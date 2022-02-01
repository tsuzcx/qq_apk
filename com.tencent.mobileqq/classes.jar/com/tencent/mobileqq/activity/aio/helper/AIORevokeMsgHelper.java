package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.BaseActivity;
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
  private BaseChatPie a;
  private QQAppInterface b;
  private Context c;
  private ChatMessage d;
  private BaseActivity e;
  private SessionInfo f;
  private MessageObserver g = new AIORevokeMsgHelper.7(this);
  
  public AIORevokeMsgHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.e;
    this.e = paramBaseChatPie.f;
    this.a = paramBaseChatPie;
    this.f = paramBaseChatPie.ah;
  }
  
  private void a()
  {
    Object localObject = this.d;
    boolean bool;
    if (localObject != null) {
      bool = TroopUtils.a(this.b, ((ChatMessage)localObject).frienduin, this.b.getCurrentAccountUin());
    } else {
      bool = false;
    }
    localObject = (ActionSheet)ActionSheetHelper.b(this.c, null);
    ((ActionSheet)localObject).setMainTitle(this.e.getString(2131891962));
    ((ActionSheet)localObject).addButton(this.e.getString(2131891960), 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new AIORevokeMsgHelper.1(this, bool, (ActionSheet)localObject));
    if (!((ActionSheet)localObject).isShowing())
    {
      ((ActionSheet)localObject).show();
      a("0X800A7F4", bool);
    }
  }
  
  private void a(int paramInt)
  {
    this.a.j().post(new AIORevokeMsgHelper.8(this, paramInt));
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof BaseTransProcessor))) {
      ((BaseTransProcessor)paramMessageForPic).cancel();
    }
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject = this.b;
    if (!TroopUtils.b((QQAppInterface)localObject, paramMessageForTroopFile, ((QQAppInterface)localObject).getCurrentAccountUin()))
    {
      paramMessageForTroopFile = HardCodeUtil.a(2131912534);
      DialogUtil.a(this.c, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new AIORevokeMsgHelper.6(this)).show();
      return;
    }
    if (NetworkUtil.isNetworkAvailable(this.c))
    {
      localObject = TroopFileUtils.a(this.b, paramMessageForTroopFile);
      TroopFileManager localTroopFileManager = TroopFileManager.a(this.b, ((TroopFileStatusInfo)localObject).d);
      localTroopFileManager.a(localTroopFileManager.a(((TroopFileStatusInfo)localObject).r, ((TroopFileStatusInfo)localObject).t, ((TroopFileStatusInfo)localObject).i, ((TroopFileStatusInfo)localObject).u), (int)paramMessageForTroopFile.shmsgseq, MessageUtils.a(paramMessageForTroopFile.msgUid));
      this.a.ao = new QQProgressDialog(this.c);
      this.a.ao.a(this.c.getString(2131891966));
      this.a.ao.c(true);
      this.a.ao.show();
      paramMessageForTroopFile = this.a.j().obtainMessage(267387140, 1, 0);
      this.a.j().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    QQToast.makeText(this.c, 2131894999, 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPtt)) {
      return;
    }
    MultiRichMediaSaveManager localMultiRichMediaSaveManager;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if (paramMessageRecord.busiType == 0)
      {
        localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.b.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
        if (localMultiRichMediaSaveManager.b(paramMessageRecord)) {
          localMultiRichMediaSaveManager.b(paramMessageRecord, 0L, 0, 256);
        }
      }
    }
    else if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      a(paramMessageRecord, 131075);
      a(paramMessageRecord, 1);
      a(paramMessageRecord, 131075);
      localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.b.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      if (localMultiRichMediaSaveManager.b(paramMessageRecord)) {
        localMultiRichMediaSaveManager.b(paramMessageRecord, 0L, 0, 24);
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
  
  private void a(List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPtt))
    {
      paramList = (MessageForPtt)paramList.get(0);
      paramChatMessage = MediaPlayerManager.a(this.b).f();
      if ((paramChatMessage == paramList) || (((paramChatMessage instanceof MessageForPtt)) && (paramChatMessage.frienduin != null) && (paramChatMessage.frienduin.equals(paramList.frienduin)) && (paramChatMessage.uniseq == paramList.uniseq))) {
        MediaPlayerManager.a(this.b).a(true);
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForShortVideo))
      {
        this.a.j(131072);
        ShortVideoPTVItemBuilder.a(this.a.U);
        return;
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        paramList = ((MessageForStructing)paramList.get(0)).structingMsg;
        if ((paramList != null) && ((paramList instanceof StructMsgForAudioShare)) && (QQPlayerService.d((StructMsgForAudioShare)paramList))) {
          QQPlayerService.e(this.c);
        }
      }
      else
      {
        if ((paramChatMessage instanceof IMessageForApollo))
        {
          paramList = (MessageRecord)paramList.get(0);
          ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).handleRevokeRspByType(paramList, this.b, this.f.a);
          return;
        }
        paramList = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("del garyTips id[");
          localStringBuilder.append(paramList);
          localStringBuilder.append("],targetId[");
          localStringBuilder.append(paramChatMessage.msgUid);
          localStringBuilder.append("], hashCode:");
          localStringBuilder.append(paramChatMessage.hashCode());
          QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(paramList)) {
          try
          {
            long l = Long.parseLong(paramList);
            this.b.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
            return;
          }
          catch (Exception paramList)
          {
            paramList.printStackTrace();
            QLog.e("AIORevokeMsgHelper", 1, paramList.toString());
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ChatMessage> paramList)
  {
    if (paramBoolean1)
    {
      this.a.j().sendEmptyMessage(267387139);
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
      QQGamePubAIOHelper.a(this.a, paramList, new ChatMessage[] { this.d });
      if ((paramBoolean2) && (paramBoolean3)) {
        ReportController.b(this.b, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
    }
    else
    {
      this.a.j().sendEmptyMessage(267387140);
    }
  }
  
  private boolean a(String paramString, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
    if (localITransFileController.containsProcessor(paramString, paramLong))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramLong);
      paramString = ((StringBuilder)localObject).toString();
      localObject = localITransFileController.findProcessor(paramString);
      if ((localObject instanceof ShortVideoDownloadProcessor))
      {
        ((ShortVideoDownloadProcessor)localObject).pause();
        localITransFileController.removeProcessor(paramString);
        return true;
      }
    }
    return false;
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    Object localObject1 = this.b;
    if (TroopUtils.a((QQAppInterface)localObject1, paramChatMessage, ((QQAppInterface)localObject1).getCurrentAccountUin()))
    {
      Object localObject2 = new ReportTask(this.b).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str2 = paramChatMessage.frienduin;
      boolean bool = TroopUtils.a(this.b, paramChatMessage.frienduin, this.b.getCurrentAccountUin());
      String str1 = "1";
      if (bool) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ((ReportTask)localObject2).a(new String[] { str2, localObject1 }).a();
      if (!SharedPreUtils.j(this.b.getCurrentAccountUin()))
      {
        e(paramChatMessage);
        localObject1 = new ReportTask(this.b).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (TroopUtils.a(this.b, paramChatMessage.frienduin, this.b.getCurrentAccountUin())) {
          paramChatMessage = str1;
        } else {
          paramChatMessage = "2";
        }
        ((ReportTask)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        SharedPreUtils.a(this.b.getCurrentAccountUin(), true);
        return;
      }
      e(paramChatMessage);
      return;
    }
    b(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isSend())
    {
      QQAppInterface localQQAppInterface = this.b;
      if ((TroopUtils.c(localQQAppInterface, paramChatMessage, localQQAppInterface.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
      {
        this.d = paramChatMessage;
        a();
        return;
      }
    }
    f(paramChatMessage);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    Object localObject = this.b.getApp().getSharedPreferences(this.b.getCurrentAccountUin(), 0);
    boolean bool;
    if (localObject == null) {
      bool = false;
    } else {
      bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true);
    }
    if ((bool) && (paramChatMessage.msgtype != -2005))
    {
      QQAppInterface localQQAppInterface = this.b;
      if (!TroopUtils.c(localQQAppInterface, paramChatMessage, localQQAppInterface.getCurrentAccountUin()))
      {
        ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
        localObject = this.c.getString(2131891945);
        if (paramChatMessage.msgtype == -2005) {
          localObject = this.c.getString(2131891946);
        }
        DialogUtil.a(this.c, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new AIORevokeMsgHelper.2(this, paramChatMessage)).show();
        return;
      }
    }
    d(paramChatMessage);
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = this.b;
    boolean bool = TroopUtils.c((QQAppInterface)localObject, paramChatMessage, ((QQAppInterface)localObject).getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L >= 120000L) || (bool)) && (!bool) && (paramChatMessage.msgtype != -2005))
    {
      localObject = this.b;
      if (!TroopUtils.a((QQAppInterface)localObject, paramChatMessage, ((QQAppInterface)localObject).getCurrentAccountUin()))
      {
        DialogUtil.a(this.c, 230).setMessage(this.c.getString(2131891961)).setPositiveButton(17039370, new AIORevokeMsgHelper.3(this)).show();
        return;
      }
    }
    this.d = paramChatMessage;
    this.a.ao = new QQProgressDialog(this.c);
    this.a.ao.a(this.c.getString(2131891966));
    this.a.ao.c(true);
    this.a.ao.show();
    localObject = this.b.getMessageFacade();
    this.b.getMsgCache().b(true);
    ((QQMessageFacade)localObject).f(this.d);
    int i = 20000;
    if (paramChatMessage.msgtype == -2005) {
      i = 30000;
    }
    paramChatMessage = this.a.j().obtainMessage(267387140, 1, 0);
    this.a.j().sendMessageDelayed(paramChatMessage, i);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.c, null);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131899209));
    localActionSheet.setSecondaryTitle(HardCodeUtil.a(2131899203));
    localActionSheet.addButton(HardCodeUtil.a(2131899200), 3);
    localActionSheet.addCancelButton(HardCodeUtil.a(2131898212));
    localActionSheet.setOnButtonClickListener(new AIORevokeMsgHelper.4(this, paramChatMessage, localActionSheet));
    localActionSheet.show();
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.c, null);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131912543));
      localActionSheet.setSecondaryTitle(HardCodeUtil.a(2131912539));
      localActionSheet.addButton(this.e.getString(2131891960), 3);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new AIORevokeMsgHelper.5(this, paramChatMessage, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      ReportController.b(this.b, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.f.b, "", "", "");
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
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.b.removeObserver(this.g);
      return;
    }
    this.b.addObserver(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper
 * JD-Core Version:    0.7.0.1
 */