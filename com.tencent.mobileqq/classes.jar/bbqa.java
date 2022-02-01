import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.1;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class bbqa
  extends MainBrowserPresenter
  implements ahrh, Handler.Callback, aqsg, aqsu, aqsv
{
  public int a;
  private ahtp jdField_a_of_type_Ahtp;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aqsm jdField_a_of_type_Aqsm;
  private aqsr jdField_a_of_type_Aqsr;
  private bbka jdField_a_of_type_Bbka;
  private bbkd jdField_a_of_type_Bbkd;
  public bbps a;
  public bbqz a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 30000;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_Bbps.getSelectedItem();
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int i;
    if (localObject != null) {
      if ((localObject instanceof AIOFilePictureData)) {
        i = 2;
      }
    }
    for (;;)
    {
      return i;
      if ((localObject instanceof AIOPictureData))
      {
        if (!((AIOPictureData)localObject).k) {
          i = 1;
        } else {
          i = 5;
        }
      }
      else
      {
        if ((localObject instanceof AIOVideoData))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).d == 0)
          {
            i = 4;
            continue;
          }
          if (((AIOVideoData)localObject).d == 1) {
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
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Bbps.getSelectedItem();
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((RichMediaBrowserInfo)localObject).baseData;
    } while (localObject == null);
    int i;
    if ((localObject instanceof AIOVideoData))
    {
      localObject = (AIOVideoData)localObject;
      if (((AIOVideoData)localObject).d == 0) {
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
        if (((AIOVideoData)localObject).d == 1)
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
  
  private void a(aqsm paramaqsm)
  {
    this.jdField_a_of_type_Aqsm = paramaqsm;
  }
  
  private int b()
  {
    switch (bbph.a().a())
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
  
  private int b(String paramString)
  {
    switch (bbph.a().c())
    {
    }
    do
    {
      return -1;
      return 1;
      return c(paramString);
      return d(paramString);
      if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
        return 6;
      }
    } while (!"0X8009EFD".equals(paramString));
    return 5;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  private int c(String paramString)
  {
    int i = -1;
    if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
      i = 4;
    }
    while (!"0X8009EFD".equals(paramString)) {
      return i;
    }
    return -1;
  }
  
  private int d(String paramString)
  {
    int i = -1;
    if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
      i = 5;
    }
    do
    {
      return i;
      if ("0X8009EFD".equals(paramString)) {
        return 4;
      }
    } while (!"0X800A882".equals(paramString));
    return 2;
  }
  
  private void o()
  {
    aqse.a();
    aqse.a().a(this);
    a(aqse.a());
    if (this.jdField_a_of_type_Aqsr != null)
    {
      this.jdField_a_of_type_Aqsr.a(this);
      this.jdField_a_of_type_Aqsr.a(this.jdField_a_of_type_Bbqz.mActivity, this.jdField_a_of_type_Bbqz.a);
      this.jdField_a_of_type_Aqsr.a();
    }
  }
  
  private void p()
  {
    if ((b(getCurrentPosition())) && (this.jdField_a_of_type_Bbps != null) && (this.jdField_a_of_type_Bbps.getItem(getCurrentPosition()) != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbps.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        aqse.a().a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, Long.valueOf(bbph.a().a()).longValue(), localRichMediaBrowserInfo.baseData.getType());
        b(this.b);
        return;
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "getDanmakuList is exception = " + localException.getMessage());
        return;
      }
    }
    BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "getDanmakuList return");
  }
  
  public int a(long paramLong)
  {
    List localList = this.jdField_a_of_type_Bbps.a();
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localList.get(i);
        if (((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).a == paramLong)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public long a()
  {
    BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
    if ((localBrowserBasePresenter instanceof bbpz)) {
      return ((bbpz)localBrowserBasePresenter).a();
    }
    return 0L;
  }
  
  public ahtp a()
  {
    return this.jdField_a_of_type_Ahtp;
  }
  
  public aqsr a()
  {
    return this.jdField_a_of_type_Aqsr;
  }
  
  public bbka a()
  {
    if (this.jdField_a_of_type_Bbka == null) {
      this.jdField_a_of_type_Bbka = new bbka(this.jdField_a_of_type_Bbqz.mActivity);
    }
    return this.jdField_a_of_type_Bbka;
  }
  
  public bbkd a()
  {
    if (this.jdField_a_of_type_Bbkd == null) {
      this.jdField_a_of_type_Bbkd = new bbkd(this.jdField_a_of_type_Bbqz.mActivity);
    }
    return this.jdField_a_of_type_Bbkd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bbqz != null)
    {
      localObject = this.jdField_a_of_type_Bbps.getSelectedItem();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((bbph.a().c()) && (bbph.a().a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Ahtp != null) && (!bool)) {
        this.jdField_a_of_type_Ahtp.a(paramLong);
      }
      if (!bool)
      {
        BrowserBasePresenter localBrowserBasePresenter = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localBrowserBasePresenter instanceof bbpz))
        {
          int i = a(paramLong);
          if (i >= 0) {
            ((bbpz)localBrowserBasePresenter).b(i);
          }
        }
      }
      if ((this.jdField_a_of_type_Bbqz.mActivity == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))) {
        break;
      }
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Bbqz.mActivity.runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
      return;
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 1) || (paramInt2 == 256) || (paramInt2 == 269484035)) {
      if ((paramInt2 != 18) && (paramInt2 != 20)) {
        break label114;
      }
    }
    label114:
    for (int i = this.jdField_a_of_type_Bbps.a(paramLong1);; i = this.jdField_a_of_type_Bbps.a(paramLong1, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof bbpz)) {
        ((bbpz)localBrowserBasePresenter).a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 256) || (paramInt2 == 1) || (paramInt2 == 0) || (paramInt2 == 269484034)) {
      if ((paramInt2 != 18) && (paramInt2 != 20) && (paramInt2 != 269484034)) {
        break label127;
      }
    }
    label127:
    for (int i = this.jdField_a_of_type_Bbps.a(paramLong);; i = this.jdField_a_of_type_Bbps.a(paramLong, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof bbpz)) {
        ((bbpz)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.jdField_a_of_type_Bbps.a(paramLong, paramInt1));
    if ((localBrowserBasePresenter instanceof bbpz)) {
      ((bbpz)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    ShortVideoUtils.reportVideoPlayEvent(null, b(), paramString, 2, a("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.b = (paramInt * 1000);
    }
    if ((!this.jdField_a_of_type_Boolean) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = getCurrentPresenter();
      if (((paramString instanceof bbpz)) && (this.jdField_a_of_type_Aqsr != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((bbpz)paramString).c();
        this.jdField_a_of_type_Aqsr.a(null);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter;
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof bbpz)) && (this.jdField_a_of_type_Aqsr != null) && (this.jdField_a_of_type_Bbps != null))
      {
        c();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbps.getSelectedItem();
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
        {
          paramString = new ArrayList();
          switch (localRichMediaBrowserInfo.baseData.getType())
          {
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqsr.a(paramString);
      return;
      paramString = bbpf.a(paramLong, paramList, a(), ((bbpz)localBrowserBasePresenter).a);
      continue;
      paramString = bbpf.a(paramLong, paramList, a(), ((bbpz)localBrowserBasePresenter).a, ((bbpz)localBrowserBasePresenter).a());
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((NetworkUtil.isNetworkAvailable()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_Aqsr != null))
    {
      c();
      this.jdField_a_of_type_Aqsr.a(paramDanmuItemBean);
    }
  }
  
  public void a(ahtp paramahtp)
  {
    this.jdField_a_of_type_Ahtp = paramahtp;
  }
  
  public void a(bbps parambbps)
  {
    super.setGalleryModel(parambbps);
    this.jdField_a_of_type_Bbps = parambbps;
  }
  
  public void a(bbqz parambbqz)
  {
    super.setGalleryScene(parambbqz);
    this.jdField_a_of_type_Bbqz = parambbqz;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqsr != null) && (this.jdField_a_of_type_Aqsr.a()) && (this.jdField_a_of_type_Bbqz != null))
    {
      this.jdField_a_of_type_Aqsr.d();
      this.jdField_a_of_type_Bbqz.a(paramBoolean);
    }
  }
  
  public void a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    if (paramArrayOfAIOBrowserBaseData != null) {}
    for (int i = paramArrayOfAIOBrowserBaseData.length;; i = 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + i + ", selected " + paramInt);
      if (this.browserScene != null) {
        this.browserScene.notifyImageModelDataChanged();
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bbps != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbps.getItem(paramInt);
      bool1 = bool2;
      if (localRichMediaBrowserInfo != null)
      {
        bool1 = bool2;
        if (localRichMediaBrowserInfo.baseData != null) {
          if ((localRichMediaBrowserInfo.baseData.getType() != 100) && (localRichMediaBrowserInfo.baseData.getType() != 101) && (localRichMediaBrowserInfo.baseData.getType() != 102))
          {
            bool1 = bool2;
            if (localRichMediaBrowserInfo.baseData.getType() != 103) {}
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
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Bbps != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbps.getItem(getCurrentPosition());
      return (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof bbpz)) && (this.jdField_a_of_type_Aqsr != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((bbpz)localBrowserBasePresenter).c();
        this.jdField_a_of_type_Aqsr.a(null);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (bbpf.a(this.jdField_a_of_type_Bbps.getSelectedItem())) && (a(paramInt));
  }
  
  public void buildComplete()
  {
    if ((this.jdField_a_of_type_Bbqz.mActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_Bbqz.mActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((anzf)((PeakAppInterface)localAppRuntime).a(2)).a(this.jdField_a_of_type_Bbqz.mActivity);
      }
    }
    if (bbpf.a())
    {
      this.jdField_a_of_type_Aqsr = new aqsr();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      o();
    }
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        AIORichMediaData localAIORichMediaData = (AIORichMediaData)paramIntent.getParcelable("extra.EXTRA_CURRENT_IMAGE");
        if (localAIORichMediaData != null)
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = bbqq.a(localAIORichMediaData);
          if (this.jdField_a_of_type_Bbps.a(localRichMediaBrowserInfo))
          {
            this.jdField_a_of_type_Bbps.b(localRichMediaBrowserInfo);
            if (paramIntent.getBoolean("muate_play")) {
              this.jdField_a_of_type_Bbps.c(localRichMediaBrowserInfo);
            }
            long l = paramIntent.getLong("click_video_bubble_time");
            if (l > 0L) {
              this.jdField_a_of_type_Bbps.a(localRichMediaBrowserInfo, l);
            }
          }
          this.jdField_a_of_type_Bbps.a(localRichMediaBrowserInfo);
          if (bbph.a().f()) {
            this.jdField_a_of_type_Bbps.a(true);
          }
        }
      }
    }
    ahrf.a().a(this);
  }
  
  public void buildPresenter() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManagerV2.excute(new AIOBrowserPresenter.1(this), 128, null, true);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Aqsr != null) && (!this.jdField_a_of_type_Aqsr.a()) && (this.jdField_a_of_type_Bbqz != null))
    {
      this.jdField_a_of_type_Aqsr.e();
      this.jdField_a_of_type_Bbqz.a(true);
    }
  }
  
  public void e()
  {
    bdla.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), 0, "" + b(), "" + b("0X8009EFD"), "", "");
  }
  
  public void f()
  {
    bdla.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void g()
  {
    bdla.b(null, "dc00898", "", "", "0X800A418", "0X800A418", a(), 0, "" + b(), "" + b("0X800A418"), "", "");
  }
  
  public void h()
  {
    bdla.b(null, "dc00898", "", "", "0X800A419", "0X800A419", a(), 0, "" + b(), "" + b("0X800A419"), "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      p();
    }
  }
  
  public void i()
  {
    bdla.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", a(), 0, "" + b(), "" + b("0X800A41A"), "", "");
  }
  
  public void j()
  {
    bdla.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", a(), 0, "" + b(), "" + b("0X800A41B"), "", "");
  }
  
  public void k()
  {
    bdla.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", a(), 0, "" + b(), "" + b("0X800A41C"), "", "");
  }
  
  public void l()
  {
    bdla.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", a(), 0, "" + b(), "" + b("0X800A41D"), "", "");
  }
  
  public void m()
  {
    bdla.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void n()
  {
    bdla.b(null, "dc00898", "", "", "0X800A882", "0X800A882", a(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aqse.a().b(this);
    if (this.jdField_a_of_type_Aqsr != null) {
      this.jdField_a_of_type_Aqsr.b();
    }
    if (this.jdField_a_of_type_Aqsm != null)
    {
      this.jdField_a_of_type_Aqsm.b();
      this.jdField_a_of_type_Aqsm = null;
    }
    if (this.jdField_a_of_type_Bbqz != null) {
      this.jdField_a_of_type_Bbqz.onDestroy();
    }
    ahrf.a().b(this);
    if (this.jdField_a_of_type_Bbka != null)
    {
      this.jdField_a_of_type_Bbka.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bbka.a();
    }
    if (this.jdField_a_of_type_Bbkd != null)
    {
      this.jdField_a_of_type_Bbkd.a();
      this.jdField_a_of_type_Bbkd = null;
    }
  }
  
  public void onDoubleTap()
  {
    super.onDoubleTap();
    g();
  }
  
  public void onItemSelect(int paramInt)
  {
    super.onItemSelect(paramInt);
    if ((this.jdField_a_of_type_Bbqz != null) && (b(paramInt)))
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof bbpz)) && (this.jdField_a_of_type_Aqsr != null))
      {
        ((bbpz)localBrowserBasePresenter).b();
        this.jdField_a_of_type_Aqsr.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    b(0);
  }
  
  public void onScale()
  {
    super.onScale();
    if (this.jdField_a_of_type_Bbqz != null) {
      this.jdField_a_of_type_Bbqz.a(false);
    }
    if (a() != null)
    {
      a().d();
      a().c();
    }
    h();
  }
  
  public void onScaleBegin()
  {
    super.onScaleBegin();
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbps.getItem(this.jdField_a_of_type_Bbps.getSelectedIndex());
    if (localRichMediaBrowserInfo != null) {
      a().c(localRichMediaBrowserInfo.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqa
 * JD-Core Version:    0.7.0.1
 */