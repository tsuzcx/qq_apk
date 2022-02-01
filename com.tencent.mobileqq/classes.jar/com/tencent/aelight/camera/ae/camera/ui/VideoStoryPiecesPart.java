package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class VideoStoryPiecesPart
  extends VideoStoryBasePart
  implements View.OnClickListener, Observer
{
  private static String W = "pendent_pag";
  private static final String X;
  private static int a = 20000;
  private static int b = 4000;
  private static int c = 64;
  private CountDownView A;
  private AbsAECaptureButton B;
  private AEWaterMarkPanel C;
  private boolean D = AEThemeUtil.b();
  private boolean E;
  private boolean F;
  private BubbleTextView G;
  private BubbleTextView H;
  private BubbleTextView I;
  private URLImageView J;
  private TextView K;
  private boolean L = false;
  private String M;
  private String N;
  private String O;
  private int P;
  private String Q;
  private String R;
  private boolean S;
  private String T;
  private int U;
  private String V;
  private PAGView Y;
  private VideoStoryPiecesPart.CameraTabBubbleAdBean Z;
  private final AEMaterialManager aa = (AEMaterialManager)AEQIMManager.a().b(1);
  private AEPituCameraUnit d;
  private AEVideoStoryCaptureModeViewModel e;
  private AEVideoStoryTopBarViewModel f;
  private AEVideoStoryGIFTplViewModel g;
  private AEVideoStoryStateViewModel h;
  private View i;
  private View j;
  private SquareRoundImageView k;
  private View l;
  private AECompoundButton m;
  private AECompoundButton n;
  private AECompoundButton o;
  private AECaptureMode p;
  private TextView q;
  private AEBottomPanelViewModel r;
  private AEMaterialPanel s;
  private AEARCakePanel t;
  private BeautyAndFilterPanel u;
  private Bitmap v;
  private View w;
  private AECameraGLSurfaceView x;
  private boolean y;
  private boolean z = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.FILES.g);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pendent.pag");
    X = localStringBuilder.toString();
  }
  
  public VideoStoryPiecesPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.d = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    if (AECameraEntryManager.k(paramActivity.getIntent())) {
      a = 20000;
    }
    this.P = AECameraEntryManager.a(this.mActivity.getIntent());
  }
  
  private boolean A()
  {
    return (this.mActivity != null) && (!AECameraEntryManager.q(this.mActivity.getIntent())) && (!AECameraEntryManager.i(this.mActivity.getIntent())) && (!AECameraEntryManager.j(this.mActivity.getIntent())) && (!AECameraEntryManager.k(this.mActivity.getIntent())) && (!AECameraEntryManager.m(this.mActivity.getIntent())) && (!AECameraEntryManager.n(this.mActivity.getIntent())) && (!AECameraEntryManager.o(this.mActivity.getIntent())) && (this.d.u().e());
  }
  
  private boolean B()
  {
    return (this.mActivity != null) && (!AECameraEntryManager.m(this.mActivity.getIntent())) && (!AECameraEntryManager.n(this.mActivity.getIntent())) && (!AECameraEntry.I.b(AECameraEntryManager.a(this.mActivity.getIntent()))) && (this.d.u().h());
  }
  
  private void C()
  {
    this.g = ((AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryGIFTplViewModel.class));
    this.e = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryCaptureModeViewModel.class));
    this.h = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryStateViewModel.class));
    this.f = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryTopBarViewModel.class));
    this.r = ((AEBottomPanelViewModel)AEViewModelProviders.a(this.d).get(AEBottomPanelViewModel.class));
    this.g.b().observe(this.d, new VideoStoryPiecesPart.9(this));
    this.e.a.observe(this.d, new VideoStoryPiecesPart.10(this));
    this.f.b().observe(this.d, new VideoStoryPiecesPart.11(this));
    if (this.E) {
      this.f.a.observe(this.d, new VideoStoryPiecesPart.12(this));
    }
    this.h.a().observe(this.d, new VideoStoryPiecesPart.13(this));
    this.h.b().postValue(Boolean.valueOf(false));
    this.h.c().postValue(Boolean.valueOf(false));
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.d).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).a.observe(this.d, new VideoStoryPiecesPart.14(this));
    this.h.b().observe(this.d, new VideoStoryPiecesPart.15(this));
    this.h.c().observe(this.d, new VideoStoryPiecesPart.16(this));
  }
  
  private void D()
  {
    BubbleTextView localBubbleTextView = this.G;
    if ((localBubbleTextView != null) && (localBubbleTextView.getVisibility() == 0))
    {
      AECameraPrefsUtil.a().a("sp_key_ae_comics_gif_tips", true, 0);
      AEQLog.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
    }
  }
  
  private void E()
  {
    if (P())
    {
      Q();
      return;
    }
    F();
  }
  
  private void F()
  {
    BubbleTextView localBubbleTextView = this.G;
    if (localBubbleTextView != null)
    {
      localBubbleTextView.clearAnimation();
      this.G.setVisibility(4);
    }
  }
  
  private void G()
  {
    BubbleTextView localBubbleTextView = this.I;
    if ((localBubbleTextView != null) && (localBubbleTextView.getVisibility() == 0))
    {
      AECameraPrefsUtil.a().a("sp_key_ae_camera_beauty_bubble_has_shown_prefix_new", true, 0);
      AEQLog.b("VideoStoryPiecesPart", "[BeautyTip]--set flag:  has shown");
    }
  }
  
  private void H()
  {
    if (K())
    {
      I();
      return;
    }
    J();
  }
  
  private void I()
  {
    if (this.I == null)
    {
      this.I = new BubbleTextView(this.mActivity);
      this.I.setPadding(UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F), UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F));
      this.I.setIncludeFontPadding(false);
      this.I.setTextSize(1, 14.0F);
      this.I.setTextColor(Color.parseColor("#03081A"));
      Object localObject1 = this.I;
      ((BubbleTextView)localObject1).e = -1;
      ((BubbleTextView)localObject1).f = 2;
      ((BubbleTextView)localObject1).b = UIUtils.a(this.mActivity, 6.0F);
      this.I.setText(this.mActivity.getString(2064187395));
      this.I.a();
      this.I.setVisibility(4);
      localObject1 = (ViewStub)this.mRootView.findViewById(2063991454);
      if (localObject1 != null) {
        ((ViewStub)localObject1).inflate();
      }
      localObject1 = this.mRootView.findViewById(2063991105);
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getParent();
        if ((localObject2 instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(3, 2063991105);
          localLayoutParams.topMargin = UIUtils.a(this.mActivity, -8.0F);
          localObject2 = (RelativeLayout)localObject2;
          ((RelativeLayout)localObject2).addView(this.I, ((RelativeLayout)localObject2).indexOfChild((View)localObject1), localLayoutParams);
        }
      }
    }
    this.I.postDelayed(new VideoStoryPiecesPart.17(this), 200L);
  }
  
  private void J()
  {
    BubbleTextView localBubbleTextView = this.I;
    if (localBubbleTextView != null)
    {
      localBubbleTextView.clearAnimation();
      this.I.setVisibility(4);
    }
  }
  
  private boolean K()
  {
    return false;
  }
  
  private void L()
  {
    if (this.Z != null)
    {
      Object localObject = this.H;
      if ((localObject != null) && (((BubbleTextView)localObject).getVisibility() == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearTabBubbleAd---OpId=");
        ((StringBuilder)localObject).append(this.Z.getOpID());
        ((StringBuilder)localObject).append(", tab=");
        ((StringBuilder)localObject).append(this.Z.getTab());
        AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject).toString());
        localObject = AECameraPrefsUtil.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_key_ae_camera_tab_bubble_ad_has_shown_prefix");
        localStringBuilder.append(this.Z.getOpID());
        ((AECameraPrefsUtil)localObject).a(localStringBuilder.toString(), true, 0);
        this.Z = null;
      }
    }
  }
  
  private void M()
  {
    if (this.Z == null)
    {
      localObject = AECameraPrefsUtil.a().b("camera_ad_tab_bubble_content", "", 4);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.Z = ((VideoStoryPiecesPart.CameraTabBubbleAdBean)GsonUtils.json2Obj((String)localObject, VideoStoryPiecesPart.CameraTabBubbleAdBean.class));
      }
    }
    if (O())
    {
      N();
      return;
    }
    Object localObject = this.H;
    if (localObject != null)
    {
      ((BubbleTextView)localObject).clearAnimation();
      this.H.setVisibility(4);
    }
  }
  
  private void N()
  {
    AEQLog.b("VideoStoryPiecesPart", "showTabBubbleAd");
    Object localObject1 = this.Z;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((VideoStoryPiecesPart.CameraTabBubbleAdBean)localObject1).getTab();
    String str = this.Z.getContent();
    if (this.H == null)
    {
      this.H = new BubbleTextView(this.mActivity);
      this.H.setPadding(UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F), UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F));
      this.H.setIncludeFontPadding(false);
      this.H.setTextSize(1, 14.0F);
      this.H.setTextColor(Color.parseColor("#03081A"));
      Object localObject2 = this.H;
      ((BubbleTextView)localObject2).e = -1;
      ((BubbleTextView)localObject2).b = UIUtils.a(this.mActivity, 6.0F);
      this.H.a();
      this.H.setVisibility(4);
      localObject2 = (RelativeLayout)this.mRootView.findViewById(2063991385);
      if (localObject2 != null)
      {
        Object localObject3 = ((RelativeLayout)localObject2).getParent();
        if ((localObject3 instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2063991385);
          localLayoutParams.bottomMargin = UIUtils.a(this.mActivity, -8.0F);
          localObject3 = (RelativeLayout)localObject3;
          ((RelativeLayout)localObject3).addView(this.H, ((RelativeLayout)localObject3).indexOfChild((View)localObject2), localLayoutParams);
        }
      }
    }
    this.H.postDelayed(new VideoStoryPiecesPart.18(this, (String)localObject1, str), 200L);
  }
  
  private boolean O()
  {
    Object localObject1 = this.Z;
    if (localObject1 == null) {
      return false;
    }
    if (TextUtils.isEmpty(((VideoStoryPiecesPart.CameraTabBubbleAdBean)localObject1).getContent())) {
      return false;
    }
    if (TextUtils.isEmpty(this.Z.getTab())) {
      return false;
    }
    if (!AECommonUtil.a(VideoStoryPiecesPart.CameraTabBubbleAdBean.access$6000(this.Z), VideoStoryPiecesPart.CameraTabBubbleAdBean.access$6100(this.Z)))
    {
      AEQLog.b("VideoStoryPiecesPart", "shouldShowTabBubbleAd---break because app version not match");
      return false;
    }
    localObject1 = (Boolean)this.h.a().getValue();
    if ((localObject1 != null) && (!((Boolean)localObject1).booleanValue())) {
      return false;
    }
    localObject1 = (Boolean)this.h.b().getValue();
    if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
      return false;
    }
    localObject1 = (Boolean)this.h.c().getValue();
    if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
      return false;
    }
    localObject1 = this.Z.toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("check show TabBubble: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject2).toString());
    localObject2 = AECameraPrefsUtil.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sp_key_ae_camera_tab_bubble_ad_has_shown_prefix");
    ((StringBuilder)localObject3).append(this.Z.getOpID());
    if (((AECameraPrefsUtil)localObject2).b(((StringBuilder)localObject3).toString(), false, 0))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TabBubble]--has shown: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject2).toString());
      return false;
    }
    localObject2 = this.Z.getTab();
    localObject3 = this.p;
    if ((localObject3 != null) && (((AECaptureMode)localObject3).name.equals(localObject2)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TabBubble]--not right tab: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject2).toString());
      return false;
    }
    localObject3 = (AECaptureMode[])((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryCaptureModeViewModel.class)).b.getValue();
    if (localObject3 == null) {
      return false;
    }
    int i2 = localObject3.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject4 = localObject3[i1];
      if ((localObject4 != null) && (localObject4.name.equals(localObject2)))
      {
        i1 = 1;
        break label436;
      }
      i1 += 1;
    }
    i1 = 0;
    label436:
    if (i1 == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TabBubble]--tab not exist: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject2).toString());
      return false;
    }
    return true;
  }
  
  private boolean P()
  {
    if (this.p != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.h.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.h.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.h.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int i1 = AECameraEntryManager.a(this.mActivity.getIntent());
    if ((!AECameraEntryManager.d(i1)) && (!AECameraEntryManager.g(i1)) && (!AECameraEntryManager.b(i1)))
    {
      if (AECameraEntryManager.a(i1)) {
        return false;
      }
      if (AECameraPrefsUtil.a().b("sp_key_ae_comics_gif_tips", false, 0))
      {
        AEQLog.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void Q()
  {
    if (this.G == null)
    {
      this.G = new BubbleTextView(this.mActivity);
      this.G.setPadding(UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F), UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F));
      this.G.setIncludeFontPadding(false);
      this.G.setTextSize(1, 14.0F);
      this.G.setTextColor(Color.parseColor("#03081A"));
      Object localObject1 = this.G;
      ((BubbleTextView)localObject1).e = -1;
      ((BubbleTextView)localObject1).b = UIUtils.a(this.mActivity, 6.0F);
      this.G.setText(this.mActivity.getString(2064187435));
      this.G.a();
      this.G.setVisibility(4);
      localObject1 = (RelativeLayout)this.mRootView.findViewById(2063991385);
      if (localObject1 != null)
      {
        Object localObject2 = ((RelativeLayout)localObject1).getParent();
        if ((localObject2 instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2063991385);
          localLayoutParams.bottomMargin = UIUtils.a(this.mActivity, -8.0F);
          localObject2 = (RelativeLayout)localObject2;
          ((RelativeLayout)localObject2).addView(this.G, ((RelativeLayout)localObject2).indexOfChild((View)localObject1), localLayoutParams);
        }
      }
    }
    this.G.postDelayed(new VideoStoryPiecesPart.19(this), 200L);
  }
  
  private void R()
  {
    if (this.p != AECaptureMode.GIF)
    {
      S();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.h.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      S();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (AEMaterialWrapper)this.g.b().getValue();
    if ((localObject != null) && (((AEMaterialWrapper)localObject).b != null))
    {
      localObject = (String)((AEMaterialWrapper)localObject).b.additionalFields.get("gif_sponsor_name");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        S();
        AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
        return;
      }
      a((String)localObject);
      return;
    }
    S();
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
  }
  
  private void S()
  {
    TextView localTextView = this.q;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void T()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.20(this), 64, null, true);
  }
  
  private void U()
  {
    AEQLog.a("VideoStoryPiecesPart", "watermark openWaterMarkPanel");
    AEWaterMarkPanel localAEWaterMarkPanel = this.C;
    if (localAEWaterMarkPanel == null) {
      return;
    }
    localAEWaterMarkPanel.setVisibility(0);
    this.C.a();
    if (this.E) {
      AEReportUtils.a(8, null);
    }
  }
  
  private void V()
  {
    if (this.u != null)
    {
      Object localObject = this.I;
      boolean bool;
      if ((localObject != null) && (((BubbleTextView)localObject).getVisibility() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openBeautyPanel---beautyBubbleShowing=");
      ((StringBuilder)localObject).append(bool);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject).toString());
      this.u.an_();
      if ((bool) && ((this.u instanceof DYBeautyAndFilterPanelViewStubHolder))) {
        ThreadManager.getUIHandler().postDelayed(new VideoStoryPiecesPart.21(this), 250L);
      }
      this.h.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void W()
  {
    BeautyAndFilterPanel localBeautyAndFilterPanel = this.u;
    if (localBeautyAndFilterPanel != null)
    {
      localBeautyAndFilterPanel.an_();
      this.h.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void X()
  {
    int i1 = UIUtils.a(this.mActivity, this.s.getHeight());
    ViewAnimator.a(new View[] { this.s }).b(new float[] { 0.0F, i1 }).a(300L).a(new VideoStoryPiecesPart.22(this)).d();
  }
  
  private void Y()
  {
    int i1 = UIUtils.a(this.mActivity, this.s.getHeight());
    ViewAnimator.a(new View[] { this.s }).b(new float[] { 0.0F, i1 }).a(300L).a(new VideoStoryPiecesPart.23(this)).d();
  }
  
  public static AECircleCaptureStyle a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      return AECircleCaptureStyle.a;
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
    {
      int i1 = AEPreviewSizeUtil.b();
      if (i1 == 2) {
        return AECircleCaptureStyle.c;
      }
      if (i1 == 1) {
        return AECircleCaptureStyle.d;
      }
      return AECircleCaptureStyle.b;
    }
    return AECircleCaptureStyle.b;
  }
  
  private void a(int paramInt)
  {
    this.k.setVisibility(paramInt);
    View localView = this.j;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  private void a(View.OnClickListener paramOnClickListener)
  {
    this.k.setOnClickListener(paramOnClickListener);
    View localView = this.j;
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private void a(@NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!this.E) {
      return;
    }
    Object localObject = this.B;
    if (localObject != null) {
      ((AbsAECaptureButton)localObject).a(true, paramAECircleCaptureStyle);
    }
    localObject = this.m;
    if (localObject != null) {
      ((AECompoundButton)localObject).setForegroundAndBackgroundResource(paramAECircleCaptureStyle.B, paramAECircleCaptureStyle.A);
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[GifAuthor]---showGifAuthor: author=");
    localStringBuilder.append(paramString);
    AEQLog.a("VideoStoryPiecesPart", localStringBuilder.toString());
    if (this.q == null)
    {
      this.q = ((TextView)((ViewStub)this.mRootView.findViewById(2063991442)).inflate());
      this.q.setTranslationY(this.x.getY() - UIUtils.a(this.mActivity, 24.0F));
    }
    this.q.setVisibility(0);
    this.q.setText(this.mActivity.getString(2064187550, new Object[] { paramString }));
  }
  
  private void b(int paramInt)
  {
    if (this.F)
    {
      this.n.setVisibility(paramInt);
      this.m.setVisibility(8);
      localView = this.l;
      if (localView != null) {
        localView.setVisibility(8);
      }
      return;
    }
    this.m.setVisibility(paramInt);
    View localView = this.l;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  private void b(View.OnClickListener paramOnClickListener)
  {
    this.m.setOnClickListener(paramOnClickListener);
    View localView = this.l;
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
    if (this.F) {
      this.n.setOnClickListener(paramOnClickListener);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i1;
    if ((B()) && (paramBoolean)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    b(i1);
    if (this.F)
    {
      String str = AECameraPrefsUtil.a().b("key_ae_arcake_preview", "", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake  arstatus ");
      localStringBuilder.append(str);
      AEQLog.a("VideoStoryPiecesPart", localStringBuilder.toString());
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ("1".equals(str)) {
        b(8);
      }
    }
  }
  
  private void c()
  {
    if (this.E)
    {
      String str = this.d.s().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("http"))) {
        try
        {
          Intent localIntent = new Intent(this.d.s(), QQBrowserActivity.class);
          localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
          localIntent.putExtra("loc_play_show_material_id", str);
          localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
          localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.N.a());
          this.d.s().startActivityForResult(localIntent, 1025);
          this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.J != null) && (this.L))
    {
      if (!this.e.b()) {
        return;
      }
      if (paramBoolean)
      {
        this.J.setVisibility(8);
        return;
      }
      this.J.setVisibility(0);
    }
  }
  
  private void d()
  {
    if (this.F)
    {
      AEARCakePanel localAEARCakePanel = this.t;
      if (localAEARCakePanel == null) {
        return;
      }
      localAEARCakePanel.setMaterialSelectId();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    this.k.setEnabled(paramBoolean);
    View localView = this.j;
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  private void e()
  {
    if (this.mRootView == null) {
      return;
    }
    this.K = ((TextView)this.mRootView.findViewById(2063991510));
    TextView localTextView = this.K;
    if (localTextView != null) {
      localTextView.setOnClickListener(this);
    }
  }
  
  private void f()
  {
    i();
    g();
  }
  
  private void g()
  {
    try
    {
      this.J = ((URLImageView)this.mRootView.findViewById(2063991150));
      if (this.L)
      {
        h();
        m();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    Object localObject = (ViewStub)this.mRootView.findViewById(2063991454);
    if (localObject != null) {
      ((ViewStub)localObject).setOnInflateListener(new VideoStoryPiecesPart.1(this));
    }
    localObject = this.J;
    if (localObject != null) {
      ((URLImageView)localObject).setOnClickListener(new VideoStoryPiecesPart.2(this));
    }
  }
  
  private void i()
  {
    j();
    if (this.L)
    {
      if (this.E)
      {
        this.N = AECameraPrefsUtil.a().b("circle_camera_ad_icon_url", "", 4);
        this.O = AECameraPrefsUtil.a().b("circle_camera_ad_schema", "", 4);
        return;
      }
      this.N = AECameraPrefsUtil.a().b("camera_ad_icon_url", "", 4);
      this.O = AECameraPrefsUtil.a().b("camera_ad_schema", "", 4);
    }
  }
  
  private void j()
  {
    if (this.E)
    {
      this.L = AECameraPrefsUtil.a().b("circle_camera_ad_show", false, 4);
      this.M = AECameraPrefsUtil.a().b("circle_camera_ad_type", "", 4);
    }
    else
    {
      this.L = AECameraPrefsUtil.a().b("camera_ad_show", false, 4);
      this.M = AECameraPrefsUtil.a().b("camera_ad_type", "", 4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPresent: ");
    localStringBuilder.append(this.L);
    localStringBuilder.append(" type: ");
    localStringBuilder.append(this.M);
    AEQLog.b("VideoStoryPiecesPart", localStringBuilder.toString());
    if (!"play".equals(this.M))
    {
      if (k())
      {
        this.L = false;
        return;
      }
      if (o()) {
        this.L = "h5".equals(this.M);
      }
    }
  }
  
  private boolean k()
  {
    return (!"h5".equals(this.M)) && (!"widget".equals(this.M)) && (!"play".equals(this.M));
  }
  
  private void l()
  {
    AEQLog.b("VideoStoryPiecesPart", "content entry present.");
    if ((this.J.getVisibility() == 0) && (this.J.getDrawable() != null)) {
      return;
    }
    this.J.setVisibility(0);
    Object localObject = this.N;
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("in url drawable set：");
      ((StringBuilder)localObject).append(this.N);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject).toString());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131168376);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131168376);
      localObject = URLDrawable.getDrawable(this.N, (URLDrawable.URLDrawableOptions)localObject);
      this.J.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      label145:
      break label145;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url error url: ");
    ((StringBuilder)localObject).append(this.N);
    AEQLog.d("VideoStoryPiecesPart", ((StringBuilder)localObject).toString());
    return;
    AEQLog.b("VideoStoryPiecesPart", "iconUrl is empty.");
  }
  
  private void m()
  {
    if (this.J == null) {
      g();
    }
    if (!this.L)
    {
      if (this.J.getVisibility() == 0) {
        this.J.setVisibility(8);
      }
      AEQLog.a("VideoStoryPiecesPart", "hide camera content entry.");
      return;
    }
    if (AECameraEntryManager.g(this.P))
    {
      l();
      return;
    }
    if (AECameraEntryManager.f(this.P))
    {
      n();
      l();
      return;
    }
    if (o())
    {
      if ("h5".equals(AECameraPrefsUtil.a().b("camera_ad_type", "", 4)))
      {
        n();
        l();
        return;
      }
      if (this.J.getVisibility() == 0) {
        this.J.setVisibility(8);
      }
      this.L = false;
      return;
    }
    if (this.J.getVisibility() == 0) {
      this.J.setVisibility(8);
    }
    this.L = false;
  }
  
  private void n()
  {
    URLImageView localURLImageView = this.J;
    if ((localURLImageView != null) && (localURLImageView.getVisibility() != 0)) {
      AEBaseDataReporter.a().W();
    }
  }
  
  private boolean o()
  {
    return ((AECameraEntryManager.c(this.P)) && (!AECameraEntryManager.f(this.P))) || (AECameraEntryManager.b(this.P)) || (AECameraEntryManager.a(this.P)) || (AECameraEntryManager.d(this.P));
  }
  
  private void p()
  {
    this.i = this.mRootView.findViewById(2063991110);
    this.w = this.mRootView.findViewById(2063991102);
    this.x = ((AECameraGLSurfaceView)this.mRootView.findViewById(2063990947));
    if (((Long)VSConfigManager.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.B = ((AbsAECaptureButton)this.mRootView.findViewById(2063990959));
    this.y = ((String)VSConfigManager.a().a("enable_click_take_picture", "1")).equals("1");
    this.z = this.mActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    a();
    this.B.setMaxDuration(a(AECaptureMode.NORMAL));
  }
  
  private void q()
  {
    if (this.E) {
      return;
    }
    Object localObject = (AECaptureMode[])this.e.b.getValue();
    if ((localObject != null) && (localObject.length == 1) && (localObject[0] == AECaptureMode.NORMAL))
    {
      AEQLog.a("VideoStoryPiecesPart", "from web need adjust layout ");
      localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.b(BaseApplicationImpl.getContext(), c);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void r()
  {
    this.C = ((AEWaterMarkPanel)this.mRootView.findViewById(2063991339));
    AEWaterMarkPanel localAEWaterMarkPanel = this.C;
    if (localAEWaterMarkPanel == null) {
      return;
    }
    localAEWaterMarkPanel.setCaptureController(this.d.am());
    this.C.setPartManager(this.mPartManager);
  }
  
  private void s()
  {
    this.k = ((SquareRoundImageView)this.mRootView.findViewById(2063991250));
    this.j = this.mRootView.findViewById(2063991251);
    a(this);
    this.k.post(new VideoStoryPiecesPart.3(this));
    if (A())
    {
      a(0);
      this.k.setDrawChecked(false);
    }
    else
    {
      a(4);
    }
    this.m = ((AECompoundButton)this.mRootView.findViewById(2063990930));
    this.l = this.mRootView.findViewById(2063990931);
    AECameraDaTongHelper.a.a(this.m, "em_ae_motion_btn");
    this.n = ((AECompoundButton)this.mRootView.findViewById(2063990914));
    Object localObject = this.n;
    if (localObject != null) {
      ((AECompoundButton)localObject).setVisibility(8);
    }
    this.s = ((AEMaterialPanel)this.mRootView.findViewById(2063991338));
    t();
    if (B())
    {
      if (this.F)
      {
        localObject = AEGiftMaterialConfigParser.a();
        if ((localObject != null) && (((List)localObject).size() <= 1))
        {
          this.n.getForegroundView().setImageResource(2063925261);
        }
        else
        {
          this.n.getForegroundView().setImageResource(2063925261);
          localObject = ((List)localObject).iterator();
          AEARCakeMaterial localAEARCakeMaterial;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAEARCakeMaterial = ((AEGiftMaterial)((Iterator)localObject).next()).c();
          } while ((localAEARCakeMaterial == null) || (localAEARCakeMaterial.A));
          this.n.getForegroundView().setImageResource(2063925264);
        }
      }
      else if (!this.E)
      {
        localObject = this.Q;
        this.m.post(new VideoStoryPiecesPart.4(this, (String)localObject));
      }
      else
      {
        this.o = ((AECompoundButton)this.mRootView.findViewById(2063991157));
        this.o.setOnClickListener(this);
      }
      b(this);
      b(0);
      this.t = ((AEARCakePanel)this.mRootView.findViewById(2063991337));
      localObject = this.t;
      if (localObject != null)
      {
        ((AEARCakePanel)localObject).setCaptureController(this.d.am());
        this.t.setPartManager(this.mPartManager);
      }
      this.s.setPartManager(this.mPartManager);
      this.s.setCaptureController(this.d.am());
      return;
    }
    b(8);
    this.s.setVisibility(8);
  }
  
  private void t()
  {
    this.S = AECameraPrefsUtil.a().b("camera_ad_pendent_show", false, 4);
    this.Q = AECameraPrefsUtil.a().b("camera_ad_pendent_icon_url", "", 4);
    this.T = AECameraPrefsUtil.a().b("camera_ad_pendent_icon_type", "", 4);
    this.U = AECameraPrefsUtil.a().b("camera_ad_pendent_categoryId", -1, 4);
    this.V = AECameraPrefsUtil.a().b("camera_ad_pendent_op_id", "", 4);
    this.R = AECameraPrefsUtil.a().b("camera_ad_pendent_schema", "", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("entry dynamics: icon type ");
    localStringBuilder.append(this.T);
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.Q);
    localStringBuilder.append(" type :");
    localStringBuilder.append(this.S);
    localStringBuilder.append(" category id: ");
    localStringBuilder.append(this.U);
    localStringBuilder.append(" OPID: ");
    localStringBuilder.append(this.V);
    localStringBuilder.append(" scheme: ");
    localStringBuilder.append(this.R);
    AEQLog.a("VideoStoryPiecesPart", localStringBuilder.toString());
  }
  
  private void u()
  {
    if (FileUtils.fileExistsAndNotEmpty(X))
    {
      AEQLog.a("VideoStoryPiecesPart", "entry dynamics: not download ");
      v();
      return;
    }
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)AEQIMManager.a(1);
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.r = this.Q;
    localAEMaterialMetaData.t = "pendent.pag";
    localAEMaterialMetaData.m = W;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), AEPath.CAMERA.FILES.g, localAEMaterialMetaData, new VideoStoryPiecesPart.5(this));
  }
  
  private void v()
  {
    if (!FeatureManager.Features.PAG.init())
    {
      AEQLog.d("VideoStoryPiecesPart", "entry dynamics: pag not init");
      this.m.getForegroundView().setImageResource(2063925554);
      return;
    }
    PAGFile localPAGFile = PAGFile.Load(X);
    this.Y = new PAGView(BaseApplication.getContext());
    this.Y.addPAGFlushListener(new VideoStoryPiecesPart.6(this));
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    this.m.addView(this.Y, (ViewGroup.LayoutParams)localObject);
    this.m.getForegroundView().setImageDrawable(this.mActivity.getResources().getDrawable(2131168376));
    localObject = this.Y;
    if ((localObject != null) && (localPAGFile != null))
    {
      ((PAGView)localObject).setComposition(localPAGFile);
      this.Y.setRepeatCount(0);
      if (!this.Y.isPlaying())
      {
        AEQLog.d("VideoStoryPiecesPart", "entry dynamics: pag  play");
        this.Y.play();
      }
    }
  }
  
  private void w()
  {
    if ("pag".equals(this.T))
    {
      u();
    }
    else if ("static".equals(this.T))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131168376);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131168376);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.m.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.m.getLayoutParams().height;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = true;
      localObject = URLDrawable.getDrawable(this.Q, (URLDrawable.URLDrawableOptions)localObject);
      this.m.getForegroundView().setImageDrawable((Drawable)localObject);
    }
    AEBaseDataReporter.a().h(this.R);
  }
  
  private void x()
  {
    AEQLog.b("VideoStoryPiecesPart", "start load hot material icon");
    List localList = this.aa.e();
    if (localList == null) {
      return;
    }
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (AEMaterialCategory)((Iterator)localObject2).next();
      if ("热门".equals(((AEMaterialCategory)localObject1).d)) {
        break label66;
      }
    }
    Object localObject1 = null;
    label66:
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localList.size() > 0) {
        localObject2 = (AEMaterialCategory)localList.get(0);
      }
    }
    if ((localObject2 != null) && (((AEMaterialCategory)localObject2).a != null) && (!((AEMaterialCategory)localObject2).a.isEmpty()))
    {
      localObject1 = (AEMaterialMetaData)((AEMaterialCategory)localObject2).a.get(0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load hot material icon, material id = ");
      ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject1).m);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject2).toString());
      UIUtils.a(this.m.getForegroundView(), ((AEMaterialMetaData)localObject1).q, UIUtils.a(this.mActivity, 36.0F), UIUtils.a(this.mActivity, 36.0F), ResourcesCompat.getDrawable(this.mActivity.getResources(), 2063925554, null), null);
      return;
    }
    this.m.getForegroundView().setImageResource(2063925554);
  }
  
  private boolean y()
  {
    return AECameraPrefsUtil.a().b(this.V, true, 4);
  }
  
  private void z()
  {
    if (this.A != null) {
      return;
    }
    this.A = ((CountDownView)((ViewStub)this.mRootView.findViewById(2063990789)).inflate().findViewById(2063990791));
    this.A.setCountDownListener(new VideoStoryPiecesPart.8(this));
  }
  
  protected int a(AECaptureMode paramAECaptureMode)
  {
    AEPituCameraUnit localAEPituCameraUnit = this.d;
    if ((localAEPituCameraUnit != null) && (localAEPituCameraUnit.u().C() != -1)) {
      return this.d.u().C();
    }
    if (paramAECaptureMode == AECaptureMode.GIF) {
      return b;
    }
    return a;
  }
  
  protected void a()
  {
    if (this.mActivity != null) {
      if ((!AECameraEntryManager.m(this.mActivity.getIntent())) && (!AECameraEntryManager.n(this.mActivity.getIntent())))
      {
        boolean bool = AECameraEntryManager.o(this.mActivity.getIntent());
        int i1 = 1;
        if (bool)
        {
          this.B.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 1));
        }
        else if (this.z)
        {
          this.B.setFunctionFlag(2);
        }
        else
        {
          AbsAECaptureButton localAbsAECaptureButton = this.B;
          if (!this.y) {
            i1 = 3;
          }
          localAbsAECaptureButton.setFunctionFlag(i1);
        }
      }
      else
      {
        this.B.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
      }
    }
    this.B.setFunctionFlag(this.d.u().b());
  }
  
  public void a(boolean paramBoolean)
  {
    URLImageView localURLImageView = this.J;
    if (localURLImageView != null)
    {
      if (!this.L) {
        return;
      }
      if (paramBoolean)
      {
        m();
        return;
      }
      localURLImageView.setVisibility(8);
    }
  }
  
  protected int b()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2063859718);
  }
  
  protected void initView()
  {
    this.E = AECameraEntryManager.o(this.mActivity.getIntent());
    this.F = AECameraEntryManager.q(this.mActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2063991433);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    p();
    s();
    r();
    C();
    q();
    c();
    f();
    e();
    d();
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    ThreadManager.getUIHandler().post(new VideoStoryPiecesPart.7(this));
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    CountDownView localCountDownView = this.A;
    if (localCountDownView != null) {
      localCountDownView.a();
    }
    AEQLog.b("VideoStoryPiecesPart", "unregister adapter observer");
    this.aa.a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 10006)) && (paramInt2 == -1))
    {
      AEMaterialPanel localAEMaterialPanel = this.s;
      if (localAEMaterialPanel != null) {
        localAEMaterialPanel.a(paramInt1, paramInt2, paramIntent);
      } else if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
      if (this.mActivity != null) {
        this.mActivity.finish();
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    T();
    AEQLog.b("VideoStoryPiecesPart", "register adapter observer for template list update");
    this.aa.a(this, 116);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject1 = null;
    Object localObject2;
    switch (i1)
    {
    default: 
    case 2063991510: 
      AEBaseDataReporter.a().Y();
      localObject1 = AEMaterialManager.n();
      if (localObject1 != null)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("sourcetype", String.valueOf(20));
        ((HashMap)localObject2).put("filterid", ((AEMaterialMetaData)localObject1).m);
        ((HashMap)localObject2).put("filtername", ((AEMaterialMetaData)localObject1).H);
        ((HashMap)localObject2).put("ext1from", "3");
        QCircleUtils.a().enterBySchemeAction(paramView.getContext(), "openpolymerize", (HashMap)localObject2);
        return;
      }
      break;
    case 2063991250: 
    case 2063991251: 
      this.d.ay();
      VSReporter.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      AEBaseDataReporter.a().L();
      return;
    case 2063991157: 
      if (this.mPartManager != null) {
        this.mPartManager.b(786433, new Object[0]);
      }
      if (this.E)
      {
        localObject2 = AEMaterialManager.n();
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          paramView = new HashMap();
          paramView.put("ext2", ((AEMaterialMetaData)localObject2).m);
        }
        AEReportUtils.c(2, paramView);
        return;
      }
      break;
    case 2063990918: 
      if (this.mPartManager != null)
      {
        this.mPartManager.b(786436, new Object[0]);
        return;
      }
      break;
    case 2063990914: 
    case 2063990930: 
    case 2063990931: 
      if (this.E)
      {
        if (AEFastClickThrottle.a(paramView)) {
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("ae_editor_bottom_tab_show_hide");
        ((Intent)localObject1).putExtra("is_show", false);
        this.d.s().sendBroadcast((Intent)localObject1);
        AEReportUtils.b(4, null);
      }
      if ((AECameraEntryManager.f(this.P)) && (this.S) && (y()))
      {
        AEQLog.a("VideoStoryPiecesPart", "entry dynamics: need jump from ad pendent");
        this.d.a(this.U, this.R);
        this.S = false;
        this.m.getForegroundView().setImageResource(2063925554);
        localObject1 = this.Y;
        if ((localObject1 != null) && (((PAGView)localObject1).isPlaying()))
        {
          this.Y.stop();
          this.m.removeView(this.Y);
        }
        AECameraPrefsUtil.a().a(this.V, false, 4);
        if (FileUtils.fileExistsAndNotEmpty(X)) {
          FileUtils.deleteFile(X);
        }
        AEBaseDataReporter.a().i(this.R);
      }
      else if ((!this.E) && (!this.F))
      {
        this.d.am().a(true, 150);
        this.r.a(null);
        this.mPartManager.b(196612, new Object[0]);
      }
      else
      {
        this.mPartManager.b(131076, new Object[0]);
      }
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      if (this.F) {
        AEBaseDataReporter.a().k();
      }
      AEBaseDataReporter.a().O();
      AECameraDaTongHelper.a.a(paramView, null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AEQLog.a("VideoStoryPiecesPart", "[BeautyTip]---clearBeautyTip when exit");
    G();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
      case 327701: 
        W();
        return;
      case 327700: 
        Y();
        return;
      case 327699: 
        AEQLog.a("VideoStoryPiecesPart", "PIECES_SEND_ACTION_ARCAKE_RED_DOT_SHOW");
        if (paramVarArgs != null)
        {
          if (paramVarArgs.length == 0) {
            return;
          }
          if (!this.F) {
            return;
          }
          boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("arcake : isShow");
          paramVarArgs.append(bool);
          AEQLog.a("VideoStoryPiecesPart", paramVarArgs.toString());
          if (bool)
          {
            this.m.getForegroundView().setImageResource(2063925264);
            return;
          }
          this.m.getForegroundView().setImageResource(2063925261);
          return;
        }
        return;
      case 327698: 
        AEQLog.b("VideoStoryPiecesPart", "PIECES_SEND_ACTION_ARCAKE_START_UP_ANIM");
        if (this.t != null)
        {
          AEQLog.a("VideoStoryPiecesPart", "doOpenProviderView");
          this.t.b();
          return;
        }
        break;
      case 327697: 
        U();
        return;
      }
      break;
    case 327688: 
      j();
      return;
    case 327687: 
      m();
      return;
    case 327686: 
      X();
      return;
    case 327685: 
      paramVarArgs = this.u;
      if (paramVarArgs != null)
      {
        paramVarArgs.d();
        return;
      }
      break;
    case 327684: 
      V();
      return;
    case 327683: 
      AEMaterialPanel localAEMaterialPanel = this.s;
      if (localAEMaterialPanel != null) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0))
        {
          if ((paramVarArgs[0] instanceof AEMaterialMetaData))
          {
            paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
            if (this.E)
            {
              localAEMaterialPanel.setVisibility(0);
              this.s.a(paramVarArgs.o, paramVarArgs.m, true);
              this.h.b().postValue(Boolean.valueOf(true));
            }
            else
            {
              this.r.a(paramVarArgs);
            }
          }
        }
        else if (this.E)
        {
          this.s.setVisibility(0);
          this.s.a(null, null, false);
          this.h.b().postValue(Boolean.valueOf(true));
        }
        else
        {
          this.r.a(null);
        }
      }
      VSReporter.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart
 * JD-Core Version:    0.7.0.1
 */