package com.tencent.mobileqq.app.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class RegisterProxyHandler$CheckDisMsgComplete
{
  private int jdField_a_of_type_Int;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private int b;
  
  public RegisterProxyHandler$CheckDisMsgComplete(RegisterProxyHandler paramRegisterProxyHandler, StringBuilder paramStringBuilder, int paramInt)
  {
    this.jdField_a_of_type_JavaLangStringBuilder = paramStringBuilder;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CheckDisMsgComplete a()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_JavaUtilHashMap.size();
    MessageCache localMessageCache = (MessageCache)RegisterProxyHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler).a().getMsgCache();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    int i;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      String str = (String)localIterator.next();
      long l2 = localMessageCache.i(str);
      Object localObject = localMessageCache.a(str);
      long l1;
      if ((localObject != null) && (localObject.length > 0)) {
        l1 = ((Long)localObject[1]).longValue();
      } else {
        l1 = 0L;
      }
      if (((localMessageCache.a(false)) || (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_JavaUtilHashMap.get(str)).booleanValue())) && (l2 < l1))
      {
        if (QLog.isColorLevel())
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          localObject = this.jdField_a_of_type_JavaLangStringBuilder;
          ((StringBuilder)localObject).append("---------checkGroupMsgComplete needToPullDiscuss discussUin: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",lastSeq:");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(",svrSeq:");
          ((StringBuilder)localObject).append(l1);
          QLog.d("RegisterProxyHandler", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_Int = localArrayList.size();
      this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_Int];
      while (i < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_ArrayOfJavaLangString[i] = ((String)localArrayList.get(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_b_of_type_JavaUtilHashMap.clear();
    return this;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.RegisterProxyHandler.CheckDisMsgComplete
 * JD-Core Version:    0.7.0.1
 */