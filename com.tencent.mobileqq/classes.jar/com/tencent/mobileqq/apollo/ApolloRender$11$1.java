package com.tencent.mobileqq.apollo;

import aisw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApolloRender$11$1
  extends IApolloRunnableTask
{
  public ApolloRender$11$1(aisw paramaisw, Map paramMap, int paramInt, byte[] paramArrayOfByte) {}
  
  public String a()
  {
    return "sendHttpRequest_responseCallback";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {}
    for (Object localObject = new String[0];; localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { "ApolloHttpUtil httpResponseCallback http:", Long.valueOf(this.this$0.jdField_a_of_type_Long), " url:", this.this$0.jdField_a_of_type_JavaLangString, " method:", this.this$0.b });
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.getSavaWrapper().a(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int, (String[])localObject, this.jdField_a_of_type_ArrayOfByte);
      return;
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((ArrayList)localObject).add(localEntry.getKey());
        ((ArrayList)localObject).add(localEntry.getValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.11.1
 * JD-Core Version:    0.7.0.1
 */