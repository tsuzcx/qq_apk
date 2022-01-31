package com.tencent.mobileqq.app.hiddenchat;

import acuo;
import adic;
import ahmg;
import ahmo;
import ahmv;
import ahpb;
import ahpc;
import ahpd;
import ahpo;
import ajsx;
import ajsy;
import ajxj;
import ajxl;
import ajyd;
import akhp;
import akil;
import aknb;
import aknc;
import aknd;
import akne;
import aknf;
import akpb;
import aktf;
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
import asfd;
import asyx;
import axqy;
import axrc;
import bbbr;
import bbfj;
import bbll;
import bcql;
import bfoi;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
  implements ahmo, ahpo, View.OnClickListener, Observer
{
  ahmv jdField_a_of_type_Ahmv;
  private ahpc jdField_a_of_type_Ahpc;
  protected ajsy a;
  private ajxj jdField_a_of_type_Ajxj = new aknf(this);
  private akil jdField_a_of_type_Akil = new akne(this);
  private aknb jdField_a_of_type_Aknb;
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aknc(this);
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_Ajsy = new aknd(this);
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
    this.jdField_a_of_type_Aknb.a((List)localObject1);
    Object localObject2 = a((List)localObject1, asfd.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
      ahmg.a((List)localObject2, localQQAppInterface, localFragmentActivity, (List)localObject1, i);
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
        Collections.sort((List)localObject1, this.jdField_a_of_type_Aknb);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (this.jdField_a_of_type_Ahmv != null))
        {
          this.jdField_a_of_type_Ahmv.a(0);
          this.jdField_a_of_type_Ahmv.a((List)localObject1);
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
      axqy.b(getActivity().app, "dc00898", "", "", "0X800A34B", "0X800A34B", k, j, "" + i, "0", "", "");
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
      paramString = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramInt != 5000) {
        break label93;
      }
      if (this.jdField_a_of_type_Ahpc != null) {
        this.jdField_a_of_type_Ahpc.a(paramRecentBaseData, paramBoolean);
      }
    }
    for (;;)
    {
      label60:
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
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
            ((ajyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
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
          localObject = (ajsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
          if (!paramBoolean) {
            break label318;
          }
          paramInt = 0;
        } while (!((ajsx)localObject).a(str2, paramInt));
        paramString = paramString.c(paramRecentBaseData.a());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          paramInt = 0;
          paramString = new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
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
      paramString = ((aktf)localObject).b(str1, paramInt);
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = new RecentUser(str1, paramInt);
      }
      if (asyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData))
      {
        if (paramBoolean) {}
        for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
        {
          ((aktf)localObject).a(paramRecentBaseData);
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
            axqy.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
            if (bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
              break;
            }
            bcql.a(getActivity(), 1, 2131696414, 0).b(getActivity().getTitleBarHeight());
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
    ahpd.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getActivity().overridePendingTransition(2130771992, 2130771993);
    paramRecentBaseData.b();
    bfoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.a());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (!FeedsManager.isShowStatus(paramView.uin)) {
        break label185;
      }
      paramString = (acuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
      paramView = (acuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
      ahpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
      ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
      asfd.a().b(paramString.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    a();
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.a();
    if ((i == 1) && (this.jdField_a_of_type_Ahpc == null)) {
      this.jdField_a_of_type_Ahpc = new ahpc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    if (bbbr.a(paramString1, localResources.getString(2131691256)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!bbbr.a(paramString1, localResources.getString(ahnw.a[4]))) {
        break label247;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      }
      label119:
      if (bbbr.a(paramString1, localResources.getString(2131691255)))
      {
        if (bbfj.d(BaseApplication.getContext())) {
          break label310;
        }
        bcql.a(BaseApplication.getContext(), 2131692321, 1, 0).b(getActivity().getTitleBarHeight());
      }
    }
    label247:
    do
    {
      return;
      if (bbbr.a(paramString1, localResources.getString(2131691260)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bbbr.a(paramString1, localResources.getString(2131693199)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        break;
      }
      if (!bbbr.a(paramString1, localResources.getString(2131693201))) {
        break;
      }
      a(i, paramRecentBaseData, paramString2, true);
      break;
      if ((!bbbr.a(paramString1, localResources.getString(ahnw.a[5]))) || (!(paramRecentBaseData instanceof RecentUserBaseData))) {
        break label119;
      }
      paramString2 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2.uin, paramString2.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      break label119;
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.a();
      if (i == 1)
      {
        i = (int)NetConnInfoCenter.getServerTime();
        ((akhp)getActivity().app.a(20)).a(paramString1, getActivity().app.c(), 0, 512, i);
        return;
      }
    } while (i != 0);
    label310:
    ((FriendListHandler)getActivity().app.a(1)).a(new String[] { paramString1 }, new boolean[] { false }, new int[] { i });
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      axqy.b(getActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(HiddenChatSettingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.s();
    }
    this.jdField_a_of_type_Aknb = new aknb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131367517));
    this.jdField_a_of_type_Ahmv = new ahmv(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 0);
    this.jdField_a_of_type_Ahmv.a(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahmv);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_Ahmv.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131696648));
    this.rightViewText.setText(2131719384);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = getMiniMsgUserParam();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131562315;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    Object localObject = getActivity().getApplication().getResources().getDrawable(2130840686);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getActivity());
    int k = bbll.b(16.0F);
    m = (bbll.b(52.0F) - m) / 2;
    int n = bbll.b(56.0F);
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = bbll.a(5.0F);
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
    adic.a(getActivity(), QQSettingChatOperationFragment.class);
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
    if (this.jdField_a_of_type_Ahmv != null) {
      this.jdField_a_of_type_Ahmv.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_a_of_type_Ahmv = null;
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
      if (adic.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
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