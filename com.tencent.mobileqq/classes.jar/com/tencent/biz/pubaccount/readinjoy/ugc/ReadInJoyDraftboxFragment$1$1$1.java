package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import java.util.List;
import qff;
import qfi;

public class ReadInJoyDraftboxFragment$1$1$1
  implements Runnable
{
  public ReadInJoyDraftboxFragment$1$1$1(qfi paramqfi, List paramList) {}
  
  public void run()
  {
    ReadInJoyDraftboxFragment.a(this.jdField_a_of_type_Qfi.a.this$0).clear();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if (ReadInJoyDraftboxFragment.a(localReadInJoyDraftboxItem)) {
          ReadInJoyDraftboxFragment.a(this.jdField_a_of_type_Qfi.a.this$0).add(localReadInJoyDraftboxItem);
        }
        i -= 1;
      }
    }
    ReadInJoyDraftboxFragment.a(this.jdField_a_of_type_Qfi.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */