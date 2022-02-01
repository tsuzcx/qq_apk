package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.tool.v.QarHelperV1;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class QarFile
{
  private QarHelper helper = new QarHelperV1();
  private File requiredFile;
  private File targetFile;
  
  private boolean initRequiredParam(String paramString1, String paramString2)
  {
    this.requiredFile = new File(paramString1);
    StringBuilder localStringBuilder;
    if (!this.requiredFile.exists())
    {
      paramString2 = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("required file not found: ");
      localStringBuilder.append(paramString1);
      paramString2.println(localStringBuilder.toString());
      return false;
    }
    this.targetFile = new File(paramString2);
    if (this.targetFile.exists())
    {
      if (!this.targetFile.delete())
      {
        paramString1 = System.out;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Qar can't create: ");
        localStringBuilder.append(paramString2);
        paramString1.println(localStringBuilder.toString());
        return false;
      }
    }
    else if ((this.targetFile.getParentFile() != null) && (!this.targetFile.getParentFile().exists())) {
      this.targetFile.mkdirs();
    }
    return true;
  }
  
  public boolean createQar(String paramString1, String paramString2)
  {
    if (initRequiredParam(paramString1, paramString2)) {
      return this.helper.write(this.requiredFile, this.targetFile);
    }
    return false;
  }
  
  public String getMd5(String paramString)
  {
    return this.helper.getQarMd5(new File(paramString));
  }
  
  public boolean restoreQar(String paramString1, String paramString2)
  {
    if (initRequiredParam(paramString1, paramString2)) {
      return this.helper.read(paramString1, paramString2);
    }
    return false;
  }
  
  public void setExceptFiles(List<String> paramList)
  {
    this.helper.setExceptFiles(paramList);
  }
  
  public void setUncompressList(List<String> paramList)
  {
    this.helper.setUncompressList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QarFile
 * JD-Core Version:    0.7.0.1
 */