package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdDMPReportUtil;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

public class d
  extends AdCanvasComponentView
{
  private static final String TAG = "GdtCanvasButtonComponentView";
  private c data;
  private AdAppDownloadManager downloadManager;
  private View.OnClickListener listener = new d.1(this);
  private e mGdtAppBtnPresenter;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public d(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, c paramc, boolean paramBoolean)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, paramc, paramBoolean);
  }
  
  private void init(Context paramContext, c paramc, boolean paramBoolean)
  {
    startLoad();
    if ((paramc == null) || (!paramc.isValid()) || (getCanvasData() == null))
    {
      AdLog.e("GdtCanvasButtonComponentView", "init error");
      stopLoad(false);
      return;
    }
    this.data = paramc;
    AdLog.i("GdtCanvasButtonComponentView", "init appId " + getCanvasData().ad.getAppId() + " channel_id " + getCanvasData().ad.getAppChannelId() + " autodownload " + getCanvasData().getAutoDownLoad());
    f localf;
    if (getData().isFixed)
    {
      paramc = new RelativeLayout.LayoutParams(-1, -2);
      paramc.addRule(12);
      setLayoutParams(paramc);
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().toBottom + getData().paddingBottom);
      localf = new f(paramContext);
      paramc = new FrameLayout.LayoutParams(this.data.width, this.data.height);
      paramc.gravity = (this.data.gravity | 0x10);
      if (this.data.gravity != 17) {
        break label493;
      }
      paramc.gravity = 17;
      label246:
      localf.setText(this.data.button.text.text);
      addView(localf, paramc);
      localf.init(paramContext, this.data);
      localf.setOnClickListener(this.listener);
      if ((this.canvasViewListener == null) || (this.canvasViewListener.get() == null)) {
        break label540;
      }
    }
    label540:
    for (paramc = ((AdCanvasViewListener)this.canvasViewListener.get()).getDownloadManager();; paramc = null)
    {
      this.downloadManager = paramc;
      if (this.downloadManager != null)
      {
        this.downloadManager.init(paramContext, getCanvasData().getAutoDownLoad(), getCanvasData().ad, getCanvasData().sourceId);
        this.mGdtAppBtnPresenter = new e(this.data, this.data.button.text.text, localf, this.downloadManager, paramBoolean);
        this.downloadManager.setAppBtnUIPresenter(this.mGdtAppBtnPresenter);
      }
      this.status = new AdViewStatus(new WeakReference(localf), new WeakReference(this));
      stopLoad(true);
      return;
      setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
      break;
      label493:
      if (this.data.gravity == 3)
      {
        paramc.gravity = 3;
        break label246;
      }
      if (this.data.gravity == 5)
      {
        paramc.gravity = 5;
        break label246;
      }
      paramc.gravity = 17;
      break label246;
    }
  }
  
  public void doClick()
  {
    AdAppBtnData localAdAppBtnData;
    e locale;
    String str;
    if ((getCanvasData() != null) && (getCanvasData().isValid()))
    {
      AdDMPReportUtil.reportAppBtnClickAsync(getCanvasData().ad);
      localAdAppBtnData = this.downloadManager.getGdtAppBtnData();
      locale = this.mGdtAppBtnPresenter;
      str = this.data.id;
      if (localAdAppBtnData == null) {
        break label78;
      }
    }
    label78:
    for (int i = localAdAppBtnData.cState;; i = 0)
    {
      locale.updateUIByClick(str, localAdAppBtnData, i);
      return;
      AdLog.e("GdtCanvasButtonComponentView", "onClick error");
      break;
    }
  }
  
  public c getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if (this.mGdtAppBtnPresenter != null) {
      this.downloadManager.removePresenter(this.mGdtAppBtnPresenter);
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (this.downloadManager != null)
    {
      AdLog.i("GdtCanvasButtonComponentView", "onActivityResume callDownloadStatusCallbacks");
      this.downloadManager.callDownloadStatusCallbacks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d
 * JD-Core Version:    0.7.0.1
 */