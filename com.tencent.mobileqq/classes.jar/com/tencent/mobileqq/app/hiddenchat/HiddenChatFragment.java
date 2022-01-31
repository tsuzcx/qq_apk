package com.tencent.mobileqq.app.hiddenchat;

import acjz;
import acxd;
import agzt;
import ahab;
import ahai;
import ahco;
import ahcp;
import ahcq;
import ahdb;
import ajex;
import ajey;
import ajjj;
import ajjz;
import ajys;
import ajyt;
import ajyu;
import akaq;
import akeu;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import ariz;
import ascr;
import awqx;
import awrb;
import azzz;
import badq;
import bajq;
import bbmy;
import befx;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class HiddenChatFragment
  extends IphoneTitleBarFragment
  implements ahab, ahdb, View.OnClickListener, Observer
{
  ahai jdField_a_of_type_Ahai;
  private ahcp jdField_a_of_type_Ahcp;
  protected ajey a;
  private ajys jdField_a_of_type_Ajys;
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ajyt(this);
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_Ajey = new ajyu(this);
  }
  
  public static List<RecentUser> a(List<RecentUser> paramList1, List<RecentUser> paramList2)
  {
    if ((paramList2 == null) || (paramList2.isEmpty())) {
      return paramList1;
    }
    paramList2 = paramList2.iterator();
    label22:
    label51:
    label120:
    label121:
    for (;;)
    {
      RecentUser localRecentUser1;
      int i;
      if (paramList2.hasNext())
      {
        localRecentUser1 = (RecentUser)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)localIterator.next();
          if ((localRecentUser1.getType() != localRecentUser2.getType()) || (!localRecentUser2.uin.equals(localRecentUser1.uin))) {
            break label120;
          }
          i = 1;
        }
      }
      for (;;)
      {
        break label51;
        if (i != 0) {
          break label121;
        }
        paramList1.add(localRecentUser1);
        break label22;
        break;
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FromType", paramInt1);
    localIntent.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.a((Activity)paramContext, localIntent, HiddenChatFragment.class, paramInt2);
  }
  
  public void a()
  {
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    this.jdField_a_of_type_Ajys.a((List)localObject1);
    Object localObject2 = a((List)localObject1, ariz.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localObject1 = new ArrayList(((List)localObject2).size());
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    FragmentActivity localFragmentActivity = getActivity();
    int i;
    if (localObject2 != null) {
      i = ((List)localObject2).size();
    }
    int k;
    for (;;)
    {
      agzt.a((List)localObject2, localQQAppInterface, localFragmentActivity, (List)localObject1, i);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("data|size");
        if (localObject1 != null) {
          break label258;
        }
        i = 0;
        QLog.i("tag_hidden_chat", 2, i);
      }
      try
      {
        Collections.sort((List)localObject1, this.jdField_a_of_type_Ajys);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (this.jdField_a_of_type_Ahai != null))
        {
          this.jdField_a_of_type_Ahai.a(0);
          this.jdField_a_of_type_Ahai.a((List)localObject1);
          k = getActivity().getIntent().getIntExtra("FromType", 0);
          if (localObject1 == null) {
            break label345;
          }
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((RecentBaseData)((Iterator)localObject1).next()).a() == 1)
              {
                i += 1;
                continue;
                i = 0;
                break;
                label258:
                i = ((List)localObject1).size();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RecentDataListManager", 2, "Comparator Exception: ", localException);
            continue;
            j += 1;
          }
        }
      }
    }
    for (;;)
    {
      awqx.b(getActivity().app, "dc00898", "", "", "0X800A34B", "0X800A34B", k, j, "" + i, "0", "", "");
      return;
      label345:
      j = 0;
      i = 0;
    }
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject;
    String str1;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      str1 = paramRecentBaseData.a();
      paramString = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramInt != 5000) {
        break label93;
      }
      if (this.jdField_a_of_type_Ahcp != null) {
        this.jdField_a_of_type_Ahcp.a(paramRecentBaseData, paramBoolean);
      }
    }
    for (;;)
    {
      label60:
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
      label93:
      label238:
      do
      {
        String str2;
        do
        {
          return;
          break;
          if (paramInt == 5001)
          {
            ((ajjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
            break label60;
          }
          if (paramInt != 1) {
            break label534;
          }
          paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          str2 = paramString.d(paramRecentBaseData.a());
          if (TextUtils.isEmpty(str2)) {
            break label340;
          }
          localObject = (ajex)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
          if (!paramBoolean) {
            break label318;
          }
          paramInt = 0;
        } while (!((ajex)localObject).a(str2, paramInt));
        paramString = paramString.c(paramRecentBaseData.a());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          paramInt = 0;
          paramString = new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject = paramRecentBaseData.a();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
        {
          paramString.a(new String[] { localObject, String.valueOf(paramInt), paramRecentBaseData }).a();
          break;
          paramInt = 1;
          break label179;
          paramInt = 0;
          break label238;
          paramInt = 3;
          break label238;
        }
        if (QLog.isColorLevel()) {
          QLog.e("tag_hidden_chat", 2, "TroopManage.getTroopCodeByTroopUin return null...");
        }
        paramInt = paramRecentBaseData.a();
        if ((str1 != null) && (str1.length() != 0) && (localObject != null)) {
          break label455;
        }
      } while (!QLog.isColorLevel());
      label179:
      label318:
      label340:
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (str1 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localObject != null) {
          break label449;
        }
      }
      label449:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("tag_hidden_chat", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
      label455:
      paramString = ((akeu)localObject).b(str1, paramInt);
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = new RecentUser(str1, paramInt);
      }
      if (ascr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData))
      {
        if (paramBoolean) {}
        for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
        {
          ((akeu)localObject).a(paramRecentBaseData);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
          break;
        }
        label534:
        if ((paramInt == 0) && (paramString.b(str1)))
        {
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramBoolean) {}
          for (int i = 1;; i = 2)
          {
            awqx.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
            if (badq.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
              break;
            }
            bbmy.a(getActivity(), 1, 2131630710, 0).b(getActivity().getTitleBarHeight());
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "setChatAtTop top: " + paramBoolean + " uin: " + str1 + " userType: " + paramInt);
          }
          FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, paramBoolean);
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!(paramRecentBaseData instanceof RecentUserBaseData)) && (QLog.isColorLevel())) {
      QLog.d("tag_hidden_chat", 2, "NOT THE RIGHT Recent type");
    }
    paramView = ((RecentUserBaseData)paramRecentBaseData).a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("hidden_aio_msg_source", 1);
    ahcq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getActivity().overridePendingTransition(2130771992, 2130771993);
    paramRecentBaseData.b();
    befx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.a());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (!FeedsManager.isShowStatus(paramView.uin)) {
        break label185;
      }
      paramString = (acjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      if (paramString != null)
      {
        long l = paramString.a(paramView.uin);
        FeedsManager.saveToken(paramView.uin, l);
        paramRecentBaseData.reportClickExpose();
        paramString.a(2, 2);
      }
    }
    label185:
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
      } while ((paramView == null) || (paramView.msgtype != -1034));
      paramView = (acjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    } while (paramView == null);
    paramView.a(2, 1);
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramString = null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      paramString = localRecentUserBaseData.a();
      i = localRecentUserBaseData.mPosition;
    }
    if (paramString != null)
    {
      ahco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
      ahcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
      ariz.a().b(paramString.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    a();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.a();
    if ((i == 1) && (this.jdField_a_of_type_Ahcp == null)) {
      this.jdField_a_of_type_Ahcp = new ahcp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    if (azzz.a(paramString1, localResources.getString(2131625680)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!azzz.a(paramString1, localResources.getString(ahbj.a[4]))) {
        break label201;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        ahcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      }
    }
    label201:
    while ((!azzz.a(paramString1, localResources.getString(ahbj.a[5]))) || (!(paramRecentBaseData instanceof RecentUserBaseData)))
    {
      return;
      if (azzz.a(paramString1, localResources.getString(2131625684)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (azzz.a(paramString1, localResources.getString(2131627558)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        break;
      }
      if (!azzz.a(paramString1, localResources.getString(2131627560))) {
        break;
      }
      a(i, paramRecentBaseData, paramString2, true);
      break;
    }
    paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.getType(), 1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      awqx.b(getActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(HiddenChatSettingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.s();
    }
    this.jdField_a_of_type_Ajys = new ajys(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131301900));
    this.jdField_a_of_type_Ahai = new ahai(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 0);
    this.jdField_a_of_type_Ahai.a(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahai);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_Ahai.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131630935));
    this.rightViewText.setText(2131653544);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = getMiniMsgUserParam();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131496715;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    Object localObject = getActivity().getApplication().getResources().getDrawable(2130840653);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getActivity());
    int k = bajq.b(16.0F);
    m = (bajq.b(52.0F) - m) / 2;
    int n = bajq.b(56.0F);
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = bajq.a(5.0F);
    localObject = new MiniMsgUserParam();
    ((MiniMsgUserParam)localObject).businessName = 24;
    ((MiniMsgUserParam)localObject).accessType = 0;
    ((MiniMsgUserParam)localObject).entryType = 1;
    ((MiniMsgUserParam)localObject).positionX = (i - (k - m) - n - i1);
    ((MiniMsgUserParam)localObject).positionY = (i2 + j);
    ((MiniMsgUserParam)localObject).colorType = 1;
    ((MiniMsgUserParam)localObject).filterMsgType = 1;
    return localObject;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    acxd.a(getActivity(), QQSettingChatOperationFragment.class);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      HiddenChatSettingFragment.a(getActivity(), 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_a_of_type_Ahai != null) {
      this.jdField_a_of_type_Ahai.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_a_of_type_Ahai = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    MiniMsgIPCClient.getInstance().clearBusiness(24);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showEntry();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (acxd.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */