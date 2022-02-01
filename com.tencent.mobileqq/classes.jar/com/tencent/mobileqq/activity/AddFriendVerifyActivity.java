package com.tencent.mobileqq.activity;

import Override;
import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniGetRsp;
import QC.UniSetReq;
import QC.UniSetRsp;
import adfs;
import adft;
import adfu;
import adfv;
import adfw;
import adfx;
import adfy;
import adfz;
import adga;
import adgb;
import adgc;
import adgd;
import adge;
import adgf;
import adgg;
import adgh;
import adgi;
import adgj;
import adgk;
import adgl;
import adgm;
import adgn;
import adgp;
import adgq;
import adgr;
import adgs;
import adgt;
import adgu;
import adgv;
import ahcm;
import ahcn;
import aixk;
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
import anri;
import anvi;
import anvk;
import anvx;
import anyb;
import aoep;
import aofu;
import aogw;
import aqxd;
import ardt;
import assw;
import awzc;
import bdfk;
import bdla;
import bghi;
import bgzv;
import bhbu;
import bhbx;
import bhdj;
import bhdz;
import bheg;
import bhfp;
import bhny;
import bhrt;
import bisl;
import bjxa;
import bjyh;
import bkzi;
import bkzz;
import blvy;
import blwh;
import bpup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  implements ahcn, TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, bghi
{
  public static final boolean a;
  private static int jdField_k_of_type_Int = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  public int a;
  private long jdField_a_of_type_Long;
  adgu jdField_a_of_type_Adgu;
  private ahcm jdField_a_of_type_Ahcm;
  public Dialog a;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new adfy(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adgf(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new adgm(this);
  public InputMethodManager a;
  public EditText a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private anvi jdField_a_of_type_Anvi = new adga(this);
  private aofu jdField_a_of_type_Aofu = new adgc(this);
  private awzc<bhny> jdField_a_of_type_Awzc = new adgk(this);
  public bisl a;
  private bjyh jdField_a_of_type_Bjyh = new adgb(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adfz(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  public KplRoleInfo.WZRYUIinfo a;
  public QQCustomDialog a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  protected FormSwitchItem a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public String a;
  private ArrayList<EditText> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public int b;
  private long jdField_b_of_type_Long;
  adgu jdField_b_of_type_Adgu;
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
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  public TextView e;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 2000;
  public TextView f;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int = -1;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int = 1000;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  
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
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new adge(this);
  }
  
  private String a()
  {
    Object localObject3 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.app.getCurrentUin());
    Object localObject2 = "";
    String str = "";
    Object localObject1 = "";
    int i2 = 0;
    int i1;
    Object localObject4;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      i1 = ((Card)localObject3).shGender;
      if (((Card)localObject3).shGender == 0)
      {
        localObject1 = getString(2131693752);
        i2 = ((Card)localObject3).age;
        str = ((Card)localObject3).strProvince;
        localObject2 = ((Card)localObject3).strCity;
        i2 = ((Card)localObject3).constellation;
        localObject4 = bgzv.c(((Card)localObject3).constellation);
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
      if ((bool) && (i2 == 0) && (i1 == -1)) {
        localObject1 = anvx.a(2131699342);
      }
      for (;;)
      {
        return (String)localObject1 + "~";
        localObject1 = localObject2;
        if (((Card)localObject3).shGender != 1) {
          break;
        }
        localObject1 = getString(2131692198);
        break;
        if ((bool) && (i2 == 0)) {
          localObject1 = anvx.a(2131699360);
        } else if ((bool) && (i1 == -1)) {
          localObject1 = anvx.a(2131699357);
        } else if ((i2 == 0) && (i1 == -1)) {
          localObject1 = anvx.a(2131699348) + str + (String)localObject4;
        } else if (i2 == 0) {
          localObject1 = anvx.a(2131699369) + str + (String)localObject4;
        } else if (i1 == -1) {
          localObject1 = anvx.a(2131699350) + str + (String)localObject4 + anvx.a(2131699356) + (String)localObject2 + anvx.a(2131699345);
        } else if (bool) {
          localObject1 = (String)localObject2 + (String)localObject3 + anvx.a(2131699346);
        } else {
          localObject1 = anvx.a(2131699362) + str + (String)localObject4 + anvx.a(2131699341) + (String)localObject2 + (String)localObject3 + anvx.a(2131699365);
        }
      }
      localObject3 = "";
      localObject2 = "";
      i1 = -1;
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
    if (this.jdField_d_of_type_Int == 3090) {}
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
    Bitmap localBitmap = bheg.a(paramURLDrawable);
    if (paramURLDrawable.getStatus() == 1)
    {
      paramURLDrawable = this.app;
      paramURLDrawable = QQAppInterface.getCircleFaceBitmap(localBitmap, 50, 50);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramURLDrawable));
      return;
    }
    paramURLDrawable.setURLDrawableListener(new adfv(this));
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 427	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 429	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 432	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 435	bheg:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 432	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 441	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload_2
    //   36: astore_3
    //   37: aload_0
    //   38: invokestatic 447	com/tencent/mobileqq/troop/utils/TroopUtils:readPictureDegree	(Ljava/lang/String;)I
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
    //   56: invokestatic 450	bheg:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
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
    //   74: invokestatic 453	bheg:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 458	android/graphics/Bitmap:recycle	()V
    //   87: return
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 461	java/lang/OutOfMemoryError:printStackTrace	()V
    //   93: return
    //   94: astore_0
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   102: aload 4
    //   104: ifnull -17 -> 87
    //   107: aload 4
    //   109: invokevirtual 458	android/graphics/Bitmap:recycle	()V
    //   112: return
    //   113: astore_0
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 458	android/graphics/Bitmap:recycle	()V
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   41	14	1	i1	int
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
    this.jdField_a_of_type_Bisl.c(2131718527);
    this.jdField_a_of_type_Bisl.show();
    aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localaoep.a(paramString1, paramString2, paramInt1, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, a(this.jdField_i_of_type_Int, this.jdField_i_of_type_JavaLangString, paramString2, l1, l2, paramInt2), this.jdField_j_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        paramString2 = "2";
        bdla.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
        bhbu.a(this.jdField_a_of_type_JavaLangString, 1, 0, paramInt1);
        if (!this.jdField_c_of_type_Boolean) {
          break label335;
        }
        bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean == true) && (!this.jdField_c_of_type_Boolean)) {
        bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean == true)) {
        bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      this.jdField_h_of_type_Int = 1001;
      ((anyb)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).e(this.jdField_f_of_type_JavaLangString);
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
      label335:
      bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.getSystemNetwork(this) == 0)
    {
      QQToast.a(this, 2131695928, 0).b(getTitleBarHeight());
      d();
    }
    while (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramBoolean, true);
  }
  
  private boolean a()
  {
    int i1 = getIntent().getExtras().getInt("source_id", 3999);
    return (i1 == 3003) || (i1 == 3006) || (i1 == 3007) || (i1 == 3009) || (i1 == 3013);
  }
  
  private void b()
  {
    getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
  }
  
  private void b(int paramInt)
  {
    String str3 = anvx.a(2131699375);
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      QLog.e("AddFriendVerifyActivity", 1, "showPayDialog, UNKOWN errorCode: " + paramInt);
      return;
    case 4002: 
      str2 = anvx.a(2131699337);
      paramInt = 1;
      str1 = "LTMCLUB";
    case 5002: 
    case 12002: 
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A4FA", paramInt, 0, "", "", "", "");
        String str4 = String.format(anvx.a(2131699359), new Object[] { str2, str2 });
        str2 = String.format(anvx.a(2131699363), new Object[] { str2 });
        bhdj.a(this, 230, str3, str4, anvx.a(2131699374), str2, new adgh(this, str1, paramInt), new adgi(this)).show();
        return;
        str2 = anvx.a(2131699344);
        paramInt = 2;
        str1 = "CJCLUBT";
        continue;
        str2 = anvx.a(2131699343);
        paramInt = 3;
        str1 = "SVHHZLH";
      }
    }
    QQToast.a(this, 1, anvx.a(2131699361), 1).a();
  }
  
  private boolean b()
  {
    return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
  }
  
  private void c()
  {
    if (aixk.a(this.app) != null)
    {
      int i1 = getIntent().getIntExtra("friend_setting", 0);
      int i2 = getIntent().getIntExtra("source_id", 3999);
      String str = getIntent().getExtras().getString("extra");
      int i3 = getIntent().getIntExtra("sub_source_id", 0);
      aixk.a(this.app).a(this.jdField_f_of_type_JavaLangString, i1, i2, i3, str);
    }
  }
  
  private boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = l1;
    if ((l2 > 1000L) && (this.jdField_h_of_type_Int != 1001) && (!this.jdField_d_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AddFriendVerifyActivity", 1, String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", new Object[] { Long.valueOf(l2), Integer.valueOf(this.jdField_h_of_type_Int), Boolean.valueOf(this.jdField_d_of_type_Boolean), Boolean.valueOf(bool) }));
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
    this.jdField_c_of_type_Boolean = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).d(this.jdField_a_of_type_JavaLangString);
    localSwitch.setChecked(this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean == true) {}
    for (String str = getString(2131695922);; str = getString(2131695926))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void e()
  {
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    localbkzi.a(2131718514, 5);
    localbkzi.a(2131718504, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new adgg(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, paramString, 0, 2131694164, null, new adgl(this, paramString));
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
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167106));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundResource(2130850375);
      int i1 = AIOUtils.dp2px(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(i1, i1, i1, i1);
      this.jdField_c_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131167026));
    }
    label286:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "select: " + paramInt + " server: " + this.jdField_f_of_type_Int);
      }
      Object localObject;
      if (this.jdField_f_of_type_Int != paramInt)
      {
        localObject = (aogw)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
        if (localObject != null)
        {
          UniSetReq localUniSetReq = new UniSetReq();
          localUniSetReq.stUniBusinessItem = new UniBusinessItem(40, paramInt, "");
          ((aogw)localObject).a(localUniSetReq, new adgv(this, paramInt), false);
        }
      }
      else
      {
        return;
        localObject = (bhny)BaseApplicationImpl.sImageCache.get(bhrt.a(paramInt));
        if (localObject == null) {
          new PobingDecoder(paramInt, bhrt.a, this.jdField_a_of_type_Awzc);
        }
        for (;;)
        {
          if (!bdfk.b()) {
            break label286;
          }
          bhdj.a(this, 0, anvx.a(2131699370), anvx.a(2131699364), null, anvx.a(2131699339), new adgj(this), null).show();
          break;
          this.jdField_a_of_type_Awzc.postQuery(localObject);
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
            this.jdField_f_of_type_Int = localUniBusinessItem.itemid;
            this.jdField_a_of_type_Ahcm.a(localUniBusinessItem.itemid);
            QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + this.jdField_f_of_type_Int);
            return;
          }
        }
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP nothing: " + this.jdField_f_of_type_Int);
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
        this.jdField_f_of_type_Int = paramInt2;
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP success: " + this.jdField_f_of_type_Int);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramObject.ret + " msg:" + paramObject.errmsg);
      b(paramObject.ret);
      this.jdField_a_of_type_Ahcm.a(this.jdField_f_of_type_Int);
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
    if (!NetworkUtil.isNetSupport(this)) {}
    int i3;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694305), 0).b(getTitleBarHeight());
      for (;;)
      {
        return;
        if (!isFinishing())
        {
          if (this.jdField_a_of_type_Bisl == null)
          {
            this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
            this.jdField_a_of_type_Bisl.setOnDismissListener(new adfw(this));
          }
          this.jdField_a_of_type_Bisl.c(2131718527);
          this.jdField_a_of_type_Bisl.setCancelable(true);
          this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(false);
          try
          {
            this.jdField_a_of_type_Bisl.show();
            Intent localIntent = getIntent();
            i3 = localIntent.getIntExtra("sub_source_id", 0);
            int i2 = localIntent.getIntExtra("friend_setting", 0);
            int i1 = i2;
            if (i2 == 3) {
              i1 = 100;
            }
            boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
            String str = localIntent.getStringExtra("src_name");
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addFriendWithMyCard(this.jdField_f_of_type_JavaLangString, localIntent.getStringExtra("extra"), i1, (byte)this.jdField_c_of_type_Int, paramString1, this.jdField_d_of_type_Int, i3, true, paramArrayOfByte, bool, this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"));
            if (!AutoRemarkActivity.a(i1, this.jdField_d_of_type_Int, bool)) {
              ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_f_of_type_JavaLangString, true);
            }
            if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_e_of_type_JavaLangString)) {
              bdla.b(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
            }
            if (localIntent.getIntExtra("sort_id", 0) == 3090) {
              bdla.b(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
            }
            if (this.jdField_d_of_type_Int == 3094) {
              if (i3 == 1)
              {
                bdla.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092E3", "0X80092E3", 0, 0, "", assw.a(), assw.a(this.app), assw.c());
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
            if (i3 == 2)
            {
              bdla.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092CC", "0X80092CC", 0, 0, "", "", assw.a(this.app), "");
              return;
            }
            if (i3 == 8)
            {
              bdla.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_g_of_type_Int, 0, "", "", "", "");
              return;
            }
          }
        }
      }
    } while (i3 != 9);
    bdla.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_g_of_type_Int, 0, "", "", "", "");
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
              i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (!QLog.isColorLevel()) {
                break label761;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, basics name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
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
              i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (("add_friend".equals(localObject1)) && (i1 != 1)) {
                f(getActivity().getResources().getString(2131719602));
              }
              if (!QLog.isColorLevel()) {
                break label768;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
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
        int i1 = ((Integer)((JSONObject)localObject1).get("state")).intValue();
        String str = (String)((JSONObject)localObject1).get("api");
        localObject1 = (String)((JSONObject)localObject1).get("msg");
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i1 + " api = " + str + " msg= " + (String)localObject1 + "\n");
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
    //   1: invokestatic 276	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 276	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1286	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1287	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 276	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +153 -> 181
    //   31: new 1289	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1290	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 10
    //   40: new 1292	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1293	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 11
    //   49: aload 11
    //   51: getfield 1297	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1303	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 1309	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 10
    //   63: getfield 1313	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 11
    //   68: invokevirtual 1316	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1320	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 10
    //   77: invokevirtual 1325	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1289	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1290	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: getfield 1329	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_3
    //   95: iload 8
    //   97: invokestatic 1332	aoep:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   100: invokevirtual 1335	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   103: aload_2
    //   104: getfield 1320	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   107: aload 10
    //   109: invokevirtual 1325	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   112: new 1289	tencent/im/msg/im_msg_body$Elem
    //   115: dup
    //   116: invokespecial 1290	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   119: astore_3
    //   120: new 1337	tencent/im/msg/im_msg_body$GeneralFlags
    //   123: dup
    //   124: invokespecial 1338	tencent/im/msg/im_msg_body$GeneralFlags:<init>	()V
    //   127: astore 10
    //   129: new 1340	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   132: dup
    //   133: invokespecial 1341	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: getfield 1345	tencent/im/msg/hummer/resv/generalflags$ResvAttr:uint32_troop_pobing_template	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iload 8
    //   145: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   148: aload 10
    //   150: getfield 1352	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: aload 11
    //   155: invokevirtual 1356	tencent/im/msg/hummer/resv/generalflags$ResvAttr:toByteArray	()[B
    //   158: invokestatic 1360	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 1309	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   164: aload_3
    //   165: getfield 1364	tencent/im/msg/im_msg_body$Elem:general_flags	Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   168: aload 10
    //   170: invokevirtual 1365	tencent/im/msg/im_msg_body$GeneralFlags:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   173: aload_2
    //   174: getfield 1320	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: aload_3
    //   178: invokevirtual 1325	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: new 1367	tencent/im/msg/im_msg_body$MsgBody
    //   184: dup
    //   185: invokespecial 1368	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: getfield 1372	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   193: aload_2
    //   194: invokevirtual 1373	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   197: new 1375	tencent/im/msg/im_msg$Msg
    //   200: dup
    //   201: invokespecial 1376	tencent/im/msg/im_msg$Msg:<init>	()V
    //   204: astore 11
    //   206: aload 11
    //   208: getfield 1380	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   211: aload_3
    //   212: invokevirtual 1381	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   215: new 1383	tencent/im/msg/im_msg$Group
    //   218: dup
    //   219: invokespecial 1384	tencent/im/msg/im_msg$Group:<init>	()V
    //   222: astore_3
    //   223: new 1386	tencent/im/msg/im_common$User
    //   226: dup
    //   227: invokespecial 1387	tencent/im/msg/im_common$User:<init>	()V
    //   230: astore 12
    //   232: aload 12
    //   234: getfield 1390	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: lload 4
    //   239: invokevirtual 1395	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   242: aload 12
    //   244: getfield 1398	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: sipush 1001
    //   250: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   253: aload 12
    //   255: getfield 1401	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: iconst_1
    //   259: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload 12
    //   264: getfield 1405	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   267: invokestatic 1409	dw:a	()J
    //   270: l2i
    //   271: invokevirtual 1412	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   274: aload 12
    //   276: getfield 1415	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: bipush 109
    //   281: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   284: aload 12
    //   286: getfield 1418	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokestatic 1420	com/tencent/common/config/AppSetting:a	()I
    //   292: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   295: aload_3
    //   296: getfield 1424	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   299: aload 12
    //   301: invokevirtual 1425	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   304: aload_3
    //   305: getfield 1424	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   308: getfield 1390	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   311: lload 4
    //   313: invokevirtual 1395	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   316: new 1427	tencent/im/msg/im_common$GroupInfo
    //   319: dup
    //   320: invokespecial 1428	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   323: astore_2
    //   324: aload_3
    //   325: getfield 1432	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   328: aload_2
    //   329: invokevirtual 1433	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 1432	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   336: getfield 1436	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 6
    //   341: invokevirtual 1395	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: aload_3
    //   345: getfield 1432	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   348: getfield 1440	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   351: iconst_1
    //   352: invokevirtual 1443	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   355: new 1445	tencent/im/msg/im_msg$RoutingHead
    //   358: dup
    //   359: invokespecial 1446	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: getfield 1450	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   367: aload_3
    //   368: invokevirtual 1451	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: new 1453	tencent/im/msg/im_msg$ContentHead
    //   374: dup
    //   375: invokespecial 1454	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   378: astore_3
    //   379: aload_3
    //   380: getfield 1457	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: astore 10
    //   385: getstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_k_of_type_Int	I
    //   388: istore_1
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: putstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_k_of_type_Int	I
    //   395: aload 10
    //   397: iload_1
    //   398: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   401: new 1459	tencent/im/msg/im_msg$MsgHead
    //   404: dup
    //   405: invokespecial 1460	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   408: astore 10
    //   410: aload 10
    //   412: getfield 1464	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   415: aload_3
    //   416: invokevirtual 1465	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   419: aload 10
    //   421: getfield 1469	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   424: aload_2
    //   425: invokevirtual 1470	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   428: aload 11
    //   430: getfield 1474	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   433: aload 10
    //   435: invokevirtual 1475	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   438: new 1477	tencent/im/msg/im_imagent$Signature
    //   441: dup
    //   442: invokespecial 1478	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   445: astore 13
    //   447: aload 13
    //   449: getfield 1481	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: iconst_1
    //   453: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   456: aload 13
    //   458: getfield 1484	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: sipush 256
    //   464: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   467: aload_0
    //   468: getfield 210	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   471: invokestatic 1489	bkki:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   474: astore_2
    //   475: aload_2
    //   476: invokestatic 276	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: istore 9
    //   481: aload_2
    //   482: astore 10
    //   484: iload 9
    //   486: ifeq +50 -> 536
    //   489: aconst_null
    //   490: areturn
    //   491: astore_3
    //   492: ldc 104
    //   494: astore_2
    //   495: aload_2
    //   496: astore 10
    //   498: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +35 -> 536
    //   504: ldc 237
    //   506: iconst_2
    //   507: new 283	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 1491
    //   517: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_3
    //   521: invokevirtual 1494	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   524: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 1497	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload_2
    //   534: astore 10
    //   536: aload 13
    //   538: getfield 1500	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   541: aload 10
    //   543: invokestatic 1303	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   546: invokevirtual 1309	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   549: new 1502	tencent/im/msg/im_imagent$ImAgentHead
    //   552: dup
    //   553: invokespecial 1503	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   556: astore_2
    //   557: aload_2
    //   558: getfield 1506	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   561: iconst_3
    //   562: invokevirtual 1443	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   565: aload_2
    //   566: getfield 1510	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   569: aload 13
    //   571: invokevirtual 1511	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   574: aload_2
    //   575: getfield 1514	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   578: aload 12
    //   580: invokevirtual 1425	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   583: aload_2
    //   584: getfield 1515	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   587: astore_3
    //   588: getstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_k_of_type_Int	I
    //   591: istore_1
    //   592: iload_1
    //   593: iconst_1
    //   594: iadd
    //   595: putstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_k_of_type_Int	I
    //   598: aload_3
    //   599: iload_1
    //   600: invokevirtual 1349	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   603: new 1517	tencent/im/msg/im_msg$MsgSendReq
    //   606: dup
    //   607: invokespecial 1518	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   610: astore_3
    //   611: aload_3
    //   612: getfield 1521	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   615: aload 11
    //   617: invokevirtual 1522	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   620: new 1524	tencent/im/msg/im_imagent$ImAgentPackage
    //   623: dup
    //   624: invokespecial 1525	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   627: astore 10
    //   629: aload 10
    //   631: getfield 1528	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   634: aload_2
    //   635: invokevirtual 1529	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   638: aload 10
    //   640: getfield 1533	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   643: aload_3
    //   644: invokevirtual 1534	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   647: aload 10
    //   649: invokevirtual 1535	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   652: astore_2
    //   653: new 1537	java/io/ByteArrayOutputStream
    //   656: dup
    //   657: aload_2
    //   658: arraylength
    //   659: bipush 8
    //   661: iadd
    //   662: invokespecial 1539	java/io/ByteArrayOutputStream:<init>	(I)V
    //   665: astore_3
    //   666: new 1541	java/io/DataOutputStream
    //   669: dup
    //   670: aload_3
    //   671: invokespecial 1544	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   674: astore 10
    //   676: aload 10
    //   678: aload_2
    //   679: arraylength
    //   680: bipush 8
    //   682: iadd
    //   683: invokevirtual 1547	java/io/DataOutputStream:writeInt	(I)V
    //   686: aload 10
    //   688: bipush 123
    //   690: invokevirtual 1550	java/io/DataOutputStream:write	(I)V
    //   693: aload 10
    //   695: bipush 123
    //   697: invokevirtual 1550	java/io/DataOutputStream:write	(I)V
    //   700: aload 10
    //   702: aload_2
    //   703: invokevirtual 1553	java/io/DataOutputStream:write	([B)V
    //   706: aload 10
    //   708: bipush 125
    //   710: invokevirtual 1550	java/io/DataOutputStream:write	(I)V
    //   713: aload 10
    //   715: bipush 125
    //   717: invokevirtual 1550	java/io/DataOutputStream:write	(I)V
    //   720: aload_3
    //   721: invokevirtual 1554	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   724: astore 11
    //   726: new 283	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   733: ldc_w 1556
    //   736: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: astore 12
    //   741: aload 11
    //   743: ifnonnull +38 -> 781
    //   746: ldc_w 1558
    //   749: astore_2
    //   750: ldc 237
    //   752: iconst_1
    //   753: aload 12
    //   755: aload_2
    //   756: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_3
    //   766: invokevirtual 1560	java/io/ByteArrayOutputStream:close	()V
    //   769: aload 10
    //   771: invokevirtual 1561	java/io/DataOutputStream:close	()V
    //   774: aload 11
    //   776: areturn
    //   777: astore_2
    //   778: aload 11
    //   780: areturn
    //   781: aload 11
    //   783: arraylength
    //   784: istore_1
    //   785: iload_1
    //   786: invokestatic 721	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   789: astore_2
    //   790: goto -40 -> 750
    //   793: astore_2
    //   794: aload_2
    //   795: invokevirtual 1562	java/lang/Exception:printStackTrace	()V
    //   798: aload_3
    //   799: invokevirtual 1560	java/io/ByteArrayOutputStream:close	()V
    //   802: aload 10
    //   804: invokevirtual 1561	java/io/DataOutputStream:close	()V
    //   807: aconst_null
    //   808: areturn
    //   809: astore_2
    //   810: aload_3
    //   811: invokevirtual 1560	java/io/ByteArrayOutputStream:close	()V
    //   814: aload 10
    //   816: invokevirtual 1561	java/io/DataOutputStream:close	()V
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
      int i1 = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = AutoRemarkActivity.a(paramEditable);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (i1 >= paramEditable.length()) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131693270) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void b(String paramString)
  {
    if (!NetworkUtil.isNetSupport(this)) {}
    ArrayList localArrayList;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131718059), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while (!getIntent().hasExtra("contacts"));
      localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      this.jdField_a_of_type_Bisl.setOnDismissListener(new adfx(this));
    }
    this.jdField_a_of_type_Bisl.setCancelable(true);
    this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bisl.c(2131718527);
    this.jdField_a_of_type_Bisl.show();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addBatchPhoneFriend(this.jdField_b_of_type_JavaUtilArrayList, paramString, 0, this.jdField_d_of_type_Int, new ArrayList());
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
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 1, 2131695803, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new AddFriendVerifyActivity.23(this, paramString), 5, null, false);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_e_of_type_Int != 4) {
      this.jdField_j_of_type_AndroidWidgetTextView.setText("30");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
      return;
      int i2 = 0;
      try
      {
        i1 = paramString.getBytes("utf-8").length;
        this.jdField_j_of_type_AndroidWidgetTextView.setText(90 - i1 + "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
            i1 = i2;
          }
        }
      }
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
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, paramInt1));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(anvx.a(2131699373) + AutoRemarkActivity.a(this.app, paramInt1));
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
        if (this.jdField_a_of_type_Bisl != null)
        {
          this.jdField_a_of_type_Bisl.cancel();
          this.jdField_a_of_type_Bisl = null;
        }
        e(getString(2131718059));
        c();
      }
    }
    for (;;)
    {
      bool1 = false;
      break label280;
      break;
      if (this.jdField_a_of_type_Bisl != null)
      {
        this.jdField_a_of_type_Bisl.cancel();
        this.jdField_a_of_type_Bisl = null;
      }
      e(getString(2131718059));
      c();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = getIntent();
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("uin");
    this.jdField_e_of_type_Int = ((Intent)localObject2).getIntExtra("k_uin_type", 1);
    if (this.jdField_e_of_type_Int != 4) {
      setTheme(2131755153);
    }
    this.jdField_g_of_type_Int = ((Intent)localObject2).getIntExtra("entrance", -1);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    Object localObject3;
    int i2;
    if (this.jdField_e_of_type_Int == 4)
    {
      setContentViewB(2131558477);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131380720));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380727));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380724));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380725));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131380721));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380723));
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379495));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362136));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368524));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368600));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.m = ((TextView)findViewById(2131373430));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374000));
      this.n = ((TextView)findViewById(2131374002));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131373999));
      this.o = ((TextView)findViewById(2131374001));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131372980));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380726));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373428));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373429));
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      this.jdField_a_of_type_Bisl.c(2131690753);
      this.jdField_g_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authKey");
      this.jdField_h_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authSig");
      if (this.jdField_g_of_type_JavaLangString != null) {}
      paramBundle = getIntent().getExtras().getString("nick_name");
      if (this.jdField_e_of_type_Int != 4) {
        break label2980;
      }
      setTitle(2131689663);
      localObject3 = (TextView)findViewById(2131369231);
      localObject1 = getIntent().getExtras().getString("leftViewText");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = getString(2131690676);
      }
      ((TextView)localObject3).setText(paramBundle);
      this.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
      addObserver(this.jdField_a_of_type_Aofu);
      paramBundle = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      this.jdField_d_of_type_JavaLangString = getIntent().getExtras().getString("key_param_homework_intro_str");
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        paramBundle.d(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = getIntent().getExtras().getShort("group_option", (short)2);
      i1 = this.jdField_a_of_type_Int;
      localObject1 = getIntent().getExtras().getString("troop_question");
      getIntent().getExtras().getString("troop_answer");
      i2 = getIntent().getIntExtra("stat_option", 0);
      bhbu.a(this.jdField_a_of_type_JavaLangString, 1, 1, i2);
      paramBundle.b(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), Long.valueOf(this.app.getCurrentUin()).longValue(), null);
      switch (i1)
      {
      default: 
        label744:
        getWindow().setSoftInputMode(5);
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Int == 3)
      {
        paramBundle = ((Intent)localObject2).getStringExtra("is_from_game");
        localObject1 = ((Intent)localObject2).getStringExtra("extra");
      }
      try
      {
        localObject2 = aqxd.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(paramBundle)) || (((ardt)localObject2).b())) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          TroopUtils.checkApiState(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "AddFriend enableCheckPermission = " + ((ardt)localObject2).b());
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i3;
          int i4;
          int i5;
          if (("true".equals(paramBundle)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            TroopUtils.checkApiState(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          }
          QLog.d("AddFriendVerifyActivity", 1, "AddFriend loadConfig exception = " + localException);
          continue;
          i1 = 0;
          continue;
        }
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      enableRightHighlight(true);
      if (bjxa.b(this.app, this.jdField_f_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("webImVisitId");
      return true;
      setContentViewB(2131558476);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
      i1 = getIntent().getIntExtra("sub_source_id", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject2).getIntExtra("source_id", 3999);
      if (((Intent)localObject2).hasExtra("param_wzry_data")) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)((Intent)localObject2).getSerializableExtra("param_wzry_data"));
      }
      if (AutoRemarkActivity.a(this.jdField_d_of_type_Int))
      {
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
        label1020:
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "AddFriendVerifyActivity remark = " + this.jdField_e_of_type_JavaLangString + ", source id=" + this.jdField_d_of_type_Int + ", mTargetGroupId = " + this.jdField_c_of_type_Int);
        }
        if ((paramBundle == null) && (NetworkUtil.isNetSupport(this)) && (AutoRemarkActivity.a(this.jdField_d_of_type_Int, this.jdField_f_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getAutoInfo(this.jdField_f_of_type_JavaLangString, this.jdField_d_of_type_Int, ((Intent)localObject2).getIntExtra("sub_source_id", 0));
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363762));
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new adfs(this));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376563));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376564));
        this.jdField_a_of_type_Adgu = new adgu(100, this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Adgu);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362306));
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
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371859));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362724));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373053));
        this.l = ((TextView)findViewById(2131371981));
        this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379071));
        this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367865));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131376862));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131376821));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
        this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366277));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379966));
        this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_e_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_e_of_type_JavaLangString.length());
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, this.jdField_c_of_type_Int));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(anvx.a(2131699367) + AutoRemarkActivity.a(this.app, this.jdField_c_of_type_Int));
        if (!bhbx.b(this.jdField_f_of_type_JavaLangString)) {
          break label1872;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131689575));
        label1600:
        if ((!bpup.a(this.jdField_d_of_type_Int)) && (this.jdField_d_of_type_Int != 3016)) {
          break label1897;
        }
        i1 = 1;
        label1622:
        if (i1 == 0)
        {
          this.jdField_a_of_type_AndroidViewView = findViewById(2131375717);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131375718));
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        }
        if (!AppSetting.jdField_c_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131692081));
        if (bhbx.b(this.jdField_f_of_type_JavaLangString)) {
          break label1902;
        }
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718030));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131693270) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (i1 != 0) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.setFocusable(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717267));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
        {
          this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
          break label1020;
        }
        if ((this.jdField_d_of_type_Int != 3004) || ((i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 8))) {
          break label1020;
        }
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
        break label1020;
        label1872:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131689574));
        break label1600;
        label1897:
        i1 = 0;
        break label1622;
        label1902:
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718029));
      }
      break label744;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.m.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams()).topMargin = 0;
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)1));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetEditText.setHeight(AIOUtils.dp2px(160.0F, getResources()));
      this.jdField_c_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_c_of_type_AndroidWidgetEditText.setGravity(48);
      this.jdField_c_of_type_AndroidWidgetEditText.setHint("");
      i1 = AIOUtils.dp2px(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(i1, i1, i1, i1);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        paramBundle = getString(2131697285, new Object[] { this.app.getCurrentNickname() });
        label2127:
        d(paramBundle);
        if (bhrt.a())
        {
          bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A4F8", 0, 0, "", "", "", "");
          paramBundle = new GridLayoutManager(this, 2);
          this.jdField_a_of_type_Ahcm = new ahcm(this);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ahcm);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
          paramBundle = (aogw)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
          if (paramBundle == null) {
            break label2310;
          }
          localObject1 = new UniGetReq();
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(Integer.valueOf(40));
          ((UniGetReq)localObject1).appidList = ((ArrayList)localObject3);
          paramBundle.a((UniGetReq)localObject1, new adgv(this, 0), false);
        }
      }
      for (;;)
      {
        setRightHighlightButton(2131690786, new adgd(this));
        break;
        paramBundle = this.jdField_d_of_type_JavaLangString;
        break label2127;
        label2310:
        QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new QQText(getString(2131716583) + ":" + (String)localObject1, 13);
      this.n.setText(paramBundle);
      this.n.setTag(this.jdField_a_of_type_JavaLangString);
      this.n.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131691909));
      }
      setRightHighlightButton(2131690786, new adgn(this));
      bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      if (paramBundle.mSpanCount <= 0) {
        break label744;
      }
      i2 = 0;
      if (i2 >= paramBundle.mSpans.length) {
        break label744;
      }
      if (!(paramBundle.mSpans[i2] instanceof QQText.LinkSpan)) {}
      for (;;)
      {
        i2 += 1;
        break;
        localObject1 = ((QQText.LinkSpan)paramBundle.mSpans[i2]).mUrl;
        i1 = -1;
        if (bhfp.d.matcher((CharSequence)localObject1).find()) {
          i1 = 0;
        }
        if (QQTextParseLinkUtil.QQ_NUMBER_PATTERN.matcher((CharSequence)localObject1).find()) {
          i1 = 1;
        }
        if (!QQTextParseLinkUtil.QQ_PHONE_PATTERN.matcher((CharSequence)localObject1).find()) {
          break label5234;
        }
        i1 = 2;
        bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_a_of_type_JavaLangString, "" + i1, "", "");
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new QQText(getString(2131716583) + ":" + (String)localObject1, 13);
      this.n.setText(paramBundle);
      this.n.setTag(this.jdField_a_of_type_JavaLangString);
      this.n.setMovementMethod(LinkMovementMethod.getInstance());
      this.n.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131691909));
      }
      setRightHighlightButton(2131690786, new adgp(this));
      bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      if (paramBundle.mSpanCount <= 0) {
        break label744;
      }
      i2 = 0;
      label2835:
      if (i2 < paramBundle.mSpans.length) {
        if ((paramBundle.mSpans[i2] instanceof QQText.LinkSpan)) {
          break label2863;
        }
      }
      for (;;)
      {
        i2 += 1;
        break label2835;
        break;
        label2863:
        localObject1 = ((QQText.LinkSpan)paramBundle.mSpans[i2]).mUrl;
        i1 = -1;
        if (bhfp.d.matcher((CharSequence)localObject1).find()) {
          i1 = 0;
        }
        if (QQTextParseLinkUtil.QQ_NUMBER_PATTERN.matcher((CharSequence)localObject1).find()) {
          i1 = 1;
        }
        if (!QQTextParseLinkUtil.QQ_PHONE_PATTERN.matcher((CharSequence)localObject1).find()) {
          break label5231;
        }
        i1 = 2;
        bdla.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_a_of_type_JavaLangString, "" + i1, "", "");
      }
      label2980:
      setTitle(2131689570);
      setLeftButton(anvx.a(2131699338), null);
      localObject1 = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      i3 = getIntent().getExtras().getInt("source_id", 3999);
      i4 = getIntent().getIntExtra("sub_source_id", 0);
      if (bpup.a(getIntent().getIntExtra("sort_id", 0)))
      {
        localObject3 = this.jdField_f_of_type_JavaLangString;
        ((anri)localObject1).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject3, 0L, 10004, null, (byte)0);
        label3097:
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        addObserver(this.jdField_a_of_type_Anvi);
        addObserver(this.jdField_a_of_type_Bjyh);
        if (this.jdField_e_of_type_Int != 2) {
          break label3517;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 11, this.jdField_f_of_type_JavaLangString));
        localObject3 = this.l;
        if (!TextUtils.isEmpty(paramBundle)) {
          break label3511;
        }
        localObject1 = this.jdField_f_of_type_JavaLangString;
        label3168:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          localObject3 = this.l;
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = this.jdField_f_of_type_JavaLangString;
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
        }
        label3210:
        i5 = ((Intent)localObject2).getIntExtra("friend_setting", 0);
        localObject1 = getIntent().getExtras().getStringArrayList("user_question");
      }
      switch (i5)
      {
      default: 
        break;
      case 0: 
      case 2: 
        if ((i3 == 3078) || (i3 == 3079))
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689558));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.l.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689576));
          }
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (getIntent() != null) {}
          for (i1 = getIntent().getIntExtra("contact_from_type", 1);; i1 = 1)
          {
            setRightHighlightButton(2131690786, new adgq(this, i1));
            paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
            paramBundle.topMargin = AIOUtils.dp2px(20.0F, getResources());
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
            break;
            ((anri)localObject1).a(this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
            break label3097;
            localObject1 = paramBundle;
            break label3168;
            if (this.jdField_e_of_type_Int == 3)
            {
              localObject1 = ((Intent)localObject2).getStringExtra("extra");
              localObject1 = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.jdField_f_of_type_JavaLangString, (String)localObject1), URLDrawable.URLDrawableOptions.obtain());
              if (bdfk.a()) {
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              }
              for (;;)
              {
                this.l.setText(paramBundle);
                if (AppSetting.jdField_c_of_type_Boolean) {
                  this.l.setContentDescription(paramBundle);
                }
                ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).infoOpenId(this.jdField_f_of_type_JavaLangString, getIntent().getStringExtra("extra"));
                break;
                a((URLDrawable)localObject1);
              }
            }
            if ((i3 == 3007) || (i3 == 2007) || (i3 == 4007) || (i3 == 3019) || (i3 == 2019)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_f_of_type_JavaLangString, true));
            }
            for (;;)
            {
              if (!a()) {
                break label3751;
              }
              if (paramBundle == null) {
                break;
              }
              this.l.setText(paramBundle);
              if (!AppSetting.jdField_c_of_type_Boolean) {
                break;
              }
              this.l.setContentDescription(paramBundle);
              break;
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_f_of_type_JavaLangString));
            }
            ThreadManager.getSubThreadHandler().post(new AddFriendVerifyActivity.5(this, paramBundle));
            break label3210;
          }
        }
        setRightHighlightButton(2131690786, new adgr(this, i3, i4));
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
        paramBundle.topMargin = AIOUtils.dp2px(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bdla.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        a(i3, i5);
        break;
      case 1: 
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689576));
        }
        setRightHighlightButton(2131690786, new adgs(this, i3, i4, i5));
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
        paramBundle.topMargin = AIOUtils.dp2px(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bdla.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        break;
      case 3: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramBundle = (String)((ArrayList)localObject1).get(0);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378673);
        localObject3 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368928);
        this.jdField_b_of_type_Adgu = new adgu(50, (EditText)localObject3);
        ((EditText)localObject3).addTextChangedListener(this.jdField_b_of_type_Adgu);
        ((TextView)localObject1).setText(getString(2131716583) + ":" + paramBundle);
        ((EditText)localObject3).setSingleLine(true);
        if (jdField_a_of_type_Boolean)
        {
          ((TextView)localObject1).setContentDescription(getString(2131716583) + ":" + paramBundle);
          ((EditText)localObject3).setContentDescription(getString(2131689573));
        }
        setRightHighlightButton(2131690786, new adgt(this, (EditText)localObject3, i5, i3, i4));
        getWindow().setSoftInputMode(5);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
        paramBundle.topMargin = AIOUtils.dp2px(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bdla.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        break;
      case 4: 
        label3511:
        label3517:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        label3751:
        localObject3 = new StringBuffer();
        if ((localObject1 == null) || (((ArrayList)localObject1).size() != 1)) {
          break label5226;
        }
        i1 = 1;
        i2 = 0;
        if (i2 < ((ArrayList)localObject1).size())
        {
          switch (i2)
          {
          default: 
            paramBundle = getResources().getString(2131716583);
          }
          for (;;)
          {
            Object localObject6 = getLayoutInflater().inflate(2131560947, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            Object localObject4 = getLayoutInflater().inflate(2131560946, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            if (i2 > 0)
            {
              localObject5 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
              if (localObject5 != null)
              {
                ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)bhdz.a(getApplication(), 19.0F));
                ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              }
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject6);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
            Object localObject5 = (String)((ArrayList)localObject1).get(i2);
            localObject6 = (TextView)((View)localObject6).findViewById(2131378673);
            ((TextView)localObject6).setText(paramBundle + (String)localObject5);
            localObject4 = (EditText)((View)localObject4).findViewById(2131368928);
            ((EditText)localObject4).addTextChangedListener(new adgu(50, (EditText)localObject4));
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            if (jdField_a_of_type_Boolean)
            {
              ((TextView)localObject6).setContentDescription(paramBundle + (String)localObject5);
              ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).setContentDescription(getString(2131689573));
            }
            int i6 = i2 + 1;
            ((StringBuffer)localObject3).append(getString(2131716583) + i6 + ":" + (String)localObject5);
            ((StringBuffer)localObject3).append("\n");
            ((StringBuffer)localObject3).append(getString(2131690049) + ":${answer}");
            if (i6 != ((ArrayList)localObject1).size()) {
              ((StringBuffer)localObject3).append("\n");
            }
            i2 += 1;
            break;
            if (i1 != 0)
            {
              paramBundle = getResources().getString(2131716584);
            }
            else
            {
              paramBundle = getResources().getString(2131716585);
              continue;
              paramBundle = getResources().getString(2131716586);
              continue;
              paramBundle = getResources().getString(2131716587);
              continue;
              paramBundle = getResources().getString(2131716588);
              continue;
              paramBundle = getResources().getString(2131716589);
            }
          }
        }
        setRightHighlightButton(2131690786, new adft(this, (StringBuffer)localObject3, i3, i4, i5));
        findViewById(2131376866).setOnTouchListener(new adfu(this));
        getWindow().setSoftInputMode(4);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
        paramBundle.topMargin = AIOUtils.dp2px(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        bdla.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
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
    int i1 = 1;
    int i2 = 0;
    super.doOnResume();
    if (this.jdField_e_of_type_Int != 4) {}
    String str1;
    Object localObject2;
    switch (getIntent().getIntExtra("friend_setting", 0))
    {
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.jdField_d_of_type_Int != 3078) && (this.jdField_d_of_type_Int != 3079));
      str1 = a(false);
      localObject2 = getString(2131691907);
      if (TextUtils.isEmpty(str1)) {
        if (!b()) {
          str1 = (String)localObject2 + ContactUtils.getFriendNick(this.app, this.app.getAccount());
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
      if (i1 != 0) {}
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
      String str4 = getString(2131691907);
      String str2;
      if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
      {
        localObject2 = str4 + getString(2131698060) + " " + ContactUtils.getFriendNick(this.app, this.app.getAccount());
        this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject2);
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689576));
        }
        if (this.jdField_e_of_type_Int != 3) {
          break label492;
        }
        str2 = getIntent().getStringExtra("msg");
        i1 = 1;
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
          if ((i1 != 0) && (str4.equals(localObject2)) && (!b())) {
            str2 = (String)localObject2 + ContactUtils.getFriendNick(this.app, this.app.getAccount());
          }
          for (i1 = 1;; i1 = i2)
          {
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetEditText.setText(str2);
              if (i1 != 0) {}
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
                  i1 = 0;
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
        i1 = 1;
        continue;
        label557:
        localObject1 = null;
        i1 = 1;
      }
      i1 = 0;
      Object localObject1 = localObject2;
      continue;
      i1 = 0;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Anvi != null) {
      addObserver(this.jdField_a_of_type_Anvi);
    }
    if (this.jdField_a_of_type_Aofu != null) {
      addObserver(this.jdField_a_of_type_Aofu);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_Bjyh != null) {
      addObserver(this.jdField_a_of_type_Bjyh);
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_Anvi != null) {
      removeObserver(this.jdField_a_of_type_Anvi);
    }
    if (this.jdField_a_of_type_Aofu != null) {
      removeObserver(this.jdField_a_of_type_Aofu);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_Bjyh != null) {
      removeObserver(this.jdField_a_of_type_Bjyh);
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
    localIntent.setPackage(getPackageName());
    localIntent.putExtra("ret_action", this.jdField_h_of_type_Int);
    sendBroadcast(localIntent);
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
    getWindow().setSoftInputMode(2);
    super.finish();
    if (this.jdField_e_of_type_Int != 4) {
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
    if (this.jdField_e_of_type_Int != 4)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (4 != this.jdField_e_of_type_Int) {
        break label177;
      }
    }
    for (;;)
    {
      a((String)localObject, bool);
      if ((getString(2131691907).equals(localObject)) && (!b())) {
        b();
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        bdla.b(this.app, "dc00899", "Qidian", this.jdField_f_of_type_JavaLangString, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
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
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, 1, 2131694255, 0).b(getTitleBarHeight());
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
          this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717267));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.jdField_f_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        blwh localblwh = new blwh(0);
        localblwh.jdField_d_of_type_JavaLangString = "QQ空间";
        localblwh.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.getQZonePluginName();
        localblwh.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        localblwh.jdField_e_of_type_JavaLangString = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localblwh.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        blvy.b(this.app.getApp(), localblwh);
        bdla.b(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
      }
      localObject = paramCompoundButton.getTag();
      if (((localObject instanceof Integer)) && (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) == null) || (this.jdField_a_of_type_JavaLangString != null))) {
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
      Intent localIntent = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
      localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult(localIntent, 1002);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
      }
      bdla.b(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
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
    if (paramView.getId() == 2131368928) {}
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