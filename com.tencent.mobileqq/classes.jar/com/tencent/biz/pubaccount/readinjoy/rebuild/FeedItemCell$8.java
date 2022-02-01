package com.tencent.biz.pubaccount.readinjoy.rebuild;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ppu;
import qjh;
import sel;

public class FeedItemCell$8
  implements Runnable
{
  public FeedItemCell$8(qjh paramqjh, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ppu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
      i += 1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("headerUninterestConfirm,");
      if (this.b != null) {
        break label123;
      }
    }
    label123:
    for (String str = "null";; str = this.b.toString())
    {
      QLog.d("FeedItemCell", 2, str);
      this.this$0.a.a(this.jdField_a_of_type_Int, localArrayList, this.b, this.jdField_a_of_type_JavaLangObject, false, this.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.8
 * JD-Core Version:    0.7.0.1
 */