import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bbfh
{
  private static float jdField_a_of_type_Float = 0.0F;
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static float jdField_b_of_type_Float = 0.0F;
  private static long jdField_b_of_type_Long;
  private static float c;
  
  private static int a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
    Object localObject = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (localObject != null)
    {
      if (((FileManagerEntity)localObject).fProgress == 1.0D) {
        return 1;
      }
      if ((((FileManagerEntity)localObject).status == 0) && (!((FileManagerEntity)localObject).isSend())) {
        return 1;
      }
      if ((((FileManagerEntity)localObject).status == 16) && (((FileManagerEntity)localObject).bSend) && (!((FileManagerEntity)localObject).bOnceSuccess)) {
        return 0;
      }
      return ((FileManagerEntity)localObject).status;
    }
    localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((aukp)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((aukp)localObject).a();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = apug.b(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.a().a(bbcc.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131690146);
    }
    return paramQQAppInterface.getApp().getString(2131690148) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131690149);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, QQMessageFacade.Message paramMessage)
  {
    String str1;
    if (SystemMsg.isSystemMessage(paramMessage.msgtype))
    {
      str1 = null;
      switch (paramMessage.msgtype)
      {
      default: 
        paramContext = str1;
        String str2 = bbbq.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = bbcz.b(paramQQAppInterface, paramMessage.senderuin, true);
              if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramMessage.senderuin))) {
                break label274;
              }
              paramString = new StringBuilder();
              paramString.append(paramQQAppInterface).append(paramContext);
              str1 = paramString.toString();
            }
          }
        }
        break;
      }
    }
    label274:
    label439:
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
                  return str1;
                  paramContext = paramContext.getString(2131689663);
                  break;
                  paramContext = paramContext.getString(2131689542);
                  break;
                  paramContext = paramContext.getString(2131689541);
                  break;
                  paramContext = paramContext.getString(2131718690);
                  break;
                  paramContext = paramContext.getString(2131689702);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = bbbq.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = bbcz.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return bbbq.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
    paramString = bbbq.a(paramString, paramQQAppInterface);
    paramMessage = bbbq.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = bbcz.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = bbbq.a(paramString, paramMessage, paramQQAppInterface);
            }
          }
        }
      }
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      localObject = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(paramString);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() < 4));
    String str1 = ((Matcher)localObject).group(0);
    String str2 = ((Matcher)localObject).group(1);
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (str2.length() > 0) {
        i = Integer.parseInt(((Matcher)localObject).group(2));
      }
    }
    j = Integer.parseInt(((Matcher)localObject).group(3));
    int k = Integer.parseInt(((Matcher)localObject).group(4));
    Object localObject = new StringBuffer();
    if (i > 0) {
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131693360));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131694292));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131719140));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    int k = 0;
    if (paramArrayOfString == null)
    {
      paramArrayOfString = "";
      label10:
      return paramArrayOfString;
    }
    if ((paramInt == 1) || (paramInt == 5000)) {}
    for (int i = 1;; i = 2)
    {
      for (;;)
      {
        if (paramArrayOfString.length <= 1) {
          break label366;
        }
        try
        {
          j = Integer.parseInt(paramArrayOfString[1]);
          switch (j)
          {
          default: 
            paramString1 = paramContext.getResources().getString(2131695867);
            if ((paramInt == 1) || (paramInt == 5000)) {
              paramString1 = paramContext.getResources().getString(2131695890);
            }
            if (paramArrayOfString.length <= 5) {
              break;
            }
          case 13: 
            try
            {
              paramInt = Integer.parseInt(paramArrayOfString[4]);
            }
            catch (Exception paramArrayOfString)
            {
              label150:
              for (;;)
              {
                boolean bool;
                label126:
                paramInt = 0;
              }
            }
            try
            {
              bool = Boolean.parseBoolean(paramArrayOfString[5]);
              k = bool;
            }
            catch (Exception paramArrayOfString)
            {
              break label126;
            }
            paramArrayOfString = paramString1;
            if (paramInt != 2) {
              break label10;
            }
            if (k == 0) {
              break label352;
            }
            paramArrayOfString = paramQQAppInterface.getApp().getString(2131695892);
            paramArrayOfString = ":" + paramArrayOfString;
            return paramString1.replace(paramQQAppInterface.getApp().getString(2131695890), paramArrayOfString);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int j = 0;
          }
          if (paramString2 == null) {
            break label310;
          }
        }
      }
      paramString2 = bbcz.a(paramQQAppInterface, paramString2, paramString1, i, 0);
      paramString1 = paramContext.getResources().getString(2131695867);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131695890);
      }
      if (paramString2.length() > 11) {
        paramContext = paramString2.substring(0, 10);
      }
      for (paramContext = paramContext + "...";; paramContext = paramString2)
      {
        paramString1 = paramContext + paramString1;
        break;
        label310:
        if ((paramInt == 1) || (paramInt == 5000))
        {
          paramString1 = paramContext.getResources().getString(2131695887);
          break;
        }
        paramString1 = paramContext.getResources().getString(2131695819);
        break;
        label352:
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131695887);
        break label150;
        label366:
        return "";
        paramInt = 0;
        break label126;
      }
    }
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {}
    do
    {
      return null;
      if (paramMessageForPic.picExtraData != null)
      {
        String str = paramMessageForPic.picExtraData.textSummary;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("msgSummary", 2, "textSummary: " + bbbr.a(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (aezl.b(paramMessageForPic)) || (anoi.b(paramMessageForPic)) || (aexb.a(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131691289);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131691289);
  }
  
  public static String a(String paramString)
  {
    String str = ajya.a(2131706983);
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, float paramFloat)
  {
    Object localObject3 = paramString;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label20;
      }
      localObject3 = paramString;
    }
    label20:
    float f1;
    for (;;)
    {
      return localObject3;
      long l1 = 0L;
      if (QLog.isDevelopLevel()) {
        l1 = SystemClock.elapsedRealtime();
      }
      if (jdField_a_of_type_Int == 0) {}
      label803:
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
        localObject3 = ajya.a(2131706992);
        TextPaint localTextPaint = new TextPaint();
        localTextPaint.setTextSize(((DisplayMetrics)localObject1).density * 14.0F);
        f1 = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
        float f2 = ((DisplayMetrics)localObject1).density;
        f1 -= f2 * 72.0F;
        if (f1 <= 0.0F)
        {
          localObject3 = paramString;
          return paramString;
        }
        c = 0.7F * f1;
        jdField_a_of_type_Float = localTextPaint.measureText((String)localObject3);
        jdField_b_of_type_Float = localTextPaint.measureText("AaJjIiMm") / "AaJjIiMm".length();
        if (jdField_a_of_type_Float > 1.0F) {
          jdField_a_of_type_Int = (int)(f1 * 0.8F / jdField_a_of_type_Float);
        }
        if (jdField_b_of_type_Float > 1.0F) {
          jdField_a_of_type_Int = Math.min(jdField_a_of_type_Int, (int)(c / jdField_b_of_type_Float));
        }
        if (jdField_a_of_type_Int <= 0) {
          jdField_a_of_type_Int = 14;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          localException.printStackTrace();
          jdField_a_of_type_Int = 14;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder(120);
            localStringBuilder.append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_a_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
            QLog.i("Q.recent", 2, localStringBuilder.toString());
          }
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
          jdField_a_of_type_Int = 14;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder(120);
            ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_a_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
            QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label803;
        }
        localObject2 = new StringBuilder(120);
        ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_a_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
      }
    }
    int k = paramString.length();
    localObject1 = paramString;
    if (k >= jdField_a_of_type_Int)
    {
      localObject1 = paramString;
      if (jdField_b_of_type_Float >= 1.0F)
      {
        if (jdField_a_of_type_Float >= 1.0F) {
          break label805;
        }
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      long l2 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime() - l1 + l2;
      jdField_b_of_type_Long += 1L;
      localObject3 = localObject1;
      if (jdField_b_of_type_Long % 10L != 1L) {
        break;
      }
      QLog.i("Q.recent", 4, "trimName, cost = " + jdField_a_of_type_Long / jdField_b_of_type_Long);
      return localObject1;
      StringBuilder localStringBuilder;
      label805:
      f1 = 0.0F;
      int i = 0;
      int j = 0;
      if (i < k)
      {
        int m = paramString.charAt(i);
        if ((m >= 32) && (m <= 126)) {}
        for (f1 += jdField_b_of_type_Float;; f1 += jdField_a_of_type_Float)
        {
          if (c * paramFloat - f1 <= 1.0F) {
            break label884;
          }
          j += 1;
          i += 1;
          break;
        }
      }
      label884:
      Object localObject2 = paramString;
      if (j < k)
      {
        localObject2 = paramString;
        if (j > 0) {
          localObject2 = paramString.substring(0, j - 1) + "...";
        }
      }
    }
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    Object localObject;
    if (paramArrayOfString == null)
    {
      localObject = "";
      label11:
      return localObject;
    }
    if (paramArrayOfString.length > 1) {
      for (;;)
      {
        int j;
        try
        {
          i = Integer.parseInt(paramArrayOfString[1]);
          j = k;
          if (paramArrayOfString.length > 3)
          {
            if ("1".equals(paramArrayOfString[3])) {
              j = k;
            }
          }
          else {
            switch (i)
            {
            default: 
              if (j == 0) {
                break label913;
              }
              paramContext = paramContext.getResources().getString(2131696230);
              localObject = paramContext;
              if (TextUtils.isEmpty(paramArrayOfString[0])) {
                break label11;
              }
              return paramContext + " " + paramArrayOfString[0];
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i = 0;
          continue;
          j = 0;
          continue;
          if (paramArrayOfString[0] == null) {
            break label930;
          }
        }
        if (paramContext.getString(2131720762).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131696247);
          }
          return paramContext.getResources().getString(2131695689);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131696230) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695675) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131720766).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131696243);
            }
            return paramContext.getResources().getString(2131696242);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695684);
          }
          return paramContext.getResources().getString(2131695683);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131696230) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695675) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131696243);
          }
          return paramContext.getResources().getString(2131696242);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695684);
        }
        return paramContext.getResources().getString(2131695683);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131696243);
          }
          return paramContext.getResources().getString(2131696242);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695684);
        }
        return paramContext.getResources().getString(2131695683);
        if (j != 0) {
          return paramContext.getResources().getString(2131696244);
        }
        return paramContext.getResources().getString(2131695685);
        if (j != 0) {
          return paramContext.getResources().getString(2131696230);
        }
        return paramContext.getResources().getString(2131695675);
        if (j != 0) {
          return paramContext.getResources().getString(2131696231);
        }
        return paramContext.getResources().getString(2131695677);
        if (j != 0) {
          return paramContext.getResources().getString(2131696246);
        }
        return paramContext.getResources().getString(2131695688);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131720762).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131696247);
          }
          return paramContext.getResources().getString(2131695689);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131696230) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695675) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131695675) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131695675);
      }
    }
    return "";
    label930:
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload 5
    //   7: astore 16
    //   9: aload_2
    //   10: invokestatic 503	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   13: ifeq +7703 -> 7716
    //   16: aload 5
    //   18: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +24 -> 45
    //   24: aload 5
    //   26: astore 16
    //   28: aload 5
    //   30: aload_1
    //   31: aload_2
    //   32: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   35: iconst_1
    //   36: invokestatic 505	bbcz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   39: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +7674 -> 7716
    //   45: aload_1
    //   46: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   49: aload_2
    //   50: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   53: aload_2
    //   54: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   57: aload_2
    //   58: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   61: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   64: astore 16
    //   66: aload 16
    //   68: instanceof 515
    //   71: ifeq +11 -> 82
    //   74: aload 16
    //   76: checkcast 515	com/tencent/mobileqq/data/ChatMessage
    //   79: invokevirtual 518	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   82: aload 16
    //   84: ifnull +13 -> 97
    //   87: aload 16
    //   89: invokestatic 521	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lmyc;
    //   92: getfield 525	myc:b	Ljava/lang/String;
    //   95: astore 5
    //   97: aload 5
    //   99: astore 16
    //   101: aload 5
    //   103: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +7610 -> 7716
    //   109: aload_2
    //   110: invokestatic 521	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lmyc;
    //   113: getfield 525	myc:b	Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: astore 16
    //   122: iload 6
    //   124: ifne +42 -> 166
    //   127: aload_2
    //   128: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   131: ifne +32 -> 163
    //   134: aload 5
    //   136: astore 16
    //   138: aload_2
    //   139: getfield 531	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   142: ifnull +24 -> 166
    //   145: aload 5
    //   147: astore 16
    //   149: aload_2
    //   150: getfield 531	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   153: aload_2
    //   154: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   157: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +6 -> 166
    //   163: aconst_null
    //   164: astore 16
    //   166: aload_2
    //   167: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   170: invokestatic 536	akpx:k	(I)Z
    //   173: ifeq +6 -> 179
    //   176: aconst_null
    //   177: astore 16
    //   179: aload_2
    //   180: invokestatic 541	bajp:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lbajq;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +10 -> 197
    //   190: aload 5
    //   192: getfield 545	bajq:c	Ljava/lang/String;
    //   195: astore 16
    //   197: aload 16
    //   199: invokestatic 546	bbfh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 19
    //   204: aload_2
    //   205: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   208: sipush -2034
    //   211: if_icmpne +16 -> 227
    //   214: aload 4
    //   216: aload_2
    //   217: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   220: invokestatic 554	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   226: return
    //   227: aload_2
    //   228: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   231: sipush -2011
    //   234: if_icmpne +157 -> 391
    //   237: iconst_0
    //   238: istore_3
    //   239: iconst_0
    //   240: istore 8
    //   242: aload_2
    //   243: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   246: sipush -2011
    //   249: if_icmpne +29 -> 278
    //   252: aload_2
    //   253: getfield 563	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extInt	I
    //   256: bipush 61
    //   258: if_icmpne +20 -> 278
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   266: invokevirtual 564	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   269: ldc_w 565
    //   272: invokevirtual 288	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   275: putfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   278: aload_2
    //   279: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   282: iconst_1
    //   283: if_icmpne +73 -> 356
    //   286: aload_1
    //   287: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   290: aload_2
    //   291: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   294: aload_2
    //   295: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   298: aload_2
    //   299: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   302: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   305: astore_0
    //   306: iload 8
    //   308: istore_3
    //   309: aload_0
    //   310: invokestatic 568	aszp:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   313: ifeq +21 -> 334
    //   316: aconst_null
    //   317: aconst_null
    //   318: aload_0
    //   319: checkcast 570	com/tencent/mobileqq/data/MessageForStructing
    //   322: invokestatic 573	aszp:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   325: iconst_0
    //   326: iconst_0
    //   327: aload 4
    //   329: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   332: iconst_1
    //   333: istore_3
    //   334: aload_0
    //   335: invokestatic 579	bajo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   338: ifeq +18 -> 356
    //   341: aconst_null
    //   342: aconst_null
    //   343: aload_2
    //   344: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   347: iconst_0
    //   348: iconst_0
    //   349: aload 4
    //   351: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   354: iconst_1
    //   355: istore_3
    //   356: iload_3
    //   357: ifne -353 -> 4
    //   360: aload_1
    //   361: aload_2
    //   362: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   365: istore 6
    //   367: aload_1
    //   368: aload_2
    //   369: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   372: istore 7
    //   374: aload 19
    //   376: aconst_null
    //   377: aload_2
    //   378: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   381: iload 6
    //   383: iload 7
    //   385: aload 4
    //   387: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   390: return
    //   391: aload_2
    //   392: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   395: sipush -2000
    //   398: if_icmpeq +13 -> 411
    //   401: aload_2
    //   402: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   405: sipush -5015
    //   408: if_icmpne +453 -> 861
    //   411: iconst_0
    //   412: istore 7
    //   414: iconst_0
    //   415: istore 10
    //   417: aconst_null
    //   418: astore 18
    //   420: aconst_null
    //   421: astore 5
    //   423: aload_2
    //   424: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   427: astore 17
    //   429: aload_2
    //   430: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   433: aload_2
    //   434: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   437: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   440: ifeq +7273 -> 7713
    //   443: aload_2
    //   444: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   447: astore 17
    //   449: aload_1
    //   450: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   453: aload 17
    //   455: aload_2
    //   456: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   459: aload_2
    //   460: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   463: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   466: checkcast 311	com/tencent/mobileqq/data/MessageForPic
    //   469: astore 16
    //   471: aload 18
    //   473: astore 5
    //   475: aload_1
    //   476: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Layvx;
    //   479: aload 17
    //   481: aload_2
    //   482: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   485: invokevirtual 595	ayvx:a	(Ljava/lang/String;J)Lbbmw;
    //   488: astore_1
    //   489: aload_1
    //   490: astore 5
    //   492: aload_2
    //   493: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   496: ifeq +231 -> 727
    //   499: aload 16
    //   501: ifnull +201 -> 702
    //   504: aload_1
    //   505: astore 5
    //   507: aload 16
    //   509: getfield 598	com/tencent/mobileqq/data/MessageForPic:size	J
    //   512: lstore 14
    //   514: lload 14
    //   516: lconst_0
    //   517: lcmp
    //   518: ifgt +184 -> 702
    //   521: aload_1
    //   522: ifnonnull +7185 -> 7707
    //   525: iconst_1
    //   526: istore 6
    //   528: aload 16
    //   530: astore 5
    //   532: iload 6
    //   534: istore 7
    //   536: aload_1
    //   537: astore 16
    //   539: aload 16
    //   541: instanceof 600
    //   544: ifeq +260 -> 804
    //   547: aload 16
    //   549: checkcast 600	aypb
    //   552: astore_1
    //   553: aload_1
    //   554: invokevirtual 602	aypb:c	()J
    //   557: ldc2_w 603
    //   560: lcmp
    //   561: ifeq +7140 -> 7701
    //   564: iconst_1
    //   565: istore 6
    //   567: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +60 -> 630
    //   573: aload_1
    //   574: getfield 607	aypb:a	Laywc;
    //   577: ifnull +219 -> 796
    //   580: aload_1
    //   581: getfield 607	aypb:a	Laywc;
    //   584: getfield 610	aywc:jdField_a_of_type_Long	J
    //   587: lstore 14
    //   589: ldc_w 612
    //   592: iconst_2
    //   593: new 160	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 614
    //   603: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: lload 14
    //   608: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   611: ldc_w 616
    //   614: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_1
    //   618: invokevirtual 618	aypb:a	()Ljava/lang/String;
    //   621: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload_0
    //   631: ldc_w 619
    //   634: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   637: astore_1
    //   638: aload_2
    //   639: invokestatic 622	ajyi:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   642: ifne +10 -> 652
    //   645: aload_2
    //   646: invokestatic 625	ajwb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   649: ifeq +11 -> 660
    //   652: aload_0
    //   653: ldc_w 626
    //   656: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   659: astore_1
    //   660: aload_2
    //   661: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   664: sipush -5015
    //   667: if_icmpne +11 -> 678
    //   670: aload_0
    //   671: ldc_w 627
    //   674: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   677: astore_1
    //   678: aload 5
    //   680: invokestatic 629	bbfh:a	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   683: astore_0
    //   684: aload_0
    //   685: ifnull +7011 -> 7696
    //   688: aload 19
    //   690: aload_0
    //   691: aconst_null
    //   692: iload 7
    //   694: iload 6
    //   696: aload 4
    //   698: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   701: return
    //   702: aload 16
    //   704: ifnull +7003 -> 7707
    //   707: aload_1
    //   708: astore 5
    //   710: aload 16
    //   712: getfield 632	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   715: ldc_w 633
    //   718: if_icmpne +7005 -> 7723
    //   721: iconst_1
    //   722: istore 6
    //   724: goto -196 -> 528
    //   727: aload_1
    //   728: ifnull +6979 -> 7707
    //   731: aload_1
    //   732: astore 5
    //   734: aload_1
    //   735: instanceof 600
    //   738: ifeq +6969 -> 7707
    //   741: aload_1
    //   742: astore 5
    //   744: aload_1
    //   745: checkcast 600	aypb
    //   748: invokevirtual 602	aypb:c	()J
    //   751: lstore 14
    //   753: lload 14
    //   755: l2i
    //   756: istore_3
    //   757: iload_3
    //   758: sipush 1005
    //   761: if_icmpeq +10 -> 771
    //   764: iload_3
    //   765: sipush 1004
    //   768: if_icmpne +6939 -> 7707
    //   771: iconst_1
    //   772: istore 6
    //   774: goto -246 -> 528
    //   777: astore 16
    //   779: aconst_null
    //   780: astore_1
    //   781: aload 16
    //   783: invokevirtual 470	java/lang/Exception:printStackTrace	()V
    //   786: aload 5
    //   788: astore 16
    //   790: aload_1
    //   791: astore 5
    //   793: goto -254 -> 539
    //   796: ldc2_w 39
    //   799: lstore 14
    //   801: goto -212 -> 589
    //   804: iload 10
    //   806: istore 6
    //   808: aload 16
    //   810: ifnull -180 -> 630
    //   813: iconst_1
    //   814: istore 10
    //   816: iload 10
    //   818: istore 6
    //   820: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   823: ifeq -193 -> 630
    //   826: ldc_w 612
    //   829: iconst_2
    //   830: new 160	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   837: ldc_w 635
    //   840: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload 16
    //   845: invokevirtual 638	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: iload 10
    //   856: istore 6
    //   858: goto -228 -> 630
    //   861: aload_2
    //   862: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   865: sipush -2002
    //   868: if_icmpeq +13 -> 881
    //   871: aload_2
    //   872: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   875: sipush -1031
    //   878: if_icmpne +265 -> 1143
    //   881: aload_2
    //   882: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   885: astore 16
    //   887: aload_2
    //   888: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   891: aload_2
    //   892: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   895: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   898: ifeq +6795 -> 7693
    //   901: aload_2
    //   902: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   905: astore 16
    //   907: iconst_0
    //   908: istore 6
    //   910: aload_0
    //   911: ldc_w 639
    //   914: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   917: astore_0
    //   918: aload_1
    //   919: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   922: aload 16
    //   924: aload_2
    //   925: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   928: aload_2
    //   929: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   932: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   935: astore 5
    //   937: aload 5
    //   939: instanceof 641
    //   942: ifeq +6745 -> 7687
    //   945: aload 5
    //   947: checkcast 641	com/tencent/mobileqq/data/MessageForPtt
    //   950: astore 17
    //   952: aload 17
    //   954: invokevirtual 644	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   957: astore 5
    //   959: aload 5
    //   961: astore_0
    //   962: aload_2
    //   963: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   966: ifeq +6721 -> 7687
    //   969: aload 17
    //   971: getfield 647	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   974: ldc2_w 39
    //   977: lcmp
    //   978: ifne +52 -> 1030
    //   981: iconst_1
    //   982: istore 6
    //   984: aload 5
    //   986: astore_0
    //   987: iconst_0
    //   988: istore 7
    //   990: ldc_w 649
    //   993: iconst_2
    //   994: anewarray 4	java/lang/Object
    //   997: dup
    //   998: iconst_0
    //   999: iload 6
    //   1001: invokestatic 652	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1004: aastore
    //   1005: dup
    //   1006: iconst_1
    //   1007: iload 7
    //   1009: invokestatic 652	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1012: aastore
    //   1013: invokestatic 657	anml:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: aload 19
    //   1018: aload_0
    //   1019: aconst_null
    //   1020: iload 6
    //   1022: iload 7
    //   1024: aload 4
    //   1026: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1029: return
    //   1030: aload 5
    //   1032: astore_0
    //   1033: aload 17
    //   1035: getfield 647	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1038: lconst_0
    //   1039: lcmp
    //   1040: ifgt +6647 -> 7687
    //   1043: aload_1
    //   1044: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Layvx;
    //   1047: aload 16
    //   1049: aload 17
    //   1051: getfield 660	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1054: aload 17
    //   1056: getfield 661	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   1059: invokevirtual 664	ayvx:b	(Ljava/lang/String;Ljava/lang/String;J)I
    //   1062: istore_3
    //   1063: iload_3
    //   1064: sipush 1005
    //   1067: if_icmpeq +15 -> 1082
    //   1070: iload_3
    //   1071: sipush 1004
    //   1074: if_icmpeq +8 -> 1082
    //   1077: iload_3
    //   1078: iconst_m1
    //   1079: if_icmpne +55 -> 1134
    //   1082: iconst_1
    //   1083: istore 7
    //   1085: iconst_0
    //   1086: istore 6
    //   1088: ldc_w 649
    //   1091: iconst_2
    //   1092: anewarray 4	java/lang/Object
    //   1095: dup
    //   1096: iconst_0
    //   1097: aload 17
    //   1099: getfield 647	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1102: invokestatic 669	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1105: aastore
    //   1106: dup
    //   1107: iconst_1
    //   1108: iload_3
    //   1109: invokestatic 672	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1112: aastore
    //   1113: invokestatic 657	anml:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1116: aload 5
    //   1118: astore_0
    //   1119: iload 6
    //   1121: istore 10
    //   1123: iload 7
    //   1125: istore 6
    //   1127: iload 10
    //   1129: istore 7
    //   1131: goto -141 -> 990
    //   1134: iconst_1
    //   1135: istore 6
    //   1137: iconst_0
    //   1138: istore 7
    //   1140: goto -52 -> 1088
    //   1143: aload_2
    //   1144: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1147: sipush -3008
    //   1150: if_icmpne +48 -> 1198
    //   1153: aload 4
    //   1155: new 160	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1162: aload_0
    //   1163: ldc_w 673
    //   1166: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   1169: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: ldc_w 675
    //   1175: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: aload_2
    //   1179: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1182: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: ldc_w 675
    //   1188: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1197: return
    //   1198: aload_2
    //   1199: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1202: sipush -2015
    //   1205: if_icmpeq +53 -> 1258
    //   1208: aload_2
    //   1209: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1212: sipush -2060
    //   1215: if_icmpeq +43 -> 1258
    //   1218: aload_2
    //   1219: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1222: sipush -2065
    //   1225: if_icmpeq +33 -> 1258
    //   1228: aload_2
    //   1229: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1232: sipush -2062
    //   1235: if_icmpeq +23 -> 1258
    //   1238: aload_2
    //   1239: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1242: sipush -4023
    //   1245: if_icmpeq +13 -> 1258
    //   1248: aload_2
    //   1249: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1252: sipush -4024
    //   1255: if_icmpne +11 -> 1266
    //   1258: aload 4
    //   1260: ldc 119
    //   1262: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1265: return
    //   1266: aload_2
    //   1267: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1270: invokestatic 679	bbbu:a	(I)Z
    //   1273: ifeq +28 -> 1301
    //   1276: aload 19
    //   1278: aload_0
    //   1279: aload_1
    //   1280: aload_2
    //   1281: invokestatic 681	bbfh:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1284: aconst_null
    //   1285: aload_1
    //   1286: aload_2
    //   1287: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1290: aload_1
    //   1291: aload_2
    //   1292: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1295: aload 4
    //   1297: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1300: return
    //   1301: aload_2
    //   1302: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1305: sipush -2017
    //   1308: if_icmpne +94 -> 1402
    //   1311: aload_0
    //   1312: ldc_w 682
    //   1315: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   1318: astore 5
    //   1320: aload_2
    //   1321: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1324: astore_0
    //   1325: aload_2
    //   1326: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1329: aload_2
    //   1330: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1333: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   1336: ifeq +8 -> 1344
    //   1339: aload_2
    //   1340: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1343: astore_0
    //   1344: aload_1
    //   1345: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1348: aload_0
    //   1349: aload_2
    //   1350: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1353: aload_2
    //   1354: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1357: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1360: astore 16
    //   1362: aload 5
    //   1364: astore_0
    //   1365: aload 16
    //   1367: instanceof 684
    //   1370: ifeq +12 -> 1382
    //   1373: aload 16
    //   1375: checkcast 684	com/tencent/mobileqq/data/MessageForTroopFile
    //   1378: invokevirtual 685	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1381: astore_0
    //   1382: aload 19
    //   1384: aload_0
    //   1385: aconst_null
    //   1386: aload_1
    //   1387: aload_2
    //   1388: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1391: aload_1
    //   1392: aload_2
    //   1393: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1396: aload 4
    //   1398: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1401: return
    //   1402: aload_2
    //   1403: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1406: invokestatic 687	bbbu:b	(I)Z
    //   1409: ifeq +35 -> 1444
    //   1412: aload_2
    //   1413: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1416: invokestatic 692	aywk:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1419: astore_1
    //   1420: aload_1
    //   1421: ifnull -1417 -> 4
    //   1424: aload 4
    //   1426: aload_1
    //   1427: aload_0
    //   1428: aload_2
    //   1429: getfield 695	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   1432: invokestatic 696	bbfh:b	(I)Z
    //   1435: iload 7
    //   1437: invokestatic 698	bbfh:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1440: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1443: return
    //   1444: aload_2
    //   1445: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1448: invokestatic 700	bbbu:c	(I)Z
    //   1451: ifeq +39 -> 1490
    //   1454: aload_2
    //   1455: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1458: invokestatic 692	aywk:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1461: astore 5
    //   1463: aload 5
    //   1465: ifnull -1461 -> 4
    //   1468: aload 4
    //   1470: aload_1
    //   1471: aload 5
    //   1473: aload_0
    //   1474: aload_2
    //   1475: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1478: aload_2
    //   1479: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1482: iload_3
    //   1483: invokestatic 702	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1486: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1489: return
    //   1490: aload_2
    //   1491: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1494: invokestatic 704	bbbu:d	(I)Z
    //   1497: ifeq +134 -> 1631
    //   1500: aload_1
    //   1501: aload_2
    //   1502: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1505: istore 6
    //   1507: aload_1
    //   1508: aload_2
    //   1509: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1512: istore 7
    //   1514: aload_2
    //   1515: ldc_w 706
    //   1518: invokevirtual 709	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1521: astore 5
    //   1523: getstatic 714	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1526: ifeq +96 -> 1622
    //   1529: aload 5
    //   1531: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1534: ifne +88 -> 1622
    //   1537: aload_0
    //   1538: aload_2
    //   1539: invokestatic 719	anqz:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1542: astore_0
    //   1543: aload_2
    //   1544: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1547: aload_1
    //   1548: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1551: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1554: ifeq +41 -> 1595
    //   1557: new 160	java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1564: ldc_w 720
    //   1567: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   1570: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: aload_0
    //   1574: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: astore_0
    //   1581: aload 19
    //   1583: aload_0
    //   1584: aconst_null
    //   1585: iload 6
    //   1587: iload 7
    //   1589: aload 4
    //   1591: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1594: return
    //   1595: new 160	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1602: ldc_w 721
    //   1605: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   1608: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload_0
    //   1612: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: astore_0
    //   1619: goto -38 -> 1581
    //   1622: aload_0
    //   1623: aload_2
    //   1624: invokestatic 719	anqz:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1627: astore_0
    //   1628: goto -47 -> 1581
    //   1631: aload_2
    //   1632: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1635: sipush -2058
    //   1638: if_icmpne +1070 -> 2708
    //   1641: ldc 119
    //   1643: astore 18
    //   1645: aload_1
    //   1646: aload_2
    //   1647: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1650: istore 12
    //   1652: aload_1
    //   1653: aload_2
    //   1654: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1657: istore 13
    //   1659: iconst_0
    //   1660: istore 8
    //   1662: aload 18
    //   1664: astore 17
    //   1666: aload_2
    //   1667: ldc_w 723
    //   1670: invokevirtual 709	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1673: astore 5
    //   1675: aload 18
    //   1677: astore 16
    //   1679: aload 18
    //   1681: astore 17
    //   1683: aload 5
    //   1685: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1688: ifne +270 -> 1958
    //   1691: aload 18
    //   1693: astore 17
    //   1695: new 725	org/json/JSONObject
    //   1698: dup
    //   1699: aload 5
    //   1701: invokespecial 728	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1704: ldc_w 730
    //   1707: invokevirtual 733	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1710: istore 9
    //   1712: iload 8
    //   1714: istore_3
    //   1715: aload 18
    //   1717: astore 5
    //   1719: aload 18
    //   1721: astore 17
    //   1723: aload_2
    //   1724: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1727: ifnull +114 -> 1841
    //   1730: iload 8
    //   1732: istore_3
    //   1733: aload 18
    //   1735: astore 5
    //   1737: iload 9
    //   1739: sipush -2007
    //   1742: if_icmpne +99 -> 1841
    //   1745: iload 8
    //   1747: istore_3
    //   1748: aload 18
    //   1750: astore 5
    //   1752: aload 18
    //   1754: astore 17
    //   1756: aload_2
    //   1757: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1760: invokestatic 742	akwa:a	([B)Ljava/lang/Object;
    //   1763: instanceof 744
    //   1766: ifeq +75 -> 1841
    //   1769: aload 18
    //   1771: astore 17
    //   1773: getstatic 714	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1776: ifeq +232 -> 2008
    //   1779: aload 18
    //   1781: astore 17
    //   1783: aload_0
    //   1784: aload_2
    //   1785: invokestatic 719	anqz:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1788: astore 5
    //   1790: aload 18
    //   1792: astore 17
    //   1794: aload_2
    //   1795: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1798: aload_1
    //   1799: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1802: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1805: ifeq +170 -> 1975
    //   1808: aload 18
    //   1810: astore 17
    //   1812: new 160	java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1819: ldc_w 745
    //   1822: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   1825: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: aload 5
    //   1830: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1836: astore 5
    //   1838: goto +5891 -> 7729
    //   1841: aload 5
    //   1843: astore 16
    //   1845: iload_3
    //   1846: ifne +112 -> 1958
    //   1849: aload 5
    //   1851: astore 17
    //   1853: getstatic 714	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1856: ifeq +208 -> 2064
    //   1859: aload 5
    //   1861: astore 17
    //   1863: aload_2
    //   1864: ldc_w 706
    //   1867: invokevirtual 709	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1870: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1873: ifne +5808 -> 7681
    //   1876: aload 5
    //   1878: astore 17
    //   1880: aload_1
    //   1881: aload_2
    //   1882: aload 4
    //   1884: invokestatic 748	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Laykk;
    //   1887: astore_0
    //   1888: new 160	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1895: astore_1
    //   1896: aload 19
    //   1898: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1901: ifne +16 -> 1917
    //   1904: aload_1
    //   1905: aload 19
    //   1907: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: ldc_w 377
    //   1913: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: pop
    //   1917: aload_2
    //   1918: invokestatic 503	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1921: ifne +16 -> 1937
    //   1924: iload 12
    //   1926: ifeq +98 -> 2024
    //   1929: aload_1
    //   1930: ldc_w 750
    //   1933: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: pop
    //   1937: aload_0
    //   1938: checkcast 752	aykk
    //   1941: aload_1
    //   1942: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1945: iconst_1
    //   1946: iconst_0
    //   1947: newarray int
    //   1949: invokevirtual 755	aykk:a	(Ljava/lang/String;Z[I)Laykk;
    //   1952: astore_1
    //   1953: aload_1
    //   1954: astore_0
    //   1955: aload_0
    //   1956: astore 16
    //   1958: aload 16
    //   1960: astore_2
    //   1961: aload 19
    //   1963: aload_2
    //   1964: aconst_null
    //   1965: iload 12
    //   1967: iload 13
    //   1969: aload 4
    //   1971: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1974: return
    //   1975: aload 18
    //   1977: astore 17
    //   1979: new 160	java/lang/StringBuilder
    //   1982: dup
    //   1983: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1986: ldc_w 756
    //   1989: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   1992: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: aload 5
    //   1997: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2003: astore 5
    //   2005: goto +5724 -> 7729
    //   2008: aload 18
    //   2010: astore 17
    //   2012: aload_0
    //   2013: aload_2
    //   2014: invokestatic 719	anqz:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   2017: astore 5
    //   2019: iconst_1
    //   2020: istore_3
    //   2021: goto -180 -> 1841
    //   2024: iload 13
    //   2026: ifeq -89 -> 1937
    //   2029: aload_1
    //   2030: ldc_w 758
    //   2033: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: pop
    //   2037: goto -100 -> 1937
    //   2040: astore_1
    //   2041: aload_0
    //   2042: astore_2
    //   2043: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2046: ifeq -85 -> 1961
    //   2049: ldc_w 760
    //   2052: iconst_2
    //   2053: ldc 119
    //   2055: aload_1
    //   2056: invokestatic 763	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2059: aload_0
    //   2060: astore_2
    //   2061: goto -100 -> 1961
    //   2064: iload 9
    //   2066: sipush -1000
    //   2069: if_icmpne +153 -> 2222
    //   2072: aload 5
    //   2074: astore 17
    //   2076: aload_2
    //   2077: invokestatic 766	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Laykk;
    //   2080: astore_0
    //   2081: aload_0
    //   2082: ifnull -2078 -> 4
    //   2085: aload 5
    //   2087: astore 17
    //   2089: new 160	java/lang/StringBuilder
    //   2092: dup
    //   2093: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2096: astore_1
    //   2097: aload 5
    //   2099: astore 17
    //   2101: aload 19
    //   2103: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2106: ifne +20 -> 2126
    //   2109: aload 5
    //   2111: astore 17
    //   2113: aload_1
    //   2114: aload 19
    //   2116: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: ldc_w 377
    //   2122: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: pop
    //   2126: aload 5
    //   2128: astore 17
    //   2130: aload_2
    //   2131: invokestatic 503	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2134: ifne +20 -> 2154
    //   2137: iload 12
    //   2139: ifeq +63 -> 2202
    //   2142: aload 5
    //   2144: astore 17
    //   2146: aload_1
    //   2147: ldc_w 750
    //   2150: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2153: pop
    //   2154: aload 5
    //   2156: astore 17
    //   2158: aload_0
    //   2159: checkcast 752	aykk
    //   2162: aload_1
    //   2163: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2166: iconst_1
    //   2167: iconst_0
    //   2168: newarray int
    //   2170: invokevirtual 755	aykk:a	(Ljava/lang/String;Z[I)Laykk;
    //   2173: astore_0
    //   2174: aload 5
    //   2176: astore 17
    //   2178: aload 4
    //   2180: iconst_1
    //   2181: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2184: aload 5
    //   2186: astore 17
    //   2188: aload 19
    //   2190: aload_0
    //   2191: aconst_null
    //   2192: iload 12
    //   2194: iload 13
    //   2196: aload 4
    //   2198: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2201: return
    //   2202: iload 13
    //   2204: ifeq -50 -> 2154
    //   2207: aload 5
    //   2209: astore 17
    //   2211: aload_1
    //   2212: ldc_w 758
    //   2215: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: pop
    //   2219: goto -65 -> 2154
    //   2222: aload 5
    //   2224: astore 16
    //   2226: iload 9
    //   2228: sipush -2000
    //   2231: if_icmpne -273 -> 1958
    //   2234: iconst_0
    //   2235: istore 11
    //   2237: iconst_0
    //   2238: istore 7
    //   2240: aconst_null
    //   2241: astore 18
    //   2243: aload 18
    //   2245: astore 16
    //   2247: aload_2
    //   2248: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2251: astore 17
    //   2253: aload 18
    //   2255: astore 16
    //   2257: aload_2
    //   2258: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2261: aload_2
    //   2262: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2265: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   2268: ifeq +5410 -> 7678
    //   2271: aload 18
    //   2273: astore 16
    //   2275: aload_2
    //   2276: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2279: astore 17
    //   2281: aload 18
    //   2283: astore 16
    //   2285: aload_1
    //   2286: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   2289: aload 17
    //   2291: aload_2
    //   2292: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2295: aload_2
    //   2296: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2299: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2302: checkcast 311	com/tencent/mobileqq/data/MessageForPic
    //   2305: astore 20
    //   2307: aload 18
    //   2309: astore 16
    //   2311: aload_1
    //   2312: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Layvx;
    //   2315: aload 17
    //   2317: aload_2
    //   2318: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2321: invokevirtual 595	ayvx:a	(Ljava/lang/String;J)Lbbmw;
    //   2324: astore_1
    //   2325: aload_1
    //   2326: astore 16
    //   2328: aload_2
    //   2329: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2332: ifeq +245 -> 2577
    //   2335: aload_1
    //   2336: astore 16
    //   2338: aload 20
    //   2340: getfield 598	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2343: lstore 14
    //   2345: lload 14
    //   2347: lconst_0
    //   2348: lcmp
    //   2349: ifgt +208 -> 2557
    //   2352: aload_1
    //   2353: ifnonnull +5319 -> 7672
    //   2356: aload 20
    //   2358: ifnull +5314 -> 7672
    //   2361: iconst_1
    //   2362: istore 6
    //   2364: iload 6
    //   2366: istore 10
    //   2368: aload 5
    //   2370: astore 17
    //   2372: aload_1
    //   2373: instanceof 600
    //   2376: ifeq +269 -> 2645
    //   2379: aload 5
    //   2381: astore 17
    //   2383: aload_1
    //   2384: checkcast 600	aypb
    //   2387: astore_1
    //   2388: aload 5
    //   2390: astore 17
    //   2392: aload_1
    //   2393: invokevirtual 602	aypb:c	()J
    //   2396: ldc2_w 603
    //   2399: lcmp
    //   2400: ifeq +6 -> 2406
    //   2403: iconst_1
    //   2404: istore 7
    //   2406: iload 7
    //   2408: istore 6
    //   2410: aload 5
    //   2412: astore 17
    //   2414: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2417: ifeq +76 -> 2493
    //   2420: aload 5
    //   2422: astore 17
    //   2424: aload_1
    //   2425: getfield 607	aypb:a	Laywc;
    //   2428: ifnull +5319 -> 7747
    //   2431: aload 5
    //   2433: astore 17
    //   2435: aload_1
    //   2436: getfield 607	aypb:a	Laywc;
    //   2439: getfield 610	aywc:jdField_a_of_type_Long	J
    //   2442: lstore 14
    //   2444: aload 5
    //   2446: astore 17
    //   2448: ldc_w 612
    //   2451: iconst_2
    //   2452: new 160	java/lang/StringBuilder
    //   2455: dup
    //   2456: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2459: ldc_w 614
    //   2462: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: lload 14
    //   2467: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2470: ldc_w 616
    //   2473: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: aload_1
    //   2477: invokevirtual 618	aypb:a	()Ljava/lang/String;
    //   2480: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2486: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2489: iload 7
    //   2491: istore 6
    //   2493: aload 5
    //   2495: astore 17
    //   2497: aload_0
    //   2498: ldc_w 619
    //   2501: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   2504: astore_1
    //   2505: aload 5
    //   2507: astore 17
    //   2509: aload_2
    //   2510: invokestatic 622	ajyi:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2513: ifne +14 -> 2527
    //   2516: aload 5
    //   2518: astore 17
    //   2520: aload_2
    //   2521: invokestatic 625	ajwb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2524: ifeq +15 -> 2539
    //   2527: aload 5
    //   2529: astore 17
    //   2531: aload_0
    //   2532: ldc_w 626
    //   2535: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   2538: astore_1
    //   2539: aload 5
    //   2541: astore 17
    //   2543: aload 19
    //   2545: aload_1
    //   2546: aconst_null
    //   2547: iload 10
    //   2549: iload 6
    //   2551: aload 4
    //   2553: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2556: return
    //   2557: aload_1
    //   2558: astore 16
    //   2560: aload 20
    //   2562: getfield 632	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2565: ldc_w 633
    //   2568: if_icmpne +5173 -> 7741
    //   2571: iconst_1
    //   2572: istore 6
    //   2574: goto -210 -> 2364
    //   2577: aload_1
    //   2578: ifnull +5094 -> 7672
    //   2581: aload_1
    //   2582: astore 16
    //   2584: aload_1
    //   2585: instanceof 600
    //   2588: ifeq +5084 -> 7672
    //   2591: aload_1
    //   2592: astore 16
    //   2594: aload_1
    //   2595: checkcast 600	aypb
    //   2598: invokevirtual 602	aypb:c	()J
    //   2601: lstore 14
    //   2603: lload 14
    //   2605: l2i
    //   2606: istore_3
    //   2607: iload_3
    //   2608: sipush 1005
    //   2611: if_icmpeq +10 -> 2621
    //   2614: iload_3
    //   2615: sipush 1004
    //   2618: if_icmpne +5054 -> 7672
    //   2621: iconst_1
    //   2622: istore 6
    //   2624: goto -260 -> 2364
    //   2627: astore_1
    //   2628: aload 5
    //   2630: astore 17
    //   2632: aload_1
    //   2633: invokevirtual 470	java/lang/Exception:printStackTrace	()V
    //   2636: aload 16
    //   2638: astore_1
    //   2639: iconst_0
    //   2640: istore 10
    //   2642: goto -274 -> 2368
    //   2645: iload 11
    //   2647: istore 6
    //   2649: aload_1
    //   2650: ifnull -157 -> 2493
    //   2653: iconst_1
    //   2654: istore 7
    //   2656: iload 7
    //   2658: istore 6
    //   2660: aload 5
    //   2662: astore 17
    //   2664: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2667: ifeq -174 -> 2493
    //   2670: aload 5
    //   2672: astore 17
    //   2674: ldc_w 612
    //   2677: iconst_2
    //   2678: new 160	java/lang/StringBuilder
    //   2681: dup
    //   2682: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2685: ldc_w 635
    //   2688: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: aload_1
    //   2692: invokevirtual 638	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2695: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2698: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2701: iload 7
    //   2703: istore 6
    //   2705: goto -212 -> 2493
    //   2708: aload_2
    //   2709: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2712: invokestatic 771	bbbu:e	(I)Z
    //   2715: ifeq +267 -> 2982
    //   2718: new 773	com/tencent/mobileqq/data/MessageForApollo
    //   2721: dup
    //   2722: invokespecial 774	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2725: astore 5
    //   2727: aload 5
    //   2729: aload_2
    //   2730: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2733: putfield 775	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2736: aload 5
    //   2738: invokevirtual 776	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2741: aload_1
    //   2742: aload_2
    //   2743: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2746: istore 6
    //   2748: aload_1
    //   2749: aload_2
    //   2750: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2753: istore 7
    //   2755: aload 5
    //   2757: getfield 778	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2760: invokestatic 781	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2763: ifeq +209 -> 2972
    //   2766: ldc_w 782
    //   2769: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   2772: astore_0
    //   2773: aload 5
    //   2775: getfield 778	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2778: iconst_4
    //   2779: if_icmpne +155 -> 2934
    //   2782: aload 5
    //   2784: getfield 785	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2787: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2790: ifeq +43 -> 2833
    //   2793: new 160	java/lang/StringBuilder
    //   2796: dup
    //   2797: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2800: aload_0
    //   2801: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2804: ldc_w 786
    //   2807: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   2810: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2816: astore_1
    //   2817: aload_1
    //   2818: astore_0
    //   2819: aload 19
    //   2821: aload_0
    //   2822: aconst_null
    //   2823: iload 6
    //   2825: iload 7
    //   2827: aload 4
    //   2829: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2832: return
    //   2833: new 725	org/json/JSONObject
    //   2836: dup
    //   2837: aload 5
    //   2839: getfield 785	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2842: invokespecial 728	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2845: ldc_w 788
    //   2848: invokevirtual 791	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2851: astore_1
    //   2852: aload_1
    //   2853: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2856: ifeq +32 -> 2888
    //   2859: new 160	java/lang/StringBuilder
    //   2862: dup
    //   2863: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2866: aload_0
    //   2867: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2870: ldc_w 792
    //   2873: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   2876: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2879: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2882: astore_1
    //   2883: aload_1
    //   2884: astore_0
    //   2885: goto -66 -> 2819
    //   2888: new 160	java/lang/StringBuilder
    //   2891: dup
    //   2892: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2895: aload_0
    //   2896: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2899: ldc_w 481
    //   2902: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2905: aload_1
    //   2906: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2909: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2912: astore_1
    //   2913: aload_1
    //   2914: astore_0
    //   2915: goto -96 -> 2819
    //   2918: astore_1
    //   2919: ldc_w 760
    //   2922: iconst_1
    //   2923: aload_1
    //   2924: iconst_0
    //   2925: anewarray 4	java/lang/Object
    //   2928: invokestatic 795	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2931: goto -112 -> 2819
    //   2934: aload_1
    //   2935: aload 5
    //   2937: invokestatic 800	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2940: astore_1
    //   2941: new 160	java/lang/StringBuilder
    //   2944: dup
    //   2945: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2948: aload_0
    //   2949: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2952: ldc_w 801
    //   2955: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   2958: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: aload_1
    //   2962: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2965: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2968: astore_0
    //   2969: goto -150 -> 2819
    //   2972: aload_1
    //   2973: aload 5
    //   2975: invokestatic 803	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2978: astore_0
    //   2979: goto -160 -> 2819
    //   2982: aload_2
    //   2983: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2986: sipush -1013
    //   2989: if_icmpeq +13 -> 3002
    //   2992: aload_2
    //   2993: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2996: sipush -1047
    //   2999: if_icmpne +20 -> 3019
    //   3002: aconst_null
    //   3003: aconst_null
    //   3004: aload_2
    //   3005: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3008: invokestatic 554	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3011: iconst_0
    //   3012: iconst_0
    //   3013: aload 4
    //   3015: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3018: return
    //   3019: aload_2
    //   3020: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3023: sipush -2042
    //   3026: if_icmpeq +13 -> 3039
    //   3029: aload_2
    //   3030: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3033: sipush -2043
    //   3036: if_icmpne +20 -> 3056
    //   3039: aconst_null
    //   3040: aload_2
    //   3041: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3044: invokestatic 554	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3047: aconst_null
    //   3048: iconst_0
    //   3049: iconst_0
    //   3050: aload 4
    //   3052: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3055: return
    //   3056: aload_2
    //   3057: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3060: sipush -2051
    //   3063: if_icmpne +155 -> 3218
    //   3066: aload_1
    //   3067: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3070: aload_2
    //   3071: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3074: aload_2
    //   3075: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3078: aload_2
    //   3079: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3082: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3085: astore_0
    //   3086: aload_0
    //   3087: ifnull +50 -> 3137
    //   3090: aload_0
    //   3091: instanceof 805
    //   3094: ifeq +43 -> 3137
    //   3097: aload_0
    //   3098: checkcast 805	com/tencent/mobileqq/data/MessageForQQStory
    //   3101: astore_0
    //   3102: aload_0
    //   3103: invokevirtual 806	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3106: aload_1
    //   3107: aload_2
    //   3108: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3111: istore 6
    //   3113: aload_1
    //   3114: aload_2
    //   3115: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3118: istore 7
    //   3120: aload 19
    //   3122: aconst_null
    //   3123: aload_0
    //   3124: invokevirtual 807	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3127: iload 6
    //   3129: iload 7
    //   3131: aload 4
    //   3133: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3136: return
    //   3137: new 160	java/lang/StringBuilder
    //   3140: dup
    //   3141: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3144: ldc 2
    //   3146: invokevirtual 812	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3149: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3152: ldc_w 814
    //   3155: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3158: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3161: astore_1
    //   3162: new 160	java/lang/StringBuilder
    //   3165: dup
    //   3166: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3169: ldc_w 816
    //   3172: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: aload_2
    //   3176: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3179: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3182: ldc_w 818
    //   3185: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3188: astore_2
    //   3189: aload_0
    //   3190: ifnull +22 -> 3212
    //   3193: aload_0
    //   3194: invokevirtual 821	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3197: astore_0
    //   3198: aload_1
    //   3199: iconst_1
    //   3200: aload_2
    //   3201: aload_0
    //   3202: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3208: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3211: return
    //   3212: ldc 119
    //   3214: astore_0
    //   3215: goto -17 -> 3198
    //   3218: aload_2
    //   3219: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3222: sipush -7002
    //   3225: if_icmpne +148 -> 3373
    //   3228: aload_1
    //   3229: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3232: aload_2
    //   3233: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3236: aload_2
    //   3237: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3240: aload_2
    //   3241: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3244: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3247: checkcast 825	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3250: astore_0
    //   3251: aload_0
    //   3252: ifnull +38 -> 3290
    //   3255: aload_0
    //   3256: invokevirtual 826	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3259: aload_1
    //   3260: aload_2
    //   3261: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3264: istore 6
    //   3266: aload_1
    //   3267: aload_2
    //   3268: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3271: istore 7
    //   3273: aload 19
    //   3275: aconst_null
    //   3276: aload_0
    //   3277: invokevirtual 827	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3280: iload 6
    //   3282: iload 7
    //   3284: aload 4
    //   3286: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3289: return
    //   3290: new 160	java/lang/StringBuilder
    //   3293: dup
    //   3294: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3297: ldc 2
    //   3299: invokevirtual 812	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3302: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3305: ldc_w 814
    //   3308: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3314: astore_1
    //   3315: new 160	java/lang/StringBuilder
    //   3318: dup
    //   3319: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3322: ldc_w 829
    //   3325: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3328: aload_2
    //   3329: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3332: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3335: ldc_w 818
    //   3338: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: astore 4
    //   3343: aload_2
    //   3344: ifnull +23 -> 3367
    //   3347: aload_2
    //   3348: invokevirtual 830	com/tencent/mobileqq/app/message/QQMessageFacade$Message:toString	()Ljava/lang/String;
    //   3351: astore_0
    //   3352: aload_1
    //   3353: iconst_1
    //   3354: aload 4
    //   3356: aload_0
    //   3357: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3360: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3363: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3366: return
    //   3367: ldc 119
    //   3369: astore_0
    //   3370: goto -18 -> 3352
    //   3373: aload_2
    //   3374: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3377: sipush -2054
    //   3380: if_icmpne +153 -> 3533
    //   3383: aload_1
    //   3384: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3387: aload_2
    //   3388: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3391: aload_2
    //   3392: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3395: aload_2
    //   3396: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3399: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3402: astore_0
    //   3403: aload_0
    //   3404: instanceof 832
    //   3407: ifeq +42 -> 3449
    //   3410: aload_0
    //   3411: checkcast 832	com/tencent/mobileqq/data/MessageForTroopSign
    //   3414: astore_0
    //   3415: ldc_w 833
    //   3418: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   3421: pop
    //   3422: aload_0
    //   3423: invokevirtual 834	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3426: aload 19
    //   3428: aconst_null
    //   3429: aload_0
    //   3430: invokevirtual 835	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3433: aload_1
    //   3434: aload_2
    //   3435: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3438: aload_1
    //   3439: aload_2
    //   3440: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3443: aload 4
    //   3445: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3448: return
    //   3449: new 160	java/lang/StringBuilder
    //   3452: dup
    //   3453: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3456: ldc 2
    //   3458: invokevirtual 812	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3461: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3464: ldc_w 837
    //   3467: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3473: astore_1
    //   3474: new 160	java/lang/StringBuilder
    //   3477: dup
    //   3478: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3481: ldc_w 839
    //   3484: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3487: aload_2
    //   3488: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3491: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3494: ldc_w 818
    //   3497: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3500: astore_2
    //   3501: aload_0
    //   3502: ifnull +25 -> 3527
    //   3505: aload_0
    //   3506: getfield 840	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3509: invokestatic 672	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3512: astore_0
    //   3513: aload_1
    //   3514: iconst_1
    //   3515: aload_2
    //   3516: aload_0
    //   3517: invokevirtual 638	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3520: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3523: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3526: return
    //   3527: ldc 119
    //   3529: astore_0
    //   3530: goto -17 -> 3513
    //   3533: aload_2
    //   3534: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3537: sipush -2035
    //   3540: if_icmpne +20 -> 3560
    //   3543: aconst_null
    //   3544: aload_2
    //   3545: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3548: invokestatic 554	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3551: aconst_null
    //   3552: iconst_0
    //   3553: iconst_0
    //   3554: aload 4
    //   3556: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3559: return
    //   3560: aload_2
    //   3561: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3564: sipush -2038
    //   3567: if_icmpne +205 -> 3772
    //   3570: aload_2
    //   3571: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3574: astore_0
    //   3575: getstatic 845	ajsd:aj	Ljava/lang/String;
    //   3578: aload_0
    //   3579: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3582: ifeq +4087 -> 7669
    //   3585: aload_2
    //   3586: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3589: astore_0
    //   3590: aload_0
    //   3591: astore 5
    //   3593: getstatic 848	ajsd:H	Ljava/lang/String;
    //   3596: aload_0
    //   3597: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3600: ifeq +59 -> 3659
    //   3603: getstatic 845	ajsd:aj	Ljava/lang/String;
    //   3606: aload_2
    //   3607: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3610: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3613: ifeq +103 -> 3716
    //   3616: aload_1
    //   3617: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3620: getstatic 845	ajsd:aj	Ljava/lang/String;
    //   3623: aload_2
    //   3624: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3627: aload_2
    //   3628: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3631: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3634: checkcast 850	com/tencent/mobileqq/data/MessageForTroopGift
    //   3637: astore 16
    //   3639: aload_0
    //   3640: astore 5
    //   3642: aload 16
    //   3644: ifnull +15 -> 3659
    //   3647: aload 16
    //   3649: invokevirtual 851	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3652: aload 16
    //   3654: getfield 852	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3657: astore 5
    //   3659: aload_1
    //   3660: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3663: aload 5
    //   3665: aload_2
    //   3666: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3669: aload_2
    //   3670: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3673: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3676: astore_0
    //   3677: aload_0
    //   3678: instanceof 850
    //   3681: ifeq +50 -> 3731
    //   3684: aload_0
    //   3685: checkcast 850	com/tencent/mobileqq/data/MessageForTroopGift
    //   3688: astore_0
    //   3689: aload_0
    //   3690: invokevirtual 851	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3693: aload_0
    //   3694: getfield 853	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3697: ifnull +28 -> 3725
    //   3700: aload_0
    //   3701: getfield 853	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3704: astore_0
    //   3705: aconst_null
    //   3706: aload_0
    //   3707: aconst_null
    //   3708: iconst_0
    //   3709: iconst_0
    //   3710: aload 4
    //   3712: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3715: return
    //   3716: aload_2
    //   3717: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3720: astore 5
    //   3722: goto -63 -> 3659
    //   3725: ldc 119
    //   3727: astore_0
    //   3728: goto -23 -> 3705
    //   3731: aload_0
    //   3732: ifnull -3728 -> 4
    //   3735: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3738: ifeq -3734 -> 4
    //   3741: ldc_w 760
    //   3744: iconst_2
    //   3745: new 160	java/lang/StringBuilder
    //   3748: dup
    //   3749: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3752: ldc_w 855
    //   3755: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: aload_0
    //   3759: invokevirtual 821	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3762: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3765: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3768: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3771: return
    //   3772: aload_2
    //   3773: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3776: sipush -2036
    //   3779: if_icmpne +48 -> 3827
    //   3782: aload_1
    //   3783: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3786: aload_2
    //   3787: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3790: aload_2
    //   3791: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3794: aload_2
    //   3795: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3798: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3801: checkcast 857	com/tencent/mobileqq/data/MessageForTroopFee
    //   3804: astore_0
    //   3805: aload_0
    //   3806: ifnull -3802 -> 4
    //   3809: aload_0
    //   3810: invokevirtual 858	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3813: aconst_null
    //   3814: aload_0
    //   3815: getfield 859	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3818: aconst_null
    //   3819: iconst_0
    //   3820: iconst_0
    //   3821: aload 4
    //   3823: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3826: return
    //   3827: aload_2
    //   3828: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3831: sipush -2069
    //   3834: if_icmpne +48 -> 3882
    //   3837: aload_1
    //   3838: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3841: aload_2
    //   3842: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3845: aload_2
    //   3846: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3849: aload_2
    //   3850: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3853: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3856: checkcast 861	com/tencent/mobileqq/data/MessageForStarLeague
    //   3859: astore_0
    //   3860: aload_0
    //   3861: ifnull -3857 -> 4
    //   3864: aload_0
    //   3865: invokevirtual 862	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3868: aconst_null
    //   3869: aload_0
    //   3870: getfield 863	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3873: aconst_null
    //   3874: iconst_0
    //   3875: iconst_0
    //   3876: aload 4
    //   3878: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3881: return
    //   3882: aload_2
    //   3883: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3886: sipush -2048
    //   3889: if_icmpne +49 -> 3938
    //   3892: aload_1
    //   3893: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3896: aload_2
    //   3897: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3900: aload_2
    //   3901: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3904: aload_2
    //   3905: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3908: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3911: checkcast 865	com/tencent/mobileqq/data/MessageForTroopReward
    //   3914: astore_0
    //   3915: aload_0
    //   3916: ifnull -3912 -> 4
    //   3919: aload_0
    //   3920: invokevirtual 866	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3923: aload 19
    //   3925: aload_0
    //   3926: getfield 867	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3929: aconst_null
    //   3930: iconst_0
    //   3931: iconst_0
    //   3932: aload 4
    //   3934: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3937: return
    //   3938: aload_2
    //   3939: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3942: iconst_1
    //   3943: if_icmpne +85 -> 4028
    //   3946: aload_2
    //   3947: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3950: sipush -3006
    //   3953: if_icmpne +75 -> 4028
    //   3956: aload_1
    //   3957: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3960: aload_2
    //   3961: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3964: aload_2
    //   3965: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3968: aload_2
    //   3969: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3972: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3975: checkcast 869	com/tencent/mobileqq/data/MessageForPubAccount
    //   3978: astore_0
    //   3979: aload_0
    //   3980: ifnull -3976 -> 4
    //   3983: aload_0
    //   3984: invokevirtual 870	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3987: aload_1
    //   3988: aload_0
    //   3989: iconst_0
    //   3990: invokestatic 874	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3993: astore_2
    //   3994: aload_0
    //   3995: invokevirtual 877	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3998: ifne +16 -> 4014
    //   4001: aconst_null
    //   4002: astore_0
    //   4003: aload_0
    //   4004: aload_2
    //   4005: aconst_null
    //   4006: iconst_0
    //   4007: iconst_0
    //   4008: aload 4
    //   4010: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4013: return
    //   4014: aload_1
    //   4015: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4018: ldc_w 878
    //   4021: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4024: astore_0
    //   4025: goto -22 -> 4003
    //   4028: aload_2
    //   4029: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4032: sipush -1034
    //   4035: if_icmpne +106 -> 4141
    //   4038: new 880	com/tencent/mobileqq/data/MessageForRichState
    //   4041: dup
    //   4042: invokespecial 881	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   4045: astore_0
    //   4046: aload_0
    //   4047: aload_2
    //   4048: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4051: putfield 882	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   4054: aload_0
    //   4055: invokevirtual 883	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   4058: new 160	java/lang/StringBuilder
    //   4061: dup
    //   4062: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4065: astore_1
    //   4066: aload_0
    //   4067: getfield 886	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4070: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4073: ifne +38 -> 4111
    //   4076: aload_1
    //   4077: aload_0
    //   4078: getfield 886	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4081: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: pop
    //   4085: aload_0
    //   4086: getfield 889	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4089: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4092: ifne +12 -> 4104
    //   4095: aload_1
    //   4096: aload_0
    //   4097: getfield 889	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4100: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4103: pop
    //   4104: aload_1
    //   4105: bipush 32
    //   4107: invokevirtual 892	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   4110: pop
    //   4111: aload_1
    //   4112: aload_0
    //   4113: invokevirtual 895	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   4116: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4119: pop
    //   4120: aload_1
    //   4121: invokevirtual 896	java/lang/StringBuilder:length	()I
    //   4124: ifle -4120 -> 4
    //   4127: aconst_null
    //   4128: aload_1
    //   4129: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4132: aconst_null
    //   4133: iconst_0
    //   4134: iconst_0
    //   4135: aload 4
    //   4137: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4140: return
    //   4141: aload_2
    //   4142: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4145: sipush -2074
    //   4148: if_icmpne +47 -> 4195
    //   4151: new 898	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4154: dup
    //   4155: invokespecial 899	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4158: astore_0
    //   4159: aload_0
    //   4160: aload_2
    //   4161: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4164: putfield 900	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4167: aload_0
    //   4168: invokevirtual 901	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4171: aload_0
    //   4172: getfield 904	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4175: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4178: ifne -4174 -> 4
    //   4181: aconst_null
    //   4182: aload_0
    //   4183: getfield 904	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4186: aconst_null
    //   4187: iconst_0
    //   4188: iconst_0
    //   4189: aload 4
    //   4191: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4194: return
    //   4195: aload_2
    //   4196: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4199: sipush -1019
    //   4202: if_icmpne +48 -> 4250
    //   4205: aconst_null
    //   4206: aconst_null
    //   4207: new 160	java/lang/StringBuilder
    //   4210: dup
    //   4211: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4214: ldc_w 905
    //   4217: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   4220: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4223: aload_2
    //   4224: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4227: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4230: ldc_w 906
    //   4233: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   4236: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4239: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4242: iconst_0
    //   4243: iconst_0
    //   4244: aload 4
    //   4246: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4249: return
    //   4250: aload_2
    //   4251: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4254: sipush -1018
    //   4257: if_icmpne +48 -> 4305
    //   4260: aconst_null
    //   4261: aconst_null
    //   4262: new 160	java/lang/StringBuilder
    //   4265: dup
    //   4266: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4269: ldc_w 907
    //   4272: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   4275: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4278: aload_2
    //   4279: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4282: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4285: ldc_w 908
    //   4288: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   4291: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4294: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4297: iconst_0
    //   4298: iconst_0
    //   4299: aload 4
    //   4301: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4304: return
    //   4305: aload_2
    //   4306: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4309: sipush -2019
    //   4312: if_icmpne +16 -> 4328
    //   4315: aload 4
    //   4317: aload_0
    //   4318: ldc_w 909
    //   4321: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4324: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4327: return
    //   4328: aload_2
    //   4329: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4332: sipush -7006
    //   4335: if_icmpne +16 -> 4351
    //   4338: aload 4
    //   4340: aload_0
    //   4341: ldc_w 910
    //   4344: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4347: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4350: return
    //   4351: aload_2
    //   4352: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4355: sipush -1026
    //   4358: if_icmpne +16 -> 4374
    //   4361: aload 4
    //   4363: aload_0
    //   4364: ldc_w 911
    //   4367: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4370: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4373: return
    //   4374: aload_2
    //   4375: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4378: sipush -1027
    //   4381: if_icmpne +16 -> 4397
    //   4384: aload 4
    //   4386: aload_0
    //   4387: ldc_w 912
    //   4390: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4393: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4396: return
    //   4397: aload_2
    //   4398: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4401: sipush -2005
    //   4404: if_icmpne +56 -> 4460
    //   4407: aload_1
    //   4408: aload_2
    //   4409: invokestatic 915	apug:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4412: astore 5
    //   4414: aload_1
    //   4415: aload_2
    //   4416: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   4419: istore 6
    //   4421: aload_1
    //   4422: aload_2
    //   4423: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   4426: istore 7
    //   4428: aload 19
    //   4430: aload_0
    //   4431: ldc_w 916
    //   4434: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4437: aconst_null
    //   4438: iload 6
    //   4440: iload 7
    //   4442: aload 4
    //   4444: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4447: aload 5
    //   4449: ifnull -4445 -> 4
    //   4452: aload 4
    //   4454: aload 5
    //   4456: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4459: return
    //   4460: aload_2
    //   4461: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4464: sipush -2022
    //   4467: if_icmpeq +13 -> 4480
    //   4470: aload_2
    //   4471: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4474: sipush -2071
    //   4477: if_icmpne +700 -> 5177
    //   4480: iconst_0
    //   4481: istore 7
    //   4483: iconst_0
    //   4484: istore 10
    //   4486: aload_1
    //   4487: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   4490: aload_2
    //   4491: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4494: aload_2
    //   4495: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4498: aload_2
    //   4499: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4502: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4505: astore 5
    //   4507: aload 5
    //   4509: instanceof 918
    //   4512: ifeq -4508 -> 4
    //   4515: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4518: ifeq +33 -> 4551
    //   4521: ldc_w 445
    //   4524: iconst_2
    //   4525: new 160	java/lang/StringBuilder
    //   4528: dup
    //   4529: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4532: ldc_w 920
    //   4535: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4538: aload_2
    //   4539: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4542: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4545: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4548: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4551: aload 5
    //   4553: checkcast 918	com/tencent/mobileqq/data/MessageForShortVideo
    //   4556: astore 16
    //   4558: aload 16
    //   4560: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4563: sipush 1005
    //   4566: if_icmpeq +60 -> 4626
    //   4569: aload_2
    //   4570: getfield 924	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   4573: ldc_w 633
    //   4576: if_icmpeq +50 -> 4626
    //   4579: aload 16
    //   4581: getfield 927	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4584: ifne +14 -> 4598
    //   4587: aload 16
    //   4589: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4592: sipush 1004
    //   4595: if_icmpeq +31 -> 4626
    //   4598: iload 7
    //   4600: istore 6
    //   4602: aload 16
    //   4604: getfield 927	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4607: iconst_1
    //   4608: if_icmpne +37 -> 4645
    //   4611: iload 7
    //   4613: istore 6
    //   4615: aload 16
    //   4617: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4620: sipush 1004
    //   4623: if_icmpne +22 -> 4645
    //   4626: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4629: ifeq +13 -> 4642
    //   4632: ldc_w 445
    //   4635: iconst_2
    //   4636: ldc_w 929
    //   4639: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4642: iconst_1
    //   4643: istore 6
    //   4645: aload_2
    //   4646: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4649: astore 5
    //   4651: aload_2
    //   4652: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4655: aload_2
    //   4656: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4659: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   4662: ifeq +9 -> 4671
    //   4665: aload_2
    //   4666: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4669: astore 5
    //   4671: aload_1
    //   4672: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Layvx;
    //   4675: aload 5
    //   4677: aload_2
    //   4678: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4681: invokevirtual 595	ayvx:a	(Ljava/lang/String;J)Lbbmw;
    //   4684: astore_1
    //   4685: aload 16
    //   4687: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4690: ifnull +337 -> 5027
    //   4693: ldc 119
    //   4695: aload 16
    //   4697: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4700: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4703: ifne +324 -> 5027
    //   4706: aload_2
    //   4707: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4710: ifeq +317 -> 5027
    //   4713: aload_1
    //   4714: ifnonnull +313 -> 5027
    //   4717: aload 16
    //   4719: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4722: sipush 1003
    //   4725: if_icmpeq +302 -> 5027
    //   4728: aload 16
    //   4730: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4733: sipush 1004
    //   4736: if_icmpeq +291 -> 5027
    //   4739: aload 16
    //   4741: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4744: sipush 2003
    //   4747: if_icmpeq +280 -> 5027
    //   4750: aload 16
    //   4752: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4755: sipush 2009
    //   4758: if_icmpeq +269 -> 5027
    //   4761: aload 16
    //   4763: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4766: sipush 2002
    //   4769: if_icmpeq +258 -> 5027
    //   4772: aload 16
    //   4774: getfield 935	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   4777: iconst_1
    //   4778: if_icmpne +249 -> 5027
    //   4781: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4784: ifeq +13 -> 4797
    //   4787: ldc_w 445
    //   4790: iconst_2
    //   4791: ldc_w 937
    //   4794: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4797: iconst_1
    //   4798: istore 7
    //   4800: iload 7
    //   4802: istore 6
    //   4804: iload 10
    //   4806: istore 7
    //   4808: aload_2
    //   4809: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4812: ifeq +81 -> 4893
    //   4815: aload 16
    //   4817: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4820: sipush 1001
    //   4823: if_icmpeq +51 -> 4874
    //   4826: aload 16
    //   4828: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4831: sipush 1002
    //   4834: if_icmpeq +40 -> 4874
    //   4837: aload 16
    //   4839: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4842: sipush 998
    //   4845: if_icmpeq +29 -> 4874
    //   4848: aload 16
    //   4850: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4853: sipush 999
    //   4856: if_icmpeq +18 -> 4874
    //   4859: iload 10
    //   4861: istore 7
    //   4863: aload 16
    //   4865: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4868: sipush 1000
    //   4871: if_icmpne +22 -> 4893
    //   4874: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4877: ifeq +13 -> 4890
    //   4880: ldc_w 445
    //   4883: iconst_2
    //   4884: ldc_w 939
    //   4887: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4890: iconst_1
    //   4891: istore 7
    //   4893: aload 16
    //   4895: instanceof 941
    //   4898: ifeq +235 -> 5133
    //   4901: aload_0
    //   4902: ldc_w 942
    //   4905: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4908: astore_0
    //   4909: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4912: ifeq +101 -> 5013
    //   4915: ldc_w 445
    //   4918: iconst_2
    //   4919: new 160	java/lang/StringBuilder
    //   4922: dup
    //   4923: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4926: ldc_w 944
    //   4929: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4932: aload 16
    //   4934: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4937: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4940: ldc_w 946
    //   4943: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4946: aload 16
    //   4948: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4951: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4954: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4957: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4960: aload_1
    //   4961: ifnonnull +203 -> 5164
    //   4964: ldc_w 445
    //   4967: iconst_2
    //   4968: ldc_w 948
    //   4971: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4974: ldc_w 445
    //   4977: iconst_2
    //   4978: new 160	java/lang/StringBuilder
    //   4981: dup
    //   4982: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4985: ldc_w 950
    //   4988: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4991: iload 6
    //   4993: invokevirtual 953	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4996: ldc_w 955
    //   4999: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5002: iload 7
    //   5004: invokevirtual 953	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5007: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5010: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5013: aload 19
    //   5015: aload_0
    //   5016: aconst_null
    //   5017: iload 6
    //   5019: iload 7
    //   5021: aload 4
    //   5023: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5026: return
    //   5027: iload 6
    //   5029: istore 7
    //   5031: aload_2
    //   5032: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5035: ifeq -235 -> 4800
    //   5038: iload 6
    //   5040: istore 7
    //   5042: aload 16
    //   5044: instanceof 941
    //   5047: ifeq -247 -> 4800
    //   5050: iload 6
    //   5052: istore 7
    //   5054: aload 16
    //   5056: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5059: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5062: ifeq -262 -> 4800
    //   5065: iload 6
    //   5067: istore 7
    //   5069: aload_1
    //   5070: ifnonnull -270 -> 4800
    //   5073: aload 16
    //   5075: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5078: sipush 1004
    //   5081: if_icmpeq +18 -> 5099
    //   5084: iload 6
    //   5086: istore 7
    //   5088: aload 16
    //   5090: getfield 923	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5093: sipush 1001
    //   5096: if_icmpne -296 -> 4800
    //   5099: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5102: ifeq +13 -> 5115
    //   5105: ldc_w 445
    //   5108: iconst_2
    //   5109: ldc_w 957
    //   5112: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5115: iconst_1
    //   5116: istore 7
    //   5118: goto -318 -> 4800
    //   5121: astore 5
    //   5123: aconst_null
    //   5124: astore_1
    //   5125: aload 5
    //   5127: invokevirtual 470	java/lang/Exception:printStackTrace	()V
    //   5130: goto -326 -> 4804
    //   5133: aload 16
    //   5135: getfield 927	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   5138: iconst_2
    //   5139: if_icmpne +14 -> 5153
    //   5142: aload_0
    //   5143: ldc_w 958
    //   5146: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5149: astore_0
    //   5150: goto -241 -> 4909
    //   5153: aload_0
    //   5154: ldc_w 959
    //   5157: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5160: astore_0
    //   5161: goto -252 -> 4909
    //   5164: ldc_w 445
    //   5167: iconst_2
    //   5168: ldc_w 961
    //   5171: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5174: goto -200 -> 4974
    //   5177: aload_2
    //   5178: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5181: sipush -5002
    //   5184: if_icmpne +40 -> 5224
    //   5187: new 963	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5190: dup
    //   5191: invokespecial 964	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5194: astore_0
    //   5195: aload_0
    //   5196: aload_2
    //   5197: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5200: putfield 965	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5203: aload_0
    //   5204: invokevirtual 966	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5207: aload_0
    //   5208: getfield 967	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5211: ifnull -5207 -> 4
    //   5214: aload 4
    //   5216: aload_0
    //   5217: getfield 967	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5220: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5223: return
    //   5224: aload_2
    //   5225: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5228: sipush -2029
    //   5231: if_icmpne +145 -> 5376
    //   5234: aload_1
    //   5235: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5238: aload_2
    //   5239: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5242: aload_2
    //   5243: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5246: aload_2
    //   5247: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5250: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5253: astore_0
    //   5254: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5257: ifeq +30 -> 5287
    //   5260: ldc_w 445
    //   5263: iconst_2
    //   5264: new 160	java/lang/StringBuilder
    //   5267: dup
    //   5268: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5271: ldc_w 969
    //   5274: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5277: aload_0
    //   5278: invokevirtual 638	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5281: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5284: invokestatic 448	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5287: aload_0
    //   5288: instanceof 971
    //   5291: ifeq -5287 -> 4
    //   5294: aload_0
    //   5295: checkcast 971	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5298: astore_0
    //   5299: aload_0
    //   5300: aload_2
    //   5301: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5304: putfield 972	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5307: aload_0
    //   5308: invokevirtual 973	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5311: aload_0
    //   5312: aload_1
    //   5313: aload_1
    //   5314: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5317: aconst_null
    //   5318: invokevirtual 977	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5321: aload_0
    //   5322: getfield 979	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5325: ifnull -5321 -> 4
    //   5328: aload_0
    //   5329: getfield 982	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5332: iconst_1
    //   5333: if_icmpne +33 -> 5366
    //   5336: aload_0
    //   5337: new 160	java/lang/StringBuilder
    //   5340: dup
    //   5341: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5344: ldc_w 983
    //   5347: invokestatic 372	ajya:a	(I)Ljava/lang/String;
    //   5350: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5353: aload_0
    //   5354: getfield 979	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5357: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5360: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5363: putfield 979	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5366: aload 4
    //   5368: aload_0
    //   5369: getfield 979	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5372: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5375: return
    //   5376: aload_2
    //   5377: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5380: sipush -2025
    //   5383: if_icmpeq +13 -> 5396
    //   5386: aload_2
    //   5387: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5390: sipush -2072
    //   5393: if_icmpne +13 -> 5406
    //   5396: aload 4
    //   5398: aload_2
    //   5399: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5402: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5405: return
    //   5406: aload_2
    //   5407: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5410: sipush -2076
    //   5413: if_icmpne +58 -> 5471
    //   5416: new 985	com/tencent/mobileqq/data/MessageForLocationShare
    //   5419: dup
    //   5420: invokespecial 986	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5423: astore_1
    //   5424: aload_1
    //   5425: aload_2
    //   5426: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5429: putfield 987	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5432: aload_1
    //   5433: invokevirtual 988	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5436: aload_1
    //   5437: getfield 989	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5440: astore_2
    //   5441: aload_2
    //   5442: astore_1
    //   5443: aload_2
    //   5444: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5447: ifeq +11 -> 5458
    //   5450: aload_0
    //   5451: ldc_w 990
    //   5454: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5457: astore_1
    //   5458: aload 19
    //   5460: ldc 119
    //   5462: aload_1
    //   5463: iconst_0
    //   5464: iconst_0
    //   5465: aload 4
    //   5467: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5470: return
    //   5471: aload_2
    //   5472: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5475: sipush -2052
    //   5478: if_icmpne +75 -> 5553
    //   5481: aload_2
    //   5482: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5485: astore_0
    //   5486: aload_2
    //   5487: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5490: aload_2
    //   5491: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5494: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   5497: ifeq +8 -> 5505
    //   5500: aload_2
    //   5501: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5504: astore_0
    //   5505: aload_1
    //   5506: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5509: aload_0
    //   5510: aload_2
    //   5511: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5514: aload_2
    //   5515: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5518: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5521: astore_0
    //   5522: aload_0
    //   5523: instanceof 992
    //   5526: ifeq -5522 -> 4
    //   5529: aload_0
    //   5530: checkcast 992	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5533: astore_0
    //   5534: aload_0
    //   5535: invokevirtual 993	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5538: aload 19
    //   5540: aload_0
    //   5541: invokevirtual 994	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5544: aconst_null
    //   5545: iconst_0
    //   5546: iconst_0
    //   5547: aload 4
    //   5549: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5552: return
    //   5553: aload_2
    //   5554: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5557: sipush -2047
    //   5560: if_icmpne +51 -> 5611
    //   5563: new 996	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5566: dup
    //   5567: invokespecial 997	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5570: astore_0
    //   5571: aload_0
    //   5572: aload_2
    //   5573: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5576: putfield 998	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5579: aload_0
    //   5580: invokevirtual 999	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5583: aload_0
    //   5584: invokevirtual 1000	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5587: astore_0
    //   5588: aload_0
    //   5589: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5592: ifne +10 -> 5602
    //   5595: aload 4
    //   5597: aload_0
    //   5598: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5601: return
    //   5602: aload 4
    //   5604: ldc_w 1002
    //   5607: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5610: return
    //   5611: aload_2
    //   5612: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5615: sipush -2040
    //   5618: if_icmpne +29 -> 5647
    //   5621: new 1004	com/tencent/mobileqq/data/MessageForApproval
    //   5624: dup
    //   5625: invokespecial 1005	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5628: astore_0
    //   5629: aload_0
    //   5630: aload_2
    //   5631: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5634: putfield 1006	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5637: aload 4
    //   5639: aload_0
    //   5640: invokevirtual 1009	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5643: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5646: return
    //   5647: aload_2
    //   5648: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5651: sipush -2041
    //   5654: if_icmpne +49 -> 5703
    //   5657: aload_0
    //   5658: ldc_w 1010
    //   5661: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5664: astore_1
    //   5665: aload_0
    //   5666: ldc_w 1011
    //   5669: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5672: astore_0
    //   5673: aload 4
    //   5675: new 160	java/lang/StringBuilder
    //   5678: dup
    //   5679: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5682: aload_1
    //   5683: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5686: ldc_w 481
    //   5689: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5692: aload_0
    //   5693: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5696: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5699: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5702: return
    //   5703: aload_2
    //   5704: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5707: sipush -7001
    //   5710: if_icmpne +157 -> 5867
    //   5713: aload_2
    //   5714: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5717: astore 5
    //   5719: aload_2
    //   5720: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5723: aload_2
    //   5724: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5727: invokestatic 587	akpx:a	(Ljava/lang/String;I)Z
    //   5730: ifeq +9 -> 5739
    //   5733: aload_2
    //   5734: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5737: astore 5
    //   5739: aload_1
    //   5740: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5743: aload 5
    //   5745: aload_2
    //   5746: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5749: aload_2
    //   5750: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5753: invokevirtual 513	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5756: checkcast 1013	com/tencent/mobileqq/data/MessageForScribble
    //   5759: astore_1
    //   5760: aload_1
    //   5761: invokevirtual 1014	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5764: ifeq +56 -> 5820
    //   5767: aload_1
    //   5768: getfield 1017	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5771: istore_3
    //   5772: iload_3
    //   5773: iconst_2
    //   5774: if_icmpne +29 -> 5803
    //   5777: iconst_1
    //   5778: istore 7
    //   5780: iconst_0
    //   5781: istore 6
    //   5783: aload 19
    //   5785: aload_0
    //   5786: ldc_w 1018
    //   5789: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5792: aconst_null
    //   5793: iload 7
    //   5795: iload 6
    //   5797: aload 4
    //   5799: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5802: return
    //   5803: aload_1
    //   5804: getfield 1017	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5807: iconst_3
    //   5808: if_icmpne +1852 -> 7660
    //   5811: iconst_1
    //   5812: istore 6
    //   5814: iconst_0
    //   5815: istore 7
    //   5817: goto -34 -> 5783
    //   5820: aload_1
    //   5821: getfield 1021	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5824: iconst_2
    //   5825: if_icmpne +1835 -> 7660
    //   5828: aload_1
    //   5829: invokestatic 1026	awgy:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5832: istore_3
    //   5833: getstatic 1028	awgy:c	I
    //   5836: istore 8
    //   5838: iload_3
    //   5839: iload 8
    //   5841: if_icmpeq +1819 -> 7660
    //   5844: iconst_1
    //   5845: istore 7
    //   5847: iconst_0
    //   5848: istore 6
    //   5850: goto -67 -> 5783
    //   5853: astore_1
    //   5854: aload_1
    //   5855: invokevirtual 470	java/lang/Exception:printStackTrace	()V
    //   5858: iconst_0
    //   5859: istore 6
    //   5861: iconst_0
    //   5862: istore 7
    //   5864: goto -81 -> 5783
    //   5867: aload_1
    //   5868: aload_2
    //   5869: invokestatic 1031	asyp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   5872: ifeq +18 -> 5890
    //   5875: aload 19
    //   5877: aload_2
    //   5878: invokevirtual 1035	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5881: aconst_null
    //   5882: iconst_0
    //   5883: iconst_0
    //   5884: aload 4
    //   5886: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5889: return
    //   5890: aload_2
    //   5891: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5894: ifnonnull +11 -> 5905
    //   5897: aload 4
    //   5899: ldc 119
    //   5901: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5904: return
    //   5905: aload_2
    //   5906: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5909: sipush -5003
    //   5912: if_icmpne +13 -> 5925
    //   5915: aload 4
    //   5917: aload_2
    //   5918: invokevirtual 1035	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5921: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5924: return
    //   5925: aload_2
    //   5926: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5929: sipush -2033
    //   5932: if_icmpne +16 -> 5948
    //   5935: aconst_null
    //   5936: getstatic 1040	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   5939: aconst_null
    //   5940: iconst_0
    //   5941: iconst_0
    //   5942: aload 4
    //   5944: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5947: return
    //   5948: aload_2
    //   5949: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5952: sipush -2049
    //   5955: if_icmpne +16 -> 5971
    //   5958: aload 4
    //   5960: aload_2
    //   5961: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5964: invokestatic 554	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5967: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5970: return
    //   5971: aload_2
    //   5972: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5975: sipush -1035
    //   5978: if_icmpne +287 -> 6265
    //   5981: iconst_0
    //   5982: istore 10
    //   5984: iconst_0
    //   5985: istore 11
    //   5987: iload 10
    //   5989: istore 6
    //   5991: iload 11
    //   5993: istore 7
    //   5995: aload_2
    //   5996: invokevirtual 528	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5999: ifeq +31 -> 6030
    //   6002: aload_2
    //   6003: getfield 924	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   6006: ldc_w 1041
    //   6009: if_icmpne +171 -> 6180
    //   6012: aload_1
    //   6013: invokevirtual 1044	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzy;
    //   6016: aload_2
    //   6017: invokevirtual 1047	awzy:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6020: ifne +150 -> 6170
    //   6023: iconst_1
    //   6024: istore 6
    //   6026: iload 11
    //   6028: istore 7
    //   6030: aload_2
    //   6031: invokevirtual 1035	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6034: astore_0
    //   6035: aload_2
    //   6036: invokestatic 1050	bamk:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6039: ifeq +1618 -> 7657
    //   6042: aload_2
    //   6043: invokestatic 1052	bamk:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6046: ifne +7 -> 6053
    //   6049: aload_2
    //   6050: invokestatic 1055	bamk:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6053: aload_2
    //   6054: invokestatic 1058	bamk:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6057: astore_1
    //   6058: aload_1
    //   6059: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6062: ifne +1595 -> 7657
    //   6065: aload_1
    //   6066: astore_0
    //   6067: aload_2
    //   6068: getfield 1061	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6071: ifnull +177 -> 6248
    //   6074: aload_0
    //   6075: ifnull +173 -> 6248
    //   6078: new 160	java/lang/StringBuilder
    //   6081: dup
    //   6082: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6085: astore_1
    //   6086: aload 19
    //   6088: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6091: ifne +16 -> 6107
    //   6094: aload_1
    //   6095: aload 19
    //   6097: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6100: ldc_w 377
    //   6103: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6106: pop
    //   6107: aload_2
    //   6108: invokestatic 503	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6111: ifne +16 -> 6127
    //   6114: iload 6
    //   6116: ifeq +89 -> 6205
    //   6119: aload_1
    //   6120: ldc_w 750
    //   6123: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6126: pop
    //   6127: aload_0
    //   6128: instanceof 752
    //   6131: ifeq +90 -> 6221
    //   6134: aload_0
    //   6135: checkcast 752	aykk
    //   6138: aload_1
    //   6139: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6142: iconst_1
    //   6143: iconst_0
    //   6144: newarray int
    //   6146: invokevirtual 755	aykk:a	(Ljava/lang/String;Z[I)Laykk;
    //   6149: astore_0
    //   6150: aload 4
    //   6152: iconst_1
    //   6153: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6156: aload 19
    //   6158: aload_0
    //   6159: aconst_null
    //   6160: iload 6
    //   6162: iload 7
    //   6164: aload 4
    //   6166: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6169: return
    //   6170: iconst_1
    //   6171: istore 7
    //   6173: iload 10
    //   6175: istore 6
    //   6177: goto -147 -> 6030
    //   6180: iconst_0
    //   6181: istore 7
    //   6183: aload_2
    //   6184: getfield 924	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   6187: ldc_w 633
    //   6190: if_icmpne +9 -> 6199
    //   6193: iconst_1
    //   6194: istore 6
    //   6196: goto -166 -> 6030
    //   6199: iconst_0
    //   6200: istore 6
    //   6202: goto -6 -> 6196
    //   6205: iload 7
    //   6207: ifeq -80 -> 6127
    //   6210: aload_1
    //   6211: ldc_w 758
    //   6214: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6217: pop
    //   6218: goto -91 -> 6127
    //   6221: aload_1
    //   6222: aload_0
    //   6223: invokevirtual 1064	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6226: pop
    //   6227: new 1066	android/text/SpannableString
    //   6230: dup
    //   6231: aload_1
    //   6232: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6235: invokespecial 1069	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6238: astore_0
    //   6239: aload 4
    //   6241: iconst_0
    //   6242: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6245: goto -89 -> 6156
    //   6248: aload 19
    //   6250: aload_0
    //   6251: invokestatic 1072	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6254: aconst_null
    //   6255: iload 6
    //   6257: iload 7
    //   6259: aload 4
    //   6261: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6264: return
    //   6265: aload_2
    //   6266: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6269: sipush -2057
    //   6272: if_icmpne +17 -> 6289
    //   6275: aload 19
    //   6277: getstatic 1077	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6280: aconst_null
    //   6281: iconst_0
    //   6282: iconst_0
    //   6283: aload 4
    //   6285: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6288: return
    //   6289: aload_2
    //   6290: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6293: sipush -1012
    //   6296: if_icmpne +70 -> 6366
    //   6299: aload_2
    //   6300: invokevirtual 1035	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6303: invokeinterface 1080 1 0
    //   6308: invokestatic 554	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6311: astore_1
    //   6312: aload_0
    //   6313: ldc_w 1081
    //   6316: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6319: astore_2
    //   6320: aload_1
    //   6321: invokevirtual 204	java/lang/String:length	()I
    //   6324: aload_2
    //   6325: invokevirtual 204	java/lang/String:length	()I
    //   6328: isub
    //   6329: iconst_1
    //   6330: isub
    //   6331: istore_3
    //   6332: aload_1
    //   6333: astore_0
    //   6334: aload_1
    //   6335: aload_2
    //   6336: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6339: ifeq +16 -> 6355
    //   6342: aload_1
    //   6343: astore_0
    //   6344: iload_3
    //   6345: ifle +10 -> 6355
    //   6348: aload_1
    //   6349: iconst_0
    //   6350: iload_3
    //   6351: invokevirtual 304	java/lang/String:substring	(II)Ljava/lang/String;
    //   6354: astore_0
    //   6355: aconst_null
    //   6356: aload_0
    //   6357: aconst_null
    //   6358: iconst_0
    //   6359: iconst_0
    //   6360: aload 4
    //   6362: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6365: return
    //   6366: aload_2
    //   6367: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6370: sipush -2059
    //   6373: if_icmpne +33 -> 6406
    //   6376: new 1083	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6379: dup
    //   6380: invokespecial 1084	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6383: astore_0
    //   6384: aload_0
    //   6385: aload_2
    //   6386: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6389: putfield 1085	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6392: aload_0
    //   6393: invokevirtual 1088	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6396: aload 4
    //   6398: aload_0
    //   6399: invokevirtual 1089	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6402: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6405: return
    //   6406: aload_2
    //   6407: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6410: sipush -2066
    //   6413: if_icmpne +87 -> 6500
    //   6416: new 1091	com/tencent/mobileqq/data/MessageForConfessCard
    //   6419: dup
    //   6420: invokespecial 1092	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6423: astore_0
    //   6424: aload_0
    //   6425: aload_2
    //   6426: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6429: putfield 1093	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6432: aload_0
    //   6433: invokevirtual 1094	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6436: aload_2
    //   6437: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6440: sipush 1032
    //   6443: if_icmpne +18 -> 6461
    //   6446: aload 19
    //   6448: aload_0
    //   6449: getfield 1097	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6452: aconst_null
    //   6453: iconst_0
    //   6454: iconst_0
    //   6455: aload 4
    //   6457: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6460: return
    //   6461: ldc 119
    //   6463: new 160	java/lang/StringBuilder
    //   6466: dup
    //   6467: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6470: aload 19
    //   6472: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6475: ldc_w 1099
    //   6478: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6481: aload_0
    //   6482: getfield 1097	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6485: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6488: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6491: aconst_null
    //   6492: iconst_0
    //   6493: iconst_0
    //   6494: aload 4
    //   6496: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6499: return
    //   6500: aload_2
    //   6501: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6504: sipush -2067
    //   6507: if_icmpne +38 -> 6545
    //   6510: new 1101	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6513: dup
    //   6514: invokespecial 1102	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6517: astore_0
    //   6518: aload_0
    //   6519: aload_2
    //   6520: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6523: putfield 1103	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6526: aload_0
    //   6527: invokevirtual 1104	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6530: aload 19
    //   6532: aload_0
    //   6533: getfield 1105	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6536: aconst_null
    //   6537: iconst_0
    //   6538: iconst_0
    //   6539: aload 4
    //   6541: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6544: return
    //   6545: aload_2
    //   6546: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6549: sipush -5008
    //   6552: if_icmpeq +23 -> 6575
    //   6555: aload_2
    //   6556: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6559: sipush -5016
    //   6562: if_icmpeq +13 -> 6575
    //   6565: aload_2
    //   6566: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6569: sipush -5017
    //   6572: if_icmpne +106 -> 6678
    //   6575: aload_2
    //   6576: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6579: sipush -5016
    //   6582: if_icmpne +64 -> 6646
    //   6585: new 1107	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6588: dup
    //   6589: invokespecial 1108	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6592: astore_0
    //   6593: aload_0
    //   6594: aload_2
    //   6595: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6598: putfield 1109	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6601: aload_0
    //   6602: invokevirtual 1110	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6605: aload 4
    //   6607: aload_0
    //   6608: invokevirtual 1113	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6611: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6614: aload_1
    //   6615: aload_2
    //   6616: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6619: istore 6
    //   6621: aload_1
    //   6622: aload_2
    //   6623: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6626: istore 7
    //   6628: aload 19
    //   6630: aload 4
    //   6632: getfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6635: aconst_null
    //   6636: iload 6
    //   6638: iload 7
    //   6640: aload 4
    //   6642: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6645: return
    //   6646: new 1115	com/tencent/mobileqq/data/MessageForArkApp
    //   6649: dup
    //   6650: invokespecial 1116	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6653: astore_0
    //   6654: aload_0
    //   6655: aload_2
    //   6656: getfield 737	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6659: putfield 1117	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6662: aload_0
    //   6663: invokevirtual 1118	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6666: aload 4
    //   6668: aload_0
    //   6669: invokevirtual 1119	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6672: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6675: goto -61 -> 6614
    //   6678: aload_1
    //   6679: aload_2
    //   6680: invokestatic 582	bbfh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6683: istore 6
    //   6685: aload_1
    //   6686: aload_2
    //   6687: invokestatic 584	bbfh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6690: istore 7
    //   6692: aload_2
    //   6693: getfield 1122	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   6696: lookupswitch	default:+52->6748, 1:+175->6871, 2:+256->6952, 8:+256->6952, 65536:+157->6853, 65538:+238->6934
    //   6749: ldc_w 706
    //   6752: invokevirtual 709	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6755: astore 5
    //   6757: getstatic 714	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   6760: ifeq +295 -> 7055
    //   6763: aload 5
    //   6765: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6768: ifne +287 -> 7055
    //   6771: aload_1
    //   6772: aload_2
    //   6773: aload 4
    //   6775: invokestatic 748	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Laykk;
    //   6778: astore_0
    //   6779: new 160	java/lang/StringBuilder
    //   6782: dup
    //   6783: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6786: astore_1
    //   6787: aload 19
    //   6789: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6792: ifne +16 -> 6808
    //   6795: aload_1
    //   6796: aload 19
    //   6798: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6801: ldc_w 377
    //   6804: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6807: pop
    //   6808: aload_2
    //   6809: invokestatic 503	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6812: ifne +16 -> 6828
    //   6815: iload 6
    //   6817: ifeq +222 -> 7039
    //   6820: aload_1
    //   6821: ldc_w 750
    //   6824: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6827: pop
    //   6828: aload 19
    //   6830: aload_0
    //   6831: aload_1
    //   6832: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6835: iconst_1
    //   6836: iconst_0
    //   6837: newarray int
    //   6839: invokevirtual 755	aykk:a	(Ljava/lang/String;Z[I)Laykk;
    //   6842: aconst_null
    //   6843: iload 6
    //   6845: iload 7
    //   6847: aload 4
    //   6849: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6852: return
    //   6853: aload 19
    //   6855: ldc 119
    //   6857: aload_2
    //   6858: getfield 549	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6861: iload 6
    //   6863: iload 7
    //   6865: aload 4
    //   6867: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6870: return
    //   6871: aload_2
    //   6872: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6875: sipush 1001
    //   6878: if_icmpeq +13 -> 6891
    //   6881: aload_2
    //   6882: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6885: sipush 10002
    //   6888: if_icmpne +26 -> 6914
    //   6891: aload_2
    //   6892: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6895: sipush -3001
    //   6898: if_icmpne +16 -> 6914
    //   6901: aload 4
    //   6903: aload_0
    //   6904: ldc_w 1123
    //   6907: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6910: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6913: return
    //   6914: aload 19
    //   6916: aload_0
    //   6917: ldc_w 619
    //   6920: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6923: aconst_null
    //   6924: iload 6
    //   6926: iload 7
    //   6928: aload 4
    //   6930: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6933: return
    //   6934: aload 19
    //   6936: aload_0
    //   6937: ldc_w 619
    //   6940: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6943: aconst_null
    //   6944: iconst_0
    //   6945: iconst_0
    //   6946: aload 4
    //   6948: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6951: return
    //   6952: ldc_w 649
    //   6955: iconst_3
    //   6956: anewarray 4	java/lang/Object
    //   6959: dup
    //   6960: iconst_0
    //   6961: iload_3
    //   6962: invokestatic 672	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6965: aastore
    //   6966: dup
    //   6967: iconst_1
    //   6968: iload 6
    //   6970: invokestatic 652	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6973: aastore
    //   6974: dup
    //   6975: iconst_2
    //   6976: iload 7
    //   6978: invokestatic 652	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6981: aastore
    //   6982: invokestatic 657	anml:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6985: aload_0
    //   6986: ldc_w 639
    //   6989: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6992: astore_0
    //   6993: aload_2
    //   6994: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   6997: aload_1
    //   6998: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7001: invokestatic 1126	bbbr:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7004: ifeq +22 -> 7026
    //   7007: iload_3
    //   7008: ifeq +18 -> 7026
    //   7011: aload 19
    //   7013: aload_0
    //   7014: ldc 119
    //   7016: iload 6
    //   7018: iload 7
    //   7020: aload 4
    //   7022: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7025: return
    //   7026: aload 19
    //   7028: aload_0
    //   7029: ldc 119
    //   7031: iconst_0
    //   7032: iconst_0
    //   7033: aload 4
    //   7035: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7038: return
    //   7039: iload 7
    //   7041: ifeq -213 -> 6828
    //   7044: aload_1
    //   7045: ldc_w 758
    //   7048: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7051: pop
    //   7052: goto -224 -> 6828
    //   7055: aload_2
    //   7056: invokevirtual 1035	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   7059: astore 5
    //   7061: aload_2
    //   7062: invokestatic 1050	bamk:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7065: ifeq +589 -> 7654
    //   7068: aload_2
    //   7069: invokestatic 1052	bamk:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7072: ifne +7 -> 7079
    //   7075: aload_2
    //   7076: invokestatic 1055	bamk:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   7079: aload_2
    //   7080: invokestatic 1058	bamk:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   7083: astore 16
    //   7085: aload 16
    //   7087: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7090: ifne +564 -> 7654
    //   7093: aload 16
    //   7095: astore 5
    //   7097: aload_2
    //   7098: getfield 1061	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   7101: ifnull +389 -> 7490
    //   7104: aload 5
    //   7106: ifnull +384 -> 7490
    //   7109: new 160	java/lang/StringBuilder
    //   7112: dup
    //   7113: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   7116: astore_0
    //   7117: aload 19
    //   7119: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7122: ifne +16 -> 7138
    //   7125: aload_0
    //   7126: aload 19
    //   7128: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7131: ldc_w 377
    //   7134: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7137: pop
    //   7138: aload_2
    //   7139: invokestatic 503	myb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7142: ifne +16 -> 7158
    //   7145: iload 6
    //   7147: ifeq +299 -> 7446
    //   7150: aload_0
    //   7151: ldc_w 750
    //   7154: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7157: pop
    //   7158: aload 5
    //   7160: instanceof 752
    //   7163: ifeq +299 -> 7462
    //   7166: aload 5
    //   7168: checkcast 752	aykk
    //   7171: aload_0
    //   7172: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7175: iconst_1
    //   7176: iconst_3
    //   7177: newarray int
    //   7179: dup
    //   7180: iconst_0
    //   7181: aload 5
    //   7183: checkcast 752	aykk
    //   7186: getfield 1127	aykk:jdField_a_of_type_Int	I
    //   7189: iastore
    //   7190: dup
    //   7191: iconst_1
    //   7192: bipush 16
    //   7194: iastore
    //   7195: dup
    //   7196: iconst_2
    //   7197: iconst_1
    //   7198: iastore
    //   7199: invokevirtual 755	aykk:a	(Ljava/lang/String;Z[I)Laykk;
    //   7202: astore_0
    //   7203: aload 4
    //   7205: iconst_1
    //   7206: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7209: aload_2
    //   7210: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7213: sipush -5040
    //   7216: if_icmpne +435 -> 7651
    //   7219: new 160	java/lang/StringBuilder
    //   7222: dup
    //   7223: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   7226: ldc_w 481
    //   7229: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7232: invokestatic 362	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7235: ldc_w 1128
    //   7238: invokevirtual 364	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7241: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7244: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7247: astore 5
    //   7249: aload_0
    //   7250: invokeinterface 1080 1 0
    //   7255: astore 16
    //   7257: aload 16
    //   7259: ifnull +386 -> 7645
    //   7262: aload 16
    //   7264: aload 5
    //   7266: invokevirtual 1131	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7269: ifeq +376 -> 7645
    //   7272: aload 16
    //   7274: aload 5
    //   7276: ldc 119
    //   7278: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7281: astore 5
    //   7283: aload 5
    //   7285: astore_0
    //   7286: iload_3
    //   7287: ifne +77 -> 7364
    //   7290: aload_1
    //   7291: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   7294: aload_2
    //   7295: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7298: iconst_0
    //   7299: invokevirtual 1134	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7302: astore 16
    //   7304: aload 5
    //   7306: astore_0
    //   7307: aload 16
    //   7309: instanceof 1136
    //   7312: ifeq +52 -> 7364
    //   7315: aload 5
    //   7317: astore_0
    //   7318: aload 16
    //   7320: checkcast 1136	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7323: getfield 1140	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqvb;
    //   7326: ifnull +38 -> 7364
    //   7329: aload 5
    //   7331: astore_0
    //   7332: aload 16
    //   7334: checkcast 1136	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7337: getfield 1140	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqvb;
    //   7340: getfield 1144	aqvb:b	I
    //   7343: invokestatic 1147	asxm:b	(I)Z
    //   7346: ifeq +18 -> 7364
    //   7349: aload_1
    //   7350: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7353: aload 5
    //   7355: invokeinterface 1080 1 0
    //   7360: invokestatic 1150	asyp:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7363: astore_0
    //   7364: aload_2
    //   7365: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7368: invokestatic 1152	akpx:i	(I)Z
    //   7371: ifeq +271 -> 7642
    //   7374: aload_1
    //   7375: invokevirtual 508	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   7378: aload_2
    //   7379: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7382: iload_3
    //   7383: invokevirtual 1134	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7386: astore_1
    //   7387: aload_1
    //   7388: ifnull +254 -> 7642
    //   7391: aload_1
    //   7392: instanceof 1136
    //   7395: ifeq +247 -> 7642
    //   7398: aload_1
    //   7399: checkcast 1136	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7402: getfield 1140	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqvb;
    //   7405: ifnull +237 -> 7642
    //   7408: aload_1
    //   7409: checkcast 1136	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7412: getfield 1140	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqvb;
    //   7415: getfield 1144	aqvb:b	I
    //   7418: ldc_w 1153
    //   7421: if_icmpne +221 -> 7642
    //   7424: aload_1
    //   7425: checkcast 1136	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7428: invokevirtual 1154	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7431: astore_0
    //   7432: aload 19
    //   7434: aload_0
    //   7435: aconst_null
    //   7436: iload 6
    //   7438: iload 7
    //   7440: aload 4
    //   7442: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7445: return
    //   7446: iload 7
    //   7448: ifeq -290 -> 7158
    //   7451: aload_0
    //   7452: ldc_w 758
    //   7455: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7458: pop
    //   7459: goto -301 -> 7158
    //   7462: aload_0
    //   7463: aload 5
    //   7465: invokevirtual 1064	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7468: pop
    //   7469: new 1066	android/text/SpannableString
    //   7472: dup
    //   7473: aload_0
    //   7474: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7477: invokespecial 1069	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7480: astore_0
    //   7481: aload 4
    //   7483: iconst_0
    //   7484: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7487: goto -278 -> 7209
    //   7490: aload 5
    //   7492: ifnull +114 -> 7606
    //   7495: aload 5
    //   7497: invokeinterface 1080 1 0
    //   7502: invokevirtual 188	java/lang/String:trim	()Ljava/lang/String;
    //   7505: astore 5
    //   7507: getstatic 1157	ajsd:G	Ljava/lang/String;
    //   7510: aload_2
    //   7511: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7514: invokevirtual 1160	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7517: ifeq +119 -> 7636
    //   7520: aload 5
    //   7522: ifnull +114 -> 7636
    //   7525: aload 5
    //   7527: invokevirtual 204	java/lang/String:length	()I
    //   7530: ifle +106 -> 7636
    //   7533: aload_0
    //   7534: aload_1
    //   7535: aload 5
    //   7537: aload_2
    //   7538: invokestatic 1162	bbfh:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   7541: astore_0
    //   7542: aload 19
    //   7544: aconst_null
    //   7545: aload_0
    //   7546: iload 6
    //   7548: aload_1
    //   7549: invokevirtual 1044	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzy;
    //   7552: aload_2
    //   7553: invokevirtual 1047	awzy:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7556: aload 4
    //   7558: invokestatic 576	bbfh:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7561: aload_2
    //   7562: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7565: sipush -1000
    //   7568: if_icmpne +44 -> 7612
    //   7571: aload 4
    //   7573: getfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7576: ifnull +36 -> 7612
    //   7579: aload 4
    //   7581: new 752	aykk
    //   7584: dup
    //   7585: aload 4
    //   7587: getfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7590: iconst_1
    //   7591: bipush 16
    //   7593: invokespecial 1165	aykk:<init>	(Ljava/lang/CharSequence;II)V
    //   7596: putfield 560	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7599: aload 4
    //   7601: iconst_1
    //   7602: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7605: return
    //   7606: aconst_null
    //   7607: astore 5
    //   7609: goto -102 -> 7507
    //   7612: aload 4
    //   7614: iconst_0
    //   7615: putfield 769	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7618: return
    //   7619: astore 5
    //   7621: goto -2496 -> 5125
    //   7624: astore 17
    //   7626: aload 16
    //   7628: astore_1
    //   7629: aload 17
    //   7631: astore 16
    //   7633: goto -6852 -> 781
    //   7636: aload 5
    //   7638: astore_0
    //   7639: goto -97 -> 7542
    //   7642: goto -210 -> 7432
    //   7645: aload_0
    //   7646: astore 5
    //   7648: goto -365 -> 7283
    //   7651: goto -287 -> 7364
    //   7654: goto -557 -> 7097
    //   7657: goto -1590 -> 6067
    //   7660: iconst_0
    //   7661: istore 6
    //   7663: iconst_0
    //   7664: istore 7
    //   7666: goto -1883 -> 5783
    //   7669: goto -4079 -> 3590
    //   7672: iconst_0
    //   7673: istore 6
    //   7675: goto -5311 -> 2364
    //   7678: goto -5397 -> 2281
    //   7681: aload 5
    //   7683: astore_0
    //   7684: goto -5729 -> 1955
    //   7687: iconst_0
    //   7688: istore 7
    //   7690: goto -6700 -> 990
    //   7693: goto -6786 -> 907
    //   7696: aload_1
    //   7697: astore_0
    //   7698: goto -7010 -> 688
    //   7701: iconst_0
    //   7702: istore 6
    //   7704: goto -7137 -> 567
    //   7707: iconst_0
    //   7708: istore 6
    //   7710: goto -7182 -> 528
    //   7713: goto -7264 -> 449
    //   7716: aload 16
    //   7718: astore 5
    //   7720: goto -7602 -> 118
    //   7723: iconst_0
    //   7724: istore 6
    //   7726: goto -7198 -> 528
    //   7729: iconst_1
    //   7730: istore_3
    //   7731: goto -5890 -> 1841
    //   7734: astore_1
    //   7735: aload 17
    //   7737: astore_0
    //   7738: goto -5697 -> 2041
    //   7741: iconst_0
    //   7742: istore 6
    //   7744: goto -5380 -> 2364
    //   7747: ldc2_w 39
    //   7750: lstore 14
    //   7752: goto -5308 -> 2444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7755	0	paramContext	Context
    //   0	7755	1	paramQQAppInterface	QQAppInterface
    //   0	7755	2	paramMessage	QQMessageFacade.Message
    //   0	7755	3	paramInt	int
    //   0	7755	4	paramMsgSummary	MsgSummary
    //   0	7755	5	paramString	String
    //   0	7755	6	paramBoolean1	boolean
    //   0	7755	7	paramBoolean2	boolean
    //   240	5602	8	i	int
    //   1710	522	9	j	int
    //   415	5759	10	bool1	boolean
    //   2235	3792	11	bool2	boolean
    //   1650	543	12	bool3	boolean
    //   1657	546	13	bool4	boolean
    //   512	7239	14	l	long
    //   7	704	16	localObject1	Object
    //   777	5	16	localException1	Exception
    //   788	6929	16	localObject2	Object
    //   427	2246	17	localObject3	Object
    //   7624	112	17	localException2	Exception
    //   418	1890	18	str1	String
    //   202	7341	19	str2	String
    //   2305	256	20	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   423	449	777	java/lang/Exception
    //   449	471	777	java/lang/Exception
    //   1888	1917	2040	java/lang/Exception
    //   1917	1924	2040	java/lang/Exception
    //   1929	1937	2040	java/lang/Exception
    //   1937	1953	2040	java/lang/Exception
    //   2029	2037	2040	java/lang/Exception
    //   2247	2253	2627	java/lang/Exception
    //   2257	2271	2627	java/lang/Exception
    //   2275	2281	2627	java/lang/Exception
    //   2285	2307	2627	java/lang/Exception
    //   2311	2325	2627	java/lang/Exception
    //   2328	2335	2627	java/lang/Exception
    //   2338	2345	2627	java/lang/Exception
    //   2560	2571	2627	java/lang/Exception
    //   2584	2591	2627	java/lang/Exception
    //   2594	2603	2627	java/lang/Exception
    //   2782	2817	2918	java/lang/Throwable
    //   2833	2883	2918	java/lang/Throwable
    //   2888	2913	2918	java/lang/Throwable
    //   4645	4651	5121	java/lang/Exception
    //   4651	4671	5121	java/lang/Exception
    //   4671	4685	5121	java/lang/Exception
    //   5713	5719	5853	java/lang/Exception
    //   5719	5739	5853	java/lang/Exception
    //   5739	5772	5853	java/lang/Exception
    //   5803	5811	5853	java/lang/Exception
    //   5820	5838	5853	java/lang/Exception
    //   4685	4713	7619	java/lang/Exception
    //   4717	4797	7619	java/lang/Exception
    //   5031	5038	7619	java/lang/Exception
    //   5042	5050	7619	java/lang/Exception
    //   5054	5065	7619	java/lang/Exception
    //   5073	5084	7619	java/lang/Exception
    //   5088	5099	7619	java/lang/Exception
    //   5099	5115	7619	java/lang/Exception
    //   475	489	7624	java/lang/Exception
    //   492	499	7624	java/lang/Exception
    //   507	514	7624	java/lang/Exception
    //   710	721	7624	java/lang/Exception
    //   734	741	7624	java/lang/Exception
    //   744	753	7624	java/lang/Exception
    //   1666	1675	7734	java/lang/Exception
    //   1683	1691	7734	java/lang/Exception
    //   1695	1712	7734	java/lang/Exception
    //   1723	1730	7734	java/lang/Exception
    //   1756	1769	7734	java/lang/Exception
    //   1773	1779	7734	java/lang/Exception
    //   1783	1790	7734	java/lang/Exception
    //   1794	1808	7734	java/lang/Exception
    //   1812	1838	7734	java/lang/Exception
    //   1853	1859	7734	java/lang/Exception
    //   1863	1876	7734	java/lang/Exception
    //   1880	1888	7734	java/lang/Exception
    //   1979	2005	7734	java/lang/Exception
    //   2012	2019	7734	java/lang/Exception
    //   2076	2081	7734	java/lang/Exception
    //   2089	2097	7734	java/lang/Exception
    //   2101	2109	7734	java/lang/Exception
    //   2113	2126	7734	java/lang/Exception
    //   2130	2137	7734	java/lang/Exception
    //   2146	2154	7734	java/lang/Exception
    //   2158	2174	7734	java/lang/Exception
    //   2178	2184	7734	java/lang/Exception
    //   2188	2201	7734	java/lang/Exception
    //   2211	2219	7734	java/lang/Exception
    //   2372	2379	7734	java/lang/Exception
    //   2383	2388	7734	java/lang/Exception
    //   2392	2403	7734	java/lang/Exception
    //   2414	2420	7734	java/lang/Exception
    //   2424	2431	7734	java/lang/Exception
    //   2435	2444	7734	java/lang/Exception
    //   2448	2489	7734	java/lang/Exception
    //   2497	2505	7734	java/lang/Exception
    //   2509	2516	7734	java/lang/Exception
    //   2520	2527	7734	java/lang/Exception
    //   2531	2539	7734	java/lang/Exception
    //   2543	2556	7734	java/lang/Exception
    //   2632	2636	7734	java/lang/Exception
    //   2664	2670	7734	java/lang/Exception
    //   2674	2701	7734	java/lang/Exception
  }
  
  private static void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.strPrefix = paramCharSequence1;
    paramMsgSummary.strContent = paramCharSequence2;
    paramMsgSummary.suffix = paramCharSequence3;
    if (paramBoolean1)
    {
      paramMsgSummary.nState = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.nState = 1;
      return;
    }
    paramMsgSummary.nState = 0;
  }
  
  public static boolean a(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    QQMessageFacade.Message localMessage = paramMessage;
    if (akpx.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (akpx.c(paramMessage.senderuin)) {
          return false;
        }
        i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label103;
          }
        }
      }
    }
    label103:
    for (int i = 1033;; i = 1034)
    {
      localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, i);
      if (localMessage.msgtype != -2005) {
        break label112;
      }
      if (2 != a(paramQQAppInterface, localMessage)) {
        break;
      }
      return true;
    }
    return false;
    label112:
    if (localMessage.msgtype == -2017)
    {
      paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && ((paramMessage instanceof MessageForTroopFile)))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramQQAppInterface = bakx.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof ayph)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((ayph)paramMessage).f() >= 0) && (((ayph)paramMessage).f() != 100)) {
      return true;
    }
    return paramQQAppInterface.a().b(localMessage);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramMessageForPic.isMultiMsg) {}
    while (!paramMessageForPic.isSendFromLocal()) {
      return false;
    }
    if (paramMessageForPic.size <= 0L)
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
      if ((paramQQAppInterface instanceof aypb))
      {
        long l = ((aypb)paramQQAppInterface).c();
        if ((l == 1005L) || ((l == 1006L) && (!paramBoolean)) || (l == 1004L)) {}
        for (paramBoolean = true;; paramBoolean = false) {
          return paramBoolean;
        }
      }
      return true;
    }
    if (paramMessageForPic.extraflag == 32768) {}
    for (paramBoolean = bool;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1.0F);
  }
  
  public static boolean b(int paramInt)
  {
    return 1 == paramInt;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    QQMessageFacade.Message localMessage;
    label105:
    label112:
    do
    {
      do
      {
        do
        {
          return false;
          localMessage = paramMessage;
          if (!akpx.a(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (akpx.c(paramMessage.senderuin));
        int i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label105;
          }
        }
        for (i = 1033;; i = 1034)
        {
          localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, i);
          if (localMessage.msgtype != -2005) {
            break label112;
          }
          if (a(paramQQAppInterface, localMessage) != 0) {
            break;
          }
          return true;
        }
        if (localMessage.fileType == 1)
        {
          i = paramQQAppInterface.a().b(localMessage.frienduin, null, localMessage.uniseq);
          if ((i != 1005) && (i != 1004)) {
            break label284;
          }
          return true;
        }
        if (localMessage.msgtype != -2017) {
          break label284;
        }
        paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
        if (!(paramMessage instanceof MessageForTroopFile)) {
          break;
        }
        paramMessage = (MessageForTroopFile)paramMessage;
      } while ((paramMessage == null) || (paramMessage.frienduin == null));
      paramQQAppInterface = bakx.a(paramQQAppInterface, paramMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.b != 3));
    return true;
    if (QLog.isColorLevel()) {
      QLog.d("MsgTypeError", 2, "uniseq:" + localMessage.uniseq + ",msgtype:" + localMessage.msgtype);
    }
    label284:
    if ((localMessage.isSendFromLocal()) && (localMessage.extraflag == 32768)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int j;
    int i;
    do
    {
      return paramString;
      localObject = paramString.toCharArray();
      j = paramString.length();
      i = 0;
      j -= 1;
      while ((i <= j) && (localObject[i] <= ' ') && (localObject[i] != '\024')) {
        i += 1;
      }
    } while (i == 0);
    Object localObject = paramString.substring(i, j + 1);
    if (QLog.isDevelopLevel()) {
      QLog.i("MsgUtils", 4, "trimBegin source:" + paramString + ", temp:" + (String)localObject);
    }
    return localObject;
  }
  
  public static boolean c(int paramInt)
  {
    return 2 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfh
 * JD-Core Version:    0.7.0.1
 */