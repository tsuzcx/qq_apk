package com.tencent.mobileqq.activity;

import abyx;
import abyy;
import abyz;
import abza;
import abzb;
import abzc;
import abzd;
import abze;
import abzf;
import abzg;
import abzi;
import abzj;
import abzk;
import abzl;
import abzm;
import abzn;
import abzp;
import abzq;
import abzr;
import abzs;
import abzt;
import abzu;
import abzv;
import abzw;
import abzx;
import abzy;
import abzz;
import acaa;
import acab;
import acac;
import acad;
import acae;
import acaf;
import acag;
import acah;
import acai;
import acaj;
import acak;
import acam;
import acao;
import acaq;
import acar;
import acas;
import acat;
import aciy;
import ajdy;
import ajex;
import ajhf;
import ajhh;
import ajhi;
import ajjj;
import ajjy;
import ajrm;
import ajtg;
import ajuc;
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
import atxx;
import awqx;
import awrb;
import axjq;
import ayqn;
import ayqo;
import azcd;
import azgh;
import azjq;
import azks;
import azzx;
import azzz;
import babh;
import bacm;
import badq;
import bajr;
import bami;
import bbjs;
import bbjt;
import bbmy;
import begr;
import begw;
import behi;
import bemi;
import beml;
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
import com.tencent.mobileqq.widget.IndexView;
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
import mmj;
import mmn;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;
import vms;

