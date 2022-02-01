package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.ark.AdArkAdapter.ArkNotifyCallback;
import com.tencent.ad.tangram.ark.AdArkAdapter.Params;
import com.tencent.ad.tangram.ark.AdArkView;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListener;
import com.tencent.ad.tangram.canvas.report.AdDMPReportUtil;
import com.tencent.ad.tangram.canvas.resource.AdResource;
import com.tencent.ad.tangram.canvas.statistics.AdTimeStatistics;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import com.tencent.ad.tangram.statistics.a.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class AdCanvasView
  extends FrameLayout
  implements AdArkAdapter.ArkNotifyCallback, AdCanvasViewListener
{
  private static final int BOTTOM_FIXED_BTN_ID = 819;
  private static final String CANVAS_BAR = "iVBORw0KGgoAAAANSUhEUgAAAAIAAACgCAYAAAAmYr3BAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAAoAAAAADn/3BcAAAAe0lEQVQ4Ec1SWwoAIQi03b3R3v9s5QQN+KFCQRUU5iNncoqI/LrlwYFF49NLNZ4jITQ1MCphJCFgl50sEjwBCyDtvEzOmVmM73XwGIR2FgkL50FUbR3TnCTGt9wCdU1sN7EIZJOIzWExV7Wgw1drC+opEhpByOT07vTQaJMEPn19hHfNAAAAAElFTkSuQmCC";
  private static final String CLOSE_ICON = "iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAt0lEQVR4AWL4//9/AhBfA+J6AO11gMFADERheNnDBxQFIEAg9E4FCsgdOo+GUPzgfzxiBh/sYC83sVr1E/P6PXYeIvo8nJVBz+vEZTQZGd7V1z+uoTNmdhIOaMK4hDIuooyLKOMiyriIMi6ijIso4R4KuIAC7qF8MvDBeSjgKjrh1DT0TiWc7xRwByVcQQWcUQFnVMAZFXBGBZxRA8+yAWrgLYs3oAa+9k/bqvYTlfBR/e47EBcBAMrZsFl4ehiPAAAAAElFTkSuQmCC";
  private static final int FLOADTING_PROGRESS_BTN_ID = 273;
  private static final String TAG = "AdCanvasView";
  private static final int TOP_FIXED_BTN_ID = 546;
  private com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.b bottomFixedButtonView;
  private RelativeLayout bottomFixedWebAppCommonButtonContainer;
  private RelativeLayout canvasViewContainer;
  private RelativeLayout closeIcon;
  private FrameLayout contentView;
  private AdCanvasData data;
  private d floatingAppBtnComponentView;
  private FrameLayout floatingProgressBar;
  private ImageView gradientLayerBg;
  public String lastTouchFormModuleId = null;
  private boolean loadReportedForAction = false;
  private boolean loadReportedForDMP = false;
  private boolean loadSuccess = true;
  private Set<String> loadTimeIds = new HashSet();
  protected AdTimeStatistics loadTimeStatistics = new AdTimeStatistics();
  private AdAppDownloadManager mAppDownloadManager;
  private PopupWindow mPopupWindow;
  private AdCanvasPageView pageView;
  private AdTimeStatistics stayTimeStatistics = new AdTimeStatistics();
  private RelativeLayout topBar;
  private com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.b topFixedButtonView;
  
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
    this.canvasViewContainer.addView(this.contentView, this.contentView.getLayoutParams());
    this.canvasViewContainer.addView(this.topFixedButtonView, this.topFixedButtonView.getLayoutParams());
    this.canvasViewContainer.addView(this.bottomFixedButtonView, this.bottomFixedButtonView.getLayoutParams());
    this.canvasViewContainer.addView(this.bottomFixedWebAppCommonButtonContainer, this.bottomFixedWebAppCommonButtonContainer.getLayoutParams());
    this.canvasViewContainer.addView(this.floatingProgressBar);
    this.canvasViewContainer.addView(this.topBar, this.topBar.getLayoutParams());
  }
  
  private void arkShowLoading(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("action");
      if ("show".equals(paramString))
      {
        if ((getContext() != null) && (getResources() != null)) {
          AdProgressDialog.show(getContext(), AdUIUtils.dp2px(60.0F, getResources()));
        }
      }
      else if ("hide".equals(paramString))
      {
        AdProgressDialog.dismiss();
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void arkShowSelectWindow(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("action");
      if ("show".equals(str1))
      {
        int i = paramString.optInt("width");
        int j = paramString.getInt("height");
        Object localObject = paramString.getJSONObject("meta");
        paramString = ((JSONObject)localObject).getString("app");
        str1 = ((JSONObject)localObject).getString("view");
        String str2 = ((JSONObject)localObject).getString("ver");
        localObject = ((JSONObject)localObject).getJSONObject("meta").toString();
        AdThreadManager.INSTANCE.post(new AdCanvasView.3(this, i, j, paramString, str1, str2, (String)localObject), 0);
        return;
      }
      if ("hide".equals(str1))
      {
        AdThreadManager.INSTANCE.post(new AdCanvasView.4(this), 0);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void arkShowToast(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("type");
      String str = paramString.getString("text");
      int j = paramString.getInt("duration");
      AdToast.show(getContext(), i, str, j);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void arkViewResize(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.pageView == null))
    {
      AdLog.e("AdCanvasView", "arkViewResize error");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("formModuleId");
      int i = paramString.getInt("width");
      int j = paramString.getInt("height");
      this.pageView.resizeArkFormView(str, i, j);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void dealXiJingDefaultPageIfTriggleDownload()
  {
    if ((this.data == null) || (!this.data.isValid())) {}
    do
    {
      do
      {
        return;
      } while ((!this.data.ad.isAppXiJingDefault()) || ((!this.mAppDownloadManager.hasStartedDownload()) && ((!this.data.getAutoDownLoad()) || (!AdNet.isWifiConnected(getContext())))) || (this.bottomFixedButtonView.getVisibility() != 0));
      this.floatingProgressBar.setVisibility(8);
    } while (this.bottomFixedButtonView.getVisibility() != 0);
    this.bottomFixedButtonView.doClick();
  }
  
  private Activity getActivity()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private void getLastTouchFormModuleId(String paramString)
  {
    try
    {
      this.lastTouchFormModuleId = new JSONObject(paramString).getString("formModuleId");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void init()
  {
    startLoad();
    initCanvasViewContainer();
    initFloatingProgressBarContainer();
    initFixedBtnAndFloatingFixedBtnContainer();
    initTopBar();
    AdArkView.setNotify(new WeakReference(this));
    this.mAppDownloadManager = new AdAppDownloadManager();
    AdCanvasDownloadListener.setDownloadListener(this.mAppDownloadManager);
  }
  
  private void initArkSelectWindow(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString3 = new AdArkAdapter.Params();
    paramString3.context = new WeakReference(getContext());
    paramString3.metaData = paramString4;
    paramString3.appName = paramString1;
    paramString3.viewName = paramString2;
    paramString1 = AdArkView.buildSelectWindowArkView(paramString3);
    this.mPopupWindow = new PopupWindow();
    paramString2 = (RelativeLayout)LayoutInflater.from(getContext()).inflate(AdResource.getArkWindowLayoutId(), null);
    paramString2.addView(paramString1);
    this.mPopupWindow.setContentView(paramString2);
    this.mPopupWindow.setWidth(-1);
    this.mPopupWindow.setHeight(paramInt2);
    this.mPopupWindow.setTouchable(true);
    this.mPopupWindow.setOutsideTouchable(true);
    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(-1));
    this.mPopupWindow.showAtLocation(LayoutInflater.from(getContext()).inflate(AdResource.getCanvasLayoutId(), null), 81, 0, 0);
  }
  
  private void initCanvasViewContainer()
  {
    this.canvasViewContainer = new RelativeLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.canvasViewContainer, localLayoutParams);
  }
  
  private void initFixedBtnAndFloatingFixedBtnContainer()
  {
    this.topFixedButtonView = new com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.b(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.topFixedButtonView.setLayoutParams(localLayoutParams);
    this.topFixedButtonView.setVisibility(8);
    this.bottomFixedButtonView = new com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.b(getContext());
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
    Object localObject2 = null;
    if ((paramLong < 0L) || (this.data == null) || (!this.data.isValid())) {
      AdLog.e("AdCanvasView", "reportLoadTimeForAction error");
    }
    while (this.loadReportedForAction) {
      return;
    }
    this.loadReportedForAction = true;
    a.a locala = new a.a();
    Object localObject1;
    if (getActivity() != null)
    {
      localObject1 = getActivity().getApplicationContext();
      locala.context = new WeakReference(localObject1);
      localObject1 = localObject2;
      if (getData() != null) {
        localObject1 = getData().ad;
      }
      locala.ad = ((Ad)localObject1);
      localObject1 = locala.data;
      if (!paramBoolean) {
        break label164;
      }
    }
    label164:
    for (int i = 3;; i = 4)
    {
      ((landing_page_collect_data.LandingPageCollectData)localObject1).landing_page_action_type = i;
      locala.data.landing_error_code = 0;
      locala.data.latency_ms = paramLong;
      com.tencent.ad.tangram.statistics.a.report(locala);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private void reportPageLoaded()
  {
    if ((this.loadReportedForDMP) || (getData() == null) || (!getData().isValid())) {
      return;
    }
    AdDMPReportUtil.reportLoadAsync(getData().ad, getData().getAutoDownLoad());
    this.loadReportedForDMP = true;
  }
  
  private void reportStayTimeForAction()
  {
    Object localObject2 = null;
    if ((this.data == null) || (!this.data.isValid()))
    {
      AdLog.e("AdCanvasView", "reportStayTimeForAction error");
      return;
    }
    a.a locala = new a.a();
    if (getActivity() != null) {}
    for (Object localObject1 = getActivity().getApplicationContext();; localObject1 = null)
    {
      locala.context = new WeakReference(localObject1);
      localObject1 = localObject2;
      if (getData() != null) {
        localObject1 = getData().ad;
      }
      locala.ad = ((Ad)localObject1);
      locala.data.landing_page_action_type = 7;
      locala.data.landing_error_code = 0;
      locala.data.latency_ms = this.stayTimeStatistics.getTime();
      com.tencent.ad.tangram.statistics.a.report(locala);
      return;
    }
  }
  
  private void setFixedButtonData()
  {
    if (this.data != null)
    {
      Object localObject = this.data.fixedButtonComponentDataList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a locala = (com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)((Iterator)localObject).next();
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
    int i2 = 0;
    Object localObject1;
    int j;
    int k;
    int i;
    Object localObject2;
    int n;
    int m;
    if (this.data != null)
    {
      localObject1 = this.data.fixedButtonComponentDataList;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label478;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      j = 0;
      k = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)((Iterator)localObject1).next();
        i += ((com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)localObject2).topWhiteSpace;
        k = ((com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)localObject2).bottomWhiteSpace + k;
        j = 1;
      }
      n = k;
      m = i;
      k = j;
      i = n;
    }
    for (;;)
    {
      localObject1 = this.data.webFixedButtonComponentDataList;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        n = 0;
        j = i;
        for (i = n; ((Iterator)localObject1).hasNext(); i = 1)
        {
          localObject2 = (com.tencent.ad.tangram.canvas.views.canvas.components.button.a)((Iterator)localObject1).next();
          if (!((com.tencent.ad.tangram.canvas.views.canvas.components.button.a)localObject2).isFixed) {
            break label469;
          }
          com.tencent.ad.tangram.canvas.views.canvas.components.button.b localb = new com.tencent.ad.tangram.canvas.views.canvas.components.button.b(getContext(), new WeakReference(this), (com.tencent.ad.tangram.canvas.views.canvas.components.button.a)localObject2);
          this.bottomFixedWebAppCommonButtonContainer.addView(localb);
          this.bottomFixedWebAppCommonButtonContainer.setVisibility(0);
          j += ((com.tencent.ad.tangram.canvas.views.canvas.components.button.a)localObject2).whiteSpace;
        }
        n = i;
        i = j;
      }
      for (;;)
      {
        localObject1 = this.data.appFixedButtonComponentDataList;
        int i1 = i;
        j = i2;
        if (localObject1 != null)
        {
          i1 = i;
          j = i2;
          if (((ArrayList)localObject1).size() > 0)
          {
            i1 = 0;
            j = 0;
            while (i1 < ((ArrayList)localObject1).size())
            {
              int i3 = j;
              i2 = i;
              if (((ArrayList)localObject1).get(i1) != null)
              {
                i3 = j;
                i2 = i;
                if ((c)((ArrayList)localObject1).get(i1) != null)
                {
                  localObject2 = (c)((ArrayList)localObject1).get(i1);
                  localObject2 = new d(getContext(), new WeakReference(this), (c)localObject2, ((c)localObject2).canShowProgress);
                  this.bottomFixedWebAppCommonButtonContainer.addView((View)localObject2);
                  this.bottomFixedWebAppCommonButtonContainer.setVisibility(0);
                  i2 = i + ((c)((ArrayList)localObject1).get(i1)).whiteSpace;
                  i3 = 1;
                }
              }
              i1 += 1;
              j = i3;
              i = i2;
            }
            i1 = i;
          }
        }
        if (((n != 0) || (k != 0) || (j != 0)) && (this.pageView != null))
        {
          localObject1 = this.pageView.getContainer();
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setPadding(((LinearLayout)localObject1).getPaddingLeft(), ((LinearLayout)localObject1).getPaddingTop() + m, ((LinearLayout)localObject1).getPaddingRight(), i1 + ((LinearLayout)localObject1).getPaddingBottom());
          }
        }
        return;
        label469:
        break;
        n = 0;
      }
      label478:
      k = 0;
      i = 0;
      m = 0;
    }
  }
  
  private void setFloatingButtonData(String paramString)
  {
    a locala;
    if (this.data != null)
    {
      locala = this.data.getPage(0);
      if (locala != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
        Object localObject1;
        while (!((Iterator)localObject1).hasNext())
        {
          do
          {
            localObject1 = locala.components;
          } while ((localObject1 == null) || (locala.isFloatingBarStyleSetted));
          localObject1 = ((List)localObject1).iterator();
        }
        localObject2 = (AdCanvasComponentData)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (!(localObject2 instanceof com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)));
      localObject2 = (com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)localObject2;
    } while (((com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)localObject2).imageList == null);
    Object localObject2 = ((com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)localObject2).imageList.iterator();
    label108:
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)((Iterator)localObject2).next();
      if (((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject3).id == paramString)
      {
        locala.floatingBarTextColor = ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject3).floatingBarTextColor;
        locala.floatingBarBackgroundColor = ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject3).floatingBarBackgroundColor;
        localObject3 = new c();
        ((c)localObject3).id = String.format("XJFloatingButton_%s", new Object[] { paramString });
        ((c)localObject3).button.text.text = "下载";
        ((c)localObject3).button.text.color = locala.floatingBarTextColor;
        ((c)localObject3).button.backgroundColor = locala.floatingBarBackgroundColor;
        ((c)localObject3).button.text.size = AdUIUtils.getValueDependsOnScreenWidth(getContext(), 1080, 54);
        ((c)localObject3).button.borderWidth = 0;
        i = AdUIUtils.getPhysicalScreenWidth(getContext());
        if (i <= 0) {
          break label374;
        }
      }
    }
    for (;;)
    {
      ((c)localObject3).width = i;
      ((c)localObject3).height = AdUIUtils.dp2px(50.0F, getContext().getResources());
      ((c)localObject3).gravity = 17;
      ((c)localObject3).canShowProgress = true;
      this.floatingAppBtnComponentView = new d(getContext(), new WeakReference(this), (c)localObject3, true);
      localObject3 = new FrameLayout.LayoutParams(-1, -1);
      this.floatingProgressBar.addView(this.floatingAppBtnComponentView, (ViewGroup.LayoutParams)localObject3);
      this.floatingProgressBar.setVisibility(8);
      locala.isFloatingBarStyleSetted = true;
      break label108;
      break;
      label374:
      i = 1080;
    }
  }
  
  private void showProgressBarIfTriggleDownload()
  {
    if (this.data == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = this.data.firstPictureComponentIdWithHotArea;
      } while ((TextUtils.isEmpty(str)) || ((!this.mAppDownloadManager.hasStartedDownload()) && ((!this.data.getAutoDownLoad()) || (!AdNet.isWifiConnected(getContext())))));
      setFloatingButtonData(str);
    } while ((this.floatingAppBtnComponentView == null) || ((this.data.ad != null) && (!this.data.ad.isAppProductType())));
    showProgressBar(str, false);
  }
  
  public boolean back()
  {
    if ((this.pageView != null) && (this.pageView.back())) {
      return true;
    }
    if (getActivity() != null)
    {
      getActivity().finish();
      return true;
    }
    return false;
  }
  
  public void commonButtonClick(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (("backTop".equals(paramString1)) && (this.pageView != null)) {
      this.pageView.fullScroll(33);
    }
    if (("form".equals(paramString1)) && (this.pageView != null)) {
      this.pageView.scrollToArkFormView(paramString3);
    }
    if (("link".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      AdLog.d("AdCanvasView", "click link :" + paramString2);
      if ((this.data == null) || (!this.data.isValid())) {
        break label161;
      }
      AdDMPReportUtil.reportOpenWebPageAsync(this.data.ad);
      paramString3 = new WeakReference(getActivity());
      if (getData() == null) {
        break label172;
      }
    }
    label161:
    label172:
    for (paramString1 = getData().ad;; paramString1 = null)
    {
      AdBrowser.show(paramString3, paramString1, paramString2, null);
      return;
      AdLog.e("AdCanvasView", "reportOpenWebPageAsync error");
      break;
    }
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
    if (this.pageView != null) {
      return this.pageView.getScrollY();
    }
    return 0;
  }
  
  public void hideBar()
  {
    if (this.closeIcon != null) {
      this.closeIcon.setVisibility(8);
    }
    if (this.gradientLayerBg != null) {
      this.gradientLayerBg.setVisibility(8);
    }
  }
  
  public void hotAreaClick(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("backTop".equals(paramString1)) {
      commonButtonClick(paramString1, false, paramString3, paramString4);
    }
    if (("form".equals(paramString1)) && (!TextUtils.isEmpty(paramString4))) {
      commonButtonClick(paramString1, false, paramString3, paramString4);
    }
    if (("link".equals(paramString1)) && (!TextUtils.isEmpty(paramString3))) {
      commonButtonClick(paramString1, false, paramString3, paramString4);
    }
    if (("top".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      showProgressBar(paramString2, true);
    }
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals("toast_event"))
    {
      AdLog.d("AdCanvasView", "toast_event" + paramString3);
      arkShowToast(paramString3);
    }
    for (;;)
    {
      return true;
      if (paramString2.equals("loading_event"))
      {
        AdLog.d("AdCanvasView", "loading_event" + paramString3);
        arkShowLoading(paramString3);
      }
      else if (paramString2.equals("xijing_form_select_event"))
      {
        AdLog.d("AdCanvasView", "xijing_form_select_event" + paramString3);
        arkShowSelectWindow(paramString3);
      }
      else if (paramString2.equals("xijing_form_resize_event"))
      {
        AdLog.d("AdCanvasView", "xijing_form_resize_event" + paramString3);
        arkViewResize(paramString3);
      }
      else if (paramString2.equals("xijing_form_input_focus_event"))
      {
        AdLog.d("AdCanvasView", "xijing_form_input_focus_event" + paramString3);
        getLastTouchFormModuleId(paramString3);
      }
    }
  }
  
  public void onActivityDestroy()
  {
    AdLog.i("AdCanvasView", "onActivityDestroy");
    if (this.pageView != null) {
      this.pageView.onActivityDestroy();
    }
    if ((this.topFixedButtonView != null) && (this.topFixedButtonView.getVisibility() == 0)) {
      this.topFixedButtonView.onActivityDestroy();
    }
    if ((this.bottomFixedButtonView != null) && (this.bottomFixedButtonView.getVisibility() == 0)) {
      this.bottomFixedButtonView.onActivityDestroy();
    }
    if (this.floatingAppBtnComponentView != null) {
      this.floatingAppBtnComponentView.onActivityDestroy();
    }
    if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing()))
    {
      this.mPopupWindow.dismiss();
      this.mPopupWindow = null;
    }
    if (this.mAppDownloadManager != null) {
      this.mAppDownloadManager.onDestroy();
    }
    AdProgressDialog.dismiss();
    AdArkView.setNotify(null);
    AdCanvasDownloadListener.removeDownloadListener(this.mAppDownloadManager);
    reportStayTimeForAction();
    reportLoadTimeForAction(this.stayTimeStatistics.getTime(), false);
  }
  
  public void onActivityPause()
  {
    if (this.pageView != null) {
      this.pageView.onActivityPause();
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
      if (this.mAppDownloadManager != null) {
        this.mAppDownloadManager.onActivityResume();
      }
      if ((this.topFixedButtonView != null) && (this.topFixedButtonView.getVisibility() == 0)) {
        this.topFixedButtonView.onActivityResume();
      }
      if ((this.bottomFixedButtonView != null) && (this.bottomFixedButtonView.getVisibility() == 0)) {
        this.bottomFixedButtonView.onActivityResume();
      }
      if (this.floatingAppBtnComponentView != null) {
        this.floatingAppBtnComponentView.onActivityResume();
      }
      if (this.bottomFixedWebAppCommonButtonContainer != null)
      {
        int i = 0;
        while (i < this.bottomFixedWebAppCommonButtonContainer.getChildCount())
        {
          View localView = this.bottomFixedWebAppCommonButtonContainer.getChildAt(i);
          if ((localView != null) && ((localView instanceof AdCanvasComponentView))) {
            ((AdCanvasComponentView)localView).onActivityResume();
          }
          i += 1;
        }
      }
      reportPageLoaded();
      this.stayTimeStatistics.start();
    }
  }
  
  public void onLoaded(AdCanvasComponentData paramAdCanvasComponentData, long paramLong, boolean paramBoolean)
  {
    if ((paramAdCanvasComponentData == null) || (!paramAdCanvasComponentData.isValid()) || (getData() == null) || (!getData().isValid())) {
      AdLog.e("AdCanvasView", "onLoaded error");
    }
    do
    {
      do
      {
        return;
      } while ((this.loadReportedForAction) || (this.loadTimeIds == null) || (!paramAdCanvasComponentData.isAddToLoadStatistics));
      this.loadSuccess &= paramBoolean;
      this.loadTimeIds.add(paramAdCanvasComponentData.id);
    } while (this.loadTimeIds.size() != getData().getToLoadIdsize());
    reportLoadTimeForAction(stopLoad(), this.loadSuccess);
  }
  
  public void setData(AdCanvasData paramAdCanvasData)
  {
    if ((paramAdCanvasData == null) || (!paramAdCanvasData.isValid())) {
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
  
  public void setPageViewTopMargin(int paramInt)
  {
    if (this.pageView != null) {
      this.pageView.setPageViewLayoutParams(paramInt);
    }
  }
  
  public void showFloatingProgressButton()
  {
    if ((this.topFixedButtonView.getVisibility() == 0) || (this.bottomFixedButtonView.getVisibility() == 0) || (this.bottomFixedWebAppCommonButtonContainer.getChildCount() > 0) || (this.floatingProgressBar == null) || (this.floatingProgressBar.getVisibility() == 0) || (!this.data.hasMultiPictureData)) {}
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      this.floatingProgressBar.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.contentView.getLayoutParams();
    } while (localLayoutParams == null);
    localLayoutParams.addRule(3, this.floatingProgressBar.getId());
  }
  
  public void showProgressBar(String paramString, boolean paramBoolean)
  {
    if ((this.topFixedButtonView.getVisibility() == 0) || (this.bottomFixedButtonView.getVisibility() == 0))
    {
      this.floatingProgressBar.setVisibility(8);
      if (this.topFixedButtonView.getVisibility() == 0) {
        this.topFixedButtonView.doClick();
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.bottomFixedButtonView.getVisibility() == 0)
        {
          this.bottomFixedButtonView.doClick();
          return;
        }
        if (this.bottomFixedWebAppCommonButtonContainer.getChildCount() <= 0) {
          break;
        }
        if (paramBoolean)
        {
          int i = 0;
          while (i < this.bottomFixedWebAppCommonButtonContainer.getChildCount())
          {
            paramString = this.bottomFixedWebAppCommonButtonContainer.getChildAt(i);
            if ((paramString != null) && ((paramString instanceof d)) && (((d)paramString).getData() != null) && (((d)paramString).getData().canShowProgress)) {
              ((d)paramString).doClick();
            }
            i += 1;
          }
        }
      }
      if (this.floatingProgressBar.getVisibility() == 8) {
        setFloatingButtonData(paramString);
      }
      showFloatingProgressButton();
      if ((paramBoolean) && (this.floatingAppBtnComponentView != null)) {
        this.floatingAppBtnComponentView.doClick();
      }
      paramString = (RelativeLayout.LayoutParams)this.contentView.getLayoutParams();
    } while (this.floatingProgressBar.getVisibility() != 0);
    paramString.addRule(3, this.floatingProgressBar.getId());
  }
  
  protected void startLoad()
  {
    if (this.loadTimeStatistics != null) {
      this.loadTimeStatistics.start();
    }
  }
  
  protected long stopLoad()
  {
    long l = -2147483648L;
    if (this.loadTimeStatistics != null)
    {
      this.loadTimeStatistics.stop();
      l = this.loadTimeStatistics.getTime();
    }
    this.loadTimeStatistics = null;
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView
 * JD-Core Version:    0.7.0.1
 */