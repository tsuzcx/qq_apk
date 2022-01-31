package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class AssetsComplementFileStringLoader
  implements ComplementFileStringLoader
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  
  public AssetsComplementFileStringLoader(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getAssets();
    try
    {
      localObject = OfflineUtils.a(((AssetManager)localObject).open(this.jdField_a_of_type_JavaLangString + "/" + paramString));
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AssetsComplementFileStringLoader", 2, "loadFileAsString: fail to include - " + paramString);
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.AssetsComplementFileStringLoader
 * JD-Core Version:    0.7.0.1
 */