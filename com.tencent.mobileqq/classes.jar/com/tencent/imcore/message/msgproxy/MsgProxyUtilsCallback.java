package com.tencent.imcore.message.msgproxy;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.MsgProxyUtils.Callback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class MsgProxyUtilsCallback
  implements MsgProxyUtils.Callback
{
  static String[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        localObject1 = localObject2;
        if (paramString.charAt(0) == '\026') {
          localObject1 = paramString.split("\\|");
        }
      }
    }
    return localObject1;
  }
  
  public int a()
  {
    return 480;
  }
  
  public MessageRecord a(ArrayList<MessageRecord> paramArrayList)
  {
    return new MessageForLongMsg(paramArrayList);
  }
  
  public void a(Exception paramException, List<MessageRecord> paramList)
  {
    CaughtExceptionReport.a(paramException, " addToTailWhenException ");
  }
  
  public boolean a(int paramInt)
  {
    return MessageUtils.a(paramInt);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return AnonymousChatHelper.b(paramMessageRecord);
  }
  
  public boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord2 instanceof MessageForUniteGrayTip))
    {
      bool1 = bool2;
      if ((paramMessageRecord1 instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (((MessageForUniteGrayTip)paramMessageRecord2).tipParam.d > ((MessageForUniteGrayTip)paramMessageRecord1).tipParam.d) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString1, String paramString2)
  {
    boolean bool = true;
    if (paramMessageRecord2.msgtype == -2002) {
      if (((paramMessageRecord2 instanceof MessageForPtt)) && ((paramMessageRecord1 instanceof MessageForPtt)) && (((MessageForPtt)paramMessageRecord1).urlAtServer != null) && (((MessageForPtt)paramMessageRecord1).urlAtServer.length() > 0) && (((MessageForPtt)paramMessageRecord2).urlAtServer != null) && (((MessageForPtt)paramMessageRecord2).urlAtServer.length() > 0)) {
        bool = ((MessageForPtt)paramMessageRecord1).urlAtServer.equals(((MessageForPtt)paramMessageRecord2).urlAtServer);
      }
    }
    label458:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool;
                        return false;
                        if (paramMessageRecord2.msgtype == -2011)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("Debug", 2, "c2c" + Arrays.toString(paramMessageRecord1.msgData) + " : " + Arrays.toString(paramMessageRecord2.msgData));
                          }
                          return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                        }
                        if (paramMessageRecord2.msgtype != -2000) {
                          break label524;
                        }
                        if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() <= 0) || (paramString2.length() <= 0) || (paramString1.charAt(0) != '\026') || (paramString2.charAt(0) != '\026')) {
                          break label458;
                        }
                        paramMessageRecord1 = a(paramString2);
                        paramString2 = a(paramString1);
                        if ((paramMessageRecord1 == null) || (paramString2 == null)) {
                          return false;
                        }
                        if ((!paramMessageRecord1[1].equals(paramString2[1])) || (!paramMessageRecord1[2].equals(paramString2[2]))) {
                          return false;
                        }
                        if ((paramMessageRecord2.issend != 2) && (!paramMessageRecord2.isSendFromLocal())) {
                          break;
                        }
                      } while (!QLog.isColorLevel());
                      QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + paramMessageRecord1[1] + ",picType:" + paramMessageRecord1[2] + ",isSend == true");
                      return true;
                      if (!paramString1.contains(AppConstants.SDCARD_PATH)) {
                        break;
                      }
                      paramMessageRecord2 = paramString2[0].split("/");
                      paramMessageRecord2 = paramMessageRecord2[(paramMessageRecord2.length - 1)].split("\\.")[0];
                      paramString1 = MD5.toMD5(paramMessageRecord1[4]);
                      if (!paramString1.equals(paramMessageRecord2)) {
                        break label1255;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + paramMessageRecord1[1] + ",picType:" + paramMessageRecord1[2] + ",Path:" + paramString1);
                    return true;
                    return paramString2[0].equals(paramMessageRecord1[0]);
                    if ((((MessageForPic)paramMessageRecord1).uuid != null) && (((MessageForPic)paramMessageRecord1).uuid.length() > 0) && (((MessageForPic)paramMessageRecord2).uuid != null) && (((MessageForPic)paramMessageRecord2).uuid.length() > 0)) {
                      return ((MessageForPic)paramMessageRecord1).uuid.equals(((MessageForPic)paramMessageRecord2).uuid);
                    }
                    return false;
                    if ((paramMessageRecord2.msgtype == -2007) && (paramMessageRecord1.msgtype == -2007)) {
                      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                    }
                    if ((paramMessageRecord2.msgtype == -2058) && (paramMessageRecord1.msgtype == -2058))
                    {
                      if (((!(paramMessageRecord2 instanceof MessageForMarketFace)) || (!(paramMessageRecord1 instanceof MessageForMarketFace))) && ((!(paramMessageRecord2 instanceof MessageForText)) || (!(paramMessageRecord1 instanceof MessageForText))) && ((!(paramMessageRecord2 instanceof MessageForPic)) || (!(paramMessageRecord1 instanceof MessageForPic)))) {
                        break label1255;
                      }
                      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                    }
                    if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1035)) {
                      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                    }
                    if ((paramMessageRecord2.msgtype != -1034) || (paramMessageRecord1.msgtype != -1034)) {
                      break;
                    }
                  } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
                  return false;
                  if ((paramMessageRecord2.msgtype != -1042) || (paramMessageRecord1.msgtype != -1042)) {
                    break;
                  }
                } while (paramMessageRecord2.time == paramMessageRecord1.time);
                return false;
                if ((paramMessageRecord2.msgtype != -2015) || (paramMessageRecord1.msgtype != -2015)) {
                  break;
                }
              } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
              return false;
              if ((paramMessageRecord2.msgtype != -7007) || (paramMessageRecord1.msgtype != -7007)) {
                break;
              }
            } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
            return false;
            if ((paramMessageRecord2.msgtype == -2010) && (paramMessageRecord1.msgtype == -2010)) {
              return ((MessageForFunnyFace)paramMessageRecord2).msgEquals((MessageForFunnyFace)paramMessageRecord1);
            }
            if ((paramMessageRecord2.msgtype == -2060) && (paramMessageRecord1.msgtype == -2060)) {
              return ((MessageForPLNews)paramMessageRecord2).msgEquals((MessageForPLNews)paramMessageRecord1);
            }
            if ((paramMessageRecord2.msgtype != -2065) && (paramMessageRecord2.msgtype != -2062) && (paramMessageRecord2.msgtype != -4023) && (paramMessageRecord2.msgtype != -2066) && (paramMessageRecord2.msgtype != -7009) && (paramMessageRecord2.msgtype != -7010) && (paramMessageRecord2.msgtype != -7011) && (paramMessageRecord2.msgtype != -7012) && (paramMessageRecord2.msgtype != -7013) && (paramMessageRecord2.msgtype != -7015)) {
              break;
            }
          } while (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq);
          return false;
          if (paramMessageRecord2.msgtype != -2005) {
            break label1064;
          }
          if ((!(paramMessageRecord2 instanceof MessageForFile)) || (!(paramMessageRecord1 instanceof MessageForFile))) {
            break;
          }
        } while ((paramMessageRecord2.msgUid == paramMessageRecord1.msgUid) && (paramMessageRecord2.msgseq == paramMessageRecord1.msgseq));
        return false;
        return false;
        if (paramMessageRecord2.msgtype == -2017) {
          return false;
        }
        if (paramMessageRecord2.msgtype != -5008) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxyUtils", 2, new Object[] { "AAShare.compMsgContent recRecord.msgUid=", Long.valueOf(paramMessageRecord2.msgUid), ",cacheRecord.msgUid,", Long.valueOf(paramMessageRecord1.msgUid) });
        }
      } while (paramMessageRecord2.msgUid == paramMessageRecord1.msgUid);
      return false;
      if (paramMessageRecord2.msgtype == -2022)
      {
        if ((!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord2).md5)) && (!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord1).md5))) {
          return ((MessageForShortVideo)paramMessageRecord1).md5.equals(((MessageForShortVideo)paramMessageRecord2).md5);
        }
        if ((!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord2).uuid)) && (!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord1).uuid))) {
          return ((MessageForShortVideo)paramMessageRecord1).uuid.equals(((MessageForShortVideo)paramMessageRecord2).uuid);
        }
        return false;
      }
    } while (TextUtils.equals(paramString1, paramString2));
    label524:
    label1064:
    label1255:
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return ((QQAppInterface)paramAppRuntime).getConversationFacade().a(paramMessageRecord.frienduin);
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForReplyText));
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    if ((MsgProxyUtils.d(paramMessageRecord.msgtype)) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
    {
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if (paramMessageRecord.tipParam != null) {
        return paramMessageRecord.tipParam.f;
      }
    }
    return false;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    return UniteGrayTipUtil.a(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.MsgProxyUtilsCallback
 * JD-Core Version:    0.7.0.1
 */