package com.tencent.mobileqq.app.friendlist;

import KQQ.ProfSmpInfoRes;
import QQService.VipBaseInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class FriendListHandlerUtil
{
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(ProfSmpInfoRes paramProfSmpInfoRes, boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramBoolean)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
      localStringBuilder.append(paramString);
      localMobileQQ.setProperty(localStringBuilder.toString(), paramProfSmpInfoRes.strNick);
    }
    if ((paramProfSmpInfoRes.cBusiCardFlag == 1) && (paramBoolean))
    {
      paramProfSmpInfoRes = (BusinessCardManager)paramQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
      if (paramProfSmpInfoRes != null)
      {
        BusinessCardServlet.a(paramQQAppInterface, paramProfSmpInfoRes.a(), 0, true);
        paramProfSmpInfoRes.a(1, true);
      }
    }
  }
  
  public static void a(FriendListHandler paramFriendListHandler, ToServiceMsg paramToServiceMsg, ProfSmpInfoRes paramProfSmpInfoRes, List<Object[]> paramList, String paramString)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqDateNick", false))
    {
      Object localObject = paramProfSmpInfoRes.sDateNick;
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramToServiceMsg = paramProfSmpInfoRes.strNick;
      }
      localObject = paramToServiceMsg;
      if (TextUtils.isEmpty(paramToServiceMsg)) {
        localObject = paramString;
      }
      paramList.add(new Object[] { paramString, localObject, Byte.valueOf(paramProfSmpInfoRes.cSex) });
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("$handleFriendInfo add to nickSaveList| uin=");
        paramToServiceMsg.append(paramString);
        paramToServiceMsg.append(" | datenick = ");
        paramToServiceMsg.append(paramProfSmpInfoRes.sDateNick);
        paramToServiceMsg.append(" | nick=");
        paramToServiceMsg.append(paramProfSmpInfoRes.strNick);
        QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
      }
      paramFriendListHandler.notifyUI(87, true, new Object[] { paramString, localObject });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ProfSmpInfoRes paramProfSmpInfoRes, Card paramCard, String paramString, ArrayList<String> paramArrayList)
  {
    paramCard.nFaceID = paramProfSmpInfoRes.wFace;
    paramCard.shGender = ((short)paramProfSmpInfoRes.cSex);
    paramCard.age = paramProfSmpInfoRes.wAge;
    if (paramProfSmpInfoRes.strNick != null) {
      paramCard.strNick = paramProfSmpInfoRes.strNick;
    }
    if (paramProfSmpInfoRes.sCountry != null) {
      paramCard.strCountry = paramProfSmpInfoRes.sCountry;
    }
    if (paramProfSmpInfoRes.sProvince != null) {
      paramCard.strProvince = paramProfSmpInfoRes.sProvince;
    }
    if (paramProfSmpInfoRes.sCity != null) {
      paramCard.strCity = paramProfSmpInfoRes.sCity;
    }
    if ((paramString.equals(paramQQAppInterface.getCurrentAccountUin())) && (paramProfSmpInfoRes.wLevel != 0)) {
      paramCard.iQQLevel = paramProfSmpInfoRes.wLevel;
    }
    if ((paramProfSmpInfoRes.isShowXMan != -1) && (paramProfSmpInfoRes.dwLoginDay >= 0L) && (paramProfSmpInfoRes.dwPhoneQQXManDay > 0L))
    {
      if (paramString.equals(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramCard.lLoginDays = paramProfSmpInfoRes.dwLoginDay;
        paramCard.lQQMasterLogindays = paramProfSmpInfoRes.dwPhoneQQXManDay;
        paramCard.iXManScene1DelayTime = paramProfSmpInfoRes.iXManScene1DelayTime;
        paramCard.iXManScene2DelayTime = paramProfSmpInfoRes.iXManScene2DelayTime;
        boolean bool;
        if (paramProfSmpInfoRes.isShowXMan == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramCard.setXManFlag(bool);
      }
      if (paramArrayList.size() == 1)
      {
        if (!paramString.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramCard.allowPeopleSee = paramProfSmpInfoRes.bOpenLoginDays;
        }
        paramCard.allowClick = paramProfSmpInfoRes.bXManIconClick;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, ProfSmpInfoRes paramProfSmpInfoRes)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
    {
      ContactConfig.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("$handleFriendInfo | iQQLevel = ");
        paramQQAppInterface.append(paramProfSmpInfoRes.wLevel);
        QLog.d("FriendListHandler", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ByteBuffer paramByteBuffer, long paramLong, int paramInt)
  {
    if ((paramInt == 20059) && (paramByteBuffer.getShort() == 4))
    {
      paramInt = paramByteBuffer.getInt();
      if ((paramInt >= 0) && (String.valueOf(paramLong).equals(paramQQAppInterface.getCurrentAccountUin())))
      {
        ((BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).a(paramInt, true);
        ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramInt);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<Object[]> paramList)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object[] arrayOfObject = (Object[])paramList.next();
      try
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleFriendInfo handle nickSaveList:");
          localStringBuilder.append(arrayOfObject[0]);
          localStringBuilder.append(", ");
          localStringBuilder.append(arrayOfObject[1]);
          localStringBuilder.append(", ");
          localStringBuilder.append(arrayOfObject[2]);
          QLog.i("FriendListHandler", 2, localStringBuilder.toString());
        }
        paramQQAppInterface.a((String)arrayOfObject[0], (String)arrayOfObject[1], ((Byte)arrayOfObject[2]).byteValue());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleFriendInfo saveDateNickByUin err");
          localStringBuilder.append(localException);
          QLog.e("FriendListHandler", 2, localStringBuilder.toString(), localException);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleFriendInfo saveDateNickByUin err");
          localStringBuilder.append(localException);
          QLog.i("FriendListHandler", 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean)
    {
      paramQQAppInterface = (EnterpriseQQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(SystemClock.uptimeMillis());
      }
    }
  }
  
  public static boolean a(ByteBuffer paramByteBuffer, ExtensionInfo paramExtensionInfo, int paramInt)
  {
    if ((paramInt == 27025) && (paramByteBuffer.getShort() == 8))
    {
      long l = paramByteBuffer.getLong();
      if (paramExtensionInfo.pendantId != l)
      {
        paramExtensionInfo.pendantId = l;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        return true;
      }
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, ProfSmpInfoRes paramProfSmpInfoRes)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqXMan", false))
    {
      Context localContext = paramQQAppInterface.getApp().getApplicationContext();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      ContactConfig.b(localContext, paramQQAppInterface, System.currentTimeMillis());
      if (paramToServiceMsg.extraData.getInt("getXManInfoScene", 0) == 2) {
        ContactConfig.c(localContext, paramQQAppInterface, System.currentTimeMillis());
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("$handleFriendInfo | dwLoginDay=");
        paramQQAppInterface.append(paramProfSmpInfoRes.dwLoginDay);
        paramQQAppInterface.append(" | dwPhoneQQXManDay=");
        paramQQAppInterface.append(paramProfSmpInfoRes.dwPhoneQQXManDay);
        paramQQAppInterface.append(" | isShowXMan=");
        paramQQAppInterface.append(paramProfSmpInfoRes.isShowXMan);
        paramQQAppInterface.append(" | iXManScene1DelayTime=");
        paramQQAppInterface.append(paramProfSmpInfoRes.iXManScene1DelayTime);
        paramQQAppInterface.append(" | iXManScene2DelayTime=");
        paramQQAppInterface.append(paramProfSmpInfoRes.iXManScene2DelayTime);
        QLog.d("FriendListHandler", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        try
        {
          Object localObject = paramQQAppInterface.getMessageFacade().a(str, 0);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019) || (localMessageRecord.msgtype == -7006)) {
                paramQQAppInterface.getMessageFacade().b(str, 0, localMessageRecord.uniseq);
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean b(ByteBuffer paramByteBuffer, ExtensionInfo paramExtensionInfo, int paramInt)
  {
    if ((paramInt == 27201) && (paramByteBuffer.getShort() == 4))
    {
      long l = paramByteBuffer.getInt();
      if ((paramExtensionInfo.uVipFont != FontManagerConstants.parseFontId(l)) || (paramExtensionInfo.vipFontType != FontManagerConstants.parseFontType(l)))
      {
        paramExtensionInfo.uVipFont = FontManagerConstants.parseFontId(l);
        paramExtensionInfo.vipFontType = FontManagerConstants.parseFontType(l);
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        return true;
      }
    }
    return false;
  }
  
  public static boolean c(ByteBuffer paramByteBuffer, ExtensionInfo paramExtensionInfo, int paramInt)
  {
    if ((paramInt == 27041) && (paramByteBuffer.getShort() == 4))
    {
      paramInt = paramByteBuffer.getInt();
      long l1 = paramExtensionInfo.colorRingId;
      long l2 = paramInt;
      if (l1 != l2)
      {
        paramExtensionInfo.colorRingId = l2;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.FriendListHandlerUtil
 * JD-Core Version:    0.7.0.1
 */