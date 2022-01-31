package com.tencent.mobileqq.activity;

import acjf;
import acjg;
import acjh;
import acji;
import acjj;
import acjk;
import acjl;
import acjm;
import acjn;
import acjo;
import acjq;
import acjr;
import acjs;
import acjt;
import acju;
import acjv;
import acjx;
import acjy;
import acjz;
import acka;
import ackb;
import ackc;
import ackd;
import acke;
import ackf;
import ackg;
import ackh;
import acki;
import ackj;
import ackk;
import ackl;
import ackm;
import ackn;
import acko;
import ackp;
import ackq;
import ackr;
import acks;
import acku;
import ackw;
import acky;
import ackz;
import acla;
import aclb;
import actj;
import ajry;
import ajsx;
import ajvg;
import ajvi;
import ajvj;
import ajxl;
import ajya;
import akfv;
import akhp;
import akil;
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
import auvy;
import axmv;
import axqy;
import axrc;
import ayjw;
import azrf;
import azrg;
import badj;
import bahy;
import balh;
import bamk;
import bbbp;
import bbbr;
import bbcz;
import bbef;
import bbfj;
import bbos;
import bcnf;
import bcng;
import bcql;
import bfpc;
import bfph;
import bfpt;
import bfut;
import bfuw;
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
import mxf;
import mxj;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;
import vzl;

public class TroopMemberListActivity
  extends BaseActivity
  implements bcnf, bcng, bfpt
{
  public static double b;
  private static int jdField_p_of_type_Int = 1000;
  public double a;
  public float a;
  public int a;
  public long a;
  public ackw a;
  public acky a;
  public ajry a;
  protected ajvg a;
  public ajvj a;
  public akil a;
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
  public bfpc a;
  protected bfph a;
  public bfut a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public TroopInfoData a;
  public IndexView a;
  public PinnedDividerSwipListView a;
  public XListView a;
  public String a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  public ArrayList<String> a;
  public List<acku> a;
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
  public List<acku> b;
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
  private String w = ajya.a(2131715566);
  
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acks(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new acjf(this);
    this.jdField_m_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_Bfph = new acjv(this);
    this.jdField_a_of_type_AndroidOsHandler = new ackc(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ackd(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new acke(this);
    this.jdField_a_of_type_Ajvj = new ackh(this);
    this.jdField_a_of_type_Akil = new ackj(this);
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
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bfut.getContentView().findViewById(2131364691);
    int i1 = 0;
    if (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      bfuw localbfuw = (bfuw)((View)localObject).getTag();
      if (localbfuw != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131377199);
        if (localObject != null)
        {
          if (localbfuw.jdField_a_of_type_Int != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131166865));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131166854));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(ajya.a(2131715636), new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(ajya.a(2131715572), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
      this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_Ackw.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_Ackw.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        q();
        h();
        if (this.jdField_a_of_type_Ackw == null) {
          break label302;
        }
        this.jdField_a_of_type_Ackw.notifyDataSetChanged();
        this.jdField_a_of_type_Ackw.a();
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
      this.jdField_a_of_type_Ackw = new ackw(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Ackw);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, mxj parammxj)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    mxf.b(paramQQAppInterface, parammxj, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void a(List<Long> paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    Dialog localDialog = new Dialog(this, 2131755791);
    localDialog.setContentView(2131559037);
    ((TextView)localDialog.findViewById(2131365150)).setText(getString(2131691534));
    TextView localTextView = (TextView)localDialog.findViewById(2131365146);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131364180);
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
      localTextView.setText(getString(2131693710));
      localCheckBox.setText(getString(2131718689));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localTextView = (TextView)localDialog.findViewById(2131365135);
      localObject = (TextView)localDialog.findViewById(2131365141);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new ackf(this, localDialog));
      ((TextView)localObject).setOnClickListener(new ackg(this, paramList, localCheckBox, bool, localDialog));
      localDialog.show();
      return;
      bool = false;
      break;
      label291:
      localTextView.setText(getString(2131694461));
      localCheckBox.setText(getString(2131694463));
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
    ajxl localajxl = (ajxl)this.app.getManager(51);
    bamk localbamk = (bamk)this.app.getManager(203);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!bbbr.d(localTroopMemberInfo.memberuin)) {
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
        if (((this.jdField_f_of_type_JavaUtilList == null) || (!this.jdField_f_of_type_JavaUtilList.contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localbamk.b(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localajxl));
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
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378265);
        localObject1 = getString(2131720525);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375100);
        ((TextView)localObject2).setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368583)).setBackgroundDrawable(bbef.d());
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372183);
        ((ImageView)localObject3).setVisibility(8);
        if (i1 != 0)
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setOnClickListener(new ackk(this));
          ((TextView)localObject2).setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ackl(this, (String)localObject1));
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
        ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375100)).setCompoundDrawables(null, null, null, null);
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
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378265)).setTextColor(getResources().getColor(2131166854));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375100);
      localObject2 = ajya.a(2131715585);
      localObject3 = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371058);
      ((Button)localObject3).setVisibility(8);
      ((Button)localObject3).setOnClickListener(new ackm(this));
      i1 = ((akfv)this.app.a(13)).g();
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
      this.jdField_g_of_type_JavaLangString = (ajya.a(2131715589) + paramInt1 + ajya.a(2131715592));
      ((TextView)localObject1).setText(this.jdField_g_of_type_JavaLangString);
      paramString1 = (String)localObject2 + "," + this.jdField_g_of_type_JavaLangString;
      label615:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        paramString2.rightMargin = actj.a(20.0F, getResources());
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
        this.jdField_g_of_type_JavaLangString = ajya.a(2131715651);
        paramString1 = (String)localObject2 + ",剩余0次";
        ((TextView)localObject1).setText("剩余0次");
        break label615;
      }
      this.jdField_g_of_type_JavaLangString = "";
      paramString1 = (String)localObject2 + "," + ajya.a(2131715650);
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
          paramInt1 = (int)(ajya.a(2131715647).length() * 12 * this.jdField_a_of_type_Float);
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
      if (paramString1.contains(ajya.a(2131715657)))
      {
        paramInt1 = paramString1.indexOf(ajya.a(2131715658));
        paramInt2 = ajya.a(2131715575).length();
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
        } while (!((bamk)paramQQAppInterface.getManager(203)).b(paramString));
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
    if (this.jdField_a_of_type_Bfut == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        bfuw localbfuw = new bfuw();
        localbfuw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localbfuw.jdField_a_of_type_Int = i1;
        localbfuw.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localArrayList.add(localbfuw);
        i1 += 1;
      }
      this.jdField_a_of_type_Bfut = bfut.a(this, localArrayList, new acjy(this), null, vzl.a(this, 135.0F), false);
      this.jdField_a_of_type_Bfut.setTouchInterceptor(new acki(this));
      a(this.jdField_m_of_type_Int);
    }
    this.jdField_a_of_type_Bfut.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(vzl.a(this, 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
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
    this.jdField_e_of_type_AndroidViewView = getLayoutInflater().inflate(2131562549, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368061);
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
      localObject = (acku)localIterator.next();
      if (((acku)localObject).jdField_b_of_type_Long == 0L) {
        ((acku)localObject).jdField_b_of_type_Long = ((acku)localObject).jdField_a_of_type_Long;
      }
      if (TextUtils.isEmpty(a(((acku)localObject).jdField_b_of_type_Long, localCalendar, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
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
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new acjq(this, i1, i2));
        s();
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
        axqy.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.jdField_b_of_type_JavaLangString, "" + i2, "", "");
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
      localObject = this.jdField_e_of_type_AndroidViewView.findViewById(2131375261);
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
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131562369);
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
      int i1 = getResources().getColor(2131166910);
      new SystemBarCompact(this.jdField_b_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375493);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375673));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838514));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Acky = new acky(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acky);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new acjr(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365763));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acla(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375493);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131367678));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131370876);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131375189));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new acjs(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acjt(this));
  }
  
  private void u()
  {
    int i1 = this.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format(ajya.a(2131715638), new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new acjx(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715664));
  }
  
  private void v()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(0, this.jdField_o_of_type_Int, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  public acku a(DiscussionMemberInfo paramDiscussionMemberInfo, ajxl paramajxl)
  {
    acku localacku = new acku();
    localacku.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramajxl != null) {
      localFriends = paramajxl.b(paramDiscussionMemberInfo.memberUin);
    }
    localacku.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localacku.jdField_a_of_type_Short = 0;
    localacku.jdField_c_of_type_JavaLangString = ChnToSpell.a(localacku.jdField_b_of_type_JavaLangString, 2);
    localacku.a(ChnToSpell.a(localacku.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localacku.e(localFriends.remark);
      localacku.h(ChnToSpell.a(localacku.jdField_j_of_type_JavaLangString, 1));
      localacku.f(ChnToSpell.a(localacku.jdField_j_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localacku.i(paramDiscussionMemberInfo.memberName);
        localacku.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localacku.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      if (this.jdField_a_of_type_Ajry != null) {
        this.jdField_a_of_type_Ajry.a(localacku);
      }
      return localacku;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localacku.e(paramDiscussionMemberInfo.inteRemark);
        localacku.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localacku.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public acku a(TroopMemberInfo paramTroopMemberInfo, ajxl paramajxl)
  {
    acku localacku = new acku();
    localacku.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramajxl != null) {
      localFriends = paramajxl.b(paramTroopMemberInfo.memberuin);
    }
    localacku.jdField_b_of_type_JavaLangString = bbcz.c(this.app, this.jdField_b_of_type_JavaLangString, localacku.jdField_a_of_type_JavaLangString, true);
    localacku.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localacku.jdField_c_of_type_JavaLangString = ChnToSpell.a(localacku.jdField_b_of_type_JavaLangString, 2);
    localacku.a(ChnToSpell.a(localacku.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localacku.b(paramTroopMemberInfo.friendnick);
      localacku.d(paramTroopMemberInfo.pyAll_friendnick);
      localacku.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localacku.e(localFriends.remark);
      localacku.h(ChnToSpell.a(localacku.jdField_j_of_type_JavaLangString, 1));
      localacku.f(ChnToSpell.a(localacku.jdField_j_of_type_JavaLangString, 2));
      localacku.g(localFriends.remark);
      if ((paramTroopMemberInfo.troopColorNick != null) && (paramTroopMemberInfo.troopColorNick.length() > 0))
      {
        localacku.i(paramTroopMemberInfo.troopColorNick);
        localacku.k(paramTroopMemberInfo.pyAll_troopnick);
        localacku.j(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localacku.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localacku.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localacku.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localacku.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
      localacku.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localacku.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localacku.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localacku.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      localacku.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.app.getManager(52)).a(this.jdField_b_of_type_JavaLangString, localacku.jdField_a_of_type_JavaLangString);
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
      localacku.t = ((int)d1 + "km");
    }
    for (;;)
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localacku.u = paramTroopMemberInfo.mUniqueTitle;
        localacku.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      if (this.jdField_a_of_type_Ajry != null) {
        this.jdField_a_of_type_Ajry.a(localacku);
      }
      localacku.jdField_e_of_type_Int = paramTroopMemberInfo.mVipType;
      localacku.jdField_f_of_type_Int = paramTroopMemberInfo.mVipLevel;
      localacku.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localacku.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
      localacku.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
      localacku.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
      localacku.v = paramTroopMemberInfo.honorList;
      return localacku;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.jdField_e_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localacku.e(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK);
        localacku.h(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 1));
        localacku.f(ChnToSpell.a(TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK, 2));
        break;
      }
      localacku.e(paramTroopMemberInfo.autoremark);
      localacku.h(paramTroopMemberInfo.pyAll_autoremark);
      localacku.f(paramTroopMemberInfo.pyFirst_autoremark);
      break;
      label669:
      localacku.t = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
      continue;
      label704:
      localacku.t = "";
    }
  }
  
  public acku a(String paramString)
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
          acku localacku = (acku)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localacku != null) && (localacku.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (acku)this.jdField_a_of_type_JavaUtilList.remove(i1);
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
  
  public aclb a(String paramString, boolean paramBoolean)
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
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof aclb)))
      {
        localObject2 = (aclb)((View)localObject2).getTag();
        if ((((aclb)localObject2).jdField_a_of_type_JavaLangString != null) && (((aclb)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
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
  
  public List<acku> a(List<acku> paramList, String paramString1, String paramString2)
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
        acku localacku = (acku)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localacku.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localacku);
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
        paramString1 = (acku)paramList.get(i3);
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
        paramString1 = (acku)paramList.get(i4);
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
          paramString1 = (acku)paramList.get(i2);
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
            paramString1 = (acku)paramList.get(i2);
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
              paramString1 = (acku)paramList.get(i2);
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
    Object localObject = (ViewGroup)findViewById(2131375329);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377369);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131368429);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void a(acku paramacku)
  {
    int i1 = 3;
    if ((paramacku != null) && (paramacku.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.clear();
      paramacku = new Intent();
      paramacku.putExtra("result", new JSONArray().toString());
      setResult(-1, paramacku);
      axqy.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
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
          } while ((paramacku == null) || (paramacku.jdField_a_of_type_JavaLangString == null));
          if (this.jdField_d_of_type_Int == 1)
          {
            if (this.app.getCurrentAccountUin().equals(paramacku.jdField_a_of_type_JavaLangString))
            {
              localObject1 = new ProfileActivity.AllInOne(paramacku.jdField_a_of_type_JavaLangString, 0);
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = bbcz.h(this.app, paramacku.jdField_a_of_type_JavaLangString);
              ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 3;
              ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 4;
              ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
              return;
            }
            a(paramacku.jdField_a_of_type_JavaLangString, paramacku.jdField_b_of_type_JavaLangString);
            return;
          }
          if (this.jdField_d_of_type_Int == 2)
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_uin", paramacku.jdField_a_of_type_JavaLangString);
            localObject2 = new TroopMemberListActivity.TroopAdmin();
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramacku.jdField_a_of_type_JavaLangString;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramacku.jdField_a_of_type_Short;
            ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramacku.jdField_b_of_type_JavaLangString;
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
              ((Intent)localObject1).putExtra("member_display_name", paramacku.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("isApollo", true);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("member_uin", paramacku.jdField_a_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
              setResult(-1, (Intent)localObject1);
              finish();
              return;
              ((Intent)localObject1).putExtra("member_display_name", paramacku.jdField_b_of_type_JavaLangString);
            }
          }
          if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 4) && (this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
            break;
          }
          e(paramacku.jdField_a_of_type_JavaLangString);
        } while (this.jdField_d_of_type_Int != 22);
        bbbp.a("Grp_idol", "mber_list", "clk", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
        return;
        if (this.jdField_d_of_type_Int == 5)
        {
          if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramacku.jdField_a_of_type_JavaLangString)))
          {
            startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.jdField_b_of_type_JavaLangString, paramacku.jdField_a_of_type_JavaLangString, i1, paramacku.u), 2);
            this.v = paramacku.jdField_a_of_type_JavaLangString;
            localObject1 = this.app;
            localObject2 = this.jdField_b_of_type_JavaLangString;
            i1 = this.jdField_m_of_type_Int;
            if (!this.jdField_m_of_type_Boolean) {
              break label633;
            }
          }
          for (paramacku = "1";; paramacku = "0")
          {
            axqy.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramacku, "");
            return;
            if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(paramacku.jdField_a_of_type_JavaLangString)))
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
          ((Intent)localObject1).putExtra("member_uin", paramacku.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_display_name", paramacku.jdField_b_of_type_JavaLangString);
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
            this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.add(paramacku);
            paramacku = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList != null)
            {
              localObject2 = this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  acku localacku = (acku)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localacku.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localacku.jdField_b_of_type_JavaLangString);
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
            paramacku.putExtra("result", ((JSONArray)localObject1).toString());
            setResult(-1, paramacku);
            finish();
            return;
          }
          if (this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.contains(paramacku)) {
            this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.remove(paramacku);
          }
          for (;;)
          {
            this.jdField_a_of_type_Ackw.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.size() < this.jdField_f_of_type_Int)
            {
              this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.add(paramacku);
            }
            else if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.add(paramacku);
            }
            else
            {
              bcql.a(this, getResources().getString(this.jdField_h_of_type_Int, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).a();
            }
          }
        }
        if ((this.jdField_d_of_type_Int != 18) && (this.jdField_d_of_type_Int != 19)) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("member_uin", paramacku.jdField_a_of_type_JavaLangString);
        PublicFragmentActivity.a(this, (Intent)localObject1, TroopMemberHistoryFragment.class);
      } while (this.jdField_d_of_type_Int != 19);
      paramacku = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
      bbbp.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bbbp.a(paramacku) });
      return;
    } while (this.jdField_d_of_type_Int != 23);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_member_name", paramacku.jdField_g_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("filter_uin", Long.valueOf(paramacku.jdField_a_of_type_JavaLangString));
    ((Intent)localObject1).putExtra("folderPath", "/");
    ((Intent)localObject1).putExtra("param_from", 6000);
    TroopFileProxyActivity.a(this, (Intent)localObject1, this.app.getCurrentAccountUin());
  }
  
  public void a(aclb paramaclb, acku paramacku, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
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
      paramaclb.jdField_a_of_type_Boolean = paramBoolean1;
      paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramaclb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaclb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaclb.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if ((this.jdField_m_of_type_Int != 1) && (this.jdField_m_of_type_Int != 5)) {
        break label867;
      }
      if (paramacku.jdField_d_of_type_Boolean) {
        break label854;
      }
      paramaclb.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      if ((this.jdField_b_of_type_Boolean) || (a()) || (paramacku.jdField_d_of_type_Int == -100) || (paramacku.jdField_d_of_type_Int == 0)) {
        break label889;
      }
      paramaclb.j.setVisibility(8);
      paramaclb.j.setText("LV" + paramacku.jdField_d_of_type_Int);
      VipUtils.a(this.app, this, getResources(), paramaclb, paramacku);
      if ((this.jdField_d_of_type_Int != 13) || (!paramBoolean1)) {
        break label901;
      }
      paramBitmap = paramacku.jdField_b_of_type_JavaLangString + "(" + paramacku.jdField_a_of_type_JavaLangString + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramacku.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramaclb.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label265:
      if ((paramBoolean2) && (paramaclb.k != null))
      {
        paramBitmap = ajya.a(2131715558) + paramacku.jdField_j_of_type_JavaLangString;
        paramaclb.k.setText(paramBitmap);
      }
      paramaclb.jdField_a_of_type_JavaLangString = paramacku.jdField_a_of_type_JavaLangString;
      paramaclb.jdField_c_of_type_Int = 1;
      paramaclb.f.setText("");
      paramaclb.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
      if (this.jdField_d_of_type_Int != 9) {
        break label986;
      }
      paramaclb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaclb.g.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaclb.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label1001;
      }
      paramaclb.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramaclb.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_d_of_type_Boolean) {
        paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
      label445:
      i3 = 0;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13)) {
        break label1131;
      }
      paramaclb.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691875) + paramaclb.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramaclb.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130848619);
      if (this.jdField_d_of_type_Int != 13) {
        break label1048;
      }
      paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label534:
      if (!str.equals(paramacku.jdField_a_of_type_JavaLangString)) {
        break label1120;
      }
      paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    int i1;
    int i2;
    for (;;)
    {
      paramaclb.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131691853), new Object[] { paramaclb.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramaclb.g.setContentDescription(getString(2131691852));
      i1 = i3;
      if (paramaclb.jdField_d_of_type_AndroidViewView != null)
      {
        paramBitmap = (bamk)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramacku.jdField_a_of_type_JavaLangString))) {
          break label2605;
        }
        i2 = 1;
        label647:
        if (i2 == 0) {
          break label2611;
        }
        paramaclb.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      label660:
      if (this.jdField_e_of_type_Boolean) {
        paramaclb.j.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramaclb.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      if ((paramBoolean2) && (paramaclb.k != null)) {
        paramBitmap.append(paramaclb.k.getText());
      }
      if (paramaclb.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        paramBitmap.append(paramaclb.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      }
      if (paramaclb.j.getVisibility() == 0) {
        paramBitmap.append(paramaclb.j.getText().toString());
      }
      if (paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.getVisibility() == 0) {
        paramBitmap.append(paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.a());
      }
      if ((paramaclb.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_Boolean))
      {
        if (i1 == 0) {
          break label2623;
        }
        paramacku = "已选中";
        label827:
        paramBitmap.append(paramacku);
      }
      paramaclb.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
      return;
      str = this.t;
      break;
      label854:
      paramaclb.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      break label84;
      label867:
      paramaclb.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramaclb.j.setVisibility(8);
      break label84;
      label889:
      paramaclb.j.setVisibility(8);
      break label153;
      label901:
      if (paramBoolean2)
      {
        paramBitmap = new ayjw(paramacku.jdField_g_of_type_JavaLangString, 16).a();
        paramaclb.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
        bbos.a(this.app, paramaclb.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
        break label265;
      }
      paramBitmap = new ayjw(paramacku.jdField_b_of_type_JavaLangString, 16).a();
      paramaclb.jdField_e_of_type_AndroidWidgetTextView.setText(paramBitmap);
      bbos.a(this.app, paramaclb.jdField_e_of_type_AndroidWidgetTextView, paramBitmap);
      break label265;
      label986:
      paramaclb.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
      break label364;
      label1001:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramaclb.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramaclb.jdField_a_of_type_AndroidViewView.setClickable(false);
        break label445;
      }
      paramaclb.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramaclb.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label445;
      label1048:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      if ((this.jdField_e_of_type_JavaLangString != null) && (!paramacku.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString)))
      {
        paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label534;
      label1120:
      paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label1131:
    paramaclb.jdField_c_of_type_AndroidWidgetTextView.setText("");
    label1153:
    boolean bool1;
    label1177:
    boolean bool2;
    label1208:
    boolean bool4;
    boolean bool5;
    if (!TextUtils.isEmpty(paramacku.u))
    {
      paramBoolean1 = true;
      if ((paramacku.jdField_a_of_type_JavaLangString == null) || (!paramacku.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString))) {
        break label1490;
      }
      bool1 = true;
      if ((this.jdField_f_of_type_JavaLangString == null) || (paramacku.jdField_a_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.contains(paramacku.jdField_a_of_type_JavaLangString))) {
        break label1496;
      }
      bool2 = true;
      bool4 = this.app.getCurrentAccountUin().equals(this.jdField_e_of_type_JavaLangString);
      bool5 = this.app.getCurrentAccountUin().equals(paramacku.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int != 5) {
        break label1648;
      }
      paramaclb.h.setVisibility(0);
      paramaclb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
      paramaclb.i.setVisibility(0);
      localObject = "";
      i2 = 0;
      if ((!paramBoolean1) || (axmv.b())) {
        break label1502;
      }
      paramBitmap = azrf.a().a(302, paramBoolean1, bool1, bool2);
      if (paramBitmap == null) {
        break label2645;
      }
      i1 = paramBitmap.jdField_b_of_type_Int;
      paramBitmap = paramacku.u;
    }
    for (;;)
    {
      label1331:
      localObject = paramBitmap;
      if (axmv.b())
      {
        if (bool1) {
          localObject = String.format(getString(2131689530), new Object[0]);
        }
      }
      else
      {
        label1361:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label1636;
        }
        paramaclb.h.setText((CharSequence)localObject);
        azrf.a(paramaclb.h, i1);
      }
      for (;;)
      {
        label1387:
        paramBitmap = (bamk)this.app.getManager(203);
        if ((paramBitmap == null) || (!paramBitmap.b(paramacku.jdField_a_of_type_JavaLangString))) {
          break label2320;
        }
        i1 = 1;
        label1419:
        if (!this.jdField_c_of_type_Boolean) {
          break label2386;
        }
        if ((this.jdField_d_of_type_Int == 21) || ((!bool1) && ((bool4) || (!bool2)) && ((bool4) || (i1 == 0)))) {
          break label2326;
        }
        paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        paramBoolean1 = false;
        break label1153;
        label1490:
        bool1 = false;
        break label1177;
        label1496:
        bool2 = false;
        break label1208;
        label1502:
        if (bool1)
        {
          localazrg = azrf.a().a(300, paramBoolean1, bool1, bool2);
          i1 = i2;
          paramBitmap = (Bitmap)localObject;
          if (localazrg == null) {
            break label1331;
          }
          i1 = localazrg.jdField_b_of_type_Int;
          paramBitmap = localazrg.jdField_a_of_type_JavaLangString;
          break label1331;
        }
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (!bool2) {
          break label1331;
        }
        azrg localazrg = azrf.a().a(301, paramBoolean1, bool1, bool2);
        i1 = i2;
        paramBitmap = (Bitmap)localObject;
        if (localazrg == null) {
          break label1331;
        }
        i1 = localazrg.jdField_b_of_type_Int;
        paramBitmap = localazrg.jdField_a_of_type_JavaLangString;
        break label1331;
        localObject = paramBitmap;
        if (!bool2) {
          break label1361;
        }
        localObject = String.format(getString(2131689529), new Object[0]);
        break label1361;
        label1636:
        paramaclb.h.setVisibility(8);
      }
      label1648:
      i1 = 0;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop();
      }
      if ((bool3) || (this.jdField_b_of_type_Boolean))
      {
        localObject = azrf.a().a(bool1, bool2);
        if (localObject == null) {
          break label2636;
        }
        paramBitmap = ((azrg)localObject).jdField_a_of_type_JavaLangString;
        i1 = ((azrg)localObject).jdField_b_of_type_Int;
      }
      for (;;)
      {
        label1712:
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
          label1748:
          if (!axmv.b())
          {
            localObject = paramBitmap;
            if (i2 != 0) {}
          }
          else
          {
            if (!bool1) {
              break label2199;
            }
            localObject = String.format(getString(2131689530), new Object[0]);
          }
          label1783:
          if (((!axmv.b()) && (i2 != 0)) || (bool2) || (bool1)) {
            break label2226;
          }
          i2 = 1;
          label1807:
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (a()) || (i2 != 0)) {
            break label2232;
          }
          paramaclb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramaclb.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          azrf.a(paramaclb.jdField_c_of_type_AndroidWidgetTextView, i1);
          label1853:
          paramBitmap = (badj)this.app.getManager(346);
          if (!paramBitmap.b(this.jdField_b_of_type_JavaLangString)) {
            break label2264;
          }
          paramBitmap = paramBitmap.a(paramacku.v);
          if ((paramBitmap == null) || (paramBitmap.size() <= 0)) {
            break label2244;
          }
          paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(paramBitmap);
          paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(0);
          label1916:
          if (this.jdField_b_of_type_Boolean)
          {
            paramBitmap = azrf.a().a(paramacku.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap == null) || (!bahy.a(paramacku.jdField_a_of_type_Int))) {
              break label2296;
            }
            if ((TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) || (axmv.b())) {
              break label2284;
            }
            paramaclb.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramaclb.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
            azrf.a(paramaclb.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
          }
        }
        for (;;)
        {
          if ((this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 12)) {
            break label2306;
          }
          if ((paramacku.jdField_a_of_type_JavaLangString == null) || (!paramacku.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
            break label2308;
          }
          paramaclb.f.setText(getString(2131694516));
          break;
          localObject = azrf.a().a(paramacku.jdField_a_of_type_Int, paramBoolean1, bool1, bool2);
          if (localObject != null)
          {
            paramBitmap = ((azrg)localObject).jdField_a_of_type_JavaLangString;
            i2 = ((azrg)localObject).jdField_b_of_type_Int;
            if (((azrg)localObject).jdField_a_of_type_Int == 302) {
              paramBitmap = paramacku.u;
            }
            i1 = i2;
            if (((azrg)localObject).jdField_a_of_type_Int != 315) {
              break label1712;
            }
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramacku.jdField_c_of_type_Int));
            i1 = i2;
            break label1712;
          }
          if (paramacku.jdField_a_of_type_Int != 315) {
            break label2630;
          }
          paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramacku.jdField_c_of_type_Int));
          i1 = Color.parseColor("#8EBDF9");
          break label1712;
          i2 = 0;
          break label1748;
          label2199:
          localObject = paramBitmap;
          if (!bool2) {
            break label1783;
          }
          localObject = String.format(getString(2131689529), new Object[0]);
          break label1783;
          label2226:
          i2 = 0;
          break label1807;
          label2232:
          paramaclb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1853;
          label2244:
          paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label1916;
          label2264:
          paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          paramaclb.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setVisibility(8);
          break label1916;
          label2284:
          paramaclb.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label2296:
          paramaclb.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        label2306:
        break label1387;
        label2308:
        paramaclb.f.setText("");
        break label1387;
        label2320:
        i1 = 0;
        break label1419;
        label2326:
        paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramaclb.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130848619);
        if (str.equals(paramacku.jdField_a_of_type_JavaLangString))
        {
          paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
          i1 = i3;
          break;
        }
        paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        label2386:
        if (this.jdField_d_of_type_Boolean)
        {
          if ((bool1) || ((!bool4) && (bool2)) || (bool5))
          {
            i1 = 1;
            label2416:
            if (i1 == 0) {
              break label2442;
            }
            paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(8);
            i1 = 0;
          }
          for (;;)
          {
            break;
            i1 = 0;
            break label2416;
            paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramacku.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.contains(paramacku.jdField_a_of_type_JavaLangString)))
            {
              paramaclb.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840202);
              i1 = 1;
            }
            else
            {
              paramaclb.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840198);
              i1 = 0;
            }
          }
        }
        label2442:
        if (this.jdField_d_of_type_Int == 20)
        {
          paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramacku.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.contains(paramacku)))
          {
            paramaclb.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840202);
            i1 = 1;
            break;
          }
          paramaclb.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840198);
          i1 = i3;
          break;
        }
        paramaclb.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramaclb.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i3;
        break;
        label2605:
        i2 = 0;
        break label647;
        label2611:
        paramaclb.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label660;
        label2623:
        paramacku = "未选中";
        break label827;
        label2630:
        paramBitmap = "";
        continue;
        label2636:
        i1 = 0;
        paramBitmap = "";
      }
      label2645:
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
      i1 = this.jdField_a_of_type_Ackw.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i1 + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        axqy.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_d_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    axqy.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (ajxl)this.app.getManager(51);
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
      axqy.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString2, paramString3, "");
    }
    axqy.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString3, "", "");
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
    //   94: invokevirtual 1911	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Laukq;
    //   97: invokevirtual 1917	aukq:createEntityManager	()Laukp;
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
    //   258: invokevirtual 1951	aukp:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   554: invokevirtual 1977	aukp:a	()V
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
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0) || (this.jdField_a_of_type_Ackw == null)) {
      break label16;
    }
    label16:
    while (this.jdField_a_of_type_Ackw.jdField_b_of_type_Int + this.jdField_a_of_type_Ackw.jdField_c_of_type_Int > 16) {
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
        localObject = (ajxl)this.app.getManager(51);
        this.jdField_c_of_type_JavaUtilList = ((ajvi)this.app.getManager(53)).a(paramString);
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
            paramString = a(paramString, (ajxl)localObject);
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
      localObject = this.jdField_a_of_type_Ackw.a();
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
    //   24: checkcast 609	ajxl
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 601	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 1911	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Laukq;
    //   36: invokevirtual 1917	aukq:createEntityManager	()Laukp;
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
    //   90: invokevirtual 2062	aukp:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
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
    //   126: invokevirtual 642	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Lajxl;)Lacku;
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
    //   27	98	6	localajxl	ajxl
    //   39	19	7	localaukp	aukp
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
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377859));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377369);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368421));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364005));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368431));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368457));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368441));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131377855));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368074));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131375056);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369309));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369490));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131367600));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369511));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697776));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368442));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843250);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131720435));
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
          acku localacku = (acku)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localacku != null) && (localacku.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131691870));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692601));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691874));
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131715576));
      }
      if (this.jdField_d_of_type_Int == 14) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689699));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839753);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acko(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696777));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690596);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839753);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ackp(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696779));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690596);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ackq(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131696608));
        if (this.jdField_h_of_type_JavaLangString == null) {
          this.jdField_h_of_type_JavaLangString = getString(2131690572);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839753);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697541);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        break;
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720538);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691961);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692601));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691874));
        break;
      }
      if (this.jdField_d_of_type_Int == 18)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720436);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131715567));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ackr(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 23)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720436);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131715634));
      if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_h_of_type_JavaLangString == null) {
        this.jdField_h_of_type_JavaLangString = getString(2131690572);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692601);
      if (this.jdField_d_of_type_Int != 4)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839753);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697776));
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
      this.jdField_a_of_type_Acky.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    bamk localbamk = (bamk)this.app.getManager(203);
    int i1 = 0;
    for (;;)
    {
      acku localacku;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label964;
        }
        localacku = (acku)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((this.jdField_r_of_type_Boolean) && (localbamk.b(localacku.jdField_a_of_type_JavaLangString))) {
          break label1142;
        }
        localacku.jdField_e_of_type_JavaLangString = "";
        localacku.jdField_f_of_type_JavaLangString = "";
        if ((paramString.equals(localacku.m)) || (paramString.equals(localacku.jdField_o_of_type_JavaLangString)) || (paramString.equals(localacku.jdField_n_of_type_JavaLangString)))
        {
          localacku.jdField_e_of_type_JavaLangString = localacku.m;
          localArrayList1.add(localacku);
          if (!QLog.isColorLevel()) {
            break label1142;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + localacku.jdField_a_of_type_JavaLangString + "," + localacku.jdField_e_of_type_JavaLangString);
        }
      }
      finally {}
      if ((paramString.equals(localacku.jdField_j_of_type_JavaLangString)) || (paramString.equals(localacku.l)) || (paramString.equals(localacku.jdField_k_of_type_JavaLangString)))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_j_of_type_JavaLangString;
        localArrayList1.add(localacku);
      }
      else if ((paramString.equals(localacku.jdField_g_of_type_JavaLangString)) || (paramString.equals(localacku.jdField_i_of_type_JavaLangString)) || (paramString.equals(localacku.jdField_h_of_type_JavaLangString)))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_g_of_type_JavaLangString;
        localArrayList1.add(localacku);
      }
      else if (paramString.equals(localacku.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localacku.jdField_e_of_type_JavaLangString = localacku.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localacku);
        }
      }
      else if ((localacku.m.indexOf(paramString) == 0) || (localacku.jdField_o_of_type_JavaLangString.indexOf(paramString) == 0) || (localacku.jdField_n_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.m;
        localacku.jdField_f_of_type_JavaLangString = localacku.jdField_n_of_type_JavaLangString;
        localArrayList2.add(localacku);
      }
      else if ((localacku.jdField_j_of_type_JavaLangString.indexOf(paramString) == 0) || (localacku.l.indexOf(paramString) == 0) || (localacku.jdField_k_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_j_of_type_JavaLangString;
        localacku.jdField_f_of_type_JavaLangString = localacku.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localacku);
      }
      else if ((localacku.jdField_g_of_type_JavaLangString.indexOf(paramString) == 0) || (localacku.jdField_i_of_type_JavaLangString.indexOf(paramString) == 0) || (localacku.jdField_h_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_g_of_type_JavaLangString;
        localacku.jdField_f_of_type_JavaLangString = localacku.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localacku);
      }
      else if (localacku.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localacku.jdField_e_of_type_JavaLangString = localacku.jdField_a_of_type_JavaLangString;
          localacku.jdField_f_of_type_JavaLangString = localacku.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localacku);
        }
      }
      else if ((localacku.m.indexOf(paramString) > 0) || (localacku.jdField_o_of_type_JavaLangString.indexOf(paramString) > 0) || (localacku.jdField_n_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.m;
        localArrayList3.add(localacku);
      }
      else if ((localacku.jdField_j_of_type_JavaLangString.indexOf(paramString) > 0) || (localacku.l.indexOf(paramString) > 0) || (localacku.jdField_k_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_j_of_type_JavaLangString;
        localArrayList3.add(localacku);
      }
      else if ((localacku.jdField_g_of_type_JavaLangString.indexOf(paramString) > 0) || (localacku.jdField_i_of_type_JavaLangString.indexOf(paramString) > 0) || (localacku.jdField_h_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_g_of_type_JavaLangString;
        localArrayList3.add(localacku);
      }
      else if ((localacku.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_e_of_type_Boolean))
      {
        localacku.jdField_e_of_type_JavaLangString = localacku.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localacku);
        continue;
        label964:
        Collections.sort(localArrayList2, new ackz(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Acky.notifyDataSetChanged();
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
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new acjg(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new acjh(this));
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 22)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new acji(this));
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
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new acjj(this));
        }
        else if (this.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new acjk(this));
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
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558428);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.jdField_d_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365146)).setText(getString(2131691851));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_Ajvg.b(Long.parseLong(this.jdField_a_of_type_JavaLangString), Long.valueOf(paramString).longValue());
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
    Object localObject1 = (ajxl)this.app.getManager(51);
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
            ThreadManager.post(new TroopMemberListActivity.1(this, paramIntent, (ajxl)localObject1, (TroopManager)localObject2), 8, null, true);
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
      localObject1 = bbcz.a(this.app, getApplicationContext(), paramIntent);
      localObject2 = actj.a(new Intent(this, SplashActivity.class), null);
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
    ThreadManager.post(new TroopMemberListActivity.2(this, (ajxl)localObject1), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_d_of_type_Int == 11) {
      axqy.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
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
    this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num_exceeds_wording", 2131697834);
    this.jdField_k_of_type_JavaLangString = ((Bundle)localObject).getString("param_pick_title_string", this.jdField_k_of_type_JavaLangString);
    this.jdField_r_of_type_Boolean = ((Bundle)localObject).getBoolean("param_filter_robot", false);
    if (this.jdField_d_of_type_Int == 17) {
      new axrc(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_b_of_type_JavaLangString }).a();
    }
    if (this.jdField_d_of_type_Int == 22) {
      bbbp.a("Grp_idol", "mber_list", "exp", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
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
        setTheme(2131755147);
      }
      super.doOnCreate(paramBundle);
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.jdField_e_of_type_Boolean + ", mTroopUin = " + this.jdField_b_of_type_JavaLangString);
      }
      setContentView(2131562546);
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
          ((akhp)this.app.a(20)).v(this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_m_of_type_Int == 5) {
          ((akhp)this.app.a(20)).w(this.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Ajvg = ((ajvg)this.app.a(6));
        this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
        this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
        paramBundle = (TroopManager)this.app.getManager(52);
        localObject = (ajvi)this.app.getManager(53);
        if ((paramBundle != null) && (localObject != null)) {
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((ajvi)localObject).a(this.jdField_b_of_type_JavaLangString);
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
      addObserver(this.jdField_a_of_type_Ajvj);
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
        this.jdField_j_of_type_Int = getResources().getDimensionPixelSize(2131298934);
        this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131296641);
        if (this.jdField_k_of_type_Int == 0) {
          this.jdField_k_of_type_Int = ((int)(paramBundle.density * 58.0F));
        }
        this.jdField_i_of_type_Int = (i1 - i2 - i3 - i4);
        this.jdField_l_of_type_Int = ((this.jdField_i_of_type_Int - this.jdField_j_of_type_Int) / this.jdField_k_of_type_Int);
        this.jdField_a_of_type_Ajry = new ajry(this);
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
      axqy.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_c_of_type_Boolean = true;
      }
      localObject = getResources().getStringArray(2130968679);
      paramBundle = getResources().getStringArray(2130968678);
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
        axqy.b(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_d_of_type_Int == 3) {
        ((akhp)this.app.a(20)).q(this.jdField_b_of_type_JavaLangString);
      }
      return true;
      this.app.addObserver(this.jdField_a_of_type_Akil, true);
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
      this.jdField_a_of_type_ArrayOfJavaLangString[i3] = getResources().getString(2131720565);
      if (i1 != 0) {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i3 + 1)] = getResources().getString(2131720564);
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
      this.jdField_b_of_type_ArrayOfJavaLangString[i2] = getResources().getString(2131720566);
      if (i1 == 0) {
        break label1521;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString[(i2 + 1)] = getResources().getString(2131720564);
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
      if (this.jdField_a_of_type_Ajry != null)
      {
        this.jdField_a_of_type_Ajry.c();
        this.jdField_a_of_type_Ajry = null;
      }
      try
      {
        removeObserver(this.jdField_a_of_type_Ajvj);
        removeObserver(this.jdField_a_of_type_Akil);
        label48:
        if (this.jdField_a_of_type_Acky != null) {
          this.jdField_a_of_type_Acky.c();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_Ackw != null) {
          this.jdField_a_of_type_Ackw.c();
        }
        if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
          this.jdField_a_of_type_Bfpc.dismiss();
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
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Ackw != null) {
        this.jdField_a_of_type_Ackw.a();
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
      if (this.jdField_a_of_type_Ajry != null) {
        this.jdField_a_of_type_Ajry.a();
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
    View localView = getLayoutInflater().inflate(2131562555, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131375675));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362514));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView;
    int i1;
    label124:
    int i2;
    label142:
    Object localObject;
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839132);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131378265);
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
        localObject = getString(2131720525);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375100);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368583)).setBackgroundDrawable(bbef.d());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372183);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new acjl(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acjm(this, (String)localObject));
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (akhp)this.app.a(20);
        if (bbfj.d(BaseApplication.getContext())) {
          break label855;
        }
        bcql.a(this, 1, 2131694608, 0).b(getTitleBarHeight());
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
        localObject = (akhp)this.app.a(20);
        if (bbfj.d(BaseApplication.getContext())) {
          break label964;
        }
        bcql.a(this, 1, 2131694608, 0).b(getTitleBarHeight());
      }
      label441:
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365763);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363479)).setVisibility(8);
      if (this.jdField_d_of_type_Int != 19) {
        break label1025;
      }
      localView = getLayoutInflater().inflate(2131562547, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new acjn(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ackw = new ackw(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Ackw);
      if ((this.jdField_d_of_type_Int == 19) || (this.jdField_d_of_type_Int == 21)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 19)) {
        t();
      }
      ((EditText)localObject).setOnTouchListener(new acjo(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_d_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839129);
      break;
      label845:
      i1 = 0;
      break label124;
      label850:
      i2 = 0;
      break label142;
      label855:
      if ((this.jdField_a_of_type_Ajvg != null) && (this.jdField_d_of_type_Int == 11)) {
        this.jdField_a_of_type_Ajvg.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839144);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject != null) {
          ((akhp)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        }
      }
      label954:
      i1 = 0;
      break label365;
      label959:
      i2 = 0;
      break label383;
      label964:
      if ((this.jdField_a_of_type_Ajvg != null) && (this.jdField_d_of_type_Int == 11))
      {
        this.jdField_a_of_type_Ajvg.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
        break label441;
      }
      if (localObject == null) {
        break label441;
      }
      ((akhp)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
      break label441;
      label1025:
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  protected void e(String paramString)
  {
    if (((bamk)this.app.getManager(203)).a(this, this.jdField_b_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131720524));
    if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131690572));
    }
    auvy.a(this.app, this, this.jdField_b_of_type_JavaLangString, paramString, 1, 1, localBundle);
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
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 16) && (bbfj.g(this)))
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
          localObject2 = (akhp)this.app.a(20);
          if (localObject2 != null)
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            ((akhp)localObject2).a(true, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, a(), this.jdField_a_of_type_Long, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_a_of_type_JavaLangString + " troopCode: " + this.jdField_b_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((akhp)localObject2).a(Long.parseLong(this.jdField_b_of_type_JavaLangString), 0L, 1, 0, 0);
        if (this.jdField_d_of_type_Int == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_troop_info_last_update" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (akhp)this.app.a(20);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              ((akhp)localObject2).j(this.jdField_b_of_type_JavaLangString);
              ((akhp)localObject2).a(1, ajsx.a(this.jdField_b_of_type_JavaLangString), 0L, 2, 0, 0, true);
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
        ((balh)this.app.getManager(113)).a(this.jdField_b_of_type_JavaLangString, new acju(this));
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
      arrayOfString = getResources().getStringArray(2130968673);
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 17) && (this.jdField_d_of_type_Int != 22)) {
        break label165;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
      i1 = arrayOfString.length;
      this.jdField_a_of_type_Bfpc = bfpc.a(this);
      i2 = 0;
      label65:
      if (i2 >= i1) {
        break label203;
      }
      if (!this.jdField_e_of_type_Boolean) {
        break label267;
      }
      if (!ajya.a(2131715602).equals(arrayOfString[i2])) {
        break label188;
      }
    }
    label267:
    for (;;)
    {
      i2 += 1;
      break label65;
      arrayOfString = getResources().getStringArray(2130968671);
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
        this.jdField_a_of_type_Bfpc.c(arrayOfString[i2]);
        label203:
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberKick == 1) && (arrayOfString.length >= 3)) {
          this.jdField_a_of_type_Bfpc.a(arrayOfString[3], 3);
        }
        this.jdField_a_of_type_Bfpc.c(2131690596);
        this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_Bfph);
        this.jdField_a_of_type_Bfpc.show();
        return;
        if (i2 == 3)
        {
          this.jdField_a_of_type_Bfpc.a(arrayOfString[i2], 3);
        }
        else
        {
          this.jdField_a_of_type_Bfpc.c(arrayOfString[i2]);
          if (arrayOfString[i2].equals(ajya.a(2131715562))) {
            axqy.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Ackw != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ackw.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Ackw.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Ackw.jdField_a_of_type_Int) }));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility();
    if (this.jdField_m_of_type_Int == 0) {
      if (this.jdField_d_of_type_Int == 11) {
        if ((this.jdField_a_of_type_Ackw != null) && (this.jdField_a_of_type_Ackw.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_Ackw.jdField_a_of_type_Int > 1)) {
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
        if ((this.jdField_a_of_type_Ackw != null) && (this.jdField_a_of_type_Ackw.jdField_b_of_type_Int + this.jdField_a_of_type_Ackw.jdField_c_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Ackw.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
        }
      }
      else if ((this.jdField_a_of_type_Ackw != null) && (this.jdField_a_of_type_Ackw.jdField_b_of_type_Int >= this.jdField_l_of_type_Int) && (this.jdField_a_of_type_Ackw.jdField_a_of_type_Int > 1))
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558428);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_d_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365146)).setText(getString(2131719292));
      return;
      label76:
      bool = false;
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Int == 11) {
      axqy.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new acjz(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new acka(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363479);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new ackb(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Acky.notifyDataSetChanged();
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
      ViewStub localViewStub = (ViewStub)findViewById(2131377896);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131377897)).setOnTouchListener(new ackn(this));
      }
    }
  }
  
  public void o()
  {
    if (!isResume()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Ackw != null) {}
      try
      {
        this.jdField_a_of_type_Ackw.notifyDataSetChanged();
        if (this.jdField_a_of_type_Acky == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_Acky.notifyDataSetChanged();
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