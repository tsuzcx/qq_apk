package com.tencent.mobileqq.activity.qwallet.voice;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.ui.funchat.record.AudioFileDecoder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.qwallet.ViewHolderFactory;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;

public class VoiceRedPacketHelper
  implements QQRecorder.OnQQRecorderListener, QQRecorder.RecorderProcessorListener
{
  private static VoiceRedPacketHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper;
  int jdField_a_of_type_Int;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString = "";
  public WeakReference<VoiceRedPacketHelper.OnVoiceRedPacketListener> a;
  HashMap<MessageForPtt, MessageForQQWalletMsg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map<MessageForPtt, VoiceRedPacketHelper.RecordMsgInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = -1;
  boolean jdField_d_of_type_Boolean;
  
  private VoiceRedPacketHelper()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  }
  
  public static int a(MessageForPtt paramMessageForPtt)
  {
    int i = 1;
    if (paramMessageForPtt != null)
    {
      switch (paramMessageForPtt.voiceRedPacketFlag)
      {
      default: 
        i = 0;
      case 1: 
      case 2: 
        return i;
      }
      return 3;
    }
    return 0;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    try
    {
      int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("ksong_redpacket_voice_type"));
      return i;
    }
    catch (Throwable paramMessageRecord) {}
    return 0;
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
  
  public static String a(MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("ksong_feeds_id");
    }
    return str;
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
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_redpacket_voice_type", paramInt + "");
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    VoiceRedPacketHelper.OnVoiceRedPacketListener localOnVoiceRedPacketListener = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localOnVoiceRedPacketListener != null) && (!localOnVoiceRedPacketListener.c())) {
      localOnVoiceRedPacketListener.a(paramInt, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "uploadKSongMixRecord is call");
    }
    paramMessageRecord = (MessageForPtt)paramMessageRecord;
    try
    {
      MessageForPtt localMessageForPtt = ChatActivityFacade.a(QWalletTools.a(), paramMessageRecord.getLocalFilePath(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramMessageRecord.voiceType);
      if (localMessageForPtt != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localMessageForPtt, new VoiceRedPacketHelper.RecordMsgInfo(paramMessageRecord, paramLong, paramArrayOfByte, paramString));
        paramArrayOfByte = new RecordParams.RecorderParam(RecordParams.jdField_b_of_type_Int, 16000, 1);
        if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, paramMessageRecord.getLocalFilePath(), paramArrayOfByte))
        {
          paramString = QWalletTools.a();
          if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (localMessageForPtt != null))
          {
            a(2, localMessageForPtt);
            localMessageForPtt.voiceRedPacketFlag = 3;
            localMessageForPtt.serial();
            Bundle localBundle = new Bundle();
            localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
            ChatActivityFacade.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.getLocalFilePath(), localMessageForPtt.uniseq, false, paramMessageRecord.voiceLength, paramArrayOfByte.jdField_c_of_type_Int, true, 0, 5, true, localMessageForPtt.vipSubBubbleId, localBundle, null, null, false, localMessageForPtt, 0);
            paramArrayOfByte = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramArrayOfByte != null) {
              this.jdField_a_of_type_Int = paramArrayOfByte.hashCode();
            }
            paramArrayOfByte = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord);
            this.jdField_a_of_type_JavaUtilHashMap.put(localMessageForPtt, paramArrayOfByte);
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageRecord);
          }
        }
        else
        {
          b("Mix song error!");
          return;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public static void a(String paramString, MessageForPtt paramMessageForPtt, BaseUploadProcessor paramBaseUploadProcessor)
  {
    b(paramString, paramMessageForPtt);
    if (paramBaseUploadProcessor != null)
    {
      if (!(paramBaseUploadProcessor instanceof C2CPttUploadProcessor)) {
        break label38;
      }
      paramString = ((C2CPttUploadProcessor)paramBaseUploadProcessor).getNewestPTTRichText();
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
      } while (!(paramBaseUploadProcessor instanceof GroupPttUploadProcessor));
      paramString = ((GroupPttUploadProcessor)paramBaseUploadProcessor).getNewestPTTRichText(paramMessageForPtt);
    } while ((paramString == null) || (paramMessageForPtt == null));
    paramMessageForPtt.richText = paramString;
  }
  
  public static void a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_feeds_id", paramString);
    }
  }
  
  public static boolean a(MessageForPtt paramMessageForPtt)
  {
    return (paramMessageForPtt.voiceRedPacketFlag == 1) || (paramMessageForPtt.voiceRedPacketFlag == 2) || (paramMessageForPtt.voiceRedPacketFlag == 3);
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
  
  private boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, RecordParams.RecorderParam paramRecorderParam)
  {
    long l;
    int i;
    int j;
    int k;
    label453:
    for (;;)
    {
      try
      {
        String str = paramString1 + "m";
        Object localObject = new File(str);
        AudioFileDecoder localAudioFileDecoder;
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "begin convert mp3 to pcm");
          }
          localAudioFileDecoder = new AudioFileDecoder(paramRecorderParam.jdField_a_of_type_Int, 16, 1);
          localAudioFileDecoder.a(new VoiceRedPacketHelper.2(this));
          l = System.currentTimeMillis();
        }
        try
        {
          localAudioFileDecoder.a(paramString1, str);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "mp3 to pcm time:" + (System.currentTimeMillis() - l));
          }
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "begin mix pcm :" + ((File)localObject).exists());
          }
          if (!((File)localObject).exists()) {
            break;
          }
          localObject = FileUtils.a((File)localObject);
          i = Math.min(paramArrayOfByte.length, localObject.length);
          paramString1 = new byte[i];
          l = System.currentTimeMillis();
          QWalletTools.a(paramString1, paramArrayOfByte, (byte[])localObject, i);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "mix pcm time:" + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          paramArrayOfByte = new AudioCompositeProcessor();
          localObject = new WechatNsWrapper(BaseApplicationImpl.getContext());
          if (WechatNsWrapper.jdField_a_of_type_Boolean) {
            paramArrayOfByte.a((IAudioProcessor)localObject);
          }
          paramArrayOfByte.a((IAudioProcessor)localObject);
          paramArrayOfByte.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.jdField_b_of_type_Int, paramRecorderParam.jdField_c_of_type_Int);
          PttBuffer.a(paramString2);
          paramRecorderParam = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
          PttBuffer.a(paramString2, paramRecorderParam, paramRecorderParam.length);
          i = paramString1.length;
          paramRecorderParam = new byte[800];
          j = 0;
          break label511;
          i -= k;
          System.arraycopy(paramString1, j, paramRecorderParam, 0, k);
          localObject = paramArrayOfByte.a(paramRecorderParam, 0, k);
          if (localObject == null) {
            break label531;
          }
          PttBuffer.a(paramString2, ((IAudioProcessor.ProcessData)localObject).jdField_a_of_type_ArrayOfByte, ((IAudioProcessor.ProcessData)localObject).jdField_a_of_type_Int);
        }
        catch (Throwable paramString1)
        {
          QLog.e("VoiceRedPacketHelper", 1, "convertMp3ToPcm decode exception:" + paramString1, paramString1);
          continue;
        }
        k = 800;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
    label531:
    label539:
    for (;;)
    {
      PttBuffer.b(paramString2);
      paramArrayOfByte.a();
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "pcm 2 silk time:" + (System.currentTimeMillis() - l));
      }
      return true;
      return false;
      for (;;)
      {
        label511:
        if (i <= 0) {
          break label539;
        }
        if (i >= 800) {
          break label453;
        }
        k = i;
        break;
        j = k + j;
      }
    }
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("voice_score_id");
    }
    return str;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  public static void b(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("voice_score_id", paramString);
    }
  }
  
  private void c(String paramString)
  {
    a(2, paramString);
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
      localObject1 = (QWalletConfigManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
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
      QLog.d("VoiceRedPacketHelper", 2, "stopRecord() is called");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
  }
  
  public void a(int paramInt)
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localQQAppInterface.runOnUiThread(new VoiceRedPacketHelper.1(this, localBaseApplication, paramInt, localBaseApplication.getResources().getDimensionPixelSize(2131299166)));
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    int i;
    String str1;
    RecordParams.RecorderParam localRecorderParam;
    try
    {
      localQQAppInterface = QWalletTools.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      i = ViewHolderFactory.a(paramMessageForQQWalletMsg.messageType);
      str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
      }
      if ((localQQAppInterface == null) || (paramSessionInfo == null)) {
        break label687;
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      localRecorderParam = new RecordParams.RecorderParam(RecordParams.jdField_b_of_type_Int, 16000, 1);
      if (!FileUtils.a())
      {
        a(2131694522);
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
      a(2131718862);
      b("sdcard full");
      return;
    }
    if (!QQRecorder.a(localRecorderParam.jdField_c_of_type_Int))
    {
      a(2131693443);
      b("internal storage full");
      return;
    }
    if (localQQAppInterface.isVideoChatting())
    {
      a(2131695173);
      b("ppt play error on video chatting");
      return;
    }
    if (i == 2)
    {
      this.jdField_c_of_type_Boolean = true;
      if (!VoiceRecognizer.a().a(localQQAppInterface)) {
        this.jdField_c_of_type_Boolean = false;
      }
      if (!VoiceRecognizer.a().a(b(str1))) {
        this.jdField_c_of_type_Boolean = false;
      }
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
      QLog.d("VoiceRedPacketHelper", 2, "startRecord() is checkInPhone:" + paramBoolean + ",isInitSuccess:" + this.jdField_c_of_type_Boolean + ",isServerAvailable:" + bool1 + ",redpkgType:" + i);
    }
    if ((!this.jdField_c_of_type_Boolean) && (!bool1)) {
      a(2, QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", BaseApplicationImpl.getContext().getResources().getString(2131695292)));
    }
    if (paramBoolean)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_d_of_type_Boolean = false;
      if ((i != 2) || (!this.jdField_c_of_type_Boolean)) {
        break label688;
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      label687:
      label688:
      do
      {
        str1 = BuddyTransfileProcessor.getTransferFilePath(localQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
        String str2 = MessageForPtt.getLocalFilePath(localRecorderParam.jdField_c_of_type_Int, str1);
        paramString = str1;
        if (str1 != null)
        {
          paramString = str1;
          if (!str1.equals(str2))
          {
            new File(str1).deleteOnExit();
            paramString = str2;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(BaseApplication.getContext());
        }
        paramSessionInfo = ChatActivityFacade.a(localQQAppInterface, paramString, paramSessionInfo, -2, localRecorderParam.jdField_c_of_type_Int);
        if (paramSessionInfo == null)
        {
          b("messageRecord create is null");
          return;
          if (bool1) {
            break;
          }
          this.jdField_a_of_type_Boolean = true;
          break;
        }
        if (i == 8)
        {
          a(1, paramSessionInfo);
          paramSessionInfo.voiceRedPacketFlag = 3;
          this.jdField_a_of_type_JavaUtilHashMap.put(paramSessionInfo, paramMessageForQQWalletMsg);
          localRecorderParam.jdField_a_of_type_JavaLangObject = paramSessionInfo;
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(localRecorderParam);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramString, true);
          paramSessionInfo = MediaPlayerManager.a(localQQAppInterface);
          if (paramSessionInfo != null) {
            paramSessionInfo.a(true);
          }
          this.jdField_b_of_type_Boolean = false;
          this.jdField_d_of_type_Int = -1;
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "startRecord() is called");
          }
        }
        else
        {
          if (this.jdField_a_of_type_Boolean) {}
          for (i = 1;; i = 2)
          {
            paramSessionInfo.voiceRedPacketFlag = i;
            break;
          }
        }
        return;
      } while (i != 8);
    }
  }
  
  public void a(VoiceRedPacketHelper.OnGetSkeyListener paramOnGetSkeyListener)
  {
    Object localObject = QWalletTools.a();
    if ((localObject == null) || (paramOnGetSkeyListener == null)) {}
    do
    {
      return;
      localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(((QQAppInterface)localObject).getCurrentAccountUin(), 16L, new VoiceRedPacketHelper.5(this, paramOnGetSkeyListener));
    } while ((localObject == null) || (((Ticket)localObject)._sig == null) || (((Ticket)localObject)._sig.length == 0));
    paramOnGetSkeyListener.a(new String(((Ticket)localObject)._sig));
  }
  
  public void a(VoiceRedPacketHelper.OnVoiceRedPacketListener paramOnVoiceRedPacketListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnVoiceRedPacketListener);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, long paramLong, byte[] paramArrayOfByte, String paramString, BaseUploadProcessor paramBaseUploadProcessor)
  {
    QQAppInterface localQQAppInterface;
    Object localObject1;
    Object localObject2;
    try
    {
      localQQAppInterface = QWalletTools.a();
      localObject1 = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      i = 0;
      if (localObject1 != null) {
        i = localObject1.hashCode();
      }
      if ((localQQAppInterface == null) || (paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForPtt)) || (localObject1 == null) || (((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject1).c()) || (this.jdField_b_of_type_Boolean) || (i != this.jdField_a_of_type_Int)) {
        return;
      }
      localObject2 = (MessageForPtt)paramMessageRecord;
      i = ((MessageForPtt)localObject2).voiceRedPacketFlag;
      localObject1 = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "checkAndSend MessagemessageForPtt flag:" + i);
      }
      if (i == 1)
      {
        paramMessageRecord = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramMessageRecord != null) && (!paramMessageRecord.c())) {
          paramMessageRecord.a(true, ((MessageForPtt)localObject2).getExtInfoFromExtStr("voice_score_id"));
        }
        b(b((MessageRecord)localObject2), (MessageRecord)localObject1);
        localQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, paramMessageObserver);
        return;
      }
      if (i != 2) {
        break label307;
      }
      if ((localObject1 == null) || (((MessageForQQWalletMsg)localObject1).mQQWalletRedPacketMsg == null))
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
    if (((MessageForQQWalletMsg)localObject1).istroop == 1) {
      i = 1;
    }
    for (;;)
    {
      a(new VoiceRedPacketHelper.3(this, localQQAppInterface, (MessageForQQWalletMsg)localObject1, i, paramLong, paramArrayOfByte, paramString, (MessageForPtt)localObject2, paramBaseUploadProcessor, paramMessageObserver));
      return;
      if (((MessageForQQWalletMsg)localObject1).istroop == 3000) {
        i = 2;
      }
    }
    label307:
    if (i == 3)
    {
      if (a(paramMessageRecord) == 1)
      {
        a(paramMessageRecord, paramLong, paramArrayOfByte, paramString);
        return;
      }
      if (a(paramMessageRecord) == 2)
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        localObject2 = (VoiceRedPacketHelper.RecordMsgInfo)this.jdField_a_of_type_JavaUtilMap.get(paramMessageRecord);
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord);
        if ((localMessageForQQWalletMsg == null) || (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null))
        {
          b("MessageForQQWalletMsg is null");
          return;
        }
        i = 0;
        if (localMessageForQQWalletMsg.istroop == 1) {
          i = 1;
        }
        for (;;)
        {
          a(new VoiceRedPacketHelper.4(this, localMessageForQQWalletMsg, localQQAppInterface, i, (VoiceRedPacketHelper.RecordMsgInfo)localObject2, paramLong, paramArrayOfByte, paramString, (MessageForQQWalletMsg)localObject1, paramMessageRecord, paramBaseUploadProcessor, paramMessageObserver));
          return;
          int j = localMessageForQQWalletMsg.istroop;
          if (j == 3000) {
            i = 2;
          }
        }
      }
    }
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cancelRecord() is called");
    }
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof WechatNsWrapper)) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null) && (paramProcessData != null) && (this.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramProcessData.jdField_a_of_type_ArrayOfByte, 0, paramProcessData.jdField_a_of_type_Int);
    }
  }
  
  public void b(String paramString)
  {
    a(1, paramString);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
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
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    a(3, "onInitFailed");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    a(3, "onRecorderAbnormal");
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderEnd() is called, isCancel:" + this.jdField_b_of_type_Boolean + "|" + this.jdField_d_of_type_Int);
    }
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        PttBuffer.a(paramString);
        return;
      }
      localObject1 = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        ((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject1).j();
      }
      PttBuffer.b(paramString);
      if (paramDouble < 500.0D)
      {
        a(2131690062);
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
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.flush();
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    }
    Object localObject1 = (MessageForPtt)paramRecorderParam.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    boolean bool;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      localObject2 = a(this.jdField_a_of_type_ArrayOfByte, (MessageForQQWalletMsg)localObject2);
      bool = ((VoiceRedPacketHelper.RecogResult)localObject2).jdField_a_of_type_Boolean;
      if (bool) {
        b(((VoiceRedPacketHelper.RecogResult)localObject2).jdField_a_of_type_JavaLangString, (MessageRecord)localObject1);
      }
      localObject2 = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject2 == null) || (((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject2).c()) || (bool)) {
        break label674;
      }
      ((VoiceRedPacketHelper.OnVoiceRedPacketListener)localObject2).a(false, "");
      break label674;
      localObject2 = (MessageForQQWalletMsg)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      if (localObject2 == null)
      {
        b("messageForQQWalletMsg is null!");
        return;
      }
      j = ViewHolderFactory.a(((MessageForQQWalletMsg)localObject2).messageType);
      if (j == 8) {
        if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag == 0) {
          if (this.jdField_d_of_type_Int == -1) {
            if (!QWalletTools.a(BaseApplicationImpl.getContext())) {
              break label677;
            }
          }
        }
      }
    }
    label674:
    label677:
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      if ((this.jdField_d_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 18) && (!a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, paramString, paramRecorderParam)))
      {
        b("mix song error!");
        return;
      }
      a(2, (MessageRecord)localObject1);
      for (;;)
      {
        ((MessageForPtt)localObject1).voiceRedPacketFlag = 3;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "isCheckInPhone:" + this.jdField_a_of_type_Boolean + ",isRecognizedInPhone:" + bool + ",redpkgType:" + j + "songFlag:" + ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag);
        }
        if ((!bool) && (this.jdField_a_of_type_Boolean)) {
          break;
        }
        localObject2 = QWalletTools.a();
        if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
          break;
        }
        ((MessageForPtt)localObject1).serial();
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", ((MessageForPtt)localObject1).vipBubbleDiyTextId);
        ChatActivityFacade.a((QQAppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, ((MessageForPtt)localObject1).uniseq, false, (int)paramDouble, paramRecorderParam.jdField_c_of_type_Int, true, 0, 5, true, ((MessageForPtt)localObject1).vipSubBubbleId, localBundle, null, null, false, (MessageRecord)localObject1, 0);
        paramString = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramString == null) {
          break;
        }
        this.jdField_a_of_type_Int = paramString.hashCode();
        return;
        if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag == 1) {
          a(1, (MessageRecord)localObject1);
        }
      }
      if (this.jdField_a_of_type_Boolean) {}
      for (i = 1;; i = 2)
      {
        ((MessageForPtt)localObject1).voiceRedPacketFlag = i;
        break;
      }
      bool = false;
      break;
      return;
      break;
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    b("onRecorderError");
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderNotReady() is called");
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderPrepare() is called :" + this.jdField_d_of_type_Boolean);
    }
    AudioUtil.b(2131230745, false);
    byte[] arrayOfByte = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, arrayOfByte, arrayOfByte.length);
    paramString = (MessageForPtt)paramRecorderParam.jdField_a_of_type_JavaLangObject;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
      if (paramString.voiceRedPacketFlag == 3)
      {
        paramString = new byte[QQRecorder.a(paramRecorderParam.jdField_a_of_type_Int, 2, 2) / 1000 * 200];
        Arrays.fill(paramString, (byte)0);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramString, 0, paramString.length);
      }
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
    paramString = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString != null) && (!paramString.c())) {
      paramString.a(AudioPanel.a(paramInt2));
    }
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderStart() is called");
    }
    VoiceRedPacketHelper.OnVoiceRedPacketListener localOnVoiceRedPacketListener = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localOnVoiceRedPacketListener != null) {
      localOnVoiceRedPacketListener.i();
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderVolumeStateChanged() is called");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper
 * JD-Core Version:    0.7.0.1
 */