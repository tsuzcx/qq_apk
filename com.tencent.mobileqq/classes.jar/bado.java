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

public class bado
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
    paramQQAppInterface = (TransFileInfo)((atmp)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((atmp)localObject).a();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = apck.b(paramQQAppInterface.status);
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
    paramContext = paramQQAppInterface.a().a(baak.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131624592);
    }
    return paramQQAppInterface.getApp().getString(2131624594) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131624595);
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
        String str2 = azzy.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = babh.b(paramQQAppInterface, paramMessage.senderuin, true);
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
                  paramContext = paramContext.getString(2131624123);
                  break;
                  paramContext = paramContext.getString(2131624003);
                  break;
                  paramContext = paramContext.getString(2131624002);
                  break;
                  paramContext = paramContext.getString(2131652854);
                  break;
                  paramContext = paramContext.getString(2131624162);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = azzy.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = babh.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return azzy.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
    paramString = azzy.a(paramString, paramQQAppInterface);
    paramMessage = azzy.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = babh.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = azzy.a(paramString, paramMessage, paramQQAppInterface);
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131627718));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131628641));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131653300));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  /* Error */
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: ldc 119
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: iload 5
    //   14: iconst_1
    //   15: if_icmpeq +11 -> 26
    //   18: iload 5
    //   20: sipush 5000
    //   23: if_icmpne +310 -> 333
    //   26: iconst_1
    //   27: istore 6
    //   29: aload_1
    //   30: arraylength
    //   31: iconst_1
    //   32: if_icmple +284 -> 316
    //   35: aload_1
    //   36: iconst_1
    //   37: aaload
    //   38: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore 7
    //   43: iload 7
    //   45: tableswitch	default:+19 -> 64, 13:+114->159
    //   65: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: ldc_w 283
    //   71: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   74: astore_3
    //   75: iload 5
    //   77: iconst_1
    //   78: if_icmpeq +11 -> 89
    //   81: iload 5
    //   83: sipush 5000
    //   86: if_icmpne +14 -> 100
    //   89: aload_2
    //   90: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   93: ldc_w 287
    //   96: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   99: astore_3
    //   100: iload 8
    //   102: istore 5
    //   104: aload_1
    //   105: arraylength
    //   106: iconst_4
    //   107: if_icmple +11 -> 118
    //   110: aload_1
    //   111: iconst_4
    //   112: aaload
    //   113: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore 5
    //   118: aload_3
    //   119: astore_1
    //   120: iload 5
    //   122: iconst_2
    //   123: if_icmpne -113 -> 10
    //   126: aload_3
    //   127: aload_0
    //   128: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: ldc_w 287
    //   134: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   137: aload_0
    //   138: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   141: ldc_w 288
    //   144: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   147: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   150: areturn
    //   151: astore 9
    //   153: iconst_0
    //   154: istore 7
    //   156: goto -113 -> 43
    //   159: aload 4
    //   161: ifnull +113 -> 274
    //   164: aload_0
    //   165: aload 4
    //   167: aload_3
    //   168: iload 6
    //   170: iconst_0
    //   171: invokestatic 291	babh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   174: astore 4
    //   176: aload_2
    //   177: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   180: ldc_w 283
    //   183: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   186: astore_3
    //   187: iload 5
    //   189: iconst_1
    //   190: if_icmpeq +11 -> 201
    //   193: iload 5
    //   195: sipush 5000
    //   198: if_icmpne +14 -> 212
    //   201: aload_2
    //   202: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   205: ldc_w 287
    //   208: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   211: astore_3
    //   212: aload 4
    //   214: invokevirtual 204	java/lang/String:length	()I
    //   217: bipush 11
    //   219: if_icmple +108 -> 327
    //   222: aload 4
    //   224: iconst_0
    //   225: bipush 10
    //   227: invokevirtual 295	java/lang/String:substring	(II)Ljava/lang/String;
    //   230: astore_2
    //   231: new 160	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 297
    //   245: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore_2
    //   252: new 160	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   259: aload_2
    //   260: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore_3
    //   271: goto -171 -> 100
    //   274: iload 5
    //   276: iconst_1
    //   277: if_icmpeq +11 -> 288
    //   280: iload 5
    //   282: sipush 5000
    //   285: if_icmpne +17 -> 302
    //   288: aload_2
    //   289: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   292: ldc_w 288
    //   295: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   298: astore_3
    //   299: goto -199 -> 100
    //   302: aload_2
    //   303: invokevirtual 282	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   306: ldc_w 298
    //   309: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   312: astore_3
    //   313: goto -213 -> 100
    //   316: ldc 119
    //   318: areturn
    //   319: astore_1
    //   320: iload 8
    //   322: istore 5
    //   324: goto -206 -> 118
    //   327: aload 4
    //   329: astore_2
    //   330: goto -78 -> 252
    //   333: iconst_2
    //   334: istore 6
    //   336: goto -307 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramQQAppInterface	QQAppInterface
    //   0	339	1	paramArrayOfString	String[]
    //   0	339	2	paramContext	Context
    //   0	339	3	paramString1	String
    //   0	339	4	paramString2	String
    //   0	339	5	paramInt	int
    //   27	308	6	i	int
    //   41	114	7	j	int
    //   1	320	8	k	int
    //   151	1	9	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   35	43	151	java/lang/NumberFormatException
    //   110	118	319	java/lang/NumberFormatException
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
            QLog.d("msgSummary", 2, "textSummary: " + azzz.a(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (aeor.b(paramMessageForPic)) || (amxv.b(paramMessageForPic)) || (aemi.a(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131625713);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131625713);
  }
  
  public static String a(String paramString)
  {
    String str = ajjy.a(2131641187);
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
        localObject3 = ajjy.a(2131641196);
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
              paramContext = paramContext.getResources().getString(2131630526);
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
        if (paramContext.getString(2131654853).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131630543);
          }
          return paramContext.getResources().getString(2131630007);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131630526) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131629993) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131654857).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131630539);
            }
            return paramContext.getResources().getString(2131630538);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131630002);
          }
          return paramContext.getResources().getString(2131630001);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131630526) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131629993) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131630539);
          }
          return paramContext.getResources().getString(2131630538);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131630002);
        }
        return paramContext.getResources().getString(2131630001);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131630539);
          }
          return paramContext.getResources().getString(2131630538);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131630002);
        }
        return paramContext.getResources().getString(2131630001);
        if (j != 0) {
          return paramContext.getResources().getString(2131630540);
        }
        return paramContext.getResources().getString(2131630003);
        if (j != 0) {
          return paramContext.getResources().getString(2131630526);
        }
        return paramContext.getResources().getString(2131629993);
        if (j != 0) {
          return paramContext.getResources().getString(2131630527);
        }
        return paramContext.getResources().getString(2131629995);
        if (j != 0) {
          return paramContext.getResources().getString(2131630542);
        }
        return paramContext.getResources().getString(2131630006);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131654853).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131630543);
          }
          return paramContext.getResources().getString(2131630007);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131630526) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131629993) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131629993) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131629993);
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
    //   10: invokestatic 495	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   13: ifeq +7683 -> 7696
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
    //   36: invokestatic 497	babh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   39: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +7654 -> 7696
    //   45: aload_1
    //   46: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   49: aload_2
    //   50: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   53: aload_2
    //   54: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   57: aload_2
    //   58: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   61: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   64: astore 16
    //   66: aload 16
    //   68: instanceof 507
    //   71: ifeq +11 -> 82
    //   74: aload 16
    //   76: checkcast 507	com/tencent/mobileqq/data/ChatMessage
    //   79: invokevirtual 510	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   82: aload 16
    //   84: ifnull +13 -> 97
    //   87: aload 16
    //   89: invokestatic 513	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lmng;
    //   92: getfield 517	mng:b	Ljava/lang/String;
    //   95: astore 5
    //   97: aload 5
    //   99: astore 16
    //   101: aload 5
    //   103: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +7590 -> 7696
    //   109: aload_2
    //   110: invokestatic 513	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lmng;
    //   113: getfield 517	mng:b	Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: astore 16
    //   122: iload 6
    //   124: ifne +42 -> 166
    //   127: aload_2
    //   128: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   131: ifne +32 -> 163
    //   134: aload 5
    //   136: astore 16
    //   138: aload_2
    //   139: getfield 523	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   142: ifnull +24 -> 166
    //   145: aload 5
    //   147: astore 16
    //   149: aload_2
    //   150: getfield 523	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   153: aload_2
    //   154: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   157: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +6 -> 166
    //   163: aconst_null
    //   164: astore 16
    //   166: aload_2
    //   167: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   170: invokestatic 528	akbm:k	(I)Z
    //   173: ifeq +6 -> 179
    //   176: aconst_null
    //   177: astore 16
    //   179: aload_2
    //   180: invokestatic 533	azhy:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lazhz;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +10 -> 197
    //   190: aload 5
    //   192: getfield 537	azhz:c	Ljava/lang/String;
    //   195: astore 16
    //   197: aload 16
    //   199: invokestatic 538	bado:b	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 19
    //   204: aload_2
    //   205: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   208: sipush -2034
    //   211: if_icmpne +16 -> 227
    //   214: aload 4
    //   216: aload_2
    //   217: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   220: invokestatic 546	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
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
    //   253: getfield 555	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extInt	I
    //   256: bipush 61
    //   258: if_icmpne +20 -> 278
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   266: invokevirtual 556	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   269: ldc_w 557
    //   272: invokevirtual 286	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   275: putfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   278: aload_2
    //   279: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   282: iconst_1
    //   283: if_icmpne +73 -> 356
    //   286: aload_1
    //   287: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   290: aload_2
    //   291: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   294: aload_2
    //   295: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   298: aload_2
    //   299: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   302: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   305: astore_0
    //   306: iload 8
    //   308: istore_3
    //   309: aload_0
    //   310: invokestatic 560	asdj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   313: ifeq +21 -> 334
    //   316: aconst_null
    //   317: aconst_null
    //   318: aload_0
    //   319: checkcast 562	com/tencent/mobileqq/data/MessageForStructing
    //   322: invokestatic 565	asdj:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   325: iconst_0
    //   326: iconst_0
    //   327: aload 4
    //   329: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   332: iconst_1
    //   333: istore_3
    //   334: aload_0
    //   335: invokestatic 571	azhx:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   338: ifeq +18 -> 356
    //   341: aconst_null
    //   342: aconst_null
    //   343: aload_2
    //   344: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   347: iconst_0
    //   348: iconst_0
    //   349: aload 4
    //   351: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   354: iconst_1
    //   355: istore_3
    //   356: iload_3
    //   357: ifne -353 -> 4
    //   360: aload_1
    //   361: aload_2
    //   362: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   365: istore 6
    //   367: aload_1
    //   368: aload_2
    //   369: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   372: istore 7
    //   374: aload 19
    //   376: aconst_null
    //   377: aload_2
    //   378: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   381: iload 6
    //   383: iload 7
    //   385: aload 4
    //   387: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
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
    //   437: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   440: ifeq +7253 -> 7693
    //   443: aload_2
    //   444: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   447: astore 17
    //   449: aload_1
    //   450: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   453: aload 17
    //   455: aload_2
    //   456: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   459: aload_2
    //   460: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   463: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   466: checkcast 301	com/tencent/mobileqq/data/MessageForPic
    //   469: astore 16
    //   471: aload 18
    //   473: astore 5
    //   475: aload_1
    //   476: invokevirtual 582	com/tencent/mobileqq/app/QQAppInterface:a	()Laxvo;
    //   479: aload 17
    //   481: aload_2
    //   482: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   485: invokevirtual 587	axvo:a	(Ljava/lang/String;J)Lbaky;
    //   488: astore_1
    //   489: aload_1
    //   490: astore 5
    //   492: aload_2
    //   493: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   496: ifeq +231 -> 727
    //   499: aload 16
    //   501: ifnull +201 -> 702
    //   504: aload_1
    //   505: astore 5
    //   507: aload 16
    //   509: getfield 590	com/tencent/mobileqq/data/MessageForPic:size	J
    //   512: lstore 14
    //   514: lload 14
    //   516: lconst_0
    //   517: lcmp
    //   518: ifgt +184 -> 702
    //   521: aload_1
    //   522: ifnonnull +7165 -> 7687
    //   525: iconst_1
    //   526: istore 6
    //   528: aload 16
    //   530: astore 5
    //   532: iload 6
    //   534: istore 7
    //   536: aload_1
    //   537: astore 16
    //   539: aload 16
    //   541: instanceof 592
    //   544: ifeq +260 -> 804
    //   547: aload 16
    //   549: checkcast 592	axou
    //   552: astore_1
    //   553: aload_1
    //   554: invokevirtual 594	axou:c	()J
    //   557: ldc2_w 595
    //   560: lcmp
    //   561: ifeq +7120 -> 7681
    //   564: iconst_1
    //   565: istore 6
    //   567: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +60 -> 630
    //   573: aload_1
    //   574: getfield 599	axou:a	Laxvt;
    //   577: ifnull +219 -> 796
    //   580: aload_1
    //   581: getfield 599	axou:a	Laxvt;
    //   584: getfield 602	axvt:jdField_a_of_type_Long	J
    //   587: lstore 14
    //   589: ldc_w 604
    //   592: iconst_2
    //   593: new 160	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 606
    //   603: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: lload 14
    //   608: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   611: ldc_w 608
    //   614: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_1
    //   618: invokevirtual 610	axou:a	()Ljava/lang/String;
    //   621: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload_0
    //   631: ldc_w 611
    //   634: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   637: astore_1
    //   638: aload_2
    //   639: invokestatic 614	ajke:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   642: ifne +10 -> 652
    //   645: aload_2
    //   646: invokestatic 617	ajhz:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   649: ifeq +11 -> 660
    //   652: aload_0
    //   653: ldc_w 618
    //   656: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   659: astore_1
    //   660: aload_2
    //   661: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   664: sipush -5015
    //   667: if_icmpne +11 -> 678
    //   670: aload_0
    //   671: ldc_w 619
    //   674: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   677: astore_1
    //   678: aload 5
    //   680: invokestatic 621	bado:a	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   683: astore_0
    //   684: aload_0
    //   685: ifnull +6991 -> 7676
    //   688: aload 19
    //   690: aload_0
    //   691: aconst_null
    //   692: iload 7
    //   694: iload 6
    //   696: aload 4
    //   698: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   701: return
    //   702: aload 16
    //   704: ifnull +6983 -> 7687
    //   707: aload_1
    //   708: astore 5
    //   710: aload 16
    //   712: getfield 624	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   715: ldc_w 625
    //   718: if_icmpne +6985 -> 7703
    //   721: iconst_1
    //   722: istore 6
    //   724: goto -196 -> 528
    //   727: aload_1
    //   728: ifnull +6959 -> 7687
    //   731: aload_1
    //   732: astore 5
    //   734: aload_1
    //   735: instanceof 592
    //   738: ifeq +6949 -> 7687
    //   741: aload_1
    //   742: astore 5
    //   744: aload_1
    //   745: checkcast 592	axou
    //   748: invokevirtual 594	axou:c	()J
    //   751: lstore 14
    //   753: lload 14
    //   755: l2i
    //   756: istore_3
    //   757: iload_3
    //   758: sipush 1005
    //   761: if_icmpeq +10 -> 771
    //   764: iload_3
    //   765: sipush 1004
    //   768: if_icmpne +6919 -> 7687
    //   771: iconst_1
    //   772: istore 6
    //   774: goto -246 -> 528
    //   777: astore 16
    //   779: aconst_null
    //   780: astore_1
    //   781: aload 16
    //   783: invokevirtual 462	java/lang/Exception:printStackTrace	()V
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
    //   820: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   823: ifeq -193 -> 630
    //   826: ldc_w 604
    //   829: iconst_2
    //   830: new 160	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   837: ldc_w 627
    //   840: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload 16
    //   845: invokevirtual 630	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   895: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   898: ifeq +6775 -> 7673
    //   901: aload_2
    //   902: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   905: astore 16
    //   907: iconst_0
    //   908: istore 6
    //   910: aload_0
    //   911: ldc_w 631
    //   914: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   917: astore_0
    //   918: aload_1
    //   919: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   922: aload 16
    //   924: aload_2
    //   925: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   928: aload_2
    //   929: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   932: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   935: astore 5
    //   937: aload 5
    //   939: instanceof 633
    //   942: ifeq +6725 -> 7667
    //   945: aload 5
    //   947: checkcast 633	com/tencent/mobileqq/data/MessageForPtt
    //   950: astore 17
    //   952: aload 17
    //   954: invokevirtual 636	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   957: astore 5
    //   959: aload 5
    //   961: astore_0
    //   962: aload_2
    //   963: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   966: ifeq +6701 -> 7667
    //   969: aload 17
    //   971: getfield 639	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   974: ldc2_w 39
    //   977: lcmp
    //   978: ifne +52 -> 1030
    //   981: iconst_1
    //   982: istore 6
    //   984: aload 5
    //   986: astore_0
    //   987: iconst_0
    //   988: istore 7
    //   990: ldc_w 641
    //   993: iconst_2
    //   994: anewarray 4	java/lang/Object
    //   997: dup
    //   998: iconst_0
    //   999: iload 6
    //   1001: invokestatic 646	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1004: aastore
    //   1005: dup
    //   1006: iconst_1
    //   1007: iload 7
    //   1009: invokestatic 646	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1012: aastore
    //   1013: invokestatic 651	amvy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: aload 19
    //   1018: aload_0
    //   1019: aconst_null
    //   1020: iload 6
    //   1022: iload 7
    //   1024: aload 4
    //   1026: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1029: return
    //   1030: aload 5
    //   1032: astore_0
    //   1033: aload 17
    //   1035: getfield 639	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1038: lconst_0
    //   1039: lcmp
    //   1040: ifgt +6627 -> 7667
    //   1043: aload_1
    //   1044: invokevirtual 582	com/tencent/mobileqq/app/QQAppInterface:a	()Laxvo;
    //   1047: aload 16
    //   1049: aload 17
    //   1051: getfield 654	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1054: aload 17
    //   1056: getfield 655	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   1059: invokevirtual 658	axvo:b	(Ljava/lang/String;Ljava/lang/String;J)I
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
    //   1088: ldc_w 641
    //   1091: iconst_2
    //   1092: anewarray 4	java/lang/Object
    //   1095: dup
    //   1096: iconst_0
    //   1097: aload 17
    //   1099: getfield 639	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1102: invokestatic 663	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1105: aastore
    //   1106: dup
    //   1107: iconst_1
    //   1108: iload_3
    //   1109: invokestatic 666	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1112: aastore
    //   1113: invokestatic 651	amvy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1163: ldc_w 667
    //   1166: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   1169: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: ldc_w 669
    //   1175: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: aload_2
    //   1179: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1182: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: ldc_w 669
    //   1188: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1197: return
    //   1198: aload_2
    //   1199: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1202: sipush -2015
    //   1205: if_icmpeq +43 -> 1248
    //   1208: aload_2
    //   1209: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1212: sipush -2060
    //   1215: if_icmpeq +33 -> 1248
    //   1218: aload_2
    //   1219: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1222: sipush -2065
    //   1225: if_icmpeq +23 -> 1248
    //   1228: aload_2
    //   1229: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1232: sipush -2062
    //   1235: if_icmpeq +13 -> 1248
    //   1238: aload_2
    //   1239: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1242: sipush -4023
    //   1245: if_icmpne +11 -> 1256
    //   1248: aload 4
    //   1250: ldc 119
    //   1252: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1255: return
    //   1256: aload_2
    //   1257: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1260: invokestatic 673	baac:a	(I)Z
    //   1263: ifeq +28 -> 1291
    //   1266: aload 19
    //   1268: aload_0
    //   1269: aload_1
    //   1270: aload_2
    //   1271: invokestatic 675	bado:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1274: aconst_null
    //   1275: aload_1
    //   1276: aload_2
    //   1277: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1280: aload_1
    //   1281: aload_2
    //   1282: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1285: aload 4
    //   1287: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1290: return
    //   1291: aload_2
    //   1292: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1295: sipush -2017
    //   1298: if_icmpne +94 -> 1392
    //   1301: aload_0
    //   1302: ldc_w 676
    //   1305: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   1308: astore 5
    //   1310: aload_2
    //   1311: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1314: astore_0
    //   1315: aload_2
    //   1316: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1319: aload_2
    //   1320: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1323: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   1326: ifeq +8 -> 1334
    //   1329: aload_2
    //   1330: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1333: astore_0
    //   1334: aload_1
    //   1335: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1338: aload_0
    //   1339: aload_2
    //   1340: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1343: aload_2
    //   1344: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1347: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1350: astore 16
    //   1352: aload 5
    //   1354: astore_0
    //   1355: aload 16
    //   1357: instanceof 678
    //   1360: ifeq +12 -> 1372
    //   1363: aload 16
    //   1365: checkcast 678	com/tencent/mobileqq/data/MessageForTroopFile
    //   1368: invokevirtual 679	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1371: astore_0
    //   1372: aload 19
    //   1374: aload_0
    //   1375: aconst_null
    //   1376: aload_1
    //   1377: aload_2
    //   1378: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1381: aload_1
    //   1382: aload_2
    //   1383: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1386: aload 4
    //   1388: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1391: return
    //   1392: aload_2
    //   1393: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1396: invokestatic 681	baac:b	(I)Z
    //   1399: ifeq +35 -> 1434
    //   1402: aload_2
    //   1403: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1406: invokestatic 686	axwb:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1409: astore_1
    //   1410: aload_1
    //   1411: ifnull -1407 -> 4
    //   1414: aload 4
    //   1416: aload_1
    //   1417: aload_0
    //   1418: aload_2
    //   1419: getfield 689	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   1422: invokestatic 690	bado:b	(I)Z
    //   1425: iload 7
    //   1427: invokestatic 692	bado:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1430: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1433: return
    //   1434: aload_2
    //   1435: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1438: invokestatic 694	baac:c	(I)Z
    //   1441: ifeq +39 -> 1480
    //   1444: aload_2
    //   1445: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1448: invokestatic 686	axwb:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1451: astore 5
    //   1453: aload 5
    //   1455: ifnull -1451 -> 4
    //   1458: aload 4
    //   1460: aload_1
    //   1461: aload 5
    //   1463: aload_0
    //   1464: aload_2
    //   1465: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1468: aload_2
    //   1469: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1472: iload_3
    //   1473: invokestatic 696	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1476: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1479: return
    //   1480: aload_2
    //   1481: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1484: invokestatic 698	baac:d	(I)Z
    //   1487: ifeq +134 -> 1621
    //   1490: aload_1
    //   1491: aload_2
    //   1492: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1495: istore 6
    //   1497: aload_1
    //   1498: aload_2
    //   1499: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1502: istore 7
    //   1504: aload_2
    //   1505: ldc_w 700
    //   1508: invokevirtual 703	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1511: astore 5
    //   1513: getstatic 708	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1516: ifeq +96 -> 1612
    //   1519: aload 5
    //   1521: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1524: ifne +88 -> 1612
    //   1527: aload_0
    //   1528: aload_2
    //   1529: invokestatic 713	anam:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1532: astore_0
    //   1533: aload_2
    //   1534: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1537: aload_1
    //   1538: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1541: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1544: ifeq +41 -> 1585
    //   1547: new 160	java/lang/StringBuilder
    //   1550: dup
    //   1551: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1554: ldc_w 714
    //   1557: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   1560: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: aload_0
    //   1564: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: astore_0
    //   1571: aload 19
    //   1573: aload_0
    //   1574: aconst_null
    //   1575: iload 6
    //   1577: iload 7
    //   1579: aload 4
    //   1581: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1584: return
    //   1585: new 160	java/lang/StringBuilder
    //   1588: dup
    //   1589: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1592: ldc_w 715
    //   1595: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   1598: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: aload_0
    //   1602: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1608: astore_0
    //   1609: goto -38 -> 1571
    //   1612: aload_0
    //   1613: aload_2
    //   1614: invokestatic 713	anam:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1617: astore_0
    //   1618: goto -47 -> 1571
    //   1621: aload_2
    //   1622: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1625: sipush -2058
    //   1628: if_icmpne +1070 -> 2698
    //   1631: ldc 119
    //   1633: astore 18
    //   1635: aload_1
    //   1636: aload_2
    //   1637: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1640: istore 12
    //   1642: aload_1
    //   1643: aload_2
    //   1644: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1647: istore 13
    //   1649: iconst_0
    //   1650: istore 8
    //   1652: aload 18
    //   1654: astore 17
    //   1656: aload_2
    //   1657: ldc_w 717
    //   1660: invokevirtual 703	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1663: astore 5
    //   1665: aload 18
    //   1667: astore 16
    //   1669: aload 18
    //   1671: astore 17
    //   1673: aload 5
    //   1675: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1678: ifne +270 -> 1948
    //   1681: aload 18
    //   1683: astore 17
    //   1685: new 719	org/json/JSONObject
    //   1688: dup
    //   1689: aload 5
    //   1691: invokespecial 722	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1694: ldc_w 724
    //   1697: invokevirtual 727	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1700: istore 9
    //   1702: iload 8
    //   1704: istore_3
    //   1705: aload 18
    //   1707: astore 5
    //   1709: aload 18
    //   1711: astore 17
    //   1713: aload_2
    //   1714: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1717: ifnull +114 -> 1831
    //   1720: iload 8
    //   1722: istore_3
    //   1723: aload 18
    //   1725: astore 5
    //   1727: iload 9
    //   1729: sipush -2007
    //   1732: if_icmpne +99 -> 1831
    //   1735: iload 8
    //   1737: istore_3
    //   1738: aload 18
    //   1740: astore 5
    //   1742: aload 18
    //   1744: astore 17
    //   1746: aload_2
    //   1747: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1750: invokestatic 736	akhp:a	([B)Ljava/lang/Object;
    //   1753: instanceof 738
    //   1756: ifeq +75 -> 1831
    //   1759: aload 18
    //   1761: astore 17
    //   1763: getstatic 708	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1766: ifeq +232 -> 1998
    //   1769: aload 18
    //   1771: astore 17
    //   1773: aload_0
    //   1774: aload_2
    //   1775: invokestatic 713	anam:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1778: astore 5
    //   1780: aload 18
    //   1782: astore 17
    //   1784: aload_2
    //   1785: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1788: aload_1
    //   1789: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1792: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1795: ifeq +170 -> 1965
    //   1798: aload 18
    //   1800: astore 17
    //   1802: new 160	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1809: ldc_w 739
    //   1812: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   1815: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: aload 5
    //   1820: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1826: astore 5
    //   1828: goto +5881 -> 7709
    //   1831: aload 5
    //   1833: astore 16
    //   1835: iload_3
    //   1836: ifne +112 -> 1948
    //   1839: aload 5
    //   1841: astore 17
    //   1843: getstatic 708	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1846: ifeq +208 -> 2054
    //   1849: aload 5
    //   1851: astore 17
    //   1853: aload_2
    //   1854: ldc_w 700
    //   1857: invokevirtual 703	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1860: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1863: ifne +5798 -> 7661
    //   1866: aload 5
    //   1868: astore 17
    //   1870: aload_1
    //   1871: aload_2
    //   1872: aload 4
    //   1874: invokestatic 742	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Laxkd;
    //   1877: astore_0
    //   1878: new 160	java/lang/StringBuilder
    //   1881: dup
    //   1882: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1885: astore_1
    //   1886: aload 19
    //   1888: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1891: ifne +16 -> 1907
    //   1894: aload_1
    //   1895: aload 19
    //   1897: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: ldc_w 367
    //   1903: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: pop
    //   1907: aload_2
    //   1908: invokestatic 495	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1911: ifne +16 -> 1927
    //   1914: iload 12
    //   1916: ifeq +98 -> 2014
    //   1919: aload_1
    //   1920: ldc_w 744
    //   1923: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: pop
    //   1927: aload_0
    //   1928: checkcast 746	axkd
    //   1931: aload_1
    //   1932: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: iconst_1
    //   1936: iconst_0
    //   1937: newarray int
    //   1939: invokevirtual 749	axkd:a	(Ljava/lang/String;Z[I)Laxkd;
    //   1942: astore_1
    //   1943: aload_1
    //   1944: astore_0
    //   1945: aload_0
    //   1946: astore 16
    //   1948: aload 16
    //   1950: astore_2
    //   1951: aload 19
    //   1953: aload_2
    //   1954: aconst_null
    //   1955: iload 12
    //   1957: iload 13
    //   1959: aload 4
    //   1961: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1964: return
    //   1965: aload 18
    //   1967: astore 17
    //   1969: new 160	java/lang/StringBuilder
    //   1972: dup
    //   1973: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1976: ldc_w 750
    //   1979: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   1982: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: aload 5
    //   1987: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1990: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1993: astore 5
    //   1995: goto +5714 -> 7709
    //   1998: aload 18
    //   2000: astore 17
    //   2002: aload_0
    //   2003: aload_2
    //   2004: invokestatic 713	anam:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   2007: astore 5
    //   2009: iconst_1
    //   2010: istore_3
    //   2011: goto -180 -> 1831
    //   2014: iload 13
    //   2016: ifeq -89 -> 1927
    //   2019: aload_1
    //   2020: ldc_w 752
    //   2023: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: goto -100 -> 1927
    //   2030: astore_1
    //   2031: aload_0
    //   2032: astore_2
    //   2033: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2036: ifeq -85 -> 1951
    //   2039: ldc_w 754
    //   2042: iconst_2
    //   2043: ldc 119
    //   2045: aload_1
    //   2046: invokestatic 757	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2049: aload_0
    //   2050: astore_2
    //   2051: goto -100 -> 1951
    //   2054: iload 9
    //   2056: sipush -1000
    //   2059: if_icmpne +153 -> 2212
    //   2062: aload 5
    //   2064: astore 17
    //   2066: aload_2
    //   2067: invokestatic 760	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Laxkd;
    //   2070: astore_0
    //   2071: aload_0
    //   2072: ifnull -2068 -> 4
    //   2075: aload 5
    //   2077: astore 17
    //   2079: new 160	java/lang/StringBuilder
    //   2082: dup
    //   2083: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2086: astore_1
    //   2087: aload 5
    //   2089: astore 17
    //   2091: aload 19
    //   2093: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2096: ifne +20 -> 2116
    //   2099: aload 5
    //   2101: astore 17
    //   2103: aload_1
    //   2104: aload 19
    //   2106: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: ldc_w 367
    //   2112: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: pop
    //   2116: aload 5
    //   2118: astore 17
    //   2120: aload_2
    //   2121: invokestatic 495	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2124: ifne +20 -> 2144
    //   2127: iload 12
    //   2129: ifeq +63 -> 2192
    //   2132: aload 5
    //   2134: astore 17
    //   2136: aload_1
    //   2137: ldc_w 744
    //   2140: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: pop
    //   2144: aload 5
    //   2146: astore 17
    //   2148: aload_0
    //   2149: checkcast 746	axkd
    //   2152: aload_1
    //   2153: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2156: iconst_1
    //   2157: iconst_0
    //   2158: newarray int
    //   2160: invokevirtual 749	axkd:a	(Ljava/lang/String;Z[I)Laxkd;
    //   2163: astore_0
    //   2164: aload 5
    //   2166: astore 17
    //   2168: aload 4
    //   2170: iconst_1
    //   2171: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2174: aload 5
    //   2176: astore 17
    //   2178: aload 19
    //   2180: aload_0
    //   2181: aconst_null
    //   2182: iload 12
    //   2184: iload 13
    //   2186: aload 4
    //   2188: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2191: return
    //   2192: iload 13
    //   2194: ifeq -50 -> 2144
    //   2197: aload 5
    //   2199: astore 17
    //   2201: aload_1
    //   2202: ldc_w 752
    //   2205: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: pop
    //   2209: goto -65 -> 2144
    //   2212: aload 5
    //   2214: astore 16
    //   2216: iload 9
    //   2218: sipush -2000
    //   2221: if_icmpne -273 -> 1948
    //   2224: iconst_0
    //   2225: istore 11
    //   2227: iconst_0
    //   2228: istore 7
    //   2230: aconst_null
    //   2231: astore 18
    //   2233: aload 18
    //   2235: astore 16
    //   2237: aload_2
    //   2238: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2241: astore 17
    //   2243: aload 18
    //   2245: astore 16
    //   2247: aload_2
    //   2248: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2251: aload_2
    //   2252: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2255: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   2258: ifeq +5400 -> 7658
    //   2261: aload 18
    //   2263: astore 16
    //   2265: aload_2
    //   2266: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2269: astore 17
    //   2271: aload 18
    //   2273: astore 16
    //   2275: aload_1
    //   2276: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   2279: aload 17
    //   2281: aload_2
    //   2282: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2285: aload_2
    //   2286: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2289: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2292: checkcast 301	com/tencent/mobileqq/data/MessageForPic
    //   2295: astore 20
    //   2297: aload 18
    //   2299: astore 16
    //   2301: aload_1
    //   2302: invokevirtual 582	com/tencent/mobileqq/app/QQAppInterface:a	()Laxvo;
    //   2305: aload 17
    //   2307: aload_2
    //   2308: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2311: invokevirtual 587	axvo:a	(Ljava/lang/String;J)Lbaky;
    //   2314: astore_1
    //   2315: aload_1
    //   2316: astore 16
    //   2318: aload_2
    //   2319: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2322: ifeq +245 -> 2567
    //   2325: aload_1
    //   2326: astore 16
    //   2328: aload 20
    //   2330: getfield 590	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2333: lstore 14
    //   2335: lload 14
    //   2337: lconst_0
    //   2338: lcmp
    //   2339: ifgt +208 -> 2547
    //   2342: aload_1
    //   2343: ifnonnull +5309 -> 7652
    //   2346: aload 20
    //   2348: ifnull +5304 -> 7652
    //   2351: iconst_1
    //   2352: istore 6
    //   2354: iload 6
    //   2356: istore 10
    //   2358: aload 5
    //   2360: astore 17
    //   2362: aload_1
    //   2363: instanceof 592
    //   2366: ifeq +269 -> 2635
    //   2369: aload 5
    //   2371: astore 17
    //   2373: aload_1
    //   2374: checkcast 592	axou
    //   2377: astore_1
    //   2378: aload 5
    //   2380: astore 17
    //   2382: aload_1
    //   2383: invokevirtual 594	axou:c	()J
    //   2386: ldc2_w 595
    //   2389: lcmp
    //   2390: ifeq +6 -> 2396
    //   2393: iconst_1
    //   2394: istore 7
    //   2396: iload 7
    //   2398: istore 6
    //   2400: aload 5
    //   2402: astore 17
    //   2404: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2407: ifeq +76 -> 2483
    //   2410: aload 5
    //   2412: astore 17
    //   2414: aload_1
    //   2415: getfield 599	axou:a	Laxvt;
    //   2418: ifnull +5309 -> 7727
    //   2421: aload 5
    //   2423: astore 17
    //   2425: aload_1
    //   2426: getfield 599	axou:a	Laxvt;
    //   2429: getfield 602	axvt:jdField_a_of_type_Long	J
    //   2432: lstore 14
    //   2434: aload 5
    //   2436: astore 17
    //   2438: ldc_w 604
    //   2441: iconst_2
    //   2442: new 160	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2449: ldc_w 606
    //   2452: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: lload 14
    //   2457: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2460: ldc_w 608
    //   2463: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: aload_1
    //   2467: invokevirtual 610	axou:a	()Ljava/lang/String;
    //   2470: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2476: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2479: iload 7
    //   2481: istore 6
    //   2483: aload 5
    //   2485: astore 17
    //   2487: aload_0
    //   2488: ldc_w 611
    //   2491: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   2494: astore_1
    //   2495: aload 5
    //   2497: astore 17
    //   2499: aload_2
    //   2500: invokestatic 614	ajke:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2503: ifne +14 -> 2517
    //   2506: aload 5
    //   2508: astore 17
    //   2510: aload_2
    //   2511: invokestatic 617	ajhz:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2514: ifeq +15 -> 2529
    //   2517: aload 5
    //   2519: astore 17
    //   2521: aload_0
    //   2522: ldc_w 618
    //   2525: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   2528: astore_1
    //   2529: aload 5
    //   2531: astore 17
    //   2533: aload 19
    //   2535: aload_1
    //   2536: aconst_null
    //   2537: iload 10
    //   2539: iload 6
    //   2541: aload 4
    //   2543: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2546: return
    //   2547: aload_1
    //   2548: astore 16
    //   2550: aload 20
    //   2552: getfield 624	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2555: ldc_w 625
    //   2558: if_icmpne +5163 -> 7721
    //   2561: iconst_1
    //   2562: istore 6
    //   2564: goto -210 -> 2354
    //   2567: aload_1
    //   2568: ifnull +5084 -> 7652
    //   2571: aload_1
    //   2572: astore 16
    //   2574: aload_1
    //   2575: instanceof 592
    //   2578: ifeq +5074 -> 7652
    //   2581: aload_1
    //   2582: astore 16
    //   2584: aload_1
    //   2585: checkcast 592	axou
    //   2588: invokevirtual 594	axou:c	()J
    //   2591: lstore 14
    //   2593: lload 14
    //   2595: l2i
    //   2596: istore_3
    //   2597: iload_3
    //   2598: sipush 1005
    //   2601: if_icmpeq +10 -> 2611
    //   2604: iload_3
    //   2605: sipush 1004
    //   2608: if_icmpne +5044 -> 7652
    //   2611: iconst_1
    //   2612: istore 6
    //   2614: goto -260 -> 2354
    //   2617: astore_1
    //   2618: aload 5
    //   2620: astore 17
    //   2622: aload_1
    //   2623: invokevirtual 462	java/lang/Exception:printStackTrace	()V
    //   2626: aload 16
    //   2628: astore_1
    //   2629: iconst_0
    //   2630: istore 10
    //   2632: goto -274 -> 2358
    //   2635: iload 11
    //   2637: istore 6
    //   2639: aload_1
    //   2640: ifnull -157 -> 2483
    //   2643: iconst_1
    //   2644: istore 7
    //   2646: iload 7
    //   2648: istore 6
    //   2650: aload 5
    //   2652: astore 17
    //   2654: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2657: ifeq -174 -> 2483
    //   2660: aload 5
    //   2662: astore 17
    //   2664: ldc_w 604
    //   2667: iconst_2
    //   2668: new 160	java/lang/StringBuilder
    //   2671: dup
    //   2672: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2675: ldc_w 627
    //   2678: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2681: aload_1
    //   2682: invokevirtual 630	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2685: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2688: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2691: iload 7
    //   2693: istore 6
    //   2695: goto -212 -> 2483
    //   2698: aload_2
    //   2699: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2702: invokestatic 765	baac:e	(I)Z
    //   2705: ifeq +267 -> 2972
    //   2708: new 767	com/tencent/mobileqq/data/MessageForApollo
    //   2711: dup
    //   2712: invokespecial 768	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2715: astore 5
    //   2717: aload 5
    //   2719: aload_2
    //   2720: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2723: putfield 769	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2726: aload 5
    //   2728: invokevirtual 770	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2731: aload_1
    //   2732: aload_2
    //   2733: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2736: istore 6
    //   2738: aload_1
    //   2739: aload_2
    //   2740: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2743: istore 7
    //   2745: aload 5
    //   2747: getfield 772	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2750: invokestatic 775	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2753: ifeq +209 -> 2962
    //   2756: ldc_w 776
    //   2759: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   2762: astore_0
    //   2763: aload 5
    //   2765: getfield 772	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2768: iconst_4
    //   2769: if_icmpne +155 -> 2924
    //   2772: aload 5
    //   2774: getfield 779	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2777: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2780: ifeq +43 -> 2823
    //   2783: new 160	java/lang/StringBuilder
    //   2786: dup
    //   2787: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2790: aload_0
    //   2791: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: ldc_w 780
    //   2797: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   2800: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2806: astore_1
    //   2807: aload_1
    //   2808: astore_0
    //   2809: aload 19
    //   2811: aload_0
    //   2812: aconst_null
    //   2813: iload 6
    //   2815: iload 7
    //   2817: aload 4
    //   2819: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2822: return
    //   2823: new 719	org/json/JSONObject
    //   2826: dup
    //   2827: aload 5
    //   2829: getfield 779	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2832: invokespecial 722	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2835: ldc_w 782
    //   2838: invokevirtual 785	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2841: astore_1
    //   2842: aload_1
    //   2843: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2846: ifeq +32 -> 2878
    //   2849: new 160	java/lang/StringBuilder
    //   2852: dup
    //   2853: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2856: aload_0
    //   2857: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2860: ldc_w 786
    //   2863: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   2866: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2869: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2872: astore_1
    //   2873: aload_1
    //   2874: astore_0
    //   2875: goto -66 -> 2809
    //   2878: new 160	java/lang/StringBuilder
    //   2881: dup
    //   2882: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2885: aload_0
    //   2886: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: ldc_w 473
    //   2892: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2895: aload_1
    //   2896: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2899: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2902: astore_1
    //   2903: aload_1
    //   2904: astore_0
    //   2905: goto -96 -> 2809
    //   2908: astore_1
    //   2909: ldc_w 754
    //   2912: iconst_1
    //   2913: aload_1
    //   2914: iconst_0
    //   2915: anewarray 4	java/lang/Object
    //   2918: invokestatic 789	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2921: goto -112 -> 2809
    //   2924: aload_1
    //   2925: aload 5
    //   2927: invokestatic 794	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2930: astore_1
    //   2931: new 160	java/lang/StringBuilder
    //   2934: dup
    //   2935: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   2938: aload_0
    //   2939: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: ldc_w 795
    //   2945: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   2948: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2951: aload_1
    //   2952: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2955: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2958: astore_0
    //   2959: goto -150 -> 2809
    //   2962: aload_1
    //   2963: aload 5
    //   2965: invokestatic 797	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2968: astore_0
    //   2969: goto -160 -> 2809
    //   2972: aload_2
    //   2973: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2976: sipush -1013
    //   2979: if_icmpeq +13 -> 2992
    //   2982: aload_2
    //   2983: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2986: sipush -1047
    //   2989: if_icmpne +20 -> 3009
    //   2992: aconst_null
    //   2993: aconst_null
    //   2994: aload_2
    //   2995: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2998: invokestatic 546	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3001: iconst_0
    //   3002: iconst_0
    //   3003: aload 4
    //   3005: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3008: return
    //   3009: aload_2
    //   3010: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3013: sipush -2042
    //   3016: if_icmpeq +13 -> 3029
    //   3019: aload_2
    //   3020: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3023: sipush -2043
    //   3026: if_icmpne +20 -> 3046
    //   3029: aconst_null
    //   3030: aload_2
    //   3031: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3034: invokestatic 546	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3037: aconst_null
    //   3038: iconst_0
    //   3039: iconst_0
    //   3040: aload 4
    //   3042: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3045: return
    //   3046: aload_2
    //   3047: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3050: sipush -2051
    //   3053: if_icmpne +155 -> 3208
    //   3056: aload_1
    //   3057: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3060: aload_2
    //   3061: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3064: aload_2
    //   3065: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3068: aload_2
    //   3069: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3072: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3075: astore_0
    //   3076: aload_0
    //   3077: ifnull +50 -> 3127
    //   3080: aload_0
    //   3081: instanceof 799
    //   3084: ifeq +43 -> 3127
    //   3087: aload_0
    //   3088: checkcast 799	com/tencent/mobileqq/data/MessageForQQStory
    //   3091: astore_0
    //   3092: aload_0
    //   3093: invokevirtual 800	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3096: aload_1
    //   3097: aload_2
    //   3098: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3101: istore 6
    //   3103: aload_1
    //   3104: aload_2
    //   3105: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3108: istore 7
    //   3110: aload 19
    //   3112: aconst_null
    //   3113: aload_0
    //   3114: invokevirtual 801	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3117: iload 6
    //   3119: iload 7
    //   3121: aload 4
    //   3123: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3126: return
    //   3127: new 160	java/lang/StringBuilder
    //   3130: dup
    //   3131: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3134: ldc 2
    //   3136: invokevirtual 806	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3139: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3142: ldc_w 808
    //   3145: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3148: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3151: astore_1
    //   3152: new 160	java/lang/StringBuilder
    //   3155: dup
    //   3156: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3159: ldc_w 810
    //   3162: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3165: aload_2
    //   3166: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3169: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3172: ldc_w 812
    //   3175: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3178: astore_2
    //   3179: aload_0
    //   3180: ifnull +22 -> 3202
    //   3183: aload_0
    //   3184: invokevirtual 815	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3187: astore_0
    //   3188: aload_1
    //   3189: iconst_1
    //   3190: aload_2
    //   3191: aload_0
    //   3192: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3195: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3198: invokestatic 817	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3201: return
    //   3202: ldc 119
    //   3204: astore_0
    //   3205: goto -17 -> 3188
    //   3208: aload_2
    //   3209: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3212: sipush -7002
    //   3215: if_icmpne +148 -> 3363
    //   3218: aload_1
    //   3219: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3222: aload_2
    //   3223: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3226: aload_2
    //   3227: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3230: aload_2
    //   3231: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3234: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3237: checkcast 819	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3240: astore_0
    //   3241: aload_0
    //   3242: ifnull +38 -> 3280
    //   3245: aload_0
    //   3246: invokevirtual 820	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3249: aload_1
    //   3250: aload_2
    //   3251: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3254: istore 6
    //   3256: aload_1
    //   3257: aload_2
    //   3258: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3261: istore 7
    //   3263: aload 19
    //   3265: aconst_null
    //   3266: aload_0
    //   3267: invokevirtual 821	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3270: iload 6
    //   3272: iload 7
    //   3274: aload 4
    //   3276: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3279: return
    //   3280: new 160	java/lang/StringBuilder
    //   3283: dup
    //   3284: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3287: ldc 2
    //   3289: invokevirtual 806	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3292: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3295: ldc_w 808
    //   3298: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3301: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3304: astore_1
    //   3305: new 160	java/lang/StringBuilder
    //   3308: dup
    //   3309: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3312: ldc_w 823
    //   3315: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3318: aload_2
    //   3319: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3322: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3325: ldc_w 812
    //   3328: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: astore 4
    //   3333: aload_2
    //   3334: ifnull +23 -> 3357
    //   3337: aload_2
    //   3338: invokevirtual 824	com/tencent/mobileqq/app/message/QQMessageFacade$Message:toString	()Ljava/lang/String;
    //   3341: astore_0
    //   3342: aload_1
    //   3343: iconst_1
    //   3344: aload 4
    //   3346: aload_0
    //   3347: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3350: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3353: invokestatic 817	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3356: return
    //   3357: ldc 119
    //   3359: astore_0
    //   3360: goto -18 -> 3342
    //   3363: aload_2
    //   3364: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3367: sipush -2054
    //   3370: if_icmpne +153 -> 3523
    //   3373: aload_1
    //   3374: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3377: aload_2
    //   3378: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3381: aload_2
    //   3382: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3385: aload_2
    //   3386: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3389: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3392: astore_0
    //   3393: aload_0
    //   3394: instanceof 826
    //   3397: ifeq +42 -> 3439
    //   3400: aload_0
    //   3401: checkcast 826	com/tencent/mobileqq/data/MessageForTroopSign
    //   3404: astore_0
    //   3405: ldc_w 827
    //   3408: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   3411: pop
    //   3412: aload_0
    //   3413: invokevirtual 828	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3416: aload 19
    //   3418: aconst_null
    //   3419: aload_0
    //   3420: invokevirtual 829	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3423: aload_1
    //   3424: aload_2
    //   3425: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3428: aload_1
    //   3429: aload_2
    //   3430: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3433: aload 4
    //   3435: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3438: return
    //   3439: new 160	java/lang/StringBuilder
    //   3442: dup
    //   3443: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3446: ldc 2
    //   3448: invokevirtual 806	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3451: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: ldc_w 831
    //   3457: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3463: astore_1
    //   3464: new 160	java/lang/StringBuilder
    //   3467: dup
    //   3468: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3471: ldc_w 833
    //   3474: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3477: aload_2
    //   3478: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3481: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3484: ldc_w 812
    //   3487: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: astore_2
    //   3491: aload_0
    //   3492: ifnull +25 -> 3517
    //   3495: aload_0
    //   3496: getfield 834	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3499: invokestatic 666	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3502: astore_0
    //   3503: aload_1
    //   3504: iconst_1
    //   3505: aload_2
    //   3506: aload_0
    //   3507: invokevirtual 630	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3510: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3513: invokestatic 817	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3516: return
    //   3517: ldc 119
    //   3519: astore_0
    //   3520: goto -17 -> 3503
    //   3523: aload_2
    //   3524: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3527: sipush -2035
    //   3530: if_icmpne +20 -> 3550
    //   3533: aconst_null
    //   3534: aload_2
    //   3535: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3538: invokestatic 546	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3541: aconst_null
    //   3542: iconst_0
    //   3543: iconst_0
    //   3544: aload 4
    //   3546: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3549: return
    //   3550: aload_2
    //   3551: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3554: sipush -2038
    //   3557: if_icmpne +205 -> 3762
    //   3560: aload_2
    //   3561: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3564: astore_0
    //   3565: getstatic 839	ajed:ai	Ljava/lang/String;
    //   3568: aload_0
    //   3569: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3572: ifeq +4077 -> 7649
    //   3575: aload_2
    //   3576: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3579: astore_0
    //   3580: aload_0
    //   3581: astore 5
    //   3583: getstatic 842	ajed:H	Ljava/lang/String;
    //   3586: aload_0
    //   3587: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3590: ifeq +59 -> 3649
    //   3593: getstatic 839	ajed:ai	Ljava/lang/String;
    //   3596: aload_2
    //   3597: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3600: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3603: ifeq +103 -> 3706
    //   3606: aload_1
    //   3607: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3610: getstatic 839	ajed:ai	Ljava/lang/String;
    //   3613: aload_2
    //   3614: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3617: aload_2
    //   3618: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3621: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3624: checkcast 844	com/tencent/mobileqq/data/MessageForTroopGift
    //   3627: astore 16
    //   3629: aload_0
    //   3630: astore 5
    //   3632: aload 16
    //   3634: ifnull +15 -> 3649
    //   3637: aload 16
    //   3639: invokevirtual 845	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3642: aload 16
    //   3644: getfield 846	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3647: astore 5
    //   3649: aload_1
    //   3650: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3653: aload 5
    //   3655: aload_2
    //   3656: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3659: aload_2
    //   3660: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3663: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3666: astore_0
    //   3667: aload_0
    //   3668: instanceof 844
    //   3671: ifeq +50 -> 3721
    //   3674: aload_0
    //   3675: checkcast 844	com/tencent/mobileqq/data/MessageForTroopGift
    //   3678: astore_0
    //   3679: aload_0
    //   3680: invokevirtual 845	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3683: aload_0
    //   3684: getfield 847	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3687: ifnull +28 -> 3715
    //   3690: aload_0
    //   3691: getfield 847	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3694: astore_0
    //   3695: aconst_null
    //   3696: aload_0
    //   3697: aconst_null
    //   3698: iconst_0
    //   3699: iconst_0
    //   3700: aload 4
    //   3702: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3705: return
    //   3706: aload_2
    //   3707: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3710: astore 5
    //   3712: goto -63 -> 3649
    //   3715: ldc 119
    //   3717: astore_0
    //   3718: goto -23 -> 3695
    //   3721: aload_0
    //   3722: ifnull -3718 -> 4
    //   3725: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3728: ifeq -3724 -> 4
    //   3731: ldc_w 754
    //   3734: iconst_2
    //   3735: new 160	java/lang/StringBuilder
    //   3738: dup
    //   3739: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   3742: ldc_w 849
    //   3745: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3748: aload_0
    //   3749: invokevirtual 815	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3752: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3755: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3758: invokestatic 817	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3761: return
    //   3762: aload_2
    //   3763: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3766: sipush -2036
    //   3769: if_icmpne +48 -> 3817
    //   3772: aload_1
    //   3773: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3776: aload_2
    //   3777: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3780: aload_2
    //   3781: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3784: aload_2
    //   3785: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3788: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3791: checkcast 851	com/tencent/mobileqq/data/MessageForTroopFee
    //   3794: astore_0
    //   3795: aload_0
    //   3796: ifnull -3792 -> 4
    //   3799: aload_0
    //   3800: invokevirtual 852	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3803: aconst_null
    //   3804: aload_0
    //   3805: getfield 853	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3808: aconst_null
    //   3809: iconst_0
    //   3810: iconst_0
    //   3811: aload 4
    //   3813: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3816: return
    //   3817: aload_2
    //   3818: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3821: sipush -2069
    //   3824: if_icmpne +48 -> 3872
    //   3827: aload_1
    //   3828: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3831: aload_2
    //   3832: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3835: aload_2
    //   3836: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3839: aload_2
    //   3840: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3843: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3846: checkcast 855	com/tencent/mobileqq/data/MessageForStarLeague
    //   3849: astore_0
    //   3850: aload_0
    //   3851: ifnull -3847 -> 4
    //   3854: aload_0
    //   3855: invokevirtual 856	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3858: aconst_null
    //   3859: aload_0
    //   3860: getfield 857	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3863: aconst_null
    //   3864: iconst_0
    //   3865: iconst_0
    //   3866: aload 4
    //   3868: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3871: return
    //   3872: aload_2
    //   3873: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3876: sipush -2048
    //   3879: if_icmpne +49 -> 3928
    //   3882: aload_1
    //   3883: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3886: aload_2
    //   3887: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3890: aload_2
    //   3891: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3894: aload_2
    //   3895: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3898: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3901: checkcast 859	com/tencent/mobileqq/data/MessageForTroopReward
    //   3904: astore_0
    //   3905: aload_0
    //   3906: ifnull -3902 -> 4
    //   3909: aload_0
    //   3910: invokevirtual 860	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3913: aload 19
    //   3915: aload_0
    //   3916: getfield 861	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3919: aconst_null
    //   3920: iconst_0
    //   3921: iconst_0
    //   3922: aload 4
    //   3924: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3927: return
    //   3928: aload_2
    //   3929: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3932: iconst_1
    //   3933: if_icmpne +85 -> 4018
    //   3936: aload_2
    //   3937: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3940: sipush -3006
    //   3943: if_icmpne +75 -> 4018
    //   3946: aload_1
    //   3947: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3950: aload_2
    //   3951: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3954: aload_2
    //   3955: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3958: aload_2
    //   3959: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3962: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3965: checkcast 863	com/tencent/mobileqq/data/MessageForPubAccount
    //   3968: astore_0
    //   3969: aload_0
    //   3970: ifnull -3966 -> 4
    //   3973: aload_0
    //   3974: invokevirtual 864	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3977: aload_1
    //   3978: aload_0
    //   3979: iconst_0
    //   3980: invokestatic 868	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3983: astore_2
    //   3984: aload_0
    //   3985: invokevirtual 871	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3988: ifne +16 -> 4004
    //   3991: aconst_null
    //   3992: astore_0
    //   3993: aload_0
    //   3994: aload_2
    //   3995: aconst_null
    //   3996: iconst_0
    //   3997: iconst_0
    //   3998: aload 4
    //   4000: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4003: return
    //   4004: aload_1
    //   4005: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4008: ldc_w 872
    //   4011: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4014: astore_0
    //   4015: goto -22 -> 3993
    //   4018: aload_2
    //   4019: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4022: sipush -1034
    //   4025: if_icmpne +106 -> 4131
    //   4028: new 874	com/tencent/mobileqq/data/MessageForRichState
    //   4031: dup
    //   4032: invokespecial 875	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   4035: astore_0
    //   4036: aload_0
    //   4037: aload_2
    //   4038: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4041: putfield 876	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   4044: aload_0
    //   4045: invokevirtual 877	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   4048: new 160	java/lang/StringBuilder
    //   4051: dup
    //   4052: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4055: astore_1
    //   4056: aload_0
    //   4057: getfield 880	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4060: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4063: ifne +38 -> 4101
    //   4066: aload_1
    //   4067: aload_0
    //   4068: getfield 880	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4071: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4074: pop
    //   4075: aload_0
    //   4076: getfield 883	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4079: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4082: ifne +12 -> 4094
    //   4085: aload_1
    //   4086: aload_0
    //   4087: getfield 883	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4090: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4093: pop
    //   4094: aload_1
    //   4095: bipush 32
    //   4097: invokevirtual 886	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   4100: pop
    //   4101: aload_1
    //   4102: aload_0
    //   4103: invokevirtual 889	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   4106: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4109: pop
    //   4110: aload_1
    //   4111: invokevirtual 890	java/lang/StringBuilder:length	()I
    //   4114: ifle -4110 -> 4
    //   4117: aconst_null
    //   4118: aload_1
    //   4119: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4122: aconst_null
    //   4123: iconst_0
    //   4124: iconst_0
    //   4125: aload 4
    //   4127: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4130: return
    //   4131: aload_2
    //   4132: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4135: sipush -2074
    //   4138: if_icmpne +47 -> 4185
    //   4141: new 892	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4144: dup
    //   4145: invokespecial 893	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4148: astore_0
    //   4149: aload_0
    //   4150: aload_2
    //   4151: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4154: putfield 894	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4157: aload_0
    //   4158: invokevirtual 895	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4161: aload_0
    //   4162: getfield 898	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4165: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4168: ifne -4164 -> 4
    //   4171: aconst_null
    //   4172: aload_0
    //   4173: getfield 898	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4176: aconst_null
    //   4177: iconst_0
    //   4178: iconst_0
    //   4179: aload 4
    //   4181: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4184: return
    //   4185: aload_2
    //   4186: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4189: sipush -1019
    //   4192: if_icmpne +48 -> 4240
    //   4195: aconst_null
    //   4196: aconst_null
    //   4197: new 160	java/lang/StringBuilder
    //   4200: dup
    //   4201: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4204: ldc_w 899
    //   4207: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   4210: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4213: aload_2
    //   4214: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4217: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4220: ldc_w 900
    //   4223: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   4226: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4229: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4232: iconst_0
    //   4233: iconst_0
    //   4234: aload 4
    //   4236: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4239: return
    //   4240: aload_2
    //   4241: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4244: sipush -1018
    //   4247: if_icmpne +48 -> 4295
    //   4250: aconst_null
    //   4251: aconst_null
    //   4252: new 160	java/lang/StringBuilder
    //   4255: dup
    //   4256: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4259: ldc_w 901
    //   4262: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   4265: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4268: aload_2
    //   4269: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4272: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4275: ldc_w 902
    //   4278: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   4281: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4284: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4287: iconst_0
    //   4288: iconst_0
    //   4289: aload 4
    //   4291: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4294: return
    //   4295: aload_2
    //   4296: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4299: sipush -2019
    //   4302: if_icmpne +16 -> 4318
    //   4305: aload 4
    //   4307: aload_0
    //   4308: ldc_w 903
    //   4311: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4314: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4317: return
    //   4318: aload_2
    //   4319: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4322: sipush -7006
    //   4325: if_icmpne +16 -> 4341
    //   4328: aload 4
    //   4330: aload_0
    //   4331: ldc_w 904
    //   4334: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4337: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4340: return
    //   4341: aload_2
    //   4342: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4345: sipush -1026
    //   4348: if_icmpne +16 -> 4364
    //   4351: aload 4
    //   4353: aload_0
    //   4354: ldc_w 905
    //   4357: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4360: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4363: return
    //   4364: aload_2
    //   4365: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4368: sipush -1027
    //   4371: if_icmpne +16 -> 4387
    //   4374: aload 4
    //   4376: aload_0
    //   4377: ldc_w 906
    //   4380: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4383: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4386: return
    //   4387: aload_2
    //   4388: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4391: sipush -2005
    //   4394: if_icmpne +56 -> 4450
    //   4397: aload_1
    //   4398: aload_2
    //   4399: invokestatic 909	apck:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4402: astore 5
    //   4404: aload_1
    //   4405: aload_2
    //   4406: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   4409: istore 6
    //   4411: aload_1
    //   4412: aload_2
    //   4413: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   4416: istore 7
    //   4418: aload 19
    //   4420: aload_0
    //   4421: ldc_w 910
    //   4424: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4427: aconst_null
    //   4428: iload 6
    //   4430: iload 7
    //   4432: aload 4
    //   4434: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4437: aload 5
    //   4439: ifnull -4435 -> 4
    //   4442: aload 4
    //   4444: aload 5
    //   4446: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4449: return
    //   4450: aload_2
    //   4451: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4454: sipush -2022
    //   4457: if_icmpeq +13 -> 4470
    //   4460: aload_2
    //   4461: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4464: sipush -2071
    //   4467: if_icmpne +691 -> 5158
    //   4470: iconst_0
    //   4471: istore 7
    //   4473: iconst_0
    //   4474: istore 10
    //   4476: aload_1
    //   4477: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   4480: aload_2
    //   4481: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4484: aload_2
    //   4485: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4488: aload_2
    //   4489: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4492: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4495: astore 5
    //   4497: aload 5
    //   4499: instanceof 912
    //   4502: ifeq -4498 -> 4
    //   4505: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4508: ifeq +33 -> 4541
    //   4511: ldc_w 437
    //   4514: iconst_2
    //   4515: new 160	java/lang/StringBuilder
    //   4518: dup
    //   4519: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4522: ldc_w 914
    //   4525: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4528: aload_2
    //   4529: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4532: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4535: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4538: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4541: aload 5
    //   4543: checkcast 912	com/tencent/mobileqq/data/MessageForShortVideo
    //   4546: astore 16
    //   4548: aload 16
    //   4550: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4553: sipush 1005
    //   4556: if_icmpeq +60 -> 4616
    //   4559: aload_2
    //   4560: getfield 918	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   4563: ldc_w 625
    //   4566: if_icmpeq +50 -> 4616
    //   4569: aload 16
    //   4571: getfield 921	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4574: ifne +14 -> 4588
    //   4577: aload 16
    //   4579: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4582: sipush 1004
    //   4585: if_icmpeq +31 -> 4616
    //   4588: iload 7
    //   4590: istore 6
    //   4592: aload 16
    //   4594: getfield 921	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4597: iconst_1
    //   4598: if_icmpne +37 -> 4635
    //   4601: iload 7
    //   4603: istore 6
    //   4605: aload 16
    //   4607: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4610: sipush 1004
    //   4613: if_icmpne +22 -> 4635
    //   4616: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4619: ifeq +13 -> 4632
    //   4622: ldc_w 437
    //   4625: iconst_2
    //   4626: ldc_w 923
    //   4629: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4632: iconst_1
    //   4633: istore 6
    //   4635: aload_2
    //   4636: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4639: astore 5
    //   4641: aload_2
    //   4642: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4645: aload_2
    //   4646: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   4649: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   4652: ifeq +9 -> 4661
    //   4655: aload_2
    //   4656: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4659: astore 5
    //   4661: aload_1
    //   4662: invokevirtual 582	com/tencent/mobileqq/app/QQAppInterface:a	()Laxvo;
    //   4665: aload 5
    //   4667: aload_2
    //   4668: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   4671: invokevirtual 587	axvo:a	(Ljava/lang/String;J)Lbaky;
    //   4674: astore_1
    //   4675: aload 16
    //   4677: getfield 926	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4680: ifnull +328 -> 5008
    //   4683: ldc 119
    //   4685: aload 16
    //   4687: getfield 926	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4690: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4693: ifne +315 -> 5008
    //   4696: aload_2
    //   4697: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4700: ifeq +308 -> 5008
    //   4703: aload_1
    //   4704: ifnonnull +304 -> 5008
    //   4707: aload 16
    //   4709: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4712: sipush 1003
    //   4715: if_icmpeq +293 -> 5008
    //   4718: aload 16
    //   4720: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4723: sipush 1004
    //   4726: if_icmpeq +282 -> 5008
    //   4729: aload 16
    //   4731: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4734: sipush 2003
    //   4737: if_icmpeq +271 -> 5008
    //   4740: aload 16
    //   4742: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4745: sipush 2009
    //   4748: if_icmpeq +260 -> 5008
    //   4751: aload 16
    //   4753: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4756: sipush 2002
    //   4759: if_icmpeq +249 -> 5008
    //   4762: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4765: ifeq +13 -> 4778
    //   4768: ldc_w 437
    //   4771: iconst_2
    //   4772: ldc_w 928
    //   4775: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4778: iconst_1
    //   4779: istore 7
    //   4781: iload 7
    //   4783: istore 6
    //   4785: iload 10
    //   4787: istore 7
    //   4789: aload_2
    //   4790: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4793: ifeq +81 -> 4874
    //   4796: aload 16
    //   4798: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4801: sipush 1001
    //   4804: if_icmpeq +51 -> 4855
    //   4807: aload 16
    //   4809: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4812: sipush 1002
    //   4815: if_icmpeq +40 -> 4855
    //   4818: aload 16
    //   4820: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4823: sipush 998
    //   4826: if_icmpeq +29 -> 4855
    //   4829: aload 16
    //   4831: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4834: sipush 999
    //   4837: if_icmpeq +18 -> 4855
    //   4840: iload 10
    //   4842: istore 7
    //   4844: aload 16
    //   4846: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4849: sipush 1000
    //   4852: if_icmpne +22 -> 4874
    //   4855: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4858: ifeq +13 -> 4871
    //   4861: ldc_w 437
    //   4864: iconst_2
    //   4865: ldc_w 930
    //   4868: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4871: iconst_1
    //   4872: istore 7
    //   4874: aload 16
    //   4876: instanceof 932
    //   4879: ifeq +235 -> 5114
    //   4882: aload_0
    //   4883: ldc_w 933
    //   4886: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   4889: astore_0
    //   4890: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4893: ifeq +101 -> 4994
    //   4896: ldc_w 437
    //   4899: iconst_2
    //   4900: new 160	java/lang/StringBuilder
    //   4903: dup
    //   4904: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4907: ldc_w 935
    //   4910: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4913: aload 16
    //   4915: getfield 926	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4918: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4921: ldc_w 937
    //   4924: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4927: aload 16
    //   4929: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4932: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4935: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4938: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4941: aload_1
    //   4942: ifnonnull +203 -> 5145
    //   4945: ldc_w 437
    //   4948: iconst_2
    //   4949: ldc_w 939
    //   4952: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4955: ldc_w 437
    //   4958: iconst_2
    //   4959: new 160	java/lang/StringBuilder
    //   4962: dup
    //   4963: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   4966: ldc_w 941
    //   4969: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4972: iload 6
    //   4974: invokevirtual 944	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4977: ldc_w 946
    //   4980: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4983: iload 7
    //   4985: invokevirtual 944	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4988: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4991: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4994: aload 19
    //   4996: aload_0
    //   4997: aconst_null
    //   4998: iload 6
    //   5000: iload 7
    //   5002: aload 4
    //   5004: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5007: return
    //   5008: iload 6
    //   5010: istore 7
    //   5012: aload_2
    //   5013: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5016: ifeq -235 -> 4781
    //   5019: iload 6
    //   5021: istore 7
    //   5023: aload 16
    //   5025: instanceof 932
    //   5028: ifeq -247 -> 4781
    //   5031: iload 6
    //   5033: istore 7
    //   5035: aload 16
    //   5037: getfield 926	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5040: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5043: ifeq -262 -> 4781
    //   5046: iload 6
    //   5048: istore 7
    //   5050: aload_1
    //   5051: ifnonnull -270 -> 4781
    //   5054: aload 16
    //   5056: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5059: sipush 1004
    //   5062: if_icmpeq +18 -> 5080
    //   5065: iload 6
    //   5067: istore 7
    //   5069: aload 16
    //   5071: getfield 917	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5074: sipush 1001
    //   5077: if_icmpne -296 -> 4781
    //   5080: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5083: ifeq +13 -> 5096
    //   5086: ldc_w 437
    //   5089: iconst_2
    //   5090: ldc_w 948
    //   5093: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5096: iconst_1
    //   5097: istore 7
    //   5099: goto -318 -> 4781
    //   5102: astore 5
    //   5104: aconst_null
    //   5105: astore_1
    //   5106: aload 5
    //   5108: invokevirtual 462	java/lang/Exception:printStackTrace	()V
    //   5111: goto -326 -> 4785
    //   5114: aload 16
    //   5116: getfield 921	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   5119: iconst_2
    //   5120: if_icmpne +14 -> 5134
    //   5123: aload_0
    //   5124: ldc_w 949
    //   5127: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5130: astore_0
    //   5131: goto -241 -> 4890
    //   5134: aload_0
    //   5135: ldc_w 950
    //   5138: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5141: astore_0
    //   5142: goto -252 -> 4890
    //   5145: ldc_w 437
    //   5148: iconst_2
    //   5149: ldc_w 952
    //   5152: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5155: goto -200 -> 4955
    //   5158: aload_2
    //   5159: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5162: sipush -5002
    //   5165: if_icmpne +40 -> 5205
    //   5168: new 954	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5171: dup
    //   5172: invokespecial 955	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5175: astore_0
    //   5176: aload_0
    //   5177: aload_2
    //   5178: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5181: putfield 956	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5184: aload_0
    //   5185: invokevirtual 957	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5188: aload_0
    //   5189: getfield 958	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5192: ifnull -5188 -> 4
    //   5195: aload 4
    //   5197: aload_0
    //   5198: getfield 958	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5201: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5204: return
    //   5205: aload_2
    //   5206: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5209: sipush -2029
    //   5212: if_icmpne +145 -> 5357
    //   5215: aload_1
    //   5216: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5219: aload_2
    //   5220: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5223: aload_2
    //   5224: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5227: aload_2
    //   5228: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5231: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5234: astore_0
    //   5235: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5238: ifeq +30 -> 5268
    //   5241: ldc_w 437
    //   5244: iconst_2
    //   5245: new 160	java/lang/StringBuilder
    //   5248: dup
    //   5249: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5252: ldc_w 960
    //   5255: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5258: aload_0
    //   5259: invokevirtual 630	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5262: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5265: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5268: aload_0
    //   5269: instanceof 962
    //   5272: ifeq -5268 -> 4
    //   5275: aload_0
    //   5276: checkcast 962	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5279: astore_0
    //   5280: aload_0
    //   5281: aload_2
    //   5282: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5285: putfield 963	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5288: aload_0
    //   5289: invokevirtual 964	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5292: aload_0
    //   5293: aload_1
    //   5294: aload_1
    //   5295: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5298: aconst_null
    //   5299: invokevirtual 968	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5302: aload_0
    //   5303: getfield 970	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5306: ifnull -5302 -> 4
    //   5309: aload_0
    //   5310: getfield 973	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5313: iconst_1
    //   5314: if_icmpne +33 -> 5347
    //   5317: aload_0
    //   5318: new 160	java/lang/StringBuilder
    //   5321: dup
    //   5322: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5325: ldc_w 974
    //   5328: invokestatic 362	ajjy:a	(I)Ljava/lang/String;
    //   5331: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5334: aload_0
    //   5335: getfield 970	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5338: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5341: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5344: putfield 970	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5347: aload 4
    //   5349: aload_0
    //   5350: getfield 970	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5353: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5356: return
    //   5357: aload_2
    //   5358: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5361: sipush -2025
    //   5364: if_icmpeq +13 -> 5377
    //   5367: aload_2
    //   5368: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5371: sipush -2072
    //   5374: if_icmpne +13 -> 5387
    //   5377: aload 4
    //   5379: aload_2
    //   5380: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5383: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5386: return
    //   5387: aload_2
    //   5388: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5391: sipush -2076
    //   5394: if_icmpne +58 -> 5452
    //   5397: new 976	com/tencent/mobileqq/data/MessageForLocationShare
    //   5400: dup
    //   5401: invokespecial 977	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5404: astore_1
    //   5405: aload_1
    //   5406: aload_2
    //   5407: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5410: putfield 978	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5413: aload_1
    //   5414: invokevirtual 979	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5417: aload_1
    //   5418: getfield 980	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5421: astore_2
    //   5422: aload_2
    //   5423: astore_1
    //   5424: aload_2
    //   5425: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5428: ifeq +11 -> 5439
    //   5431: aload_0
    //   5432: ldc_w 981
    //   5435: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5438: astore_1
    //   5439: aload 19
    //   5441: ldc 119
    //   5443: aload_1
    //   5444: iconst_0
    //   5445: iconst_0
    //   5446: aload 4
    //   5448: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5451: return
    //   5452: aload_2
    //   5453: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5456: sipush -2052
    //   5459: if_icmpne +75 -> 5534
    //   5462: aload_2
    //   5463: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5466: astore_0
    //   5467: aload_2
    //   5468: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5471: aload_2
    //   5472: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5475: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   5478: ifeq +8 -> 5486
    //   5481: aload_2
    //   5482: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5485: astore_0
    //   5486: aload_1
    //   5487: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5490: aload_0
    //   5491: aload_2
    //   5492: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5495: aload_2
    //   5496: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5499: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5502: astore_0
    //   5503: aload_0
    //   5504: instanceof 983
    //   5507: ifeq -5503 -> 4
    //   5510: aload_0
    //   5511: checkcast 983	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5514: astore_0
    //   5515: aload_0
    //   5516: invokevirtual 984	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5519: aload 19
    //   5521: aload_0
    //   5522: invokevirtual 985	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5525: aconst_null
    //   5526: iconst_0
    //   5527: iconst_0
    //   5528: aload 4
    //   5530: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5533: return
    //   5534: aload_2
    //   5535: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5538: sipush -2047
    //   5541: if_icmpne +51 -> 5592
    //   5544: new 987	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5547: dup
    //   5548: invokespecial 988	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5551: astore_0
    //   5552: aload_0
    //   5553: aload_2
    //   5554: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5557: putfield 989	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5560: aload_0
    //   5561: invokevirtual 990	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5564: aload_0
    //   5565: invokevirtual 991	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5568: astore_0
    //   5569: aload_0
    //   5570: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5573: ifne +10 -> 5583
    //   5576: aload 4
    //   5578: aload_0
    //   5579: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5582: return
    //   5583: aload 4
    //   5585: ldc_w 993
    //   5588: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5591: return
    //   5592: aload_2
    //   5593: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5596: sipush -2040
    //   5599: if_icmpne +29 -> 5628
    //   5602: new 995	com/tencent/mobileqq/data/MessageForApproval
    //   5605: dup
    //   5606: invokespecial 996	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5609: astore_0
    //   5610: aload_0
    //   5611: aload_2
    //   5612: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   5615: putfield 997	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5618: aload 4
    //   5620: aload_0
    //   5621: invokevirtual 1000	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5624: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5627: return
    //   5628: aload_2
    //   5629: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5632: sipush -2041
    //   5635: if_icmpne +49 -> 5684
    //   5638: aload_0
    //   5639: ldc_w 1001
    //   5642: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5645: astore_1
    //   5646: aload_0
    //   5647: ldc_w 1002
    //   5650: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5653: astore_0
    //   5654: aload 4
    //   5656: new 160	java/lang/StringBuilder
    //   5659: dup
    //   5660: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   5663: aload_1
    //   5664: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5667: ldc_w 473
    //   5670: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5673: aload_0
    //   5674: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5677: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5680: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5683: return
    //   5684: aload_2
    //   5685: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5688: sipush -7001
    //   5691: if_icmpne +157 -> 5848
    //   5694: aload_2
    //   5695: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5698: astore 5
    //   5700: aload_2
    //   5701: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5704: aload_2
    //   5705: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5708: invokestatic 579	akbm:a	(Ljava/lang/String;I)Z
    //   5711: ifeq +9 -> 5720
    //   5714: aload_2
    //   5715: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5718: astore 5
    //   5720: aload_1
    //   5721: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5724: aload 5
    //   5726: aload_2
    //   5727: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   5730: aload_2
    //   5731: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   5734: invokevirtual 505	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5737: checkcast 1004	com/tencent/mobileqq/data/MessageForScribble
    //   5740: astore_1
    //   5741: aload_1
    //   5742: invokevirtual 1005	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5745: ifeq +56 -> 5801
    //   5748: aload_1
    //   5749: getfield 1008	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5752: istore_3
    //   5753: iload_3
    //   5754: iconst_2
    //   5755: if_icmpne +29 -> 5784
    //   5758: iconst_1
    //   5759: istore 7
    //   5761: iconst_0
    //   5762: istore 6
    //   5764: aload 19
    //   5766: aload_0
    //   5767: ldc_w 1009
    //   5770: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   5773: aconst_null
    //   5774: iload 7
    //   5776: iload 6
    //   5778: aload 4
    //   5780: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5783: return
    //   5784: aload_1
    //   5785: getfield 1008	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5788: iconst_3
    //   5789: if_icmpne +1851 -> 7640
    //   5792: iconst_1
    //   5793: istore 6
    //   5795: iconst_0
    //   5796: istore 7
    //   5798: goto -34 -> 5764
    //   5801: aload_1
    //   5802: getfield 1012	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5805: iconst_2
    //   5806: if_icmpne +1834 -> 7640
    //   5809: aload_1
    //   5810: invokestatic 1017	avhd:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5813: istore_3
    //   5814: getstatic 1019	avhd:c	I
    //   5817: istore 8
    //   5819: iload_3
    //   5820: iload 8
    //   5822: if_icmpeq +1818 -> 7640
    //   5825: iconst_1
    //   5826: istore 7
    //   5828: iconst_0
    //   5829: istore 6
    //   5831: goto -67 -> 5764
    //   5834: astore_1
    //   5835: aload_1
    //   5836: invokevirtual 462	java/lang/Exception:printStackTrace	()V
    //   5839: iconst_0
    //   5840: istore 6
    //   5842: iconst_0
    //   5843: istore 7
    //   5845: goto -81 -> 5764
    //   5848: aload_1
    //   5849: aload_2
    //   5850: invokestatic 1022	ascj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   5853: ifeq +18 -> 5871
    //   5856: aload 19
    //   5858: aload_2
    //   5859: invokevirtual 1026	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5862: aconst_null
    //   5863: iconst_0
    //   5864: iconst_0
    //   5865: aload 4
    //   5867: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5870: return
    //   5871: aload_2
    //   5872: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5875: ifnonnull +11 -> 5886
    //   5878: aload 4
    //   5880: ldc 119
    //   5882: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5885: return
    //   5886: aload_2
    //   5887: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5890: sipush -5003
    //   5893: if_icmpne +13 -> 5906
    //   5896: aload 4
    //   5898: aload_2
    //   5899: invokevirtual 1026	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5902: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5905: return
    //   5906: aload_2
    //   5907: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5910: sipush -2033
    //   5913: if_icmpne +16 -> 5929
    //   5916: aconst_null
    //   5917: getstatic 1031	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   5920: aconst_null
    //   5921: iconst_0
    //   5922: iconst_0
    //   5923: aload 4
    //   5925: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5928: return
    //   5929: aload_2
    //   5930: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5933: sipush -2049
    //   5936: if_icmpne +16 -> 5952
    //   5939: aload 4
    //   5941: aload_2
    //   5942: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5945: invokestatic 546	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5948: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5951: return
    //   5952: aload_2
    //   5953: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   5956: sipush -1035
    //   5959: if_icmpne +287 -> 6246
    //   5962: iconst_0
    //   5963: istore 10
    //   5965: iconst_0
    //   5966: istore 11
    //   5968: iload 10
    //   5970: istore 6
    //   5972: iload 11
    //   5974: istore 7
    //   5976: aload_2
    //   5977: invokevirtual 520	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5980: ifeq +31 -> 6011
    //   5983: aload_2
    //   5984: getfield 918	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   5987: ldc_w 1032
    //   5990: if_icmpne +171 -> 6161
    //   5993: aload_1
    //   5994: invokevirtual 1035	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   5997: aload_2
    //   5998: invokevirtual 1038	awao:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6001: ifne +150 -> 6151
    //   6004: iconst_1
    //   6005: istore 6
    //   6007: iload 11
    //   6009: istore 7
    //   6011: aload_2
    //   6012: invokevirtual 1026	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6015: astore_0
    //   6016: aload_2
    //   6017: invokestatic 1041	azks:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6020: ifeq +1617 -> 7637
    //   6023: aload_2
    //   6024: invokestatic 1043	azks:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6027: ifne +7 -> 6034
    //   6030: aload_2
    //   6031: invokestatic 1046	azks:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6034: aload_2
    //   6035: invokestatic 1049	azks:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6038: astore_1
    //   6039: aload_1
    //   6040: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6043: ifne +1594 -> 7637
    //   6046: aload_1
    //   6047: astore_0
    //   6048: aload_2
    //   6049: getfield 1052	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6052: ifnull +177 -> 6229
    //   6055: aload_0
    //   6056: ifnull +173 -> 6229
    //   6059: new 160	java/lang/StringBuilder
    //   6062: dup
    //   6063: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6066: astore_1
    //   6067: aload 19
    //   6069: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6072: ifne +16 -> 6088
    //   6075: aload_1
    //   6076: aload 19
    //   6078: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6081: ldc_w 367
    //   6084: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6087: pop
    //   6088: aload_2
    //   6089: invokestatic 495	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6092: ifne +16 -> 6108
    //   6095: iload 6
    //   6097: ifeq +89 -> 6186
    //   6100: aload_1
    //   6101: ldc_w 744
    //   6104: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6107: pop
    //   6108: aload_0
    //   6109: instanceof 746
    //   6112: ifeq +90 -> 6202
    //   6115: aload_0
    //   6116: checkcast 746	axkd
    //   6119: aload_1
    //   6120: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6123: iconst_1
    //   6124: iconst_0
    //   6125: newarray int
    //   6127: invokevirtual 749	axkd:a	(Ljava/lang/String;Z[I)Laxkd;
    //   6130: astore_0
    //   6131: aload 4
    //   6133: iconst_1
    //   6134: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6137: aload 19
    //   6139: aload_0
    //   6140: aconst_null
    //   6141: iload 6
    //   6143: iload 7
    //   6145: aload 4
    //   6147: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6150: return
    //   6151: iconst_1
    //   6152: istore 7
    //   6154: iload 10
    //   6156: istore 6
    //   6158: goto -147 -> 6011
    //   6161: iconst_0
    //   6162: istore 7
    //   6164: aload_2
    //   6165: getfield 918	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   6168: ldc_w 625
    //   6171: if_icmpne +9 -> 6180
    //   6174: iconst_1
    //   6175: istore 6
    //   6177: goto -166 -> 6011
    //   6180: iconst_0
    //   6181: istore 6
    //   6183: goto -6 -> 6177
    //   6186: iload 7
    //   6188: ifeq -80 -> 6108
    //   6191: aload_1
    //   6192: ldc_w 752
    //   6195: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6198: pop
    //   6199: goto -91 -> 6108
    //   6202: aload_1
    //   6203: aload_0
    //   6204: invokevirtual 1055	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6207: pop
    //   6208: new 1057	android/text/SpannableString
    //   6211: dup
    //   6212: aload_1
    //   6213: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6216: invokespecial 1060	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6219: astore_0
    //   6220: aload 4
    //   6222: iconst_0
    //   6223: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6226: goto -89 -> 6137
    //   6229: aload 19
    //   6231: aload_0
    //   6232: invokestatic 1063	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6235: aconst_null
    //   6236: iload 6
    //   6238: iload 7
    //   6240: aload 4
    //   6242: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6245: return
    //   6246: aload_2
    //   6247: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6250: sipush -2057
    //   6253: if_icmpne +17 -> 6270
    //   6256: aload 19
    //   6258: getstatic 1068	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6261: aconst_null
    //   6262: iconst_0
    //   6263: iconst_0
    //   6264: aload 4
    //   6266: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6269: return
    //   6270: aload_2
    //   6271: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6274: sipush -1012
    //   6277: if_icmpne +70 -> 6347
    //   6280: aload_2
    //   6281: invokevirtual 1026	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6284: invokeinterface 1071 1 0
    //   6289: invokestatic 546	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6292: astore_1
    //   6293: aload_0
    //   6294: ldc_w 1072
    //   6297: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6300: astore_2
    //   6301: aload_1
    //   6302: invokevirtual 204	java/lang/String:length	()I
    //   6305: aload_2
    //   6306: invokevirtual 204	java/lang/String:length	()I
    //   6309: isub
    //   6310: iconst_1
    //   6311: isub
    //   6312: istore_3
    //   6313: aload_1
    //   6314: astore_0
    //   6315: aload_1
    //   6316: aload_2
    //   6317: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6320: ifeq +16 -> 6336
    //   6323: aload_1
    //   6324: astore_0
    //   6325: iload_3
    //   6326: ifle +10 -> 6336
    //   6329: aload_1
    //   6330: iconst_0
    //   6331: iload_3
    //   6332: invokevirtual 295	java/lang/String:substring	(II)Ljava/lang/String;
    //   6335: astore_0
    //   6336: aconst_null
    //   6337: aload_0
    //   6338: aconst_null
    //   6339: iconst_0
    //   6340: iconst_0
    //   6341: aload 4
    //   6343: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6346: return
    //   6347: aload_2
    //   6348: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6351: sipush -2059
    //   6354: if_icmpne +33 -> 6387
    //   6357: new 1074	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6360: dup
    //   6361: invokespecial 1075	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6364: astore_0
    //   6365: aload_0
    //   6366: aload_2
    //   6367: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6370: putfield 1076	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6373: aload_0
    //   6374: invokevirtual 1079	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6377: aload 4
    //   6379: aload_0
    //   6380: invokevirtual 1080	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6383: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6386: return
    //   6387: aload_2
    //   6388: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6391: sipush -2066
    //   6394: if_icmpne +87 -> 6481
    //   6397: new 1082	com/tencent/mobileqq/data/MessageForConfessCard
    //   6400: dup
    //   6401: invokespecial 1083	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6404: astore_0
    //   6405: aload_0
    //   6406: aload_2
    //   6407: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6410: putfield 1084	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6413: aload_0
    //   6414: invokevirtual 1085	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6417: aload_2
    //   6418: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6421: sipush 1032
    //   6424: if_icmpne +18 -> 6442
    //   6427: aload 19
    //   6429: aload_0
    //   6430: getfield 1088	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6433: aconst_null
    //   6434: iconst_0
    //   6435: iconst_0
    //   6436: aload 4
    //   6438: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6441: return
    //   6442: ldc 119
    //   6444: new 160	java/lang/StringBuilder
    //   6447: dup
    //   6448: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6451: aload 19
    //   6453: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6456: ldc_w 1090
    //   6459: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6462: aload_0
    //   6463: getfield 1088	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6466: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6469: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6472: aconst_null
    //   6473: iconst_0
    //   6474: iconst_0
    //   6475: aload 4
    //   6477: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6480: return
    //   6481: aload_2
    //   6482: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6485: sipush -2067
    //   6488: if_icmpne +38 -> 6526
    //   6491: new 1092	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6494: dup
    //   6495: invokespecial 1093	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6498: astore_0
    //   6499: aload_0
    //   6500: aload_2
    //   6501: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6504: putfield 1094	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6507: aload_0
    //   6508: invokevirtual 1095	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6511: aload 19
    //   6513: aload_0
    //   6514: getfield 1096	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6517: aconst_null
    //   6518: iconst_0
    //   6519: iconst_0
    //   6520: aload 4
    //   6522: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6525: return
    //   6526: aload_2
    //   6527: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6530: sipush -5008
    //   6533: if_icmpeq +23 -> 6556
    //   6536: aload_2
    //   6537: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6540: sipush -5016
    //   6543: if_icmpeq +13 -> 6556
    //   6546: aload_2
    //   6547: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6550: sipush -5017
    //   6553: if_icmpne +106 -> 6659
    //   6556: aload_2
    //   6557: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6560: sipush -5016
    //   6563: if_icmpne +64 -> 6627
    //   6566: new 1098	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6569: dup
    //   6570: invokespecial 1099	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6573: astore_0
    //   6574: aload_0
    //   6575: aload_2
    //   6576: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6579: putfield 1100	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6582: aload_0
    //   6583: invokevirtual 1101	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6586: aload 4
    //   6588: aload_0
    //   6589: invokevirtual 1104	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6592: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6595: aload_1
    //   6596: aload_2
    //   6597: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6600: istore 6
    //   6602: aload_1
    //   6603: aload_2
    //   6604: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6607: istore 7
    //   6609: aload 19
    //   6611: aload 4
    //   6613: getfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6616: aconst_null
    //   6617: iload 6
    //   6619: iload 7
    //   6621: aload 4
    //   6623: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6626: return
    //   6627: new 1106	com/tencent/mobileqq/data/MessageForArkApp
    //   6630: dup
    //   6631: invokespecial 1107	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6634: astore_0
    //   6635: aload_0
    //   6636: aload_2
    //   6637: getfield 731	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   6640: putfield 1108	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6643: aload_0
    //   6644: invokevirtual 1109	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6647: aload 4
    //   6649: aload_0
    //   6650: invokevirtual 1110	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6653: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6656: goto -61 -> 6595
    //   6659: aload_1
    //   6660: aload_2
    //   6661: invokestatic 574	bado:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6664: istore 6
    //   6666: aload_1
    //   6667: aload_2
    //   6668: invokestatic 576	bado:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   6671: istore 7
    //   6673: aload_2
    //   6674: getfield 1113	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   6677: lookupswitch	default:+51->6728, 1:+174->6851, 2:+255->6932, 8:+255->6932, 65536:+156->6833, 65538:+237->6914
    //   6729: ldc_w 700
    //   6732: invokevirtual 703	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6735: astore 5
    //   6737: getstatic 708	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   6740: ifeq +295 -> 7035
    //   6743: aload 5
    //   6745: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6748: ifne +287 -> 7035
    //   6751: aload_1
    //   6752: aload_2
    //   6753: aload 4
    //   6755: invokestatic 742	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Laxkd;
    //   6758: astore_0
    //   6759: new 160	java/lang/StringBuilder
    //   6762: dup
    //   6763: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   6766: astore_1
    //   6767: aload 19
    //   6769: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6772: ifne +16 -> 6788
    //   6775: aload_1
    //   6776: aload 19
    //   6778: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6781: ldc_w 367
    //   6784: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6787: pop
    //   6788: aload_2
    //   6789: invokestatic 495	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6792: ifne +16 -> 6808
    //   6795: iload 6
    //   6797: ifeq +222 -> 7019
    //   6800: aload_1
    //   6801: ldc_w 744
    //   6804: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6807: pop
    //   6808: aload 19
    //   6810: aload_0
    //   6811: aload_1
    //   6812: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6815: iconst_1
    //   6816: iconst_0
    //   6817: newarray int
    //   6819: invokevirtual 749	axkd:a	(Ljava/lang/String;Z[I)Laxkd;
    //   6822: aconst_null
    //   6823: iload 6
    //   6825: iload 7
    //   6827: aload 4
    //   6829: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6832: return
    //   6833: aload 19
    //   6835: ldc 119
    //   6837: aload_2
    //   6838: getfield 541	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6841: iload 6
    //   6843: iload 7
    //   6845: aload 4
    //   6847: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6850: return
    //   6851: aload_2
    //   6852: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6855: sipush 1001
    //   6858: if_icmpeq +13 -> 6871
    //   6861: aload_2
    //   6862: getfield 38	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   6865: sipush 10002
    //   6868: if_icmpne +26 -> 6894
    //   6871: aload_2
    //   6872: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   6875: sipush -3001
    //   6878: if_icmpne +16 -> 6894
    //   6881: aload 4
    //   6883: aload_0
    //   6884: ldc_w 1114
    //   6887: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6890: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6893: return
    //   6894: aload 19
    //   6896: aload_0
    //   6897: ldc_w 611
    //   6900: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6903: aconst_null
    //   6904: iload 6
    //   6906: iload 7
    //   6908: aload 4
    //   6910: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6913: return
    //   6914: aload 19
    //   6916: aload_0
    //   6917: ldc_w 611
    //   6920: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6923: aconst_null
    //   6924: iconst_0
    //   6925: iconst_0
    //   6926: aload 4
    //   6928: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6931: return
    //   6932: ldc_w 641
    //   6935: iconst_3
    //   6936: anewarray 4	java/lang/Object
    //   6939: dup
    //   6940: iconst_0
    //   6941: iload_3
    //   6942: invokestatic 666	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6945: aastore
    //   6946: dup
    //   6947: iconst_1
    //   6948: iload 6
    //   6950: invokestatic 646	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6953: aastore
    //   6954: dup
    //   6955: iconst_2
    //   6956: iload 7
    //   6958: invokestatic 646	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6961: aastore
    //   6962: invokestatic 651	amvy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6965: aload_0
    //   6966: ldc_w 631
    //   6969: invokevirtual 208	android/content/Context:getString	(I)Ljava/lang/String;
    //   6972: astore_0
    //   6973: aload_2
    //   6974: getfield 195	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   6977: aload_1
    //   6978: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6981: invokestatic 1117	azzz:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6984: ifeq +22 -> 7006
    //   6987: iload_3
    //   6988: ifeq +18 -> 7006
    //   6991: aload 19
    //   6993: aload_0
    //   6994: ldc 119
    //   6996: iload 6
    //   6998: iload 7
    //   7000: aload 4
    //   7002: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7005: return
    //   7006: aload 19
    //   7008: aload_0
    //   7009: ldc 119
    //   7011: iconst_0
    //   7012: iconst_0
    //   7013: aload 4
    //   7015: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7018: return
    //   7019: iload 7
    //   7021: ifeq -213 -> 6808
    //   7024: aload_1
    //   7025: ldc_w 752
    //   7028: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7031: pop
    //   7032: goto -224 -> 6808
    //   7035: aload_2
    //   7036: invokevirtual 1026	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   7039: astore 5
    //   7041: aload_2
    //   7042: invokestatic 1041	azks:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7045: ifeq +589 -> 7634
    //   7048: aload_2
    //   7049: invokestatic 1043	azks:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7052: ifne +7 -> 7059
    //   7055: aload_2
    //   7056: invokestatic 1046	azks:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   7059: aload_2
    //   7060: invokestatic 1049	azks:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   7063: astore 16
    //   7065: aload 16
    //   7067: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7070: ifne +564 -> 7634
    //   7073: aload 16
    //   7075: astore 5
    //   7077: aload_2
    //   7078: getfield 1052	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   7081: ifnull +389 -> 7470
    //   7084: aload 5
    //   7086: ifnull +384 -> 7470
    //   7089: new 160	java/lang/StringBuilder
    //   7092: dup
    //   7093: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   7096: astore_0
    //   7097: aload 19
    //   7099: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7102: ifne +16 -> 7118
    //   7105: aload_0
    //   7106: aload 19
    //   7108: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7111: ldc_w 367
    //   7114: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7117: pop
    //   7118: aload_2
    //   7119: invokestatic 495	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7122: ifne +16 -> 7138
    //   7125: iload 6
    //   7127: ifeq +299 -> 7426
    //   7130: aload_0
    //   7131: ldc_w 744
    //   7134: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7137: pop
    //   7138: aload 5
    //   7140: instanceof 746
    //   7143: ifeq +299 -> 7442
    //   7146: aload 5
    //   7148: checkcast 746	axkd
    //   7151: aload_0
    //   7152: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7155: iconst_1
    //   7156: iconst_3
    //   7157: newarray int
    //   7159: dup
    //   7160: iconst_0
    //   7161: aload 5
    //   7163: checkcast 746	axkd
    //   7166: getfield 1118	axkd:jdField_a_of_type_Int	I
    //   7169: iastore
    //   7170: dup
    //   7171: iconst_1
    //   7172: bipush 16
    //   7174: iastore
    //   7175: dup
    //   7176: iconst_2
    //   7177: iconst_1
    //   7178: iastore
    //   7179: invokevirtual 749	axkd:a	(Ljava/lang/String;Z[I)Laxkd;
    //   7182: astore_0
    //   7183: aload 4
    //   7185: iconst_1
    //   7186: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7189: aload_2
    //   7190: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7193: sipush -5040
    //   7196: if_icmpne +435 -> 7631
    //   7199: new 160	java/lang/StringBuilder
    //   7202: dup
    //   7203: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   7206: ldc_w 473
    //   7209: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7212: invokestatic 352	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7215: ldc_w 1119
    //   7218: invokevirtual 354	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7221: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7224: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7227: astore 5
    //   7229: aload_0
    //   7230: invokeinterface 1071 1 0
    //   7235: astore 16
    //   7237: aload 16
    //   7239: ifnull +386 -> 7625
    //   7242: aload 16
    //   7244: aload 5
    //   7246: invokevirtual 1122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7249: ifeq +376 -> 7625
    //   7252: aload 16
    //   7254: aload 5
    //   7256: ldc 119
    //   7258: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7261: astore 5
    //   7263: aload 5
    //   7265: astore_0
    //   7266: iload_3
    //   7267: ifne +77 -> 7344
    //   7270: aload_1
    //   7271: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   7274: aload_2
    //   7275: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7278: iconst_0
    //   7279: invokevirtual 1125	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7282: astore 16
    //   7284: aload 5
    //   7286: astore_0
    //   7287: aload 16
    //   7289: instanceof 1127
    //   7292: ifeq +52 -> 7344
    //   7295: aload 5
    //   7297: astore_0
    //   7298: aload 16
    //   7300: checkcast 1127	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7303: getfield 1131	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqax;
    //   7306: ifnull +38 -> 7344
    //   7309: aload 5
    //   7311: astore_0
    //   7312: aload 16
    //   7314: checkcast 1127	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7317: getfield 1131	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqax;
    //   7320: getfield 1135	aqax:b	I
    //   7323: invokestatic 1138	asbg:b	(I)Z
    //   7326: ifeq +18 -> 7344
    //   7329: aload_1
    //   7330: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7333: aload 5
    //   7335: invokeinterface 1071 1 0
    //   7340: invokestatic 1141	ascj:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7343: astore_0
    //   7344: aload_2
    //   7345: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7348: invokestatic 1143	akbm:i	(I)Z
    //   7351: ifeq +271 -> 7622
    //   7354: aload_1
    //   7355: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   7358: aload_2
    //   7359: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7362: iload_3
    //   7363: invokevirtual 1125	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7366: astore_1
    //   7367: aload_1
    //   7368: ifnull +254 -> 7622
    //   7371: aload_1
    //   7372: instanceof 1127
    //   7375: ifeq +247 -> 7622
    //   7378: aload_1
    //   7379: checkcast 1127	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7382: getfield 1131	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqax;
    //   7385: ifnull +237 -> 7622
    //   7388: aload_1
    //   7389: checkcast 1127	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7392: getfield 1131	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Laqax;
    //   7395: getfield 1135	aqax:b	I
    //   7398: ldc_w 1144
    //   7401: if_icmpne +221 -> 7622
    //   7404: aload_1
    //   7405: checkcast 1127	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7408: invokevirtual 1145	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7411: astore_0
    //   7412: aload 19
    //   7414: aload_0
    //   7415: aconst_null
    //   7416: iload 6
    //   7418: iload 7
    //   7420: aload 4
    //   7422: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7425: return
    //   7426: iload 7
    //   7428: ifeq -290 -> 7138
    //   7431: aload_0
    //   7432: ldc_w 752
    //   7435: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7438: pop
    //   7439: goto -301 -> 7138
    //   7442: aload_0
    //   7443: aload 5
    //   7445: invokevirtual 1055	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7448: pop
    //   7449: new 1057	android/text/SpannableString
    //   7452: dup
    //   7453: aload_0
    //   7454: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7457: invokespecial 1060	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7460: astore_0
    //   7461: aload 4
    //   7463: iconst_0
    //   7464: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7467: goto -278 -> 7189
    //   7470: aload 5
    //   7472: ifnull +114 -> 7586
    //   7475: aload 5
    //   7477: invokeinterface 1071 1 0
    //   7482: invokevirtual 188	java/lang/String:trim	()Ljava/lang/String;
    //   7485: astore 5
    //   7487: getstatic 1148	ajed:G	Ljava/lang/String;
    //   7490: aload_2
    //   7491: getfield 35	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7494: invokevirtual 1151	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7497: ifeq +119 -> 7616
    //   7500: aload 5
    //   7502: ifnull +114 -> 7616
    //   7505: aload 5
    //   7507: invokevirtual 204	java/lang/String:length	()I
    //   7510: ifle +106 -> 7616
    //   7513: aload_0
    //   7514: aload_1
    //   7515: aload 5
    //   7517: aload_2
    //   7518: invokestatic 1153	bado:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   7521: astore_0
    //   7522: aload 19
    //   7524: aconst_null
    //   7525: aload_0
    //   7526: iload 6
    //   7528: aload_1
    //   7529: invokevirtual 1035	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   7532: aload_2
    //   7533: invokevirtual 1038	awao:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7536: aload 4
    //   7538: invokestatic 568	bado:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7541: aload_2
    //   7542: getfield 174	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   7545: sipush -1000
    //   7548: if_icmpne +44 -> 7592
    //   7551: aload 4
    //   7553: getfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7556: ifnull +36 -> 7592
    //   7559: aload 4
    //   7561: new 746	axkd
    //   7564: dup
    //   7565: aload 4
    //   7567: getfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7570: iconst_1
    //   7571: bipush 16
    //   7573: invokespecial 1156	axkd:<init>	(Ljava/lang/CharSequence;II)V
    //   7576: putfield 552	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7579: aload 4
    //   7581: iconst_1
    //   7582: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7585: return
    //   7586: aconst_null
    //   7587: astore 5
    //   7589: goto -102 -> 7487
    //   7592: aload 4
    //   7594: iconst_0
    //   7595: putfield 763	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7598: return
    //   7599: astore 5
    //   7601: goto -2495 -> 5106
    //   7604: astore 17
    //   7606: aload 16
    //   7608: astore_1
    //   7609: aload 17
    //   7611: astore 16
    //   7613: goto -6832 -> 781
    //   7616: aload 5
    //   7618: astore_0
    //   7619: goto -97 -> 7522
    //   7622: goto -210 -> 7412
    //   7625: aload_0
    //   7626: astore 5
    //   7628: goto -365 -> 7263
    //   7631: goto -287 -> 7344
    //   7634: goto -557 -> 7077
    //   7637: goto -1589 -> 6048
    //   7640: iconst_0
    //   7641: istore 6
    //   7643: iconst_0
    //   7644: istore 7
    //   7646: goto -1882 -> 5764
    //   7649: goto -4069 -> 3580
    //   7652: iconst_0
    //   7653: istore 6
    //   7655: goto -5301 -> 2354
    //   7658: goto -5387 -> 2271
    //   7661: aload 5
    //   7663: astore_0
    //   7664: goto -5719 -> 1945
    //   7667: iconst_0
    //   7668: istore 7
    //   7670: goto -6680 -> 990
    //   7673: goto -6766 -> 907
    //   7676: aload_1
    //   7677: astore_0
    //   7678: goto -6990 -> 688
    //   7681: iconst_0
    //   7682: istore 6
    //   7684: goto -7117 -> 567
    //   7687: iconst_0
    //   7688: istore 6
    //   7690: goto -7162 -> 528
    //   7693: goto -7244 -> 449
    //   7696: aload 16
    //   7698: astore 5
    //   7700: goto -7582 -> 118
    //   7703: iconst_0
    //   7704: istore 6
    //   7706: goto -7178 -> 528
    //   7709: iconst_1
    //   7710: istore_3
    //   7711: goto -5880 -> 1831
    //   7714: astore_1
    //   7715: aload 17
    //   7717: astore_0
    //   7718: goto -5687 -> 2031
    //   7721: iconst_0
    //   7722: istore 6
    //   7724: goto -5370 -> 2354
    //   7727: ldc2_w 39
    //   7730: lstore 14
    //   7732: goto -5298 -> 2434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7735	0	paramContext	Context
    //   0	7735	1	paramQQAppInterface	QQAppInterface
    //   0	7735	2	paramMessage	QQMessageFacade.Message
    //   0	7735	3	paramInt	int
    //   0	7735	4	paramMsgSummary	MsgSummary
    //   0	7735	5	paramString	String
    //   0	7735	6	paramBoolean1	boolean
    //   0	7735	7	paramBoolean2	boolean
    //   240	5583	8	i	int
    //   1700	522	9	j	int
    //   415	5740	10	bool1	boolean
    //   2225	3783	11	bool2	boolean
    //   1640	543	12	bool3	boolean
    //   1647	546	13	bool4	boolean
    //   512	7219	14	l	long
    //   7	704	16	localObject1	Object
    //   777	5	16	localException1	Exception
    //   788	6909	16	localObject2	Object
    //   427	2236	17	localObject3	Object
    //   7604	112	17	localException2	Exception
    //   418	1880	18	str1	String
    //   202	7321	19	str2	String
    //   2295	256	20	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   423	449	777	java/lang/Exception
    //   449	471	777	java/lang/Exception
    //   1878	1907	2030	java/lang/Exception
    //   1907	1914	2030	java/lang/Exception
    //   1919	1927	2030	java/lang/Exception
    //   1927	1943	2030	java/lang/Exception
    //   2019	2027	2030	java/lang/Exception
    //   2237	2243	2617	java/lang/Exception
    //   2247	2261	2617	java/lang/Exception
    //   2265	2271	2617	java/lang/Exception
    //   2275	2297	2617	java/lang/Exception
    //   2301	2315	2617	java/lang/Exception
    //   2318	2325	2617	java/lang/Exception
    //   2328	2335	2617	java/lang/Exception
    //   2550	2561	2617	java/lang/Exception
    //   2574	2581	2617	java/lang/Exception
    //   2584	2593	2617	java/lang/Exception
    //   2772	2807	2908	java/lang/Throwable
    //   2823	2873	2908	java/lang/Throwable
    //   2878	2903	2908	java/lang/Throwable
    //   4635	4641	5102	java/lang/Exception
    //   4641	4661	5102	java/lang/Exception
    //   4661	4675	5102	java/lang/Exception
    //   5694	5700	5834	java/lang/Exception
    //   5700	5720	5834	java/lang/Exception
    //   5720	5753	5834	java/lang/Exception
    //   5784	5792	5834	java/lang/Exception
    //   5801	5819	5834	java/lang/Exception
    //   4675	4703	7599	java/lang/Exception
    //   4707	4778	7599	java/lang/Exception
    //   5012	5019	7599	java/lang/Exception
    //   5023	5031	7599	java/lang/Exception
    //   5035	5046	7599	java/lang/Exception
    //   5054	5065	7599	java/lang/Exception
    //   5069	5080	7599	java/lang/Exception
    //   5080	5096	7599	java/lang/Exception
    //   475	489	7604	java/lang/Exception
    //   492	499	7604	java/lang/Exception
    //   507	514	7604	java/lang/Exception
    //   710	721	7604	java/lang/Exception
    //   734	741	7604	java/lang/Exception
    //   744	753	7604	java/lang/Exception
    //   1656	1665	7714	java/lang/Exception
    //   1673	1681	7714	java/lang/Exception
    //   1685	1702	7714	java/lang/Exception
    //   1713	1720	7714	java/lang/Exception
    //   1746	1759	7714	java/lang/Exception
    //   1763	1769	7714	java/lang/Exception
    //   1773	1780	7714	java/lang/Exception
    //   1784	1798	7714	java/lang/Exception
    //   1802	1828	7714	java/lang/Exception
    //   1843	1849	7714	java/lang/Exception
    //   1853	1866	7714	java/lang/Exception
    //   1870	1878	7714	java/lang/Exception
    //   1969	1995	7714	java/lang/Exception
    //   2002	2009	7714	java/lang/Exception
    //   2066	2071	7714	java/lang/Exception
    //   2079	2087	7714	java/lang/Exception
    //   2091	2099	7714	java/lang/Exception
    //   2103	2116	7714	java/lang/Exception
    //   2120	2127	7714	java/lang/Exception
    //   2136	2144	7714	java/lang/Exception
    //   2148	2164	7714	java/lang/Exception
    //   2168	2174	7714	java/lang/Exception
    //   2178	2191	7714	java/lang/Exception
    //   2201	2209	7714	java/lang/Exception
    //   2362	2369	7714	java/lang/Exception
    //   2373	2378	7714	java/lang/Exception
    //   2382	2393	7714	java/lang/Exception
    //   2404	2410	7714	java/lang/Exception
    //   2414	2421	7714	java/lang/Exception
    //   2425	2434	7714	java/lang/Exception
    //   2438	2479	7714	java/lang/Exception
    //   2487	2495	7714	java/lang/Exception
    //   2499	2506	7714	java/lang/Exception
    //   2510	2517	7714	java/lang/Exception
    //   2521	2529	7714	java/lang/Exception
    //   2533	2546	7714	java/lang/Exception
    //   2622	2626	7714	java/lang/Exception
    //   2654	2660	7714	java/lang/Exception
    //   2664	2691	7714	java/lang/Exception
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
    if (akbm.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (akbm.c(paramMessage.senderuin)) {
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
          paramQQAppInterface = azjg.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof axoy)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((axoy)paramMessage).f() >= 0) && (((axoy)paramMessage).f() != 100)) {
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
      if ((paramQQAppInterface instanceof axou))
      {
        long l = ((axou)paramQQAppInterface).c();
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
          if (!akbm.a(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (akbm.c(paramMessage.senderuin));
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
      paramQQAppInterface = azjg.a(paramQQAppInterface, paramMessage);
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
 * Qualified Name:     bado
 * JD-Core Version:    0.7.0.1
 */