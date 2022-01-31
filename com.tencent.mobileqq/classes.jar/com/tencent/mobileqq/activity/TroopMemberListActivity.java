package com.tencent.mobileqq.activity;

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
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.ReqBody;
import txc;
import txd;
import txe;
import txf;
import txg;
import txh;
import txi;
import txj;
import txk;
import txl;
import txm;
import txn;
import txo;
import txq;
import txr;
import txs;
import txt;
import txu;
import txv;
import txw;
import txx;
import tyb;
import tyc;
import tyd;
import tye;
import tyf;
import tyg;
import tyh;
import tyj;
import tyk;
import tyl;
import tym;
import tyo;
import typ;
import tyw;
import tyx;
import tyy;
import tyz;
import tza;
import tzb;
import tzc;
import tzd;

public class TroopMemberListActivity
  extends BaseActivity
  implements IndexView.OnIndexChangedListener, IndexView.OnIndexChangedListener2, AdapterView.OnItemClickListener
{
  public static double b;
  private static int l;
  public double a;
  protected float a;
  public int a;
  public long a;
  public Dialog a;
  protected Drawable a;
  public Handler a;
  protected LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  protected RelativeLayout a;
  public TextView a;
  public TroopMemberListActivity.ListAdapter a;
  public TroopMemberListActivity.SearchResultAdapter a;
  protected DiscussionHandler a;
  public DiscussionObserver a;
  public TroopObserver a;
  protected DiscussionInfo a;
  public TroopInfo a;
  public TroopInfoData a;
  protected IndexView a;
  protected ActionSheet.OnButtonClickListener a;
  public ActionSheet a;
  public PinnedDividerSwipListView a;
  public PopupMenuDialog a;
  protected XListView a;
  protected String a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  public ArrayList a;
  public List a;
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
  protected ArrayList b;
  public List b;
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
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List c;
  public boolean c;
  private long[] jdField_c_of_type_ArrayOfLong;
  public int d;
  private long jdField_d_of_type_Long;
  public View.OnClickListener d;
  protected View d;
  public RelativeLayout d;
  public TextView d;
  protected String d;
  private ArrayList jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  protected List d;
  public boolean d;
  public int e;
  private View jdField_e_of_type_AndroidViewView;
  protected RelativeLayout e;
  protected TextView e;
  public String e;
  private ArrayList jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  public List e;
  public boolean e;
  protected int f;
  public String f;
  private ArrayList f;
  protected List f;
  public boolean f;
  protected int g;
  public String g;
  private ArrayList jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_g_of_type_JavaUtilList = new ArrayList();
  protected boolean g;
  public int h;
  protected String h;
  public boolean h;
  public int i;
  public String i;
  protected boolean i;
  private int j;
  protected String j;
  protected boolean j;
  private int k;
  protected String k;
  public boolean k;
  protected String l;
  public boolean l;
  protected String m;
  private boolean m;
  public String n;
  private boolean n;
  public String o;
  private boolean o;
  public final String p;
  private boolean p;
  public final String q;
  private boolean q;
  public final String r = "param_deleted_uins";
  protected String s = "";
  public String t = "";
  public String u = "";
  public String v;
  private String w = "老师和管理员";
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
    jdField_l_of_type_Int = 1000;
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
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_p_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new tzd(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new txd(this);
    this.jdField_i_of_type_Int = 0;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new txx(this);
    this.jdField_a_of_type_AndroidOsHandler = new tyg(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new tyh(this);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_j_of_type_Int = -1;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new tyj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new tym(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new typ(this);
  }
  
  private int a()
  {
    int i1 = 1;
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_n_of_type_Boolean) {
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
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131363039);
    int i1 = 0;
    if (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)((View)localObject).getTag();
      if (localMenuItem != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131374727);
        if (localObject != null)
        {
          if (localMenuItem.jdField_a_of_type_Int != paramInt) {
            break label98;
          }
          ((TextView)localObject).setTextColor(getResources().getColor(2131494216));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label98:
        ((TextView)localObject).setTextColor(getResources().getColor(2131494207));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_d_of_type_Int == 20) || (this.jdField_d_of_type_Int == 21)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("加载中...(%d%%)", new Object[] { Integer.valueOf(paramInt3) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("加载中...(%d/%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      QLog.d(".troop.troopManagerVASH", 2, new Object[] { "obj.length==3, refreshUI List count: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        p();
        h();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter == null) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = new TroopMemberListActivity.ListAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x74f.ReqBody localReqBody = new oidb_cmd0x74f.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    ProtoUtils.b(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
  }
  
  private void a(List paramList)
  {
    if (paramList.size() < 1) {
      return;
    }
    Dialog localDialog = new Dialog(this, 2131624515);
    localDialog.setContentView(2130968978);
    ((TextView)localDialog.findViewById(2131364010)).setText(getString(2131433103));
    TextView localTextView = (TextView)localDialog.findViewById(2131362758);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131363662);
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
    if (paramList.size() == 1)
    {
      localTextView.setText(getString(2131433111));
      localCheckBox.setText(getString(2131433113));
    }
    for (;;)
    {
      localTextView = (TextView)localDialog.findViewById(2131364013);
      localObject = (TextView)localDialog.findViewById(2131364014);
      localTextView.setText(17039360);
      ((TextView)localObject).setText(17039370);
      localTextView.setOnClickListener(new tyk(this, localDialog));
      ((TextView)localObject).setOnClickListener(new tyl(this, paramList, localCheckBox, localDialog));
      localDialog.show();
      return;
      localTextView.setText(getString(2131433112));
      localCheckBox.setText(getString(2131433114));
    }
  }
  
  private void a(List paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "processConvertTroopMemberInfo2AtTroopMember, processIndex:" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.app.getManager(202);
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.get(i1);
      if (localTroopMemberInfo != null)
      {
        if (!Utils.d(localTroopMemberInfo.memberuin)) {
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
        if (((this.jdField_f_of_type_JavaUtilList == null) || (!this.jdField_f_of_type_JavaUtilList.contains(localTroopMemberInfo.memberuin))) && ((this.jdField_d_of_type_Int != 20) || (!localTroopRobotManager.b(localTroopMemberInfo.memberuin))) && (!localTroopMemberInfo.memberuin.equals("50000000")))
        {
          localArrayList.add(a(localTroopMemberInfo, localFriendsManager));
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
  
  private void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetAtAllRemianCountInfo:" + paramBoolean1 + ", " + paramString1 + ", " + paramBoolean2 + ", " + paramInt1 + ", " + paramString2 + ", " + paramString3);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375162)).setCompoundDrawables(null, null, null, null);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(true);
      if ((paramBoolean1) && (paramString1 != null)) {
        break label173;
      }
    }
    label173:
    TextView localTextView;
    Button localButton;
    int i1;
    do
    {
      return;
      ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363531)).setTextColor(getResources().getColor(2131494207));
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375162);
      localButton = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375164);
      localButton.setVisibility(8);
      localButton.setOnClickListener(new tyw(this));
      i1 = ((SVIPHandler)this.app.a(13)).j();
      if (this.jdField_d_of_type_Int != 11) {
        break;
      }
    } while (!paramString1.equals(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Int = paramInt2;
    if ((paramBoolean2) && (paramInt1 > 0))
    {
      paramBoolean1 = true;
      label303:
      this.jdField_f_of_type_Boolean = paramBoolean1;
      if (!this.jdField_f_of_type_Boolean) {
        break label448;
      }
      this.jdField_g_of_type_JavaLangString = ("剩余" + paramInt1 + "次");
      localTextView.setText(this.jdField_g_of_type_JavaLangString);
      paramString1 = "@全体成员" + "," + this.jdField_g_of_type_JavaLangString;
      label385:
      paramString2 = paramString1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramString2 = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
        paramString2.rightMargin = AIOUtils.a(20.0F, getResources());
        localTextView.setLayoutParams(paramString2);
      }
    }
    for (paramString2 = paramString1;; paramString2 = "@全体成员" + "," + paramString1)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramString2);
      return;
      paramBoolean1 = false;
      break label303;
      label448:
      if (paramInt1 == 0)
      {
        this.jdField_g_of_type_JavaLangString = "该功能的使用次数已用完";
        paramString1 = "@全体成员" + ",剩余0次";
        localTextView.setText("剩余0次");
        break label385;
      }
      this.jdField_g_of_type_JavaLangString = "";
      paramString1 = "@全体成员" + ",现在无法发送@All消息";
      localTextView.setText("");
      break label385;
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
          localButton.setVisibility(0);
          paramString2 = paramString2 + ",\n超级会员可继续使用";
          localTextView.setGravity(21);
          localTextView.setLineSpacing(this.jdField_a_of_type_Float * 5.0F, 1.0F);
          paramInt1 = (int)("超级会员可继续使用".length() * 12 * this.jdField_a_of_type_Float);
          new DisplayMetrics();
          paramInt2 = (int)(getResources().getDisplayMetrics().widthPixels - 227.0F * this.jdField_a_of_type_Float - 5.0F * this.jdField_a_of_type_Float);
          paramString1 = paramString2;
          if (paramInt1 > paramInt2)
          {
            localTextView.setSingleLine(false);
            localTextView.setLines(2);
            localTextView.setWidth(paramInt2);
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
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
      if (paramString1.contains("超级会员"))
      {
        paramInt1 = paramString1.indexOf("超级会员");
        paramInt2 = "超级会员".length();
        paramString2.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
      }
      localTextView.setText(paramString2);
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
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localMenuItem.jdField_a_of_type_Int = i1;
        localMenuItem.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        localArrayList.add(localMenuItem);
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new tyc(this), null, UIUtils.a(this, 135.0F), true);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setTouchInterceptor(new tyo(this));
      a(this.jdField_i_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(this.jdField_b_of_type_AndroidWidgetImageView, -(UIUtils.a(this, 135.0F) - this.jdField_b_of_type_AndroidWidgetImageView.getWidth()), 0);
  }
  
  private void p()
  {
    if (((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(this.app.getCurrentAccountUin()))) || ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((!this.jdField_e_of_type_Boolean) && (i1 != 0) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 17)) && (System.currentTimeMillis() > this.jdField_c_of_type_Long)) {
        ThreadManager.post(new txo(this), 8, null, true);
      }
      return;
    }
  }
  
  private void q()
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_e_of_type_AndroidViewView = getLayoutInflater().inflate(2130971631, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131375148);
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
      localObject = (TroopMemberListActivity.ATroopMember)localIterator.next();
      if (((TroopMemberListActivity.ATroopMember)localObject).jdField_b_of_type_Long == 0L) {
        ((TroopMemberListActivity.ATroopMember)localObject).jdField_b_of_type_Long = ((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_Long;
      }
      if (TextUtils.isEmpty(a(((TroopMemberListActivity.ATroopMember)localObject).jdField_b_of_type_Long, localCalendar, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList))) {
        break label349;
      }
      i1 += 1;
    }
    label349:
    for (;;)
    {
      break;
      localTextView.setText(i1 + "");
      if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {}
      for (int i2 = 0;; i2 = 1)
      {
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new txq(this, i1, i2));
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(this.jdField_e_of_type_AndroidViewView);
        ReportController.b(this.app, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.jdField_b_of_type_JavaLangString, "" + i2, "", "");
        return;
      }
    }
  }
  
  private void r()
  {
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_b_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2130971476);
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
      int i1 = getResources().getColor(2131494247);
      new SystemBarCompact(this.jdField_b_of_type_AndroidAppDialog, true, i1).init();
      View localView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362822);
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.b(), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365642));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838210));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter = new TroopMemberListActivity.SearchResultAdapter(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new txr(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131368255));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopMemberListActivity.SearchTextWatcher(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362822);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131368256));
    this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363902);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363900));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new txs(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new txt(this));
  }
  
  private void s()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      String str = MessageFormat.format("删除({0})", new Object[] { Integer.valueOf(i1) });
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new tyb(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("删除");
  }
  
  private void t()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(0, this.jdField_k_of_type_Int, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, 800L);
  }
  
  public TroopMemberListActivity.ATroopMember a(DiscussionMemberInfo paramDiscussionMemberInfo, FriendsManager paramFriendsManager)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramDiscussionMemberInfo.memberUin.trim();
    Friends localFriends = null;
    if (paramFriendsManager != null) {
      localFriends = paramFriendsManager.a(paramDiscussionMemberInfo.memberUin);
    }
    localATroopMember.jdField_b_of_type_JavaLangString = paramDiscussionMemberInfo.getDiscussionMemberName();
    localATroopMember.jdField_a_of_type_Short = 0;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localATroopMember.e(localFriends.remark);
      localATroopMember.h(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 2));
    }
    for (;;)
    {
      if ((paramDiscussionMemberInfo.memberName != null) && (paramDiscussionMemberInfo.memberName.length() > 0))
      {
        localATroopMember.i(paramDiscussionMemberInfo.memberName);
        localATroopMember.k(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 1));
        localATroopMember.j(ChnToSpell.a(paramDiscussionMemberInfo.memberName, 2));
      }
      return localATroopMember;
      if ((paramDiscussionMemberInfo.inteRemark != null) && (paramDiscussionMemberInfo.inteRemark.length() > 0))
      {
        localATroopMember.e(paramDiscussionMemberInfo.inteRemark);
        localATroopMember.h(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 1));
        localATroopMember.f(ChnToSpell.a(paramDiscussionMemberInfo.inteRemark, 2));
      }
    }
  }
  
  public TroopMemberListActivity.ATroopMember a(TroopMemberInfo paramTroopMemberInfo, FriendsManager paramFriendsManager)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    Friends localFriends = null;
    if (paramFriendsManager != null) {
      localFriends = paramFriendsManager.a(paramTroopMemberInfo.memberuin);
    }
    localATroopMember.jdField_b_of_type_JavaLangString = ContactUtils.g(this.app, this.jdField_b_of_type_JavaLangString, localATroopMember.jdField_a_of_type_JavaLangString);
    localATroopMember.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 2);
    localATroopMember.a(ChnToSpell.a(localATroopMember.jdField_b_of_type_JavaLangString, 1));
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localATroopMember.b(paramTroopMemberInfo.friendnick);
      localATroopMember.d(paramTroopMemberInfo.pyAll_friendnick);
      localATroopMember.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    double d1;
    if ((localFriends != null) && (localFriends.isFriend()) && (localFriends.remark != null) && (localFriends.remark.length() > 0))
    {
      localATroopMember.e(localFriends.remark);
      localATroopMember.h(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 2));
      localATroopMember.g(localFriends.remark);
      if ((paramTroopMemberInfo.troopnick != null) && (paramTroopMemberInfo.troopnick.length() > 0))
      {
        localATroopMember.i(paramTroopMemberInfo.troopnick);
        localATroopMember.k(paramTroopMemberInfo.pyAll_troopnick);
        localATroopMember.j(paramTroopMemberInfo.pyFirst_troopnick);
      }
      localATroopMember.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
      localATroopMember.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
      localATroopMember.jdField_a_of_type_Int = paramTroopMemberInfo.level;
      localATroopMember.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
      localATroopMember.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
      localATroopMember.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
      localATroopMember.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
      localATroopMember.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
      localATroopMember.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
      d1 = ((TroopManager)this.app.getManager(51)).a(this.jdField_b_of_type_JavaLangString, localATroopMember.jdField_a_of_type_JavaLangString);
      if ((d1 == -1000.0D) || (d1 == -100.0D)) {
        break label593;
      }
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
    }
    label593:
    for (localATroopMember.t = ("(" + this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km)");; localATroopMember.t = "")
    {
      if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
      {
        localATroopMember.u = paramTroopMemberInfo.mUniqueTitle;
        localATroopMember.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
      }
      return localATroopMember;
      if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0)) {
        break;
      }
      if ((this.jdField_e_of_type_Boolean) && (paramTroopMemberInfo.autoremark.equals(paramTroopMemberInfo.memberuin)))
      {
        localATroopMember.e("群成员");
        localATroopMember.h(ChnToSpell.a("群成员", 1));
        localATroopMember.f(ChnToSpell.a("群成员", 2));
        break;
      }
      localATroopMember.e(paramTroopMemberInfo.autoremark);
      localATroopMember.h(paramTroopMemberInfo.pyAll_autoremark);
      localATroopMember.f(paramTroopMemberInfo.pyFirst_autoremark);
      break;
    }
  }
  
  public TroopMemberListActivity.ATroopMember a(String paramString)
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
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            paramString = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.remove(i1);
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
  
  public TroopMemberListActivity.TmViewHolder a(String paramString, boolean paramBoolean)
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
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof TroopMemberListActivity.TmViewHolder)))
      {
        localObject2 = (TroopMemberListActivity.TmViewHolder)((View)localObject2).getTag();
        if ((((TroopMemberListActivity.TmViewHolder)localObject2).jdField_a_of_type_JavaLangString != null) && (((TroopMemberListActivity.TmViewHolder)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
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
  
  public String a(long paramLong, Calendar paramCalendar, ArrayList paramArrayList1, ArrayList paramArrayList2)
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
  
  protected List a(List paramList, String paramString1, String paramString2)
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
        TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)paramList.get(i1);
        if ((paramString1 != null) && (paramString1.equals(localATroopMember.jdField_a_of_type_JavaLangString)))
        {
          paramList.remove(i1);
          paramList.add(0, localATroopMember);
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
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i3);
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
        paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i4);
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
          paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i2);
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
            paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i2);
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
              paramString1 = (TroopMemberListActivity.ATroopMember)paramList.get(i2);
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
    Object localObject = (ViewGroup)findViewById(2131363226);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131362577);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131363227);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void a(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    int i1 = 3;
    if ((paramATroopMember != null) && (paramATroopMember.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
      paramATroopMember = new Intent();
      paramATroopMember.putExtra("result", new JSONArray().toString());
      setResult(-1, paramATroopMember);
      ReportController.b(this.app, "P_CliOper", "Grp_work", "", "create", "Clk_none", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      finish();
    }
    label578:
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramATroopMember == null) || (paramATroopMember.jdField_a_of_type_JavaLangString == null));
        if (this.jdField_d_of_type_Int == 1)
        {
          if (this.app.getCurrentAccountUin().equals(paramATroopMember.jdField_a_of_type_JavaLangString))
          {
            localObject1 = new ProfileActivity.AllInOne(paramATroopMember.jdField_a_of_type_JavaLangString, 0);
            ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = ContactUtils.j(this.app, paramATroopMember.jdField_a_of_type_JavaLangString);
            ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 3;
            ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 4;
            ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
            return;
          }
          a(paramATroopMember.jdField_a_of_type_JavaLangString, paramATroopMember.jdField_b_of_type_JavaLangString);
          return;
        }
        Object localObject2;
        if (this.jdField_d_of_type_Int == 2)
        {
          localObject1 = getIntent();
          ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
          localObject2 = new TroopMemberListActivity.TroopAdmin();
          ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
          ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_a_of_type_Short = paramATroopMember.jdField_a_of_type_Short;
          ((TroopMemberListActivity.TroopAdmin)localObject2).jdField_b_of_type_JavaLangString = paramATroopMember.jdField_b_of_type_JavaLangString;
          ((Intent)localObject1).putExtra("member_info", (Parcelable)localObject2);
          setResult(-1, (Intent)localObject1);
          finish();
          return;
        }
        if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
        {
          localObject1 = getIntent();
          if (this.jdField_n_of_type_Boolean)
          {
            ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("isApollo", true);
          }
          for (;;)
          {
            ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
            setResult(-1, (Intent)localObject1);
            finish();
            return;
            ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
          }
        }
        if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 4) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 15) || (this.jdField_d_of_type_Int == 17))
        {
          e(paramATroopMember.jdField_a_of_type_JavaLangString);
          return;
        }
        if (this.jdField_d_of_type_Int == 5)
        {
          if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramATroopMember.jdField_a_of_type_JavaLangString)))
          {
            startActivityForResult(EditUniqueTitleActivity.a(this, 1, this.jdField_b_of_type_JavaLangString, paramATroopMember.jdField_a_of_type_JavaLangString, i1, paramATroopMember.u), 2);
            this.v = paramATroopMember.jdField_a_of_type_JavaLangString;
            localObject1 = this.app;
            localObject2 = this.jdField_b_of_type_JavaLangString;
            i1 = this.jdField_i_of_type_Int;
            if (!this.jdField_l_of_type_Boolean) {
              break label578;
            }
          }
          for (paramATroopMember = "1";; paramATroopMember = "0")
          {
            ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, (String)localObject2, String.valueOf(i1), paramATroopMember, "");
            return;
            if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
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
          ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("member_display_name", paramATroopMember.jdField_b_of_type_JavaLangString);
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
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
            paramATroopMember = new Intent();
            localObject1 = new JSONArray();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)((Iterator)localObject2).next();
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("uin", localATroopMember.jdField_a_of_type_JavaLangString);
                    localJSONObject.put("nick", localATroopMember.jdField_b_of_type_JavaLangString);
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
            paramATroopMember.putExtra("result", ((JSONArray)localObject1).toString());
            setResult(-1, paramATroopMember);
            finish();
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.remove(paramATroopMember);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.size() < this.jdField_f_of_type_Int)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
            }
            else if (this.jdField_f_of_type_Int == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.add(paramATroopMember);
            }
            else
            {
              QQToast.a(this, getResources().getString(this.jdField_h_of_type_Int, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).a();
            }
          }
        }
      } while ((this.jdField_d_of_type_Int != 18) && (this.jdField_d_of_type_Int != 19));
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("member_uin", paramATroopMember.jdField_a_of_type_JavaLangString);
      PublicFragmentActivity.a(this, (Intent)localObject1, TroopMemberHistoryFragment.class);
    } while (this.jdField_d_of_type_Int != 19);
    paramATroopMember = ((TroopManager)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
    TroopReportor.a("Grp_edu", "teachermsg", "showsomeone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(paramATroopMember) });
  }
  
  protected void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    label76:
    Object localObject;
    label144:
    label170:
    label364:
    int i2;
    if (paramBoolean1)
    {
      str = this.u;
      paramTmViewHolder.jdField_a_of_type_Boolean = paramBoolean1;
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramTmViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      if (this.jdField_i_of_type_Int != 1) {
        break label823;
      }
      if (paramATroopMember.jdField_d_of_type_Boolean) {
        break label810;
      }
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(165);
      if ((this.jdField_b_of_type_Boolean) || (a()) || (paramATroopMember.jdField_d_of_type_Int == -100) || (paramATroopMember.jdField_d_of_type_Int == 0)) {
        break label845;
      }
      paramTmViewHolder.k.setVisibility(0);
      paramTmViewHolder.k.setText("LV" + paramATroopMember.jdField_d_of_type_Int);
      if ((this.jdField_o_of_type_Boolean) && (!TextUtils.isEmpty(paramATroopMember.t))) {
        break label857;
      }
      paramTmViewHolder.l.setVisibility(8);
      if ((this.jdField_d_of_type_Int != 13) || (!paramBoolean1)) {
        break label879;
      }
      paramBitmap = paramATroopMember.jdField_b_of_type_JavaLangString + "(" + paramATroopMember.jdField_a_of_type_JavaLangString + ")";
      localObject = new SpannableString(paramBitmap);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-7829368), paramATroopMember.jdField_b_of_type_JavaLangString.length(), paramBitmap.length(), 18);
      paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label268:
      if ((paramBoolean2) && (paramTmViewHolder.m != null))
      {
        paramBitmap = "好友备注: " + paramATroopMember.jdField_j_of_type_JavaLangString;
        paramTmViewHolder.m.setText(paramBitmap);
      }
      paramTmViewHolder.jdField_a_of_type_JavaLangString = paramATroopMember.jdField_a_of_type_JavaLangString;
      paramTmViewHolder.jdField_c_of_type_Int = 1;
      paramTmViewHolder.g.setText("");
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean1));
      if (this.jdField_d_of_type_Int != 9) {
        break label912;
      }
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.h.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label927;
      }
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(true);
      if (this.jdField_d_of_type_Boolean) {
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      }
      label445:
      i2 = 0;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13)) {
        break label1057;
      }
      paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433999) + paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845391);
      if (this.jdField_d_of_type_Int != 13) {
        break label974;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label534:
      if (!str.equals(paramATroopMember.jdField_a_of_type_JavaLangString)) {
        break label1046;
      }
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
    }
    int i1;
    for (;;)
    {
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(String.format(getString(2131433996), new Object[] { paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText().toString() }));
      paramTmViewHolder.h.setContentDescription(getString(2131433997));
      i1 = i2;
      if (this.jdField_e_of_type_Boolean) {
        paramTmViewHolder.k.setVisibility(8);
      }
      paramBitmap = new StringBuffer();
      paramBitmap.append(paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
      if ((paramBoolean2) && (paramTmViewHolder.m != null)) {
        paramBitmap.append(paramTmViewHolder.m.getText());
      }
      if (paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        paramBitmap.append(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      }
      if (paramTmViewHolder.k.getVisibility() == 0) {
        paramBitmap.append(paramTmViewHolder.k.getText().toString());
      }
      if ((paramTmViewHolder.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_Boolean))
      {
        if (i1 == 0) {
          break label2217;
        }
        paramATroopMember = "已选中";
        label753:
        paramBitmap.append(paramATroopMember);
      }
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setContentDescription(paramBitmap.toString());
      return;
      str = this.t;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0)
      {
        paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      paramTmViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
      label810:
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      break label76;
      label823:
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
      paramTmViewHolder.k.setVisibility(8);
      break label76;
      label845:
      paramTmViewHolder.k.setVisibility(8);
      break label144;
      label857:
      paramTmViewHolder.l.setVisibility(0);
      paramTmViewHolder.l.setText(paramATroopMember.t);
      break label170;
      label879:
      if (paramBoolean2)
      {
        paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramATroopMember.jdField_g_of_type_JavaLangString);
        break label268;
      }
      paramTmViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramATroopMember.jdField_b_of_type_JavaLangString);
      break label268;
      label912:
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(paramBoolean1));
      break label364;
      label927:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
        break label445;
      }
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramTmViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      break label445;
      label974:
      if (this.jdField_d_of_type_Int == 21)
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      if ((this.jdField_e_of_type_JavaLangString != null) && (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString)))
      {
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label534;
      }
      paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      break label534;
      label1046:
      paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    }
    label1057:
    paramTmViewHolder.f.setVisibility(8);
    paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
    label1088:
    boolean bool1;
    label1112:
    boolean bool2;
    label1143:
    boolean bool4;
    int i3;
    if (!TextUtils.isEmpty(paramATroopMember.u))
    {
      paramBoolean1 = true;
      if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_e_of_type_JavaLangString))) {
        break label1362;
      }
      bool1 = true;
      if ((this.jdField_f_of_type_JavaLangString == null) || (paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.contains(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        break label1368;
      }
      bool2 = true;
      bool4 = this.app.getCurrentAccountUin().equals(this.jdField_e_of_type_JavaLangString);
      if (this.jdField_d_of_type_Int != 5) {
        break label1493;
      }
      paramTmViewHolder.i.setVisibility(0);
      paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTmViewHolder.j.setVisibility(0);
      localObject = "";
      i3 = 0;
      if (!paramBoolean1) {
        break label1374;
      }
      paramBitmap = TroopRankConfig.a().a(302, paramBoolean1, bool1, bool2);
      if (paramBitmap == null) {
        break label2239;
      }
      i1 = paramBitmap.jdField_b_of_type_Int;
      paramBitmap = paramATroopMember.u;
    }
    for (;;)
    {
      label1235:
      if (!TextUtils.isEmpty(paramBitmap))
      {
        paramTmViewHolder.i.setText(paramBitmap);
        TroopRankConfig.a(paramTmViewHolder.i, i1);
      }
      for (;;)
      {
        label1259:
        paramBitmap = (TroopRobotManager)this.app.getManager(202);
        if ((paramBitmap == null) || (!paramBitmap.b(paramATroopMember.jdField_a_of_type_JavaLangString))) {
          break label1927;
        }
        i1 = 1;
        label1291:
        if (!this.jdField_c_of_type_Boolean) {
          break label1993;
        }
        if ((this.jdField_d_of_type_Int == 21) || ((!bool1) && ((bool4) || (!bool2)) && ((bool4) || (i1 == 0)))) {
          break label1933;
        }
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i2;
        break;
        paramBoolean1 = false;
        break label1088;
        label1362:
        bool1 = false;
        break label1112;
        label1368:
        bool2 = false;
        break label1143;
        label1374:
        if (bool1)
        {
          localTroopRankItem = TroopRankConfig.a().a(300, paramBoolean1, bool1, bool2);
          i1 = i3;
          paramBitmap = (Bitmap)localObject;
          if (localTroopRankItem == null) {
            break label1235;
          }
          i1 = localTroopRankItem.jdField_b_of_type_Int;
          paramBitmap = localTroopRankItem.jdField_a_of_type_JavaLangString;
          break label1235;
        }
        i1 = i3;
        paramBitmap = (Bitmap)localObject;
        if (!bool2) {
          break label1235;
        }
        TroopRankConfig.TroopRankItem localTroopRankItem = TroopRankConfig.a().a(301, paramBoolean1, bool1, bool2);
        i1 = i3;
        paramBitmap = (Bitmap)localObject;
        if (localTroopRankItem == null) {
          break label1235;
        }
        i1 = localTroopRankItem.jdField_b_of_type_Int;
        paramBitmap = localTroopRankItem.jdField_a_of_type_JavaLangString;
        break label1235;
        paramTmViewHolder.i.setVisibility(8);
      }
      label1493:
      i1 = 0;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop();
      }
      if ((bool3) || (this.jdField_b_of_type_Boolean))
      {
        localObject = TroopRankConfig.a().a(bool1, bool2);
        if (localObject == null) {
          break label2230;
        }
        paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
        i1 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
      }
      for (;;)
      {
        label1557:
        if (this.jdField_d_of_type_Int == 11) {
          paramBitmap = "";
        }
        if ((!TextUtils.isEmpty(paramBitmap)) && (!a()))
        {
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramBitmap);
          TroopRankConfig.a(paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView, i1);
          label1608:
          if (this.jdField_b_of_type_Boolean)
          {
            paramBitmap = TroopRankConfig.a().a(paramATroopMember.jdField_a_of_type_Int, false, false, false);
            if ((paramBitmap == null) || (!HWTroopUtils.a(paramATroopMember.jdField_a_of_type_Int))) {
              break label1903;
            }
            if (TextUtils.isEmpty(paramBitmap.jdField_a_of_type_JavaLangString)) {
              break label1891;
            }
            paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramBitmap.jdField_a_of_type_JavaLangString);
            TroopRankConfig.a(paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView, paramBitmap.jdField_b_of_type_Int);
          }
        }
        for (;;)
        {
          if ((this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 12)) {
            break label1913;
          }
          if ((paramATroopMember.jdField_a_of_type_JavaLangString == null) || (!paramATroopMember.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
            break label1915;
          }
          paramTmViewHolder.g.setText(getString(2131433099));
          break;
          localObject = TroopRankConfig.a().a(paramATroopMember.jdField_a_of_type_Int, paramBoolean1, bool1, bool2);
          if (localObject != null)
          {
            paramBitmap = ((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_JavaLangString;
            i3 = ((TroopRankConfig.TroopRankItem)localObject).jdField_b_of_type_Int;
            if (((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_Int == 302) {
              paramBitmap = paramATroopMember.u;
            }
            i1 = i3;
            if (((TroopRankConfig.TroopRankItem)localObject).jdField_a_of_type_Int != 315) {
              break label1557;
            }
            paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_c_of_type_Int));
            i1 = i3;
            break label1557;
          }
          if (paramATroopMember.jdField_a_of_type_Int != 315) {
            break label2224;
          }
          paramBitmap = (String)this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramATroopMember.jdField_c_of_type_Int));
          i1 = Color.parseColor("#8EBDF9");
          break label1557;
          paramTmViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1608;
          label1891:
          paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          label1903:
          paramTmViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        label1913:
        break label1259;
        label1915:
        paramTmViewHolder.g.setText("");
        break label1259;
        label1927:
        i1 = 0;
        break label1291;
        label1933:
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845391);
        if (str.equals(paramATroopMember.jdField_a_of_type_JavaLangString))
        {
          paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
          i1 = i2;
          break;
        }
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i2;
        break;
        label1993:
        if (this.jdField_d_of_type_Boolean)
        {
          if ((bool1) || ((!bool4) && (bool2)) || ((!bool4) && (i1 != 0)))
          {
            i1 = 1;
            label2028:
            if (i1 == 0) {
              break label2054;
            }
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
            i1 = 0;
          }
          for (;;)
          {
            break;
            i1 = 0;
            break label2028;
            paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.contains(paramATroopMember.jdField_a_of_type_JavaLangString)))
            {
              paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839270);
              i1 = 1;
            }
            else
            {
              paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839268);
              i1 = 0;
            }
          }
        }
        label2054:
        if (this.jdField_d_of_type_Int == 20)
        {
          paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if ((paramATroopMember.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.contains(paramATroopMember)))
          {
            paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839270);
            i1 = 1;
            break;
          }
          paramTmViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839268);
          i1 = i2;
          break;
        }
        paramTmViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramTmViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        i1 = i2;
        break;
        label2217:
        paramATroopMember = "未选中";
        break label753;
        label2224:
        paramBitmap = "";
        continue;
        label2230:
        i1 = 0;
        paramBitmap = "";
      }
      label2239:
      i1 = 0;
      paramBitmap = "";
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void a(String paramString)
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
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localATroopMember != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
  
  public void a(String paramString, int paramInt)
  {
    if ("$".equals(paramString)) {
      if ((this.jdField_d_of_type_Int == 11) && (paramInt == 1)) {
        ReportController.b(this.app, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
      }
    }
    while ((this.jdField_d_of_type_Int != 11) || (paramInt != 0)) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString2 = (FriendsManager)this.app.getManager(50);
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
      ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString2, paramString3, "");
    }
    ReportController.b(this.app, "P_CliOper", "Grp_pay", "", paramString2, paramString1, 0, 0, this.jdField_b_of_type_JavaLangString, paramString3, "", "");
    return;
  }
  
  /* Error */
  public void a(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 427 1 0
    //   11: aload_0
    //   12: dconst_0
    //   13: putfield 217	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_a_of_type_Double	D
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 219	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_j_of_type_Int	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 244	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_k_of_type_Int	I
    //   26: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc_w 556
    //   35: iconst_2
    //   36: new 558	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1728
    //   46: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 896	java/lang/System:currentTimeMillis	()J
    //   63: putfield 247	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   66: aload_2
    //   67: ifnull +15 -> 82
    //   70: aload_2
    //   71: astore 8
    //   73: aload_2
    //   74: invokeinterface 1730 1 0
    //   79: ifeq +508 -> 587
    //   82: new 108	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 109	java/util/ArrayList:<init>	()V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 579	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 1734	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   97: invokevirtual 1740	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_1
    //   105: ldc_w 595
    //   108: invokevirtual 1745	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: bipush 18
    //   113: anewarray 336	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 1746
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 1747
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 1748
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 1749
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: ldc_w 1750
    //   145: aastore
    //   146: dup
    //   147: iconst_5
    //   148: ldc_w 1751
    //   151: aastore
    //   152: dup
    //   153: bipush 6
    //   155: ldc_w 1752
    //   158: aastore
    //   159: dup
    //   160: bipush 7
    //   162: ldc_w 1753
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: ldc_w 1754
    //   172: aastore
    //   173: dup
    //   174: bipush 9
    //   176: ldc_w 1756
    //   179: aastore
    //   180: dup
    //   181: bipush 10
    //   183: ldc_w 1758
    //   186: aastore
    //   187: dup
    //   188: bipush 11
    //   190: ldc_w 1759
    //   193: aastore
    //   194: dup
    //   195: bipush 12
    //   197: ldc_w 1760
    //   200: aastore
    //   201: dup
    //   202: bipush 13
    //   204: ldc_w 1761
    //   207: aastore
    //   208: dup
    //   209: bipush 14
    //   211: ldc_w 1762
    //   214: aastore
    //   215: dup
    //   216: bipush 15
    //   218: ldc_w 1763
    //   221: aastore
    //   222: dup
    //   223: bipush 16
    //   225: ldc_w 1764
    //   228: aastore
    //   229: dup
    //   230: bipush 17
    //   232: ldc_w 1765
    //   235: aastore
    //   236: ldc_w 1767
    //   239: iconst_1
    //   240: anewarray 336	java/lang/String
    //   243: dup
    //   244: iconst_0
    //   245: aload_1
    //   246: aastore
    //   247: aconst_null
    //   248: aconst_null
    //   249: aconst_null
    //   250: aconst_null
    //   251: invokevirtual 1772	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +276 -> 532
    //   259: aload_1
    //   260: invokeinterface 1777 1 0
    //   265: ifeq +261 -> 526
    //   268: new 595	com/tencent/mobileqq/data/TroopMemberInfo
    //   271: dup
    //   272: invokespecial 1778	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   275: astore 9
    //   277: aload 9
    //   279: aload_1
    //   280: iconst_0
    //   281: invokeinterface 1779 2 0
    //   286: putfield 598	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   289: aload 9
    //   291: aload_1
    //   292: iconst_1
    //   293: invokeinterface 1779 2 0
    //   298: invokestatic 1782	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   301: putfield 1291	com/tencent/mobileqq/data/TroopMemberInfo:mIsShielded	Z
    //   304: aload 9
    //   306: aload_1
    //   307: iconst_2
    //   308: invokeinterface 1779 2 0
    //   313: putfield 1323	com/tencent/mobileqq/data/TroopMemberInfo:mUniqueTitle	Ljava/lang/String;
    //   316: aload 9
    //   318: aload_1
    //   319: iconst_3
    //   320: invokeinterface 1785 2 0
    //   325: putfield 1269	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   328: aload 9
    //   330: aload_1
    //   331: iconst_4
    //   332: invokeinterface 1789 2 0
    //   337: putfield 1287	com/tencent/mobileqq/data/TroopMemberInfo:active_point	J
    //   340: aload 9
    //   342: aload_1
    //   343: iconst_5
    //   344: invokeinterface 1789 2 0
    //   349: putfield 1278	com/tencent/mobileqq/data/TroopMemberInfo:credit_level	J
    //   352: aload 9
    //   354: aload_1
    //   355: bipush 6
    //   357: invokeinterface 1789 2 0
    //   362: putfield 1263	com/tencent/mobileqq/data/TroopMemberInfo:last_active_time	J
    //   365: aload 9
    //   367: aload_1
    //   368: bipush 7
    //   370: invokeinterface 1789 2 0
    //   375: putfield 1266	com/tencent/mobileqq/data/TroopMemberInfo:join_time	J
    //   378: aload 9
    //   380: aload_1
    //   381: bipush 8
    //   383: invokeinterface 1779 2 0
    //   388: putfield 1254	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   391: aload 9
    //   393: aload_1
    //   394: bipush 9
    //   396: invokeinterface 1779 2 0
    //   401: putfield 1257	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_troopnick	Ljava/lang/String;
    //   404: aload 9
    //   406: aload_1
    //   407: bipush 10
    //   409: invokeinterface 1779 2 0
    //   414: putfield 1260	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_troopnick	Ljava/lang/String;
    //   417: aload 9
    //   419: aload_1
    //   420: bipush 11
    //   422: invokeinterface 1779 2 0
    //   427: putfield 1237	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   430: aload 9
    //   432: aload_1
    //   433: bipush 12
    //   435: invokeinterface 1779 2 0
    //   440: putfield 1242	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_friendnick	Ljava/lang/String;
    //   443: aload 9
    //   445: aload_1
    //   446: bipush 13
    //   448: invokeinterface 1779 2 0
    //   453: putfield 1247	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_friendnick	Ljava/lang/String;
    //   456: aload 9
    //   458: aload_1
    //   459: bipush 14
    //   461: invokeinterface 1779 2 0
    //   466: putfield 1328	com/tencent/mobileqq/data/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   469: aload 9
    //   471: aload_1
    //   472: bipush 15
    //   474: invokeinterface 1779 2 0
    //   479: putfield 1333	com/tencent/mobileqq/data/TroopMemberInfo:pyAll_autoremark	Ljava/lang/String;
    //   482: aload 9
    //   484: aload_1
    //   485: bipush 16
    //   487: invokeinterface 1779 2 0
    //   492: putfield 1336	com/tencent/mobileqq/data/TroopMemberInfo:pyFirst_autoremark	Ljava/lang/String;
    //   495: aload 9
    //   497: aload_1
    //   498: bipush 17
    //   500: invokeinterface 1785 2 0
    //   505: putfield 1273	com/tencent/mobileqq/data/TroopMemberInfo:realLevel	I
    //   508: aload_2
    //   509: aload 9
    //   511: invokeinterface 623 2 0
    //   516: pop
    //   517: aload_1
    //   518: invokeinterface 1792 1 0
    //   523: ifne -255 -> 268
    //   526: aload_1
    //   527: invokeinterface 1795 1 0
    //   532: aload 8
    //   534: invokevirtual 1796	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   537: invokestatic 896	java/lang/System:currentTimeMillis	()J
    //   540: lstore 6
    //   542: aload_2
    //   543: astore 8
    //   545: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +39 -> 587
    //   551: ldc_w 556
    //   554: iconst_2
    //   555: new 558	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 1798
    //   565: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: lload 6
    //   570: aload_0
    //   571: getfield 247	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_d_of_type_Long	J
    //   574: lsub
    //   575: invokevirtual 1801	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   578: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: aload_2
    //   585: astore 8
    //   587: aload 8
    //   589: ifnull +13 -> 602
    //   592: aload 8
    //   594: invokeinterface 1730 1 0
    //   599: ifeq +26 -> 625
    //   602: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq +13 -> 618
    //   608: ldc_w 556
    //   611: iconst_2
    //   612: ldc_w 1803
    //   615: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_0
    //   619: invokevirtual 422	com/tencent/mobileqq/activity/TroopMemberListActivity:k	()V
    //   622: aload_0
    //   623: monitorexit
    //   624: return
    //   625: aload 8
    //   627: invokeinterface 399 1 0
    //   632: istore 4
    //   634: aload_0
    //   635: iload 4
    //   637: putfield 244	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_k_of_type_Int	I
    //   640: iload 4
    //   642: getstatic 79	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_l_of_type_Int	I
    //   645: idiv
    //   646: istore 5
    //   648: iload 4
    //   650: getstatic 79	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_l_of_type_Int	I
    //   653: irem
    //   654: ifne +195 -> 849
    //   657: iconst_0
    //   658: istore_3
    //   659: aload_0
    //   660: iload_3
    //   661: iload 5
    //   663: iadd
    //   664: putfield 219	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_j_of_type_Int	I
    //   667: iconst_0
    //   668: istore_3
    //   669: iload_3
    //   670: iload 4
    //   672: if_icmpge +42 -> 714
    //   675: new 1805	tyi
    //   678: dup
    //   679: aload_0
    //   680: aload 8
    //   682: iload_3
    //   683: getstatic 79	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_l_of_type_Int	I
    //   686: iload_3
    //   687: iadd
    //   688: iconst_1
    //   689: isub
    //   690: iload 4
    //   692: invokestatic 1811	java/lang/Math:min	(II)I
    //   695: invokespecial 1814	tyi:<init>	(Lcom/tencent/mobileqq/activity/TroopMemberListActivity;Ljava/util/List;II)V
    //   698: bipush 8
    //   700: aconst_null
    //   701: iconst_1
    //   702: invokestatic 905	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   705: iload_3
    //   706: getstatic 79	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_l_of_type_Int	I
    //   709: iadd
    //   710: istore_3
    //   711: goto -42 -> 669
    //   714: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq -95 -> 622
    //   720: ldc_w 556
    //   723: iconst_2
    //   724: new 558	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   731: ldc_w 1816
    //   734: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload 4
    //   739: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: ldc_w 1818
    //   745: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload_0
    //   749: getfield 219	com/tencent/mobileqq/activity/TroopMemberListActivity:jdField_j_of_type_Int	I
    //   752: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: goto -139 -> 622
    //   764: astore_1
    //   765: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq -146 -> 622
    //   771: ldc_w 556
    //   774: iconst_2
    //   775: new 558	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 1820
    //   785: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_1
    //   789: invokevirtual 1721	java/lang/Exception:toString	()Ljava/lang/String;
    //   792: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: goto -179 -> 622
    //   804: astore_1
    //   805: aload_0
    //   806: monitorexit
    //   807: aload_1
    //   808: athrow
    //   809: astore_1
    //   810: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   813: ifeq -191 -> 622
    //   816: ldc_w 556
    //   819: iconst_2
    //   820: new 558	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   827: ldc_w 1820
    //   830: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_1
    //   834: invokevirtual 1821	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   837: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: goto -224 -> 622
    //   849: iconst_1
    //   850: istore_3
    //   851: goto -192 -> 659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	TroopMemberListActivity
    //   0	854	1	paramString	String
    //   0	854	2	paramList	List
    //   658	193	3	i1	int
    //   632	106	4	i2	int
    //   646	18	5	i3	int
    //   540	29	6	l1	long
    //   71	610	8	localObject	Object
    //   275	235	9	localTroopMemberInfo	TroopMemberInfo
    // Exception table:
    //   from	to	target	type
    //   26	59	764	java/lang/Exception
    //   59	66	764	java/lang/Exception
    //   73	82	764	java/lang/Exception
    //   82	255	764	java/lang/Exception
    //   259	268	764	java/lang/Exception
    //   268	526	764	java/lang/Exception
    //   526	532	764	java/lang/Exception
    //   532	542	764	java/lang/Exception
    //   545	584	764	java/lang/Exception
    //   592	602	764	java/lang/Exception
    //   602	618	764	java/lang/Exception
    //   618	622	764	java/lang/Exception
    //   625	657	764	java/lang/Exception
    //   659	667	764	java/lang/Exception
    //   675	711	764	java/lang/Exception
    //   714	761	764	java/lang/Exception
    //   2	26	804	finally
    //   26	59	804	finally
    //   59	66	804	finally
    //   73	82	804	finally
    //   82	255	804	finally
    //   259	268	804	finally
    //   268	526	804	finally
    //   526	532	804	finally
    //   532	542	804	finally
    //   545	584	804	finally
    //   592	602	804	finally
    //   602	618	804	finally
    //   618	622	804	finally
    //   625	657	804	finally
    //   659	667	804	finally
    //   675	711	804	finally
    //   714	761	804	finally
    //   765	801	804	finally
    //   810	846	804	finally
    //   26	59	809	java/lang/OutOfMemoryError
    //   59	66	809	java/lang/OutOfMemoryError
    //   73	82	809	java/lang/OutOfMemoryError
    //   82	255	809	java/lang/OutOfMemoryError
    //   259	268	809	java/lang/OutOfMemoryError
    //   268	526	809	java/lang/OutOfMemoryError
    //   526	532	809	java/lang/OutOfMemoryError
    //   532	542	809	java/lang/OutOfMemoryError
    //   545	584	809	java/lang/OutOfMemoryError
    //   592	602	809	java/lang/OutOfMemoryError
    //   602	618	809	java/lang/OutOfMemoryError
    //   618	622	809	java/lang/OutOfMemoryError
    //   625	657	809	java/lang/OutOfMemoryError
    //   659	667	809	java/lang/OutOfMemoryError
    //   675	711	809	java/lang/OutOfMemoryError
    //   714	761	809	java/lang/OutOfMemoryError
  }
  
  public Object[] a(String paramString)
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
        localObject = (FriendsManager)this.app.getManager(50);
        this.jdField_c_of_type_JavaUtilList = ((DiscussionManager)this.app.getManager(52)).a(paramString);
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
            paramString = a(paramString, (FriendsManager)localObject);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
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
  public Object[] a(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 896	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 108	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 109	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 579	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: bipush 50
    //   21: invokevirtual 585	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 587	com/tencent/mobileqq/app/FriendsManager
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 579	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 1734	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   36: invokevirtual 1740	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore 7
    //   41: aload_2
    //   42: invokeinterface 939 1 0
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 944 1 0
    //   54: ifeq +85 -> 139
    //   57: aload 7
    //   59: ldc_w 595
    //   62: iconst_0
    //   63: ldc_w 1868
    //   66: iconst_2
    //   67: anewarray 336	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: invokeinterface 947 1 0
    //   82: checkcast 336	java/lang/String
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 1871	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   93: astore 8
    //   95: aload 8
    //   97: ifnull -49 -> 48
    //   100: aload 8
    //   102: invokeinterface 399 1 0
    //   107: ifle -59 -> 48
    //   110: aload 5
    //   112: aload_0
    //   113: aload 8
    //   115: iconst_0
    //   116: invokeinterface 593 2 0
    //   121: checkcast 595	com/tencent/mobileqq/data/TroopMemberInfo
    //   124: aload 6
    //   126: invokevirtual 620	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;Lcom/tencent/mobileqq/app/FriendsManager;)Lcom/tencent/mobileqq/activity/TroopMemberListActivity$ATroopMember;
    //   129: invokeinterface 623 2 0
    //   134: pop
    //   135: goto -87 -> 48
    //   138: astore_1
    //   139: invokestatic 554	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +34 -> 176
    //   145: ldc_w 556
    //   148: iconst_2
    //   149: new 558	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 559	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1873
    //   159: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 896	java/lang/System:currentTimeMillis	()J
    //   165: lload_3
    //   166: lsub
    //   167: invokevirtual 1801	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: iconst_1
    //   179: anewarray 328	java/lang/Object
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
    //   0	193	2	paramList	List
    //   5	161	3	l1	long
    //   13	172	5	localArrayList	ArrayList
    //   27	98	6	localFriendsManager	FriendsManager
    //   39	19	7	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
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
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375144));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362577);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363363));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366540));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373322));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    if ((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363455));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363410));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363456));
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131365951));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131363807));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131363031);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369789));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373465));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131374858));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131374859));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131430228));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364003));
    if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130841413);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131433137));
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130841414);
    }
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(0);
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(paramString);
    } while (i1 == -1);
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelection(i1 + this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.getHeaderViewsCount());
  }
  
  protected void c()
  {
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131435330));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434517));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433998));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label1195;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_i_of_type_Int >= 0) && (this.jdField_i_of_type_Int < this.jdField_b_of_type_ArrayOfJavaLangString.length)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_i_of_type_Int]);
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 14) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131433100));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131433681);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839143);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new tyz(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131430169));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131432998);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839143);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new tza(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131430168));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131432998);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new tzb(this));
        break;
      }
      if (this.jdField_d_of_type_Int == 5)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131430391));
        if (this.jdField_h_of_type_JavaLangString == null) {
          this.jdField_h_of_type_JavaLangString = getString(2131433681);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839143);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131430730);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        break;
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433130);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131434535);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131433092);
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
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131432998);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434517));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433998));
        break;
      }
      if (this.jdField_d_of_type_Int == 18)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433138);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131433681));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      if (this.jdField_d_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131433681));
        this.jdField_b_of_type_AndroidWidgetTextView.setText("老师和管理员");
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new tzc(this));
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText("群聊成员");
      if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_h_of_type_JavaLangString == null) {
        this.jdField_h_of_type_JavaLangString = getString(2131433681);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131434517);
      if (this.jdField_d_of_type_Int != 4)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839143);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131430228));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1195:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void c(String paramString)
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
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember;
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label926;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i1);
        localATroopMember.jdField_e_of_type_JavaLangString = "";
        localATroopMember.jdField_f_of_type_JavaLangString = "";
        if ((paramString.equals(localATroopMember.m)) || (paramString.equals(localATroopMember.jdField_o_of_type_JavaLangString)) || (paramString.equals(localATroopMember.jdField_n_of_type_JavaLangString)))
        {
          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.m;
          localArrayList1.add(localATroopMember);
          if (!QLog.isColorLevel()) {
            break label1104;
          }
          QLog.d("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + localATroopMember.jdField_a_of_type_JavaLangString + "," + localATroopMember.jdField_e_of_type_JavaLangString);
          break label1104;
        }
        if ((paramString.equals(localATroopMember.jdField_j_of_type_JavaLangString)) || (paramString.equals(localATroopMember.l)) || (paramString.equals(localATroopMember.jdField_k_of_type_JavaLangString)))
        {
          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_j_of_type_JavaLangString;
          localArrayList1.add(localATroopMember);
          continue;
        }
        if (paramString.equals(localATroopMember.jdField_g_of_type_JavaLangString)) {
          break label383;
        }
      }
      finally {}
      if ((paramString.equals(localATroopMember.jdField_i_of_type_JavaLangString)) || (paramString.equals(localATroopMember.jdField_h_of_type_JavaLangString)))
      {
        label383:
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_g_of_type_JavaLangString;
        localArrayList1.add(localATroopMember);
      }
      else if (paramString.equals(localATroopMember.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localATroopMember);
        }
      }
      else if ((localATroopMember.m.indexOf(paramString) == 0) || (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(paramString) == 0) || (localATroopMember.jdField_n_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.m;
        localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_n_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_j_of_type_JavaLangString.indexOf(paramString) == 0) || (localATroopMember.l.indexOf(paramString) == 0) || (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_j_of_type_JavaLangString;
        localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_k_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_g_of_type_JavaLangString.indexOf(paramString) == 0) || (localATroopMember.jdField_i_of_type_JavaLangString.indexOf(paramString) == 0) || (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(paramString) == 0))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_g_of_type_JavaLangString;
        localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_h_of_type_JavaLangString;
        localArrayList2.add(localATroopMember);
      }
      else if (localATroopMember.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
          localATroopMember.jdField_f_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localATroopMember);
        }
      }
      else if ((localATroopMember.m.indexOf(paramString) > 0) || (localATroopMember.jdField_o_of_type_JavaLangString.indexOf(paramString) > 0) || (localATroopMember.jdField_n_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.m;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_j_of_type_JavaLangString.indexOf(paramString) > 0) || (localATroopMember.l.indexOf(paramString) > 0) || (localATroopMember.jdField_k_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_j_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_g_of_type_JavaLangString.indexOf(paramString) > 0) || (localATroopMember.jdField_i_of_type_JavaLangString.indexOf(paramString) > 0) || (localATroopMember.jdField_h_of_type_JavaLangString.indexOf(paramString) > 0))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_g_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
      }
      else if ((localATroopMember.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) && (!this.jdField_e_of_type_Boolean))
      {
        localATroopMember.jdField_e_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
        localArrayList3.add(localATroopMember);
        continue;
        label926:
        Collections.sort(localArrayList2, new TroopMemberListActivity.SearchResultComparator(this));
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
        this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
        if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TroopMemberListActivityget_troop_member", 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.jdField_b_of_type_JavaUtilList.size() + "," + this.jdField_a_of_type_JavaUtilList.size());
          return;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        label1104:
        i1 += 1;
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 5) || (this.jdField_d_of_type_Int == 9)) {
      if ((this.jdField_d_of_type_Int == 9) && (this.jdField_e_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new txe(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new txf(this));
      if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 17)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new txg(this));
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
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new txh(this));
        }
        else if (this.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new txi(this));
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
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624515);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968595);
          Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
          if (this.jdField_d_of_type_Int != 1)
          {
            localDialog.setCancelable(bool);
            ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362758)).setText(getString(2131433982));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(Long.parseLong(this.jdField_a_of_type_JavaLangString), Long.valueOf(paramString).longValue());
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    Object localObject2 = (TroopManager)this.app.getManager(51);
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
            ThreadManager.post(new txc(this, paramIntent, (FriendsManager)localObject1, (TroopManager)localObject2), 8, null, true);
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
      localObject1 = ContactUtils.a(this.app, getApplicationContext(), paramIntent);
      localObject2 = AIOUtils.a(new Intent(this, SplashActivity.class), null);
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
    ThreadManager.post(new txn(this, (FriendsManager)localObject1), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_d_of_type_Int == 11) {
      ReportController.b(this.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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
    this.jdField_n_of_type_Boolean = ((Bundle)localObject).getBoolean("param_troop_send_apollo_msg", false);
    this.jdField_k_of_type_Int = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM", 0);
    this.jdField_i_of_type_Int = ((Bundle)localObject).getInt("sort_type", 0);
    this.jdField_f_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num", this.jdField_f_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("param_pick_selected_list");
    this.jdField_e_of_type_JavaUtilList = ((Bundle)localObject).getStringArrayList("param_delete_filter_member_list");
    this.jdField_f_of_type_JavaUtilList = ((Bundle)localObject).getStringArrayList("param_hide_filter_member_list");
    this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("param_pick_max_num_exceeds_wording", 2131430836);
    this.jdField_k_of_type_JavaLangString = ((Bundle)localObject).getString("param_pick_title_string", this.jdField_k_of_type_JavaLangString);
    if (this.jdField_d_of_type_Int == 17) {
      new ReportTask(this.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(1).a(new String[] { this.jdField_b_of_type_JavaLangString }).a();
    }
    if ((this.jdField_d_of_type_Int == 9) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (QLog.isColorLevel())) {
      QLog.e("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
    }
    if (this.jdField_d_of_type_Int == 14)
    {
      this.jdField_i_of_type_Int = 7;
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
        setTheme(2131624736);
      }
      super.doOnCreate(paramBundle);
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.jdField_e_of_type_Boolean + ", mTroopUin = " + this.jdField_b_of_type_JavaLangString);
      }
      setContentView(2130971629);
      b();
      if (this.jdField_k_of_type_Int == 0)
      {
        paramBundle = ((TroopManager)this.app.getManager(51)).a(this.jdField_b_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_k_of_type_Int = paramBundle.wMemberNum;
        }
      }
      if (this.jdField_d_of_type_Int == 15)
      {
        this.jdField_i_of_type_Int = 6;
        this.jdField_f_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("param_seq_days");
        this.jdField_e_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("param_seq_name");
      }
      if (this.jdField_i_of_type_Int == 1) {
        ((TroopHandler)this.app.a(20)).s(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
      this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      paramBundle = (TroopManager)this.app.getManager(51);
      localObject = (DiscussionManager)this.app.getManager(52);
      if ((paramBundle != null) && (localObject != null)) {
        if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionManager)localObject).a(this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if ((this.jdField_d_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.getCurrentAccountUin()))) {
            break label966;
          }
          finish();
          return false;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_b_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {}
      for (bool = true;; bool = false)
      {
        this.jdField_b_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getCurrentAccountUin());
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label938;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        this.m = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopPrivilegeFlag, 32);
        break;
      }
      label938:
      finish();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
    }
    finish();
    return false;
    label966:
    label1222:
    String str2;
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 16))
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if ((this.jdField_n_of_type_Boolean) && (this.jdField_d_of_type_Int == 3)) {
        this.jdField_i_of_type_Int = 2;
      }
      if (this.jdField_d_of_type_Int == 1) {
        break label1554;
      }
      if (this.jdField_d_of_type_Int != 11) {
        break label1363;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin;
        if ((this.jdField_e_of_type_JavaLangString == null) || (!this.jdField_e_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
          break label1358;
        }
        bool = true;
        label1081:
        this.jdField_a_of_type_Boolean = bool;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_Int == 21) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131296312);
      this.jdField_b_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131296313);
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
      this.jdField_o_of_type_Boolean = TroopMemberLbsHelper.a(this.jdField_b_of_type_JavaLangString, this.app).booleanValue();
      if (this.jdField_d_of_type_Int == 18) {
        ReportController.b(this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      return true;
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
      break;
      label1358:
      bool = false;
      break label1081;
      label1363:
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
          label1473:
          this.jdField_a_of_type_Boolean = bool;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo admin: " + this.jdField_f_of_type_JavaLangString + "  owner:" + this.jdField_e_of_type_JavaLangString);
        break;
        bool = false;
        break label1473;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "doOnCreate, mTroopInfo==null");
        }
      }
      label1554:
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
      paramBundle = "0";
      break label1222;
      paramBundle = "1";
      break label1222;
      paramBundle = "2";
      break label1222;
      paramBundle = "3";
      break label1222;
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
  
  protected void doOnDestroy()
  {
    this.jdField_i_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      try
      {
        label13:
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        label29:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.V_();
        }
        super.doOnDestroy();
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.c();
        }
        if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
          this.jdField_b_of_type_AndroidAppDialog.dismiss();
        }
        return;
      }
      catch (Exception localException1)
      {
        break label29;
      }
    }
    catch (Exception localException2)
    {
      break label13;
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 13) && (this.jdField_d_of_type_Int != 21) && ((this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean)))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      }
      return true;
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
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
        this.jdField_a_of_type_AndroidViewView.requestLayout();
        this.jdField_a_of_type_AndroidViewView.invalidate();
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
  
  protected void e()
  {
    View localView = getLayoutInflater().inflate(2130971635, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365630));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131375161));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363531);
    this.jdField_g_of_type_Int = ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).leftMargin;
    int i1;
    int i2;
    label126:
    Object localObject;
    if ((this.jdField_d_of_type_Int == 3) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != 1))
    {
      i1 = 1;
      if ((this.jdField_d_of_type_Int != 11) || (!this.jdField_a_of_type_Boolean)) {
        break label720;
      }
      i2 = 1;
      if ((i1 != 0) || (i2 != 0))
      {
        localObject = getString(2131433109);
        localTextView.setText((CharSequence)localObject);
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375162);
        localTextView.setText("");
        ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364316)).setBackgroundDrawable(ImageUtil.d());
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131375163);
        localImageView.setVisibility(8);
        if (i1 != 0)
        {
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new txj(this));
          localTextView.setTextSize(12.0F);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new txk(this, (String)localObject));
        if (!this.jdField_n_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        }
        localObject = (TroopHandler)this.app.a(20);
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label725;
        }
        QQToast.a(this, 1, 2131433196, 0).b(getTitleBarHeight());
      }
      localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368255);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368254)).setVisibility(8);
      if (this.jdField_d_of_type_Int != 19) {
        break label824;
      }
      localView = getLayoutInflater().inflate(2130971630, this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localView.setOnClickListener(new txl(this));
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = new TroopMemberListActivity.ListAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
      if ((this.jdField_d_of_type_Int == 19) || (this.jdField_d_of_type_Int == 21)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 19)) {
        r();
      }
      ((EditText)localObject).setOnTouchListener(new txm(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      if (this.jdField_d_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener2(this);
      }
      return;
      i1 = 0;
      break;
      label720:
      i2 = 0;
      break label126;
      label725:
      if ((this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler != null) && (this.jdField_d_of_type_Int == 11)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.app.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838596);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        break;
        if (localObject != null) {
          ((TroopHandler)localObject).a(this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
        }
      }
      label824:
      if ((this.jdField_d_of_type_Int != 9) && (this.jdField_d_of_type_Int != 15)) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView(localView);
      }
    }
  }
  
  protected void e(String paramString)
  {
    if (((TroopRobotManager)this.app.getManager(202)).a(this, this.jdField_b_of_type_JavaLangString, Long.parseLong(paramString))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("selfSet_leftViewText", getString(2131433092));
    if ((this.jdField_j_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
      localBundle.putString("custom_leftbackbutton_name", getString(2131433681));
    }
    TroopMemberCardUtils.a(this.app, this, this.jdField_b_of_type_JavaLangString, paramString, 1, 1, localBundle);
    this.v = paramString;
    a("Clk_item", this.jdField_n_of_type_JavaLangString, "");
  }
  
  protected void f()
  {
    t();
    if (this.jdField_d_of_type_Int == 9) {
      ThreadManager.post(new txu(this), 8, null, true);
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
        if ((this.jdField_d_of_type_Int != 11) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 16) && (NetworkUtil.g(this)))
        {
          localObject2 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 0);
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
          localObject2 = (TroopHandler)this.app.a(20);
          if (localObject2 != null)
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            ((TroopHandler)localObject2).a(true, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, a(), this.jdField_a_of_type_Long);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopHandler.getTroopMemberList(), troopUin: " + this.jdField_a_of_type_JavaLangString + " troopCode: " + this.jdField_b_of_type_JavaLangString);
            }
          }
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((TroopHandler)localObject2).a(Long.parseLong(this.jdField_b_of_type_JavaLangString), 0L, 1, 0, 0);
        if (this.jdField_d_of_type_Int == 3)
        {
          l1 = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 0).getLong("key_troop_info_last_update" + this.jdField_b_of_type_JavaLangString, 0L);
          l2 = Math.abs(l1 - System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "fillData, TroopInfo lastUpdateTime:" + l1 + " timeDiff:" + l2 / 1000L / 60L);
          }
          if (l2 > 60000L)
          {
            localObject2 = (TroopHandler)this.app.a(20);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              ((TroopHandler)localObject2).a(this.jdField_b_of_type_JavaLangString, (byte)0, 0L, 0);
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
        ((TroopGiftManager)this.app.getManager(112)).a(this.jdField_b_of_type_JavaLangString, new txw(this));
        return;
        localObject1 = new txv(this);
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
    if ((this.jdField_d_of_type_Int == 9) && ((this.jdField_k_of_type_Boolean) || (this.jdField_c_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
      localIntent.putExtra("callback", this.s);
      setResult(-1, localIntent);
    }
    super.finish();
    if (this.jdField_j_of_type_Boolean) {
      overridePendingTransition(0, 2131034122);
    }
    if (this.jdField_d_of_type_Int == 12) {
      overridePendingTransition(0, 2131034135);
    }
  }
  
  public void g()
  {
    String[] arrayOfString;
    int i1;
    if (this.jdField_d_of_type_Int == 9)
    {
      arrayOfString = getResources().getStringArray(2131296317);
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 17)) {
        break label178;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      i1 = arrayOfString.length;
    }
    int i2;
    label178:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      i2 = 0;
      if (i2 < i1)
      {
        if (!this.jdField_e_of_type_Boolean) {
          break label201;
        }
        if (i2 != 2) {
          break label217;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(arrayOfString[i2]);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      arrayOfString = getResources().getStringArray(2131296311);
      break;
      label126:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption != 3) {
          i1 = arrayOfString.length - 1;
        } else {
          i1 = arrayOfString.length - 2;
        }
      }
      else
      {
        i1 = arrayOfString.length - 2;
        continue;
        if (this.jdField_d_of_type_Int == 9) {
          i1 = arrayOfString.length;
        } else {
          i1 = arrayOfString.length - 5;
        }
      }
    }
    label201:
    if (i2 == 3) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[i2], 3);
    }
    for (;;)
    {
      label217:
      i2 += 1;
      break;
      if ((this.m) || (i2 != 1)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(arrayOfString[i2]);
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (QLog.isColorLevel())) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "checkShowCharIndexView, mItemCount:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int + " mCharSegmentCount:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int);
    }
    if (this.jdField_i_of_type_Int == 0)
    {
      if (this.jdField_d_of_type_Int == 11)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int > 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int > 1)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        }
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_Int > 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_Int > 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void i()
  {
    boolean bool = true;
    Dialog localDialog;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624515);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968595);
      localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (this.jdField_d_of_type_Int == 1) {
        break label76;
      }
    }
    for (;;)
    {
      localDialog.setCancelable(bool);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362758)).setText(getString(2131434436));
      return;
      label76:
      bool = false;
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Int == 11) {
      ReportController.b(this.app, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new tyd(this, (TranslateAnimation)localObject, localTranslateAnimation, i1));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new tye(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131368254);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new tyf(this));
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
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
  
  public void m()
  {
    ThreadManager.post(new tyx(this), 8, null, true);
    a("Clk_invite", this.jdField_n_of_type_JavaLangString, "");
  }
  
  void n()
  {
    if (!this.m)
    {
      ViewStub localViewStub = (ViewStub)findViewById(2131375145);
      if (localViewStub != null) {
        ((LinearLayout)localViewStub.inflate().findViewById(2131375186)).setOnTouchListener(new tyy(this));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().getDecorView().invalidate();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity
 * JD-Core Version:    0.7.0.1
 */