package com.tencent.mobileqq.activity;

import Override;
import afet;
import afeu;
import afev;
import afew;
import afex;
import afey;
import afez;
import affa;
import affb;
import affc;
import affe;
import afff;
import affg;
import affh;
import affi;
import affj;
import affl;
import affm;
import affn;
import affo;
import affp;
import affq;
import affr;
import affs;
import afft;
import affu;
import affv;
import affw;
import affx;
import affy;
import affz;
import afga;
import afgb;
import afgc;
import afgd;
import afge;
import afgf;
import afgg;
import afgi;
import afgk;
import afgm;
import afgn;
import afgo;
import afgp;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import anrb;
import antl;
import antp;
import antq;
import anvk;
import anvx;
import aocy;
import aoep;
import aofu;
import azry;
import bbcg;
import bdfk;
import bdla;
import bdlf;
import begq;
import bfkd;
import bfke;
import bfwu;
import bgek;
import bgel;
import bghd;
import bgko;
import bgls;
import bhbu;
import bhbx;
import bheg;
import bhmb;
import bhta;
import bipq;
import bipr;
import bkzi;
import bkzq;
import bleh;
import blek;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ntb;
import ntf;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;

public class TroopMemberListActivity
  extends BaseActivity
  implements bipq, bipr, AdapterView.OnItemClickListener
{
  public static double b;
  private static int jdField_p_of_type_Int = 1000;
  public double a;
  public float a;
  public int a;
  public long a;
  public afgk a;
  public afgm a;
  public Dialog a;
  protected Drawable a;
  public Handler a;
  public LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  protected RelativeLayout a;
  public TextView a;
  protected antl a;
  public antq a;
  public aofu a;
  public bbcg a;
  public bkzi a;
  protected bkzq a;
  public bleh a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public TroopInfoData a;
  public IndexView a;
  public PinnedDividerSwipListView a;
  public XListView a;
  public String a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  public ArrayList<String> a;
  public List<afgi> a;
  public boolean a;
  private long[] jdField_a_of_type_ArrayOfLong;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  public long b;
  public Dialog b;
  public View.OnClickListener b;
  protected View b;
  public ImageView b;
  public LinearLayout b;
  protected RelativeLayout b;
  public TextView b;
  public String b;
  public ArrayList<String> b;
  public List<afgi> b;
  public boolean b;
  private long[] jdField_b_of_type_ArrayOfLong;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  public int c;
  private long jdField_c_of_type_Long;
  public View.OnClickListener c;
  protected View c;
  protected RelativeLayout c;
  public TextView c;
  protected String c;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<DiscussionMemberInfo> c;
  public boolean c;
  private long[] jdField_c_of_type_ArrayOfLong;
  public int d;
  private long jdField_d_of_type_Long;
  public View.OnClickListener d;
  protected View d;
  public RelativeLayout d;
  public TextView d;
  protected String d;
  private ArrayList<String> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public List<String> d;
  public boolean d;
  protected int e;
  private View jdField_e_of_type_AndroidViewView;
  protected RelativeLayout e;
  protected TextView e;
  public String e;
  private ArrayList<String> jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  public List<String> e;
  public boolean e;
  protected int f;
  public String f;
  private ArrayList<String> f;
  protected List<String> f;
  public boolean f;
  protected int g;
  public String g;
  private ArrayList<String> jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  private List<oidb_cmd0x74f.Range> jdField_g_of_type_JavaUtilList = new ArrayList();
  protected boolean g;
  public int h;
  protected String h;
  public boolean h;
  public int i;
  protected String i;
  protected boolean i;
  public int j;
  protected String j;
  protected boolean j;
  public int k;
  protected String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  private int jdField_n_of_type_Int = -1;
  public String n;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  protected String o;
  private boolean jdField_o_of_type_Boolean;
  public final String p;
  private boolean jdField_p_of_type_Boolean = true;
  public final String q;
  private boolean q;
  public final String r;
  private boolean r;
  protected String s = "";
  public String t = "";
  public String u = "";
  protected String v;
  private String w = anvx.a(2131714919);
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
  }
  
  public TroopMemberListActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
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
    this.jdField_n_of_type_JavaLangString = "2";
    this.jdField_o_of_type_JavaLangString = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
    this.jdField_p_of_type_JavaLangString = "param_seq_name";
    this.jdField_q_of_type_JavaLangString = "param_seq_days";
    this.jdField_r_of_type_JavaLangString = "param_deleted_uins";
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_l_of_type_Int = 50;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afgg(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afet(this);
    this.jdField_m_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_Bkzq = new affj(this);
    this.jdField_a_of_type_AndroidOsHandler = new affq(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new affr(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new affs(this);
    this.jdField_a_of_type_Antq = new affv(this);
    this.jdField_a_of_type_Aofu = new affx(this);
  }
  
  private int a()
  {
    int i1 = 1;
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_o_of_type_Boolean) {
        i1 = 3;
      }
      return i1;
      i1 = 2;
    }
  }
  
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, TroopMemberListActivity.class);
    paramContext.putExtra("troop_uin", paramString);
    paramContext.putExtra("param_from", paramInt);
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bleh.getContentView().findViewById(2131365157);
    int i1 = 0;
    if (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      blek localblek = (blek)((View)localObject).getTag();
      if (localblek != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131378828);
        if (localObject != null)
        {
          if (localblek.jdField_a_of_type_Int != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131167037));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131167026));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(anvx.a(2131714989), new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(anvx.a(2131714925), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
      this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_Afgk.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_Afgk.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        q();
        h();
        if (this.jdField_a_of_type_Afgk == null) {
          break label302;
        }
        this.jdField_a_of_type_Afgk.notifyDataSetChanged();
        this.jdField_a_of_type_Afgk.a();
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setVisibility(0);
        if ((!this.jdField_g_of_type_Boolean) || (this.jdField_d_of_type_Int == 11)) {
          k();
        }
        d();
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
      this.jdField_a_of_type_Afgk = new afgk(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Afgk);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, ntf paramntf)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    ntb.b(paramQQAppInterface, paramntf, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void a(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
    localReportDialog.setContentView(2131559182);
    ((TextView)localReportDialog.findViewById(2131365648)).setText(getString(2131691472));
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365644);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131364596);
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
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1))
    {
      bool = true;
      if (paramList.size() != 1) {
        break label291;
      }
      localTextView.setText(getString(2131693425));
      localCheckBox.setText(getString(2131718019));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localTextView = (TextView)localReportDialog.findViewById(2131365633);
      localObject = (TextView)localReportDialog.findViewById(2131365639);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new afft(this, localReportDialog));
      ((TextView)localObject).setOnClickListener(new affu(this, paramList, localCheckBox, bool, localReportDialog));
      localReportDialog.show();
      return;
      bool = false;
      break;
      label291:
      localTextView.setText(getString(2131694180));
      localCheckBox.setText(getString(2131694182));
    }
  }
  
  private void a(List<TroopMemberInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, processIndex:" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    bgls localbgls = (bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!bhbx.d(localTroopMemberInfo.memberuin)) {
          break label245;
        }
        if ((this.jdField_d_of_type_Int != 2) || ((!localTroopMemberInfo.memberuin.equals(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.contains(localTroopMemberInfo.memberuin)))) {
          break label166;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label166:
        if (((this.jdField_f_of_type_JavaUtilList == null) || (!this.jdField_f_of_type_JavaUtilList.contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localbgls.b(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localanvk));
          continue;
          label245:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:" + localTroopMemberInfo.memberuin);
          }
        }
      }
    }
    paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localArrayList);
    paramList.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if ((this.jdField_d_of_type_Int == 3) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != 1))
    {
      i1 = 1;
      if ((!this.jdField_a_of_type_Boolean) && (paramBoolean3) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
      {
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380038);
        localObject1 = getString(2131719642);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376504);
        ((TextView)localObject2).setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369417)).setBackgroundDrawable(bheg.d());
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373427);
        ((ImageView)localObject3).setVisibility(8);
        if (i1 != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new affy(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new affz(this, (String)localObject1));
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetAtAllRemianCountInfo:" + paramBoolean1 + ", " + paramString1 + ", " + paramBoolean2 + ", " + paramInt1 + ", " + paramString2 + ", " + paramString3);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376504)).setCompoundDrawables(null, null, null, null);
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
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380038)).setTextColor(getResources().getColor(2131167026));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376504);
      localObject2 = anvx.a(2131714938);
      localObject3 = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372232);
      ((Button)localObject3).setVisibility(8);
      ((Button)localObject3).setOnClickListener(new afga(this));
      i1 = ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
      if (this.jdField_d_of_type_Int != 11) {
        break label774;
      }
    } while (!paramString1.equals(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = paramInt2;
    if ((paramBoolean2) && (paramInt1 > 0))
    {
      paramBoolean1 = true;
      label529:
      this.jdField_f_of_type_Boolean = paramBoolean1;
      if (!this.jdField_f_of_type_Boolean) {
        break label679;
      }
      this.jdField_g_of_type_JavaLangString = (anvx.a(2131714942) + paramInt1 + anvx.a(2131714945));
      ((TextView)localObject1).setText(this.jdField_g_of_type_JavaLangString);
      paramString1 = (String)localObject2 + "," + this.jdField_g_of_type_JavaLangString;
      label616:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        paramString2.rightMargin = AIOUtils.dp2px(20.0F, getResources());
        ((TextView)localObject1).setLayoutParams(paramString2);
      }
    }
    for (paramString2 = paramString1;; paramString2 = (String)localObject2 + "," + paramString1)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramString2);
      return;
      paramBoolean1 = false;
      break label529;
      label679:
      if (paramInt1 == 0)
      {
        this.jdField_g_of_type_JavaLangString = anvx.a(2131715004);
        paramString1 = (String)localObject2 + ",剩余0次";
        ((TextView)localObject1).setText("剩余0次");
        break label616;
      }
      this.jdField_g_of_type_JavaLangString = "";
      paramString1 = (String)localObject2 + "," + anvx.a(2131715003);
      ((TextView)localObject1).setText("");
      break label616;
      label774:
      if (!paramString1.equals(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      this.jdField_f_of_type_Boolean = paramBoolean2;
      this.jdField_g_of_type_JavaLangString = paramString3;
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("TroopMemberListActivityget_troop_member", 1, "updateUIForAtAllRemainedCount remainTips empty");
        return;
      }
      paramString1 = paramString2;
      if (!this.jdField_f_of_type_Boolean)
      {
        paramString1 = paramString2;
        if (i1 != 3)
        {
          ((Button)localObject3).setVisibility(0);
          paramString2 = paramString2 + ",\n超级会员可继续使用";
          ((TextView)localObject1).setGravity(21);
          ((TextView)localObject1).setLineSpacing(this.jdField_a_of_type_Float * 5.0F, 1.0F);
          paramInt1 = (int)(anvx.a(2131715000).length() * 12 * this.jdField_a_of_type_Float);
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
      if (paramString1.contains(anvx.a(2131715010)))
      {
        paramInt1 = paramString1.indexOf(anvx.a(2131715011));
        paramInt2 = anvx.a(2131714928).length();
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
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
        break label85;
      }
      long l1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
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
        } while (!((bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramString));
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
      QLog.d("TroopMemberListActivityget_troop_member", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
      return;
      paramInt -= i1;
      if (paramInt > 0) {
        paramTextView.setMaxWidth(paramInt);
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberListActivityget_troop_member", 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:" + i1 + " nTargetMaxWidth:" + paramInt);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bleh == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        blek localblek = new blek();
        localblek.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localblek.jdField_a_of_type_Int = i1;
        localblek.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localArrayList.add(localblek);
        i1 += 1;
      }
      this.jdField_a_of_type_Bleh = bleh.a(this, localArrayList, new affm(this), null, UIUtils.dip2px(this, 135.0F), false);
      this.jdField_a_of_type_Bleh.setTouchInterceptor(new affw(this));
      a(this.jdField_m_of_type_Int);
    }
    this.jdField_a_of_type_Bleh.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(UIUtils.dip2px(this, 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
  }
  
  private void q()
  {
    if (((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(this.app.getCurrentAccountUin()))) || ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((!this.jdField_e_of_type_Boolean) && (i1 != 0) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 17)) && (System.currentTimeMillis() > this.jdField_c_of_type_Long)) {
        ThreadManager.post(new TroopMemberListActivity.20(this), 8, null, true);
      }
      return;
    }
  }
  
  private void r()
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_e_of_type_AndroidViewView = getLayoutInflater().inflate(2131562997, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368794);
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
      localObject = (afgi)localIterator.next();
      if (((afgi)localObject).jdField_b_of_type_Long == 0L) {
        ((afgi)localObject).jdField_b_of_type_Long = ((afgi)localObject).jdField_a_of_type_Long;
      }
      if (TextUtils.isEmpty(a(((afgi)localObject).jdField_b_of_type_Long, localCalendar, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
        break label353;
      }
      i1 += 1;
    }
    label353:
    for (;;)
    {
      break;
      localTextView.setText(i1 + "");
      if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {}
      for (int i2 = 0;; i2 = 1)
      {
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new affe(this, i1, i2));
        s();
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
        bdla.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.jdField_b_of_type_JavaLangString, "" + i2, "", "");
        return;
      }
    }
  }
  
  private void s()
  {
    Object localObject;
    DisplayMetrics localDisplayMetrics;
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView != null))
    {
      localObject = this.jdField_e_of_type_AndroidViewView.findViewById(2131376676);
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
  
  private void t()
  {
    this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(this);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131562813);
    Object localObject = this.jdField_b_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)getSystemService("input_method");
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT < 24))
    {
      this.jdField_b_of_type_AndroidAppDialog.getWindow().addFlags(67108864);
      int i1 = getResources().getColor(2131167084);
      new SystemBarCompact(this.jdField_b_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131376947);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131377153));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838911));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Afgm = new afgm(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afgm);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new afff(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131366280));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new afgo(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131376947);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131368378));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131372032);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131376602));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new affg(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new affh(this));
  }
  
  private void u()
  {
    int i1 = this.jdField_a_of_type_Afgk.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format(anvx.a(2131714991), new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new affl(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131715017));
  }
  
  private void v()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(0, this.jdField_o_of_type_Int, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  public afgi a(DiscussionMemberInfo paramDiscussionMemberInfo, anvk paramanvk)
  {
    afgi localafgi = new afgi();
    localafgi.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramanvk != null) {
      localFriends = paramanvk.b(paramDiscussionMemberInfo.memberUin);
    }
    localafgi.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localafgi.jdField_a_of_type_Short = 0;
    localafgi.jdField_c_of_type_JavaLangString = ChnToSpell.a(localafgi.jdField_b_of_type_JavaLangString, 2);
    localafgi.a(ChnToSpell.a(localafgi.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localafgi.e(localFriends.remark);
      localafgi.h(ChnToSpell.a(localafgi.jdField_j_of_type_JavaLangString, 1));
      localafgi.f(ChnToSpell.a(localafgi.jdField_j_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localafgi.i(paramDiscussionMemberInfo.memberName);
        localafgi.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localafgi.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      if (this.jdField_a_of_type_Bbcg != null) {
        this.jdField_a_of_type_Bbcg.a(localafgi);
      }
      return localafgi;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localafgi.e(paramDiscussionMemberInfo.inteRemark);
        localafgi.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localafgi.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public afgi a(TroopMemberInfo paramTroopMemberInfo, anvk paramanvk)
  {
    afgi localafgi = new afgi();
    localafgi.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramanvk != null) {
      localFriends = paramanvk.b(paramTroopMemberInfo.memberuin);
    }
    localafgi.jdField_b_of_type_JavaLangString = ContactUtils.getTroopMemberName(this.app, this.jdField_b_of_type_JavaLangString, localafgi.jdField_a_of_type_JavaLangString, true);
    localafgi.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localafgi.jdField_c_of_type_JavaLangString = ChnToSpell.a(localafgi.jdField_b_of_type_JavaLangString, 2);
    localafgi.a(ChnToSpell.a(localafgi.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localafgi.b(paramTroopMemberInfo.friendnick);
      localafgi.d(paramTroopMemberInfo.pyAll_friendnick);
      localafgi.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localafgi.e(localFriends.remark);
      localafgi.h(ChnToSpell.a(localafgi.jdField_j_of_type_JavaLangString, 1));
      localafgi.f(ChnToSpell.a(localafgi.jdField_j_of_type_JavaLangString, 2));
      localafgi.g(localFriends.remark);
      if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
      {
        localafgi.i(paramTroopMemberInfo.troopColorNick);
        localafgi.k(paramTroopMemberInfo.pyAll_troopnick);
        localafgi.j(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localafgi.jdField_o_of_type_Int = paramTroopMemberInfo.troopColorNickId;
      localafgi.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localafgi.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localafgi.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localafgi.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
      localafgi.jdField_d_of_type_Int = paramTroopMemberInfo.newRealLevel;
      localafgi.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localafgi.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localafgi.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localafgi.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      localafgi.jdField_e_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_b_of_type_JavaLangString, localafgi.jdField_a_of_type_JavaLangString);
      if ((d1 == -1000.0D) || (d1 == -100.0D)) {
        break label723;
      }
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
      if (d1 <= 10.0D) {
        break label688;
      }
      localafgi.t = ((int)d1 + "km");
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localafgi.u = paramTroopMemberInfo.mUniqueTitle;
        localafgi.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if (this.jdField_a_of_type_Bbcg != null) {
        this.jdField_a_of_type_Bbcg.a(localafgi);
      }
      localafgi.jdField_f_of_type_Int = paramTroopMemberInfo.mVipType;
      localafgi.jdField_g_of_type_Int = paramTroopMemberInfo.mVipLevel;
      localafgi.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localafgi.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
      localafgi.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
      localafgi.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localafgi.v = paramTroopMemberInfo.honorList;
      return localafgi;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.jdField_e_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localafgi.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localafgi.h(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localafgi.f(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
        break;
      }
      localafgi.e(paramTroopMemberInfo.autoremark);
      localafgi.h(paramTroopMemberInfo.pyAll_autoremark);
      localafgi.f(paramTroopMemberInfo.pyFirst_autoremark);
      break;
      label688:
      localafgi.t = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
      continue;
      label723:
      localafgi.t = "";
    }
  }
  
  public afgi a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "removeItem:" + paramString);
    }
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          afgi localafgi = (afgi)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localafgi != null) && (localafgi.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (afgi)this.jdField_a_of_type_JavaUtilList.remove(i1);
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
  
  public afgp a(String paramString, boolean paramBoolean)
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
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof afgp)))
      {
        localObject2 = (afgp)((View)localObject2).getTag();
        if ((((afgp)localObject2).jdField_a_of_type_JavaLangString != null) && (((afgp)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "findListItemHolderByUin:" + i1);
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
  
  public List<afgi> a(List<afgi> paramList, String paramString1, String paramString2)
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
        afgi localafgi = (afgi)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localafgi.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localafgi);
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
        paramString1 = (afgi)paramList.get(i3);
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
        paramString1 = (afgi)paramList.get(i4);
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
          paramString1 = (afgi)paramList.get(i2);
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
            paramString1 = (afgi)paramList.get(i2);
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
              paramString1 = (afgi)paramList.get(i2);
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
    Object localObject = (ViewGroup)findViewById(2131376760);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131379020);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369231);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void a(afgi paramafgi)
  {
    int i1 = 3;
    if ((paramafgi != null) && (paramafgi.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.clear();
      paramafgi = new Intent();
      paramafgi.putExtra("result", new JSONArray().toString());
      setResult(-1, paramafgi);
      bdla.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      finish();
    }
    label94:
    label633:
    do
    {
      do
      {
        Object localObject2;
        do
        {
          break label94;
          do
          {
            return;
          } while ((paramafgi == null) || (paramafgi.jdField_a_of_type_JavaLangString == null));
          if (this.jdField_d_of_type_Int == 1)
          {
            if (this.app.getCurrentAccountUin().equals(paramafgi.jdField_a_of_type_JavaLangString))
            {
              localObject1 = new ProfileActivity.AllInOne(paramafgi.jdField_a_of_type_JavaLangString, 0);
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = ContactUtils.getAccountNickName(this.app, paramafgi.jdField_a_of_type_JavaLangString);
              ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 3;
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 4;
              ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
              return;
            }
            a(paramafgi.jdField_a_of_type_JavaLangString, paramafgi.jdField_b_of_type_JavaLangString);
            return;
          }
          if (this.jdField_d_of_type_Int == 2)
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_uin", paramafgi.jdField_a_of_type_JavaLangString);
            localObject2 = new TroopMemberListActivity.TroopAdmin();
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramafgi.jdField_a_of_type_JavaLangString;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramafgi.jdField_a_of_type_Short;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramafgi.jdField_b_of_type_JavaLangString;
            ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
            setResult(-1, (Intent)localObject1);
            finish();
            return;
          }
          if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            localObject1 = getIntent();
            if (this.jdField_o_of_type_Boolean)
            {
              ((Intent)localObject1).putExtra("member_display_name", paramafgi.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("isApollo", true);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("member_uin", paramafgi.jdField_a_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
              setResult(-1, (Intent)localObject1);
              finish();
              return;
              ((Intent)localObject1).putExtra("member_display_name", paramafgi.jdField_b_of_type_JavaLangString);
            }
          }
          if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 4) && (this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
            break;
          }
          e(paramafgi.jdField_a_of_type_JavaLangString);
        } while (this.jdField_d_of_type_Int != 22);
        bhbu.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
        return;
        if (this.jdField_d_of_type_Int == 5)
        {
          if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramafgi.jdField_a_of_type_JavaLangString)))
          {
            startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.jdField_b_of_type_JavaLangString, paramafgi.jdField_a_of_type_JavaLangString, i1, paramafgi.u), 2);
            this.v = paramafgi.jdField_a_of_type_JavaLangString;
            localObject1 = this.app;
            localObject2 = this.jdField_b_of_type_JavaLangString;
            i1 = this.jdField_m_of_type_Int;
            if (!this.jdField_m_of_type_Boolean) {
              break label633;
            }
          }
          for (paramafgi = "1";; paramafgi = "0")
          {
            bdla.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramafgi, "");
            return;
            if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(paramafgi.jdField_a_of_type_JavaLangString)))
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
          localObject1 = getIntent();
          ((Intent)localObject1).putExtra("member_uin", paramafgi.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_nickname", paramafgi.jdField_g_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_display_name", paramafgi.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("troop_gift_from", this.jdField_d_of_type_JavaLangString);
          setResult(-1, (Intent)localObject1);
          finish();
          return;
        }
        if ((this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 20))
        {
          if (this.jdField_f_of_type_Int == 1)
          {
            this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.add(paramafgi);
            paramafgi = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList != null)
            {
              localObject2 = this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  afgi localafgi = (afgi)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localafgi.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localafgi.jdField_b_of_type_JavaLangString);
                    ((JSONArray)localObject1).put(localJSONObject);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberListActivityget_troop_member", 2, "json put error");
                      }
                    }
                  }
                }
              }
            }
            paramafgi.putExtra("result", ((JSONArray)localObject1).toString());
            setResult(-1, paramafgi);
            finish();
            return;
          }
          if (this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.contains(paramafgi)) {
            this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.remove(paramafgi);
          }
          for (;;)
          {
            this.jdField_a_of_type_Afgk.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.size() < this.jdField_f_of_type_Int)
            {
              this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.add(paramafgi);
            }
            else if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.add(paramafgi);
            }
            else
            {
              QQToast.a(this, getResources().getString(this.jdField_h_of_type_Int, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).a();
            }
          }
        }
        if ((this.jdField_d_of_type_Int != 18) && (this.jdField_d_of_type_Int != 19)) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_uin", paramafgi.jdField_a_of_type_JavaLangString);
        PublicFragmentActivity.a(this, (Intent)localObject1, TroopMemberHistoryFragment.class);
      } while (this.jdField_d_of_type_Int != 19);
      paramafgi = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
      bhbu.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(paramafgi) });
      return;
    } while (this.jdField_d_of_type_Int != 23);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_member_name", paramafgi.jdField_g_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramafgi.jdField_a_of_type_JavaLangString));
    ((Intent)localObject1).putExtra("folderPath", "/");
    ((Intent)localObject1).putExtra("param_from", 6000);
    TroopFileProxyActivity.a(this, (Intent)localObject1, this.app.getCurrentAccountUin());
  }
  
  public void a(afgp paramafgp, afgi paramafgi, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    label84:
    Object localObject;
    label153:
    label474:
    int i5;
    if (paramBoolean1)
    {
      str = this.u;
      paramafgp.jdField_a_of_type_Boolean = paramBoolean1;
      paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramafgp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramafgp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramafgp.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if ((this.jdField_m_of_type_Int != 1) && (this.jdField_m_of_type_Int != 5)) {
        break label896;
      }
      if (paramafgi.jdField_d_of_type_Boolean) {
        break label883;
      }
      paramafgp.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      if ((this.jdField_b_of_type_Boolean) || (a()) || (paramafgi.jdField_e_of_type_Int == -100) || (paramafgi.jdField_e_of_type_Int == 0)) {
        break label918;
      }
      paramafgp.j.setVisibility(8);
      paramafgp.j.setText("LV" + paramafgi.jdField_e_of_type_Int);
      VipUtils.a(this.app, this, getResources(), paramafgp, paramafgi);
      if ((this.jdField_d_of_type_Int != 13) || (!paramBoolean1)) {
        break label930;
      }
      paramBitmap = paramafgi.jdField_b_of_type_JavaLangString + "(" + paramafgi.jdField_a_of_type_JavaLangString + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramafgi.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramafgp.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label265:
      bhta.a(paramafgp.jdField_e_of_type_AndroidWidgetTextView, this, paramafgi.jdField_o_of_type_Int, false);
      if ((paramBoolean2) && (paramafgp.k != null))
      {
        paramBitmap = anvx.a(2131714911) + paramafgi.jdField_j_of_type_JavaLangString;
        paramafgp.k.setText(paramBitmap);
      }
      paramafgp.jdField_a_of_type_JavaLangString = paramafgi.jdField_a_of_type_JavaLangString;
      paramafgp.jdField_c_of_type_Int = 1;
      paramafgp.f.setText("");
      paramafgp.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
      if (this.jdField_d_of_type_Int != 9) {
        break label1015;
      }
      paramafgp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null) {
        paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
      }
      label393:
      paramafgp.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramafgp.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label1030;
      }
      paramafgp.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramafgp.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_d_of_type_Boolean) {
        paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
      i5 = 0;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13)) {
        break label1160;
      }
      paramafgp.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691752) + paramafgp.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramafgp.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130849683);
      if (this.jdField_d_of_type_Int != 13) {
        break label1077;
      }
      paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label563:
      if (!str.equals(paramafgi.jdField_a_of_type_JavaLangString)) {
        break label1149;
      }
      paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    int i1;
    int i2;
    for (;;)
    {
      paramafgp.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131691737), new Object[] { paramafgp.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramafgp.g.setContentDescription(getString(2131691736));
      i1 = i5;
      if (paramafgp.jdField_d_of_type_AndroidViewView != null)
      {
        paramBitmap = (bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        if ((paramBitmap == null) || (!paramBitmap.b(paramafgi.jdField_a_of_type_JavaLangString))) {
          break label3012;
        }
        i2 = 1;
        label676:
        if (i2 == 0) {
          break label3018;
        }
        paramafgp.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      label689:
      if (this.jdField_e_of_type_Boolean) {
        paramafgp.j.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramafgp.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      if ((paramBoolean2) && (paramafgp.k != null)) {
        paramBitmap.append(paramafgp.k.getText());
      }
      if (paramafgp.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        paramBitmap.append(paramafgp.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      }
      if (paramafgp.j.getVisibility() == 0) {
        paramBitmap.append(paramafgp.j.getText().toString());
      }
      if (paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.getVisibility() == 0) {
        paramBitmap.append(paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.a());
      }
      if ((paramafgp.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_Boolean))
      {
        if (i1 == 0) {
          break label3030;
        }
        paramafgi = "已选中";
        label856:
        paramBitmap.append(paramafgi);
      }
      paramafgp.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
      return;
      str = this.t;
      break;
      label883:
      paramafgp.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      break label84;
      label896:
      paramafgp.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramafgp.j.setVisibility(8);
      break label84;
      label918:
      paramafgp.j.setVisibility(8);
      break label153;
      label930:
      if (paramBoolean2)
      {
        paramBitmap = new begq(paramafgi.jdField_g_of_type_JavaLangString, 16).a();
        paramafgp.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
        bhmb.a(this.app, paramafgp.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
        break label265;
      }
      paramBitmap = new begq(paramafgi.jdField_b_of_type_JavaLangString, 16).a();
      paramafgp.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      bhmb.a(this.app, paramafgp.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
      break label265;
      label1015:
      paramafgp.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
      break label393;
      label1030:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramafgp.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramafgp.jdField_a_of_type_AndroidViewView.setClickable(false);
        break label474;
      }
      paramafgp.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramafgp.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label474;
      label1077:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label563;
      }
      if ((this.jdField_e_of_type_JavaLangString != null) && (!paramafgi.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString)))
      {
        paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label563;
      }
      paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label563;
      label1149:
      paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label1160:
    paramafgp.jdField_c_of_type_AndroidWidgetTextView.setText("");
    label1182:
    boolean bool1;
    label1206:
    boolean bool2;
    label1237:
    boolean bool4;
    boolean bool5;
    if (!TextUtils.isEmpty(paramafgi.u))
    {
      paramBoolean1 = true;
      if ((paramafgi.jdField_a_of_type_JavaLangString == null) || (!paramafgi.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString))) {
        break label1513;
      }
      bool1 = true;
      if ((this.jdField_f_of_type_JavaLangString == null) || (paramafgi.jdField_a_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.contains(paramafgi.jdField_a_of_type_JavaLangString))) {
        break label1519;
      }
      bool2 = true;
      bool4 = this.app.getCurrentAccountUin().equals(this.jdField_e_of_type_JavaLangString);
      bool5 = this.app.getCurrentAccountUin().equals(paramafgi.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int != 5) {
        break label1682;
      }
      paramafgp.h.setVisibility(0);
      paramafgp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null) {
        paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
      }
      paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
      paramafgp.i.setVisibility(0);
      if (bgek.a(this.jdField_b_of_type_JavaLangString)) {
        break label1644;
      }
      localObject = "";
      i2 = 0;
      if ((!paramBoolean1) || (bdfk.b())) {
        break label1525;
      }
      paramBitmap = bfkd.a().a(302, paramBoolean1, bool1, bool2);
      if (paramBitmap == null) {
        break label3052;
      }
      i1 = paramBitmap.jdField_b_of_type_Int;
      paramBitmap = paramafgi.u;
    }
    for (;;)
    {
      label1386:
      if (!TextUtils.isEmpty(paramBitmap))
      {
        paramafgp.h.setText(paramBitmap);
        bfkd.a(paramafgp.h, i1);
      }
      label1410:
      label1442:
      label1513:
      label1519:
      label1525:
      bfke localbfke;
      for (;;)
      {
        paramBitmap = (bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        if ((paramBitmap == null) || (!paramBitmap.b(paramafgi.jdField_a_of_type_JavaLangString))) {
          break label2727;
        }
        i1 = 1;
        if (!this.jdField_c_of_type_Boolean) {
          break label2793;
        }
        if ((this.jdField_d_of_type_Int == 21) || ((!bool1) && ((bool4) || (!bool2)) && ((bool4) || (i1 == 0)))) {
          break label2733;
        }
        paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i5;
        break;
        paramBoolean1 = false;
        break label1182;
        bool1 = false;
        break label1206;
        bool2 = false;
        break label1237;
        if (bool1)
        {
          localbfke = bfkd.a().a(300, paramBoolean1, bool1, bool2);
          i1 = i2;
          paramBitmap = (Bitmap)localObject;
          if (localbfke == null) {
            break label1386;
          }
          i1 = localbfke.jdField_b_of_type_Int;
          paramBitmap = localbfke.jdField_a_of_type_JavaLangString;
          break label1386;
        }
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (!bool2) {
          break label1386;
        }
        localbfke = bfkd.a().a(301, paramBoolean1, bool1, bool2);
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (localbfke == null) {
          break label1386;
        }
        i1 = localbfke.jdField_b_of_type_Int;
        paramBitmap = localbfke.jdField_a_of_type_JavaLangString;
        break label1386;
        paramafgp.h.setVisibility(8);
        continue;
        label1644:
        paramBitmap = bgek.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramafgi.jdField_a_of_type_JavaLangString, paramafgi.u);
        if ((paramBitmap != null) && (paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null)) {
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
        }
      }
      label1682:
      i1 = 0;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop();
      }
      if ((bool3) || (this.jdField_b_of_type_Boolean))
      {
        localObject = bfkd.a().a(bool1, bool2);
        if (localObject == null) {
          break label3043;
        }
        paramBitmap = ((bfke)localObject).jdField_a_of_type_JavaLangString;
        i1 = ((bfke)localObject).jdField_b_of_type_Int;
      }
      for (;;)
      {
        label1746:
        if (this.jdField_d_of_type_Int == 11) {
          paramBitmap = "";
        }
        int i3 = 1;
        label1782:
        int i4;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          if (1 == this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupRankUserFlag) {
            i3 = 1;
          }
        }
        else
        {
          i2 = 0;
          localObject = bfkd.a().a(bool1, bool2);
          if (localObject != null) {
            i2 = ((bfke)localObject).jdField_b_of_type_Int;
          }
          if (((!bdfk.b()) && (i3 != 0)) || (!bool1)) {
            break label2345;
          }
          localObject = String.format(getString(2131689491), new Object[0]);
          i4 = i2;
          label1845:
          if (bgek.a(this.jdField_b_of_type_JavaLangString)) {
            break label2416;
          }
          if (paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null) {
            paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
          }
          if (((!bdfk.b()) && (i3 != 0)) || (bool2) || (bool1)) {
            break label2398;
          }
          i1 = 1;
          label1895:
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (a()) || (i1 != 0) || (i4 == 0)) {
            break label2404;
          }
          paramafgp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramafgp.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          bfkd.a(paramafgp.jdField_c_of_type_AndroidWidgetTextView, i4);
          label1946:
          paramBitmap = (bfwu)this.app.getManager(QQManagerFactory.TROOP_HONOR_MANAGER);
          if (!paramBitmap.b(this.jdField_b_of_type_JavaLangString)) {
            break label2522;
          }
          paramBitmap = paramBitmap.a(paramafgi.v);
          if ((paramBitmap == null) || (paramBitmap.size() <= 0)) {
            break label2502;
          }
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(paramBitmap, 2);
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(0);
          label2010:
          if (this.jdField_b_of_type_Boolean)
          {
            if (bgek.a(this.jdField_b_of_type_JavaLangString)) {
              break label2566;
            }
            if (paramafgp.jdField_b_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null) {
              paramafgp.jdField_b_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
            }
            paramBitmap = bfkd.a().a(paramafgi.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap == null) || (!bghd.a(paramafgi.jdField_a_of_type_Int))) {
              break label2554;
            }
            if ((TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) || (bdfk.b())) {
              break label2542;
            }
            paramafgp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramafgp.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
            bfkd.a(paramafgp.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
          }
        }
        for (;;)
        {
          if ((this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 12)) {
            break label2713;
          }
          if ((paramafgi.jdField_a_of_type_JavaLangString == null) || (!paramafgi.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
            break label2715;
          }
          paramafgp.f.setText(getString(2131694215));
          break label1410;
          localbfke = bfkd.a().a(paramafgi.jdField_a_of_type_Int, paramBoolean1, bool1, bool2);
          if (localbfke != null)
          {
            localObject = localbfke.jdField_a_of_type_JavaLangString;
            i2 = localbfke.jdField_b_of_type_Int;
            if (localbfke.jdField_a_of_type_Int == 302) {
              localObject = paramafgi.u;
            }
            paramBitmap = (Bitmap)localObject;
            i1 = i2;
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
              break label1746;
            }
            paramBitmap = (Bitmap)localObject;
            i1 = i2;
            if (localbfke.jdField_a_of_type_Int != 315) {
              break label1746;
            }
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramafgi.jdField_c_of_type_Int));
            i1 = i2;
            break label1746;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (paramafgi.jdField_a_of_type_Int != 315)) {
            break label3037;
          }
          paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramafgi.jdField_c_of_type_Int));
          i1 = Color.parseColor("#8EBDF9");
          break label1746;
          i3 = 0;
          break label1782;
          label2345:
          if (!bdfk.b())
          {
            localObject = paramBitmap;
            i4 = i1;
            if (i3 != 0) {
              break label1845;
            }
          }
          localObject = paramBitmap;
          i4 = i1;
          if (!bool2) {
            break label1845;
          }
          localObject = String.format(getString(2131689490), new Object[0]);
          i4 = i2;
          break label1845;
          label2398:
          i1 = 0;
          break label1895;
          label2404:
          paramafgp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1946;
          label2416:
          paramafgp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView == null) {
            break label1946;
          }
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
          i2 = paramafgi.jdField_d_of_type_Int;
          i1 = i2;
          if (i2 == 0) {
            i1 = bgek.b(paramafgi.jdField_c_of_type_Int);
          }
          paramBitmap = bgek.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramafgi.jdField_a_of_type_JavaLangString, i1, paramafgi.jdField_a_of_type_Int, paramafgi.u);
          if (paramBitmap == null) {
            break;
          }
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
          break label1946;
          label2502:
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label2010;
          label2522:
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramafgp.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label2010;
          label2542:
          paramafgp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label2554:
          paramafgp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label2566:
          paramafgp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          if (paramafgp.jdField_b_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null)
          {
            paramafgp.jdField_b_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
            if (bool1)
            {
              paramBitmap = new bgel();
              paramBitmap.jdField_b_of_type_Boolean = true;
              paramBitmap.jdField_a_of_type_Boolean = false;
              paramBitmap.jdField_a_of_type_Int = 300;
              paramBitmap.jdField_a_of_type_ArrayOfInt = bgek.a(paramBitmap.jdField_a_of_type_Int);
              paramBitmap.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
              paramafgp.jdField_b_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
            }
            else if (bool2)
            {
              paramBitmap = new bgel();
              paramBitmap.jdField_b_of_type_Boolean = true;
              paramBitmap.jdField_a_of_type_Boolean = false;
              paramBitmap.jdField_a_of_type_Int = 301;
              paramBitmap.jdField_a_of_type_ArrayOfInt = bgek.a(paramBitmap.jdField_a_of_type_Int);
              paramBitmap.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
              paramafgp.jdField_b_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramBitmap);
            }
          }
        }
        label2713:
        break label1410;
        label2715:
        paramafgp.f.setText("");
        break label1410;
        label2727:
        i1 = 0;
        break label1442;
        label2733:
        paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramafgp.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130849683);
        if (str.equals(paramafgi.jdField_a_of_type_JavaLangString))
        {
          paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
          i1 = i5;
          break;
        }
        paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i5;
        break;
        label2793:
        if (this.jdField_d_of_type_Boolean)
        {
          if ((bool1) || ((!bool4) && (bool2)) || (bool5))
          {
            i1 = 1;
            if (i1 == 0) {
              break label2849;
            }
            paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(8);
            i1 = 0;
          }
          for (;;)
          {
            break;
            i1 = 0;
            break label2823;
            paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramafgi.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Afgk.jdField_b_of_type_JavaUtilList.contains(paramafgi.jdField_a_of_type_JavaLangString)))
            {
              paramafgp.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840569);
              i1 = 1;
            }
            else
            {
              paramafgp.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840565);
              i1 = 0;
            }
          }
        }
        label2823:
        label2849:
        if (this.jdField_d_of_type_Int == 20)
        {
          paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramafgi.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.contains(paramafgi)))
          {
            paramafgp.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840569);
            i1 = 1;
            break;
          }
          paramafgp.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840565);
          i1 = i5;
          break;
        }
        paramafgp.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramafgp.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i5;
        break;
        label3012:
        i2 = 0;
        break label676;
        label3018:
        paramafgp.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label689;
        label3030:
        paramafgi = "未选中";
        break label856;
        label3037:
        paramBitmap = "";
        continue;
        label3043:
        i1 = 0;
        paramBitmap = "";
      }
      label3052:
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
      i1 = this.jdField_a_of_type_Afgk.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i1 + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        bdla.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_d_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    bdla.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramString2 != null)
    {
      if (paramString2.b(paramString1))
      {
        paramString1 = new ProfileActivity.AllInOne(paramString1, 20);
        paramString1.jdField_a_of_type_Int = 20;
        paramString1.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        paramString1.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        paramString1.jdField_h_of_type_Int = 4;
        ProfileActivity.b(this, paramString1);
      }
    }
    else {
      return;
    }
    paramString1 = new ProfileActivity.AllInOne(paramString1, 21);
    paramString1.jdField_a_of_type_Int = 21;
    paramString1.jdField_l_of_type_Int = 11;
    paramString1.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramString1.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramString1.jdField_h_of_type_Int = 4;
    ProfileActivity.b(this, paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMemberListActivityget_troop_member", 2, "doReport, actionName=" + paramString1 + " ext2=" + paramString2 + " ext3=" + paramString3 + " from=" + this.jdField_d_of_type_Int);
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
        QLog.i("TroopMemberListActivityget_troop_member", 2, "doReport:" + paramString1.toString());
        return;
        label172:
        paramString2 = "un_pay_list";
      }
      label179:
      bdla.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString2, paramString3, "");
    }
    bdla.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString3, "", "");
    return;
  }
  
  /* Error */
  public void a(String paramString, List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 439 1 0
    //   11: aload_0
    //   12: dconst_0
    //   13: putfield 231	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_a_of_type_Double	D
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 233	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_n_of_type_Int	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 258	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_o_of_type_Int	I
    //   26: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc_w 580
    //   35: iconst_2
    //   36: new 582	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1986
    //   46: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 596	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 979	java/lang/System:currentTimeMillis	()J
    //   63: putfield 261	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   66: aload_2
    //   67: ifnull +15 -> 82
    //   70: aload_2
    //   71: astore 8
    //   73: aload_2
    //   74: invokeinterface 1988 1 0
    //   79: ifeq +548 -> 627
    //   82: new 114	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 115	java/util/ArrayList:<init>	()V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 603	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 1992	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   97: invokevirtual 1998	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_1
    //   105: ldc_w 627
    //   108: invokevirtual 2003	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: bipush 20
    //   113: anewarray 349	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 2004
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 2005
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 2006
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 2007
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 2008
    //   145: aastore
    //   146: dup
    //   147: iconst_5
    //   148: ldc_w 2009
    //   151: aastore
    //   152: dup
    //   153: bipush 6
    //   155: ldc_w 2010
    //   158: aastore
    //   159: dup
    //   160: bipush 7
    //   162: ldc_w 2011
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: ldc_w 2013
    //   172: aastore
    //   173: dup
    //   174: bipush 9
    //   176: ldc_w 2015
    //   179: aastore
    //   180: dup
    //   181: bipush 10
    //   183: ldc_w 2017
    //   186: aastore
    //   187: dup
    //   188: bipush 11
    //   190: ldc_w 2018
    //   193: aastore
    //   194: dup
    //   195: bipush 12
    //   197: ldc_w 2019
    //   200: aastore
    //   201: dup
    //   202: bipush 13
    //   204: ldc_w 2020
    //   207: aastore
    //   208: dup
    //   209: bipush 14
    //   211: ldc_w 2021
    //   214: aastore
    //   215: dup
    //   216: bipush 15
    //   218: ldc_w 2022
    //   221: aastore
    //   222: dup
    //   223: bipush 16
    //   225: ldc_w 2023
    //   228: aastore
    //   229: dup
    //   230: bipush 17
    //   232: ldc_w 2024
    //   235: aastore
    //   236: dup
    //   237: bipush 18
    //   239: ldc_w 2025
    //   242: aastore
    //   243: dup
    //   244: bipush 19
    //   246: ldc_w 2026
    //   249: aastore
    //   250: ldc_w 2028
    //   253: iconst_1
    //   254: anewarray 349	java/lang/String
    //   257: dup
    //   258: iconst_0
    //   259: aload_1
    //   260: aastore
    //   261: aconst_null
    //   262: aconst_null
    //   263: aconst_null
    //   264: aconst_null
    //   265: invokevirtual 2034	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   268: astore_1
    //   269: aload_1
    //   270: ifnull +302 -> 572
    //   273: aload_1
    //   274: invokeinterface 2039 1 0
    //   279: ifeq +287 -> 566
    //   282: new 627	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   285: dup
    //   286: invokespecial 2040	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   289: astore 9
    //   291: aload 9
    //   293: aload_1
    //   294: iconst_0
    //   295: invokeinterface 2041 2 0
    //   300: putfield 630	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   303: aload 9
    //   305: aload_1
    //   306: iconst_1
    //   307: invokeinterface 2041 2 0
    //   312: invokestatic 2044	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   315: putfield 1395	com/tencent/mobileqq/data/troop/TroopMemberInfo:mIsShielded	Z
    //   318: aload 9
    //   320: aload_1
    //   321: iconst_2
    //   322: invokeinterface 2041 2 0
    //   327: putfield 1425	com/tencent/mobileqq/data/troop/TroopMemberInfo:mUniqueTitle	Ljava/lang/String;
    //   330: aload 9
    //   332: aload_1
    //   333: iconst_3
    //   334: invokeinterface 2047 2 0
    //   339: putfield 1370	com/tencent/mobileqq/data/troop/TroopMemberInfo:level	I
    //   342: aload 9
    //   344: aload_1
    //   345: iconst_4
    //   346: invokeinterface 2051 2 0
    //   351: putfield 1391	com/tencent/mobileqq/data/troop/TroopMemberInfo:active_point	J
    //   354: aload 9
    //   356: aload_1
    //   357: iconst_5
    //   358: invokeinterface 2051 2 0
    //   363: putfield 1383	com/tencent/mobileqq/data/troop/TroopMemberInfo:credit_level	J
    //   366: aload 9
    //   368: aload_1
    //   369: bipush 6
    //   371: invokeinterface 2051 2 0
    //   376: putfield 1364	com/tencent/mobileqq/data/troop/TroopMemberInfo:last_active_time	J
    //   379: aload 9
    //   381: aload_1
    //   382: bipush 7
    //   384: invokeinterface 2051 2 0
    //   389: putfield 1367	com/tencent/mobileqq/data/troop/TroopMemberInfo:join_time	J
    //   392: aload 9
    //   394: aload_1
    //   395: bipush 8
    //   397: invokeinterface 2041 2 0
    //   402: putfield 2053	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   405: aload 9
    //   407: aload_1
    //   408: bipush 9
    //   410: invokeinterface 2041 2 0
    //   415: putfield 1354	com/tencent/mobileqq/data/troop/TroopMemberInfo:pyAll_troopnick	Ljava/lang/String;
    //   418: aload 9
    //   420: aload_1
    //   421: bipush 10
    //   423: invokeinterface 2041 2 0
    //   428: putfield 1357	com/tencent/mobileqq/data/troop/TroopMemberInfo:pyFirst_troopnick	Ljava/lang/String;
    //   431: aload 9
    //   433: aload_1
    //   434: bipush 11
    //   436: invokeinterface 2041 2 0
    //   441: putfield 1334	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   444: aload 9
    //   446: aload_1
    //   447: bipush 12
    //   449: invokeinterface 2041 2 0
    //   454: putfield 1339	com/tencent/mobileqq/data/troop/TroopMemberInfo:pyAll_friendnick	Ljava/lang/String;
    //   457: aload 9
    //   459: aload_1
    //   460: bipush 13
    //   462: invokeinterface 2041 2 0
    //   467: putfield 1344	com/tencent/mobileqq/data/troop/TroopMemberInfo:pyFirst_friendnick	Ljava/lang/String;
    //   470: aload 9
    //   472: aload_1
    //   473: bipush 14
    //   475: invokeinterface 2041 2 0
    //   480: putfield 1461	com/tencent/mobileqq/data/troop/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   483: aload 9
    //   485: aload_1
    //   486: bipush 15
    //   488: invokeinterface 2041 2 0
    //   493: putfield 1467	com/tencent/mobileqq/data/troop/TroopMemberInfo:pyAll_autoremark	Ljava/lang/String;
    //   496: aload 9
    //   498: aload_1
    //   499: bipush 16
    //   501: invokeinterface 2041 2 0
    //   506: putfield 1470	com/tencent/mobileqq/data/troop/TroopMemberInfo:pyFirst_autoremark	Ljava/lang/String;
    //   509: aload 9
    //   511: aload_1
    //   512: bipush 17
    //   514: invokeinterface 2047 2 0
    //   519: putfield 1374	com/tencent/mobileqq/data/troop/TroopMemberInfo:realLevel	I
    //   522: aload 9
    //   524: aload_1
    //   525: bipush 18
    //   527: invokeinterface 2041 2 0
    //   532: putfield 1351	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   535: aload 9
    //   537: aload_1
    //   538: bipush 19
    //   540: invokeinterface 2047 2 0
    //   545: putfield 1379	com/tencent/mobileqq/data/troop/TroopMemberInfo:newRealLevel	I
    //   548: aload_2
    //   549: aload 9
    //   551: invokeinterface 655 2 0
    //   556: pop
    //   557: aload_1
    //   558: invokeinterface 2056 1 0
    //   563: ifne -281 -> 282
    //   566: aload_1
    //   567: invokeinterface 2059 1 0
    //   572: aload 8
    //   574: invokevirtual 2060	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   577: invokestatic 979	java/lang/System:currentTimeMillis	()J
    //   580: lstore 6
    //   582: aload_2
    //   583: astore 8
    //   585: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq +39 -> 627
    //   591: ldc_w 580
    //   594: iconst_2
    //   595: new 582	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 2062
    //   605: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: lload 6
    //   610: aload_0
    //   611: getfield 261	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   614: lsub
    //   615: invokevirtual 2065	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   618: invokevirtual 596	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload_2
    //   625: astore 8
    //   627: aload 8
    //   629: ifnull +13 -> 642
    //   632: aload 8
    //   634: invokeinterface 1988 1 0
    //   639: ifeq +26 -> 665
    //   642: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +13 -> 658
    //   648: ldc_w 580
    //   651: iconst_2
    //   652: ldc_w 2067
    //   655: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload_0
    //   659: invokevirtual 434	com/tencent/mobileqq/activity/TroopMemberListActivity:k	()V
    //   662: aload_0
    //   663: monitorexit
    //   664: return
    //   665: aload 8
    //   667: invokeinterface 411 1 0
    //   672: istore 4
    //   674: aload_0
    //   675: iload 4
    //   677: putfield 258	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_o_of_type_Int	I
    //   680: iload 4
    //   682: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   685: idiv
    //   686: istore 5
    //   688: iload 4
    //   690: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   693: irem
    //   694: ifne +195 -> 889
    //   697: iconst_0
    //   698: istore_3
    //   699: aload_0
    //   700: iload_3
    //   701: iload 5
    //   703: iadd
    //   704: putfield 233	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_n_of_type_Int	I
    //   707: iconst_0
    //   708: istore_3
    //   709: iload_3
    //   710: iload 4
    //   712: if_icmpge +42 -> 754
    //   715: new 2069	com/tencent/mobileqq/activity/TroopMemberListActivity$35
    //   718: dup
    //   719: aload_0
    //   720: aload 8
    //   722: iload_3
    //   723: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   726: iload_3
    //   727: iadd
    //   728: iconst_1
    //   729: isub
    //   730: iload 4
    //   732: invokestatic 2075	java/lang/Math:min	(II)I
    //   735: invokespecial 2078	com/tencent/mobileqq/activity/TroopMemberListActivity$35:<init>	(Lcom/tencent/mobileqq/activity/TroopMemberListActivity;Ljava/util/List;II)V
    //   738: bipush 8
    //   740: aconst_null
    //   741: iconst_1
    //   742: invokestatic 988	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   745: iload_3
    //   746: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   749: iadd
    //   750: istore_3
    //   751: goto -42 -> 709
    //   754: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq -95 -> 662
    //   760: ldc_w 580
    //   763: iconst_2
    //   764: new 582	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   771: ldc_w 2080
    //   774: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: iload 4
    //   779: invokevirtual 592	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   782: ldc_w 2082
    //   785: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_0
    //   789: getfield 233	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_n_of_type_Int	I
    //   792: invokevirtual 592	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 596	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: goto -139 -> 662
    //   804: astore_1
    //   805: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   808: ifeq -146 -> 662
    //   811: ldc_w 580
    //   814: iconst_2
    //   815: new 582	java/lang/StringBuilder
    //   818: dup
    //   819: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   822: ldc_w 2084
    //   825: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_1
    //   829: invokevirtual 1979	java/lang/Exception:toString	()Ljava/lang/String;
    //   832: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 596	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   841: goto -179 -> 662
    //   844: astore_1
    //   845: aload_0
    //   846: monitorexit
    //   847: aload_1
    //   848: athrow
    //   849: astore_1
    //   850: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq -191 -> 662
    //   856: ldc_w 580
    //   859: iconst_2
    //   860: new 582	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 2084
    //   870: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_1
    //   874: invokevirtual 2085	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   877: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 596	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: goto -224 -> 662
    //   889: iconst_1
    //   890: istore_3
    //   891: goto -192 -> 699
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	894	0	this	TroopMemberListActivity
    //   0	894	1	paramString	String
    //   0	894	2	paramList	List<TroopMemberInfo>
    //   698	193	3	i1	int
    //   672	106	4	i2	int
    //   686	18	5	i3	int
    //   580	29	6	l1	long
    //   71	650	8	localObject	Object
    //   289	261	9	localTroopMemberInfo	TroopMemberInfo
    // Exception table:
    //   from	to	target	type
    //   26	59	804	java/lang/Exception
    //   59	66	804	java/lang/Exception
    //   73	82	804	java/lang/Exception
    //   82	269	804	java/lang/Exception
    //   273	282	804	java/lang/Exception
    //   282	566	804	java/lang/Exception
    //   566	572	804	java/lang/Exception
    //   572	582	804	java/lang/Exception
    //   585	624	804	java/lang/Exception
    //   632	642	804	java/lang/Exception
    //   642	658	804	java/lang/Exception
    //   658	662	804	java/lang/Exception
    //   665	697	804	java/lang/Exception
    //   699	707	804	java/lang/Exception
    //   715	751	804	java/lang/Exception
    //   754	801	804	java/lang/Exception
    //   2	26	844	finally
    //   26	59	844	finally
    //   59	66	844	finally
    //   73	82	844	finally
    //   82	269	844	finally
    //   273	282	844	finally
    //   282	566	844	finally
    //   566	572	844	finally
    //   572	582	844	finally
    //   585	624	844	finally
    //   632	642	844	finally
    //   642	658	844	finally
    //   658	662	844	finally
    //   665	697	844	finally
    //   699	707	844	finally
    //   715	751	844	finally
    //   754	801	844	finally
    //   805	841	844	finally
    //   850	886	844	finally
    //   26	59	849	java/lang/OutOfMemoryError
    //   59	66	849	java/lang/OutOfMemoryError
    //   73	82	849	java/lang/OutOfMemoryError
    //   82	269	849	java/lang/OutOfMemoryError
    //   273	282	849	java/lang/OutOfMemoryError
    //   282	566	849	java/lang/OutOfMemoryError
    //   566	572	849	java/lang/OutOfMemoryError
    //   572	582	849	java/lang/OutOfMemoryError
    //   585	624	849	java/lang/OutOfMemoryError
    //   632	642	849	java/lang/OutOfMemoryError
    //   642	658	849	java/lang/OutOfMemoryError
    //   658	662	849	java/lang/OutOfMemoryError
    //   665	697	849	java/lang/OutOfMemoryError
    //   699	707	849	java/lang/OutOfMemoryError
    //   715	751	849	java/lang/OutOfMemoryError
    //   754	801	849	java/lang/OutOfMemoryError
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0) || (this.jdField_a_of_type_Afgk == null)) {
      break label16;
    }
    label16:
    while (this.jdField_a_of_type_Afgk.jdField_b_of_type_Int + this.jdField_a_of_type_Afgk.jdField_c_of_type_Int > 16) {
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
        QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("updateMaxItemCount, max: %s", new Object[] { Integer.valueOf(this.jdField_l_of_type_Int) }));
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
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, uin:" + paramString);
        }
        l1 = System.currentTimeMillis();
        localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.jdField_c_of_type_JavaUtilList = ((antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, queryTime:" + (l2 - l1));
        }
        if (this.jdField_c_of_type_JavaUtilList == null) {
          break label559;
        }
        i2 = this.jdField_c_of_type_JavaUtilList.size();
        if (i1 < i2)
        {
          paramString = (DiscussionMemberInfo)this.jdField_c_of_type_JavaUtilList.get(i1);
          if (paramString == null) {
            break label564;
          }
          if ((paramString.memberUin != null) && (paramString.memberUin.trim().length() > 0) && (!paramString.memberUin.trim().equalsIgnoreCase("0")))
          {
            if (((this.jdField_d_of_type_Int == 2) && (paramString.memberUin.equals(this.jdField_e_of_type_JavaLangString))) || ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))) {
              break label564;
            }
            paramString = a(paramString, (anvk)localObject);
            this.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
        }
        paramString = null;
        return paramString;
        if (!QLog.isColorLevel()) {
          break label564;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, continued:" + paramString.memberUin);
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label323:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.app.getProxyManager() == null) {
        break label571;
      }
    }
    finally {}
    this.app.getProxyManager().notifyRefreshTroopMember();
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, TotalTime:" + (l2 - l1) + ", listSize:" + this.jdField_a_of_type_JavaUtilList.size() + ", dbSize:" + i1);
      }
      localObject = this.jdField_a_of_type_Afgk.a();
      if ((localObject != null) && (localObject.length == 3))
      {
        paramString = new Object[3];
        paramString[0] = localObject[0];
        paramString[1] = localObject[1];
        paramString[2] = localObject[2];
        break label323;
      }
      paramString = null;
      break label323;
      label559:
      i1 = 0;
      continue;
      label564:
      i1 += 1;
      break;
      label571:
      i1 = i2;
    }
  }
  
  /* Error */
  public Object[] a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 979	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 114	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 115	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 603	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: getstatic 608	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   22: invokevirtual 614	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   25: checkcast 616	anvk
    //   28: astore 6
    //   30: aload_0
    //   31: getfield 603	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: invokevirtual 1992	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   37: invokevirtual 1998	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: astore 7
    //   42: aload_2
    //   43: invokeinterface 1022 1 0
    //   48: astore_2
    //   49: aload_2
    //   50: invokeinterface 1027 1 0
    //   55: ifeq +85 -> 140
    //   58: aload 7
    //   60: ldc_w 627
    //   63: iconst_0
    //   64: ldc_w 2146
    //   67: iconst_2
    //   68: anewarray 349	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: invokeinterface 1030 1 0
    //   83: checkcast 349	java/lang/String
    //   86: aastore
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: aconst_null
    //   91: invokevirtual 2149	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   94: astore 8
    //   96: aload 8
    //   98: ifnull -49 -> 49
    //   101: aload 8
    //   103: invokeinterface 411 1 0
    //   108: ifle -59 -> 49
    //   111: aload 5
    //   113: aload_0
    //   114: aload 8
    //   116: iconst_0
    //   117: invokeinterface 625 2 0
    //   122: checkcast 627	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   125: aload 6
    //   127: invokevirtual 652	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;Lanvk;)Lafgi;
    //   130: invokeinterface 655 2 0
    //   135: pop
    //   136: goto -87 -> 49
    //   139: astore_1
    //   140: invokestatic 578	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +34 -> 177
    //   146: ldc_w 580
    //   149: iconst_2
    //   150: new 582	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 2151
    //   160: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokestatic 979	java/lang/System:currentTimeMillis	()J
    //   166: lload_3
    //   167: lsub
    //   168: invokevirtual 2065	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: invokevirtual 596	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 599	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_0
    //   178: monitorexit
    //   179: iconst_1
    //   180: anewarray 341	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 5
    //   187: aastore
    //   188: areturn
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	TroopMemberListActivity
    //   0	194	1	paramString	String
    //   0	194	2	paramList	List<String>
    //   5	162	3	l1	long
    //   13	173	5	localArrayList	ArrayList
    //   28	98	6	localanvk	anvk
    //   40	19	7	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   94	21	8	localList	List
    // Exception table:
    //   from	to	target	type
    //   30	49	139	java/lang/Exception
    //   49	96	139	java/lang/Exception
    //   101	136	139	java/lang/Exception
    //   2	30	189	finally
    //   30	49	189	finally
    //   49	96	189	finally
    //   101	136	189	finally
    //   140	177	189	finally
  }
  
  protected void b()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379551));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379020);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369278));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369224));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364417));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369233));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369262));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369245));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131379545));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368807));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131376461);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370224));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370454));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368295));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131370477));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697263));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369246));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843928);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131719503));
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "removeSearchItem:" + paramString);
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_b_of_type_JavaUtilList.size())
        {
          afgi localafgi = (afgi)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localafgi != null) && (localafgi.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
  
  protected void c()
  {
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691749));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692403));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691751));
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131714929));
      }
      if (this.jdField_d_of_type_Int == 14) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689617));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new afgc(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696219));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690697);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new afgd(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696221));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690697);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new afge(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696045));
        if (this.jdField_h_of_type_JavaLangString == null) {
          this.jdField_h_of_type_JavaLangString = getString(2131690676);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
        break;
      }
      if ((this.jdField_d_of_type_Int == 14) || (this.jdField_d_of_type_Int == 16))
      {
        if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697011);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        break;
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719653);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691815);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      if ((this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21))
      {
        if (this.jdField_k_of_type_JavaLangString != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692403));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691751));
        break;
      }
      if (this.jdField_d_of_type_Int == 18)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719504);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131714920));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new afgf(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 23)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719504);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131714987));
      if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_h_of_type_JavaLangString == null) {
        this.jdField_h_of_type_JavaLangString = getString(2131690676);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692403);
      if (this.jdField_d_of_type_Int != 4)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697263));
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
  
  public void c(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.u = "";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Afgm.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    bgls localbgls = (bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    int i1 = 0;
    for (;;)
    {
      afgi localafgi;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label964;
        }
        localafgi = (afgi)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((this.jdField_r_of_type_Boolean) && (localbgls.b(localafgi.jdField_a_of_type_JavaLangString))) {
          break label1142;
        }
        localafgi.jdField_e_of_type_JavaLangString = "";
        localafgi.jdField_f_of_type_JavaLangString = "";
        if ((paramString.equals(localafgi.m)) || (paramString.equals(localafgi.jdField_o_of_type_JavaLangString)) || (paramString.equals(localafgi.jdField_n_of_type_JavaLangString)))
        {
          localafgi.jdField_e_of_type_JavaLangString = localafgi.m;
          localArrayList1.add(localafgi);
          if (!QLog.isColorLevel()) {
            break label1142;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + localafgi.jdField_a_of_type_JavaLangString + "," + localafgi.jdField_e_of_type_JavaLangString);
        }
      }
      finally {}
      if ((paramString.equals(localafgi.jdField_j_of_type_JavaLangString)) || (paramString.equals(localafgi.l)) || (paramString.equals(localafgi.jdField_k_of_type_JavaLangString)))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_j_of_type_JavaLangString;
        localArrayList1.add(localafgi);
      }
      else if ((paramString.equals(localafgi.jdField_g_of_type_JavaLangString)) || (paramString.equals(localafgi.jdField_i_of_type_JavaLangString)) || (paramString.equals(localafgi.jdField_h_of_type_JavaLangString)))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_g_of_type_JavaLangString;
        localArrayList1.add(localafgi);
      }
      else if (paramString.equals(localafgi.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localafgi);
        }
      }
      else if ((localafgi.m.indexOf(paramString) == 0) || (localafgi.jdField_o_of_type_JavaLangString.indexOf(paramString) == 0) || (localafgi.jdField_n_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.m;
        localafgi.jdField_f_of_type_JavaLangString = localafgi.jdField_n_of_type_JavaLangString;
        localArrayList2.add(localafgi);
      }
      else if ((localafgi.jdField_j_of_type_JavaLangString.indexOf(paramString) == 0) || (localafgi.l.indexOf(paramString) == 0) || (localafgi.jdField_k_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_j_of_type_JavaLangString;
        localafgi.jdField_f_of_type_JavaLangString = localafgi.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localafgi);
      }
      else if ((localafgi.jdField_g_of_type_JavaLangString.indexOf(paramString) == 0) || (localafgi.jdField_i_of_type_JavaLangString.indexOf(paramString) == 0) || (localafgi.jdField_h_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_g_of_type_JavaLangString;
        localafgi.jdField_f_of_type_JavaLangString = localafgi.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localafgi);
      }
      else if (localafgi.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_a_of_type_JavaLangString;
          localafgi.jdField_f_of_type_JavaLangString = localafgi.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localafgi);
        }
      }
      else if ((localafgi.m.indexOf(paramString) > 0) || (localafgi.jdField_o_of_type_JavaLangString.indexOf(paramString) > 0) || (localafgi.jdField_n_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.m;
        localArrayList3.add(localafgi);
      }
      else if ((localafgi.jdField_j_of_type_JavaLangString.indexOf(paramString) > 0) || (localafgi.l.indexOf(paramString) > 0) || (localafgi.jdField_k_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_j_of_type_JavaLangString;
        localArrayList3.add(localafgi);
      }
      else if ((localafgi.jdField_g_of_type_JavaLangString.indexOf(paramString) > 0) || (localafgi.jdField_i_of_type_JavaLangString.indexOf(paramString) > 0) || (localafgi.jdField_h_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_g_of_type_JavaLangString;
        localArrayList3.add(localafgi);
      }
      else if ((localafgi.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_e_of_type_Boolean))
      {
        localafgi.jdField_e_of_type_JavaLangString = localafgi.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localafgi);
        continue;
        label964:
        Collections.sort(localArrayList2, new afgn(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Afgm.notifyDataSetChanged();
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.jdField_b_of_type_JavaUtilList.size() + "," + this.jdField_a_of_type_JavaUtilList.size());
          return;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        label1142:
        i1 += 1;
      }
    }
  }
  
  protected void d()
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
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new afeu(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new afev(this));
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 22)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new afew(this));
      }
      while ((this.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mMemberInvitingFlag) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption == 3)))
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
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new afex(this));
        }
        else if (this.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new afey(this));
        }
        else if (this.jdField_d_of_type_Int == 22)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "kickOutDiscussionMember:" + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755829);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558435);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.jdField_d_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(2131691735));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_Antl.b(Long.parseLong(this.jdField_a_of_type_JavaLangString), Long.valueOf(paramString).longValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "kickOutDiscussionMember:" + paramString.toString());
      }
      bool = false;
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
    int i1 = 0;
    Object localObject1 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
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
              setResult(-1, paramIntent);
              finish();
              return;
            }
            ThreadManager.post(new TroopMemberListActivity.1(this, paramIntent, (anvk)localObject1, (TroopManager)localObject2), 8, null, true);
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
      localObject1 = ContactUtils.getDiscussionName(this.app, getApplicationContext(), paramIntent);
      localObject2 = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
      ((Intent)localObject2).putExtra("uin", paramIntent);
      ((Intent)localObject2).putExtra("uintype", 3000);
      ((Intent)localObject2).putExtra("uinname", (String)localObject1);
      ((Intent)localObject2).putExtra("isBack2Root", true);
      ((Intent)localObject2).setFlags(67108864);
      startActivity((Intent)localObject2);
      finish();
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (TextUtils.isEmpty(this.v));
    ThreadManager.post(new TroopMemberListActivity.2(this, (anvk)localObject1), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_d_of_type_Int == 11) {
      bdla.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    Object localObject = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("troop_uin");
    this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("troop_info_name");
    this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("troop_gift_from");
    this.jdField_h_of_type_JavaLangString = ((Bundle)localObject).getString("leftViewText");
    this.jdField_j_of_type_Boolean = ((Bundle)localObject).getBoolean("param_is_pop_up_style", false);
    this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("param_from", 0);
    this.jdField_i_of_type_JavaLangString = ((Bundle)localObject).getString("param_troop_fee_project_id");
    this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("param_troop_fee_entrance_type", -1);
    this.s = ((Bundle)localObject).getString("callback");
    this.jdField_o_of_type_Boolean = ((Bundle)localObject).getBoolean("param_troop_send_apollo_msg", false);
    this.jdField_o_of_type_Int = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM", 0);
    this.jdField_m_of_type_Int = ((Bundle)localObject).getInt("sort_type", 0);
    this.jdField_f_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num", this.jdField_f_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("param_pick_selected_list");
    this.jdField_e_of_type_JavaUtilList = ((Bundle)localObject).getStringArrayList("param_delete_filter_member_list");
    this.jdField_f_of_type_JavaUtilList = ((Bundle)localObject).getStringArrayList("param_hide_filter_member_list");
    this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num_exceeds_wording", 2131697327);
    this.jdField_k_of_type_JavaLangString = ((Bundle)localObject).getString("param_pick_title_string", this.jdField_k_of_type_JavaLangString);
    this.jdField_r_of_type_Boolean = ((Bundle)localObject).getBoolean("param_filter_robot", false);
    if (this.jdField_d_of_type_Int == 17) {
      new bdlf(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_b_of_type_JavaLangString }).a();
    }
    if (this.jdField_d_of_type_Int == 22) {
      bhbu.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
    }
    if ((this.jdField_d_of_type_Int == 9) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (QLog.isColorLevel())) {
      QLog.e("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    if (this.jdField_d_of_type_Int == 14)
    {
      this.jdField_m_of_type_Int = 7;
      this.jdField_p_of_type_Boolean = false;
    }
    this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("param_chat_mode", 0);
    this.jdField_j_of_type_JavaLangString = ((Bundle)localObject).getString("custom_title_name");
    String str1 = ((Bundle)localObject).getString("param_from");
    if (str1 != null) {}
    boolean bool;
    try
    {
      this.jdField_d_of_type_Int = Integer.parseInt(str1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, troopCode=" + this.jdField_b_of_type_JavaLangString + " troopUin=" + this.jdField_a_of_type_JavaLangString + " from=" + this.jdField_d_of_type_Int);
      }
      if (this.jdField_j_of_type_Boolean) {
        setTheme(2131755153);
      }
      super.doOnCreate(paramBundle);
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.jdField_e_of_type_Boolean + ", mTroopUin = " + this.jdField_b_of_type_JavaLangString);
      }
      setContentView(2131562994);
      b();
      if (this.jdField_o_of_type_Int == 0)
      {
        paramBundle = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_b_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_o_of_type_Int = paramBundle.wMemberNum;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        this.jdField_k_of_type_Boolean = ThemeUtil.isDefaultTheme();
        if (this.jdField_d_of_type_Int == 15)
        {
          this.jdField_m_of_type_Int = 6;
          this.jdField_f_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("param_seq_days");
          this.jdField_e_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("param_seq_name");
        }
        if ((this.jdField_m_of_type_Int == 1) || (this.jdField_m_of_type_Int == 8)) {
          ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).v(this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_m_of_type_Int == 5) {
          ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).w(this.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Antl = ((antl)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
        this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if ((paramBundle != null) && (localObject != null)) {
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((antp)localObject).a(this.jdField_b_of_type_JavaLangString);
            this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            if ((this.jdField_d_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(this.app.getCurrentAccountUin()))) {
              break label1100;
            }
            finish();
            return false;
            localNumberFormatException = localNumberFormatException;
            localNumberFormatException.printStackTrace();
          }
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramBundle.b(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_b_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop())) {}
        for (bool = true;; bool = false)
        {
          this.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, getCurrentAccountUin());
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
            break label1072;
          }
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
          this.jdField_n_of_type_Boolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopPrivilegeFlag, 32);
          break;
        }
        label1072:
        finish();
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    finish();
    return false;
    label1100:
    int i1;
    int i2;
    int i3;
    int i4;
    label1426:
    label1527:
    String str2;
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
    {
      addObserver(this.jdField_a_of_type_Antq);
      if ((this.jdField_o_of_type_Boolean) && (this.jdField_d_of_type_Int == 3)) {
        this.jdField_m_of_type_Int = 2;
      }
      if (this.jdField_d_of_type_Int == 0)
      {
        paramBundle = getResources().getDisplayMetrics();
        i1 = Math.max(paramBundle.widthPixels, paramBundle.heightPixels);
        i2 = getTitleBarHeight();
        i3 = ImmersiveUtils.getStatusBarHeight(this);
        i4 = (int)(60.0F * this.jdField_a_of_type_Float);
        this.jdField_j_of_type_Int = getResources().getDimensionPixelSize(2131299151);
        this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131296768);
        if (this.jdField_k_of_type_Int == 0) {
          this.jdField_k_of_type_Int = ((int)(paramBundle.density * 58.0F));
        }
        this.jdField_i_of_type_Int = (i1 - i2 - i3 - i4);
        this.jdField_l_of_type_Int = ((this.jdField_i_of_type_Int - this.jdField_j_of_type_Int) / this.jdField_k_of_type_Int);
        this.jdField_a_of_type_Bbcg = new bbcg(this);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_i_of_type_Int), Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(this.jdField_k_of_type_Int), Integer.valueOf(this.jdField_l_of_type_Int) }));
        }
      }
      if (this.jdField_d_of_type_Int == 1) {
        break label1940;
      }
      if (this.jdField_d_of_type_Int != 11) {
        break label1746;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.jdField_e_of_type_JavaLangString == null) || (!this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
          break label1740;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
      }
      bdla.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_c_of_type_Boolean = true;
      }
      localObject = getResources().getStringArray(2130968683);
      paramBundle = getResources().getStringArray(2130968682);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop())) {
        break label2056;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
      this.jdField_b_of_type_ArrayOfJavaLangString = paramBundle;
      c();
      e();
      f();
      a();
      localObject = "4";
      paramBundle = (Bundle)localObject;
      switch (this.jdField_d_of_type_Int)
      {
      default: 
        paramBundle = (Bundle)localObject;
      case 1: 
        label1591:
        str2 = "2";
        if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
          localObject = "0";
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_n_of_type_JavaLangString = ((String)localObject);
      a("exp", paramBundle, (String)localObject);
      if (this.jdField_d_of_type_Int == 14) {
        n();
      }
      if (this.jdField_d_of_type_Int == 18) {
        bdla.b(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_d_of_type_Int == 3) {
        ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).q(this.jdField_b_of_type_JavaLangString);
      }
      return true;
      this.app.addObserver(this.jdField_a_of_type_Aofu, true);
      break;
      label1740:
      bool = false;
      break label1426;
      label1746:
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin != null) {
          this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) {
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin.equals(this.app.getCurrentAccountUin()))) || ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(this.app.getCurrentAccountUin()))))
        {
          bool = true;
          label1857:
          this.jdField_a_of_type_Boolean = bool;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo admin: " + this.jdField_f_of_type_JavaLangString + "  owner:" + this.jdField_e_of_type_JavaLangString);
        break;
        bool = false;
        break label1857;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo==null");
        }
      }
      label1940:
      this.jdField_c_of_type_Boolean = true;
      this.t = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
      }
      for (;;)
      {
        if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
          this.jdField_a_of_type_Boolean = true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo owner: " + this.jdField_e_of_type_JavaLangString);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mDiscussionInfo==null");
        }
      }
      label2056:
      i3 = 0;
      i4 = 1;
      i2 = i4;
      i1 = i3;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.showGameSwitchStatus == 1)
      {
        i2 = i4;
        i1 = i3;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.gameSwitchStatus == 1)
        {
          i1 = 1;
          i2 = 2;
        }
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[localObject.length + i2];
      i3 = 0;
      int i5 = localObject.length;
      i4 = 0;
      while (i4 < i5)
      {
        str2 = localObject[i4];
        this.jdField_a_of_type_ArrayOfJavaLangString[i3] = str2;
        i4 += 1;
        i3 += 1;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString[i3] = getResources().getString(2131719705);
      if (i1 != 0) {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i3 + 1)] = getResources().getString(2131719704);
      }
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[i2 + paramBundle.length];
      i2 = 0;
      i4 = paramBundle.length;
      i3 = 0;
      while (i3 < i4)
      {
        localObject = paramBundle[i3];
        this.jdField_b_of_type_ArrayOfJavaLangString[i2] = localObject;
        i3 += 1;
        i2 += 1;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString[i2] = getResources().getString(2131719706);
      if (i1 == 0) {
        break label1527;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString[(i2 + 1)] = getResources().getString(2131719704);
      break label1527;
      paramBundle = "0";
      break label1591;
      paramBundle = "1";
      break label1591;
      paramBundle = "2";
      break label1591;
      paramBundle = "3";
      break label1591;
      localObject = str2;
      if (this.jdField_f_of_type_JavaLangString != null)
      {
        localObject = str2;
        if (this.jdField_f_of_type_JavaLangString.contains(this.app.getCurrentAccountUin())) {
          localObject = "1";
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_i_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      label13:
      if (this.jdField_a_of_type_Bbcg != null)
      {
        this.jdField_a_of_type_Bbcg.c();
        this.jdField_a_of_type_Bbcg = null;
      }
      try
      {
        removeObserver(this.jdField_a_of_type_Antq);
        removeObserver(this.jdField_a_of_type_Aofu);
        label48:
        if (this.jdField_a_of_type_Afgm != null) {
          this.jdField_a_of_type_Afgm.c();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_Afgk != null) {
          this.jdField_a_of_type_Afgk.c();
        }
        if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
          this.jdField_a_of_type_Bkzi.dismiss();
        }
        if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_b_of_type_AndroidAppDialog.dismiss();
        }
        return;
      }
      catch (Exception localException1)
      {
        break label48;
      }
    }
    catch (Exception localException2)
    {
      break label13;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13) && (this.jdField_d_of_type_Int != 21) && ((this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean)))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_d_of_type_Int != 22) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Afgk != null) {
        this.jdField_a_of_type_Afgk.a();
      }
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(48);
      label13:
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
        this.jdField_a_of_type_AndroidViewView.requestLayout();
        this.jdField_a_of_type_AndroidViewView.invalidate();
      }
      if (this.jdField_a_of_type_Bbcg != null) {
        this.jdField_a_of_type_Bbcg.a();
      }
      return;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  protected void e()
  {
    View localView = getLayoutInflater().inflate(2131563003, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377155));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362657));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView;
    int i1;
    label124:
    int i2;
    label142:
    Object localObject;
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839458);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380038);
      this.jdField_g_of_type_Int = ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).leftMargin;
      if ((this.jdField_d_of_type_Int != 3) || (!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 1)) {
        break label847;
      }
      i1 = 1;
      if ((this.jdField_d_of_type_Int != 11) || (!this.jdField_a_of_type_Boolean)) {
        break label852;
      }
      i2 = 1;
      if ((i1 != 0) || (i2 != 0))
      {
        localObject = getString(2131719642);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376504);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369417)).setBackgroundDrawable(bheg.d());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373427);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new afez(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new affa(this, (String)localObject));
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          break label857;
        }
        QQToast.a(this, 1, 2131694253, 0).b(getTitleBarHeight());
      }
      if ((this.jdField_d_of_type_Int != 3) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 1)) {
        break label956;
      }
      i1 = 1;
      label366:
      if ((this.jdField_d_of_type_Int != 11) || (this.jdField_a_of_type_Boolean)) {
        break label961;
      }
      i2 = 1;
      label384:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && ((i1 != 0) || (i2 != 0)))
      {
        localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          break label966;
        }
        QQToast.a(this, 1, 2131694253, 0).b(getTitleBarHeight());
      }
      label443:
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366280);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363845)).setVisibility(8);
      if (this.jdField_d_of_type_Int != 19) {
        break label1027;
      }
      localView = getLayoutInflater().inflate(2131562995, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new affb(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afgk = new afgk(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Afgk);
      if ((this.jdField_d_of_type_Int == 19) || (this.jdField_d_of_type_Int == 21)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 19)) {
        t();
      }
      ((EditText)localObject).setOnTouchListener(new affc(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_d_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839455);
      break;
      label847:
      i1 = 0;
      break label124;
      label852:
      i2 = 0;
      break label142;
      label857:
      if ((this.jdField_a_of_type_Antl != null) && (this.jdField_d_of_type_Int == 11)) {
        this.jdField_a_of_type_Antl.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839470);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject != null) {
          ((aoep)localObject).b(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        }
      }
      label956:
      i1 = 0;
      break label366;
      label961:
      i2 = 0;
      break label384;
      label966:
      if ((this.jdField_a_of_type_Antl != null) && (this.jdField_d_of_type_Int == 11))
      {
        this.jdField_a_of_type_Antl.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
        break label443;
      }
      if (localObject == null) {
        break label443;
      }
      ((aoep)localObject).b(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
      break label443;
      label1027:
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  protected void e(String paramString)
  {
    if (((bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this, this.jdField_b_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131719641));
    if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131690676));
    }
    azry.a(this.app, this, this.jdField_b_of_type_JavaLangString, paramString, 1, 1, localBundle);
    this.v = paramString;
    a("Clk_item", this.jdField_n_of_type_JavaLangString, "");
  }
  
  protected void f()
  {
    v();
    if (this.jdField_d_of_type_Int == 9) {
      ThreadManager.post(new TroopMemberListActivity.25(this), 8, null, true);
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
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13));
        localObject1 = null;
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 16) && (NetworkUtil.isNetworkAvailable(this)))
        {
          localObject2 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4);
          l1 = ((SharedPreferences)localObject2).getLong("key_last_update_time" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(System.currentTimeMillis() - l1);
          int i1 = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
            i1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum;
          }
          int i2 = ((SharedPreferences)localObject2).getInt("key_last_update_num" + this.jdField_b_of_type_JavaLangString, 0);
          ((SharedPreferences)localObject2).edit().putInt("key_last_update_num" + this.jdField_b_of_type_JavaLangString, i1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L + " min  curMemberNum:" + i1 + " lastUpdateMemberNum:" + i2);
          }
          localObject2 = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          if (localObject2 != null)
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            ((aoep)localObject2).a(true, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, a(), this.jdField_a_of_type_Long, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_a_of_type_JavaLangString + " troopCode: " + this.jdField_b_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((aoep)localObject2).a(Long.parseLong(this.jdField_b_of_type_JavaLangString), 0L, 1, 0, 0);
        if (this.jdField_d_of_type_Int == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_troop_info_last_update" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              ((aoep)localObject2).j(this.jdField_b_of_type_JavaLangString);
              ((aoep)localObject2).a(1, anrb.a(this.jdField_b_of_type_JavaLangString), 0L, 2, 0, 0, true);
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, getGroupInfoReq, mTroopUin:" + this.jdField_b_of_type_JavaLangString);
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
        ((bgko)this.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(this.jdField_b_of_type_JavaLangString, new affi(this));
        return;
        localObject1 = new TroopMemberListActivity.26(this);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListActivityget_troop_member", 2, localException.toString());
          }
        }
      }
    }
  }
  
  public void finish()
  {
    if ((this.jdField_d_of_type_Int == 9) && ((this.jdField_l_of_type_Boolean) || (this.jdField_c_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
      localIntent.putExtra("callback", this.s);
      setResult(-1, localIntent);
    }
    super.finish();
    if (this.jdField_j_of_type_Boolean) {
      overridePendingTransition(0, 2130771978);
    }
    if (this.jdField_d_of_type_Int == 12) {
      overridePendingTransition(0, 2130772001);
    }
  }
  
  public void g()
  {
    String[] arrayOfString;
    int i1;
    label55:
    int i2;
    if (this.jdField_d_of_type_Int == 9)
    {
      arrayOfString = getResources().getStringArray(2130968677);
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
        break label165;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
      i1 = arrayOfString.length;
      this.jdField_a_of_type_Bkzi = bkzi.a(this);
      i2 = 0;
      label65:
      if (i2 >= i1) {
        break label203;
      }
      if (!this.jdField_e_of_type_Boolean) {
        break label267;
      }
      if (!anvx.a(2131714955).equals(arrayOfString[i2])) {
        break label188;
      }
    }
    label267:
    for (;;)
    {
      i2 += 1;
      break label65;
      arrayOfString = getResources().getStringArray(2130968675);
      break;
      label113:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mMemberInvitingFlag))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption != 3)
        {
          i1 = arrayOfString.length - 1;
          break label55;
        }
        i1 = arrayOfString.length - 2;
        break label55;
      }
      i1 = arrayOfString.length - 2;
      break label55;
      label165:
      if (this.jdField_d_of_type_Int == 9)
      {
        i1 = arrayOfString.length;
        break label55;
      }
      i1 = arrayOfString.length - 5;
      break label55;
      label188:
      if (i2 == 2)
      {
        this.jdField_a_of_type_Bkzi.c(arrayOfString[i2]);
        label203:
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
          this.jdField_a_of_type_Bkzi.a(arrayOfString[3], 3);
        }
        this.jdField_a_of_type_Bkzi.c(2131690697);
        this.jdField_a_of_type_Bkzi.a(this.jdField_a_of_type_Bkzq);
        this.jdField_a_of_type_Bkzi.show();
        return;
        if (i2 == 3)
        {
          this.jdField_a_of_type_Bkzi.a(arrayOfString[i2], 3);
        }
        else
        {
          this.jdField_a_of_type_Bkzi.c(arrayOfString[i2]);
          if (arrayOfString[i2].equals(anvx.a(2131714915))) {
            bdla.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Afgk != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Afgk.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Afgk.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Afgk.jdField_a_of_type_Int) }));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.jdField_m_of_type_Int == 0) {
      if (this.jdField_d_of_type_Int == 11) {
        if ((this.jdField_a_of_type_Afgk != null) && (this.jdField_a_of_type_Afgk.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_Afgk.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility()) {
        s();
      }
      return;
      if (this.jdField_d_of_type_Int == 0)
      {
        if ((this.jdField_a_of_type_Afgk != null) && (this.jdField_a_of_type_Afgk.jdField_b_of_type_Int + this.jdField_a_of_type_Afgk.jdField_c_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Afgk.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else if ((this.jdField_a_of_type_Afgk != null) && (this.jdField_a_of_type_Afgk.jdField_b_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Afgk.jdField_a_of_type_Int > 1))
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
  
  public void i()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755829);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558435);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_d_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(2131718527));
      return;
      label76:
      bool = false;
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Int == 11) {
      bdla.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new affn(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new affo(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363845);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new affp(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Afgm.notifyDataSetChanged();
    this.jdField_h_of_type_Boolean = true;
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_b_of_type_JavaLangString;
    localIntent.putExtra("url", str);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "showMemberDstribute:" + str);
    }
    a("Clk_mberdist", this.jdField_n_of_type_JavaLangString, "");
  }
  
  protected void m()
  {
    ThreadManager.post(new TroopMemberListActivity.44(this), 8, null, true);
    a("Clk_invite", this.jdField_n_of_type_JavaLangString, "");
  }
  
  void n()
  {
    if (!this.jdField_n_of_type_Boolean)
    {
      ViewStub localViewStub = (ViewStub)findViewById(2131379603);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131379604)).setOnTouchListener(new afgb(this));
      }
    }
  }
  
  public void o()
  {
    if (!isResume()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Afgk != null) {}
      try
      {
        this.jdField_a_of_type_Afgk.notifyDataSetChanged();
        if (this.jdField_a_of_type_Afgm == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_Afgm.notifyDataSetChanged();
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
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */