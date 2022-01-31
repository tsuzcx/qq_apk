package com.tencent.mobileqq.activity;

import adcl;
import adcn;
import adnz;
import adoa;
import adob;
import adoc;
import adod;
import adoe;
import adof;
import adog;
import adoh;
import adoi;
import adpn;
import aepi;
import akfx;
import alof;
import alpk;
import alpq;
import altm;
import alto;
import alud;
import alwx;
import amcm;
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
import anys;
import anyt;
import aryv;
import asim;
import auac;
import ausj;
import autj;
import autm;
import awqw;
import ayzl;
import azqs;
import azup;
import azus;
import azut;
import azwv;
import azxl;
import azyr;
import azzm;
import bddf;
import bdea;
import bdeu;
import bdgc;
import bdin;
import bety;
import bfyh;
import bhuf;
import bjdt;
import bjea;
import bjux;
import bjuy;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nbp;
import zdv;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements adcn, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  public adcl a;
  alpq jdField_a_of_type_Alpq = new adoi(this);
  altm jdField_a_of_type_Altm = new adog(this);
  alwx jdField_a_of_type_Alwx = new adoe(this);
  amcm jdField_a_of_type_Amcm = new adof(this);
  public Intent a;
  public Bundle a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anys jdField_a_of_type_Anys;
  anyt jdField_a_of_type_Anyt = new adoh(this);
  asim jdField_a_of_type_Asim = new adnz(this);
  private awqw jdField_a_of_type_Awqw;
  public bety a;
  public ProfileActivity.AllInOne a;
  public BusinessCard a;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public FormSimpleItem a;
  public FormSwitchItem a;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adoc(this);
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
  private boolean k;
  
  public ProfileCardMoreActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static azut a(String paramString)
  {
    azyr localazyr = new azyr();
    localazyr.b(1);
    localazyr.a(paramString);
    return localazyr;
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
    if (!this.k) {
      this.k = paramIntent.getBooleanExtra("param_qqcircle_switch_changed", false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!bdin.d(BaseApplication.getContext()))
    {
      a(2131692398, 1);
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
          m = 1;
          if (m == 0) {
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
          a(2131720073, 1);
        }
        for (;;)
        {
          d();
          return;
          a(2131720075, 1);
        }
        int m = 0;
      }
    }
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.jdField_j_of_type_Boolean) || (this.k);
  }
  
  private void j()
  {
    boolean bool = false;
    Object localObject;
    autj localautj;
    int m;
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      localObject = "";
      localautj = ausj.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
      if (localautj == null) {
        break label195;
      }
      if (localautj.a != 1L) {
        break label122;
      }
      localObject = getString(2131693712);
      m = localautj.jdField_c_of_type_Int;
      bool = localautj.c();
    }
    for (;;)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      if (m != 0)
      {
        localObject = getResources().getDrawable(m);
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
          if (localautj.a == 2L)
          {
            localObject = getString(2131693710);
            break;
          }
          if (localautj.a != 3L) {
            break;
          }
          localObject = getString(2131693711);
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
      m = 0;
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
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690628));
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
    //   5: invokevirtual 358	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 361	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 218	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 365	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   23: invokevirtual 371	awgg:createEntityManager	()Lawgf;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3441 -> 3471
    //   33: aload 11
    //   35: ldc_w 373
    //   38: aload_1
    //   39: invokevirtual 378	awgf:a	(Ljava/lang/Class;Ljava/lang/String;)Lawge;
    //   42: checkcast 373	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   45: astore 15
    //   47: aload 11
    //   49: ifnull +8 -> 57
    //   52: aload 11
    //   54: invokevirtual 380	awgf:a	()V
    //   57: aload 15
    //   59: ifnonnull +5 -> 64
    //   62: iconst_m1
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 382	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +879 -> 950
    //   74: aload_0
    //   75: getfield 382	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: astore 12
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore_3
    //   84: aconst_null
    //   85: astore 13
    //   87: aload_0
    //   88: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   91: astore 14
    //   93: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   96: astore 11
    //   98: new 400	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 403
    //   108: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 12
    //   113: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 409
    //   119: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 16
    //   127: aload 14
    //   129: aload 11
    //   131: iconst_4
    //   132: anewarray 354	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: ldc_w 414
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: ldc_w 416
    //   146: aastore
    //   147: dup
    //   148: iconst_2
    //   149: ldc_w 418
    //   152: aastore
    //   153: dup
    //   154: iconst_3
    //   155: ldc_w 420
    //   158: aastore
    //   159: aload 16
    //   161: aconst_null
    //   162: aconst_null
    //   163: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore 11
    //   168: iconst_0
    //   169: istore 4
    //   171: lconst_0
    //   172: lstore 8
    //   174: iload_3
    //   175: istore_2
    //   176: iload 4
    //   178: istore_3
    //   179: aload 11
    //   181: ifnull +3277 -> 3458
    //   184: aload 11
    //   186: invokeinterface 431 1 0
    //   191: istore 10
    //   193: iload 10
    //   195: ifeq +3263 -> 3458
    //   198: aload 11
    //   200: iconst_0
    //   201: invokeinterface 435 2 0
    //   206: lstore 6
    //   208: iload_2
    //   209: istore 4
    //   211: aload 15
    //   213: getfield 438	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   216: astore 13
    //   218: aload 13
    //   220: ifnull +873 -> 1093
    //   223: aconst_null
    //   224: astore 14
    //   226: aload_0
    //   227: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   230: astore 17
    //   232: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   235: astore 16
    //   237: new 400	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 440
    //   247: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload 6
    //   252: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc_w 445
    //   258: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 418
    //   264: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 447
    //   270: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 449
    //   276: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 451
    //   282: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 420
    //   288: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 447
    //   294: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 15
    //   299: getfield 438	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   302: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 451
    //   308: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 453
    //   314: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 447
    //   320: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iconst_2
    //   324: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 409
    //   330: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: astore 13
    //   338: aload 17
    //   340: aload 16
    //   342: iconst_5
    //   343: anewarray 354	java/lang/String
    //   346: dup
    //   347: iconst_0
    //   348: ldc_w 414
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: ldc_w 416
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: ldc_w 418
    //   363: aastore
    //   364: dup
    //   365: iconst_3
    //   366: ldc_w 420
    //   369: aastore
    //   370: dup
    //   371: iconst_4
    //   372: ldc_w 453
    //   375: aastore
    //   376: aload 13
    //   378: aconst_null
    //   379: aconst_null
    //   380: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   383: astore 13
    //   385: aload 13
    //   387: ifnull +594 -> 981
    //   390: aload 13
    //   392: invokeinterface 459 1 0
    //   397: istore 10
    //   399: iload 10
    //   401: ifeq +580 -> 981
    //   404: iconst_1
    //   405: istore_3
    //   406: iconst_1
    //   407: istore_2
    //   408: aload 13
    //   410: invokeinterface 462 1 0
    //   415: iconst_0
    //   416: ifeq +3035 -> 3451
    //   419: new 464	java/lang/NullPointerException
    //   422: dup
    //   423: invokespecial 465	java/lang/NullPointerException:<init>	()V
    //   426: athrow
    //   427: iload_3
    //   428: istore 5
    //   430: lload 6
    //   432: lstore 8
    //   434: iload_2
    //   435: istore 4
    //   437: aload 11
    //   439: ifnull +2999 -> 3438
    //   442: aload 11
    //   444: invokeinterface 462 1 0
    //   449: iload_3
    //   450: ifne +669 -> 1119
    //   453: iconst_1
    //   454: istore_3
    //   455: iconst_0
    //   456: istore_2
    //   457: new 467	android/content/ContentValues
    //   460: dup
    //   461: invokespecial 468	android/content/ContentValues:<init>	()V
    //   464: astore 13
    //   466: iload_3
    //   467: iconst_1
    //   468: if_icmpne +669 -> 1137
    //   471: aload_0
    //   472: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   475: getstatic 471	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   478: aload 13
    //   480: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   483: invokestatic 481	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   486: lstore 6
    //   488: aload 12
    //   490: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   493: ifne +55 -> 548
    //   496: aload 13
    //   498: invokevirtual 484	android/content/ContentValues:clear	()V
    //   501: aload 13
    //   503: ldc_w 414
    //   506: lload 6
    //   508: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   514: aload 13
    //   516: ldc_w 418
    //   519: ldc_w 494
    //   522: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 13
    //   527: ldc_w 420
    //   530: aload 12
    //   532: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   539: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   542: aload 13
    //   544: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   547: pop
    //   548: aload 15
    //   550: getfield 500	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   553: ifnonnull +11 -> 564
    //   556: aload 15
    //   558: getfield 503	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   561: ifnull +99 -> 660
    //   564: aload 13
    //   566: invokevirtual 484	android/content/ContentValues:clear	()V
    //   569: aload 13
    //   571: ldc_w 414
    //   574: lload 6
    //   576: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   579: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   582: aload 13
    //   584: ldc_w 418
    //   587: ldc_w 505
    //   590: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload 15
    //   595: getfield 503	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   598: ifnull +16 -> 614
    //   601: aload 13
    //   603: ldc_w 420
    //   606: aload 15
    //   608: getfield 503	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   611: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 15
    //   616: getfield 500	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   619: ifnull +16 -> 635
    //   622: aload 13
    //   624: ldc_w 507
    //   627: aload 15
    //   629: getfield 500	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   632: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 13
    //   637: ldc_w 453
    //   640: iconst_1
    //   641: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   647: aload_0
    //   648: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   651: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   654: aload 13
    //   656: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   659: pop
    //   660: aload 15
    //   662: getfield 438	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   665: ifnull +70 -> 735
    //   668: aload 13
    //   670: invokevirtual 484	android/content/ContentValues:clear	()V
    //   673: aload 13
    //   675: ldc_w 414
    //   678: lload 6
    //   680: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   683: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   686: aload 13
    //   688: ldc_w 418
    //   691: ldc_w 449
    //   694: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 13
    //   699: ldc_w 420
    //   702: aload 15
    //   704: getfield 438	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   707: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 13
    //   712: ldc_w 453
    //   715: iconst_2
    //   716: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   719: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   722: aload_0
    //   723: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   726: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   729: aload 13
    //   731: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   734: pop
    //   735: aload 15
    //   737: getfield 518	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   740: ifnull +70 -> 810
    //   743: aload 13
    //   745: invokevirtual 484	android/content/ContentValues:clear	()V
    //   748: aload 13
    //   750: ldc_w 414
    //   753: lload 6
    //   755: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   758: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   761: aload 13
    //   763: ldc_w 418
    //   766: ldc_w 449
    //   769: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload 13
    //   774: ldc_w 420
    //   777: aload 15
    //   779: getfield 518	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   782: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 13
    //   787: ldc_w 453
    //   790: iconst_3
    //   791: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   794: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   797: aload_0
    //   798: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   801: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   804: aload 13
    //   806: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   809: pop
    //   810: aload 15
    //   812: getfield 521	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   815: ifnull +70 -> 885
    //   818: aload 13
    //   820: invokevirtual 484	android/content/ContentValues:clear	()V
    //   823: aload 13
    //   825: ldc_w 414
    //   828: lload 6
    //   830: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   833: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   836: aload 13
    //   838: ldc_w 418
    //   841: ldc_w 523
    //   844: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload 13
    //   849: ldc_w 420
    //   852: aload 15
    //   854: getfield 521	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   857: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 13
    //   862: ldc_w 453
    //   865: iconst_2
    //   866: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   869: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   872: aload_0
    //   873: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   876: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   879: aload 13
    //   881: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   884: pop
    //   885: aload 13
    //   887: invokevirtual 484	android/content/ContentValues:clear	()V
    //   890: aload 13
    //   892: ldc_w 414
    //   895: lload 6
    //   897: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   900: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   903: aload 13
    //   905: ldc_w 418
    //   908: ldc_w 525
    //   911: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload 13
    //   916: ldc_w 420
    //   919: aload_1
    //   920: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload 13
    //   925: ldc_w 453
    //   928: iconst_2
    //   929: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   932: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   935: aload_0
    //   936: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   939: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   942: aload 13
    //   944: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   947: pop
    //   948: iconst_0
    //   949: ireturn
    //   950: aload 15
    //   952: getfield 528	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   955: ifnull +13 -> 968
    //   958: aload 15
    //   960: getfield 528	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   963: astore 12
    //   965: goto -885 -> 80
    //   968: aload_1
    //   969: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +2493 -> 3465
    //   975: aload_1
    //   976: astore 12
    //   978: goto -898 -> 80
    //   981: iconst_0
    //   982: istore_2
    //   983: iconst_0
    //   984: istore 4
    //   986: iload_2
    //   987: istore_3
    //   988: aload 13
    //   990: ifnull +2487 -> 3477
    //   993: iload 4
    //   995: istore_3
    //   996: aload 13
    //   998: invokeinterface 462 1 0
    //   1003: iload_2
    //   1004: istore_3
    //   1005: goto +2472 -> 3477
    //   1008: iload_2
    //   1009: istore_3
    //   1010: aload 13
    //   1012: ifnull +2465 -> 3477
    //   1015: iload_2
    //   1016: istore_3
    //   1017: aload 13
    //   1019: invokeinterface 462 1 0
    //   1024: iload_2
    //   1025: istore_3
    //   1026: goto +2451 -> 3477
    //   1029: astore 13
    //   1031: iload_3
    //   1032: istore_2
    //   1033: iconst_1
    //   1034: istore_3
    //   1035: iload_3
    //   1036: istore 5
    //   1038: lload 6
    //   1040: lstore 8
    //   1042: iload_2
    //   1043: istore 4
    //   1045: aload 11
    //   1047: ifnull +2391 -> 3438
    //   1050: aload 11
    //   1052: invokeinterface 462 1 0
    //   1057: goto -608 -> 449
    //   1060: astore 13
    //   1062: aload 14
    //   1064: ifnull +13 -> 1077
    //   1067: iload_2
    //   1068: istore 4
    //   1070: aload 14
    //   1072: invokeinterface 462 1 0
    //   1077: iload_2
    //   1078: istore 4
    //   1080: aload 13
    //   1082: athrow
    //   1083: astore 13
    //   1085: iconst_1
    //   1086: istore_3
    //   1087: iload 4
    //   1089: istore_2
    //   1090: goto -55 -> 1035
    //   1093: iconst_0
    //   1094: istore_2
    //   1095: iconst_1
    //   1096: istore_3
    //   1097: goto -670 -> 427
    //   1100: astore_1
    //   1101: aload 13
    //   1103: astore 11
    //   1105: aload 11
    //   1107: ifnull +10 -> 1117
    //   1110: aload 11
    //   1112: invokeinterface 462 1 0
    //   1117: aload_1
    //   1118: athrow
    //   1119: iload_2
    //   1120: ifne +10 -> 1130
    //   1123: iconst_1
    //   1124: istore_3
    //   1125: iconst_0
    //   1126: istore_2
    //   1127: goto -670 -> 457
    //   1130: iconst_1
    //   1131: istore_2
    //   1132: iconst_0
    //   1133: istore_3
    //   1134: goto -677 -> 457
    //   1137: iload_2
    //   1138: iconst_1
    //   1139: if_icmpne +2163 -> 3302
    //   1142: aload 15
    //   1144: getfield 438	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1147: ifnull +131 -> 1278
    //   1150: aload 13
    //   1152: invokevirtual 484	android/content/ContentValues:clear	()V
    //   1155: aload 13
    //   1157: ldc_w 418
    //   1160: ldc_w 449
    //   1163: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: aload 13
    //   1168: ldc_w 420
    //   1171: aload 15
    //   1173: getfield 438	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1176: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1179: aload 13
    //   1181: ldc_w 453
    //   1184: iconst_2
    //   1185: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1188: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1191: aload_0
    //   1192: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1195: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1198: aload 13
    //   1200: new 400	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1207: ldc_w 440
    //   1210: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: lload 6
    //   1215: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1218: ldc_w 445
    //   1221: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: ldc_w 418
    //   1227: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: ldc_w 447
    //   1233: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: ldc_w 449
    //   1239: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: ldc_w 451
    //   1245: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: ldc_w 453
    //   1251: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: ldc_w 447
    //   1257: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: iconst_2
    //   1261: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1264: ldc_w 409
    //   1267: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: aconst_null
    //   1274: invokevirtual 532	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1277: pop
    //   1278: aload 15
    //   1280: getfield 500	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1283: ifnull +293 -> 1576
    //   1286: aconst_null
    //   1287: astore 11
    //   1289: aload_0
    //   1290: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1293: astore 16
    //   1295: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1298: astore 14
    //   1300: new 400	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1307: ldc_w 440
    //   1310: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: lload 6
    //   1315: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1318: ldc_w 445
    //   1321: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: ldc_w 418
    //   1327: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: ldc_w 447
    //   1333: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: ldc_w 505
    //   1339: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: ldc_w 451
    //   1345: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: ldc_w 453
    //   1351: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: ldc_w 447
    //   1357: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: iconst_1
    //   1361: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1364: ldc_w 409
    //   1367: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1373: astore 12
    //   1375: aload 16
    //   1377: aload 14
    //   1379: iconst_5
    //   1380: anewarray 354	java/lang/String
    //   1383: dup
    //   1384: iconst_0
    //   1385: ldc_w 414
    //   1388: aastore
    //   1389: dup
    //   1390: iconst_1
    //   1391: ldc_w 416
    //   1394: aastore
    //   1395: dup
    //   1396: iconst_2
    //   1397: ldc_w 418
    //   1400: aastore
    //   1401: dup
    //   1402: iconst_3
    //   1403: ldc_w 507
    //   1406: aastore
    //   1407: dup
    //   1408: iconst_4
    //   1409: ldc_w 453
    //   1412: aastore
    //   1413: aload 12
    //   1415: aconst_null
    //   1416: aconst_null
    //   1417: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1420: astore 12
    //   1422: aload 12
    //   1424: astore 11
    //   1426: aload 11
    //   1428: invokeinterface 459 1 0
    //   1433: ifeq +1364 -> 2797
    //   1436: aload 13
    //   1438: invokevirtual 484	android/content/ContentValues:clear	()V
    //   1441: aload 13
    //   1443: ldc_w 418
    //   1446: ldc_w 505
    //   1449: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1452: aload 13
    //   1454: ldc_w 507
    //   1457: aload 15
    //   1459: getfield 500	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1462: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 13
    //   1467: ldc_w 453
    //   1470: iconst_1
    //   1471: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1474: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1477: aload_0
    //   1478: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1481: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1484: aload 13
    //   1486: new 400	java/lang/StringBuilder
    //   1489: dup
    //   1490: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1493: ldc_w 440
    //   1496: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: lload 6
    //   1501: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1504: ldc_w 445
    //   1507: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: ldc_w 418
    //   1513: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: ldc_w 447
    //   1519: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: ldc_w 505
    //   1525: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: ldc_w 451
    //   1531: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: ldc_w 453
    //   1537: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: ldc_w 447
    //   1543: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: iconst_1
    //   1547: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1550: ldc_w 409
    //   1553: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1559: aconst_null
    //   1560: invokevirtual 532	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1563: pop
    //   1564: aload 11
    //   1566: ifnull +10 -> 1576
    //   1569: aload 11
    //   1571: invokeinterface 462 1 0
    //   1576: aload 15
    //   1578: getfield 503	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1581: ifnull +293 -> 1874
    //   1584: aconst_null
    //   1585: astore 11
    //   1587: aload_0
    //   1588: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1591: astore 12
    //   1593: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1596: astore 16
    //   1598: new 400	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1605: ldc_w 440
    //   1608: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: lload 6
    //   1613: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1616: ldc_w 445
    //   1619: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: ldc_w 418
    //   1625: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: ldc_w 447
    //   1631: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: ldc_w 505
    //   1637: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: ldc_w 451
    //   1643: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1646: ldc_w 453
    //   1649: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: ldc_w 447
    //   1655: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: iconst_1
    //   1659: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1662: ldc_w 409
    //   1665: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: astore 14
    //   1673: aload 12
    //   1675: aload 16
    //   1677: iconst_5
    //   1678: anewarray 354	java/lang/String
    //   1681: dup
    //   1682: iconst_0
    //   1683: ldc_w 414
    //   1686: aastore
    //   1687: dup
    //   1688: iconst_1
    //   1689: ldc_w 416
    //   1692: aastore
    //   1693: dup
    //   1694: iconst_2
    //   1695: ldc_w 418
    //   1698: aastore
    //   1699: dup
    //   1700: iconst_3
    //   1701: ldc_w 420
    //   1704: aastore
    //   1705: dup
    //   1706: iconst_4
    //   1707: ldc_w 453
    //   1710: aastore
    //   1711: aload 14
    //   1713: aconst_null
    //   1714: aconst_null
    //   1715: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1718: astore 12
    //   1720: aload 12
    //   1722: astore 11
    //   1724: aload 11
    //   1726: invokeinterface 459 1 0
    //   1731: ifeq +1168 -> 2899
    //   1734: aload 13
    //   1736: invokevirtual 484	android/content/ContentValues:clear	()V
    //   1739: aload 13
    //   1741: ldc_w 418
    //   1744: ldc_w 505
    //   1747: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1750: aload 13
    //   1752: ldc_w 420
    //   1755: aload 15
    //   1757: getfield 503	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1760: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1763: aload 13
    //   1765: ldc_w 453
    //   1768: iconst_1
    //   1769: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1772: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1775: aload_0
    //   1776: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1779: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1782: aload 13
    //   1784: new 400	java/lang/StringBuilder
    //   1787: dup
    //   1788: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1791: ldc_w 440
    //   1794: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: lload 6
    //   1799: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1802: ldc_w 445
    //   1805: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: ldc_w 418
    //   1811: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: ldc_w 447
    //   1817: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: ldc_w 505
    //   1823: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: ldc_w 451
    //   1829: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: ldc_w 453
    //   1835: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: ldc_w 447
    //   1841: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: iconst_1
    //   1845: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1848: ldc_w 409
    //   1851: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: aconst_null
    //   1858: invokevirtual 532	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1861: pop
    //   1862: aload 11
    //   1864: ifnull +10 -> 1874
    //   1867: aload 11
    //   1869: invokeinterface 462 1 0
    //   1874: aload 15
    //   1876: getfield 518	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1879: ifnull +306 -> 2185
    //   1882: aconst_null
    //   1883: astore 11
    //   1885: aload_0
    //   1886: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1889: astore 16
    //   1891: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1894: astore 12
    //   1896: new 400	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1903: ldc_w 440
    //   1906: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: lload 6
    //   1911: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1914: ldc_w 445
    //   1917: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: ldc_w 418
    //   1923: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: ldc_w 447
    //   1929: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: ldc_w 449
    //   1935: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: ldc_w 451
    //   1941: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: ldc_w 453
    //   1947: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: ldc_w 447
    //   1953: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: iconst_3
    //   1957: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1960: ldc_w 409
    //   1963: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: astore 14
    //   1971: aload 16
    //   1973: aload 12
    //   1975: iconst_5
    //   1976: anewarray 354	java/lang/String
    //   1979: dup
    //   1980: iconst_0
    //   1981: ldc_w 414
    //   1984: aastore
    //   1985: dup
    //   1986: iconst_1
    //   1987: ldc_w 416
    //   1990: aastore
    //   1991: dup
    //   1992: iconst_2
    //   1993: ldc_w 418
    //   1996: aastore
    //   1997: dup
    //   1998: iconst_3
    //   1999: ldc_w 420
    //   2002: aastore
    //   2003: dup
    //   2004: iconst_4
    //   2005: ldc_w 453
    //   2008: aastore
    //   2009: aload 14
    //   2011: aconst_null
    //   2012: aconst_null
    //   2013: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2016: astore 12
    //   2018: aload 12
    //   2020: astore 11
    //   2022: aload 11
    //   2024: invokeinterface 459 1 0
    //   2029: ifeq +972 -> 3001
    //   2032: aload 13
    //   2034: invokevirtual 484	android/content/ContentValues:clear	()V
    //   2037: aload 13
    //   2039: ldc_w 414
    //   2042: lload 6
    //   2044: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2047: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2050: aload 13
    //   2052: ldc_w 418
    //   2055: ldc_w 449
    //   2058: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2061: aload 13
    //   2063: ldc_w 420
    //   2066: aload 15
    //   2068: getfield 518	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2071: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2074: aload 13
    //   2076: ldc_w 453
    //   2079: iconst_3
    //   2080: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2083: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2086: aload_0
    //   2087: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2090: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2093: aload 13
    //   2095: new 400	java/lang/StringBuilder
    //   2098: dup
    //   2099: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   2102: ldc_w 440
    //   2105: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: lload 6
    //   2110: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2113: ldc_w 445
    //   2116: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: ldc_w 418
    //   2122: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: ldc_w 447
    //   2128: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: ldc_w 449
    //   2134: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: ldc_w 451
    //   2140: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: ldc_w 453
    //   2146: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: ldc_w 447
    //   2152: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: iconst_3
    //   2156: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2159: ldc_w 409
    //   2162: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2168: aconst_null
    //   2169: invokevirtual 532	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2172: pop
    //   2173: aload 11
    //   2175: ifnull +10 -> 2185
    //   2178: aload 11
    //   2180: invokeinterface 462 1 0
    //   2185: aload 15
    //   2187: getfield 521	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2190: ifnull +306 -> 2496
    //   2193: aconst_null
    //   2194: astore 11
    //   2196: aload_0
    //   2197: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2200: astore 14
    //   2202: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2205: astore 16
    //   2207: new 400	java/lang/StringBuilder
    //   2210: dup
    //   2211: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   2214: ldc_w 440
    //   2217: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2220: lload 6
    //   2222: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2225: ldc_w 445
    //   2228: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: ldc_w 418
    //   2234: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: ldc_w 447
    //   2240: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: ldc_w 523
    //   2246: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: ldc_w 451
    //   2252: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: ldc_w 453
    //   2258: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: ldc_w 447
    //   2264: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2267: iconst_2
    //   2268: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2271: ldc_w 409
    //   2274: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2280: astore 12
    //   2282: aload 14
    //   2284: aload 16
    //   2286: iconst_5
    //   2287: anewarray 354	java/lang/String
    //   2290: dup
    //   2291: iconst_0
    //   2292: ldc_w 414
    //   2295: aastore
    //   2296: dup
    //   2297: iconst_1
    //   2298: ldc_w 416
    //   2301: aastore
    //   2302: dup
    //   2303: iconst_2
    //   2304: ldc_w 418
    //   2307: aastore
    //   2308: dup
    //   2309: iconst_3
    //   2310: ldc_w 420
    //   2313: aastore
    //   2314: dup
    //   2315: iconst_4
    //   2316: ldc_w 453
    //   2319: aastore
    //   2320: aload 12
    //   2322: aconst_null
    //   2323: aconst_null
    //   2324: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2327: astore 12
    //   2329: aload 12
    //   2331: astore 11
    //   2333: aload 11
    //   2335: invokeinterface 459 1 0
    //   2340: ifeq +763 -> 3103
    //   2343: aload 13
    //   2345: invokevirtual 484	android/content/ContentValues:clear	()V
    //   2348: aload 13
    //   2350: ldc_w 414
    //   2353: lload 6
    //   2355: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2358: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2361: aload 13
    //   2363: ldc_w 418
    //   2366: ldc_w 523
    //   2369: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2372: aload 13
    //   2374: ldc_w 420
    //   2377: aload 15
    //   2379: getfield 521	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2382: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2385: aload 13
    //   2387: ldc_w 453
    //   2390: iconst_2
    //   2391: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2394: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2397: aload_0
    //   2398: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2401: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2404: aload 13
    //   2406: new 400	java/lang/StringBuilder
    //   2409: dup
    //   2410: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   2413: ldc_w 440
    //   2416: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: lload 6
    //   2421: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2424: ldc_w 445
    //   2427: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2430: ldc_w 418
    //   2433: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: ldc_w 447
    //   2439: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: ldc_w 523
    //   2445: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: ldc_w 451
    //   2451: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: ldc_w 453
    //   2457: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: ldc_w 447
    //   2463: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: iconst_2
    //   2467: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2470: ldc_w 409
    //   2473: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2479: aconst_null
    //   2480: invokevirtual 532	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2483: pop
    //   2484: aload 11
    //   2486: ifnull +10 -> 2496
    //   2489: aload 11
    //   2491: invokeinterface 462 1 0
    //   2496: aconst_null
    //   2497: astore 11
    //   2499: aload_0
    //   2500: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2503: astore 14
    //   2505: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2508: astore 15
    //   2510: new 400	java/lang/StringBuilder
    //   2513: dup
    //   2514: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   2517: ldc_w 440
    //   2520: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2523: lload 6
    //   2525: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2528: ldc_w 445
    //   2531: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: ldc_w 418
    //   2537: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2540: ldc_w 447
    //   2543: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: ldc_w 525
    //   2549: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2552: ldc_w 451
    //   2555: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: ldc_w 453
    //   2561: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: ldc_w 447
    //   2567: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: iconst_2
    //   2571: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2574: ldc_w 409
    //   2577: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2583: astore 12
    //   2585: aload 14
    //   2587: aload 15
    //   2589: iconst_5
    //   2590: anewarray 354	java/lang/String
    //   2593: dup
    //   2594: iconst_0
    //   2595: ldc_w 414
    //   2598: aastore
    //   2599: dup
    //   2600: iconst_1
    //   2601: ldc_w 416
    //   2604: aastore
    //   2605: dup
    //   2606: iconst_2
    //   2607: ldc_w 418
    //   2610: aastore
    //   2611: dup
    //   2612: iconst_3
    //   2613: ldc_w 420
    //   2616: aastore
    //   2617: dup
    //   2618: iconst_4
    //   2619: ldc_w 453
    //   2622: aastore
    //   2623: aload 12
    //   2625: aconst_null
    //   2626: aconst_null
    //   2627: invokevirtual 426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2630: astore 12
    //   2632: aload 12
    //   2634: astore 11
    //   2636: aload 11
    //   2638: invokeinterface 459 1 0
    //   2643: ifeq +562 -> 3205
    //   2646: aload 13
    //   2648: invokevirtual 484	android/content/ContentValues:clear	()V
    //   2651: aload 13
    //   2653: ldc_w 414
    //   2656: lload 6
    //   2658: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2661: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2664: aload 13
    //   2666: ldc_w 418
    //   2669: ldc_w 525
    //   2672: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2675: aload 13
    //   2677: ldc_w 420
    //   2680: aload_1
    //   2681: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2684: aload 13
    //   2686: ldc_w 453
    //   2689: iconst_2
    //   2690: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2693: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2696: aload_0
    //   2697: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2700: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2703: aload 13
    //   2705: new 400	java/lang/StringBuilder
    //   2708: dup
    //   2709: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   2712: ldc_w 440
    //   2715: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2718: lload 6
    //   2720: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2723: ldc_w 445
    //   2726: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2729: ldc_w 418
    //   2732: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2735: ldc_w 447
    //   2738: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: ldc_w 525
    //   2744: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: ldc_w 451
    //   2750: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: ldc_w 453
    //   2756: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: ldc_w 447
    //   2762: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2765: iconst_2
    //   2766: invokevirtual 456	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2769: ldc_w 409
    //   2772: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2775: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2778: aconst_null
    //   2779: invokevirtual 532	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2782: pop
    //   2783: aload 11
    //   2785: ifnull +10 -> 2795
    //   2788: aload 11
    //   2790: invokeinterface 462 1 0
    //   2795: iconst_1
    //   2796: ireturn
    //   2797: aload 13
    //   2799: invokevirtual 484	android/content/ContentValues:clear	()V
    //   2802: aload 13
    //   2804: ldc_w 414
    //   2807: lload 6
    //   2809: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2812: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2815: aload 13
    //   2817: ldc_w 418
    //   2820: ldc_w 505
    //   2823: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2826: aload 13
    //   2828: ldc_w 507
    //   2831: aload 15
    //   2833: getfield 500	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2836: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2839: aload 13
    //   2841: ldc_w 453
    //   2844: iconst_1
    //   2845: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2848: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2851: aload_0
    //   2852: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2855: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2858: aload 13
    //   2860: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2863: pop
    //   2864: goto -1300 -> 1564
    //   2867: astore 12
    //   2869: aload 11
    //   2871: ifnull -1295 -> 1576
    //   2874: aload 11
    //   2876: invokeinterface 462 1 0
    //   2881: goto -1305 -> 1576
    //   2884: astore_1
    //   2885: aload 11
    //   2887: ifnull +10 -> 2897
    //   2890: aload 11
    //   2892: invokeinterface 462 1 0
    //   2897: aload_1
    //   2898: athrow
    //   2899: aload 13
    //   2901: invokevirtual 484	android/content/ContentValues:clear	()V
    //   2904: aload 13
    //   2906: ldc_w 414
    //   2909: lload 6
    //   2911: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2914: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2917: aload 13
    //   2919: ldc_w 418
    //   2922: ldc_w 505
    //   2925: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2928: aload 13
    //   2930: ldc_w 420
    //   2933: aload 15
    //   2935: getfield 503	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2938: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2941: aload 13
    //   2943: ldc_w 453
    //   2946: iconst_1
    //   2947: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2950: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2953: aload_0
    //   2954: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2957: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2960: aload 13
    //   2962: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2965: pop
    //   2966: goto -1104 -> 1862
    //   2969: astore 12
    //   2971: aload 11
    //   2973: ifnull -1099 -> 1874
    //   2976: aload 11
    //   2978: invokeinterface 462 1 0
    //   2983: goto -1109 -> 1874
    //   2986: astore_1
    //   2987: aload 11
    //   2989: ifnull +10 -> 2999
    //   2992: aload 11
    //   2994: invokeinterface 462 1 0
    //   2999: aload_1
    //   3000: athrow
    //   3001: aload 13
    //   3003: invokevirtual 484	android/content/ContentValues:clear	()V
    //   3006: aload 13
    //   3008: ldc_w 414
    //   3011: lload 6
    //   3013: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3016: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3019: aload 13
    //   3021: ldc_w 418
    //   3024: ldc_w 449
    //   3027: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3030: aload 13
    //   3032: ldc_w 420
    //   3035: aload 15
    //   3037: getfield 518	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   3040: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3043: aload 13
    //   3045: ldc_w 453
    //   3048: iconst_3
    //   3049: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3052: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3055: aload_0
    //   3056: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3059: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3062: aload 13
    //   3064: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3067: pop
    //   3068: goto -895 -> 2173
    //   3071: astore 12
    //   3073: aload 11
    //   3075: ifnull -890 -> 2185
    //   3078: aload 11
    //   3080: invokeinterface 462 1 0
    //   3085: goto -900 -> 2185
    //   3088: astore_1
    //   3089: aload 11
    //   3091: ifnull +10 -> 3101
    //   3094: aload 11
    //   3096: invokeinterface 462 1 0
    //   3101: aload_1
    //   3102: athrow
    //   3103: aload 13
    //   3105: invokevirtual 484	android/content/ContentValues:clear	()V
    //   3108: aload 13
    //   3110: ldc_w 414
    //   3113: lload 6
    //   3115: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3118: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3121: aload 13
    //   3123: ldc_w 418
    //   3126: ldc_w 523
    //   3129: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3132: aload 13
    //   3134: ldc_w 420
    //   3137: aload 15
    //   3139: getfield 521	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3142: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3145: aload 13
    //   3147: ldc_w 453
    //   3150: iconst_2
    //   3151: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3154: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3157: aload_0
    //   3158: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3161: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3164: aload 13
    //   3166: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3169: pop
    //   3170: goto -686 -> 2484
    //   3173: astore 12
    //   3175: aload 11
    //   3177: ifnull -681 -> 2496
    //   3180: aload 11
    //   3182: invokeinterface 462 1 0
    //   3187: goto -691 -> 2496
    //   3190: astore_1
    //   3191: aload 11
    //   3193: ifnull +10 -> 3203
    //   3196: aload 11
    //   3198: invokeinterface 462 1 0
    //   3203: aload_1
    //   3204: athrow
    //   3205: aload 13
    //   3207: invokevirtual 484	android/content/ContentValues:clear	()V
    //   3210: aload 13
    //   3212: ldc_w 414
    //   3215: lload 6
    //   3217: invokestatic 488	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3220: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3223: aload 13
    //   3225: ldc_w 418
    //   3228: ldc_w 525
    //   3231: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3234: aload 13
    //   3236: ldc_w 420
    //   3239: aload_1
    //   3240: invokevirtual 497	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3243: aload 13
    //   3245: ldc_w 453
    //   3248: iconst_2
    //   3249: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3252: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3255: aload_0
    //   3256: invokevirtual 392	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3259: getstatic 398	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3262: aload 13
    //   3264: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3267: pop
    //   3268: goto -485 -> 2783
    //   3271: astore_1
    //   3272: aload 11
    //   3274: ifnull -479 -> 2795
    //   3277: aload 11
    //   3279: invokeinterface 462 1 0
    //   3284: goto -489 -> 2795
    //   3287: astore_1
    //   3288: aload 11
    //   3290: ifnull +10 -> 3300
    //   3293: aload 11
    //   3295: invokeinterface 462 1 0
    //   3300: aload_1
    //   3301: athrow
    //   3302: iconst_m1
    //   3303: ireturn
    //   3304: astore_1
    //   3305: goto -17 -> 3288
    //   3308: astore_1
    //   3309: aconst_null
    //   3310: astore 11
    //   3312: goto -40 -> 3272
    //   3315: astore_1
    //   3316: goto -125 -> 3191
    //   3319: astore 11
    //   3321: aconst_null
    //   3322: astore 11
    //   3324: goto -149 -> 3175
    //   3327: astore_1
    //   3328: goto -239 -> 3089
    //   3331: astore 11
    //   3333: aconst_null
    //   3334: astore 11
    //   3336: goto -263 -> 3073
    //   3339: astore_1
    //   3340: goto -353 -> 2987
    //   3343: astore 11
    //   3345: aconst_null
    //   3346: astore 11
    //   3348: goto -377 -> 2971
    //   3351: astore_1
    //   3352: goto -467 -> 2885
    //   3355: astore 11
    //   3357: aconst_null
    //   3358: astore 11
    //   3360: goto -491 -> 2869
    //   3363: astore_1
    //   3364: goto -2259 -> 1105
    //   3367: astore 11
    //   3369: aconst_null
    //   3370: astore 11
    //   3372: iconst_0
    //   3373: istore_3
    //   3374: lconst_0
    //   3375: lstore 6
    //   3377: goto -2342 -> 1035
    //   3380: astore 13
    //   3382: lload 8
    //   3384: lstore 6
    //   3386: goto -2351 -> 1035
    //   3389: astore 13
    //   3391: iconst_1
    //   3392: istore_3
    //   3393: lload 8
    //   3395: lstore 6
    //   3397: goto -2362 -> 1035
    //   3400: astore 16
    //   3402: aload 13
    //   3404: astore 14
    //   3406: aload 16
    //   3408: astore 13
    //   3410: goto -2348 -> 1062
    //   3413: astore 16
    //   3415: aload 13
    //   3417: astore 14
    //   3419: iconst_1
    //   3420: istore_2
    //   3421: aload 16
    //   3423: astore 13
    //   3425: goto -2363 -> 1062
    //   3428: astore 14
    //   3430: goto -2422 -> 1008
    //   3433: astore 14
    //   3435: goto -2427 -> 1008
    //   3438: lload 8
    //   3440: lstore 6
    //   3442: iload 5
    //   3444: istore_3
    //   3445: iload 4
    //   3447: istore_2
    //   3448: goto -2999 -> 449
    //   3451: iconst_1
    //   3452: istore_2
    //   3453: iconst_1
    //   3454: istore_3
    //   3455: goto -3028 -> 427
    //   3458: lload 8
    //   3460: lstore 6
    //   3462: goto -3035 -> 427
    //   3465: aconst_null
    //   3466: astore 12
    //   3468: goto -3388 -> 80
    //   3471: aconst_null
    //   3472: astore 15
    //   3474: goto -3427 -> 47
    //   3477: iload_3
    //   3478: istore_2
    //   3479: iconst_1
    //   3480: istore_3
    //   3481: lload 6
    //   3483: lstore 8
    //   3485: goto -3306 -> 179
    //   3488: astore 13
    //   3490: aconst_null
    //   3491: astore 13
    //   3493: goto -2485 -> 1008
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3496	0	this	ProfileCardMoreActivity
    //   0	3496	1	paramString	String
    //   81	3398	2	m	int
    //   83	3398	3	n	int
    //   169	3277	4	i1	int
    //   428	3015	5	i2	int
    //   206	3276	6	l1	long
    //   172	3312	8	l2	long
    //   191	209	10	bool	boolean
    //   26	3285	11	localObject1	Object
    //   3319	1	11	localException1	Exception
    //   3322	1	11	localObject2	Object
    //   3331	1	11	localException2	Exception
    //   3334	1	11	localObject3	Object
    //   3343	1	11	localException3	Exception
    //   3346	1	11	localObject4	Object
    //   3355	1	11	localException4	Exception
    //   3358	1	11	localObject5	Object
    //   3367	1	11	localException5	Exception
    //   3370	1	11	localObject6	Object
    //   78	2555	12	localObject7	Object
    //   2867	1	12	localException6	Exception
    //   2969	1	12	localException7	Exception
    //   3071	1	12	localException8	Exception
    //   3173	1	12	localException9	Exception
    //   3466	1	12	localObject8	Object
    //   85	933	13	localObject9	Object
    //   1029	1	13	localException10	Exception
    //   1060	21	13	localObject10	Object
    //   1083	2180	13	localException11	Exception
    //   3380	1	13	localException12	Exception
    //   3389	14	13	localException13	Exception
    //   3408	16	13	localObject11	Object
    //   3488	1	13	localException14	Exception
    //   3491	1	13	localObject12	Object
    //   91	3327	14	localObject13	Object
    //   3428	1	14	localException15	Exception
    //   3433	1	14	localException16	Exception
    //   45	3428	15	localObject14	Object
    //   125	2160	16	localObject15	Object
    //   3400	7	16	localObject16	Object
    //   3413	9	16	localObject17	Object
    //   230	109	17	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   419	427	1029	java/lang/Exception
    //   996	1003	1029	java/lang/Exception
    //   1017	1024	1029	java/lang/Exception
    //   226	385	1060	finally
    //   211	218	1083	java/lang/Exception
    //   1070	1077	1083	java/lang/Exception
    //   1080	1083	1083	java/lang/Exception
    //   87	168	1100	finally
    //   1426	1564	2867	java/lang/Exception
    //   2797	2864	2867	java/lang/Exception
    //   1289	1422	2884	finally
    //   1724	1862	2969	java/lang/Exception
    //   2899	2966	2969	java/lang/Exception
    //   1587	1720	2986	finally
    //   2022	2173	3071	java/lang/Exception
    //   3001	3068	3071	java/lang/Exception
    //   1885	2018	3088	finally
    //   2333	2484	3173	java/lang/Exception
    //   3103	3170	3173	java/lang/Exception
    //   2196	2329	3190	finally
    //   2636	2783	3271	java/lang/Exception
    //   3205	3268	3271	java/lang/Exception
    //   2499	2632	3287	finally
    //   2636	2783	3304	finally
    //   3205	3268	3304	finally
    //   2499	2632	3308	java/lang/Exception
    //   2333	2484	3315	finally
    //   3103	3170	3315	finally
    //   2196	2329	3319	java/lang/Exception
    //   2022	2173	3327	finally
    //   3001	3068	3327	finally
    //   1885	2018	3331	java/lang/Exception
    //   1724	1862	3339	finally
    //   2899	2966	3339	finally
    //   1587	1720	3343	java/lang/Exception
    //   1426	1564	3351	finally
    //   2797	2864	3351	finally
    //   1289	1422	3355	java/lang/Exception
    //   184	193	3363	finally
    //   198	208	3363	finally
    //   211	218	3363	finally
    //   419	427	3363	finally
    //   996	1003	3363	finally
    //   1017	1024	3363	finally
    //   1070	1077	3363	finally
    //   1080	1083	3363	finally
    //   87	168	3367	java/lang/Exception
    //   184	193	3380	java/lang/Exception
    //   198	208	3389	java/lang/Exception
    //   390	399	3400	finally
    //   408	415	3413	finally
    //   390	399	3428	java/lang/Exception
    //   408	415	3433	java/lang/Exception
    //   226	385	3488	java/lang/Exception
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
      String str = bdgc.e(this.app, this.jdField_a_of_type_JavaLangString);
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
    setContentViewB(2131561176);
    Object localObject1;
    label97:
    int i1;
    label129:
    int n;
    int m;
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString))
    {
      setTitle(alud.a(2131708842));
      if (this.mLeftBackText != null)
      {
        this.mLeftBackText.setText("");
        this.mLeftBackText.setContentDescription(alud.a(2131708852));
      }
      enableRightHighlight(false);
      localObject1 = findViewById(2131365083);
      if (this.jdField_a_of_type_ArrayOfInt[13] != 1) {
        break label180;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131377098);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label190;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      i1 = -1;
      n = -1;
      m = 0;
      label135:
      if (m > 3) {
        break label200;
      }
      if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
        break label1313;
      }
      if (i1 >= 0) {
        break label1310;
      }
      i1 = m;
      label156:
      if (n >= m) {
        break label1307;
      }
      n = m;
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
      m += 1;
      break label135;
      setTitle(2131695635);
      break;
      label180:
      ((View)localObject1).setVisibility(8);
      break label97;
      label190:
      ((View)localObject1).setVisibility(8);
      break label129;
      label200:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131368571));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375635));
      a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout, i1, n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368479));
      a(1, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368586));
      a(2, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368471));
      a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368547));
      a(4, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
      if (this.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(alud.a(2131708875));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368474));
        a(15, this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368484));
        a(16, this.jdField_i_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
        a(null);
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368544));
        a(17, this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368546));
        a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 5, 5);
        i1 = -1;
        n = -1;
        m = 6;
        label495:
        if (m > 12) {
          break label557;
        }
        if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
          break label1304;
        }
        if (i1 >= 0) {
          break label1301;
        }
        i1 = m;
        if (n >= m) {
          break label1298;
        }
        n = m;
      }
      for (;;)
      {
        m += 1;
        break label495;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(alud.a(2131708864));
        break;
        label557:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131376917));
        a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368515));
        a(8, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          azqs.b(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376473));
        a(10, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376476));
        a(9, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370824));
        a(11, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376479));
        a(12, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        alto localalto;
        label970:
        boolean bool;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localalto = (alto)this.app.getManager(51);
          if (localalto == null)
          {
            localObject1 = null;
            Object localObject2;
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localObject2 = localalto.a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!bdeu.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
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
              if (localalto != null) {
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
              ((alpk)this.app.a(2)).x();
            }
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if ((localalto == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
                break label1265;
              }
              this.jdField_a_of_type_Boolean = localalto.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              label1057:
              d();
            }
            if ((localalto != null) && (localalto.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
              l();
            }
          }
        }
        for (;;)
        {
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719788));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717869));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131695570));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alud.a(2131708825));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690628));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alud.a(2131708835));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695659));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          }
          return;
          localObject1 = localalto.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break;
          label1237:
          localObject1 = this.jdField_c_of_type_JavaLangString;
          break label911;
          label1246:
          localObject1 = localalto.c(alof.aC);
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
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a(getTitleBarHeight()).show();
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
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839254));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839270));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839261));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839264));
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
    int n = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (alto)this.app.getManager(51);
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
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130845363));
    }
    int m;
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
      m = 0;
      while (m < paramBusinessCard.mobilesNum.size())
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append((String)paramBusinessCard.mobilesNum.get(m));
        m += 1;
      }
      localObject2 = ((alto)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label242:
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    label254:
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      m = n;
      if (((StringBuilder)localObject2).length() != 0)
      {
        ((StringBuilder)localObject2).append("，");
        m = n;
      }
      while (m < paramBusinessCard.descs.size())
      {
        ((StringBuilder)localObject2).append((String)paramBusinessCard.descs.get(m));
        m += 1;
      }
    }
    this.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    b((String)localObject1);
  }
  
  void a(Card paramCard)
  {
    if (this.jdField_a_of_type_Adcl != null) {
      this.jdField_a_of_type_Adcl.a(paramCard);
    }
  }
  
  void a(String paramString)
  {
    bhuf localbhuf = bhuf.a(this);
    if (bdeu.b(paramString)) {
      localbhuf.a(2131690509);
    }
    for (;;)
    {
      localbhuf.a(2131691571, 3);
      localbhuf.c(2131690648);
      localbhuf.a(new adod(this, paramString, localbhuf));
      localbhuf.show();
      return;
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        localbhuf.a(2131690511);
      } else {
        localbhuf.a(2131690510);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((alto)this.app.getManager(51)).b(paramString1);
    int m = 17;
    if (localObject1 != null) {
      m = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new azup(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + m;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + m;
    String str2 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + m;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((azup)localObject2).c(14).a(2).a(1).a(alud.a(2131708827) + paramString2).a("plugin", str2, "", (String)localObject3, str1).d(getResources().getString(2131719134)).a();
    localObject3 = new azxl();
    ((azut)localObject3).b(1);
    ((azut)localObject3).a(new azwv((String)localObject1));
    ((azut)localObject3).a(new StructMsgItemTitle(paramString2));
    ((azut)localObject3).a(new azzm(alud.a(2131708824) + bfyh.b(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a(alud.a(2131708872)));
    ((AbsShareMsg)localObject2).addItem((azus)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    aryv.a(this, paramString2, 21);
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (bdin.d(BaseApplication.getContext()))
    {
      auac localauac = (auac)this.app.getManager(16);
      if (localauac != null) {}
      for (;;)
      {
        int m;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          m = bddf.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localauac.b(m, (List)localObject);
            m = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            n = m;
            if (n == 0) {
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
            localauac.a(m, (List)localObject);
            continue;
            m = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          n = m;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              n = 1;
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
        a(2131720073, 1);
      }
      for (;;)
      {
        d();
        return;
        a(2131720075, 1);
      }
    }
    a(2131692398, 1);
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
        a(2131720074, 2);
      }
    }
    else
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label144;
      }
      alto localalto = (alto)this.app.getManager(51);
      if ((localalto == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label136;
      }
      this.jdField_a_of_type_Boolean = localalto.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      d();
      return;
      a(2131720087, 2);
      break;
      label112:
      if (paramBoolean2)
      {
        a(2131720073, 1);
        break;
      }
      a(2131720075, 1);
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
    auac localauac = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localauac = (auac)this.app.getManager(16);
      if (localauac == null) {
        break label162;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localauac.a((String)localObject);
      localObject = (alto)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = localauac; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((alto)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
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
    int m = 0;
    while (m < 18)
    {
      this.jdField_a_of_type_ArrayOfInt[m] = 0;
      m += 1;
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
        if (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ArrayOfInt[2] = 1;
          this.jdField_a_of_type_ArrayOfInt[11] = 1;
          this.jdField_a_of_type_ArrayOfInt[13] = 1;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfInt[0] = 1;
          if ((nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (bfyh.b(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
          {
            m = 1;
            label197:
            if (m != 0)
            {
              if (!((bfyh)this.app.getManager(165)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
                break label337;
              }
              this.jdField_a_of_type_ArrayOfInt[3] = 0;
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfInt[4] = 1;
            if (m == 0)
            {
              this.jdField_a_of_type_ArrayOfInt[5] = 1;
              this.jdField_a_of_type_ArrayOfInt[10] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[6] = 1;
            this.jdField_a_of_type_ArrayOfInt[7] = 1;
            if (autm.a(this.app.c())) {
              this.jdField_a_of_type_ArrayOfInt[8] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[9] = 1;
            this.jdField_a_of_type_ArrayOfInt[12] = 1;
            this.jdField_a_of_type_ArrayOfInt[13] = 1;
            this.jdField_a_of_type_ArrayOfInt[14] = 1;
            break;
            m = 0;
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
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
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
    Object localObject = (alto)this.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((alto)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  void c(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(bdea.a(this, "bc_remark_first"))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 8)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365511));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = aepi.a(10.0F, getResources()))
    {
      int m = paramInt2;
      if (paramInt2 < 0) {
        m = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, m, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      bdea.a(this, "bc_remark_first", "false");
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Adcl != null) {
      this.jdField_a_of_type_Adcl.a(paramArrayOfByte);
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
    while ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
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
        if (bdin.d(BaseApplication.getContext()))
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
              paramIntent = new bjuy();
              paramIntent.jdField_a_of_type_Int = 5;
              bjux.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a(paramIntent);
              return;
            }
            a(2131693628, 1);
            return;
          }
          a(2131693609, 0);
          return;
        }
        a(2131694829, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131720582));
        localObject = aepi.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
        if (this.jdField_a_of_type_Adcl == null) {
          break;
        }
        this.jdField_a_of_type_Adcl.b(paramInt2, paramIntent);
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
      this.jdField_a_of_type_Adcl = new adcl(this, this);
      this.jdField_a_of_type_Adcl.jdField_a_of_type_Int = getIntent().getIntExtra("coverTimeStamp", 0);
      this.jdField_a_of_type_Adcl.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("coverUrl");
      this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(this.app.c(), 0);
      }
      this.jdField_a_of_type_Anys = ((anys)this.app.getManager(112));
      addObserver(this.jdField_a_of_type_Alwx);
      addObserver(this.jdField_a_of_type_Amcm);
      addObserver(this.jdField_a_of_type_Alpq);
      addObserver(this.jdField_a_of_type_Altm);
      addObserver(this.jdField_a_of_type_Asim);
      this.app.registObserver(this.jdField_a_of_type_Anyt);
      this.app.setHandler(ProfileCardMoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      if ((this.jdField_d_of_type_JavaLangString == null) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
      }
      akfx.a(this.app);
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
    if (this.jdField_a_of_type_Adcl != null)
    {
      this.jdField_a_of_type_Adcl.a();
      this.jdField_a_of_type_Adcl = null;
    }
    f();
    removeObserver(this.jdField_a_of_type_Alwx);
    removeObserver(this.jdField_a_of_type_Amcm);
    removeObserver(this.jdField_a_of_type_Alpq);
    removeObserver(this.jdField_a_of_type_Altm);
    removeObserver(this.jdField_a_of_type_Asim);
    this.app.unRegistObserver(this.jdField_a_of_type_Anyt);
    this.app.removeHandler(ProfileCardMoreActivity.class);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Adcl != null)) {
      this.jdField_a_of_type_Adcl.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((alto)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label67;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131719649));
    }
    for (;;)
    {
      j();
      return;
      label67:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131719650));
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
      this.jdField_a_of_type_Bety.c(2131719785);
    }
    this.jdField_a_of_type_Bety.show();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.cancel();
      this.jdField_a_of_type_Bety = null;
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
    if ((this.jdField_a_of_type_Adcl != null) && (this.jdField_a_of_type_Adcl.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Adcl.jdField_a_of_type_ArrayOfByte);
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
    Object localObject1 = (alto)this.app.getManager(51);
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
        localObject1 = ((alto)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      int m;
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
          break label302;
        }
        m = 20005;
      }
      label302:
      label489:
      for (;;)
      {
        label119:
        if ((m == 20005) || (m == 20015) || (m == 25020)) {
          zdv.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, zdv.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, zdv.b(2)), str2, null, this.app.getCurrentAccountUin(), m, null, (Bundle)localObject1);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), Integer.valueOf(m), str2, str1, localObject1 }));
          }
          azqs.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          str2 = "0";
          break;
          int n;
          if (ProfileActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            n = 20008;
            m = n;
            if (localObject1 != null) {
              break label489;
            }
            localObject1 = zdv.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, 1);
            m = n;
            break label119;
          }
          if (ProfileActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            n = 20013;
            m = n;
            if (localObject1 != null) {
              break label489;
            }
            localObject1 = zdv.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString, 3000);
            m = n;
            break label119;
          }
          if (localObject1 != null)
          {
            if (((Bundle)localObject1).containsKey("chattype"))
            {
              m = zdv.a(((Bundle)localObject1).getInt("chattype"));
              break label119;
            }
            if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              m = 21000;
              break label119;
            }
            m = 20002;
            break label119;
          }
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            m = 21001;
            break label119;
          }
          m = 20001;
          break label119;
          zdv.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, null, str2, str1, this.app.getAccount(), m, null, (Bundle)localObject1);
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    int m = 1;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.app;
      if (paramBoolean)
      {
        m = 1;
        azqs.b(paramCompoundButton, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
        if (this.jdField_a_of_type_Boolean != paramBoolean) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      return;
      m = 2;
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
        if (bdin.d(BaseApplication.getContext()))
        {
          paramCompoundButton = (FriendListHandler)this.app.a(1);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramCompoundButton.a((short)1, (List)localObject, paramBoolean);
          if (paramBoolean)
          {
            azqs.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
            return;
          }
          azqs.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
          return;
        }
        a(2131692398, 1);
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
        if (bdin.d(BaseApplication.getContext()))
        {
          ((alpk)this.app.a(2)).m(paramBoolean);
          paramCompoundButton = this.app;
          if (paramBoolean) {}
          for (;;)
          {
            azqs.b(paramCompoundButton, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
            return;
            m = 0;
          }
        }
        a(2131692398, 1);
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
    if (!bdin.d(BaseApplication.getContext()))
    {
      a(2131692398, 1);
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
      l = ayzl.a();
      FriendsStatusUtil.b((QQAppInterface)localObject, str, 0, l, true, false);
      localObject = this.app;
      if (!paramCompoundButton.isChecked()) {
        break label629;
      }
    }
    label629:
    for (m = 1;; m = 2)
    {
      azqs.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
      return;
      l = 0L;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int m;
    if (paramView == null) {
      m = 0;
    }
    switch (m)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "case default do nothing");
      }
    case 2131368571: 
    case 2131368479: 
    case 2131368471: 
    case 2131368547: 
    case 2131365083: 
    case 2131377098: 
    case 2131368546: 
    case 2131376917: 
    case 2131368515: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              m = paramView.getId();
              break;
              bddf.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
              azqs.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              azqs.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
              return;
              c();
              azqs.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              return;
              if (Build.VERSION.SDK_INT >= 23)
              {
                if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0)
                {
                  requestPermissions(new adoa(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
                  return;
                }
                g();
                return;
              }
              g();
              return;
              if (((bfyh)this.app.getManager(165)).f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
              {
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = bdgc.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
                azqs.b(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
                return;
                if (this.jdField_a_of_type_Awqw == null) {
                  this.jdField_a_of_type_Awqw = new awqw(this, this.app, 0, new adob(this));
                }
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = bdgc.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                }
                this.jdField_a_of_type_Awqw.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
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
                paramView = bjea.a();
                paramView.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
                paramView.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
                bjdt.a(this, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
                azqs.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
                return;
              }
              catch (Exception paramView) {}
            } while (!QLog.isColorLevel());
            QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
            return;
            akfx.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 3);
            azqs.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
            return;
            azqs.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
            paramView = ((alto)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          } while (paramView == null);
          if ((paramView.intimate_type != 2) && (paramView.intimate_type != 3) && (paramView.intimate_type != 1)) {
            break label887;
          }
          paramView = new Intent();
          paramView.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          adpn.a(this, paramView, PublicFragmentActivity.class, IntimateInfoFragment.class);
        } while (!QLog.isColorLevel());
        QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
        return;
        paramView = autm.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, "click item_friend_intimate url:" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", paramView));
      return;
    case 2131368474: 
      paramView = new Intent(this, AvatarPendantActivity.class);
      paramView.putExtra("AllInOne", this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramView.putExtra("showActionSheet", true);
      startActivity(paramView);
      azqs.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
      return;
    case 2131368484: 
      label595:
      label887:
      if (this.jdField_a_of_type_Adcl != null)
      {
        paramView = this.jdField_a_of_type_Adcl;
        if (this.jdField_a_of_type_Adcl.jdField_a_of_type_Int != 0) {
          break label1090;
        }
      }
      label1090:
      for (boolean bool = true;; bool = false)
      {
        paramView.a(bool);
        azqs.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
        return;
      }
    }
    k();
    azqs.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */