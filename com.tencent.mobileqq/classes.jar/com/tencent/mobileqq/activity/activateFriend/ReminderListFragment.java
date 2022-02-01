package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderListItemModel;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ReminderListFragment
  extends PublicBaseFragment
  implements PullToRefreshBase.OnRefreshListener2<RecyclerView>
{
  private static final String b = "ReminderListFragment";
  long a;
  private RelativeLayout c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private PullToRefreshRecyclerView g;
  private RecyclerView h;
  private ReminderListFragment.ReminderListAdapter i;
  private boolean j = false;
  private boolean k = false;
  private PopupWindow l;
  private int m = 0;
  private int n;
  private IQQReminderDataService o;
  private QQAppInterface p;
  private Handler q = new Handler(Looper.getMainLooper());
  private boolean r;
  private String s;
  private boolean t = true;
  
  private View a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setOnClickListener(new ReminderListFragment.2(this));
    localFrameLayout.setBackgroundColor(Color.parseColor("#1A000000"));
    Button localButton = new Button(paramContext);
    localButton.setText(HardCodeUtil.a(2131910859));
    localButton.setTextColor(Color.parseColor("#000000"));
    localButton.setTextSize(1, 16.0F);
    localButton.setBackgroundDrawable(paramContext.getResources().getDrawable(2130846163));
    localButton.setOnClickListener(new ReminderListFragment.3(this));
    localFrameLayout.addView(localButton);
    paramContext = (FrameLayout.LayoutParams)localButton.getLayoutParams();
    paramContext.width = AIOUtils.b(80.0F, getResources());
    paramContext.height = -2;
    paramContext.gravity = 53;
    return localFrameLayout;
  }
  
  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627252, paramViewGroup, false);
    this.c = ((RelativeLayout)paramLayoutInflater.findViewById(2131430350));
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131432531));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131436227));
    this.e.setText(getResources().getString(2131886175));
    this.f = ((TextView)paramLayoutInflater.findViewById(2131436180));
    this.f.setOnClickListener(new ReminderListFragment.1(this));
    this.g = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131440880));
    this.g.setOnRefreshListener(this);
    this.h = ((RecyclerView)this.g.getRefreshableView());
    this.h.setId(2131444519);
    this.h.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
    this.h.addItemDecoration(new ReminderListFragment.ReminderListItemDecoration(this, null));
    this.i = new ReminderListFragment.ReminderListAdapter(this, null);
    this.h.setAdapter(this.i);
    this.i.notifyDataSetChanged();
    if (this.l == null) {
      this.l = new PopupWindow(a(getBaseActivity()), -1, -1);
    }
    this.l.setBackgroundDrawable(new ColorDrawable());
    this.l.setOutsideTouchable(true);
    this.l.setFocusable(true);
    return paramLayoutInflater;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.j = false;
      this.k = false;
      this.m = 0;
    }
    if (!this.t)
    {
      b(HardCodeUtil.a(2131910860));
      this.q.post(new ReminderListFragment.8(this));
      return;
    }
    IQQReminderService localIQQReminderService = (IQQReminderService)this.p.getRuntimeService(IQQReminderService.class, "");
    if (localIQQReminderService == null) {
      return;
    }
    localIQQReminderService.sendReminderList(paramInt, 10, new ReminderListFragment.9(this, paramInt));
  }
  
  private void a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "---deleMsg--- acsMsg is null");
      }
      b(HardCodeUtil.a(2131910852));
      return;
    }
    Object localObject1 = paramAcsMsg.msg_id;
    Object localObject2 = (IQQReminderService)this.p.getRuntimeService(IQQReminderService.class, "");
    if (localObject2 == null) {
      return;
    }
    ((IQQReminderService)localObject2).sendDelReminderListById((String)localObject1, 0L, 2, new ReminderListFragment.5(this, paramAcsMsg, (String)localObject1));
    localObject1 = (IQQReminderCalendarService)this.p.getRuntimeService(IQQReminderCalendarService.class, "");
    localObject2 = new CalendarEntity();
    ((CalendarEntity)localObject2).msg_id = paramAcsMsg.msg_id;
    ((IQQReminderCalendarService)localObject1).deleteCalendarAlarm(getQBaseActivity(), (CalendarEntity)localObject2);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ReminderListFragment.class);
    localIntent.putExtra("notice_time", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivity.class, ReminderListFragment.class);
  }
  
  private void a(String paramString)
  {
    this.o.getReminderListByday(paramString, new ReminderListFragment.6(this));
  }
  
  private void a(ArrayList<AcsMsg> paramArrayList, ArrayList<ReminderListItemModel> paramArrayList1, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AcsMsg localAcsMsg = (AcsMsg)paramArrayList.next();
      ReminderListItemModel localReminderListItemModel = new ReminderListItemModel();
      localReminderListItemModel.a = localAcsMsg;
      if (localAcsMsg.notice_time * 1000L >= this.a)
      {
        localReminderListItemModel.c = 0;
        if (!this.j)
        {
          localReminderListItemModel.b = HardCodeUtil.a(2131910858);
          this.j = true;
        }
      }
      else
      {
        localReminderListItemModel.c = 1;
        if (!this.k)
        {
          localReminderListItemModel.b = HardCodeUtil.a(2131910863);
          this.k = true;
        }
      }
      paramArrayList1.add(localReminderListItemModel);
    }
    this.q.post(new ReminderListFragment.7(this, paramArrayList1, paramBoolean));
  }
  
  private QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void b(String paramString)
  {
    this.q.post(new ReminderListFragment.10(this, paramString));
  }
  
  private void c()
  {
    if (getBaseActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("msg_id", this.s);
      getBaseActivity().setResult(-1, localIntent);
      getBaseActivity().finish();
    }
  }
  
  private boolean d()
  {
    Intent localIntent = getBaseActivity().getIntent();
    if (localIntent != null)
    {
      this.r = (StringUtil.isEmpty(localIntent.getStringExtra("notice_time")) ^ true);
      if (this.r) {
        this.g.setMode(PullToRefreshBase.Mode.DISABLED);
      }
      return this.r;
    }
    return false;
  }
  
  private void e()
  {
    this.q.post(new ReminderListFragment.4(this));
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      b(HardCodeUtil.a(2131910855));
      if (this.n == 0) {
        e();
      }
      return;
    }
    String str;
    if (d()) {
      str = getBaseActivity().getIntent().getStringExtra("notice_time");
    }
    try
    {
      a(DateUtil.a(Long.parseLong(str) * 1000L, "yyyyMMdd"));
      return;
    }
    catch (Exception localException)
    {
      label72:
      break label72;
    }
    this.n = 0;
    this.m = 0;
    this.t = true;
    a(this.n);
    return;
    this.n = 0;
    this.m = 0;
    this.t = true;
    a(this.n);
  }
  
  private void g()
  {
    this.p = b();
    QQAppInterface localQQAppInterface = this.p;
    if (localQQAppInterface != null)
    {
      this.o = ((IQQReminderDataService)localQQAppInterface.getRuntimeService(IQQReminderDataService.class, ""));
      f();
    }
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "----onPullDownToRefresh----");
    }
    f();
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "----onPullUpToRefresh----");
    }
    if (!this.r) {
      a(this.n);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      c();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup);
    g();
    this.a = NetConnInfoCenter.getServerTimeMillis();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Handler localHandler = this.q;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment
 * JD-Core Version:    0.7.0.1
 */