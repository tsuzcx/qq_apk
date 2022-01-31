package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import java.util.ArrayList;
import java.util.Iterator;
import nol;

class ReadInJoySelectMemberAQFragment$3
  implements Runnable
{
  ReadInJoySelectMemberAQFragment$3(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      nol.a(null, "", "0X8009543", "0X8009543", 0, 0, "", "", "", ReadInJoySelectMemberAQFragment.a(this.this$0, localResultRecord, this.jdField_a_of_type_JavaLangString), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment.3
 * JD-Core Version:    0.7.0.1
 */