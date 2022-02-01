package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.NearByGiftPanelHelper;
import com.tencent.mobileqq.activity.aio.helper.NearbyHelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.NearbyMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.NearbyMsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.tips.NearbyTipsController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.profilecard.IMiniCardManager;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;

public class NearbyChatPie
  extends BaseChatPie
{
  int bi = 0;
  int bj = -1;
  String bk;
  String bl = this.f.getIntent().getStringExtra("from_where_to_aio");
  boolean bm = true;
  byte[] bn = null;
  public boolean bo = false;
  protected boolean bp = false;
  boolean bq = false;
  public String br;
  boolean bs = false;
  boolean bt = false;
  protected boolean bu = true;
  FriendListObserver bv = new NearbyChatPie.8(this);
  protected MessageObserver bw = new NearbyChatPieObserver(this);
  NearbyRelevantObserver bx = new NearbyChatPie.9(this);
  ProtoUtils.TroopProtocolObserver by = new NearbyChatPie.10(this);
  
  public NearbyChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(Long.valueOf(paramString).longValue());
    localNearbyUserFollowReq.operation.set(paramInt);
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void bA()
  {
    if (aX().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.bs);
      localIntent.putExtra("uin", aX().getIntent().getStringExtra("tinyId"));
      aX().setResult(-1, localIntent);
    }
  }
  
  private void f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramString));
    boolean bool = ((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramString);
    ((IMiniCardManager)this.d.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, bool ^ true, new NearbyChatPie.5(this));
  }
  
  public void B()
  {
    Intent localIntent = new Intent(this.f, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("uinname", this.ah.e);
    localIntent.putExtra("uintype", this.ah.a);
    localIntent.putExtra("add_friend_source_id", this.ah.t);
    localIntent.putExtra("follow_flag", this.bu);
    this.f.startActivityForResult(localIntent, 2000);
  }
  
  protected void E()
  {
    this.ah.e = ContactUtils.h(this.d, this.ah.b);
  }
  
  public void K()
  {
    super.K();
  }
  
  public void O()
  {
    super.O();
  }
  
  public void U()
  {
    super.U();
    this.bo = false;
  }
  
  public boolean V()
  {
    bA();
    NearByGiftPanelHelper localNearByGiftPanelHelper = (NearByGiftPanelHelper)q(136);
    if ((localNearByGiftPanelHelper.g != null) && (localNearByGiftPanelHelper.g.b()))
    {
      localNearByGiftPanelHelper.g.a();
      super.V();
      return true;
    }
    return super.V();
  }
  
  public void X()
  {
    super.X();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.bu = paramIntent.getBooleanExtra("follow_flag", false);
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    super.a(paramIntent, paramInt);
  }
  
  public boolean a()
  {
    return this.bp;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    f(this.ah.b);
    f(this.d.getCurrentAccountUin());
    String str1 = this.f.getIntent().getStringExtra("ProfileCard_flag");
    String str2 = this.f.getIntent().getStringExtra("OFFICIAL_MSG");
    if ((this.i != null) && ("ProfileCard".equals(str1)) && (!TextUtils.isEmpty(str2)))
    {
      Object localObject2 = this.f.getIntent().getStringExtra("VERIFY_GRAY_TIPS");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new UniteGrayTipParam(this.ah.b, this.d.getCurrentAccountUin(), (String)localObject2, this.ah.a, -5000, 655381, MessageCache.c());
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 66);
        ((UniteGrayTipParam)localObject1).a(((String)localObject2).length() - 4, ((String)localObject2).length(), localBundle);
        localObject2 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.d, (UniteGrayTipParam)localObject1);
        UniteGrayTipMsgUtil.a(this.d, (MessageForUniteGrayTip)localObject2);
      }
      Object localObject1 = this.i.p().a();
      if ((localObject1 instanceof NearbyMessageSender)) {
        ((NearbyMessageSender)localObject1).a(str2);
      }
    }
    if ((this.i != null) && (this.i.O() != null)) {
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportNearbyAIOExp(this.d, this.i.O().b, str1);
    }
    return paramBoolean;
  }
  
  public void aN()
  {
    if (this.bp) {
      return;
    }
    super.aN();
  }
  
  protected void am()
  {
    super.am();
    if ((this.ah.a == 1001) || (this.ah.a == 10002))
    {
      Object localObject = this.e;
      if (this.ah.a == 1001) {
        i = 2131896559;
      } else {
        i = 2131891943;
      }
      localObject = ((Context)localObject).getString(i);
      int i = 1;
      b(true);
      this.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.q.setOnClickListener(null);
      this.r.setOnClickListener(null);
      this.I.setText((CharSequence)localObject);
      if (b) {
        this.I.setContentDescription((CharSequence)localObject);
      }
      if ((this.ah.a != 10002) || (this.d.getMsgCache().o(this.ah.b) != null)) {
        if ((this.ah.a == 1001) && (this.d.getMsgCache().r(this.ah.b) == null)) {
          i = 0;
        } else {
          i = -1;
        }
      }
      if (i != -1) {
        NearbyUtils.a(this.d, this.ah.b, i);
      }
    }
  }
  
  protected void ap()
  {
    super.ap();
    if (!this.aC) {
      a(this.f.app, this.ah.b, Integer.valueOf("3").intValue(), this.by);
    }
  }
  
  protected void au()
  {
    super.au();
    this.d.addObserver(this.bw);
    this.d.addObserver(this.bx);
    this.d.addObserver(this.bv);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bw);
    this.d.removeObserver(this.bx);
    this.d.removeObserver(this.bv);
  }
  
  protected HelperProvider b()
  {
    return new NearbyHelperProvider(this.f);
  }
  
  protected String b(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if ((this.ah.a != 1001) && (this.ah.a != 10002)) {
      return super.b(paramList, paramMessageRecord);
    }
    paramList = this.e;
    int i;
    if (this.ah.a == 1001) {
      i = 2131896559;
    } else {
      i = 2131891943;
    }
    return paramList.getString(i);
  }
  
  MqqHandler bz()
  {
    return this.m;
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new NearbyMessageSender(this.i)).a();
  }
  
  protected void c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = ContactUtils.h(this.d, this.ah.b);
    }
    this.ah.e = paramIntent;
    this.f.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      DatingUtil.a(this.c, new Object[] { "updateSession_updateTitle", this.ah.e });
    }
  }
  
  protected AIOContext d()
  {
    return new NearbyContext();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ListUI(this.i)).a(new UnreadTask(this.i)).a(new NearbyMsgListRefresher(this.i)).a();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    Object localObject1;
    Object localObject2;
    if (this.ah.a == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel())
      {
        localObject1 = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("From chatActivity : sameState Sig--->");
        ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(paramIntent));
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (paramIntent != null) {
        this.d.getMsgCache().f(this.ah.b, paramIntent);
      }
    }
    else if ((this.ah.a != 1001) && (this.ah.a != 10002))
    {
      if (this.ah.a == 1010)
      {
        this.bj = paramIntent.getIntExtra("gender", -1);
        this.bi = paramIntent.getIntExtra("dating_from_id", 0);
        paramIntent = paramIntent.getByteArrayExtra("rich_date_sig");
        if (paramIntent != null) {
          this.d.getMsgCache().k(this.ah.b, paramIntent);
        }
      }
    }
    else
    {
      this.bj = paramIntent.getIntExtra("gender", -1);
      localObject1 = paramIntent.getByteArrayExtra("rich_accost_sig");
      if (QLog.isColorLevel())
      {
        localObject2 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("From chatActivity : accost Sig--->");
        localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject1));
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (localObject1 != null) {
        this.d.getMsgCache().g(this.ah.b, (byte[])localObject1);
      }
      if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
        ChatActivityFacade.g(this.d, this.ah);
      } else {
        ThreadManager.post(new NearbyChatPie.1(this), 5, null, false);
      }
    }
    if (-1 == this.bj) {
      ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public void e(String paramString)
  {
    String str = this.bk;
    if ((str != null) && (str.length() > 0) && (this.bk.equals(paramString))) {
      ThreadManager.post(new NearbyChatPie.6(this, paramString), 5, null, false);
    }
    this.bk = null;
    paramString = this.bl;
    if ((paramString != null) && (paramString.equals("nearby_recommend_people")) && (this.bm)) {
      ThreadManager.post(new NearbyChatPie.7(this), 1, null, false);
    }
    this.bs = true;
  }
  
  protected TipsController f()
  {
    return new NearbyTipsController(this.i);
  }
  
  public void f(boolean paramBoolean)
  {
    bA();
    super.f(paramBoolean);
  }
  
  protected void h()
  {
    this.c = "NearbyChatPie";
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    if (paramMessage.what != 39) {
      return super.handleMessage(paramMessage);
    }
    this.bo = false;
    paramMessage = (String)paramMessage.obj;
    ChatActivityFacade.a(this.d, this.f, this.ah, paramMessage);
    return true;
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
    ((TempMsgManager)this.d.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.ah, this);
  }
  
  protected boolean p()
  {
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 0) && (!this.bt)) {
        this.bt = true;
      }
      if (this.ah.a == 1010)
      {
        int i = this.bi;
        if (((i == 2) || (i == 3)) && (paramObservable.isSendFromLocal()) && (Utils.a(paramObservable.senderuin, this.d.getCurrentAccountUin()))) {
          if (this.bi == 2) {
            ReportController.b(this.d, "CliOper", "", this.ah.b, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.d, "CliOper", "", this.ah.b, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
          }
        }
      }
      this.bi = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.ah.b.equals(paramObservable.frienduin)) && ((this.ah.a == paramObservable.istroop) || ((UinTypeUtil.b(this.ah.a)) && (UinTypeUtil.b(paramObservable.istroop)))) && ((this.ah.a == 1001) || (this.ah.a == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.d.getMessageFacade().B();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.f.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.f.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        AIOAnimationControlManager.a(this, false);
      }
    }
  }
  
  protected boolean x()
  {
    return (this.ah.a != 1001) && (this.ah.a != 10002) && (this.ah.a != 1010);
  }
  
  protected void z()
  {
    if ((this.ah.a != 1009) && (this.ah.a != 10002) && (this.ah.a != 1001))
    {
      this.A.setOnClickListener(new NearbyChatPie.4(this));
      if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
      {
        this.A.setVisibility(0);
        this.A.setContentDescription(this.f.getResources().getString(2131896548));
        return;
      }
      this.A.setVisibility(8);
      return;
    }
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie
 * JD-Core Version:    0.7.0.1
 */