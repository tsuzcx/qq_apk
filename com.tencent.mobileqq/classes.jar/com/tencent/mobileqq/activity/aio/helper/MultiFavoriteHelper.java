package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavRequestQueue;
import cooperation.qqfav.QfavUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;

public class MultiFavoriteHelper
  implements View.OnClickListener, ILifeCycleHelper, OnActivityResultCallback
{
  protected ImageView a;
  private QQAppInterface b;
  private Context c;
  private Activity d;
  private BaseChatPie e;
  private SessionInfo f;
  
  public MultiFavoriteHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.e;
    this.d = paramBaseChatPie.f;
    this.e = paramBaseChatPie;
    this.f = paramBaseChatPie.ah;
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.t;
    if (FileUtil.d(paramTroopFileStatusInfo.k)) {
      localFileManagerEntity.setFilePath(paramTroopFileStatusInfo.k);
    }
    if (FileUtil.d(paramTroopFileStatusInfo.m)) {
      localFileManagerEntity.strLargeThumPath = paramTroopFileStatusInfo.m;
    }
    if (FileUtil.d(paramTroopFileStatusInfo.l)) {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.l;
    } else if (FileUtil.d(paramTroopFileStatusInfo.n)) {
      localFileManagerEntity.strMiddleThumPath = paramTroopFileStatusInfo.n;
    }
    localFileManagerEntity.fileSize = paramTroopFileStatusInfo.i;
    localFileManagerEntity.fProgress = ((float)paramTroopFileStatusInfo.j / (float)paramTroopFileStatusInfo.i);
    localFileManagerEntity.nFileType = FileManagerUtil.c(paramTroopFileStatusInfo.t);
    if ((6 <= paramTroopFileStatusInfo.e) && (13 != paramTroopFileStatusInfo.e))
    {
      if (12 == paramTroopFileStatusInfo.e) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
    else {
      localFileManagerEntity.status = 2;
    }
    if (paramTroopFileStatusInfo.a != null) {
      localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.a.toString();
    }
    localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.r;
    localFileManagerEntity.strTroopFileSha1 = paramTroopFileStatusInfo.s;
    localFileManagerEntity.busId = paramTroopFileStatusInfo.u;
    localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.d;
    localFileManagerEntity.peerType = 1;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= create new Entity[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] fileName[");
    localStringBuilder.append(paramTroopFileStatusInfo.t);
    localStringBuilder.append("] by troop size(");
    localStringBuilder.append(localFileManagerEntity.imgHeight);
    localStringBuilder.append(":");
    localStringBuilder.append(localFileManagerEntity.imgWidth);
    localStringBuilder.append(")");
    QLog.i("MultiFavoriteHelper", 1, localStringBuilder.toString());
    return localFileManagerEntity;
  }
  
  private Entity a(Entity paramEntity)
  {
    StringBuilder localStringBuilder = null;
    if (paramEntity == null) {
      return null;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("deepCopy, start:");
        ((StringBuilder)localObject1).append(paramEntity.toString());
        QLog.d("MultiFavoriteHelper", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (Entity)paramEntity.getClass().newInstance();
      if (localObject1 != null)
      {
        localObject2 = paramEntity.getClass().getFields();
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          if (!localObject3.isAccessible()) {
            localObject3.setAccessible(true);
          }
          localObject3.set(localObject1, localObject3.get(paramEntity));
          i += 1;
        }
      }
      paramEntity = (Entity)localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" deepCopy:failed");
      ((StringBuilder)localObject2).append(paramEntity.getClass().getName());
      ((StringBuilder)localObject2).append(" exception e: = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("Entity", 1, ((StringBuilder)localObject2).toString());
      localException.printStackTrace();
      paramEntity = localStringBuilder;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("deepCopy, end, entity:");
      localStringBuilder.append(paramEntity);
      QLog.d("MultiFavoriteHelper", 2, localStringBuilder.toString());
    }
    return paramEntity;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramQQAppInterface != null))
    {
      String str2 = MsgProxyUtils.d(paramChatMessage);
      String str1;
      if ((paramChatMessage.isMultiMsg) && (!AnonymousChatHelper.c(paramChatMessage)))
      {
        String str3 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
        str1 = str3;
        if (TextUtils.isEmpty(str3)) {
          str1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, paramQQAppInterface);
        }
      }
      else
      {
        str1 = "";
      }
      if ((str1 != null) && (TextUtils.getTrimmedLength(str1) != 0)) {
        paramQQAppInterface = str1;
      } else {
        paramQQAppInterface = MultiMsgUtil.b(paramChatMessage.senderuin);
      }
      if (TextUtils.isEmpty(str2)) {
        paramQQAppInterface = str2;
      }
      return paramQQAppInterface;
    }
    return null;
  }
  
  private ArrayList<ChatMessage> a(MessageForStructing paramMessageForStructing, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (localChatMessage.msgtype == -1037) {
        paramArrayList = (MessageForText)((MessageForLongMsg)localChatMessage).rebuildLongMsg();
      } else if (localChatMessage.msgtype == -1036) {
        paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localChatMessage).rebuildLongMsg();
      } else if (localChatMessage.msgtype == -1035) {
        paramArrayList = (ChatMessage)((MessageForMixedMsg)localChatMessage).rebuildMixedMsg();
      } else if (localChatMessage.msgtype == -2011) {
        paramArrayList = new MessageForStructing(localChatMessage);
      } else {
        paramArrayList = (ChatMessage)localChatMessage.deepCopyByReflect();
      }
      Object localObject1 = paramArrayList;
      if (paramArrayList == null)
      {
        localObject1 = paramArrayList;
        if ((localChatMessage instanceof MessageForText))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiFavoriteHelper", 2, "preAddMultiMsg.mrTemp is null ,should copy by myself...");
          }
          localObject1 = (ChatMessage)a(localChatMessage);
          if (localChatMessage == null) {}
        }
      }
      try
      {
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("preAddMultiMsg.mr msg:");
          paramArrayList.append(localChatMessage.msg);
          paramArrayList.append(" msgData:");
          paramArrayList.append(localChatMessage.msgData);
          QLog.d("MultiFavoriteHelper", 2, paramArrayList.toString());
        }
        if ((localObject1 != null) && (QLog.isColorLevel()))
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("preAddMultiMsg.mrTemp msg:");
          paramArrayList.append(((ChatMessage)localObject1).msg);
          paramArrayList.append(" msgData:");
          paramArrayList.append(((ChatMessage)localObject1).msgData);
          QLog.d("MultiFavoriteHelper", 2, paramArrayList.toString());
        }
        if ((localObject1 != null) && (((ChatMessage)localObject1).msg != null) && (((ChatMessage)localObject1).msgData == null))
        {
          ((ChatMessage)localObject1).msgData = ((ChatMessage)localObject1).msg.getBytes("UTF-8");
          break label425;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiFavoriteHelper", 2, "preAddMultiMsg.mrTemp or msg is null");
          }
          localObject1 = null;
        }
        catch (Exception paramArrayList)
        {
          localObject1 = null;
        }
      }
      catch (Exception paramArrayList)
      {
        label389:
        Object localObject2;
        break label389;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preAddMultiMsg.copy by myself exception:");
      ((StringBuilder)localObject2).append(paramArrayList);
      QLog.d("MultiFavoriteHelper", 2, ((StringBuilder)localObject2).toString());
      label425:
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiFavoriteHelper", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
        }
        return null;
      }
      if (!TextUtils.isEmpty(((ChatMessage)localObject1).getExtInfoFromExtStr("troop_at_info_list"))) {
        ((ChatMessage)localObject1).removeExtInfoToExtStr("troop_at_info_list");
      }
      if (!TextUtils.isEmpty(((ChatMessage)localObject1).getExtInfoFromExtStr("disc_at_info_list"))) {
        ((ChatMessage)localObject1).removeExtInfoToExtStr("disc_at_info_list");
      }
      ((ChatMessage)localObject1).atInfoList = null;
      ((ChatMessage)localObject1).msgseq = paramMessageForStructing.uniseq;
      ((ChatMessage)localObject1).extraflag = 32770;
      if (((ChatMessage)localObject1).msgtype == -1035)
      {
        paramArrayList = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject2 = (MessageRecord)paramArrayList.next();
          ((MessageRecord)localObject2).msgseq = ((ChatMessage)localObject1).msgseq;
          ((MessageRecord)localObject2).isMultiMsg = true;
        }
      }
      if (((ChatMessage)localObject1).msgtype == -2022) {
        ((MessageForShortVideo)localObject1).redBagType = 0;
      }
      localArrayList.add(localObject1);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("preAddMultiMsg, MessageRecord:");
        paramArrayList.append(localChatMessage.toString());
        QLog.d("MultiFavoriteHelper", 2, paramArrayList.toString());
      }
    }
    return localArrayList;
  }
  
  private void a(ChatAdapter1 paramChatAdapter1, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (paramChatAdapter1 == null) {
        return;
      }
      ECommerceDataReportUtil.a(this.b, paramChatMessage, 4);
      if (QLog.isColorLevel()) {
        QLog.d("MultiFavoriteHelper", 2, "favorSingleMsg");
      }
      QfavRequestQueue.a().a = false;
      paramChatAdapter1.c.a(paramChatMessage, paramChatAdapter1).a(2131432813, this.c, paramChatMessage);
      if (QfavRequestQueue.a().a) {
        QfavRequestQueue.a().a = false;
      } else {
        ((Activity)this.c).runOnUiThread(new MultiFavoriteHelper.1(this));
      }
      if (AIOSelectableDelegateImpl.a().l()) {
        AIOSelectableDelegateImpl.a().n();
      }
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, MessageForTroopFile paramMessageForTroopFile)
  {
    if (paramFileManagerEntity != null)
    {
      if (paramMessageForTroopFile == null) {
        return;
      }
      if ((paramFileManagerEntity.fileSize == 0L) && (paramMessageForTroopFile.fileSize > 0L))
      {
        paramFileManagerEntity.fileSize = paramMessageForTroopFile.fileSize;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkPatchEntity, patch size:");
          localStringBuilder.append(paramFileManagerEntity.fileSize);
          QLog.d("qqfav", 2, localStringBuilder.toString());
        }
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.fileName)) && (!TextUtils.isEmpty(paramMessageForTroopFile.fileName)))
      {
        paramFileManagerEntity.fileName = paramMessageForTroopFile.fileName;
        if (QLog.isColorLevel())
        {
          paramMessageForTroopFile = new StringBuilder();
          paramMessageForTroopFile.append("checkPatchEntity, patch name:");
          paramMessageForTroopFile.append(paramFileManagerEntity.fileName);
          QLog.d("qqfav", 2, paramMessageForTroopFile.toString());
        }
      }
    }
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.c))
    {
      QQToast.makeText(this.b.getApp(), 2131889169, 0).show(this.e.A());
      return;
    }
    ECommerceDataReportUtil.a(this.b, paramList, 4);
    MultiMsgManager.a().b(paramList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("multiForwardTogether|checklist.size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
    }
    if (paramList.size() == 0) {
      return;
    }
    this.e.e(2131896471);
    Object localObject = new ArrayList();
    a(paramList, (List)localObject);
    MultiMsgManager.a().c.clear();
    MultiMsgManager.a().c.addAll(paramList);
    MultiMsgManager.a().e = 6;
    if ((this.e instanceof MultiForwardChatPie)) {
      this.f = MultiMsgManager.a().d();
    }
    if (this.f.a == 1) {
      ((ITroopMemberInfoHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(this.f.b, (ArrayList)localObject, false, null);
    } else if ((this.f.a == 0) || (this.f.a == 3000) || (this.f.a == 1000) || (this.f.a == 1004)) {
      ((FriendListHandler)this.b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch((ArrayList)localObject);
    }
    paramList = this.e.j();
    Message localMessage = paramList.obtainMessage(24);
    localMessage.arg1 = ((ArrayList)localObject).size();
    paramList.sendMessageDelayed(localMessage, 30000L);
  }
  
  private void a(List<ChatMessage> paramList, List<String> paramList1)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = MsgProxyUtils.d((ChatMessage)paramList.next());
        if (!paramList1.contains(str)) {
          paramList1.add(str);
        }
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    if (!MultiMsgUtil.a(this.b, paramChatMessage)) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForStructing)) {
      return ((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID == 35;
    }
    if ((paramChatMessage instanceof MessageForArkApp)) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForPic)) && (ZhituManager.a((MessageForPic)paramChatMessage))) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForDLFile))
    {
      paramChatMessage = (MessageForDLFile)paramChatMessage;
      int i = paramChatMessage.deviceType;
      long l = paramChatMessage.associatedId;
      paramChatMessage = this.b.getMessageFacade().d(i).a(l);
      boolean bool1 = bool2;
      if (paramChatMessage != null)
      {
        bool1 = bool2;
        if (FileUtils.fileExistsAndNotEmpty(paramChatMessage.path)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  private boolean a(List<ChatMessage> paramList, int paramInt)
  {
    if (paramList == null) {
      return true;
    }
    if (paramList.size() > paramInt) {
      return false;
    }
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (QfavUtil.a(localChatMessage)) {
        i += ((MessageForStructing)localChatMessage).structingMsg.mTSum;
      } else {
        i += 1;
      }
    }
    return i <= paramInt;
  }
  
  private int b(List<ChatMessage> paramList)
  {
    int j = 0;
    int i = 0;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 0;
      }
      paramList = paramList.iterator();
      for (;;)
      {
        j = i;
        if (!paramList.hasNext()) {
          break;
        }
        if (!a((ChatMessage)paramList.next())) {
          i += 1;
        }
      }
    }
    return j;
  }
  
  public static FileManagerEntity b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    Object localObject;
    if (paramChatMessage != null)
    {
      if (!paramChatMessage.isMultiMsg) {
        return null;
      }
      localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i = Integer.parseInt((String)localObject);
      } else {
        i = -1;
      }
      if ((i != 1) && (i != 2) && (i != 3)) {
        return null;
      }
      localObject = new FileManagerEntity();
      ((FileManagerEntity)localObject).nSessionId = FileManagerUtil.a().longValue();
      ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
      ((FileManagerEntity)localObject).selfUin = paramQQAppInterface.getAccount();
      ((FileManagerEntity)localObject).isReaded = false;
      String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
      if (!TextUtils.isEmpty(str)) {
        ((FileManagerEntity)localObject).busId = Integer.valueOf(str).intValue();
      } else {
        ((FileManagerEntity)localObject).busId = -1;
      }
      ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      if (i == 1)
      {
        ((FileManagerEntity)localObject).peerType = 0;
        ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
      }
      else if (i == 2)
      {
        ((FileManagerEntity)localObject).peerType = 3000;
      }
      else if (i == 3)
      {
        ((FileManagerEntity)localObject).peerType = 1;
      }
      ((FileManagerEntity)localObject).peerNick = FileManagerUtil.a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
      ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
      ((FileManagerEntity)localObject).fileIdCrc = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
      ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        ((FileManagerEntity)localObject).fileSize = Long.parseLong(paramQQAppInterface);
      }
      paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin)) {
        if (((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
          ((FileManagerEntity)localObject).nOpType = 0;
        } else {
          ((FileManagerEntity)localObject).nOpType = 1;
        }
      }
      ((FileManagerEntity)localObject).status = -1;
      paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin)) {
        if (((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
          ((FileManagerEntity)localObject).bSend = false;
        } else {
          ((FileManagerEntity)localObject).bSend = true;
        }
      }
      paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
      if (FileUtils.fileExistsAndNotEmpty(paramQQAppInterface))
      {
        ((FileManagerEntity)localObject).setFilePath(paramQQAppInterface);
        ((FileManagerEntity)localObject).setCloudType(3);
      }
      else
      {
        ((FileManagerEntity)localObject).setCloudType(1);
      }
      ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
      ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
      paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
    }
    try
    {
      ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(paramQQAppInterface);
      label424:
      paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
      try
      {
        ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(paramQQAppInterface);
        return localObject;
      }
      catch (NumberFormatException paramQQAppInterface) {}
      return null;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      break label424;
    }
    return localObject;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onActivityResult");
    }
    if (paramIntent != null)
    {
      long l = paramIntent.getExtras().getLong("requestId", -1L);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult, id:");
        paramIntent.append(l);
        QLog.d("MultiFavoriteHelper", 2, paramIntent.toString());
      }
      QfavRequestQueue.a().a(l);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!paramBoolean) {
      return;
    }
    if (this.a == null)
    {
      this.a = new ImageView(this.c);
      this.a.setId(2131430634);
      if (AppSetting.e) {
        this.a.setContentDescription(HardCodeUtil.a(2131904873));
      }
    }
    paramBaseChatPie = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    paramBaseChatPie.setMargins(paramInt3, 0, 0, 0);
    paramBaseChatPie.gravity = 16;
    this.a.setLayoutParams(paramBaseChatPie);
    this.a.setOnClickListener(this);
    paramBaseChatPie = new StateListDrawable();
    Drawable localDrawable = this.c.getResources().getDrawable(2130839540);
    paramBaseChatPie.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.c.getResources().getDrawable(2130839539);
    paramBaseChatPie.addState(new int[] { 16842910 }, localDrawable);
    this.a.setImageDrawable(paramBaseChatPie);
    if (paramLinearLayout != null) {
      paramLinearLayout.addView(this.a);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, ChatAdapter1 paramChatAdapter1, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onClickMultiFavoriteBtn");
    }
    int i = MultiMsgManager.a().f();
    ReportController.b(this.b, "dc00898", "", "", "0X8009C5B", "0X8009C5B", 0, i, "", "", "", "");
    if (paramMessageForStructing == null)
    {
      paramMessageForStructing = MultiMsgManager.a().i();
      if (paramMessageForStructing.size() == 1)
      {
        ArrayList localArrayList = MultiMsgUtil.a(this.b, (ArrayList)paramMessageForStructing);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          paramMessageForStructing = localArrayList.get(0);
        } else {
          paramMessageForStructing = paramMessageForStructing.get(0);
        }
        a(paramChatAdapter1, (ChatMessage)paramMessageForStructing);
        paramBaseChatPie.a(false, null, false);
        return;
      }
      paramChatAdapter1 = paramMessageForStructing;
      if (paramMessageForStructing.size() == 0) {
        QQToast.makeText(this.b.getApp(), 2131896469, 0).show(paramBaseChatPie.A());
      }
    }
    else
    {
      if (!QfavUtil.a(paramMessageForStructing)) {
        return;
      }
      paramChatAdapter1 = new ArrayList();
      paramChatAdapter1.add(paramMessageForStructing);
    }
    QfavRequestQueue.a().a = true;
    if (!a(paramChatAdapter1, MultiMsgManager.a().c()))
    {
      QQToast.makeText(this.b.getApp(), 2131891505, 0).show(paramBaseChatPie.A());
      return;
    }
    i = b(paramChatAdapter1);
    paramMessageForStructing = paramChatAdapter1;
    if (i > 0)
    {
      if (paramChatAdapter1.size() == i)
      {
        QQToast.makeText(this.b.getApp(), 2131891968, 0).show(paramBaseChatPie.A());
        paramBaseChatPie.a(false, null, false);
        return;
      }
      paramMessageForStructing = this.b.getCurrentUin();
      if (!QfavUtil.c(paramMessageForStructing))
      {
        QfavUtil.b(paramMessageForStructing);
        a(this.c.getString(2131890819), this.c.getString(2131891969), new MultiFavoriteHelper.4(this, paramChatAdapter1, paramBaseChatPie));
        return;
      }
      paramChatAdapter1 = MultiMsgUtil.a(this.b, (ArrayList)paramChatAdapter1);
      if (paramChatAdapter1 != null)
      {
        paramMessageForStructing = paramChatAdapter1;
        if (paramChatAdapter1.size() != 0) {}
      }
      else
      {
        QQToast.makeText(this.b.getApp(), 2131891968, 0).show(paramBaseChatPie.A());
        paramBaseChatPie.a(false, null, false);
        return;
      }
    }
    a(paramMessageForStructing);
    paramBaseChatPie.a(false, null, false);
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    try
    {
      DialogUtil.a(this.d, 230, null, paramString1, "", paramString2, new MultiFavoriteHelper.5(this, paramOnClickListener), null).show();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramInt != 6) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "favorMultiMsg");
    }
    int i = this.f.a;
    boolean bool = true;
    if (i == 0) {
      localObject1 = ContactUtils.a(this.b, this.f.b);
    } else if ((this.f.a != 1) && (this.f.a != 3000)) {
      localObject1 = " ";
    } else {
      localObject1 = this.f.e;
    }
    if ((paramArrayList != null) && (paramArrayList.size() == 1) && (QfavUtil.a((ChatMessage)paramArrayList.get(0))))
    {
      paramArrayList = (MessageForStructing)paramArrayList.get(0);
      localObject1 = null;
    }
    else
    {
      Object localObject2 = this.c;
      if (paramInt == 1) {
        bool = false;
      }
      localObject1 = ChatActivityFacade.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
      if (localObject1 == null) {
        return;
      }
      localObject2 = MultiMsgManager.a().a(this.b, this.f.b, this.f.a, this.f.c, (AbsStructMsg)localObject1);
      localObject1 = a((MessageForStructing)localObject2, paramArrayList);
      if ((localObject1 == null) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        ((Activity)this.c).runOnUiThread(new MultiFavoriteHelper.2(this));
        return;
      }
      paramArrayList = (ArrayList<ChatMessage>)localObject2;
    }
    Object localObject1 = QfavBuilder.a(this.b, paramArrayList, (List)localObject1, paramMap);
    if (localObject1 != null)
    {
      ((QfavBuilder)localObject1).b(this.b, paramArrayList);
      paramMap = this.b.getAccount();
      bool = ((QfavBuilder)localObject1).b((Activity)this.c, paramMap, 18000, null);
      if (!bool)
      {
        QfavRequestQueue.a().a(-1L);
        paramArrayList = ((QfavBuilder)localObject1).b();
        if (paramArrayList != null)
        {
          paramArrayList = this.c.getString(paramArrayList.getIntExtra("nReasonInt", 2131889173));
          ((Activity)this.c).runOnUiThread(new MultiFavoriteHelper.3(this, paramMap, bool, paramArrayList));
        }
      }
      else
      {
        QfavHelper.a(this.c, paramMap, bool, null, false);
      }
    }
    else
    {
      QLog.e("MultiFavoriteHelper", 2, "builder == null");
    }
  }
  
  public String getTag()
  {
    return "MultiFavoriteHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18000) {
      a(paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430634)
    {
      MultiFavoriteHelper localMultiFavoriteHelper = (MultiFavoriteHelper)this.e.q(11);
      BaseChatPie localBaseChatPie = this.e;
      localMultiFavoriteHelper.a(localBaseChatPie, localBaseChatPie.V, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper
 * JD-Core Version:    0.7.0.1
 */