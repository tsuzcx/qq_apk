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
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
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
  public static long a;
  private static SparseArrayCompat<IStructMsgBgSetter> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private static IStructMsgBgSetter jdField_a_of_type_ComTencentMobileqqActivityAioStructMsgIStructMsgBgSetter = new DefaultStructMsgBgSetter();
  private static boolean b;
  protected Context a;
  protected ArraySet<Long> a;
  public ChatAdapter1.BubbleOnlongClickListener a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public BaseChatPie a;
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
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
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
    if (paramBaseChatPie == null) {}
    for (long l = NetConnInfoCenter.getServerTime();; l = paramBaseChatPie.a())
    {
      this.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper = new ChatAdapterSelectableHelper(this, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatSelCurPageForLSSHelper = new ChatSelCurPageForLSSHelper(paramBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener = new ChatAdapter1.BubbleOnlongClickListener(this);
      return;
    }
  }
  
  @Nullable
  static ChatMessage a(List<ChatMessage> paramList, ArraySet<Long> paramArraySet, long paramLong)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "create time: " + paramLong);
    }
    long l1 = 0L;
    int i = 0;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      int j;
      label86:
      Object localObject2;
      if ((MessageUtils.b(localChatMessage.msgtype)) && (localChatMessage.needShowTimeStamp()))
      {
        j = 1;
        if ((j == 0) || ((i != 0) && ((localChatMessage.time >= paramLong) || (localChatMessage.time - l1 <= 300L)) && ((localChatMessage.time < paramLong) || (localChatMessage.time - l1 <= 300L) || ((localObject1 != null) && (localChatMessage.time - localObject1.time <= 60L))) && ((!paramArraySet.contains(Long.valueOf(localChatMessage.uniseq))) || (l1 / 60L == localChatMessage.time / 60L)))) {
          break label472;
        }
        bool = true;
        label206:
        localChatMessage.mNeedTimeStamp = bool;
        if (localChatMessage.mNeedTimeStamp)
        {
          long l2 = localChatMessage.time;
          l1 = l2;
          if (localChatMessage.time < paramLong)
          {
            TimestampReporter.a(localChatMessage);
            l1 = l2;
          }
        }
        if ((i < 50) && (QLog.isColorLevel()))
        {
          if ((localChatMessage.msg == null) || (localChatMessage.msg.length() <= 0)) {
            break label478;
          }
          localObject2 = localChatMessage.msg.substring(0, 1);
          label295:
          StringBuilder localStringBuilder = new StringBuilder().append("msg: ").append((String)localObject2).append(", type: ").append(localChatMessage.msgtype).append(", mNeedTimeStamp: ").append(localChatMessage.mNeedTimeStamp).append(", time: ").append(localChatMessage.time).append(", lastTimestamp: ").append(l1).append(", last time: ");
          if (localObject1 != null) {
            break label485;
          }
          localObject2 = "null";
          label378:
          QLog.d("ChatAdapter1", 2, localObject2);
        }
        localObject2 = localObject1;
        if (j != 0)
        {
          localObject2 = localObject1;
          if (!UniteGrayTipUtil.a(localChatMessage)) {
            localObject2 = localChatMessage;
          }
        }
        if (i != paramList.size() - 1) {
          localChatMessage.isFlowMessage = false;
        }
        if (i != 0) {
          break label498;
        }
      }
      label472:
      label478:
      label485:
      label498:
      for (boolean bool = true;; bool = false)
      {
        localChatMessage.isFirstMsg = bool;
        i += 1;
        localObject1 = localObject2;
        break;
        j = 0;
        break label86;
        bool = false;
        break label206;
        localObject2 = "";
        break label295;
        localObject2 = Long.valueOf(localObject1.time);
        break label378;
      }
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
  
  public static void a(MessageForStructing paramMessageForStructing, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, boolean paramBoolean)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
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
  
  private boolean a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    boolean bool2 = false;
    Object localObject = ((MessageForMarketFace)paramChatMessage1).mMarkFaceMessage;
    MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramChatMessage2).mMarkFaceMessage;
    if (localObject == null) {
      paramChatMessage1.parse();
    }
    for (paramChatMessage1 = ((MessageForMarketFace)paramChatMessage1).mMarkFaceMessage;; paramChatMessage1 = (ChatMessage)localObject)
    {
      localObject = localMarkFaceMessage;
      if (localMarkFaceMessage == null)
      {
        paramChatMessage2.parse();
        localObject = ((MessageForMarketFace)paramChatMessage2).mMarkFaceMessage;
      }
      boolean bool1 = bool2;
      if (paramChatMessage1 != null)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (paramChatMessage1.dwTabID == ((MarkFaceMessage)localObject).dwTabID)
          {
            bool1 = bool2;
            if (EmosmUtils.a(paramChatMessage1.sbufID, paramChatMessage1.mediaType).equals(EmosmUtils.a(((MarkFaceMessage)localObject).sbufID, ((MarkFaceMessage)localObject).mediaType)))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", paramChatMessage1.dwTabID + "", "", "");
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return -1;
    }
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
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
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
    label22:
    View localView;
    ChatMessage localChatMessage;
    if (i >= 0)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      localChatMessage = (ChatMessage)localView.getTag(2131364647);
      if (localChatMessage != null) {
        break label61;
      }
    }
    label61:
    while (!localChatMessage.equals(paramChatMessage))
    {
      i -= 1;
      break label22;
      break;
    }
    a(localView, paramChatMessage, paramInt);
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  public void a(List<ChatMessage> paramList)
  {
    ChatMessage localChatMessage1;
    int i;
    int j;
    ChatMessage localChatMessage2;
    ChatMessage localChatMessage4;
    if (paramList.size() > 0)
    {
      localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - 1);
      i = 1;
      for (;;)
      {
        if ((MessageUtils.a(localChatMessage1.msgtype)) || (MsgProxyUtils.d(localChatMessage1.msgtype)))
        {
          i += 1;
          if ((paramList.size() - i >= 0) && (i <= 4))
          {
            localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - i);
          }
          else
          {
            j = 0;
            int k = i + 1;
            if (paramList.size() - k >= 0)
            {
              for (ChatMessage localChatMessage3 = (ChatMessage)paramList.get(paramList.size() - k);; localChatMessage3 = (ChatMessage)paramList.get(paramList.size() - k))
              {
                if (!MessageUtils.a(localChatMessage3.msgtype))
                {
                  localChatMessage2 = localChatMessage3;
                  localChatMessage4 = localChatMessage1;
                  i = j;
                  if (!MsgProxyUtils.d(localChatMessage3.msgtype)) {
                    break label216;
                  }
                }
                k += 1;
                if (paramList.size() - k < 0) {
                  break;
                }
              }
              i = 0;
              localChatMessage4 = localChatMessage1;
              localChatMessage2 = localChatMessage3;
            }
          }
        }
      }
    }
    for (;;)
    {
      label216:
      if ((i != 0) && (localChatMessage4 != null) && (localChatMessage2 != null))
      {
        localChatMessage4.isFlowMessage = false;
        localChatMessage2.isFlowMessage = false;
        if ((localChatMessage4.istroop == 1) || (localChatMessage4.istroop == 3000))
        {
          if (((localChatMessage4 instanceof MessageForMarketFace)) && ((localChatMessage2 instanceof MessageForMarketFace))) {
            localChatMessage4.isFlowMessage = a(localChatMessage4, localChatMessage2);
          }
          if ((localChatMessage4.istroop == 1) && ((localChatMessage4 instanceof MessageForText)) && ((localChatMessage2 instanceof MessageForText))) {
            localChatMessage4.isFlowMessage = b(localChatMessage4, localChatMessage2);
          }
        }
      }
      return;
      localChatMessage2 = null;
      i = 0;
      localChatMessage4 = localChatMessage1;
      continue;
      j = 1;
      break;
      localChatMessage2 = null;
      localChatMessage4 = null;
      i = 1;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList);
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
      ((DoutuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER)).a(paramList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramInt);
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
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label58;
      }
      j = i;
      if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq == paramLong) {
        break;
      }
      i += 1;
    }
    label58:
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
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label70;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localChatMessage.shmsgseq == paramLong)
      {
        j = i;
        if (!MsgProxyUtils.a(localChatMessage)) {
          break;
        }
      }
      i += 1;
    }
    label70:
    return -1;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (localChatMessage != null)
      {
        Object localObject1;
        Object localObject2;
        if ((localChatMessage instanceof RecommendCommonMessage))
        {
          localObject1 = (RecommendCommonMessage)localChatMessage;
          ((RecommendCommonMessage)localObject1).mHasReportShowIconEach = false;
          ((RecommendCommonMessage)localObject1).mHasReportShowUnderlineEach = false;
          if (((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer != null) {
            ((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer.doOnEvent(2);
          }
          localObject1 = ((RecommendCommonMessage)localObject1).mContextList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject2).next();
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
          localObject1 = (MessageForArkApp)localChatMessage;
          if (localObject1 != null)
          {
            ((MessageForArkApp)localObject1).doOnEvent(2);
            ((MessageForArkApp)localObject1).mExtendMsgArkAppList.clear();
          }
        }
        for (;;)
        {
          localChatMessage.isFolded = true;
          break;
          if ((localChatMessage instanceof MessageForArkBabyqReply))
          {
            localObject1 = (MessageForArkBabyqReply)localChatMessage;
            if ((localObject1 != null) && (((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList != null))
            {
              localObject1 = ((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ArkBabyqCardInfo)((Iterator)localObject1).next();
                if (localObject2 != null)
                {
                  ((ArkBabyqCardInfo)localObject2).doOnEvent(2);
                  if (((ArkBabyqCardInfo)localObject2).mExtendedArkBabyqCardList != null) {
                    ((ArkBabyqCardInfo)localObject2).mExtendedArkBabyqCardList.clear();
                  }
                }
              }
            }
          }
          else if ((localChatMessage instanceof MessageForPtt))
          {
            localObject1 = (MessageForPtt)localChatMessage;
            if (localObject1 != null)
            {
              ((MessageForPtt)localObject1).playProgress = 0.0F;
              ((MessageForPtt)localObject1).playSpeedPos = SonicHelper.a;
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a();
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
      if ((localSelectableDelegate == null) || (!localSelectableDelegate.c())) {
        break label41;
      }
      localSelectableDelegate.d();
    }
    label41:
    while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener.a.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener.a.a();
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
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      l1 = l2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        l1 = ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
      }
    }
    return l1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      paramInt = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localChatMessage != null) {
        localChatMessage.parse();
      }
      return ItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      StartupTracker.a(null, "AIO_ChatAdapter_getView" + " | " + localChatMessage.getClass().getName());
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
        ((View)localObject1).setTag(2131364647, localChatMessage);
        if (((localObject2 instanceof AbstractChatItemBuilder)) && ((localObject1 instanceof IChatShieldClick))) {
          localObject2 = (IChatShieldClick)localObject1;
        }
      }
      StartupTracker.a("AIO_ChatAdapter_getView" + " | " + localChatMessage.getClass().getName(), null);
    }
  }
  
  public int getViewTypeCount()
  {
    return 127;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1
 * JD-Core Version:    0.7.0.1
 */