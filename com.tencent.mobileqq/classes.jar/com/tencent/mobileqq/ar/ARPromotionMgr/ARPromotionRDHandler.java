package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;

public class ARPromotionRDHandler
  extends ResDownloadHandler.DefaultRDHandler
{
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = ((PromotionConfigInfo.ZipItem)paramDownloadParam.a).jdField_d_of_type_JavaLangString;
    if (QQAudioHelper.c())
    {
      String str = PromotionUtil.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUnzipDirPath, path[");
      localStringBuilder.append(paramDownloadParam);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return paramDownloadParam;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    PromotionConfigInfo.ZipItem localZipItem = (PromotionConfigInfo.ZipItem)paramDownloadParam.a;
    localZipItem.jdField_d_of_type_Int = 0;
    boolean bool2 = super.a(paramDownloadParam);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ARPromotionRDHandler, needDownload[");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append("], zipItem[");
    ((StringBuilder)localObject1).append(localZipItem);
    String str1 = ((StringBuilder)localObject1).toString();
    boolean bool1 = bool2;
    localObject1 = str1;
    String str2;
    if (bool2)
    {
      str2 = PrecoverUtils.a("20180426_803_worldcupXXX", localZipItem.b);
      bool1 = bool2;
      localObject1 = str1;
      if (!TextUtils.isEmpty(str2))
      {
        localObject2 = new File(str2);
        boolean bool3 = ((File)localObject2).exists();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append("], prePath[");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("], exists[");
        ((StringBuilder)localObject1).append(bool3);
        str1 = ((StringBuilder)localObject1).toString();
        bool1 = bool2;
        localObject1 = str1;
        if (!bool3) {}
      }
    }
    try
    {
      localObject1 = MD5FileUtil.a((File)localObject2);
    }
    catch (Exception localException)
    {
      label199:
      break label199;
    }
    localObject1 = "Exception";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("], preMd5[");
    ((StringBuilder)localObject2).append((String)localObject1);
    str1 = ((StringBuilder)localObject2).toString();
    if (TextUtils.equals(localZipItem.b, (CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131700954));
      localObject1 = ((StringBuilder)localObject1).toString();
      bool2 = FileUtils.copyFile(str2, b(paramDownloadParam));
      bool1 = super.a(paramDownloadParam);
      paramDownloadParam = new StringBuilder();
      paramDownloadParam.append((String)localObject1);
      paramDownloadParam.append(", copyFile[");
      paramDownloadParam.append(bool2);
      paramDownloadParam.append("], reCheck[");
      paramDownloadParam.append(bool1);
      paramDownloadParam.append("]");
      localObject1 = paramDownloadParam.toString();
      if (!bool1) {
        localZipItem.jdField_d_of_type_Int = 1;
      }
    }
    else
    {
      paramDownloadParam = new StringBuilder();
      paramDownloadParam.append(str1);
      paramDownloadParam.append(HardCodeUtil.a(2131700953));
      localObject1 = paramDownloadParam.toString();
      bool1 = bool2;
    }
    QLog.w(PromotionUtil.a, 1, (String)localObject1);
    return bool1;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = ((PromotionConfigInfo.ZipItem)paramDownloadParam.a).c;
    if (QQAudioHelper.c())
    {
      String str = PromotionUtil.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDownloadPath, path[");
      localStringBuilder.append(paramDownloadParam);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return paramDownloadParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.ARPromotionRDHandler
 * JD-Core Version:    0.7.0.1
 */