package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import afez;
import agce;
import agct;
import agcu;
import agcv;
import agcw;
import agcy;
import agcz;
import agda;
import agdb;
import agdi;
import agdj;
import agdt;
import agej;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
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
import anzj;
import atbt;
import bhnv;
import bhsr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ReminderListFragment
  extends PublicBaseFragment
  implements atbt<RecyclerView>
{
  private static final String jdField_a_of_type_JavaLangString = ReminderListFragment.class.getSimpleName();
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private agda jdField_a_of_type_Agda;
  private agdj jdField_a_of_type_Agdj;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PullToRefreshRecyclerView jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = true;
  
  private View a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setOnClickListener(new agcu(this));
    localFrameLayout.setBackgroundColor(Color.parseColor("#1A000000"));
    Button localButton = new Button(paramContext);
    localButton.setText(anzj.a(2131712263));
    localButton.setTextColor(Color.parseColor("#000000"));
    localButton.setTextSize(1, 16.0F);
    localButton.setBackgroundDrawable(paramContext.getResources().getDrawable(2130844752));
    localButton.setOnClickListener(new agcv(this));
    localFrameLayout.addView(localButton);
    paramContext = (FrameLayout.LayoutParams)localButton.getLayoutParams();
    paramContext.width = agej.a(80.0F, getResources());
    paramContext.height = -2;
    paramContext.gravity = 53;
    return localFrameLayout;
  }
  
  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561030, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131364228));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366049));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131369088));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131689532));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131369042));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new agct(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373209));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131376407);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new agdb(this, null));
    this.jdField_a_of_type_Agda = new agda(this, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Agda);
    this.jdField_a_of_type_Agda.notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(a(getActivity()), -1, -1);
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
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("msg_id", this.jdField_b_of_type_JavaLangString);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
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
      b(anzj.a(2131712264));
      this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.8(this));
      return;
    }
    agdi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, 10, new agcz(this, paramInt));
  }
  
  private void a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "---deleMsg--- acsMsg is null");
      }
      b(anzj.a(2131712256));
      return;
    }
    String str = paramAcsMsg.msg_id;
    agdi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, new agcw(this, paramAcsMsg, str));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ReminderListFragment.class);
    localIntent.putExtra("notice_time", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    afez.a(paramContext, localIntent, PublicFragmentActivity.class, ReminderListFragment.class);
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Agdj.a(paramString, new agcy(this));
  }
  
  private void a(ArrayList<AcsMsg> paramArrayList, ArrayList<agdt> paramArrayList1, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      AcsMsg localAcsMsg = (AcsMsg)paramArrayList.next();
      agdt localagdt = new agdt();
      localagdt.jdField_a_of_type_WalletAcsMsg = localAcsMsg;
      if (localAcsMsg.notice_time * 1000L >= this.jdField_a_of_type_Long)
      {
        localagdt.jdField_a_of_type_Int = 0;
        if (!this.jdField_a_of_type_Boolean)
        {
          localagdt.jdField_a_of_type_JavaLangString = anzj.a(2131712262);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      for (;;)
      {
        paramArrayList1.add(localagdt);
        break;
        localagdt.jdField_a_of_type_Int = 1;
        if (!this.jdField_b_of_type_Boolean)
        {
          localagdt.jdField_a_of_type_JavaLangString = anzj.a(2131712267);
          this.jdField_b_of_type_Boolean = true;
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.7(this, paramArrayList1, paramBoolean));
  }
  
  private boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      bool1 = bool2;
      if (!bhsr.a(localIntent.getStringExtra("notice_time"))) {
        bool1 = true;
      }
      this.c = bool1;
      if (this.c) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.DISABLED);
      }
      bool1 = this.c;
    }
    return bool1;
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
    if (!bhnv.g(getActivity()))
    {
      b(anzj.a(2131712259));
      if (this.jdField_b_of_type_Int == 0) {
        b();
      }
      return;
    }
    if (a())
    {
      String str = getActivity().getIntent().getStringExtra("notice_time");
      try
      {
        a(agce.a(Long.parseLong(str) * 1000L, "yyyyMMdd"));
        return;
      }
      catch (Exception localException)
      {
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.d = true;
        a(this.jdField_b_of_type_Int);
        return;
      }
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.d = true;
    a(this.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a();
    this.jdField_a_of_type_Agdj = ((agdj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(378));
    c();
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
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment
 * JD-Core Version:    0.7.0.1
 */