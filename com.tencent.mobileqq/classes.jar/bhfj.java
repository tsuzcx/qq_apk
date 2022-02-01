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
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public class bhfj
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
      j = paramQQAppInterface.getFileManagerRSCenter().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
    Object localObject = paramQQAppInterface.getFileManagerDataCenter().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
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
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((EntityManager)localObject).close();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = auea.b(paramQQAppInterface.status);
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
    paramContext = paramQQAppInterface.getMsgHandler().a(bhch.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131690120);
    }
    return paramQQAppInterface.getApp().getString(2131690122) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131690123);
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
        String str2 = bhbv.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = ContactUtils.getBuddyName(paramQQAppInterface, paramMessage.senderuin, true);
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
                  paramContext = paramContext.getString(2131689583);
                  break;
                  paramContext = paramContext.getString(2131689498);
                  break;
                  paramContext = paramContext.getString(2131689497);
                  break;
                  paramContext = paramContext.getString(2131718020);
                  break;
                  paramContext = paramContext.getString(2131689620);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = bhbv.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = ContactUtils.getBuddyName(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return bhbv.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
    paramString = bhbv.a(paramString, paramQQAppInterface);
    paramMessage = bhbv.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = ContactUtils.getBuddyName(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = bhbv.a(paramString, paramMessage, paramQQAppInterface);
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131693131));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131694023));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131718414));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  @Nullable
  private static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    String str = paramString;
    if (nty.a(paramMessage)) {
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (paramString.equals(ContactUtils.getTroopName(paramQQAppInterface, paramMessage.frienduin, true))) {}
      }
      else
      {
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if ((paramQQAppInterface instanceof ChatMessage)) {
          ((ChatMessage)paramQQAppInterface).parse();
        }
        if (paramQQAppInterface != null) {
          paramString = nty.a(paramQQAppInterface).b;
        }
        str = paramString;
        if (!TextUtils.isEmpty(paramString)) {}
      }
    }
    for (paramQQAppInterface = nty.a(paramMessage).b;; paramQQAppInterface = str)
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
      if (acnh.l(paramMessage.msgtype)) {}
      for (paramQQAppInterface = localObject;; paramQQAppInterface = paramString)
      {
        paramMessage = bgiz.a(paramMessage);
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
    //   7: ldc 123
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
    //   41: invokestatic 263	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   44: istore 7
    //   46: iload 7
    //   48: tableswitch	default:+20 -> 68, 13:+148->196
    //   69: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: ldc_w 344
    //   75: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   78: astore_3
    //   79: iload 5
    //   81: iconst_1
    //   82: if_icmpeq +11 -> 93
    //   85: iload 5
    //   87: sipush 5000
    //   90: if_icmpne +14 -> 104
    //   93: aload_2
    //   94: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   97: ldc_w 348
    //   100: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   103: astore_3
    //   104: aload_1
    //   105: arraylength
    //   106: iconst_5
    //   107: if_icmple +302 -> 409
    //   110: aload_1
    //   111: iconst_4
    //   112: aaload
    //   113: invokestatic 263	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore 5
    //   118: aload_1
    //   119: iconst_5
    //   120: aaload
    //   121: invokestatic 263	java/lang/Integer:parseInt	(Ljava/lang/String;)I
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
    //   141: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   144: ldc_w 349
    //   147: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   150: astore_1
    //   151: new 165	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 351
    //   161: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_3
    //   173: aload_0
    //   174: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   177: ldc_w 348
    //   180: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   183: aload_1
    //   184: invokevirtual 280	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
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
    //   208: invokestatic 355	com/tencent/mobileqq/utils/ContactUtils:getDisplayName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   211: astore 4
    //   213: aload_2
    //   214: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc_w 344
    //   220: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   223: astore_3
    //   224: iload 5
    //   226: iconst_1
    //   227: if_icmpeq +11 -> 238
    //   230: iload 5
    //   232: sipush 5000
    //   235: if_icmpne +14 -> 249
    //   238: aload_2
    //   239: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   242: ldc_w 348
    //   245: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   248: astore_3
    //   249: aload 4
    //   251: invokevirtual 210	java/lang/String:length	()I
    //   254: bipush 11
    //   256: if_icmple +163 -> 419
    //   259: aload 4
    //   261: iconst_0
    //   262: bipush 10
    //   264: invokevirtual 359	java/lang/String:substring	(II)Ljava/lang/String;
    //   267: astore_2
    //   268: new 165	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   275: aload_2
    //   276: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 361
    //   282: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_2
    //   289: new 165	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   296: aload_2
    //   297: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_3
    //   301: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_3
    //   308: goto -204 -> 104
    //   311: iload 5
    //   313: iconst_1
    //   314: if_icmpeq +11 -> 325
    //   317: iload 5
    //   319: sipush 5000
    //   322: if_icmpne +17 -> 339
    //   325: aload_2
    //   326: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   329: ldc_w 362
    //   332: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   335: astore_3
    //   336: goto -232 -> 104
    //   339: aload_2
    //   340: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   343: ldc_w 363
    //   346: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   349: astore_3
    //   350: goto -246 -> 104
    //   353: iload 6
    //   355: iconst_5
    //   356: if_icmpne +17 -> 373
    //   359: aload_0
    //   360: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   363: ldc_w 364
    //   366: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   369: astore_1
    //   370: goto -219 -> 151
    //   373: aload_0
    //   374: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   377: ldc_w 362
    //   380: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   383: astore_1
    //   384: goto -233 -> 151
    //   387: ldc 123
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
            QLog.d("msgSummary", 2, "textSummary: " + bhbx.a(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (paramMessageForPic.picExtraData.isRelatedEmo()) || (aioi.b(paramMessageForPic)) || (asaa.b(paramMessageForPic)) || (aiin.a(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131691250);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131691250);
  }
  
  public static String a(String paramString)
  {
    String str = anvx.a(2131706447);
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
        localObject3 = anvx.a(2131706456);
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
              paramContext = paramContext.getResources().getString(2131695685);
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
        if (paramContext.getString(2131719939).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695702);
          }
          return paramContext.getResources().getString(2131695125);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695685) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695111) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131719943).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131695698);
            }
            return paramContext.getResources().getString(2131695697);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695120);
          }
          return paramContext.getResources().getString(2131695119);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695685) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695111) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695698);
          }
          return paramContext.getResources().getString(2131695697);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695120);
        }
        return paramContext.getResources().getString(2131695119);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131695698);
          }
          return paramContext.getResources().getString(2131695697);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131695120);
        }
        return paramContext.getResources().getString(2131695119);
        if (j != 0) {
          return paramContext.getResources().getString(2131695699);
        }
        return paramContext.getResources().getString(2131695121);
        if (j != 0) {
          return paramContext.getResources().getString(2131695685);
        }
        return paramContext.getResources().getString(2131695111);
        if (j != 0) {
          return paramContext.getResources().getString(2131695686);
        }
        return paramContext.getResources().getString(2131695113);
        if (j != 0) {
          return paramContext.getResources().getString(2131695701);
        }
        return paramContext.getResources().getString(2131695124);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131719939).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131695702);
          }
          return paramContext.getResources().getString(2131695125);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131695685) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131695111) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131695111) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131695111);
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
    //   11: invokestatic 559	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Ljava/lang/String;Z)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 19
    //   20: aload_2
    //   21: getfield 563	com/tencent/imcore/message/QQMessageFacade$Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   24: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +39 -> 66
    //   30: aload 5
    //   32: astore 19
    //   34: aload 5
    //   36: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +27 -> 66
    //   42: new 165	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   49: aload_2
    //   50: getfield 563	com/tencent/imcore/message/QQMessageFacade$Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   53: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 19
    //   66: aload_0
    //   67: aload_1
    //   68: aload_2
    //   69: iload_3
    //   70: aload 4
    //   72: aload 19
    //   74: iload 6
    //   76: iload 7
    //   78: invokestatic 569	bhfj:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   81: ifne -77 -> 4
    //   84: aload_2
    //   85: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   88: sipush -2034
    //   91: if_icmpne +16 -> 107
    //   94: aload 4
    //   96: aload_2
    //   97: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   100: invokestatic 577	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   103: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   106: return
    //   107: aload_2
    //   108: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   111: sipush -2011
    //   114: if_icmpne +157 -> 271
    //   117: iconst_0
    //   118: istore_3
    //   119: iconst_0
    //   120: istore 8
    //   122: aload_2
    //   123: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   126: sipush -2011
    //   129: if_icmpne +29 -> 158
    //   132: aload_2
    //   133: getfield 585	com/tencent/imcore/message/QQMessageFacade$Message:extInt	I
    //   136: bipush 61
    //   138: if_icmpne +20 -> 158
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   146: invokevirtual 586	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   149: ldc_w 587
    //   152: invokevirtual 347	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   155: putfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   158: aload_2
    //   159: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   162: iconst_1
    //   163: if_icmpne +73 -> 236
    //   166: aload_1
    //   167: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   170: aload_2
    //   171: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   174: aload_2
    //   175: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   178: aload_2
    //   179: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   182: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   185: astore_0
    //   186: iload 8
    //   188: istore_3
    //   189: aload_0
    //   190: invokestatic 590	axoi:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   193: ifeq +21 -> 214
    //   196: aconst_null
    //   197: aconst_null
    //   198: aload_0
    //   199: checkcast 592	com/tencent/mobileqq/data/MessageForStructing
    //   202: invokestatic 595	axoi:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   205: iconst_0
    //   206: iconst_0
    //   207: aload 4
    //   209: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   212: iconst_1
    //   213: istore_3
    //   214: aload_0
    //   215: invokestatic 601	bgiy:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   218: ifeq +18 -> 236
    //   221: iconst_1
    //   222: istore_3
    //   223: aconst_null
    //   224: aconst_null
    //   225: aload_2
    //   226: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   229: iconst_0
    //   230: iconst_0
    //   231: aload 4
    //   233: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   236: iload_3
    //   237: ifne -233 -> 4
    //   240: aload_1
    //   241: aload_2
    //   242: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   245: istore 6
    //   247: aload_1
    //   248: aload_2
    //   249: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   252: istore 7
    //   254: aload 19
    //   256: aconst_null
    //   257: aload_2
    //   258: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   261: iload 6
    //   263: iload 7
    //   265: aload 4
    //   267: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   270: return
    //   271: aload_2
    //   272: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   275: sipush -2000
    //   278: if_icmpeq +13 -> 291
    //   281: aload_2
    //   282: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   285: sipush -5015
    //   288: if_icmpne +446 -> 734
    //   291: aconst_null
    //   292: astore 18
    //   294: aconst_null
    //   295: astore 5
    //   297: aload_2
    //   298: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   301: astore 17
    //   303: aload_2
    //   304: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   307: aload_2
    //   308: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   311: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   314: ifeq +7498 -> 7812
    //   317: aload_2
    //   318: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   321: astore 17
    //   323: aload_1
    //   324: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   327: aload 17
    //   329: aload_2
    //   330: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   333: aload_2
    //   334: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   337: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   340: checkcast 367	com/tencent/mobileqq/data/MessageForPic
    //   343: astore 16
    //   345: aload 18
    //   347: astore 5
    //   349: aload_1
    //   350: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:getTransFileController	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   353: aload 17
    //   355: aload_2
    //   356: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   359: invokevirtual 619	com/tencent/mobileqq/transfile/TransFileController:findProcessor	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   362: astore_1
    //   363: aload_1
    //   364: astore 5
    //   366: aload_2
    //   367: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   370: ifeq +231 -> 601
    //   373: aload 16
    //   375: ifnull +201 -> 576
    //   378: aload_1
    //   379: astore 5
    //   381: aload 16
    //   383: getfield 622	com/tencent/mobileqq/data/MessageForPic:size	J
    //   386: lstore 14
    //   388: lload 14
    //   390: lconst_0
    //   391: lcmp
    //   392: ifgt +184 -> 576
    //   395: aload_1
    //   396: ifnonnull +7410 -> 7806
    //   399: iconst_1
    //   400: istore 6
    //   402: aload 16
    //   404: astore 5
    //   406: iload 6
    //   408: istore 7
    //   410: aload_1
    //   411: astore 16
    //   413: aload 16
    //   415: instanceof 624
    //   418: ifeq +263 -> 681
    //   421: aload 16
    //   423: checkcast 624	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   426: astore_1
    //   427: aload_1
    //   428: invokevirtual 627	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   431: ldc2_w 628
    //   434: lcmp
    //   435: ifeq +7365 -> 7800
    //   438: iconst_1
    //   439: istore 6
    //   441: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq +60 -> 504
    //   447: aload_1
    //   448: getfield 633	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   451: ifnull +222 -> 673
    //   454: aload_1
    //   455: getfield 633	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   458: getfield 638	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   461: lstore 14
    //   463: ldc_w 640
    //   466: iconst_2
    //   467: new 165	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 642
    //   477: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: lload 14
    //   482: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: ldc_w 644
    //   488: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_1
    //   492: invokevirtual 647	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   495: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload_0
    //   505: ldc_w 648
    //   508: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   511: astore_1
    //   512: aload_2
    //   513: invokestatic 651	anwf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   516: ifne +10 -> 526
    //   519: aload_2
    //   520: invokestatic 654	anud:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   523: ifeq +11 -> 534
    //   526: aload_0
    //   527: ldc_w 655
    //   530: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   533: astore_1
    //   534: aload_2
    //   535: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   538: sipush -5015
    //   541: if_icmpne +11 -> 552
    //   544: aload_0
    //   545: ldc_w 656
    //   548: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   551: astore_1
    //   552: aload 5
    //   554: invokestatic 658	bhfj:a	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   557: astore_0
    //   558: aload_0
    //   559: ifnull +7230 -> 7789
    //   562: aload 19
    //   564: aload_0
    //   565: aconst_null
    //   566: iload 7
    //   568: iload 6
    //   570: aload 4
    //   572: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   575: return
    //   576: aload 16
    //   578: ifnull +7228 -> 7806
    //   581: aload_1
    //   582: astore 5
    //   584: aload 16
    //   586: getfield 661	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   589: ldc_w 662
    //   592: if_icmpne +7223 -> 7815
    //   595: iconst_1
    //   596: istore 6
    //   598: goto -196 -> 402
    //   601: aload_1
    //   602: ifnull +7204 -> 7806
    //   605: aload_1
    //   606: astore 5
    //   608: aload_1
    //   609: instanceof 624
    //   612: ifeq +7194 -> 7806
    //   615: aload_1
    //   616: astore 5
    //   618: aload_1
    //   619: checkcast 624	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   622: invokevirtual 627	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   625: lstore 14
    //   627: lload 14
    //   629: l2i
    //   630: istore_3
    //   631: iload_3
    //   632: sipush 1005
    //   635: if_icmpeq +10 -> 645
    //   638: iload_3
    //   639: sipush 1004
    //   642: if_icmpne +7164 -> 7806
    //   645: iconst_1
    //   646: istore 6
    //   648: goto -246 -> 402
    //   651: astore 16
    //   653: aconst_null
    //   654: astore_1
    //   655: aload 16
    //   657: invokevirtual 528	java/lang/Exception:printStackTrace	()V
    //   660: iconst_0
    //   661: istore 7
    //   663: aload 5
    //   665: astore 16
    //   667: aload_1
    //   668: astore 5
    //   670: goto -257 -> 413
    //   673: ldc2_w 40
    //   676: lstore 14
    //   678: goto -215 -> 463
    //   681: aload 16
    //   683: ifnull +7111 -> 7794
    //   686: iconst_1
    //   687: istore 10
    //   689: iload 10
    //   691: istore 6
    //   693: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq -192 -> 504
    //   699: ldc_w 640
    //   702: iconst_2
    //   703: new 165	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   710: ldc_w 664
    //   713: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 16
    //   718: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: iload 10
    //   729: istore 6
    //   731: goto -227 -> 504
    //   734: aload_2
    //   735: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   738: sipush -2002
    //   741: if_icmpeq +13 -> 754
    //   744: aload_2
    //   745: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   748: sipush -1031
    //   751: if_icmpne +250 -> 1001
    //   754: aload_2
    //   755: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   758: astore 5
    //   760: aload_2
    //   761: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   764: aload_2
    //   765: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   768: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   771: ifeq +7015 -> 7786
    //   774: aload_2
    //   775: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   778: astore 5
    //   780: aload_0
    //   781: ldc_w 665
    //   784: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   787: astore_0
    //   788: aload_1
    //   789: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   792: aload 5
    //   794: aload_2
    //   795: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   798: aload_2
    //   799: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   802: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   805: astore 16
    //   807: aload 16
    //   809: instanceof 667
    //   812: ifeq +6965 -> 7777
    //   815: aload 16
    //   817: checkcast 667	com/tencent/mobileqq/data/MessageForPtt
    //   820: astore 17
    //   822: aload 17
    //   824: invokevirtual 670	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   827: astore 16
    //   829: aload 16
    //   831: astore_0
    //   832: aload_2
    //   833: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   836: ifeq +6941 -> 7777
    //   839: aload 17
    //   841: getfield 673	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   844: ldc2_w 40
    //   847: lcmp
    //   848: ifne +52 -> 900
    //   851: iconst_0
    //   852: istore 7
    //   854: iconst_1
    //   855: istore 6
    //   857: aload 16
    //   859: astore_0
    //   860: ldc_w 675
    //   863: iconst_2
    //   864: anewarray 4	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: iload 6
    //   871: invokestatic 680	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   874: aastore
    //   875: dup
    //   876: iconst_1
    //   877: iload 7
    //   879: invokestatic 680	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   882: aastore
    //   883: invokestatic 685	arxx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: aload 19
    //   888: aload_0
    //   889: aconst_null
    //   890: iload 6
    //   892: iload 7
    //   894: aload 4
    //   896: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   899: return
    //   900: aload 16
    //   902: astore_0
    //   903: aload 17
    //   905: getfield 673	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   908: lconst_0
    //   909: lcmp
    //   910: ifgt +6867 -> 7777
    //   913: aload_1
    //   914: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:getTransFileController	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   917: aload 5
    //   919: aload 17
    //   921: getfield 688	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   924: aload 17
    //   926: getfield 689	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   929: invokevirtual 693	com/tencent/mobileqq/transfile/TransFileController:findProcessorFileStatus	(Ljava/lang/String;Ljava/lang/String;J)I
    //   932: istore_3
    //   933: iload_3
    //   934: sipush 1005
    //   937: if_icmpeq +15 -> 952
    //   940: iload_3
    //   941: sipush 1004
    //   944: if_icmpeq +8 -> 952
    //   947: iload_3
    //   948: iconst_m1
    //   949: if_icmpne +43 -> 992
    //   952: iconst_1
    //   953: istore 6
    //   955: iconst_0
    //   956: istore 7
    //   958: ldc_w 675
    //   961: iconst_2
    //   962: anewarray 4	java/lang/Object
    //   965: dup
    //   966: iconst_0
    //   967: aload 17
    //   969: getfield 673	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   972: invokestatic 698	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   975: aastore
    //   976: dup
    //   977: iconst_1
    //   978: iload_3
    //   979: invokestatic 701	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   982: aastore
    //   983: invokestatic 685	arxx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   986: aload 16
    //   988: astore_0
    //   989: goto -129 -> 860
    //   992: iconst_1
    //   993: istore 7
    //   995: iconst_0
    //   996: istore 6
    //   998: goto -40 -> 958
    //   1001: aload_2
    //   1002: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1005: sipush -3008
    //   1008: if_icmpne +48 -> 1056
    //   1011: aload 4
    //   1013: new 165	java/lang/StringBuilder
    //   1016: dup
    //   1017: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1020: aload_0
    //   1021: ldc_w 702
    //   1024: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   1027: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: ldc_w 704
    //   1033: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload_2
    //   1037: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1040: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: ldc_w 704
    //   1046: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1055: return
    //   1056: aload_2
    //   1057: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1060: sipush -2015
    //   1063: if_icmpeq +113 -> 1176
    //   1066: aload_2
    //   1067: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1070: sipush -2060
    //   1073: if_icmpeq +103 -> 1176
    //   1076: aload_2
    //   1077: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1080: sipush -2062
    //   1083: if_icmpeq +93 -> 1176
    //   1086: aload_2
    //   1087: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1090: sipush -2065
    //   1093: if_icmpeq +83 -> 1176
    //   1096: aload_2
    //   1097: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1100: sipush -7010
    //   1103: if_icmpeq +73 -> 1176
    //   1106: aload_2
    //   1107: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1110: sipush -7009
    //   1113: if_icmpeq +63 -> 1176
    //   1116: aload_2
    //   1117: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1120: sipush -7011
    //   1123: if_icmpeq +53 -> 1176
    //   1126: aload_2
    //   1127: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1130: sipush -7012
    //   1133: if_icmpeq +43 -> 1176
    //   1136: aload_2
    //   1137: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1140: sipush -4023
    //   1143: if_icmpeq +33 -> 1176
    //   1146: aload_2
    //   1147: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1150: sipush -4024
    //   1153: if_icmpeq +23 -> 1176
    //   1156: aload_2
    //   1157: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1160: sipush -7013
    //   1163: if_icmpeq +13 -> 1176
    //   1166: aload_2
    //   1167: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1170: sipush -7015
    //   1173: if_icmpne +11 -> 1184
    //   1176: aload 4
    //   1178: ldc 123
    //   1180: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1183: return
    //   1184: aload_2
    //   1185: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1188: invokestatic 708	bhca:a	(I)Z
    //   1191: ifeq +28 -> 1219
    //   1194: aload 19
    //   1196: aload_0
    //   1197: aload_1
    //   1198: aload_2
    //   1199: invokestatic 710	bhfj:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1202: aconst_null
    //   1203: aload_1
    //   1204: aload_2
    //   1205: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1208: aload_1
    //   1209: aload_2
    //   1210: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1213: aload 4
    //   1215: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1218: return
    //   1219: aload_2
    //   1220: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1223: sipush -2017
    //   1226: if_icmpne +94 -> 1320
    //   1229: aload_0
    //   1230: ldc_w 711
    //   1233: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   1236: astore 5
    //   1238: aload_2
    //   1239: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1242: astore_0
    //   1243: aload_2
    //   1244: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1247: aload_2
    //   1248: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1251: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   1254: ifeq +8 -> 1262
    //   1257: aload_2
    //   1258: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1261: astore_0
    //   1262: aload_1
    //   1263: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1266: aload_0
    //   1267: aload_2
    //   1268: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1271: aload_2
    //   1272: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   1275: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1278: astore 16
    //   1280: aload 5
    //   1282: astore_0
    //   1283: aload 16
    //   1285: instanceof 713
    //   1288: ifeq +12 -> 1300
    //   1291: aload 16
    //   1293: checkcast 713	com/tencent/mobileqq/data/MessageForTroopFile
    //   1296: invokevirtual 714	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1299: astore_0
    //   1300: aload 19
    //   1302: aload_0
    //   1303: aconst_null
    //   1304: aload_1
    //   1305: aload_2
    //   1306: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1309: aload_1
    //   1310: aload_2
    //   1311: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1314: aload 4
    //   1316: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1319: return
    //   1320: aload_2
    //   1321: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1324: invokestatic 716	bhca:b	(I)Z
    //   1327: ifeq +43 -> 1370
    //   1330: aload_2
    //   1331: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1334: invokestatic 722	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   1337: astore_1
    //   1338: aload_1
    //   1339: ifnull +22 -> 1361
    //   1342: aload 4
    //   1344: aload_1
    //   1345: aload_0
    //   1346: aload_2
    //   1347: getfield 725	com/tencent/imcore/message/QQMessageFacade$Message:issend	I
    //   1350: invokestatic 726	bhfj:b	(I)Z
    //   1353: iload 7
    //   1355: invokestatic 728	bhfj:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1358: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1361: iload_3
    //   1362: aload 19
    //   1364: aload 4
    //   1366: invokestatic 733	almj:a	(ILjava/lang/String;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1369: return
    //   1370: aload_2
    //   1371: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1374: invokestatic 735	bhca:c	(I)Z
    //   1377: ifeq +39 -> 1416
    //   1380: aload_2
    //   1381: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1384: invokestatic 722	com/tencent/mobileqq/transfile/TransfileUtile:analysisTransFileProtocolData	(Ljava/lang/String;)[Ljava/lang/String;
    //   1387: astore 5
    //   1389: aload 5
    //   1391: ifnull -1387 -> 4
    //   1394: aload 4
    //   1396: aload_1
    //   1397: aload 5
    //   1399: aload_0
    //   1400: aload_2
    //   1401: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1404: aload_2
    //   1405: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1408: iload_3
    //   1409: invokestatic 737	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1412: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1415: return
    //   1416: aload_2
    //   1417: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1420: invokestatic 739	bhca:d	(I)Z
    //   1423: ifeq +134 -> 1557
    //   1426: aload_1
    //   1427: aload_2
    //   1428: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1431: istore 6
    //   1433: aload_1
    //   1434: aload_2
    //   1435: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1438: istore 7
    //   1440: aload_2
    //   1441: ldc_w 741
    //   1444: invokevirtual 744	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1447: astore 5
    //   1449: getstatic 749	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1452: ifeq +96 -> 1548
    //   1455: aload 5
    //   1457: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1460: ifne +88 -> 1548
    //   1463: aload_0
    //   1464: aload_2
    //   1465: invokestatic 754	asdi:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1468: astore_0
    //   1469: aload_2
    //   1470: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1473: aload_1
    //   1474: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1477: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1480: ifeq +41 -> 1521
    //   1483: new 165	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1490: ldc_w 755
    //   1493: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   1496: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: aload_0
    //   1500: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: astore_0
    //   1507: aload 19
    //   1509: aload_0
    //   1510: aconst_null
    //   1511: iload 6
    //   1513: iload 7
    //   1515: aload 4
    //   1517: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1520: return
    //   1521: new 165	java/lang/StringBuilder
    //   1524: dup
    //   1525: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1528: ldc_w 756
    //   1531: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   1534: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: aload_0
    //   1538: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: astore_0
    //   1545: goto -38 -> 1507
    //   1548: aload_0
    //   1549: aload_2
    //   1550: invokestatic 754	asdi:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1553: astore_0
    //   1554: goto -47 -> 1507
    //   1557: aload_2
    //   1558: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1561: sipush -2058
    //   1564: if_icmpne +1120 -> 2684
    //   1567: ldc 123
    //   1569: astore 18
    //   1571: aload_1
    //   1572: aload_2
    //   1573: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1576: istore 12
    //   1578: aload_1
    //   1579: aload_2
    //   1580: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1583: istore 13
    //   1585: iconst_0
    //   1586: istore 8
    //   1588: aload 18
    //   1590: astore 17
    //   1592: aload_2
    //   1593: ldc_w 758
    //   1596: invokevirtual 744	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1599: astore 5
    //   1601: aload 18
    //   1603: astore 16
    //   1605: aload 18
    //   1607: astore 17
    //   1609: aload 5
    //   1611: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1614: ifne +291 -> 1905
    //   1617: aload 18
    //   1619: astore 17
    //   1621: new 760	org/json/JSONObject
    //   1624: dup
    //   1625: aload 5
    //   1627: invokespecial 763	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1630: ldc_w 765
    //   1633: invokevirtual 768	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1636: istore 9
    //   1638: iload 8
    //   1640: istore_3
    //   1641: aload 18
    //   1643: astore 5
    //   1645: aload 18
    //   1647: astore 17
    //   1649: aload_2
    //   1650: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1653: ifnull +114 -> 1767
    //   1656: iload 8
    //   1658: istore_3
    //   1659: aload 18
    //   1661: astore 5
    //   1663: iload 9
    //   1665: sipush -2007
    //   1668: if_icmpne +99 -> 1767
    //   1671: iload 8
    //   1673: istore_3
    //   1674: aload 18
    //   1676: astore 5
    //   1678: aload 18
    //   1680: astore 17
    //   1682: aload_2
    //   1683: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1686: invokestatic 777	apab:a	([B)Ljava/lang/Object;
    //   1689: instanceof 779
    //   1692: ifeq +75 -> 1767
    //   1695: aload 18
    //   1697: astore 17
    //   1699: getstatic 749	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1702: ifeq +253 -> 1955
    //   1705: aload 18
    //   1707: astore 17
    //   1709: aload_0
    //   1710: aload_2
    //   1711: invokestatic 754	asdi:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1714: astore 5
    //   1716: aload 18
    //   1718: astore 17
    //   1720: aload_2
    //   1721: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1724: aload_1
    //   1725: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1728: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1731: ifeq +191 -> 1922
    //   1734: aload 18
    //   1736: astore 17
    //   1738: new 165	java/lang/StringBuilder
    //   1741: dup
    //   1742: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1745: ldc_w 780
    //   1748: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   1751: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: aload 5
    //   1756: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: astore 5
    //   1764: goto +6057 -> 7821
    //   1767: aload 5
    //   1769: astore 16
    //   1771: iload_3
    //   1772: ifne +133 -> 1905
    //   1775: aload 5
    //   1777: astore 17
    //   1779: getstatic 749	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   1782: ifeq +229 -> 2011
    //   1785: aload 5
    //   1787: astore 17
    //   1789: aload_2
    //   1790: ldc_w 741
    //   1793: invokevirtual 744	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1796: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1799: ifne +5972 -> 7771
    //   1802: aload 5
    //   1804: astore 17
    //   1806: aload_1
    //   1807: aload_2
    //   1808: aload 4
    //   1810: invokestatic 783	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   1813: astore_0
    //   1814: new 165	java/lang/StringBuilder
    //   1817: dup
    //   1818: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1821: astore_1
    //   1822: aload 19
    //   1824: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1827: ifne +16 -> 1843
    //   1830: aload_1
    //   1831: aload 19
    //   1833: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: ldc_w 435
    //   1839: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: pop
    //   1843: aload 4
    //   1845: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1848: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1851: ifne +13 -> 1864
    //   1854: aload_1
    //   1855: aload 4
    //   1857: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   1860: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1863: pop
    //   1864: aload_2
    //   1865: invokestatic 287	nty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1868: ifne +16 -> 1884
    //   1871: iload 12
    //   1873: ifeq +98 -> 1971
    //   1876: aload_1
    //   1877: ldc_w 791
    //   1880: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: pop
    //   1884: aload_0
    //   1885: checkcast 793	com/tencent/mobileqq/text/QQText
    //   1888: aload_1
    //   1889: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1892: iconst_1
    //   1893: iconst_0
    //   1894: newarray int
    //   1896: invokevirtual 796	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1899: astore_1
    //   1900: aload_1
    //   1901: astore_0
    //   1902: aload_0
    //   1903: astore 16
    //   1905: aload 16
    //   1907: astore_2
    //   1908: aload 19
    //   1910: aload_2
    //   1911: aconst_null
    //   1912: iload 12
    //   1914: iload 13
    //   1916: aload 4
    //   1918: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1921: return
    //   1922: aload 18
    //   1924: astore 17
    //   1926: new 165	java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1933: ldc_w 797
    //   1936: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   1939: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: aload 5
    //   1944: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1950: astore 5
    //   1952: goto +5869 -> 7821
    //   1955: aload 18
    //   1957: astore 17
    //   1959: aload_0
    //   1960: aload_2
    //   1961: invokestatic 754	asdi:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1964: astore 5
    //   1966: iconst_1
    //   1967: istore_3
    //   1968: goto -201 -> 1767
    //   1971: iload 13
    //   1973: ifeq -89 -> 1884
    //   1976: aload_1
    //   1977: ldc_w 799
    //   1980: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: pop
    //   1984: goto -100 -> 1884
    //   1987: astore_1
    //   1988: aload_0
    //   1989: astore_2
    //   1990: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1993: ifeq -85 -> 1908
    //   1996: ldc_w 801
    //   1999: iconst_2
    //   2000: ldc 123
    //   2002: aload_1
    //   2003: invokestatic 804	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2006: aload_0
    //   2007: astore_2
    //   2008: goto -100 -> 1908
    //   2011: iload 9
    //   2013: sipush -1000
    //   2016: if_icmpne +182 -> 2198
    //   2019: aload 5
    //   2021: astore 17
    //   2023: aload_2
    //   2024: invokestatic 807	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;)Lcom/tencent/mobileqq/text/QQText;
    //   2027: astore_0
    //   2028: aload_0
    //   2029: ifnull -2025 -> 4
    //   2032: aload 5
    //   2034: astore 17
    //   2036: new 165	java/lang/StringBuilder
    //   2039: dup
    //   2040: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2043: astore_1
    //   2044: aload 5
    //   2046: astore 17
    //   2048: aload 19
    //   2050: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2053: ifne +20 -> 2073
    //   2056: aload 5
    //   2058: astore 17
    //   2060: aload_1
    //   2061: aload 19
    //   2063: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: ldc_w 435
    //   2069: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: aload 5
    //   2075: astore 17
    //   2077: aload 4
    //   2079: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   2082: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2085: ifne +17 -> 2102
    //   2088: aload 5
    //   2090: astore 17
    //   2092: aload_1
    //   2093: aload 4
    //   2095: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   2098: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   2101: pop
    //   2102: aload 5
    //   2104: astore 17
    //   2106: aload_2
    //   2107: invokestatic 287	nty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2110: ifne +20 -> 2130
    //   2113: iload 12
    //   2115: ifeq +63 -> 2178
    //   2118: aload 5
    //   2120: astore 17
    //   2122: aload_1
    //   2123: ldc_w 791
    //   2126: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: pop
    //   2130: aload 5
    //   2132: astore 17
    //   2134: aload_0
    //   2135: checkcast 793	com/tencent/mobileqq/text/QQText
    //   2138: aload_1
    //   2139: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2142: iconst_1
    //   2143: iconst_0
    //   2144: newarray int
    //   2146: invokevirtual 796	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   2149: astore_0
    //   2150: aload 5
    //   2152: astore 17
    //   2154: aload 4
    //   2156: iconst_1
    //   2157: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2160: aload 5
    //   2162: astore 17
    //   2164: aload 19
    //   2166: aload_0
    //   2167: aconst_null
    //   2168: iload 12
    //   2170: iload 13
    //   2172: aload 4
    //   2174: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2177: return
    //   2178: iload 13
    //   2180: ifeq -50 -> 2130
    //   2183: aload 5
    //   2185: astore 17
    //   2187: aload_1
    //   2188: ldc_w 799
    //   2191: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2194: pop
    //   2195: goto -65 -> 2130
    //   2198: aload 5
    //   2200: astore 16
    //   2202: iload 9
    //   2204: sipush -2000
    //   2207: if_icmpne -302 -> 1905
    //   2210: iconst_0
    //   2211: istore 11
    //   2213: iconst_0
    //   2214: istore 7
    //   2216: aconst_null
    //   2217: astore 18
    //   2219: aload 18
    //   2221: astore 16
    //   2223: aload_2
    //   2224: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2227: astore 17
    //   2229: aload 18
    //   2231: astore 16
    //   2233: aload_2
    //   2234: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2237: aload_2
    //   2238: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2241: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   2244: ifeq +5524 -> 7768
    //   2247: aload 18
    //   2249: astore 16
    //   2251: aload_2
    //   2252: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2255: astore 17
    //   2257: aload 18
    //   2259: astore 16
    //   2261: aload_1
    //   2262: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   2265: aload 17
    //   2267: aload_2
    //   2268: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2271: aload_2
    //   2272: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2275: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2278: checkcast 367	com/tencent/mobileqq/data/MessageForPic
    //   2281: astore 20
    //   2283: aload 18
    //   2285: astore 16
    //   2287: aload_1
    //   2288: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:getTransFileController	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   2291: aload 17
    //   2293: aload_2
    //   2294: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2297: invokevirtual 619	com/tencent/mobileqq/transfile/TransFileController:findProcessor	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   2300: astore_1
    //   2301: aload_1
    //   2302: astore 16
    //   2304: aload_2
    //   2305: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2308: ifeq +245 -> 2553
    //   2311: aload_1
    //   2312: astore 16
    //   2314: aload 20
    //   2316: getfield 622	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2319: lstore 14
    //   2321: lload 14
    //   2323: lconst_0
    //   2324: lcmp
    //   2325: ifgt +208 -> 2533
    //   2328: aload_1
    //   2329: ifnonnull +5433 -> 7762
    //   2332: aload 20
    //   2334: ifnull +5428 -> 7762
    //   2337: iconst_1
    //   2338: istore 6
    //   2340: iload 6
    //   2342: istore 10
    //   2344: aload 5
    //   2346: astore 17
    //   2348: aload_1
    //   2349: instanceof 624
    //   2352: ifeq +269 -> 2621
    //   2355: aload 5
    //   2357: astore 17
    //   2359: aload_1
    //   2360: checkcast 624	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   2363: astore_1
    //   2364: aload 5
    //   2366: astore 17
    //   2368: aload_1
    //   2369: invokevirtual 627	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   2372: ldc2_w 628
    //   2375: lcmp
    //   2376: ifeq +6 -> 2382
    //   2379: iconst_1
    //   2380: istore 7
    //   2382: iload 7
    //   2384: istore 6
    //   2386: aload 5
    //   2388: astore 17
    //   2390: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2393: ifeq +76 -> 2469
    //   2396: aload 5
    //   2398: astore 17
    //   2400: aload_1
    //   2401: getfield 633	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2404: ifnull +5435 -> 7839
    //   2407: aload 5
    //   2409: astore 17
    //   2411: aload_1
    //   2412: getfield 633	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   2415: getfield 638	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   2418: lstore 14
    //   2420: aload 5
    //   2422: astore 17
    //   2424: ldc_w 640
    //   2427: iconst_2
    //   2428: new 165	java/lang/StringBuilder
    //   2431: dup
    //   2432: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2435: ldc_w 642
    //   2438: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2441: lload 14
    //   2443: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2446: ldc_w 644
    //   2449: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: aload_1
    //   2453: invokevirtual 647	com/tencent/mobileqq/transfile/BaseTransProcessor:getKey	()Ljava/lang/String;
    //   2456: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2459: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2462: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2465: iload 7
    //   2467: istore 6
    //   2469: aload 5
    //   2471: astore 17
    //   2473: aload_0
    //   2474: ldc_w 648
    //   2477: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   2480: astore_1
    //   2481: aload 5
    //   2483: astore 17
    //   2485: aload_2
    //   2486: invokestatic 651	anwf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2489: ifne +14 -> 2503
    //   2492: aload 5
    //   2494: astore 17
    //   2496: aload_2
    //   2497: invokestatic 654	anud:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2500: ifeq +15 -> 2515
    //   2503: aload 5
    //   2505: astore 17
    //   2507: aload_0
    //   2508: ldc_w 655
    //   2511: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   2514: astore_1
    //   2515: aload 5
    //   2517: astore 17
    //   2519: aload 19
    //   2521: aload_1
    //   2522: aconst_null
    //   2523: iload 10
    //   2525: iload 6
    //   2527: aload 4
    //   2529: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2532: return
    //   2533: aload_1
    //   2534: astore 16
    //   2536: aload 20
    //   2538: getfield 661	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2541: ldc_w 662
    //   2544: if_icmpne +5289 -> 7833
    //   2547: iconst_1
    //   2548: istore 6
    //   2550: goto -210 -> 2340
    //   2553: aload_1
    //   2554: ifnull +5208 -> 7762
    //   2557: aload_1
    //   2558: astore 16
    //   2560: aload_1
    //   2561: instanceof 624
    //   2564: ifeq +5198 -> 7762
    //   2567: aload_1
    //   2568: astore 16
    //   2570: aload_1
    //   2571: checkcast 624	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   2574: invokevirtual 627	com/tencent/mobileqq/transfile/BaseTransProcessor:getFileStatus	()J
    //   2577: lstore 14
    //   2579: lload 14
    //   2581: l2i
    //   2582: istore_3
    //   2583: iload_3
    //   2584: sipush 1005
    //   2587: if_icmpeq +10 -> 2597
    //   2590: iload_3
    //   2591: sipush 1004
    //   2594: if_icmpne +5168 -> 7762
    //   2597: iconst_1
    //   2598: istore 6
    //   2600: goto -260 -> 2340
    //   2603: astore_1
    //   2604: aload 5
    //   2606: astore 17
    //   2608: aload_1
    //   2609: invokevirtual 528	java/lang/Exception:printStackTrace	()V
    //   2612: aload 16
    //   2614: astore_1
    //   2615: iconst_0
    //   2616: istore 10
    //   2618: goto -274 -> 2344
    //   2621: iload 11
    //   2623: istore 6
    //   2625: aload_1
    //   2626: ifnull -157 -> 2469
    //   2629: iconst_1
    //   2630: istore 7
    //   2632: iload 7
    //   2634: istore 6
    //   2636: aload 5
    //   2638: astore 17
    //   2640: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2643: ifeq -174 -> 2469
    //   2646: aload 5
    //   2648: astore 17
    //   2650: ldc_w 640
    //   2653: iconst_2
    //   2654: new 165	java/lang/StringBuilder
    //   2657: dup
    //   2658: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2661: ldc_w 664
    //   2664: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2667: aload_1
    //   2668: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2671: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2674: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2677: iload 7
    //   2679: istore 6
    //   2681: goto -212 -> 2469
    //   2684: aload_2
    //   2685: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2688: invokestatic 812	bhca:e	(I)Z
    //   2691: ifeq +267 -> 2958
    //   2694: new 814	com/tencent/mobileqq/data/MessageForApollo
    //   2697: dup
    //   2698: invokespecial 815	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2701: astore 5
    //   2703: aload 5
    //   2705: aload_2
    //   2706: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   2709: putfield 816	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2712: aload 5
    //   2714: invokevirtual 817	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2717: aload_1
    //   2718: aload_2
    //   2719: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2722: istore 6
    //   2724: aload_1
    //   2725: aload_2
    //   2726: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2729: istore 7
    //   2731: aload 5
    //   2733: getfield 819	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2736: invokestatic 822	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(I)Z
    //   2739: ifeq +209 -> 2948
    //   2742: ldc_w 823
    //   2745: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   2748: astore_0
    //   2749: aload 5
    //   2751: getfield 819	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2754: iconst_4
    //   2755: if_icmpne +155 -> 2910
    //   2758: aload 5
    //   2760: getfield 826	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2763: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2766: ifeq +43 -> 2809
    //   2769: new 165	java/lang/StringBuilder
    //   2772: dup
    //   2773: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2776: aload_0
    //   2777: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2780: ldc_w 827
    //   2783: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   2786: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2789: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2792: astore_1
    //   2793: aload_1
    //   2794: astore_0
    //   2795: aload 19
    //   2797: aload_0
    //   2798: aconst_null
    //   2799: iload 6
    //   2801: iload 7
    //   2803: aload 4
    //   2805: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2808: return
    //   2809: new 760	org/json/JSONObject
    //   2812: dup
    //   2813: aload 5
    //   2815: getfield 826	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2818: invokespecial 763	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2821: ldc_w 829
    //   2824: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2827: astore_1
    //   2828: aload_1
    //   2829: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2832: ifeq +32 -> 2864
    //   2835: new 165	java/lang/StringBuilder
    //   2838: dup
    //   2839: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2842: aload_0
    //   2843: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: ldc_w 833
    //   2849: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   2852: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2858: astore_1
    //   2859: aload_1
    //   2860: astore_0
    //   2861: goto -66 -> 2795
    //   2864: new 165	java/lang/StringBuilder
    //   2867: dup
    //   2868: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2871: aload_0
    //   2872: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2875: ldc_w 539
    //   2878: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: aload_1
    //   2882: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2885: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2888: astore_1
    //   2889: aload_1
    //   2890: astore_0
    //   2891: goto -96 -> 2795
    //   2894: astore_1
    //   2895: ldc_w 801
    //   2898: iconst_1
    //   2899: aload_1
    //   2900: iconst_0
    //   2901: anewarray 4	java/lang/Object
    //   2904: invokestatic 836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2907: goto -112 -> 2795
    //   2910: aload_1
    //   2911: aload 5
    //   2913: invokestatic 841	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2916: astore_1
    //   2917: new 165	java/lang/StringBuilder
    //   2920: dup
    //   2921: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2924: aload_0
    //   2925: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: ldc_w 842
    //   2931: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   2934: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2937: aload_1
    //   2938: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2941: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2944: astore_0
    //   2945: goto -150 -> 2795
    //   2948: aload_1
    //   2949: aload 5
    //   2951: invokestatic 844	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2954: astore_0
    //   2955: goto -160 -> 2795
    //   2958: aload_2
    //   2959: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2962: sipush -1013
    //   2965: if_icmpeq +13 -> 2978
    //   2968: aload_2
    //   2969: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2972: sipush -1047
    //   2975: if_icmpne +20 -> 2995
    //   2978: aconst_null
    //   2979: aconst_null
    //   2980: aload_2
    //   2981: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2984: invokestatic 577	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   2987: iconst_0
    //   2988: iconst_0
    //   2989: aload 4
    //   2991: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2994: return
    //   2995: aload_2
    //   2996: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2999: sipush -2042
    //   3002: if_icmpeq +13 -> 3015
    //   3005: aload_2
    //   3006: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3009: sipush -2043
    //   3012: if_icmpne +20 -> 3032
    //   3015: aconst_null
    //   3016: aload_2
    //   3017: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3020: invokestatic 577	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3023: aconst_null
    //   3024: iconst_0
    //   3025: iconst_0
    //   3026: aload 4
    //   3028: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3031: return
    //   3032: aload_2
    //   3033: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3036: sipush -2051
    //   3039: if_icmpne +155 -> 3194
    //   3042: aload_1
    //   3043: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3046: aload_2
    //   3047: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3050: aload_2
    //   3051: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3054: aload_2
    //   3055: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3058: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3061: astore_0
    //   3062: aload_0
    //   3063: ifnull +50 -> 3113
    //   3066: aload_0
    //   3067: instanceof 846
    //   3070: ifeq +43 -> 3113
    //   3073: aload_0
    //   3074: checkcast 846	com/tencent/mobileqq/data/MessageForQQStory
    //   3077: astore_0
    //   3078: aload_0
    //   3079: invokevirtual 847	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3082: aload_1
    //   3083: aload_2
    //   3084: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3087: istore 6
    //   3089: aload_1
    //   3090: aload_2
    //   3091: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3094: istore 7
    //   3096: aload 19
    //   3098: aconst_null
    //   3099: aload_0
    //   3100: invokevirtual 848	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3103: iload 6
    //   3105: iload 7
    //   3107: aload 4
    //   3109: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3112: return
    //   3113: new 165	java/lang/StringBuilder
    //   3116: dup
    //   3117: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3120: ldc 2
    //   3122: invokevirtual 853	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3125: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3128: ldc_w 855
    //   3131: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3134: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3137: astore_1
    //   3138: new 165	java/lang/StringBuilder
    //   3141: dup
    //   3142: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3145: ldc_w 857
    //   3148: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3151: aload_2
    //   3152: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3155: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3158: ldc_w 859
    //   3161: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: astore_2
    //   3165: aload_0
    //   3166: ifnull +22 -> 3188
    //   3169: aload_0
    //   3170: invokevirtual 862	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3173: astore_0
    //   3174: aload_1
    //   3175: iconst_1
    //   3176: aload_2
    //   3177: aload_0
    //   3178: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3181: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3184: invokestatic 864	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3187: return
    //   3188: ldc 123
    //   3190: astore_0
    //   3191: goto -17 -> 3174
    //   3194: aload_2
    //   3195: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3198: sipush -7002
    //   3201: if_icmpne +148 -> 3349
    //   3204: aload_1
    //   3205: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3208: aload_2
    //   3209: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3212: aload_2
    //   3213: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3216: aload_2
    //   3217: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3220: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3223: checkcast 866	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3226: astore_0
    //   3227: aload_0
    //   3228: ifnull +38 -> 3266
    //   3231: aload_0
    //   3232: invokevirtual 867	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3235: aload_1
    //   3236: aload_2
    //   3237: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3240: istore 6
    //   3242: aload_1
    //   3243: aload_2
    //   3244: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3247: istore 7
    //   3249: aload 19
    //   3251: aconst_null
    //   3252: aload_0
    //   3253: invokevirtual 868	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3256: iload 6
    //   3258: iload 7
    //   3260: aload 4
    //   3262: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3265: return
    //   3266: new 165	java/lang/StringBuilder
    //   3269: dup
    //   3270: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3273: ldc 2
    //   3275: invokevirtual 853	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3278: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: ldc_w 855
    //   3284: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3287: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3290: astore_1
    //   3291: new 165	java/lang/StringBuilder
    //   3294: dup
    //   3295: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3298: ldc_w 870
    //   3301: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3304: aload_2
    //   3305: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3308: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3311: ldc_w 859
    //   3314: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: astore 4
    //   3319: aload_2
    //   3320: ifnull +23 -> 3343
    //   3323: aload_2
    //   3324: invokevirtual 871	com/tencent/imcore/message/QQMessageFacade$Message:toString	()Ljava/lang/String;
    //   3327: astore_0
    //   3328: aload_1
    //   3329: iconst_1
    //   3330: aload 4
    //   3332: aload_0
    //   3333: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3339: invokestatic 864	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3342: return
    //   3343: ldc 123
    //   3345: astore_0
    //   3346: goto -18 -> 3328
    //   3349: aload_2
    //   3350: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3353: sipush -2054
    //   3356: if_icmpne +153 -> 3509
    //   3359: aload_1
    //   3360: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3363: aload_2
    //   3364: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3367: aload_2
    //   3368: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3371: aload_2
    //   3372: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3375: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3378: astore_0
    //   3379: aload_0
    //   3380: instanceof 873
    //   3383: ifeq +42 -> 3425
    //   3386: aload_0
    //   3387: checkcast 873	com/tencent/mobileqq/data/MessageForTroopSign
    //   3390: astore_0
    //   3391: ldc_w 874
    //   3394: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   3397: pop
    //   3398: aload_0
    //   3399: invokevirtual 875	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3402: aload 19
    //   3404: aconst_null
    //   3405: aload_0
    //   3406: invokevirtual 876	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3409: aload_1
    //   3410: aload_2
    //   3411: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3414: aload_1
    //   3415: aload_2
    //   3416: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3419: aload 4
    //   3421: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3424: return
    //   3425: new 165	java/lang/StringBuilder
    //   3428: dup
    //   3429: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3432: ldc 2
    //   3434: invokevirtual 853	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3437: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: ldc_w 878
    //   3443: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3449: astore_1
    //   3450: new 165	java/lang/StringBuilder
    //   3453: dup
    //   3454: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3457: ldc_w 880
    //   3460: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: aload_2
    //   3464: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3467: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3470: ldc_w 859
    //   3473: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3476: astore_2
    //   3477: aload_0
    //   3478: ifnull +25 -> 3503
    //   3481: aload_0
    //   3482: getfield 881	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3485: invokestatic 701	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3488: astore_0
    //   3489: aload_1
    //   3490: iconst_1
    //   3491: aload_2
    //   3492: aload_0
    //   3493: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3496: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3499: invokestatic 864	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3502: return
    //   3503: ldc 123
    //   3505: astore_0
    //   3506: goto -17 -> 3489
    //   3509: aload_2
    //   3510: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3513: sipush -2035
    //   3516: if_icmpne +20 -> 3536
    //   3519: aconst_null
    //   3520: aload_2
    //   3521: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3524: invokestatic 577	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3527: aconst_null
    //   3528: iconst_0
    //   3529: iconst_0
    //   3530: aload 4
    //   3532: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3535: return
    //   3536: aload_2
    //   3537: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3540: sipush -2038
    //   3543: if_icmpne +205 -> 3748
    //   3546: aload_2
    //   3547: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3550: astore_0
    //   3551: getstatic 886	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3554: aload_0
    //   3555: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3558: ifeq +4201 -> 7759
    //   3561: aload_2
    //   3562: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3565: astore_0
    //   3566: aload_0
    //   3567: astore 5
    //   3569: getstatic 889	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   3572: aload_0
    //   3573: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3576: ifeq +59 -> 3635
    //   3579: getstatic 886	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3582: aload_2
    //   3583: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3586: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3589: ifeq +103 -> 3692
    //   3592: aload_1
    //   3593: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3596: getstatic 886	com/tencent/mobileqq/app/AppConstants:LBS_SAY_HELLO_LIST_UIN	Ljava/lang/String;
    //   3599: aload_2
    //   3600: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3603: aload_2
    //   3604: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3607: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3610: checkcast 891	com/tencent/mobileqq/data/MessageForTroopGift
    //   3613: astore 16
    //   3615: aload_0
    //   3616: astore 5
    //   3618: aload 16
    //   3620: ifnull +15 -> 3635
    //   3623: aload 16
    //   3625: invokevirtual 892	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3628: aload 16
    //   3630: getfield 893	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3633: astore 5
    //   3635: aload_1
    //   3636: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3639: aload 5
    //   3641: aload_2
    //   3642: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3645: aload_2
    //   3646: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3649: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3652: astore_0
    //   3653: aload_0
    //   3654: instanceof 891
    //   3657: ifeq +50 -> 3707
    //   3660: aload_0
    //   3661: checkcast 891	com/tencent/mobileqq/data/MessageForTroopGift
    //   3664: astore_0
    //   3665: aload_0
    //   3666: invokevirtual 892	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3669: aload_0
    //   3670: getfield 894	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3673: ifnull +28 -> 3701
    //   3676: aload_0
    //   3677: getfield 894	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3680: astore_0
    //   3681: aconst_null
    //   3682: aload_0
    //   3683: aconst_null
    //   3684: iconst_0
    //   3685: iconst_0
    //   3686: aload 4
    //   3688: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3691: return
    //   3692: aload_2
    //   3693: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3696: astore 5
    //   3698: goto -63 -> 3635
    //   3701: ldc 123
    //   3703: astore_0
    //   3704: goto -23 -> 3681
    //   3707: aload_0
    //   3708: ifnull -3704 -> 4
    //   3711: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3714: ifeq -3710 -> 4
    //   3717: ldc_w 801
    //   3720: iconst_2
    //   3721: new 165	java/lang/StringBuilder
    //   3724: dup
    //   3725: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   3728: ldc_w 896
    //   3731: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3734: aload_0
    //   3735: invokevirtual 862	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3738: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3741: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3744: invokestatic 864	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3747: return
    //   3748: aload_2
    //   3749: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3752: sipush -2036
    //   3755: if_icmpne +48 -> 3803
    //   3758: aload_1
    //   3759: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3762: aload_2
    //   3763: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3766: aload_2
    //   3767: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3770: aload_2
    //   3771: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3774: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3777: checkcast 898	com/tencent/mobileqq/data/MessageForTroopFee
    //   3780: astore_0
    //   3781: aload_0
    //   3782: ifnull -3778 -> 4
    //   3785: aload_0
    //   3786: invokevirtual 899	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3789: aconst_null
    //   3790: aload_0
    //   3791: getfield 900	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3794: aconst_null
    //   3795: iconst_0
    //   3796: iconst_0
    //   3797: aload 4
    //   3799: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3802: return
    //   3803: aload_2
    //   3804: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3807: sipush -2069
    //   3810: if_icmpne +48 -> 3858
    //   3813: aload_1
    //   3814: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3817: aload_2
    //   3818: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3821: aload_2
    //   3822: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3825: aload_2
    //   3826: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3829: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3832: checkcast 902	com/tencent/mobileqq/data/MessageForStarLeague
    //   3835: astore_0
    //   3836: aload_0
    //   3837: ifnull -3833 -> 4
    //   3840: aload_0
    //   3841: invokevirtual 903	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3844: aconst_null
    //   3845: aload_0
    //   3846: getfield 904	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3849: aconst_null
    //   3850: iconst_0
    //   3851: iconst_0
    //   3852: aload 4
    //   3854: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3857: return
    //   3858: aload_2
    //   3859: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3862: sipush -2048
    //   3865: if_icmpne +49 -> 3914
    //   3868: aload_1
    //   3869: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3872: aload_2
    //   3873: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3876: aload_2
    //   3877: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3880: aload_2
    //   3881: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3884: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3887: checkcast 906	com/tencent/mobileqq/data/MessageForTroopReward
    //   3890: astore_0
    //   3891: aload_0
    //   3892: ifnull -3888 -> 4
    //   3895: aload_0
    //   3896: invokevirtual 907	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3899: aload 19
    //   3901: aload_0
    //   3902: getfield 908	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3905: aconst_null
    //   3906: iconst_0
    //   3907: iconst_0
    //   3908: aload 4
    //   3910: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3913: return
    //   3914: aload_2
    //   3915: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3918: iconst_1
    //   3919: if_icmpne +130 -> 4049
    //   3922: aload_2
    //   3923: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3926: sipush -3006
    //   3929: if_icmpne +120 -> 4049
    //   3932: aload_1
    //   3933: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3936: aload_2
    //   3937: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3940: aload_2
    //   3941: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3944: aload_2
    //   3945: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3948: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3951: checkcast 910	com/tencent/mobileqq/data/MessageForPubAccount
    //   3954: astore_0
    //   3955: aload_0
    //   3956: ifnull -3952 -> 4
    //   3959: aload_0
    //   3960: invokevirtual 911	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   3963: aload_1
    //   3964: aload_0
    //   3965: iconst_0
    //   3966: invokestatic 915	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   3969: astore 5
    //   3971: aload_0
    //   3972: invokevirtual 918	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   3975: ifne +60 -> 4035
    //   3978: aconst_null
    //   3979: astore_0
    //   3980: aload_0
    //   3981: astore_1
    //   3982: aload_2
    //   3983: getfield 563	com/tencent/imcore/message/QQMessageFacade$Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   3986: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3989: ifne +34 -> 4023
    //   3992: aload_0
    //   3993: astore_1
    //   3994: aload_0
    //   3995: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3998: ifne +25 -> 4023
    //   4001: new 165	java/lang/StringBuilder
    //   4004: dup
    //   4005: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   4008: aload_2
    //   4009: getfield 563	com/tencent/imcore/message/QQMessageFacade$Message:prefixOfNickname	Ljava/lang/CharSequence;
    //   4012: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4015: aload_0
    //   4016: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4019: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4022: astore_1
    //   4023: aload_1
    //   4024: aload 5
    //   4026: aconst_null
    //   4027: iconst_0
    //   4028: iconst_0
    //   4029: aload 4
    //   4031: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4034: return
    //   4035: aload_1
    //   4036: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4039: ldc_w 919
    //   4042: invokevirtual 163	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4045: astore_0
    //   4046: goto -66 -> 3980
    //   4049: aload_2
    //   4050: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4053: sipush -1034
    //   4056: if_icmpne +106 -> 4162
    //   4059: new 921	com/tencent/mobileqq/data/MessageForRichState
    //   4062: dup
    //   4063: invokespecial 922	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   4066: astore_0
    //   4067: aload_0
    //   4068: aload_2
    //   4069: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4072: putfield 923	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   4075: aload_0
    //   4076: invokevirtual 924	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   4079: new 165	java/lang/StringBuilder
    //   4082: dup
    //   4083: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   4086: astore_1
    //   4087: aload_0
    //   4088: getfield 927	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4091: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4094: ifne +38 -> 4132
    //   4097: aload_1
    //   4098: aload_0
    //   4099: getfield 927	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4102: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4105: pop
    //   4106: aload_0
    //   4107: getfield 930	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4110: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4113: ifne +12 -> 4125
    //   4116: aload_1
    //   4117: aload_0
    //   4118: getfield 930	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4121: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4124: pop
    //   4125: aload_1
    //   4126: bipush 32
    //   4128: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   4131: pop
    //   4132: aload_1
    //   4133: aload_0
    //   4134: invokevirtual 936	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   4137: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4140: pop
    //   4141: aload_1
    //   4142: invokevirtual 937	java/lang/StringBuilder:length	()I
    //   4145: ifle -4141 -> 4
    //   4148: aconst_null
    //   4149: aload_1
    //   4150: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4153: aconst_null
    //   4154: iconst_0
    //   4155: iconst_0
    //   4156: aload 4
    //   4158: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4161: return
    //   4162: aload_2
    //   4163: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4166: sipush -2074
    //   4169: if_icmpne +47 -> 4216
    //   4172: new 939	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4175: dup
    //   4176: invokespecial 940	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4179: astore_0
    //   4180: aload_0
    //   4181: aload_2
    //   4182: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4185: putfield 941	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4188: aload_0
    //   4189: invokevirtual 942	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4192: aload_0
    //   4193: getfield 945	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4196: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4199: ifne -4195 -> 4
    //   4202: aconst_null
    //   4203: aload_0
    //   4204: getfield 945	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4207: aconst_null
    //   4208: iconst_0
    //   4209: iconst_0
    //   4210: aload 4
    //   4212: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4215: return
    //   4216: aload_2
    //   4217: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4220: sipush -1019
    //   4223: if_icmpne +48 -> 4271
    //   4226: aconst_null
    //   4227: aconst_null
    //   4228: new 165	java/lang/StringBuilder
    //   4231: dup
    //   4232: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   4235: ldc_w 946
    //   4238: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   4241: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4244: aload_2
    //   4245: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4248: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4251: ldc_w 947
    //   4254: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   4257: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4260: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4263: iconst_0
    //   4264: iconst_0
    //   4265: aload 4
    //   4267: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4270: return
    //   4271: aload_2
    //   4272: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4275: sipush -1018
    //   4278: if_icmpne +48 -> 4326
    //   4281: aconst_null
    //   4282: aconst_null
    //   4283: new 165	java/lang/StringBuilder
    //   4286: dup
    //   4287: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   4290: ldc_w 948
    //   4293: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   4296: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4299: aload_2
    //   4300: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4303: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4306: ldc_w 949
    //   4309: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   4312: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4315: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4318: iconst_0
    //   4319: iconst_0
    //   4320: aload 4
    //   4322: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4325: return
    //   4326: aload_2
    //   4327: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4330: sipush -2019
    //   4333: if_icmpne +16 -> 4349
    //   4336: aload 4
    //   4338: aload_0
    //   4339: ldc_w 950
    //   4342: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   4345: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4348: return
    //   4349: aload_2
    //   4350: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4353: sipush -7006
    //   4356: if_icmpne +16 -> 4372
    //   4359: aload 4
    //   4361: aload_0
    //   4362: ldc_w 951
    //   4365: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   4368: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4371: return
    //   4372: aload_2
    //   4373: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4376: sipush -1026
    //   4379: if_icmpne +16 -> 4395
    //   4382: aload 4
    //   4384: aload_0
    //   4385: ldc_w 952
    //   4388: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   4391: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4394: return
    //   4395: aload_2
    //   4396: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4399: sipush -1027
    //   4402: if_icmpne +16 -> 4418
    //   4405: aload 4
    //   4407: aload_0
    //   4408: ldc_w 953
    //   4411: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   4414: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4417: return
    //   4418: aload_2
    //   4419: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4422: sipush -2005
    //   4425: if_icmpne +56 -> 4481
    //   4428: aload_1
    //   4429: aload_2
    //   4430: invokestatic 956	auea:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4433: astore 5
    //   4435: aload_1
    //   4436: aload_2
    //   4437: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4440: istore 6
    //   4442: aload_1
    //   4443: aload_2
    //   4444: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4447: istore 7
    //   4449: aload 19
    //   4451: aload_0
    //   4452: ldc_w 957
    //   4455: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   4458: aconst_null
    //   4459: iload 6
    //   4461: iload 7
    //   4463: aload 4
    //   4465: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4468: aload 5
    //   4470: ifnull -4466 -> 4
    //   4473: aload 4
    //   4475: aload 5
    //   4477: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4480: return
    //   4481: aload_2
    //   4482: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4485: sipush -2022
    //   4488: if_icmpeq +13 -> 4501
    //   4491: aload_2
    //   4492: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4495: sipush -2071
    //   4498: if_icmpne +700 -> 5198
    //   4501: iconst_0
    //   4502: istore 7
    //   4504: iconst_0
    //   4505: istore 10
    //   4507: aload_1
    //   4508: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4511: aload_2
    //   4512: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4515: aload_2
    //   4516: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4519: aload_2
    //   4520: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4523: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4526: astore 5
    //   4528: aload 5
    //   4530: instanceof 959
    //   4533: ifeq -4529 -> 4
    //   4536: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4539: ifeq +33 -> 4572
    //   4542: ldc_w 503
    //   4545: iconst_2
    //   4546: new 165	java/lang/StringBuilder
    //   4549: dup
    //   4550: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   4553: ldc_w 961
    //   4556: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4559: aload_2
    //   4560: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4563: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4566: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4569: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4572: aload 5
    //   4574: checkcast 959	com/tencent/mobileqq/data/MessageForShortVideo
    //   4577: astore 16
    //   4579: aload 16
    //   4581: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4584: sipush 1005
    //   4587: if_icmpeq +60 -> 4647
    //   4590: aload_2
    //   4591: getfield 965	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   4594: ldc_w 662
    //   4597: if_icmpeq +50 -> 4647
    //   4600: aload 16
    //   4602: getfield 968	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4605: ifne +14 -> 4619
    //   4608: aload 16
    //   4610: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4613: sipush 1004
    //   4616: if_icmpeq +31 -> 4647
    //   4619: iload 7
    //   4621: istore 6
    //   4623: aload 16
    //   4625: getfield 968	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4628: iconst_1
    //   4629: if_icmpne +37 -> 4666
    //   4632: iload 7
    //   4634: istore 6
    //   4636: aload 16
    //   4638: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4641: sipush 1004
    //   4644: if_icmpne +22 -> 4666
    //   4647: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4650: ifeq +13 -> 4663
    //   4653: ldc_w 503
    //   4656: iconst_2
    //   4657: ldc_w 970
    //   4660: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4663: iconst_1
    //   4664: istore 6
    //   4666: aload_2
    //   4667: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4670: astore 5
    //   4672: aload_2
    //   4673: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4676: aload_2
    //   4677: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4680: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   4683: ifeq +9 -> 4692
    //   4686: aload_2
    //   4687: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4690: astore 5
    //   4692: aload_1
    //   4693: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:getTransFileController	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   4696: aload 5
    //   4698: aload_2
    //   4699: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4702: invokevirtual 619	com/tencent/mobileqq/transfile/TransFileController:findProcessor	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4705: astore_1
    //   4706: aload 16
    //   4708: getfield 973	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4711: ifnull +337 -> 5048
    //   4714: ldc 123
    //   4716: aload 16
    //   4718: getfield 973	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4721: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4724: ifne +324 -> 5048
    //   4727: aload_2
    //   4728: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4731: ifeq +317 -> 5048
    //   4734: aload_1
    //   4735: ifnonnull +313 -> 5048
    //   4738: aload 16
    //   4740: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4743: sipush 1003
    //   4746: if_icmpeq +302 -> 5048
    //   4749: aload 16
    //   4751: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4754: sipush 1004
    //   4757: if_icmpeq +291 -> 5048
    //   4760: aload 16
    //   4762: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4765: sipush 2003
    //   4768: if_icmpeq +280 -> 5048
    //   4771: aload 16
    //   4773: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4776: sipush 2009
    //   4779: if_icmpeq +269 -> 5048
    //   4782: aload 16
    //   4784: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4787: sipush 2002
    //   4790: if_icmpeq +258 -> 5048
    //   4793: aload 16
    //   4795: getfield 976	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   4798: iconst_1
    //   4799: if_icmpne +249 -> 5048
    //   4802: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4805: ifeq +13 -> 4818
    //   4808: ldc_w 503
    //   4811: iconst_2
    //   4812: ldc_w 978
    //   4815: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4818: iconst_1
    //   4819: istore 7
    //   4821: iload 7
    //   4823: istore 6
    //   4825: iload 10
    //   4827: istore 7
    //   4829: aload_2
    //   4830: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4833: ifeq +81 -> 4914
    //   4836: aload 16
    //   4838: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4841: sipush 1001
    //   4844: if_icmpeq +51 -> 4895
    //   4847: aload 16
    //   4849: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4852: sipush 1002
    //   4855: if_icmpeq +40 -> 4895
    //   4858: aload 16
    //   4860: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4863: sipush 998
    //   4866: if_icmpeq +29 -> 4895
    //   4869: aload 16
    //   4871: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4874: sipush 999
    //   4877: if_icmpeq +18 -> 4895
    //   4880: iload 10
    //   4882: istore 7
    //   4884: aload 16
    //   4886: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4889: sipush 1000
    //   4892: if_icmpne +22 -> 4914
    //   4895: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4898: ifeq +13 -> 4911
    //   4901: ldc_w 503
    //   4904: iconst_2
    //   4905: ldc_w 980
    //   4908: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4911: iconst_1
    //   4912: istore 7
    //   4914: aload 16
    //   4916: instanceof 982
    //   4919: ifeq +235 -> 5154
    //   4922: aload_0
    //   4923: ldc_w 983
    //   4926: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   4929: astore_0
    //   4930: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4933: ifeq +101 -> 5034
    //   4936: ldc_w 503
    //   4939: iconst_2
    //   4940: new 165	java/lang/StringBuilder
    //   4943: dup
    //   4944: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   4947: ldc_w 985
    //   4950: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4953: aload 16
    //   4955: getfield 973	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4958: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4961: ldc_w 987
    //   4964: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4967: aload 16
    //   4969: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4972: invokevirtual 497	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4975: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4978: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4981: aload_1
    //   4982: ifnonnull +203 -> 5185
    //   4985: ldc_w 503
    //   4988: iconst_2
    //   4989: ldc_w 989
    //   4992: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4995: ldc_w 503
    //   4998: iconst_2
    //   4999: new 165	java/lang/StringBuilder
    //   5002: dup
    //   5003: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   5006: ldc_w 991
    //   5009: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5012: iload 6
    //   5014: invokevirtual 994	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5017: ldc_w 996
    //   5020: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5023: iload 7
    //   5025: invokevirtual 994	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5028: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5031: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5034: aload 19
    //   5036: aload_0
    //   5037: aconst_null
    //   5038: iload 6
    //   5040: iload 7
    //   5042: aload 4
    //   5044: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5047: return
    //   5048: iload 6
    //   5050: istore 7
    //   5052: aload_2
    //   5053: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5056: ifeq -235 -> 4821
    //   5059: iload 6
    //   5061: istore 7
    //   5063: aload 16
    //   5065: instanceof 982
    //   5068: ifeq -247 -> 4821
    //   5071: iload 6
    //   5073: istore 7
    //   5075: aload 16
    //   5077: getfield 973	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5080: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5083: ifeq -262 -> 4821
    //   5086: iload 6
    //   5088: istore 7
    //   5090: aload_1
    //   5091: ifnonnull -270 -> 4821
    //   5094: aload 16
    //   5096: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5099: sipush 1004
    //   5102: if_icmpeq +18 -> 5120
    //   5105: iload 6
    //   5107: istore 7
    //   5109: aload 16
    //   5111: getfield 964	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5114: sipush 1001
    //   5117: if_icmpne -296 -> 4821
    //   5120: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5123: ifeq +13 -> 5136
    //   5126: ldc_w 503
    //   5129: iconst_2
    //   5130: ldc_w 998
    //   5133: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5136: iconst_1
    //   5137: istore 7
    //   5139: goto -318 -> 4821
    //   5142: astore 5
    //   5144: aconst_null
    //   5145: astore_1
    //   5146: aload 5
    //   5148: invokevirtual 528	java/lang/Exception:printStackTrace	()V
    //   5151: goto -326 -> 4825
    //   5154: aload 16
    //   5156: getfield 968	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   5159: iconst_2
    //   5160: if_icmpne +14 -> 5174
    //   5163: aload_0
    //   5164: ldc_w 999
    //   5167: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   5170: astore_0
    //   5171: goto -241 -> 4930
    //   5174: aload_0
    //   5175: ldc_w 1000
    //   5178: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   5181: astore_0
    //   5182: goto -252 -> 4930
    //   5185: ldc_w 503
    //   5188: iconst_2
    //   5189: ldc_w 1002
    //   5192: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5195: goto -200 -> 4995
    //   5198: aload_2
    //   5199: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5202: sipush -5002
    //   5205: if_icmpne +40 -> 5245
    //   5208: new 1004	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5211: dup
    //   5212: invokespecial 1005	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5215: astore_0
    //   5216: aload_0
    //   5217: aload_2
    //   5218: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5221: putfield 1006	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5224: aload_0
    //   5225: invokevirtual 1007	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5228: aload_0
    //   5229: getfield 1008	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5232: ifnull -5228 -> 4
    //   5235: aload 4
    //   5237: aload_0
    //   5238: getfield 1008	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5241: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5244: return
    //   5245: aload_2
    //   5246: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5249: sipush -2029
    //   5252: if_icmpne +145 -> 5397
    //   5255: aload_1
    //   5256: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5259: aload_2
    //   5260: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5263: aload_2
    //   5264: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5267: aload_2
    //   5268: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5271: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5274: astore_0
    //   5275: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5278: ifeq +30 -> 5308
    //   5281: ldc_w 503
    //   5284: iconst_2
    //   5285: new 165	java/lang/StringBuilder
    //   5288: dup
    //   5289: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   5292: ldc_w 1010
    //   5295: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5298: aload_0
    //   5299: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5302: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5305: invokestatic 506	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5308: aload_0
    //   5309: instanceof 1012
    //   5312: ifeq -5308 -> 4
    //   5315: aload_0
    //   5316: checkcast 1012	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5319: astore_0
    //   5320: aload_0
    //   5321: aload_2
    //   5322: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5325: putfield 1013	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5328: aload_0
    //   5329: invokevirtual 1014	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5332: aload_0
    //   5333: aload_1
    //   5334: aload_1
    //   5335: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5338: aconst_null
    //   5339: invokevirtual 1018	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5342: aload_0
    //   5343: getfield 1020	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5346: ifnull -5342 -> 4
    //   5349: aload_0
    //   5350: getfield 1023	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5353: iconst_1
    //   5354: if_icmpne +33 -> 5387
    //   5357: aload_0
    //   5358: new 165	java/lang/StringBuilder
    //   5361: dup
    //   5362: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   5365: ldc_w 1024
    //   5368: invokestatic 430	anvx:a	(I)Ljava/lang/String;
    //   5371: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5374: aload_0
    //   5375: getfield 1020	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5378: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5384: putfield 1020	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5387: aload 4
    //   5389: aload_0
    //   5390: getfield 1020	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5393: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5396: return
    //   5397: aload_2
    //   5398: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5401: sipush -2025
    //   5404: if_icmpeq +13 -> 5417
    //   5407: aload_2
    //   5408: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5411: sipush -2072
    //   5414: if_icmpne +13 -> 5427
    //   5417: aload 4
    //   5419: aload_2
    //   5420: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5423: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5426: return
    //   5427: aload_2
    //   5428: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5431: sipush -2076
    //   5434: if_icmpne +58 -> 5492
    //   5437: new 1026	com/tencent/mobileqq/data/MessageForLocationShare
    //   5440: dup
    //   5441: invokespecial 1027	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5444: astore_1
    //   5445: aload_1
    //   5446: aload_2
    //   5447: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5450: putfield 1028	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5453: aload_1
    //   5454: invokevirtual 1029	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5457: aload_1
    //   5458: getfield 1030	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5461: astore_2
    //   5462: aload_2
    //   5463: astore_1
    //   5464: aload_2
    //   5465: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5468: ifeq +11 -> 5479
    //   5471: aload_0
    //   5472: ldc_w 1031
    //   5475: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   5478: astore_1
    //   5479: aload 19
    //   5481: ldc 123
    //   5483: aload_1
    //   5484: iconst_0
    //   5485: iconst_0
    //   5486: aload 4
    //   5488: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5491: return
    //   5492: aload_2
    //   5493: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5496: sipush -2052
    //   5499: if_icmpne +75 -> 5574
    //   5502: aload_2
    //   5503: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5506: astore_0
    //   5507: aload_2
    //   5508: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5511: aload_2
    //   5512: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5515: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   5518: ifeq +8 -> 5526
    //   5521: aload_2
    //   5522: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5525: astore_0
    //   5526: aload_1
    //   5527: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5530: aload_0
    //   5531: aload_2
    //   5532: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5535: aload_2
    //   5536: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5539: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5542: astore_0
    //   5543: aload_0
    //   5544: instanceof 1033
    //   5547: ifeq -5543 -> 4
    //   5550: aload_0
    //   5551: checkcast 1033	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5554: astore_0
    //   5555: aload_0
    //   5556: invokevirtual 1034	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5559: aload 19
    //   5561: aload_0
    //   5562: invokevirtual 1035	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5565: aconst_null
    //   5566: iconst_0
    //   5567: iconst_0
    //   5568: aload 4
    //   5570: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5573: return
    //   5574: aload_2
    //   5575: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5578: sipush -2047
    //   5581: if_icmpne +51 -> 5632
    //   5584: new 1037	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5587: dup
    //   5588: invokespecial 1038	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5591: astore_0
    //   5592: aload_0
    //   5593: aload_2
    //   5594: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5597: putfield 1039	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5600: aload_0
    //   5601: invokevirtual 1040	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5604: aload_0
    //   5605: invokevirtual 1041	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5608: astore_0
    //   5609: aload_0
    //   5610: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5613: ifne +10 -> 5623
    //   5616: aload 4
    //   5618: aload_0
    //   5619: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5622: return
    //   5623: aload 4
    //   5625: ldc_w 1043
    //   5628: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5631: return
    //   5632: aload_2
    //   5633: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5636: sipush -2040
    //   5639: if_icmpne +29 -> 5668
    //   5642: new 1045	com/tencent/mobileqq/data/MessageForApproval
    //   5645: dup
    //   5646: invokespecial 1046	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5649: astore_0
    //   5650: aload_0
    //   5651: aload_2
    //   5652: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5655: putfield 1047	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5658: aload 4
    //   5660: aload_0
    //   5661: invokevirtual 1050	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5664: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5667: return
    //   5668: aload_2
    //   5669: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5672: sipush -2041
    //   5675: if_icmpne +49 -> 5724
    //   5678: aload_0
    //   5679: ldc_w 1051
    //   5682: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   5685: astore_1
    //   5686: aload_0
    //   5687: ldc_w 1052
    //   5690: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   5693: astore_0
    //   5694: aload 4
    //   5696: new 165	java/lang/StringBuilder
    //   5699: dup
    //   5700: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   5703: aload_1
    //   5704: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5707: ldc_w 539
    //   5710: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5713: aload_0
    //   5714: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5717: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5720: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5723: return
    //   5724: aload_2
    //   5725: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5728: sipush -7001
    //   5731: if_icmpne +157 -> 5888
    //   5734: aload_2
    //   5735: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5738: astore 5
    //   5740: aload_2
    //   5741: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5744: aload_2
    //   5745: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5748: invokestatic 609	acnh:b	(Ljava/lang/String;I)Z
    //   5751: ifeq +9 -> 5760
    //   5754: aload_2
    //   5755: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5758: astore 5
    //   5760: aload_1
    //   5761: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5764: aload 5
    //   5766: aload_2
    //   5767: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5770: aload_2
    //   5771: getfield 32	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5774: invokevirtual 300	com/tencent/imcore/message/QQMessageFacade:queryMsgItemByUniseq	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5777: checkcast 1054	com/tencent/mobileqq/data/MessageForScribble
    //   5780: astore_1
    //   5781: aload_1
    //   5782: invokevirtual 1055	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5785: ifeq +56 -> 5841
    //   5788: aload_1
    //   5789: getfield 1058	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5792: istore_3
    //   5793: iload_3
    //   5794: iconst_2
    //   5795: if_icmpne +29 -> 5824
    //   5798: iconst_1
    //   5799: istore 7
    //   5801: iconst_0
    //   5802: istore 6
    //   5804: aload 19
    //   5806: aload_0
    //   5807: ldc_w 1059
    //   5810: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   5813: aconst_null
    //   5814: iload 7
    //   5816: iload 6
    //   5818: aload 4
    //   5820: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5823: return
    //   5824: aload_1
    //   5825: getfield 1058	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5828: iconst_3
    //   5829: if_icmpne +1921 -> 7750
    //   5832: iconst_1
    //   5833: istore 6
    //   5835: iconst_0
    //   5836: istore 7
    //   5838: goto -34 -> 5804
    //   5841: aload_1
    //   5842: getfield 1062	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5845: iconst_2
    //   5846: if_icmpne +1904 -> 7750
    //   5849: aload_1
    //   5850: invokestatic 1067	bbxw:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5853: istore_3
    //   5854: getstatic 1069	bbxw:c	I
    //   5857: istore 8
    //   5859: iload_3
    //   5860: iload 8
    //   5862: if_icmpeq +1888 -> 7750
    //   5865: iconst_1
    //   5866: istore 7
    //   5868: iconst_0
    //   5869: istore 6
    //   5871: goto -67 -> 5804
    //   5874: astore_1
    //   5875: aload_1
    //   5876: invokevirtual 528	java/lang/Exception:printStackTrace	()V
    //   5879: iconst_0
    //   5880: istore 6
    //   5882: iconst_0
    //   5883: istore 7
    //   5885: goto -81 -> 5804
    //   5888: aload_1
    //   5889: aload_2
    //   5890: invokestatic 1072	axnc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   5893: ifeq +18 -> 5911
    //   5896: aload 19
    //   5898: aload_2
    //   5899: invokevirtual 1076	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5902: aconst_null
    //   5903: iconst_0
    //   5904: iconst_0
    //   5905: aload 4
    //   5907: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5910: return
    //   5911: aload_2
    //   5912: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5915: ifnonnull +11 -> 5926
    //   5918: aload 4
    //   5920: ldc 123
    //   5922: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5925: return
    //   5926: aload_2
    //   5927: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5930: sipush -5003
    //   5933: if_icmpne +13 -> 5946
    //   5936: aload 4
    //   5938: aload_2
    //   5939: invokevirtual 1076	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5942: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5945: return
    //   5946: aload_2
    //   5947: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5950: sipush -2033
    //   5953: if_icmpne +16 -> 5969
    //   5956: aconst_null
    //   5957: getstatic 1081	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   5960: aconst_null
    //   5961: iconst_0
    //   5962: iconst_0
    //   5963: aload 4
    //   5965: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5968: return
    //   5969: aload_2
    //   5970: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5973: sipush -2049
    //   5976: if_icmpne +16 -> 5992
    //   5979: aload 4
    //   5981: aload_2
    //   5982: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5985: invokestatic 577	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   5988: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5991: return
    //   5992: aload_2
    //   5993: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5996: sipush -1035
    //   5999: if_icmpne +308 -> 6307
    //   6002: iconst_0
    //   6003: istore 10
    //   6005: iconst_0
    //   6006: istore 11
    //   6008: iload 10
    //   6010: istore 6
    //   6012: iload 11
    //   6014: istore 7
    //   6016: aload_2
    //   6017: invokevirtual 315	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   6020: ifeq +31 -> 6051
    //   6023: aload_2
    //   6024: getfield 965	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6027: ldc_w 1082
    //   6030: if_icmpne +192 -> 6222
    //   6033: aload_1
    //   6034: invokevirtual 1086	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   6037: aload_2
    //   6038: invokevirtual 1089	bcrg:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6041: ifne +171 -> 6212
    //   6044: iconst_1
    //   6045: istore 6
    //   6047: iload 11
    //   6049: istore 7
    //   6051: aload_2
    //   6052: invokevirtual 1076	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6055: astore_0
    //   6056: aload_2
    //   6057: invokestatic 1092	bgls:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6060: ifeq +1687 -> 7747
    //   6063: aload_2
    //   6064: invokestatic 1094	bgls:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6067: ifne +7 -> 6074
    //   6070: aload_2
    //   6071: invokestatic 1097	bgls:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6074: aload_2
    //   6075: invokestatic 1100	bgls:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6078: astore_1
    //   6079: aload_1
    //   6080: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6083: ifne +1664 -> 7747
    //   6086: aload_1
    //   6087: astore_0
    //   6088: aload_2
    //   6089: getfield 1103	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6092: ifnull +198 -> 6290
    //   6095: aload_0
    //   6096: ifnull +194 -> 6290
    //   6099: new 165	java/lang/StringBuilder
    //   6102: dup
    //   6103: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   6106: astore_1
    //   6107: aload 19
    //   6109: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6112: ifne +16 -> 6128
    //   6115: aload_1
    //   6116: aload 19
    //   6118: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6121: ldc_w 435
    //   6124: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6127: pop
    //   6128: aload 4
    //   6130: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6133: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6136: ifne +13 -> 6149
    //   6139: aload_1
    //   6140: aload 4
    //   6142: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6145: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6148: pop
    //   6149: aload_2
    //   6150: invokestatic 287	nty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6153: ifne +16 -> 6169
    //   6156: iload 6
    //   6158: ifeq +89 -> 6247
    //   6161: aload_1
    //   6162: ldc_w 791
    //   6165: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6168: pop
    //   6169: aload_0
    //   6170: instanceof 793
    //   6173: ifeq +90 -> 6263
    //   6176: aload_0
    //   6177: checkcast 793	com/tencent/mobileqq/text/QQText
    //   6180: aload_1
    //   6181: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6184: iconst_1
    //   6185: iconst_0
    //   6186: newarray int
    //   6188: invokevirtual 796	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   6191: astore_0
    //   6192: aload 4
    //   6194: iconst_1
    //   6195: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6198: aload 19
    //   6200: aload_0
    //   6201: aconst_null
    //   6202: iload 6
    //   6204: iload 7
    //   6206: aload 4
    //   6208: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6211: return
    //   6212: iconst_1
    //   6213: istore 7
    //   6215: iload 10
    //   6217: istore 6
    //   6219: goto -168 -> 6051
    //   6222: iconst_0
    //   6223: istore 7
    //   6225: aload_2
    //   6226: getfield 965	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6229: ldc_w 662
    //   6232: if_icmpne +9 -> 6241
    //   6235: iconst_1
    //   6236: istore 6
    //   6238: goto -187 -> 6051
    //   6241: iconst_0
    //   6242: istore 6
    //   6244: goto -6 -> 6238
    //   6247: iload 7
    //   6249: ifeq -80 -> 6169
    //   6252: aload_1
    //   6253: ldc_w 799
    //   6256: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6259: pop
    //   6260: goto -91 -> 6169
    //   6263: aload_1
    //   6264: aload_0
    //   6265: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6268: pop
    //   6269: new 1105	android/text/SpannableString
    //   6272: dup
    //   6273: aload_1
    //   6274: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6277: invokespecial 1108	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6280: astore_0
    //   6281: aload 4
    //   6283: iconst_0
    //   6284: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6287: goto -89 -> 6198
    //   6290: aload 19
    //   6292: aload_0
    //   6293: invokestatic 1111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6296: aconst_null
    //   6297: iload 6
    //   6299: iload 7
    //   6301: aload 4
    //   6303: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6306: return
    //   6307: aload_2
    //   6308: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6311: sipush -2057
    //   6314: if_icmpne +17 -> 6331
    //   6317: aload 19
    //   6319: getstatic 1116	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6322: aconst_null
    //   6323: iconst_0
    //   6324: iconst_0
    //   6325: aload 4
    //   6327: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6330: return
    //   6331: aload_2
    //   6332: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6335: sipush -1012
    //   6338: if_icmpne +70 -> 6408
    //   6341: aload_2
    //   6342: invokevirtual 1076	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6345: invokeinterface 1119 1 0
    //   6350: invokestatic 577	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6353: astore_1
    //   6354: aload_0
    //   6355: ldc_w 1120
    //   6358: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   6361: astore_2
    //   6362: aload_1
    //   6363: invokevirtual 210	java/lang/String:length	()I
    //   6366: aload_2
    //   6367: invokevirtual 210	java/lang/String:length	()I
    //   6370: isub
    //   6371: iconst_1
    //   6372: isub
    //   6373: istore_3
    //   6374: aload_1
    //   6375: astore_0
    //   6376: aload_1
    //   6377: aload_2
    //   6378: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6381: ifeq +16 -> 6397
    //   6384: aload_1
    //   6385: astore_0
    //   6386: iload_3
    //   6387: ifle +10 -> 6397
    //   6390: aload_1
    //   6391: iconst_0
    //   6392: iload_3
    //   6393: invokevirtual 359	java/lang/String:substring	(II)Ljava/lang/String;
    //   6396: astore_0
    //   6397: aconst_null
    //   6398: aload_0
    //   6399: aconst_null
    //   6400: iconst_0
    //   6401: iconst_0
    //   6402: aload 4
    //   6404: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6407: return
    //   6408: aload_2
    //   6409: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6412: sipush -2059
    //   6415: if_icmpne +33 -> 6448
    //   6418: new 1122	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6421: dup
    //   6422: invokespecial 1123	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6425: astore_0
    //   6426: aload_0
    //   6427: aload_2
    //   6428: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6431: putfield 1124	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6434: aload_0
    //   6435: invokevirtual 1127	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6438: aload 4
    //   6440: aload_0
    //   6441: invokevirtual 1128	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6444: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6447: return
    //   6448: aload_2
    //   6449: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6452: sipush -2066
    //   6455: if_icmpne +87 -> 6542
    //   6458: new 1130	com/tencent/mobileqq/data/MessageForConfessCard
    //   6461: dup
    //   6462: invokespecial 1131	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6465: astore_0
    //   6466: aload_0
    //   6467: aload_2
    //   6468: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6471: putfield 1132	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6474: aload_0
    //   6475: invokevirtual 1133	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6478: aload_2
    //   6479: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6482: sipush 1032
    //   6485: if_icmpne +18 -> 6503
    //   6488: aload 19
    //   6490: aload_0
    //   6491: getfield 1136	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6494: aconst_null
    //   6495: iconst_0
    //   6496: iconst_0
    //   6497: aload 4
    //   6499: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6502: return
    //   6503: ldc 123
    //   6505: new 165	java/lang/StringBuilder
    //   6508: dup
    //   6509: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   6512: aload 19
    //   6514: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6517: ldc_w 1138
    //   6520: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6523: aload_0
    //   6524: getfield 1136	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6527: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6530: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6533: aconst_null
    //   6534: iconst_0
    //   6535: iconst_0
    //   6536: aload 4
    //   6538: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6541: return
    //   6542: aload_2
    //   6543: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6546: sipush -2067
    //   6549: if_icmpne +38 -> 6587
    //   6552: new 1140	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6555: dup
    //   6556: invokespecial 1141	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6559: astore_0
    //   6560: aload_0
    //   6561: aload_2
    //   6562: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6565: putfield 1142	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6568: aload_0
    //   6569: invokevirtual 1143	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6572: aload 19
    //   6574: aload_0
    //   6575: getfield 1144	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6578: aconst_null
    //   6579: iconst_0
    //   6580: iconst_0
    //   6581: aload 4
    //   6583: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6586: return
    //   6587: aload_2
    //   6588: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6591: sipush -5008
    //   6594: if_icmpeq +23 -> 6617
    //   6597: aload_2
    //   6598: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6601: sipush -5016
    //   6604: if_icmpeq +13 -> 6617
    //   6607: aload_2
    //   6608: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6611: sipush -5017
    //   6614: if_icmpne +113 -> 6727
    //   6617: aload_2
    //   6618: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6621: sipush -5016
    //   6624: if_icmpne +64 -> 6688
    //   6627: new 1146	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6630: dup
    //   6631: invokespecial 1147	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6634: astore_0
    //   6635: aload_0
    //   6636: aload_2
    //   6637: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6640: putfield 1148	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6643: aload_0
    //   6644: invokevirtual 1149	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6647: aload 4
    //   6649: aload_0
    //   6650: invokevirtual 1152	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6653: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6656: aload_1
    //   6657: aload_2
    //   6658: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6661: istore 6
    //   6663: aload_1
    //   6664: aload_2
    //   6665: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6668: istore 7
    //   6670: aload 19
    //   6672: aload 4
    //   6674: getfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6677: aconst_null
    //   6678: iload 6
    //   6680: iload 7
    //   6682: aload 4
    //   6684: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6687: return
    //   6688: new 1154	com/tencent/mobileqq/data/MessageForArkApp
    //   6691: dup
    //   6692: invokespecial 1155	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6695: astore_0
    //   6696: aload_0
    //   6697: aload_2
    //   6698: getfield 772	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6701: putfield 1156	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6704: aload_0
    //   6705: invokevirtual 1157	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6708: aload 4
    //   6710: aload_0
    //   6711: invokevirtual 1158	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6714: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6717: aload_2
    //   6718: aload 4
    //   6720: aload_1
    //   6721: invokestatic 1161	bhfj:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   6724: goto -68 -> 6656
    //   6727: aload_1
    //   6728: aload_2
    //   6729: invokestatic 604	bhfj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6732: istore 6
    //   6734: aload_1
    //   6735: aload_2
    //   6736: invokestatic 606	bhfj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6739: istore 7
    //   6741: aload_2
    //   6742: getfield 1164	com/tencent/imcore/message/QQMessageFacade$Message:fileType	I
    //   6745: lookupswitch	default:+51->6796, 1:+195->6940, 2:+276->7021, 8:+276->7021, 65536:+177->6922, 65538:+258->7003
    //   6797: ldc_w 741
    //   6800: invokevirtual 744	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6803: astore 5
    //   6805: getstatic 749	com/tencent/mobileqq/emoticon/EmojiStickerManager:e	Z
    //   6808: ifeq +316 -> 7124
    //   6811: aload 5
    //   6813: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6816: ifne +308 -> 7124
    //   6819: aload_1
    //   6820: aload_2
    //   6821: aload 4
    //   6823: invokestatic 783	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Lcom/tencent/mobileqq/text/QQText;
    //   6826: astore_0
    //   6827: new 165	java/lang/StringBuilder
    //   6830: dup
    //   6831: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   6834: astore_1
    //   6835: aload 19
    //   6837: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6840: ifne +16 -> 6856
    //   6843: aload_1
    //   6844: aload 19
    //   6846: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6849: ldc_w 435
    //   6852: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6855: pop
    //   6856: aload 4
    //   6858: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6861: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6864: ifne +13 -> 6877
    //   6867: aload_1
    //   6868: aload 4
    //   6870: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   6873: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6876: pop
    //   6877: aload_2
    //   6878: invokestatic 287	nty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6881: ifne +16 -> 6897
    //   6884: iload 6
    //   6886: ifeq +222 -> 7108
    //   6889: aload_1
    //   6890: ldc_w 791
    //   6893: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6896: pop
    //   6897: aload 19
    //   6899: aload_0
    //   6900: aload_1
    //   6901: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6904: iconst_1
    //   6905: iconst_0
    //   6906: newarray int
    //   6908: invokevirtual 796	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   6911: aconst_null
    //   6912: iload 6
    //   6914: iload 7
    //   6916: aload 4
    //   6918: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6921: return
    //   6922: aload 19
    //   6924: ldc 123
    //   6926: aload_2
    //   6927: getfield 572	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6930: iload 6
    //   6932: iload 7
    //   6934: aload 4
    //   6936: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6939: return
    //   6940: aload_2
    //   6941: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6944: sipush 1001
    //   6947: if_icmpeq +13 -> 6960
    //   6950: aload_2
    //   6951: getfield 39	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6954: sipush 10002
    //   6957: if_icmpne +26 -> 6983
    //   6960: aload_2
    //   6961: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6964: sipush -3001
    //   6967: if_icmpne +16 -> 6983
    //   6970: aload 4
    //   6972: aload_0
    //   6973: ldc_w 1165
    //   6976: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   6979: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6982: return
    //   6983: aload 19
    //   6985: aload_0
    //   6986: ldc_w 648
    //   6989: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   6992: aconst_null
    //   6993: iload 6
    //   6995: iload 7
    //   6997: aload 4
    //   6999: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7002: return
    //   7003: aload 19
    //   7005: aload_0
    //   7006: ldc_w 648
    //   7009: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   7012: aconst_null
    //   7013: iconst_0
    //   7014: iconst_0
    //   7015: aload 4
    //   7017: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7020: return
    //   7021: ldc_w 675
    //   7024: iconst_3
    //   7025: anewarray 4	java/lang/Object
    //   7028: dup
    //   7029: iconst_0
    //   7030: iload_3
    //   7031: invokestatic 701	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7034: aastore
    //   7035: dup
    //   7036: iconst_1
    //   7037: iload 6
    //   7039: invokestatic 680	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7042: aastore
    //   7043: dup
    //   7044: iconst_2
    //   7045: iload 7
    //   7047: invokestatic 680	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7050: aastore
    //   7051: invokestatic 685	arxx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7054: aload_0
    //   7055: ldc_w 665
    //   7058: invokevirtual 214	android/content/Context:getString	(I)Ljava/lang/String;
    //   7061: astore_0
    //   7062: aload_2
    //   7063: getfield 200	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   7066: aload_1
    //   7067: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7070: invokestatic 1168	bhbx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7073: ifeq +22 -> 7095
    //   7076: iload_3
    //   7077: ifeq +18 -> 7095
    //   7080: aload 19
    //   7082: aload_0
    //   7083: ldc 123
    //   7085: iload 6
    //   7087: iload 7
    //   7089: aload 4
    //   7091: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7094: return
    //   7095: aload 19
    //   7097: aload_0
    //   7098: ldc 123
    //   7100: iconst_0
    //   7101: iconst_0
    //   7102: aload 4
    //   7104: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7107: return
    //   7108: iload 7
    //   7110: ifeq -213 -> 6897
    //   7113: aload_1
    //   7114: ldc_w 799
    //   7117: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7120: pop
    //   7121: goto -224 -> 6897
    //   7124: aload_2
    //   7125: invokevirtual 1076	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   7128: astore 5
    //   7130: aload_2
    //   7131: invokestatic 1092	bgls:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7134: ifeq +610 -> 7744
    //   7137: aload_2
    //   7138: invokestatic 1094	bgls:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7141: ifne +7 -> 7148
    //   7144: aload_2
    //   7145: invokestatic 1097	bgls:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   7148: aload_2
    //   7149: invokestatic 1100	bgls:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   7152: astore 16
    //   7154: aload 16
    //   7156: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7159: ifne +585 -> 7744
    //   7162: aload 16
    //   7164: astore 5
    //   7166: aload_2
    //   7167: getfield 1103	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   7170: ifnull +410 -> 7580
    //   7173: aload 5
    //   7175: ifnull +405 -> 7580
    //   7178: new 165	java/lang/StringBuilder
    //   7181: dup
    //   7182: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   7185: astore_0
    //   7186: aload 19
    //   7188: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7191: ifne +16 -> 7207
    //   7194: aload_0
    //   7195: aload 19
    //   7197: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7200: ldc_w 435
    //   7203: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7206: pop
    //   7207: aload 4
    //   7209: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   7212: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7215: ifne +13 -> 7228
    //   7218: aload_0
    //   7219: aload 4
    //   7221: getfield 786	com/tencent/mobileqq/activity/recent/MsgSummary:prefixOfContent	Ljava/lang/CharSequence;
    //   7224: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7227: pop
    //   7228: aload_2
    //   7229: invokestatic 287	nty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7232: ifne +16 -> 7248
    //   7235: iload 6
    //   7237: ifeq +299 -> 7536
    //   7240: aload_0
    //   7241: ldc_w 791
    //   7244: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7247: pop
    //   7248: aload 5
    //   7250: instanceof 793
    //   7253: ifeq +299 -> 7552
    //   7256: aload 5
    //   7258: checkcast 793	com/tencent/mobileqq/text/QQText
    //   7261: aload_0
    //   7262: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7265: iconst_1
    //   7266: iconst_3
    //   7267: newarray int
    //   7269: dup
    //   7270: iconst_0
    //   7271: aload 5
    //   7273: checkcast 793	com/tencent/mobileqq/text/QQText
    //   7276: getfield 1171	com/tencent/mobileqq/text/QQText:mFlags	I
    //   7279: iastore
    //   7280: dup
    //   7281: iconst_1
    //   7282: bipush 16
    //   7284: iastore
    //   7285: dup
    //   7286: iconst_2
    //   7287: iconst_1
    //   7288: iastore
    //   7289: invokevirtual 796	com/tencent/mobileqq/text/QQText:append	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   7292: astore_0
    //   7293: aload 4
    //   7295: iconst_1
    //   7296: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7299: aload_2
    //   7300: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7303: sipush -5040
    //   7306: if_icmpne +435 -> 7741
    //   7309: new 165	java/lang/StringBuilder
    //   7312: dup
    //   7313: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   7316: ldc_w 539
    //   7319: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7322: invokestatic 420	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7325: ldc_w 1172
    //   7328: invokevirtual 422	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7331: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7334: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7337: astore 5
    //   7339: aload_0
    //   7340: invokeinterface 1119 1 0
    //   7345: astore 16
    //   7347: aload 16
    //   7349: ifnull +386 -> 7735
    //   7352: aload 16
    //   7354: aload 5
    //   7356: invokevirtual 1175	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7359: ifeq +376 -> 7735
    //   7362: aload 16
    //   7364: aload 5
    //   7366: ldc 123
    //   7368: invokevirtual 280	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7371: astore 5
    //   7373: aload 5
    //   7375: astore_0
    //   7376: iload_3
    //   7377: ifne +77 -> 7454
    //   7380: aload_1
    //   7381: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7384: aload_2
    //   7385: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7388: iconst_0
    //   7389: invokevirtual 1179	com/tencent/imcore/message/QQMessageFacade:getLastMsgForMsgTab	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7392: astore 16
    //   7394: aload 5
    //   7396: astore_0
    //   7397: aload 16
    //   7399: instanceof 1181
    //   7402: ifeq +52 -> 7454
    //   7405: aload 5
    //   7407: astore_0
    //   7408: aload 16
    //   7410: checkcast 1181	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7413: getfield 1185	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavhz;
    //   7416: ifnull +38 -> 7454
    //   7419: aload 5
    //   7421: astore_0
    //   7422: aload 16
    //   7424: checkcast 1181	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7427: getfield 1185	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavhz;
    //   7430: getfield 1189	avhz:b	I
    //   7433: invokestatic 1192	axma:b	(I)Z
    //   7436: ifeq +18 -> 7454
    //   7439: aload_1
    //   7440: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7443: aload 5
    //   7445: invokeinterface 1119 1 0
    //   7450: invokestatic 1195	axnc:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7453: astore_0
    //   7454: aload_2
    //   7455: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7458: invokestatic 1198	acnh:j	(I)Z
    //   7461: ifeq +271 -> 7732
    //   7464: aload_1
    //   7465: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7468: aload_2
    //   7469: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7472: iload_3
    //   7473: invokevirtual 1179	com/tencent/imcore/message/QQMessageFacade:getLastMsgForMsgTab	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7476: astore_1
    //   7477: aload_1
    //   7478: ifnull +254 -> 7732
    //   7481: aload_1
    //   7482: instanceof 1181
    //   7485: ifeq +247 -> 7732
    //   7488: aload_1
    //   7489: checkcast 1181	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7492: getfield 1185	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavhz;
    //   7495: ifnull +237 -> 7732
    //   7498: aload_1
    //   7499: checkcast 1181	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7502: getfield 1185	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lavhz;
    //   7505: getfield 1189	avhz:b	I
    //   7508: ldc_w 1199
    //   7511: if_icmpne +221 -> 7732
    //   7514: aload_1
    //   7515: checkcast 1181	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7518: invokevirtual 1200	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7521: astore_0
    //   7522: aload 19
    //   7524: aload_0
    //   7525: aconst_null
    //   7526: iload 6
    //   7528: iload 7
    //   7530: aload 4
    //   7532: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7535: return
    //   7536: iload 7
    //   7538: ifeq -290 -> 7248
    //   7541: aload_0
    //   7542: ldc_w 799
    //   7545: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7548: pop
    //   7549: goto -301 -> 7248
    //   7552: aload_0
    //   7553: aload 5
    //   7555: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7558: pop
    //   7559: new 1105	android/text/SpannableString
    //   7562: dup
    //   7563: aload_0
    //   7564: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7567: invokespecial 1108	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7570: astore_0
    //   7571: aload 4
    //   7573: iconst_0
    //   7574: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7577: goto -278 -> 7299
    //   7580: aload 5
    //   7582: ifnull +114 -> 7696
    //   7585: aload 5
    //   7587: invokeinterface 1119 1 0
    //   7592: invokevirtual 193	java/lang/String:trim	()Ljava/lang/String;
    //   7595: astore 5
    //   7597: getstatic 1203	com/tencent/mobileqq/app/AppConstants:SYSTEM_MSG_UIN	Ljava/lang/String;
    //   7600: aload_2
    //   7601: getfield 36	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7604: invokevirtual 1206	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7607: ifeq +119 -> 7726
    //   7610: aload 5
    //   7612: ifnull +114 -> 7726
    //   7615: aload 5
    //   7617: invokevirtual 210	java/lang/String:length	()I
    //   7620: ifle +106 -> 7726
    //   7623: aload_0
    //   7624: aload_1
    //   7625: aload 5
    //   7627: aload_2
    //   7628: invokestatic 1208	bhfj:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   7631: astore_0
    //   7632: aload 19
    //   7634: aconst_null
    //   7635: aload_0
    //   7636: iload 6
    //   7638: aload_1
    //   7639: invokevirtual 1086	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   7642: aload_2
    //   7643: invokevirtual 1089	bcrg:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7646: aload 4
    //   7648: invokestatic 598	bhfj:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7651: aload_2
    //   7652: getfield 179	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7655: sipush -1000
    //   7658: if_icmpne +44 -> 7702
    //   7661: aload 4
    //   7663: getfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7666: ifnull +36 -> 7702
    //   7669: aload 4
    //   7671: new 793	com/tencent/mobileqq/text/QQText
    //   7674: dup
    //   7675: aload 4
    //   7677: getfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7680: iconst_1
    //   7681: bipush 16
    //   7683: invokespecial 1211	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   7686: putfield 582	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7689: aload 4
    //   7691: iconst_1
    //   7692: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7695: return
    //   7696: aconst_null
    //   7697: astore 5
    //   7699: goto -102 -> 7597
    //   7702: aload 4
    //   7704: iconst_0
    //   7705: putfield 810	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7708: return
    //   7709: astore 5
    //   7711: goto -2565 -> 5146
    //   7714: astore 17
    //   7716: aload 16
    //   7718: astore_1
    //   7719: aload 17
    //   7721: astore 16
    //   7723: goto -7068 -> 655
    //   7726: aload 5
    //   7728: astore_0
    //   7729: goto -97 -> 7632
    //   7732: goto -210 -> 7522
    //   7735: aload_0
    //   7736: astore 5
    //   7738: goto -365 -> 7373
    //   7741: goto -287 -> 7454
    //   7744: goto -578 -> 7166
    //   7747: goto -1659 -> 6088
    //   7750: iconst_0
    //   7751: istore 6
    //   7753: iconst_0
    //   7754: istore 7
    //   7756: goto -1952 -> 5804
    //   7759: goto -4193 -> 3566
    //   7762: iconst_0
    //   7763: istore 6
    //   7765: goto -5425 -> 2340
    //   7768: goto -5511 -> 2257
    //   7771: aload 5
    //   7773: astore_0
    //   7774: goto -5872 -> 1902
    //   7777: iconst_0
    //   7778: istore 7
    //   7780: iconst_0
    //   7781: istore 6
    //   7783: goto -6923 -> 860
    //   7786: goto -7006 -> 780
    //   7789: aload_1
    //   7790: astore_0
    //   7791: goto -7229 -> 562
    //   7794: iconst_0
    //   7795: istore 6
    //   7797: goto -7293 -> 504
    //   7800: iconst_0
    //   7801: istore 6
    //   7803: goto -7362 -> 441
    //   7806: iconst_0
    //   7807: istore 6
    //   7809: goto -7407 -> 402
    //   7812: goto -7489 -> 323
    //   7815: iconst_0
    //   7816: istore 6
    //   7818: goto -7416 -> 402
    //   7821: iconst_1
    //   7822: istore_3
    //   7823: goto -6056 -> 1767
    //   7826: astore_1
    //   7827: aload 17
    //   7829: astore_0
    //   7830: goto -5842 -> 1988
    //   7833: iconst_0
    //   7834: istore 6
    //   7836: goto -5496 -> 2340
    //   7839: ldc2_w 40
    //   7842: lstore 14
    //   7844: goto -5424 -> 2420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7847	0	paramContext	Context
    //   0	7847	1	paramQQAppInterface	QQAppInterface
    //   0	7847	2	paramMessage	QQMessageFacade.Message
    //   0	7847	3	paramInt	int
    //   0	7847	4	paramMsgSummary	MsgSummary
    //   0	7847	5	paramString	String
    //   0	7847	6	paramBoolean1	boolean
    //   0	7847	7	paramBoolean2	boolean
    //   120	5743	8	i	int
    //   1636	572	9	j	int
    //   687	5529	10	bool1	boolean
    //   2211	3837	11	bool2	boolean
    //   1576	593	12	bool3	boolean
    //   1583	596	13	bool4	boolean
    //   386	7457	14	l	long
    //   343	242	16	localObject1	Object
    //   651	5	16	localException1	Exception
    //   665	7057	16	localObject2	Object
    //   301	2348	17	localObject3	Object
    //   7714	114	17	localException2	Exception
    //   292	1992	18	str1	String
    //   18	7615	19	str2	String
    //   2281	256	20	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   297	323	651	java/lang/Exception
    //   323	345	651	java/lang/Exception
    //   1814	1843	1987	java/lang/Exception
    //   1843	1864	1987	java/lang/Exception
    //   1864	1871	1987	java/lang/Exception
    //   1876	1884	1987	java/lang/Exception
    //   1884	1900	1987	java/lang/Exception
    //   1976	1984	1987	java/lang/Exception
    //   2223	2229	2603	java/lang/Exception
    //   2233	2247	2603	java/lang/Exception
    //   2251	2257	2603	java/lang/Exception
    //   2261	2283	2603	java/lang/Exception
    //   2287	2301	2603	java/lang/Exception
    //   2304	2311	2603	java/lang/Exception
    //   2314	2321	2603	java/lang/Exception
    //   2536	2547	2603	java/lang/Exception
    //   2560	2567	2603	java/lang/Exception
    //   2570	2579	2603	java/lang/Exception
    //   2758	2793	2894	java/lang/Throwable
    //   2809	2859	2894	java/lang/Throwable
    //   2864	2889	2894	java/lang/Throwable
    //   4666	4672	5142	java/lang/Exception
    //   4672	4692	5142	java/lang/Exception
    //   4692	4706	5142	java/lang/Exception
    //   5734	5740	5874	java/lang/Exception
    //   5740	5760	5874	java/lang/Exception
    //   5760	5793	5874	java/lang/Exception
    //   5824	5832	5874	java/lang/Exception
    //   5841	5859	5874	java/lang/Exception
    //   4706	4734	7709	java/lang/Exception
    //   4738	4818	7709	java/lang/Exception
    //   5052	5059	7709	java/lang/Exception
    //   5063	5071	7709	java/lang/Exception
    //   5075	5086	7709	java/lang/Exception
    //   5094	5105	7709	java/lang/Exception
    //   5109	5120	7709	java/lang/Exception
    //   5120	5136	7709	java/lang/Exception
    //   349	363	7714	java/lang/Exception
    //   366	373	7714	java/lang/Exception
    //   381	388	7714	java/lang/Exception
    //   584	595	7714	java/lang/Exception
    //   608	615	7714	java/lang/Exception
    //   618	627	7714	java/lang/Exception
    //   1592	1601	7826	java/lang/Exception
    //   1609	1617	7826	java/lang/Exception
    //   1621	1638	7826	java/lang/Exception
    //   1649	1656	7826	java/lang/Exception
    //   1682	1695	7826	java/lang/Exception
    //   1699	1705	7826	java/lang/Exception
    //   1709	1716	7826	java/lang/Exception
    //   1720	1734	7826	java/lang/Exception
    //   1738	1764	7826	java/lang/Exception
    //   1779	1785	7826	java/lang/Exception
    //   1789	1802	7826	java/lang/Exception
    //   1806	1814	7826	java/lang/Exception
    //   1926	1952	7826	java/lang/Exception
    //   1959	1966	7826	java/lang/Exception
    //   2023	2028	7826	java/lang/Exception
    //   2036	2044	7826	java/lang/Exception
    //   2048	2056	7826	java/lang/Exception
    //   2060	2073	7826	java/lang/Exception
    //   2077	2088	7826	java/lang/Exception
    //   2092	2102	7826	java/lang/Exception
    //   2106	2113	7826	java/lang/Exception
    //   2122	2130	7826	java/lang/Exception
    //   2134	2150	7826	java/lang/Exception
    //   2154	2160	7826	java/lang/Exception
    //   2164	2177	7826	java/lang/Exception
    //   2187	2195	7826	java/lang/Exception
    //   2348	2355	7826	java/lang/Exception
    //   2359	2364	7826	java/lang/Exception
    //   2368	2379	7826	java/lang/Exception
    //   2390	2396	7826	java/lang/Exception
    //   2400	2407	7826	java/lang/Exception
    //   2411	2420	7826	java/lang/Exception
    //   2424	2465	7826	java/lang/Exception
    //   2473	2481	7826	java/lang/Exception
    //   2485	2492	7826	java/lang/Exception
    //   2496	2503	7826	java/lang/Exception
    //   2507	2515	7826	java/lang/Exception
    //   2519	2532	7826	java/lang/Exception
    //   2608	2612	7826	java/lang/Exception
    //   2640	2646	7826	java/lang/Exception
    //   2650	2677	7826	java/lang/Exception
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
      paramMsgSummary.strContent += paramQQAppInterface.getApp().getString(2131692695);
    }
  }
  
  private static void a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessage != null) && (1 == paramInt))
    {
      paramQQAppInterface = ContactUtils.getTroopMemberNameInUI(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
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
    Iterator localIterator = paramQQAppInterface.getMessageFacade().getRegistry().b().iterator();
    while (localIterator.hasNext()) {
      if (((acod)localIterator.next()).a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
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
    if (acnh.b(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (acnh.b(paramMessage.senderuin)) {
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
      localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(paramMessage.senderuin, i);
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
      paramMessage = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && ((paramMessage instanceof MessageForTroopFile)))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramQQAppInterface = bgke.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.getTransFileController().findProcessor(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((BuddyTransfileProcessor)paramMessage).getProgress() >= 0) && (((BuddyTransfileProcessor)paramMessage).getProgress() != 100)) {
      return true;
    }
    return paramQQAppInterface.getMsgCache().b(localMessage);
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
      paramQQAppInterface = paramQQAppInterface.getTransFileController().findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
      if ((paramQQAppInterface instanceof BaseTransProcessor))
      {
        long l = ((BaseTransProcessor)paramQQAppInterface).getFileStatus();
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
          if (!acnh.b(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (acnh.b(paramMessage.senderuin));
        int i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label105;
          }
        }
        for (i = 1033;; i = 1034)
        {
          localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(paramMessage.senderuin, i);
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
          i = paramQQAppInterface.getTransFileController().findProcessorFileStatus(localMessage.frienduin, null, localMessage.uniseq);
          if ((i != 1005) && (i != 1004)) {
            break label284;
          }
          return true;
        }
        if (localMessage.msgtype != -2017) {
          break label284;
        }
        paramMessage = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
        if (!(paramMessage instanceof MessageForTroopFile)) {
          break;
        }
        paramMessage = (MessageForTroopFile)paramMessage;
      } while ((paramMessage == null) || (paramMessage.frienduin == null));
      paramQQAppInterface = bgke.a(paramQQAppInterface, paramMessage);
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
 * Qualified Name:     bhfj
 * JD-Core Version:    0.7.0.1
 */