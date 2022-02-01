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
import com.tencent.mobileqq.data.MessageForAniSticker;
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
  float a = 0.86F;
  Context b;
  QQAppInterface c;
  ChatXListView d;
  MiniChatAdapter e;
  RelativeLayout f;
  TextView g;
  ViewGroup h;
  float i = 16.0F;
  public boolean j = false;
  private float k = 0.78F;
  private int l = 0;
  private long m;
  private SessionInfo n = new SessionInfo();
  
  private Window a(Activity paramActivity)
  {
    return paramActivity.getWindow();
  }
  
  private ArrayList<ChatMessage> a(MiniChatAdapter paramMiniChatAdapter)
  {
    Object localObject = d().getStringArrayListExtra("FAV_PATH_OR_ID");
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
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        Object localObject1 = (ChatMessage)paramArrayList.get(i1);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("generateFakeSeperateMsg  ");
        ((StringBuilder)localObject2).append(((ChatMessage)localObject1).msgtype);
        QLog.i("MiniMultiForwardPreviewFragment", 2, ((StringBuilder)localObject2).toString());
        Object localObject3;
        if (!b((ChatMessage)localObject1))
        {
          localObject1 = a((ChatMessage)localObject1);
        }
        else if (((ChatMessage)localObject1).msgtype == -1049)
        {
          localObject2 = (MessageForReplyText)localObject1;
          localObject1 = ((ChatMessage)localObject1).msg;
          localObject3 = new ChatActivityFacade.SendMsgParams();
          ((ChatActivityFacade.SendMsgParams)localObject3).w = true;
          ((ChatActivityFacade.SendMsgParams)localObject3).A = true;
          ((ChatActivityFacade.SendMsgParams)localObject3).h = new MessageForReplyText.SourceMsgInfo(((MessageForReplyText)localObject2).mSourceMsgInfo);
          ((ChatActivityFacade.SendMsgParams)localObject3).h.mSourceMsgTroopName = null;
          localObject1 = ChatActivityFacade.a(this.c, this.n, (String)localObject1, null, (ChatActivityFacade.SendMsgParams)localObject3);
          ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject2).getSourceMessage());
        }
        else
        {
          localObject2 = MultiMsgUtil.a(this.c, (MessageRecord)localObject1);
          localObject1 = (ChatMessage)this.c.getMultiMessageProxy().a((MessageRecord)localObject1, (String)localObject2, false);
          ((ChatMessage)localObject1).setStatus(1000);
          ((ChatMessage)localObject1).msgData = ((ChatMessage)localObject1).msg.getBytes();
        }
        if (localObject1 != null)
        {
          ((ChatMessage)localObject1).fakeSenderType = 1;
          ((ChatMessage)localObject1).saveExtInfoToExtStr("self_nickname", this.c.getCurrentNickname());
          if ((((ChatMessage)localObject1).msgtype == -1000) || (((ChatMessage)localObject1).msgtype == -1049))
          {
            localObject2 = ((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.c.getCurrentUin(), false);
            if (localObject2 != null)
            {
              localObject3 = (IFontManagerService)this.c.getRuntimeService(IFontManagerService.class, "");
              ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_id", String.valueOf(FontManagerConstants.generateFontValue((ExtensionInfo)localObject2)));
              ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(((IFontManagerService)localObject3).getVariedStyleIndex(((ExtensionInfo)localObject2).uVipFont)));
              if (1 == ((ExtensionInfo)localObject2).magicFont) {
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
              } else {
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(((ExtensionInfo)localObject2).fontEffect));
              }
            }
          }
          localObject2 = (ISVIPHandler)this.c.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
          ((ChatMessage)localObject1).vipBubbleID = ((ISVIPHandler)localObject2).d();
          ((ChatMessage)localObject1).vipBubbleDiyTextId = ((ISVIPHandler)localObject2).g();
          ((ISVIPHandler)localObject2).a((MessageRecord)localObject1);
          if (AnonymousChatHelper.c((MessageRecord)localObject1)) {
            ((ChatMessage)localObject1).extLong &= 0xFFFFFFFC;
          }
          localArrayList.add(localObject1);
        }
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    Intent localIntent = d();
    this.n.b = localIntent.getStringExtra("uin");
    this.n.a = localIntent.getIntExtra("uintype", -1);
    this.n.e = localIntent.getStringExtra("uinname");
    this.n.H = new ChatBackground();
    this.n.H.c = this.b.getResources().getDrawable(2130852164);
    this.n.H.b = this.b.getResources().getColorStateList(2131165558);
    this.n.r = ChatTextSizeSettingActivity.a(this.b);
    this.l = localIntent.getIntExtra("multi_forward_type", 0);
    this.m = localIntent.getLongExtra("structmsg_uniseq", 0L);
  }
  
  private Intent b(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private void b()
  {
    Object localObject = (RelativeLayout)this.h.findViewById(2131445041);
    if (localObject != null)
    {
      i1 = this.b.getResources().getDimensionPixelSize(2131297496);
      float f1 = this.k;
      if ((f1 > 0.0F) && (f1 <= 1.0F))
      {
        i1 = (int)(i1 / f1);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i1;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
        double d1 = this.k;
        Double.isNaN(d1);
        i1 = (int)(16.0D / d1);
        localObject = (TextView)this.h.findViewById(2131447238);
        if (localObject != null)
        {
          f1 = i1;
          this.i = f1;
          ((TextView)localObject).setTextSize(2, f1);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
        }
        localObject = (ImageView)this.h.findViewById(2131435503);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = ((int)(localLayoutParams.height / this.k));
            localLayoutParams.width = ((int)(localLayoutParams.width / this.k));
            ((ImageView)localObject).setLayoutParams(localLayoutParams);
          }
        }
      }
    }
    localObject = d();
    this.g = ((TextView)this.h.findViewById(2131447238));
    this.f = ((RelativeLayout)this.h.findViewById(2131435632));
    this.f.setOnClickListener(this);
    localObject = ((Intent)localObject).getStringExtra("multi_forward_title");
    int i1 = this.l;
    if (i1 == 2)
    {
      if ((localObject != null) && ((((String)localObject).equals(HardCodeUtil.a(2131904748))) || (((String)localObject).equals(HardCodeUtil.a(2131904747)))))
      {
        this.g.setText((CharSequence)localObject);
        return;
      }
      this.g.setText("");
      return;
    }
    if ((i1 != 1) && (i1 != 4))
    {
      if (i1 == 3)
      {
        this.g.setText((CharSequence)localObject);
        return;
      }
      this.g.setText("");
      return;
    }
    this.g.setText(HardCodeUtil.a(2131904746));
  }
  
  private void b(ArrayList<ChatMessage> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject2 = (ChatMessage)paramArrayList.get(0);
      int i1 = ((ChatMessage)localObject2).istroop;
      String str1 = "";
      Object localObject1;
      if ((i1 != 1) && (((ChatMessage)localObject2).istroop != 3000))
      {
        localObject1 = str1;
        if (((ChatMessage)localObject2).istroop == 0)
        {
          localObject1 = ((ChatMessage)localObject2).senderuin;
          String str2 = ((ChatMessage)localObject2).getExtInfoFromExtStr("self_nickname");
          i1 = 0;
          while (i1 < paramArrayList.size())
          {
            ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(i1);
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
                break label176;
              }
            }
            i1 += 1;
            localObject1 = localObject2;
          }
          paramArrayList = "";
          boolean bool = true;
          label176:
          if (str2 != null)
          {
            localObject2 = str2;
            if (str2.trim().length() != 0) {}
          }
          else
          {
            localObject2 = MultiMsgUtil.b((String)localObject1);
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
              localObject1 = MultiMsgUtil.b(str1);
            }
          }
          paramArrayList = new Paint();
          paramArrayList.setTextSize(TypedValue.applyDimension(2, this.i, this.b.getResources().getDisplayMetrics()));
          int i2 = c(getBaseActivity()).getDefaultDisplay().getWidth() - AIOUtils.b(80.0F, this.b.getResources());
          i1 = i2;
          if (i2 < 300) {
            i1 = AIOUtils.b(150.0F, this.b.getResources());
          }
          paramArrayList = ChatActivityFacade.a(this.b, (String)localObject2, (String)localObject1, 1, i1, 2048, paramArrayList, bool);
          localObject1 = paramArrayList;
          if (android.text.TextUtils.isEmpty(paramArrayList)) {
            localObject1 = HardCodeUtil.a(2131904749);
          }
        }
      }
      else
      {
        localObject1 = HardCodeUtil.a(2131904745);
      }
      ThreadManager.getUIHandler().post(new MiniMultiForwardFragment.2(this, (String)localObject1));
      return;
    }
    QLog.e("MiniMultiForwardPreviewFragment", 2, "SetTitle With emptyMsg");
  }
  
  private WindowManager c(Activity paramActivity)
  {
    return paramActivity.getWindowManager();
  }
  
  private void c()
  {
    this.d = ((ChatXListView)this.h.findViewById(2131438387));
    View localView = new View(this.b);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, this.b.getResources().getDimensionPixelSize(2131299920)));
    localView.setId(2131428030);
    this.d.setStackFromBottom(false);
    this.d.setTranscriptMode(0);
    new View(this.b).setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.b.getResources().getDisplayMetrics())));
    localView = LayoutInflater.from(this.b).inflate(2131624523, null);
    this.d.setOverScrollHeader(localView);
    this.e = new MiniChatAdapter(this.c, this.b, this.n);
    this.e.a(true);
    this.d.setAdapter(this.e);
  }
  
  private Intent d()
  {
    return getBaseActivity().getIntent();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniMultiForwardPreviewFragment", 2, "loadFirstData");
    }
    ThreadManager.excute(new MiniMultiForwardFragment.1(this), 16, null, true);
  }
  
  private ArrayList<ChatMessage> f()
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = this.m;
    int i2 = 0;
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (l1 != 0L)
    {
      localObject1 = MultiMsgManager.a().a(this.c, this.m);
      if (localObject1 != null) {
        while (i1 < ((List)localObject1).size())
        {
          localObject2 = (ChatMessage)((List)localObject1).get(i1);
          localObject3 = a((ChatMessage)localObject2);
          if (localObject3 != null)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("generateFakeCombineMsg s:");
            ((StringBuilder)localObject4).append(this.m);
            ((StringBuilder)localObject4).append(" : ");
            ((StringBuilder)localObject4).append(((ChatMessage)localObject2).msgtype);
            QLog.i("MiniMultiForwardPreviewFragment", 2, ((StringBuilder)localObject4).toString());
            ((ChatMessage)localObject3).fakeSenderType = 2;
            localArrayList.add(localObject3);
          }
          i1 += 1;
        }
      }
    }
    else
    {
      localObject3 = MultiMsgManager.a().c;
      localObject4 = MultiMsgManager.a().d;
      if (localObject3 != null)
      {
        i1 = i2;
        while (i1 < ((List)localObject3).size())
        {
          localObject1 = (ChatMessage)((List)localObject3).get(i1);
          ChatMessage localChatMessage = a((ChatMessage)localObject1);
          if (localChatMessage != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("generateFakeCombineMsg   ");
            ((StringBuilder)localObject2).append(((ChatMessage)localObject1).msgtype);
            QLog.i("MiniMultiForwardPreviewFragment", 2, ((StringBuilder)localObject2).toString());
            localChatMessage.fakeSenderType = 2;
            if (localObject4 != null) {
              localObject1 = (String)((HashMap)localObject4).get(MsgProxyUtils.d(localChatMessage));
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
          i1 += 1;
        }
      }
    }
    return localArrayList;
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
        if ((((MessageForMixedMsg)localObject1).getReplyMessage(this.c) != null) && (paramChatMessage.getReplyMessage(this.c) != null))
        {
          localObject1 = (MessageForReplyText)a(((MessageForMixedMsg)localObject1).getReplyMessage(this.c));
          if (((MessageForReplyText)localObject1).getSourceMessage() != null) {
            paramChatMessage.getReplyMessage(this.c).setSourceMessageRecord(((MessageForReplyText)localObject1).getSourceMessage());
          }
        }
      }
    }
    return localChatMessage;
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.msgtype != -1000) && (paramChatMessage.msgtype != -2000) && (paramChatMessage.msgtype != -2011) && (paramChatMessage.msgtype != -5008) && (paramChatMessage.msgtype != -5017) && (paramChatMessage.msgtype != -5016) && (paramChatMessage.msgtype != -5013) && (paramChatMessage.msgtype != -1035) && (paramChatMessage.msgtype != -1036) && (paramChatMessage.msgtype != -2022) && (!(paramChatMessage instanceof MessageForAniSticker)) && (!(paramChatMessage instanceof MessageForFile)) && (!(paramChatMessage instanceof MessageForTroopFile));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Display localDisplay = c(getBaseActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = localDisplay.getWidth();
    float f4 = this.k;
    f3 = (f1 - f3 * (1.0F - f4) / 2.0F) / f4;
    f4 = localDisplay.getHeight();
    float f5 = this.k;
    paramMotionEvent.offsetLocation(f3 - f1, (f2 - f4 * (1.0F - f5) / 2.0F) / f5 - f2);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    a(paramActivity).setFormat(-2);
    Object localObject = a(paramActivity).getAttributes();
    Display localDisplay = c(paramActivity).getDefaultDisplay();
    this.a = b(paramActivity).getFloatExtra("minaio_height_ration", 0.6F);
    ((WindowManager.LayoutParams)localObject).height = ((int)(localDisplay.getHeight() * this.a));
    a(paramActivity).setAttributes((WindowManager.LayoutParams)localObject);
    localObject = a(paramActivity).getDecorView();
    if (MiniPieHelper.e())
    {
      this.k = b(paramActivity).getFloatExtra("minaio_scaled_ration", 0.95F);
      ((View)localObject).setScaleX(this.k);
      ((View)localObject).setScaleY(this.k);
      QLog.i("MiniMultiForwardPreviewFragment", 2, "surport scale ");
      return;
    }
    this.k = 1.0F;
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
    if (paramView.getId() == 2131435632) {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getBaseActivity();
    this.c = getBaseActivity().app;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.c == null)
    {
      paramLayoutInflater = null;
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131625380, paramViewGroup, false);
      if (paramLayoutInflater == null) {
        getBaseActivity().finish();
      }
      this.h = ((ViewGroup)paramLayoutInflater.findViewById(2131427887));
      a();
      b();
      c();
      e();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((MediaPlayerManager)this.c.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.d);
    QQLiveImage.releaseAll((Activity)this.b);
    this.e.d();
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
    QQLiveImage.pauseAll((Activity)this.b);
    AbstractGifImage.pauseAll();
    BaseChatItemLayout.ad = this.j;
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
    QQLiveImage.resumeAll((Activity)this.b);
    QQLiveImage.onForeground((Activity)this.b);
    this.j = BaseChatItemLayout.ad;
    BaseChatItemLayout.ad = false;
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
    QQLiveImage.onForeground((Activity)this.b);
  }
  
  public void onStop()
  {
    super.onStop();
    QQLiveImage.onForeground((Activity)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment
 * JD-Core Version:    0.7.0.1
 */