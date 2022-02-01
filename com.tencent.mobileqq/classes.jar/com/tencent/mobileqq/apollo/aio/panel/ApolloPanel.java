package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloFavViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.App3DConfig;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloPanelRedDotUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.Apollo3DMainInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ApolloPanel
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener, OpenCallback, EmotionPanelListView.PullAndFastScrollListener
{
  public static int a;
  public static boolean a;
  public static int b;
  public static int c;
  private long jdField_a_of_type_Long;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BubbleProducer jdField_a_of_type_ComTencentMobileqqApolloAioBubbleProducer;
  private ApolloNewActionFloatViewController jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController = null;
  private ApolloPanelAdapter jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter;
  private ApolloPanelExtendHelper jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper;
  private ApolloPanelGuideView.ClickCallback jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback = new ApolloPanel.34(this);
  private ApolloPanelGuideView jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView;
  public ApolloPanelManager.PanelClickCallback a;
  private ApolloPanelManager jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager;
  private ApolloPanelTips jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelTips;
  private ApolloTabAdapter jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter;
  private PanelStrategy jdField_a_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy;
  private ApolloSecondaryViewBinder jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder;
  private ApolloManagerServiceImpl jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl;
  private ApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver;
  private ApolloStatusUpdateListener jdField_a_of_type_ComTencentMobileqqApolloListenerApolloStatusUpdateListener = new ApolloPanel.30(this);
  private ApolloDaoManagerServiceImpl jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl;
  IResDownloadListener jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = new ApolloPanel.4(this);
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloPanel.25(this);
  private List<ApolloViewBinder> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private PanelStrategy jdField_b_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private PanelStrategy jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy;
  private List<Integer> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private boolean d;
  public int e;
  private boolean e;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  public ApolloPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Int = 2;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ApolloPanel.20(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager$PanelClickCallback = new ApolloPanel.24(this);
    this.jdField_e_of_type_Int = 1;
    View.inflate(paramContext, 2131558524, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131363166));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363974));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365144));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365143));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363952));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363848);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131363946));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramAttributeSet = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838557);
    paramAttributeSet.addState(new int[] { 16842919 }, localDrawable);
    paramAttributeSet = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = paramContext.getResources().getDrawable(2130838557);
    paramAttributeSet.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362805));
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131378212));
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter = new ApolloTabAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    findViewById(2131378207).setBackgroundColor(paramContext.getResources().getColor(2131165618));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370396));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362799));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362798));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362797));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362745));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout).b(5).a();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelTips = new ApolloPanelTips();
  }
  
  private int a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      return ApolloGameUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return 0;
  }
  
  @NotNull
  private ApolloExtensionObserver a()
  {
    return new ApolloPanel.3(this);
  }
  
  private HashMap<String, String> a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      return new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a();
    }
    return null;
  }
  
  private void a(ApolloManagerServiceImpl paramApolloManagerServiceImpl)
  {
    paramApolloManagerServiceImpl = paramApolloManagerServiceImpl.getCMSActionList();
    if ((paramApolloManagerServiceImpl != null) && (paramApolloManagerServiceImpl.size() != 0))
    {
      paramApolloManagerServiceImpl = paramApolloManagerServiceImpl.iterator();
      while (paramApolloManagerServiceImpl.hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramApolloManagerServiceImpl.next();
        if ((localApolloActionData != null) && (localApolloActionData.isForPlayerAction == 1)) {
          a(localApolloActionData);
        }
      }
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 4, "[handleGetAllActionCoverFrame] CMSDataList is empty.");
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    q();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController = new ApolloNewActionFloatViewController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController.a(paramApolloActionData, paramInt1, paramInt2, paramInt3, paramBundle);
    this.jdField_h_of_type_Boolean = false;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.28(this, paramAppInfo, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    ApolloDtReportUtil.a("panel", paramString1, paramString2, a());
  }
  
  private void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramList != null))
    {
      if (paramList1 == null) {
        return;
      }
      this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a(paramList, paramList1, paramBoolean, this.jdField_h_of_type_Boolean);
    }
  }
  
  private boolean a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      return ((IApolloManagerService)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable();
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      return ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getInt(paramString, 0) == 1;
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter;
    if (localObject != null)
    {
      localObject = ((ApolloTabAdapter)localObject).a();
      if ((localObject != null) && (((List)localObject).size() > 0) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (localObject != null) {
          return ((ApolloActionPackage)localObject).packageId;
        }
      }
    }
    return -1;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder = new ApolloSecondaryViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder.a(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("func showApolloPanel begins. Thread id = ");
        localStringBuilder.append(Thread.currentThread().getId());
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder);
      p();
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void b(int paramInt, View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof ApolloTabAdapter.ViewHolder))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updatePanelTabRedDot view tag is not an holder : ");
      ((StringBuilder)localObject1).append(paramView);
      QLog.e("[cmshow]ApolloPanel", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    paramView = (ApolloTabAdapter.ViewHolder)paramView;
    if (paramView.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter;
      if (localObject2 != null)
      {
        localObject2 = (ApolloActionPackage)((ApolloTabAdapter)localObject2).a().get(paramInt);
        String str = ApolloPanelRedDotUtil.a(((ApolloActionPackage)localObject2).packageId);
        if ((str != null) && (ApolloPanelRedDotUtil.a(((ApolloActionPackage)localObject2).packageId))) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("level", 1);
            ((IRedTouchManager)localObject1).onRedTouchItemClick(((IRedTouchManager)localObject1).getAppInfoByPath(str), localJSONObject.toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onRedTouchItemClick ");
            ((StringBuilder)localObject1).append(((ApolloActionPackage)localObject2).packageId);
            QLog.d("ApolloPanelRedDotUtil", 1, ((StringBuilder)localObject1).toString());
          }
          catch (Throwable localThrowable)
          {
            QLog.e("[cmshow]ApolloPanel", 1, "Throwable : ", localThrowable);
          }
        }
      }
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.findActionById(paramInt1);
      if (localObject1 == null)
      {
        QLog.w("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.isObtainActionById(paramInt1);
      boolean bool1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.isLimitFreeActionById(paramInt1)) && (((ApolloActionData)localObject1).feeType != 1) && (((ApolloActionData)localObject1).feeType != 10)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(((ApolloActionData)localObject1).feeType) });
      }
      if (bool1)
      {
        a((ApolloActionData)localObject1, 0, 20, paramInt2, null);
        return;
      }
      if (((ApolloActionData)localObject1).feeType == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new ApolloPanel.26(this, (ApolloActionData)localObject1, paramInt2));
        ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(((ApolloActionData)localObject1).actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
        return;
      }
      Object localObject2;
      if (((ApolloActionData)localObject1).feeType == 2)
      {
        if (((ApolloActionData)localObject1).currencyType != 1)
        {
          QLog.w("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
          return;
        }
        if (bool2)
        {
          a((ApolloActionData)localObject1, 0, 23, paramInt2, null);
          return;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("pkgId", paramInt2);
        a((ApolloActionData)localObject1, 2, 23, paramInt2, (Bundle)localObject2);
        return;
      }
      if (((ApolloActionData)localObject1).feeType == 9)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.isSuperYellow((String)localObject2))
        {
          a((ApolloActionData)localObject1, 0, 28, paramInt2, null);
          return;
        }
        a((ApolloActionData)localObject1, 4, 27, paramInt2, null);
        return;
      }
      QLog.e("[cmshow]ApolloPanel", 1, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(((ApolloActionData)localObject1).feeType) });
      return;
    }
    QLog.w("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
  }
  
  private void c(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(paramString, 1).apply();
    }
  }
  
  private void d(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a(paramInt, b(paramInt));
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt)
    {
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick tab postion=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
      }
      setTabSelect(paramInt);
      int m = 0;
      int n = 0;
      while (m < paramInt)
      {
        n += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        m += 1;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(n, false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter.a();
        if (localObject != null)
        {
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clciktabreddot", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
          if ((((ApolloActionPackage)localObject).packageId == 10) || (((ApolloActionPackage)localObject).packageId == 302))
          {
            if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1))
            {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_c2c", "click", "", "", "", "");
              return;
            }
            if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_qun", "click", "", "", "", "");
            }
          }
        }
        else {}
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCurrentItem exception e=");
        localStringBuilder.append(localThrowable.toString());
        QLog.e("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void f(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      int m = a();
      if ((paramInt == 0) || (paramInt == m)) {
        paramInt = m;
      }
      m = paramInt;
      if (paramInt == 2)
      {
        m = paramInt;
        if (!a()) {
          m = 1;
        }
      }
      g(m);
    }
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_e_of_type_Int != paramInt) && (QLog.isColorLevel())) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "setCurrentPanelType targetPanelType=", Integer.valueOf(paramInt) });
    }
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy = this.jdField_b_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy;
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy;
  }
  
  private void n()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "[initData]");
    }
    i();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    ApolloNewActionFloatViewController localApolloNewActionFloatViewController = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController;
    if (localApolloNewActionFloatViewController != null)
    {
      localApolloNewActionFloatViewController.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController = null;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void s()
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.29(this));
  }
  
  private void t()
  {
    if (getVisibility() == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAioBubbleProducer.b())
      {
        QLog.d("[cmshow]ApolloPanel", 2, "showGuidePageFor3D for json");
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloAioBubbleProducer.b(false);
        l();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAioBubbleProducer.a())
      {
        QLog.d("[cmshow]ApolloPanel", 2, "showGuidePageFor3D for action");
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloAioBubbleProducer.a(false);
        l();
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[checkInitGuidePage]");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558608, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setClickCallback(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback);
      addView(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView, -1, -1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.bringToFront();
  }
  
  private void v()
  {
    ApolloPanelGuideView localApolloPanelGuideView = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView;
    if ((localApolloPanelGuideView != null) && (localApolloPanelGuideView.getParent() == this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView = null;
      jdField_c_of_type_Int = 0;
    }
  }
  
  private void w()
  {
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int n = jdField_a_of_type_Int;
    if ((m > n) && ((this.jdField_a_of_type_JavaUtilList.get(n) instanceof ApolloTagActionViewBinder))) {
      ((ApolloTagActionViewBinder)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).e();
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter == null) {
        return;
      }
      int m = a(jdField_a_of_type_Int);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter.a();
      if ((localObject != null) && (((List)localObject).size() != 0) && (m >= 0))
      {
        if (m >= ((List)localObject).size()) {
          return;
        }
        localObject = (ApolloActionPackage)((List)localObject).get(m);
        if (localObject != null) {
          m = ((ApolloActionPackage)localObject).packageId;
        } else {
          m = 0;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), m, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt > 0)
    {
      int m = 0;
      int n = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        n += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        if (paramInt < n) {
          return m;
        }
        m += 1;
      }
    }
    return 0;
  }
  
  public ApolloViewBinder a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getViewBinder type = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" packageId = ");
      localStringBuilder.append(paramInt2);
      QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    }
    return this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a(paramInt1, paramInt2);
  }
  
  public HorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
  }
  
  public void a()
  {
    ThreadManager.post(new ApolloPanel.9(this), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 2) {}
      }
      else
      {
        if (!FileUtil.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))
        {
          b(paramInt, 3);
          ((ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).addDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
          return;
        }
        ApolloPanelAdapter localApolloPanelAdapter = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter;
        if (localApolloPanelAdapter != null) {
          localApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
        }
        b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        return;
      }
    }
    b(paramInt, 1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jumpPkgId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) != 1)
      {
        QLog.d("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] status not open, abort jump");
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if ((paramInt1 == -1) && (paramInt2 == -1))
        {
          QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] abort finding action index");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter == null)
        {
          QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] failed, no view pager");
          return;
        }
        int i6 = this.jdField_a_of_type_JavaUtilList.size();
        int i5 = 0;
        int m = -1;
        int i2 = 0;
        int i1;
        int n;
        for (int i3 = -1; (i5 < i6) && (m == -1); i3 = i1)
        {
          localObject = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i5);
          if (localObject == null)
          {
            i1 = i3;
          }
          else
          {
            ApolloInfo localApolloInfo;
            if (((ApolloViewBinder)localObject).jdField_d_of_type_Int == paramInt1)
            {
              if (paramInt2 == -1)
              {
                m = i2;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump for pkg, newViewPagerIndex=", Integer.valueOf(i2) });
                m = i2;
                break;
              }
              localList = ((ApolloViewBinder)localObject).jdField_a_of_type_JavaUtilList;
              if ((localList != null) && (localList.size() > 0))
              {
                i7 = localList.size();
                i4 = 0;
                for (;;)
                {
                  n = m;
                  i1 = i3;
                  if (i4 >= i7) {
                    break;
                  }
                  localApolloInfo = (ApolloInfo)localList.get(i4);
                  if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramInt2))
                  {
                    ((ApolloViewBinder)localObject).b(i4);
                    n = ((ApolloViewBinder)localObject).a(i4) + i2;
                    if (QLog.isColorLevel()) {
                      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found, jumpActionIndex=", Integer.valueOf(i4), ", newViewPagerIndex=", Integer.valueOf(n) });
                    }
                    i1 = i4;
                    break;
                  }
                  i4 += 1;
                }
              }
              m = i2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction true, just jump pkg, newViewPagerIndex=", Integer.valueOf(i2) });
              m = i2;
              break;
            }
            List localList = ((ApolloViewBinder)localObject).jdField_a_of_type_JavaUtilList;
            if ((localList == null) && (localList.size() == 0)) {
              break;
            }
            int i7 = localList.size();
            int i4 = 0;
            for (;;)
            {
              n = m;
              i1 = i3;
              if (i4 >= i7) {
                break;
              }
              localApolloInfo = (ApolloInfo)localList.get(i4);
              if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramInt2))
              {
                n = m;
                i1 = i3;
                if (paramInt1 != ((ApolloViewBinder)localObject).jdField_d_of_type_Int) {
                  break;
                }
                ((ApolloViewBinder)localObject).b(i4);
                n = i2 + ((ApolloViewBinder)localObject).a(i4);
                if (QLog.isColorLevel()) {
                  QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found2, jumpActionIndex=", Integer.valueOf(i4), ", newViewPagerIndex=", Integer.valueOf(n) });
                }
                i1 = i4;
                break;
              }
              i4 += 1;
            }
            i2 += ((ApolloViewBinder)localObject).a();
            m = n;
          }
          i5 += 1;
        }
        if (m != -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump to new index=", Integer.valueOf(m), ", current index=", Integer.valueOf(jdField_a_of_type_Int) });
          }
          n = jdField_a_of_type_Int;
          if (n != m)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(m, false);
            setTabSelect(a(m));
            jdField_a_of_type_Int = m;
          }
          if ((m >= n - 1) && (m <= n + 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloPanel", 2, "[jumpToPkgOrAction] force refresh cache view");
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter.notifyDataSetChanged();
          }
        }
        if (i3 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
          }
          if (!this.jdField_c_of_type_Boolean)
          {
            localObject = this.jdField_a_of_type_AndroidWidgetImageView;
            if (localObject != null) {
              ((ImageView)localObject).setVisibility(0);
            }
            this.jdField_c_of_type_Boolean = true;
            this.jdField_f_of_type_Int = paramInt2;
            this.jdField_g_of_type_Int = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloPanel", 2, "[jumpToPkgOrAction] no action found, try to update json");
            }
            ((ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadJson(1);
          }
        }
        return;
      }
      QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] jump failed, no binder data");
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public void a(int paramInt1, int paramInt2, ApolloPanel paramApolloPanel)
  {
    if (paramApolloPanel == null) {
      return;
    }
    if ((paramInt1 != 21) && (paramInt2 != 21)) {
      return;
    }
    boolean bool2 = true;
    boolean bool1;
    if (paramInt2 == 21)
    {
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(0)).b == 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView == null))
      {
        paramApolloPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((paramApolloPanel != null) && (paramApolloPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ApolloDtReportUtil.a("panel", "new_user_v2", "expose", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).f(paramInt1).a());
          bool1 = bool2;
          break label236;
        }
      }
      a(ApolloDtReportUtil.a(b(jdField_a_of_type_Int)), "expose");
      paramApolloPanel = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      bool1 = bool2;
      if (paramApolloPanel != null)
      {
        bool1 = bool2;
        if (paramApolloPanel.getVisibility() == 0)
        {
          a("panel_store", "expose");
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    label236:
    ((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext().b(bool1);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject1 != null)
      {
        if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter.a();
        if (paramInt >= ((List)localObject1).size()) {
          return;
        }
        localObject1 = (ApolloActionPackage)((List)localObject1).get(paramInt);
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject1).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject1).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
        Object localObject2;
        if ((((ApolloActionPackage)localObject1).packageId == 8) && (!((ApolloActionPackage)localObject1).isRecommendTabClick))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("apollo_sp");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("apollo_sp_key_recommend_tab_click", true).commit();
          ((ApolloActionPackage)localObject1).isRecommendTabClick = true;
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if (((ApolloActionPackage)localObject1).isUpdate)
        {
          if (NetConnInfoCenter.getServerTimeMillis() < ((ApolloActionPackage)localObject1).redStartTime) {
            return;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("clear tab red packageId=");
          ((StringBuilder)localObject2).append(((ApolloActionPackage)localObject1).packageId);
          ((StringBuilder)localObject2).append(" tabIndex = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject2).toString());
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((ApolloActionPackage)localObject1).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject1).redFlowId;
          QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject1).packageId), ", new action id=", Integer.valueOf(paramInt) });
          ThreadManager.post(new ApolloPanel.22(this, (ApolloActionPackage)localObject1), 5, null, true);
          QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.jdField_h_of_type_Boolean), ", mIsTriggeredByClick=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
          if ((this.jdField_h_of_type_Boolean) && (paramInt != 0))
          {
            paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
            paramView.arg1 = paramInt;
            paramView.getData().putInt("pkgId", ((ApolloActionPackage)localObject1).packageId);
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView, 800L);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "auth_finish");
    }
    post(new ApolloPanel.15(this, paramString, paramInt));
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy = new Panel2DStrategy(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a(new ApolloPanel.1(this));
    this.jdField_b_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy = new Panel3DStrategy(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_b_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a(new ApolloPanel.2(this));
    this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_g_of_type_Int = paramInt1;
      this.jdField_f_of_type_Int = paramInt2;
    }
    this.jdField_h_of_type_Int = paramInt3;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.addApolloStatusUpdateListener(this.jdField_a_of_type_ComTencentMobileqqApolloListenerApolloStatusUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioBubbleProducer = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getBubbleProducer();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloPanelManager();
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager;
    if (paramBaseChatPie != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramBaseChatPie.a.get()));
    }
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103200.103250");
    ((IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(100, null);
    QZoneVipInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramBaseChatPie = MobileQQ.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("chat_tool_apollo_");
    paramSessionInfo.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramBaseChatPie.getBoolean(paramSessionInfo.toString(), false))
    {
      paramBaseChatPie = paramBaseChatPie.edit();
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("chat_tool_apollo_");
      paramSessionInfo.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramBaseChatPie.putBoolean(paramSessionInfo.toString(), false).commit();
      paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.obtainMessage(51).sendToTarget();
      }
    }
    if (ApolloManagerServiceImpl.sFirstOpenPanel)
    {
      QLog.d("[cmshow]ApolloPanel", 1, "[initPanel] getUserApolloInfo");
      this.jdField_b_of_type_Boolean = true;
      ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 1082392704, "Open Panel");
      ApolloManagerServiceImpl.sFirstOpenPanel = false;
    }
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper = new ApolloPanelExtendHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper.a();
    setBackgroundColor(super.getResources().getColor(2131165620));
    o();
    n();
    QLog.d("[cmshow]ApolloPanel", 2, "init panel done");
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloPanel handleCMSPlayerGetFrame : ");
    localStringBuilder.append(paramApolloActionData.toString());
    QLog.d("[cmshow]ApolloPanel", 4, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.handleCMSPlayerGetFrame("apolloPanel", paramApolloActionData, new ApolloPanel.FrameCallback(this.jdField_a_of_type_JavaUtilList, paramApolloActionData));
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    if (paramApolloInfo != null)
    {
      if (paramApolloInfo.mAction == null) {
        return;
      }
      int i1 = 0;
      int m = 0;
      int n;
      for (;;)
      {
        n = i1;
        if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        Object localObject1 = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m);
        if ((((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList != null) && (((ApolloViewBinder)localObject1).jdField_c_of_type_Int == 2))
        {
          if (((ApolloViewBinder)localObject1).b != 5)
          {
            ((ApolloViewBinder)localObject1).a(5);
            localObject2 = new ApolloInfo();
            ((ApolloInfo)localObject2).mType = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131690026);
            ((ApolloInfo)localObject2).mAction = localApolloActionData;
            ((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
          }
          localObject1 = ((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList;
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if ((localObject2 != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
            paramApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramApolloInfo, paramApolloInfo.mAction);
          }
          ((List)localObject1).add(1, paramApolloInfo);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("add action to fav action ");
            ((StringBuilder)localObject1).append(paramApolloInfo.toString());
            QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject1).toString());
          }
          n = 1;
          break;
        }
        m += 1;
      }
      paramApolloInfo = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter;
      if ((paramApolloInfo != null) && (n != 0)) {
        paramApolloInfo.notifyDataSetChanged();
      }
      paramApolloInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((paramApolloInfo != null) && (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (n == 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.27(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (TextUtils.isEmpty(paramString5)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showAidDialog title=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" content=");
        localStringBuilder.append(paramString3);
        localStringBuilder.append("rightString=");
        localStringBuilder.append(paramString4);
        localStringBuilder.append(" url=");
        localStringBuilder.append(paramString5);
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        return;
      }
      j();
      boolean bool = "onlyRightType".equals(paramString5);
      int m = 0;
      if (bool)
      {
        paramString1 = new ApolloPanel.16(this);
        m = 1;
      }
      else
      {
        if ("moreInfo".equals(paramString5)) {
          paramString1 = new ApolloPanel.17(this, paramString7);
        }
        for (;;)
        {
          break;
          if ("requestSSO".equals(paramString5))
          {
            paramString1 = new ApolloPanel.18(this, paramString1, paramString7, paramString8);
          }
          else
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
            {
              ApolloUtilImpl.jumpToH5PreviewAction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString7, paramString9);
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              m = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              paramString2 = new StringBuilder();
              paramString2.append("");
              paramString2.append(paramString7);
              VipUtils.a(paramString1, "cmshow", "Apollo", "vip_alert_view", m, 0, new String[] { paramString2.toString(), "0" });
              return;
            }
            paramString1 = new ApolloPanel.19(this, paramString5, paramString6, paramString7, paramString1, paramString9);
          }
        }
      }
      paramString6 = super.getResources().getString(2131695005);
      if (m != 0) {
        paramString5 = null;
      } else {
        paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getPackageInfoBySession(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (localObject4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanel", 2, "packageList is null.");
        }
        return;
      }
      localObject1 = this.jdField_c_of_type_JavaUtilList;
      if (localObject1 != null) {
        ((List)localObject1).clear();
      }
      this.jdField_g_of_type_Boolean = false;
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      int i2 = 0;
      int m = -1;
      int n = 0;
      long l1;
      Object localObject3;
      Object localObject5;
      label499:
      Object localObject2;
      long l2;
      for (;;)
      {
        int i1 = ((List)localObject4).size();
        String str1 = "apollo_sp";
        if (i2 >= i1) {
          break;
        }
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)((List)localObject4).get(i2);
        if ((localApolloActionPackage != null) && (localApolloActionPackage.packageId != 4) && (this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a(localApolloActionPackage.packageId)))
        {
          String str2 = DeviceInfoUtil.c();
          if (!ApolloUtilImpl.verifyActionPackageVersion(localApolloActionPackage, str2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("version not correct packageId=");
            ((StringBuilder)localObject1).append(localApolloActionPackage.packageId);
            QLog.w("[cmshow]ApolloPanel", 1, ((StringBuilder)localObject1).toString());
          }
          else
          {
            l1 = System.currentTimeMillis();
            ApolloViewBinder localApolloViewBinder = a(localApolloActionPackage.type, localApolloActionPackage.packageId);
            if (localApolloViewBinder != null)
            {
              localApolloViewBinder.jdField_d_of_type_Int = localApolloActionPackage.packageId;
              localApolloViewBinder.a(this);
              ArrayList localArrayList3 = new ArrayList();
              Object localObject6;
              if ((localApolloActionPackage.packageId != 10) && (localApolloActionPackage.packageId != 302)) {
                if (localApolloActionPackage.type == 2)
                {
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getFavPanelActionPairInfo();
                  localObject1 = (List)((Pair)localObject3).first;
                  localObject3 = (List)((Pair)localObject3).second;
                  if ((localObject1 != null) && (((List)localObject1).size() > 0))
                  {
                    localApolloViewBinder.a(5);
                    localObject5 = new ApolloInfo();
                    ((ApolloInfo)localObject5).mType = 2;
                    localObject6 = new ApolloActionData();
                    ((ApolloActionData)localObject6).actionName = super.getResources().getString(2131690026);
                    ((ApolloInfo)localObject5).mAction = ((ApolloActionData)localObject6);
                    localArrayList3.add(localObject5);
                  }
                  else
                  {
                    localApolloViewBinder.a(4);
                  }
                }
                else
                {
                  if (localApolloActionPackage.type != 100) {
                    break label499;
                  }
                }
              }
              boolean bool1;
              int i3;
              for (;;)
              {
                localObject3 = null;
                localObject1 = null;
                localObject6 = null;
                localObject5 = localObject1;
                break;
                if (localApolloActionPackage.packageId == 8)
                {
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getRecommendActionList();
                  localObject1 = (List)((Pair)localObject3).first;
                  localObject3 = (List)((Pair)localObject3).second;
                  localApolloViewBinder.a(0);
                }
                for (;;)
                {
                  localObject5 = null;
                  localObject6 = localObject1;
                  break;
                  if (((!CmShowWnsUtils.d()) && (localApolloActionPackage.packageId != 9)) || (CmShowWnsUtils.d()))
                  {
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getActionByPackageId(localApolloActionPackage.packageId);
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getPackageActionDataById(localApolloActionPackage.packageId);
                    localApolloViewBinder.a(0);
                  }
                  else
                  {
                    localObject3 = null;
                    localObject1 = null;
                  }
                  if (localApolloActionPackage.packageId == 6)
                  {
                    localApolloViewBinder.a(9);
                    this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.rearrangeEnhanceAction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (List)localObject3);
                  }
                  else if (localApolloActionPackage.packageId == 7)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.rearrangeEnhanceAction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (List)localObject3);
                  }
                }
                if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 1))
                {
                  bool1 = CmShowWnsUtils.j();
                  i1 = 4021;
                }
                else if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 2))
                {
                  bool1 = CmShowWnsUtils.k();
                  i1 = 4022;
                }
                else
                {
                  bool1 = false;
                  i1 = -1;
                }
                boolean bool2 = StudyModeManager.a();
                if ((bool1) && (!bool2))
                {
                  try
                  {
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getBattleGameList(i1);
                  }
                  catch (Throwable localThrowable)
                  {
                    QLog.d("[cmshow]ApolloPanel", 1, "[initPanelData]   getBattleGameList error! exception = ", localThrowable);
                    localObject2 = null;
                  }
                  if ((localObject2 != null) && (((List)localObject2).size() > 0))
                  {
                    if ((localApolloViewBinder instanceof ApolloBattleGameViewBinder))
                    {
                      ((ApolloBattleGameViewBinder)localApolloViewBinder).a(i1, (List)localObject2);
                      i3 = localApolloActionPackage.packageId;
                      i1 = 10;
                      if (i3 != 10) {
                        i1 = 11;
                      }
                      localApolloViewBinder.a(i1);
                      localArrayList2.add(localApolloViewBinder);
                      localArrayList1.add(localApolloActionPackage);
                      this.jdField_g_of_type_Boolean = true;
                    }
                    else
                    {
                      QLog.e("[cmshow]ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME packageViewBinder is not ApolloMiniGameViewBinder!");
                    }
                  }
                  else {
                    QLog.w("[cmshow]ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME miniGameInfoList is null!");
                  }
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("[initPanelData] APOLLO_TAB_BATTLE_GAME not show entrance.");
                  ((StringBuilder)localObject2).append("sceneId = ");
                  ((StringBuilder)localObject2).append(i1);
                  ((StringBuilder)localObject2).append(", wnsConfigShowEntrance = ");
                  ((StringBuilder)localObject2).append(bool1);
                  ((StringBuilder)localObject2).append(", studyModeSwitch = ");
                  ((StringBuilder)localObject2).append(bool2);
                  QLog.d("[cmshow]ApolloPanel", 1, new Object[] { localObject2 });
                }
              }
              l2 = System.currentTimeMillis();
              localObject2 = new StringBuilder();
              if (localObject3 != null)
              {
                i1 = 0;
                while (i1 < ((List)localObject3).size())
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                    return;
                  }
                  ApolloActionData localApolloActionData = (ApolloActionData)((List)localObject3).get(i1);
                  if (localApolloActionData == null) {}
                  for (;;)
                  {
                    i3 = m;
                    break label1672;
                    if (ApolloUtilImpl.verifyActionVersion(localApolloActionData, str2)) {
                      break;
                    }
                    ((StringBuilder)localObject2).append(",version ");
                    ((StringBuilder)localObject2).append(localApolloActionData.actionId);
                  }
                  if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1))
                  {
                    if (localApolloActionData.sessionType != 2) {
                      break label1188;
                    }
                    ((StringBuilder)localObject2).append(",special C2C ");
                    ((StringBuilder)localObject2).append(localApolloActionData.actionId);
                  }
                  for (;;)
                  {
                    i3 = m;
                    break label1672;
                    if ((CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) && (localApolloActionData.sessionType == 1))
                    {
                      ((StringBuilder)localObject2).append(",special ");
                      ((StringBuilder)localObject2).append(localApolloActionData.actionId);
                    }
                    else
                    {
                      label1188:
                      if (((ApolloActionData)((List)localObject3).get(i1)).isShow != 0) {
                        break;
                      }
                      ((StringBuilder)localObject2).append(",hide ");
                      ((StringBuilder)localObject2).append(localApolloActionData.actionId);
                    }
                  }
                  if ((localApolloActionPackage.type == 4) && (CMShowPlatform.a.b(Scene.AIO)))
                  {
                    bool1 = CmShowWnsUtils.B();
                    if (QLog.isColorLevel()) {
                      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] showAioPanelSlaveTabOnCEEngine=", Boolean.valueOf(bool1) });
                    }
                    if (!bool1)
                    {
                      i3 = m;
                      break label1672;
                    }
                  }
                  ApolloInfo localApolloInfo = localApolloViewBinder.a(paramString);
                  if (localApolloInfo != null)
                  {
                    localApolloInfo.mAction = localApolloActionData;
                    localApolloInfo.mPackageId = localApolloActionPackage.packageId;
                    if (localApolloActionPackage.type == 2)
                    {
                      if ((localObject5 != null) && (((List)localObject5).size() > i1))
                      {
                        localApolloInfo.mActionText = ((ApolloFavActionData)((List)localObject5).get(i1)).text;
                        localApolloInfo.mTextType = ((ApolloFavActionData)((List)localObject5).get(i1)).textType;
                        localApolloInfo.mAudioId = ((ApolloFavActionData)((List)localObject5).get(i1)).audioId;
                        localApolloInfo.mAudioStartTime = ((ApolloFavActionData)((List)localObject5).get(i1)).audioStartTime;
                        localApolloInfo.mPlayOriginalAudio = ((ApolloFavActionData)((List)localObject5).get(i1)).playOriginalAudio;
                        localApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localApolloInfo, localApolloInfo.mAction);
                      }
                    }
                    else
                    {
                      if ((localObject6 != null) && (((List)localObject6).size() > i1))
                      {
                        localApolloInfo.mActionText = ((ApolloActionPackageData)((List)localObject6).get(i1)).text;
                        localApolloInfo.mTextType = ((ApolloActionPackageData)((List)localObject6).get(i1)).textType;
                      }
                      localApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localApolloInfo, localApolloInfo.mAction);
                    }
                    localArrayList3.add(localApolloInfo);
                  }
                  i3 = m;
                  if (m == -1)
                  {
                    i3 = m;
                    if (this.jdField_f_of_type_Int == localApolloActionData.actionId)
                    {
                      if (this.jdField_g_of_type_Int == -1)
                      {
                        this.jdField_g_of_type_Int = localApolloActionPackage.packageId;
                        if (QLog.isColorLevel()) {
                          QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_g_of_type_Int) });
                        }
                      }
                      i3 = m;
                      if (this.jdField_g_of_type_Int == localApolloActionPackage.packageId) {
                        i3 = localArrayList3.size() - 1;
                      }
                    }
                  }
                  label1672:
                  i1 += 1;
                  m = i3;
                }
                if (localArrayList3.size() > 0)
                {
                  localApolloViewBinder.a(localArrayList3);
                  if (this.jdField_g_of_type_Int == localApolloActionPackage.packageId)
                  {
                    if (m != -1)
                    {
                      localApolloViewBinder.b(m);
                      jdField_a_of_type_Int = localApolloViewBinder.a(m) + n;
                    }
                    else
                    {
                      jdField_a_of_type_Int = n;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(m) });
                    }
                  }
                  localArrayList2.add(localApolloViewBinder);
                  if (localApolloActionPackage.packageId == 8)
                  {
                    localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
                    if ((localObject5 != null) && (((BaseChatPie)localObject5).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                    {
                      localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
                      localObject6 = new StringBuilder();
                      ((StringBuilder)localObject6).append(str1);
                      ((StringBuilder)localObject6).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
                      localApolloActionPackage.isRecommendTabClick = ((BaseApplication)localObject5).getSharedPreferences(((StringBuilder)localObject6).toString(), 0).getBoolean("apollo_sp_key_recommend_tab_click", false);
                      QLog.d("[cmshow]ApolloPanel", 1, new Object[] { "[initPanelData] isRecommendTabClick=", Boolean.valueOf(localApolloActionPackage.isRecommendTabClick) });
                    }
                  }
                  localArrayList1.add(localApolloActionPackage);
                  n += localApolloViewBinder.a();
                }
                else {}
              }
              if (QLog.isColorLevel())
              {
                i1 = localApolloActionPackage.packageId;
                if (localObject3 == null) {
                  localObject3 = null;
                } else {
                  localObject3 = Integer.valueOf(((List)localObject3).size());
                }
                QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(i1), ",actionPackageDatas size:", localObject3, ",findTime:", Long.valueOf(l2 - l1), ",remove actions ", ((StringBuilder)localObject2).toString() });
              }
            }
          }
        }
        i2 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
      }
      if ((this.jdField_f_of_type_Int == -1) && (this.jdField_g_of_type_Int == -1)) {
        a(localArrayList2, localArrayList1, paramBoolean);
      }
      if ((this.jdField_f_of_type_Int != -1) && (m == -1) && (!this.jdField_c_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
        }
        paramString = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramString != null) {
          paramString.post(new ApolloPanel.6(this));
        }
        this.jdField_c_of_type_Boolean = true;
        ((ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadJson(1);
      }
      else if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_g_of_type_Int = -1;
        this.jdField_f_of_type_Int = -1;
      }
      if (localArrayList2.size() > 0)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("apollo_sp");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        localObject3 = paramString.getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
        l1 = NetConnInfoCenter.getServerTime();
        localObject2 = new ArrayList();
        paramString = localArrayList1.iterator();
        while (paramString.hasNext())
        {
          localObject4 = (ApolloActionPackage)paramString.next();
          if ((((ApolloActionPackage)localObject4).isUpdate) && (((ApolloActionPackage)localObject4).packageId != 100))
          {
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("[initPanelData] delete red dot after 24h:");
              ((StringBuilder)localObject5).append(((List)localObject2).size());
              QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject5).toString());
            }
            l2 = NetConnInfoCenter.getServerTimeMillis();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("action_red_tab_update_");
            ((StringBuilder)localObject5).append(((ApolloActionPackage)localObject4).packageId);
            if (l2 - ((SharedPreferences)localObject3).getLong(((StringBuilder)localObject5).toString(), 0L) > ((ApolloActionPackage)localObject4).redInterval)
            {
              ((ApolloActionPackage)localObject4).isUpdate = false;
              ((List)localObject2).add(localObject4);
            }
          }
          if (((ApolloActionPackage)localObject4).isUpdate) {
            if ((((ApolloActionPackage)localObject4).packageId == 100) && (l1 - 0L > 604800000L))
            {
              ((ApolloActionPackage)localObject4).isUpdate = false;
              ((List)localObject2).add(localObject4);
            }
            else {}
          }
        }
        if (!((List)localObject2).isEmpty())
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("[initPanelData] delete red dot after 24h:");
            paramString.append(((List)localObject2).size());
            QLog.d("[cmshow]ApolloPanel", 2, paramString.toString());
          }
          ThreadManager.post(new ApolloPanel.7(this, (List)localObject2), 5, null, true);
        }
        a(localArrayList1);
        b(localArrayList2);
        this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a();
        a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "103100.103200.103250", paramBoolean);
        if (Looper.myLooper() == Looper.getMainLooper()) {
          try
          {
            x();
            return;
          }
          catch (Throwable paramString)
          {
            QLog.e("[cmshow]ApolloPanel", 1, "[reportTabExposure] failed, excetion1=", paramString);
            return;
          }
        }
        this.jdField_a_of_type_MqqOsMqqHandler.post(new ApolloPanel.8(this));
      }
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initBinderData] forceRefresh=", Boolean.valueOf(paramBoolean1), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean2) });
    }
    ThreadManager.post(new ApolloPanel.5(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ApolloPanel.11(this, paramList));
    }
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {
      return;
    }
    String str = (String)paramMap.get("APOLLO_POP_TYPE");
    if ("toast".equals(str))
    {
      str = (String)paramMap.get("offset");
      paramMap = (String)paramMap.get("tips");
      a(Integer.parseInt(str), paramMap);
      return;
    }
    if ("dialog".equals(str)) {
      a((String)paramMap.get("feeType"), (String)paramMap.get("title"), (String)paramMap.get("content"), (String)paramMap.get("rightString"), (String)paramMap.get("url"), (String)paramMap.get("isActionBack"), (String)paramMap.get("actionId"), (String)paramMap.get("extendJson"), (String)paramMap.get("personNum"));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = NetworkUtil.isNetworkAvailable();
    int n = 1;
    if (!bool)
    {
      QQToast.a(getContext(), 1, 2131690023, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject1 != null)
      {
        if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        int m = 2131690084;
        int i1 = 2131690083;
        localObject1 = "change3d";
        String str;
        Object localObject2;
        if (paramBoolean)
        {
          m = 2131690086;
          i1 = 2131690085;
          str = "open_3d_cmshow";
          localObject2 = "change3d";
        }
        else
        {
          str = "open_2d_cmshow";
          localObject1 = "change2d";
          localObject2 = localObject1;
          n = 0;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", (String)localObject2, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[0]);
        a((String)localObject1, "click");
        ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(str, n, new ApolloPanel.35(this, i1, m));
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder;
      if (localObject != null) {
        ((ApolloSecondaryViewBinder)localObject).c();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("actionpanel onOpen response result:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
      if (paramBoolean)
      {
        if (paramObject == null) {
          return;
        }
        paramObject = (Pair)paramObject;
        localObject = (String)paramObject.first;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
            return;
          }
          if (2 == ((Integer)paramObject.second).intValue())
          {
            jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(jdField_a_of_type_Int);
            i();
            return;
          }
          if (1 == ((Integer)paramObject.second).intValue())
          {
            ((ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).checkApolloPanelJsonCfg(false, "panel open apollo", 1);
            paramObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder;
            if (paramObject != null)
            {
              paramObject.a(0);
              a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "del fav action");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject1 != null)
    {
      if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      int i2 = 0;
      int n = 0;
      int i1;
      for (;;)
      {
        int i3 = this.jdField_a_of_type_JavaUtilList.size();
        i1 = 1;
        int m = 1;
        if (n >= i3) {
          break;
        }
        localObject1 = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(n);
        if (((ApolloViewBinder)localObject1).jdField_c_of_type_Int == 2)
        {
          List localList1 = ((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList;
          if ((localList1 != null) && (localList1.size() != 0))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl == null)
            {
              if (QLog.isColorLevel()) {
                QLog.e("[cmshow]ApolloPanel", 2, "apolloDaoManager null");
              }
              return;
            }
            localList1.clear();
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getFavPanelActionPairInfo();
            List localList2 = (List)((Pair)localObject2).first;
            localObject2 = (List)((Pair)localObject2).second;
            ApolloInfo localApolloInfo;
            if ((localList2 != null) && (localList2.size() > 0))
            {
              ((ApolloViewBinder)localObject1).a(5);
              localApolloInfo = new ApolloInfo();
              localApolloInfo.mType = 2;
              ApolloActionData localApolloActionData = new ApolloActionData();
              localApolloActionData.actionName = super.getResources().getString(2131690026);
              localApolloInfo.mAction = localApolloActionData;
              localList1.add(localApolloInfo);
            }
            else
            {
              ((ApolloViewBinder)localObject1).a(4);
              m = 0;
            }
            for (;;)
            {
              i1 = m;
              if (i2 >= ((List)localObject2).size()) {
                break;
              }
              localApolloInfo = ((ApolloViewBinder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
              if (localApolloInfo != null)
              {
                localApolloInfo.mAction = ((ApolloActionData)((List)localObject2).get(i2));
                localApolloInfo.mPackageId = ((ApolloViewBinder)localObject1).jdField_d_of_type_Int;
                if ((localList2 != null) && (localList2.size() > n))
                {
                  localApolloInfo.mActionText = ((ApolloFavActionData)localList2.get(i2)).text;
                  localApolloInfo.mTextType = ((ApolloFavActionData)localList2.get(i2)).textType;
                  localApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localApolloInfo, localApolloInfo.mAction);
                }
                localList1.add(localApolloInfo);
              }
              i2 += 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, "no fav action yet");
          }
          return;
        }
        n += 1;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter;
      if ((localObject1 != null) && (i1 != 0)) {
        ((ApolloPanelAdapter)localObject1).notifyDataSetChanged();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (i1 == 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter;
    if (localObject == null) {
      return;
    }
    localObject = ((ApolloTabAdapter)localObject).a();
    if (localObject != null)
    {
      if (paramInt >= ((List)localObject).size()) {
        return;
      }
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      int m = ((ApolloActionPackage)localObject).type;
      localObject = this.jdField_c_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).contains(Integer.valueOf(paramInt))))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject = (ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all");
          if (m == 2) {
            ((ApolloResManagerImpl)localObject).checkPanelActionRes(paramInt, true);
          } else if ((m != 100) && (m != 9) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 1)) {
            ((ApolloResManagerImpl)localObject).checkPanelActionRes(paramInt, false);
          }
          this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    long l1 = 0L;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateItemStatus action= ");
      ((StringBuilder)localObject).append(paramApolloActionData.actionId);
      ((StringBuilder)localObject).append(" action name =");
      ((StringBuilder)localObject).append(paramApolloActionData.actionName);
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    int m;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      m = 0;
    }
    for (;;)
    {
      try
      {
        if (m < this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount())
        {
          localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(m);
          if ((localObject instanceof ApolloLinearLayout))
          {
            if (((ApolloLinearLayout)localObject).a(paramApolloActionData) != null) {
              break label403;
            }
            continue;
            if (n < ((ViewGroup)localObject).getChildCount())
            {
              LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)localObject).getChildAt(n);
              int i1 = 0;
              if (i1 < localLinearLayout.getChildCount())
              {
                ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localLinearLayout.getChildAt(i1).getTag();
                if (localViewHolder != null)
                {
                  ApolloInfo localApolloInfo = localViewHolder.a;
                  if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramApolloActionData.actionId)) {
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new ApolloPanel.21(this, localViewHolder));
                  }
                }
                i1 += 1;
                continue;
              }
              n += 1;
              continue;
            }
          }
          m += 1;
          continue;
        }
        long l2;
        if (!QLog.isColorLevel()) {
          break label402;
        }
      }
      catch (Exception paramApolloActionData)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateItemStatus error:");
        ((StringBuilder)localObject).append(paramApolloActionData.toString());
        QLog.e("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel())
        {
          l2 = System.currentTimeMillis();
          paramApolloActionData = new StringBuilder();
          paramApolloActionData.append("updateItemStatus cost time = ");
          paramApolloActionData.append(l2 - l1);
          QLog.d("[cmshow]ApolloPanel", 2, paramApolloActionData.toString());
        }
        return;
      }
      QLog.d("[cmshow]ApolloPanel", 2, "something=null ");
      label402:
      return;
      label403:
      int n = 0;
    }
  }
  
  public void b(String paramString)
  {
    f(0);
    a(paramString, false);
  }
  
  public void b(List<ApolloViewBinder> paramList)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ApolloPanel.12(this, paramList));
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      boolean bool2 = QLog.isColorLevel();
      boolean bool1 = true;
      if (bool2) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if ((this.jdField_b_of_type_Boolean) && (!paramBoolean))
      {
        this.jdField_g_of_type_Int = -1;
        this.jdField_f_of_type_Int = -1;
      }
      bool2 = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
      if (paramBoolean)
      {
        if (paramObject != null)
        {
          paramObject = (Bundle)paramObject;
          int m = paramObject.getInt("jumpPkdId", -1);
          int n = paramObject.getInt("jumpActionId", -1);
          if ((m != -1) && (n != -1))
          {
            this.jdField_g_of_type_Int = m;
            this.jdField_f_of_type_Int = n;
          }
        }
        if ((bool2) && (paramBoolean)) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false, paramBoolean);
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      localObject = (ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      ((ApolloExtensionHandler)localObject).a(1, "actionPanel", null);
      int m = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.openType;
      ApolloPanel.10 local10 = new ApolloPanel.10(this, m);
      if (2 == m)
      {
        ((ApolloExtensionHandler)localObject).a("actionPanel", 1, local10);
        return;
      }
      if (1 == m)
      {
        ((ApolloExtensionHandler)localObject).a("actionPanel", 0, local10);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanel", 2, "actionpanel onOpen");
        }
        this.jdField_h_of_type_Int = -1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showGuidePageForOpenCmshow dataType:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("[cmshow]ApolloPanel", 1, ((StringBuilder)localObject1).toString());
      ArrayList localArrayList = new ArrayList();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl;
      if (localObject1 == null)
      {
        QLog.e("[cmshow]ApolloPanel", 1, "showGuidePageForOpenCmshow adm == null");
        ApolloUtilImpl.showDebugTipsToast("showGuidePageForOpenCmshow adm == null");
        return;
      }
      jdField_c_of_type_Int = paramInt;
      if (paramInt == 1)
      {
        localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).getActionByPackageId(400);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((List)localObject2).size() > 4) {
              localObject1 = ((List)localObject2).subList(0, 4);
            }
          }
          paramInt = 0;
          while ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
          {
            localObject2 = new Apollo3DMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            ((Apollo3DMainInfo)localObject2).mAction = ((ApolloActionData)((List)localObject1).get(paramInt));
            localArrayList.add(localObject2);
            paramInt += 1;
          }
        }
        QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
        ApolloUtilImpl.showDebugTipsToast("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
        if (21 == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c())
        {
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ad();
            return;
          }
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.31(this));
        }
        return;
      }
      Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).getRecommendActionDataList();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((List)localObject2).size() > 4) {
            localObject1 = ((List)localObject2).subList(0, 4);
          }
        }
        paramInt = 0;
        while ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((ApolloMainInfo)localObject2).mAction = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          u();
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setGuideType(1);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setActions(localArrayList);
        }
        else
        {
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.33(this, localArrayList));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if (localObject1 != null)
          {
            VipUtils.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "exp_panelnewuser_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), jdField_c_of_type_Int, new String[] { String.valueOf(this.jdField_d_of_type_Int), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
            a("new_user_panel", "expose");
          }
        }
        return;
      }
      QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      ApolloUtilImpl.showDebugTipsToast("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      if (21 == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c())
      {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ad();
          return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.32(this));
      }
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageForOpenCmshow] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject, "aio", ApolloConstant.z, null);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      StartupTracker.a("apollo_panel_open", null);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "dispatchdraw is called");
      }
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchDraw, StackOverflowError, stack:");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramCanvas));
      QLog.e("[cmshow]ApolloPanel", 1, localStringBuilder.toString());
    }
  }
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    super.dispatchVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelTips.a();
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_f_of_type_Boolean = bool;
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      localObject = (ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all");
      ((ApolloResManagerImpl)localObject).addDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
      int m = 0;
      if (!FileUtil.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
        m = 1;
      }
      ((ApolloResManagerImpl)localObject).downloadJson(m);
    }
  }
  
  public void f()
  {
    int m = 0;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m)).b();
      m += 1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject = (ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all");
      ((ApolloResManagerImpl)localObject).removeDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
      ((ApolloResManagerImpl)localObject).removeAllListener();
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager;
      if (localObject != null) {
        ((ApolloPanelManager)localObject).b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver);
      }
    }
    j();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    q();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloSecondaryViewBinder = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelTips.a();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[switch2RedTab] visibility=", Integer.valueOf(super.getVisibility()) });
    }
    if (super.getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[switch2RedTab] visible now, abort");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter;
    if (localObject == null) {
      return;
    }
    localObject = ((ApolloTabAdapter)localObject).a();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      int n = ((List)localObject).size();
      int m = 0;
      while (m < n)
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)((List)localObject).get(m);
        if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
          }
          e(m);
          return;
        }
        m += 1;
      }
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject == null) {
        return;
      }
      ((MqqHandler)localObject).post(new ApolloPanel.13(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 1)
    {
      if (m != 2) {
        return false;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_f_of_type_Boolean))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
        if ((paramMessage != null) && (!TextUtils.isEmpty(paramMessage.content)) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time > 0) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum < this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelTips.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 49, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time, null);
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
          paramMessage.show_sum += 1;
          this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          return false;
        }
      }
    }
    else
    {
      m = paramMessage.getData().getInt("pkgId");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(m) });
      }
      c(paramMessage.arg1, m);
    }
    return false;
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).addDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager;
      if (localObject != null) {
        ((ApolloPanelManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager$PanelClickCallback);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public boolean isPanelOpen()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper.a();
  }
  
  protected void j()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject == null) {
        return;
      }
      ((MqqHandler)localObject).post(new ApolloPanel.23(this));
    }
  }
  
  public void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if ((App3DConfig.sShow) && (this.jdField_e_of_type_Int != 2) && (a()))
      {
        u();
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setGuideType(0);
        localObject = new ArrayList();
        List localList = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getActionByPackageId(400);
        if ((localList != null) && (localList.size() > 0))
        {
          int m = 0;
          while (m < localList.size())
          {
            Apollo3DMainInfo localApollo3DMainInfo = new Apollo3DMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            localApollo3DMainInfo.mAction = ((ApolloActionData)localList.get(m));
            ((List)localObject).add(localApollo3DMainInfo);
            m += 1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.setActions((List)localObject);
        localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject).setDuration(500L);
        ((TranslateAnimation)localObject).setRepeatCount(0);
        ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView.startAnimation((Animation)localObject);
        if (!this.k)
        {
          this.k = true;
          ((ApolloResManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).checkResForGuidePanel();
        }
        return;
      }
      v();
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageFor3D] mBaseChatPie or mGuidePageFor3D or mBaseChatPie.app is null");
  }
  
  public void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null) {
      return;
    }
    QQAppInterface localQQAppInterface = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localQQAppInterface != null)
    {
      if (localObject == null) {
        return;
      }
      int m = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getCmShowStatusNoCareSelfStatus(localQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString, false);
      int n = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject).jdField_a_of_type_Int);
      if (m == 2) {
        localObject = "3D";
      } else {
        localObject = "2D";
      }
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", n, 0, new String[] { localObject });
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363974: 
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "click tab shop");
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        if (this.jdField_e_of_type_Boolean)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
          if (paramView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.clickPushItem(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
            ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
            ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103200.103250");
            this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
            this.jdField_e_of_type_Boolean = false;
            s();
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
            break label297;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.is3dAvailable()) {
          paramView = ApolloConstant.z;
        } else {
          paramView = ApolloConstant.A;
        }
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, "aio", paramView, null);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[0]);
        a("panel_store", "click");
        return;
      }
      break;
    case 2131363952: 
      a(true);
      return;
    case 2131363848: 
      a(false);
      return;
    case 2131362798: 
      label297:
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (paramView != null)
      {
        VipUtils.a(paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, "aio", ApolloConstant.A, null, 14003);
        a("package_slave", "open");
      }
      break;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((m == 1) || (m == 3)) {
      super.getParent().requestDisallowInterceptTouchEvent(false);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ApolloPanel event ");
      localStringBuilder.append(paramMotionEvent.toString());
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { localStringBuilder.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_d_of_type_Boolean = true;
    e(paramInt);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChange state=");
      localStringBuilder.append(paramInt);
      QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled i=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",il=");
      localStringBuilder.append(paramInt2);
      QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pager position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject1).toString());
    }
    int n = a(paramInt);
    if ((this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt - 1))) || (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_i_of_type_Boolean))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("change tab index = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject1).toString());
      }
      setTabSelect(n);
    }
    int m;
    if (paramInt < jdField_a_of_type_Int) {
      m = 1;
    } else {
      m = 0;
    }
    jdField_a_of_type_Int = paramInt;
    d(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloTabAdapter;
    if (localObject1 != null)
    {
      localObject1 = ((ApolloTabAdapter)localObject1).a();
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (n >= 0) && (n < ((List)localObject1).size()))
      {
        localObject1 = (ApolloActionPackage)((List)localObject1).get(n);
        if (localObject1 != null)
        {
          n = ((ApolloActionPackage)localObject1).packageId;
          break label246;
        }
      }
    }
    n = 0;
    label246:
    if (n == 6) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    } else {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject1 != null) {
      localObject1 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
    } else {
      localObject1 = "";
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    Object localObject2;
    if (m != 0) {
      localObject2 = "0";
    } else {
      localObject2 = "1";
    }
    VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, i1, n, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localObject2 = null;
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      m = 0;
      ApolloViewBinder localApolloViewBinder;
      do
      {
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localApolloViewBinder = (ApolloViewBinder)((Iterator)localObject3).next();
        } while ((localApolloViewBinder == null) || (!(localApolloViewBinder instanceof ApolloViewBinder)));
        i1 = localApolloViewBinder.a();
        n = m + i1;
        m = n;
      } while (paramInt + 1 > n);
      if (!(localApolloViewBinder instanceof ApolloSecondaryViewBinder))
      {
        localObject1 = localObject2;
        if (!(localApolloViewBinder instanceof ApolloFavViewBinder)) {}
      }
      else
      {
        localObject1 = localApolloViewBinder.a(i1 - (n - paramInt));
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = new StringBuilder();
        m = ((ArrayList)localObject1).size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (ApolloInfo)((ArrayList)localObject1).get(paramInt);
          if (((ApolloInfo)localObject3).mAction != null) {
            ((StringBuilder)localObject2).append(((ApolloInfo)localObject3).mAction.actionId);
          } else {
            ((StringBuilder)localObject2).append("0");
          }
          if (paramInt != m - 1) {
            ((StringBuilder)localObject2).append("-");
          }
          paramInt += 1;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
  }
  
  public void onPullDown()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper.c();
  }
  
  public void onPullUp()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper.b();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    if ((paramInt == 0) && (this.jdField_e_of_type_Int == 2))
    {
      int m = this.jdField_j_of_type_Int;
      if ((m != -1) && (m != paramInt)) {
        this.jdField_c_of_type_ComTencentMobileqqApolloAioPanelPanelStrategy.a();
      }
    }
    this.jdField_j_of_type_Int = paramInt;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView != null)) {
      v();
    }
    t();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelExtendHelper.a(paramInt);
  }
  
  public void setTabSelect(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_Boolean = true;
      if (this.jdField_g_of_type_Boolean)
      {
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (localSessionInfo != null)
        {
          if (CmShowAioMatcherImpl.judgeSupported(localSessionInfo.jdField_a_of_type_Int, 1))
          {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_c2c", "expo", "", "", "", "");
            return;
          }
          if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_qun", "expo", "", "", "", "");
          }
        }
      }
    }
    else if (paramInt == 8)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      q();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
      }
      this.jdField_h_of_type_Boolean = true;
      if (this.jdField_a_of_type_Long != 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "panel_stay_time", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "", "", "", String.valueOf(l1 - l2) });
        }
        this.jdField_a_of_type_Long = 0L;
      }
      jdField_a_of_type_Boolean = false;
      w();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */