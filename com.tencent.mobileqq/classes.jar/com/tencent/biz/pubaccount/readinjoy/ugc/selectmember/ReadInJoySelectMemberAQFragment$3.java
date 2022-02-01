package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;

class ReadInJoySelectMemberAQFragment$3
  implements Runnable
{
  ReadInJoySelectMemberAQFragment$3(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ResultRecord)localIterator.next();
      localObject = ReadInJoySelectMemberAQFragment.a(this.this$0, (ResultRecord)localObject, this.jdField_a_of_type_JavaLangString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009543", "0X8009543", 0, 0, "", "", "", (String)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment.3
 * JD-Core Version:    0.7.0.1
 */