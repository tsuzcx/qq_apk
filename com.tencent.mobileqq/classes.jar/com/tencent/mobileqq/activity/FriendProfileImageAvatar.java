package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.os.MqqHandler;

public class FriendProfileImageAvatar
  extends FriendProfileImageModel
  implements Handler.Callback, HttpDownloadUtil.HttpDownloadListener
{
  URL a;
  MqqHandler b;
  boolean c;
  String d;
  int e;
  boolean f = false;
  boolean g = false;
  private boolean m = false;
  private AvatarObserver n = new FriendProfileImageAvatar.2(this);
  private GPServiceObserver o = new FriendProfileImageAvatar.3(this);
  
  public FriendProfileImageAvatar(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = null;
    this.c = false;
    this.b = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public FriendProfileImageAvatar(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramQQAppInterface);
    this.m = paramBoolean;
    this.a = null;
    this.c = false;
    this.b = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(GuildUserAvatar paramGuildUserAvatar, String paramString)
  {
    if (paramGuildUserAvatar == null) {
      return;
    }
    if (!this.h.equals(paramString)) {
      return;
    }
    String str = ((IGPSService)this.l.getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, 2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, new Object[] { "onGetHeadInfo: tinyId=", paramString, ",uin:", paramString });
    }
    if ((this.c) && (!TextUtils.isEmpty(str))) {
      a(paramString, (byte)paramGuildUserAvatar.b(), str);
    }
  }
  
  private void b(String paramString)
  {
    if (this.m)
    {
      a(((IGPSService)this.l.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrl(paramString), paramString);
      return;
    }
    this.l.refreshFace(paramString);
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 0) {
      i = 0;
    }
    this.j = i;
    this.k = b(i);
    if (this.k != null)
    {
      a(this.k, true);
      c(this.k);
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.k = paramProfileImageInfo;
  }
  
  void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, boolean paramBoolean)
  {
    int i = paramProfileImageInfo.d;
    if ((paramBoolean) && (!this.c) && ((paramProfileImageInfo.d == 0) || (paramProfileImageInfo.d == 3)))
    {
      this.c = true;
      ThreadManager.postImmediately(new FriendProfileImageAvatar.1(this, paramProfileImageInfo), null, false);
    }
    Object localObject;
    if (paramProfileImageInfo.d == 0)
    {
      paramProfileImageInfo.d = 1;
    }
    else if ((!paramBoolean) && (paramProfileImageInfo.d == 3))
    {
      paramProfileImageInfo.d = 4;
      localObject = this.b;
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessageDelayed(4, 400L);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load: uin=");
      ((StringBuilder)localObject).append(paramProfileImageInfo.g);
      ((StringBuilder)localObject).append(",state=");
      ((StringBuilder)localObject).append(paramProfileImageInfo.d);
      ((StringBuilder)localObject).append(", bState=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", bGetHeadInfo=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", isFromClickEvent=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (this.m) {
      ((IGPSService)this.l.getRuntimeService(IGPSService.class, "")).addObserver(this.o);
    } else {
      paramBaseActivity.removeObserver(this.n);
    }
    paramBaseActivity = this.b;
    if (paramBaseActivity != null) {
      paramBaseActivity.removeCallbacksAndMessages(null);
    }
    this.b = null;
  }
  
  public void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    paramProfileImageInfo.a = null;
    paramProfileImageInfo.b = this.l.getCustomFaceFilePath(false, this.h);
    paramProfileImageInfo.c = FaceUtil.c(this.h);
    b(paramProfileImageInfo);
    this.k = paramProfileImageInfo;
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar", new Object[] { paramString });
    }
    if (this.g)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.4(this, paramString), 5, null, true);
  }
  
  void a(String paramString1, byte paramByte, String paramString2)
  {
    this.c = false;
    this.k.f = true;
    c(this.k);
    if (this.f)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.5(this, paramString1, paramByte, paramString2), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHttpStart() url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if ((localObject != null) && (((URL)localObject).toString().equals(paramString)))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt;
      localObject = this.b;
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((URL)localObject).toString().equals(paramString)))
    {
      paramString = this.b;
      if ((paramString != null) && (paramString.hasMessages(1))) {
        this.b.removeMessages(1);
      }
      paramString = Message.obtain();
      paramString.what = 1;
      paramString.arg1 = ((int)((float)paramLong2 / (float)paramLong1 * 100.0F));
      localObject = this.b;
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(paramString);
      }
    }
  }
  
  public Drawable b()
  {
    if ((this.l != null) && (this.k != null) && (!TextUtils.isEmpty(this.k.g))) {
      return FaceDrawable.getFaceDrawable(this.l, 1, this.k.g);
    }
    return null;
  }
  
  public FriendProfileImageModel.ProfileImageInfo b(int paramInt)
  {
    return this.k;
  }
  
  void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    try
    {
      int i = paramProfileImageInfo.d;
      if (FileUtil.d(paramProfileImageInfo.c))
      {
        paramProfileImageInfo.d = 6;
        paramProfileImageInfo.f = false;
        if (this.b != null) {
          this.b.removeMessages(4);
        }
      }
      else if (FileUtil.d(paramProfileImageInfo.b))
      {
        paramProfileImageInfo.d = 3;
      }
      else
      {
        paramProfileImageInfo.d = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateState: uin=");
        localStringBuilder.append(paramProfileImageInfo.g);
        localStringBuilder.append(",state=");
        localStringBuilder.append(paramProfileImageInfo.d);
        localStringBuilder.append(", beforeState=");
        localStringBuilder.append(i);
        QLog.d("Q.profilecard.Avatar", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    if (this.m)
    {
      ((IGPSService)this.l.getRuntimeService(IGPSService.class, "")).addObserver(this.o);
      return;
    }
    paramBaseActivity.addObserver(this.n);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        localObject = null;
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("MSG_DOWNLOAD_HD_AVATAR ");
              localStringBuilder.append(paramMessage.obj);
              QLog.i("Q.profilecard.Avatar", 2, localStringBuilder.toString());
            }
            if ((paramMessage.obj instanceof Setting)) {
              localObject = (Setting)paramMessage.obj;
            }
            if ((localObject != null) && (!((Setting)localObject).url.equals(this.d)))
            {
              this.d = ((Setting)localObject).url;
              a(((Setting)localObject).uin, ((Setting)localObject).bFaceFlags, ((Setting)localObject).url);
              return true;
            }
            if (QLog.isColorLevel())
            {
              paramMessage = new StringBuilder();
              paramMessage.append("MSG_DOWNLOAD_HD_AVATAR | has download path = ");
              paramMessage.append(this.d);
              QLog.i("Q.profilecard.Avatar", 2, paramMessage.toString());
              return true;
            }
          }
          else
          {
            a(this.h);
            return true;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("end result : ");
            ((StringBuilder)localObject).append(paramMessage.arg1);
            QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
          }
          this.k.e = 100;
          this.k.f = false;
          b(this.k);
          if (paramMessage.arg1 == 1)
          {
            c(this.k);
            return true;
          }
          this.k.d = 5;
          c(this.k);
          i = this.e;
          if (i < 3)
          {
            this.e = (i + 1);
            this.d = null;
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start progress : ");
          ((StringBuilder)localObject).append(paramMessage.arg1);
          QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
        }
        this.k.e = 0;
        c(this.k);
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh progress : ");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
      }
      this.k.e = paramMessage.arg1;
      c(this.k);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar
 * JD-Core Version:    0.7.0.1
 */