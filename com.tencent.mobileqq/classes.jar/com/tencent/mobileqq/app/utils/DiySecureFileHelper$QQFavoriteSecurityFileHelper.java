package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.ISecurityFileHelper;

public class DiySecureFileHelper$QQFavoriteSecurityFileHelper
  extends DiySecureFileHelper.BaseFileHelper
  implements ISecurityFileHelper
{
  public DiySecureFileHelper$QQFavoriteSecurityFileHelper()
  {
    super(null);
  }
  
  protected String a()
  {
    return "QQFavoriteMigration";
  }
  
  public String declareBusinessFileName()
  {
    return "QQ_Favorite";
  }
  
  public boolean doMigrate(File paramFile)
  {
    QLog.d("ISecurityFileHelper", 1, "Move QQFavorite file start");
    Object localObject = new File(AppConstants.SDCARD_IMG_FAVORITE);
    if ((((File)localObject).exists()) && (paramFile.isDirectory()))
    {
      paramFile = DiySecureFileHelper.a((File)localObject);
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        String str = paramFile[i];
        localObject = str.getName();
        if ((((String)localObject).length() > 4) && (((String)localObject).matches("[0-9]{5}.*")))
        {
          str = str.getAbsolutePath();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
          localStringBuilder.append(DiySecureFileHelper.a((String)localObject));
          FileUtils.quickMove(str, localStringBuilder.toString());
        }
        i += 1;
      }
    }
    c();
    return true;
  }
  
  public boolean needMigration()
  {
    if (b())
    {
      File localFile = new File(AppConstants.SDCARD_IMG_FAVORITE);
      if ((localFile.exists()) && (localFile.isDirectory())) {
        return true;
      }
      c();
    }
    return false;
  }
  
  public File oldBusinessDir(String paramString)
  {
    return null;
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    return false;
  }
  
  public String[] reportHistoryFileInfo()
  {
    return new String[] { "0", "0" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.DiySecureFileHelper.QQFavoriteSecurityFileHelper
 * JD-Core Version:    0.7.0.1
 */