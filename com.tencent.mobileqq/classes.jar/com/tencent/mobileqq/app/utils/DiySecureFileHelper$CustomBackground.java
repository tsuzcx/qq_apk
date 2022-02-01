package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.ISecurityFileHelper;

public class DiySecureFileHelper$CustomBackground
  extends DiySecureFileHelper.BaseFileHelper
  implements ISecurityFileHelper
{
  public DiySecureFileHelper$CustomBackground()
  {
    super(null);
  }
  
  protected String a()
  {
    return "QQThemeMigration";
  }
  
  public String declareBusinessFileName()
  {
    return "QQ_Favorite";
  }
  
  public boolean doMigrate(File paramFile)
  {
    QLog.d("ISecurityFileHelper", 1, "Move Theme file start");
    paramFile = new File(DiySecureFileHelper.a());
    File[] arrayOfFile;
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      arrayOfFile = DiySecureFileHelper.a(paramFile);
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localObject1 = arrayOfFile[i];
        if ((((File)localObject1).isDirectory()) && (!new File((File)localObject1, ".moveflag").exists()))
        {
          localObject2 = ((File)localObject1).getName();
          if ((((String)localObject2).length() > 4) && (((String)localObject2).matches("[0-9]{5,}")))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramFile.getAbsolutePath());
            ((StringBuilder)localObject3).append("/");
            ((StringBuilder)localObject3).append(DiySecureFileHelper.a((String)localObject2));
            localObject2 = ((StringBuilder)localObject3).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("/.moveflag");
            FileUtils.createFileIfNotExits(((StringBuilder)localObject3).toString());
            DiySecureFileHelper.b(((File)localObject1).getAbsolutePath(), (String)localObject2);
          }
        }
        i += 1;
      }
    }
    paramFile = new File(AppConstants.SDCARD_PATH);
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = DiySecureFileHelper.a(paramFile);
      i = paramFile.length;
      int k = 0;
      while (k < i)
      {
        arrayOfFile = paramFile[k];
        localObject1 = arrayOfFile.getName();
        if ((arrayOfFile.isDirectory()) && (((String)localObject1).length() > 4) && (((String)localObject1).matches("[0-9]{5,}")))
        {
          if (DiySecureFileHelper.a(arrayOfFile).length > 0)
          {
            localObject2 = DiySecureFileHelper.a(arrayOfFile);
            int n = localObject2.length;
            int m = 0;
            j = 0;
            while (m < n)
            {
              localObject3 = localObject2[m];
              if ((((File)localObject3).isDirectory()) && (((File)localObject3).getName().equals("custom_background")))
              {
                localObject3 = DiySecureFileHelper.a((File)localObject3);
                int i1 = localObject3.length;
                j = 0;
                while (j < i1)
                {
                  Object localObject4 = localObject3[j];
                  if (localObject4.isFile())
                  {
                    Object localObject5 = new StringBuilder();
                    ((StringBuilder)localObject5).append(DiySecureFileHelper.a());
                    ((StringBuilder)localObject5).append(DiySecureFileHelper.a((String)localObject1));
                    ((StringBuilder)localObject5).append("/.moveflag");
                    FileUtils.createFileIfNotExits(((StringBuilder)localObject5).toString());
                    localObject5 = localObject4.getAbsolutePath();
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append(DiySecureFileHelper.a());
                    localStringBuilder.append(DiySecureFileHelper.a((String)localObject1));
                    localStringBuilder.append("/");
                    localStringBuilder.append(localObject4.getName());
                    FileUtils.quickMove((String)localObject5, localStringBuilder.toString());
                  }
                  j += 1;
                }
                j = 1;
              }
              m += 1;
            }
          }
          else
          {
            j = 1;
          }
        }
        else {
          j = 0;
        }
        if (j != 0) {
          FileUtils.deleteDirectory(arrayOfFile.getAbsolutePath());
        }
        k += 1;
      }
    }
    c();
    return true;
  }
  
  public boolean needMigration()
  {
    return b();
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
 * Qualified Name:     com.tencent.mobileqq.app.utils.DiySecureFileHelper.CustomBackground
 * JD-Core Version:    0.7.0.1
 */