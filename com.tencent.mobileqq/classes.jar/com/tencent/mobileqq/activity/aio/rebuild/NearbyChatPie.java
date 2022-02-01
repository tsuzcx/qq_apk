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
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.util.Utils;
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
  boolean D = true;
  public boolean E = false;
  protected boolean F = false;
  boolean G = false;
  boolean H = false;
  boolean I = false;
  protected boolean J = true;
  ProtoUtils.TroopProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = new NearbyChatPie.11(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NearbyChatPie.9(this);
  protected MessageObserver a;
  NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new NearbyChatPie.10(this);
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String d;
  String e = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("from_where_to_aio");
  public String f;
  int g = 0;
  int h = -1;
  
  public NearbyChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new NearbyChatPieObserver(this);
  }
  
  private void a()
  {
    if (a().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.H);
      localIntent.putExtra("uin", a().getIntent().getStringExtra("tinyId"));
      a().setResult(-1, localIntent);
    }
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
  
  private void e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramString));
    boolean bool = ((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramString);
    ((IMiniCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, bool ^ true, new NearbyChatPie.5(this));
  }
  
  public void A()
  {
    super.A();
  }
  
  protected void I()
  {
    super.I();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
        i = 2131698612;
      } else {
        i = 2131694305;
      }
      localObject = ((Context)localObject).getString(i);
      int i = 1;
      a(true);
      this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.f.setText((CharSequence)localObject);
      if (jdField_a_of_type_Boolean) {
        this.f.setContentDescription((CharSequence)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().m(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null)) {
          i = 0;
        } else {
          i = -1;
        }
      }
      if (i != -1) {
        NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
      }
    }
  }
  
  protected void K()
  {
    super.K();
    if (!this.q) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf("3").intValue(), this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver);
    }
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected AIOContext a()
  {
    return new NearbyContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new NearbyMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new NearbyMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected TipsController a()
  {
    return new NearbyTipsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  protected HelperProvider a()
  {
    return new NearbyHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002)) {
      return super.a(paramList, paramMessageRecord);
    }
    paramList = this.jdField_a_of_type_AndroidContentContext;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
      i = 2131698612;
    } else {
      i = 2131694305;
    }
    return paramList.getString(i);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.J = paramIntent.getBooleanExtra("follow_flag", false);
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    super.a(paramIntent, paramInt);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("ProfileCard_flag");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("OFFICIAL_MSG");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext != null) && ("ProfileCard".equals(localObject1)) && (!TextUtils.isEmpty(str)))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("VERIFY_GRAY_TIPS");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new UniteGrayTipParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5000, 655381, MessageCache.a());
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 66);
        ((UniteGrayTipParam)localObject1).a(((String)localObject2).length() - 4, ((String)localObject2).length(), localBundle);
        localObject2 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
        UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
      if ((localObject1 instanceof NearbyMessageSender)) {
        ((NearbyMessageSender)localObject1).a(str);
      }
    }
    return paramBoolean;
  }
  
  public void ab()
  {
    if (this.F) {
      return;
    }
    super.ab();
  }
  
  MqqHandler b()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      DatingUtil.a(this.jdField_b_of_type_JavaLangString, new Object[] { "updateSession_updateTitle", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "NearbyChatPie";
  }
  
  public void c(boolean paramBoolean)
  {
    a();
    super.c(paramBoolean);
  }
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("From chatActivity : sameState Sig--->");
        ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(paramIntent));
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
      {
        this.h = paramIntent.getIntExtra("gender", -1);
        this.g = paramIntent.getIntExtra("dating_from_id", 0);
        paramIntent = paramIntent.getByteArrayExtra("rich_date_sig");
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
        }
      }
    }
    else
    {
      this.h = paramIntent.getIntExtra("gender", -1);
      localObject1 = paramIntent.getByteArrayExtra("rich_accost_sig");
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("From chatActivity : accost Sig--->");
        localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject1));
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject1);
      }
      if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
        ChatActivityFacade.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      } else {
        ThreadManager.post(new NearbyChatPie.1(this), 5, null, false);
      }
    }
    if (-1 == this.h) {
      ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public void d(String paramString)
  {
    String str = this.jdField_d_of_type_JavaLangString;
    if ((str != null) && (str.length() > 0) && (this.jdField_d_of_type_JavaLangString.equals(paramString))) {
      ThreadManager.post(new NearbyChatPie.7(this, paramString), 5, null, false);
    }
    this.jdField_d_of_type_JavaLangString = null;
    paramString = this.e;
    if ((paramString != null) && (paramString.equals("nearby_recommend_people")) && (this.D)) {
      ThreadManager.post(new NearbyChatPie.8(this), 1, null, false);
    }
    this.H = true;
  }
  
  public boolean d()
  {
    a();
    NearByGiftPanelHelper localNearByGiftPanelHelper = (NearByGiftPanelHelper)a(136);
    if ((localNearByGiftPanelHelper.a != null) && (localNearByGiftPanelHelper.a.a()))
    {
      localNearByGiftPanelHelper.a.a();
      super.d();
      return true;
    }
    return super.d();
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    if (paramMessage.what != 39) {
      return super.handleMessage(paramMessage);
    }
    this.E = false;
    paramMessage = (String)paramMessage.obj;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
    return true;
  }
  
  protected void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1009) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new NearbyChatPie.4(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698601));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    super.j();
  }
  
  public void k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
    localIntent.putExtra("follow_flag", this.J);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void p()
  {
    super.p();
  }
  
  public boolean t()
  {
    return this.F;
  }
  
  public void u()
  {
    super.u();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 0) && (!this.I))
      {
        this.I = true;
        a().runOnUiThread(new NearbyChatPie.6(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
      {
        int i = this.g;
        if (((i == 2) || (i == 3)) && (paramObservable.isSendFromLocal()) && (Utils.a(paramObservable.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          if (this.g == 2) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
          }
        }
      }
      this.g = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramObservable.istroop)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        AIOAnimationControlManager.a(this, false);
      }
    }
  }
  
  public void z()
  {
    super.z();
    this.E = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie
 * JD-Core Version:    0.7.0.1
 */