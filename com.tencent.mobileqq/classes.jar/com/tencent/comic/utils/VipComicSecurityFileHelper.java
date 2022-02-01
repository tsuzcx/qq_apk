package com.tencent.comic.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import mqq.app.ISecurityFileHelper;

public class VipComicSecurityFileHelper
  implements ISecurityFileHelper
{
  private Pattern a = Pattern.compile("\\d{5,}");
  private FilenameFilter b = new VipComicSecurityFileHelper.1(this);
  
  public String declareBusinessFileName()
  {
    return "QQComicOffline";
  }
  
  public boolean doMigrate(File paramFile)
  {
    File localFile1 = new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/");
    String[] arrayOfString = localFile1.list(this.b);
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return true;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        File localFile2 = new File(localFile1, (String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(declareBusinessFileName());
        localObject = new File(localStringBuilder.toString());
        int k = FileUtils.quickMove(localFile2.getAbsolutePath(), ((File)localObject).getAbsolutePath());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doMigrate：");
        localStringBuilder.append(declareBusinessFileName());
        localStringBuilder.append(" result = ");
        localStringBuilder.append(k);
        localStringBuilder.append(" fromFile = ");
        localStringBuilder.append(localFile2.getAbsolutePath());
        localStringBuilder.append(" targetFile = ");
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        QLog.d("VipComicSecurityFileHelper", 2, localStringBuilder.toString());
        if (k != 0) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean needMigration()
  {
    Object localObject = new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/").list(this.b);
    boolean bool;
    if ((localObject != null) && (localObject.length > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("needMigration: uinDirs.len=");
    if (localObject == null)
    {
      localObject = Integer.valueOf(0);
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localObject.length);
      localStringBuilder2.append(" needMigration=");
      localStringBuilder2.append(bool);
      localObject = localStringBuilder2.toString();
    }
    localStringBuilder1.append(localObject);
    QLog.i("VipComicSecurityFileHelper", 2, localStringBuilder1.toString());
    return bool;
  }
  
  public File oldBusinessDir(String paramString)
  {
    return new File(new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/"), paramString);
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    paramString = oldBusinessDir(paramString);
    return (paramString.isDirectory()) && (paramString.exists());
  }
  
  public String[] reportHistoryFileInfo()
  {
    String[] arrayOfString1 = new String[2];
    Object localObject = new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/");
    String[] arrayOfString2 = ((File)localObject).list(this.b);
    if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
    {
      int j = arrayOfString2.length;
      long l1 = 0L;
      long l2 = l1;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString2[i];
        l2 += FileUtils.getFileOrFolderSize(new File((File)localObject, str).getAbsolutePath());
        l1 += FileUtils.getFileAmount(new File((File)localObject, str).getAbsolutePath());
        i += 1;
      }
      arrayOfString1[0] = Long.toString(l2);
      arrayOfString1[1] = Long.toString(l1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportHistoryFileInfo:");
      ((StringBuilder)localObject).append(declareBusinessFileName());
      ((StringBuilder)localObject).append(" fileAmount = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" fileSize = ");
      ((StringBuilder)localObject).append(l2);
      QLog.d("VipComicSecurityFileHelper", 2, ((StringBuilder)localObject).toString());
    }
    return arrayOfString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.utils.VipComicSecurityFileHelper
 * JD-Core Version:    0.7.0.1
 */