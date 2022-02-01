package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.IUpLoadMsgPackBusinessType;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.vas.VipLongMsgShareDomainHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QZoneConfigHelper;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShareStructLongMessageManager
  implements IUpLoadMsgPackBusinessType
{
  public static int a = 800;
  private static ShareStructLongMessageManager a;
  public static int b = 700;
  
  public static ShareStructLongMessageManager a()
  {
    if (a == null) {
      a = new ShareStructLongMessageManager();
    }
    return a;
  }
  
  public static String a(AbsStructMsg paramAbsStructMsg)
  {
    if (((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramAbsStructMsg).mIsPAVideoStructMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "is video struct msg");
      }
      return null;
    }
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl)) {
      return paramAbsStructMsg.mMsgUrl;
    }
    if (AIOGallerySceneWithBusiness.b(paramAbsStructMsg.mMsgActionData))
    {
      paramAbsStructMsg = AIOGallerySceneWithBusiness.b(paramAbsStructMsg.mMsgActionData);
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.length > 2)) {
        return paramAbsStructMsg[1];
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "url is empty");
      }
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("article_id");
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return str;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sendLongTextMsg]data.length = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      QLog.d("ShareStructLongMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new TransferRequest();
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mFileType = 131078;
    ((TransferRequest)localObject).multiMsgType = 1;
    ((TransferRequest)localObject).toSendData = paramArrayOfByte;
    ((TransferRequest)localObject).mSelfUin = paramString1;
    ((TransferRequest)localObject).mPeerUin = paramString2;
    ((TransferRequest)localObject).mSecondId = paramString3;
    ((TransferRequest)localObject).mUinType = paramInt1;
    ((TransferRequest)localObject).mUniseq = paramLong;
    ((TransferRequest)localObject).mBusiType = paramInt2;
    ((TransferRequest)localObject).mUpCallBack = paramUpCallBack;
    ((TransferRequest)localObject).upMsgBusiType = a();
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    return true;
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if ("micro_app".equals(paramAbsStructMsg.mMsg_A_ActionData)) {
        return true;
      }
      Object localObject = (StructMsgForGeneralShare)paramAbsStructMsg;
      if (((StructMsgForGeneralShare)localObject).needSendLongMsgWhenFailed) {
        return true;
      }
      if (((StructMsgForGeneralShare)localObject).mIsPAVideoStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)localObject).mMsgServiceID == 118)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "tribe matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)localObject).mMsgServiceID == 35)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "MULTI_MSG matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)localObject).mMsgServiceID == 83)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "gallery matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)localObject).mMsgServiceID == 123)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "confess general share msg matches!");
        }
        return true;
      }
      if ((((StructMsgForGeneralShare)localObject).mMsgServiceID != 151) && (((StructMsgForGeneralShare)localObject).mMsgServiceID != 156))
      {
        if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))
        {
          localObject = paramAbsStructMsg.mMsgUrl;
          try
          {
            Uri localUri = Uri.parse((String)localObject);
            if (VipLongMsgShareDomainHelper.a().a(localUri.getHost())) {
              return true;
            }
            bool = QZoneConfigHelper.c(localUri.getHost());
            if (!bool) {
              break label286;
            }
            return true;
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("shouldShareStructLongMessage vip url exception, url = ");
            localStringBuilder.append((String)localObject);
            QLog.e("ShareStructLongMessageManager", 1, localStringBuilder.toString(), localException);
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "STRUCT_TYPE_NEW_SUBSCRIBE_ACCOUNT_NEWS share msg matches!");
        }
        return true;
      }
    }
    label286:
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))
    {
      if (Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAbsStructMsg.mMsgUrl).matches())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
        }
        return true;
      }
      if (Pattern.compile("https://.*.mp.qq.com.*").matcher(paramAbsStructMsg.mMsgUrl).matches())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
        }
        return true;
      }
    }
    try
    {
      paramAbsStructMsg = new URL(paramAbsStructMsg.mMsgUrl).getHost();
      bool = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).checkNeedLongMessageChannel(paramAbsStructMsg);
      if (!bool) {
        break label415;
      }
      return true;
    }
    catch (Exception paramAbsStructMsg)
    {
      break label415;
    }
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData)) {
      return b(paramAbsStructMsg);
    }
    label415:
    return false;
  }
  
  public static boolean b(AbsStructMsg paramAbsStructMsg)
  {
    if (AIOGallerySceneWithBusiness.b(paramAbsStructMsg.mMsgActionData))
    {
      paramAbsStructMsg = AIOGallerySceneWithBusiness.b(paramAbsStructMsg.mMsgActionData);
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.length > 2))
      {
        paramAbsStructMsg = paramAbsStructMsg[1];
        if (!TextUtils.isEmpty(paramAbsStructMsg))
        {
          if (Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAbsStructMsg).matches())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShareStructLongMessageManager", 2, "matches!");
            }
            return true;
          }
          if (Pattern.compile("https://.*.mp.qq.com.*").matcher(paramAbsStructMsg).matches())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShareStructLongMessageManager", 2, "matches!");
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.getMsgCache().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramMessageRecord.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("step2: sendShareStructLongMessage saveMessage end and pack ShareStructLongMessage start currenttime:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("ShareStructLongMessageManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (!(paramMessageRecord instanceof MessageForStructing))
    {
      QLog.d("ShareStructLongMessageManager", 2, "is not MessageForStructing");
      return;
    }
    Object localObject1 = ((MessageForStructing)paramMessageRecord).structingMsg.getXmlBytes();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("buff is ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("ShareStructLongMessageManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = a((byte[])localObject1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buffer is ");
      localStringBuilder.append((String)localObject2);
      QLog.d("ShareStructLongMessageManager", 2, localStringBuilder.toString());
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "step2: sendShareStructLongMessage pack failed! packData is null.............................");
      }
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.getMsgCache().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      paramMessageObserver = paramMessageRecord.frienduin;
      int i = paramMessageRecord.istroop;
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramMessageRecord.istroop), false, new Object[] { paramMessageObserver, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
    }
    paramBoolean = a(paramQQAppInterface, (byte[])localObject1, paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin, paramMessageRecord.selfuin, paramMessageRecord.istroop, paramMessageRecord.uniseq + 1L, 1035, new ShareStructLongMessageManager.1(this, paramMessageRecord, paramQQAppInterface, paramMessageObserver, paramBoolean));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage successful, uploadShareStructLongMessagePkg start!");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessageObserver = new StringBuilder();
        paramMessageObserver.append("sendShareStructLongMessage failed! isSuccess:");
        paramMessageObserver.append(paramBoolean);
        QLog.d("ShareStructLongMessageManager", 2, paramMessageObserver.toString());
      }
      a(paramQQAppInterface, paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareStructLongMessageManager
 * JD-Core Version:    0.7.0.1
 */