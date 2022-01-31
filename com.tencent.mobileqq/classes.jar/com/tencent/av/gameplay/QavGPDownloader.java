package com.tencent.av.gameplay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import jjw;

public class QavGPDownloader
{
  QAVGamePlaySoConfigInfo jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = null;
  jjw jdField_a_of_type_Jjw = null;
  boolean jdField_a_of_type_Boolean = false;
  
  QavGPDownloader()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "QavGPDownloader in QQAppInterface");
    }
    this.jdField_a_of_type_Jjw = new jjw();
  }
  
  public static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.qavgameplaysomgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QavGPDownloadManager.a().a.b(paramIntent, paramConfig);
  }
  
  public static void a(QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo)
  {
    SharedPreferences localSharedPreferences = QavGamePlayUtil.a();
    paramQAVGamePlaySoConfigInfo = paramQAVGamePlaySoConfigInfo.b;
    localSharedPreferences.edit().putString("so_zip_md5", paramQAVGamePlaySoConfigInfo).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "onEnterBackground");
    }
    a();
  }
  
  public static void a(ConfigurationService.ConfigSeq paramConfigSeq)
  {
    SharedPreferences localSharedPreferences = QavGamePlayUtil.a();
    if (!TextUtils.isEmpty(localSharedPreferences.getString("config", null))) {}
    for (int i = localSharedPreferences.getInt("ver", 0);; i = 0)
    {
      paramConfigSeq.version.set(i);
      paramConfigSeq.compress.set(1);
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("fillVersion[%s]", new Object[] { Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public static boolean a()
  {
    return QavGPDownloadManager.a().a.b();
  }
  
  private boolean b()
  {
    QLog.d("QavGPDownloadManager", 4, "innerDownload, start");
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(20) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGPDownloadManager", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo == null) {
      this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo;
    if (localObject == null)
    {
      QLog.d("QavGPDownloadManager", 2, "downloadInfo == null");
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == QavGamePlayUtil.a((QAVGamePlaySoConfigInfo)localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        QLog.d("QavGPDownloadManager", 2, "downloadTask.start");
        return this.jdField_a_of_type_Jjw.a((QAVGamePlaySoConfigInfo)localObject);
      }
      QLog.d("QavGPDownloadManager", 2, "bDownloading = false");
      return bool;
    }
  }
  
  void b(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null)
    {
      QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config, config is null");
      return;
    }
    SharedPreferences localSharedPreferences = QavGamePlayUtil.a();
    if (!TextUtils.isEmpty(localSharedPreferences.getString("config", null))) {}
    for (int i = localSharedPreferences.getInt("ver", 0);; i = 0)
    {
      if (paramConfig.msg_content_list != null) {}
      int m;
      for (int j = paramConfig.msg_content_list.size();; j = -1)
      {
        m = paramConfig.version.get();
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("handle_QAG_QavGameplay_Config, serverVersion[%s], localVersion[%s], size[%s], autoDwonload[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
        }
        if (m == i) {
          break;
        }
        if ((j > 0) || (m == 0)) {
          break label207;
        }
        QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config,  (size <= 0 && serverVersion != 0) ");
        this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = null;
        localSharedPreferences.edit().putString("config", "");
        localSharedPreferences.edit().putInt("ver", m);
        localSharedPreferences.edit().commit();
        return;
      }
      label207:
      Intent localIntent = null;
      Object localObject3 = null;
      int k = 0;
      int n;
      Object localObject4;
      label417:
      label546:
      Object localObject2;
      if (k < j)
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(k);
        if (paramIntent != null)
        {
          n = paramIntent.task_id.get();
          localObject4 = paramIntent.content.get();
          if (localObject4 != null)
          {
            Object localObject1 = "";
            if (paramIntent.compress.get() == 1)
            {
              localObject4 = OlympicUtil.a(((ByteStringMicro)localObject4).toByteArray());
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                paramIntent = new String((byte[])localObject4, "UTF-8");
                if (TextUtils.isEmpty(paramIntent)) {
                  break label705;
                }
                localObject1 = QAVGamePlaySoConfigInfo.a(paramIntent);
                if (QLog.isColorLevel())
                {
                  if (localObject1 == null) {
                    break label670;
                  }
                  bool = true;
                  QLog.d("QavGPDownloadManager", 2, String.format("handle_QAG_QavGameplay_Config, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], parseJson[%s], \n%s", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), paramIntent }));
                }
                if (localObject1 == null) {
                  break label676;
                }
                if (n != ((QAVGamePlaySoConfigInfo)localObject1).a) {
                  break label937;
                }
                if (TextUtils.isEmpty(paramIntent)) {
                  break label911;
                }
                this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = ((QAVGamePlaySoConfigInfo)localObject1);
                localSharedPreferences.edit().putString("config", paramIntent);
                localSharedPreferences.edit().putInt("ver", m);
                localSharedPreferences.edit().commit();
                QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config,  !TextUtils.isEmpty(fjsonContent)");
                if (!this.jdField_a_of_type_Boolean) {
                  break;
                }
                QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config, mNeedDownloadAfterGetConfig == true");
                this.jdField_a_of_type_Boolean = false;
                a();
                return;
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break label921;
                }
                paramIntent.printStackTrace();
                paramIntent = "编码失败" + paramIntent.getMessage();
                localObject4 = null;
                localObject1 = paramIntent;
                paramIntent = (Intent)localObject4;
                continue;
              }
              catch (OutOfMemoryError paramIntent)
              {
                if (QLog.isColorLevel())
                {
                  paramIntent.printStackTrace();
                  localObject1 = "内存不足" + paramIntent.getMessage();
                }
                System.gc();
                try
                {
                  paramIntent = new String((byte[])localObject4, "UTF-8");
                }
                catch (Throwable localThrowable)
                {
                  paramIntent = null;
                  localObject2 = "异常" + localThrowable.getMessage();
                }
                continue;
              }
              localObject2 = "解压失败";
              paramIntent = null;
              continue;
              paramIntent = ((ByteStringMicro)localObject4).toStringUtf8();
              localObject2 = "无压缩";
              continue;
              label670:
              boolean bool = false;
            }
            label676:
            paramIntent = localObject3;
            localObject2 = localIntent;
          }
        }
      }
      label911:
      label921:
      label937:
      for (;;)
      {
        localObject4 = paramIntent;
        paramIntent = (Intent)localObject2;
        for (;;)
        {
          k += 1;
          localObject3 = localObject4;
          localIntent = paramIntent;
          break;
          label705:
          localObject4 = localObject3;
          paramIntent = localIntent;
          if (QLog.isColorLevel())
          {
            QLog.d("QavGPDownloadManager", 2, String.format("handle_QAG_QavGameplay_Config, err, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], %s", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), localObject2 }));
            localObject4 = localObject3;
            paramIntent = localIntent;
            continue;
            QLog.d("QavGPDownloadManager", 1, String.format("handle_QAG_QavGameplay_Config, sub_content为空, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }));
            localObject4 = localObject3;
            paramIntent = localIntent;
            continue;
            QLog.d("QavGPDownloadManager", 1, String.format("handle_QAG_QavGameplay_Config, content为空, index[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }));
            localObject4 = localObject3;
            paramIntent = localIntent;
          }
        }
        QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config,  Fucking!!!!");
        return;
        paramIntent = "";
        break label546;
        paramIntent = localObject3;
        localObject2 = localIntent;
        break label417;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloader
 * JD-Core Version:    0.7.0.1
 */