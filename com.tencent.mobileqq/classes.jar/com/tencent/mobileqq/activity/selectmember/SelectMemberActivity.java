package com.tencent.mobileqq.activity.selectmember;

import Override;
import acxa;
import aeex;
import ahux;
import amrb;
import amrc;
import amsu;
import amsw;
import amtj;
import anca;
import andd;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import baxb;
import baxd;
import baxe;
import baxj;
import baxk;
import baxl;
import baxo;
import bayp;
import bbbg;
import bcef;
import bdzw;
import beaf;
import beah;
import bftf;
import bfur;
import bfvf;
import bfvo;
import bhht;
import bhig;
import bkik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.activity.selectmember.ResultRecord;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lxk;
import lzb;
import mqq.app.MobileQQ;
import mrf;
import mst;
import muk;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectMemberActivity
  extends FragmentActivity
  implements View.OnClickListener, bbbg, beaf
{
  public static final int ENTRANCE_ADD_FORBID_STORY_FRIEND = 24;
  public static final int ENTRANCE_ASSIGN_HB = 25;
  public static final int ENTRANCE_BATCH_ADDFRDS = 30;
  public static final int ENTRANCE_BLESS = 15;
  public static final int ENTRANCE_BLESS_TYPE = 16;
  public static final int ENTRANCE_BLESS_WEB = 32;
  public static final int ENTRANCE_CHATSETTING = 29;
  public static final int ENTRANCE_FORWARD_NEW_SESSION = 12;
  public static final int ENTRANCE_FUN_CALL = 22;
  public static final int ENTRANCE_H5_FRIENDS_SELECTOR = 32;
  public static final int ENTRANCE_INVITE_TROOP_MEM_JOIN_GROUP_VEDIO = 23;
  public static final int ENTRANCE_MANGE_TROOP_MANAGERS = 21;
  public static final int ENTRANCE_MINI_APP_SELECT_MULTI = 37;
  public static final int ENTRANCE_MULTIAUDIO_MULTI_VIDEO_SELECT_MEMBER = 11;
  public static final int ENTRANCE_NEW_TROOP_CREATE_INTERFACE = 27;
  public static final int ENTRANCE_ONLINE_STATUS_PERMISSION = 40;
  public static final int ENTRANCE_QAV = 35;
  public static final int ENTRANCE_QAV_Switch = 36;
  public static final int ENTRANCE_QCIRCLE_COMMENT = 42;
  public static final int ENTRANCE_QCIRCLE_PUBLISH = 41;
  public static final int ENTRANCE_QQSTORY_CREATE_SHARE_GROUP = 26;
  public static final int ENTRANCE_QZONE_MOOD_SYNC_SELECT_MEMBER = 17;
  public static final int ENTRANCE_TEAM_WORK_AUTHORIZE = 31;
  public static final int ENTRANCE_TO_PAY = 33;
  public static final int ENTRANCE_TROOPSETTING_INVITE = 38;
  public static final int ENTRANCE_TROOP_APP_BULK_SEND_MESSAGE = 34;
  public static final int ENTRANCE_TROOP_ORG_MANAGE = 14;
  public static final int ENTRANCE_UNITE_SEARCH = 28;
  public static final int ENTRANCE_UNITE_SEARCH_FRIEND = 39;
  public static final String FRIEND_TEAM_ID = "friend_team_id";
  public static final String GROUP_MEMBER_COUNT = "group_member_type";
  public static final String GROUP_NAME = "group_name";
  public static final String GROUP_TYPE = "group_type";
  public static final String GROUP_UIN = "group_uin";
  private static final String INDEX_NOT_ADMIN_INVITE_MEMBER_COUNT = "not_admin_invite_member_count";
  private static final int MAX_OF_PSTN = 8;
  public static final int MAX_OF_PSTN_TIPS = 3;
  private static final int MSG_INIT_DATA = 1000;
  public static final String MULTICHAT = "multi_chat";
  public static final String NEED_CLOSE_WHEN_PSTN_CLOSE = "NEED_CLOSE_WHEN_PSTN_CLOSE";
  private static final int NOT_ADMIN_INVITE_MEMBER_MAX_COUNT = 3;
  static final int PAGE_CONTACTS_LIST = 1;
  public static final int PAGE_DISCUSSION_MEMBER_LIST = 7;
  static final int PAGE_FRIEND_LIST = 5;
  static final int PAGE_FRIEND_TEAM_LIST = 0;
  public static final int PAGE_FRIENT_TEAN_SELECT = 8;
  static final int PAGE_RECENT_MEMBER_LIST = 4;
  public static final int PAGE_TROOP_BATCH_ADD_FRDS_LIST = 9;
  static final int PAGE_TROOP_DISCUSSION_LIST = 3;
  static final int PAGE_TROOP_LIST = 2;
  public static final int PAGE_TROOP_MEMBER_LIST = 6;
  public static final String PARAMR_ADMIN_GVIDEO_ROOM_NUM = "PARAMR_ADMIN_GVIDEO_ROOM_NUM";
  public static final String PARAM_AAPAY_RESULT_RECEIVER = "aapay_result_recevier";
  public static final String PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET = "param_add_passed_members_to_result_set";
  public static final String PARAM_ALL_SELECT_MAX_NUM = "param_all_select_max_num";
  public static final String PARAM_BACK_BUTTON_SIDE = "param_back_button_side";
  public static final String PARAM_BATCH_ADDFRD_RECOMMAND_UIN = "batch_addfrd_recommand_uin";
  public static final String PARAM_BATCH_ADDFRD_SCENE_TYPE = "batch_addfrd_scene_type";
  public static final String PARAM_DEFAULT_SELECTED_TROOP_MEMBERS = "param_default_selected_troop_members";
  public static final String PARAM_DONE_BUTTON_HIGHLIGHT_WORDING = "param_done_button_highlight_wording";
  public static final String PARAM_DONE_BUTTON_WORDING = "param_done_button_wording";
  public static final String PARAM_DONOT_NEED_CONTACTS = "param_donot_need_contacts";
  public static final String PARAM_DONOT_NEED_DISCUSSION = "param_donot_need_discussion";
  public static final String PARAM_DONOT_NEED_TROOP = "param_donot_need_troop";
  public static final String PARAM_ENABLE_ALL_SELECT = "param_enable_all_select";
  public static final String PARAM_ENTRANCE = "param_entrance";
  public static final String PARAM_EXIT_ANIMATION = "param_exit_animation";
  public static final String PARAM_FACE_TO_FACE_INVITE = "param_face_to_face_invite";
  public static final String PARAM_FACE_TO_FACE_TROOP = "param_face_to_face_troop";
  public static final String PARAM_FILTER_ROBOT = "filer_robot";
  public static final String PARAM_FROM = "param_from";
  public static final String PARAM_GROUPCODE = "param_groupcode";
  public static final String PARAM_HIDE_UIN_LIST = "param_uins_hide";
  public static final String PARAM_IS_FORBID_ONLY_CHOOSE_MYSELF = "is_forbid_only_choose_myself";
  public static final String PARAM_IS_PUT_MYSELF_FIRST = "is_put_myself_first";
  public static final String PARAM_IS_STORY_NOT_SEE = "is_story_not_see";
  public static final String PARAM_IS_SUPPORT_SELECT_FROM_FRIEND_GROUPS = "is_support_select_from_friend_groups";
  public static final String PARAM_IS_TROOP_ADMIN = "param_is_troop_admin";
  public static final String PARAM_MAX = "param_max";
  public static final String PARAM_MIN = "param_min";
  public static final String PARAM_ONLY_DISCUSSION_MEMBER = "param_only_discussion_member";
  public static final String PARAM_ONLY_FRIENDS = "param_only_friends";
  public static final String PARAM_ONLY_TROOP_MEMBER = "param_only_troop_member";
  public static final String PARAM_ONLY_TROOP_OR_DISCUSSION_MEMBER = "param_only_troop_or_discussion_member";
  public static final String PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT = "param_overload_tips_include_default_count";
  public static final String PARAM_RESULT_SET = "result_set";
  public static final String PARAM_RESULT_SET_For_out_Member = "result_set_for_out_Member ";
  public static final String PARAM_SELECTED_RECORDS_FOR_CREATE_DISCURRION = "param_selected_records_for_create_discussion";
  public static final String PARAM_SHOW_MYSELF = "param_show_myself";
  public static final String PARAM_SHOW_OWNER_AND_ADMINS_ONLY = "param_show_owner_and_admins_only";
  public static final String PARAM_SUBTYPE = "param_subtype";
  public static final String PARAM_ShowInviteEntry = "show_invite_entry";
  public static final String PARAM_TITLE = "param_title";
  public static final String PARAM_TROOP_MEMBER_SHOW_TYPE = "param_member_show_type";
  public static final String PARAM_TYPE = "param_type";
  public static final String PARAM_UIN_SELECTED_FRIENDS = "param_uins_selected_friends";
  public static final String PARAM_UIN_SELECT_DEFAULT = "param_uins_selected_default";
  public static final int REQUEST_CODE_ADD_FRIND = 11;
  public static final int REQUEST_CODE_QQSTORY_CREATE_SHARE_GROUP = 10001;
  public static final int REQUEST_CODE_UNITED_VERIFY_MSG_EDIT = 10;
  public static final int RESULT_RECORD_TYPE_ONLY_CONTACT = 5;
  public static final String Result_Name = "result_name";
  public static final String Result_Uin = "result_uin";
  public static final String Result_UinType = "result_uintype";
  public static final int SUB_TYPE_ADD_MEMBER = 1;
  public static final int SUB_TYPE_CREATE = 0;
  public static final int SUB_TYPE_CREATE_BY_SWITCH = 2;
  public static final int SUB_TYPE_INVITE_TROOP_VEDIO_MEM = 3;
  public static final int SUB_TYPE_SELECT_MEMBER_ONLY = 5;
  public static final int SUB_TYPE_TROOP_BATACH_ADDFRDS = 4;
  static final String TAG = "SelectMemberActivity";
  protected static final int addReqError = 1;
  protected static final int addReqOK = 0;
  protected static final int refreshGridView = 2;
  public static boolean sNeedBlockDiscussSelfInviteMsg;
  ContactSearchFragment contactSearchFragment;
  InputMethodManager imm = null;
  boolean isClosed = false;
  public boolean isStoryNotSee;
  public boolean isSupportSelectFriendGroup = true;
  long lastCreateTimeStamp = 0L;
  public int lastInerFrame = -1;
  boolean mAddPassedMembersToResultSet;
  private Drawable mAnimationDrawable;
  int mBackButtonSide;
  public ahux mBlessManager;
  protected Button mCreateTroopButton;
  protected View mCreateTroopButtonLayout;
  Bitmap mDefaultAvatar;
  protected float mDensity;
  private amrc mDiscussionObserver;
  String mDoneBtnText;
  String mDoneBtnText_x;
  public boolean mDonotNeedContacts;
  boolean mDonotNeedDiscussion;
  boolean mDonotNeedTroop;
  int mEnterAnimation;
  public int mEntrance;
  int mExitAnimation;
  FaceDecoder mFaceDecoder;
  public boolean mFilterRobot;
  protected acxa mFinishActivityCallback = new SelectMemberActivity.11(this);
  private amsu mFriendlistObserver;
  protected int mFrom;
  protected TextView mGVideoTextView;
  private bkik mGVideoWrapper;
  String mGroupCode;
  ArrayList<Entity> mGroupmembers;
  final Handler mHandler = new SelectMemberActivity.16(this, Looper.getMainLooper());
  protected InnerFrameManager mInnerFrameManager;
  public Intent mIntent;
  protected long mInviteNoAuthLimitNum = 9223372036854775807L;
  String mInviteSuccToastWording = amtj.a(2131712867);
  protected List<String> mInvitedUinList = new ArrayList();
  public boolean mIsForbidOnlyChooseMySelf;
  protected boolean mIsLimitToInviteByTroopMaxLimit;
  public boolean mIsNeedSendIsResumeBroadcast = true;
  public boolean mIsPutMySelfFirst;
  public boolean mIsSelectAllMembers;
  boolean mIsSoftInputShowing;
  protected boolean mIsTroopAdmin;
  protected TextView mLeftBackBtn;
  protected TextView mLeftCancelBtn;
  protected LinearLayout mListPanel;
  protected int mMaxSelectNumber;
  protected int mMinSelectNumber;
  private boolean mModeMulti;
  private Button mMultiAddBtn;
  private View mMultiAddContainerV;
  View mMultiSearchView;
  SelectMemberActivity.IOnSelectStateChange mOnSelectStateChangeListener;
  boolean mOnlyDiscussionMember;
  boolean mOnlyFaceToFaceTroop;
  boolean mOnlyFriends;
  boolean mOnlySelectTroopOrDiscussionMember;
  boolean mOnlyTroopMember;
  boolean mOverloadTipsIncludeDefaultCount;
  private long mOverloadToastLastShowTime;
  protected bhht mQQProgressDialog;
  protected bhig mQQTH;
  private lxk mQavWrapper;
  protected ArrayList<ResultRecord> mResultList = new ArrayList();
  protected TextView mRightBtn;
  protected View mSearchResultLayout;
  protected boolean mSearchTextEmpty = true;
  public SelectedAndSearchBar mSelectedAndSearchBar;
  private aeex mSelectedAndSearchBarCallback = new SelectMemberActivity.9(this);
  protected boolean mShowMyself;
  public int mSubType;
  protected TextView mTitle;
  protected View mTitleBar;
  String mTitleString;
  protected View mTooManyMembersTipsBar;
  protected View mTooManyMembersTipsClose;
  public ArrayList<String> mTopayTips;
  protected Bitmap mTransparentFace;
  protected int mTroopMemberNum;
  private andd mTroopObserver;
  public int mType;
  public ArrayList<String> mUinsSelectedDefault;
  public ArrayList<String> mUinsSelectedFriends;
  public ArrayList<String> mUinsToHide;
  private int mUnblessedUinCount;
  private int mWebUinCount;
  String mYellowTipsWording = "";
  boolean needShowYellowTips = false;
  protected Dialog pd;
  protected ProgressBar tipsDialogPb;
  protected TextView tipsDialogText;
  protected ImageView tipsFlagImage;
  private BroadcastReceiver videoMsgReceiver;
  
  private void afterCreateTroopSucc(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "afterCreateTroopSucc, troop[" + paramString + "], entrance[" + this.mEntrance + "]");
    }
    Object localObject = ((TroopManager)this.app.getManager(52)).c(paramString);
    ArrayList localArrayList;
    Iterator localIterator;
    if (localObject == null)
    {
      localObject = "";
      localArrayList = new ArrayList();
      localIterator = this.mResultList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label218;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
        }
        localArrayList.add(localResultRecord.uin);
        continue;
        localObject = ((TroopInfo)localObject).troopname;
        break;
      }
      if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+"))) {
        localArrayList.add(localResultRecord.uin);
      }
    }
    label218:
    this.mIntent.putExtra("roomId", paramString);
    this.mIntent.putExtra("discussName", (String)localObject);
    this.mIntent.putExtra("qqPhoneUserList", localArrayList);
    this.mIntent.putExtra("audioType", 2);
    this.mIntent.putExtra("result_uin", paramString);
    this.mIntent.putExtra("result_uintype", 1);
    this.mIntent.putExtra("result_name", (String)localObject);
    if (this.mEntrance == 12) {
      this.mIntent.putExtra("select_memeber_discussion_memeber_count", this.mResultList.size() + 1);
    }
    this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
    setResult(-1, this.mIntent);
    if (this.mEntrance == 27) {
      TroopUtils.enterTroopAio(this, paramString, true);
    }
    finish();
  }
  
  private boolean canInvite()
  {
    if ((!this.mIsTroopAdmin) && (getNotAdminInviteMemberCount() >= 3)) {}
    return true;
  }
  
  public static ResultRecord constructAResultRecord(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    return localResultRecord;
  }
  
  private void handleTroopInviteGroupFailed(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.mEntrance == 11) || (this.mEntrance == 36)) {
        str = getString(2131695116);
      }
      break;
    }
    for (;;)
    {
      this.mHandler.obtainMessage(1, str).sendToTarget();
      QLog.w("SelectMemberActivity", 1, "handleTroopInviteGroupFailed, result[" + paramInt + "], errStr[" + str + "]");
      return;
      str = getString(2131693195);
      continue;
      str = getString(2131693194);
      continue;
      str = getString(2131693197);
      continue;
      str = getString(2131693196);
      continue;
      str = getString(2131693198);
    }
  }
  
  private boolean hasAdd2ResultList(String paramString)
  {
    try
    {
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = TextUtils.equals(((ResultRecord)localIterator.next()).uin, paramString);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void initObserver()
  {
    this.mDiscussionObserver = new SelectMemberActivity.13(this);
    this.mTroopObserver = new SelectMemberActivity.14(this);
    this.mFriendlistObserver = new SelectMemberActivity.15(this);
    addObserver(this.mDiscussionObserver);
    addObserver(this.mFriendlistObserver);
    addObserver(this.mTroopObserver);
  }
  
  private void initOnProgressDialog()
  {
    if (this.pd != null)
    {
      this.pd.dismiss();
      this.pd = null;
    }
    this.pd = new ReportDialog(this, 2131755826);
    this.pd.setContentView(2131562728);
    this.tipsDialogText = ((TextView)this.pd.findViewById(2131365552));
    this.tipsDialogText.setText(getString(2131718142));
    this.tipsDialogPb = ((ProgressBar)this.pd.findViewById(2131367022));
    this.tipsDialogPb.setVisibility(0);
    this.tipsFlagImage = ((ImageView)this.pd.findViewById(2131380190));
    this.tipsFlagImage.setVisibility(4);
  }
  
  private boolean isNotMaxOfPSTN()
  {
    boolean bool = false;
    int i;
    if (this.mSubType == 1) {
      if (this.mQavWrapper != null) {
        i = this.mQavWrapper.a(Long.valueOf(this.mGroupCode).longValue(), this.mType) + 0;
      }
    }
    for (;;)
    {
      Iterator localIterator = this.mResultList.iterator();
      label50:
      int j;
      if (localIterator.hasNext()) {
        if (((ResultRecord)localIterator.next()).type == 5)
        {
          j = i + 1;
          i = j;
          if (j < 8) {}
        }
      }
      for (;;)
      {
        if (j < 8) {
          bool = true;
        }
        return bool;
        if (this.mGVideoWrapper == null) {
          break label141;
        }
        i = this.mGVideoWrapper.a(Long.valueOf(this.mGroupCode).longValue(), this.mType) + 0;
        break;
        break label50;
        j = i;
      }
      label141:
      i = 0;
    }
  }
  
  private void sendIsResumeBroadcast(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.mIsNeedSendIsResumeBroadcast + " ,isResume = " + paramBoolean);
    }
    if (this.mIsNeedSendIsResumeBroadcast) {
      lzb.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void setDoneBtnEnabled(boolean paramBoolean)
  {
    if (this.mIntent.getBooleanExtra("show_invite_entry", false)) {}
    label292:
    for (;;)
    {
      return;
      int i = this.mResultList.size();
      String str1;
      if (i <= 1) {
        if (this.mSubType == 3)
        {
          String str2 = this.mDoneBtnText;
          str1 = str2;
          if (i != 1)
          {
            paramBoolean = false;
            str1 = str2;
          }
          if (!paramBoolean) {
            break label247;
          }
          this.mRightBtn.setEnabled(true);
          if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
            this.mRightBtn.setAlpha(1.0F);
          }
          this.mRightBtn.setText(str1);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label292;
        }
        this.mRightBtn.setContentDescription(this.mDoneBtnText + amtj.a(2131712860) + i + amtj.a(2131712851));
        return;
        if (((this.mEntrance == 25) && (i == 1)) || ((isCreateNewTypeTroop()) && (i == 1)))
        {
          str1 = MessageFormat.format(this.mDoneBtnText_x, new Object[] { Integer.valueOf(i) });
          break;
        }
        str1 = this.mDoneBtnText;
        break;
        if (this.mSubType == 3)
        {
          str1 = this.mDoneBtnText;
          break;
        }
        str1 = MessageFormat.format(this.mDoneBtnText_x, new Object[] { Integer.valueOf(i) });
        break;
        label247:
        this.mRightBtn.setEnabled(false);
        if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
          this.mRightBtn.setAlpha(0.5F);
        }
        this.mRightBtn.setText(str1);
      }
    }
  }
  
  private void showMemberOverloadToast(int paramInt)
  {
    showMemberOverloadToast(getString(paramInt));
  }
  
  private void showMemberOverloadToast(String paramString)
  {
    if (System.currentTimeMillis() - this.mOverloadToastLastShowTime > 2000)
    {
      QQToast.a(this, paramString, 2000).b(this.mTitleBar.getHeight());
      this.mOverloadToastLastShowTime = System.currentTimeMillis();
    }
  }
  
  private void startRelationFriendAndTroopSearch(boolean paramBoolean)
  {
    SelectMemberInnerFrame localSelectMemberInnerFrame;
    if ((this.mEntrance == 38) || (this.mEntrance == 29) || (this.mEntrance == 39))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "isItemClick：" + paramBoolean);
      }
      localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.mInnerFrameManager.getChildAt(1);
      if ((!paramBoolean) || (this.mInnerFrameManager.a() != 0)) {
        break label87;
      }
    }
    label87:
    while (!(localSelectMemberInnerFrame instanceof FriendTeamListInnerFrame)) {
      return;
    }
    ResultRecord localResultRecord = null;
    if (this.mResultList.size() > 0) {
      localResultRecord = (ResultRecord)this.mResultList.get(this.mResultList.size() - 1);
    }
    localSelectMemberInnerFrame.a(localResultRecord, this.mEntrance);
  }
  
  public boolean addFriendResults(List<ResultRecord> paramList, boolean paramBoolean)
  {
    return addFriendResults(paramList, paramBoolean, false);
  }
  
  public boolean addFriendResults(List<ResultRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.mResultList.clear();
    }
    HashSet localHashSet = new HashSet(this.mResultList.size());
    Object localObject = this.mResultList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    if (this.mUinsSelectedDefault != null)
    {
      localObject = this.mUinsSelectedDefault.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    do
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label345;
        }
        localObject = (ResultRecord)paramList.next();
        if (!localHashSet.contains(((ResultRecord)localObject).uin))
        {
          if ((isMemberOverLoad("addFriendResults", paramBoolean2, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).groupUin)) || (isMemberOverload(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name)) || (!preAddPstnNumber(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).groupUin))) {
            break;
          }
          this.mResultList.add(localObject);
          updateMultiAddState((ResultRecord)localObject, true);
          if (this.mType == 9003) {
            if ((this.mEntrance == 15) && (!this.mBlessManager.a(((ResultRecord)localObject).uin))) {
              this.mUnblessedUinCount += 1;
            } else if ((this.mEntrance == 32) && (!this.mBlessManager.b(((ResultRecord)localObject).uin))) {
              this.mUnblessedUinCount += 1;
            }
          }
        }
      }
    } while (this.mType == 9003);
    label345:
    this.mSelectedAndSearchBar.a(true);
    setupDoneBtn();
    onResultListChanged();
    return true;
  }
  
  public void afterMemberFilter(int paramInt)
  {
    if (this.mEntrance != 35) {
      return;
    }
    this.mIsSelectAllMembers = false;
    doEnableAllSelect(paramInt);
    showAllSelectBtn();
  }
  
  public ResultRecord constructAResultRecord(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    localResultRecord.phone = paramString4;
    return localResultRecord;
  }
  
  protected void createNewTypeDiscussion()
  {
    if (System.currentTimeMillis() - this.lastCreateTimeStamp < 1500L) {}
    bdzw localbdzw;
    do
    {
      return;
      this.lastCreateTimeStamp = System.currentTimeMillis();
      localbdzw = (bdzw)this.app.getManager(32);
    } while (localbdzw == null);
    Object localObject = new JSONObject();
    label542:
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("group_type", 1);
        ((JSONObject)localObject).put("name", ContactUtils.getAccountNickName(this.app, this.app.getCurrentAccountUin()) + amtj.a(2131712850));
        ((JSONObject)localObject).put("classify", 10010);
        if ((this.mEntrance != 12) && (this.mEntrance != 36)) {
          ((JSONObject)localObject).put("isJumpAio", 1);
        }
        i = this.mEntrance;
        if (i == 12) {
          i = 3;
        }
        ArrayList localArrayList;
        String str;
        ResultRecord localResultRecord;
        if (this.mFrom != 1002) {
          break;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((JSONObject)localObject).put("create_source", i);
          localbdzw.a(((JSONObject)localObject).toString(), 5);
          bcef.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + i, "", "");
          localArrayList = new ArrayList(this.mResultList.size());
          localArrayList.addAll(this.mResultList);
          if (this.mUinsSelectedDefault == null) {
            continue;
          }
          localObject = this.mUinsSelectedDefault.iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          str = (String)((Iterator)localObject).next();
          localResultRecord = new ResultRecord();
          localResultRecord.uin = str;
          localResultRecord.type = 0;
          localResultRecord.groupUin = "-1";
          localResultRecord.name = ContactUtils.getNickName(this.app, localResultRecord.uin, localResultRecord.type);
          localArrayList.add(localResultRecord);
          continue;
          if (this.mEntrance == 28)
          {
            i = 5;
            continue;
          }
          if (this.mEntrance == 39)
          {
            i = 8;
            continue;
          }
          if (this.mEntrance == 29)
          {
            i = 2;
            continue;
          }
          if (this.mEntrance != 27) {
            break label542;
          }
          i = getIntent().getIntExtra("create_source", 0);
          continue;
          localJSONException1 = localJSONException1;
          i = 0;
        }
        catch (JSONException localJSONException2)
        {
          continue;
          int i = 0;
        }
        QLog.e("SelectMemberActivity", 1, "createNewTypeDiscussion json error!", localJSONException1);
        continue;
        localbdzw.a(this, this, localJSONException1);
        if (this.mFrom == 1003)
        {
          bcef.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
          return;
        }
      }
      bcef.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
      return;
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
  
  void doEnableAllSelect(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (!this.mIntent.getBooleanExtra("param_enable_all_select", false)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mIntent.getStringExtra("group_uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || ((!this.mOnlyDiscussionMember) && (!this.mOnlyTroopMember)));
    if (paramInt != -1)
    {
      if (!this.mShowMyself) {
        break label259;
      }
      j = paramInt - 1;
    }
    for (;;)
    {
      if (j <= this.mIntent.getIntExtra("param_all_select_max_num", this.mMaxSelectNumber)) {
        this.mIsSelectAllMembers = true;
      }
      QLog.w("SelectMemberActivity", 1, "isEnableAllSelect, memCount[" + paramInt + "], memFromAPI[" + i + "], finalCount[" + j + "], mIsSelectAllMembers[" + this.mIsSelectAllMembers + "], mShowMyself[" + this.mShowMyself + "]");
      return;
      if (this.mOnlyDiscussionMember)
      {
        amrb localamrb = (amrb)this.app.getManager(53);
        if (localamrb == null) {
          break label254;
        }
        i = localamrb.a((String)localObject);
      }
      for (;;)
      {
        j = i - 1;
        break;
        i = j;
        if (this.mOnlyTroopMember)
        {
          localObject = ((TroopManager)this.app.getManager(52)).c((String)localObject);
          i = j;
          if (localObject != null)
          {
            i = ((TroopInfo)localObject).wMemberNum;
            continue;
            label254:
            i = 0;
          }
        }
      }
      label259:
      j = paramInt;
    }
  }
  
  protected void doInviteTroopMember(ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList.size() > 0) && (this.mGroupCode.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.mGroupCode + " member count: " + paramArrayList.size());
      }
      if (!canInvite())
      {
        QQToast.a(this, 2131694121, 0).b(getTitleBarHeight());
        return;
      }
      if (this.mTroopMemberNum <= 0)
      {
        Object localObject = (TroopManager)this.app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.mGroupCode);
          if (localObject != null) {
            this.mTroopMemberNum = ((TroopInfo)localObject).wMemberNum;
          }
        }
      }
      if ((this.mInviteNoAuthLimitNum > 0L) && (paramArrayList.size() + this.mTroopMemberNum > this.mInviteNoAuthLimitNum))
      {
        bfur.a(this, amtj.a(2131712861), 2131690620, 2131693192, new SelectMemberActivity.7(this, paramArrayList), new bfvf()).show();
        reportInviteFriend("exp_msgbox");
        return;
      }
      ((anca)this.app.getBusinessHandler(20)).a(this.mGroupCode, paramArrayList, "");
      initOnProgressDialog();
      this.pd.show();
      reportInviteFriend("Clk_invite");
      return;
    }
    finish();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "qqstory create share group result:" + paramInt2);
      }
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    while (this.mInnerFrameManager == null) {
      return;
    }
    this.mInnerFrameManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755153);
    super.doOnCreate(paramBundle);
    getIntentExtras();
    setContentLayout();
    if ((this.mEntrance == 11) || (this.mEntrance == 36)) {}
    ArrayList localArrayList;
    for (int i = 1;; i = 0)
    {
      if (i == 1) {
        super.getWindow().addFlags(524288);
      }
      this.mFaceDecoder = new FaceDecoder(this, this.app);
      this.mDensity = getResources().getDisplayMetrics().density;
      findViews();
      initTitleBar();
      initSelectedBar();
      initSearchBar();
      initObserver();
      initInnerFrameManager();
      if ((this.mType == 1) && (this.mSubType == 1))
      {
        paramBundle = (TroopManager)this.app.getManager(52);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.b(this.mGroupCode);
          if (paramBundle != null) {
            this.mTroopMemberNum = paramBundle.wMemberNum;
          }
        }
        ThreadManager.post(new SelectMemberActivity.1(this), 8, null, true);
      }
      this.mTransparentFace = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      this.mDefaultAvatar = bfvo.a();
      if (this.videoMsgReceiver == null)
      {
        this.videoMsgReceiver = new SelectMemberActivity.VideoMsgReceiver(this);
        paramBundle = new IntentFilter();
        paramBundle.addAction("tencent.av.v2q.StopVideoChat");
        registerReceiver(this.videoMsgReceiver, paramBundle);
      }
      if (this.mFrom == 30) {
        toggleSelectMode(true, true);
      }
      if ((this.mType != 9003) && (8998 != this.mType)) {
        break label415;
      }
      this.mBlessManager = ((ahux)this.app.getManager(138));
      Object localObject = this.mBlessManager.a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label415;
      }
      paramBundle = (amsw)this.app.getManager(51);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Friends localFriends = paramBundle.e(str);
        if (localFriends != null) {
          localArrayList.add(constructAResultRecord(str, localFriends.getFriendNick(), 0, "-1"));
        }
      }
    }
    addFriendResults(localArrayList, false);
    label415:
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      addFriendResults(paramBundle, false);
    }
    if (this.mFrom == 1003) {
      bcef.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mEntrance == 33) {
        bcef.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
      }
      return true;
      if (this.mFrom == 1002) {
        bcef.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mInnerFrameManager.d();
    removeObserver(this.mDiscussionObserver);
    removeObserver(this.mFriendlistObserver);
    removeObserver(this.mTroopObserver);
    if ((this.pd != null) && (this.pd.isShowing())) {
      this.pd.dismiss();
    }
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.destory();
    }
    if (this.videoMsgReceiver != null)
    {
      unregisterReceiver(this.videoMsgReceiver);
      this.videoMsgReceiver = null;
    }
    bdzw localbdzw = (bdzw)this.app.getManager(32);
    if (localbdzw != null) {
      localbdzw.a(this);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mInnerFrameManager.b();
    sendIsResumeBroadcast(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mInnerFrameManager.a();
    sendIsResumeBroadcast(true);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.mInnerFrameManager.c();
  }
  
  @TargetApi(14)
  protected void findViews()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131376679);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localRelativeLayout.setFitsSystemWindows(true);
      }
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mTitleBar = findViewById(2131378727);
    this.mTitle = ((TextView)findViewById(2131369115));
    this.mLeftBackBtn = ((TextView)findViewById(2131369068));
    this.mLeftCancelBtn = ((TextView)findViewById(2131369070));
    this.mRightBtn = ((TextView)findViewById(2131369099));
    this.mSelectedAndSearchBar = ((SelectedAndSearchBar)findViewById(2131377049));
    this.mListPanel = ((LinearLayout)findViewById(2131370041));
    this.mInnerFrameManager = ((InnerFrameManager)findViewById(2131380787));
    this.mSearchResultLayout = findViewById(2131376347);
    this.mSearchResultLayout.setVisibility(8);
    this.mTooManyMembersTipsBar = findViewById(2131378910);
    if (this.mTooManyMembersTipsBar != null)
    {
      this.mTooManyMembersTipsBar.setVisibility(8);
      this.mTooManyMembersTipsBar.setOnClickListener(this);
    }
    this.mTooManyMembersTipsClose = findViewById(2131378911);
    if (this.mTooManyMembersTipsClose != null) {
      this.mTooManyMembersTipsClose.setOnClickListener(this);
    }
    this.mCreateTroopButtonLayout = findViewById(2131365229);
    if (isShowDoneButtonInBottom())
    {
      this.mCreateTroopButtonLayout.setVisibility(0);
      this.mCreateTroopButton = ((Button)findViewById(2131365228));
      if (this.mEntrance != 35) {
        break label481;
      }
      this.mCreateTroopButton.setText(this.mDoneBtnText);
    }
    label481:
    for (boolean bool = true;; bool = false)
    {
      if (this.mEntrance == 40) {
        this.mCreateTroopButton.setText(this.mDoneBtnText);
      }
      this.mCreateTroopButton.setOnClickListener(this);
      NewTroopContactView.setCreateTroopButtonEnable(this.mCreateTroopButton, bool);
      if (isCreateNewTroopEntrance())
      {
        int i = getIntent().getIntExtra("create_source", 0);
        bcef.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", "" + i, "", "");
      }
      for (;;)
      {
        this.mMultiSearchView = findViewById(2131377050);
        this.mMultiAddContainerV = findViewById(2131366775);
        this.mMultiAddBtn = ((Button)findViewById(2131363884));
        if (this.mMultiAddBtn != null) {
          this.mMultiAddBtn.setOnClickListener(this);
        }
        return;
        if (isInviteTroopMember())
        {
          this.mCreateTroopButton.setText(amtj.a(2131712831));
          refreshInviteTipsBar();
        }
      }
    }
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("SelectMemberActivity", 1, "finish", new Throwable("打印调用栈"));
    }
    ForwardRecentActivity.a(this.mIntent, this);
    super.finish();
    if (this.videoMsgReceiver != null)
    {
      unregisterReceiver(this.videoMsgReceiver);
      this.videoMsgReceiver = null;
    }
    switch (this.mExitAnimation)
    {
    default: 
      overridePendingTransition(0, 2130771978);
    }
    for (;;)
    {
      if (this.mSelectedAndSearchBar.a()) {
        quitSearchState();
      }
      return;
      overridePendingTransition(2130771988, 2130771989);
      continue;
      overridePendingTransition(0, 2130772001);
      continue;
      overridePendingTransition(0, 0);
    }
  }
  
  public int getCheckPhoneNumberResId(String paramString)
  {
    switch (mst.a(paramString.substring("pstn".length()), true))
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      return 2131718102;
    case 1: 
      return 2131718096;
    case 2: 
      return 2131718097;
    case 3: 
      return 2131718098;
    case 4: 
      return 2131718099;
    case 5: 
      return 2131718100;
    }
    return 2131718101;
  }
  
  protected void getIntentExtras()
  {
    this.mIntent = getIntent();
    this.mType = this.mIntent.getExtras().getInt("param_type");
    this.mSubType = this.mIntent.getExtras().getInt("param_subtype");
    this.mFrom = this.mIntent.getExtras().getInt("param_from");
    this.mEntrance = this.mIntent.getIntExtra("param_entrance", 0);
    this.mFilterRobot = this.mIntent.getBooleanExtra("filer_robot", false);
    this.mUinsSelectedDefault = this.mIntent.getStringArrayListExtra("param_uins_selected_default");
    this.mUinsSelectedFriends = this.mIntent.getStringArrayListExtra("param_uins_selected_friends");
    this.mUinsToHide = this.mIntent.getStringArrayListExtra("param_uins_hide");
    if (this.mUinsToHide == null) {
      this.mUinsToHide = new ArrayList();
    }
    this.mUinsToHide.add(AppConstants.BABY_Q_UIN);
    Object localObject2 = (TroopManager)this.app.getManager(52);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((TroopManager)localObject2).a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject1).next();
        if (localTroopInfo.isQidianPrivateTroop()) {
          this.mUinsToHide.add(localTroopInfo.troopuin);
        }
      }
    }
    this.mGroupCode = this.mIntent.getExtras().getString("param_groupcode");
    this.mIsTroopAdmin = this.mIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.mMaxSelectNumber = this.mIntent.getIntExtra("param_max", 2147483647);
    int i;
    if ((localObject2 != null) && (!TextUtils.isEmpty(this.mGroupCode)) && (!TextUtils.equals("0", this.mGroupCode)))
    {
      localObject1 = ((TroopManager)localObject2).b(this.mGroupCode);
      if (localObject1 != null)
      {
        i = ((TroopInfo)localObject1).wMemberMax - ((TroopInfo)localObject1).wMemberNum;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mMaxSelectNumber:").append(this.mMaxSelectNumber).append(" remain:").append(i).append("  wMemberMax:").append(((TroopInfo)localObject1).wMemberMax).append("  wMemberNum:").append(((TroopInfo)localObject1).wMemberNum).append("  real mMaxSelectNumber").append(Math.min(this.mMaxSelectNumber, i));
          QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i > 0) && (this.mMaxSelectNumber > i))
        {
          this.mMaxSelectNumber = i;
          this.mIsLimitToInviteByTroopMaxLimit = true;
        }
      }
    }
    this.mMinSelectNumber = this.mIntent.getIntExtra("param_min", 1);
    this.mShowMyself = this.mIntent.getBooleanExtra("param_show_myself", false);
    this.mDonotNeedContacts = this.mIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.mDonotNeedTroop = this.mIntent.getBooleanExtra("param_donot_need_troop", false);
    this.mDonotNeedDiscussion = this.mIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.mOnlyFriends = this.mIntent.getBooleanExtra("param_only_friends", false);
    this.mOnlyTroopMember = this.mIntent.getBooleanExtra("param_only_troop_member", false);
    this.mOnlyDiscussionMember = this.mIntent.getBooleanExtra("param_only_discussion_member", false);
    this.mOnlySelectTroopOrDiscussionMember = this.mIntent.getBooleanExtra("param_only_troop_or_discussion_member", false);
    this.mOnlyFaceToFaceTroop = this.mIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.mOverloadTipsIncludeDefaultCount = this.mIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.mTitleString = this.mIntent.getStringExtra("param_title");
    if (this.mTitleString == null) {
      this.mTitleString = getString(2131718077);
    }
    this.mDoneBtnText = this.mIntent.getStringExtra("param_done_button_wording");
    if (this.mDoneBtnText == null) {
      this.mDoneBtnText = getString(2131718089);
    }
    this.mDoneBtnText_x = this.mIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.mDoneBtnText_x == null) {
      this.mDoneBtnText_x = (this.mDoneBtnText + "({0})");
    }
    this.mAddPassedMembersToResultSet = this.mIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.mExitAnimation = this.mIntent.getIntExtra("param_exit_animation", 0);
    this.mBackButtonSide = this.mIntent.getIntExtra("param_back_button_side", 1);
    this.mIsPutMySelfFirst = this.mIntent.getBooleanExtra("is_put_myself_first", false);
    this.mIsForbidOnlyChooseMySelf = this.mIntent.getBooleanExtra("is_forbid_only_choose_myself", false);
    if ((this.mEntrance == 14) || (this.mEntrance == 21))
    {
      localObject1 = this.mIntent.getParcelableArrayListExtra("param_default_selected_troop_members");
      if (localObject1 != null) {
        localObject1 = ((ArrayList)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        this.mResultList.add(localObject2);
        continue;
        if (((this.mEntrance == 32) || (this.mEntrance == 35)) && ((this.mOnlyTroopMember) || (this.mOnlyDiscussionMember)))
        {
          doEnableAllSelect(-1);
          localObject1 = this.mIntent.getStringExtra("group_uin");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!this.mIsSelectAllMembers) && (this.mUinsSelectedFriends != null))
          {
            i = 0;
            if (i < this.mUinsSelectedFriends.size())
            {
              if (!TextUtils.isEmpty((CharSequence)this.mUinsSelectedFriends.get(i)))
              {
                localObject2 = new ResultRecord();
                ((ResultRecord)localObject2).uin = ((String)this.mUinsSelectedFriends.get(i));
                if (!this.mOnlyDiscussionMember) {
                  break label1020;
                }
              }
              label1020:
              for (int j = 2;; j = 1)
              {
                ((ResultRecord)localObject2).type = j;
                ((ResultRecord)localObject2).groupUin = ((String)localObject1);
                this.mResultList.add(localObject2);
                i += 1;
                break;
              }
            }
          }
        }
        else if ((this.mEntrance == 17) && (this.mUinsSelectedFriends != null))
        {
          i = 0;
          while (i < this.mUinsSelectedFriends.size())
          {
            if (!TextUtils.isEmpty((CharSequence)this.mUinsSelectedFriends.get(i)))
            {
              localObject1 = new ResultRecord();
              ((ResultRecord)localObject1).uin = ((String)this.mUinsSelectedFriends.get(i));
              this.mResultList.add(localObject1);
            }
            i += 1;
          }
        }
      }
    }
    this.isSupportSelectFriendGroup = this.mIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
  }
  
  int getNotAdminInviteMemberCount()
  {
    int j = 0;
    long l = bftf.a();
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i = j;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i = j;
      if (Long.parseLong(localObject[0]) == l) {
        i = Integer.parseInt(localObject[1]);
      }
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  ArrayList<ResultRecord> getOutGroupMem()
  {
    if ((this.mEntrance == 11) && (this.mGroupmembers != null))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!isGroupMember(localResultRecord.uin)) {
          localArrayList.add(localResultRecord);
        }
      }
      return localArrayList;
    }
    return this.mResultList;
  }
  
  public ArrayList<ResultRecord> getResultRecordList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mResultList.size())
    {
      localArrayList.add(this.mResultList.get(i));
      i += 1;
    }
    if (this.mUinsSelectedDefault != null)
    {
      Iterator localIterator = this.mUinsSelectedDefault.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = str;
        localResultRecord.type = 0;
        localResultRecord.groupUin = "-1";
        localResultRecord.name = ContactUtils.getNickName(this.app, localResultRecord.uin, localResultRecord.type);
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public List<String> getResultUins()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mResultList.size())
    {
      localArrayList.add(((ResultRecord)this.mResultList.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<String> getSelectedUinList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mResultList.size())
    {
      localArrayList.add(((ResultRecord)this.mResultList.get(i)).uin);
      i += 1;
    }
    if (this.mUinsSelectedDefault != null) {
      localArrayList.addAll(this.mUinsSelectedDefault);
    }
    return localArrayList;
  }
  
  protected String getTroopCodeFromTroopUin(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  protected void initInnerFrameManager()
  {
    this.mInnerFrameManager.a(this);
    this.mInnerFrameManager.setAppIntf(this.app);
    if (this.mFrom == 30)
    {
      this.mInnerFrameManager.a(9, this.mIntent.getExtras());
      return;
    }
    if (this.mOnlyTroopMember)
    {
      this.mInnerFrameManager.a(6, this.mIntent.getExtras());
      return;
    }
    if (this.mOnlyDiscussionMember)
    {
      this.mInnerFrameManager.a(7, this.mIntent.getExtras());
      return;
    }
    if (this.mOnlySelectTroopOrDiscussionMember)
    {
      this.mInnerFrameManager.a(3);
      return;
    }
    this.mInnerFrameManager.a(0);
  }
  
  public void initSearchBar()
  {
    if (this.imm == null) {
      this.imm = ((InputMethodManager)getSystemService("input_method"));
    }
    this.mSearchResultLayout.setOnTouchListener(new SelectMemberActivity.10(this));
  }
  
  @SuppressLint({"NewApi"})
  protected void initSelectedBar()
  {
    this.mSelectedAndSearchBar.a(this.mResultList, this.mFaceDecoder, this.mSelectedAndSearchBarCallback);
    if (((this.mResultList.size() != 0) && ((this.mEntrance == 14) || (this.mEntrance == 21))) || (this.mEntrance == 32))
    {
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (this.mEntrance == 32)
        {
          if (localResultRecord.type == 1) {
            localResultRecord.name = ContactUtils.getTroopMemberName(this.app, localResultRecord.groupUin, localResultRecord.uin);
          } else if (localResultRecord.type == 2) {
            localResultRecord.name = ContactUtils.getDiscussionMemberName(this.app, localResultRecord.groupUin, localResultRecord.uin);
          }
        }
        else {
          localResultRecord.name = ContactUtils.getTroopMemberName(this.app, localResultRecord.groupUin, localResultRecord.uin);
        }
      }
      this.mSelectedAndSearchBar.a(true);
    }
    this.mRightBtn.setOnClickListener(new SelectMemberActivity.6(this));
  }
  
  protected void initTitleBar()
  {
    this.mLeftBackBtn.setVisibility(0);
    this.mLeftCancelBtn.setVisibility(8);
    this.mRightBtn.setVisibility(0);
    this.mLeftBackBtn.setText(2131718082);
    this.mLeftBackBtn.setBackgroundResource(0);
    this.mLeftBackBtn.setPadding(0, 0, 0, 0);
    this.mTitle.setText(this.mTitleString);
    if (AppSetting.c)
    {
      this.mTitle.setContentDescription(this.mTitleString);
      this.mLeftBackBtn.setContentDescription(getString(2131718082));
    }
    if (isShowDoneButtonInBottom())
    {
      this.mRightBtn.setVisibility(8);
      if (isCreateNewTroopEntrance())
      {
        this.mLeftBackBtn.setText("");
        this.mLeftBackBtn.setBackgroundResource(2130850593);
        this.mLeftCancelBtn.setVisibility(8);
      }
    }
    else
    {
      this.mLeftBackBtn.setOnClickListener(new SelectMemberActivity.5(this));
      setupDoneBtn();
      if (this.mIntent.getBooleanExtra("show_invite_entry", false))
      {
        if (this.mEntrance != 35) {
          break label262;
        }
        this.mRightBtn.setText(2131718080);
        mrf.f();
      }
    }
    for (;;)
    {
      this.mRightBtn.setVisibility(0);
      return;
      if (isInviteTroopMember())
      {
        this.mLeftBackBtn.setText(2131690620);
        this.mLeftBackBtn.setBackgroundDrawable(null);
        break;
      }
      this.mLeftBackBtn.setText("");
      this.mLeftBackBtn.setBackgroundResource(2130850593);
      break;
      label262:
      this.mRightBtn.setText(2131718081);
    }
  }
  
  boolean isCreateNewTroopEntrance()
  {
    return (this.mEntrance == 27) || (this.mEntrance == 28) || (this.mEntrance == 12) || (this.mEntrance == 29) || (this.mEntrance == 39);
  }
  
  boolean isCreateNewTypeTroop()
  {
    boolean bool = isCreateNewTroopEntrance();
    int j = this.mResultList.size();
    if (this.mUinsSelectedDefault != null) {}
    for (int i = this.mUinsSelectedDefault.size(); (bool) && (this.mSubType == 0) && (i + j >= 1); i = 0) {
      return true;
    }
    return false;
  }
  
  boolean isGroupMember(String paramString)
  {
    Iterator localIterator = this.mGroupmembers.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((TroopMemberInfo)localIterator.next()).memberuin, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  boolean isInviteTroopMember()
  {
    return (this.mType == 1) && (this.mSubType == 1);
  }
  
  public boolean isInvitedListContainFriend(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mInvitedUinList.size())
      {
        if (((String)this.mInvitedUinList.get(i)).equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean isMemberOverLoad(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((this.mEntrance == 32) && (paramBoolean) && (this.mIntent.getBooleanExtra("param_enable_all_select", false))) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (this.mType != 3000) {
            break;
          }
        } while (this.mResultList.size() < this.mMaxSelectNumber);
        if ((this.mEntrance == 12) && (this.mMaxSelectNumber == 1)) {
          showMemberOverloadToast(2131691670);
        }
        for (;;)
        {
          return true;
          showMemberOverloadToast(2131691665);
        }
        if (this.mType != 1) {
          break label711;
        }
        if ((this.mIsLimitToInviteByTroopMaxLimit) && (this.mResultList.size() >= this.mMaxSelectNumber))
        {
          showMemberOverloadToast(amtj.a(2131712843));
          return true;
        }
        if (this.mSubType != 0) {
          break;
        }
      } while (this.mResultList.size() < this.mMaxSelectNumber);
      showMemberOverloadToast(getString(2131719324));
      return true;
      if (this.mSubType != 1) {
        break;
      }
      if (this.mResultList.size() >= this.mMaxSelectNumber)
      {
        showMemberOverloadToast(2131719324);
        return true;
      }
    } while ((this.mEntrance != 11) || (this.mGroupmembers == null));
    int k = this.mGroupmembers.size() + 1;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    String str = this.mIntent.getStringExtra("group_uin");
    int i = localTroopManager.c(str).getMemNumForAutoInviteIntoGroup(this.app);
    if (i > k)
    {
      i -= k;
      label276:
      int j = getOutGroupMem().size();
      int m = this.mResultList.size();
      paramBoolean = isGroupMember(paramString2);
      if (AudioHelper.f()) {
        QLog.w("SelectMemberActivity", 1, "isMemberOverLoad[" + paramString1 + "], 可邀请的群外成员到达上限检查, 已经选择群内成员[" + (m - j) + "], 当前群成员[" + k + "], 实际可邀请的群外成员[" + i + "], 已经选择的群外成员[" + j + "], 当前选择的是群成员[" + paramBoolean + "], uin[" + paramString2 + "], name[" + paramString3 + "], type[" + paramInt + "], fromGroupUin[" + paramString4 + "], mResultList[" + this.mResultList.size() + "], groupUin[" + str + "], mGroupCode[" + this.mGroupCode + "]");
      }
      paramInt = j;
      if (!paramBoolean) {
        paramInt = j + 1;
      }
      if (paramInt <= i) {
        break label928;
      }
      paramBoolean = true;
      showMemberOverloadToast(2131719293);
    }
    for (;;)
    {
      return paramBoolean;
      i = 0;
      break label276;
      if (this.mSubType == 3)
      {
        if (this.mResultList.size() < this.mMaxSelectNumber) {
          break;
        }
        showMemberOverloadToast(getString(2131719292));
        bcef.b(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, this.mGroupCode, muk.a(this.app, this.app.getCurrentAccountUin(), this.mGroupCode) + "", "", "");
        return true;
      }
      if (this.mSubType == 4)
      {
        if (this.mResultList.size() < this.mMaxSelectNumber) {
          break;
        }
        showMemberOverloadToast(getString(2131719097, new Object[] { Integer.valueOf(this.mMaxSelectNumber) }));
        return true;
      }
      if (this.mResultList.size() < this.mMaxSelectNumber) {
        break;
      }
      if (this.mEntrance == 35) {
        showMemberOverloadToast(2131719324);
      }
      for (;;)
      {
        return true;
        showMemberOverloadToast(2131719292);
      }
      label711:
      if (this.mType == 9003)
      {
        if (this.mEntrance == 15)
        {
          paramInt = this.mBlessManager.f();
          if (this.mResultList.size() < paramInt) {
            break;
          }
          showMemberOverloadToast(String.format(getString(2131690580), new Object[] { Integer.valueOf(this.mBlessManager.e()) }));
          return true;
        }
        if (this.mEntrance != 32) {
          break;
        }
        paramInt = this.mBlessManager.k();
        if (this.mResultList.size() < paramInt) {
          break;
        }
        showMemberOverloadToast(String.format(getString(2131690580), new Object[] { Integer.valueOf(this.mBlessManager.h()) }));
        return true;
      }
      if (this.mResultList.size() < this.mMaxSelectNumber) {
        break;
      }
      i = 0;
      paramInt = i;
      if (this.mOverloadTipsIncludeDefaultCount)
      {
        paramInt = i;
        if (this.mUinsSelectedDefault != null) {
          paramInt = this.mUinsSelectedDefault.size();
        }
      }
      showMemberOverloadToast(String.format(getString(2131694283), new Object[] { Integer.valueOf(paramInt + this.mMaxSelectNumber) }));
      return true;
      label928:
      paramBoolean = false;
    }
  }
  
  protected boolean isMemberOverload(String paramString1, String paramString2)
  {
    if (this.mType == 9003)
    {
      if ((this.mEntrance == 15) && (!this.mBlessManager.a(paramString1)) && (this.mUnblessedUinCount >= this.mBlessManager.d())) {
        showMemberOverloadToast(String.format(getString(2131690581), new Object[] { Integer.valueOf(this.mBlessManager.c()) }));
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.mEntrance == 32)
        {
          bool2 = bool1;
          if (!this.mBlessManager.b(paramString1))
          {
            bool2 = bool1;
            if (this.mUnblessedUinCount >= this.mBlessManager.j())
            {
              showMemberOverloadToast(String.format(getString(2131719618), new Object[] { Integer.valueOf(this.mBlessManager.i()) }));
              bool2 = true;
            }
          }
        }
        return bool2;
      }
    }
    return false;
  }
  
  public boolean isResultListContainFriend(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mResultList.size())
      {
        if (((ResultRecord)this.mResultList.get(i)).uin.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean isShowDoneButtonInBottom()
  {
    if ((isCreateNewTroopEntrance()) || (isInviteTroopMember())) {}
    while ((this.mEntrance == 35) || (this.mEntrance == 40)) {
      return true;
    }
    return false;
  }
  
  public boolean isSoftInputShowing()
  {
    return this.mIsSoftInputShowing;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAction(View paramView)
  {
    Object localObject2 = (bayp)paramView.getTag(2131380831);
    if (localObject2 == null) {}
    String str;
    Object localObject1;
    label232:
    do
    {
      return;
      if (this.mEntrance == 33) {
        bcef.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
      }
      paramView = ((bayp)localObject2).b();
      str = ((bayp)localObject2).a().toString();
      localObject1 = "-1";
      if ((localObject2 instanceof baxd))
      {
        localObject1 = ((baxd)localObject2).e();
        if ((localObject2 instanceof baxl))
        {
          paramView = ((baxl)localObject2).a;
          if (!TextUtils.isEmpty(paramView.uin)) {
            break label232;
          }
          paramView = "pstn" + paramView.mobileNo;
        }
      }
      for (;;)
      {
        if (!(localObject2 instanceof baxb)) {
          break label281;
        }
        paramView = new Bundle();
        paramView.putString("group_uin", ((baxb)localObject2).b());
        paramView.putString("group_name", ((baxb)localObject2).c());
        this.mInnerFrameManager.a(7, paramView);
        quitSearchState();
        return;
        if (!(localObject2 instanceof baxk)) {
          break;
        }
        localObject1 = ((baxk)localObject2).a;
        break;
        if (paramView.uin.equals("0")) {
          paramView = paramView.nationCode + paramView.mobileCode;
        } else {
          paramView = paramView.uin;
        }
      }
      if ((localObject2 instanceof baxj))
      {
        paramView = (baxj)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          QQToast.a(this, 0, getResources().getString(2131697089), 0).b(getResources().getDimensionPixelSize(2131299076));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.b());
        ((Bundle)localObject1).putString("group_name", paramView.c());
        this.mInnerFrameManager.a(6, (Bundle)localObject1);
        quitSearchState();
        return;
      }
      if ((localObject2 instanceof baxo))
      {
        paramView = (baxo)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          QQToast.a(this, 0, getResources().getString(2131697089), 0).b(getResources().getDimensionPixelSize(2131299076));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.b());
        ((Bundle)localObject1).putString("group_name", paramView.c());
        this.mInnerFrameManager.a(6, (Bundle)localObject1);
        quitSearchState();
        return;
      }
      if (isInvitedListContainFriend(paramView))
      {
        QQToast.a(this, 1, amtj.a(2131712854), 0).b(getTitleBarHeight());
        bcef.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, (String)localObject1, "", "", "");
        return;
      }
    } while (((this.mUinsSelectedDefault != null) && (this.mUinsSelectedDefault.contains(paramView))) || (isResultListContainFriend(paramView)) || (isMemberOverLoad("onAction", false, paramView, str, -1, (String)localObject1)) || (isMemberOverload(paramView, str)));
    label281:
    SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.mInnerFrameManager.getCurrentView();
    int i;
    if ((this.mInnerFrameManager.a() == 5) || (this.mInnerFrameManager.a() == 0) || (this.mInnerFrameManager.a() == 4) || (this.mInnerFrameManager.a() == 3) || (this.mInnerFrameManager.a() == 8))
    {
      i = -1;
      if ((localObject2 instanceof baxd))
      {
        i = 2;
        if (i != -1) {
          this.mResultList.add(constructAResultRecord(paramView, str, i, (String)localObject1));
        }
        label752:
        onResultListChanged();
        setupDoneBtn();
        localSelectMemberInnerFrame.f();
        this.mSelectedAndSearchBar.a(true);
        this.mSelectedAndSearchBar.a();
        if (this.mType == 9003) {
          if ((this.mEntrance != 15) || (this.mBlessManager.a(paramView))) {
            break label1148;
          }
        }
      }
    }
    for (this.mUnblessedUinCount += 1;; this.mUnblessedUinCount += 1) {
      label1148:
      do
      {
        startRelationFriendAndTroopSearch(false);
        return;
        if ((localObject2 instanceof baxk))
        {
          i = 1;
          break;
        }
        if ((localObject2 instanceof baxe))
        {
          i = 0;
          break;
        }
        if (!(localObject2 instanceof baxl)) {
          break;
        }
        if ((paramView.startsWith("pstn")) && (preAddPstnNumber(paramView, str, 5, (String)localObject1)))
        {
          i = 5;
          break;
        }
        if (paramView.startsWith("+"))
        {
          i = 4;
          break;
        }
        i = 0;
        break;
        if (this.mInnerFrameManager.a() == 6)
        {
          this.mResultList.add(constructAResultRecord(paramView, str, 1, localSelectMemberInnerFrame.a()));
          break label752;
        }
        if (this.mInnerFrameManager.a() == 7)
        {
          this.mResultList.add(constructAResultRecord(paramView, str, 2, localSelectMemberInnerFrame.a()));
          break label752;
        }
        if (this.mInnerFrameManager.a() == 1)
        {
          if ((paramView.startsWith("pstn")) && (preAddPstnNumber(paramView, str, 5, localSelectMemberInnerFrame.a())))
          {
            this.mResultList.add(constructAResultRecord(paramView, str, 5, localSelectMemberInnerFrame.a()));
            break label752;
          }
          if (paramView.startsWith("+"))
          {
            this.mResultList.add(constructAResultRecord(paramView, str, 4, localSelectMemberInnerFrame.a()));
            break label752;
          }
          this.mResultList.add(constructAResultRecord(paramView, str, 0, localSelectMemberInnerFrame.a()));
          break label752;
        }
        if (this.mInnerFrameManager.a() != 9) {
          break label752;
        }
        localObject1 = constructAResultRecord(paramView, str, 1, localSelectMemberInnerFrame.a());
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localObject1);
        addFriendResults((List)localObject2, false);
        break label752;
      } while ((this.mEntrance != 32) || (this.mBlessManager.b(paramView)));
    }
  }
  
  public boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.mSelectedAndSearchBar.a()))
    {
      quitSearchState();
      return true;
    }
    if (this.mSelectedAndSearchBar.a()) {
      quitSearchState();
    }
    switch (this.mInnerFrameManager.a())
    {
    }
    for (;;)
    {
      return super.onBackEvent();
      stopTitleProgress();
      this.mInnerFrameManager.a(0);
      return true;
      if (this.mOnlySelectTroopOrDiscussionMember)
      {
        if (this.mEntrance == 27)
        {
          this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
          setResult(-1, this.mIntent);
        }
        finish();
      }
      for (;;)
      {
        return true;
        stopTitleProgress();
        this.mInnerFrameManager.a(0);
      }
      if (this.mOnlyTroopMember) {
        finish();
      }
      for (;;)
      {
        return true;
        stopTitleProgress();
        this.mInnerFrameManager.a(3);
      }
      if (this.mOnlyDiscussionMember) {
        finish();
      }
      for (;;)
      {
        return true;
        stopTitleProgress();
        this.mInnerFrameManager.a(3);
      }
      this.mInnerFrameManager.a(0);
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    label161:
    ResultRecord localResultRecord;
    Intent localIntent;
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131378911: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.mTooManyMembersTipsBar.setVisibility(8);
        this.isClosed = true;
        bcef.b(this.app, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, this.mGroupCode, muk.a(this.app, this.app.getCurrentAccountUin(), this.mGroupCode) + "", "", "");
      }
    case 2131365228: 
      if (this.mEntrance == 35)
      {
        if (this.mResultList.size() >= 1)
        {
          localObject1 = "1";
          bcef.b(this.app, "CliOper", "", "", "0X8009E2B", "0X8009E2B", 0, 0, (String)localObject1, "", "", "");
        }
      }
      else
      {
        if ((this.mEntrance != 12) || (this.mResultList.size() != 1)) {
          break label468;
        }
        localResultRecord = (ResultRecord)this.mResultList.get(0);
        localIntent = new Intent();
        localIntent.putExtra("select_memeber_single_friend", true);
        localIntent.putExtra("select_memeber_single_friend_type", localResultRecord.type);
        if ((localResultRecord.type == 0) && (localResultRecord.type != 1)) {
          break label815;
        }
        i = 1000;
      }
      break;
    }
    for (Object localObject1 = getTroopCodeFromTroopUin(localResultRecord.groupUin);; localObject1 = null)
    {
      if (localResultRecord.type == 2)
      {
        localObject1 = localResultRecord.groupUin;
        i = 1004;
      }
      for (;;)
      {
        if (localResultRecord.type == 3) {
          i = 1021;
        }
        for (;;)
        {
          Object localObject2 = ((amsw)this.app.getManager(51)).e(localResultRecord.uin);
          int j = i;
          if (localObject2 != null)
          {
            j = i;
            if (((Friends)localObject2).isFriend()) {
              j = 0;
            }
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("uin", localResultRecord.uin);
          ((Bundle)localObject2).putInt("uintype", j);
          ((Bundle)localObject2).putString("uinname", localResultRecord.name);
          ((Bundle)localObject2).putString("troop_uin", (String)localObject1);
          localIntent.putExtras((Bundle)localObject2);
          setResult(-1, localIntent);
          finish();
          break;
          localObject1 = "2";
          break label161;
          if (localResultRecord.type == 4)
          {
            i = 1006;
            continue;
            label468:
            if (isCreateNewTroopEntrance())
            {
              createNewTypeDiscussion();
              break;
            }
            if (isInviteTroopMember())
            {
              if (this.mEntrance == 11)
              {
                localObject1 = getOutGroupMem();
                if (((ArrayList)localObject1).size() > 0)
                {
                  bfur.a(this, 230, getString(2131695219), getString(2131695099), 2131694952, 2131694964, new SelectMemberActivity.17(this, (ArrayList)localObject1), new SelectMemberActivity.18(this)).show();
                  break;
                }
                afterCreateTroopSucc(this.mIntent.getStringExtra("group_uin"), false);
                break;
              }
              if (this.mEntrance == 37)
              {
                this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
                setResult(-1, this.mIntent);
                finish();
                break;
              }
              doInviteTroopMember(this.mResultList);
              break;
            }
            this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
            setResult(-1, this.mIntent);
            finish();
            break;
            quitSearchState();
            if (getResultUins().size() == 1)
            {
              localObject1 = (String)getResultUins().get(0);
              if (this.mOnSelectStateChangeListener == null) {
                break;
              }
              this.mOnSelectStateChangeListener.onAddSingleFrd((String)localObject1);
              break;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("TROOP_UIN", this.mIntent.getStringExtra("group_uin"));
            ((Intent)localObject1).putExtra("hide_title_left_arrow", true);
            PublicFragmentActivity.a(this, (Intent)localObject1, UnitedVerifyMsgEditFragment.class, 10);
            overridePendingTransition(2130771997, 2130771990);
            localObject1 = getIntent().getStringExtra("group_uin");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            ThreadManager.post(new SelectMemberActivity.19(this, (String)localObject1), 5, null, true);
            break;
          }
        }
      }
      label815:
      i = 0;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreateTroopCompletely(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString))) {
      bcef.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "cre_suc", 0, 0, paramString, "", "", "");
    }
    do
    {
      return;
      paramInt = beah.a(paramInt);
    } while (paramInt == 0);
    QQToast.a(this, 1, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void onInviteComplete(int paramInt, String paramString)
  {
    int i = 1;
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.w("SelectMemberActivity", 1, "onInviteComplete, retCode[" + paramInt + "], troopUin[" + paramString + "], mSubType[" + this.mSubType + "], mEntrance[" + this.mEntrance + "]");
    }
    if (paramInt == 0) {}
    for (paramInt = i; paramInt != 0; paramInt = 0)
    {
      afterCreateTroopSucc(paramString, false);
      return;
    }
    QQToast.a(this, getString(2131691636), 2000).b(this.mTitleBar.getHeight());
  }
  
  public boolean onListViewItemClick(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool1;
    if (isResultListContainFriend(paramString1))
    {
      bool1 = false;
      removeFriendFromResultList(paramString1);
    }
    for (;;)
    {
      if (isInvitedListContainFriend(paramString1))
      {
        removeFriendFromResultList(paramString1);
        QQToast.a(this, 1, amtj.a(2131712863), 0).b(getTitleBarHeight());
        bcef.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool1 = false;
      }
      this.mSelectedAndSearchBar.a(bool1);
      setupDoneBtn();
      onResultListChanged();
      startRelationFriendAndTroopSearch(true);
      return bool1;
      if ((!isMemberOverLoad("onListViewItemClick1", false, paramString1, paramString2, paramInt, paramString3)) && (!isMemberOverload(paramString1, paramString2)) && (preAddPstnNumber(paramString1, paramString2, paramInt, paramString3)))
      {
        boolean bool2 = true;
        this.mResultList.add(constructAResultRecord(paramString1, paramString2, paramInt, paramString3));
        bool1 = bool2;
        if (this.mType == 9003) {
          if ((this.mEntrance == 15) && (!this.mBlessManager.a(paramString1)))
          {
            this.mUnblessedUinCount += 1;
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (this.mEntrance == 32)
            {
              bool1 = bool2;
              if (!this.mBlessManager.b(paramString1))
              {
                this.mUnblessedUinCount += 1;
                bool1 = bool2;
              }
            }
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public boolean onListViewItemClick(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    boolean bool;
    if (isResultListContainFriend(paramString1))
    {
      bool = false;
      removeFriendFromResultList(paramString1);
    }
    for (;;)
    {
      if (isInvitedListContainFriend(paramString1))
      {
        removeFriendFromResultList(paramString1);
        QQToast.a(this, 1, amtj.a(2131712828), 0).b(getTitleBarHeight());
        bcef.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool = false;
      }
      this.mSelectedAndSearchBar.a(bool);
      setupDoneBtn();
      onResultListChanged();
      return bool;
      if ((!isMemberOverLoad("onListViewItemClick2", false, paramString1, paramString2, paramInt, paramString3)) && (preAddPstnNumber(paramString1, paramString2, paramInt, paramString3)))
      {
        bool = true;
        this.mResultList.add(constructAResultRecord(paramString1, paramString2, paramInt, paramString3, paramString4));
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void onRelationTroopItemClick(String paramString)
  {
    if ((this.mEntrance == 38) || (this.mEntrance == 29) || (this.mEntrance == 39))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: empty");
      }
    }
    return;
    label51:
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: troopUin:" + paramString);
    }
    onReusedTroop(paramString);
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  protected void onResultListChanged()
  {
    boolean bool = false;
    String str = null;
    Iterator localIterator = this.mResultList.iterator();
    int i = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type != 5) {
        break label365;
      }
      if (i >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.contactSearchFragment != null) {
        this.contactSearchFragment.a(getResultUins(), this.mUinsSelectedDefault);
      }
      if (isShowDoneButtonInBottom())
      {
        i = this.mResultList.size();
        if (i <= 0) {
          break label278;
        }
        if ((this.mEntrance != 35) && (this.mEntrance != 40)) {
          break label235;
        }
        str = MessageFormat.format(this.mDoneBtnText_x, new Object[] { Integer.valueOf(i) });
        this.mCreateTroopButton.setText(str);
        this.mCreateTroopButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.mCreateTroopButton, true);
      }
      if (isInviteTroopMember()) {
        refreshInviteTipsBar();
      }
      return;
    }
    if (str == null)
    {
      str = localResultRecord.name;
      label196:
      i += 1;
    }
    label235:
    label365:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.name;
      break label196;
      if (isCreateNewTroopEntrance()) {}
      for (str = amtj.a(2131712864);; str = amtj.a(2131712841))
      {
        str = MessageFormat.format(str, new Object[] { Integer.valueOf(i) });
        break;
      }
      if (this.mEntrance == 35)
      {
        str = this.mDoneBtnText;
        bool = true;
      }
      for (;;)
      {
        this.mCreateTroopButton.setText(str);
        this.mCreateTroopButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.mCreateTroopButton, bool);
        break;
        if (this.mEntrance == 40) {
          str = this.mDoneBtnText;
        } else if (isCreateNewTroopEntrance()) {
          str = amtj.a(2131712832);
        } else {
          str = amtj.a(2131712866);
        }
      }
    }
  }
  
  public void onReusedTroop(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SelectMemberActivity", 1, "onReusedTroop,troopUin[" + paramString + "], mSubType[" + this.mSubType + "], mEntrance[" + this.mEntrance + "]");
    }
    afterCreateTroopSucc(paramString, true);
  }
  
  boolean preAddPstnNumber(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool;
    int i;
    if (paramInt == 5)
    {
      bool = isNotMaxOfPSTN();
      if (!bool) {
        QQToast.a(this, 2131718103, 1).b(getTitleBarHeight());
      }
      i = getCheckPhoneNumberResId(paramString1);
      if (i != 0) {
        break label76;
      }
    }
    label76:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        QQToast.a(this, i, 1).b(getTitleBarHeight());
      }
      if ((!bool) || (paramInt == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  protected ArrayList<ResultRecord> processResult()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mResultList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public void qCircleReport(ArrayList<ResultRecord> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      localObject = null;
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = (ArrayList<ResultRecord>)localObject;
      if (localIterator.hasNext())
      {
        localObject = (ResultRecord)localIterator.next();
        if ((localObject != null) && (!TextUtils.isEmpty(((ResultRecord)localObject).uin))) {
          if (paramArrayList == null) {
            paramArrayList = new StringBuilder(((ResultRecord)localObject).uin + "");
          }
        }
        for (;;)
        {
          break;
          paramArrayList.append("|" + ((ResultRecord)localObject).uin);
        }
      }
      if (paramArrayList != null) {
        if (paramInt != 41) {
          break label157;
        }
      }
    }
    label157:
    for (Object localObject = "1";; localObject = "2")
    {
      QCircleLpReportDc05504.report("", 41, 1, 2, (String)localObject, "", paramArrayList.toString(), "", "");
      return;
    }
  }
  
  void quitSearchState()
  {
    this.imm.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.mSelectedAndSearchBar.a();
    this.mSelectedAndSearchBar.b();
    this.mSearchResultLayout.setVisibility(8);
    this.mIsSoftInputShowing = false;
  }
  
  public void refreshGVideoTextView(boolean paramBoolean, int paramInt)
  {
    if (this.mSubType == 3)
    {
      this.mGVideoTextView = ((TextView)findViewById(2131377025));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.mGVideoTextView.setVisibility(0);
        this.mGVideoTextView.setText(getString(2131697279, new Object[] { Integer.valueOf(Math.min(paramInt, this.mMaxSelectNumber)) }));
      }
    }
    else
    {
      return;
    }
    this.mGVideoTextView.setVisibility(0);
    this.mGVideoTextView.setText(getString(2131697281, new Object[] { Integer.valueOf(this.mMaxSelectNumber) }));
  }
  
  protected void refreshInviteTipsBar()
  {
    Object localObject = ((TroopManager)this.app.getManager(52)).c(this.mGroupCode);
    boolean bool1;
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x6100000) != 0L) {
        break label230;
      }
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        if (!((TroopInfo)localObject).isAdmin()) {
          bool2 = true;
        }
      }
      else
      {
        label54:
        if (((TroopInfo)localObject).maxInviteMemNum <= 0) {
          break label475;
        }
        if (((TroopInfo)localObject).wMemberNum + this.mResultList.size() <= ((TroopInfo)localObject).maxInviteMemNum) {
          break label339;
        }
        bool1 = true;
      }
      for (;;)
      {
        label82:
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "refreshInviteTipsBar needAdminCheck = " + bool2 + " needAgree = " + bool1);
        }
        if ((!bool2) && (!bool1))
        {
          this.needShowYellowTips = false;
          if ((this.mEntrance == 11) || (this.mEntrance == 36)) {
            this.mInviteSuccToastWording = getString(2131695117);
          }
        }
        for (;;)
        {
          if ((this.isClosed) || (!this.needShowYellowTips) || (TextUtils.isEmpty(this.mYellowTipsWording))) {
            break label465;
          }
          this.mTooManyMembersTipsBar.setVisibility(0);
          localObject = (TextView)this.mTooManyMembersTipsBar.findViewById(2131378912);
          ((TextView)localObject).setText(this.mYellowTipsWording);
          ((TextView)localObject).setContentDescription(this.mYellowTipsWording);
          return;
          label230:
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.mResultList.size() > 50)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.mResultList.size() > 100)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label480;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label54;
          label339:
          bool1 = false;
          break label82;
          this.mInviteSuccToastWording = amtj.a(2131712858);
          continue;
          if ((!bool2) && (bool1))
          {
            this.needShowYellowTips = true;
            this.mYellowTipsWording = amtj.a(2131712839);
            this.mInviteSuccToastWording = amtj.a(2131712868);
          }
          else if ((bool2) && (bool1))
          {
            this.needShowYellowTips = true;
            this.mYellowTipsWording = amtj.a(2131712855);
            this.mInviteSuccToastWording = amtj.a(2131712844);
          }
          else if ((bool2) && (!bool1))
          {
            this.needShowYellowTips = true;
            this.mYellowTipsWording = amtj.a(2131712835);
            this.mInviteSuccToastWording = amtj.a(2131712846);
          }
        }
        label465:
        this.mTooManyMembersTipsBar.setVisibility(8);
        return;
        label475:
        bool1 = false;
      }
      label480:
      bool1 = false;
    }
  }
  
  public boolean removeAllFriendResult()
  {
    this.mResultList.clear();
    this.mSelectedAndSearchBar.a(false);
    setupDoneBtn();
    onResultListChanged();
    return true;
  }
  
  public void removeFriendFromResultList(String paramString)
  {
    int i = 0;
    if (i < this.mResultList.size())
    {
      if (((ResultRecord)this.mResultList.get(i)).uin.equals(paramString))
      {
        this.mResultList.remove(i);
        if (this.mType == 9003) {
          if ((this.mEntrance != 15) || (this.mBlessManager.a(paramString))) {
            break label90;
          }
        }
      }
      for (this.mUnblessedUinCount -= 1;; this.mUnblessedUinCount -= 1) {
        label90:
        do
        {
          i += 1;
          break;
        } while ((this.mEntrance != 32) || (this.mBlessManager.b(paramString)));
      }
    }
    onResultListChanged();
  }
  
  public void reportInviteFriend(String paramString)
  {
    ThreadManagerV2.excute(new SelectMemberActivity.8(this, paramString), 32, null, false);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void sendContactsListBroadcast()
  {
    if ((this.mResultList != null) && (this.mResultList.size() > 0))
    {
      Object localObject = processResult();
      Intent localIntent = new Intent("tencent.video.q2v.SelectMember");
      localIntent.setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject).size() > 0) {
        localIntent.putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject);
      }
      int i = this.mResultList.size();
      localObject = ((ResultRecord)this.mResultList.get(0)).name;
      localIntent.putExtra("InviteCount", i);
      localIntent.putExtra("FirstName", (String)localObject);
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  protected void setContentLayout()
  {
    try
    {
      setContentView(2131562781);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("SelectMemberActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
    }
  }
  
  public void setGroupMembers(ArrayList<Entity> paramArrayList)
  {
    this.mGroupmembers = paramArrayList;
  }
  
  void setNotAdminInviteMemberCount(int paramInt)
  {
    long l = bftf.a();
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l + ":" + paramInt);
    localEditor.commit();
  }
  
  public void setOnSelectStateChangeListener(SelectMemberActivity.IOnSelectStateChange paramIOnSelectStateChange)
  {
    this.mOnSelectStateChangeListener = paramIOnSelectStateChange;
  }
  
  public void setupDoneBtn()
  {
    if (this.mFrom == 30) {
      return;
    }
    if (this.mResultList.size() >= this.mMinSelectNumber)
    {
      setDoneBtnEnabled(true);
      return;
    }
    setDoneBtnEnabled(false);
  }
  
  public void setupTitleBar(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.mLeftBackBtn.setVisibility(0);
      this.mLeftBackBtn.setText(paramString1);
      this.mLeftBackBtn.setOnClickListener(new SelectMemberActivity.2(this));
      this.mLeftBackBtn.setBackgroundResource(2130850593);
      this.mLeftCancelBtn.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.mLeftBackBtn);
      if ((this.mEntrance != 14) && (this.mEntrance != 21) && (this.mEntrance != 25) && (this.mEntrance != 35)) {
        break label206;
      }
      if (TextUtils.isEmpty(this.mTitleString)) {
        break label195;
      }
      this.mTitle.setText(this.mTitleString);
      label118:
      if (AppSetting.c)
      {
        this.mTitle.setContentDescription(this.mTitle.getText());
        paramString2 = this.mLeftBackBtn;
        if (!TextUtils.isEmpty(this.mLeftBackBtn.getText())) {
          break label395;
        }
      }
    }
    label395:
    for (paramString1 = amtj.a(2131712856);; paramString1 = this.mLeftBackBtn.getText())
    {
      paramString2.setContentDescription(paramString1);
      this.mLeftBackBtn.postDelayed(new SelectMemberActivity.4(this), 1000L);
      return;
      initTitleBar();
      break;
      label195:
      this.mTitle.setText(paramString2);
      break label118;
      label206:
      if (this.mSubType == 3)
      {
        this.mTitle.setText(getString(2131697280));
        break label118;
      }
      if (this.mFrom == 30)
      {
        this.mTitleString = getString(2131689570);
        if (!this.mTitle.getText().equals(this.mTitleString)) {
          this.mTitle.setText(this.mTitleString);
        }
        if (this.mRightBtn.getVisibility() != 0) {
          this.mRightBtn.setVisibility(0);
        }
        if (8 != this.mLeftCancelBtn.getVisibility()) {
          this.mLeftCancelBtn.setVisibility(8);
        }
        this.mLeftBackBtn.setVisibility(0);
        this.mRightBtn.setVisibility(8);
        this.mLeftBackBtn.setOnClickListener(new SelectMemberActivity.3(this));
        if (!AppSetting.c) {
          break label118;
        }
        this.mTitle.setContentDescription(this.mTitleString);
        this.mLeftBackBtn.setContentDescription(getString(2131718082));
        break label118;
      }
      this.mTitle.setText(paramString2);
      break label118;
    }
  }
  
  void showAllSelectBtn()
  {
    int i = 0;
    if (this.mEntrance != 35) {}
    RelativeLayout localRelativeLayout;
    do
    {
      do
      {
        return;
      } while (!this.mIntent.getBooleanExtra("param_enable_all_select", false));
      localRelativeLayout = (RelativeLayout)findViewById(2131376609);
    } while (localRelativeLayout == null);
    if (this.mIsSelectAllMembers) {}
    for (;;)
    {
      localRelativeLayout.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  protected void startCreateOrAdd()
  {
    if ((this.mType == 3000) && (isCreateNewTypeTroop()))
    {
      createNewTypeDiscussion();
      return;
    }
    Object localObject1;
    label167:
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    switch (this.mType)
    {
    default: 
      localObject1 = this.mIntent.getStringExtra("group_uin");
      if ((localObject1 != null) && (this.mEntrance == 32) && ((this.mOnlyTroopMember) || (this.mOnlyDiscussionMember)))
      {
        this.mIntent.putExtra("group_uin", (String)localObject1);
        if (!this.mOnlyTroopMember) {
          break label705;
        }
        localObject1 = ((TroopManager)this.app.getManager(52)).c((String)localObject1);
        this.mIntent.putExtra("group_type", 4);
        if (localObject1 != null)
        {
          this.mIntent.putExtra("group_name", ((TroopInfo)localObject1).troopname);
          this.mIntent.putExtra("group_member_type", ((TroopInfo)localObject1).wMemberNum);
        }
      }
      if ((this.mEntrance == 42) || (this.mEntrance == 41)) {
        qCircleReport(this.mResultList, this.mEntrance);
      }
      this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.mIntent);
      finish();
      return;
    case 3000: 
      if (this.mAddPassedMembersToResultSet)
      {
        localObject1 = this.mUinsSelectedDefault.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!hasAdd2ResultList((String)localObject2))
          {
            localObject3 = new ResultRecord();
            ((ResultRecord)localObject3).uin = ((String)localObject2);
            ((ResultRecord)localObject3).type = 0;
            ((ResultRecord)localObject3).groupUin = "-1";
            this.mResultList.add(localObject3);
          }
        }
      }
      localObject1 = (amsw)this.app.getManager(51);
      this.mResultList.size();
      localObject2 = this.mResultList.iterator();
      i = 0;
      j = 0;
      label371:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        if (((ResultRecord)localObject3).type == 3) {
          j = 1;
        }
        if (((ResultRecord)localObject3).type != 5)
        {
          i = 1;
          if ((j == 0) || (i == 0)) {
            break;
          }
        }
      }
      label415:
      break;
    }
    for (;;)
    {
      if (j != 0)
      {
        bcef.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        label463:
        if (this.mSubType != 0) {
          break label650;
        }
        bcef.b(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
        label506:
        if (this.mSubType != 0) {
          break label689;
        }
      }
      label650:
      label689:
      for (j = 2131691638;; j = 2131691635)
      {
        this.mQQProgressDialog = new bhht(this, getResources().getDimensionPixelSize(2131299076));
        this.mQQProgressDialog.c(j);
        this.mQQProgressDialog.show();
        if ((this.mSubType == 0) || (i != 0))
        {
          localObject1 = new SelectMemberActivity.12(this, (amsw)localObject1);
          ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
          ThreadManager.postImmediately((Runnable)localObject1, null, false);
        }
        if (this.mSubType == 0) {
          break;
        }
        sendContactsListBroadcast();
        if (i != 0) {
          break;
        }
        finish();
        return;
        break label371;
        bcef.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break label463;
        bcef.b(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
        break label506;
      }
      doInviteTroopMember(this.mResultList);
      return;
      label705:
      if (!this.mOnlyDiscussionMember) {
        break label167;
      }
      localObject2 = (amrb)this.app.getManager(53);
      localObject3 = ((amrb)localObject2).a((String)localObject1);
      this.mIntent.putExtra("group_type", 8);
      this.mIntent.putExtra("group_member_type", ((amrb)localObject2).a((String)localObject1));
      if (localObject3 == null) {
        break label167;
      }
      this.mIntent.putExtra("group_name", ((DiscussionInfo)localObject3).discussionName);
      break label167;
      break label415;
    }
  }
  
  public void startTitleProgress()
  {
    if ((this.mTitle != null) && (this.mAnimationDrawable == null))
    {
      this.mAnimationDrawable = getResources().getDrawable(2130839449);
      this.mTitle.setCompoundDrawablePadding(10);
      this.mTitle.setCompoundDrawablesWithIntrinsicBounds(this.mAnimationDrawable, null, null, null);
      ((Animatable)this.mAnimationDrawable).start();
    }
  }
  
  public void stopTitleProgress()
  {
    if ((this.mTitle != null) && (this.mAnimationDrawable != null))
    {
      ((Animatable)this.mAnimationDrawable).stop();
      this.mAnimationDrawable = null;
      this.mTitle.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void toggleSelectMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    int i;
    if (!paramBoolean2)
    {
      if (!this.mModeMulti)
      {
        bool1 = true;
        this.mModeMulti = bool1;
      }
    }
    else
    {
      localObject = this.mMultiSearchView;
      if (!this.mModeMulti) {
        break label239;
      }
      i = 0;
      label38:
      ((View)localObject).setVisibility(i);
      setupTitleBar(false, "", "");
      if (!this.mModeMulti) {
        break label274;
      }
      this.mMultiAddContainerV.setVisibility(0);
      if (!this.mResultList.isEmpty()) {
        break label245;
      }
      localObject = getString(2131690972);
      label89:
      if (this.mMultiAddBtn != null) {
        this.mMultiAddBtn.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.mSelectedAndSearchBar.a();
      if (this.mMultiAddBtn != null)
      {
        localObject = this.mMultiAddBtn;
        bool1 = bool2;
        if (!this.mResultList.isEmpty()) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      if ((this.mOnSelectStateChangeListener != null) && (!paramBoolean2)) {
        this.mOnSelectStateChangeListener.toggleSelectMode(true, paramBoolean2);
      }
      if (!paramBoolean1)
      {
        this.mSelectedAndSearchBar.a(true);
        onResultListChanged();
      }
      quitSearchState();
      paramBoolean1 = this.mModeMulti;
      localObject = getIntent().getStringExtra("group_uin");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new SelectMemberActivity.20(this, paramBoolean1, (String)localObject), 5, null, true);
      }
      return;
      bool1 = false;
      break;
      label239:
      i = 8;
      break label38;
      label245:
      localObject = getString(2131690973, new Object[] { Integer.valueOf(this.mResultList.size()) });
      break label89;
      label274:
      this.mSearchResultLayout.setVisibility(8);
      this.mMultiSearchView.setVisibility(8);
      this.mMultiAddContainerV.setVisibility(8);
    }
  }
  
  public void updateMultiAddState(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (this.mEntrance != 30) {
      return;
    }
    if (this.mOnSelectStateChangeListener != null) {
      this.mOnSelectStateChangeListener.onSelect(paramResultRecord, paramBoolean);
    }
    if (this.mResultList.isEmpty())
    {
      paramResultRecord = getString(2131690972);
      label46:
      if (this.mMultiAddBtn == null) {
        break label110;
      }
      this.mMultiAddBtn.setText(paramResultRecord);
      paramResultRecord = this.mMultiAddBtn;
      if (this.mResultList.isEmpty()) {
        break label112;
      }
    }
    label110:
    label112:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramResultRecord.setEnabled(paramBoolean);
      return;
      paramResultRecord = getString(2131690973, new Object[] { Integer.valueOf(this.mResultList.size()) });
      break label46;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */