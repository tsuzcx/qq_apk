package com.tencent.mobileqq.activity;

import abgw;
import abgy;
import absc;
import absd;
import abse;
import absf;
import absg;
import absh;
import absi;
import absj;
import absk;
import absl;
import abtq;
import actj;
import aijy;
import ajsd;
import ajti;
import ajto;
import ajxj;
import ajxl;
import ajya;
import akat;
import akgh;
import amdj;
import amdk;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import aqbe;
import aqkn;
import aset;
import asxd;
import asyd;
import asyg;
import auvb;
import awzy;
import axqy;
import axum;
import axup;
import axuq;
import axws;
import axxi;
import axyo;
import axzj;
import bbac;
import bbax;
import bbbr;
import bbcz;
import bbfj;
import bcqf;
import bcql;
import bduf;
import bfpc;
import bgyp;
import bgyw;
import bhpf;
import bhpg;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import myv;
import xkn;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements abgy, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  public abgw a;
  ajto jdField_a_of_type_Ajto = new absl(this);
  ajxj jdField_a_of_type_Ajxj = new absj(this);
  akat jdField_a_of_type_Akat = new absh(this);
  akgh jdField_a_of_type_Akgh = new absi(this);
  amdj jdField_a_of_type_Amdj;
  amdk jdField_a_of_type_Amdk = new absk(this);
  public Intent a;
  public Bundle a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aqkn jdField_a_of_type_Aqkn = new absc(this);
  private auvb jdField_a_of_type_Auvb;
  public bcqf a;
  public ProfileActivity.AllInOne a;
  public BusinessCard a;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public FormSimpleItem a;
  public FormSwitchItem a;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new absf(this);
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int = -1;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne b;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem d;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  FormSimpleItem jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  FormSimpleItem jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_i_of_type_Boolean;
  FormSimpleItem jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_j_of_type_Boolean;
  
  public ProfileCardMoreActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static axuq a(String paramString)
  {
    axyo localaxyo = new axyo();
    localaxyo.b(1);
    localaxyo.a(paramString);
    return localaxyo;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent.hasExtra("param_interest_switch")) {
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("param_interest_switch", 0);
    }
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("param_interest_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_music_switch")) {
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("param_music_switch", 0);
    }
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("param_music_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_present_switch")) {
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("param_present_switch", 0);
    }
    if (!this.jdField_g_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("param_present_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_extendfriend_switch")) {
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("param_extendfriend_switch", 0);
    }
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("param_extendfriend_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_personlabel_switch")) {
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("param_personlabel_switch", 0);
    }
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("param_personlabel_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_miniapp_switch")) {
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("param_miniapp_switch", 0);
    }
    if (!this.jdField_h_of_type_Boolean) {
      this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("param_miniapp_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_musicbox_switch")) {
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("param_musicbox_switch", 0);
    }
    if (!this.jdField_i_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("param_musicbox_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_sticky_note_switch")) {
      this.jdField_i_of_type_Int = paramIntent.getIntExtra("param_sticky_note_switch", 0);
    }
    if (!this.jdField_j_of_type_Boolean) {
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("param_sticky_note_switch_changed", false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!bbfj.d(BaseApplication.getContext()))
    {
      a(2131692321, 1);
      d();
      return;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (l > 0L) {
        if (!paramBoolean)
        {
          bool1 = true;
          localFriendListHandler.a(l, bool1);
          k = 1;
          if (k == 0) {
            break label126;
          }
          if (paramBoolean) {
            break label121;
          }
          paramBoolean = bool2;
          this.jdField_a_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_Int |= 0x2;
          e();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
        continue;
        boolean bool1 = false;
        continue;
        label121:
        paramBoolean = false;
        continue;
        label126:
        if (paramBoolean) {
          a(2131719529, 1);
        }
        for (;;)
        {
          d();
          return;
          a(2131719531, 1);
        }
        int k = 0;
      }
    }
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.jdField_j_of_type_Boolean);
  }
  
  private void j()
  {
    boolean bool = false;
    Object localObject;
    asyd localasyd;
    int k;
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      localObject = "";
      localasyd = asxd.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
      if (localasyd == null) {
        break label195;
      }
      if (localasyd.a != 1L) {
        break label122;
      }
      localObject = getString(2131693609);
      k = localasyd.jdField_c_of_type_Int;
      bool = localasyd.c();
    }
    for (;;)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      if (k != 0)
      {
        localObject = getResources().getDrawable(k);
        if ((localObject instanceof SkinnableBitmapDrawable))
        {
          localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
          label103:
          if (!bool) {
            break label176;
          }
          ((Drawable)localObject).setAlpha(102);
        }
        for (;;)
        {
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
          return;
          label122:
          if (localasyd.a == 2L)
          {
            localObject = getString(2131693607);
            break;
          }
          if (localasyd.a != 3L) {
            break;
          }
          localObject = getString(2131693608);
          break;
          localObject = ((Drawable)localObject).mutate();
          break label103;
          label176:
          ((Drawable)localObject).setAlpha(255);
        }
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      return;
      label195:
      k = 0;
    }
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this, InterestSwitchEditActivity.class);
    if (-1 != this.jdField_b_of_type_Int) {
      localIntent.putExtra("param_interest_switch", this.jdField_b_of_type_Int);
    }
    if (-1 != this.jdField_c_of_type_Int) {
      localIntent.putExtra("param_music_switch", this.jdField_c_of_type_Int);
    }
    if (-1 != this.jdField_e_of_type_Int) {
      localIntent.putExtra("param_extendfriend_switch", this.jdField_e_of_type_Int);
    }
    if (-1 != this.jdField_d_of_type_Int) {
      localIntent.putExtra("param_personlabel_switch", this.jdField_d_of_type_Int);
    }
    if (-1 != this.jdField_f_of_type_Int) {
      localIntent.putExtra("param_present_switch", this.jdField_f_of_type_Int);
    }
    if (-1 != this.jdField_g_of_type_Int) {
      localIntent.putExtra("param_miniapp_switch", this.jdField_g_of_type_Int);
    }
    if (-1 != this.jdField_h_of_type_Int) {
      localIntent.putExtra("param_musicbox_switch", this.jdField_h_of_type_Int);
    }
    if (-1 != this.jdField_i_of_type_Int) {
      localIntent.putExtra("param_sticky_note_switch", this.jdField_i_of_type_Int);
    }
    startActivityForResult(localIntent, 1008);
  }
  
  private void l()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690577));
      }
    }
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 354	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 357	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 213	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 361	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Laukq;
    //   23: invokevirtual 367	aukq:createEntityManager	()Laukp;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3446 -> 3476
    //   33: aload 11
    //   35: ldc_w 369
    //   38: aload_1
    //   39: invokevirtual 374	aukp:a	(Ljava/lang/Class;Ljava/lang/String;)Lauko;
    //   42: checkcast 369	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   45: astore 15
    //   47: aload 11
    //   49: ifnull +8 -> 57
    //   52: aload 11
    //   54: invokevirtual 376	aukp:a	()V
    //   57: aload 15
    //   59: ifnonnull +5 -> 64
    //   62: iconst_m1
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 378	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokestatic 384	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +877 -> 948
    //   74: aload_0
    //   75: getfield 378	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: astore 12
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore 4
    //   85: aconst_null
    //   86: astore 13
    //   88: aload_0
    //   89: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   92: astore 16
    //   94: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   97: astore 14
    //   99: new 396	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 399
    //   109: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 12
    //   114: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 405
    //   120: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 11
    //   128: aload 16
    //   130: aload 14
    //   132: iconst_4
    //   133: anewarray 350	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: ldc_w 410
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: ldc_w 412
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: ldc_w 414
    //   153: aastore
    //   154: dup
    //   155: iconst_3
    //   156: ldc_w 416
    //   159: aastore
    //   160: aload 11
    //   162: aconst_null
    //   163: aconst_null
    //   164: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   167: astore 11
    //   169: iconst_0
    //   170: istore_3
    //   171: lconst_0
    //   172: lstore 8
    //   174: iload 4
    //   176: istore_2
    //   177: aload 11
    //   179: ifnull +3284 -> 3463
    //   182: aload 11
    //   184: invokeinterface 427 1 0
    //   189: istore 10
    //   191: iload 10
    //   193: ifeq +3270 -> 3463
    //   196: aload 11
    //   198: iconst_0
    //   199: invokeinterface 431 2 0
    //   204: lstore 6
    //   206: iload_2
    //   207: istore 4
    //   209: aload 15
    //   211: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnull +873 -> 1091
    //   221: aconst_null
    //   222: astore 14
    //   224: aload_0
    //   225: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   228: astore 17
    //   230: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   233: astore 13
    //   235: new 396	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 436
    //   245: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: lload 6
    //   250: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: ldc_w 441
    //   256: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 414
    //   262: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 443
    //   268: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 445
    //   274: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc_w 447
    //   280: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 416
    //   286: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 443
    //   292: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 15
    //   297: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   300: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 447
    //   306: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 449
    //   312: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 443
    //   318: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iconst_2
    //   322: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: ldc_w 405
    //   328: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore 16
    //   336: aload 17
    //   338: aload 13
    //   340: iconst_5
    //   341: anewarray 350	java/lang/String
    //   344: dup
    //   345: iconst_0
    //   346: ldc_w 410
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: ldc_w 412
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: ldc_w 414
    //   361: aastore
    //   362: dup
    //   363: iconst_3
    //   364: ldc_w 416
    //   367: aastore
    //   368: dup
    //   369: iconst_4
    //   370: ldc_w 449
    //   373: aastore
    //   374: aload 16
    //   376: aconst_null
    //   377: aconst_null
    //   378: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   381: astore 13
    //   383: aload 13
    //   385: ifnull +594 -> 979
    //   388: aload 13
    //   390: invokeinterface 455 1 0
    //   395: istore 10
    //   397: iload 10
    //   399: ifeq +580 -> 979
    //   402: iconst_1
    //   403: istore_3
    //   404: iconst_1
    //   405: istore_2
    //   406: aload 13
    //   408: invokeinterface 458 1 0
    //   413: iconst_0
    //   414: ifeq +3042 -> 3456
    //   417: new 460	java/lang/NullPointerException
    //   420: dup
    //   421: invokespecial 461	java/lang/NullPointerException:<init>	()V
    //   424: athrow
    //   425: iload_3
    //   426: istore 5
    //   428: lload 6
    //   430: lstore 8
    //   432: iload_2
    //   433: istore 4
    //   435: aload 11
    //   437: ifnull +3006 -> 3443
    //   440: aload 11
    //   442: invokeinterface 458 1 0
    //   447: iload_3
    //   448: ifne +668 -> 1116
    //   451: iconst_1
    //   452: istore_3
    //   453: iconst_0
    //   454: istore_2
    //   455: new 463	android/content/ContentValues
    //   458: dup
    //   459: invokespecial 464	android/content/ContentValues:<init>	()V
    //   462: astore 13
    //   464: iload_3
    //   465: iconst_1
    //   466: if_icmpne +668 -> 1134
    //   469: aload_0
    //   470: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   473: getstatic 467	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   476: aload 13
    //   478: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   481: invokestatic 477	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   484: lstore 6
    //   486: aload 12
    //   488: invokestatic 384	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   491: ifne +55 -> 546
    //   494: aload 13
    //   496: invokevirtual 480	android/content/ContentValues:clear	()V
    //   499: aload 13
    //   501: ldc_w 410
    //   504: lload 6
    //   506: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   512: aload 13
    //   514: ldc_w 414
    //   517: ldc_w 490
    //   520: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload 13
    //   525: ldc_w 416
    //   528: aload 12
    //   530: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   537: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   540: aload 13
    //   542: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   545: pop
    //   546: aload 15
    //   548: getfield 496	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   551: ifnonnull +11 -> 562
    //   554: aload 15
    //   556: getfield 499	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   559: ifnull +99 -> 658
    //   562: aload 13
    //   564: invokevirtual 480	android/content/ContentValues:clear	()V
    //   567: aload 13
    //   569: ldc_w 410
    //   572: lload 6
    //   574: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   577: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   580: aload 13
    //   582: ldc_w 414
    //   585: ldc_w 501
    //   588: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: aload 15
    //   593: getfield 499	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   596: ifnull +16 -> 612
    //   599: aload 13
    //   601: ldc_w 416
    //   604: aload 15
    //   606: getfield 499	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   609: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload 15
    //   614: getfield 496	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   617: ifnull +16 -> 633
    //   620: aload 13
    //   622: ldc_w 503
    //   625: aload 15
    //   627: getfield 496	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   630: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 13
    //   635: ldc_w 449
    //   638: iconst_1
    //   639: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   645: aload_0
    //   646: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   649: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   652: aload 13
    //   654: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   657: pop
    //   658: aload 15
    //   660: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   663: ifnull +70 -> 733
    //   666: aload 13
    //   668: invokevirtual 480	android/content/ContentValues:clear	()V
    //   671: aload 13
    //   673: ldc_w 410
    //   676: lload 6
    //   678: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   681: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   684: aload 13
    //   686: ldc_w 414
    //   689: ldc_w 445
    //   692: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload 13
    //   697: ldc_w 416
    //   700: aload 15
    //   702: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   705: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload 13
    //   710: ldc_w 449
    //   713: iconst_2
    //   714: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   720: aload_0
    //   721: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   724: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   727: aload 13
    //   729: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   732: pop
    //   733: aload 15
    //   735: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   738: ifnull +70 -> 808
    //   741: aload 13
    //   743: invokevirtual 480	android/content/ContentValues:clear	()V
    //   746: aload 13
    //   748: ldc_w 410
    //   751: lload 6
    //   753: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   756: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   759: aload 13
    //   761: ldc_w 414
    //   764: ldc_w 445
    //   767: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: aload 13
    //   772: ldc_w 416
    //   775: aload 15
    //   777: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   780: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload 13
    //   785: ldc_w 449
    //   788: iconst_3
    //   789: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   795: aload_0
    //   796: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   799: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   802: aload 13
    //   804: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   807: pop
    //   808: aload 15
    //   810: getfield 517	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   813: ifnull +70 -> 883
    //   816: aload 13
    //   818: invokevirtual 480	android/content/ContentValues:clear	()V
    //   821: aload 13
    //   823: ldc_w 410
    //   826: lload 6
    //   828: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   831: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   834: aload 13
    //   836: ldc_w 414
    //   839: ldc_w 519
    //   842: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload 13
    //   847: ldc_w 416
    //   850: aload 15
    //   852: getfield 517	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   855: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload 13
    //   860: ldc_w 449
    //   863: iconst_2
    //   864: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   870: aload_0
    //   871: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   874: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   877: aload 13
    //   879: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   882: pop
    //   883: aload 13
    //   885: invokevirtual 480	android/content/ContentValues:clear	()V
    //   888: aload 13
    //   890: ldc_w 410
    //   893: lload 6
    //   895: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   898: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   901: aload 13
    //   903: ldc_w 414
    //   906: ldc_w 521
    //   909: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: aload 13
    //   914: ldc_w 416
    //   917: aload_1
    //   918: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   921: aload 13
    //   923: ldc_w 449
    //   926: iconst_2
    //   927: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   930: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   933: aload_0
    //   934: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   937: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   940: aload 13
    //   942: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   945: pop
    //   946: iconst_0
    //   947: ireturn
    //   948: aload 15
    //   950: getfield 524	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   953: ifnull +13 -> 966
    //   956: aload 15
    //   958: getfield 524	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   961: astore 12
    //   963: goto -883 -> 80
    //   966: aload_1
    //   967: invokestatic 384	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   970: ifne +2500 -> 3470
    //   973: aload_1
    //   974: astore 12
    //   976: goto -896 -> 80
    //   979: iconst_0
    //   980: istore_2
    //   981: iconst_0
    //   982: istore 4
    //   984: iload_2
    //   985: istore_3
    //   986: aload 13
    //   988: ifnull +2494 -> 3482
    //   991: iload 4
    //   993: istore_3
    //   994: aload 13
    //   996: invokeinterface 458 1 0
    //   1001: iload_2
    //   1002: istore_3
    //   1003: goto +2479 -> 3482
    //   1006: iload_2
    //   1007: istore_3
    //   1008: aload 13
    //   1010: ifnull +2472 -> 3482
    //   1013: iload_2
    //   1014: istore_3
    //   1015: aload 13
    //   1017: invokeinterface 458 1 0
    //   1022: iload_2
    //   1023: istore_3
    //   1024: goto +2458 -> 3482
    //   1027: astore 13
    //   1029: iload_3
    //   1030: istore_2
    //   1031: iconst_1
    //   1032: istore_3
    //   1033: iload_3
    //   1034: istore 5
    //   1036: lload 6
    //   1038: lstore 8
    //   1040: iload_2
    //   1041: istore 4
    //   1043: aload 11
    //   1045: ifnull +2398 -> 3443
    //   1048: aload 11
    //   1050: invokeinterface 458 1 0
    //   1055: goto -608 -> 447
    //   1058: astore 13
    //   1060: aload 14
    //   1062: ifnull +13 -> 1075
    //   1065: iload_2
    //   1066: istore 4
    //   1068: aload 14
    //   1070: invokeinterface 458 1 0
    //   1075: iload_2
    //   1076: istore 4
    //   1078: aload 13
    //   1080: athrow
    //   1081: astore 13
    //   1083: iconst_1
    //   1084: istore_3
    //   1085: iload 4
    //   1087: istore_2
    //   1088: goto -55 -> 1033
    //   1091: iconst_0
    //   1092: istore_2
    //   1093: iconst_1
    //   1094: istore_3
    //   1095: goto -670 -> 425
    //   1098: astore 11
    //   1100: aload 13
    //   1102: astore_1
    //   1103: aload_1
    //   1104: ifnull +9 -> 1113
    //   1107: aload_1
    //   1108: invokeinterface 458 1 0
    //   1113: aload 11
    //   1115: athrow
    //   1116: iload_2
    //   1117: ifne +10 -> 1127
    //   1120: iconst_1
    //   1121: istore_3
    //   1122: iconst_0
    //   1123: istore_2
    //   1124: goto -669 -> 455
    //   1127: iconst_1
    //   1128: istore_2
    //   1129: iconst_0
    //   1130: istore_3
    //   1131: goto -676 -> 455
    //   1134: iload_2
    //   1135: iconst_1
    //   1136: if_icmpne +2163 -> 3299
    //   1139: aload 15
    //   1141: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1144: ifnull +131 -> 1275
    //   1147: aload 13
    //   1149: invokevirtual 480	android/content/ContentValues:clear	()V
    //   1152: aload 13
    //   1154: ldc_w 414
    //   1157: ldc_w 445
    //   1160: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: aload 13
    //   1165: ldc_w 416
    //   1168: aload 15
    //   1170: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1173: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: aload 13
    //   1178: ldc_w 449
    //   1181: iconst_2
    //   1182: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1188: aload_0
    //   1189: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1192: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1195: aload 13
    //   1197: new 396	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 436
    //   1207: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: lload 6
    //   1212: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1215: ldc_w 441
    //   1218: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: ldc_w 414
    //   1224: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: ldc_w 443
    //   1230: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: ldc_w 445
    //   1236: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: ldc_w 447
    //   1242: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: ldc_w 449
    //   1248: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: ldc_w 443
    //   1254: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: iconst_2
    //   1258: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1261: ldc_w 405
    //   1264: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: aconst_null
    //   1271: invokevirtual 528	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1274: pop
    //   1275: aload 15
    //   1277: getfield 496	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1280: ifnull +293 -> 1573
    //   1283: aconst_null
    //   1284: astore 11
    //   1286: aload_0
    //   1287: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1290: astore 14
    //   1292: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1295: astore 16
    //   1297: new 396	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   1304: ldc_w 436
    //   1307: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: lload 6
    //   1312: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1315: ldc_w 441
    //   1318: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: ldc_w 414
    //   1324: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: ldc_w 443
    //   1330: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: ldc_w 501
    //   1336: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: ldc_w 447
    //   1342: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: ldc_w 449
    //   1348: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: ldc_w 443
    //   1354: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: iconst_1
    //   1358: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: ldc_w 405
    //   1364: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: astore 12
    //   1372: aload 14
    //   1374: aload 16
    //   1376: iconst_5
    //   1377: anewarray 350	java/lang/String
    //   1380: dup
    //   1381: iconst_0
    //   1382: ldc_w 410
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_1
    //   1388: ldc_w 412
    //   1391: aastore
    //   1392: dup
    //   1393: iconst_2
    //   1394: ldc_w 414
    //   1397: aastore
    //   1398: dup
    //   1399: iconst_3
    //   1400: ldc_w 503
    //   1403: aastore
    //   1404: dup
    //   1405: iconst_4
    //   1406: ldc_w 449
    //   1409: aastore
    //   1410: aload 12
    //   1412: aconst_null
    //   1413: aconst_null
    //   1414: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1417: astore 12
    //   1419: aload 12
    //   1421: astore 11
    //   1423: aload 11
    //   1425: invokeinterface 455 1 0
    //   1430: ifeq +1364 -> 2794
    //   1433: aload 13
    //   1435: invokevirtual 480	android/content/ContentValues:clear	()V
    //   1438: aload 13
    //   1440: ldc_w 414
    //   1443: ldc_w 501
    //   1446: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1449: aload 13
    //   1451: ldc_w 503
    //   1454: aload 15
    //   1456: getfield 496	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1459: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1462: aload 13
    //   1464: ldc_w 449
    //   1467: iconst_1
    //   1468: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1471: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1474: aload_0
    //   1475: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1478: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1481: aload 13
    //   1483: new 396	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   1490: ldc_w 436
    //   1493: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: lload 6
    //   1498: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1501: ldc_w 441
    //   1504: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: ldc_w 414
    //   1510: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: ldc_w 443
    //   1516: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: ldc_w 501
    //   1522: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: ldc_w 447
    //   1528: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: ldc_w 449
    //   1534: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: ldc_w 443
    //   1540: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: iconst_1
    //   1544: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1547: ldc_w 405
    //   1550: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: aconst_null
    //   1557: invokevirtual 528	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1560: pop
    //   1561: aload 11
    //   1563: ifnull +10 -> 1573
    //   1566: aload 11
    //   1568: invokeinterface 458 1 0
    //   1573: aload 15
    //   1575: getfield 499	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1578: ifnull +293 -> 1871
    //   1581: aconst_null
    //   1582: astore 11
    //   1584: aload_0
    //   1585: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1588: astore 16
    //   1590: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1593: astore 14
    //   1595: new 396	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   1602: ldc_w 436
    //   1605: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: lload 6
    //   1610: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1613: ldc_w 441
    //   1616: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: ldc_w 414
    //   1622: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: ldc_w 443
    //   1628: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: ldc_w 501
    //   1634: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: ldc_w 447
    //   1640: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: ldc_w 449
    //   1646: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: ldc_w 443
    //   1652: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: iconst_1
    //   1656: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1659: ldc_w 405
    //   1662: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: astore 12
    //   1670: aload 16
    //   1672: aload 14
    //   1674: iconst_5
    //   1675: anewarray 350	java/lang/String
    //   1678: dup
    //   1679: iconst_0
    //   1680: ldc_w 410
    //   1683: aastore
    //   1684: dup
    //   1685: iconst_1
    //   1686: ldc_w 412
    //   1689: aastore
    //   1690: dup
    //   1691: iconst_2
    //   1692: ldc_w 414
    //   1695: aastore
    //   1696: dup
    //   1697: iconst_3
    //   1698: ldc_w 416
    //   1701: aastore
    //   1702: dup
    //   1703: iconst_4
    //   1704: ldc_w 449
    //   1707: aastore
    //   1708: aload 12
    //   1710: aconst_null
    //   1711: aconst_null
    //   1712: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1715: astore 12
    //   1717: aload 12
    //   1719: astore 11
    //   1721: aload 11
    //   1723: invokeinterface 455 1 0
    //   1728: ifeq +1168 -> 2896
    //   1731: aload 13
    //   1733: invokevirtual 480	android/content/ContentValues:clear	()V
    //   1736: aload 13
    //   1738: ldc_w 414
    //   1741: ldc_w 501
    //   1744: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1747: aload 13
    //   1749: ldc_w 416
    //   1752: aload 15
    //   1754: getfield 499	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1757: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1760: aload 13
    //   1762: ldc_w 449
    //   1765: iconst_1
    //   1766: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1769: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1772: aload_0
    //   1773: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1776: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1779: aload 13
    //   1781: new 396	java/lang/StringBuilder
    //   1784: dup
    //   1785: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   1788: ldc_w 436
    //   1791: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: lload 6
    //   1796: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1799: ldc_w 441
    //   1802: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: ldc_w 414
    //   1808: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: ldc_w 443
    //   1814: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: ldc_w 501
    //   1820: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: ldc_w 447
    //   1826: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: ldc_w 449
    //   1832: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: ldc_w 443
    //   1838: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: iconst_1
    //   1842: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1845: ldc_w 405
    //   1848: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1854: aconst_null
    //   1855: invokevirtual 528	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1858: pop
    //   1859: aload 11
    //   1861: ifnull +10 -> 1871
    //   1864: aload 11
    //   1866: invokeinterface 458 1 0
    //   1871: aload 15
    //   1873: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1876: ifnull +306 -> 2182
    //   1879: aconst_null
    //   1880: astore 11
    //   1882: aload_0
    //   1883: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1886: astore 16
    //   1888: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1891: astore 14
    //   1893: new 396	java/lang/StringBuilder
    //   1896: dup
    //   1897: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   1900: ldc_w 436
    //   1903: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: lload 6
    //   1908: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1911: ldc_w 441
    //   1914: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 414
    //   1920: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: ldc_w 443
    //   1926: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: ldc_w 445
    //   1932: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: ldc_w 447
    //   1938: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: ldc_w 449
    //   1944: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: ldc_w 443
    //   1950: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: iconst_3
    //   1954: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1957: ldc_w 405
    //   1960: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1966: astore 12
    //   1968: aload 16
    //   1970: aload 14
    //   1972: iconst_5
    //   1973: anewarray 350	java/lang/String
    //   1976: dup
    //   1977: iconst_0
    //   1978: ldc_w 410
    //   1981: aastore
    //   1982: dup
    //   1983: iconst_1
    //   1984: ldc_w 412
    //   1987: aastore
    //   1988: dup
    //   1989: iconst_2
    //   1990: ldc_w 414
    //   1993: aastore
    //   1994: dup
    //   1995: iconst_3
    //   1996: ldc_w 416
    //   1999: aastore
    //   2000: dup
    //   2001: iconst_4
    //   2002: ldc_w 449
    //   2005: aastore
    //   2006: aload 12
    //   2008: aconst_null
    //   2009: aconst_null
    //   2010: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2013: astore 12
    //   2015: aload 12
    //   2017: astore 11
    //   2019: aload 11
    //   2021: invokeinterface 455 1 0
    //   2026: ifeq +972 -> 2998
    //   2029: aload 13
    //   2031: invokevirtual 480	android/content/ContentValues:clear	()V
    //   2034: aload 13
    //   2036: ldc_w 410
    //   2039: lload 6
    //   2041: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2044: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2047: aload 13
    //   2049: ldc_w 414
    //   2052: ldc_w 445
    //   2055: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2058: aload 13
    //   2060: ldc_w 416
    //   2063: aload 15
    //   2065: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2068: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2071: aload 13
    //   2073: ldc_w 449
    //   2076: iconst_3
    //   2077: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2080: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2083: aload_0
    //   2084: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2087: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2090: aload 13
    //   2092: new 396	java/lang/StringBuilder
    //   2095: dup
    //   2096: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   2099: ldc_w 436
    //   2102: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: lload 6
    //   2107: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2110: ldc_w 441
    //   2113: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: ldc_w 414
    //   2119: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: ldc_w 443
    //   2125: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: ldc_w 445
    //   2131: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: ldc_w 447
    //   2137: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2140: ldc_w 449
    //   2143: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: ldc_w 443
    //   2149: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: iconst_3
    //   2153: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: ldc_w 405
    //   2159: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2165: aconst_null
    //   2166: invokevirtual 528	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2169: pop
    //   2170: aload 11
    //   2172: ifnull +10 -> 2182
    //   2175: aload 11
    //   2177: invokeinterface 458 1 0
    //   2182: aload 15
    //   2184: getfield 517	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2187: ifnull +306 -> 2493
    //   2190: aconst_null
    //   2191: astore 11
    //   2193: aload_0
    //   2194: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2197: astore 12
    //   2199: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2202: astore 14
    //   2204: new 396	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   2211: ldc_w 436
    //   2214: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: lload 6
    //   2219: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2222: ldc_w 441
    //   2225: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: ldc_w 414
    //   2231: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: ldc_w 443
    //   2237: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: ldc_w 519
    //   2243: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: ldc_w 447
    //   2249: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: ldc_w 449
    //   2255: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: ldc_w 443
    //   2261: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: iconst_2
    //   2265: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2268: ldc_w 405
    //   2271: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2277: astore 16
    //   2279: aload 12
    //   2281: aload 14
    //   2283: iconst_5
    //   2284: anewarray 350	java/lang/String
    //   2287: dup
    //   2288: iconst_0
    //   2289: ldc_w 410
    //   2292: aastore
    //   2293: dup
    //   2294: iconst_1
    //   2295: ldc_w 412
    //   2298: aastore
    //   2299: dup
    //   2300: iconst_2
    //   2301: ldc_w 414
    //   2304: aastore
    //   2305: dup
    //   2306: iconst_3
    //   2307: ldc_w 416
    //   2310: aastore
    //   2311: dup
    //   2312: iconst_4
    //   2313: ldc_w 449
    //   2316: aastore
    //   2317: aload 16
    //   2319: aconst_null
    //   2320: aconst_null
    //   2321: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2324: astore 12
    //   2326: aload 12
    //   2328: astore 11
    //   2330: aload 11
    //   2332: invokeinterface 455 1 0
    //   2337: ifeq +763 -> 3100
    //   2340: aload 13
    //   2342: invokevirtual 480	android/content/ContentValues:clear	()V
    //   2345: aload 13
    //   2347: ldc_w 410
    //   2350: lload 6
    //   2352: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2355: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2358: aload 13
    //   2360: ldc_w 414
    //   2363: ldc_w 519
    //   2366: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2369: aload 13
    //   2371: ldc_w 416
    //   2374: aload 15
    //   2376: getfield 517	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2379: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2382: aload 13
    //   2384: ldc_w 449
    //   2387: iconst_2
    //   2388: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2391: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2394: aload_0
    //   2395: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2398: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2401: aload 13
    //   2403: new 396	java/lang/StringBuilder
    //   2406: dup
    //   2407: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   2410: ldc_w 436
    //   2413: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2416: lload 6
    //   2418: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2421: ldc_w 441
    //   2424: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2427: ldc_w 414
    //   2430: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: ldc_w 443
    //   2436: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: ldc_w 519
    //   2442: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: ldc_w 447
    //   2448: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2451: ldc_w 449
    //   2454: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: ldc_w 443
    //   2460: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2463: iconst_2
    //   2464: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2467: ldc_w 405
    //   2470: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2476: aconst_null
    //   2477: invokevirtual 528	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2480: pop
    //   2481: aload 11
    //   2483: ifnull +10 -> 2493
    //   2486: aload 11
    //   2488: invokeinterface 458 1 0
    //   2493: aconst_null
    //   2494: astore 11
    //   2496: aload_0
    //   2497: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2500: astore 15
    //   2502: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2505: astore 12
    //   2507: new 396	java/lang/StringBuilder
    //   2510: dup
    //   2511: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   2514: ldc_w 436
    //   2517: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: lload 6
    //   2522: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2525: ldc_w 441
    //   2528: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: ldc_w 414
    //   2534: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: ldc_w 443
    //   2540: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: ldc_w 521
    //   2546: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: ldc_w 447
    //   2552: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: ldc_w 449
    //   2558: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: ldc_w 443
    //   2564: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: iconst_2
    //   2568: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2571: ldc_w 405
    //   2574: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2577: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2580: astore 14
    //   2582: aload 15
    //   2584: aload 12
    //   2586: iconst_5
    //   2587: anewarray 350	java/lang/String
    //   2590: dup
    //   2591: iconst_0
    //   2592: ldc_w 410
    //   2595: aastore
    //   2596: dup
    //   2597: iconst_1
    //   2598: ldc_w 412
    //   2601: aastore
    //   2602: dup
    //   2603: iconst_2
    //   2604: ldc_w 414
    //   2607: aastore
    //   2608: dup
    //   2609: iconst_3
    //   2610: ldc_w 416
    //   2613: aastore
    //   2614: dup
    //   2615: iconst_4
    //   2616: ldc_w 449
    //   2619: aastore
    //   2620: aload 14
    //   2622: aconst_null
    //   2623: aconst_null
    //   2624: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2627: astore 12
    //   2629: aload 12
    //   2631: astore 11
    //   2633: aload 11
    //   2635: invokeinterface 455 1 0
    //   2640: ifeq +562 -> 3202
    //   2643: aload 13
    //   2645: invokevirtual 480	android/content/ContentValues:clear	()V
    //   2648: aload 13
    //   2650: ldc_w 410
    //   2653: lload 6
    //   2655: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2658: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2661: aload 13
    //   2663: ldc_w 414
    //   2666: ldc_w 521
    //   2669: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2672: aload 13
    //   2674: ldc_w 416
    //   2677: aload_1
    //   2678: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2681: aload 13
    //   2683: ldc_w 449
    //   2686: iconst_2
    //   2687: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2690: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2693: aload_0
    //   2694: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2697: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2700: aload 13
    //   2702: new 396	java/lang/StringBuilder
    //   2705: dup
    //   2706: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   2709: ldc_w 436
    //   2712: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2715: lload 6
    //   2717: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2720: ldc_w 441
    //   2723: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: ldc_w 414
    //   2729: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2732: ldc_w 443
    //   2735: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2738: ldc_w 521
    //   2741: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: ldc_w 447
    //   2747: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: ldc_w 449
    //   2753: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: ldc_w 443
    //   2759: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2762: iconst_2
    //   2763: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2766: ldc_w 405
    //   2769: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2772: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2775: aconst_null
    //   2776: invokevirtual 528	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2779: pop
    //   2780: aload 11
    //   2782: ifnull +10 -> 2792
    //   2785: aload 11
    //   2787: invokeinterface 458 1 0
    //   2792: iconst_1
    //   2793: ireturn
    //   2794: aload 13
    //   2796: invokevirtual 480	android/content/ContentValues:clear	()V
    //   2799: aload 13
    //   2801: ldc_w 410
    //   2804: lload 6
    //   2806: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2809: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2812: aload 13
    //   2814: ldc_w 414
    //   2817: ldc_w 501
    //   2820: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2823: aload 13
    //   2825: ldc_w 503
    //   2828: aload 15
    //   2830: getfield 496	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2833: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2836: aload 13
    //   2838: ldc_w 449
    //   2841: iconst_1
    //   2842: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2845: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2848: aload_0
    //   2849: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2852: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2855: aload 13
    //   2857: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2860: pop
    //   2861: goto -1300 -> 1561
    //   2864: astore 12
    //   2866: aload 11
    //   2868: ifnull -1295 -> 1573
    //   2871: aload 11
    //   2873: invokeinterface 458 1 0
    //   2878: goto -1305 -> 1573
    //   2881: astore_1
    //   2882: aload 11
    //   2884: ifnull +10 -> 2894
    //   2887: aload 11
    //   2889: invokeinterface 458 1 0
    //   2894: aload_1
    //   2895: athrow
    //   2896: aload 13
    //   2898: invokevirtual 480	android/content/ContentValues:clear	()V
    //   2901: aload 13
    //   2903: ldc_w 410
    //   2906: lload 6
    //   2908: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2911: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2914: aload 13
    //   2916: ldc_w 414
    //   2919: ldc_w 501
    //   2922: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2925: aload 13
    //   2927: ldc_w 416
    //   2930: aload 15
    //   2932: getfield 499	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2935: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2938: aload 13
    //   2940: ldc_w 449
    //   2943: iconst_1
    //   2944: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2947: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2950: aload_0
    //   2951: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2954: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2957: aload 13
    //   2959: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2962: pop
    //   2963: goto -1104 -> 1859
    //   2966: astore 12
    //   2968: aload 11
    //   2970: ifnull -1099 -> 1871
    //   2973: aload 11
    //   2975: invokeinterface 458 1 0
    //   2980: goto -1109 -> 1871
    //   2983: astore_1
    //   2984: aload 11
    //   2986: ifnull +10 -> 2996
    //   2989: aload 11
    //   2991: invokeinterface 458 1 0
    //   2996: aload_1
    //   2997: athrow
    //   2998: aload 13
    //   3000: invokevirtual 480	android/content/ContentValues:clear	()V
    //   3003: aload 13
    //   3005: ldc_w 410
    //   3008: lload 6
    //   3010: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3013: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3016: aload 13
    //   3018: ldc_w 414
    //   3021: ldc_w 445
    //   3024: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3027: aload 13
    //   3029: ldc_w 416
    //   3032: aload 15
    //   3034: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   3037: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3040: aload 13
    //   3042: ldc_w 449
    //   3045: iconst_3
    //   3046: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3049: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3052: aload_0
    //   3053: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3056: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3059: aload 13
    //   3061: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3064: pop
    //   3065: goto -895 -> 2170
    //   3068: astore 12
    //   3070: aload 11
    //   3072: ifnull -890 -> 2182
    //   3075: aload 11
    //   3077: invokeinterface 458 1 0
    //   3082: goto -900 -> 2182
    //   3085: astore_1
    //   3086: aload 11
    //   3088: ifnull +10 -> 3098
    //   3091: aload 11
    //   3093: invokeinterface 458 1 0
    //   3098: aload_1
    //   3099: athrow
    //   3100: aload 13
    //   3102: invokevirtual 480	android/content/ContentValues:clear	()V
    //   3105: aload 13
    //   3107: ldc_w 410
    //   3110: lload 6
    //   3112: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3115: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3118: aload 13
    //   3120: ldc_w 414
    //   3123: ldc_w 519
    //   3126: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3129: aload 13
    //   3131: ldc_w 416
    //   3134: aload 15
    //   3136: getfield 517	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3139: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3142: aload 13
    //   3144: ldc_w 449
    //   3147: iconst_2
    //   3148: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3151: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3154: aload_0
    //   3155: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3158: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3161: aload 13
    //   3163: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3166: pop
    //   3167: goto -686 -> 2481
    //   3170: astore 12
    //   3172: aload 11
    //   3174: ifnull -681 -> 2493
    //   3177: aload 11
    //   3179: invokeinterface 458 1 0
    //   3184: goto -691 -> 2493
    //   3187: astore_1
    //   3188: aload 11
    //   3190: ifnull +10 -> 3200
    //   3193: aload 11
    //   3195: invokeinterface 458 1 0
    //   3200: aload_1
    //   3201: athrow
    //   3202: aload 13
    //   3204: invokevirtual 480	android/content/ContentValues:clear	()V
    //   3207: aload 13
    //   3209: ldc_w 410
    //   3212: lload 6
    //   3214: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3217: invokevirtual 488	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3220: aload 13
    //   3222: ldc_w 414
    //   3225: ldc_w 521
    //   3228: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3231: aload 13
    //   3233: ldc_w 416
    //   3236: aload_1
    //   3237: invokevirtual 493	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3240: aload 13
    //   3242: ldc_w 449
    //   3245: iconst_2
    //   3246: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3249: invokevirtual 511	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3252: aload_0
    //   3253: invokevirtual 388	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3256: getstatic 394	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3259: aload 13
    //   3261: invokevirtual 471	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3264: pop
    //   3265: goto -485 -> 2780
    //   3268: astore_1
    //   3269: aload 11
    //   3271: ifnull -479 -> 2792
    //   3274: aload 11
    //   3276: invokeinterface 458 1 0
    //   3281: goto -489 -> 2792
    //   3284: astore_1
    //   3285: aload 11
    //   3287: ifnull +10 -> 3297
    //   3290: aload 11
    //   3292: invokeinterface 458 1 0
    //   3297: aload_1
    //   3298: athrow
    //   3299: iconst_m1
    //   3300: ireturn
    //   3301: astore_1
    //   3302: goto -17 -> 3285
    //   3305: astore_1
    //   3306: aconst_null
    //   3307: astore 11
    //   3309: goto -40 -> 3269
    //   3312: astore_1
    //   3313: goto -125 -> 3188
    //   3316: astore 11
    //   3318: aconst_null
    //   3319: astore 11
    //   3321: goto -149 -> 3172
    //   3324: astore_1
    //   3325: goto -239 -> 3086
    //   3328: astore 11
    //   3330: aconst_null
    //   3331: astore 11
    //   3333: goto -263 -> 3070
    //   3336: astore_1
    //   3337: goto -353 -> 2984
    //   3340: astore 11
    //   3342: aconst_null
    //   3343: astore 11
    //   3345: goto -377 -> 2968
    //   3348: astore_1
    //   3349: goto -467 -> 2882
    //   3352: astore 11
    //   3354: aconst_null
    //   3355: astore 11
    //   3357: goto -491 -> 2866
    //   3360: astore 12
    //   3362: aload 11
    //   3364: astore_1
    //   3365: aload 12
    //   3367: astore 11
    //   3369: goto -2266 -> 1103
    //   3372: astore 11
    //   3374: aconst_null
    //   3375: astore 11
    //   3377: iconst_0
    //   3378: istore_3
    //   3379: lconst_0
    //   3380: lstore 6
    //   3382: goto -2349 -> 1033
    //   3385: astore 13
    //   3387: lload 8
    //   3389: lstore 6
    //   3391: goto -2358 -> 1033
    //   3394: astore 13
    //   3396: iconst_1
    //   3397: istore_3
    //   3398: lload 8
    //   3400: lstore 6
    //   3402: goto -2369 -> 1033
    //   3405: astore 16
    //   3407: aload 13
    //   3409: astore 14
    //   3411: aload 16
    //   3413: astore 13
    //   3415: goto -2355 -> 1060
    //   3418: astore 16
    //   3420: aload 13
    //   3422: astore 14
    //   3424: iconst_1
    //   3425: istore_2
    //   3426: aload 16
    //   3428: astore 13
    //   3430: goto -2370 -> 1060
    //   3433: astore 14
    //   3435: goto -2429 -> 1006
    //   3438: astore 14
    //   3440: goto -2434 -> 1006
    //   3443: lload 8
    //   3445: lstore 6
    //   3447: iload 5
    //   3449: istore_3
    //   3450: iload 4
    //   3452: istore_2
    //   3453: goto -3006 -> 447
    //   3456: iconst_1
    //   3457: istore_2
    //   3458: iconst_1
    //   3459: istore_3
    //   3460: goto -3035 -> 425
    //   3463: lload 8
    //   3465: lstore 6
    //   3467: goto -3042 -> 425
    //   3470: aconst_null
    //   3471: astore 12
    //   3473: goto -3393 -> 80
    //   3476: aconst_null
    //   3477: astore 15
    //   3479: goto -3432 -> 47
    //   3482: iload_3
    //   3483: istore_2
    //   3484: iconst_1
    //   3485: istore_3
    //   3486: lload 6
    //   3488: lstore 8
    //   3490: goto -3313 -> 177
    //   3493: astore 13
    //   3495: aconst_null
    //   3496: astore 13
    //   3498: goto -2492 -> 1006
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3501	0	this	ProfileCardMoreActivity
    //   0	3501	1	paramString	String
    //   81	3403	2	k	int
    //   170	3316	3	m	int
    //   83	3368	4	n	int
    //   426	3022	5	i1	int
    //   204	3283	6	l1	long
    //   172	3317	8	l2	long
    //   189	209	10	bool	boolean
    //   26	1023	11	localObject1	Object
    //   1098	16	11	localObject2	Object
    //   1284	2024	11	localObject3	Object
    //   3316	1	11	localException1	Exception
    //   3319	1	11	localObject4	Object
    //   3328	1	11	localException2	Exception
    //   3331	1	11	localObject5	Object
    //   3340	1	11	localException3	Exception
    //   3343	1	11	localObject6	Object
    //   3352	1	11	localException4	Exception
    //   3355	13	11	localObject7	Object
    //   3372	1	11	localException5	Exception
    //   3375	1	11	localObject8	Object
    //   78	2552	12	localObject9	Object
    //   2864	1	12	localException6	Exception
    //   2966	1	12	localException7	Exception
    //   3068	1	12	localException8	Exception
    //   3170	1	12	localException9	Exception
    //   3360	6	12	localObject10	Object
    //   3471	1	12	localObject11	Object
    //   86	930	13	localObject12	Object
    //   1027	1	13	localException10	Exception
    //   1058	21	13	localObject13	Object
    //   1081	2179	13	localException11	Exception
    //   3385	1	13	localException12	Exception
    //   3394	14	13	localException13	Exception
    //   3413	16	13	localObject14	Object
    //   3493	1	13	localException14	Exception
    //   3496	1	13	localObject15	Object
    //   97	3326	14	localObject16	Object
    //   3433	1	14	localException15	Exception
    //   3438	1	14	localException16	Exception
    //   45	3433	15	localObject17	Object
    //   92	2226	16	localObject18	Object
    //   3405	7	16	localObject19	Object
    //   3418	9	16	localObject20	Object
    //   228	109	17	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   417	425	1027	java/lang/Exception
    //   994	1001	1027	java/lang/Exception
    //   1015	1022	1027	java/lang/Exception
    //   224	383	1058	finally
    //   209	216	1081	java/lang/Exception
    //   1068	1075	1081	java/lang/Exception
    //   1078	1081	1081	java/lang/Exception
    //   88	169	1098	finally
    //   1423	1561	2864	java/lang/Exception
    //   2794	2861	2864	java/lang/Exception
    //   1286	1419	2881	finally
    //   1721	1859	2966	java/lang/Exception
    //   2896	2963	2966	java/lang/Exception
    //   1584	1717	2983	finally
    //   2019	2170	3068	java/lang/Exception
    //   2998	3065	3068	java/lang/Exception
    //   1882	2015	3085	finally
    //   2330	2481	3170	java/lang/Exception
    //   3100	3167	3170	java/lang/Exception
    //   2193	2326	3187	finally
    //   2633	2780	3268	java/lang/Exception
    //   3202	3265	3268	java/lang/Exception
    //   2496	2629	3284	finally
    //   2633	2780	3301	finally
    //   3202	3265	3301	finally
    //   2496	2629	3305	java/lang/Exception
    //   2330	2481	3312	finally
    //   3100	3167	3312	finally
    //   2193	2326	3316	java/lang/Exception
    //   2019	2170	3324	finally
    //   2998	3065	3324	finally
    //   1882	2015	3328	java/lang/Exception
    //   1721	1859	3336	finally
    //   2896	2963	3336	finally
    //   1584	1717	3340	java/lang/Exception
    //   1423	1561	3348	finally
    //   2794	2861	3348	finally
    //   1286	1419	3352	java/lang/Exception
    //   182	191	3360	finally
    //   196	206	3360	finally
    //   209	216	3360	finally
    //   417	425	3360	finally
    //   994	1001	3360	finally
    //   1015	1022	3360	finally
    //   1068	1075	3360	finally
    //   1078	1081	3360	finally
    //   88	169	3372	java/lang/Exception
    //   182	191	3385	java/lang/Exception
    //   196	206	3394	java/lang/Exception
    //   388	397	3405	finally
    //   406	413	3418	finally
    //   388	397	3433	java/lang/Exception
    //   406	413	3438	java/lang/Exception
    //   224	383	3493	java/lang/Exception
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public String a()
  {
    Object localObject = null;
    try
    {
      String str = bbcz.e(this.app, this.jdField_a_of_type_JavaLangString);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  void a()
  {
    setContentViewB(2131560975);
    Object localObject1;
    label97:
    int n;
    label129:
    int m;
    int k;
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString))
    {
      setTitle(ajya.a(2131708458));
      if (this.mLeftBackText != null)
      {
        this.mLeftBackText.setText("");
        this.mLeftBackText.setContentDescription(ajya.a(2131708468));
      }
      enableRightHighlight(false);
      localObject1 = findViewById(2131364996);
      if (this.jdField_a_of_type_ArrayOfInt[13] != 1) {
        break label180;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131376544);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label190;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      n = -1;
      m = -1;
      k = 0;
      label135:
      if (k > 3) {
        break label200;
      }
      if (this.jdField_a_of_type_ArrayOfInt[k] != 1) {
        break label1313;
      }
      if (n >= 0) {
        break label1310;
      }
      n = k;
      label156:
      if (m >= k) {
        break label1307;
      }
      m = k;
    }
    label517:
    label911:
    label1298:
    label1301:
    label1304:
    label1307:
    label1310:
    label1313:
    for (;;)
    {
      k += 1;
      break label135;
      setTitle(2131695475);
      break;
      label180:
      ((View)localObject1).setVisibility(8);
      break label97;
      label190:
      ((View)localObject1).setVisibility(8);
      break label129;
      label200:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131368377));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375104));
      a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout, n, m);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368322));
      a(1, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368392));
      a(2, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368314));
      a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368364));
      a(4, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
      if (this.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(ajya.a(2131708491));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368317));
        a(15, this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368326));
        a(16, this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
        a(null);
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368361));
        a(17, this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368363));
        a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 5, 5);
        n = -1;
        m = -1;
        k = 6;
        label495:
        if (k > 12) {
          break label557;
        }
        if (this.jdField_a_of_type_ArrayOfInt[k] != 1) {
          break label1304;
        }
        if (n >= 0) {
          break label1301;
        }
        n = k;
        if (m >= k) {
          break label1298;
        }
        m = k;
      }
      for (;;)
      {
        k += 1;
        break label495;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(ajya.a(2131708480));
        break;
        label557:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131376359));
        a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368332));
        a(8, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
        if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          axqy.b(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131375920));
        a(10, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131375923));
        a(9, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370499));
        a(11, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131375926));
        a(12, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        ajxl localajxl;
        label970:
        boolean bool;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localajxl = (ajxl)this.app.getManager(51);
          if (localajxl == null)
          {
            localObject1 = null;
            Object localObject2;
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localObject2 = localajxl.a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!bbbr.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
                this.jdField_c_of_type_JavaLangString = ((Groups)localObject2).group_name;
              }
              if (((Friends)localObject1).gathtertype == 1)
              {
                this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
                this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
                this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                break label1237;
              }
              localObject1 = "";
              ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 0)
            {
              a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.post(new ProfileCardMoreActivity.2(this));
            }
            if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if (localajxl != null) {
                break label1246;
              }
              localObject1 = null;
              localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if ((localObject1 == null) || (!((Card)localObject1).babyQSwitch)) {
                break label1259;
              }
              bool = true;
              label992:
              ((FormSwitchItem)localObject2).setChecked(bool);
              ((ajti)this.app.a(2)).w();
            }
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if ((localajxl == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
                break label1265;
              }
              this.jdField_a_of_type_Boolean = localajxl.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              label1057:
              d();
            }
            if ((localajxl != null) && (localajxl.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
              l();
            }
          }
        }
        for (;;)
        {
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719295));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717485));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131695410));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131708441));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690577));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131708451));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695499));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          }
          return;
          localObject1 = localajxl.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break;
          label1237:
          localObject1 = this.jdField_c_of_type_JavaLangString;
          break label911;
          label1246:
          localObject1 = localajxl.c(ajsd.aC);
          break label970;
          label1259:
          bool = false;
          break label992;
          label1265:
          this.jdField_a_of_type_Boolean = false;
          break label1057;
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
          {
            this.jdField_a_of_type_Boolean = a();
            d();
          }
        }
        continue;
        break label517;
      }
      continue;
      break label156;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bcql.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a(getTitleBarHeight()).show();
  }
  
  void a(int paramInt1, RelativeLayout paramRelativeLayout, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramRelativeLayout == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramRelativeLayout.setVisibility(0);
      paramRelativeLayout.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839169));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839185));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839176));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839179));
      return;
    }
    paramRelativeLayout.setVisibility(8);
  }
  
  void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSimpleItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSimpleItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  void a(int paramInt1, FormSwitchItem paramFormSwitchItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSwitchItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSwitchItem.setVisibility(0);
      paramFormSwitchItem.setOnCheckedChangeListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSwitchItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSwitchItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSwitchItem.setBgType(3);
        return;
      }
      paramFormSwitchItem.setBgType(2);
      return;
    }
    paramFormSwitchItem.setVisibility(8);
  }
  
  void a(TextView paramTextView, Drawable paramDrawable)
  {
    if (paramTextView != null)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
      }
    }
    else {
      return;
    }
    paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    int m = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (ajxl)this.app.getManager(51);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((Friends)localObject2).remark != null)
        {
          localObject1 = str;
          if (((Friends)localObject2).isRemark == 1) {
            localObject1 = ((Friends)localObject2).remark;
          }
        }
      }
      if (TextUtils.isEmpty(paramBusinessCard.picUrl)) {
        break label242;
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130844927));
    }
    int k;
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (!TextUtils.isEmpty(paramBusinessCard.company))
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append(paramBusinessCard.company);
      }
      if ((paramBusinessCard.mobilesNum == null) || (paramBusinessCard.mobilesNum.isEmpty())) {
        break label254;
      }
      k = 0;
      while (k < paramBusinessCard.mobilesNum.size())
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append((String)paramBusinessCard.mobilesNum.get(k));
        k += 1;
      }
      localObject2 = ((ajxl)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label242:
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    label254:
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      k = m;
      if (((StringBuilder)localObject2).length() != 0)
      {
        ((StringBuilder)localObject2).append("，");
        k = m;
      }
      while (k < paramBusinessCard.descs.size())
      {
        ((StringBuilder)localObject2).append((String)paramBusinessCard.descs.get(k));
        k += 1;
      }
    }
    this.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    b((String)localObject1);
  }
  
  void a(Card paramCard)
  {
    if (this.jdField_a_of_type_Abgw != null) {
      this.jdField_a_of_type_Abgw.a(paramCard);
    }
  }
  
  void a(String paramString)
  {
    bfpc localbfpc = bfpc.a(this);
    if (bbbr.b(paramString)) {
      localbfpc.a(2131690458);
    }
    for (;;)
    {
      localbfpc.a(2131691515, 3);
      localbfpc.c(2131690596);
      localbfpc.a(new absg(this, paramString, localbfpc));
      localbfpc.show();
      return;
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        localbfpc.a(2131690460);
      } else {
        localbfpc.a(2131690459);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((ajxl)this.app.getManager(51)).b(paramString1);
    int k = 17;
    if (localObject1 != null) {
      k = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new axum(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + k;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + k;
    String str2 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + k;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((axum)localObject2).c(14).a(2).a(1).a(ajya.a(2131708443) + paramString2).a("plugin", str2, "", (String)localObject3, str1).d(getResources().getString(2131718649)).a();
    localObject3 = new axxi();
    ((axuq)localObject3).b(1);
    ((axuq)localObject3).a(new axws((String)localObject1));
    ((axuq)localObject3).a(new StructMsgItemTitle(paramString2));
    ((axuq)localObject3).a(new axzj(ajya.a(2131708440) + bduf.b(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a(ajya.a(2131708488)));
    ((AbsShareMsg)localObject2).addItem((axup)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    aqbe.a(this, paramString2, 21);
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (bbfj.d(BaseApplication.getContext()))
    {
      aset localaset = (aset)this.app.getManager(16);
      if (localaset != null) {}
      for (;;)
      {
        int k;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          k = bbac.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localaset.b(k, (List)localObject);
            k = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            m = k;
            if (m == 0) {
              break label314;
            }
            if (paramBoolean) {
              break label309;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_Int |= 0x2;
            e();
            return;
            localaset.a(k, (List)localObject);
            continue;
            k = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int m = k;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          m = k;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              m = 1;
              break;
              this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label309:
            paramBoolean = false;
          }
        }
      }
      label314:
      if (paramBoolean) {
        a(2131719529, 1);
      }
      for (;;)
      {
        d();
        return;
        a(2131719531, 1);
      }
    }
    a(2131692321, 1);
    d();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    f();
    if ((this.jdField_a_of_type_Int & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label112;
      }
      if (paramBoolean2) {
        a(2131719530, 2);
      }
    }
    else
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label144;
      }
      ajxl localajxl = (ajxl)this.app.getManager(51);
      if ((localajxl == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label136;
      }
      this.jdField_a_of_type_Boolean = localajxl.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      d();
      return;
      a(2131719543, 2);
      break;
      label112:
      if (paramBoolean2)
      {
        a(2131719529, 1);
        break;
      }
      a(2131719531, 1);
      break;
      label136:
      this.jdField_a_of_type_Boolean = false;
      continue;
      label144:
      this.jdField_a_of_type_Boolean = a();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      c(paramArrayOfByte);
    }
  }
  
  boolean a()
  {
    aset localaset = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localaset = (aset)this.app.getManager(16);
      if (localaset == null) {
        break label162;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localaset.a((String)localObject);
      localObject = (ajxl)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = localaset; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((ajxl)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = a();
      }
    }
    label162:
    return false;
  }
  
  void b()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[18];
    int k = 0;
    while (k < 18)
    {
      this.jdField_a_of_type_ArrayOfInt[k] = 0;
      k += 1;
    }
    if (this.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[15] = 1;
      this.jdField_a_of_type_ArrayOfInt[16] = 1;
      this.jdField_a_of_type_ArrayOfInt[17] = 1;
    }
    for (;;)
    {
      if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[4] = 0;
      }
      return;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        if (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ArrayOfInt[2] = 1;
          this.jdField_a_of_type_ArrayOfInt[11] = 1;
          this.jdField_a_of_type_ArrayOfInt[13] = 1;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfInt[0] = 1;
          if ((myv.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (bduf.b(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
          {
            k = 1;
            label197:
            if (k != 0)
            {
              if (!((bduf)this.app.getManager(165)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
                break label337;
              }
              this.jdField_a_of_type_ArrayOfInt[3] = 0;
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfInt[4] = 1;
            if (k == 0)
            {
              this.jdField_a_of_type_ArrayOfInt[5] = 1;
              this.jdField_a_of_type_ArrayOfInt[10] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[6] = 1;
            this.jdField_a_of_type_ArrayOfInt[7] = 1;
            if (asyg.a(this.app.c())) {
              this.jdField_a_of_type_ArrayOfInt[8] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[9] = 1;
            this.jdField_a_of_type_ArrayOfInt[12] = 1;
            this.jdField_a_of_type_ArrayOfInt[13] = 1;
            this.jdField_a_of_type_ArrayOfInt[14] = 1;
            break;
            k = 0;
            break label197;
            label337:
            this.jdField_a_of_type_ArrayOfInt[3] = 1;
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 78)
      {
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 95)
      {
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    bcql.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
      for (paramString = "" + this.jdField_f_of_type_JavaLangString;; paramString = this.jdField_b_of_type_JavaLangString + "，" + this.jdField_f_of_type_JavaLangString)
      {
        localTextView.setText(paramString);
        if (this.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_b_of_type_JavaLangString);
        setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
        return;
      }
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_b_of_type_JavaLangString)
    {
      localTextView.setText(paramString);
      break;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      c(paramArrayOfByte);
    }
  }
  
  void c()
  {
    Object localObject = (ajxl)this.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ajxl)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  void c(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(bbax.a(this, "bc_remark_first"))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 8)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365425));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = actj.a(10.0F, getResources()))
    {
      int k = paramInt2;
      if (paramInt2 < 0) {
        k = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, k, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      bbax.a(this, "bc_remark_first", "false");
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Abgw != null) {
      this.jdField_a_of_type_Abgw.a(paramArrayOfByte);
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      a(null);
      return;
    }
    runOnUiThread(new ProfileCardMoreActivity.4(this));
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    while ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt2 == -1) {}
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("result");
        bool = paramIntent.getBooleanExtra("hasChange", false);
      }
      break;
    }
    for (paramIntent = (Intent)localObject;; paramIntent = (Intent)localObject)
    {
      if (paramIntent == null) {
        paramIntent = "";
      }
      for (;;)
      {
        if (bbfj.d(BaseApplication.getContext()))
        {
          if ((!bool) && (paramIntent.equals(this.jdField_e_of_type_JavaLangString))) {
            break;
          }
          if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
          {
            localObject = (FriendListHandler)this.app.a(1);
            if (localObject != null)
            {
              ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
              this.jdField_a_of_type_Int |= 0x1;
              b(paramIntent);
              paramIntent = new bhpg();
              paramIntent.jdField_a_of_type_Int = 5;
              bhpf.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a(paramIntent);
              return;
            }
            a(2131693525, 1);
            return;
          }
          a(2131693506, 0);
          return;
        }
        a(2131694671, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131720034));
        localObject = actj.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
        if (this.jdField_a_of_type_Abgw == null) {
          break;
        }
        this.jdField_a_of_type_Abgw.b(paramInt2, paramIntent);
        return;
        if (paramIntent == null) {
          break;
        }
        a(paramInt2, paramIntent);
        return;
      }
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("from");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_nick_name");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      super.finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, String.format("check params [%s, %s, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle }));
    }
    try
    {
      b();
      a();
      this.jdField_a_of_type_Abgw = new abgw(this, this);
      this.jdField_a_of_type_Abgw.jdField_a_of_type_Int = getIntent().getIntExtra("coverTimeStamp", 0);
      this.jdField_a_of_type_Abgw.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("coverUrl");
      this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(this.app.c(), 0);
      }
      this.jdField_a_of_type_Amdj = ((amdj)this.app.getManager(112));
      addObserver(this.jdField_a_of_type_Akat);
      addObserver(this.jdField_a_of_type_Akgh);
      addObserver(this.jdField_a_of_type_Ajto);
      addObserver(this.jdField_a_of_type_Ajxj);
      addObserver(this.jdField_a_of_type_Aqkn);
      this.app.registObserver(this.jdField_a_of_type_Amdk);
      this.app.setHandler(ProfileCardMoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      if ((this.jdField_d_of_type_JavaLangString == null) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
      }
      aijy.a(this.app);
      return true;
    }
    catch (NoSuchFieldError paramBundle)
    {
      for (;;)
      {
        super.finish();
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Abgw != null)
    {
      this.jdField_a_of_type_Abgw.a();
      this.jdField_a_of_type_Abgw = null;
    }
    f();
    removeObserver(this.jdField_a_of_type_Akat);
    removeObserver(this.jdField_a_of_type_Akgh);
    removeObserver(this.jdField_a_of_type_Ajto);
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Aqkn);
    this.app.unRegistObserver(this.jdField_a_of_type_Amdk);
    this.app.removeHandler(ProfileCardMoreActivity.class);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Abgw != null)) {
      this.jdField_a_of_type_Abgw.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((ajxl)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label67;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131719156));
    }
    for (;;)
    {
      j();
      return;
      label67:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131719157));
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
      this.jdField_a_of_type_Bcqf.c(2131719292);
    }
    this.jdField_a_of_type_Bcqf.show();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.cancel();
      this.jdField_a_of_type_Bcqf = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (b()) {
      localIntent.putExtra("param_switches_changed", true);
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    if ((this.jdField_a_of_type_Abgw != null) && (this.jdField_a_of_type_Abgw.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Abgw.jdField_a_of_type_ArrayOfByte);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  public void g()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getFileThreadHandler().post(new ProfileCardMoreActivity.13(this));
    }
  }
  
  protected void h()
  {
    Object localObject1 = (ajxl)this.app.getManager(51);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label148;
      }
    }
    label143:
    label148:
    for (localObject1 = ((Card)localObject1).strReMark;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label143;
          }
        }
      }
      for (Object localObject2 = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;; localObject2 = null)
      {
        this.jdField_d_of_type_JavaLangString = ((String)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.i("IphoneTitleBarActivity", 4, "initRemark, " + this.jdField_d_of_type_JavaLangString);
        }
        return;
        localObject1 = ((ajxl)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  public void i()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      String str2;
      Object localObject1;
      int k;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        str2 = "1";
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle.containsKey("chatuin"))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle.containsKey("chattype")) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 96) {
          break label295;
        }
        k = 20005;
      }
      label295:
      label482:
      for (;;)
      {
        label119:
        if ((k == 20005) || (k == 20015)) {
          xkn.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, xkn.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, xkn.b(2)), str2, null, this.app.getCurrentAccountUin(), k, null, (Bundle)localObject1);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), Integer.valueOf(k), str2, str1, localObject1 }));
          }
          axqy.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          str2 = "0";
          break;
          int m;
          if (ProfileActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            m = 20008;
            k = m;
            if (localObject1 != null) {
              break label482;
            }
            localObject1 = xkn.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, 1);
            k = m;
            break label119;
          }
          if (ProfileActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            m = 20013;
            k = m;
            if (localObject1 != null) {
              break label482;
            }
            localObject1 = xkn.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString, 3000);
            k = m;
            break label119;
          }
          if (localObject1 != null)
          {
            if (((Bundle)localObject1).containsKey("chattype"))
            {
              k = xkn.a(((Bundle)localObject1).getInt("chattype"));
              break label119;
            }
            if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              k = 21000;
              break label119;
            }
            k = 20002;
            break label119;
          }
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            k = 21001;
            break label119;
          }
          k = 20001;
          break label119;
          xkn.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, null, str2, str1, this.app.getAccount(), k, null, (Bundle)localObject1);
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    int k = 1;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.app;
      if (paramBoolean)
      {
        k = 1;
        axqy.b(paramCompoundButton, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, k, "0", "0", "", "");
        if (this.jdField_a_of_type_Boolean != paramBoolean) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      return;
      k = 2;
      break;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          b(paramBoolean);
          return;
        }
      }
      if (!paramBoolean) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        a(paramBoolean);
        return;
      }
      if (paramCompoundButton == this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (bbfj.d(BaseApplication.getContext()))
        {
          paramCompoundButton = (FriendListHandler)this.app.a(1);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramCompoundButton.a((short)1, (List)localObject, paramBoolean);
          if (paramBoolean)
          {
            axqy.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
            return;
          }
          axqy.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
          return;
        }
        a(2131692321, 1);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        paramCompoundButton = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!paramBoolean) {}
        for (paramBoolean = bool3;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          return;
        }
      }
      if (paramCompoundButton == this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (bbfj.d(BaseApplication.getContext()))
        {
          ((ajti)this.app.a(2)).m(paramBoolean);
          paramCompoundButton = this.app;
          if (paramBoolean) {}
          for (;;)
          {
            axqy.b(paramCompoundButton, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(k), "", "", "");
            return;
            k = 0;
          }
        }
        a(2131692321, 1);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        paramCompoundButton = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!paramBoolean) {}
        for (paramBoolean = bool4;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          return;
        }
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton));
    if (!bbfj.d(BaseApplication.getContext()))
    {
      a(2131692321, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramCompoundButton.isChecked()) {}
      for (paramBoolean = bool5;; paramBoolean = false)
      {
        ((FormSwitchItem)localObject).setChecked(paramBoolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
    }
    Object localObject = this.app;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    long l;
    if (paramCompoundButton.isChecked())
    {
      l = awzy.a();
      FriendsStatusUtil.b((QQAppInterface)localObject, str, 0, l, true, false);
      localObject = this.app;
      if (!paramCompoundButton.isChecked()) {
        break label629;
      }
    }
    label629:
    for (k = 1;; k = 2)
    {
      axqy.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, k, "0", "0", "", "");
      return;
      l = 0L;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int k;
    if (paramView == null) {
      k = 0;
    }
    switch (k)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "case default do nothing");
      }
    case 2131368377: 
    case 2131368322: 
    case 2131368314: 
    case 2131368364: 
    case 2131364996: 
    case 2131376544: 
    case 2131368363: 
    case 2131376359: 
    case 2131368332: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              k = paramView.getId();
              break;
              bbac.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
              axqy.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              axqy.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
              return;
              c();
              axqy.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              return;
              if (Build.VERSION.SDK_INT >= 23)
              {
                if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0)
                {
                  requestPermissions(new absd(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
                  return;
                }
                g();
                return;
              }
              g();
              return;
              if (((bduf)this.app.getManager(165)).f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
              {
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = bbcz.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                }
                String str = getIntent().getStringExtra("key_nick_name");
                paramView = str;
                if (str == null) {
                  paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
                }
                a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView, 14);
              }
              for (;;)
              {
                axqy.b(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
                return;
                if (this.jdField_a_of_type_Auvb == null) {
                  this.jdField_a_of_type_Auvb = new auvb(this, this.app, 0, new abse(this));
                }
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = bbcz.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                }
                this.jdField_a_of_type_Auvb.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
              }
              for (;;)
              {
                try
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
                    break label595;
                  }
                  paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                  a(paramView);
                  return;
                }
                catch (Exception paramView) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("IphoneTitleBarActivity", 2, paramView, new Object[0]);
                return;
                paramView = null;
              }
              i();
              return;
              try
              {
                paramView = bgyw.a();
                paramView.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
                paramView.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
                bgyp.a(this, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
                axqy.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
                return;
              }
              catch (Exception paramView) {}
            } while (!QLog.isColorLevel());
            QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
            return;
            aijy.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 3);
            axqy.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
            return;
            axqy.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
            paramView = ((ajxl)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          } while (paramView == null);
          if ((paramView.intimate_type != 2) && (paramView.intimate_type != 3) && (paramView.intimate_type != 1)) {
            break label887;
          }
          paramView = new Intent();
          paramView.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          abtq.a(this, paramView, PublicFragmentActivity.class, IntimateInfoFragment.class);
        } while (!QLog.isColorLevel());
        QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
        return;
        paramView = asyg.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, "click item_friend_intimate url:" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", paramView));
      return;
    case 2131368317: 
      paramView = new Intent(this, AvatarPendantActivity.class);
      paramView.putExtra("AllInOne", this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramView.putExtra("showActionSheet", true);
      startActivity(paramView);
      axqy.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
      return;
    case 2131368326: 
      label595:
      label887:
      if (this.jdField_a_of_type_Abgw != null)
      {
        paramView = this.jdField_a_of_type_Abgw;
        if (this.jdField_a_of_type_Abgw.jdField_a_of_type_Int != 0) {
          break label1090;
        }
      }
      label1090:
      for (boolean bool = true;; bool = false)
      {
        paramView.a(bool);
        axqy.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
        return;
      }
    }
    k();
    axqy.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */