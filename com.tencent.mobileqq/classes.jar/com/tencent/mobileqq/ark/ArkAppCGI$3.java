package com.tencent.mobileqq.ark;

import java.util.ArrayList;

class ArkAppCGI$3
  implements ArkAppCGI.ITaskHttpResult
{
  ArkAppCGI$3(ArkAppCGI paramArkAppCGI) {}
  
  public void a(ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    paramQueryTask = (ArkAppCGI.QueryTask_GetContextActionAppList)paramQueryTask;
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      paramBoolean = ArkAppCGI.a(paramQueryTask, paramArrayOfByte);
    }
    while ((paramBoolean) && (paramQueryTask.jdField_a_of_type_Boolean))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, more data, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramQueryTask.d.size()), Long.valueOf(paramQueryTask.jdField_c_of_type_Long), Integer.valueOf(paramQueryTask.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramQueryTask.jdField_b_of_type_Long) }));
      ArkAppCGI.a(this.a, paramQueryTask);
      return;
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, request fail, gray-app-id=%d, app-id=%d", new Object[] { Long.valueOf(paramQueryTask.jdField_c_of_type_Long), Long.valueOf(paramQueryTask.jdField_b_of_type_Long) }));
    }
    ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, done, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramQueryTask.d.size()), Long.valueOf(paramQueryTask.jdField_c_of_type_Long), Integer.valueOf(paramQueryTask.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramQueryTask.jdField_b_of_type_Long) }));
    int j = paramQueryTask.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte = paramQueryTask.jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramQueryTask.jdField_c_of_type_JavaUtilArrayList, paramQueryTask.d);
      }
      i += 1;
    }
    paramQueryTask.jdField_b_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.3
 * JD-Core Version:    0.7.0.1
 */