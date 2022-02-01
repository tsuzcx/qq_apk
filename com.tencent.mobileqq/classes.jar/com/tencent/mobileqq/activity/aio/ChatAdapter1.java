package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.structMsg.DefaultStructMsgBgSetter;
import com.tencent.mobileqq.activity.aio.structMsg.EmptyStructMsgBgSetter;
import com.tencent.mobileqq.activity.aio.structMsg.IStructMsgBgSetter;
import com.tencent.mobileqq.activity.aio.structMsg.StructMsgBgSetterWithTail;
import com.tencent.mobileqq.activity.aio.structMsg.StructMsgBgSetterWithTailWhenMsgHasHeadIcon;
import com.tencent.mobileqq.activity.miniaio.IChatShieldClick;
import com.tencent.mobileqq.activity.selectable.AIOMenuWrapper;
import com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper;
import com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class ChatAdapter1
  extends XBaseAdapter
  implements DecodeTaskCompletionListener
{
  @Deprecated
  public static long e = -1L;
  private static SparseArrayCompat<IStructMsgBgSetter> r = new SparseArrayCompat();
  private static boolean s;
  private static IStructMsgBgSetter t = new DefaultStructMsgBgSetter();
  protected List<ChatMessage> a = new ArrayList();
  protected QQAppInterface b;
  public ItemBuilderFactory c;
  CharSequence d = null;
  public ChatAdapter1.BubbleOnlongClickListener f;
  public Boolean g = Boolean.valueOf(true);
  public boolean h = false;
  public IFaceDecoder i;
  protected ListView j;
  protected BaseChatPie k;
  protected SessionInfo l;
  protected long m;
  protected ArraySet<Long> n = new ArraySet();
  public ChatAdapterSelectableHelper o;
  public ChatSelCurPageForLSSHelper p;
  protected Context q;
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.b = paramQQAppInterface;
    this.c = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.l = paramSessionInfo;
    this.i = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.i.setDecodeTaskCompletionListener(this);
    this.q = paramContext;
    this.k = paramBaseChatPie;
    long l1;
    if (paramBaseChatPie == null) {
      l1 = NetConnInfoCenter.getServerTime();
    } else {
      l1 = paramBaseChatPie.bp();
    }
    this.m = l1;
    this.o = new ChatAdapterSelectableHelper(this, paramQQAppInterface);
    this.p = new ChatSelCurPageForLSSHelper(paramBaseChatPie);
    this.f = new ChatAdapter1.BubbleOnlongClickListener(this);
  }
  
  @Nullable
  static ChatMessage a(List<ChatMessage> paramList, ArraySet<Long> paramArraySet, long paramLong)
  {
    boolean bool1 = QLog.isColorLevel();
    String str = "ChatAdapter1";
    if (bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("create time: ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("ChatAdapter1", 2, ((StringBuilder)localObject1).toString());
    }
    long l1 = 0L;
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i1);
      bool1 = MessageUtils.c(localChatMessage.msgtype);
      boolean bool2 = true;
      int i2;
      if ((bool1) && (localChatMessage.needShowTimeStamp())) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i2 != 0)
      {
        if ((i1 != 0) && ((localChatMessage.time >= paramLong) || (localChatMessage.time - l1 <= 300L)))
        {
          if ((localChatMessage.time >= paramLong) && (localChatMessage.time - l1 > 300L)) {
            if ((localObject1 == null) || (localChatMessage.time - ((ChatMessage)localObject1).time > 60L)) {
              break label240;
            }
          }
          if ((!paramArraySet.contains(Long.valueOf(localChatMessage.uniseq))) || (l1 / 60L == localChatMessage.time / 60L)) {
            break label246;
          }
        }
        label240:
        bool1 = true;
        break label249;
      }
      label246:
      bool1 = false;
      label249:
      localChatMessage.mNeedTimeStamp = bool1;
      if (localChatMessage.mNeedTimeStamp)
      {
        l1 = localChatMessage.time;
        if (localChatMessage.time < paramLong) {
          TimestampReporter.a(localChatMessage);
        }
      }
      if ((i1 < 50) && (QLog.isColorLevel()))
      {
        if ((localChatMessage.msg != null) && (localChatMessage.msg.length() > 0)) {
          localObject2 = localChatMessage.msg.substring(0, 1);
        } else {
          localObject2 = "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msg: ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(", type: ");
        localStringBuilder.append(localChatMessage.msgtype);
        localStringBuilder.append(", mNeedTimeStamp: ");
        localStringBuilder.append(localChatMessage.mNeedTimeStamp);
        localStringBuilder.append(", time: ");
        localStringBuilder.append(localChatMessage.time);
        localStringBuilder.append(", lastTimestamp: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", last time: ");
        if (localObject1 == null) {
          localObject2 = "null";
        } else {
          localObject2 = Long.valueOf(((ChatMessage)localObject1).time);
        }
        localStringBuilder.append(localObject2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      Object localObject2 = localObject1;
      if (i2 != 0)
      {
        localObject2 = localObject1;
        if (!UniteGrayTipMsgUtil.b(localChatMessage)) {
          localObject2 = localChatMessage;
        }
      }
      if (i1 != paramList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      if (i1 == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localChatMessage.isFirstMsg = bool1;
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private String a(MessageForText paramMessageForText)
  {
    if (paramMessageForText.sb != null) {
      return paramMessageForText.sb.toString();
    }
    return paramMessageForText.msg;
  }
  
  protected static void a(MessageForStructing paramMessageForStructing, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, boolean paramBoolean)
  {
    if (paramMessageForStructing != null)
    {
      if (paramMessageForStructing.structingMsg == null) {
        return;
      }
      h();
      IStructMsgBgSetter localIStructMsgBgSetter2 = (IStructMsgBgSetter)r.get(paramMessageForStructing.structingMsg.mMsgServiceID);
      IStructMsgBgSetter localIStructMsgBgSetter1 = localIStructMsgBgSetter2;
      if (localIStructMsgBgSetter2 == null) {
        localIStructMsgBgSetter1 = t;
      }
      localIStructMsgBgSetter1.a(paramMessageForStructing, paramViewHolder, paramView, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if ((paramBoolean) && (paramChatMessage1 != null))
    {
      if (paramChatMessage2 == null) {
        return;
      }
      paramChatMessage1.isFlowMessage = false;
      paramChatMessage2.isFlowMessage = false;
      ListUI localListUI = this.k.bv().e().b();
      JumpStateMachineController localJumpStateMachineController = null;
      if ((localListUI instanceof TroopListUI)) {
        localJumpStateMachineController = ((TroopListUI)localListUI).y();
      } else if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localListUI)) {
        localJumpStateMachineController = (JumpStateMachineController)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildListUIJumpStateController(localListUI);
      }
      if ((localJumpStateMachineController != null) && (localJumpStateMachineController.a() == JumpState.JUMP_SUCCESS)) {
        return;
      }
      if ((paramChatMessage1.istroop == 1) || (paramChatMessage1.istroop == 3000))
      {
        if (((paramChatMessage1 instanceof MessageForMarketFace)) && ((paramChatMessage2 instanceof MessageForMarketFace))) {
          paramChatMessage1.isFlowMessage = a(paramChatMessage1, paramChatMessage2);
        }
        if ((paramChatMessage1.istroop == 1) && ((paramChatMessage1 instanceof MessageForText)) && ((paramChatMessage2 instanceof MessageForText))) {
          paramChatMessage1.isFlowMessage = b(paramChatMessage1, paramChatMessage2);
        }
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    MessageForMarketFace localMessageForMarketFace2 = (MessageForMarketFace)paramChatMessage1;
    MarkFaceMessage localMarkFaceMessage3 = localMessageForMarketFace2.mMarkFaceMessage;
    MessageForMarketFace localMessageForMarketFace1 = (MessageForMarketFace)paramChatMessage2;
    MarkFaceMessage localMarkFaceMessage2 = localMessageForMarketFace1.mMarkFaceMessage;
    MarkFaceMessage localMarkFaceMessage1 = localMarkFaceMessage3;
    if (localMarkFaceMessage3 == null)
    {
      paramChatMessage1.parse();
      localMarkFaceMessage1 = localMessageForMarketFace2.mMarkFaceMessage;
    }
    paramChatMessage1 = localMarkFaceMessage2;
    if (localMarkFaceMessage2 == null)
    {
      paramChatMessage2.parse();
      paramChatMessage1 = localMessageForMarketFace1.mMarkFaceMessage;
    }
    if ((localMarkFaceMessage1 != null) && (paramChatMessage1 != null) && (localMarkFaceMessage1.dwTabID == paramChatMessage1.dwTabID) && (EmosmUtils.a(localMarkFaceMessage1.sbufID, localMarkFaceMessage1.mediaType).equals(EmosmUtils.a(paramChatMessage1.sbufID, paramChatMessage1.mediaType))))
    {
      paramChatMessage1 = this.b;
      paramChatMessage2 = new StringBuilder();
      paramChatMessage2.append(localMarkFaceMessage1.dwTabID);
      paramChatMessage2.append("");
      ReportController.b(paramChatMessage1, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", paramChatMessage2.toString(), "", "");
      return true;
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    paramChatMessage1.parse();
    paramChatMessage2.parse();
    return a((MessageForText)paramChatMessage1).equals(a((MessageForText)paramChatMessage2));
  }
  
  private static void h()
  {
    if (s) {
      return;
    }
    Object localObject = new EmptyStructMsgBgSetter();
    r.put(83, localObject);
    r.put(108, localObject);
    r.put(151, localObject);
    r.put(156, localObject);
    r.put(114, localObject);
    r.put(98, localObject);
    r.put(97, localObject);
    r.put(106, localObject);
    r.put(107, localObject);
    r.put(116, localObject);
    r.put(95, localObject);
    r.put(133, localObject);
    localObject = new StructMsgBgSetterWithTail();
    r.put(1, localObject);
    r.put(2, localObject);
    r.put(14, localObject);
    r.put(19, localObject);
    r.put(20, localObject);
    r.put(15, localObject);
    r.put(32, localObject);
    r.put(33, localObject);
    r.put(35, localObject);
    r.put(96, localObject);
    r.put(123, localObject);
    r.put(128, localObject);
    localObject = new StructMsgBgSetterWithTailWhenMsgHasHeadIcon();
    r.put(21, localObject);
    s = true;
  }
  
  private boolean i()
  {
    BaseChatPie localBaseChatPie = this.k;
    if (localBaseChatPie != null) {
      return ((ArkHelper)localBaseChatPie.q(110)).f();
    }
    return false;
  }
  
  public int a(long paramLong)
  {
    int i2 = getCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (getItemId(i1) == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public List<ChatMessage> a()
  {
    return this.a;
  }
  
  public void a(ArraySet<Long> paramArraySet)
  {
    this.n = paramArraySet;
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    this.c.a(paramChatMessage, this).a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i1 = this.a.indexOf(paramChatMessage);
    if (i1 >= 0)
    {
      Object localObject1;
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        localObject1 = (MessageForArkApp)paramChatMessage;
        if (localObject1 != null) {
          ((MessageForArkApp)localObject1).doOnEvent(2);
        }
      }
      if ((paramChatMessage instanceof RecommendCommonMessage))
      {
        localObject1 = (RecommendCommonMessage)paramChatMessage;
        if ((localObject1 != null) && (((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer != null)) {
          ((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer.doOnEvent(2);
        }
        if (localObject1 != null)
        {
          localObject1 = ((RecommendCommonMessage)localObject1).mContextList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject2).next();
                if (localArkMsgAppInfo != null) {
                  localArkMsgAppInfo.doOnEvent(2);
                }
              }
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForArkFlashChat))
      {
        localObject1 = (MessageForArkFlashChat)paramChatMessage;
        if ((localObject1 != null) && (((MessageForArkFlashChat)localObject1).arkContainer != null)) {
          ((MessageForArkFlashChat)localObject1).arkContainer.doOnEvent(2);
        }
      }
      if ((paramChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject1 = (MessageForArkBabyqReply)paramChatMessage;
        if (localObject1 != null) {
          ((MessageForArkBabyqReply)localObject1).doOnEvent(2);
        }
      }
      this.a.remove(paramChatMessage);
      notifyRowDeleted(i1, i1);
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage != null)
    {
      Object localObject = this.j;
      if (localObject == null) {
        return;
      }
      int i1 = ((ListView)localObject).getChildCount() - 1;
      while (i1 >= 0)
      {
        localObject = this.j.getChildAt(i1);
        ChatMessage localChatMessage = (ChatMessage)((View)localObject).getTag(2131430591);
        if ((localChatMessage != null) && (localChatMessage.equals(paramChatMessage)))
        {
          a((View)localObject, paramChatMessage, paramInt);
          return;
        }
        i1 -= 1;
      }
    }
  }
  
  public void a(ListView paramListView)
  {
    this.j = paramListView;
  }
  
  public void a(List<ChatMessage> paramList)
  {
    int i1 = paramList.size();
    ChatMessage localChatMessage2 = null;
    boolean bool3 = false;
    label112:
    ChatMessage localChatMessage3;
    boolean bool2;
    if (i1 > 0)
    {
      ChatMessage localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - 1);
      i1 = 1;
      for (;;)
      {
        if ((!MessageUtils.b(localChatMessage1.msgtype)) && (!MsgProxyUtils.d(localChatMessage1.msgtype)))
        {
          bool1 = true;
          break label112;
        }
        i1 += 1;
        if ((paramList.size() - i1 < 0) || (i1 > 4)) {
          break;
        }
        localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - i1);
      }
      boolean bool1 = false;
      i1 += 1;
      localChatMessage3 = localChatMessage1;
      bool2 = bool3;
      if (paramList.size() - i1 >= 0) {
        for (localChatMessage2 = (ChatMessage)paramList.get(paramList.size() - i1);; localChatMessage2 = (ChatMessage)paramList.get(paramList.size() - i1))
        {
          if ((!MessageUtils.b(localChatMessage2.msgtype)) && (!MsgProxyUtils.d(localChatMessage2.msgtype)))
          {
            localChatMessage3 = localChatMessage1;
            bool2 = bool1;
            break;
          }
          i1 += 1;
          localChatMessage3 = localChatMessage1;
          bool2 = bool3;
          if (paramList.size() - i1 < 0) {
            break;
          }
        }
      }
    }
    else
    {
      localChatMessage3 = null;
      bool2 = true;
    }
    a(bool2, localChatMessage3, localChatMessage2);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    ChatMessage localChatMessage1 = a(paramList, this.n, this.m);
    if (paramList.size() > 0) {
      this.n.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
    }
    this.a = paramList;
    if (this.b.getMessageFacade() != null) {
      this.b.getMessageFacade().c(paramList);
    }
    if (paramCharSequence != null)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.a.get(0);
      localChatMessage2.mNeedGrayTips = true;
      localChatMessage2.mMessageSource = paramCharSequence;
    }
    if ((localChatMessage1 != null) && (!localChatMessage1.isFlowMessage)) {
      a(paramList);
    }
    paramCharSequence = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.l.a == 3000) || (this.l.a == 1) || ((this.l.a == 0) && (paramCharSequence != null) && (paramCharSequence.n(this.l.b)))) {
      DoutuMsgUtil.a(this.b, paramList, this.l, this.k, paramInt);
    }
    if (BaseChatpieHelper.a(this.l)) {
      this.a = BaseChatpieHelper.a(this.a, this.l.A);
    }
    super.notifyDataSetChanged();
    this.p.b();
  }
  
  public int b(long paramLong)
  {
    if (paramLong < 0L) {
      return -1;
    }
    int i1 = 0;
    while (i1 < this.a.size())
    {
      if (((ChatMessage)this.a.get(i1)).uniseq == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int b(ChatMessage paramChatMessage)
  {
    List localList = this.a;
    if (localList == null) {
      return -1;
    }
    return localList.indexOf(paramChatMessage);
  }
  
  public void b()
  {
    if (!this.i.isPausing())
    {
      this.i.pause();
      this.i.cancelPendingRequests();
    }
  }
  
  public int c(long paramLong)
  {
    if (paramLong < 0L) {
      return -1;
    }
    int i1 = 0;
    while (i1 < this.a.size())
    {
      ChatMessage localChatMessage = (ChatMessage)this.a.get(i1);
      if ((localChatMessage.shmsgseq == paramLong) && (!MsgProxyUtils.a(localChatMessage))) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void c()
  {
    if (this.i.isPausing())
    {
      this.i.resume();
      notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject1).next();
      if (localChatMessage != null)
      {
        Object localObject2;
        Object localObject3;
        if ((localChatMessage instanceof RecommendCommonMessage))
        {
          localObject2 = (RecommendCommonMessage)localChatMessage;
          ((RecommendCommonMessage)localObject2).mHasReportShowIconEach = false;
          ((RecommendCommonMessage)localObject2).mHasReportShowUnderlineEach = false;
          if (((RecommendCommonMessage)localObject2).mOldAppInfo.mArkContainer != null) {
            ((RecommendCommonMessage)localObject2).mOldAppInfo.mArkContainer.doOnEvent(2);
          }
          localObject2 = ((RecommendCommonMessage)localObject2).mContextList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((RecommendCommonMessage.ArkContextInfo)localObject3).contextAppInfoList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject3).next();
                if (localArkMsgAppInfo != null)
                {
                  localArkMsgAppInfo.doOnEvent(2);
                  localArkMsgAppInfo.mOpenCardAppInfoList.clear();
                }
              }
            }
          }
        }
        if ((localChatMessage instanceof MessageForArkApp))
        {
          if (!i())
          {
            localObject2 = (MessageForArkApp)localChatMessage;
            if (localObject2 != null)
            {
              ((MessageForArkApp)localObject2).doOnEvent(2);
              ((MessageForArkApp)localObject2).mExtendMsgArkAppList.clear();
            }
          }
        }
        else if ((localChatMessage instanceof MessageForArkBabyqReply))
        {
          localObject2 = (MessageForArkBabyqReply)localChatMessage;
          if ((localObject2 != null) && (((MessageForArkBabyqReply)localObject2).mArkBabyqReplyCardList != null))
          {
            localObject2 = ((MessageForArkBabyqReply)localObject2).mArkBabyqReplyCardList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ArkBabyqCardInfo)((Iterator)localObject2).next();
              if (localObject3 != null)
              {
                ((ArkBabyqCardInfo)localObject3).doOnEvent(2);
                if (((ArkBabyqCardInfo)localObject3).mExtendedArkBabyqCardList != null) {
                  ((ArkBabyqCardInfo)localObject3).mExtendedArkBabyqCardList.clear();
                }
              }
            }
          }
        }
        else if ((localChatMessage instanceof MessageForPtt))
        {
          localObject2 = (MessageForPtt)localChatMessage;
          if (localObject2 != null)
          {
            ((MessageForPtt)localObject2).playProgress = 0.0F;
            ((MessageForPtt)localObject2).playSpeedPos = SonicHelper.a;
          }
        }
        localChatMessage.isFolded = true;
      }
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((ItemBuilderFactory)localObject1).a();
    }
    this.i.setDecodeTaskCompletionListener(null);
    this.i.destory();
    if (g()) {
      TimestampReporter.a();
    }
    this.p.c();
  }
  
  public void e()
  {
    if (this.f.a != null)
    {
      SelectableDelegate localSelectableDelegate = this.f.a.b();
      if ((localSelectableDelegate != null) && (localSelectableDelegate.l()))
      {
        localSelectableDelegate.n();
        return;
      }
      if (this.f.a.e()) {
        this.f.a.f();
      }
    }
  }
  
  public ArraySet<Long> f()
  {
    return this.n;
  }
  
  protected boolean g()
  {
    return true;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.a.size()) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.a.size() > 0) && (paramInt < this.a.size())) {
      return ((ChatMessage)this.a.get(paramInt)).uniseq;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt > this.a.size() - 1) {
      i1 = this.a.size() - 1;
    }
    paramInt = i1;
    if (i1 < 0) {
      paramInt = 0;
    }
    ChatMessage localChatMessage = (ChatMessage)this.a.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    return ItemBuilderFactory.a(this.b, localChatMessage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.a.size())
    {
      localObject1 = paramView;
    }
    else
    {
      ChatMessage localChatMessage = (ChatMessage)this.a.get(paramInt);
      localObject1 = AIOUtils.a();
      ((StringBuilder)localObject1).append("AIO_ChatAdapter_getView");
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(localChatMessage.getClass().getName());
      StartupTracker.a(null, ((StringBuilder)localObject1).toString());
      Object localObject2 = this.c.a(localChatMessage, this);
      if (paramInt != 0)
      {
        localObject1 = (ChatMessage)this.a.get(paramInt - 1);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForTroopUnreadTips))) {
          localChatMessage.mNeedTimeStamp = true;
        }
      }
      localObject1 = ((ChatItemBuilder)localObject2).a(paramInt, this.a.size(), localChatMessage, paramView, paramViewGroup, this.f);
      if (localObject1 != null)
      {
        ((View)localObject1).setTag(2131430591, localChatMessage);
        if (((localObject2 instanceof AbstractChatItemBuilder)) && ((localObject1 instanceof IChatShieldClick))) {
          localObject2 = (IChatShieldClick)localObject1;
        }
      }
      localObject2 = AIOUtils.a();
      ((StringBuilder)localObject2).append("AIO_ChatAdapter_getView");
      ((StringBuilder)localObject2).append(" | ");
      ((StringBuilder)localObject2).append(localChatMessage.getClass().getName());
      StartupTracker.a(((StringBuilder)localObject2).toString(), null);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 129;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",avatar= ");
      localStringBuilder.append(paramBitmap);
      QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
    }
    if (paramBitmap != null)
    {
      if (this.i.isPausing()) {
        return;
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1
 * JD-Core Version:    0.7.0.1
 */