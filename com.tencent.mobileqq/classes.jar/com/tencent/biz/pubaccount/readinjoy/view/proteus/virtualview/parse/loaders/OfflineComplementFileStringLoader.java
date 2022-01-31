package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OfflineComplementFileStringLoader
  implements ComplementFileStringLoader
{
  private String a;
  
  public OfflineComplementFileStringLoader(String paramString)
  {
    this.a = paramString;
  }
  
  public String a(String paramString)
  {
    try
    {
      String str = OfflineUtils.a(new FileInputStream(new File(this.a + "/" + paramString)));
      return str;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OfflineComplementFileStringLoader", 2, "loadFileAsString: fail to include - " + paramString);
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.OfflineComplementFileStringLoader
 * JD-Core Version:    0.7.0.1
 */