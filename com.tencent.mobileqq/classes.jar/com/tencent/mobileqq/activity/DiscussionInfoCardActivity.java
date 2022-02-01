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
import android.os.Looper;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ContactSorter.DiscussionMemberComparator;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionHandler.ReqDiscussInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiscussionInfoCardActivity.ListAdapter jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter;
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new DiscussionInfoCardActivity.10(this);
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  protected DiscussionInfo a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new DiscussionInfoCardActivity.11(this);
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new DiscussionInfoCardActivity.12(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new DiscussionInfoCardActivity.15(this);
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
  private int h = 0;
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
    this.jdField_a_of_type_Int = 10;
    this.jdField_b_of_type_Int = 11;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    if (paramDiscussionInfo == null) {
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return "";
    }
    if (paramDiscussionInfo.isOwnerOrInheritOwner(paramQQAppInterface)) {
      return "0";
    }
    return "1";
  }
  
  @SuppressLint({"NewApi"})
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666F", "0X800666F", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131703515));
      localStringBuilder.append(paramString2);
      localStringBuilder.append("】:\n");
      localStringBuilder.append(paramString1);
      paramString2 = localStringBuilder.toString();
      if (Build.VERSION.SDK_INT < 11)
      {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString2);
      }
      else
      {
        paramString1 = (android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard");
        paramString2 = ClipData.newPlainText("discussion_url", paramString2);
        ClipboardMonitor.setPrimaryClip(paramString1, paramString2);
        paramString1.setPrimaryClip(paramString2);
      }
      QQToast.a(paramQQAppInterface, 2, HardCodeUtil.a(2131703502), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    QQToast.a(paramQQAppInterface, 2, HardCodeUtil.a(2131703523), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131299168));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      if (paramQQProgressDialog != null) {
        try
        {
          paramQQProgressDialog.show();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DiscussionInfoCardActivity", 2, localException.toString());
          }
        }
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666B", "0X800666B", 0, 0, "", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        ThreadManager.post(new DiscussionInfoCardActivity.16(paramLong, paramQQAppInterface, paramString2, str, paramString3, paramString1, paramActivity, paramInt, paramQQProgressDialog), 5, null, true);
        return;
      }
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      QQToast.a(paramActivity, -1, HardCodeUtil.a(2131703509), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
    ThreadManager.post(new DiscussionInfoCardActivity.17(paramString2, paramActivity, paramString1, String.format(paramActivity.getString(2131691769), new Object[] { paramString3 }), paramQQAppInterface), 5, null, false);
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i4 = getResources().getDisplayMetrics().widthPixels;
    int i5 = (int)(this.mDensity * 20.0F);
    int i3 = (int)(this.mDensity * 20.0F);
    int i1 = (int)(this.mDensity * 66.0F);
    int i2 = (int)(this.mDensity * 50.0F);
    i4 -= i5;
    i3 = i4 / (i3 + i2);
    i2 = i1 - i2;
    i1 = (i4 - i3 * i1 - i2) / (i3 + 1) + i2 / 2;
    i2 = (int)(this.mDensity * 20.0F);
    this.g = i1;
    this.h = i1;
    this.i = i2;
    this.j = i2;
    this.k = i3;
    paramMyGridView.setPadding(this.g, this.i, this.h, this.j);
    paramMyGridView = this.jdField_b_of_type_AndroidViewView;
    if (paramMyGridView != null) {
      paramMyGridView.setBackgroundResource(2130839440);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setText(paramCharSequence);
    if (AppSetting.d)
    {
      FollowImageTextView localFollowImageTextView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131703513));
      localStringBuilder.append(paramCharSequence);
      localStringBuilder.append(HardCodeUtil.a(2131703524));
      localFollowImageTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if (Thread.currentThread() == getMainLooper().getThread())
      {
        ThreadManager.post(new DiscussionInfoCardActivity.5(this, paramBoolean), 5, null, false);
      }
      else
      {
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_f_of_type_JavaLangString);
        a(localArrayList);
        if (paramBoolean) {
          try
          {
            localObject2 = new DiscussionHandler.ReqDiscussInfo();
            ((DiscussionHandler.ReqDiscussInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_f_of_type_JavaLangString);
            ((DiscussionHandler.ReqDiscussInfo)localObject2).jdField_b_of_type_Int = localArrayList.size();
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a((DiscussionHandler.ReqDiscussInfo)localObject2);
          }
          catch (Exception localException)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("initDiscussionView getDiscussInfo error disUin=");
              ((StringBuilder)localObject2).append(this.jdField_f_of_type_JavaLangString);
              QLog.d("DiscussionInfoCardActivity", 2, ((StringBuilder)localObject2).toString(), localException);
            }
          }
        }
      }
      return;
    }
    finally {}
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
    setContentBackgroundResource(2130838739);
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
    Object localObject2 = (XListView)View.inflate(this, 2131559286, null);
    try
    {
      ((XListView)localObject2).setBackgroundResource(2130838739);
    }
    catch (Throwable localThrowable)
    {
      QLog.i("DiscussionInfoCardActivity", 1, localThrowable.toString());
    }
    ((XListView)localObject2).setDivider(null);
    ((XListView)localObject2).setVerticalScrollBarEnabled(false);
    ((XListView)localObject2).setPadding(0, 0, 0, 0);
    Object localObject1 = View.inflate(this, 2131558840, null);
    ((XListView)localObject2).setAdapter(new XSimpleListAdapter((View)localObject1));
    setContentView((View)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)((View)localObject1).findViewById(2131379003));
    this.jdField_b_of_type_AndroidViewView = ((View)localObject1).findViewById(2131365732);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370746));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_b_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131370744));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131379348);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView = ((FollowImageTextView)((View)localObject1).findViewById(2131379316));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextColor(getResources().getColor(2131167059));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextSize(1, 23.0F);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxLines(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxWidth((int)DeviceInfoUtil.i() - UIUtils.a(this, 88.5F));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageResource(2130844005);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageWH(UIUtils.a(this, 14.0F), UIUtils.a(this, 15.0F));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject1).findViewById(2131364475));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject1).findViewById(2131376166));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject1).findViewById(2131377286));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)((View)localObject1).findViewById(2131365738));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject1).findViewById(2131370654));
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnClickListener(new DiscussionInfoCardActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnTouchListener(new DiscussionInfoCardActivity.2(this));
    ((ImageView)localObject2).setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new DiscussionInfoCardActivity.3(this));
    setTitle(2131690818);
    setLeftViewName(2131690529);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setBackgroundResource(2130840351);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
    {
      a(1, getString(2131691781));
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView mDiscussionInfo is null,try to get getDiscuss");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.f(this.app.getLongAccountUin());
      finish();
      return;
    }
    localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null) && (!((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin)))
    {
      localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin);
      localStringBuilder.append("");
      ((FriendListHandler)localObject2).getFriendInfo(localStringBuilder.toString(), false);
    }
    a(this.jdField_e_of_type_JavaLangString);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DiscussionInfo.DiscussionFlag:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.DiscussionFlag);
      QLog.d("DiscussionInfoCardActivity", 4, ((StringBuilder)localObject2).toString());
    }
    r();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new DiscussionInfoCardActivity.4(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (this.app != null) && (this.app.getCurrentAccountUin() != null))
    {
      if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      }
      else if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin)))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    if (AppSetting.d)
    {
      this.rightViewImg.setContentDescription(getString(2131697523));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131703525));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690793));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690790));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718783));
      localObject2 = getString(2131696192);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
      localObject2 = getString(2131691791);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
    }
    a(true);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131364667);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839440);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368773).setVisibility(4);
    localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this, 30.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784);
    ((TextView)localObject1).setText(HardCodeUtil.a(2131703500));
    localObject2 = this.app.getMessageFacade().b(this.jdField_f_of_type_JavaLangString, 3000);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
      return;
    }
    ((TextView)localObject1).setTextColor(Color.parseColor("#cccccc"));
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
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_editName", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131691792);
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
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_chatRecord", 1, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_f_of_type_Int);
    startActivityForResult(localIntent, 1000);
  }
  
  private void m()
  {
    FileManagerReporter.a("0X8004E02");
    ReportController.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_file", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
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
    VasWebviewUtil.b(this, IndividuationUrlHelper.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_delMber", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString });
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("param_from", 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    RouteUtils.a(this, localIntent, "/troop/memberlist/TroopMemberList", 9);
  }
  
  private void p()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setMainTitle(2131692084);
    localActionSheet.addButton(getString(2131692083));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new DiscussionInfoCardActivity.14(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_quitgrp", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
    if (localObject1 != null)
    {
      localObject1 = ((DiscussionManager)localObject1).a(this.jdField_f_of_type_JavaLangString, this.app.getCurrentAccountUin());
      if (localObject1 != null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("DiscussionMemberInfo.flag:");
          ((StringBuilder)localObject2).append(((DiscussionMemberInfo)localObject1).flag);
          QLog.d("DiscussionInfoCardActivity", 4, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (localObject2 != null)
        {
          boolean bool = false;
          ((FormSwitchItem)localObject2).setVisibility(0);
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if ((((DiscussionMemberInfo)localObject1).flag & 0x1) != 0) {
            bool = true;
          }
          ((FormSwitchItem)localObject2).setChecked(bool);
        }
      }
      else
      {
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (localObject1 != null) {
          ((FormSwitchItem)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  protected void a()
  {
    DiscussionInfo localDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    if (localDiscussionInfo != null) {
      this.jdField_e_of_type_JavaLangString = localDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131378298);
    if (localObject == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.isDiscussHrMeeting()) && (!((String)localObject).equals(getString(2131693478)))) {
      return;
    }
    int i1;
    if (((String)localObject).equals(getString(2131693478)))
    {
      if (3000 == this.jdField_f_of_type_Int)
      {
        paramView = new Intent();
        localObject = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_f_of_type_JavaLangString);
        if (localObject != null) {
          paramView.putStringArrayListExtra("param_uins_selected_default", new ArrayList(((Map)localObject).keySet()));
        }
        paramView.putExtra("param_groupcode", this.jdField_f_of_type_JavaLangString);
        paramView.putExtra("param_type", 3000);
        paramView.putExtra("param_subtype", 1);
        if (localObject != null) {
          i1 = ((Map)localObject).size();
        } else {
          i1 = 0;
        }
        paramView.putExtra("param_max", 100 - i1);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, paramView, 2);
        ReportController.b(this.app, "CliOper", "", "", "0X800629A", "0X800629A", 0, 0, "", "", "", "");
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_invite_new", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      }
    }
    else
    {
      if (((String)localObject).equals(this.app.getCurrentAccountUin()))
      {
        paramView = new AllInOne((String)localObject, 0);
        paramView.lastActivity = 5;
        paramView.profileEntryType = 57;
        ProfileUtils.openProfileCardForResult(this, paramView, 3);
      }
      else if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject))
      {
        paramView = new AllInOne((String)localObject, 45);
        paramView.nickname = ContactUtils.a(this.app, (String)localObject, 0);
        i1 = this.jdField_f_of_type_Int;
        if (3000 != i1)
        {
          paramView.preWinUin = ((String)localObject);
          paramView.preWinType = i1;
        }
        paramView.discussUin = this.jdField_f_of_type_JavaLangString;
        paramView.lastActivity = 5;
        paramView.profileEntryType = 57;
        ProfileUtils.openProfileCardForResult(this, paramView, 3);
      }
      else
      {
        AllInOne localAllInOne = new AllInOne((String)localObject, 46);
        i1 = this.jdField_f_of_type_Int;
        if (i1 == 3000)
        {
          localAllInOne.pa = 46;
        }
        else if (i1 == 1000)
        {
          localAllInOne.pa = 22;
          localAllInOne.troopUin = getIntent().getStringExtra("troop_uin");
        }
        else if (i1 == 1001)
        {
          localAllInOne.pa = 42;
        }
        else if (i1 == 10002)
        {
          localAllInOne.pa = 86;
        }
        else if (i1 == 1005)
        {
          localAllInOne.pa = 2;
        }
        else if (i1 == 1023)
        {
          localAllInOne.pa = 74;
        }
        else
        {
          localAllInOne.pa = 19;
        }
        localAllInOne.nickname = paramView;
        localAllInOne.preWinUin = ((String)localObject);
        i1 = this.jdField_f_of_type_Int;
        localAllInOne.preWinType = i1;
        if (3000 == i1) {
          localAllInOne.discussUin = this.jdField_f_of_type_JavaLangString;
        } else if (1000 == i1) {
          localAllInOne.troopUin = getIntent().getStringExtra("troop_uin");
        }
        localAllInOne.lastActivity = 5;
        localAllInOne.profileEntryType = 57;
        ProfileUtils.openProfileCardForResult(this, localAllInOne, 3);
      }
      TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_mberHead", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    }
  }
  
  protected void a(DiscussionInfoCardActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.f();
      }
      paramBitmap = localBitmap;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
    }
  }
  
  void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562765);
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131718766));
  }
  
  void a(List<DiscussionMemberInfo> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject1 = null;
      int i1 = 0;
      while (i1 < paramList.size())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.get(i1);
        Object localObject2 = localObject1;
        if (localDiscussionMemberInfo != null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (localDiscussionMemberInfo.memberUin != null))
          {
            if ((a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (localDiscussionMemberInfo.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin))) {}
            while ((!a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (localDiscussionMemberInfo.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin)))
            {
              i2 = 1;
              break;
            }
            int i2 = 0;
            if (i2 != 0)
            {
              localObject2 = new DiscussionMemberInfo();
              ((DiscussionMemberInfo)localObject2).memberUin = localDiscussionMemberInfo.memberUin;
              ((DiscussionMemberInfo)localObject2).memberName = ContactUtils.a(localDiscussionMemberInfo, this.app);
              break label254;
            }
          }
          localObject2 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject2).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject2).memberName = ContactUtils.a(localDiscussionMemberInfo, this.app);
          ((DiscussionMemberInfo)localObject2).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject2).memberName, 1);
          localArrayList.add(localObject2);
          localObject2 = localObject1;
        }
        label254:
        i1 += 1;
        localObject1 = localObject2;
      }
      Collections.sort(localArrayList, new ContactSorter.DiscussionMemberComparator());
      if (localObject1 != null) {
        localArrayList.add(0, localObject1);
      }
      if ((localArrayList.size() > 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localArrayList).sendToTarget();
      }
    }
  }
  
  boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", this.jdField_f_of_type_JavaLangString, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_share", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131719029));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(TroopShareUtility.a(this, true));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("ShareActionSheet", 2, localStringBuilder.toString());
      }
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("qrcode", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussionvalidtime");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_Long = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussion");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString(localStringBuilder.toString(), null);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussionfullSig");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString(localStringBuilder.toString(), null);
    int i1;
    if (this.jdField_a_of_type_Long - System.currentTimeMillis() / 1000L > 0L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString != null) && (i1 != 0))
    {
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "qrcode url not valid");
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.jdField_f_of_type_JavaLangString), true);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
  }
  
  protected void c()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_qrcode", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.jdField_a_of_type_AndroidContentIntent = new Intent(getActivity(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", HardCodeUtil.a(2131703505));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_f_of_type_JavaLangString, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131720059);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", data = ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.i("DiscussionInfoCardActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 8)
              {
                if (paramInt1 != 1000)
                {
                  if (paramInt1 != 10)
                  {
                    if (paramInt1 != 11) {
                      return;
                    }
                    localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
                    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
                    paramIntent = ForwardUtils.a((Intent)localObject);
                    ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
                    return;
                  }
                  addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
                  return;
                }
                setResult(-1);
                this.jdField_b_of_type_Boolean = true;
              }
            }
            else
            {
              paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter;
              if (paramIntent != null) {
                paramIntent.notifyDataSetChanged();
              }
            }
          }
          else
          {
            paramInt1 = paramIntent.getIntExtra("param_subtype", -1);
            if (paramInt1 != 0)
            {
              if (paramInt1 == 1) {}
            }
            else {
              ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
            }
            localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramIntent.getLongExtra("roomId", 0L));
            localStringBuilder.append("");
            paramIntent = localStringBuilder.toString();
            ((Intent)localObject).putExtra("uin", paramIntent);
            ((Intent)localObject).putExtra("uintype", 3000);
            ((Intent)localObject).putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
            ((Intent)localObject).putExtra("isBack2Root", true);
            startActivity((Intent)localObject);
            finish();
          }
        }
        else
        {
          q();
          finish();
        }
      }
      else
      {
        if (paramIntent != null) {
          paramIntent = paramIntent.getStringExtra("result");
        } else {
          paramIntent = "";
        }
        if ((paramIntent != null) && (!paramIntent.equals("")) && (!paramIntent.equals(this.jdField_e_of_type_JavaLangString)))
        {
          if (NetworkUtil.isNetSupport(this))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue(), paramIntent);
            a(paramIntent);
            a(getString(2131690782));
            this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            return;
          }
          a(1, getString(2131694475));
        }
      }
    }
    else if ((paramInt2 == 0) && (3 == paramInt1))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ListAdapter;
      if (paramIntent != null) {
        paramIntent.notifyDataSetChanged();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.app.setHandler(DiscussionInfoCardActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    f();
    g();
    TroopReportor.a("Grp_Dis_set", "Dis_info", "exp", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.app.removeHandler(DiscussionInfoCardActivity.class);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
  }
  
  protected void doOnPause()
  {
    j();
    super.doOnPause();
  }
  
  protected void e()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 1000L)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        a(paramView);
        break;
      case 2131379348: 
        c();
        break;
      case 2131377286: 
        n();
        break;
      case 2131376166: 
        m();
        break;
      case 2131370654: 
        o();
        break;
      case 2131369216: 
        localObject = ActionSheet.create(this);
        ((ActionSheet)localObject).addButton(getString(2131696199));
        ((ActionSheet)localObject).addButton(2131690749);
        ((ActionSheet)localObject).addButton(getString(2131696147), 3);
        ((ActionSheet)localObject).addButton(2131690728);
        ((ActionSheet)localObject).setOnButtonClickListener(new DiscussionInfoCardActivity.6(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_upright", 0, 0, new String[] { this.jdField_f_of_type_JavaLangString, a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
        break;
      case 2131364667: 
        localObject = this.app.getMessageFacade().b(this.jdField_f_of_type_JavaLangString, 3000);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = new DeleteRecordDialog(this, this.app, false);
          ((DeleteRecordDialog)localObject).a(new DiscussionInfoCardActivity.7(this));
          ((DeleteRecordDialog)localObject).a(2);
        }
        else
        {
          QQToast.a(this, 1, getString(2131719762), 0).a();
        }
        break;
      case 2131364475: 
        l();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof DiscussionInfoCardActivity.ViewHolder)))
        {
          localObject = (DiscussionInfoCardActivity.ViewHolder)localObject;
          if (paramString == null)
          {
            a((DiscussionInfoCardActivity.ViewHolder)localObject, null, false);
          }
          else if (paramString.equals(((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
          {
            ((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(2130839573, HardCodeUtil.a(2131703520));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    else
    {
      Object localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        int i2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.action;
        if (i2 != 1)
        {
          int i1 = 0;
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if ((i2 != 9) && (i2 != 10))
              {
                if (i2 == 23) {
                  c();
                }
              }
              else
              {
                if (!WXShareHelper.a().a()) {
                  i1 = 2131720478;
                } else if (!WXShareHelper.a().b()) {
                  i1 = 2131720479;
                } else {
                  i1 = -1;
                }
                if (i1 != -1)
                {
                  QRUtils.a(1, i1);
                }
                else
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new DiscussionInfoCardActivity.13(this);
                    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
                  }
                  Object localObject2 = this.app;
                  if (paramInt == 2) {
                    localObject1 = "1";
                  } else {
                    localObject1 = "0";
                  }
                  ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, (String)localObject1, "", "", "");
                  if (paramInt == 2) {
                    ReportController.b(this.app, "CliOper", "", "", "0X800666D", "0X800666D", 0, 0, "", "", "", "");
                  } else {
                    ReportController.b(this.app, "CliOper", "", "", "0X800666E", "0X800666E", 0, 0, "", "", "", "");
                  }
                  this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_f_of_type_JavaLangString, true);
                  localObject1 = null;
                  if ((localObject2 instanceof BitmapDrawable)) {
                    localObject1 = ((BitmapDrawable)localObject2).getBitmap();
                  }
                  localObject1 = TroopShareUtility.a((Bitmap)localObject1);
                  localObject2 = WXShareHelper.a();
                  String str1 = this.jdField_a_of_type_JavaLangString;
                  String str2 = ForwardUtils.a(this.app, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
                  Object localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(HardCodeUtil.a(2131703503));
                  ((StringBuilder)localObject3).append(ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin));
                  localObject3 = ((StringBuilder)localObject3).toString();
                  String str3 = this.jdField_b_of_type_JavaLangString;
                  if (paramInt == 2) {
                    i1 = 0;
                  } else {
                    i1 = 1;
                  }
                  ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, (String)localObject3, str3, i1);
                }
              }
            }
            else {
              a(this.app, this, this.jdField_b_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
            }
          }
          else
          {
            d();
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.jdField_f_of_type_JavaLangString);
            if (localObject1 != null) {
              i1 = ((List)localObject1).size();
            }
            a(this.app, this, 11, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, i1, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
          }
        }
        else
        {
          a(this.app, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */