package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.b;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.ad.tangram.views.xijing.a;
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
    if ((paramc != null) && (paramc.isValid()) && (getCanvasData() != null))
    {
      this.data = paramc;
      paramc = new StringBuilder();
      paramc.append("init appId ");
      paramc.append(getCanvasData().ad.getAppId());
      paramc.append(" channel_id ");
      paramc.append(getCanvasData().ad.getAppChannelId());
      paramc.append(" autodownload ");
      paramc.append(getCanvasData().getAutoDownLoad());
      AdLog.i("GdtCanvasButtonComponentView", paramc.toString());
      if (getData().isFixed)
      {
        paramc = new RelativeLayout.LayoutParams(-1, -2);
        paramc.addRule(12);
        setLayoutParams(paramc);
        setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().toBottom + getData().paddingBottom);
      }
      else
      {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
      }
      paramc = new f.a();
      paramc.textSize = this.data.button.text.size;
      paramc.leftBackgroundColor = this.data.button.backgroundColor;
      paramc.leftTextColor = this.data.button.text.color;
      paramc.rightBackgroundColor = this.data.button.text.color;
      paramc.rightTextColor = this.data.button.backgroundColor;
      paramc.borderCornerRadius = AdUIUtils.dp2px(this.data.button.borderCornerRadius, paramContext.getResources());
      paramc.borderWidth = this.data.button.borderWidth;
      paramc.borderColor = this.data.button.backgroundColor;
      f localf = new f(paramContext, paramc);
      paramc = new FrameLayout.LayoutParams(this.data.width, this.data.height);
      paramc.gravity = (this.data.gravity | 0x10);
      if (this.data.gravity == 17) {
        paramc.gravity = 17;
      } else if (this.data.gravity == 3) {
        paramc.gravity = 3;
      } else if (this.data.gravity == 5) {
        paramc.gravity = 5;
      } else {
        paramc.gravity = 17;
      }
      localf.setText(this.data.button.text.text);
      addView(localf, paramc);
      localf.setOnClickListener(this.listener);
      if ((this.canvasViewListener != null) && (this.canvasViewListener.get() != null)) {
        paramc = ((AdCanvasViewListener)this.canvasViewListener.get()).getDownloadManager();
      } else {
        paramc = null;
      }
      this.downloadManager = paramc;
      paramc = this.downloadManager;
      if (paramc != null)
      {
        paramc.init(paramContext, getCanvasData().getAutoDownLoad(), getCanvasData().ad, getCanvasData().sourceId);
        paramContext = this.data;
        this.mGdtAppBtnPresenter = new e(paramContext, paramContext.button.text.text, localf, this.downloadManager, paramBoolean);
        this.downloadManager.setAppBtnUIPresenter(this.mGdtAppBtnPresenter);
      }
      this.status = new AdViewStatus(new WeakReference(localf), new WeakReference(this));
      stopLoad(true);
      return;
    }
    AdLog.e("GdtCanvasButtonComponentView", "init error");
    stopLoad(false);
  }
  
  public void doClick()
  {
    if ((getCanvasData() != null) && (getCanvasData().isValid())) {
      b.reportAppBtnClickAsync(getCanvasData().ad);
    } else {
      AdLog.e("GdtCanvasButtonComponentView", "onClick error");
    }
    AdAppBtnData localAdAppBtnData = this.downloadManager.getGdtAppBtnData();
    e locale = this.mGdtAppBtnPresenter;
    String str = this.data.id;
    int i;
    if (localAdAppBtnData != null) {
      i = localAdAppBtnData.cState;
    } else {
      i = 0;
    }
    locale.updateUIByClick(str, localAdAppBtnData, i);
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
    e locale = this.mGdtAppBtnPresenter;
    if (locale != null) {
      this.downloadManager.removePresenter(locale);
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
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.d
 * JD-Core Version:    0.7.0.1
 */