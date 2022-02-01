package com.tencent.ad.tangram.canvas.views.canvas.components.form;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;
import com.tencent.ad.tangram.ark.AdArkAdapter.DataParams;
import com.tencent.ad.tangram.ark.AdArkAdapter.Params;
import com.tencent.ad.tangram.ark.AdArkView;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.a.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
  implements AdArkAdapter.Callback
{
  private static final String TAG = "GdtCanvasFormComponentView";
  private a data;
  private boolean focused = false;
  private boolean formPaused = true;
  private int lastInputRectBottom;
  private View mArkView;
  private ViewGroup.MarginLayoutParams mLayoutParams;
  private int mUsableHeightPrevious;
  private String metadata;
  private int previousTopMargin = 0;
  private long startLoadingArkTime;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama);
  }
  
  private boolean checkCanNotResize(View paramView)
  {
    if (!this.focused) {}
    while ((paramView == null) || (paramView.getRootView() == null) || (this.mArkView == null) || (getContext() == null) || (this.formPaused) || (this.canvasViewListener == null) || (this.canvasViewListener.get() == null)) {
      return true;
    }
    return false;
  }
  
  private void doResize(View paramView, int paramInt)
  {
    if ((paramView == null) || (this.mArkView == null)) {}
    Rect localRect;
    do
    {
      return;
      j = paramView.getRootView().getHeight();
      i = j - paramInt;
      if (i <= j / 4) {
        break;
      }
      localRect = AdArkView.getArkInputRect(this.mArkView);
    } while (localRect == null);
    int[] arrayOfInt = new int[2];
    this.mArkView.getLocationOnScreen(arrayOfInt);
    this.lastInputRectBottom = arrayOfInt[1];
    int j = AdUIUtils.getValueDependsOnScreenWidth(getContext(), this.mArkView.getWidth(), localRect.bottom) + arrayOfInt[1];
    int i = AdUIUtils.getScreenHeight(getContext()) - i;
    if (i < j)
    {
      AdThreadManager.INSTANCE.postDelayed(new b.1(this, i - j, paramView), 0, 5L);
      this.mArkView.clearFocus();
      this.mArkView.post(new b.2(this));
    }
    for (;;)
    {
      this.mUsableHeightPrevious = paramInt;
      return;
      ((AdCanvasViewListener)this.canvasViewListener.get()).setPageViewTopMargin(this.previousTopMargin);
    }
  }
  
  private void init(Context paramContext, a parama)
  {
    startLoad();
    if ((parama == null) || (TextUtils.isEmpty(parama.id)))
    {
      AdLog.e("GdtCanvasFormComponentView", "init error");
      stopLoad(false);
      return;
    }
    this.data = parama;
    initViews(paramContext);
    this.status = new AdViewStatus(new WeakReference(this), new WeakReference(this));
    stopLoad(true);
  }
  
  private void initArkFormView(Context paramContext)
  {
    AdArkAdapter.Params localParams = new AdArkAdapter.Params();
    localParams.context = new WeakReference(paramContext);
    localParams.callback = new WeakReference(this);
    localParams.metaData = this.metadata;
    this.mArkView = AdArkView.buildArkView(localParams);
    if (this.mArkView == null) {}
    do
    {
      return;
      addView(this.mArkView);
      this.mLayoutParams = ((ViewGroup.MarginLayoutParams)this.mArkView.getLayoutParams());
    } while (this.mLayoutParams == null);
    this.previousTopMargin = this.mLayoutParams.topMargin;
  }
  
  private void initViews(Context paramContext)
  {
    if (!isValid()) {
      AdLog.e("GdtCanvasFormComponentView", "initViews error");
    }
    do
    {
      return;
      setFocusable(true);
      setFocusableInTouchMode(true);
      reportArkStartLoad();
    } while (!makeArkFormData());
    this.startLoadingArkTime = SystemClock.elapsedRealtime();
    initArkFormView(paramContext);
  }
  
  private boolean isValid()
  {
    return (getData() != null) && (getData().isValid()) && (getCanvasData() != null) && (getCanvasData().isValid()) && (getCanvasData().ad.getActionSetId() != -2147483648L);
  }
  
  private boolean makeArkFormData()
  {
    if ((getCanvasData() == null) || (getCanvasData().ad == null)) {}
    do
    {
      return false;
      Ad localAd = getCanvasData().ad;
      AdArkAdapter.DataParams localDataParams = new AdArkAdapter.DataParams();
      localDataParams.advertiser_id = localAd.getAdvertiserId();
      localDataParams.canvas_json = localAd.getCanvas();
      localDataParams.dest_type = localAd.getDestType();
      localDataParams.product_type = localAd.getProductType();
      localDataParams.landing_page_report_url = localAd.getUrlForAction();
      localDataParams.traceid = localAd.getTraceId();
      localDataParams.form_module_id = this.data.id;
      localDataParams.index = this.data.index;
      this.metadata = AdArkView.getArkFormData(localDataParams);
    } while (TextUtils.isEmpty(this.metadata));
    return true;
  }
  
  private void reportArkLoadSuccess(long paramLong)
  {
    a.a locala = new a.a();
    locala.context = new WeakReference(getContext());
    if (getCanvasData() != null) {}
    for (Ad localAd = getCanvasData().ad;; localAd = null)
    {
      locala.ad = localAd;
      locala.data.landing_page_action_type = 62;
      locala.data.landing_error_code = 0;
      locala.data.latency_ms = (paramLong - this.startLoadingArkTime);
      com.tencent.ad.tangram.statistics.a.report(locala);
      return;
    }
  }
  
  private void reportArkStartLoad()
  {
    a.a locala = new a.a();
    locala.context = new WeakReference(getContext());
    if (getCanvasData() != null) {}
    for (Ad localAd = getCanvasData().ad;; localAd = null)
    {
      locala.ad = localAd;
      locala.data.landing_page_action_type = 61;
      locala.data.landing_error_code = 0;
      locala.data.latency_ms = 0L;
      com.tencent.ad.tangram.statistics.a.report(locala);
      return;
    }
  }
  
  private void resizeArkViewWhenKeyboardExist(View paramView)
  {
    if (checkCanNotResize(paramView)) {}
    int i;
    do
    {
      return;
      Rect localRect = new Rect();
      if (paramView != null) {
        paramView.getWindowVisibleDisplayFrame(localRect);
      }
      i = localRect.bottom - localRect.top;
    } while (i == this.mUsableHeightPrevious);
    doResize(paramView, i);
  }
  
  private void resizeArkViewWhenKeyboardExistAgain(View paramView)
  {
    if (checkCanNotResize(paramView)) {}
    int i;
    do
    {
      return;
      Rect localRect = new Rect();
      if (paramView != null) {
        paramView.getWindowVisibleDisplayFrame(localRect);
      }
      i = localRect.bottom - localRect.top;
    } while (i != this.mUsableHeightPrevious);
    doResize(paramView, i);
  }
  
  public void firstPaint(long paramLong)
  {
    reportArkLoadSuccess(paramLong);
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void loadSucc() {}
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    this.focused = paramBoolean;
    if ((paramBoolean) || (this.canvasViewListener == null) || (this.canvasViewListener.get() == null)) {
      return;
    }
    ((AdCanvasViewListener)this.canvasViewListener.get()).setPageViewTopMargin(0);
  }
  
  public void onGlobalLayout(View paramView)
  {
    resizeArkViewWhenKeyboardExist(paramView);
  }
  
  public void onHideMenu(View paramView) {}
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onViewPause()
  {
    super.onViewPause();
    this.formPaused = true;
  }
  
  public void onViewResume()
  {
    super.onViewResume();
    this.formPaused = false;
  }
  
  public void setFocused(boolean paramBoolean)
  {
    this.focused = paramBoolean;
    if ((!paramBoolean) && (getContext() != null)) {
      this.mUsableHeightPrevious = AdUIUtils.getScreenHeight(getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.form.b
 * JD-Core Version:    0.7.0.1
 */