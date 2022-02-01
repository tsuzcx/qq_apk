package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Iterator;

public class AdEmoReportUtil
{
  public int a(BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramBaseSessionInfo == null) {
      return 0;
    }
    int i = paramBaseSessionInfo.a;
    if (i == 1) {
      return 1;
    }
    if (i == 0) {
      return 2;
    }
    if (BaseChatActivityUtils.a(i)) {
      return 3;
    }
    return 4;
  }
  
  public void a(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null))
    {
      if (paramMessageForPic == null) {
        return;
      }
      if (!((IEmosmService)QRoute.api(IEmosmService.class)).hasReported(paramMessageForPic, "0X800B126"))
      {
        String str2 = paramMessageForPic.picExtraData.mAdEmoDescStr;
        String str1 = paramMessageForPic.md5;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportTailShow, picMsg.uniseq = ");
          localStringBuilder.append(paramMessageForPic.uniseq);
          QLog.d("AdEmoReportUtil", 2, localStringBuilder.toString());
        }
        paramMessageForPic = paramBaseSessionInfo.b;
        int i = a(paramBaseSessionInfo);
        if (str1 == null) {
          paramBaseSessionInfo = "";
        } else {
          paramBaseSessionInfo = str1;
        }
        a(paramAppInterface, paramMessageForPic, "0X800B126", "0X800B126", i, "", paramBaseSessionInfo, str2);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, PicReq paramPicReq)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null))
    {
      if (paramPicReq == null) {
        return;
      }
      if ((paramPicReq.i != null) && (paramPicReq.i.imageBizType == 9))
      {
        if ((paramPicReq.h != null) && (paramPicReq.h.b != null) && (paramPicReq.h.b.m != null)) {
          paramPicReq = paramPicReq.h.b.m;
        } else {
          paramPicReq = "";
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdEmoReportUtil", 2, "reportForwardSingleAdEmo ");
        }
        a(paramAppInterface, paramBaseSessionInfo.b, "0X800B128", "0X800B128", 1, "", paramPicReq, "");
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null))
    {
      if (paramString == null) {
        return;
      }
      int i = a(paramBaseSessionInfo);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportHitKeyWord, keyword = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", sessionType = ");
        localStringBuilder.append(i);
        QLog.d("AdEmoReportUtil", 2, localStringBuilder.toString());
      }
      a(paramAppInterface, paramBaseSessionInfo.b, "0X800B123", "0X800B123", i, "", "", paramString);
    }
  }
  
  public void a(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportAdEmoShow, imgUrl = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" , index = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" , imgMd5 = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" , keyWord = ");
        localStringBuilder.append(paramString3);
        QLog.d("AdEmoReportUtil", 2, localStringBuilder.toString());
      }
      a(paramAppInterface, paramBaseSessionInfo.b, "0X800B124", paramString1, a(paramBaseSessionInfo), String.valueOf(paramInt + 1), paramString2, paramString3);
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doReport, fromUin = ");
      String str;
      if ((paramAppInterface != null) && (paramAppInterface.getCurrentAccountUin() != null)) {
        str = paramAppInterface.getCurrentAccountUin();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", toUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" , subAction = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", actionName = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" , fromType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ,r2 = ");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(" , r4 = ");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" , r5 = ");
      localStringBuilder.append(paramString6);
      QLog.d("AdEmoReportUtil", 2, localStringBuilder.toString());
    }
    ReportController.b(paramAppInterface, "dc00898", "", paramString1, paramString2, paramString3, paramInt, 0, paramString4, "", paramString5, paramString6);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if ((paramAppInterface != null) && (paramString != null))
    {
      if (paramArrayList == null) {
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = (ChatMessage)localIterator.next();
        if (a(paramArrayList))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("reportForwardAdEmoMulti, picMsg.uniseq = ");
            ((StringBuilder)localObject).append(paramArrayList.uniseq);
            QLog.d("AdEmoReportUtil", 2, ((StringBuilder)localObject).toString());
          }
          Object localObject = ((MessageForPic)paramArrayList).md5;
          paramArrayList = (ArrayList<ChatMessage>)localObject;
          if (localObject == null) {
            paramArrayList = "";
          }
          a(paramAppInterface, paramString, "0X800B128", "0X800B128", paramInt, "", paramArrayList, "");
        }
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramChatMessage instanceof MessageForPic))
    {
      paramChatMessage = (MessageForPic)paramChatMessage;
      bool1 = bool2;
      if (paramChatMessage.picExtraData != null)
      {
        bool1 = bool2;
        if (paramChatMessage.picExtraData.imageBizType == 9) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null))
    {
      if (paramMessageForPic == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportTailClick, picMsg.uniseq = ");
        ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
        QLog.d("AdEmoReportUtil", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramMessageForPic.md5;
      paramMessageForPic = paramMessageForPic.picExtraData.mAdEmoDescStr;
      String str = paramBaseSessionInfo.b;
      int i = a(paramBaseSessionInfo);
      paramBaseSessionInfo = (BaseSessionInfo)localObject;
      if (localObject == null) {
        paramBaseSessionInfo = "";
      }
      a(paramAppInterface, str, "0X800B127", "0X800B127", i, "", paramBaseSessionInfo, paramMessageForPic);
    }
  }
  
  public void b(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportAdEmoSend, imgUrl = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" , index = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" , imgMd5 = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" , keyWord = ");
        localStringBuilder.append(paramString3);
        QLog.d("AdEmoReportUtil", 2, localStringBuilder.toString());
      }
      a(paramAppInterface, paramBaseSessionInfo.b, "0X800B125", paramString1, a(paramBaseSessionInfo), String.valueOf(paramInt + 1), paramString2, paramString3);
      return;
    }
  }
  
  public void c(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForPic paramMessageForPic)
  {
    if (paramAppInterface != null)
    {
      if (paramMessageForPic == null) {
        return;
      }
      if (a(paramMessageForPic))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportAdEmoAddFav, picMsg.uniseq = ");
          ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
          QLog.d("AdEmoReportUtil", 2, ((StringBuilder)localObject).toString());
        }
        paramMessageForPic = paramMessageForPic.md5;
        if (paramBaseSessionInfo == null)
        {
          if (paramMessageForPic == null) {
            paramMessageForPic = "";
          }
          a(paramAppInterface, "", "0X800B129", "0X800B129", 0, "", paramMessageForPic, "");
          return;
        }
        Object localObject = paramBaseSessionInfo.b;
        int i = a(paramBaseSessionInfo);
        if (paramMessageForPic == null) {
          paramMessageForPic = "";
        }
        a(paramAppInterface, (String)localObject, "0X800B129", "0X800B129", i, "", paramMessageForPic, "");
      }
    }
  }
  
  public void d(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramAppInterface != null) && (paramBaseSessionInfo != null))
    {
      if (paramMessageForPic == null) {
        return;
      }
      if (a(paramMessageForPic))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportEnterAdEmo, picMsg.uniseq = ");
          ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
          QLog.d("AdEmoReportUtil", 2, ((StringBuilder)localObject).toString());
        }
        paramMessageForPic = paramMessageForPic.md5;
        Object localObject = paramBaseSessionInfo.b;
        int i = a(paramBaseSessionInfo);
        paramBaseSessionInfo = paramMessageForPic;
        if (paramMessageForPic == null) {
          paramBaseSessionInfo = "";
        }
        a(paramAppInterface, (String)localObject, "0X800B12A", "0X800B12A", i, "", paramBaseSessionInfo, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoReportUtil
 * JD-Core Version:    0.7.0.1
 */