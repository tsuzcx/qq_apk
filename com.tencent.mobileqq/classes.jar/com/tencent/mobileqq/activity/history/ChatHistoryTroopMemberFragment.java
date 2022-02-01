package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper.AddFrdHelperListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.memberlist.TroopMemberList.TroopAdmin;
import com.tencent.mobileqq.troop.observer.TroopFeeObserver;
import com.tencent.mobileqq.troop.observer.TroopMessageObserver;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.mobileqq.troop.troopmessage.api.ITroopMessageHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
import cooperation.troop.TroopFileProxyActivity;
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

public class ChatHistoryTroopMemberFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, IndexView.OnIndexChangedListener, IndexView.OnIndexChangedListener2, AdapterView.OnItemClickListener
{
  protected static double b = 10.0D;
  private static int p = 1000;
  protected double a;
  protected float a;
  protected int a;
  protected long a;
  protected Drawable a;
  protected LayoutInflater a;
  public View.OnClickListener a;
  protected EditText a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  protected ChatHistoryTroopMemberFragment.ListAdapter a;
  protected ChatHistoryTroopMemberFragment.SearchResultAdapter a;
  TroopMemberAddFrdHelper.AddFrdHelperListener jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener = new ChatHistoryTroopMemberFragment.1(this);
  public TroopMemberAddFrdHelper a;
  protected DiscussionHandler a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public DiscussionObserver a;
  public TroopObserver a;
  protected TroopInfoData a;
  public TroopFeeObserver a;
  public TroopMessageObserver a;
  public TroopOnlineMemberObserver a;
  public TroopRobotObserver a;
  public TroopSettingObserver a;
  protected IndexView a;
  protected ActionSheet.OnButtonClickListener a;
  protected ActionSheet a;
  protected PinnedDividerSwipListView a;
  protected PopupMenuDialog a;
  protected XListView a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  protected ArrayList<String> a;
  public List<ChatHistoryTroopMemberFragment.ATroopMember> a;
  private long[] jdField_a_of_type_ArrayOfLong;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  protected long b;
  protected Handler b;
  public View.OnClickListener b;
  protected View b;
  protected ImageView b;
  protected LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  protected QQAppInterface b;
  public String b;
  protected ArrayList<String> b;
  protected List<ChatHistoryTroopMemberFragment.ATroopMember> b;
  private long[] jdField_b_of_type_ArrayOfLong;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  protected int c;
  private long jdField_c_of_type_Long = 0L;
  protected Dialog c;
  private Handler jdField_c_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  public View.OnClickListener c;
  protected View c;
  protected RelativeLayout c;
  protected TextView c;
  protected String c;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<DiscussionMemberInfo> c;
  private long[] jdField_c_of_type_ArrayOfLong;
  public int d;
  private long jdField_d_of_type_Long = 0L;
  public Dialog d;
  public View.OnClickListener d;
  protected View d;
  protected RelativeLayout d;
  protected TextView d;
  protected String d;
  private ArrayList<String> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  protected List<String> d;
  protected boolean d;
  protected int e;
  protected View e;
  protected RelativeLayout e;
  protected TextView e;
  protected String e;
  private ArrayList<String> jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  protected List<String> e;
  boolean jdField_e_of_type_Boolean = false;
  protected int f;
  protected View f;
  protected String f;
  private ArrayList<String> f;
  protected List<String> f;
  protected boolean f;
  protected int g;
  private View jdField_g_of_type_AndroidViewView;
  protected String g;
  private ArrayList<String> jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  private List<oidb_cmd0x74f.Range> jdField_g_of_type_JavaUtilList = new ArrayList();
  protected boolean g;
  public int h;
  protected String h;
  protected boolean h;
  public int i;
  protected String i;
  protected boolean i;
  public int j;
  protected String j;
  protected boolean j;
  public int k;
  protected String k;
  protected boolean k;
  public int l;
  protected String l;
  protected boolean l;
  protected int m;
  protected String m;
  protected boolean m;
  private int n;
  protected String n;
  public boolean n;
  private int o;
  protected String o;
  protected boolean o;
  protected String p;
  protected boolean p;
  public final String q;
  private boolean q;
  public final String r;
  private boolean r;
  public final String s;
  private boolean s;
  protected String t;
  private boolean t;
  protected String u;
  private boolean u;
  protected String v;
  private boolean v;
  protected String w;
  private String x = HardCodeUtil.a(2131701856);
  
  public ChatHistoryTroopMemberFragment()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = -1;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = 2147483647;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_o_of_type_JavaLangString = "2";
    this.jdField_p_of_type_JavaLangString = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
    this.jdField_s_of_type_Boolean = false;
    this.jdField_q_of_type_JavaLangString = "param_seq_name";
    this.jdField_r_of_type_JavaLangString = "param_seq_days";
    this.jdField_s_of_type_JavaLangString = "param_deleted_uins";
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_t_of_type_Boolean = true;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 50;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper = null;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ChatHistoryTroopMemberFragment.10(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ChatHistoryTroopMemberFragment.11(this);
    this.jdField_m_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new ChatHistoryTroopMemberFragment.29(this);
    this.jdField_b_of_type_AndroidOsHandler = new ChatHistoryTroopMemberFragment.34(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ChatHistoryTroopMemberFragment.35(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_n_of_type_Int = -1;
    this.jdField_o_of_type_Int = 0;
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new ChatHistoryTroopMemberFragment.37(this);
    this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new ChatHistoryTroopMemberFragment.40(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new ChatHistoryTroopMemberFragment.41(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver = new ChatHistoryTroopMemberFragment.42(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new ChatHistoryTroopMemberFragment.43(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopFeeObserver = new ChatHistoryTroopMemberFragment.44(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopMessageObserver = new ChatHistoryTroopMemberFragment.45(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver = new ChatHistoryTroopMemberFragment.46(this);
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        localMenuItem.title = arrayOfString[i1];
        localMenuItem.id = i1;
        localMenuItem.contentDescription = arrayOfString[i1];
        localArrayList.add(localMenuItem);
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(getBaseActivity(), localArrayList, new ChatHistoryTroopMemberFragment.4(this), null, UIUtils.a(getBaseActivity(), 135.0F), false);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setTouchInterceptor(new ChatHistoryTroopMemberFragment.5(this));
      c(this.jdField_m_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(UIUtils.a(getBaseActivity(), 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
  }
  
  private void F()
  {
    String str = this.jdField_g_of_type_JavaLangString;
    if ((str == null) || (!str.contains(getBaseActivity().app.getCurrentAccountUin())))
    {
      str = this.jdField_f_of_type_JavaLangString;
      if ((str == null) || (!str.equals(getBaseActivity().app.getCurrentAccountUin()))) {}
    }
    else
    {
      i1 = 1;
      break label59;
    }
    int i1 = 0;
    label59:
    if ((!this.jdField_h_of_type_Boolean) && (i1 != 0))
    {
      i1 = this.jdField_d_of_type_Int;
      if (((i1 == 0) || (i1 == 17)) && (System.currentTimeMillis() > this.jdField_c_of_type_Long)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.21(this), 8, null, true);
      }
    }
  }
  
  private void G()
  {
    if (this.jdField_g_of_type_AndroidViewView != null) {
      return;
    }
    Object localObject1 = getBaseActivity().getLayoutInflater();
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView;
    int i2 = 0;
    this.jdField_g_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2131562974, (ViewGroup)localObject2, false);
    localObject1 = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131368748);
    localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
    Object localObject3 = this.jdField_g_of_type_JavaUtilList.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (oidb_cmd0x74f.Range)((Iterator)localObject3).next();
      this.jdField_d_of_type_JavaUtilArrayList.add(String.valueOf(((oidb_cmd0x74f.Range)localObject4).uint32_days.get()));
      this.jdField_c_of_type_JavaUtilArrayList.add(((oidb_cmd0x74f.Range)localObject4).string_name.get());
    }
    localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject3).next();
      if (((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).jdField_b_of_type_Long == 0L) {
        ((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).jdField_b_of_type_Long = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).jdField_a_of_type_Long;
      }
      if (!TextUtils.isEmpty(a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).jdField_b_of_type_Long, (Calendar)localObject2, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
        i1 += 1;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_f_of_type_JavaLangString;
    if ((localObject1 == null) || (!((String)localObject1).equals(getBaseActivity().app.getCurrentAccountUin()))) {
      i2 = 1;
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new ChatHistoryTroopMemberFragment.22(this, i1, i2));
    H();
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_g_of_type_AndroidViewView);
    localObject1 = getBaseActivity().app;
    localObject2 = this.jdField_c_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i2);
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
  }
  
  private void H()
  {
    Object localObject = this.jdField_g_of_type_AndroidViewView;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView != null))
    {
      localObject = ((View)localObject).findViewById(2131376549);
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
          {
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 26.0F));
            return;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 18.0F));
        }
      }
    }
  }
  
  private void I()
  {
    this.jdField_d_of_type_AndroidAppDialog = new ReportDialog(getBaseActivity());
    this.jdField_d_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_d_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_d_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_d_of_type_AndroidAppDialog.setContentView(2131562779);
    Object localObject = this.jdField_d_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_d_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getBaseActivity().getSystemService("input_method");
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT < 24))
    {
      this.jdField_d_of_type_AndroidAppDialog.getWindow().addFlags(67108864);
      int i1 = getResources().getColor(2131167114);
      new SystemBarCompact(this.jdField_d_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_d_of_type_AndroidAppDialog.findViewById(2131376809);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131377016));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838739));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter = new ChatHistoryTroopMemberFragment.SearchResultAdapter(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ChatHistoryTroopMemberFragment.23(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ChatHistoryTroopMemberFragment.SearchTextWatcher(this));
    this.jdField_d_of_type_AndroidViewView = this.jdField_d_of_type_AndroidAppDialog.findViewById(2131376809);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131368340));
    this.jdField_c_of_type_AndroidViewView = this.jdField_d_of_type_AndroidAppDialog.findViewById(2131371921);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131376483));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ChatHistoryTroopMemberFragment.24(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ChatHistoryTroopMemberFragment.25(this));
  }
  
  private void J()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format(HardCodeUtil.a(2131701831), new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.30(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701843));
  }
  
  private void K()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(0, this.jdField_o_of_type_Int, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  private View a(int paramInt)
  {
    return this.jdField_f_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = this.jdField_d_of_type_Int;
    if ((i1 != 20) && (i1 != 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131701821), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    } else {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131701853), new Object[] { Integer.valueOf(paramInt3) }));
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Object localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 3))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
      ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    else if ((paramMessage != null) && (paramMessage.length == 1))
    {
      try
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
        QLog.d(".troop.troopManagerVASH", 2, new Object[] { "refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
      finally {}
    }
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      F();
      w();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
      if (paramMessage != null)
      {
        paramMessage.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter = new ChatHistoryTroopMemberFragment.ListAdapter(this);
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter);
      }
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setVisibility(0);
    }
    if ((!this.jdField_j_of_type_Boolean) || (this.jdField_d_of_type_Int == 11)) {
      z();
    }
    s();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    ProtoUtils.b(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void a(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    ReportDialog localReportDialog = new ReportDialog(getBaseActivity(), 2131756189);
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
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.allowMemberKick == 1)) {
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
    localTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.38(this, localReportDialog));
    ((TextView)localObject).setOnClickListener(new ChatHistoryTroopMemberFragment.39(this, paramList, localCheckBox, bool, localReportDialog));
    localReportDialog.show();
  }
  
  private void a(List<TroopMemberInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processConvertTroopMemberInfo2AtTroopMember, processIndex:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        Object localObject2;
        if (Utils.d(localTroopMemberInfo.memberuin))
        {
          if ((this.jdField_d_of_type_Int != 2) || ((!localTroopMemberInfo.memberuin.equals(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_g_of_type_JavaLangString.contains(localTroopMemberInfo.memberuin))))
          {
            localObject2 = this.jdField_f_of_type_JavaUtilList;
            if (((localObject2 == null) || (!((List)localObject2).contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localITroopRobotService.isRobotUin(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000"))) {
              ((List)localObject1).add(a(localTroopMemberInfo, localFriendsManager));
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:");
          ((StringBuilder)localObject2).append(localTroopMemberInfo.memberuin);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i1 += 1;
    }
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(12, localObject1);
    paramList.arg1 = paramInt;
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i1 = this.jdField_d_of_type_Int;
    boolean bool = false;
    if ((i1 == 3) && (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int != 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject2;
    Object localObject3;
    if ((!this.jdField_d_of_type_Boolean) && (paramBoolean3))
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (localObject1 != null)
      {
        localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131379778);
        localObject1 = getString(2131719953);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376387);
        ((TextView)localObject2).setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369373)).setBackgroundDrawable(ImageUtil.a());
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373313);
        ((ImageView)localObject3).setVisibility(8);
        if (i1 != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new ChatHistoryTroopMemberFragment.47(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ChatHistoryTroopMemberFragment.48(this, (String)localObject1));
        if (!this.jdField_s_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
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
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject1 != null)
      {
        ((Animatable)localObject1).stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376387)).setCompoundDrawables(null, null, null, null);
      }
    }
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if ((localObject1 != null) && (((RelativeLayout)localObject1).getVisibility() != 8))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(true);
      if (paramBoolean1)
      {
        if (paramString1 == null) {
          return;
        }
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379778)).setTextColor(getResources().getColor(2131167056));
        localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376387);
        localObject2 = HardCodeUtil.a(2131701815);
        localObject3 = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372119);
        ((Button)localObject3).setVisibility(8);
        ((Button)localObject3).setOnClickListener(new ChatHistoryTroopMemberFragment.49(this));
        i1 = ((ISVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
        if (this.jdField_d_of_type_Int == 11)
        {
          if (!paramString1.equals(this.jdField_b_of_type_JavaLangString)) {
            return;
          }
          this.jdField_a_of_type_Int = paramInt2;
          paramBoolean1 = bool;
          if (paramBoolean2)
          {
            paramBoolean1 = bool;
            if (paramInt1 > 0) {
              paramBoolean1 = true;
            }
          }
          this.jdField_i_of_type_Boolean = paramBoolean1;
          if (this.jdField_i_of_type_Boolean)
          {
            paramString1 = new StringBuilder();
            paramString1.append(HardCodeUtil.a(2131701863));
            paramString1.append(paramInt1);
            paramString1.append(HardCodeUtil.a(2131701881));
            this.jdField_h_of_type_JavaLangString = paramString1.toString();
            ((TextView)localObject1).setText(this.jdField_h_of_type_JavaLangString);
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",");
            paramString1.append(this.jdField_h_of_type_JavaLangString);
            paramString1 = paramString1.toString();
          }
          else if (paramInt1 == 0)
          {
            this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131701870);
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",剩余0次");
            paramString1 = paramString1.toString();
            ((TextView)localObject1).setText("剩余0次");
          }
          else
          {
            this.jdField_h_of_type_JavaLangString = "";
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",");
            paramString1.append(HardCodeUtil.a(2131701861));
            paramString1 = paramString1.toString();
            ((TextView)localObject1).setText("");
          }
          paramString2 = paramString1;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
          {
            paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
            paramString2.rightMargin = AIOUtils.b(20.0F, getResources());
            ((TextView)localObject1).setLayoutParams(paramString2);
            paramString2 = paramString1;
          }
        }
        else
        {
          if (!paramString1.equals(this.jdField_c_of_type_JavaLangString)) {
            return;
          }
          this.jdField_i_of_type_Boolean = paramBoolean2;
          this.jdField_h_of_type_JavaLangString = paramString3;
          if (TextUtils.isEmpty(paramString2))
          {
            QLog.e("Q.history.BaseFragment", 1, "updateUIForAtAllRemainedCount remainTips empty");
            return;
          }
          if ((!this.jdField_i_of_type_Boolean) && (i1 != 3))
          {
            ((Button)localObject3).setVisibility(0);
            paramString1 = new StringBuilder();
            paramString1.append(paramString2);
            paramString1.append(",\n超级会员可继续使用");
            paramString2 = paramString1.toString();
            ((TextView)localObject1).setGravity(21);
            ((TextView)localObject1).setLineSpacing(this.jdField_a_of_type_Float * 5.0F, 1.0F);
            paramInt1 = (int)(HardCodeUtil.a(2131701888).length() * 12 * this.jdField_a_of_type_Float);
            new DisplayMetrics();
            float f1 = getResources().getDisplayMetrics().widthPixels;
            float f2 = this.jdField_a_of_type_Float;
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
          if (paramString1.contains(HardCodeUtil.a(2131701871)))
          {
            paramInt1 = paramString1.indexOf(HardCodeUtil.a(2131701807));
            paramInt2 = HardCodeUtil.a(2131701885).length();
            paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
          }
          ((TextView)localObject1).setText(paramString2);
          paramString2 = new StringBuilder();
          paramString2.append((String)localObject2);
          paramString2.append(",");
          paramString2.append(paramString1);
          paramString2 = paramString2.toString();
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramString2);
      }
    }
  }
  
  private boolean a()
  {
    int i1 = this.jdField_d_of_type_Int;
    boolean bool2 = false;
    if ((i1 != 3) && (i1 != 2) && (i1 != 14)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localTroopInfo != null)
    {
      long l1 = localTroopInfo.dwGroupClassExt;
      if ((l1 == 10009L) || (l1 == 10010L) || (l1 == 10011L))
      {
        i2 = 1;
        break label86;
      }
    }
    int i2 = 0;
    label86:
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (i2 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, TextView paramTextView, View paramView, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramTextView != null) && (paramView != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!((ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString)) {
        return;
      }
      int i2 = paramView.getWidth();
      int i1 = i2;
      if (i2 == 0)
      {
        paramView.measure(0, 0);
        i1 = paramView.getMeasuredWidth();
      }
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
        }
        return;
      }
      paramInt -= i1;
      if (paramInt > 0) {
        paramTextView.setMaxWidth(paramInt);
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:");
        paramQQAppInterface.append(i1);
        paramQQAppInterface.append(" nTargetMaxWidth:");
        paramQQAppInterface.append(paramInt);
        QLog.d("Q.history.BaseFragment", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private void c(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131365169);
    int i1 = 0;
    while (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
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
      i1 += 1;
    }
  }
  
  private int d()
  {
    int i1;
    if (this.jdField_d_of_type_Int != 3) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (this.jdField_s_of_type_Boolean) {
      i1 = 3;
    }
    return i1;
  }
  
  protected void A()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new ActivityURIRequest(getBaseActivity(), "/pubaccount/browser");
    ((ActivityURIRequest)localObject2).extra().putString("url", (String)localObject1);
    QRoute.startUri((URIRequest)localObject2, null);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showMemberDstribute:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
    }
    a("Clk_mberdist", this.jdField_o_of_type_JavaLangString, "");
  }
  
  protected void B()
  {
    ThreadManager.post(new ChatHistoryTroopMemberFragment.50(this), 8, null, true);
    a("Clk_invite", this.jdField_o_of_type_JavaLangString, "");
  }
  
  void C()
  {
    if (!this.jdField_r_of_type_Boolean)
    {
      ViewStub localViewStub = (ViewStub)a(2131379358);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131379359)).setOnTouchListener(new ChatHistoryTroopMemberFragment.51(this));
      }
    }
  }
  
  public void D()
  {
    if (!getBaseActivity().isResume()) {
      return;
    }
    ChatHistoryTroopMemberFragment.ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
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
    ChatHistoryTroopMemberFragment.SearchResultAdapter localSearchResultAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter;
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
  
  public ChatHistoryTroopMemberFragment.ATroopMember a(DiscussionMemberInfo paramDiscussionMemberInfo, FriendsManager paramFriendsManager)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    if (paramFriendsManager != null) {
      paramFriendsManager = paramFriendsManager.b(paramDiscussionMemberInfo.memberUin);
    } else {
      paramFriendsManager = null;
    }
    localATroopMember.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localATroopMember.jdField_a_of_type_Short = 0;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((paramFriendsManager != null) && (paramFriendsManager.isFriend()) && (paramFriendsManager.remark != null) && (paramFriendsManager.remark.length() > 0))
    {
      localATroopMember.e(paramFriendsManager.remark);
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
    paramDiscussionMemberInfo = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper;
    if (paramDiscussionMemberInfo != null) {
      paramDiscussionMemberInfo.a(localATroopMember);
    }
    return localATroopMember;
  }
  
  public ChatHistoryTroopMemberFragment.ATroopMember a(TroopMemberInfo paramTroopMemberInfo, FriendsManager paramFriendsManager)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (paramFriendsManager != null) {
      paramFriendsManager = paramFriendsManager.b(paramTroopMemberInfo.memberuin);
    } else {
      paramFriendsManager = null;
    }
    localATroopMember.jdField_b_of_type_JavaLangString = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, localATroopMember.jdField_a_of_type_JavaLangString, true);
    localATroopMember.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localATroopMember.b(paramTroopMemberInfo.friendnick);
      localATroopMember.d(paramTroopMemberInfo.pyAll_friendnick);
      localATroopMember.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    if ((paramFriendsManager != null) && (paramFriendsManager.isFriend()) && (paramFriendsManager.remark != null) && (paramFriendsManager.remark.length() > 0))
    {
      localATroopMember.e(paramFriendsManager.remark);
      localATroopMember.h(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 2));
      localATroopMember.g(paramFriendsManager.remark);
    }
    else if ((paramTroopMemberInfo.autoremark != null) && (paramTroopMemberInfo.autoremark.length() > 0))
    {
      if ((this.jdField_h_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
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
    localATroopMember.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
    localATroopMember.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
    localATroopMember.jdField_b_of_type_Int = paramTroopMemberInfo.level;
    localATroopMember.jdField_d_of_type_Int = paramTroopMemberInfo.realLevel;
    localATroopMember.jdField_e_of_type_Int = paramTroopMemberInfo.newRealLevel;
    localATroopMember.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
    localATroopMember.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
    localATroopMember.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
    localATroopMember.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
    localATroopMember.jdField_f_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
    double d1 = ((IBizTroopMemberInfoService)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberDiatanceToSelf(this.jdField_c_of_type_JavaLangString, localATroopMember.jdField_a_of_type_JavaLangString);
    if ((d1 != -1000.0D) && (d1 != -100.0D))
    {
      d1 /= 1000.0D;
      double d2 = 0.01D;
      if (d1 < 0.01D) {
        d1 = d2;
      }
      if (d1 > 10.0D)
      {
        paramFriendsManager = new StringBuilder();
        paramFriendsManager.append((int)d1);
        paramFriendsManager.append("km");
        localATroopMember.jdField_t_of_type_JavaLangString = paramFriendsManager.toString();
      }
      else
      {
        paramFriendsManager = new StringBuilder();
        paramFriendsManager.append(this.jdField_a_of_type_JavaTextDecimalFormat.format(d1));
        paramFriendsManager.append("km");
        localATroopMember.jdField_t_of_type_JavaLangString = paramFriendsManager.toString();
      }
    }
    else
    {
      localATroopMember.jdField_t_of_type_JavaLangString = "";
    }
    if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
    {
      localATroopMember.jdField_u_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      localATroopMember.jdField_c_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
    }
    paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper;
    if (paramFriendsManager != null) {
      paramFriendsManager.a(localATroopMember);
    }
    localATroopMember.jdField_g_of_type_Int = paramTroopMemberInfo.mVipType;
    localATroopMember.jdField_h_of_type_Int = paramTroopMemberInfo.mVipLevel;
    localATroopMember.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
    localATroopMember.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
    localATroopMember.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
    localATroopMember.jdField_l_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
    return localATroopMember;
  }
  
  protected ChatHistoryTroopMemberFragment.ATroopMember a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeItem:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localObject != null) && (((ChatHistoryTroopMemberFragment.ATroopMember)localObject).jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.remove(i1);
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
        i1 += 1;
      }
    }
  }
  
  protected ChatHistoryTroopMemberFragment.TmViewHolder a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean) {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView;
    }
    int i2 = ((ViewGroup)localObject1).getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof ChatHistoryTroopMemberFragment.TmViewHolder)))
      {
        localObject2 = (ChatHistoryTroopMemberFragment.TmViewHolder)((View)localObject2).getTag();
        if ((((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).jdField_a_of_type_JavaLangString != null) && (((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("findListItemHolderByUin:");
            paramString.append(i1);
            QLog.d("Q.history.BaseFragment", 2, paramString.toString());
          }
          return localObject2;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  public String a(long paramLong, Calendar paramCalendar, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList2.size() != 0)
    {
      if (paramArrayList1.size() == 0) {
        return null;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong * 1000L);
      int i2 = paramCalendar.get(1);
      int i3 = localCalendar.get(1);
      int i4 = paramCalendar.get(6);
      int i5 = localCalendar.get(6);
      int i1 = paramArrayList2.size() - 1;
      while (i1 >= 0)
      {
        if ((i2 - i3) * 365 + i4 - i5 >= Integer.parseInt((String)paramArrayList1.get(i1))) {
          return (String)paramArrayList2.get(i1);
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  protected List<ChatHistoryTroopMemberFragment.ATroopMember> a(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList, String paramString1, String paramString2)
  {
    int i6 = paramList.size();
    if (i6 > 0)
    {
      int i1 = 0;
      while (i1 < i6)
      {
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localATroopMember.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localATroopMember);
          break;
        }
        i1 += 1;
      }
      int i5 = 1;
      int i3 = 1;
      int i4;
      for (int i2 = 1;; i2 = i1)
      {
        i1 = i2;
        i4 = i5;
        if (i3 >= i6) {
          break;
        }
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i3);
        i1 = i2;
        if (paramString2.contains(paramString1.jdField_a_of_type_JavaLangString))
        {
          i1 = i2;
          if (paramString1.jdField_b_of_type_Int == 332)
          {
            paramList.remove(i3);
            paramList.add(i2, paramString1);
            i1 = i2 + 1;
          }
        }
        i3 += 1;
      }
      while (i4 < i6)
      {
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i4);
        i2 = i1;
        if (paramString2.contains(paramString1.jdField_a_of_type_JavaLangString))
        {
          i2 = i1;
          if (paramString1.jdField_b_of_type_Int == 333)
          {
            paramList.remove(i4);
            paramList.add(i1, paramString1);
            i2 = i1 + 1;
          }
        }
        i4 += 1;
        i1 = i2;
      }
      for (i2 = i1; i1 < i6; i2 = i3)
      {
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i1);
        i3 = i2;
        if (paramString1.jdField_b_of_type_Int == 332)
        {
          paramList.remove(i1);
          paramList.add(i2, paramString1);
          i3 = i2 + 1;
        }
        i1 += 1;
      }
      for (i1 = i2; i2 < i6; i1 = i3)
      {
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i2);
        i3 = i1;
        if (paramString1.jdField_b_of_type_Int == 333)
        {
          paramList.remove(i2);
          paramList.add(i1, paramString1);
          i3 = i1 + 1;
        }
        i2 += 1;
      }
      for (i2 = i1; i1 < i6; i2 = i3)
      {
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i1);
        i3 = i2;
        if (paramString2.contains(paramString1.jdField_a_of_type_JavaLangString))
        {
          paramList.remove(i1);
          paramList.add(i2, paramString1);
          i3 = i2 + 1;
        }
        i1 += 1;
      }
    }
    return paramList;
  }
  
  protected void a()
  {
    Object localObject = (ViewGroup)a(2131376636);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = a(2131378803);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)a(2131369202);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return;
          }
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringArrayListExtra("param_deleted_uins");
            if (paramIntent.size() > 0)
            {
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext()) {
                a((String)paramIntent.next());
              }
            }
          }
        }
        else if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("roomId");
          if (paramIntent != null)
          {
            localObject1 = ContactUtils.a(getBaseActivity().app, getBaseActivity().getApplicationContext(), paramIntent);
            localObject2 = AIOUtils.a(new Intent(getBaseActivity(), SplashActivity.class), null);
            ((Intent)localObject2).putExtra("uin", paramIntent);
            ((Intent)localObject2).putExtra("uintype", 3000);
            ((Intent)localObject2).putExtra("uinname", (String)localObject1);
            ((Intent)localObject2).putExtra("isBack2Root", true);
            ((Intent)localObject2).setFlags(67108864);
            startActivity((Intent)localObject2);
            getBaseActivity().finish();
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
          getBaseActivity().setResult(-1, paramIntent);
          getBaseActivity().finish();
          return;
        }
        ThreadManager.post(new ChatHistoryTroopMemberFragment.2(this, paramIntent, (FriendsManager)localObject1, (TroopManager)localObject2), 8, null, true);
      }
    }
    else
    {
      if (paramInt1 != 1) {
        return;
      }
      if (!TextUtils.isEmpty(this.w)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.3(this, (FriendsManager)localObject1), 8, null, true);
      }
    }
  }
  
  protected void a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if ((paramATroopMember != null) && (paramATroopMember.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
      paramATroopMember = new Intent();
      paramATroopMember.putExtra("result", new JSONArray().toString());
      getBaseActivity().setResult(-1, paramATroopMember);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      getBaseActivity().finish();
      return;
    }
    if (paramATroopMember != null)
    {
      if (paramATroopMember.jdField_a_of_type_JavaLangString == null) {
        return;
      }
      int i1 = this.jdField_d_of_type_Int;
      Object localObject1;
      if (i1 == 1)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          localObject1 = new AllInOne(paramATroopMember.jdField_a_of_type_JavaLangString, 0);
          ((AllInOne)localObject1).nickname = ContactUtils.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramATroopMember.jdField_a_of_type_JavaLangString);
          ((AllInOne)localObject1).lastActivity = 3;
          ((AllInOne)localObject1).profileEntryType = 4;
          ProfileUtils.openProfileCard(getActivity(), (AllInOne)localObject1);
          return;
        }
        a(paramATroopMember.jdField_a_of_type_JavaLangString, paramATroopMember.jdField_b_of_type_JavaLangString);
        return;
      }
      Object localObject2;
      if (i1 == 2)
      {
        localObject1 = getActivity().getIntent();
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        localObject2 = new TroopMemberList.TroopAdmin();
        ((TroopMemberList.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
        ((TroopMemberList.TroopAdmin)localObject2).jdField_a_of_type_Short = paramATroopMember.jdField_a_of_type_Short;
        ((TroopMemberList.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramATroopMember.jdField_b_of_type_JavaLangString;
        ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
        getBaseActivity().setResult(-1, (Intent)localObject1);
        getBaseActivity().finish();
        return;
      }
      if ((i1 != 3) && (i1 != 11) && (i1 != 16))
      {
        if ((i1 != 0) && (i1 != 4) && (i1 != 9) && (i1 != 15) && (i1 != 17) && (i1 != 22))
        {
          if (i1 == 5)
          {
            localObject1 = this.jdField_f_of_type_JavaLangString;
            if ((localObject1 != null) && (((String)localObject1).equals(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              i1 = 3;
            }
            else
            {
              localObject1 = this.jdField_g_of_type_JavaLangString;
              if ((localObject1 != null) && (((String)localObject1).contains(paramATroopMember.jdField_a_of_type_JavaLangString))) {
                i1 = 2;
              } else {
                i1 = 1;
              }
            }
            startActivityForResult(EditUniqueTitleActivity.a(getBaseActivity(), 1, this.jdField_c_of_type_JavaLangString, paramATroopMember.jdField_a_of_type_JavaLangString, i1, paramATroopMember.jdField_u_of_type_JavaLangString), 2);
            this.w = paramATroopMember.jdField_a_of_type_JavaLangString;
            localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = this.jdField_c_of_type_JavaLangString;
            i1 = this.jdField_m_of_type_Int;
            if (this.jdField_p_of_type_Boolean) {
              paramATroopMember = "1";
            } else {
              paramATroopMember = "0";
            }
            ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramATroopMember, "");
            return;
          }
          if (i1 == 14)
          {
            localObject1 = getActivity().getIntent();
            ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("troop_gift_from", this.jdField_e_of_type_JavaLangString);
            getActivity().setResult(-1, (Intent)localObject1);
            getActivity().finish();
            return;
          }
          if ((i1 != 12) && (i1 != 20))
          {
            if ((i1 != 18) && (i1 != 19))
            {
              if (i1 == 23)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
                ((Intent)localObject1).putExtra("filter_member_name", paramATroopMember.jdField_g_of_type_JavaLangString);
                ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramATroopMember.jdField_a_of_type_JavaLangString));
                ((Intent)localObject1).putExtra("folderPath", "/");
                ((Intent)localObject1).putExtra("param_from", 6000);
                TroopFileProxyActivity.a(getBaseActivity(), (Intent)localObject1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              }
            }
            else
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
              PublicFragmentActivity.a(getBaseActivity(), (Intent)localObject1, TroopMemberHistoryFragment.class);
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A596", "0X800A596", 1, 0, "", "", "", "");
              if (this.jdField_d_of_type_Int == 19)
              {
                paramATroopMember = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                TroopReportor.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(paramATroopMember) });
              }
            }
          }
          else
          {
            if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
              paramATroopMember = new Intent();
              localObject1 = new JSONArray();
              if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList != null)
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localATroopMember.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localATroopMember.jdField_b_of_type_JavaLangString);
                  }
                  catch (Exception localException)
                  {
                    label1030:
                    int i2;
                    break label1030;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.history.BaseFragment", 2, "json put error");
                  }
                  ((JSONArray)localObject1).put(localJSONObject);
                }
              }
              paramATroopMember.putExtra("result", ((JSONArray)localObject1).toString());
              getBaseActivity().setResult(-1, paramATroopMember);
              getBaseActivity().finish();
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.remove(paramATroopMember);
            }
            else
            {
              i1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.size();
              i2 = this.jdField_f_of_type_Int;
              if (i1 < i2)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
              }
              else if (i2 == 1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
              }
              else
              {
                paramATroopMember = getResources().getString(this.jdField_h_of_type_Int, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) });
                QQToast.a(getBaseActivity(), paramATroopMember, 0).a();
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.notifyDataSetChanged();
          }
        }
        else
        {
          f(paramATroopMember.jdField_a_of_type_JavaLangString);
          if (this.jdField_d_of_type_Int == 22) {
            TroopReportor.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString });
          }
        }
      }
      else
      {
        localObject1 = getActivity().getIntent();
        if (this.jdField_s_of_type_Boolean)
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("isApollo", true);
        }
        else
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
        }
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
        getBaseActivity().setResult(-1, (Intent)localObject1);
        getBaseActivity().finish();
      }
    }
  }
  
  protected void a(ChatHistoryTroopMemberFragment.TmViewHolder paramTmViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1) {
      str = this.jdField_v_of_type_JavaLangString;
    } else {
      str = this.jdField_u_of_type_JavaLangString;
    }
    paramTmViewHolder.jdField_a_of_type_Boolean = paramBoolean1;
    paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setVisibility(0);
    paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramTmViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    if (this.jdField_m_of_type_Int == 1)
    {
      if (!paramATroopMember.jdField_d_of_type_Boolean) {
        paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      } else {
        paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      }
    }
    else
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramTmViewHolder.j.setVisibility(8);
    }
    if ((!this.jdField_e_of_type_Boolean) && (!a()) && (paramATroopMember.jdField_f_of_type_Int != -100) && (paramATroopMember.jdField_f_of_type_Int != 0))
    {
      paramTmViewHolder.j.setVisibility(8);
      paramBitmap = paramTmViewHolder.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LV");
      ((StringBuilder)localObject).append(paramATroopMember.jdField_f_of_type_Int);
      paramBitmap.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      paramTmViewHolder.j.setVisibility(8);
    }
    VipUtils.a(getBaseActivity().app, getBaseActivity(), getResources(), paramTmViewHolder, paramATroopMember);
    if ((this.jdField_d_of_type_Int == 13) && (paramBoolean1))
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(paramATroopMember.jdField_b_of_type_JavaLangString);
      paramBitmap.append("(");
      paramBitmap.append(paramATroopMember.jdField_a_of_type_JavaLangString);
      paramBitmap.append(")");
      paramBitmap = paramBitmap.toString();
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramATroopMember.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    else if (paramBoolean2)
    {
      paramBitmap = new ColorNickText(paramATroopMember.jdField_g_of_type_JavaLangString, 16).a();
      paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      ColorNickManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
    }
    else
    {
      paramBitmap = new ColorNickText(paramATroopMember.jdField_b_of_type_JavaLangString, 16).a();
      paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      ColorNickManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
    }
    if ((paramBoolean2) && (paramTmViewHolder.k != null))
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(HardCodeUtil.a(2131701809));
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
    if (this.jdField_d_of_type_Int == 9) {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    } else {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
    }
    paramTmViewHolder.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    paramTmViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      if (this.jdField_d_of_type_Int == 21)
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
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_g_of_type_Boolean) {
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
    }
    int i1 = this.jdField_d_of_type_Int;
    if ((i1 != 1) && (i1 != 13))
    {
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
      boolean bool3 = TextUtils.isEmpty(paramATroopMember.jdField_u_of_type_JavaLangString) ^ true;
      if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      boolean bool1;
      if ((this.jdField_g_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_f_of_type_JavaLangString);
      boolean bool5 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramATroopMember.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int == 5)
      {
        paramTmViewHolder.h.setVisibility(0);
        paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramTmViewHolder.i.setVisibility(0);
        if ((bool3) && (!SimpleUIUtil.a()))
        {
          localObject = TroopRankConfig.a().a(302, bool3, paramBoolean1, bool1);
          if (localObject != null)
          {
            i1 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
            paramBitmap = paramATroopMember.jdField_u_of_type_JavaLangString;
          }
          else
          {
            i1 = 0;
          }
        }
        else
        {
          if (paramBoolean1)
          {
            localObject = TroopRankConfig.a().a(300, bool3, paramBoolean1, bool1);
            if (localObject != null)
            {
              i1 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
              paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
              break label1001;
            }
          }
          else if (bool1)
          {
            localObject = TroopRankConfig.a().a(301, bool3, paramBoolean1, bool1);
            if (localObject != null)
            {
              i1 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
              paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
              break label1001;
            }
          }
          i1 = 0;
        }
        label1001:
        if (!TextUtils.isEmpty(paramBitmap))
        {
          paramTmViewHolder.h.setText(paramBitmap);
          TroopRankConfig.a(paramTmViewHolder.h, i1);
        }
        else
        {
          paramTmViewHolder.h.setVisibility(8);
        }
      }
      else
      {
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        boolean bool2;
        if (paramBitmap != null) {
          bool2 = paramBitmap.isQidianPrivateTroop();
        } else {
          bool2 = false;
        }
        if ((!bool2) && (!this.jdField_e_of_type_Boolean))
        {
          localObject = TroopRankConfig.a().a(paramATroopMember.jdField_b_of_type_Int, bool3, paramBoolean1, bool1);
          if (localObject != null)
          {
            paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
            i1 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
            if (((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_Int == 302) {
              paramBitmap = paramATroopMember.jdField_u_of_type_JavaLangString;
            }
            if (((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_Int == 315) {
              paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_d_of_type_Int));
            }
          }
          else if (paramATroopMember.jdField_b_of_type_Int == 315)
          {
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_d_of_type_Int));
            i1 = Color.parseColor("#8EBDF9");
          }
          else
          {
            paramBitmap = "";
            i1 = 0;
          }
        }
        else
        {
          localObject = TroopRankConfig.a().a(paramBoolean1, bool1);
          if (localObject != null)
          {
            paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
            i1 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
          }
          else
          {
            paramBitmap = "";
            i1 = 0;
          }
        }
        if (this.jdField_d_of_type_Int == 11) {
          paramBitmap = "";
        }
        if ((SimpleUIUtil.a()) && (paramBoolean1))
        {
          localObject = String.format(getString(2131689491), new Object[0]);
        }
        else
        {
          localObject = paramBitmap;
          if (SimpleUIUtil.a())
          {
            localObject = paramBitmap;
            if (bool1) {
              localObject = String.format(getString(2131689490), new Object[0]);
            }
          }
        }
        if ((SimpleUIUtil.a()) && (!bool1) && (!paramBoolean1)) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!a()) && (i2 == 0))
        {
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          TroopRankConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, i1);
        }
        else
        {
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_e_of_type_Boolean)
        {
          paramBitmap = TroopRankConfig.a().a(paramATroopMember.jdField_b_of_type_Int, false, false, false);
          if ((paramBitmap != null) && (((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramATroopMember.jdField_b_of_type_Int)))
          {
            if (!TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString))
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
        i1 = this.jdField_d_of_type_Int;
        if ((i1 != 9) && (i1 != 12)) {
          if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            paramTmViewHolder.f.setText(getString(2131694384));
          } else {
            paramTmViewHolder.f.setText("");
          }
        }
      }
      paramBitmap = (ITroopRobotService)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      if ((paramBitmap != null) && (paramBitmap.isRobotUin(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if ((this.jdField_d_of_type_Int != 21) && ((paramBoolean1) || ((!bool4) && (bool1)) || ((!bool4) && (i1 != 0))))
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
        if (this.jdField_g_of_type_Boolean)
        {
          if ((!paramBoolean1) && ((bool4) || (!bool1)) && (!bool5)) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          if (i1 != 0)
          {
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840575);
              i1 = 1;
              break label1869;
            }
            paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840571);
          }
          i1 = 0;
        }
        else
        {
          label1869:
          if (this.jdField_d_of_type_Int != 20) {
            break label1941;
          }
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember))) {
            break label1928;
          }
          paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840575);
          i1 = 1;
        }
        break label2200;
        label1928:
        paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840571);
        break label1958;
        label1941:
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
      }
    }
    else
    {
      label1958:
      paramBitmap = paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(2131691790));
      ((StringBuilder)localObject).append(paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramBitmap.setContentDescription(((StringBuilder)localObject).toString());
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130850005);
      i1 = this.jdField_d_of_type_Int;
      if (i1 == 13)
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      else if (i1 == 21)
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      else if ((this.jdField_f_of_type_JavaLangString != null) && (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString)))
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
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131691775), new Object[] { paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramTmViewHolder.g.setContentDescription(getString(2131691774));
    }
    i1 = 0;
    label2200:
    int i2 = 1;
    if (paramTmViewHolder.jdField_d_of_type_AndroidViewView != null)
    {
      paramBitmap = (ITroopRobotService)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      if ((paramBitmap == null) || (!paramBitmap.isRobotUin(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        i2 = 0;
      }
      if (i2 != 0) {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      } else {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if (this.jdField_h_of_type_Boolean) {
      paramTmViewHolder.j.setVisibility(8);
    }
    paramBitmap = new StringBuffer();
    paramBitmap.append(paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
    if ((paramBoolean2) && (paramTmViewHolder.k != null)) {
      paramBitmap.append(paramTmViewHolder.k.getText());
    }
    if (paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
    }
    if (paramTmViewHolder.j.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.j.getText().toString());
    }
    if ((paramTmViewHolder.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_g_of_type_Boolean))
    {
      if (i1 != 0) {
        paramATroopMember = "已选中";
      } else {
        paramATroopMember = "未选中";
      }
      paramBitmap.append(paramATroopMember);
    }
    paramTmViewHolder.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new AllInOne(paramString1, 20);
        paramString1.pa = 20;
        paramString1.troopUin = this.jdField_b_of_type_JavaLangString;
        paramString1.troopCode = this.jdField_c_of_type_JavaLangString;
        paramString1.profileEntryType = 4;
        ProfileUtils.openProfileCard(getActivity(), paramString1);
        return;
      }
      paramString1 = new AllInOne(paramString1, 21);
      paramString1.pa = 21;
      paramString1.subSourceId = 11;
      paramString1.troopUin = this.jdField_b_of_type_JavaLangString;
      paramString1.troopCode = this.jdField_c_of_type_JavaLangString;
      paramString1.profileEntryType = 4;
      ProfileUtils.openProfileCard(getActivity(), paramString1);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
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
          localStringBuilder.append(this.jdField_d_of_type_Int);
          QLog.i("Q.history.BaseFragment", 2, localStringBuilder.toString());
          if (this.jdField_d_of_type_Int != 1)
          {
            if (this.jdField_d_of_type_Int == 11) {
              return;
            }
            if (this.jdField_d_of_type_Int == 9)
            {
              if (this.jdField_e_of_type_Int != 1) {
                break label246;
              }
              paramString2 = "suc_pay_list";
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, paramString3, "", "");
              return;
            }
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, paramString2, paramString3, "");
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
          QLog.i("Q.history.BaseFragment", 2, paramString2.toString());
        }
        return;
      }
      continue;
      label246:
      paramString2 = "un_pay_list";
    }
  }
  
  protected void a(String paramString, List<TroopMemberInfo> paramList)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Double = 0.0D;
        this.jdField_n_of_type_Int = -1;
        this.jdField_o_of_type_Int = 0;
      }
      finally
      {
        Object localObject;
        long l1;
        continue;
        throw paramString;
        continue;
        paramString = paramList;
        continue;
        continue;
        int i1 = 1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getTroopMemberFromDBIfNeeded, uin:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        if (paramList != null) {
          if (!paramList.isEmpty()) {
            continue;
          }
        }
        paramList = new ArrayList();
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
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
        l1 = System.currentTimeMillis();
        paramString = paramList;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getTroopMemberFromDB, queryTime:");
          paramString.append(l1 - this.jdField_d_of_type_Long);
          QLog.d("Q.history.BaseFragment", 2, paramString.toString());
          paramString = paramList;
        }
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          int i2 = paramString.size();
          this.jdField_o_of_type_Int = i2;
          int i3 = i2 / jdField_p_of_type_Int;
          if (i2 % jdField_p_of_type_Int != 0) {
            continue;
          }
          i1 = 0;
          this.jdField_n_of_type_Int = (i3 + i1);
          i1 = 0;
          if (i1 < i2)
          {
            ThreadManager.post(new ChatHistoryTroopMemberFragment.36(this, paramString, i1, Math.min(jdField_p_of_type_Int + i1 - 1, i2)), 8, null, true);
            i1 += jdField_p_of_type_Int;
            continue;
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("getTroopMemberFromDBIfNeeded, listSize:");
            paramString.append(i2);
            paramString.append("|mJobCount:");
            paramString.append(this.jdField_n_of_type_Int);
            QLog.d("Q.history.BaseFragment", 2, paramString.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
          }
          z();
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
          QLog.d("Q.history.BaseFragment", 2, paramList.toString());
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("getTroopMemberFromDBIfNeeded:");
          paramList.append(paramString.toString());
          QLog.d("Q.history.BaseFragment", 2, paramList.toString());
        }
      }
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      ChatHistoryTroopMemberFragment.ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
      if (localListAdapter == null) {
        return;
      }
      if (localListAdapter.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_c_of_type_Int > 16) {
        return;
      }
      int i3 = 1;
      int i2 = 0;
      int i1 = 0;
      while (i3 < paramArrayOfInt.length)
      {
        int i4 = paramArrayOfInt[i3] - paramArrayOfInt[(i3 - 1)] - 1;
        if (i4 > 0)
        {
          int i5 = i2 + this.jdField_j_of_type_Int;
          i2 = this.jdField_k_of_type_Int * i4 + i5;
          if (i2 > this.jdField_i_of_type_Int)
          {
            i2 = i4;
            do
            {
              i4 = i2 - 1;
              i3 = this.jdField_j_of_type_Int * i4 + i5;
              if (i3 <= this.jdField_i_of_type_Int) {
                break;
              }
              i2 = i4;
            } while (i4 > 0);
            i1 += i4;
            i2 = i3;
            break;
          }
          i1 += i4;
        }
        i3 += 1;
      }
      if (i2 + this.jdField_k_of_type_Int > this.jdField_i_of_type_Int) {
        this.jdField_l_of_type_Int = (i1 + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.BaseFragment", 2, String.format("updateMaxItemCount, max: %s", new Object[] { Integer.valueOf(this.jdField_l_of_type_Int) }));
      }
    }
  }
  
  protected Object[] a(String paramString)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      finally
      {
        Object localObject1;
        long l1;
        long l2;
        int i2;
        Object localObject2;
        continue;
        throw paramString;
        continue;
        i1 += 1;
        continue;
        int i1 = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getDiscussionMemberFromDB, uin:");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject1).toString());
        }
        l1 = System.currentTimeMillis();
        localObject1 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.jdField_c_of_type_JavaUtilList = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getDiscussionMemberFromDB, queryTime:");
          paramString.append(l2 - l1);
          QLog.d("Q.history.BaseFragment", 2, paramString.toString());
        }
        if (this.jdField_c_of_type_JavaUtilList == null) {
          continue;
        }
        i2 = this.jdField_c_of_type_JavaUtilList.size();
        i1 = 0;
        if (i1 < i2)
        {
          paramString = (DiscussionMemberInfo)this.jdField_c_of_type_JavaUtilList.get(i1);
          if (paramString == null) {
            continue;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.jdField_d_of_type_Int == 2) && (paramString.memberUin.equals(this.jdField_f_of_type_JavaLangString))) || ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))) {
              continue;
            }
            paramString = a(paramString, (FriendsManager)localObject1);
            this.jdField_a_of_type_JavaUtilList.add(paramString);
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getDiscussionMemberFromDB, continued:");
          ((StringBuilder)localObject2).append(paramString.memberUin);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
          continue;
        }
        i1 = i2;
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().notifyRefreshTroopMember();
          i1 = i2;
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getDiscussionMemberFromDB, TotalTime:");
          paramString.append(l2 - l1);
          paramString.append(", listSize:");
          paramString.append(this.jdField_a_of_type_JavaUtilList.size());
          paramString.append(", dbSize:");
          paramString.append(i1);
          QLog.d("Q.history.BaseFragment", 2, paramString.toString());
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
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
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getDiscussionMemberFromDB:");
          ((StringBuilder)localObject1).append(paramString.toString());
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    return null;
  }
  
  protected Object[] a(String paramString, List<String> paramList)
  {
    try
    {
      l1 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    }
    finally
    {
      long l1;
      ArrayList localArrayList;
      FriendsManager localFriendsManager;
      EntityManager localEntityManager;
      label139:
      for (;;)
      {
        label49:
        throw paramString;
      }
    }
    try
    {
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        List localList = localEntityManager.query(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, (String)paramList.next() }, null, null, null, null);
        if ((localList == null) || (localList.size() <= 0)) {
          break label49;
        }
        localArrayList.add(a((TroopMemberInfo)localList.get(0), localFriendsManager));
        break label49;
      }
    }
    catch (Exception paramString)
    {
      break label139;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("cost:");
      paramString.append(System.currentTimeMillis() - l1);
      QLog.d("Q.history.BaseFragment", 2, paramString.toString());
    }
    return new Object[] { localArrayList };
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeSearchItem:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_b_of_type_JavaUtilList.size())
        {
          ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localATroopMember == null) || (!localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
            continue;
          }
          this.jdField_b_of_type_JavaUtilList.remove(i1);
        }
        return;
      }
      finally
      {
        continue;
        throw paramString;
        continue;
        i1 += 1;
      }
    }
  }
  
  protected void d(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_AndroidViewView.getLayoutParams().height = -1;
    Object localObject;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ITroopRobotService localITroopRobotService;
    int i1;
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      paramString = paramString.toLowerCase();
      localObject = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localITroopRobotService = (ITroopRobotService)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((this.jdField_v_of_type_Boolean) && (localITroopRobotService.isRobotUin(localATroopMember.jdField_a_of_type_JavaLangString))) {
            break label1221;
          }
          localATroopMember.jdField_e_of_type_JavaLangString = "";
          localATroopMember.jdField_f_of_type_JavaLangString = "";
          if ((!paramString.equals(localATroopMember.m)) && (!paramString.equals(localATroopMember.jdField_o_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.n)))
          {
            if ((!paramString.equals(localATroopMember.jdField_j_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.jdField_l_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.jdField_k_of_type_JavaLangString)))
            {
              if ((!paramString.equals(localATroopMember.jdField_g_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.jdField_i_of_type_JavaLangString)) && (!paramString.equals(localATroopMember.jdField_h_of_type_JavaLangString)))
              {
                if (paramString.equals(localATroopMember.jdField_a_of_type_JavaLangString))
                {
                  if (!this.jdField_h_of_type_Boolean)
                  {
                    localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                    ((List)localObject).add(localATroopMember);
                  }
                }
                else if ((localATroopMember.m.indexOf(paramString) != 0) && (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.n.indexOf(paramString) != 0))
                {
                  if ((localATroopMember.jdField_j_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.jdField_l_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(paramString) != 0))
                  {
                    if ((localATroopMember.jdField_g_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.jdField_i_of_type_JavaLangString.indexOf(paramString) != 0) && (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(paramString) != 0))
                    {
                      if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
                      {
                        if (!this.jdField_h_of_type_Boolean)
                        {
                          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                          localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
                          localArrayList1.add(localATroopMember);
                        }
                      }
                      else if ((localATroopMember.m.indexOf(paramString) <= 0) && (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.n.indexOf(paramString) <= 0))
                      {
                        if ((localATroopMember.jdField_j_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.jdField_l_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(paramString) <= 0))
                        {
                          if ((localATroopMember.jdField_g_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.jdField_i_of_type_JavaLangString.indexOf(paramString) <= 0) && (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(paramString) <= 0))
                          {
                            if ((localATroopMember.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_h_of_type_Boolean))
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
            break label1221;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshSearchResultList:");
          localStringBuilder.append(localATroopMember.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(",");
          localStringBuilder.append(localATroopMember.jdField_e_of_type_JavaLangString);
          QLog.d("Q.history.BaseFragment", 2, localStringBuilder.toString());
          break label1221;
        }
        Collections.sort(localArrayList1, new ChatHistoryTroopMemberFragment.SearchResultComparator(this));
        this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        } else {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshSearchResultList:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(l2 - l1);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilList.size());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
          QLog.i("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
      return;
      label1221:
      i1 += 1;
    }
  }
  
  protected void e(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("kickOutDiscussionMember:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_AndroidAppDialog == null)
        {
          this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(getBaseActivity(), 2131756189);
          this.jdField_c_of_type_AndroidAppDialog.setContentView(2131558463);
          localObject = this.jdField_c_of_type_AndroidAppDialog;
          int i1 = this.jdField_d_of_type_Int;
          bool = true;
          if (i1 != 1)
          {
            ((Dialog)localObject).setCancelable(bool);
            ((TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(2131691773));
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(Long.parseLong(this.jdField_b_of_type_JavaLangString), Long.valueOf(paramString).longValue());
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
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  protected void f(String paramString)
  {
    if (((ITroopRobotService)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(getActivity(), this.jdField_c_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131719952));
    String str = this.jdField_k_of_type_JavaLangString;
    if ((str != null) && (!TextUtils.isEmpty(str))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131690706));
    }
    TroopMemberCardUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_c_of_type_JavaLangString, paramString, 1, 1, localBundle);
    this.w = paramString;
    a("Clk_item", this.jdField_o_of_type_JavaLangString, "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 == 2) {
        D();
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper.b();
    }
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562971, paramViewGroup, false);
    this.jdField_f_of_type_AndroidViewView = paramLayoutInflater;
    q();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_l_of_type_Boolean = true;
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper;
      if (localObject != null)
      {
        ((TroopMemberAddFrdHelper)localObject).c();
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper = null;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject = (QBaseActivity)getActivity();
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopFeeObserver);
        ((QBaseActivity)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopMessageObserver);
        label99:
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter;
        if (localObject != null) {
          ((ChatHistoryTroopMemberFragment.SearchResultAdapter)localObject).c();
        }
        super.g();
        localObject = this.jdField_c_of_type_AndroidAppDialog;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          this.jdField_c_of_type_AndroidAppDialog.dismiss();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
        if (localObject != null) {
          ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).c();
        }
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
        if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        localObject = this.jdField_d_of_type_AndroidAppDialog;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          this.jdField_d_of_type_AndroidAppDialog.dismiss();
        }
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label99;
      }
    }
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(0);
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a(paramString);
    if (i1 != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView;
      paramString.setSelection(i1 + paramString.getHeaderViewsCount());
    }
  }
  
  public void onIndexChanged(String paramString, int paramInt)
  {
    if ("$".equals(paramString))
    {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    else if ((this.jdField_d_of_type_Int == 11) && (paramInt == 0)) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause()
  {
    super.onPause();
    getBaseActivity().getWindow().setSoftInputMode(16);
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      getBaseActivity().getWindow().setSoftInputMode(48);
      label16:
      Object localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).destroyDrawingCache();
        this.jdField_b_of_type_AndroidViewView.requestLayout();
        this.jdField_b_of_type_AndroidViewView.invalidate();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper;
      if (localObject != null) {
        ((TroopMemberAddFrdHelper)localObject).a();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 7, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    paramView = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    paramView = getBaseActivity().getIntent().getExtras();
    this.jdField_c_of_type_JavaLangString = paramView.getString("uin");
    this.jdField_d_of_type_JavaLangString = paramView.getString("troop_info_name");
    this.jdField_e_of_type_JavaLangString = paramView.getString("troop_gift_from");
    this.jdField_i_of_type_JavaLangString = paramView.getString("leftViewText");
    int i3 = 0;
    this.jdField_m_of_type_Boolean = paramView.getBoolean("param_is_pop_up_style", false);
    this.jdField_d_of_type_Int = 18;
    this.jdField_j_of_type_JavaLangString = paramView.getString("param_troop_fee_project_id");
    this.jdField_e_of_type_Int = paramView.getInt("param_troop_fee_entrance_type", -1);
    this.jdField_t_of_type_JavaLangString = paramView.getString("callback");
    this.jdField_s_of_type_Boolean = paramView.getBoolean("param_troop_send_apollo_msg", false);
    this.jdField_o_of_type_Int = paramView.getInt("TROOP_INFO_MEMBER_NUM", 0);
    this.jdField_m_of_type_Int = paramView.getInt("sort_type", 0);
    this.jdField_f_of_type_Int = paramView.getInt("param_pick_max_num", this.jdField_f_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = paramView.getStringArrayList("param_pick_selected_list");
    this.jdField_e_of_type_JavaUtilList = paramView.getStringArrayList("param_delete_filter_member_list");
    this.jdField_f_of_type_JavaUtilList = paramView.getStringArrayList("param_hide_filter_member_list");
    this.jdField_h_of_type_Int = paramView.getInt("param_pick_max_num_exceeds_wording", 2131697587);
    this.jdField_l_of_type_JavaLangString = paramView.getString("param_pick_title_string", this.jdField_l_of_type_JavaLangString);
    this.jdField_v_of_type_Boolean = paramView.getBoolean("param_filter_robot", false);
    if (this.jdField_d_of_type_Int == 17) {
      new ReportTask(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_c_of_type_JavaLangString }).a();
    }
    if (this.jdField_d_of_type_Int == 22) {
      TroopReportor.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString });
    }
    if ((this.jdField_d_of_type_Int == 9) && (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) && (QLog.isColorLevel())) {
      QLog.e("Q.history.BaseFragment.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    if (this.jdField_d_of_type_Int == 14)
    {
      this.jdField_m_of_type_Int = 7;
      this.jdField_t_of_type_Boolean = false;
    }
    this.jdField_b_of_type_Int = paramView.getInt("param_chat_mode", 0);
    this.jdField_k_of_type_JavaLangString = paramView.getString("custom_title_name");
    paramBundle = paramView.getString("param_from");
    if (paramBundle != null) {
      try
      {
        this.jdField_d_of_type_Int = Integer.parseInt(paramBundle);
      }
      catch (NumberFormatException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate, troopCode=");
      paramBundle.append(this.jdField_c_of_type_JavaLangString);
      paramBundle.append(" troopUin=");
      paramBundle.append(this.jdField_b_of_type_JavaLangString);
      paramBundle.append(" from=");
      paramBundle.append(this.jdField_d_of_type_Int);
      QLog.d("Q.history.BaseFragment", 2, paramBundle.toString());
    }
    if (this.jdField_m_of_type_Boolean) {
      getBaseActivity().setTheme(2131755317);
    }
    paramBundle = (TroopManager)getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
    this.jdField_h_of_type_Boolean = paramBundle.m(this.jdField_c_of_type_JavaLangString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate, mIsQidianPrivateTroop = ");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Boolean);
      ((StringBuilder)localObject).append(", mTroopUin = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_o_of_type_Int == 0)
    {
      paramBundle = paramBundle.b(this.jdField_c_of_type_JavaLangString);
      if (paramBundle != null) {
        this.jdField_o_of_type_Int = paramBundle.wMemberNum;
      }
    }
    try
    {
      this.jdField_n_of_type_Boolean = ThemeUtil.isDefaultTheme();
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (this.jdField_d_of_type_Int == 15)
    {
      this.jdField_m_of_type_Int = 6;
      this.jdField_f_of_type_JavaUtilArrayList = paramView.getStringArrayList("param_seq_days");
      this.jdField_e_of_type_JavaUtilArrayList = paramView.getStringArrayList("param_seq_name");
    }
    int i1 = this.jdField_m_of_type_Int;
    if ((i1 == 1) || (i1 == 8)) {
      ((ITroopOnlineMemberHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER)).b(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    this.jdField_a_of_type_AndroidViewLayoutInflater = getBaseActivity().getLayoutInflater();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    paramView = (TroopManager)getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
    paramBundle = (DiscussionManager)getBaseActivity().app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if ((paramView != null) && (paramBundle != null))
    {
      i1 = this.jdField_d_of_type_Int;
      boolean bool;
      if ((i1 != 1) && (i1 != 11) && (i1 != 16))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramView.b(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin = this.jdField_c_of_type_JavaLangString;
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if ((paramView != null) && (paramView.isHomeworkTroop())) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_e_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, getBaseActivity().getCurrentAccountUin());
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if (paramView != null)
        {
          this.jdField_b_of_type_JavaLangString = paramView.troopcode;
          this.jdField_r_of_type_Boolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopPrivilegeFlag, 32);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.history.BaseFragment", 2, "doOnCreate, mTroopInfo is null");
          }
          getBaseActivity().finish();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramBundle.a(this.jdField_c_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if ((paramView != null) && (!paramView.isTroopOwner(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          getActivity().finish();
          return;
        }
      }
      paramView = (QBaseActivity)getActivity();
      i1 = this.jdField_d_of_type_Int;
      if ((i1 != 1) && (i1 != 11) && (i1 != 16))
      {
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver, true);
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver, true);
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver, true);
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver, true);
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopFeeObserver, true);
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopMessageObserver, true);
      }
      else
      {
        paramView.addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
      }
      if ((this.jdField_s_of_type_Boolean) && (this.jdField_d_of_type_Int == 3)) {
        this.jdField_m_of_type_Int = 2;
      }
      int i2;
      int i4;
      if (this.jdField_d_of_type_Int == 0)
      {
        paramView = getResources().getDisplayMetrics();
        i1 = Math.max(paramView.widthPixels, paramView.heightPixels);
        i2 = getBaseActivity().getTitleBarHeight();
        i4 = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
        int i5 = (int)(this.jdField_a_of_type_Float * 60.0F);
        this.jdField_j_of_type_Int = getResources().getDimensionPixelSize(2131299245);
        this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131296768);
        if (this.jdField_k_of_type_Int == 0) {
          this.jdField_k_of_type_Int = ((int)(paramView.density * 58.0F));
        }
        this.jdField_i_of_type_Int = (i1 - i2 - i4 - i5);
        this.jdField_l_of_type_Int = ((this.jdField_i_of_type_Int - this.jdField_j_of_type_Int) / this.jdField_k_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper = new TroopMemberAddFrdHelper(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener, getBaseActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.i("Q.history.BaseFragment", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_i_of_type_Int), Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(this.jdField_k_of_type_Int), Integer.valueOf(this.jdField_l_of_type_Int) }));
        }
      }
      i1 = this.jdField_d_of_type_Int;
      if (i1 != 1)
      {
        if (i1 == 11)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
          if (paramView != null)
          {
            this.jdField_f_of_type_JavaLangString = paramView.ownerUin;
            paramView = this.jdField_f_of_type_JavaLangString;
            if ((paramView != null) && (paramView.equals(getBaseActivity().app.getCurrentAccountUin()))) {
              bool = true;
            } else {
              bool = false;
            }
            this.jdField_d_of_type_Boolean = bool;
          }
          ReportController.b(getBaseActivity().app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_f_of_type_Boolean = false;
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          if (paramView != null)
          {
            if (paramView.troopowneruin != null) {
              this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) {
              this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin.equals(getBaseActivity().app.getCurrentAccountUin())))
            {
              paramView = this.jdField_g_of_type_JavaLangString;
              if ((paramView == null) || (!paramView.contains(getBaseActivity().app.getCurrentAccountUin()))) {}
            }
            else
            {
              bool = true;
              break label1657;
            }
            bool = false;
            label1657:
            this.jdField_d_of_type_Boolean = bool;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mTroopInfo==null");
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("doOnCreate, mTroopInfo admin: ");
            paramView.append(this.jdField_g_of_type_JavaLangString);
            paramView.append("  owner:");
            paramView.append(this.jdField_f_of_type_JavaLangString);
            QLog.d("Q.history.BaseFragment", 2, paramView.toString());
          }
        }
      }
      else
      {
        this.jdField_f_of_type_Boolean = true;
        this.jdField_u_of_type_JavaLangString = "";
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
        if (paramView != null) {
          this.jdField_f_of_type_JavaLangString = paramView.ownerUin;
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mDiscussionInfo==null");
        }
        paramView = this.jdField_f_of_type_JavaLangString;
        if ((paramView != null) && (paramView.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          this.jdField_d_of_type_Boolean = true;
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("doOnCreate, mDiscussionInfo owner: ");
          paramView.append(this.jdField_f_of_type_JavaLangString);
          QLog.d("Q.history.BaseFragment", 2, paramView.toString());
        }
      }
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_f_of_type_Boolean = true;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if ((paramView != null) && (paramView.isKingBattleTroop())) {
        this.jdField_q_of_type_Boolean = true;
      }
      paramView = getResources().getStringArray(2130968684);
      if (!this.jdField_q_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramView;
      }
      else
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[paramView.length + 1];
        i4 = paramView.length;
        i2 = 0;
        i1 = 0;
        while (i2 < i4)
        {
          paramBundle = paramView[i2];
          this.jdField_a_of_type_ArrayOfJavaLangString[i1] = paramBundle;
          i2 += 1;
          i1 += 1;
        }
        this.jdField_a_of_type_ArrayOfJavaLangString[i1] = getResources().getString(2131720021);
      }
      paramView = getResources().getStringArray(2130968683);
      if (!this.jdField_q_of_type_Boolean)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = paramView;
      }
      else
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = new String[paramView.length + 1];
        i4 = paramView.length;
        i1 = 0;
        i2 = i3;
        while (i2 < i4)
        {
          paramBundle = paramView[i2];
          this.jdField_b_of_type_ArrayOfJavaLangString[i1] = paramBundle;
          i2 += 1;
          i1 += 1;
        }
        this.jdField_b_of_type_ArrayOfJavaLangString[i1] = getResources().getString(2131720022);
      }
      r();
      t();
      u();
      a();
      i1 = this.jdField_d_of_type_Int;
      paramBundle = "1";
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              paramView = "4";
            } else {
              paramView = "1";
            }
          }
          else {
            paramView = "2";
          }
        }
        else {
          paramView = "3";
        }
      }
      else {
        paramView = "0";
      }
      localObject = this.jdField_f_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equals(getBaseActivity().app.getCurrentAccountUin())))
      {
        paramBundle = "0";
      }
      else
      {
        localObject = this.jdField_g_of_type_JavaLangString;
        if ((localObject == null) || (!((String)localObject).contains(getBaseActivity().app.getCurrentAccountUin()))) {
          paramBundle = "2";
        }
      }
      this.jdField_o_of_type_JavaLangString = paramBundle;
      a("exp", paramView, paramBundle);
      if (this.jdField_d_of_type_Int == 14) {
        C();
      }
      if (this.jdField_d_of_type_Int == 18) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_d_of_type_Int == 3) {
        ((ITroopRobotHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(this.jdField_c_of_type_JavaLangString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    getBaseActivity().finish();
  }
  
  protected void q()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131379303));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_b_of_type_AndroidViewView = a(2131378803);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131369249));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131369195));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364412));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131369202));
    int i1 = this.jdField_d_of_type_Int;
    if ((i1 == 3) || (i1 == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131369204));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369216));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)a(2131379297));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)a(2131368761));
    this.jdField_e_of_type_AndroidViewView = a(2131376345);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370156));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370368));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368260));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131370395));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697523));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369217));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844003);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131719799));
  }
  
  protected void r()
  {
    int i1 = this.jdField_d_of_type_Int;
    if (i1 == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691787));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692486));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691789));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    else if (i1 == 2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689656));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.6(this));
    }
    else if (i1 == 3)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696491));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690728);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.7(this));
    }
    else if (i1 == 11)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696493));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690728);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.8(this));
    }
    else if (i1 == 5)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696312));
      if (this.jdField_i_of_type_JavaLangString == null) {
        this.jdField_i_of_type_JavaLangString = getString(2131690706);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
    }
    else if ((i1 != 14) && (i1 != 16))
    {
      if (i1 == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719964);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691859);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else if ((i1 != 12) && (i1 != 20) && (i1 != 21))
      {
        if (i1 == 18)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719800);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else if (i1 == 19)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701854));
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.9(this));
        }
        else if (i1 == 23)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719800);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701847));
          localObject = this.jdField_k_of_type_JavaLangString;
          if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
          }
          if (this.jdField_i_of_type_JavaLangString == null) {
            this.jdField_i_of_type_JavaLangString = getString(2131690706);
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692486);
          if (this.jdField_d_of_type_Int != 4)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697523));
            if (this.jdField_d_of_type_Int != 22) {
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
      else
      {
        localObject = this.jdField_l_of_type_JavaLangString;
        if (localObject != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692486));
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691789));
        }
      }
    }
    else
    {
      localObject = this.jdField_k_of_type_JavaLangString;
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697284);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = this.jdField_m_of_type_Int;
      if (i1 >= 0)
      {
        localObject = this.jdField_b_of_type_ArrayOfJavaLangString;
        if (i1 < localObject.length) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(localObject[i1]);
        }
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_m_of_type_Int == 8)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701840));
    }
    if (this.jdField_d_of_type_Int == 14) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    localStringBuilder.append(this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
    ((LinearLayout)localObject).setContentDescription(localStringBuilder.toString());
  }
  
  protected void s()
  {
    int i1 = this.jdField_d_of_type_Int;
    if ((i1 == 2) || (i1 == 3) || (i1 == 11) || (i1 == 0) || (i1 == 17) || (i1 == 5) || (i1 == 9) || (i1 == 22))
    {
      if ((this.jdField_d_of_type_Int == 9) && (this.jdField_e_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ChatHistoryTroopMemberFragment.12(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ChatHistoryTroopMemberFragment.13(this));
    }
    i1 = this.jdField_d_of_type_Int;
    if ((i1 != 0) && (i1 != 9) && (i1 != 17) && (i1 != 22))
    {
      if (i1 == 7)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else if ((i1 != 12) && (i1 != 20))
      {
        if (i1 == 21) {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.16(this));
        } else if (i1 == 22) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.15(this));
      }
    }
    else {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.14(this));
    }
    if ((this.jdField_h_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if ((localTroopInfo == null) || (!localTroopInfo.mMemberInvitingFlag) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption == 3)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  protected void t()
  {
    View localView = getBaseActivity().getLayoutInflater().inflate(2131562980, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377019));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362652));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (ThemeUtil.isDefaultTheme()) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839393);
    } else {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839390);
    }
    Object localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379778);
    this.jdField_g_of_type_Int = ((LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin;
    if ((this.jdField_d_of_type_Int == 3) && (this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int != 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((this.jdField_d_of_type_Int == 11) && (this.jdField_d_of_type_Boolean)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    Object localObject2;
    if ((i1 != 0) || (i2 != 0))
    {
      localObject2 = getString(2131719953);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376387);
      ((TextView)localObject1).setText("");
      ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369373)).setBackgroundDrawable(ImageUtil.a());
      Object localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373313);
      ((ImageView)localObject3).setVisibility(8);
      if (i1 != 0)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setOnClickListener(new ChatHistoryTroopMemberFragment.17(this));
        ((TextView)localObject1).setTextSize(12.0F);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ChatHistoryTroopMemberFragment.18(this, (String)localObject2));
      if (!this.jdField_s_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
      }
      localObject2 = (ITroopMessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MESSAGE_HANDLER);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(getBaseActivity(), 1, 2131694422, 0).b(getBaseActivity().getTitleBarHeight());
      }
      else
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
        if ((localObject3 != null) && (this.jdField_d_of_type_Int == 11)) {
          ((DiscussionHandler)localObject3).b(getBaseActivity().app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        } else if (localObject2 != null) {
          ((ITroopMessageHandler)localObject2).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    if ((this.jdField_d_of_type_Int == 3) && (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int != 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((this.jdField_d_of_type_Int == 11) && (!this.jdField_d_of_type_Boolean)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && ((i1 != 0) || (i2 != 0)))
    {
      localObject1 = (ITroopMessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MESSAGE_HANDLER);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(getBaseActivity(), 1, 2131694422, 0).b(getBaseActivity().getTitleBarHeight());
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
        if ((localObject2 != null) && (this.jdField_d_of_type_Int == 11)) {
          ((DiscussionHandler)localObject2).b(getBaseActivity().app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        } else if (localObject1 != null) {
          ((ITroopMessageHandler)localObject1).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString);
        }
      }
    }
    localObject1 = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868)).setVisibility(8);
    int i1 = this.jdField_d_of_type_Int;
    if (i1 == 19)
    {
      localView = getBaseActivity().getLayoutInflater().inflate(2131562972, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new ChatHistoryTroopMemberFragment.19(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    else if ((i1 != 9) && (i1 != 15))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter = new ChatHistoryTroopMemberFragment.ListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter);
    i1 = this.jdField_d_of_type_Int;
    if ((i1 == 19) || (i1 == 21)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    i1 = this.jdField_d_of_type_Int;
    if ((i1 != 9) && (i1 != 19)) {
      I();
    }
    ((EditText)localObject1).setOnTouchListener(new ChatHistoryTroopMemberFragment.20(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    if (this.jdField_d_of_type_Int == 11) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
    }
  }
  
  protected void u()
  {
    K();
    int i1 = this.jdField_d_of_type_Int;
    if (i1 == 9)
    {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.26(this), 8, null, true);
      return;
    }
    Object localObject1;
    if ((i1 != 15) && (i1 != 1) && (i1 != 11) && (i1 != 16))
    {
      localObject1 = this.jdField_b_of_type_AndroidOsHandler;
      ((Handler)localObject1).sendMessage(((Handler)localObject1).obtainMessage(13));
      localObject1 = null;
    }
    else
    {
      localObject1 = new ChatHistoryTroopMemberFragment.27(this);
    }
    i1 = this.jdField_d_of_type_Int;
    Object localObject4;
    long l1;
    long l2;
    if ((i1 != 11) && (i1 != 1) && (i1 != 16) && (NetworkUtil.isNetworkAvailable(getActivity())))
    {
      Object localObject2 = getActivity();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("last_update_time");
      ((StringBuilder)localObject4).append(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((FragmentActivity)localObject2).getSharedPreferences(((StringBuilder)localObject4).toString(), 4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_time");
      ((StringBuilder)localObject4).append(this.jdField_c_of_type_JavaLangString);
      l1 = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject4).toString(), 0L);
      l2 = Math.abs(System.currentTimeMillis() - l1);
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localObject4 != null) {
        i1 = ((TroopInfo)localObject4).wMemberNum;
      } else {
        i1 = 0;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_num");
      ((StringBuilder)localObject4).append(this.jdField_c_of_type_JavaLangString);
      int i2 = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject4).toString(), 0);
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_num");
      ((StringBuilder)localObject4).append(this.jdField_c_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject4).toString(), i1).commit();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fillData, lastUpdateTime:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" timeDiff:");
        ((StringBuilder)localObject2).append(l2 / 1000L / 60L);
        ((StringBuilder)localObject2).append(" min  curMemberNum:");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(" lastUpdateMemberNum:");
        ((StringBuilder)localObject2).append(i2);
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (ITroopMemberListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      if (localObject2 != null)
      {
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, d(), this.jdField_a_of_type_Long, 0);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("fillData, ITroopMemberListHandler.getTroopMemberList(), troopUin: ");
          ((StringBuilder)localObject4).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject4).append(" troopCode: ");
          ((StringBuilder)localObject4).append(this.jdField_c_of_type_JavaLangString);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject4).toString());
        }
      }
      if (localObject2 != null) {
        try
        {
          ((ITroopMemberListHandler)localObject2).a(Long.parseLong(this.jdField_c_of_type_JavaLangString), 0L, 1, 0, 0);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.history.BaseFragment", 2, localException.toString());
          }
        }
      }
    }
    if (this.jdField_d_of_type_Int == 3)
    {
      Object localObject3 = getActivity();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("last_update_time");
      ((StringBuilder)localObject4).append(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject3 = ((FragmentActivity)localObject3).getSharedPreferences(((StringBuilder)localObject4).toString(), 4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_troop_info_last_update");
      ((StringBuilder)localObject4).append(this.jdField_c_of_type_JavaLangString);
      l1 = ((SharedPreferences)localObject3).getLong(((StringBuilder)localObject4).toString(), 0L);
      l2 = Math.abs(l1 - System.currentTimeMillis());
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("fillData, TroopInfo lastUpdateTime:");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(" timeDiff:");
        ((StringBuilder)localObject3).append(l2 / 1000L / 60L);
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject3).toString());
      }
      if (l2 > 60000L)
      {
        localObject3 = (ITroopInfoHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
        localObject4 = (ITroopMemberListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
        if ((localObject4 != null) && (localObject3 != null))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          ((ITroopInfoHandler)localObject3).a(this.jdField_c_of_type_JavaLangString);
          ((ITroopMemberListHandler)localObject4).a(1, TroopFileHandler.a(this.jdField_c_of_type_JavaLangString), 0L, 2, 0, 0, true);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("fillData, getGroupInfoReq, mTroopUin:");
            ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
            QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    if (localObject1 != null) {
      ThreadManager.post((Runnable)localObject1, 8, null, true);
    }
    if (this.jdField_d_of_type_Int == 14) {
      ((TroopGiftManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(this.jdField_c_of_type_JavaLangString, new ChatHistoryTroopMemberFragment.28(this));
    }
  }
  
  protected void v()
  {
    String[] arrayOfString;
    if (this.jdField_d_of_type_Int == 9) {
      arrayOfString = getResources().getStringArray(2130968678);
    } else {
      arrayOfString = getResources().getStringArray(2130968676);
    }
    int i1 = this.jdField_d_of_type_Int;
    if ((i1 != 0) && (i1 != 17) && (i1 != 22))
    {
      if (i1 == 9) {
        i1 = arrayOfString.length;
      } else {
        i1 = arrayOfString.length - 5;
      }
    }
    else if (this.jdField_d_of_type_Boolean)
    {
      i1 = arrayOfString.length;
    }
    else
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if ((localTroopInfo != null) && (localTroopInfo.mMemberInvitingFlag))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption != 3)
        {
          i1 = arrayOfString.length - 1;
          break label142;
        }
        i1 = arrayOfString.length;
      }
      else
      {
        i1 = arrayOfString.length;
      }
      i1 -= 2;
    }
    label142:
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getBaseActivity());
    int i2 = 0;
    while (i2 < i1)
    {
      if (this.jdField_h_of_type_Boolean)
      {
        if ((!HardCodeUtil.a(2131701802).equals(arrayOfString[i2])) && (i2 == 2))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(arrayOfString[i2]);
          break;
        }
      }
      else if (i2 == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(arrayOfString[i2], 3);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(arrayOfString[i2]);
        if (arrayOfString[i2].equals(HardCodeUtil.a(2131701887))) {
          ReportController.b(getBaseActivity().app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
        }
      }
      i2 += 1;
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(arrayOfString[3], 3);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected void w()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) && (QLog.isColorLevel())) {
      QLog.d("Q.history.BaseFragment", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_Int) }));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.jdField_m_of_type_Int == 0)
    {
      int i2 = this.jdField_d_of_type_Int;
      ChatHistoryTroopMemberFragment.ListAdapter localListAdapter;
      if (i2 == 11)
      {
        localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
        if ((localListAdapter != null) && (localListAdapter.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        }
      }
      else if (i2 == 0)
      {
        localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
        if ((localListAdapter != null) && (localListAdapter.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_c_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else
      {
        localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter;
        if ((localListAdapter != null) && (localListAdapter.jdField_b_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    }
    if (i1 != this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility()) {
      H();
    }
  }
  
  protected void x()
  {
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(getBaseActivity(), 2131756189);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131558463);
      Dialog localDialog = this.jdField_c_of_type_AndroidAppDialog;
      int i1 = this.jdField_d_of_type_Int;
      boolean bool = true;
      if (i1 == 1) {
        bool = false;
      }
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(2131718766));
    }
  }
  
  protected void y()
  {
    if (this.jdField_d_of_type_Int == 11) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 7, 0, "", "", "", "");
    int i1 = this.jdField_b_of_type_AndroidViewView.getHeight();
    float f1 = -i1;
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new ChatHistoryTroopMemberFragment.31(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_d_of_type_AndroidAppDialog.setOnDismissListener(new ChatHistoryTroopMemberFragment.32(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131363868);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new ChatHistoryTroopMemberFragment.33(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
    this.jdField_k_of_type_Boolean = true;
  }
  
  void z()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(14);
    RelativeLayout localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment
 * JD-Core Version:    0.7.0.1
 */