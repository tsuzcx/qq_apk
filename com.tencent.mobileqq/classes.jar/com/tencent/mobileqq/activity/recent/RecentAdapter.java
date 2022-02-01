package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacadeUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.MultiAIOStarter;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.IRecentImgv;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RecentAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener, DecodeTaskCompletionListener, SwipListView.SwipListListener
{
  public int a;
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RecentAdapter.9(this);
  protected RecentTabHaloPresenter a;
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  private RecentAdapter.ShowUpStateListener jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter$ShowUpStateListener = null;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected DragFrameLayout a;
  protected QQAppInterface a;
  protected BubblePopupWindow a;
  protected XListView a;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new RecentAdapter.1(this, 20);
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  protected final List<Object> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  protected List<Object> b;
  private int c;
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramOnRecentUserOpsListener, paramInt, false);
  }
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory = new RecentItemBuilderFactory(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter = new RecentTabHaloPresenter(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter.a(new RecentAdapter.2(this));
    if (paramInt == 0) {
      this.jdField_b_of_type_Int = 0;
    } else if (paramInt == 1) {
      this.jdField_b_of_type_Int = 5;
    } else if (paramInt == 9) {
      this.jdField_b_of_type_Int = 11;
    } else if (paramInt == 11) {
      this.jdField_b_of_type_Int = 17;
    } else if (paramInt == 12) {
      this.jdField_b_of_type_Int = 19;
    } else if (paramInt == 13) {
      this.jdField_b_of_type_Int = 21;
    } else if (paramInt == 15) {
      this.jdField_b_of_type_Int = 23;
    }
    this.c = paramInt;
  }
  
  private void a(int paramInt, RecentItemServiceAccountFolderData paramRecentItemServiceAccountFolderData)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof RecentItemServiceAccountFolderData))
    {
      a(paramInt, (RecentItemServiceAccountFolderData)paramObject);
      return;
    }
    Object localObject1;
    if ((paramObject instanceof RecentItemEcShopAssitant))
    {
      paramObject = (RecentItemEcShopAssitant)paramObject;
      paramObject.clearUnReadNum();
      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1008);
      if (paramObject != null)
      {
        localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (localObject1 != null) {
          ((EcShopAssistantManager)localObject1).a(paramObject.time);
        }
      }
    }
    else
    {
      Object localObject2;
      if ((paramObject instanceof RecentUserBaseData))
      {
        localObject1 = (RecentUserBaseData)paramObject;
        localObject2 = ((RecentUserBaseData)localObject1).a();
        if (((RecentUser)localObject2).getType() == 1008)
        {
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(((RecentUser)localObject2).uin);
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(((RecentUserBaseData)localObject1).mUnreadNum);
          ReportController.b(localQQAppInterface, "dc00899", "Pb_account_lifeservice", (String)localObject3, "0X80064CA", "0X80064CA", 0, 0, localStringBuilder.toString(), "", "", "");
        }
        else if (((RecentUser)localObject2).getType() == 6004)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EA", "0X80090EA", 0, 0, "", "", "", "");
        }
        ((RecentUserBaseData)localObject1).clearUnReadNum();
        NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(((RecentUserBaseData)localObject1).getRecentUserUin());
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2, true, false);
        if (this.c == 0) {
          RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2);
        }
        if ((paramObject instanceof SendBlessRecentItemData)) {
          ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).b(true);
        }
        a((RecentUser)localObject2);
        return;
      }
      if ((paramObject instanceof RecentTroopAssistantItem))
      {
        paramObject = (RecentTroopAssistantItem)paramObject;
        paramObject.clearUnReadNum();
        RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1);
        if (paramObject != null) {
          TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.time);
        }
      }
      else if ((paramObject instanceof RecentItemEcShop))
      {
        paramObject = (RecentItemEcShop)paramObject;
        localObject1 = paramObject.getRecentUserUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramObject.mUnreadNum);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064D3", "0X80064D3", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        paramObject.clearUnReadNum();
        RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1008);
        if (paramObject != null)
        {
          localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
          if (localObject1 != null) {
            ((EcShopAssistantManager)localObject1).a(paramObject.time);
          }
        }
      }
      else
      {
        if ((paramObject instanceof RecentMsgBoxItem))
        {
          a((RecentMsgBoxItem)paramObject);
          return;
        }
        if ((paramObject instanceof RecentSayHelloListItem))
        {
          paramObject = (RecentSayHelloListItem)paramObject;
          paramObject.clearUnReadNum();
          RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
          return;
        }
        if ((paramObject instanceof RecentItemConfessMsg))
        {
          ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramObject, false);
          return;
        }
        if ((paramObject instanceof RecentMatchChatListItem))
        {
          paramObject = (RecentMatchChatListItem)paramObject;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        }
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        Object localObject;
        switch (paramInt)
        {
        default: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString, "", "");
          return;
        case 9505: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
          return;
        case 9002: 
          LpReportInfo_dc00518.report(100, 3, 0);
          if (QLog.isColorLevel()) {
            QLog.d("RecentAdapter", 2, "do report: QQnotice.list.delete");
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.delete", 0, 0, "", "", "", "");
          return;
        case 7220: 
          ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportKanDianDelete();
          RecentPubAccHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramRecentBaseData.getTitleName());
          return;
        case 7210: 
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadNum);
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.getRecentUserUin());
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          return;
        case 7200: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString, "");
          return;
        case 7120: 
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadNum);
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.getRecentUserUin());
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          return;
        case 7000: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString, "");
          return;
        case 6004: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
          return;
        case 6000: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString, "");
          return;
        case 5000: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString, "");
          return;
        case 4000: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString, "");
          return;
        case 3000: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString, "");
          return;
        case 1022: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString, "");
          return;
        case 1010: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
          return;
        case 1008: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString, "");
          if ((paramRecentBaseData instanceof RecentItemEcShop)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.getRecentUserUin(), "", paramRecentBaseData.mTitleName, "");
          }
          paramString = paramRecentBaseData.getRecentUserUin();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramRecentBaseData.mUnreadNum);
          ReportController.b((AppRuntime)localObject, "dc00899", "Pb_account_lifeservice", paramString, "0X80064C9", "0X80064C9", 0, 0, localStringBuilder.toString(), "", "", "");
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramRecentBaseData.getRecentUserUin());
          ReportController.b((AppRuntime)localObject, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, localStringBuilder.toString(), "", "", "");
          RecentPubAccHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramRecentBaseData.getTitleName());
          if (AppConstants.WEISHI_UIN.equals(paramString)) {
            ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportWeiShiDelete();
          }
          ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportDelete(paramString);
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
        if ((paramRecentBaseData instanceof RecentMsgBoxItem))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", ((RecentMsgBoxItem)paramRecentBaseData).a(), "msg_box", "delete_msg", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString, "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString, "");
  }
  
  private void a(RecentMsgBoxItem paramRecentMsgBoxItem)
  {
    paramRecentMsgBoxItem.clearUnReadNum();
    if (UinTypeUtil.c(paramRecentMsgBoxItem.getRecentUserUin()))
    {
      ThreadManager.post(new RecentAdapter.7(this, paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType()), 8, null, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
      return;
    }
    RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType());
    if (MsgProxyUtils.a(paramRecentMsgBoxItem.getRecentUserUin()))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", String.valueOf(paramRecentMsgBoxItem.mFromFlag), "");
      return;
    }
    if (MsgProxyUtils.b(paramRecentMsgBoxItem.getRecentUserUin())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
    }
  }
  
  private void a(RecentUser paramRecentUser)
  {
    if ((paramRecentUser.getType() == 0) && (Utils.b(paramRecentUser.uin)))
    {
      paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i = 0;
      paramRecentUser = paramRecentUser.getSharedPreferences(str, 0);
      if (!paramRecentUser.getBoolean("babyQ_toast_flag", false))
      {
        int j = paramRecentUser.getInt("babyQ_drag_count", 0) + 1;
        if (j >= 3)
        {
          DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "babyQ提醒", "是否需要关闭babyQ的推送开关\n", HardCodeUtil.a(2131713080), HardCodeUtil.a(2131713079), new RecentAdapter.5(this), new RecentAdapter.6(this)).show();
          paramRecentUser.edit().putBoolean("babyQ_toast_flag", true);
        }
        else
        {
          i = j;
        }
        paramRecentUser.edit().putInt("babyQ_drag_count", i).commit();
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    if (this.c == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      if (!TextUtils.isEmpty(paramStringBuilder1)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", String.valueOf(paramStringBuilder3), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramStringBuilder1), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(paramStringBuilder2));
      }
    }
  }
  
  private boolean a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
      return true;
    }
    Object localObject1;
    Object localObject2;
    if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localObject1 = paramView.getTag(-1);
      paramView = paramView.getTag(-2);
      if (((localObject1 instanceof Integer)) && ((paramView instanceof Integer)))
      {
        int i = ((Integer)localObject1).intValue();
        int j = ((Integer)paramView).intValue();
        localObject1 = null;
        try
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
        }
        catch (Exception localException)
        {
          paramView = localObject1;
          if (QLog.isDevelopLevel())
          {
            QLog.i("Q.recent", 4, localException.toString());
            paramView = localObject1;
          }
        }
        localObject1 = getItem(i);
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onClick|obj = ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(paramView);
          QLog.i("Q.recent", 4, ((StringBuilder)localObject2).toString());
        }
        if ((paramView != null) && ((localObject1 instanceof RecentBaseData))) {
          a((RecentBaseData)localObject1, paramView, "2");
        }
        if (AppSetting.d) {
          this.jdField_a_of_type_Int = -1;
        }
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
      }
      return true;
    }
    if (Utils.a("tag_recent_item_icon", paramView.getTag()))
    {
      localObject1 = paramView.getTag(-22);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
      if ((localObject2 != null) && (localObject1 != null)) {
        ((OnRecentUserOpsListener)localObject2).onClick(paramView, localObject1);
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    return RecentUtil.a(paramRecentBaseData);
  }
  
  private void b(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    int i = paramRecentBaseData.getRecentUserType();
    if (i == 7220)
    {
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).obtainMergeKanDianFolderStatus();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5(), false);
      ((IKanDianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).removeKanDianPushFromSP();
      ((IKanDianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).removeSubscribePushFromSP();
    }
    if (i == 8112)
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        paramRecentBaseData = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a(paramRecentBaseData, paramRecentBaseData.getResources().getString(2131692183), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(paramString1);
      if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
      {
        paramString1 = (RecentItemMayKnowFriendVerticalListData)paramRecentBaseData;
        if ((paramString1.mUser.extraInfo instanceof MayKnowRecommend))
        {
          paramString1 = (MayKnowRecommend)paramString1.mUser.extraInfo;
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.uin, "frd_list_dlt", 25, 0, paramString1.recommendReason, 0, paramString1.algBuffer, 2);
        }
      }
    }
    if (i == 8113)
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        paramRecentBaseData = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a(paramRecentBaseData, paramRecentBaseData.getResources().getString(2131692183), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).d(paramString1);
    }
    if ((i == 1008) && ("2747277822".equals(paramRecentBaseData.getRecentUserUin()))) {
      h();
    }
    if ((i == 1044) || (i == 1045))
    {
      paramString1 = new HashMap();
      paramString1.put("to_uid", paramRecentBaseData.getRecentUserUin());
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#delete_friend", true, -1L, -1L, paramString1, true, true);
    }
    a(paramRecentBaseData, paramString2);
    a(paramRecentBaseData, paramString2, i);
  }
  
  private void c(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData.getRecentUserType() == 1)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramRecentBaseData.getRecentUserUin());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, paramRecentBaseData.getRecentUserUin(), String.valueOf(i - 1), "", "");
    }
    if ("9970".equals(paramRecentBaseData.getRecentUserUin())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
    }
  }
  
  private void d() {}
  
  private void e()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    boolean bool2;
    Object localObject1;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      RecentBaseData localRecentBaseData = a(localView);
      if (localRecentBaseData == null)
      {
        bool2 = bool1;
      }
      else
      {
        int k = localRecentBaseData.getRecentUserType();
        k = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, localRecentBaseData.getRecentUserUin()).first).intValue();
        bool2 = bool1;
        if (k != -2147483648) {
          if ((localRecentBaseData instanceof RecentSayHelloBoxItem))
          {
            localObject1 = (RecentSayHelloBoxItem)localRecentBaseData;
            Object localObject2 = ((RecentSayHelloBoxItem)localObject1).mUnreadMRList;
            localObject1 = ((RecentSayHelloBoxItem)localObject1).lock;
            if (localObject2 != null) {}
            try
            {
              if (((List)localObject2).size() > 0)
              {
                localObject2 = new LinkedList((Collection)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
                  Object localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append(k);
                  ((StringBuilder)localObject5).append(":");
                  ((StringBuilder)localObject5).append(localMessageRecord.senderuin);
                  localObject5 = ((StringBuilder)localObject5).toString();
                  localObject5 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject5);
                  if (localObject5 != null) {
                    a(localView, localRecentBaseData, localMessageRecord, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject5));
                  }
                }
              }
              bool2 = bool1;
            }
            finally {}
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(":");
            ((StringBuilder)localObject1).append(localRecentBaseData.getRecentUserUin());
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject1);
            bool2 = bool1;
            if (localObject1 != null)
            {
              if (k == 103)
              {
                long l = System.currentTimeMillis();
                Object localObject4 = BaseApplication.getContext().getResources().getDrawable(2130840412);
                if ((localObject4 instanceof SkinnableBitmapDrawable)) {
                  ((SkinnableBitmapDrawable)localObject4).setGravity(81);
                }
                if ((localObject4 instanceof BitmapDrawable)) {
                  ((BitmapDrawable)localObject4).setGravity(81);
                }
                ((Drawable)localObject4).setBounds(0, 0, ((Drawable)localObject4).getIntrinsicWidth(), ((Drawable)localObject4).getIntrinsicHeight());
                localObject4 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject4 });
                localObject1 = localObject4;
                if (QLog.isDevelopLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("onDecodeTaskCompleted, subaccount cost = ");
                  ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
                  QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
                  localObject1 = localObject4;
                }
              }
              else
              {
                localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1);
              }
              a(localView, localRecentBaseData, (Drawable)localObject1);
              bool2 = true;
            }
          }
        }
      }
      i += 1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodecomplete|faceCache size = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilHashtable.size());
      ((StringBuilder)localObject1).append(", isNeedUpdateAvatar=");
      ((StringBuilder)localObject1).append(bool1);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void f()
  {
    MessageHandler localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
    if (localMessageHandler != null) {
      localMessageHandler.d(false);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2 = null;
    Object localObject3 = localObject2;
    Object localObject1 = localObject3;
    while (localIterator.hasNext())
    {
      Object localObject7 = localIterator.next();
      if (((localObject7 instanceof RecentBaseData)) && ((localObject7 instanceof RecentUserBaseData)))
      {
        Object localObject4 = (RecentUserBaseData)localObject7;
        if (((RecentUserBaseData)localObject4).mUnreadNum > 0)
        {
          RecentUser localRecentUser = ((RecentUserBaseData)localObject4).a();
          ((RecentUserBaseData)localObject4).clearUnReadNum();
          NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(((RecentUserBaseData)localObject4).getRecentUserUin());
          if (TripleGraySwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK")) {
            ConversationFacadeUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type);
          }
          localObject4 = localObject2;
          Object localObject6 = localObject3;
          Object localObject5 = localObject1;
          if (localRecentUser.getType() == 1008)
          {
            localObject4 = localObject2;
            if (localObject2 == null)
            {
              localObject4 = new StringBuilder();
              localObject3 = new StringBuilder();
              localObject1 = new StringBuilder();
            }
            a(localRecentUser, (StringBuilder)localObject4, (StringBuilder)localObject3, (StringBuilder)localObject1);
            localObject5 = localObject1;
            localObject6 = localObject3;
          }
          boolean bool4 = localObject7 instanceof RecentItemTroopMsgData;
          boolean bool2 = true;
          boolean bool3 = true;
          boolean bool1 = true;
          if (bool4)
          {
            int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(localRecentUser.uin);
            if ((i != 2) && (i != 4))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (localMessageHandler != null) {
                bool1 = false;
              }
              RecentUtil.a((QQAppInterface)localObject1, localRecentUser, bool1, false);
              localObject2 = localObject4;
              localObject3 = localObject6;
              localObject1 = localObject5;
            }
            else
            {
              RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, true, false);
              localObject2 = localObject4;
              localObject3 = localObject6;
              localObject1 = localObject5;
            }
          }
          else if ((localObject7 instanceof RecentItemServiceAccountFolderData))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByTabRed");
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localMessageHandler == null) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            RecentUtil.a((QQAppInterface)localObject1, localRecentUser, bool1, false);
            ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
            if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete()) {
              ServiceAccountFolderManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onReportNumRedPoint(104000, "104000.104001");
            localObject2 = localObject4;
            localObject3 = localObject6;
            localObject1 = localObject5;
          }
          else if ((localObject7 instanceof SendBlessRecentItemData))
          {
            ThreadManager.post(new RecentAdapter.4(this), 5, null, true);
            localObject2 = localObject4;
            localObject3 = localObject6;
            localObject1 = localObject5;
          }
          else
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localMessageHandler == null) {
              bool1 = bool3;
            } else {
              bool1 = false;
            }
            RecentUtil.a((QQAppInterface)localObject1, localRecentUser, bool1, false);
            localObject2 = localObject4;
            localObject3 = localObject6;
            localObject1 = localObject5;
          }
        }
      }
    }
    a(localObject2, (StringBuilder)localObject3, (StringBuilder)localObject1);
  }
  
  private void g()
  {
    Object localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if ((localObject1 != null) && (((EcShopAssistantManager)localObject1).e))
    {
      ((EcShopAssistantManager)localObject1).e = false;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ecshop_sp");
      localStringBuilder.append((String)localObject1);
      ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("folder_reddot", false).commit();
    }
  }
  
  private void h()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject = (IGameMsgManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (localObject != null)
        {
          ((IGameMsgManagerService)localObject).setUnshowedUnreadCnt(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (localObject != null)
          {
            ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1009));
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      CaughtExceptionReport.a(localException);
    }
  }
  
  public RecentBaseData a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (MultiAIOHelper.a(((RecentBaseData)localObject).getRecentUserType())) {
            return localObject;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public RecentFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131380210);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.a() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setExtraFlag:");
      localStringBuilder.append(paramInt);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if (paramView != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        int j = paramRecentBaseData.getRecentUserType();
        int i = j;
        if ((paramRecentBaseData instanceof RecentCallItem))
        {
          i = j;
          if (((RecentCallItem)paramRecentBaseData).a()) {
            i = 3002;
          }
        }
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(i, paramRecentBaseData.getRecentUserUin());
      }
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
      if (paramDrawable != null) {
        try
        {
          paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
          return;
        }
        catch (Throwable paramView)
        {
          if (!RecentParcelUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
            return;
          }
          throw new RuntimeException(paramView);
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if (paramView != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateSayHelloBoxItem|uin:");
        ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
        QLog.d("Q.recent", 4, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramDrawable;
      if (paramDrawable == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
      if ((paramDrawable != null) && ((paramDrawable instanceof SayHelloBoxItemBuilder))) {
        ((SayHelloBoxItemBuilder)paramDrawable).a(paramView, paramRecentBaseData, paramMessageRecord, (Drawable)localObject);
      }
    }
  }
  
  public void a(RecentAdapter.ShowUpStateListener paramShowUpStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter$ShowUpStateListener = paramShowUpStateListener;
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      int j = ((XListView)localObject).getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        RecentBaseData localRecentBaseData = a((View)localObject);
        if ((localRecentBaseData != null) && (localRecentBaseData.equals(paramRecentBaseData)))
        {
          a((View)localObject, localRecentBaseData);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    OnRecentUserOpsListener localOnRecentUserOpsListener = this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
    if (localOnRecentUserOpsListener != null) {
      localOnRecentUserOpsListener.onRecentBaseDataDelete(paramRecentBaseData, paramString);
    }
    paramString = this.jdField_a_of_type_JavaUtilList;
    if (paramString != null)
    {
      paramString.remove(paramRecentBaseData);
      d();
      notifyDataSetChanged();
    }
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (Utils.a(paramString1, localResources.getString(RecentItemBaseBuilder.a[0])))
    {
      paramRecentBaseData.getRecentUserType();
      b(paramRecentBaseData, paramString1, paramString2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A360", "0X800A360", 0, 0, "1", "", paramString2, "");
      return;
    }
    OnRecentUserOpsListener localOnRecentUserOpsListener = this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
    if (localOnRecentUserOpsListener != null)
    {
      localOnRecentUserOpsListener.onMenuItemClick(paramString1, paramRecentBaseData, paramString2);
      ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportSetTopOrCancelSetTop(paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin(), paramString1, localResources);
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_b_of_type_JavaUtilList = null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter;
    if (localObject != null) {
      ((RecentTabHaloPresenter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory;
    if (localObject != null) {
      ((RecentItemBuilderFactory)localObject).a(paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter = new RecentTabHaloPresenter(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter.a(new RecentAdapter.11(this));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAccountChanged: invoked. Message: app: ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(" recreate mRecentTabHaloPresenter: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter);
      QLog.i("RecentTabHaloPresenter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, 1008);
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = ((MessageRecord)localObject3).getExtInfoFromExtStr("gdt_msgClick");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "0";
        localObject3 = ((MessageRecord)localObject3).getExtInfoFromExtStr("pa_msgId");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(",");
        paramStringBuilder1.append(localStringBuilder.toString());
      }
    }
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      paramStringBuilder1 = (StringBuilder)localObject1;
      if (!((JSONObject)localObject2).has("ad_id")) {
        break label152;
      }
      paramStringBuilder1 = ((JSONObject)localObject2).getString("ad_id");
    }
    catch (Exception paramStringBuilder1)
    {
      label130:
      label152:
      break label130;
    }
    paramStringBuilder1 = (StringBuilder)localObject1;
    if (QLog.isColorLevel())
    {
      QLog.i("Q.recent", 2, " parse ad_id error");
      paramStringBuilder1 = (StringBuilder)localObject1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramStringBuilder1);
    ((StringBuilder)localObject1).append(",");
    paramStringBuilder2.append(((StringBuilder)localObject1).toString());
    paramStringBuilder1 = new StringBuilder();
    paramStringBuilder1.append(paramRecentUser.uin);
    paramStringBuilder1.append(",");
    paramStringBuilder3.append(paramStringBuilder1.toString());
  }
  
  protected void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
    ReportController.b(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, localStringBuilder.toString(), "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        RecentBaseData localRecentBaseData = a(localView);
        if ((localRecentBaseData != null) && (localRecentBaseData.getRecentUserType() == paramInt) && (Utils.a(localRecentBaseData.getRecentUserUin(), paramString)))
        {
          a(localView, localRecentBaseData);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int i = 1;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        RecentBaseData localRecentBaseData = a(localView);
        if ((localRecentBaseData != null) && (Utils.a(paramString, localRecentBaseData.getRecentUserUin())))
        {
          int k = localRecentBaseData.getRecentUserType();
          if ((paramBoolean) && (k == 1))
          {
            a(localView, localRecentBaseData);
            return;
          }
          if ((!paramBoolean) && (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(k))))
          {
            a(localView, localRecentBaseData);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    hideMenuPop();
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setDataList size = ");
      ((StringBuilder)localObject1).append(i);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setDataList size = ");
      ((StringBuilder)localObject1).append(i);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString(), new Exception("setDataListEmpty"));
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentWidgetXListView;
    boolean bool = localObject3 instanceof SwipListView;
    Object localObject1 = null;
    Object localObject2 = null;
    if (bool)
    {
      localObject3 = (SwipListView)localObject3;
      i = this.jdField_a_of_type_Int;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          localObject1 = this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setDataList findsel, [");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("Q.recent", 4, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_Int = -1;
      localObject2 = localObject3;
    }
    else
    {
      localObject2 = null;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {}
    try
    {
      paramList = paramList.iterator();
      i = -1;
      while (paramList.hasNext())
      {
        localObject3 = (RecentBaseData)paramList.next();
        if (localObject3 != null)
        {
          i += 1;
          if ((localObject3 instanceof RecentItemChatMsgData)) {
            ((RecentBaseData)localObject3).mPosition = i;
          }
          if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject3)) {
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("Q.recent", 2, "setDataList, [item is null]");
        }
      }
    }
    catch (Exception paramList)
    {
      label399:
      int j;
      break label399;
    }
    if (localObject2 != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((SwipListView)localObject2).setDragEnable(bool);
    }
    if ((localObject1 instanceof RecentBaseData))
    {
      paramList = (RecentBaseData)localObject1;
      i = Math.max(((SwipListView)localObject2).getFirstVisiblePosition(), 0);
      j = Math.min(((SwipListView)localObject2).getLastVisiblePosition() + 1, this.jdField_a_of_type_JavaUtilList.size());
      while (i < j)
      {
        if (paramList.equals(this.jdField_a_of_type_JavaUtilList.get(i)))
        {
          this.jdField_a_of_type_Int = i;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          paramList = new StringBuilder();
          paramList.append("setDataList getsel, [");
          paramList.append(i);
          paramList.append(",");
          paramList.append(this.jdField_a_of_type_JavaUtilList.get(i));
          paramList.append("]");
          QLog.i("Q.recent", 4, paramList.toString());
          break;
        }
        i += 1;
      }
    }
    if ((localObject2 != null) && (this.jdField_a_of_type_Int == -1)) {
      ((SwipListView)localObject2).hideCurShowingRightView();
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.resume();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecentBaseData localRecentBaseData = a(this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i));
      if ((localRecentBaseData != null) && (!(localRecentBaseData instanceof RecentItemImaxADData))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(localRecentBaseData.getRecentUserType(), localRecentBaseData.getRecentUserUin(), false);
      }
      i += 1;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView);
  }
  
  public List<Object> b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return new ArrayList(localList);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    RecentTabHaloPresenter localRecentTabHaloPresenter = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter;
    if (localRecentTabHaloPresenter != null) {
      localRecentTabHaloPresenter.a();
    }
  }
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 8) && (paramRecentBaseData.mExtraType == 25))
    {
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localIPhoneContactService != null)
      {
        localObject1 = localObject2;
        if (paramRecentBaseData.mPhoneNumber != null) {
          localObject1 = localIPhoneContactService.queryContactByCodeNumber(paramRecentBaseData.mPhoneNumber);
        }
      }
      if (localObject1 != null)
      {
        paramRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
        return;
      }
      localObject1 = ((QCallCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(paramRecentBaseData.getRecentUserUin());
      if (localObject1 != null) {
        paramRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    RecentItemBuilderFactory localRecentItemBuilderFactory = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory;
    if (localRecentItemBuilderFactory != null) {
      localRecentItemBuilderFactory.b(paramQQAppInterface);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public void c()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.b();
    }
  }
  
  protected boolean c()
  {
    int i = this.jdField_b_of_type_Int;
    return (i == 3) || (i == 8);
  }
  
  public int getCount()
  {
    if ((!c()) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      Object localObject;
      if ((!c()) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
      {
        if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
          break label81;
        }
        localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
      else
      {
        localObject = Integer.valueOf(this.jdField_b_of_type_Int);
      }
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    label81:
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject2 = getItem(paramInt);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject2);
      if ((localObject2 instanceof RecentBaseData))
      {
        localObject2 = (RecentBaseData)localObject2;
        b((RecentBaseData)localObject2);
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
        paramView = (View)localObject1;
      }
      else if ((localObject2 instanceof Integer))
      {
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
        paramView = (View)localObject1;
      }
      else if ((localObject2 instanceof String))
      {
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
        paramView = (View)localObject1;
      }
      else
      {
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
        paramView = (View)localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      RecentParcelUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, localThrowable);
      if (RecentParcelUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label206;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
    label206:
    throw new RuntimeException(localThrowable);
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.b();
  }
  
  public void hideMenuPop()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localBubblePopupWindow != null)
    {
      localBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    FrameHelperActivity.b(paramBoolean ^ true);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    RecentAdapter.ShowUpStateListener localShowUpStateListener = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter$ShowUpStateListener;
    if (localShowUpStateListener == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof RecentUserBaseData)))
    {
      localObject = ((RecentUserBaseData)this.jdField_a_of_type_JavaUtilList.get(0)).a();
      if ((localObject != null) && (((RecentUser)localObject).showUpTime > 0L))
      {
        localShowUpStateListener.m();
        return;
      }
      localShowUpStateListener.n();
      return;
    }
    localShowUpStateListener.n();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      int i;
      if (this.c == 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject;
      RecentUser localRecentUser;
      if (paramInt == 2)
      {
        if (paramDragFrameLayout == null) {
          paramDragFrameLayout = "null";
        } else {
          paramDragFrameLayout = paramDragFrameLayout.getClass().getSimpleName();
        }
        QLog.d("RecentAdapter", 2, new Object[] { "onChange type=", Integer.valueOf(paramInt), " from=", paramDragFrameLayout, " Current Thread=", Thread.currentThread().getName() });
        if (i != 0)
        {
          paramDragFrameLayout = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramDragFrameLayout.hasNext())
          {
            localObject = paramDragFrameLayout.next();
            if (((localObject instanceof RecentBaseData)) && ((localObject instanceof RecentUserBaseData)))
            {
              localObject = (RecentUserBaseData)localObject;
              if (((RecentUserBaseData)localObject).mUnreadNum > 0)
              {
                localRecentUser = ((RecentUserBaseData)localObject).a();
                RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject, localRecentUser, true);
              }
            }
          }
        }
        g();
        f();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow)
        {
          paramDragFrameLayout = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
          if (paramDragFrameLayout != null) {
            paramDragFrameLayout.a(MessageCache.a());
          }
        }
        ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).recordOneKeyClean();
        return;
      }
      paramDragFrameLayout = paramDragFrameLayout.a();
      if (paramDragFrameLayout != null)
      {
        paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
        if (paramDragFrameLayout != null)
        {
          paramInt = paramDragFrameLayout.intValue();
          paramDragFrameLayout = getItem(paramInt);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onChange:");
            ((StringBuilder)localObject).append(paramDragFrameLayout);
            QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
          }
          if ((paramDragFrameLayout instanceof RecentBaseData))
          {
            localObject = (RecentBaseData)paramDragFrameLayout;
            if ((i != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
            {
              localRecentUser = ((RecentUserBaseData)paramDragFrameLayout).a();
              RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject, localRecentUser, false);
              if (TripleGraySwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK")) {
                ConversationFacadeUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type);
              }
            }
            a(paramInt, paramDragFrameLayout);
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (!a(paramView))
    {
      Object localObject1 = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STORY_HALO_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener != null)
      {
        Object localObject2 = paramView.getTag(-22);
        if (((StoryHaloManager)localObject1).b(localObject2)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.onClick(paramView, localObject2);
        }
        localObject1 = paramView.getTag(-1);
        if (!(localObject1 instanceof Integer))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
          }
        }
        else
        {
          int i = ((Integer)localObject1).intValue();
          localObject1 = getItem(i);
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onClick|obj = ");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.i("Q.recent", 4, ((StringBuilder)localObject2).toString());
          }
          if ((localObject1 instanceof RecentBaseData))
          {
            if (((paramView instanceof IRecentImgv)) && ((localObject1 instanceof RecentItemEcShop)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.onClick(paramView, localObject1);
            }
            else
            {
              localObject2 = (RecentBaseData)localObject1;
              ((RecentBaseData)localObject2).mPosition = i;
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.onRecentBaseDataClick(paramView, (RecentBaseData)localObject2, ((RecentBaseData)localObject2).mTitleName, true);
            }
            if ((localObject1 instanceof RecentItemTroopMsgData))
            {
              localObject2 = (RecentItemTroopMsgData)localObject1;
              if ((localObject2 != null) && (((RecentItemTroopMsgData)localObject2).mIsGroupVideoNotify)) {
                a(((RecentItemTroopMsgData)localObject2).getRecentUserUin());
              }
            }
            else if ((localObject1 instanceof RecentTroopAssistantItem))
            {
              localObject2 = (RecentTroopAssistantItem)localObject1;
              if ((localObject2 != null) && (((RecentTroopAssistantItem)localObject2).mIsGroupVideoNotify)) {
                a(((RecentTroopAssistantItem)localObject2).getRecentUserUin());
              }
            }
            OfficialAccountReporter.a.a(localObject1);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.onClick(paramView, localObject1);
          }
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (TextUtils.isEmpty(???)) {
        return;
      }
      if ((paramBitmap == null) && (paramInt1 > 0)) {
        return;
      }
      boolean bool2 = true;
      if (paramBitmap != null) {
        try
        {
          Hashtable localHashtable = this.jdField_a_of_type_JavaUtilHashtable;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramInt2);
          localStringBuilder2.append(":");
          localStringBuilder2.append(???);
          localHashtable.put(localStringBuilder2.toString(), paramBitmap);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          System.gc();
          localOutOfMemoryError.printStackTrace();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("onDecodeTaskCompleted error:");
          localStringBuilder2.append(localOutOfMemoryError.getMessage());
          QLog.i("RecentAdapter", 1, localStringBuilder2.toString());
        }
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      boolean bool1;
      if ((l2 > 0L) && (l1 - l2 > 300L)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("RecentAdapter.onDecodeTaskCompleted type=");
        localStringBuilder1.append(paramInt2);
        localStringBuilder1.append(", uin=");
        localStringBuilder1.append(???);
        localStringBuilder1.append(", remainingTasks=");
        localStringBuilder1.append(paramInt1);
        localStringBuilder1.append(", isdecodeFaceTimeout=");
        localStringBuilder1.append(bool1);
        localStringBuilder1.append(", avatar == null ? | ");
        if (paramBitmap != null) {
          bool2 = false;
        }
        localStringBuilder1.append(bool2);
        localStringBuilder1.append(",style | ");
        localStringBuilder1.append(this.c);
        QLog.d("RecentAdapter", 2, localStringBuilder1.toString());
      }
      if ((paramInt1 > 0) && (!bool1)) {
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashtable)
      {
        if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
          return;
        }
        if (paramInt1 == 0) {
          this.jdField_a_of_type_Long = 0L;
        } else {
          this.jdField_a_of_type_Long = l1;
        }
        e();
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        return;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 2, "RecentAdpater onLongClick");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory;
    boolean bool2 = false;
    int i;
    if (localObject1 != null) {
      i = ((RecentItemBuilderFactory)localObject1).a();
    } else {
      i = 0;
    }
    if ((i == 0) && (FrameHelperActivity.b())) {
      return false;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    if ((paramView.getContext() instanceof TroopAssistantActivity)) {
      return false;
    }
    localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLongClick|obj = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject2).toString());
    }
    boolean bool1 = localObject1 instanceof RecentBaseData;
    Object localObject2 = null;
    if (bool1) {
      localObject1 = (RecentBaseData)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append("RecentAdpater onLongClick item is null, pos = ");
        paramView.append(j);
        QLog.i("Q.recent", 4, paramView.toString());
      }
      return false;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory;
    if (localObject3 == null) {
      return false;
    }
    localObject3 = ((RecentItemBuilderFactory)localObject3).a(localObject1);
    c((RecentBaseData)localObject1);
    if (localObject3 != null) {
      localObject2 = ((RecentItemBaseBuilder)localObject3).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0) && (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long > 100L))
    {
      localObject3 = new QQCustomMenu();
      i = 0;
      while (i < ((List)localObject2).size())
      {
        ((QQCustomMenu)localObject3).a(j, (String)((List)localObject2).get(i));
        i += 1;
      }
      if ((this.jdField_a_of_type_Boolean) && (MultiAIOStarter.a(this.jdField_a_of_type_AndroidContentContext, ((RecentBaseData)localObject1).getRecentUserUin(), ((RecentBaseData)localObject1).getRecentUserType(), ((RecentBaseData)localObject1).getTitleName(), "conversation_tab_list")))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.recent", 2, "MultiAIOStarter start multiaio successfully!");
          bool1 = bool2;
        }
      }
      else
      {
        try
        {
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject3, this.jdField_a_of_type_AndroidViewView$OnClickListener, new RecentAdapter.3(this, paramView));
          bool1 = true;
        }
        catch (Throwable paramView)
        {
          paramView.printStackTrace();
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.recent", 2, "long click showAsDropDown", paramView);
            bool1 = bool2;
          }
        }
      }
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      return bool1;
    }
    if (QLog.isDevelopLevel())
    {
      paramView = new StringBuilder();
      paramView.append("RecentAdpater onLongClick no menu, builder = ");
      paramView.append(localObject3);
      QLog.i("Q.recent", 4, paramView.toString());
    }
    return false;
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter
 * JD-Core Version:    0.7.0.1
 */