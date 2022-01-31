package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import adpn;
import aeno;
import aenw;
import aenx;
import aeny;
import aenz;
import aeob;
import aeoc;
import aeod;
import aeoe;
import aeol;
import aeom;
import aeos;
import aepi;
import alud;
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
import aqgr;
import bdin;
import bdnn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ReminderListFragment
  extends PublicBaseFragment
  implements aqgr<RecyclerView>
{
  private static final String jdField_a_of_type_JavaLangString = ReminderListFragment.class.getSimpleName();
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private aeod jdField_a_of_type_Aeod;
  private aeom jdField_a_of_type_Aeom;
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
    localFrameLayout.setOnClickListener(new aenx(this));
    localFrameLayout.setBackgroundColor(Color.parseColor("#1A000000"));
    Button localButton = new Button(paramContext);
    localButton.setText(alud.a(2131713775));
    localButton.setTextColor(Color.parseColor("#000000"));
    localButton.setTextSize(1, 16.0F);
    localButton.setBackgroundDrawable(paramContext.getResources().getDrawable(2130844344));
    localButton.setOnClickListener(new aeny(this));
    localFrameLayout.addView(localButton);
    paramContext = (FrameLayout.LayoutParams)localButton.getLayoutParams();
    paramContext.width = aepi.a(80.0F, getResources());
    paramContext.height = -2;
    paramContext.gravity = 53;
    return localFrameLayout;
  }
  
  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560793, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131363982));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131365762));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131689607));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aenw(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131372496));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131375543);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new aeoe(this, null));
    this.jdField_a_of_type_Aeod = new aeod(this, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aeod);
    this.jdField_a_of_type_Aeod.notifyDataSetChanged();
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
      b(alud.a(2131713776));
      this.jdField_a_of_type_AndroidOsHandler.post(new ReminderListFragment.8(this));
      return;
    }
    aeol.a(paramInt, 10, new aeoc(this, paramInt));
  }
  
  private void a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "---deleMsg--- acsMsg is null");
      }
      b(alud.a(2131713768));
      return;
    }
    String str = paramAcsMsg.msg_id;
    aeol.a(str, new aenz(this, paramAcsMsg, str));
  }
  
  public static void a(Activity paramActivity)
  {
    adpn.a(paramActivity, new Intent(paramActivity, ReminderListFragment.class), PublicFragmentActivity.class, ReminderListFragment.class, 2000);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ReminderListFragment.class);
    localIntent.putExtra("notice_time", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    adpn.a(paramContext, localIntent, PublicFragmentActivity.class, ReminderListFragment.class);
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Aeom.a(paramString, new aeob(this));
  }
  
  private void a(ArrayList<AcsMsg> paramArrayList, ArrayList<aeos> paramArrayList1, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      AcsMsg localAcsMsg = (AcsMsg)paramArrayList.next();
      aeos localaeos = new aeos();
      localaeos.jdField_a_of_type_WalletAcsMsg = localAcsMsg;
      if (localAcsMsg.notice_time * 1000L >= this.jdField_a_of_type_Long)
      {
        localaeos.jdField_a_of_type_Int = 0;
        if (!this.jdField_a_of_type_Boolean)
        {
          localaeos.jdField_a_of_type_JavaLangString = alud.a(2131713774);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      for (;;)
      {
        paramArrayList1.add(localaeos);
        break;
        localaeos.jdField_a_of_type_Int = 1;
        if (!this.jdField_b_of_type_Boolean)
        {
          localaeos.jdField_a_of_type_JavaLangString = alud.a(2131713779);
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
      if (!bdnn.a(localIntent.getStringExtra("notice_time"))) {
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
    if (!bdin.g(getActivity()))
    {
      b(alud.a(2131713771));
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
        a(aeno.a(Long.parseLong(str) * 1000L, "yyyyMMdd"));
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
    this.jdField_a_of_type_Aeom = new aeom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    aeol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aeol.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment
 * JD-Core Version:    0.7.0.1
 */