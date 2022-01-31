import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class axnd
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public axnd(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseBubbleBuilder.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder = paramBaseBubbleBuilder;
  }
  
  private void a(int paramInt)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A36C", "0X800A36C", paramInt, 0, "", "", "", "");
  }
  
  private boolean a(View paramView, MessageForReplyText paramMessageForReplyText)
  {
    Object localObject1 = afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramMessageForReplyText.mSourceMsgInfo);
    Object localObject2 = localObject1;
    Object localObject3;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, null).iterator();
      do
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject3).next();
      } while (((MessageRecord)localObject2).shmsgseq != paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    }
    if (QLog.isColorLevel())
    {
      if (localObject2 == null)
      {
        localObject1 = "null";
        QLog.d("ReplyItemClickListener", 2, new Object[] { "clicked sourceMsg Class=", localObject1 });
      }
    }
    else if (paramMessageForReplyText.isBarrageMsg)
    {
      if (!(localObject2 instanceof MessageForPic)) {
        break label351;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
    }
    boolean bool1;
    label351:
    int i;
    for (;;)
    {
      boolean bool2 = true;
      localObject3 = null;
      localObject1 = localObject3;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        localObject1 = localObject3;
        bool1 = bool2;
        if (localObject2 != null)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageRecord)localObject2).shmsgseq);
          localObject1 = localObject3;
          bool1 = bool2;
          if (localObject3 == null)
          {
            bool1 = false;
            localObject1 = localObject3;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "check source msg, isReplySrcMsgExist = " + bool1);
      }
      if (!(localObject2 instanceof MessageForShortVideo)) {
        break label784;
      }
      if ((paramView.getId() == 2131364201) || (paramView.getId() == 2131377827)) {
        break label635;
      }
      return false;
      localObject1 = localObject2.getClass().getName();
      break;
      if ((localObject2 instanceof MessageForShortVideo))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
      }
      else if (arrr.a((MessageRecord)localObject2))
      {
        localObject1 = afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
        if ((localObject1 instanceof MessageForFile))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if (localObject1 != null)
          {
            i = arrr.a(((FileManagerEntity)localObject1).fileName);
            if (i == 0) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
        else if ((localObject1 instanceof MessageForTroopFile))
        {
          localObject1 = (MessageForTroopFile)localObject1;
          localObject1 = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
          if (localObject1 != null)
          {
            i = arrr.a(((bbtn)localObject1).g);
            if (i == 0) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    label635:
    if (paramView.getId() == 2131364201)
    {
      localObject1 = (ImageView)paramView.findViewById(2131377827);
      if (((MessageForShortVideo)localObject2).busiType != 0)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localObject2;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (ImageView)paramView;
        }
        ShortVideoRealItemBuilder.a((QQAppInterface)localObject3, localContext, localMessageForShortVideo, (View)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
      }
      for (;;)
      {
        a(5);
        return true;
        agai.a((MessageForShortVideo)localObject2, 0L, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
      }
      if ((localObject2 instanceof MessageForText))
      {
        if ((paramView.getId() != 2131364201) && (paramView.getId() != 2131370777)) {
          return false;
        }
        if (paramView.getId() != 2131364201) {
          break label2603;
        }
        paramMessageForReplyText = (ETTextView)paramView.findViewById(2131370777);
        localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
        if (localObject1 != null)
        {
          localObject1 = ((FragmentActivity)localObject1).getChatFragment();
          if (localObject1 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramMessageForReplyText == null) {}
            for (;;)
            {
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
              a(1);
              return true;
              paramView = paramMessageForReplyText;
            }
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramMessageForReplyText == null) {}
          for (;;)
          {
            ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            paramView = paramMessageForReplyText;
          }
        }
      }
      else if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForPic)))
      {
        if ((paramView.getId() != 2131364201) && (paramView.getId() != 2131370777) && (paramView.getId() != 2131377827)) {
          return false;
        }
        if (((localObject2 instanceof MessageForMixedMsg)) && ((paramView.getId() == 2131364201) || (paramView.getId() == 2131370777)))
        {
          if (paramView.getId() != 2131364201) {
            break label2592;
          }
          paramMessageForReplyText = (ETTextView)paramView.findViewById(2131370777);
          label1020:
          localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
          if (localObject1 == null) {
            break label2586;
          }
          localObject1 = ((FragmentActivity)localObject1).getChatFragment();
          if (localObject1 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramMessageForReplyText == null)
            {
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
              a(3);
            }
          }
        }
        for (;;)
        {
          return true;
          paramView = paramMessageForReplyText;
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramMessageForReplyText == null) {}
          for (;;)
          {
            ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            paramView = paramMessageForReplyText;
          }
          if (((localObject2 instanceof MessageForPic)) && (!(paramView instanceof URLImageView)))
          {
            localObject1 = (MessageForPic)localObject2;
            if (afwu.a((MessageForPic)localObject1)) {
              AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, zjc.a(paramView), afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
            }
            for (;;)
            {
              return true;
              afwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
            }
          }
          paramView = (URLImageView)paramView;
          localObject1 = (MessageForPic)paramView.getTag(2131364187);
          localObject3 = (URLDrawable)paramView.getDrawable();
          if (localObject3 == null) {
            return false;
          }
          switch (((URLDrawable)localObject3).getStatus())
          {
          }
          for (;;)
          {
            if (!(localObject2 instanceof MessageForMixedMsg)) {
              break label1426;
            }
            a(4);
            break;
            if (bdhb.a(this.jdField_a_of_type_AndroidContentContext))
            {
              ((URLDrawable)localObject3).restartDownload();
              continue;
              if (!((URLDrawable)localObject3).isDownloadStarted())
              {
                ((URLDrawable)localObject3).startDownload();
                continue;
                if (afwu.a((MessageForPic)localObject1)) {
                  AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, zjc.a(paramView), afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
                } else {
                  afwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
                }
              }
            }
          }
          a(2);
        }
      }
      else if (arrr.a((MessageRecord)localObject2))
      {
        paramView = afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
        if ((bool1) && (localObject1 != null)) {
          paramView.uniseq = ((MessageRecord)localObject1).uniseq;
        }
        paramView.isMultiMsg = paramMessageForReplyText.isMultiMsg;
        if ((paramView instanceof MessageForFile))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.uniseq, paramView.frienduin, paramView.istroop);
          if (localObject1 != null)
          {
            if (((FileManagerEntity)localObject1).status == 16) {
              return false;
            }
            i = arrr.a(((FileManagerEntity)localObject1).fileName);
            if (((FileManagerEntity)localObject1).cloudType == 0) {
              i = 11;
            }
            if (i == 0)
            {
              afmf.a(this.jdField_a_of_type_AndroidContentContext, null, (MessageForFile)paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, paramMessageForReplyText);
              a(6);
              return true;
            }
            if (i == 2)
            {
              if (((FileManagerEntity)localObject1).status == 16) {
                return true;
              }
              if (!arsx.a((FileManagerEntity)localObject1)) {
                return true;
              }
              i = 0;
              if (((FileManagerEntity)localObject1).peerType == 0) {
                i = 1;
              }
              for (;;)
              {
                arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForFile)paramView, null, i, 10004, (FileManagerEntity)localObject1, false, true);
                break;
                if (((FileManagerEntity)localObject1).peerType == 3000) {
                  i = 5;
                }
              }
            }
            i = 0;
            if (((FileManagerEntity)localObject1).peerType == 0) {
              i = 1;
            }
            for (;;)
            {
              paramView = new arlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1, 10004);
              paramMessageForReplyText = new Bundle();
              paramMessageForReplyText.putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              paramView.a(paramMessageForReplyText);
              paramView = new arls(this.jdField_a_of_type_AndroidContentContext, paramView);
              paramView.a(i);
              paramView.a();
              break;
              if (((FileManagerEntity)localObject1).peerType == 3000) {
                i = 5;
              }
            }
          }
        }
        else if ((paramView instanceof MessageForTroopFile))
        {
          long l = Long.parseLong(paramView.frienduin);
          paramView = (MessageForTroopFile)paramView;
          localObject1 = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
          if (localObject1 != null)
          {
            if (((bbtn)localObject1).b == 12)
            {
              QLog.i("ReplyItemClickListener<QFile>", 1, "click reply. troop file message is expired");
              return false;
            }
            i = arrr.a(((bbtn)localObject1).g);
            if (i == 2)
            {
              if ((paramView.lastTime != 0L) && (paramView.lastTime <= NetConnInfoCenter.getServerTime()))
              {
                QLog.i("ReplyItemClickListener<QFile>", 1, "click reply. troop file message is expired");
                return false;
              }
              arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, l, (bbtn)localObject1, paramView.senderuin, paramView.lastTime, 3, 3, null, false, true, true);
            }
            for (;;)
            {
              a(6);
              return true;
              if (i == 0) {
                switch (((bbtn)localObject1).b)
                {
                case 4: 
                case 5: 
                default: 
                  afwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, afzh.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
                  break;
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                  paramMessageForReplyText = new Intent();
                  paramMessageForReplyText.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
                  TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  break;
                }
              } else {
                arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForReplyText, l, (bbtn)localObject1, paramView.senderuin, paramView.lastTime, 3, 3, null, false, true);
              }
            }
          }
        }
      }
      else if ((localObject2 instanceof MessageForStructing))
      {
        if (!akid.a((MessageRecord)localObject2)) {
          return false;
        }
        if (afzh.c((MessageRecord)localObject2)) {
          return false;
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          paramMessageForReplyText = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          if ((paramMessageForReplyText instanceof StructMsgForGeneralShare))
          {
            paramView.setTag(localObject2);
            localObject1 = (StructMsgForGeneralShare)paramMessageForReplyText;
            localObject2 = new azvp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (StructMsgForGeneralShare)localObject1);
            StructMsgForGeneralShare.onClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (StructMsgForGeneralShare)localObject1, paramView, (azvp)localObject2);
            paramMessageForReplyText.getOnClickListener().onClick(paramView);
            switch (paramMessageForReplyText.mMsgServiceID)
            {
            default: 
              a(9);
            }
          }
          for (;;)
          {
            return true;
            if (!(paramMessageForReplyText instanceof StructMsgForAudioShare)) {
              break;
            }
            localObject1 = (StructMsgForAudioShare)paramMessageForReplyText;
            StructMsgForAudioShare.onClickEvent(this.jdField_a_of_type_AndroidContentContext, (StructMsgForAudioShare)localObject1);
            break;
            a(7);
            continue;
            a(8);
          }
        }
      }
      else if (!(localObject2 instanceof MessageForArkApp)) {}
    }
    for (;;)
    {
      try
      {
        label784:
        label831:
        label852:
        paramMessageForReplyText = ((MessageForArkApp)localObject2).ark_app_message;
        label1041:
        label1426:
        if ((paramMessageForReplyText != null) && (aomy.a().a(paramMessageForReplyText.appName, paramMessageForReplyText.appView)))
        {
          a(aomy.a(paramMessageForReplyText.appName, paramMessageForReplyText.appView));
          localObject2 = aomy.a().a(new JSONObject(paramMessageForReplyText.toAppXml()));
          localObject1 = (String)((Map)localObject2).get("kArkMsgReplyAction");
          localObject2 = (String)((Map)localObject2).get("kArkMsgReplyJumpUrl");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2567;
          }
          if ("showLargeText".equals(localObject1))
          {
            if ((paramView.getId() != 2131364201) && (paramView.getId() != 2131370777)) {
              return false;
            }
            paramMessageForReplyText = null;
            if (paramView.getId() == 2131364201) {
              paramMessageForReplyText = (ETTextView)paramView.findViewById(2131370777);
            }
            localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
            if (localObject1 == null) {
              break label2580;
            }
            localObject1 = ((FragmentActivity)localObject1).getChatFragment();
            if (localObject1 == null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramMessageForReplyText != null) {
                break label2616;
              }
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
            }
            else
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramMessageForReplyText == null) {
                ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              }
            }
          }
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ReplyItemClickListener", 1, "handle sourceMsg of MessageForArkApp error: " + paramView.getMessage());
      }
      return false;
      paramView = paramMessageForReplyText;
      continue;
      label2567:
      anjy.a((String)localObject2, 0, paramMessageForReplyText.appName);
      return true;
      label2580:
      localObject1 = null;
      continue;
      label2586:
      localObject1 = null;
      break label1041;
      label2592:
      paramMessageForReplyText = null;
      break label1020;
      localObject1 = null;
      break label852;
      label2603:
      paramMessageForReplyText = null;
      break label831;
      localObject1 = null;
      break;
      return true;
      label2616:
      paramView = paramMessageForReplyText;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a()) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 1000L);
      this.jdField_a_of_type_Long = l;
      localObject1 = aepi.a(paramView);
      if (!(localObject1 instanceof MessageForMixedMsg)) {
        break;
      }
      localObject1 = (MessageForMixedMsg)localObject1;
    } while (((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == null);
    Object localObject1 = ((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    for (;;)
    {
      if (!(localObject1 instanceof MessageForReplyText))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject2 = new StringBuilder().append("TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForReplyText, it's");
        if (localObject1 != null) {}
        for (paramView = localObject1.getClass().getSimpleName();; paramView = "null")
        {
          QLog.w("ReplyItemClickListener", 2, paramView);
          return;
        }
      }
      Object localObject2 = (MessageForReplyText)localObject1;
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((MessageForReplyText)localObject2).mSourceMsgInfo;
      if (((MessageForReplyText)localObject2).msgtype == -1003)
      {
        aepi.n = true;
        localObject1 = bdqa.a(((MessageForReplyText)localObject2).action);
        localObject1 = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject1);
        if (localObject1 != null) {
          ((bdhk)localObject1).c();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "ReplyTextItemBuilder OnClickListener original sourceMsgInfo msgUid= " + localSourceMsgInfo.origUid + ", time = " + localSourceMsgInfo.mSourceMsgTime);
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364201: 
      case 2131370777: 
      case 2131377827: 
        if (a(paramView, (MessageForReplyText)localObject2))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick success");
          return;
        }
      case 2131368831: 
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break;
        }
        ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localChatFragment != null)
        {
          localObject1 = afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject2).frienduin, ((MessageForReplyText)localObject2).istroop, (MessageRecord)localObject2, ((MessageForReplyText)localObject2).mSourceMsgInfo);
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
            }
            Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForReplyText)localObject2).frienduin, ((MessageForReplyText)localObject2).istroop, null).iterator();
            do
            {
              paramView = (View)localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              paramView = (MessageRecord)localIterator.next();
            } while (paramView.shmsgseq != ((MessageForReplyText)localObject2).mSourceMsgInfo.mSourceMsgSeq);
          }
          if (((paramView instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramView).tipParam != null) && ((((MessageForUniteGrayTip)paramView).tipParam.b == 1) || (((MessageForUniteGrayTip)paramView).tipParam.b == 131073)))
          {
            int i;
            if (((MessageForUniteGrayTip)paramView).tipParam.b == 1)
            {
              j = 1;
              paramView = this.jdField_a_of_type_AndroidContentContext;
              if (j == 0) {
                break label598;
              }
              i = 0;
              label552:
              if (j == 0) {
                break label603;
              }
            }
            label598:
            label603:
            for (int j = 2131698124;; j = 2131698215)
            {
              QQToast.a(paramView, i, j, 0).b(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
              afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
              return;
              j = 0;
              break;
              i = 1;
              break label552;
            }
          }
          localObject1 = localChatFragment.a();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && ((localObject1 instanceof agps))) {
            ((agps)localObject1).a(22, localSourceMsgInfo.origUid, localSourceMsgInfo.mSourceMsgTime, null, 1, 1);
          }
          for (;;)
          {
            afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, "0X800A36A");
            return;
            if (((BaseChatPie)localObject1).j())
            {
              ((BaseChatPie)localObject1).a(22, localSourceMsgInfo.mSourceMsgSeq, (int)(((MessageForReplyText)localObject2).shmsgseq - localSourceMsgInfo.mSourceMsgSeq), (MessageRecord)localObject2, 1, 1);
              MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", ((MessageForReplyText)localObject2).frienduin, (ChatMessage)localObject2);
              if (QLog.isColorLevel()) {
                QLog.w("ReplyItemClickListener", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
              }
            }
            else if ((localObject1 instanceof agso))
            {
              ((BaseChatPie)localObject1).a(22, localSourceMsgInfo.mSourceMsgSeq, (int)(((MessageForReplyText)localObject2).shmsgseq - localSourceMsgInfo.mSourceMsgSeq), (MessageRecord)localObject2, 1, 1);
              if (QLog.isColorLevel()) {
                QLog.d("ReplyItemClickListener", 2, "MultiForwardChatPie onClickListener: isReplyMsg = true");
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReplyItemClickListener", 2, "getChatFragment() is null");
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131698123, 0).b(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick fail");
        }
        localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
        if (localObject1 != null) {}
        for (localObject1 = ((FragmentActivity)localObject1).getChatFragment();; localObject1 = null)
        {
          if (localObject1 == null) {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
          }
          for (;;)
          {
            a(9);
            return;
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axnd
 * JD-Core Version:    0.7.0.1
 */