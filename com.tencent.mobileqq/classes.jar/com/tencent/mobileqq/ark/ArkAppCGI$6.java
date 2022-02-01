package com.tencent.mobileqq.ark;

import java.util.ArrayList;

class ArkAppCGI$6
  implements ArkAppCGI.ITaskHttpResult
{
  public void a(ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((!paramBoolean) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("getPredownloadAppList: fail, url=%s", new Object[] { paramQueryTask.jdField_a_of_type_JavaLangString }));
    }
    for (;;)
    {
      int i = 0;
      while (i < paramQueryTask.b.size())
      {
        paramArrayOfByte = paramQueryTask.jdField_a_of_type_JavaUtilArrayList.get(i);
        ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask.b.get(i);
        if (localArkAppCGICallback != null) {
          localArkAppCGICallback.a(paramBoolean, localArrayList1, localArrayList2, paramArrayOfByte);
        }
        i += 1;
      }
      ArkAppCGI.a(this.a, paramArrayOfByte, localArrayList1, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.6
 * JD-Core Version:    0.7.0.1
 */