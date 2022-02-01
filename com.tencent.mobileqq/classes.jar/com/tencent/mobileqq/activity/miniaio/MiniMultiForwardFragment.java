package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MiniMultiForwardFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  float jdField_a_of_type_Float = 0.86F;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  MiniChatAdapter jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  public boolean a;
  float b = 16.0F;
  private float c = 0.78F;
  
  public MiniMultiForwardFragment()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Intent a()
  {
    return getBaseActivity().getIntent();
  }
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private Window a(Activity paramActivity)
  {
    return paramActivity.getWindow();
  }
  
  private WindowManager a(Activity paramActivity)
  {
    return paramActivity.getWindowManager();
  }
  
  private ArrayList<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    long l = this.jdField_a_of_type_Long;
    int j = 0;
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (l != 0L)
    {
      localObject1 = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      if (localObject1 != null) {
        while (i < ((List)localObject1).size())
        {
          localObject2 = (ChatMessage)((List)localObject1).get(i);
          localObject3 = a((ChatMessage)localObject2);
          if (localObject3 != null)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("generateFakeCombineMsg s:");
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_Long);
            ((StringBuilder)localObject4).append(" : ");
            ((StringBuilder)localObject4).append(((ChatMessage)localObject2).msgtype);
            QLog.i("MiniMultiForwardPreviewFragment", 2, ((StringBuilder)localObject4).toString());
            ((ChatMessage)localObject3).fakeSenderType = 2;
            localArrayList.add(localObject3);
          }
          i += 1;
        }
      }
    }
    else
    {
      localObject3 = MultiMsgManager.a().a;
      localObject4 = MultiMsgManager.a().b;
      if (localObject3 != null)
      {
        i = j;
        while (i < ((List)localObject3).size())
        {
          localObject1 = (ChatMessage)((List)localObject3).get(i);
          ChatMessage localChatMessage = a((ChatMessage)localObject1);
          if (localChatMessage != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("generateFakeCombineMsg   ");
            ((StringBuilder)localObject2).append(((ChatMessage)localObject1).msgtype);
            QLog.i("MiniMultiForwardPreviewFragment", 2, ((StringBuilder)localObject2).toString());
            localChatMessage.fakeSenderType = 2;
            if (localObject4 != null) {
              localObject1 = (String)((HashMap)localObject4).get(MsgProxyUtils.a(localChatMessage));
            } else {
              localObject1 = "";
            }
            localObject2 = localObject1;
            if (localChatMessage.istroop == 1)
            {
              localObject2 = localObject1;
              if (localObject1 != null) {
                localObject2 = com.tencent.mobileqq.text.TextUtils.removeColorNickCode((String)localObject1);
              }
            }
            localChatMessage.saveExtInfoToExtStr("self_nickname", (String)localObject2);
            localArrayList.add(localChatMessage);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<ChatMessage> a(MiniChatAdapter paramMiniChatAdapter)
  {
    Object localObject = a().getStringArrayListExtra("FAV_PATH_OR_ID");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localArrayList1.add(new MessageForPic());
      MessageForPic localMessageForPic = new MessageForPic();
      localMessageForPic.issend = 1;
      localMessageForPic.path = str;
      localMessageForPic.fakeSenderType = 1;
      localMessageForPic.msgtype = -7008;
      localArrayList2.add(localMessageForPic);
    }
    paramMiniChatAdapter.b(localArrayList2);
    return localArrayList1;
  }
  
  private ArrayList<ChatMessage> a(ArrayList<ChatMessage> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject1 = (ChatMessage)paramArrayList.get(i);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("generateFakeSeperateMsg  ");
        ((StringBuilder)localObject2).append(((ChatMessage)localObject1).msgtype);
        QLog.i("MiniMultiForwardPreviewFragment", 2, ((StringBuilder)localObject2).toString());
        Object localObject3;
        if (!a((ChatMessage)localObject1))
        {
          localObject1 = a((ChatMessage)localObject1);
        }
        else if (((ChatMessage)localObject1).msgtype == -1049)
        {
          localObject2 = (MessageForReplyText)localObject1;
          localObject1 = ((ChatMessage)localObject1).msg;
          localObject3 = new ChatActivityFacade.SendMsgParams();
          ((ChatActivityFacade.SendMsgParams)localObject3).g = true;
          ((ChatActivityFacade.SendMsgParams)localObject3).j = true;
          ((ChatActivityFacade.SendMsgParams)localObject3).a = new MessageForReplyText.SourceMsgInfo(((MessageForReplyText)localObject2).mSourceMsgInfo);
          ((ChatActivityFacade.SendMsgParams)localObject3).a.mSourceMsgTroopName = null;
          localObject1 = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, null, (ChatActivityFacade.SendMsgParams)localObject3);
          ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject2).getSourceMessage());
        }
        else
        {
          localObject2 = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
          localObject1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject1, (String)localObject2, false);
          ((ChatMessage)localObject1).setStatus(1000);
          ((ChatMessage)localObject1).msgData = ((ChatMessage)localObject1).msg.getBytes();
        }
        if (localObject1 != null)
        {
          ((ChatMessage)localObject1).fakeSenderType = 1;
          ((ChatMessage)localObject1).saveExtInfoToExtStr("self_nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
          if ((((ChatMessage)localObject1).msgtype == -1000) || (((ChatMessage)localObject1).msgtype == -1049))
          {
            localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
            if (localObject2 != null)
            {
              localObject3 = (IFontManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFontManagerService.class, "");
              ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_id", String.valueOf(FontManagerConstants.generateFontValue((ExtensionInfo)localObject2)));
              ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(((IFontManagerService)localObject3).getVariedStyleIndex(((ExtensionInfo)localObject2).uVipFont)));
              if (1 == ((ExtensionInfo)localObject2).magicFont) {
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
              } else {
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(((ExtensionInfo)localObject2).fontEffect));
              }
            }
          }
          localObject2 = (ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
          ((ChatMessage)localObject1).vipBubbleID = ((ISVIPHandler)localObject2).b();
          ((ChatMessage)localObject1).vipBubbleDiyTextId = ((ISVIPHandler)localObject2).e();
          ((ISVIPHandler)localObject2).a((MessageRecord)localObject1);
          if (AnonymousChatHelper.a((MessageRecord)localObject1)) {
            ((ChatMessage)localObject1).extLong &= 0xFFFFFFFC;
          }
          localArrayList.add(localObject1);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    Intent localIntent = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localIntent.getStringExtra("uinname");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850373);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165321);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("multi_forward_type", 0);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("structmsg_uniseq", 0L);
  }
  
  private void a(ArrayList<ChatMessage> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject2 = (ChatMessage)paramArrayList.get(0);
      int i = ((ChatMessage)localObject2).istroop;
      String str1 = "";
      Object localObject1;
      if ((i != 1) && (((ChatMessage)localObject2).istroop != 3000))
      {
        localObject1 = str1;
        if (((ChatMessage)localObject2).istroop == 0)
        {
          localObject1 = ((ChatMessage)localObject2).senderuin;
          String str2 = ((ChatMessage)localObject2).getExtInfoFromExtStr("self_nickname");
          i = 0;
          while (i < paramArrayList.size())
          {
            ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(i);
            if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = localChatMessage.senderuin;
            }
            else
            {
              localObject2 = localObject1;
              if (!android.text.TextUtils.equals((CharSequence)localObject1, localChatMessage.senderuin))
              {
                str1 = localChatMessage.senderuin;
                paramArrayList = localChatMessage.getExtInfoFromExtStr("self_nickname");
                bool = false;
                break label174;
              }
            }
            i += 1;
            localObject1 = localObject2;
          }
          paramArrayList = "";
          boolean bool = true;
          label174:
          if (str2 != null)
          {
            localObject2 = str2;
            if (str2.trim().length() != 0) {}
          }
          else
          {
            localObject2 = MultiMsgUtil.a((String)localObject1);
          }
          if (paramArrayList != null)
          {
            localObject1 = paramArrayList;
            if (paramArrayList.trim().length() != 0) {}
          }
          else
          {
            localObject1 = paramArrayList;
            if (!bool) {
              localObject1 = MultiMsgUtil.a(str1);
            }
          }
          paramArrayList = new Paint();
          paramArrayList.setTextSize(TypedValue.applyDimension(2, this.b, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
          int j = a(getBaseActivity()).getDefaultDisplay().getWidth() - AIOUtils.b(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          i = j;
          if (j < 300) {
            i = AIOUtils.b(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
          paramArrayList = ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, (String)localObject1, 1, i, 2048, paramArrayList, bool);
          localObject1 = paramArrayList;
          if (android.text.TextUtils.isEmpty(paramArrayList)) {
            localObject1 = HardCodeUtil.a(2131706904);
          }
        }
      }
      else
      {
        localObject1 = HardCodeUtil.a(2131706900);
      }
      ThreadManager.getUIHandler().post(new MiniMultiForwardFragment.2(this, (String)localObject1));
      return;
    }
    QLog.e("MiniMultiForwardPreviewFragment", 2, "SetTitle With emptyMsg");
  }
  
  private void b()
  {
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376750);
    if (localObject != null)
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297115);
      float f = this.c;
      if ((f > 0.0F) && (f <= 1.0F))
      {
        i = (int)(i / f);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
        double d = this.c;
        Double.isNaN(d);
        i = (int)(16.0D / d);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378609);
        if (localObject != null)
        {
          f = i;
          this.b = f;
          ((TextView)localObject).setTextSize(2, f);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
        }
        localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368591);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = ((int)(localLayoutParams.height / this.c));
            localLayoutParams.width = ((int)(localLayoutParams.width / this.c));
            ((ImageView)localObject).setLayoutParams(localLayoutParams);
          }
        }
      }
    }
    localObject = a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378609));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368719));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    localObject = ((Intent)localObject).getStringExtra("multi_forward_title");
    int i = this.jdField_a_of_type_Int;
    if (i == 2)
    {
      if ((localObject != null) && ((((String)localObject).equals(HardCodeUtil.a(2131706903))) || (((String)localObject).equals(HardCodeUtil.a(2131706902)))))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    if ((i != 1) && (i != 4))
    {
      if (i == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131706901));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371046));
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168)));
    localView.setId(2131362422);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    new View(this.jdField_a_of_type_AndroidContentContext).setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics())));
    localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558901, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter = new MiniChatAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.a(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniMultiForwardPreviewFragment", 2, "loadFirstData");
    }
    ThreadManager.excute(new MiniMultiForwardFragment.1(this), 16, null, true);
  }
  
  public ChatMessage a(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = (ChatMessage)paramChatMessage.deepCopyByReflect();
    if (localChatMessage != null)
    {
      if ((localChatMessage instanceof MessageForArkApp)) {
        ((MessageForArkApp)localChatMessage).arkContainer = null;
      }
      if ((localChatMessage instanceof MessageForArkFlashChat)) {
        ((MessageForArkFlashChat)localChatMessage).arkContainer = null;
      }
      Object localObject1;
      Object localObject2;
      if ((localChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject1 = (MessageForArkBabyqReply)localChatMessage;
        if ((((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList != null) && (((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.size() > 0))
        {
          localObject1 = ((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ArkBabyqCardInfo)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((ArkBabyqCardInfo)localObject2).mArkBabyqContainer = null;
            }
          }
        }
      }
      if (((localChatMessage instanceof MessageForReplyText)) && ((paramChatMessage instanceof MessageForReplyText)))
      {
        localObject1 = (MessageForReplyText)localChatMessage;
        localObject2 = (MessageForReplyText)paramChatMessage;
        if ((((MessageForReplyText)localObject1).mSourceMsgInfo != null) && (((MessageForReplyText)localObject2).mSourceMsgInfo != null))
        {
          ((MessageForReplyText)localObject1).mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(((MessageForReplyText)localObject2).mSourceMsgInfo);
          ((MessageForReplyText)localObject1).mSourceMsgInfo.mSourceMsgTroopName = null;
        }
        ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject2).getSourceMessage());
      }
      if (((paramChatMessage instanceof MessageForMixedMsg)) && ((localChatMessage instanceof MessageForMixedMsg)))
      {
        localObject1 = (MessageForMixedMsg)paramChatMessage;
        paramChatMessage = (MessageForMixedMsg)localChatMessage;
        if ((((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) && (paramChatMessage.getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null))
        {
          localObject1 = (MessageForReplyText)a(((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          if (((MessageForReplyText)localObject1).getSourceMessage() != null) {
            paramChatMessage.getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).setSourceMessageRecord(((MessageForReplyText)localObject1).getSourceMessage());
          }
        }
      }
    }
    return localChatMessage;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.msgtype != -1000) && (paramChatMessage.msgtype != -2000) && (paramChatMessage.msgtype != -2011) && (paramChatMessage.msgtype != -5008) && (paramChatMessage.msgtype != -5017) && (paramChatMessage.msgtype != -5016) && (paramChatMessage.msgtype != -5013) && (paramChatMessage.msgtype != -1035) && (paramChatMessage.msgtype != -1036) && (paramChatMessage.msgtype != -2022) && (!(paramChatMessage instanceof MessageForFile)) && (!(paramChatMessage instanceof MessageForTroopFile));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Display localDisplay = a(getBaseActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = localDisplay.getWidth();
    float f4 = this.c;
    f3 = (f1 - f3 * (1.0F - f4) / 2.0F) / f4;
    f4 = localDisplay.getHeight();
    float f5 = this.c;
    paramMotionEvent.offsetLocation(f3 - f1, (f2 - f4 * (1.0F - f5) / 2.0F) / f5 - f2);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    a(paramActivity).setFormat(-2);
    Object localObject = a(paramActivity).getAttributes();
    Display localDisplay = a(paramActivity).getDefaultDisplay();
    this.jdField_a_of_type_Float = a(paramActivity).getFloatExtra("minaio_height_ration", 0.6F);
    ((WindowManager.LayoutParams)localObject).height = ((int)(localDisplay.getHeight() * this.jdField_a_of_type_Float));
    a(paramActivity).setAttributes((WindowManager.LayoutParams)localObject);
    localObject = a(paramActivity).getDecorView();
    if (MiniPieHelper.a())
    {
      this.c = a(paramActivity).getFloatExtra("minaio_scaled_ration", 0.95F);
      ((View)localObject).setScaleX(this.c);
      ((View)localObject).setScaleY(this.c);
      QLog.i("MiniMultiForwardPreviewFragment", 2, "surport scale ");
      return;
    }
    this.c = 1.0F;
    QLog.i("MiniMultiForwardPreviewFragment", 2, "not surport scale ");
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    getBaseActivity().finish();
    getBaseActivity().overridePendingTransition(0, 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368719) {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      paramLayoutInflater = null;
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131559414, paramViewGroup, false);
      if (paramLayoutInflater == null) {
        getBaseActivity().finish();
      }
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131362288));
      a();
      b();
      c();
      d();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    QQLiveImage.releaseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.c();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    AbstractGifImage.pauseAll();
    BaseChatItemLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ArkAioContainerWrapper.a(0);
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    AbstractVideoImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    QQLiveImage.onForeground((Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Boolean = BaseChatItemLayout.jdField_a_of_type_Boolean;
    BaseChatItemLayout.jdField_a_of_type_Boolean = false;
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
  }
  
  public void onStart()
  {
    super.onStart();
    QQLiveImage.onForeground((Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onStop()
  {
    super.onStop();
    QQLiveImage.onForeground((Activity)this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment
 * JD-Core Version:    0.7.0.1
 */