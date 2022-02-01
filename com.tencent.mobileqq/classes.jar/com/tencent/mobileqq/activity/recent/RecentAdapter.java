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
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
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
  protected RecentItemBuilderFactory a;
  protected final List<Object> b;
  protected Context c;
  protected QQAppInterface d;
  protected RecentFaceDecoder e;
  protected XListView f = null;
  protected DragFrameLayout g;
  protected BubblePopupWindow h;
  public int i = -1;
  protected List<Object> j;
  protected RecentTabHaloPresenter k;
  View.OnClickListener l = new RecentAdapter.9(this);
  private int m;
  private int n;
  private OnRecentUserOpsListener o = null;
  private long p = 0L;
  private Hashtable<String, Bitmap> q = new Hashtable();
  private long r;
  private RecentAdapter.ShowUpStateListener s = null;
  private boolean t = false;
  private ArrayList<Integer> u = new RecentAdapter.1(this, 20);
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramOnRecentUserOpsListener, paramInt, false);
  }
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt, boolean paramBoolean)
  {
    this.c = paramContext;
    this.f = paramXListView;
    this.o = paramOnRecentUserOpsListener;
    this.d = paramQQAppInterface;
    this.b = new ArrayList(99);
    this.a = new RecentItemBuilderFactory(paramInt);
    this.a.a(this);
    this.e = new RecentFaceDecoder(paramQQAppInterface, this, paramBoolean);
    this.k = new RecentTabHaloPresenter(paramQQAppInterface);
    this.k.a(new RecentAdapter.2(this));
    if (paramInt == 0) {
      this.m = 0;
    } else if (paramInt == 1) {
      this.m = 5;
    } else if (paramInt == 9) {
      this.m = 11;
    } else if (paramInt == 11) {
      this.m = 17;
    } else if (paramInt == 12) {
      this.m = 19;
    } else if (paramInt == 13) {
      this.m = 21;
    } else if (paramInt == 15) {
      this.m = 23;
    } else if (paramInt == 16) {
      this.m = 24;
    } else if (paramInt == 17) {
      this.m = 0;
    }
    this.n = paramInt;
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
      RecentUtil.b(this.d, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
      this.d.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
      paramObject = this.d.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1008);
      if (paramObject != null)
      {
        localObject1 = (EcShopAssistantManager)this.d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
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
        localObject2 = ((RecentUserBaseData)localObject1).e();
        if (((RecentUser)localObject2).getType() == 1008)
        {
          QQAppInterface localQQAppInterface = this.d;
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
          ReportController.b(this.d, "dc00898", "", "", "0X80090EA", "0X80090EA", 0, 0, "", "", "", "");
        }
        ((RecentUserBaseData)localObject1).clearUnReadNum();
        NotifyIdManager.a(this.d).c(((RecentUserBaseData)localObject1).getRecentUserUin());
        RecentUtil.a(this.d, (RecentUser)localObject2, true, false);
        if (this.n == 0) {
          RecentUtil.a(this.d, (RecentUser)localObject2);
        }
        if ((paramObject instanceof SendBlessRecentItemData)) {
          ((BlessManager)this.d.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).b(true);
        }
        a((RecentUser)localObject2);
        return;
      }
      if ((paramObject instanceof RecentTroopAssistantItem))
      {
        paramObject = (RecentTroopAssistantItem)paramObject;
        paramObject.clearUnReadNum();
        RecentUtil.b(this.d, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        this.d.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        paramObject = this.d.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1);
        if (paramObject != null) {
          TroopAssistantManager.a().a(this.d, paramObject.time);
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
        RecentUtil.b(this.d, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        this.d.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        paramObject = this.d.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1008);
        if (paramObject != null)
        {
          localObject1 = (EcShopAssistantManager)this.d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
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
          RecentUtil.b(this.d, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
          this.d.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
          return;
        }
        if ((paramObject instanceof RecentItemConfessMsg))
        {
          ConfessMsgUtil.a(this.d, (RecentItemConfessMsg)paramObject, false);
          return;
        }
        if ((paramObject instanceof RecentMatchChatListItem))
        {
          paramObject = (RecentMatchChatListItem)paramObject;
          this.d.getMessageFacade().a(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
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
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString, "", "");
          return;
        case 9505: 
          ReportController.b(this.d, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
          return;
        case 9002: 
          LpReportInfo_dc00518.report(100, 3, 0);
          if (QLog.isColorLevel()) {
            QLog.d("RecentAdapter", 2, "do report: QQnotice.list.delete");
          }
          ReportController.b(this.d, "P_CliOper", "QQnotice", "", "", "QQnotice.list.delete", 0, 0, "", "", "", "");
          return;
        case 7220: 
          ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportKanDianDelete();
          RecentPubAccHelper.a(this.d, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramRecentBaseData.getTitleName(), false);
          return;
        case 7210: 
          paramString = this.d;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadNum);
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          paramString = this.d;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.getRecentUserUin());
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          return;
        case 7200: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString, "");
          return;
        case 7120: 
          paramString = this.d;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadNum);
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          paramString = this.d;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.getRecentUserUin());
          ReportController.b(paramString, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
          return;
        case 7000: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString, "");
          return;
        case 6004: 
          ReportController.b(this.d, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
          return;
        case 6000: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString, "");
          return;
        case 5000: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString, "");
          return;
        case 4000: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString, "");
          return;
        case 3000: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString, "");
          return;
        case 1022: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString, "");
          return;
        case 1010: 
          ReportController.b(this.d, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
          return;
        case 1008: 
          ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString, "");
          if ((paramRecentBaseData instanceof RecentItemEcShop)) {
            ReportController.b(this.d, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.getRecentUserUin(), "", paramRecentBaseData.mTitleName, "");
          }
          paramString = paramRecentBaseData.getRecentUserUin();
          localObject = this.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramRecentBaseData.mUnreadNum);
          ReportController.b((AppRuntime)localObject, "dc00899", "Pb_account_lifeservice", paramString, "0X80064C9", "0X80064C9", 0, 0, localStringBuilder.toString(), "", "", "");
          localObject = this.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramRecentBaseData.getRecentUserUin());
          ReportController.b((AppRuntime)localObject, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, localStringBuilder.toString(), "", "", "");
          RecentPubAccHelper.a(this.d, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramRecentBaseData.getTitleName(), RecentPubAccHelper.a());
          if (AppConstants.WEISHI_UIN.equals(paramString)) {
            ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportWeiShiDelete();
          }
          ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportDelete(paramString);
          return;
        }
        ReportController.b(this.d, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
        if ((paramRecentBaseData instanceof RecentMsgBoxItem))
        {
          ReportController.b(this.d, "dc00899", "grp_lbs", ((RecentMsgBoxItem)paramRecentBaseData).bW_(), "msg_box", "delete_msg", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.d, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString, "");
      return;
    }
    ReportController.b(this.d, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString, "");
  }
  
  private void a(RecentMsgBoxItem paramRecentMsgBoxItem)
  {
    paramRecentMsgBoxItem.clearUnReadNum();
    if (UinTypeUtil.c(paramRecentMsgBoxItem.getRecentUserUin()))
    {
      ThreadManager.post(new RecentAdapter.7(this, paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType()), 8, null, false);
      ReportController.b(this.d, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
      ReportController.b(this.d, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
      return;
    }
    RecentUtil.b(this.d, paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType());
    this.d.getMessageFacade().a(paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType());
    if (MsgProxyUtils.b(paramRecentMsgBoxItem.getRecentUserUin()))
    {
      ReportController.b(this.d, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", String.valueOf(paramRecentMsgBoxItem.mFromFlag), "");
      return;
    }
    if (MsgProxyUtils.c(paramRecentMsgBoxItem.getRecentUserUin())) {
      ReportController.b(this.d, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
    }
  }
  
  private void a(RecentUser paramRecentUser)
  {
    if ((paramRecentUser.getType() == 0) && (Utils.c(paramRecentUser.uin)))
    {
      paramRecentUser = this.d.getApp();
      String str = this.d.getCurrentAccountUin();
      int i1 = 0;
      paramRecentUser = paramRecentUser.getSharedPreferences(str, 0);
      if (!paramRecentUser.getBoolean("babyQ_toast_flag", false))
      {
        int i2 = paramRecentUser.getInt("babyQ_drag_count", 0) + 1;
        if (i2 >= 3)
        {
          DialogUtil.a(this.c, 230, "babyQ提醒", "是否需要关闭babyQ的推送开关\n", HardCodeUtil.a(2131898212), HardCodeUtil.a(2131899883), new RecentAdapter.5(this), new RecentAdapter.6(this)).show();
          paramRecentUser.edit().putBoolean("babyQ_toast_flag", true);
        }
        else
        {
          i1 = i2;
        }
        paramRecentUser.edit().putInt("babyQ_drag_count", i1).commit();
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    if (this.n == 0)
    {
      ReportController.b(this.d, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
      ReportController.b(this.d, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      if (!TextUtils.isEmpty(paramStringBuilder1)) {
        ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", String.valueOf(paramStringBuilder3), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramStringBuilder1), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(paramStringBuilder2));
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    return RecentUtil.a(paramRecentBaseData);
  }
  
  private RecentBaseData b(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 2, "RecentAdpater onLongClick");
    }
    Object localObject = this.a;
    if (localObject != null) {
      i1 = ((RecentItemBuilderFactory)localObject).a();
    } else {
      i1 = 0;
    }
    if ((i1 == 0) && (FrameHelperActivity.G())) {
      return null;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return null;
    }
    if ((paramView.getContext() instanceof TroopAssistantActivity)) {
      return null;
    }
    paramView = paramView.getTag(-1);
    if (!(paramView instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return null;
    }
    int i1 = ((Integer)paramView).intValue();
    paramView = getItem(i1);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLongClick|obj = ");
      ((StringBuilder)localObject).append(paramView);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramView instanceof RecentBaseData)) {
      paramView = (RecentBaseData)paramView;
    } else {
      paramView = null;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append("RecentAdpater onLongClick item is null, pos = ");
        paramView.append(i1);
        QLog.i("Q.recent", 4, paramView.toString());
      }
      return null;
    }
    if (this.a == null) {
      return null;
    }
    return paramView;
  }
  
  private void b(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    if (i1 == 7220)
    {
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).obtainMergeKanDianFolderStatus();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5(), false);
      ((IKanDianMergeManager)this.d.getRuntimeService(IKanDianMergeManager.class)).removeKanDianPushFromSP();
      ((IKanDianMergeManager)this.d.getRuntimeService(IKanDianMergeManager.class)).removeSubscribePushFromSP();
    }
    if (i1 == 8112)
    {
      if (!NetworkUtil.isNetworkAvailable(this.c))
      {
        paramRecentBaseData = this.c;
        QQToast.makeText(paramRecentBaseData, paramRecentBaseData.getResources().getString(2131889169), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      ((FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(paramString1);
      if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
      {
        paramString1 = (RecentItemMayKnowFriendVerticalListData)paramRecentBaseData;
        if ((paramString1.mUser.extraInfo instanceof MayKnowRecommend))
        {
          paramString1 = (MayKnowRecommend)paramString1.mUser.extraInfo;
          ContactReportUtils.a(this.d, paramString1.uin, "frd_list_dlt", 25, 0, paramString1.recommendReason, 0, paramString1.algBuffer, 2);
        }
      }
    }
    if (i1 == 8113)
    {
      if (!NetworkUtil.isNetworkAvailable(this.c))
      {
        paramRecentBaseData = this.c;
        QQToast.makeText(paramRecentBaseData, paramRecentBaseData.getResources().getString(2131889169), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      ((MayknowRecommendManager)this.d.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).f(paramString1);
    }
    if ((i1 == 1008) && ("2747277822".equals(paramRecentBaseData.getRecentUserUin()))) {
      p();
    }
    if ((i1 == 1044) || (i1 == 1045))
    {
      paramString1 = new HashMap();
      paramString1.put("to_uid", paramRecentBaseData.getRecentUserUin());
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#delete_friend", true, -1L, -1L, paramString1, true, true);
    }
    a(paramRecentBaseData, paramString2);
    a(paramRecentBaseData, paramString2, i1);
  }
  
  private void c(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData.getRecentUserType() == 1)
    {
      int i1 = this.d.getTroopMask(paramRecentBaseData.getRecentUserUin());
      ReportController.b(this.d, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, paramRecentBaseData.getRecentUserUin(), String.valueOf(i1 - 1), "", "");
    }
    if ("9970".equals(paramRecentBaseData.getRecentUserUin())) {
      ReportController.b(this.d, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
    }
  }
  
  private boolean c(View paramView)
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
        int i1 = ((Integer)localObject1).intValue();
        int i2 = ((Integer)paramView).intValue();
        localObject1 = null;
        try
        {
          paramView = this.c.getResources().getString(i2);
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
        localObject1 = getItem(i1);
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
        if (AppSetting.e) {
          this.i = -1;
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
      localObject2 = this.o;
      if ((localObject2 != null) && (localObject1 != null)) {
        ((OnRecentUserOpsListener)localObject2).onClick(paramView, localObject1);
      }
      return true;
    }
    return false;
  }
  
  private void l() {}
  
  private void m()
  {
    int i2 = this.f.getChildCount();
    int i1 = 0;
    boolean bool2;
    Object localObject1;
    for (boolean bool1 = false; i1 < i2; bool1 = bool2)
    {
      View localView = this.f.getChildAt(i1);
      RecentBaseData localRecentBaseData = a(localView);
      if (localRecentBaseData == null)
      {
        bool2 = bool1;
      }
      else
      {
        int i3 = localRecentBaseData.getRecentUserType();
        i3 = ((Integer)RecentFaceDecoder.a(this.d, i3, localRecentBaseData.getRecentUserUin()).first).intValue();
        bool2 = bool1;
        if (i3 != -2147483648) {
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
                  ((StringBuilder)localObject5).append(i3);
                  ((StringBuilder)localObject5).append(":");
                  ((StringBuilder)localObject5).append(localMessageRecord.senderuin);
                  localObject5 = ((StringBuilder)localObject5).toString();
                  localObject5 = (Bitmap)this.q.get(localObject5);
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
            ((StringBuilder)localObject1).append(i3);
            ((StringBuilder)localObject1).append(":");
            ((StringBuilder)localObject1).append(localRecentBaseData.getRecentUserUin());
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject1 = (Bitmap)this.q.get(localObject1);
            bool2 = bool1;
            if (localObject1 != null)
            {
              if (i3 == 103)
              {
                long l1 = System.currentTimeMillis();
                Object localObject4 = BaseApplication.getContext().getResources().getDrawable(2130841165);
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
                  ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
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
      i1 += 1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodecomplete|faceCache size = ");
      ((StringBuilder)localObject1).append(this.q.size());
      ((StringBuilder)localObject1).append(", isNeedUpdateAvatar=");
      ((StringBuilder)localObject1).append(bool1);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void n()
  {
    MessageHandler localMessageHandler = (MessageHandler)this.d.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
    if (localMessageHandler != null) {
      localMessageHandler.f(false);
    }
    Iterator localIterator = this.b.iterator();
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
          RecentUser localRecentUser = ((RecentUserBaseData)localObject4).e();
          ((RecentUserBaseData)localObject4).clearUnReadNum();
          NotifyIdManager.a(this.d).c(((RecentUserBaseData)localObject4).getRecentUserUin());
          if (TripleGraySwitchUtil.a(this.d.getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK")) {
            ConversationFacadeUtil.a(this.d, localRecentUser.uin, localRecentUser.type);
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
            int i1 = this.d.getTroopMask(localRecentUser.uin);
            if ((i1 != 2) && (i1 != 4))
            {
              localObject1 = this.d;
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
              RecentUtil.a(this.d, localRecentUser, true, false);
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
            localObject1 = this.d;
            if (localMessageHandler == null) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            RecentUtil.a((QQAppInterface)localObject1, localRecentUser, bool1, false);
            ServiceAccountFolderManager.a().b(this.d, NetConnInfoCenter.getServerTime());
            if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete()) {
              ServiceAccountFolderManager.a().f(this.d);
            }
            ((IRedTouchManager)this.d.getRuntimeService(IRedTouchManager.class, "")).onReportNumRedPoint(104000, "104000.104001");
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
            localObject1 = this.d;
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
  
  private void o()
  {
    Object localObject1 = (EcShopAssistantManager)this.d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if ((localObject1 != null) && (((EcShopAssistantManager)localObject1).B))
    {
      ((EcShopAssistantManager)localObject1).B = false;
      Object localObject2 = this.d.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject2 = this.d.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ecshop_sp");
      localStringBuilder.append((String)localObject1);
      ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("folder_reddot", false).commit();
    }
  }
  
  private void p()
  {
    try
    {
      if (this.d != null)
      {
        Object localObject = (IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, "");
        if (localObject != null)
        {
          ((IGameMsgManagerService)localObject).setUnshowedUnreadCnt(0);
          localObject = this.d.getHandler(Conversation.class);
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
  
  public void a(int paramInt)
  {
    this.m = paramInt;
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
        int i2 = paramRecentBaseData.getRecentUserType();
        int i1 = i2;
        if ((paramRecentBaseData instanceof RecentCallItem))
        {
          i1 = i2;
          if (((RecentCallItem)paramRecentBaseData).a()) {
            i1 = 3002;
          }
        }
        localDrawable = this.e.a(i1, paramRecentBaseData.getRecentUserUin());
      }
      paramDrawable = this.a.b(paramRecentBaseData);
      if (paramDrawable != null) {
        try
        {
          paramDrawable.a(paramView, paramRecentBaseData, this.c, localDrawable);
          return;
        }
        catch (Throwable paramView)
        {
          if (!RecentParcelUtil.c(this.d.getApp())) {
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
        localObject = this.e.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.a.b(paramRecentBaseData);
      if ((paramDrawable != null) && ((paramDrawable instanceof SayHelloBoxItemBuilder))) {
        ((SayHelloBoxItemBuilder)paramDrawable).a(paramView, paramRecentBaseData, paramMessageRecord, (Drawable)localObject);
      }
    }
  }
  
  public void a(RecentAdapter.ShowUpStateListener paramShowUpStateListener)
  {
    this.s = paramShowUpStateListener;
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      int i2 = ((XListView)localObject).getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.f.getChildAt(i1);
        RecentBaseData localRecentBaseData = a((View)localObject);
        if ((localRecentBaseData != null) && (localRecentBaseData.equals(paramRecentBaseData)))
        {
          a((View)localObject, localRecentBaseData);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    OnRecentUserOpsListener localOnRecentUserOpsListener = this.o;
    if (localOnRecentUserOpsListener != null) {
      localOnRecentUserOpsListener.onRecentBaseDataDelete(paramRecentBaseData, paramString);
    }
    paramString = this.b;
    if (paramString != null)
    {
      paramString.remove(paramRecentBaseData);
      l();
      notifyDataSetChanged();
    }
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    Resources localResources = this.c.getResources();
    if ((!Utils.a(paramString1, localResources.getString(RecentItemBaseBuilder.c[0]))) && (!Utils.a(paramString1, localResources.getString(RecentItemBaseBuilder.c[10]))))
    {
      OnRecentUserOpsListener localOnRecentUserOpsListener = this.o;
      if (localOnRecentUserOpsListener != null)
      {
        localOnRecentUserOpsListener.onMenuItemClick(paramString1, paramRecentBaseData, paramString2);
        ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportSetTopOrCancelSetTop(paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin(), paramString1, localResources);
      }
    }
    else
    {
      paramRecentBaseData.getRecentUserType();
      b(paramRecentBaseData, paramString1, paramString2);
      ReportController.b(this.d, "dc00898", "", "", "0X800A360", "0X800A360", 0, 0, "1", "", paramString2, "");
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.g = paramDragFrameLayout;
    this.g.a(this, true);
    this.g.setDragViewProviderByGroup(FrameControllerUtil.l, this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.e.a(paramQQAppInterface);
    if (this.d != paramQQAppInterface)
    {
      this.d = paramQQAppInterface;
      this.j = null;
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((RecentTabHaloPresenter)localObject).a();
    }
    localObject = this.a;
    if (localObject != null) {
      ((RecentItemBuilderFactory)localObject).a(paramQQAppInterface);
    }
    this.k = new RecentTabHaloPresenter(paramQQAppInterface);
    this.k.a(new RecentAdapter.11(this));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAccountChanged: invoked. Message: app: ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(" recreate mRecentTabHaloPresenter: ");
      ((StringBuilder)localObject).append(this.k);
      QLog.i("RecentTabHaloPresenter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject3 = this.d.getMessageFacade().getLastMessage(paramRecentUser.uin, 1008);
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
    localStringBuilder.append(TroopUtils.a(this.d, paramString));
    ReportController.b(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, localStringBuilder.toString(), "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.f != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i2 = this.f.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.f.getChildAt(i1);
        RecentBaseData localRecentBaseData = a(localView);
        if ((localRecentBaseData != null) && (localRecentBaseData.getRecentUserType() == paramInt) && (Utils.a(localRecentBaseData.getRecentUserUin(), paramString)))
        {
          a(localView, localRecentBaseData);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.f != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i2 = this.f.getChildCount();
      int i1 = 1;
      while (i1 < i2)
      {
        View localView = this.f.getChildAt(i1);
        RecentBaseData localRecentBaseData = a(localView);
        if ((localRecentBaseData != null) && (Utils.a(paramString, localRecentBaseData.getRecentUserUin())))
        {
          int i3 = localRecentBaseData.getRecentUserType();
          if ((paramBoolean) && (i3 == 1))
          {
            a(localView, localRecentBaseData);
            return;
          }
          if ((!paramBoolean) && (this.u.contains(Integer.valueOf(i3))))
          {
            a(localView, localRecentBaseData);
            return;
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    if (this.d == null) {
      return;
    }
    hideMenuPop();
    int i1;
    if (paramList != null) {
      i1 = paramList.size();
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setDataList size = ");
      ((StringBuilder)localObject1).append(i1);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString());
    }
    if (i1 == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setDataList size = ");
      ((StringBuilder)localObject1).append(i1);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString(), new Exception("setDataListEmpty"));
    }
    Object localObject3 = this.f;
    boolean bool = localObject3 instanceof SwipListView;
    Object localObject1 = null;
    Object localObject2 = null;
    if (bool)
    {
      localObject3 = (SwipListView)localObject3;
      i1 = this.i;
      localObject1 = localObject2;
      if (i1 >= 0)
      {
        localObject1 = localObject2;
        if (i1 < this.b.size()) {
          localObject1 = this.b.get(this.i);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setDataList findsel, [");
        ((StringBuilder)localObject2).append(this.i);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("Q.recent", 4, ((StringBuilder)localObject2).toString());
      }
      this.i = -1;
      localObject2 = localObject3;
    }
    else
    {
      localObject2 = null;
    }
    this.b.clear();
    if (paramList != null) {}
    try
    {
      paramList = paramList.iterator();
      i1 = -1;
      while (paramList.hasNext())
      {
        localObject3 = (RecentBaseData)paramList.next();
        if (localObject3 != null)
        {
          i1 += 1;
          if ((localObject3 instanceof RecentItemChatMsgData)) {
            ((RecentBaseData)localObject3).mPosition = i1;
          }
          if (!a(this.d, (RecentBaseData)localObject3)) {
            this.b.add(localObject3);
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
      int i2;
      break label399;
    }
    if (localObject2 != null)
    {
      if (this.b.size() == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((SwipListView)localObject2).setDragEnable(bool);
    }
    if ((localObject1 instanceof RecentBaseData))
    {
      paramList = (RecentBaseData)localObject1;
      i1 = Math.max(((SwipListView)localObject2).getFirstVisiblePosition(), 0);
      i2 = Math.min(((SwipListView)localObject2).getLastVisiblePosition() + 1, this.b.size());
      while (i1 < i2)
      {
        if (paramList.equals(this.b.get(i1)))
        {
          this.i = i1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          paramList = new StringBuilder();
          paramList.append("setDataList getsel, [");
          paramList.append(i1);
          paramList.append(",");
          paramList.append(this.b.get(i1));
          paramList.append("]");
          QLog.i("Q.recent", 4, paramList.toString());
          break;
        }
        i1 += 1;
      }
    }
    if ((localObject2 != null) && (this.i == -1)) {
      ((SwipListView)localObject2).hideCurShowingRightView();
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.e.a.cancelPendingRequests();
      this.e.a.pause();
      return;
    }
    if (this.e.a.isPausing()) {
      this.e.a.resume();
    }
    this.p = System.currentTimeMillis();
    int i2 = this.f.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecentBaseData localRecentBaseData = a(this.f.getChildAt(i1));
      if ((localRecentBaseData != null) && (!(localRecentBaseData instanceof RecentItemImaxADData))) {
        this.e.a(localRecentBaseData.getRecentUserType(), localRecentBaseData.getRecentUserUin(), false);
      }
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    return (this.f instanceof SwipListView);
  }
  
  public DragFrameLayout b()
  {
    return this.g;
  }
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 8) && (paramRecentBaseData.mExtraType == 25))
    {
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "");
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
      localObject1 = ((QCallCardManager)this.d.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(paramRecentBaseData.getRecentUserUin());
      if (localObject1 != null) {
        paramRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    RecentItemBuilderFactory localRecentItemBuilderFactory = this.a;
    if (localRecentItemBuilderFactory != null) {
      localRecentItemBuilderFactory.b(paramQQAppInterface);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void c() {}
  
  public boolean d()
  {
    return (e()) || (this.b.size() == 0);
  }
  
  protected boolean e()
  {
    int i1 = this.m;
    return (i1 == 3) || (i1 == 8);
  }
  
  public RecentFaceDecoder f()
  {
    return this.e;
  }
  
  public List<View> g()
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = this.f.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.f.getChildAt(i1);
      if (localView != null)
      {
        localView = localView.findViewById(2131449128);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.getDragViewType() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    if ((!e()) && (this.b.size() != 0)) {
      return this.b.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      Object localObject;
      if ((!e()) && (this.b.size() != 0))
      {
        if ((paramInt < 0) || (paramInt >= this.b.size())) {
          break label81;
        }
        localObject = this.b.get(paramInt);
      }
      else
      {
        localObject = Integer.valueOf(this.m);
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
    return this.a.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject2 = getItem(paramInt);
      Object localObject1 = this.a.b(localObject2);
      if ((localObject2 instanceof RecentBaseData))
      {
        localObject2 = (RecentBaseData)localObject2;
        b((RecentBaseData)localObject2);
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, this.e, paramView, paramViewGroup, this.c, this, this, this);
        paramView = (View)localObject1;
      }
      else if ((localObject2 instanceof Integer))
      {
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.c, this, this, this);
        paramView = (View)localObject1;
      }
      else if ((localObject2 instanceof String))
      {
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.c, null, null, null);
        paramView = (View)localObject1;
      }
      else
      {
        localObject1 = ((RecentItemBaseBuilder)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.c, null, null, null);
        paramView = (View)localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      RecentParcelUtil.a(this.d.getApp(), false, localThrowable);
      if (RecentParcelUtil.c(this.d.getApp())) {
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
    return this.a.b();
  }
  
  public void h()
  {
    this.e.b();
    this.d = null;
    RecentTabHaloPresenter localRecentTabHaloPresenter = this.k;
    if (localRecentTabHaloPresenter != null) {
      localRecentTabHaloPresenter.a();
    }
  }
  
  public void hideMenuPop()
  {
    BubblePopupWindow localBubblePopupWindow = this.h;
    if (localBubblePopupWindow != null)
    {
      localBubblePopupWindow.dismiss();
      this.h = null;
    }
  }
  
  public void i()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.e;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.c();
    }
  }
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    FrameHelperActivity.c(paramBoolean ^ true);
  }
  
  public List<Object> j()
  {
    List localList = this.b;
    if (localList != null) {
      return new ArrayList(localList);
    }
    return null;
  }
  
  public RecentBaseData k()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      int i2 = ((List)localObject).size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.b.get(i1);
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (MultiAIOHelper.a(((RecentBaseData)localObject).getRecentUserType())) {
            return localObject;
          }
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    RecentAdapter.ShowUpStateListener localShowUpStateListener = this.s;
    if (localShowUpStateListener == null) {
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() != 0) && ((this.b.get(0) instanceof RecentUserBaseData)))
    {
      localObject = ((RecentUserBaseData)this.b.get(0)).e();
      if ((localObject != null) && (((RecentUser)localObject).showUpTime > 0L))
      {
        localShowUpStateListener.q();
        return;
      }
      localShowUpStateListener.r();
      return;
    }
    localShowUpStateListener.r();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      Object localObject;
      if ((paramDragFrameLayout != null) && (paramDragFrameLayout.getDragView() != null))
      {
        localObject = paramDragFrameLayout.getDragView().getTag();
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          if ((localObject != null) && (localObject != FrameControllerUtil.l)) {
            return;
          }
        }
      }
      int i1;
      if (this.n == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      RecentUser localRecentUser;
      if (paramInt == 2)
      {
        if (paramDragFrameLayout == null) {
          paramDragFrameLayout = "null";
        } else {
          paramDragFrameLayout = paramDragFrameLayout.getClass().getSimpleName();
        }
        QLog.d("RecentAdapter", 2, new Object[] { "onChange type=", Integer.valueOf(paramInt), " from=", paramDragFrameLayout, " Current Thread=", Thread.currentThread().getName() });
        if (i1 != 0)
        {
          paramDragFrameLayout = this.b.iterator();
          while (paramDragFrameLayout.hasNext())
          {
            localObject = paramDragFrameLayout.next();
            if (((localObject instanceof RecentBaseData)) && ((localObject instanceof RecentUserBaseData)))
            {
              localObject = (RecentUserBaseData)localObject;
              if (((RecentUserBaseData)localObject).mUnreadNum > 0)
              {
                localRecentUser = ((RecentUserBaseData)localObject).e();
                RecentReportHelper.a(this.d, (RecentBaseData)localObject, localRecentUser, true);
              }
            }
          }
        }
        o();
        n();
        if (!this.d.isCallTabShow)
        {
          paramDragFrameLayout = (QCallFacade)this.d.getManager(QQManagerFactory.RECENT_CALL_FACADE);
          if (paramDragFrameLayout != null) {
            paramDragFrameLayout.a(MessageCache.c());
          }
        }
        ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).recordOneKeyClean();
        return;
      }
      paramDragFrameLayout = paramDragFrameLayout.getDragView();
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
            if ((i1 != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
            {
              localRecentUser = ((RecentUserBaseData)paramDragFrameLayout).e();
              RecentReportHelper.a(this.d, (RecentBaseData)localObject, localRecentUser, false);
              if (TripleGraySwitchUtil.a(this.d.getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK")) {
                ConversationFacadeUtil.a(this.d, localRecentUser.uin, localRecentUser.type);
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
    if (!c(paramView))
    {
      Object localObject1 = (StoryHaloManager)this.d.getManager(QQManagerFactory.STORY_HALO_MANAGER);
      if (this.o != null)
      {
        Object localObject2 = paramView.getTag(-22);
        if (((StoryHaloManager)localObject1).b(localObject2)) {
          this.o.onClick(paramView, localObject2);
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
          int i1 = ((Integer)localObject1).intValue();
          localObject1 = getItem(i1);
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
              this.o.onClick(paramView, localObject1);
            }
            else
            {
              localObject2 = (RecentBaseData)localObject1;
              ((RecentBaseData)localObject2).mPosition = i1;
              this.o.onRecentBaseDataClick(paramView, (RecentBaseData)localObject2, ((RecentBaseData)localObject2).mTitleName, true);
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
            this.o.onClick(paramView, localObject1);
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
    if (this.f != null)
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
          Hashtable localHashtable = this.q;
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
      long l2 = this.p;
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
        localStringBuilder1.append(this.n);
        QLog.d("RecentAdapter", 2, localStringBuilder1.toString());
      }
      if ((paramInt1 > 0) && (!bool1)) {
        return;
      }
      synchronized (this.q)
      {
        if (this.q.size() == 0) {
          return;
        }
        if (paramInt1 == 0) {
          this.p = 0L;
        } else {
          this.p = l1;
        }
        m();
        this.q.clear();
        return;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    RecentBaseData localRecentBaseData = b(paramView);
    boolean bool2 = false;
    if (localRecentBaseData == null) {
      return false;
    }
    int i2 = ((Integer)paramView.getTag(-1)).intValue();
    Object localObject = this.a.b(localRecentBaseData);
    c(localRecentBaseData);
    List localList = null;
    if (localObject != null) {
      localList = ((RecentItemBaseBuilder)localObject).a(localRecentBaseData, this.c);
    }
    if ((localList != null) && (localList.size() > 0) && (SystemClock.uptimeMillis() - this.r > 100L))
    {
      localObject = new QQCustomMenu();
      int i1 = 0;
      while (i1 < localList.size())
      {
        ((QQCustomMenu)localObject).a(i2, (String)localList.get(i1));
        i1 += 1;
      }
      boolean bool1;
      if ((this.t) && (MultiAIOStarter.a(this.c, localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType(), localRecentBaseData.getTitleName(), "conversation_tab_list")))
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
          this.h = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.l, new RecentAdapter.3(this, paramView));
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
      this.r = SystemClock.uptimeMillis();
      return bool1;
    }
    if (QLog.isDevelopLevel())
    {
      paramView = new StringBuilder();
      paramView.append("RecentAdpater onLongClick no menu, builder = ");
      paramView.append(localObject);
      QLog.i("Q.recent", 4, paramView.toString());
    }
    return false;
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i1 = i2;
      if ((paramView instanceof Integer)) {
        i1 = ((Integer)paramView).intValue();
      }
    }
    this.i = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter
 * JD-Core Version:    0.7.0.1
 */