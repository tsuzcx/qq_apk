package com.tencent.ad.tangram.views.canvas.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import com.tencent.ad.tangram.statistics.b.a;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListener;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.a;
import com.tencent.ad.tangram.views.canvas.components.appbutton.c;
import com.tencent.ad.tangram.views.canvas.components.appbutton.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Keep
public class AdCanvasView
  extends FrameLayout
  implements AdAppDownloadManager.a, AdCanvasViewListener
{
  private static final int BOTTOM_FIXED_BTN_ID = 819;
  private static final String CANVAS_BAR = "iVBORw0KGgoAAAANSUhEUgAAAAIAAACgCAYAAAAmYr3BAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAAoAAAAADn/3BcAAAAe0lEQVQ4Ec1SWwoAIQi03b3R3v9s5QQN+KFCQRUU5iNncoqI/LrlwYFF49NLNZ4jITQ1MCphJCFgl50sEjwBCyDtvEzOmVmM73XwGIR2FgkL50FUbR3TnCTGt9wCdU1sN7EIZJOIzWExV7Wgw1drC+opEhpByOT07vTQaJMEPn19hHfNAAAAAElFTkSuQmCC";
  private static final String CLOSE_ICON = "iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAt0lEQVR4AWL4//9/AhBfA+J6AO11gMFADERheNnDBxQFIEAg9E4FCsgdOo+GUPzgfzxiBh/sYC83sVr1E/P6PXYeIvo8nJVBz+vEZTQZGd7V1z+uoTNmdhIOaMK4hDIuooyLKOMiyriIMi6ijIso4R4KuIAC7qF8MvDBeSjgKjrh1DT0TiWc7xRwByVcQQWcUQFnVMAZFXBGBZxRA8+yAWrgLYs3oAa+9k/bqvYTlfBR/e47EBcBAMrZsFl4ehiPAAAAAElFTkSuQmCC";
  private static final int FLOADTING_PROGRESS_BTN_ID = 273;
  private static final String TAG = "AdCanvasView";
  private static final int TOP_FIXED_BTN_ID = 546;
  private com.tencent.ad.tangram.views.canvas.components.fixedbutton.b bottomFixedButtonView;
  private RelativeLayout bottomFixedWebAppCommonButtonContainer;
  private RelativeLayout canvasViewContainer;
  private RelativeLayout closeIcon;
  private FrameLayout contentView;
  private AdCanvasData data;
  private d floatingAppBtnComponentView;
  private FrameLayout floatingProgressBar;
  private ImageView gradientLayerBg;
  private RelativeLayout keyElementsLayout;
  private boolean loadReportedForAction = false;
  private boolean loadReportedForDMP = false;
  private boolean loadSuccess = true;
  private Set<String> loadTimeIds = new HashSet();
  protected AdTimeStatistics loadTimeStatistics = new AdTimeStatistics();
  private AdAppDownloadManager mAppDownloadManager;
  private AdCanvasPageView pageView;
  private AdTimeStatistics stayTimeStatistics = new AdTimeStatistics();
  private RelativeLayout topBar;
  private com.tencent.ad.tangram.views.canvas.components.fixedbutton.b topFixedButtonView;
  
  public AdCanvasView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AdCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AdCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void addViewByOrder()
  {
    RelativeLayout localRelativeLayout = this.canvasViewContainer;
    Object localObject = this.contentView;
    localRelativeLayout.addView((View)localObject, ((FrameLayout)localObject).getLayoutParams());
    localRelativeLayout = this.canvasViewContainer;
    localObject = this.topFixedButtonView;
    localRelativeLayout.addView((View)localObject, ((com.tencent.ad.tangram.views.canvas.components.fixedbutton.b)localObject).getLayoutParams());
    localRelativeLayout = this.canvasViewContainer;
    localObject = this.bottomFixedButtonView;
    localRelativeLayout.addView((View)localObject, ((com.tencent.ad.tangram.views.canvas.components.fixedbutton.b)localObject).getLayoutParams());
    localRelativeLayout = this.canvasViewContainer;
    localObject = this.bottomFixedWebAppCommonButtonContainer;
    localRelativeLayout.addView((View)localObject, ((RelativeLayout)localObject).getLayoutParams());
    this.canvasViewContainer.addView(this.floatingProgressBar);
    localRelativeLayout = this.canvasViewContainer;
    localObject = this.topBar;
    localRelativeLayout.addView((View)localObject, ((RelativeLayout)localObject).getLayoutParams());
  }
  
  private void dealXiJingDefaultPageIfTriggleDownload()
  {
    AdCanvasData localAdCanvasData = this.data;
    if ((localAdCanvasData != null) && (localAdCanvasData.isValid()))
    {
      if (this.mAppDownloadManager == null) {
        return;
      }
      if (!this.data.ad.isAppXiJingDefault()) {
        return;
      }
      if ((!this.mAppDownloadManager.hasStartedDownload()) && (!this.data.getAutoDownLoad())) {
        return;
      }
      if (this.bottomFixedButtonView.getVisibility() == 0)
      {
        this.floatingProgressBar.setVisibility(8);
        if (this.bottomFixedButtonView.getVisibility() == 0) {
          this.bottomFixedButtonView.doClick();
        }
      }
    }
  }
  
  private Activity getActivity()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private void init()
  {
    startLoad();
    initCanvasViewContainer();
    initFloatingProgressBarContainer();
    initFixedBtnAndFloatingFixedBtnContainer();
    initTopBar();
    this.mAppDownloadManager = new AdAppDownloadManager();
    this.mAppDownloadManager.setAppDataCallback(new WeakReference(this));
    AdCanvasDownloadListener.setDownloadListener(this.mAppDownloadManager);
  }
  
  private void initCanvasViewContainer()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setOrientation(1);
    addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.keyElementsLayout = new RelativeLayout(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, AdUIUtils.getValueDependsOnScreenWidth(getContext(), 750, 70));
    localLinearLayout.addView(this.keyElementsLayout, (ViewGroup.LayoutParams)localObject);
    this.keyElementsLayout.setBackgroundColor(Color.parseColor("#F5F6F8"));
    this.keyElementsLayout.setVisibility(8);
    this.canvasViewContainer = new RelativeLayout(getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    localLinearLayout.addView(this.canvasViewContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  private void initFixedBtnAndFloatingFixedBtnContainer()
  {
    this.topFixedButtonView = new com.tencent.ad.tangram.views.canvas.components.fixedbutton.b(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.topFixedButtonView.setLayoutParams(localLayoutParams);
    this.topFixedButtonView.setVisibility(8);
    this.bottomFixedButtonView = new com.tencent.ad.tangram.views.canvas.components.fixedbutton.b(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12, -1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.bottomFixedButtonView.setElevation(10.0F);
      this.bottomFixedButtonView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
      this.bottomFixedButtonView.setStateListAnimator(null);
    }
    this.bottomFixedButtonView.setLayoutParams(localLayoutParams);
    this.bottomFixedButtonView.setVisibility(8);
    this.bottomFixedWebAppCommonButtonContainer = new RelativeLayout(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12, -1);
    this.bottomFixedWebAppCommonButtonContainer.setLayoutParams(localLayoutParams);
    this.bottomFixedWebAppCommonButtonContainer.setVisibility(8);
  }
  
  private void initFloatingProgressBarContainer()
  {
    this.floatingProgressBar = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, AdUIUtils.dp2px(40.0F, getResources()));
    this.floatingProgressBar.setId(273);
    this.floatingProgressBar.setLayoutParams(localLayoutParams);
    this.floatingProgressBar.setVisibility(8);
  }
  
  private void initTopBar()
  {
    this.topBar = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, AdUIUtils.dp2px(40.0F, getResources()));
    this.topBar.setLayoutParams(localLayoutParams1);
    this.gradientLayerBg = new ImageView(getContext());
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    this.gradientLayerBg.setLayoutParams(localLayoutParams1);
    Object localObject = AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAAAIAAACgCAYAAAAmYr3BAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAAoAAAAADn/3BcAAAAe0lEQVQ4Ec1SWwoAIQi03b3R3v9s5QQN+KFCQRUU5iNncoqI/LrlwYFF49NLNZ4jITQ1MCphJCFgl50sEjwBCyDtvEzOmVmM73XwGIR2FgkL50FUbR3TnCTGt9wCdU1sN7EIZJOIzWExV7Wgw1drC+opEhpByOT07vTQaJMEPn19hHfNAAAAAElFTkSuQmCC");
    if (localObject != null) {
      this.gradientLayerBg.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.closeIcon = new RelativeLayout(getContext());
    localObject = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(60.0F, getResources()), AdUIUtils.dp2px(60.0F, getResources()));
    this.closeIcon.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ImageView localImageView = new ImageView(getContext());
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(15.0F, getResources()), AdUIUtils.dp2px(15.0F, getResources()));
    localLayoutParams2.leftMargin = AdUIUtils.dp2px(12.0F, getResources());
    localLayoutParams2.topMargin = AdUIUtils.dp2px(12.0F, getResources());
    localImageView.setImageBitmap(AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAt0lEQVR4AWL4//9/AhBfA+J6AO11gMFADERheNnDBxQFIEAg9E4FCsgdOo+GUPzgfzxiBh/sYC83sVr1E/P6PXYeIvo8nJVBz+vEZTQZGd7V1z+uoTNmdhIOaMK4hDIuooyLKOMiyriIMi6ijIso4R4KuIAC7qF8MvDBeSjgKjrh1DT0TiWc7xRwByVcQQWcUQFnVMAZFXBGBZxRA8+yAWrgLYs3oAa+9k/bqvYTlfBR/e47EBcBAMrZsFl4ehiPAAAAAElFTkSuQmCC"));
    this.closeIcon.addView(localImageView, localLayoutParams2);
    this.closeIcon.setOnClickListener(new AdCanvasView.2(this));
    this.topBar.addView(this.gradientLayerBg, localLayoutParams1);
    this.topBar.addView(this.closeIcon, (ViewGroup.LayoutParams)localObject);
  }
  
  private void reportLoadTimeForAction(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      Object localObject1 = this.data;
      if ((localObject1 != null) && (((AdCanvasData)localObject1).isValid()))
      {
        if (this.loadReportedForAction) {
          return;
        }
        this.loadReportedForAction = true;
        b.a locala = new b.a();
        localObject1 = getActivity();
        Object localObject2 = null;
        if (localObject1 != null) {
          localObject1 = getActivity().getApplicationContext();
        } else {
          localObject1 = null;
        }
        locala.context = new WeakReference(localObject1);
        localObject1 = localObject2;
        if (getData() != null) {
          localObject1 = getData().ad;
        }
        locala.ad = ((Ad)localObject1);
        localObject1 = locala.data;
        int i;
        if (paramBoolean) {
          i = 3;
        } else {
          i = 4;
        }
        ((landing_page_collect_data.LandingPageCollectData)localObject1).landing_page_action_type = i;
        locala.data.landing_error_code = 0;
        locala.data.latency_ms = paramLong;
        com.tencent.ad.tangram.statistics.b.report(locala);
        return;
      }
    }
    AdLog.e("AdCanvasView", "reportLoadTimeForAction error");
  }
  
  private void reportPageLoaded()
  {
    if ((!this.loadReportedForDMP) && (getData() != null))
    {
      if (!getData().isValid()) {
        return;
      }
      com.tencent.ad.tangram.statistics.canvas.b.reportLoadAsync(getData().ad, getData().getAutoDownLoad());
      this.loadReportedForDMP = true;
    }
  }
  
  private void reportStayTimeForAction()
  {
    Object localObject1 = this.data;
    if ((localObject1 != null) && (((AdCanvasData)localObject1).isValid()))
    {
      b.a locala = new b.a();
      localObject1 = getActivity();
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = getActivity().getApplicationContext();
      } else {
        localObject1 = null;
      }
      locala.context = new WeakReference(localObject1);
      localObject1 = localObject2;
      if (getData() != null) {
        localObject1 = getData().ad;
      }
      locala.ad = ((Ad)localObject1);
      locala.data.landing_page_action_type = 7;
      locala.data.landing_error_code = 0;
      locala.data.latency_ms = this.stayTimeStatistics.getTime();
      com.tencent.ad.tangram.statistics.b.report(locala);
      return;
    }
    AdLog.e("AdCanvasView", "reportStayTimeForAction error");
  }
  
  private void setFixedButtonData()
  {
    Object localObject = this.data;
    if (localObject != null)
    {
      localObject = ((AdCanvasData)localObject).fixedButtonComponentDataList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.ad.tangram.views.canvas.components.fixedbutton.a locala = (com.tencent.ad.tangram.views.canvas.components.fixedbutton.a)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(locala.position)) {
            if (locala.position.toLowerCase().equals("top"))
            {
              this.topFixedButtonView.setVisibility(0);
              this.topFixedButtonView.init(getContext(), locala, this.data.ad, new WeakReference(this));
            }
            else if (locala.position.toLowerCase().equals("bottom"))
            {
              this.bottomFixedButtonView.setVisibility(0);
              this.bottomFixedButtonView.init(getContext(), locala, this.data.ad, new WeakReference(this));
            }
          }
        }
      }
    }
  }
  
  private void setFixedCommonButtonData()
  {
    Object localObject1 = this.data;
    if (localObject1 != null)
    {
      localObject1 = ((AdCanvasData)localObject1).fixedButtonComponentDataList;
      int i1 = 0;
      Object localObject2;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        k = 0;
        j = 0;
        for (m = 0;; m = 1)
        {
          n = k;
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (com.tencent.ad.tangram.views.canvas.components.fixedbutton.a)((Iterator)localObject1).next();
          k += ((com.tencent.ad.tangram.views.canvas.components.fixedbutton.a)localObject2).topWhiteSpace;
          j += ((com.tencent.ad.tangram.views.canvas.components.fixedbutton.a)localObject2).bottomWhiteSpace;
        }
      }
      int n = 0;
      int i = 0;
      int m = 0;
      localObject1 = this.data.appFixedButtonComponentDataList;
      int k = i1;
      int j = i;
      if (localObject1 != null)
      {
        k = i1;
        j = i;
        if (((ArrayList)localObject1).size() > 0)
        {
          k = 0;
          j = 0;
          while (k < ((ArrayList)localObject1).size())
          {
            int i2 = j;
            i1 = i;
            if (((ArrayList)localObject1).get(k) != null)
            {
              i2 = j;
              i1 = i;
              if ((c)((ArrayList)localObject1).get(k) != null)
              {
                localObject2 = (c)((ArrayList)localObject1).get(k);
                localObject2 = new d(getContext(), new WeakReference(this), (c)localObject2, ((c)localObject2).canShowProgress);
                this.bottomFixedWebAppCommonButtonContainer.addView((View)localObject2);
                this.bottomFixedWebAppCommonButtonContainer.setVisibility(0);
                i1 = i + ((c)((ArrayList)localObject1).get(k)).whiteSpace;
                i2 = 1;
              }
            }
            k += 1;
            j = i2;
            i = i1;
          }
          k = j;
          j = i;
        }
      }
      if ((m != 0) || (k != 0))
      {
        localObject1 = this.pageView;
        if (localObject1 != null)
        {
          localObject1 = ((AdCanvasPageView)localObject1).getContainer();
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setPadding(((LinearLayout)localObject1).getPaddingLeft(), ((LinearLayout)localObject1).getPaddingTop() + n, ((LinearLayout)localObject1).getPaddingRight(), ((LinearLayout)localObject1).getPaddingBottom() + j);
          }
        }
      }
    }
  }
  
  private void setFloatingButtonData(String paramString)
  {
    Object localObject1 = this.data;
    if (localObject1 != null)
    {
      localObject1 = ((AdCanvasData)localObject1).getPage(0);
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ((a)localObject1).components;
      if ((localObject2 != null) && (!((a)localObject1).isFloatingBarStyleSetted))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (AdCanvasComponentData)((Iterator)localObject2).next();
          if ((localObject3 != null) && ((localObject3 instanceof com.tencent.ad.tangram.views.canvas.components.pictures.a)))
          {
            localObject3 = (com.tencent.ad.tangram.views.canvas.components.pictures.a)localObject3;
            if (((com.tencent.ad.tangram.views.canvas.components.pictures.a)localObject3).imageList != null)
            {
              localObject3 = ((com.tencent.ad.tangram.views.canvas.components.pictures.a)localObject3).imageList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Object localObject4 = (com.tencent.ad.tangram.views.canvas.components.picture.a)((Iterator)localObject3).next();
                if (((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject4).id == paramString)
                {
                  ((a)localObject1).floatingBarTextColor = ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject4).floatingBarTextColor;
                  ((a)localObject1).floatingBarBackgroundColor = ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject4).floatingBarBackgroundColor;
                  localObject4 = new c();
                  ((c)localObject4).id = String.format("XJFloatingButton_%s", new Object[] { paramString });
                  ((c)localObject4).button.text.text = "下载";
                  ((c)localObject4).button.text.color = ((a)localObject1).floatingBarTextColor;
                  ((c)localObject4).button.backgroundColor = ((a)localObject1).floatingBarBackgroundColor;
                  ((c)localObject4).button.text.size = AdUIUtils.getValueDependsOnScreenWidth(getContext(), 1080, 54);
                  ((c)localObject4).button.borderWidth = 0;
                  int i = AdUIUtils.getPhysicalScreenWidth(getContext());
                  if (i <= 0) {
                    i = 1080;
                  }
                  ((c)localObject4).width = i;
                  ((c)localObject4).height = AdUIUtils.dp2px(50.0F, getContext().getResources());
                  ((c)localObject4).gravity = 17;
                  ((c)localObject4).canShowProgress = true;
                  this.floatingAppBtnComponentView = new d(getContext(), new WeakReference(this), (c)localObject4, true);
                  localObject4 = new FrameLayout.LayoutParams(-1, -1);
                  this.floatingProgressBar.addView(this.floatingAppBtnComponentView, (ViewGroup.LayoutParams)localObject4);
                  this.floatingProgressBar.setVisibility(8);
                  ((a)localObject1).isFloatingBarStyleSetted = true;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void showProgressBarIfTriggleDownload()
  {
    Object localObject = this.data;
    if (localObject != null)
    {
      if (this.mAppDownloadManager == null) {
        return;
      }
      localObject = ((AdCanvasData)localObject).firstPictureComponentIdWithHotArea;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      if ((!this.mAppDownloadManager.hasStartedDownload()) && (!this.data.getAutoDownLoad())) {
        return;
      }
      setFloatingButtonData((String)localObject);
      if (this.floatingAppBtnComponentView == null) {
        return;
      }
      if ((this.data.ad != null) && (!this.data.ad.isAppProductType())) {
        return;
      }
      showProgressBar((String)localObject, false);
    }
  }
  
  public boolean back()
  {
    AdCanvasPageView localAdCanvasPageView = this.pageView;
    if ((localAdCanvasPageView != null) && (localAdCanvasPageView.back())) {
      return true;
    }
    if (getActivity() != null)
    {
      getActivity().finish();
      return true;
    }
    return false;
  }
  
  public AdCanvasPageView getContentView()
  {
    return this.pageView;
  }
  
  public AdCanvasData getData()
  {
    return this.data;
  }
  
  public AdAppDownloadManager getDownloadManager()
  {
    return this.mAppDownloadManager;
  }
  
  public int getPageViewScrollY()
  {
    AdCanvasPageView localAdCanvasPageView = this.pageView;
    if (localAdCanvasPageView != null) {
      return localAdCanvasPageView.getScrollY();
    }
    return 0;
  }
  
  public void hideBar()
  {
    Object localObject = this.closeIcon;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(8);
    }
    localObject = this.gradientLayerBg;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public void hotAreaClick(String paramString1, String paramString2, String paramString3)
  {
    if (("top".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      showProgressBar(paramString2, true);
    }
  }
  
  public void onActivityDestroy()
  {
    AdLog.i("AdCanvasView", "onActivityDestroy");
    Object localObject = this.pageView;
    if (localObject != null) {
      ((AdCanvasPageView)localObject).onActivityDestroy();
    }
    localObject = this.topFixedButtonView;
    if ((localObject != null) && (((com.tencent.ad.tangram.views.canvas.components.fixedbutton.b)localObject).getVisibility() == 0)) {
      this.topFixedButtonView.onActivityDestroy();
    }
    localObject = this.bottomFixedButtonView;
    if ((localObject != null) && (((com.tencent.ad.tangram.views.canvas.components.fixedbutton.b)localObject).getVisibility() == 0)) {
      this.bottomFixedButtonView.onActivityDestroy();
    }
    localObject = this.floatingAppBtnComponentView;
    if (localObject != null) {
      ((d)localObject).onActivityDestroy();
    }
    localObject = this.mAppDownloadManager;
    if (localObject != null)
    {
      ((AdAppDownloadManager)localObject).onDestroy();
      this.mAppDownloadManager = null;
    }
    AdCanvasDownloadListener.removeDownloadListener(this.mAppDownloadManager);
    reportStayTimeForAction();
    reportLoadTimeForAction(this.stayTimeStatistics.getTime(), false);
  }
  
  public void onActivityPause()
  {
    AdCanvasPageView localAdCanvasPageView = this.pageView;
    if (localAdCanvasPageView != null) {
      localAdCanvasPageView.onActivityPause();
    }
    this.stayTimeStatistics.stop();
  }
  
  public void onActivityResume()
  {
    AdLog.i("AdCanvasView", "onActivityResume");
    if (this.pageView != null)
    {
      this.mAppDownloadManager.fetchDownloadStatus(new AdCanvasView.1(this));
      this.pageView.onActivityResume();
      Object localObject = this.mAppDownloadManager;
      if (localObject != null) {
        ((AdAppDownloadManager)localObject).onActivityResume();
      }
      localObject = this.topFixedButtonView;
      if ((localObject != null) && (((com.tencent.ad.tangram.views.canvas.components.fixedbutton.b)localObject).getVisibility() == 0)) {
        this.topFixedButtonView.onActivityResume();
      }
      localObject = this.bottomFixedButtonView;
      if ((localObject != null) && (((com.tencent.ad.tangram.views.canvas.components.fixedbutton.b)localObject).getVisibility() == 0)) {
        this.bottomFixedButtonView.onActivityResume();
      }
      localObject = this.floatingAppBtnComponentView;
      if (localObject != null) {
        ((d)localObject).onActivityResume();
      }
      if (this.bottomFixedWebAppCommonButtonContainer != null)
      {
        int i = 0;
        while (i < this.bottomFixedWebAppCommonButtonContainer.getChildCount())
        {
          localObject = this.bottomFixedWebAppCommonButtonContainer.getChildAt(i);
          if ((localObject != null) && ((localObject instanceof AdCanvasComponentView))) {
            ((AdCanvasComponentView)localObject).onActivityResume();
          }
          i += 1;
        }
      }
      reportPageLoaded();
      this.stayTimeStatistics.start();
    }
  }
  
  public void onFetchSuccess(AdAppBtnData paramAdAppBtnData)
  {
    if (paramAdAppBtnData == null) {
      return;
    }
    String str1 = paramAdAppBtnData.name;
    String str2 = paramAdAppBtnData.authorName;
    paramAdAppBtnData = paramAdAppBtnData.versionName;
    String str3 = getData().appInfoRightUrl;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramAdAppBtnData)))
    {
      if (TextUtils.isEmpty(str3)) {
        return;
      }
      AdThreadManager.INSTANCE.post(new AdCanvasView.3(this, str3, str1, paramAdAppBtnData, str2), 0);
    }
  }
  
  public void onLoaded(AdCanvasComponentData paramAdCanvasComponentData, long paramLong, boolean paramBoolean)
  {
    if ((paramAdCanvasComponentData != null) && (paramAdCanvasComponentData.isValid()) && (getData() != null) && (getData().isValid()))
    {
      if ((!this.loadReportedForAction) && (this.loadTimeIds != null) && (paramAdCanvasComponentData.isAddToLoadStatistics))
      {
        this.loadSuccess &= paramBoolean;
        this.loadTimeIds.add(paramAdCanvasComponentData.id);
        if (this.loadTimeIds.size() == getData().getToLoadIdsize()) {
          reportLoadTimeForAction(stopLoad(), this.loadSuccess);
        }
      }
      return;
    }
    AdLog.e("AdCanvasView", "onLoaded error");
  }
  
  public void setData(AdCanvasData paramAdCanvasData)
  {
    if (paramAdCanvasData != null)
    {
      if (!paramAdCanvasData.isValid()) {
        return;
      }
      this.data = paramAdCanvasData;
      if (!this.data.ad.isAppProductType()) {
        this.data.setAutodownload(false);
      }
      if (this.data.getPage(0) != null) {
        setBackgroundColor(this.data.getPage(0).backgroundColor);
      }
      this.topFixedButtonView.setId(546);
      this.bottomFixedButtonView.setId(819);
      this.contentView = new FrameLayout(getContext());
      paramAdCanvasData = new RelativeLayout.LayoutParams(-1, -2);
      paramAdCanvasData.addRule(3, this.topFixedButtonView.getId());
      this.contentView.setLayoutParams(paramAdCanvasData);
      this.pageView = new AdCanvasPageView(getContext(), new WeakReference(this), this.data.getPage(0));
      this.contentView.addView(this.pageView);
      setFixedButtonData();
      setFixedCommonButtonData();
      showProgressBarIfTriggleDownload();
      dealXiJingDefaultPageIfTriggleDownload();
      if ((this.data.isPageWithoutButton()) && (!TextUtils.isEmpty(this.data.firstPictureComponentIdWithHotArea))) {
        setFloatingButtonData(this.data.firstPictureComponentIdWithHotArea);
      }
      addViewByOrder();
    }
  }
  
  public void setPageViewTopMargin(int paramInt)
  {
    AdCanvasPageView localAdCanvasPageView = this.pageView;
    if (localAdCanvasPageView != null) {
      localAdCanvasPageView.setPageViewLayoutParams(paramInt);
    }
  }
  
  public void showFloatingProgressButton()
  {
    if ((this.topFixedButtonView.getVisibility() != 0) && (this.bottomFixedButtonView.getVisibility() != 0) && (this.bottomFixedWebAppCommonButtonContainer.getChildCount() <= 0))
    {
      Object localObject = this.floatingProgressBar;
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() != 0))
      {
        if (!this.data.hasMultiPictureData) {
          return;
        }
        this.floatingProgressBar.setVisibility(0);
        localObject = (RelativeLayout.LayoutParams)this.contentView.getLayoutParams();
        if (localObject == null) {
          return;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.floatingProgressBar.getId());
      }
    }
  }
  
  public void showProgressBar(String paramString, boolean paramBoolean)
  {
    if ((this.topFixedButtonView.getVisibility() == 0) || (this.bottomFixedButtonView.getVisibility() == 0))
    {
      this.floatingProgressBar.setVisibility(8);
      if (this.topFixedButtonView.getVisibility() == 0)
      {
        this.topFixedButtonView.doClick();
        return;
      }
      if (this.bottomFixedButtonView.getVisibility() == 0)
      {
        this.bottomFixedButtonView.doClick();
        return;
      }
    }
    if (this.bottomFixedWebAppCommonButtonContainer.getChildCount() > 0)
    {
      if (paramBoolean)
      {
        int i = 0;
        while (i < this.bottomFixedWebAppCommonButtonContainer.getChildCount())
        {
          paramString = this.bottomFixedWebAppCommonButtonContainer.getChildAt(i);
          if ((paramString != null) && ((paramString instanceof d)))
          {
            paramString = (d)paramString;
            if ((paramString.getData() != null) && (paramString.getData().canShowProgress)) {
              paramString.doClick();
            }
          }
          i += 1;
        }
      }
      return;
    }
    if (this.floatingProgressBar.getVisibility() == 8) {
      setFloatingButtonData(paramString);
    }
    showFloatingProgressButton();
    if (paramBoolean)
    {
      paramString = this.floatingAppBtnComponentView;
      if (paramString != null) {
        paramString.doClick();
      }
    }
    paramString = (RelativeLayout.LayoutParams)this.contentView.getLayoutParams();
    if (this.floatingProgressBar.getVisibility() == 0) {
      paramString.addRule(3, this.floatingProgressBar.getId());
    }
  }
  
  protected void startLoad()
  {
    AdTimeStatistics localAdTimeStatistics = this.loadTimeStatistics;
    if (localAdTimeStatistics != null) {
      localAdTimeStatistics.start();
    }
  }
  
  protected long stopLoad()
  {
    AdTimeStatistics localAdTimeStatistics = this.loadTimeStatistics;
    long l;
    if (localAdTimeStatistics != null)
    {
      localAdTimeStatistics.stop();
      l = this.loadTimeStatistics.getTime();
    }
    else
    {
      l = -2147483648L;
    }
    this.loadTimeStatistics = null;
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.AdCanvasView
 * JD-Core Version:    0.7.0.1
 */