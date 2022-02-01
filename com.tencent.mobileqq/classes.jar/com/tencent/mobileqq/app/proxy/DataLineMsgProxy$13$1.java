package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.Iterator;
import java.util.List;

class DataLineMsgProxy$13$1
  implements Runnable
{
  DataLineMsgProxy$13$1(DataLineMsgProxy.13 param13, List paramList) {}
  
  public void run()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = j;
      if (DataLineMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy$13.this$0) != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
          if (!DataLineMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy$13.this$0).insertFrontToList(localDataLineMsgRecord)) {
            break label107;
          }
          i += 1;
        }
      }
    }
    label107:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy$13.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy$13.a.a(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13.1
 * JD-Core Version:    0.7.0.1
 */