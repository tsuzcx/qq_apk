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

public class aqnf
  extends aqng
  implements aegr, amkz, amln, amlo, Handler.Callback
{
  public int a;
  public aejb a;
  private amlf jdField_a_of_type_Amlf;
  private amlk jdField_a_of_type_Amlk;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public aqmj a;
  private aqmo jdField_a_of_type_Aqmo;
  public aqoi a;
  private avwo jdField_a_of_type_Avwo;
  private avwr jdField_a_of_type_Avwr;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Integer, AIOGalleryBasePresenter> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 30000;
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Aqmj.a();
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
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
  
  private void a(amlf paramamlf)
  {
    this.jdField_a_of_type_Amlf = paramamlf;
  }
  
  private int b()
  {
    Object localObject = this.jdField_a_of_type_Aqmj.a();
    if (localObject == null) {
      return -1;
    }
    localObject = ((aqmi)localObject).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData;
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
    switch (this.jdField_a_of_type_Aqmo.c())
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
    switch (this.jdField_a_of_type_Aqmo.a())
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
    amkx.a();
    amkx.a().a(this);
    a(amkx.a());
    if (this.jdField_a_of_type_Amlk != null)
    {
      this.jdField_a_of_type_Amlk.a(this);
      this.jdField_a_of_type_Amlk.a(this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidViewTextureView);
      this.jdField_a_of_type_Amlk.a();
    }
  }
  
  private void y()
  {
    if ((b(a())) && (this.jdField_a_of_type_Aqmj != null) && (this.jdField_a_of_type_Aqmj.a(a()) != null))
    {
      aqmi localaqmi = this.jdField_a_of_type_Aqmj.a(a());
      if (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        amkx.a().a(localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d, Long.valueOf(this.jdField_a_of_type_Aqmo.a()).longValue(), localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a());
        c(this.b);
        return;
      }
      catch (Exception localException)
      {
        aqmd.a().a().b("AIOGalleryPresenter", 2, "getDanmakuList is exception = " + localException.getMessage());
        return;
      }
    }
    aqmd.a().a().b("AIOGalleryPresenter", 2, "getDanmakuList return");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aqmj != null) {
      return this.jdField_a_of_type_Aqmj.b();
    }
    return -1;
  }
  
  public int a(long paramLong)
  {
    List localList = this.jdField_a_of_type_Aqmj.a();
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        if (((aqmi)localList.get(i)).jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a == paramLong) {
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
  
  public amlk a()
  {
    return this.jdField_a_of_type_Amlk;
  }
  
  public aqmo a()
  {
    return this.jdField_a_of_type_Aqmo;
  }
  
  public avwo a()
  {
    if (this.jdField_a_of_type_Avwo == null) {
      this.jdField_a_of_type_Avwo = new avwo(this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Avwo;
  }
  
  public avwr a()
  {
    if (this.jdField_a_of_type_Avwr == null) {
      this.jdField_a_of_type_Avwr = new avwr(this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity);
    }
    return this.jdField_a_of_type_Avwr;
  }
  
  public AIOGalleryBasePresenter a()
  {
    if (this.jdField_a_of_type_Aqmj != null)
    {
      aqmi localaqmi = this.jdField_a_of_type_Aqmj.a(a());
      if ((localaqmi != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
        return (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a()));
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
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(long paramLong)
  {
    aqmi localaqmi;
    if ((this.jdField_a_of_type_Aqoi != null) && (this.jdField_a_of_type_Aqoi.jdField_a_of_type_Aqof != null))
    {
      localaqmi = this.jdField_a_of_type_Aqmj.a();
      if ((localaqmi == null) || (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData == null) || (this.jdField_a_of_type_Aqmo == null)) {
        aqmd.a().a().b("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((this.jdField_a_of_type_Aqmo.c()) && (this.jdField_a_of_type_Aqmo.a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Aejb != null) && (!bool)) {
        this.jdField_a_of_type_Aejb.a(paramLong);
      }
      if (!bool)
      {
        AIOGalleryBasePresenter localAIOGalleryBasePresenter = (AIOGalleryBasePresenter)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a()));
        if (localAIOGalleryBasePresenter != null)
        {
          int i = a(paramLong);
          if (i >= 0) {
            localAIOGalleryBasePresenter.c(i);
          }
        }
      }
      if (this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
      this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryPresenter.1(this, paramLong, localaqmi, bool));
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
    for (int i = this.jdField_a_of_type_Aqmj.a(paramLong1);; i = this.jdField_a_of_type_Aqmj.a(paramLong1, paramInt1))
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
    for (int i = this.jdField_a_of_type_Aqmj.a(paramLong);; i = this.jdField_a_of_type_Aqmj.a(paramLong, paramInt1))
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
    int i = this.jdField_a_of_type_Aqmj.a(paramLong, paramInt1);
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
      if ((paramString != null) && (this.jdField_a_of_type_Amlk != null))
      {
        aqmd.a().a().b("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        paramString.aE_();
        this.jdField_a_of_type_Amlk.a(null);
      }
    }
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      paramString = a();
      if ((paramString != null) && (this.jdField_a_of_type_Amlk != null))
      {
        paramString = paramString.a(paramLong, paramList);
        this.jdField_a_of_type_Amlk.a(paramString);
      }
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((bbfj.a()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_Amlk != null)) {
      this.jdField_a_of_type_Amlk.a(paramDanmuItemBean);
    }
  }
  
  public void a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    this.jdField_a_of_type_Aqmo = new aqmo(paramIntent);
    paramIntent = new aqmi(aqnv.a((AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE")));
    paramIntent.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    if (this.jdField_a_of_type_Aqmj.a(paramIntent))
    {
      this.jdField_a_of_type_Aqmj.c(paramIntent);
      if (localBundle.getBoolean("muate_play")) {
        this.jdField_a_of_type_Aqmj.d(paramIntent);
      }
    }
    this.jdField_a_of_type_Aqmj.b(paramIntent);
    if (this.jdField_a_of_type_Aqmo.f()) {
      this.jdField_a_of_type_Aqmj.a(true);
    }
    aegp.a().a(this);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.a(paramConfiguration);
    }
  }
  
  public void a(aqmj paramaqmj)
  {
    this.jdField_a_of_type_Aqmj = paramaqmj;
    super.a(paramaqmj);
  }
  
  public void a(aqoi paramaqoi)
  {
    this.jdField_a_of_type_Aqoi = paramaqoi;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Amlk != null) && (this.jdField_a_of_type_Amlk.a()) && (this.jdField_a_of_type_Aqoi != null))
    {
      this.jdField_a_of_type_Amlk.d();
      this.jdField_a_of_type_Aqoi.c(paramBoolean);
    }
  }
  
  public void a(GalleryBaseData[] paramArrayOfGalleryBaseData, int paramInt)
  {
    aqmd.a().a().b("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + paramArrayOfGalleryBaseData.length + ", selected " + paramInt);
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.m();
    }
  }
  
  public boolean a()
  {
    return (amlg.e()) && (this.jdField_a_of_type_Aqmo.a() == 1);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aqmj != null)
    {
      aqmi localaqmi = this.jdField_a_of_type_Aqmj.a(paramInt);
      bool1 = bool2;
      if (localaqmi != null)
      {
        bool1 = bool2;
        if (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) {
          if ((localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 1) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 2) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 3))
          {
            bool1 = bool2;
            if (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.a() != 4) {}
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
    if (this.jdField_a_of_type_Aqoi != null) {
      return this.jdField_a_of_type_Aqoi.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aqmj != null)
    {
      aqmi localaqmi = this.jdField_a_of_type_Aqmj.a(a());
      bool1 = bool2;
      if (localaqmi != null)
      {
        bool1 = bool2;
        if (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)
        {
          bool1 = bool2;
          if (paramLong == localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.d) {
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
  
  public void aI_()
  {
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.o();
    }
  }
  
  public void aJ_()
  {
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.i();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      AIOGalleryBasePresenter localAIOGalleryBasePresenter = a();
      if ((localAIOGalleryBasePresenter != null) && (this.jdField_a_of_type_Amlk != null))
      {
        aqmd.a().a().b("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        localAIOGalleryBasePresenter.aE_();
        this.jdField_a_of_type_Amlk.a(null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      aqlx localaqlx = new aqlx(this.jdField_a_of_type_Aqoi.b, paramInt);
      localaqlx.a(this);
      new aqly(localaqlx).a(this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidContentIntent);
      if ((localaqlx.a() instanceof AIOGalleryBasePresenter))
      {
        ((AIOGalleryBasePresenter)localaqlx.a()).a(this);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), (AIOGalleryBasePresenter)localaqlx.a());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      axqy.b(null, "dc00898", "", "", "0X800A99B", "0X800A99B", 1, 0, "" + a("0X800A99B"), "", "", "");
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X800A99B", "0X800A99B", 2, 0, "" + a("0X800A99B"), "", "", "");
  }
  
  public boolean b()
  {
    if (!amlg.e()) {}
    aqmi localaqmi;
    do
    {
      return false;
      localaqmi = this.jdField_a_of_type_Aqmj.a(a());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldShowDanmakuBtn, paramsManager.isFromMultiMsg() = ").append(this.jdField_a_of_type_Aqmo.c());
        localStringBuilder.append(" , paramsManager.getmCurType() = ").append(this.jdField_a_of_type_Aqmo.a());
        localStringBuilder.append(" , paramsManager.getSourceEntrance() = ").append(this.jdField_a_of_type_Aqmo.c());
        localStringBuilder.append(" , paramsManager.isReplyMsgFromSameSession() = ").append(this.jdField_a_of_type_Aqmo.h());
        localStringBuilder.append(" , paramsManager.isMixedMsg = ").append(this.jdField_a_of_type_Aqmo.b);
        localStringBuilder.append(" , paramsManager.isReplySrcMsgExist = ").append(this.jdField_a_of_type_Aqmo.c);
        if ((localaqmi != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null)) {
          localStringBuilder.append(", galleryInfo.mData.isInMixedMsg = ").append(localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.b).append(" isMsgSeqReady = ").append(localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.c);
        }
        QLog.d("AIOGalleryPresenter", 2, localStringBuilder.toString());
      }
    } while ((this.jdField_a_of_type_Aqmo.c()) || (this.jdField_a_of_type_Aqmo.a() != 1) || (this.jdField_a_of_type_Aqmo.c() == 4) || (!this.jdField_a_of_type_Aqmo.h()) || (!this.jdField_a_of_type_Aqmo.c) || ((localaqmi != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.b)) || ((localaqmi != null) && (localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData != null) && (!localaqmi.jdField_a_of_type_ComTencentMobileqqGalleryModelGalleryBaseData.c)));
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
      axqy.b(null, "dc00898", "", "", "0X800A9B5", "0X800A9B5", i, 0, str, "", "", "");
      return;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Aqoi != null) {
      return this.jdField_a_of_type_Aqoi.c();
    }
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((akaz)((PeakAppInterface)localAppRuntime).a(2)).a(this.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity);
      }
    }
    if (a())
    {
      this.jdField_a_of_type_Amlk = new amlk();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      x();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Aqoi != null) && (b(a())))
    {
      AIOGalleryBasePresenter localAIOGalleryBasePresenter = a();
      if ((localAIOGalleryBasePresenter != null) && (this.jdField_a_of_type_Amlk != null))
      {
        localAIOGalleryBasePresenter.b();
        this.jdField_a_of_type_Amlk.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    c(0);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Amlk != null) && (!this.jdField_a_of_type_Amlk.a()) && (this.jdField_a_of_type_Aqoi != null))
    {
      this.jdField_a_of_type_Amlk.e();
      this.jdField_a_of_type_Aqoi.c(true);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Aejb != null) && (!this.jdField_a_of_type_Aqmo.e())) {
      this.jdField_a_of_type_Aejb.a(this.jdField_a_of_type_Aqmo.b());
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
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.j();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.n();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    amkx.a().b(this);
    if (this.jdField_a_of_type_Amlk != null) {
      this.jdField_a_of_type_Amlk.b();
    }
    if (this.jdField_a_of_type_Amlf != null) {
      this.jdField_a_of_type_Amlf.b();
    }
    if (this.jdField_a_of_type_Aqoi != null) {
      this.jdField_a_of_type_Aqoi.k();
    }
    aegp.a().b(this);
    if (this.jdField_a_of_type_Avwo != null)
    {
      this.jdField_a_of_type_Avwo.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Avwo.a();
    }
    if (this.jdField_a_of_type_Avwr != null) {
      this.jdField_a_of_type_Avwr.a();
    }
  }
  
  public void m()
  {
    axqy.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", b(), 0, "" + c(), "" + b("0X8009EFD"), "", "");
  }
  
  public void n()
  {
    axqy.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", b(), 0, "" + c(), "" + b("0X8009EFC"), "", "");
  }
  
  public void o()
  {
    axqy.b(null, "dc00898", "", "", "0X800A418", "0X800A418", b(), 0, "" + c(), "" + b("0X800A418"), "", "");
  }
  
  public void p()
  {
    axqy.b(null, "dc00898", "", "", "0X800A419", "0X800A419", b(), 0, "" + c(), "" + b("0X800A419"), "", "");
  }
  
  public void q()
  {
    axqy.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", b(), 0, "" + c(), "" + b("0X800A41A"), "", "");
  }
  
  public void r()
  {
    axqy.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", b(), 0, "" + c(), "" + b("0X800A41B"), "", "");
  }
  
  public void s()
  {
    axqy.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", b(), 0, "" + c(), "" + b("0X800A41C"), "", "");
  }
  
  public void t()
  {
    axqy.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", b(), 0, "" + c(), "" + b("0X800A41D"), "", "");
  }
  
  public void u()
  {
    axqy.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", b(), 0, "" + c(), "" + b("0X8009EFC"), "", "");
  }
  
  public void v()
  {
    axqy.b(null, "dc00898", "", "", "0X800A882", "0X800A882", b(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void w()
  {
    axqy.b(null, "dc00898", "", "", "0X800A9B4", "0X800A9B4", b(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnf
 * JD-Core Version:    0.7.0.1
 */