package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.QProxyManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.discussion.BizDiscussionObserver;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.troop.memberlist.TroopMemberList.TroopAdmin;
import com.tencent.mobileqq.troop.observer.TroopFeeObserver;
import com.tencent.mobileqq.troop.observer.TroopMessageObserver;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.troopmessage.api.ITroopMessageHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;

@RoutePage(desc="群成员列表", path="/troop/memberlist/TroopMemberList")
public class TroopMemberListActivity
  extends QBaseActivity
  implements IndexView.OnIndexChangedListener, IndexView.OnIndexChangedListener2, AdapterView.OnItemClickListener
{
  public static final int ADMIN_DELETE_MEMBER = 7;
  private static final double FAKE_DATA_MAX_PROGRESS = 0.9D;
  protected static double FAKE_PROGRESS_DELTA = 10.0D;
  public static final String GUEST_MEMBER_LIST_URL = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
  public static final int INVITE_FRIEND_JOIN = 6;
  private static int PROCESS_MEM_COUNT_PER_JOB = 1000;
  public static final int SHEET_MODE_ = 5;
  public static final String TAG = "TroopMemberListActivityget_troop_member";
  public static final String TAG_GET_TROOP_MEMBER = "get_troop_member";
  public static final int TRANSLATE_DISTANCE = 34;
  public static final int TRANSLATE_DURATION = 250;
  protected static final int TROOP_FEE_ENTRANCE_TYPE_CHECK_NOT_PAYED_MEMBERS = 2;
  protected static final int TROOP_FEE_ENTRANCE_TYPE_CHECK_PAYED_MEMBERS = 1;
  public final String PARAM_DELETED_UINS = "param_deleted_uins";
  public final String PARAM_SEQ_DAYS = "param_seq_days";
  public final String PARAM_SEQ_NAME = "param_seq_name";
  public View animatingView;
  public AppInterface app;
  protected ImageButton clear_text;
  private ArrayList<String> deletedInactiveUins = new ArrayList();
  protected String flowerRankListUrl = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
  private boolean hasSendFlowerPrivilege;
  private ArrayList<String> inactiveSeqDays = new ArrayList();
  private ArrayList<String> inactiveSeqName = new ArrayList();
  private View inactiveTitle;
  protected boolean isPositiveSort = true;
  protected boolean isSearchMode = false;
  protected String mActionMemberUin;
  protected ActionSheet mActionSheet;
  protected TroopMemberListActivity.ListAdapter mAdapter = null;
  public AddFrdHelper mAddFrdHelper = null;
  private String mAdminAndTeacherTitle = HardCodeUtil.a(2131715335);
  protected RelativeLayout mAllMemberLayout;
  protected Drawable mAnimDrawable;
  private long[] mBirthdays;
  protected boolean mCanAtAll = false;
  protected int mChatMode = 0;
  protected String mCustomTitleName = null;
  private DecimalFormat mDecimalFormat = new DecimalFormat("#.##");
  protected ArrayList<String> mDelList = new ArrayList();
  protected float mDensity = 1.5F;
  protected int mDiscRemainCout = 0;
  protected IDiscussionHandlerService mDiscussionHandler;
  protected DiscussionInfo mDiscussionInfo;
  protected List<DiscussionMemberInfo> mDiscussionMemberFromDB;
  public BizDiscussionObserver mDiscussionObserver = new TroopMemberListActivity.39(this);
  protected double mFakeProgess = 0.0D;
  private boolean mFilerRobot = false;
  public View.OnClickListener mFinishListener = new TroopMemberListActivity.10(this);
  public int mFrom = 0;
  protected Drawable mGaryCover;
  private long mGetTroopMemberFromDBIfNeededBeginTime = 0L;
  protected Handler mHandler = new TroopMemberListActivity.33(this);
  protected boolean mHasDeletedMember = false;
  protected List<String> mHideUins = new ArrayList();
  public int mIndexHeight = 0;
  protected IndexView mIndexView;
  private boolean mIsApollo = false;
  public boolean mIsDefaultTheme = true;
  boolean mIsHomeworkTroop = false;
  protected boolean mIsInDeleteState;
  protected boolean mIsInMultiDeleteState;
  protected boolean mIsPopUpStyle = false;
  protected boolean mIsQidianPrivateTroop;
  protected boolean mIsTroopAdmin = false;
  public int mItemHeight = 0;
  private int mJobCount = -1;
  protected LayoutInflater mLayoutInflater;
  protected TextView mLeftBackBtn;
  protected String mLeftBackBtnText;
  protected int mLeftMarginOfNick = 0;
  public List<TroopMemberListActivity.ATroopMember> mListData = new ArrayList();
  protected PinnedDividerSwipListView mListView;
  protected RelativeLayout mListZone;
  private boolean mLoadGiftListFinish = true;
  private boolean mLoadLocalFinish = false;
  protected RelativeLayout mLoadingLayout;
  protected TextView mLoadingTv;
  protected View mLoadingView;
  public int mMaxAvailableHeight = 0;
  public int mMaxItemCountPerPage = 50;
  protected long mMemberListReqStartTime = 0L;
  protected List<String> mMemberUins = new ArrayList();
  protected List<String> mMgrList = new ArrayList();
  private long[] mMineRecvs;
  private long[] mMineSends;
  public View.OnClickListener mMultiDeleteListener = new TroopMemberListActivity.9(this);
  protected String mMyTroopRole = "2";
  protected String mNoAtAllRemainTips = "";
  protected ActionSheet.OnButtonClickListener mOnActionSheetClickListener = new TroopMemberListActivity.28(this);
  protected boolean mOnDestroy = false;
  public View.OnClickListener mOnItemClickListener = new TroopMemberListActivity.34(this);
  public View.OnClickListener mOnKickOutBtnClickListener = new TroopMemberListActivity.36(this);
  protected int mPickMaxNum = 2147483647;
  public int mPickNumExceedsWordingId;
  protected String mPickTitle;
  protected int mPickType;
  protected String mPickedMems;
  protected ArrayList<String> mPreSelectedUins = new ArrayList();
  protected ProgressBar mProgressBar;
  protected Dialog mProgressDialog;
  protected String mRecMems;
  protected Drawable mRemainAnimDrawable;
  protected boolean mRequestServer = false;
  protected RelativeLayout mRightContainer;
  protected TextView mRightManageBtn;
  protected LinearLayout mRootView;
  protected RelativeLayout mSearchBar;
  public Dialog mSearchDialog;
  protected TroopMemberListActivity.SearchResultAdapter mSearchResultAdapter;
  protected List<TroopMemberListActivity.ATroopMember> mSearchResultList = new ArrayList();
  protected String mSearchSlideLeftUin = "";
  private TroopMemberListActivity.SearchTextWatcher mSearchTextWatcher;
  protected String mSlideLeftUin = "";
  private String[] mSortActionWords;
  private String[] mSortDescribes;
  protected int mSortType = 0;
  protected PopupMenuDialog mSortTypeDialog;
  protected TextView mSubTitle;
  protected TextView mTitle;
  protected View mTitleBar;
  protected LinearLayout mTitleLayout;
  protected ImageView mTitleRightImgBtn;
  protected ImageView mTitleSortImgBtn;
  protected String mTroopAdminUins = "";
  public String mTroopCode = "";
  protected String mTroopFeeCallback = "";
  protected int mTroopFeeEntranceType = -1;
  protected int mTroopFeeMemberCount = 0;
  public TroopFeeObserver mTroopFeeObserver = new TroopMemberListActivity.43(this);
  protected String mTroopFeeProjectId = null;
  protected String mTroopGiftFrom = "";
  public TroopInfo mTroopInfo;
  protected TroopInfoData mTroopInfoData = new TroopInfoData();
  protected long mTroopInfoReqStartTime = 0L;
  private int mTroopMemberCount = 0;
  public TroopMessageObserver mTroopMessageObserver = new TroopMemberListActivity.45(this);
  protected String mTroopName = "";
  public TroopObserver mTroopObserver = new TroopMemberListActivity.40(this);
  public TroopOnlineMemberObserver mTroopOnlineMemberObserver = new TroopMemberListActivity.44(this);
  protected String mTroopOwnerUin = "";
  public TroopRobotObserver mTroopRobotObserver = new TroopMemberListActivity.41(this);
  protected String mTroopUin = "";
  private long nextPullTime = 0L;
  protected View noSearchResultImage;
  private List<oidb_cmd0x74f.Range> range = new ArrayList();
  protected View root;
  protected EditText searchEditText;
  protected XListView searchList;
  protected RelativeLayout search_result;
  private ArrayList<String> seqDays = new ArrayList();
  private ArrayList<String> seqName = new ArrayList();
  public TroopSettingObserver troopSettingObserver = new TroopMemberListActivity.42(this);
  
  private void addInactiveTitle()
  {
    if (this.inactiveTitle != null) {
      return;
    }
    Object localObject1 = getLayoutInflater();
    Object localObject2 = this.mListView;
    int j = 0;
    this.inactiveTitle = ((LayoutInflater)localObject1).inflate(2131562974, (ViewGroup)localObject2, false);
    localObject1 = (TextView)this.inactiveTitle.findViewById(2131368748);
    localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
    Object localObject3 = this.range.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (oidb_cmd0x74f.Range)((Iterator)localObject3).next();
      this.seqDays.add(String.valueOf(((oidb_cmd0x74f.Range)localObject4).uint32_days.get()));
      this.seqName.add(((oidb_cmd0x74f.Range)localObject4).string_name.get());
    }
    localObject3 = this.mListData.iterator();
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject3).next();
      if (((TroopMemberListActivity.ATroopMember)localObject4).jdField_b_of_type_Long == 0L) {
        ((TroopMemberListActivity.ATroopMember)localObject4).jdField_b_of_type_Long = ((TroopMemberListActivity.ATroopMember)localObject4).jdField_a_of_type_Long;
      }
      if (!TextUtils.isEmpty(getInactiveSeq(((TroopMemberListActivity.ATroopMember)localObject4).jdField_b_of_type_Long, (Calendar)localObject2, this.seqDays, this.seqName))) {
        i += 1;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject1 = this.mTroopOwnerUin;
    if ((localObject1 == null) || (!((String)localObject1).equals(this.app.getCurrentAccountUin()))) {
      j = 1;
    }
    this.inactiveTitle.setOnClickListener(new TroopMemberListActivity.21(this, i, j));
    updateInactiveTitleArrowMargin();
    this.mListView.addHeaderView(this.inactiveTitle);
    localObject1 = this.app;
    localObject2 = this.mTroopUin;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(j);
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
  }
  
  private static void checkAdjustNicknameMaxWidthWhenShowRobotMask(AppInterface paramAppInterface, TextView paramTextView, View paramView, String paramString, int paramInt)
  {
    if ((paramAppInterface != null) && (paramTextView != null) && (paramView != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!((ITroopRobotService)paramAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString)) {
        return;
      }
      int j = paramView.getWidth();
      int i = j;
      if (j == 0)
      {
        paramView.measure(0, 0);
        i = paramView.getMeasuredWidth();
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
        }
        return;
      }
      paramInt -= i;
      if (paramInt > 0) {
        paramTextView.setMaxWidth(paramInt);
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:");
        paramAppInterface.append(i);
        paramAppInterface.append(" nTargetMaxWidth:");
        paramAppInterface.append(paramInt);
        QLog.d("TroopMemberListActivityget_troop_member", 2, paramAppInterface.toString());
      }
    }
  }
  
  public static void get0x74fInactiveMember(AppRuntime paramAppRuntime, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    ProtoUtils.b(paramAppRuntime, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  public static Intent getLaunchIntent(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, TroopMemberListActivity.class);
    paramContext.putExtra("troop_uin", paramString);
    paramContext.putExtra("param_from", paramInt);
    return paramContext;
  }
  
  private int getMemberListReqType()
  {
    int i;
    if (this.mFrom != 3) {
      i = 1;
    } else {
      i = 2;
    }
    if (this.mIsApollo) {
      i = 3;
    }
    return i;
  }
  
  private void initSearchDialogAndSearchList()
  {
    this.mSearchDialog = new ReportDialog(this);
    this.mSearchDialog.setCanceledOnTouchOutside(true);
    this.mSearchDialog.requestWindowFeature(1);
    this.mSearchDialog.getWindow().setSoftInputMode(36);
    this.mSearchDialog.setContentView(2131562779);
    Object localObject = this.mSearchDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.mSearchDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getSystemService("input_method");
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT < 24))
    {
      this.mSearchDialog.getWindow().addFlags(67108864);
      int i = getResources().getColor(2131167114);
      new SystemBarCompact(this.mSearchDialog, true, i).init();
      View localView = this.mSearchDialog.findViewById(2131376809);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
    }
    this.searchList = ((XListView)this.mSearchDialog.findViewById(2131377016));
    this.searchList.setBackgroundDrawable(getResources().getDrawable(2130838739));
    this.searchList.setDividerHeight(0);
    this.mSearchResultList.clear();
    this.mSearchResultAdapter = new TroopMemberListActivity.SearchResultAdapter(this, this.mSearchResultList);
    this.searchList.setAdapter(this.mSearchResultAdapter);
    this.searchList.setOnTouchListener(new TroopMemberListActivity.22(this, (InputMethodManager)localObject));
    this.searchEditText = ((EditText)this.mSearchDialog.findViewById(2131366333));
    if (this.mSearchTextWatcher == null) {
      this.mSearchTextWatcher = new TroopMemberListActivity.SearchTextWatcher(this);
    }
    this.searchEditText.addTextChangedListener(this.mSearchTextWatcher);
    this.root = this.mSearchDialog.findViewById(2131376809);
    this.clear_text = ((ImageButton)this.mSearchDialog.findViewById(2131368340));
    this.noSearchResultImage = this.mSearchDialog.findViewById(2131371921);
    this.search_result = ((RelativeLayout)this.mSearchDialog.findViewById(2131376483));
    this.clear_text.setOnClickListener(new TroopMemberListActivity.23(this));
    this.search_result.setOnClickListener(new TroopMemberListActivity.24(this));
  }
  
  private boolean isPickUpPurposeFor760()
  {
    int i = this.mFrom;
    boolean bool2 = false;
    if ((i != 3) && (i != 2) && (i != 14)) {
      i = 0;
    } else {
      i = 1;
    }
    TroopInfo localTroopInfo = this.mTroopInfo;
    if (localTroopInfo != null)
    {
      long l = localTroopInfo.dwGroupClassExt;
      if ((l == 10009L) || (l == 10010L) || (l == 10011L))
      {
        j = 1;
        break label86;
      }
    }
    int j = 0;
    label86:
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void processConvertTroopMemberInfo2AtTroopMember(List<TroopMemberInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processConvertTroopMemberInfo2AtTroopMember, processIndex:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    IFriendDataService localIFriendDataService = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.app.getRuntimeService(ITroopRobotService.class, "all");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i);
      if (localTroopMemberInfo != null)
      {
        Object localObject2;
        if (Utils.d(localTroopMemberInfo.memberuin))
        {
          if ((this.mFrom != 2) || ((!localTroopMemberInfo.memberuin.equals(this.mTroopOwnerUin)) && (!this.mTroopAdminUins.contains(localTroopMemberInfo.memberuin))))
          {
            localObject2 = this.mHideUins;
            if (((localObject2 == null) || (!((List)localObject2).contains(localTroopMemberInfo.memberuin))) && ((this.mFrom != 20) || (!localITroopRobotService.isRobotUin(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000"))) {
              ((List)localObject1).add(convertTroopMemberInfo(localTroopMemberInfo, localIFriendDataService));
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:");
          ((StringBuilder)localObject2).append(localTroopMemberInfo.memberuin);
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
    paramList = this.mHandler.obtainMessage(12, localObject1);
    paramList.arg1 = paramInt;
    this.mHandler.sendMessage(paramList);
  }
  
  private void refreshUI(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Object localObject = this.mLoadingLayout;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0)) {
      this.mLoadingLayout.setVisibility(8);
    }
    if (this.mListZone.getVisibility() == 8) {
      this.mListZone.setVisibility(0);
    }
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 3))
    {
      localObject = this.mAdapter;
      ((TroopMemberListActivity.ListAdapter)localObject).jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      ((TroopMemberListActivity.ListAdapter)localObject).jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      ((TroopMemberListActivity.ListAdapter)localObject).jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.mListData.size()) });
    }
    else if ((paramMessage != null) && (paramMessage.length == 1))
    {
      try
      {
        this.mListData.clear();
        this.mListData.addAll((List)paramMessage[0]);
        QLog.d(".troop.troopManagerVASH", 2, new Object[] { "refreshUI List count: ", Integer.valueOf(this.mListData.size()) });
      }
      finally {}
    }
    if (this.mListData.size() != 0)
    {
      showInactiveTitle();
      checkShowCharIndexView();
      paramMessage = this.mAdapter;
      if (paramMessage != null)
      {
        paramMessage.notifyDataSetChanged();
        this.mAdapter.a();
      }
      else
      {
        this.mAdapter = new TroopMemberListActivity.ListAdapter(this);
        this.mListView.setAdapter(this.mAdapter);
      }
      this.mListView.setVisibility(0);
    }
    if ((!this.mRequestServer) || (this.mFrom == 11)) {
      stopTitleProgress();
    }
    initTitleBarRightBtn();
  }
  
  private void setRighBtnEnabledInMutiDelete()
  {
    int i = this.mAdapter.jdField_b_of_type_JavaUtilList.size();
    if (i > 0)
    {
      String str = MessageFormat.format(HardCodeUtil.a(2131715407), new Object[] { Integer.valueOf(i) });
      this.mRightManageBtn.setEnabled(true);
      this.mRightManageBtn.setText(str);
      this.mRightManageBtn.setOnClickListener(new TroopMemberListActivity.29(this));
      return;
    }
    this.mRightManageBtn.setEnabled(false);
    this.mRightManageBtn.setText(HardCodeUtil.a(2131715433));
  }
  
  public static void setVipIconAndName(AppInterface paramAppInterface, Context paramContext, Resources paramResources, TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    if (SimpleUIUtil.a())
    {
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167056));
      return;
    }
    if (((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getBigClubFlag(paramATroopMember.jdField_i_of_type_Int) != 0)
    {
      paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167202));
      return;
    }
    int i = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getVipTypeByFlag(paramATroopMember.jdField_f_of_type_Int);
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167056));
            return;
          }
          paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167202));
        }
      }
      else
      {
        paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167202));
        return;
      }
    }
    paramTmViewHolder.e.setTextColor(paramResources.getColor(2131167202));
  }
  
  private void showInactiveTitle()
  {
    String str = this.mTroopAdminUins;
    if ((str == null) || (!str.contains(this.app.getCurrentAccountUin())))
    {
      str = this.mTroopOwnerUin;
      if ((str == null) || (!str.equals(this.app.getCurrentAccountUin()))) {}
    }
    else
    {
      i = 1;
      break label53;
    }
    int i = 0;
    label53:
    if ((!this.mIsQidianPrivateTroop) && (i != 0))
    {
      i = this.mFrom;
      if (((i == 0) || (i == 17)) && (System.currentTimeMillis() > this.nextPullTime)) {
        ThreadManager.post(new TroopMemberListActivity.20(this), 8, null, true);
      }
    }
  }
  
  private void showKickoutWindow(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131559094);
    ((TextView)localReportDialog.findViewById(2131365648)).setText(getString(2131691503));
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365644);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131364597);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    boolean bool;
    if ((!this.mIsTroopAdmin) && (this.mTroopInfoData.allowMemberKick == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramList.size() == 1)
    {
      localTextView.setText(getString(2131693533));
      localCheckBox.setText(getString(2131718176));
    }
    else
    {
      localTextView.setText(getString(2131694348));
      localCheckBox.setText(getString(2131694351));
    }
    if (bool) {
      localCheckBox.setVisibility(8);
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365633);
    Object localObject = (TextView)localReportDialog.findViewById(2131365639);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new TroopMemberListActivity.37(this, localReportDialog));
    ((TextView)localObject).setOnClickListener(new TroopMemberListActivity.38(this, paramList, localCheckBox, bool, localReportDialog));
    localReportDialog.show();
  }
  
  private void showLoadingProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.mFrom;
    if ((i != 20) && (i != 21)) {
      this.mLoadingTv.setText(String.format(HardCodeUtil.a(2131715341), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    } else {
      this.mLoadingTv.setText(String.format(HardCodeUtil.a(2131715405), new Object[] { Integer.valueOf(paramInt3) }));
    }
    this.mProgressBar.setProgress(paramInt3);
  }
  
  private void showSortPopDialog()
  {
    if (this.mSortTypeDialog == null)
    {
      ArrayList localArrayList = new ArrayList(this.mSortActionWords.length);
      int i = 0;
      while (i < this.mSortActionWords.length)
      {
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        String[] arrayOfString = this.mSortActionWords;
        localMenuItem.title = arrayOfString[i];
        localMenuItem.id = i;
        localMenuItem.contentDescription = arrayOfString[i];
        localArrayList.add(localMenuItem);
        i += 1;
      }
      this.mSortTypeDialog = PopupMenuDialog.build(this, localArrayList, new TroopMemberListActivity.3(this), null, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).dp2px(135.0F, getResources()), false);
      this.mSortTypeDialog.setTouchInterceptor(new TroopMemberListActivity.4(this));
      updatePopDialogTextColor(this.mSortType);
    }
    this.mSortTypeDialog.showAsDropDown(this.mTitleSortImgBtn, -(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).dp2px(135.0F, getResources()) - this.mTitleSortImgBtn.getWidth()), 0);
  }
  
  private void startTitleProgress()
  {
    this.mListZone.setVisibility(8);
    showLoadingProgress(0, this.mTroopMemberCount, 0);
    this.mHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  private void updateInactiveTitleArrowMargin()
  {
    Object localObject = this.inactiveTitle;
    if ((localObject != null) && (this.mIndexView != null))
    {
      localObject = ((View)localObject).findViewById(2131376549);
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
          if (this.mIndexView.getVisibility() == 0)
          {
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 26.0F));
            return;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 18.0F));
        }
      }
    }
  }
  
  private void updatePopDialogTextColor(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.mSortTypeDialog.getContentView().findViewById(2131365169);
    int i = 0;
    while (i < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i);
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)((View)localObject).getTag();
      if (localMenuItem != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131378623);
        if (localObject != null) {
          if (localMenuItem.id == paramInt) {
            ((TextView)localObject).setTextColor(getResources().getColor(2131167067));
          } else {
            ((TextView)localObject).setTextColor(getResources().getColor(2131167056));
          }
        }
      }
      i += 1;
    }
  }
  
  private void updateUIForAtAllRemainedCount(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i = this.mFrom;
    boolean bool = false;
    if ((i == 3) && (!this.mIsTroopAdmin) && (this.mChatMode != 1)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2;
    Object localObject3;
    if ((!this.mIsTroopAdmin) && (paramBoolean3))
    {
      localObject1 = this.mAllMemberLayout;
      if (localObject1 != null)
      {
        localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131379778);
        localObject1 = getString(2131719953);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.mAllMemberLayout.findViewById(2131376387);
        ((TextView)localObject2).setText("");
        ((ImageView)this.mAllMemberLayout.findViewById(2131369373)).setBackgroundDrawable(((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getDefaultTroopFaceDrawableNew());
        localObject3 = (ImageView)this.mAllMemberLayout.findViewById(2131373313);
        ((ImageView)localObject3).setVisibility(8);
        if (i != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new TroopMemberListActivity.46(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.mAllMemberLayout.setOnClickListener(new TroopMemberListActivity.47(this, (String)localObject1));
        if (!this.mIsApollo)
        {
          this.mAllMemberLayout.setVisibility(0);
          this.mAllMemberLayout.setEnabled(false);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetAtAllRemianCountInfo:");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.mAllMemberLayout != null)
    {
      localObject1 = this.mRemainAnimDrawable;
      if (localObject1 != null)
      {
        ((Animatable)localObject1).stop();
        this.mRemainAnimDrawable = null;
        ((TextView)this.mAllMemberLayout.findViewById(2131376387)).setCompoundDrawables(null, null, null, null);
      }
    }
    Object localObject1 = this.mAllMemberLayout;
    if ((localObject1 != null) && (((RelativeLayout)localObject1).getVisibility() != 8))
    {
      this.mAllMemberLayout.setEnabled(true);
      if (paramBoolean1)
      {
        if (paramString1 == null) {
          return;
        }
        ((TextView)this.mAllMemberLayout.findViewById(2131379778)).setTextColor(getResources().getColor(2131167056));
        localObject1 = (TextView)this.mAllMemberLayout.findViewById(2131376387);
        localObject2 = HardCodeUtil.a(2131715354);
        localObject3 = (Button)this.mAllMemberLayout.findViewById(2131372119);
        ((Button)localObject3).setVisibility(8);
        ((Button)localObject3).setOnClickListener(new TroopMemberListActivity.48(this));
        i = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getCurrentUserVipType(this.app);
        if (this.mFrom == 11)
        {
          if (!paramString1.equals(this.mTroopCode)) {
            return;
          }
          this.mDiscRemainCout = paramInt2;
          paramBoolean1 = bool;
          if (paramBoolean2)
          {
            paramBoolean1 = bool;
            if (paramInt1 > 0) {
              paramBoolean1 = true;
            }
          }
          this.mCanAtAll = paramBoolean1;
          if (this.mCanAtAll)
          {
            paramString1 = new StringBuilder();
            paramString1.append(HardCodeUtil.a(2131715358));
            paramString1.append(paramInt1);
            paramString1.append(HardCodeUtil.a(2131715361));
            this.mNoAtAllRemainTips = paramString1.toString();
            ((TextView)localObject1).setText(this.mNoAtAllRemainTips);
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",");
            paramString1.append(this.mNoAtAllRemainTips);
            paramString1 = paramString1.toString();
          }
          else if (paramInt1 == 0)
          {
            this.mNoAtAllRemainTips = HardCodeUtil.a(2131715420);
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",剩余0次");
            paramString1 = paramString1.toString();
            ((TextView)localObject1).setText("剩余0次");
          }
          else
          {
            this.mNoAtAllRemainTips = "";
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",");
            paramString1.append(HardCodeUtil.a(2131715419));
            paramString1 = paramString1.toString();
            ((TextView)localObject1).setText("");
          }
          paramString2 = paramString1;
          if (this.mIndexView.getVisibility() == 0)
          {
            paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
            paramString2.rightMargin = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).dp2px(20.0F, getResources());
            ((TextView)localObject1).setLayoutParams(paramString2);
            paramString2 = paramString1;
          }
        }
        else
        {
          if (!paramString1.equals(this.mTroopUin)) {
            return;
          }
          this.mCanAtAll = paramBoolean2;
          this.mNoAtAllRemainTips = paramString3;
          if (TextUtils.isEmpty(paramString2))
          {
            QLog.e("TroopMemberListActivityget_troop_member", 1, "updateUIForAtAllRemainedCount remainTips empty");
            return;
          }
          if ((!this.mCanAtAll) && (i != 3))
          {
            ((Button)localObject3).setVisibility(0);
            paramString1 = new StringBuilder();
            paramString1.append(paramString2);
            paramString1.append(",\n超级会员可继续使用");
            paramString2 = paramString1.toString();
            ((TextView)localObject1).setGravity(21);
            ((TextView)localObject1).setLineSpacing(this.mDensity * 5.0F, 1.0F);
            paramInt1 = (int)(HardCodeUtil.a(2131715416).length() * 12 * this.mDensity);
            new DisplayMetrics();
            float f1 = getResources().getDisplayMetrics().widthPixels;
            float f2 = this.mDensity;
            paramInt2 = (int)(f1 - 227.0F * f2 - f2 * 5.0F);
            paramString1 = paramString2;
            if (paramInt1 > paramInt2)
            {
              ((TextView)localObject1).setSingleLine(false);
              ((TextView)localObject1).setLines(2);
              ((TextView)localObject1).setWidth(paramInt2);
              ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
              paramString1 = paramString2;
            }
          }
          else
          {
            paramString1 = paramString2;
          }
          paramString2 = new SpannableString(paramString1);
          paramString3 = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
          if (!TextUtils.isEmpty(paramString3))
          {
            paramInt1 = paramString1.indexOf(paramString3);
            paramInt2 = paramString3.length();
            paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
          }
          if (paramString1.contains(HardCodeUtil.a(2131715426)))
          {
            paramInt1 = paramString1.indexOf(HardCodeUtil.a(2131715427));
            paramInt2 = HardCodeUtil.a(2131715344).length();
            paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
          }
          ((TextView)localObject1).setText(paramString2);
          paramString2 = new StringBuilder();
          paramString2.append((String)localObject2);
          paramString2.append(",");
          paramString2.append(paramString1);
          paramString2 = paramString2.toString();
        }
        this.mAllMemberLayout.setContentDescription(paramString2);
      }
    }
  }
  
  protected void checkShowCharIndexView()
  {
    if ((this.mAdapter != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.mAdapter.jdField_b_of_type_Int), Integer.valueOf(this.mAdapter.jdField_c_of_type_Int), Integer.valueOf(this.mAdapter.jdField_a_of_type_Int) }));
    }
    int i = this.mIndexView.getVisibility();
    if (this.mSortType == 0)
    {
      int j = this.mFrom;
      TroopMemberListActivity.ListAdapter localListAdapter;
      if (j == 11)
      {
        localListAdapter = this.mAdapter;
        if ((localListAdapter != null) && (localListAdapter.jdField_b_of_type_Int > 6) && (this.mAdapter.jdField_a_of_type_Int > 1)) {
          this.mIndexView.setVisibility(0);
        }
      }
      else if (j == 0)
      {
        localListAdapter = this.mAdapter;
        if ((localListAdapter != null) && (localListAdapter.jdField_b_of_type_Int + this.mAdapter.jdField_c_of_type_Int >= this.mMaxItemCountPerPage) && (this.mAdapter.jdField_a_of_type_Int > 1)) {
          this.mIndexView.setVisibility(0);
        } else {
          this.mIndexView.setVisibility(4);
        }
      }
      else
      {
        localListAdapter = this.mAdapter;
        if ((localListAdapter != null) && (localListAdapter.jdField_b_of_type_Int >= this.mMaxItemCountPerPage) && (this.mAdapter.jdField_a_of_type_Int > 1)) {
          this.mIndexView.setVisibility(0);
        } else {
          this.mIndexView.setVisibility(4);
        }
      }
    }
    else
    {
      this.mIndexView.setVisibility(4);
    }
    if (i != this.mIndexView.getVisibility()) {
      updateInactiveTitleArrowMargin();
    }
  }
  
  protected void clickSearchBar()
  {
    if (this.mFrom == 11) {
      ReportController.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i = this.mTitleBar.getHeight();
    float f = -i;
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.mRootView.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new TroopMemberListActivity.30(this, (TranslateAnimation)localObject, localTranslateAnimation, i));
    this.mSearchDialog.setOnDismissListener(new TroopMemberListActivity.31(this));
    this.searchEditText.setText("");
    this.searchEditText.setSelection(0);
    this.searchEditText.requestFocus();
    localObject = (Button)this.mSearchDialog.findViewById(2131363868);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new TroopMemberListActivity.32(this));
    this.mSearchResultList.clear();
    this.mSearchResultAdapter.notifyDataSetChanged();
    this.isSearchMode = true;
  }
  
  protected void constructProgressDialog()
  {
    if (this.mProgressDialog == null)
    {
      this.mProgressDialog = new ReportDialog(this, 2131756189);
      this.mProgressDialog.setContentView(2131558463);
      Dialog localDialog = this.mProgressDialog;
      int i = this.mFrom;
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      localDialog.setCancelable(bool);
      ((TextView)this.mProgressDialog.findViewById(2131365644)).setText(getString(2131718766));
    }
  }
  
  public TroopMemberListActivity.ATroopMember convertDiscussionMemberInfo(DiscussionMemberInfo paramDiscussionMemberInfo, IFriendDataService paramIFriendDataService)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    if (paramIFriendDataService != null) {
      paramIFriendDataService = paramIFriendDataService.getFriend(paramDiscussionMemberInfo.memberUin, true);
    } else {
      paramIFriendDataService = null;
    }
    localATroopMember.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localATroopMember.jdField_a_of_type_Short = 0;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((paramIFriendDataService != null) && (paramIFriendDataService.isFriend()) && (paramIFriendDataService.remark != null) && (paramIFriendDataService.remark.length() > 0))
    {
      localATroopMember.e(paramIFriendDataService.remark);
      localATroopMember.h(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 2));
    }
    else if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
    {
      localATroopMember.e(paramDiscussionMemberInfo.inteRemark);
      localATroopMember.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
      localATroopMember.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
    }
    if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
    {
      localATroopMember.i(paramDiscussionMemberInfo.memberName);
      localATroopMember.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
      localATroopMember.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
    }
    paramDiscussionMemberInfo = this.mAddFrdHelper;
    if (paramDiscussionMemberInfo != null) {
      paramDiscussionMemberInfo.a(localATroopMember);
    }
    return localATroopMember;
  }
  
  public TroopMemberListActivity.ATroopMember convertTroopMemberInfo(TroopMemberInfo paramTroopMemberInfo, IFriendDataService paramIFriendDataService)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (paramIFriendDataService != null) {
      paramIFriendDataService = paramIFriendDataService.getFriend(paramTroopMemberInfo.memberuin, true);
    } else {
      paramIFriendDataService = null;
    }
    localATroopMember.jdField_b_of_type_JavaLangString = ((ITroopMemberNameService)this.app.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(this.mTroopUin, localATroopMember.jdField_a_of_type_JavaLangString, true, false);
    localATroopMember.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localATroopMember.b(paramTroopMemberInfo.friendnick);
      localATroopMember.d(paramTroopMemberInfo.pyAll_friendnick);
      localATroopMember.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    if ((paramIFriendDataService != null) && (paramIFriendDataService.isFriend()) && (paramIFriendDataService.remark != null) && (paramIFriendDataService.remark.length() > 0))
    {
      localATroopMember.e(paramIFriendDataService.remark);
      localATroopMember.h(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 2));
      localATroopMember.g(paramIFriendDataService.remark);
    }
    else if ((paramTroopMemberInfo.autoremark != null) && (paramTroopMemberInfo.autoremark.length() > 0))
    {
      if ((this.mIsQidianPrivateTroop) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localATroopMember.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localATroopMember.h(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localATroopMember.f(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
      }
      else
      {
        localATroopMember.e(paramTroopMemberInfo.autoremark);
        localATroopMember.h(paramTroopMemberInfo.pyAll_autoremark);
        localATroopMember.f(paramTroopMemberInfo.pyFirst_autoremark);
      }
    }
    if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
    {
      localATroopMember.i(paramTroopMemberInfo.troopColorNick);
      localATroopMember.k(paramTroopMemberInfo.pyAll_troopnick);
      localATroopMember.j(paramTroopMemberInfo.pyFirst_troopnick);
    }
    localATroopMember.jdField_o_of_type_Int = paramTroopMemberInfo.troopColorNickId;
    localATroopMember.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
    localATroopMember.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
    localATroopMember.jdField_a_of_type_Int = paramTroopMemberInfo.level;
    localATroopMember.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
    localATroopMember.jdField_d_of_type_Int = paramTroopMemberInfo.newRealLevel;
    localATroopMember.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
    localATroopMember.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
    localATroopMember.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
    localATroopMember.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
    localATroopMember.jdField_e_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
    double d1 = ((IBizTroopMemberInfoService)this.app.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberDiatanceToSelf(this.mTroopUin, localATroopMember.jdField_a_of_type_JavaLangString);
    if ((d1 != -1000.0D) && (d1 != -100.0D))
    {
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
      if (d1 > 10.0D)
      {
        paramIFriendDataService = new StringBuilder();
        paramIFriendDataService.append((int)d1);
        paramIFriendDataService.append("km");
        localATroopMember.t = paramIFriendDataService.toString();
      }
      else
      {
        paramIFriendDataService = new StringBuilder();
        paramIFriendDataService.append(this.mDecimalFormat.format(d1));
        paramIFriendDataService.append("km");
        localATroopMember.t = paramIFriendDataService.toString();
      }
    }
    else
    {
      localATroopMember.t = "";
    }
    if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
    {
      localATroopMember.u = paramTroopMemberInfo.mUniqueTitle;
      localATroopMember.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
    }
    paramIFriendDataService = this.mAddFrdHelper;
    if (paramIFriendDataService != null) {
      paramIFriendDataService.a(localATroopMember);
    }
    localATroopMember.jdField_f_of_type_Int = paramTroopMemberInfo.mVipType;
    localATroopMember.jdField_g_of_type_Int = paramTroopMemberInfo.mVipLevel;
    localATroopMember.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
    localATroopMember.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
    localATroopMember.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
    localATroopMember.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
    localATroopMember.v = paramTroopMemberInfo.honorList;
    localATroopMember.jdField_a_of_type_Byte = paramTroopMemberInfo.mHonorRichFlag;
    return localATroopMember;
  }
  
  protected void delTroopMember()
  {
    new ReportTask(this.app).a("dc00899").b("Grp_mber").c("del_mber").d("clk").a(0).a(new String[] { this.mTroopUin, this.mMyTroopRole }).a();
    ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).startSelectTroopMemberFragment(this, true, this.mTroopInfoData.troopUin, 5);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doItemClick(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    if ((paramATroopMember != null) && (paramATroopMember.jdField_c_of_type_Boolean))
    {
      this.mAdapter.jdField_a_of_type_JavaUtilList.clear();
      paramATroopMember = new Intent();
      paramATroopMember.putExtra("result", new JSONArray().toString());
      setResult(-1, paramATroopMember);
      ReportController.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.mTroopUin, "", "", "");
      finish();
      return;
    }
    if (paramATroopMember != null)
    {
      if (paramATroopMember.jdField_a_of_type_JavaLangString == null) {
        return;
      }
      int j = this.mFrom;
      int i = 3;
      Object localObject1;
      if (j == 1)
      {
        if (this.app.getCurrentAccountUin().equals(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          localObject1 = new AllInOne(paramATroopMember.jdField_a_of_type_JavaLangString, 0);
          ((AllInOne)localObject1).nickname = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getAccountNickName(this.app, paramATroopMember.jdField_a_of_type_JavaLangString);
          ((AllInOne)localObject1).lastActivity = 3;
          ((AllInOne)localObject1).profileEntryType = 4;
          ProfileUtils.openProfileCard(this, (AllInOne)localObject1);
          return;
        }
        openProfileCard(paramATroopMember.jdField_a_of_type_JavaLangString, paramATroopMember.jdField_b_of_type_JavaLangString);
        return;
      }
      Object localObject2;
      if (j == 2)
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        localObject2 = new TroopMemberList.TroopAdmin();
        ((TroopMemberList.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
        ((TroopMemberList.TroopAdmin)localObject2).jdField_a_of_type_Short = paramATroopMember.jdField_a_of_type_Short;
        ((TroopMemberList.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramATroopMember.jdField_b_of_type_JavaLangString;
        ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
        setResult(-1, (Intent)localObject1);
        finish();
        return;
      }
      if ((j != 3) && (j != 11) && (j != 16))
      {
        if ((j != 0) && (j != 4) && (j != 9) && (j != 15) && (j != 17) && (j != 22))
        {
          if (j == 5)
          {
            localObject1 = this.mTroopOwnerUin;
            if ((localObject1 == null) || (!((String)localObject1).equals(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              localObject1 = this.mTroopAdminUins;
              if ((localObject1 != null) && (((String)localObject1).contains(paramATroopMember.jdField_a_of_type_JavaLangString))) {
                i = 2;
              } else {
                i = 1;
              }
            }
            ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).startEditUniqueTitleActivity(this, this.mTroopUin, paramATroopMember.jdField_a_of_type_JavaLangString, i, paramATroopMember.u, 2);
            this.mActionMemberUin = paramATroopMember.jdField_a_of_type_JavaLangString;
            localObject1 = this.app;
            localObject2 = this.mTroopUin;
            i = this.mSortType;
            if (this.isPositiveSort) {
              paramATroopMember = "1";
            } else {
              paramATroopMember = "0";
            }
            ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i), paramATroopMember, "");
            return;
          }
          if (j == 14)
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_nickname", paramATroopMember.jdField_g_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
            ((Intent)localObject1).putExtra("troop_gift_from", this.mTroopGiftFrom);
            setResult(-1, (Intent)localObject1);
            finish();
            return;
          }
          if ((j != 12) && (j != 20))
          {
            if ((j != 18) && (j != 19))
            {
              if (j == 23) {
                ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).openTroopFileBrowserActivity(this, this.mTroopUin, paramATroopMember.jdField_g_of_type_JavaLangString, paramATroopMember.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin());
              }
            }
            else
            {
              ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).startTroopMemberHistoryFragment(this, this.mTroopUin, paramATroopMember.jdField_a_of_type_JavaLangString);
              if (this.mFrom == 19)
              {
                paramATroopMember = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(this.mTroopInfoData.troopUin, this.app.getCurrentAccountUin());
                TroopReportor.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.mTroopInfoData.troopUin, TroopReportor.a(paramATroopMember) });
              }
            }
          }
          else
          {
            if (this.mPickMaxNum == 1)
            {
              this.mAdapter.jdField_a_of_type_JavaUtilList.clear();
              this.mAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
              paramATroopMember = new Intent();
              localObject1 = new JSONArray();
              if (this.mAdapter.jdField_a_of_type_JavaUtilList != null)
              {
                localObject2 = this.mAdapter.jdField_a_of_type_JavaUtilList.iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localATroopMember.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localATroopMember.jdField_b_of_type_JavaLangString);
                  }
                  catch (Exception localException)
                  {
                    label923:
                    break label923;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListActivityget_troop_member", 2, "json put error");
                  }
                  ((JSONArray)localObject1).put(localJSONObject);
                }
              }
              paramATroopMember.putExtra("result", ((JSONArray)localObject1).toString());
              setResult(-1, paramATroopMember);
              finish();
              return;
            }
            if (this.mAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember))
            {
              this.mAdapter.jdField_a_of_type_JavaUtilList.remove(paramATroopMember);
            }
            else
            {
              i = this.mAdapter.jdField_a_of_type_JavaUtilList.size();
              j = this.mPickMaxNum;
              if (i < j)
              {
                this.mAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
              }
              else if (j == 1)
              {
                this.mAdapter.jdField_a_of_type_JavaUtilList.clear();
                this.mAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
              }
              else
              {
                QQToast.a(this, getResources().getString(this.mPickNumExceedsWordingId, new Object[] { Integer.valueOf(this.mPickMaxNum) }), 0).a();
              }
            }
            this.mAdapter.notifyDataSetChanged();
          }
        }
        else
        {
          startTroopMemberCardActivity(paramATroopMember.jdField_a_of_type_JavaLangString);
          if (this.mFrom == 22) {
            TroopReportor.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.mTroopUin });
          }
        }
      }
      else
      {
        localObject1 = getIntent();
        if (this.mIsApollo)
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("isApollo", true);
        }
        else
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
        }
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("troop_uin", this.mTroopUin);
        setResult(-1, (Intent)localObject1);
        finish();
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
    Object localObject2 = (ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "");
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5) {
              return;
            }
            if (paramIntent != null)
            {
              paramIntent = paramIntent.getStringArrayListExtra("uinList");
              if ((paramIntent != null) && (paramIntent.size() > 0))
              {
                this.mHasDeletedMember = true;
                localObject1 = paramIntent.iterator();
                while (((Iterator)localObject1).hasNext()) {
                  removeItem((String)((Iterator)localObject1).next());
                }
                if (this.mFrom == 15) {
                  this.deletedInactiveUins = paramIntent;
                }
                paramIntent = this.mHandler;
                paramIntent.sendMessage(paramIntent.obtainMessage(16));
              }
            }
          }
          else if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringArrayListExtra("param_deleted_uins");
            if (paramIntent.size() > 0)
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext()) {
                removeItem((String)paramIntent.next());
              }
            }
          }
        }
        else if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("roomId");
          if (paramIntent != null)
          {
            localObject1 = ((IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionName(getApplicationContext(), paramIntent);
            localObject2 = BaseAIOUtils.a(new Intent(), null);
            ((Intent)localObject2).putExtra("uin", paramIntent);
            ((Intent)localObject2).putExtra("uintype", 3000);
            ((Intent)localObject2).putExtra("uinname", (String)localObject1);
            ((Intent)localObject2).putExtra("isBack2Root", true);
            ((Intent)localObject2).setFlags(67108864);
            RouteUtils.a(getActivity(), (Intent)localObject2, "/base/start/splash");
            finish();
          }
        }
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (paramIntent != null)
        {
          paramInt1 = paramInt2;
          if (paramIntent.getBooleanExtra("isNeedFinish", false)) {
            paramInt1 = 1;
          }
        }
        if (paramInt1 != 0)
        {
          paramIntent = new Intent();
          paramIntent.putExtra("isNeedFinish", true);
          setResult(-1, paramIntent);
          finish();
          return;
        }
        ThreadManager.post(new TroopMemberListActivity.1(this, paramIntent, (IFriendDataService)localObject1, (ITroopInfoService)localObject2), 8, null, true);
      }
    }
    else
    {
      if (paramInt1 != 1) {
        return;
      }
      if (!TextUtils.isEmpty(this.mActionMemberUin)) {
        ThreadManager.post(new TroopMemberListActivity.2(this, (IFriendDataService)localObject1), 8, null, true);
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.mFrom == 11) {
      ReportController.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    super.doOnCreate(paramBundle);
    this.app = ((AppInterface)getAppRuntime());
    paramBundle = getIntent().getExtras();
    this.mTroopUin = paramBundle.getString("troop_uin");
    this.mTroopName = paramBundle.getString("troop_info_name");
    this.mTroopGiftFrom = paramBundle.getString("troop_gift_from");
    this.mLeftBackBtnText = paramBundle.getString("leftViewText");
    int n = 0;
    this.mIsPopUpStyle = paramBundle.getBoolean("param_is_pop_up_style", false);
    this.mFrom = paramBundle.getInt("param_from", 0);
    this.mTroopFeeProjectId = paramBundle.getString("param_troop_fee_project_id");
    this.mTroopFeeEntranceType = paramBundle.getInt("param_troop_fee_entrance_type", -1);
    this.mTroopFeeCallback = paramBundle.getString("callback");
    this.mIsApollo = paramBundle.getBoolean("param_troop_send_apollo_msg", false);
    this.mTroopMemberCount = paramBundle.getInt("TROOP_INFO_MEMBER_NUM", 0);
    this.mSortType = paramBundle.getInt("sort_type", 0);
    this.mPickMaxNum = paramBundle.getInt("param_pick_max_num", this.mPickMaxNum);
    this.mPreSelectedUins = paramBundle.getStringArrayList("param_pick_selected_list");
    this.mMemberUins = paramBundle.getStringArrayList("param_delete_filter_member_list");
    this.mHideUins = paramBundle.getStringArrayList("param_hide_filter_member_list");
    this.mPickNumExceedsWordingId = paramBundle.getInt("param_pick_max_num_exceeds_wording", 2131697587);
    this.mPickTitle = paramBundle.getString("param_pick_title_string", this.mPickTitle);
    this.mFilerRobot = paramBundle.getBoolean("param_filter_robot", false);
    if (this.mFrom == 17) {
      new ReportTask(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.mTroopUin }).a();
    }
    if (this.mFrom == 22) {
      TroopReportor.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.mTroopUin });
    }
    if ((this.mFrom == 9) && (TextUtils.isEmpty(this.mTroopFeeProjectId)) && (QLog.isColorLevel())) {
      QLog.e("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    if (this.mFrom == 14)
    {
      this.mSortType = 7;
      this.mLoadGiftListFinish = false;
    }
    this.mChatMode = paramBundle.getInt("param_chat_mode", 0);
    this.mCustomTitleName = paramBundle.getString("custom_title_name");
    String str = paramBundle.getString("param_from");
    if (str != null) {
      try
      {
        this.mFrom = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnCreate, troopCode=");
      ((StringBuilder)localObject1).append(this.mTroopUin);
      ((StringBuilder)localObject1).append(" troopUin=");
      ((StringBuilder)localObject1).append(this.mTroopCode);
      ((StringBuilder)localObject1).append(" from=");
      ((StringBuilder)localObject1).append(this.mFrom);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.mIsPopUpStyle) {
      setTheme(2131755317);
    }
    Object localObject1 = (ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "");
    this.mIsQidianPrivateTroop = ((ITroopInfoService)localObject1).isQidianPrivateTroop(this.mTroopUin);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doOnCreate, mIsQidianPrivateTroop = ");
      ((StringBuilder)localObject2).append(this.mIsQidianPrivateTroop);
      ((StringBuilder)localObject2).append(", mTroopUin = ");
      ((StringBuilder)localObject2).append(this.mTroopUin);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
    }
    setContentView(2131562971);
    findViews();
    if (this.mTroopMemberCount == 0)
    {
      localObject2 = ((ITroopInfoService)localObject1).findTroopInfo(this.mTroopUin);
      if (localObject2 != null) {
        this.mTroopMemberCount = ((TroopInfo)localObject2).wMemberNum;
      }
    }
    try
    {
      this.mIsDefaultTheme = ThemeUtil.isDefaultTheme();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (this.mFrom == 15)
    {
      this.mSortType = 6;
      this.inactiveSeqDays = paramBundle.getStringArrayList("param_seq_days");
      this.inactiveSeqName = paramBundle.getStringArrayList("param_seq_name");
    }
    paramBundle = (ITroopOnlineMemberHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName());
    int i = this.mSortType;
    if ((i == 1) || (i == 8)) {
      paramBundle.b(this.mTroopUin);
    }
    if (this.mSortType == 5) {
      paramBundle.d(this.mTroopUin);
    }
    this.mDiscussionHandler = ((IDiscussionHandlerService)this.app.getRuntimeService(IDiscussionHandlerService.class, ""));
    this.mLayoutInflater = getLayoutInflater();
    this.mDensity = getResources().getDisplayMetrics().density;
    paramBundle = (IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "");
    if ((localObject1 != null) && (paramBundle != null))
    {
      i = this.mFrom;
      boolean bool;
      if ((i != 1) && (i != 11) && (i != 16))
      {
        this.mTroopInfo = ((ITroopInfoService)localObject1).findTroopInfo(this.mTroopUin);
        this.mTroopInfoData.troopUin = this.mTroopUin;
        paramBundle = this.mTroopInfo;
        if ((paramBundle != null) && (paramBundle.isHomeworkTroop())) {
          bool = true;
        } else {
          bool = false;
        }
        this.mIsHomeworkTroop = bool;
        this.mTroopInfoData.updateForTroopInfo(this.mTroopInfo, this.app.getCurrentAccountUin());
        paramBundle = this.mTroopInfo;
        if (paramBundle != null)
        {
          this.mTroopCode = paramBundle.troopcode;
          this.hasSendFlowerPrivilege = TroopInfo.hasPayPrivilege(this.mTroopInfo.troopPrivilegeFlag, 32);
        }
        else
        {
          finish();
          return false;
        }
      }
      else
      {
        this.mDiscussionInfo = ((DiscussionInfo)paramBundle.findDiscussionInfoByID(this.mTroopUin));
        this.mTroopCode = this.mTroopUin;
      }
      if (this.mFrom == 5)
      {
        paramBundle = this.mTroopInfo;
        if ((paramBundle != null) && (!paramBundle.isTroopOwner(this.app.getCurrentAccountUin())))
        {
          finish();
          return false;
        }
      }
      i = this.mFrom;
      if ((i != 1) && (i != 11) && (i != 16))
      {
        this.app.addObserver(this.mTroopObserver, true);
        this.app.addObserver(this.troopSettingObserver, true);
        this.app.addObserver(this.mTroopRobotObserver, true);
        this.app.addObserver(this.mTroopFeeObserver, true);
        this.app.addObserver(this.mTroopOnlineMemberObserver, true);
        this.app.addObserver(this.mTroopMessageObserver, true);
      }
      else
      {
        addObserver(this.mDiscussionObserver);
      }
      if ((this.mIsApollo) && (this.mFrom == 3)) {
        this.mSortType = 2;
      }
      int j;
      int k;
      int m;
      if (this.mFrom == 0)
      {
        paramBundle = getResources().getDisplayMetrics();
        i = Math.max(paramBundle.widthPixels, paramBundle.heightPixels);
        j = getTitleBarHeight();
        k = ImmersiveUtils.getStatusBarHeight(this);
        m = (int)(this.mDensity * 60.0F);
        this.mIndexHeight = getResources().getDimensionPixelSize(2131299245);
        this.mItemHeight = getResources().getDimensionPixelSize(2131296768);
        if (this.mItemHeight == 0) {
          this.mItemHeight = ((int)(paramBundle.density * 58.0F));
        }
        this.mMaxAvailableHeight = (i - j - k - m);
        this.mMaxItemCountPerPage = ((this.mMaxAvailableHeight - this.mIndexHeight) / this.mItemHeight);
        this.mAddFrdHelper = new AddFrdHelper(this);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mMaxAvailableHeight), Integer.valueOf(this.mIndexHeight), Integer.valueOf(this.mItemHeight), Integer.valueOf(this.mMaxItemCountPerPage) }));
        }
      }
      i = this.mFrom;
      if (i != 1)
      {
        if (i == 11)
        {
          paramBundle = this.mDiscussionInfo;
          if (paramBundle != null)
          {
            this.mTroopOwnerUin = paramBundle.ownerUin;
            paramBundle = this.mTroopOwnerUin;
            if ((paramBundle != null) && (paramBundle.equals(this.app.getCurrentAccountUin()))) {
              bool = true;
            } else {
              bool = false;
            }
            this.mIsTroopAdmin = bool;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
        }
        else
        {
          this.mIsInDeleteState = false;
          paramBundle = this.mTroopInfo;
          if (paramBundle != null)
          {
            if (paramBundle.troopowneruin != null) {
              this.mTroopOwnerUin = this.mTroopInfo.troopowneruin;
            }
            if (this.mTroopInfo.Administrator != null) {
              this.mTroopAdminUins = this.mTroopInfo.Administrator;
            }
            if ((this.mTroopInfo.troopowneruin == null) || (!this.mTroopInfo.troopowneruin.equals(this.app.getCurrentAccountUin())))
            {
              paramBundle = this.mTroopAdminUins;
              if ((paramBundle == null) || (!paramBundle.contains(this.app.getCurrentAccountUin()))) {}
            }
            else
            {
              bool = true;
              break label1673;
            }
            bool = false;
            label1673:
            this.mIsTroopAdmin = bool;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo==null");
          }
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("doOnCreate, mTroopInfo admin: ");
            paramBundle.append(this.mTroopAdminUins);
            paramBundle.append("  owner:");
            paramBundle.append(this.mTroopOwnerUin);
            QLog.d("TroopMemberListActivityget_troop_member", 2, paramBundle.toString());
          }
        }
      }
      else
      {
        this.mIsInDeleteState = true;
        this.mSlideLeftUin = "";
        paramBundle = this.mDiscussionInfo;
        if (paramBundle != null) {
          this.mTroopOwnerUin = paramBundle.ownerUin;
        } else if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo==null");
        }
        paramBundle = this.mTroopOwnerUin;
        if ((paramBundle != null) && (paramBundle.equals(this.app.getCurrentAccountUin()))) {
          this.mIsTroopAdmin = true;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("doOnCreate, mDiscussionInfo owner: ");
          paramBundle.append(this.mTroopOwnerUin);
          QLog.d("TroopMemberListActivityget_troop_member", 2, paramBundle.toString());
        }
      }
      if (this.mFrom == 21) {
        this.mIsInDeleteState = true;
      }
      localObject1 = getResources().getStringArray(2130968684);
      paramBundle = getResources().getStringArray(2130968683);
      Object localObject3 = this.mTroopInfo;
      if ((localObject3 != null) && (((TroopInfo)localObject3).isKingBattleTroop()))
      {
        if ((this.mTroopInfo.showGameSwitchStatus == 1) && (this.mTroopInfo.gameSwitchStatus == 1))
        {
          j = 2;
          i = 1;
        }
        else
        {
          j = 1;
          i = 0;
        }
        this.mSortActionWords = new String[localObject1.length + j];
        int i1 = localObject1.length;
        m = 0;
        k = 0;
        while (m < i1)
        {
          localObject3 = localObject1[m];
          this.mSortActionWords[k] = localObject3;
          m += 1;
          k += 1;
        }
        this.mSortActionWords[k] = getResources().getString(2131720021);
        if (i != 0) {
          this.mSortActionWords[(k + 1)] = getResources().getString(2131720020);
        }
        this.mSortDescribes = new String[paramBundle.length + j];
        m = paramBundle.length;
        j = 0;
        k = n;
        while (k < m)
        {
          localObject1 = paramBundle[k];
          this.mSortDescribes[j] = localObject1;
          k += 1;
          j += 1;
        }
        this.mSortDescribes[j] = getResources().getString(2131720022);
        if (i != 0) {
          this.mSortDescribes[(j + 1)] = getResources().getString(2131720020);
        }
      }
      else
      {
        this.mSortActionWords = ((String[])localObject1);
        this.mSortDescribes = paramBundle;
      }
      initTitleBar();
      initListView();
      fillData();
      setAccSoft();
      i = this.mFrom;
      localObject1 = "0";
      if (i != 0)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramBundle = "4";
            } else {
              paramBundle = "1";
            }
          }
          else {
            paramBundle = "2";
          }
        }
        else {
          paramBundle = "3";
        }
      }
      else {
        paramBundle = "0";
      }
      localObject3 = this.mTroopOwnerUin;
      if ((localObject3 == null) || (!((String)localObject3).equals(this.app.getCurrentAccountUin())))
      {
        localObject1 = this.mTroopAdminUins;
        if ((localObject1 != null) && (((String)localObject1).contains(this.app.getCurrentAccountUin()))) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
      }
      this.mMyTroopRole = ((String)localObject1);
      doReport("exp", paramBundle, (String)localObject1);
      if (this.mFrom == 14) {
        showTroopSendFlowerNoPermission();
      }
      if (this.mFrom == 18) {
        ReportController.b(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.mTroopUin, "", "", "");
      }
      if (this.mFrom == 3) {
        ((ITroopRobotHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRobotHandlerName())).a(this.mTroopUin);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    this.mOnDestroy = true;
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      localObject = this.mAddFrdHelper;
      if (localObject != null)
      {
        ((AddFrdHelper)localObject).c();
        this.mAddFrdHelper = null;
      }
      localObject = this.searchEditText;
      if (localObject != null) {
        ((EditText)localObject).removeTextChangedListener(this.mSearchTextWatcher);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        removeObserver(this.mDiscussionObserver);
        removeObserver(this.mTroopObserver);
        removeObserver(this.troopSettingObserver);
        removeObserver(this.mTroopRobotObserver);
        removeObserver(this.mTroopFeeObserver);
        removeObserver(this.mTroopOnlineMemberObserver);
        removeObserver(this.mTroopMessageObserver);
        label104:
        Object localObject = this.mSearchResultAdapter;
        if (localObject != null) {
          ((TroopMemberListActivity.SearchResultAdapter)localObject).a();
        }
        super.doOnDestroy();
        localObject = this.mProgressDialog;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          this.mProgressDialog.dismiss();
        }
        localObject = this.mAdapter;
        if (localObject != null) {
          ((TroopMemberListActivity.ListAdapter)localObject).c();
        }
        localObject = this.mActionSheet;
        if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
          this.mActionSheet.dismiss();
        }
        localObject = this.mSearchDialog;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          this.mSearchDialog.dismiss();
        }
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label104;
      }
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      int i = this.mFrom;
      if ((i != 1) && (i != 13) && (i != 21) && ((this.mIsInMultiDeleteState) || (this.mIsInDeleteState)))
      {
        this.mIsInMultiDeleteState = false;
        this.mTitleRightImgBtn.setVisibility(0);
        if (this.mFrom != 22) {
          this.mTitleSortImgBtn.setVisibility(0);
        }
        this.mRightManageBtn.setVisibility(8);
        this.mLeftBackBtn.setVisibility(8);
        this.mLeftBackBtn = ((TextView)findViewById(2131369202));
        this.mLeftBackBtn.setVisibility(0);
        this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
        paramKeyEvent = this.mAdapter;
        if (paramKeyEvent != null) {
          paramKeyEvent.a();
        }
        return true;
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(48);
      label13:
      Object localObject = this.mTitleBar;
      if (localObject != null)
      {
        ((View)localObject).destroyDrawingCache();
        this.mTitleBar.requestLayout();
        this.mTitleBar.invalidate();
      }
      localObject = this.mAddFrdHelper;
      if (localObject != null) {
        ((AddFrdHelper)localObject).a();
      }
      return;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  protected void doReport(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReport, actionName=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" ext2=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" ext3=");
          localStringBuilder.append(paramString3);
          localStringBuilder.append(" from=");
          localStringBuilder.append(this.mFrom);
          QLog.i("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
          if (this.mFrom != 1)
          {
            if (this.mFrom == 11) {
              return;
            }
            if (this.mFrom == 9)
            {
              if (this.mTroopFeeEntranceType != 1) {
                break label244;
              }
              paramString2 = "suc_pay_list";
              ReportController.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.mTroopUin, paramString3, "", "");
              return;
            }
            ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.mTroopUin, paramString2, paramString3, "");
            return;
          }
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("doReport:");
          paramString2.append(paramString1.toString());
          QLog.i("TroopMemberListActivityget_troop_member", 2, paramString2.toString());
        }
        return;
      }
      continue;
      label244:
      paramString2 = "un_pay_list";
    }
  }
  
  protected void fillData()
  {
    startTitleProgress();
    int i = this.mFrom;
    if (i == 9)
    {
      ThreadManager.post(new TroopMemberListActivity.25(this), 8, null, true);
      return;
    }
    Object localObject1;
    if ((i != 15) && (i != 1) && (i != 11) && (i != 16))
    {
      localObject1 = this.mHandler;
      ((Handler)localObject1).sendMessage(((Handler)localObject1).obtainMessage(13));
      localObject1 = null;
    }
    else
    {
      localObject1 = new TroopMemberListActivity.26(this);
    }
    i = this.mFrom;
    Object localObject4;
    long l2;
    if ((i != 11) && (i != 1) && (i != 16) && (NetworkUtil.isNetworkAvailable(this)))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("last_update_time");
      ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
      localObject2 = getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_time");
      ((StringBuilder)localObject4).append(this.mTroopUin);
      l1 = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject4).toString(), 0L);
      l2 = Math.abs(System.currentTimeMillis() - l1);
      localObject4 = this.mTroopInfo;
      if (localObject4 != null) {
        i = ((TroopInfo)localObject4).wMemberNum;
      } else {
        i = 0;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_num");
      ((StringBuilder)localObject4).append(this.mTroopUin);
      int j = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject4).toString(), 0);
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_num");
      ((StringBuilder)localObject4).append(this.mTroopUin);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject4).toString(), i).commit();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fillData, lastUpdateTime:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" timeDiff:");
        ((StringBuilder)localObject2).append(l2 / 1000L / 60L);
        ((StringBuilder)localObject2).append(" min  curMemberNum:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" lastUpdateMemberNum:");
        ((StringBuilder)localObject2).append(j);
        QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (ITroopMemberListHandler)this.app.getBusinessHandler(TroopMemberListHandler.class.getName());
      if (localObject2 != null)
      {
        this.mRequestServer = true;
        this.mMemberListReqStartTime = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, this.mTroopUin, this.mTroopCode, true, getMemberListReqType(), this.mMemberListReqStartTime, 0);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("fillData, ITroopMemberListHandler.getTroopMemberList(), troopUin: ");
          ((StringBuilder)localObject4).append(this.mTroopCode);
          ((StringBuilder)localObject4).append(" troopCode: ");
          ((StringBuilder)localObject4).append(this.mTroopUin);
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject4).toString());
        }
      }
      if (localObject2 != null) {
        try
        {
          ((ITroopMemberListHandler)localObject2).a(Long.parseLong(this.mTroopUin), 0L, 1, 0, 0);
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListActivityget_troop_member", 2, localException1.toString());
          }
        }
      }
    }
    Object localObject3;
    if (this.mFrom == 3)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("last_update_time");
      ((StringBuilder)localObject3).append(this.app.getCurrentAccountUin());
      localObject3 = getSharedPreferences(((StringBuilder)localObject3).toString(), 4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_troop_info_last_update");
      ((StringBuilder)localObject4).append(this.mTroopUin);
      l1 = ((SharedPreferences)localObject3).getLong(((StringBuilder)localObject4).toString(), 0L);
      l2 = Math.abs(l1 - System.currentTimeMillis());
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("fillData, TroopInfo lastUpdateTime:");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(" timeDiff:");
        ((StringBuilder)localObject3).append(l2 / 1000L / 60L);
        QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject3).toString());
      }
      if (l2 > 60000L)
      {
        localObject4 = (ITroopInfoHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
        localObject3 = (ITroopMemberListHandler)this.app.getBusinessHandler(TroopMemberListHandler.class.getName());
        if ((localObject3 != null) && (localObject4 != null))
        {
          this.mTroopInfoReqStartTime = System.currentTimeMillis();
          ((ITroopInfoHandler)localObject4).a(this.mTroopUin);
        }
      }
    }
    try
    {
      l1 = Long.valueOf(this.mTroopUin).longValue();
    }
    catch (Exception localException2)
    {
      label867:
      break label867;
    }
    long l1 = 0L;
    ((ITroopMemberListHandler)localObject3).a(1, l1, 0L, 2, 0, 0, true);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("fillData, getGroupInfoReq, mTroopUin:");
      ((StringBuilder)localObject3).append(this.mTroopUin);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject3).toString());
    }
    if (localObject1 != null) {
      ThreadManager.post((Runnable)localObject1, 8, null, true);
    }
    if (this.mFrom == 14) {
      ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).requestGiftMemberList(this.app, this.mTroopUin, new TroopMemberListActivity.27(this));
    }
  }
  
  protected TroopMemberListActivity.TmViewHolder findListItemHolderByUin(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean) {
      localObject1 = this.searchList;
    } else {
      localObject1 = this.mListView;
    }
    int j = ((ViewGroup)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof TroopMemberListActivity.TmViewHolder)))
      {
        localObject2 = (TroopMemberListActivity.TmViewHolder)((View)localObject2).getTag();
        if ((((TroopMemberListActivity.TmViewHolder)localObject2).jdField_a_of_type_JavaLangString != null) && (((TroopMemberListActivity.TmViewHolder)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("findListItemHolderByUin:");
            paramString.append(i);
            QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
          }
          return localObject2;
        }
      }
      i += 1;
    }
    return null;
  }
  
  protected void findViews()
  {
    this.mRootView = ((LinearLayout)findViewById(2131379303));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.mRootView.setFitsSystemWindows(true);
    }
    this.mTitleBar = findViewById(2131378803);
    this.mTitle = ((TextView)findViewById(2131369249));
    this.mSubTitle = ((TextView)findViewById(2131369195));
    this.mTitleLayout = ((LinearLayout)findViewById(2131364412));
    this.mLeftBackBtn = ((TextView)findViewById(2131369202));
    int i = this.mFrom;
    if ((i == 3) || (i == 11))
    {
      this.mLeftBackBtn.setVisibility(8);
      this.mLeftBackBtn = ((TextView)findViewById(2131369204));
      this.mLeftBackBtn.setVisibility(0);
    }
    this.mRightManageBtn = ((TextView)findViewById(2131369233));
    this.mTitleRightImgBtn = ((ImageView)findViewById(2131369216));
    this.mListView = ((PinnedDividerSwipListView)findViewById(2131379297));
    this.mIndexView = ((IndexView)findViewById(2131368761));
    this.mLoadingView = findViewById(2131376345);
    this.mListZone = ((RelativeLayout)findViewById(2131370156));
    this.mLoadingLayout = ((RelativeLayout)findViewById(2131370368));
    this.mProgressBar = ((ProgressBar)this.mLoadingLayout.findViewById(2131368260));
    this.mLoadingTv = ((TextView)this.mLoadingLayout.findViewById(2131370395));
    this.mTitleRightImgBtn.setContentDescription(getString(2131697523));
    this.mTitleSortImgBtn = ((ImageView)findViewById(2131369217));
    this.mTitleSortImgBtn.setBackgroundResource(2130844003);
    this.mTitleSortImgBtn.setContentDescription(getString(2131719799));
  }
  
  public void finish()
  {
    if ((this.mFrom == 9) && ((this.mHasDeletedMember) || (this.mTroopFeeMemberCount != this.mListData.size())))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
      localIntent.putExtra("callback", this.mTroopFeeCallback);
      setResult(-1, localIntent);
    }
    super.finish();
    if (this.mIsPopUpStyle) {
      overridePendingTransition(0, 2130771992);
    }
    if (this.mFrom == 12) {
      overridePendingTransition(0, 2130772015);
    }
  }
  
  protected Object[] getDiscussionMemberFromDB(String paramString)
  {
    for (;;)
    {
      try
      {
        this.mListData.clear();
      }
      finally
      {
        Object localObject1;
        long l1;
        long l2;
        int j;
        Object localObject2;
        continue;
        throw paramString;
        continue;
        i += 1;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getDiscussionMemberFromDB, uin:");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject1).toString());
        }
        l1 = System.currentTimeMillis();
        localObject1 = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
        this.mDiscussionMemberFromDB = ((ArrayList)((IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoListByUin(paramString));
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getDiscussionMemberFromDB, queryTime:");
          paramString.append(l2 - l1);
          QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
        }
        if (this.mDiscussionMemberFromDB == null) {
          continue;
        }
        j = this.mDiscussionMemberFromDB.size();
        i = 0;
        if (i < j)
        {
          paramString = (DiscussionMemberInfo)this.mDiscussionMemberFromDB.get(i);
          if (paramString == null) {
            continue;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.mFrom == 2) && (paramString.memberUin.equals(this.mTroopOwnerUin))) || ((this.mFrom == 1) && (this.mDiscussionInfo != null) && (paramString.memberUin.equals(this.mDiscussionInfo.inheritOwnerUin)))) {
              continue;
            }
            paramString = convertDiscussionMemberInfo(paramString, (IFriendDataService)localObject1);
            this.mListData.add(paramString);
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getDiscussionMemberFromDB, continued:");
          ((StringBuilder)localObject2).append(paramString.memberUin);
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
          continue;
        }
        paramString = (QProxyManager)this.app.getProxyManagerInner();
        i = j;
        if (paramString != null)
        {
          paramString.notifyRefreshTroopMember();
          i = j;
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getDiscussionMemberFromDB, TotalTime:");
          paramString.append(l2 - l1);
          paramString.append(", listSize:");
          paramString.append(this.mListData.size());
          paramString.append(", dbSize:");
          paramString.append(i);
          QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
        }
        localObject2 = this.mAdapter.a();
        if ((localObject2 != null) && (localObject2.length == 3))
        {
          paramString = localObject2[0];
          localObject1 = localObject2[1];
          localObject2 = localObject2[2];
          return new Object[] { paramString, localObject1, localObject2 };
        }
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getDiscussionMemberFromDB:");
          ((StringBuilder)localObject1).append(paramString.toString());
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getDiscussionMemberFromDB:");
          ((StringBuilder)localObject1).append(paramString.toString());
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    return null;
  }
  
  public String getInactiveSeq(long paramLong, Calendar paramCalendar, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList2.size() != 0)
    {
      if (paramArrayList1.size() == 0) {
        return null;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong * 1000L);
      int j = paramCalendar.get(1);
      int k = localCalendar.get(1);
      int m = paramCalendar.get(6);
      int n = localCalendar.get(6);
      int i = paramArrayList2.size() - 1;
      while (i >= 0)
      {
        if ((j - k) * 365 + m - n >= Integer.parseInt((String)paramArrayList1.get(i))) {
          return (String)paramArrayList2.get(i);
        }
        i -= 1;
      }
    }
    return null;
  }
  
  protected Object[] getMemberListFromUins(String paramString, List<String> paramList)
  {
    try
    {
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localIFriendDataService = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
    }
    finally
    {
      long l;
      ArrayList localArrayList;
      IFriendDataService localIFriendDataService;
      EntityManager localEntityManager;
      label141:
      for (;;)
      {
        label51:
        throw paramString;
      }
    }
    try
    {
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        List localList = localEntityManager.query(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, (String)paramList.next() }, null, null, null, null);
        if ((localList == null) || (localList.size() <= 0)) {
          break label51;
        }
        localArrayList.add(convertTroopMemberInfo((TroopMemberInfo)localList.get(0), localIFriendDataService));
        break label51;
      }
    }
    catch (Exception paramString)
    {
      break label141;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("cost:");
      paramString.append(System.currentTimeMillis() - l);
      QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
    }
    return new Object[] { localArrayList };
  }
  
  protected void getTroopMemberFromDBIfNeeded(String paramString, List<TroopMemberInfo> paramList)
  {
    for (;;)
    {
      try
      {
        this.mListData.clear();
        this.mFakeProgess = 0.0D;
        this.mJobCount = -1;
        this.mTroopMemberCount = 0;
      }
      finally
      {
        Object localObject;
        long l;
        continue;
        throw paramString;
        continue;
        paramString = paramList;
        continue;
        continue;
        int i = 1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getTroopMemberFromDBIfNeeded, uin:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
        }
        this.mGetTroopMemberFromDBIfNeededBeginTime = System.currentTimeMillis();
        if (paramList != null) {
          if (!paramList.isEmpty()) {
            continue;
          }
        }
        paramList = new ArrayList();
        localObject = this.app.getEntityManagerFactory().createEntityManager();
        paramString = ((EntityManager)localObject).query(true, TroopMemberInfo.class.getSimpleName(), new String[] { "memberuin", "mIsShielded", "mUniqueTitle", "level", "active_point", "credit_level", "last_active_time", "join_time", "troopnick", "pyAll_troopNick", "pyFirst_troopNick", "friendnick", "pyAll_friendnick", "pyFirst_friendnick", "autoremark", "pyAll_autoremark", "pyFirst_autoremark", "realLevel", "troopColorNick", "newRealLevel" }, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        if (paramString != null)
        {
          if (paramString.moveToFirst())
          {
            TroopMemberInfo localTroopMemberInfo = new TroopMemberInfo();
            localTroopMemberInfo.memberuin = paramString.getString(0);
            localTroopMemberInfo.mIsShielded = Boolean.parseBoolean(paramString.getString(1));
            localTroopMemberInfo.mUniqueTitle = paramString.getString(2);
            localTroopMemberInfo.level = paramString.getInt(3);
            localTroopMemberInfo.active_point = paramString.getLong(4);
            localTroopMemberInfo.credit_level = paramString.getLong(5);
            localTroopMemberInfo.last_active_time = paramString.getLong(6);
            localTroopMemberInfo.join_time = paramString.getLong(7);
            localTroopMemberInfo.troopnick = paramString.getString(8);
            localTroopMemberInfo.pyAll_troopnick = paramString.getString(9);
            localTroopMemberInfo.pyFirst_troopnick = paramString.getString(10);
            localTroopMemberInfo.friendnick = paramString.getString(11);
            localTroopMemberInfo.pyAll_friendnick = paramString.getString(12);
            localTroopMemberInfo.pyFirst_friendnick = paramString.getString(13);
            localTroopMemberInfo.autoremark = paramString.getString(14);
            localTroopMemberInfo.pyAll_autoremark = paramString.getString(15);
            localTroopMemberInfo.pyFirst_autoremark = paramString.getString(16);
            localTroopMemberInfo.realLevel = paramString.getInt(17);
            localTroopMemberInfo.troopColorNick = paramString.getString(18);
            localTroopMemberInfo.newRealLevel = paramString.getInt(19);
            paramList.add(localTroopMemberInfo);
            if (paramString.moveToNext()) {
              continue;
            }
          }
          paramString.close();
        }
        ((EntityManager)localObject).close();
        l = System.currentTimeMillis();
        paramString = paramList;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getTroopMemberFromDB, queryTime:");
          paramString.append(l - this.mGetTroopMemberFromDBIfNeededBeginTime);
          QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
          paramString = paramList;
        }
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          int j = paramString.size();
          this.mTroopMemberCount = j;
          int k = j / PROCESS_MEM_COUNT_PER_JOB;
          if (j % PROCESS_MEM_COUNT_PER_JOB != 0) {
            continue;
          }
          i = 0;
          this.mJobCount = (k + i);
          i = 0;
          if (i < j)
          {
            ThreadManager.post(new TroopMemberListActivity.35(this, paramString, i, Math.min(PROCESS_MEM_COUNT_PER_JOB + i - 1, j)), 8, null, true);
            i += PROCESS_MEM_COUNT_PER_JOB;
            continue;
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("getTroopMemberFromDBIfNeeded, listSize:");
            paramString.append(j);
            paramString.append("|mJobCount:");
            paramString.append(this.mJobCount);
            QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
          }
          stopTitleProgress();
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("getTroopMemberFromDBIfNeeded:");
          paramList.append(paramString.toString());
          QLog.d("TroopMemberListActivityget_troop_member", 2, paramList.toString());
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("getTroopMemberFromDBIfNeeded:");
          paramList.append(paramString.toString());
          QLog.d("TroopMemberListActivityget_troop_member", 2, paramList.toString());
        }
      }
    }
  }
  
  protected void initListView()
  {
    View localView = getLayoutInflater().inflate(2131562980, this.mListView, false);
    this.mSearchBar = ((RelativeLayout)localView.findViewById(2131377019));
    this.mAllMemberLayout = ((RelativeLayout)localView.findViewById(2131362652));
    this.mAllMemberLayout.setVisibility(8);
    if (ThemeUtil.isDefaultTheme()) {
      this.mAllMemberLayout.setBackgroundResource(2130839393);
    } else {
      this.mAllMemberLayout.setBackgroundResource(2130839390);
    }
    Object localObject1 = (TextView)this.mAllMemberLayout.findViewById(2131379778);
    this.mLeftMarginOfNick = ((LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin;
    if ((this.mFrom == 3) && (this.mIsTroopAdmin) && (this.mChatMode != 1)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((this.mFrom == 11) && (this.mIsTroopAdmin)) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject2;
    if ((i != 0) || (j != 0))
    {
      localObject2 = getString(2131719953);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = (TextView)this.mAllMemberLayout.findViewById(2131376387);
      ((TextView)localObject1).setText("");
      ((ImageView)this.mAllMemberLayout.findViewById(2131369373)).setBackgroundDrawable(((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getDefaultTroopFaceDrawableNew());
      Object localObject3 = (ImageView)this.mAllMemberLayout.findViewById(2131373313);
      ((ImageView)localObject3).setVisibility(8);
      if (i != 0)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setOnClickListener(new TroopMemberListActivity.16(this));
        ((TextView)localObject1).setTextSize(12.0F);
      }
      this.mAllMemberLayout.setOnClickListener(new TroopMemberListActivity.17(this, (String)localObject2));
      if (!this.mIsApollo)
      {
        this.mAllMemberLayout.setVisibility(0);
        this.mAllMemberLayout.setEnabled(false);
      }
      localObject2 = (ITroopMessageHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMessageHandlerName());
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this, 1, 2131694422, 0).b(getTitleBarHeight());
      }
      else
      {
        localObject3 = this.mDiscussionHandler;
        if ((localObject3 != null) && (this.mFrom == 11)) {
          ((IDiscussionHandlerService)localObject3).getAtAllRemainCountInfo(this.app.getCurrentAccountUin(), this.mTroopCode);
        } else if (localObject2 != null) {
          ((ITroopMessageHandler)localObject2).a(this.app.getCurrentAccountUin(), this.mTroopUin);
        }
        this.mRemainAnimDrawable = getResources().getDrawable(2130839406);
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(this.mRemainAnimDrawable, null, null, null);
        ((Animatable)this.mRemainAnimDrawable).start();
      }
    }
    if ((this.mFrom == 3) && (!this.mIsTroopAdmin) && (this.mChatMode != 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.mFrom == 11) && (!this.mIsTroopAdmin)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((this.mTroopInfoData.isNewTroop) && ((i != 0) || (j != 0)))
    {
      localObject1 = (ITroopMessageHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMessageHandlerName());
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this, 1, 2131694422, 0).b(getTitleBarHeight());
      }
      else
      {
        localObject2 = this.mDiscussionHandler;
        if ((localObject2 != null) && (this.mFrom == 11)) {
          ((IDiscussionHandlerService)localObject2).getAtAllRemainCountInfo(this.app.getCurrentAccountUin(), this.mTroopCode);
        } else if (localObject1 != null) {
          ((ITroopMessageHandler)localObject1).a(this.app.getCurrentAccountUin(), this.mTroopUin);
        }
      }
    }
    localObject1 = (EditText)this.mSearchBar.findViewById(2131366333);
    ((Button)this.mSearchBar.findViewById(2131363868)).setVisibility(8);
    int i = this.mFrom;
    if (i == 19)
    {
      localView = getLayoutInflater().inflate(2131562972, this.mListView, false);
      localView.setOnClickListener(new TroopMemberListActivity.18(this));
      this.mListView.addHeaderView(localView);
    }
    else if ((i != 9) && (i != 15))
    {
      this.mListView.addHeaderView(localView);
    }
    this.mAdapter = new TroopMemberListActivity.ListAdapter(this);
    this.mListView.setAdapter(this.mAdapter);
    i = this.mFrom;
    if ((i == 19) || (i == 21)) {
      this.mSearchBar.setVisibility(8);
    }
    i = this.mFrom;
    if ((i != 9) && (i != 19)) {
      initSearchDialogAndSearchList();
    }
    ((EditText)localObject1).setOnTouchListener(new TroopMemberListActivity.19(this));
    this.mIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.mIndexView.setOnIndexChangedListener(this);
    if (this.mFrom == 11) {
      this.mIndexView.setOnIndexChangedListener2(this);
    }
  }
  
  protected void initTitleBar()
  {
    int i = this.mFrom;
    if (i == 1)
    {
      this.mTitle.setText(getString(2131691787));
      this.mLeftBackBtn.setVisibility(4);
      this.mRightManageBtn.setText(getString(2131692486));
      this.mRightManageBtn.setVisibility(0);
      this.mRightManageBtn.setContentDescription(getString(2131691789));
      this.mRightManageBtn.setOnClickListener(this.mFinishListener);
    }
    else if (i == 2)
    {
      this.mTitle.setText(getString(2131689656));
      this.mRightManageBtn.setVisibility(8);
      this.mTitleRightImgBtn.setVisibility(8);
      this.mTitleRightImgBtn.setImageResource(2130840347);
      this.mTitleSortImgBtn.setVisibility(0);
      this.mLeftBackBtn.setOnClickListener(new TroopMemberListActivity.5(this));
    }
    else if (i == 3)
    {
      this.mTitle.setText(getString(2131696491));
      this.mLeftBackBtn.setText(2131690728);
      this.mRightManageBtn.setVisibility(8);
      this.mTitleRightImgBtn.setVisibility(8);
      this.mTitleRightImgBtn.setImageResource(2130840347);
      this.mTitleSortImgBtn.setVisibility(0);
      this.mLeftBackBtn.setOnClickListener(new TroopMemberListActivity.6(this));
    }
    else if (i == 11)
    {
      this.mTitle.setText(getString(2131696493));
      this.mLeftBackBtn.setText(2131690728);
      this.mRightManageBtn.setVisibility(8);
      this.mTitleRightImgBtn.setVisibility(8);
      this.mTitleSortImgBtn.setVisibility(8);
      this.mLeftBackBtn.setOnClickListener(new TroopMemberListActivity.7(this));
    }
    else if (i == 5)
    {
      this.mTitle.setText(getString(2131696312));
      if (this.mLeftBackBtnText == null) {
        this.mLeftBackBtnText = getString(2131690706);
      }
      this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
      this.mTitleRightImgBtn.setVisibility(8);
      this.mTitleSortImgBtn.setVisibility(0);
      this.mTitleRightImgBtn.setImageResource(2130840347);
    }
    else if ((i != 14) && (i != 16))
    {
      if (i == 15)
      {
        this.mTitle.setText(2131719964);
        this.mRightManageBtn.setText(2131691859);
        this.mRightManageBtn.setVisibility(0);
        this.mRightManageBtn.setOnClickListener(this.mMultiDeleteListener);
        this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
        this.mTitleRightImgBtn.setVisibility(8);
        this.mTitleSortImgBtn.setVisibility(8);
      }
      else if ((i != 12) && (i != 20) && (i != 21))
      {
        if (i == 18)
        {
          this.mTitle.setText(2131719800);
          this.mRightManageBtn.setVisibility(8);
          this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
          this.mTitleSortImgBtn.setVisibility(8);
          this.mTitleRightImgBtn.setVisibility(8);
        }
        else if (i == 19)
        {
          this.mTitleRightImgBtn.setVisibility(8);
          this.mTitleSortImgBtn.setVisibility(8);
          this.mTitle.setText(HardCodeUtil.a(2131715336));
          this.mLeftBackBtn.setOnClickListener(new TroopMemberListActivity.8(this));
        }
        else if (i == 23)
        {
          this.mTitle.setText(2131719800);
          this.mRightManageBtn.setVisibility(8);
          this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
          this.mTitleSortImgBtn.setVisibility(8);
          this.mTitleRightImgBtn.setVisibility(8);
        }
        else
        {
          this.mTitle.setText(HardCodeUtil.a(2131715403));
          localObject = this.mCustomTitleName;
          if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            this.mTitle.setText(this.mCustomTitleName);
          }
          if (this.mLeftBackBtnText == null) {
            this.mLeftBackBtnText = getString(2131690706);
          }
          this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
          this.mRightManageBtn.setVisibility(8);
          this.mRightManageBtn.setText(2131692486);
          if (this.mFrom != 4)
          {
            this.mTitleRightImgBtn.setVisibility(0);
            this.mTitleRightImgBtn.setImageResource(2130840347);
            this.mTitleRightImgBtn.setContentDescription(getString(2131697523));
            if (this.mFrom != 22) {
              this.mTitleSortImgBtn.setVisibility(0);
            }
          }
          else
          {
            this.mTitleRightImgBtn.setVisibility(8);
            this.mTitleSortImgBtn.setVisibility(8);
          }
        }
      }
      else
      {
        localObject = this.mPickTitle;
        if (localObject != null) {
          this.mTitle.setText((CharSequence)localObject);
        }
        this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
        this.mTitleRightImgBtn.setVisibility(8);
        this.mTitleSortImgBtn.setVisibility(8);
        if (this.mPickMaxNum == 1)
        {
          this.mRightManageBtn.setVisibility(8);
        }
        else
        {
          this.mRightManageBtn.setText(getString(2131692486));
          this.mRightManageBtn.setVisibility(0);
          this.mRightManageBtn.setContentDescription(getString(2131691789));
        }
      }
    }
    else
    {
      localObject = this.mCustomTitleName;
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.mTitle.setText(this.mCustomTitleName);
      }
      this.mLeftBackBtn.setVisibility(8);
      this.mTitleRightImgBtn.setVisibility(8);
      this.mTitleSortImgBtn.setVisibility(8);
      this.mRightManageBtn.setText(2131697284);
      this.mRightManageBtn.setVisibility(0);
      this.mRightManageBtn.setOnClickListener(this.mFinishListener);
    }
    if (this.mTitleSortImgBtn.getVisibility() == 0)
    {
      this.mSubTitle.setVisibility(0);
      i = this.mSortType;
      if (i >= 0)
      {
        localObject = this.mSortDescribes;
        if (i < localObject.length) {
          this.mSubTitle.setText(localObject[i]);
        }
      }
    }
    else
    {
      this.mSubTitle.setVisibility(8);
    }
    if (this.mSortType == 8)
    {
      this.mSubTitle.setVisibility(0);
      this.mSubTitle.setText(HardCodeUtil.a(2131715345));
    }
    if (this.mFrom == 14) {
      this.mSubTitle.setVisibility(8);
    }
    this.mTitleLayout.setFocusable(true);
    Object localObject = this.mTitleLayout;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mTitle.getText().toString());
    localStringBuilder.append(this.mSubTitle.getText().toString());
    ((LinearLayout)localObject).setContentDescription(localStringBuilder.toString());
  }
  
  protected void initTitleBarRightBtn()
  {
    int i = this.mFrom;
    if ((i == 2) || (i == 3) || (i == 11) || (i == 0) || (i == 17) || (i == 5) || (i == 9) || (i == 22))
    {
      if ((this.mFrom == 9) && (this.mTroopFeeEntranceType == 1))
      {
        this.mTitleRightImgBtn.setVisibility(8);
        this.mTitleSortImgBtn.setVisibility(8);
        return;
      }
      this.mTitleRightImgBtn.setOnClickListener(new TroopMemberListActivity.11(this));
      this.mTitleSortImgBtn.setOnClickListener(new TroopMemberListActivity.12(this));
    }
    i = this.mFrom;
    if ((i != 0) && (i != 9) && (i != 17) && (i != 22))
    {
      if (i == 7)
      {
        this.mTitleRightImgBtn.setVisibility(8);
        this.mTitleSortImgBtn.setVisibility(8);
      }
      else if ((i != 12) && (i != 20))
      {
        if (i == 21) {
          this.mRightManageBtn.setOnClickListener(new TroopMemberListActivity.15(this));
        } else if (i == 22) {
          this.mTitleSortImgBtn.setVisibility(8);
        }
      }
      else
      {
        this.mRightManageBtn.setOnClickListener(new TroopMemberListActivity.14(this));
      }
    }
    else {
      this.mRightManageBtn.setOnClickListener(new TroopMemberListActivity.13(this));
    }
    if ((this.mIsQidianPrivateTroop) && (!this.mIsTroopAdmin))
    {
      TroopInfo localTroopInfo = this.mTroopInfo;
      if ((localTroopInfo == null) || (!localTroopInfo.mMemberInvitingFlag) || (this.mTroopInfo.cGroupOption == 3)) {
        this.mTitleRightImgBtn.setVisibility(8);
      }
    }
  }
  
  protected void inviteMember()
  {
    ThreadManager.post(new TroopMemberListActivity.49(this), 8, null, true);
    doReport("Clk_invite", this.mMyTroopRole, "");
  }
  
  protected void kickOutDiscussionMember(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("kickOutDiscussionMember:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        if (this.mProgressDialog == null)
        {
          this.mProgressDialog = new ReportDialog(this, 2131756189);
          this.mProgressDialog.setContentView(2131558463);
          localObject = this.mProgressDialog;
          int i = this.mFrom;
          bool = true;
          if (i != 1)
          {
            ((Dialog)localObject).setCancelable(bool);
            ((TextView)this.mProgressDialog.findViewById(2131365644)).setText(getString(2131691773));
          }
        }
        else
        {
          this.mProgressDialog.show();
          this.mDiscussionHandler.kickOutMemberFromDiscussion(Long.parseLong(this.mTroopCode), Long.valueOf(paramString).longValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("kickOutDiscussionMember:");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.mListView.setSelection(0);
      return;
    }
    int i = this.mAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.mListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onIndexChanged(String paramString, int paramInt)
  {
    if ("$".equals(paramString))
    {
      if ((this.mFrom == 11) && (paramInt == 1)) {
        ReportController.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    else if ((this.mFrom == 11) && (paramInt == 0)) {
      ReportController.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void openProfileCard(String paramString1, String paramString2)
  {
    paramString2 = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
    if (paramString2 != null)
    {
      if (paramString2.isFriend(paramString1))
      {
        paramString1 = new AllInOne(paramString1, 20);
        paramString1.pa = 20;
        paramString1.troopUin = this.mTroopCode;
        paramString1.troopCode = this.mTroopUin;
        paramString1.profileEntryType = 4;
        ProfileUtils.openProfileCard(this, paramString1);
        return;
      }
      paramString1 = new AllInOne(paramString1, 21);
      paramString1.pa = 21;
      paramString1.subSourceId = 11;
      paramString1.troopUin = this.mTroopCode;
      paramString1.troopCode = this.mTroopUin;
      paramString1.profileEntryType = 4;
      ProfileUtils.openProfileCard(this, paramString1);
    }
  }
  
  protected void performItemClick(AdapterView<?> paramAdapterView, int paramInt)
  {
    paramAdapterView = (TroopMemberListActivity.ATroopMember)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView != null)
    {
      if (paramAdapterView.jdField_a_of_type_JavaLangString == null) {
        return;
      }
      doItemClick(paramAdapterView);
    }
  }
  
  public void refreshAddFrdState()
  {
    if (!isResume()) {
      return;
    }
    TroopMemberListActivity.ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter != null) {
      try
      {
        localListAdapter.notifyDataSetChanged();
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
    }
    TroopMemberListActivity.SearchResultAdapter localSearchResultAdapter = this.mSearchResultAdapter;
    if (localSearchResultAdapter != null) {
      try
      {
        localSearchResultAdapter.notifyDataSetChanged();
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
  
  protected void refreshSearchResultList(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.mSearchSlideLeftUin = "";
    this.mSearchResultList.clear();
    this.root.getLayoutParams().height = -1;
    Object localObject;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ITroopRobotService localITroopRobotService;
    int i;
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      this.clear_text.setVisibility(0);
      this.searchList.setVisibility(0);
      paramString = paramString.toLowerCase();
      localObject = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localITroopRobotService = (ITroopRobotService)this.app.getRuntimeService(ITroopRobotService.class, "all");
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mListData.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.mListData.get(i);
          if ((this.mFilerRobot) && (localITroopRobotService.isRobotUin(localATroopMember.jdField_a_of_type_JavaLangString))) {
            break label1219;
          }
          localATroopMember.jdField_e_of_type_JavaLangString = "";
          localATroopMember.jdField_f_of_type_JavaLangString = "";
          if ((!paramString.equals(localATroopMember.m)) && (!paramString.equals(localATroopMember.jdField_o_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.n)))
          {
            if ((!paramString.equals(localATroopMember.jdField_j_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.l)) && (!paramString.equals(localATroopMember.jdField_k_of_type_JavaLangString)))
            {
              if ((!paramString.equals(localATroopMember.jdField_g_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.jdField_i_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.jdField_h_of_type_JavaLangString)))
              {
                if (paramString.equals(localATroopMember.jdField_a_of_type_JavaLangString))
                {
                  if (!this.mIsQidianPrivateTroop)
                  {
                    localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                    ((List)localObject).add(localATroopMember);
                  }
                }
                else if ((localATroopMember.m.indexOf(paramString) != 0) && (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.n.indexOf(paramString) != 0))
                {
                  if ((localATroopMember.jdField_j_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.l.indexOf(paramString) != 0) && (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(paramString) != 0))
                  {
                    if ((localATroopMember.jdField_g_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.jdField_i_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(paramString) != 0))
                    {
                      if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
                      {
                        if (!this.mIsQidianPrivateTroop)
                        {
                          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                          localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                          localArrayList1.add(localATroopMember);
                        }
                      }
                      else if ((localATroopMember.m.indexOf(paramString) <= 0) && (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.n.indexOf(paramString) <= 0))
                      {
                        if ((localATroopMember.jdField_j_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.l.indexOf(paramString) <= 0) && (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(paramString) <= 0))
                        {
                          if ((localATroopMember.jdField_g_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.jdField_i_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(paramString) <= 0))
                          {
                            if ((localATroopMember.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.mIsQidianPrivateTroop))
                            {
                              localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                              localArrayList2.add(localATroopMember);
                            }
                          }
                          else
                          {
                            localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_g_of_type_JavaLangString;
                            localArrayList2.add(localATroopMember);
                          }
                        }
                        else
                        {
                          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_j_of_type_JavaLangString;
                          localArrayList2.add(localATroopMember);
                        }
                      }
                      else
                      {
                        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.m;
                        localArrayList2.add(localATroopMember);
                      }
                    }
                    else
                    {
                      localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_g_of_type_JavaLangString;
                      localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_h_of_type_JavaLangString;
                      localArrayList1.add(localATroopMember);
                    }
                  }
                  else
                  {
                    localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_j_of_type_JavaLangString;
                    localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_k_of_type_JavaLangString;
                    localArrayList1.add(localATroopMember);
                  }
                }
                else
                {
                  localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.m;
                  localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.n;
                  localArrayList1.add(localATroopMember);
                }
              }
              else
              {
                localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_g_of_type_JavaLangString;
                ((List)localObject).add(localATroopMember);
              }
            }
            else
            {
              localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_j_of_type_JavaLangString;
              ((List)localObject).add(localATroopMember);
            }
          }
          else
          {
            localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.m;
            ((List)localObject).add(localATroopMember);
          }
          if (!QLog.isColorLevel()) {
            break label1219;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshSearchResultList:");
          localStringBuilder.append(localATroopMember.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(",");
          localStringBuilder.append(localATroopMember.jdField_e_of_type_JavaLangString);
          QLog.d("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
          break label1219;
        }
        Collections.sort(localArrayList1, new TroopMemberListActivity.SearchResultComparator(this));
        this.mSearchResultList.addAll((Collection)localObject);
        this.mSearchResultList.addAll(localArrayList1);
        this.mSearchResultList.addAll(localArrayList2);
        if (this.mSearchResultList.isEmpty()) {
          this.noSearchResultImage.setVisibility(0);
        } else {
          this.noSearchResultImage.setVisibility(8);
        }
        this.mSearchResultAdapter.notifyDataSetChanged();
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshSearchResultList:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(l2 - l1);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.mSearchResultList.size());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.mListData.size());
          QLog.i("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      this.clear_text.setVisibility(8);
      this.searchList.setVisibility(8);
      this.noSearchResultImage.setVisibility(8);
      this.mSearchResultAdapter.notifyDataSetChanged();
      return;
      label1219:
      i += 1;
    }
  }
  
  protected TroopMemberListActivity.ATroopMember removeItem(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeItem:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mListData.size())
        {
          localObject = (TroopMemberListActivity.ATroopMember)this.mListData.get(i);
          if ((localObject != null) && (((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (TroopMemberListActivity.ATroopMember)this.mListData.remove(i);
            return paramString;
          }
        }
        else
        {
          return null;
        }
      }
      finally
      {
        continue;
        throw paramString;
        continue;
        i += 1;
      }
    }
  }
  
  protected void removeSearchItem(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeSearchItem:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mSearchResultList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mSearchResultList.size())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.mSearchResultList.get(i);
          if ((localATroopMember == null) || (!localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            continue;
          }
          this.mSearchResultList.remove(i);
        }
        return;
      }
      finally
      {
        continue;
        throw paramString;
        continue;
        i += 1;
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void setAccSoft()
  {
    Object localObject = (ViewGroup)findViewById(2131376636);
    if (localObject != null) {
      QIphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131378803);
    if (localObject != null) {
      QIphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369202);
    if (localObject != null) {
      QIphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected void setItemViewValue(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1) {
      str = this.mSearchSlideLeftUin;
    } else {
      str = this.mSlideLeftUin;
    }
    paramTmViewHolder.jdField_a_of_type_Boolean = paramBoolean1;
    paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setVisibility(0);
    paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramTmViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    int i = this.mSortType;
    if ((i != 1) && (i != 5))
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramTmViewHolder.j.setVisibility(8);
    }
    else if (!paramATroopMember.jdField_d_of_type_Boolean)
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
    }
    else
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if ((!this.mIsHomeworkTroop) && (!isPickUpPurposeFor760()) && (paramATroopMember.jdField_e_of_type_Int != -100) && (paramATroopMember.jdField_e_of_type_Int != 0))
    {
      paramTmViewHolder.j.setVisibility(8);
      paramBitmap = paramTmViewHolder.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LV");
      ((StringBuilder)localObject).append(paramATroopMember.jdField_e_of_type_Int);
      paramBitmap.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      paramTmViewHolder.j.setVisibility(8);
    }
    setVipIconAndName(this.app, this, getResources(), paramTmViewHolder, paramATroopMember);
    if ((this.mFrom == 13) && (paramBoolean1))
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(paramATroopMember.jdField_b_of_type_JavaLangString);
      paramBitmap.append("(");
      paramBitmap.append(paramATroopMember.jdField_a_of_type_JavaLangString);
      paramBitmap.append(")");
      paramBitmap = paramBitmap.toString();
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramATroopMember.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramTmViewHolder.e.setText((CharSequence)localObject);
    }
    else if (paramBoolean2)
    {
      paramBitmap = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).createColorNickText(paramATroopMember.jdField_g_of_type_JavaLangString, 16);
      paramTmViewHolder.e.setText(paramBitmap);
      ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).setColorText(this.app, paramTmViewHolder.e, paramBitmap);
    }
    else
    {
      paramBitmap = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).createColorNickText(paramATroopMember.jdField_b_of_type_JavaLangString, 16);
      paramTmViewHolder.e.setText(paramBitmap);
      ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).setColorText(this.app, paramTmViewHolder.e, paramBitmap);
    }
    ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).setCustomCloth(paramTmViewHolder.e, this, paramATroopMember.jdField_o_of_type_Int, false);
    if ((paramBoolean2) && (paramTmViewHolder.k != null))
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(HardCodeUtil.a(2131715327));
      paramBitmap.append(paramATroopMember.jdField_j_of_type_JavaLangString);
      paramBitmap = paramBitmap.toString();
      paramTmViewHolder.k.setText(paramBitmap);
    }
    paramTmViewHolder.jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
    paramTmViewHolder.jdField_c_of_type_Int = 1;
    Object localObject = paramTmViewHolder.f;
    paramBitmap = "";
    ((TextView)localObject).setText("");
    paramTmViewHolder.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
    if (this.mFrom == 9)
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null) {
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
      }
    }
    else
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
    }
    paramTmViewHolder.g.setOnClickListener(this.mOnKickOutBtnClickListener);
    paramTmViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this.mOnKickOutBtnClickListener);
    paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setOnClickListener(this.mOnItemClickListener);
    if ((!this.mIsInDeleteState) && (!this.mIsInMultiDeleteState))
    {
      if (this.mFrom == 21)
      {
        paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      }
      else
      {
        paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      }
    }
    else
    {
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this.mOnKickOutBtnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.mIsInMultiDeleteState) {
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
    }
    i = this.mFrom;
    if ((i != 1) && (i != 13))
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
      boolean bool3 = TextUtils.isEmpty(paramATroopMember.u) ^ true;
      if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.mTroopOwnerUin))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      boolean bool1;
      if ((this.mTroopAdminUins != null) && (paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.mTroopAdminUins.contains(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool4 = this.app.getCurrentAccountUin().equals(this.mTroopOwnerUin);
      boolean bool5 = this.app.getCurrentAccountUin().equals(paramATroopMember.jdField_a_of_type_JavaLangString);
      if (this.mFrom == 5)
      {
        paramTmViewHolder.h.setVisibility(0);
        paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null) {
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
        }
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
        paramTmViewHolder.i.setVisibility(0);
        if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(this.mTroopUin))
        {
          if ((bool3) && (!SimpleUIUtil.a()))
          {
            localObject = TroopRankConfig.a().a(302, bool3, paramBoolean1, bool1);
            if (localObject != null)
            {
              i = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
              paramBitmap = paramATroopMember.u;
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            if (paramBoolean1)
            {
              localObject = TroopRankConfig.a().a(300, bool3, paramBoolean1, bool1);
              if (localObject != null)
              {
                i = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
                paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
                break label1124;
              }
            }
            else if (bool1)
            {
              localObject = TroopRankConfig.a().a(301, bool3, paramBoolean1, bool1);
              if (localObject != null)
              {
                i = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
                paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
                break label1124;
              }
            }
            i = 0;
          }
          label1124:
          if (!TextUtils.isEmpty(paramBitmap))
          {
            paramTmViewHolder.h.setText(paramBitmap);
            TroopRankConfig.a(paramTmViewHolder.h, i);
          }
          else
          {
            paramTmViewHolder.h.setVisibility(8);
          }
        }
        else
        {
          paramBitmap = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem_Unique(this.mTroopInfo, paramATroopMember.jdField_a_of_type_JavaLangString, paramATroopMember.u, paramATroopMember.jdField_a_of_type_Byte);
          if ((paramBitmap != null) && (paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null)) {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
          }
        }
      }
      else
      {
        paramBitmap = this.mTroopInfo;
        boolean bool2;
        if (paramBitmap != null) {
          bool2 = paramBitmap.isQidianPrivateTroop();
        } else {
          bool2 = false;
        }
        if ((!bool2) && (!this.mIsHomeworkTroop))
        {
          TroopRankConfig.TroopRankItem localTroopRankItem = TroopRankConfig.a().a(paramATroopMember.jdField_a_of_type_Int, bool3, paramBoolean1, bool1);
          if (localTroopRankItem != null)
          {
            paramBitmap = localTroopRankItem.jdField_a_of_type_JavaLangString;
            j = localTroopRankItem.jdField_b_of_type_Int;
            if (localTroopRankItem.jdField_a_of_type_Int == 302) {
              paramBitmap = paramATroopMember.u;
            }
            localObject = paramBitmap;
            i = j;
            if (this.mTroopInfo != null)
            {
              localObject = paramBitmap;
              i = j;
              if (localTroopRankItem.jdField_a_of_type_Int == 315)
              {
                paramBitmap = (String)this.mTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_c_of_type_Int));
                i = j;
                break label1465;
              }
            }
          }
          else
          {
            if ((this.mTroopInfo != null) && (paramATroopMember.jdField_a_of_type_Int == 315))
            {
              paramBitmap = (String)this.mTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_c_of_type_Int));
              i = Color.parseColor("#8EBDF9");
              break label1465;
            }
            paramBitmap = "";
            i = 0;
            break label1465;
          }
        }
        else
        {
          paramBitmap = TroopRankConfig.a().a(paramBoolean1, bool1);
          if (paramBitmap != null)
          {
            localObject = paramBitmap.jdField_a_of_type_JavaLangString;
            i = paramBitmap.jdField_b_of_type_Int;
          }
          else
          {
            localObject = "";
            i = 0;
          }
        }
        paramBitmap = (Bitmap)localObject;
        label1465:
        if (this.mFrom == 11) {
          paramBitmap = "";
        }
        localObject = this.mTroopInfo;
        int k;
        if ((localObject != null) && (1 != ((TroopInfo)localObject).cGroupRankUserFlag)) {
          k = 0;
        } else {
          k = 1;
        }
        localObject = TroopRankConfig.a().a(paramBoolean1, bool1);
        if (localObject != null) {
          j = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
        } else {
          j = 0;
        }
        if (((SimpleUIUtil.a()) || (k == 0)) && (paramBoolean1)) {
          paramBitmap = String.format(getString(2131689491), new Object[0]);
        } else if (((SimpleUIUtil.a()) || (k == 0)) && (bool1)) {
          paramBitmap = String.format(getString(2131689490), new Object[0]);
        } else {
          j = i;
        }
        if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(this.mTroopUin))
        {
          if (paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null) {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
          }
          if (((SimpleUIUtil.a()) || (k == 0)) && (!bool1) && (!paramBoolean1)) {
            i = 1;
          } else {
            i = 0;
          }
          if ((!TextUtils.isEmpty(paramBitmap)) && (!isPickUpPurposeFor760()) && (i == 0) && (j != 0))
          {
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramBitmap);
            TroopRankConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, j);
          }
          else
          {
            paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
        else
        {
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null)
          {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
            j = paramATroopMember.jdField_d_of_type_Int;
            i = j;
            if (j == 0) {
              i = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertOldLevelToNewLevel(paramATroopMember.jdField_c_of_type_Int);
            }
            paramBitmap = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(this.mTroopInfo, paramATroopMember.jdField_a_of_type_JavaLangString, i, paramATroopMember.jdField_a_of_type_Int, paramATroopMember.u, paramATroopMember.jdField_a_of_type_Byte);
            if (paramBitmap == null) {
              return;
            }
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
          }
        }
        paramBitmap = (ITroopHonorService)this.app.getRuntimeService(ITroopHonorService.class, "");
        if (paramBitmap.isSupportTroopHonor(this.mTroopUin))
        {
          paramBitmap = paramBitmap.convertToHonorList(paramATroopMember.v, Byte.valueOf(paramATroopMember.jdField_a_of_type_Byte));
          if ((paramBitmap != null) && (paramBitmap.size() > 0))
          {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(paramBitmap, 2);
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(0);
          }
          else
          {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          }
        }
        else
        {
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
        }
        if (this.mIsHomeworkTroop) {
          if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(this.mTroopUin))
          {
            if (paramTmViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null) {
              paramTmViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
            }
            paramBitmap = TroopRankConfig.a().a(paramATroopMember.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap != null) && (((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramATroopMember.jdField_a_of_type_Int)))
            {
              if ((!TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) && (!SimpleUIUtil.a()))
              {
                paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
                paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
                TroopRankConfig.a(paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
              }
              else
              {
                paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              }
            }
            else {
              paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
          else
          {
            paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            if (paramTmViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView != null)
            {
              paramTmViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
              if (paramBoolean1)
              {
                paramBitmap = new TroopMemberRankItem();
                paramBitmap.jdField_b_of_type_Boolean = true;
                paramBitmap.jdField_a_of_type_Boolean = false;
                paramBitmap.jdField_a_of_type_Int = 300;
                paramBitmap.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramBitmap.jdField_a_of_type_Int);
                paramBitmap.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
                paramTmViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
              }
              else if (bool1)
              {
                paramBitmap = new TroopMemberRankItem();
                paramBitmap.jdField_b_of_type_Boolean = true;
                paramBitmap.jdField_a_of_type_Boolean = false;
                paramBitmap.jdField_a_of_type_Int = 301;
                paramBitmap.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramBitmap.jdField_a_of_type_Int);
                paramBitmap.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
                paramTmViewHolder.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
              }
            }
          }
        }
        i = this.mFrom;
        if ((i != 9) && (i != 12)) {
          if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
            paramTmViewHolder.f.setText(getString(2131694384));
          } else {
            paramTmViewHolder.f.setText("");
          }
        }
      }
      paramBitmap = (ITroopRobotService)this.app.getRuntimeService(ITroopRobotService.class, "all");
      if ((paramBitmap != null) && (paramBitmap.isRobotUin(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.mIsInDeleteState)
      {
        if ((this.mFrom != 21) && ((paramBoolean1) || ((!bool4) && (bool1)) || ((!bool4) && (i != 0))))
        {
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
        }
        else
        {
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130850005);
          if (str.equals(paramATroopMember.jdField_a_of_type_JavaLangString)) {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.a(false);
          } else {
            paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
          }
        }
      }
      else
      {
        if (this.mIsInMultiDeleteState)
        {
          if ((!paramBoolean1) && ((bool4) || (!bool1)) && (!bool5)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.mAdapter.jdField_b_of_type_JavaUtilList.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840575);
              i = 1;
              break label2638;
            }
            paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840571);
          }
          i = 0;
          label2638:
          break label2969;
        }
        if (this.mFrom == 20)
        {
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.mAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember)))
          {
            paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840575);
            i = 1;
            break label2969;
          }
          paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840571);
        }
        else
        {
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
        }
      }
    }
    else
    {
      paramBitmap = paramTmViewHolder.e;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(2131691790));
      ((StringBuilder)localObject).append(paramTmViewHolder.e.getText().toString());
      paramBitmap.setContentDescription(((StringBuilder)localObject).toString());
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130850005);
      i = this.mFrom;
      if (i == 13)
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      else if (i == 21)
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      else if ((this.mTroopOwnerUin != null) && (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.mTroopOwnerUin)))
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      else
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
      }
      if (str.equals(paramATroopMember.jdField_a_of_type_JavaLangString)) {
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.a(false);
      } else {
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131691775), new Object[] { paramTmViewHolder.e.getText().toString() }));
      paramTmViewHolder.g.setContentDescription(getString(2131691774));
    }
    i = 0;
    label2969:
    int j = 1;
    if (paramTmViewHolder.jdField_d_of_type_AndroidViewView != null)
    {
      paramBitmap = (ITroopRobotService)this.app.getRuntimeService(ITroopRobotService.class, "all");
      if ((paramBitmap == null) || (!paramBitmap.isRobotUin(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        j = 0;
      }
      if (j != 0) {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      } else {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if (this.mIsQidianPrivateTroop) {
      paramTmViewHolder.j.setVisibility(8);
    }
    paramBitmap = new StringBuffer();
    paramBitmap.append(paramTmViewHolder.e.getText().toString());
    if ((paramBoolean2) && (paramTmViewHolder.k != null)) {
      paramBitmap.append(paramTmViewHolder.k.getText());
    }
    if (paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
    }
    if (paramTmViewHolder.j.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.j.getText().toString());
    }
    if (paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.a());
    }
    if ((paramTmViewHolder.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.mIsInMultiDeleteState))
    {
      if (i != 0) {
        paramATroopMember = "已选中";
      } else {
        paramATroopMember = "未选中";
      }
      paramBitmap.append(paramATroopMember);
    }
    paramTmViewHolder.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
  }
  
  protected void showActionSheet()
  {
    String[] arrayOfString;
    if (this.mFrom == 9) {
      arrayOfString = getResources().getStringArray(2130968678);
    } else {
      arrayOfString = getResources().getStringArray(2130968676);
    }
    int i = this.mFrom;
    if ((i != 0) && (i != 17) && (i != 22))
    {
      if (i == 9) {
        i = arrayOfString.length;
      } else {
        i = arrayOfString.length - 5;
      }
    }
    else if (this.mIsTroopAdmin)
    {
      i = arrayOfString.length;
    }
    else
    {
      TroopInfo localTroopInfo = this.mTroopInfo;
      if ((localTroopInfo != null) && (localTroopInfo.mMemberInvitingFlag))
      {
        if (this.mTroopInfo.cGroupOption != 3)
        {
          i = arrayOfString.length - 1;
          break label142;
        }
        i = arrayOfString.length;
      }
      else
      {
        i = arrayOfString.length;
      }
      i -= 2;
    }
    label142:
    this.mActionSheet = ActionSheet.create(this);
    int j = 0;
    while (j < i)
    {
      if (this.mIsQidianPrivateTroop)
      {
        if ((!HardCodeUtil.a(2131715371).equals(arrayOfString[j])) && (j == 2))
        {
          this.mActionSheet.addButton(arrayOfString[j]);
          break;
        }
      }
      else if (j == 3)
      {
        this.mActionSheet.addButton(arrayOfString[j], 3);
      }
      else
      {
        this.mActionSheet.addButton(arrayOfString[j]);
        if (arrayOfString[j].equals(HardCodeUtil.a(2131715331))) {
          ReportController.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.mTroopUin, "", "", "");
        }
      }
      j += 1;
    }
    if ((!this.mIsTroopAdmin) && (this.mTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
      this.mActionSheet.addButton(arrayOfString[3], 3);
    }
    this.mActionSheet.addCancelButton(2131690728);
    this.mActionSheet.setOnButtonClickListener(this.mOnActionSheetClickListener);
    this.mActionSheet.show();
  }
  
  protected void showMemberDstribute()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=");
    ((StringBuilder)localObject1).append(this.mTroopUin);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new ActivityURIRequest(this, "/pubaccount/browser");
    ((ActivityURIRequest)localObject2).extra().putString("url", (String)localObject1);
    QRoute.startUri((URIRequest)localObject2, null);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showMemberDstribute:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
    }
    doReport("Clk_mberdist", this.mMyTroopRole, "");
  }
  
  void showTroopSendFlowerNoPermission()
  {
    if (!this.hasSendFlowerPrivilege)
    {
      ViewStub localViewStub = (ViewStub)findViewById(2131379358);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131379359)).setOnTouchListener(new TroopMemberListActivity.50(this));
      }
    }
  }
  
  protected List<TroopMemberListActivity.ATroopMember> sortAdminsWithHomework(List<TroopMemberListActivity.ATroopMember> paramList, String paramString1, String paramString2)
  {
    int i1 = paramList.size();
    if (i1 > 0)
    {
      int i = 0;
      while (i < i1)
      {
        TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)paramList.get(i);
        if ((paramString1 != null) && (paramString1.equals(localATroopMember.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i);
          paramList.add(0, localATroopMember);
          break;
        }
        i += 1;
      }
      int n = 1;
      int k = 1;
      int m;
      for (int j = 1;; j = i)
      {
        i = j;
        m = n;
        if (k >= i1) {
          break;
        }
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(k);
        i = j;
        if (paramString2.contains(paramString1.jdField_a_of_type_JavaLangString))
        {
          i = j;
          if (paramString1.jdField_a_of_type_Int == 332)
          {
            paramList.remove(k);
            paramList.add(j, paramString1);
            i = j + 1;
          }
        }
        k += 1;
      }
      while (m < i1)
      {
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(m);
        j = i;
        if (paramString2.contains(paramString1.jdField_a_of_type_JavaLangString))
        {
          j = i;
          if (paramString1.jdField_a_of_type_Int == 333)
          {
            paramList.remove(m);
            paramList.add(i, paramString1);
            j = i + 1;
          }
        }
        m += 1;
        i = j;
      }
      for (j = i; i < i1; j = k)
      {
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i);
        k = j;
        if (paramString1.jdField_a_of_type_Int == 332)
        {
          paramList.remove(i);
          paramList.add(j, paramString1);
          k = j + 1;
        }
        i += 1;
      }
      for (i = j; j < i1; i = k)
      {
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(j);
        k = i;
        if (paramString1.jdField_a_of_type_Int == 333)
        {
          paramList.remove(j);
          paramList.add(i, paramString1);
          k = i + 1;
        }
        j += 1;
      }
      for (j = i; i < i1; j = k)
      {
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i);
        k = j;
        if (paramString2.contains(paramString1.jdField_a_of_type_JavaLangString))
        {
          paramList.remove(i);
          paramList.add(j, paramString1);
          k = j + 1;
        }
        i += 1;
      }
    }
    return paramList;
  }
  
  void startAnimation(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    else if (paramInt2 == 1)
    {
      localObject = new TranslateAnimation(0.0F, this.mDensity * -34.0F, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    else
    {
      localObject = AnimationUtils.loadAnimation(this, paramInt1);
    }
    if (localObject != null)
    {
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setAnimationListener(new TroopMemberListActivity.AnimationEndClearListener(this, paramView, paramInt2));
      paramView.clearAnimation();
      paramView.startAnimation((Animation)localObject);
    }
  }
  
  protected void startTroopMemberCardActivity(String paramString)
  {
    if (((ITroopRobotService)this.app.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this, this.mTroopUin, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131719952));
    String str = this.mCustomTitleName;
    if ((str != null) && (!TextUtils.isEmpty(str))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131690706));
    }
    ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).openTroopmemberCard(this.app, this, this.mTroopUin, paramString, 1, localBundle);
    this.mActionMemberUin = paramString;
    doReport("Clk_item", this.mMyTroopRole, "");
  }
  
  void stopTitleProgress()
  {
    this.mHandler.removeMessages(14);
    RelativeLayout localRelativeLayout = this.mLoadingLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0)) {
      this.mLoadingLayout.setVisibility(8);
    }
  }
  
  public void updateMaxItemCount(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      TroopMemberListActivity.ListAdapter localListAdapter = this.mAdapter;
      if (localListAdapter == null) {
        return;
      }
      if (localListAdapter.jdField_b_of_type_Int + this.mAdapter.jdField_c_of_type_Int > 16) {
        return;
      }
      int k = 1;
      int j = 0;
      int i = 0;
      while (k < paramArrayOfInt.length)
      {
        int m = paramArrayOfInt[k] - paramArrayOfInt[(k - 1)] - 1;
        if (m > 0)
        {
          int n = j + this.mIndexHeight;
          j = this.mItemHeight * m + n;
          if (j > this.mMaxAvailableHeight)
          {
            j = m;
            do
            {
              m = j - 1;
              k = this.mIndexHeight * m + n;
              if (k <= this.mMaxAvailableHeight) {
                break;
              }
              j = m;
            } while (m > 0);
            i += m;
            j = k;
            break;
          }
          i += m;
        }
        k += 1;
      }
      if (j + this.mItemHeight > this.mMaxAvailableHeight) {
        this.mMaxItemCountPerPage = (i + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("updateMaxItemCount, max: %s", new Object[] { Integer.valueOf(this.mMaxItemCountPerPage) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */