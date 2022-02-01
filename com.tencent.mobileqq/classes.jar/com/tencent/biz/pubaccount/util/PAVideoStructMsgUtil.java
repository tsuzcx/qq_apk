package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

public class PAVideoStructMsgUtil
{
  public static StructMsgItemVideo a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      return b(paramMessageRecord.structingMsg);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject3 = ReadInJoyConstants.l;
    Object localObject1 = localObject3;
    Object localObject2;
    if (paramBoolean) {
      try
      {
        localObject1 = URLDecoder.decode(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getPersonalHomePageWebUrl(), "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("PAVideoStructMsgUtil", 1, "getJumpURL4WebSubscribeAccount error,", localUnsupportedEncodingException);
        localObject2 = localObject3;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localObject2);
    ((StringBuilder)localObject3).append(Base64Util.encodeToString(paramString.getBytes(), 2));
    return ((StringBuilder)localObject3).toString();
  }
  
  public static void a(StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    if (paramStructMsgForGeneralShare == null) {
      return;
    }
    Object localObject1 = paramStructMsgForGeneralShare.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
      if ((localObject2 instanceof StructMsgItemLayout5))
      {
        localObject2 = ((StructMsgItemLayout5)localObject2).ax.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
          Object localObject4;
          Object localObject5;
          if ((localObject3 instanceof StructMsgItemVideo))
          {
            localObject3 = (StructMsgItemVideo)localObject3;
            if (((StructMsgItemVideo)localObject3).c())
            {
              ((StructMsgItemVideo)localObject3).aB = null;
              ((StructMsgItemVideo)localObject3).av = null;
              ((StructMsgItemVideo)localObject3).aw = 0;
              if (QLog.isColorLevel()) {
                QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: summary = null");
              }
              localObject4 = ((StructMsgItemVideo)localObject3).az;
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("");
              ((StringBuilder)localObject5).append(((StructMsgItemVideo)localObject3).aR);
              localObject5 = ((StringBuilder)localObject5).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(((StructMsgItemVideo)localObject3).as.msgId);
              ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800682F", "0X800682F", 0, 0, (String)localObject4, (String)localObject5, localStringBuilder.toString(), "");
            }
          }
          else if ((localObject3 instanceof StructMsgItemTitle))
          {
            localObject3 = (StructMsgItemTitle)localObject3;
            localObject4 = ((StructMsgItemTitle)localObject3).e();
            int i = ((String)localObject4).length();
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("simplifyForForward: title = ");
              ((StringBuilder)localObject5).append(((StructMsgItemTitle)localObject3).e());
              ((StringBuilder)localObject5).append(", length=");
              ((StringBuilder)localObject5).append(i);
              QLog.d("PAVideoStructMsgUtil", 2, ((StringBuilder)localObject5).toString());
            }
            if (i > 15)
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(((String)localObject4).substring(0, 15));
              ((StringBuilder)localObject5).append("...");
              ((StructMsgItemTitle)localObject3).b(((StringBuilder)localObject5).toString());
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("simplifyForForward: after reduce title length, title = ");
                ((StringBuilder)localObject4).append(((StructMsgItemTitle)localObject3).e());
                QLog.d("PAVideoStructMsgUtil", 2, ((StringBuilder)localObject4).toString());
              }
            }
          }
        }
      }
    }
    if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgBrief)) && (paramStructMsgForGeneralShare.mMsgBrief.length() > 15))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramStructMsgForGeneralShare.mMsgBrief.substring(0, 15));
      ((StringBuilder)localObject1).append("...");
      paramStructMsgForGeneralShare.mMsgBrief = ((StringBuilder)localObject1).toString();
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 100);
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (paramAbsStructMsg != null)
    {
      bool2 = bool3;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!paramAbsStructMsg.hasNext()) {
            return bool2;
          }
          Object localObject = (AbsStructMsgElement)paramAbsStructMsg.next();
          if ((localObject instanceof StructMsgItemLayout5))
          {
            localObject = ((StructMsgItemLayout5)localObject).ax.iterator();
            if (((Iterator)localObject).hasNext())
            {
              AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
              if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                break;
              }
              if (((StructMsgItemVideo)localAbsStructMsgElement).c()) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public static StructMsgItemVideo b(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      Object localObject2;
      do
      {
        do
        {
          paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).iterator();
          Object localObject1;
          while (!((Iterator)localObject1).hasNext())
          {
            do
            {
              if (!paramAbsStructMsg.hasNext()) {
                break;
              }
              localObject1 = (AbsStructMsgElement)paramAbsStructMsg.next();
            } while (!(localObject1 instanceof StructMsgItemLayout5));
            localObject1 = ((StructMsgItemLayout5)localObject1).ax.iterator();
          }
          localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof StructMsgItemVideo));
        localObject2 = (StructMsgItemVideo)localObject2;
      } while (!((StructMsgItemVideo)localObject2).c());
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil
 * JD-Core Version:    0.7.0.1
 */