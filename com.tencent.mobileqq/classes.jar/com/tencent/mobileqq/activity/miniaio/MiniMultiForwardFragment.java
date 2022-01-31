package com.tencent.mobileqq.activity.miniaio;

import aanz;
import aaog;
import actj;
import acur;
import adli;
import agfw;
import aghk;
import ajxl;
import ajya;
import akfv;
import akpx;
import akqa;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
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
import asua;
import asuh;
import aylc;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import ho;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import myb;

public class MiniMultiForwardFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  float jdField_a_of_type_Float = 0.86F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  agfw jdField_a_of_type_Agfw;
  Context jdField_a_of_type_AndroidContentContext;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  public boolean a;
  float b = 16.0F;
  private float c = 0.78F;
  
  private Intent a()
  {
    return getActivity().getIntent();
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
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_Long != 0L)
    {
      localObject1 = asua.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      if (localObject1 != null)
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (ChatMessage)((List)localObject1).get(i);
          localObject3 = a((ChatMessage)localObject2);
          if (localObject3 != null)
          {
            QLog.i("MiniMultiForwardPreviewFragment", 2, "generateFakeCombineMsg s:" + this.jdField_a_of_type_Long + " : " + ((ChatMessage)localObject2).msgtype);
            ((ChatMessage)localObject3).fakeSenderType = 2;
            localArrayList.add(localObject3);
          }
          i += 1;
        }
      }
    }
    else
    {
      localObject3 = asua.a().a;
      HashMap localHashMap = asua.a().b;
      if (localObject3 != null)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject1 = (ChatMessage)((List)localObject3).get(i);
          ChatMessage localChatMessage = a((ChatMessage)localObject1);
          if (localChatMessage != null)
          {
            QLog.i("MiniMultiForwardPreviewFragment", 2, "generateFakeCombineMsg   " + ((ChatMessage)localObject1).msgtype);
            localChatMessage.fakeSenderType = 2;
            localObject1 = "";
            if (localHashMap != null) {
              localObject1 = (String)localHashMap.get(akpx.c(localChatMessage));
            }
            localObject2 = localObject1;
            if (localChatMessage.istroop == 1)
            {
              localObject2 = localObject1;
              if (localObject1 != null) {
                localObject2 = aylc.h((String)localObject1);
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
  
  private ArrayList<ChatMessage> a(ArrayList<ChatMessage> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      int i = 0;
      if (i < paramArrayList.size())
      {
        Object localObject1 = (ChatMessage)paramArrayList.get(i);
        QLog.i("MiniMultiForwardPreviewFragment", 2, "generateFakeSeperateMsg  " + ((ChatMessage)localObject1).msgtype);
        label74:
        Object localObject2;
        if (!a((ChatMessage)localObject1))
        {
          localObject1 = a((ChatMessage)localObject1);
          if (localObject1 != null)
          {
            ((ChatMessage)localObject1).fakeSenderType = 1;
            ((ChatMessage)localObject1).saveExtInfoToExtStr("self_nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
            if ((((ChatMessage)localObject1).msgtype == -1000) || (((ChatMessage)localObject1).msgtype == -1049))
            {
              localObject2 = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
              if (localObject2 != null)
              {
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_id", String.valueOf(ho.a((ExtensionInfo)localObject2)));
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(ho.c(((ExtensionInfo)localObject2).uVipFont)));
                if (1 != ((ExtensionInfo)localObject2).magicFont) {
                  break label415;
                }
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = (akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
          ((ChatMessage)localObject1).vipBubbleID = ((akfv)localObject2).b();
          ((ChatMessage)localObject1).vipBubbleDiyTextId = ((akfv)localObject2).e();
          ((akfv)localObject2).a((MessageRecord)localObject1);
          if (myb.a((MessageRecord)localObject1)) {
            ((ChatMessage)localObject1).extLong &= 0xFFFFFFFC;
          }
          localArrayList.add(localObject1);
          i += 1;
          break;
          if (((ChatMessage)localObject1).msgtype == -1049)
          {
            localObject2 = (MessageForReplyText)localObject1;
            localObject1 = ((ChatMessage)localObject1).msg;
            aaog localaaog = new aaog();
            localaaog.g = true;
            localaaog.j = true;
            localaaog.a = new MessageForReplyText.SourceMsgInfo(((MessageForReplyText)localObject2).mSourceMsgInfo);
            localaaog.a.mSourceMsgTroopName = null;
            localObject1 = aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, null, localaaog);
            ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject2).getSourceMessage());
            break label74;
          }
          localObject2 = asuh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
          localObject1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, (String)localObject2, false);
          ((ChatMessage)localObject1).setStatus(1000);
          ((ChatMessage)localObject1).msgData = ((ChatMessage)localObject1).msg.getBytes();
          break label74;
          label415:
          ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(((ExtensionInfo)localObject2).fontEffect));
        }
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur = new acur();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848971);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur.jdField_a_of_type_AndroidContentResColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165272);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("multi_forward_type", 0);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("structmsg_uniseq", 0L);
  }
  
  private void a(ArrayList<ChatMessage> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("MiniMultiForwardPreviewFragment", 2, "SetTitle With emptyMsg");
      return;
    }
    Object localObject2 = (ChatMessage)paramArrayList.get(0);
    if ((((ChatMessage)localObject2).istroop == 1) || (((ChatMessage)localObject2).istroop == 3000)) {
      paramArrayList = ajya.a(2131706875);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new MiniMultiForwardFragment.2(this, paramArrayList));
      return;
      if (((ChatMessage)localObject2).istroop == 0)
      {
        Object localObject1 = ((ChatMessage)localObject2).senderuin;
        Object localObject3 = ((ChatMessage)localObject2).getExtInfoFromExtStr("self_nickname");
        int i = 0;
        if (i < paramArrayList.size())
        {
          ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localChatMessage.senderuin;
          }
          do
          {
            i += 1;
            localObject1 = localObject2;
            break;
            localObject2 = localObject1;
          } while (TextUtils.equals((CharSequence)localObject1, localChatMessage.senderuin));
          localObject2 = localChatMessage.senderuin;
          paramArrayList = localChatMessage.getExtInfoFromExtStr("self_nickname");
        }
        for (boolean bool = false;; bool = true)
        {
          if ((localObject3 == null) || (((String)localObject3).trim().length() == 0)) {}
          for (localObject1 = asuh.a((String)localObject1);; localObject1 = localObject3)
          {
            if (paramArrayList != null)
            {
              localObject3 = paramArrayList;
              if (paramArrayList.trim().length() != 0) {}
            }
            else
            {
              localObject3 = paramArrayList;
              if (!bool) {
                localObject3 = asuh.a((String)localObject2);
              }
            }
            paramArrayList = new Paint();
            paramArrayList.setTextSize(TypedValue.applyDimension(2, this.b, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
            int j = a(getActivity()).getDefaultDisplay().getWidth() - actj.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            i = j;
            if (j < 300) {
              i = actj.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            }
            localObject1 = aanz.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject3, 1, i, 2048, paramArrayList, bool);
            paramArrayList = (ArrayList<ChatMessage>)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            paramArrayList = ajya.a(2131706879);
            break;
          }
          paramArrayList = "";
          localObject2 = "";
        }
      }
      paramArrayList = "";
    }
  }
  
  private void b()
  {
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375445);
    if (localObject != null)
    {
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296975);
      if ((this.c > 0.0F) && (this.c <= 1.0F))
      {
        i = (int)(i / this.c);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
        i = (int)(16.0D / this.c);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377185);
        if (localObject != null)
        {
          this.b = i;
          ((TextView)localObject).setTextSize(2, i);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
        }
        localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367906);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377185));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368032));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    localObject = ((Intent)localObject).getStringExtra("multi_forward_title");
    if (this.jdField_a_of_type_Int == 2)
    {
      if ((localObject != null) && ((((String)localObject).equals(ajya.a(2131706878))) || (((String)localObject).equals(ajya.a(2131706877)))))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131706876));
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370166));
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865)));
    localView.setId(2131362314);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    new View(this.jdField_a_of_type_AndroidContentContext).setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics())));
    localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558825, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_Agfw = new agfw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Agfw.a(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Agfw);
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
    Display localDisplay = a(getActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent.offsetLocation((f1 - localDisplay.getWidth() * (1.0F - this.c) / 2.0F) / this.c - f1, (f2 - localDisplay.getHeight() * (1.0F - this.c) / 2.0F) / this.c - f2);
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
    if (aghk.a())
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
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131559284, paramViewGroup, false);
    if (paramLayoutInflater == null) {
      getActivity().finish();
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131362188));
    a();
    b();
    c();
    d();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    QQLiveImage.releaseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Agfw.c();
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
    adli.a(0);
    adli.a(0);
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
    com.etrump.mixlayout.ETTextView.enableAnimation = true;
    adli.a(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment
 * JD-Core Version:    0.7.0.1
 */