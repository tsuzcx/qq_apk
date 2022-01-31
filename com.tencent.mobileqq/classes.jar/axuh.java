import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
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

public class axuh
  extends MainBrowserPresenter
  implements agdh, Handler.Callback, aobx, aocl, aocm
{
  public int a;
  private agft jdField_a_of_type_Agft;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aocd jdField_a_of_type_Aocd;
  private aoci jdField_a_of_type_Aoci;
  private axon jdField_a_of_type_Axon;
  private axoq jdField_a_of_type_Axoq;
  public axtz a;
  public axvf a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 30000;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_Axtz.getSelectedItem();
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
    Object localObject = this.jdField_a_of_type_Axtz.getSelectedItem();
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
  
  private void a(aocd paramaocd)
  {
    this.jdField_a_of_type_Aocd = paramaocd;
  }
  
  private int b()
  {
    switch (axtu.a().a())
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
    switch (axtu.a().c())
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
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  private void o()
  {
    aobv.a();
    aobv.a().a(this);
    a(aobv.a());
    if (this.jdField_a_of_type_Aoci != null)
    {
      this.jdField_a_of_type_Aoci.a(this);
      this.jdField_a_of_type_Aoci.a(this.jdField_a_of_type_Axvf.mActivity, this.jdField_a_of_type_Axvf.a);
      this.jdField_a_of_type_Aoci.a();
    }
  }
  
  private void p()
  {
    if ((b(getCurrentPosition())) && (this.jdField_a_of_type_Axtz != null) && (this.jdField_a_of_type_Axtz.getItem(getCurrentPosition()) != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axtz.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        aobv.a().a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, Long.valueOf(axtu.a().a()).longValue(), localRichMediaBrowserInfo.baseData.getType());
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
    List localList = this.jdField_a_of_type_Axtz.a();
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
    if ((localBrowserBasePresenter instanceof axug)) {
      return ((axug)localBrowserBasePresenter).a();
    }
    return 0L;
  }
  
  public agft a()
  {
    return this.jdField_a_of_type_Agft;
  }
  
  public aoci a()
  {
    return this.jdField_a_of_type_Aoci;
  }
  
  public axon a()
  {
    if (this.jdField_a_of_type_Axon == null) {
      this.jdField_a_of_type_Axon = new axon(this.jdField_a_of_type_Axvf.mActivity);
    }
    return this.jdField_a_of_type_Axon;
  }
  
  public axoq a()
  {
    if (this.jdField_a_of_type_Axoq == null) {
      this.jdField_a_of_type_Axoq = new axoq(this.jdField_a_of_type_Axvf.mActivity);
    }
    return this.jdField_a_of_type_Axoq;
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
    if ((this.jdField_a_of_type_Axvf != null) && (this.jdField_a_of_type_Axvf.mAdapter != null))
    {
      localObject = this.jdField_a_of_type_Axtz.getSelectedItem();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((axtu.a().c()) && (axtu.a().a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Agft != null) && (!bool)) {
        this.jdField_a_of_type_Agft.a(paramLong);
      }
      if (!bool)
      {
        BrowserBasePresenter localBrowserBasePresenter = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localBrowserBasePresenter instanceof axug))
        {
          int i = a(paramLong);
          if (i >= 0) {
            ((axug)localBrowserBasePresenter).b(i);
          }
        }
      }
      if ((this.jdField_a_of_type_Axvf.mActivity == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))) {
        break;
      }
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Axvf.mActivity.runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
      return;
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 1) || (paramInt2 == 256)) {
      if ((paramInt2 != 18) && (paramInt2 != 20)) {
        break label106;
      }
    }
    label106:
    for (int i = this.jdField_a_of_type_Axtz.a(paramLong1);; i = this.jdField_a_of_type_Axtz.a(paramLong1, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof axug)) {
        ((axug)localBrowserBasePresenter).a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
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
    for (int i = this.jdField_a_of_type_Axtz.a(paramLong);; i = this.jdField_a_of_type_Axtz.a(paramLong, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof axug)) {
        ((axug)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.jdField_a_of_type_Axtz.a(paramLong, paramInt1));
    if ((localBrowserBasePresenter instanceof axug)) {
      ((axug)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
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
      if (((paramString instanceof axug)) && (this.jdField_a_of_type_Aoci != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((axug)paramString).c();
        this.jdField_a_of_type_Aoci.a(null);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter;
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof axug)) && (this.jdField_a_of_type_Aoci != null) && (this.jdField_a_of_type_Axtz != null))
      {
        c();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axtz.getSelectedItem();
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
      this.jdField_a_of_type_Aoci.a(paramString);
      return;
      paramString = axts.a(paramLong, paramList, a(), ((axug)localBrowserBasePresenter).a);
      continue;
      paramString = axts.a(paramLong, paramList, a(), ((axug)localBrowserBasePresenter).a, ((axug)localBrowserBasePresenter).a());
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((bdee.a()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_Aoci != null)) {
      this.jdField_a_of_type_Aoci.a(paramDanmuItemBean);
    }
  }
  
  public void a(agft paramagft)
  {
    this.jdField_a_of_type_Agft = paramagft;
  }
  
  public void a(axtz paramaxtz)
  {
    super.setGalleryModel(paramaxtz);
    this.jdField_a_of_type_Axtz = paramaxtz;
  }
  
  public void a(axvf paramaxvf)
  {
    super.setGalleryScene(paramaxvf);
    this.jdField_a_of_type_Axvf = paramaxvf;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aoci != null) && (this.jdField_a_of_type_Aoci.a()) && (this.jdField_a_of_type_Axvf != null))
    {
      this.jdField_a_of_type_Aoci.d();
      this.jdField_a_of_type_Axvf.a(paramBoolean);
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
    if (this.jdField_a_of_type_Axtz != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axtz.getItem(paramInt);
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
    if (this.jdField_a_of_type_Axtz != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axtz.getItem(getCurrentPosition());
      return (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof axug)) && (this.jdField_a_of_type_Aoci != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((axug)localBrowserBasePresenter).c();
        this.jdField_a_of_type_Aoci.a(null);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (axts.a(this.jdField_a_of_type_Axtz.getSelectedItem())) && (a(paramInt));
  }
  
  public void buildComplete()
  {
    if ((this.jdField_a_of_type_Axvf.mActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_Axvf.mActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((also)((PeakAppInterface)localAppRuntime).a(2)).a(this.jdField_a_of_type_Axvf.mActivity);
      }
    }
    if (axts.a())
    {
      this.jdField_a_of_type_Aoci = new aoci();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      o();
    }
  }
  
  public void buildParams(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    AIORichMediaData localAIORichMediaData = (AIORichMediaData)paramIntent.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
    localRichMediaBrowserInfo.baseData = axuw.a(localAIORichMediaData);
    if (this.jdField_a_of_type_Axtz.a(localRichMediaBrowserInfo))
    {
      this.jdField_a_of_type_Axtz.b(localRichMediaBrowserInfo);
      if (paramIntent.getBoolean("muate_play")) {
        this.jdField_a_of_type_Axtz.c(localRichMediaBrowserInfo);
      }
    }
    this.jdField_a_of_type_Axtz.a(localRichMediaBrowserInfo);
    if (axtu.a().f()) {
      this.jdField_a_of_type_Axtz.a(true);
    }
    agdf.a().a(this);
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
    if ((this.jdField_a_of_type_Aoci != null) && (!this.jdField_a_of_type_Aoci.a()) && (this.jdField_a_of_type_Axvf != null))
    {
      this.jdField_a_of_type_Aoci.e();
      this.jdField_a_of_type_Axvf.a(true);
    }
  }
  
  public void e()
  {
    azmj.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), 0, "" + b(), "" + b("0X8009EFD"), "", "");
  }
  
  public void f()
  {
    azmj.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void g()
  {
    azmj.b(null, "dc00898", "", "", "0X800A418", "0X800A418", a(), 0, "" + b(), "" + b("0X800A418"), "", "");
  }
  
  public void h()
  {
    azmj.b(null, "dc00898", "", "", "0X800A419", "0X800A419", a(), 0, "" + b(), "" + b("0X800A419"), "", "");
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
    azmj.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", a(), 0, "" + b(), "" + b("0X800A41A"), "", "");
  }
  
  public void j()
  {
    azmj.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", a(), 0, "" + b(), "" + b("0X800A41B"), "", "");
  }
  
  public void k()
  {
    azmj.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", a(), 0, "" + b(), "" + b("0X800A41C"), "", "");
  }
  
  public void l()
  {
    azmj.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", a(), 0, "" + b(), "" + b("0X800A41D"), "", "");
  }
  
  public void m()
  {
    azmj.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void n()
  {
    azmj.b(null, "dc00898", "", "", "0X800A882", "0X800A882", a(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aobv.a().b(this);
    if (this.jdField_a_of_type_Aoci != null) {
      this.jdField_a_of_type_Aoci.b();
    }
    if (this.jdField_a_of_type_Aocd != null)
    {
      this.jdField_a_of_type_Aocd.b();
      this.jdField_a_of_type_Aocd = null;
    }
    if (this.jdField_a_of_type_Axvf != null) {
      this.jdField_a_of_type_Axvf.onDestroy();
    }
    agdf.a().b(this);
    if (this.jdField_a_of_type_Axon != null)
    {
      this.jdField_a_of_type_Axon.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Axon.a();
    }
    if (this.jdField_a_of_type_Axoq != null)
    {
      this.jdField_a_of_type_Axoq.a();
      this.jdField_a_of_type_Axoq = null;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    g();
    return true;
  }
  
  public void onItemSelect(int paramInt)
  {
    if ((this.jdField_a_of_type_Axvf != null) && (b(paramInt)))
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof axug)) && (this.jdField_a_of_type_Aoci != null))
      {
        ((axug)localBrowserBasePresenter).b();
        this.jdField_a_of_type_Aoci.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    b(0);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Axvf != null) {
      this.jdField_a_of_type_Axvf.a(false);
    }
    if (a() != null)
    {
      a().d();
      a().c();
    }
    h();
    return true;
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_Axtz.getItem(paramInt);
    if (paramView != null) {
      a().c(paramView.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuh
 * JD-Core Version:    0.7.0.1
 */