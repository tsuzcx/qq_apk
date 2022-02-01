import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bgnr
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
    localObject = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((EntityManager)localObject).close();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = atvo.b(paramQQAppInterface.status);
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
    paramContext = paramQQAppInterface.a().a(bgkh.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131690055);
    }
    return paramQQAppInterface.getApp().getString(2131690057) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131690058);
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
        String str2 = bgju.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = bglf.b(paramQQAppInterface, paramMessage.senderuin, true);
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
                  paramContext = paramContext.getString(2131689582);
                  break;
                  paramContext = paramContext.getString(2131689497);
                  break;
                  paramContext = paramContext.getString(2131689496);
                  break;
                  paramContext = paramContext.getString(2131717293);
                  break;
                  paramContext = paramContext.getString(2131689619);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = bgju.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = bglf.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return bgju.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
    paramString = bgju.a(paramString, paramQQAppInterface);
    paramMessage = bgju.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = bglf.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = bgju.a(paramString, paramMessage, paramQQAppInterface);
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131692933));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131693717));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131717660));
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
            paramString1 = paramContext.getResources().getString(2131694910);
            if ((paramInt == 1) || (paramInt == 5000)) {
              paramString1 = paramContext.getResources().getString(2131694933);
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
            paramArrayOfString = paramQQAppInterface.getApp().getString(2131694935);
            paramArrayOfString = ":" + paramArrayOfString;
            return paramString1.replace(paramQQAppInterface.getApp().getString(2131694933), paramArrayOfString);
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
      paramString2 = bglf.a(paramQQAppInterface, paramString2, paramString1, i, 0);
      paramString1 = paramContext.getResources().getString(2131694910);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131694933);
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
          paramString1 = paramContext.getResources().getString(2131694930);
          break;
        }
        paramString1 = paramContext.getResources().getString(2131694862);
        break;
        label352:
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131694930);
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
            QLog.d("msgSummary", 2, "textSummary: " + bgjw.a(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (paramMessageForPic.picExtraData.isRelatedEmo()) || (ains.b(paramMessageForPic)) || (armt.b(paramMessageForPic)) || (aijp.a(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131691126);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131691126);
  }
  
  public static String a(String paramString)
  {
    String str = anni.a(2131705758);
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
        localObject3 = anni.a(2131705767);
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
              paramContext = paramContext.getResources().getString(2131695286);
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
        if (paramContext.getString(2131719032).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695303);
          }
          return paramContext.getResources().getString(2131694729);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695286) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131694715) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131719036).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131695299);
            }
            return paramContext.getResources().getString(2131695298);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131694724);
          }
          return paramContext.getResources().getString(2131694723);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695286) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131694715) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695299);
          }
          return paramContext.getResources().getString(2131695298);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131694724);
        }
        return paramContext.getResources().getString(2131694723);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695299);
          }
          return paramContext.getResources().getString(2131695298);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131694724);
        }
        return paramContext.getResources().getString(2131694723);
        if (j != 0) {
          return paramContext.getResources().getString(2131695300);
        }
        return paramContext.getResources().getString(2131694725);
        if (j != 0) {
          return paramContext.getResources().getString(2131695286);
        }
        return paramContext.getResources().getString(2131694715);
        if (j != 0) {
          return paramContext.getResources().getString(2131695287);
        }
        return paramContext.getResources().getString(2131694717);
        if (j != 0) {
          return paramContext.getResources().getString(2131695302);
        }
        return paramContext.getResources().getString(2131694728);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131719032).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695303);
          }
          return paramContext.getResources().getString(2131694729);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695286) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131694715) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131694715) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131694715);
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
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: iload_3
    //   9: aload 4
    //   11: aload 5
    //   13: iload 6
    //   15: iload 7
    //   17: invokestatic 505	bgnr:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   20: ifne -16 -> 4
    //   23: aload 5
    //   25: astore 16
    //   27: aload_2
    //   28: invokestatic 509	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   31: ifeq +7757 -> 7788
    //   34: aload 5
    //   36: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +24 -> 63
    //   42: aload 5
    //   44: astore 16
    //   46: aload 5
    //   48: aload_1
    //   49: aload_2
    //   50: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   53: iconst_1
    //   54: invokestatic 511	bglf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   57: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +7728 -> 7788
    //   63: aload_1
    //   64: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   67: aload_2
    //   68: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   71: aload_2
    //   72: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   75: aload_2
    //   76: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   79: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   82: astore 16
    //   84: aload 16
    //   86: instanceof 521
    //   89: ifeq +11 -> 100
    //   92: aload 16
    //   94: checkcast 521	com/tencent/mobileqq/data/ChatMessage
    //   97: invokevirtual 524	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   100: aload 16
    //   102: ifnull +13 -> 115
    //   105: aload 16
    //   107: invokestatic 527	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lnjp;
    //   110: getfield 531	njp:b	Ljava/lang/String;
    //   113: astore 5
    //   115: aload 5
    //   117: astore 16
    //   119: aload 5
    //   121: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +7664 -> 7788
    //   127: aload_2
    //   128: invokestatic 527	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lnjp;
    //   131: getfield 531	njp:b	Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: astore 16
    //   140: iload 6
    //   142: ifne +42 -> 184
    //   145: aload_2
    //   146: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   149: ifne +32 -> 181
    //   152: aload 5
    //   154: astore 16
    //   156: aload_2
    //   157: getfield 537	com/tencent/imcore/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   160: ifnull +24 -> 184
    //   163: aload 5
    //   165: astore 16
    //   167: aload_2
    //   168: getfield 537	com/tencent/imcore/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   171: aload_2
    //   172: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   175: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifeq +6 -> 184
    //   181: aconst_null
    //   182: astore 16
    //   184: aload_2
    //   185: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   188: invokestatic 542	acwh:l	(I)Z
    //   191: ifeq +6 -> 197
    //   194: aconst_null
    //   195: astore 16
    //   197: aload_2
    //   198: invokestatic 547	bfre:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lbfrf;
    //   201: astore 5
    //   203: aload 5
    //   205: ifnull +10 -> 215
    //   208: aload 5
    //   210: getfield 551	bfrf:c	Ljava/lang/String;
    //   213: astore 16
    //   215: aload 16
    //   217: invokestatic 552	bgnr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 19
    //   222: aload_2
    //   223: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   226: sipush -2034
    //   229: if_icmpne +16 -> 245
    //   232: aload 4
    //   234: aload_2
    //   235: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   238: invokestatic 560	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   244: return
    //   245: aload_2
    //   246: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   249: sipush -2011
    //   252: if_icmpne +157 -> 409
    //   255: iconst_0
    //   256: istore_3
    //   257: iconst_0
    //   258: istore 8
    //   260: aload_2
    //   261: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   264: sipush -2011
    //   267: if_icmpne +29 -> 296
    //   270: aload_2
    //   271: getfield 569	com/tencent/imcore/message/QQMessageFacade$Message:extInt	I
    //   274: bipush 61
    //   276: if_icmpne +20 -> 296
    //   279: aload_2
    //   280: aload_1
    //   281: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: invokevirtual 570	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   287: ldc_w 571
    //   290: invokevirtual 288	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   293: putfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   296: aload_2
    //   297: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   300: iconst_1
    //   301: if_icmpne +73 -> 374
    //   304: aload_1
    //   305: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   308: aload_2
    //   309: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   312: aload_2
    //   313: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   316: aload_2
    //   317: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   320: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   323: astore_0
    //   324: iload 8
    //   326: istore_3
    //   327: aload_0
    //   328: invokestatic 574	axci:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   331: ifeq +21 -> 352
    //   334: aconst_null
    //   335: aconst_null
    //   336: aload_0
    //   337: checkcast 576	com/tencent/mobileqq/data/MessageForStructing
    //   340: invokestatic 579	axci:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   343: iconst_0
    //   344: iconst_0
    //   345: aload 4
    //   347: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   350: iconst_1
    //   351: istore_3
    //   352: aload_0
    //   353: invokestatic 585	bfrd:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   356: ifeq +18 -> 374
    //   359: aconst_null
    //   360: aconst_null
    //   361: aload_2
    //   362: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   365: iconst_0
    //   366: iconst_0
    //   367: aload 4
    //   369: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   372: iconst_1
    //   373: istore_3
    //   374: iload_3
    //   375: ifne -371 -> 4
    //   378: aload_1
    //   379: aload_2
    //   380: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   383: istore 6
    //   385: aload_1
    //   386: aload_2
    //   387: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   390: istore 7
    //   392: aload 19
    //   394: aconst_null
    //   395: aload_2
    //   396: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   399: iload 6
    //   401: iload 7
    //   403: aload 4
    //   405: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   408: return
    //   409: aload_2
    //   410: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   413: sipush -2000
    //   416: if_icmpeq +13 -> 429
    //   419: aload_2
    //   420: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   423: sipush -5015
    //   426: if_icmpne +453 -> 879
    //   429: iconst_0
    //   430: istore 7
    //   432: iconst_0
    //   433: istore 10
    //   435: aconst_null
    //   436: astore 18
    //   438: aconst_null
    //   439: astore 5
    //   441: aload_2
    //   442: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   445: astore 17
    //   447: aload_2
    //   448: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   451: aload_2
    //   452: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   455: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   458: ifeq +7327 -> 7785
    //   461: aload_2
    //   462: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   465: astore 17
    //   467: aload_1
    //   468: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   471: aload 17
    //   473: aload_2
    //   474: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   477: aload_2
    //   478: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   481: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   484: checkcast 311	com/tencent/mobileqq/data/MessageForPic
    //   487: astore 16
    //   489: aload 18
    //   491: astore 5
    //   493: aload_1
    //   494: invokevirtual 596	com/tencent/mobileqq/app/QQAppInterface:a	()Lbdzi;
    //   497: aload 17
    //   499: aload_2
    //   500: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   503: invokevirtual 601	bdzi:a	(Ljava/lang/String;J)Lbguz;
    //   506: astore_1
    //   507: aload_1
    //   508: astore 5
    //   510: aload_2
    //   511: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   514: ifeq +231 -> 745
    //   517: aload 16
    //   519: ifnull +201 -> 720
    //   522: aload_1
    //   523: astore 5
    //   525: aload 16
    //   527: getfield 604	com/tencent/mobileqq/data/MessageForPic:size	J
    //   530: lstore 14
    //   532: lload 14
    //   534: lconst_0
    //   535: lcmp
    //   536: ifgt +184 -> 720
    //   539: aload_1
    //   540: ifnonnull +7239 -> 7779
    //   543: iconst_1
    //   544: istore 6
    //   546: aload 16
    //   548: astore 5
    //   550: iload 6
    //   552: istore 7
    //   554: aload_1
    //   555: astore 16
    //   557: aload 16
    //   559: instanceof 606
    //   562: ifeq +260 -> 822
    //   565: aload 16
    //   567: checkcast 606	bdsx
    //   570: astore_1
    //   571: aload_1
    //   572: invokevirtual 608	bdsx:c	()J
    //   575: ldc2_w 609
    //   578: lcmp
    //   579: ifeq +7194 -> 7773
    //   582: iconst_1
    //   583: istore 6
    //   585: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq +60 -> 648
    //   591: aload_1
    //   592: getfield 613	bdsx:a	Lbdzn;
    //   595: ifnull +219 -> 814
    //   598: aload_1
    //   599: getfield 613	bdsx:a	Lbdzn;
    //   602: getfield 616	bdzn:jdField_a_of_type_Long	J
    //   605: lstore 14
    //   607: ldc_w 618
    //   610: iconst_2
    //   611: new 161	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 620
    //   621: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: lload 14
    //   626: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   629: ldc_w 622
    //   632: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_1
    //   636: invokevirtual 624	bdsx:b	()Ljava/lang/String;
    //   639: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: aload_0
    //   649: ldc_w 625
    //   652: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   655: astore_1
    //   656: aload_2
    //   657: invokestatic 628	annq:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   660: ifne +10 -> 670
    //   663: aload_2
    //   664: invokestatic 631	anlk:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   667: ifeq +11 -> 678
    //   670: aload_0
    //   671: ldc_w 632
    //   674: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   677: astore_1
    //   678: aload_2
    //   679: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   682: sipush -5015
    //   685: if_icmpne +11 -> 696
    //   688: aload_0
    //   689: ldc_w 633
    //   692: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   695: astore_1
    //   696: aload 5
    //   698: invokestatic 635	bgnr:a	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   701: astore_0
    //   702: aload_0
    //   703: ifnull +7065 -> 7768
    //   706: aload 19
    //   708: aload_0
    //   709: aconst_null
    //   710: iload 7
    //   712: iload 6
    //   714: aload 4
    //   716: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   719: return
    //   720: aload 16
    //   722: ifnull +7057 -> 7779
    //   725: aload_1
    //   726: astore 5
    //   728: aload 16
    //   730: getfield 638	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   733: ldc_w 639
    //   736: if_icmpne +7059 -> 7795
    //   739: iconst_1
    //   740: istore 6
    //   742: goto -196 -> 546
    //   745: aload_1
    //   746: ifnull +7033 -> 7779
    //   749: aload_1
    //   750: astore 5
    //   752: aload_1
    //   753: instanceof 606
    //   756: ifeq +7023 -> 7779
    //   759: aload_1
    //   760: astore 5
    //   762: aload_1
    //   763: checkcast 606	bdsx
    //   766: invokevirtual 608	bdsx:c	()J
    //   769: lstore 14
    //   771: lload 14
    //   773: l2i
    //   774: istore_3
    //   775: iload_3
    //   776: sipush 1005
    //   779: if_icmpeq +10 -> 789
    //   782: iload_3
    //   783: sipush 1004
    //   786: if_icmpne +6993 -> 7779
    //   789: iconst_1
    //   790: istore 6
    //   792: goto -246 -> 546
    //   795: astore 16
    //   797: aconst_null
    //   798: astore_1
    //   799: aload 16
    //   801: invokevirtual 473	java/lang/Exception:printStackTrace	()V
    //   804: aload 5
    //   806: astore 16
    //   808: aload_1
    //   809: astore 5
    //   811: goto -254 -> 557
    //   814: ldc2_w 39
    //   817: lstore 14
    //   819: goto -212 -> 607
    //   822: iload 10
    //   824: istore 6
    //   826: aload 16
    //   828: ifnull -180 -> 648
    //   831: iconst_1
    //   832: istore 10
    //   834: iload 10
    //   836: istore 6
    //   838: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq -193 -> 648
    //   844: ldc_w 618
    //   847: iconst_2
    //   848: new 161	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 641
    //   858: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload 16
    //   863: invokevirtual 644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: iload 10
    //   874: istore 6
    //   876: goto -228 -> 648
    //   879: aload_2
    //   880: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   883: sipush -2002
    //   886: if_icmpeq +13 -> 899
    //   889: aload_2
    //   890: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   893: sipush -1031
    //   896: if_icmpne +265 -> 1161
    //   899: aload_2
    //   900: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   903: astore 16
    //   905: aload_2
    //   906: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   909: aload_2
    //   910: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   913: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   916: ifeq +6849 -> 7765
    //   919: aload_2
    //   920: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   923: astore 16
    //   925: iconst_0
    //   926: istore 6
    //   928: aload_0
    //   929: ldc_w 645
    //   932: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   935: astore_0
    //   936: aload_1
    //   937: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   940: aload 16
    //   942: aload_2
    //   943: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   946: aload_2
    //   947: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   950: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   953: astore 5
    //   955: aload 5
    //   957: instanceof 647
    //   960: ifeq +6799 -> 7759
    //   963: aload 5
    //   965: checkcast 647	com/tencent/mobileqq/data/MessageForPtt
    //   968: astore 17
    //   970: aload 17
    //   972: invokevirtual 650	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   975: astore 5
    //   977: aload 5
    //   979: astore_0
    //   980: aload_2
    //   981: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   984: ifeq +6775 -> 7759
    //   987: aload 17
    //   989: getfield 653	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   992: ldc2_w 39
    //   995: lcmp
    //   996: ifne +52 -> 1048
    //   999: iconst_1
    //   1000: istore 6
    //   1002: aload 5
    //   1004: astore_0
    //   1005: iconst_0
    //   1006: istore 7
    //   1008: ldc_w 655
    //   1011: iconst_2
    //   1012: anewarray 4	java/lang/Object
    //   1015: dup
    //   1016: iconst_0
    //   1017: iload 6
    //   1019: invokestatic 658	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_1
    //   1025: iload 7
    //   1027: invokestatic 658	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1030: aastore
    //   1031: invokestatic 663	arkw:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: aload 19
    //   1036: aload_0
    //   1037: aconst_null
    //   1038: iload 6
    //   1040: iload 7
    //   1042: aload 4
    //   1044: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1047: return
    //   1048: aload 5
    //   1050: astore_0
    //   1051: aload 17
    //   1053: getfield 653	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1056: lconst_0
    //   1057: lcmp
    //   1058: ifgt +6701 -> 7759
    //   1061: aload_1
    //   1062: invokevirtual 596	com/tencent/mobileqq/app/QQAppInterface:a	()Lbdzi;
    //   1065: aload 16
    //   1067: aload 17
    //   1069: getfield 666	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1072: aload 17
    //   1074: getfield 667	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   1077: invokevirtual 670	bdzi:b	(Ljava/lang/String;Ljava/lang/String;J)I
    //   1080: istore_3
    //   1081: iload_3
    //   1082: sipush 1005
    //   1085: if_icmpeq +15 -> 1100
    //   1088: iload_3
    //   1089: sipush 1004
    //   1092: if_icmpeq +8 -> 1100
    //   1095: iload_3
    //   1096: iconst_m1
    //   1097: if_icmpne +55 -> 1152
    //   1100: iconst_1
    //   1101: istore 7
    //   1103: iconst_0
    //   1104: istore 6
    //   1106: ldc_w 655
    //   1109: iconst_2
    //   1110: anewarray 4	java/lang/Object
    //   1113: dup
    //   1114: iconst_0
    //   1115: aload 17
    //   1117: getfield 653	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1120: invokestatic 675	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1123: aastore
    //   1124: dup
    //   1125: iconst_1
    //   1126: iload_3
    //   1127: invokestatic 678	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1130: aastore
    //   1131: invokestatic 663	arkw:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1134: aload 5
    //   1136: astore_0
    //   1137: iload 6
    //   1139: istore 10
    //   1141: iload 7
    //   1143: istore 6
    //   1145: iload 10
    //   1147: istore 7
    //   1149: goto -141 -> 1008
    //   1152: iconst_1
    //   1153: istore 6
    //   1155: iconst_0
    //   1156: istore 7
    //   1158: goto -52 -> 1106
    //   1161: aload_2
    //   1162: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1165: sipush -3008
    //   1168: if_icmpne +48 -> 1216
    //   1171: aload 4
    //   1173: new 161	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1180: aload_0
    //   1181: ldc_w 679
    //   1184: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   1187: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: ldc_w 681
    //   1193: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_2
    //   1197: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1200: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: ldc_w 681
    //   1206: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1215: return
    //   1216: aload_2
    //   1217: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1220: sipush -2015
    //   1223: if_icmpeq +103 -> 1326
    //   1226: aload_2
    //   1227: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1230: sipush -2060
    //   1233: if_icmpeq +93 -> 1326
    //   1236: aload_2
    //   1237: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1240: sipush -2062
    //   1243: if_icmpeq +83 -> 1326
    //   1246: aload_2
    //   1247: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1250: sipush -2065
    //   1253: if_icmpeq +73 -> 1326
    //   1256: aload_2
    //   1257: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1260: sipush -7010
    //   1263: if_icmpeq +63 -> 1326
    //   1266: aload_2
    //   1267: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1270: sipush -7009
    //   1273: if_icmpeq +53 -> 1326
    //   1276: aload_2
    //   1277: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1280: sipush -7011
    //   1283: if_icmpeq +43 -> 1326
    //   1286: aload_2
    //   1287: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1290: sipush -7012
    //   1293: if_icmpeq +33 -> 1326
    //   1296: aload_2
    //   1297: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1300: sipush -4023
    //   1303: if_icmpeq +23 -> 1326
    //   1306: aload_2
    //   1307: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1310: sipush -4024
    //   1313: if_icmpeq +13 -> 1326
    //   1316: aload_2
    //   1317: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1320: sipush -7013
    //   1323: if_icmpne +11 -> 1334
    //   1326: aload 4
    //   1328: ldc 120
    //   1330: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1333: return
    //   1334: aload_2
    //   1335: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1338: invokestatic 685	bgjz:a	(I)Z
    //   1341: ifeq +28 -> 1369
    //   1344: aload 19
    //   1346: aload_0
    //   1347: aload_1
    //   1348: aload_2
    //   1349: invokestatic 687	bgnr:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1352: aconst_null
    //   1353: aload_1
    //   1354: aload_2
    //   1355: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1358: aload_1
    //   1359: aload_2
    //   1360: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1363: aload 4
    //   1365: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1368: return
    //   1369: aload_2
    //   1370: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1373: sipush -2017
    //   1376: if_icmpne +94 -> 1470
    //   1379: aload_0
    //   1380: ldc_w 688
    //   1383: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   1386: astore 5
    //   1388: aload_2
    //   1389: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1392: astore_0
    //   1393: aload_2
    //   1394: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1397: aload_2
    //   1398: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1401: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   1404: ifeq +8 -> 1412
    //   1407: aload_2
    //   1408: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1411: astore_0
    //   1412: aload_1
    //   1413: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1416: aload_0
    //   1417: aload_2
    //   1418: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1421: aload_2
    //   1422: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   1425: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1428: astore 16
    //   1430: aload 5
    //   1432: astore_0
    //   1433: aload 16
    //   1435: instanceof 690
    //   1438: ifeq +12 -> 1450
    //   1441: aload 16
    //   1443: checkcast 690	com/tencent/mobileqq/data/MessageForTroopFile
    //   1446: invokevirtual 691	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1449: astore_0
    //   1450: aload 19
    //   1452: aload_0
    //   1453: aconst_null
    //   1454: aload_1
    //   1455: aload_2
    //   1456: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1459: aload_1
    //   1460: aload_2
    //   1461: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1464: aload 4
    //   1466: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1469: return
    //   1470: aload_2
    //   1471: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1474: invokestatic 693	bgjz:b	(I)Z
    //   1477: ifeq +35 -> 1512
    //   1480: aload_2
    //   1481: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1484: invokestatic 698	bdzv:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1487: astore_1
    //   1488: aload_1
    //   1489: ifnull -1485 -> 4
    //   1492: aload 4
    //   1494: aload_1
    //   1495: aload_0
    //   1496: aload_2
    //   1497: getfield 701	com/tencent/imcore/message/QQMessageFacade$Message:issend	I
    //   1500: invokestatic 702	bgnr:b	(I)Z
    //   1503: iload 7
    //   1505: invokestatic 704	bgnr:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1508: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1511: return
    //   1512: aload_2
    //   1513: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1516: invokestatic 706	bgjz:c	(I)Z
    //   1519: ifeq +39 -> 1558
    //   1522: aload_2
    //   1523: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1526: invokestatic 698	bdzv:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1529: astore 5
    //   1531: aload 5
    //   1533: ifnull -1529 -> 4
    //   1536: aload 4
    //   1538: aload_1
    //   1539: aload 5
    //   1541: aload_0
    //   1542: aload_2
    //   1543: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1546: aload_2
    //   1547: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1550: iload_3
    //   1551: invokestatic 708	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1554: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1557: return
    //   1558: aload_2
    //   1559: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1562: invokestatic 710	bgjz:d	(I)Z
    //   1565: ifeq +134 -> 1699
    //   1568: aload_1
    //   1569: aload_2
    //   1570: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1573: istore 6
    //   1575: aload_1
    //   1576: aload_2
    //   1577: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1580: istore 7
    //   1582: aload_2
    //   1583: ldc_w 712
    //   1586: invokevirtual 715	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1589: astore 5
    //   1591: getstatic 720	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1594: ifeq +96 -> 1690
    //   1597: aload 5
    //   1599: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1602: ifne +88 -> 1690
    //   1605: aload_0
    //   1606: aload_2
    //   1607: invokestatic 725	arpm:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1610: astore_0
    //   1611: aload_2
    //   1612: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1615: aload_1
    //   1616: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1619: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1622: ifeq +41 -> 1663
    //   1625: new 161	java/lang/StringBuilder
    //   1628: dup
    //   1629: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1632: ldc_w 726
    //   1635: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   1638: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: aload_0
    //   1642: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1648: astore_0
    //   1649: aload 19
    //   1651: aload_0
    //   1652: aconst_null
    //   1653: iload 6
    //   1655: iload 7
    //   1657: aload 4
    //   1659: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1662: return
    //   1663: new 161	java/lang/StringBuilder
    //   1666: dup
    //   1667: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1670: ldc_w 727
    //   1673: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   1676: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: aload_0
    //   1680: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: astore_0
    //   1687: goto -38 -> 1649
    //   1690: aload_0
    //   1691: aload_2
    //   1692: invokestatic 725	arpm:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1695: astore_0
    //   1696: goto -47 -> 1649
    //   1699: aload_2
    //   1700: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1703: sipush -2058
    //   1706: if_icmpne +1070 -> 2776
    //   1709: ldc 120
    //   1711: astore 18
    //   1713: aload_1
    //   1714: aload_2
    //   1715: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1718: istore 12
    //   1720: aload_1
    //   1721: aload_2
    //   1722: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1725: istore 13
    //   1727: iconst_0
    //   1728: istore 8
    //   1730: aload 18
    //   1732: astore 17
    //   1734: aload_2
    //   1735: ldc_w 729
    //   1738: invokevirtual 715	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1741: astore 5
    //   1743: aload 18
    //   1745: astore 16
    //   1747: aload 18
    //   1749: astore 17
    //   1751: aload 5
    //   1753: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1756: ifne +270 -> 2026
    //   1759: aload 18
    //   1761: astore 17
    //   1763: new 731	org/json/JSONObject
    //   1766: dup
    //   1767: aload 5
    //   1769: invokespecial 734	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1772: ldc_w 736
    //   1775: invokevirtual 739	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1778: istore 9
    //   1780: iload 8
    //   1782: istore_3
    //   1783: aload 18
    //   1785: astore 5
    //   1787: aload 18
    //   1789: astore 17
    //   1791: aload_2
    //   1792: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1795: ifnull +114 -> 1909
    //   1798: iload 8
    //   1800: istore_3
    //   1801: aload 18
    //   1803: astore 5
    //   1805: iload 9
    //   1807: sipush -2007
    //   1810: if_icmpne +99 -> 1909
    //   1813: iload 8
    //   1815: istore_3
    //   1816: aload 18
    //   1818: astore 5
    //   1820: aload 18
    //   1822: astore 17
    //   1824: aload_2
    //   1825: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1828: invokestatic 748	aopw:a	([B)Ljava/lang/Object;
    //   1831: instanceof 750
    //   1834: ifeq +75 -> 1909
    //   1837: aload 18
    //   1839: astore 17
    //   1841: getstatic 720	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1844: ifeq +232 -> 2076
    //   1847: aload 18
    //   1849: astore 17
    //   1851: aload_0
    //   1852: aload_2
    //   1853: invokestatic 725	arpm:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1856: astore 5
    //   1858: aload 18
    //   1860: astore 17
    //   1862: aload_2
    //   1863: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1866: aload_1
    //   1867: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1870: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1873: ifeq +170 -> 2043
    //   1876: aload 18
    //   1878: astore 17
    //   1880: new 161	java/lang/StringBuilder
    //   1883: dup
    //   1884: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1887: ldc_w 751
    //   1890: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   1893: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: aload 5
    //   1898: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1904: astore 5
    //   1906: goto +5895 -> 7801
    //   1909: aload 5
    //   1911: astore 16
    //   1913: iload_3
    //   1914: ifne +112 -> 2026
    //   1917: aload 5
    //   1919: astore 17
    //   1921: getstatic 720	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1924: ifeq +208 -> 2132
    //   1927: aload 5
    //   1929: astore 17
    //   1931: aload_2
    //   1932: ldc_w 712
    //   1935: invokevirtual 715	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1938: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1941: ifne +5812 -> 7753
    //   1944: aload 5
    //   1946: astore 17
    //   1948: aload_1
    //   1949: aload_2
    //   1950: aload 4
    //   1952: invokestatic 754	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lbdnt;
    //   1955: astore_0
    //   1956: new 161	java/lang/StringBuilder
    //   1959: dup
    //   1960: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1963: astore_1
    //   1964: aload 19
    //   1966: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1969: ifne +16 -> 1985
    //   1972: aload_1
    //   1973: aload 19
    //   1975: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: ldc_w 380
    //   1981: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload_2
    //   1986: invokestatic 509	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1989: ifne +16 -> 2005
    //   1992: iload 12
    //   1994: ifeq +98 -> 2092
    //   1997: aload_1
    //   1998: ldc_w 756
    //   2001: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: pop
    //   2005: aload_0
    //   2006: checkcast 758	bdnt
    //   2009: aload_1
    //   2010: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2013: iconst_1
    //   2014: iconst_0
    //   2015: newarray int
    //   2017: invokevirtual 761	bdnt:a	(Ljava/lang/String;Z[I)Lbdnt;
    //   2020: astore_1
    //   2021: aload_1
    //   2022: astore_0
    //   2023: aload_0
    //   2024: astore 16
    //   2026: aload 16
    //   2028: astore_2
    //   2029: aload 19
    //   2031: aload_2
    //   2032: aconst_null
    //   2033: iload 12
    //   2035: iload 13
    //   2037: aload 4
    //   2039: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2042: return
    //   2043: aload 18
    //   2045: astore 17
    //   2047: new 161	java/lang/StringBuilder
    //   2050: dup
    //   2051: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2054: ldc_w 762
    //   2057: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   2060: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: aload 5
    //   2065: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2071: astore 5
    //   2073: goto +5728 -> 7801
    //   2076: aload 18
    //   2078: astore 17
    //   2080: aload_0
    //   2081: aload_2
    //   2082: invokestatic 725	arpm:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   2085: astore 5
    //   2087: iconst_1
    //   2088: istore_3
    //   2089: goto -180 -> 1909
    //   2092: iload 13
    //   2094: ifeq -89 -> 2005
    //   2097: aload_1
    //   2098: ldc_w 764
    //   2101: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: pop
    //   2105: goto -100 -> 2005
    //   2108: astore_1
    //   2109: aload_0
    //   2110: astore_2
    //   2111: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2114: ifeq -85 -> 2029
    //   2117: ldc_w 766
    //   2120: iconst_2
    //   2121: ldc 120
    //   2123: aload_1
    //   2124: invokestatic 769	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2127: aload_0
    //   2128: astore_2
    //   2129: goto -100 -> 2029
    //   2132: iload 9
    //   2134: sipush -1000
    //   2137: if_icmpne +153 -> 2290
    //   2140: aload 5
    //   2142: astore 17
    //   2144: aload_2
    //   2145: invokestatic 772	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;)Lbdnt;
    //   2148: astore_0
    //   2149: aload_0
    //   2150: ifnull -2146 -> 4
    //   2153: aload 5
    //   2155: astore 17
    //   2157: new 161	java/lang/StringBuilder
    //   2160: dup
    //   2161: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2164: astore_1
    //   2165: aload 5
    //   2167: astore 17
    //   2169: aload 19
    //   2171: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2174: ifne +20 -> 2194
    //   2177: aload 5
    //   2179: astore 17
    //   2181: aload_1
    //   2182: aload 19
    //   2184: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: ldc_w 380
    //   2190: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: pop
    //   2194: aload 5
    //   2196: astore 17
    //   2198: aload_2
    //   2199: invokestatic 509	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2202: ifne +20 -> 2222
    //   2205: iload 12
    //   2207: ifeq +63 -> 2270
    //   2210: aload 5
    //   2212: astore 17
    //   2214: aload_1
    //   2215: ldc_w 756
    //   2218: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2221: pop
    //   2222: aload 5
    //   2224: astore 17
    //   2226: aload_0
    //   2227: checkcast 758	bdnt
    //   2230: aload_1
    //   2231: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2234: iconst_1
    //   2235: iconst_0
    //   2236: newarray int
    //   2238: invokevirtual 761	bdnt:a	(Ljava/lang/String;Z[I)Lbdnt;
    //   2241: astore_0
    //   2242: aload 5
    //   2244: astore 17
    //   2246: aload 4
    //   2248: iconst_1
    //   2249: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2252: aload 5
    //   2254: astore 17
    //   2256: aload 19
    //   2258: aload_0
    //   2259: aconst_null
    //   2260: iload 12
    //   2262: iload 13
    //   2264: aload 4
    //   2266: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2269: return
    //   2270: iload 13
    //   2272: ifeq -50 -> 2222
    //   2275: aload 5
    //   2277: astore 17
    //   2279: aload_1
    //   2280: ldc_w 764
    //   2283: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2286: pop
    //   2287: goto -65 -> 2222
    //   2290: aload 5
    //   2292: astore 16
    //   2294: iload 9
    //   2296: sipush -2000
    //   2299: if_icmpne -273 -> 2026
    //   2302: iconst_0
    //   2303: istore 11
    //   2305: iconst_0
    //   2306: istore 7
    //   2308: aconst_null
    //   2309: astore 18
    //   2311: aload 18
    //   2313: astore 16
    //   2315: aload_2
    //   2316: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2319: astore 17
    //   2321: aload 18
    //   2323: astore 16
    //   2325: aload_2
    //   2326: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2329: aload_2
    //   2330: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2333: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   2336: ifeq +5414 -> 7750
    //   2339: aload 18
    //   2341: astore 16
    //   2343: aload_2
    //   2344: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2347: astore 17
    //   2349: aload 18
    //   2351: astore 16
    //   2353: aload_1
    //   2354: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   2357: aload 17
    //   2359: aload_2
    //   2360: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2363: aload_2
    //   2364: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2367: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2370: checkcast 311	com/tencent/mobileqq/data/MessageForPic
    //   2373: astore 20
    //   2375: aload 18
    //   2377: astore 16
    //   2379: aload_1
    //   2380: invokevirtual 596	com/tencent/mobileqq/app/QQAppInterface:a	()Lbdzi;
    //   2383: aload 17
    //   2385: aload_2
    //   2386: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2389: invokevirtual 601	bdzi:a	(Ljava/lang/String;J)Lbguz;
    //   2392: astore_1
    //   2393: aload_1
    //   2394: astore 16
    //   2396: aload_2
    //   2397: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2400: ifeq +245 -> 2645
    //   2403: aload_1
    //   2404: astore 16
    //   2406: aload 20
    //   2408: getfield 604	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2411: lstore 14
    //   2413: lload 14
    //   2415: lconst_0
    //   2416: lcmp
    //   2417: ifgt +208 -> 2625
    //   2420: aload_1
    //   2421: ifnonnull +5323 -> 7744
    //   2424: aload 20
    //   2426: ifnull +5318 -> 7744
    //   2429: iconst_1
    //   2430: istore 6
    //   2432: iload 6
    //   2434: istore 10
    //   2436: aload 5
    //   2438: astore 17
    //   2440: aload_1
    //   2441: instanceof 606
    //   2444: ifeq +269 -> 2713
    //   2447: aload 5
    //   2449: astore 17
    //   2451: aload_1
    //   2452: checkcast 606	bdsx
    //   2455: astore_1
    //   2456: aload 5
    //   2458: astore 17
    //   2460: aload_1
    //   2461: invokevirtual 608	bdsx:c	()J
    //   2464: ldc2_w 609
    //   2467: lcmp
    //   2468: ifeq +6 -> 2474
    //   2471: iconst_1
    //   2472: istore 7
    //   2474: iload 7
    //   2476: istore 6
    //   2478: aload 5
    //   2480: astore 17
    //   2482: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2485: ifeq +76 -> 2561
    //   2488: aload 5
    //   2490: astore 17
    //   2492: aload_1
    //   2493: getfield 613	bdsx:a	Lbdzn;
    //   2496: ifnull +5323 -> 7819
    //   2499: aload 5
    //   2501: astore 17
    //   2503: aload_1
    //   2504: getfield 613	bdsx:a	Lbdzn;
    //   2507: getfield 616	bdzn:jdField_a_of_type_Long	J
    //   2510: lstore 14
    //   2512: aload 5
    //   2514: astore 17
    //   2516: ldc_w 618
    //   2519: iconst_2
    //   2520: new 161	java/lang/StringBuilder
    //   2523: dup
    //   2524: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2527: ldc_w 620
    //   2530: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2533: lload 14
    //   2535: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2538: ldc_w 622
    //   2541: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: aload_1
    //   2545: invokevirtual 624	bdsx:b	()Ljava/lang/String;
    //   2548: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2554: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2557: iload 7
    //   2559: istore 6
    //   2561: aload 5
    //   2563: astore 17
    //   2565: aload_0
    //   2566: ldc_w 625
    //   2569: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   2572: astore_1
    //   2573: aload 5
    //   2575: astore 17
    //   2577: aload_2
    //   2578: invokestatic 628	annq:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2581: ifne +14 -> 2595
    //   2584: aload 5
    //   2586: astore 17
    //   2588: aload_2
    //   2589: invokestatic 631	anlk:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2592: ifeq +15 -> 2607
    //   2595: aload 5
    //   2597: astore 17
    //   2599: aload_0
    //   2600: ldc_w 632
    //   2603: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   2606: astore_1
    //   2607: aload 5
    //   2609: astore 17
    //   2611: aload 19
    //   2613: aload_1
    //   2614: aconst_null
    //   2615: iload 10
    //   2617: iload 6
    //   2619: aload 4
    //   2621: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2624: return
    //   2625: aload_1
    //   2626: astore 16
    //   2628: aload 20
    //   2630: getfield 638	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2633: ldc_w 639
    //   2636: if_icmpne +5177 -> 7813
    //   2639: iconst_1
    //   2640: istore 6
    //   2642: goto -210 -> 2432
    //   2645: aload_1
    //   2646: ifnull +5098 -> 7744
    //   2649: aload_1
    //   2650: astore 16
    //   2652: aload_1
    //   2653: instanceof 606
    //   2656: ifeq +5088 -> 7744
    //   2659: aload_1
    //   2660: astore 16
    //   2662: aload_1
    //   2663: checkcast 606	bdsx
    //   2666: invokevirtual 608	bdsx:c	()J
    //   2669: lstore 14
    //   2671: lload 14
    //   2673: l2i
    //   2674: istore_3
    //   2675: iload_3
    //   2676: sipush 1005
    //   2679: if_icmpeq +10 -> 2689
    //   2682: iload_3
    //   2683: sipush 1004
    //   2686: if_icmpne +5058 -> 7744
    //   2689: iconst_1
    //   2690: istore 6
    //   2692: goto -260 -> 2432
    //   2695: astore_1
    //   2696: aload 5
    //   2698: astore 17
    //   2700: aload_1
    //   2701: invokevirtual 473	java/lang/Exception:printStackTrace	()V
    //   2704: aload 16
    //   2706: astore_1
    //   2707: iconst_0
    //   2708: istore 10
    //   2710: goto -274 -> 2436
    //   2713: iload 11
    //   2715: istore 6
    //   2717: aload_1
    //   2718: ifnull -157 -> 2561
    //   2721: iconst_1
    //   2722: istore 7
    //   2724: iload 7
    //   2726: istore 6
    //   2728: aload 5
    //   2730: astore 17
    //   2732: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2735: ifeq -174 -> 2561
    //   2738: aload 5
    //   2740: astore 17
    //   2742: ldc_w 618
    //   2745: iconst_2
    //   2746: new 161	java/lang/StringBuilder
    //   2749: dup
    //   2750: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2753: ldc_w 641
    //   2756: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: aload_1
    //   2760: invokevirtual 644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2763: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2766: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2769: iload 7
    //   2771: istore 6
    //   2773: goto -212 -> 2561
    //   2776: aload_2
    //   2777: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2780: invokestatic 777	bgjz:e	(I)Z
    //   2783: ifeq +267 -> 3050
    //   2786: new 779	com/tencent/mobileqq/data/MessageForApollo
    //   2789: dup
    //   2790: invokespecial 780	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2793: astore 5
    //   2795: aload 5
    //   2797: aload_2
    //   2798: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   2801: putfield 781	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2804: aload 5
    //   2806: invokevirtual 782	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2809: aload_1
    //   2810: aload_2
    //   2811: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2814: istore 6
    //   2816: aload_1
    //   2817: aload_2
    //   2818: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2821: istore 7
    //   2823: aload 5
    //   2825: getfield 784	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2828: invokestatic 787	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2831: ifeq +209 -> 3040
    //   2834: ldc_w 788
    //   2837: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   2840: astore_0
    //   2841: aload 5
    //   2843: getfield 784	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2846: iconst_4
    //   2847: if_icmpne +155 -> 3002
    //   2850: aload 5
    //   2852: getfield 791	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2855: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2858: ifeq +43 -> 2901
    //   2861: new 161	java/lang/StringBuilder
    //   2864: dup
    //   2865: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2868: aload_0
    //   2869: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2872: ldc_w 792
    //   2875: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   2878: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2884: astore_1
    //   2885: aload_1
    //   2886: astore_0
    //   2887: aload 19
    //   2889: aload_0
    //   2890: aconst_null
    //   2891: iload 6
    //   2893: iload 7
    //   2895: aload 4
    //   2897: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2900: return
    //   2901: new 731	org/json/JSONObject
    //   2904: dup
    //   2905: aload 5
    //   2907: getfield 791	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2910: invokespecial 734	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2913: ldc_w 794
    //   2916: invokevirtual 797	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2919: astore_1
    //   2920: aload_1
    //   2921: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2924: ifeq +32 -> 2956
    //   2927: new 161	java/lang/StringBuilder
    //   2930: dup
    //   2931: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2934: aload_0
    //   2935: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2938: ldc_w 798
    //   2941: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   2944: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2947: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2950: astore_1
    //   2951: aload_1
    //   2952: astore_0
    //   2953: goto -66 -> 2887
    //   2956: new 161	java/lang/StringBuilder
    //   2959: dup
    //   2960: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2963: aload_0
    //   2964: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2967: ldc_w 484
    //   2970: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2973: aload_1
    //   2974: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2977: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2980: astore_1
    //   2981: aload_1
    //   2982: astore_0
    //   2983: goto -96 -> 2887
    //   2986: astore_1
    //   2987: ldc_w 766
    //   2990: iconst_1
    //   2991: aload_1
    //   2992: iconst_0
    //   2993: anewarray 4	java/lang/Object
    //   2996: invokestatic 801	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2999: goto -112 -> 2887
    //   3002: aload_1
    //   3003: aload 5
    //   3005: invokestatic 806	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   3008: astore_1
    //   3009: new 161	java/lang/StringBuilder
    //   3012: dup
    //   3013: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3016: aload_0
    //   3017: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3020: ldc_w 807
    //   3023: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   3026: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3029: aload_1
    //   3030: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3033: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3036: astore_0
    //   3037: goto -150 -> 2887
    //   3040: aload_1
    //   3041: aload 5
    //   3043: invokestatic 809	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   3046: astore_0
    //   3047: goto -160 -> 2887
    //   3050: aload_2
    //   3051: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3054: sipush -1013
    //   3057: if_icmpeq +13 -> 3070
    //   3060: aload_2
    //   3061: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3064: sipush -1047
    //   3067: if_icmpne +20 -> 3087
    //   3070: aconst_null
    //   3071: aconst_null
    //   3072: aload_2
    //   3073: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3076: invokestatic 560	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3079: iconst_0
    //   3080: iconst_0
    //   3081: aload 4
    //   3083: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3086: return
    //   3087: aload_2
    //   3088: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3091: sipush -2042
    //   3094: if_icmpeq +13 -> 3107
    //   3097: aload_2
    //   3098: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3101: sipush -2043
    //   3104: if_icmpne +20 -> 3124
    //   3107: aconst_null
    //   3108: aload_2
    //   3109: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3112: invokestatic 560	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3115: aconst_null
    //   3116: iconst_0
    //   3117: iconst_0
    //   3118: aload 4
    //   3120: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3123: return
    //   3124: aload_2
    //   3125: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3128: sipush -2051
    //   3131: if_icmpne +155 -> 3286
    //   3134: aload_1
    //   3135: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3138: aload_2
    //   3139: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3142: aload_2
    //   3143: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3146: aload_2
    //   3147: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3150: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3153: astore_0
    //   3154: aload_0
    //   3155: ifnull +50 -> 3205
    //   3158: aload_0
    //   3159: instanceof 811
    //   3162: ifeq +43 -> 3205
    //   3165: aload_0
    //   3166: checkcast 811	com/tencent/mobileqq/data/MessageForQQStory
    //   3169: astore_0
    //   3170: aload_0
    //   3171: invokevirtual 812	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3174: aload_1
    //   3175: aload_2
    //   3176: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3179: istore 6
    //   3181: aload_1
    //   3182: aload_2
    //   3183: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3186: istore 7
    //   3188: aload 19
    //   3190: aconst_null
    //   3191: aload_0
    //   3192: invokevirtual 813	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3195: iload 6
    //   3197: iload 7
    //   3199: aload 4
    //   3201: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3204: return
    //   3205: new 161	java/lang/StringBuilder
    //   3208: dup
    //   3209: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3212: ldc 2
    //   3214: invokevirtual 818	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3217: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3220: ldc_w 820
    //   3223: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3229: astore_1
    //   3230: new 161	java/lang/StringBuilder
    //   3233: dup
    //   3234: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3237: ldc_w 822
    //   3240: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3243: aload_2
    //   3244: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3247: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3250: ldc_w 824
    //   3253: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3256: astore_2
    //   3257: aload_0
    //   3258: ifnull +22 -> 3280
    //   3261: aload_0
    //   3262: invokevirtual 827	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3265: astore_0
    //   3266: aload_1
    //   3267: iconst_1
    //   3268: aload_2
    //   3269: aload_0
    //   3270: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3273: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3276: invokestatic 829	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3279: return
    //   3280: ldc 120
    //   3282: astore_0
    //   3283: goto -17 -> 3266
    //   3286: aload_2
    //   3287: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3290: sipush -7002
    //   3293: if_icmpne +148 -> 3441
    //   3296: aload_1
    //   3297: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3300: aload_2
    //   3301: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3304: aload_2
    //   3305: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3308: aload_2
    //   3309: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3312: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3315: checkcast 831	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3318: astore_0
    //   3319: aload_0
    //   3320: ifnull +38 -> 3358
    //   3323: aload_0
    //   3324: invokevirtual 832	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3327: aload_1
    //   3328: aload_2
    //   3329: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3332: istore 6
    //   3334: aload_1
    //   3335: aload_2
    //   3336: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3339: istore 7
    //   3341: aload 19
    //   3343: aconst_null
    //   3344: aload_0
    //   3345: invokevirtual 833	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3348: iload 6
    //   3350: iload 7
    //   3352: aload 4
    //   3354: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3357: return
    //   3358: new 161	java/lang/StringBuilder
    //   3361: dup
    //   3362: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3365: ldc 2
    //   3367: invokevirtual 818	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3370: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: ldc_w 820
    //   3376: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3379: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3382: astore_1
    //   3383: new 161	java/lang/StringBuilder
    //   3386: dup
    //   3387: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3390: ldc_w 835
    //   3393: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3396: aload_2
    //   3397: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3400: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3403: ldc_w 824
    //   3406: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3409: astore 4
    //   3411: aload_2
    //   3412: ifnull +23 -> 3435
    //   3415: aload_2
    //   3416: invokevirtual 836	com/tencent/imcore/message/QQMessageFacade$Message:toString	()Ljava/lang/String;
    //   3419: astore_0
    //   3420: aload_1
    //   3421: iconst_1
    //   3422: aload 4
    //   3424: aload_0
    //   3425: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3428: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3431: invokestatic 829	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3434: return
    //   3435: ldc 120
    //   3437: astore_0
    //   3438: goto -18 -> 3420
    //   3441: aload_2
    //   3442: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3445: sipush -2054
    //   3448: if_icmpne +153 -> 3601
    //   3451: aload_1
    //   3452: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3455: aload_2
    //   3456: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3459: aload_2
    //   3460: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3463: aload_2
    //   3464: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3467: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3470: astore_0
    //   3471: aload_0
    //   3472: instanceof 838
    //   3475: ifeq +42 -> 3517
    //   3478: aload_0
    //   3479: checkcast 838	com/tencent/mobileqq/data/MessageForTroopSign
    //   3482: astore_0
    //   3483: ldc_w 839
    //   3486: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   3489: pop
    //   3490: aload_0
    //   3491: invokevirtual 840	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3494: aload 19
    //   3496: aconst_null
    //   3497: aload_0
    //   3498: invokevirtual 841	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3501: aload_1
    //   3502: aload_2
    //   3503: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3506: aload_1
    //   3507: aload_2
    //   3508: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3511: aload 4
    //   3513: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3516: return
    //   3517: new 161	java/lang/StringBuilder
    //   3520: dup
    //   3521: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3524: ldc 2
    //   3526: invokevirtual 818	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3529: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3532: ldc_w 843
    //   3535: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3541: astore_1
    //   3542: new 161	java/lang/StringBuilder
    //   3545: dup
    //   3546: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3549: ldc_w 845
    //   3552: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3555: aload_2
    //   3556: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3559: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3562: ldc_w 824
    //   3565: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3568: astore_2
    //   3569: aload_0
    //   3570: ifnull +25 -> 3595
    //   3573: aload_0
    //   3574: getfield 846	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3577: invokestatic 678	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3580: astore_0
    //   3581: aload_1
    //   3582: iconst_1
    //   3583: aload_2
    //   3584: aload_0
    //   3585: invokevirtual 644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3588: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3591: invokestatic 829	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3594: return
    //   3595: ldc 120
    //   3597: astore_0
    //   3598: goto -17 -> 3581
    //   3601: aload_2
    //   3602: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3605: sipush -2035
    //   3608: if_icmpne +20 -> 3628
    //   3611: aconst_null
    //   3612: aload_2
    //   3613: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3616: invokestatic 560	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3619: aconst_null
    //   3620: iconst_0
    //   3621: iconst_0
    //   3622: aload 4
    //   3624: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3627: return
    //   3628: aload_2
    //   3629: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3632: sipush -2038
    //   3635: if_icmpne +205 -> 3840
    //   3638: aload_2
    //   3639: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3642: astore_0
    //   3643: getstatic 851	anhk:aj	Ljava/lang/String;
    //   3646: aload_0
    //   3647: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3650: ifeq +4091 -> 7741
    //   3653: aload_2
    //   3654: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3657: astore_0
    //   3658: aload_0
    //   3659: astore 5
    //   3661: getstatic 854	anhk:H	Ljava/lang/String;
    //   3664: aload_0
    //   3665: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3668: ifeq +59 -> 3727
    //   3671: getstatic 851	anhk:aj	Ljava/lang/String;
    //   3674: aload_2
    //   3675: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3678: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3681: ifeq +103 -> 3784
    //   3684: aload_1
    //   3685: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3688: getstatic 851	anhk:aj	Ljava/lang/String;
    //   3691: aload_2
    //   3692: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3695: aload_2
    //   3696: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3699: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3702: checkcast 856	com/tencent/mobileqq/data/MessageForTroopGift
    //   3705: astore 16
    //   3707: aload_0
    //   3708: astore 5
    //   3710: aload 16
    //   3712: ifnull +15 -> 3727
    //   3715: aload 16
    //   3717: invokevirtual 857	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3720: aload 16
    //   3722: getfield 858	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3725: astore 5
    //   3727: aload_1
    //   3728: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3731: aload 5
    //   3733: aload_2
    //   3734: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3737: aload_2
    //   3738: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3741: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3744: astore_0
    //   3745: aload_0
    //   3746: instanceof 856
    //   3749: ifeq +50 -> 3799
    //   3752: aload_0
    //   3753: checkcast 856	com/tencent/mobileqq/data/MessageForTroopGift
    //   3756: astore_0
    //   3757: aload_0
    //   3758: invokevirtual 857	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3761: aload_0
    //   3762: getfield 859	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3765: ifnull +28 -> 3793
    //   3768: aload_0
    //   3769: getfield 859	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3772: astore_0
    //   3773: aconst_null
    //   3774: aload_0
    //   3775: aconst_null
    //   3776: iconst_0
    //   3777: iconst_0
    //   3778: aload 4
    //   3780: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3783: return
    //   3784: aload_2
    //   3785: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3788: astore 5
    //   3790: goto -63 -> 3727
    //   3793: ldc 120
    //   3795: astore_0
    //   3796: goto -23 -> 3773
    //   3799: aload_0
    //   3800: ifnull -3796 -> 4
    //   3803: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3806: ifeq -3802 -> 4
    //   3809: ldc_w 766
    //   3812: iconst_2
    //   3813: new 161	java/lang/StringBuilder
    //   3816: dup
    //   3817: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3820: ldc_w 861
    //   3823: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3826: aload_0
    //   3827: invokevirtual 827	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3830: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3833: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3836: invokestatic 829	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3839: return
    //   3840: aload_2
    //   3841: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3844: sipush -2036
    //   3847: if_icmpne +48 -> 3895
    //   3850: aload_1
    //   3851: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3854: aload_2
    //   3855: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3858: aload_2
    //   3859: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3862: aload_2
    //   3863: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3866: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3869: checkcast 863	com/tencent/mobileqq/data/MessageForTroopFee
    //   3872: astore_0
    //   3873: aload_0
    //   3874: ifnull -3870 -> 4
    //   3877: aload_0
    //   3878: invokevirtual 864	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3881: aconst_null
    //   3882: aload_0
    //   3883: getfield 865	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3886: aconst_null
    //   3887: iconst_0
    //   3888: iconst_0
    //   3889: aload 4
    //   3891: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3894: return
    //   3895: aload_2
    //   3896: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3899: sipush -2069
    //   3902: if_icmpne +48 -> 3950
    //   3905: aload_1
    //   3906: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3909: aload_2
    //   3910: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3913: aload_2
    //   3914: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3917: aload_2
    //   3918: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3921: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3924: checkcast 867	com/tencent/mobileqq/data/MessageForStarLeague
    //   3927: astore_0
    //   3928: aload_0
    //   3929: ifnull -3925 -> 4
    //   3932: aload_0
    //   3933: invokevirtual 868	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3936: aconst_null
    //   3937: aload_0
    //   3938: getfield 869	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3941: aconst_null
    //   3942: iconst_0
    //   3943: iconst_0
    //   3944: aload 4
    //   3946: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3949: return
    //   3950: aload_2
    //   3951: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3954: sipush -2048
    //   3957: if_icmpne +49 -> 4006
    //   3960: aload_1
    //   3961: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3964: aload_2
    //   3965: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3968: aload_2
    //   3969: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3972: aload_2
    //   3973: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3976: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3979: checkcast 871	com/tencent/mobileqq/data/MessageForTroopReward
    //   3982: astore_0
    //   3983: aload_0
    //   3984: ifnull -3980 -> 4
    //   3987: aload_0
    //   3988: invokevirtual 872	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3991: aload 19
    //   3993: aload_0
    //   3994: getfield 873	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3997: aconst_null
    //   3998: iconst_0
    //   3999: iconst_0
    //   4000: aload 4
    //   4002: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4005: return
    //   4006: aload_2
    //   4007: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4010: iconst_1
    //   4011: if_icmpne +85 -> 4096
    //   4014: aload_2
    //   4015: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4018: sipush -3006
    //   4021: if_icmpne +75 -> 4096
    //   4024: aload_1
    //   4025: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4028: aload_2
    //   4029: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4032: aload_2
    //   4033: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4036: aload_2
    //   4037: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4040: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4043: checkcast 875	com/tencent/mobileqq/data/MessageForPubAccount
    //   4046: astore_0
    //   4047: aload_0
    //   4048: ifnull -4044 -> 4
    //   4051: aload_0
    //   4052: invokevirtual 876	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   4055: aload_1
    //   4056: aload_0
    //   4057: iconst_0
    //   4058: invokestatic 880	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   4061: astore_2
    //   4062: aload_0
    //   4063: invokevirtual 883	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   4066: ifne +16 -> 4082
    //   4069: aconst_null
    //   4070: astore_0
    //   4071: aload_0
    //   4072: aload_2
    //   4073: aconst_null
    //   4074: iconst_0
    //   4075: iconst_0
    //   4076: aload 4
    //   4078: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4081: return
    //   4082: aload_1
    //   4083: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4086: ldc_w 884
    //   4089: invokevirtual 159	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4092: astore_0
    //   4093: goto -22 -> 4071
    //   4096: aload_2
    //   4097: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4100: sipush -1034
    //   4103: if_icmpne +106 -> 4209
    //   4106: new 886	com/tencent/mobileqq/data/MessageForRichState
    //   4109: dup
    //   4110: invokespecial 887	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   4113: astore_0
    //   4114: aload_0
    //   4115: aload_2
    //   4116: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4119: putfield 888	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   4122: aload_0
    //   4123: invokevirtual 889	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   4126: new 161	java/lang/StringBuilder
    //   4129: dup
    //   4130: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4133: astore_1
    //   4134: aload_0
    //   4135: getfield 892	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4138: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4141: ifne +38 -> 4179
    //   4144: aload_1
    //   4145: aload_0
    //   4146: getfield 892	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4149: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4152: pop
    //   4153: aload_0
    //   4154: getfield 895	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4157: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4160: ifne +12 -> 4172
    //   4163: aload_1
    //   4164: aload_0
    //   4165: getfield 895	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4168: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4171: pop
    //   4172: aload_1
    //   4173: bipush 32
    //   4175: invokevirtual 898	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   4178: pop
    //   4179: aload_1
    //   4180: aload_0
    //   4181: invokevirtual 901	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   4184: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4187: pop
    //   4188: aload_1
    //   4189: invokevirtual 902	java/lang/StringBuilder:length	()I
    //   4192: ifle -4188 -> 4
    //   4195: aconst_null
    //   4196: aload_1
    //   4197: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4200: aconst_null
    //   4201: iconst_0
    //   4202: iconst_0
    //   4203: aload 4
    //   4205: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4208: return
    //   4209: aload_2
    //   4210: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4213: sipush -2074
    //   4216: if_icmpne +47 -> 4263
    //   4219: new 904	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4222: dup
    //   4223: invokespecial 905	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4226: astore_0
    //   4227: aload_0
    //   4228: aload_2
    //   4229: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4232: putfield 906	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4235: aload_0
    //   4236: invokevirtual 907	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4239: aload_0
    //   4240: getfield 910	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4243: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4246: ifne -4242 -> 4
    //   4249: aconst_null
    //   4250: aload_0
    //   4251: getfield 910	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4254: aconst_null
    //   4255: iconst_0
    //   4256: iconst_0
    //   4257: aload 4
    //   4259: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4262: return
    //   4263: aload_2
    //   4264: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4267: sipush -1019
    //   4270: if_icmpne +48 -> 4318
    //   4273: aconst_null
    //   4274: aconst_null
    //   4275: new 161	java/lang/StringBuilder
    //   4278: dup
    //   4279: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4282: ldc_w 911
    //   4285: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   4288: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4291: aload_2
    //   4292: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4295: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4298: ldc_w 912
    //   4301: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   4304: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4307: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4310: iconst_0
    //   4311: iconst_0
    //   4312: aload 4
    //   4314: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4317: return
    //   4318: aload_2
    //   4319: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4322: sipush -1018
    //   4325: if_icmpne +48 -> 4373
    //   4328: aconst_null
    //   4329: aconst_null
    //   4330: new 161	java/lang/StringBuilder
    //   4333: dup
    //   4334: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4337: ldc_w 913
    //   4340: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   4343: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4346: aload_2
    //   4347: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4350: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4353: ldc_w 914
    //   4356: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   4359: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4362: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4365: iconst_0
    //   4366: iconst_0
    //   4367: aload 4
    //   4369: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4372: return
    //   4373: aload_2
    //   4374: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4377: sipush -2019
    //   4380: if_icmpne +16 -> 4396
    //   4383: aload 4
    //   4385: aload_0
    //   4386: ldc_w 915
    //   4389: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4392: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4395: return
    //   4396: aload_2
    //   4397: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4400: sipush -7006
    //   4403: if_icmpne +16 -> 4419
    //   4406: aload 4
    //   4408: aload_0
    //   4409: ldc_w 916
    //   4412: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4415: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4418: return
    //   4419: aload_2
    //   4420: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4423: sipush -1026
    //   4426: if_icmpne +16 -> 4442
    //   4429: aload 4
    //   4431: aload_0
    //   4432: ldc_w 917
    //   4435: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4438: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4441: return
    //   4442: aload_2
    //   4443: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4446: sipush -1027
    //   4449: if_icmpne +16 -> 4465
    //   4452: aload 4
    //   4454: aload_0
    //   4455: ldc_w 918
    //   4458: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4461: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4464: return
    //   4465: aload_2
    //   4466: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4469: sipush -2005
    //   4472: if_icmpne +56 -> 4528
    //   4475: aload_1
    //   4476: aload_2
    //   4477: invokestatic 921	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4480: astore 5
    //   4482: aload_1
    //   4483: aload_2
    //   4484: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4487: istore 6
    //   4489: aload_1
    //   4490: aload_2
    //   4491: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4494: istore 7
    //   4496: aload 19
    //   4498: aload_0
    //   4499: ldc_w 922
    //   4502: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4505: aconst_null
    //   4506: iload 6
    //   4508: iload 7
    //   4510: aload 4
    //   4512: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4515: aload 5
    //   4517: ifnull -4513 -> 4
    //   4520: aload 4
    //   4522: aload 5
    //   4524: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4527: return
    //   4528: aload_2
    //   4529: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4532: sipush -2022
    //   4535: if_icmpeq +13 -> 4548
    //   4538: aload_2
    //   4539: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4542: sipush -2071
    //   4545: if_icmpne +700 -> 5245
    //   4548: iconst_0
    //   4549: istore 7
    //   4551: iconst_0
    //   4552: istore 10
    //   4554: aload_1
    //   4555: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4558: aload_2
    //   4559: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4562: aload_2
    //   4563: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4566: aload_2
    //   4567: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4570: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4573: astore 5
    //   4575: aload 5
    //   4577: instanceof 924
    //   4580: ifeq -4576 -> 4
    //   4583: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4586: ifeq +33 -> 4619
    //   4589: ldc_w 448
    //   4592: iconst_2
    //   4593: new 161	java/lang/StringBuilder
    //   4596: dup
    //   4597: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4600: ldc_w 926
    //   4603: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4606: aload_2
    //   4607: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4610: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4613: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4616: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4619: aload 5
    //   4621: checkcast 924	com/tencent/mobileqq/data/MessageForShortVideo
    //   4624: astore 16
    //   4626: aload 16
    //   4628: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4631: sipush 1005
    //   4634: if_icmpeq +60 -> 4694
    //   4637: aload_2
    //   4638: getfield 930	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   4641: ldc_w 639
    //   4644: if_icmpeq +50 -> 4694
    //   4647: aload 16
    //   4649: getfield 933	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4652: ifne +14 -> 4666
    //   4655: aload 16
    //   4657: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4660: sipush 1004
    //   4663: if_icmpeq +31 -> 4694
    //   4666: iload 7
    //   4668: istore 6
    //   4670: aload 16
    //   4672: getfield 933	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4675: iconst_1
    //   4676: if_icmpne +37 -> 4713
    //   4679: iload 7
    //   4681: istore 6
    //   4683: aload 16
    //   4685: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4688: sipush 1004
    //   4691: if_icmpne +22 -> 4713
    //   4694: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4697: ifeq +13 -> 4710
    //   4700: ldc_w 448
    //   4703: iconst_2
    //   4704: ldc_w 935
    //   4707: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4710: iconst_1
    //   4711: istore 6
    //   4713: aload_2
    //   4714: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4717: astore 5
    //   4719: aload_2
    //   4720: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4723: aload_2
    //   4724: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4727: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   4730: ifeq +9 -> 4739
    //   4733: aload_2
    //   4734: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4737: astore 5
    //   4739: aload_1
    //   4740: invokevirtual 596	com/tencent/mobileqq/app/QQAppInterface:a	()Lbdzi;
    //   4743: aload 5
    //   4745: aload_2
    //   4746: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4749: invokevirtual 601	bdzi:a	(Ljava/lang/String;J)Lbguz;
    //   4752: astore_1
    //   4753: aload 16
    //   4755: getfield 938	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4758: ifnull +337 -> 5095
    //   4761: ldc 120
    //   4763: aload 16
    //   4765: getfield 938	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4768: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4771: ifne +324 -> 5095
    //   4774: aload_2
    //   4775: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4778: ifeq +317 -> 5095
    //   4781: aload_1
    //   4782: ifnonnull +313 -> 5095
    //   4785: aload 16
    //   4787: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4790: sipush 1003
    //   4793: if_icmpeq +302 -> 5095
    //   4796: aload 16
    //   4798: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4801: sipush 1004
    //   4804: if_icmpeq +291 -> 5095
    //   4807: aload 16
    //   4809: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4812: sipush 2003
    //   4815: if_icmpeq +280 -> 5095
    //   4818: aload 16
    //   4820: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4823: sipush 2009
    //   4826: if_icmpeq +269 -> 5095
    //   4829: aload 16
    //   4831: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4834: sipush 2002
    //   4837: if_icmpeq +258 -> 5095
    //   4840: aload 16
    //   4842: getfield 941	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   4845: iconst_1
    //   4846: if_icmpne +249 -> 5095
    //   4849: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4852: ifeq +13 -> 4865
    //   4855: ldc_w 448
    //   4858: iconst_2
    //   4859: ldc_w 943
    //   4862: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4865: iconst_1
    //   4866: istore 7
    //   4868: iload 7
    //   4870: istore 6
    //   4872: iload 10
    //   4874: istore 7
    //   4876: aload_2
    //   4877: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4880: ifeq +81 -> 4961
    //   4883: aload 16
    //   4885: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4888: sipush 1001
    //   4891: if_icmpeq +51 -> 4942
    //   4894: aload 16
    //   4896: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4899: sipush 1002
    //   4902: if_icmpeq +40 -> 4942
    //   4905: aload 16
    //   4907: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4910: sipush 998
    //   4913: if_icmpeq +29 -> 4942
    //   4916: aload 16
    //   4918: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4921: sipush 999
    //   4924: if_icmpeq +18 -> 4942
    //   4927: iload 10
    //   4929: istore 7
    //   4931: aload 16
    //   4933: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4936: sipush 1000
    //   4939: if_icmpne +22 -> 4961
    //   4942: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4945: ifeq +13 -> 4958
    //   4948: ldc_w 448
    //   4951: iconst_2
    //   4952: ldc_w 945
    //   4955: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4958: iconst_1
    //   4959: istore 7
    //   4961: aload 16
    //   4963: instanceof 947
    //   4966: ifeq +235 -> 5201
    //   4969: aload_0
    //   4970: ldc_w 948
    //   4973: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4976: astore_0
    //   4977: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4980: ifeq +101 -> 5081
    //   4983: ldc_w 448
    //   4986: iconst_2
    //   4987: new 161	java/lang/StringBuilder
    //   4990: dup
    //   4991: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4994: ldc_w 950
    //   4997: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5000: aload 16
    //   5002: getfield 938	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5005: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5008: ldc_w 952
    //   5011: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5014: aload 16
    //   5016: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5019: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5022: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5025: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5028: aload_1
    //   5029: ifnonnull +203 -> 5232
    //   5032: ldc_w 448
    //   5035: iconst_2
    //   5036: ldc_w 954
    //   5039: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5042: ldc_w 448
    //   5045: iconst_2
    //   5046: new 161	java/lang/StringBuilder
    //   5049: dup
    //   5050: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5053: ldc_w 956
    //   5056: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5059: iload 6
    //   5061: invokevirtual 959	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5064: ldc_w 961
    //   5067: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5070: iload 7
    //   5072: invokevirtual 959	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5075: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5078: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5081: aload 19
    //   5083: aload_0
    //   5084: aconst_null
    //   5085: iload 6
    //   5087: iload 7
    //   5089: aload 4
    //   5091: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5094: return
    //   5095: iload 6
    //   5097: istore 7
    //   5099: aload_2
    //   5100: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5103: ifeq -235 -> 4868
    //   5106: iload 6
    //   5108: istore 7
    //   5110: aload 16
    //   5112: instanceof 947
    //   5115: ifeq -247 -> 4868
    //   5118: iload 6
    //   5120: istore 7
    //   5122: aload 16
    //   5124: getfield 938	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5127: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5130: ifeq -262 -> 4868
    //   5133: iload 6
    //   5135: istore 7
    //   5137: aload_1
    //   5138: ifnonnull -270 -> 4868
    //   5141: aload 16
    //   5143: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5146: sipush 1004
    //   5149: if_icmpeq +18 -> 5167
    //   5152: iload 6
    //   5154: istore 7
    //   5156: aload 16
    //   5158: getfield 929	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5161: sipush 1001
    //   5164: if_icmpne -296 -> 4868
    //   5167: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5170: ifeq +13 -> 5183
    //   5173: ldc_w 448
    //   5176: iconst_2
    //   5177: ldc_w 963
    //   5180: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5183: iconst_1
    //   5184: istore 7
    //   5186: goto -318 -> 4868
    //   5189: astore 5
    //   5191: aconst_null
    //   5192: astore_1
    //   5193: aload 5
    //   5195: invokevirtual 473	java/lang/Exception:printStackTrace	()V
    //   5198: goto -326 -> 4872
    //   5201: aload 16
    //   5203: getfield 933	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   5206: iconst_2
    //   5207: if_icmpne +14 -> 5221
    //   5210: aload_0
    //   5211: ldc_w 964
    //   5214: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5217: astore_0
    //   5218: goto -241 -> 4977
    //   5221: aload_0
    //   5222: ldc_w 965
    //   5225: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5228: astore_0
    //   5229: goto -252 -> 4977
    //   5232: ldc_w 448
    //   5235: iconst_2
    //   5236: ldc_w 967
    //   5239: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5242: goto -200 -> 5042
    //   5245: aload_2
    //   5246: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5249: sipush -5002
    //   5252: if_icmpne +40 -> 5292
    //   5255: new 969	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5258: dup
    //   5259: invokespecial 970	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5262: astore_0
    //   5263: aload_0
    //   5264: aload_2
    //   5265: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5268: putfield 971	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5271: aload_0
    //   5272: invokevirtual 972	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5275: aload_0
    //   5276: getfield 973	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5279: ifnull -5275 -> 4
    //   5282: aload 4
    //   5284: aload_0
    //   5285: getfield 973	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5288: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5291: return
    //   5292: aload_2
    //   5293: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5296: sipush -2029
    //   5299: if_icmpne +145 -> 5444
    //   5302: aload_1
    //   5303: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5306: aload_2
    //   5307: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5310: aload_2
    //   5311: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5314: aload_2
    //   5315: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5318: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5321: astore_0
    //   5322: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5325: ifeq +30 -> 5355
    //   5328: ldc_w 448
    //   5331: iconst_2
    //   5332: new 161	java/lang/StringBuilder
    //   5335: dup
    //   5336: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5339: ldc_w 975
    //   5342: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5345: aload_0
    //   5346: invokevirtual 644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5349: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5352: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5355: aload_0
    //   5356: instanceof 977
    //   5359: ifeq -5355 -> 4
    //   5362: aload_0
    //   5363: checkcast 977	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5366: astore_0
    //   5367: aload_0
    //   5368: aload_2
    //   5369: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5372: putfield 978	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5375: aload_0
    //   5376: invokevirtual 979	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5379: aload_0
    //   5380: aload_1
    //   5381: aload_1
    //   5382: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5385: aconst_null
    //   5386: invokevirtual 983	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5389: aload_0
    //   5390: getfield 985	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5393: ifnull -5389 -> 4
    //   5396: aload_0
    //   5397: getfield 988	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5400: iconst_1
    //   5401: if_icmpne +33 -> 5434
    //   5404: aload_0
    //   5405: new 161	java/lang/StringBuilder
    //   5408: dup
    //   5409: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5412: ldc_w 989
    //   5415: invokestatic 375	anni:a	(I)Ljava/lang/String;
    //   5418: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: aload_0
    //   5422: getfield 985	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5425: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5428: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5431: putfield 985	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5434: aload 4
    //   5436: aload_0
    //   5437: getfield 985	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5440: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5443: return
    //   5444: aload_2
    //   5445: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5448: sipush -2025
    //   5451: if_icmpeq +13 -> 5464
    //   5454: aload_2
    //   5455: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5458: sipush -2072
    //   5461: if_icmpne +13 -> 5474
    //   5464: aload 4
    //   5466: aload_2
    //   5467: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5470: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5473: return
    //   5474: aload_2
    //   5475: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5478: sipush -2076
    //   5481: if_icmpne +58 -> 5539
    //   5484: new 991	com/tencent/mobileqq/data/MessageForLocationShare
    //   5487: dup
    //   5488: invokespecial 992	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5491: astore_1
    //   5492: aload_1
    //   5493: aload_2
    //   5494: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5497: putfield 993	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5500: aload_1
    //   5501: invokevirtual 994	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5504: aload_1
    //   5505: getfield 995	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5508: astore_2
    //   5509: aload_2
    //   5510: astore_1
    //   5511: aload_2
    //   5512: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5515: ifeq +11 -> 5526
    //   5518: aload_0
    //   5519: ldc_w 996
    //   5522: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5525: astore_1
    //   5526: aload 19
    //   5528: ldc 120
    //   5530: aload_1
    //   5531: iconst_0
    //   5532: iconst_0
    //   5533: aload 4
    //   5535: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5538: return
    //   5539: aload_2
    //   5540: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5543: sipush -2052
    //   5546: if_icmpne +75 -> 5621
    //   5549: aload_2
    //   5550: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5553: astore_0
    //   5554: aload_2
    //   5555: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5558: aload_2
    //   5559: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5562: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   5565: ifeq +8 -> 5573
    //   5568: aload_2
    //   5569: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5572: astore_0
    //   5573: aload_1
    //   5574: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5577: aload_0
    //   5578: aload_2
    //   5579: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5582: aload_2
    //   5583: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5586: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5589: astore_0
    //   5590: aload_0
    //   5591: instanceof 998
    //   5594: ifeq -5590 -> 4
    //   5597: aload_0
    //   5598: checkcast 998	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5601: astore_0
    //   5602: aload_0
    //   5603: invokevirtual 999	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5606: aload 19
    //   5608: aload_0
    //   5609: invokevirtual 1000	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5612: aconst_null
    //   5613: iconst_0
    //   5614: iconst_0
    //   5615: aload 4
    //   5617: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5620: return
    //   5621: aload_2
    //   5622: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5625: sipush -2047
    //   5628: if_icmpne +51 -> 5679
    //   5631: new 1002	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5634: dup
    //   5635: invokespecial 1003	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5638: astore_0
    //   5639: aload_0
    //   5640: aload_2
    //   5641: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5644: putfield 1004	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5647: aload_0
    //   5648: invokevirtual 1005	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5651: aload_0
    //   5652: invokevirtual 1006	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5655: astore_0
    //   5656: aload_0
    //   5657: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5660: ifne +10 -> 5670
    //   5663: aload 4
    //   5665: aload_0
    //   5666: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5669: return
    //   5670: aload 4
    //   5672: ldc_w 1008
    //   5675: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5678: return
    //   5679: aload_2
    //   5680: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5683: sipush -2040
    //   5686: if_icmpne +29 -> 5715
    //   5689: new 1010	com/tencent/mobileqq/data/MessageForApproval
    //   5692: dup
    //   5693: invokespecial 1011	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5696: astore_0
    //   5697: aload_0
    //   5698: aload_2
    //   5699: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5702: putfield 1012	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5705: aload 4
    //   5707: aload_0
    //   5708: invokevirtual 1015	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5711: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5714: return
    //   5715: aload_2
    //   5716: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5719: sipush -2041
    //   5722: if_icmpne +49 -> 5771
    //   5725: aload_0
    //   5726: ldc_w 1016
    //   5729: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5732: astore_1
    //   5733: aload_0
    //   5734: ldc_w 1017
    //   5737: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5740: astore_0
    //   5741: aload 4
    //   5743: new 161	java/lang/StringBuilder
    //   5746: dup
    //   5747: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5750: aload_1
    //   5751: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5754: ldc_w 484
    //   5757: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5760: aload_0
    //   5761: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5764: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5767: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5770: return
    //   5771: aload_2
    //   5772: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5775: sipush -7001
    //   5778: if_icmpne +157 -> 5935
    //   5781: aload_2
    //   5782: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5785: astore 5
    //   5787: aload_2
    //   5788: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5791: aload_2
    //   5792: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5795: invokestatic 593	acwh:b	(Ljava/lang/String;I)Z
    //   5798: ifeq +9 -> 5807
    //   5801: aload_2
    //   5802: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5805: astore 5
    //   5807: aload_1
    //   5808: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5811: aload 5
    //   5813: aload_2
    //   5814: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5817: aload_2
    //   5818: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5821: invokevirtual 519	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5824: checkcast 1019	com/tencent/mobileqq/data/MessageForScribble
    //   5827: astore_1
    //   5828: aload_1
    //   5829: invokevirtual 1020	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5832: ifeq +56 -> 5888
    //   5835: aload_1
    //   5836: getfield 1023	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5839: istore_3
    //   5840: iload_3
    //   5841: iconst_2
    //   5842: if_icmpne +29 -> 5871
    //   5845: iconst_1
    //   5846: istore 7
    //   5848: iconst_0
    //   5849: istore 6
    //   5851: aload 19
    //   5853: aload_0
    //   5854: ldc_w 1024
    //   5857: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5860: aconst_null
    //   5861: iload 7
    //   5863: iload 6
    //   5865: aload 4
    //   5867: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5870: return
    //   5871: aload_1
    //   5872: getfield 1023	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5875: iconst_3
    //   5876: if_icmpne +1856 -> 7732
    //   5879: iconst_1
    //   5880: istore 6
    //   5882: iconst_0
    //   5883: istore 7
    //   5885: goto -34 -> 5851
    //   5888: aload_1
    //   5889: getfield 1027	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5892: iconst_2
    //   5893: if_icmpne +1839 -> 7732
    //   5896: aload_1
    //   5897: invokestatic 1032	bbet:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5900: istore_3
    //   5901: getstatic 1034	bbet:c	I
    //   5904: istore 8
    //   5906: iload_3
    //   5907: iload 8
    //   5909: if_icmpeq +1823 -> 7732
    //   5912: iconst_1
    //   5913: istore 7
    //   5915: iconst_0
    //   5916: istore 6
    //   5918: goto -67 -> 5851
    //   5921: astore_1
    //   5922: aload_1
    //   5923: invokevirtual 473	java/lang/Exception:printStackTrace	()V
    //   5926: iconst_0
    //   5927: istore 6
    //   5929: iconst_0
    //   5930: istore 7
    //   5932: goto -81 -> 5851
    //   5935: aload_1
    //   5936: aload_2
    //   5937: invokestatic 1037	axbb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   5940: ifeq +18 -> 5958
    //   5943: aload 19
    //   5945: aload_2
    //   5946: invokevirtual 1041	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5949: aconst_null
    //   5950: iconst_0
    //   5951: iconst_0
    //   5952: aload 4
    //   5954: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5957: return
    //   5958: aload_2
    //   5959: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5962: ifnonnull +11 -> 5973
    //   5965: aload 4
    //   5967: ldc 120
    //   5969: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5972: return
    //   5973: aload_2
    //   5974: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5977: sipush -5003
    //   5980: if_icmpne +13 -> 5993
    //   5983: aload 4
    //   5985: aload_2
    //   5986: invokevirtual 1041	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5989: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5992: return
    //   5993: aload_2
    //   5994: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5997: sipush -2033
    //   6000: if_icmpne +16 -> 6016
    //   6003: aconst_null
    //   6004: getstatic 1046	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   6007: aconst_null
    //   6008: iconst_0
    //   6009: iconst_0
    //   6010: aload 4
    //   6012: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6015: return
    //   6016: aload_2
    //   6017: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6020: sipush -2049
    //   6023: if_icmpne +16 -> 6039
    //   6026: aload 4
    //   6028: aload_2
    //   6029: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6032: invokestatic 560	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6035: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6038: return
    //   6039: aload_2
    //   6040: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6043: sipush -1035
    //   6046: if_icmpne +287 -> 6333
    //   6049: iconst_0
    //   6050: istore 10
    //   6052: iconst_0
    //   6053: istore 11
    //   6055: iload 10
    //   6057: istore 6
    //   6059: iload 11
    //   6061: istore 7
    //   6063: aload_2
    //   6064: invokevirtual 534	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   6067: ifeq +31 -> 6098
    //   6070: aload_2
    //   6071: getfield 930	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6074: ldc_w 1047
    //   6077: if_icmpne +171 -> 6248
    //   6080: aload_1
    //   6081: invokevirtual 1050	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   6084: aload_2
    //   6085: invokevirtual 1053	bbyp:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6088: ifne +150 -> 6238
    //   6091: iconst_1
    //   6092: istore 6
    //   6094: iload 11
    //   6096: istore 7
    //   6098: aload_2
    //   6099: invokevirtual 1041	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6102: astore_0
    //   6103: aload_2
    //   6104: invokestatic 1056	bftx:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6107: ifeq +1622 -> 7729
    //   6110: aload_2
    //   6111: invokestatic 1058	bftx:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6114: ifne +7 -> 6121
    //   6117: aload_2
    //   6118: invokestatic 1061	bftx:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6121: aload_2
    //   6122: invokestatic 1064	bftx:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6125: astore_1
    //   6126: aload_1
    //   6127: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6130: ifne +1599 -> 7729
    //   6133: aload_1
    //   6134: astore_0
    //   6135: aload_2
    //   6136: getfield 1067	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6139: ifnull +177 -> 6316
    //   6142: aload_0
    //   6143: ifnull +173 -> 6316
    //   6146: new 161	java/lang/StringBuilder
    //   6149: dup
    //   6150: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   6153: astore_1
    //   6154: aload 19
    //   6156: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6159: ifne +16 -> 6175
    //   6162: aload_1
    //   6163: aload 19
    //   6165: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6168: ldc_w 380
    //   6171: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6174: pop
    //   6175: aload_2
    //   6176: invokestatic 509	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6179: ifne +16 -> 6195
    //   6182: iload 6
    //   6184: ifeq +89 -> 6273
    //   6187: aload_1
    //   6188: ldc_w 756
    //   6191: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6194: pop
    //   6195: aload_0
    //   6196: instanceof 758
    //   6199: ifeq +90 -> 6289
    //   6202: aload_0
    //   6203: checkcast 758	bdnt
    //   6206: aload_1
    //   6207: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6210: iconst_1
    //   6211: iconst_0
    //   6212: newarray int
    //   6214: invokevirtual 761	bdnt:a	(Ljava/lang/String;Z[I)Lbdnt;
    //   6217: astore_0
    //   6218: aload 4
    //   6220: iconst_1
    //   6221: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6224: aload 19
    //   6226: aload_0
    //   6227: aconst_null
    //   6228: iload 6
    //   6230: iload 7
    //   6232: aload 4
    //   6234: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6237: return
    //   6238: iconst_1
    //   6239: istore 7
    //   6241: iload 10
    //   6243: istore 6
    //   6245: goto -147 -> 6098
    //   6248: iconst_0
    //   6249: istore 7
    //   6251: aload_2
    //   6252: getfield 930	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6255: ldc_w 639
    //   6258: if_icmpne +9 -> 6267
    //   6261: iconst_1
    //   6262: istore 6
    //   6264: goto -166 -> 6098
    //   6267: iconst_0
    //   6268: istore 6
    //   6270: goto -6 -> 6264
    //   6273: iload 7
    //   6275: ifeq -80 -> 6195
    //   6278: aload_1
    //   6279: ldc_w 764
    //   6282: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6285: pop
    //   6286: goto -91 -> 6195
    //   6289: aload_1
    //   6290: aload_0
    //   6291: invokevirtual 1070	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6294: pop
    //   6295: new 1072	android/text/SpannableString
    //   6298: dup
    //   6299: aload_1
    //   6300: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6303: invokespecial 1075	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6306: astore_0
    //   6307: aload 4
    //   6309: iconst_0
    //   6310: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6313: goto -89 -> 6224
    //   6316: aload 19
    //   6318: aload_0
    //   6319: invokestatic 1078	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6322: aconst_null
    //   6323: iload 6
    //   6325: iload 7
    //   6327: aload 4
    //   6329: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6332: return
    //   6333: aload_2
    //   6334: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6337: sipush -2057
    //   6340: if_icmpne +17 -> 6357
    //   6343: aload 19
    //   6345: getstatic 1083	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6348: aconst_null
    //   6349: iconst_0
    //   6350: iconst_0
    //   6351: aload 4
    //   6353: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6356: return
    //   6357: aload_2
    //   6358: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6361: sipush -1012
    //   6364: if_icmpne +70 -> 6434
    //   6367: aload_2
    //   6368: invokevirtual 1041	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6371: invokeinterface 1086 1 0
    //   6376: invokestatic 560	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6379: astore_1
    //   6380: aload_0
    //   6381: ldc_w 1087
    //   6384: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6387: astore_2
    //   6388: aload_1
    //   6389: invokevirtual 205	java/lang/String:length	()I
    //   6392: aload_2
    //   6393: invokevirtual 205	java/lang/String:length	()I
    //   6396: isub
    //   6397: iconst_1
    //   6398: isub
    //   6399: istore_3
    //   6400: aload_1
    //   6401: astore_0
    //   6402: aload_1
    //   6403: aload_2
    //   6404: invokevirtual 124	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6407: ifeq +16 -> 6423
    //   6410: aload_1
    //   6411: astore_0
    //   6412: iload_3
    //   6413: ifle +10 -> 6423
    //   6416: aload_1
    //   6417: iconst_0
    //   6418: iload_3
    //   6419: invokevirtual 304	java/lang/String:substring	(II)Ljava/lang/String;
    //   6422: astore_0
    //   6423: aconst_null
    //   6424: aload_0
    //   6425: aconst_null
    //   6426: iconst_0
    //   6427: iconst_0
    //   6428: aload 4
    //   6430: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6433: return
    //   6434: aload_2
    //   6435: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6438: sipush -2059
    //   6441: if_icmpne +33 -> 6474
    //   6444: new 1089	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6447: dup
    //   6448: invokespecial 1090	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6451: astore_0
    //   6452: aload_0
    //   6453: aload_2
    //   6454: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6457: putfield 1091	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6460: aload_0
    //   6461: invokevirtual 1094	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6464: aload 4
    //   6466: aload_0
    //   6467: invokevirtual 1095	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6470: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6473: return
    //   6474: aload_2
    //   6475: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6478: sipush -2066
    //   6481: if_icmpne +87 -> 6568
    //   6484: new 1097	com/tencent/mobileqq/data/MessageForConfessCard
    //   6487: dup
    //   6488: invokespecial 1098	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6491: astore_0
    //   6492: aload_0
    //   6493: aload_2
    //   6494: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6497: putfield 1099	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6500: aload_0
    //   6501: invokevirtual 1100	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6504: aload_2
    //   6505: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6508: sipush 1032
    //   6511: if_icmpne +18 -> 6529
    //   6514: aload 19
    //   6516: aload_0
    //   6517: getfield 1103	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6520: aconst_null
    //   6521: iconst_0
    //   6522: iconst_0
    //   6523: aload 4
    //   6525: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6528: return
    //   6529: ldc 120
    //   6531: new 161	java/lang/StringBuilder
    //   6534: dup
    //   6535: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   6538: aload 19
    //   6540: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6543: ldc_w 1105
    //   6546: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6549: aload_0
    //   6550: getfield 1103	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6553: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6556: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6559: aconst_null
    //   6560: iconst_0
    //   6561: iconst_0
    //   6562: aload 4
    //   6564: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6567: return
    //   6568: aload_2
    //   6569: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6572: sipush -2067
    //   6575: if_icmpne +38 -> 6613
    //   6578: new 1107	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6581: dup
    //   6582: invokespecial 1108	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6585: astore_0
    //   6586: aload_0
    //   6587: aload_2
    //   6588: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6591: putfield 1109	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6594: aload_0
    //   6595: invokevirtual 1110	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6598: aload 19
    //   6600: aload_0
    //   6601: getfield 1111	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6604: aconst_null
    //   6605: iconst_0
    //   6606: iconst_0
    //   6607: aload 4
    //   6609: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6612: return
    //   6613: aload_2
    //   6614: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6617: sipush -5008
    //   6620: if_icmpeq +23 -> 6643
    //   6623: aload_2
    //   6624: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6627: sipush -5016
    //   6630: if_icmpeq +13 -> 6643
    //   6633: aload_2
    //   6634: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6637: sipush -5017
    //   6640: if_icmpne +113 -> 6753
    //   6643: aload_2
    //   6644: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6647: sipush -5016
    //   6650: if_icmpne +64 -> 6714
    //   6653: new 1113	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6656: dup
    //   6657: invokespecial 1114	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6660: astore_0
    //   6661: aload_0
    //   6662: aload_2
    //   6663: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6666: putfield 1115	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6669: aload_0
    //   6670: invokevirtual 1116	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6673: aload 4
    //   6675: aload_0
    //   6676: invokevirtual 1119	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6679: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6682: aload_1
    //   6683: aload_2
    //   6684: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6687: istore 6
    //   6689: aload_1
    //   6690: aload_2
    //   6691: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6694: istore 7
    //   6696: aload 19
    //   6698: aload 4
    //   6700: getfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6703: aconst_null
    //   6704: iload 6
    //   6706: iload 7
    //   6708: aload 4
    //   6710: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6713: return
    //   6714: new 1121	com/tencent/mobileqq/data/MessageForArkApp
    //   6717: dup
    //   6718: invokespecial 1122	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6721: astore_0
    //   6722: aload_0
    //   6723: aload_2
    //   6724: getfield 743	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6727: putfield 1123	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6730: aload_0
    //   6731: invokevirtual 1124	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6734: aload 4
    //   6736: aload_0
    //   6737: invokevirtual 1125	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6740: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6743: aload_2
    //   6744: aload 4
    //   6746: aload_1
    //   6747: invokestatic 1128	bgnr:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   6750: goto -68 -> 6682
    //   6753: aload_1
    //   6754: aload_2
    //   6755: invokestatic 588	bgnr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6758: istore 6
    //   6760: aload_1
    //   6761: aload_2
    //   6762: invokestatic 590	bgnr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6765: istore 7
    //   6767: aload_2
    //   6768: getfield 1131	com/tencent/imcore/message/QQMessageFacade$Message:fileType	I
    //   6771: lookupswitch	default:+49->6820, 1:+172->6943, 2:+253->7024, 8:+253->7024, 65536:+154->6925, 65538:+235->7006
    //   6821: ldc_w 712
    //   6824: invokevirtual 715	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6827: astore 5
    //   6829: getstatic 720	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   6832: ifeq +295 -> 7127
    //   6835: aload 5
    //   6837: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6840: ifne +287 -> 7127
    //   6843: aload_1
    //   6844: aload_2
    //   6845: aload 4
    //   6847: invokestatic 754	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lbdnt;
    //   6850: astore_0
    //   6851: new 161	java/lang/StringBuilder
    //   6854: dup
    //   6855: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   6858: astore_1
    //   6859: aload 19
    //   6861: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6864: ifne +16 -> 6880
    //   6867: aload_1
    //   6868: aload 19
    //   6870: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6873: ldc_w 380
    //   6876: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6879: pop
    //   6880: aload_2
    //   6881: invokestatic 509	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6884: ifne +16 -> 6900
    //   6887: iload 6
    //   6889: ifeq +222 -> 7111
    //   6892: aload_1
    //   6893: ldc_w 756
    //   6896: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6899: pop
    //   6900: aload 19
    //   6902: aload_0
    //   6903: aload_1
    //   6904: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6907: iconst_1
    //   6908: iconst_0
    //   6909: newarray int
    //   6911: invokevirtual 761	bdnt:a	(Ljava/lang/String;Z[I)Lbdnt;
    //   6914: aconst_null
    //   6915: iload 6
    //   6917: iload 7
    //   6919: aload 4
    //   6921: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6924: return
    //   6925: aload 19
    //   6927: ldc 120
    //   6929: aload_2
    //   6930: getfield 555	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6933: iload 6
    //   6935: iload 7
    //   6937: aload 4
    //   6939: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6942: return
    //   6943: aload_2
    //   6944: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6947: sipush 1001
    //   6950: if_icmpeq +13 -> 6963
    //   6953: aload_2
    //   6954: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6957: sipush 10002
    //   6960: if_icmpne +26 -> 6986
    //   6963: aload_2
    //   6964: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6967: sipush -3001
    //   6970: if_icmpne +16 -> 6986
    //   6973: aload 4
    //   6975: aload_0
    //   6976: ldc_w 1132
    //   6979: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6982: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6985: return
    //   6986: aload 19
    //   6988: aload_0
    //   6989: ldc_w 625
    //   6992: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6995: aconst_null
    //   6996: iload 6
    //   6998: iload 7
    //   7000: aload 4
    //   7002: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7005: return
    //   7006: aload 19
    //   7008: aload_0
    //   7009: ldc_w 625
    //   7012: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   7015: aconst_null
    //   7016: iconst_0
    //   7017: iconst_0
    //   7018: aload 4
    //   7020: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7023: return
    //   7024: ldc_w 655
    //   7027: iconst_3
    //   7028: anewarray 4	java/lang/Object
    //   7031: dup
    //   7032: iconst_0
    //   7033: iload_3
    //   7034: invokestatic 678	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7037: aastore
    //   7038: dup
    //   7039: iconst_1
    //   7040: iload 6
    //   7042: invokestatic 658	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7045: aastore
    //   7046: dup
    //   7047: iconst_2
    //   7048: iload 7
    //   7050: invokestatic 658	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7053: aastore
    //   7054: invokestatic 663	arkw:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7057: aload_0
    //   7058: ldc_w 645
    //   7061: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   7064: astore_0
    //   7065: aload_2
    //   7066: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   7069: aload_1
    //   7070: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7073: invokestatic 1135	bgjw:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7076: ifeq +22 -> 7098
    //   7079: iload_3
    //   7080: ifeq +18 -> 7098
    //   7083: aload 19
    //   7085: aload_0
    //   7086: ldc 120
    //   7088: iload 6
    //   7090: iload 7
    //   7092: aload 4
    //   7094: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7097: return
    //   7098: aload 19
    //   7100: aload_0
    //   7101: ldc 120
    //   7103: iconst_0
    //   7104: iconst_0
    //   7105: aload 4
    //   7107: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7110: return
    //   7111: iload 7
    //   7113: ifeq -213 -> 6900
    //   7116: aload_1
    //   7117: ldc_w 764
    //   7120: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7123: pop
    //   7124: goto -224 -> 6900
    //   7127: aload_2
    //   7128: invokevirtual 1041	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   7131: astore 5
    //   7133: aload_2
    //   7134: invokestatic 1056	bftx:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7137: ifeq +589 -> 7726
    //   7140: aload_2
    //   7141: invokestatic 1058	bftx:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7144: ifne +7 -> 7151
    //   7147: aload_2
    //   7148: invokestatic 1061	bftx:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   7151: aload_2
    //   7152: invokestatic 1064	bftx:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   7155: astore 16
    //   7157: aload 16
    //   7159: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7162: ifne +564 -> 7726
    //   7165: aload 16
    //   7167: astore 5
    //   7169: aload_2
    //   7170: getfield 1067	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   7173: ifnull +389 -> 7562
    //   7176: aload 5
    //   7178: ifnull +384 -> 7562
    //   7181: new 161	java/lang/StringBuilder
    //   7184: dup
    //   7185: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   7188: astore_0
    //   7189: aload 19
    //   7191: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7194: ifne +16 -> 7210
    //   7197: aload_0
    //   7198: aload 19
    //   7200: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7203: ldc_w 380
    //   7206: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7209: pop
    //   7210: aload_2
    //   7211: invokestatic 509	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7214: ifne +16 -> 7230
    //   7217: iload 6
    //   7219: ifeq +299 -> 7518
    //   7222: aload_0
    //   7223: ldc_w 756
    //   7226: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7229: pop
    //   7230: aload 5
    //   7232: instanceof 758
    //   7235: ifeq +299 -> 7534
    //   7238: aload 5
    //   7240: checkcast 758	bdnt
    //   7243: aload_0
    //   7244: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7247: iconst_1
    //   7248: iconst_3
    //   7249: newarray int
    //   7251: dup
    //   7252: iconst_0
    //   7253: aload 5
    //   7255: checkcast 758	bdnt
    //   7258: getfield 1136	bdnt:jdField_a_of_type_Int	I
    //   7261: iastore
    //   7262: dup
    //   7263: iconst_1
    //   7264: bipush 16
    //   7266: iastore
    //   7267: dup
    //   7268: iconst_2
    //   7269: iconst_1
    //   7270: iastore
    //   7271: invokevirtual 761	bdnt:a	(Ljava/lang/String;Z[I)Lbdnt;
    //   7274: astore_0
    //   7275: aload 4
    //   7277: iconst_1
    //   7278: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7281: aload_2
    //   7282: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7285: sipush -5040
    //   7288: if_icmpne +435 -> 7723
    //   7291: new 161	java/lang/StringBuilder
    //   7294: dup
    //   7295: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   7298: ldc_w 484
    //   7301: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7304: invokestatic 365	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7307: ldc_w 1137
    //   7310: invokevirtual 367	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7313: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7316: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7319: astore 5
    //   7321: aload_0
    //   7322: invokeinterface 1086 1 0
    //   7327: astore 16
    //   7329: aload 16
    //   7331: ifnull +386 -> 7717
    //   7334: aload 16
    //   7336: aload 5
    //   7338: invokevirtual 1140	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7341: ifeq +376 -> 7717
    //   7344: aload 16
    //   7346: aload 5
    //   7348: ldc 120
    //   7350: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7353: astore 5
    //   7355: aload 5
    //   7357: astore_0
    //   7358: iload_3
    //   7359: ifne +77 -> 7436
    //   7362: aload_1
    //   7363: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7366: aload_2
    //   7367: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7370: iconst_0
    //   7371: invokevirtual 1143	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7374: astore 16
    //   7376: aload 5
    //   7378: astore_0
    //   7379: aload 16
    //   7381: instanceof 1145
    //   7384: ifeq +52 -> 7436
    //   7387: aload 5
    //   7389: astore_0
    //   7390: aload 16
    //   7392: checkcast 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7395: getfield 1149	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lauxc;
    //   7398: ifnull +38 -> 7436
    //   7401: aload 5
    //   7403: astore_0
    //   7404: aload 16
    //   7406: checkcast 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7409: getfield 1149	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lauxc;
    //   7412: getfield 1153	auxc:b	I
    //   7415: invokestatic 1156	awzy:b	(I)Z
    //   7418: ifeq +18 -> 7436
    //   7421: aload_1
    //   7422: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7425: aload 5
    //   7427: invokeinterface 1086 1 0
    //   7432: invokestatic 1159	axbb:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7435: astore_0
    //   7436: aload_2
    //   7437: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7440: invokestatic 1162	acwh:j	(I)Z
    //   7443: ifeq +271 -> 7714
    //   7446: aload_1
    //   7447: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7450: aload_2
    //   7451: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7454: iload_3
    //   7455: invokevirtual 1143	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7458: astore_1
    //   7459: aload_1
    //   7460: ifnull +254 -> 7714
    //   7463: aload_1
    //   7464: instanceof 1145
    //   7467: ifeq +247 -> 7714
    //   7470: aload_1
    //   7471: checkcast 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7474: getfield 1149	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lauxc;
    //   7477: ifnull +237 -> 7714
    //   7480: aload_1
    //   7481: checkcast 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7484: getfield 1149	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lauxc;
    //   7487: getfield 1153	auxc:b	I
    //   7490: ldc_w 1163
    //   7493: if_icmpne +221 -> 7714
    //   7496: aload_1
    //   7497: checkcast 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7500: invokevirtual 1164	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7503: astore_0
    //   7504: aload 19
    //   7506: aload_0
    //   7507: aconst_null
    //   7508: iload 6
    //   7510: iload 7
    //   7512: aload 4
    //   7514: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7517: return
    //   7518: iload 7
    //   7520: ifeq -290 -> 7230
    //   7523: aload_0
    //   7524: ldc_w 764
    //   7527: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7530: pop
    //   7531: goto -301 -> 7230
    //   7534: aload_0
    //   7535: aload 5
    //   7537: invokevirtual 1070	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7540: pop
    //   7541: new 1072	android/text/SpannableString
    //   7544: dup
    //   7545: aload_0
    //   7546: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7549: invokespecial 1075	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7552: astore_0
    //   7553: aload 4
    //   7555: iconst_0
    //   7556: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7559: goto -278 -> 7281
    //   7562: aload 5
    //   7564: ifnull +114 -> 7678
    //   7567: aload 5
    //   7569: invokeinterface 1086 1 0
    //   7574: invokevirtual 189	java/lang/String:trim	()Ljava/lang/String;
    //   7577: astore 5
    //   7579: getstatic 1167	anhk:G	Ljava/lang/String;
    //   7582: aload_2
    //   7583: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7586: invokevirtual 1170	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7589: ifeq +119 -> 7708
    //   7592: aload 5
    //   7594: ifnull +114 -> 7708
    //   7597: aload 5
    //   7599: invokevirtual 205	java/lang/String:length	()I
    //   7602: ifle +106 -> 7708
    //   7605: aload_0
    //   7606: aload_1
    //   7607: aload 5
    //   7609: aload_2
    //   7610: invokestatic 1172	bgnr:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   7613: astore_0
    //   7614: aload 19
    //   7616: aconst_null
    //   7617: aload_0
    //   7618: iload 6
    //   7620: aload_1
    //   7621: invokevirtual 1050	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   7624: aload_2
    //   7625: invokevirtual 1053	bbyp:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7628: aload 4
    //   7630: invokestatic 582	bgnr:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7633: aload_2
    //   7634: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7637: sipush -1000
    //   7640: if_icmpne +44 -> 7684
    //   7643: aload 4
    //   7645: getfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7648: ifnull +36 -> 7684
    //   7651: aload 4
    //   7653: new 758	bdnt
    //   7656: dup
    //   7657: aload 4
    //   7659: getfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7662: iconst_1
    //   7663: bipush 16
    //   7665: invokespecial 1175	bdnt:<init>	(Ljava/lang/CharSequence;II)V
    //   7668: putfield 566	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7671: aload 4
    //   7673: iconst_1
    //   7674: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7677: return
    //   7678: aconst_null
    //   7679: astore 5
    //   7681: goto -102 -> 7579
    //   7684: aload 4
    //   7686: iconst_0
    //   7687: putfield 775	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7690: return
    //   7691: astore 5
    //   7693: goto -2500 -> 5193
    //   7696: astore 17
    //   7698: aload 16
    //   7700: astore_1
    //   7701: aload 17
    //   7703: astore 16
    //   7705: goto -6906 -> 799
    //   7708: aload 5
    //   7710: astore_0
    //   7711: goto -97 -> 7614
    //   7714: goto -210 -> 7504
    //   7717: aload_0
    //   7718: astore 5
    //   7720: goto -365 -> 7355
    //   7723: goto -287 -> 7436
    //   7726: goto -557 -> 7169
    //   7729: goto -1594 -> 6135
    //   7732: iconst_0
    //   7733: istore 6
    //   7735: iconst_0
    //   7736: istore 7
    //   7738: goto -1887 -> 5851
    //   7741: goto -4083 -> 3658
    //   7744: iconst_0
    //   7745: istore 6
    //   7747: goto -5315 -> 2432
    //   7750: goto -5401 -> 2349
    //   7753: aload 5
    //   7755: astore_0
    //   7756: goto -5733 -> 2023
    //   7759: iconst_0
    //   7760: istore 7
    //   7762: goto -6754 -> 1008
    //   7765: goto -6840 -> 925
    //   7768: aload_1
    //   7769: astore_0
    //   7770: goto -7064 -> 706
    //   7773: iconst_0
    //   7774: istore 6
    //   7776: goto -7191 -> 585
    //   7779: iconst_0
    //   7780: istore 6
    //   7782: goto -7236 -> 546
    //   7785: goto -7318 -> 467
    //   7788: aload 16
    //   7790: astore 5
    //   7792: goto -7656 -> 136
    //   7795: iconst_0
    //   7796: istore 6
    //   7798: goto -7252 -> 546
    //   7801: iconst_1
    //   7802: istore_3
    //   7803: goto -5894 -> 1909
    //   7806: astore_1
    //   7807: aload 17
    //   7809: astore_0
    //   7810: goto -5701 -> 2109
    //   7813: iconst_0
    //   7814: istore 6
    //   7816: goto -5384 -> 2432
    //   7819: ldc2_w 39
    //   7822: lstore 14
    //   7824: goto -5312 -> 2512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7827	0	paramContext	Context
    //   0	7827	1	paramQQAppInterface	QQAppInterface
    //   0	7827	2	paramMessage	QQMessageFacade.Message
    //   0	7827	3	paramInt	int
    //   0	7827	4	paramMsgSummary	MsgSummary
    //   0	7827	5	paramString	String
    //   0	7827	6	paramBoolean1	boolean
    //   0	7827	7	paramBoolean2	boolean
    //   258	5652	8	i	int
    //   1778	522	9	j	int
    //   433	5809	10	bool1	boolean
    //   2303	3792	11	bool2	boolean
    //   1718	543	12	bool3	boolean
    //   1725	546	13	bool4	boolean
    //   530	7293	14	l	long
    //   25	704	16	localObject1	Object
    //   795	5	16	localException1	Exception
    //   806	6983	16	localObject2	Object
    //   445	2296	17	localObject3	Object
    //   7696	112	17	localException2	Exception
    //   436	1940	18	str1	String
    //   220	7395	19	str2	String
    //   2373	256	20	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   441	467	795	java/lang/Exception
    //   467	489	795	java/lang/Exception
    //   1956	1985	2108	java/lang/Exception
    //   1985	1992	2108	java/lang/Exception
    //   1997	2005	2108	java/lang/Exception
    //   2005	2021	2108	java/lang/Exception
    //   2097	2105	2108	java/lang/Exception
    //   2315	2321	2695	java/lang/Exception
    //   2325	2339	2695	java/lang/Exception
    //   2343	2349	2695	java/lang/Exception
    //   2353	2375	2695	java/lang/Exception
    //   2379	2393	2695	java/lang/Exception
    //   2396	2403	2695	java/lang/Exception
    //   2406	2413	2695	java/lang/Exception
    //   2628	2639	2695	java/lang/Exception
    //   2652	2659	2695	java/lang/Exception
    //   2662	2671	2695	java/lang/Exception
    //   2850	2885	2986	java/lang/Throwable
    //   2901	2951	2986	java/lang/Throwable
    //   2956	2981	2986	java/lang/Throwable
    //   4713	4719	5189	java/lang/Exception
    //   4719	4739	5189	java/lang/Exception
    //   4739	4753	5189	java/lang/Exception
    //   5781	5787	5921	java/lang/Exception
    //   5787	5807	5921	java/lang/Exception
    //   5807	5840	5921	java/lang/Exception
    //   5871	5879	5921	java/lang/Exception
    //   5888	5906	5921	java/lang/Exception
    //   4753	4781	7691	java/lang/Exception
    //   4785	4865	7691	java/lang/Exception
    //   5099	5106	7691	java/lang/Exception
    //   5110	5118	7691	java/lang/Exception
    //   5122	5133	7691	java/lang/Exception
    //   5141	5152	7691	java/lang/Exception
    //   5156	5167	7691	java/lang/Exception
    //   5167	5183	7691	java/lang/Exception
    //   493	507	7696	java/lang/Exception
    //   510	517	7696	java/lang/Exception
    //   525	532	7696	java/lang/Exception
    //   728	739	7696	java/lang/Exception
    //   752	759	7696	java/lang/Exception
    //   762	771	7696	java/lang/Exception
    //   1734	1743	7806	java/lang/Exception
    //   1751	1759	7806	java/lang/Exception
    //   1763	1780	7806	java/lang/Exception
    //   1791	1798	7806	java/lang/Exception
    //   1824	1837	7806	java/lang/Exception
    //   1841	1847	7806	java/lang/Exception
    //   1851	1858	7806	java/lang/Exception
    //   1862	1876	7806	java/lang/Exception
    //   1880	1906	7806	java/lang/Exception
    //   1921	1927	7806	java/lang/Exception
    //   1931	1944	7806	java/lang/Exception
    //   1948	1956	7806	java/lang/Exception
    //   2047	2073	7806	java/lang/Exception
    //   2080	2087	7806	java/lang/Exception
    //   2144	2149	7806	java/lang/Exception
    //   2157	2165	7806	java/lang/Exception
    //   2169	2177	7806	java/lang/Exception
    //   2181	2194	7806	java/lang/Exception
    //   2198	2205	7806	java/lang/Exception
    //   2214	2222	7806	java/lang/Exception
    //   2226	2242	7806	java/lang/Exception
    //   2246	2252	7806	java/lang/Exception
    //   2256	2269	7806	java/lang/Exception
    //   2279	2287	7806	java/lang/Exception
    //   2440	2447	7806	java/lang/Exception
    //   2451	2456	7806	java/lang/Exception
    //   2460	2471	7806	java/lang/Exception
    //   2482	2488	7806	java/lang/Exception
    //   2492	2499	7806	java/lang/Exception
    //   2503	2512	7806	java/lang/Exception
    //   2516	2557	7806	java/lang/Exception
    //   2565	2573	7806	java/lang/Exception
    //   2577	2584	7806	java/lang/Exception
    //   2588	2595	7806	java/lang/Exception
    //   2599	2607	7806	java/lang/Exception
    //   2611	2624	7806	java/lang/Exception
    //   2700	2704	7806	java/lang/Exception
    //   2732	2738	7806	java/lang/Exception
    //   2742	2769	7806	java/lang/Exception
  }
  
  public static void a(Context paramContext, IMCoreAppRuntime paramIMCoreAppRuntime, IMCoreMessageStub paramIMCoreMessageStub, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramIMCoreAppRuntime;
    paramIMCoreMessageStub = (QQMessageFacade.Message)paramIMCoreMessageStub;
    a(paramIMCoreMessageStub, localQQAppInterface, paramInt);
    if (paramIMCoreMessageStub != null) {}
    for (paramIMCoreAppRuntime = paramIMCoreMessageStub.nickName;; paramIMCoreAppRuntime = null)
    {
      a(paramContext, localQQAppInterface, paramIMCoreMessageStub, paramInt, paramMsgSummary, paramIMCoreAppRuntime, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  private static void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessage.istroop == 10007) && (paramMessage.msgtype == -5008)) {
      paramMsgSummary.strContent += paramQQAppInterface.getApp().getString(2131692539);
    }
  }
  
  private static void a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessage != null) && (1 == paramInt))
    {
      paramQQAppInterface = bglf.g(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      if ((paramQQAppInterface != null) && (!TextUtils.equals(paramQQAppInterface, paramMessage.nickName)))
      {
        paramMessage.nickName = paramQQAppInterface;
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "processTroopNickName  nickname : " + paramQQAppInterface);
        }
      }
    }
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
  
  private static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = paramQQAppInterface.a().a().c().iterator();
    while (localIterator.hasNext()) {
      if (((acxb)localIterator.next()).a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    QQMessageFacade.Message localMessage = paramMessage;
    if (acwh.b(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (acwh.b(paramMessage.senderuin)) {
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
          paramQQAppInterface = bfsj.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof bdtd)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((bdtd)paramMessage).f() >= 0) && (((bdtd)paramMessage).f() != 100)) {
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
      if ((paramQQAppInterface instanceof bdsx))
      {
        long l = ((bdsx)paramQQAppInterface).c();
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
          if (!acwh.b(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (acwh.b(paramMessage.senderuin));
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
      paramQQAppInterface = bfsj.a(paramQQAppInterface, paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnr
 * JD-Core Version:    0.7.0.1
 */