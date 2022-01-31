import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryPresenter.1;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class apte
  extends aptf
  implements advu, alvk, alvy, alvz, Handler.Callback
{
  public int a;
  public adye a;
  private alvq jdField_a_of_type_Alvq;
  private alvv jdField_a_of_type_Alvv;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public apss a;
  private apsx jdField_a_of_type_Apsx;
  public apug a;
  private auwv jdField_a_of_type_Auwv;
  private auwy jdField_a_of_type_Auwy;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Integer, AIOGalleryBasePresenter> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 30000;
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Apss.a();
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    } while (localObject == null);
    int i;
    if ((localObject instanceof AIOShortVideoData))
    {
      localObject = (AIOShortVideoData)localObject;
      if (((AIOShortVideoData)localObject).d == 0) {
        if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString))) {
          i = 2;
        }
      }
    }
    for (;;)
    {
      return i;
      if ("0X8009AA6".equals(paramString))
      {
        i = 1;
        continue;
        if (((AIOShortVideoData)localObject).d == 1)
        {
          if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString)))
          {
            i = 1;
            continue;
          }
          if ("0X8009AA6".equals(paramString))
          {
            i = 1;
            continue;
            if ((!(localObject instanceof AIOFileVideoData)) || ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))) {
              break;
            }
            return 3;
          }
        }
      }
      i = -1;
    }
  }
  
  private void a(alvq paramalvq)
  {
    this.jdField_a_of_type_Alvq = paramalvq;
  }
  
  private int b()
  {
    Object localObject = this.jdField_a_of_type_Apss.a();
    if (localObject == null) {
      return -1;
    }
    localObject = ((apsr)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
    int i;
    if (localObject != null) {
      if ((localObject instanceof AIOFilePicData)) {
        i = 2;
      }
    }
    for (;;)
    {
      return i;
      if ((localObject instanceof AIOPicData))
      {
        if (!((AIOPicData)localObject).k) {
          i = 1;
        } else {
          i = 5;
        }
      }
      else
      {
        if ((localObject instanceof AIOShortVideoData))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).d == 0)
          {
            i = 4;
            continue;
          }
          if (((AIOShortVideoData)localObject).d == 1) {
            i = 3;
          }
        }
        else if ((localObject instanceof AIOFileVideoData))
        {
          i = 5;
          continue;
        }
        i = -1;
      }
    }
  }
  
  private int b(String paramString)
  {
    switch (this.jdField_a_of_type_Apsx.c())
    {
    }
    do
    {
      do
      {
        do
        {
          return -1;
          return 1;
          if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
            return 4;
          }
        } while (!"0X8009EFD".equals(paramString));
        return -1;
        if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
          return 5;
        }
        if ("0X8009EFD".equals(paramString)) {
          return 4;
        }
      } while (!"0X800A882".equals(paramString));
      return 2;
      if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
        return 6;
      }
    } while (!"0X8009EFD".equals(paramString));
    return 5;
  }
  
  private int c()
  {
    switch (this.jdField_a_of_type_Apsx.a())
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  private void x()
  {
    alvi.a();
    alvi.a().a(this);
    a(alvi.a());
    if (this.jdField_a_of_type_Alvv != null)
    {
      this.jdField_a_of_type_Alvv.a(this);
      this.jdField_a_of_type_Alvv.a(this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidViewTextureView);
      this.jdField_a_of_type_Alvv.a();
    }
  }
  
  private void y()
  {
    if ((b(a())) && (this.jdField_a_of_type_Apss != null) && (this.jdField_a_of_type_Apss.a(a()) != null))
    {
      apsr localapsr = this.jdField_a_of_type_Apss.a(a());
      if (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        alvi.a().a(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d, Long.valueOf(this.jdField_a_of_type_Apsx.a()).longValue(), localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a());
        c(this.b);
        return;
      }
      catch (Exception localException)
      {
        apsm.a().a().b("AIOGalleryPresenter", 2, "getDanmakuList is exception = " + localException.getMessage());
        return;
      }
    }
    apsm.a().a().b("AIOGalleryPresenter", 2, "getDanmakuList return");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Apss != null) {
      return this.jdField_a_of_type_Apss.b();
    }
    return -1;
  }
  
  public int a(long paramLong)
  {
    List localList = this.jdField_a_of_type_Apss.a();
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        if (((apsr)localList.get(i)).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a == paramLong) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public long a()
  {
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = a();
    if (localAIOGalleryBasePresenter != null) {
      return localAIOGalleryBasePresenter.a();
    }
    return 0L;
  }
  
  public alvv a()
  {
    return this.jdField_a_of_type_Alvv;
  }
  
  public apsx a()
  {
    return this.jdField_a_of_type_Apsx;
  }
  
  public auwv a()
  {
    if (this.jdField_a_of_type_Auwv == null) {
      this.jdField_a_of_type_Auwv = new auwv(this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Auwv;
  }
  
  public auwy a()
  {
    if (this.jdField_a_of_type_Auwy == null) {
      this.jdField_a_of_type_Auwy = new auwy(this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Auwy;
  }
  
  public AIOGalleryBasePresenter a()
  {
    if (this.jdField_a_of_type_Apss != null)
    {
      apsr localapsr = this.jdField_a_of_type_Apss.a(a());
      if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
        return (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a()));
      }
    }
    return null;
  }
  
  public AIOGalleryBasePresenter a(int paramInt)
  {
    return (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(long paramLong)
  {
    apsr localapsr;
    if ((this.jdField_a_of_type_Apug != null) && (this.jdField_a_of_type_Apug.jdField_a_of_type_Apud != null))
    {
      localapsr = this.jdField_a_of_type_Apss.a();
      if ((localapsr == null) || (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (this.jdField_a_of_type_Apsx == null)) {
        apsm.a().a().b("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((this.jdField_a_of_type_Apsx.c()) && (this.jdField_a_of_type_Apsx.a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Adye != null) && (!bool)) {
        this.jdField_a_of_type_Adye.a(paramLong);
      }
      if (!bool)
      {
        AIOGalleryBasePresenter localAIOGalleryBasePresenter = (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a()));
        if (localAIOGalleryBasePresenter != null)
        {
          int i = a(paramLong);
          if (i >= 0) {
            localAIOGalleryBasePresenter.c(i);
          }
        }
      }
      if (this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
      this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryPresenter.1(this, paramLong, localapsr, bool));
      return;
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 1) || (paramInt2 == 256)) {
      if ((paramInt2 != 18) && (paramInt2 != 20)) {
        break label109;
      }
    }
    label109:
    for (int i = this.jdField_a_of_type_Apss.a(paramLong1);; i = this.jdField_a_of_type_Apss.a(paramLong1, paramInt1))
    {
      AIOGalleryBasePresenter localAIOGalleryBasePresenter = (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
      if (localAIOGalleryBasePresenter != null) {
        localAIOGalleryBasePresenter.a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 256) || (paramInt2 == 1) || (paramInt2 == 0) || (paramInt2 == 269484034)) {
      if ((paramInt2 != 18) && (paramInt2 != 20) && (paramInt2 != 269484034)) {
        break label130;
      }
    }
    label130:
    for (int i = this.jdField_a_of_type_Apss.a(paramLong);; i = this.jdField_a_of_type_Apss.a(paramLong, paramInt1))
    {
      AIOGalleryBasePresenter localAIOGalleryBasePresenter = (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
      if (localAIOGalleryBasePresenter != null) {
        localAIOGalleryBasePresenter.a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    int i = this.jdField_a_of_type_Apss.a(paramLong, paramInt1);
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (localAIOGalleryBasePresenter != null) {
      localAIOGalleryBasePresenter.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    ShortVideoUtils.a(null, c(), paramString, 2, a("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.b = (paramInt * 1000);
    }
    if ((!this.jdField_a_of_type_Boolean) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = a();
      if ((paramString != null) && (this.jdField_a_of_type_Alvv != null))
      {
        apsm.a().a().b("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        paramString.aH_();
        this.jdField_a_of_type_Alvv.a(null);
      }
    }
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      paramString = a();
      if ((paramString != null) && (this.jdField_a_of_type_Alvv != null))
      {
        paramString = paramString.a(paramLong, paramList);
        this.jdField_a_of_type_Alvv.a(paramString);
      }
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((badq.a()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_Alvv != null)) {
      this.jdField_a_of_type_Alvv.a(paramDanmuItemBean);
    }
  }
  
  public void a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    this.jdField_a_of_type_Apsx = new apsx(paramIntent);
    paramIntent = new apsr(aptt.a((AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE")));
    paramIntent.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    if (this.jdField_a_of_type_Apss.a(paramIntent))
    {
      this.jdField_a_of_type_Apss.c(paramIntent);
      if (localBundle.getBoolean("muate_play")) {
        this.jdField_a_of_type_Apss.d(paramIntent);
      }
    }
    this.jdField_a_of_type_Apss.b(paramIntent);
    if (this.jdField_a_of_type_Apsx.f()) {
      this.jdField_a_of_type_Apss.a(true);
    }
    advs.a().a(this);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.a(paramConfiguration);
    }
  }
  
  public void a(apss paramapss)
  {
    this.jdField_a_of_type_Apss = paramapss;
    super.a(paramapss);
  }
  
  public void a(apug paramapug)
  {
    this.jdField_a_of_type_Apug = paramapug;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Alvv != null) && (this.jdField_a_of_type_Alvv.a()) && (this.jdField_a_of_type_Apug != null))
    {
      this.jdField_a_of_type_Alvv.d();
      this.jdField_a_of_type_Apug.c(paramBoolean);
    }
  }
  
  public void a(GalleryBaseData[] paramArrayOfGalleryBaseData, int paramInt)
  {
    apsm.a().a().b("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + paramArrayOfGalleryBaseData.length + ", selected " + paramInt);
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.m();
    }
  }
  
  public boolean a()
  {
    return (alvr.e()) && (this.jdField_a_of_type_Apsx.a() == 1);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Apss != null)
    {
      apsr localapsr = this.jdField_a_of_type_Apss.a(paramInt);
      bool1 = bool2;
      if (localapsr != null)
      {
        bool1 = bool2;
        if (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) {
          if ((localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 2) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3))
          {
            bool1 = bool2;
            if (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 4) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Apug != null) {
      return this.jdField_a_of_type_Apug.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Apss != null)
    {
      apsr localapsr = this.jdField_a_of_type_Apss.a(a());
      bool1 = bool2;
      if (localapsr != null)
      {
        bool1 = bool2;
        if (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)
        {
          bool1 = bool2;
          if (paramLong == localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public void aL_()
  {
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.o();
    }
  }
  
  public void aM_()
  {
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.i();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      AIOGalleryBasePresenter localAIOGalleryBasePresenter = a();
      if ((localAIOGalleryBasePresenter != null) && (this.jdField_a_of_type_Alvv != null))
      {
        apsm.a().a().b("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        localAIOGalleryBasePresenter.aH_();
        this.jdField_a_of_type_Alvv.a(null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      apsg localapsg = new apsg(this.jdField_a_of_type_Apug.b, paramInt);
      localapsg.a(this);
      new apsh(localapsg).a(this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidContentIntent);
      if ((localapsg.a() instanceof AIOGalleryBasePresenter))
      {
        ((AIOGalleryBasePresenter)localapsg.a()).a(this);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), (AIOGalleryBasePresenter)localapsg.a());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      awqx.b(null, "dc00898", "", "", "0X800A99B", "0X800A99B", 1, 0, "" + a("0X800A99B"), "", "", "");
      return;
    }
    awqx.b(null, "dc00898", "", "", "0X800A99B", "0X800A99B", 2, 0, "" + a("0X800A99B"), "", "", "");
  }
  
  public boolean b()
  {
    if (!alvr.e()) {}
    apsr localapsr;
    do
    {
      return false;
      localapsr = this.jdField_a_of_type_Apss.a(a());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldShowDanmakuBtn, paramsManager.isFromMultiMsg() = ").append(this.jdField_a_of_type_Apsx.c());
        localStringBuilder.append(" , paramsManager.getmCurType() = ").append(this.jdField_a_of_type_Apsx.a());
        localStringBuilder.append(" , paramsManager.getSourceEntrance() = ").append(this.jdField_a_of_type_Apsx.c());
        localStringBuilder.append(" , paramsManager.isReplyMsgFromSameSession() = ").append(this.jdField_a_of_type_Apsx.h());
        localStringBuilder.append(" , paramsManager.isMixedMsg = ").append(this.jdField_a_of_type_Apsx.b);
        localStringBuilder.append(" , paramsManager.isReplySrcMsgExist = ").append(this.jdField_a_of_type_Apsx.c);
        if ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
          localStringBuilder.append(", galleryInfo.mData.isInMixedMsg = ").append(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.b).append(" isMsgSeqReady = ").append(localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.c);
        }
        QLog.d("AIOGalleryPresenter", 2, localStringBuilder.toString());
      }
    } while ((this.jdField_a_of_type_Apsx.c()) || (this.jdField_a_of_type_Apsx.a() != 1) || (this.jdField_a_of_type_Apsx.c() == 4) || (!this.jdField_a_of_type_Apsx.h()) || (!this.jdField_a_of_type_Apsx.c) || ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.b)) || ((localapsr != null) && (localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (!localapsr.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.c)));
    return true;
  }
  
  public boolean b(int paramInt)
  {
    return (b()) && (a(paramInt));
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    int i = a("0X800A9B5");
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      awqx.b(null, "dc00898", "", "", "0X800A9B5", "0X800A9B5", i, 0, str, "", "", "");
      return;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Apug != null) {
      return this.jdField_a_of_type_Apug.c();
    }
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((ajms)((PeakAppInterface)localAppRuntime).a(2)).a(this.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity);
      }
    }
    if (a())
    {
      this.jdField_a_of_type_Alvv = new alvv();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      x();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Apug != null) && (b(a())))
    {
      AIOGalleryBasePresenter localAIOGalleryBasePresenter = a();
      if ((localAIOGalleryBasePresenter != null) && (this.jdField_a_of_type_Alvv != null))
      {
        localAIOGalleryBasePresenter.b();
        this.jdField_a_of_type_Alvv.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    c(0);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Alvv != null) && (!this.jdField_a_of_type_Alvv.a()) && (this.jdField_a_of_type_Apug != null))
    {
      this.jdField_a_of_type_Alvv.e();
      this.jdField_a_of_type_Apug.c(true);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Adye != null) && (!this.jdField_a_of_type_Apsx.e())) {
      this.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Apsx.b());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      y();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.j();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.n();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    alvi.a().b(this);
    if (this.jdField_a_of_type_Alvv != null) {
      this.jdField_a_of_type_Alvv.b();
    }
    if (this.jdField_a_of_type_Alvq != null) {
      this.jdField_a_of_type_Alvq.b();
    }
    if (this.jdField_a_of_type_Apug != null) {
      this.jdField_a_of_type_Apug.k();
    }
    advs.a().b(this);
    if (this.jdField_a_of_type_Auwv != null)
    {
      this.jdField_a_of_type_Auwv.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Auwv.a();
    }
    if (this.jdField_a_of_type_Auwy != null) {
      this.jdField_a_of_type_Auwy.a();
    }
  }
  
  public void m()
  {
    awqx.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", b(), 0, "" + c(), "" + b("0X8009EFD"), "", "");
  }
  
  public void n()
  {
    awqx.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", b(), 0, "" + c(), "" + b("0X8009EFC"), "", "");
  }
  
  public void o()
  {
    awqx.b(null, "dc00898", "", "", "0X800A418", "0X800A418", b(), 0, "" + c(), "" + b("0X800A418"), "", "");
  }
  
  public void p()
  {
    awqx.b(null, "dc00898", "", "", "0X800A419", "0X800A419", b(), 0, "" + c(), "" + b("0X800A419"), "", "");
  }
  
  public void q()
  {
    awqx.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", b(), 0, "" + c(), "" + b("0X800A41A"), "", "");
  }
  
  public void r()
  {
    awqx.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", b(), 0, "" + c(), "" + b("0X800A41B"), "", "");
  }
  
  public void s()
  {
    awqx.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", b(), 0, "" + c(), "" + b("0X800A41C"), "", "");
  }
  
  public void t()
  {
    awqx.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", b(), 0, "" + c(), "" + b("0X800A41D"), "", "");
  }
  
  public void u()
  {
    awqx.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", b(), 0, "" + c(), "" + b("0X8009EFC"), "", "");
  }
  
  public void v()
  {
    awqx.b(null, "dc00898", "", "", "0X800A882", "0X800A882", b(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void w()
  {
    awqx.b(null, "dc00898", "", "", "0X800A9B4", "0X800A9B4", b(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apte
 * JD-Core Version:    0.7.0.1
 */