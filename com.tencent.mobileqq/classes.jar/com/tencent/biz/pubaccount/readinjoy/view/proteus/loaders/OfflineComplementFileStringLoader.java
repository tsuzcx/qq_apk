package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.ReadFile;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class OfflineComplementFileStringLoader
  implements ComplementFileStringLoader
{
  private ReadFile a;
  
  public OfflineComplementFileStringLoader(ReadFile paramReadFile)
  {
    this.a = paramReadFile;
  }
  
  public String loadFileAsString(String paramString)
  {
    try
    {
      InputStream localInputStream = this.a.a(paramString);
      if (localInputStream == null) {
        throw new IllegalStateException(paramString + " not found");
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OfflineComplementFileStringLoader", 2, "loadFileAsString: fail to include - " + paramString);
        localIOException.printStackTrace();
      }
      return null;
    }
    String str = OfflineUtils.a(localIOException);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.OfflineComplementFileStringLoader
 * JD-Core Version:    0.7.0.1
 */