package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavRequestQueue;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;

public class MultiFavoriteHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ImageView a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public MultiFavoriteHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private int a(List<ChatMessage> paramList)
  {
    int j;
    if ((paramList == null) || (paramList.size() == 0)) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      paramList = paramList.iterator();
      i = 0;
      j = i;
    } while (!paramList.hasNext());
    if (!a((ChatMessage)paramList.next())) {
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {}
    for (;;)
    {
      return null;
      Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (int i = Integer.parseInt((String)localObject); (i == 1) || (i == 2) || (i == 3); i = -1)
      {
        localObject = new FileManagerEntity();
        ((FileManagerEntity)localObject).nSessionId = FileManagerUtil.a().longValue();
        ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
        ((FileManagerEntity)localObject).selfUin = paramQQAppInterface.getAccount();
        ((FileManagerEntity)localObject).isReaded = false;
        String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
        if (!TextUtils.isEmpty(str)) {
          ((FileManagerEntity)localObject).busId = Integer.valueOf(str).intValue();
        }
        for (;;)
        {
          ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          if (i == 1)
          {
            ((FileManagerEntity)localObject).peerType = 0;
            ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            label144:
            ((FileManagerEntity)localObject).peerNick = FileManagerUtil.a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
            ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
            ((FileManagerEntity)localObject).fileIdCrc = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
            ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              ((FileManagerEntity)localObject).fileSize = Long.parseLong(paramQQAppInterface);
            }
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
            {
              if (!((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
                break label396;
              }
              ((FileManagerEntity)localObject).nOpType = 0;
            }
            label246:
            ((FileManagerEntity)localObject).status = -1;
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
            {
              if (!((FileManagerEntity)localObject).selfUin.equals(paramQQAppInterface)) {
                break label404;
              }
              ((FileManagerEntity)localObject).bSend = false;
            }
            label284:
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
            if (!FileUtils.b(paramQQAppInterface)) {
              break label412;
            }
            ((FileManagerEntity)localObject).setFilePath(paramQQAppInterface);
            ((FileManagerEntity)localObject).setCloudType(3);
            ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
            ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
          }
          try
          {
            ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(paramQQAppInterface);
            label343:
            paramQQAppInterface = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
            try
            {
              ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(paramQQAppInterface);
              label358:
              return localObject;
              ((FileManagerEntity)localObject).busId = -1;
              continue;
              if (i == 2)
              {
                ((FileManagerEntity)localObject).peerType = 3000;
                break label144;
              }
              if (i != 3) {
                break label144;
              }
              ((FileManagerEntity)localObject).peerType = 1;
              break label144;
              label396:
              ((FileManagerEntity)localObject).nOpType = 1;
              break label246;
              label404:
              ((FileManagerEntity)localObject).bSend = true;
              break label284;
              label412:
              ((FileManagerEntity)localObject).setCloudType(1);
            }
            catch (NumberFormatException paramQQAppInterface)
            {
              break label358;
            }
          }
          catch (NumberFormatException paramQQAppInterface)
          {
            break label343;
          }
        }
      }
    }
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.g;
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramTroopFileStatusInfo.jdField_c_of_type_Long;
      localFileManagerEntity.fProgress = ((float)paramTroopFileStatusInfo.jdField_d_of_type_Long / (float)paramTroopFileStatusInfo.jdField_c_of_type_Long);
      localFileManagerEntity.nFileType = FileManagerUtil.a(paramTroopFileStatusInfo.g);
      if ((6 <= paramTroopFileStatusInfo.jdField_b_of_type_Int) && (13 != paramTroopFileStatusInfo.jdField_b_of_type_Int)) {
        break label306;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.e;
      localFileManagerEntity.strTroopFileSha1 = paramTroopFileStatusInfo.f;
      localFileManagerEntity.busId = paramTroopFileStatusInfo.h;
      localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      QLog.i("MultiFavoriteHelper", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramTroopFileStatusInfo.g + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      return localFileManagerEntity;
      if (!FileUtil.a(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
      break;
      label306:
      if (12 == paramTroopFileStatusInfo.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  /* Error */
  private com.tencent.mobileqq.persistence.Entity a(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +33 -> 42
    //   12: ldc_w 309
    //   15: iconst_2
    //   16: new 311	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 352
    //   26: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 353	java/lang/Object:toString	()Ljava/lang/String;
    //   33: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   46: invokevirtual 364	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   49: checkcast 366	com/tencent/mobileqq/persistence/Entity
    //   52: astore 5
    //   54: aload 5
    //   56: astore 4
    //   58: aload 5
    //   60: ifnull +124 -> 184
    //   63: aload_1
    //   64: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   67: invokevirtual 370	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   70: astore 6
    //   72: aload 6
    //   74: arraylength
    //   75: istore_3
    //   76: iconst_0
    //   77: istore_2
    //   78: aload 5
    //   80: astore 4
    //   82: iload_2
    //   83: iload_3
    //   84: if_icmpge +100 -> 184
    //   87: aload 6
    //   89: iload_2
    //   90: aaload
    //   91: astore 4
    //   93: aload 4
    //   95: invokevirtual 375	java/lang/reflect/Field:isAccessible	()Z
    //   98: ifne +9 -> 107
    //   101: aload 4
    //   103: iconst_1
    //   104: invokevirtual 379	java/lang/reflect/Field:setAccessible	(Z)V
    //   107: aload 4
    //   109: aload 5
    //   111: aload 4
    //   113: aload_1
    //   114: invokevirtual 383	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: invokevirtual 387	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   120: iload_2
    //   121: iconst_1
    //   122: iadd
    //   123: istore_2
    //   124: goto -46 -> 78
    //   127: astore 4
    //   129: ldc_w 389
    //   132: iconst_1
    //   133: new 311	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 391
    //   143: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 394	java/lang/Class:getName	()Ljava/lang/String;
    //   153: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 396
    //   159: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 4
    //   164: invokevirtual 399	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 4
    //   178: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   181: aconst_null
    //   182: astore 4
    //   184: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +31 -> 218
    //   190: ldc_w 309
    //   193: iconst_2
    //   194: new 311	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 404
    //   204: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 4
    //   209: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 4
    //   220: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	MultiFavoriteHelper
    //   0	221	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    //   77	47	2	i	int
    //   75	10	3	j	int
    //   56	56	4	localEntity1	com.tencent.mobileqq.persistence.Entity
    //   127	50	4	localException	Exception
    //   182	37	4	localObject	Object
    //   52	58	5	localEntity2	com.tencent.mobileqq.persistence.Entity
    //   70	18	6	arrayOfField	java.lang.reflect.Field[]
    // Exception table:
    //   from	to	target	type
    //   6	42	127	java/lang/Exception
    //   42	54	127	java/lang/Exception
    //   63	76	127	java/lang/Exception
    //   93	107	127	java/lang/Exception
    //   107	120	127	java/lang/Exception
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (paramQQAppInterface == null)) {
      paramQQAppInterface = null;
    }
    String str3;
    do
    {
      return paramQQAppInterface;
      str3 = MsgProxyUtils.a(paramChatMessage);
      String str2 = "";
      String str1 = str2;
      if (paramChatMessage.isMultiMsg)
      {
        str1 = str2;
        if (!AnonymousChatHelper.a(paramChatMessage))
        {
          str2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
          str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, paramQQAppInterface);
          }
        }
      }
      if (str1 != null)
      {
        paramQQAppInterface = str1;
        if (TextUtils.getTrimmedLength(str1) != 0) {}
      }
      else
      {
        paramQQAppInterface = MultiMsgUtil.a(paramChatMessage.senderuin);
      }
    } while (!TextUtils.isEmpty(str3));
    return str3;
  }
  
  /* Error */
  private ArrayList<ChatMessage> a(MessageForStructing paramMessageForStructing, ArrayList<ChatMessage> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 447	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 448	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload_2
    //   16: invokevirtual 449	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore 6
    //   21: aload 6
    //   23: invokeinterface 56 1 0
    //   28: ifeq +583 -> 611
    //   31: aload 6
    //   33: invokeinterface 60 1 0
    //   38: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   41: astore 7
    //   43: aload 7
    //   45: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   48: sipush -1037
    //   51: if_icmpne +225 -> 276
    //   54: aload 7
    //   56: checkcast 454	com/tencent/mobileqq/data/MessageForLongMsg
    //   59: invokevirtual 458	com/tencent/mobileqq/data/MessageForLongMsg:rebuildLongMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   62: checkcast 460	com/tencent/mobileqq/data/MessageForText
    //   65: checkcast 460	com/tencent/mobileqq/data/MessageForText
    //   68: astore_2
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: ifnonnull +182 -> 254
    //   75: aload_2
    //   76: astore_3
    //   77: aload 7
    //   79: instanceof 460
    //   82: ifeq +172 -> 254
    //   85: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +13 -> 101
    //   91: ldc_w 309
    //   94: iconst_2
    //   95: ldc_w 462
    //   98: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_0
    //   102: aload 7
    //   104: invokespecial 464	com/tencent/mobileqq/activity/aio/helper/MultiFavoriteHelper:a	(Lcom/tencent/mobileqq/persistence/Entity;)Lcom/tencent/mobileqq/persistence/Entity;
    //   107: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   110: astore_2
    //   111: aload 7
    //   113: ifnull +54 -> 167
    //   116: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +48 -> 167
    //   122: ldc_w 309
    //   125: iconst_2
    //   126: new 311	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 466
    //   136: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 7
    //   141: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   144: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 471
    //   150: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 7
    //   155: getfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   158: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_2
    //   168: ifnull +52 -> 220
    //   171: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +46 -> 220
    //   177: ldc_w 309
    //   180: iconst_2
    //   181: new 311	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 477
    //   191: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   198: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 471
    //   204: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: getfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   211: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_2
    //   221: ifnull +146 -> 367
    //   224: aload_2
    //   225: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   228: ifnull +139 -> 367
    //   231: aload_2
    //   232: getfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   235: ifnonnull +132 -> 367
    //   238: aload_2
    //   239: aload_2
    //   240: getfield 469	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   243: ldc_w 479
    //   246: invokevirtual 483	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   249: putfield 475	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   252: aload_2
    //   253: astore_3
    //   254: aload_3
    //   255: ifnonnull +170 -> 425
    //   258: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq -257 -> 4
    //   264: ldc_w 309
    //   267: iconst_2
    //   268: ldc_w 485
    //   271: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aconst_null
    //   275: areturn
    //   276: aload 7
    //   278: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   281: sipush -1036
    //   284: if_icmpne +21 -> 305
    //   287: aload 7
    //   289: checkcast 454	com/tencent/mobileqq/data/MessageForLongMsg
    //   292: invokevirtual 458	com/tencent/mobileqq/data/MessageForLongMsg:rebuildLongMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   295: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   298: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   301: astore_2
    //   302: goto -233 -> 69
    //   305: aload 7
    //   307: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   310: sipush -1035
    //   313: if_icmpne +18 -> 331
    //   316: aload 7
    //   318: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   321: invokevirtual 490	com/tencent/mobileqq/data/MessageForMixedMsg:rebuildMixedMsg	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   324: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   327: astore_2
    //   328: goto -259 -> 69
    //   331: aload 7
    //   333: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   336: sipush -2011
    //   339: if_icmpne +16 -> 355
    //   342: new 492	com/tencent/mobileqq/data/MessageForStructing
    //   345: dup
    //   346: aload 7
    //   348: invokespecial 495	com/tencent/mobileqq/data/MessageForStructing:<init>	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   351: astore_2
    //   352: goto -283 -> 69
    //   355: aload 7
    //   357: invokevirtual 499	com/tencent/mobileqq/data/ChatMessage:deepCopyByReflect	()Lcom/tencent/mobileqq/persistence/Entity;
    //   360: checkcast 62	com/tencent/mobileqq/data/ChatMessage
    //   363: astore_2
    //   364: goto -295 -> 69
    //   367: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +13 -> 383
    //   373: ldc_w 309
    //   376: iconst_2
    //   377: ldc_w 501
    //   380: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aconst_null
    //   384: astore_2
    //   385: goto -133 -> 252
    //   388: astore 4
    //   390: aload_2
    //   391: astore_3
    //   392: aload 4
    //   394: astore_2
    //   395: ldc_w 309
    //   398: iconst_2
    //   399: new 311	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 503
    //   409: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_2
    //   413: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: goto -168 -> 254
    //   425: aload_3
    //   426: ldc_w 505
    //   429: invokevirtual 83	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   432: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   435: ifne +10 -> 445
    //   438: aload_3
    //   439: ldc_w 505
    //   442: invokevirtual 508	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   445: aload_3
    //   446: ldc_w 510
    //   449: invokevirtual 83	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: ifne +10 -> 465
    //   458: aload_3
    //   459: ldc_w 510
    //   462: invokevirtual 508	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   465: aload_3
    //   466: aconst_null
    //   467: putfield 514	com/tencent/mobileqq/data/ChatMessage:atInfoList	Ljava/util/ArrayList;
    //   470: aload_3
    //   471: aload_1
    //   472: getfield 515	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   475: putfield 433	com/tencent/mobileqq/data/ChatMessage:msgseq	J
    //   478: aload_3
    //   479: ldc_w 516
    //   482: putfield 519	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   485: aload_3
    //   486: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   489: sipush -1035
    //   492: if_icmpne +54 -> 546
    //   495: aload_3
    //   496: checkcast 487	com/tencent/mobileqq/data/MessageForMixedMsg
    //   499: getfield 523	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   502: invokeinterface 50 1 0
    //   507: astore_2
    //   508: aload_2
    //   509: invokeinterface 56 1 0
    //   514: ifeq +32 -> 546
    //   517: aload_2
    //   518: invokeinterface 60 1 0
    //   523: checkcast 525	com/tencent/mobileqq/data/MessageRecord
    //   526: astore 4
    //   528: aload 4
    //   530: aload_3
    //   531: getfield 433	com/tencent/mobileqq/data/ChatMessage:msgseq	J
    //   534: putfield 526	com/tencent/mobileqq/data/MessageRecord:msgseq	J
    //   537: aload 4
    //   539: iconst_1
    //   540: putfield 527	com/tencent/mobileqq/data/MessageRecord:isMultiMsg	Z
    //   543: goto -35 -> 508
    //   546: aload_3
    //   547: getfield 452	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   550: sipush -2022
    //   553: if_icmpne +11 -> 564
    //   556: aload_3
    //   557: checkcast 529	com/tencent/mobileqq/data/MessageForShortVideo
    //   560: iconst_0
    //   561: putfield 532	com/tencent/mobileqq/data/MessageForShortVideo:redBagType	I
    //   564: aload 5
    //   566: aload_3
    //   567: invokevirtual 535	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   570: pop
    //   571: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq -553 -> 21
    //   577: ldc_w 309
    //   580: iconst_2
    //   581: new 311	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 537
    //   591: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 7
    //   596: invokevirtual 538	com/tencent/mobileqq/data/ChatMessage:toString	()Ljava/lang/String;
    //   599: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: goto -587 -> 21
    //   611: aload 5
    //   613: areturn
    //   614: astore_2
    //   615: aconst_null
    //   616: astore_3
    //   617: goto -222 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	MultiFavoriteHelper
    //   0	620	1	paramMessageForStructing	MessageForStructing
    //   0	620	2	paramArrayList	ArrayList<ChatMessage>
    //   70	547	3	localArrayList	ArrayList<ChatMessage>
    //   388	5	4	localException	Exception
    //   526	12	4	localMessageRecord	MessageRecord
    //   13	599	5	localArrayList1	ArrayList
    //   19	13	6	localIterator	Iterator
    //   41	554	7	localChatMessage	ChatMessage
    // Exception table:
    //   from	to	target	type
    //   116	167	388	java/lang/Exception
    //   171	220	388	java/lang/Exception
    //   224	252	388	java/lang/Exception
    //   367	383	614	java/lang/Exception
  }
  
  private void a(ChatAdapter1 paramChatAdapter1, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (paramChatAdapter1 == null)) {}
    for (;;)
    {
      return;
      ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
      if (QLog.isColorLevel()) {
        QLog.d("MultiFavoriteHelper", 2, "favorSingleMsg");
      }
      QfavRequestQueue.a().a = false;
      paramChatAdapter1.a.a(paramChatMessage, paramChatAdapter1).a(2131366625, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      if (QfavRequestQueue.a().a) {
        QfavRequestQueue.a().a = false;
      }
      while (AIOSelectableDelegateImpl.a().c())
      {
        AIOSelectableDelegateImpl.a().d();
        return;
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new MultiFavoriteHelper.1(this));
      }
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, MessageForTroopFile paramMessageForTroopFile)
  {
    if ((paramFileManagerEntity == null) || (paramMessageForTroopFile == null)) {}
    do
    {
      do
      {
        return;
        if ((paramFileManagerEntity.fileSize == 0L) && (paramMessageForTroopFile.fileSize > 0L))
        {
          paramFileManagerEntity.fileSize = paramMessageForTroopFile.fileSize;
          if (QLog.isColorLevel()) {
            QLog.d("qqfav", 2, "checkPatchEntity, patch size:" + paramFileManagerEntity.fileSize);
          }
        }
      } while ((!TextUtils.isEmpty(paramFileManagerEntity.fileName)) || (TextUtils.isEmpty(paramMessageForTroopFile.fileName)));
      paramFileManagerEntity.fileName = paramMessageForTroopFile.fileName;
    } while (!QLog.isColorLevel());
    QLog.d("qqfav", 2, "checkPatchEntity, patch name:" + paramFileManagerEntity.fileName);
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    do
    {
      return;
      ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, 4);
      MultiMsgManager.a().b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(2131698459);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList);
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    MultiMsgManager.a().jdField_a_of_type_Int = 6;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof MultiForwardChatPie)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = MultiMsgManager.a().a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, false, null);
    }
    for (;;)
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
      Message localMessage = paramList.obtainMessage(24);
      localMessage.arg1 = localArrayList.size();
      paramList.sendMessageDelayed(localMessage, 30000L);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(localArrayList);
      }
    }
  }
  
  private void a(List<ChatMessage> paramList, List<String> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = MsgProxyUtils.a((ChatMessage)paramList.next());
        if (!paramList1.contains(str)) {
          paramList1.add(str);
        }
      }
    }
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage));
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break;
        }
      } while (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 35);
      return true;
    } while (((paramChatMessage instanceof MessageForArkApp)) || (((paramChatMessage instanceof MessageForPic)) && (ZhituManager.a((MessageForPic)paramChatMessage))));
    if ((paramChatMessage instanceof MessageForDLFile))
    {
      int i = ((MessageForDLFile)paramChatMessage).deviceType;
      long l = ((MessageForDLFile)paramChatMessage).associatedId;
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l);
      if ((paramChatMessage != null) && (FileUtils.b(paramChatMessage.path))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  private boolean a(List<ChatMessage> paramList, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramList == null) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramList.size() > paramInt);
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (QfavUtil.a(localChatMessage)) {
          i = ((MessageForStructing)localChatMessage).structingMsg.mTSum + i;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      }
      bool1 = bool2;
    } while (i > paramInt);
    return true;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onActivityResult");
    }
    if (paramIntent != null)
    {
      long l = paramIntent.getExtras().getLong("requestId", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiFavoriteHelper", 2, "onActivityResult, id:" + l);
      }
      QfavRequestQueue.a().a(l);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364686);
        if (AppSetting.d) {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707011));
        }
      }
      paramBaseChatPie = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      paramBaseChatPie.setMargins(paramInt3, 0, 0, 0);
      paramBaseChatPie.gravity = 16;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatPie);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatPie = new StateListDrawable();
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839502);
      paramBaseChatPie.addState(new int[] { 16842919 }, localDrawable);
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839501);
      paramBaseChatPie.addState(new int[] { 16842910 }, localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBaseChatPie);
    } while (paramLinearLayout == null);
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void a(BaseChatPie paramBaseChatPie, ChatAdapter1 paramChatAdapter1, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "onClickMultiFavoriteBtn");
    }
    int i = MultiMsgManager.a().c();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C5B", "0X8009C5B", 0, i, "", "", "", "");
    if (paramMessageForStructing == null)
    {
      paramMessageForStructing = MultiMsgManager.a().a();
      if (paramMessageForStructing.size() == 1)
      {
        localArrayList = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramMessageForStructing);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramMessageForStructing = (ChatMessage)localArrayList.get(0);
          a(paramChatAdapter1, paramMessageForStructing);
          paramBaseChatPie.a(false, null, false);
        }
      }
    }
    while (!QfavUtil.a(paramMessageForStructing))
    {
      for (;;)
      {
        ArrayList localArrayList;
        return;
        paramMessageForStructing = (ChatMessage)paramMessageForStructing.get(0);
      }
      if (paramMessageForStructing.size() != 0) {
        break label424;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698457, 0).b(paramBaseChatPie.a());
      return;
    }
    paramChatAdapter1 = new ArrayList();
    paramChatAdapter1.add(paramMessageForStructing);
    for (;;)
    {
      QfavRequestQueue.a().a = true;
      if (!a(paramChatAdapter1, MultiMsgManager.a().a()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131693929, 0).b(paramBaseChatPie.a());
        return;
      }
      i = a(paramChatAdapter1);
      paramMessageForStructing = paramChatAdapter1;
      if (i > 0)
      {
        if (paramChatAdapter1.size() == i)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694365, 0).b(paramBaseChatPie.a());
          paramBaseChatPie.a(false, null, false);
          return;
        }
        paramMessageForStructing = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        if (!QfavUtil.a(paramMessageForStructing))
        {
          QfavUtil.b(paramMessageForStructing);
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131693316), this.jdField_a_of_type_AndroidContentContext.getString(2131694366), new MultiFavoriteHelper.4(this, paramChatAdapter1, paramBaseChatPie));
          return;
        }
        paramChatAdapter1 = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramChatAdapter1);
        if (paramChatAdapter1 != null)
        {
          paramMessageForStructing = paramChatAdapter1;
          if (paramChatAdapter1.size() != 0) {}
        }
        else
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694365, 0).b(paramBaseChatPie.a());
          paramBaseChatPie.a(false, null, false);
          return;
        }
      }
      a(paramMessageForStructing);
      paramBaseChatPie.a(false, null, false);
      return;
      label424:
      paramChatAdapter1 = paramMessageForStructing;
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    try
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, paramString1, "", paramString2, new MultiFavoriteHelper.5(this, paramOnClickListener), null).show();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramInt != 6) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiFavoriteHelper", 2, "favorMultiMsg");
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() == 1) && (QfavUtil.a((ChatMessage)paramArrayList.get(0))))
      {
        localObject1 = (MessageForStructing)paramArrayList.get(0);
        localObject2 = null;
        label88:
        paramArrayList = QfavBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject1, (List)localObject2, paramMap);
        if (paramArrayList == null) {
          break label413;
        }
        if (-1L >= 0L) {
          paramArrayList.a(-1L);
        }
        paramArrayList.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1);
        paramMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        bool = paramArrayList.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramMap, 18000, null);
        if (bool) {
          break label400;
        }
        QfavRequestQueue.a().a(-1L);
        paramArrayList = paramArrayList.a();
        if (paramArrayList == null) {
          break;
        }
        paramArrayList = this.jdField_a_of_type_AndroidContentContext.getString(paramArrayList.getIntExtra("nReasonInt", 2131692260));
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new MultiFavoriteHelper.3(this, paramMap, bool, paramArrayList));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
          break label424;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        continue;
      }
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt != 1) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ChatActivityFacade.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
        if (localObject1 == null) {
          break;
        }
        MessageForStructing localMessageForStructing = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, (AbsStructMsg)localObject1);
        ArrayList localArrayList = a(localMessageForStructing, paramArrayList);
        localObject2 = localArrayList;
        localObject1 = localMessageForStructing;
        if (localArrayList != null) {
          break label88;
        }
        localObject2 = localArrayList;
        localObject1 = localMessageForStructing;
        if (paramArrayList == null) {
          break label88;
        }
        localObject2 = localArrayList;
        localObject1 = localMessageForStructing;
        if (paramArrayList.size() <= 0) {
          break label88;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new MultiFavoriteHelper.2(this));
        return;
      }
      label400:
      QfavHelper.a(this.jdField_a_of_type_AndroidContentContext, paramMap, bool, null, false);
      return;
      label413:
      QLog.e("MultiFavoriteHelper", 2, "builder == null");
      return;
      label424:
      localObject1 = " ";
    }
  }
  
  public String getTag()
  {
    return "MultiFavoriteHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14 };
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(11)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, null);
    }
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper
 * JD-Core Version:    0.7.0.1
 */