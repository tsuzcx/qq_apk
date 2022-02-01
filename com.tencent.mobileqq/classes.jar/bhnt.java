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
import com.tencent.mobileqq.data.ChatMessage;
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
import org.jetbrains.annotations.Nullable;

public class bhnt
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
    paramQQAppInterface.status = aunj.b(paramQQAppInterface.status);
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
    paramContext = paramQQAppInterface.a().a(bhki.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131690063);
    }
    return paramQQAppInterface.getApp().getString(2131690065) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131690066);
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
        String str2 = bhjv.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = bhlg.b(paramQQAppInterface, paramMessage.senderuin, true);
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
                  paramContext = paramContext.getString(2131689584);
                  break;
                  paramContext = paramContext.getString(2131689498);
                  break;
                  paramContext = paramContext.getString(2131689497);
                  break;
                  paramContext = paramContext.getString(2131717421);
                  break;
                  paramContext = paramContext.getString(2131689621);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = bhjv.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = bhlg.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return bhjv.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
    paramString = bhjv.a(paramString, paramQQAppInterface);
    paramMessage = bhjv.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = bhlg.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = bhjv.a(paramString, paramMessage, paramQQAppInterface);
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131692941));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131693734));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131717791));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  @Nullable
  private static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    String str = paramString;
    if (nlj.a(paramMessage)) {
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (paramString.equals(bhlg.a(paramQQAppInterface, paramMessage.frienduin, true))) {}
      }
      else
      {
        paramQQAppInterface = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if ((paramQQAppInterface instanceof ChatMessage)) {
          ((ChatMessage)paramQQAppInterface).parse();
        }
        if (paramQQAppInterface != null) {
          paramString = nlj.a(paramQQAppInterface).b;
        }
        str = paramString;
        if (!TextUtils.isEmpty(paramString)) {}
      }
    }
    for (paramQQAppInterface = nlj.a(paramMessage).b;; paramQQAppInterface = str)
    {
      paramString = paramQQAppInterface;
      if (!paramBoolean) {
        if (!paramMessage.isSendFromLocal())
        {
          paramString = paramQQAppInterface;
          if (paramMessage.selfuin != null)
          {
            paramString = paramQQAppInterface;
            if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
          }
        }
        else
        {
          paramString = null;
        }
      }
      if (adak.l(paramMessage.msgtype)) {}
      for (paramQQAppInterface = localObject;; paramQQAppInterface = paramString)
      {
        paramMessage = bgrf.a(paramMessage);
        if (paramMessage != null) {
          paramQQAppInterface = paramMessage.c;
        }
        return b(paramQQAppInterface);
      }
    }
  }
  
  /* Error */
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: ldc 120
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: iconst_2
    //   13: istore 6
    //   15: iload 5
    //   17: iconst_1
    //   18: if_icmpeq +11 -> 29
    //   21: iload 5
    //   23: sipush 5000
    //   26: if_icmpne +6 -> 32
    //   29: iconst_1
    //   30: istore 6
    //   32: aload_1
    //   33: arraylength
    //   34: iconst_1
    //   35: if_icmple +352 -> 387
    //   38: aload_1
    //   39: iconst_1
    //   40: aaload
    //   41: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   44: istore 7
    //   46: iload 7
    //   48: tableswitch	default:+20 -> 68, 13:+148->196
    //   69: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: ldc_w 336
    //   75: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   78: astore_3
    //   79: iload 5
    //   81: iconst_1
    //   82: if_icmpeq +11 -> 93
    //   85: iload 5
    //   87: sipush 5000
    //   90: if_icmpne +14 -> 104
    //   93: aload_2
    //   94: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   97: ldc_w 340
    //   100: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   103: astore_3
    //   104: aload_1
    //   105: arraylength
    //   106: iconst_5
    //   107: if_icmple +302 -> 409
    //   110: aload_1
    //   111: iconst_4
    //   112: aaload
    //   113: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore 5
    //   118: aload_1
    //   119: iconst_5
    //   120: aaload
    //   121: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore 6
    //   126: aload_3
    //   127: astore_1
    //   128: iload 5
    //   130: iconst_2
    //   131: if_icmpne -121 -> 10
    //   134: iload 6
    //   136: iconst_4
    //   137: if_icmpne +216 -> 353
    //   140: aload_0
    //   141: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   144: ldc_w 341
    //   147: invokevirtual 159	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   150: astore_1
    //   151: new 161	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 343
    //   161: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_3
    //   173: aload_0
    //   174: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   177: ldc_w 340
    //   180: invokevirtual 159	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   183: aload_1
    //   184: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   187: areturn
    //   188: astore 9
    //   190: iconst_0
    //   191: istore 7
    //   193: goto -147 -> 46
    //   196: aload 4
    //   198: ifnull +113 -> 311
    //   201: aload_0
    //   202: aload 4
    //   204: aload_3
    //   205: iload 6
    //   207: iconst_0
    //   208: invokestatic 346	bhlg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   211: astore 4
    //   213: aload_2
    //   214: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc_w 336
    //   220: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   223: astore_3
    //   224: iload 5
    //   226: iconst_1
    //   227: if_icmpeq +11 -> 238
    //   230: iload 5
    //   232: sipush 5000
    //   235: if_icmpne +14 -> 249
    //   238: aload_2
    //   239: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   242: ldc_w 340
    //   245: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   248: astore_3
    //   249: aload 4
    //   251: invokevirtual 205	java/lang/String:length	()I
    //   254: bipush 11
    //   256: if_icmple +163 -> 419
    //   259: aload 4
    //   261: iconst_0
    //   262: bipush 10
    //   264: invokevirtual 350	java/lang/String:substring	(II)Ljava/lang/String;
    //   267: astore_2
    //   268: new 161	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   275: aload_2
    //   276: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 352
    //   282: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_2
    //   289: new 161	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   296: aload_2
    //   297: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_3
    //   301: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_3
    //   308: goto -204 -> 104
    //   311: iload 5
    //   313: iconst_1
    //   314: if_icmpeq +11 -> 325
    //   317: iload 5
    //   319: sipush 5000
    //   322: if_icmpne +17 -> 339
    //   325: aload_2
    //   326: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   329: ldc_w 353
    //   332: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   335: astore_3
    //   336: goto -232 -> 104
    //   339: aload_2
    //   340: invokevirtual 335	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   343: ldc_w 354
    //   346: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   349: astore_3
    //   350: goto -246 -> 104
    //   353: iload 6
    //   355: iconst_5
    //   356: if_icmpne +17 -> 373
    //   359: aload_0
    //   360: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   363: ldc_w 355
    //   366: invokevirtual 159	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   369: astore_1
    //   370: goto -219 -> 151
    //   373: aload_0
    //   374: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   377: ldc_w 353
    //   380: invokevirtual 159	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   383: astore_1
    //   384: goto -233 -> 151
    //   387: ldc 120
    //   389: areturn
    //   390: astore_1
    //   391: iconst_0
    //   392: istore 5
    //   394: iload 8
    //   396: istore 6
    //   398: goto -272 -> 126
    //   401: astore_1
    //   402: iload 8
    //   404: istore 6
    //   406: goto -280 -> 126
    //   409: iconst_0
    //   410: istore 5
    //   412: iload 8
    //   414: istore 6
    //   416: goto -290 -> 126
    //   419: aload 4
    //   421: astore_2
    //   422: goto -133 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramQQAppInterface	QQAppInterface
    //   0	425	1	paramArrayOfString	String[]
    //   0	425	2	paramContext	Context
    //   0	425	3	paramString1	String
    //   0	425	4	paramString2	String
    //   0	425	5	paramInt	int
    //   13	402	6	i	int
    //   44	148	7	j	int
    //   1	412	8	k	int
    //   188	1	9	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   38	46	188	java/lang/NumberFormatException
    //   110	118	390	java/lang/Exception
    //   118	126	401	java/lang/Exception
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
            QLog.d("msgSummary", 2, "textSummary: " + bhjx.a(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (paramMessageForPic.picExtraData.isRelatedEmo()) || (aiyz.b(paramMessageForPic)) || (ascj.b(paramMessageForPic)) || (aiti.a(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131691126);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131691126);
  }
  
  public static String a(String paramString)
  {
    String str = anzj.a(2131705865);
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
        localObject3 = anzj.a(2131705874);
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
              paramContext = paramContext.getResources().getString(2131695329);
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
        if (paramContext.getString(2131719201).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695346);
          }
          return paramContext.getResources().getString(2131694771);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695329) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131694757) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131719205).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131695342);
            }
            return paramContext.getResources().getString(2131695341);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131694766);
          }
          return paramContext.getResources().getString(2131694765);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695329) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131694757) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695342);
          }
          return paramContext.getResources().getString(2131695341);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131694766);
        }
        return paramContext.getResources().getString(2131694765);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695342);
          }
          return paramContext.getResources().getString(2131695341);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131694766);
        }
        return paramContext.getResources().getString(2131694765);
        if (j != 0) {
          return paramContext.getResources().getString(2131695343);
        }
        return paramContext.getResources().getString(2131694767);
        if (j != 0) {
          return paramContext.getResources().getString(2131695329);
        }
        return paramContext.getResources().getString(2131694757);
        if (j != 0) {
          return paramContext.getResources().getString(2131695330);
        }
        return paramContext.getResources().getString(2131694759);
        if (j != 0) {
          return paramContext.getResources().getString(2131695345);
        }
        return paramContext.getResources().getString(2131694770);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131719201).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695346);
          }
          return paramContext.getResources().getString(2131694771);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695329) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131694757) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131694757) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131694757);
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
    //   5: aload_1
    //   6: aload_2
    //   7: aload 5
    //   9: iload 6
    //   11: invokestatic 550	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Ljava/lang/String;Z)Ljava/lang/String;
    //   14: astore 19
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: iload_3
    //   20: aload 4
    //   22: aload 19
    //   24: iload 6
    //   26: iload 7
    //   28: invokestatic 553	bhnt:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   31: ifne -27 -> 4
    //   34: aload_2
    //   35: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   38: sipush -2034
    //   41: if_icmpne +16 -> 57
    //   44: aload 4
    //   46: aload_2
    //   47: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   50: invokestatic 561	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   56: return
    //   57: aload_2
    //   58: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   61: sipush -2011
    //   64: if_icmpne +157 -> 221
    //   67: iconst_0
    //   68: istore_3
    //   69: iconst_0
    //   70: istore 8
    //   72: aload_2
    //   73: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   76: sipush -2011
    //   79: if_icmpne +29 -> 108
    //   82: aload_2
    //   83: getfield 570	com/tencent/imcore/message/QQMessageFacade$Message:extInt	I
    //   86: bipush 61
    //   88: if_icmpne +20 -> 108
    //   91: aload_2
    //   92: aload_1
    //   93: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   96: invokevirtual 571	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   99: ldc_w 572
    //   102: invokevirtual 339	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   105: putfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   108: aload_2
    //   109: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   112: iconst_1
    //   113: if_icmpne +73 -> 186
    //   116: aload_1
    //   117: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   120: aload_2
    //   121: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   124: aload_2
    //   125: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   128: aload_2
    //   129: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   132: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   135: astore_0
    //   136: iload 8
    //   138: istore_3
    //   139: aload_0
    //   140: invokestatic 575	axuz:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   143: ifeq +21 -> 164
    //   146: aconst_null
    //   147: aconst_null
    //   148: aload_0
    //   149: checkcast 577	com/tencent/mobileqq/data/MessageForStructing
    //   152: invokestatic 580	axuz:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   155: iconst_0
    //   156: iconst_0
    //   157: aload 4
    //   159: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   162: iconst_1
    //   163: istore_3
    //   164: aload_0
    //   165: invokestatic 586	bgre:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   168: ifeq +18 -> 186
    //   171: iconst_1
    //   172: istore_3
    //   173: aconst_null
    //   174: aconst_null
    //   175: aload_2
    //   176: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   179: iconst_0
    //   180: iconst_0
    //   181: aload 4
    //   183: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   186: iload_3
    //   187: ifne -183 -> 4
    //   190: aload_1
    //   191: aload_2
    //   192: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   195: istore 6
    //   197: aload_1
    //   198: aload_2
    //   199: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   202: istore 7
    //   204: aload 19
    //   206: aconst_null
    //   207: aload_2
    //   208: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   211: iload 6
    //   213: iload 7
    //   215: aload 4
    //   217: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   220: return
    //   221: aload_2
    //   222: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   225: sipush -2000
    //   228: if_icmpeq +13 -> 241
    //   231: aload_2
    //   232: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   235: sipush -5015
    //   238: if_icmpne +446 -> 684
    //   241: aconst_null
    //   242: astore 18
    //   244: aconst_null
    //   245: astore 5
    //   247: aload_2
    //   248: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   251: astore 17
    //   253: aload_2
    //   254: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   257: aload_2
    //   258: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   261: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   264: ifeq +7322 -> 7586
    //   267: aload_2
    //   268: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   271: astore 17
    //   273: aload_1
    //   274: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   277: aload 17
    //   279: aload_2
    //   280: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   283: aload_2
    //   284: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   287: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   290: checkcast 358	com/tencent/mobileqq/data/MessageForPic
    //   293: astore 16
    //   295: aload 18
    //   297: astore 5
    //   299: aload_1
    //   300: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:a	()Lbeyb;
    //   303: aload 17
    //   305: aload_2
    //   306: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   309: invokevirtual 602	beyb:a	(Ljava/lang/String;J)Lbhvc;
    //   312: astore_1
    //   313: aload_1
    //   314: astore 5
    //   316: aload_2
    //   317: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   320: ifeq +231 -> 551
    //   323: aload 16
    //   325: ifnull +201 -> 526
    //   328: aload_1
    //   329: astore 5
    //   331: aload 16
    //   333: getfield 605	com/tencent/mobileqq/data/MessageForPic:size	J
    //   336: lstore 14
    //   338: lload 14
    //   340: lconst_0
    //   341: lcmp
    //   342: ifgt +184 -> 526
    //   345: aload_1
    //   346: ifnonnull +7234 -> 7580
    //   349: iconst_1
    //   350: istore 6
    //   352: aload 16
    //   354: astore 5
    //   356: iload 6
    //   358: istore 7
    //   360: aload_1
    //   361: astore 16
    //   363: aload 16
    //   365: instanceof 607
    //   368: ifeq +263 -> 631
    //   371: aload 16
    //   373: checkcast 607	berp
    //   376: astore_1
    //   377: aload_1
    //   378: invokevirtual 609	berp:c	()J
    //   381: ldc2_w 610
    //   384: lcmp
    //   385: ifeq +7189 -> 7574
    //   388: iconst_1
    //   389: istore 6
    //   391: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +60 -> 454
    //   397: aload_1
    //   398: getfield 614	berp:a	Lbeyg;
    //   401: ifnull +222 -> 623
    //   404: aload_1
    //   405: getfield 614	berp:a	Lbeyg;
    //   408: getfield 617	beyg:jdField_a_of_type_Long	J
    //   411: lstore 14
    //   413: ldc_w 619
    //   416: iconst_2
    //   417: new 161	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 621
    //   427: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: lload 14
    //   432: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   435: ldc_w 623
    //   438: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_1
    //   442: invokevirtual 625	berp:b	()Ljava/lang/String;
    //   445: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: aload_0
    //   455: ldc_w 626
    //   458: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   461: astore_1
    //   462: aload_2
    //   463: invokestatic 629	anzr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   466: ifne +10 -> 476
    //   469: aload_2
    //   470: invokestatic 632	anxg:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   473: ifeq +11 -> 484
    //   476: aload_0
    //   477: ldc_w 633
    //   480: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   483: astore_1
    //   484: aload_2
    //   485: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   488: sipush -5015
    //   491: if_icmpne +11 -> 502
    //   494: aload_0
    //   495: ldc_w 634
    //   498: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   501: astore_1
    //   502: aload 5
    //   504: invokestatic 636	bhnt:a	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   507: astore_0
    //   508: aload_0
    //   509: ifnull +7054 -> 7563
    //   512: aload 19
    //   514: aload_0
    //   515: aconst_null
    //   516: iload 7
    //   518: iload 6
    //   520: aload 4
    //   522: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   525: return
    //   526: aload 16
    //   528: ifnull +7052 -> 7580
    //   531: aload_1
    //   532: astore 5
    //   534: aload 16
    //   536: getfield 639	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   539: ldc_w 640
    //   542: if_icmpne +7047 -> 7589
    //   545: iconst_1
    //   546: istore 6
    //   548: goto -196 -> 352
    //   551: aload_1
    //   552: ifnull +7028 -> 7580
    //   555: aload_1
    //   556: astore 5
    //   558: aload_1
    //   559: instanceof 607
    //   562: ifeq +7018 -> 7580
    //   565: aload_1
    //   566: astore 5
    //   568: aload_1
    //   569: checkcast 607	berp
    //   572: invokevirtual 609	berp:c	()J
    //   575: lstore 14
    //   577: lload 14
    //   579: l2i
    //   580: istore_3
    //   581: iload_3
    //   582: sipush 1005
    //   585: if_icmpeq +10 -> 595
    //   588: iload_3
    //   589: sipush 1004
    //   592: if_icmpne +6988 -> 7580
    //   595: iconst_1
    //   596: istore 6
    //   598: goto -246 -> 352
    //   601: astore 16
    //   603: aconst_null
    //   604: astore_1
    //   605: aload 16
    //   607: invokevirtual 519	java/lang/Exception:printStackTrace	()V
    //   610: iconst_0
    //   611: istore 7
    //   613: aload 5
    //   615: astore 16
    //   617: aload_1
    //   618: astore 5
    //   620: goto -257 -> 363
    //   623: ldc2_w 39
    //   626: lstore 14
    //   628: goto -215 -> 413
    //   631: aload 16
    //   633: ifnull +6935 -> 7568
    //   636: iconst_1
    //   637: istore 10
    //   639: iload 10
    //   641: istore 6
    //   643: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq -192 -> 454
    //   649: ldc_w 619
    //   652: iconst_2
    //   653: new 161	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 642
    //   663: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 16
    //   668: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: iload 10
    //   679: istore 6
    //   681: goto -227 -> 454
    //   684: aload_2
    //   685: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   688: sipush -2002
    //   691: if_icmpeq +13 -> 704
    //   694: aload_2
    //   695: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   698: sipush -1031
    //   701: if_icmpne +250 -> 951
    //   704: aload_2
    //   705: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   708: astore 5
    //   710: aload_2
    //   711: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   714: aload_2
    //   715: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   718: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   721: ifeq +6839 -> 7560
    //   724: aload_2
    //   725: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   728: astore 5
    //   730: aload_0
    //   731: ldc_w 646
    //   734: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   737: astore_0
    //   738: aload_1
    //   739: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   742: aload 5
    //   744: aload_2
    //   745: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   748: aload_2
    //   749: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   752: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   755: astore 16
    //   757: aload 16
    //   759: instanceof 648
    //   762: ifeq +6789 -> 7551
    //   765: aload 16
    //   767: checkcast 648	com/tencent/mobileqq/data/MessageForPtt
    //   770: astore 17
    //   772: aload 17
    //   774: invokevirtual 651	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   777: astore 16
    //   779: aload 16
    //   781: astore_0
    //   782: aload_2
    //   783: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   786: ifeq +6765 -> 7551
    //   789: aload 17
    //   791: getfield 654	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   794: ldc2_w 39
    //   797: lcmp
    //   798: ifne +52 -> 850
    //   801: iconst_0
    //   802: istore 7
    //   804: iconst_1
    //   805: istore 6
    //   807: aload 16
    //   809: astore_0
    //   810: ldc_w 656
    //   813: iconst_2
    //   814: anewarray 4	java/lang/Object
    //   817: dup
    //   818: iconst_0
    //   819: iload 6
    //   821: invokestatic 661	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   824: aastore
    //   825: dup
    //   826: iconst_1
    //   827: iload 7
    //   829: invokestatic 661	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   832: aastore
    //   833: invokestatic 666	asam:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   836: aload 19
    //   838: aload_0
    //   839: aconst_null
    //   840: iload 6
    //   842: iload 7
    //   844: aload 4
    //   846: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   849: return
    //   850: aload 16
    //   852: astore_0
    //   853: aload 17
    //   855: getfield 654	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   858: lconst_0
    //   859: lcmp
    //   860: ifgt +6691 -> 7551
    //   863: aload_1
    //   864: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:a	()Lbeyb;
    //   867: aload 5
    //   869: aload 17
    //   871: getfield 669	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   874: aload 17
    //   876: getfield 670	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   879: invokevirtual 673	beyb:b	(Ljava/lang/String;Ljava/lang/String;J)I
    //   882: istore_3
    //   883: iload_3
    //   884: sipush 1005
    //   887: if_icmpeq +15 -> 902
    //   890: iload_3
    //   891: sipush 1004
    //   894: if_icmpeq +8 -> 902
    //   897: iload_3
    //   898: iconst_m1
    //   899: if_icmpne +43 -> 942
    //   902: iconst_1
    //   903: istore 6
    //   905: iconst_0
    //   906: istore 7
    //   908: ldc_w 656
    //   911: iconst_2
    //   912: anewarray 4	java/lang/Object
    //   915: dup
    //   916: iconst_0
    //   917: aload 17
    //   919: getfield 654	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   922: invokestatic 678	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   925: aastore
    //   926: dup
    //   927: iconst_1
    //   928: iload_3
    //   929: invokestatic 681	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   932: aastore
    //   933: invokestatic 666	asam:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   936: aload 16
    //   938: astore_0
    //   939: goto -129 -> 810
    //   942: iconst_1
    //   943: istore 7
    //   945: iconst_0
    //   946: istore 6
    //   948: goto -40 -> 908
    //   951: aload_2
    //   952: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   955: sipush -3008
    //   958: if_icmpne +48 -> 1006
    //   961: aload 4
    //   963: new 161	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   970: aload_0
    //   971: ldc_w 682
    //   974: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   977: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: ldc_w 684
    //   983: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_2
    //   987: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   990: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 684
    //   996: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1005: return
    //   1006: aload_2
    //   1007: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1010: sipush -2015
    //   1013: if_icmpeq +103 -> 1116
    //   1016: aload_2
    //   1017: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1020: sipush -2060
    //   1023: if_icmpeq +93 -> 1116
    //   1026: aload_2
    //   1027: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1030: sipush -2062
    //   1033: if_icmpeq +83 -> 1116
    //   1036: aload_2
    //   1037: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1040: sipush -2065
    //   1043: if_icmpeq +73 -> 1116
    //   1046: aload_2
    //   1047: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1050: sipush -7010
    //   1053: if_icmpeq +63 -> 1116
    //   1056: aload_2
    //   1057: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1060: sipush -7009
    //   1063: if_icmpeq +53 -> 1116
    //   1066: aload_2
    //   1067: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1070: sipush -7011
    //   1073: if_icmpeq +43 -> 1116
    //   1076: aload_2
    //   1077: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1080: sipush -7012
    //   1083: if_icmpeq +33 -> 1116
    //   1086: aload_2
    //   1087: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1090: sipush -4023
    //   1093: if_icmpeq +23 -> 1116
    //   1096: aload_2
    //   1097: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1100: sipush -4024
    //   1103: if_icmpeq +13 -> 1116
    //   1106: aload_2
    //   1107: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1110: sipush -7013
    //   1113: if_icmpne +11 -> 1124
    //   1116: aload 4
    //   1118: ldc 120
    //   1120: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1123: return
    //   1124: aload_2
    //   1125: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1128: invokestatic 688	bhka:a	(I)Z
    //   1131: ifeq +28 -> 1159
    //   1134: aload 19
    //   1136: aload_0
    //   1137: aload_1
    //   1138: aload_2
    //   1139: invokestatic 690	bhnt:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1142: aconst_null
    //   1143: aload_1
    //   1144: aload_2
    //   1145: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1148: aload_1
    //   1149: aload_2
    //   1150: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1153: aload 4
    //   1155: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1158: return
    //   1159: aload_2
    //   1160: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1163: sipush -2017
    //   1166: if_icmpne +94 -> 1260
    //   1169: aload_0
    //   1170: ldc_w 691
    //   1173: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   1176: astore 5
    //   1178: aload_2
    //   1179: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1182: astore_0
    //   1183: aload_2
    //   1184: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1187: aload_2
    //   1188: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1191: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   1194: ifeq +8 -> 1202
    //   1197: aload_2
    //   1198: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1201: astore_0
    //   1202: aload_1
    //   1203: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1206: aload_0
    //   1207: aload_2
    //   1208: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1211: aload_2
    //   1212: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   1215: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1218: astore 16
    //   1220: aload 5
    //   1222: astore_0
    //   1223: aload 16
    //   1225: instanceof 693
    //   1228: ifeq +12 -> 1240
    //   1231: aload 16
    //   1233: checkcast 693	com/tencent/mobileqq/data/MessageForTroopFile
    //   1236: invokevirtual 694	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1239: astore_0
    //   1240: aload 19
    //   1242: aload_0
    //   1243: aconst_null
    //   1244: aload_1
    //   1245: aload_2
    //   1246: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1249: aload_1
    //   1250: aload_2
    //   1251: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1254: aload 4
    //   1256: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1259: return
    //   1260: aload_2
    //   1261: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1264: invokestatic 696	bhka:b	(I)Z
    //   1267: ifeq +35 -> 1302
    //   1270: aload_2
    //   1271: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1274: invokestatic 701	beyo:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1277: astore_1
    //   1278: aload_1
    //   1279: ifnull -1275 -> 4
    //   1282: aload 4
    //   1284: aload_1
    //   1285: aload_0
    //   1286: aload_2
    //   1287: getfield 704	com/tencent/imcore/message/QQMessageFacade$Message:issend	I
    //   1290: invokestatic 705	bhnt:b	(I)Z
    //   1293: iload 7
    //   1295: invokestatic 707	bhnt:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1298: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1301: return
    //   1302: aload_2
    //   1303: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1306: invokestatic 709	bhka:c	(I)Z
    //   1309: ifeq +39 -> 1348
    //   1312: aload_2
    //   1313: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1316: invokestatic 701	beyo:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1319: astore 5
    //   1321: aload 5
    //   1323: ifnull -1319 -> 4
    //   1326: aload 4
    //   1328: aload_1
    //   1329: aload 5
    //   1331: aload_0
    //   1332: aload_2
    //   1333: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1336: aload_2
    //   1337: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1340: iload_3
    //   1341: invokestatic 711	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1344: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1347: return
    //   1348: aload_2
    //   1349: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1352: invokestatic 713	bhka:d	(I)Z
    //   1355: ifeq +134 -> 1489
    //   1358: aload_1
    //   1359: aload_2
    //   1360: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1363: istore 6
    //   1365: aload_1
    //   1366: aload_2
    //   1367: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1370: istore 7
    //   1372: aload_2
    //   1373: ldc_w 715
    //   1376: invokevirtual 718	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1379: astore 5
    //   1381: getstatic 723	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1384: ifeq +96 -> 1480
    //   1387: aload 5
    //   1389: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1392: ifne +88 -> 1480
    //   1395: aload_0
    //   1396: aload_2
    //   1397: invokestatic 728	asfa:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1400: astore_0
    //   1401: aload_2
    //   1402: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1405: aload_1
    //   1406: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1409: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1412: ifeq +41 -> 1453
    //   1415: new 161	java/lang/StringBuilder
    //   1418: dup
    //   1419: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1422: ldc_w 729
    //   1425: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   1428: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload_0
    //   1432: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1438: astore_0
    //   1439: aload 19
    //   1441: aload_0
    //   1442: aconst_null
    //   1443: iload 6
    //   1445: iload 7
    //   1447: aload 4
    //   1449: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1452: return
    //   1453: new 161	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1460: ldc_w 730
    //   1463: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   1466: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: aload_0
    //   1470: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: astore_0
    //   1477: goto -38 -> 1439
    //   1480: aload_0
    //   1481: aload_2
    //   1482: invokestatic 728	asfa:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1485: astore_0
    //   1486: goto -47 -> 1439
    //   1489: aload_2
    //   1490: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1493: sipush -2058
    //   1496: if_icmpne +1070 -> 2566
    //   1499: ldc 120
    //   1501: astore 18
    //   1503: aload_1
    //   1504: aload_2
    //   1505: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1508: istore 12
    //   1510: aload_1
    //   1511: aload_2
    //   1512: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1515: istore 13
    //   1517: iconst_0
    //   1518: istore 8
    //   1520: aload 18
    //   1522: astore 17
    //   1524: aload_2
    //   1525: ldc_w 732
    //   1528: invokevirtual 718	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1531: astore 5
    //   1533: aload 18
    //   1535: astore 16
    //   1537: aload 18
    //   1539: astore 17
    //   1541: aload 5
    //   1543: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1546: ifne +270 -> 1816
    //   1549: aload 18
    //   1551: astore 17
    //   1553: new 734	org/json/JSONObject
    //   1556: dup
    //   1557: aload 5
    //   1559: invokespecial 737	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1562: ldc_w 739
    //   1565: invokevirtual 742	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1568: istore 9
    //   1570: iload 8
    //   1572: istore_3
    //   1573: aload 18
    //   1575: astore 5
    //   1577: aload 18
    //   1579: astore 17
    //   1581: aload_2
    //   1582: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1585: ifnull +114 -> 1699
    //   1588: iload 8
    //   1590: istore_3
    //   1591: aload 18
    //   1593: astore 5
    //   1595: iload 9
    //   1597: sipush -2007
    //   1600: if_icmpne +99 -> 1699
    //   1603: iload 8
    //   1605: istore_3
    //   1606: aload 18
    //   1608: astore 5
    //   1610: aload 18
    //   1612: astore 17
    //   1614: aload_2
    //   1615: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1618: invokestatic 751	apdm:a	([B)Ljava/lang/Object;
    //   1621: instanceof 753
    //   1624: ifeq +75 -> 1699
    //   1627: aload 18
    //   1629: astore 17
    //   1631: getstatic 723	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1634: ifeq +232 -> 1866
    //   1637: aload 18
    //   1639: astore 17
    //   1641: aload_0
    //   1642: aload_2
    //   1643: invokestatic 728	asfa:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1646: astore 5
    //   1648: aload 18
    //   1650: astore 17
    //   1652: aload_2
    //   1653: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1656: aload_1
    //   1657: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1660: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1663: ifeq +170 -> 1833
    //   1666: aload 18
    //   1668: astore 17
    //   1670: new 161	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1677: ldc_w 754
    //   1680: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   1683: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: aload 5
    //   1688: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1694: astore 5
    //   1696: goto +5899 -> 7595
    //   1699: aload 5
    //   1701: astore 16
    //   1703: iload_3
    //   1704: ifne +112 -> 1816
    //   1707: aload 5
    //   1709: astore 17
    //   1711: getstatic 723	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1714: ifeq +208 -> 1922
    //   1717: aload 5
    //   1719: astore 17
    //   1721: aload_2
    //   1722: ldc_w 715
    //   1725: invokevirtual 718	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1728: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1731: ifne +5814 -> 7545
    //   1734: aload 5
    //   1736: astore 17
    //   1738: aload_1
    //   1739: aload_2
    //   1740: aload 4
    //   1742: invokestatic 757	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lbegp;
    //   1745: astore_0
    //   1746: new 161	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1753: astore_1
    //   1754: aload 19
    //   1756: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1759: ifne +16 -> 1775
    //   1762: aload_1
    //   1763: aload 19
    //   1765: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: ldc_w 426
    //   1771: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: pop
    //   1775: aload_2
    //   1776: invokestatic 282	nlj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1779: ifne +16 -> 1795
    //   1782: iload 12
    //   1784: ifeq +98 -> 1882
    //   1787: aload_1
    //   1788: ldc_w 759
    //   1791: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: pop
    //   1795: aload_0
    //   1796: checkcast 761	begp
    //   1799: aload_1
    //   1800: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1803: iconst_1
    //   1804: iconst_0
    //   1805: newarray int
    //   1807: invokevirtual 764	begp:a	(Ljava/lang/String;Z[I)Lbegp;
    //   1810: astore_1
    //   1811: aload_1
    //   1812: astore_0
    //   1813: aload_0
    //   1814: astore 16
    //   1816: aload 16
    //   1818: astore_2
    //   1819: aload 19
    //   1821: aload_2
    //   1822: aconst_null
    //   1823: iload 12
    //   1825: iload 13
    //   1827: aload 4
    //   1829: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1832: return
    //   1833: aload 18
    //   1835: astore 17
    //   1837: new 161	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1844: ldc_w 765
    //   1847: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   1850: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: aload 5
    //   1855: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1861: astore 5
    //   1863: goto +5732 -> 7595
    //   1866: aload 18
    //   1868: astore 17
    //   1870: aload_0
    //   1871: aload_2
    //   1872: invokestatic 728	asfa:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1875: astore 5
    //   1877: iconst_1
    //   1878: istore_3
    //   1879: goto -180 -> 1699
    //   1882: iload 13
    //   1884: ifeq -89 -> 1795
    //   1887: aload_1
    //   1888: ldc_w 767
    //   1891: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: pop
    //   1895: goto -100 -> 1795
    //   1898: astore_1
    //   1899: aload_0
    //   1900: astore_2
    //   1901: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1904: ifeq -85 -> 1819
    //   1907: ldc_w 769
    //   1910: iconst_2
    //   1911: ldc 120
    //   1913: aload_1
    //   1914: invokestatic 772	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1917: aload_0
    //   1918: astore_2
    //   1919: goto -100 -> 1819
    //   1922: iload 9
    //   1924: sipush -1000
    //   1927: if_icmpne +153 -> 2080
    //   1930: aload 5
    //   1932: astore 17
    //   1934: aload_2
    //   1935: invokestatic 775	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;)Lbegp;
    //   1938: astore_0
    //   1939: aload_0
    //   1940: ifnull -1936 -> 4
    //   1943: aload 5
    //   1945: astore 17
    //   1947: new 161	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1954: astore_1
    //   1955: aload 5
    //   1957: astore 17
    //   1959: aload 19
    //   1961: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1964: ifne +20 -> 1984
    //   1967: aload 5
    //   1969: astore 17
    //   1971: aload_1
    //   1972: aload 19
    //   1974: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: ldc_w 426
    //   1980: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: pop
    //   1984: aload 5
    //   1986: astore 17
    //   1988: aload_2
    //   1989: invokestatic 282	nlj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1992: ifne +20 -> 2012
    //   1995: iload 12
    //   1997: ifeq +63 -> 2060
    //   2000: aload 5
    //   2002: astore 17
    //   2004: aload_1
    //   2005: ldc_w 759
    //   2008: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: pop
    //   2012: aload 5
    //   2014: astore 17
    //   2016: aload_0
    //   2017: checkcast 761	begp
    //   2020: aload_1
    //   2021: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2024: iconst_1
    //   2025: iconst_0
    //   2026: newarray int
    //   2028: invokevirtual 764	begp:a	(Ljava/lang/String;Z[I)Lbegp;
    //   2031: astore_0
    //   2032: aload 5
    //   2034: astore 17
    //   2036: aload 4
    //   2038: iconst_1
    //   2039: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2042: aload 5
    //   2044: astore 17
    //   2046: aload 19
    //   2048: aload_0
    //   2049: aconst_null
    //   2050: iload 12
    //   2052: iload 13
    //   2054: aload 4
    //   2056: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2059: return
    //   2060: iload 13
    //   2062: ifeq -50 -> 2012
    //   2065: aload 5
    //   2067: astore 17
    //   2069: aload_1
    //   2070: ldc_w 767
    //   2073: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: pop
    //   2077: goto -65 -> 2012
    //   2080: aload 5
    //   2082: astore 16
    //   2084: iload 9
    //   2086: sipush -2000
    //   2089: if_icmpne -273 -> 1816
    //   2092: iconst_0
    //   2093: istore 11
    //   2095: iconst_0
    //   2096: istore 7
    //   2098: aconst_null
    //   2099: astore 18
    //   2101: aload 18
    //   2103: astore 16
    //   2105: aload_2
    //   2106: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2109: astore 17
    //   2111: aload 18
    //   2113: astore 16
    //   2115: aload_2
    //   2116: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2119: aload_2
    //   2120: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2123: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   2126: ifeq +5416 -> 7542
    //   2129: aload 18
    //   2131: astore 16
    //   2133: aload_2
    //   2134: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2137: astore 17
    //   2139: aload 18
    //   2141: astore 16
    //   2143: aload_1
    //   2144: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   2147: aload 17
    //   2149: aload_2
    //   2150: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2153: aload_2
    //   2154: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2157: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2160: checkcast 358	com/tencent/mobileqq/data/MessageForPic
    //   2163: astore 20
    //   2165: aload 18
    //   2167: astore 16
    //   2169: aload_1
    //   2170: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:a	()Lbeyb;
    //   2173: aload 17
    //   2175: aload_2
    //   2176: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2179: invokevirtual 602	beyb:a	(Ljava/lang/String;J)Lbhvc;
    //   2182: astore_1
    //   2183: aload_1
    //   2184: astore 16
    //   2186: aload_2
    //   2187: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2190: ifeq +245 -> 2435
    //   2193: aload_1
    //   2194: astore 16
    //   2196: aload 20
    //   2198: getfield 605	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2201: lstore 14
    //   2203: lload 14
    //   2205: lconst_0
    //   2206: lcmp
    //   2207: ifgt +208 -> 2415
    //   2210: aload_1
    //   2211: ifnonnull +5325 -> 7536
    //   2214: aload 20
    //   2216: ifnull +5320 -> 7536
    //   2219: iconst_1
    //   2220: istore 6
    //   2222: iload 6
    //   2224: istore 10
    //   2226: aload 5
    //   2228: astore 17
    //   2230: aload_1
    //   2231: instanceof 607
    //   2234: ifeq +269 -> 2503
    //   2237: aload 5
    //   2239: astore 17
    //   2241: aload_1
    //   2242: checkcast 607	berp
    //   2245: astore_1
    //   2246: aload 5
    //   2248: astore 17
    //   2250: aload_1
    //   2251: invokevirtual 609	berp:c	()J
    //   2254: ldc2_w 610
    //   2257: lcmp
    //   2258: ifeq +6 -> 2264
    //   2261: iconst_1
    //   2262: istore 7
    //   2264: iload 7
    //   2266: istore 6
    //   2268: aload 5
    //   2270: astore 17
    //   2272: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2275: ifeq +76 -> 2351
    //   2278: aload 5
    //   2280: astore 17
    //   2282: aload_1
    //   2283: getfield 614	berp:a	Lbeyg;
    //   2286: ifnull +5327 -> 7613
    //   2289: aload 5
    //   2291: astore 17
    //   2293: aload_1
    //   2294: getfield 614	berp:a	Lbeyg;
    //   2297: getfield 617	beyg:jdField_a_of_type_Long	J
    //   2300: lstore 14
    //   2302: aload 5
    //   2304: astore 17
    //   2306: ldc_w 619
    //   2309: iconst_2
    //   2310: new 161	java/lang/StringBuilder
    //   2313: dup
    //   2314: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2317: ldc_w 621
    //   2320: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: lload 14
    //   2325: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2328: ldc_w 623
    //   2331: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2334: aload_1
    //   2335: invokevirtual 625	berp:b	()Ljava/lang/String;
    //   2338: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2344: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2347: iload 7
    //   2349: istore 6
    //   2351: aload 5
    //   2353: astore 17
    //   2355: aload_0
    //   2356: ldc_w 626
    //   2359: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   2362: astore_1
    //   2363: aload 5
    //   2365: astore 17
    //   2367: aload_2
    //   2368: invokestatic 629	anzr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2371: ifne +14 -> 2385
    //   2374: aload 5
    //   2376: astore 17
    //   2378: aload_2
    //   2379: invokestatic 632	anxg:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2382: ifeq +15 -> 2397
    //   2385: aload 5
    //   2387: astore 17
    //   2389: aload_0
    //   2390: ldc_w 633
    //   2393: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   2396: astore_1
    //   2397: aload 5
    //   2399: astore 17
    //   2401: aload 19
    //   2403: aload_1
    //   2404: aconst_null
    //   2405: iload 10
    //   2407: iload 6
    //   2409: aload 4
    //   2411: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2414: return
    //   2415: aload_1
    //   2416: astore 16
    //   2418: aload 20
    //   2420: getfield 639	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2423: ldc_w 640
    //   2426: if_icmpne +5181 -> 7607
    //   2429: iconst_1
    //   2430: istore 6
    //   2432: goto -210 -> 2222
    //   2435: aload_1
    //   2436: ifnull +5100 -> 7536
    //   2439: aload_1
    //   2440: astore 16
    //   2442: aload_1
    //   2443: instanceof 607
    //   2446: ifeq +5090 -> 7536
    //   2449: aload_1
    //   2450: astore 16
    //   2452: aload_1
    //   2453: checkcast 607	berp
    //   2456: invokevirtual 609	berp:c	()J
    //   2459: lstore 14
    //   2461: lload 14
    //   2463: l2i
    //   2464: istore_3
    //   2465: iload_3
    //   2466: sipush 1005
    //   2469: if_icmpeq +10 -> 2479
    //   2472: iload_3
    //   2473: sipush 1004
    //   2476: if_icmpne +5060 -> 7536
    //   2479: iconst_1
    //   2480: istore 6
    //   2482: goto -260 -> 2222
    //   2485: astore_1
    //   2486: aload 5
    //   2488: astore 17
    //   2490: aload_1
    //   2491: invokevirtual 519	java/lang/Exception:printStackTrace	()V
    //   2494: aload 16
    //   2496: astore_1
    //   2497: iconst_0
    //   2498: istore 10
    //   2500: goto -274 -> 2226
    //   2503: iload 11
    //   2505: istore 6
    //   2507: aload_1
    //   2508: ifnull -157 -> 2351
    //   2511: iconst_1
    //   2512: istore 7
    //   2514: iload 7
    //   2516: istore 6
    //   2518: aload 5
    //   2520: astore 17
    //   2522: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2525: ifeq -174 -> 2351
    //   2528: aload 5
    //   2530: astore 17
    //   2532: ldc_w 619
    //   2535: iconst_2
    //   2536: new 161	java/lang/StringBuilder
    //   2539: dup
    //   2540: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2543: ldc_w 642
    //   2546: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: aload_1
    //   2550: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2553: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2556: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2559: iload 7
    //   2561: istore 6
    //   2563: goto -212 -> 2351
    //   2566: aload_2
    //   2567: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2570: invokestatic 780	bhka:e	(I)Z
    //   2573: ifeq +267 -> 2840
    //   2576: new 782	com/tencent/mobileqq/data/MessageForApollo
    //   2579: dup
    //   2580: invokespecial 783	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2583: astore 5
    //   2585: aload 5
    //   2587: aload_2
    //   2588: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   2591: putfield 784	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2594: aload 5
    //   2596: invokevirtual 785	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2599: aload_1
    //   2600: aload_2
    //   2601: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2604: istore 6
    //   2606: aload_1
    //   2607: aload_2
    //   2608: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2611: istore 7
    //   2613: aload 5
    //   2615: getfield 787	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2618: invokestatic 790	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2621: ifeq +209 -> 2830
    //   2624: ldc_w 791
    //   2627: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   2630: astore_0
    //   2631: aload 5
    //   2633: getfield 787	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2636: iconst_4
    //   2637: if_icmpne +155 -> 2792
    //   2640: aload 5
    //   2642: getfield 794	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2645: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2648: ifeq +43 -> 2691
    //   2651: new 161	java/lang/StringBuilder
    //   2654: dup
    //   2655: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2658: aload_0
    //   2659: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2662: ldc_w 795
    //   2665: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   2668: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2671: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2674: astore_1
    //   2675: aload_1
    //   2676: astore_0
    //   2677: aload 19
    //   2679: aload_0
    //   2680: aconst_null
    //   2681: iload 6
    //   2683: iload 7
    //   2685: aload 4
    //   2687: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2690: return
    //   2691: new 734	org/json/JSONObject
    //   2694: dup
    //   2695: aload 5
    //   2697: getfield 794	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2700: invokespecial 737	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2703: ldc_w 797
    //   2706: invokevirtual 800	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2709: astore_1
    //   2710: aload_1
    //   2711: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2714: ifeq +32 -> 2746
    //   2717: new 161	java/lang/StringBuilder
    //   2720: dup
    //   2721: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2724: aload_0
    //   2725: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: ldc_w 801
    //   2731: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   2734: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2740: astore_1
    //   2741: aload_1
    //   2742: astore_0
    //   2743: goto -66 -> 2677
    //   2746: new 161	java/lang/StringBuilder
    //   2749: dup
    //   2750: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2753: aload_0
    //   2754: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2757: ldc_w 530
    //   2760: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: aload_1
    //   2764: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2770: astore_1
    //   2771: aload_1
    //   2772: astore_0
    //   2773: goto -96 -> 2677
    //   2776: astore_1
    //   2777: ldc_w 769
    //   2780: iconst_1
    //   2781: aload_1
    //   2782: iconst_0
    //   2783: anewarray 4	java/lang/Object
    //   2786: invokestatic 804	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2789: goto -112 -> 2677
    //   2792: aload_1
    //   2793: aload 5
    //   2795: invokestatic 809	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2798: astore_1
    //   2799: new 161	java/lang/StringBuilder
    //   2802: dup
    //   2803: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2806: aload_0
    //   2807: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2810: ldc_w 810
    //   2813: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   2816: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: aload_1
    //   2820: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2823: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2826: astore_0
    //   2827: goto -150 -> 2677
    //   2830: aload_1
    //   2831: aload 5
    //   2833: invokestatic 812	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2836: astore_0
    //   2837: goto -160 -> 2677
    //   2840: aload_2
    //   2841: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2844: sipush -1013
    //   2847: if_icmpeq +13 -> 2860
    //   2850: aload_2
    //   2851: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2854: sipush -1047
    //   2857: if_icmpne +20 -> 2877
    //   2860: aconst_null
    //   2861: aconst_null
    //   2862: aload_2
    //   2863: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2866: invokestatic 561	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   2869: iconst_0
    //   2870: iconst_0
    //   2871: aload 4
    //   2873: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2876: return
    //   2877: aload_2
    //   2878: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2881: sipush -2042
    //   2884: if_icmpeq +13 -> 2897
    //   2887: aload_2
    //   2888: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2891: sipush -2043
    //   2894: if_icmpne +20 -> 2914
    //   2897: aconst_null
    //   2898: aload_2
    //   2899: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2902: invokestatic 561	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   2905: aconst_null
    //   2906: iconst_0
    //   2907: iconst_0
    //   2908: aload 4
    //   2910: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2913: return
    //   2914: aload_2
    //   2915: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2918: sipush -2051
    //   2921: if_icmpne +155 -> 3076
    //   2924: aload_1
    //   2925: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   2928: aload_2
    //   2929: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2932: aload_2
    //   2933: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2936: aload_2
    //   2937: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2940: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2943: astore_0
    //   2944: aload_0
    //   2945: ifnull +50 -> 2995
    //   2948: aload_0
    //   2949: instanceof 814
    //   2952: ifeq +43 -> 2995
    //   2955: aload_0
    //   2956: checkcast 814	com/tencent/mobileqq/data/MessageForQQStory
    //   2959: astore_0
    //   2960: aload_0
    //   2961: invokevirtual 815	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   2964: aload_1
    //   2965: aload_2
    //   2966: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2969: istore 6
    //   2971: aload_1
    //   2972: aload_2
    //   2973: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2976: istore 7
    //   2978: aload 19
    //   2980: aconst_null
    //   2981: aload_0
    //   2982: invokevirtual 816	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   2985: iload 6
    //   2987: iload 7
    //   2989: aload 4
    //   2991: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2994: return
    //   2995: new 161	java/lang/StringBuilder
    //   2998: dup
    //   2999: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3002: ldc 2
    //   3004: invokevirtual 821	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3007: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3010: ldc_w 823
    //   3013: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3019: astore_1
    //   3020: new 161	java/lang/StringBuilder
    //   3023: dup
    //   3024: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3027: ldc_w 825
    //   3030: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3033: aload_2
    //   3034: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3037: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3040: ldc_w 827
    //   3043: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3046: astore_2
    //   3047: aload_0
    //   3048: ifnull +22 -> 3070
    //   3051: aload_0
    //   3052: invokevirtual 830	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3055: astore_0
    //   3056: aload_1
    //   3057: iconst_1
    //   3058: aload_2
    //   3059: aload_0
    //   3060: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3066: invokestatic 832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3069: return
    //   3070: ldc 120
    //   3072: astore_0
    //   3073: goto -17 -> 3056
    //   3076: aload_2
    //   3077: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3080: sipush -7002
    //   3083: if_icmpne +148 -> 3231
    //   3086: aload_1
    //   3087: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3090: aload_2
    //   3091: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3094: aload_2
    //   3095: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3098: aload_2
    //   3099: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3102: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3105: checkcast 834	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3108: astore_0
    //   3109: aload_0
    //   3110: ifnull +38 -> 3148
    //   3113: aload_0
    //   3114: invokevirtual 835	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3117: aload_1
    //   3118: aload_2
    //   3119: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3122: istore 6
    //   3124: aload_1
    //   3125: aload_2
    //   3126: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3129: istore 7
    //   3131: aload 19
    //   3133: aconst_null
    //   3134: aload_0
    //   3135: invokevirtual 836	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3138: iload 6
    //   3140: iload 7
    //   3142: aload 4
    //   3144: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3147: return
    //   3148: new 161	java/lang/StringBuilder
    //   3151: dup
    //   3152: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3155: ldc 2
    //   3157: invokevirtual 821	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3160: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3163: ldc_w 823
    //   3166: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3169: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3172: astore_1
    //   3173: new 161	java/lang/StringBuilder
    //   3176: dup
    //   3177: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3180: ldc_w 838
    //   3183: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3186: aload_2
    //   3187: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3190: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3193: ldc_w 827
    //   3196: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3199: astore 4
    //   3201: aload_2
    //   3202: ifnull +23 -> 3225
    //   3205: aload_2
    //   3206: invokevirtual 839	com/tencent/imcore/message/QQMessageFacade$Message:toString	()Ljava/lang/String;
    //   3209: astore_0
    //   3210: aload_1
    //   3211: iconst_1
    //   3212: aload 4
    //   3214: aload_0
    //   3215: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3218: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3221: invokestatic 832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3224: return
    //   3225: ldc 120
    //   3227: astore_0
    //   3228: goto -18 -> 3210
    //   3231: aload_2
    //   3232: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3235: sipush -2054
    //   3238: if_icmpne +153 -> 3391
    //   3241: aload_1
    //   3242: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3245: aload_2
    //   3246: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3249: aload_2
    //   3250: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3253: aload_2
    //   3254: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3257: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3260: astore_0
    //   3261: aload_0
    //   3262: instanceof 841
    //   3265: ifeq +42 -> 3307
    //   3268: aload_0
    //   3269: checkcast 841	com/tencent/mobileqq/data/MessageForTroopSign
    //   3272: astore_0
    //   3273: ldc_w 842
    //   3276: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   3279: pop
    //   3280: aload_0
    //   3281: invokevirtual 843	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3284: aload 19
    //   3286: aconst_null
    //   3287: aload_0
    //   3288: invokevirtual 844	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3291: aload_1
    //   3292: aload_2
    //   3293: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3296: aload_1
    //   3297: aload_2
    //   3298: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3301: aload 4
    //   3303: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3306: return
    //   3307: new 161	java/lang/StringBuilder
    //   3310: dup
    //   3311: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3314: ldc 2
    //   3316: invokevirtual 821	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3319: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3322: ldc_w 846
    //   3325: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3328: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3331: astore_1
    //   3332: new 161	java/lang/StringBuilder
    //   3335: dup
    //   3336: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3339: ldc_w 848
    //   3342: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: aload_2
    //   3346: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3349: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3352: ldc_w 827
    //   3355: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3358: astore_2
    //   3359: aload_0
    //   3360: ifnull +25 -> 3385
    //   3363: aload_0
    //   3364: getfield 849	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3367: invokestatic 681	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3370: astore_0
    //   3371: aload_1
    //   3372: iconst_1
    //   3373: aload_2
    //   3374: aload_0
    //   3375: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3378: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3381: invokestatic 832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3384: return
    //   3385: ldc 120
    //   3387: astore_0
    //   3388: goto -17 -> 3371
    //   3391: aload_2
    //   3392: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3395: sipush -2035
    //   3398: if_icmpne +20 -> 3418
    //   3401: aconst_null
    //   3402: aload_2
    //   3403: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3406: invokestatic 561	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3409: aconst_null
    //   3410: iconst_0
    //   3411: iconst_0
    //   3412: aload 4
    //   3414: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3417: return
    //   3418: aload_2
    //   3419: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3422: sipush -2038
    //   3425: if_icmpne +205 -> 3630
    //   3428: aload_2
    //   3429: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3432: astore_0
    //   3433: getstatic 854	antf:aj	Ljava/lang/String;
    //   3436: aload_0
    //   3437: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3440: ifeq +4093 -> 7533
    //   3443: aload_2
    //   3444: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3447: astore_0
    //   3448: aload_0
    //   3449: astore 5
    //   3451: getstatic 857	antf:H	Ljava/lang/String;
    //   3454: aload_0
    //   3455: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3458: ifeq +59 -> 3517
    //   3461: getstatic 854	antf:aj	Ljava/lang/String;
    //   3464: aload_2
    //   3465: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3468: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3471: ifeq +103 -> 3574
    //   3474: aload_1
    //   3475: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3478: getstatic 854	antf:aj	Ljava/lang/String;
    //   3481: aload_2
    //   3482: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3485: aload_2
    //   3486: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3489: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3492: checkcast 859	com/tencent/mobileqq/data/MessageForTroopGift
    //   3495: astore 16
    //   3497: aload_0
    //   3498: astore 5
    //   3500: aload 16
    //   3502: ifnull +15 -> 3517
    //   3505: aload 16
    //   3507: invokevirtual 860	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3510: aload 16
    //   3512: getfield 861	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3515: astore 5
    //   3517: aload_1
    //   3518: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3521: aload 5
    //   3523: aload_2
    //   3524: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3527: aload_2
    //   3528: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3531: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3534: astore_0
    //   3535: aload_0
    //   3536: instanceof 859
    //   3539: ifeq +50 -> 3589
    //   3542: aload_0
    //   3543: checkcast 859	com/tencent/mobileqq/data/MessageForTroopGift
    //   3546: astore_0
    //   3547: aload_0
    //   3548: invokevirtual 860	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3551: aload_0
    //   3552: getfield 862	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3555: ifnull +28 -> 3583
    //   3558: aload_0
    //   3559: getfield 862	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3562: astore_0
    //   3563: aconst_null
    //   3564: aload_0
    //   3565: aconst_null
    //   3566: iconst_0
    //   3567: iconst_0
    //   3568: aload 4
    //   3570: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3573: return
    //   3574: aload_2
    //   3575: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3578: astore 5
    //   3580: goto -63 -> 3517
    //   3583: ldc 120
    //   3585: astore_0
    //   3586: goto -23 -> 3563
    //   3589: aload_0
    //   3590: ifnull -3586 -> 4
    //   3593: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3596: ifeq -3592 -> 4
    //   3599: ldc_w 769
    //   3602: iconst_2
    //   3603: new 161	java/lang/StringBuilder
    //   3606: dup
    //   3607: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3610: ldc_w 864
    //   3613: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: aload_0
    //   3617: invokevirtual 830	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3620: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3623: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3626: invokestatic 832	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3629: return
    //   3630: aload_2
    //   3631: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3634: sipush -2036
    //   3637: if_icmpne +48 -> 3685
    //   3640: aload_1
    //   3641: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3644: aload_2
    //   3645: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3648: aload_2
    //   3649: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3652: aload_2
    //   3653: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3656: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3659: checkcast 866	com/tencent/mobileqq/data/MessageForTroopFee
    //   3662: astore_0
    //   3663: aload_0
    //   3664: ifnull -3660 -> 4
    //   3667: aload_0
    //   3668: invokevirtual 867	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3671: aconst_null
    //   3672: aload_0
    //   3673: getfield 868	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3676: aconst_null
    //   3677: iconst_0
    //   3678: iconst_0
    //   3679: aload 4
    //   3681: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3684: return
    //   3685: aload_2
    //   3686: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3689: sipush -2069
    //   3692: if_icmpne +48 -> 3740
    //   3695: aload_1
    //   3696: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3699: aload_2
    //   3700: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3703: aload_2
    //   3704: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3707: aload_2
    //   3708: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3711: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3714: checkcast 870	com/tencent/mobileqq/data/MessageForStarLeague
    //   3717: astore_0
    //   3718: aload_0
    //   3719: ifnull -3715 -> 4
    //   3722: aload_0
    //   3723: invokevirtual 871	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3726: aconst_null
    //   3727: aload_0
    //   3728: getfield 872	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3731: aconst_null
    //   3732: iconst_0
    //   3733: iconst_0
    //   3734: aload 4
    //   3736: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3739: return
    //   3740: aload_2
    //   3741: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3744: sipush -2048
    //   3747: if_icmpne +49 -> 3796
    //   3750: aload_1
    //   3751: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3754: aload_2
    //   3755: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3758: aload_2
    //   3759: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3762: aload_2
    //   3763: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3766: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3769: checkcast 874	com/tencent/mobileqq/data/MessageForTroopReward
    //   3772: astore_0
    //   3773: aload_0
    //   3774: ifnull -3770 -> 4
    //   3777: aload_0
    //   3778: invokevirtual 875	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3781: aload 19
    //   3783: aload_0
    //   3784: getfield 876	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3787: aconst_null
    //   3788: iconst_0
    //   3789: iconst_0
    //   3790: aload 4
    //   3792: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3795: return
    //   3796: aload_2
    //   3797: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3800: iconst_1
    //   3801: if_icmpne +85 -> 3886
    //   3804: aload_2
    //   3805: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3808: sipush -3006
    //   3811: if_icmpne +75 -> 3886
    //   3814: aload_1
    //   3815: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3818: aload_2
    //   3819: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3822: aload_2
    //   3823: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3826: aload_2
    //   3827: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3830: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3833: checkcast 878	com/tencent/mobileqq/data/MessageForPubAccount
    //   3836: astore_0
    //   3837: aload_0
    //   3838: ifnull -3834 -> 4
    //   3841: aload_0
    //   3842: invokevirtual 879	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3845: aload_1
    //   3846: aload_0
    //   3847: iconst_0
    //   3848: invokestatic 883	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3851: astore_2
    //   3852: aload_0
    //   3853: invokevirtual 886	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3856: ifne +16 -> 3872
    //   3859: aconst_null
    //   3860: astore_0
    //   3861: aload_0
    //   3862: aload_2
    //   3863: aconst_null
    //   3864: iconst_0
    //   3865: iconst_0
    //   3866: aload 4
    //   3868: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3871: return
    //   3872: aload_1
    //   3873: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3876: ldc_w 887
    //   3879: invokevirtual 159	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   3882: astore_0
    //   3883: goto -22 -> 3861
    //   3886: aload_2
    //   3887: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3890: sipush -1034
    //   3893: if_icmpne +106 -> 3999
    //   3896: new 889	com/tencent/mobileqq/data/MessageForRichState
    //   3899: dup
    //   3900: invokespecial 890	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   3903: astore_0
    //   3904: aload_0
    //   3905: aload_2
    //   3906: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3909: putfield 891	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   3912: aload_0
    //   3913: invokevirtual 892	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   3916: new 161	java/lang/StringBuilder
    //   3919: dup
    //   3920: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3923: astore_1
    //   3924: aload_0
    //   3925: getfield 895	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3928: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3931: ifne +38 -> 3969
    //   3934: aload_1
    //   3935: aload_0
    //   3936: getfield 895	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   3939: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3942: pop
    //   3943: aload_0
    //   3944: getfield 898	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3947: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3950: ifne +12 -> 3962
    //   3953: aload_1
    //   3954: aload_0
    //   3955: getfield 898	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   3958: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3961: pop
    //   3962: aload_1
    //   3963: bipush 32
    //   3965: invokevirtual 901	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3968: pop
    //   3969: aload_1
    //   3970: aload_0
    //   3971: invokevirtual 904	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   3974: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3977: pop
    //   3978: aload_1
    //   3979: invokevirtual 905	java/lang/StringBuilder:length	()I
    //   3982: ifle -3978 -> 4
    //   3985: aconst_null
    //   3986: aload_1
    //   3987: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3990: aconst_null
    //   3991: iconst_0
    //   3992: iconst_0
    //   3993: aload 4
    //   3995: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3998: return
    //   3999: aload_2
    //   4000: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4003: sipush -2074
    //   4006: if_icmpne +47 -> 4053
    //   4009: new 907	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4012: dup
    //   4013: invokespecial 908	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4016: astore_0
    //   4017: aload_0
    //   4018: aload_2
    //   4019: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4022: putfield 909	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4025: aload_0
    //   4026: invokevirtual 910	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4029: aload_0
    //   4030: getfield 913	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4033: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4036: ifne -4032 -> 4
    //   4039: aconst_null
    //   4040: aload_0
    //   4041: getfield 913	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4044: aconst_null
    //   4045: iconst_0
    //   4046: iconst_0
    //   4047: aload 4
    //   4049: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4052: return
    //   4053: aload_2
    //   4054: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4057: sipush -1019
    //   4060: if_icmpne +48 -> 4108
    //   4063: aconst_null
    //   4064: aconst_null
    //   4065: new 161	java/lang/StringBuilder
    //   4068: dup
    //   4069: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4072: ldc_w 914
    //   4075: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   4078: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4081: aload_2
    //   4082: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4085: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4088: ldc_w 915
    //   4091: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   4094: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4097: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4100: iconst_0
    //   4101: iconst_0
    //   4102: aload 4
    //   4104: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4107: return
    //   4108: aload_2
    //   4109: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4112: sipush -1018
    //   4115: if_icmpne +48 -> 4163
    //   4118: aconst_null
    //   4119: aconst_null
    //   4120: new 161	java/lang/StringBuilder
    //   4123: dup
    //   4124: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4127: ldc_w 916
    //   4130: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   4133: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4136: aload_2
    //   4137: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4140: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4143: ldc_w 917
    //   4146: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   4149: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4152: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4155: iconst_0
    //   4156: iconst_0
    //   4157: aload 4
    //   4159: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4162: return
    //   4163: aload_2
    //   4164: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4167: sipush -2019
    //   4170: if_icmpne +16 -> 4186
    //   4173: aload 4
    //   4175: aload_0
    //   4176: ldc_w 918
    //   4179: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4182: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4185: return
    //   4186: aload_2
    //   4187: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4190: sipush -7006
    //   4193: if_icmpne +16 -> 4209
    //   4196: aload 4
    //   4198: aload_0
    //   4199: ldc_w 919
    //   4202: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4205: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4208: return
    //   4209: aload_2
    //   4210: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4213: sipush -1026
    //   4216: if_icmpne +16 -> 4232
    //   4219: aload 4
    //   4221: aload_0
    //   4222: ldc_w 920
    //   4225: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4228: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4231: return
    //   4232: aload_2
    //   4233: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4236: sipush -1027
    //   4239: if_icmpne +16 -> 4255
    //   4242: aload 4
    //   4244: aload_0
    //   4245: ldc_w 921
    //   4248: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4251: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4254: return
    //   4255: aload_2
    //   4256: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4259: sipush -2005
    //   4262: if_icmpne +56 -> 4318
    //   4265: aload_1
    //   4266: aload_2
    //   4267: invokestatic 924	aunj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4270: astore 5
    //   4272: aload_1
    //   4273: aload_2
    //   4274: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4277: istore 6
    //   4279: aload_1
    //   4280: aload_2
    //   4281: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4284: istore 7
    //   4286: aload 19
    //   4288: aload_0
    //   4289: ldc_w 925
    //   4292: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4295: aconst_null
    //   4296: iload 6
    //   4298: iload 7
    //   4300: aload 4
    //   4302: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4305: aload 5
    //   4307: ifnull -4303 -> 4
    //   4310: aload 4
    //   4312: aload 5
    //   4314: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4317: return
    //   4318: aload_2
    //   4319: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4322: sipush -2022
    //   4325: if_icmpeq +13 -> 4338
    //   4328: aload_2
    //   4329: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4332: sipush -2071
    //   4335: if_icmpne +700 -> 5035
    //   4338: iconst_0
    //   4339: istore 7
    //   4341: iconst_0
    //   4342: istore 10
    //   4344: aload_1
    //   4345: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4348: aload_2
    //   4349: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4352: aload_2
    //   4353: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4356: aload_2
    //   4357: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4360: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4363: astore 5
    //   4365: aload 5
    //   4367: instanceof 927
    //   4370: ifeq -4366 -> 4
    //   4373: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4376: ifeq +33 -> 4409
    //   4379: ldc_w 494
    //   4382: iconst_2
    //   4383: new 161	java/lang/StringBuilder
    //   4386: dup
    //   4387: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4390: ldc_w 929
    //   4393: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4396: aload_2
    //   4397: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4400: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4403: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4406: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4409: aload 5
    //   4411: checkcast 927	com/tencent/mobileqq/data/MessageForShortVideo
    //   4414: astore 16
    //   4416: aload 16
    //   4418: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4421: sipush 1005
    //   4424: if_icmpeq +60 -> 4484
    //   4427: aload_2
    //   4428: getfield 933	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   4431: ldc_w 640
    //   4434: if_icmpeq +50 -> 4484
    //   4437: aload 16
    //   4439: getfield 936	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4442: ifne +14 -> 4456
    //   4445: aload 16
    //   4447: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4450: sipush 1004
    //   4453: if_icmpeq +31 -> 4484
    //   4456: iload 7
    //   4458: istore 6
    //   4460: aload 16
    //   4462: getfield 936	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4465: iconst_1
    //   4466: if_icmpne +37 -> 4503
    //   4469: iload 7
    //   4471: istore 6
    //   4473: aload 16
    //   4475: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4478: sipush 1004
    //   4481: if_icmpne +22 -> 4503
    //   4484: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4487: ifeq +13 -> 4500
    //   4490: ldc_w 494
    //   4493: iconst_2
    //   4494: ldc_w 938
    //   4497: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4500: iconst_1
    //   4501: istore 6
    //   4503: aload_2
    //   4504: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4507: astore 5
    //   4509: aload_2
    //   4510: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4513: aload_2
    //   4514: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4517: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   4520: ifeq +9 -> 4529
    //   4523: aload_2
    //   4524: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4527: astore 5
    //   4529: aload_1
    //   4530: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:a	()Lbeyb;
    //   4533: aload 5
    //   4535: aload_2
    //   4536: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4539: invokevirtual 602	beyb:a	(Ljava/lang/String;J)Lbhvc;
    //   4542: astore_1
    //   4543: aload 16
    //   4545: getfield 941	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4548: ifnull +337 -> 4885
    //   4551: ldc 120
    //   4553: aload 16
    //   4555: getfield 941	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4558: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4561: ifne +324 -> 4885
    //   4564: aload_2
    //   4565: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4568: ifeq +317 -> 4885
    //   4571: aload_1
    //   4572: ifnonnull +313 -> 4885
    //   4575: aload 16
    //   4577: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4580: sipush 1003
    //   4583: if_icmpeq +302 -> 4885
    //   4586: aload 16
    //   4588: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4591: sipush 1004
    //   4594: if_icmpeq +291 -> 4885
    //   4597: aload 16
    //   4599: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4602: sipush 2003
    //   4605: if_icmpeq +280 -> 4885
    //   4608: aload 16
    //   4610: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4613: sipush 2009
    //   4616: if_icmpeq +269 -> 4885
    //   4619: aload 16
    //   4621: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4624: sipush 2002
    //   4627: if_icmpeq +258 -> 4885
    //   4630: aload 16
    //   4632: getfield 944	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   4635: iconst_1
    //   4636: if_icmpne +249 -> 4885
    //   4639: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4642: ifeq +13 -> 4655
    //   4645: ldc_w 494
    //   4648: iconst_2
    //   4649: ldc_w 946
    //   4652: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4655: iconst_1
    //   4656: istore 7
    //   4658: iload 7
    //   4660: istore 6
    //   4662: iload 10
    //   4664: istore 7
    //   4666: aload_2
    //   4667: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4670: ifeq +81 -> 4751
    //   4673: aload 16
    //   4675: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4678: sipush 1001
    //   4681: if_icmpeq +51 -> 4732
    //   4684: aload 16
    //   4686: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4689: sipush 1002
    //   4692: if_icmpeq +40 -> 4732
    //   4695: aload 16
    //   4697: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4700: sipush 998
    //   4703: if_icmpeq +29 -> 4732
    //   4706: aload 16
    //   4708: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4711: sipush 999
    //   4714: if_icmpeq +18 -> 4732
    //   4717: iload 10
    //   4719: istore 7
    //   4721: aload 16
    //   4723: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4726: sipush 1000
    //   4729: if_icmpne +22 -> 4751
    //   4732: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4735: ifeq +13 -> 4748
    //   4738: ldc_w 494
    //   4741: iconst_2
    //   4742: ldc_w 948
    //   4745: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4748: iconst_1
    //   4749: istore 7
    //   4751: aload 16
    //   4753: instanceof 950
    //   4756: ifeq +235 -> 4991
    //   4759: aload_0
    //   4760: ldc_w 951
    //   4763: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   4766: astore_0
    //   4767: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4770: ifeq +101 -> 4871
    //   4773: ldc_w 494
    //   4776: iconst_2
    //   4777: new 161	java/lang/StringBuilder
    //   4780: dup
    //   4781: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4784: ldc_w 953
    //   4787: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4790: aload 16
    //   4792: getfield 941	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4795: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4798: ldc_w 955
    //   4801: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4804: aload 16
    //   4806: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4809: invokevirtual 488	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4812: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4815: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4818: aload_1
    //   4819: ifnonnull +203 -> 5022
    //   4822: ldc_w 494
    //   4825: iconst_2
    //   4826: ldc_w 957
    //   4829: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4832: ldc_w 494
    //   4835: iconst_2
    //   4836: new 161	java/lang/StringBuilder
    //   4839: dup
    //   4840: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   4843: ldc_w 959
    //   4846: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4849: iload 6
    //   4851: invokevirtual 962	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4854: ldc_w 964
    //   4857: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4860: iload 7
    //   4862: invokevirtual 962	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4865: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4868: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4871: aload 19
    //   4873: aload_0
    //   4874: aconst_null
    //   4875: iload 6
    //   4877: iload 7
    //   4879: aload 4
    //   4881: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4884: return
    //   4885: iload 6
    //   4887: istore 7
    //   4889: aload_2
    //   4890: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4893: ifeq -235 -> 4658
    //   4896: iload 6
    //   4898: istore 7
    //   4900: aload 16
    //   4902: instanceof 950
    //   4905: ifeq -247 -> 4658
    //   4908: iload 6
    //   4910: istore 7
    //   4912: aload 16
    //   4914: getfield 941	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4917: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4920: ifeq -262 -> 4658
    //   4923: iload 6
    //   4925: istore 7
    //   4927: aload_1
    //   4928: ifnonnull -270 -> 4658
    //   4931: aload 16
    //   4933: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4936: sipush 1004
    //   4939: if_icmpeq +18 -> 4957
    //   4942: iload 6
    //   4944: istore 7
    //   4946: aload 16
    //   4948: getfield 932	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4951: sipush 1001
    //   4954: if_icmpne -296 -> 4658
    //   4957: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4960: ifeq +13 -> 4973
    //   4963: ldc_w 494
    //   4966: iconst_2
    //   4967: ldc_w 966
    //   4970: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4973: iconst_1
    //   4974: istore 7
    //   4976: goto -318 -> 4658
    //   4979: astore 5
    //   4981: aconst_null
    //   4982: astore_1
    //   4983: aload 5
    //   4985: invokevirtual 519	java/lang/Exception:printStackTrace	()V
    //   4988: goto -326 -> 4662
    //   4991: aload 16
    //   4993: getfield 936	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4996: iconst_2
    //   4997: if_icmpne +14 -> 5011
    //   5000: aload_0
    //   5001: ldc_w 967
    //   5004: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5007: astore_0
    //   5008: goto -241 -> 4767
    //   5011: aload_0
    //   5012: ldc_w 968
    //   5015: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5018: astore_0
    //   5019: goto -252 -> 4767
    //   5022: ldc_w 494
    //   5025: iconst_2
    //   5026: ldc_w 970
    //   5029: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5032: goto -200 -> 4832
    //   5035: aload_2
    //   5036: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5039: sipush -5002
    //   5042: if_icmpne +40 -> 5082
    //   5045: new 972	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5048: dup
    //   5049: invokespecial 973	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5052: astore_0
    //   5053: aload_0
    //   5054: aload_2
    //   5055: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5058: putfield 974	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5061: aload_0
    //   5062: invokevirtual 975	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5065: aload_0
    //   5066: getfield 976	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5069: ifnull -5065 -> 4
    //   5072: aload 4
    //   5074: aload_0
    //   5075: getfield 976	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5078: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5081: return
    //   5082: aload_2
    //   5083: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5086: sipush -2029
    //   5089: if_icmpne +145 -> 5234
    //   5092: aload_1
    //   5093: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5096: aload_2
    //   5097: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5100: aload_2
    //   5101: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5104: aload_2
    //   5105: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5108: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5111: astore_0
    //   5112: invokestatic 372	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5115: ifeq +30 -> 5145
    //   5118: ldc_w 494
    //   5121: iconst_2
    //   5122: new 161	java/lang/StringBuilder
    //   5125: dup
    //   5126: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5129: ldc_w 978
    //   5132: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5135: aload_0
    //   5136: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5139: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5142: invokestatic 497	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5145: aload_0
    //   5146: instanceof 980
    //   5149: ifeq -5145 -> 4
    //   5152: aload_0
    //   5153: checkcast 980	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5156: astore_0
    //   5157: aload_0
    //   5158: aload_2
    //   5159: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5162: putfield 981	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5165: aload_0
    //   5166: invokevirtual 982	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5169: aload_0
    //   5170: aload_1
    //   5171: aload_1
    //   5172: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5175: aconst_null
    //   5176: invokevirtual 986	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5179: aload_0
    //   5180: getfield 988	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5183: ifnull -5179 -> 4
    //   5186: aload_0
    //   5187: getfield 991	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5190: iconst_1
    //   5191: if_icmpne +33 -> 5224
    //   5194: aload_0
    //   5195: new 161	java/lang/StringBuilder
    //   5198: dup
    //   5199: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5202: ldc_w 992
    //   5205: invokestatic 421	anzj:a	(I)Ljava/lang/String;
    //   5208: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5211: aload_0
    //   5212: getfield 988	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5215: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5218: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5221: putfield 988	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5224: aload 4
    //   5226: aload_0
    //   5227: getfield 988	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5230: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5233: return
    //   5234: aload_2
    //   5235: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5238: sipush -2025
    //   5241: if_icmpeq +13 -> 5254
    //   5244: aload_2
    //   5245: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5248: sipush -2072
    //   5251: if_icmpne +13 -> 5264
    //   5254: aload 4
    //   5256: aload_2
    //   5257: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5260: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5263: return
    //   5264: aload_2
    //   5265: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5268: sipush -2076
    //   5271: if_icmpne +58 -> 5329
    //   5274: new 994	com/tencent/mobileqq/data/MessageForLocationShare
    //   5277: dup
    //   5278: invokespecial 995	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5281: astore_1
    //   5282: aload_1
    //   5283: aload_2
    //   5284: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5287: putfield 996	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5290: aload_1
    //   5291: invokevirtual 997	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5294: aload_1
    //   5295: getfield 998	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5298: astore_2
    //   5299: aload_2
    //   5300: astore_1
    //   5301: aload_2
    //   5302: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5305: ifeq +11 -> 5316
    //   5308: aload_0
    //   5309: ldc_w 999
    //   5312: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5315: astore_1
    //   5316: aload 19
    //   5318: ldc 120
    //   5320: aload_1
    //   5321: iconst_0
    //   5322: iconst_0
    //   5323: aload 4
    //   5325: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5328: return
    //   5329: aload_2
    //   5330: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5333: sipush -2052
    //   5336: if_icmpne +75 -> 5411
    //   5339: aload_2
    //   5340: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5343: astore_0
    //   5344: aload_2
    //   5345: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5348: aload_2
    //   5349: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5352: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   5355: ifeq +8 -> 5363
    //   5358: aload_2
    //   5359: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5362: astore_0
    //   5363: aload_1
    //   5364: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5367: aload_0
    //   5368: aload_2
    //   5369: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5372: aload_2
    //   5373: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5376: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5379: astore_0
    //   5380: aload_0
    //   5381: instanceof 1001
    //   5384: ifeq -5380 -> 4
    //   5387: aload_0
    //   5388: checkcast 1001	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5391: astore_0
    //   5392: aload_0
    //   5393: invokevirtual 1002	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5396: aload 19
    //   5398: aload_0
    //   5399: invokevirtual 1003	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5402: aconst_null
    //   5403: iconst_0
    //   5404: iconst_0
    //   5405: aload 4
    //   5407: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5410: return
    //   5411: aload_2
    //   5412: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5415: sipush -2047
    //   5418: if_icmpne +51 -> 5469
    //   5421: new 1005	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5424: dup
    //   5425: invokespecial 1006	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5428: astore_0
    //   5429: aload_0
    //   5430: aload_2
    //   5431: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5434: putfield 1007	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5437: aload_0
    //   5438: invokevirtual 1008	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5441: aload_0
    //   5442: invokevirtual 1009	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5445: astore_0
    //   5446: aload_0
    //   5447: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5450: ifne +10 -> 5460
    //   5453: aload 4
    //   5455: aload_0
    //   5456: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5459: return
    //   5460: aload 4
    //   5462: ldc_w 1011
    //   5465: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5468: return
    //   5469: aload_2
    //   5470: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5473: sipush -2040
    //   5476: if_icmpne +29 -> 5505
    //   5479: new 1013	com/tencent/mobileqq/data/MessageForApproval
    //   5482: dup
    //   5483: invokespecial 1014	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5486: astore_0
    //   5487: aload_0
    //   5488: aload_2
    //   5489: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5492: putfield 1015	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5495: aload 4
    //   5497: aload_0
    //   5498: invokevirtual 1018	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5501: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5504: return
    //   5505: aload_2
    //   5506: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5509: sipush -2041
    //   5512: if_icmpne +49 -> 5561
    //   5515: aload_0
    //   5516: ldc_w 1019
    //   5519: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5522: astore_1
    //   5523: aload_0
    //   5524: ldc_w 1020
    //   5527: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5530: astore_0
    //   5531: aload 4
    //   5533: new 161	java/lang/StringBuilder
    //   5536: dup
    //   5537: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5540: aload_1
    //   5541: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5544: ldc_w 530
    //   5547: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5550: aload_0
    //   5551: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5554: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5557: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5560: return
    //   5561: aload_2
    //   5562: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5565: sipush -7001
    //   5568: if_icmpne +157 -> 5725
    //   5571: aload_2
    //   5572: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5575: astore 5
    //   5577: aload_2
    //   5578: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5581: aload_2
    //   5582: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5585: invokestatic 594	adak:b	(Ljava/lang/String;I)Z
    //   5588: ifeq +9 -> 5597
    //   5591: aload_2
    //   5592: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5595: astore 5
    //   5597: aload_1
    //   5598: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5601: aload 5
    //   5603: aload_2
    //   5604: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5607: aload_2
    //   5608: getfield 31	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5611: invokevirtual 292	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5614: checkcast 1022	com/tencent/mobileqq/data/MessageForScribble
    //   5617: astore_1
    //   5618: aload_1
    //   5619: invokevirtual 1023	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5622: ifeq +56 -> 5678
    //   5625: aload_1
    //   5626: getfield 1026	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5629: istore_3
    //   5630: iload_3
    //   5631: iconst_2
    //   5632: if_icmpne +29 -> 5661
    //   5635: iconst_1
    //   5636: istore 7
    //   5638: iconst_0
    //   5639: istore 6
    //   5641: aload 19
    //   5643: aload_0
    //   5644: ldc_w 1027
    //   5647: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   5650: aconst_null
    //   5651: iload 7
    //   5653: iload 6
    //   5655: aload 4
    //   5657: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5660: return
    //   5661: aload_1
    //   5662: getfield 1026	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5665: iconst_3
    //   5666: if_icmpne +1858 -> 7524
    //   5669: iconst_1
    //   5670: istore 6
    //   5672: iconst_0
    //   5673: istore 7
    //   5675: goto -34 -> 5641
    //   5678: aload_1
    //   5679: getfield 1030	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5682: iconst_2
    //   5683: if_icmpne +1841 -> 7524
    //   5686: aload_1
    //   5687: invokestatic 1035	bbxm:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5690: istore_3
    //   5691: getstatic 1037	bbxm:c	I
    //   5694: istore 8
    //   5696: iload_3
    //   5697: iload 8
    //   5699: if_icmpeq +1825 -> 7524
    //   5702: iconst_1
    //   5703: istore 7
    //   5705: iconst_0
    //   5706: istore 6
    //   5708: goto -67 -> 5641
    //   5711: astore_1
    //   5712: aload_1
    //   5713: invokevirtual 519	java/lang/Exception:printStackTrace	()V
    //   5716: iconst_0
    //   5717: istore 6
    //   5719: iconst_0
    //   5720: istore 7
    //   5722: goto -81 -> 5641
    //   5725: aload_1
    //   5726: aload_2
    //   5727: invokestatic 1040	axtt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   5730: ifeq +18 -> 5748
    //   5733: aload 19
    //   5735: aload_2
    //   5736: invokevirtual 1044	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5739: aconst_null
    //   5740: iconst_0
    //   5741: iconst_0
    //   5742: aload 4
    //   5744: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5747: return
    //   5748: aload_2
    //   5749: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5752: ifnonnull +11 -> 5763
    //   5755: aload 4
    //   5757: ldc 120
    //   5759: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5762: return
    //   5763: aload_2
    //   5764: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5767: sipush -5003
    //   5770: if_icmpne +13 -> 5783
    //   5773: aload 4
    //   5775: aload_2
    //   5776: invokevirtual 1044	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5779: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5782: return
    //   5783: aload_2
    //   5784: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5787: sipush -2033
    //   5790: if_icmpne +16 -> 5806
    //   5793: aconst_null
    //   5794: getstatic 1049	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   5797: aconst_null
    //   5798: iconst_0
    //   5799: iconst_0
    //   5800: aload 4
    //   5802: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5805: return
    //   5806: aload_2
    //   5807: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5810: sipush -2049
    //   5813: if_icmpne +16 -> 5829
    //   5816: aload 4
    //   5818: aload_2
    //   5819: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5822: invokestatic 561	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5825: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5828: return
    //   5829: aload_2
    //   5830: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5833: sipush -1035
    //   5836: if_icmpne +287 -> 6123
    //   5839: iconst_0
    //   5840: istore 10
    //   5842: iconst_0
    //   5843: istore 11
    //   5845: iload 10
    //   5847: istore 6
    //   5849: iload 11
    //   5851: istore 7
    //   5853: aload_2
    //   5854: invokevirtual 307	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5857: ifeq +31 -> 5888
    //   5860: aload_2
    //   5861: getfield 933	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   5864: ldc_w 1050
    //   5867: if_icmpne +171 -> 6038
    //   5870: aload_1
    //   5871: invokevirtual 1053	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   5874: aload_2
    //   5875: invokevirtual 1056	bcrg:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5878: ifne +150 -> 6028
    //   5881: iconst_1
    //   5882: istore 6
    //   5884: iload 11
    //   5886: istore 7
    //   5888: aload_2
    //   5889: invokevirtual 1044	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5892: astore_0
    //   5893: aload_2
    //   5894: invokestatic 1059	bgty:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5897: ifeq +1624 -> 7521
    //   5900: aload_2
    //   5901: invokestatic 1061	bgty:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5904: ifne +7 -> 5911
    //   5907: aload_2
    //   5908: invokestatic 1064	bgty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   5911: aload_2
    //   5912: invokestatic 1067	bgty:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   5915: astore_1
    //   5916: aload_1
    //   5917: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5920: ifne +1601 -> 7521
    //   5923: aload_1
    //   5924: astore_0
    //   5925: aload_2
    //   5926: getfield 1070	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   5929: ifnull +177 -> 6106
    //   5932: aload_0
    //   5933: ifnull +173 -> 6106
    //   5936: new 161	java/lang/StringBuilder
    //   5939: dup
    //   5940: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   5943: astore_1
    //   5944: aload 19
    //   5946: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5949: ifne +16 -> 5965
    //   5952: aload_1
    //   5953: aload 19
    //   5955: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5958: ldc_w 426
    //   5961: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5964: pop
    //   5965: aload_2
    //   5966: invokestatic 282	nlj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   5969: ifne +16 -> 5985
    //   5972: iload 6
    //   5974: ifeq +89 -> 6063
    //   5977: aload_1
    //   5978: ldc_w 759
    //   5981: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5984: pop
    //   5985: aload_0
    //   5986: instanceof 761
    //   5989: ifeq +90 -> 6079
    //   5992: aload_0
    //   5993: checkcast 761	begp
    //   5996: aload_1
    //   5997: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6000: iconst_1
    //   6001: iconst_0
    //   6002: newarray int
    //   6004: invokevirtual 764	begp:a	(Ljava/lang/String;Z[I)Lbegp;
    //   6007: astore_0
    //   6008: aload 4
    //   6010: iconst_1
    //   6011: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6014: aload 19
    //   6016: aload_0
    //   6017: aconst_null
    //   6018: iload 6
    //   6020: iload 7
    //   6022: aload 4
    //   6024: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6027: return
    //   6028: iconst_1
    //   6029: istore 7
    //   6031: iload 10
    //   6033: istore 6
    //   6035: goto -147 -> 5888
    //   6038: iconst_0
    //   6039: istore 7
    //   6041: aload_2
    //   6042: getfield 933	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6045: ldc_w 640
    //   6048: if_icmpne +9 -> 6057
    //   6051: iconst_1
    //   6052: istore 6
    //   6054: goto -166 -> 5888
    //   6057: iconst_0
    //   6058: istore 6
    //   6060: goto -6 -> 6054
    //   6063: iload 7
    //   6065: ifeq -80 -> 5985
    //   6068: aload_1
    //   6069: ldc_w 767
    //   6072: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6075: pop
    //   6076: goto -91 -> 5985
    //   6079: aload_1
    //   6080: aload_0
    //   6081: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6084: pop
    //   6085: new 1075	android/text/SpannableString
    //   6088: dup
    //   6089: aload_1
    //   6090: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6093: invokespecial 1078	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6096: astore_0
    //   6097: aload 4
    //   6099: iconst_0
    //   6100: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6103: goto -89 -> 6014
    //   6106: aload 19
    //   6108: aload_0
    //   6109: invokestatic 1081	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6112: aconst_null
    //   6113: iload 6
    //   6115: iload 7
    //   6117: aload 4
    //   6119: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6122: return
    //   6123: aload_2
    //   6124: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6127: sipush -2057
    //   6130: if_icmpne +17 -> 6147
    //   6133: aload 19
    //   6135: getstatic 1086	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6138: aconst_null
    //   6139: iconst_0
    //   6140: iconst_0
    //   6141: aload 4
    //   6143: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6146: return
    //   6147: aload_2
    //   6148: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6151: sipush -1012
    //   6154: if_icmpne +70 -> 6224
    //   6157: aload_2
    //   6158: invokevirtual 1044	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6161: invokeinterface 1089 1 0
    //   6166: invokestatic 561	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6169: astore_1
    //   6170: aload_0
    //   6171: ldc_w 1090
    //   6174: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6177: astore_2
    //   6178: aload_1
    //   6179: invokevirtual 205	java/lang/String:length	()I
    //   6182: aload_2
    //   6183: invokevirtual 205	java/lang/String:length	()I
    //   6186: isub
    //   6187: iconst_1
    //   6188: isub
    //   6189: istore_3
    //   6190: aload_1
    //   6191: astore_0
    //   6192: aload_1
    //   6193: aload_2
    //   6194: invokevirtual 124	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6197: ifeq +16 -> 6213
    //   6200: aload_1
    //   6201: astore_0
    //   6202: iload_3
    //   6203: ifle +10 -> 6213
    //   6206: aload_1
    //   6207: iconst_0
    //   6208: iload_3
    //   6209: invokevirtual 350	java/lang/String:substring	(II)Ljava/lang/String;
    //   6212: astore_0
    //   6213: aconst_null
    //   6214: aload_0
    //   6215: aconst_null
    //   6216: iconst_0
    //   6217: iconst_0
    //   6218: aload 4
    //   6220: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6223: return
    //   6224: aload_2
    //   6225: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6228: sipush -2059
    //   6231: if_icmpne +33 -> 6264
    //   6234: new 1092	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6237: dup
    //   6238: invokespecial 1093	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6241: astore_0
    //   6242: aload_0
    //   6243: aload_2
    //   6244: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6247: putfield 1094	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6250: aload_0
    //   6251: invokevirtual 1097	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6254: aload 4
    //   6256: aload_0
    //   6257: invokevirtual 1098	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6260: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6263: return
    //   6264: aload_2
    //   6265: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6268: sipush -2066
    //   6271: if_icmpne +87 -> 6358
    //   6274: new 1100	com/tencent/mobileqq/data/MessageForConfessCard
    //   6277: dup
    //   6278: invokespecial 1101	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6281: astore_0
    //   6282: aload_0
    //   6283: aload_2
    //   6284: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6287: putfield 1102	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6290: aload_0
    //   6291: invokevirtual 1103	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6294: aload_2
    //   6295: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6298: sipush 1032
    //   6301: if_icmpne +18 -> 6319
    //   6304: aload 19
    //   6306: aload_0
    //   6307: getfield 1106	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6310: aconst_null
    //   6311: iconst_0
    //   6312: iconst_0
    //   6313: aload 4
    //   6315: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6318: return
    //   6319: ldc 120
    //   6321: new 161	java/lang/StringBuilder
    //   6324: dup
    //   6325: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   6328: aload 19
    //   6330: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6333: ldc_w 1108
    //   6336: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6339: aload_0
    //   6340: getfield 1106	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6343: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6346: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6349: aconst_null
    //   6350: iconst_0
    //   6351: iconst_0
    //   6352: aload 4
    //   6354: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6357: return
    //   6358: aload_2
    //   6359: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6362: sipush -2067
    //   6365: if_icmpne +38 -> 6403
    //   6368: new 1110	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6371: dup
    //   6372: invokespecial 1111	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6375: astore_0
    //   6376: aload_0
    //   6377: aload_2
    //   6378: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6381: putfield 1112	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6384: aload_0
    //   6385: invokevirtual 1113	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6388: aload 19
    //   6390: aload_0
    //   6391: getfield 1114	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6394: aconst_null
    //   6395: iconst_0
    //   6396: iconst_0
    //   6397: aload 4
    //   6399: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6402: return
    //   6403: aload_2
    //   6404: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6407: sipush -5008
    //   6410: if_icmpeq +23 -> 6433
    //   6413: aload_2
    //   6414: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6417: sipush -5016
    //   6420: if_icmpeq +13 -> 6433
    //   6423: aload_2
    //   6424: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6427: sipush -5017
    //   6430: if_icmpne +113 -> 6543
    //   6433: aload_2
    //   6434: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6437: sipush -5016
    //   6440: if_icmpne +64 -> 6504
    //   6443: new 1116	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6446: dup
    //   6447: invokespecial 1117	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6450: astore_0
    //   6451: aload_0
    //   6452: aload_2
    //   6453: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6456: putfield 1118	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6459: aload_0
    //   6460: invokevirtual 1119	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6463: aload 4
    //   6465: aload_0
    //   6466: invokevirtual 1122	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6469: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6472: aload_1
    //   6473: aload_2
    //   6474: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6477: istore 6
    //   6479: aload_1
    //   6480: aload_2
    //   6481: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6484: istore 7
    //   6486: aload 19
    //   6488: aload 4
    //   6490: getfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6493: aconst_null
    //   6494: iload 6
    //   6496: iload 7
    //   6498: aload 4
    //   6500: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6503: return
    //   6504: new 1124	com/tencent/mobileqq/data/MessageForArkApp
    //   6507: dup
    //   6508: invokespecial 1125	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6511: astore_0
    //   6512: aload_0
    //   6513: aload_2
    //   6514: getfield 746	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6517: putfield 1126	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6520: aload_0
    //   6521: invokevirtual 1127	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6524: aload 4
    //   6526: aload_0
    //   6527: invokevirtual 1128	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6530: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6533: aload_2
    //   6534: aload 4
    //   6536: aload_1
    //   6537: invokestatic 1131	bhnt:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   6540: goto -68 -> 6472
    //   6543: aload_1
    //   6544: aload_2
    //   6545: invokestatic 589	bhnt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6548: istore 6
    //   6550: aload_1
    //   6551: aload_2
    //   6552: invokestatic 591	bhnt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6555: istore 7
    //   6557: aload_2
    //   6558: getfield 1134	com/tencent/imcore/message/QQMessageFacade$Message:fileType	I
    //   6561: lookupswitch	default:+51->6612, 1:+174->6735, 2:+255->6816, 8:+255->6816, 65536:+156->6717, 65538:+237->6798
    //   6613: ldc_w 715
    //   6616: invokevirtual 718	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6619: astore 5
    //   6621: getstatic 723	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   6624: ifeq +295 -> 6919
    //   6627: aload 5
    //   6629: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6632: ifne +287 -> 6919
    //   6635: aload_1
    //   6636: aload_2
    //   6637: aload 4
    //   6639: invokestatic 757	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lbegp;
    //   6642: astore_0
    //   6643: new 161	java/lang/StringBuilder
    //   6646: dup
    //   6647: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   6650: astore_1
    //   6651: aload 19
    //   6653: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6656: ifne +16 -> 6672
    //   6659: aload_1
    //   6660: aload 19
    //   6662: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6665: ldc_w 426
    //   6668: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6671: pop
    //   6672: aload_2
    //   6673: invokestatic 282	nlj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6676: ifne +16 -> 6692
    //   6679: iload 6
    //   6681: ifeq +222 -> 6903
    //   6684: aload_1
    //   6685: ldc_w 759
    //   6688: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6691: pop
    //   6692: aload 19
    //   6694: aload_0
    //   6695: aload_1
    //   6696: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6699: iconst_1
    //   6700: iconst_0
    //   6701: newarray int
    //   6703: invokevirtual 764	begp:a	(Ljava/lang/String;Z[I)Lbegp;
    //   6706: aconst_null
    //   6707: iload 6
    //   6709: iload 7
    //   6711: aload 4
    //   6713: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6716: return
    //   6717: aload 19
    //   6719: ldc 120
    //   6721: aload_2
    //   6722: getfield 556	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6725: iload 6
    //   6727: iload 7
    //   6729: aload 4
    //   6731: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6734: return
    //   6735: aload_2
    //   6736: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6739: sipush 1001
    //   6742: if_icmpeq +13 -> 6755
    //   6745: aload_2
    //   6746: getfield 38	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6749: sipush 10002
    //   6752: if_icmpne +26 -> 6778
    //   6755: aload_2
    //   6756: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6759: sipush -3001
    //   6762: if_icmpne +16 -> 6778
    //   6765: aload 4
    //   6767: aload_0
    //   6768: ldc_w 1135
    //   6771: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6774: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6777: return
    //   6778: aload 19
    //   6780: aload_0
    //   6781: ldc_w 626
    //   6784: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6787: aconst_null
    //   6788: iload 6
    //   6790: iload 7
    //   6792: aload 4
    //   6794: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6797: return
    //   6798: aload 19
    //   6800: aload_0
    //   6801: ldc_w 626
    //   6804: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6807: aconst_null
    //   6808: iconst_0
    //   6809: iconst_0
    //   6810: aload 4
    //   6812: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6815: return
    //   6816: ldc_w 656
    //   6819: iconst_3
    //   6820: anewarray 4	java/lang/Object
    //   6823: dup
    //   6824: iconst_0
    //   6825: iload_3
    //   6826: invokestatic 681	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6829: aastore
    //   6830: dup
    //   6831: iconst_1
    //   6832: iload 6
    //   6834: invokestatic 661	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6837: aastore
    //   6838: dup
    //   6839: iconst_2
    //   6840: iload 7
    //   6842: invokestatic 661	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6845: aastore
    //   6846: invokestatic 666	asam:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6849: aload_0
    //   6850: ldc_w 646
    //   6853: invokevirtual 209	android/content/Context:getString	(I)Ljava/lang/String;
    //   6856: astore_0
    //   6857: aload_2
    //   6858: getfield 196	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   6861: aload_1
    //   6862: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6865: invokestatic 1138	bhjx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6868: ifeq +22 -> 6890
    //   6871: iload_3
    //   6872: ifeq +18 -> 6890
    //   6875: aload 19
    //   6877: aload_0
    //   6878: ldc 120
    //   6880: iload 6
    //   6882: iload 7
    //   6884: aload 4
    //   6886: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6889: return
    //   6890: aload 19
    //   6892: aload_0
    //   6893: ldc 120
    //   6895: iconst_0
    //   6896: iconst_0
    //   6897: aload 4
    //   6899: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6902: return
    //   6903: iload 7
    //   6905: ifeq -213 -> 6692
    //   6908: aload_1
    //   6909: ldc_w 767
    //   6912: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6915: pop
    //   6916: goto -224 -> 6692
    //   6919: aload_2
    //   6920: invokevirtual 1044	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6923: astore 5
    //   6925: aload_2
    //   6926: invokestatic 1059	bgty:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6929: ifeq +589 -> 7518
    //   6932: aload_2
    //   6933: invokestatic 1061	bgty:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6936: ifne +7 -> 6943
    //   6939: aload_2
    //   6940: invokestatic 1064	bgty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6943: aload_2
    //   6944: invokestatic 1067	bgty:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6947: astore 16
    //   6949: aload 16
    //   6951: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6954: ifne +564 -> 7518
    //   6957: aload 16
    //   6959: astore 5
    //   6961: aload_2
    //   6962: getfield 1070	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6965: ifnull +389 -> 7354
    //   6968: aload 5
    //   6970: ifnull +384 -> 7354
    //   6973: new 161	java/lang/StringBuilder
    //   6976: dup
    //   6977: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   6980: astore_0
    //   6981: aload 19
    //   6983: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6986: ifne +16 -> 7002
    //   6989: aload_0
    //   6990: aload 19
    //   6992: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6995: ldc_w 426
    //   6998: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7001: pop
    //   7002: aload_2
    //   7003: invokestatic 282	nlj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7006: ifne +16 -> 7022
    //   7009: iload 6
    //   7011: ifeq +299 -> 7310
    //   7014: aload_0
    //   7015: ldc_w 759
    //   7018: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7021: pop
    //   7022: aload 5
    //   7024: instanceof 761
    //   7027: ifeq +299 -> 7326
    //   7030: aload 5
    //   7032: checkcast 761	begp
    //   7035: aload_0
    //   7036: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7039: iconst_1
    //   7040: iconst_3
    //   7041: newarray int
    //   7043: dup
    //   7044: iconst_0
    //   7045: aload 5
    //   7047: checkcast 761	begp
    //   7050: getfield 1139	begp:jdField_a_of_type_Int	I
    //   7053: iastore
    //   7054: dup
    //   7055: iconst_1
    //   7056: bipush 16
    //   7058: iastore
    //   7059: dup
    //   7060: iconst_2
    //   7061: iconst_1
    //   7062: iastore
    //   7063: invokevirtual 764	begp:a	(Ljava/lang/String;Z[I)Lbegp;
    //   7066: astore_0
    //   7067: aload 4
    //   7069: iconst_1
    //   7070: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7073: aload_2
    //   7074: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7077: sipush -5040
    //   7080: if_icmpne +435 -> 7515
    //   7083: new 161	java/lang/StringBuilder
    //   7086: dup
    //   7087: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   7090: ldc_w 530
    //   7093: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7096: invokestatic 411	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7099: ldc_w 1140
    //   7102: invokevirtual 413	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7105: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7108: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7111: astore 5
    //   7113: aload_0
    //   7114: invokeinterface 1089 1 0
    //   7119: astore 16
    //   7121: aload 16
    //   7123: ifnull +386 -> 7509
    //   7126: aload 16
    //   7128: aload 5
    //   7130: invokevirtual 1143	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7133: ifeq +376 -> 7509
    //   7136: aload 16
    //   7138: aload 5
    //   7140: ldc 120
    //   7142: invokevirtual 275	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7145: astore 5
    //   7147: aload 5
    //   7149: astore_0
    //   7150: iload_3
    //   7151: ifne +77 -> 7228
    //   7154: aload_1
    //   7155: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7158: aload_2
    //   7159: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7162: iconst_0
    //   7163: invokevirtual 1146	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7166: astore 16
    //   7168: aload 5
    //   7170: astore_0
    //   7171: aload 16
    //   7173: instanceof 1148
    //   7176: ifeq +52 -> 7228
    //   7179: aload 5
    //   7181: astore_0
    //   7182: aload 16
    //   7184: checkcast 1148	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7187: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavpd;
    //   7190: ifnull +38 -> 7228
    //   7193: aload 5
    //   7195: astore_0
    //   7196: aload 16
    //   7198: checkcast 1148	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7201: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavpd;
    //   7204: getfield 1156	avpd:b	I
    //   7207: invokestatic 1159	axsr:b	(I)Z
    //   7210: ifeq +18 -> 7228
    //   7213: aload_1
    //   7214: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7217: aload 5
    //   7219: invokeinterface 1089 1 0
    //   7224: invokestatic 1162	axtt:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7227: astore_0
    //   7228: aload_2
    //   7229: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7232: invokestatic 1165	adak:j	(I)Z
    //   7235: ifeq +271 -> 7506
    //   7238: aload_1
    //   7239: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7242: aload_2
    //   7243: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7246: iload_3
    //   7247: invokevirtual 1146	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7250: astore_1
    //   7251: aload_1
    //   7252: ifnull +254 -> 7506
    //   7255: aload_1
    //   7256: instanceof 1148
    //   7259: ifeq +247 -> 7506
    //   7262: aload_1
    //   7263: checkcast 1148	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7266: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavpd;
    //   7269: ifnull +237 -> 7506
    //   7272: aload_1
    //   7273: checkcast 1148	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7276: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavpd;
    //   7279: getfield 1156	avpd:b	I
    //   7282: ldc_w 1166
    //   7285: if_icmpne +221 -> 7506
    //   7288: aload_1
    //   7289: checkcast 1148	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7292: invokevirtual 1167	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7295: astore_0
    //   7296: aload 19
    //   7298: aload_0
    //   7299: aconst_null
    //   7300: iload 6
    //   7302: iload 7
    //   7304: aload 4
    //   7306: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7309: return
    //   7310: iload 7
    //   7312: ifeq -290 -> 7022
    //   7315: aload_0
    //   7316: ldc_w 767
    //   7319: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7322: pop
    //   7323: goto -301 -> 7022
    //   7326: aload_0
    //   7327: aload 5
    //   7329: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7332: pop
    //   7333: new 1075	android/text/SpannableString
    //   7336: dup
    //   7337: aload_0
    //   7338: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7341: invokespecial 1078	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7344: astore_0
    //   7345: aload 4
    //   7347: iconst_0
    //   7348: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7351: goto -278 -> 7073
    //   7354: aload 5
    //   7356: ifnull +114 -> 7470
    //   7359: aload 5
    //   7361: invokeinterface 1089 1 0
    //   7366: invokevirtual 189	java/lang/String:trim	()Ljava/lang/String;
    //   7369: astore 5
    //   7371: getstatic 1170	antf:G	Ljava/lang/String;
    //   7374: aload_2
    //   7375: getfield 35	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7378: invokevirtual 1173	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7381: ifeq +119 -> 7500
    //   7384: aload 5
    //   7386: ifnull +114 -> 7500
    //   7389: aload 5
    //   7391: invokevirtual 205	java/lang/String:length	()I
    //   7394: ifle +106 -> 7500
    //   7397: aload_0
    //   7398: aload_1
    //   7399: aload 5
    //   7401: aload_2
    //   7402: invokestatic 1175	bhnt:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   7405: astore_0
    //   7406: aload 19
    //   7408: aconst_null
    //   7409: aload_0
    //   7410: iload 6
    //   7412: aload_1
    //   7413: invokevirtual 1053	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   7416: aload_2
    //   7417: invokevirtual 1056	bcrg:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7420: aload 4
    //   7422: invokestatic 583	bhnt:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7425: aload_2
    //   7426: getfield 175	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7429: sipush -1000
    //   7432: if_icmpne +44 -> 7476
    //   7435: aload 4
    //   7437: getfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7440: ifnull +36 -> 7476
    //   7443: aload 4
    //   7445: new 761	begp
    //   7448: dup
    //   7449: aload 4
    //   7451: getfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7454: iconst_1
    //   7455: bipush 16
    //   7457: invokespecial 1178	begp:<init>	(Ljava/lang/CharSequence;II)V
    //   7460: putfield 567	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7463: aload 4
    //   7465: iconst_1
    //   7466: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7469: return
    //   7470: aconst_null
    //   7471: astore 5
    //   7473: goto -102 -> 7371
    //   7476: aload 4
    //   7478: iconst_0
    //   7479: putfield 778	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7482: return
    //   7483: astore 5
    //   7485: goto -2502 -> 4983
    //   7488: astore 17
    //   7490: aload 16
    //   7492: astore_1
    //   7493: aload 17
    //   7495: astore 16
    //   7497: goto -6892 -> 605
    //   7500: aload 5
    //   7502: astore_0
    //   7503: goto -97 -> 7406
    //   7506: goto -210 -> 7296
    //   7509: aload_0
    //   7510: astore 5
    //   7512: goto -365 -> 7147
    //   7515: goto -287 -> 7228
    //   7518: goto -557 -> 6961
    //   7521: goto -1596 -> 5925
    //   7524: iconst_0
    //   7525: istore 6
    //   7527: iconst_0
    //   7528: istore 7
    //   7530: goto -1889 -> 5641
    //   7533: goto -4085 -> 3448
    //   7536: iconst_0
    //   7537: istore 6
    //   7539: goto -5317 -> 2222
    //   7542: goto -5403 -> 2139
    //   7545: aload 5
    //   7547: astore_0
    //   7548: goto -5735 -> 1813
    //   7551: iconst_0
    //   7552: istore 7
    //   7554: iconst_0
    //   7555: istore 6
    //   7557: goto -6747 -> 810
    //   7560: goto -6830 -> 730
    //   7563: aload_1
    //   7564: astore_0
    //   7565: goto -7053 -> 512
    //   7568: iconst_0
    //   7569: istore 6
    //   7571: goto -7117 -> 454
    //   7574: iconst_0
    //   7575: istore 6
    //   7577: goto -7186 -> 391
    //   7580: iconst_0
    //   7581: istore 6
    //   7583: goto -7231 -> 352
    //   7586: goto -7313 -> 273
    //   7589: iconst_0
    //   7590: istore 6
    //   7592: goto -7240 -> 352
    //   7595: iconst_1
    //   7596: istore_3
    //   7597: goto -5898 -> 1699
    //   7600: astore_1
    //   7601: aload 17
    //   7603: astore_0
    //   7604: goto -5705 -> 1899
    //   7607: iconst_0
    //   7608: istore 6
    //   7610: goto -5388 -> 2222
    //   7613: ldc2_w 39
    //   7616: lstore 14
    //   7618: goto -5316 -> 2302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7621	0	paramContext	Context
    //   0	7621	1	paramQQAppInterface	QQAppInterface
    //   0	7621	2	paramMessage	QQMessageFacade.Message
    //   0	7621	3	paramInt	int
    //   0	7621	4	paramMsgSummary	MsgSummary
    //   0	7621	5	paramString	String
    //   0	7621	6	paramBoolean1	boolean
    //   0	7621	7	paramBoolean2	boolean
    //   70	5630	8	i	int
    //   1568	522	9	j	int
    //   637	5395	10	bool1	boolean
    //   2093	3792	11	bool2	boolean
    //   1508	543	12	bool3	boolean
    //   1515	546	13	bool4	boolean
    //   336	7281	14	l	long
    //   293	242	16	localObject1	Object
    //   601	5	16	localException1	Exception
    //   615	6881	16	localObject2	Object
    //   251	2280	17	localObject3	Object
    //   7488	114	17	localException2	Exception
    //   242	1924	18	str1	String
    //   14	7393	19	str2	String
    //   2163	256	20	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   247	273	601	java/lang/Exception
    //   273	295	601	java/lang/Exception
    //   1746	1775	1898	java/lang/Exception
    //   1775	1782	1898	java/lang/Exception
    //   1787	1795	1898	java/lang/Exception
    //   1795	1811	1898	java/lang/Exception
    //   1887	1895	1898	java/lang/Exception
    //   2105	2111	2485	java/lang/Exception
    //   2115	2129	2485	java/lang/Exception
    //   2133	2139	2485	java/lang/Exception
    //   2143	2165	2485	java/lang/Exception
    //   2169	2183	2485	java/lang/Exception
    //   2186	2193	2485	java/lang/Exception
    //   2196	2203	2485	java/lang/Exception
    //   2418	2429	2485	java/lang/Exception
    //   2442	2449	2485	java/lang/Exception
    //   2452	2461	2485	java/lang/Exception
    //   2640	2675	2776	java/lang/Throwable
    //   2691	2741	2776	java/lang/Throwable
    //   2746	2771	2776	java/lang/Throwable
    //   4503	4509	4979	java/lang/Exception
    //   4509	4529	4979	java/lang/Exception
    //   4529	4543	4979	java/lang/Exception
    //   5571	5577	5711	java/lang/Exception
    //   5577	5597	5711	java/lang/Exception
    //   5597	5630	5711	java/lang/Exception
    //   5661	5669	5711	java/lang/Exception
    //   5678	5696	5711	java/lang/Exception
    //   4543	4571	7483	java/lang/Exception
    //   4575	4655	7483	java/lang/Exception
    //   4889	4896	7483	java/lang/Exception
    //   4900	4908	7483	java/lang/Exception
    //   4912	4923	7483	java/lang/Exception
    //   4931	4942	7483	java/lang/Exception
    //   4946	4957	7483	java/lang/Exception
    //   4957	4973	7483	java/lang/Exception
    //   299	313	7488	java/lang/Exception
    //   316	323	7488	java/lang/Exception
    //   331	338	7488	java/lang/Exception
    //   534	545	7488	java/lang/Exception
    //   558	565	7488	java/lang/Exception
    //   568	577	7488	java/lang/Exception
    //   1524	1533	7600	java/lang/Exception
    //   1541	1549	7600	java/lang/Exception
    //   1553	1570	7600	java/lang/Exception
    //   1581	1588	7600	java/lang/Exception
    //   1614	1627	7600	java/lang/Exception
    //   1631	1637	7600	java/lang/Exception
    //   1641	1648	7600	java/lang/Exception
    //   1652	1666	7600	java/lang/Exception
    //   1670	1696	7600	java/lang/Exception
    //   1711	1717	7600	java/lang/Exception
    //   1721	1734	7600	java/lang/Exception
    //   1738	1746	7600	java/lang/Exception
    //   1837	1863	7600	java/lang/Exception
    //   1870	1877	7600	java/lang/Exception
    //   1934	1939	7600	java/lang/Exception
    //   1947	1955	7600	java/lang/Exception
    //   1959	1967	7600	java/lang/Exception
    //   1971	1984	7600	java/lang/Exception
    //   1988	1995	7600	java/lang/Exception
    //   2004	2012	7600	java/lang/Exception
    //   2016	2032	7600	java/lang/Exception
    //   2036	2042	7600	java/lang/Exception
    //   2046	2059	7600	java/lang/Exception
    //   2069	2077	7600	java/lang/Exception
    //   2230	2237	7600	java/lang/Exception
    //   2241	2246	7600	java/lang/Exception
    //   2250	2261	7600	java/lang/Exception
    //   2272	2278	7600	java/lang/Exception
    //   2282	2289	7600	java/lang/Exception
    //   2293	2302	7600	java/lang/Exception
    //   2306	2347	7600	java/lang/Exception
    //   2355	2363	7600	java/lang/Exception
    //   2367	2374	7600	java/lang/Exception
    //   2378	2385	7600	java/lang/Exception
    //   2389	2397	7600	java/lang/Exception
    //   2401	2414	7600	java/lang/Exception
    //   2490	2494	7600	java/lang/Exception
    //   2522	2528	7600	java/lang/Exception
    //   2532	2559	7600	java/lang/Exception
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
      paramMsgSummary.strContent += paramQQAppInterface.getApp().getString(2131692545);
    }
  }
  
  private static void a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessage != null) && (1 == paramInt))
    {
      paramQQAppInterface = bhlg.g(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
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
      if (((adbi)localIterator.next()).a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
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
    if (adak.b(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (adak.b(paramMessage.senderuin)) {
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
          paramQQAppInterface = bgsk.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof berv)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((berv)paramMessage).f() >= 0) && (((berv)paramMessage).f() != 100)) {
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
      if ((paramQQAppInterface instanceof berp))
      {
        long l = ((berp)paramQQAppInterface).c();
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
          if (!adak.b(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (adak.b(paramMessage.senderuin));
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
      paramQQAppInterface = bgsk.a(paramQQAppInterface, paramMessage);
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
 * Qualified Name:     bhnt
 * JD-Core Version:    0.7.0.1
 */