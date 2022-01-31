package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MutilTransHead;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class MultiMsgProxy
  extends BaseProxy
{
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class, MessageForShortVideo.class, MessageForReplyText.class, MessageForTroopFile.class, MessageForQQStoryComment.class, MessageForArkApp.class, MessageForArkFlashChat.class };
  MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public MultiMsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private MessageRecordEntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {}
    do
    {
      return true;
      if (!MessageForFile.class.isInstance(paramChatMessage)) {
        break;
      }
    } while (!FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful());
    return false;
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (AnonymousChatHelper.a(paramChatMessage)) {
      return false;
    }
    if (GoldMsgChatHelper.c(paramChatMessage)) {
      return false;
    }
    if ((MessageForShortVideo.class.isInstance(paramChatMessage)) && (((MessageForShortVideo)paramChatMessage).busiType == 2)) {
      return false;
    }
    if ((MessageForLongTextMsg.class.isInstance(paramChatMessage)) && ((paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3")))) {
      return false;
    }
    if (!MessageForArkApp.getArkMutiForwardConf(paramChatMessage)) {
      return false;
    }
    if (MessageForTroopConfess.class.isInstance(paramChatMessage)) {
      return false;
    }
    Object localObject = jdField_a_of_type_ArrayOfJavaLangClass;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].isInstance(paramChatMessage)) {
        return true;
      }
      i += 1;
    }
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      localObject = (MessageForStructing)paramChatMessage;
      if ((((MessageForStructing)localObject).structingMsg != null) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction))) {
        return false;
      }
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 82)) {
        return false;
      }
      if (paramChatMessage.msgtype != -2011) {
        return false;
      }
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.fwFlag == 1)) {
        return false;
      }
      return (((MessageForStructing)localObject).structingMsg == null) || (!((MessageForStructing)localObject).structingMsg.hasFlag(1));
    }
    if ((paramChatMessage instanceof MessageForArkBabyqReply))
    {
      paramChatMessage = (MessageForArkBabyqReply)paramChatMessage;
      return (paramChatMessage.mArkBabyqReplyCardList != null) && (paramChatMessage.mArkBabyqReplyCardList.size() > 0);
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 177
    //   8: iconst_2
    //   9: new 179	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   16: ldc 182
    //   18: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: arraylength
    //   23: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 199	java/io/ByteArrayInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 202	java/io/ByteArrayInputStream:<init>	([B)V
    //   40: astore_3
    //   41: new 204	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: invokespecial 205	java/io/ByteArrayOutputStream:<init>	()V
    //   48: astore 4
    //   50: sipush 1024
    //   53: newarray byte
    //   55: astore_0
    //   56: new 207	java/util/zip/GZIPOutputStream
    //   59: dup
    //   60: aload 4
    //   62: invokespecial 210	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_2
    //   66: aload_3
    //   67: aload_0
    //   68: iconst_0
    //   69: sipush 1024
    //   72: invokevirtual 214	java/io/ByteArrayInputStream:read	([BII)I
    //   75: istore_1
    //   76: iload_1
    //   77: iconst_m1
    //   78: if_icmpeq +63 -> 141
    //   81: aload_2
    //   82: aload_0
    //   83: iconst_0
    //   84: iload_1
    //   85: invokevirtual 218	java/util/zip/GZIPOutputStream:write	([BII)V
    //   88: goto -22 -> 66
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_0
    //   94: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +31 -> 128
    //   100: ldc 177
    //   102: iconst_2
    //   103: new 179	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   110: ldc 220
    //   112: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_2
    //   116: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload 4
    //   130: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_3
    //   134: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   137: aload_0
    //   138: astore_2
    //   139: aload_2
    //   140: areturn
    //   141: aload_2
    //   142: invokevirtual 230	java/util/zip/GZIPOutputStream:flush	()V
    //   145: aload_2
    //   146: invokevirtual 231	java/util/zip/GZIPOutputStream:close	()V
    //   149: aload 4
    //   151: invokevirtual 235	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   154: astore_0
    //   155: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +29 -> 187
    //   161: ldc 177
    //   163: iconst_2
    //   164: new 179	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   171: ldc 237
    //   173: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: arraylength
    //   178: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 4
    //   189: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   192: aload_3
    //   193: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   196: aload_0
    //   197: areturn
    //   198: astore_3
    //   199: aload_0
    //   200: astore_2
    //   201: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq -65 -> 139
    //   207: ldc 177
    //   209: iconst_2
    //   210: new 179	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   217: ldc 239
    //   219: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_3
    //   223: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: areturn
    //   237: astore_3
    //   238: aload_0
    //   239: astore_2
    //   240: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq -104 -> 139
    //   246: ldc 177
    //   248: iconst_2
    //   249: new 179	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   256: ldc 239
    //   258: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_3
    //   262: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_0
    //   279: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +31 -> 313
    //   285: ldc 177
    //   287: iconst_2
    //   288: new 179	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   295: ldc 242
    //   297: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_2
    //   301: invokevirtual 243	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 4
    //   315: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   318: aload_3
    //   319: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   322: aload_0
    //   323: areturn
    //   324: astore_3
    //   325: aload_0
    //   326: astore_2
    //   327: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq -191 -> 139
    //   333: ldc 177
    //   335: iconst_2
    //   336: new 179	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   343: ldc 239
    //   345: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_3
    //   349: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   352: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: areturn
    //   363: astore_0
    //   364: aload 4
    //   366: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   369: aload_3
    //   370: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   373: aload_0
    //   374: athrow
    //   375: astore_2
    //   376: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq -6 -> 373
    //   382: ldc 177
    //   384: iconst_2
    //   385: new 179	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   392: ldc 239
    //   394: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_2
    //   398: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   401: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto -37 -> 373
    //   413: astore_2
    //   414: goto -135 -> 279
    //   417: astore_2
    //   418: goto -324 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramArrayOfByte	byte[]
    //   75	10	1	i	int
    //   65	17	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   91	25	2	localException1	Exception
    //   138	102	2	arrayOfByte1	byte[]
    //   276	25	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   326	1	2	arrayOfByte2	byte[]
    //   375	23	2	localIOException1	java.io.IOException
    //   413	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   417	1	2	localException2	Exception
    //   40	153	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   198	25	3	localIOException2	java.io.IOException
    //   237	82	3	localIOException3	java.io.IOException
    //   324	46	3	localIOException4	java.io.IOException
    //   48	317	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	66	91	java/lang/Exception
    //   66	76	91	java/lang/Exception
    //   81	88	91	java/lang/Exception
    //   141	155	91	java/lang/Exception
    //   187	196	198	java/io/IOException
    //   128	137	237	java/io/IOException
    //   50	66	276	java/lang/OutOfMemoryError
    //   66	76	276	java/lang/OutOfMemoryError
    //   81	88	276	java/lang/OutOfMemoryError
    //   141	155	276	java/lang/OutOfMemoryError
    //   313	322	324	java/io/IOException
    //   50	66	363	finally
    //   66	76	363	finally
    //   81	88	363	finally
    //   94	128	363	finally
    //   141	155	363	finally
    //   155	187	363	finally
    //   279	313	363	finally
    //   364	373	375	java/io/IOException
    //   155	187	413	java/lang/OutOfMemoryError
    //   155	187	417	java/lang/Exception
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!MessageForFile.class.isInstance(paramChatMessage)) {
              break;
            }
          } while (!FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful());
          return false;
        } while (MessageForPic.class.isInstance(paramChatMessage));
        if (!MessageForShortVideo.class.isInstance(paramChatMessage)) {
          break;
        }
      } while (((MessageForShortVideo)paramChatMessage).checkForward());
      return false;
    } while (c(paramChatMessage));
    return false;
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return (MessageForMarketFace.class.isInstance(paramChatMessage)) || (MessageForPic.class.isInstance(paramChatMessage));
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 177
    //   8: iconst_2
    //   9: new 179	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   16: ldc 253
    //   18: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: arraylength
    //   23: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 199	java/io/ByteArrayInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 202	java/io/ByteArrayInputStream:<init>	([B)V
    //   40: astore_3
    //   41: new 204	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: invokespecial 205	java/io/ByteArrayOutputStream:<init>	()V
    //   48: astore 4
    //   50: sipush 1024
    //   53: newarray byte
    //   55: astore_0
    //   56: new 255	java/util/zip/GZIPInputStream
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 258	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: astore_2
    //   65: aload_2
    //   66: aload_0
    //   67: iconst_0
    //   68: sipush 1024
    //   71: invokevirtual 259	java/util/zip/GZIPInputStream:read	([BII)I
    //   74: istore_1
    //   75: iload_1
    //   76: iconst_m1
    //   77: if_icmpeq +65 -> 142
    //   80: aload 4
    //   82: aload_0
    //   83: iconst_0
    //   84: iload_1
    //   85: invokevirtual 260	java/io/ByteArrayOutputStream:write	([BII)V
    //   88: goto -23 -> 65
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_0
    //   94: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +32 -> 129
    //   100: ldc 177
    //   102: iconst_2
    //   103: new 179	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 262
    //   113: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_2
    //   117: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload 4
    //   131: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   134: aload_3
    //   135: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   138: aload_0
    //   139: astore_2
    //   140: aload_2
    //   141: areturn
    //   142: aload_2
    //   143: invokevirtual 263	java/util/zip/GZIPInputStream:close	()V
    //   146: aload 4
    //   148: invokevirtual 235	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   151: astore_0
    //   152: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +30 -> 185
    //   158: ldc 177
    //   160: iconst_2
    //   161: new 179	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 265
    //   171: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: arraylength
    //   176: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload 4
    //   187: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   190: aload_3
    //   191: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   194: aload_0
    //   195: areturn
    //   196: astore_3
    //   197: aload_0
    //   198: astore_2
    //   199: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -62 -> 140
    //   205: ldc 177
    //   207: iconst_2
    //   208: new 179	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 267
    //   218: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_3
    //   222: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   225: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: areturn
    //   236: astore_3
    //   237: aload_0
    //   238: astore_2
    //   239: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq -102 -> 140
    //   245: ldc 177
    //   247: iconst_2
    //   248: new 179	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 267
    //   258: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_3
    //   262: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_0
    //   279: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +32 -> 314
    //   285: ldc 177
    //   287: iconst_2
    //   288: new 179	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 262
    //   298: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_2
    //   302: invokevirtual 243	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload 4
    //   316: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   319: aload_3
    //   320: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   323: aload_0
    //   324: areturn
    //   325: astore_3
    //   326: aload_0
    //   327: astore_2
    //   328: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq -191 -> 140
    //   334: ldc 177
    //   336: iconst_2
    //   337: new 179	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 267
    //   347: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_3
    //   351: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: areturn
    //   365: astore_0
    //   366: aload 4
    //   368: invokevirtual 226	java/io/ByteArrayOutputStream:close	()V
    //   371: aload_3
    //   372: invokevirtual 227	java/io/ByteArrayInputStream:close	()V
    //   375: aload_0
    //   376: athrow
    //   377: astore_2
    //   378: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq -6 -> 375
    //   384: ldc 177
    //   386: iconst_2
    //   387: new 179	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 267
    //   397: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: goto -38 -> 375
    //   416: astore_2
    //   417: goto -138 -> 279
    //   420: astore_2
    //   421: goto -327 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	paramArrayOfByte	byte[]
    //   74	11	1	i	int
    //   64	2	2	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   91	26	2	localException1	Exception
    //   139	100	2	arrayOfByte1	byte[]
    //   276	26	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   327	1	2	arrayOfByte2	byte[]
    //   377	24	2	localIOException1	java.io.IOException
    //   416	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   420	1	2	localException2	Exception
    //   40	151	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   196	26	3	localIOException2	java.io.IOException
    //   236	84	3	localIOException3	java.io.IOException
    //   325	47	3	localIOException4	java.io.IOException
    //   48	319	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	65	91	java/lang/Exception
    //   65	75	91	java/lang/Exception
    //   80	88	91	java/lang/Exception
    //   142	152	91	java/lang/Exception
    //   185	194	196	java/io/IOException
    //   129	138	236	java/io/IOException
    //   50	65	276	java/lang/OutOfMemoryError
    //   65	75	276	java/lang/OutOfMemoryError
    //   80	88	276	java/lang/OutOfMemoryError
    //   142	152	276	java/lang/OutOfMemoryError
    //   314	323	325	java/io/IOException
    //   50	65	365	finally
    //   65	75	365	finally
    //   80	88	365	finally
    //   94	129	365	finally
    //   142	152	365	finally
    //   152	185	365	finally
    //   279	314	365	finally
    //   366	375	377	java/io/IOException
    //   152	185	416	java/lang/OutOfMemoryError
    //   152	185	420	java/lang/Exception
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((StructMsgForImageShare.class.isInstance(paramChatMessage.structingMsg)) && (((StructMsgForImageShare)paramChatMessage.structingMsg).getFirstImageElement() != null)) {
        return true;
      }
    }
    return false;
  }
  
  protected MessageRecord a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "queryLastMsg,delNum:" + paramInt);
    }
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage limit 1 offset ?", new String[] { String.valueOf(paramInt - 1) });
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      return null;
    }
    return (MessageRecord)localArrayList.get(0);
  }
  
  public ArrayList a(long paramLong)
  {
    ArrayList localArrayList = (ArrayList)a().a(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[] { String.valueOf(paramLong) });
    Object localObject1;
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      localObject1 = new ArrayList();
    }
    do
    {
      return localObject1;
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        ((MessageRecord)localObject2).isMultiMsg = true;
        if (((MessageRecord)localObject2).msgtype == -1035)
        {
          localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MessageRecord)((Iterator)localObject2).next()).isMultiMsg = true;
          }
        }
      }
      localObject1 = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "querySevalMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localArrayList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localArrayList.get(0)).msgseq);
    return localArrayList;
  }
  
  public ArrayList a(MessageRecord paramMessageRecord, ArrayList paramArrayList, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)localIterator1.next();
      if (paramBoolean2)
      {
        if (localMessageRecord1.msgtype == -1037) {
          paramArrayList = (MessageForText)((MessageForLongMsg)localMessageRecord1).rebuildLongMsg();
        }
        while (paramArrayList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          }
          return null;
          if (localMessageRecord1.msgtype == -1036) {
            paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord1).rebuildLongMsg();
          } else if (localMessageRecord1.msgtype == -2011) {
            paramArrayList = new MessageForStructing(localMessageRecord1);
          } else {
            paramArrayList = (MessageRecord)localMessageRecord1.deepCopyByReflect();
          }
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramArrayList.atInfoList = null;
      }
      while (paramArrayList == null)
      {
        return null;
        paramArrayList = localMessageRecord1;
      }
      paramArrayList.createMessageUniseq();
      paramArrayList.msgseq = paramMessageRecord.uniseq;
      paramArrayList.isMultiMsg = true;
      paramArrayList.extraflag = 32770;
      if (paramArrayList.msgtype == -1035)
      {
        Iterator localIterator2 = ((MessageForMixedMsg)paramArrayList).msgElemList.iterator();
        while (localIterator2.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator2.next();
          localMessageRecord2.msgseq = paramArrayList.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (paramArrayList.msgtype == -2022) {
        ((MessageForShortVideo)paramArrayList).redBagType = 0;
      }
      localArrayList.add(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord1.toString());
      }
      if (paramBoolean1) {
        if (paramArrayList.getStatus() == 1000) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramArrayList.frienduin, paramArrayList.istroop, paramArrayList.getTableName(), paramArrayList, 0, paramProxyListener);
        } else {
          a(paramArrayList, null);
        }
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    return localArrayList;
  }
  
  public ArrayList a(byte[] paramArrayOfByte, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo)
  {
    long l4 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, start unpack, startTime:" + l4);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, data is null or data.lenght is 0");
      }
      return null;
    }
    Object localObject1 = b(paramArrayOfByte);
    if (localObject1 == null) {
      return null;
    }
    paramArrayOfByte = new ArrayList();
    Object localObject2 = new msg_transmit.PbMultiMsgTransmit();
    int i;
    Object localObject3;
    try
    {
      localObject1 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject2).mergeFrom((byte[])localObject1);
      i = 0;
      if (i >= ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.size()) {
        break label1022;
      }
      localObject3 = (msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject1).msg.get(i);
      if ((!((msg_comm.Msg)localObject3).msg_body.has()) || (!((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).rich_text.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, no msg_body or rich_text, msg_body.has():" + ((msg_comm.Msg)localObject3).msg_body.has());
        }
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", paramArrayOfByte);
      }
      return null;
    }
    Object localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get();
    long l3 = ((msg_comm.MsgHead)localObject4).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject4).msg_seq.get();
    long l6 = ((msg_comm.MsgHead)localObject4).msg_time.get();
    long l7 = ((msg_comm.MsgHead)localObject4).msg_uid.get();
    int j = ((msg_comm.MsgHead)localObject4).msg_type.get();
    MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject2 = MessageProtoCodec.a(localMessageHandler, (msg_comm.Msg)localObject3, String.valueOf(l3), String.valueOf(l3));
    long l1;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      if (l1 != -1L) {
        break label1117;
      }
    }
    label1117:
    for (long l2 = 0L;; l2 = l1)
    {
      localObject2 = new ArrayList();
      int k;
      if (((MessageUtils.c(j)) || (j == 208)) && (((msg_comm.MsgHead)localObject4).c2c_cmd.has()))
      {
        k = ((msg_comm.MsgHead)localObject4).c2c_cmd.get();
        if ((k == 175) || (k == 11)) {
          MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, true, false, paramMessageInfo);
        }
        if ((((msg_comm.MsgHead)localObject4).from_nick.has()) && (paramHashMap != null)) {
          paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).from_nick.get());
        }
        if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
          MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3);
        }
        l1 = l3;
        label506:
        k = MessageProtoCodec.a((msg_comm.Msg)localObject3);
        localObject3 = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label1001;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        ((MessageRecord)localObject4).time = l6;
        ((MessageRecord)localObject4).shmsgseq = l5;
        ((MessageRecord)localObject4).msgUid = l7;
        ((MessageRecord)localObject4).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject4).senderuin = String.valueOf(l3);
        ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
        ((MessageRecord)localObject4).vipBubbleDiyTextId = k;
        ((MessageRecord)localObject4).vipBubbleID = SVIPHandler.a((int)l2, k);
        if ((j == 82) || (j == 43))
        {
          ((MessageRecord)localObject4).istroop = 1;
          continue;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break;
          if (((j == 82) || (j == 43)) && (((msg_comm.MsgHead)localObject4).group_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            ((msg_comm.MsgHead)localObject4).group_info.group_code.get();
            MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, paramMessageInfo);
            if ((((msg_comm.MsgHead)localObject4).group_info.group_card.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).group_info.group_card.get().toStringUtf8());
            }
            if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
              MessageProtoCodec.a(localMessageHandler, (msg_comm.Msg)localObject3, (List)localObject2);
            }
            break label506;
          }
          if (((j == 83) || (j == 42)) && (((msg_comm.MsgHead)localObject4).discuss_info.has()))
          {
            l1 = ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            ((msg_comm.MsgHead)localObject4).discuss_info.discuss_uin.get();
            MessageProtoCodec.a(localMessageHandler, (List)localObject2, (msg_comm.Msg)localObject3, false, false, paramMessageInfo);
            if ((((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.has()) && (paramHashMap != null)) {
              paramHashMap.put(String.valueOf(l3), ((msg_comm.MsgHead)localObject4).discuss_info.discuss_remark.get().toStringUtf8());
            }
            if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107)) {
              MessageProtoCodec.a(localMessageHandler, (msg_comm.Msg)localObject3, (List)localObject2);
            }
            break label506;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, illegal msgType:" + j);
          }
          return null;
        }
        if ((j == 83) || (j == 42)) {
          ((MessageRecord)localObject4).istroop = 3000;
        } else {
          ((MessageRecord)localObject4).istroop = 0;
        }
      }
      label1001:
      MessageHandlerUtils.a((List)localObject2);
      paramArrayOfByte.addAll((Collection)localObject2);
      i += 1;
      break;
      label1022:
      if ((paramMessageRecord == null) && (paramArrayOfByte.size() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "unpackPbToMultiMsg end unpack, type: longText");
        }
        return paramArrayOfByte;
      }
      if (!a(paramMessageRecord, paramArrayOfByte, null)) {
        return null;
      }
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "unpackPbToMultiMsg, end unpack,endTime:" + l1 + " cost:" + (l1 - l4));
      }
      return paramArrayOfByte;
    }
  }
  
  public msg_comm.MsgHead a(MessageRecord paramMessageRecord, HashMap paramHashMap, boolean paramBoolean, int paramInt)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    localMsgHead.from_uin.set(Long.valueOf(MsgProxyUtils.c(paramMessageRecord)).longValue());
    localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
    localMsgHead.msg_time.set((int)paramMessageRecord.time);
    localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
    Object localObject = new msg_comm.MutilTransHead();
    PBUInt32Field localPBUInt32Field = ((msg_comm.MutilTransHead)localObject).status;
    int i;
    if (paramBoolean)
    {
      i = 0;
      localPBUInt32Field.set(i);
      ((msg_comm.MutilTransHead)localObject).msgId.set(paramInt);
      localMsgHead.mutiltrans_head.set((MessageMicro)localObject);
      if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022)) {
        break label283;
      }
      if (!(paramMessageRecord instanceof MessageForPtt)) {
        break label242;
      }
      localMsgHead.msg_type.set(208);
      label176:
      if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        break label255;
      }
      localMsgHead.c2c_cmd.set(11);
      label200:
      paramMessageRecord = MsgProxyUtils.c(paramMessageRecord);
      if ((paramHashMap == null) || (paramHashMap.get(paramMessageRecord) == null)) {
        break label269;
      }
      localMsgHead.from_nick.set((String)paramHashMap.get(paramMessageRecord));
    }
    for (;;)
    {
      return localMsgHead;
      i = -1;
      break;
      label242:
      localMsgHead.msg_type.set(9);
      break label176;
      label255:
      localMsgHead.c2c_cmd.set(175);
      break label200;
      label269:
      localMsgHead.from_nick.set(" ");
    }
    label283:
    if (paramMessageRecord.istroop == 3000)
    {
      localMsgHead.msg_type.set(83);
      localObject = new msg_comm.DiscussInfo();
      ((msg_comm.DiscussInfo)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if ((paramHashMap != null) && (paramHashMap.get(paramMessageRecord.senderuin) != null)) {
        ((msg_comm.DiscussInfo)localObject).discuss_remark.set(ByteStringMicro.copyFromUtf8((String)paramHashMap.get(paramMessageRecord.senderuin)));
      }
      for (;;)
      {
        localMsgHead.discuss_info.set((MessageMicro)localObject);
        break;
        ((msg_comm.DiscussInfo)localObject).discuss_remark.set(ByteStringMicro.copyFromUtf8(" "));
      }
    }
    if (paramMessageRecord.istroop == 1)
    {
      localMsgHead.msg_type.set(82);
      localObject = new msg_comm.GroupInfo();
      ((msg_comm.GroupInfo)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if ((paramHashMap != null) && (paramHashMap.get(paramMessageRecord.senderuin) != null)) {
        ((msg_comm.GroupInfo)localObject).group_card.set(ByteStringMicro.copyFromUtf8((String)paramHashMap.get(paramMessageRecord.senderuin)));
      }
      for (;;)
      {
        localMsgHead.group_info.set((MessageMicro)localObject);
        break;
        ((msg_comm.GroupInfo)localObject).group_card.set(ByteStringMicro.copyFromUtf8(" "));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
    }
    return null;
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000)) {
      localObject1 = MessageProtoCodec.a((MessageForText)paramMessageRecord);
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((im_msg_body.RichText)localObject1).elems.isEmpty()))
      {
        Object localObject3 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject3).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        paramMessageRecord = new im_msg_body.Elem();
        paramMessageRecord.elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.RichText)localObject1).elems.add(paramMessageRecord);
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set((MessageMicro)localObject1);
        do
        {
          return paramMessageRecord;
          if (paramMessageRecord.msgtype == -1049)
          {
            localObject1 = MessageProtoCodec.a((MessageForReplyText)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype != -2005) {
            break label187;
          }
          localObject3 = MessageProtoCodec.a((MessageForFile)paramMessageRecord);
          localObject1 = new im_msg_body.MsgBody();
          paramMessageRecord = (MessageRecord)localObject1;
        } while (localObject3 == null);
        ((im_msg_body.MsgBody)localObject1).rich_text.set((MessageMicro)localObject3);
        return localObject1;
        label187:
        if (paramMessageRecord.msgtype == -2052)
        {
          localObject1 = MessageProtoCodec.a((MessageForQQStoryComment)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2000)
        {
          localObject1 = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5008)
        {
          localObject1 = MessageProtoCodec.b((MessageForArkApp)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5016)
        {
          localObject1 = MessageProtoCodec.d((MessageForArkBabyqReply)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5017)
        {
          localObject1 = MessageProtoCodec.c((MessageForArkApp)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5013)
        {
          localObject1 = MessageProtoCodec.e((MessageForArkFlashChat)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5014)
        {
          localObject1 = MessageProtoCodec.f((MessageForHiBoom)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          localObject3 = MessageProtoCodec.a((MessageForStructing)paramMessageRecord);
          if (localObject3 == null) {
            return null;
          }
          Object localObject4 = (MessageForStructing)paramMessageRecord;
          localObject1 = localObject3;
          try
          {
            if (((MessageForStructing)localObject4).structingMsg == null) {
              continue;
            }
            localObject1 = localObject3;
            if (!(((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)) {
              continue;
            }
            localObject4 = ((StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg).getFirstImageElement();
            localObject1 = localObject3;
            if (localObject4 == null) {
              continue;
            }
            localObject1 = ((StructMsgItemImage)localObject4).a.richText;
            if (localObject1 == null) {
              return null;
            }
            ((im_msg_body.RichText)localObject3).elems.add(((im_msg_body.RichText)localObject1).elems.get(0));
            localObject1 = localObject3;
          }
          catch (Exception localException)
          {
            localObject2 = localObject3;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MultiMsg", 2, " packMultiMsg.structMsg.exception...");
          localObject2 = localObject3;
          continue;
        }
        if (paramMessageRecord.msgtype == -1035)
        {
          localObject2 = new im_msg_body.RichText();
          int k = ((MessageForMixedMsg)paramMessageRecord).msgElemList.size();
          int i = 0;
          while (i < k)
          {
            localObject3 = (MessageRecord)((MessageForMixedMsg)paramMessageRecord).msgElemList.get(i);
            if ((localObject3 instanceof MessageForText))
            {
              localObject3 = MessageProtoCodec.a((MessageForText)localObject3);
              if (localObject3 == null) {
                return null;
              }
              int j = 0;
              while (j < ((im_msg_body.RichText)localObject3).elems.size())
              {
                ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject3).elems.get(j));
                j += 1;
              }
            }
            if ((localObject3 instanceof MessageForRichText))
            {
              localObject3 = ((MessageForPic)localObject3).richText;
              if (localObject3 == null) {
                return null;
              }
              ((im_msg_body.RichText)localObject2).elems.add(((im_msg_body.RichText)localObject3).elems.get(0));
            }
            i += 1;
          }
          continue;
        }
        if (paramMessageRecord.msgtype == -1051)
        {
          localObject2 = MessageProtoCodec.a((MessageForLongTextMsg)paramMessageRecord, false);
          continue;
        }
        if (paramMessageRecord.msgtype == -2022)
        {
          if ((paramMessageRecord instanceof MessageForRichText)) {
            localObject2 = ((MessageForRichText)paramMessageRecord).richText;
          }
        }
        else if ((paramMessageRecord.msgtype == -2002) && ((paramMessageRecord instanceof MessageForRichText))) {
          localObject2 = ((MessageForRichText)paramMessageRecord).richText;
        }
      }
      else
      {
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  protected void a() {}
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramLong) }, 2, null);
  }
  
  public boolean a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.getStatus() == 1000) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 3, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 4, null);
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord, List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if (paramMessageRecord.senderuin.equals(localMessageRecord1.senderuin))
      {
        localMessageRecord1.issend = 1;
        localMessageRecord1.selfuin = localMessageRecord1.senderuin;
      }
      if ((localMessageRecord1 instanceof MessageForPtt)) {
        localMessageRecord1.issend = paramMessageRecord.issend;
      }
      localMessageRecord1.msgseq = paramMessageRecord.uniseq;
      localMessageRecord1.isMultiMsg = true;
      if (localMessageRecord1.msgtype == -1035)
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          localMessageRecord2.msgseq = localMessageRecord1.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localMessageRecord1.toString();
        QLog.d("MultiMsg", 2, "AddMultiMsg,time:" + localMessageRecord1.time + " senderuin:" + localMessageRecord1.senderuin + " istroop:" + localMessageRecord1.istroop + " shmsgseq:" + localMessageRecord1.shmsgseq + " msgseq:" + localMessageRecord1.msgseq + " msgData:" + localMessageRecord1.msgData);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord1.frienduin, localMessageRecord1.istroop, localMessageRecord1.getTableName(), localMessageRecord1, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    return true;
  }
  
  public boolean a(List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramProxyListener = (MessageRecord)paramList.next();
      if (paramProxyListener.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 3, null);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 4, null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    return true;
  }
  
  public byte[] a(MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbFromLongTextMsg, start pack, startTime:" + l1);
    }
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put(paramMessageRecord.senderuin, localObject1);
    localObject1 = new msg_comm.Msg();
    localObject2 = a(paramMessageRecord, (HashMap)localObject2, true, 1);
    im_msg_body.MsgBody localMsgBody = a(paramMessageRecord);
    if ((localObject2 != null) && (localMsgBody != null))
    {
      ((msg_comm.Msg)localObject1).msg_head.set((MessageMicro)localObject2);
      ((msg_comm.Msg)localObject1).msg_body.set(localMsgBody);
      localPbMultiMsgTransmit.msg.add((MessageMicro)localObject1);
    }
    for (;;)
    {
      paramMessageRecord = a(localPbMultiMsgTransmit.toByteArray());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "packPbFromLongTextMsg, end pack, endTime:" + l2 + " cost:" + (l2 - l1));
      }
      return paramMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "packPbFromLongTextMsg, error:msg_head or msg_body is null,uniseq:" + paramMessageRecord.uniseq);
      }
    }
  }
  
  public byte[] a(ArrayList paramArrayList, HashMap paramHashMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, new Object[] { "packPbToMultiMsg, start pack, startTime:", Long.valueOf(l1) });
    }
    Object localObject = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    int i = new Random(System.currentTimeMillis()).nextInt();
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = (ArrayList)localObject;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localObject = new msg_comm.Msg();
      int j = i + 1;
      msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap, paramBoolean, i);
      im_msg_body.MsgBody localMsgBody = a(localMessageRecord);
      if ((localMsgHead != null) && (localMsgBody != null))
      {
        ((msg_comm.Msg)localObject).msg_head.set(localMsgHead);
        ((msg_comm.Msg)localObject).msg_body.set(localMsgBody);
        localPbMultiMsgTransmit.msg.add((MessageMicro)localObject);
        i = j;
      }
      else
      {
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new StringBuilder("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
        }
        ((StringBuilder)localObject).append(localMessageRecord.uniseq).append("|");
        i = j;
        paramArrayList = (ArrayList)localObject;
      }
    }
    if ((paramArrayList != null) && (QLog.isColorLevel())) {
      QLog.d("MultiMsg", 2, paramArrayList.toString());
    }
    paramArrayList = a(localPbMultiMsgTransmit.toByteArray());
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "packPbToMultiMsg, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
    }
    return paramArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a();
    }
  }
  
  public void c()
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {}
    int i;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        i = localSQLiteDatabase.a("mr_multimessage");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "checkMsgCounts, count:" + i);
        }
      } while (i <= 10000);
      i = Math.max(i - 10000, 200);
      localMessageRecord = a(i);
    } while (localMessageRecord == null);
    String str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { "mr_multimessage", "mr_multimessage", Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "checkMsgCounts, delNum:" + i + "mr.msgseq:" + localMessageRecord.msgseq);
    }
    try
    {
      localSQLiteDatabase.a(str);
      label165:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgseq);
      return;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MultiMsgProxy
 * JD-Core Version:    0.7.0.1
 */