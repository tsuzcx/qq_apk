package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import sel;

public class ReadInJoyBaseAdapter$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$4(sel paramsel, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (sel.a(this.this$0) != this.jdField_a_of_type_Long) {}
    label25:
    LinkedList localLinkedList;
    label38:
    label80:
    do
    {
      do
      {
        return;
        int i;
        int j;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          localLinkedList = new LinkedList();
          j = this.jdField_a_of_type_Int;
          if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
            continue;
          }
          if ((j < i) && (j >= 0)) {
            break label80;
          }
        }
        do
        {
          for (;;)
          {
            j += 1;
            break label38;
            i = this.jdField_a_of_type_JavaUtilList.size();
            break label25;
            if (sel.a(this.this$0) != this.jdField_a_of_type_Long) {
              break;
            }
            try
            {
              BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(j);
              sel.a(this.this$0, localLinkedList, j, localBaseArticleInfo);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (sel.a(this.this$0) == this.jdField_a_of_type_Long);
        return;
      } while (sel.a(this.this$0) != this.jdField_a_of_type_Long);
      sel.a(this.this$0, localLinkedList);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */