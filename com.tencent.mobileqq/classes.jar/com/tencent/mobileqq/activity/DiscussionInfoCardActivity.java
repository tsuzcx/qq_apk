package com.tencent.mobileqq.activity;

import aaow;
import aaox;
import aaoy;
import aapb;
import aapc;
import aapd;
import aape;
import aapf;
import aapg;
import aaph;
import aapi;
import aapj;
import aapk;
import aapl;
import aapm;
import aapn;
import aciy;
import ajex;
import ajey;
import ajfo;
import ajgj;
import ajhf;
import ajhh;
import ajhi;
import ajjh;
import ajjj;
import ajjy;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apci;
import awqx;
import azlj;
import azsq;
import azvv;
import azwg;
import azwh;
import azzx;
import babh;
import babp;
import bacm;
import badq;
import bahv;
import bahx;
import baia;
import bant;
import bbhy;
import bbms;
import bbmy;
import bbsh;
import begr;
import behe;
import bepm;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import vms;
import vvp;

public class DiscussionInfoCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, azwh
{
  protected final int a;
  public long a;
  private aapm jdField_a_of_type_Aapm;
  ajey jdField_a_of_type_Ajey = new aapf(this);
  ajfo jdField_a_of_type_Ajfo = new aapb(this);
  private ajhf jdField_a_of_type_Ajhf;
  private ajhh jdField_a_of_type_Ajhh;
  ajhi jdField_a_of_type_Ajhi = new aaoy(this);
  ajjh jdField_a_of_type_Ajjh = new aaox(this);
  public Dialog a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  azwg jdField_a_of_type_Azwg;
  protected bahv a;
  public bbms a;
  protected bbsh a;
  public DiscussionInfo a;
  public FollowImageTextView a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  public String a;
  private List<DiscussionMemberInfo> jdField_a_of_type_JavaUtilList;
  public MqqHandler a;
  public boolean a;
  protected final int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private bbms jdField_b_of_type_Bbms;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  protected final int c;
  private FormSimpleItem c;
  public String c;
  protected final int d;
  private FormSimpleItem d;
  public String d;
  protected final int e;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_e_of_type_JavaLangString;
  protected int f;
  private String f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = 4;
  private final int m = 0;
  private final int n = 1;
  private final int o = 2;
  private final int p = 3;
  private final int q = 8;
  private final int r = 9;
  
