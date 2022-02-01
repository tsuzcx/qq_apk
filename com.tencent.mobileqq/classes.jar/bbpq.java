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

public class bbpq
  extends MainBrowserPresenter
  implements aibq, Handler.Callback, aqvt, aqwh, aqwi
{
  public int a;
  private aidz jdField_a_of_type_Aidz;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aqvz jdField_a_of_type_Aqvz;
  private aqwe jdField_a_of_type_Aqwe;
  private bbjq jdField_a_of_type_Bbjq;
  private bbjt jdField_a_of_type_Bbjt;
  public bbpi a;
  public bbqp a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 30000;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_Bbpi.getSelectedItem();
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
    Object localObject = this.jdField_a_of_type_Bbpi.getSelectedItem();
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
  
  private void a(aqvz paramaqvz)
  {
    this.jdField_a_of_type_Aqvz = paramaqvz;
  }
  
  private int b()
  {
    switch (bbox.a().a())
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
    switch (bbox.a().c())
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
    aqvr.a();
    aqvr.a().a(this);
    a(aqvr.a());
    if (this.jdField_a_of_type_Aqwe != null)
    {
      this.jdField_a_of_type_Aqwe.a(this);
      this.jdField_a_of_type_Aqwe.a(this.jdField_a_of_type_Bbqp.mActivity, this.jdField_a_of_type_Bbqp.a);
      this.jdField_a_of_type_Aqwe.a();
    }
  }
  
  private void p()
  {
    if ((b(getCurrentPosition())) && (this.jdField_a_of_type_Bbpi != null) && (this.jdField_a_of_type_Bbpi.getItem(getCurrentPosition()) != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpi.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        aqvr.a().a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, Long.valueOf(bbox.a().a()).longValue(), localRichMediaBrowserInfo.baseData.getType());
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
    List localList = this.jdField_a_of_type_Bbpi.a();
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
    if ((localBrowserBasePresenter instanceof bbpp)) {
      return ((bbpp)localBrowserBasePresenter).a();
    }
    return 0L;
  }
  
  public aidz a()
  {
    return this.jdField_a_of_type_Aidz;
  }
  
  public aqwe a()
  {
    return this.jdField_a_of_type_Aqwe;
  }
  
  public bbjq a()
  {
    if (this.jdField_a_of_type_Bbjq == null) {
      this.jdField_a_of_type_Bbjq = new bbjq(this.jdField_a_of_type_Bbqp.mActivity);
    }
    return this.jdField_a_of_type_Bbjq;
  }
  
  public bbjt a()
  {
    if (this.jdField_a_of_type_Bbjt == null) {
      this.jdField_a_of_type_Bbjt = new bbjt(this.jdField_a_of_type_Bbqp.mActivity);
    }
    return this.jdField_a_of_type_Bbjt;
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
    if (this.jdField_a_of_type_Bbqp != null)
    {
      localObject = this.jdField_a_of_type_Bbpi.getSelectedItem();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((bbox.a().c()) && (bbox.a().a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Aidz != null) && (!bool)) {
        this.jdField_a_of_type_Aidz.a(paramLong);
      }
      if (!bool)
      {
        BrowserBasePresenter localBrowserBasePresenter = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localBrowserBasePresenter instanceof bbpp))
        {
          int i = a(paramLong);
          if (i >= 0) {
            ((bbpp)localBrowserBasePresenter).b(i);
          }
        }
      }
      if ((this.jdField_a_of_type_Bbqp.mActivity == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))) {
        break;
      }
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Bbqp.mActivity.runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
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
    for (int i = this.jdField_a_of_type_Bbpi.a(paramLong1);; i = this.jdField_a_of_type_Bbpi.a(paramLong1, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof bbpp)) {
        ((bbpp)localBrowserBasePresenter).a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
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
    for (int i = this.jdField_a_of_type_Bbpi.a(paramLong);; i = this.jdField_a_of_type_Bbpi.a(paramLong, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof bbpp)) {
        ((bbpp)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.jdField_a_of_type_Bbpi.a(paramLong, paramInt1));
    if ((localBrowserBasePresenter instanceof bbpp)) {
      ((bbpp)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    ShortVideoUtils.a(null, b(), paramString, 2, a("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.b = (paramInt * 1000);
    }
    if ((!this.jdField_a_of_type_Boolean) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = getCurrentPresenter();
      if (((paramString instanceof bbpp)) && (this.jdField_a_of_type_Aqwe != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((bbpp)paramString).c();
        this.jdField_a_of_type_Aqwe.a(null);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter;
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof bbpp)) && (this.jdField_a_of_type_Aqwe != null) && (this.jdField_a_of_type_Bbpi != null))
      {
        c();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpi.getSelectedItem();
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
      this.jdField_a_of_type_Aqwe.a(paramString);
      return;
      paramString = bbov.a(paramLong, paramList, a(), ((bbpp)localBrowserBasePresenter).a);
      continue;
      paramString = bbov.a(paramLong, paramList, a(), ((bbpp)localBrowserBasePresenter).a, ((bbpp)localBrowserBasePresenter).a());
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((bhnv.a()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_Aqwe != null))
    {
      c();
      this.jdField_a_of_type_Aqwe.a(paramDanmuItemBean);
    }
  }
  
  public void a(aidz paramaidz)
  {
    this.jdField_a_of_type_Aidz = paramaidz;
  }
  
  public void a(bbpi parambbpi)
  {
    super.setGalleryModel(parambbpi);
    this.jdField_a_of_type_Bbpi = parambbpi;
  }
  
  public void a(bbqp parambbqp)
  {
    super.setGalleryScene(parambbqp);
    this.jdField_a_of_type_Bbqp = parambbqp;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqwe != null) && (this.jdField_a_of_type_Aqwe.a()) && (this.jdField_a_of_type_Bbqp != null))
    {
      this.jdField_a_of_type_Aqwe.d();
      this.jdField_a_of_type_Bbqp.a(paramBoolean);
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
    if (this.jdField_a_of_type_Bbpi != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpi.getItem(paramInt);
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
    if (this.jdField_a_of_type_Bbpi != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpi.getItem(getCurrentPosition());
      return (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof bbpp)) && (this.jdField_a_of_type_Aqwe != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((bbpp)localBrowserBasePresenter).c();
        this.jdField_a_of_type_Aqwe.a(null);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (bbov.a(this.jdField_a_of_type_Bbpi.getSelectedItem())) && (a(paramInt));
  }
  
  public void buildComplete()
  {
    if ((this.jdField_a_of_type_Bbqp.mActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_Bbqp.mActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((aocp)((PeakAppInterface)localAppRuntime).a(2)).a(this.jdField_a_of_type_Bbqp.mActivity);
      }
    }
    if (bbov.a())
    {
      this.jdField_a_of_type_Aqwe = new aqwe();
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
          localRichMediaBrowserInfo.baseData = bbqg.a(localAIORichMediaData);
          if (this.jdField_a_of_type_Bbpi.a(localRichMediaBrowserInfo))
          {
            this.jdField_a_of_type_Bbpi.b(localRichMediaBrowserInfo);
            if (paramIntent.getBoolean("muate_play")) {
              this.jdField_a_of_type_Bbpi.c(localRichMediaBrowserInfo);
            }
            long l = paramIntent.getLong("click_video_bubble_time");
            if (l > 0L) {
              this.jdField_a_of_type_Bbpi.a(localRichMediaBrowserInfo, l);
            }
          }
          this.jdField_a_of_type_Bbpi.a(localRichMediaBrowserInfo);
          if (bbox.a().f()) {
            this.jdField_a_of_type_Bbpi.a(true);
          }
        }
      }
    }
    aibo.a().a(this);
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
    if ((this.jdField_a_of_type_Aqwe != null) && (!this.jdField_a_of_type_Aqwe.a()) && (this.jdField_a_of_type_Bbqp != null))
    {
      this.jdField_a_of_type_Aqwe.e();
      this.jdField_a_of_type_Bbqp.a(true);
    }
  }
  
  public void e()
  {
    bdll.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), 0, "" + b(), "" + b("0X8009EFD"), "", "");
  }
  
  public void f()
  {
    bdll.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void g()
  {
    bdll.b(null, "dc00898", "", "", "0X800A418", "0X800A418", a(), 0, "" + b(), "" + b("0X800A418"), "", "");
  }
  
  public void h()
  {
    bdll.b(null, "dc00898", "", "", "0X800A419", "0X800A419", a(), 0, "" + b(), "" + b("0X800A419"), "", "");
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
    bdll.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", a(), 0, "" + b(), "" + b("0X800A41A"), "", "");
  }
  
  public void j()
  {
    bdll.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", a(), 0, "" + b(), "" + b("0X800A41B"), "", "");
  }
  
  public void k()
  {
    bdll.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", a(), 0, "" + b(), "" + b("0X800A41C"), "", "");
  }
  
  public void l()
  {
    bdll.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", a(), 0, "" + b(), "" + b("0X800A41D"), "", "");
  }
  
  public void m()
  {
    bdll.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void n()
  {
    bdll.b(null, "dc00898", "", "", "0X800A882", "0X800A882", a(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aqvr.a().b(this);
    if (this.jdField_a_of_type_Aqwe != null) {
      this.jdField_a_of_type_Aqwe.b();
    }
    if (this.jdField_a_of_type_Aqvz != null)
    {
      this.jdField_a_of_type_Aqvz.b();
      this.jdField_a_of_type_Aqvz = null;
    }
    if (this.jdField_a_of_type_Bbqp != null) {
      this.jdField_a_of_type_Bbqp.onDestroy();
    }
    aibo.a().b(this);
    if (this.jdField_a_of_type_Bbjq != null)
    {
      this.jdField_a_of_type_Bbjq.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bbjq.a();
    }
    if (this.jdField_a_of_type_Bbjt != null)
    {
      this.jdField_a_of_type_Bbjt.a();
      this.jdField_a_of_type_Bbjt = null;
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
    if ((this.jdField_a_of_type_Bbqp != null) && (b(paramInt)))
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof bbpp)) && (this.jdField_a_of_type_Aqwe != null))
      {
        ((bbpp)localBrowserBasePresenter).b();
        this.jdField_a_of_type_Aqwe.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    b(0);
  }
  
  public void onScale()
  {
    super.onScale();
    if (this.jdField_a_of_type_Bbqp != null) {
      this.jdField_a_of_type_Bbqp.a(false);
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
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpi.getItem(this.jdField_a_of_type_Bbpi.getSelectedIndex());
    if (localRichMediaBrowserInfo != null) {
      a().c(localRichMediaBrowserInfo.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpq
 * JD-Core Version:    0.7.0.1
 */