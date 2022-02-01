package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloDressInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApolloAEUtil
{
  public static CmShowAssetsData a(ApolloResManagerImpl.ApolloDressInfo paramApolloDressInfo)
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    Iterator localIterator = paramApolloDressInfo.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)localIterator.next()).getValue();
      String str = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + localDress.id).getAbsolutePath();
      localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.put(localDress.attachPart.get(0), str);
      QLog.d("cm_res", 1, "part: " + (String)localDress.attachPart.get(0) + "; dir : " + str);
    }
    localCmShowAssetsData.jdField_a_of_type_JavaLangString = paramApolloDressInfo.b();
    localCmShowAssetsData.b = paramApolloDressInfo.a();
    QLog.d("cm_res", 1, "roleResDir: " + localCmShowAssetsData.jdField_a_of_type_JavaLangString);
    return localCmShowAssetsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloAEUtil
 * JD-Core Version:    0.7.0.1
 */