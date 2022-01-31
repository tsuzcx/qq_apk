package com.tencent.mobileqq.apollo.view;

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
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager.PanelClickCallback;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import yyc;
import yyf;
import yyg;
import yyh;
import yyi;
import yyj;
import yyk;
import yyl;
import yym;
import yyn;
import yyo;
import yyp;
import yyq;
import yyr;
import yys;
import yyt;
import yyu;
import yyv;
import yyw;
import yyx;
import yyy;
import yyz;
import yza;
import yzb;
import yzc;
import yzd;
import yze;
import yzf;
import yzg;
import yzh;
import yzi;

public class ApolloPanel
  extends RelativeLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, OpenCallback
{
  public static int a;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public URLImageView a;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  public BaseChatPie a;
  public SessionInfo a;
  public ApolloPanelManager.PanelClickCallback a;
  private ApolloPanelManager jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager;
  IResDownloadListener jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = new yyc(this);
  public ApolloGameViewBinder a;
  public ApolloMainViewBinder a;
  public ApolloPanelAdapter a;
  public ApolloTabAdapter a;
  public EmoticonPagerRadioGroup a;
  public RedTouch a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public QQViewPager a;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public HorizontalListView a;
  CalloutPopupWindow jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
  private Runnable jdField_a_of_type_JavaLangRunnable = new yys(this);
  public List a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  public LinearLayout b;
  public RelativeLayout b;
  public TextView b;
  public URLImageView b;
  public List b;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public List c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = true;
  
  public ApolloPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new yym(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback = new yyr(this);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new yym(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback = new yyr(this);
  }
  
  private int a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int j = 0;
    int i = 0;
    if (j < paramInt)
    {
      ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)paramList.get(j);
      if (localApolloViewBinder == null) {
        break label72;
      }
      i = localApolloViewBinder.a() + i;
    }
    label72:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject5 = null;
    Object localObject4;
    if (paramApolloActionData == null) {
      localObject4 = null;
    }
    label96:
    do
    {
      Resources localResources;
      do
      {
        return localObject4;
        localResources = super.getResources();
        try
        {
          localObject1 = localResources.getDrawable(2130837572);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Drawable localDrawable;
            String str;
            localObject1 = null;
            QLog.e("ApolloPanel", 1, "[getNewActionStaticDrawable] exception=", localException1);
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1 = null;
            QLog.e("ApolloPanel", 1, "[getNewActionStaticDrawable] error=", localOutOfMemoryError1);
            Object localObject3 = null;
          }
        }
        for (;;)
        {
          try
          {
            localDrawable = localResources.getDrawable(2130841350);
            localObject4 = localObject1;
            if (paramApolloActionData.status == 0) {
              break;
            }
            str = Integer.toString(1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            break label223;
          }
          catch (Exception localException2)
          {
            break label204;
          }
          try
          {
            localObject4 = new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName);
            localObject5 = localObject4;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            QLog.e("ApolloPanel", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
            break label96;
          }
        }
        localObject4 = localObject1;
      } while (localObject5 == null);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.a(90.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight;
      ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
      localObject1 = URLDrawable.getDrawable(localObject5, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = localObject1;
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(paramApolloActionData);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    return localObject1;
  }
  
  private void a(View paramView, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramView == null)) {}
    do
    {
      do
      {
        return;
        paramString = CalloutPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new CalloutPopupWindow.DrawableBuilder(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = paramString.a();
    } while (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.c(2);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(paramView);
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", extra=", paramBundle });
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2130968680, null));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setId(2131362448);
    ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363172)).setOnClickListener(this);
    Object localObject2 = super.getResources();
    Object localObject1 = (ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363174);
    ApolloMainInfo localApolloMainInfo = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    localApolloMainInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
    ((ImageView)localObject1).setImageDrawable(a(paramApolloActionData));
    ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363175)).setText(paramApolloActionData.actionName);
    ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363176)).setText(paramApolloActionData.description);
    ((Button)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363170)).setOnClickListener(new yyu(this, paramApolloActionData));
    localObject1 = (Button)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363171);
    int i = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
    if (i < AIOUtils.a(213.0F, (Resources)localObject2))
    {
      localObject3 = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363169);
      i = i - (int)((Resources)localObject2).getDimension(2131558721) - (int)((Resources)localObject2).getDimension(2131558722);
      ((RelativeLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams()).bottomMargin = ((int)(i * 0.1D));
      ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363173)).getLayoutParams()).bottomMargin = ((int)(i * 0.2D));
    }
    localObject2 = (ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363177);
    Object localObject3 = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363179);
    switch (paramInt2)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        label468:
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramBundle.addRule(2, 2131362950);
        if (!this.jdField_g_of_type_Boolean) {}
        break;
      }
      break;
    }
    for (paramInt1 = super.getChildCount() - 1;; paramInt1 = -1)
    {
      addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, paramInt1, paramBundle);
      paramBundle = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      paramBundle.setDuration(500L);
      paramBundle.setRepeatCount(0);
      paramBundle.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(paramBundle);
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_flame_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
      }
      return;
      ((ImageView)localObject2).setVisibility(8);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText("免费");
      break;
      ((ImageView)localObject2).setVisibility(8);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText("已获得");
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838105);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FFFF8444"));
      ((TextView)localObject3).setText(paramApolloActionData.extraWording);
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838106);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText("购买");
      localObject2 = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131363178);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(String.valueOf(paramApolloActionData.currencyNum));
      break;
      ((ImageView)localObject2).setVisibility(0);
      switch (paramApolloActionData.vipLevel)
      {
      default: 
        ((ImageView)localObject2).setImageResource(2130838113);
      }
      for (;;)
      {
        if (paramInt2 != 24) {
          break label959;
        }
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
        ((TextView)localObject3).setText("开通小钻可使用");
        break;
        ((ImageView)localObject2).setImageResource(2130838107);
        continue;
        ((ImageView)localObject2).setImageResource(2130838108);
        continue;
        ((ImageView)localObject2).setImageResource(2130838109);
        continue;
        ((ImageView)localObject2).setImageResource(2130838110);
        continue;
        ((ImageView)localObject2).setImageResource(2130838111);
        continue;
        ((ImageView)localObject2).setImageResource(2130838112);
        continue;
        ((ImageView)localObject2).setImageResource(2130838113);
      }
      label959:
      ((TextView)localObject3).setVisibility(8);
      break;
      ((Button)localObject1).setText("立即发送");
      ((Button)localObject1).setOnClickListener(new yyv(this, localApolloMainInfo, paramApolloActionData));
      break label468;
      ((Button)localObject1).setText("立即参加");
      ((Button)localObject1).setOnClickListener(new yyw(this, paramBundle, paramApolloActionData));
      break label468;
      ((Button)localObject1).setText("立即购买");
      ((Button)localObject1).setOnClickListener(new yyx(this, paramApolloActionData, paramBundle));
      break label468;
      ((Button)localObject1).setText("开通小钻");
      ((Button)localObject1).setOnClickListener(new yyy(this, paramApolloActionData));
      break label468;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new yzb(this, paramAppInfo, paramString));
  }
  
  private void a(List paramList1, List paramList2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList1 == null) || (paramList2 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] mShouldShowActionFloatView=", Boolean.valueOf(this.jdField_h_of_type_Boolean), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    int i;
    int j;
    int k;
    ApolloActionPackage localApolloActionPackage;
    if (!paramBoolean)
    {
      paramBoolean = false;
      i = 0;
      this.jdField_g_of_type_Int = -1;
      if (((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).jdField_f_of_type_Boolean)
      {
        j = ((SharedPreferences)localObject).getInt("key_panel_bubble_tab", -1);
        i = 0;
        k = paramList2.size();
        if (i >= k) {
          break label931;
        }
        localApolloActionPackage = (ApolloActionPackage)paramList2.get(i);
        if ((localApolloActionPackage == null) || (localApolloActionPackage.packageId != j)) {
          break label487;
        }
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] bubble pakcageId:", Integer.valueOf(j) });
      }
      if ((!paramBoolean) && (this.jdField_h_of_type_Boolean))
      {
        j = 0;
        k = paramList2.size();
        label267:
        if (j < k)
        {
          localApolloActionPackage = (ApolloActionPackage)paramList2.get(j);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            paramBoolean = true;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] hasNewAction=", Boolean.valueOf(paramBoolean), ", tabIndex=", Integer.valueOf(i) });
        }
        int m;
        if ((paramBoolean) && (i < paramList1.size()))
        {
          k = a(paramList1, i);
          m = 1;
          this.jdField_g_of_type_Int = i;
          j = m;
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] hasNewAction, pagerIndex=", Integer.valueOf(k) });
            i = k;
            j = m;
          }
        }
        for (;;)
        {
          int n = 0;
          k = 0;
          for (;;)
          {
            if (k < paramList1.size())
            {
              n += ((ApolloViewBinder)paramList1.get(k)).a();
              k += 1;
              continue;
              label487:
              i += 1;
              break;
              j += 1;
              break label267;
            }
          }
          m = j;
          k = i;
          if (j == 0)
          {
            if ((this.jdField_g_of_type_Int < 0) || (this.jdField_g_of_type_Int >= paramList1.size())) {
              break label916;
            }
            i = a(paramList1, this.jdField_g_of_type_Int);
            j = 1;
          }
          label898:
          label916:
          for (;;)
          {
            if ((j == 0) && (((SharedPreferences)localObject).contains("sp_key_apollo_current_page_index")))
            {
              localObject = ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_index", null);
              if (TextUtils.isEmpty((CharSequence)localObject)) {}
            }
            for (;;)
            {
              try
              {
                k = Integer.parseInt((String)localObject);
                if (k >= n) {
                  break label898;
                }
                m = 1;
                j = m;
                i = k;
              }
              catch (Exception localException1)
              {
                k = i;
                i = j;
              }
              try
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] from previous saved, pagerIndex=", Integer.valueOf(k) });
                  i = k;
                  j = m;
                }
                k = j;
                j = i;
                i = k;
                if (i != 0) {
                  break label877;
                }
                k = 0;
                m = paramList2.size();
                if (k >= m) {
                  break label892;
                }
                localObject = (ApolloActionPackage)paramList2.get(k);
                if ((localObject == null) || (((ApolloActionPackage)localObject).packageId != 0)) {
                  break label860;
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  label860:
                  i = 1;
                }
                k = i;
                i = j;
                j = k;
                continue;
                k = 0;
                continue;
              }
              if (k < paramList1.size())
              {
                i = a(paramList1, k);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
                }
                j = 1;
                if (j == 0) {
                  i = 1;
                }
                if (i >= n) {
                  break;
                }
                jdField_a_of_type_Int = i;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(jdField_a_of_type_Int) });
                return;
                QLog.e("ApolloPanel", 1, "parse previousSavedPagerIndexStr error", localException1);
                m = i;
                i = m;
                j = k;
                continue;
                k += 1;
                continue;
              }
              label877:
              label892:
              continue;
              k = i;
              i = j;
              j = k;
            }
          }
          j = 0;
          i = 1;
        }
      }
      label931:
      i = 0;
    }
  }
  
  private int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return -1;
    }
    ApolloGameManager localApolloGameManager = (ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210);
    if (localApolloGameManager.jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localApolloGameManager.jdField_a_of_type_Int), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      int i = localApolloGameManager.jdField_a_of_type_Int;
      if (!this.jdField_a_of_type_Boolean) {
        localApolloGameManager.jdField_a_of_type_Int = -1;
      }
      return i;
    }
    return -1;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder = new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.c(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder);
      r();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.w("ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
    }
    ApolloActionData localApolloActionData;
    do
    {
      Object localObject;
      String str;
      do
      {
        return;
        localObject = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        localApolloActionData = ((ApolloDaoManager)localObject).a(paramInt1);
        if (localApolloActionData == null)
        {
          QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
          return;
        }
        boolean bool2 = ((ApolloDaoManager)localObject).a(paramInt1);
        if ((((ApolloDaoManager)localObject).b(paramInt1)) || (localApolloActionData.feeType == 1)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(localApolloActionData.feeType) });
          }
          if (!bool1) {
            break;
          }
          a(localApolloActionData, 0, 20, null);
          return;
        }
        if (localApolloActionData.feeType == 6)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new yyt(this, localApolloActionData));
          ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
          return;
        }
        if (localApolloActionData.feeType == 2)
        {
          if (localApolloActionData.currencyType == 1)
          {
            if (bool2)
            {
              a(localApolloActionData, 0, 23, null);
              return;
            }
            localObject = new Bundle();
            ((Bundle)localObject).putInt("pkgId", paramInt2);
            a(localApolloActionData, 2, 23, (Bundle)localObject);
            return;
          }
          QLog.w("ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
          return;
        }
        if (localApolloActionData.feeType != 9) {
          break;
        }
        localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        if (((ApolloManager)localObject).a(str))
        {
          if (((ApolloManager)localObject).a(str) >= localApolloActionData.vipLevel)
          {
            a(localApolloActionData, 0, 25, null);
            return;
          }
          QLog.w("ApolloPanel", 1, "[showNewActionFloatView] vip level not match, abort");
          return;
        }
        if ((localApolloActionData.vipLevel == 1) || (((ApolloManager)localObject).a(str) >= localApolloActionData.vipLevel))
        {
          a(localApolloActionData, 3, 24, null);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] action vip level=", Integer.valueOf(localApolloActionData.vipLevel), ", user vip level=", Integer.valueOf(((ApolloManager)localObject).a(str)), ", abort" });
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(localApolloActionData.feeType) });
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putString("sp_key_apollo_current_page_index", String.valueOf(paramInt)).apply();
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[initData]");
    }
    k();
  }
  
  private void q()
  {
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    label290:
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      Object localObject1 = ((SharedPreferences)localObject2).edit();
      if (((SharedPreferences)localObject2).contains("sp_key_apollo_preview_action_guide")) {}
      for (boolean bool = ((SharedPreferences)localObject2).getBoolean("sp_key_apollo_preview_action_guide", false);; bool = false)
      {
        if (bool) {
          break label290;
        }
        int i = b(jdField_a_of_type_Int);
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        localObject2 = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject2 == null) || (((ApolloViewBinder)localObject2).jdField_e_of_type_Int == 100)) {
          break;
        }
        this.jdField_g_of_type_Boolean = true;
        ((SharedPreferences.Editor)localObject1).putBoolean("sp_key_apollo_preview_action_guide", true).commit();
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ((int)(this.jdField_b_of_type_ComTencentImageURLImageView.getHeight() + 0.5F));
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((int)(this.jdField_b_of_type_ComTencentImageURLImageView.getWidth() + 0.5F));
        localObject1 = ApolloImageDownloader.a(true, ApolloConstant.g + "apollo_preview_action_guide.png", (URLDrawable.URLDrawableOptions)localObject1, "http://cmshow.gtimg.cn/client/img/apollo_preview_action_guide.png");
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(new yzf(this));
        return;
      }
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideNewActionFloatView] remove");
      }
      super.removeView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    }
    View localView = super.findViewById(2131362448);
    if (localView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideNewActionFloatView] remove by id");
      }
      super.removeView(localView);
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void u()
  {
    ThreadManager.getUIHandler().post(new yzc(this));
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int m = 0;
    int k = m;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      k = m;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      k = m;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        j += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        if (paramInt < j) {
          k = ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a() - (j - paramInt);
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
  
  public int a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo, ApolloActionData paramApolloActionData)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      j = 0;
      return j;
    }
    ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
    ApolloManager localApolloManager = (ApolloManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    boolean bool = localApolloDaoManager.a(paramApolloActionData.actionId);
    if ((paramApolloActionData.hasSound) || (paramApolloInfo.jdField_e_of_type_Int > 0)) {}
    for (int j = 1;; j = 0)
    {
      if (localApolloDaoManager.b(paramApolloActionData.actionId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(j) });
        }
        return j | 0x2;
      }
      int i = j;
      if (paramApolloActionData.feeType == 6)
      {
        if (bool)
        {
          i = 16;
          i = j | i;
        }
      }
      else
      {
        j = i;
        if (paramApolloActionData.feeType == 2) {
          if (!bool) {
            break label259;
          }
        }
      }
      label259:
      for (j = 4;; j = 128)
      {
        j = i | j;
        i = j;
        if (paramApolloActionData.feeType != 9) {
          break label275;
        }
        if (!localApolloManager.a(paramBaseChatPie.a().getCurrentAccountUin())) {
          break label267;
        }
        i = localApolloManager.a(paramBaseChatPie.a().getCurrentAccountUin());
        if (paramApolloActionData.vipLevel > i) {
          break label267;
        }
        return j | 0x20;
        i = 64;
        break;
      }
      label267:
      i = j | 0x100;
      label275:
      j = i;
      if (paramApolloActionData.feeType != 7) {
        break;
      }
      if (bool) {}
      for (j = 8;; j = 512) {
        return i | j;
      }
    }
  }
  
  public ApolloViewBinder a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
      }
      switch (paramInt)
      {
      default: 
        return new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      case 0: 
        return new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      case 2: 
        return new ApolloFavViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      case 100: 
        if (ApolloManager.c("gameSwitch") == 1) {
          break label183;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "loadPanel gameSwitch is 0 return null");
    return null;
    label183:
    return new ApolloGameViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    return new ApolloSlaveViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(1, "actionPanel");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "actionpanel onOpen");
      }
      this.jdField_f_of_type_Int = -1;
    }
  }
  
  public void a(int paramInt)
  {
    int i = b(paramInt);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > i))
    {
      int j = ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
      if (((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_Int == 100) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      }
      do
      {
        return;
        if ((j <= 1) || (((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_Int == 100)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(j, false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(a(paramInt));
      } while (!QLog.isColorLevel());
      QLog.d("ApolloPanel", 2, "mRadioGroup is visible count = " + j);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localApolloViewBinder.jdField_d_of_type_Int == 100) && ((localApolloViewBinder instanceof ApolloGameViewBinder)) && (((ApolloGameViewBinder)localApolloViewBinder).a != null) && (((ApolloGameViewBinder)localApolloViewBinder).a.gameId == paramInt2)) {
          ((ApolloGameViewBinder)localApolloViewBinder).b(paramInt1);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, ApolloPanel paramApolloPanel)
  {
    if (((paramInt1 == 21) || (paramInt2 == 21)) && (paramApolloPanel != null))
    {
      paramApolloPanel = a(100);
      if ((paramApolloPanel != null) && ((paramApolloPanel instanceof ApolloGameViewBinder)))
      {
        paramApolloPanel = (ApolloGameViewBinder)paramApolloPanel;
        if (paramInt1 != 21) {
          break label50;
        }
        paramApolloPanel.c();
      }
    }
    return;
    label50:
    paramApolloPanel.d();
  }
  
  public void a(int paramInt, View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
      if (((List)localObject).size() > paramInt)
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((ApolloActionPackage)localObject).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject).redFlowId;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", new action id=", Integer.valueOf(paramInt) });
          }
          ThreadManager.post(new yyp(this, (ApolloActionPackage)localObject), 5, null, true);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.jdField_h_of_type_Boolean), ", mIsTriggeredByClick=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
          }
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
          if ((this.jdField_h_of_type_Boolean) && (paramInt != 0))
          {
            paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
            paramView.arg1 = paramInt;
            paramView.getData().putInt("pkgId", ((ApolloActionPackage)localObject).packageId);
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView, 800L);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "auth_finish");
    }
    post(new yyh(this, paramString, paramInt));
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    paramBaseChatPie = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    if (paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_e_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt2;
    }
    this.jdField_f_of_type_Int = paramInt3;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131362948));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)super.findViewById(2131362949));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131362956));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362955));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838144);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838143);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362950));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131362957));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter = new ApolloTabAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131362952).setBackgroundColor(super.getContext().getResources().getColor(2131494035));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362951));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362944));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362945));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362947));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362946));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131362958));
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager = paramBaseChatPie.a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a.get()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(5).a();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.a(100);
      }
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) && (this.jdField_f_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (ApolloManager.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[initPanel] getUserApolloInfo");
        }
        this.jdField_a_of_type_Boolean = true;
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 8650880, "Open Panel");
        ApolloManager.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a(null);
      }
      paramBaseChatPie = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_JavaLangString))) {
        break label992;
      }
    }
    label992:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams()).bottomMargin = ((int)(10.0F * super.getResources().getDisplayMetrics().density));
      setBackgroundColor(super.getResources().getColor(2131494037));
      p();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "init panel done");
      }
      return;
    }
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    int k = 0;
    if ((paramApolloInfo == null) || (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {}
    int j;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      int i = 0;
      j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList == null) {}
        while (((ApolloViewBinder)localObject1).jdField_d_of_type_Int != 2)
        {
          i += 1;
          break;
        }
        Object localObject2;
        if (((ApolloViewBinder)localObject1).jdField_c_of_type_Int != 5)
        {
          ((ApolloViewBinder)localObject1).c(5);
          localObject2 = new ApolloInfo();
          ((ApolloInfo)localObject2).jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131438195);
          ((ApolloInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          ((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
        }
        localObject1 = ((ApolloViewBinder)localObject1).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
          paramApolloInfo.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramApolloInfo, paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        }
        ((List)localObject1).add(1, paramApolloInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramApolloInfo.toString());
        }
        j = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (j != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (j != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    long l1 = System.currentTimeMillis();
    if (paramApolloActionData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "updateItemStatus action= " + paramApolloActionData.actionId + " action name =" + paramApolloActionData.actionName);
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "something=null ");
    return;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount()) {
          continue;
        }
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(i);
        if (!(localViewGroup instanceof ApolloLinearLayout)) {
          break label384;
        }
        if (((ApolloLinearLayout)localViewGroup).a(paramApolloActionData) != null) {
          break label391;
        }
      }
      catch (Exception paramApolloActionData)
      {
        ViewGroup localViewGroup;
        LinearLayout localLinearLayout;
        int k;
        ApolloLinearLayout.ViewHolder localViewHolder;
        ApolloInfo localApolloInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloPanel", 2, "updateItemStatus error:" + paramApolloActionData.toString());
        l2 = System.currentTimeMillis();
      }
      if (j < localViewGroup.getChildCount())
      {
        localLinearLayout = (LinearLayout)localViewGroup.getChildAt(j);
        k = 0;
        if (k < localLinearLayout.getChildCount())
        {
          localViewHolder = (ApolloLinearLayout.ViewHolder)localLinearLayout.getChildAt(k).getTag();
          if (localViewHolder != null)
          {
            localApolloInfo = localViewHolder.a;
            if ((localApolloInfo != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new yyn(this, localViewHolder));
            }
          }
          k += 1;
          continue;
        }
        j += 1;
        continue;
        long l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "updateItemStatus cost time = " + (l2 - l1));
        return;
      }
      label384:
      i += 1;
      continue;
      label391:
      int j = 0;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new yza(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
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
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    m();
    int i;
    if ("onlyRightType".equals(paramString5))
    {
      i = 1;
      paramString1 = new yyi(this);
      label137:
      paramString6 = super.getResources().getString(2131436731);
      if (i == 0) {
        break label293;
      }
    }
    label293:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new yyj(this, paramString7);
        i = 0;
        break label137;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new yyk(this, paramString1, paramString7, paramString8);
        i = 0;
        break label137;
      }
      paramString1 = new yyl(this, paramString5, paramString6, paramString7, paramString1);
      i = 0;
      break label137;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList1;
    ApolloDaoManager localApolloDaoManager;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList1 = new ArrayList();
        localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      } while (localApolloDaoManager == null);
      localList = localApolloDaoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (localList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "packageList is null.");
    return;
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList2 = new ArrayList();
    int n = 0;
    int i = 0;
    int j = -1;
    label164:
    ApolloActionPackage localApolloActionPackage;
    if (n < localList.size())
    {
      localApolloActionPackage = (ApolloActionPackage)localList.get(n);
      if (localApolloActionPackage == null) {
        break label2390;
      }
      if (localApolloActionPackage.packageId != 4) {}
    }
    label465:
    label2390:
    for (;;)
    {
      n += 1;
      break label164;
      String str = DeviceInfoUtil.d();
      if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!IndividuationConfigInfo.a(localApolloActionPackage.startVersion, str)) || (!IndividuationConfigInfo.a(str, localApolloActionPackage.endVersion))))
      {
        QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
      }
      else
      {
        long l2 = System.currentTimeMillis();
        ApolloViewBinder localApolloViewBinder = a(localApolloActionPackage.type);
        if (localApolloViewBinder != null)
        {
          localApolloViewBinder.jdField_e_of_type_Int = localApolloActionPackage.packageId;
          Object localObject3 = null;
          ArrayList localArrayList3 = new ArrayList();
          Object localObject1;
          Object localObject2;
          Object localObject4;
          int k;
          long l1;
          label490:
          ApolloActionData localApolloActionData;
          if (localApolloActionPackage.type == 2)
          {
            localObject1 = localApolloDaoManager.a();
            localObject2 = (List)((Pair)localObject1).first;
            localObject3 = (List)((Pair)localObject1).second;
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localApolloViewBinder.c(5);
              localObject1 = new ApolloInfo();
              ((ApolloInfo)localObject1).jdField_b_of_type_Int = 2;
              localObject4 = new ApolloActionData();
              ((ApolloActionData)localObject4).actionName = super.getResources().getString(2131438195);
              ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject4);
              localArrayList3.add(localObject1);
              localObject1 = null;
              k = i;
              l1 = System.currentTimeMillis();
              localObject4 = new StringBuilder();
              if (localObject3 == null) {
                break label2383;
              }
              i = j;
              j = 0;
              if (j >= ((List)localObject3).size()) {
                break label1351;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                break;
              }
              localApolloActionData = (ApolloActionData)((List)localObject3).get(j);
              if (localApolloActionData != null) {
                break label800;
              }
            }
          }
          for (;;)
          {
            j += 1;
            break label490;
            localApolloViewBinder.c(4);
            break;
            if (localApolloActionPackage.type == 100)
            {
              localObject1 = localApolloDaoManager.h();
              if ((localObject1 != null) && (((List)localObject1).size() > 0))
              {
                k = i;
                if ((localApolloViewBinder instanceof ApolloGameViewBinder))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                  }
                  ((ApolloGameViewBinder)localApolloViewBinder).a((List)localObject1);
                  localApolloViewBinder.c(100);
                  k = i + localApolloViewBinder.a();
                  localArrayList2.add(localApolloViewBinder);
                  localArrayList1.add(localList.get(n));
                }
              }
              for (;;)
              {
                localObject1 = null;
                localObject2 = null;
                break;
                QLog.i("ApolloPanel", 1, "load game info fail cause games == null");
                k = i;
              }
            }
            localObject3 = localApolloDaoManager.d(localApolloActionPackage.packageId);
            localObject1 = localApolloDaoManager.e(localApolloActionPackage.packageId);
            localApolloViewBinder.c(0);
            if (localApolloActionPackage.packageId == 6)
            {
              localApolloViewBinder.c(9);
              localApolloDaoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
              localObject2 = null;
              k = i;
              break label465;
            }
            if (localApolloActionPackage.packageId == 7) {
              localApolloDaoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
            }
            localObject2 = null;
            k = i;
            break label465;
            if ((!TextUtils.isEmpty(localApolloActionData.minVer)) && (!TextUtils.isEmpty(localApolloActionData.maxVer)) && ((!IndividuationConfigInfo.a(localApolloActionData.minVer, str)) || (!IndividuationConfigInfo.a(str, localApolloActionData.maxVer))))
            {
              ((StringBuilder)localObject4).append(",version ").append(localApolloActionData.actionId);
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
              {
                if (localApolloActionData.sessionType == 2) {
                  ((StringBuilder)localObject4).append(",special C2C ").append(localApolloActionData.actionId);
                }
              }
              else if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (localApolloActionData.sessionType == 1))
              {
                ((StringBuilder)localObject4).append(",special ").append(localApolloActionData.actionId);
                continue;
              }
              if (((ApolloActionData)((List)localObject3).get(j)).isShow != 0) {
                break label998;
              }
              ((StringBuilder)localObject4).append(",hide ").append(localApolloActionData.actionId);
            }
          }
          label998:
          ApolloInfo localApolloInfo = localApolloViewBinder.a(paramString);
          localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          localApolloInfo.jdField_a_of_type_Int = localApolloActionPackage.packageId;
          if (localApolloActionPackage.type == 2) {
            if ((localObject2 != null) && (((List)localObject2).size() > j))
            {
              localApolloInfo.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject2).get(j)).text;
              localApolloInfo.jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(j)).textType;
              localApolloInfo.jdField_e_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(j)).audioId;
              localApolloInfo.jdField_a_of_type_Float = ((ApolloFavActionData)((List)localObject2).get(j)).audioStartTime;
              localApolloInfo.jdField_f_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(j)).playOriginalAudio;
            }
          }
          for (localApolloInfo.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localApolloInfo, localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);; localApolloInfo.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localApolloInfo, localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData))
          {
            do
            {
              localArrayList3.add(localApolloInfo);
              if ((i != -1) || (this.jdField_d_of_type_Int != localApolloActionData.actionId)) {
                break label2380;
              }
              if (this.jdField_e_of_type_Int == -1)
              {
                this.jdField_e_of_type_Int = localApolloActionPackage.packageId;
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_e_of_type_Int) });
                }
              }
              if (this.jdField_e_of_type_Int != localApolloActionPackage.packageId) {
                break label2380;
              }
              i = localArrayList3.size() - 1;
              break;
            } while ((localObject1 == null) || (((List)localObject1).size() <= j));
            localApolloInfo.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject1).get(j)).text;
            localApolloInfo.jdField_d_of_type_Int = ((ApolloActionPackageData)((List)localObject1).get(j)).textType;
          }
          if (0 != 0) {
            throw new NullPointerException();
          }
          int m = k;
          j = i;
          if (localArrayList3.size() > 0)
          {
            localApolloViewBinder.a_(localArrayList3);
            if (this.jdField_e_of_type_Int == localApolloActionPackage.packageId)
            {
              if (i == -1) {
                break label1602;
              }
              localApolloViewBinder.d(i);
              jdField_a_of_type_Int = localApolloViewBinder.a(i) + k;
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(i) });
              }
            }
            localArrayList2.add(localApolloViewBinder);
            localArrayList1.add(localList.get(n));
            m = k + localApolloViewBinder.a();
            j = i;
          }
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              i = localApolloActionPackage.packageId;
              if (localObject3 != null) {
                break label1610;
              }
            }
            for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject3).size()))
            {
              QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(i), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l1 - l2), ",remove actions ", ((StringBuilder)localObject4).toString() });
              i = m;
              break;
              jdField_a_of_type_Int = k;
              break label1422;
            }
            if ((this.jdField_d_of_type_Int == -1) && (this.jdField_e_of_type_Int == -1)) {
              a(localArrayList2, localArrayList1, paramBoolean);
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
            }
            if ((this.jdField_d_of_type_Int != -1) && (j == -1) && (!this.jdField_b_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
              }
              if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                this.jdField_a_of_type_AndroidWidgetImageView.post(new yyz(this));
              }
              this.jdField_b_of_type_Boolean = true;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(1);
              }
            }
            while ((localArrayList2 != null) && (localArrayList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
              l2 = NetConnInfoCenter.getServerTimeMillis();
              l1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              paramString = new ArrayList();
              localObject1 = localArrayList1.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (ApolloActionPackage)((Iterator)localObject1).next();
                if ((((ApolloActionPackage)localObject3).isUpdate) && (((ApolloActionPackage)localObject3).packageId != 100))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + paramString.size());
                  }
                  if (NetConnInfoCenter.getServerTimeMillis() - ((SharedPreferences)localObject2).getLong("action_red_tab_update_" + ((ApolloActionPackage)localObject3).packageId, 0L) > ((ApolloActionPackage)localObject3).redInterval)
                  {
                    ((ApolloActionPackage)localObject3).isUpdate = false;
                    paramString.add(localObject3);
                  }
                }
                if ((((ApolloActionPackage)localObject3).isUpdate) && (((ApolloActionPackage)localObject3).packageId == 100) && (l2 - l1 > 604800000L))
                {
                  ((ApolloActionPackage)localObject3).isUpdate = false;
                  paramString.add(localObject3);
                }
              }
              if (!this.jdField_a_of_type_Boolean)
              {
                this.jdField_e_of_type_Int = -1;
                this.jdField_d_of_type_Int = -1;
              }
            }
            break;
            if (!paramString.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + paramString.size());
              }
              ThreadManager.post(new yzd(this, paramString), 5, null, true);
            }
            j = c();
            if ((j > 0) && (!localArrayList2.isEmpty())) {
              i = 0;
            }
            for (;;)
            {
              if (i < localArrayList2.size())
              {
                paramString = (ApolloViewBinder)localArrayList2.get(i);
                if ((paramString instanceof ApolloGameViewBinder))
                {
                  jdField_a_of_type_Int = i;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] checkGameTab jumpGameId:", Integer.valueOf(j), ",gameTabIndex:" + jdField_a_of_type_Int });
                  }
                  ((ApolloGameViewBinder)paramString).a(j);
                }
              }
              else
              {
                a(localArrayList1);
                b(localArrayList2);
                a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "103100.103200.103250", paramBoolean);
                if (Looper.myLooper() != Looper.getMainLooper()) {
                  break;
                }
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
              i += 1;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new yze(this));
            return;
            break label528;
            m = k;
          }
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initBinderData] froceRefresh=", Boolean.valueOf(paramBoolean1), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean2) });
    }
    if (this.jdField_f_of_type_Int == 7)
    {
      l();
      return;
    }
    ThreadManager.post(new yyo(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new yzh(this, paramList));
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
    a((String)paramMap.get("feeType"), (String)paramMap.get("title"), (String)paramMap.get("content"), (String)paramMap.get("rightString"), (String)paramMap.get("url"), (String)paramMap.get("isActionBack"), (String)paramMap.get("actionId"), (String)paramMap.get("extendJson"));
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      Pair localPair;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder != null) {
                this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.c();
              }
            } while (!paramBoolean);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "actionpanel onOpen response");
            }
          } while (paramObject == null);
          localPair = (Pair)paramObject;
          paramObject = (String)((Pair)paramObject).first;
        } while ((TextUtils.isEmpty(paramObject)) || (!paramObject.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())));
        if (2 == ((Integer)localPair.second).intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
          jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(jdField_a_of_type_Int);
          k();
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.c(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
      if ((localObject != null) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(this.jdField_h_of_type_Int);
        if ((localObject != null) && (((ApolloActionPackage)localObject).packageId == 100)) {
          return true;
        }
      }
    }
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 3);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof ApolloGameViewBinder)))
    {
      ApolloGameData localApolloGameData = ((ApolloGameViewBinder)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).b();
      if (localApolloGameData != null) {
        return localApolloGameData.gameId;
      }
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    int m = 0;
    int k = m;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      k = m;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      k = m;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        j += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        if (paramInt < j) {
          k = i;
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio", ApolloConstant.X, null);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (paramInt == 7) {
      l();
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        c(paramInt, 1);
        return;
      }
      if (paramInt == 1)
      {
        if ((!FileUtil.a(ApolloUtil.jdField_a_of_type_JavaLangString)) || (!FileUtil.a(ApolloUtil.jdField_b_of_type_JavaLangString)))
        {
          c(paramInt, 3);
          ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
        b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        return;
      }
    } while (paramInt != 2);
    c(paramInt, 1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jumpPkgId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    if (localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 1)
    {
      QLog.d("ApolloPanel", 1, "[jumpToPkgOrAction] status not open, abort jump");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] jump failed, no binder data");
      return;
    }
    int j = c();
    int i;
    if ((j > 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      i = 0;
      label174:
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1249;
      }
      if (!(this.jdField_a_of_type_JavaUtilList.get(i) instanceof ApolloGameViewBinder)) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        paramInt1 = jdField_a_of_type_Int;
        if ((jdField_a_of_type_Int != i) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i, false);
          a(i);
          setTabSelect(b(i));
          jdField_a_of_type_Int = i;
        }
        if ((i >= paramInt1 - 1) && (i <= paramInt1 + 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab force refresh cache view");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab jumpGameId:" + j + ",gameTabIndex:" + i);
        return;
        i += 1;
        break label174;
      }
      if ((paramInt1 == -1) && (paramInt2 == -1))
      {
        QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] abort finding action index");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter == null))
      {
        QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] failed, no view pager");
        return;
      }
      int k = 0;
      i = -1;
      int m = -1;
      int i3 = this.jdField_a_of_type_JavaUtilList.size();
      int i2 = 0;
      ApolloViewBinder localApolloViewBinder;
      label506:
      int n;
      List localList;
      label787:
      ApolloInfo localApolloInfo;
      if ((i2 < i3) && (i == -1))
      {
        localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i2);
        if (localApolloViewBinder == null) {
          break label1242;
        }
        if ((paramInt1 != -1) && (localApolloViewBinder.jdField_e_of_type_Int == paramInt1))
        {
          if (paramInt2 == -1)
          {
            i = k;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump for pkg, newViewPagerIndex=", Integer.valueOf(k) });
              i = k;
            }
            if (i != -1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump to new index=", Integer.valueOf(i), ", current index=", Integer.valueOf(jdField_a_of_type_Int) });
              }
              j = jdField_a_of_type_Int;
              if (jdField_a_of_type_Int != i)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i, false);
                a(i);
                setTabSelect(b(i));
                jdField_a_of_type_Int = i;
              }
              if ((i >= j - 1) && (i <= j + 1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] force refresh cache view");
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
              }
            }
            if ((paramInt2 == -1) || (m != -1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
            }
            if (this.jdField_b_of_type_Boolean) {
              break;
            }
            if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            this.jdField_b_of_type_Boolean = true;
            this.jdField_d_of_type_Int = paramInt2;
            this.jdField_e_of_type_Int = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] no action found, try to update json");
            }
            localApolloManager.a(1);
            return;
          }
          j = m;
          n = i;
          if (!(localApolloViewBinder instanceof ApolloGameViewBinder))
          {
            localList = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
            if ((localList == null) || (localList.size() <= 0)) {
              break label955;
            }
            j = 0;
            n = localList.size();
            if (j >= n) {
              break label1233;
            }
            localApolloInfo = (ApolloInfo)localList.get(j);
            if ((localApolloInfo != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              localApolloViewBinder.d(j);
              i = localApolloViewBinder.a(j) + k;
              if (!QLog.isColorLevel()) {
                break label1220;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found, jumpActionIndex=", Integer.valueOf(j), ", newViewPagerIndex=", Integer.valueOf(i) });
              m = j;
              j = i;
              i = m;
              label905:
              n = j;
              j = i;
            }
          }
          else
          {
            label912:
            k = localApolloViewBinder.a() + k;
            i = n;
            m = j;
          }
        }
      }
      label955:
      label1220:
      label1233:
      label1242:
      for (j = k;; j = k)
      {
        i2 += 1;
        k = j;
        break;
        j += 1;
        break label787;
        i = k;
        if (!QLog.isColorLevel()) {
          break label506;
        }
        QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction true, just jump pkg, newViewPagerIndex=", Integer.valueOf(k) });
        i = k;
        break label506;
        j = m;
        n = i;
        if (paramInt2 == -1) {
          break label912;
        }
        j = m;
        n = i;
        if ((localApolloViewBinder instanceof ApolloGameViewBinder)) {
          break label912;
        }
        localList = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
        if ((localList != null) && (localList.size() > 0))
        {
          int i1 = 0;
          int i4 = localList.size();
          for (;;)
          {
            j = m;
            n = i;
            if (i1 >= i4) {
              break;
            }
            localApolloInfo = (ApolloInfo)localList.get(i1);
            if ((localApolloInfo != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              if (paramInt1 != -1)
              {
                j = m;
                n = i;
                if (paramInt1 != localApolloViewBinder.jdField_e_of_type_Int) {
                  break;
                }
              }
              localApolloViewBinder.d(i1);
              n = k + localApolloViewBinder.a(i1);
              if (!QLog.isColorLevel()) {
                break label1210;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found2, jumpActionIndex=", Integer.valueOf(i1), ", newViewPagerIndex=", Integer.valueOf(n) });
              j = i1;
              break;
            }
            i1 += 1;
          }
          j = i1;
          break label912;
        }
        break label506;
        m = i;
        i = j;
        j = m;
        break label905;
        j = i;
        i = m;
        break label905;
      }
      label1210:
      label1249:
      i = -1;
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new yzi(this, paramList));
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    boolean bool2;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
      {
        this.jdField_e_of_type_Int = -1;
        this.jdField_d_of_type_Int = -1;
      }
      bool2 = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
    } while (!paramBoolean);
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      int i = paramObject.getInt("jumpPkdId", -1);
      int j = paramObject.getInt("jumpActionId", -1);
      if ((i != -1) && (j != -1))
      {
        this.jdField_e_of_type_Int = i;
        this.jdField_d_of_type_Int = j;
      }
    }
    if ((bool2) && (paramBoolean)) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false, paramBoolean);
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (localApolloManager != null)
      {
        localApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
        int i = 0;
        if (!FileUtil.a(ApolloUtil.jdField_b_of_type_JavaLangString)) {
          i = 2;
        }
        int j = i;
        if (!FileUtil.a(ApolloUtil.jdField_a_of_type_JavaLangString)) {
          j = i | 0x1;
        }
        localApolloManager.a(j);
      }
    }
  }
  
  void c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "onClick tab postion=" + paramInt);
      }
      setTabSelect(paramInt);
      int i = 0;
      int j = 0;
      while (i < paramInt)
      {
        j += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        i += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j, false);
          a(j);
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
          if (localObject == null) {
            break;
          }
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
          {
            paramInt = 2;
            VipUtils.a(null, "cmshow", "Apollo", "clciktabreddot", paramInt, 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloPanel", 2, "setCurrentItem exception e=" + localThrowable.toString());
          return;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    SessionInfo localSessionInfo;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    } while ((localQQAppInterface == null) || (localSessionInfo == null));
    int i = ((ApolloManager)localQQAppInterface.getManager(152)).b(localQQAppInterface.c());
    String str = localSessionInfo.jdField_a_of_type_JavaLangString;
    if (i == 0) {}
    for (i = 0;; i = 1)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", str, i, 0, new String[] { String.valueOf(ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter == null) {}
    int i;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      i = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    if (i == 2) {
      ((ApolloManager)localObject).a(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((i != 100) && (((ApolloManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)) {
        ((ApolloManager)localObject).a(paramInt, false);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
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
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    super.dispatchVisibilityChanged(paramView, paramInt);
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      return;
    }
  }
  
  public void e()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null))
    {
      i = b(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
      if ((localObject != null) && (((List)localObject).size() > 0) && (i >= 0) && (i < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(i);
        if (localObject == null) {
          break label150;
        }
      }
    }
    label150:
    for (int i = ((ApolloActionPackage)localObject).packageId;; i = 0)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), i, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void f()
  {
    ThreadManager.post(new yzg(this), 5, null, false);
  }
  
  public void g()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "del fav action");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int k;
    label470:
    do
    {
      int n;
      int i;
      do
      {
        return;
        n = 1;
        i = 1;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      int j = 0;
      for (;;)
      {
        k = n;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label470;
        }
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localApolloViewBinder.jdField_d_of_type_Int == 2)
        {
          List localList = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
          if ((localList == null) || (localList.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          Object localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList.clear();
          Object localObject2 = ((ApolloDaoManager)localObject1).a();
          localObject1 = (List)((Pair)localObject2).first;
          localObject2 = (List)((Pair)localObject2).second;
          Object localObject3 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localApolloViewBinder.c(5);
            localObject3 = new ApolloInfo();
            ((ApolloInfo)localObject3).jdField_b_of_type_Int = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131438195);
            ((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localList.add(localObject3);
          }
          for (;;)
          {
            k = i;
            if (m >= ((List)localObject2).size()) {
              break;
            }
            localObject3 = localApolloViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(m));
            ((ApolloInfo)localObject3).jdField_a_of_type_Int = localApolloViewBinder.jdField_e_of_type_Int;
            if ((localObject1 != null) && (((List)localObject1).size() > j))
            {
              ((ApolloInfo)localObject3).jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(m)).text;
              ((ApolloInfo)localObject3).jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(m)).textType;
              ((ApolloInfo)localObject3).jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ApolloInfo)localObject3, ((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
            }
            localList.add(localObject3);
            m += 1;
            continue;
            localApolloViewBinder.c(4);
            i = 0;
          }
        }
        j += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (k != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (k != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        i += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (localApolloManager != null)
      {
        localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
        localApolloManager.b();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a();
        }
      }
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    s();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      int i = paramMessage.getData().getInt("pkgId");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(i) });
      }
      d(paramMessage.arg1, i);
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content)) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts));
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 49, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time);
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramMessage.show_sum += 1;
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
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
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null)
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localList.get(i);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
            }
            c(i);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void j()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new yyf(this));
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    localApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager$PanelClickCallback);
    }
    int i = localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_f_of_type_Int == 7)) {
      i = 7;
    }
    b(i);
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      List localList = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).h();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameViewBinder = new ApolloGameViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameViewBinder.a(localList);
      if ((localList == null) || (localList.size() <= 0)) {
        break label116;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameViewBinder.c(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new yyg(this));
      return;
      label116:
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameViewBinder.c(8);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void n()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localApolloViewBinder.jdField_d_of_type_Int == 100) && ((localApolloViewBinder instanceof ApolloGameViewBinder))) {
          ((ApolloGameViewBinder)localApolloViewBinder).b();
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void o()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new yyq(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131362956: 
    case 2131362945: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "click tab shop");
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        paramView = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          this.jdField_e_of_type_Boolean = false;
          u();
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[0]);
          return;
        }
        FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
        if (paramView.jdField_d_of_type_Boolean) {}
        for (paramView = ApolloConstant.Y;; paramView = ApolloConstant.X)
        {
          ApolloUtil.a(localFragmentActivity, null, "aio", paramView, null);
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ApolloConstant.Y, null, 14003);
      return;
    }
    s();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "ApolloPanel event " + paramMotionEvent.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        super.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_d_of_type_Boolean = true;
    c(paramInt);
    this.jdField_d_of_type_Boolean = false;
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
    int m = b(paramInt);
    if ((this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt - 1))) || (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "change tab index = " + paramInt);
      }
      setTabSelect(m);
      a(paramInt);
      this.jdField_c_of_type_Int = 0;
    }
    int i;
    int j;
    label406:
    Object localObject2;
    if (paramInt < jdField_a_of_type_Int)
    {
      i = 1;
      jdField_a_of_type_Int = paramInt;
      e(paramInt);
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(a(paramInt));
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "recent_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
      }
      j = b();
      if ((j != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "cmshow", "Apollo", "game_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int), 0, new String[] { Integer.toString(j) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        return;
      }
      int k = 0;
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
        j = k;
        if (localObject1 != null)
        {
          j = k;
          if (((List)localObject1).size() > 0)
          {
            j = k;
            if (m >= 0)
            {
              j = k;
              if (m < ((List)localObject1).size())
              {
                localObject1 = (ApolloActionPackage)((List)localObject1).get(m);
                j = k;
                if (localObject1 != null) {
                  j = ((ApolloActionPackage)localObject1).packageId;
                }
              }
            }
          }
        }
      }
      if (j != 6) {
        break label738;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      Object localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      k = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (i == 0) {
        break label750;
      }
      localObject2 = "0";
      label457:
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, k, j, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        return;
      }
      localObject2 = null;
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      label545:
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)((Iterator)localObject3).next();
        i = j;
        if (localApolloViewBinder == null) {
          break label758;
        }
        i = j;
        if (!(localApolloViewBinder instanceof ApolloViewBinder)) {
          break label758;
        }
        k = localApolloViewBinder.a();
        j += k;
        i = j;
        if (paramInt + 1 > j) {
          break label758;
        }
        if (!(localApolloViewBinder instanceof ApolloMainViewBinder))
        {
          localObject1 = localObject2;
          if (!(localApolloViewBinder instanceof ApolloFavViewBinder)) {}
        }
        else
        {
          localObject1 = localApolloViewBinder.a(k - (j - paramInt));
        }
      }
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        return;
      }
      localObject2 = new StringBuilder();
      i = ((ArrayList)localObject1).size();
      paramInt = 0;
      label672:
      if (paramInt >= i) {
        break label775;
      }
      localObject3 = (ApolloInfo)((ArrayList)localObject1).get(paramInt);
      if (((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {
        break label763;
      }
      ((StringBuilder)localObject2).append(((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    }
    for (;;)
    {
      if (paramInt != i - 1) {
        ((StringBuilder)localObject2).append("-");
      }
      paramInt += 1;
      break label672;
      i = 0;
      break;
      label738:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label406;
      label750:
      localObject2 = "1";
      break label457;
      label758:
      j = i;
      break label545;
      label763:
      ((StringBuilder)localObject2).append("0");
    }
    label775:
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  public void setTabSelect(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setTabSelect] newIndex=", Integer.valueOf(paramInt), ", mLastTabIndex=", Integer.valueOf(this.jdField_h_of_type_Int) });
    }
    QQAppInterface localQQAppInterface;
    String str;
    int j;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
      }
      if ((this.jdField_h_of_type_Int == -1) || (this.jdField_h_of_type_Int != paramInt)) {
        s();
      }
      Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt);
      i = this.jdField_h_of_type_Int;
      this.jdField_h_of_type_Int = paramInt;
      if (localObject != null)
      {
        ((View)localObject).setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a(paramInt);
        this.jdField_a_of_type_AndroidViewView = ((View)localObject);
        a(paramInt, (View)localObject);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localObject = (ApolloActionPackage)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a().get(paramInt);
          if ((((ApolloActionPackage)localObject).packageId == 100) && (i != paramInt)) {
            ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1);
          }
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          j = ((ApolloActionPackage)localObject).packageId;
          localStringBuilder = new StringBuilder().append("");
          if (!((ApolloActionPackage)localObject).isUpdate) {
            break label375;
          }
        }
      }
    }
    label375:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, j, 0, new String[] { i, "" + ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", String.valueOf(System.currentTimeMillis() / 1000L) });
      d(paramInt);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 8)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      s();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
      }
      this.jdField_h_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */