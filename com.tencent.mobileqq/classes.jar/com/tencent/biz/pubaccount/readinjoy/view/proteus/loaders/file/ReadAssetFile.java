package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadAssetFile
  implements ReadFile
{
  private AssetManager jdField_a_of_type_AndroidContentResAssetManager;
  private String jdField_a_of_type_JavaLangString;
  
  public ReadAssetFile(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentResAssetManager = paramContext.getAssets();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public InputStream a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentResAssetManager.open(this.jdField_a_of_type_JavaLangString + "/" + paramString);
  }
  
  public List<String> a()
  {
    try
    {
      localList = OfflineUtils.a(this.jdField_a_of_type_AndroidContentResAssetManager, this.jdField_a_of_type_JavaLangString);
      if (localList == null) {
        break label28;
      }
    }
    catch (Exception localException)
    {
      label28:
      do
      {
        List localList;
        QLog.d("ReadAssetFile", 1, "tryLoadTemplateFromAssets fileList size: ", localException);
        arrayOfString = this.jdField_a_of_type_AndroidContentResAssetManager.list(this.jdField_a_of_type_JavaLangString);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (arrayOfString == null);
      j = arrayOfString.length;
      i = 0;
    }
    return localList;
    for (;;)
    {
      String[] arrayOfString;
      ArrayList localArrayList;
      int j;
      int i;
      Object localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.ReadAssetFile
 * JD-Core Version:    0.7.0.1
 */