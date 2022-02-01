package com.tencent.mobileqq.activity;

import Override;
import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniGetRsp;
import QC.UniSetReq;
import QC.UniSetRsp;
import adjq;
import adjr;
import adjs;
import adjt;
import adju;
import adjv;
import adjw;
import adjx;
import adjy;
import adjz;
import adka;
import adkb;
import adkc;
import adkd;
import adke;
import adkf;
import adkg;
import adkh;
import adki;
import adkj;
import adkk;
import adkl;
import adkn;
import adko;
import adkp;
import adkq;
import adkr;
import adks;
import adkt;
import afur;
import ahdx;
import ahdy;
import aiwt;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anip;
import aniz;
import anmu;
import anmw;
import anni;
import anpk;
import anwd;
import anxg;
import anyj;
import aoch;
import aqlj;
import aqrq;
import asmj;
import awnc;
import bcnj;
import bcst;
import bdnt;
import bdob;
import bdoh;
import bfpo;
import bfup;
import bght;
import bgjt;
import bgjw;
import bglf;
import bglp;
import bgme;
import bgmo;
import bgnt;
import bgny;
import bgpa;
import bgyp;
import bhcb;
import biau;
import bjft;
import bjha;
import bkho;
import bkif;
import blfh;
import blfq;
import bqkd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.vas.PobingDecoder;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements ahdy, TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, bfpo
{
  public static final boolean a;
  private static int jdField_i_of_type_Int = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  adks jdField_a_of_type_Adks;
  private ahdx jdField_a_of_type_Ahdx;
  public Dialog a;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new adjw(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adkd(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new adkk(this);
  public InputMethodManager a;
  public EditText a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private aniz jdField_a_of_type_Aniz = new adjx(this);
  private anmu jdField_a_of_type_Anmu = new adjy(this);
  private anxg jdField_a_of_type_Anxg = new adka(this);
  private awnc<bgyp> jdField_a_of_type_Awnc = new adki(this);
  public bgpa a;
  public biau a;
  private bjha jdField_a_of_type_Bjha = new adjz(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  public KplRoleInfo.WZRYUIinfo a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  protected FormSwitchItem a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public String a;
  private ArrayList<EditText> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  adks jdField_b_of_type_Adks;
  public EditText b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  protected String b;
  private ArrayList<PhoneContact> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  private int jdField_c_of_type_Int;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  public TextView c;
  public String c;
  public boolean c;
  private int jdField_d_of_type_Int = 2000;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 1000;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString;
  private TextView l;
  private TextView m;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  }
  
  public AddFriendVerifyActivity()
  {
    this.jdField_b_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new adkc(this);
  }
  
  private String a()
  {
    Object localObject3 = ((anmw)this.app.getManager(51)).b(this.app.c());
    Object localObject2 = "";
    String str = "";
    Object localObject1 = "";
    int i1 = 0;
    int n;
    Object localObject4;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      n = ((Card)localObject3).shGender;
      if (((Card)localObject3).shGender == 0)
      {
        localObject1 = getString(2131693461);
        i1 = ((Card)localObject3).age;
        str = ((Card)localObject3).strProvince;
        localObject2 = ((Card)localObject3).strCity;
        i1 = ((Card)localObject3).constellation;
        localObject4 = bght.c(((Card)localObject3).constellation);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(str);
      localObject4 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject4 = "";
      }
      if ((bool) && (i1 == 0) && (n == -1)) {
        localObject1 = anni.a(2131698649);
      }
      for (;;)
      {
        return (String)localObject1 + "~";
        localObject1 = localObject2;
        if (((Card)localObject3).shGender != 1) {
          break;
        }
        localObject1 = getString(2131692055);
        break;
        if ((bool) && (i1 == 0)) {
          localObject1 = anni.a(2131698667);
        } else if ((bool) && (n == -1)) {
          localObject1 = anni.a(2131698664);
        } else if ((i1 == 0) && (n == -1)) {
          localObject1 = anni.a(2131698655) + str + (String)localObject4;
        } else if (i1 == 0) {
          localObject1 = anni.a(2131698676) + str + (String)localObject4;
        } else if (n == -1) {
          localObject1 = anni.a(2131698657) + str + (String)localObject4 + anni.a(2131698663) + (String)localObject2 + anni.a(2131698652);
        } else if (bool) {
          localObject1 = (String)localObject2 + (String)localObject3 + anni.a(2131698653);
        } else {
          localObject1 = anni.a(2131698669) + str + (String)localObject4 + anni.a(2131698648) + (String)localObject2 + (String)localObject3 + anni.a(2131698672);
        }
      }
      localObject3 = "";
      localObject2 = "";
      n = -1;
    }
  }
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Int == 3090) {}
    try
    {
      ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AddFriendVerifyActivity", 1, "feedBackToGameSDK error = " + paramString);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable == null) || (this.app == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Bitmap localBitmap = bgmo.a(paramURLDrawable);
    if (paramURLDrawable.getStatus() == 1)
    {
      paramURLDrawable = this.app;
      paramURLDrawable = QQAppInterface.a(localBitmap, 50, 50);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramURLDrawable));
      return;
    }
    paramURLDrawable.setURLDrawableListener(new adjt(this));
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 416	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 418	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 421	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 424	bgmo:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 421	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 430	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload_2
    //   36: astore_3
    //   37: aload_0
    //   38: invokestatic 435	bfup:a	(Ljava/lang/String;)I
    //   41: istore_1
    //   42: aload_2
    //   43: astore_3
    //   44: iload_1
    //   45: ifeq +34 -> 79
    //   48: aload_2
    //   49: astore 4
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: iload_1
    //   55: i2f
    //   56: invokestatic 438	bgmo:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   59: astore_0
    //   60: aload_0
    //   61: astore_3
    //   62: aload_0
    //   63: ifnull +16 -> 79
    //   66: aload_0
    //   67: astore 4
    //   69: aload_0
    //   70: astore_3
    //   71: aload_0
    //   72: aload 5
    //   74: invokestatic 441	bgmo:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 446	android/graphics/Bitmap:recycle	()V
    //   87: return
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 449	java/lang/OutOfMemoryError:printStackTrace	()V
    //   93: return
    //   94: astore_0
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   102: aload 4
    //   104: ifnull -17 -> 87
    //   107: aload 4
    //   109: invokevirtual 446	android/graphics/Bitmap:recycle	()V
    //   112: return
    //   113: astore_0
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 446	android/graphics/Bitmap:recycle	()V
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   41	14	1	n	int
    //   21	33	2	localObject1	Object
    //   36	83	3	localObject2	Object
    //   33	75	4	localObject3	Object
    //   8	65	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   22	32	88	java/lang/OutOfMemoryError
    //   37	42	94	java/io/IOException
    //   53	60	94	java/io/IOException
    //   71	77	94	java/io/IOException
    //   37	42	113	finally
    //   53	60	113	finally
    //   71	77	113	finally
    //   98	102	113	finally
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Biau.c(2131717771);
    this.jdField_a_of_type_Biau.show();
    anwd localanwd = (anwd)this.app.a(20);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localanwd.a(paramString1, paramString2, paramInt1, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, a(this.jdField_g_of_type_Int, this.jdField_i_of_type_JavaLangString, paramString2, l1, l2, paramInt2), this.jdField_j_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        paramString2 = "2";
        bcst.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
        bgjt.a(this.jdField_a_of_type_JavaLangString, 1, 0, paramInt1);
        if (!this.jdField_c_of_type_Boolean) {
          break label334;
        }
        bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean == true) && (!this.jdField_c_of_type_Boolean)) {
        bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean == true)) {
        bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      this.jdField_f_of_type_Int = 1001;
      ((anpk)this.app.getManager(159)).e(this.jdField_f_of_type_JavaLangString);
      return;
      paramString2 = "0";
      break;
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        paramString2 = "1";
        break;
      }
      paramString2 = "3";
      break;
      label334:
      bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (bgnt.a(this) == 0)
    {
      QQToast.a(this, 2131695494, 0).b(getTitleBarHeight());
      d();
    }
    while (((TroopManager)this.app.getManager(52) == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    ((anwd)this.app.a(20)).a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramBoolean, true);
  }
  
  private boolean a()
  {
    int n = getIntent().getExtras().getInt("source_id", 3999);
    return (n == 3003) || (n == 3006) || (n == 3007) || (n == 3009) || (n == 3013);
  }
  
  private void b()
  {
    getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
  }
  
  private void b(int paramInt)
  {
    String str3 = anni.a(2131698682);
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      QLog.e("AddFriendVerifyActivity", 1, "showPayDialog, UNKOWN errorCode: " + paramInt);
      return;
    case 4002: 
      str2 = anni.a(2131698644);
      paramInt = 1;
      str1 = "LTMCLUB";
    case 5002: 
    case 12002: 
      for (;;)
      {
        bcst.b(null, "dc00898", "", "", "qq_vip", "0X800A4FA", paramInt, 0, "", "", "", "");
        String str4 = String.format(anni.a(2131698666), new Object[] { str2, str2 });
        str2 = String.format(anni.a(2131698670), new Object[] { str2 });
        bglp.a(this, 230, str3, str4, anni.a(2131698681), str2, new adkf(this, str1, paramInt), new adkg(this)).show();
        return;
        str2 = anni.a(2131698651);
        paramInt = 2;
        str1 = "CJCLUBT";
        continue;
        str2 = anni.a(2131698650);
        paramInt = 3;
        str1 = "SVHHZLH";
      }
    }
    QQToast.a(this, 1, anni.a(2131698668), 1).a();
  }
  
  private boolean b()
  {
    return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
  }
  
  private void c()
  {
    if (aiwt.a(this.app) != null)
    {
      int n = getIntent().getIntExtra("friend_setting", 0);
      int i1 = getIntent().getIntExtra("source_id", 3999);
      String str = getIntent().getExtras().getString("extra");
      int i2 = getIntent().getIntExtra("sub_source_id", 0);
      aiwt.a(this.app).a(this.jdField_f_of_type_JavaLangString, n, i1, i2, str);
    }
  }
  
  private boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = l1;
    if ((l2 > 1000L) && (this.jdField_f_of_type_Int != 1001) && (!this.jdField_d_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AddFriendVerifyActivity", 1, String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", new Object[] { Long.valueOf(l2), Integer.valueOf(this.jdField_f_of_type_Int), Boolean.valueOf(this.jdField_d_of_type_Boolean), Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(1));
    this.jdField_c_of_type_Boolean = ((TroopManager)this.app.getManager(52)).d(this.jdField_a_of_type_JavaLangString);
    localSwitch.setChecked(this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean == true) {}
    for (String str = getString(2131695488);; str = getString(2131695492))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void e()
  {
    bkho localbkho = (bkho)bkif.a(this, null);
    localbkho.a(2131717758, 5);
    localbkho.a(2131717750, 5);
    localbkho.c(2131690582);
    localbkho.a(new adke(this, localbkho));
    if (!localbkho.isShowing()) {
      localbkho.show();
    }
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_a_of_type_AndroidAppDialog = bglp.a(this, paramString, 0, 2131693857, null, new adkj(this, paramString));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AddFriendVerifyActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  private void f(String paramString)
  {
    runOnUiThread(new AddFriendVerifyActivity.30(this));
  }
  
  public void a()
  {
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      finish();
      return;
    }
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null) {
      for (;;)
      {
        Intent localIntent2;
        try
        {
          localObject = Class.forName((String)localObject);
          localIntent2 = new Intent();
          localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject).getName()));
          if ((localObject.equals(FriendProfileCardActivity.class)) || (localObject.equals(QidianProfileCardActivity.class)))
          {
            ProfileActivity.a(this, this.jdField_f_of_type_JavaLangString, localIntent2);
            localIntent2.setFlags(67108864);
            localIntent2.putExtra("key_back_from_add_friend", true);
            startActivity(localIntent2);
            return;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "goBack | exception = ", localClassNotFoundException);
          }
          localClassNotFoundException.printStackTrace();
          setResult(-1);
          finish();
          return;
        }
        if (localClassNotFoundException.equals(NearbyPeopleProfileActivity.class))
        {
          localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_f_of_type_JavaLangString, 41));
          localIntent2.putExtra("param_mode", 3);
        }
      }
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.jdField_f_of_type_JavaLangString);
      setResult(-1, localIntent1);
    }
    for (;;)
    {
      finish();
      return;
      a(0, "");
      setResult(-1);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2000)
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167060));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundResource(2130850338);
      int n = afur.a(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(n, n, n, n);
      this.jdField_c_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131166986));
    }
    label283:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "select: " + paramInt + " server: " + this.jdField_d_of_type_Int);
      }
      Object localObject;
      if (this.jdField_d_of_type_Int != paramInt)
      {
        localObject = (anyj)this.app.a(27);
        if (localObject != null)
        {
          UniSetReq localUniSetReq = new UniSetReq();
          localUniSetReq.stUniBusinessItem = new UniBusinessItem(40, paramInt);
          ((anyj)localObject).a(localUniSetReq, new adkt(this, paramInt), false);
        }
      }
      else
      {
        return;
        localObject = (bgyp)BaseApplicationImpl.sImageCache.get(bhcb.a(paramInt));
        if (localObject == null) {
          new PobingDecoder(paramInt, bhcb.a, this.jdField_a_of_type_Awnc);
        }
        for (;;)
        {
          if (!bcnj.b()) {
            break label283;
          }
          bglp.a(this, 0, anni.a(2131698677), anni.a(2131698671), null, anni.a(2131698646), new adkh(this), null).show();
          break;
          this.jdField_a_of_type_Awnc.postQuery(localObject);
        }
      }
    }
    QLog.e("AddFriendVerifyActivity", 1, "set fail, VipInfoHandler is null");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new AddFriendVerifyActivity.31(this, paramInt1, getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 3: 
      if ((paramBoolean) && ((paramObject instanceof UniGetRsp)))
      {
        paramObject = ((UniGetRsp)paramObject).uniBusinessItemList.iterator();
        while (paramObject.hasNext())
        {
          UniBusinessItem localUniBusinessItem = (UniBusinessItem)paramObject.next();
          if (localUniBusinessItem.appid == 40)
          {
            this.jdField_d_of_type_Int = localUniBusinessItem.itemid;
            this.jdField_a_of_type_Ahdx.a(localUniBusinessItem.itemid);
            QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + this.jdField_d_of_type_Int);
            return;
          }
        }
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP nothing: " + this.jdField_d_of_type_Int);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + paramBoolean + " data=" + paramObject);
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)))
    {
      paramObject = (UniSetRsp)paramObject;
      if (paramObject.ret == 0)
      {
        this.jdField_d_of_type_Int = paramInt2;
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP success: " + this.jdField_d_of_type_Int);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramObject.ret + " msg:" + paramObject.errmsg);
      b(paramObject.ret);
      this.jdField_a_of_type_Ahdx.a(this.jdField_d_of_type_Int);
      return;
    }
    QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramBoolean + " data=" + paramObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "saveVerifyMsg return from wzry");
      }
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), paramString).commit();
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!bgnt.d(this)) {}
    int i2;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131693991), 0).b(getTitleBarHeight());
      for (;;)
      {
        return;
        if (!isFinishing())
        {
          if (this.jdField_a_of_type_Biau == null)
          {
            this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
            this.jdField_a_of_type_Biau.setOnDismissListener(new adju(this));
          }
          this.jdField_a_of_type_Biau.c(2131717771);
          this.jdField_a_of_type_Biau.setCancelable(true);
          this.jdField_a_of_type_Biau.setCanceledOnTouchOutside(false);
          try
          {
            this.jdField_a_of_type_Biau.show();
            Intent localIntent = getIntent();
            i2 = localIntent.getIntExtra("sub_source_id", 0);
            int i1 = localIntent.getIntExtra("friend_setting", 0);
            int n = i1;
            if (i1 == 3) {
              n = 100;
            }
            boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
            String str = localIntent.getStringExtra("src_name");
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, localIntent.getStringExtra("extra"), n, (byte)this.jdField_a_of_type_Int, paramString1, this.jdField_b_of_type_Int, i2, true, paramArrayOfByte, bool, this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"));
            if (!AutoRemarkActivity.a(n, this.jdField_b_of_type_Int, bool)) {
              ((anmw)this.app.getManager(51)).a(this.jdField_f_of_type_JavaLangString, true);
            }
            if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_e_of_type_JavaLangString)) {
              bcst.b(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
            }
            if (localIntent.getIntExtra("sort_id", 0) == 3090) {
              bcst.b(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
            }
            if (this.jdField_b_of_type_Int == 3094) {
              if (i2 == 1)
              {
                bcst.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092E3", "0X80092E3", 0, 0, "", asmj.a(), asmj.a(this.app), asmj.c());
                return;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, localException.toString());
              }
            }
            if (i2 == 2)
            {
              bcst.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092CC", "0X80092CC", 0, 0, "", "", asmj.a(this.app), "");
              return;
            }
            if (i2 == 8)
            {
              bcst.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_e_of_type_Int, 0, "", "", "", "");
              return;
            }
          }
        }
      }
    } while (i2 != 9);
    bcst.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_e_of_type_Int, 0, "", "", "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramJSONObject == null);
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
        paramJSONObject = (JSONObject)paramJSONObject.get("result");
        if ((paramInt != 0) || (paramJSONObject == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
        }
        paramBundle = (JSONObject)paramJSONObject.get("basics");
        Object localObject2;
        if (paramBundle != null)
        {
          paramBundle = (JSONArray)paramBundle.get("datas");
          if (paramBundle != null)
          {
            paramInt = 0;
            if (paramInt < paramBundle.length())
            {
              localObject2 = (JSONObject)paramBundle.get(paramInt);
              str = (String)((JSONObject)localObject2).get("name");
              n = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (!QLog.isColorLevel()) {
                break label761;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, basics name = " + str + " state = " + n + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
              break label761;
            }
          }
        }
        paramBundle = (JSONObject)paramJSONObject.get("friendlink");
        if (paramBundle != null)
        {
          paramBundle = (JSONArray)paramBundle.get("datas");
          if (paramBundle != null)
          {
            paramInt = 0;
            if (paramInt < paramBundle.length())
            {
              localObject2 = (JSONObject)paramBundle.get(paramInt);
              str = (String)((JSONObject)localObject2).get("name");
              n = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (("add_friend".equals(localObject1)) && (n != 1)) {
                f(getActivity().getResources().getString(2131718772));
              }
              if (!QLog.isColorLevel()) {
                break label768;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, friendlink name = " + str + " state = " + n + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
              break label768;
            }
          }
        }
        paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, appid =" + paramInt + "\n");
        }
        paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
        if (paramJSONObject == null) {
          break;
        }
        paramJSONObject = (JSONArray)paramJSONObject.get("datas");
        if (paramJSONObject == null) {
          break;
        }
        paramInt = 0;
        if (paramInt >= paramJSONObject.length()) {
          break;
        }
        Object localObject1 = (JSONObject)paramJSONObject.get(paramInt);
        paramBundle = (String)((JSONObject)localObject1).get("name");
        int n = ((Integer)((JSONObject)localObject1).get("state")).intValue();
        String str = (String)((JSONObject)localObject1).get("api");
        localObject1 = (String)((JSONObject)localObject1).get("msg");
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + n + " api = " + str + " msg= " + (String)localObject1 + "\n");
        }
        paramInt += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramJSONObject) {}
      QLog.d("AddFriendVerifyActivity", 2, "checkApiState onResult " + paramJSONObject.toString());
      return;
      label761:
      paramInt += 1;
      continue;
      label768:
      paramInt += 1;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 266	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 266	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1253	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1254	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 266	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +153 -> 181
    //   31: new 1256	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1257	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 10
    //   40: new 1259	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1260	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 11
    //   49: aload 11
    //   51: getfield 1264	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1270	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 1276	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 10
    //   63: getfield 1280	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 11
    //   68: invokevirtual 1283	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1287	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 10
    //   77: invokevirtual 1292	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1256	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1257	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: getfield 1296	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_3
    //   95: iload 8
    //   97: invokestatic 1299	anwd:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   100: invokevirtual 1302	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   103: aload_2
    //   104: getfield 1287	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   107: aload 10
    //   109: invokevirtual 1292	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   112: new 1256	tencent/im/msg/im_msg_body$Elem
    //   115: dup
    //   116: invokespecial 1257	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   119: astore_3
    //   120: new 1304	tencent/im/msg/im_msg_body$GeneralFlags
    //   123: dup
    //   124: invokespecial 1305	tencent/im/msg/im_msg_body$GeneralFlags:<init>	()V
    //   127: astore 10
    //   129: new 1307	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   132: dup
    //   133: invokespecial 1308	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: getfield 1312	tencent/im/msg/hummer/resv/generalflags$ResvAttr:uint32_troop_pobing_template	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iload 8
    //   145: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   148: aload 10
    //   150: getfield 1319	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: aload 11
    //   155: invokevirtual 1323	tencent/im/msg/hummer/resv/generalflags$ResvAttr:toByteArray	()[B
    //   158: invokestatic 1327	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 1276	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   164: aload_3
    //   165: getfield 1331	tencent/im/msg/im_msg_body$Elem:general_flags	Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   168: aload 10
    //   170: invokevirtual 1332	tencent/im/msg/im_msg_body$GeneralFlags:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   173: aload_2
    //   174: getfield 1287	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: aload_3
    //   178: invokevirtual 1292	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: new 1334	tencent/im/msg/im_msg_body$MsgBody
    //   184: dup
    //   185: invokespecial 1335	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: getfield 1339	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   193: aload_2
    //   194: invokevirtual 1340	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   197: new 1342	tencent/im/msg/im_msg$Msg
    //   200: dup
    //   201: invokespecial 1343	tencent/im/msg/im_msg$Msg:<init>	()V
    //   204: astore 11
    //   206: aload 11
    //   208: getfield 1347	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   211: aload_3
    //   212: invokevirtual 1348	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   215: new 1350	tencent/im/msg/im_msg$Group
    //   218: dup
    //   219: invokespecial 1351	tencent/im/msg/im_msg$Group:<init>	()V
    //   222: astore_3
    //   223: new 1353	tencent/im/msg/im_common$User
    //   226: dup
    //   227: invokespecial 1354	tencent/im/msg/im_common$User:<init>	()V
    //   230: astore 12
    //   232: aload 12
    //   234: getfield 1357	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: lload 4
    //   239: invokevirtual 1362	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   242: aload 12
    //   244: getfield 1365	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: sipush 1001
    //   250: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   253: aload 12
    //   255: getfield 1368	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: iconst_1
    //   259: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload 12
    //   264: getfield 1372	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   267: invokestatic 1376	dw:a	()J
    //   270: l2i
    //   271: invokevirtual 1379	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   274: aload 12
    //   276: getfield 1382	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: bipush 109
    //   281: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   284: aload 12
    //   286: getfield 1385	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokestatic 1387	com/tencent/common/config/AppSetting:a	()I
    //   292: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   295: aload_3
    //   296: getfield 1391	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   299: aload 12
    //   301: invokevirtual 1392	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   304: aload_3
    //   305: getfield 1391	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   308: getfield 1357	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   311: lload 4
    //   313: invokevirtual 1362	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   316: new 1394	tencent/im/msg/im_common$GroupInfo
    //   319: dup
    //   320: invokespecial 1395	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   323: astore_2
    //   324: aload_3
    //   325: getfield 1399	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   328: aload_2
    //   329: invokevirtual 1400	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 1399	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   336: getfield 1403	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 6
    //   341: invokevirtual 1362	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: aload_3
    //   345: getfield 1399	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   348: getfield 1407	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   351: iconst_1
    //   352: invokevirtual 1410	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   355: new 1412	tencent/im/msg/im_msg$RoutingHead
    //   358: dup
    //   359: invokespecial 1413	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: getfield 1417	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   367: aload_3
    //   368: invokevirtual 1418	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: new 1420	tencent/im/msg/im_msg$ContentHead
    //   374: dup
    //   375: invokespecial 1421	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   378: astore_3
    //   379: aload_3
    //   380: getfield 1424	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: astore 10
    //   385: getstatic 87	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_i_of_type_Int	I
    //   388: istore_1
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: putstatic 87	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_i_of_type_Int	I
    //   395: aload 10
    //   397: iload_1
    //   398: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   401: new 1426	tencent/im/msg/im_msg$MsgHead
    //   404: dup
    //   405: invokespecial 1427	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   408: astore 10
    //   410: aload 10
    //   412: getfield 1431	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   415: aload_3
    //   416: invokevirtual 1432	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   419: aload 10
    //   421: getfield 1436	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   424: aload_2
    //   425: invokevirtual 1437	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   428: aload 11
    //   430: getfield 1441	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   433: aload 10
    //   435: invokevirtual 1442	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   438: new 1444	tencent/im/msg/im_imagent$Signature
    //   441: dup
    //   442: invokespecial 1445	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   445: astore 13
    //   447: aload 13
    //   449: getfield 1448	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: iconst_1
    //   453: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   456: aload 13
    //   458: getfield 1451	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: sipush 256
    //   464: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   467: aload_0
    //   468: getfield 206	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   471: invokestatic 1456	bjsy:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   474: astore_2
    //   475: aload_2
    //   476: invokestatic 266	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: istore 9
    //   481: aload_2
    //   482: astore 10
    //   484: iload 9
    //   486: ifeq +50 -> 536
    //   489: aconst_null
    //   490: areturn
    //   491: astore_3
    //   492: ldc 102
    //   494: astore_2
    //   495: aload_2
    //   496: astore 10
    //   498: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +35 -> 536
    //   504: ldc 227
    //   506: iconst_2
    //   507: new 273	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 1458
    //   517: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_3
    //   521: invokevirtual 1461	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   524: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 1464	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload_2
    //   534: astore 10
    //   536: aload 13
    //   538: getfield 1467	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   541: aload 10
    //   543: invokestatic 1270	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   546: invokevirtual 1276	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   549: new 1469	tencent/im/msg/im_imagent$ImAgentHead
    //   552: dup
    //   553: invokespecial 1470	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   556: astore_2
    //   557: aload_2
    //   558: getfield 1473	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   561: iconst_3
    //   562: invokevirtual 1410	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   565: aload_2
    //   566: getfield 1477	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   569: aload 13
    //   571: invokevirtual 1478	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   574: aload_2
    //   575: getfield 1481	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   578: aload 12
    //   580: invokevirtual 1392	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   583: aload_2
    //   584: getfield 1482	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   587: astore_3
    //   588: getstatic 87	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_i_of_type_Int	I
    //   591: istore_1
    //   592: iload_1
    //   593: iconst_1
    //   594: iadd
    //   595: putstatic 87	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_i_of_type_Int	I
    //   598: aload_3
    //   599: iload_1
    //   600: invokevirtual 1316	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   603: new 1484	tencent/im/msg/im_msg$MsgSendReq
    //   606: dup
    //   607: invokespecial 1485	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   610: astore_3
    //   611: aload_3
    //   612: getfield 1488	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   615: aload 11
    //   617: invokevirtual 1489	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   620: new 1491	tencent/im/msg/im_imagent$ImAgentPackage
    //   623: dup
    //   624: invokespecial 1492	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   627: astore 10
    //   629: aload 10
    //   631: getfield 1495	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   634: aload_2
    //   635: invokevirtual 1496	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   638: aload 10
    //   640: getfield 1500	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   643: aload_3
    //   644: invokevirtual 1501	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   647: aload 10
    //   649: invokevirtual 1502	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   652: astore_2
    //   653: new 1504	java/io/ByteArrayOutputStream
    //   656: dup
    //   657: aload_2
    //   658: arraylength
    //   659: bipush 8
    //   661: iadd
    //   662: invokespecial 1506	java/io/ByteArrayOutputStream:<init>	(I)V
    //   665: astore_3
    //   666: new 1508	java/io/DataOutputStream
    //   669: dup
    //   670: aload_3
    //   671: invokespecial 1511	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   674: astore 10
    //   676: aload 10
    //   678: aload_2
    //   679: arraylength
    //   680: bipush 8
    //   682: iadd
    //   683: invokevirtual 1514	java/io/DataOutputStream:writeInt	(I)V
    //   686: aload 10
    //   688: bipush 123
    //   690: invokevirtual 1517	java/io/DataOutputStream:write	(I)V
    //   693: aload 10
    //   695: bipush 123
    //   697: invokevirtual 1517	java/io/DataOutputStream:write	(I)V
    //   700: aload 10
    //   702: aload_2
    //   703: invokevirtual 1520	java/io/DataOutputStream:write	([B)V
    //   706: aload 10
    //   708: bipush 125
    //   710: invokevirtual 1517	java/io/DataOutputStream:write	(I)V
    //   713: aload 10
    //   715: bipush 125
    //   717: invokevirtual 1517	java/io/DataOutputStream:write	(I)V
    //   720: aload_3
    //   721: invokevirtual 1521	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   724: astore 11
    //   726: new 273	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   733: ldc_w 1523
    //   736: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: astore 12
    //   741: aload 11
    //   743: ifnonnull +38 -> 781
    //   746: ldc_w 1525
    //   749: astore_2
    //   750: ldc 227
    //   752: iconst_1
    //   753: aload 12
    //   755: aload_2
    //   756: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 364	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_3
    //   766: invokevirtual 1527	java/io/ByteArrayOutputStream:close	()V
    //   769: aload 10
    //   771: invokevirtual 1528	java/io/DataOutputStream:close	()V
    //   774: aload 11
    //   776: areturn
    //   777: astore_2
    //   778: aload 11
    //   780: areturn
    //   781: aload 11
    //   783: arraylength
    //   784: istore_1
    //   785: iload_1
    //   786: invokestatic 696	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   789: astore_2
    //   790: goto -40 -> 750
    //   793: astore_2
    //   794: aload_2
    //   795: invokevirtual 1529	java/lang/Exception:printStackTrace	()V
    //   798: aload_3
    //   799: invokevirtual 1527	java/io/ByteArrayOutputStream:close	()V
    //   802: aload 10
    //   804: invokevirtual 1528	java/io/DataOutputStream:close	()V
    //   807: aconst_null
    //   808: areturn
    //   809: astore_2
    //   810: aload_3
    //   811: invokevirtual 1527	java/io/ByteArrayOutputStream:close	()V
    //   814: aload 10
    //   816: invokevirtual 1528	java/io/DataOutputStream:close	()V
    //   819: aload_2
    //   820: athrow
    //   821: astore_3
    //   822: goto -3 -> 819
    //   825: astore_2
    //   826: goto -19 -> 807
    //   829: astore_3
    //   830: goto -335 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	AddFriendVerifyActivity
    //   0	833	1	paramInt1	int
    //   0	833	2	paramString1	String
    //   0	833	3	paramString2	String
    //   0	833	4	paramLong1	long
    //   0	833	6	paramLong2	long
    //   0	833	8	paramInt2	int
    //   479	6	9	bool	boolean
    //   38	777	10	localObject1	Object
    //   47	735	11	localObject2	Object
    //   230	524	12	localObject3	Object
    //   445	125	13	localSignature	tencent.im.msg.im_imagent.Signature
    // Exception table:
    //   from	to	target	type
    //   467	475	491	java/lang/InterruptedException
    //   765	774	777	java/lang/Exception
    //   676	741	793	java/lang/Exception
    //   750	765	793	java/lang/Exception
    //   781	785	793	java/lang/Exception
    //   676	741	809	finally
    //   750	765	809	finally
    //   781	785	809	finally
    //   794	798	809	finally
    //   810	819	821	java/lang/Exception
    //   798	807	825	java/lang/Exception
    //   475	481	829	java/lang/InterruptedException
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    if (AutoRemarkActivity.a(paramEditable) > 32)
    {
      int n = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = AutoRemarkActivity.a(paramEditable);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (n >= paramEditable.length()) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131693037) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void b(String paramString)
  {
    if (!bgnt.d(this)) {}
    ArrayList localArrayList;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131717328), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while (!getIntent().hasExtra("contacts"));
      localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
      this.jdField_a_of_type_Biau.setOnDismissListener(new adjv(this));
    }
    this.jdField_a_of_type_Biau.setCancelable(true);
    this.jdField_a_of_type_Biau.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Biau.c(2131717771);
    this.jdField_a_of_type_Biau.show();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_b_of_type_JavaUtilArrayList, paramString, 0, this.jdField_b_of_type_Int, new ArrayList());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    if (!bgnt.g(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 1, 2131695369, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new AddFriendVerifyActivity.23(this, paramString), 5, null, false);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_c_of_type_Int != 4) {
      this.jdField_h_of_type_AndroidWidgetTextView.setText("30");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
      return;
      int i1 = 0;
      try
      {
        n = paramString.getBytes("utf-8").length;
        this.jdField_h_of_type_AndroidWidgetTextView.setText(90 - n + "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int n = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
            n = i1;
          }
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doOnActivityResult, requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent == null)
      {
        bool1 = true;
        QLog.d("AddFriendVerifyActivity", 2, bool1);
      }
    }
    else if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    switch (paramInt1)
    {
    case 1003: 
    default: 
    case 1001: 
    case 1002: 
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          paramIntent = this.jdField_a_of_type_AndroidNetUri.getPath();
        } while (TextUtils.isEmpty(paramIntent));
        this.jdField_k_of_type_JavaLangString = paramIntent;
        a(this.jdField_k_of_type_JavaLangString);
        c(this.jdField_k_of_type_JavaLangString);
        return;
      } while (paramIntent == null);
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, paramInt1));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(anni.a(2131698680) + AutoRemarkActivity.a(this.app, paramInt1));
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("ticket");
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        a(this.jdField_a_of_type_AndroidOsBundle.getString("msg", ""), this.jdField_a_of_type_AndroidOsBundle.getByteArray("sig"), paramIntent);
        bool1 = bool2;
        label280:
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "REQUEST_CODE_SECCHECK_H5_PAGE, isSuccuss=" + bool1);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Biau != null)
        {
          this.jdField_a_of_type_Biau.cancel();
          this.jdField_a_of_type_Biau = null;
        }
        e(getString(2131717328));
        c();
      }
    }
    for (;;)
    {
      bool1 = false;
      break label280;
      break;
      if (this.jdField_a_of_type_Biau != null)
      {
        this.jdField_a_of_type_Biau.cancel();
        this.jdField_a_of_type_Biau = null;
      }
      e(getString(2131717328));
      c();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = getIntent();
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("uin");
    this.jdField_c_of_type_Int = ((Intent)localObject2).getIntExtra("k_uin_type", 1);
    if (this.jdField_c_of_type_Int != 4) {
      setTheme(2131755152);
    }
    this.jdField_e_of_type_Int = ((Intent)localObject2).getIntExtra("entrance", -1);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    Object localObject3;
    int i1;
    if (this.jdField_c_of_type_Int == 4)
    {
      setContentViewB(2131558476);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131380472));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380479));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380476));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380477));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131380473));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380475));
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379255));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362126));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368269));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368346));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373173));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373741));
      this.l = ((TextView)findViewById(2131373743));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131373740));
      this.m = ((TextView)findViewById(2131373742));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131372707));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380478));
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
      this.jdField_a_of_type_Biau.c(2131690638);
      this.jdField_g_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authKey");
      this.jdField_h_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authSig");
      if (this.jdField_g_of_type_JavaLangString != null) {}
      paramBundle = getIntent().getExtras().getString("nick_name");
      if (this.jdField_c_of_type_Int != 4) {
        break label2907;
      }
      setTitle(2131689662);
      localObject3 = (TextView)findViewById(2131368947);
      localObject1 = getIntent().getExtras().getString("leftViewText");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = getString(2131690563);
      }
      ((TextView)localObject3).setText(paramBundle);
      this.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
      addObserver(this.jdField_a_of_type_Anxg);
      this.jdField_d_of_type_JavaLangString = getIntent().getExtras().getString("key_param_homework_intro_str");
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        ((anwd)this.app.a(20)).d(this.jdField_a_of_type_JavaLangString);
      }
      n = getIntent().getExtras().getShort("group_option", (short)2);
      paramBundle = getIntent().getExtras().getString("troop_question");
      getIntent().getExtras().getString("troop_answer");
      i1 = getIntent().getIntExtra("stat_option", 0);
      bgjt.a(this.jdField_a_of_type_JavaLangString, 1, 1, i1);
      switch (n)
      {
      default: 
        label676:
        getWindow().setSoftInputMode(5);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int == 3)
      {
        paramBundle = ((Intent)localObject2).getStringExtra("is_from_game");
        localObject1 = ((Intent)localObject2).getStringExtra("extra");
      }
      try
      {
        localObject2 = aqlj.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(paramBundle)) || (((aqrq)localObject2).b())) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          bfup.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "AddFriend enableCheckPermission = " + ((aqrq)localObject2).b());
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i2;
          int i3;
          int i4;
          if (("true".equals(paramBundle)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            bfup.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          }
          QLog.d("AddFriendVerifyActivity", 1, "AddFriend loadConfig exception = " + localException);
          continue;
          n = 0;
          continue;
        }
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      enableRightHighlight(true);
      if (bjft.b(this.app, this.jdField_f_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("webImVisitId");
      return true;
      setContentViewB(2131558475);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
      n = getIntent().getIntExtra("sub_source_id", 0);
      this.jdField_b_of_type_Int = ((Intent)localObject2).getIntExtra("source_id", 3999);
      if (((Intent)localObject2).hasExtra("param_wzry_data")) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)((Intent)localObject2).getSerializableExtra("param_wzry_data"));
      }
      if (AutoRemarkActivity.a(this.jdField_b_of_type_Int))
      {
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
        label950:
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "AddFriendVerifyActivity remark = " + this.jdField_e_of_type_JavaLangString + ", source id=" + this.jdField_b_of_type_Int + ", mTargetGroupId = " + this.jdField_a_of_type_Int);
        }
        if ((paramBundle == null) && (bgnt.d(this)) && (AutoRemarkActivity.a(this.jdField_b_of_type_Int, this.jdField_f_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, this.jdField_b_of_type_Int, ((Intent)localObject2).getIntExtra("sub_source_id", 0));
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363636));
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new adjq(this));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376410));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376411));
        this.jdField_a_of_type_Adks = new adks(100, this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Adks);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362286));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramBundle = getIntent().getStringExtra("key_param_age_area");
        if (!TextUtils.isEmpty(paramBundle))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
          }
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371595));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362688));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372779));
        this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371720));
        this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378846));
        this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367628));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131376702));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131376660));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
        this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366099));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379705));
        this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_e_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_e_of_type_JavaLangString.length());
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, this.jdField_a_of_type_Int));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(anni.a(2131698674) + AutoRemarkActivity.a(this.app, this.jdField_a_of_type_Int));
        if (!bgjw.b(this.jdField_f_of_type_JavaLangString)) {
          break label1802;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(getString(2131689574));
        label1530:
        if ((!bqkd.a(this.jdField_b_of_type_Int)) && (this.jdField_b_of_type_Int != 3016)) {
          break label1827;
        }
        n = 1;
        label1552:
        if (n == 0)
        {
          this.jdField_a_of_type_AndroidViewView = findViewById(2131375567);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131375568));
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        }
        if (!AppSetting.jdField_c_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691941));
        if (bgjw.b(this.jdField_f_of_type_JavaLangString)) {
          break label1832;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717303));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131693037) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (n != 0) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.setFocusable(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131716554));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
        {
          this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
          break label950;
        }
        if ((this.jdField_b_of_type_Int != 3004) || ((n != 5) && (n != 6) && (n != 7) && (n != 8))) {
          break label950;
        }
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
        break label950;
        label1802:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(getString(2131689573));
        break label1530;
        label1827:
        n = 0;
        break label1552;
        label1832:
        this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717302));
      }
      break label676;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams()).topMargin = 0;
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(aoch.a(this.app, this.app.getCurrentAccountUin(), (byte)1));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetEditText.setHeight(afur.a(160.0F, getResources()));
      this.jdField_c_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_c_of_type_AndroidWidgetEditText.setGravity(48);
      this.jdField_c_of_type_AndroidWidgetEditText.setHint("");
      n = afur.a(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(n, n, n, n);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        paramBundle = getString(2131696821, new Object[] { this.app.getCurrentNickname() });
        label2057:
        d(paramBundle);
        if (bhcb.a())
        {
          bcst.b(null, "dc00898", "", "", "qq_vip", "0X800A4F8", 0, 0, "", "", "", "");
          paramBundle = new GridLayoutManager(this, 2);
          this.jdField_a_of_type_Ahdx = new ahdx(this);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ahdx);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
          paramBundle = (anyj)this.app.a(27);
          if (paramBundle == null) {
            break label2239;
          }
          localObject1 = new UniGetReq();
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(Integer.valueOf(40));
          ((UniGetReq)localObject1).appidList = ((ArrayList)localObject3);
          paramBundle.a((UniGetReq)localObject1, new adkt(this, 0), false);
        }
      }
      for (;;)
      {
        setRightHighlightButton(2131690671, new adkb(this));
        break;
        paramBundle = this.jdField_d_of_type_JavaLangString;
        break label2057;
        label2239:
        QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new bdnt(getString(2131715879) + ":" + paramBundle, 13);
      this.l.setText(paramBundle);
      this.l.setTag(this.jdField_a_of_type_JavaLangString);
      this.l.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131691772));
      }
      setRightHighlightButton(2131690671, new adkl(this));
      bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      if (paramBundle.jdField_b_of_type_Int <= 0) {
        break label676;
      }
      i1 = 0;
      if (i1 >= paramBundle.a.length) {
        break label676;
      }
      if (!(paramBundle.a[i1] instanceof bdob)) {}
      for (;;)
      {
        i1 += 1;
        break;
        localObject1 = ((bdob)paramBundle.a[i1]).jdField_a_of_type_JavaLangString;
        n = -1;
        if (bgny.d.matcher((CharSequence)localObject1).find()) {
          n = 0;
        }
        if (bdoh.b.matcher((CharSequence)localObject1).find()) {
          n = 1;
        }
        if (!bdoh.e.matcher((CharSequence)localObject1).find()) {
          break label5158;
        }
        n = 2;
        bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_a_of_type_JavaLangString, "" + n, "", "");
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new bdnt(getString(2131715879) + ":" + paramBundle, 13);
      this.l.setText(paramBundle);
      this.l.setTag(this.jdField_a_of_type_JavaLangString);
      this.l.setMovementMethod(LinkMovementMethod.getInstance());
      this.l.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131691772));
      }
      setRightHighlightButton(2131690671, new adkn(this));
      bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      if (paramBundle.jdField_b_of_type_Int <= 0) {
        break label676;
      }
      i1 = 0;
      label2762:
      if (i1 < paramBundle.a.length) {
        if ((paramBundle.a[i1] instanceof bdob)) {
          break label2790;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label2762;
        break;
        label2790:
        localObject1 = ((bdob)paramBundle.a[i1]).jdField_a_of_type_JavaLangString;
        n = -1;
        if (bgny.d.matcher((CharSequence)localObject1).find()) {
          n = 0;
        }
        if (bdoh.b.matcher((CharSequence)localObject1).find()) {
          n = 1;
        }
        if (!bdoh.e.matcher((CharSequence)localObject1).find()) {
          break label5155;
        }
        n = 2;
        bcst.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_a_of_type_JavaLangString, "" + n, "", "");
      }
      label2907:
      setTitle(2131689569);
      setLeftButton(anni.a(2131698645), null);
      localObject1 = (anip)this.app.a(2);
      i2 = getIntent().getExtras().getInt("source_id", 3999);
      i3 = getIntent().getIntExtra("sub_source_id", 0);
      if (bqkd.a(getIntent().getIntExtra("sort_id", 0)))
      {
        localObject3 = this.jdField_f_of_type_JavaLangString;
        ((anip)localObject1).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject3, 0L, 10004, null, (byte)0);
        label3022:
        addObserver(this.jdField_a_of_type_Aniz);
        addObserver(this.jdField_a_of_type_Anmu);
        addObserver(this.jdField_a_of_type_Bjha);
        if (this.jdField_c_of_type_Int != 2) {
          break label3441;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoch.a(this.app, 11, this.jdField_f_of_type_JavaLangString));
        localObject3 = this.jdField_j_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(paramBundle)) {
          break label3435;
        }
        localObject1 = this.jdField_f_of_type_JavaLangString;
        label3093:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          localObject3 = this.jdField_j_of_type_AndroidWidgetTextView;
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = this.jdField_f_of_type_JavaLangString;
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
        }
        label3135:
        i4 = ((Intent)localObject2).getIntExtra("friend_setting", 0);
        localObject1 = getIntent().getExtras().getStringArrayList("user_question");
      }
      switch (i4)
      {
      default: 
        break;
      case 0: 
      case 2: 
        if ((i2 == 3078) || (i2 == 3079))
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689558));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689575));
          }
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (getIntent() != null) {}
          for (n = getIntent().getIntExtra("contact_from_type", 1);; n = 1)
          {
            setRightHighlightButton(2131690671, new adko(this, n));
            paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
            paramBundle.topMargin = afur.a(20.0F, getResources());
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
            break;
            ((anip)localObject1).a(this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
            break label3022;
            localObject1 = paramBundle;
            break label3093;
            if (this.jdField_c_of_type_Int == 3)
            {
              localObject1 = ((Intent)localObject2).getStringExtra("extra");
              localObject1 = URLDrawable.getDrawable(aoch.a(this.jdField_f_of_type_JavaLangString, (String)localObject1), URLDrawable.URLDrawableOptions.obtain());
              if (bcnj.a()) {
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              }
              for (;;)
              {
                this.jdField_j_of_type_AndroidWidgetTextView.setText(paramBundle);
                if (AppSetting.jdField_c_of_type_Boolean) {
                  this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
                }
                ((FriendListHandler)this.app.a(1)).a(this.jdField_f_of_type_JavaLangString, getIntent().getStringExtra("extra"));
                break;
                a((URLDrawable)localObject1);
              }
            }
            if ((i2 == 3007) || (i2 == 2007) || (i2 == 4007) || (i2 == 3019) || (i2 == 2019)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoch.a(this.app, 200, this.jdField_f_of_type_JavaLangString, true));
            }
            for (;;)
            {
              if (!a()) {
                break label3673;
              }
              if (paramBundle == null) {
                break;
              }
              this.jdField_j_of_type_AndroidWidgetTextView.setText(paramBundle);
              if (!AppSetting.jdField_c_of_type_Boolean) {
                break;
              }
              this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
              break;
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoch.a(this.app, 1, this.jdField_f_of_type_JavaLangString));
            }
            ThreadManager.getSubThreadHandler().post(new AddFriendVerifyActivity.5(this, paramBundle));
            break label3135;
          }
        }
        setRightHighlightButton(2131690671, new adkp(this, i2, i3));
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
        paramBundle.topMargin = afur.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bcst.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i2), String.valueOf(i3), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i2 + " subSourceId = " + i3);
        }
        a(i2, i4);
        break;
      case 1: 
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689575));
        }
        setRightHighlightButton(2131690671, new adkq(this, i2, i3, i4));
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
        paramBundle.topMargin = afur.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bcst.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i2), String.valueOf(i3), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i2 + " subSourceId = " + i3);
        }
        break;
      case 3: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramBundle = (String)((ArrayList)localObject1).get(0);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378460);
        localObject3 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368670);
        this.jdField_b_of_type_Adks = new adks(50, (EditText)localObject3);
        ((EditText)localObject3).addTextChangedListener(this.jdField_b_of_type_Adks);
        ((TextView)localObject1).setText(getString(2131715879) + ":" + paramBundle);
        ((EditText)localObject3).setSingleLine(true);
        if (jdField_a_of_type_Boolean)
        {
          ((TextView)localObject1).setContentDescription(getString(2131715879) + ":" + paramBundle);
          ((EditText)localObject3).setContentDescription(getString(2131689572));
        }
        setRightHighlightButton(2131690671, new adkr(this, (EditText)localObject3, i4, i2, i3));
        getWindow().setSoftInputMode(5);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
        paramBundle.topMargin = afur.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bcst.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i2), String.valueOf(i3), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i2 + " subSourceId = " + i3);
        }
        break;
      case 4: 
        label3435:
        label3441:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        label3673:
        localObject3 = new StringBuffer();
        if ((localObject1 == null) || (((ArrayList)localObject1).size() != 1)) {
          break label5150;
        }
        n = 1;
        i1 = 0;
        if (i1 < ((ArrayList)localObject1).size())
        {
          switch (i1)
          {
          default: 
            paramBundle = getResources().getString(2131715879);
          }
          for (;;)
          {
            Object localObject6 = getLayoutInflater().inflate(2131560986, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            Object localObject4 = getLayoutInflater().inflate(2131560985, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            if (i1 > 0)
            {
              localObject5 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
              if (localObject5 != null)
              {
                ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)bgme.a(getApplication(), 19.0F));
                ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              }
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject6);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
            Object localObject5 = (String)((ArrayList)localObject1).get(i1);
            localObject6 = (TextView)((View)localObject6).findViewById(2131378460);
            ((TextView)localObject6).setText(paramBundle + (String)localObject5);
            localObject4 = (EditText)((View)localObject4).findViewById(2131368670);
            ((EditText)localObject4).addTextChangedListener(new adks(50, (EditText)localObject4));
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            if (jdField_a_of_type_Boolean)
            {
              ((TextView)localObject6).setContentDescription(paramBundle + (String)localObject5);
              ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).setContentDescription(getString(2131689572));
            }
            int i5 = i1 + 1;
            ((StringBuffer)localObject3).append(getString(2131715879) + i5 + ":" + (String)localObject5);
            ((StringBuffer)localObject3).append("\n");
            ((StringBuffer)localObject3).append(getString(2131689993) + ":${answer}");
            if (i5 != ((ArrayList)localObject1).size()) {
              ((StringBuffer)localObject3).append("\n");
            }
            i1 += 1;
            break;
            if (n != 0)
            {
              paramBundle = getResources().getString(2131715880);
            }
            else
            {
              paramBundle = getResources().getString(2131715881);
              continue;
              paramBundle = getResources().getString(2131715882);
              continue;
              paramBundle = getResources().getString(2131715883);
              continue;
              paramBundle = getResources().getString(2131715884);
              continue;
              paramBundle = getResources().getString(2131715885);
            }
          }
        }
        setRightHighlightButton(2131690671, new adjr(this, (StringBuffer)localObject3, i2, i3, i4));
        findViewById(2131376706).setOnTouchListener(new adjs(this));
        getWindow().setSoftInputMode(4);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
        paramBundle.topMargin = afur.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bcst.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i2), String.valueOf(i3), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i2 + " subSourceId = " + i3);
        }
        break;
      }
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      if (Build.VERSION.SDK_INT >= 16) {
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      for (;;)
      {
        super.doOnDestroy();
        return;
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.jdField_k_of_type_JavaLangString = ((String)paramIntent.get(0));
      c(this.jdField_k_of_type_JavaLangString);
    }
  }
  
  public void doOnResume()
  {
    int n = 1;
    int i1 = 0;
    super.doOnResume();
    if (this.jdField_c_of_type_Int != 4) {}
    String str1;
    Object localObject2;
    switch (getIntent().getIntExtra("friend_setting", 0))
    {
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.jdField_b_of_type_Int != 3078) && (this.jdField_b_of_type_Int != 3079));
      str1 = a(false);
      localObject2 = getString(2131691770);
      if (TextUtils.isEmpty(str1)) {
        if (!b()) {
          str1 = (String)localObject2 + bglf.a(this.app, this.app.getAccount());
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
      if (n != 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject2).length(), str1.length());
        for (;;)
        {
          label168:
          getWindow().setSoftInputMode(5);
          return;
          if (!TextUtils.isEmpty(str1)) {
            this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str1.length());
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label168;
      }
      String str4 = getString(2131691770);
      String str2;
      if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
      {
        localObject2 = str4 + getString(2131697547) + " " + bglf.a(this.app, this.app.getAccount());
        this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject2);
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689575));
        }
        if (this.jdField_c_of_type_Int != 3) {
          break label492;
        }
        str2 = getIntent().getStringExtra("msg");
        n = 1;
      }
      for (;;)
      {
        label358:
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
          str3 = a(false);
        }
        if (TextUtils.isEmpty(str3)) {}
        for (;;)
        {
          if ((n != 0) && (str4.equals(localObject2)) && (!b())) {
            str2 = (String)localObject2 + bglf.a(this.app, this.app.getAccount());
          }
          for (n = 1;; n = i1)
          {
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetEditText.setText(str2);
              if (n != 0) {}
              try
              {
                this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str4.length(), str2.length());
                for (;;)
                {
                  label467:
                  getWindow().setSoftInputMode(5);
                  return;
                  this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
                  localObject2 = str4;
                  break;
                  label492:
                  if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) {
                    break label557;
                  }
                  str2 = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg;
                  if (TextUtils.isEmpty(str2)) {
                    break label552;
                  }
                  n = 0;
                  break label358;
                  this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str2.length());
                }
              }
              catch (Throwable localThrowable2)
              {
                break label467;
              }
            }
            localObject1 = localObject2;
          }
          localObject2 = str3;
        }
        label552:
        n = 1;
        continue;
        label557:
        localObject1 = null;
        n = 1;
      }
      n = 0;
      Object localObject1 = localObject2;
      continue;
      n = 0;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Anmu != null) {
      addObserver(this.jdField_a_of_type_Anmu);
    }
    if (this.jdField_a_of_type_Anxg != null) {
      addObserver(this.jdField_a_of_type_Anxg);
    }
    if (this.jdField_a_of_type_Aniz != null) {
      addObserver(this.jdField_a_of_type_Aniz);
    }
    if (this.jdField_a_of_type_Bjha != null) {
      addObserver(this.jdField_a_of_type_Bjha);
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_Anmu != null) {
      removeObserver(this.jdField_a_of_type_Anmu);
    }
    if (this.jdField_a_of_type_Anxg != null) {
      removeObserver(this.jdField_a_of_type_Anxg);
    }
    if (this.jdField_a_of_type_Aniz != null) {
      removeObserver(this.jdField_a_of_type_Aniz);
    }
    if (this.jdField_a_of_type_Bjha != null) {
      removeObserver(this.jdField_a_of_type_Bjha);
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
    localIntent.setPackage(getPackageName());
    localIntent.putExtra("ret_action", this.jdField_f_of_type_Int);
    sendBroadcast(localIntent);
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
    getWindow().setSoftInputMode(2);
    super.finish();
    if (this.jdField_c_of_type_Int != 4) {
      overridePendingTransition(0, 2130772001);
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = true;
    c();
    Object localObject;
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      return super.onBackEvent();
    }
    if (this.jdField_c_of_type_Int != 4)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (4 != this.jdField_c_of_type_Int) {
        break label177;
      }
    }
    for (;;)
    {
      a((String)localObject, bool);
      if ((getString(2131691770).equals(localObject)) && (!b())) {
        b();
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        bcst.b(this.app, "dc00899", "Qidian", this.jdField_f_of_type_JavaLangString, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
      }
      return super.onBackEvent();
      label177:
      bool = false;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject;
    if (!bgnt.d(this))
    {
      QQToast.a(this, 1, 2131693948, 0).b(getTitleBarHeight());
      if (this.jdField_a_of_type_ComTencentWidgetSwitch != null)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!paramBoolean) {
          bool = true;
        }
        ((Switch)localObject).setChecked(bool);
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this);
      }
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131716554));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.jdField_f_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        blfq localblfq = new blfq(0);
        localblfq.jdField_d_of_type_JavaLangString = "QQ空间";
        localblfq.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
        localblfq.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        localblfq.jdField_e_of_type_JavaLangString = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localblfq.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        blfh.b(this.app.getApp(), localblfq);
        bcst.b(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
      }
      localObject = paramCompoundButton.getTag();
      if (((localObject instanceof Integer)) && (((TroopManager)this.app.getManager(52) == null) || (this.jdField_a_of_type_JavaLangString != null))) {
        switch (((Integer)localObject).intValue())
        {
        default: 
          break;
        case 1: 
          a(paramBoolean);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_a_of_type_Int);
      localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult(localIntent, 1002);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
      }
      bcst.b(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131368670) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */