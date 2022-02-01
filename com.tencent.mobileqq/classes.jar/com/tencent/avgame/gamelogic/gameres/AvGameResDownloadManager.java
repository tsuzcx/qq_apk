package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.avgame.config.AvGameConfProcessor;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AVRes;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager;
import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager.IResDownloadListener;
import com.tencent.avgame.gamelogic.gameres.api.impl.ResDownloadManagerImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvGameResDownloadManager
  implements IResDownloadManager.IResDownloadListener
{
  public static String a;
  private AvGameResDownloadManager.IStatusListener jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener;
  private IResDownloadManager jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager;
  
  public AvGameResDownloadManager(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof BaseQQAppInterface)) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager = ((IResDownloadManager)((BaseQQAppInterface)paramAppInterface).getRuntimeService(IResDownloadManager.class));
    } else {
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager = new ResDownloadManagerImpl(paramAppInterface);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager.addListener(this);
  }
  
  private void a(int paramInt, String paramString)
  {
    AvGameResDownloadManager.IStatusListener localIStatusListener = this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener;
    if (localIStatusListener != null)
    {
      if (paramInt == 0)
      {
        localIStatusListener.a(paramString);
        return;
      }
      localIStatusListener.b(paramInt);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadStart()");
    }
    AvGameResDownloadManager.IStatusListener localIStatusListener = this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener;
    if (localIStatusListener != null) {
      localIStatusListener.a();
    }
  }
  
  public void a(AvGameResDownloadManager.ResInfo paramResInfo)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "startDownload res...");
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager.download(paramResInfo.a, paramResInfo.b, ".zip", true, 1);
      return;
    }
    finally {}
  }
  
  public void a(AvGameResDownloadManager.ResInfo paramResInfo, AvGameResDownloadManager.IStatusListener paramIStatusListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkResDownloadReady resUrl is ");
      String str;
      if (paramResInfo == null) {
        str = "emptyUrl";
      } else {
        str = paramResInfo.a;
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" resMd5 is ");
      if (paramResInfo == null) {
        str = "emptyMd5";
      } else {
        str = paramResInfo.b;
      }
      localStringBuilder.append(str);
      QLog.d("AvGameResDownloadManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener = paramIStatusListener;
    if ((paramResInfo != null) && (!TextUtils.isEmpty(paramResInfo.a)) && (!TextUtils.isEmpty(paramResInfo.b)))
    {
      a(paramResInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvGameResDownloadManager", 2, "need pull config");
    }
    ((AvGameConfProcessor)QConfigManager.a().a(642)).a(new AvGameResDownloadManager.1(this));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadUpdate,url =   ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",percent = ");
      localStringBuilder.append(paramInt);
      QLog.d("AvGameResDownloadManager", 2, localStringBuilder.toString());
    }
    paramString1 = this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener;
    if (paramString1 != null) {
      paramString1.a(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish,url =   ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",errCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",path = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",userData = ");
      localStringBuilder.append(paramObject);
      QLog.d("AvGameResDownloadManager", 2, localStringBuilder.toString());
    }
    if (!paramString3.endsWith("/"))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(File.separator);
      paramString3 = paramString1.toString();
    }
    a(paramInt, paramString3);
  }
  
  public void a(List<ITopic> paramList, String paramString, boolean paramBoolean)
  {
    if (paramList != null) {}
    try
    {
      if ((paramList.size() >= 1) && (((TopicBase)paramList.get(0)).b != null))
      {
        AvGameResHandler.a();
        int i = 0;
        while (i < paramList.size())
        {
          Iterator localIterator = ((TopicBase)paramList.get(i)).b.iterator();
          while (localIterator.hasNext())
          {
            AVRes localAVRes = (AVRes)localIterator.next();
            String str1 = localAVRes.b();
            String str2 = AvGameResHandler.a(str1, paramString);
            if ((!FileUtils.fileExists(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(localAVRes.a()))) {
              this.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager.download(localAVRes.a(), str1, paramString, paramBoolean, 1);
            } else {
              QLog.d("AvGameResDownloadManager", 1, String.format("startDownload() [isExist,avResUrl,avResMd5] %b , %s , %s", new Object[] { Boolean.valueOf(FileUtils.fileExists(str2)), localAVRes.a(), str1 }));
            }
          }
          i += 1;
        }
        return;
      }
      QLog.d("AvGameResDownloadManager", 1, "startDownload() topicList is empty just return");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener = null;
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager
 * JD-Core Version:    0.7.0.1
 */