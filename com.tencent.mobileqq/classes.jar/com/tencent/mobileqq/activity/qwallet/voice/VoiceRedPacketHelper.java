package com.tencent.mobileqq.activity.qwallet.voice;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;
import xhw;
import xhx;
import xia;
import xib;

public class VoiceRedPacketHelper
  implements QQRecorder.OnQQRecorderListener, QQRecorder.RecorderProcessorListener
{
  private static VoiceRedPacketHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper;
  public int a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  public WeakReference a;
  public HashMap a;
  boolean jdField_a_of_type_Boolean;
  public byte[] a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  
  private VoiceRedPacketHelper()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(MessageForPtt paramMessageForPtt)
  {
    int j = 0;
    int i = j;
    if (paramMessageForPtt != null)
    {
      i = j;
      if (paramMessageForPtt.voiceRedPacketFlag != 0) {
        i = 1;
      }
    }
    return i;
  }
  
  private VoiceRedPacketHelper.RecogResult a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    VoiceRedPacketHelper.RecogResult localRecogResult = new VoiceRedPacketHelper.RecogResult();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return localRecogResult;
    }
    VoiceRecognizer.a().a();
    if (VoiceRecognizer.a().a(paramArrayOfByte, paramArrayOfByte.length) == 1) {}
    for (;;)
    {
      localRecogResult.jdField_a_of_type_Boolean = bool;
      localRecogResult.jdField_a_of_type_Float = VoiceRecognizer.a().a();
      localRecogResult.jdField_a_of_type_JavaLangString = a(localRecogResult.jdField_a_of_type_Float);
      VoiceRecognizer.a().b();
      this.jdField_b_of_type_Int += 1;
      return localRecogResult;
      bool = false;
    }
  }
  
  private VoiceRedPacketHelper.RecogResult a(byte[] paramArrayOfByte, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    long l1 = System.currentTimeMillis();
    paramArrayOfByte = a(paramArrayOfByte);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "checkInPhone:" + paramArrayOfByte);
    }
    if (paramArrayOfByte.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      a(i, l2 - l1, 0, paramMessageForQQWalletMsg, paramArrayOfByte.jdField_a_of_type_Float);
      return paramArrayOfByte;
    }
  }
  
  public static VoiceRedPacketHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper = new VoiceRedPacketHelper();
      }
      VoiceRedPacketHelper localVoiceRedPacketHelper = jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper;
      return localVoiceRedPacketHelper;
    }
    finally {}
  }
  
  public static ByteStringMicro a(MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageForPtt != null) {}
    try
    {
      paramMessageForPtt = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessageForPtt)) {
        localObject1 = ByteStringMicro.copyFromUtf8(paramMessageForPtt);
      }
      return localObject1;
    }
    catch (Throwable paramMessageForPtt)
    {
      paramMessageForPtt.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    a(paramInt1, paramLong, paramInt2, paramMessageForQQWalletMsg, 0.0F);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg, float paramFloat)
  {
    if (paramMessageForQQWalletMsg == null) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramInt1);
    localStringBuilder1.append("|").append(paramLong);
    localStringBuilder1.append("|").append(paramInt2);
    localStringBuilder1.append("|").append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
    QQAppInterface localQQAppInterface = QWalletTools.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("|");
    if (localQQAppInterface == null) {
      paramInt1 = 0;
    }
    for (;;)
    {
      localStringBuilder2.append(paramInt1);
      localStringBuilder1.append("|").append(paramMessageForQQWalletMsg.istroop);
      localStringBuilder1.append("|").append(paramFloat);
      VACDReportUtil.a(localStringBuilder1.toString(), "QWalletStat", "voiceRedPackMatch", null, null, 0, null);
      return;
      if (VoiceRecognizer.a().a(localQQAppInterface)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    VoiceRedPacketHelper.OnVoiceRedPacketListener localOnVoiceRedPacketListener = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localOnVoiceRedPacketListener != null) && (!localOnVoiceRedPacketListener.e())) {
      localOnVoiceRedPacketListener.a(paramInt, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, paramString);
    }
  }
  
  public static void a(String paramString, MessageForPtt paramMessageForPtt, BaseUploadProcessor paramBaseUploadProcessor)
  {
    a(paramString, paramMessageForPtt);
    if (paramBaseUploadProcessor != null)
    {
      if (!(paramBaseUploadProcessor instanceof C2CPttUploadProcessor)) {
        break label38;
      }
      paramString = ((C2CPttUploadProcessor)paramBaseUploadProcessor).a();
      if ((paramString != null) && (paramMessageForPtt != null)) {
        paramMessageForPtt.richText = paramString;
      }
    }
    label38:
    do
    {
      do
      {
        return;
      } while (!(paramBaseUploadProcessor instanceof GroupPicUploadProcessor));
      paramString = ((GroupPicUploadProcessor)paramBaseUploadProcessor).a(paramMessageForPtt);
    } while ((paramString == null) || (paramMessageForPtt == null));
    paramMessageForPtt.richText = paramString;
  }
  
  public static void a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("voice_score_id", paramString);
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        bool1 = bool2;
        if (paramMessageRecord.voiceRedPacketFlag != 0)
        {
          bool1 = bool2;
          if (!paramMessageRecord.isResend) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "isNeedInterceptSend:" + bool1);
    }
    return bool1;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  private void c(String paramString)
  {
    a(2, paramString);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderStart() is called");
    }
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onBeginReceiveData() is called");
    }
    paramString = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null) {
      return paramString.a();
    }
    return 0;
  }
  
  public String a(float paramFloat)
  {
    int k = (int)(100.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cfdToScoreId:" + paramFloat + "|" + k);
    }
    Object localObject1 = QWalletTools.a();
    if (localObject1 != null)
    {
      localObject1 = (QWalletConfigManager)((QQAppInterface)localObject1).getManager(244);
      if (localObject1 != null)
      {
        localObject1 = ((QWalletConfigManager)localObject1).a("voice_pwd", new String[] { "scoreIdMap" });
        if (localObject1 == null) {}
      }
    }
    int i;
    int j;
    label313:
    label361:
    do
    {
      try
      {
        if (((JSONObject)localObject1).length() > 0)
        {
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (localIterator != null) {
            for (;;)
            {
              if (localIterator.hasNext())
              {
                String str2 = (String)localIterator.next();
                String str1 = ((JSONObject)localObject1).getString(str2);
                if (!str2.contains("-")) {
                  continue;
                }
                Object localObject2 = str2.split("-");
                if ((localObject2 == null) || (localObject2.length <= 0) || (localObject2.length > 2)) {
                  continue;
                }
                boolean bool = TextUtils.isEmpty(str1);
                if (bool) {
                  continue;
                }
                i = -2147483648;
                j = 2147483647;
                try
                {
                  if (localObject2.length == 1)
                  {
                    i = Integer.parseInt(localObject2[0].trim());
                    break label361;
                  }
                  if (localObject2.length == 2)
                  {
                    str2 = localObject2[0].trim();
                    localObject2 = localObject2[1].trim();
                    if (TextUtils.isEmpty(str2)) {}
                    for (;;)
                    {
                      j = Integer.parseInt((String)localObject2);
                      break;
                      i = Integer.parseInt(str2);
                    }
                  }
                }
                catch (Throwable localThrowable2)
                {
                  localThrowable2.printStackTrace();
                }
              }
            }
          }
        }
        if (k >= 65) {
          break label313;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      return "c";
      if (k < 70) {
        return "b";
      }
      if (k < 75) {
        return "a";
      }
      if (k < 80) {
        return "s";
      }
      if (k < 90) {
        return "ss";
      }
      return "sss";
    } while ((k < i) || (k > j));
    return localThrowable2;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderVolumeStateChanged() is called");
    }
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    String str;
    QQRecorder.RecorderParam localRecorderParam;
    BaseApplication localBaseApplication;
    try
    {
      localQQAppInterface = QWalletTools.a();
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
      }
      if ((localQQAppInterface == null) || (paramSessionInfo == null)) {
        return;
      }
      if (TextUtils.isEmpty(str)) {
        return;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      localRecorderParam = new QQRecorder.RecorderParam(RecordParams.jdField_b_of_type_Int, 16000, 1);
      localBaseApplication = BaseApplication.getContext();
      if (!FileUtils.a())
      {
        b(2131433437);
        b("no sdcard");
        return;
      }
    }
    catch (Exception paramSessionInfo)
    {
      b(paramSessionInfo.toString());
      paramSessionInfo.printStackTrace();
      return;
    }
    if (!QQRecorder.d())
    {
      b(2131433438);
      b("sdcard full");
      return;
    }
    if (!QQRecorder.a(localRecorderParam.jdField_c_of_type_Int))
    {
      b(2131433441);
      b("internal storage full");
      return;
    }
    if (localQQAppInterface.c())
    {
      b(2131433788);
      b("ppt play error on video chatting");
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (!VoiceRecognizer.a().a(localQQAppInterface)) {
      this.jdField_c_of_type_Boolean = false;
    }
    if (!VoiceRecognizer.a().a(b(str))) {
      this.jdField_c_of_type_Boolean = false;
    }
    boolean bool2 = true;
    long l1 = QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    boolean bool1 = bool2;
    if (l1 != 0L)
    {
      bool1 = bool2;
      if (l1 > l2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "startRecord() is checkInPhone:" + paramBoolean + ",isInitSuccess:" + this.jdField_c_of_type_Boolean + ",isServerAvailable:" + bool1);
    }
    if ((!this.jdField_c_of_type_Boolean) && (!bool1)) {
      a(2, QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", BaseApplicationImpl.getContext().getResources().getString(2131432341)));
    }
    if (paramBoolean)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      paramString = BuddyTransfileProcessor.a(localQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
      str = MessageForPtt.getLocalFilePath(localRecorderParam.jdField_c_of_type_Int, paramString);
      if ((paramString == null) || (paramString.equals(str))) {
        break label588;
      }
      new File(paramString).deleteOnExit();
      paramString = str;
    }
    label582:
    label588:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(localBaseApplication);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(localRecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramString, true);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ChatActivityFacade.a(localQQAppInterface, paramString, paramSessionInfo, -2, localRecorderParam.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null)
      {
        paramSessionInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
        if (!this.jdField_a_of_type_Boolean) {
          break label582;
        }
      }
      for (int i = 1;; i = 2)
      {
        paramSessionInfo.voiceRedPacketFlag = i;
        this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, paramMessageForQQWalletMsg);
        this.jdField_b_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VoiceRedPacketHelper", 2, "startRecord() is called");
        return;
        if (bool1) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
      }
    }
  }
  
  public void a(VoiceRedPacketHelper.OnVoiceRedPacketListener paramOnVoiceRedPacketListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnVoiceRedPacketListener);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, long paramLong, byte[] paramArrayOfByte, String paramString, BaseUploadProcessor paramBaseUploadProcessor)
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    try
    {
      localQQAppInterface = QWalletTools.a();
      localObject = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      i = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      if ((localQQAppInterface == null) || (paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForPtt)) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (localObject == null) || (((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject).e()) || (this.jdField_b_of_type_Boolean) || (i != this.jdField_a_of_type_Int)) {
        return;
      }
      paramMessageRecord = (MessageForPtt)paramMessageRecord;
      i = paramMessageRecord.voiceRedPacketFlag;
      if (i == 1)
      {
        paramArrayOfByte = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.e())) {
          paramArrayOfByte.a(true, paramMessageRecord.getExtInfoFromExtStr("voice_score_id"));
        }
        localQQAppInterface.a().a(paramMessageRecord, paramMessageObserver);
        return;
      }
      if (i != 2) {
        return;
      }
      localObject = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord);
      if ((localObject == null) || (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg == null))
      {
        b("MessageForQQWalletMsg is null");
        return;
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      b(paramMessageRecord.toString());
      return;
    }
    int i = 0;
    if (((MessageForQQWalletMsg)localObject).istroop == 1) {
      i = 1;
    }
    for (;;)
    {
      a(new xhx(this, localQQAppInterface, (MessageForQQWalletMsg)localObject, i, paramLong, paramArrayOfByte, paramString, paramMessageRecord, paramBaseUploadProcessor, paramMessageObserver));
      return;
      int j = ((MessageForQQWalletMsg)localObject).istroop;
      if (j == 3000) {
        i = 2;
      }
    }
  }
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderNotReady() is called");
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderPrepare() is called");
    }
    AudioUtil.b(2131230744, false);
    paramRecorderParam = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderEnd() is called");
    }
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        PttBuffer.a(paramString);
        return;
      }
      PttBuffer.b(paramString);
      if (paramDouble < 500.0D)
      {
        b(2131433786);
        b("record time too short");
        return;
      }
    }
    catch (Exception paramString)
    {
      b(paramString.toString());
      paramString.printStackTrace();
      return;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.flush();
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      boolean bool = false;
      Object localObject;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
          break label447;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          break label427;
        }
        break label447;
        localObject = a(this.jdField_a_of_type_ArrayOfByte, (MessageForQQWalletMsg)localObject);
        bool = ((VoiceRedPacketHelper.RecogResult)localObject).jdField_a_of_type_Boolean;
        if (bool) {
          a(((VoiceRedPacketHelper.RecogResult)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
        }
        localObject = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject == null) || (((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject).e()) || (bool)) {
          break label453;
        }
        ((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject).a(false, "");
        break label453;
      }
      label427:
      label447:
      label453:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "isCheckInPhone:" + this.jdField_a_of_type_Boolean + ",isRecognizedInPhone:" + bool);
        }
        if ((bool) || (!this.jdField_a_of_type_Boolean))
        {
          localObject = QWalletTools.a();
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceRedPacketFlag = i;
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.serial();
            Bundle localBundle = new Bundle();
            localBundle.putInt("DiyTextId", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.vipBubbleDiyTextId);
            ChatActivityFacade.a((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq, false, (int)paramDouble, paramRecorderParam.jdField_c_of_type_Int, true, 0, 5, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.vipSubBubbleId, localBundle, null, null, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
            paramString = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramString != null)
            {
              this.jdField_a_of_type_Int = paramString.hashCode();
              return;
              localObject = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
              break;
            }
          }
        }
        return;
        localObject = null;
        break;
      }
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    b("onRecorderError");
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
    paramString = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString != null) && (!paramString.e())) {
      paramString.a(AudioPanel.a(paramInt2));
    }
  }
  
  public void a(xib paramxib)
  {
    Object localObject = QWalletTools.a();
    if ((localObject == null) || (paramxib == null)) {}
    do
    {
      return;
      localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).GetSkey(((QQAppInterface)localObject).getCurrentAccountUin(), 16L, new xia(this, paramxib));
    } while ((localObject == null) || (((Ticket)localObject)._sig == null) || (((Ticket)localObject)._sig.length == 0));
    paramxib.a(new String(((Ticket)localObject)._sig));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "stopRecord() is called");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
  }
  
  public void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localQQAppInterface.runOnUiThread(new xhw(this, localBaseApplication, paramInt, localBaseApplication.getResources().getDimensionPixelSize(2131558448)));
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if (((paramIPttProcessor instanceof WechatNsWrapper)) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null) && (paramProcessData != null) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramProcessData.jdField_a_of_type_ArrayOfByte, 0, paramProcessData.jdField_a_of_type_Int);
    }
  }
  
  public void b(String paramString)
  {
    a(1, paramString);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(3, "onRecorderAbnormal");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cancelRecord() is called");
    }
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(3, "onInitFailed");
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper
 * JD-Core Version:    0.7.0.1
 */