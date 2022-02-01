package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TroopUrlConfBean;
import com.tencent.mobileqq.config.business.TroopUrlConfProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansInfo.IdolItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.associations.TroopAssociationsEntryConfig;
import com.tencent.mobileqq.troop.associations.TroopAssociationsUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfoData;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.RobotMemberFormItem;
import com.tencent.mobileqq.troop.widget.RoundedBackgroundSpan;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.troopkeyword.EntryStatus;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, DecodeTaskCompletionListener, HttpWebCgiAsyncTask.Callback
{
  public static final ArrayList<Integer> a;
  public static String l;
  protected final int a;
  long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  protected BroadcastReceiver a;
  public Intent a;
  protected Drawable a;
  protected Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new ChatSettingForTroop.12(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new UITools.MyViewAlphaOnTouchListener();
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected OpenIdObserver a;
  protected TroopCardAppInfoHelper.IGetAppInfoCB a;
  protected TroopCardAppInfoHelper a;
  protected ChatSettingForTroop.ListAdapter a;
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver = new ChatSettingForTroop.59(this);
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ChatSettingForTroop.49(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ChatSettingForTroop.34(this);
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ChatSettingForTroop.30(this);
  protected TroopManager a;
  protected IFaceDecoder a;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new ChatSettingForTroop.33(this);
  public TroopUrlConfBean a;
  protected TroopInfo a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new ChatSettingForTroop.29(this);
  private RobotMemberFormItem jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView;
  protected GroupCatalogBean a;
  protected TroopInfoData a;
  protected TroopShareUtility a;
  protected QQCustomDialog a;
  protected RoamSettingController a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  protected MyGridView a;
  protected QQBlurView a;
  protected QQProgressDialog a;
  protected QQProgressNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected ImmersiveTitleBar2 a;
  protected Runnable a;
  protected String a;
  protected List<Integer> a;
  protected boolean a;
  protected View[] a;
  protected int b;
  protected Handler b;
  protected View.OnClickListener b;
  protected View b;
  protected Button b;
  protected ImageView b;
  protected TextView b;
  TroopBusinessObserver jdField_b_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ChatSettingForTroop.31(this);
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected Runnable b;
  protected String b;
  protected ArrayList<TroopAppInfo> b;
  List<ImageView> jdField_b_of_type_JavaUtilList;
  protected volatile boolean b;
  protected int c;
  protected View c;
  public TextView c;
  TroopBusinessObserver jdField_c_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ChatSettingForTroop.32(this);
  protected String c;
  private ArrayList<Long> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<oidb_0x899.memberlist> c;
  protected boolean c;
  protected int d;
  protected View d;
  public TextView d;
  private TroopBusinessObserver jdField_d_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ChatSettingForTroop.1(this);
  String jdField_d_of_type_JavaLangString;
  protected List<Long> d;
  protected boolean d;
  protected int e;
  String jdField_e_of_type_JavaLangString;
  protected List<oidb_0x899.memberlist> e;
  boolean jdField_e_of_type_Boolean = false;
  protected int f;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  protected int g;
  String g;
  protected boolean g;
  protected int h;
  String h;
  protected boolean h;
  protected int i;
  String i;
  protected boolean i;
  protected int j;
  String j;
  protected boolean j;
  protected int k;
  String k;
  protected boolean k;
  private int l;
  public boolean l;
  private String m;
  protected boolean m;
  protected boolean n = false;
  private boolean o = false;
  private boolean p;
  private boolean q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u;
  private boolean v = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131380036));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131380037));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131380038));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131380039));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131380040));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131380041));
    jdField_l_of_type_JavaLangString = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 5;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = null;
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = 2;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ChatSettingForTroop.4(this);
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangRunnable = new ChatSettingForTroop.13(this);
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new ChatSettingForTroop.19(this);
    this.jdField_b_of_type_JavaLangRunnable = new ChatSettingForTroop.22(this);
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new ChatSettingForTroop.28(this);
    this.jdField_m_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ChatSettingForTroop.50(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new ChatSettingForTroop.55(this);
  }
  
  private void A()
  {
    b(getResources().getString(2131699447));
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      localObject1 = new FormSimpleItem(this);
      a(1006, 1, (FormSimpleItem)localObject1, HardCodeUtil.a(2131701836), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    }
    for (int i1 = 1;; i1 = 0)
    {
      localObject1 = new FormSimpleItem(this);
      Object localObject2;
      if (i1 != 0)
      {
        i1 = 2;
        a(1001, i1, (FormSimpleItem)localObject1, getString(2131696090), HardCodeUtil.a(2131701801), true);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        TroopReportor.a("Grp_set_new", "grpData_admin", "chatRecord_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        localObject1 = new FormSwitchItem(this, null);
        ((FormSwitchItem)localObject1).setBgType(2);
        ((FormSwitchItem)localObject1).setText(getString(2131693109));
        ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167033));
        ((FormSwitchItem)localObject1).setFocusable(true);
        ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
        ((FormSwitchItem)localObject1).setContentDescription(getString(2131693109));
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
        localObject2 = ((FormSwitchItem)localObject1).a();
        if (!((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
          break label640;
        }
        ((Switch)localObject2).setChecked(true);
        label285:
        ((Switch)localObject2).setTag(Integer.valueOf(7));
        ((Switch)localObject2).setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        localObject1 = new FormSwitchItem(this, null);
        ((FormSwitchItem)localObject1).setBackgroundResource(2130839585);
        ((FormSwitchItem)localObject1).setBgType(2);
        ((FormSwitchItem)localObject1).setText(getString(2131693110));
        ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167033));
        ((FormSwitchItem)localObject1).setFocusable(true);
        ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
        ((FormSwitchItem)localObject1).setContentDescription(getString(2131693110));
        this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
        localObject2 = ((FormSwitchItem)localObject1).a();
        ((Switch)localObject2).setTag(Boolean.FALSE);
        i1 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask = i1;
        }
        if (i1 == 1) {
          break label649;
        }
      }
      label640:
      label649:
      for (boolean bool = true;; bool = false)
      {
        ((Switch)localObject2).setChecked(bool);
        ((Switch)localObject2).setOnCheckedChangeListener(new ChatSettingForTroop.8(this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        localObject1 = View.inflate(this, 2131561704, null);
        localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131369444);
        a(9, 0, (FormSimpleItem)localObject2, getString(2131720069), "", true);
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(17.0F, getResources()), AIOUtils.a(17.0F, getResources()));
        localLayoutParams.rightMargin = AIOUtils.a(30.0F, getResources());
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(15);
        ((FormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839545));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        return;
        i1 = 1;
        break;
        ((Switch)localObject2).setChecked(false);
        break label285;
      }
    }
  }
  
  private void B()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {}
    Object localObject;
    int i1;
    label136:
    boolean bool;
    label241:
    do
    {
      return;
      b(getResources().getString(2131699449));
      FormItemRelativeLayout localFormItemRelativeLayout = (FormItemRelativeLayout)View.inflate(this, 2131561707, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localFormItemRelativeLayout;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormItemRelativeLayout);
      a(localFormItemRelativeLayout, null);
      localFormItemRelativeLayout.setTag(Integer.valueOf(5));
      localFormItemRelativeLayout.setBGType(1);
      localFormItemRelativeLayout.setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break;
      }
      localObject = HardCodeUtil.a(2131701787);
      a(5, 3, localFormItemRelativeLayout, getString(2131720169), (CharSequence)localObject, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
        break label520;
      }
      i1 = 0;
      localFormItemRelativeLayout.setVisibility(i1);
      if (i1 == 0) {
        TroopReportor.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      TextView localTextView = (TextView)localFormItemRelativeLayout.findViewById(2131377063);
      localTextView.setText((CharSequence)localObject);
      b(localFormItemRelativeLayout);
      this.q = TroopUtils.b("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        break label526;
      }
      bool = false;
      this.p = TroopUtils.b(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
      TroopUtils.a(TroopUtils.a(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.p, this.q, localTextView);
      localObject = (TroopPluginManager)this.app.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
      if (localObject != null) {
        this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject).a("troop_manage_plugin.apk", new ChatSettingForTroop.9(this));
      }
      if (!RobotUtils.a(this.app)) {
        break label569;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem = new RobotMemberFormItem(this, getString(2131720267));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem.a().setBackgroundResource(2130839582);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem.a();
    } while (localObject == null);
    if (RobotUtils.c(this.app)) {
      this.o = RobotUtils.b(this.app);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.o);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem.a(this.o);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      ((View)localObject).setOnClickListener(this);
      ((View)localObject).setTag(Integer.valueOf(1009));
      ReportController.b(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
      return;
      localObject = HardCodeUtil.a(2131701794);
      break;
      label520:
      i1 = 8;
      break label136;
      label526:
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();
      break label241;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        this.o = RobotUtils.b(this.app);
      } else {
        this.o = false;
      }
    }
    label569:
    QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
  }
  
  private void C()
  {
    b(getResources().getString(2131699448));
    Object localObject = View.inflate(this, 2131561707, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(14));
    a(14, 2, (View)localObject, getString(2131691870), "", true);
    e();
    b((View)localObject);
    localObject = View.inflate(this, 2131561707, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(25));
    a(25, 2, (View)localObject, getString(2131699363), "", true);
    boolean bool;
    FormSimpleItem localFormSimpleItem;
    String str;
    if (!this.jdField_d_of_type_Boolean)
    {
      bool = true;
      a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
      b((View)localObject);
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      localObject = View.inflate(this, 2131561707, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      a((View)localObject, null);
      a(4, 2, (View)localObject, getString(2131699409), "", true);
      ((View)localObject).setTag(Integer.valueOf(4));
      ((View)localObject).setOnClickListener(this);
      localFormSimpleItem = new FormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localFormSimpleItem;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSimpleItem);
      str = getString(2131694418);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
        break label405;
      }
    }
    label405:
    for (localObject = getString(2131697574);; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)
    {
      a(6, 3, localFormSimpleItem, str, (CharSequence)localObject, true);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
      {
        localObject = new ColorNickText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
        localFormSimpleItem.setRightText((CharSequence)localObject);
        ColorNickManager.a(this.app, localFormSimpleItem.a(), (Spannable)localObject);
      }
      if (localFormSimpleItem.a() != null) {
        localFormSimpleItem.a().setCompoundDrawablePadding(ViewUtils.b(9.0F));
      }
      O();
      return;
      bool = false;
      break;
    }
  }
  
  private void D()
  {
    View localView = View.inflate(this, 2131559988, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localView;
    localView.getBackground().setAlpha(255);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.setVisibility(8);
  }
  
  private void E()
  {
    View localView = View.inflate(this, 2131561715, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localView;
    localView.setTag(Integer.valueOf(0));
    localView.setBackgroundResource(2130839585);
    localView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371122));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701809) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + HardCodeUtil.a(2131701817));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.a(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
    }
    a(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131371120));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
    G();
    localView = View.inflate(this, 2131561722, null);
    localView.setBackgroundResource(2130851165);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
  }
  
  private void F()
  {
    new QueryTask(new ChatSettingForTroop.10(this), new ChatSettingForTroop.11(this)).a(null);
  }
  
  private void G()
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i2 = (int)(24.0F * f1);
    int i3 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    i1 = (i1 - i2) / ((int)(50.0F * f1) + i3);
    i2 = (int)(10.0F * f1);
    this.jdField_c_of_type_Int = i2;
    this.jdField_d_of_type_Int = i2;
    this.jdField_e_of_type_Int = ((int)(5.0F * f1));
    this.jdField_f_of_type_Int = ((int)(f1 * 17.0F));
    this.jdField_g_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
  }
  
  private void H()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[26];
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label116;
      }
      SpannableString localSpannableString = new SpannableString("[Avatar]");
      Drawable localDrawable = a();
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(localView, localSpannableString, null, null);
      }
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[35];
      if (localView != null) {
        ((ImageView)localView).setImageDrawable(a());
      }
      return;
      label116:
      a(localView, null, null, HardCodeUtil.a(2131701830));
    }
  }
  
  private void I()
  {
    byte[] arrayOfByte = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        return;
      }
    }
    QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop quitTroop mTroopInfoData.bOwner = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null)
      {
        localObject = null;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label184;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && (this.jdField_i_of_type_Int == 0)) {
        break label177;
      }
      K();
      label108:
      localObject = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label235;
      }
      localObject = "0";
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject, "", "");
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label177:
      L();
      break label108;
      label184:
      localObject = ActionSheet.create(this);
      ((ActionSheet)localObject).setMainTitle(2131691156);
      ((ActionSheet)localObject).addButton(2131692161, 3);
      ((ActionSheet)localObject).setOnButtonClickListener(new ChatSettingForTroop.15(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).addCancelButton(getString(2131690800));
      ((ActionSheet)localObject).show();
      break label108;
      label235:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject = "1";
      }
    }
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
    localReportDialog.setContentView(2131561170);
    ((TextView)localReportDialog.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365832);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365830);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365836);
    String str = HardCodeUtil.a(2131701805);
    localTextView1.setText(getString(2131691151, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694615);
    localTextView3.setText(2131690800);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ChatSettingForTroop.16(this, localReportDialog));
    localTextView3.setOnClickListener(new ChatSettingForTroop.17(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131691833);
    String str = getString(2131691150);
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131691149), 3);
    localActionSheet.addCancelButton(getString(2131690800));
    localActionSheet.setOnButtonClickListener(new ChatSettingForTroop.18(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void M()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null) {
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true, 1);
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB);
  }
  
  private void N()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void O()
  {
    Object localObject = View.inflate(this, 2131561722, null);
    ((View)localObject).setBackgroundResource(2130851165);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298624);
    localObject = View.inflate(this, 2131561707, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[50] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(50));
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {}
    for (localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark;; localObject = "")
    {
      c((String)localObject);
      ReportController.b(this.app, "dc00899", "Grp_set_new", "", "groupnameRemarks", "entrance_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      return;
    }
  }
  
  private void P()
  {
    Object localObject = (TroopFansEntryConfig)QConfigManager.a().a(701);
    int i1;
    if ((localObject != null) && (((TroopFansEntryConfig)localObject).isGroupEntranceSwitchOn()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isFansTroop()))
    {
      i1 = 1;
      if (i1 != 0)
      {
        localObject = View.inflate(this, 2131561722, null);
        ((View)localObject).setBackgroundResource(2130851165);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298624);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localObject = View.inflate(this, 2131561707, null);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId() != 0) {
            break label178;
          }
          this.jdField_a_of_type_ArrayOfAndroidViewView[45] = localObject;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          ((View)localObject).setTag(Integer.valueOf(45));
          e((View)localObject);
        }
      }
    }
    for (;;)
    {
      b((View)localObject);
      ReportController.b(this.app, "dc00898", "", "", "0X800B595", "0X800B595", 0, 0, "", "", "", "");
      return;
      i1 = 0;
      break;
      label178:
      this.jdField_a_of_type_ArrayOfAndroidViewView[46] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      ((View)localObject).setTag(Integer.valueOf(46));
      ((View)localObject).setVisibility(8);
      Q();
    }
  }
  
  private void Q()
  {
    TroopFansInfo.IdolItem localIdolItem = ((TroopInfoManager)this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localIdolItem != null) {
      a(localIdolItem.name, localIdolItem.rank);
    }
  }
  
  private void R()
  {
    Object localObject = (TroopFansEntryConfig)QConfigManager.a().a(701);
    if ((localObject == null) || (!((TroopFansEntryConfig)localObject).isGroupEntranceSwitchOn())) {}
    View localView;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isFansTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId() == 0)) {
          break;
        }
        localObject = (BizTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      } while (localObject == null);
      ((BizTroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      return;
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[45];
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[46];
    } while ((localObject == null) && (localView == null));
    if (localObject != null) {}
    for (;;)
    {
      e((View)localObject);
      return;
      localObject = localView;
    }
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.setMainTitle(getString(2131719761, new Object[] { localObject }));
      localActionSheet.addRadioButton(getString(2131697651), false);
      localActionSheet.addRadioButton(getString(2131697647), false);
      localActionSheet.addRadioButton(getString(2131697643), false);
      int i1 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new ChatSettingForTroop.23(this, i1, localActionSheet));
        localActionSheet.show();
        return;
        continue;
        localActionSheet.setRadioButtonChecked(0);
        continue;
        localActionSheet.setRadioButtonChecked(1);
        continue;
        localActionSheet.setRadioButtonChecked(2);
      }
    }
  }
  
  private void T()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.f();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.d("Q.chatopttroop", 1, "gotoTroopQRCodeActivity NullPointerException ", localNullPointerException);
    }
  }
  
  private void U()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label24:
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void V()
  {
    U();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131697632));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131697631), new ChatSettingForTroop.27(this));
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void W()
  {
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), "8.5.5" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)))
    {
      V();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTroopUrlConfBean;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = TroopUrlConfProcessor.a();
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTroopUrlConfBean = ((TroopUrlConfBean)localObject1);
    }
    localObject1 = ((TroopUrlConfBean)localObject1).jdField_a_of_type_JavaLangString;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", TroopUtils.a((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, true));
    ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
    ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult((Intent)localObject2, 17);
  }
  
  private void X()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    if (localView != null)
    {
      localView.setOnTouchListener(null);
      localView.setOnClickListener(null);
    }
  }
  
  private void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "showNotSearchableActionSheet");
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    if (bool)
    {
      i1 = 2131693099;
      localActionSheet.setMainTitle(getString(i1));
      if (!bool) {
        break label115;
      }
    }
    label115:
    for (int i1 = 2131693096;; i1 = 2131693097)
    {
      localActionSheet.addButton(i1);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ChatSettingForTroop.43(this, localActionSheet));
      localActionSheet.setOnBottomCancelListener(new ChatSettingForTroop.44(this, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      return;
      i1 = 2131693098;
      break;
    }
  }
  
  private void Z()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "gotoSettingOrShare ,isOwnerOrAdmin = " + bool);
    }
    if (bool)
    {
      Bundle localBundle = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      localBundle.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt);
      localBundle.putString("leftViewText", getString(2131720207));
      localBundle.putInt("troop_auth_submit_time", this.jdField_i_of_type_Int);
      localBundle.putInt("PARAM_EXIT_ANIMATION", 1);
      localBundle.putBoolean(TroopInfoActivity.jdField_c_of_type_JavaLangString, true);
      TroopInfoActivity.a(this, localBundle);
      overridePendingTransition(2130771981, 2130771982);
      return;
    }
    T();
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ImageUtil.c();
    }
    return new BitmapDrawable((Bitmap)localObject2);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131720185);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131720190);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131720192);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131720187);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131720186);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop()))
    {
      localObject = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i1 = 1;; i1 = 0)
    {
      ((TroopHandler)localObject).b(str, paramInt, i1);
      localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[31];
      if (localObject != null) {
        ((FormSwitchItem)localObject).a().setClickable(false);
      }
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692534));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131696046));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363778);
    paramView = (TextView)paramView.findViewById(2131377063);
    if (TextUtils.isEmpty(paramCharSequence1)) {
      if (TextUtils.isEmpty(paramCharSequence3)) {
        paramView.setVisibility(8);
      }
    }
    while (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence3);
      continue;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence1);
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  private void a(View paramView, String paramString)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363778);
    paramView = (TextView)paramView.findViewById(2131377063);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131697633));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[45];
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[46];
    if ((localObject1 == null) && (localObject2 == null)) {
      return;
    }
    if (localObject1 != null) {}
    TextView localTextView;
    for (;;)
    {
      localObject2 = (TextView)((View)localObject1).findViewById(2131363778);
      localTextView = (TextView)((View)localObject1).findViewById(2131377063);
      ((View)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      TroopUtils.a(false, localTextView);
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      e((View)localObject1);
      return;
      localObject1 = localObject2;
    }
    localObject2 = getString(2131699456);
    if ((paramLong > 0L) && (paramLong <= 50L)) {
      localObject2 = String.format(getString(2131699431), new Object[] { Long.valueOf(paramLong) });
    }
    for (;;)
    {
      a(46, 3, (View)localObject1, paramString, "", true);
      localTextView.setText((CharSequence)localObject2);
      b((View)localObject1);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopRemarkEditFragment.jdField_a_of_type_JavaLangString, paramString1);
    localIntent.putExtra(TroopRemarkEditFragment.jdField_c_of_type_JavaLangString, paramString3);
    localIntent.putExtra(TroopRemarkEditFragment.jdField_b_of_type_JavaLangString, paramString2);
    if (!TextUtils.isEmpty(paramString4)) {
      localIntent.putExtra(TroopRemarkEditFragment.jdField_d_of_type_JavaLangString, paramString4);
    }
    PublicFragmentActivity.a(this, localIntent, TroopRemarkEditFragment.class, 20);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateUinQREntry isShowUin = " + paramBoolean1 + ",showUinLockIcon = " + paramBoolean2);
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[25];; localView = null)
    {
      Object localObject2;
      Object localObject1;
      if (localView != null)
      {
        localObject2 = "";
        localObject1 = localObject2;
        if (paramBoolean1)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label588;
        }
        localObject1 = " ";
      }
      label561:
      label583:
      label588:
      for (;;)
      {
        localView.setVisibility(0);
        int i1;
        if (paramBoolean1) {
          i1 = 2131699362;
        }
        for (;;)
        {
          a(25, 2, localView, getString(i1), "", true);
          localObject2 = new SpannableString((String)localObject1 + "PT[QR]");
          a(paramBoolean1, paramBoolean2, (String)localObject1, (SpannableString)localObject2);
          a(paramBoolean1, paramBoolean2, localView);
          Object localObject3 = getResources().getDrawable(2130844087);
          ((Drawable)localObject3).setBounds(0, 0, ScreenUtil.dip2px(18.0F), ScreenUtil.dip2px(18.0F));
          if (ThemeUtil.isInNightMode(this.app)) {
            ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
          localObject3 = new ChatSettingForTroop.38(this, (Drawable)localObject3, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            QLog.e("vip_pretty.Q.chatopttroop", 1, "show the pretty troop icon :" + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.groupFlagExt4);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(1)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFreezeReason(2)))
            {
              i1 = 1;
              label334:
              if (i1 == 0) {
                break label561;
              }
              Drawable localDrawable = getResources().getDrawable(2130847296);
              localDrawable.setBounds(0, 0, ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(15.0F));
              ((SpannableString)localObject2).setSpan(new ChatSettingForTroop.39(this, localDrawable, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
              ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
            }
          }
          for (;;)
          {
            paramBoolean1 = bool;
            if (!" ".equals(localObject1))
            {
              paramBoolean1 = bool;
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) {
                paramBoolean1 = true;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "updateUinQREntry troopNameAndQr = " + localObject2);
            }
            TroopUtils.a(localView, (CharSequence)localObject2, null, null, paramBoolean1, (String)localObject1, HardCodeUtil.a(2131691375), new ChatSettingForTroop.40(this));
            localView.setOnClickListener(this);
            return;
            if (paramBoolean1) {
              break label583;
            }
            i1 = 2131699363;
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(2))
            {
              i1 = 1;
              break label334;
              QLog.e("vip_pretty.Q.chatopttroop", 1, "not show the pretty troop icon");
            }
            i1 = 0;
            break label334;
            ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
          }
          i1 = 0;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramView = (TextView)paramView.findViewById(2131377063);
      paramView.setOnClickListener(new ChatSettingForTroop.41(this));
      paramView.setOnLongClickListener(new ChatSettingForTroop.42(this));
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "appendRoundBgAndLockIcon isShowUin = " + paramBoolean1 + ",showUinLockIcon = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      RoundedBackgroundSpan localRoundedBackgroundSpan = new RoundedBackgroundSpan(-1315339, -7894119, ViewUtils.a(3.0F), ViewUtils.a(21.0F), ViewUtils.a(6.0F));
      localRoundedBackgroundSpan.a(getResources().getDrawable(2130844094), ViewUtils.a(16.0F), ViewUtils.a(16.0F), ViewUtils.a(4.0F));
      paramSpannableString.setSpan(localRoundedBackgroundSpan, 0, paramString.length(), 33);
    }
  }
  
  private boolean a(long paramLong, TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return false;
    }
    if (paramLong == 101761547L)
    {
      ListenTogetherUtils.b(this.app, getApplicationContext(), 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      return true;
    }
    Object localObject;
    if (paramLong == 101847770L)
    {
      localObject = TroopMemberListActivity.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
      ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", paramTroopInfo.wMemberNum);
      startActivity((Intent)localObject);
      return true;
    }
    if (paramLong == 101872203L)
    {
      if (AvGameEntranceUtil.a((BaseActivity)getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        return true;
      }
      localObject = (AvGameManager)this.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localObject != null) {
        ((AvGameManager)localObject).a(getActivity(), 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      }
      if ((localObject != null) && (((AvGameManager)localObject).a())) {}
      for (int i1 = 1;; i1 = 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B4E3", "0X800B4E3", i1, 0, "", "", paramTroopInfo.troopuin, "");
        return true;
      }
    }
    return false;
  }
  
  private void aa()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[33];
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      localObject2 = TroopUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        localObject1 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      ((ExpandableTextView)localView).setText(new QQText((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label156;
      }
    }
    label156:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; localObject1 = getString(2131696129))
    {
      ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 11, 16));
      return;
    }
  }
  
  private void ab()
  {
    o();
    ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, null);
  }
  
  private void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.v) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (!this.v) {
      this.v = true;
    }
    if ((this.v) || (bool)) {}
    for (int i1 = 2131167030;; i1 = 2131166726)
    {
      int i3 = getResources().getColor(i1);
      int i2 = 2130847077;
      i1 = i2;
      if (this.v)
      {
        i1 = i2;
        if (!bool) {
          i1 = 2130847074;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130851150);
      localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(i3);
      e(this.v);
      return;
    }
  }
  
  private void ad()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131374172);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void ae()
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidViewView == null) || (this.jdField_a_of_type_ArrayOfAndroidViewView.length <= 0)) {}
    for (;;)
    {
      return;
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
      if (localView != null)
      {
        Object localObject1 = null;
        int i1 = 0;
        while (i1 <= 7)
        {
          switch (i1)
          {
          default: 
            if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
              break label382;
            }
            Object localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof oidb_0xe83.AppInfo))) {
              break label382;
            }
            localObject2 = (oidb_0xe83.AppInfo)localObject2;
            long l1 = -1000L;
            int i2 = -1000;
            if (((oidb_0xe83.AppInfo)localObject2).push_red_point.has()) {
              i2 = ((oidb_0xe83.AppInfo)localObject2).push_red_point.get();
            }
            if (((oidb_0xe83.AppInfo)localObject2).appid.has()) {
              l1 = ((oidb_0xe83.AppInfo)localObject2).appid.get();
            }
            if (l1 != 1L) {
              break label382;
            }
            boolean bool = DBUtils.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
            if ((i2 != -1) && (!bool)) {
              break;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131362907);
            if (i1 == 0) {
              break label374;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText("");
            ((TextView)localObject1).setBackgroundResource(0);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130850830, 0, 0, 0);
            return;
            localObject1 = localView.findViewById(2131379822);
            break;
            localObject1 = localView.findViewById(2131379823);
            break;
            localObject1 = localView.findViewById(2131379824);
            break;
            localObject1 = localView.findViewById(2131379825);
            break;
            localObject1 = localView.findViewById(2131379826);
            break;
            localObject1 = localView.findViewById(2131379827);
            break;
            localObject1 = localView.findViewById(2131379828);
            break;
            localObject1 = localView.findViewById(2131379829);
            break;
          }
          label374:
          ((TextView)localObject1).setVisibility(8);
          return;
          label382:
          i1 += 1;
        }
      }
    }
  }
  
  private void af()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.u)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.u = false;
    }
    setResult(-1, localIntent1);
  }
  
  private void ag()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[47];
    if (localFormSwitchItem == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled();
      localFormSwitchItem.setChecked(bool);
      localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    } while (localFormSwitchItem == null);
    if (bool)
    {
      localFormSwitchItem.setVisibility(0);
      ah();
      return;
    }
    localFormSwitchItem.setVisibility(8);
  }
  
  private void ah()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localFormSwitchItem == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    localFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isShowMyGameCardEnabled());
  }
  
  private void ai()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("Change_Game_Card_Switch_Tips_Value", false))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131697405), getString(2131697404), 2131690800, 2131697403, new ChatSettingForTroop.52(this), null);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ChatSettingForTroop.53(this));
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      localSharedPreferences.edit().putBoolean("Change_Game_Card_Switch_Tips_Value", true).apply();
    }
  }
  
  private void aj()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    View localView;
    do
    {
      do
      {
        return;
        i1 = -1;
        if (this.jdField_c_of_type_JavaLangString.equals("wangzhe"))
        {
          TroopReportor.a("Grp_AIO", "AIO_clk", "game_on_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          i1 = 48;
        }
      } while ((i1 < 0) || (i1 >= 51));
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i1];
    } while ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (localView == null) || (localView.getVisibility() != 0));
    int i1 = localView.getTop();
    int i2 = localView.getHeight();
    this.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollBy(i1 - i2, 1000);
  }
  
  private void ak()
  {
    boolean bool = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void al()
  {
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[31];
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (localObject != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.showGameSwitchStatus != 1) {
        break label82;
      }
      ((FormSwitchItem)localObject).setVisibility(0);
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.gameSwitchStatus != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
      ((Switch)localObject).setClickable(true);
      return;
    }
    label82:
    ((FormSwitchItem)localObject).setVisibility(8);
  }
  
  private void am()
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    long l1;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cmdUinFlagEx2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("mTroopInfo.mask=");
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          break label173;
        }
      }
    }
    label173:
    for (localObject = "no troopInfo";; localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cmdUinFlagEx2 + "")
    {
      QLog.d("Q.chatopttroop", 2, (String)localObject);
      boolean bool = TroopInfo.isCmdUinFlagEx2Open(l1, 512);
      localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10];
      if (localObject != null)
      {
        localObject = ((FormSwitchItem)localObject).a();
        ((Switch)localObject).setOnCheckedChangeListener(null);
        ((Switch)localObject).setChecked(bool);
        an();
        ((Switch)localObject).setOnCheckedChangeListener(this);
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      break;
    }
  }
  
  private void an()
  {
    int i2 = 0;
    boolean bool1 = ((FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10]).a();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
    if (!bool1)
    {
      i1 = 0;
      ((View)localObject).setVisibility(i1);
      if (!bool1) {
        TroopReportor.a("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((localObject instanceof FormSwitchItem)))
      {
        boolean bool2 = ((FormSwitchItem)localObject).a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if ((bool1) || (bool2)) {
          break label124;
        }
      }
    }
    label124:
    for (int i1 = i2;; i1 = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  private void ao()
  {
    boolean bool = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131696194));
    }
  }
  
  private void ap()
  {
    int i2 = 0;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    e();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    if ((bool) && (this.jdField_b_of_type_Boolean)) {}
    for (int i1 = 0;; i1 = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
      localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject != null)
      {
        if (i1 == 0) {
          i2 = 3;
        }
        ((FormSimpleItem)localObject).setBgType(i2);
      }
      return;
    }
  }
  
  private void b(int paramInt)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694459, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.b.clear();
    this.app.setTroopMsgFilterToServer(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.r)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.r = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        DialogUtil.a(this, getString(2131697642), 2131719347, 2131719347, new DialogUtil.DialogOnClickAdapter(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  private void b(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setFocusable(true);
    localTextView.setText(paramString);
    localTextView.setPadding(ViewUtils.a(16.0F), 0, ViewUtils.a(16.0F), 0);
    localTextView.setTextAppearance(this, 2131756000);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.topMargin = ViewUtils.b(14.0F);
    paramString.bottomMargin = ViewUtils.b(4.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, paramString);
  }
  
  private void b(List<oidb_0x899.memberlist> paramList)
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    ArrayList localArrayList1 = new ArrayList();
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject;
      } else if (localTroopRobotManager.b(str)) {
        localArrayList1.add(localObject);
      } else if (TroopUtils.b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject);
      } else {
        localArrayList3.add(localObject);
      }
    }
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    Object localObject = paramList;
    if (paramList == null) {}
    try
    {
      localObject = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
      this.jdField_e_of_type_JavaUtilList.add(0, localObject);
    }
    catch (NumberFormatException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, paramList.toString());
        }
      }
      localObject = TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label430;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject);
      a(this.jdField_e_of_type_JavaUtilList);
      localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList3);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "handle0X899_0,memberListForCard.size = " + this.jdField_e_of_type_JavaUtilList.size());
    }
    paramList = new ArrayList();
    localObject = this.jdField_e_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject).next()).uint64_member_uin.get()));
    }
    label430:
  }
  
  private boolean b()
  {
    byte[] arrayOfByte = ((TroopInfoManager)this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {
      try
      {
        oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null) {
        break label57;
      }
    }
    label57:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363973);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363891));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377978));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)paramView.findViewById(2131363792));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new ChatSettingForTroop.5(this));
  }
  
  private void c(String paramString)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[50];
    TextView localTextView1 = (TextView)localView.findViewById(2131363778);
    TextView localTextView2 = (TextView)localView.findViewById(2131377063);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    a(50, 3, localView, getString(2131699435), "", true);
    if (TextUtils.isEmpty(paramString)) {
      localTextView2.setText(getString(2131699440));
    }
    for (;;)
    {
      b(localView);
      return;
      localTextView2.setText(paramString);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {}
    label391:
    label524:
    for (;;)
    {
      return;
      Object localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
      int i1;
      label79:
      Switch localSwitch;
      if ((localObject != null) && (((TroopGameCardConfig)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin)))
      {
        i1 = 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()) || (i1 == 0) || (StudyModeManager.a())) {
          break label472;
        }
        i1 = 1;
        if (i1 != 0)
        {
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled();
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isOwnerOrAdmin(this.app.getCurrentAccountUin()))
          {
            localObject = new FormSwitchItem(this, null);
            ((FormSwitchItem)localObject).setBackgroundResource(2130839585);
            ((FormSwitchItem)localObject).setBgType(2);
            ((FormSwitchItem)localObject).setText(getString(2131697400));
            ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167033));
            ((FormSwitchItem)localObject).setFocusable(true);
            ((FormSwitchItem)localObject).getBackground().setAlpha(255);
            ((FormSwitchItem)localObject).setContentDescription(getString(2131697400));
            this.jdField_a_of_type_ArrayOfAndroidViewView[47] = localObject;
            localSwitch = ((FormSwitchItem)localObject).a();
            localSwitch.setTag(Integer.valueOf(47));
            if (!bool) {
              break label477;
            }
            localSwitch.setChecked(true);
            label228:
            localSwitch.setOnCheckedChangeListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            TroopReportor.a("Grp_set_new", "grpData_admin", "game_switch", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject).setBackgroundResource(2130839585);
          ((FormSwitchItem)localObject).setText(getString(2131697401));
          ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167033));
          ((FormSwitchItem)localObject).setFocusable(true);
          ((FormSwitchItem)localObject).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject).setContentDescription(getString(2131697401));
          this.jdField_a_of_type_ArrayOfAndroidViewView[48] = localObject;
          localSwitch = ((FormSwitchItem)localObject).a();
          localSwitch.setTag(Integer.valueOf(48));
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.shouldShowMyGameCard()) {
            break label486;
          }
          localSwitch.setChecked(true);
          localSwitch.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          if (bool) {
            break label495;
          }
          ((FormSwitchItem)localObject).setVisibility(8);
        }
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label524;
        }
        localObject = View.inflate(this, 2131561722, null);
        ((View)localObject).setBackgroundResource(2130851165);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
        return;
        i1 = 0;
        break;
        label472:
        i1 = 0;
        break label79;
        label477:
        localSwitch.setChecked(false);
        break label228;
        label486:
        localSwitch.setChecked(false);
        break label391;
        label495:
        TroopReportor.a("Grp_manage_new", "game", "game_switch", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
    }
  }
  
  private boolean c()
  {
    boolean bool4 = true;
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool5;
    boolean bool6;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            break label221;
          }
          bool1 = true;
          bool5 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopPicListJson);
          bool6 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt > 0L) {
            break label226;
          }
          bool2 = true;
          label85:
          if (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
            break label231;
          }
          bool3 = bool4;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags != null) {
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.isEmpty()) {
              break label231;
            }
          }
        }
      }
    }
    label221:
    label226:
    label231:
    for (boolean bool3 = bool4;; bool3 = false)
    {
      bool4 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      bool1 = TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, new boolean[] { bool1, bool5, bool6, bool2, bool3, bool4 }, new int[] { 11, 12, 5, 4, 8, 6 });
      return bool1;
      bool1 = false;
      break;
      bool2 = false;
      break label85;
    }
  }
  
  private void d(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
    HWTroopUtils.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void d(View paramView)
  {
    Object localObject = View.inflate(this, 2131560801, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject;
    ad();
    this.jdField_b_of_type_AndroidViewView.measure(0, 0);
    localObject = View.inflate(this, 2131561722, null);
    ((View)localObject).setBackgroundResource(2130851165);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
    localObject = View.inflate(this, 2131561719, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localObject;
    ((View)localObject).setTag(Integer.valueOf(23));
    ((View)localObject).setOnClickListener(this);
    ((View)localObject).setContentDescription(HardCodeUtil.a(2131701799));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    paramView.findViewById(2131379922).setVisibility(8);
    boolean bool = DBUtils.a(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
    paramView = (TextView)((View)localObject).findViewById(2131377063);
    if (paramView != null) {
      TroopUtils.a(bool, paramView);
    }
    paramView = ((View)localObject).findViewById(2131368281);
    paramView.setTag(Integer.valueOf(35));
    paramView.setContentDescription(getResources().getString(2131699355));
    if (SimpleUIUtil.a()) {
      paramView.setBackground(null);
    }
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[35] = paramView;
    H();
    paramView = ((View)localObject).findViewById(2131379987);
    paramView.setTag(Integer.valueOf(36));
    this.jdField_a_of_type_ArrayOfAndroidViewView[36] = paramView;
    e();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      localObject = ((View)localObject).findViewById(2131378625);
      ((TextView)localObject).setText(new QQText(paramView, 11, 16));
      this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        ((View)localObject).setVisibility(8);
      }
      d();
      P();
      paramView = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
      if ((paramView != null) && (paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)))
      {
        paramView = View.inflate(this, 2131561722, null);
        paramView.setBackgroundResource(2130851165);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
        paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298624);
        paramView = View.inflate(this, 2131561707, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[43] = paramView;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
        localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject == null) {
          break label572;
        }
      }
    }
    label572:
    for (int i1 = ((TroopManager)localObject).k(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);; i1 = 0)
    {
      paramView = (TextView)paramView.findViewById(2131377063);
      TroopUtils.a(TroopUtils.b("RED_POINT_KEY_TROOP_ASSOCIATION"), paramView);
      e(i1);
      paramView = View.inflate(this, 2131561722, null);
      paramView.setBackgroundResource(2130851165);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
      paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
      return;
      paramView = getString(2131696129);
      break;
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      ab();
      return;
    }
    e(paramString);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this, ChatActivity.class);; localIntent = new Intent(this, SplashActivity.class))
    {
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      if ((paramBoolean) && (this.jdField_k_of_type_Boolean))
      {
        localIntent.putExtra("fromThirdAppByOpenSDK", true);
        localIntent.putExtra("appid", getIntent().getExtras().getString("appid"));
        localIntent.putExtra("pkg_name", getIntent().getExtras().getString("pkg_name"));
        localIntent.putExtra("app_name", getIntent().getExtras().getString("app_name"));
        localIntent.putExtra("action", getIntent().getExtras().getInt("pkg_name"));
      }
      startActivity(localIntent);
      return;
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("count = %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[43];
    if (localView == null) {
      return;
    }
    if (paramInt > 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        ReportController.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800B4AD", "0X800B4AD", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), "", "", "");
      }
      String str = getResources().getString(2131699352) + String.valueOf(paramInt) + getResources().getString(2131699353);
      a(43, 2, localView, getResources().getString(2131699354), " ", true);
      TextView localTextView1 = (TextView)localView.findViewById(2131363778);
      TextView localTextView2 = (TextView)localView.findViewById(2131377063);
      if (localTextView1 != null) {
        localTextView1.setVisibility(8);
      }
      if (localTextView2 != null) {
        localTextView2.setText(str);
      }
      localView.setTag(Integer.valueOf(43));
      localView.setOnClickListener(this);
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void e(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131363778);
    TextView localTextView2 = (TextView)paramView.findViewById(2131377063);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    localTextView2.setText(getString(2131699455));
    a(45, 3, paramView, getString(2131699457), "", true);
    TroopUtils.a(TroopUtils.b("RED_POINT_KEY_TROOP_IDOL_RANK" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), localTextView2);
  }
  
  private void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2)) {
        i1 = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 10);
      return;
    }
    a(2131720199, 0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.setStatusTextColor(false, getWindow());
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
  }
  
  private void f(String paramString)
  {
    runOnUiThread(new ChatSettingForTroop.57(this, paramString));
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    while (paramBoolean == this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled()) {
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131696176, 0).b(getTitleBarHeight());
      ag();
      return;
    }
    if (paramBoolean) {
      ai();
    }
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((FormSwitchItem)localObject).setVisibility(0);
        ah();
      }
    }
    else
    {
      localObject = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject != null) {
        ((TroopHandler)localObject).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean);
      }
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (localObject = "game_switch_on";; localObject = "game_switch_off")
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
      ((FormSwitchItem)localObject).setVisibility(8);
      break;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isShowMyGameCardEnabled() == paramBoolean) {
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131696176, 0).b(getTitleBarHeight());
      ah();
      return;
    }
    Object localObject = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null) {
      ((TroopHandler)localObject).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean);
    }
    if (paramBoolean) {}
    for (localObject = "game_switch_on";; localObject = "game_switch_off")
    {
      TroopReportor.a("Grp_manage_new", "game", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      if (!paramBoolean) {
        break label146;
      }
      i1 = 0;
      label46:
      if (!localBizTroopHandler.a(str, i1)) {
        break label158;
      }
      if (!paramBoolean) {
        break label151;
      }
    }
    label146:
    label151:
    for (String str = "open_stick";; str = "close_stick")
    {
      ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      break;
      i1 = 1;
      break label46;
    }
    label158:
    ak();
  }
  
  private void i(boolean paramBoolean)
  {
    int i2 = 1;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131692257, 1);
      am();
      return;
    }
    if (paramBoolean) {
      HiddenChatManager.a(this.app).a(this);
    }
    label123:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i1 = 1;
      int i3 = (int)NetConnInfoCenter.getServerTime();
      ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, this.app.getCurrentUin(), i1, 512, i3);
      an();
      if (!paramBoolean) {
        break label171;
      }
      TroopReportor.a("Grp_set_new", "grpData_admin", "hideMessage_open", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label202;
      }
    }
    label171:
    label202:
    for (int i1 = i2;; i1 = 2)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 2, i1, "0", "0", "", "");
      return;
      i1 = 0;
      break;
      TroopReportor.a("Grp_set_new", "grpData_admin", "hideMessage_close", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      break label123;
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131696176, 0).b(getTitleBarHeight());
      ao();
      return;
    }
    ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      break;
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
      } while ((localObject == null) || (!((TroopAssociationsEntryConfig)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)));
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation()) && (!paramBoolean)) {
        break;
      }
      localObject = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localObject == null);
    ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3, "");
    return;
    e(0);
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[49];
    } while (localObject == null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131377063);
    TroopUtils.a(DBUtils.b(this.app.getCurrentAccountUin()), localTextView);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFlagExt4 & 0x8000) == 0) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      localTextView.setText(getResources().getString(2131697559));
      return;
    }
    localTextView.setText("");
    long l1 = 0L;
    Object localObject = DBUtils.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, getString(2131697561));
    if ((localObject != null) && (localObject.length == 2)) {
      l1 = ((Long)localObject[0]).longValue();
    }
    for (localObject = (String)localObject[1];; localObject = "")
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date());
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localTroopHandler.x(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
      }
      if (l1 > localCalendar.getTimeInMillis())
      {
        localTextView.setText("");
        return;
      }
      localTroopHandler.x(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
    }
  }
  
  private void v()
  {
    TextView localTextView = new TextView(this);
    localTextView.setOnClickListener(new ChatSettingForTroop.6(this));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localTextView.setGravity(1);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(2131720200);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ViewUtils.b(15.0F);
    localLayoutParams.bottomMargin = ViewUtils.b(24.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
    TroopReportor.a("Grp_set_new", "grpData_admin", "tipoff_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
  }
  
  private void w()
  {
    Object localObject = View.inflate(this, 2131561720, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = (Button)((View)localObject).findViewById(2131365651);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
      ((Button)localObject).setText(2131691834);
    }
    for (;;)
    {
      ((Button)localObject).setOnClickListener(new ChatSettingForTroop.7(this));
      return;
      ((Button)localObject).setText(2131717088);
    }
  }
  
  private void x()
  {
    Object localObject = View.inflate(this, 2131561700, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a(27, 0, (View)localObject, getString(2131696091), null, false);
    ((View)localObject).setTag(Integer.valueOf(27));
    ((View)localObject).setOnClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131379432);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localObject = (TextView)((View)localObject).findViewById(2131369051);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private void y()
  {
    b(getResources().getString(2131699450));
    Object localObject = new FormSimpleItem(this);
    this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject;
    a(17, 1, (FormSimpleItem)localObject, HardCodeUtil.a(2131701821), "", true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "chatBG_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject = new FormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      a(18, 2, (FormSimpleItem)localObject, getString(2131720099), "", true);
      ((FormSimpleItem)localObject).setVisibility(8);
      localObject = (TroopEnterEffectManager)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initUI  effectManager.isAllTroopShowEnterance() = " + ((TroopEnterEffectManager)localObject).b());
      }
      if (((TroopEnterEffectManager)localObject).b()) {
        a(true);
      }
    }
    c(false);
    localObject = new FormSimpleItem(this);
    a(1010, 2, (FormSimpleItem)localObject, getString(2131694554), getString(2131719084), true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpNotice_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    if (TroopKeywordManager.a())
    {
      localObject = new FormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject;
      a(40, 2, (FormSimpleItem)localObject, getString(2131699392), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    }
    localObject = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject).setBackgroundResource(2130839582);
    ((FormSwitchItem)localObject).setText(getString(2131696334));
    ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167033));
    ((FormSwitchItem)localObject).setFocusable(true);
    ((FormSwitchItem)localObject).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject).setContentDescription(getString(2131696334));
    this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject;
    ((FormSwitchItem)localObject).a().setTag(Integer.valueOf(10));
    am();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "hideMessage_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    localObject = View.inflate(this, 2131561722, null);
    ((View)localObject).setBackgroundResource(2130851165);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
  }
  
  private void z()
  {
    b(getResources().getString(2131699451));
    if (((ITroopHonorService)this.app.getRuntimeService(ITroopHonorService.class, "")).isGrayTroopHonor(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      localObject1 = new FormSwitchItem(this, null);
      localObject2 = new FormSimpleItem(this, null);
      ((FormSimpleItem)localObject2).a(true);
      ((FormSimpleItem)localObject2).setBgType(1);
      ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131699382));
      int i2 = 2131699379;
      int i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()) {
          i1 = 2131699380;
        }
      }
      ((FormSimpleItem)localObject2).setRightText(getResources().getString(i1));
      ((FormSimpleItem)localObject2).setContentDescription(getResources().getString(2131699382));
      ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167033));
      ((FormSimpleItem)localObject2).setFocusable(true);
      ((FormSimpleItem)localObject2).getBackground().setAlpha(255);
      this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject2;
      ((FormSimpleItem)localObject2).setTag(Integer.valueOf(32));
      ((FormSimpleItem)localObject2).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      TroopReportor.a("Grp_set_new", "grpData_admin", "grpHonour_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      ReportController.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
    }
    Object localObject1 = View.inflate(this, 2131561707, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[49] = localObject1;
    a(49, 3, (View)localObject1, getString(2131699394), "", true);
    ((View)localObject1).setTag(Integer.valueOf(49));
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131363778);
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    ((View)localObject1).setOnClickListener(this);
    if (this.jdField_f_of_type_Boolean)
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "Luckyword_entry_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      return;
      ((View)localObject1).setVisibility(8);
    }
  }
  
  void a()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      View localView = View.inflate(this, 2131563139, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365157));
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131379533));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[51];
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
      Object localObject = new AbsListView.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      localObject = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
      this.jdField_d_of_type_Boolean = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "intNewStyleUI mIsQidianPrivateTroop : " + this.jdField_d_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      super.setContentView(localView);
      this.jdField_d_of_type_AndroidViewView = localView;
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838979);
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131379512);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131379451));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690890));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369534));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690890));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369487));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694683) + getString(2131690775));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369501));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131693409));
      TroopReportor.a("Grp_set_new", "grpData_admin", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      d(localView);
      E();
      D();
      C();
      B();
      A();
      z();
      y();
      x();
      w();
      v();
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNewStyleUI  mIsQidianPrivateTroop = " + this.jdField_d_of_type_Boolean + ",time = " + (System.currentTimeMillis() - l1));
      }
      c(localView);
      b(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      finish();
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131369051);
    if (paramString != null)
    {
      paramString.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label69;
      }
    }
    label69:
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131167113));
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    label52:
    TextView localTextView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        paramView.getBackground().setAlpha(255);
        localTextView = (TextView)paramView.findViewById(2131379432);
        if (localTextView != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label176;
          }
          localTextView.setText("");
          localTextView.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839575);
      break label52;
      paramView.setBackgroundResource(2130839591);
      break label52;
      paramView.setBackgroundResource(2130839585);
      break label52;
      paramView.setBackgroundResource(2130839582);
      break label52;
      paramView.setBackgroundColor(Color.parseColor("#00000000"));
      break label52;
      label176:
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      switch (paramInt2)
      {
      default: 
        label60:
        paramFormSimpleItem.setRightTextColor(2);
        paramFormSimpleItem.setLeftTextColor(0);
        paramFormSimpleItem.getBackground().setAlpha(255);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramFormSimpleItem.setLeftText(str);
        paramFormSimpleItem.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
      paramFormSimpleItem.setBgType(0);
      break label60;
      paramFormSimpleItem.setBgType(1);
      break label60;
      paramFormSimpleItem.setBgType(2);
      break label60;
      paramFormSimpleItem.setBgType(3);
      break label60;
      paramFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
      break label60;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramView == null) {}
    do
    {
      return;
      if (33 == paramInt) {
        paramBoolean = false;
      }
      paramView = paramView.findViewById(2131363027);
    } while (paramView == null);
    if (paramBoolean) {}
    for (paramInt = i1;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      return;
    }
  }
  
  protected void a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ThreadManager.post(new ChatSettingForTroop.21(this, paramLong), 8, null, true);
  }
  
  /* Error */
  protected void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 2701	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 2703	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 2704	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 2708	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 2709	[B
    //   30: invokevirtual 2710	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 2713	KQQ/BatchResponse:seq	I
    //   38: ifne +746 -> 784
    //   41: aload 10
    //   43: ifnull +741 -> 784
    //   46: aload 10
    //   48: getfield 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 2720	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +730 -> 784
    //   57: aload 10
    //   59: getfield 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 2723	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 2729	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 2731	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 2732	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 2733	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 2737	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 2742	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1380 -> 1487
    //   110: aload 8
    //   112: ifnonnull +672 -> 784
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +666 -> 784
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 2744 2 0
    //   130: checkcast 2746	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   133: astore 9
    //   135: aload 9
    //   137: ifnonnull +29 -> 166
    //   140: iload 4
    //   142: iconst_1
    //   143: iadd
    //   144: istore 4
    //   146: goto -36 -> 110
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 2747	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 2036 1 0
    //   162: istore_3
    //   163: goto +1324 -> 1487
    //   166: aload 9
    //   168: getfield 2751	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +83 -> 261
    //   181: iload 4
    //   183: ifne +78 -> 261
    //   186: aload_0
    //   187: ldc_w 2755
    //   190: iconst_1
    //   191: invokestatic 2306	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   194: aload_0
    //   195: invokevirtual 2309	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   198: invokevirtual 2312	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   201: pop
    //   202: new 2757	com/tencent/mobileqq/activity/ChatSettingForTroop$35
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 2758	com/tencent/mobileqq/activity/ChatSettingForTroop$35:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   210: bipush 32
    //   212: aconst_null
    //   213: iconst_0
    //   214: invokestatic 2763	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   222: aload_0
    //   223: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: iconst_0
    //   227: putfield 2040	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   230: aload_0
    //   231: invokevirtual 1771	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 2765
    //   237: iconst_0
    //   238: invokevirtual 1405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 2192	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   246: aload_0
    //   247: aload_0
    //   248: invokevirtual 1771	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   251: invokevirtual 2213	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   254: iconst_2
    //   255: invokestatic 2768	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   258: goto -118 -> 140
    //   261: iload_2
    //   262: ifne +1119 -> 1381
    //   265: aload 9
    //   267: getfield 2772	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   270: invokevirtual 2775	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   273: ifeq +1108 -> 1381
    //   276: aload 9
    //   278: getfield 2772	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   281: invokevirtual 2778	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 2774	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   287: astore 9
    //   289: aload 9
    //   291: astore 8
    //   293: aload 9
    //   295: ifnull -155 -> 140
    //   298: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +40 -> 341
    //   304: ldc_w 636
    //   307: iconst_2
    //   308: new 558	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 2780
    //   318: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 9
    //   323: getfield 2783	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_long_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   326: invokevirtual 2723	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   329: invokevirtual 2786	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   332: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 9
    //   343: astore 8
    //   345: aload_0
    //   346: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   349: ifnull -209 -> 140
    //   352: aload_0
    //   353: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 9
    //   358: invokevirtual 2790	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   361: aload_0
    //   362: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   365: getfield 2204	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   368: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +7 -> 378
    //   374: aload_0
    //   375: invokevirtual 670	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   378: aload_0
    //   379: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 819	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopHead	Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokespecial 2163	com/tencent/mobileqq/activity/ChatSettingForTroop:H	()V
    //   392: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +69 -> 464
    //   398: aload 9
    //   400: getfield 2793	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   406: istore_2
    //   407: ldc_w 2795
    //   410: iconst_2
    //   411: new 558	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 2797
    //   421: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   428: getfield 354	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   431: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 2799
    //   437: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_2
    //   441: invokevirtual 742	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 2801
    //   447: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: i2l
    //   452: invokestatic 2804	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(J)Z
    //   455: invokevirtual 641	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   468: ifnull +64 -> 532
    //   471: aload_0
    //   472: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   475: aload 9
    //   477: invokevirtual 2805	com/tencent/mobileqq/data/troop/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   480: aload_0
    //   481: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload_0
    //   485: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   488: invokevirtual 2808	com/tencent/mobileqq/data/troop/TroopInfo:getNewTroopNameOrTroopName	()Ljava/lang/String;
    //   491: putfield 2204	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   498: getfield 2809	com/tencent/mobileqq/data/troop/TroopInfo:isNewTroop	Z
    //   501: ifne +17 -> 518
    //   504: aload_0
    //   505: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   508: aload_0
    //   509: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   512: invokevirtual 2808	com/tencent/mobileqq/data/troop/TroopInfo:getNewTroopNameOrTroopName	()Ljava/lang/String;
    //   515: putfield 2810	com/tencent/mobileqq/data/troop/TroopInfo:newTroopName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   522: aload_0
    //   523: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   526: invokevirtual 2808	com/tencent/mobileqq/data/troop/TroopInfo:getNewTroopNameOrTroopName	()Ljava/lang/String;
    //   529: putfield 2813	com/tencent/mobileqq/data/troop/TroopInfo:oldTroopName	Ljava/lang/String;
    //   532: aload_0
    //   533: aload 9
    //   535: getfield 2793	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: i2l
    //   542: invokestatic 2804	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(J)Z
    //   545: putfield 673	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   548: aload_0
    //   549: getfield 673	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   552: ifeq +77 -> 629
    //   555: aload_0
    //   556: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   559: getfield 543	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   562: ifeq +804 -> 1366
    //   565: iconst_1
    //   566: istore_2
    //   567: new 2815	com/tencent/mobileqq/statistics/ReportTask
    //   570: dup
    //   571: aload_0
    //   572: getfield 420	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokespecial 2818	com/tencent/mobileqq/statistics/ReportTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   578: ldc_w 893
    //   581: invokevirtual 2821	com/tencent/mobileqq/statistics/ReportTask:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   584: ldc_w 2823
    //   587: invokevirtual 2825	com/tencent/mobileqq/statistics/ReportTask:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   590: ldc_w 347
    //   593: invokevirtual 2827	com/tencent/mobileqq/statistics/ReportTask:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   596: ldc_w 2829
    //   599: invokevirtual 2831	com/tencent/mobileqq/statistics/ReportTask:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   602: iconst_2
    //   603: anewarray 351	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   612: getfield 354	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_2
    //   619: invokestatic 1957	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   622: aastore
    //   623: invokevirtual 2834	com/tencent/mobileqq/statistics/ReportTask:a	([Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   626: invokevirtual 2836	com/tencent/mobileqq/statistics/ReportTask:a	()V
    //   629: aload_0
    //   630: getfield 673	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   633: ifne +865 -> 1498
    //   636: iconst_1
    //   637: istore 5
    //   639: aload_0
    //   640: iload 5
    //   642: aload_0
    //   643: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   646: getfield 676	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   649: invokespecial 679	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(ZZ)V
    //   652: aload_0
    //   653: invokevirtual 2838	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   656: aload_0
    //   657: getfield 420	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   660: aload_0
    //   661: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   664: getfield 2841	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   667: new 2843	com/tencent/mobileqq/activity/ChatSettingForTroop$36
    //   670: dup
    //   671: aload_0
    //   672: invokespecial 2844	com/tencent/mobileqq/activity/ChatSettingForTroop$36:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   675: invokestatic 2849	com/tencent/mobileqq/troop/utils/TroopBindPubAccountProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLcom/tencent/biz/ProtoUtils$TroopProtocolObserver;)V
    //   678: aload_0
    //   679: invokevirtual 2851	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   682: aload_0
    //   683: invokespecial 2853	com/tencent/mobileqq/activity/ChatSettingForTroop:aa	()V
    //   686: aload_0
    //   687: invokevirtual 2167	com/tencent/mobileqq/activity/ChatSettingForTroop:d	()V
    //   690: aload_0
    //   691: invokespecial 2130	com/tencent/mobileqq/activity/ChatSettingForTroop:ad	()V
    //   694: aload_0
    //   695: invokevirtual 2855	com/tencent/mobileqq/activity/ChatSettingForTroop:q	()V
    //   698: aload_0
    //   699: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   702: ifnull +21 -> 723
    //   705: aload_0
    //   706: getfield 316	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   709: aload_0
    //   710: getfield 420	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   713: aload_0
    //   714: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   717: getfield 2040	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   720: invokestatic 2858	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   723: aload_0
    //   724: invokevirtual 2859	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   727: aload_0
    //   728: getfield 2861	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   731: ifnull +21 -> 752
    //   734: aload_0
    //   735: getfield 2861	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   738: aload_0
    //   739: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   742: invokevirtual 2867	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   745: aload_0
    //   746: getfield 2861	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   749: invokevirtual 2868	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	()V
    //   752: aload_0
    //   753: iconst_0
    //   754: invokespecial 2870	com/tencent/mobileqq/activity/ChatSettingForTroop:k	(Z)V
    //   757: aload 9
    //   759: astore 8
    //   761: goto -621 -> 140
    //   764: astore 8
    //   766: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +15 -> 784
    //   772: ldc_w 2872
    //   775: iconst_2
    //   776: aload 8
    //   778: invokevirtual 2873	java/lang/Exception:toString	()Ljava/lang/String;
    //   781: invokestatic 665	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: aload_1
    //   785: getfield 2713	KQQ/BatchResponse:seq	I
    //   788: iconst_1
    //   789: if_icmpne +92 -> 881
    //   792: aload 10
    //   794: ifnull +87 -> 881
    //   797: aload 10
    //   799: getfield 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   802: invokevirtual 2720	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   805: ifeq +76 -> 881
    //   808: aload 10
    //   810: getfield 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   813: invokevirtual 2723	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   816: invokevirtual 2729	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   819: astore 8
    //   821: new 2875	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   824: dup
    //   825: invokespecial 2876	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   828: astore 9
    //   830: aload 9
    //   832: aload 8
    //   834: invokevirtual 2877	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   837: pop
    //   838: aload 9
    //   840: getfield 2880	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   843: invokevirtual 2881	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   846: ifeq +35 -> 881
    //   849: aload_0
    //   850: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   853: getfield 2040	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   856: ifne +555 -> 1411
    //   859: aload_0
    //   860: getfield 2861	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   863: ifnull +18 -> 881
    //   866: aload_0
    //   867: getfield 2861	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   870: aload 9
    //   872: getfield 2880	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   875: invokevirtual 2742	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   878: invokevirtual 2882	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   881: aload_1
    //   882: getfield 2713	KQQ/BatchResponse:seq	I
    //   885: iconst_2
    //   886: if_icmpne -875 -> 11
    //   889: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +13 -> 905
    //   895: ldc_w 2884
    //   898: iconst_2
    //   899: ldc_w 2886
    //   902: invokestatic 644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload 10
    //   907: ifnull -896 -> 11
    //   910: aload 10
    //   912: getfield 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   915: invokevirtual 2720	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   918: ifeq -907 -> 11
    //   921: aload 10
    //   923: getfield 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   926: invokevirtual 2723	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   929: invokevirtual 2729	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   932: astore_1
    //   933: new 2888	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   936: dup
    //   937: invokespecial 2889	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   940: astore 9
    //   942: aload 9
    //   944: aload_1
    //   945: invokevirtual 2890	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   948: pop
    //   949: aload 9
    //   951: getfield 2893	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   954: invokevirtual 1743	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   957: ifeq -946 -> 11
    //   960: aload 9
    //   962: getfield 2896	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   965: invokevirtual 2897	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   968: ifne +514 -> 1482
    //   971: aload 9
    //   973: getfield 2896	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   976: invokevirtual 2742	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   979: astore_1
    //   980: aload 9
    //   982: getfield 2900	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   985: invokevirtual 2897	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   988: ifne +488 -> 1476
    //   991: aload 9
    //   993: getfield 2900	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   996: invokevirtual 2742	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   999: astore 8
    //   1001: aload_0
    //   1002: getfield 420	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1005: getstatic 425	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1008: invokevirtual 431	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1011: checkcast 433	com/tencent/mobileqq/app/TroopManager
    //   1014: astore 10
    //   1016: aload 9
    //   1018: getfield 2893	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1021: invokevirtual 1745	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1024: lstore 6
    //   1026: aload 10
    //   1028: lload 6
    //   1030: invokestatic 2007	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1033: invokevirtual 900	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1036: astore 11
    //   1038: aload 11
    //   1040: ifnull -1029 -> 11
    //   1043: aload_1
    //   1044: ifnull +71 -> 1115
    //   1047: aload 11
    //   1049: aload_1
    //   1050: aload 8
    //   1052: invokevirtual 2904	com/tencent/mobileqq/data/troop/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   1055: aload 9
    //   1057: getfield 2907	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1060: invokevirtual 2908	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1063: ifeq +386 -> 1449
    //   1066: aload 9
    //   1068: getfield 2907	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1071: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1074: istore_2
    //   1075: aload 11
    //   1077: iload_2
    //   1078: i2l
    //   1079: putfield 2911	com/tencent/mobileqq/data/troop/TroopInfo:dwGroupLevelSeq	J
    //   1082: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1085: ifeq +30 -> 1115
    //   1088: ldc_w 2884
    //   1091: iconst_2
    //   1092: new 558	java/lang/StringBuilder
    //   1095: dup
    //   1096: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   1099: ldc_w 2913
    //   1102: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: iload_2
    //   1106: invokevirtual 742	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: aload 9
    //   1117: getfield 2916	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1120: astore_1
    //   1121: aload_1
    //   1122: ifnull +19 -> 1141
    //   1125: aload 11
    //   1127: aload 9
    //   1129: getfield 2916	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1132: invokevirtual 2723	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1135: invokevirtual 2786	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1138: putfield 2919	com/tencent/mobileqq/data/troop/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1141: aload 9
    //   1143: getfield 2922	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1146: astore_1
    //   1147: aload_1
    //   1148: ifnull +19 -> 1167
    //   1151: aload 11
    //   1153: aload 9
    //   1155: getfield 2922	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1158: invokevirtual 2723	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1161: invokevirtual 2786	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1164: putfield 2925	com/tencent/mobileqq/data/troop/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1167: iconst_m1
    //   1168: istore_2
    //   1169: iconst_m1
    //   1170: istore_3
    //   1171: iconst_m1
    //   1172: istore 4
    //   1174: aload 9
    //   1176: getfield 2928	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1179: invokevirtual 2908	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1182: ifeq +23 -> 1205
    //   1185: aload 11
    //   1187: aload 9
    //   1189: getfield 2928	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1192: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1195: i2b
    //   1196: putfield 2931	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   1199: aload 11
    //   1201: getfield 2931	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   1204: istore_2
    //   1205: aload 9
    //   1207: getfield 2934	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1210: invokevirtual 2908	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1213: ifeq +23 -> 1236
    //   1216: aload 11
    //   1218: aload 9
    //   1220: getfield 2934	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1223: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1226: i2b
    //   1227: putfield 2937	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   1230: aload 11
    //   1232: getfield 2937	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   1235: istore_3
    //   1236: aload 9
    //   1238: getfield 2940	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1241: invokevirtual 2908	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1244: ifeq +24 -> 1268
    //   1247: aload 11
    //   1249: aload 9
    //   1251: getfield 2940	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1254: invokevirtual 2754	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1257: i2b
    //   1258: putfield 2943	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1261: aload 11
    //   1263: getfield 2943	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1266: istore 4
    //   1268: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +56 -> 1327
    //   1274: ldc_w 2884
    //   1277: iconst_2
    //   1278: new 558	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   1285: lload 6
    //   1287: invokevirtual 1893	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1290: ldc_w 2945
    //   1293: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload_2
    //   1297: invokevirtual 742	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: ldc_w 2947
    //   1303: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: iload_3
    //   1307: invokevirtual 742	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1310: ldc_w 2949
    //   1313: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: iload 4
    //   1318: invokevirtual 742	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: new 2951	com/tencent/mobileqq/activity/ChatSettingForTroop$37
    //   1330: dup
    //   1331: aload_0
    //   1332: aload 10
    //   1334: aload 11
    //   1336: invokespecial 2954	com/tencent/mobileqq/activity/ChatSettingForTroop$37:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   1339: bipush 8
    //   1341: aconst_null
    //   1342: iconst_0
    //   1343: invokestatic 2695	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1346: return
    //   1347: astore_1
    //   1348: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq -1340 -> 11
    //   1354: ldc_w 2884
    //   1357: iconst_2
    //   1358: aload_1
    //   1359: invokevirtual 2873	java/lang/Exception:toString	()Ljava/lang/String;
    //   1362: invokestatic 1533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1365: return
    //   1366: aload_0
    //   1367: getfield 134	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1370: getfield 936	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1373: ifeq +120 -> 1493
    //   1376: iconst_2
    //   1377: istore_2
    //   1378: goto -811 -> 567
    //   1381: ldc_w 1526
    //   1384: iconst_1
    //   1385: new 558	java/lang/StringBuilder
    //   1388: dup
    //   1389: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   1392: ldc_w 2956
    //   1395: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: iload_2
    //   1399: invokevirtual 742	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1402: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokestatic 1533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1408: goto -1268 -> 140
    //   1411: aload_0
    //   1412: aload 9
    //   1414: getfield 2880	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1417: invokevirtual 2742	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1420: invokespecial 1450	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(Ljava/util/List;)V
    //   1423: goto -542 -> 881
    //   1426: astore 8
    //   1428: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1431: ifeq -550 -> 881
    //   1434: ldc_w 2872
    //   1437: iconst_2
    //   1438: aload 8
    //   1440: invokevirtual 2873	java/lang/Exception:toString	()Ljava/lang/String;
    //   1443: invokestatic 665	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: goto -565 -> 881
    //   1449: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1452: ifeq -337 -> 1115
    //   1455: ldc_w 2884
    //   1458: iconst_2
    //   1459: ldc_w 2958
    //   1462: invokestatic 644	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1465: goto -350 -> 1115
    //   1468: astore_1
    //   1469: goto -302 -> 1167
    //   1472: astore_1
    //   1473: goto -332 -> 1141
    //   1476: aconst_null
    //   1477: astore 8
    //   1479: goto -478 -> 1001
    //   1482: aconst_null
    //   1483: astore_1
    //   1484: goto -504 -> 980
    //   1487: iconst_0
    //   1488: istore 4
    //   1490: goto -1380 -> 110
    //   1493: iconst_3
    //   1494: istore_2
    //   1495: goto -928 -> 567
    //   1498: iconst_0
    //   1499: istore 5
    //   1501: goto -862 -> 639
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1504	0	this	ChatSettingForTroop
    //   0	1504	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1321	2	i1	int
    //   106	1201	3	i2	int
    //   115	1374	4	i3	int
    //   637	863	5	bool	boolean
    //   1024	262	6	l1	long
    //   68	692	8	localObject1	Object
    //   764	13	8	localException1	Exception
    //   819	232	8	localObject2	Object
    //   1426	13	8	localException2	Exception
    //   1477	1	8	localObject3	Object
    //   77	1336	9	localObject4	Object
    //   19	1314	10	localObject5	Object
    //   98	1237	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	764	java/lang/Exception
    //   90	100	764	java/lang/Exception
    //   121	135	764	java/lang/Exception
    //   155	163	764	java/lang/Exception
    //   166	175	764	java/lang/Exception
    //   186	258	764	java/lang/Exception
    //   265	289	764	java/lang/Exception
    //   298	341	764	java/lang/Exception
    //   345	378	764	java/lang/Exception
    //   378	392	764	java/lang/Exception
    //   392	464	764	java/lang/Exception
    //   464	518	764	java/lang/Exception
    //   518	532	764	java/lang/Exception
    //   532	565	764	java/lang/Exception
    //   567	629	764	java/lang/Exception
    //   629	636	764	java/lang/Exception
    //   639	723	764	java/lang/Exception
    //   723	752	764	java/lang/Exception
    //   752	757	764	java/lang/Exception
    //   1366	1376	764	java/lang/Exception
    //   1381	1408	764	java/lang/Exception
    //   933	980	1347	java/lang/Exception
    //   980	1001	1347	java/lang/Exception
    //   1001	1038	1347	java/lang/Exception
    //   1047	1115	1347	java/lang/Exception
    //   1115	1121	1347	java/lang/Exception
    //   1141	1147	1347	java/lang/Exception
    //   1174	1205	1347	java/lang/Exception
    //   1205	1236	1347	java/lang/Exception
    //   1236	1268	1347	java/lang/Exception
    //   1268	1327	1347	java/lang/Exception
    //   1327	1346	1347	java/lang/Exception
    //   1449	1465	1347	java/lang/Exception
    //   821	881	1426	java/lang/Exception
    //   1411	1423	1426	java/lang/Exception
    //   1151	1167	1468	java/lang/Exception
    //   1125	1141	1472	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131379977;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379978;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379979;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379980;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379981;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379982;
    tmp38_32;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      this.jdField_b_of_type_JavaUtilList.add((ImageView)paramView.findViewById(i3));
      i1 += 1;
    }
  }
  
  protected void a(DiscussionInfoCardActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.c();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramQQAppInterface == null) || (paramTroopInfo == null)) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      localStringBuffer.append(str + "|");
    }
    paramTroopInfo.Administrator = localStringBuffer.toString();
    ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopInfo);
  }
  
  protected void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      this.jdField_d_of_type_JavaUtilList = paramTroopInfo.parseTroopMemeberList();
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder().append("getMemberListFromTroopInfo,memberUins.size = ");
        if (this.jdField_d_of_type_JavaUtilList == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i1 = this.jdField_d_of_type_JavaUtilList.size();; i1 = -1)
    {
      QLog.d("Q.chatopttroop", 2, i1);
      f();
      return;
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    String str1 = null;
    if (paramTroopMemberInfo != null) {
      str1 = paramTroopMemberInfo.troopColorNick;
    }
    for (String str2 = paramTroopMemberInfo.troopnick;; str2 = null)
    {
      if (!TextUtils.isEmpty(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "updateNickUseTroopMemberInfo and colorNick is " + str1);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = str1;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId = paramTroopMemberInfo.troopColorNickId;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = str2;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return;
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramString;
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  protected void a(List<oidb_0x899.memberlist> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateGridTroopMemberFace,list = " + paramList);
    }
    if (paramList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList = paramList;
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilList.size())
    {
      localArrayList.add(Long.valueOf(((oidb_0x899.memberlist)paramList.get(i1)).uint64_member_uin.get()));
      i1 += 1;
    }
    this.jdField_d_of_type_JavaUtilList = localArrayList;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("updateGridTroopMemberFace,memberUins.size = ");
      if (this.jdField_d_of_type_JavaUtilList == null) {
        break label171;
      }
    }
    label171:
    for (i1 = this.jdField_d_of_type_JavaUtilList.size();; i1 = -1)
    {
      QLog.d("Q.chatopttroop", 2, i1);
      this.jdField_a_of_type_AndroidOsHandler.post(new ChatSettingForTroop.20(this));
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    label314:
    label864:
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null)
        {
          try
          {
            paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
            paramJSONObject = (JSONObject)paramJSONObject.get("result");
            if ((paramInt != 0) || (paramJSONObject == null)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
            }
            paramBundle = (JSONObject)paramJSONObject.get("basics");
            Object localObject2;
            String str;
            int i1;
            Object localObject1;
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (!QLog.isColorLevel()) {
                    break label1046;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, basics name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
                  break label1046;
                }
              }
            }
            paramBundle = (JSONObject)paramJSONObject.get("friendlink");
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (("add_group".equals(localObject1)) && (i1 != 1)) {
                    runOnUiThread(new ChatSettingForTroop.58(this));
                  }
                  if (!QLog.isColorLevel()) {
                    break label1053;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
                  break label1053;
                }
              }
            }
            paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult, appid =" + paramInt + "\n");
            }
            paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
            if (paramJSONObject == null) {
              continue;
            }
            paramJSONObject = (JSONArray)paramJSONObject.get("datas");
            if (paramJSONObject == null) {
              continue;
            }
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              localObject1 = (JSONObject)paramJSONObject.get(paramInt);
              paramBundle = (String)((JSONObject)localObject1).get("name");
              i1 = ((Integer)((JSONObject)localObject1).get("state")).intValue();
              str = (String)((JSONObject)localObject1).get("api");
              localObject1 = (String)((JSONObject)localObject1).get("msg");
              if (QLog.isColorLevel()) {
                QLog.i("Q.chatopttroop", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i1 + " api = " + str + " msg= " + (String)localObject1 + "\n");
              }
              paramInt += 1;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (Exception paramJSONObject) {}
          QLog.d("Q.chatopttroop", 2, "checkApiState onResult " + paramJSONObject.toString());
          return;
          if (paramJSONObject != null) {
            try
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("data");
              if (paramJSONObject != null)
              {
                paramJSONObject = (JSONObject)paramJSONObject.get("key");
                if (paramJSONObject != null)
                {
                  paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                  paramBundle = (String)paramJSONObject.get("retMsg");
                  if (paramInt != 0) {
                    break label963;
                  }
                  d(true);
                  ReportController.b(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel())
                  {
                    QLog.i("Q.chatopttroop", 2, "joinGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                    return;
                  }
                }
              }
            }
            catch (Exception paramJSONObject)
            {
              f(getActivity().getResources().getString(2131720176));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label963:
    paramJSONObject = getActivity().getResources().getString(2131720176);
    switch (paramInt)
    {
    }
    for (;;)
    {
      f(paramJSONObject);
      break label864;
      paramJSONObject = getActivity().getResources().getString(2131720171);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131720177);
      continue;
      label1046:
      paramInt += 1;
      break;
      label1053:
      paramInt += 1;
      break label314;
    }
  }
  
  protected void a(oidb_0xe83.RspBody paramRspBody)
  {
    Object localObject1;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("showGetAppListResult: respBody isNull=");
      if (paramRspBody == null)
      {
        bool1 = true;
        QLog.d("Q.chatopttroop", 2, bool1);
      }
    }
    else
    {
      if (paramRspBody != null) {
        break label56;
      }
    }
    label56:
    View localView;
    List localList;
    label141:
    boolean bool2;
    int i4;
    label283:
    int i1;
    label291:
    int i2;
    label293:
    do
    {
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
          this.jdField_c_of_type_JavaUtilArrayList.clear();
        } while (localView == null);
        localList = paramRspBody.infos.get();
        if ((localList != null) && (localList.size() != 0)) {
          break label141;
        }
        localView.setVisibility(8);
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList == null || appList.size() == 0");
      return;
      SimpleUIUtil.a();
      bool2 = ThemeUtil.isInNightMode(this.app);
      localView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379920));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label359;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131708960));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ChatSettingForTroop.51(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      i4 = localList.size();
      paramRspBody = localView.findViewById(2131379836);
      if (i4 > 5) {
        break label371;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 5");
      }
      paramRspBody.setVisibility(8);
      if (i4 > 5) {
        break label379;
      }
      i1 = 4;
      i2 = 0;
    } while (i2 > i1);
    switch (i2)
    {
    }
    for (;;)
    {
      i2 += 1;
      break label293;
      label359:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label371:
      paramRspBody.setVisibility(0);
      break label283;
      label379:
      i1 = 9;
      break label291;
      paramRspBody = localView.findViewById(2131379822);
      label394:
      ImageView localImageView;
      Object localObject3;
      oidb_0xe83.AppInfo localAppInfo;
      Object localObject2;
      int i3;
      if ((i2 <= i1) && (i2 < i4))
      {
        paramRspBody.setVisibility(0);
        localImageView = (ImageView)paramRspBody.findViewById(2131362887);
        TextView localTextView = (TextView)paramRspBody.findViewById(2131362909);
        localObject3 = (TextView)paramRspBody.findViewById(2131362907);
        localAppInfo = (oidb_0xe83.AppInfo)localList.get(i2);
        localObject2 = localAppInfo.name.get();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject1 = localObject2;
        if (((String)localObject2).length() > 4) {
          localObject1 = ((String)localObject2).substring(0, 4) + "...";
        }
        localTextView.setText((CharSequence)localObject1);
        localObject2 = new StringBuffer((String)localObject1);
        i3 = localAppInfo.push_red_point.get();
        if (i3 != -1) {
          break label1121;
        }
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText("");
        ((TextView)localObject3).setBackgroundResource(0);
        ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(2130850830, 0, 0, 0);
        ((StringBuffer)localObject2).append("，新");
        label591:
        long l1 = localAppInfo.appid.get();
        if ((i3 != -1) && (l1 == 1L))
        {
          if (!DBUtils.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false)) {
            break label1183;
          }
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText("");
          ((TextView)localObject3).setBackgroundResource(0);
          ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(2130850830, 0, 0, 0);
        }
        label668:
        if (l1 == 0L) {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("qun", "qun_info", "expo_more", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (!localAppInfo.icon.has()) {
          break label1193;
        }
        localObject1 = localAppInfo.icon.get();
        label726:
        localObject3 = localImageView.getContext();
        if (localAppInfo.show_frame.get() != 1) {
          break label1200;
        }
        bool1 = true;
        label748:
        TroopAppShortcutUtils.a((Context)localObject3, localImageView, (String)localObject1, 40.0F, bool1);
        if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(localAppInfo.url.get())) {
          TroopUtils.a(localAppInfo, "expo", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (l1 == 101914115L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
            break label1206;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
          label827:
          QQGameTroopManager.a(1, (String)localObject1, true);
        }
        if (!bool2) {
          break label1213;
        }
        localImageView.setColorFilter(1996488704);
      }
      for (;;)
      {
        paramRspBody.setTag(localAppInfo);
        paramRspBody.setTag(-1, Integer.valueOf(i2 + 1));
        paramRspBody.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        i3 = 0;
        while (i3 < i4)
        {
          localObject1 = (oidb_0xe83.AppInfo)localList.get(i3);
          if ((localObject1 != null) && (((oidb_0xe83.AppInfo)localObject1).appid != null)) {
            ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC3", "0X800AFC3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), String.valueOf(((oidb_0xe83.AppInfo)localObject1).appid.get()), String.valueOf(((oidb_0xe83.AppInfo)localObject1).appid.get()) + "-" + String.valueOf(i3 + 1), "");
          }
          i3 += 1;
        }
        paramRspBody = localView.findViewById(2131379823);
        break label394;
        paramRspBody = localView.findViewById(2131379824);
        break label394;
        paramRspBody = localView.findViewById(2131379825);
        break label394;
        paramRspBody = localView.findViewById(2131379826);
        break label394;
        paramRspBody = localView.findViewById(2131379827);
        break label394;
        paramRspBody = localView.findViewById(2131379828);
        break label394;
        paramRspBody = localView.findViewById(2131379829);
        break label394;
        paramRspBody = localView.findViewById(2131379830);
        break label394;
        paramRspBody = localView.findViewById(2131379831);
        break label394;
        paramRspBody.setVisibility(4);
        break;
        label1121:
        if (i3 > 0)
        {
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText(String.valueOf(i3));
          ((TextView)localObject3).setBackgroundResource(2130850834);
          ((StringBuffer)localObject2).append("，").append(i3).append("未读");
          break label591;
        }
        ((TextView)localObject3).setVisibility(8);
        break label591;
        label1183:
        ((TextView)localObject3).setVisibility(8);
        break label668;
        label1193:
        localObject1 = "";
        break label726;
        label1200:
        bool1 = false;
        break label748;
        label1206:
        localObject1 = "";
        break label827;
        label1213:
        localImageView.setColorFilter(0);
      }
      paramRspBody.setContentDescription(((StringBuffer)localObject2).toString());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateEnterEffectStatus  isShow = " + paramBoolean);
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localFormSimpleItem == null) {
      return;
    }
    Object localObject1;
    if (paramBoolean)
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "specialEntrance_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      localFormSimpleItem.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[17];
      if ((localObject1 != null) && ((localObject1 instanceof FormSimpleItem))) {
        ((FormSimpleItem)localObject1).setBgType(2);
      }
      Object localObject2 = (TroopEnterEffectManager)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      localObject1 = ((TroopEnterEffectManager)localObject2).a();
      if (localObject1 == null) {
        break label209;
      }
      localObject2 = ((TroopEnterEffectManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if ((localObject2 != null) && (((TroopEnterEffectConfig.EffectInfoData)localObject2).jdField_a_of_type_Int > 0)) {
        localFormSimpleItem.setRightText(((TroopEnterEffectConfig.EffectInfoData)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      localFormSimpleItem.setVisibility(8);
      return;
    }
    if (((TroopEnterEffectConfig.EffectInfo)localObject1).b > 0)
    {
      localFormSimpleItem.setRightText(((TroopEnterEffectConfig.EffectInfo)localObject1).jdField_a_of_type_JavaLangString);
      return;
    }
    localFormSimpleItem.setRightText(HardCodeUtil.a(2131701814));
    return;
    label209:
    localFormSimpleItem.setRightText(HardCodeUtil.a(2131701822));
  }
  
  protected boolean a()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "checkParams");
    }
    if (this.app == null) {
      return false;
    }
    boolean bool2 = bool3;
    try
    {
      this.jdField_c_of_type_Boolean = false;
      bool2 = bool3;
      this.jdField_a_of_type_Boolean = false;
      bool2 = bool3;
      Bundle localBundle = getIntent().getExtras();
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = TroopUtils.a(localBundle, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this);
      if (localTroopInfo != null)
      {
        bool2 = bool3;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
      }
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = localBundle.getString("troop_uin");
      bool2 = bool3;
      if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
      this.jdField_h_of_type_Int = localBundle.getInt("D2GType");
      bool2 = bool1;
      this.jdField_k_of_type_Int = localBundle.getInt("filter_id", -1);
      bool2 = bool1;
      TroopUtils.jdField_a_of_type_Int = localBundle.getInt("exposureSource", 99);
      bool2 = bool1;
      this.jdField_k_of_type_Boolean = localBundle.getBoolean("fromThirdAppByOpenSDK");
      bool2 = bool1;
      this.jdField_a_of_type_JavaLangString = localBundle.getString("authKey");
      bool2 = bool1;
      this.jdField_b_of_type_JavaLangString = localBundle.getString("authSig");
      return bool1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
      BnrReport.a(this.app, 69);
    }
    return bool2;
  }
  
  protected boolean a(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    int i1 = 0;
    Object localObject = null;
    if ((localObject == null) && (i1 < paramArrayList.size()))
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i1);
      if (localTroopMemberCardInfo == null) {
        localObject = localTroopMemberCardInfo;
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (Utils.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
        {
          localObject = localTroopMemberCardInfo;
          if (Utils.a(localTroopMemberCardInfo.memberuin, this.app.getCurrentAccountUin())) {}
        }
        else
        {
          localObject = null;
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    if ((localObject != null) && (!Utils.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)))
    {
      paramArrayList = localObject.name;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = localObject.colorNick;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId = localObject.colorNickId;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = localObject.name;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
    return localObject != null;
  }
  
  protected void b()
  {
    if (!NetworkUtil.g(getApplicationContext())) {}
    TroopHandler localTroopHandler;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      TroopListHandler localTroopListHandler = (TroopListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER);
      Object localObject = (TroopMemberInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        ((TroopMemberInfoHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if ((localTroopListHandler != null) && (localTroopHandler != null))
      {
        m();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localTroopListHandler.b((ArrayList)localObject);
          localTroopHandler.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.app);
      M();
    } while (localTroopHandler == null);
    localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, 0, 1);
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        m();
      }
    }
    ThreadManager.post(new ChatSettingForTroop.45(this), 8, null, true);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131379432);
      paramView = paramView.findViewById(2131377063);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (AIOUtils.a(30.0F, getResources()) + i1);
  }
  
  protected void b(boolean paramBoolean)
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_b_of_type_Boolean)) {}
    for (int i1 = 0;; i1 = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
      localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject == null) {
        break;
      }
      if (i1 == 0) {
        i2 = 3;
      }
      ((FormSimpleItem)localObject).setBgType(i2);
      return;
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839545);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298132));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!NetworkUtil.g(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131694459), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ChatSettingForTroop.14(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {}
    for (paramIntent = null;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.app.getCurrentAccountUin(), getResources());
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + HardCodeUtil.a(2131701823));
        }
      }
      if (this.jdField_e_of_type_JavaUtilList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "resultForTroopMemberList,memberListForCard.size = " + this.jdField_e_of_type_JavaUtilList.size());
        }
        a(this.jdField_e_of_type_JavaUtilList);
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) || (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)) {
        break;
      }
      ThreadManager.post(new ChatSettingForTroop.46(this, paramIntent), 8, null, true);
      return;
    }
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131379947);
    ((TextView)localObject).setTag(Integer.valueOf(39));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    if (i1 > 0)
    {
      String str = String.format(getResources().getString(2131693432), new Object[] { Integer.valueOf(i1) });
      ((TextView)localObject).setText(str);
      ((TextView)localObject).setContentDescription(str);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean) {
        ((TextView)localObject).setVisibility(8);
      }
      ((TextView)localObject).setOnClickListener(this);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    n();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      ThreadManager.post(new ChatSettingForTroop.47(this, paramIntent), 8, null, true);
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
    Object localObject = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    String str;
    boolean bool1;
    long l1;
    switch (paramInt1)
    {
    default: 
    case 145: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 11: 
    case 8: 
    case 12: 
    case 13: 
    case 10: 
    case 6: 
    case 4: 
    case 15: 
    case 18: 
    case 16: 
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
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                          str = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
                          if (paramInt2 == -1) {}
                          for (paramIntent = "0";; paramIntent = "1")
                          {
                            TroopReportor.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
                            return;
                          }
                        } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false)));
                        this.u = true;
                        return;
                        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
                        {
                          paramIntent = new Intent();
                          paramIntent.putExtra("isNeedFinish", true);
                          setResult(-1, paramIntent);
                          finish();
                          return;
                        }
                        if (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null) {
                          ThreadManager.post(new ChatSettingForTroop.48(this), 8, null, true);
                        }
                        f();
                        return;
                        a(paramInt2, paramIntent);
                        return;
                      } while (paramInt2 != -1);
                      setResult(-1);
                      this.jdField_m_of_type_Boolean = true;
                      return;
                      b(paramInt2, paramIntent);
                      return;
                      c(paramInt2, paramIntent);
                      return;
                      ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      return;
                      d(paramInt2, paramIntent);
                      e(paramInt2, paramIntent);
                      return;
                    } while ((paramIntent == null) || (paramIntent.getExtras() == null) || (paramInt2 != -1));
                    paramIntent = paramIntent.getExtras();
                    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = paramIntent.getString("location");
                    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
                    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
                    k();
                    return;
                  } while (paramInt2 != -1);
                  if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra("isNeedFinish", true);
                    setResult(-1, paramIntent);
                  }
                  finish();
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
                this.jdField_a_of_type_AndroidContentIntent = paramIntent;
                return;
              } while (paramInt2 != -1);
              paramIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
              paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName());
              paramIntent.putExtra("uintype", 1);
              startActivity(paramIntent);
              setResult(-1);
              finish();
              return;
              e(paramInt2, paramIntent);
              return;
              paramIntent = (TroopEnterEffectManager)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
              if (QLog.isColorLevel()) {
                QLog.d("Q.chatopttroop", 2, "doOnActivityResult REQUEST_FOR_ENTER_EFFECT_SETTING  effectManager.isAllTroopShowEnterance() = " + paramIntent.b());
              }
            } while (!paramIntent.b());
            a(true);
            return;
            bool1 = paramIntent.getBooleanExtra("disabled", true);
            localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[41];
          } while (localObject == null);
          if (bool1) {}
          for (paramIntent = getResources().getString(2131696184);; paramIntent = getResources().getString(2131696185))
          {
            ((FormSimpleItem)localObject).setRightText(paramIntent);
            return;
          }
        } while ((paramInt2 != -1) || (paramIntent == null));
        if (!NetworkUtil.g(this))
        {
          QQToast.a(this, 1, 2131694460, 0).b(getTitleBarHeight());
          return;
        }
        paramIntent = paramIntent.getStringExtra("result");
      } while ((TextUtils.isEmpty(paramIntent)) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname)));
      localObject = (BizTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1) {
          bool1 = true;
        }
      }
      ((BizTroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramIntent, bool1);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopHead())) {
        this.jdField_e_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
      e();
      return;
    case 17: 
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      l1 = 0L;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        bool1 = paramIntent.getBooleanExtra("updateFromWeb", false);
        localObject = paramIntent.getStringExtra("lastAnnouncement");
        l1 = paramIntent.getLongExtra("groupCode", 0L);
        if ((bool1) && (TextUtils.equals(str, String.valueOf(l1))))
        {
          paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          paramIntent.what = 20;
          paramIntent.obj = localObject;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
          paramIntent = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramIntent.b(str);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.updateLastMemoFromWeb((String)localObject);
            paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          }
        }
      }
      break;
    }
    for (paramIntent = (Intent)localObject; QLog.isColorLevel(); paramIntent = (Intent)localObject)
    {
      QLog.i("Q.chatopttroop", 2, String.format("doOnActivityResult get last memo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool1), str, Long.valueOf(l1), paramIntent }));
      return;
      paramIntent = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        break;
      }
      paramIntent.x(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      if (!NetworkUtil.g(this))
      {
        QQToast.a(this, 1, 2131694460, 0).b(getTitleBarHeight());
        return;
      }
      c(paramIntent.getStringExtra("result"));
      return;
      bool1 = false;
    }
  }
  
  public void doOnBackPressed()
  {
    af();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("appid");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("openid");
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("share_uin");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      TroopUtils.a(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this, 0, null);
      this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("guild_id");
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("zone_id");
      this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("role_id");
      this.jdField_k_of_type_JavaLangString = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "joinGroup appid = " + this.jdField_d_of_type_JavaLangString + " openid = " + this.jdField_e_of_type_JavaLangString + " guild id = " + this.jdField_h_of_type_JavaLangString + "zone_id = " + this.jdField_i_of_type_JavaLangString + " role id = " + this.jdField_j_of_type_JavaLangString + "  group code= " + this.jdField_k_of_type_JavaLangString);
      }
      paramBundle = String.valueOf(this.jdField_d_of_type_JavaLangString);
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_f_of_type_JavaLangString.equals(this.app.getAccount()))) {
        break label401;
      }
      s();
      label313:
      if (!QLog.isColorLevel()) {
        break label1137;
      }
    }
    label401:
    label1137:
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (!a())
      {
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
        break;
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break label313;
        }
        OpenID localOpenID = this.app.getMsgHandler().a(paramBundle);
        if (localOpenID == null)
        {
          o();
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatSettingForTroop.2(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
          this.app.getMsgHandler().d(paramBundle);
          break label313;
        }
        if (this.jdField_e_of_type_JavaLangString.equals(localOpenID.openID)) {
          break label313;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
        }
        s();
        break label313;
      }
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaUtilArrayList);
          }
          paramBundle = (TroopLuckyCharacterConfig)QConfigManager.a().a(696);
          if (paramBundle != null) {
            this.jdField_f_of_type_Boolean = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.app.getManager(QQManagerFactory.MGR_TROOP_FILTER));
          a();
          a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          if (!b()) {
            I();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
          }
          ThreadManager.getSubThreadHandler().post(new ChatSettingForTroop.3(this));
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
            {
              paramBundle = "0";
              a("Grp_Admin_data", "Clk_data", paramBundle);
            }
          }
          else
          {
            BnrReport.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            paramBundle.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            addObserver(this.jdField_d_of_type_ComTencentMobileqqAppTroopBusinessObserver);
            addObserver(this.jdField_c_of_type_ComTencentMobileqqAppTroopBusinessObserver);
            TroopUtils.a(this.app);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER));
            paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
            if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
            {
              paramBundle = paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              if ((paramBundle != null) && (paramBundle.isGameBind())) {
                TroopReportor.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
            }
            this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
            ReportController.b(this.app, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
            ReportController.b(this.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
            this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("focusItem");
            if (this.jdField_f_of_type_Boolean) {
              u();
            }
            return true;
          }
        }
        catch (OutOfMemoryError paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        catch (InflateException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        paramBundle = "1";
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 2064	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   4: ifnull +14 -> 18
    //   7: aload_0
    //   8: getfield 2064	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   11: invokevirtual 3737	android/widget/Button:getBackground	()Landroid/graphics/drawable/Drawable;
    //   14: aconst_null
    //   15: invokevirtual 3740	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 163	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_g_of_type_Boolean	Z
    //   23: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +427 -> 453
    //   29: invokestatic 1251	java/lang/System:currentTimeMillis	()J
    //   32: lstore_1
    //   33: ldc 2
    //   35: monitorenter
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 140	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 1342	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder	Lcom/tencent/mobileqq/app/face/IFaceDecoder;
    //   48: ifnull +12 -> 60
    //   51: aload_0
    //   52: getfield 1342	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder	Lcom/tencent/mobileqq/app/face/IFaceDecoder;
    //   55: invokeinterface 3743 1 0
    //   60: aload_0
    //   61: getfield 620	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem	Lcom/tencent/mobileqq/troop/widget/RobotMemberFormItem;
    //   64: ifnull +10 -> 74
    //   67: aload_0
    //   68: getfield 620	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem	Lcom/tencent/mobileqq/troop/widget/RobotMemberFormItem;
    //   71: invokevirtual 3744	com/tencent/mobileqq/troop/widget/RobotMemberFormItem:a	()V
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 289	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver	Lcom/tencent/biz/common/util/OpenIdObserver;
    //   79: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 266	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   87: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 261	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver	Lcom/tencent/mobileqq/avatar/observer/AvatarObserver;
    //   95: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 273	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver	Lcom/tencent/mobileqq/app/BizTroopObserver;
    //   103: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 251	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppTroopBusinessObserver	Lcom/tencent/mobileqq/app/TroopBusinessObserver;
    //   111: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 241	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver	Lcom/tencent/mobileqq/troop/api/observer/TroopObserver;
    //   119: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 246	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver	Lcom/tencent/mobileqq/app/TroopBusinessObserver;
    //   127: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 196	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_ComTencentMobileqqAppTroopBusinessObserver	Lcom/tencent/mobileqq/app/TroopBusinessObserver;
    //   135: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 256	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_ComTencentMobileqqAppTroopBusinessObserver	Lcom/tencent/mobileqq/app/TroopBusinessObserver;
    //   143: invokevirtual 3747	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   146: aload_0
    //   147: getfield 420	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   150: aload_0
    //   151: getfield 299	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver	Lcom/tencent/mobileqq/apollo/api/handler/IApolloExtensionObserver;
    //   154: invokevirtual 3748	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   157: aload_0
    //   158: getfield 236	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: ifnull +11 -> 172
    //   164: aload_0
    //   165: getfield 236	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   168: aconst_null
    //   169: invokevirtual 3751	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   172: aload_0
    //   173: getfield 3353	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   176: ifnull +30 -> 206
    //   179: aload_0
    //   180: getfield 3353	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   183: checkcast 3360	android/graphics/drawable/Animatable
    //   186: invokeinterface 3754 1 0
    //   191: ifeq +15 -> 206
    //   194: aload_0
    //   195: getfield 3353	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   198: checkcast 3360	android/graphics/drawable/Animatable
    //   201: invokeinterface 3757 1 0
    //   206: aload_0
    //   207: getfield 177	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   210: ifnull +20 -> 230
    //   213: aload_0
    //   214: getfield 177	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   217: invokevirtual 3758	android/app/Dialog:isShowing	()Z
    //   220: ifeq +10 -> 230
    //   223: aload_0
    //   224: getfield 177	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   227: invokevirtual 3759	android/app/Dialog:dismiss	()V
    //   230: aload_0
    //   231: invokestatic 3764	com/tencent/mobileqq/troopinfo/GroupCatalogTool:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/troopinfo/GroupCatalogTool;
    //   234: invokevirtual 3765	com/tencent/mobileqq/troopinfo/GroupCatalogTool:a	()V
    //   237: aload_0
    //   238: getfield 3767	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   241: ifnull +10 -> 251
    //   244: aload_0
    //   245: getfield 3767	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   248: invokevirtual 3770	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   251: aload_0
    //   252: getfield 1020	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper	Lcom/tencent/biz/helper/TroopCardAppInfoHelper;
    //   255: ifnull +10 -> 265
    //   258: aload_0
    //   259: getfield 1020	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper	Lcom/tencent/biz/helper/TroopCardAppInfoHelper;
    //   262: invokevirtual 3771	com/tencent/biz/helper/TroopCardAppInfoHelper:a	()V
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 205	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   270: invokevirtual 3775	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   273: aload_0
    //   274: getfield 3600	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   277: ifnull +11 -> 288
    //   280: aload_0
    //   281: getfield 3600	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   284: aconst_null
    //   285: invokevirtual 3751	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   288: aload_0
    //   289: aconst_null
    //   290: putfield 282	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   293: aload_0
    //   294: getfield 2072	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   297: ifnull +10 -> 307
    //   300: aload_0
    //   301: getfield 2072	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   304: invokevirtual 3777	com/tencent/mobileqq/widget/QQBlurView:c	()V
    //   307: aload_0
    //   308: getfield 1151	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   311: ifnull +10 -> 321
    //   314: aload_0
    //   315: getfield 1151	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   318: invokevirtual 1154	com/tencent/mobileqq/troopshare/TroopShareUtility:e	()V
    //   321: aload_0
    //   322: invokespecial 1178	com/tencent/mobileqq/activity/ChatSettingForTroop:U	()V
    //   325: aload_0
    //   326: invokespecial 3779	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   329: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +34 -> 366
    //   335: ldc_w 636
    //   338: iconst_2
    //   339: new 558	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 3781
    //   349: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokestatic 1251	java/lang/System:currentTimeMillis	()J
    //   355: lload_1
    //   356: lsub
    //   357: invokevirtual 1893	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 665	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: return
    //   367: astore_3
    //   368: ldc 2
    //   370: monitorexit
    //   371: aload_3
    //   372: athrow
    //   373: astore_3
    //   374: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq -104 -> 273
    //   380: ldc_w 636
    //   383: iconst_2
    //   384: new 558	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 3783
    //   394: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_3
    //   398: invokevirtual 3784	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   401: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 1533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto -137 -> 273
    //   413: astore_3
    //   414: invokestatic 634	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq -144 -> 273
    //   420: ldc_w 636
    //   423: iconst_2
    //   424: new 558	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   431: ldc_w 3783
    //   434: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_3
    //   438: invokevirtual 3785	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   441: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 1533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: goto -177 -> 273
    //   453: lconst_0
    //   454: lstore_1
    //   455: goto -422 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	ChatSettingForTroop
    //   32	423	1	l1	long
    //   367	5	3	localObject	Object
    //   373	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   413	25	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   36	44	367	finally
    //   368	371	367	finally
    //   265	273	373	java/lang/IllegalArgumentException
    //   265	273	413	java/lang/Exception
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    }
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (i1 != 0) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      }
      TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      Object localObject;
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_l_of_type_Boolean = false;
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        String str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
        {
          localObject = "1";
          label145:
          TroopReportor.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
          label178:
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (!RobotUtils.a(this.app))) {}
        }
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (localTroopHandler != null) {
          localTroopHandler.g(l1);
        }
        if (this.t)
        {
          k(true);
          this.t = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        ae();
        ac();
        ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[40] != null) {
          F();
        }
        return;
        i1 = 0;
        continue;
        localObject = "0";
        break label145;
        localObject = (TroopAppMgr)this.app.getManager(QQManagerFactory.TROOP_APP_MGR);
        if ((localObject != null) && (((TroopAppMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (localTroopHandler != null)) {
          localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, 0, 1);
        }
        if (!this.s) {
          break label178;
        }
        m();
        this.s = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.chatopttroop", 2, "onResume  parseLong err", localException);
          long l1 = 0L;
        }
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.jdField_h_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      addObserver(this.jdField_c_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_h_of_type_Boolean = true;
    }
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_h_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    String str;
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
        break label249;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      localView.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(HardCodeUtil.a(2131701807)).append(str);
        if (!bool) {
          break label259;
        }
        localObject = HardCodeUtil.a(2131701796);
        label85:
        localView.setContentDescription((String)localObject);
      }
      a(localView, new ColorNickText(str, 32).a(), null, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[36];
    if (localObject != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      if (!TextUtils.isEmpty(str)) {
        break label265;
      }
      str = HardCodeUtil.a(2131701824);
    }
    label259:
    label265:
    for (;;)
    {
      ((TextView)localObject).setText(str);
      if (AppSetting.jdField_d_of_type_Boolean) {
        ((View)localObject).setContentDescription(HardCodeUtil.a(2131701791) + str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label249:
      str = HardCodeUtil.a(2131701834);
      break;
      localObject = "";
      break label85;
    }
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        ap();
        N();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      if ("updateShowFace  memberUins.size = " + this.jdField_d_of_type_JavaUtilList == null) {
        break label121;
      }
    }
    label121:
    for (int i1 = this.jdField_d_of_type_JavaUtilList.size();; i1 = -1)
    {
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i1) });
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter != null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter = new ChatSettingForTroop.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter.notifyDataSetChanged();
  }
  
  protected void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.canInviteMember()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4);
    long l1 = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l1);
    }
    if (l1 == 0L)
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localTroopHandler != null) {
        localTroopHandler.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void h()
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label187;
      }
      HWTroopUtils.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      ReportController.b(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
      return;
      i1 = 0;
      break;
      label187:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131697571));
      localIntent.putExtra("default_text", str);
      localIntent.putExtra("default_nick_id", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uin", this.app.getAccount());
      localIntent.putExtra("max_num", 60);
      localIntent.putExtra("from", 0);
      startActivityForResult(localIntent, 2);
    }
  }
  
  protected void i()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    startActivityForResult((Intent)localObject, 9);
    localObject = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject = "0";
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 11)) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat / 1000000.0D), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon / 1000000.0D) }));
      startActivity(localIntent);
      a("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      Intent localIntent;
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 12);
  }
  
  public void k()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)))
      {
        localView.setVisibility(0);
        a(11, 3, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void l()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[22];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo)))
      {
        localView.setVisibility(0);
        a(22, 1, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void m()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    TroopInfoHandler localTroopInfoHandler = (TroopInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
    if ((localTroopHandler == null) || (localTroopInfoHandler == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break label133;
        }
        localTroopInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1000L, "getGroupInfoFromChatSettingForTroop");
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break label153;
        }
        localTroopHandler.c(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.chatopttroop", 2, localException.toString());
      return;
      label133:
      localTroopInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1000L, "getGroupInfoFromChatSettingForTroop");
    }
    label153:
    localException.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "refreshTroopBasicInfo");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, getResources(), this.app.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = false;
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      }
    }
    e();
    aa();
    q();
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
      return;
    }
  }
  
  public void o()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      switch (((Integer)localObject).intValue())
      {
      default: 
        break;
      case 7: 
        h(paramBoolean);
        break;
      case 19: 
        j(paramBoolean);
        break;
      case 10: 
        i(paramBoolean);
        break;
      case 31: 
        a(1, paramBoolean);
        break;
      case 47: 
        f(paramBoolean);
        break;
      case 48: 
        g(paramBoolean);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!(localObject1 instanceof Integer))) {}
    }
    Object localObject3;
    int i1;
    label390:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 4: 
    case 6: 
    case 0: 
    case 2: 
    case 3: 
    case 22: 
    case 39: 
    case 9: 
    case 1001: 
    case 1010: 
    case 1006: 
    case 1008: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = paramView.getTag();
        break;
        if ((QVipBigTroopExpiredProcessor.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
        {
          bool = TroopManager.LiangGroupHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (bool)
            {
              i1 = 15;
              localObject4 = VipUtils.a(0, i1).toString();
              localObject5 = HardCodeUtil.a(2131701806);
              localObject6 = new ChatSettingForTroop.24(this, bool);
              if (!bool) {
                break label490;
              }
              localObject1 = "0X800A57F";
              if (!bool) {
                break label498;
              }
              i1 = 1;
              VipUtils.a(this, (String)localObject3, (String)localObject4, (String)localObject5, (DialogInterface.OnClickListener)localObject6, (String)localObject1, i1, bool);
            }
          }
          for (;;)
          {
            ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
            break;
            i1 = 8;
            break label390;
            localObject1 = "0X8009E38";
            break label430;
            i1 = 3;
            break label437;
            VipUtils.a(this, bool);
          }
        }
        W();
        continue;
        h();
        continue;
        i();
        a("Grp_Admin_data", "Clk_mber", "");
        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        g();
        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        localObject1 = paramView.getTag(2131378910);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          if (((TroopRobotManager)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b((String)localObject1))
          {
            RobotUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1);
          }
          else
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("selfSet_leftViewText", getString(2131720219));
            ((Bundle)localObject3).putString("custom_leftbackbutton_name", getTitle().toString());
            TroopMemberCardUtils.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1, 1, -1, (Bundle)localObject3);
            continue;
            localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject3 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject3).putExtra("url", (String)localObject1);
            startActivity((Intent)localObject3);
            ReportController.b(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
            for (i1 = 0;; i1 = 1)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("hide_operation_bar", true);
              ((Intent)localObject1).putExtra("hideRightButton", true);
              ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
              ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
              ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i1);
              localObject3 = new ActivityURIRequest(this, "/pubaccount/browser");
              ((ActivityURIRequest)localObject3).extra().putAll(((Intent)localObject1).getExtras());
              QRoute.startUri((URIRequest)localObject3, null);
              ReportController.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              BnrReport.a(this.app, 72);
              break;
            }
            S();
            TroopReportor.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            continue;
            ChatHistoryActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1001);
            ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            TroopReportor.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            ReportController.b(this.app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
            continue;
            TroopReportor.a("Grp_set_new", "grpData_admin", "grpNotice_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Intent)localObject1).putExtra("uintype", 1);
            MessageNotificationSettingFragment.a(this, (Intent)localObject1);
            continue;
            localObject1 = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
            ((Intent)localObject1).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
            startActivityForResult((Intent)localObject1, 9);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
            TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a((TroopMemberInfo)localObject1) });
            continue;
            QQToast.a(this, HardCodeUtil.a(2131701800), 0).a();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("extra.GROUP_UIN", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
            EntryDebugFragment.a(this, (Bundle)localObject1);
          }
        }
      }
    case 1002: 
      d(false);
      if (this.jdField_h_of_type_Int == 2) {
        ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      }
      i1 = getIntent().getIntExtra("extra_share_group_from", 0);
      if (i1 != 0) {
        StoryReportor.a("story_grp", "clk_msg", i1, 0, new String[0]);
      }
      localObject1 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A526", "0X800A526", i1, 0, TroopUtils.a() + "", "", "", "");
        break;
      }
    case 5: 
      label430:
      label437:
      label490:
      label498:
      TroopUtils.a("RED_POINT_KEY_TROOP_ADMIN");
      if (this.p) {
        TroopUtils.a("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
      }
      if (this.q) {
        TroopUtils.a("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
      }
      TroopUtils.a(false, (TextView)paramView.findViewById(2131377063));
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject4).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject4).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      ((Intent)localObject4).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
      ((Intent)localObject4).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
      ((Intent)localObject4).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
      ((Intent)localObject4).putExtra("troop_auth_submit_time", this.jdField_i_of_type_Int);
      ((Intent)localObject4).putExtra("leftViewText", getResources().getString(2131690889));
      ((Intent)localObject4).putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
      ((Intent)localObject4).putExtra("key_is_update_before_805", TroopUtils.a(this, "8.0.5"));
      localObject1 = (ITroopHonorService)this.app.getRuntimeService(ITroopHonorService.class, "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        ((Intent)localObject4).putExtra("key_support_troop_honor", ((ITroopHonorService)localObject1).isGrayTroopHonor(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin));
      }
      break;
    }
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();; bool = false)
    {
      label2640:
      label2670:
      long l1;
      for (;;)
      {
        ((Intent)localObject4).putExtra("key_customed_troop", bool);
        if (bool) {
          GameCenterUtils.a(null, "846", "205605", "", "84601", "1", "145");
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTroopUrlConfBean;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = TroopUrlConfProcessor.a();
          this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTroopUrlConfBean = ((TroopUrlConfBean)localObject1);
        }
        ((Intent)localObject4).putExtra("autoApprovalUrl", ((TroopUrlConfBean)localObject1).jdField_b_of_type_JavaLangString);
        ((Intent)localObject4).putExtra("frequencyLimitVisible", ((TroopUrlConfBean)localObject1).jdField_a_of_type_Boolean);
        ((Intent)localObject4).putExtra("key_is_need_update_Group_info", true);
        if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.nMsgLimitFreq) }));
        }
        ((Intent)localObject4).putExtra("troop_manager_edit_red_show", c());
        ((Intent)localObject4).putExtra("troop_manager_edit_current_uin", this.app.getCurrentUin());
        localObject1 = TroopBaseProxyActivity.a(this);
        localObject3 = new TroopManageCmd(this.app);
        localObject5 = PluginCommunicationHandler.getInstance();
        if (localObject5 != null) {
          ((PluginCommunicationHandler)localObject5).register((RemoteCommand)localObject3);
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, this, (Intent)localObject4, (Dialog)localObject1, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), 8);
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject4, (String)localObject1, "", "");
          TroopReportor.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          break;
        }
        ReportController.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
        TroopNotificationUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
        TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        break;
        TroopUtils.a(this.app, this, getIntent(), this);
        ReportController.b(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
        TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        break;
        localObject1 = this.app;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
        for (i1 = 1;; i1 = 2)
        {
          ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A527", "0X800A527", i1, 0, TroopUtils.a() + "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
            break label2670;
          }
          if (!ExtendFriendManager.a(this.app.getCurrentAccountUin())) {
            break label2640;
          }
          localObject1 = ProfileGuideDialogUtils.a(this);
          if (isFinishing()) {
            break;
          }
          ((Dialog)localObject1).show();
          ReportController.b(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
          break;
        }
        ReportController.b(this.app, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
        TroopUtils.a(false, null);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
          {
            d(1);
            break;
          }
          ab();
          break;
        }
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, TroopUtils.jdField_a_of_type_Int, this.jdField_k_of_type_Int, 2);
        if (!NetworkUtil.d(this))
        {
          a(2131694457, 1);
          break;
        }
        localObject1 = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (localObject1 != null) {}
        try
        {
          l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          o();
          ((TroopHandler)localObject1).a(l1, 8390784);
          if (super.getIntent().getBooleanExtra("from_babyq", false)) {
            ReportController.b(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
          }
          TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, localException.toString());
            }
          }
        }
      }
      j();
      break;
      TroopUtils.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 6);
      ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      localObject3 = (EntryStatus)((FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40]).getTag(2131375424);
      if (localObject3 != null)
      {
        l1 = ((EntryStatus)localObject3).jdField_a_of_type_Long;
        ((EntryStatus)localObject3).jdField_a_of_type_Long = SystemClock.uptimeMillis();
        if (((EntryStatus)localObject3).jdField_a_of_type_Long < l1 + 1000L) {
          break;
        }
        QVipConfigManager.a(this.app, "troop_keyword_expire_list_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((EntryStatus)localObject3).jdField_b_of_type_JavaLangString);
        QVipConfigManager.b(this.app, "troop_keyword_guide_clicked", true);
        localObject2 = IndividuationUrlHelper.a("groupkeywords").replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, "onClick: " + (String)localObject2);
        }
        ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((EntryStatus)localObject3).jdField_c_of_type_Int, 1, 0, "", "", "", "");
        localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("isShowAd", false);
        startActivity((Intent)localObject3);
        break;
      }
      QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
      break;
      TroopReportor.a("Grp_set_new", "grpData_admin", "specialEntrance_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      Object localObject2 = new Intent(this, QQBrowserActivity.class);
      localObject3 = IndividuationUrlHelper.a("troopEnterEffect");
      ((Intent)localObject2).putExtra("url", (String)localObject3 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      startActivityForResult((Intent)localObject2, 15);
      TroopEnterEffectManager.a("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      i1 = ((TroopEnterEffectManager)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i1), "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      }
      if (DBUtils.a(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false))
      {
        DBUtils.a(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
        DBUtils.b(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true);
        RedPointUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troop", 3, 0);
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
        if (localObject2 != null)
        {
          localObject2 = (TextView)((View)localObject2).findViewById(2131377063);
          if (localObject2 != null) {
            TroopUtils.a(false, (TextView)localObject2);
          }
        }
      }
      localObject2 = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
      ((Bundle)localObject2).putInt("exposureSource", 1);
      TroopUtils.a(this, (Bundle)localObject2, 2);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800A524", "0X800A524", i1, 0, "", "", "", "");
        break;
      }
      localObject2 = new DeleteRecordDialog(this, this.app, false);
      ((DeleteRecordDialog)localObject2).a(new ChatSettingForTroop.25(this));
      ((DeleteRecordDialog)localObject2).a(2);
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      if (this.o)
      {
        RobotUtils.a(this.app, false);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotMemberFormItem.a(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
        }
      }
      ReportController.b(this.app, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
      TroopUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
      {
        i1 = 1;
        label3904:
        if ((i1 == 0) || (!QVipBigTroopExpiredProcessor.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
          break label4092;
        }
        bool = TroopManager.LiangGroupHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label4083;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!bool) {
          break label4069;
        }
        i1 = 15;
        label3977:
        localObject4 = VipUtils.a(0, i1).toString();
        localObject5 = HardCodeUtil.a(2131701793);
        localObject6 = new ChatSettingForTroop.26(this, bool);
        if (!bool) {
          break label4075;
        }
        localObject2 = "0X800A57F";
        label4017:
        VipUtils.a(this, (String)localObject3, (String)localObject4, (String)localObject5, (DialogInterface.OnClickListener)localObject6, (String)localObject2, 1, bool);
      }
      for (;;)
      {
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
        break;
        i1 = 0;
        break label3904;
        label4069:
        i1 = 8;
        break label3977;
        label4075:
        localObject2 = "0X8009E38";
        break label4017;
        label4083:
        VipUtils.a(this, bool);
      }
      label4092:
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
        label4111:
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
          break label4412;
        }
        i2 = 1;
        label4143:
        localObject4 = new Intent(this, EditInfoActivity.class);
        ((Intent)localObject4).putExtra("edit_type", 2);
        if (i1 == 0) {
          break label4417;
        }
        localObject2 = HardCodeUtil.a(2131701812);
        label4178:
        ((Intent)localObject4).putExtra("title", (String)localObject2);
        ((Intent)localObject4).putExtra("default_text", (String)localObject3);
        ((Intent)localObject4).putExtra("max_num", 96);
        ((Intent)localObject4).putExtra("canPostNull", false);
        if (i1 == 0) {
          break label4428;
        }
        localObject2 = HardCodeUtil.a(2131701797);
        label4233:
        ((Intent)localObject4).putExtra("right_btn", (String)localObject2);
        ((Intent)localObject4).putExtra("isTroopName", true);
        if (i1 == 0) {
          break label4435;
        }
        bool = true;
        label4261:
        ((Intent)localObject4).putExtra("edit_mode", bool);
        if (i2 == 0) {
          break label4441;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        label4285:
        ((Intent)localObject4).putExtra("troopUin", (String)localObject2);
        startActivityForResult((Intent)localObject4, 16);
        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label4448;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, (String)localObject4, "0", (String)localObject2, "");
        break;
        localObject2 = "";
        break label4111;
        label4412:
        i2 = 0;
        break label4143;
        label4417:
        localObject2 = HardCodeUtil.a(2131701811);
        break label4178;
        label4428:
        localObject2 = "";
        break label4233;
        label4435:
        bool = false;
        break label4261;
        label4441:
        localObject2 = "";
        break label4285;
        label4448:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
      T();
      localObject3 = this.app;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject2 = "0";
      }
      for (;;)
      {
        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, (String)localObject4, "0", (String)localObject2, "");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
      localObject2 = TroopLinkManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1);
      localObject3 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject3).putExtra("url", (String)localObject2);
      startActivity((Intent)localObject3);
      TroopReportor.a("Grp_set_new", "grpData_admin", "grpHonour_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      ReportController.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
      break;
      DBUtils.b(this.app.getCurrentAccountUin(), false);
      localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[49];
      if (localObject2 != null)
      {
        localObject2 = (TextView)((View)localObject2).findViewById(2131377063);
        if (localObject2 != null) {
          TroopUtils.a(false, (TextView)localObject2);
        }
      }
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", "https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter".replace("{GROUPCODE}", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      startActivityForResult((Intent)localObject2, 19);
      TroopReportor.a("Grp_set_new", "grpData_admin", "Luckyword_entry_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = TroopUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800A525", "0X800A525", i1, 0, TroopUtils.a() + "", "", "", "");
        break;
      }
      this.t = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        TroopAssociationsUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      TroopUtils.a("RED_POINT_KEY_TROOP_ASSOCIATION");
      TroopUtils.a(false, (TextView)paramView.findViewById(2131377063));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break;
      }
      ReportController.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800B4AE", "0X800B4AE", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), "", "", "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        localObject2 = (TextView)paramView.findViewById(2131377063);
        TroopUtils.a("RED_POINT_KEY_TROOP_IDOL_RANK" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        TroopUtils.a(false, (TextView)localObject2);
        if (StudyModeManager.a())
        {
          QQToast.a(this, getString(2131699454), 0).b(getTitleBarHeight());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
          break;
        }
        FansTroopUtils.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ReportController.b(this.app, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
      for (localObject2 = "null";; localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)
      {
        QLog.d("Q.chatopttroop", 2, new Object[] { "onclick: troopUin = ", localObject2 });
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (StudyModeManager.a())
        {
          QQToast.a(this, getString(2131699454), 0).b(getTitleBarHeight());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
          break;
        }
        FansTroopUtils.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId());
        ReportController.b(this.app, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
      for (localObject2 = "null";; localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)
      {
        QLog.d("Q.chatopttroop", 2, new Object[] { "onclick: troopUin = ", localObject2 });
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)) {
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark);
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        break label55;
      }
      H();
    }
    label55:
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView == null) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
    paramInt1 = 0;
    label72:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof DiscussionInfoCardActivity.ViewHolder)))
      {
        localObject = (DiscussionInfoCardActivity.ViewHolder)localObject;
        if (paramString != null) {
          break label129;
        }
        a((DiscussionInfoCardActivity.ViewHolder)localObject, null, false);
      }
    }
    label129:
    while (!paramString.equals(((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
    {
      paramInt1 += 1;
      break label72;
      break;
    }
    ((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void p()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void q()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mCanSearchByKeywords) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mCanSearchByTroopUin)) {
        localView.setVisibility(0);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void r()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      GroupCatalogTool.a(localContext).a(str, null);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695214);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692187);
    ChatSettingForTroop.54 local54 = new ChatSettingForTroop.54(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, local54);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695183, local54);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void t()
  {
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "updateNick use cache");
      }
      a(localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin()));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "updateNick async");
    }
    ThreadManager.post(new ChatSettingForTroop.56(this, localTroopManager), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */