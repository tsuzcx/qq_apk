package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ContactSorter.DiscussionMemberComparator;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class DiscussionInfoCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, DecodeTaskCompletionListener
{
  protected final int a;
  protected long a;
  protected Dialog a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiscussionInfoCardActivity.ListAdapter jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new DiscussionInfoCardActivity.15(this);
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new DiscussionInfoCardActivity.11(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new DiscussionInfoCardActivity.10(this);
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  protected DiscussionInfo a;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new DiscussionInfoCardActivity.12(this);
  protected FollowImageTextView a;
  protected ShareActionSheetBuilder a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  protected QQProgressDialog a;
  protected WXShareHelper.WXShareListener a;
  protected String a;
  private List<DiscussionMemberInfo> jdField_a_of_type_JavaUtilList;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new DiscussionInfoCardActivity.9(this);
  protected boolean a;
  protected final int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected String b;
  private boolean jdField_b_of_type_Boolean = false;
  protected final int c;
  private FormSimpleItem c;
  protected String c;
  protected final int d;
  private FormSimpleItem d;
  protected String d;
  protected final int e;
  private String e;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int g = 0;
  private int h;
  private int i = 0;
  private int j = 0;
  private int k = 4;
  private final int l = 0;
  private final int m = 1;
  private final int n = 2;
  private final int o = 3;
  private final int p = 8;
  private final int q = 9;
  
  public DiscussionInfoCardActivity()
  {
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 11;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666F", "0X800666F", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      paramString1 = HardCodeUtil.a(2131703383) + paramString2 + "】:\n" + paramString1;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString1);
      }
      for (;;)
      {
        QQToast.a(paramQQAppInterface, 2, HardCodeUtil.a(2131703370), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131299166));
        return;
        ((android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramString1));
      }
    }
    QQToast.a(paramQQAppInterface, 2, HardCodeUtil.a(2131703391), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131299166));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramQQProgressDialog != null)) {}
    try
    {
      paramQQProgressDialog.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666B", "0X800666B", 0, 0, "", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        ThreadManager.post(new DiscussionInfoCardActivity.16(paramLong, paramQQAppInterface, paramString2, str, paramString3, paramString1, paramActivity, paramInt, paramQQProgressDialog), 5, null, true);
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
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      QQToast.a(paramActivity, -1, HardCodeUtil.a(2131703377), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299166));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
    ThreadManager.post(new DiscussionInfoCardActivity.17(paramString2, paramActivity, paramString1, String.format(paramActivity.getString(2131691847), new Object[] { paramString3 }), paramQQAppInterface), 5, null, false);
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
    this.g = i2;
    this.jdField_h_of_type_Int = i2;
    this.i = i3;
    this.j = i3;
    this.k = i1;
    paramMyGridView.setPadding(this.g, this.i, this.jdField_h_of_type_Int, this.j);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839582);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setText(paramCharSequence);
    if (AppSetting.d) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setContentDescription(HardCodeUtil.a(2131703381) + paramCharSequence + HardCodeUtil.a(2131703392));
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 413	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: aload_0
    //   6: invokevirtual 417	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:getMainLooper	()Landroid/os/Looper;
    //   9: invokevirtual 422	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   12: if_acmpne +21 -> 33
    //   15: new 424	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$5
    //   18: dup
    //   19: aload_0
    //   20: iload_1
    //   21: invokespecial 427	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$5:<init>	(Lcom/tencent/mobileqq/activity/DiscussionInfoCardActivity;Z)V
    //   24: iconst_5
    //   25: aconst_null
    //   26: iconst_0
    //   27: invokestatic 314	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 139	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_a_of_type_ComTencentMobileqqAppDiscussionManager	Lcom/tencent/mobileqq/app/DiscussionManager;
    //   37: aload_0
    //   38: getfield 151	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokevirtual 432	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 435	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:a	(Ljava/util/List;)V
    //   50: iload_1
    //   51: ifeq -21 -> 30
    //   54: new 437	com/tencent/mobileqq/app/DiscussionHandler$ReqDiscussInfo
    //   57: dup
    //   58: invokespecial 438	com/tencent/mobileqq/app/DiscussionHandler$ReqDiscussInfo:<init>	()V
    //   61: astore_3
    //   62: aload_3
    //   63: aload_0
    //   64: getfield 151	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokestatic 442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: putfield 444	com/tencent/mobileqq/app/DiscussionHandler$ReqDiscussInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_3
    //   74: aload_2
    //   75: invokeinterface 449 1 0
    //   80: putfield 450	com/tencent/mobileqq/app/DiscussionHandler$ReqDiscussInfo:jdField_b_of_type_Int	I
    //   83: aload_0
    //   84: getfield 136	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   87: aload_3
    //   88: invokevirtual 455	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler$ReqDiscussInfo;)V
    //   91: goto -61 -> 30
    //   94: astore_2
    //   95: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -68 -> 30
    //   101: ldc_w 322
    //   104: iconst_2
    //   105: new 197	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 457
    //   115: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 151	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload_2
    //   129: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   61	27	3	localReqDiscussInfo	com.tencent.mobileqq.app.DiscussionHandler.ReqDiscussInfo
    // Exception table:
    //   from	to	target	type
    //   54	91	94	java/lang/Exception
    //   2	30	135	finally
    //   33	50	135	finally
    //   54	91	135	finally
    //   95	132	135	finally
  }
  
  private void f()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_f_of_type_JavaLangString);
    h();
    setContentBackgroundResource(2130838979);
  }
  
  private void g()
  {
    IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess()))
    {
      localIWebProcessManagerService.startWebProcess(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionInfoCardActivity", 2, "start preloadWebProcess");
      }
    }
  }
  
  private void h()
  {
    Object localObject2 = (XListView)View.inflate(this, 2131559411, null);
    try
    {
      ((XListView)localObject2).setBackgroundResource(2130838979);
      ((XListView)localObject2).setDivider(null);
      ((XListView)localObject2).setVerticalScrollBarEnabled(false);
      ((XListView)localObject2).setPadding(0, 0, 0, 0);
      View localView = View.inflate(this, 2131558942, null);
      ((XListView)localObject2).setAdapter(new XSimpleListAdapter(localView));
      setContentView((View)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131379660));
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365894);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371122));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131371120));
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131380019));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView = ((FollowImageTextView)localView.findViewById(2131379987));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextColor(getResources().getColor(2131167036));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextSize(1, 23.0F);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxLines(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxWidth((int)DeviceInfoUtil.i() - UIUtils.a(this, 88.5F));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageResource(2130844101);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageWH(UIUtils.a(this, 14.0F), UIUtils.a(this, 15.0F));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131364588));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131376662));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131377860));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131365900));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131371020));
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnClickListener(new DiscussionInfoCardActivity.1(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnTouchListener(new DiscussionInfoCardActivity.2(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new DiscussionInfoCardActivity.3(this));
      setTitle(2131690889);
      setLeftViewName(2131690601);
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(this);
      this.rightViewImg.setBackgroundResource(2130840482);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
      {
        a(1, getString(2131691859));
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView mDiscussionInfo is null,try to get getDiscuss");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.f(this.app.getLongAccountUin());
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
      localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null) && (!((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
        ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "", false);
      }
      a(this.jdField_e_of_type_JavaLangString);
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "DiscussionInfo.DiscussionFlag:" + this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.DiscussionFlag);
      }
      r();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new DiscussionInfoCardActivity.4(this));
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
        if (AppSetting.d)
        {
          this.rightViewImg.setContentDescription(getString(2131697517));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131703393));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690865));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690862));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719067));
          localObject2 = getString(2131696173);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
          localObject2 = getString(2131691869);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
        }
        a(true);
        this.jdField_a_of_type_AndroidViewView = localThrowable.findViewById(2131364779);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839582);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131369051).setVisibility(4);
        localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this, 30.0F);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379432);
        ((TextView)localObject1).setText(HardCodeUtil.a(2131703368));
        localObject2 = this.app.getMessageFacade().a(this.jdField_f_of_type_JavaLangString, 3000);
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
  
  private void i()
  {
    a(false);
  }
  
  private void j()
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
  
  private void k()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_editName", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131691870);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("limit", 48);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("action", 102);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("current", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("canPostNull", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("multiLine", false);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
  }
  
  private void l()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_chatRecord", 1, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_f_of_type_Int);
    startActivityForResult(localIntent, 1000);
  }
  
  private void m()
  {
    FileManagerReporter.a("0X8004E02");
    ReportController.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_file", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_f_of_type_Int);
    localIntent.putExtra("uinname", this.jdField_e_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  private void n()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_f_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_delMber", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString });
    Intent localIntent = TroopMemberListActivity.a(this, this.jdField_f_of_type_JavaLangString, 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void p()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setMainTitle(2131692164);
    localActionSheet.addButton(getString(2131692163));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new DiscussionInfoCardActivity.14(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_quitgrp", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
  }
  
  private void q()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_f_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void r()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager != null)
    {
      DiscussionMemberInfo localDiscussionMemberInfo = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_f_of_type_JavaLangString, this.app.getCurrentAccountUin());
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
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131378909);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.isDiscussHrMeeting()) && (!((String)localObject).equals(getString(2131693523))));
      if (!((String)localObject).equals(getString(2131693523))) {
        break;
      }
    } while (3000 != this.jdField_f_of_type_Int);
    paramView = new Intent(this, SelectMemberActivity.class);
    localObject = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_f_of_type_JavaLangString);
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
      ReportController.b(this.app, "CliOper", "", "", "0X800629A", "0X800629A", 0, 0, "", "", "", "");
      TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_invite_new", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
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
      TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_mberHead", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      return;
      if (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject)) {
        break;
      }
      paramView = new ProfileActivity.AllInOne((String)localObject, 45);
      paramView.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, (String)localObject, 0);
      if (3000 != this.jdField_f_of_type_Int)
      {
        paramView.jdField_f_of_type_JavaLangString = ((String)localObject);
        paramView.jdField_e_of_type_Int = this.jdField_f_of_type_Int;
      }
      paramView.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      paramView.g = 5;
      paramView.jdField_h_of_type_Int = 57;
      ProfileActivity.a(this, paramView, 3);
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)localObject, 46);
    if (this.jdField_f_of_type_Int == 3000)
    {
      localAllInOne.jdField_a_of_type_Int = 46;
      label470:
      localAllInOne.jdField_h_of_type_JavaLangString = paramView;
      localAllInOne.jdField_f_of_type_JavaLangString = ((String)localObject);
      localAllInOne.jdField_e_of_type_Int = this.jdField_f_of_type_Int;
      if (3000 != this.jdField_f_of_type_Int) {
        break label657;
      }
      localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    }
    for (;;)
    {
      localAllInOne.g = 5;
      localAllInOne.jdField_h_of_type_Int = 57;
      ProfileActivity.a(this, localAllInOne, 3);
      break;
      if (this.jdField_f_of_type_Int == 1000)
      {
        localAllInOne.jdField_a_of_type_Int = 22;
        localAllInOne.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
        break label470;
      }
      if (this.jdField_f_of_type_Int == 1001)
      {
        localAllInOne.jdField_a_of_type_Int = 42;
        break label470;
      }
      if (this.jdField_f_of_type_Int == 10002)
      {
        localAllInOne.jdField_a_of_type_Int = 86;
        break label470;
      }
      if (this.jdField_f_of_type_Int == 1005)
      {
        localAllInOne.jdField_a_of_type_Int = 2;
        break label470;
      }
      if (this.jdField_f_of_type_Int == 1023)
      {
        localAllInOne.jdField_a_of_type_Int = 74;
        break label470;
      }
      localAllInOne.jdField_a_of_type_Int = 19;
      break label470;
      label657:
      if (1000 == this.jdField_f_of_type_Int) {
        localAllInOne.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
      }
    }
  }
  
  protected void a(DiscussionInfoCardActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.c();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562946);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131719050));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
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
      localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
      label109:
      if (i1 != 0)
      {
        localObject = new DiscussionMemberInfo();
        ((DiscussionMemberInfo)localObject).memberUin = localDiscussionMemberInfo1.memberUin;
        ((DiscussionMemberInfo)localObject).memberName = ContactUtils.a(localDiscussionMemberInfo1, this.app);
      }
      for (;;)
      {
        i2 += 1;
        break;
        if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) || (!localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
          break label312;
        }
        i1 = 1;
        break label109;
        DiscussionMemberInfo localDiscussionMemberInfo2 = new DiscussionMemberInfo();
        localDiscussionMemberInfo2.memberUin = localDiscussionMemberInfo1.memberUin;
        localDiscussionMemberInfo2.memberName = ContactUtils.a(localDiscussionMemberInfo1, this.app);
        localDiscussionMemberInfo2.discussionUin = ChnToSpell.a(localDiscussionMemberInfo2.memberName, 1);
        localArrayList.add(localDiscussionMemberInfo2);
      }
      Collections.sort(localArrayList, new ContactSorter.DiscussionMemberComparator());
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      if ((localArrayList.size() > 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localArrayList).sendToTarget();
      }
      return;
      label312:
      i1 = 0;
    }
  }
  
  boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", this.jdField_f_of_type_JavaLangString, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_share", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131719311));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(TroopShareUtility.a(this, true));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
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
        ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
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
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_f_of_type_JavaLangString), true);
        }
      }
    }
  }
  
  protected void c()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_qrcode", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.jdField_a_of_type_AndroidContentIntent = new Intent(getActivity(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", HardCodeUtil.a(2131703373));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_f_of_type_JavaLangString, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131720319);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter.notifyDataSetChanged();
          return;
          q();
          finish();
          return;
          setResult(-1);
          this.jdField_b_of_type_Boolean = true;
          return;
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.jdField_e_of_type_JavaLangString)));
        if (NetworkUtil.d(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue(), (String)localObject);
          a((CharSequence)localObject);
          a(getString(2131690854));
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(1, getString(2131694510));
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        }
        Object localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        paramIntent = paramIntent.getLongExtra("roomId", 0L) + "";
        ((Intent)localObject).putExtra("uin", paramIntent);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
        ((Intent)localObject).putExtra("isBack2Root", true);
        startActivity((Intent)localObject);
        finish();
        return;
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter.notifyDataSetChanged();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.app.setHandler(DiscussionInfoCardActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    f();
    g();
    TroopReportor.a("Grp_Dis_set", "Dis_info", "exp", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.app.removeHandler(DiscussionInfoCardActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
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
    j();
    super.doOnPause();
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        a(paramView);
        break;
      case 2131380019: 
        c();
        break;
      case 2131364588: 
        l();
        break;
      case 2131376662: 
        m();
        break;
      case 2131377860: 
        n();
        break;
      case 2131371020: 
        o();
        break;
      case 2131369501: 
        localObject = ActionSheet.create(this);
        ((ActionSheet)localObject).addButton(getString(2131696180));
        ((ActionSheet)localObject).addButton(2131690821);
        ((ActionSheet)localObject).addButton(getString(2131696130), 3);
        ((ActionSheet)localObject).addButton(2131690800);
        ((ActionSheet)localObject).setOnButtonClickListener(new DiscussionInfoCardActivity.6(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_upright", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, TroopReportor.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
        break;
      case 2131364779: 
        localObject = this.app.getMessageFacade().a(this.jdField_f_of_type_JavaLangString, 3000);
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          QQToast.a(this, 1, getString(2131720030), 0).a();
        }
        else
        {
          localObject = new DeleteRecordDialog(this, this.app, false);
          ((DeleteRecordDialog)localObject).a(new DiscussionInfoCardActivity.7(this));
          ((DeleteRecordDialog)localObject).a(2);
        }
        break;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
        if ((localObject != null) && ((localObject instanceof DiscussionInfoCardActivity.ViewHolder)))
        {
          localObject = (DiscussionInfoCardActivity.ViewHolder)localObject;
          if (paramString != null) {
            break label72;
          }
          a((DiscussionInfoCardActivity.ViewHolder)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
        {
          paramInt1 += 1;
          break;
        }
        ((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(2130839715, HardCodeUtil.a(2131703388));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.action)
        {
        default: 
          break;
        case 1: 
          a(this.app, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        }
      }
    }
    d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_f_of_type_JavaLangString);
    if (localObject1 != null) {}
    for (int i1 = ((List)localObject1).size();; i1 = 0)
    {
      a(this.app, this, 11, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, i1, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      break;
      a(this.app, this, this.jdField_b_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      break;
      i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131720753;
      }
      for (;;)
      {
        if (i1 == -1) {
          break label288;
        }
        QRUtils.a(1, i1);
        break;
        if (!WXShareHelper.a().b()) {
          i1 = 2131720754;
        }
      }
      label288:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new DiscussionInfoCardActivity.13(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      Object localObject2 = this.app;
      if (paramInt == 2)
      {
        localObject1 = "1";
        label333:
        ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, (String)localObject1, "", "", "");
        if (paramInt != 2) {
          break label557;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800666D", "0X800666D", 0, 0, "", "", "", "");
        label393:
        this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_f_of_type_JavaLangString, true);
        if (!(localObject1 instanceof BitmapDrawable)) {
          break label602;
        }
      }
      label557:
      label602:
      for (localObject1 = ((BitmapDrawable)localObject1).getBitmap();; localObject1 = null)
      {
        localObject1 = TroopShareUtility.a((Bitmap)localObject1);
        localObject2 = WXShareHelper.a();
        String str1 = this.jdField_a_of_type_JavaLangString;
        String str2 = ForwardUtils.a(this.app, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
        String str3 = HardCodeUtil.a(2131703371) + ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin);
        String str4 = this.jdField_b_of_type_JavaLangString;
        if (paramInt == 2) {}
        for (i1 = 0;; i1 = 1)
        {
          ((WXShareHelper)localObject2).b(str1, str2, (Bitmap)localObject1, str3, str4, i1);
          break;
          localObject1 = "0";
          break label333;
          ReportController.b(this.app, "CliOper", "", "", "0X800666E", "0X800666E", 0, 0, "", "", "", "");
          break label393;
        }
        c();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */