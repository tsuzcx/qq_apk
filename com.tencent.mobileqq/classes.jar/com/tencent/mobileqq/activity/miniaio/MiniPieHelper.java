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
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private MiniPie jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new MiniPieHelper.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  
  public MiniPieHelper(MiniPie paramMiniPie)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramMiniPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie = paramMiniPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniPie.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".Helper");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  static boolean a()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  static int b(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doNewRefreshForAio");
    }
    int j;
    int i;
    if (paramChatXListView.getLastVisiblePosition() >= 0)
    {
      paramList1 = paramChatXListView.getChildAt(paramChatXListView.getChildCount() - 1);
      if (paramList1 != null) {
        paramInt = paramList1.getBottom();
      } else {
        paramInt = 0;
      }
      int k = paramChatXListView.getHeight();
      j = k;
      i = paramInt;
      if (QLog.isColorLevel())
      {
        paramChatXListView = jdField_a_of_type_JavaLangString;
        paramList1 = new StringBuilder();
        paramList1.append("refreshlistadapter=====lastbuttom=");
        paramList1.append(paramInt);
        paramList1.append(" listHeight=");
        paramList1.append(k);
        QLog.d(paramChatXListView, 2, paramList1.toString());
        j = k;
        i = paramInt;
      }
    }
    else
    {
      j = 0;
      i = 0;
    }
    if (i <= j) {
      return 3;
    }
    return 0;
  }
  
  int a(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "keepPostionScroll");
    }
    return Scroller.a(jdField_a_of_type_JavaLangString, paramChatXListView, paramInt, paramList1, paramList2);
  }
  
  int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doDefaultSrollPosition");
    }
    int i = paramInt;
    if (paramList1 != paramList2)
    {
      int m = paramList1.size();
      int j = paramList2.size();
      if ((m > 0) && (j > 0))
      {
        long l = ((ChatMessage)paramList1.get(m - 1)).uniseq;
        int k = j - 1;
        i = k;
        while ((i >= 0) && ((i != k) || (!UniteGrayTipMsgUtil.a((MessageRecord)paramList2.get(i)))))
        {
          if (((ChatMessage)paramList2.get(i)).uniseq == l) {
            break label144;
          }
          i -= 1;
        }
      }
      i = -1;
      label144:
      if (i >= 0) {
        return j - (m - paramInt + j - 1 - i);
      }
      i = paramInt;
      if (j > 0)
      {
        i = paramInt;
        if (!UniteGrayTipMsgUtil.a((MessageRecord)paramList2.get(j - 1))) {
          i = j;
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.b()) {
      MiniChatMsgProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    int i = ((ChatXListView)localObject).getFooterViewsCount();
    int k = ((ChatXListView)localObject).getHeaderViewsCount();
    int j = paramInt3 - k - i;
    paramInt3 = j - (paramInt1 - k) - paramInt2;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" listSize =");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" chatPie.mReadedCnt =");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.g);
      QLog.d("MiniPie.onScroll", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.g < j)
    {
      paramInt2 = paramInt1 + paramInt2 - i - k;
      paramInt1 = paramInt2;
      if (paramInt2 >= j) {
        paramInt1 = j - 1;
      }
      if (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.g) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.g = (paramInt1 + i);
      }
      if (paramInt3 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.g = j;
      }
      paramInt1 = j - this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.g;
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.h)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_MqqOsMqqHandler;
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5, paramInt1, paramInt3);
      long l;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        l = 1500L;
      } else {
        l = 0L;
      }
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l);
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.h = paramInt1;
    }
  }
  
  protected void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    paramSendMsgParams.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    paramSendMsgParams.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramSendMsgParams.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    paramSendMsgParams.jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    paramSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    paramSendMsgParams.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.m;
    paramSendMsgParams.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if ((localSourceMsgInfo != null) && (localSourceMsgInfo.mSourceMsgText.length() > BaseChatPie.f))
    {
      localSourceMsgInfo.mSourceMsgText = localSourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.f);
      localSourceMsgInfo.mSourceSummaryFlag = 0;
      if (localSourceMsgInfo.mType == -1036) {
        localSourceMsgInfo.oriMsgType = 1;
      }
    }
    paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = localSourceMsgInfo;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.b())
    {
      MiniChatMsgProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) && (!MiniChatMsgProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    int i = ((String)localObject1).length();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    int k = MiniPie.e;
    int j = 1;
    if (i > k)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131718759, 1);
      return;
    }
    Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (((XEditTextEx)localObject5).getTag(2131373876) == null) {
      localObject2 = null;
    }
    if (localObject2 != null) {
      localObject1 = ReplyMsgUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForReplyText.SourceMsgInfo)localObject2);
    } else {
      localObject1 = null;
    }
    Object localObject4 = new ChatActivityFacade.SendMsgParams();
    a((ChatActivityFacade.SendMsgParams)localObject4);
    ((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Int = DanmuUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
    if (((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Boolean)
    {
      ((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Int = DanmuUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
      if ((((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Int != 1) && (((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Int != 3))
      {
        if ((((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Int == 2) || (((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Int == 4)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A884", "0X800A884", 0, 0, "", "", "", "");
        }
      }
      else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A883", "0X800A883", 0, 0, "", "", "", "");
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new ArrayList();
      localObject2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2, (ArrayList)localObject1, (ChatActivityFacade.SendMsgParams)localObject4);
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
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
        localObject3 = jdField_a_of_type_JavaLangString;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(" send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:");
        ((StringBuilder)localObject6).append(System.currentTimeMillis());
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject6).toString());
      }
      Object localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName))
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            i = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, -1L, true);
            i = ((List)localObject3).size() - 1;
            while (i >= 0)
            {
              localObject1 = (ChatMessage)((List)localObject3).get(i);
              if (((ChatMessage)localObject1).shmsgseq == ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq) {
                break label680;
              }
              i -= 1;
            }
            localObject1 = null;
            label680:
            MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "suc_replyMsg", "reply_suc", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (ChatMessage)localObject1);
            localObject3 = localObject1;
          }
        }
      }
      if (((ChatActivityFacade.SendMsgParams)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
      {
        ((ChatActivityFacade.SendMsgParams)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
        if (((localObject3 instanceof MessageForPic)) || ((localObject3 instanceof MessageForMixedMsg))) {
          ((ChatActivityFacade.SendMsgParams)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
        }
        if (localObject3 != null) {
          ((ChatActivityFacade.SendMsgParams)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
        }
      }
      Object localObject6 = new ArrayList();
      localObject2 = AtTroopMemberSpan.a(((XEditTextEx)localObject5).getEditableText(), (ArrayList)localObject6);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a(true);
      ArrayList localArrayList = new ArrayList();
      localObject5 = AtTroopMemberSpan.a(((XEditTextEx)localObject5).getEditableText(), localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2, (ArrayList)localObject6, (ChatActivityFacade.SendMsgParams)localObject4, (MessageRecord)localObject3, (String)localObject5, localArrayList);
        if (((ChatActivityFacade.SendMsgParams)localObject4).jdField_d_of_type_Boolean)
        {
          localObject3 = (IDanmuDataIPCServer)QRoute.api(IDanmuDataIPCServer.class);
          long l1 = ((ChatActivityFacade.SendMsgParams)localObject4).jdField_a_of_type_Long;
          long l2 = ((ChatActivityFacade.SendMsgParams)localObject4).jdField_b_of_type_Long;
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          long l3 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq;
          if (((ArrayList)localObject6).isEmpty()) {
            localObject1 = null;
          }
          ((IDanmuDataIPCServer)localObject3).notifyDanmuSendResult(l1, l2, (String)localObject2, (String)localObject4, l3, (SpannableString)localObject1);
        }
      }
      else
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2, (ArrayList)localObject6, (ChatActivityFacade.SendMsgParams)localObject4);
      }
    }
    d();
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373876, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(AIOUtils.b(36.0F, this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
    }
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    localMiniPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    localMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.m = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = 0L;
  }
  
  public String getTag()
  {
    return jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie);
      b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieHelper
 * JD-Core Version:    0.7.0.1
 */