  public DiscussionInfoCardActivity()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 11;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 2;
    this.jdField_a_of_type_MqqOsMqqHandler = new aapl(this);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    awqx.b(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    awqx.b(paramQQAppInterface, "CliOper", "", "", "0X800666F", "0X800666F", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      paramString1 = ajjy.a(2131637565) + paramString2 + "】:\n" + paramString1;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString1);
      }
      for (;;)
      {
        bbmy.a(paramQQAppInterface, 2, ajjy.a(2131637552), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131167766));
        return;
        ((android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramString1));
      }
    }
    bbmy.a(paramQQAppInterface, 2, ajjy.a(2131637573), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131167766));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, bbms parambbms)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (parambbms != null)) {}
    try
    {
      parambbms.show();
      awqx.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      awqx.b(paramQQAppInterface, "CliOper", "", "", "0X800666B", "0X800666B", 0, 0, "", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        ThreadManager.post(new DiscussionInfoCardActivity.17(paramLong, paramQQAppInterface, paramString2, str, paramString3, paramString1, paramActivity, paramInt, parambbms), 5, null, true);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiscussionInfoCardActivity", 2, localException.toString());
        }
      }
      if ((parambbms != null) && (parambbms.isShowing())) {
        parambbms.dismiss();
      }
      bbmy.a(paramActivity, -1, ajjy.a(2131637559), 0).b(paramActivity.getResources().getDimensionPixelSize(2131167766));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    awqx.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    awqx.b(paramQQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
    ThreadManager.post(new DiscussionInfoCardActivity.18(paramString2, paramActivity, paramString1, String.format(paramActivity.getString(2131626255), new Object[] { paramString3 }), paramQQAppInterface), 5, null, false);
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    int i3 = (int)(this.mDensity * 20.0F);
    int i1 = (int)(this.mDensity * 20.0F);
    int i4 = (int)(66.0F * this.mDensity);
    int i5 = (int)(50.0F * this.mDensity);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1) + (i4 - i5) / 2;
    i3 = (int)(this.mDensity * 20.0F);
    this.jdField_h_of_type_Int = i2;
    this.i = i2;
    this.j = i3;
    this.k = i3;
    this.l = i1;
    paramMyGridView.setPadding(this.jdField_h_of_type_Int, this.j, this.i, this.k);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839151);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setText(paramCharSequence);
    if (AppSetting.c) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setContentDescription(ajjy.a(2131637563) + paramCharSequence + ajjy.a(2131637574));
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: aload_0
    //   6: invokevirtual 414	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:getMainLooper	()Landroid/os/Looper;
    //   9: invokevirtual 419	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   12: if_acmpne +21 -> 33
    //   15: new 421	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$5
    //   18: dup
    //   19: aload_0
    //   20: iload_1
    //   21: invokespecial 424	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$5:<init>	(Lcom/tencent/mobileqq/activity/DiscussionInfoCardActivity;Z)V
    //   24: iconst_5
    //   25: aconst_null
    //   26: iconst_0
    //   27: invokestatic 303	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 125	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_a_of_type_Ajhh	Lajhh;
    //   37: aload_0
    //   38: getfield 140	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokevirtual 429	ajhh:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 432	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:a	(Ljava/util/List;)V
    //   50: iload_1
    //   51: ifeq -21 -> 30
    //   54: new 434	ajhg
    //   57: dup
    //   58: invokespecial 435	ajhg:<init>	()V
    //   61: astore_3
    //   62: aload_3
    //   63: aload_0
    //   64: getfield 140	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: putfield 441	ajhg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_3
    //   74: aload_2
    //   75: invokeinterface 446 1 0
    //   80: putfield 447	ajhg:jdField_b_of_type_Int	I
    //   83: aload_0
    //   84: getfield 122	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_a_of_type_Ajhf	Lajhf;
    //   87: aload_3
    //   88: invokevirtual 452	ajhf:a	(Lajhg;)V
    //   91: goto -61 -> 30
    //   94: astore_2
    //   95: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -68 -> 30
    //   101: ldc_w 311
    //   104: iconst_2
    //   105: new 186	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 454
    //   115: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 140	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload_2
    //   129: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: goto -102 -> 30
    //   135: astore_2
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	DiscussionInfoCardActivity
    //   0	140	1	paramBoolean	boolean
    //   44	31	2	localArrayList	ArrayList
    //   94	35	2	localException	Exception
    //   135	4	2	localObject	Object
    //   61	27	3	localajhg	ajhg
    // Exception table:
    //   from	to	target	type
    //   54	91	94	java/lang/Exception
    //   2	30	135	finally
    //   33	50	135	finally
    //   54	91	135	finally
    //   95	132	135	finally
  }
  
  private void j()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    }
    this.g = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Ajhh = ((ajhh)this.app.getManager(53));
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = this.jdField_a_of_type_Ajhh.a(this.jdField_f_of_type_JavaLangString);
    l();
    setContentBackgroundResource(2130838503);
  }
  
  private void k()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
    if (localWebProcessManager == null) {}
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.d());
      localWebProcessManager.e();
    } while (!QLog.isColorLevel());
    QLog.d("DiscussionInfoCardActivity", 2, "start preloadWebProcess");
  }
  
  private void l()
  {
    Object localObject2 = (XListView)View.inflate(this, 2131493599, null);
    try
    {
      ((XListView)localObject2).setBackgroundResource(2130838503);
      ((XListView)localObject2).setDivider(null);
      ((XListView)localObject2).setVerticalScrollBarEnabled(false);
      ((XListView)localObject2).setPadding(0, 0, 0, 0);
      View localView = View.inflate(this, 2131493204, null);
      ((XListView)localObject2).setAdapter(new bepm(localView));
      setContentView((View)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131311748));
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131299669);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131304185));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131304183));
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
      this.jdField_a_of_type_Azwg = new azwg(this, this.app);
      this.jdField_a_of_type_Azwg.a(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131312063));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView = ((FollowImageTextView)localView.findViewById(2131312041));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextColor(getResources().getColor(2131101263));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextSize(1, 23.0F);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxLines(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxWidth((int)babp.i() - vms.a(this, 88.5F));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageResource(2130843168);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageWH(vms.a(this, 14.0F), vms.a(this, 15.0F));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131298507));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131309121));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131310156));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131299678));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131304088));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131299680));
      i();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnClickListener(new aaow(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnTouchListener(new aapg(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aaph(this));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      setTitle(2131625182);
      setLeftViewName(2131624770);
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(this);
      this.rightViewImg.setBackgroundResource(2130839708);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
      {
        a(1, getString(2131626279));
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView mDiscussionInfo is null,try to get getDiscuss");
        }
        this.jdField_a_of_type_Ajhf.f(this.app.getLongAccountUin());
        finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("DiscussionInfoCardActivity", 1, localThrowable.toString());
      }
      localObject2 = (ajjj)this.app.getManager(51);
      if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null) && (!((ajjj)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
        ((FriendListHandler)this.app.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "", false);
      }
      a(this.jdField_e_of_type_JavaLangString);
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "DiscussionInfo.DiscussionFlag:" + this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.DiscussionFlag);
      }
      v();
      this.jdField_a_of_type_Ajhf = ((ajhf)this.app.a(6));
      boolean bool = this.jdField_a_of_type_Ajhf.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aapi(this));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (this.app != null) && (this.app.getCurrentAccountUin() != null)) {
        if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        }
      }
      Object localObject1;
      for (;;)
      {
        if (AppSetting.c)
        {
          this.rightViewImg.setContentDescription(getString(2131632046));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131637575));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131625153));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131625150));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653475));
          localObject2 = getString(2131630785);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
          localObject2 = getString(2131626293);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.isDiscussHrMeeting()) {
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        }
        a(true);
        this.jdField_a_of_type_AndroidViewView = localThrowable.findViewById(2131298679);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839151);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131302466).setVisibility(4);
        localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = azvv.a(this, 30.0F);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311534);
        ((TextView)localObject1).setText(ajjy.a(2131637550));
        localObject2 = this.app.a().a(this.jdField_f_of_type_JavaLangString, 3000);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          break;
        }
        ((TextView)localObject1).setTextColor(Color.parseColor("#cccccc"));
        return;
        if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        }
      }
      ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
    }
  }
  
  private void m()
  {
    a(false);
  }
  
  private void n()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void o()
  {
    awqx.b(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    azzx.a("Grp_Dis_set", "Dis_info", "clk_editName", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131626296);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("limit", 48);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("action", 102);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("current", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("canPostNull", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("multiLine", false);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
  }
  
  private void p()
  {
    awqx.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    azzx.a("Grp_Dis_set", "Dis_info", "clk_chatRecord", 1, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.g);
    startActivityForResult(localIntent, 1000);
  }
  
  private void q()
  {
    apci.a("0X8004E02");
    awqx.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    azzx.a("Grp_Dis_set", "Dis_info", "clk_file", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.g);
    localIntent.putExtra("uinname", this.jdField_e_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  private void r()
  {
    awqx.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.g);
    localIntent.putExtra("bg_replace_entrance", 62);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bant.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void s()
  {
    awqx.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    azzx.a("Grp_Dis_set", "Dis_info", "clk_delMber", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString });
    Intent localIntent = TroopMemberListActivity.a(this, this.jdField_f_of_type_JavaLangString, 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void t()
  {
    begr localbegr = (begr)behe.a(this, null);
    localbegr.a(2131626624);
    localbegr.c(getString(2131626623));
    localbegr.c(2131625035);
    localbegr.a(new aapd(this, localbegr));
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
    azzx.a("Grp_Dis_set", "Dis_info", "clk_quitgrp", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
  }
  
  private void u()
  {
    Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.g);
    localIntent.putExtra("isNeedUpdate", this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void v()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ajhh != null)
    {
      DiscussionMemberInfo localDiscussionMemberInfo = this.jdField_a_of_type_Ajhh.a(this.jdField_f_of_type_JavaLangString, this.app.getCurrentAccountUin());
      if (localDiscussionMemberInfo == null) {
        break label105;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag:" + localDiscussionMemberInfo.flag);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if ((localDiscussionMemberInfo.flag & 0x1) != 0) {
          bool = true;
        }
        localFormSwitchItem.setChecked(bool);
      }
    }
    label105:
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null)
    {
      FormSwitchItem localFormSwitchItem;
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bbmy.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(aapn paramaapn, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaapn.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Azwg.b(paramaapn.jdField_a_of_type_Int, paramaapn.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bacm.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramaapn.jdField_a_of_type_JavaLangString, paramaapn.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaapn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131311058);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.isDiscussHrMeeting()) && (!((String)localObject).equals(getString(2131628030))));
      if (!((String)localObject).equals(getString(2131628030))) {
        break;
      }
    } while (3000 != this.g);
    paramView = new Intent(this, SelectMemberActivity.class);
    localObject = ((ajhh)this.app.getManager(53)).a(this.jdField_f_of_type_JavaLangString);
    if (localObject != null) {
      paramView.putStringArrayListExtra("param_uins_selected_default", new ArrayList(((Map)localObject).keySet()));
    }
    paramView.putExtra("param_groupcode", this.jdField_f_of_type_JavaLangString);
    paramView.putExtra("param_type", 3000);
    paramView.putExtra("param_subtype", 1);
    if (localObject != null) {}
    for (int i1 = ((Map)localObject).size();; i1 = 0)
    {
      paramView.putExtra("param_max", 100 - i1);
      startActivityForResult(paramView, 2);
      awqx.b(this.app, "CliOper", "", "", "0X800629A", "0X800629A", 0, 0, "", "", "", "");
      azzx.a("Grp_Dis_set", "Dis_info", "clk_invite_new", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      return;
    }
    if (((String)localObject).equals(this.app.getCurrentAccountUin()))
    {
      paramView = new ProfileActivity.AllInOne((String)localObject, 0);
      paramView.g = 5;
      paramView.jdField_h_of_type_Int = 57;
      ProfileActivity.a(this, paramView, 3);
    }
    for (;;)
    {
      azzx.a("Grp_Dis_set", "Dis_info", "clk_mberHead", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      return;
      if (!((ajjj)this.app.getManager(51)).b((String)localObject)) {
        break;
      }
      paramView = new ProfileActivity.AllInOne((String)localObject, 45);
      paramView.jdField_h_of_type_JavaLangString = babh.a(this.app, (String)localObject, 0);
      if (3000 != this.g)
      {
        paramView.jdField_f_of_type_JavaLangString = ((String)localObject);
        paramView.jdField_e_of_type_Int = this.g;
      }
      paramView.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      paramView.g = 5;
      paramView.jdField_h_of_type_Int = 57;
      ProfileActivity.a(this, paramView, 3);
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)localObject, 46);
    if (this.g == 3000)
    {
      localAllInOne.jdField_a_of_type_Int = 46;
      label468:
      localAllInOne.jdField_h_of_type_JavaLangString = paramView;
      localAllInOne.jdField_f_of_type_JavaLangString = ((String)localObject);
      localAllInOne.jdField_e_of_type_Int = this.g;
      if (3000 != this.g) {
        break label655;
      }
      localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    }
    for (;;)
    {
      localAllInOne.g = 5;
      localAllInOne.jdField_h_of_type_Int = 57;
      ProfileActivity.a(this, localAllInOne, 3);
      break;
      if (this.g == 1000)
      {
        localAllInOne.jdField_a_of_type_Int = 22;
        localAllInOne.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
        break label468;
      }
      if (this.g == 1001)
      {
        localAllInOne.jdField_a_of_type_Int = 42;
        break label468;
      }
      if (this.g == 10002)
      {
        localAllInOne.jdField_a_of_type_Int = 86;
        break label468;
      }
      if (this.g == 1005)
      {
        localAllInOne.jdField_a_of_type_Int = 2;
        break label468;
      }
      if (this.g == 1023)
      {
        localAllInOne.jdField_a_of_type_Int = 74;
        break label468;
      }
      localAllInOne.jdField_a_of_type_Int = 19;
      break label468;
      label655:
      if (1000 == this.g) {
        localAllInOne.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_Bbms = new bbms(this, getTitleBarHeight());
    this.jdField_b_of_type_Bbms.setContentView(2131496755);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_b_of_type_Bbms.a(getString(2131653452));
      return;
    }
    this.jdField_b_of_type_Bbms.a(paramString);
  }
  
  void a(List<DiscussionMemberInfo> paramList)
  {
    ArrayList localArrayList;
    Object localObject;
    int i2;
    DiscussionMemberInfo localDiscussionMemberInfo1;
    int i1;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      localObject = (ajjj)this.app.getManager(51);
      localObject = null;
      i2 = 0;
      if (i2 < paramList.size())
      {
        localDiscussionMemberInfo1 = (DiscussionMemberInfo)paramList.get(i2);
        if (localDiscussionMemberInfo1 != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (localDiscussionMemberInfo1.memberUin != null)) {
            if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin))) {
              i1 = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      label108:
      if (i1 != 0)
      {
        localObject = new DiscussionMemberInfo();
        ((DiscussionMemberInfo)localObject).memberUin = localDiscussionMemberInfo1.memberUin;
        ((DiscussionMemberInfo)localObject).memberName = babh.a(localDiscussionMemberInfo1, this.app);
      }
      for (;;)
      {
        i2 += 1;
        break;
        if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) || (!localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
          break label311;
        }
        i1 = 1;
        break label108;
        DiscussionMemberInfo localDiscussionMemberInfo2 = new DiscussionMemberInfo();
        localDiscussionMemberInfo2.memberUin = localDiscussionMemberInfo1.memberUin;
        localDiscussionMemberInfo2.memberName = babh.a(localDiscussionMemberInfo1, this.app);
        localDiscussionMemberInfo2.discussionUin = ChnToSpell.a(localDiscussionMemberInfo2.memberName, 1);
        localArrayList.add(localDiscussionMemberInfo2);
      }
      Collections.sort(localArrayList, new ajgj());
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      if ((localArrayList.size() > 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localArrayList).sendToTarget();
      }
      return;
      label311:
      i1 = 0;
    }
  }
  
  boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  public void b()
  {
    awqx.b(this.app, "CliOper", "", this.jdField_f_of_type_JavaLangString, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    azzx.a("Grp_Dis_set", "Dis_info", "clk_share", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    if (this.jdField_a_of_type_Bahv == null)
    {
      this.jdField_a_of_type_Bahv = new bahv(this);
      this.jdField_a_of_type_Bahv.a(getString(2131653614));
      this.jdField_a_of_type_Bahv.a(azsq.a(this, true));
      this.jdField_a_of_type_Bahv.a(this);
    }
    try
    {
      this.jdField_a_of_type_Bahv.a();
      SharedPreferences localSharedPreferences = getSharedPreferences("qrcode", 0);
      this.jdField_a_of_type_Long = localSharedPreferences.getLong("discussionvalidtime" + this.jdField_f_of_type_JavaLangString, 0L);
      this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("discussion" + this.jdField_f_of_type_JavaLangString, null);
      this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("discussionfullSig" + this.jdField_f_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Long - System.currentTimeMillis() / 1000L > 0L)
      {
        i1 = 1;
        if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString == null) || (i1 == 0)) {
          break label354;
        }
        this.jdField_a_of_type_Boolean = true;
        awqx.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
          continue;
          i1 = 0;
          continue;
          label354:
          if (QLog.isDevelopLevel()) {
            QLog.d("DiscussionInfoCardActivity", 4, "qrcode url not valid");
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Ajhf.a(Long.parseLong(this.jdField_f_of_type_JavaLangString), true);
        }
      }
    }
  }
  
  protected void c()
  {
    awqx.b(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
    azzx.a("Grp_Dis_set", "Dis_info", "clk_qrcode", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.jdField_a_of_type_AndroidContentIntent = new Intent(getActivity(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", ajjy.a(2131637555));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    Object localObject = this.jdField_a_of_type_Ajhf.a(this.jdField_f_of_type_JavaLangString, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_Ajhi);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      return;
    }
    azzx.a("Grp_Dis_set", "Dis_info", "clk_upgrade", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    switch (this.jdField_f_of_type_Int)
    {
    default: 
      return;
    case 0: 
      e();
      return;
    case 1: 
      awqx.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "Clk_grptab", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), "", "", "");
      azlj.a(this, TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16), 2);
      return;
    }
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16);
    localBundle.putInt("D2GType", 1);
    azlj.a(this, localBundle, 2);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscussionInfoCardActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
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
          do
          {
            return;
          } while (this.jdField_a_of_type_Aapm == null);
          this.jdField_a_of_type_Aapm.notifyDataSetChanged();
          return;
          u();
          finish();
          return;
          setResult(-1);
          this.jdField_b_of_type_Boolean = true;
          return;
          addObserver(this.jdField_a_of_type_Ajhi);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.jdField_e_of_type_JavaLangString)));
        if (badq.d(this))
        {
          this.jdField_a_of_type_Ajhf.a(Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue(), (String)localObject);
          a((CharSequence)localObject);
          a(getString(2131625107));
          this.jdField_b_of_type_Bbms.show();
          return;
        }
        a(1, getString(2131629008));
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          awqx.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        }
        Object localObject = aciy.a(new Intent(this, SplashActivity.class), null);
        paramIntent = paramIntent.getLongExtra("roomId", 0L) + "";
        ((Intent)localObject).putExtra("uin", paramIntent);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", babh.a(this.app, getApplicationContext(), paramIntent));
        ((Intent)localObject).putExtra("isBack2Root", true);
        startActivity((Intent)localObject);
        finish();
        return;
        localObject = aciy.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Aapm == null);
    this.jdField_a_of_type_Aapm.notifyDataSetChanged();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_Ajhf = ((ajhf)this.app.a(6));
    addObserver(this.jdField_a_of_type_Ajjh);
    addObserver(this.jdField_a_of_type_Ajhi);
    addObserver(this.jdField_a_of_type_Ajfo);
    addObserver(this.jdField_a_of_type_Ajey);
    this.app.setHandler(DiscussionInfoCardActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    j();
    k();
    azzx.a("Grp_Dis_set", "Dis_info", "exp", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_b_of_type_Bbms != null) && (this.jdField_b_of_type_Bbms.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_Bbms.dismiss();
        this.jdField_b_of_type_Bbms = null;
      }
      removeObserver(this.jdField_a_of_type_Ajjh);
      removeObserver(this.jdField_a_of_type_Ajhi);
      removeObserver(this.jdField_a_of_type_Ajfo);
      removeObserver(this.jdField_a_of_type_Ajey);
      this.app.removeHandler(DiscussionInfoCardActivity.class);
      if (this.jdField_a_of_type_Azwg != null)
      {
        this.jdField_a_of_type_Azwg.d();
        this.jdField_a_of_type_Azwg = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (this.jdField_a_of_type_Bbsh != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
        this.jdField_a_of_type_Bbsh = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void doOnPause()
  {
    n();
    super.doOnPause();
  }
  
  protected void e()
  {
    begr localbegr = begr.a(this);
    localbegr.b(2131626362);
    localbegr.c(2131625035);
    localbegr.a(new aape(this, localbegr));
    localbegr.show();
  }
  
  public void f()
  {
    try
    {
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).longValue();
      ajex localajex = (ajex)this.app.a(22);
      if (localajex == null) {
        return;
      }
      localajex.a(l1);
      g();
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
      this.jdField_a_of_type_Bbms.c(2131654683);
    }
    if (!this.jdField_a_of_type_Bbms.isShowing()) {
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  public void i()
  {
    int i1 = 2131626362;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupUin == 0L))
      {
        this.jdField_f_of_type_Int = 0;
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131626362));
      }
      while (AppSetting.c)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(i1));
        return;
        TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
        if (localTroopManager == null)
        {
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          return;
        }
        if (localTroopManager.b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode)) != null)
        {
          this.jdField_f_of_type_Int = 1;
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131626364));
          i1 = 2131626364;
        }
        else
        {
          this.jdField_f_of_type_Int = 2;
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131626369));
          i1 = 2131626369;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    switch (paramView.getId())
    {
    default: 
      a(paramView);
      return;
    case 2131312063: 
      c();
      return;
    case 2131298507: 
      p();
      return;
    case 2131309121: 
      q();
      return;
    case 2131310156: 
      r();
      return;
    case 2131299680: 
      d();
      return;
    case 2131304088: 
      s();
      return;
    case 2131302816: 
      paramView = begr.a(this);
      paramView.c(getString(2131630792));
      paramView.b(2131625060);
      paramView.a(getString(2131630743), 3);
      paramView.b(2131625035);
      paramView.a(new aapj(this, paramView));
      paramView.show();
      azzx.a("Grp_Dis_set", "Dis_info", "clk_upright", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, azzx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      return;
    }
    paramView = this.app.a().a(this.jdField_f_of_type_JavaLangString, 3000);
    if ((paramView == null) || (paramView.isEmpty()))
    {
      bbmy.a(this, 1, getString(2131654497), 0).a();
      return;
    }
    paramView = new bbhy(this, this.app, false);
    paramView.a(new aapk(this));
    paramView.a(2);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof aapn)))
        {
          localObject = (aapn)localObject;
          if (paramString != null) {
            break label72;
          }
          a((aapn)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((aapn)localObject).jdField_a_of_type_JavaLangString))
        {
          paramInt1 += 1;
          break;
        }
        ((aapn)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(2130839278, ajjy.a(2131637570));
      this.jdField_a_of_type_Bahv.b();
    }
    do
    {
      return;
      paramAdapterView = paramView.getTag();
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Bahv.b();
    switch (((baia)paramAdapterView).a.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(this.app, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      return;
    case 2: 
      g();
      paramAdapterView = this.jdField_a_of_type_Ajhh.a(this.jdField_f_of_type_JavaLangString);
      if (paramAdapterView == null) {
        break;
      }
    }
    for (paramInt = paramAdapterView.size();; paramInt = 0)
    {
      a(this.app, this, 11, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramInt, this.jdField_a_of_type_Bbms);
      return;
      a(this.app, this, this.jdField_b_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      return;
      int i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131655008;
      }
      while (i1 != -1)
      {
        vvp.a(1, i1);
        return;
        if (!WXShareHelper.a().b()) {
          i1 = 2131655009;
        }
      }
      if (this.jdField_a_of_type_Bbsh == null)
      {
        this.jdField_a_of_type_Bbsh = new aapc(this);
        WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
      }
      paramView = this.app;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        awqx.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        if (paramInt != 2) {
          break label508;
        }
        awqx.b(this.app, "CliOper", "", "", "0X800666D", "0X800666D", 0, 0, "", "", "", "");
        label358:
        this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        paramAdapterView = this.jdField_a_of_type_Ajhf.a(this.jdField_f_of_type_JavaLangString, true);
        if (!(paramAdapterView instanceof BitmapDrawable)) {
          break label550;
        }
      }
      label550:
      for (paramAdapterView = ((BitmapDrawable)paramAdapterView).getBitmap();; paramAdapterView = null)
      {
        paramAdapterView = azsq.a(paramAdapterView);
        paramView = WXShareHelper.a();
        String str1 = this.jdField_a_of_type_JavaLangString;
        String str2 = ForwardUtils.a(this.app, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
        String str3 = ajjy.a(2131637553) + babh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin);
        String str4 = this.jdField_b_of_type_JavaLangString;
        if (paramInt == 2) {}
        for (paramInt = 0;; paramInt = 1)
        {
          paramView.b(str1, str2, paramAdapterView, str3, str4, paramInt);
          return;
          paramAdapterView = "0";
          break;
          label508:
          awqx.b(this.app, "CliOper", "", "", "0X800666E", "0X800666E", 0, 0, "", "", "", "");
          break label358;
        }
        c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */