package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager.PanelClickCallback;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.api.impl.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.api.impl.model.App3DConfig;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelRedDotUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.apollo.view.Apollo3DMainInfo;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloFavViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import cooperation.qzone.QZoneVipInfoManager;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ApolloPanel
  extends RelativeLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, OpenCallback, EmotionPanelListView.PullAndFastScrollListener
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
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public BaseChatPie a;
  public ApolloPanelManager.PanelClickCallback a;
  private ApolloPanelManager jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager;
  private ApolloDaoManagerServiceImpl jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl;
  private ApolloExtensionObserverImpl jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl;
  private BubbleProducer jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer;
  private ApolloStatusUpdateListener jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerApolloStatusUpdateListener = new ApolloPanel.31(this);
  IResDownloadListener jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = new ApolloPanel.4(this);
  private ApolloNewActionFloatViewController jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController = null;
  private ApolloPanelAdapter jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter;
  private ApolloPanelExtendHelper jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper;
  private ApolloPanelGuideView.ClickCallback jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView$ClickCallback = new ApolloPanel.35(this);
  private ApolloPanelGuideView jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView;
  private ApolloTabAdapter jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter;
  private PanelStrategy jdField_a_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy;
  private ApolloSecondaryViewBinder jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private CalloutPopupWindow jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloPanel.26(this);
  private Deque<ApolloPanel.PopupWindowData> jdField_a_of_type_JavaUtilDeque;
  private List<ApolloViewBinder> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private PanelStrategy jdField_b_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private PanelStrategy jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy;
  private List<Integer> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private boolean d;
  int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  public int f;
  private boolean f;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  
  static
  {
    jdField_c_of_type_Int = 0;
  }
  
  public ApolloPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_d_of_type_Int = 2;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ApolloPanel.21(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback = new ApolloPanel.25(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = 2;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ApolloPanel.21(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback = new ApolloPanel.25(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Int = 2;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ApolloPanel.21(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback = new ApolloPanel.25(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  @NotNull
  private ApolloExtensionObserverImpl a()
  {
    return new ApolloPanel.3(this);
  }
  
  private HashMap<String, String> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      return new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a();
    }
    return null;
  }
  
  private void a(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramView == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
        {
          if (this.jdField_a_of_type_JavaUtilDeque == null) {
            this.jdField_a_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_a_of_type_JavaUtilDeque.addLast(new ApolloPanel.PopupWindowData(paramView, paramInt1, paramString, paramInt2, paramOnClickListener));
          return;
        }
        paramString = CalloutPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new CalloutPopupWindow.DrawableBuilder(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = paramString.a();
    } while (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.c(2);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(paramOnClickListener);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.setOnDismissListener(new ApolloPanel.9(this));
  }
  
  private void a(ApolloManagerServiceImpl paramApolloManagerServiceImpl)
  {
    paramApolloManagerServiceImpl = paramApolloManagerServiceImpl.getCMSActionList();
    if ((paramApolloManagerServiceImpl == null) || (paramApolloManagerServiceImpl.size() == 0)) {
      QLog.e("ApolloPanel", 4, "[handleGetAllActionCoverFrame] CMSDataList is empty.");
    }
    for (;;)
    {
      return;
      paramApolloManagerServiceImpl = paramApolloManagerServiceImpl.iterator();
      while (paramApolloManagerServiceImpl.hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramApolloManagerServiceImpl.next();
        if ((localApolloActionData != null) && (localApolloActionData.isForPlayerAction == 1)) {
          a(localApolloActionData);
        }
      }
    }
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    s();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController = new ApolloNewActionFloatViewController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController.a(paramApolloActionData, paramInt1, paramInt2, paramInt3, paramBundle);
    this.jdField_i_of_type_Boolean = false;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.29(this, paramAppInfo, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      ApolloDtReportUtil.a("panel", paramString1, paramString2, a());
    }
  }
  
  private void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a(paramList, paramList1, paramBoolean, this.jdField_i_of_type_Boolean);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      bool = false;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getInt(paramString, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return 0;
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
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
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder = new ApolloSecondaryViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder.a(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder);
      r();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void b(int paramInt, View paramView)
  {
    paramView = paramView.getTag();
    IRedTouchManager localIRedTouchManager;
    ApolloActionPackage localApolloActionPackage;
    String str;
    if ((paramView instanceof ApolloTabAdapter.ViewHolder))
    {
      localIRedTouchManager = (IRedTouchManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IRedTouchManager.class, "");
      if ((((ApolloTabAdapter.ViewHolder)paramView).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter != null) && (localIRedTouchManager != null))
      {
        localApolloActionPackage = (ApolloActionPackage)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a().get(paramInt);
        str = ApolloPanelRedDotUtil.a(localApolloActionPackage.packageId);
        if ((str == null) || (!ApolloPanelRedDotUtil.a(localApolloActionPackage.packageId))) {}
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("level", 1);
      localIRedTouchManager.onRedTouchItemClick(localIRedTouchManager.getAppInfoByPath(str), localJSONObject.toString());
      QLog.d("ApolloPanelRedDotUtil", 1, "onRedTouchItemClick " + localApolloActionPackage.packageId);
      ((ApolloTabAdapter.ViewHolder)paramView).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloPanel", 1, "Throwable : ", localThrowable);
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.w("ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
    }
    ApolloActionData localApolloActionData;
    do
    {
      return;
      Object localObject = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localApolloActionData = ((ApolloDaoManagerServiceImpl)localObject).findActionById(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((ApolloDaoManagerServiceImpl)localObject).isObtainActionById(paramInt1);
      if ((((ApolloDaoManagerServiceImpl)localObject).isLimitFreeActionById(paramInt1)) || (localApolloActionData.feeType == 1) || (localApolloActionData.feeType == 10)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(localApolloActionData.feeType) });
        }
        if (!bool1) {
          break;
        }
        a(localApolloActionData, 0, 20, paramInt2, null);
        return;
      }
      if (localApolloActionData.feeType == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new ApolloPanel.27(this, localApolloActionData, paramInt2));
        ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
        return;
      }
      if (localApolloActionData.feeType == 2)
      {
        if (localApolloActionData.currencyType == 1)
        {
          if (bool2)
          {
            a(localApolloActionData, 0, 23, paramInt2, null);
            return;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("pkgId", paramInt2);
          a(localApolloActionData, 2, 23, paramInt2, (Bundle)localObject);
          return;
        }
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
        return;
      }
      if (localApolloActionData.feeType == 9)
      {
        if (((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isSuperYellow(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
        {
          a(localApolloActionData, 0, 28, paramInt2, null);
          return;
        }
        a(localApolloActionData, 4, 27, paramInt2, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(localApolloActionData.feeType) });
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit().putInt(paramString, 1).apply();
  }
  
  private void e(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a(paramInt, b(paramInt));
  }
  
  private void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    int n = b();
    int m = n;
    if (paramInt != 0)
    {
      m = n;
      if (paramInt != n) {
        m = paramInt;
      }
    }
    paramInt = m;
    if (m == 2)
    {
      paramInt = m;
      if (!a()) {
        paramInt = 1;
      }
    }
    g(paramInt);
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_f_of_type_Int != paramInt) && (QLog.isColorLevel())) {
      QLog.d("ApolloPanel", 2, new Object[] { "setCurrentPanelType targetPanelType=", Integer.valueOf(paramInt) });
    }
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_f_of_type_Int == 2)
    {
      this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy = this.jdField_b_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy;
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy;
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[initData]");
    }
    k();
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController = null;
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void u()
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.30(this));
  }
  
  private void v()
  {
    if (getVisibility() == 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer.b()) {
        break label45;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.jdField_k_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer.b(false);
      n();
    }
    label45:
    while (!this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer.a()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer.a(false);
    n();
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[checkInitGuidePage]");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558709, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setClickCallback(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView$ClickCallback);
      addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView, -1, -1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.bringToFront();
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.getParent() == this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView = null;
      jdField_c_of_type_Int = 0;
    }
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int i2 = 0;
    int i1 = i2;
    int m;
    int n;
    if (paramInt > 0)
    {
      m = 0;
      n = 0;
    }
    for (;;)
    {
      i1 = i2;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        n += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        if (paramInt < n) {
          i1 = m;
        }
      }
      else
      {
        return i1;
      }
      m += 1;
    }
  }
  
  public ApolloViewBinder a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type = " + paramInt1 + " packageId = " + paramInt2);
    }
    return this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a(paramInt1, paramInt2);
  }
  
  public HorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
  }
  
  public void a()
  {
    ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl;
    int m;
    ApolloPanel.11 local11;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localApolloExtensionHandlerImpl = (ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      localApolloExtensionHandlerImpl.a(1, "actionPanel", null);
      m = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).openType;
      local11 = new ApolloPanel.11(this, m);
      if (2 != m) {
        break label91;
      }
      localApolloExtensionHandlerImpl.a("actionPanel", 1, local11);
    }
    label91:
    while (1 != m) {
      return;
    }
    localApolloExtensionHandlerImpl.a("actionPanel", 0, local11);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "actionpanel onOpen");
    }
    this.jdField_i_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 0: 
    case 2: 
      b(paramInt, 1);
      return;
    }
    if (!FileUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))
    {
      b(paramInt, 3);
      ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).addDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jumpPkgId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) != 1)
    {
      QLog.d("ApolloPanel", 1, "[jumpToPkgOrAction] status not open, abort jump");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] jump failed, no binder data");
      return;
    }
    if ((paramInt1 == -1) && (paramInt2 == -1))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] abort finding action index");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter == null))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] failed, no view pager");
      return;
    }
    int i1 = 0;
    int m = -1;
    int i2 = -1;
    int i6 = this.jdField_a_of_type_JavaUtilList.size();
    int i5 = 0;
    ApolloViewBinder localApolloViewBinder;
    int i3;
    int n;
    for (;;)
    {
      if ((i5 < i6) && (m == -1))
      {
        localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i5);
        if (localApolloViewBinder == null)
        {
          i3 = m;
          n = i2;
          m = i1;
          i5 += 1;
          i1 = m;
          i2 = n;
          m = i3;
        }
        else if (localApolloViewBinder.jdField_d_of_type_Int == paramInt1)
        {
          if (paramInt2 == -1)
          {
            m = i1;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump for pkg, newViewPagerIndex=", Integer.valueOf(i1) });
              m = i1;
            }
          }
        }
      }
    }
    for (;;)
    {
      label333:
      if (m != -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump to new index=", Integer.valueOf(m), ", current index=", Integer.valueOf(jdField_a_of_type_Int) });
        }
        n = jdField_a_of_type_Int;
        if (jdField_a_of_type_Int != m)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(m, false);
          setTabSelect(a(m));
          jdField_a_of_type_Int = m;
        }
        if ((m >= n - 1) && (m <= n + 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] force refresh cache view");
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
        }
      }
      if (i2 != -1) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
      }
      if (this.jdField_c_of_type_Boolean) {
        break;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_Int = paramInt2;
      this.jdField_h_of_type_Int = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] no action found, try to update json");
      }
      localApolloManagerServiceImpl.downloadJson(1);
      return;
      List localList = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
      label589:
      ApolloInfo localApolloInfo;
      if ((localList != null) && (localList.size() > 0))
      {
        n = 0;
        i3 = localList.size();
        if (n >= i3) {
          break label981;
        }
        localApolloInfo = (ApolloInfo)localList.get(n);
        if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramInt2))
        {
          localApolloViewBinder.b(n);
          m = localApolloViewBinder.a(n) + i1;
          if (!QLog.isColorLevel()) {
            break label968;
          }
          QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found, jumpActionIndex=", Integer.valueOf(n), ", newViewPagerIndex=", Integer.valueOf(m) });
          i2 = n;
          n = m;
          m = i2;
        }
      }
      for (;;)
      {
        i3 = n;
        n = m;
        for (;;)
        {
          m = localApolloViewBinder.a() + i1;
          break;
          n += 1;
          break label589;
          m = i1;
          if (!QLog.isColorLevel()) {
            break label333;
          }
          QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction true, just jump pkg, newViewPagerIndex=", Integer.valueOf(i1) });
          m = i1;
          break label333;
          localList = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
          if ((localList == null) && (localList.size() == 0)) {
            break label333;
          }
          int i4 = 0;
          int i7 = localList.size();
          for (;;)
          {
            n = i2;
            i3 = m;
            if (i4 >= i7) {
              break;
            }
            localApolloInfo = (ApolloInfo)localList.get(i4);
            if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramInt2))
            {
              n = i2;
              i3 = m;
              if (paramInt1 != localApolloViewBinder.jdField_d_of_type_Int) {
                break;
              }
              localApolloViewBinder.b(i4);
              i3 = i1 + localApolloViewBinder.a(i4);
              if (!QLog.isColorLevel()) {
                break label961;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found2, jumpActionIndex=", Integer.valueOf(i4), ", newViewPagerIndex=", Integer.valueOf(i3) });
              n = i4;
              break;
            }
            i4 += 1;
          }
          label961:
          n = i4;
        }
        label968:
        i2 = m;
        m = n;
        n = i2;
        continue;
        label981:
        n = m;
        m = i2;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, ApolloPanel paramApolloPanel)
  {
    boolean bool2 = true;
    if (paramApolloPanel == null) {}
    while ((paramInt1 != 21) && (paramInt2 != 21)) {
      return;
    }
    boolean bool1;
    if (paramInt2 == 21) {
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramInt1 = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ApolloDtReportUtil.a("panel", "new_user_v2", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).f(paramInt1).a());
        bool1 = bool2;
      }
    }
    for (;;)
    {
      ((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext().b(bool1);
      return;
      a(ApolloDtReportUtil.a(b(jdField_a_of_type_Int)), "expose");
      bool1 = bool2;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
        {
          a("panel_store", "expose");
          bool1 = bool2;
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
        } while (paramInt >= ((List)localObject).size());
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
        if ((((ApolloActionPackage)localObject).packageId == 8) && (!((ApolloActionPackage)localObject).isRecommendTabClick))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit().putBoolean("apollo_sp_key_recommend_tab_click", true).commit();
          ((ApolloActionPackage)localObject).isRecommendTabClick = true;
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      } while ((!((ApolloActionPackage)localObject).isUpdate) || (NetConnInfoCenter.getServerTimeMillis() < ((ApolloActionPackage)localObject).redStartTime));
      QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
      ((ApolloTabAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      ((ApolloActionPackage)localObject).isUpdate = false;
      paramInt = ((ApolloActionPackage)localObject).redFlowId;
      QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", new action id=", Integer.valueOf(paramInt) });
      ThreadManager.post(new ApolloPanel.23(this, (ApolloActionPackage)localObject), 5, null, true);
      QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.jdField_i_of_type_Boolean), ", mIsTriggeredByClick=", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    } while ((!this.jdField_i_of_type_Boolean) || (paramInt == 0));
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    paramView.arg1 = paramInt;
    paramView.getData().putInt("pkgId", ((ApolloActionPackage)localObject).packageId);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView, 800L);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "auth_finish");
    }
    post(new ApolloPanel.16(this, paramString, paramInt));
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy = new Panel2DStrategy(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a(new ApolloPanel.1(this));
    this.jdField_b_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy = new Panel3DStrategy(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_b_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a(new ApolloPanel.2(this));
    this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    paramBaseChatPie = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (paramBaseChatPie.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
    }
    this.jdField_i_of_type_Int = paramInt3;
    paramBaseChatPie.addApolloStatusUpdateListener(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplListenerApolloStatusUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer = paramBaseChatPie.getBubbleProducer();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131363232));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131364049));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365267));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365266));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131364025));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363922);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131364019));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838712);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838712);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362861));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131378823));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter = new ApolloTabAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131378819).setBackgroundColor(super.getContext().getResources().getColor(2131165637));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370761));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362855));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362854));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362853));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362795));
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager = paramBaseChatPie.getApolloPanelManager();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a.get()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).b(5).a();
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramBaseChatPie != null) {
        paramBaseChatPie.startWebProcess(100, null);
      }
      QZoneVipInfoManager.preloadQZoneProcess(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) && (this.jdField_i_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (ApolloManagerServiceImpl.sFristOpenPanel)
      {
        QLog.d("ApolloPanel", 1, "[initPanel] getUserApolloInfo");
        this.jdField_b_of_type_Boolean = true;
        ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 1082392704, "Open Panel");
        ApolloManagerServiceImpl.sFristOpenPanel = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a(null);
      }
      paramBaseChatPie = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString))) {
        break label1173;
      }
    }
    label1173:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper = new ApolloPanelExtendHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper.a();
      setBackgroundColor(super.getResources().getColor(2131165639));
      q();
      p();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "init panel done");
      }
      return;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    QLog.d("ApolloPanel", 4, "ApolloPanel handleCMSPlayerGetFrame : " + paramApolloActionData.toString());
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localApolloManagerServiceImpl != null) {
      localApolloManagerServiceImpl.handleCMSPlayerGetFrame("apolloPanel", paramApolloActionData, new ApolloPanel.FrameCallback(this.jdField_a_of_type_JavaUtilList, paramApolloActionData));
    }
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    int i1 = 0;
    if ((paramApolloInfo == null) || (paramApolloInfo.mAction == null)) {}
    int n;
    do
    {
      return;
      int m = 0;
      n = i1;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m);
        if (((ApolloViewBinder)localObject).jdField_a_of_type_JavaUtilList == null) {}
        while (((ApolloViewBinder)localObject).jdField_c_of_type_Int != 2)
        {
          m += 1;
          break;
        }
        if (((ApolloViewBinder)localObject).jdField_b_of_type_Int != 5)
        {
          ((ApolloViewBinder)localObject).a(5);
          ApolloInfo localApolloInfo = new ApolloInfo();
          localApolloInfo.mType = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131690110);
          localApolloInfo.mAction = localApolloActionData;
          ((ApolloViewBinder)localObject).jdField_a_of_type_JavaUtilList.add(0, localApolloInfo);
        }
        localObject = ((ApolloViewBinder)localObject).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          paramApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramApolloInfo, paramApolloInfo.mAction);
        }
        ((List)localObject).add(1, paramApolloInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramApolloInfo.toString());
        }
        n = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (n != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (n != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.28(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString2 + " content=" + paramString3 + "rightString=" + paramString4 + " url=" + paramString5);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null);
    l();
    int m;
    if ("onlyRightType".equals(paramString5))
    {
      m = 1;
      paramString1 = new ApolloPanel.17(this);
      label137:
      paramString6 = super.getResources().getString(2131695015);
      if (m == 0) {
        break label411;
      }
    }
    label411:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new ApolloPanel.18(this, paramString7);
        m = 0;
        break label137;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new ApolloPanel.19(this, paramString1, paramString7, paramString8);
        m = 0;
        break label137;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
      {
        ApolloUtilImpl.jumpToH5PreviewAction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString7, paramString9);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramString7, "0" });
        return;
      }
      paramString1 = new ApolloPanel.20(this, paramString5, paramString6, paramString7, paramString1, paramString9);
      m = 0;
      break label137;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList2;
    List localList2;
    do
    {
      return;
      new ArrayList();
      localArrayList2 = new ArrayList();
      localList2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getPackageInfoBySession(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (localList2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "packageList is null.");
    return;
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList1 = new ArrayList();
    this.jdField_h_of_type_Boolean = false;
    int i3 = 0;
    int n = 0;
    int m = -1;
    label148:
    ApolloActionPackage localApolloActionPackage;
    int i1;
    if (i3 < localList2.size())
    {
      localApolloActionPackage = (ApolloActionPackage)localList2.get(i3);
      if (localApolloActionPackage == null) {
        break label2641;
      }
      if (localApolloActionPackage.packageId == 4)
      {
        i1 = n;
        n = m;
        m = i1;
      }
    }
    for (;;)
    {
      i3 += 1;
      i1 = n;
      n = m;
      m = i1;
      break label148;
      if (!this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a(localApolloActionPackage.packageId))
      {
        i1 = m;
        m = n;
        n = i1;
      }
      else
      {
        String str = DeviceInfoUtil.c();
        if (!localApolloActionPackage.verifyVersion(str))
        {
          QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
          i1 = n;
          n = m;
          m = i1;
        }
        else
        {
          long l2 = System.currentTimeMillis();
          ApolloViewBinder localApolloViewBinder = a(localApolloActionPackage.type, localApolloActionPackage.packageId);
          if (localApolloViewBinder == null)
          {
            i1 = m;
            m = n;
            n = i1;
          }
          else
          {
            localApolloViewBinder.jdField_d_of_type_Int = localApolloActionPackage.packageId;
            localApolloViewBinder.a(this);
            Object localObject1 = null;
            Object localObject3 = null;
            ArrayList localArrayList3 = new ArrayList();
            boolean bool1;
            label434:
            boolean bool2;
            if ((localApolloActionPackage.packageId == 10) || (localApolloActionPackage.packageId == 302))
            {
              i1 = -1;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
              if (localObject1 != null)
              {
                bool1 = false;
                if (CmShowAioMatcher.a(((BaseChatPie)localObject1).b(), 1))
                {
                  i1 = 4021;
                  bool1 = CmShowWnsUtils.h();
                  bool2 = StudyModeManager.a();
                  if ((bool1) && (!bool2)) {
                    localObject1 = null;
                  }
                }
                else
                {
                  try
                  {
                    localList1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getBattleGameList(i1);
                    localObject1 = localList1;
                  }
                  catch (Throwable localThrowable)
                  {
                    for (;;)
                    {
                      List localList1;
                      QLog.d("ApolloPanel", 1, "[initPanelData]   getBattleGameList error! exception = ", localThrowable);
                      continue;
                      i1 = 11;
                      continue;
                      QLog.e("ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME packageViewBinder is not ApolloMiniGameViewBinder!");
                      continue;
                      QLog.e("ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME miniGameInfoList is null!");
                    }
                  }
                  if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
                    if ((localApolloViewBinder instanceof ApolloBattleGameViewBinder))
                    {
                      ((ApolloBattleGameViewBinder)localApolloViewBinder).a(i1, (List)localObject1);
                      if (localApolloActionPackage.packageId == 10)
                      {
                        i1 = 10;
                        localApolloViewBinder.a(i1);
                        localArrayList1.add(localApolloViewBinder);
                        localArrayList2.add(localApolloActionPackage);
                        this.jdField_h_of_type_Boolean = true;
                        localObject1 = null;
                        localList1 = null;
                      }
                    }
                  }
                }
              }
            }
            label554:
            long l1;
            Object localObject4;
            Object localObject5;
            label614:
            Object localObject2;
            for (;;)
            {
              l1 = System.currentTimeMillis();
              localObject4 = new StringBuilder();
              if (localList1 == null) {
                break label2625;
              }
              i1 = 0;
              for (;;)
              {
                if (i1 >= localList1.size()) {
                  break label1635;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                  break;
                }
                localObject5 = (ApolloActionData)localList1.get(i1);
                if (localObject5 != null) {
                  break label1119;
                }
                i1 += 1;
              }
              if (!CmShowAioMatcher.a(((BaseChatPie)localObject1).b(), 2)) {
                break label434;
              }
              i1 = 4022;
              bool1 = CmShowWnsUtils.i();
              break label434;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[initPanelData] APOLLO_TAB_BATTLE_GAME not show entrance.").append("sceneId = ").append(i1).append(", wnsConfigShowEntrance = ").append(bool1).append(", studyModeSwitch = ").append(bool2);
              QLog.d("ApolloPanel", 1, new Object[] { localObject1 });
              for (;;)
              {
                break;
                QLog.e("ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME miniGameInfoList is null!");
              }
              if (localApolloActionPackage.type == 2)
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getFavPanelActionPairInfo();
                localObject1 = (List)((Pair)localObject2).first;
                localObject2 = (List)((Pair)localObject2).second;
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  localApolloViewBinder.a(5);
                  localObject5 = new ApolloInfo();
                  ((ApolloInfo)localObject5).mType = 2;
                  localObject4 = new ApolloActionData();
                  ((ApolloActionData)localObject4).actionName = super.getResources().getString(2131690110);
                  ((ApolloInfo)localObject5).mAction = ((ApolloActionData)localObject4);
                  localArrayList3.add(localObject5);
                }
                for (;;)
                {
                  break;
                  localApolloViewBinder.a(4);
                }
              }
              if (localApolloActionPackage.type == 100)
              {
                localObject2 = null;
                localObject1 = null;
              }
              else
              {
                if (localApolloActionPackage.packageId != 8) {
                  break label978;
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getRecommendActionList();
                localObject3 = (List)((Pair)localObject1).first;
                localObject2 = (List)((Pair)localObject1).second;
                localApolloViewBinder.a(0);
                localObject1 = null;
              }
            }
            label978:
            if (((!CmShowWnsUtils.c()) && (localApolloActionPackage.packageId != 9)) || (CmShowWnsUtils.c()))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getActionByPackageId(localApolloActionPackage.packageId);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getPackageActionDataById(localApolloActionPackage.packageId);
              localApolloViewBinder.a(0);
            }
            for (;;)
            {
              if (localApolloActionPackage.packageId == 6)
              {
                localApolloViewBinder.a(9);
                this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.rearrangeEnhanceAction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (List)localObject1);
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = null;
                break label554;
              }
              if (localApolloActionPackage.packageId == 7) {
                this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.rearrangeEnhanceAction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (List)localObject1);
              }
              localObject4 = localObject1;
              localObject1 = null;
              localObject3 = localObject2;
              localObject2 = localObject4;
              break label554;
              label1119:
              if (!((ApolloActionData)localObject5).verifyVersion(str))
              {
                ((StringBuilder)localObject4).append(",version ").append(((ApolloActionData)localObject5).actionId);
                break label614;
              }
              if (CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1))
              {
                if (((ApolloActionData)localObject5).sessionType != 2) {
                  break label1235;
                }
                ((StringBuilder)localObject4).append(",special C2C ").append(((ApolloActionData)localObject5).actionId);
                break label614;
              }
              if ((CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) && (((ApolloActionData)localObject5).sessionType == 1))
              {
                ((StringBuilder)localObject4).append(",special ").append(((ApolloActionData)localObject5).actionId);
                break label614;
              }
              label1235:
              if (((ApolloActionData)((List)localObject2).get(i1)).isShow == 0)
              {
                ((StringBuilder)localObject4).append(",hide ").append(((ApolloActionData)localObject5).actionId);
                break label614;
              }
              ApolloInfo localApolloInfo = localApolloViewBinder.a(paramString);
              if (localApolloInfo != null)
              {
                localApolloInfo.mAction = ((ApolloActionData)localObject5);
                localApolloInfo.mPackageId = localApolloActionPackage.packageId;
                if (localApolloActionPackage.type != 2) {
                  break label1553;
                }
                if ((localObject1 != null) && (((List)localObject1).size() > i1))
                {
                  localApolloInfo.mActionText = ((ApolloFavActionData)((List)localObject1).get(i1)).text;
                  localApolloInfo.mTextType = ((ApolloFavActionData)((List)localObject1).get(i1)).textType;
                  localApolloInfo.mAudioId = ((ApolloFavActionData)((List)localObject1).get(i1)).audioId;
                  localApolloInfo.mAudioStartTime = ((ApolloFavActionData)((List)localObject1).get(i1)).audioStartTime;
                  localApolloInfo.mPlayOriginalAudio = ((ApolloFavActionData)((List)localObject1).get(i1)).playOriginalAudio;
                }
              }
              for (localApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localApolloInfo, localApolloInfo.mAction);; localApolloInfo.iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localApolloInfo, localApolloInfo.mAction))
              {
                localArrayList3.add(localApolloInfo);
                if ((m != -1) || (this.jdField_g_of_type_Int != ((ApolloActionData)localObject5).actionId)) {
                  break label2622;
                }
                if (this.jdField_h_of_type_Int == -1)
                {
                  this.jdField_h_of_type_Int = localApolloActionPackage.packageId;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_h_of_type_Int) });
                  }
                }
                if (this.jdField_h_of_type_Int != localApolloActionPackage.packageId) {
                  break label2622;
                }
                m = localArrayList3.size() - 1;
                break;
                label1553:
                if ((localObject3 != null) && (((List)localObject3).size() > i1))
                {
                  localApolloInfo.mActionText = ((ApolloActionPackageData)((List)localObject3).get(i1)).text;
                  localApolloInfo.mTextType = ((ApolloActionPackageData)((List)localObject3).get(i1)).textType;
                }
              }
              label1635:
              if (0 != 0) {
                throw new NullPointerException();
              }
              int i2 = n;
              i1 = m;
              if (localArrayList3.size() > 0)
              {
                localApolloViewBinder.a(localArrayList3);
                if (this.jdField_h_of_type_Int == localApolloActionPackage.packageId)
                {
                  if (m == -1) {
                    break label1995;
                  }
                  localApolloViewBinder.b(m);
                  jdField_a_of_type_Int = localApolloViewBinder.a(m) + n;
                  label1706:
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(m) });
                  }
                }
                localArrayList1.add(localApolloViewBinder);
                if ((localApolloActionPackage.packageId == 8) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  localApolloActionPackage.isRecommendTabClick = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getBoolean("apollo_sp_key_recommend_tab_click", false);
                  QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] isRecommendTabClick=", Boolean.valueOf(localApolloActionPackage.isRecommendTabClick) });
                }
                localArrayList2.add(localApolloActionPackage);
                i2 = n + localApolloViewBinder.a();
              }
              for (i1 = m;; i1 = m)
              {
                if (QLog.isColorLevel())
                {
                  m = localApolloActionPackage.packageId;
                  if (localObject2 != null) {
                    break label2003;
                  }
                }
                label1995:
                label2003:
                for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject2).size()))
                {
                  QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(m), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l1 - l2), ",remove actions ", ((StringBuilder)localObject4).toString() });
                  m = i2;
                  n = i1;
                  break;
                  jdField_a_of_type_Int = n;
                  break label1706;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
                }
                if ((this.jdField_g_of_type_Int == -1) && (this.jdField_h_of_type_Int == -1)) {
                  a(localArrayList1, localArrayList2, paramBoolean);
                }
                if ((this.jdField_g_of_type_Int != -1) && (m == -1) && (!this.jdField_c_of_type_Boolean))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
                  }
                  if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                    this.jdField_a_of_type_AndroidWidgetImageView.post(new ApolloPanel.6(this));
                  }
                  this.jdField_c_of_type_Boolean = true;
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).downloadJson(1);
                  }
                }
                while ((localArrayList1 != null) && (localArrayList1.size() > 0))
                {
                  paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
                  l2 = NetConnInfoCenter.getServerTime();
                  l1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  localObject2 = new ArrayList();
                  localObject3 = localArrayList2.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject1 = (ApolloActionPackage)((Iterator)localObject3).next();
                    if ((((ApolloActionPackage)localObject1).isUpdate) && (((ApolloActionPackage)localObject1).packageId != 100))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject2).size());
                      }
                      if (NetConnInfoCenter.getServerTimeMillis() - paramString.getLong("action_red_tab_update_" + ((ApolloActionPackage)localObject1).packageId, 0L) > ((ApolloActionPackage)localObject1).redInterval)
                      {
                        ((ApolloActionPackage)localObject1).isUpdate = false;
                        ((List)localObject2).add(localObject1);
                      }
                    }
                    if ((((ApolloActionPackage)localObject1).isUpdate) && (((ApolloActionPackage)localObject1).packageId == 100) && (l2 - l1 > 604800000L))
                    {
                      ((ApolloActionPackage)localObject1).isUpdate = false;
                      ((List)localObject2).add(localObject1);
                    }
                  }
                  if (!this.jdField_b_of_type_Boolean)
                  {
                    this.jdField_h_of_type_Int = -1;
                    this.jdField_g_of_type_Int = -1;
                  }
                }
                break;
                if (!((List)localObject2).isEmpty())
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject2).size());
                  }
                  ThreadManager.post(new ApolloPanel.7(this, (List)localObject2), 5, null, true);
                }
                a(localArrayList2);
                b(localArrayList1);
                this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a();
                a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "103100.103200.103250", paramBoolean);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                  try
                  {
                    e();
                    return;
                  }
                  catch (Throwable paramString)
                  {
                    QLog.e("ApolloPanel", 1, "[reportTabExposure] failed, excetion1=", paramString);
                    return;
                  }
                }
                this.jdField_a_of_type_MqqOsMqqHandler.post(new ApolloPanel.8(this));
                return;
                label2622:
                break label614;
                label2625:
                i2 = n;
              }
              localObject2 = null;
            }
            label2641:
            i1 = m;
            m = n;
            n = i1;
          }
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initBinderData] forceRefresh=", Boolean.valueOf(paramBoolean1), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean2) });
    }
    if (this.jdField_i_of_type_Int == 7) {
      return;
    }
    ThreadManager.post(new ApolloPanel.5(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ApolloPanel.12(this, paramList));
    }
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {}
    String str;
    do
    {
      return;
      str = (String)paramMap.get("APOLLO_POP_TYPE");
      if ("toast".equals(str))
      {
        str = (String)paramMap.get("offset");
        paramMap = (String)paramMap.get("tips");
        a(Integer.parseInt(str), paramMap);
        return;
      }
    } while (!"dialog".equals(str));
    a((String)paramMap.get("feeType"), (String)paramMap.get("title"), (String)paramMap.get("content"), (String)paramMap.get("rightString"), (String)paramMap.get("url"), (String)paramMap.get("isActionBack"), (String)paramMap.get("actionId"), (String)paramMap.get("extendJson"), (String)paramMap.get("personNum"));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!NetworkUtil.a()) {
      QQToast.a(getContext(), 1, 2131690107, 0).a();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    String str1 = "change2d";
    String str2;
    int m;
    String str3;
    int n;
    if (paramBoolean)
    {
      str1 = "change3d";
      str2 = "change3d";
      m = 1;
      str3 = "open_3d_cmshow";
      n = 2131690168;
    }
    for (int i1 = 2131690169;; i1 = 2131690167)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", str1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[0]);
      a(str2, "click");
      ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(str3, m, new ApolloPanel.36(this, n, i1));
      return;
      str2 = "change2d";
      m = 0;
      str3 = "open_2d_cmshow";
      n = 2131690166;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      Pair localPair;
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder.c();
            }
            QLog.d("ApolloPanel", 2, "actionpanel onOpen response result:" + paramBoolean);
          } while ((!paramBoolean) || (paramObject == null));
          localPair = (Pair)paramObject;
          paramObject = (String)((Pair)paramObject).first;
        } while ((TextUtils.isEmpty(paramObject)) || (!paramObject.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())));
        if (2 == ((Integer)localPair.second).intValue())
        {
          jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(jdField_a_of_type_Int);
          k();
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder.a(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio", ApolloConstant.u, null);
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "onClick tab postion=" + paramInt);
      }
      setTabSelect(paramInt);
      int m = 0;
      int n = 0;
      while (m < paramInt)
      {
        n += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        m += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(n, false);
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
          if (localObject == null) {
            return;
          }
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
          {
            paramInt = 2;
            VipUtils.a(null, "cmshow", "Apollo", "clciktabreddot", paramInt, 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
            if ((((ApolloActionPackage)localObject).packageId != 10) && (((ApolloActionPackage)localObject).packageId != 302)) {
              return;
            }
            if (!CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {
              break;
            }
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_c2c", "click", "", "", "", "");
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloPanel", 2, "setCurrentItem exception e=" + localThrowable.toString());
          return;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
      if (CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_qun", "click", "", "", "", "");
      }
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    long l1 = System.currentTimeMillis();
    if (paramApolloActionData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "updateItemStatus action= " + paramApolloActionData.actionId + " action name =" + paramApolloActionData.actionName);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "something=null ");
    return;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m >= this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount()) {
          continue;
        }
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(m);
        if (!(localViewGroup instanceof ApolloLinearLayout)) {
          break label377;
        }
        if (((ApolloLinearLayout)localViewGroup).a(paramApolloActionData) != null) {
          break label384;
        }
      }
      catch (Exception paramApolloActionData)
      {
        ViewGroup localViewGroup;
        LinearLayout localLinearLayout;
        int i1;
        ApolloLinearLayout.ViewHolder localViewHolder;
        ApolloInfo localApolloInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloPanel", 2, "updateItemStatus error:" + paramApolloActionData.toString());
        l2 = System.currentTimeMillis();
      }
      if (n < localViewGroup.getChildCount())
      {
        localLinearLayout = (LinearLayout)localViewGroup.getChildAt(n);
        i1 = 0;
        if (i1 < localLinearLayout.getChildCount())
        {
          localViewHolder = (ApolloLinearLayout.ViewHolder)localLinearLayout.getChildAt(i1).getTag();
          if (localViewHolder != null)
          {
            localApolloInfo = localViewHolder.a;
            if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new ApolloPanel.22(this, localViewHolder));
            }
          }
          i1 += 1;
          continue;
        }
        n += 1;
        continue;
        long l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "updateItemStatus cost time = " + (l2 - l1));
        return;
      }
      label377:
      m += 1;
      continue;
      label384:
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
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ApolloPanel.13(this, paramList));
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    boolean bool2;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if ((this.jdField_b_of_type_Boolean) && (!paramBoolean))
      {
        this.jdField_h_of_type_Int = -1;
        this.jdField_g_of_type_Int = -1;
      }
      bool2 = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
    } while (!paramBoolean);
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      int m = paramObject.getInt("jumpPkdId", -1);
      int n = paramObject.getInt("jumpActionId", -1);
      if ((m != -1) && (n != -1))
      {
        this.jdField_h_of_type_Int = m;
        this.jdField_g_of_type_Int = n;
      }
    }
    if ((bool2) && (paramBoolean)) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false, paramBoolean);
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (localApolloManagerServiceImpl != null)
      {
        localApolloManagerServiceImpl.addDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
        int m = 0;
        if (!FileUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
          m = 1;
        }
        localApolloManagerServiceImpl.downloadJson(m);
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter == null) {}
    int m;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
      } while ((localObject == null) || (paramInt >= ((List)localObject).size()));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      m = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (m == 2) {
      ((ApolloManagerServiceImpl)localObject).checkPanelActionRes(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((m != 100) && (m != 9) && (((ApolloManagerServiceImpl)localObject).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 1)) {
        ((ApolloManagerServiceImpl)localObject).checkPanelActionRes(paramInt, false);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    } while ((localQQAppInterface == null) || (localObject == null));
    int m = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatusNoCareSelfStatus(localQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString, false);
    int n = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject).jdField_a_of_type_Int);
    if (m == 2) {}
    for (Object localObject = "3D";; localObject = "2D")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", n, 0, new String[] { localObject });
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList;
    List localList;
    do
    {
      return;
      QLog.i("ApolloPanel", 1, "showGuidePageForOpenCmshow dataType:" + paramInt);
      localArrayList = new ArrayList();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl == null)
      {
        QLog.e("ApolloPanel", 1, "showGuidePageForOpenCmshow adm == null");
        ApolloUtilImpl.showDebugTipsToast("showGuidePageForOpenCmshow adm == null");
        return;
      }
      jdField_c_of_type_Int = paramInt;
      if (paramInt != 1) {
        break label270;
      }
      localList = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getActionByPackageId(400);
      if ((localList != null) && (!localList.isEmpty())) {
        break;
      }
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      ApolloUtilImpl.showDebugTipsToast("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
    } while (21 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g());
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.aF();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.32(this));
    return;
    if ((localList != null) && (localList.size() > 4)) {
      localList = localList.subList(0, 4);
    }
    for (;;)
    {
      paramInt = 0;
      Object localObject;
      for (;;)
      {
        if ((localList != null) && (paramInt < localList.size()))
        {
          localObject = new Apollo3DMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((Apollo3DMainInfo)localObject).mAction = ((ApolloActionData)localList.get(paramInt));
          localArrayList.add(localObject);
          paramInt += 1;
          continue;
          label270:
          localList = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getRecommndActionDataList();
          if ((localList == null) || (localList.isEmpty()))
          {
            QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            ApolloUtilImpl.showDebugTipsToast("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            if (21 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g()) {
              break;
            }
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.aF();
              return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.33(this));
            return;
          }
          if ((localList == null) || (localList.size() <= 4)) {
            break label603;
          }
          localList = localList.subList(0, 4);
        }
      }
      label603:
      for (;;)
      {
        paramInt = 0;
        while ((localList != null) && (paramInt < localList.size()))
        {
          localObject = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((ApolloMainInfo)localObject).mAction = ((ApolloActionData)localList.get(paramInt));
          localArrayList.add(localObject);
          paramInt += 1;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          w();
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setGuideType(1);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setActions(localArrayList);
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "exp_panelnewuser_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), jdField_c_of_type_Int, new String[] { String.valueOf(this.jdField_d_of_type_Int), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          a("new_user_panel", "expose");
          return;
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.34(this, localArrayList));
        }
        break;
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      StartupTracker.a("apollo_panel_open", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "dispatchdraw is called");
      }
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("ApolloPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  public void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    super.dispatchVisibilityChanged(paramView, paramInt);
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      return;
    }
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter == null)) {}
    do
    {
      return;
      m = a(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
    } while ((localObject == null) || (((List)localObject).size() == 0) || (m < 0) || (m >= ((List)localObject).size()));
    Object localObject = (ApolloActionPackage)((List)localObject).get(m);
    if (localObject != null) {}
    for (int m = ((ApolloActionPackage)localObject).packageId;; m = 0)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), m, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void f()
  {
    ThreadManager.post(new ApolloPanel.10(this), 5, null, false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "del fav action");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i1;
    label438:
    do
    {
      return;
      int i2 = 1;
      int m = 1;
      int n = 0;
      for (;;)
      {
        i1 = i2;
        if (n >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label438;
        }
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(n);
        if (localApolloViewBinder.jdField_c_of_type_Int == 2)
        {
          List localList1 = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
          if ((localList1 == null) || (localList1.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList1.clear();
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataImplApolloDaoManagerServiceImpl.getFavPanelActionPairInfo();
          List localList2 = (List)((Pair)localObject).first;
          localObject = (List)((Pair)localObject).second;
          ApolloInfo localApolloInfo;
          if ((localList2 != null) && (localList2.size() > 0))
          {
            localApolloViewBinder.a(5);
            localApolloInfo = new ApolloInfo();
            localApolloInfo.mType = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131690110);
            localApolloInfo.mAction = localApolloActionData;
            localList1.add(localApolloInfo);
          }
          for (;;)
          {
            i2 = 0;
            for (;;)
            {
              i1 = m;
              if (i2 >= ((List)localObject).size()) {
                break;
              }
              localApolloInfo = localApolloViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
              if (localApolloInfo != null)
              {
                localApolloInfo.mAction = ((ApolloActionData)((List)localObject).get(i2));
                localApolloInfo.mPackageId = localApolloViewBinder.jdField_d_of_type_Int;
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
            localApolloViewBinder.a(4);
            m = 0;
          }
        }
        n += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (i1 != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (i1 != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    int m = 0;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(m)).b();
      m += 1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (localApolloManagerServiceImpl != null)
      {
        localApolloManagerServiceImpl.removeDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
        localApolloManagerServiceImpl.removeAllListener();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.b();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl);
      }
    }
    l();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    s();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloSecondaryViewBinder = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
    this.jdField_a_of_type_JavaUtilDeque = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      int m = paramMessage.getData().getInt("pkgId");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(m) });
      }
      c(paramMessage.arg1, m);
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content)) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts));
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 49, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time, null);
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramMessage.show_sum += 1;
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] visibility=", Integer.valueOf(super.getVisibility()) });
    }
    if (super.getVisibility() == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[switch2RedTab] visible now, abort");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter != null)
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        int n = localList.size();
        int m = 0;
        while (m < n)
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localList.get(m);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
            }
            b(m);
            return;
          }
          m += 1;
        }
      }
    }
  }
  
  public boolean isPanelOpen()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper.a();
  }
  
  public void j()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.14(this));
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    localApolloManagerServiceImpl.addDownLoadListener(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback);
    }
    int n = localApolloManagerServiceImpl.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)
      {
        m = 1;
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_i_of_type_Int != 7) && (m == 0)) {
          break label150;
        }
      }
    }
    label150:
    for (int m = 7;; m = n)
    {
      a(m);
      return;
      m = 0;
      break;
      m = 0;
      break;
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void m()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.24(this));
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageFor3D] mBaseChatPie or mGuidePageFor3D or mBaseChatPie.app is null");
    }
    do
    {
      do
      {
        return;
        if ((!App3DConfig.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Int == 2) || (!a()))
        {
          x();
          return;
        }
        w();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setGuideType(0);
        localObject2 = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject2).getActionByPackageId(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int m = 0;
        while (m < ((List)localObject2).size())
        {
          Apollo3DMainInfo localApollo3DMainInfo = new Apollo3DMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          localApollo3DMainInfo.mAction = ((ApolloActionData)((List)localObject2).get(m));
          ((List)localObject1).add(localApollo3DMainInfo);
          m += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setActions((List)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.startAnimation((Animation)localObject1);
    } while (this.l);
    this.l = true;
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkResForGuidePanel();
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof ApolloTagActionViewBinder))) {
      ((ApolloTagActionViewBinder)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).e();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "click tab shop");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        Object localObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          ((ApolloManagerServiceImpl)localObject).clickPushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
          ((ApolloManagerServiceImpl)localObject).removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
          this.jdField_f_of_type_Boolean = false;
          u();
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[0]);
          a("panel_store", "click");
        }
        else
        {
          if (((ApolloManagerServiceImpl)localObject).is3dAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject = ApolloConstant.u;; localObject = ApolloConstant.v)
          {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", (String)localObject, null);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
          {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ApolloConstant.v, null, 14003);
            a("package_slave", "open");
            continue;
            a(true);
            continue;
            a(false);
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "ApolloPanel event " + paramMotionEvent.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        super.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_e_of_type_Boolean = true;
    b(paramInt);
    this.jdField_e_of_type_Boolean = false;
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrollStateChange state=" + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrolled i=" + paramInt1 + ",il=" + paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "pager position = " + paramInt);
    }
    int i2 = a(paramInt);
    if ((this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt - 1))) || (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_j_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "change tab index = " + paramInt);
      }
      setTabSelect(i2);
      this.jdField_e_of_type_Int = 0;
    }
    if (paramInt < jdField_a_of_type_Int)
    {
      m = 1;
      jdField_a_of_type_Int = paramInt;
      e(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        break label156;
      }
    }
    label156:
    int n;
    Object localObject1;
    Object localObject3;
    label326:
    do
    {
      int i1;
      do
      {
        return;
        m = 0;
        break;
        i1 = 0;
        n = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a();
          n = i1;
          if (localObject1 != null)
          {
            n = i1;
            if (((List)localObject1).size() > 0)
            {
              n = i1;
              if (i2 >= 0)
              {
                n = i1;
                if (i2 < ((List)localObject1).size())
                {
                  localObject1 = (ApolloActionPackage)((List)localObject1).get(i2);
                  n = i1;
                  if (localObject1 != null) {
                    n = ((ApolloActionPackage)localObject1).packageId;
                  }
                }
              }
            }
          }
        }
        if (n != 6) {
          break label595;
        }
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject1 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (m == 0) {
          break label607;
        }
        localObject2 = "0";
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, i1, n, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localObject2 = null;
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      n = 0;
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)((Iterator)localObject3).next();
        m = n;
        if (localApolloViewBinder == null) {
          break label615;
        }
        m = n;
        if (!(localApolloViewBinder instanceof ApolloViewBinder)) {
          break label615;
        }
        i1 = localApolloViewBinder.a();
        n += i1;
        m = n;
        if (paramInt + 1 > n) {
          break label615;
        }
        if (!(localApolloViewBinder instanceof ApolloSecondaryViewBinder))
        {
          localObject1 = localObject2;
          if (!(localApolloViewBinder instanceof ApolloFavViewBinder)) {}
        }
        else
        {
          localObject1 = localApolloViewBinder.a(i1 - (n - paramInt));
        }
      }
    } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
    label407:
    Object localObject2 = new StringBuilder();
    int m = ((ArrayList)localObject1).size();
    paramInt = 0;
    label534:
    if (paramInt < m)
    {
      localObject3 = (ApolloInfo)((ArrayList)localObject1).get(paramInt);
      if (((ApolloInfo)localObject3).mAction != null) {
        ((StringBuilder)localObject2).append(((ApolloInfo)localObject3).mAction.actionId);
      }
      for (;;)
      {
        if (paramInt != m - 1) {
          ((StringBuilder)localObject2).append("-");
        }
        paramInt += 1;
        break label534;
        label595:
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
        label607:
        localObject2 = "1";
        break label326;
        label615:
        n = m;
        break label407;
        ((StringBuilder)localObject2).append("0");
      }
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  public void onPullDown()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper.c();
  }
  
  public void onPullUp()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper.b();
  }
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    if ((paramInt == 0) && (this.jdField_f_of_type_Int == 2) && (this.jdField_k_of_type_Int != -1) && (this.jdField_k_of_type_Int != paramInt)) {
      this.jdField_c_of_type_ComTencentMobileqqApolloViewPannelPanelStrategy.a();
    }
    this.jdField_k_of_type_Int = paramInt;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView != null)) {
      x();
    }
    v();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelExtendHelper.a(paramInt);
  }
  
  public void setTabSelect(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setTabSelect] newIndex=", Integer.valueOf(paramInt), ", mLastTabIndex=", Integer.valueOf(this.jdField_j_of_type_Int) });
    }
    int m;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(this.jdField_j_of_type_Int);
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      }
      if ((this.jdField_j_of_type_Int == -1) || (this.jdField_j_of_type_Int != paramInt)) {
        s();
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
      m = this.jdField_j_of_type_Int;
      this.jdField_j_of_type_Int = paramInt;
      if (jdField_b_of_type_Int != paramInt)
      {
        a(ApolloDtReportUtil.a(b(paramInt)), "expose");
        jdField_b_of_type_Int = paramInt;
      }
      if (localObject == null) {
        break label626;
      }
      ((View)localObject).setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a(paramInt);
      b(paramInt, (View)localObject);
      if ((!this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView == null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer.a()) && (!this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer.b())) {
        a(paramInt, (View)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a().get(paramInt);
        if ((((ApolloActionPackage)localObject).packageId == 100) && (m != paramInt)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        int n = ((ApolloActionPackage)localObject).packageId;
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (!((ApolloActionPackage)localObject).isUpdate) {
          break label621;
        }
        m = 1;
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, n, 0, new String[] { m, "" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", String.valueOf(System.currentTimeMillis() / 1000L) });
        if (((ApolloActionPackage)localObject).packageId == 9)
        {
          if (this.jdField_e_of_type_Boolean) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "y_bqtabclick", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
          }
          a("stickertab", "expose");
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "y_bqtabexpose", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
        }
      }
    }
    for (;;)
    {
      c(paramInt);
      return;
      label621:
      m = 0;
      break;
      label626:
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloTabAdapter.a(paramInt);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_Boolean = true;
      if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (!CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {
          break label114;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_c2c", "expo", "", "", "", "");
      }
    }
    label114:
    while (paramInt != 8)
    {
      do
      {
        return;
      } while (!CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2));
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_qun", "expo", "", "", "", "");
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    s();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
    }
    this.jdField_i_of_type_Boolean = true;
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
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */