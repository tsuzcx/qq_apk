package com.tencent.mobileqq.activity.selectmember;

import aaqe;
import acay;
import afaz;
import aiec;
import aied;
import aiee;
import aief;
import aieg;
import aieh;
import aiei;
import aiej;
import aiek;
import aiel;
import aiem;
import aien;
import aieq;
import aier;
import aies;
import aiet;
import ajsf;
import ajvk;
import ajvl;
import ajxl;
import ajxn;
import ajyc;
import akhq;
import akim;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import aukm;
import awmo;
import awmq;
import awmr;
import awmw;
import awmx;
import awmy;
import awnb;
import awoc;
import awqu;
import axqw;
import azoa;
import azoj;
import azol;
import bamn;
import baxk;
import bbbd;
import bbcl;
import bbcv;
import bbdf;
import bbdr;
import bbgg;
import bcpq;
import bcpw;
import bgjz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lxv;
import lzj;
import mqq.app.MobileQQ;
import mrb;
import msp;
import mud;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectMemberActivity
  extends FragmentActivity
  implements View.OnClickListener, awqu, azoj
{
  public static boolean b;
  protected float a;
  public int a;
  public long a;
  protected aaqe a;
  private acay jdField_a_of_type_Acay = new aier(this);
  public afaz a;
  aies jdField_a_of_type_Aies;
  private ajvl jdField_a_of_type_Ajvl;
  private ajxl jdField_a_of_type_Ajxl;
  private akim jdField_a_of_type_Akim;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Intent a;
  protected Bitmap a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public final Handler a;
  protected View a;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
  baxk jdField_a_of_type_Baxk;
  public bcpq a;
  private bgjz jdField_a_of_type_Bgjz;
  public InnerFrameManager a;
  public SelectedAndSearchBar a;
  public ContactSearchFragment a;
  public List<String> a;
  private lxv jdField_a_of_type_Lxv;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  long jdField_b_of_type_Long = 0L;
  public Dialog b;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  protected TextView b;
  public ArrayList<String> b;
  protected int c;
  private long c;
  public View c;
  public TextView c;
  public String c;
  public ArrayList<String> c;
  public boolean c;
  public int d;
  public View d;
  protected TextView d;
  String d;
  public ArrayList<String> d;
  public boolean d;
  public int e;
  protected View e;
  public TextView e;
  String jdField_e_of_type_JavaLangString;
  public ArrayList<ResultRecord> e;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  View jdField_f_of_type_AndroidViewView;
  protected TextView f;
  String jdField_f_of_type_JavaLangString;
  public ArrayList<String> f;
  boolean jdField_f_of_type_Boolean;
  public int g;
  private View jdField_g_of_type_AndroidViewView;
  public String g;
  ArrayList<aukm> jdField_g_of_type_JavaUtilArrayList;
  boolean jdField_g_of_type_Boolean;
  protected int h;
  String jdField_h_of_type_JavaLangString = "";
  boolean jdField_h_of_type_Boolean;
  public int i;
  boolean i;
  public int j;
  boolean j;
  private int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean;
  boolean l;
  boolean m;
  protected boolean n = true;
  protected boolean o;
  protected boolean p;
  public boolean q;
  public boolean r = true;
  public boolean s;
  public boolean t = true;
  public boolean u;
  public boolean v;
  public boolean w;
  boolean x = false;
  boolean y = false;
  boolean z;
  
  public SelectMemberActivity()
  {
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaLangString = ajyc.a(2131713759);
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_Aaqe = new aied(this);
    this.jdField_a_of_type_AndroidOsHandler = new aieh(this, Looper.getMainLooper());
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.jdField_c_of_type_JavaLangString = paramString3;
    return localResultRecord;
  }
  
  private void a(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 2000)
    {
      bcpw.a(this, paramString, 2000).b(this.jdField_c_of_type_AndroidViewView.getHeight());
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "afterCreateTroopSucc, troop[" + paramString + "], entrance[" + this.jdField_d_of_type_Int + "]");
    }
    Object localObject = ((TroopManager)this.app.getManager(52)).c(paramString);
    ArrayList localArrayList;
    Iterator localIterator;
    if (localObject == null)
    {
      localObject = "";
      localArrayList = new ArrayList();
      localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label211;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int == 5)
      {
        if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
          localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
        }
        localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        continue;
        localObject = ((TroopInfo)localObject).troopname;
        break;
      }
      if ((localResultRecord.jdField_a_of_type_Int == 4) && (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+"))) {
        localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
      }
    }
    label211:
    this.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("discussName", (String)localObject);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("qqPhoneUserList", localArrayList);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("audioType", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_uin", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_uintype", 1);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_name", (String)localObject);
    if (this.jdField_d_of_type_Int == 12) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("select_memeber_discussion_memeber_count", this.jdField_e_of_type_JavaUtilArrayList.size() + 1);
    }
    this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_d_of_type_Int == 27) {
      bamn.a(this, paramString, true);
    }
    finish();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false)) {}
    label293:
    for (;;)
    {
      return;
      int i1 = this.jdField_e_of_type_JavaUtilArrayList.size();
      String str1;
      if (i1 <= 1) {
        if (this.jdField_b_of_type_Int == 3)
        {
          String str2 = this.jdField_e_of_type_JavaLangString;
          str1 = str2;
          if (i1 != 1)
          {
            paramBoolean = false;
            str1 = str2;
          }
          if (!paramBoolean) {
            break label248;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(true);
          if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
            this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
        }
      }
      for (;;)
      {
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label293;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_e_of_type_JavaLangString + ajyc.a(2131713752) + i1 + ajyc.a(2131713743));
        return;
        if (((this.jdField_d_of_type_Int == 25) && (i1 == 1)) || ((f()) && (i1 == 1)))
        {
          str1 = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
          break;
        }
        str1 = this.jdField_e_of_type_JavaLangString;
        break;
        if (this.jdField_b_of_type_Int == 3)
        {
          str1 = this.jdField_e_of_type_JavaLangString;
          break;
        }
        str1 = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
        break;
        label248:
        this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(false);
        if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
          this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_c_of_type_Boolean) && (b() >= 3)) {}
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.t + " ,isResume = " + paramBoolean);
    }
    if (this.t) {
      lzj.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i1;
    if (this.jdField_b_of_type_Int == 1) {
      if (this.jdField_a_of_type_Lxv != null) {
        i1 = this.jdField_a_of_type_Lxv.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), this.jdField_a_of_type_Int) + 0;
      }
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      label50:
      int i2;
      if (localIterator.hasNext()) {
        if (((ResultRecord)localIterator.next()).jdField_a_of_type_Int == 5)
        {
          i2 = i1 + 1;
          i1 = i2;
          if (i2 < 8) {}
        }
      }
      for (;;)
      {
        if (i2 < 8) {
          bool = true;
        }
        return bool;
        if (this.jdField_a_of_type_Bgjz == null) {
          break label141;
        }
        i1 = this.jdField_a_of_type_Bgjz.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), this.jdField_a_of_type_Int) + 0;
        break;
        break label50;
        i2 = i1;
      }
      label141:
      i1 = 0;
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null)
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131562356);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365147));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(getString(2131719281));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131366570));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131378673));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void c(boolean paramBoolean)
  {
    SelectMemberInnerFrame localSelectMemberInnerFrame;
    if ((this.jdField_d_of_type_Int == 38) || (this.jdField_d_of_type_Int == 29) || (this.jdField_d_of_type_Int == 39))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "isItemClick：" + paramBoolean);
      }
      localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 0)) {
        break label86;
      }
    }
    label86:
    while (!(localSelectMemberInnerFrame instanceof FriendTeamListInnerFrame)) {
      return;
    }
    ResultRecord localResultRecord = null;
    if (this.jdField_e_of_type_JavaUtilArrayList.size() > 0) {
      localResultRecord = (ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_JavaUtilArrayList.size() - 1);
    }
    localSelectMemberInnerFrame.a(localResultRecord, this.jdField_d_of_type_Int);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Ajvl = new aiee(this);
    this.jdField_a_of_type_Akim = new aief(this);
    this.jdField_a_of_type_Ajxl = new aieg(this);
    addObserver(this.jdField_a_of_type_Ajvl);
    addObserver(this.jdField_a_of_type_Ajxl);
    addObserver(this.jdField_a_of_type_Akim);
  }
  
  private void d(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 36)) {
        str = getString(2131695892);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str).sendToTarget();
      QLog.w("SelectMemberActivity", 1, "handleTroopInviteGroupFailed, result[" + paramInt + "], errStr[" + str + "]");
      return;
      str = getString(2131693673);
      continue;
      str = getString(2131693672);
      continue;
      str = getString(2131693675);
      continue;
      str = getString(2131693674);
      continue;
      str = getString(2131693676);
    }
  }
  
  private boolean d(String paramString)
  {
    try
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = TextUtils.equals(((ResultRecord)localIterator.next()).jdField_a_of_type_JavaLangString, paramString);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void e(int paramInt)
  {
    a(getString(paramInt));
  }
  
  public int a(String paramString)
  {
    switch (msp.a(paramString.substring("pstn".length()), true))
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      return 2131719232;
    case 1: 
      return 2131719226;
    case 2: 
      return 2131719227;
    case 3: 
      return 2131719228;
    case 4: 
      return 2131719229;
    case 5: 
      return 2131719230;
    }
    return 2131719231;
  }
  
  public ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.jdField_c_of_type_JavaLangString = paramString3;
    localResultRecord.jdField_d_of_type_JavaLangString = paramString4;
    return localResultRecord;
  }
  
  public String a(String paramString)
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
  
  public ArrayList<ResultRecord> a()
  {
    if ((this.jdField_d_of_type_Int == 11) && (this.jdField_g_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!a(localResultRecord.jdField_a_of_type_JavaLangString)) {
          localArrayList.add(localResultRecord);
        }
      }
      return localArrayList;
    }
    return this.jdField_e_of_type_JavaUtilArrayList;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      i1 += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int == 3000) && (f()))
    {
      m();
      return;
    }
    Object localObject1;
    label172:
    Object localObject2;
    Object localObject3;
    int i1;
    int i2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
      if ((localObject1 != null) && (this.jdField_d_of_type_Int == 32) && ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("group_uin", (String)localObject1);
        if (!this.jdField_h_of_type_Boolean) {
          break label659;
        }
        localObject1 = ((TroopManager)this.app.getManager(52)).c((String)localObject1);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("group_type", 4);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_name", ((TroopInfo)localObject1).troopname);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_member_type", ((TroopInfo)localObject1).wMemberNum);
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.m)
      {
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!d((String)localObject2))
          {
            localObject3 = new ResultRecord();
            ((ResultRecord)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((ResultRecord)localObject3).jdField_a_of_type_Int = 0;
            ((ResultRecord)localObject3).jdField_c_of_type_JavaLangString = "-1";
            this.jdField_e_of_type_JavaUtilArrayList.add(localObject3);
          }
        }
      }
      localObject1 = (ajxn)this.app.getManager(51);
      this.jdField_e_of_type_JavaUtilArrayList.size();
      localObject2 = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      i1 = 0;
      i2 = 0;
      label347:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        if (((ResultRecord)localObject3).jdField_a_of_type_Int == 3) {
          i2 = 1;
        }
        if (((ResultRecord)localObject3).jdField_a_of_type_Int != 5)
        {
          i1 = 1;
          if ((i2 == 0) || (i1 == 0)) {
            break;
          }
        }
      }
      label391:
      break;
    }
    for (;;)
    {
      if (i2 != 0)
      {
        axqw.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        label434:
        if (this.jdField_b_of_type_Int != 0) {
          break label610;
        }
        axqw.b(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
        label471:
        if (this.jdField_b_of_type_Int != 0) {
          break label643;
        }
      }
      label643:
      for (i2 = 2131691820;; i2 = 2131691811)
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this, getResources().getDimensionPixelSize(2131298865));
        this.jdField_a_of_type_Bcpq.c(i2);
        this.jdField_a_of_type_Bcpq.show();
        if ((this.jdField_b_of_type_Int == 0) || (i1 != 0))
        {
          localObject1 = new SelectMemberActivity.12(this, (ajxn)localObject1);
          ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
          ThreadManager.postImmediately((Runnable)localObject1, null, false);
        }
        if (this.jdField_b_of_type_Int == 0) {
          break;
        }
        s();
        if (i1 != 0) {
          break;
        }
        finish();
        return;
        break label347;
        axqw.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break label434;
        label610:
        axqw.b(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
        break label471;
      }
      a(this.jdField_e_of_type_JavaUtilArrayList);
      return;
      label659:
      if (!this.jdField_i_of_type_Boolean) {
        break label172;
      }
      localObject2 = (ajvk)this.app.getManager(53);
      localObject3 = ((ajvk)localObject2).a((String)localObject1);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("group_type", 8);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("group_member_type", ((ajvk)localObject2).a((String)localObject1));
      if (localObject3 == null) {
        break label172;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("group_name", ((DiscussionInfo)localObject3).discussionName);
      break label172;
      break label391;
    }
  }
  
  public void a(int paramInt)
  {
    long l1 = bbbd.a();
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l1 + ":" + paramInt);
    localEditor.commit();
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString))) {
      axqw.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "cre_suc", 0, 0, paramString, "", "", "");
    }
    do
    {
      return;
      paramInt = azol.a(paramInt);
    } while (paramInt == 0);
    bcpw.a(this, 1, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(aies paramaies)
  {
    this.jdField_a_of_type_Aies = paramaies;
  }
  
  public void a(View paramView)
  {
    Object localObject2 = (awoc)paramView.getTag(2131379208);
    if (localObject2 == null) {}
    String str;
    Object localObject1;
    label228:
    do
    {
      return;
      if (this.jdField_d_of_type_Int == 33) {
        axqw.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
      }
      paramView = ((awoc)localObject2).b();
      str = ((awoc)localObject2).a().toString();
      localObject1 = "-1";
      if ((localObject2 instanceof awmq))
      {
        localObject1 = ((awmq)localObject2).e();
        if ((localObject2 instanceof awmy))
        {
          paramView = ((awmy)localObject2).a;
          if (!TextUtils.isEmpty(paramView.uin)) {
            break label228;
          }
          paramView = "pstn" + paramView.mobileNo;
        }
      }
      for (;;)
      {
        if (!(localObject2 instanceof awmo)) {
          break label277;
        }
        paramView = new Bundle();
        paramView.putString("group_uin", ((awmo)localObject2).b());
        paramView.putString("group_name", ((awmo)localObject2).c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, paramView);
        p();
        return;
        if (!(localObject2 instanceof awmx)) {
          break;
        }
        localObject1 = ((awmx)localObject2).jdField_a_of_type_JavaLangString;
        break;
        if (paramView.uin.equals("0")) {
          paramView = paramView.nationCode + paramView.mobileCode;
        } else {
          paramView = paramView.uin;
        }
      }
      if ((localObject2 instanceof awmw))
      {
        paramView = (awmw)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          bcpw.a(this, 0, getResources().getString(2131697863), 0).b(getResources().getDimensionPixelSize(2131298865));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.b());
        ((Bundle)localObject1).putString("group_name", paramView.c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject1);
        p();
        return;
      }
      if ((localObject2 instanceof awnb))
      {
        paramView = (awnb)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          bcpw.a(this, 0, getResources().getString(2131697863), 0).b(getResources().getDimensionPixelSize(2131298865));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.b());
        ((Bundle)localObject1).putString("group_name", paramView.c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject1);
        p();
        return;
      }
      if (c(paramView))
      {
        bcpw.a(this, 1, ajyc.a(2131713746), 0).b(getTitleBarHeight());
        axqw.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, (String)localObject1, "", "", "");
        return;
      }
    } while (((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.contains(paramView))) || (b(paramView)) || (a("onAction", false, paramView, str, -1, (String)localObject1)) || (a(paramView, str)));
    label277:
    SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
    int i1;
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 5) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 4) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 3) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8))
    {
      i1 = -1;
      if ((localObject2 instanceof awmq))
      {
        i1 = 2;
        if (i1 != -1) {
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, i1, (String)localObject1));
        }
        label748:
        r();
        k();
        localSelectMemberInnerFrame.f();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
        if (this.jdField_a_of_type_Int == 9003) {
          if ((this.jdField_d_of_type_Int != 15) || (this.jdField_a_of_type_Afaz.a(paramView))) {
            break label1142;
          }
        }
      }
    }
    for (this.jdField_k_of_type_Int += 1;; this.jdField_k_of_type_Int += 1) {
      label1142:
      do
      {
        c(false);
        return;
        if ((localObject2 instanceof awmx))
        {
          i1 = 1;
          break;
        }
        if ((localObject2 instanceof awmr))
        {
          i1 = 0;
          break;
        }
        if (!(localObject2 instanceof awmy)) {
          break;
        }
        if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, (String)localObject1)))
        {
          i1 = 5;
          break;
        }
        if (paramView.startsWith("+"))
        {
          i1 = 4;
          break;
        }
        i1 = 0;
        break;
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 6)
        {
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 1, localSelectMemberInnerFrame.a()));
          break label748;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 7)
        {
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 2, localSelectMemberInnerFrame.a()));
          break label748;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1)
        {
          if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, localSelectMemberInnerFrame.a())))
          {
            this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 5, localSelectMemberInnerFrame.a()));
            break label748;
          }
          if (paramView.startsWith("+"))
          {
            this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 4, localSelectMemberInnerFrame.a()));
            break label748;
          }
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 0, localSelectMemberInnerFrame.a()));
          break label748;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 9) {
          break label748;
        }
        localObject1 = a(paramView, str, 1, localSelectMemberInnerFrame.a());
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localObject1);
        a((List)localObject2, false);
        break label748;
      } while ((this.jdField_d_of_type_Int != 32) || (this.jdField_a_of_type_Afaz.b(paramView)));
    }
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Int != 30) {
      return;
    }
    if (this.jdField_a_of_type_Aies != null) {
      this.jdField_a_of_type_Aies.a(paramResultRecord, paramBoolean);
    }
    if (this.jdField_e_of_type_JavaUtilArrayList.isEmpty())
    {
      paramResultRecord = getString(2131691059);
      label46:
      if (this.jdField_b_of_type_AndroidWidgetButton == null) {
        break label110;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(paramResultRecord);
      paramResultRecord = this.jdField_b_of_type_AndroidWidgetButton;
      if (this.jdField_e_of_type_JavaUtilArrayList.isEmpty()) {
        break label112;
      }
    }
    label110:
    label112:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramResultRecord.setEnabled(paramBoolean);
      return;
      paramResultRecord = getString(2131691060, new Object[] { Integer.valueOf(this.jdField_e_of_type_JavaUtilArrayList.size()) });
      break label46;
      break;
    }
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList.size() > 0) && (this.jdField_c_of_type_JavaLangString.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.jdField_c_of_type_JavaLangString + " member count: " + paramArrayList.size());
      }
      if (!a())
      {
        bcpw.a(this, 2131694694, 0).b(getTitleBarHeight());
        return;
      }
      if (this.jdField_i_of_type_Int <= 0)
      {
        Object localObject = (TroopManager)this.app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.jdField_c_of_type_JavaLangString);
          if (localObject != null) {
            this.jdField_i_of_type_Int = ((TroopInfo)localObject).wMemberNum;
          }
        }
      }
      if ((this.jdField_a_of_type_Long > 0L) && (paramArrayList.size() + this.jdField_i_of_type_Int > this.jdField_a_of_type_Long))
      {
        bbcv.a(this, ajyc.a(2131713753), 2131690596, 2131693670, new aieq(this, paramArrayList), new bbdf()).show();
        d("exp_msgbox");
        return;
      }
      ((akhq)this.app.a(20)).b(this.jdField_c_of_type_JavaLangString, paramArrayList, "");
      c();
      this.jdField_b_of_type_AndroidAppDialog.show();
      d("Clk_invite");
      return;
    }
    finish();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375794));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698048, new Object[] { Integer.valueOf(Math.min(paramInt, this.jdField_g_of_type_Int)) }));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698050, new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) }));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aiek(this));
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130849538);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      if ((this.jdField_d_of_type_Int != 14) && (this.jdField_d_of_type_Int != 21) && (this.jdField_d_of_type_Int != 25) && (this.jdField_d_of_type_Int != 35)) {
        break label206;
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label195;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      label118:
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        paramString2 = this.jdField_c_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
          break label395;
        }
      }
    }
    label395:
    for (paramString1 = ajyc.a(2131713748);; paramString1 = this.jdField_c_of_type_AndroidWidgetTextView.getText())
    {
      paramString2.setContentDescription(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new SelectMemberActivity.4(this), 1000L);
      return;
      b();
      break;
      label195:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      break label118;
      label206:
      if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131698049));
        break label118;
      }
      if (this.jdField_c_of_type_Int == 30)
      {
        this.jdField_d_of_type_JavaLangString = getString(2131689648);
        if (!this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (8 != this.jdField_d_of_type_AndroidWidgetTextView.getVisibility()) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aiel(this));
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label118;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131719207));
        break label118;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      break label118;
    }
  }
  
  boolean a(String paramString)
  {
    Iterator localIterator = this.jdField_g_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((TroopMemberInfo)localIterator.next()).memberuin, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int == 9003)
    {
      if ((this.jdField_d_of_type_Int == 15) && (!this.jdField_a_of_type_Afaz.a(paramString1)) && (this.jdField_k_of_type_Int >= this.jdField_a_of_type_Afaz.d())) {
        a(String.format(getString(2131690535), new Object[] { Integer.valueOf(this.jdField_a_of_type_Afaz.c()) }));
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.jdField_d_of_type_Int == 32)
        {
          bool2 = bool1;
          if (!this.jdField_a_of_type_Afaz.b(paramString1))
          {
            bool2 = bool1;
            if (this.jdField_k_of_type_Int >= this.jdField_a_of_type_Afaz.j())
            {
              a(String.format(getString(2131720854), new Object[] { Integer.valueOf(this.jdField_a_of_type_Afaz.i()) }));
              bool2 = true;
            }
          }
        }
        return bool2;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool1;
    if (b(paramString1))
    {
      bool1 = false;
      e(paramString1);
    }
    for (;;)
    {
      if (c(paramString1))
      {
        e(paramString1);
        bcpw.a(this, 1, ajyc.a(2131713755), 0).b(getTitleBarHeight());
        axqw.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(bool1);
      k();
      r();
      c(true);
      return bool1;
      if ((!a("onListViewItemClick1", false, paramString1, paramString2, paramInt, paramString3)) && (!a(paramString1, paramString2)) && (b(paramString1, paramString2, paramInt, paramString3)))
      {
        boolean bool2 = true;
        this.jdField_e_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
        bool1 = bool2;
        if (this.jdField_a_of_type_Int == 9003) {
          if ((this.jdField_d_of_type_Int == 15) && (!this.jdField_a_of_type_Afaz.a(paramString1)))
          {
            this.jdField_k_of_type_Int += 1;
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (this.jdField_d_of_type_Int == 32)
            {
              bool1 = bool2;
              if (!this.jdField_a_of_type_Afaz.b(paramString1))
              {
                this.jdField_k_of_type_Int += 1;
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
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    boolean bool;
    if (b(paramString1))
    {
      bool = false;
      e(paramString1);
    }
    for (;;)
    {
      if (c(paramString1))
      {
        e(paramString1);
        bcpw.a(this, 1, ajyc.a(2131713720), 0).b(getTitleBarHeight());
        axqw.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(bool);
      k();
      r();
      return bool;
      if ((!a("onListViewItemClick2", false, paramString1, paramString2, paramInt, paramString3)) && (b(paramString1, paramString2, paramInt, paramString3)))
      {
        bool = true;
        this.jdField_e_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3, paramString4));
      }
      else
      {
        bool = false;
      }
    }
  }
  
  boolean a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((this.jdField_d_of_type_Int == 32) && (paramBoolean) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false))) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (this.jdField_a_of_type_Int != 3000) {
            break;
          }
        } while (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int);
        if ((this.jdField_d_of_type_Int == 12) && (this.jdField_g_of_type_Int == 1)) {
          e(2131691881);
        }
        for (;;)
        {
          return true;
          e(2131691872);
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label707;
        }
        if ((this.o) && (this.jdField_e_of_type_JavaUtilArrayList.size() >= this.jdField_g_of_type_Int))
        {
          a(ajyc.a(2131713735));
          return true;
        }
        if (this.jdField_b_of_type_Int != 0) {
          break;
        }
      } while (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int);
      a(getString(2131720588));
      return true;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() >= this.jdField_g_of_type_Int)
      {
        e(2131720588);
        return true;
      }
    } while ((this.jdField_d_of_type_Int != 11) || (this.jdField_g_of_type_JavaUtilArrayList == null));
    int i3 = this.jdField_g_of_type_JavaUtilArrayList.size() + 1;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
    int i1 = localTroopManager.c(str).getMemNumForAutoInviteIntoGroup(this.app);
    if (i1 > i3)
    {
      i1 -= i3;
      label278:
      int i2 = a().size();
      int i4 = this.jdField_e_of_type_JavaUtilArrayList.size();
      paramBoolean = a(paramString2);
      if (AudioHelper.e()) {
        QLog.w("SelectMemberActivity", 1, "isMemberOverLoad[" + paramString1 + "], 可邀请的群外成员到达上限检查, 已经选择群内成员[" + (i4 - i2) + "], 当前群成员[" + i3 + "], 实际可邀请的群外成员[" + i1 + "], 已经选择的群外成员[" + i2 + "], 当前选择的是群成员[" + paramBoolean + "], uin[" + paramString2 + "], name[" + paramString3 + "], type[" + paramInt + "], fromGroupUin[" + paramString4 + "], mResultList[" + this.jdField_e_of_type_JavaUtilArrayList.size() + "], groupUin[" + str + "], mGroupCode[" + this.jdField_c_of_type_JavaLangString + "]");
      }
      paramInt = i2;
      if (!paramBoolean) {
        paramInt = i2 + 1;
      }
      if (paramInt <= i1) {
        break label924;
      }
      paramBoolean = true;
      e(2131720564);
    }
    for (;;)
    {
      return paramBoolean;
      i1 = 0;
      break label278;
      if (this.jdField_b_of_type_Int == 3)
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
          break;
        }
        a(getString(2131720562));
        axqw.b(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, this.jdField_c_of_type_JavaLangString, mud.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
        return true;
      }
      if (this.jdField_b_of_type_Int == 4)
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
          break;
        }
        a(getString(2131720423, new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) }));
        return true;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
        break;
      }
      if (this.jdField_d_of_type_Int == 35) {
        e(2131720588);
      }
      for (;;)
      {
        return true;
        e(2131720562);
      }
      label707:
      if (this.jdField_a_of_type_Int == 9003)
      {
        if (this.jdField_d_of_type_Int == 15)
        {
          paramInt = this.jdField_a_of_type_Afaz.f();
          if (this.jdField_e_of_type_JavaUtilArrayList.size() < paramInt) {
            break;
          }
          a(String.format(getString(2131690533), new Object[] { Integer.valueOf(this.jdField_a_of_type_Afaz.e()) }));
          return true;
        }
        if (this.jdField_d_of_type_Int != 32) {
          break;
        }
        paramInt = this.jdField_a_of_type_Afaz.k();
        if (this.jdField_e_of_type_JavaUtilArrayList.size() < paramInt) {
          break;
        }
        a(String.format(getString(2131690533), new Object[] { Integer.valueOf(this.jdField_a_of_type_Afaz.h()) }));
        return true;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
        break;
      }
      i1 = 0;
      paramInt = i1;
      if (this.l)
      {
        paramInt = i1;
        if (this.jdField_b_of_type_JavaUtilArrayList != null) {
          paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
        }
      }
      a(String.format(getString(2131694936), new Object[] { Integer.valueOf(paramInt + this.jdField_g_of_type_Int) }));
      return true;
      label924:
      paramBoolean = false;
    }
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false);
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_e_of_type_JavaUtilArrayList.clear();
    }
    HashSet localHashSet = new HashSet(this.jdField_e_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
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
        if (!localHashSet.contains(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))
        {
          if ((a("addFriendResults", paramBoolean2, ((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b, ((ResultRecord)localObject).jdField_a_of_type_Int, ((ResultRecord)localObject).jdField_c_of_type_JavaLangString)) || (a(((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b)) || (!b(((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b, ((ResultRecord)localObject).jdField_a_of_type_Int, ((ResultRecord)localObject).jdField_c_of_type_JavaLangString))) {
            break;
          }
          this.jdField_e_of_type_JavaUtilArrayList.add(localObject);
          a((ResultRecord)localObject, true);
          if (this.jdField_a_of_type_Int == 9003) {
            if ((this.jdField_d_of_type_Int == 15) && (!this.jdField_a_of_type_Afaz.a(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
              this.jdField_k_of_type_Int += 1;
            } else if ((this.jdField_d_of_type_Int == 32) && (!this.jdField_a_of_type_Afaz.b(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
              this.jdField_k_of_type_Int += 1;
            }
          }
        }
      }
    } while (this.jdField_a_of_type_Int == 9003);
    label345:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
    k();
    r();
    return true;
  }
  
  public int b()
  {
    int i2 = 0;
    long l1 = bbbd.a();
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i1 = i2;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i1 = i2;
      if (Long.parseLong(localObject[0]) == l1) {
        i1 = Integer.parseInt(localObject[1]);
      }
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  protected ArrayList<ResultRecord> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int == 5)
      {
        if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
          localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131719207);
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131719207));
    }
    if (c())
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      if (g())
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130849538);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aiem(this));
      k();
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false))
      {
        if (this.jdField_d_of_type_Int != 35) {
          break label261;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131719205);
        mrb.f();
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (h())
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690596);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130849538);
      break;
      label261:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131719206);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_d_of_type_Int != 35) {
      return;
    }
    this.q = false;
    c(paramInt);
    t();
  }
  
  public void b(int paramInt, String paramString)
  {
    int i1 = 1;
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.w("SelectMemberActivity", 1, "onInviteComplete, retCode[" + paramInt + "], troopUin[" + paramString + "], mSubType[" + this.jdField_b_of_type_Int + "], mEntrance[" + this.jdField_d_of_type_Int + "]");
    }
    if (paramInt == 0) {}
    for (paramInt = i1; paramInt != 0; paramInt = 0)
    {
      a(paramString, false);
      return;
    }
    bcpw.a(this, getString(2131691815), 2000).b(this.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  public void b(ArrayList<aukm> paramArrayList)
  {
    this.jdField_g_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    int i1;
    if (!paramBoolean2)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
      }
    }
    else
    {
      localObject = this.jdField_f_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Boolean) {
        break label238;
      }
      i1 = 0;
      label38:
      ((View)localObject).setVisibility(i1);
      a(false, "", "");
      if (!this.jdField_a_of_type_Boolean) {
        break label273;
      }
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_e_of_type_JavaUtilArrayList.isEmpty()) {
        break label244;
      }
      localObject = getString(2131691059);
      label87:
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
      if (this.jdField_b_of_type_AndroidWidgetButton != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetButton;
        bool1 = bool2;
        if (!this.jdField_e_of_type_JavaUtilArrayList.isEmpty()) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      if ((this.jdField_a_of_type_Aies != null) && (!paramBoolean2)) {
        this.jdField_a_of_type_Aies.a(true, paramBoolean2);
      }
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
        r();
      }
      p();
      paramBoolean1 = this.jdField_a_of_type_Boolean;
      localObject = getIntent().getStringExtra("group_uin");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new SelectMemberActivity.20(this, paramBoolean1, (String)localObject), 5, null, true);
      }
      return;
      bool1 = false;
      break;
      label238:
      i1 = 8;
      break label38;
      label244:
      localObject = getString(2131691060, new Object[] { Integer.valueOf(this.jdField_e_of_type_JavaUtilArrayList.size()) });
      break label87;
      label273:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
      {
        if (((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  boolean b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool;
    int i1;
    if (paramInt == 5)
    {
      bool = b();
      if (!bool) {
        bcpw.a(this, 2131719233, 1).b(getTitleBarHeight());
      }
      i1 = a(paramString1);
      if (i1 != 0) {
        break label76;
      }
    }
    label76:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        bcpw.a(this, i1, 1).b(getTitleBarHeight());
      }
      if ((!bool) || (paramInt == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList<ResultRecord> c()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(this.jdField_e_of_type_JavaUtilArrayList.get(i1));
      i1 += 1;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = str;
        localResultRecord.jdField_a_of_type_Int = 0;
        localResultRecord.jdField_c_of_type_JavaLangString = "-1";
        localResultRecord.b = bbcl.b(this.app, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.jdField_a_of_type_Int);
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void c(int paramInt)
  {
    int i2 = 0;
    int i1 = 0;
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || ((!this.jdField_i_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)));
    if (paramInt != -1)
    {
      if (!this.p) {
        break label260;
      }
      i2 = paramInt - 1;
    }
    for (;;)
    {
      if (i2 <= this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_all_select_max_num", this.jdField_g_of_type_Int)) {
        this.q = true;
      }
      QLog.w("SelectMemberActivity", 1, "isEnableAllSelect, memCount[" + paramInt + "], memFromAPI[" + i1 + "], finalCount[" + i2 + "], mIsSelectAllMembers[" + this.q + "], mShowMyself[" + this.p + "]");
      return;
      if (this.jdField_i_of_type_Boolean)
      {
        ajvk localajvk = (ajvk)this.app.getManager(53);
        if (localajvk == null) {
          break label255;
        }
        i1 = localajvk.a((String)localObject);
      }
      for (;;)
      {
        i2 = i1 - 1;
        break;
        i1 = i2;
        if (this.jdField_h_of_type_Boolean)
        {
          localObject = ((TroopManager)this.app.getManager(52)).c((String)localObject);
          i1 = i2;
          if (localObject != null)
          {
            i1 = ((TroopInfo)localObject).wMemberNum;
            continue;
            label255:
            i1 = 0;
          }
        }
      }
      label260:
      i2 = paramInt;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SelectMemberActivity", 1, "onReusedTroop,troopUin[" + paramString + "], mSubType[" + this.jdField_b_of_type_Int + "], mEntrance[" + this.jdField_d_of_type_Int + "]");
    }
    a(paramString, true);
  }
  
  boolean c()
  {
    if ((g()) || (h())) {}
    while (this.jdField_d_of_type_Int == 35) {
      return true;
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((String)this.jdField_a_of_type_JavaUtilList.get(i1)).equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public ArrayList<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      i1 += 1;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  public void d(String paramString)
  {
    ThreadManagerV2.excute(new SelectMemberActivity.8(this, paramString), 32, null, false);
  }
  
  public boolean d()
  {
    this.jdField_e_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(false);
    k();
    r();
    return true;
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
    while (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755147);
    super.doOnCreate(paramBundle);
    i();
    h();
    if ((this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 36)) {}
    ArrayList localArrayList;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 1) {
        super.getWindow().addFlags(524288);
      }
      this.jdField_a_of_type_Baxk = new baxk(this, this.app);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      j();
      b();
      l();
      o();
      d();
      g();
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1))
      {
        paramBundle = (TroopManager)this.app.getManager(52);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.b(this.jdField_c_of_type_JavaLangString);
          if (paramBundle != null) {
            this.jdField_i_of_type_Int = paramBundle.wMemberNum;
          }
        }
        ThreadManager.post(new SelectMemberActivity.1(this), 8, null, true);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      this.jdField_b_of_type_AndroidGraphicsBitmap = bbdr.a();
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aiet(this);
        paramBundle = new IntentFilter();
        paramBundle.addAction("tencent.av.v2q.StopVideoChat");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      }
      if (this.jdField_c_of_type_Int == 30) {
        b(true, true);
      }
      if ((this.jdField_a_of_type_Int != 9003) && (8998 != this.jdField_a_of_type_Int)) {
        break label415;
      }
      this.jdField_a_of_type_Afaz = ((afaz)this.app.getManager(138));
      Object localObject = this.jdField_a_of_type_Afaz.a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label415;
      }
      paramBundle = (ajxn)this.app.getManager(51);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Friends localFriends = paramBundle.e(str);
        if (localFriends != null) {
          localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
        }
      }
    }
    a(localArrayList, false);
    label415:
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      a(paramBundle, false);
    }
    if (this.jdField_c_of_type_Int == 1003) {
      axqw.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 33) {
        axqw.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
      }
      return true;
      if (this.jdField_c_of_type_Int == 1002) {
        axqw.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    removeObserver(this.jdField_a_of_type_Ajvl);
    removeObserver(this.jdField_a_of_type_Ajxl);
    removeObserver(this.jdField_a_of_type_Akim);
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    azoa localazoa = (azoa)this.app.getManager(32);
    if (localazoa != null) {
      localazoa.a(this);
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
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
    b(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
    b(true);
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
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
  
  public void e(String paramString)
  {
    int i1 = 0;
    if (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString))
      {
        this.jdField_e_of_type_JavaUtilArrayList.remove(i1);
        if (this.jdField_a_of_type_Int == 9003) {
          if ((this.jdField_d_of_type_Int != 15) || (this.jdField_a_of_type_Afaz.a(paramString))) {
            break label90;
          }
        }
      }
      for (this.jdField_k_of_type_Int -= 1;; this.jdField_k_of_type_Int -= 1) {
        label90:
        do
        {
          i1 += 1;
          break;
        } while ((this.jdField_d_of_type_Int != 32) || (this.jdField_a_of_type_Afaz.b(paramString)));
      }
    }
    r();
  }
  
  public boolean e()
  {
    return this.z;
  }
  
  public void f(String paramString)
  {
    if ((this.jdField_d_of_type_Int == 38) || (this.jdField_d_of_type_Int == 29) || (this.jdField_d_of_type_Int == 39))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label50;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: empty");
      }
    }
    return;
    label50:
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: troopUin:" + paramString);
    }
    c(paramString);
  }
  
  boolean f()
  {
    boolean bool = g();
    int i2 = this.jdField_e_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.jdField_b_of_type_JavaUtilArrayList.size(); (bool) && (this.jdField_b_of_type_Int == 0) && (i1 + i2 >= 1); i1 = 0) {
      return true;
    }
    return false;
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("SelectMemberActivity", 1, "finish", new Throwable("打印调用栈"));
    }
    ForwardRecentActivity.a(this.jdField_a_of_type_AndroidContentIntent, this);
    super.finish();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      overridePendingTransition(0, 2130771978);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
        p();
      }
      return;
      overridePendingTransition(2130771988, 2130771989);
      continue;
      overridePendingTransition(0, 2130772001);
      continue;
      overridePendingTransition(0, 0);
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    if (this.jdField_c_of_type_Int == 30)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
  }
  
  boolean g()
  {
    return (this.jdField_d_of_type_Int == 27) || (this.jdField_d_of_type_Int == 28) || (this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 29) || (this.jdField_d_of_type_Int == 39);
  }
  
  protected void h()
  {
    setContentView(2131562409);
  }
  
  boolean h()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1);
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.w = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("filer_robot", false);
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_c_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_friends");
    this.jdField_d_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_d_of_type_JavaUtilArrayList == null) {
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_d_of_type_JavaUtilArrayList.add(ajsf.aC);
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
          this.jdField_d_of_type_JavaUtilArrayList.add(localTroopInfo.troopuin);
        }
      }
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", 2147483647);
    int i1;
    if ((localObject2 != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.equals("0", this.jdField_c_of_type_JavaLangString)))
    {
      localObject1 = ((TroopManager)localObject2).b(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null)
      {
        i1 = ((TroopInfo)localObject1).wMemberMax - ((TroopInfo)localObject1).wMemberNum;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mMaxSelectNumber:").append(this.jdField_g_of_type_Int).append(" remain:").append(i1).append("  wMemberMax:").append(((TroopInfo)localObject1).wMemberMax).append("  wMemberNum:").append(((TroopInfo)localObject1).wMemberNum).append("  real mMaxSelectNumber").append(Math.min(this.jdField_g_of_type_Int, i1));
          QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i1 > 0) && (this.jdField_g_of_type_Int > i1))
        {
          this.jdField_g_of_type_Int = i1;
          this.o = true;
        }
      }
    }
    this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.p = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.jdField_h_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_or_discussion_member", false);
    this.jdField_j_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.l = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = getString(2131719200);
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = getString(2131719216);
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.jdField_f_of_type_JavaLangString == null) {
      this.jdField_f_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "({0})");
    }
    this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_back_button_side", 1);
    this.u = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_put_myself_first", false);
    this.v = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_forbid_only_choose_myself", false);
    if ((this.jdField_d_of_type_Int == 14) || (this.jdField_d_of_type_Int == 21))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_default_selected_troop_members");
      if (localObject1 != null) {
        localObject1 = ((ArrayList)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        this.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
        continue;
        if (((this.jdField_d_of_type_Int == 32) || (this.jdField_d_of_type_Int == 35)) && ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)))
        {
          c(-1);
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!this.q) && (this.jdField_c_of_type_JavaUtilArrayList != null))
          {
            i1 = 0;
            if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
            {
              if (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilArrayList.get(i1)))
              {
                localObject2 = new ResultRecord();
                ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString = ((String)this.jdField_c_of_type_JavaUtilArrayList.get(i1));
                if (!this.jdField_i_of_type_Boolean) {
                  break label1051;
                }
              }
              label1051:
              for (int i2 = 2;; i2 = 1)
              {
                ((ResultRecord)localObject2).jdField_a_of_type_Int = i2;
                ((ResultRecord)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
                this.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
                i1 += 1;
                break;
              }
            }
          }
        }
        else if ((this.jdField_d_of_type_Int == 17) && (this.jdField_c_of_type_JavaUtilArrayList != null))
        {
          i1 = 0;
          while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
          {
            if (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilArrayList.get(i1)))
            {
              localObject1 = new ResultRecord();
              ((ResultRecord)localObject1).jdField_a_of_type_JavaLangString = ((String)this.jdField_c_of_type_JavaUtilArrayList.get(i1));
              this.jdField_e_of_type_JavaUtilArrayList.add(localObject1);
            }
            i1 += 1;
          }
        }
      }
    }
    this.r = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @TargetApi(14)
  protected void j()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131375491);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localRelativeLayout.setFitsSystemWindows(true);
      }
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377369);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368431));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368457));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)findViewById(2131375814));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369298));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131379163));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375187);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131377540);
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_e_of_type_AndroidViewView = findViewById(2131377541);
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364838);
    if (c())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364837));
      if (this.jdField_d_of_type_Int != 35) {
        break label456;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_e_of_type_JavaLangString);
    }
    label456:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, bool);
      if (g())
      {
        int i1 = getIntent().getIntExtra("create_source", 0);
        axqw.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", "" + i1, "", "");
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidViewView = findViewById(2131375815);
        this.jdField_g_of_type_AndroidViewView = findViewById(2131366335);
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363588));
        if (this.jdField_b_of_type_AndroidWidgetButton != null) {
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        }
        return;
        if (h())
        {
          this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131713723));
          n();
        }
      }
    }
  }
  
  public void k()
  {
    if (this.jdField_c_of_type_Int == 30) {
      return;
    }
    if (this.jdField_e_of_type_JavaUtilArrayList.size() >= this.jdField_h_of_type_Int)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  @SuppressLint({"NewApi"})
  protected void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(this.jdField_e_of_type_JavaUtilArrayList, this.jdField_a_of_type_Baxk, this.jdField_a_of_type_Acay);
    if (((this.jdField_e_of_type_JavaUtilArrayList.size() != 0) && ((this.jdField_d_of_type_Int == 14) || (this.jdField_d_of_type_Int == 21))) || (this.jdField_d_of_type_Int == 32))
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (this.jdField_d_of_type_Int == 32)
        {
          if (localResultRecord.jdField_a_of_type_Int == 1) {
            localResultRecord.b = bbcl.h(this.app, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
          } else if (localResultRecord.jdField_a_of_type_Int == 2) {
            localResultRecord.b = bbcl.a(this.app, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
          }
        }
        else {
          localResultRecord.b = bbcl.h(this.app, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new aien(this));
  }
  
  public void m()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1500L) {}
    azoa localazoa;
    do
    {
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      localazoa = (azoa)this.app.getManager(32);
    } while (localazoa == null);
    Object localObject = new JSONObject();
    label527:
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("group_type", 1);
        ((JSONObject)localObject).put("name", bbcl.h(this.app, this.app.getCurrentAccountUin()) + ajyc.a(2131713742));
        ((JSONObject)localObject).put("classify", 10010);
        if ((this.jdField_d_of_type_Int != 12) && (this.jdField_d_of_type_Int != 36)) {
          ((JSONObject)localObject).put("isJumpAio", 1);
        }
        i1 = this.jdField_d_of_type_Int;
        if (i1 == 12) {
          i1 = 3;
        }
        ArrayList localArrayList;
        String str;
        ResultRecord localResultRecord;
        if (this.jdField_c_of_type_Int != 1002) {
          break;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((JSONObject)localObject).put("create_source", i1);
          localazoa.a(((JSONObject)localObject).toString(), 5);
          axqw.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + i1, "", "");
          localArrayList = new ArrayList(this.jdField_e_of_type_JavaUtilArrayList.size());
          localArrayList.addAll(this.jdField_e_of_type_JavaUtilArrayList);
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            continue;
          }
          localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          str = (String)((Iterator)localObject).next();
          localResultRecord = new ResultRecord();
          localResultRecord.jdField_a_of_type_JavaLangString = str;
          localResultRecord.jdField_a_of_type_Int = 0;
          localResultRecord.jdField_c_of_type_JavaLangString = "-1";
          localResultRecord.b = bbcl.b(this.app, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.jdField_a_of_type_Int);
          localArrayList.add(localResultRecord);
          continue;
          if (this.jdField_d_of_type_Int == 28)
          {
            i1 = 5;
            continue;
          }
          if (this.jdField_d_of_type_Int == 39)
          {
            i1 = 8;
            continue;
          }
          if (this.jdField_d_of_type_Int == 29)
          {
            i1 = 2;
            continue;
          }
          if (this.jdField_d_of_type_Int != 27) {
            break label527;
          }
          i1 = getIntent().getIntExtra("create_source", 0);
          continue;
          localJSONException1 = localJSONException1;
          i1 = 0;
        }
        catch (JSONException localJSONException2)
        {
          continue;
          int i1 = 0;
        }
        QLog.e("SelectMemberActivity", 1, "createNewTypeDiscussion json error!", localJSONException1);
        continue;
        localazoa.b(this, this, localJSONException1);
        if (this.jdField_c_of_type_Int == 1003)
        {
          axqw.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
          return;
        }
      }
      axqw.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected void n()
  {
    Object localObject = ((TroopManager)this.app.getManager(52)).c(this.jdField_c_of_type_JavaLangString);
    boolean bool1;
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x6100000) != 0L) {
        break label229;
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
          break label474;
        }
        if (((TroopInfo)localObject).wMemberNum + this.jdField_e_of_type_JavaUtilArrayList.size() <= ((TroopInfo)localObject).maxInviteMemNum) {
          break label338;
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
          this.x = false;
          if ((this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 36)) {
            this.jdField_g_of_type_JavaLangString = getString(2131695893);
          }
        }
        for (;;)
        {
          if ((this.y) || (!this.x) || (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
            break label464;
          }
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          localObject = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131377542);
          ((TextView)localObject).setText(this.jdField_h_of_type_JavaLangString);
          ((TextView)localObject).setContentDescription(this.jdField_h_of_type_JavaLangString);
          return;
          label229:
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.jdField_e_of_type_JavaUtilArrayList.size() > 50)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.jdField_e_of_type_JavaUtilArrayList.size() > 100)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label479;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label54;
          label338:
          bool1 = false;
          break label82;
          this.jdField_g_of_type_JavaLangString = ajyc.a(2131713750);
          continue;
          if ((!bool2) && (bool1))
          {
            this.x = true;
            this.jdField_h_of_type_JavaLangString = ajyc.a(2131713731);
            this.jdField_g_of_type_JavaLangString = ajyc.a(2131713760);
          }
          else if ((bool2) && (bool1))
          {
            this.x = true;
            this.jdField_h_of_type_JavaLangString = ajyc.a(2131713747);
            this.jdField_g_of_type_JavaLangString = ajyc.a(2131713736);
          }
          else if ((bool2) && (!bool1))
          {
            this.x = true;
            this.jdField_h_of_type_JavaLangString = ajyc.a(2131713727);
            this.jdField_g_of_type_JavaLangString = ajyc.a(2131713738);
          }
        }
        label464:
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
        label474:
        bool1 = false;
      }
      label479:
      bool1 = false;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new aiec(this));
  }
  
  public boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()))
    {
      p();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
      p();
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    }
    for (;;)
    {
      return super.onBackEvent();
      q();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
      if (this.jdField_k_of_type_Boolean)
      {
        if (this.jdField_d_of_type_Int == 27)
        {
          this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
          setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
        }
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      }
      if (this.jdField_h_of_type_Boolean) {
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      }
      if (this.jdField_i_of_type_Boolean) {
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      }
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    label147:
    ResultRecord localResultRecord;
    Intent localIntent;
    int i1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377541: 
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.y = true;
      axqw.b(this.app, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, this.jdField_c_of_type_JavaLangString, mud.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
      return;
    case 2131364837: 
      if (this.jdField_d_of_type_Int == 35)
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() >= 1)
        {
          paramView = "1";
          axqw.b(this.app, "CliOper", "", "", "0X8009E2B", "0X8009E2B", 0, 0, paramView, "", "", "");
        }
      }
      else
      {
        if ((this.jdField_d_of_type_Int != 12) || (this.jdField_e_of_type_JavaUtilArrayList.size() != 1)) {
          break label442;
        }
        localResultRecord = (ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(0);
        localIntent = new Intent();
        localIntent.putExtra("select_memeber_single_friend", true);
        localIntent.putExtra("select_memeber_single_friend_type", localResultRecord.jdField_a_of_type_Int);
        if ((localResultRecord.jdField_a_of_type_Int == 0) && (localResultRecord.jdField_a_of_type_Int != 1)) {
          break label766;
        }
        i1 = 1000;
      }
      break;
    }
    for (paramView = a(localResultRecord.jdField_c_of_type_JavaLangString);; paramView = null)
    {
      if (localResultRecord.jdField_a_of_type_Int == 2)
      {
        paramView = localResultRecord.jdField_c_of_type_JavaLangString;
        i1 = 1004;
      }
      for (;;)
      {
        if (localResultRecord.jdField_a_of_type_Int == 3) {
          i1 = 1021;
        }
        for (;;)
        {
          Object localObject = ((ajxn)this.app.getManager(51)).e(localResultRecord.jdField_a_of_type_JavaLangString);
          int i2 = i1;
          if (localObject != null)
          {
            i2 = i1;
            if (((Friends)localObject).isFriend()) {
              i2 = 0;
            }
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("uin", localResultRecord.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putInt("uintype", i2);
          ((Bundle)localObject).putString("uinname", localResultRecord.b);
          ((Bundle)localObject).putString("troop_uin", paramView);
          localIntent.putExtras((Bundle)localObject);
          setResult(-1, localIntent);
          finish();
          return;
          paramView = "2";
          break label147;
          if (localResultRecord.jdField_a_of_type_Int == 4)
          {
            i1 = 1006;
            continue;
            label442:
            if (g())
            {
              m();
              return;
            }
            if (h())
            {
              if (this.jdField_d_of_type_Int == 11)
              {
                paramView = a();
                if (paramView.size() > 0)
                {
                  bbcv.a(this, 230, getString(2131695994), getString(2131695875), 2131695731, 2131695743, new aiei(this, paramView), new aiej(this)).show();
                  return;
                }
                a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin"), false);
                return;
              }
              if (this.jdField_d_of_type_Int == 37)
              {
                this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
                setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
                finish();
                return;
              }
              a(this.jdField_e_of_type_JavaUtilArrayList);
              return;
            }
            this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
            setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
            finish();
            return;
            p();
            if (a().size() == 1)
            {
              paramView = (String)a().get(0);
              if (this.jdField_a_of_type_Aies == null) {
                break;
              }
              this.jdField_a_of_type_Aies.b(paramView);
              return;
            }
            paramView = new Intent();
            paramView.putExtra("TROOP_UIN", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin"));
            paramView.putExtra("hide_title_left_arrow", true);
            PublicFragmentActivity.a(this, paramView, UnitedVerifyMsgEditFragment.class, 10);
            overridePendingTransition(2130771997, 2130771990);
            paramView = getIntent().getStringExtra("group_uin");
            if (TextUtils.isEmpty(paramView)) {
              break;
            }
            ThreadManager.post(new SelectMemberActivity.19(this, paramView), 5, null, true);
            return;
          }
        }
      }
      label766:
      i1 = 0;
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  void p()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.z = false;
  }
  
  public void q()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  protected void r()
  {
    boolean bool = false;
    String str = null;
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label339;
      }
      if (i1 >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(a(), this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (c())
      {
        i1 = this.jdField_e_of_type_JavaUtilArrayList.size();
        if (i1 <= 0) {
          break label269;
        }
        if (this.jdField_d_of_type_Int != 35) {
          break label226;
        }
        str = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, true);
      }
      if (h()) {
        n();
      }
      return;
    }
    if (str == null)
    {
      str = localResultRecord.b;
      label187:
      i1 += 1;
    }
    label269:
    label339:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.b;
      break label187;
      label226:
      if (g()) {}
      for (str = ajyc.a(2131713756);; str = ajyc.a(2131713733))
      {
        str = MessageFormat.format(str, new Object[] { Integer.valueOf(i1) });
        break;
      }
      if (this.jdField_d_of_type_Int == 35)
      {
        str = this.jdField_e_of_type_JavaLangString;
        bool = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, bool);
        break;
        if (g()) {
          str = ajyc.a(2131713724);
        } else {
          str = ajyc.a(2131713758);
        }
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void s()
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_e_of_type_JavaUtilArrayList.size() > 0))
    {
      Object localObject = b();
      Intent localIntent = new Intent("tencent.video.q2v.SelectMember");
      localIntent.setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject).size() > 0) {
        localIntent.putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject);
      }
      int i1 = this.jdField_e_of_type_JavaUtilArrayList.size();
      localObject = ((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(0)).b;
      localIntent.putExtra("InviteCount", i1);
      localIntent.putExtra("FirstName", (String)localObject);
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  void t()
  {
    int i1 = 0;
    if (this.jdField_d_of_type_Int != 35) {}
    RelativeLayout localRelativeLayout;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false));
      localRelativeLayout = (RelativeLayout)findViewById(2131375427);
    } while (localRelativeLayout == null);
    if (this.q) {}
    for (;;)
    {
      localRelativeLayout.setVisibility(i1);
      return;
      i1 = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */