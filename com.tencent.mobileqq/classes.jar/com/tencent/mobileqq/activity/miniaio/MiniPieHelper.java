package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.comment.DanmuUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.AniStickerSendMessageCallBack;
import com.tencent.mobileqq.emoticonview.AniStickerSendMessageCallBack.AniStickerTextParseResult;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class MiniPieHelper
  implements ILifeCycleHelper
{
  public static String a = "MiniPie.MiniPieHelper";
  boolean b = false;
  int c = 0;
  int d = 0;
  private QQAppInterface e;
  private Context f;
  private MiniPie g;
  private SessionInfo h;
  private MessageObserver i = new MiniPieHelper.1(this);
  
  public MiniPieHelper(MiniPie paramMiniPie)
  {
    this.e = paramMiniPie.d;
    this.f = paramMiniPie.b;
    this.g = paramMiniPie;
    this.h = paramMiniPie.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniPie.a);
    localStringBuilder.append(".Helper");
    a = localStringBuilder.toString();
  }
  
  static int b(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "doNewRefreshForAio");
    }
    int k;
    int j;
    if (paramChatXListView.getLastVisiblePosition() >= 0)
    {
      paramList1 = paramChatXListView.getChildAt(paramChatXListView.getChildCount() - 1);
      if (paramList1 != null) {
        paramInt = paramList1.getBottom();
      } else {
        paramInt = 0;
      }
      int m = paramChatXListView.getHeight();
      k = m;
      j = paramInt;
      if (QLog.isColorLevel())
      {
        paramChatXListView = a;
        paramList1 = new StringBuilder();
        paramList1.append("refreshlistadapter=====lastbuttom=");
        paramList1.append(paramInt);
        paramList1.append(" listHeight=");
        paramList1.append(m);
        QLog.d(paramChatXListView, 2, paramList1.toString());
        k = m;
        j = paramInt;
      }
    }
    else
    {
      k = 0;
      j = 0;
    }
    if (j <= k) {
      return 3;
    }
    return 0;
  }
  
  static boolean e()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  int a(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "keepPostionScroll");
    }
    return Scroller.a(a, paramChatXListView, paramInt, paramList1, paramList2);
  }
  
  int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "doDefaultSrollPosition");
    }
    int j = paramInt;
    if (paramList1 != paramList2)
    {
      int n = paramList1.size();
      int k = paramList2.size();
      if ((n > 0) && (k > 0))
      {
        long l = ((ChatMessage)paramList1.get(n - 1)).uniseq;
        int m = k - 1;
        j = m;
        while ((j >= 0) && ((j != m) || (!UniteGrayTipMsgUtil.b((MessageRecord)paramList2.get(j)))))
        {
          if (((ChatMessage)paramList2.get(j)).uniseq == l) {
            break label144;
          }
          j -= 1;
        }
      }
      j = -1;
      label144:
      if (j >= 0) {
        return k - (n - paramInt + k - 1 - j);
      }
      j = paramInt;
      if (k > 0)
      {
        j = paramInt;
        if (!UniteGrayTipMsgUtil.b((MessageRecord)paramList2.get(k - 1))) {
          j = k;
        }
      }
    }
    return j;
  }
  
  public void a()
  {
    if (this.g.c()) {
      MiniChatMsgProxy.a().a(this.h.a, this.h.b, this.g);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.g.i;
    int j = ((ChatXListView)localObject).getFooterViewsCount();
    int m = ((ChatXListView)localObject).getHeaderViewsCount();
    int k = paramInt3 - m - j;
    paramInt3 = k - (paramInt1 - m) - paramInt2;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" listSize =");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" chatPie.mReadedCnt =");
      ((StringBuilder)localObject).append(this.g.I);
      QLog.d("MiniPie.onScroll", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g.I < k)
    {
      paramInt2 = paramInt1 + paramInt2 - j - m;
      paramInt1 = paramInt2;
      if (paramInt2 >= k) {
        paramInt1 = k - 1;
      }
      if (paramInt1 >= this.g.I) {
        this.g.I = (paramInt1 + j);
      }
      if (paramInt3 == 0) {
        this.g.I = k;
      }
      paramInt1 = k - this.g.I;
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramInt1 != this.g.J)
    {
      if (this.g.e.hasMessages(5)) {
        this.g.e.removeMessages(5);
      }
      localObject = this.g.e;
      Message localMessage = this.g.e.obtainMessage(5, paramInt1, paramInt3);
      long l;
      if (this.g.K.booleanValue()) {
        l = 1500L;
      } else {
        l = 0L;
      }
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l);
      this.g.K = Boolean.valueOf(false);
      this.g.J = paramInt1;
    }
  }
  
  protected void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    paramSendMsgParams.d = this.d;
    paramSendMsgParams.c = this.c;
    paramSendMsgParams.e = this.b;
    paramSendMsgParams.f = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    paramSendMsgParams.g = System.currentTimeMillis();
    paramSendMsgParams.i = this.g.c.F;
    paramSendMsgParams.j = this.g.c.E;
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.g.U;
    if ((localSourceMsgInfo != null) && (localSourceMsgInfo.mSourceMsgText.length() > BaseChatPie.bh))
    {
      localSourceMsgInfo.mSourceMsgText = localSourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.bh);
      localSourceMsgInfo.mSourceSummaryFlag = 0;
      if (localSourceMsgInfo.mType == -1036) {
        localSourceMsgInfo.oriMsgType = 1;
      }
    }
    paramSendMsgParams.h = localSourceMsgInfo;
  }
  
  public void b()
  {
    if (this.g.c())
    {
      MiniChatMsgProxy.a().b(this.h.a, this.h.b, this.g);
      if ((this.e.getMessageFacade() != null) && (!MiniChatMsgProxy.a().a(this.h.a, this.h.b))) {
        this.e.getMessageFacade().a(this.h.a, this.h.b);
      }
    }
  }
  
  protected void c()
  {
    if (this.g.t.getText() != null) {
      localObject1 = this.g.t.getText().toString();
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    int j = ((String)localObject1).length();
    Object localObject1 = this.g;
    if (j > MiniPie.D)
    {
      ChatActivityUtils.a(this.f, 2131916265, 1);
      return;
    }
    Object localObject5 = this.g.t;
    Object localObject2 = this.g.U;
    if (((XEditTextEx)localObject5).getTag(2131441550) == null) {
      localObject2 = null;
    }
    if (localObject2 != null) {
      localObject1 = ReplyMsgUtils.c(this.e, this.h, (MessageForReplyText.SourceMsgInfo)localObject2);
    } else {
      localObject1 = null;
    }
    Object localObject4 = new ChatActivityFacade.SendMsgParams();
    a((ChatActivityFacade.SendMsgParams)localObject4);
    ((ChatActivityFacade.SendMsgParams)localObject4).k = DanmuUtil.a(this.e, (MessageRecord)localObject1);
    if (((ChatActivityFacade.SendMsgParams)localObject4).i)
    {
      ((ChatActivityFacade.SendMsgParams)localObject4).k = DanmuUtil.a(this.e, (MessageRecord)localObject1);
      if ((((ChatActivityFacade.SendMsgParams)localObject4).k != 1) && (((ChatActivityFacade.SendMsgParams)localObject4).k != 3))
      {
        if ((((ChatActivityFacade.SendMsgParams)localObject4).k == 2) || (((ChatActivityFacade.SendMsgParams)localObject4).k == 4)) {
          ReportController.b(this.e, "dc00898", "", "", "0X800A884", "0X800A884", 0, 0, "", "", "", "");
        }
      }
      else {
        ReportController.b(this.e, "dc00898", "", "", "0X800A883", "0X800A883", 0, 0, "", "", "", "");
      }
    }
    j = this.g.c.a;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    Object localObject3;
    if ((j != 1) && (this.g.c.a != 3000))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new ArrayList();
      localObject2 = AtTroopMemberSpan.a(this.g.t.getEditableText(), (ArrayList)localObject1);
      bool1 = bool2;
      if (this.g.c.a == 0)
      {
        localObject3 = AniStickerSendMessageCallBack.parseMsgForAniSticker((String)localObject2, this.g.c);
        bool1 = bool2;
        if (((AniStickerSendMessageCallBack.AniStickerTextParseResult)localObject3).isAniStickerEnable()) {
          bool1 = AniStickerSendMessageCallBack.sendAniSticker(((AniStickerSendMessageCallBack.AniStickerTextParseResult)localObject3).emoLocalId, this.h);
        }
      }
      if (!bool1) {
        ChatActivityFacade.a(this.g.d, this.f, this.g.c, (String)localObject2, (ArrayList)localObject1, (ChatActivityFacade.SendMsgParams)localObject4);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject3 = a;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(" send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:");
        ((StringBuilder)localObject6).append(System.currentTimeMillis());
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject6).toString());
      }
      localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName))
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = this.g.c.b;
            j = this.g.c.a;
            localObject3 = this.g.d.getMessageFacade().c(this.g.c.b, j, -1L, true);
            j = ((List)localObject3).size() - 1;
            while (j >= 0)
            {
              localObject1 = (ChatMessage)((List)localObject3).get(j);
              if (((ChatMessage)localObject1).shmsgseq == ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq) {
                break label739;
              }
              j -= 1;
            }
            localObject1 = null;
            label739:
            MessageForReplyText.reportReplyMsg(this.e, "suc_replyMsg", "reply_suc", this.h.b, (ChatMessage)localObject1);
            localObject3 = localObject1;
          }
        }
      }
      if (((ChatActivityFacade.SendMsgParams)localObject4).h != null)
      {
        ((ChatActivityFacade.SendMsgParams)localObject4).h.mType = 0;
        if (((localObject3 instanceof MessageForPic)) || ((localObject3 instanceof MessageForMixedMsg))) {
          ((ChatActivityFacade.SendMsgParams)localObject4).h.oriMsgType = 1;
        }
        if (localObject3 != null) {
          ((ChatActivityFacade.SendMsgParams)localObject4).h.packSourceMsg(this.e, (MessageRecord)localObject3);
        }
      }
      Object localObject6 = new ArrayList();
      localObject2 = AtTroopMemberSpan.a(((XEditTextEx)localObject5).getEditableText(), (ArrayList)localObject6);
      localObject1 = this.g.f(true);
      ArrayList localArrayList = new ArrayList();
      localObject5 = AtTroopMemberSpan.a(((XEditTextEx)localObject5).getEditableText(), localArrayList);
      if (this.g.U != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        ReplyMsgSender.a().a(this.e, this.h, (String)localObject2, (ArrayList)localObject6, (ChatActivityFacade.SendMsgParams)localObject4, (MessageRecord)localObject3, (String)localObject5, localArrayList);
        if (((ChatActivityFacade.SendMsgParams)localObject4).i)
        {
          localObject3 = (IDanmuDataIPCServer)QRoute.api(IDanmuDataIPCServer.class);
          long l1 = ((ChatActivityFacade.SendMsgParams)localObject4).g;
          long l2 = ((ChatActivityFacade.SendMsgParams)localObject4).j;
          localObject4 = this.g.c.b;
          long l3 = this.g.U.mSourceMsgSeq;
          if (((ArrayList)localObject6).isEmpty()) {
            localObject1 = null;
          }
          ((IDanmuDataIPCServer)localObject3).notifyDanmuSendResult(l1, l2, (String)localObject2, (String)localObject4, l3, (SpannableString)localObject1);
        }
      }
      else
      {
        bool1 = bool3;
        if (this.g.c.a == 1)
        {
          localObject1 = AniStickerSendMessageCallBack.parseMsgForAniSticker((String)localObject2, this.g.c);
          bool1 = bool3;
          if (((AniStickerSendMessageCallBack.AniStickerTextParseResult)localObject1).isAniStickerEnable()) {
            bool1 = AniStickerSendMessageCallBack.sendAniSticker(((AniStickerSendMessageCallBack.AniStickerTextParseResult)localObject1).emoLocalId, this.h);
          }
        }
        if (!bool1) {
          ChatActivityFacade.a(this.g.d, this.f, this.g.c, (String)localObject2, (ArrayList)localObject6, (ChatActivityFacade.SendMsgParams)localObject4);
        }
      }
    }
    d();
  }
  
  protected void d()
  {
    this.g.t.setText("");
    this.g.t.setCompoundDrawables(null, null, null, null);
    this.g.t.setTag(2131441550, null);
    this.g.t.setSelection(0);
    this.g.u.setEnabled(false);
    if (this.g.c != null) {
      this.g.t.setMinHeight(AIOUtils.b(36.0F, this.g.t.getResources()));
    }
    MiniPie localMiniPie = this.g;
    localMiniPie.U = null;
    localMiniPie.c.F = false;
    this.g.c.E = 0L;
  }
  
  public String getTag()
  {
    return a;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.e.removeObserver(this.i);
      this.e.getMessageFacade().deleteObserver(this.g);
      b();
      return;
    }
    this.e.addDefaultObservers(this.i);
    this.e.getMessageFacade().addObserver(this.g);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieHelper
 * JD-Core Version:    0.7.0.1
 */