package com.tencent.mobileqq.app.hiddenchat;

import abol;
import aely;
import afai;
import ajdx;
import ajee;
import ajgk;
import ajgl;
import ajgm;
import ajgx;
import alkk;
import alkl;
import alox;
import aloz;
import alpr;
import alzf;
import amab;
import amer;
import ames;
import amet;
import ameu;
import amjk;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import atwd;
import aupu;
import azmj;
import azmo;
import bdal;
import bdee;
import bdkf;
import bhpd;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class HiddenChatFragment
  extends IphoneTitleBarFragment
  implements ajdx, ajgx, Handler.Callback, View.OnClickListener, Observer
{
  ajee jdField_a_of_type_Ajee;
  private ajgl jdField_a_of_type_Ajgl;
  protected alkl a;
  private alox jdField_a_of_type_Alox = new ameu(this);
  private amab jdField_a_of_type_Amab = new amet(this);
  private amer jdField_a_of_type_Amer;
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private MqqHandler b;
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_Alkl = new ames(this);
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
  
  private void a(List<RecentBaseData> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1) || (getActivity() == null) || (getActivity().getIntent() == null)) {}
    while (this.jdField_a_of_type_Ajee == null) {
      return;
    }
    this.jdField_a_of_type_Ajee.a(0);
    this.jdField_a_of_type_Ajee.a(paramList);
    int m = getActivity().getIntent().getIntExtra("FromType", 0);
    int j;
    int i;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      j = 0;
      i = 0;
      if (paramList.hasNext())
      {
        int k;
        if (((RecentBaseData)paramList.next()).a() == 1)
        {
          k = j;
          j = i + 1;
        }
        for (i = k;; i = k)
        {
          k = j;
          j = i;
          i = k;
          break;
          k = j + 1;
          j = i;
        }
      }
    }
    for (;;)
    {
      azmj.b(getActivity().app, "dc00898", "", "", "0X800A34B", "0X800A34B", m, j, "" + i, "0", "", "");
      return;
      j = 0;
      i = 0;
    }
  }
  
  public void a()
  {
    HiddenChatFragment.1 local1 = new HiddenChatFragment.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(local1);
      }
    }
    while (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      return;
    }
    local1.run();
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject;
    String str1;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      str1 = paramRecentBaseData.a();
      paramString = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramInt != 5000) {
        break label91;
      }
      if (this.jdField_a_of_type_Ajgl != null) {
        this.jdField_a_of_type_Ajgl.a(paramRecentBaseData, paramBoolean);
      }
    }
    for (;;)
    {
      label60:
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
      label91:
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
            ((alpr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
            break label60;
          }
          if (paramInt != 1) {
            break label531;
          }
          paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          str2 = paramString.d(paramRecentBaseData.a());
          if (TextUtils.isEmpty(str2)) {
            break label340;
          }
          localObject = (alkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
          if (!paramBoolean) {
            break label318;
          }
          paramInt = 0;
        } while (!((alkk)localObject).a(str2, paramInt));
        paramString = paramString.c(paramRecentBaseData.a());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          paramInt = 0;
          paramString = new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
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
          break label177;
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
          break label457;
        }
      } while (!QLog.isColorLevel());
      label177:
      label318:
      label340:
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (str1 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localObject != null) {
          break label451;
        }
      }
      label451:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("tag_hidden_chat", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
      label457:
      paramString = ((amjk)localObject).b(str1, paramInt);
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = new RecentUser(str1, paramInt);
      }
      if (aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData))
      {
        if (paramBoolean) {}
        for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
        {
          ((amjk)localObject).a(paramRecentBaseData);
          a();
          break;
        }
        label531:
        if ((paramInt == 0) && (paramString.b(str1)))
        {
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramBoolean) {}
          for (int i = 1;; i = 2)
          {
            azmj.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
            if (bdee.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
              break;
            }
            QQToast.a(getActivity(), 1, 2131696588, 0).b(getActivity().getTitleBarHeight());
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
    ajgm.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getActivity().overridePendingTransition(2130771992, 2130771993);
    paramRecentBaseData.b();
    bhpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.a());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (!FeedsManager.isShowStatus(paramView.uin)) {
        break label186;
      }
      paramString = (aely)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      if (paramString != null)
      {
        long l = paramString.a(paramView.uin);
        FeedsManager.saveToken(paramView.uin, l);
        paramRecentBaseData.reportClickExpose();
        paramString.a(2, 2);
      }
    }
    label186:
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
      } while ((paramView == null) || (paramView.msgtype != -1034));
      paramView = (aely)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
      ajgk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
      ajgm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
      atwd.a().b(paramString.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    a();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.a();
    if ((i == 1) && (this.jdField_a_of_type_Ajgl == null)) {
      this.jdField_a_of_type_Ajgl = new ajgl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    if (bdal.a(paramString1, localResources.getString(2131691309)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!bdal.a(paramString1, localResources.getString(ajff.a[4]))) {
        break label242;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        ajgm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.a(), true, true);
        a();
      }
      label114:
      if (bdal.a(paramString1, localResources.getString(2131691308)))
      {
        if (bdee.d(BaseApplication.getContext())) {
          break label300;
        }
        QQToast.a(BaseApplication.getContext(), 2131692397, 1, 0).b(getActivity().getTitleBarHeight());
      }
    }
    label242:
    do
    {
      return;
      if (bdal.a(paramString1, localResources.getString(2131691313)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bdal.a(paramString1, localResources.getString(2131693300)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        break;
      }
      if (!bdal.a(paramString1, localResources.getString(2131693302))) {
        break;
      }
      a(i, paramRecentBaseData, paramString2, true);
      break;
      if ((!bdal.a(paramString1, localResources.getString(ajff.a[5]))) || (!(paramRecentBaseData instanceof RecentUserBaseData))) {
        break label114;
      }
      paramString2 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2.uin, paramString2.getType(), 1);
      a();
      break label114;
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.a();
      if (i == 1)
      {
        i = (int)NetConnInfoCenter.getServerTime();
        ((alzf)getActivity().app.a(20)).a(paramString1, getActivity().app.c(), 0, 512, i);
        return;
      }
    } while (i != 0);
    label300:
    ((FriendListHandler)getActivity().app.a(1)).a(new String[] { paramString1 }, new boolean[] { false }, new int[] { i });
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1))
    {
      a();
      azmj.b(getActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getRecentThreadLooper(), this);
    this.b = new MqqHandler(Looper.getMainLooper(), this);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(HiddenChatSettingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.s();
    }
    this.jdField_a_of_type_Amer = new amer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131367645));
    this.jdField_a_of_type_Ajee = new ajee(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 0);
    this.jdField_a_of_type_Ajee.a(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajee);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_Ajee.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131696823));
    this.rightViewText.setText(2131719870);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = getMiniMsgUserParam();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131562519;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    Object localObject = getActivity().getApplication().getResources().getDrawable(2130840796);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getActivity());
    int k = bdkf.b(16.0F);
    m = (bdkf.b(52.0F) - m) / 2;
    int n = bdkf.b(56.0F);
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = bdkf.a(5.0F);
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
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getActivity() == null) || (!getActivity().app.isLogin())) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a();
      continue;
      a((List)paramMessage.obj);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    afai.a(getActivity(), QQSettingChatOperationFragment.class);
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
    if (this.jdField_a_of_type_Ajee != null) {
      this.jdField_a_of_type_Ajee.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_a_of_type_Ajee = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    MiniMsgIPCClient.getInstance().clearBusiness(24);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
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
      if (afai.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    }
    else
    {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */