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

public class axyq
  extends MainBrowserPresenter
  implements aghw, Handler.Callback, aogg, aogu, aogv
{
  public int a;
  private agki jdField_a_of_type_Agki;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aogm jdField_a_of_type_Aogm;
  private aogr jdField_a_of_type_Aogr;
  private axsw jdField_a_of_type_Axsw;
  private axsz jdField_a_of_type_Axsz;
  public axyi a;
  public axzo a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 30000;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_Axyi.getSelectedItem();
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
    Object localObject = this.jdField_a_of_type_Axyi.getSelectedItem();
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
  
  private void a(aogm paramaogm)
  {
    this.jdField_a_of_type_Aogm = paramaogm;
  }
  
  private int b()
  {
    switch (axyd.a().a())
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
    switch (axyd.a().c())
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
    aoge.a();
    aoge.a().a(this);
    a(aoge.a());
    if (this.jdField_a_of_type_Aogr != null)
    {
      this.jdField_a_of_type_Aogr.a(this);
      this.jdField_a_of_type_Aogr.a(this.jdField_a_of_type_Axzo.mActivity, this.jdField_a_of_type_Axzo.a);
      this.jdField_a_of_type_Aogr.a();
    }
  }
  
  private void p()
  {
    if ((b(getCurrentPosition())) && (this.jdField_a_of_type_Axyi != null) && (this.jdField_a_of_type_Axyi.getItem(getCurrentPosition()) != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyi.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        aoge.a().a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, Long.valueOf(axyd.a().a()).longValue(), localRichMediaBrowserInfo.baseData.getType());
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
    List localList = this.jdField_a_of_type_Axyi.a();
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
    if ((localBrowserBasePresenter instanceof axyp)) {
      return ((axyp)localBrowserBasePresenter).a();
    }
    return 0L;
  }
  
  public agki a()
  {
    return this.jdField_a_of_type_Agki;
  }
  
  public aogr a()
  {
    return this.jdField_a_of_type_Aogr;
  }
  
  public axsw a()
  {
    if (this.jdField_a_of_type_Axsw == null) {
      this.jdField_a_of_type_Axsw = new axsw(this.jdField_a_of_type_Axzo.mActivity);
    }
    return this.jdField_a_of_type_Axsw;
  }
  
  public axsz a()
  {
    if (this.jdField_a_of_type_Axsz == null) {
      this.jdField_a_of_type_Axsz = new axsz(this.jdField_a_of_type_Axzo.mActivity);
    }
    return this.jdField_a_of_type_Axsz;
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
    if ((this.jdField_a_of_type_Axzo != null) && (this.jdField_a_of_type_Axzo.mAdapter != null))
    {
      localObject = this.jdField_a_of_type_Axyi.getSelectedItem();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((axyd.a().c()) && (axyd.a().a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_Agki != null) && (!bool)) {
        this.jdField_a_of_type_Agki.a(paramLong);
      }
      if (!bool)
      {
        BrowserBasePresenter localBrowserBasePresenter = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localBrowserBasePresenter instanceof axyp))
        {
          int i = a(paramLong);
          if (i >= 0) {
            ((axyp)localBrowserBasePresenter).b(i);
          }
        }
      }
      if ((this.jdField_a_of_type_Axzo.mActivity == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))) {
        break;
      }
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Axzo.mActivity.runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
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
    for (int i = this.jdField_a_of_type_Axyi.a(paramLong1);; i = this.jdField_a_of_type_Axyi.a(paramLong1, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof axyp)) {
        ((axyp)localBrowserBasePresenter).a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
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
    for (int i = this.jdField_a_of_type_Axyi.a(paramLong);; i = this.jdField_a_of_type_Axyi.a(paramLong, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof axyp)) {
        ((axyp)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.jdField_a_of_type_Axyi.a(paramLong, paramInt1));
    if ((localBrowserBasePresenter instanceof axyp)) {
      ((axyp)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
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
      if (((paramString instanceof axyp)) && (this.jdField_a_of_type_Aogr != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((axyp)paramString).c();
        this.jdField_a_of_type_Aogr.a(null);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter;
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof axyp)) && (this.jdField_a_of_type_Aogr != null) && (this.jdField_a_of_type_Axyi != null))
      {
        c();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyi.getSelectedItem();
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
      this.jdField_a_of_type_Aogr.a(paramString);
      return;
      paramString = axyb.a(paramLong, paramList, a(), ((axyp)localBrowserBasePresenter).a);
      continue;
      paramString = axyb.a(paramLong, paramList, a(), ((axyp)localBrowserBasePresenter).a, ((axyp)localBrowserBasePresenter).a());
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((bdin.a()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_Aogr != null)) {
      this.jdField_a_of_type_Aogr.a(paramDanmuItemBean);
    }
  }
  
  public void a(agki paramagki)
  {
    this.jdField_a_of_type_Agki = paramagki;
  }
  
  public void a(axyi paramaxyi)
  {
    super.setGalleryModel(paramaxyi);
    this.jdField_a_of_type_Axyi = paramaxyi;
  }
  
  public void a(axzo paramaxzo)
  {
    super.setGalleryScene(paramaxzo);
    this.jdField_a_of_type_Axzo = paramaxzo;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aogr != null) && (this.jdField_a_of_type_Aogr.a()) && (this.jdField_a_of_type_Axzo != null))
    {
      this.jdField_a_of_type_Aogr.d();
      this.jdField_a_of_type_Axzo.a(paramBoolean);
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
    if (this.jdField_a_of_type_Axyi != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyi.getItem(paramInt);
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
    if (this.jdField_a_of_type_Axyi != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyi.getItem(getCurrentPosition());
      return (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof axyp)) && (this.jdField_a_of_type_Aogr != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((axyp)localBrowserBasePresenter).c();
        this.jdField_a_of_type_Aogr.a(null);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (axyb.a(this.jdField_a_of_type_Axyi.getSelectedItem())) && (a(paramInt));
  }
  
  public void buildComplete()
  {
    if ((this.jdField_a_of_type_Axzo.mActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_Axzo.mActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((alxd)((PeakAppInterface)localAppRuntime).a(2)).a(this.jdField_a_of_type_Axzo.mActivity);
      }
    }
    if (axyb.a())
    {
      this.jdField_a_of_type_Aogr = new aogr();
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
    localRichMediaBrowserInfo.baseData = axzf.a(localAIORichMediaData);
    if (this.jdField_a_of_type_Axyi.a(localRichMediaBrowserInfo))
    {
      this.jdField_a_of_type_Axyi.b(localRichMediaBrowserInfo);
      if (paramIntent.getBoolean("muate_play")) {
        this.jdField_a_of_type_Axyi.c(localRichMediaBrowserInfo);
      }
    }
    this.jdField_a_of_type_Axyi.a(localRichMediaBrowserInfo);
    if (axyd.a().f()) {
      this.jdField_a_of_type_Axyi.a(true);
    }
    aghu.a().a(this);
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
    if ((this.jdField_a_of_type_Aogr != null) && (!this.jdField_a_of_type_Aogr.a()) && (this.jdField_a_of_type_Axzo != null))
    {
      this.jdField_a_of_type_Aogr.e();
      this.jdField_a_of_type_Axzo.a(true);
    }
  }
  
  public void e()
  {
    azqs.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), 0, "" + b(), "" + b("0X8009EFD"), "", "");
  }
  
  public void f()
  {
    azqs.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void g()
  {
    azqs.b(null, "dc00898", "", "", "0X800A418", "0X800A418", a(), 0, "" + b(), "" + b("0X800A418"), "", "");
  }
  
  public void h()
  {
    azqs.b(null, "dc00898", "", "", "0X800A419", "0X800A419", a(), 0, "" + b(), "" + b("0X800A419"), "", "");
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
    azqs.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", a(), 0, "" + b(), "" + b("0X800A41A"), "", "");
  }
  
  public void j()
  {
    azqs.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", a(), 0, "" + b(), "" + b("0X800A41B"), "", "");
  }
  
  public void k()
  {
    azqs.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", a(), 0, "" + b(), "" + b("0X800A41C"), "", "");
  }
  
  public void l()
  {
    azqs.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", a(), 0, "" + b(), "" + b("0X800A41D"), "", "");
  }
  
  public void m()
  {
    azqs.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void n()
  {
    azqs.b(null, "dc00898", "", "", "0X800A882", "0X800A882", a(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aoge.a().b(this);
    if (this.jdField_a_of_type_Aogr != null) {
      this.jdField_a_of_type_Aogr.b();
    }
    if (this.jdField_a_of_type_Aogm != null)
    {
      this.jdField_a_of_type_Aogm.b();
      this.jdField_a_of_type_Aogm = null;
    }
    if (this.jdField_a_of_type_Axzo != null) {
      this.jdField_a_of_type_Axzo.onDestroy();
    }
    aghu.a().b(this);
    if (this.jdField_a_of_type_Axsw != null)
    {
      this.jdField_a_of_type_Axsw.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Axsw.a();
    }
    if (this.jdField_a_of_type_Axsz != null)
    {
      this.jdField_a_of_type_Axsz.a();
      this.jdField_a_of_type_Axsz = null;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    g();
    return true;
  }
  
  public void onItemSelect(int paramInt)
  {
    if ((this.jdField_a_of_type_Axzo != null) && (b(paramInt)))
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof axyp)) && (this.jdField_a_of_type_Aogr != null))
      {
        ((axyp)localBrowserBasePresenter).b();
        this.jdField_a_of_type_Aogr.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    b(0);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Axzo != null) {
      this.jdField_a_of_type_Axzo.a(false);
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
    paramView = this.jdField_a_of_type_Axyi.getItem(paramInt);
    if (paramView != null) {
      a().c(paramView.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyq
 * JD-Core Version:    0.7.0.1
 */