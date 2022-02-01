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
  private MyGridView A;
  private TextView B;
  private View C;
  private FormSimpleItem D;
  private FormSimpleItem E;
  private FormSimpleItem F;
  private FormSimpleItem G;
  private FormSwitchItem H;
  private FormSwitchItem I;
  private DiscussionInfoCardActivity.ListAdapter J;
  private QQProgressDialog K;
  private String L;
  private String M;
  private int N;
  private boolean O = false;
  private int P = 0;
  private int Q = 0;
  private int R = 0;
  private int S = 0;
  private int T = 4;
  private Intent U;
  private long V;
  private final int W = 0;
  private final int X = 1;
  private final int Y = 2;
  private final int Z = 3;
  protected FollowImageTextView a;
  private final int aa = 8;
  private final int ab = 9;
  private List<DiscussionMemberInfo> ac;
  View b;
  protected final int c = 10;
  protected final int d = 11;
  protected final int e = 0;
  protected final int f = 1;
  protected final int g = 2;
  protected DiscussionInfo h;
  protected QQProgressDialog i;
  protected Dialog j;
  protected ShareActionSheetBuilder k;
  protected WXShareHelper.WXShareListener l;
  protected String m;
  protected long n;
  protected String o;
  protected String p;
  protected boolean q = false;
  IFaceDecoder r;
  protected String s;
  MqqHandler t = new DiscussionInfoCardActivity.9(this);
  FriendListObserver u = new DiscussionInfoCardActivity.10(this);
  DiscussionObserver v = new DiscussionInfoCardActivity.11(this);
  ProfileCardObserver w = new DiscussionInfoCardActivity.12(this);
  TroopMngObserver x = new DiscussionInfoCardActivity.15(this);
  private DiscussionHandler y;
  private DiscussionManager z;
  
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
      localStringBuilder.append(HardCodeUtil.a(2131901467));
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
      QQToast.makeText(paramQQAppInterface, 2, HardCodeUtil.a(2131901454), 0).show(paramQQAppInterface.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    QQToast.makeText(paramQQAppInterface, 2, HardCodeUtil.a(2131901475), 0).show(paramQQAppInterface.getResources().getDimensionPixelSize(2131299920));
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
      QQToast.makeText(paramActivity, -1, HardCodeUtil.a(2131901461), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
    ThreadManager.post(new DiscussionInfoCardActivity.17(paramString2, paramActivity, paramString1, String.format(paramActivity.getString(2131888731), new Object[] { paramString3 }), paramQQAppInterface), 5, null, false);
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
    this.P = i1;
    this.Q = i1;
    this.R = i2;
    this.S = i2;
    this.T = i3;
    paramMyGridView.setPadding(this.P, this.R, this.Q, this.S);
    paramMyGridView = this.C;
    if (paramMyGridView != null) {
      paramMyGridView.setBackgroundResource(2130839629);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
    if (AppSetting.e)
    {
      FollowImageTextView localFollowImageTextView = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131901465));
      localStringBuilder.append(paramCharSequence);
      localStringBuilder.append(HardCodeUtil.a(2131901476));
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
        ArrayList localArrayList = this.z.a(this.M);
        a(localArrayList);
        if (paramBoolean) {
          try
          {
            localObject2 = new DiscussionHandler.ReqDiscussInfo();
            ((DiscussionHandler.ReqDiscussInfo)localObject2).a = String.valueOf(this.M);
            ((DiscussionHandler.ReqDiscussInfo)localObject2).c = localArrayList.size();
            this.y.a((DiscussionHandler.ReqDiscussInfo)localObject2);
          }
          catch (Exception localException)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("initDiscussionView getDiscussInfo error disUin=");
              ((StringBuilder)localObject2).append(this.M);
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
    this.M = this.U.getStringExtra("uin");
    this.L = this.U.getStringExtra("uinname");
    if (this.L == null) {
      this.L = this.M;
    }
    this.N = this.U.getIntExtra("uintype", -1);
    this.z = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.h = this.z.d(this.M);
    h();
    setContentBackgroundResource(2130838958);
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
    Object localObject2 = (XListView)View.inflate(this, 2131625212, null);
    try
    {
      ((XListView)localObject2).setBackgroundResource(2130838958);
    }
    catch (Throwable localThrowable)
    {
      QLog.i("DiscussionInfoCardActivity", 1, localThrowable.toString());
    }
    ((XListView)localObject2).setDivider(null);
    ((XListView)localObject2).setVerticalScrollBarEnabled(false);
    ((XListView)localObject2).setPadding(0, 0, 0, 0);
    Object localObject1 = View.inflate(this, 2131624460, null);
    ((XListView)localObject2).setAdapter(new XSimpleListAdapter((View)localObject1));
    setContentView((View)localObject2);
    this.H = ((FormSwitchItem)((View)localObject1).findViewById(2131447723));
    this.C = ((View)localObject1).findViewById(2131431974);
    this.B = ((TextView)((View)localObject1).findViewById(2131438047));
    this.B.setCompoundDrawables(null, null, null, null);
    this.C.setClickable(false);
    this.A = ((MyGridView)((View)localObject1).findViewById(2131438045));
    this.A.setFadingEdgeLength(0);
    this.r = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.r.setDecodeTaskCompletionListener(this);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131448085);
    this.a = ((FollowImageTextView)((View)localObject1).findViewById(2131448053));
    this.a.setTextColor(getResources().getColor(2131167997));
    this.a.setTextSize(1, 23.0F);
    this.a.setMaxLines(2);
    this.a.setMaxWidth((int)DeviceInfoUtil.D() - UIUtils.a(this, 88.5F));
    this.a.setFollowImageResource(2130844960);
    this.a.setFollowImageVisibility(0);
    this.a.setFollowImageWH(UIUtils.a(this, 14.0F), UIUtils.a(this, 15.0F));
    this.E = ((FormSimpleItem)((View)localObject1).findViewById(2131430532));
    this.F = ((FormSimpleItem)((View)localObject1).findViewById(2131444372));
    this.G = ((FormSimpleItem)((View)localObject1).findViewById(2131445673));
    this.G.setVisibility(0);
    this.I = ((FormSwitchItem)((View)localObject1).findViewById(2131431980));
    this.D = ((FormSimpleItem)((View)localObject1).findViewById(2131437930));
    a(this.A);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.a.setOnClickListener(new DiscussionInfoCardActivity.1(this));
    this.a.setOnTouchListener(new DiscussionInfoCardActivity.2(this));
    ((ImageView)localObject2).setOnClickListener(this);
    this.I.setOnCheckedChangeListener(new DiscussionInfoCardActivity.3(this));
    setTitle(2131887748);
    setLeftViewName(2131887440);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setBackgroundResource(2130841091);
    if (this.h == null)
    {
      a(1, getString(2131888743));
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView mDiscussionInfo is null,try to get getDiscuss");
      }
      this.y.f(this.app.getLongAccountUin());
      finish();
      return;
    }
    localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((TextUtils.isEmpty(this.s)) && (this.h.ownerUin != null) && (!((FriendsManager)localObject2).n(this.h.ownerUin)))
    {
      localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h.ownerUin);
      localStringBuilder.append("");
      ((FriendListHandler)localObject2).getFriendInfo(localStringBuilder.toString(), false);
    }
    a(this.L);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DiscussionInfo.DiscussionFlag:");
      ((StringBuilder)localObject2).append(this.h.DiscussionFlag);
      QLog.d("DiscussionInfoCardActivity", 4, ((StringBuilder)localObject2).toString());
    }
    r();
    this.y = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    boolean bool = this.y.a(this.h);
    this.H.setChecked(bool);
    this.H.setOnCheckedChangeListener(new DiscussionInfoCardActivity.4(this));
    if ((this.h != null) && (this.app != null) && (this.app.getCurrentAccountUin() != null))
    {
      if ((a(this.h.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.h.inheritOwnerUin)))
      {
        this.D.setOnClickListener(this);
        this.D.setVisibility(0);
      }
      else if ((!a(this.h.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.h.ownerUin)))
      {
        this.D.setOnClickListener(this);
        this.D.setVisibility(0);
      }
      else
      {
        this.D.setVisibility(8);
      }
    }
    else {
      this.D.setVisibility(8);
    }
    if (AppSetting.e)
    {
      this.rightViewImg.setContentDescription(getString(2131895296));
      this.D.setContentDescription(HardCodeUtil.a(2131901477));
      this.E.setContentDescription(getString(2131887723));
      this.F.setContentDescription(getString(2131887720));
      this.G.setContentDescription(getString(2131916289));
      localObject2 = getString(2131893958);
      this.H.setContentDescription((CharSequence)localObject2);
      localObject2 = getString(2131888753);
      this.I.setContentDescription((CharSequence)localObject2);
    }
    a(true);
    this.b = ((View)localObject1).findViewById(2131430756);
    this.b.setOnClickListener(this);
    this.b.setBackgroundResource(2130839629);
    this.b.findViewById(2131435692).setVisibility(4);
    localObject1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this, 30.0F);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (TextView)this.b.findViewById(2131447463);
    ((TextView)localObject1).setText(HardCodeUtil.a(2131901452));
    localObject2 = this.app.getMessageFacade().o(this.M, 3000);
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
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_editName", 0, 0, new String[] { this.M, a(this.app, this.h) });
    this.U = new Intent(this, EditActivity.class);
    this.U.putExtra("title", 2131888754);
    this.U.putExtra("limit", 48);
    this.U.putExtra("action", 102);
    this.U.putExtra("current", this.L);
    this.U.putExtra("canPostNull", false);
    this.U.putExtra("multiLine", false);
    startActivityForResult(this.U, 0);
  }
  
  private void l()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_chatRecord", 1, 0, new String[] { this.M, a(this.app, this.h) });
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.M);
    localIntent.putExtra("uintype", this.N);
    startActivityForResult(localIntent, 1000);
  }
  
  private void m()
  {
    FileManagerReporter.a("0X8004E02");
    ReportController.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_file", 0, 0, new String[] { this.M, a(this.app, this.h) });
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.M);
    localIntent.putExtra("uintype", this.N);
    localIntent.putExtra("uinname", this.L);
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
    localIntent.putExtra("chatbg_intent_frinedUin", this.M);
    localIntent.putExtra("uintype", this.N);
    localIntent.putExtra("bg_replace_entrance", 62);
    VasWebviewUtil.b(this, IndividuationUrlHelper.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_delMber", 0, 0, new String[] { this.M });
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.M);
    localIntent.putExtra("param_from", 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    RouteUtils.a(this, localIntent, "/troop/memberlist/TroopMemberList", 9);
  }
  
  private void p()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.setMainTitle(2131889056);
    localActionSheet.addButton(getString(2131889055));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new DiscussionInfoCardActivity.14(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_quitgrp", 0, 0, new String[] { this.M, a(this.app, this.h) });
  }
  
  private void q()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.M);
    localIntent.putExtra("uinname", this.L);
    localIntent.putExtra("uintype", this.N);
    localIntent.putExtra("isNeedUpdate", this.O);
    startActivity(localIntent);
  }
  
  private void r()
  {
    Object localObject1 = this.z;
    if (localObject1 != null)
    {
      localObject1 = ((DiscussionManager)localObject1).b(this.M, this.app.getCurrentAccountUin());
      if (localObject1 != null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("DiscussionMemberInfo.flag:");
          ((StringBuilder)localObject2).append(((DiscussionMemberInfo)localObject1).flag);
          QLog.d("DiscussionInfoCardActivity", 4, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = this.I;
        if (localObject2 != null)
        {
          boolean bool = false;
          ((FormSwitchItem)localObject2).setVisibility(0);
          localObject2 = this.I;
          if ((((DiscussionMemberInfo)localObject1).flag & 0x1) != 0) {
            bool = true;
          }
          ((FormSwitchItem)localObject2).setChecked(bool);
        }
      }
      else
      {
        localObject1 = this.I;
        if (localObject1 != null) {
          ((FormSwitchItem)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  protected void a()
  {
    DiscussionInfo localDiscussionInfo = this.h;
    if (localDiscussionInfo != null) {
      this.L = localDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.makeText(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  public void a(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131446817);
    if (localObject == null) {
      return;
    }
    if ((this.h.isDiscussHrMeeting()) && (!((String)localObject).equals(getString(2131891027)))) {
      return;
    }
    int i1;
    if (((String)localObject).equals(getString(2131891027)))
    {
      if (3000 == this.N)
      {
        paramView = new Intent();
        localObject = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(this.M);
        if (localObject != null) {
          paramView.putStringArrayListExtra("param_uins_selected_default", new ArrayList(((Map)localObject).keySet()));
        }
        paramView.putExtra("param_groupcode", this.M);
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
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_invite_new", 0, 0, new String[] { this.M, a(this.app, this.h) });
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
      else if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n((String)localObject))
      {
        paramView = new AllInOne((String)localObject, 45);
        paramView.nickname = ContactUtils.a(this.app, (String)localObject, 0);
        i1 = this.N;
        if (3000 != i1)
        {
          paramView.preWinUin = ((String)localObject);
          paramView.preWinType = i1;
        }
        paramView.discussUin = this.M;
        paramView.lastActivity = 5;
        paramView.profileEntryType = 57;
        ProfileUtils.openProfileCardForResult(this, paramView, 3);
      }
      else
      {
        AllInOne localAllInOne = new AllInOne((String)localObject, 46);
        i1 = this.N;
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
        i1 = this.N;
        localAllInOne.preWinType = i1;
        if (3000 == i1) {
          localAllInOne.discussUin = this.M;
        } else if (1000 == i1) {
          localAllInOne.troopUin = getIntent().getStringExtra("troop_uin");
        }
        localAllInOne.lastActivity = 5;
        localAllInOne.profileEntryType = 57;
        ProfileUtils.openProfileCardForResult(this, localAllInOne, 3);
      }
      TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_mberHead", 0, 0, new String[] { this.M, a(this.app, this.h) });
    }
  }
  
  protected void a(DiscussionInfoCardActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.a == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.r.getBitmapFromCacheFrom(paramViewHolder.d, paramViewHolder.c, 5);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.k();
      }
      paramBitmap = localBitmap;
      if (!this.r.isPausing())
      {
        this.r.requestDecodeFace(paramViewHolder.c, paramViewHolder.d, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.a.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
    }
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
          if ((this.h != null) && (localDiscussionMemberInfo.memberUin != null))
          {
            if ((a(this.h.inheritOwnerUin)) && (localDiscussionMemberInfo.memberUin.equals(this.h.inheritOwnerUin))) {}
            while ((!a(this.h.inheritOwnerUin)) && (localDiscussionMemberInfo.memberUin.equals(this.h.ownerUin)))
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
          ((DiscussionMemberInfo)localObject2).discussionUin = ChnToSpell.b(((DiscussionMemberInfo)localObject2).memberName, 1);
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
      if ((localArrayList.size() > 0) && (!this.t.hasMessages(0))) {
        this.t.obtainMessage(0, localArrayList).sendToTarget();
      }
    }
  }
  
  boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", this.M, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_share", 0, 0, new String[] { this.M, a(this.app, this.h) });
    if (this.k == null)
    {
      this.k = new ShareActionSheetBuilder(this);
      this.k.setActionSheetTitle(getString(2131916565));
      this.k.setActionSheetItems(TroopShareUtility.a(this, true));
      this.k.setItemClickListener(this);
    }
    try
    {
      this.k.show();
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
    localStringBuilder.append(this.M);
    this.n = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussion");
    localStringBuilder.append(this.M);
    this.o = localSharedPreferences.getString(localStringBuilder.toString(), null);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussionfullSig");
    localStringBuilder.append(this.M);
    this.p = localSharedPreferences.getString(localStringBuilder.toString(), null);
    int i1;
    if (this.n - System.currentTimeMillis() / 1000L > 0L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((this.o != null) && (this.p != null) && (i1 != 0))
    {
      this.q = true;
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "qrcode url not valid");
      }
      this.q = false;
      this.y.a(Long.parseLong(this.M), true);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
  }
  
  void b(String paramString)
  {
    this.K = new QQProgressDialog(this, getTitleBarHeight());
    this.K.setContentView(2131629210);
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      this.K.a(paramString);
      return;
    }
    this.K.a(getString(2131916272));
  }
  
  protected void c()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
    TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_qrcode", 0, 0, new String[] { this.M, a(this.app, this.h) });
    this.U = new Intent(getActivity(), QRDisplayActivity.class);
    this.U.putExtra("title", HardCodeUtil.a(2131901457));
    this.U.putExtra("uin", this.M);
    this.U.putExtra("nick", this.L);
    this.U.putExtra("type", 5);
    Object localObject = this.y.a(this.M, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.U.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.v);
    startActivityForResult(this.U, 10);
  }
  
  protected void d()
  {
    if (this.i == null)
    {
      this.i = new QQProgressDialog(this, getTitleBarHeight());
      this.i.c(2131917680);
    }
    if (!this.i.isShowing()) {
      this.i.show();
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
                  addObserver(this.v);
                  return;
                }
                setResult(-1);
                this.O = true;
              }
            }
            else
            {
              paramIntent = this.J;
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
        if ((paramIntent != null) && (!paramIntent.equals("")) && (!paramIntent.equals(this.L)))
        {
          if (NetworkUtil.isNetSupport(this))
          {
            this.y.a(Long.valueOf(this.M).longValue(), paramIntent);
            a(paramIntent);
            b(getString(2131887704));
            this.K.show();
            return;
          }
          a(1, getString(2131892157));
        }
      }
    }
    else if ((paramInt2 == 0) && (3 == paramInt1))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
      paramIntent = this.J;
      if (paramIntent != null) {
        paramIntent.notifyDataSetChanged();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.U = getIntent();
    this.y = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    addObserver(this.u);
    addObserver(this.v);
    addObserver(this.w);
    addObserver(this.x);
    this.app.setHandler(DiscussionInfoCardActivity.class, this.t);
    f();
    g();
    TroopReportor.a("Grp_Dis_set", "Dis_info", "exp", 0, 0, new String[] { this.M, a(this.app, this.h) });
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.K != null) && (this.K.isShowing()) && (!isFinishing()))
      {
        this.K.dismiss();
        this.K = null;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    removeObserver(this.u);
    removeObserver(this.v);
    removeObserver(this.w);
    removeObserver(this.x);
    this.app.removeHandler(DiscussionInfoCardActivity.class);
    Object localObject = this.r;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.r = null;
    }
    localObject = this.j;
    if ((localObject != null) && (((Dialog)localObject).isShowing()) && (this.j.getWindow() != null)) {
      this.j.dismiss();
    }
    if (this.l != null)
    {
      WXShareHelper.a().b(this.l);
      this.l = null;
    }
  }
  
  protected void doOnPause()
  {
    j();
    super.doOnPause();
  }
  
  protected void e()
  {
    QQProgressDialog localQQProgressDialog = this.i;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.i.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.V >= 1000L)
    {
      this.V = System.currentTimeMillis();
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        a(paramView);
        break;
      case 2131448085: 
        c();
        break;
      case 2131445673: 
        n();
        break;
      case 2131444372: 
        m();
        break;
      case 2131437930: 
        o();
        break;
      case 2131436194: 
        localObject = ActionSheet.create(this);
        ((ActionSheet)localObject).addButton(getString(2131893965));
        ((ActionSheet)localObject).addButton(2131887669);
        ((ActionSheet)localObject).addButton(getString(2131893912), 3);
        ((ActionSheet)localObject).addButton(2131887648);
        ((ActionSheet)localObject).setOnButtonClickListener(new DiscussionInfoCardActivity.6(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_upright", 0, 0, new String[] { this.M, a(this.app, this.h) });
        break;
      case 2131430756: 
        localObject = this.app.getMessageFacade().o(this.M, 3000);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = new DeleteRecordDialog(this, this.app, false);
          ((DeleteRecordDialog)localObject).a(new DiscussionInfoCardActivity.7(this));
          ((DeleteRecordDialog)localObject).a(2);
        }
        else
        {
          QQToast.makeText(this, 1, getString(2131917366), 0).show();
        }
        break;
      case 2131430532: 
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
      paramInt2 = this.A.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.A.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof DiscussionInfoCardActivity.ViewHolder)))
        {
          localObject = (DiscussionInfoCardActivity.ViewHolder)localObject;
          if (paramString == null)
          {
            a((DiscussionInfoCardActivity.ViewHolder)localObject, null, false);
          }
          else if (paramString.equals(((DiscussionInfoCardActivity.ViewHolder)localObject).c))
          {
            ((DiscussionInfoCardActivity.ViewHolder)localObject).a.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.q)
    {
      a(2130839791, HardCodeUtil.a(2131901472));
      this.k.dismiss();
    }
    else
    {
      Object localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        this.k.dismiss();
        int i2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.action;
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
                if (!WXShareHelper.a().b()) {
                  i1 = 2131918154;
                } else if (!WXShareHelper.a().c()) {
                  i1 = 2131918155;
                } else {
                  i1 = -1;
                }
                if (i1 != -1)
                {
                  QRUtils.a(1, i1);
                }
                else
                {
                  if (this.l == null)
                  {
                    this.l = new DiscussionInfoCardActivity.13(this);
                    WXShareHelper.a().a(this.l);
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
                  this.m = String.valueOf(System.currentTimeMillis());
                  localObject2 = this.y.a(this.M, true);
                  localObject1 = null;
                  if ((localObject2 instanceof BitmapDrawable)) {
                    localObject1 = ((BitmapDrawable)localObject2).getBitmap();
                  }
                  localObject1 = TroopShareUtility.a((Bitmap)localObject1);
                  localObject2 = WXShareHelper.a();
                  String str1 = this.m;
                  String str2 = ForwardUtils.a(this.app, this.L, this.M);
                  Object localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(HardCodeUtil.a(2131901455));
                  ((StringBuilder)localObject3).append(ContactUtils.a(this.app, this.h.uin, this.h.ownerUin));
                  localObject3 = ((StringBuilder)localObject3).toString();
                  String str3 = this.o;
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
              a(this.app, this, this.o, this.M, this.L);
            }
          }
          else
          {
            d();
            localObject1 = this.z.a(this.M);
            if (localObject1 != null) {
              i1 = ((List)localObject1).size();
            }
            a(this.app, this, 11, this.p, this.M, this.L, i1, this.i);
          }
        }
        else
        {
          a(this.app, this.n, this.o, this.L);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */