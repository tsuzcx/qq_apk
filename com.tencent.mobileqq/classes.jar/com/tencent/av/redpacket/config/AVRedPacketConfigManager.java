package com.tencent.av.redpacket.config;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jlx;
import jly;
import jlz;
import jma;
import mqq.manager.Manager;

public class AVRedPacketConfigManager
  implements Handler.Callback, ResDownloadManager.IResDownloadListener, Manager
{
  private Handler a;
  public AVRedPacketConfig a;
  public IAVRedPacketCallback a;
  public QQAppInterface a;
  public ResDownloadManager a;
  public Object a;
  public String a;
  public volatile boolean a;
  public IAVRedPacketCallback b;
  public String b;
  public volatile boolean b;
  public volatile boolean c;
  
  public AVRedPacketConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)paramQQAppInterface.getManager(190));
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this);
  }
  
  public int a()
  {
    AVRedPacketConfig localAVRedPacketConfig = a();
    if (localAVRedPacketConfig == null) {}
    for (int i = 0;; i = localAVRedPacketConfig.version)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getConfigVersion:" + i);
      }
      return i;
    }
  }
  
  public AVRedPacketConfig a()
  {
    return a(true);
  }
  
  public AVRedPacketConfig a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null) && (paramBoolean))
    {
      b();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig:" + this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
      }
    }
    return this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig;
  }
  
  void a()
  {
    PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192);
    RunnableTask localRunnableTask = new RunnableTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "av_redpacket_pic", new jlx(this), 0L);
    boolean bool1 = localPreDownloadController.a(10070, "prd", "av_redpacket", 0, this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL, AVRedPacketRDHandler.a(), 1, 1, true, localRunnableTask);
    localRunnableTask = new RunnableTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "av_redpacket_music", new jly(this), 0L);
    boolean bool2 = localPreDownloadController.a(10070, "prd", "av_redpacket", 0, this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl, AVRedPacketRDHandler.a(), 1, 1, true, localRunnableTask);
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "preDownloadRes picReqRet =  " + bool1 + ",musicReqRet = " + bool2);
    }
  }
  
  public void a(AVRedPacketConfig paramAVRedPacketConfig, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onGetConfig ,isNewConfig = " + paramBoolean + ",config = " + paramAVRedPacketConfig);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = paramAVRedPacketConfig;
      if (paramAVRedPacketConfig != null)
      {
        localObject2 = QavRecordDpc.a();
        if ((localObject2 != null) && (((QavRecordDpc)localObject2).i == 1)) {
          a();
        }
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback;
      if (localObject2 != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback.a(true, paramAVRedPacketConfig);
        this.jdField_a_of_type_Boolean = false;
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig != null)) {
          this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.saveToFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onGetConfig finish, isGettingConfig =" + this.jdField_a_of_type_Boolean);
        }
        return;
      }
      catch (RemoteException paramAVRedPacketConfig)
      {
        for (;;)
        {
          paramAVRedPacketConfig.printStackTrace();
        }
      }
    }
  }
  
  public void a(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "downloadRes");
    }
    if (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
    {
      QLog.d("AVRedPacketConfigManger", 1, "downloadRes, redPacketConfig is null");
      return;
    }
    PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192);
    localPreDownloadController.a(this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL);
    localPreDownloadController.a(this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl);
    ThreadManager.executeOnSubThread(new jlz(this, paramIAVRedPacketCallback), true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + paramString1 + ",md5 = " + paramString2 + ",errCode = " + paramInt + ",path = " + paramString3 + ",userData = " + paramObject);
    }
    String str = null;
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label169;
      }
      paramObject = this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL;
      AVRedPacketDataCollector.a(i, paramInt);
      if (!paramString3.endsWith("/")) {
        break label191;
      }
    }
    label169:
    label191:
    for (str = paramString3;; str = paramString3 + File.separator)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(paramObject))) {
        ThreadManager.executeOnSubThread(new jma(this, paramInt, str, paramString2, i, paramString1), true);
      }
      return;
      paramObject = str;
      if (i != 2) {
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl;
      break;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
      {
        this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = AVRedPacketConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "loadConfigFromFile,redPacketConfig =   " + this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
        }
      }
      return;
    }
  }
  
  public void b(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,start");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,isGettingConfig =   " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback = paramIAVRedPacketCallback;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramIAVRedPacketCallback = this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback;
        if (paramIAVRedPacketCallback == null) {}
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback.a(true, this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
        return;
      }
      catch (RemoteException paramIAVRedPacketCallback)
      {
        for (;;)
        {
          paramIAVRedPacketCallback.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,error    ", paramIAVRedPacketCallback);
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      QavRecordReporter.f();
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketConfigManager
 * JD-Core Version:    0.7.0.1
 */