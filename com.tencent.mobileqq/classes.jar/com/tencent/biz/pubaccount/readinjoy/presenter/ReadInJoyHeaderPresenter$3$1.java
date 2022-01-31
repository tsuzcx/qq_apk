package com.tencent.biz.pubaccount.readinjoy.presenter;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import pgd;
import pji;
import pjm;
import rqj;

public class ReadInJoyHeaderPresenter$3$1
  implements Runnable
{
  public ReadInJoyHeaderPresenter$3$1(pjm parampjm) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((pgd)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
      i += 1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("headerUninterestConfirm,");
      if (this.a.b != null) {
        break label139;
      }
    }
    label139:
    for (String str = "null";; str = this.a.b.toString())
    {
      QLog.d("ReadInJoyHeaderPresenter", 2, str);
      pji.a(this.a.jdField_a_of_type_Pji).a(this.a.jdField_a_of_type_Int, localArrayList, this.a.b, this.a.jdField_a_of_type_JavaLangObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter.3.1
 * JD-Core Version:    0.7.0.1
 */