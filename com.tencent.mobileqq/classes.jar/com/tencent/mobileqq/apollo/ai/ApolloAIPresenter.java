package com.tencent.mobileqq.apollo.ai;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.task.ApolloAudioPlayer;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import yom;
import yon;

public class ApolloAIPresenter
  implements IApolloAIListener, QQRecorder.OnQQRecorderListener
{
  private double jdField_a_of_type_Double;
  private Context jdField_a_of_type_AndroidContentContext;
  private IApolloAIView jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new yon(this, ThreadManager.getSubThreadLooper());
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new yom(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ApolloAIPresenter(QQAppInterface paramQQAppInterface, Context paramContext, IApolloAIView paramIApolloAIView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView = paramIApolloAIView;
    paramContext = (ApolloManager)paramQQAppInterface.getManager(152);
    if (paramContext != null) {
      paramContext.a(this);
    }
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloAIMessage paramApolloAIMessage)
  {
    int i = 0;
    if ((paramApolloAIMessage == null) || (paramApolloAIMessage.jdField_a_of_type_Int > 1)) {}
    label412:
    label415:
    for (;;)
    {
      return;
      paramApolloAIMessage.jdField_c_of_type_Int = 4;
      paramApolloAIMessage.jdField_c_of_type_Boolean = true;
      paramApolloAIMessage.jdField_b_of_type_Boolean = false;
      Object localObject;
      if (!TextUtils.isEmpty(paramApolloAIMessage.jdField_c_of_type_JavaLangString)) {
        if (!TextUtils.isEmpty(paramApolloAIMessage.jdField_a_of_type_JavaLangString))
        {
          paramApolloAIMessage.jdField_a_of_type_JavaLangString += " 查看详情";
          localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = paramApolloAIMessage.jdField_b_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloAIPresenter", 2, "emotion action id:" + ((ApolloActionData)localObject).actionId);
          }
          if ((paramApolloAIMessage.jdField_b_of_type_Int <= 0) || (ApolloUtil.a(ApolloUtil.a((ApolloActionData)localObject, 8)))) {
            break label412;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloAIPresenter", 2, "emotion action NOT exist");
          }
          paramApolloAIMessage.jdField_b_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if ((((ApolloActionData)localObject).actionId <= 0) || (i != 0)) {
          break label415;
        }
        ApolloResDownloader.a(paramQQAppInterface, ApolloUtil.a((ApolloActionData)localObject, 8) + "/d.zip", ApolloUtil.a((ApolloActionData)localObject, 9));
        return;
        paramApolloAIMessage.jdField_a_of_type_JavaLangString = "查看详情";
        break;
        if ((paramApolloAIMessage.jdField_a_of_type_Int != 1) || (TextUtils.isEmpty(paramApolloAIMessage.jdField_b_of_type_JavaLangString))) {
          break;
        }
        localObject = new File(ApolloConstant.m + System.currentTimeMillis() + ".mp3");
        DownloadTask localDownloadTask = new DownloadTask(paramApolloAIMessage.jdField_b_of_type_JavaLangString, (File)localObject);
        localDownloadTask.l = true;
        localDownloadTask.o = true;
        localDownloadTask.p = true;
        localDownloadTask.jdField_b_of_type_Int = 1;
        int j = DownloaderFactory.a(localDownloadTask, paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloAIPresenter", 2, "audio download ret:" + j + ",path:" + ((File)localObject).getAbsolutePath());
        }
        if (j != 0) {
          break;
        }
        paramApolloAIMessage.jdField_d_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        if ((paramApolloAIMessage.jdField_d_of_type_Int > 0) || (paramApolloAIMessage.jdField_a_of_type_Int != 1)) {
          break;
        }
        paramApolloAIMessage.jdField_d_of_type_Int = ApolloAudioPlayer.a(paramApolloAIMessage.jdField_d_of_type_JavaLangString);
        break;
        i = 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.c();
    }
    this.jdField_a_of_type_Double = 0.0D;
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int j = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((j & 0x4) != 0) {
      i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      return i - 200 + 200;
      if ((j & 0x2) != 0) {
        i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(ApolloAIMessage paramApolloAIMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAIPresenter", 2, "[pushResponse], message:" + paramApolloAIMessage + ",thread id:" + Thread.currentThread().getId());
    }
    if ((paramApolloAIMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView == null)) {}
    do
    {
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramApolloAIMessage);
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.a(paramApolloAIMessage);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    byte[] arrayOfByte = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, arrayOfByte, arrayOfByte.length, (short)0);
      return;
    }
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, arrayOfByte, arrayOfByte.length);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) {
      if (this.jdField_a_of_type_Double < 500.0D)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.j();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloAIPresenter", 2, "apollo AI Record is too short");
        }
        VipUtils.a(null, "cmshow", "Apollo", "voice_sent", 0, 1, new String[] { "0", "0", String.valueOf(paramDouble / 1000.0D) });
      }
    }
    label122:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.d();
      } while (paramRecorderParam == null);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break;
      }
      i = 1;
      if (i != 0) {
        break label311;
      }
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      paramRecorderParam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler == null) || (paramRecorderParam == null));
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
      paramRecorderParam.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_b_of_type_Boolean = true;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_Int = 24;
    localTransferRequest.jdField_c_of_type_Int = 36;
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localTransferRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.j = ((int)paramDouble);
    localTransferRequest.i = paramString;
    paramRecorderParam.a(localTransferRequest);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "voice_sent", 0, i, new String[] { "0", "0", String.valueOf(paramDouble / 1000.0D) });
      return;
      i = 0;
      break;
      label311:
      PttBuffer.b(paramString);
      break label122;
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.g();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIPresenter", 2, "apollo ai record onRecorderError");
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.a(paramString, paramInt2, paramDouble);
      }
      this.jdField_a_of_type_Double = paramDouble;
      return;
      i = 0;
      break;
      label58:
      PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
      localObject = new QQRecorder.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((QQRecorder.RecorderParam)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    Object localObject = new File(ApolloConstant.k);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ApolloConstant.k + System.currentTimeMillis() + ".amr";
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((String)localObject, true);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).b(paramInt, "cmshowAI");
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.f();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIPresenter", 2, "apollo ai record onRecorderAbnormal");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null)
      {
        ((TransFileController)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
      }
      localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (localObject != null) {
        ((ApolloManager)localObject).a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.g();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIPresenter", 2, "apollo ai record onInitFail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ai.ApolloAIPresenter
 * JD-Core Version:    0.7.0.1
 */