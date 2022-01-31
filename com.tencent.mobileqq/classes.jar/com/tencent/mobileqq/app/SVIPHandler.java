package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq.TDiyFontReqInfo;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq.TMd5Info;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp.TMd5Ret;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SVIPHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int = -1;
  public BubbleManager a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  
  SVIPHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)paramQQAppInterface.getManager(43));
  }
  
  public static int a(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1;
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleGetUserFont isSuccess = " + paramFromServiceMsg.isSuccess() + " data = " + StructLongMessageDownloadProcessor.a((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      paramObject = new VipFontUpdate.TFontSsoRsp();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp)paramObject.st_md5_check_rsp.get();
        if ((paramFromServiceMsg.rpt_md5_ret.has()) && (paramFromServiceMsg.rpt_md5_ret.get().size() > 0))
        {
          paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp.TMd5Ret)paramFromServiceMsg.rpt_md5_ret.get().get(0);
          int i = paramFromServiceMsg.i32_check_ret.get();
          int j = paramFromServiceMsg.i32_check_font_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleGetUserFont fontid = " + j + " md5ret = " + i);
          }
          if ((j == a()) && (i > 0)) {
            paramToServiceMsg.b(j, this.e);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("SVIPHandler", 1, "handleGetUserFont error: " + paramFromServiceMsg.getMessage());
        continue;
      }
      paramToServiceMsg.c.set(true);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "handleGetUserFont response not success message = " + paramFromServiceMsg.getResultCode());
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      do
      {
        ArrayList localArrayList;
        FriendsManager localFriendsManager;
        try
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (VipFontUpdate.TDiyFontRsp)paramToServiceMsg.st_diyfont_rsp.get();
          localArrayList = new ArrayList();
          localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          Iterator localIterator = paramToServiceMsg.rpt_font_rsp_info.get().iterator();
          while (localIterator.hasNext())
          {
            VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo localTDiyFontRspInfo = (VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo)localIterator.next();
            String str = String.valueOf(localTDiyFontRspInfo.u64_uin.get());
            paramObject = localTDiyFontRspInfo.str_diy_font_config.get();
            paramToServiceMsg = paramObject;
            if (paramObject == null) {
              paramToServiceMsg = "";
            }
            int i = localTDiyFontRspInfo.i32_font_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "handleGetDiyFontConfig uin = " + str + " fontId = " + i + " config = " + paramToServiceMsg + " seq = " + paramFromServiceMsg.getRequestSsoSeq());
            }
            paramObject = localFriendsManager.a(str);
            if (paramObject.diyFontConfigMap == null) {
              paramObject.diyFontConfigMap = new ConcurrentHashMap();
            }
            if ((!paramObject.diyFontConfigMap.containsKey(Integer.valueOf(i))) || (!paramToServiceMsg.equals(paramObject.diyFontConfigMap.get(Integer.valueOf(i)))))
            {
              paramObject.diyFontConfigMap.put(Integer.valueOf(i), paramToServiceMsg);
              ((FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).b(str, i);
              localArrayList.add(paramObject);
            }
          }
          if (localArrayList.size() <= 0) {
            continue;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.e("VasFont", 1, "handleGetDiyFontConfig error: + " + paramToServiceMsg.getMessage());
          return;
        }
        localFriendsManager.b(localArrayList);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VasFont", 2, "handleGetDiyFontConfig return empty");
      return;
    }
    QLog.e("VasFont", 1, "handleGetDiyFontConfig not success errorcode = " + paramFromServiceMsg.getResultCode() + " seq = " + paramFromServiceMsg.getRequestSsoSeq());
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/app/SVIPHandler:d	I
    //   6: iconst_m1
    //   7: if_icmpne +53 -> 60
    //   10: aload_0
    //   11: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: bipush 50
    //   16: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 195	com/tencent/mobileqq/app/FriendsManager
    //   22: aload_0
    //   23: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokevirtual 257	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull +9 -> 43
    //   37: iconst_0
    //   38: istore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: aload_0
    //   44: aload_2
    //   45: getfield 307	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   48: l2i
    //   49: putfield 25	com/tencent/mobileqq/app/SVIPHandler:d	I
    //   52: aload_0
    //   53: aload_2
    //   54: getfield 310	com/tencent/mobileqq/data/ExtensionInfo:vipFontType	I
    //   57: putfield 27	com/tencent/mobileqq/app/SVIPHandler:e	I
    //   60: aload_0
    //   61: getfield 25	com/tencent/mobileqq/app/SVIPHandler:d	I
    //   64: istore_1
    //   65: goto -26 -> 39
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SVIPHandler
    //   38	27	1	i	int
    //   32	22	2	localExtensionInfo	ExtensionInfo
    //   68	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	68	finally
    //   43	60	68	finally
    //   60	65	68	finally
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    int j = a(paramMessageRecord.vipBubbleID);
    if (j == 0) {
      return 0;
    }
    int i;
    if (paramMessageRecord.vipSubBubbleId != 0) {
      i = paramMessageRecord.vipSubBubbleId;
    }
    for (;;)
    {
      if ((i != 0) && (a(j, i)))
      {
        paramMessageRecord.vipSubBubbleId = i;
        return i;
        String str = paramMessageRecord.getExtInfoFromExtStr("bubble_sub_id");
        if (QLog.isColorLevel()) {
          QLog.i("SVIPHandler", 2, String.format("try get bubbleSubId from msg id %d : %s", new Object[] { Long.valueOf(paramMessageRecord.uniseq), str }));
        }
        if (!TextUtils.isEmpty(str)) {
          i = Integer.parseInt(str);
        }
      }
      else
      {
        paramMessageRecord.vipSubBubbleId = 0;
        return j;
      }
      i = 0;
    }
  }
  
  public int a(String paramString)
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramString, 0).getInt("svip_colorScreen_id", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "getColorScreenId " + paramString + " id " + i);
    }
    return i;
  }
  
  protected Class a()
  {
    return SVIPObserver.class;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.clear();
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (paramInt != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_id", paramInt).commit();
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setSelfFontInfo id = " + paramInt1 + " type = " + paramInt2);
      }
      if ((paramInt1 != this.d) || (paramInt2 != this.e))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        ExtensionInfo localExtensionInfo2 = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
        if (localExtensionInfo2 == null)
        {
          localExtensionInfo1 = new ExtensionInfo();
          localExtensionInfo1.uin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        }
        localExtensionInfo1.uVipFont = paramInt1;
        localExtensionInfo1.vipFontType = paramInt2;
        localFriendsManager.a(localExtensionInfo1);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 21	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_Int	I
    //   7: if_icmpeq +139 -> 146
    //   10: aload_0
    //   11: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +132 -> 146
    //   17: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 60
    //   25: iconst_2
    //   26: new 62	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 428
    //   36: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 21	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_Int	I
    //   54: aload_0
    //   55: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokevirtual 363	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: aload_0
    //   62: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: iconst_0
    //   69: invokevirtual 369	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   72: invokeinterface 400 1 0
    //   77: ldc_w 430
    //   80: iload_1
    //   81: invokeinterface 408 3 0
    //   86: invokeinterface 411 1 0
    //   91: pop
    //   92: iload_1
    //   93: ifle +53 -> 146
    //   96: new 62	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   103: aload_0
    //   104: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   110: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 432
    //   116: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: iload_2
    //   128: ifeq +26 -> 154
    //   131: new 434	zjk
    //   134: dup
    //   135: aload_0
    //   136: aload_3
    //   137: invokespecial 437	zjk:<init>	(Lcom/tencent/mobileqq/app/SVIPHandler;Ljava/lang/String;)V
    //   140: iconst_5
    //   141: aconst_null
    //   142: iconst_0
    //   143: invokestatic 443	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 413	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_Boolean	Z
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: invokestatic 448	com/tencent/mobileqq/bubble/BubbleDiyFetcher:a	()Lcom/tencent/mobileqq/bubble/BubbleDiyFetcher;
    //   157: aload_0
    //   158: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   161: aload_3
    //   162: aconst_null
    //   163: invokevirtual 451	com/tencent/mobileqq/bubble/BubbleDiyFetcher:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   166: goto -20 -> 146
    //   169: astore_3
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_3
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	SVIPHandler
    //   0	174	1	paramInt	int
    //   0	174	2	paramBoolean	boolean
    //   126	36	3	str	String
    //   169	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	169	finally
    //   49	92	169	finally
    //   96	127	169	finally
    //   131	146	169	finally
    //   146	151	169	finally
    //   154	166	169	finally
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!paramMessageRecord.needVipBubble())) {
      break label11;
    }
    label11:
    while (((AnonymousChatHelper.a(paramMessageRecord)) && (AnonymousChatHelper.b(paramMessageRecord))) || (paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) {
      return;
    }
    if (h() > 0)
    {
      paramMessageRecord.vipBubbleID = a(b(), h());
      paramMessageRecord.vipBubbleDiyTextId = h();
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        int i = i();
        if (i > 0) {
          paramMessageRecord.vipBubbleID = i;
        }
      }
      paramMessageRecord.vipSubBubbleId = f();
      if (paramMessageRecord.vipSubBubbleId == 0) {
        break;
      }
      paramMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(paramMessageRecord.vipSubBubbleId));
      c();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("SVIPHandler", 2, "addSendingBubbleId: changeSubBubbleId, messageRecord: " + paramMessageRecord.getClass().getSimpleName());
      return;
      paramMessageRecord.vipBubbleID = b();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Font.fresh".equals(paramFromServiceMsg.getServiceCmd())) {}
    switch (paramToServiceMsg.extraData.getInt("CMD"))
    {
    case 2: 
    default: 
      return;
    case 1: 
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramString, 0);
    localSharedPreferences.getInt("svip_colorScreen_id", 0);
    localSharedPreferences.edit().putInt("svip_colorScreen_id", paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "setColorScreenId " + paramString + " id " + paramInt);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "pbGetDiyFontConfig");
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(3);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("7.6.0.3525");
    localObject = new VipFontUpdate.TDiyFontReq();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      VipFontUpdate.TDiyFontReq.TDiyFontReqInfo localTDiyFontReqInfo = new VipFontUpdate.TDiyFontReq.TDiyFontReqInfo();
      localTDiyFontReqInfo.u64_uin.set(Long.parseLong(str));
      localTDiyFontReqInfo.i32_font_id.set(((Integer)paramMap.get(str)).intValue());
      ((VipFontUpdate.TDiyFontReq)localObject).rpt_font_req_info.add(localTDiyFontReqInfo);
    }
    localTFontSsoReq.st_diyfont_req.set((MessageMicro)localObject);
    paramMap = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
    paramMap.putWupBuffer(localTFontSsoReq.toByteArray());
    paramMap.extraData.putInt("CMD", 3);
    b(paramMap);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null))
    {
      BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.get(Integer.valueOf(paramInt1));
      return (localBubbleConfig != null) && (localBubbleConfig.a()) && (localBubbleConfig.a(paramInt2));
    }
    return false;
  }
  
  public int b()
  {
    try
    {
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("svip_bubble_id", 0);
      }
      int i = a(this.jdField_a_of_type_Int);
      return i;
    }
    finally {}
  }
  
  public void b()
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(1);
    Object localObject1 = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject1).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("7.6.0.3525");
    localObject1 = new VipFontUpdate.TFontFreshReq();
    ((VipFontUpdate.TFontFreshReq)localObject1).i32_local_font_id.set(a());
    localTFontSsoReq.st_fresh_req.set((MessageMicro)localObject1);
    localObject1 = new VipFontUpdate.TFontMd5CheckReq();
    VipFontUpdate.TFontMd5CheckReq.TMd5Info localTMd5Info = new VipFontUpdate.TFontMd5CheckReq.TMd5Info();
    localTMd5Info.i32_font_id.set(a());
    Object localObject2 = ((FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(a(), this.e);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = new File(((FontInfo)localObject2).a);
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
        break label358;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new FileInputStream((File)localObject3);
        localObject3 = MD5.toMD5Byte((InputStream)localObject2, ((File)localObject3).length());
        if (QLog.isColorLevel()) {
          QLog.d("SVIPHandler", 2, "fontFile MD5 = " + StructLongMessageDownloadProcessor.a((byte[])localObject3));
        }
        localTMd5Info.bytes_md5.set(ByteStringMicro.copyFrom((byte[])localObject3));
        ((FileInputStream)localObject2).close();
      }
      catch (Exception localException)
      {
        QLog.e("SVIPHandler", 1, "pbGetUserFont error" + localException.getMessage());
        continue;
      }
      ((VipFontUpdate.TFontMd5CheckReq)localObject1).rpt_md5_info.add(localTMd5Info);
      localTFontSsoReq.st_Md5_Check_req.set((MessageMicro)localObject1);
      localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
      ((ToServiceMsg)localObject1).putWupBuffer(localTFontSsoReq.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("CMD", 1);
      b((ToServiceMsg)localObject1);
      return;
      label358:
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "fontFile exists = " + ((File)localObject3).exists() + " ,isFile = " + ((File)localObject3).isFile());
      }
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (paramInt != this.c)
      {
        this.c = paramInt;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_voice_print_id", paramInt).commit();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void b(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 29	com/tencent/mobileqq/app/SVIPHandler:f	I
    //   7: if_icmpeq +101 -> 108
    //   10: aload_0
    //   11: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +94 -> 108
    //   17: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 60
    //   25: iconst_2
    //   26: new 62	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 719
    //   36: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 29	com/tencent/mobileqq/app/SVIPHandler:f	I
    //   54: iload_1
    //   55: ifle +53 -> 108
    //   58: new 62	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   72: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 432
    //   78: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_1
    //   82: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_3
    //   89: iload_2
    //   90: ifeq +26 -> 116
    //   93: new 721	zjm
    //   96: dup
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 722	zjm:<init>	(Lcom/tencent/mobileqq/app/SVIPHandler;Ljava/lang/String;)V
    //   102: iconst_5
    //   103: aconst_null
    //   104: iconst_0
    //   105: invokestatic 443	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 413	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_Boolean	Z
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: invokestatic 727	com/tencent/mobileqq/addon/DiyPendantFetcher:a	()Lcom/tencent/mobileqq/addon/DiyPendantFetcher;
    //   119: aload_0
    //   120: getfield 50	com/tencent/mobileqq/app/SVIPHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: aload_3
    //   124: aconst_null
    //   125: invokevirtual 730	com/tencent/mobileqq/addon/DiyPendantFetcher:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/BusinessObserver;)Lcom/tencent/mobileqq/addon/DiyPendantEntity;
    //   128: pop
    //   129: goto -21 -> 108
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	SVIPHandler
    //   0	137	1	paramInt	int
    //   0	137	2	paramBoolean	boolean
    //   88	36	3	str	String
    //   132	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	132	finally
    //   49	54	132	finally
    //   58	89	132	finally
    //   93	108	132	finally
    //   108	113	132	finally
    //   116	129	132	finally
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null))
      {
        BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.get(Integer.valueOf(b()));
        if ((localBubbleConfig != null) && (localBubbleConfig.a())) {
          localBubbleConfig.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setMagicFont setup = " + paramInt);
      }
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      ExtensionInfo localExtensionInfo2 = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = new ExtensionInfo();
        localExtensionInfo1.uin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      }
      if (localExtensionInfo1.magicFont != paramInt)
      {
        localExtensionInfo1.magicFont = paramInt;
        if (1 == paramInt) {
          localExtensionInfo1.fontEffect = 0;
        }
      }
      localFriendsManager.a(localExtensionInfo1);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public void d(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SVIPHandler", 2, "setFontEffect fontEffectId = " + paramInt);
        }
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        ExtensionInfo localExtensionInfo = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localExtensionInfo == null)
        {
          localExtensionInfo = new ExtensionInfo();
          localExtensionInfo.uin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          localExtensionInfo.fontEffect = -1;
          i = 1;
          if (localExtensionInfo.fontEffect != paramInt)
          {
            localExtensionInfo.fontEffect = paramInt;
            localExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
            ((FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).c();
            if (paramInt == 0) {
              break label166;
            }
            localExtensionInfo.magicFont = 0;
            break label166;
          }
          if (i != 0) {
            localFriendsManager.a(localExtensionInfo);
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      finally {}
      int i = 0;
      continue;
      label166:
      i = 1;
    }
  }
  
  public int f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null))
    {
      BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.get(Integer.valueOf(b()));
      if ((localBubbleConfig != null) && (localBubbleConfig.a()))
      {
        int i = localBubbleConfig.a();
        if (QLog.isColorLevel()) {
          QLog.i("SVIPHandler", 2, "main bubbleid: " + this.jdField_a_of_type_Int + ", subBubbleId: " + i);
        }
        return i;
      }
    }
    return 0;
  }
  
  /* Error */
  public int g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 764	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   5: getstatic 770	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:MsgLengthByBubble	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   8: invokevirtual 773	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   11: ldc_w 775
    //   14: invokevirtual 778	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_3
    //   18: iconst_0
    //   19: istore_2
    //   20: aload_3
    //   21: invokestatic 359	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: astore_3
    //   30: iload_2
    //   31: istore_1
    //   32: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq -10 -> 25
    //   38: ldc 60
    //   40: iconst_2
    //   41: aload_3
    //   42: invokevirtual 779	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   45: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iload_2
    //   49: istore_1
    //   50: goto -25 -> 25
    //   53: astore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	SVIPHandler
    //   24	26	1	i	int
    //   19	30	2	j	int
    //   17	4	3	str	String
    //   29	13	3	localNumberFormatException	java.lang.NumberFormatException
    //   53	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	29	java/lang/NumberFormatException
    //   2	18	53	finally
    //   20	25	53	finally
    //   32	48	53	finally
  }
  
  public int h()
  {
    try
    {
      if (this.jdField_b_of_type_Int == -1) {
        this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("svip_bubble_diy_text_id", 0);
      }
      int i = this.jdField_b_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public int i()
  {
    try
    {
      if (this.c == -1) {
        this.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("svip_bubble_voice_print_id", 0);
      }
      int i = this.c;
      return i;
    }
    finally {}
  }
  
  public int j()
  {
    int i = VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((i & 0x4) != 0) {
      return 3;
    }
    if ((i & 0x2) != 0) {
      return 1;
    }
    if ((i & 0x1) != 0) {
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPHandler
 * JD-Core Version:    0.7.0.1
 */