package com.tencent.mobileqq.activity;

import aeap;
import aeaq;
import aear;
import aeas;
import aeat;
import aeau;
import aeav;
import aeaw;
import aeax;
import aeay;
import aeba;
import aebb;
import aebc;
import aebd;
import aebe;
import aebf;
import aebh;
import aebi;
import aebj;
import aebk;
import aebl;
import aebm;
import aebn;
import aebo;
import aebp;
import aebq;
import aebr;
import aebs;
import aebt;
import aebu;
import aebv;
import aebw;
import aebx;
import aeby;
import aebz;
import aeca;
import aecb;
import aecc;
import aece;
import aecg;
import aeci;
import aecj;
import aeck;
import aecl;
import aekt;
import aljl;
import alkk;
import almt;
import almv;
import almw;
import aloz;
import alpo;
import alxl;
import alzf;
import amab;
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
import awnk;
import azib;
import azmj;
import azmo;
import bahs;
import bbpo;
import bbpp;
import bcbt;
import bcgk;
import bcju;
import bckx;
import bdaj;
import bdal;
import bdbt;
import bdda;
import bdee;
import bdnm;
import bemh;
import bemi;
import bhpy;
import bhqd;
import bhqp;
import bhvq;
import bhvt;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
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
import xod;

public class TroopMemberListActivity
  extends BaseActivity
  implements bemh, bemi, bhqp
{
  public static double b;
  private static int jdField_p_of_type_Int = 1000;
  public double a;
  public float a;
  public int a;
  public long a;
  public aecg a;
  public aeci a;
  public aljl a;
  protected almt a;
  public almw a;
  public amab a;
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
  public bhpy a;
  protected bhqd a;
  public bhvq a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public TroopInfoData a;
  public IndexView a;
  public PinnedDividerSwipListView a;
  public XListView a;
  public String a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  public ArrayList<String> a;
  public List<aece> a;
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
  public List<aece> b;
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
  private String w = alpo.a(2131715938);
  
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aecc(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aeap(this);
    this.jdField_m_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_Bhqd = new aebf(this);
    this.jdField_a_of_type_AndroidOsHandler = new aebm(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new aebn(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new aebo(this);
    this.jdField_a_of_type_Almw = new aebr(this);
    this.jdField_a_of_type_Amab = new aebt(this);
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
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bhvq.getContentView().findViewById(2131364770);
    int i1 = 0;
    if (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      bhvt localbhvt = (bhvt)((View)localObject).getTag();
      if (localbhvt != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131377720);
        if (localObject != null)
        {
          if (localbhvt.jdField_a_of_type_Int != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131166912));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131166901));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(alpo.a(2131716008), new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(alpo.a(2131715944), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
      this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_Aecg.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_Aecg.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        q();
        h();
        if (this.jdField_a_of_type_Aecg == null) {
          break label302;
        }
        this.jdField_a_of_type_Aecg.notifyDataSetChanged();
        this.jdField_a_of_type_Aecg.a();
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
      this.jdField_a_of_type_Aecg = new aecg(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Aecg);
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
    Dialog localDialog = new Dialog(this, 2131755801);
    localDialog.setContentView(2131559078);
    ((TextView)localDialog.findViewById(2131365235)).setText(getString(2131691589));
    TextView localTextView = (TextView)localDialog.findViewById(2131365231);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131364242);
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
      localTextView.setText(getString(2131693826));
      localCheckBox.setText(getString(2131719162));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localTextView = (TextView)localDialog.findViewById(2131365220);
      localObject = (TextView)localDialog.findViewById(2131365226);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new aebp(this, localDialog));
      ((TextView)localObject).setOnClickListener(new aebq(this, paramList, localCheckBox, bool, localDialog));
      localDialog.show();
      return;
      bool = false;
      break;
      label291:
      localTextView.setText(getString(2131694618));
      localCheckBox.setText(getString(2131694620));
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
    aloz localaloz = (aloz)this.app.getManager(51);
    bckx localbckx = (bckx)this.app.getManager(203);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!bdal.d(localTroopMemberInfo.memberuin)) {
          break label244;
        }
        if ((this.jdField_d_of_type_Int != 2) || ((!localTroopMemberInfo.memberuin.equals(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.contains(localTroopMemberInfo.memberuin)))) {
          break label165;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label165:
        if (((this.jdField_f_of_type_JavaUtilList == null) || (!this.jdField_f_of_type_JavaUtilList.contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localbckx.b(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localaloz));
          continue;
          label244:
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
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378839);
        localObject1 = getString(2131721065);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375580);
        ((TextView)localObject2).setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368782)).setBackgroundDrawable(bdda.d());
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372536);
        ((ImageView)localObject3).setVisibility(8);
        if (i1 != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new aebu(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aebv(this, (String)localObject1));
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
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375580)).setCompoundDrawables(null, null, null, null);
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
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378839)).setTextColor(getResources().getColor(2131166901));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375580);
      localObject2 = alpo.a(2131715957);
      localObject3 = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371371);
      ((Button)localObject3).setVisibility(8);
      ((Button)localObject3).setOnClickListener(new aebw(this));
      i1 = ((alxl)this.app.a(13)).g();
      if (this.jdField_d_of_type_Int != 11) {
        break label773;
      }
    } while (!paramString1.equals(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = paramInt2;
    if ((paramBoolean2) && (paramInt1 > 0))
    {
      paramBoolean1 = true;
      label528:
      this.jdField_f_of_type_Boolean = paramBoolean1;
      if (!this.jdField_f_of_type_Boolean) {
        break label678;
      }
      this.jdField_g_of_type_JavaLangString = (alpo.a(2131715961) + paramInt1 + alpo.a(2131715964));
      ((TextView)localObject1).setText(this.jdField_g_of_type_JavaLangString);
      paramString1 = (String)localObject2 + "," + this.jdField_g_of_type_JavaLangString;
      label615:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        paramString2.rightMargin = aekt.a(20.0F, getResources());
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
        this.jdField_g_of_type_JavaLangString = alpo.a(2131716023);
        paramString1 = (String)localObject2 + ",剩余0次";
        ((TextView)localObject1).setText("剩余0次");
        break label615;
      }
      this.jdField_g_of_type_JavaLangString = "";
      paramString1 = (String)localObject2 + "," + alpo.a(2131716022);
      ((TextView)localObject1).setText("");
      break label615;
      label773:
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
          paramInt1 = (int)(alpo.a(2131716019).length() * 12 * this.jdField_a_of_type_Float);
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
      if (paramString1.contains(alpo.a(2131716029)))
      {
        paramInt1 = paramString1.indexOf(alpo.a(2131716030));
        paramInt2 = alpo.a(2131715947).length();
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
        } while (!((bckx)paramQQAppInterface.getManager(203)).b(paramString));
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
    if (this.jdField_a_of_type_Bhvq == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        bhvt localbhvt = new bhvt();
        localbhvt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localbhvt.jdField_a_of_type_Int = i1;
        localbhvt.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localArrayList.add(localbhvt);
        i1 += 1;
      }
      this.jdField_a_of_type_Bhvq = bhvq.a(this, localArrayList, new aebi(this), null, xod.a(this, 135.0F), false);
      this.jdField_a_of_type_Bhvq.setTouchInterceptor(new aebs(this));
      a(this.jdField_m_of_type_Int);
    }
    this.jdField_a_of_type_Bhvq.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(xod.a(this, 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
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
    this.jdField_e_of_type_AndroidViewView = getLayoutInflater().inflate(2131562751, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368199);
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
      localObject = (aece)localIterator.next();
      if (((aece)localObject).jdField_b_of_type_Long == 0L) {
        ((aece)localObject).jdField_b_of_type_Long = ((aece)localObject).jdField_a_of_type_Long;
      }
      if (TextUtils.isEmpty(a(((aece)localObject).jdField_b_of_type_Long, localCalendar, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
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
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new aeba(this, i1, i2));
        s();
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
        azmj.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.jdField_b_of_type_JavaLangString, "" + i2, "", "");
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
      localObject = this.jdField_e_of_type_AndroidViewView.findViewById(2131375743);
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
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131562573);
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
      int i1 = getResources().getColor(2131166957);
      new SystemBarCompact(this.jdField_b_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375981);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131376166));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838591));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aeci = new aeci(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aeci);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new aebb(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aeck(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375981);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131367807));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131371186);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375671));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aebc(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aebd(this));
  }
  
  private void u()
  {
    int i1 = this.jdField_a_of_type_Aecg.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format(alpo.a(2131716010), new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aebh(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131716036));
  }
  
  private void v()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(0, this.jdField_o_of_type_Int, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  public aece a(DiscussionMemberInfo paramDiscussionMemberInfo, aloz paramaloz)
  {
    aece localaece = new aece();
    localaece.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramaloz != null) {
      localFriends = paramaloz.b(paramDiscussionMemberInfo.memberUin);
    }
    localaece.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localaece.jdField_a_of_type_Short = 0;
    localaece.jdField_c_of_type_JavaLangString = ChnToSpell.a(localaece.jdField_b_of_type_JavaLangString, 2);
    localaece.a(ChnToSpell.a(localaece.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localaece.e(localFriends.remark);
      localaece.h(ChnToSpell.a(localaece.jdField_j_of_type_JavaLangString, 1));
      localaece.f(ChnToSpell.a(localaece.jdField_j_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localaece.i(paramDiscussionMemberInfo.memberName);
        localaece.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localaece.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      if (this.jdField_a_of_type_Aljl != null) {
        this.jdField_a_of_type_Aljl.a(localaece);
      }
      return localaece;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localaece.e(paramDiscussionMemberInfo.inteRemark);
        localaece.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localaece.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public aece a(TroopMemberInfo paramTroopMemberInfo, aloz paramaloz)
  {
    aece localaece = new aece();
    localaece.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramaloz != null) {
      localFriends = paramaloz.b(paramTroopMemberInfo.memberuin);
    }
    localaece.jdField_b_of_type_JavaLangString = bdbt.c(this.app, this.jdField_b_of_type_JavaLangString, localaece.jdField_a_of_type_JavaLangString, true);
    localaece.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localaece.jdField_c_of_type_JavaLangString = ChnToSpell.a(localaece.jdField_b_of_type_JavaLangString, 2);
    localaece.a(ChnToSpell.a(localaece.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localaece.b(paramTroopMemberInfo.friendnick);
      localaece.d(paramTroopMemberInfo.pyAll_friendnick);
      localaece.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localaece.e(localFriends.remark);
      localaece.h(ChnToSpell.a(localaece.jdField_j_of_type_JavaLangString, 1));
      localaece.f(ChnToSpell.a(localaece.jdField_j_of_type_JavaLangString, 2));
      localaece.g(localFriends.remark);
      if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
      {
        localaece.i(paramTroopMemberInfo.troopColorNick);
        localaece.k(paramTroopMemberInfo.pyAll_troopnick);
        localaece.j(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localaece.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localaece.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localaece.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localaece.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
      localaece.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localaece.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localaece.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localaece.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      localaece.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.app.getManager(52)).a(this.jdField_b_of_type_JavaLangString, localaece.jdField_a_of_type_JavaLangString);
      if ((d1 == -1000.0D) || (d1 == -100.0D)) {
        break label704;
      }
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
      if (d1 <= 10.0D) {
        break label669;
      }
      localaece.t = ((int)d1 + "km");
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localaece.u = paramTroopMemberInfo.mUniqueTitle;
        localaece.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if (this.jdField_a_of_type_Aljl != null) {
        this.jdField_a_of_type_Aljl.a(localaece);
      }
      localaece.jdField_e_of_type_Int = paramTroopMemberInfo.mVipType;
      localaece.jdField_f_of_type_Int = paramTroopMemberInfo.mVipLevel;
      localaece.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localaece.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
      localaece.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
      localaece.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localaece.v = paramTroopMemberInfo.honorList;
      return localaece;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.jdField_e_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localaece.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localaece.h(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localaece.f(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
        break;
      }
      localaece.e(paramTroopMemberInfo.autoremark);
      localaece.h(paramTroopMemberInfo.pyAll_autoremark);
      localaece.f(paramTroopMemberInfo.pyFirst_autoremark);
      break;
      label669:
      localaece.t = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
      continue;
      label704:
      localaece.t = "";
    }
  }
  
  public aece a(String paramString)
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
          aece localaece = (aece)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localaece != null) && (localaece.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (aece)this.jdField_a_of_type_JavaUtilList.remove(i1);
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
  
  public aecl a(String paramString, boolean paramBoolean)
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
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof aecl)))
      {
        localObject2 = (aecl)((View)localObject2).getTag();
        if ((((aecl)localObject2).jdField_a_of_type_JavaLangString != null) && (((aecl)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
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
  
  public List<aece> a(List<aece> paramList, String paramString1, String paramString2)
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
        aece localaece = (aece)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localaece.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localaece);
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
        paramString1 = (aece)paramList.get(i3);
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
        paramString1 = (aece)paramList.get(i4);
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
          paramString1 = (aece)paramList.get(i2);
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
            paramString1 = (aece)paramList.get(i2);
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
              paramString1 = (aece)paramList.get(i2);
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
    Object localObject = (ViewGroup)findViewById(2131375812);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377903);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131368613);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void a(aece paramaece)
  {
    int i1 = 3;
    if ((paramaece != null) && (paramaece.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.clear();
      paramaece = new Intent();
      paramaece.putExtra("result", new JSONArray().toString());
      setResult(-1, paramaece);
      azmj.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
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
          } while ((paramaece == null) || (paramaece.jdField_a_of_type_JavaLangString == null));
          if (this.jdField_d_of_type_Int == 1)
          {
            if (this.app.getCurrentAccountUin().equals(paramaece.jdField_a_of_type_JavaLangString))
            {
              localObject1 = new ProfileActivity.AllInOne(paramaece.jdField_a_of_type_JavaLangString, 0);
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = bdbt.h(this.app, paramaece.jdField_a_of_type_JavaLangString);
              ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 3;
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 4;
              ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
              return;
            }
            a(paramaece.jdField_a_of_type_JavaLangString, paramaece.jdField_b_of_type_JavaLangString);
            return;
          }
          if (this.jdField_d_of_type_Int == 2)
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_uin", paramaece.jdField_a_of_type_JavaLangString);
            localObject2 = new TroopMemberListActivity.TroopAdmin();
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramaece.jdField_a_of_type_JavaLangString;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramaece.jdField_a_of_type_Short;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramaece.jdField_b_of_type_JavaLangString;
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
              ((Intent)localObject1).putExtra("member_display_name", paramaece.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("isApollo", true);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("member_uin", paramaece.jdField_a_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
              setResult(-1, (Intent)localObject1);
              finish();
              return;
              ((Intent)localObject1).putExtra("member_display_name", paramaece.jdField_b_of_type_JavaLangString);
            }
          }
          if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 4) && (this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
            break;
          }
          e(paramaece.jdField_a_of_type_JavaLangString);
        } while (this.jdField_d_of_type_Int != 22);
        bdaj.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
        return;
        if (this.jdField_d_of_type_Int == 5)
        {
          if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramaece.jdField_a_of_type_JavaLangString)))
          {
            startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.jdField_b_of_type_JavaLangString, paramaece.jdField_a_of_type_JavaLangString, i1, paramaece.u), 2);
            this.v = paramaece.jdField_a_of_type_JavaLangString;
            localObject1 = this.app;
            localObject2 = this.jdField_b_of_type_JavaLangString;
            i1 = this.jdField_m_of_type_Int;
            if (!this.jdField_m_of_type_Boolean) {
              break label633;
            }
          }
          for (paramaece = "1";; paramaece = "0")
          {
            azmj.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramaece, "");
            return;
            if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(paramaece.jdField_a_of_type_JavaLangString)))
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
          ((Intent)localObject1).putExtra("member_uin", paramaece.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_display_name", paramaece.jdField_b_of_type_JavaLangString);
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
            this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.add(paramaece);
            paramaece = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList != null)
            {
              localObject2 = this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  aece localaece = (aece)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localaece.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localaece.jdField_b_of_type_JavaLangString);
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
            paramaece.putExtra("result", ((JSONArray)localObject1).toString());
            setResult(-1, paramaece);
            finish();
            return;
          }
          if (this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.contains(paramaece)) {
            this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.remove(paramaece);
          }
          for (;;)
          {
            this.jdField_a_of_type_Aecg.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.size() < this.jdField_f_of_type_Int)
            {
              this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.add(paramaece);
            }
            else if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.add(paramaece);
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
        ((Intent)localObject1).putExtra("member_uin", paramaece.jdField_a_of_type_JavaLangString);
        PublicFragmentActivity.a(this, (Intent)localObject1, TroopMemberHistoryFragment.class);
      } while (this.jdField_d_of_type_Int != 19);
      paramaece = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
      bdaj.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(paramaece) });
      return;
    } while (this.jdField_d_of_type_Int != 23);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_member_name", paramaece.jdField_g_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramaece.jdField_a_of_type_JavaLangString));
    ((Intent)localObject1).putExtra("folderPath", "/");
    ((Intent)localObject1).putExtra("param_from", 6000);
    TroopFileProxyActivity.a(this, (Intent)localObject1, this.app.getCurrentAccountUin());
  }
  
  public void a(aecl paramaecl, aece paramaece, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    label84:
    Object localObject;
    label153:
    label364:
    int i3;
    if (paramBoolean1)
    {
      str = this.u;
      paramaecl.jdField_a_of_type_Boolean = paramBoolean1;
      paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramaecl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaecl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaecl.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if ((this.jdField_m_of_type_Int != 1) && (this.jdField_m_of_type_Int != 5)) {
        break label867;
      }
      if (paramaece.jdField_d_of_type_Boolean) {
        break label854;
      }
      paramaecl.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      if ((this.jdField_b_of_type_Boolean) || (a()) || (paramaece.jdField_d_of_type_Int == -100) || (paramaece.jdField_d_of_type_Int == 0)) {
        break label889;
      }
      paramaecl.j.setVisibility(8);
      paramaecl.j.setText("LV" + paramaece.jdField_d_of_type_Int);
      VipUtils.a(this.app, this, getResources(), paramaecl, paramaece);
      if ((this.jdField_d_of_type_Int != 13) || (!paramBoolean1)) {
        break label901;
      }
      paramBitmap = paramaece.jdField_b_of_type_JavaLangString + "(" + paramaece.jdField_a_of_type_JavaLangString + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramaece.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramaecl.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label265:
      if ((paramBoolean2) && (paramaecl.k != null))
      {
        paramBitmap = alpo.a(2131715930) + paramaece.jdField_j_of_type_JavaLangString;
        paramaecl.k.setText(paramBitmap);
      }
      paramaecl.jdField_a_of_type_JavaLangString = paramaece.jdField_a_of_type_JavaLangString;
      paramaecl.jdField_c_of_type_Int = 1;
      paramaecl.f.setText("");
      paramaecl.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
      if (this.jdField_d_of_type_Int != 9) {
        break label986;
      }
      paramaecl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaecl.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaecl.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label1001;
      }
      paramaecl.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaecl.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_d_of_type_Boolean) {
        paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
      label445:
      i3 = 0;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13)) {
        break label1131;
      }
      paramaecl.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691930) + paramaecl.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramaecl.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130849049);
      if (this.jdField_d_of_type_Int != 13) {
        break label1048;
      }
      paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label534:
      if (!str.equals(paramaece.jdField_a_of_type_JavaLangString)) {
        break label1120;
      }
      paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    int i1;
    int i2;
    for (;;)
    {
      paramaecl.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131691908), new Object[] { paramaecl.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramaecl.g.setContentDescription(getString(2131691907));
      i1 = i3;
      if (paramaecl.jdField_d_of_type_AndroidViewView != null)
      {
        paramBitmap = (bckx)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramaece.jdField_a_of_type_JavaLangString))) {
          break label2557;
        }
        i2 = 1;
        label647:
        if (i2 == 0) {
          break label2563;
        }
        paramaecl.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      label660:
      if (this.jdField_e_of_type_Boolean) {
        paramaecl.j.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramaecl.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      if ((paramBoolean2) && (paramaecl.k != null)) {
        paramBitmap.append(paramaecl.k.getText());
      }
      if (paramaecl.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        paramBitmap.append(paramaecl.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      }
      if (paramaecl.j.getVisibility() == 0) {
        paramBitmap.append(paramaecl.j.getText().toString());
      }
      if (paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.getVisibility() == 0) {
        paramBitmap.append(paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.a());
      }
      if ((paramaecl.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_Boolean))
      {
        if (i1 == 0) {
          break label2575;
        }
        paramaece = "已选中";
        label827:
        paramBitmap.append(paramaece);
      }
      paramaecl.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
      return;
      str = this.t;
      break;
      label854:
      paramaecl.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      break label84;
      label867:
      paramaecl.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramaecl.j.setVisibility(8);
      break label84;
      label889:
      paramaecl.j.setVisibility(8);
      break label153;
      label901:
      if (paramBoolean2)
      {
        paramBitmap = new bahs(paramaece.jdField_g_of_type_JavaLangString, 16).a();
        paramaecl.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
        bdnm.a(this.app, paramaecl.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
        break label265;
      }
      paramBitmap = new bahs(paramaece.jdField_b_of_type_JavaLangString, 16).a();
      paramaecl.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      bdnm.a(this.app, paramaecl.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
      break label265;
      label986:
      paramaecl.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
      break label364;
      label1001:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramaecl.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramaecl.jdField_a_of_type_AndroidViewView.setClickable(false);
        break label445;
      }
      paramaecl.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramaecl.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label445;
      label1048:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      if ((this.jdField_e_of_type_JavaLangString != null) && (!paramaece.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString)))
      {
        paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label534;
      label1120:
      paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label1131:
    paramaecl.jdField_c_of_type_AndroidWidgetTextView.setText("");
    label1153:
    boolean bool1;
    label1177:
    boolean bool2;
    label1208:
    boolean bool4;
    boolean bool5;
    if (!TextUtils.isEmpty(paramaece.u))
    {
      paramBoolean1 = true;
      if ((paramaece.jdField_a_of_type_JavaLangString == null) || (!paramaece.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString))) {
        break label1458;
      }
      bool1 = true;
      if ((this.jdField_f_of_type_JavaLangString == null) || (paramaece.jdField_a_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.contains(paramaece.jdField_a_of_type_JavaLangString))) {
        break label1464;
      }
      bool2 = true;
      bool4 = this.app.getCurrentAccountUin().equals(this.jdField_e_of_type_JavaLangString);
      bool5 = this.app.getCurrentAccountUin().equals(paramaece.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int != 5) {
        break label1589;
      }
      paramaecl.h.setVisibility(0);
      paramaecl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
      paramaecl.i.setVisibility(0);
      localObject = "";
      i2 = 0;
      if ((!paramBoolean1) || (azib.b())) {
        break label1470;
      }
      paramBitmap = bbpo.a().a(302, paramBoolean1, bool1, bool2);
      if (paramBitmap == null) {
        break label2597;
      }
      i1 = paramBitmap.jdField_b_of_type_Int;
      paramBitmap = paramaece.u;
    }
    for (;;)
    {
      label1331:
      if (!TextUtils.isEmpty(paramBitmap))
      {
        paramaecl.h.setText(paramBitmap);
        bbpo.a(paramaecl.h, i1);
      }
      for (;;)
      {
        label1355:
        paramBitmap = (bckx)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramaece.jdField_a_of_type_JavaLangString))) {
          break label2272;
        }
        i1 = 1;
        label1387:
        if (!this.jdField_c_of_type_Boolean) {
          break label2338;
        }
        if ((this.jdField_d_of_type_Int == 21) || ((!bool1) && ((bool4) || (!bool2)) && ((bool4) || (i1 == 0)))) {
          break label2278;
        }
        paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        paramBoolean1 = false;
        break label1153;
        label1458:
        bool1 = false;
        break label1177;
        label1464:
        bool2 = false;
        break label1208;
        label1470:
        if (bool1)
        {
          localbbpp = bbpo.a().a(300, paramBoolean1, bool1, bool2);
          i1 = i2;
          paramBitmap = (Bitmap)localObject;
          if (localbbpp == null) {
            break label1331;
          }
          i1 = localbbpp.jdField_b_of_type_Int;
          paramBitmap = localbbpp.jdField_a_of_type_JavaLangString;
          break label1331;
        }
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (!bool2) {
          break label1331;
        }
        bbpp localbbpp = bbpo.a().a(301, paramBoolean1, bool1, bool2);
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (localbbpp == null) {
          break label1331;
        }
        i1 = localbbpp.jdField_b_of_type_Int;
        paramBitmap = localbbpp.jdField_a_of_type_JavaLangString;
        break label1331;
        paramaecl.h.setVisibility(8);
      }
      label1589:
      i1 = 0;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop();
      }
      if ((bool3) || (this.jdField_b_of_type_Boolean))
      {
        localObject = bbpo.a().a(bool1, bool2);
        if (localObject == null) {
          break label2588;
        }
        paramBitmap = ((bbpp)localObject).jdField_a_of_type_JavaLangString;
        i1 = ((bbpp)localObject).jdField_b_of_type_Int;
      }
      for (;;)
      {
        label1653:
        if (this.jdField_d_of_type_Int == 11) {
          paramBitmap = "";
        }
        i2 = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
        {
          if (1 == this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag) {
            i2 = 1;
          }
        }
        else
        {
          label1689:
          if (((!azib.b()) && (i2 != 0)) || (!bool1)) {
            break label2137;
          }
          localObject = String.format(getString(2131689530), new Object[0]);
          label1721:
          if (((!azib.b()) && (i2 != 0)) || (bool2) || (bool1)) {
            break label2178;
          }
          i2 = 1;
          label1745:
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (a()) || (i2 != 0)) {
            break label2184;
          }
          paramaecl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramaecl.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          bbpo.a(paramaecl.jdField_c_of_type_AndroidWidgetTextView, i1);
          label1791:
          paramBitmap = (bcbt)this.app.getManager(346);
          if (!paramBitmap.b(this.jdField_b_of_type_JavaLangString)) {
            break label2216;
          }
          paramBitmap = paramBitmap.a(paramaece.v);
          if ((paramBitmap == null) || (paramBitmap.size() <= 0)) {
            break label2196;
          }
          paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(paramBitmap);
          paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(0);
          label1854:
          if (this.jdField_b_of_type_Boolean)
          {
            paramBitmap = bbpo.a().a(paramaece.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap == null) || (!bcgk.a(paramaece.jdField_a_of_type_Int))) {
              break label2248;
            }
            if ((TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) || (azib.b())) {
              break label2236;
            }
            paramaecl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramaecl.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
            bbpo.a(paramaecl.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
          }
        }
        for (;;)
        {
          if ((this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 12)) {
            break label2258;
          }
          if ((paramaece.jdField_a_of_type_JavaLangString == null) || (!paramaece.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
            break label2260;
          }
          paramaecl.f.setText(getString(2131694672));
          break;
          localObject = bbpo.a().a(paramaece.jdField_a_of_type_Int, paramBoolean1, bool1, bool2);
          if (localObject != null)
          {
            paramBitmap = ((bbpp)localObject).jdField_a_of_type_JavaLangString;
            i2 = ((bbpp)localObject).jdField_b_of_type_Int;
            if (((bbpp)localObject).jdField_a_of_type_Int == 302) {
              paramBitmap = paramaece.u;
            }
            i1 = i2;
            if (((bbpp)localObject).jdField_a_of_type_Int != 315) {
              break label1653;
            }
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramaece.jdField_c_of_type_Int));
            i1 = i2;
            break label1653;
          }
          if (paramaece.jdField_a_of_type_Int != 315) {
            break label2582;
          }
          paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramaece.jdField_c_of_type_Int));
          i1 = Color.parseColor("#8EBDF9");
          break label1653;
          i2 = 0;
          break label1689;
          label2137:
          if (!azib.b())
          {
            localObject = paramBitmap;
            if (i2 != 0) {
              break label1721;
            }
          }
          localObject = paramBitmap;
          if (!bool2) {
            break label1721;
          }
          localObject = String.format(getString(2131689529), new Object[0]);
          break label1721;
          label2178:
          i2 = 0;
          break label1745;
          label2184:
          paramaecl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1791;
          label2196:
          paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label1854;
          label2216:
          paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramaecl.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label1854;
          label2236:
          paramaecl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label2248:
          paramaecl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        label2258:
        break label1355;
        label2260:
        paramaecl.f.setText("");
        break label1355;
        label2272:
        i1 = 0;
        break label1387;
        label2278:
        paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramaecl.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130849049);
        if (str.equals(paramaece.jdField_a_of_type_JavaLangString))
        {
          paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
          i1 = i3;
          break;
        }
        paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        label2338:
        if (this.jdField_d_of_type_Boolean)
        {
          if ((bool1) || ((!bool4) && (bool2)) || (bool5))
          {
            i1 = 1;
            label2368:
            if (i1 == 0) {
              break label2394;
            }
            paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(8);
            i1 = 0;
          }
          for (;;)
          {
            break;
            i1 = 0;
            break label2368;
            label2394:
            paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramaece.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aecg.jdField_b_of_type_JavaUtilList.contains(paramaece.jdField_a_of_type_JavaLangString)))
            {
              paramaecl.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840305);
              i1 = 1;
            }
            else
            {
              paramaecl.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840301);
              i1 = 0;
            }
          }
        }
        if (this.jdField_d_of_type_Int == 20)
        {
          paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramaece.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aecg.jdField_a_of_type_JavaUtilList.contains(paramaece)))
          {
            paramaecl.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840305);
            i1 = 1;
            break;
          }
          paramaecl.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840301);
          i1 = i3;
          break;
        }
        paramaecl.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramaecl.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        label2557:
        i2 = 0;
        break label647;
        label2563:
        paramaecl.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label660;
        label2575:
        paramaece = "未选中";
        break label827;
        label2582:
        paramBitmap = "";
        continue;
        label2588:
        i1 = 0;
        paramBitmap = "";
      }
      label2597:
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
      i1 = this.jdField_a_of_type_Aecg.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i1 + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        azmj.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_d_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    azmj.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (aloz)this.app.getManager(51);
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
      azmj.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString2, paramString3, "");
    }
    azmj.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString3, "", "");
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
    //   26: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc_w 578
    //   35: iconst_2
    //   36: new 580	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 581	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1905
    //   46: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 961	java/lang/System:currentTimeMillis	()J
    //   63: putfield 261	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   66: aload_2
    //   67: ifnull +15 -> 82
    //   70: aload_2
    //   71: astore 8
    //   73: aload_2
    //   74: invokeinterface 1907 1 0
    //   79: ifeq +528 -> 607
    //   82: new 114	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 115	java/util/ArrayList:<init>	()V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 601	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 1911	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawbx;
    //   97: invokevirtual 1917	awbx:createEntityManager	()Lawbw;
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_1
    //   105: ldc_w 617
    //   108: invokevirtual 1922	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: bipush 19
    //   113: anewarray 349	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 1923
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 1924
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 1925
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 1926
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 1927
    //   145: aastore
    //   146: dup
    //   147: iconst_5
    //   148: ldc_w 1928
    //   151: aastore
    //   152: dup
    //   153: bipush 6
    //   155: ldc_w 1929
    //   158: aastore
    //   159: dup
    //   160: bipush 7
    //   162: ldc_w 1930
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: ldc_w 1932
    //   172: aastore
    //   173: dup
    //   174: bipush 9
    //   176: ldc_w 1934
    //   179: aastore
    //   180: dup
    //   181: bipush 10
    //   183: ldc_w 1936
    //   186: aastore
    //   187: dup
    //   188: bipush 11
    //   190: ldc_w 1937
    //   193: aastore
    //   194: dup
    //   195: bipush 12
    //   197: ldc_w 1938
    //   200: aastore
    //   201: dup
    //   202: bipush 13
    //   204: ldc_w 1939
    //   207: aastore
    //   208: dup
    //   209: bipush 14
    //   211: ldc_w 1940
    //   214: aastore
    //   215: dup
    //   216: bipush 15
    //   218: ldc_w 1941
    //   221: aastore
    //   222: dup
    //   223: bipush 16
    //   225: ldc_w 1942
    //   228: aastore
    //   229: dup
    //   230: bipush 17
    //   232: ldc_w 1943
    //   235: aastore
    //   236: dup
    //   237: bipush 18
    //   239: ldc_w 1944
    //   242: aastore
    //   243: ldc_w 1946
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
    //   258: invokevirtual 1951	awbw:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +289 -> 552
    //   266: aload_1
    //   267: invokeinterface 1956 1 0
    //   272: ifeq +274 -> 546
    //   275: new 617	com/tencent/mobileqq/data/TroopMemberInfo
    //   278: dup
    //   279: invokespecial 1957	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload_1
    //   287: iconst_0
    //   288: invokeinterface 1958 2 0
    //   293: putfield 620	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   296: aload 9
    //   298: aload_1
    //   299: iconst_1
    //   300: invokeinterface 1958 2 0
    //   305: invokestatic 1961	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   308: putfield 1368	com/tencent/mobileqq/data/TroopMemberInfo:mIsShielded	Z
    //   311: aload 9
    //   313: aload_1
    //   314: iconst_2
    //   315: invokeinterface 1958 2 0
    //   320: putfield 1395	com/tencent/mobileqq/data/TroopMemberInfo:mUniqueTitle	Ljava/lang/String;
    //   323: aload 9
    //   325: aload_1
    //   326: iconst_3
    //   327: invokeinterface 1964 2 0
    //   332: putfield 1347	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   335: aload 9
    //   337: aload_1
    //   338: iconst_4
    //   339: invokeinterface 1968 2 0
    //   344: putfield 1364	com/tencent/mobileqq/data/TroopMemberInfo:active_point	J
    //   347: aload 9
    //   349: aload_1
    //   350: iconst_5
    //   351: invokeinterface 1968 2 0
    //   356: putfield 1356	com/tencent/mobileqq/data/TroopMemberInfo:credit_level	J
    //   359: aload 9
    //   361: aload_1
    //   362: bipush 6
    //   364: invokeinterface 1968 2 0
    //   369: putfield 1341	com/tencent/mobileqq/data/TroopMemberInfo:last_active_time	J
    //   372: aload 9
    //   374: aload_1
    //   375: bipush 7
    //   377: invokeinterface 1968 2 0
    //   382: putfield 1344	com/tencent/mobileqq/data/TroopMemberInfo:join_time	J
    //   385: aload 9
    //   387: aload_1
    //   388: bipush 8
    //   390: invokeinterface 1958 2 0
    //   395: putfield 1970	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   398: aload 9
    //   400: aload_1
    //   401: bipush 9
    //   403: invokeinterface 1958 2 0
    //   408: putfield 1335	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_troopnick	Ljava/lang/String;
    //   411: aload 9
    //   413: aload_1
    //   414: bipush 10
    //   416: invokeinterface 1958 2 0
    //   421: putfield 1338	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_troopnick	Ljava/lang/String;
    //   424: aload 9
    //   426: aload_1
    //   427: bipush 11
    //   429: invokeinterface 1958 2 0
    //   434: putfield 1315	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   437: aload 9
    //   439: aload_1
    //   440: bipush 12
    //   442: invokeinterface 1958 2 0
    //   447: putfield 1320	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_friendnick	Ljava/lang/String;
    //   450: aload 9
    //   452: aload_1
    //   453: bipush 13
    //   455: invokeinterface 1958 2 0
    //   460: putfield 1325	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_friendnick	Ljava/lang/String;
    //   463: aload 9
    //   465: aload_1
    //   466: bipush 14
    //   468: invokeinterface 1958 2 0
    //   473: putfield 1430	com/tencent/mobileqq/data/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   476: aload 9
    //   478: aload_1
    //   479: bipush 15
    //   481: invokeinterface 1958 2 0
    //   486: putfield 1436	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_autoremark	Ljava/lang/String;
    //   489: aload 9
    //   491: aload_1
    //   492: bipush 16
    //   494: invokeinterface 1958 2 0
    //   499: putfield 1439	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_autoremark	Ljava/lang/String;
    //   502: aload 9
    //   504: aload_1
    //   505: bipush 17
    //   507: invokeinterface 1964 2 0
    //   512: putfield 1351	com/tencent/mobileqq/data/TroopMemberInfo:realLevel	I
    //   515: aload 9
    //   517: aload_1
    //   518: bipush 18
    //   520: invokeinterface 1958 2 0
    //   525: putfield 1332	com/tencent/mobileqq/data/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   528: aload_2
    //   529: aload 9
    //   531: invokeinterface 645 2 0
    //   536: pop
    //   537: aload_1
    //   538: invokeinterface 1973 1 0
    //   543: ifne -268 -> 275
    //   546: aload_1
    //   547: invokeinterface 1976 1 0
    //   552: aload 8
    //   554: invokevirtual 1977	awbw:a	()V
    //   557: invokestatic 961	java/lang/System:currentTimeMillis	()J
    //   560: lstore 6
    //   562: aload_2
    //   563: astore 8
    //   565: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +39 -> 607
    //   571: ldc_w 578
    //   574: iconst_2
    //   575: new 580	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 581	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 1979
    //   585: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: lload 6
    //   590: aload_0
    //   591: getfield 261	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   594: lsub
    //   595: invokevirtual 1982	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_2
    //   605: astore 8
    //   607: aload 8
    //   609: ifnull +13 -> 622
    //   612: aload 8
    //   614: invokeinterface 1907 1 0
    //   619: ifeq +26 -> 645
    //   622: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +13 -> 638
    //   628: ldc_w 578
    //   631: iconst_2
    //   632: ldc_w 1984
    //   635: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload_0
    //   639: invokevirtual 434	com/tencent/mobileqq/activity/TroopMemberListActivity:k	()V
    //   642: aload_0
    //   643: monitorexit
    //   644: return
    //   645: aload 8
    //   647: invokeinterface 411 1 0
    //   652: istore 4
    //   654: aload_0
    //   655: iload 4
    //   657: putfield 258	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_o_of_type_Int	I
    //   660: iload 4
    //   662: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   665: idiv
    //   666: istore 5
    //   668: iload 4
    //   670: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   673: irem
    //   674: ifne +195 -> 869
    //   677: iconst_0
    //   678: istore_3
    //   679: aload_0
    //   680: iload_3
    //   681: iload 5
    //   683: iadd
    //   684: putfield 233	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_n_of_type_Int	I
    //   687: iconst_0
    //   688: istore_3
    //   689: iload_3
    //   690: iload 4
    //   692: if_icmpge +42 -> 734
    //   695: new 1986	com/tencent/mobileqq/activity/TroopMemberListActivity$35
    //   698: dup
    //   699: aload_0
    //   700: aload 8
    //   702: iload_3
    //   703: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   706: iload_3
    //   707: iadd
    //   708: iconst_1
    //   709: isub
    //   710: iload 4
    //   712: invokestatic 1992	java/lang/Math:min	(II)I
    //   715: invokespecial 1995	com/tencent/mobileqq/activity/TroopMemberListActivity$35:<init>	(Lcom/tencent/mobileqq/activity/TroopMemberListActivity;Ljava/util/List;II)V
    //   718: bipush 8
    //   720: aconst_null
    //   721: iconst_1
    //   722: invokestatic 970	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   725: iload_3
    //   726: getstatic 85	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_p_of_type_Int	I
    //   729: iadd
    //   730: istore_3
    //   731: goto -42 -> 689
    //   734: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq -95 -> 642
    //   740: ldc_w 578
    //   743: iconst_2
    //   744: new 580	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 581	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 1997
    //   754: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: iload 4
    //   759: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   762: ldc_w 1999
    //   765: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_0
    //   769: getfield 233	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_n_of_type_Int	I
    //   772: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: goto -139 -> 642
    //   784: astore_1
    //   785: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq -146 -> 642
    //   791: ldc_w 578
    //   794: iconst_2
    //   795: new 580	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 581	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 2001
    //   805: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload_1
    //   809: invokevirtual 1898	java/lang/Exception:toString	()Ljava/lang/String;
    //   812: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: goto -179 -> 642
    //   824: astore_1
    //   825: aload_0
    //   826: monitorexit
    //   827: aload_1
    //   828: athrow
    //   829: astore_1
    //   830: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq -191 -> 642
    //   836: ldc_w 578
    //   839: iconst_2
    //   840: new 580	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 581	java/lang/StringBuilder:<init>	()V
    //   847: ldc_w 2001
    //   850: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_1
    //   854: invokevirtual 2002	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   857: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: goto -224 -> 642
    //   869: iconst_1
    //   870: istore_3
    //   871: goto -192 -> 679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	TroopMemberListActivity
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
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0) || (this.jdField_a_of_type_Aecg == null)) {
      break label16;
    }
    label16:
    while (this.jdField_a_of_type_Aecg.jdField_b_of_type_Int + this.jdField_a_of_type_Aecg.jdField_c_of_type_Int > 16) {
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
        localObject = (aloz)this.app.getManager(51);
        this.jdField_c_of_type_JavaUtilList = ((almv)this.app.getManager(53)).a(paramString);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, queryTime:" + (l2 - l1));
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
            if (((this.jdField_d_of_type_Int == 2) && (paramString.memberUin.equals(this.jdField_e_of_type_JavaLangString))) || ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))) {
              break label562;
            }
            paramString = a(paramString, (aloz)localObject);
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
          break label562;
        }
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, continued:" + paramString.memberUin);
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          label321:
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB:" + paramString.toString());
          }
        }
      }
      if (this.app.a() == null) {
        break label569;
      }
    }
    finally {}
    this.app.a().g();
    for (;;)
    {
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "getDiscussionMemberFromDB, TotalTime:" + (l2 - l1) + ", listSize:" + this.jdField_a_of_type_JavaUtilList.size() + ", dbSize:" + i1);
      }
      localObject = this.jdField_a_of_type_Aecg.a();
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
    //   2: invokestatic 961	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 114	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 115	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 601	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: bipush 51
    //   21: invokevirtual 607	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 609	aloz
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 601	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 1911	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawbx;
    //   36: invokevirtual 1917	awbx:createEntityManager	()Lawbw;
    //   39: astore 7
    //   41: aload_2
    //   42: invokeinterface 1004 1 0
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 1009 1 0
    //   54: ifeq +85 -> 139
    //   57: aload 7
    //   59: ldc_w 617
    //   62: iconst_0
    //   63: ldc_w 2059
    //   66: iconst_2
    //   67: anewarray 349	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: invokeinterface 1012 1 0
    //   82: checkcast 349	java/lang/String
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 2062	awbw:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   93: astore 8
    //   95: aload 8
    //   97: ifnull -49 -> 48
    //   100: aload 8
    //   102: invokeinterface 411 1 0
    //   107: ifle -59 -> 48
    //   110: aload 5
    //   112: aload_0
    //   113: aload 8
    //   115: iconst_0
    //   116: invokeinterface 615 2 0
    //   121: checkcast 617	com/tencent/mobileqq/data/TroopMemberInfo
    //   124: aload 6
    //   126: invokevirtual 642	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Laloz;)Laece;
    //   129: invokeinterface 645 2 0
    //   134: pop
    //   135: goto -87 -> 48
    //   138: astore_1
    //   139: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +34 -> 176
    //   145: ldc_w 578
    //   148: iconst_2
    //   149: new 580	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 581	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 2064
    //   159: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 961	java/lang/System:currentTimeMillis	()J
    //   165: lload_3
    //   166: lsub
    //   167: invokevirtual 1982	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: iconst_1
    //   179: anewarray 341	java/lang/Object
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
    //   0	193	0	this	TroopMemberListActivity
    //   0	193	1	paramString	String
    //   0	193	2	paramList	List<String>
    //   5	161	3	l1	long
    //   13	172	5	localArrayList	ArrayList
    //   27	98	6	localaloz	aloz
    //   39	19	7	localawbw	awbw
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
  
  protected void b()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378404));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377903);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368659));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368605));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364066));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368613));
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368615));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368644));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368627));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131378400));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368212));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131375537);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369544));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369752));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131367729));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369773));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697953));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368628));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843434);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131720973));
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
          aece localaece = (aece)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localaece != null) && (localaece.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691925));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692680));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691929));
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131715948));
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840101);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aeby(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696952));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690648);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840101);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aebz(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696954));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690648);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aeca(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696783));
        if (this.jdField_h_of_type_JavaLangString == null) {
          this.jdField_h_of_type_JavaLangString = getString(2131690623);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840101);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697716);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        break;
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131721078);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692016);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692680));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691929));
        break;
      }
      if (this.jdField_d_of_type_Int == 18)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720974);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131715939));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aecb(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 23)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720974);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131716006));
      if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_h_of_type_JavaLangString == null) {
        this.jdField_h_of_type_JavaLangString = getString(2131690623);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692680);
      if (this.jdField_d_of_type_Int != 4)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840101);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697953));
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
      this.jdField_a_of_type_Aeci.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    bckx localbckx = (bckx)this.app.getManager(203);
    int i1 = 0;
    for (;;)
    {
      aece localaece;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label964;
        }
        localaece = (aece)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((this.jdField_r_of_type_Boolean) && (localbckx.b(localaece.jdField_a_of_type_JavaLangString))) {
          break label1142;
        }
        localaece.jdField_e_of_type_JavaLangString = "";
        localaece.jdField_f_of_type_JavaLangString = "";
        if ((paramString.equals(localaece.m)) || (paramString.equals(localaece.jdField_o_of_type_JavaLangString)) || (paramString.equals(localaece.jdField_n_of_type_JavaLangString)))
        {
          localaece.jdField_e_of_type_JavaLangString = localaece.m;
          localArrayList1.add(localaece);
          if (!QLog.isColorLevel()) {
            break label1142;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + localaece.jdField_a_of_type_JavaLangString + "," + localaece.jdField_e_of_type_JavaLangString);
        }
      }
      finally {}
      if ((paramString.equals(localaece.jdField_j_of_type_JavaLangString)) || (paramString.equals(localaece.l)) || (paramString.equals(localaece.jdField_k_of_type_JavaLangString)))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_j_of_type_JavaLangString;
        localArrayList1.add(localaece);
      }
      else if ((paramString.equals(localaece.jdField_g_of_type_JavaLangString)) || (paramString.equals(localaece.jdField_i_of_type_JavaLangString)) || (paramString.equals(localaece.jdField_h_of_type_JavaLangString)))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_g_of_type_JavaLangString;
        localArrayList1.add(localaece);
      }
      else if (paramString.equals(localaece.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localaece.jdField_e_of_type_JavaLangString = localaece.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localaece);
        }
      }
      else if ((localaece.m.indexOf(paramString) == 0) || (localaece.jdField_o_of_type_JavaLangString.indexOf(paramString) == 0) || (localaece.jdField_n_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.m;
        localaece.jdField_f_of_type_JavaLangString = localaece.jdField_n_of_type_JavaLangString;
        localArrayList2.add(localaece);
      }
      else if ((localaece.jdField_j_of_type_JavaLangString.indexOf(paramString) == 0) || (localaece.l.indexOf(paramString) == 0) || (localaece.jdField_k_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_j_of_type_JavaLangString;
        localaece.jdField_f_of_type_JavaLangString = localaece.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localaece);
      }
      else if ((localaece.jdField_g_of_type_JavaLangString.indexOf(paramString) == 0) || (localaece.jdField_i_of_type_JavaLangString.indexOf(paramString) == 0) || (localaece.jdField_h_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_g_of_type_JavaLangString;
        localaece.jdField_f_of_type_JavaLangString = localaece.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localaece);
      }
      else if (localaece.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localaece.jdField_e_of_type_JavaLangString = localaece.jdField_a_of_type_JavaLangString;
          localaece.jdField_f_of_type_JavaLangString = localaece.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localaece);
        }
      }
      else if ((localaece.m.indexOf(paramString) > 0) || (localaece.jdField_o_of_type_JavaLangString.indexOf(paramString) > 0) || (localaece.jdField_n_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.m;
        localArrayList3.add(localaece);
      }
      else if ((localaece.jdField_j_of_type_JavaLangString.indexOf(paramString) > 0) || (localaece.l.indexOf(paramString) > 0) || (localaece.jdField_k_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_j_of_type_JavaLangString;
        localArrayList3.add(localaece);
      }
      else if ((localaece.jdField_g_of_type_JavaLangString.indexOf(paramString) > 0) || (localaece.jdField_i_of_type_JavaLangString.indexOf(paramString) > 0) || (localaece.jdField_h_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_g_of_type_JavaLangString;
        localArrayList3.add(localaece);
      }
      else if ((localaece.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_e_of_type_Boolean))
      {
        localaece.jdField_e_of_type_JavaLangString = localaece.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localaece);
        continue;
        label964:
        Collections.sort(localArrayList2, new aecj(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Aeci.notifyDataSetChanged();
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
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aeaq(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aear(this));
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 22)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aeas(this));
      }
      while ((this.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption == 3)))
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
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aeat(this));
        }
        else if (this.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aeau(this));
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
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755801);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558428);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.jdField_d_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365231)).setText(getString(2131691906));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_Almt.b(Long.parseLong(this.jdField_a_of_type_JavaLangString), Long.valueOf(paramString).longValue());
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    Object localObject1 = (aloz)this.app.getManager(51);
    Object localObject2 = (TroopManager)this.app.getManager(52);
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
            ThreadManager.post(new TroopMemberListActivity.1(this, paramIntent, (aloz)localObject1, (TroopManager)localObject2), 8, null, true);
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
      localObject1 = bdbt.a(this.app, getApplicationContext(), paramIntent);
      localObject2 = aekt.a(new Intent(this, SplashActivity.class), null);
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
    ThreadManager.post(new TroopMemberListActivity.2(this, (aloz)localObject1), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_d_of_type_Int == 11) {
      azmj.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
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
    this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num_exceeds_wording", 2131698011);
    this.jdField_k_of_type_JavaLangString = ((Bundle)localObject).getString("param_pick_title_string", this.jdField_k_of_type_JavaLangString);
    this.jdField_r_of_type_Boolean = ((Bundle)localObject).getBoolean("param_filter_robot", false);
    if (this.jdField_d_of_type_Int == 17) {
      new azmo(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_b_of_type_JavaLangString }).a();
    }
    if (this.jdField_d_of_type_Int == 22) {
      bdaj.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
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
        setTheme(2131755151);
      }
      super.doOnCreate(paramBundle);
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.jdField_e_of_type_Boolean + ", mTroopUin = " + this.jdField_b_of_type_JavaLangString);
      }
      setContentView(2131562748);
      b();
      if (this.jdField_o_of_type_Int == 0)
      {
        paramBundle = ((TroopManager)this.app.getManager(52)).b(this.jdField_b_of_type_JavaLangString);
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
          ((alzf)this.app.a(20)).v(this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_m_of_type_Int == 5) {
          ((alzf)this.app.a(20)).w(this.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Almt = ((almt)this.app.a(6));
        this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        paramBundle = (TroopManager)this.app.getManager(52);
        localObject = (almv)this.app.getManager(53);
        if ((paramBundle != null) && (localObject != null)) {
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((almv)localObject).a(this.jdField_b_of_type_JavaLangString);
            this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            if ((this.jdField_d_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.getCurrentAccountUin()))) {
              break label1094;
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
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.b(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_b_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {}
        for (bool = true;; bool = false)
        {
          this.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getCurrentAccountUin());
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
            break label1066;
          }
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
          this.jdField_n_of_type_Boolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 32);
          break;
        }
        label1066:
        finish();
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    finish();
    return false;
    label1094:
    int i1;
    int i2;
    int i3;
    int i4;
    label1420:
    label1521:
    String str2;
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
    {
      addObserver(this.jdField_a_of_type_Almw);
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
        this.jdField_j_of_type_Int = getResources().getDimensionPixelSize(2131298983);
        this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131296657);
        if (this.jdField_k_of_type_Int == 0) {
          this.jdField_k_of_type_Int = ((int)(paramBundle.density * 58.0F));
        }
        this.jdField_i_of_type_Int = (i1 - i2 - i3 - i4);
        this.jdField_l_of_type_Int = ((this.jdField_i_of_type_Int - this.jdField_j_of_type_Int) / this.jdField_k_of_type_Int);
        this.jdField_a_of_type_Aljl = new aljl(this);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberListActivityget_troop_member", 2, String.format("init h: %s, ah: %s, indexH: %s, itemH: %s, count: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_i_of_type_Int), Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(this.jdField_k_of_type_Int), Integer.valueOf(this.jdField_l_of_type_Int) }));
        }
      }
      if (this.jdField_d_of_type_Int == 1) {
        break label1935;
      }
      if (this.jdField_d_of_type_Int != 11) {
        break label1741;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.jdField_e_of_type_JavaLangString == null) || (!this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
          break label1735;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
      }
      azmj.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_c_of_type_Boolean = true;
      }
      localObject = getResources().getStringArray(2130968681);
      paramBundle = getResources().getStringArray(2130968680);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop())) {
        break label2051;
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
        label1587:
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
        azmj.b(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_d_of_type_Int == 3) {
        ((alzf)this.app.a(20)).q(this.jdField_b_of_type_JavaLangString);
      }
      return true;
      this.app.addObserver(this.jdField_a_of_type_Amab, true);
      break;
      label1735:
      bool = false;
      break label1420;
      label1741:
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
          this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.app.getCurrentAccountUin()))) || ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(this.app.getCurrentAccountUin()))))
        {
          bool = true;
          label1852:
          this.jdField_a_of_type_Boolean = bool;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo admin: " + this.jdField_f_of_type_JavaLangString + "  owner:" + this.jdField_e_of_type_JavaLangString);
        break;
        bool = false;
        break label1852;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo==null");
        }
      }
      label1935:
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
      label2051:
      i3 = 0;
      i4 = 1;
      i2 = i4;
      i1 = i3;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.showGameSwitchStatus == 1)
      {
        i2 = i4;
        i1 = i3;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.gameSwitchStatus == 1)
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
      this.jdField_a_of_type_ArrayOfJavaLangString[i3] = getResources().getString(2131721105);
      if (i1 != 0) {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i3 + 1)] = getResources().getString(2131721104);
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
      this.jdField_b_of_type_ArrayOfJavaLangString[i2] = getResources().getString(2131721106);
      if (i1 == 0) {
        break label1521;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString[(i2 + 1)] = getResources().getString(2131721104);
      break label1521;
      paramBundle = "0";
      break label1587;
      paramBundle = "1";
      break label1587;
      paramBundle = "2";
      break label1587;
      paramBundle = "3";
      break label1587;
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
      if (this.jdField_a_of_type_Aljl != null)
      {
        this.jdField_a_of_type_Aljl.c();
        this.jdField_a_of_type_Aljl = null;
      }
      try
      {
        removeObserver(this.jdField_a_of_type_Almw);
        removeObserver(this.jdField_a_of_type_Amab);
        label48:
        if (this.jdField_a_of_type_Aeci != null) {
          this.jdField_a_of_type_Aeci.c();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_Aecg != null) {
          this.jdField_a_of_type_Aecg.c();
        }
        if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
          this.jdField_a_of_type_Bhpy.dismiss();
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
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368613));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Aecg != null) {
        this.jdField_a_of_type_Aecg.a();
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
      if (this.jdField_a_of_type_Aljl != null) {
        this.jdField_a_of_type_Aljl.a();
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
    View localView = getLayoutInflater().inflate(2131562757, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376168));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362536));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView;
    int i1;
    label124:
    int i2;
    label142:
    Object localObject;
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839216);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378839);
      this.jdField_g_of_type_Int = ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).leftMargin;
      if ((this.jdField_d_of_type_Int != 3) || (!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 1)) {
        break label845;
      }
      i1 = 1;
      if ((this.jdField_d_of_type_Int != 11) || (!this.jdField_a_of_type_Boolean)) {
        break label850;
      }
      i2 = 1;
      if ((i1 != 0) || (i2 != 0))
      {
        localObject = getString(2131721065);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375580);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368782)).setBackgroundDrawable(bdda.d());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372536);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new aeav(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aeaw(this, (String)localObject));
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (alzf)this.app.a(20);
        if (bdee.d(BaseApplication.getContext())) {
          break label855;
        }
        QQToast.a(this, 1, 2131694764, 0).b(getTitleBarHeight());
      }
      if ((this.jdField_d_of_type_Int != 3) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 1)) {
        break label954;
      }
      i1 = 1;
      label365:
      if ((this.jdField_d_of_type_Int != 11) || (this.jdField_a_of_type_Boolean)) {
        break label959;
      }
      i2 = 1;
      label383:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && ((i1 != 0) || (i2 != 0)))
      {
        localObject = (alzf)this.app.a(20);
        if (bdee.d(BaseApplication.getContext())) {
          break label964;
        }
        QQToast.a(this, 1, 2131694764, 0).b(getTitleBarHeight());
      }
      label441:
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365849);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363520)).setVisibility(8);
      if (this.jdField_d_of_type_Int != 19) {
        break label1025;
      }
      localView = getLayoutInflater().inflate(2131562749, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new aeax(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aecg = new aecg(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Aecg);
      if ((this.jdField_d_of_type_Int == 19) || (this.jdField_d_of_type_Int == 21)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 19)) {
        t();
      }
      ((EditText)localObject).setOnTouchListener(new aeay(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_d_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839213);
      break;
      label845:
      i1 = 0;
      break label124;
      label850:
      i2 = 0;
      break label142;
      label855:
      if ((this.jdField_a_of_type_Almt != null) && (this.jdField_d_of_type_Int == 11)) {
        this.jdField_a_of_type_Almt.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839228);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject != null) {
          ((alzf)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        }
      }
      label954:
      i1 = 0;
      break label365;
      label959:
      i2 = 0;
      break label383;
      label964:
      if ((this.jdField_a_of_type_Almt != null) && (this.jdField_d_of_type_Int == 11))
      {
        this.jdField_a_of_type_Almt.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
        break label441;
      }
      if (localObject == null) {
        break label441;
      }
      ((alzf)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
      break label441;
      label1025:
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  protected void e(String paramString)
  {
    if (((bckx)this.app.getManager(203)).a(this, this.jdField_b_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131721064));
    if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131690623));
    }
    awnk.a(this.app, this, this.jdField_b_of_type_JavaLangString, paramString, 1, 1, localBundle);
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
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 16) && (bdee.g(this)))
        {
          localObject2 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4);
          l1 = ((SharedPreferences)localObject2).getLong("key_last_update_time" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(System.currentTimeMillis() - l1);
          int i1 = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            i1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum;
          }
          int i2 = ((SharedPreferences)localObject2).getInt("key_last_update_num" + this.jdField_b_of_type_JavaLangString, 0);
          ((SharedPreferences)localObject2).edit().putInt("key_last_update_num" + this.jdField_b_of_type_JavaLangString, i1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L + " min  curMemberNum:" + i1 + " lastUpdateMemberNum:" + i2);
          }
          localObject2 = (alzf)this.app.a(20);
          if (localObject2 != null)
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            ((alzf)localObject2).a(true, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, a(), this.jdField_a_of_type_Long, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_a_of_type_JavaLangString + " troopCode: " + this.jdField_b_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((alzf)localObject2).a(Long.parseLong(this.jdField_b_of_type_JavaLangString), 0L, 1, 0, 0);
        if (this.jdField_d_of_type_Int == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_troop_info_last_update" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (alzf)this.app.a(20);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              ((alzf)localObject2).j(this.jdField_b_of_type_JavaLangString);
              ((alzf)localObject2).a(1, alkk.a(this.jdField_b_of_type_JavaLangString), 0L, 2, 0, 0, true);
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
        ((bcju)this.app.getManager(113)).a(this.jdField_b_of_type_JavaLangString, new aebe(this));
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
      arrayOfString = getResources().getStringArray(2130968675);
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
        break label165;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
      i1 = arrayOfString.length;
      this.jdField_a_of_type_Bhpy = bhpy.a(this);
      i2 = 0;
      label65:
      if (i2 >= i1) {
        break label203;
      }
      if (!this.jdField_e_of_type_Boolean) {
        break label267;
      }
      if (!alpo.a(2131715974).equals(arrayOfString[i2])) {
        break label188;
      }
    }
    label267:
    for (;;)
    {
      i2 += 1;
      break label65;
      arrayOfString = getResources().getStringArray(2130968673);
      break;
      label113:
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
        this.jdField_a_of_type_Bhpy.c(arrayOfString[i2]);
        label203:
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
          this.jdField_a_of_type_Bhpy.a(arrayOfString[3], 3);
        }
        this.jdField_a_of_type_Bhpy.c(2131690648);
        this.jdField_a_of_type_Bhpy.a(this.jdField_a_of_type_Bhqd);
        this.jdField_a_of_type_Bhpy.show();
        return;
        if (i2 == 3)
        {
          this.jdField_a_of_type_Bhpy.a(arrayOfString[i2], 3);
        }
        else
        {
          this.jdField_a_of_type_Bhpy.c(arrayOfString[i2]);
          if (arrayOfString[i2].equals(alpo.a(2131715934))) {
            azmj.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Aecg != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aecg.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Aecg.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Aecg.jdField_a_of_type_Int) }));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.jdField_m_of_type_Int == 0) {
      if (this.jdField_d_of_type_Int == 11) {
        if ((this.jdField_a_of_type_Aecg != null) && (this.jdField_a_of_type_Aecg.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_Aecg.jdField_a_of_type_Int > 1)) {
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
        if ((this.jdField_a_of_type_Aecg != null) && (this.jdField_a_of_type_Aecg.jdField_b_of_type_Int + this.jdField_a_of_type_Aecg.jdField_c_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Aecg.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else if ((this.jdField_a_of_type_Aecg != null) && (this.jdField_a_of_type_Aecg.jdField_b_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Aecg.jdField_a_of_type_Int > 1))
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558428);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_d_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365231)).setText(getString(2131719773));
      return;
      label76:
      bool = false;
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Int == 11) {
      azmj.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new aebj(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new aebk(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363520);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new aebl(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aeci.notifyDataSetChanged();
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
    String str = "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_b_of_type_JavaLangString;
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
      ViewStub localViewStub = (ViewStub)findViewById(2131378442);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131378443)).setOnTouchListener(new aebx(this));
      }
    }
  }
  
  public void o()
  {
    if (!isResume()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Aecg != null) {}
      try
      {
        this.jdField_a_of_type_Aecg.notifyDataSetChanged();
        if (this.jdField_a_of_type_Aeci == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_Aeci.notifyDataSetChanged();
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
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */