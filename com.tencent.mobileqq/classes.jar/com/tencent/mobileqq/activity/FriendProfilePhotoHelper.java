package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.CardTransProcessorHandler;
import com.tencent.mobileqq.app.CardHandler.CoverTransCallback;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class FriendProfilePhotoHelper
  implements CardHandler.CoverTransCallback
{
  public static final String a = "FriendProfilePhotoHelper";
  public QQAppInterface b;
  public final QBaseActivity c;
  public Uri d;
  public QQProgressDialog e;
  public WeakReferenceHandler f;
  public CardHandler.CardTransProcessorHandler g;
  public FriendProfilePhotoHelper.ProfilePhotoCallback h;
  public boolean i = false;
  public byte[] j = null;
  public String k;
  public int l = 0;
  public Runnable m = new FriendProfilePhotoHelper.2(this);
  Handler.Callback n = new FriendProfilePhotoHelper.3(this);
  
  public FriendProfilePhotoHelper(QBaseActivity paramQBaseActivity, FriendProfilePhotoHelper.ProfilePhotoCallback paramProfilePhotoCallback)
  {
    this.c = paramQBaseActivity;
    this.b = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.h = paramProfilePhotoCallback;
    this.f = new WeakReferenceHandler(Looper.getMainLooper(), this.n);
    paramQBaseActivity = (CardHandler)this.b.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramQBaseActivity != null) {
      this.g = paramQBaseActivity.a(this.b, this);
    }
  }
  
  public void a()
  {
    if (this.g != null)
    {
      ((CardHandler)this.b.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.g);
      this.g = null;
    }
    this.i = false;
    this.j = null;
    this.k = "";
    this.l = 0;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, String.format("onSendFailed resultCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    this.f.removeCallbacks(this.m);
    c();
    int i1 = 2131917777;
    if (paramInt == 1503) {
      i1 = 2131897181;
    }
    this.h.notifyUser(i1, 1);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.h.notifyUser(2131892157, 1);
      return;
    }
    if (paramIntent == null) {
      return;
    }
    int i1 = paramIntent.getIntExtra("req_code_key", 0);
    if (i1 == 1025)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        CardHandler localCardHandler = (CardHandler)this.b.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
        {
          localCardHandler.a((String)localArrayList.get(0));
          b();
          this.f.postDelayed(this.m, 30000L);
          return;
        }
        localCardHandler.a(localArrayList);
        b();
      }
    }
    else if (i1 == 1020)
    {
      if ((paramInt == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramIntent)) {
          a(paramIntent);
        }
      }
    }
    else if (i1 == 1021)
    {
      if (paramInt == -1)
      {
        this.d = ((Uri)paramIntent.getParcelableExtra("upload_uri_key"));
        a(ImageUtil.b(this.c, this.d));
      }
    }
    else if ((i1 == 2002) && (paramInt == -1))
    {
      paramIntent = ProfileCardManager.b(paramIntent.getStringExtra("card_url_key"));
      this.h.updateCover(paramIntent);
    }
  }
  
  public void a(Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
    {
      b(paramArrayList);
      return;
    }
    a(paramArrayList);
  }
  
  public void a(Card paramCard)
  {
    if (paramCard != null)
    {
      paramCard = paramCard.getCoverData(this.l);
      String str = (String)paramCard[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.k)))
      {
        this.k = str;
        this.l = ((Integer)paramCard[1]).intValue();
      }
    }
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("action_cover_pick_gallery", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    QBaseActivity localQBaseActivity = this.c;
    PhotoUtils.startPhotoEdit(localIntent, localQBaseActivity, localQBaseActivity.getClass().getName(), ProfileCardUtil.c(this.c), ProfileCardUtil.d(this.c), ProfileCardUtil.c(this.c), ProfileCardUtil.d(this.c), paramString, ProfileCardUtil.b());
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.h.notifyUser(2131892157, 1);
      return;
    }
    ((CardHandler)this.b.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramArrayList);
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_default_key", paramBoolean);
    PublicFragmentActivity.Launcher.a(this.c, localIntent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.j = paramArrayOfByte;
    this.i = true;
    ThreadManager.excute(new FriendProfilePhotoHelper.1(this), 16, null, false);
  }
  
  protected void b()
  {
    try
    {
      if (!this.c.isFinishing())
      {
        this.e = new QQProgressDialog(this.c, this.c.getTitleBarHeight());
        this.e.setCancelable(false);
        this.e.c(2131887775);
        this.e.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.h.notifyUser(2131892157, 1);
      return;
    }
    ((CardHandler)this.b.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((String)paramArrayList.get(0));
    b();
    this.f.postDelayed(this.m, 30000L);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.f.removeCallbacks(this.m);
    c();
    this.h.notifyUser(2131917776, 2);
    if (paramArrayOfByte != null)
    {
      Object localObject3 = ByteBuffer.wrap(paramArrayOfByte);
      int i2 = ((ByteBuffer)localObject3).get();
      if (i2 != 0)
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("error retCode:");
          ((StringBuilder)localObject1).append(i2);
          QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      Object localObject1 = new byte[4];
      Object localObject2 = new byte[4];
      int i3 = 0;
      i2 = 0;
      while (i2 < 4)
      {
        int i1 = ((ByteBuffer)localObject3).get();
        localObject1[i2] = i1;
        localObject2[(3 - i2)] = i1;
        i2 += 1;
      }
      int i4 = (int)HummerParser.a((byte[])localObject1);
      if (i4 <= paramArrayOfByte.length - 5)
      {
        i2 = i4;
        if (i4 >= 0) {}
      }
      else
      {
        i2 = (int)HummerParser.a((byte[])localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("len:");
        localStringBuilder.append(i2);
        localStringBuilder.append(" bLength:");
        localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject1));
        localStringBuilder.append(" bFlipLength:");
        localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject2));
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
      if ((i2 <= paramArrayOfByte.length - 5) && (i2 >= 0))
      {
        localObject1 = new byte[i2];
        while (i3 < i2)
        {
          localObject1[i3] = paramArrayOfByte[(i3 + 5)];
          i3 += 1;
        }
        this.h.onUploadResult((byte[])localObject1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("长度超出! len:");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append(" extraInfo.length:");
        ((StringBuilder)localObject2).append(paramArrayOfByte.length);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "send finish extraInfo is null");
    }
    this.h.onUploadResult(null);
  }
  
  protected void c()
  {
    QQProgressDialog localQQProgressDialog = this.e;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.e.dismiss();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePhotoHelper
 * JD-Core Version:    0.7.0.1
 */