public class TroopMemberListActivity
  extends BaseActivity
  implements bbjs, bbjt, behi
{
  public static double b;
  private static int jdField_p_of_type_Int = 1000;
  public double a;
  public float a;
  public int a;
  public long a;
  public acao a;
  public acaq a;
  public ajdy a;
  protected ajhf a;
  public ajhi a;
  public ajuc a;
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
  public begr a;
  protected begw a;
  public bemi a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public TroopInfoData a;
  public IndexView a;
  public PinnedDividerSwipListView a;
  public XListView a;
  public String a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  public ArrayList<String> a;
  public List<acam> a;
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
  public List<acam> b;
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
  private String w = ajjy.a(2131649764);
  
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acak(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new abyx(this);
    this.jdField_m_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_Begw = new abzn(this);
    this.jdField_a_of_type_AndroidOsHandler = new abzu(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new abzv(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new abzw(this);
    this.jdField_a_of_type_Ajhi = new abzz(this);
    this.jdField_a_of_type_Ajuc = new acab(this);
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
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bemi.getContentView().findViewById(2131299132);
    int i1 = 0;
    if (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      beml localbeml = (beml)((View)localObject).getTag();
      if (localbeml != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131311386);
        if (localObject != null)
        {
          if (localbeml.jdField_a_of_type_Int != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131101271));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131101260));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(ajjy.a(2131649834), new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(ajjy.a(2131649770), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
      this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_Acao.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_Acao.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        q();
        h();
        if (this.jdField_a_of_type_Acao == null) {
          break label302;
        }
        this.jdField_a_of_type_Acao.notifyDataSetChanged();
        this.jdField_a_of_type_Acao.a();
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
      this.jdField_a_of_type_Acao = new acao(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Acao);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, mmn parammmn)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    mmj.b(paramQQAppInterface, parammmn, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void a(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    Dialog localDialog = new Dialog(this, 2131690181);
    localDialog.setContentView(2131493474);
    ((TextView)localDialog.findViewById(2131299583)).setText(getString(2131625958));
    TextView localTextView = (TextView)localDialog.findViewById(2131299579);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131298623);
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
      localTextView.setText(getString(2131628068));
      localCheckBox.setText(getString(2131652853));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localTextView = (TextView)localDialog.findViewById(2131299568);
      localObject = (TextView)localDialog.findViewById(2131299574);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new abzx(this, localDialog));
      ((TextView)localObject).setOnClickListener(new abzy(this, paramList, localCheckBox, bool, localDialog));
      localDialog.show();
      return;
      bool = false;
      break;
      label291:
      localTextView.setText(getString(2131628799));
      localCheckBox.setText(getString(2131628801));
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
    ajjj localajjj = (ajjj)this.app.getManager(51);
    azks localazks = (azks)this.app.getManager(203);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!azzz.d(localTroopMemberInfo.memberuin)) {
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
        if (((this.jdField_f_of_type_JavaUtilList == null) || (!this.jdField_f_of_type_JavaUtilList.contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localazks.b(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localajjj));
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
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131312436);
        localObject1 = getString(2131654618);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131309352);
        ((TextView)localObject2).setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131302951)).setBackgroundDrawable(bacm.d());
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131306484);
        ((ImageView)localObject3).setVisibility(8);
        if (i1 != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new acac(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acad(this, (String)localObject1));
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
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131309352)).setCompoundDrawables(null, null, null, null);
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
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131312436)).setTextColor(getResources().getColor(2131101260));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131309352);
      localObject2 = ajjy.a(2131649783);
      localObject3 = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305365);
      ((Button)localObject3).setVisibility(8);
      ((Button)localObject3).setOnClickListener(new acae(this));
      i1 = ((ajrm)this.app.a(13)).g();
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
      this.jdField_g_of_type_JavaLangString = (ajjy.a(2131649787) + paramInt1 + ajjy.a(2131649790));
      ((TextView)localObject1).setText(this.jdField_g_of_type_JavaLangString);
      paramString1 = (String)localObject2 + "," + this.jdField_g_of_type_JavaLangString;
      label615:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        paramString2.rightMargin = aciy.a(20.0F, getResources());
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
        this.jdField_g_of_type_JavaLangString = ajjy.a(2131649849);
        paramString1 = (String)localObject2 + ",剩余0次";
        ((TextView)localObject1).setText("剩余0次");
        break label615;
      }
      this.jdField_g_of_type_JavaLangString = "";
      paramString1 = (String)localObject2 + "," + ajjy.a(2131649848);
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
          paramInt1 = (int)(ajjy.a(2131649845).length() * 12 * this.jdField_a_of_type_Float);
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
      if (paramString1.contains(ajjy.a(2131649855)))
      {
        paramInt1 = paramString1.indexOf(ajjy.a(2131649856));
        paramInt2 = ajjy.a(2131649773).length();
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
        } while (!((azks)paramQQAppInterface.getManager(203)).b(paramString));
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
    if (this.jdField_a_of_type_Bemi == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        beml localbeml = new beml();
        localbeml.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localbeml.jdField_a_of_type_Int = i1;
        localbeml.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localArrayList.add(localbeml);
        i1 += 1;
      }
      this.jdField_a_of_type_Bemi = bemi.a(this, localArrayList, new abzq(this), null, vms.a(this, 135.0F), false);
      this.jdField_a_of_type_Bemi.setTouchInterceptor(new acaa(this));
      a(this.jdField_m_of_type_Int);
    }
    this.jdField_a_of_type_Bemi.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(vms.a(this, 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
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
    this.jdField_e_of_type_AndroidViewView = getLayoutInflater().inflate(2131496950, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302441);
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
      localObject = (acam)localIterator.next();
      if (((acam)localObject).jdField_b_of_type_Long == 0L) {
        ((acam)localObject).jdField_b_of_type_Long = ((acam)localObject).jdField_a_of_type_Long;
      }
      if (TextUtils.isEmpty(a(((acam)localObject).jdField_b_of_type_Long, localCalendar, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
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
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new abzi(this, i1, i2));
        s();
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
        awqx.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.jdField_b_of_type_JavaLangString, "" + i2, "", "");
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
      localObject = this.jdField_e_of_type_AndroidViewView.findViewById(2131309511);
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
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131496769);
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
      int i1 = getResources().getColor(2131101315);
      new SystemBarCompact(this.jdField_b_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131309736);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131309910));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838503));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Acaq = new acaq(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acaq);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new abzj(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131300167));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acas(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131309736);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302060));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131305203);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131309439));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new abzk(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new abzl(this));
  }
  
  private void u()
  {
    int i1 = this.jdField_a_of_type_Acao.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format(ajjy.a(2131649836), new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abzp(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649862));
  }
  
  private void v()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(0, this.jdField_o_of_type_Int, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  public acam a(DiscussionMemberInfo paramDiscussionMemberInfo, ajjj paramajjj)
  {
    acam localacam = new acam();
    localacam.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramajjj != null) {
      localFriends = paramajjj.b(paramDiscussionMemberInfo.memberUin);
    }
    localacam.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localacam.jdField_a_of_type_Short = 0;
    localacam.jdField_c_of_type_JavaLangString = ChnToSpell.a(localacam.jdField_b_of_type_JavaLangString, 2);
    localacam.a(ChnToSpell.a(localacam.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localacam.e(localFriends.remark);
      localacam.h(ChnToSpell.a(localacam.jdField_j_of_type_JavaLangString, 1));
      localacam.f(ChnToSpell.a(localacam.jdField_j_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localacam.i(paramDiscussionMemberInfo.memberName);
        localacam.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localacam.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      if (this.jdField_a_of_type_Ajdy != null) {
        this.jdField_a_of_type_Ajdy.a(localacam);
      }
      return localacam;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localacam.e(paramDiscussionMemberInfo.inteRemark);
        localacam.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localacam.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public acam a(TroopMemberInfo paramTroopMemberInfo, ajjj paramajjj)
  {
    acam localacam = new acam();
    localacam.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramajjj != null) {
      localFriends = paramajjj.b(paramTroopMemberInfo.memberuin);
    }
    localacam.jdField_b_of_type_JavaLangString = babh.c(this.app, this.jdField_b_of_type_JavaLangString, localacam.jdField_a_of_type_JavaLangString, true);
    localacam.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localacam.jdField_c_of_type_JavaLangString = ChnToSpell.a(localacam.jdField_b_of_type_JavaLangString, 2);
    localacam.a(ChnToSpell.a(localacam.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localacam.b(paramTroopMemberInfo.friendnick);
      localacam.d(paramTroopMemberInfo.pyAll_friendnick);
      localacam.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localacam.e(localFriends.remark);
      localacam.h(ChnToSpell.a(localacam.jdField_j_of_type_JavaLangString, 1));
      localacam.f(ChnToSpell.a(localacam.jdField_j_of_type_JavaLangString, 2));
      localacam.g(localFriends.remark);
      if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
      {
        localacam.i(paramTroopMemberInfo.troopColorNick);
        localacam.k(paramTroopMemberInfo.pyAll_troopnick);
        localacam.j(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localacam.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localacam.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localacam.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localacam.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
      localacam.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localacam.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localacam.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localacam.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      localacam.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.app.getManager(52)).a(this.jdField_b_of_type_JavaLangString, localacam.jdField_a_of_type_JavaLangString);
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
      localacam.t = ((int)d1 + "km");
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localacam.u = paramTroopMemberInfo.mUniqueTitle;
        localacam.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if (this.jdField_a_of_type_Ajdy != null) {
        this.jdField_a_of_type_Ajdy.a(localacam);
      }
      localacam.jdField_e_of_type_Int = paramTroopMemberInfo.mVipType;
      localacam.jdField_f_of_type_Int = paramTroopMemberInfo.mVipLevel;
      localacam.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localacam.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
      localacam.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
      localacam.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localacam.v = paramTroopMemberInfo.honorList;
      return localacam;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.jdField_e_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localacam.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localacam.h(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localacam.f(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
        break;
      }
      localacam.e(paramTroopMemberInfo.autoremark);
      localacam.h(paramTroopMemberInfo.pyAll_autoremark);
      localacam.f(paramTroopMemberInfo.pyFirst_autoremark);
      break;
      label669:
      localacam.t = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
      continue;
      label704:
      localacam.t = "";
    }
  }
  
  public acam a(String paramString)
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
          acam localacam = (acam)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localacam != null) && (localacam.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (acam)this.jdField_a_of_type_JavaUtilList.remove(i1);
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
  
  public acat a(String paramString, boolean paramBoolean)
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
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof acat)))
      {
        localObject2 = (acat)((View)localObject2).getTag();
        if ((((acat)localObject2).jdField_a_of_type_JavaLangString != null) && (((acat)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
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
  
  public List<acam> a(List<acam> paramList, String paramString1, String paramString2)
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
        acam localacam = (acam)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localacam.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localacam);
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
        paramString1 = (acam)paramList.get(i3);
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
        paramString1 = (acam)paramList.get(i4);
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
          paramString1 = (acam)paramList.get(i2);
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
            paramString1 = (acam)paramList.get(i2);
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
              paramString1 = (acam)paramList.get(i2);
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
    Object localObject = (ViewGroup)findViewById(2131309578);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131311553);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131302804);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void a(acam paramacam)
  {
    int i1 = 3;
    if ((paramacam != null) && (paramacam.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.clear();
      paramacam = new Intent();
      paramacam.putExtra("result", new JSONArray().toString());
      setResult(-1, paramacam);
      awqx.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
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
          } while ((paramacam == null) || (paramacam.jdField_a_of_type_JavaLangString == null));
          if (this.jdField_d_of_type_Int == 1)
          {
            if (this.app.getCurrentAccountUin().equals(paramacam.jdField_a_of_type_JavaLangString))
            {
              localObject1 = new ProfileActivity.AllInOne(paramacam.jdField_a_of_type_JavaLangString, 0);
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = babh.h(this.app, paramacam.jdField_a_of_type_JavaLangString);
              ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 3;
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 4;
              ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
              return;
            }
            a(paramacam.jdField_a_of_type_JavaLangString, paramacam.jdField_b_of_type_JavaLangString);
            return;
          }
          if (this.jdField_d_of_type_Int == 2)
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_uin", paramacam.jdField_a_of_type_JavaLangString);
            localObject2 = new TroopMemberListActivity.TroopAdmin();
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramacam.jdField_a_of_type_JavaLangString;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramacam.jdField_a_of_type_Short;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramacam.jdField_b_of_type_JavaLangString;
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
              ((Intent)localObject1).putExtra("member_display_name", paramacam.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("isApollo", true);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("member_uin", paramacam.jdField_a_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
              setResult(-1, (Intent)localObject1);
              finish();
              return;
              ((Intent)localObject1).putExtra("member_display_name", paramacam.jdField_b_of_type_JavaLangString);
            }
          }
          if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 4) && (this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
            break;
          }
          e(paramacam.jdField_a_of_type_JavaLangString);
        } while (this.jdField_d_of_type_Int != 22);
        azzx.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
        return;
        if (this.jdField_d_of_type_Int == 5)
        {
          if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramacam.jdField_a_of_type_JavaLangString)))
          {
            startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.jdField_b_of_type_JavaLangString, paramacam.jdField_a_of_type_JavaLangString, i1, paramacam.u), 2);
            this.v = paramacam.jdField_a_of_type_JavaLangString;
            localObject1 = this.app;
            localObject2 = this.jdField_b_of_type_JavaLangString;
            i1 = this.jdField_m_of_type_Int;
            if (!this.jdField_m_of_type_Boolean) {
              break label633;
            }
          }
          for (paramacam = "1";; paramacam = "0")
          {
            awqx.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramacam, "");
            return;
            if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(paramacam.jdField_a_of_type_JavaLangString)))
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
          ((Intent)localObject1).putExtra("member_uin", paramacam.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_display_name", paramacam.jdField_b_of_type_JavaLangString);
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
            this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.add(paramacam);
            paramacam = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList != null)
            {
              localObject2 = this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  acam localacam = (acam)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localacam.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localacam.jdField_b_of_type_JavaLangString);
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
            paramacam.putExtra("result", ((JSONArray)localObject1).toString());
            setResult(-1, paramacam);
            finish();
            return;
          }
          if (this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.contains(paramacam)) {
            this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.remove(paramacam);
          }
          for (;;)
          {
            this.jdField_a_of_type_Acao.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.size() < this.jdField_f_of_type_Int)
            {
              this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.add(paramacam);
            }
            else if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.add(paramacam);
            }
            else
            {
              bbmy.a(this, getResources().getString(this.jdField_h_of_type_Int, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).a();
            }
          }
        }
        if ((this.jdField_d_of_type_Int != 18) && (this.jdField_d_of_type_Int != 19)) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_uin", paramacam.jdField_a_of_type_JavaLangString);
        PublicFragmentActivity.a(this, (Intent)localObject1, TroopMemberHistoryFragment.class);
      } while (this.jdField_d_of_type_Int != 19);
      paramacam = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
      azzx.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, azzx.a(paramacam) });
      return;
    } while (this.jdField_d_of_type_Int != 23);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_member_name", paramacam.jdField_g_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramacam.jdField_a_of_type_JavaLangString));
    ((Intent)localObject1).putExtra("folderPath", "/");
    ((Intent)localObject1).putExtra("param_from", 6000);
    TroopFileProxyActivity.a(this, (Intent)localObject1, this.app.getCurrentAccountUin());
  }
  
  public void a(acat paramacat, acam paramacam, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    label84:
    Object localObject;
    label153:
    label364:
    int i2;
    if (paramBoolean1)
    {
      str = this.u;
      paramacat.jdField_a_of_type_Boolean = paramBoolean1;
      paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramacat.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramacat.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramacat.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if ((this.jdField_m_of_type_Int != 1) && (this.jdField_m_of_type_Int != 5)) {
        break label867;
      }
      if (paramacam.jdField_d_of_type_Boolean) {
        break label854;
      }
      paramacat.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      if ((this.jdField_b_of_type_Boolean) || (a()) || (paramacam.jdField_d_of_type_Int == -100) || (paramacam.jdField_d_of_type_Int == 0)) {
        break label889;
      }
      paramacat.j.setVisibility(8);
      paramacat.j.setText("LV" + paramacam.jdField_d_of_type_Int);
      bajr.a(this.app, this, getResources(), paramacat, paramacam);
      if ((this.jdField_d_of_type_Int != 13) || (!paramBoolean1)) {
        break label901;
      }
      paramBitmap = paramacam.jdField_b_of_type_JavaLangString + "(" + paramacam.jdField_a_of_type_JavaLangString + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramacam.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramacat.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label265:
      if ((paramBoolean2) && (paramacat.k != null))
      {
        paramBitmap = ajjy.a(2131649756) + paramacam.jdField_j_of_type_JavaLangString;
        paramacat.k.setText(paramBitmap);
      }
      paramacat.jdField_a_of_type_JavaLangString = paramacam.jdField_a_of_type_JavaLangString;
      paramacat.jdField_c_of_type_Int = 1;
      paramacat.f.setText("");
      paramacat.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
      if (this.jdField_d_of_type_Int != 9) {
        break label986;
      }
      paramacat.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramacat.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramacat.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label1001;
      }
      paramacat.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramacat.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_d_of_type_Boolean) {
        paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
      label445:
      i2 = 0;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13)) {
        break label1131;
      }
      paramacat.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131626292) + paramacat.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramacat.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130848381);
      if (this.jdField_d_of_type_Int != 13) {
        break label1048;
      }
      paramacat.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label534:
      if (!str.equals(paramacam.jdField_a_of_type_JavaLangString)) {
        break label1120;
      }
      paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    int i1;
    for (;;)
    {
      paramacat.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131626270), new Object[] { paramacat.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramacat.g.setContentDescription(getString(2131626269));
      i1 = i2;
      if (paramacat.jdField_d_of_type_AndroidViewView != null)
      {
        paramBitmap = (azks)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramacam.jdField_a_of_type_JavaLangString))) {
          break label2406;
        }
        i2 = 1;
        label647:
        if (i2 == 0) {
          break label2412;
        }
        paramacat.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      label660:
      if (this.jdField_e_of_type_Boolean) {
        paramacat.j.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramacat.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      if ((paramBoolean2) && (paramacat.k != null)) {
        paramBitmap.append(paramacat.k.getText());
      }
      if (paramacat.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        paramBitmap.append(paramacat.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      }
      if (paramacat.j.getVisibility() == 0) {
        paramBitmap.append(paramacat.j.getText().toString());
      }
      if (paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.getVisibility() == 0) {
        paramBitmap.append(paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.a());
      }
      if ((paramacat.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_Boolean))
      {
        if (i1 == 0) {
          break label2424;
        }
        paramacam = "已选中";
        label827:
        paramBitmap.append(paramacam);
      }
      paramacat.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
      return;
      str = this.t;
      break;
      label854:
      paramacat.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      break label84;
      label867:
      paramacat.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramacat.j.setVisibility(8);
      break label84;
      label889:
      paramacat.j.setVisibility(8);
      break label153;
      label901:
      if (paramBoolean2)
      {
        paramBitmap = new axjq(paramacam.jdField_g_of_type_JavaLangString, 16).a();
        paramacat.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
        bami.a(this.app, paramacat.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
        break label265;
      }
      paramBitmap = new axjq(paramacam.jdField_b_of_type_JavaLangString, 16).a();
      paramacat.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      bami.a(this.app, paramacat.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
      break label265;
      label986:
      paramacat.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
      break label364;
      label1001:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramacat.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramacat.jdField_a_of_type_AndroidViewView.setClickable(false);
        break label445;
      }
      paramacat.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramacat.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label445;
      label1048:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramacat.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      if ((this.jdField_e_of_type_JavaLangString != null) && (!paramacam.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString)))
      {
        paramacat.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      paramacat.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label534;
      label1120:
      paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label1131:
    paramacat.jdField_c_of_type_AndroidWidgetTextView.setText("");
    label1153:
    boolean bool1;
    label1177:
    boolean bool2;
    label1208:
    boolean bool4;
    boolean bool5;
    int i3;
    if (!TextUtils.isEmpty(paramacam.u))
    {
      paramBoolean1 = true;
      if ((paramacam.jdField_a_of_type_JavaLangString == null) || (!paramacam.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString))) {
        break label1452;
      }
      bool1 = true;
      if ((this.jdField_f_of_type_JavaLangString == null) || (paramacam.jdField_a_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.contains(paramacam.jdField_a_of_type_JavaLangString))) {
        break label1458;
      }
      bool2 = true;
      bool4 = this.app.getCurrentAccountUin().equals(this.jdField_e_of_type_JavaLangString);
      bool5 = this.app.getCurrentAccountUin().equals(paramacam.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int != 5) {
        break label1583;
      }
      paramacat.h.setVisibility(0);
      paramacat.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
      paramacat.i.setVisibility(0);
      localObject = "";
      i3 = 0;
      if (!paramBoolean1) {
        break label1464;
      }
      paramBitmap = ayqn.a().a(302, paramBoolean1, bool1, bool2);
      if (paramBitmap == null) {
        break label2446;
      }
      i1 = paramBitmap.jdField_b_of_type_Int;
      paramBitmap = paramacam.u;
    }
    for (;;)
    {
      label1325:
      if (!TextUtils.isEmpty(paramBitmap))
      {
        paramacat.h.setText(paramBitmap);
        ayqn.a(paramacat.h, i1);
      }
      for (;;)
      {
        label1349:
        paramBitmap = (azks)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramacam.jdField_a_of_type_JavaLangString))) {
          break label2121;
        }
        i1 = 1;
        label1381:
        if (!this.jdField_c_of_type_Boolean) {
          break label2187;
        }
        if ((this.jdField_d_of_type_Int == 21) || ((!bool1) && ((bool4) || (!bool2)) && ((bool4) || (i1 == 0)))) {
          break label2127;
        }
        paramacat.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i2;
        break;
        paramBoolean1 = false;
        break label1153;
        label1452:
        bool1 = false;
        break label1177;
        label1458:
        bool2 = false;
        break label1208;
        label1464:
        if (bool1)
        {
          localayqo = ayqn.a().a(300, paramBoolean1, bool1, bool2);
          i1 = i3;
          paramBitmap = (Bitmap)localObject;
          if (localayqo == null) {
            break label1325;
          }
          i1 = localayqo.jdField_b_of_type_Int;
          paramBitmap = localayqo.jdField_a_of_type_JavaLangString;
          break label1325;
        }
        i1 = i3;
        paramBitmap = (Bitmap)localObject;
        if (!bool2) {
          break label1325;
        }
        ayqo localayqo = ayqn.a().a(301, paramBoolean1, bool1, bool2);
        i1 = i3;
        paramBitmap = (Bitmap)localObject;
        if (localayqo == null) {
          break label1325;
        }
        i1 = localayqo.jdField_b_of_type_Int;
        paramBitmap = localayqo.jdField_a_of_type_JavaLangString;
        break label1325;
        paramacat.h.setVisibility(8);
      }
      label1583:
      i1 = 0;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop();
      }
      if ((bool3) || (this.jdField_b_of_type_Boolean))
      {
        localObject = ayqn.a().a(bool1, bool2);
        if (localObject == null) {
          break label2437;
        }
        paramBitmap = ((ayqo)localObject).jdField_a_of_type_JavaLangString;
        i1 = ((ayqo)localObject).jdField_b_of_type_Int;
      }
      for (;;)
      {
        label1647:
        if (this.jdField_d_of_type_Int == 11) {
          paramBitmap = "";
        }
        if ((!TextUtils.isEmpty(paramBitmap)) && (!a()))
        {
          paramacat.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramacat.jdField_c_of_type_AndroidWidgetTextView.setText(paramBitmap);
          ayqn.a(paramacat.jdField_c_of_type_AndroidWidgetTextView, i1);
          label1698:
          paramBitmap = (azcd)this.app.getManager(346);
          if (!paramBitmap.a(this.jdField_b_of_type_JavaLangString, false)) {
            break label2065;
          }
          paramBitmap = paramBitmap.a(paramacam.v);
          if ((paramBitmap == null) || (paramBitmap.size() <= 0)) {
            break label2045;
          }
          paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(paramBitmap);
          paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(0);
          label1762:
          if (this.jdField_b_of_type_Boolean)
          {
            paramBitmap = ayqn.a().a(paramacam.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap == null) || (!azgh.a(paramacam.jdField_a_of_type_Int))) {
              break label2097;
            }
            if (TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) {
              break label2085;
            }
            paramacat.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramacat.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
            ayqn.a(paramacat.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
          }
        }
        for (;;)
        {
          if ((this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 12)) {
            break label2107;
          }
          if ((paramacam.jdField_a_of_type_JavaLangString == null) || (!paramacam.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
            break label2109;
          }
          paramacat.f.setText(getString(2131628854));
          break;
          localObject = ayqn.a().a(paramacam.jdField_a_of_type_Int, paramBoolean1, bool1, bool2);
          if (localObject != null)
          {
            paramBitmap = ((ayqo)localObject).jdField_a_of_type_JavaLangString;
            i3 = ((ayqo)localObject).jdField_b_of_type_Int;
            if (((ayqo)localObject).jdField_a_of_type_Int == 302) {
              paramBitmap = paramacam.u;
            }
            i1 = i3;
            if (((ayqo)localObject).jdField_a_of_type_Int != 315) {
              break label1647;
            }
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramacam.jdField_c_of_type_Int));
            i1 = i3;
            break label1647;
          }
          if (paramacam.jdField_a_of_type_Int != 315) {
            break label2431;
          }
          paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramacam.jdField_c_of_type_Int));
          i1 = Color.parseColor("#8EBDF9");
          break label1647;
          paramacat.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1698;
          label2045:
          paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label1762;
          label2065:
          paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramacat.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label1762;
          label2085:
          paramacat.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label2097:
          paramacat.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        label2107:
        break label1349;
        label2109:
        paramacat.f.setText("");
        break label1349;
        label2121:
        i1 = 0;
        break label1381;
        label2127:
        paramacat.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramacat.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130848381);
        if (str.equals(paramacam.jdField_a_of_type_JavaLangString))
        {
          paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
          i1 = i2;
          break;
        }
        paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i2;
        break;
        label2187:
        if (this.jdField_d_of_type_Boolean)
        {
          if ((bool1) || ((!bool4) && (bool2)) || (bool5))
          {
            i1 = 1;
            label2217:
            if (i1 == 0) {
              break label2243;
            }
            paramacat.jdField_b_of_type_AndroidViewView.setVisibility(8);
            i1 = 0;
          }
          for (;;)
          {
            break;
            i1 = 0;
            break label2217;
            label2243:
            paramacat.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramacam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Acao.jdField_b_of_type_JavaUtilList.contains(paramacam.jdField_a_of_type_JavaLangString)))
            {
              paramacat.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840158);
              i1 = 1;
            }
            else
            {
              paramacat.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840154);
              i1 = 0;
            }
          }
        }
        if (this.jdField_d_of_type_Int == 20)
        {
          paramacat.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramacam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Acao.jdField_a_of_type_JavaUtilList.contains(paramacam)))
          {
            paramacat.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840158);
            i1 = 1;
            break;
          }
          paramacat.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840154);
          i1 = i2;
          break;
        }
        paramacat.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramacat.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i2;
        break;
        label2406:
        i2 = 0;
        break label647;
        label2412:
        paramacat.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label660;
        label2424:
        paramacam = "未选中";
        break label827;
        label2431:
        paramBitmap = "";
        continue;
        label2437:
        i1 = 0;
        paramBitmap = "";
      }
      label2446:
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
      i1 = this.jdField_a_of_type_Acao.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i1 + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        awqx.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_d_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    awqx.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (ajjj)this.app.getManager(51);
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
      awqx.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString2, paramString3, "");
    }
    awqx.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString3, "", "");
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
    //   43: ldc_w 1897
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
    //   74: invokeinterface 1899 1 0
    //   79: ifeq +528 -> 607
    //   82: new 114	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 115	java/util/ArrayList:<init>	()V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 601	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 1903	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   97: invokevirtual 1909	atmq:createEntityManager	()Latmp;
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_1
    //   105: ldc_w 617
    //   108: invokevirtual 1914	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: bipush 19
    //   113: anewarray 349	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 1915
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 1916
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 1917
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 1918
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 1919
    //   145: aastore
    //   146: dup
    //   147: iconst_5
    //   148: ldc_w 1920
    //   151: aastore
    //   152: dup
    //   153: bipush 6
    //   155: ldc_w 1921
    //   158: aastore
    //   159: dup
    //   160: bipush 7
    //   162: ldc_w 1922
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: ldc_w 1924
    //   172: aastore
    //   173: dup
    //   174: bipush 9
    //   176: ldc_w 1926
    //   179: aastore
    //   180: dup
    //   181: bipush 10
    //   183: ldc_w 1928
    //   186: aastore
    //   187: dup
    //   188: bipush 11
    //   190: ldc_w 1929
    //   193: aastore
    //   194: dup
    //   195: bipush 12
    //   197: ldc_w 1930
    //   200: aastore
    //   201: dup
    //   202: bipush 13
    //   204: ldc_w 1931
    //   207: aastore
    //   208: dup
    //   209: bipush 14
    //   211: ldc_w 1932
    //   214: aastore
    //   215: dup
    //   216: bipush 15
    //   218: ldc_w 1933
    //   221: aastore
    //   222: dup
    //   223: bipush 16
    //   225: ldc_w 1934
    //   228: aastore
    //   229: dup
    //   230: bipush 17
    //   232: ldc_w 1935
    //   235: aastore
    //   236: dup
    //   237: bipush 18
    //   239: ldc_w 1936
    //   242: aastore
    //   243: ldc_w 1938
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
    //   258: invokevirtual 1943	atmp:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +289 -> 552
    //   266: aload_1
    //   267: invokeinterface 1948 1 0
    //   272: ifeq +274 -> 546
    //   275: new 617	com/tencent/mobileqq/data/TroopMemberInfo
    //   278: dup
    //   279: invokespecial 1949	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload_1
    //   287: iconst_0
    //   288: invokeinterface 1950 2 0
    //   293: putfield 620	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   296: aload 9
    //   298: aload_1
    //   299: iconst_1
    //   300: invokeinterface 1950 2 0
    //   305: invokestatic 1953	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   308: putfield 1368	com/tencent/mobileqq/data/TroopMemberInfo:mIsShielded	Z
    //   311: aload 9
    //   313: aload_1
    //   314: iconst_2
    //   315: invokeinterface 1950 2 0
    //   320: putfield 1395	com/tencent/mobileqq/data/TroopMemberInfo:mUniqueTitle	Ljava/lang/String;
    //   323: aload 9
    //   325: aload_1
    //   326: iconst_3
    //   327: invokeinterface 1956 2 0
    //   332: putfield 1347	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   335: aload 9
    //   337: aload_1
    //   338: iconst_4
    //   339: invokeinterface 1960 2 0
    //   344: putfield 1364	com/tencent/mobileqq/data/TroopMemberInfo:active_point	J
    //   347: aload 9
    //   349: aload_1
    //   350: iconst_5
    //   351: invokeinterface 1960 2 0
    //   356: putfield 1356	com/tencent/mobileqq/data/TroopMemberInfo:credit_level	J
    //   359: aload 9
    //   361: aload_1
    //   362: bipush 6
    //   364: invokeinterface 1960 2 0
    //   369: putfield 1341	com/tencent/mobileqq/data/TroopMemberInfo:last_active_time	J
    //   372: aload 9
    //   374: aload_1
    //   375: bipush 7
    //   377: invokeinterface 1960 2 0
    //   382: putfield 1344	com/tencent/mobileqq/data/TroopMemberInfo:join_time	J
    //   385: aload 9
    //   387: aload_1
    //   388: bipush 8
    //   390: invokeinterface 1950 2 0
    //   395: putfield 1962	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   398: aload 9
    //   400: aload_1
    //   401: bipush 9
    //   403: invokeinterface 1950 2 0
    //   408: putfield 1335	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_troopnick	Ljava/lang/String;
    //   411: aload 9
    //   413: aload_1
    //   414: bipush 10
    //   416: invokeinterface 1950 2 0
    //   421: putfield 1338	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_troopnick	Ljava/lang/String;
    //   424: aload 9
    //   426: aload_1
    //   427: bipush 11
    //   429: invokeinterface 1950 2 0
    //   434: putfield 1315	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   437: aload 9
    //   439: aload_1
    //   440: bipush 12
    //   442: invokeinterface 1950 2 0
    //   447: putfield 1320	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_friendnick	Ljava/lang/String;
    //   450: aload 9
    //   452: aload_1
    //   453: bipush 13
    //   455: invokeinterface 1950 2 0
    //   460: putfield 1325	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_friendnick	Ljava/lang/String;
    //   463: aload 9
    //   465: aload_1
    //   466: bipush 14
    //   468: invokeinterface 1950 2 0
    //   473: putfield 1430	com/tencent/mobileqq/data/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   476: aload 9
    //   478: aload_1
    //   479: bipush 15
    //   481: invokeinterface 1950 2 0
    //   486: putfield 1436	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_autoremark	Ljava/lang/String;
    //   489: aload 9
    //   491: aload_1
    //   492: bipush 16
    //   494: invokeinterface 1950 2 0
    //   499: putfield 1439	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_autoremark	Ljava/lang/String;
    //   502: aload 9
    //   504: aload_1
    //   505: bipush 17
    //   507: invokeinterface 1956 2 0
    //   512: putfield 1351	com/tencent/mobileqq/data/TroopMemberInfo:realLevel	I
    //   515: aload 9
    //   517: aload_1
    //   518: bipush 18
    //   520: invokeinterface 1950 2 0
    //   525: putfield 1332	com/tencent/mobileqq/data/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   528: aload_2
    //   529: aload 9
    //   531: invokeinterface 645 2 0
    //   536: pop
    //   537: aload_1
    //   538: invokeinterface 1965 1 0
    //   543: ifne -268 -> 275
    //   546: aload_1
    //   547: invokeinterface 1968 1 0
    //   552: aload 8
    //   554: invokevirtual 1969	atmp:a	()V
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
    //   582: ldc_w 1971
    //   585: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: lload 6
    //   590: aload_0
    //   591: getfield 261	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   594: lsub
    //   595: invokevirtual 1974	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: invokevirtual 594	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_2
    //   605: astore 8
    //   607: aload 8
    //   609: ifnull +13 -> 622
    //   612: aload 8
    //   614: invokeinterface 1899 1 0
    //   619: ifeq +26 -> 645
    //   622: invokestatic 576	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +13 -> 638
    //   628: ldc_w 578
    //   631: iconst_2
    //   632: ldc_w 1976
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
    //   695: new 1978	com/tencent/mobileqq/activity/TroopMemberListActivity$35
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
    //   712: invokestatic 1984	java/lang/Math:min	(II)I
    //   715: invokespecial 1987	com/tencent/mobileqq/activity/TroopMemberListActivity$35:<init>	(Lcom/tencent/mobileqq/activity/TroopMemberListActivity;Ljava/util/List;II)V
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
    //   751: ldc_w 1989
    //   754: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: iload 4
    //   759: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   762: ldc_w 1991
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
    //   802: ldc_w 1993
    //   805: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload_1
    //   809: invokevirtual 1890	java/lang/Exception:toString	()Ljava/lang/String;
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
    //   847: ldc_w 1993
    //   850: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_1
    //   854: invokevirtual 1994	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
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
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0) || (this.jdField_a_of_type_Acao == null)) {
      break label16;
    }
    label16:
    while (this.jdField_a_of_type_Acao.jdField_b_of_type_Int + this.jdField_a_of_type_Acao.jdField_c_of_type_Int > 16) {
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
        localObject = (ajjj)this.app.getManager(51);
        this.jdField_c_of_type_JavaUtilList = ((ajhh)this.app.getManager(53)).a(paramString);
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
            paramString = a(paramString, (ajjj)localObject);
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
      localObject = this.jdField_a_of_type_Acao.a();
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
    //   24: checkcast 609	ajjj
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 601	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 1903	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   36: invokevirtual 1909	atmq:createEntityManager	()Latmp;
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
    //   63: ldc_w 2051
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
    //   90: invokevirtual 2054	atmp:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
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
    //   126: invokevirtual 642	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Lajjj;)Lacam;
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
    //   156: ldc_w 2056
    //   159: invokevirtual 587	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 961	java/lang/System:currentTimeMillis	()J
    //   165: lload_3
    //   166: lsub
    //   167: invokevirtual 1974	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
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
    //   27	98	6	localajjj	ajjj
    //   39	19	7	localatmp	atmp
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
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131312031));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131311553);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302796));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298449));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302806));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302832));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302816));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131312027));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131302454));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131309309);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303639));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303816));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131301983));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131303837));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131632046));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302817));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843166);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131654528));
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
          acam localacam = (acam)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localacam != null) && (localacam.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131626287));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131626982));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131626291));
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649774));
      }
      if (this.jdField_d_of_type_Int == 14) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131624159));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839704);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acag(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131631064));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131625035);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839704);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acah(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131631066));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131625035);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acai(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131630895));
        if (this.jdField_h_of_type_JavaLangString == null) {
          this.jdField_h_of_type_JavaLangString = getString(2131625011);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839704);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131631828);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        break;
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654631);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131626377);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131626982));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131626291));
        break;
      }
      if (this.jdField_d_of_type_Int == 18)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654529);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649765));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acaj(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 23)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654529);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649832));
      if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_h_of_type_JavaLangString == null) {
        this.jdField_h_of_type_JavaLangString = getString(2131625011);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131626982);
      if (this.jdField_d_of_type_Int != 4)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839704);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131632046));
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
      this.jdField_a_of_type_Acaq.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    azks localazks = (azks)this.app.getManager(203);
    int i1 = 0;
    for (;;)
    {
      acam localacam;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label964;
        }
        localacam = (acam)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((this.jdField_r_of_type_Boolean) && (localazks.b(localacam.jdField_a_of_type_JavaLangString))) {
          break label1142;
        }
        localacam.jdField_e_of_type_JavaLangString = "";
        localacam.jdField_f_of_type_JavaLangString = "";
        if ((paramString.equals(localacam.m)) || (paramString.equals(localacam.jdField_o_of_type_JavaLangString)) || (paramString.equals(localacam.jdField_n_of_type_JavaLangString)))
        {
          localacam.jdField_e_of_type_JavaLangString = localacam.m;
          localArrayList1.add(localacam);
          if (!QLog.isColorLevel()) {
            break label1142;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + localacam.jdField_a_of_type_JavaLangString + "," + localacam.jdField_e_of_type_JavaLangString);
        }
      }
      finally {}
      if ((paramString.equals(localacam.jdField_j_of_type_JavaLangString)) || (paramString.equals(localacam.l)) || (paramString.equals(localacam.jdField_k_of_type_JavaLangString)))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_j_of_type_JavaLangString;
        localArrayList1.add(localacam);
      }
      else if ((paramString.equals(localacam.jdField_g_of_type_JavaLangString)) || (paramString.equals(localacam.jdField_i_of_type_JavaLangString)) || (paramString.equals(localacam.jdField_h_of_type_JavaLangString)))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_g_of_type_JavaLangString;
        localArrayList1.add(localacam);
      }
      else if (paramString.equals(localacam.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localacam.jdField_e_of_type_JavaLangString = localacam.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localacam);
        }
      }
      else if ((localacam.m.indexOf(paramString) == 0) || (localacam.jdField_o_of_type_JavaLangString.indexOf(paramString) == 0) || (localacam.jdField_n_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.m;
        localacam.jdField_f_of_type_JavaLangString = localacam.jdField_n_of_type_JavaLangString;
        localArrayList2.add(localacam);
      }
      else if ((localacam.jdField_j_of_type_JavaLangString.indexOf(paramString) == 0) || (localacam.l.indexOf(paramString) == 0) || (localacam.jdField_k_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_j_of_type_JavaLangString;
        localacam.jdField_f_of_type_JavaLangString = localacam.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localacam);
      }
      else if ((localacam.jdField_g_of_type_JavaLangString.indexOf(paramString) == 0) || (localacam.jdField_i_of_type_JavaLangString.indexOf(paramString) == 0) || (localacam.jdField_h_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_g_of_type_JavaLangString;
        localacam.jdField_f_of_type_JavaLangString = localacam.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localacam);
      }
      else if (localacam.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localacam.jdField_e_of_type_JavaLangString = localacam.jdField_a_of_type_JavaLangString;
          localacam.jdField_f_of_type_JavaLangString = localacam.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localacam);
        }
      }
      else if ((localacam.m.indexOf(paramString) > 0) || (localacam.jdField_o_of_type_JavaLangString.indexOf(paramString) > 0) || (localacam.jdField_n_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.m;
        localArrayList3.add(localacam);
      }
      else if ((localacam.jdField_j_of_type_JavaLangString.indexOf(paramString) > 0) || (localacam.l.indexOf(paramString) > 0) || (localacam.jdField_k_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_j_of_type_JavaLangString;
        localArrayList3.add(localacam);
      }
      else if ((localacam.jdField_g_of_type_JavaLangString.indexOf(paramString) > 0) || (localacam.jdField_i_of_type_JavaLangString.indexOf(paramString) > 0) || (localacam.jdField_h_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_g_of_type_JavaLangString;
        localArrayList3.add(localacam);
      }
      else if ((localacam.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_e_of_type_Boolean))
      {
        localacam.jdField_e_of_type_JavaLangString = localacam.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localacam);
        continue;
        label964:
        Collections.sort(localArrayList2, new acar(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Acaq.notifyDataSetChanged();
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
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new abyy(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new abyz(this));
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 22)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abza(this));
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
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abzb(this));
        }
        else if (this.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abzc(this));
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
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131690181);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131492892);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.jdField_d_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131299579)).setText(getString(2131626268));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_Ajhf.b(Long.parseLong(this.jdField_a_of_type_JavaLangString), Long.valueOf(paramString).longValue());
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
    Object localObject1 = (ajjj)this.app.getManager(51);
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
            ThreadManager.post(new TroopMemberListActivity.1(this, paramIntent, (ajjj)localObject1, (TroopManager)localObject2), 8, null, true);
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
      localObject1 = babh.a(this.app, getApplicationContext(), paramIntent);
      localObject2 = aciy.a(new Intent(this, SplashActivity.class), null);
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
    ThreadManager.post(new TroopMemberListActivity.2(this, (ajjj)localObject1), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_d_of_type_Int == 11) {
      awqx.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
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
    this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num_exceeds_wording", 2131632104);
    this.jdField_k_of_type_JavaLangString = ((Bundle)localObject).getString("param_pick_title_string", this.jdField_k_of_type_JavaLangString);
    this.jdField_r_of_type_Boolean = ((Bundle)localObject).getBoolean("param_filter_robot", false);
    if (this.jdField_d_of_type_Int == 17) {
      new awrb(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_b_of_type_JavaLangString }).a();
    }
    if (this.jdField_d_of_type_Int == 22) {
      azzx.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
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
        setTheme(2131689611);
      }
      super.doOnCreate(paramBundle);
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.jdField_e_of_type_Boolean + ", mTroopUin = " + this.jdField_b_of_type_JavaLangString);
      }
      setContentView(2131496947);
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
          ((ajtg)this.app.a(20)).v(this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_m_of_type_Int == 5) {
          ((ajtg)this.app.a(20)).w(this.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Ajhf = ((ajhf)this.app.a(6));
        this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        paramBundle = (TroopManager)this.app.getManager(52);
        localObject = (ajhh)this.app.getManager(53);
        if ((paramBundle != null) && (localObject != null)) {
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((ajhh)localObject).a(this.jdField_b_of_type_JavaLangString);
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
      addObserver(this.jdField_a_of_type_Ajhi);
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
        this.jdField_j_of_type_Int = getResources().getDimensionPixelSize(2131167835);
        this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131165569);
        if (this.jdField_k_of_type_Int == 0) {
          this.jdField_k_of_type_Int = ((int)(paramBundle.density * 58.0F));
        }
        this.jdField_i_of_type_Int = (i1 - i2 - i3 - i4);
        this.jdField_l_of_type_Int = ((this.jdField_i_of_type_Int - this.jdField_j_of_type_Int) / this.jdField_k_of_type_Int);
        this.jdField_a_of_type_Ajdy = new ajdy(this);
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
      awqx.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_c_of_type_Boolean = true;
      }
      localObject = getResources().getStringArray(2130903143);
      paramBundle = getResources().getStringArray(2130903142);
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
        awqx.b(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_d_of_type_Int == 3) {
        ((ajtg)this.app.a(20)).q(this.jdField_b_of_type_JavaLangString);
      }
      return true;
      this.app.addObserver(this.jdField_a_of_type_Ajuc, true);
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
      this.jdField_a_of_type_ArrayOfJavaLangString[i3] = getResources().getString(2131654658);
      if (i1 != 0) {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i3 + 1)] = getResources().getString(2131654657);
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
      this.jdField_b_of_type_ArrayOfJavaLangString[i2] = getResources().getString(2131654659);
      if (i1 == 0) {
        break label1521;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString[(i2 + 1)] = getResources().getString(2131654657);
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
      if (this.jdField_a_of_type_Ajdy != null)
      {
        this.jdField_a_of_type_Ajdy.c();
        this.jdField_a_of_type_Ajdy = null;
      }
      try
      {
        removeObserver(this.jdField_a_of_type_Ajhi);
        removeObserver(this.jdField_a_of_type_Ajuc);
        label48:
        if (this.jdField_a_of_type_Acaq != null) {
          this.jdField_a_of_type_Acaq.c();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_Acao != null) {
          this.jdField_a_of_type_Acao.c();
        }
        if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
          this.jdField_a_of_type_Begr.dismiss();
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
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Acao != null) {
        this.jdField_a_of_type_Acao.a();
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
      if (this.jdField_a_of_type_Ajdy != null) {
        this.jdField_a_of_type_Ajdy.a();
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
    View localView = getLayoutInflater().inflate(2131496956, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131309912));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131296974));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView;
    int i1;
    label124:
    int i2;
    label142:
    Object localObject;
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839104);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131312436);
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
        localObject = getString(2131654618);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131309352);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131302951)).setBackgroundDrawable(bacm.d());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131306484);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new abzd(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new abze(this, (String)localObject));
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (ajtg)this.app.a(20);
        if (badq.d(BaseApplication.getContext())) {
          break label855;
        }
        bbmy.a(this, 1, 2131628946, 0).b(getTitleBarHeight());
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
        localObject = (ajtg)this.app.a(20);
        if (badq.d(BaseApplication.getContext())) {
          break label964;
        }
        bbmy.a(this, 1, 2131628946, 0).b(getTitleBarHeight());
      }
      label441:
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300167);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297934)).setVisibility(8);
      if (this.jdField_d_of_type_Int != 19) {
        break label1025;
      }
      localView = getLayoutInflater().inflate(2131496948, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new abzf(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acao = new acao(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Acao);
      if ((this.jdField_d_of_type_Int == 19) || (this.jdField_d_of_type_Int == 21)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 19)) {
        t();
      }
      ((EditText)localObject).setOnTouchListener(new abzg(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_d_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839101);
      break;
      label845:
      i1 = 0;
      break label124;
      label850:
      i2 = 0;
      break label142;
      label855:
      if ((this.jdField_a_of_type_Ajhf != null) && (this.jdField_d_of_type_Int == 11)) {
        this.jdField_a_of_type_Ajhf.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839117);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject != null) {
          ((ajtg)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        }
      }
      label954:
      i1 = 0;
      break label365;
      label959:
      i2 = 0;
      break label383;
      label964:
      if ((this.jdField_a_of_type_Ajhf != null) && (this.jdField_d_of_type_Int == 11))
      {
        this.jdField_a_of_type_Ajhf.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
        break label441;
      }
      if (localObject == null) {
        break label441;
      }
      ((ajtg)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
      break label441;
      label1025:
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  protected void e(String paramString)
  {
    if (((azks)this.app.getManager(203)).a(this, this.jdField_b_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131654617));
    if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131625011));
    }
    atxx.a(this.app, this, this.jdField_b_of_type_JavaLangString, paramString, 1, 1, localBundle);
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
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 16) && (badq.g(this)))
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
          localObject2 = (ajtg)this.app.a(20);
          if (localObject2 != null)
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            ((ajtg)localObject2).a(true, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, a(), this.jdField_a_of_type_Long, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_a_of_type_JavaLangString + " troopCode: " + this.jdField_b_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((ajtg)localObject2).a(Long.parseLong(this.jdField_b_of_type_JavaLangString), 0L, 1, 0, 0);
        if (this.jdField_d_of_type_Int == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_troop_info_last_update" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (ajtg)this.app.a(20);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              ((ajtg)localObject2).j(this.jdField_b_of_type_JavaLangString);
              ((ajtg)localObject2).a(1, ajex.a(this.jdField_b_of_type_JavaLangString), 0L, 2, 0, 0, true);
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
        ((azjq)this.app.getManager(113)).a(this.jdField_b_of_type_JavaLangString, new abzm(this));
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
      arrayOfString = getResources().getStringArray(2130903137);
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
        break label165;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
      i1 = arrayOfString.length;
      this.jdField_a_of_type_Begr = begr.a(this);
      i2 = 0;
      label65:
      if (i2 >= i1) {
        break label203;
      }
      if (!this.jdField_e_of_type_Boolean) {
        break label267;
      }
      if (!ajjy.a(2131649800).equals(arrayOfString[i2])) {
        break label188;
      }
    }
    label267:
    for (;;)
    {
      i2 += 1;
      break label65;
      arrayOfString = getResources().getStringArray(2130903135);
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
        this.jdField_a_of_type_Begr.c(arrayOfString[i2]);
        label203:
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
          this.jdField_a_of_type_Begr.a(arrayOfString[3], 3);
        }
        this.jdField_a_of_type_Begr.c(2131625035);
        this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_Begw);
        this.jdField_a_of_type_Begr.show();
        return;
        if (i2 == 3)
        {
          this.jdField_a_of_type_Begr.a(arrayOfString[i2], 3);
        }
        else
        {
          this.jdField_a_of_type_Begr.c(arrayOfString[i2]);
          if (arrayOfString[i2].equals(ajjy.a(2131649760))) {
            awqx.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Acao != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Acao.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Acao.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Acao.jdField_a_of_type_Int) }));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.jdField_m_of_type_Int == 0) {
      if (this.jdField_d_of_type_Int == 11) {
        if ((this.jdField_a_of_type_Acao != null) && (this.jdField_a_of_type_Acao.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_Acao.jdField_a_of_type_Int > 1)) {
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
        if ((this.jdField_a_of_type_Acao != null) && (this.jdField_a_of_type_Acao.jdField_b_of_type_Int + this.jdField_a_of_type_Acao.jdField_c_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Acao.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else if ((this.jdField_a_of_type_Acao != null) && (this.jdField_a_of_type_Acao.jdField_b_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Acao.jdField_a_of_type_Int > 1))
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131690181);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131492892);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_d_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131299579)).setText(getString(2131653452));
      return;
      label76:
      bool = false;
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Int == 11) {
      awqx.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new abzr(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new abzs(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297934);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new abzt(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Acaq.notifyDataSetChanged();
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
      ViewStub localViewStub = (ViewStub)findViewById(2131312069);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131312070)).setOnTouchListener(new acaf(this));
      }
    }
  }
  
  public void o()
  {
    if (!isResume()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Acao != null) {}
      try
      {
        this.jdField_a_of_type_Acao.notifyDataSetChanged();
        if (this.jdField_a_of_type_Acaq == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_Acaq.notifyDataSetChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */