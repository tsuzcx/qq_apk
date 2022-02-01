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
  protected static double bq = 10.0D;
  private static int cb = 1000;
  protected boolean A;
  protected boolean B;
  protected String C = "";
  protected String D = "";
  protected String E = "";
  protected boolean F = false;
  protected int G = 0;
  protected int H = 0;
  protected float I = 1.5F;
  public List<ChatHistoryTroopMemberFragment.ATroopMember> J = new ArrayList();
  protected ChatHistoryTroopMemberFragment.ListAdapter K = null;
  protected Dialog L;
  protected View M;
  protected TextView N;
  protected ImageView O;
  protected ImageView P;
  protected TextView Q;
  protected TextView R;
  protected LinearLayout S;
  protected TextView T;
  protected LinearLayout U;
  protected RelativeLayout V;
  protected EditText W;
  protected ImageButton X;
  protected RelativeLayout Y;
  protected View Z;
  protected String aA = null;
  protected int aB = -1;
  protected String aC = null;
  protected String aD;
  protected int aE = 2147483647;
  protected String aF;
  protected String aG;
  protected int aH = 0;
  protected long aI = 0L;
  protected long aJ = 0L;
  protected String aK = "2";
  protected String aL = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
  public final String aM = "param_seq_name";
  public final String aN = "param_seq_days";
  public final String aO = "param_deleted_uins";
  protected RelativeLayout aP;
  protected RelativeLayout aQ;
  protected ProgressBar aR;
  protected TextView aS;
  protected PopupMenuDialog aT;
  protected ArrayList<String> aU = new ArrayList();
  public int aV;
  public int aW = 0;
  public int aX = 0;
  public int aY = 0;
  public int aZ = 50;
  protected RelativeLayout aa;
  protected XListView ab;
  protected List<ChatHistoryTroopMemberFragment.ATroopMember> ac = new ArrayList();
  protected ChatHistoryTroopMemberFragment.SearchResultAdapter ad;
  protected View ae;
  protected IndexView af;
  protected Drawable ag;
  protected String ah;
  public TroopInfo ai;
  protected TroopInfoData aj = new TroopInfoData();
  protected DiscussionInfo ak;
  protected LayoutInflater al;
  protected ActionSheet am;
  protected View an;
  protected boolean ao = false;
  protected boolean ap = false;
  protected List<DiscussionMemberInfo> aq;
  protected DiscussionHandler ar;
  protected List<String> as = new ArrayList();
  protected List<String> at = new ArrayList();
  protected List<String> au = new ArrayList();
  protected ArrayList<String> av = new ArrayList();
  protected int aw = 0;
  protected boolean ax = false;
  protected boolean ay = false;
  public int az = 0;
  public TroopOnlineMemberObserver bA = new ChatHistoryTroopMemberFragment.46(this);
  protected String bB;
  private View bC;
  private boolean bD;
  private boolean bE;
  private boolean bF = false;
  private long bG = 0L;
  private List<oidb_cmd0x74f.Range> bH = new ArrayList();
  private ArrayList<String> bI = new ArrayList();
  private ArrayList<String> bJ = new ArrayList();
  private ArrayList<String> bK = new ArrayList();
  private ArrayList<String> bL = new ArrayList();
  private ArrayList<String> bM = new ArrayList();
  private String[] bN;
  private String[] bO;
  private DecimalFormat bP = new DecimalFormat("#.##");
  private long[] bQ;
  private long[] bR;
  private long[] bS;
  private boolean bT = true;
  private boolean bU = false;
  private String bV = HardCodeUtil.a(2131899873);
  private boolean bW = false;
  private Handler bX = new Handler(Looper.getMainLooper(), this);
  private int bY = -1;
  private long bZ = 0L;
  public TroopMemberAddFrdHelper ba = null;
  public boolean bb = true;
  protected QQAppInterface bc;
  protected View bd;
  TroopMemberAddFrdHelper.AddFrdHelperListener be = new ChatHistoryTroopMemberFragment.1(this);
  protected boolean bf = false;
  protected String bg = "";
  public View.OnClickListener bh = new ChatHistoryTroopMemberFragment.10(this);
  public View.OnClickListener bi = new ChatHistoryTroopMemberFragment.11(this);
  protected int bj = 0;
  protected boolean bk = true;
  protected ActionSheet.OnButtonClickListener bl = new ChatHistoryTroopMemberFragment.29(this);
  public Dialog bm;
  protected Handler bn = new ChatHistoryTroopMemberFragment.34(this);
  public View.OnClickListener bo = new ChatHistoryTroopMemberFragment.35(this);
  protected double bp = 0.0D;
  protected String br = "";
  protected String bs = "";
  public View.OnClickListener bt = new ChatHistoryTroopMemberFragment.37(this);
  public DiscussionObserver bu = new ChatHistoryTroopMemberFragment.40(this);
  public TroopObserver bv = new ChatHistoryTroopMemberFragment.41(this);
  public TroopRobotObserver bw = new ChatHistoryTroopMemberFragment.42(this);
  public TroopSettingObserver bx = new ChatHistoryTroopMemberFragment.43(this);
  public TroopFeeObserver by = new ChatHistoryTroopMemberFragment.44(this);
  public TroopMessageObserver bz = new ChatHistoryTroopMemberFragment.45(this);
  private int ca = 0;
  protected PinnedDividerSwipListView s;
  protected boolean t = false;
  boolean u = false;
  public String v = "";
  protected String w = "";
  protected String x = "";
  protected String y = "";
  protected boolean z;
  
  private void I()
  {
    if (this.aT == null)
    {
      ArrayList localArrayList = new ArrayList(this.bN.length);
      int i = 0;
      while (i < this.bN.length)
      {
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        String[] arrayOfString = this.bN;
        localMenuItem.title = arrayOfString[i];
        localMenuItem.id = i;
        localMenuItem.contentDescription = arrayOfString[i];
        localArrayList.add(localMenuItem);
        i += 1;
      }
      this.aT = PopupMenuDialog.build(getBaseActivity(), localArrayList, new ChatHistoryTroopMemberFragment.4(this), null, UIUtils.a(getBaseActivity(), 135.0F), false);
      this.aT.setTouchInterceptor(new ChatHistoryTroopMemberFragment.5(this));
      d(this.bj);
    }
    this.aT.showAsDropDown(this.P, -(UIUtils.a(getBaseActivity(), 135.0F) - this.P.getWidth()), 0);
  }
  
  private void J()
  {
    String str = this.D;
    if ((str == null) || (!str.contains(getBaseActivity().app.getCurrentAccountUin())))
    {
      str = this.C;
      if ((str == null) || (!str.equals(getBaseActivity().app.getCurrentAccountUin()))) {}
    }
    else
    {
      i = 1;
      break label59;
    }
    int i = 0;
    label59:
    if ((!this.B) && (i != 0))
    {
      i = this.az;
      if (((i == 0) || (i == 17)) && (System.currentTimeMillis() > this.bG)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.21(this), 8, null, true);
      }
    }
  }
  
  private void K()
  {
    if (this.bC != null) {
      return;
    }
    Object localObject1 = getBaseActivity().getLayoutInflater();
    Object localObject2 = this.s;
    int j = 0;
    this.bC = ((LayoutInflater)localObject1).inflate(2131629582, (ViewGroup)localObject2, false);
    localObject1 = (TextView)this.bC.findViewById(2131435663);
    localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
    Object localObject3 = this.bH.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (oidb_cmd0x74f.Range)((Iterator)localObject3).next();
      this.bJ.add(String.valueOf(((oidb_cmd0x74f.Range)localObject4).uint32_days.get()));
      this.bI.add(((oidb_cmd0x74f.Range)localObject4).string_name.get());
    }
    localObject3 = this.J.iterator();
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject3).next();
      if (((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).u == 0L) {
        ((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).u = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).s;
      }
      if (!TextUtils.isEmpty(a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject4).u, (Calendar)localObject2, this.bJ, this.bI))) {
        i += 1;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject1 = this.C;
    if ((localObject1 == null) || (!((String)localObject1).equals(getBaseActivity().app.getCurrentAccountUin()))) {
      j = 1;
    }
    this.bC.setOnClickListener(new ChatHistoryTroopMemberFragment.22(this, i, j));
    L();
    this.s.addHeaderView(this.bC);
    localObject1 = getBaseActivity().app;
    localObject2 = this.w;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(j);
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
  }
  
  private void L()
  {
    Object localObject = this.bC;
    if ((localObject != null) && (this.af != null))
    {
      localObject = ((View)localObject).findViewById(2131444799);
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
          if (this.af.getVisibility() == 0)
          {
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 26.0F));
            return;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 18.0F));
        }
      }
    }
  }
  
  private void M()
  {
    this.bm = new ReportDialog(getBaseActivity());
    this.bm.setCanceledOnTouchOutside(true);
    this.bm.requestWindowFeature(1);
    this.bm.getWindow().setSoftInputMode(36);
    this.bm.setContentView(2131629224);
    Object localObject = this.bm.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.bm.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getBaseActivity().getSystemService("input_method");
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT < 24))
    {
      this.bm.getWindow().addFlags(67108864);
      int i = getResources().getColor(2131168092);
      new SystemBarCompact(this.bm, true, i).init();
      View localView = this.bm.findViewById(2131445137);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
    }
    this.ab = ((XListView)this.bm.findViewById(2131445380));
    this.ab.setBackgroundDrawable(getResources().getDrawable(2130838958));
    this.ab.setDividerHeight(0);
    this.ac.clear();
    this.ad = new ChatHistoryTroopMemberFragment.SearchResultAdapter(this, this.ac);
    this.ab.setAdapter(this.ad);
    this.ab.setOnTouchListener(new ChatHistoryTroopMemberFragment.23(this, (InputMethodManager)localObject));
    this.W = ((EditText)this.bm.findViewById(2131432634));
    this.W.addTextChangedListener(new ChatHistoryTroopMemberFragment.SearchTextWatcher(this));
    this.ae = this.bm.findViewById(2131445137);
    this.X = ((ImageButton)this.bm.findViewById(2131435215));
    this.Z = this.bm.findViewById(2131439366);
    this.aa = ((RelativeLayout)this.bm.findViewById(2131444724));
    this.X.setOnClickListener(new ChatHistoryTroopMemberFragment.24(this));
    this.aa.setOnClickListener(new ChatHistoryTroopMemberFragment.25(this));
  }
  
  private void N()
  {
    int i = this.K.e.size();
    if (i > 0)
    {
      String str = MessageFormat.format(HardCodeUtil.a(2131899848), new Object[] { Integer.valueOf(i) });
      this.N.setEnabled(true);
      this.N.setText(str);
      this.N.setOnClickListener(new ChatHistoryTroopMemberFragment.30(this));
      return;
    }
    this.N.setEnabled(false);
    this.N.setText(HardCodeUtil.a(2131899860));
  }
  
  private boolean O()
  {
    int i = this.az;
    boolean bool2 = false;
    if ((i != 3) && (i != 2) && (i != 14)) {
      i = 0;
    } else {
      i = 1;
    }
    TroopInfo localTroopInfo = this.ai;
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
  
  private void P()
  {
    this.aQ.setVisibility(8);
    a(0, this.ca, 0);
    this.bn.sendEmptyMessageDelayed(14, 800L);
  }
  
  private int Q()
  {
    int i;
    if (this.az != 3) {
      i = 1;
    } else {
      i = 2;
    }
    if (this.bF) {
      i = 3;
    }
    return i;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.az;
    if ((i != 20) && (i != 21)) {
      this.aS.setText(String.format(HardCodeUtil.a(2131899839), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    } else {
      this.aS.setText(String.format(HardCodeUtil.a(2131899870), new Object[] { Integer.valueOf(paramInt3) }));
    }
    this.aR.setProgress(paramInt3);
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Object localObject = this.aP;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0)) {
      this.aP.setVisibility(8);
    }
    if (this.aQ.getVisibility() == 8) {
      this.aQ.setVisibility(0);
    }
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 3))
    {
      localObject = this.K;
      ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).a = ((LinkedHashMap)paramMessage[0]);
      ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).b = ((int[])paramMessage[1]);
      ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).c = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.J.size()) });
    }
    else if ((paramMessage != null) && (paramMessage.length == 1))
    {
      try
      {
        this.J.clear();
        this.J.addAll((List)paramMessage[0]);
        QLog.d(".troop.troopManagerVASH", 2, new Object[] { "refreshUI List count: ", Integer.valueOf(this.J.size()) });
      }
      finally {}
    }
    if (this.J.size() != 0)
    {
      J();
      A();
      paramMessage = this.K;
      if (paramMessage != null)
      {
        paramMessage.notifyDataSetChanged();
        this.K.c();
      }
      else
      {
        this.K = new ChatHistoryTroopMemberFragment.ListAdapter(this);
        this.s.setAdapter(this.K);
      }
      this.s.setVisibility(0);
    }
    if ((!this.ao) || (this.az == 11)) {
      D();
    }
    w();
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
    ReportDialog localReportDialog = new ReportDialog(getBaseActivity(), 2131953338);
    localReportDialog.setContentView(2131624755);
    ((TextView)localReportDialog.findViewById(2131431880)).setText(getString(2131888462));
    TextView localTextView = (TextView)localReportDialog.findViewById(2131431876);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131430666);
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
    if ((!this.t) && (this.aj.allowMemberKick == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramList.size() == 1)
    {
      localTextView.setText(getString(2131891097));
      localCheckBox.setText(getString(2131915655));
    }
    else
    {
      localTextView.setText(getString(2131892022));
      localCheckBox.setText(getString(2131892025));
    }
    if (bool) {
      localCheckBox.setVisibility(8);
    }
    localTextView = (TextView)localReportDialog.findViewById(2131431864);
    Object localObject = (TextView)localReportDialog.findViewById(2131431870);
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
    FriendsManager localFriendsManager = (FriendsManager)this.bc.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.bc.getRuntimeService(ITroopRobotService.class, "all");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i);
      if (localTroopMemberInfo != null)
      {
        Object localObject2;
        if (Utils.e(localTroopMemberInfo.memberuin))
        {
          if ((this.az != 2) || ((!localTroopMemberInfo.memberuin.equals(this.C)) && (!this.D.contains(localTroopMemberInfo.memberuin))))
          {
            localObject2 = this.au;
            if (((localObject2 == null) || (!((List)localObject2).contains(localTroopMemberInfo.memberuin))) && ((this.az != 20) || (!localITroopRobotService.isRobotUin(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000"))) {
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
      i += 1;
    }
    paramList = this.bn.obtainMessage(12, localObject1);
    paramList.arg1 = paramInt;
    this.bn.sendMessage(paramList);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i = this.az;
    boolean bool = false;
    if ((i == 3) && (!this.t) && (this.H != 1)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2;
    Object localObject3;
    if ((!this.t) && (paramBoolean3))
    {
      localObject1 = this.Y;
      if (localObject1 != null)
      {
        localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131448598);
        localObject1 = getString(2131917558);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.Y.findViewById(2131444603);
        ((TextView)localObject2).setText("");
        ((ImageView)this.Y.findViewById(2131436404)).setBackgroundDrawable(ImageUtil.b());
        localObject3 = (ImageView)this.Y.findViewById(2131440982);
        ((ImageView)localObject3).setVisibility(8);
        if (i != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new ChatHistoryTroopMemberFragment.47(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.Y.setOnClickListener(new ChatHistoryTroopMemberFragment.48(this, (String)localObject1));
        if (!this.bF)
        {
          this.Y.setVisibility(0);
          this.Y.setEnabled(false);
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
    if (this.Y != null)
    {
      localObject1 = this.ag;
      if (localObject1 != null)
      {
        ((Animatable)localObject1).stop();
        this.ag = null;
        ((TextView)this.Y.findViewById(2131444603)).setCompoundDrawables(null, null, null, null);
      }
    }
    Object localObject1 = this.Y;
    if ((localObject1 != null) && (((RelativeLayout)localObject1).getVisibility() != 8))
    {
      this.Y.setEnabled(true);
      if (paramBoolean1)
      {
        if (paramString1 == null) {
          return;
        }
        ((TextView)this.Y.findViewById(2131448598)).setTextColor(getResources().getColor(2131167993));
        localObject1 = (TextView)this.Y.findViewById(2131444603);
        localObject2 = HardCodeUtil.a(2131899833);
        localObject3 = (Button)this.Y.findViewById(2131439589);
        ((Button)localObject3).setVisibility(8);
        ((Button)localObject3).setOnClickListener(new ChatHistoryTroopMemberFragment.49(this));
        i = ((ISVIPHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).j();
        if (this.az == 11)
        {
          if (!paramString1.equals(this.v)) {
            return;
          }
          this.G = paramInt2;
          paramBoolean1 = bool;
          if (paramBoolean2)
          {
            paramBoolean1 = bool;
            if (paramInt1 > 0) {
              paramBoolean1 = true;
            }
          }
          this.F = paramBoolean1;
          if (this.F)
          {
            paramString1 = new StringBuilder();
            paramString1.append(HardCodeUtil.a(2131899880));
            paramString1.append(paramInt1);
            paramString1.append(HardCodeUtil.a(2131899897));
            this.E = paramString1.toString();
            ((TextView)localObject1).setText(this.E);
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",");
            paramString1.append(this.E);
            paramString1 = paramString1.toString();
          }
          else if (paramInt1 == 0)
          {
            this.E = HardCodeUtil.a(2131899887);
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",剩余0次");
            paramString1 = paramString1.toString();
            ((TextView)localObject1).setText("剩余0次");
          }
          else
          {
            this.E = "";
            paramString1 = new StringBuilder();
            paramString1.append((String)localObject2);
            paramString1.append(",");
            paramString1.append(HardCodeUtil.a(2131899878));
            paramString1 = paramString1.toString();
            ((TextView)localObject1).setText("");
          }
          paramString2 = paramString1;
          if (this.af.getVisibility() == 0)
          {
            paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
            paramString2.rightMargin = AIOUtils.b(20.0F, getResources());
            ((TextView)localObject1).setLayoutParams(paramString2);
            paramString2 = paramString1;
          }
        }
        else
        {
          if (!paramString1.equals(this.w)) {
            return;
          }
          this.F = paramBoolean2;
          this.E = paramString3;
          if (TextUtils.isEmpty(paramString2))
          {
            QLog.e("Q.history.BaseFragment", 1, "updateUIForAtAllRemainedCount remainTips empty");
            return;
          }
          if ((!this.F) && (i != 3))
          {
            ((Button)localObject3).setVisibility(0);
            paramString1 = new StringBuilder();
            paramString1.append(paramString2);
            paramString1.append(",\n超级会员可继续使用");
            paramString2 = paramString1.toString();
            ((TextView)localObject1).setGravity(21);
            ((TextView)localObject1).setLineSpacing(this.I * 5.0F, 1.0F);
            paramInt1 = (int)(HardCodeUtil.a(2131899904).length() * 12 * this.I);
            new DisplayMetrics();
            float f1 = getResources().getDisplayMetrics().widthPixels;
            float f2 = this.I;
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
          if (paramString1.contains(HardCodeUtil.a(2131899888)))
          {
            paramInt1 = paramString1.indexOf(HardCodeUtil.a(2131899825));
            paramInt2 = HardCodeUtil.a(2131899901).length();
            paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
          }
          ((TextView)localObject1).setText(paramString2);
          paramString2 = new StringBuilder();
          paramString2.append((String)localObject2);
          paramString2.append(",");
          paramString2.append(paramString1);
          paramString2 = paramString2.toString();
        }
        this.Y.setContentDescription(paramString2);
      }
    }
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
          QLog.d("Q.history.BaseFragment", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
        }
        return;
      }
      paramInt -= i;
      if (paramInt > 0) {
        paramTextView.setMaxWidth(paramInt);
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(" nTargetMaxWidth:");
        paramQQAppInterface.append(paramInt);
        QLog.d("Q.history.BaseFragment", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private View c(int paramInt)
  {
    return this.bd.findViewById(paramInt);
  }
  
  private void d(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.aT.getContentView().findViewById(2131431322);
    int i = 0;
    while (i < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i);
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)((View)localObject).getTag();
      if (localMenuItem != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131447262);
        if (localObject != null) {
          if (localMenuItem.id == paramInt) {
            ((TextView)localObject).setTextColor(getResources().getColor(2131168007));
          } else {
            ((TextView)localObject).setTextColor(getResources().getColor(2131167993));
          }
        }
      }
      i += 1;
    }
  }
  
  protected void A()
  {
    if ((this.K != null) && (QLog.isColorLevel())) {
      QLog.d("Q.history.BaseFragment", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.K.i), Integer.valueOf(this.K.j), Integer.valueOf(this.K.h) }));
    }
    int i = this.af.getVisibility();
    if (this.bj == 0)
    {
      int j = this.az;
      ChatHistoryTroopMemberFragment.ListAdapter localListAdapter;
      if (j == 11)
      {
        localListAdapter = this.K;
        if ((localListAdapter != null) && (localListAdapter.i > 6) && (this.K.h > 1)) {
          this.af.setVisibility(0);
        }
      }
      else if (j == 0)
      {
        localListAdapter = this.K;
        if ((localListAdapter != null) && (localListAdapter.i + this.K.j >= this.aZ) && (this.K.h > 1)) {
          this.af.setVisibility(0);
        } else {
          this.af.setVisibility(4);
        }
      }
      else
      {
        localListAdapter = this.K;
        if ((localListAdapter != null) && (localListAdapter.i >= this.aZ) && (this.K.h > 1)) {
          this.af.setVisibility(0);
        } else {
          this.af.setVisibility(4);
        }
      }
    }
    else
    {
      this.af.setVisibility(4);
    }
    if (i != this.af.getVisibility()) {
      L();
    }
  }
  
  protected void B()
  {
    if (this.L == null)
    {
      this.L = new ReportDialog(getBaseActivity(), 2131953338);
      this.L.setContentView(2131623999);
      Dialog localDialog = this.L;
      int i = this.az;
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      localDialog.setCancelable(bool);
      ((TextView)this.L.findViewById(2131431876)).setText(getString(2131916272));
    }
  }
  
  protected void C()
  {
    if (this.az == 11) {
      ReportController.b(this.bc, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 7, 0, "", "", "", "");
    int i = this.M.getHeight();
    float f = -i;
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.U.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new ChatHistoryTroopMemberFragment.31(this, (TranslateAnimation)localObject, localTranslateAnimation, i));
    this.bm.setOnDismissListener(new ChatHistoryTroopMemberFragment.32(this));
    this.W.setText("");
    this.W.setSelection(0);
    this.W.requestFocus();
    localObject = (Button)this.bm.findViewById(2131429816);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new ChatHistoryTroopMemberFragment.33(this));
    this.ac.clear();
    this.ad.notifyDataSetChanged();
    this.ap = true;
  }
  
  void D()
  {
    this.bn.removeMessages(14);
    RelativeLayout localRelativeLayout = this.aP;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0)) {
      this.aP.setVisibility(8);
    }
  }
  
  protected void E()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=");
    ((StringBuilder)localObject1).append(this.w);
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
    a("Clk_mberdist", this.aK, "");
  }
  
  protected void F()
  {
    ThreadManager.post(new ChatHistoryTroopMemberFragment.50(this), 8, null, true);
    a("Clk_invite", this.aK, "");
  }
  
  void G()
  {
    if (!this.bE)
    {
      ViewStub localViewStub = (ViewStub)c(2131448095);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131448096)).setOnTouchListener(new ChatHistoryTroopMemberFragment.51(this));
      }
    }
  }
  
  public void H()
  {
    if (!getBaseActivity().isResume()) {
      return;
    }
    ChatHistoryTroopMemberFragment.ListAdapter localListAdapter = this.K;
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
    ChatHistoryTroopMemberFragment.SearchResultAdapter localSearchResultAdapter = this.ad;
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
    localATroopMember.a = paramDiscussionMemberInfo.memberUin.trim();
    if (paramFriendsManager != null) {
      paramFriendsManager = paramFriendsManager.c(paramDiscussionMemberInfo.memberUin);
    } else {
      paramFriendsManager = null;
    }
    localATroopMember.c = paramDiscussionMemberInfo.getDiscussionMemberName();
    localATroopMember.b = 0;
    localATroopMember.d = ChnToSpell.b(localATroopMember.c, 2);
    localATroopMember.a(ChnToSpell.b(localATroopMember.c, 1));
    if ((paramFriendsManager != null) && (paramFriendsManager.isFriend()) && (paramFriendsManager.remark != null) && (paramFriendsManager.remark.length() > 0))
    {
      localATroopMember.e(paramFriendsManager.remark);
      localATroopMember.h(ChnToSpell.b(localATroopMember.k, 1));
      localATroopMember.f(ChnToSpell.b(localATroopMember.k, 2));
    }
    else if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
    {
      localATroopMember.e(paramDiscussionMemberInfo.inteRemark);
      localATroopMember.h(ChnToSpell.b(paramDiscussionMemberInfo.inteRemark, 1));
      localATroopMember.f(ChnToSpell.b(paramDiscussionMemberInfo.inteRemark, 2));
    }
    if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
    {
      localATroopMember.i(paramDiscussionMemberInfo.memberName);
      localATroopMember.k(ChnToSpell.b(paramDiscussionMemberInfo.memberName, 1));
      localATroopMember.j(ChnToSpell.b(paramDiscussionMemberInfo.memberName, 2));
    }
    paramDiscussionMemberInfo = this.ba;
    if (paramDiscussionMemberInfo != null) {
      paramDiscussionMemberInfo.a(localATroopMember);
    }
    return localATroopMember;
  }
  
  public ChatHistoryTroopMemberFragment.ATroopMember a(TroopMemberInfo paramTroopMemberInfo, FriendsManager paramFriendsManager)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    localATroopMember.a = paramTroopMemberInfo.memberuin.trim();
    if (paramFriendsManager != null) {
      paramFriendsManager = paramFriendsManager.c(paramTroopMemberInfo.memberuin);
    } else {
      paramFriendsManager = null;
    }
    localATroopMember.c = ContactUtils.a(this.bc, this.w, localATroopMember.a, true);
    localATroopMember.b = paramTroopMemberInfo.faceid;
    localATroopMember.d = ChnToSpell.b(localATroopMember.c, 2);
    localATroopMember.a(ChnToSpell.b(localATroopMember.c, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localATroopMember.b(paramTroopMemberInfo.friendnick);
      localATroopMember.d(paramTroopMemberInfo.pyAll_friendnick);
      localATroopMember.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    if ((paramFriendsManager != null) && (paramFriendsManager.isFriend()) && (paramFriendsManager.remark != null) && (paramFriendsManager.remark.length() > 0))
    {
      localATroopMember.e(paramFriendsManager.remark);
      localATroopMember.h(ChnToSpell.b(localATroopMember.k, 1));
      localATroopMember.f(ChnToSpell.b(localATroopMember.k, 2));
      localATroopMember.g(paramFriendsManager.remark);
    }
    else if ((paramTroopMemberInfo.autoremark != null) && (paramTroopMemberInfo.autoremark.length() > 0))
    {
      if ((this.B) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localATroopMember.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localATroopMember.h(ChnToSpell.b(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localATroopMember.f(ChnToSpell.b(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
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
    localATroopMember.u = paramTroopMemberInfo.last_active_time;
    localATroopMember.s = paramTroopMemberInfo.join_time;
    localATroopMember.x = paramTroopMemberInfo.level;
    localATroopMember.F = paramTroopMemberInfo.realLevel;
    localATroopMember.G = paramTroopMemberInfo.newRealLevel;
    localATroopMember.z = paramTroopMemberInfo.credit_level;
    localATroopMember.A = paramTroopMemberInfo.isTroopFollowed;
    localATroopMember.y = paramTroopMemberInfo.active_point;
    localATroopMember.I = paramTroopMemberInfo.mIsShielded;
    localATroopMember.H = paramTroopMemberInfo.globalTroopLevel;
    double d1 = ((IBizTroopMemberInfoService)this.bc.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberDiatanceToSelf(this.w, localATroopMember.a);
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
        localATroopMember.C = paramFriendsManager.toString();
      }
      else
      {
        paramFriendsManager = new StringBuilder();
        paramFriendsManager.append(this.bP.format(d1));
        paramFriendsManager.append("km");
        localATroopMember.C = paramFriendsManager.toString();
      }
    }
    else
    {
      localATroopMember.C = "";
    }
    if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
    {
      localATroopMember.D = paramTroopMemberInfo.mUniqueTitle;
      localATroopMember.E = paramTroopMemberInfo.mUniqueTitleExpire;
    }
    paramFriendsManager = this.ba;
    if (paramFriendsManager != null) {
      paramFriendsManager.a(localATroopMember);
    }
    localATroopMember.L = paramTroopMemberInfo.mVipType;
    localATroopMember.M = paramTroopMemberInfo.mVipLevel;
    localATroopMember.N = paramTroopMemberInfo.mBigClubTemplateId;
    localATroopMember.O = paramTroopMemberInfo.mBigClubVipType;
    localATroopMember.P = paramTroopMemberInfo.mBigClubVipLevel;
    localATroopMember.Q = paramTroopMemberInfo.mBigClubTemplateId;
    return localATroopMember;
  }
  
  protected ChatHistoryTroopMemberFragment.TmViewHolder a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean) {
      localObject1 = this.ab;
    } else {
      localObject1 = this.s;
    }
    int j = ((ViewGroup)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof ChatHistoryTroopMemberFragment.TmViewHolder)))
      {
        localObject2 = (ChatHistoryTroopMemberFragment.TmViewHolder)((View)localObject2).getTag();
        if ((((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).y != null) && (((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).y.equals(paramString)))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("findListItemHolderByUin:");
            paramString.append(i);
            QLog.d("Q.history.BaseFragment", 2, paramString.toString());
          }
          return localObject2;
        }
      }
      i += 1;
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
  
  protected List<ChatHistoryTroopMemberFragment.ATroopMember> a(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList, String paramString1, String paramString2)
  {
    int i1 = paramList.size();
    if (i1 > 0)
    {
      int i = 0;
      while (i < i1)
      {
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i);
        if ((paramString1 != null) && (paramString1.equals(localATroopMember.a)))
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
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(k);
        i = j;
        if (paramString2.contains(paramString1.a))
        {
          i = j;
          if (paramString1.x == 332)
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
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(m);
        j = i;
        if (paramString2.contains(paramString1.a))
        {
          j = i;
          if (paramString1.x == 333)
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
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i);
        k = j;
        if (paramString1.x == 332)
        {
          paramList.remove(i);
          paramList.add(j, paramString1);
          k = j + 1;
        }
        i += 1;
      }
      for (i = j; j < i1; i = k)
      {
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(j);
        k = i;
        if (paramString1.x == 333)
        {
          paramList.remove(j);
          paramList.add(i, paramString1);
          k = i + 1;
        }
        j += 1;
      }
      for (j = i; i < i1; j = k)
      {
        paramString1 = (ChatHistoryTroopMemberFragment.ATroopMember)paramList.get(i);
        k = j;
        if (paramString2.contains(paramString1.a))
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
  
  protected void a()
  {
    Object localObject = (ViewGroup)c(2131444897);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = c(2131447484);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)c(2131436180);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1 = (FriendsManager)this.bc.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = (TroopManager)this.bc.getManager(QQManagerFactory.TROOP_MANAGER);
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
                d((String)paramIntent.next());
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
      if (!TextUtils.isEmpty(this.bB)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.3(this, (FriendsManager)localObject1), 8, null, true);
      }
    }
  }
  
  protected void a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if ((paramATroopMember != null) && (paramATroopMember.J))
    {
      this.K.d.clear();
      paramATroopMember = new Intent();
      paramATroopMember.putExtra("result", new JSONArray().toString());
      getBaseActivity().setResult(-1, paramATroopMember);
      ReportController.b(this.bc, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.w, "", "", "");
      getBaseActivity().finish();
      return;
    }
    if (paramATroopMember != null)
    {
      if (paramATroopMember.a == null) {
        return;
      }
      int i = this.az;
      Object localObject1;
      if (i == 1)
      {
        if (this.bc.getCurrentAccountUin().equals(paramATroopMember.a))
        {
          localObject1 = new AllInOne(paramATroopMember.a, 0);
          ((AllInOne)localObject1).nickname = ContactUtils.f(this.bc, paramATroopMember.a);
          ((AllInOne)localObject1).lastActivity = 3;
          ((AllInOne)localObject1).profileEntryType = 4;
          ProfileUtils.openProfileCard(getActivity(), (AllInOne)localObject1);
          return;
        }
        a(paramATroopMember.a, paramATroopMember.c);
        return;
      }
      Object localObject2;
      if (i == 2)
      {
        localObject1 = getActivity().getIntent();
        ((Intent)localObject1).putExtra("troop_uin", this.w);
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.a);
        localObject2 = new TroopMemberList.TroopAdmin();
        ((TroopMemberList.TroopAdmin)localObject2).a = paramATroopMember.a;
        ((TroopMemberList.TroopAdmin)localObject2).b = paramATroopMember.b;
        ((TroopMemberList.TroopAdmin)localObject2).c = paramATroopMember.c;
        ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
        getBaseActivity().setResult(-1, (Intent)localObject1);
        getBaseActivity().finish();
        return;
      }
      if ((i != 3) && (i != 11) && (i != 16))
      {
        if ((i != 0) && (i != 4) && (i != 9) && (i != 15) && (i != 17) && (i != 22))
        {
          if (i == 5)
          {
            localObject1 = this.C;
            if ((localObject1 != null) && (((String)localObject1).equals(paramATroopMember.a)))
            {
              i = 3;
            }
            else
            {
              localObject1 = this.D;
              if ((localObject1 != null) && (((String)localObject1).contains(paramATroopMember.a))) {
                i = 2;
              } else {
                i = 1;
              }
            }
            startActivityForResult(EditUniqueTitleActivity.a(getBaseActivity(), 1, this.w, paramATroopMember.a, i, paramATroopMember.D), 2);
            this.bB = paramATroopMember.a;
            localObject1 = this.bc;
            localObject2 = this.w;
            i = this.bj;
            if (this.bk) {
              paramATroopMember = "1";
            } else {
              paramATroopMember = "0";
            }
            ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i), paramATroopMember, "");
            return;
          }
          if (i == 14)
          {
            localObject1 = getActivity().getIntent();
            ((Intent)localObject1).putExtra("member_uin", paramATroopMember.a);
            ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.c);
            ((Intent)localObject1).putExtra("troop_uin", this.w);
            ((Intent)localObject1).putExtra("troop_gift_from", this.y);
            getActivity().setResult(-1, (Intent)localObject1);
            getActivity().finish();
            return;
          }
          if ((i != 12) && (i != 20))
          {
            if ((i != 18) && (i != 19))
            {
              if (i == 23)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra(TroopFileProxyActivity.b, this.w);
                ((Intent)localObject1).putExtra("filter_member_name", paramATroopMember.h);
                ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramATroopMember.a));
                ((Intent)localObject1).putExtra("folderPath", "/");
                ((Intent)localObject1).putExtra("param_from", 6000);
                TroopFileProxyActivity.a(getBaseActivity(), (Intent)localObject1, this.bc.getCurrentAccountUin());
              }
            }
            else
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("troop_uin", this.w);
              ((Intent)localObject1).putExtra("member_uin", paramATroopMember.a);
              PublicFragmentActivity.a(getBaseActivity(), (Intent)localObject1, TroopMemberHistoryFragment.class);
              ReportController.b(this.bc, "CliOper", "", "", "0X800A596", "0X800A596", 1, 0, "", "", "", "");
              if (this.az == 19)
              {
                paramATroopMember = ((TroopManager)this.bc.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.aj.troopUin, this.bc.getCurrentAccountUin());
                TroopReportor.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.aj.troopUin, TroopReportor.a(paramATroopMember) });
              }
            }
          }
          else
          {
            if (this.aE == 1)
            {
              this.K.d.clear();
              this.K.d.add(paramATroopMember);
              paramATroopMember = new Intent();
              localObject1 = new JSONArray();
              if (this.K.d != null)
              {
                localObject2 = this.K.d.iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localATroopMember.a);
                    localJSONObject.put("nick", localATroopMember.c);
                  }
                  catch (Exception localException)
                  {
                    label1030:
                    int j;
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
            if (this.K.d.contains(paramATroopMember))
            {
              this.K.d.remove(paramATroopMember);
            }
            else
            {
              i = this.K.d.size();
              j = this.aE;
              if (i < j)
              {
                this.K.d.add(paramATroopMember);
              }
              else if (j == 1)
              {
                this.K.d.clear();
                this.K.d.add(paramATroopMember);
              }
              else
              {
                paramATroopMember = getResources().getString(this.aV, new Object[] { Integer.valueOf(this.aE) });
                QQToast.makeText(getBaseActivity(), paramATroopMember, 0).show();
              }
            }
            this.K.notifyDataSetChanged();
          }
        }
        else
        {
          h(paramATroopMember.a);
          if (this.az == 22) {
            TroopReportor.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.w });
          }
        }
      }
      else
      {
        localObject1 = getActivity().getIntent();
        if (this.bF)
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.c);
          ((Intent)localObject1).putExtra("isApollo", true);
        }
        else
        {
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.c);
        }
        ((Intent)localObject1).putExtra("member_uin", paramATroopMember.a);
        ((Intent)localObject1).putExtra("troop_uin", this.w);
        getBaseActivity().setResult(-1, (Intent)localObject1);
        getBaseActivity().finish();
      }
    }
  }
  
  protected void a(ChatHistoryTroopMemberFragment.TmViewHolder paramTmViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1) {
      str = this.bs;
    } else {
      str = this.br;
    }
    paramTmViewHolder.q = paramBoolean1;
    paramTmViewHolder.c.setVisibility(0);
    paramTmViewHolder.b.setVisibility(8);
    paramTmViewHolder.a.setVisibility(8);
    paramTmViewHolder.A.setImageBitmap(paramBitmap);
    if (this.bj == 1)
    {
      if (!paramATroopMember.K) {
        paramTmViewHolder.A.setAlpha(165);
      } else {
        paramTmViewHolder.A.setAlpha(255);
      }
    }
    else
    {
      paramTmViewHolder.A.setAlpha(255);
      paramTmViewHolder.s.setVisibility(8);
    }
    if ((!this.u) && (!O()) && (paramATroopMember.H != -100) && (paramATroopMember.H != 0))
    {
      paramTmViewHolder.s.setVisibility(8);
      paramBitmap = paramTmViewHolder.s;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LV");
      ((StringBuilder)localObject).append(paramATroopMember.H);
      paramBitmap.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      paramTmViewHolder.s.setVisibility(8);
    }
    VipUtils.a(getBaseActivity().app, getBaseActivity(), getResources(), paramTmViewHolder, paramATroopMember);
    if ((this.az == 13) && (paramBoolean1))
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(paramATroopMember.c);
      paramBitmap.append("(");
      paramBitmap.append(paramATroopMember.a);
      paramBitmap.append(")");
      paramBitmap = paramBitmap.toString();
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramATroopMember.c.length(), paramBitmap.length(), 18);
      paramTmViewHolder.j.setText((CharSequence)localObject);
    }
    else if (paramBoolean2)
    {
      paramBitmap = new ColorNickText(paramATroopMember.h, 16).b();
      paramTmViewHolder.j.setText(paramBitmap);
      ColorNickManager.a(this.bc, paramTmViewHolder.j, paramBitmap);
    }
    else
    {
      paramBitmap = new ColorNickText(paramATroopMember.c, 16).b();
      paramTmViewHolder.j.setText(paramBitmap);
      ColorNickManager.a(this.bc, paramTmViewHolder.j, paramBitmap);
    }
    if ((paramBoolean2) && (paramTmViewHolder.t != null))
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(HardCodeUtil.a(2131899827));
      paramBitmap.append(paramATroopMember.k);
      paramBitmap = paramBitmap.toString();
      paramTmViewHolder.t.setText(paramBitmap);
    }
    paramTmViewHolder.y = paramATroopMember.a;
    paramTmViewHolder.z = 1;
    Object localObject = paramTmViewHolder.k;
    paramBitmap = "";
    ((TextView)localObject).setText("");
    paramTmViewHolder.g.setTag(Boolean.valueOf(paramBoolean1));
    if (this.az == 9) {
      paramTmViewHolder.h.setVisibility(8);
    } else {
      paramTmViewHolder.h.setTag(Boolean.valueOf(paramBoolean1));
    }
    paramTmViewHolder.m.setOnClickListener(this.bt);
    paramTmViewHolder.f.setOnClickListener(this.bt);
    paramTmViewHolder.c.setOnClickListener(this.bo);
    if ((!this.z) && (!this.A))
    {
      if (this.az == 21)
      {
        paramTmViewHolder.d.setOnClickListener(null);
        paramTmViewHolder.d.setClickable(false);
      }
      else
      {
        paramTmViewHolder.d.setOnClickListener(null);
        paramTmViewHolder.d.setClickable(false);
      }
    }
    else
    {
      paramTmViewHolder.d.setOnClickListener(this.bt);
      paramTmViewHolder.d.setClickable(true);
      if (this.A) {
        paramTmViewHolder.c.setOnClickListener(null);
      }
    }
    int i = this.az;
    if ((i != 1) && (i != 13))
    {
      paramTmViewHolder.h.setText("");
      boolean bool3 = TextUtils.isEmpty(paramATroopMember.D) ^ true;
      if ((paramATroopMember.a != null) && (paramATroopMember.a.equals(this.C))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      boolean bool1;
      if ((this.D != null) && (paramATroopMember.a != null) && (this.D.contains(paramATroopMember.a))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool4 = this.bc.getCurrentAccountUin().equals(this.C);
      boolean bool5 = this.bc.getCurrentAccountUin().equals(paramATroopMember.a);
      if (this.az == 5)
      {
        paramTmViewHolder.o.setVisibility(0);
        paramTmViewHolder.h.setVisibility(8);
        paramTmViewHolder.p.setVisibility(0);
        if ((bool3) && (!SimpleUIUtil.e()))
        {
          localObject = TroopRankConfig.a().a(302, bool3, paramBoolean1, bool1);
          if (localObject != null)
          {
            i = ((TroopRankConfig.TroopRankItem)localObject).b;
            paramBitmap = paramATroopMember.D;
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
              i = ((TroopRankConfig.TroopRankItem)localObject).b;
              paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).c;
              break label1001;
            }
          }
          else if (bool1)
          {
            localObject = TroopRankConfig.a().a(301, bool3, paramBoolean1, bool1);
            if (localObject != null)
            {
              i = ((TroopRankConfig.TroopRankItem)localObject).b;
              paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).c;
              break label1001;
            }
          }
          i = 0;
        }
        label1001:
        if (!TextUtils.isEmpty(paramBitmap))
        {
          paramTmViewHolder.o.setText(paramBitmap);
          TroopRankConfig.a(paramTmViewHolder.o, i);
        }
        else
        {
          paramTmViewHolder.o.setVisibility(8);
        }
      }
      else
      {
        paramBitmap = this.ai;
        boolean bool2;
        if (paramBitmap != null) {
          bool2 = paramBitmap.isQidianPrivateTroop();
        } else {
          bool2 = false;
        }
        if ((!bool2) && (!this.u))
        {
          localObject = TroopRankConfig.a().a(paramATroopMember.x, bool3, paramBoolean1, bool1);
          if (localObject != null)
          {
            paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).c;
            i = ((TroopRankConfig.TroopRankItem)localObject).b;
            if (((TroopRankConfig.TroopRankItem)localObject).a == 302) {
              paramBitmap = paramATroopMember.D;
            }
            if (((TroopRankConfig.TroopRankItem)localObject).a == 315) {
              paramBitmap = (String)this.ai.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.F));
            }
          }
          else if (paramATroopMember.x == 315)
          {
            paramBitmap = (String)this.ai.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.F));
            i = Color.parseColor("#8EBDF9");
          }
          else
          {
            paramBitmap = "";
            i = 0;
          }
        }
        else
        {
          localObject = TroopRankConfig.a().a(paramBoolean1, bool1);
          if (localObject != null)
          {
            paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).c;
            i = ((TroopRankConfig.TroopRankItem)localObject).b;
          }
          else
          {
            paramBitmap = "";
            i = 0;
          }
        }
        if (this.az == 11) {
          paramBitmap = "";
        }
        if ((SimpleUIUtil.e()) && (paramBoolean1))
        {
          localObject = String.format(getString(2131886099), new Object[0]);
        }
        else
        {
          localObject = paramBitmap;
          if (SimpleUIUtil.e())
          {
            localObject = paramBitmap;
            if (bool1) {
              localObject = String.format(getString(2131886098), new Object[0]);
            }
          }
        }
        if ((SimpleUIUtil.e()) && (!bool1) && (!paramBoolean1)) {
          j = 1;
        } else {
          j = 0;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!O()) && (j == 0))
        {
          paramTmViewHolder.h.setVisibility(0);
          paramTmViewHolder.h.setText((CharSequence)localObject);
          TroopRankConfig.a(paramTmViewHolder.h, i);
        }
        else
        {
          paramTmViewHolder.h.setVisibility(8);
        }
        if (this.u)
        {
          paramBitmap = TroopRankConfig.a().a(paramATroopMember.x, false, false, false);
          if ((paramBitmap != null) && (((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramATroopMember.x)))
          {
            if (!TextUtils.isEmpty(paramBitmap.c))
            {
              paramTmViewHolder.i.setVisibility(0);
              paramTmViewHolder.i.setText(paramBitmap.c);
              TroopRankConfig.a(paramTmViewHolder.i, paramBitmap.b);
            }
            else
            {
              paramTmViewHolder.i.setVisibility(8);
            }
          }
          else {
            paramTmViewHolder.i.setVisibility(8);
          }
        }
        i = this.az;
        if ((i != 9) && (i != 12)) {
          if ((paramATroopMember.a != null) && (paramATroopMember.a.equals(this.bc.getCurrentAccountUin()))) {
            paramTmViewHolder.k.setText(getString(2131892063));
          } else {
            paramTmViewHolder.k.setText("");
          }
        }
      }
      paramBitmap = (ITroopRobotService)this.bc.getRuntimeService(ITroopRobotService.class, "all");
      if ((paramBitmap != null) && (paramBitmap.isRobotUin(paramATroopMember.a))) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.z)
      {
        if ((this.az != 21) && ((paramBoolean1) || ((!bool4) && (bool1)) || ((!bool4) && (i != 0))))
        {
          paramTmViewHolder.f.setVisibility(8);
          paramTmViewHolder.c.b(false);
        }
        else
        {
          paramTmViewHolder.f.setVisibility(0);
          paramTmViewHolder.g.setBackgroundResource(2130851766);
          if (str.equals(paramATroopMember.a)) {
            paramTmViewHolder.c.a(false);
          } else {
            paramTmViewHolder.c.b(false);
          }
        }
      }
      else
      {
        if (this.A)
        {
          if ((!paramBoolean1) && ((bool4) || (!bool1)) && (!bool5)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            paramTmViewHolder.f.setVisibility(8);
          }
          else
          {
            paramTmViewHolder.f.setVisibility(0);
            if ((paramATroopMember.a != null) && (this.K.e.contains(paramATroopMember.a)))
            {
              paramTmViewHolder.g.setBackgroundResource(2130841341);
              i = 1;
              break label1869;
            }
            paramTmViewHolder.g.setBackgroundResource(2130841337);
          }
          i = 0;
        }
        else
        {
          label1869:
          if (this.az != 20) {
            break label1941;
          }
          paramTmViewHolder.f.setVisibility(0);
          if ((paramATroopMember.a == null) || (!this.K.d.contains(paramATroopMember))) {
            break label1928;
          }
          paramTmViewHolder.g.setBackgroundResource(2130841341);
          i = 1;
        }
        break label2200;
        label1928:
        paramTmViewHolder.g.setBackgroundResource(2130841337);
        break label1958;
        label1941:
        paramTmViewHolder.f.setVisibility(8);
        paramTmViewHolder.c.b(false);
      }
    }
    else
    {
      label1958:
      paramBitmap = paramTmViewHolder.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getString(2131888752));
      ((StringBuilder)localObject).append(paramTmViewHolder.j.getText().toString());
      paramBitmap.setContentDescription(((StringBuilder)localObject).toString());
      paramTmViewHolder.g.setBackgroundResource(2130851766);
      i = this.az;
      if (i == 13)
      {
        paramTmViewHolder.f.setVisibility(0);
      }
      else if (i == 21)
      {
        paramTmViewHolder.f.setVisibility(0);
      }
      else if ((this.C != null) && (!paramATroopMember.a.equals(this.C)))
      {
        paramTmViewHolder.f.setVisibility(0);
      }
      else
      {
        paramTmViewHolder.f.setVisibility(8);
        paramTmViewHolder.c.b(false);
      }
      if (str.equals(paramATroopMember.a)) {
        paramTmViewHolder.c.a(false);
      } else {
        paramTmViewHolder.c.b(false);
      }
      paramTmViewHolder.f.setContentDescription(String.format(getString(2131888737), new Object[] { paramTmViewHolder.j.getText().toString() }));
      paramTmViewHolder.m.setContentDescription(getString(2131888736));
    }
    i = 0;
    label2200:
    int j = 1;
    if (paramTmViewHolder.l != null)
    {
      paramBitmap = (ITroopRobotService)this.bc.getRuntimeService(ITroopRobotService.class, "all");
      if ((paramBitmap == null) || (!paramBitmap.isRobotUin(paramATroopMember.a))) {
        j = 0;
      }
      if (j != 0) {
        paramTmViewHolder.l.setVisibility(0);
      } else {
        paramTmViewHolder.l.setVisibility(8);
      }
    }
    if (this.B) {
      paramTmViewHolder.s.setVisibility(8);
    }
    paramBitmap = new StringBuffer();
    paramBitmap.append(paramTmViewHolder.j.getText().toString());
    if ((paramBoolean2) && (paramTmViewHolder.t != null)) {
      paramBitmap.append(paramTmViewHolder.t.getText());
    }
    if (paramTmViewHolder.h.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.h.getText().toString());
    }
    if (paramTmViewHolder.s.getVisibility() == 0) {
      paramBitmap.append(paramTmViewHolder.s.getText().toString());
    }
    if ((paramTmViewHolder.f.getVisibility() == 0) && (this.A))
    {
      if (i != 0) {
        paramATroopMember = "已选中";
      } else {
        paramATroopMember = "未选中";
      }
      paramBitmap.append(paramATroopMember);
    }
    paramTmViewHolder.d.setContentDescription(paramBitmap.toString());
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendsManager)this.bc.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramString2 != null)
    {
      if (paramString2.n(paramString1))
      {
        paramString1 = new AllInOne(paramString1, 20);
        paramString1.pa = 20;
        paramString1.troopUin = this.v;
        paramString1.troopCode = this.w;
        paramString1.profileEntryType = 4;
        ProfileUtils.openProfileCard(getActivity(), paramString1);
        return;
      }
      paramString1 = new AllInOne(paramString1, 21);
      paramString1.pa = 21;
      paramString1.subSourceId = 11;
      paramString1.troopUin = this.v;
      paramString1.troopCode = this.w;
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
          localStringBuilder.append(this.az);
          QLog.i("Q.history.BaseFragment", 2, localStringBuilder.toString());
          if (this.az != 1)
          {
            if (this.az == 11) {
              return;
            }
            if (this.az == 9)
            {
              if (this.aB != 1) {
                break label246;
              }
              paramString2 = "suc_pay_list";
              ReportController.b(this.bc, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.w, paramString3, "", "");
              return;
            }
            ReportController.b(this.bc, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.w, paramString2, paramString3, "");
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
  
  public void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      ChatHistoryTroopMemberFragment.ListAdapter localListAdapter = this.K;
      if (localListAdapter == null) {
        return;
      }
      if (localListAdapter.i + this.K.j > 16) {
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
          int n = j + this.aX;
          j = this.aY * m + n;
          if (j > this.aW)
          {
            j = m;
            do
            {
              m = j - 1;
              k = this.aX * m + n;
              if (k <= this.aW) {
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
      if (j + this.aY > this.aW) {
        this.aZ = (i + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.BaseFragment", 2, String.format("updateMaxItemCount, max: %s", new Object[] { Integer.valueOf(this.aZ) }));
      }
    }
  }
  
  protected Object[] a(String paramString, List<String> paramList)
  {
    try
    {
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localFriendsManager = (FriendsManager)this.bc.getManager(QQManagerFactory.FRIENDS_MANAGER);
    }
    finally
    {
      long l;
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
      localEntityManager = this.bc.getEntityManagerFactory().createEntityManager();
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
      paramString.append(System.currentTimeMillis() - l);
      QLog.d("Q.history.BaseFragment", 2, paramString.toString());
    }
    return new Object[] { localArrayList };
  }
  
  protected void b()
  {
    this.U = ((LinearLayout)c(2131448040));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.U.setFitsSystemWindows(true);
    }
    this.M = c(2131447484);
    this.M.setVisibility(8);
    this.Q = ((TextView)c(2131436227));
    this.R = ((TextView)c(2131436173));
    this.S = ((LinearLayout)c(2131430444));
    this.T = ((TextView)c(2131436180));
    int i = this.az;
    if ((i == 3) || (i == 11))
    {
      this.T.setVisibility(8);
      this.T = ((TextView)c(2131436182));
      this.T.setVisibility(0);
    }
    this.N = ((TextView)c(2131436211));
    this.O = ((ImageView)c(2131436194));
    this.s = ((PinnedDividerSwipListView)c(2131448034));
    this.af = ((IndexView)c(2131435678));
    this.an = c(2131444560);
    this.aQ = ((RelativeLayout)c(2131437320));
    this.aP = ((RelativeLayout)c(2131437630));
    this.aR = ((ProgressBar)this.aP.findViewById(2131435131));
    this.aS = ((TextView)this.aP.findViewById(2131437663));
    this.O.setContentDescription(getString(2131895296));
    this.P = ((ImageView)c(2131436195));
    this.P.setBackgroundResource(2130844958);
    this.P.setContentDescription(getString(2131917403));
  }
  
  protected void b(String paramString, List<TroopMemberInfo> paramList)
  {
    for (;;)
    {
      try
      {
        this.J.clear();
        this.bp = 0.0D;
        this.bY = -1;
        this.ca = 0;
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
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
        }
        this.bZ = System.currentTimeMillis();
        if (paramList != null) {
          if (!paramList.isEmpty()) {
            continue;
          }
        }
        paramList = new ArrayList();
        localObject = this.bc.getEntityManagerFactory().createEntityManager();
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
          paramString.append(l - this.bZ);
          QLog.d("Q.history.BaseFragment", 2, paramString.toString());
          paramString = paramList;
        }
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          int j = paramString.size();
          this.ca = j;
          int k = j / cb;
          if (j % cb != 0) {
            continue;
          }
          i = 0;
          this.bY = (k + i);
          i = 0;
          if (i < j)
          {
            ThreadManager.post(new ChatHistoryTroopMemberFragment.36(this, paramString, i, Math.min(cb + i - 1, j)), 8, null, true);
            i += cb;
            continue;
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("getTroopMemberFromDBIfNeeded, listSize:");
            paramString.append(j);
            paramString.append("|mJobCount:");
            paramString.append(this.bY);
            QLog.d("Q.history.BaseFragment", 2, paramString.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
          }
          D();
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
    Object localObject = this.ac;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.ac.size())
        {
          ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.ac.get(i);
          if ((localATroopMember == null) || (!localATroopMember.a.equals(paramString))) {
            continue;
          }
          this.ac.remove(i);
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
  
  protected ChatHistoryTroopMemberFragment.ATroopMember d(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeItem:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.J.size())
        {
          localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.J.get(i);
          if ((localObject != null) && (((ChatHistoryTroopMemberFragment.ATroopMember)localObject).a.equals(paramString)))
          {
            paramString = (ChatHistoryTroopMemberFragment.ATroopMember)this.J.remove(i);
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
  
  protected void d() {}
  
  protected void e(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.bs = "";
    this.ac.clear();
    this.ae.getLayoutParams().height = -1;
    Object localObject;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ITroopRobotService localITroopRobotService;
    int i;
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      this.X.setVisibility(0);
      this.ab.setVisibility(0);
      paramString = paramString.toLowerCase();
      localObject = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localITroopRobotService = (ITroopRobotService)this.bc.getRuntimeService(ITroopRobotService.class, "all");
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.J.size())
        {
          ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.J.get(i);
          if ((this.bW) && (localITroopRobotService.isRobotUin(localATroopMember.a))) {
            break label1221;
          }
          localATroopMember.f = "";
          localATroopMember.g = "";
          if ((!paramString.equals(localATroopMember.n)) && (!paramString.equals(localATroopMember.q)) && (!paramString.equals(localATroopMember.p)))
          {
            if ((!paramString.equals(localATroopMember.k)) && (!paramString.equals(localATroopMember.m)) && (!paramString.equals(localATroopMember.l)))
            {
              if ((!paramString.equals(localATroopMember.h)) && (!paramString.equals(localATroopMember.j)) && (!paramString.equals(localATroopMember.i)))
              {
                if (paramString.equals(localATroopMember.a))
                {
                  if (!this.B)
                  {
                    localATroopMember.f = localATroopMember.a;
                    ((List)localObject).add(localATroopMember);
                  }
                }
                else if ((localATroopMember.n.indexOf(paramString) != 0) && (localATroopMember.q.indexOf(paramString) != 0) && (localATroopMember.p.indexOf(paramString) != 0))
                {
                  if ((localATroopMember.k.indexOf(paramString) != 0) && (localATroopMember.m.indexOf(paramString) != 0) && (localATroopMember.l.indexOf(paramString) != 0))
                  {
                    if ((localATroopMember.h.indexOf(paramString) != 0) && (localATroopMember.j.indexOf(paramString) != 0) && (localATroopMember.i.indexOf(paramString) != 0))
                    {
                      if (localATroopMember.a.indexOf(paramString) == 0)
                      {
                        if (!this.B)
                        {
                          localATroopMember.f = localATroopMember.a;
                          localATroopMember.g = localATroopMember.a;
                          localArrayList1.add(localATroopMember);
                        }
                      }
                      else if ((localATroopMember.n.indexOf(paramString) <= 0) && (localATroopMember.q.indexOf(paramString) <= 0) && (localATroopMember.p.indexOf(paramString) <= 0))
                      {
                        if ((localATroopMember.k.indexOf(paramString) <= 0) && (localATroopMember.m.indexOf(paramString) <= 0) && (localATroopMember.l.indexOf(paramString) <= 0))
                        {
                          if ((localATroopMember.h.indexOf(paramString) <= 0) && (localATroopMember.j.indexOf(paramString) <= 0) && (localATroopMember.i.indexOf(paramString) <= 0))
                          {
                            if ((localATroopMember.a.indexOf(paramString) > 0) && (!this.B))
                            {
                              localATroopMember.f = localATroopMember.a;
                              localArrayList2.add(localATroopMember);
                            }
                          }
                          else
                          {
                            localATroopMember.f = localATroopMember.h;
                            localArrayList2.add(localATroopMember);
                          }
                        }
                        else
                        {
                          localATroopMember.f = localATroopMember.k;
                          localArrayList2.add(localATroopMember);
                        }
                      }
                      else
                      {
                        localATroopMember.f = localATroopMember.n;
                        localArrayList2.add(localATroopMember);
                      }
                    }
                    else
                    {
                      localATroopMember.f = localATroopMember.h;
                      localATroopMember.g = localATroopMember.i;
                      localArrayList1.add(localATroopMember);
                    }
                  }
                  else
                  {
                    localATroopMember.f = localATroopMember.k;
                    localATroopMember.g = localATroopMember.l;
                    localArrayList1.add(localATroopMember);
                  }
                }
                else
                {
                  localATroopMember.f = localATroopMember.n;
                  localATroopMember.g = localATroopMember.p;
                  localArrayList1.add(localATroopMember);
                }
              }
              else
              {
                localATroopMember.f = localATroopMember.h;
                ((List)localObject).add(localATroopMember);
              }
            }
            else
            {
              localATroopMember.f = localATroopMember.k;
              ((List)localObject).add(localATroopMember);
            }
          }
          else
          {
            localATroopMember.f = localATroopMember.n;
            ((List)localObject).add(localATroopMember);
          }
          if (!QLog.isColorLevel()) {
            break label1221;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshSearchResultList:");
          localStringBuilder.append(localATroopMember.a);
          localStringBuilder.append(",");
          localStringBuilder.append(localATroopMember.f);
          QLog.d("Q.history.BaseFragment", 2, localStringBuilder.toString());
          break label1221;
        }
        Collections.sort(localArrayList1, new ChatHistoryTroopMemberFragment.SearchResultComparator(this));
        this.ac.addAll((Collection)localObject);
        this.ac.addAll(localArrayList1);
        this.ac.addAll(localArrayList2);
        if (this.ac.isEmpty()) {
          this.Z.setVisibility(0);
        } else {
          this.Z.setVisibility(8);
        }
        this.ad.notifyDataSetChanged();
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshSearchResultList:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(l2 - l1);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.ac.size());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.J.size());
          QLog.i("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      this.X.setVisibility(8);
      this.ab.setVisibility(8);
      this.Z.setVisibility(8);
      this.ad.notifyDataSetChanged();
      return;
      label1221:
      i += 1;
    }
  }
  
  protected Object[] f(String paramString)
  {
    for (;;)
    {
      try
      {
        this.J.clear();
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
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject1).toString());
        }
        l1 = System.currentTimeMillis();
        localObject1 = (FriendsManager)this.bc.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.aq = ((DiscussionManager)this.bc.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getDiscussionMemberFromDB, queryTime:");
          paramString.append(l2 - l1);
          QLog.d("Q.history.BaseFragment", 2, paramString.toString());
        }
        if (this.aq == null) {
          continue;
        }
        j = this.aq.size();
        i = 0;
        if (i < j)
        {
          paramString = (DiscussionMemberInfo)this.aq.get(i);
          if (paramString == null) {
            continue;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.az == 2) && (paramString.memberUin.equals(this.C))) || ((this.az == 1) && (this.ak != null) && (paramString.memberUin.equals(this.ak.inheritOwnerUin)))) {
              continue;
            }
            paramString = a(paramString, (FriendsManager)localObject1);
            this.J.add(paramString);
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
        i = j;
        if (this.bc.getProxyManager() != null)
        {
          this.bc.getProxyManager().notifyRefreshTroopMember();
          i = j;
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getDiscussionMemberFromDB, TotalTime:");
          paramString.append(l2 - l1);
          paramString.append(", listSize:");
          paramString.append(this.J.size());
          paramString.append(", dbSize:");
          paramString.append(i);
          QLog.d("Q.history.BaseFragment", 2, paramString.toString());
        }
        localObject2 = this.K.b();
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
  
  protected void g(String paramString)
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
        if (this.L == null)
        {
          this.L = new ReportDialog(getBaseActivity(), 2131953338);
          this.L.setContentView(2131623999);
          localObject = this.L;
          int i = this.az;
          bool = true;
          if (i != 1)
          {
            ((Dialog)localObject).setCancelable(bool);
            ((TextView)this.L.findViewById(2131431876)).setText(getString(2131888735));
          }
        }
        else
        {
          this.L.show();
          this.ar.b(Long.parseLong(this.v), Long.valueOf(paramString).longValue());
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
  
  protected void h(String paramString)
  {
    if (((ITroopRobotService)this.bc.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(getActivity(), this.w, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131917557));
    String str = this.aC;
    if ((str != null) && (!TextUtils.isEmpty(str))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131887625));
    }
    TroopMemberCardUtils.a(this.bc, getBaseActivity(), this.w, paramString, 1, 1, localBundle);
    this.bB = paramString;
    a("Clk_item", this.aK, "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2) {
        H();
      }
    }
    else {
      this.ba.b();
    }
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629579, paramViewGroup, false);
    this.bd = paramLayoutInflater;
    b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.ax = true;
    try
    {
      this.bn.removeCallbacksAndMessages(null);
      localObject = this.ba;
      if (localObject != null)
      {
        ((TroopMemberAddFrdHelper)localObject).c();
        this.ba = null;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject = (QBaseActivity)getActivity();
        ((QBaseActivity)localObject).removeObserver(this.bu);
        ((QBaseActivity)localObject).removeObserver(this.bv);
        ((QBaseActivity)localObject).removeObserver(this.bx);
        ((QBaseActivity)localObject).removeObserver(this.bA);
        ((QBaseActivity)localObject).removeObserver(this.bw);
        ((QBaseActivity)localObject).removeObserver(this.by);
        ((QBaseActivity)localObject).removeObserver(this.bz);
        label99:
        localObject = this.ad;
        if (localObject != null) {
          ((ChatHistoryTroopMemberFragment.SearchResultAdapter)localObject).c();
        }
        super.k();
        localObject = this.L;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          this.L.dismiss();
        }
        localObject = this.K;
        if (localObject != null) {
          ((ChatHistoryTroopMemberFragment.ListAdapter)localObject).d();
        }
        localObject = this.am;
        if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
          this.am.dismiss();
        }
        localObject = this.bm;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          this.bm.dismiss();
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
      this.s.setSelection(0);
      return;
    }
    int i = this.K.b(paramString);
    if (i != -1)
    {
      paramString = this.s;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onIndexChanged(String paramString, int paramInt)
  {
    if ("$".equals(paramString))
    {
      if ((this.az == 11) && (paramInt == 1)) {
        ReportController.b(this.bc, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    else if ((this.az == 11) && (paramInt == 0)) {
      ReportController.b(this.bc, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
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
      Object localObject = this.M;
      if (localObject != null)
      {
        ((View)localObject).destroyDrawingCache();
        this.M.requestLayout();
        this.M.invalidate();
      }
      localObject = this.ba;
      if (localObject != null) {
        ((TroopMemberAddFrdHelper)localObject).a();
      }
      ReportController.b(this.a, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 7, 0, "", "", "", "");
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
    this.bc = getBaseActivity().app;
    paramView = this.bc;
    paramView = getBaseActivity().getIntent().getExtras();
    this.w = paramView.getString("uin");
    this.x = paramView.getString("troop_info_name");
    this.y = paramView.getString("troop_gift_from");
    this.ah = paramView.getString("leftViewText");
    int k = 0;
    this.ay = paramView.getBoolean("param_is_pop_up_style", false);
    this.az = 18;
    this.aA = paramView.getString("param_troop_fee_project_id");
    this.aB = paramView.getInt("param_troop_fee_entrance_type", -1);
    this.bg = paramView.getString("callback");
    this.bF = paramView.getBoolean("param_troop_send_apollo_msg", false);
    this.ca = paramView.getInt("TROOP_INFO_MEMBER_NUM", 0);
    this.bj = paramView.getInt("sort_type", 0);
    this.aE = paramView.getInt("param_pick_max_num", this.aE);
    this.aU = paramView.getStringArrayList("param_pick_selected_list");
    this.at = paramView.getStringArrayList("param_delete_filter_member_list");
    this.au = paramView.getStringArrayList("param_hide_filter_member_list");
    this.aV = paramView.getInt("param_pick_max_num_exceeds_wording", 2131895360);
    this.aD = paramView.getString("param_pick_title_string", this.aD);
    this.bW = paramView.getBoolean("param_filter_robot", false);
    if (this.az == 17) {
      new ReportTask(this.bc).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.w }).a();
    }
    if (this.az == 22) {
      TroopReportor.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.w });
    }
    if ((this.az == 9) && (TextUtils.isEmpty(this.aA)) && (QLog.isColorLevel())) {
      QLog.e("Q.history.BaseFragment.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    if (this.az == 14)
    {
      this.bj = 7;
      this.bT = false;
    }
    this.H = paramView.getInt("param_chat_mode", 0);
    this.aC = paramView.getString("custom_title_name");
    paramBundle = paramView.getString("param_from");
    if (paramBundle != null) {
      try
      {
        this.az = Integer.parseInt(paramBundle);
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
      paramBundle.append(this.w);
      paramBundle.append(" troopUin=");
      paramBundle.append(this.v);
      paramBundle.append(" from=");
      paramBundle.append(this.az);
      QLog.d("Q.history.BaseFragment", 2, paramBundle.toString());
    }
    if (this.ay) {
      getBaseActivity().setTheme(2131952010);
    }
    paramBundle = (TroopManager)getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
    this.B = paramBundle.Z(this.w);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate, mIsQidianPrivateTroop = ");
      ((StringBuilder)localObject).append(this.B);
      ((StringBuilder)localObject).append(", mTroopUin = ");
      ((StringBuilder)localObject).append(this.w);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.ca == 0)
    {
      paramBundle = paramBundle.f(this.w);
      if (paramBundle != null) {
        this.ca = paramBundle.wMemberNum;
      }
    }
    try
    {
      this.bb = ThemeUtil.isDefaultTheme();
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (this.az == 15)
    {
      this.bj = 6;
      this.bL = paramView.getStringArrayList("param_seq_days");
      this.bK = paramView.getStringArrayList("param_seq_name");
    }
    int i = this.bj;
    if ((i == 1) || (i == 8)) {
      ((ITroopOnlineMemberHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER)).b(this.w);
    }
    this.ar = ((DiscussionHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    this.al = getBaseActivity().getLayoutInflater();
    this.I = getResources().getDisplayMetrics().density;
    paramView = (TroopManager)getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
    paramBundle = (DiscussionManager)getBaseActivity().app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if ((paramView != null) && (paramBundle != null))
    {
      i = this.az;
      boolean bool;
      if ((i != 1) && (i != 11) && (i != 16))
      {
        this.ai = paramView.f(this.w);
        this.aj.troopUin = this.w;
        paramView = this.ai;
        if ((paramView != null) && (paramView.isHomeworkTroop())) {
          bool = true;
        } else {
          bool = false;
        }
        this.u = bool;
        this.aj.updateForTroopInfo(this.ai, getBaseActivity().getCurrentAccountUin());
        paramView = this.ai;
        if (paramView != null)
        {
          this.v = paramView.troopcode;
          this.bE = TroopInfo.hasPayPrivilege(this.ai.troopPrivilegeFlag, 32);
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
        this.ak = paramBundle.d(this.w);
        this.v = this.w;
      }
      if (this.az == 5)
      {
        paramView = this.ai;
        if ((paramView != null) && (!paramView.isTroopOwner(this.bc.getCurrentAccountUin())))
        {
          getActivity().finish();
          return;
        }
      }
      paramView = (QBaseActivity)getActivity();
      i = this.az;
      if ((i != 1) && (i != 11) && (i != 16))
      {
        paramView.addObserver(this.bv, true);
        paramView.addObserver(this.bx, true);
        paramView.addObserver(this.bA, true);
        paramView.addObserver(this.bw, true);
        paramView.addObserver(this.by, true);
        paramView.addObserver(this.bz, true);
      }
      else
      {
        paramView.addObserver(this.bu);
      }
      if ((this.bF) && (this.az == 3)) {
        this.bj = 2;
      }
      int j;
      int m;
      if (this.az == 0)
      {
        paramView = getResources().getDisplayMetrics();
        i = Math.max(paramView.widthPixels, paramView.heightPixels);
        j = getBaseActivity().getTitleBarHeight();
        m = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
        int n = (int)(this.I * 60.0F);
        this.aX = getResources().getDimensionPixelSize(2131299998);
        this.aY = getResources().getDimensionPixelSize(2131297099);
        if (this.aY == 0) {
          this.aY = ((int)(paramView.density * 58.0F));
        }
        this.aW = (i - j - m - n);
        this.aZ = ((this.aW - this.aX) / this.aY);
        this.ba = new TroopMemberAddFrdHelper(getBaseActivity(), this.be, getBaseActivity().app, this.ai, this.J);
        if (QLog.isColorLevel()) {
          QLog.i("Q.history.BaseFragment", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.aW), Integer.valueOf(this.aX), Integer.valueOf(this.aY), Integer.valueOf(this.aZ) }));
        }
      }
      i = this.az;
      if (i != 1)
      {
        if (i == 11)
        {
          paramView = this.ak;
          if (paramView != null)
          {
            this.C = paramView.ownerUin;
            paramView = this.C;
            if ((paramView != null) && (paramView.equals(getBaseActivity().app.getCurrentAccountUin()))) {
              bool = true;
            } else {
              bool = false;
            }
            this.t = bool;
          }
          ReportController.b(getBaseActivity().app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
        }
        else
        {
          this.z = false;
          paramView = this.ai;
          if (paramView != null)
          {
            if (paramView.troopowneruin != null) {
              this.C = this.ai.troopowneruin;
            }
            if (this.ai.Administrator != null) {
              this.D = this.ai.Administrator;
            }
            if ((this.ai.troopowneruin == null) || (!this.ai.troopowneruin.equals(getBaseActivity().app.getCurrentAccountUin())))
            {
              paramView = this.D;
              if ((paramView == null) || (!paramView.contains(getBaseActivity().app.getCurrentAccountUin()))) {}
            }
            else
            {
              bool = true;
              break label1659;
            }
            bool = false;
            label1659:
            this.t = bool;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mTroopInfo==null");
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("doOnCreate, mTroopInfo admin: ");
            paramView.append(this.D);
            paramView.append("  owner:");
            paramView.append(this.C);
            QLog.d("Q.history.BaseFragment", 2, paramView.toString());
          }
        }
      }
      else
      {
        this.z = true;
        this.br = "";
        paramView = this.ak;
        if (paramView != null) {
          this.C = paramView.ownerUin;
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mDiscussionInfo==null");
        }
        paramView = this.C;
        if ((paramView != null) && (paramView.equals(this.bc.getCurrentAccountUin()))) {
          this.t = true;
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("doOnCreate, mDiscussionInfo owner: ");
          paramView.append(this.C);
          QLog.d("Q.history.BaseFragment", 2, paramView.toString());
        }
      }
      if (this.az == 21) {
        this.z = true;
      }
      paramView = this.ai;
      if ((paramView != null) && (paramView.isKingBattleTroop())) {
        this.bD = true;
      }
      paramView = getResources().getStringArray(2130968686);
      if (!this.bD)
      {
        this.bN = paramView;
      }
      else
      {
        this.bN = new String[paramView.length + 1];
        m = paramView.length;
        j = 0;
        i = 0;
        while (j < m)
        {
          paramBundle = paramView[j];
          this.bN[i] = paramBundle;
          j += 1;
          i += 1;
        }
        this.bN[i] = getResources().getString(2131917626);
      }
      paramView = getResources().getStringArray(2130968685);
      if (!this.bD)
      {
        this.bO = paramView;
      }
      else
      {
        this.bO = new String[paramView.length + 1];
        m = paramView.length;
        i = 0;
        j = k;
        while (j < m)
        {
          paramBundle = paramView[j];
          this.bO[i] = paramBundle;
          j += 1;
          i += 1;
        }
        this.bO[i] = getResources().getString(2131917627);
      }
      v();
      x();
      y();
      a();
      i = this.az;
      paramBundle = "1";
      if (i != 0)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
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
      localObject = this.C;
      if ((localObject != null) && (((String)localObject).equals(getBaseActivity().app.getCurrentAccountUin())))
      {
        paramBundle = "0";
      }
      else
      {
        localObject = this.D;
        if ((localObject == null) || (!((String)localObject).contains(getBaseActivity().app.getCurrentAccountUin()))) {
          paramBundle = "2";
        }
      }
      this.aK = paramBundle;
      a("exp", paramView, paramBundle);
      if (this.az == 14) {
        G();
      }
      if (this.az == 18) {
        ReportController.b(this.bc, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.w, "", "", "");
      }
      if (this.az == 3) {
        ((ITroopRobotHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(this.w);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    getBaseActivity().finish();
  }
  
  protected void v()
  {
    int i = this.az;
    if (i == 1)
    {
      this.Q.setText(getString(2131888749));
      this.T.setVisibility(4);
      this.N.setText(getString(2131889474));
      this.N.setVisibility(0);
      this.N.setContentDescription(getString(2131888751));
      this.N.setOnClickListener(this.bi);
    }
    else if (i == 2)
    {
      this.Q.setText(getString(2131886267));
      this.N.setVisibility(8);
      this.O.setVisibility(8);
      this.O.setImageResource(2130841087);
      this.P.setVisibility(0);
      this.T.setOnClickListener(new ChatHistoryTroopMemberFragment.6(this));
    }
    else if (i == 3)
    {
      this.Q.setText(getString(2131894265));
      this.T.setText(2131887648);
      this.N.setVisibility(8);
      this.O.setVisibility(8);
      this.O.setImageResource(2130841087);
      this.P.setVisibility(0);
      this.T.setOnClickListener(new ChatHistoryTroopMemberFragment.7(this));
    }
    else if (i == 11)
    {
      this.Q.setText(getString(2131894267));
      this.T.setText(2131887648);
      this.N.setVisibility(8);
      this.O.setVisibility(8);
      this.P.setVisibility(8);
      this.T.setOnClickListener(new ChatHistoryTroopMemberFragment.8(this));
    }
    else if (i == 5)
    {
      this.Q.setText(getString(2131894078));
      if (this.ah == null) {
        this.ah = getString(2131887625);
      }
      this.T.setOnClickListener(this.bi);
      this.O.setVisibility(8);
      this.P.setVisibility(0);
      this.O.setImageResource(2130841087);
    }
    else if ((i != 14) && (i != 16))
    {
      if (i == 15)
      {
        this.Q.setText(2131917569);
        this.N.setText(2131888824);
        this.N.setVisibility(0);
        this.N.setOnClickListener(this.bh);
        this.T.setOnClickListener(this.bi);
        this.O.setVisibility(8);
        this.P.setVisibility(8);
      }
      else if ((i != 12) && (i != 20) && (i != 21))
      {
        if (i == 18)
        {
          this.Q.setText(2131917404);
          this.N.setVisibility(8);
          this.T.setOnClickListener(this.bi);
          this.P.setVisibility(8);
          this.O.setVisibility(8);
        }
        else if (i == 19)
        {
          this.O.setVisibility(8);
          this.P.setVisibility(8);
          this.Q.setText(HardCodeUtil.a(2131899871));
          this.T.setOnClickListener(new ChatHistoryTroopMemberFragment.9(this));
        }
        else if (i == 23)
        {
          this.Q.setText(2131917404);
          this.N.setVisibility(8);
          this.T.setOnClickListener(this.bi);
          this.P.setVisibility(8);
          this.O.setVisibility(8);
        }
        else
        {
          this.Q.setText(HardCodeUtil.a(2131899864));
          localObject = this.aC;
          if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            this.Q.setText(this.aC);
          }
          if (this.ah == null) {
            this.ah = getString(2131887625);
          }
          this.T.setOnClickListener(this.bi);
          this.N.setVisibility(8);
          this.N.setText(2131889474);
          if (this.az != 4)
          {
            this.O.setVisibility(0);
            this.O.setImageResource(2130841087);
            this.O.setContentDescription(getString(2131895296));
            if (this.az != 22) {
              this.P.setVisibility(0);
            }
          }
          else
          {
            this.O.setVisibility(8);
            this.P.setVisibility(8);
          }
        }
      }
      else
      {
        localObject = this.aD;
        if (localObject != null) {
          this.Q.setText((CharSequence)localObject);
        }
        this.T.setOnClickListener(this.bi);
        this.O.setVisibility(8);
        this.P.setVisibility(8);
        if (this.aE == 1)
        {
          this.N.setVisibility(8);
        }
        else
        {
          this.N.setText(getString(2131889474));
          this.N.setVisibility(0);
          this.N.setContentDescription(getString(2131888751));
        }
      }
    }
    else
    {
      localObject = this.aC;
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.Q.setText(this.aC);
      }
      this.T.setVisibility(8);
      this.O.setVisibility(8);
      this.P.setVisibility(8);
      this.N.setText(2131895057);
      this.N.setVisibility(0);
      this.N.setOnClickListener(this.bi);
    }
    if (this.P.getVisibility() == 0)
    {
      this.R.setVisibility(0);
      i = this.bj;
      if (i >= 0)
      {
        localObject = this.bO;
        if (i < localObject.length) {
          this.R.setText(localObject[i]);
        }
      }
    }
    else
    {
      this.R.setVisibility(8);
    }
    if (this.bj == 8)
    {
      this.R.setVisibility(0);
      this.R.setText(HardCodeUtil.a(2131899857));
    }
    if (this.az == 14) {
      this.R.setVisibility(8);
    }
    this.S.setFocusable(true);
    Object localObject = this.S;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.Q.getText().toString());
    localStringBuilder.append(this.R.getText().toString());
    ((LinearLayout)localObject).setContentDescription(localStringBuilder.toString());
  }
  
  protected void w()
  {
    int i = this.az;
    if ((i == 2) || (i == 3) || (i == 11) || (i == 0) || (i == 17) || (i == 5) || (i == 9) || (i == 22))
    {
      if ((this.az == 9) && (this.aB == 1))
      {
        this.O.setVisibility(8);
        this.P.setVisibility(8);
        return;
      }
      this.O.setOnClickListener(new ChatHistoryTroopMemberFragment.12(this));
      this.P.setOnClickListener(new ChatHistoryTroopMemberFragment.13(this));
    }
    i = this.az;
    if ((i != 0) && (i != 9) && (i != 17) && (i != 22))
    {
      if (i == 7)
      {
        this.O.setVisibility(8);
        this.P.setVisibility(8);
      }
      else if ((i != 12) && (i != 20))
      {
        if (i == 21) {
          this.N.setOnClickListener(new ChatHistoryTroopMemberFragment.16(this));
        } else if (i == 22) {
          this.P.setVisibility(8);
        }
      }
      else
      {
        this.N.setOnClickListener(new ChatHistoryTroopMemberFragment.15(this));
      }
    }
    else {
      this.N.setOnClickListener(new ChatHistoryTroopMemberFragment.14(this));
    }
    if ((this.B) && (!this.t))
    {
      TroopInfo localTroopInfo = this.ai;
      if ((localTroopInfo == null) || (!localTroopInfo.mMemberInvitingFlag) || (this.ai.cGroupOption == 3)) {
        this.O.setVisibility(8);
      }
    }
  }
  
  protected void x()
  {
    View localView = getBaseActivity().getLayoutInflater().inflate(2131629588, this.s, false);
    this.V = ((RelativeLayout)localView.findViewById(2131445383));
    this.Y = ((RelativeLayout)localView.findViewById(2131428273));
    this.Y.setVisibility(8);
    if (ThemeUtil.isDefaultTheme()) {
      this.Y.setBackgroundResource(2130839577);
    } else {
      this.Y.setBackgroundResource(2130839574);
    }
    Object localObject1 = (TextView)this.Y.findViewById(2131448598);
    this.aH = ((LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin;
    if ((this.az == 3) && (this.t) && (this.H != 1)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((this.az == 11) && (this.t)) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject2;
    if ((i != 0) || (j != 0))
    {
      localObject2 = getString(2131917558);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = (TextView)this.Y.findViewById(2131444603);
      ((TextView)localObject1).setText("");
      ((ImageView)this.Y.findViewById(2131436404)).setBackgroundDrawable(ImageUtil.b());
      Object localObject3 = (ImageView)this.Y.findViewById(2131440982);
      ((ImageView)localObject3).setVisibility(8);
      if (i != 0)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setOnClickListener(new ChatHistoryTroopMemberFragment.17(this));
        ((TextView)localObject1).setTextSize(12.0F);
      }
      this.Y.setOnClickListener(new ChatHistoryTroopMemberFragment.18(this, (String)localObject2));
      if (!this.bF)
      {
        this.Y.setVisibility(0);
        this.Y.setEnabled(false);
      }
      localObject2 = (ITroopMessageHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_MESSAGE_HANDLER);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.makeText(getBaseActivity(), 1, 2131892102, 0).show(getBaseActivity().getTitleBarHeight());
      }
      else
      {
        localObject3 = this.ar;
        if ((localObject3 != null) && (this.az == 11)) {
          ((DiscussionHandler)localObject3).b(getBaseActivity().app.getCurrentAccountUin(), this.v);
        } else if (localObject2 != null) {
          ((ITroopMessageHandler)localObject2).a(this.bc.getCurrentAccountUin(), this.w);
        }
        this.ag = getResources().getDrawable(2130839590);
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(this.ag, null, null, null);
        ((Animatable)this.ag).start();
      }
    }
    if ((this.az == 3) && (!this.t) && (this.H != 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.az == 11) && (!this.t)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((this.aj.isNewTroop) && ((i != 0) || (j != 0)))
    {
      localObject1 = (ITroopMessageHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_MESSAGE_HANDLER);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.makeText(getBaseActivity(), 1, 2131892102, 0).show(getBaseActivity().getTitleBarHeight());
      }
      else
      {
        localObject2 = this.ar;
        if ((localObject2 != null) && (this.az == 11)) {
          ((DiscussionHandler)localObject2).b(getBaseActivity().app.getCurrentAccountUin(), this.v);
        } else if (localObject1 != null) {
          ((ITroopMessageHandler)localObject1).a(this.bc.getCurrentAccountUin(), this.w);
        }
      }
    }
    localObject1 = (EditText)this.V.findViewById(2131432634);
    ((Button)this.V.findViewById(2131429816)).setVisibility(8);
    int i = this.az;
    if (i == 19)
    {
      localView = getBaseActivity().getLayoutInflater().inflate(2131629580, this.s, false);
      localView.setOnClickListener(new ChatHistoryTroopMemberFragment.19(this));
      this.s.addHeaderView(localView);
    }
    else if ((i != 9) && (i != 15))
    {
      this.s.addHeaderView(localView);
    }
    this.K = new ChatHistoryTroopMemberFragment.ListAdapter(this);
    this.s.setAdapter(this.K);
    i = this.az;
    if ((i == 19) || (i == 21)) {
      this.V.setVisibility(8);
    }
    i = this.az;
    if ((i != 9) && (i != 19)) {
      M();
    }
    ((EditText)localObject1).setOnTouchListener(new ChatHistoryTroopMemberFragment.20(this));
    this.af.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.af.setOnIndexChangedListener(this);
    if (this.az == 11) {
      this.af.setOnIndexChangedListener2(this);
    }
  }
  
  protected void y()
  {
    P();
    int i = this.az;
    if (i == 9)
    {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.26(this), 8, null, true);
      return;
    }
    Object localObject1;
    if ((i != 15) && (i != 1) && (i != 11) && (i != 16))
    {
      localObject1 = this.bn;
      ((Handler)localObject1).sendMessage(((Handler)localObject1).obtainMessage(13));
      localObject1 = null;
    }
    else
    {
      localObject1 = new ChatHistoryTroopMemberFragment.27(this);
    }
    i = this.az;
    Object localObject4;
    long l1;
    long l2;
    if ((i != 11) && (i != 1) && (i != 16) && (NetworkUtil.isNetworkAvailable(getActivity())))
    {
      Object localObject2 = getActivity();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("last_update_time");
      ((StringBuilder)localObject4).append(this.bc.getCurrentAccountUin());
      localObject2 = ((FragmentActivity)localObject2).getSharedPreferences(((StringBuilder)localObject4).toString(), 4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_time");
      ((StringBuilder)localObject4).append(this.w);
      l1 = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject4).toString(), 0L);
      l2 = Math.abs(System.currentTimeMillis() - l1);
      localObject4 = this.ai;
      if (localObject4 != null) {
        i = ((TroopInfo)localObject4).wMemberNum;
      } else {
        i = 0;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_num");
      ((StringBuilder)localObject4).append(this.w);
      int j = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject4).toString(), 0);
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_last_update_num");
      ((StringBuilder)localObject4).append(this.w);
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
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (ITroopMemberListHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      if (localObject2 != null)
      {
        this.ao = true;
        this.aI = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, this.w, this.v, true, Q(), this.aI, 0);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("fillData, ITroopMemberListHandler.getTroopMemberList(), troopUin: ");
          ((StringBuilder)localObject4).append(this.v);
          ((StringBuilder)localObject4).append(" troopCode: ");
          ((StringBuilder)localObject4).append(this.w);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject4).toString());
        }
      }
      if (localObject2 != null) {
        try
        {
          ((ITroopMemberListHandler)localObject2).a(Long.parseLong(this.w), 0L, 1, 0, 0);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.history.BaseFragment", 2, localException.toString());
          }
        }
      }
    }
    if (this.az == 3)
    {
      Object localObject3 = getActivity();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("last_update_time");
      ((StringBuilder)localObject4).append(this.bc.getCurrentAccountUin());
      localObject3 = ((FragmentActivity)localObject3).getSharedPreferences(((StringBuilder)localObject4).toString(), 4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_troop_info_last_update");
      ((StringBuilder)localObject4).append(this.w);
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
        localObject3 = (ITroopInfoHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
        localObject4 = (ITroopMemberListHandler)this.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
        if ((localObject4 != null) && (localObject3 != null))
        {
          this.aJ = System.currentTimeMillis();
          ((ITroopInfoHandler)localObject3).a(this.w);
          ((ITroopMemberListHandler)localObject4).a(1, TroopFileHandler.a(this.w), 0L, 2, 0, 0, true);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("fillData, getGroupInfoReq, mTroopUin:");
            ((StringBuilder)localObject3).append(this.w);
            QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    if (localObject1 != null) {
      ThreadManager.post((Runnable)localObject1, 8, null, true);
    }
    if (this.az == 14) {
      ((TroopGiftManager)this.bc.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(this.w, new ChatHistoryTroopMemberFragment.28(this));
    }
  }
  
  protected void z()
  {
    String[] arrayOfString;
    if (this.az == 9) {
      arrayOfString = getResources().getStringArray(2130968680);
    } else {
      arrayOfString = getResources().getStringArray(2130968678);
    }
    int i = this.az;
    if ((i != 0) && (i != 17) && (i != 22))
    {
      if (i == 9) {
        i = arrayOfString.length;
      } else {
        i = arrayOfString.length - 5;
      }
    }
    else if (this.t)
    {
      i = arrayOfString.length;
    }
    else
    {
      TroopInfo localTroopInfo = this.ai;
      if ((localTroopInfo != null) && (localTroopInfo.mMemberInvitingFlag))
      {
        if (this.ai.cGroupOption != 3)
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
    this.am = ActionSheet.create(getBaseActivity());
    int j = 0;
    while (j < i)
    {
      if (this.B)
      {
        if ((!HardCodeUtil.a(2131899820).equals(arrayOfString[j])) && (j == 2))
        {
          this.am.addButton(arrayOfString[j]);
          break;
        }
      }
      else if (j == 3)
      {
        this.am.addButton(arrayOfString[j], 3);
      }
      else
      {
        this.am.addButton(arrayOfString[j]);
        if (arrayOfString[j].equals(HardCodeUtil.a(2131899903))) {
          ReportController.b(getBaseActivity().app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.w, "", "", "");
        }
      }
      j += 1;
    }
    if ((!this.t) && (this.aj.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
      this.am.addButton(arrayOfString[3], 3);
    }
    this.am.addCancelButton(2131887648);
    this.am.setOnButtonClickListener(this.bl);
    this.am.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment
 * JD-Core Version:    0.7.0.1
 */