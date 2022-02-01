package com.tencent.mobileqq.activity.troop.config;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi.FeedItem;
import com.tencent.mobileqq.troop.announcement.api.TroopAnnouncementObserver;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.config.AbsTroopAnnouncementProcessor;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class TroopAnnouncementProcessor
  extends AbsTroopAnnouncementProcessor
{
  private static String a = "TroopAnnouncementProcessor";
  
  private TroopNotificationCache a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, DataInputStream paramDataInputStream)
  {
    for (;;)
    {
      try
      {
        paramDataInputStream.readInt();
        paramDataInputStream.readInt();
        int i = paramDataInputStream.readShort();
        paramDataInputStream.readShort();
        if (paramInt1 != 23) {
          break label180;
        }
        bool = true;
        paramDataInputStream = ((ITroopAnnouncementHandler)paramQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).a(paramDataInputStream, bool);
        if (paramDataInputStream != null)
        {
          if (paramInt1 == 23)
          {
            paramQQAppInterface = a(paramDataInputStream, paramDataInputStream.jdField_b_of_type_JavaLangString, i, paramInt2, paramLong);
            if ((paramQQAppInterface == null) || (!TextUtils.isEmpty(paramQQAppInterface.title))) {
              break;
            }
            paramQQAppInterface.title = paramDataInputStream.jdField_c_of_type_JavaLangString;
            return paramQQAppInterface;
          }
          if ((!TroopNotificationHelper.a(paramQQAppInterface, Long.toString(paramLong), paramDataInputStream.jdField_b_of_type_JavaLangString)) && (paramBoolean)) {
            TroopNotificationHelper.a(paramQQAppInterface, paramDataInputStream.jdField_b_of_type_JavaLangString, Long.toString(paramLong), 2);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramQQAppInterface.getMessage());
        }
      }
      return null;
      label180:
      boolean bool = false;
    }
    return paramQQAppInterface;
  }
  
  private static TroopNotificationCache a(ITroopAnnouncementHelperApi.FeedItem paramFeedItem, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramFeedItem != null)
    {
      if (paramFeedItem.jdField_a_of_type_Int == 1)
      {
        String str2 = a(paramFeedItem.jdField_c_of_type_JavaLangString);
        int i = str2.lastIndexOf('&');
        String str1 = str2;
        if (i != -1)
        {
          str1 = str2;
          if (str2.indexOf(";", i) == -1) {
            str1 = str2.substring(0, i - 1);
          }
        }
        str2 = a(paramFeedItem.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(paramFeedItem.jdField_a_of_type_JavaLangString))
        {
          str2 = new SimpleDateFormat("yyyy年M月d日").format(new Date(paramFeedItem.jdField_c_of_type_Int * 1000L));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(" 群公告");
          str2 = ((StringBuilder)localObject).toString();
        }
        paramString = String.format("https://web.qun.qq.com/mannounce/index.html?_wv=1031&amp;_bid=148#gc=%d&amp;feedType=%d&amp;gotoFid=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString });
        Object localObject = new TroopNotificationCache();
        ((TroopNotificationCache)localObject).title = paramFeedItem.jdField_a_of_type_JavaLangString;
        ((TroopNotificationCache)localObject).feedType = paramInt1;
        ((TroopNotificationCache)localObject).appId = paramInt2;
        ((TroopNotificationCache)localObject).userUin = paramFeedItem.jdField_a_of_type_Long;
        ((TroopNotificationCache)localObject).troopUin = paramLong;
        ((TroopNotificationCache)localObject).time = paramFeedItem.jdField_c_of_type_Int;
        ((TroopNotificationCache)localObject).feedsId = paramFeedItem.jdField_b_of_type_JavaLangString;
        ((TroopNotificationCache)localObject).serviceID = 27;
        ((TroopNotificationCache)localObject).needConfirm = paramFeedItem.jdField_a_of_type_Boolean;
        String str3 = new SimpleDateFormat("M-d HH:mm").format(new Date(((TroopNotificationCache)localObject).time * 1000L));
        if (TextUtils.isEmpty(paramFeedItem.jdField_d_of_type_JavaLangString))
        {
          ((TroopNotificationCache)localObject).xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"1\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, str3, str1 }).getBytes();
          return localObject;
        }
        ((TroopNotificationCache)localObject).xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"6\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /></item><item layout=\"2\"><picture cover=\"%s\"/><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, paramFeedItem.jdField_d_of_type_JavaLangString, str3, str1 }).getBytes();
        return localObject;
      }
      if (paramFeedItem.jdField_a_of_type_Int == 2)
      {
        paramString = new TroopNotificationCache();
        paramString.feedType = paramInt1;
        paramString.appId = paramInt2;
        paramString.userUin = paramFeedItem.jdField_a_of_type_Long;
        paramString.troopUin = paramLong;
        paramString.time = paramFeedItem.jdField_c_of_type_Int;
        paramString.feedsId = paramFeedItem.jdField_b_of_type_JavaLangString;
        paramString.ctrlStr = paramFeedItem.jdField_e_of_type_JavaLangString;
        paramString.xmlBytes = paramFeedItem.jdField_a_of_type_ArrayOfByte;
        paramString.src = paramFeedItem.jdField_d_of_type_Int;
        paramString.filterID = paramFeedItem.jdField_b_of_type_Long;
        paramString.serviceID = 20;
        return paramString;
      }
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return a(a(a(a(a(paramString, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "'", "&apos;"), "\"", "&quot;");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return null;
    }
    int i = paramString1.indexOf(paramString2);
    String str = paramString1;
    if (i >= 0)
    {
      str = "";
      while (i >= 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramString1.substring(0, i));
        localStringBuilder.append(paramString3);
        str = localStringBuilder.toString();
        paramString1 = paramString1.substring(i + paramString2.length());
        i = paramString1.indexOf(paramString2);
      }
      paramString2 = new StringBuilder();
      paramString2.append(str);
      paramString2.append(paramString1);
      str = paramString2.toString();
    }
    return str;
  }
  
  public void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, int paramInt, ITroopAnnouncementHelperApi.FeedItem paramFeedItem, String paramString)
  {
    if (paramFeedItem != null)
    {
      TroopNotificationCache localTroopNotificationCache = null;
      if ((paramFeedItem.jdField_a_of_type_Int == 1) || (paramFeedItem.jdField_a_of_type_Int == 2)) {
        localTroopNotificationCache = a(paramFeedItem, paramString, 23, paramInt, paramLong2);
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        paramAppInterface = (QQAppInterface)paramAppInterface;
        paramString = paramAppInterface.getMessageFacade();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localTroopNotificationCache);
        paramInt = (int)MessageCache.a();
        paramString.a().a(paramAppInterface, String.valueOf(paramLong1), String.valueOf(paramLong2), localArrayList, 23, paramInt, paramFeedItem.jdField_e_of_type_Int, paramFeedItem.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, DataInputStream paramDataInputStream)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      paramDataInputStream = a(paramAppInterface, paramLong2, paramInt2, paramInt1, paramBoolean, paramDataInputStream);
      if ((paramInt2 == 23) && (paramDataInputStream != null))
      {
        ((ITroopAnnouncementHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).a(TroopAnnouncementObserver.b, true, paramDataInputStream);
        return;
      }
      if ((paramInt2 == 34) && (paramDataInputStream != null))
      {
        QQMessageFacade localQQMessageFacade = paramAppInterface.getMessageFacade();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramDataInputStream);
        paramInt1 = (int)MessageCache.a();
        localQQMessageFacade.a().a(paramAppInterface, String.valueOf(paramLong1), String.valueOf(paramLong2), localArrayList, 34, paramInt1, 0, paramString);
        paramAppInterface = paramAppInterface.getHandler(Conversation.class);
        if (paramAppInterface != null) {
          paramAppInterface.sendEmptyMessage(1009);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopAnnouncementProcessor
 * JD-Core Version:    0.7.0.1
 */