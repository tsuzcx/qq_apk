package com.tencent.mobileqq.activity.history;

import aepi;
import aibp;
import aibq;
import aibs;
import aibt;
import aibu;
import aibv;
import aibw;
import aibx;
import aiby;
import aibz;
import aica;
import aicb;
import aicd;
import aice;
import aicf;
import aicg;
import aich;
import aici;
import aick;
import aicl;
import aicm;
import aicn;
import aico;
import aicp;
import aicq;
import aicr;
import aics;
import aict;
import aicu;
import aicv;
import aicw;
import aicx;
import aicy;
import aicz;
import aida;
import aidb;
import aidc;
import aidd;
import aide;
import aidf;
import aidh;
import aidj;
import aidk;
import aidl;
import aidm;
import aidv;
import aidx;
import aloz;
import alri;
import alrk;
import alrl;
import alto;
import alud;
import amca;
import amdu;
import ameq;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.support.v4.app.FragmentActivity;
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
import awrt;
import azmk;
import azqs;
import azqx;
import bamb;
import bbtx;
import bbty;
import bckt;
import bcod;
import bcpg;
import bdes;
import bdeu;
import bdgc;
import bdhj;
import bdin;
import bdrv;
import beqq;
import beqr;
import bhuf;
import bhuk;
import bhuw;
import bhzx;
import biaa;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TroopAdmin;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.troop.TroopFileProxyActivity;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mzy;
import nac;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;
import xsm;

public class ChatHistoryTroopMemberFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, beqq, beqr, bhuw
{
  public static double b;
  private static int p;
  public double a;
  public float a;
  public int a;
  public long a;
  public aidh a;
  public aidj a;
  public aidv a;
  aidx jdField_a_of_type_Aidx = new aibp(this);
  protected alri a;
  public alrl a;
  public ameq a;
  protected Drawable a;
  public LayoutInflater a;
  public View.OnClickListener a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  protected RelativeLayout a;
  public TextView a;
  public bhuf a;
  protected bhuk a;
  public bhzx a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public TroopInfoData a;
  public IndexView a;
  public PinnedDividerSwipListView a;
  public XListView a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  public ArrayList<String> a;
  public List<aidf> a;
  private long[] jdField_a_of_type_ArrayOfLong;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  public long b;
  public Handler b;
  public View.OnClickListener b;
  public View b;
  public ImageView b;
  public LinearLayout b;
  protected RelativeLayout b;
  public TextView b;
  public QQAppInterface b;
  public String b;
  public ArrayList<String> b;
  public List<aidf> b;
  private long[] jdField_b_of_type_ArrayOfLong;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  public int c;
  private long jdField_c_of_type_Long;
  public Dialog c;
  private Handler jdField_c_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  public View.OnClickListener c;
  protected View c;
  protected RelativeLayout c;
  public TextView c;
  public String c;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<DiscussionMemberInfo> c;
  private long[] jdField_c_of_type_ArrayOfLong;
  public int d;
  private long jdField_d_of_type_Long;
  public Dialog d;
  public View.OnClickListener d;
  protected View d;
  public RelativeLayout d;
  public TextView d;
  protected String d;
  private ArrayList<String> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public List<String> d;
  public boolean d;
  protected int e;
  protected View e;
  protected RelativeLayout e;
  protected TextView e;
  protected String e;
  private ArrayList<String> e;
  public List<String> e;
  public boolean e;
  protected int f;
  protected View f;
  public String f;
  private ArrayList<String> f;
  protected List<String> f;
  public boolean f;
  protected int g;
  private View jdField_g_of_type_AndroidViewView;
  public String g;
  private ArrayList<String> jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  private List<oidb_cmd0x74f.Range> jdField_g_of_type_JavaUtilList = new ArrayList();
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  protected String i;
  public boolean i;
  public int j;
  protected String j;
  protected boolean j;
  public int k;
  protected String k;
  public boolean k;
  public int l;
  protected String l;
  protected boolean l;
  public int m;
  public String m;
  protected boolean m;
  private int n;
  public String n;
  public boolean n;
  private int o;
  public String o;
  public boolean o;
  protected String p;
  public boolean p;
  public final String q;
  private boolean q;
  public final String r;
  private boolean r;
  public final String s;
  private boolean s;
  protected String t;
  private boolean t;
  public String u;
  private boolean u;
  public String v;
  private boolean v;
  protected String w;
  private String x = alud.a(2131702028);
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
    jdField_p_of_type_Int = 1000;
  }
  
  public ChatHistoryTroopMemberFragment()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 2147483647;
    this.jdField_o_of_type_JavaLangString = "2";
    this.jdField_p_of_type_JavaLangString = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
    this.jdField_q_of_type_JavaLangString = "param_seq_name";
    this.jdField_r_of_type_JavaLangString = "param_seq_days";
    this.jdField_s_of_type_JavaLangString = "param_deleted_uins";
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_t_of_type_Boolean = true;
    this.jdField_l_of_type_Int = 50;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aibq(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aibs(this);
    this.jdField_m_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_a_of_type_Bhuk = new aici(this);
    this.jdField_b_of_type_AndroidOsHandler = new aico(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new aicp(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_n_of_type_Int = -1;
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new aicq(this);
    this.jdField_a_of_type_Alrl = new aicu(this);
    this.jdField_a_of_type_Ameq = new aicv(this);
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_Bhzx == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        biaa localbiaa = new biaa();
        localbiaa.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localbiaa.jdField_a_of_type_Int = i1;
        localbiaa.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localArrayList.add(localbiaa);
        i1 += 1;
      }
      this.jdField_a_of_type_Bhzx = bhzx.a(getActivity(), localArrayList, new aict(this), null, xsm.a(getActivity(), 135.0F), false);
      this.jdField_a_of_type_Bhzx.setTouchInterceptor(new aida(this));
      c(this.jdField_m_of_type_Int);
    }
    this.jdField_a_of_type_Bhzx.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(xsm.a(getActivity(), 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
  }
  
  private void E()
  {
    if (((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.contains(getActivity().app.getCurrentAccountUin()))) || ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(getActivity().app.getCurrentAccountUin())))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((!this.jdField_h_of_type_Boolean) && (i1 != 0) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 17)) && (System.currentTimeMillis() > this.jdField_c_of_type_Long)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.21(this), 8, null, true);
      }
      return;
    }
  }
  
  private void F()
  {
    if (this.jdField_g_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_g_of_type_AndroidViewView = getActivity().getLayoutInflater().inflate(2131562769, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131368210);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
    Iterator localIterator = this.jdField_g_of_type_JavaUtilList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (oidb_cmd0x74f.Range)localIterator.next();
      this.jdField_d_of_type_JavaUtilArrayList.add(String.valueOf(((oidb_cmd0x74f.Range)localObject).uint32_days.get()));
      this.jdField_c_of_type_JavaUtilArrayList.add(((oidb_cmd0x74f.Range)localObject).string_name.get());
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      localObject = (aidf)localIterator.next();
      if (((aidf)localObject).jdField_b_of_type_Long == 0L) {
        ((aidf)localObject).jdField_b_of_type_Long = ((aidf)localObject).jdField_a_of_type_Long;
      }
      if (TextUtils.isEmpty(a(((aidf)localObject).jdField_b_of_type_Long, localCalendar, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
        break label362;
      }
      i1 += 1;
    }
    label362:
    for (;;)
    {
      break;
      localTextView.setText(i1 + "");
      if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(getActivity().app.getCurrentAccountUin()))) {}
      for (int i2 = 0;; i2 = 1)
      {
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(new aicd(this, i1, i2));
        G();
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_g_of_type_AndroidViewView);
        azqs.b(getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.jdField_c_of_type_JavaLangString, "" + i2, "", "");
        return;
      }
    }
  }
  
  private void G()
  {
    Object localObject;
    DisplayMetrics localDisplayMetrics;
    if ((this.jdField_g_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView != null))
    {
      localObject = this.jdField_g_of_type_AndroidViewView.findViewById(2131375794);
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          localDisplayMetrics = getResources().getDisplayMetrics();
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0) {
            break label83;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 26.0F));
        }
      }
    }
    return;
    label83:
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(localDisplayMetrics.density * 18.0F));
  }
  
  private void H()
  {
    this.jdField_d_of_type_AndroidAppDialog = new Dialog(getActivity());
    this.jdField_d_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_d_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_d_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_d_of_type_AndroidAppDialog.setContentView(2131562591);
    Object localObject = this.jdField_d_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_d_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getActivity().getSystemService("input_method");
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT < 24))
    {
      this.jdField_d_of_type_AndroidAppDialog.getWindow().addFlags(67108864);
      int i1 = getResources().getColor(2131166959);
      new SystemBarCompact(this.jdField_d_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_d_of_type_AndroidAppDialog.findViewById(2131376034);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131376220));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838592));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aidj = new aidj(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aidj);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new aice(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131365851));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aidl(this));
    this.jdField_d_of_type_AndroidViewView = this.jdField_d_of_type_AndroidAppDialog.findViewById(2131376034);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131367817));
    this.jdField_c_of_type_AndroidViewView = this.jdField_d_of_type_AndroidAppDialog.findViewById(2131371205);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131375722));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aicf(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aicg(this));
  }
  
  private void I()
  {
    int i1 = this.jdField_a_of_type_Aidh.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format(alud.a(2131702003), new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aick(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131702015));
  }
  
  private void J()
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
    if ((this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(alud.a(2131702025), new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(alud.a(2131701993), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 3))
    {
      this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_Aidh.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_Aidh.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        E();
        v();
        if (this.jdField_a_of_type_Aidh == null) {
          break label302;
        }
        this.jdField_a_of_type_Aidh.notifyDataSetChanged();
        this.jdField_a_of_type_Aidh.a();
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setVisibility(0);
        if ((!this.jdField_j_of_type_Boolean) || (this.jdField_d_of_type_Int == 11)) {
          y();
        }
        r();
        return;
        if ((paramMessage == null) || (paramMessage.length != 1)) {
          break;
        }
        try
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
          QLog.d(".troop.troopManagerVASH", 2, new Object[] { "refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
          break;
        }
        finally {}
      }
      label302:
      this.jdField_a_of_type_Aidh = new aidh(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Aidh);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, nac paramnac)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    mzy.b(paramQQAppInterface, paramnac, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void a(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    Dialog localDialog = new Dialog(getActivity(), 2131755801);
    localDialog.setContentView(2131559077);
    ((TextView)localDialog.findViewById(2131365237)).setText(getString(2131691590));
    TextView localTextView = (TextView)localDialog.findViewById(2131365233);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131364244);
    Object localObject;
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
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1))
    {
      bool = true;
      if (paramList.size() != 1) {
        break label294;
      }
      localTextView.setText(getString(2131693828));
      localCheckBox.setText(getString(2131719174));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localTextView = (TextView)localDialog.findViewById(2131365222);
      localObject = (TextView)localDialog.findViewById(2131365228);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new aicr(this, localDialog));
      ((TextView)localObject).setOnClickListener(new aics(this, paramList, localCheckBox, bool, localDialog));
      localDialog.show();
      return;
      bool = false;
      break;
      label294:
      localTextView.setText(getString(2131694620));
      localCheckBox.setText(getString(2131694622));
    }
  }
  
  private void a(List<TroopMemberInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "processConvertTroopMemberInfo2AtTroopMember, processIndex:" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    alto localalto = (alto)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    bcpg localbcpg = (bcpg)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!bdeu.d(localTroopMemberInfo.memberuin)) {
          break label244;
        }
        if ((this.jdField_d_of_type_Int != 2) || ((!localTroopMemberInfo.memberuin.equals(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_g_of_type_JavaLangString.contains(localTroopMemberInfo.memberuin)))) {
          break label165;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label165:
        if (((this.jdField_f_of_type_JavaUtilList == null) || (!this.jdField_f_of_type_JavaUtilList.contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localbcpg.b(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localalto));
          continue;
          label244:
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:" + localTroopMemberInfo.memberuin);
          }
        }
      }
    }
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(12, localArrayList);
    paramList.arg1 = paramInt;
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if ((this.jdField_d_of_type_Int == 3) && (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int != 1))
    {
      i1 = 1;
      if ((!this.jdField_d_of_type_Boolean) && (paramBoolean3) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
      {
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378896);
        localObject1 = getString(2131721077);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375631);
        ((TextView)localObject2).setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368796)).setBackgroundDrawable(bdhj.d());
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372562);
        ((ImageView)localObject3).setVisibility(8);
        if (i1 != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new aicw(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aicx(this, (String)localObject1));
        if (!this.jdField_s_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onGetAtAllRemianCountInfo:" + paramBoolean1 + ", " + paramString1 + ", " + paramBoolean2 + ", " + paramInt1 + ", " + paramString2 + ", " + paramString3);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375631)).setCompoundDrawables(null, null, null, null);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(true);
        if ((paramBoolean1) && (paramString1 != null)) {
          break label390;
        }
      }
    }
    label390:
    do
    {
      return;
      i1 = 0;
      break;
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378896)).setTextColor(getResources().getColor(2131166903));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375631);
      localObject2 = alud.a(2131701987);
      localObject3 = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371390);
      ((Button)localObject3).setVisibility(8);
      ((Button)localObject3).setOnClickListener(new aicy(this));
      i1 = ((amca)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
      if (this.jdField_d_of_type_Int != 11) {
        break label773;
      }
    } while (!paramString1.equals(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Int = paramInt2;
    if ((paramBoolean2) && (paramInt1 > 0))
    {
      paramBoolean1 = true;
      label528:
      this.jdField_i_of_type_Boolean = paramBoolean1;
      if (!this.jdField_i_of_type_Boolean) {
        break label678;
      }
      this.jdField_h_of_type_JavaLangString = (alud.a(2131702035) + paramInt1 + alud.a(2131702053));
      ((TextView)localObject1).setText(this.jdField_h_of_type_JavaLangString);
      paramString1 = (String)localObject2 + "," + this.jdField_h_of_type_JavaLangString;
      label615:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        paramString2.rightMargin = aepi.a(20.0F, getResources());
        ((TextView)localObject1).setLayoutParams(paramString2);
      }
    }
    for (paramString2 = paramString1;; paramString2 = (String)localObject2 + "," + paramString1)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramString2);
      return;
      paramBoolean1 = false;
      break label528;
      label678:
      if (paramInt1 == 0)
      {
        this.jdField_h_of_type_JavaLangString = alud.a(2131702042);
        paramString1 = (String)localObject2 + ",剩余0次";
        ((TextView)localObject1).setText("剩余0次");
        break label615;
      }
      this.jdField_h_of_type_JavaLangString = "";
      paramString1 = (String)localObject2 + "," + alud.a(2131702033);
      ((TextView)localObject1).setText("");
      break label615;
      label773:
      if (!paramString1.equals(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      this.jdField_i_of_type_Boolean = paramBoolean2;
      this.jdField_h_of_type_JavaLangString = paramString3;
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("Q.history.BaseFragment", 1, "updateUIForAtAllRemainedCount remainTips empty");
        return;
      }
      paramString1 = paramString2;
      if (!this.jdField_i_of_type_Boolean)
      {
        paramString1 = paramString2;
        if (i1 != 3)
        {
          ((Button)localObject3).setVisibility(0);
          paramString2 = paramString2 + ",\n超级会员可继续使用";
          ((TextView)localObject1).setGravity(21);
          ((TextView)localObject1).setLineSpacing(this.jdField_a_of_type_Float * 5.0F, 1.0F);
          paramInt1 = (int)(alud.a(2131702060).length() * 12 * this.jdField_a_of_type_Float);
          new DisplayMetrics();
          paramInt2 = (int)(getResources().getDisplayMetrics().widthPixels - 227.0F * this.jdField_a_of_type_Float - 5.0F * this.jdField_a_of_type_Float);
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
      }
      paramString2 = new SpannableString(paramString1);
      paramString3 = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
      if (!TextUtils.isEmpty(paramString3))
      {
        paramInt1 = paramString1.indexOf(paramString3);
        paramInt2 = paramString3.length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      if (paramString1.contains(alud.a(2131702043)))
      {
        paramInt1 = paramString1.indexOf(alud.a(2131701979));
        paramInt2 = alud.a(2131702057).length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      ((TextView)localObject1).setText(paramString2);
    }
  }
  
  private boolean a()
  {
    int i1;
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 14))
    {
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
        break label85;
      }
      long l1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      if ((l1 != 10009L) && (l1 != 10010L) && (l1 != 10011L)) {
        break label85;
      }
    }
    label85:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 != 0) && (i2 != 0))
      {
        return true;
        i1 = 0;
        break;
      }
      return false;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, TextView paramTextView, View paramView, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramTextView == null) || (paramView == null) || (TextUtils.isEmpty(paramString))) {}
    int i1;
    do
    {
      do
      {
        do
        {
          return;
        } while (!((bcpg)paramQQAppInterface.getManager(203)).b(paramString));
        int i2 = paramView.getWidth();
        i1 = i2;
        if (i2 == 0)
        {
          paramView.measure(0, 0);
          i1 = paramView.getMeasuredWidth();
        }
        if (i1 != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.history.BaseFragment", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
      return;
      paramInt -= i1;
      if (paramInt > 0) {
        paramTextView.setMaxWidth(paramInt);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.BaseFragment", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:" + i1 + " nTargetMaxWidth:" + paramInt);
  }
  
  private void c(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bhzx.getContentView().findViewById(2131364771);
    int i1 = 0;
    if (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      biaa localbiaa = (biaa)((View)localObject).getTag();
      if (localbiaa != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131377774);
        if (localObject != null)
        {
          if (localbiaa.jdField_a_of_type_Int != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131166914));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131166903));
      }
    }
  }
  
  private int d()
  {
    int i1 = 1;
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_s_of_type_Boolean) {
        i1 = 3;
      }
      return i1;
      i1 = 2;
    }
  }
  
  protected void A()
  {
    ThreadManager.post(new ChatHistoryTroopMemberFragment.45(this), 8, null, true);
    a("Clk_invite", this.jdField_o_of_type_JavaLangString, "");
  }
  
  void B()
  {
    if (!this.jdField_r_of_type_Boolean)
    {
      ViewStub localViewStub = (ViewStub)a(2131378496);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131378497)).setOnTouchListener(new aicz(this));
      }
    }
  }
  
  public void C()
  {
    if (!getActivity().isResume()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Aidh != null) {}
      try
      {
        this.jdField_a_of_type_Aidh.notifyDataSetChanged();
        if (this.jdField_a_of_type_Aidj == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_Aidj.notifyDataSetChanged();
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  public aidf a(DiscussionMemberInfo paramDiscussionMemberInfo, alto paramalto)
  {
    aidf localaidf = new aidf();
    localaidf.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramalto != null) {
      localFriends = paramalto.b(paramDiscussionMemberInfo.memberUin);
    }
    localaidf.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localaidf.jdField_a_of_type_Short = 0;
    localaidf.jdField_c_of_type_JavaLangString = ChnToSpell.a(localaidf.jdField_b_of_type_JavaLangString, 2);
    localaidf.a(ChnToSpell.a(localaidf.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localaidf.e(localFriends.remark);
      localaidf.h(ChnToSpell.a(localaidf.jdField_j_of_type_JavaLangString, 1));
      localaidf.f(ChnToSpell.a(localaidf.jdField_j_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localaidf.i(paramDiscussionMemberInfo.memberName);
        localaidf.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localaidf.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      if (this.jdField_a_of_type_Aidv != null) {
        this.jdField_a_of_type_Aidv.a(localaidf);
      }
      return localaidf;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localaidf.e(paramDiscussionMemberInfo.inteRemark);
        localaidf.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localaidf.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public aidf a(TroopMemberInfo paramTroopMemberInfo, alto paramalto)
  {
    aidf localaidf = new aidf();
    localaidf.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramalto != null) {
      localFriends = paramalto.b(paramTroopMemberInfo.memberuin);
    }
    localaidf.jdField_b_of_type_JavaLangString = bdgc.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, localaidf.jdField_a_of_type_JavaLangString, true);
    localaidf.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localaidf.jdField_c_of_type_JavaLangString = ChnToSpell.a(localaidf.jdField_b_of_type_JavaLangString, 2);
    localaidf.a(ChnToSpell.a(localaidf.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localaidf.b(paramTroopMemberInfo.friendnick);
      localaidf.d(paramTroopMemberInfo.pyAll_friendnick);
      localaidf.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localaidf.e(localFriends.remark);
      localaidf.h(ChnToSpell.a(localaidf.jdField_j_of_type_JavaLangString, 1));
      localaidf.f(ChnToSpell.a(localaidf.jdField_j_of_type_JavaLangString, 2));
      localaidf.g(localFriends.remark);
      if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
      {
        localaidf.i(paramTroopMemberInfo.troopColorNick);
        localaidf.k(paramTroopMemberInfo.pyAll_troopnick);
        localaidf.j(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localaidf.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localaidf.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localaidf.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localaidf.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
      localaidf.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localaidf.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localaidf.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localaidf.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      localaidf.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_c_of_type_JavaLangString, localaidf.jdField_a_of_type_JavaLangString);
      if ((d1 == -1000.0D) || (d1 == -100.0D)) {
        break label695;
      }
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
      if (d1 <= 10.0D) {
        break label660;
      }
      localaidf.jdField_t_of_type_JavaLangString = ((int)d1 + "km");
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localaidf.jdField_u_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localaidf.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if (this.jdField_a_of_type_Aidv != null) {
        this.jdField_a_of_type_Aidv.a(localaidf);
      }
      localaidf.jdField_e_of_type_Int = paramTroopMemberInfo.mVipType;
      localaidf.jdField_f_of_type_Int = paramTroopMemberInfo.mVipLevel;
      localaidf.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localaidf.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
      localaidf.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
      localaidf.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      return localaidf;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.jdField_h_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localaidf.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localaidf.h(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localaidf.f(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
        break;
      }
      localaidf.e(paramTroopMemberInfo.autoremark);
      localaidf.h(paramTroopMemberInfo.pyAll_autoremark);
      localaidf.f(paramTroopMemberInfo.pyFirst_autoremark);
      break;
      label660:
      localaidf.jdField_t_of_type_JavaLangString = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
      continue;
      label695:
      localaidf.jdField_t_of_type_JavaLangString = "";
    }
  }
  
  public aidf a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "removeItem:" + paramString);
    }
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          aidf localaidf = (aidf)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localaidf != null) && (localaidf.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (aidf)this.jdField_a_of_type_JavaUtilList.remove(i1);
            return paramString;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public aidm a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    int i2;
    int i1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
      i2 = ((ViewGroup)localObject1).getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label134;
      }
      Object localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof aidm)))
      {
        localObject2 = (aidm)((View)localObject2).getTag();
        if ((((aidm)localObject2).jdField_a_of_type_JavaLangString != null) && (((aidm)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "findListItemHolderByUin:" + i1);
          }
          return localObject2;
          localObject1 = this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView;
          break;
        }
      }
      i1 += 1;
    }
    label134:
    return null;
  }
  
  public String a(long paramLong, Calendar paramCalendar, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList2.size() == 0) || (paramArrayList1.size() == 0)) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
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
    return null;
  }
  
  public List<aidf> a(List<aidf> paramList, String paramString1, String paramString2)
  {
    int i5 = 1;
    int i6 = paramList.size();
    int i3;
    int i2;
    label79:
    int i4;
    if (i6 > 0)
    {
      i1 = 0;
      if (i1 < i6)
      {
        aidf localaidf = (aidf)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localaidf.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localaidf);
        }
      }
      else
      {
        i3 = 1;
        i2 = 1;
        i1 = i2;
        i4 = i5;
        if (i3 >= i6) {
          break label173;
        }
        paramString1 = (aidf)paramList.get(i3);
        if ((!paramString2.contains(paramString1.jdField_a_of_type_JavaLangString)) || (paramString1.jdField_a_of_type_Int != 332)) {
          break label459;
        }
        paramList.remove(i3);
        paramList.add(i2, paramString1);
      }
    }
    label173:
    label447:
    label450:
    label453:
    label456:
    label459:
    for (int i1 = i2 + 1;; i1 = i2)
    {
      i3 += 1;
      i2 = i1;
      break label79;
      i1 += 1;
      break;
      if (i4 < i6)
      {
        paramString1 = (aidf)paramList.get(i4);
        if ((!paramString2.contains(paramString1.jdField_a_of_type_JavaLangString)) || (paramString1.jdField_a_of_type_Int != 333)) {
          break label456;
        }
        paramList.remove(i4);
        paramList.add(i1, paramString1);
        i1 += 1;
      }
      for (;;)
      {
        i4 += 1;
        break;
        i2 = i1;
        if (i2 < i6)
        {
          paramString1 = (aidf)paramList.get(i2);
          if (paramString1.jdField_a_of_type_Int != 332) {
            break label453;
          }
          paramList.remove(i2);
          paramList.add(i1, paramString1);
          i1 += 1;
        }
        for (;;)
        {
          i2 += 1;
          break;
          i2 = i1;
          if (i2 < i6)
          {
            paramString1 = (aidf)paramList.get(i2);
            if (paramString1.jdField_a_of_type_Int != 333) {
              break label450;
            }
            paramList.remove(i2);
            paramList.add(i1, paramString1);
            i1 += 1;
          }
          for (;;)
          {
            i2 += 1;
            break;
            i2 = i1;
            if (i2 < i6)
            {
              paramString1 = (aidf)paramList.get(i2);
              if (!paramString2.contains(paramString1.jdField_a_of_type_JavaLangString)) {
                break label447;
              }
              paramList.remove(i2);
              paramList.add(i1, paramString1);
              i1 += 1;
            }
            for (;;)
            {
              i2 += 1;
              break;
              return paramList;
            }
          }
        }
      }
    }
  }
  
  protected void a()
  {
    Object localObject = (ViewGroup)a(2131375863);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = a(2131377957);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)a(2131368624);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1 = (alto)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramInt1 = i1;
            if (paramIntent != null)
            {
              paramInt1 = i1;
              if (paramIntent.getBooleanExtra("isNeedFinish", false)) {
                paramInt1 = 1;
              }
            }
            if (paramInt1 != 0)
            {
              paramIntent = new Intent();
              paramIntent.putExtra("isNeedFinish", true);
              getActivity().setResult(-1, paramIntent);
              getActivity().finish();
              return;
            }
            ThreadManager.post(new ChatHistoryTroopMemberFragment.2(this, paramIntent, (alto)localObject1, (TroopManager)localObject2), 8, null, true);
            return;
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
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("roomId");
      } while (paramIntent == null);
      localObject1 = bdgc.a(getActivity().app, getActivity().getApplicationContext(), paramIntent);
      localObject2 = aepi.a(new Intent(getActivity(), SplashActivity.class), null);
      ((Intent)localObject2).putExtra("uin", paramIntent);
      ((Intent)localObject2).putExtra("uintype", 3000);
      ((Intent)localObject2).putExtra("uinname", (String)localObject1);
      ((Intent)localObject2).putExtra("isBack2Root", true);
      ((Intent)localObject2).setFlags(67108864);
      startActivity((Intent)localObject2);
      getActivity().finish();
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (TextUtils.isEmpty(this.w));
    ThreadManager.post(new ChatHistoryTroopMemberFragment.3(this, (alto)localObject1), 8, null, true);
  }
  
  public void a(aidf paramaidf)
  {
    if ((paramaidf != null) && (paramaidf.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.clear();
      paramaidf = new Intent();
      paramaidf.putExtra("result", new JSONArray().toString());
      getActivity().setResult(-1, paramaidf);
      azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      getActivity().finish();
    }
    label98:
    do
    {
      do
      {
        Object localObject2;
        do
        {
          break label98;
          do
          {
            return;
          } while ((paramaidf == null) || (paramaidf.jdField_a_of_type_JavaLangString == null));
          if (this.jdField_d_of_type_Int == 1)
          {
            if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramaidf.jdField_a_of_type_JavaLangString))
            {
              localObject1 = new ProfileActivity.AllInOne(paramaidf.jdField_a_of_type_JavaLangString, 0);
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = bdgc.h(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramaidf.jdField_a_of_type_JavaLangString);
              ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 3;
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 4;
              ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
              return;
            }
            a(paramaidf.jdField_a_of_type_JavaLangString, paramaidf.jdField_b_of_type_JavaLangString);
            return;
          }
          if (this.jdField_d_of_type_Int == 2)
          {
            localObject1 = getActivity().getIntent();
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_uin", paramaidf.jdField_a_of_type_JavaLangString);
            localObject2 = new TroopMemberListActivity.TroopAdmin();
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramaidf.jdField_a_of_type_JavaLangString;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramaidf.jdField_a_of_type_Short;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramaidf.jdField_b_of_type_JavaLangString;
            ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
            getActivity().setResult(-1, (Intent)localObject1);
            getActivity().finish();
            return;
          }
          if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            localObject1 = getActivity().getIntent();
            if (this.jdField_s_of_type_Boolean)
            {
              ((Intent)localObject1).putExtra("member_display_name", paramaidf.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("isApollo", true);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("member_uin", paramaidf.jdField_a_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
              getActivity().setResult(-1, (Intent)localObject1);
              getActivity().finish();
              return;
              ((Intent)localObject1).putExtra("member_display_name", paramaidf.jdField_b_of_type_JavaLangString);
            }
          }
          if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 4) && (this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
            break;
          }
          g(paramaidf.jdField_a_of_type_JavaLangString);
        } while (this.jdField_d_of_type_Int != 22);
        bdes.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString });
        return;
        if (this.jdField_d_of_type_Int == 5)
        {
          int i1;
          if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(paramaidf.jdField_a_of_type_JavaLangString)))
          {
            i1 = 3;
            startActivityForResult(EditUniqueTitleActivity.a(getActivity(), 1, this.jdField_c_of_type_JavaLangString, paramaidf.jdField_a_of_type_JavaLangString, i1, paramaidf.jdField_u_of_type_JavaLangString), 2);
            this.w = paramaidf.jdField_a_of_type_JavaLangString;
            localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = this.jdField_c_of_type_JavaLangString;
            i1 = this.jdField_m_of_type_Int;
            if (!this.jdField_p_of_type_Boolean) {
              break label663;
            }
          }
          for (paramaidf = "1";; paramaidf = "0")
          {
            azqs.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramaidf, "");
            return;
            if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.contains(paramaidf.jdField_a_of_type_JavaLangString)))
            {
              i1 = 2;
              break;
            }
            i1 = 1;
            break;
          }
        }
        if (this.jdField_d_of_type_Int == 14)
        {
          localObject1 = getActivity().getIntent();
          ((Intent)localObject1).putExtra("member_uin", paramaidf.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_display_name", paramaidf.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("troop_gift_from", this.jdField_e_of_type_JavaLangString);
          getActivity().setResult(-1, (Intent)localObject1);
          getActivity().finish();
          return;
        }
        if ((this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 20))
        {
          if (this.jdField_f_of_type_Int == 1)
          {
            this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.add(paramaidf);
            paramaidf = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList != null)
            {
              localObject2 = this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  aidf localaidf = (aidf)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localaidf.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localaidf.jdField_b_of_type_JavaLangString);
                    ((JSONArray)localObject1).put(localJSONObject);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.history.BaseFragment", 2, "json put error");
                      }
                    }
                  }
                }
              }
            }
            paramaidf.putExtra("result", ((JSONArray)localObject1).toString());
            getActivity().setResult(-1, paramaidf);
            getActivity().finish();
            return;
          }
          if (this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.contains(paramaidf)) {
            this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.remove(paramaidf);
          }
          for (;;)
          {
            this.jdField_a_of_type_Aidh.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.size() < this.jdField_f_of_type_Int)
            {
              this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.add(paramaidf);
            }
            else if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.add(paramaidf);
            }
            else
            {
              paramaidf = getResources().getString(this.jdField_h_of_type_Int, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) });
              QQToast.a(getActivity(), paramaidf, 0).a();
            }
          }
        }
        if ((this.jdField_d_of_type_Int != 18) && (this.jdField_d_of_type_Int != 19)) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_uin", paramaidf.jdField_a_of_type_JavaLangString);
        PublicFragmentActivity.a(getActivity(), (Intent)localObject1, TroopMemberHistoryFragment.class);
        azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A596", "0X800A596", 1, 0, "", "", "", "");
      } while (this.jdField_d_of_type_Int != 19);
      paramaidf = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bdes.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdes.a(paramaidf) });
      return;
    } while (this.jdField_d_of_type_Int != 23);
    label663:
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_member_name", paramaidf.jdField_g_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramaidf.jdField_a_of_type_JavaLangString));
    ((Intent)localObject1).putExtra("folderPath", "/");
    ((Intent)localObject1).putExtra("param_from", 6000);
    TroopFileProxyActivity.a(getActivity(), (Intent)localObject1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(aidm paramaidm, aidf paramaidf, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    label76:
    Object localObject;
    label145:
    label362:
    int i3;
    if (paramBoolean1)
    {
      str = this.jdField_v_of_type_JavaLangString;
      paramaidm.jdField_a_of_type_Boolean = paramBoolean1;
      paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramaidm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaidm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaidm.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if (this.jdField_m_of_type_Int != 1) {
        break label843;
      }
      if (paramaidf.jdField_d_of_type_Boolean) {
        break label830;
      }
      paramaidm.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      if ((this.jdField_e_of_type_Boolean) || (a()) || (paramaidf.jdField_d_of_type_Int == -100) || (paramaidf.jdField_d_of_type_Int == 0)) {
        break label865;
      }
      paramaidm.j.setVisibility(8);
      paramaidm.j.setText("LV" + paramaidf.jdField_d_of_type_Int);
      VipUtils.a(getActivity().app, getActivity(), getResources(), paramaidm, paramaidf);
      if ((this.jdField_d_of_type_Int != 13) || (!paramBoolean1)) {
        break label877;
      }
      paramBitmap = paramaidf.jdField_b_of_type_JavaLangString + "(" + paramaidf.jdField_a_of_type_JavaLangString + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramaidf.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramaidm.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label263:
      if ((paramBoolean2) && (paramaidm.k != null))
      {
        paramBitmap = alud.a(2131701981) + paramaidf.jdField_j_of_type_JavaLangString;
        paramaidm.k.setText(paramBitmap);
      }
      paramaidm.jdField_a_of_type_JavaLangString = paramaidf.jdField_a_of_type_JavaLangString;
      paramaidm.jdField_c_of_type_Int = 1;
      paramaidm.f.setText("");
      paramaidm.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
      if (this.jdField_d_of_type_Int != 9) {
        break label962;
      }
      paramaidm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaidm.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaidm.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
        break label977;
      }
      paramaidm.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaidm.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_g_of_type_Boolean) {
        paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
      label443:
      i3 = 0;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13)) {
        break label1107;
      }
      paramaidm.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691931) + paramaidm.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramaidm.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130849122);
      if (this.jdField_d_of_type_Int != 13) {
        break label1024;
      }
      paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label532:
      if (!str.equals(paramaidf.jdField_a_of_type_JavaLangString)) {
        break label1096;
      }
      paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    int i1;
    int i2;
    for (;;)
    {
      paramaidm.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131691909), new Object[] { paramaidm.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramaidm.g.setContentDescription(getString(2131691908));
      i1 = i3;
      if (paramaidm.jdField_d_of_type_AndroidViewView != null)
      {
        paramBitmap = (bcpg)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramaidf.jdField_a_of_type_JavaLangString))) {
          break label2370;
        }
        i2 = 1;
        label645:
        if (i2 == 0) {
          break label2376;
        }
        paramaidm.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      label658:
      if (this.jdField_h_of_type_Boolean) {
        paramaidm.j.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramaidm.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      if ((paramBoolean2) && (paramaidm.k != null)) {
        paramBitmap.append(paramaidm.k.getText());
      }
      if (paramaidm.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        paramBitmap.append(paramaidm.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      }
      if (paramaidm.j.getVisibility() == 0) {
        paramBitmap.append(paramaidm.j.getText().toString());
      }
      if ((paramaidm.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_g_of_type_Boolean))
      {
        if (i1 == 0) {
          break label2388;
        }
        paramaidf = "已选中";
        label803:
        paramBitmap.append(paramaidf);
      }
      paramaidm.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
      return;
      str = this.jdField_u_of_type_JavaLangString;
      break;
      label830:
      paramaidm.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      break label76;
      label843:
      paramaidm.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramaidm.j.setVisibility(8);
      break label76;
      label865:
      paramaidm.j.setVisibility(8);
      break label145;
      label877:
      if (paramBoolean2)
      {
        paramBitmap = new bamb(paramaidf.jdField_g_of_type_JavaLangString, 16).a();
        paramaidm.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
        bdrv.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramaidm.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
        break label263;
      }
      paramBitmap = new bamb(paramaidf.jdField_b_of_type_JavaLangString, 16).a();
      paramaidm.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      bdrv.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramaidm.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
      break label263;
      label962:
      paramaidm.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
      break label362;
      label977:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramaidm.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramaidm.jdField_a_of_type_AndroidViewView.setClickable(false);
        break label443;
      }
      paramaidm.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramaidm.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label443;
      label1024:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label532;
      }
      if ((this.jdField_f_of_type_JavaLangString != null) && (!paramaidf.jdField_a_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString)))
      {
        paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label532;
      }
      paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label532;
      label1096:
      paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label1107:
    paramaidm.jdField_c_of_type_AndroidWidgetTextView.setText("");
    label1129:
    boolean bool1;
    label1153:
    boolean bool2;
    label1184:
    boolean bool4;
    boolean bool5;
    if (!TextUtils.isEmpty(paramaidf.jdField_u_of_type_JavaLangString))
    {
      paramBoolean1 = true;
      if ((paramaidf.jdField_a_of_type_JavaLangString == null) || (!paramaidf.jdField_a_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString))) {
        break label1425;
      }
      bool1 = true;
      if ((this.jdField_g_of_type_JavaLangString == null) || (paramaidf.jdField_a_of_type_JavaLangString == null) || (!this.jdField_g_of_type_JavaLangString.contains(paramaidf.jdField_a_of_type_JavaLangString))) {
        break label1431;
      }
      bool2 = true;
      bool4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_f_of_type_JavaLangString);
      bool5 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramaidf.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int != 5) {
        break label1556;
      }
      paramaidm.h.setVisibility(0);
      paramaidm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaidm.i.setVisibility(0);
      localObject = "";
      i2 = 0;
      if ((!paramBoolean1) || (azmk.b())) {
        break label1437;
      }
      paramBitmap = bbtx.a().a(302, paramBoolean1, bool1, bool2);
      if (paramBitmap == null) {
        break label2410;
      }
      i1 = paramBitmap.jdField_b_of_type_Int;
      paramBitmap = paramaidf.jdField_u_of_type_JavaLangString;
    }
    for (;;)
    {
      label1298:
      if (!TextUtils.isEmpty(paramBitmap))
      {
        paramaidm.h.setText(paramBitmap);
        bbtx.a(paramaidm.h, i1);
      }
      for (;;)
      {
        label1322:
        paramBitmap = (bcpg)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramaidf.jdField_a_of_type_JavaLangString))) {
          break label2085;
        }
        i1 = 1;
        label1354:
        if (!this.jdField_f_of_type_Boolean) {
          break label2151;
        }
        if ((this.jdField_d_of_type_Int == 21) || ((!bool1) && ((bool4) || (!bool2)) && ((bool4) || (i1 == 0)))) {
          break label2091;
        }
        paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        paramBoolean1 = false;
        break label1129;
        label1425:
        bool1 = false;
        break label1153;
        label1431:
        bool2 = false;
        break label1184;
        label1437:
        if (bool1)
        {
          localbbty = bbtx.a().a(300, paramBoolean1, bool1, bool2);
          i1 = i2;
          paramBitmap = (Bitmap)localObject;
          if (localbbty == null) {
            break label1298;
          }
          i1 = localbbty.jdField_b_of_type_Int;
          paramBitmap = localbbty.jdField_a_of_type_JavaLangString;
          break label1298;
        }
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (!bool2) {
          break label1298;
        }
        bbty localbbty = bbtx.a().a(301, paramBoolean1, bool1, bool2);
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (localbbty == null) {
          break label1298;
        }
        i1 = localbbty.jdField_b_of_type_Int;
        paramBitmap = localbbty.jdField_a_of_type_JavaLangString;
        break label1298;
        paramaidm.h.setVisibility(8);
      }
      label1556:
      i1 = 0;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop();
      }
      if ((bool3) || (this.jdField_e_of_type_Boolean))
      {
        localObject = bbtx.a().a(bool1, bool2);
        if (localObject == null) {
          break label2401;
        }
        paramBitmap = ((bbty)localObject).jdField_a_of_type_JavaLangString;
        i1 = ((bbty)localObject).jdField_b_of_type_Int;
      }
      for (;;)
      {
        label1620:
        if (this.jdField_d_of_type_Int == 11) {
          paramBitmap = "";
        }
        if ((azmk.b()) && (bool1))
        {
          localObject = String.format(getString(2131689530), new Object[0]);
          label1659:
          if ((!azmk.b()) || (bool2) || (bool1)) {
            break label2031;
          }
          i2 = 1;
          label1678:
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (a()) || (i2 != 0)) {
            break label2037;
          }
          paramaidm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramaidm.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          bbtx.a(paramaidm.jdField_c_of_type_AndroidWidgetTextView, i1);
          label1724:
          if (this.jdField_e_of_type_Boolean)
          {
            paramBitmap = bbtx.a().a(paramaidf.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap == null) || (!bckt.a(paramaidf.jdField_a_of_type_Int))) {
              break label2061;
            }
            if (TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) {
              break label2049;
            }
            paramaidm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramaidm.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
            bbtx.a(paramaidm.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
          }
        }
        for (;;)
        {
          if ((this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 12)) {
            break label2071;
          }
          if ((paramaidf.jdField_a_of_type_JavaLangString == null) || (!paramaidf.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            break label2073;
          }
          paramaidm.f.setText(getString(2131694674));
          break;
          localObject = bbtx.a().a(paramaidf.jdField_a_of_type_Int, paramBoolean1, bool1, bool2);
          if (localObject != null)
          {
            paramBitmap = ((bbty)localObject).jdField_a_of_type_JavaLangString;
            i2 = ((bbty)localObject).jdField_b_of_type_Int;
            if (((bbty)localObject).jdField_a_of_type_Int == 302) {
              paramBitmap = paramaidf.jdField_u_of_type_JavaLangString;
            }
            i1 = i2;
            if (((bbty)localObject).jdField_a_of_type_Int != 315) {
              break label1620;
            }
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramaidf.jdField_c_of_type_Int));
            i1 = i2;
            break label1620;
          }
          if (paramaidf.jdField_a_of_type_Int != 315) {
            break label2395;
          }
          paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramaidf.jdField_c_of_type_Int));
          i1 = Color.parseColor("#8EBDF9");
          break label1620;
          localObject = paramBitmap;
          if (!azmk.b()) {
            break label1659;
          }
          localObject = paramBitmap;
          if (!bool2) {
            break label1659;
          }
          localObject = String.format(getString(2131689529), new Object[0]);
          break label1659;
          label2031:
          i2 = 0;
          break label1678;
          label2037:
          paramaidm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1724;
          label2049:
          paramaidm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label2061:
          paramaidm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        label2071:
        break label1322;
        label2073:
        paramaidm.f.setText("");
        break label1322;
        label2085:
        i1 = 0;
        break label1354;
        label2091:
        paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramaidm.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130849122);
        if (str.equals(paramaidf.jdField_a_of_type_JavaLangString))
        {
          paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
          i1 = i3;
          break;
        }
        paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        label2151:
        if (this.jdField_g_of_type_Boolean)
        {
          if ((bool1) || ((!bool4) && (bool2)) || (bool5))
          {
            i1 = 1;
            if (i1 == 0) {
              break label2207;
            }
            paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(8);
            i1 = 0;
          }
          for (;;)
          {
            break;
            i1 = 0;
            break label2181;
            paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramaidf.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aidh.jdField_b_of_type_JavaUtilList.contains(paramaidf.jdField_a_of_type_JavaLangString)))
            {
              paramaidm.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840306);
              i1 = 1;
            }
            else
            {
              paramaidm.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840302);
              i1 = 0;
            }
          }
        }
        label2181:
        label2207:
        if (this.jdField_d_of_type_Int == 20)
        {
          paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramaidf.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aidh.jdField_a_of_type_JavaUtilList.contains(paramaidf)))
          {
            paramaidm.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840306);
            i1 = 1;
            break;
          }
          paramaidm.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840302);
          i1 = i3;
          break;
        }
        paramaidm.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramaidm.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        label2370:
        i2 = 0;
        break label645;
        label2376:
        paramaidm.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label658;
        label2388:
        paramaidf = "未选中";
        break label803;
        label2395:
        paramBitmap = "";
        continue;
        label2401:
        i1 = 0;
        paramBitmap = "";
      }
      label2410:
      i1 = 0;
      paramBitmap = "";
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(0);
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_Aidh.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i1 + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_d_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (alto)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.jdField_a_of_type_Int = 20;
        paramString1.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        paramString1.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        paramString1.jdField_h_of_type_Int = 4;
        ProfileActivity.b(getActivity(), paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.jdField_a_of_type_Int = 21;
    paramString1.jdField_l_of_type_Int = 11;
    paramString1.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramString1.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    paramString1.jdField_h_of_type_Int = 4;
    ProfileActivity.b(getActivity(), paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.BaseFragment", 2, "doReport, actionName=" + paramString1 + " ext2=" + paramString2 + " ext3=" + paramString3 + " from=" + this.jdField_d_of_type_Int);
      }
      if (this.jdField_d_of_type_Int == 1) {
        return;
      }
      if (this.jdField_d_of_type_Int == 11) {
        return;
      }
      if (this.jdField_d_of_type_Int != 9) {
        break label179;
      }
      if (this.jdField_e_of_type_Int != 1) {
        break label172;
      }
      paramString2 = "suc_pay_list";
    }
    catch (Exception paramString1)
    {
      while (QLog.isColorLevel())
      {
        QLog.i("Q.history.BaseFragment", 2, "doReport:" + paramString1.toString());
        return;
        label172:
        paramString2 = "un_pay_list";
      }
      label179:
      azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, paramString2, paramString3, "");
    }
    azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_c_of_type_JavaLangString, paramString3, "", "");
    return;
  }
  
  /* Error */
  public void a(String paramString, List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 670 1 0
    //   11: aload_0
    //   12: dconst_0
    //   13: putfield 254	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_a_of_type_Double	D
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 256	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_n_of_type_Int	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 763	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_o_of_type_Int	I
    //   26: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc_w 960
    //   35: iconst_2
    //   36: new 470	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 2004
    //   46: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   63: putfield 776	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_d_of_type_Long	J
    //   66: aload_2
    //   67: ifnull +15 -> 82
    //   70: aload_2
    //   71: astore 8
    //   73: aload_2
    //   74: invokeinterface 2006 1 0
    //   79: ifeq +528 -> 607
    //   82: new 119	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 120	java/util/ArrayList:<init>	()V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 967	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 2010	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   97: invokevirtual 2016	awgg:createEntityManager	()Lawgf;
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_1
    //   105: ldc_w 980
    //   108: invokevirtual 2021	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: bipush 19
    //   113: anewarray 349	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 2022
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 2023
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 2024
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 2025
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 2026
    //   145: aastore
    //   146: dup
    //   147: iconst_5
    //   148: ldc_w 2027
    //   151: aastore
    //   152: dup
    //   153: bipush 6
    //   155: ldc_w 2028
    //   158: aastore
    //   159: dup
    //   160: bipush 7
    //   162: ldc_w 2029
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: ldc_w 2031
    //   172: aastore
    //   173: dup
    //   174: bipush 9
    //   176: ldc_w 2033
    //   179: aastore
    //   180: dup
    //   181: bipush 10
    //   183: ldc_w 2035
    //   186: aastore
    //   187: dup
    //   188: bipush 11
    //   190: ldc_w 2036
    //   193: aastore
    //   194: dup
    //   195: bipush 12
    //   197: ldc_w 2037
    //   200: aastore
    //   201: dup
    //   202: bipush 13
    //   204: ldc_w 2038
    //   207: aastore
    //   208: dup
    //   209: bipush 14
    //   211: ldc_w 2039
    //   214: aastore
    //   215: dup
    //   216: bipush 15
    //   218: ldc_w 2040
    //   221: aastore
    //   222: dup
    //   223: bipush 16
    //   225: ldc_w 2041
    //   228: aastore
    //   229: dup
    //   230: bipush 17
    //   232: ldc_w 2042
    //   235: aastore
    //   236: dup
    //   237: bipush 18
    //   239: ldc_w 2043
    //   242: aastore
    //   243: ldc_w 2045
    //   246: iconst_1
    //   247: anewarray 349	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: aload_1
    //   253: aastore
    //   254: aconst_null
    //   255: aconst_null
    //   256: aconst_null
    //   257: aconst_null
    //   258: invokevirtual 2050	awgf:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +289 -> 552
    //   266: aload_1
    //   267: invokeinterface 2055 1 0
    //   272: ifeq +274 -> 546
    //   275: new 980	com/tencent/mobileqq/data/TroopMemberInfo
    //   278: dup
    //   279: invokespecial 2056	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload_1
    //   287: iconst_0
    //   288: invokeinterface 2057 2 0
    //   293: putfield 983	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   296: aload 9
    //   298: aload_1
    //   299: iconst_1
    //   300: invokeinterface 2057 2 0
    //   305: invokestatic 2060	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   308: putfield 1419	com/tencent/mobileqq/data/TroopMemberInfo:mIsShielded	Z
    //   311: aload 9
    //   313: aload_1
    //   314: iconst_2
    //   315: invokeinterface 2057 2 0
    //   320: putfield 1447	com/tencent/mobileqq/data/TroopMemberInfo:mUniqueTitle	Ljava/lang/String;
    //   323: aload 9
    //   325: aload_1
    //   326: iconst_3
    //   327: invokeinterface 2063 2 0
    //   332: putfield 1397	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   335: aload 9
    //   337: aload_1
    //   338: iconst_4
    //   339: invokeinterface 2067 2 0
    //   344: putfield 1415	com/tencent/mobileqq/data/TroopMemberInfo:active_point	J
    //   347: aload 9
    //   349: aload_1
    //   350: iconst_5
    //   351: invokeinterface 2067 2 0
    //   356: putfield 1406	com/tencent/mobileqq/data/TroopMemberInfo:credit_level	J
    //   359: aload 9
    //   361: aload_1
    //   362: bipush 6
    //   364: invokeinterface 2067 2 0
    //   369: putfield 1391	com/tencent/mobileqq/data/TroopMemberInfo:last_active_time	J
    //   372: aload 9
    //   374: aload_1
    //   375: bipush 7
    //   377: invokeinterface 2067 2 0
    //   382: putfield 1394	com/tencent/mobileqq/data/TroopMemberInfo:join_time	J
    //   385: aload 9
    //   387: aload_1
    //   388: bipush 8
    //   390: invokeinterface 2057 2 0
    //   395: putfield 2069	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   398: aload 9
    //   400: aload_1
    //   401: bipush 9
    //   403: invokeinterface 2057 2 0
    //   408: putfield 1385	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_troopnick	Ljava/lang/String;
    //   411: aload 9
    //   413: aload_1
    //   414: bipush 10
    //   416: invokeinterface 2057 2 0
    //   421: putfield 1388	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_troopnick	Ljava/lang/String;
    //   424: aload 9
    //   426: aload_1
    //   427: bipush 11
    //   429: invokeinterface 2057 2 0
    //   434: putfield 1365	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   437: aload 9
    //   439: aload_1
    //   440: bipush 12
    //   442: invokeinterface 2057 2 0
    //   447: putfield 1370	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_friendnick	Ljava/lang/String;
    //   450: aload 9
    //   452: aload_1
    //   453: bipush 13
    //   455: invokeinterface 2057 2 0
    //   460: putfield 1375	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_friendnick	Ljava/lang/String;
    //   463: aload 9
    //   465: aload_1
    //   466: bipush 14
    //   468: invokeinterface 2057 2 0
    //   473: putfield 1477	com/tencent/mobileqq/data/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   476: aload 9
    //   478: aload_1
    //   479: bipush 15
    //   481: invokeinterface 2057 2 0
    //   486: putfield 1483	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_autoremark	Ljava/lang/String;
    //   489: aload 9
    //   491: aload_1
    //   492: bipush 16
    //   494: invokeinterface 2057 2 0
    //   499: putfield 1486	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_autoremark	Ljava/lang/String;
    //   502: aload 9
    //   504: aload_1
    //   505: bipush 17
    //   507: invokeinterface 2063 2 0
    //   512: putfield 1401	com/tencent/mobileqq/data/TroopMemberInfo:realLevel	I
    //   515: aload 9
    //   517: aload_1
    //   518: bipush 18
    //   520: invokeinterface 2057 2 0
    //   525: putfield 1382	com/tencent/mobileqq/data/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   528: aload_2
    //   529: aload 9
    //   531: invokeinterface 296 2 0
    //   536: pop
    //   537: aload_1
    //   538: invokeinterface 2072 1 0
    //   543: ifne -268 -> 275
    //   546: aload_1
    //   547: invokeinterface 2075 1 0
    //   552: aload 8
    //   554: invokevirtual 2076	awgf:a	()V
    //   557: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   560: lstore 6
    //   562: aload_2
    //   563: astore 8
    //   565: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +39 -> 607
    //   571: ldc_w 960
    //   574: iconst_2
    //   575: new 470	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 2078
    //   585: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: lload 6
    //   590: aload_0
    //   591: getfield 776	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_d_of_type_Long	J
    //   594: lsub
    //   595: invokevirtual 2081	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_2
    //   605: astore 8
    //   607: aload 8
    //   609: ifnull +13 -> 622
    //   612: aload 8
    //   614: invokeinterface 2006 1 0
    //   619: ifeq +26 -> 645
    //   622: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +13 -> 638
    //   628: ldc_w 960
    //   631: iconst_2
    //   632: ldc_w 2083
    //   635: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload_0
    //   639: invokevirtual 845	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:y	()V
    //   642: aload_0
    //   643: monitorexit
    //   644: return
    //   645: aload 8
    //   647: invokeinterface 732 1 0
    //   652: istore 4
    //   654: aload_0
    //   655: iload 4
    //   657: putfield 763	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_o_of_type_Int	I
    //   660: iload 4
    //   662: getstatic 90	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_p_of_type_Int	I
    //   665: idiv
    //   666: istore 5
    //   668: iload 4
    //   670: getstatic 90	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_p_of_type_Int	I
    //   673: irem
    //   674: ifne +195 -> 869
    //   677: iconst_0
    //   678: istore_3
    //   679: aload_0
    //   680: iload_3
    //   681: iload 5
    //   683: iadd
    //   684: putfield 256	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_n_of_type_Int	I
    //   687: iconst_0
    //   688: istore_3
    //   689: iload_3
    //   690: iload 4
    //   692: if_icmpge +42 -> 734
    //   695: new 2085	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment$36
    //   698: dup
    //   699: aload_0
    //   700: aload 8
    //   702: iload_3
    //   703: getstatic 90	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_p_of_type_Int	I
    //   706: iload_3
    //   707: iadd
    //   708: iconst_1
    //   709: isub
    //   710: iload 4
    //   712: invokestatic 2091	java/lang/Math:min	(II)I
    //   715: invokespecial 2094	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment$36:<init>	(Lcom/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment;Ljava/util/List;II)V
    //   718: bipush 8
    //   720: aconst_null
    //   721: iconst_1
    //   722: invokestatic 375	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   725: iload_3
    //   726: getstatic 90	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_p_of_type_Int	I
    //   729: iadd
    //   730: istore_3
    //   731: goto -42 -> 689
    //   734: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq -95 -> 642
    //   740: ldc_w 960
    //   743: iconst_2
    //   744: new 470	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 2096
    //   754: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: iload 4
    //   759: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   762: ldc_w 2098
    //   765: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_0
    //   769: getfield 256	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_n_of_type_Int	I
    //   772: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: goto -139 -> 642
    //   784: astore_1
    //   785: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq -146 -> 642
    //   791: ldc_w 960
    //   794: iconst_2
    //   795: new 470	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 2100
    //   805: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload_1
    //   809: invokevirtual 1997	java/lang/Exception:toString	()Ljava/lang/String;
    //   812: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: goto -179 -> 642
    //   824: astore_1
    //   825: aload_0
    //   826: monitorexit
    //   827: aload_1
    //   828: athrow
    //   829: astore_1
    //   830: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq -191 -> 642
    //   836: ldc_w 960
    //   839: iconst_2
    //   840: new 470	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   847: ldc_w 2100
    //   850: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_1
    //   854: invokevirtual 2101	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   857: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: goto -224 -> 642
    //   869: iconst_1
    //   870: istore_3
    //   871: goto -192 -> 679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	ChatHistoryTroopMemberFragment
    //   0	874	1	paramString	String
    //   0	874	2	paramList	List<TroopMemberInfo>
    //   678	193	3	i1	int
    //   652	106	4	i2	int
    //   666	18	5	i3	int
    //   560	29	6	l1	long
    //   71	630	8	localObject	Object
    //   282	248	9	localTroopMemberInfo	TroopMemberInfo
    // Exception table:
    //   from	to	target	type
    //   26	59	784	java/lang/Exception
    //   59	66	784	java/lang/Exception
    //   73	82	784	java/lang/Exception
    //   82	262	784	java/lang/Exception
    //   266	275	784	java/lang/Exception
    //   275	546	784	java/lang/Exception
    //   546	552	784	java/lang/Exception
    //   552	562	784	java/lang/Exception
    //   565	604	784	java/lang/Exception
    //   612	622	784	java/lang/Exception
    //   622	638	784	java/lang/Exception
    //   638	642	784	java/lang/Exception
    //   645	677	784	java/lang/Exception
    //   679	687	784	java/lang/Exception
    //   695	731	784	java/lang/Exception
    //   734	781	784	java/lang/Exception
    //   2	26	824	finally
    //   26	59	824	finally
    //   59	66	824	finally
    //   73	82	824	finally
    //   82	262	824	finally
    //   266	275	824	finally
    //   275	546	824	finally
    //   546	552	824	finally
    //   552	562	824	finally
    //   565	604	824	finally
    //   612	622	824	finally
    //   622	638	824	finally
    //   638	642	824	finally
    //   645	677	824	finally
    //   679	687	824	finally
    //   695	731	824	finally
    //   734	781	824	finally
    //   785	821	824	finally
    //   830	866	824	finally
    //   26	59	829	java/lang/OutOfMemoryError
    //   59	66	829	java/lang/OutOfMemoryError
    //   73	82	829	java/lang/OutOfMemoryError
    //   82	262	829	java/lang/OutOfMemoryError
    //   266	275	829	java/lang/OutOfMemoryError
    //   275	546	829	java/lang/OutOfMemoryError
    //   546	552	829	java/lang/OutOfMemoryError
    //   552	562	829	java/lang/OutOfMemoryError
    //   565	604	829	java/lang/OutOfMemoryError
    //   612	622	829	java/lang/OutOfMemoryError
    //   622	638	829	java/lang/OutOfMemoryError
    //   638	642	829	java/lang/OutOfMemoryError
    //   645	677	829	java/lang/OutOfMemoryError
    //   679	687	829	java/lang/OutOfMemoryError
    //   695	731	829	java/lang/OutOfMemoryError
    //   734	781	829	java/lang/OutOfMemoryError
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0) || (this.jdField_a_of_type_Aidh == null)) {
      break label16;
    }
    label16:
    while (this.jdField_a_of_type_Aidh.jdField_b_of_type_Int + this.jdField_a_of_type_Aidh.jdField_c_of_type_Int > 16) {
      return;
    }
    int i3 = 1;
    int i1 = 0;
    int i2 = 0;
    label44:
    int i5 = i1;
    int i4 = i2;
    if (i3 < paramArrayOfInt.length)
    {
      i4 = paramArrayOfInt[i3] - paramArrayOfInt[(i3 - 1)] - 1;
      if (i4 > 0) {}
    }
    for (;;)
    {
      i3 += 1;
      break label44;
      int i6 = i2 + this.jdField_j_of_type_Int;
      i2 = this.jdField_k_of_type_Int * i4;
      if (i6 + i2 > this.jdField_i_of_type_Int)
      {
        i2 = i4;
        do
        {
          i3 = i2 - 1;
          i4 = this.jdField_j_of_type_Int * i3;
          if (i6 + i4 <= this.jdField_i_of_type_Int) {
            break;
          }
          i2 = i3;
        } while (i3 > 0);
        i5 = i1 + i3;
        i4 = i6 + i4;
        if (this.jdField_k_of_type_Int + i4 > this.jdField_i_of_type_Int) {
          this.jdField_l_of_type_Int = (i5 + 1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.history.BaseFragment", 2, String.format("updateMaxItemCount, max: %s", new Object[] { Integer.valueOf(this.jdField_l_of_type_Int) }));
        return;
      }
      i2 = i6 + i2;
      i1 += i4;
    }
  }
  
  protected Object[] a(String paramString)
  {
    int i1 = 0;
    long l1;
    Object localObject;
    long l2;
    int i2;
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "getDiscussionMemberFromDB, uin:" + paramString);
        }
        l1 = System.currentTimeMillis();
        localObject = (alto)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        this.jdField_c_of_type_JavaUtilList = ((alrk)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "getDiscussionMemberFromDB, queryTime:" + (l2 - l1));
        }
        if (this.jdField_c_of_type_JavaUtilList == null) {
          break label557;
        }
        i2 = this.jdField_c_of_type_JavaUtilList.size();
        if (i1 < i2)
        {
          paramString = (DiscussionMemberInfo)this.jdField_c_of_type_JavaUtilList.get(i1);
          if (paramString == null) {
            break label562;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.jdField_d_of_type_Int == 2) && (paramString.memberUin.equals(this.jdField_f_of_type_JavaLangString))) || ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))) {
              break label562;
            }
            paramString = a(paramString, (alto)localObject);
            this.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "getDiscussionMemberFromDB:" + paramString.toString());
        }
        paramString = null;
        return paramString;
        if (!QLog.isColorLevel()) {
          break label562;
        }
        QLog.d("Q.history.BaseFragment", 2, "getDiscussionMemberFromDB, continued:" + paramString.memberUin);
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label321:
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "getDiscussionMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
        break label569;
      }
    }
    finally {}
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "getDiscussionMemberFromDB, TotalTime:" + (l2 - l1) + ", listSize:" + this.jdField_a_of_type_JavaUtilList.size() + ", dbSize:" + i1);
      }
      localObject = this.jdField_a_of_type_Aidh.a();
      if ((localObject != null) && (localObject.length == 3))
      {
        paramString = new Object[3];
        paramString[0] = localObject[0];
        paramString[1] = localObject[1];
        paramString[2] = localObject[2];
        break label321;
      }
      paramString = null;
      break label321;
      label557:
      i1 = 0;
      continue;
      label562:
      i1 += 1;
      break;
      label569:
      i1 = i2;
    }
  }
  
  /* Error */
  public Object[] a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 119	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 120	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 967	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: bipush 51
    //   21: invokevirtual 971	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 973	alto
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 967	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 2010	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   36: invokevirtual 2016	awgg:createEntityManager	()Lawgf;
    //   39: astore 7
    //   41: aload_2
    //   42: invokeinterface 420 1 0
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 426 1 0
    //   54: ifeq +85 -> 139
    //   57: aload 7
    //   59: ldc_w 980
    //   62: iconst_0
    //   63: ldc_w 2157
    //   66: iconst_2
    //   67: anewarray 349	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: invokeinterface 430 1 0
    //   82: checkcast 349	java/lang/String
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 2160	awgf:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   93: astore 8
    //   95: aload 8
    //   97: ifnull -49 -> 48
    //   100: aload 8
    //   102: invokeinterface 732 1 0
    //   107: ifle -59 -> 48
    //   110: aload 5
    //   112: aload_0
    //   113: aload 8
    //   115: iconst_0
    //   116: invokeinterface 978 2 0
    //   121: checkcast 980	com/tencent/mobileqq/data/TroopMemberInfo
    //   124: aload 6
    //   126: invokevirtual 997	com/tencent/mobileqq/activity/history/ChatHistoryTroopMemberFragment:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Lalto;)Laidf;
    //   129: invokeinterface 296 2 0
    //   134: pop
    //   135: goto -87 -> 48
    //   138: astore_1
    //   139: invokestatic 958	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +34 -> 176
    //   145: ldc_w 960
    //   148: iconst_2
    //   149: new 470	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 2162
    //   159: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   165: lload_3
    //   166: lsub
    //   167: invokevirtual 2081	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 965	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: iconst_1
    //   179: anewarray 735	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 5
    //   186: aastore
    //   187: areturn
    //   188: astore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	ChatHistoryTroopMemberFragment
    //   0	193	1	paramString	String
    //   0	193	2	paramList	List<String>
    //   5	161	3	l1	long
    //   13	172	5	localArrayList	ArrayList
    //   27	98	6	localalto	alto
    //   39	19	7	localawgf	awgf
    //   93	21	8	localList	List
    // Exception table:
    //   from	to	target	type
    //   29	48	138	java/lang/Exception
    //   48	95	138	java/lang/Exception
    //   100	135	138	java/lang/Exception
    //   2	29	188	finally
    //   29	48	188	finally
    //   48	95	188	finally
    //   100	135	188	finally
    //   139	176	188	finally
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "removeSearchItem:" + paramString);
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_b_of_type_JavaUtilList.size())
        {
          aidf localaidf = (aidf)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localaidf != null) && (localaidf.jdField_a_of_type_JavaLangString.equals(paramString))) {
            this.jdField_b_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public void e(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Aidj.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    bcpg localbcpg = (bcpg)getActivity().app.getManager(203);
    int i1 = 0;
    for (;;)
    {
      aidf localaidf;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label967;
        }
        localaidf = (aidf)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((this.jdField_v_of_type_Boolean) && (localbcpg.b(localaidf.jdField_a_of_type_JavaLangString))) {
          break label1145;
        }
        localaidf.jdField_e_of_type_JavaLangString = "";
        localaidf.jdField_f_of_type_JavaLangString = "";
        if ((paramString.equals(localaidf.m)) || (paramString.equals(localaidf.jdField_o_of_type_JavaLangString)) || (paramString.equals(localaidf.n)))
        {
          localaidf.jdField_e_of_type_JavaLangString = localaidf.m;
          localArrayList1.add(localaidf);
          if (!QLog.isColorLevel()) {
            break label1145;
          }
          QLog.d("Q.history.BaseFragment", 2, "refreshSearchResultList:" + localaidf.jdField_a_of_type_JavaLangString + "," + localaidf.jdField_e_of_type_JavaLangString);
        }
      }
      finally {}
      if ((paramString.equals(localaidf.jdField_j_of_type_JavaLangString)) || (paramString.equals(localaidf.jdField_l_of_type_JavaLangString)) || (paramString.equals(localaidf.jdField_k_of_type_JavaLangString)))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_j_of_type_JavaLangString;
        localArrayList1.add(localaidf);
      }
      else if ((paramString.equals(localaidf.jdField_g_of_type_JavaLangString)) || (paramString.equals(localaidf.jdField_i_of_type_JavaLangString)) || (paramString.equals(localaidf.jdField_h_of_type_JavaLangString)))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_g_of_type_JavaLangString;
        localArrayList1.add(localaidf);
      }
      else if (paramString.equals(localaidf.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_h_of_type_Boolean)
        {
          localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localaidf);
        }
      }
      else if ((localaidf.m.indexOf(paramString) == 0) || (localaidf.jdField_o_of_type_JavaLangString.indexOf(paramString) == 0) || (localaidf.n.indexOf(paramString) == 0))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.m;
        localaidf.jdField_f_of_type_JavaLangString = localaidf.n;
        localArrayList2.add(localaidf);
      }
      else if ((localaidf.jdField_j_of_type_JavaLangString.indexOf(paramString) == 0) || (localaidf.jdField_l_of_type_JavaLangString.indexOf(paramString) == 0) || (localaidf.jdField_k_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_j_of_type_JavaLangString;
        localaidf.jdField_f_of_type_JavaLangString = localaidf.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localaidf);
      }
      else if ((localaidf.jdField_g_of_type_JavaLangString.indexOf(paramString) == 0) || (localaidf.jdField_i_of_type_JavaLangString.indexOf(paramString) == 0) || (localaidf.jdField_h_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_g_of_type_JavaLangString;
        localaidf.jdField_f_of_type_JavaLangString = localaidf.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localaidf);
      }
      else if (localaidf.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
      {
        if (!this.jdField_h_of_type_Boolean)
        {
          localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_a_of_type_JavaLangString;
          localaidf.jdField_f_of_type_JavaLangString = localaidf.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localaidf);
        }
      }
      else if ((localaidf.m.indexOf(paramString) > 0) || (localaidf.jdField_o_of_type_JavaLangString.indexOf(paramString) > 0) || (localaidf.n.indexOf(paramString) > 0))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.m;
        localArrayList3.add(localaidf);
      }
      else if ((localaidf.jdField_j_of_type_JavaLangString.indexOf(paramString) > 0) || (localaidf.jdField_l_of_type_JavaLangString.indexOf(paramString) > 0) || (localaidf.jdField_k_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_j_of_type_JavaLangString;
        localArrayList3.add(localaidf);
      }
      else if ((localaidf.jdField_g_of_type_JavaLangString.indexOf(paramString) > 0) || (localaidf.jdField_i_of_type_JavaLangString.indexOf(paramString) > 0) || (localaidf.jdField_h_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_g_of_type_JavaLangString;
        localArrayList3.add(localaidf);
      }
      else if ((localaidf.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_h_of_type_Boolean))
      {
        localaidf.jdField_e_of_type_JavaLangString = localaidf.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localaidf);
        continue;
        label967:
        Collections.sort(localArrayList2, new aidk(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Aidj.notifyDataSetChanged();
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.history.BaseFragment", 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.jdField_b_of_type_JavaUtilList.size() + "," + this.jdField_a_of_type_JavaUtilList.size());
          return;
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        label1145:
        i1 += 1;
      }
    }
  }
  
  public void f(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "kickOutDiscussionMember:" + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_AndroidAppDialog == null)
        {
          this.jdField_c_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755801);
          this.jdField_c_of_type_AndroidAppDialog.setContentView(2131558428);
          Dialog localDialog = this.jdField_c_of_type_AndroidAppDialog;
          if (this.jdField_d_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131365233)).setText(getString(2131691907));
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_Alri.b(Long.parseLong(this.jdField_b_of_type_JavaLangString), Long.valueOf(paramString).longValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.history.BaseFragment", 2, "kickOutDiscussionMember:" + paramString.toString());
      }
      bool = false;
    }
  }
  
  protected void g(String paramString)
  {
    if (((bcpg)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(getActivity(), this.jdField_c_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131721076));
    if ((this.jdField_k_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131690623));
    }
    awrt.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_c_of_type_JavaLangString, paramString, 1, 1, localBundle);
    this.w = paramString;
    a("Clk_item", this.jdField_o_of_type_JavaLangString, "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Aidv.b();
      continue;
      C();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562766, paramViewGroup, false);
    this.jdField_f_of_type_AndroidViewView = paramLayoutInflater;
    p();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_l_of_type_Boolean = true;
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      label17:
      if (this.jdField_a_of_type_Aidv != null)
      {
        this.jdField_a_of_type_Aidv.c();
        this.jdField_a_of_type_Aidv = null;
      }
      try
      {
        getActivity().removeObserver(this.jdField_a_of_type_Alrl);
        getActivity().removeObserver(this.jdField_a_of_type_Ameq);
        label58:
        if (this.jdField_a_of_type_Aidj != null) {
          this.jdField_a_of_type_Aidj.c();
        }
        super.g();
        if ((this.jdField_c_of_type_AndroidAppDialog != null) && (this.jdField_c_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_c_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_Aidh != null) {
          this.jdField_a_of_type_Aidh.c();
        }
        if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
          this.jdField_a_of_type_Bhuf.dismiss();
        }
        if ((this.jdField_d_of_type_AndroidAppDialog != null) && (this.jdField_d_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_d_of_type_AndroidAppDialog.dismiss();
        }
        return;
      }
      catch (Exception localException1)
      {
        break label58;
      }
    }
    catch (Exception localException2)
    {
      break label17;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause()
  {
    super.onPause();
    getActivity().getWindow().setSoftInputMode(16);
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      getActivity().getWindow().setSoftInputMode(48);
      label16:
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.destroyDrawingCache();
        this.jdField_b_of_type_AndroidViewView.requestLayout();
        this.jdField_b_of_type_AndroidViewView.invalidate();
      }
      if (this.jdField_a_of_type_Aidv != null) {
        this.jdField_a_of_type_Aidv.a();
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 7, 0, "", "", "", "");
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
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    paramView = getActivity().getIntent().getExtras();
    this.jdField_c_of_type_JavaLangString = paramView.getString("uin");
    this.jdField_d_of_type_JavaLangString = paramView.getString("troop_info_name");
    this.jdField_e_of_type_JavaLangString = paramView.getString("troop_gift_from");
    this.jdField_i_of_type_JavaLangString = paramView.getString("leftViewText");
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
    this.jdField_h_of_type_Int = paramView.getInt("param_pick_max_num_exceeds_wording", 2131698013);
    this.jdField_l_of_type_JavaLangString = paramView.getString("param_pick_title_string", this.jdField_l_of_type_JavaLangString);
    this.jdField_v_of_type_Boolean = paramView.getBoolean("param_filter_robot", false);
    if (this.jdField_d_of_type_Int == 17) {
      new azqx(getActivity().app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_c_of_type_JavaLangString }).a();
    }
    if (this.jdField_d_of_type_Int == 22) {
      bdes.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString });
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
    if (paramBundle != null) {}
    boolean bool;
    try
    {
      this.jdField_d_of_type_Int = Integer.parseInt(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnCreate, troopCode=" + this.jdField_c_of_type_JavaLangString + " troopUin=" + this.jdField_b_of_type_JavaLangString + " from=" + this.jdField_d_of_type_Int);
      }
      if (this.jdField_m_of_type_Boolean) {
        getActivity().setTheme(2131755151);
      }
      this.jdField_h_of_type_Boolean = TroopInfo.isQidianPrivateTroop(getActivity().app, this.jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.jdField_h_of_type_Boolean + ", mTroopUin = " + this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_o_of_type_Int == 0)
      {
        paramBundle = ((TroopManager)getActivity().app.getManager(52)).b(this.jdField_c_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_o_of_type_Int = paramBundle.wMemberNum;
        }
      }
    }
    catch (NumberFormatException paramBundle)
    {
      try
      {
        this.jdField_n_of_type_Boolean = ThemeUtil.isDefaultTheme();
        if (this.jdField_d_of_type_Int == 15)
        {
          this.jdField_m_of_type_Int = 6;
          this.jdField_f_of_type_JavaUtilArrayList = paramView.getStringArrayList("param_seq_days");
          this.jdField_e_of_type_JavaUtilArrayList = paramView.getStringArrayList("param_seq_name");
        }
        if ((this.jdField_m_of_type_Int == 1) || (this.jdField_m_of_type_Int == 8)) {
          ((amdu)getActivity().app.a(20)).v(this.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Alri = ((alri)getActivity().app.a(6));
        this.jdField_a_of_type_AndroidViewLayoutInflater = getActivity().getLayoutInflater();
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        paramView = (TroopManager)getActivity().app.getManager(52);
        paramBundle = (alrk)getActivity().app.getManager(53);
        if ((paramView != null) && (paramBundle != null)) {
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramBundle.a(this.jdField_c_of_type_JavaLangString);
            this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
            if ((this.jdField_d_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(getActivity().app.getCurrentAccountUin()))) {
              break label1072;
            }
            getActivity().finish();
            return;
            paramBundle = paramBundle;
            paramBundle.printStackTrace();
          }
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramView.b(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_c_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {}
        for (bool = true;; bool = false)
        {
          this.jdField_e_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getActivity().getCurrentAccountUin());
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
            break label1024;
          }
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
          this.jdField_r_of_type_Boolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 32);
          break;
        }
        label1024:
        if (QLog.isColorLevel()) {
          QLog.e("Q.history.BaseFragment", 2, "doOnCreate, mTroopInfo is null");
        }
        getActivity().finish();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    getActivity().finish();
    return;
    label1072:
    label1109:
    int i1;
    int i2;
    int i3;
    label1434:
    label1532:
    String str;
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
    {
      getActivity().addObserver(this.jdField_a_of_type_Alrl);
      if ((this.jdField_s_of_type_Boolean) && (this.jdField_d_of_type_Int == 3)) {
        this.jdField_m_of_type_Int = 2;
      }
      if (this.jdField_d_of_type_Int == 0)
      {
        paramView = getResources().getDisplayMetrics();
        i1 = Math.max(paramView.widthPixels, paramView.heightPixels);
        i2 = getActivity().getTitleBarHeight();
        i3 = ImmersiveUtils.getStatusBarHeight(getActivity());
        int i4 = (int)(60.0F * this.jdField_a_of_type_Float);
        this.jdField_j_of_type_Int = getResources().getDimensionPixelSize(2131298983);
        this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131296657);
        if (this.jdField_k_of_type_Int == 0) {
          this.jdField_k_of_type_Int = ((int)(paramView.density * 58.0F));
        }
        this.jdField_i_of_type_Int = (i1 - i2 - i3 - i4);
        this.jdField_l_of_type_Int = ((this.jdField_i_of_type_Int - this.jdField_j_of_type_Int) / this.jdField_k_of_type_Int);
        this.jdField_a_of_type_Aidv = new aidv(getActivity(), this.jdField_a_of_type_Aidx, getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.i("Q.history.BaseFragment", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_i_of_type_Int), Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(this.jdField_k_of_type_Int), Integer.valueOf(this.jdField_l_of_type_Int) }));
        }
      }
      if (this.jdField_d_of_type_Int == 1) {
        break label1980;
      }
      if (this.jdField_d_of_type_Int != 11) {
        break label1780;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.jdField_f_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.equals(getActivity().app.getCurrentAccountUin()))) {
          break label1774;
        }
        bool = true;
        this.jdField_d_of_type_Boolean = bool;
      }
      azqs.b(getActivity().app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_f_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop())) {
        this.jdField_q_of_type_Boolean = true;
      }
      paramView = getResources().getStringArray(2130968681);
      if (this.jdField_q_of_type_Boolean) {
        break label2096;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = paramView;
      paramView = getResources().getStringArray(2130968680);
      if (this.jdField_q_of_type_Boolean) {
        break label2167;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString = paramView;
      label1555:
      q();
      s();
      t();
      a();
      paramBundle = "4";
      paramView = paramBundle;
      switch (this.jdField_d_of_type_Int)
      {
      default: 
        paramView = paramBundle;
      case 1: 
        label1618:
        str = "2";
        if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(getActivity().app.getCurrentAccountUin()))) {
          paramBundle = "0";
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_o_of_type_JavaLangString = paramBundle;
      a("exp", paramView, paramBundle);
      if (this.jdField_d_of_type_Int == 14) {
        B();
      }
      if (this.jdField_d_of_type_Int == 18) {
        azqs.b(getActivity().app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_d_of_type_Int != 3) {
        break;
      }
      ((amdu)getActivity().app.a(20)).q(this.jdField_c_of_type_JavaLangString);
      return;
      getActivity().app.addObserver(this.jdField_a_of_type_Ameq, true);
      break label1109;
      label1774:
      bool = false;
      break label1434;
      label1780:
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
          this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(getActivity().app.getCurrentAccountUin()))) || ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.contains(getActivity().app.getCurrentAccountUin()))))
        {
          bool = true;
          label1897:
          this.jdField_d_of_type_Boolean = bool;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mTroopInfo admin: " + this.jdField_g_of_type_JavaLangString + "  owner:" + this.jdField_f_of_type_JavaLangString);
        break;
        bool = false;
        break label1897;
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mTroopInfo==null");
        }
      }
      label1980:
      this.jdField_f_of_type_Boolean = true;
      this.jdField_u_of_type_JavaLangString = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
      }
      for (;;)
      {
        if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          this.jdField_d_of_type_Boolean = true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mDiscussionInfo owner: " + this.jdField_f_of_type_JavaLangString);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "doOnCreate, mDiscussionInfo==null");
        }
      }
      label2096:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[paramView.length + 1];
      i1 = 0;
      i3 = paramView.length;
      i2 = 0;
      while (i2 < i3)
      {
        paramBundle = paramView[i2];
        this.jdField_a_of_type_ArrayOfJavaLangString[i1] = paramBundle;
        i2 += 1;
        i1 += 1;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString[i1] = getResources().getString(2131721117);
      break label1532;
      label2167:
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[paramView.length + 1];
      i1 = 0;
      i3 = paramView.length;
      i2 = 0;
      while (i2 < i3)
      {
        paramBundle = paramView[i2];
        this.jdField_b_of_type_ArrayOfJavaLangString[i1] = paramBundle;
        i2 += 1;
        i1 += 1;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString[i1] = getResources().getString(2131721118);
      break label1555;
      paramView = "0";
      break label1618;
      paramView = "1";
      break label1618;
      paramView = "2";
      break label1618;
      paramView = "3";
      break label1618;
      paramBundle = str;
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        paramBundle = str;
        if (this.jdField_g_of_type_JavaLangString.contains(getActivity().app.getCurrentAccountUin())) {
          paramBundle = "1";
        }
      }
    }
  }
  
  protected void p()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131378458));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_b_of_type_AndroidViewView = a(2131377957);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368670));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131368616));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364068));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131368624));
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131368626));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368655));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368638));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)a(2131378454));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)a(2131368223));
    this.jdField_e_of_type_AndroidViewView = a(2131375588);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369562));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369771));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131367739));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369792));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697955));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368639));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843447);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131720985));
  }
  
  protected void q()
  {
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691926));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692682));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691930));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label1221;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_m_of_type_Int >= 0) && (this.jdField_m_of_type_Int < this.jdField_b_of_type_ArrayOfJavaLangString.length)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int]);
      }
    }
    for (;;)
    {
      if (this.jdField_m_of_type_Int == 8)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131702012));
      }
      if (this.jdField_d_of_type_Int == 14) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689700));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840102);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aidb(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696954));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690648);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840102);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aidc(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696956));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690648);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aidd(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696785));
        if (this.jdField_i_of_type_JavaLangString == null) {
          this.jdField_i_of_type_JavaLangString = getString(2131690623);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840102);
        break;
      }
      if ((this.jdField_d_of_type_Int == 14) || (this.jdField_d_of_type_Int == 16))
      {
        if ((this.jdField_k_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697718);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        break;
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131721090);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692017);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      if ((this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21))
      {
        if (this.jdField_l_of_type_JavaLangString != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692682));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691930));
        break;
      }
      if (this.jdField_d_of_type_Int == 18)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720986);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      if (this.jdField_d_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131702026));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aide(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 23)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720986);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131702019));
      if ((this.jdField_k_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
      }
      if (this.jdField_i_of_type_JavaLangString == null) {
        this.jdField_i_of_type_JavaLangString = getString(2131690623);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692682);
      if (this.jdField_d_of_type_Int != 4)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840102);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697955));
        if (this.jdField_d_of_type_Int == 22) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1221:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void r()
  {
    if ((this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 5) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 22)) {
      if ((this.jdField_d_of_type_Int == 9) && (this.jdField_e_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aibt(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aibu(this));
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 22)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aibv(this));
      }
      while ((this.jdField_h_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption == 3)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        if (this.jdField_d_of_type_Int == 7)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else if ((this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 20))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aibw(this));
        }
        else if (this.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aibx(this));
        }
        else if (this.jdField_d_of_type_Int == 22)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  protected void s()
  {
    View localView = getActivity().getLayoutInflater().inflate(2131562775, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376222));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362536));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView;
    int i1;
    label127:
    int i2;
    label145:
    Object localObject;
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839217);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378896);
      this.jdField_g_of_type_Int = ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).leftMargin;
      if ((this.jdField_d_of_type_Int != 3) || (!this.jdField_d_of_type_Boolean) || (this.jdField_b_of_type_Int == 1)) {
        break label869;
      }
      i1 = 1;
      if ((this.jdField_d_of_type_Int != 11) || (!this.jdField_d_of_type_Boolean)) {
        break label874;
      }
      i2 = 1;
      if ((i1 != 0) || (i2 != 0))
      {
        localObject = getString(2131721077);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375631);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368796)).setBackgroundDrawable(bdhj.d());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372562);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new aiby(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aibz(this, (String)localObject));
        if (!this.jdField_s_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (amdu)getActivity().app.a(20);
        if (bdin.d(BaseApplication.getContext())) {
          break label879;
        }
        QQToast.a(getActivity(), 1, 2131694766, 0).b(getActivity().getTitleBarHeight());
      }
      if ((this.jdField_d_of_type_Int != 3) || (this.jdField_d_of_type_Boolean) || (this.jdField_b_of_type_Int == 1)) {
        break label984;
      }
      i1 = 1;
      label377:
      if ((this.jdField_d_of_type_Int != 11) || (this.jdField_d_of_type_Boolean)) {
        break label989;
      }
      i2 = 1;
      label395:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && ((i1 != 0) || (i2 != 0)))
      {
        localObject = (amdu)getActivity().app.a(20);
        if (bdin.d(BaseApplication.getContext())) {
          break label994;
        }
        QQToast.a(getActivity(), 1, 2131694766, 0).b(getActivity().getTitleBarHeight());
      }
      label462:
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365851);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363522)).setVisibility(8);
      if (this.jdField_d_of_type_Int != 19) {
        break label1061;
      }
      localView = getActivity().getLayoutInflater().inflate(2131562767, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new aica(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aidh = new aidh(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Aidh);
      if ((this.jdField_d_of_type_Int == 19) || (this.jdField_d_of_type_Int == 21)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 19)) {
        H();
      }
      ((EditText)localObject).setOnTouchListener(new aicb(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_d_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839214);
      break;
      label869:
      i1 = 0;
      break label127;
      label874:
      i2 = 0;
      break label145;
      label879:
      if ((this.jdField_a_of_type_Alri != null) && (this.jdField_d_of_type_Int == 11)) {
        this.jdField_a_of_type_Alri.b(getActivity().app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839229);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject != null) {
          ((amdu)localObject).a(getActivity().app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString);
        }
      }
      label984:
      i1 = 0;
      break label377;
      label989:
      i2 = 0;
      break label395;
      label994:
      if ((this.jdField_a_of_type_Alri != null) && (this.jdField_d_of_type_Int == 11))
      {
        this.jdField_a_of_type_Alri.b(getActivity().app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        break label462;
      }
      if (localObject == null) {
        break label462;
      }
      ((amdu)localObject).a(getActivity().app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString);
      break label462;
      label1061:
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  protected void t()
  {
    J();
    if (this.jdField_d_of_type_Int == 9) {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.26(this), 8, null, true);
    }
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      long l1;
      long l2;
      if ((this.jdField_d_of_type_Int != 15) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 16))
      {
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(13));
        localObject1 = null;
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 16) && (bdin.g(getActivity())))
        {
          localObject2 = getActivity().getSharedPreferences("last_update_time" + getActivity().app.getCurrentAccountUin(), 4);
          l1 = ((SharedPreferences)localObject2).getLong("key_last_update_time" + this.jdField_c_of_type_JavaLangString, 0L);
          l2 = Math.abs(System.currentTimeMillis() - l1);
          int i1 = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            i1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum;
          }
          int i2 = ((SharedPreferences)localObject2).getInt("key_last_update_num" + this.jdField_c_of_type_JavaLangString, 0);
          ((SharedPreferences)localObject2).edit().putInt("key_last_update_num" + this.jdField_c_of_type_JavaLangString, i1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "fillData, lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L + " min  curMemberNum:" + i1 + " lastUpdateMemberNum:" + i2);
          }
          localObject2 = (amdu)getActivity().app.a(20);
          if (localObject2 != null)
          {
            this.jdField_j_of_type_Boolean = true;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            ((amdu)localObject2).a(true, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, d(), this.jdField_a_of_type_Long, 0);
            if (QLog.isColorLevel()) {
              QLog.d("Q.history.BaseFragment", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_b_of_type_JavaLangString + " troopCode: " + this.jdField_c_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((amdu)localObject2).a(Long.parseLong(this.jdField_c_of_type_JavaLangString), 0L, 1, 0, 0);
        if (this.jdField_d_of_type_Int == 3)
        {
          l1 = getActivity().getSharedPreferences("last_update_time" + getActivity().app.getCurrentAccountUin(), 4).getLong("key_troop_info_last_update" + this.jdField_c_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (amdu)getActivity().app.a(20);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              ((amdu)localObject2).j(this.jdField_c_of_type_JavaLangString);
              ((amdu)localObject2).a(1, aloz.a(this.jdField_c_of_type_JavaLangString), 0L, 2, 0, 0, true);
              if (QLog.isColorLevel()) {
                QLog.d("Q.history.BaseFragment", 2, "fillData, getGroupInfoReq, mTroopUin:" + this.jdField_c_of_type_JavaLangString);
              }
            }
          }
        }
        if (localObject1 != null) {
          ThreadManager.post((Runnable)localObject1, 8, null, true);
        }
        if (this.jdField_d_of_type_Int != 14) {
          continue;
        }
        ((bcod)getActivity().app.getManager(113)).a(this.jdField_c_of_type_JavaLangString, new aich(this));
        return;
        localObject1 = new ChatHistoryTroopMemberFragment.27(this);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.history.BaseFragment", 2, localException.toString());
          }
        }
      }
    }
  }
  
  public void u()
  {
    String[] arrayOfString;
    int i1;
    label55:
    int i2;
    if (this.jdField_d_of_type_Int == 9)
    {
      arrayOfString = getResources().getStringArray(2130968675);
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
        break label168;
      }
      if (!this.jdField_d_of_type_Boolean) {
        break label116;
      }
      i1 = arrayOfString.length;
      this.jdField_a_of_type_Bhuf = bhuf.a(getActivity());
      i2 = 0;
      label68:
      if (i2 >= i1) {
        break label206;
      }
      if (!this.jdField_h_of_type_Boolean) {
        break label270;
      }
      if (!alud.a(2131701974).equals(arrayOfString[i2])) {
        break label191;
      }
    }
    label270:
    for (;;)
    {
      i2 += 1;
      break label68;
      arrayOfString = getResources().getStringArray(2130968673);
      break;
      label116:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption != 3)
        {
          i1 = arrayOfString.length - 1;
          break label55;
        }
        i1 = arrayOfString.length - 2;
        break label55;
      }
      i1 = arrayOfString.length - 2;
      break label55;
      label168:
      if (this.jdField_d_of_type_Int == 9)
      {
        i1 = arrayOfString.length;
        break label55;
      }
      i1 = arrayOfString.length - 5;
      break label55;
      label191:
      if (i2 == 2)
      {
        this.jdField_a_of_type_Bhuf.c(arrayOfString[i2]);
        label206:
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
          this.jdField_a_of_type_Bhuf.a(arrayOfString[3], 3);
        }
        this.jdField_a_of_type_Bhuf.c(2131690648);
        this.jdField_a_of_type_Bhuf.a(this.jdField_a_of_type_Bhuk);
        this.jdField_a_of_type_Bhuf.show();
        return;
        if (i2 == 3)
        {
          this.jdField_a_of_type_Bhuf.a(arrayOfString[i2], 3);
        }
        else
        {
          this.jdField_a_of_type_Bhuf.c(arrayOfString[i2]);
          if (arrayOfString[i2].equals(alud.a(2131702059))) {
            azqs.b(getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
  }
  
  public void v()
  {
    if ((this.jdField_a_of_type_Aidh != null) && (QLog.isColorLevel())) {
      QLog.d("Q.history.BaseFragment", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aidh.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Aidh.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Aidh.jdField_a_of_type_Int) }));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.jdField_m_of_type_Int == 0) {
      if (this.jdField_d_of_type_Int == 11) {
        if ((this.jdField_a_of_type_Aidh != null) && (this.jdField_a_of_type_Aidh.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_Aidh.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility()) {
        G();
      }
      return;
      if (this.jdField_d_of_type_Int == 0)
      {
        if ((this.jdField_a_of_type_Aidh != null) && (this.jdField_a_of_type_Aidh.jdField_b_of_type_Int + this.jdField_a_of_type_Aidh.jdField_c_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Aidh.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else if ((this.jdField_a_of_type_Aidh != null) && (this.jdField_a_of_type_Aidh.jdField_b_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Aidh.jdField_a_of_type_Int > 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
      }
    }
  }
  
  public void w()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755801);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131558428);
      localDialog = this.jdField_c_of_type_AndroidAppDialog;
      if (this.jdField_d_of_type_Int == 1) {
        break label79;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131365233)).setText(getString(2131719785));
      return;
      label79:
      bool = false;
    }
  }
  
  public void x()
  {
    if (this.jdField_d_of_type_Int == 11) {
      azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 7, 0, "", "", "", "");
    int i1 = this.jdField_b_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new aicl(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_d_of_type_AndroidAppDialog.setOnDismissListener(new aicm(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131363522);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new aicn(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aidj.notifyDataSetChanged();
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void y()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(14);
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void z()
  {
    Intent localIntent = new Intent(getActivity(), PublicAccountBrowser.class);
    String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_c_of_type_JavaLangString;
    localIntent.putExtra("url", str);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "showMemberDstribute:" + str);
    }
    a("Clk_mberdist", this.jdField_o_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment
 * JD-Core Version:    0.7.0.1
 */