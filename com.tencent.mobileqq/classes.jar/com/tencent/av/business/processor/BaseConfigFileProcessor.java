package com.tencent.av.business.processor;

import android.os.Build.VERSION;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseConfigFileProcessor<T extends ItemBase>
{
  private final Object a = new Object();
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT <= 8) {
        return new String(paramFile);
      }
      try
      {
        paramFile = new String(paramFile, "UTF-8");
        return paramFile;
      }
      catch (UnsupportedEncodingException paramFile)
      {
        QLog.e("BaseFileProcessor_PTV", 1, "loadFileContent error, ", paramFile);
      }
    }
    return null;
  }
  
  public abstract String a();
  
  public ArrayList<MetaMaterial> a(ArrayList<MetaCategory> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return localArrayList;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MetaCategory localMetaCategory = (MetaCategory)paramArrayList.next();
        localArrayList.addAll(localMetaCategory.materials);
        localArrayList.addAll(a(localMetaCategory.subCategories));
      }
    }
    return localArrayList;
  }
  
  public abstract List<T> a(File paramFile);
  
  public List<T> a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readAndParseConfigFile parent: ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" newJson: ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" oldJson: ");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.i("BaseFileProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    synchronized (this.a)
    {
      localObject1 = new ArrayList();
      File localFile = new File(paramString1, paramString2);
      paramString3 = new File(paramString1, paramString3);
      if (!localFile.exists())
      {
        if (!paramString3.exists())
        {
          QLog.e("BaseFileProcessor", 1, "readAndParseConfigFile -> old json not exist, new json not exist too");
          paramString1 = (String)localObject1;
        }
        else
        {
          try
          {
            paramString1 = a(paramString3);
          }
          catch (Exception paramString1)
          {
            FileUtils.deleteFile(paramString3.getPath());
            a();
            paramString2 = new StringBuilder();
            paramString2.append("readAndParseConfigFile -> load oldJson exception ");
            paramString2.append(paramString1.getMessage());
            QLog.e("BaseFileProcessor", 1, paramString2.toString());
            paramString1 = (String)localObject1;
          }
        }
      }
      else
      {
        paramString1 = (String)localObject1;
        try
        {
          paramString2 = a(localFile);
          paramString1 = paramString2;
          FileUtils.moveFile(localFile.getPath(), paramString3.getPath());
          paramString1 = paramString2;
        }
        catch (Exception paramString2)
        {
          paramString3 = new StringBuilder();
          paramString3.append("readAndParseConfigFile -> load newJson exception ");
          paramString3.append(paramString2.getMessage());
          QLog.e("BaseFileProcessor", 1, paramString3.toString());
          FileUtils.deleteFile(localFile.getPath());
          a();
        }
      }
      return paramString1;
    }
  }
  
  public abstract void a();
  
  public void a(String paramString)
  {
    ThreadManagerV2.excute(new BaseConfigFileProcessor.1(this, paramString), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.processor.BaseConfigFileProcessor
 * JD-Core Version:    0.7.0.1
 */