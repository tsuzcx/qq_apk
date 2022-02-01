package com.tencent.mobileqq.activity;

import Wallet.PfaFriend;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.DisplayData;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.IForwardRecentListAdapterCallback;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardChooseFriendOption;
import com.tencent.mobileqq.forward.ForwardConstants;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.forward.ForwardH5PTVOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.forward.ForwardStructingMsgOption;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager.TopayListener;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCClient;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RoutePage(desc="跳转最近选择框", path="/base/forwardRecent")
public class ForwardRecentActivity
  extends ForwardBaseActivity
  implements ForwardConstants, IToPayManager.TopayListener
{
  public static final String ACTION_BIND_FINISH = "ForwardEntranceActivity";
  public static final String CALL_BY_FORWARD = "call_by_forward";
  public static final String FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE = "forward_ability_entrence_show_in_share";
  public static final int FORWARD_SELECTION_REQUEST = 20000;
  public static final String FORWARD_SEND_TO_UIN = "forward_send_to_uin";
  protected static final String FORWARD_SHARE_CARD = "forward_share_card";
  public static final int FORWARD_TO_QZONE = 10;
  public static final String KEY_DIRECT_JUMP_QZONE_SHUOSHUO = "key_direct_jump_qzone_shuoshuo";
  protected static final String KEY_FILE = "forward_thumb";
  public static final String KEY_FORWARD_BUSINESS_ID = "key_forward_business_id";
  public static final String KEY_FORWARD_FROM_MSGTAB_CAMERA = "key_forward_from_msgtab_camera";
  public static final String KEY_FORWARD_GUILD_SHARE_FROM_MINI = "key_forward_guild_share_from_mini";
  public static final String KEY_FORWARD_IMAGE_SHARE = "key_forward_image_share";
  public static final String KEY_FORWARD_IMAGE_SHARE_APPID = "key_forward_image_share_appid";
  public static final String KEY_FORWARD_IMAGE_SHARE_TITLE = "key_forward_image_share_title";
  public static final String KEY_FORWARD_IMAGE_SHARE_UIN_TYPE = "key_forward_image_share_uin_type";
  public static final String KEY_FORWARD_SHARE = "key_forward_share";
  public static final String KEY_FORWARD_SHARE_TITLE = "key_forward_share_title";
  public static final String KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS = "k_forward_show_direct_share_tips";
  public static final String KEY_FORWARD_TITLE = "k_forward_title";
  public static final String KEY_JUMP_FROM_QZONE_FEED = "key_jump_from_qzone_feed";
  public static final String KEY_JUMP_FROM_QZONE_FEED_LEFT_TITLE = "key_jump_from_qzone_feed_left_title";
  private static final String KEY_QCIRCLE_CLICK = "key_qcircle_click";
  private static final String KEY_QCIRCLE_FORWARD = "key_qcircle_forward";
  public static final String KEY_SHOW_CANCEL_BUTTON = "k_cancel_button";
  protected static final String KEY_TEXT = "forward_text";
  protected static final String KEY_TYPE = "forward_type";
  public static final String PARAM_BIND_FINISH = "param_bind_finish";
  public static final String PARAM_SELECTED_TARGET_LIST = "selected_target_list";
  public static final int REQUEST_CODE_CREATE_DISCUSSION = 20003;
  public static final int REQUEST_CODE_FORWARD_TO_QZONE = 20005;
  public static final int REQUEST_CODE_SEND_HONG_BAO = 20002;
  public static final int REQUEST_CODE_TAKE_STORY = 20004;
  public static final int REQ_CODE_PRESENT_BOOK = 20001;
  public static final String SELECTION_MODE = "selection_mode";
  public static final int SELECTION_MODE_MULTI = 2;
  public static final int SELECTION_MODE_SINGE = 1;
  private static final int STATUS_DEFAULT = 0;
  private static final int STATUS_MULTI_SELECT = 1;
  static final String TAG = "ForwardOption.ForwardEntranceActivity";
  public static final String TYPE_IS_MULTI_SELECTION = "is_multi_selection";
  public static final String TYPE_ONLY_SINGLE_SELECTION = "only_single_selection";
  private static int k16dp = ViewUtils.dpToPx(16.0F);
  String appid = "";
  private BroadcastReceiver bindFinishReceiver;
  private String businessId;
  FormItemRelativeLayout contactLayout;
  Uri dataUri;
  TipsBar directShareTips;
  private View.OnClickListener directShareTipsCloseListener = new ForwardRecentActivity.25(this);
  Bundle extra;
  protected List<RecentUser> forwardlist;
  FormItemRelativeLayout friendLayout;
  private FriendListObserver friendListObserver = new ForwardRecentActivity.12(this);
  String fromPkgName;
  FormItemRelativeLayout guildContactsLayout;
  boolean isForConfessDirectFriends = false;
  boolean isSdkShare = false;
  private boolean isShowInSare = false;
  TextView leftButton;
  int mBusinessSubType = 0;
  int mBusinessType = 0;
  String mCallActivity;
  private int mCurrentStatus = 0;
  private DataSetObserver mDataSetObserver;
  private LinearLayout mEntryContentContainer;
  private View mEntryHeader;
  private IFaceDecoder mFaceDecoder;
  private Dialog mForwardCountLimitDialog;
  private ForwardRecentItemView mForwardGuildItemView;
  private ForwardRecentItemView mForwardIpadItemView;
  ForwardBaseOption mForwardOption = null;
  private ForwardRecentItemView mForwardPcItemView;
  private ForwardRecentListAdapter.IForwardRecentListAdapterCallback mForwardRecentListAdapterCallback = new ForwardRecentActivity.17(this);
  private Map<String, ResultRecord> mForwardTargetMap = new LinkedHashMap();
  private IQQGuildService mGuildService;
  private InputMethodManager mImm;
  private AutomatorObserver mInitObserver = new ForwardRecentActivity.15(this);
  boolean mIsForConfess = false;
  boolean mIsFromAIO = false;
  boolean mIsFromDatalineAIO = false;
  boolean mIsFromMini = false;
  boolean mIsFromShare = false;
  boolean mIsFromWeb = false;
  private boolean mIsShowGuildEntrance;
  boolean mIsToPayList = false;
  private boolean mJumpQzoneShuoshuoDirect = false;
  private XListView mListView;
  LinearLayout mLlRoot;
  boolean mNeedShareCallback = false;
  boolean mNeedShowDirectShareTips = false;
  private ContactSearchResultPresenter.OnActionListener mOnActionListener = new ForwardRecentActivity.22(this);
  boolean mOnlySingleSelection = false;
  protected int mReq = -1;
  RelativeLayout mRlTitleBar;
  private ContactSearchFragment mSearchFragment;
  FrameLayout mSearchResultLayout;
  SelectedAndSearchBar mSelectedAndSearchBar;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback mSelectedAndSearchBarCallback = new ForwardRecentActivity.21(this);
  int miniAppShareFrom = -1;
  FormItemRelativeLayout multiChatLayout;
  private View.OnClickListener onClick = new ForwardRecentActivity.11(this);
  private BroadcastReceiver qqBroadcastReceiver;
  private View.OnClickListener qzoneEntryOnClickListener = new ForwardRecentActivity.26(this);
  FormItemRelativeLayout qzoneLayout;
  private ForwardRecentListAdapter recentAdapter;
  TextView recommendTv;
  TextView rightButton;
  View searchBox;
  private TextView title;
  private IToPayManager topayManager;
  FormItemRelativeLayout troopDiscussionLayout;
  private TroopMngObserver troopMngObserver = new ForwardRecentActivity.13(this);
  private TroopObserver troopObserver = new ForwardRecentActivity.14(this);
  int uinType;
  
  private boolean add2ForwardTargetList(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    Object localObject = getForwardTargetKey(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.mForwardTargetMap.get(localObject);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.mForwardTargetMap.values());
      this.mSelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.mForwardTargetMap.size() == 9)
    {
      showForwardCountLimitDialog();
      return false;
    }
    paramResultRecord = ResultRecord.copyResultRecord(paramResultRecord);
    paramResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
    this.mForwardTargetMap.put(localObject, paramResultRecord);
    refreshRightBtn();
    paramResultRecord = new ArrayList(this.mForwardTargetMap.values());
    this.mSelectedAndSearchBar.a(paramResultRecord, true);
    paramResultRecord = new ArrayList();
    localObject = this.mForwardTargetMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramResultRecord.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.mSearchFragment;
    if (localObject != null) {
      ((ContactSearchFragment)localObject).a(paramResultRecord, paramResultRecord);
    }
    return true;
  }
  
  private void addDatalineEntry()
  {
    this.mForwardPcItemView = new ForwardRecentItemView(this);
    ResultRecord localResultRecord1 = new ResultRecord(AppConstants.DATALINE_PC_UIN, HardCodeUtil.a(2131892059), 6000, "", "");
    this.mForwardPcItemView.a(HardCodeUtil.a(2131892059), "", getResources().getDrawable(2130845599), localResultRecord1, false, false);
    this.mForwardPcItemView.setOnClickListener(new ForwardRecentActivity.5(this, localResultRecord1));
    this.mListView.addHeaderView(this.mForwardPcItemView);
    if (((RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).f() != 0)
    {
      this.mForwardIpadItemView = new ForwardRecentItemView(this);
      ResultRecord localResultRecord2 = new ResultRecord(AppConstants.DATALINE_IPAD_UIN, "我的iPad", 6003, "", "");
      this.mForwardIpadItemView.a("我的iPad", "", getResources().getDrawable(2130845594), localResultRecord2, false, false);
      this.mForwardIpadItemView.setOnClickListener(new ForwardRecentActivity.6(this, localResultRecord1));
      this.mListView.addHeaderView(this.mForwardIpadItemView);
    }
  }
  
  private void addGuildEntry()
  {
    this.mForwardGuildItemView = new ForwardRecentItemView(this);
    Object localObject = new ResultRecord(AppConstants.DATALINE_GUILD_UIN, HardCodeUtil.a(2131896942), 10014, "", "");
    this.mForwardGuildItemView.a(HardCodeUtil.a(2131896942), "", getResources().getDrawable(2130841030), (ResultRecord)localObject, false, false);
    localObject = getResources().getDrawable(2130839446);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
    this.mForwardGuildItemView.b.setCompoundDrawables(null, null, (Drawable)localObject, null);
    this.mForwardGuildItemView.b.getLayoutParams().width = -1;
    changeMarginRight(this.mForwardGuildItemView.b, k16dp);
    this.mForwardGuildItemView.setOnClickListener(new ForwardRecentActivity.4(this));
    this.mListView.addHeaderView(this.mForwardGuildItemView);
  }
  
  private void addSmartDeviceEntry()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (localSmartDeviceProxyMgr.c())
    {
      DeviceInfo[] arrayOfDeviceInfo = localSmartDeviceProxyMgr.e();
      if (arrayOfDeviceInfo != null)
      {
        if (arrayOfDeviceInfo.length <= 0) {
          return;
        }
        arrayOfDeviceInfo = this.mForwardOption.a(arrayOfDeviceInfo);
        if (arrayOfDeviceInfo != null)
        {
          int j = arrayOfDeviceInfo.length;
          int i = 0;
          while (i < j)
          {
            DeviceInfo localDeviceInfo = arrayOfDeviceInfo[i];
            if ((localDeviceInfo.isAdmin != 2) && ((!localSmartDeviceProxyMgr.c(localDeviceInfo.din)) || (localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17))))
            {
              ForwardRecentItemView localForwardRecentItemView = new ForwardRecentItemView(this);
              String str = SmartDeviceUtil.a(localDeviceInfo);
              ResultRecord localResultRecord = new ResultRecord(String.valueOf(localDeviceInfo.din), str, 9501, "", "");
              localForwardRecentItemView.a(str, "", new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(String.valueOf(localDeviceInfo.din))), localResultRecord, false, false);
              localForwardRecentItemView.setOnClickListener(new ForwardRecentActivity.7(this, localDeviceInfo, localForwardRecentItemView, localResultRecord, super.getResources(), str));
              this.mListView.addHeaderView(localForwardRecentItemView);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void adjustEntryLayout()
  {
    if ((!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.c)) && (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.d)) && (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.e)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
      }
      localForwardBaseOption = this.mForwardOption;
      if ((!(localForwardBaseOption instanceof ForwardChooseFriendOption)) || (localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.m)))
      {
        this.mListView.removeHeaderView(this.mEntryHeader);
        return;
      }
    }
    if (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.c))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
      }
      this.friendLayout.setVisibility(8);
    }
    if (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.i))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support phone contacts forward, set contactBtn gone");
      }
      this.contactLayout.setVisibility(8);
      this.mEntryHeader.findViewById(2131436080).setVisibility(8);
    }
    if ((!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.d)) || (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.m)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
      }
      this.multiChatLayout.setVisibility(8);
    }
    if ((!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.d)) && (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.e)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
      }
      this.troopDiscussionLayout.setVisibility(8);
    }
    ForwardBaseOption localForwardBaseOption = this.mForwardOption;
    if ((localForwardBaseOption instanceof ForwardH5PTVOption))
    {
      if ((!localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) && (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
        }
        this.friendLayout.setVisibility(8);
        this.multiChatLayout.setVisibility(8);
      }
      if (!this.mForwardOption.a(ForwardAbility.ForwardAbilityType.c))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends");
        }
        this.friendLayout.setVisibility(8);
        this.multiChatLayout.setVisibility(8);
      }
    }
    localForwardBaseOption = this.mForwardOption;
    if (((localForwardBaseOption instanceof ForwardChooseFriendOption)) && (!localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.m))) {
      this.multiChatLayout.setVisibility(0);
    }
  }
  
  private void attachQCircleReportParam(boolean paramBoolean)
  {
    if (isNotQCircleForwardFlow()) {
      return;
    }
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    Object localObject = this.mForwardOption;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ForwardBaseOption)localObject).al();
    }
    if (localObject != null)
    {
      localBundle.putInt("uintype", ((Bundle)localObject).getInt("uintype"));
      localBundle.putString("uin", ((Bundle)localObject).getString("uin"));
      localBundle.putString("uinname", ((Bundle)localObject).getString("uinname"));
      localBundle.putBoolean("key_qcircle_click", paramBoolean);
      localIntent.putExtras(localBundle);
    }
  }
  
  private void bindFinishReceiver(Intent paramIntent)
  {
    if (this.isSdkShare)
    {
      initBindFinishReceiver();
      paramIntent.putExtra("param_bind_finish", true);
    }
  }
  
  private void bindSelectAndSearchBarData()
  {
    if (this.mFaceDecoder == null) {
      this.mFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    }
    if (this.mGuildService == null) {
      this.mGuildService = ((IQQGuildService)this.app.getRuntimeService(IQQGuildService.class, ""));
    }
    this.mSelectedAndSearchBar.a(null, this.mFaceDecoder, this.mSelectedAndSearchBarCallback, this.mGuildService);
  }
  
  private static void changeMarginRight(@NonNull View paramView, int paramInt)
  {
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, paramInt, localMarginLayoutParams.bottomMargin);
      paramView.requestLayout();
    }
  }
  
  private void clearForwardTarget()
  {
    this.mForwardTargetMap.clear();
  }
  
  private RecentUser createNewVersionDatalineEntry()
  {
    RecentUser localRecentUser = new RecentUser("3636666661", 0);
    localRecentUser.displayName = getString(2131896189);
    return localRecentUser;
  }
  
  private void forward2MultiTargets()
  {
    if (this.mForwardTargetMap.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, "forward2MultiTargets no forward target !");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(this.mForwardTargetMap.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.p.intValue());
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    localBundle.putBoolean("from_outside_share", this.mIsFromShare);
    localBundle.putBoolean("from_dataline_aio", this.mIsFromDatalineAIO);
    this.mForwardOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
    this.mForwardOption.v();
  }
  
  private String getBusinessId()
  {
    if (TextUtils.isEmpty(this.businessId)) {
      this.businessId = getIntent().getStringExtra("key_forward_business_id");
    }
    if (TextUtils.isEmpty(this.businessId)) {
      this.businessId = "other";
    }
    return this.businessId;
  }
  
  private DatalineDeviceChooseModel getDeviceChooseModel()
  {
    Object localObject1 = getIntent();
    Object localObject2 = new ArrayList();
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)((Intent)localObject1).getParcelableExtra("fileinfo");
    if (localForwardFileInfo != null)
    {
      ((ArrayList)localObject2).add(localForwardFileInfo);
      return DatalineDeviceChooseModel.a((ArrayList)localObject2);
    }
    localObject1 = ((Intent)localObject1).getParcelableArrayListExtra("fileinfo_array");
    if (localObject1 != null) {
      return DatalineDeviceChooseModel.a((ArrayList)localObject1);
    }
    localObject1 = this.mForwardOption;
    if ((localObject1 != null) && ((localObject1 instanceof ForwardFileOption)))
    {
      localObject1 = (ForwardFileOption)localObject1;
      if (((ForwardFileOption)localObject1).t()) {
        return DatalineDeviceChooseModel.a((ForwardFileOption)localObject1);
      }
    }
    localObject1 = MultiMsgManager.a().i();
    localObject2 = DatalineDeviceChooseModel.b((List)localObject1);
    if (((List)localObject1).size() > 1) {
      ((DatalineDeviceChooseModel)localObject2).a();
    }
    return localObject2;
  }
  
  public static String getFilePath(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str != null) && (!str.equals("file")))
    {
      if (str.equals("content")) {
        try
        {
          paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          int i = paramContext.getColumnIndexOrThrow("_data");
          paramContext.moveToFirst();
          paramUri = paramContext.getString(i);
          paramContext.close();
          return paramUri;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      return null;
    }
    return new File(paramUri.getPath()).getAbsolutePath();
  }
  
  private List<RecentUser> getForwardRecentList(List<RecentUser> paramList)
  {
    return this.mForwardOption.a(paramList);
  }
  
  private String getForwardTargetKey(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private int getReportFromType()
  {
    if (this.mIsFromShare) {
      return 2;
    }
    if (this.mIsFromWeb) {
      return 3;
    }
    return 1;
  }
  
  private ArrayList<ResultRecord> getResultRecord()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getResultRecord() called #this = ");
      ((StringBuilder)localObject1).append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    ListAdapter localListAdapter = this.mListView.getAdapter();
    int j = localListAdapter.getCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localListAdapter.getItem(i);
      if ((localObject2 instanceof ForwardRecentListAdapter.DisplayData))
      {
        localObject2 = (ForwardRecentListAdapter.DisplayData)localObject2;
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = ((ForwardRecentListAdapter.DisplayData)localObject2).c;
        if (((ForwardRecentListAdapter.DisplayData)localObject2).d != null) {
          localResultRecord.type = ((ForwardRecentListAdapter.DisplayData)localObject2).d.getType();
        }
        int k = localResultRecord.type;
        boolean bool = true;
        if ((k != 1) || (TroopUtils.b(localResultRecord.uin))) {
          bool = false;
        }
        localResultRecord.isNewTroop = bool;
        localResultRecord.name = ((ForwardRecentListAdapter.DisplayData)localObject2).a;
        ((ArrayList)localObject1).add(localResultRecord);
      }
      i += 1;
    }
    return localObject1;
  }
  
  private void initBindFinishReceiver()
  {
    if (this.bindFinishReceiver == null)
    {
      this.bindFinishReceiver = new ForwardRecentActivity.9(this);
      registerReceiver(this.bindFinishReceiver, new IntentFilter("ForwardEntranceActivity"));
    }
  }
  
  private void initBroadcastReceiver()
  {
    if (this.qqBroadcastReceiver == null)
    {
      this.qqBroadcastReceiver = new ForwardRecentActivity.8(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.qqBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void initData() {}
  
  private void initEntryHeaderView()
  {
    this.mEntryHeader = LayoutInflater.from(this).inflate(2131624867, this.mListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.mEntryHeader.setOverScrollMode(2);
    }
    if (this.uinType != 9501) {
      this.mListView.addHeaderView(this.mEntryHeader);
    }
    this.mEntryContentContainer = ((LinearLayout)this.mEntryHeader.findViewById(2131437449));
    this.friendLayout = ((FormItemRelativeLayout)this.mEntryHeader.findViewById(2131433619));
    this.contactLayout = ((FormItemRelativeLayout)this.mEntryHeader.findViewById(2131433623));
    this.troopDiscussionLayout = ((FormItemRelativeLayout)this.mEntryHeader.findViewById(2131433627));
    this.guildContactsLayout = ((FormItemRelativeLayout)this.mEntryHeader.findViewById(2131433620));
    this.multiChatLayout = ((FormItemRelativeLayout)this.mEntryHeader.findViewById(2131433622));
    this.qzoneLayout = ((FormItemRelativeLayout)this.mEntryHeader.findViewById(2131433624));
    this.directShareTips = ((TipsBar)this.mEntryHeader.findViewById(2131446855));
    this.friendLayout.setBGType(1);
    this.troopDiscussionLayout.setBGType(2);
    this.multiChatLayout.setBGType(3);
    this.guildContactsLayout.setBGType(2);
    this.contactLayout.setBGType(2);
    this.qzoneLayout.setBGType(0);
    this.friendLayout.setBackgroundResource(2130839572);
    this.contactLayout.setBackgroundResource(2130839572);
    this.troopDiscussionLayout.setBackgroundResource(2130839572);
    this.guildContactsLayout.setBackgroundResource(2130839572);
    this.multiChatLayout.setBackgroundResource(2130839572);
    this.qzoneLayout.setBackgroundResource(2130839572);
    this.directShareTips.setBackgroundResource(2130839572);
    this.friendLayout.setOnClickListener(this.onClick);
    this.troopDiscussionLayout.setOnClickListener(this.onClick);
    this.guildContactsLayout.setOnClickListener(this.onClick);
    this.contactLayout.setOnClickListener(this.onClick);
    this.multiChatLayout.setOnClickListener(this.onClick);
    this.qzoneLayout.setOnClickListener(this.qzoneEntryOnClickListener);
    this.directShareTips.setCloseListener(this.directShareTipsCloseListener);
    View localView = LayoutInflater.from(this).inflate(2131624546, null);
    localView.setFocusable(true);
    this.recommendTv = ((TextView)localView.findViewById(2131448393));
    if (this.mIsToPayList) {
      this.recommendTv.setText(2131889676);
    } else {
      this.recommendTv.setText(2131889675);
    }
    if (this.mOnlySingleSelection)
    {
      this.friendLayout.setVisibility(0);
      this.contactLayout.setVisibility(0);
      this.troopDiscussionLayout.setVisibility(0);
      this.multiChatLayout.setVisibility(0);
      if ((!this.mIsShowGuildEntrance) && (!this.mIsFromMini) && (!this.mIsFromWeb)) {
        this.guildContactsLayout.setVisibility(8);
      } else {
        this.guildContactsLayout.setVisibility(0);
      }
    }
    else
    {
      this.friendLayout.setVisibility(8);
      this.contactLayout.setVisibility(8);
      this.troopDiscussionLayout.setVisibility(8);
      this.multiChatLayout.setVisibility(0);
      this.guildContactsLayout.setVisibility(8);
    }
    this.mListView.addHeaderView(localView);
  }
  
  private void initSelectMode(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("caller_name");
    boolean bool2 = false;
    int i = paramIntent.getIntExtra("selection_mode", 0);
    if (i == 2)
    {
      this.mOnlySingleSelection = false;
      return;
    }
    if (i == 1)
    {
      this.mOnlySingleSelection = true;
      return;
    }
    if (("SplashActivity".equals(str)) || ("ChatActivity".equals(str)) || ("LiteActivity".equals(str)) || ("ChatHistoryActivity".equals(str))) {
      this.mIsFromAIO = true;
    }
    boolean bool1;
    if ((!paramIntent.getBooleanExtra("only_single_selection", false)) && (this.mForwardOption.l()))
    {
      bool1 = bool2;
      if (!this.mIsFromAIO)
      {
        bool1 = bool2;
        if (!this.mIsFromWeb)
        {
          bool1 = bool2;
          if (!this.mForwardOption.ac()) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    this.mOnlySingleSelection = bool1;
  }
  
  private void initSelectedAndSearchBar()
  {
    this.mImm = ((InputMethodManager)getSystemService("input_method"));
    this.mSelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131445550));
    this.mSelectedAndSearchBar.b(0L);
    this.mSelectedAndSearchBar.a(new ForwardRecentActivity.23(this));
  }
  
  private void initTitleBtn()
  {
    this.rightButton = ((TextView)super.findViewById(2131436211));
    this.leftButton = ((TextView)super.findViewById(2131436182));
    if (!this.mOnlySingleSelection)
    {
      this.rightButton.setVisibility(0);
      this.rightButton.setText(HardCodeUtil.a(2131902775));
      this.rightButton.setOnClickListener(this.onClick);
      this.leftButton.setVisibility(0);
      this.leftButton.setOnClickListener(this.onClick);
      this.leftButton.setText(HardCodeUtil.a(2131902780));
    }
    else
    {
      this.leftButton.setVisibility(8);
      this.rightButton.setVisibility(0);
      this.rightButton.setText(HardCodeUtil.a(2131898212));
      this.rightButton.setOnClickListener(this.onClick);
    }
    Object localObject = (RelativeLayout.LayoutParams)this.rightButton.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(10.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(75.0F, getResources());
    }
    this.rightButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.rightButton.setPadding(AIOUtils.b(7.0F, getResources()), 0, AIOUtils.b(7.0F, getResources()), 0);
    if (AppSetting.e)
    {
      localObject = this.rightButton;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      localObject = this.leftButton;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
  }
  
  private void initViews()
  {
    this.mLlRoot = ((LinearLayout)super.findViewById(2131445137));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.mLlRoot.setFitsSystemWindows(true);
      this.mLlRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mRlTitleBar = ((RelativeLayout)super.findViewById(2131445043));
    super.findViewById(2131436180).setVisibility(8);
    super.findViewById(2131436194).setVisibility(8);
    this.title = ((TextView)super.findViewById(2131436227));
    this.title.setText(this.mForwardOption.u());
    initTitleBtn();
    initSelectedAndSearchBar();
    this.mSearchResultLayout = ((FrameLayout)super.findViewById(2131444724));
    if (AppSetting.e) {
      AccessibilityUtil.b(this.rightButton, Button.class.getName());
    }
    this.mListView = ((XListView)super.findViewById(2131437281));
    if (AppSetting.e) {
      ViewCompat.setImportantForAccessibility(this.mListView, 2);
    }
    this.searchBox = LayoutInflater.from(this).inflate(2131629215, this.mListView, false);
    this.searchBox.findViewById(2131429816).setVisibility(8);
    Object localObject = (EditText)this.searchBox.findViewById(2131432634);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this.onClick);
    ((EditText)localObject).setCursorVisible(false);
    this.mListView.addHeaderView(this.searchBox);
    initEntryHeaderView();
    if ((this.mForwardOption.a(ForwardAbility.ForwardAbilityType.g)) && (!QFileAssistantUtils.a(this.app))) {
      addDatalineEntry();
    }
    if (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.k)) {
      addSmartDeviceEntry();
    }
    if ((this.mIsShowGuildEntrance) && (!this.mOnlySingleSelection)) {
      addGuildEntry();
    }
    if ((this.mForwardOption.a(ForwardAbility.ForwardAbilityType.f)) && (!this.isShowInSare))
    {
      this.qzoneLayout.setVisibility(0);
      ReportController.b(this.app, "CliOper", "", "", "friendchoose", "0X800A2D6", getReportFromType(), 0, "", "", "", getBusinessId());
    }
    else
    {
      this.qzoneLayout.setVisibility(8);
    }
    if (getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("forward_share_card", true)) {
      this.mEntryHeader.findViewById(2131436080).setVisibility(0);
    }
    localObject = this.directShareTips;
    if (localObject != null) {
      if (this.mNeedShowDirectShareTips)
      {
        ((TipsBar)localObject).setVisibility(0);
        localObject = TencentDocMyFileNameProcessor.a();
        if ((localObject != null) && (!TextUtils.isEmpty(((TencentDocMyFileNameBean)localObject).e))) {
          this.directShareTips.setTipsText(((TencentDocMyFileNameBean)localObject).e);
        }
      }
      else
      {
        ((TipsBar)localObject).setVisibility(8);
      }
    }
    int i = this.mReq;
    if ((1 == i) || (2 == i)) {
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ForwardRecentActivity.2(this));
    }
  }
  
  private boolean isForwardTargetSelected(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.mForwardTargetMap.containsKey(getForwardTargetKey(paramString, paramInt));
  }
  
  private boolean isMultiSelectStatus()
  {
    return this.mCurrentStatus == 1;
  }
  
  private boolean isNotQCircleForwardFlow()
  {
    Object localObject = getIntent();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Intent)localObject).getExtras();
    }
    boolean bool = false;
    if ((localObject == null) || (!((Bundle)localObject).getBoolean("key_qcircle_forward", false))) {
      bool = true;
    }
    return bool;
  }
  
  private void notifyForwardRecentItemClick()
  {
    if (isNotQCircleForwardFlow()) {
      return;
    }
    attachQCircleReportParam(true);
    notifyResultReceiver(getIntent(), this);
  }
  
  public static void notifyResultReceiver(Intent paramIntent, Object paramObject)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramObject != null))
    {
      boolean bool = paramObject instanceof Activity;
      int i = 0;
      if (bool) {
        bool = ((Activity)paramObject).isFinishing();
      } else {
        bool = false;
      }
      if (!bool)
      {
        ResultReceiver localResultReceiver = (ResultReceiver)paramIntent.getParcelableExtra("PARAM_ActivityResultReceiver");
        if (localResultReceiver != null)
        {
          try
          {
            Field localField = Activity.class.getDeclaredField("mResultCode");
            localField.setAccessible(true);
            int j = ((Integer)localField.get(paramObject)).intValue();
            i = j;
          }
          catch (Exception paramObject)
          {
            QLog.w("ForwardOption.ForwardEntranceActivity", 1, "finish, get mResultCode fail", paramObject);
          }
          catch (NoSuchFieldException paramObject)
          {
            QLog.w("ForwardOption.ForwardEntranceActivity", 1, "finish, get mResultCode NoSuchFieldException", paramObject);
          }
          if (QLog.isDevelopLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("notifyResultReceiver, resultReceiver[");
            paramObject.append(localResultReceiver);
            paramObject.append("]");
            QLog.w("ForwardOption.ForwardEntranceActivity", 1, paramObject.toString(), new Throwable("打印调用栈"));
          }
          localResultReceiver.send(i, paramIntent.getExtras());
        }
      }
    }
  }
  
  private void onFileAssistantItemCLickedInMultiSelectStatus(ResultRecord paramResultRecord, ForwardRecentItemView paramForwardRecentItemView, boolean paramBoolean)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = getDeviceChooseModel();
    if (paramBoolean) {
      localDatalineDeviceChooseModel.a();
    }
    localDatalineDeviceChooseModel.a(this, paramResultRecord.uin, new ForwardRecentActivity.18(this, paramResultRecord, paramForwardRecentItemView, paramBoolean));
  }
  
  private void onFileAssistantItemClickedInDefaultStatus(ResultRecord paramResultRecord, ForwardRecentItemView paramForwardRecentItemView)
  {
    getDeviceChooseModel().a(this, paramResultRecord.uin, new ForwardRecentActivity.16(this, paramResultRecord, paramForwardRecentItemView));
  }
  
  private void onListViewItemClickedInMultiSelectStatus(View paramView)
  {
    paramView = (ForwardRecentItemView)paramView;
    ResultRecord localResultRecord = paramView.k;
    boolean bool = isForwardTargetSelected(localResultRecord.uin, localResultRecord.getUinType());
    if (!QFileAssistantUtils.a(localResultRecord.uin))
    {
      setListItemSelected(localResultRecord, paramView, bool);
      return;
    }
    onFileAssistantItemCLickedInMultiSelectStatus(localResultRecord, paramView, bool);
  }
  
  private void openForwardDialog(ResultRecord paramResultRecord, ForwardRecentItemView paramForwardRecentItemView)
  {
    int i;
    if ((this.isSdkShare) && (paramResultRecord != null))
    {
      i = paramResultRecord.getUinType();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 3000) {
            ReportCenter.a().a(this.app.getAccount(), "", this.appid, "1000", "32", "0", false, this.isSdkShare);
          }
        }
        else {
          ReportCenter.a().a(this.app.getAccount(), "", this.appid, "1000", "31", "0", false, this.isSdkShare);
        }
      }
      else {
        ReportCenter.a().a(this.app.getAccount(), "", this.appid, "1000", "30", "0", false, this.isSdkShare);
      }
    }
    if (paramResultRecord != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("uintype", paramResultRecord.getUinType());
      localBundle.putString("uin", paramResultRecord.uin);
      localBundle.putString("troop_uin", paramResultRecord.groupUin);
      localBundle.putString("guild_id", paramResultRecord.guildId);
      if (paramResultRecord.getUinType() == 3000)
      {
        localBundle.putString("uinname", ForwardUtils.a(this.app, paramForwardRecentItemView.h, paramResultRecord.uin));
      }
      else if (paramResultRecord.getUinType() == 1)
      {
        i = getIntent().getIntExtra("forward_type", -1);
        localBundle.putString("uinname", ForwardUtils.a(this.app, paramResultRecord.uin, i, paramForwardRecentItemView.h));
      }
      else
      {
        localBundle.putString("uinname", paramForwardRecentItemView.h);
      }
      localBundle.putBoolean("forward_report_confirm", true);
      localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
      localBundle.putString("forward_report_confirm_reverse2", "5");
      localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.p.intValue());
      localBundle.putString("caller_name", this.mCallActivity);
      if ((getIntent() != null) && (getIntent().getExtras() != null))
      {
        localBundle.putBoolean("needShareCallBack", getIntent().getExtras().getBoolean("needShareCallBack"));
        localBundle.putInt("miniAppShareFrom", getIntent().getExtras().getInt("miniAppShareFrom"));
      }
      QFileAssistantUtils.a(this.app, getIntent(), localBundle);
      this.mForwardOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
      this.mForwardOption.v();
      if ((paramResultRecord.getUinType() == 3000) || (paramResultRecord.getUinType() == 1)) {
        new ReportTask(this.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "0" }).a();
      }
      ReportController.b(this.app, "CliOper", "", "", "friendchoose", "0X8009D90", getReportFromType(), 0, "", "", "", getBusinessId());
      notifyForwardRecentItemClick();
    }
  }
  
  private void popupSearchDialog(int paramInt)
  {
    if (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.c)) {
      i = 33;
    } else {
      i = 32;
    }
    paramInt = i;
    if (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.i)) {
      paramInt = i | 0x100;
    }
    int i = paramInt;
    if (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.j)) {
      i = paramInt | 0x4;
    }
    paramInt = i;
    if (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.e)) {
      paramInt = i | 0x8;
    }
    i = paramInt;
    if (this.mForwardOption.a(ForwardAbility.ForwardAbilityType.d)) {
      i = paramInt | 0x10 | 0x200000 | 0x400000;
    }
    long l = -1L;
    if ((this.mForwardOption instanceof ForwardStructingMsgOption)) {
      l = 1L;
    }
    ContactSearchComponentActivity.a(this, null, 7, i, 21001, l);
    ReportController.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
  }
  
  private void quitSearchState()
  {
    this.mImm.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.mSelectedAndSearchBar.b();
    this.mSelectedAndSearchBar.c();
    this.mSearchResultLayout.setVisibility(8);
  }
  
  private void refreshRecentList()
  {
    if (this.app.isAccLoginSuccess())
    {
      this.forwardlist = getForwardRecentList(this.app.getProxyManager().g().a(true));
      boolean bool = QLog.isColorLevel();
      int j = 0;
      Object localObject2;
      int i;
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("refreshRecentList 01 forwardList size is: ");
        localObject2 = this.forwardlist;
        if (localObject2 == null) {
          i = 0;
        } else {
          i = ((List)localObject2).size();
        }
        ((StringBuilder)localObject1).append(i);
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.forwardlist != null)
      {
        localObject1 = new ArrayList();
        localObject2 = this.forwardlist.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if ((localRecentUser.lFlag == 16L) || (localRecentUser.getType() == 10005)) {
            ((List)localObject1).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1038) {
            ((List)localObject1).add(localRecentUser);
          }
          if ((this.mIsForConfess) && (TextUtils.equals(localRecentUser.uin, this.app.getCurrentAccountUin()))) {
            ((List)localObject1).add(localRecentUser);
          }
          if (TextUtils.equals(localRecentUser.uin, QFileAssistantUtils.b(this.app))) {
            ((List)localObject1).add(localRecentUser);
          }
          if ((TextUtils.equals(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, localRecentUser.uin)) || (localRecentUser.getType() == 8111) || (localRecentUser.getType() == 8112) || (localRecentUser.getType() == 8113) || (localRecentUser.getType() == 10007) || (localRecentUser.getType() == 10014) || (localRecentUser.getType() == 10015)) {
            ((List)localObject1).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1)
          {
            Object localObject3 = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(localRecentUser.uin, true);
            if ((localObject3 != null) && ((((TroopInfo)localObject3).isKicked()) || (((TroopInfo)localObject3).isDisband())))
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("refreshRecentList, filter troop, recentUser.troopUin =");
                ((StringBuilder)localObject3).append(localRecentUser.troopUin);
                ((StringBuilder)localObject3).append(",recentUser.uin = ");
                ((StringBuilder)localObject3).append(localRecentUser.uin);
                QLog.i("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject3).toString());
              }
              ((List)localObject1).add(localRecentUser);
            }
          }
        }
        this.forwardlist.removeAll((Collection)localObject1);
        if (QFileAssistantUtils.a(this.app))
        {
          localObject1 = createNewVersionDatalineEntry();
          this.forwardlist.add(0, localObject1);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("refreshRecentList forwardList size is: ");
        localObject2 = this.forwardlist;
        if (localObject2 == null) {
          i = j;
        } else {
          i = ((List)localObject2).size();
        }
        ((StringBuilder)localObject1).append(i);
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.recentAdapter;
      if (localObject1 == null)
      {
        if (this.mListView != null)
        {
          this.recentAdapter = new ForwardRecentListAdapter(this, this.app, this.mListView, this.forwardlist, this.mForwardRecentListAdapterCallback);
          this.mListView.setAdapter(this.recentAdapter);
        }
      }
      else {
        ((ForwardRecentListAdapter)localObject1).a(this.forwardlist);
      }
    }
  }
  
  private void refreshRightBtn()
  {
    this.rightButton.setEllipsize(null);
    this.rightButton.setMaxWidth(2147483647);
    if (this.mForwardTargetMap.isEmpty())
    {
      this.rightButton.setText(HardCodeUtil.a(2131902777));
      this.rightButton.setClickable(false);
      this.rightButton.setTextColor(getResources().getColor(2131168014));
    }
    else
    {
      this.rightButton.setText(String.format(HardCodeUtil.a(2131902769), new Object[] { Integer.valueOf(this.mForwardTargetMap.size()) }));
      this.rightButton.setClickable(true);
      this.rightButton.setTextColor(getResources().getColor(2131168013));
    }
    if (AppSetting.e)
    {
      TextView localTextView = this.rightButton;
      localTextView.setContentDescription(localTextView.getText());
    }
  }
  
  private void registerListViewDataSetChangedObserver()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registerListViewDataSetChangedObserver() called #this = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mDataSetObserver == null) {
      this.mDataSetObserver = new ForwardRecentActivity.3(this);
    }
    Object localObject = this.mListView.getAdapter();
    if (localObject != null)
    {
      ((ListAdapter)localObject).registerDataSetObserver(this.mDataSetObserver);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "registerListViewDataSetChangedObserver() adapter is null");
    }
  }
  
  private void removeFromForwardTargetList(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = getForwardTargetKey(paramString, paramInt);
    this.mForwardTargetMap.remove(paramString);
    refreshRightBtn();
    paramString = new ArrayList(this.mForwardTargetMap.values());
    this.mSelectedAndSearchBar.a(paramString, true);
    paramString = new ArrayList();
    Object localObject = this.mForwardTargetMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.mSearchFragment;
    if (localObject != null) {
      ((ContactSearchFragment)localObject).a(paramString, paramString);
    }
  }
  
  private void removeWindowContent()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.setAlpha(0.0F);
    localViewGroup.setBackgroundDrawable(null);
    getWindow().setBackgroundDrawable(null);
    localViewGroup.removeAllViews();
  }
  
  private void reportMiniAppEventByIPC(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  private void reportMiniAppShareFail()
  {
    switch (this.miniAppShareFrom)
    {
    default: 
      return;
    case 12: 
      reportMiniAppEventByIPC("user_click", "more_button", "share_QQ", "fail");
      return;
    case 11: 
      reportMiniAppEventByIPC("user_click", "custom_button", "share_QQ", "fail");
      return;
    }
    reportMiniAppEventByIPC("user_click", "more_about", "share", "fail");
  }
  
  private void setListItemSelected(ResultRecord paramResultRecord, ForwardRecentItemView paramForwardRecentItemView, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onListViewItemClickedInMultiSelectStatus, isSelected = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      paramForwardRecentItemView.a(false);
      removeFromForwardTargetList(paramResultRecord.uin, paramResultRecord.getUinType());
      return;
    }
    if (add2ForwardTargetList(paramResultRecord)) {
      paramForwardRecentItemView.a(true);
    }
  }
  
  private void showForwardCountLimitDialog()
  {
    if (this.mForwardCountLimitDialog == null) {
      this.mForwardCountLimitDialog = DialogUtil.a(this, getString(2131896914), 0, 2131892366, null, new ForwardRecentActivity.24(this));
    }
    if (!isFinishing()) {
      this.mForwardCountLimitDialog.show();
    }
  }
  
  private void startChatAndSendMsg()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject1 = new Bundle(this.mForwardOption.al());
    ((Bundle)localObject1).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject1).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject1).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject1).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject1);
    Object localObject2 = ((Bundle)localObject1).getString("GALLERY.FORWORD_LOCAL_PATH");
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = (SmartDeviceProxyMgr)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    try
    {
      bool = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(localIntent.getStringExtra("uin")), 17);
    }
    catch (Exception localException)
    {
      boolean bool;
      label201:
      break label201;
    }
    bool = false;
    if (bool)
    {
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("sIsCloudPrinter", true);
      PhotoUtils.sendPhoto(this, localIntent, (ArrayList)localObject1, 0, true);
    }
    else
    {
      PhotoUtils.sendPhoto(this, localIntent, (ArrayList)localObject1, 0, false);
    }
    ForwardUtils.a(this.app, 0L);
  }
  
  private void switch2DefaultStatus()
  {
    this.mCurrentStatus = 0;
    quitSearchState();
    this.leftButton.setText(HardCodeUtil.a(2131902780));
    this.rightButton.setText(HardCodeUtil.a(2131902779));
    this.rightButton.setTextColor(getResources().getColor(2131167990));
    this.rightButton.setBackgroundResource(2130853306);
    Object localObject = (RelativeLayout.LayoutParams)this.rightButton.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(36.0F, getResources());
    this.rightButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.rightButton.setTextSize(1, 17.0F);
    this.rightButton.setClickable(true);
    this.searchBox.setVisibility(0);
    this.multiChatLayout.setVisibility(0);
    this.friendLayout.setVisibility(8);
    this.troopDiscussionLayout.setVisibility(8);
    this.guildContactsLayout.setVisibility(8);
    if ((this.mForwardOption.a(ForwardAbility.ForwardAbilityType.f)) && (!this.isShowInSare)) {
      this.qzoneLayout.setVisibility(0);
    } else {
      this.qzoneLayout.setVisibility(8);
    }
    localObject = (FrameLayout.LayoutParams)this.mEntryContentContainer.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = AIOUtils.b(0.0F, getResources());
    this.mEntryContentContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    clearForwardTarget();
    this.mForwardOption.b("forward_multi_target");
    this.mListView.postDelayed(new ForwardRecentActivity.20(this), 1L);
    if (AppSetting.e)
    {
      localObject = this.leftButton;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      localObject = this.rightButton;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    if (this.isSdkShare) {
      togglePCViewStatus(true);
    }
    this.mListView.addHeaderView(this.mForwardGuildItemView);
  }
  
  private void switch2MultiSelectStatus()
  {
    this.mCurrentStatus = 1;
    this.leftButton.setText(HardCodeUtil.a(2131901576));
    this.rightButton.setText(HardCodeUtil.a(2131902778));
    Object localObject = (RelativeLayout.LayoutParams)this.rightButton.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(29.0F, getResources());
    this.rightButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.rightButton.setBackgroundResource(2130846654);
    this.rightButton.setTextSize(1, 14.0F);
    this.rightButton.setTextColor(getResources().getColor(2131168014));
    this.rightButton.setClickable(false);
    this.searchBox.setVisibility(4);
    this.multiChatLayout.setVisibility(8);
    this.friendLayout.setVisibility(0);
    if (this.mIsShowGuildEntrance) {
      this.guildContactsLayout.setVisibility(0);
    } else {
      this.guildContactsLayout.setVisibility(8);
    }
    this.qzoneLayout.setVisibility(8);
    this.troopDiscussionLayout.setVisibility(0);
    this.guildContactsLayout.setBGType(3);
    this.troopDiscussionLayout.setBackgroundResource(2130839572);
    localObject = (FrameLayout.LayoutParams)this.mEntryContentContainer.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = AIOUtils.b(8.0F, getResources());
    this.mEntryContentContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mListView.postDelayed(new ForwardRecentActivity.19(this), 50L);
    if ((this.mFaceDecoder == null) || (this.mGuildService == null)) {
      bindSelectAndSearchBarData();
    }
    localObject = new ArrayList(this.mForwardTargetMap.values());
    this.mSelectedAndSearchBar.a((List)localObject, true);
    if (AppSetting.e)
    {
      localObject = this.leftButton;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      localObject = this.rightButton;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    if (this.isSdkShare)
    {
      togglePCViewStatus(false);
      ForwardUtils.a(this.app, "0X800A733", new String[0]);
    }
    this.mListView.removeHeaderView(this.mForwardGuildItemView);
  }
  
  private void togglePCViewStatus(boolean paramBoolean)
  {
    ForwardRecentItemView localForwardRecentItemView = this.mForwardPcItemView;
    if (localForwardRecentItemView != null) {
      if (paramBoolean) {
        this.mListView.addHeaderView(localForwardRecentItemView);
      } else {
        this.mListView.removeHeaderView(localForwardRecentItemView);
      }
    }
    localForwardRecentItemView = this.mForwardIpadItemView;
    if (localForwardRecentItemView != null)
    {
      if (paramBoolean)
      {
        this.mListView.addHeaderView(localForwardRecentItemView);
        return;
      }
      this.mListView.removeHeaderView(localForwardRecentItemView);
    }
  }
  
  private void unregisterListViewDataSetChangedObserver()
  {
    if (this.mDataSetObserver == null) {
      return;
    }
    ListAdapter localListAdapter = this.mListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    localListAdapter.unregisterDataSetObserver(this.mDataSetObserver);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    Object localObject1;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 102)
      {
        if (paramInt1 != 19001)
        {
          Object localObject2;
          if (paramInt1 != 21001)
          {
            switch (paramInt1)
            {
            default: 
              return;
            case 20005: 
              setResult(-1, paramIntent);
              finish();
              if (this.mJumpQzoneShuoshuoDirect) {
                break;
              }
              ForwardToQzoneUtils.a();
              return;
            case 20004: 
              if (paramIntent == null) {
                break;
              }
              paramIntent = paramIntent.getStringExtra("new_video_extra_info");
              ((ForwardSdkShareOption)this.mForwardOption).a(paramIntent);
              finish();
              overridePendingTransition(0, 0);
              return;
            case 20003: 
              if (paramIntent.getBooleanExtra("select_memeber_single_friend", false))
              {
                localObject1 = paramIntent.getExtras();
                paramInt2 = paramIntent.getIntExtra("select_memeber_single_friend_type", 2);
                paramInt1 = paramInt2;
                if (paramInt2 == 4) {
                  paramInt1 = 1;
                }
                paramInt2 = paramInt1;
                if (paramInt1 == 0) {
                  paramInt2 = 2;
                }
                ((Bundle)localObject1).putBoolean("forward_report_confirm", true);
                ((Bundle)localObject1).putString("forward_report_confirm_action_name", "0X8005A14");
                ((Bundle)localObject1).putString("forward_report_confirm_reverse2", Integer.toString(paramInt2));
                this.mForwardOption.a(ForwardAbility.ForwardAbilityType.c.intValue(), (Bundle)localObject1);
                ReportCenter.a().a(this.app.getAccount(), "", this.appid, "1000", "30", "0", false, this.isSdkShare);
                return;
              }
              localObject1 = paramIntent.getStringExtra("roomId");
              if (!StringUtil.isEmpty((String)localObject1))
              {
                refreshRecentList();
                ReportController.b(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
                paramInt1 = paramIntent.getIntExtra("select_memeber_discussion_memeber_count", 0);
                localObject2 = new Bundle();
                ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
                ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A15");
                ((Bundle)localObject2).putString("forward_report_confirm_reverse2", Integer.toString(paramInt1));
                this.mForwardOption.a((String)localObject1, paramIntent.getStringExtra("discussName"), (Bundle)localObject2);
              }
              ReportCenter.a().a(this.app.getAccount(), "", this.appid, "1000", "32", "0", false, this.isSdkShare);
              return;
            case 20002: 
              this.mForwardOption.a(paramInt1, paramInt2, paramIntent);
              return;
            case 20001: 
              setResult(-1, paramIntent);
              finish();
              return;
            case 20000: 
              if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
                setResult(10, paramIntent);
              } else {
                setResult(-1, paramIntent);
              }
              finish();
              overridePendingTransition(0, 0);
              return;
            }
          }
          else
          {
            paramIntent.putExtra("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.q);
            if (getIntent() != null) {
              bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
            }
            if (bool)
            {
              localObject1 = getIntent().getStringExtra("choose_friend_confirmTitle");
              localObject2 = getIntent().getStringExtra("choose_friend_confirmContent");
              paramIntent.putExtra("choose_friend_needConfirm", bool);
              paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject1);
              paramIntent.putExtra("choose_friend_confirmContent", (String)localObject2);
            }
            SearchUtil.a(paramIntent, this.mForwardOption);
          }
        }
        else
        {
          this.mForwardOption.a(paramInt1, paramInt2, paramIntent);
        }
      }
      else {
        this.mForwardOption.a(paramInt1, paramInt2, paramIntent);
      }
    }
    else if (paramInt2 == 1)
    {
      if (20000 == paramInt1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    else if ((20000 == paramInt1) && (paramInt2 != -1))
    {
      if (this.isForConfessDirectFriends)
      {
        finish();
        return;
      }
      if (paramInt2 == 0)
      {
        localObject1 = null;
        if (paramIntent != null) {
          localObject1 = paramIntent.getParcelableArrayListExtra("selected_target_list");
        }
        if (localObject1 != null)
        {
          this.mForwardTargetMap.clear();
          if (((List)localObject1).isEmpty())
          {
            this.mSelectedAndSearchBar.a((List)localObject1, false);
            this.recentAdapter.notifyDataSetChanged();
            refreshRightBtn();
          }
          else
          {
            Collections.sort((List)localObject1, new ResultRecord.DefaultComparator());
            paramIntent = ((List)localObject1).iterator();
            while (paramIntent.hasNext()) {
              add2ForwardTargetList((ResultRecord)paramIntent.next());
            }
            this.recentAdapter.notifyDataSetChanged();
          }
          paramIntent = this.mForwardPcItemView;
          if (paramIntent != null) {
            paramIntent.a(isForwardTargetSelected(AppConstants.DATALINE_PC_UIN, 6000));
          }
          paramIntent = this.mForwardIpadItemView;
          if (paramIntent != null) {
            paramIntent.a(isForwardTargetSelected(AppConstants.DATALINE_IPAD_UIN, 6003));
          }
        }
      }
    }
    else if ((paramInt2 == 0) && (this.mJumpQzoneShuoshuoDirect) && (paramInt1 == 20005))
    {
      finish();
    }
  }
  
  public void doOnBackPressed()
  {
    if (!isFinishing())
    {
      this.mForwardOption.b(false);
      com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i = this.mReq;
    if ((1 != i) && (2 != i)) {
      setTheme(2131952010);
    }
    super.doOnCreate(paramBundle);
    this.topayManager = ((IToPayManager)QRoute.api(IToPayManager.class));
    this.app.addObserver(this.friendListObserver);
    this.app.addObserver(this.troopMngObserver);
    this.app.addObserver(this.troopObserver);
    this.app.addObserver(this.mInitObserver);
    setContentViewNoTitle(2131624870);
    return doOnCreate_init(paramBundle);
  }
  
  protected boolean doOnCreate_init(Bundle paramBundle)
  {
    paramBundle = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getGuildList();
    Object localObject1;
    if (((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab())
    {
      this.mIsShowGuildEntrance = true;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doOnCreate_init isShowTab equls true and guildSize: ");
        ((StringBuilder)localObject1).append(paramBundle.size());
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramBundle.isEmpty()) {
        ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).refreshGuildList(false);
      }
    }
    this.mForwardOption = ForwardOptionBuilder.a(getIntent(), this.app, this);
    paramBundle = this.mForwardOption;
    boolean bool;
    if (paramBundle != null)
    {
      paramBundle.y();
      if (isFinishing())
      {
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--isFinishing");
        return false;
      }
      this.mForwardOption.an();
      paramBundle = getIntent();
      this.isShowInSare = paramBundle.getBooleanExtra("forward_ability_entrence_show_in_share", false);
      this.mIsFromWeb = paramBundle.getBooleanExtra("isWebCompShare", false);
      this.mIsForConfess = paramBundle.getBooleanExtra("choose_friend_isForConfess", false);
      this.mNeedShareCallback = paramBundle.getBooleanExtra("needShareCallBack", false);
      this.miniAppShareFrom = paramBundle.getIntExtra("miniAppShareFrom", -1);
      this.mNeedShowDirectShareTips = paramBundle.getBooleanExtra("k_forward_show_direct_share_tips", false);
      this.mJumpQzoneShuoshuoDirect = paramBundle.getBooleanExtra("key_direct_jump_qzone_shuoshuo", false);
      if (this.mJumpQzoneShuoshuoDirect)
      {
        localObject1 = paramBundle.getStringExtra("key_forward_business_id");
        bool = paramBundle.hasExtra("file_send_path");
        ForwardToQzoneUtils.a(this.app, this, paramBundle, (String)localObject1, bool);
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--mJumpQzoneShuoshuoDirect==true");
        return true;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        this.uinType = paramBundle.getIntExtra("forward_source_uin_type", 0);
        this.dataUri = paramBundle.getData();
        if (paramBundle.getIntExtra("forward_type", -1) == 11) {
          this.isSdkShare = true;
        }
        this.fromPkgName = paramBundle.getStringExtra("pkg_name");
        long l = paramBundle.getLongExtra("req_share_id", 0L);
        this.mCallActivity = getIntent().getStringExtra("caller_name");
        this.mIsFromShare = getIntent().getBooleanExtra("isFromShare", false);
        this.mIsFromDatalineAIO = getIntent().getBooleanExtra("isFromDataLineAIO", false);
        if (l > 0L) {
          this.appid = String.valueOf(l);
        }
        if ((!this.mIsFromShare) && ((l > 0L) || (this.isSdkShare) || ((!TextUtils.isEmpty(this.fromPkgName)) && (!this.fromPkgName.equals("com.tencent.mobileqq"))))) {
          this.mIsFromShare = true;
        }
        int i = paramBundle.getIntExtra("req_type", 5);
        if (((!this.isSdkShare) && (i != 6)) || (!this.mIsShowGuildEntrance) || (i == 5)) {
          break label1241;
        }
        bool = true;
        this.mIsShowGuildEntrance = bool;
        bool = this.isSdkShare;
        localObject1 = this.fromPkgName;
        localObject3 = this.appid;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(", isFromWeb=");
        localStringBuilder.append(this.mIsFromWeb);
        localStringBuilder.append(", isFromShare=");
        localStringBuilder.append(this.mIsFromShare);
        localStringBuilder.append(", isFromDatalineAIO=");
        localStringBuilder.append(this.mIsFromDatalineAIO);
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, new Object[] { "-->doOnCreate_init--isSdkShare=", Boolean.valueOf(bool), ", pkgName=", localObject1, ", appid=", localObject3, localStringBuilder.toString() });
        initSelectMode(paramBundle);
        this.mBusinessType = paramBundle.getIntExtra("choose_friend_businessType", 0);
        this.mBusinessSubType = paramBundle.getIntExtra("choose_friend_businessSubType", 0);
        if ((this.mBusinessType == 1) && (this.mBusinessSubType > 0) && (this.mBusinessSubType < 3)) {
          this.mIsToPayList = true;
        }
        initData();
        initViews();
        if (this.app.getCurrentAccountUin() == null) {
          finish();
        }
        if (this.mIsToPayList) {
          refreshRecommendList(true);
        } else {
          refreshRecentList();
        }
        this.mForwardOption.m();
        adjustEntryLayout();
        l = paramBundle.getLongExtra("forward_send_to_uin", 0L);
        if (l != 0L) {
          showForwardDialog(l, paramBundle.getStringExtra("forward_send_to_uin_nickname"));
        }
        if ((1 == this.mReq) || (2 == this.mReq)) {
          registerListViewDataSetChangedObserver();
        }
        if (3 == this.mReq) {
          this.mForwardOption.T();
        }
      }
      catch (Exception localException)
      {
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "exception in ForwardRecentActivity", localException);
        finish();
      }
      Object localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("zhuanfa end:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("StructingMsgItemBuildertime", 4, ((StringBuilder)localObject2).toString());
      }
      if (this.mIsToPayList) {
        if ((this.mBusinessType == 1) && (this.mBusinessSubType == 1)) {
          ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.show", 0, 0, "", "", "", "");
        } else if ((this.mBusinessType == 1) && (this.mBusinessSubType == 2)) {
          ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.show", 0, 0, "", "", "", "");
        }
      }
      if (paramBundle.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        ReportController.b(this.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "", "", "", "");
      }
      if (this.mIsForConfess)
      {
        this.isForConfessDirectFriends = true;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("call_by_forward", true);
        localObject3 = this.dataUri;
        if (localObject3 != null) {
          ((Intent)localObject2).setData((Uri)localObject3);
        }
        ((Intent)localObject2).putExtras(this.mForwardOption.al());
        ((Intent)localObject2).putExtras(paramBundle.getExtras());
        ((Intent)localObject2).putExtra("isForConfessDirectFriendsTitle", this.mForwardOption.u());
        ((Intent)localObject2).setClass(this, ForwardFriendListActivity.class);
        ((Intent)localObject2).putExtra("extra_choose_friend", 5);
        startActivityForResult((Intent)localObject2, 20000);
      }
      correctStatusBarHeight();
      ReportController.b(this.app, "CliOper", "", "", "friendchoose", "0X8009D8E", getReportFromType(), 0, "", "", "", "");
      this.mForwardOption.s();
      return true;
      QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--mForwardOption == null");
      finish();
      return false;
      label1241:
      bool = false;
    }
  }
  
  protected void doOnDestroy()
  {
    QQGuildForwardSelectionGuildListAdapter.b();
    this.app.removeObserver(this.friendListObserver);
    this.app.removeObserver(this.troopMngObserver);
    this.app.removeObserver(this.troopObserver);
    this.app.removeObserver(this.mInitObserver);
    if (this.mIsToPayList) {
      this.topayManager.removeObserver(this.app);
    }
    unregisterListViewDataSetChangedObserver();
    Object localObject = this.recentAdapter;
    if (localObject != null)
    {
      ((ForwardRecentListAdapter)localObject).c();
      this.mListView.setAdapter(null);
    }
    localObject = this.mForwardOption;
    if (localObject != null) {
      ((ForwardBaseOption)localObject).ad();
    }
    localObject = this.qqBroadcastReceiver;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    localObject = this.bindFinishReceiver;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    localObject = this.mFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "ForwardOption.ForwardEntranceActivity onNewIntent()");
    }
    int i = 0;
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        if (paramIntent.isEmpty()) {
          return;
        }
        paramIntent = (String)paramIntent.get(0);
        Bundle localBundle = this.mForwardOption.al();
        int j = localBundle.getInt("key_forward_ability_type", 0);
        String str1 = localBundle.getString("uin");
        int k = localBundle.getInt("uintype", -1);
        String str2 = localBundle.getString("troop_uin");
        localBundle.getString("uinname");
        boolean bool2 = localBundle.getBoolean("FORWARD_IS_QZONE_SHARE");
        boolean bool1 = true;
        localBundle.putBoolean("FORWARD_IS_EDITED", true);
        if (bool2)
        {
          if ((j != ForwardAbility.ForwardAbilityType.g.intValue()) && (j != ForwardAbility.ForwardAbilityType.l.intValue()))
          {
            if (j == ForwardAbility.ForwardAbilityType.h.intValue())
            {
              this.mForwardOption.al().putString("forward_filepath", paramIntent);
              this.mForwardOption.al().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
              this.mForwardOption.aa();
              i = 1;
            }
            else
            {
              bool1 = ForwardSendPicUtil.a(this.app, paramIntent, str1, k, str2, true, this);
            }
          }
          else {
            LiteActivity.a(this.app, paramIntent, this);
          }
          if (bool1) {
            setResult(-1);
          } else if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardEntranceActivity", 2, "failed to send pic from qzone");
          }
          if (i == 0) {
            finish();
          }
        }
        else
        {
          if ((j != ForwardAbility.ForwardAbilityType.g.intValue()) && (j != ForwardAbility.ForwardAbilityType.l.intValue()))
          {
            if (j == ForwardAbility.ForwardAbilityType.h.intValue())
            {
              this.mForwardOption.al().putString("forward_filepath", paramIntent);
              this.mForwardOption.al().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
              this.mForwardOption.aa();
              return;
            }
            this.mForwardOption.al().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
            startChatAndSendMsg();
            ReportController.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
            return;
          }
          this.mForwardOption.al().putString("forward_extra", paramIntent);
          this.mForwardOption.b(j);
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ForwardBaseOption localForwardBaseOption = this.mForwardOption;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.j();
    }
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    ForwardBaseOption localForwardBaseOption = this.mForwardOption;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.b(paramBundle);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (AppSetting.e) {
      this.rightButton.postDelayed(new ForwardRecentActivity.1(this), 1000L);
    }
    if (BaseApplicationImpl.appStartTime > 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("actStartSel, cost=");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime);
      Log.d("AutoMonitor", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mForwardOption;
    if (localObject != null) {
      ((ForwardBaseOption)localObject).i();
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    ForwardBaseOption localForwardBaseOption = this.mForwardOption;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.a(paramBundle);
    }
  }
  
  public void finish()
  {
    attachQCircleReportParam(false);
    notifyResultReceiver(getIntent(), this);
    super.finish();
    overridePendingTransition(0, 2130771995);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 20002) {
      finish();
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.mSearchResultLayout.getVisibility() != 8)
    {
      quitSearchState();
      return true;
    }
    if (this.mSelectedAndSearchBar.a()) {
      quitSearchState();
    }
    if (this.mNeedShareCallback) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
    }
    reportMiniAppShareFail();
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onListViewItemClickedInDefaultStatus(View paramView)
  {
    reportDataForBusiness("0X8007827");
    paramView = (ForwardRecentItemView)paramView;
    ResultRecord localResultRecord = paramView.k;
    if (QFileAssistantUtils.a(localResultRecord.uin))
    {
      onFileAssistantItemClickedInDefaultStatus(localResultRecord, paramView);
      return;
    }
    openForwardDialog(localResultRecord, paramView);
  }
  
  public void onRefreshTopayList(boolean paramBoolean)
  {
    refreshRecommendList(false);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void refreshRecommendList(boolean paramBoolean)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject1 = this.topayManager.getTopayList(this, paramBoolean, this.mBusinessType, this.mBusinessSubType);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.topayManager;
    localObject2 = ((HashMap)localObject1).get("tips");
    if (localObject2 != null)
    {
      localObject2 = (ArrayList)localObject2;
      this.mForwardOption.al().putStringArrayList("choose_friend_feedbacks", (ArrayList)localObject2);
    }
    this.forwardlist = new ArrayList();
    localObject2 = this.topayManager;
    localObject2 = ((HashMap)localObject1).get("recommend");
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (ArrayList)localObject2;
    }
    if (localObject1 != null)
    {
      int i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (PfaFriend)((ArrayList)localObject1).get(i);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((PfaFriend)localObject2).uin)) && ((!this.mIsForConfess) || (!TextUtils.equals(((PfaFriend)localObject2).uin, this.app.getCurrentAccountUin()))))
        {
          localObject2 = new RecentUser(((PfaFriend)localObject2).uin, 0);
          this.forwardlist.add(localObject2);
          Collections.sort(this.forwardlist, new ForwardRecentActivity.10(this));
        }
        i += 1;
      }
    }
    localObject1 = this.recentAdapter;
    if (localObject1 == null)
    {
      this.recentAdapter = new ForwardRecentListAdapter(this, this.app, this.mListView, this.forwardlist, this.mForwardRecentListAdapterCallback);
      this.mListView.setAdapter(this.recentAdapter);
      return;
    }
    ((ForwardRecentListAdapter)localObject1).a(this.forwardlist);
  }
  
  public void reportDataForBusiness(String paramString)
  {
    if (getIntent().getBooleanExtra("forward_source_from_shoot_quick", false)) {
      ReportController.b(this.app, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  public void showForwardDialog(long paramLong, String paramString)
  {
    Object localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getExtras();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = new Bundle((Bundle)localObject);
    } else {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putInt("uintype", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ((Bundle)localObject).putString("uin", localStringBuilder.toString());
    if (paramString != null) {
      ((Bundle)localObject).putString("uinname", paramString);
    }
    this.mForwardOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), (Bundle)localObject);
    this.mForwardOption.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */