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
  private static final String jdField_a_of_type_JavaLangString = "ReminderListFragment";
  private int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReminderListFragment.ReminderListAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$ReminderListAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PullToRefreshRecyclerView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView;
  private IQQReminderDataService jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d = true;
  
  private View a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setOnClickListener(new ReminderListFragment.2(this));
    localFrameLayout.setBackgroundColor(Color.parseColor("#1A000000"));
    Button localButton = new Button(paramContext);
    localButton.setText(HardCodeUtil.a(2131713306));
    localButton.setTextColor(Color.parseColor("#000000"));
    localButton.setTextSize(1, 16.0F);
    localButton.setBackgroundDrawable(paramContext.getResources().getDrawable(2130844731));
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131560911, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131364322));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366239));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131689565));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ReminderListFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373271));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131376308);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new ReminderListFragment.ReminderListItemDecoration(this, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$ReminderListAdapter = new ReminderListFragment.ReminderListAdapter(this, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$ReminderListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$ReminderListAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(a(getBaseActivity()), -1, -1);
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    return paramLayoutInflater;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a()
  {
    if (getBaseActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("msg_id", this.jdField_b_of_type_JavaLangString);
      getBaseActivity().setResult(-1, localIntent);
      getBaseActivity().finish();
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
    }
    if (!this.d)
    {
      b(HardCodeUtil.a(2131713307));
      this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.8(this));
      return;
    }
    IQQReminderService localIQQReminderService = (IQQReminderService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQReminderService.class, "");
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "---deleMsg--- acsMsg is null");
      }
      b(HardCodeUtil.a(2131713299));
      return;
    }
    Object localObject1 = paramAcsMsg.msg_id;
    Object localObject2 = (IQQReminderService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQReminderService.class, "");
    if (localObject2 == null) {
      return;
    }
    ((IQQReminderService)localObject2).sendDelReminderListById((String)localObject1, 0L, 2, new ReminderListFragment.5(this, paramAcsMsg, (String)localObject1));
    localObject1 = (IQQReminderCalendarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQReminderCalendarService.class, "");
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
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getReminderListByday(paramString, new ReminderListFragment.6(this));
  }
  
  private void a(ArrayList<AcsMsg> paramArrayList, ArrayList<ReminderListItemModel> paramArrayList1, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AcsMsg localAcsMsg = (AcsMsg)paramArrayList.next();
      ReminderListItemModel localReminderListItemModel = new ReminderListItemModel();
      localReminderListItemModel.jdField_a_of_type_WalletAcsMsg = localAcsMsg;
      if (localAcsMsg.notice_time * 1000L >= this.jdField_a_of_type_Long)
      {
        localReminderListItemModel.jdField_a_of_type_Int = 0;
        if (!this.jdField_a_of_type_Boolean)
        {
          localReminderListItemModel.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713305);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        localReminderListItemModel.jdField_a_of_type_Int = 1;
        if (!this.jdField_b_of_type_Boolean)
        {
          localReminderListItemModel.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713310);
          this.jdField_b_of_type_Boolean = true;
        }
      }
      paramArrayList1.add(localReminderListItemModel);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.7(this, paramArrayList1, paramBoolean));
  }
  
  private boolean a()
  {
    Intent localIntent = getBaseActivity().getIntent();
    if (localIntent != null)
    {
      this.c = (StringUtil.a(localIntent.getStringExtra("notice_time")) ^ true);
      if (this.c) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.DISABLED);
      }
      return this.c;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.4(this));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.10(this, paramString));
  }
  
  private void c()
  {
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      b(HardCodeUtil.a(2131713302));
      if (this.jdField_b_of_type_Int == 0) {
        b();
      }
      return;
    }
    String str;
    if (a()) {
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
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.d = true;
    a(this.jdField_b_of_type_Int);
    return;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.d = true;
    a(this.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService = ((IQQReminderDataService)localQQAppInterface.getRuntimeService(IQQReminderDataService.class, ""));
      c();
    }
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "----onPullDownToRefresh----");
    }
    c();
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "----onPullUpToRefresh----");
    }
    if (!this.c) {
      a(this.jdField_b_of_type_Int);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup);
    d();
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment
 * JD-Core Version:    0.7.0.1
 */