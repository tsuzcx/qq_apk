package com.tencent.mobileqq.apollo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.apollo.ApolloGameBtnData;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.apollo.ApolloPushManager.OnPushObserver;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import ykn;
import ykp;
import ykq;
import ykr;
import yks;
import ykt;
import ykv;
import ykx;
import yky;
import ykz;
import yla;

public class HotChatCenterFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, ApolloPushManager.OnPushObserver, Observer
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ykn(this);
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new ykr(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new yks(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TransProcessorHandler a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap a;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public HotChatCenterFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ykq(this);
  }
  
  public static AioPushData a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = (ApolloDaoManager)paramQQAppInterface.getManager(154);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString, paramInt);
    }
    return null;
  }
  
  private List a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      return localArrayList1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = new RecentHotchatItem((HotChatItemData)localObject2);
        ((RecentHotchatItem)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
        if (((RecentHotchatItem)localObject2).c() > 0)
        {
          localArrayList1.add(localObject2);
          localArrayList1.add(RecentHotchatItem.a());
        }
        else
        {
          localArrayList2.add(localObject2);
        }
      }
    }
    if ((localArrayList2.size() == 0) && (localArrayList1.size() > 0)) {
      localArrayList1.remove(localArrayList1.size() - 1);
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, AioPushData paramAioPushData, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramAioPushData == null) || (TextUtils.isEmpty(paramString))) {
      QLog.e("HotchatActivity", 1, "[enterPage] para is null");
    }
    do
    {
      return;
      ThreadManager.post(new ykz(paramAioPushData, paramQQAppInterface), 8, null, true);
      paramQQAppInterface = paramAioPushData.url;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        break;
      }
      paramAioPushData = new Intent(paramContext, QQBrowserActivity.class);
      paramAioPushData.putExtra("url", paramQQAppInterface);
      paramContext.startActivity(paramAioPushData);
    } while (!QLog.isColorLevel());
    QLog.d("HotchatActivity", 2, String.format("[enterPage] url:%s", new Object[] { paramQQAppInterface }));
    return;
    QLog.e("HotchatActivity", 1, "[enterPage] url is empty");
  }
  
  public static void a(AioPushData paramAioPushData, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramAioPushData != null))
    {
      paramQQAppInterface = (ApolloDaoManager)paramQQAppInterface.getManager(154);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.b(paramAioPushData);
        return;
      }
      QLog.e("HotchatActivity", 1, "[removePushItem] dao manager is null");
      return;
    }
    QLog.e("HotchatActivity", 1, "[removePushItem] app or item null");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ForwardImageProcessor.class });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.e.findViewById(2131364762));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new yla(this, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this, 10);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void f()
  {
    if (isAdded())
    {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList = a();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254)).a(((QQMessageFacade.Message)localObject).time);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  protected int a()
  {
    return 2130969027;
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (paramRecentBaseData != null))
    {
      if (paramBoolean)
      {
        ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramRecentBaseData.a());
        if ((paramRecentBaseData instanceof RecentHotchatItem))
        {
          paramInt = ((RecentHotchatItem)paramRecentBaseData).c();
          if (paramInt > 0) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "top_game_reliao", 0, 0, new String[] { String.valueOf(paramInt) });
          }
        }
        if ((paramRecentBaseData instanceof RecentHotchatItem)) {
          ((RecentHotchatItem)paramRecentBaseData).a();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
        return;
        ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramRecentBaseData.a());
      }
    }
    QLog.e("HotchatActivity", 1, String.format("[doShowUpMsg] up %s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotchatActivity", 2, "[onReceivePush] from manager");
    }
    if ((paramObject != null) && ((paramObject instanceof AioPushData)))
    {
      paramInt = ((AioPushData)paramObject).busId;
      String str = ((AioPushData)paramObject).them;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        Object localObject1 = ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        if (localObject1 != null)
        {
          boolean bool2 = false;
          boolean bool1 = bool2;
          Object localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
            bool1 = bool2;
            if (localObject2 != null) {
              bool1 = ((ApolloDaoManager)localObject2).a((AioPushData)paramObject);
            }
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (HotChatItemData)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((HotChatItemData)localObject2).mHotChatCode != null) && (((HotChatItemData)localObject2).mHotChatCode.equals(str)) && (paramInt == ((HotChatItemData)localObject2).mGameId))
            {
              if (!bool1)
              {
                ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(((HotChatItemData)localObject2).mHotChatCode, ((AioPushData)paramObject).wording);
                ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(((HotChatItemData)localObject2).mTroopUin);
                ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(((HotChatItemData)localObject2).mTroopUin, 1);
              }
              if (QLog.isColorLevel()) {
                QLog.d("HotchatActivity", 2, "[onReceivePush] read");
              }
              c();
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    paramString2 = new CmGameStartChecker.StartCheckParam(paramInt1, true, "message", 0L, 6, 1, 0, 0, paramString2, 202);
    paramString2.extendJson = String.format("{\"actId\":\"%s\"}", new Object[] { paramString3 });
    paramString2.mFriendUin = paramString1;
    ApolloGameUtil.a(getActivity(), paramString2);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (isAdded())
    {
      paramLayoutInflater = getActivity().getWindow();
      if (paramLayoutInflater != null)
      {
        if (Build.VERSION.SDK_INT >= 11) {
          paramLayoutInflater.setFlags(16777216, 16777216);
        }
        paramLayoutInflater.setBackgroundDrawable(null);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254));
      if (isAdded())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
        }
        this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(getActivity().getMainLooper(), this);
        paramLayoutInflater = (ApolloPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(226);
        if (paramLayoutInflater != null) {
          paramLayoutInflater.a(this);
        }
      }
      a("热聊房间");
      e();
      c();
      f();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentHotchatItem)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] data is null");
    }
    Object localObject1;
    int i;
    Object localObject2;
    AioPushData localAioPushData;
    label180:
    label241:
    do
    {
      return;
      paramString = (RecentHotchatItem)paramRecentBaseData;
      switch (paramView.getId())
      {
      default: 
        QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick]");
      case 2131363182: 
        for (;;)
        {
          localObject1 = paramRecentBaseData.a();
          i = paramRecentBaseData.a();
          if ((localObject1 == null) || (i != 1)) {
            break;
          }
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          paramView = ((HotChatManager)localObject2).a(paramRecentBaseData.a());
          if (paramString.c() > 0)
          {
            i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 1);
            localAioPushData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramString.c(), paramString.c());
            if (i > 0) {
              break label789;
            }
            i = 0;
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_game_reliao", i, 0, new String[] { String.valueOf(paramString.c()) });
          }
          if (paramView != null) {
            break label1007;
          }
          paramView = ((HotChatManager)localObject2).a(paramString.c());
          if ((paramView == null) || (paramView.state != 0)) {
            break label1001;
          }
          i = 1;
          if ((paramString.c() > 0) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (paramString.d()) && (!paramString.c()))
          {
            ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramString.a(), 2);
            ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramString.a());
          }
          if ((paramView == null) || (paramView.state != 0)) {
            break label875;
          }
          if (i == 0) {
            break label806;
          }
          if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
            break;
          }
          ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b((String)localObject1);
          return;
          QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] click relativeItem");
        }
      }
      QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] click apollo_hotchat_item_activity_layout");
      paramView = ApolloGameUtil.a(paramString.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramRecentBaseData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramString.c());
    } while (paramRecentBaseData == null);
    if (paramView != null)
    {
      if (!isAdded()) {
        break label1013;
      }
      if (paramView.mSpRegion == 0)
      {
        paramString = new Intent(getActivity(), QQBrowserActivity.class);
        paramString.putExtra("url", paramView.mUrl);
        getActivity().startActivity(paramString);
        i = 0;
      }
    }
    for (;;)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int j;
      label488:
      int m;
      int k;
      if (paramView == null)
      {
        j = 0;
        m = paramRecentBaseData.gameId;
        if (paramView != null) {
          break label775;
        }
        k = 0;
        label501:
        if (paramView != null) {
          break label781;
        }
      }
      label775:
      label781:
      for (paramView = "";; paramView = paramView.mActId)
      {
        VipUtils.a(paramString, "cmshow", "Apollo", "clk_reliao_game_activity", j, i, new String[] { String.valueOf(m), String.valueOf(k), paramView });
        return;
        a(paramString.c(), paramRecentBaseData.openKey, "", paramView.mSpRegion, paramView.mActId);
        i = 1;
        break;
        localObject1 = paramRecentBaseData.getHomeActionBtn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject1 != null) {
          a(paramString.c(), paramRecentBaseData.openKey, "", ((ApolloGameBtnData)localObject1).b, "");
        }
        for (i = 1;; i = 0)
        {
          QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] no activity ");
          break;
          localObject2 = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(paramRecentBaseData.gameId);
          localObject1 = new StringBuilder(100);
          ((StringBuilder)localObject1).append(ApolloConstant.N).append("&aio_type=").append(ApolloUtil.b(paramString.a())).append("&aio_id=").append(paramString.a()).append("&game_id=").append(paramRecentBaseData.gameId).append("&game_version=").append((String)localObject2);
          paramString = new Intent(getActivity(), QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserActivity(getActivity(), ((StringBuilder)localObject1).toString(), -1L, paramString, false, -1);
        }
        j = paramView.mDotId;
        break label488;
        k = 1;
        break label501;
      }
      label789:
      if (localAioPushData != null)
      {
        i = 1;
        break label180;
      }
      i = 2;
      break label180;
      label806:
      localObject1 = Message.obtain();
      ((Message)localObject1).what = 2;
      ((Message)localObject1).obj = new Object[] { paramRecentBaseData.a(), paramView.troopCode, paramView.name, Integer.valueOf(paramString.c()) };
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      return;
      label875:
      paramView = paramString.c();
      i = paramString.c();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, paramView);
      }
      ThreadManager.postImmediately(new ykx(this, paramView, i), null, true);
      QLog.e("HotchatActivity", 1, String.format("[onRecentBaseDataClick] info is null and re join code:%s id:%s", new Object[] { paramView, Integer.valueOf(i) }));
      return;
      label1001:
      i = 0;
      break label241;
      label1007:
      i = 0;
      break label241;
      label1013:
      i = 0;
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      String str = paramRecentBaseData.a();
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[ onRecentBaseDataDelete] delete " + str);
      }
      if ((paramRecentBaseData instanceof RecentHotchatItem))
      {
        int i = ((RecentHotchatItem)paramRecentBaseData).c();
        if (i > 0) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "delete_reliao_enter", 0, 0, new String[] { String.valueOf(i) });
        }
      }
      b(str, paramRecentBaseData, paramString);
      return;
    }
    QLog.e("HotchatActivity", 1, "[onRecentBaseDataDelete] delete when uin is null");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    int i = paramRecentBaseData.a();
    if (i == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[onMenuItemClick]");
      }
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
        a(i, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.a() != 1) || (!Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]), paramString1)))
    {
      do
      {
        return;
      } while (!Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3])));
      a(i, paramRecentBaseData, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("HotchatActivity", 1, "[addActivity] app is null");
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("HotchatActivity", 1, "[addActivity] uin is null");
          return;
        }
        paramString2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramInt);
      } while (paramString2 == null);
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1);
      ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString1, 22, l, paramString2.wording, 0);
    } while (!QLog.isColorLevel());
    QLog.d("HotchatActivity", 2, paramString2.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((e()) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[onChange] end of drag");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.f == null) || (this.f == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null) {}
    for (int i = ((QQMessageFacade)localObject).b();; i = 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("返回");
        this.f.setVisibility(0);
      }
      for (localObject = this.f; localObject != null; localObject = this.jdField_b_of_type_AndroidWidgetTextView)
      {
        ThreadManager.post(new ykt(this, i, (TextView)localObject), 8, null, true);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.f.setVisibility(8);
      }
      break;
    }
  }
  
  public void b(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramString1);
      if (localObject == null) {
        break label63;
      }
      HotChatHelper.a((HotChatInfo)localObject, new yky(this, (HotChatInfo)localObject, paramString1, paramRecentBaseData, paramString2));
    }
    label63:
    do
    {
      return;
      ((yla)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter).b(paramRecentBaseData, paramString2);
      QLog.e("HotchatActivity", 1, "[exitHotChat] uin null");
    } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d("HotchatActivity", 2, "remove");
    }
    ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramString1);
  }
  
  public void c()
  {
    ThreadManager.post(new ykv(this), 8, null, true);
  }
  
  public boolean d()
  {
    StatisticTroopAssist.e(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return super.d();
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      QLog.e("HotchatActivity", 1, "[handleMessage] not found command");
    case 1: 
    case 2: 
      String str;
      do
      {
        return true;
        c();
        return true;
        if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Object[]))) {
          break label337;
        }
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage.length < 4) || (!(paramMessage[0] instanceof String)) || (!(paramMessage[1] instanceof String)) || (!(paramMessage[2] instanceof String)) || (!(paramMessage[3] instanceof Integer))) {
          break;
        }
        Object localObject = new Intent(getActivity(), SplashActivity.class);
        str = (String)paramMessage[0];
        localObject = AIOUtils.a((Intent)localObject, null);
        ((Intent)localObject).putExtra("uin", str);
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("troop_uin", (String)paramMessage[1]);
        ((Intent)localObject).putExtra("uinname", (String)paramMessage[2]);
        if ((paramMessage.length >= 5) && ((paramMessage[4] instanceof Boolean))) {
          ((Intent)localObject).putExtra("startApolloGame", (Boolean)paramMessage[4]);
        }
        a(str, (String)paramMessage[2], ((Integer)paramMessage[3]).intValue());
        startActivity((Intent)localObject);
        localObject = getActivity();
        if ((localObject != null) && (isAdded())) {
          ((FragmentActivity)localObject).overridePendingTransition(2131034144, 2131034145);
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotchatActivity", 2, String.format("[handleMessage] uin:%s uin_type:%s troop_uin:%s uin_name:%s", new Object[] { str, Integer.valueOf(1), (String)paramMessage[1], (String)paramMessage[2] }));
      return true;
      QLog.e("HotchatActivity", 1, "[handleMessage] msg para invalid");
      return true;
      label337:
      QLog.e("HotchatActivity", 1, "[handleMessage] msg obj invalid");
      return true;
    }
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QQToast.a(BaseApplication.getContext(), paramMessage, 0).a();
      return true;
    }
    QLog.e("HotchatActivity", 1, "[handleMessage] toast without wording");
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (isAdded()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ApolloPushManager localApolloPushManager;
      do
      {
        for (;;)
        {
          QLog.e("HotchatActivity", 1, localThrowable, new Object[0]);
        }
        if (isAdded())
        {
          getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        localApolloPushManager = (ApolloPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(226);
      } while (localApolloPushManager == null);
      localApolloPushManager.a(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    h();
  }
  
  public void onResume()
  {
    super.onResume();
    c();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (isAdded())) {
        getActivity().runOnUiThread(new ykp(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment
 * JD-Core Version:    0.7.0.1
 */