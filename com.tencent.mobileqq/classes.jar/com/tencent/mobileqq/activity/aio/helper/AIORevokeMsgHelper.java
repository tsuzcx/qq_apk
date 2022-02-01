package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import mqq.os.MqqHandler;

public class AIORevokeMsgHelper
  implements ILifeCycleHelper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AIORevokeMsgHelper.7(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public AIORevokeMsgHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {}
    for (boolean bool = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());; bool = false)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694359));
      localActionSheet.addButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694357), 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new AIORevokeMsgHelper.1(this, bool, localActionSheet));
      if (!localActionSheet.isShowing())
      {
        localActionSheet.show();
        a("0X800A7F4", bool);
      }
      return;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().post(new AIORevokeMsgHelper.8(this, paramInt));
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof BaseTransProcessor))) {
      ((BaseTransProcessor)paramMessageForPic).cancel();
    }
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramMessageForTroopFile = HardCodeUtil.a(2131715121);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new AIORevokeMsgHelper.6(this)).show();
      return;
    }
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
      TroopFileManager localTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo.b);
      localTroopFileManager.a(localTroopFileManager.a(localTroopFileStatusInfo.e, localTroopFileStatusInfo.g, localTroopFileStatusInfo.c, localTroopFileStatusInfo.h), (int)paramMessageForTroopFile.shmsgseq, MessageUtils.a(paramMessageForTroopFile.msgUid));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694363));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.show();
      paramMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131697207, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPtt)) {}
    MultiRichMediaSaveManager localMultiRichMediaSaveManager;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramMessageRecord instanceof MessageForShortVideo)) {
              break;
            }
            paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
            a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
          } while (paramMessageRecord.busiType != 0);
          localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
        } while (!localMultiRichMediaSaveManager.a(paramMessageRecord));
        localMultiRichMediaSaveManager.b(paramMessageRecord, 0L, 0, 256);
        return;
      } while (!(paramMessageRecord instanceof MessageForPic));
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      a(paramMessageRecord, 131075);
      a(paramMessageRecord, 1);
      a(paramMessageRecord, 131075);
      localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    } while (!localMultiRichMediaSaveManager.a(paramMessageRecord));
    localMultiRichMediaSaveManager.b(paramMessageRecord, 0L, 0, 24);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPtt))
    {
      paramList = (MessageForPtt)paramList.get(0);
      paramChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      if ((paramChatMessage == paramList) || (((paramChatMessage instanceof MessageForPtt)) && (paramChatMessage.frienduin != null) && (paramChatMessage.frienduin.equals(paramList.frienduin)) && (paramChatMessage.uniseq == paramList.uniseq))) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramChatMessage instanceof MessageForShortVideo))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g(131072);
              ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
              return;
            }
            if (!(paramChatMessage instanceof MessageForStructing)) {
              break;
            }
            paramList = ((MessageForStructing)paramList.get(0)).structingMsg;
          } while ((paramList == null) || (!(paramList instanceof StructMsgForAudioShare)) || (!QQPlayerService.a((StructMsgForAudioShare)paramList)));
          QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
          return;
          if (!(paramChatMessage instanceof MessageForApollo)) {
            break;
          }
          paramList = (MessageForApollo)paramList.get(0);
        } while (paramList == null);
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopTaskByMsg(paramList.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "withdraw_msg");
      } while (paramList.mApolloMessage == null);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "withdraw_success", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramList.mApolloMessage.id) });
      return;
      paramList = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramList + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
    } while (TextUtils.isEmpty(paramList));
    try
    {
      long l = Long.parseLong(paramList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      QLog.e("AIORevokeMsgHelper", 1, paramList.toString());
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ChatMessage> paramList)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessage(267387139);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        MultiMsgManager.a().a(paramList);
        ChatActivityFacade.a(paramList);
        ChatActivityFacade.b(paramList);
        AIOGalleryMsgRevokeMgr.a((MessageRecord)paramList.get(0));
        ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
        a(localChatMessage);
        a(paramList, localChatMessage);
      }
      QQGamePubAIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramList, new ChatMessage[] { this.jdField_a_of_type_ComTencentMobileqqDataChatMessage });
      if ((paramBoolean2) && (paramBoolean3)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessage(267387140);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (localITransFileController.containsProcessor(paramString, paramLong))
    {
      paramString = paramString + paramLong;
      IHttpCommunicatorListener localIHttpCommunicatorListener = localITransFileController.findProcessor(paramString);
      if ((localIHttpCommunicatorListener instanceof ShortVideoDownloadProcessor))
      {
        ((ShortVideoDownloadProcessor)localIHttpCommunicatorListener).pause();
        localITransFileController.removeProcessor(paramString);
        return true;
      }
    }
    return false;
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    if (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((ReportTask)localObject2).a(new String[] { str, localObject1 }).a();
        if (SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label234;
        }
        e(paramChatMessage);
        localObject1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label227;
        }
      }
      label227:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((ReportTask)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        return;
        localObject1 = "2";
        break;
      }
      label234:
      e(paramChatMessage);
      return;
    }
    b(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (TroopUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      a();
      return;
    }
    f(paramChatMessage);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject == null) {}
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005) && (!TroopUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694342);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694343);
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new AIORevokeMsgHelper.2(this, paramChatMessage)).show();
      return;
    }
    d(paramChatMessage);
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = TroopUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L < 120000L) && (!bool)) || (bool) || (paramChatMessage.msgtype == -2005) || (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694363));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.show();
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(true);
      localQQMessageFacade.d(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      int i = 20000;
      if (paramChatMessage.msgtype == -2005) {
        i = 30000;
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendMessageDelayed(paramChatMessage, i);
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694358)).setPositiveButton(17039370, new AIORevokeMsgHelper.3(this)).show();
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131701052));
    localActionSheet.setSecondaryTitle(HardCodeUtil.a(2131701045));
    localActionSheet.addButton(HardCodeUtil.a(2131701042), 3);
    localActionSheet.addCancelButton(HardCodeUtil.a(2131701053));
    localActionSheet.setOnButtonClickListener(new AIORevokeMsgHelper.4(this, paramChatMessage, localActionSheet));
    localActionSheet.show();
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131715132));
      localActionSheet.setSecondaryTitle(HardCodeUtil.a(2131715126));
      localActionSheet.addButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694357), 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new AIORevokeMsgHelper.5(this, paramChatMessage, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    c(paramChatMessage);
  }
  
  public String getTag()
  {
    return "AIORevokeMsgHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper
 * JD-Core Version:    0.7.0.1
 */