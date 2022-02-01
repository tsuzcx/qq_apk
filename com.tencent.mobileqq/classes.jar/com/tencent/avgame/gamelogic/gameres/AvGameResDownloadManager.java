package com.tencent.avgame.gamelogic.gameres;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AVRes;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.AvGameConfProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvGameResDownloadManager
  implements ResDownloadManager.IResDownloadListener
{
  public static String a;
  private AvGameResDownloadManager.IStatusListener jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener;
  private ResDownloadManager jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager;
  
  public AvGameResDownloadManager(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD));; this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = new ResDownloadManager(paramAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this);
      return;
    }
  }
  
  public static URLDrawable a(String paramString)
  {
    paramString = c() + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "getDrawableByImageName path = " + paramString);
    }
    if (!FileUtils.a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "getDrawableByImageName return null,path = " + paramString);
      }
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
    paramString.downloadImediatly(true);
    return paramString;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "lottie" + File.separator;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener.a(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener.b(paramInt);
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "sounds" + File.separator;
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "images" + File.separator;
  }
  
  public static String d()
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    return jdField_a_of_type_JavaLangString + "fonts" + File.separator;
  }
  
  public static String e()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + File.separator + "AVGameFontConfigure.json";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener = null;
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.b(this);
  }
  
  public void a(AvGameResDownloadManager.ResInfo paramResInfo)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "startDownload res...");
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(paramResInfo.jdField_a_of_type_JavaLangString, paramResInfo.b, ".zip", true, 6);
      return;
    }
    finally {}
  }
  
  public void a(AvGameResDownloadManager.ResInfo paramResInfo, AvGameResDownloadManager.IStatusListener paramIStatusListener)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkResDownloadReady resUrl is ");
      if (paramResInfo != null) {
        break label129;
      }
      str = "emptyUrl";
      localStringBuilder = localStringBuilder.append(str).append(" resMd5 is ");
      if (paramResInfo != null) {
        break label137;
      }
    }
    label129:
    label137:
    for (String str = "emptyMd5";; str = paramResInfo.b)
    {
      QLog.d("AvGameResDownloadManager", 2, str);
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener = paramIStatusListener;
      if ((paramResInfo != null) && (!TextUtils.isEmpty(paramResInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramResInfo.b))) {
        break label145;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "need pull config");
      }
      ((AvGameConfProcessor)QConfigManager.a().a(642)).a(new AvGameResDownloadManager.1(this));
      return;
      str = paramResInfo.jdField_a_of_type_JavaLangString;
      break;
    }
    label145:
    a(paramResInfo);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener.a(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadFinish,url =   " + paramString1 + ",md5 = " + paramString2 + ",errCode = " + paramInt + ",path = " + paramString3 + ",userData = " + paramObject);
    }
    if (paramString3.endsWith("/")) {}
    for (;;)
    {
      a(paramInt, paramString3);
      return;
      paramString3 = paramString3 + File.separator;
    }
  }
  
  public void a(List<ITopic> paramList, String paramString, boolean paramBoolean)
  {
    if (paramList != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((paramList.size() < 1) || (((TopicBase)paramList.get(0)).b == null))
        {
          QLog.d("AvGameResDownloadManager", 1, "startDownload() topicList is empty just return");
          return;
        }
        AvGameResHandler.a();
        i = 0;
        if (i >= paramList.size()) {
          continue;
        }
        Iterator localIterator = ((TopicBase)paramList.get(i)).b.iterator();
        if (!localIterator.hasNext()) {
          break label214;
        }
        AVRes localAVRes = (AVRes)localIterator.next();
        String str1 = localAVRes.b();
        String str2 = AvGameResHandler.a(str1, paramString);
        if ((FileUtils.a(str2)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(localAVRes.a())))
        {
          QLog.d("AvGameResDownloadManager", 1, String.format("startDownload() [isExist,avResUrl,avResMd5] %b , %s , %s", new Object[] { Boolean.valueOf(FileUtils.a(str2)), localAVRes.a(), str1 }));
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(localAVRes.a(), str1, paramString, paramBoolean, 6);
      }
      finally {}
      continue;
      label214:
      i += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadStart()");
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$IStatusListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager
 * JD-Core Version:    0.7.0.1
 */