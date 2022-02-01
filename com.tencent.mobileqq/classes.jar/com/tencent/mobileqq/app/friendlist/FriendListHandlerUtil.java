package com.tencent.mobileqq.app.friendlist;

import KQQ.ProfSmpInfoRes;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class FriendListHandlerUtil
{
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(paramInt1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.iVipLevel != -1) && (paramVipBaseInfo.iVipType != -1)) {}
    }
    else
    {
      return paramInt2;
    }
    if (paramVipBaseInfo.bOpen) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return (paramInt1 << 8 | (byte)paramVipBaseInfo.iVipType & 0xFF) << 16 | (short)paramVipBaseInfo.iVipLevel;
    }
  }
  
  public static void a(ProfSmpInfoRes paramProfSmpInfoRes, boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramBoolean) {
      paramQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + paramString, paramProfSmpInfoRes.strNick);
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
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleFriendInfo add to nickSaveList| uin=" + paramString + " | datenick = " + paramProfSmpInfoRes.sDateNick + " | nick=" + paramProfSmpInfoRes.strNick);
      }
      paramFriendListHandler.notifyUI(89, true, new Object[] { paramString, localObject });
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
    if ((paramProfSmpInfoRes.isShowXMan != -1) && (paramProfSmpInfoRes.dwLoginDay >= 0L) && (paramProfSmpInfoRes.dwPhoneQQXManDay > 0L)) {
      if (paramString.equals(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramCard.lLoginDays = paramProfSmpInfoRes.dwLoginDay;
        paramCard.lQQMasterLogindays = paramProfSmpInfoRes.dwPhoneQQXManDay;
        paramCard.iXManScene1DelayTime = paramProfSmpInfoRes.iXManScene1DelayTime;
        paramCard.iXManScene2DelayTime = paramProfSmpInfoRes.iXManScene2DelayTime;
        if (paramProfSmpInfoRes.isShowXMan != 1) {
          break label234;
        }
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      paramCard.setXManFlag(bool);
      if (paramArrayList.size() == 1)
      {
        if (!paramString.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramCard.allowPeopleSee = paramProfSmpInfoRes.bOpenLoginDays;
        }
        paramCard.allowClick = paramProfSmpInfoRes.bXManIconClick;
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, ProfSmpInfoRes paramProfSmpInfoRes)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
    {
      ContactConfig.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleFriendInfo | iQQLevel = " + paramProfSmpInfoRes.wLevel);
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
        ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramInt);
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
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleFriendInfo handle nickSaveList:" + arrayOfObject[0] + ", " + arrayOfObject[1] + ", " + arrayOfObject[2]);
        }
        paramQQAppInterface.a((String)arrayOfObject[0], (String)arrayOfObject[1], ((Byte)arrayOfObject[2]).byteValue());
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FriendListHandler", 2, "handleFriendInfo saveDateNickByUin err" + localException, localException);
        } else {
          QLog.i("FriendListHandler", 1, "handleFriendInfo saveDateNickByUin err" + localException);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 27025)
    {
      bool1 = bool2;
      if (paramByteBuffer.getShort() == 8)
      {
        long l = paramByteBuffer.getLong();
        bool1 = bool2;
        if (paramExtensionInfo.pendantId != l)
        {
          paramExtensionInfo.pendantId = l;
          paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
          bool1 = true;
        }
      }
    }
    return bool1;
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
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleFriendInfo | dwLoginDay=" + paramProfSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay=" + paramProfSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan=" + paramProfSmpInfoRes.isShowXMan + " | iXManScene1DelayTime=" + paramProfSmpInfoRes.iXManScene1DelayTime + " | iXManScene2DelayTime=" + paramProfSmpInfoRes.iXManScene2DelayTime);
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
          Object localObject = paramQQAppInterface.getMessageFacade().b(str, 0);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 27201)
    {
      bool1 = bool2;
      if (paramByteBuffer.getShort() == 4)
      {
        long l = paramByteBuffer.getInt();
        if (paramExtensionInfo.uVipFont == FontManager.a(l))
        {
          bool1 = bool2;
          if (paramExtensionInfo.vipFontType == FontManager.b(l)) {}
        }
        else
        {
          paramExtensionInfo.uVipFont = FontManager.a(l);
          paramExtensionInfo.vipFontType = FontManager.b(l);
          paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(ByteBuffer paramByteBuffer, ExtensionInfo paramExtensionInfo, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 27041)
    {
      bool1 = bool2;
      if (paramByteBuffer.getShort() == 4)
      {
        paramInt = paramByteBuffer.getInt();
        bool1 = bool2;
        if (paramExtensionInfo.colorRingId != paramInt)
        {
          paramExtensionInfo.colorRingId = paramInt;
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.FriendListHandlerUtil
 * JD-Core Version:    0.7.0.1
 */