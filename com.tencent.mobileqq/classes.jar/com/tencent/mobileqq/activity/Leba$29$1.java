package com.tencent.mobileqq.activity;

import abai;
import abat;
import aiba;
import java.util.List;

public class Leba$29$1
  implements Runnable
{
  public Leba$29$1(abat paramabat, List paramList) {}
  
  public void run()
  {
    if (abai.a(this.jdField_a_of_type_Abat.a) != null)
    {
      abai.a(this.jdField_a_of_type_Abat.a).clear();
      abai.a(this.jdField_a_of_type_Abat.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Abat.a.a != null) {
        this.jdField_a_of_type_Abat.a.a.notifyDataSetChanged();
      }
      abai.c(this.jdField_a_of_type_Abat.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.29.1
 * JD-Core Version:    0.7.0.1
 */