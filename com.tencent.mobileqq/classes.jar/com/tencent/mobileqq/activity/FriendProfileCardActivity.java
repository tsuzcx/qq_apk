package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.container.ProfileBgContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileFgContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer;
import com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent;
import com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.mobileqq.widget.ProfileConfigHelper.OnConfigUpdateListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements TopGestureLayout.OnGestureListener, XListView.MotionEventInterceptor
{
  public static long a;
  public static AtomicInteger a;
  private byte jdField_a_of_type_Byte;
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new FriendProfileCardActivity.10(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Uri jdField_a_of_type_AndroidNetUri;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new FriendProfileCardActivity.16(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new FriendProfileCardActivity.11(this);
  public View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  public ProfileActivity.CardContactInfo a;
  protected SDKAvatarSettingManager a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new FriendProfileCardActivity.4(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FriendProfileCardActivity.7(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new FriendProfileCardActivity.8(this);
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new FriendProfileCardActivity.6(this);
  public ProfileCardInfo a;
  private IProfileActivityDelegate jdField_a_of_type_ComTencentMobileqqProfilecardBaseComponentIProfileActivityDelegate = new FriendProfileCardActivity.23(this);
  private ProfileBgContainer jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer;
  private ProfileContentContainer jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer;
  private ProfileFgContainer jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer;
  private ProfileHeaderContainer jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer;
  private ProfileTitleContainer jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer;
  private IComponentCenter jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter;
  @Deprecated
  public AbsProfileHeaderView a;
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new FriendProfileCardActivity.5(this);
  private VasProfileTemplateController jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController;
  public BusinessInfoCheckUpdate.AppInfo a;
  public RedTouch a;
  public TimeTraceUtil a;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new FriendProfileCardActivity.1(this);
  protected ProfileCardMoreInfoView a;
  private ProfileConfigHelper.OnConfigUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener = new FriendProfileCardActivity.22(this);
  public ProfileConfigHelper a;
  public WeakReferenceHandler a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new FriendProfileCardActivity.18(this);
  PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader = null;
  private List<AbsListView.OnScrollListener> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  int jdField_b_of_type_Int = -1;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new FriendProfileCardActivity.17(this);
  View jdField_b_of_type_AndroidViewView;
  public WeakReferenceHandler b;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public View c;
  public boolean c;
  public View d;
  public boolean d;
  View e;
  public boolean e;
  public boolean f = false;
  boolean g = false;
  private boolean h;
  private boolean i = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public FriendProfileCardActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  private ProfileActivity.AllInOne a(Intent paramIntent)
  {
    Object localObject = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean = paramIntent.hasExtra("troopUin");
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("troopUin");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard = new TroopMemberCard();
      if (localObject == null)
      {
        paramIntent = paramIntent.getStringExtra("memberUin");
        if (TextUtils.isEmpty(paramIntent))
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramIntent);
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            paramIntent = new ProfileActivity.AllInOne(paramIntent, 1);
            paramIntent.jdField_h_of_type_JavaLangString = ((Friends)localObject).name;
            paramIntent.jdField_i_of_type_JavaLangString = ((Friends)localObject).remark;
          }
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString))) {
          paramIntent.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString;
        }
        if ((!TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(paramIntent.d))) {
          paramIntent.d = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).d(paramIntent.jdField_c_of_type_JavaLangString);
        }
        new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("page").d("page_exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString }).a();
        return paramIntent;
        paramIntent = new ProfileActivity.AllInOne(paramIntent, 21);
        paramIntent.jdField_l_of_type_Int = 11;
        continue;
        break;
        paramIntent = (Intent)localObject;
      }
    }
    return localObject;
  }
  
  protected static ProfileActivity.CardContactInfo a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public static String a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (j == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty(null)) {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      return localObject1;
      if ((j == 1000) || (j == 1020))
      {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
        }
      }
      else if (j == 1021)
      {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
        }
      }
      else if (j == 1004)
      {
        localObject1 = localObject2;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d != null) {
          localObject1 = ContactUtils.c(paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfileActivity.AllInOne.i(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, ProfileCardInfo paramProfileCardInfo, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
      localIntent.putExtra("entrance", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    int k = ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str3 = a(paramProfileCardInfo, paramQQAppInterface);
    String str2 = null;
    Object localObject;
    String str1;
    if (ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      if (k != 1000) {
        break label379;
      }
      str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
    }
    for (;;)
    {
      label58:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, k, (String)localObject, str3, str2, true, str1, true, true, null, "from_internal");
      switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str1 = str2;
        int j = k;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          str1 = str2;
          j = k;
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            str1 = str2;
            j = k;
            if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))
            {
              str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
              j = 0;
            }
          }
        }
        str2 = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        localObject = str1;
        k = j;
        break;
        label379:
        if (k != 1004) {
          break label427;
        }
        str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
        break label58;
        paramBaseActivity = "4";
        continue;
        paramBaseActivity = "5";
        continue;
        paramBaseActivity = "6";
        continue;
        paramBaseActivity = "7";
      }
      label427:
      str1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, Dialog paramDialog)
  {
    Object localObject1 = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int m;
    int n;
    int j;
    int k;
    if (localObject1 != null)
    {
      bool = ((Bundle)localObject1).getBoolean("from_babyq", false);
      m = 3999;
      n = 0;
      j = n;
      k = m;
      switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        k = m;
        j = n;
      }
    }
    for (;;)
    {
      if (k == 3045) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      }
      if (k == 3094) {
        ReportController.a(paramQQAppInterface, "dc00898", "", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(j), ExtendFriendReport.a(), ExtendFriendReport.a(paramQQAppInterface), ExtendFriendReport.c());
      }
      if ((k != 3007) || (LBSHandler.a(paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label1571;
      }
      localObject1 = paramDialog;
      if (paramDialog == null) {
        localObject1 = LBSHandler.a(paramBaseActivity, paramBaseActivity.getString(2131694436), new FriendProfileCardActivity.12(paramQQAppInterface, paramBaseActivity, paramProfileCardInfo), new FriendProfileCardActivity.13());
      }
      if ((localObject1 != null) && (!((Dialog)localObject1).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject1).show();
      }
      return;
      bool = false;
      break;
      j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3004;
      continue;
      j = 3;
      k = 3004;
      continue;
      j = 1;
      k = 3007;
      continue;
      j = 1;
      k = 3001;
      continue;
      j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3020;
      continue;
      j = 1;
      k = 3017;
      continue;
      j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3002;
      continue;
      j = 1;
      k = 3005;
      continue;
      j = 2;
      k = 3007;
      continue;
      j = 0;
      k = 3003;
      continue;
      j = 12;
      k = 3008;
      continue;
      j = 11;
      k = 3008;
      continue;
      j = 12;
      k = 3041;
      continue;
      j = 11;
      k = 3041;
      continue;
      j = 0;
      k = 3999;
      continue;
      j = 1;
      k = 3037;
      continue;
      j = 1;
      k = 3095;
      continue;
      j = 1;
      k = 3096;
      continue;
      j = 1;
      k = 3042;
      continue;
      j = 2;
      k = 3037;
      continue;
      j = 0;
      k = 3009;
      continue;
      k = 3006;
      j = 13;
      if (bool)
      {
        j = 1;
        k = 3084;
        continue;
        k = 3068;
        j = 1;
        if (bool)
        {
          j = 1;
          k = 3084;
          continue;
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 16) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 17))
          {
            j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
            k = 3006;
          }
          else
          {
            j = 1;
            k = 3075;
            continue;
            j = 1;
            k = 3009;
            continue;
            j = 1;
            k = 3006;
            continue;
            j = 0;
            k = 3013;
            continue;
            j = 1;
            k = 3003;
            continue;
            j = 1;
            k = 3014;
            continue;
            j = 2;
            k = 3003;
            continue;
            k = 3022;
            j = 1;
            if (bool)
            {
              j = 1;
              k = 3083;
              continue;
              j = 0;
              k = 3011;
              continue;
              if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 127)
              {
                j = 1;
                k = 3048;
              }
              else
              {
                j = 1;
                k = 3071;
                continue;
                j = 21;
                k = 3045;
                continue;
                j = 23;
                k = 3045;
                continue;
                k = 3045;
                j = 3;
                if (bool)
                {
                  j = 1;
                  k = 3083;
                  continue;
                  if (localObject1 != null) {}
                  for (j = ((Bundle)localObject1).getInt("tabID", 0);; j = 0)
                  {
                    k = 3045;
                    break;
                  }
                  j = 28;
                  k = 3045;
                  continue;
                  j = 4;
                  k = 3045;
                  continue;
                  j = 24;
                  k = 3045;
                  continue;
                  j = 20;
                  k = 3045;
                  continue;
                  j = 25;
                  k = 3045;
                  continue;
                  j = 1;
                  k = 3092;
                  continue;
                  j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
                  k = 3094;
                  continue;
                  j = 11;
                  k = 3072;
                  continue;
                  j = 12;
                  k = 3072;
                  continue;
                  j = 1;
                  k = 3018;
                  continue;
                  j = 15;
                  k = 3041;
                  continue;
                  j = 14;
                  k = 3041;
                  continue;
                  if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
                  {
                    j = 3;
                    k = 3022;
                  }
                  else
                  {
                    j = n;
                    k = m;
                    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 121)
                    {
                      j = 2;
                      k = 3022;
                      continue;
                      j = 23;
                      k = 3004;
                      continue;
                      j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
                      k = 3004;
                      continue;
                      j = 1;
                      k = 3050;
                      continue;
                      j = 4;
                      k = 3076;
                      continue;
                      j = 6;
                      k = 3076;
                      continue;
                      j = 2;
                      k = 3047;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1571:
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject1 = ProfileCardUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.age, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);; localObject1 = "")
    {
      Object localObject2;
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if ((localCardContactInfo == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
          break;
        }
        localObject2 = localCardContactInfo.b + localCardContactInfo.jdField_c_of_type_JavaLangString;
        paramDialog = localCardContactInfo.jdField_a_of_type_JavaLangString;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label1885;
          }
          paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, (String)localObject2, null, k, j, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690778), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject1);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramProfileCardInfo);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          label1885:
          if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]))
          {
            paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
              paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
      paramQQAppInterface = null;
      if ((3004 == k) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)))
      {
        paramDialog = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
        paramQQAppInterface = null;
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)) {
          break label2171;
        }
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
        label2003:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2412;
        }
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      label2409:
      label2412:
      for (;;)
      {
        localObject2 = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (localObject2 != null)
        {
          localObject1 = AddContactsActivity.class.getName();
          if (!((String)localObject2).equals(QidianProfileCardActivity.class.getName())) {
            break label2409;
          }
          localObject1 = localObject2;
        }
        for (;;)
        {
          localObject2 = paramQQAppInterface;
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
          }
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, k, j, (String)localObject2, null, (String)localObject1, paramBaseActivity.getString(2131690778), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramProfileCardInfo);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != k) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
            break;
          }
          paramDialog = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          break;
          label2171:
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 82) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 81) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 83) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 84) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 101) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 103) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 102) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 107) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 110)) {
            break label2003;
          }
          paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5];
          break label2003;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, k, j, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690778), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramProfileCardInfo);
          if (k == 3094)
          {
            paramQQAppInterface.putExtra("entrance", paramBaseActivity.getIntent().getIntExtra("entrance", 2));
            paramQQAppInterface.removeExtra("param_return_addr");
            paramBaseActivity.startActivity(paramQQAppInterface);
            return;
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject1);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, String paramString, int paramInt)
  {
    if (paramBaseActivity.getIntent() != null) {}
    for (boolean bool = paramBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false);; bool = false)
    {
      Object localObject;
      Intent localIntent;
      if (bool)
      {
        localObject = new Intent(paramBaseActivity, ChatActivity.class);
        localIntent = AIOUtils.a((Intent)localObject, null);
        localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
        localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramBaseActivity.getIntent().getExtras() != null) {
          localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
        }
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("aio_msg_source", 3);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
          localIntent.putExtra("entrance", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
        }
        localObject = a(paramProfileCardInfo, paramQQAppInterface);
        if (localObject != null) {
          break label488;
        }
        paramString = "";
        label181:
        localIntent.putExtra("uinname", paramString);
        if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
          break label494;
        }
        localIntent.putExtra("troop_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
          localIntent.putExtra("troop_code", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString);
        }
        if (paramInt == 1009) {
          localIntent.putExtra("rich_status_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (paramInt == 1001) {
          localIntent.putExtra("rich_accost_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), Utils.a((String)localObject), Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) }));
        }
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((paramQQAppInterface != null) && ((CrmUtils.a(paramQQAppInterface.cSpecialFlag)) || (QidianManager.b(paramQQAppInterface.cSpecialFlag)))) {
            localIntent.putExtra("chat_subType", 1);
          }
        }
        localIntent.putExtra("hidden_aio_msg_source", 2);
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101)) {
          break label526;
        }
        localIntent.putExtra("is_from_manage_stranger", true);
        paramBaseActivity.startActivityForResult(localIntent, 1010);
        return;
        localObject = new Intent(paramBaseActivity, SplashActivity.class);
        break;
        label488:
        paramString = (String)localObject;
        break label181;
        label494:
        if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
          localIntent.putExtra("troop_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
        }
      }
      label526:
      paramBaseActivity.startActivity(localIntent);
      return;
    }
  }
  
  /* Error */
  public static void a(QQAppInterface arg0, ProfileCardInfo paramProfileCardInfo)
  {
    // Byte code:
    //   0: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 441
    //   9: iconst_2
    //   10: ldc_w 733
    //   13: invokestatic 705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 255	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 260	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_1
    //   34: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 350	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   40: astore 5
    //   42: aload_1
    //   43: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 735	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 738	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   58: astore 10
    //   60: aload_1
    //   61: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 740	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   67: astore 14
    //   69: aload_1
    //   70: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 353	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 742	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +580 -> 673
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: getstatic 230	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   108: invokevirtual 236	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   111: checkcast 238	com/tencent/mobileqq/app/FriendsManager
    //   114: astore 4
    //   116: aload 4
    //   118: ifnonnull +530 -> 648
    //   121: aconst_null
    //   122: astore 11
    //   124: aload 6
    //   126: astore 9
    //   128: aload 11
    //   130: ifnull +881 -> 1011
    //   133: aload 6
    //   135: astore 4
    //   137: aload 6
    //   139: astore 7
    //   141: aload 6
    //   143: astore 8
    //   145: aload 11
    //   147: getfield 253	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   150: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +18 -> 171
    //   156: aload 6
    //   158: astore 7
    //   160: aload 6
    //   162: astore 8
    //   164: aload 11
    //   166: getfield 253	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   169: astore 4
    //   171: aload 4
    //   173: astore 7
    //   175: aload 4
    //   177: astore 8
    //   179: aload 4
    //   181: astore 9
    //   183: aload 11
    //   185: getfield 258	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   188: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +820 -> 1011
    //   194: aload 4
    //   196: astore 7
    //   198: aload 4
    //   200: astore 8
    //   202: aload 11
    //   204: getfield 258	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   207: astore 6
    //   209: aload 4
    //   211: astore_3
    //   212: aload 6
    //   214: astore 4
    //   216: aload_0
    //   217: getstatic 267	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   220: invokevirtual 236	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   223: checkcast 269	com/tencent/mobileqq/app/TroopManager
    //   226: astore 8
    //   228: aload_1
    //   229: getfield 203	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: astore 7
    //   234: aload 7
    //   236: astore 6
    //   238: aload 7
    //   240: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifeq +34 -> 277
    //   246: aload 7
    //   248: astore 6
    //   250: aload_1
    //   251: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   254: getfield 264	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:d	Ljava/lang/String;
    //   257: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: ifne +17 -> 277
    //   263: aload 8
    //   265: aload_1
    //   266: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   269: getfield 264	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:d	Ljava/lang/String;
    //   272: invokevirtual 744	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 6
    //   277: aload 6
    //   279: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifne +710 -> 992
    //   285: aload 8
    //   287: ifnull +705 -> 992
    //   290: aload_0
    //   291: ldc_w 746
    //   294: ldc_w 339
    //   297: invokevirtual 750	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   300: checkcast 746	com/tencent/mobileqq/troop/api/ITroopMemberNameService
    //   303: aload 6
    //   305: aload_1
    //   306: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   309: getfield 221	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   312: invokeinterface 754 3 0
    //   317: astore_0
    //   318: aload 10
    //   320: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +662 -> 985
    //   326: aload_1
    //   327: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   330: invokestatic 323	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   333: astore 5
    //   335: aload 5
    //   337: ifnull +648 -> 985
    //   340: aload 5
    //   342: getfield 606	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   345: astore 5
    //   347: aload 4
    //   349: astore 6
    //   351: aload 5
    //   353: astore 9
    //   355: aload_3
    //   356: astore 4
    //   358: aload 6
    //   360: astore 5
    //   362: aload_0
    //   363: astore 6
    //   365: aload_1
    //   366: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   369: astore_0
    //   370: aload_0
    //   371: monitorenter
    //   372: aload_1
    //   373: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   376: iconst_0
    //   377: aaload
    //   378: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifeq +11 -> 392
    //   384: aload_1
    //   385: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   388: iconst_0
    //   389: aload 4
    //   391: aastore
    //   392: aload_1
    //   393: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   396: iconst_4
    //   397: aaload
    //   398: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifeq +11 -> 412
    //   404: aload_1
    //   405: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   408: iconst_4
    //   409: aload 5
    //   411: aastore
    //   412: aload_1
    //   413: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   416: iconst_3
    //   417: aaload
    //   418: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   421: ifeq +11 -> 432
    //   424: aload_1
    //   425: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   428: iconst_3
    //   429: aload 9
    //   431: aastore
    //   432: aload_1
    //   433: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   436: iconst_5
    //   437: aaload
    //   438: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   441: ifeq +11 -> 452
    //   444: aload_1
    //   445: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   448: iconst_5
    //   449: aload 12
    //   451: aastore
    //   452: aload_1
    //   453: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   456: iconst_1
    //   457: aaload
    //   458: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifeq +11 -> 472
    //   464: aload_1
    //   465: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   468: iconst_1
    //   469: aload 6
    //   471: aastore
    //   472: aload_1
    //   473: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   476: bipush 6
    //   478: aaload
    //   479: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifeq +12 -> 494
    //   485: aload_1
    //   486: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   489: bipush 6
    //   491: aload 14
    //   493: aastore
    //   494: aload_1
    //   495: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   498: iconst_2
    //   499: aaload
    //   500: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifeq +11 -> 514
    //   506: aload_1
    //   507: getfield 347	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   510: iconst_2
    //   511: aload 13
    //   513: aastore
    //   514: aload_0
    //   515: monitorexit
    //   516: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +128 -> 647
    //   522: new 325	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   529: astore_0
    //   530: aload_0
    //   531: ldc_w 756
    //   534: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 758
    //   540: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 4
    //   545: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   548: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc_w 760
    //   554: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload 5
    //   559: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   562: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: ldc_w 762
    //   568: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 9
    //   573: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   576: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: ldc_w 764
    //   582: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 12
    //   587: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: ldc_w 766
    //   596: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 6
    //   601: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   604: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 768
    //   610: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 13
    //   615: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   618: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc_w 770
    //   624: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 12
    //   629: invokestatic 696	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: ldc_w 441
    //   639: iconst_2
    //   640: aload_0
    //   641: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 446	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: return
    //   648: aload 6
    //   650: astore 7
    //   652: aload 6
    //   654: astore 8
    //   656: aload 4
    //   658: aload_1
    //   659: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   662: getfield 221	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   665: invokevirtual 707	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   668: astore 11
    //   670: goto -546 -> 124
    //   673: aload 6
    //   675: astore 7
    //   677: aload 6
    //   679: astore 8
    //   681: aload_1
    //   682: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   685: getfield 476	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   688: ifne +33 -> 721
    //   691: aload 6
    //   693: astore 7
    //   695: aload 6
    //   697: astore 8
    //   699: aload_0
    //   700: aload_1
    //   701: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   704: getfield 221	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   707: invokestatic 773	com/tencent/mobileqq/utils/ContactUtils:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   710: astore 6
    //   712: aload_3
    //   713: astore 4
    //   715: aload 6
    //   717: astore_3
    //   718: goto -502 -> 216
    //   721: aload 6
    //   723: astore 7
    //   725: aload 6
    //   727: astore 8
    //   729: aload 6
    //   731: astore 4
    //   733: aload 6
    //   735: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   738: ifeq +260 -> 998
    //   741: aload 6
    //   743: astore 7
    //   745: aload 6
    //   747: astore 8
    //   749: aload 6
    //   751: astore 4
    //   753: aload_1
    //   754: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   757: invokestatic 434	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:g	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   760: ifeq +238 -> 998
    //   763: aload 6
    //   765: astore 7
    //   767: aload 6
    //   769: astore 8
    //   771: aload_0
    //   772: aload_1
    //   773: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   776: getfield 221	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   779: iconst_0
    //   780: invokestatic 776	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   783: astore 4
    //   785: aload 4
    //   787: astore 7
    //   789: aload 4
    //   791: astore 8
    //   793: aload 4
    //   795: aload_1
    //   796: getfield 220	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   799: getfield 221	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   802: invokestatic 779	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   805: istore_2
    //   806: iload_2
    //   807: ifeq +191 -> 998
    //   810: aconst_null
    //   811: astore 6
    //   813: aload_3
    //   814: astore 4
    //   816: aload 6
    //   818: astore_3
    //   819: goto -603 -> 216
    //   822: astore 8
    //   824: aload 5
    //   826: astore_0
    //   827: aload_0
    //   828: astore 6
    //   830: aload_3
    //   831: astore 5
    //   833: aload 7
    //   835: astore 4
    //   837: aload 10
    //   839: astore 9
    //   841: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq -479 -> 365
    //   847: ldc_w 441
    //   850: iconst_2
    //   851: aload 8
    //   853: invokevirtual 780	java/lang/Exception:toString	()Ljava/lang/String;
    //   856: invokestatic 446	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: aload_0
    //   860: astore 6
    //   862: aload_3
    //   863: astore 5
    //   865: aload 7
    //   867: astore 4
    //   869: aload 10
    //   871: astore 9
    //   873: goto -508 -> 365
    //   876: astore 7
    //   878: aload 5
    //   880: astore_0
    //   881: aload_0
    //   882: astore 6
    //   884: aload_3
    //   885: astore 5
    //   887: aload 8
    //   889: astore 4
    //   891: aload 10
    //   893: astore 9
    //   895: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   898: ifeq -533 -> 365
    //   901: ldc_w 441
    //   904: iconst_2
    //   905: aload 7
    //   907: invokevirtual 781	java/lang/Error:toString	()Ljava/lang/String;
    //   910: invokestatic 446	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   913: aload_0
    //   914: astore 6
    //   916: aload_3
    //   917: astore 5
    //   919: aload 8
    //   921: astore 4
    //   923: aload 10
    //   925: astore 9
    //   927: goto -562 -> 365
    //   930: astore_1
    //   931: aload_0
    //   932: monitorexit
    //   933: aload_1
    //   934: athrow
    //   935: astore 7
    //   937: aload_3
    //   938: astore 8
    //   940: aload 5
    //   942: astore_0
    //   943: aload 4
    //   945: astore_3
    //   946: goto -65 -> 881
    //   949: astore 7
    //   951: aload_3
    //   952: astore 8
    //   954: aload 4
    //   956: astore_3
    //   957: goto -76 -> 881
    //   960: astore 8
    //   962: aload_3
    //   963: astore 7
    //   965: aload 5
    //   967: astore_0
    //   968: aload 4
    //   970: astore_3
    //   971: goto -144 -> 827
    //   974: astore 8
    //   976: aload_3
    //   977: astore 7
    //   979: aload 4
    //   981: astore_3
    //   982: goto -155 -> 827
    //   985: aload 10
    //   987: astore 5
    //   989: goto -642 -> 347
    //   992: aload 5
    //   994: astore_0
    //   995: goto -677 -> 318
    //   998: aload 4
    //   1000: astore 6
    //   1002: aload_3
    //   1003: astore 4
    //   1005: aload 6
    //   1007: astore_3
    //   1008: goto -792 -> 216
    //   1011: aload_3
    //   1012: astore 4
    //   1014: aload 9
    //   1016: astore_3
    //   1017: goto -801 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1020	1	paramProfileCardInfo	ProfileCardInfo
    //   805	2	2	bool	boolean
    //   32	985	3	localObject1	Object
    //   114	899	4	localObject2	Object
    //   40	953	5	localObject3	Object
    //   23	983	6	localObject4	Object
    //   80	786	7	localObject5	Object
    //   876	30	7	localError1	java.lang.Error
    //   935	1	7	localError2	java.lang.Error
    //   949	1	7	localError3	java.lang.Error
    //   963	15	7	localObject6	Object
    //   84	708	8	localObject7	Object
    //   822	98	8	localException1	Exception
    //   938	15	8	localObject8	Object
    //   960	1	8	localException2	Exception
    //   974	1	8	localException3	Exception
    //   126	889	9	localObject9	Object
    //   58	928	10	str1	String
    //   122	547	11	localFriends	Friends
    //   49	579	12	str2	String
    //   76	538	13	str3	String
    //   67	425	14	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	96	822	java/lang/Exception
    //   104	116	822	java/lang/Exception
    //   145	156	822	java/lang/Exception
    //   164	171	822	java/lang/Exception
    //   183	194	822	java/lang/Exception
    //   202	209	822	java/lang/Exception
    //   656	670	822	java/lang/Exception
    //   681	691	822	java/lang/Exception
    //   699	712	822	java/lang/Exception
    //   733	741	822	java/lang/Exception
    //   753	763	822	java/lang/Exception
    //   771	785	822	java/lang/Exception
    //   793	806	822	java/lang/Exception
    //   86	96	876	java/lang/Error
    //   104	116	876	java/lang/Error
    //   145	156	876	java/lang/Error
    //   164	171	876	java/lang/Error
    //   183	194	876	java/lang/Error
    //   202	209	876	java/lang/Error
    //   656	670	876	java/lang/Error
    //   681	691	876	java/lang/Error
    //   699	712	876	java/lang/Error
    //   733	741	876	java/lang/Error
    //   753	763	876	java/lang/Error
    //   771	785	876	java/lang/Error
    //   793	806	876	java/lang/Error
    //   372	392	930	finally
    //   392	412	930	finally
    //   412	432	930	finally
    //   432	452	930	finally
    //   452	472	930	finally
    //   472	494	930	finally
    //   494	514	930	finally
    //   514	516	930	finally
    //   931	933	930	finally
    //   216	234	935	java/lang/Error
    //   238	246	935	java/lang/Error
    //   250	277	935	java/lang/Error
    //   277	285	935	java/lang/Error
    //   290	318	935	java/lang/Error
    //   318	335	949	java/lang/Error
    //   340	347	949	java/lang/Error
    //   216	234	960	java/lang/Exception
    //   238	246	960	java/lang/Exception
    //   250	277	960	java/lang/Exception
    //   277	285	960	java/lang/Exception
    //   290	318	960	java/lang/Exception
    //   318	335	974	java/lang/Exception
    //   340	347	974	java/lang/Exception
  }
  
  private void a(Card paramCard, int paramInt)
  {
    boolean bool2;
    if ((paramInt == 8) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.i))
    {
      this.i = true;
      bool2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramCard.uin);
      if ((paramCard.lUserFlag & 0x800) == 0L) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isFriend=%s profileFriend=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      if (bool1 != bool2) {
        ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendDetailInfo(paramCard.uin);
      }
      return;
    }
  }
  
  public static void a(ProfileCardInfo paramProfileCardInfo)
  {
    int m = 6;
    int j = 3;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    int k;
    switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      j = 1;
      k = 0;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(k, j, paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "updateProfileName profileName: %s", new Object[] { paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString() }));
      }
      return;
      if (paramProfileCardInfo.jdField_b_of_type_Boolean)
      {
        k = 3;
        j = 2;
      }
      else
      {
        j = 2;
        k = 1;
        continue;
        j = 2;
        k = 2;
        continue;
        if (paramProfileCardInfo.jdField_b_of_type_Boolean)
        {
          k = 3;
          j = 2;
        }
        else
        {
          j = 2;
          k = 2;
          continue;
          k = 3;
          j = 2;
          continue;
          k = 3;
          j = 1;
          continue;
          k = 4;
          j = 1;
          continue;
          j = 2;
          k = m;
          continue;
          j = 1;
          k = m;
          continue;
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            k = m;
            if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {}
          }
          else
          {
            j = 1;
            k = m;
            continue;
            k = 7;
            j = 2;
            continue;
            k = 7;
            j = 1;
            continue;
            k = 8;
            j = 1;
            continue;
            k = 9;
            j = 1;
            continue;
            k = 11;
            j = 1;
            continue;
            j = 1;
            k = 1;
            continue;
            k = 5;
            j = 1;
          }
        }
      }
    }
  }
  
  private boolean a(Intent paramIntent, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramIntent.hasExtra("param_wzry_data"))
    {
      paramIntent = paramIntent.getSerializableExtra("param_wzry_data");
      if (paramIntent != null)
      {
        paramAllInOne = KPLProfileCardActivity.a(this);
        paramAllInOne.putExtra("param_wzry_data", paramIntent);
        startActivity(paramAllInOne);
        finish();
        return true;
      }
    }
    if ((Utils.b(paramAllInOne.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(getApplicationContext())))
    {
      overridePendingTransition(0, 0);
      finish();
      return true;
    }
    if ((BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean))
    {
      paramIntent = new Intent(this, QidianProfileCardActivity.class);
      paramIntent.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      super.startActivity(paramIntent);
      super.finish();
      return true;
    }
    return false;
  }
  
  public static boolean a(ProfileCardInfo paramProfileCardInfo, int paramInt, String paramString)
  {
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString == null) || (paramInt < 0) || (paramInt >= paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return false;
    }
    paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramIntent = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label95;
      }
    }
    for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) {
      label95:
      do
      {
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.feedPreviewTime, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vSeed, paramIntent, true);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36));
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    ThreadPriorityManager.a(true);
    ProfileActivity.AllInOne localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    int j = ProfileCardUtil.a(localAllInOne);
    if ((localAllInOne.f != null) && (localAllInOne.f.length() > 0) && (localAllInOne.jdField_e_of_type_Int != 3000) && (localAllInOne.jdField_e_of_type_Int != 1) && (localAllInOne.jdField_e_of_type_Int != 2) && (localAllInOne.jdField_e_of_type_Int != 1033) && (localAllInOne.jdField_e_of_type_Int != 1034) && (localAllInOne.jdField_e_of_type_Int != 1044) && (localAllInOne.jdField_e_of_type_Int != 1045) && (localAllInOne.f.equals(localAllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.i(localAllInOne)) {
      if (localAllInOne.jdField_a_of_type_Int == 53) {
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          j = 0;
          str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramProfileCardInfo, str, j);
      return;
      j = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.jdField_a_of_type_Int == 3) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 102) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 103) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.onDataUpdate(paramProfileCardInfo)))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.getHeaderComponent();
        if (localObject != null)
        {
          localObject = ((AbsProfileHeaderComponent)localObject).getHeaderView();
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = ((AbsProfileHeaderView)localObject);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = ((AbsProfileHeaderView)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer.onDataUpdate(paramProfileCardInfo);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer.onDataUpdate(paramProfileCardInfo);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer.onDataUpdate(paramProfileCardInfo);
      }
      return;
    }
    catch (Exception paramProfileCardInfo)
    {
      QLog.e("FriendProfileCardActivity", 1, "notifyComponentDataUpdate fail.", paramProfileCardInfo);
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "initAvatarManager failed intent null");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramIntent.getBundleExtra("profile_extres");
    } while ((localBundle == null) || (!localBundle.getBoolean("key_from_sdk_set_avatar", false)));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager = new SDKAvatarSettingManager(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.a(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.a();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 90)
    {
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localFriendsManager == null) || (!localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label229;
      }
    }
    label229:
    for (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 19)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 100) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) && (!((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).i())) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 29;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) && (TextUtils.equals(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0"))) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
    }
  }
  
  private void o()
  {
    int j;
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 59) {
        break label239;
      }
      j = 1;
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X800723B", "0X800723B", j, 0, "", "", "", "");
      label117:
      Object localObject2;
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A11E ", "0X800A11E ", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "", "0X800A4BF", 0, 0, "", "", "", "");
        if (ProfileCardUtil.a())
        {
          localObject2 = Locale.getDefault().getCountry();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = this.app;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label332;
          }
        }
      }
      label332:
      for (j = 1;; j = 2)
      {
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X8008CA2", "0X8008CA2", j, 0, "", "", (String)localObject1, "");
        ProfileCardReport.reportProfileEntry(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        return;
        label239:
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 1)
        {
          j = 2;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 8) {
          break label337;
        }
        j = 3;
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 121) {
          break label117;
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800A51D", "0X800A51D", 0, 0, "", "", "", "");
        break label117;
      }
      label337:
      j = 0;
    }
  }
  
  private void p()
  {
    ProfileExtendFriendComponent localProfileExtendFriendComponent;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
    {
      localProfileExtendFriendComponent = (ProfileExtendFriendComponent)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.getComponent(1008);
      if (localProfileExtendFriendComponent == null) {}
    }
    for (boolean bool = localProfileExtendFriendComponent.interceptAddFriend(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);; bool = false)
    {
      if (!bool) {
        a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_AndroidAppDialog);
      }
      return;
    }
  }
  
  private void q()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.isFriend) || ((localObject != null) && (((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))))
    {
      localIntent.putExtra("uintype", 0);
      String str = ContactUtils.e(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.nick;
      }
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString);
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        break label244;
      }
      ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString, new FriendProfileCardActivity.15(this, localIntent));
    }
    label244:
    while (!QLog.isColorLevel())
    {
      return;
      localIntent.putExtra("uintype", 1000);
      break;
    }
    QLog.e("FriendProfileCardActivity", 2, "enterChatByTroopMember, troopManager is null");
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "updateTheme");
    }
    for (;;)
    {
      try
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
          break label224;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        ProfileCardTemplate.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "background");
        if (ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundDrawable(null);
          if (ThemeUtil.isInNightMode(this.app))
          {
            if (this.jdField_c_of_type_AndroidViewView != null) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false, new String[0]);
          }
        }
        else
        {
          ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
          continue;
        }
        if (this.jdField_c_of_type_AndroidViewView == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "updateTheme fail.", localException);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      continue;
      label224:
      if (ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
      {
        localException.setForeground(null);
        localException.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
        if (ThemeUtil.isInNightMode(this.app))
        {
          if (this.jdField_c_of_type_AndroidViewView != null) {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          }
        }
        else if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "updateTheme: cardInfo.currentTemplate is null");
        }
        localException.setForeground(getResources().getDrawable(2130850513));
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_Byte = ((byte)SharedPreUtils.X(getApplication(), this.app.getCurrentAccountUin()));
    TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) && (localTroopManager.n(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  private void t()
  {
    try
    {
      u();
      v();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "initComponentCenter fail.", localException);
      finish();
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter = new ComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.init(this);
    }
  }
  
  private void v()
  {
    FrameLayout localFrameLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369063);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer = ((ProfileHeaderContainer)ProfileComponentFactory.create(102, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo));
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.setProfileArgs(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, (ViewGroup)this.jdField_d_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.setProfileHeaderDelegate(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseComponentIProfileActivityDelegate);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.setContainerView(localFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.attachToComponentCenter();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer = ((ProfileContentContainer)ProfileComponentFactory.create(103, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo));
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.setProfileArgs(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.setProfileDelegate(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseComponentIProfileActivityDelegate);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.setContainerView(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.attachToComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setContentContainer(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373516);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer = ((ProfileBgContainer)ProfileComponentFactory.create(104, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo));
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer.setContainerView(localFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer.attachToComponentCenter();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373529);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer = ((ProfileFgContainer)ProfileComponentFactory.create(105, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo));
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer.setContainerView(localFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer.attachToComponentCenter();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373538));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer = ((ProfileTitleContainer)ProfileComponentFactory.create(106, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo));
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer.setProfileArgs(this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer.setProfileDelegate(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseComponentIProfileActivityDelegate);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer.setContainerView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer.attachToComponentCenter();
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer.detachFromComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileHeaderContainer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.detachFromComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer.detachFromComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileBgContainer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer.detachFromComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer.detachFromComponentCenter();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileTitleContainer = null;
    }
  }
  
  Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString2 = ((IProfileDataService)this.app.getRuntimeService(IProfileDataService.class, "all")).getContactCardByMobileNo(paramString2, false);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.startsWith("+"))
      {
        localObject = paramString;
        if (paramString.length() == 11)
        {
          localObject = paramString;
          if (!paramString.startsWith("0"))
          {
            localObject = ((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
            if ((localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).nationCode))) {
              break label101;
            }
            localObject = ((RespondQueryQQBindingStat)localObject).nationCode + paramString.trim();
          }
        }
      }
    }
    return localObject;
    label101:
    return "+86" + paramString.trim();
  }
  
  public void a()
  {
    Message localMessage;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "send async message to init card in db");
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        localMessage = null;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label66;
        }
      }
    }
    for (;;)
    {
      if (localMessage != null) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      }
      return;
      label66:
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "initCardInfo. SUBTHREAD_MSG_INIT_CARD");
        }
        localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        localMessage.what = 2;
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    int k;
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) && (((TroopManager)localObject).n(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString)))
    {
      localObject = ((TroopManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer != null)
      {
        ProfileTroopMemInfoComponent localProfileTroopMemInfoComponent = (ProfileTroopMemInfoComponent)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.getComponent(1013);
        if (localProfileTroopMemInfoComponent != null) {
          localProfileTroopMemInfoComponent.checkAndUpdateTroopInfo((TroopInfo)localObject);
        }
      }
      if ((((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        k = 1;
        j = 1;
      }
    }
    for (;;)
    {
      int n = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int m = 0;
      for (;;)
      {
        if (m < n)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          m += 1;
          continue;
          k = 0;
          j = 0;
          break;
        }
      }
      switch (paramInt)
      {
      default: 
        j = 0;
        localObject = findViewById(2131373517);
        if (j != 0)
        {
          paramInt = 0;
          ((View)localObject).setVisibility(paramInt);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (j == 0) {
            break label1161;
          }
          paramInt = 0;
          ((LinearLayout)localObject).setVisibility(paramInt);
        }
        break;
      case 1: 
        label265:
        label283:
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131695064, 1, 2131691293);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693346, 1, 2131691240);
          label355:
          localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localObject == null) {
            break label1167;
          }
        }
        break;
      }
      label1161:
      label1167:
      for (boolean bool = ((FriendsManager)localObject).b(this.app.getCurrentUin());; bool = true)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!bool))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 7, 2131693323, 2, 2131691227);
          break;
          if (QVipUtils.a(this.app))
          {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 92, 2131695065, 1, 2131695065);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693346, 1, 2131691240);
            break label355;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131695064, 1, 2131691293);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693346, 1, 2131691240);
          break label355;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131719035, 2, 2131691310);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693323, 1, 2131691227);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 1, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 0);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719035, 2, 2131691310);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693323, 1, 2131691227);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719035, 2, 2131691310);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 1, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 0);
        if ((k == 0) && (!StudyModeManager.a()))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 95, 2131698677, 1, 2131698677);
          ReportController.b(this.app, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719035, 2, 2131691310);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693323, 1, 2131691227);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 1, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131693323, 2, 2131691227);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719035, 2, 2131691310);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 1, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 1, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693395, 1, 2131693395);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693395, 1, 2131693395);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131693323, 2, 2131691227);
        break;
        if (ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693323, 1, 2131691227);
        }
        for (;;)
        {
          if ((k == 0) && (!StudyModeManager.a())) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 77, 2131698677, 1, 2131698677);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719035, 2, 2131691310);
          break;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 1, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(), 0);
        }
        paramInt = 8;
        break label265;
        paramInt = 8;
        break label283;
      }
      k = 0;
      j = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.jdField_c_of_type_Int);
    }
    if ((this.jdField_c_of_type_Int > 5) && (!paramBoolean)) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    } while (localCardHandler == null);
    this.jdField_c_of_type_Int += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int j = 12;
        byte b1 = 0;
        paramArrayOfByte1 = (BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.a(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramBoolean);
          switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 33: 
          case 38: 
          case 39: 
          case 43: 
          case 44: 
          case 48: 
          case 49: 
          case 54: 
          case 59: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 76: 
          case 79: 
          case 85: 
          case 87: 
          case 88: 
          case 89: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 99: 
          case 100: 
          case 109: 
          case 114: 
          case 116: 
          case 118: 
          case 119: 
          default: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
            return;
          case 0: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 60: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 1: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 78: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
            return;
          case 40: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 41: 
            j = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
            {
              j = 37;
              paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
            }
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 42: 
          case 73: 
          case 86: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 36: 
            localCardHandler.a(this.app.getCurrentAccountUin(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 3014, arrayOfByte2, (byte)0);
            return;
          case 30: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 29: 
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
          case 53: 
            j = 16;
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
              j = 17;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
              j = 50;
            }
            break;
          }
          for (;;)
          {
            paramArrayOfByte1 = a(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            localCardHandler.a(this.app.getCurrentAccountUin(), "0", j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, null, (byte)0);
            return;
            ((QCallCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QCALLCARD_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
              break;
            }
            long l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
              int k = 0;
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
              {
                j = 13;
                k = 1;
                paramArrayOfByte1 = this.app.getCurrentAccountUin();
                paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                if (k != 1) {
                  break label1447;
                }
                b1 = this.jdField_a_of_type_Byte;
                localCardHandler.a(paramArrayOfByte1, paramArrayOfByte2, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b1);
              }
            }
            catch (Exception paramArrayOfByte1)
            {
              for (;;)
              {
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                  l1 = l2;
                  continue;
                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
                  {
                    j = 4;
                  }
                  else
                  {
                    j = 14;
                    continue;
                    label1447:
                    b1 = 0;
                  }
                }
              }
            }
            long l1 = ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
            {
              j = 2;
              b1 = 1;
              paramArrayOfByte1 = this.app.getCurrentAccountUin();
              paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              if (b1 != 1) {
                break label1617;
              }
            }
            label1617:
            for (byte b2 = this.jdField_a_of_type_Byte;; b2 = 0)
            {
              localCardHandler.a(paramArrayOfByte1, paramArrayOfByte2, j, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b2);
              return;
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
              {
                j = 5;
                b1 = 0;
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22) {
                break;
              }
              j = 7;
              b1 = 0;
              break;
            }
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 3004) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {}
            }
            label2890:
            label2898:
            for (paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                for (;;)
                {
                  l2 = 0L;
                  try
                  {
                    l1 = Long.parseLong(paramArrayOfByte2);
                    j = 11;
                    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                      j = 35;
                    }
                    localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int, arrayOfByte2, (byte)0);
                    return;
                    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
                      break label2898;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.app.getEntityManagerFactory().createEntityManager().find(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d });
                    if (paramArrayOfByte1 == null) {
                      break label2898;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break;
                    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 3005) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 2005)) {
                      break label2890;
                    }
                    paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
                  }
                  catch (Exception paramArrayOfByte1)
                  {
                    for (;;)
                    {
                      l1 = l2;
                      if (QLog.isColorLevel())
                      {
                        QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                        l1 = l2;
                      }
                    }
                  }
                }
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3095, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3096, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3050, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3076, arrayOfByte2, (byte)0);
                return;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  protected void a(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getComponent();
      if ((localObject != null) && (TextUtils.equals(((ComponentName)localObject).getClassName(), QQBrowserActivity.class.getName())))
      {
        localObject = paramIntent.getStringExtra("url");
        String str = paramIntent.getStringExtra("big_brother_source_key");
        if (TextUtils.isEmpty(str)) {
          paramIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("dealIntent key: %s, url: %s", new Object[] { str, localObject }));
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, getString(paramInt2), paramInt3, getString(paramInt4), 0);
  }
  
  void a(View paramView, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    int j = 2131167066;
    if (paramView == null) {}
    do
    {
      return;
      DataTag localDataTag = new DataTag(paramInt1, null);
      paramView.setVisibility(0);
      if (paramInt2 == 0)
      {
        paramView = (ImageButton)paramView.findViewById(2131368865);
        paramView.setTag(localDataTag);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setImageResource(paramInt3);
        paramView.setContentDescription(paramString2);
        return;
      }
      paramView = (Button)paramView.findViewById(2131380726);
      paramView.setTag(localDataTag);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(paramString2);
      paramView.setText(paramString1);
      paramView.setSingleLine();
      if ((!a(paramInt1)) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      paramView.setTextColor(getResources().getColor(2131167113));
      paramView.setEnabled(this.jdField_c_of_type_Boolean);
    } while ((7 != paramInt1) || (!QSecFramework.a().a(1001).booleanValue()));
    QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
    return;
    if (paramInt2 == 2)
    {
      paramInt2 = 2131167066;
      label205:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label243;
      }
      paramInt2 = j;
    }
    label243:
    for (;;)
    {
      paramView.setTextColor(getResources().getColor(paramInt2));
      break;
      paramInt2 = 2131167068;
      break label205;
    }
  }
  
  void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_e_of_type_AndroidViewView = null;
    int j = getResources().getDimensionPixelSize(2131296749);
    int k = getResources().getDimensionPixelSize(2131296749);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131562182, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_e_of_type_AndroidViewView).d(30).e(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
          c();
        }
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131562182, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561465, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561480, null);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561552, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561552, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561552, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561465, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
      }
    }
  }
  
  void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    Intent localIntent;
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label149;
      }
      localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramCardContactInfo));
    }
    for (;;)
    {
      try
      {
        startActivity(localIntent);
        this.app.getCallFacade().b(paramCardContactInfo);
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        paramCardContactInfo = null;
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "callContact fail.", localException);
        continue;
      }
      label149:
      a(2131693380, 1);
    }
  }
  
  void a(Card paramCard, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
    b(true);
    long l = 0L;
    if (paramCard != null)
    {
      l = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
      paramCard = paramString;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label192;
      }
    }
    label192:
    for (paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramString = null)
    {
      a(l, paramCard, paramString, true);
      return;
      e();
      w();
      t();
      paramCard = null;
      break;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    int k = 99999;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateCardInfo card=%s isNetRet=%s", new Object[] { paramCard, Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initUpdateInfoStart", true);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    r();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean, new String[0]);
    a(paramBoolean);
    int j;
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark)) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark + getResources().getString(2131698575));
      }
    }
    else
    {
      if (paramCard != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Int = paramCard.extendFriendEntryAddFriend;
      }
      j = k;
      if (paramCard != null)
      {
        if (paramCard.mQQLevelType != 0) {
          break label340;
        }
        j = k;
      }
      label217:
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label348;
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A777", j, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick + getResources().getString(2131698575));
      break;
      label340:
      j = paramCard.mQQLevelType;
      break label217;
      label348:
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A776", j, 0, "", "", "", "");
    }
  }
  
  protected void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    if (paramCard != null) {}
    for (;;)
    {
      Message localMessage;
      try
      {
        if (!QLog.isColorLevel()) {
          break label474;
        }
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isNetCard=%s msgType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
      }
      finally {}
      if (paramCard.lCurrentBgId >= 0L)
      {
        ReportController.b(this.app, "CliOper", "", "", "card_mall", "Prof_in_client", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(paramCard.lCurrentBgId), "", "");
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "card_mall", "prof_in_client", "", 1, 0, 0, "", Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), paramCard.lCurrentBgId + "", paramCard.lCurrentStyleId + "", "", "", "", 0, 0, 0, 0);
      }
      a(paramCard, paramBoolean);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      if ((paramCard.tempChatSig != null) && (paramCard.tempChatSig.length > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = paramCard.tempChatSig;
      }
      a(paramCard, paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController = new VasProfileTemplateController(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.onCardUpdate(paramCard, paramInt);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.updateBG;
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.updateStyle;
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.updateDiyText;
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      }
      if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
        if (!paramBoolean) {
          continue;
        }
        j = 1;
        localMessage = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5, j, paramInt, paramCard);
        if ((!bool1) || (!bool2)) {
          continue;
        }
        localMessage.arg2 = 12;
        localMessage.sendToTarget();
        if (bool3) {
          this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5, j, 17, paramCard).sendToTarget();
        }
      }
      return;
      int j = 0;
      continue;
      if (bool1)
      {
        localMessage.arg2 = 11;
        continue;
        label474:
        if (paramInt != 1) {
          if (paramInt != 8) {}
        }
      }
    }
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateContactCardInfo card=%s isNetRet=%s", new Object[] { paramContactCard, Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramContactCard;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    if (a(paramContactCard, paramBoolean)) {
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean, new String[0]);
    a(paramBoolean);
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnScrollListener);
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, 4, paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    paramString = (MQQProfileName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.clone();
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    switch (paramString.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, true, new String[] { "map_key_qzone", "map_key_account_base_info" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.updateHead(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.updateHead(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      a(1);
    }
    label289:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        a(9);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {
          if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))
          {
            a(0);
            this.jdField_b_of_type_Int = 0;
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 105)) {
          break label289;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800716B", "0X800716B", this.jdField_b_of_type_Int, 0, "", "", "", "");
        return;
        a(4);
        break;
        if (((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo) != null)
        {
          this.jdField_b_of_type_Int = 1;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {}
          for (int j = 12;; j = 2)
          {
            a(j);
            break;
          }
        }
        this.jdField_b_of_type_Int = 2;
        a(11);
        continue;
        this.jdField_b_of_type_Int = 3;
        a(10);
      }
    }
    boolean bool4 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    paramBoolean = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 113)
    {
      paramBoolean = false;
      bool1 = false;
    }
    boolean bool2 = bool1;
    boolean bool3 = bool4;
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (!this.h) {
        break label571;
      }
      paramBoolean = false;
      bool2 = false;
    }
    for (bool3 = false;; bool3 = bool4)
    {
      bool1 = bool2;
      if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte.length > 0) {
            bool1 = true;
          }
        }
      }
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramBoolean = false;
      }
      if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean))
      {
        a(12);
        return;
      }
      if ((bool3) && (bool1) && (paramBoolean))
      {
        a(2);
        return;
      }
      if ((bool3) && (bool1))
      {
        a(3);
        return;
      }
      if ((bool1) && (paramBoolean))
      {
        a(4);
        return;
      }
      if ((bool3) && (paramBoolean))
      {
        a(5);
        return;
      }
      if (bool3)
      {
        a(6);
        return;
      }
      if (bool1)
      {
        a(7);
        return;
      }
      if (paramBoolean)
      {
        a(5);
        return;
      }
      a(0);
      return;
      label571:
      paramBoolean = false;
      bool2 = bool1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int k = 1;
    if ((this.app == null) || (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    label317:
    label336:
    label361:
    label362:
    for (;;)
    {
      return;
      if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, String.format("checkAndSwitch2Friend phone: %s, check:%s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Utils.a(paramString) }));
        }
        Message localMessage;
        if (paramBoolean1)
        {
          localObject = a(paramString, a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          localMessage = Message.obtain();
          localMessage.what = 3;
          if (localObject == null) {}
          for (;;)
          {
            localMessage.obj = paramString;
            this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
            return;
            paramString = (String)localObject;
          }
        }
        Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        int j;
        if (!paramBoolean2)
        {
          j = 1;
          if (j != 0) {
            break label361;
          }
          if (localObject != null) {
            break label317;
          }
          paramString = null;
          label236:
          if ((paramString == null) || (!paramString.isFriend())) {
            break label336;
          }
          j = k;
        }
        for (;;)
        {
          label251:
          if (j == 0) {
            break label362;
          }
          if (localObject == null) {}
          for (paramString = null;; paramString = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            localMessage = Message.obtain();
            localMessage.what = 3;
            localObject = paramString;
            if (paramString == null) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            localMessage.obj = localObject;
            this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
            return;
            j = 0;
            break;
            paramString = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            break label236;
            j = 0;
            break label251;
          }
        }
      }
    }
  }
  
  void a(int[] paramArrayOfInt, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2130968636);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 16) {
        localActionSheet.addCancelButton(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((paramArrayOfInt[paramInt] >= 0) && (paramArrayOfInt[paramInt] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localActionSheet.addButton(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]], 1);
        }
      }
    }
    localActionSheet.setOnButtonClickListener(new FriendProfileCardActivity.9(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label496;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label501;
        }
        paramBoolean = true;
        label169:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label220:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label511;
          }
        }
      }
      label496:
      label501:
      label511:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        paramBoolean = false;
        break label169;
        bool1 = false;
        break label220;
      }
      bool2 = false;
    }
  }
  
  boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
          paramBoolean = bool1;
        }
        for (;;)
        {
          return paramBoolean;
          paramBoolean = false;
          break;
        }
      }
      paramBoolean = false;
    }
  }
  
  boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      UinUtils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int + ", entry = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder(300);
          localStringBuilder.append("checkParamValidate, [pa: ").append(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int).append(", uin: ").append(Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          if (ProfileActivity.e(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_discussUin: ").append(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
          }
          if (ProfileActivity.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_troopUin: ").append(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d).append(",  allinone_troopcode: ").append(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString).append(", sub_source_id: ").append(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int).append(", troopUin: ").append(paramProfileCardInfo.jdField_a_of_type_JavaLangString);
          }
          Bundle localBundle = getIntent().getBundleExtra("flc_extra_param");
          if (localBundle != null)
          {
            localStringBuilder.append(", extra_param_troop_code: ").append(localBundle.getString("troop_code"));
            localStringBuilder.append(", extra_param_troop_uin: ").append(localBundle.getString("troop_uin"));
            localStringBuilder.append(", extra_param_notify_type: ").append(localBundle.getInt("flc_notify_type"));
            localStringBuilder.append(", extra_param_recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
          }
          localStringBuilder.append(", reportExtraParam: ").append(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          localStringBuilder.append("]");
          QLog.i("addFriendTag", 2, localStringBuilder.toString());
        }
        return a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramProfileCardInfo) {}
  }
  
  protected void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.setPriority(2147483647);
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localThrowable.toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof VasProfileSimpleView)) {
      ((VasProfileSimpleView)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView).fixBlankHeight();
    }
    for (paramInt = getResources().getDisplayMetrics().heightPixels / 2 + paramInt;; paramInt = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.getHeight() + paramInt)
    {
      paramInt -= getTitleBarHeight();
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("scrollToMoreInfoView offset=%s", new Object[] { Integer.valueOf(paramInt) }));
      }
      if (this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView != null) {
        this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPositionFromTop(0, -paramInt);
      }
      return;
    }
  }
  
  void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label133;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label133:
      a(2131693380, 1);
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnScrollListener);
    }
  }
  
  void b(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) && (!this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(getResources().getString(2131698575));
    String str2 = getString(2131719148);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new FriendProfileCardActivity.20(this, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localObject3 = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localObject3 != null) {
          break label231;
        }
      }
    }
    label231:
    label496:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = ((PhoneContactManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label496;
        }
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if ((!((FriendListHandler)localObject2).isGetOnlineListRecently()) && (!((FriendListHandler)localObject2).shouldGetOnlineInfo())) {
          ((FriendListHandler)localObject2).getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
        localObject2 = ((PhoneContactManager)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((PhoneContactManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).mobileCode;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          localObject2 = localObject1;
          if (!((FriendListHandler)localObject3).shouldGetOnlineInfo())
          {
            ((FriendListHandler)localObject3).getOnlineInfo(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 29));
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) {
      return;
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localRedTouchManager.a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    localRedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
  }
  
  void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          break label191;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label180;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localFriendListHandler == null) {
          break label169;
        }
        localFriendListHandler.setFriendComment(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.jdField_a_of_type_Int |= 0x1;
        a(paramCardContactInfo);
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label169:
      a(2131693407, 1);
      continue;
      label180:
      a(2131693393, 1);
      continue;
      label191:
      a(2131694507, 1);
    }
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localRedTouchManager != null) {
        localRedTouchManager.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("doOnActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt1 == 1022) {
      b(paramIntent);
    }
    label279:
    label296:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    return;
                    if (paramInt1 != 4) {
                      break label296;
                    }
                    if ((paramInt2 == -1) && (paramIntent != null))
                    {
                      if (!paramIntent.hasExtra("result")) {
                        break label279;
                      }
                      paramIntent = paramIntent.getStringExtra("result");
                      if (QLog.isColorLevel()) {
                        QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + paramIntent);
                      }
                      if (!TextUtils.isEmpty(paramIntent)) {
                        try
                        {
                          paramIntent = new JSONObject(paramIntent);
                          if (paramIntent != null)
                          {
                            paramIntent = paramIntent.get("payState");
                            if ((paramIntent != null) && ("0".equals(String.valueOf(paramIntent))))
                            {
                              a(0L, null, null, false);
                              return;
                            }
                          }
                        }
                        catch (JSONException paramIntent)
                        {
                          paramIntent.printStackTrace();
                          if (QLog.isColorLevel())
                          {
                            QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
                            return;
                          }
                        }
                        catch (Exception paramIntent)
                        {
                          paramIntent.printStackTrace();
                        }
                      }
                    }
                  }
                } while (!QLog.isColorLevel());
                QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
                return;
              } while (!QLog.isColorLevel());
              QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
              return;
              if (paramInt1 != 1010) {
                break;
              }
            } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101) || (paramInt2 != -1));
            finish();
            return;
            if (paramInt1 != 1035) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.a(paramInt2, paramIntent);
          return;
        } while (paramInt2 != -1);
        switch (paramInt1)
        {
        default: 
          return;
        case 5: 
          paramIntent = ImageUtil.b(this, this.jdField_a_of_type_AndroidNetUri);
          paramInt1 = ProfileCardUtil.b(this);
          localObject = new Intent();
          ((Intent)localObject).putExtra("Business_Origin", 100);
          PhotoUtils.startPhotoEdit((Intent)localObject, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, FaceUtil.a());
          return;
        }
      } while (paramIntent == null);
      if (paramIntent.getBooleanExtra("finchat", false)) {
        finish();
      }
      for (;;)
      {
        b(paramIntent);
        return;
        localObject = paramIntent.getStringExtra("remark");
        if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, localObject)) {
          a((String)localObject);
        }
      }
      setResult(-1);
      finish();
      return;
      paramIntent = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentAccountUin());
    } while ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null));
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, true, new String[] { "map_key_tag" });
    return;
    paramIntent = new Intent(this, FriendProfileCardActivity.class);
    paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
    paramIntent.putExtra("diyTextEditResult", true);
    startActivity(paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(new ColorDrawable(-1));
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil("FriendProfileCardActivity");
    Intent localIntent = getIntent();
    if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())) || (localIntent == null))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 1.");
      finish();
      return false;
    }
    ProfileActivity.AllInOne localAllInOne = a(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper = new ProfileConfigHelper(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper;
    this.h = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("key_from_extends_friend", false);
    this.f = localIntent.getBooleanExtra("key_from_extends_friend_limit_chat", false);
    if (!a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 2.");
      finish();
      return false;
    }
    if (a(localIntent, localAllInOne))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate jump to other.");
      return false;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    n();
    m();
    s();
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    try
    {
      b(false);
      if (ClubContentJsonTask.a == null) {
        ThreadManager.excute(new FriendProfileCardActivity.2(this), 16, null, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
      ThreadManager.excute(new FriendProfileCardActivity.3(this), 16, null, true);
      e();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        a();
      }
      for (;;)
      {
        g();
        o();
        c(getIntent());
        t();
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onCreate(this, paramBundle);
        }
        return true;
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      return false;
    }
    catch (Exception paramBundle)
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate fail.", paramBundle);
      finish();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a();
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      if (this.app != null) {
        this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      if (this.app != null)
      {
        IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
        if (localIVasQuickUpdateService != null) {
          localIVasQuickUpdateService.removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
        }
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard))) {
        QLog.i("FriendProfileCardActivity", 1, "FriendProfileCardActivity.onDestroy()");
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
        ProfileCardUtil.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.f();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onDestroy();
      }
      w();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onNewIntent(paramIntent);
    }
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
        doOnActivityResult(1000, -1, paramIntent);
      }
      ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
      if ((localAllInOne != null) && (localAllInOne.jdField_h_of_type_Int == 115))
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
        a(0L, null, null, false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager == null) {
        c(paramIntent);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.b(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onPause();
    }
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onResume();
    }
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    c();
    k();
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 115) && (AddFriendLogicActivity.jdField_b_of_type_Boolean)) {
      b(getIntent().getStringExtra("src_name"));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onStop();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("doOnWindowFocusChanged", false);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer != null)
      {
        ProfileCmShowComponent localProfileCmShowComponent = (ProfileCmShowComponent)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileFgContainer.getComponent(1020);
        if (localProfileCmShowComponent != null) {
          localProfileCmShowComponent.onWindowFocusGained();
        }
      }
    }
  }
  
  @TargetApi(11)
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initInfoCardCommonLayoutStart", true);
    this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2131561537, null);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365157));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131365434);
    this.jdField_c_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131374762);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561489, null);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369057);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
      label172:
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369071));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.app, this, this.h, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_b_of_type_Boolean = this.jdField_e_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_c_of_type_Boolean = this.f;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366595));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131380240));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131364192));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new XSimpleListAdapter(null));
      localObject = new FriendProfileCardActivity.ProfileTopGestureLayout(this, this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setOnFlingGesture(this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).addView(this.jdField_d_of_type_AndroidViewView);
      setContentView((View)localObject);
      localObject = (FrameLayout)findViewById(16908290);
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundResource(2130846077);
      }
      if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        localObject = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(10);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject, 10000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initInfoCardCommonLayoutEnd", "initInfoCardCommonLayoutStart", false);
      return;
    }
    catch (Exception localException)
    {
      break label172;
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
    {
      q();
      return;
    }
    if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      ExtendFriendSendMsgHelper.a(this.app).a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, new FriendProfileCardActivity.14(this));
      return;
    }
    b(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof VasProfilePhotoView))
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.getChildView("map_key_qzonecover");
      if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).jdField_a_of_type_Boolean)) {
        return;
      }
    }
    onBackPressed();
  }
  
  public void flingRToL() {}
  
  void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
      startUnlockActivity();
    }
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.jdField_a_of_type_JavaLangClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.jdField_a_of_type_JavaLangClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
  }
  
  public int getTitleBarHeight()
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    }
    return j;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369079).setVisibility(8);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369079).setVisibility(0);
    }
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.intercept(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPosition(0);
  }
  
  void k()
  {
    ThreadManager.post(new FriendProfileCardActivity.19(this), 5, null, false);
  }
  
  public void l()
  {
    try
    {
      ProfileCardUtils.openProfileEdit(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      ReportController.b(this.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
      ProfileCardReport.reportProfileEditClick(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "forward2ProfileEdit fail.", localException);
      }
    }
  }
  
  public void m()
  {
    ThreadManager.post(new FriendProfileCardActivity.21(this), 5, null, false);
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseFrameworkIComponentCenter.onBackPressed()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "onBackEvent event cost by component");
      }
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.c();
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity onRestart");
    }
    super.onRestart();
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil();
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    a(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */