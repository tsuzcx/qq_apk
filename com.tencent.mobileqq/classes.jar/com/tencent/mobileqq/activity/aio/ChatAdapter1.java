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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
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
  public static long a = -1L;
  private static SparseArrayCompat<IStructMsgBgSetter> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private static IStructMsgBgSetter jdField_a_of_type_ComTencentMobileqqActivityAioStructMsgIStructMsgBgSetter = new DefaultStructMsgBgSetter();
  private static boolean b;
  protected Context a;
  protected ArraySet<Long> a;
  public ChatAdapter1.BubbleOnlongClickListener a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  protected BaseChatPie a;
  public ItemBuilderFactory a;
  public ChatAdapterSelectableHelper a;
  public ChatSelCurPageForLSSHelper a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public IFaceDecoder a;
  protected ListView a;
  public Boolean a;
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  protected List<ChatMessage> a;
  public boolean a;
  protected long b;
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    long l;
    if (paramBaseChatPie == null) {
      l = NetConnInfoCenter.getServerTime();
    } else {
      l = paramBaseChatPie.a();
    }
    this.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper = new ChatAdapterSelectableHelper(this, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatSelCurPageForLSSHelper = new ChatSelCurPageForLSSHelper(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener = new ChatAdapter1.BubbleOnlongClickListener(this);
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
    long l = 0L;
    Object localObject1 = null;
    int i = 0;
    while (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      bool1 = MessageUtils.b(localChatMessage.msgtype);
      boolean bool2 = true;
      int j;
      if ((bool1) && (localChatMessage.needShowTimeStamp())) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if ((i != 0) && ((localChatMessage.time >= paramLong) || (localChatMessage.time - l <= 300L)))
        {
          if ((localChatMessage.time >= paramLong) && (localChatMessage.time - l > 300L)) {
            if ((localObject1 == null) || (localChatMessage.time - ((ChatMessage)localObject1).time > 60L)) {
              break label240;
            }
          }
          if ((!paramArraySet.contains(Long.valueOf(localChatMessage.uniseq))) || (l / 60L == localChatMessage.time / 60L)) {
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
        l = localChatMessage.time;
        if (localChatMessage.time < paramLong) {
          TimestampReporter.a(localChatMessage);
        }
      }
      if ((i < 50) && (QLog.isColorLevel()))
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
        localStringBuilder.append(l);
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
      if (j != 0)
      {
        localObject2 = localObject1;
        if (!UniteGrayTipMsgUtil.a(localChatMessage)) {
          localObject2 = localChatMessage;
        }
      }
      if (i != paramList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      if (i == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localChatMessage.isFirstMsg = bool1;
      i += 1;
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
      e();
      IStructMsgBgSetter localIStructMsgBgSetter2 = (IStructMsgBgSetter)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramMessageForStructing.structingMsg.mMsgServiceID);
      IStructMsgBgSetter localIStructMsgBgSetter1 = localIStructMsgBgSetter2;
      if (localIStructMsgBgSetter2 == null) {
        localIStructMsgBgSetter1 = jdField_a_of_type_ComTencentMobileqqActivityAioStructMsgIStructMsgBgSetter;
      }
      localIStructMsgBgSetter1.a(paramMessageForStructing, paramViewHolder, paramView, paramBoolean);
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
      paramChatMessage1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramChatMessage2 = new StringBuilder();
      paramChatMessage2.append(localMarkFaceMessage1.dwTabID);
      paramChatMessage2.append("");
      ReportController.b(paramChatMessage1, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", paramChatMessage2.toString(), "", "");
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      return ((ArkHelper)localBaseChatPie.a(110)).a();
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    paramChatMessage1.parse();
    paramChatMessage2.parse();
    return a((MessageForText)paramChatMessage1).equals(a((MessageForText)paramChatMessage2));
  }
  
  private static void e()
  {
    if (jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = new EmptyStructMsgBgSetter();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(83, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(108, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(151, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(156, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(114, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(98, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(97, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(106, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(107, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(116, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(95, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(133, localObject);
    localObject = new StructMsgBgSetterWithTail();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(1, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(2, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(14, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(19, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(20, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(15, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(32, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(33, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(35, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(96, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(123, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(128, localObject);
    localObject = new StructMsgBgSetterWithTailWhenMsgHasHeadIcon();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(21, localObject);
    jdField_b_of_type_Boolean = true;
  }
  
  public int a(long paramLong)
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      if (getItemId(i) == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return -1;
    }
    return localList.indexOf(paramChatMessage);
  }
  
  public ArraySet<Long> a()
  {
    return this.jdField_a_of_type_AndroidSupportV4UtilArraySet;
  }
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    }
  }
  
  public void a(ArraySet<Long> paramArraySet)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilArraySet = paramArraySet;
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(paramChatMessage, this).a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
    if (i >= 0)
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
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
      notifyRowDeleted(i, i);
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      if (localObject == null) {
        return;
      }
      int i = ((ListView)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        ChatMessage localChatMessage = (ChatMessage)((View)localObject).getTag(2131364534);
        if ((localChatMessage != null) && (localChatMessage.equals(paramChatMessage)))
        {
          a((View)localObject, paramChatMessage, paramInt);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  public void a(List<ChatMessage> paramList)
  {
    int i = paramList.size();
    Object localObject = null;
    ChatMessage localChatMessage1 = null;
    int j;
    label120:
    ChatMessage localChatMessage3;
    if (i > 0)
    {
      ChatMessage localChatMessage2 = (ChatMessage)paramList.get(paramList.size() - 1);
      for (i = 1;; i = j)
      {
        if ((!MessageUtils.a(localChatMessage2.msgtype)) && (!MsgProxyUtils.d(localChatMessage2.msgtype)))
        {
          k = 1;
          j = i;
          i = k;
          break label120;
        }
        j = i + 1;
        if ((paramList.size() - j < 0) || (j > 4)) {
          break;
        }
        localChatMessage2 = (ChatMessage)paramList.get(paramList.size() - j);
      }
      i = 0;
      int k = j + 1;
      if (paramList.size() - k >= 0) {
        for (localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - k);; localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - k))
        {
          if (!MessageUtils.a(localChatMessage1.msgtype))
          {
            localChatMessage3 = localChatMessage2;
            localObject = localChatMessage1;
            j = i;
            if (!MsgProxyUtils.d(localChatMessage1.msgtype)) {
              break label248;
            }
          }
          k += 1;
          if (paramList.size() - k < 0) {
            break;
          }
        }
      }
      j = 0;
      localChatMessage3 = localChatMessage2;
      localObject = localChatMessage1;
    }
    else
    {
      localChatMessage3 = null;
      j = 1;
    }
    label248:
    if ((j != 0) && (localChatMessage3 != null) && (localObject != null))
    {
      localChatMessage3.isFlowMessage = false;
      localObject.isFlowMessage = false;
      if ((localChatMessage3.istroop == 1) || (localChatMessage3.istroop == 3000))
      {
        if (((localChatMessage3 instanceof MessageForMarketFace)) && ((localObject instanceof MessageForMarketFace))) {
          localChatMessage3.isFlowMessage = a(localChatMessage3, localObject);
        }
        if ((localChatMessage3.istroop == 1) && ((localChatMessage3 instanceof MessageForText)) && ((localObject instanceof MessageForText))) {
          localChatMessage3.isFlowMessage = b(localChatMessage3, localObject);
        }
      }
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    ChatMessage localChatMessage1 = a(paramList, this.jdField_a_of_type_AndroidSupportV4UtilArraySet, this.jdField_b_of_type_Long);
    if (paramList.size() > 0) {
      this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(paramList);
    }
    if (paramCharSequence != null)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      localChatMessage2.mNeedGrayTips = true;
      localChatMessage2.mMessageSource = paramCharSequence;
    }
    if ((localChatMessage1 != null) && (!localChatMessage1.isFlowMessage)) {
      a(paramList);
    }
    paramCharSequence = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (paramCharSequence != null) && (paramCharSequence.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      DoutuMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramInt);
    }
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      this.jdField_a_of_type_JavaUtilList = BaseChatpieHelper.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.i);
    }
    super.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatSelCurPageForLSSHelper.b();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public int b(long paramLong)
  {
    if (paramLong < 0L) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      notifyDataSetChanged();
    }
  }
  
  public int c(long paramLong)
  {
    if (paramLong < 0L) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localChatMessage.shmsgseq == paramLong) && (!MsgProxyUtils.a(localChatMessage))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
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
          if (!b())
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory;
    if (localObject1 != null) {
      ((ItemBuilderFactory)localObject1).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    if (a()) {
      TimestampReporter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatSelCurPageForLSSHelper.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener.a != null)
    {
      SelectableDelegate localSelectableDelegate = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener.a.a();
      if ((localSelectableDelegate != null) && (localSelectableDelegate.c()))
      {
        localSelectableDelegate.d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener.a.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener.a.a();
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    return ItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = paramView;
    }
    else
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject1 = AIOUtils.a();
      ((StringBuilder)localObject1).append("AIO_ChatAdapter_getView");
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(localChatMessage.getClass().getName());
      StartupTracker.a(null, ((StringBuilder)localObject1).toString());
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(localChatMessage, this);
      if (paramInt != 0)
      {
        localObject1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForTroopUnreadTips))) {
          localChatMessage.mNeedTimeStamp = true;
        }
      }
      localObject1 = ((ChatItemBuilder)localObject2).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener);
      if (localObject1 != null)
      {
        ((View)localObject1).setTag(2131364534, localChatMessage);
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
    return 128;
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        return;
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1
 * JD-Core Version:    0.7.0.1
 */