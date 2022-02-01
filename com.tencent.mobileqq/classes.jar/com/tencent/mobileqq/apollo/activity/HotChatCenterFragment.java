package com.tencent.mobileqq.apollo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnPushObserver;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
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

public class HotChatCenterFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, IApolloPushManager.OnPushObserver, Observer
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new HotChatCenterFragment.1(this);
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new HotChatCenterFragment.3(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new HotChatCenterFragment.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TransProcessorHandler a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeakReference<HotChatCenterManager> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<String, String> a;
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public HotChatCenterFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new HotChatCenterFragment.2(this);
  }
  
  public static AioPushData a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getAioPushData(paramString, paramInt);
    }
    return null;
  }
  
  private List<RecentBaseData> a()
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
        if (((RecentHotchatItem)localObject2).a() > 0)
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
      ThreadManager.post(new HotChatCenterFragment.9(paramAioPushData, paramQQAppInterface), 8, null, true);
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
      paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.removeAioPushData(paramAioPushData);
        return;
      }
      QLog.e("HotchatActivity", 1, "[removePushItem] dao manager is null");
      return;
    }
    QLog.e("HotchatActivity", 1, "[removePushItem] app or item null");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ForwardImageProcessor.class });
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131368542));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new HotChatCenterFragment.HotCenterAdapter(this, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this, 10);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void e()
  {
    if (isAdded())
    {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilList = a();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((RecentBaseData)localObject).getRecentUserUin(), ((RecentBaseData)localObject).getRecentUserType());
        if (localObject != null)
        {
          ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(((com.tencent.imcore.message.Message)localObject).time);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localObject != null) {}
    for (int i = ((QQMessageFacade)localObject).b();; i = 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131705567));
        this.mLeftBackText.setVisibility(0);
      }
      for (localObject = this.mLeftBackText; localObject != null; localObject = this.leftView)
      {
        ThreadManager.post(new HotChatCenterFragment.5(this, i, (TextView)localObject), 8, null, true);
        return;
        this.leftView.setVisibility(0);
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
      }
      break;
    }
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (paramRecentBaseData != null))
    {
      if (paramBoolean)
      {
        ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramRecentBaseData.getRecentUserUin());
        if ((paramRecentBaseData instanceof RecentHotchatItem))
        {
          paramInt = ((RecentHotchatItem)paramRecentBaseData).a();
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
        ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramRecentBaseData.getRecentUserUin());
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
            localObject2 = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
            bool1 = bool2;
            if (localObject2 != null) {
              bool1 = ((ApolloDaoManagerServiceImpl)localObject2).hasAioPushData((AioPushData)paramObject);
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
              b();
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
    paramString2 = new CmGameStartChecker.StartCheckParam(paramInt1, true, "message", 0L, 6, 1, 0, 0, paramString2, 202, null);
    paramString2.extendJson = String.format("{\"actId\":\"%s\"}", new Object[] { paramString3 });
    paramString2.mFriendUin = paramString1;
    ApolloGameUtil.a(getActivity(), paramString2);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentHotchatItem)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] data is null");
    }
    label77:
    Object localObject1;
    int i;
    do
    {
      return;
      paramString = (RecentHotchatItem)paramRecentBaseData;
      switch (paramView.getId())
      {
      default: 
        QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick]");
        localObject1 = paramRecentBaseData.getRecentUserUin();
        i = paramRecentBaseData.getRecentUserType();
      }
    } while ((localObject1 == null) || (i != 1));
    Object localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    paramView = ((HotChatManager)localObject2).a(paramRecentBaseData.getRecentUserUin());
    AioPushData localAioPushData;
    if (paramString.a() > 0)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a((String)localObject1, 1);
      localAioPushData = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getAioPushData(paramString.a(), paramString.a());
      if (i <= 0)
      {
        i = 0;
        label182:
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_game_reliao", i, 0, new String[] { String.valueOf(paramString.a()) });
      }
    }
    else
    {
      if (paramView != null) {
        break label992;
      }
      paramView = ((HotChatManager)localObject2).a(paramString.a());
      if ((paramView == null) || (paramView.state != 0)) {
        break label986;
      }
      i = 1;
    }
    for (;;)
    {
      if ((paramString.a() > 0) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (paramString.c()) && (!paramString.b()))
      {
        ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramString.getRecentUserUin(), 2);
        ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramString.getRecentUserUin());
      }
      if ((paramView != null) && (paramView.state == 0))
      {
        if (i != 0)
        {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
            break;
          }
          ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b((String)localObject1);
          return;
          QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] click relativeItem");
          break label77;
          QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] click apollo_hotchat_item_activity_layout");
          paramView = ApolloGameUtil.a(paramString.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramRecentBaseData = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramString.a());
          if (paramRecentBaseData == null) {
            break;
          }
          int j;
          label491:
          int m;
          int k;
          if (paramView != null)
          {
            if (!isAdded()) {
              break label745;
            }
            if (paramView.mSpRegion == 0)
            {
              paramString = new Intent(getActivity(), QQBrowserActivity.class);
              paramString.putExtra("url", paramView.mUrl);
              getActivity().startActivity(paramString);
              i = 0;
              paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramView != null) {
                break label751;
              }
              j = 0;
              m = paramRecentBaseData.gameId;
              if (paramView != null) {
                break label760;
              }
              k = 0;
              label504:
              if (paramView != null) {
                break label766;
              }
            }
          }
          label745:
          label751:
          label760:
          label766:
          for (paramView = "";; paramView = paramView.mActId)
          {
            VipUtils.a(paramString, "cmshow", "Apollo", "clk_reliao_game_activity", j, i, new String[] { String.valueOf(m), String.valueOf(k), paramView });
            return;
            a(paramString.a(), paramRecentBaseData.openKey, "", paramView.mSpRegion, paramView.mActId);
            i = 1;
            break;
            localObject2 = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloGameLocalVersion(paramRecentBaseData.gameId);
            localObject1 = new StringBuilder(100);
            ((StringBuilder)localObject1).append(ApolloConstant.k).append("&aio_type=").append(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramString.getRecentUserType())).append("&aio_id=").append(paramString.getRecentUserUin()).append("&game_id=").append(paramRecentBaseData.gameId).append("&game_version=").append((String)localObject2);
            paramString = new Intent(getActivity(), QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
            VasWebviewUtil.openQQBrowserActivity(getActivity(), ((StringBuilder)localObject1).toString(), -1L, paramString, false, -1);
            QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] no activity ");
            i = 0;
            break;
            j = paramView.mDotId;
            break label491;
            k = 1;
            break label504;
          }
          if (localAioPushData != null)
          {
            i = 1;
            break label182;
          }
          i = 2;
          break label182;
        }
        localObject1 = android.os.Message.obtain();
        ((android.os.Message)localObject1).what = 2;
        ((android.os.Message)localObject1).obj = new Object[] { paramRecentBaseData.getRecentUserUin(), paramView.troopCode, paramView.name, Integer.valueOf(paramString.a()) };
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((android.os.Message)localObject1);
        return;
      }
      paramView = paramString.a();
      i = paramString.a();
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
      ThreadManager.postImmediately(new HotChatCenterFragment.7(this, paramView, i), null, true);
      QLog.e("HotchatActivity", 1, String.format("[onRecentBaseDataClick] info is null and re join code:%s id:%s", new Object[] { paramView, Integer.valueOf(i) }));
      return;
      label986:
      i = 0;
      continue;
      label992:
      i = 0;
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      String str = paramRecentBaseData.getRecentUserUin();
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[ onRecentBaseDataDelete] delete " + str);
      }
      if ((paramRecentBaseData instanceof RecentHotchatItem))
      {
        int i = ((RecentHotchatItem)paramRecentBaseData).a();
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
    int i = paramRecentBaseData.getRecentUserType();
    if (i == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[onMenuItemClick]");
      }
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
        a(i, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.getRecentUserType() != 1) || (!Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]), paramString1)))
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
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString1, 1);
      ((TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(paramString1, 24, l, l, paramString2.wording, 0, null);
    } while (!QLog.isColorLevel());
    QLog.d("HotchatActivity", 2, paramString2.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[onChange] end of drag");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1);
  }
  
  public void b()
  {
    ThreadManager.post(new HotChatCenterFragment.6(this), 8, null, true);
  }
  
  public void b(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString1);
      if (localObject == null) {
        break label64;
      }
      HotChatHelper.a((HotChatInfo)localObject, new HotChatCenterFragment.8(this, (HotChatInfo)localObject, paramString1, paramRecentBaseData, paramString2));
    }
    label64:
    do
    {
      return;
      ((HotChatCenterFragment.HotCenterAdapter)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter).b(paramRecentBaseData, paramString2);
      QLog.e("HotchatActivity", 1, "[exitHotChat] uin null");
    } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d("HotchatActivity", 2, "remove");
    }
    ((HotChatCenterManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramString1);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
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
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER));
      if (isAdded())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
        }
        this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(getActivity().getMainLooper(), this);
        ((IApolloPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloPushManager.class, "all")).setOnPushObserver(this);
      }
      setTitle(HardCodeUtil.a(2131705561));
      d();
      b();
      e();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131559346;
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
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
        b();
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
          ((FragmentActivity)localObject).overridePendingTransition(2130772016, 2130772017);
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
  
  public boolean onBackEvent()
  {
    StatisticTroopAssist.e(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return super.onBackEvent();
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
      IApolloPushManager localIApolloPushManager;
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
          ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
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
        localIApolloPushManager = (IApolloPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloPushManager.class, "all");
      } while (localIApolloPushManager == null);
      localIApolloPushManager.setOnPushObserver(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    g();
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (isAdded())) {
        getActivity().runOnUiThread(new HotChatCenterFragment.10(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment
 * JD-Core Version:    0.7.0.1
 */