package com.tencent.mobileqq.activity;

import adgt;
import android.content.Context;
import android.widget.TextView;
import atkv;
import bhvv;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class Leba$38
  implements Runnable
{
  Leba$38(Leba paramLeba, int paramInt1, boolean paramBoolean, int paramInt2, List paramList) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject;
    TextView localTextView;
    boolean bool1;
    if (this.jdField_a_of_type_Int > 0)
    {
      if (Leba.d(this.this$0) != null) {
        Leba.d(this.this$0).setVisibility(0);
      }
      bhvv.a(Leba.d(this.this$0), 9, this.jdField_a_of_type_Int, 0);
      localObject = this.this$0.a();
      localTextView = Leba.c(this.this$0);
      if (Leba.a(this.this$0).b() == 1)
      {
        bool1 = true;
        bhvv.a((Context)localObject, localTextView, 9, bool1);
      }
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Boolean) && (this.b > 0))
        {
          if (Leba.e(this.this$0) != null)
          {
            Leba.e(this.this$0).setVisibility(0);
            bhvv.a(Leba.e(this.this$0), 8, this.jdField_a_of_type_Int, 0);
            localObject = this.this$0.a();
            localTextView = Leba.e(this.this$0);
            bool1 = bool2;
            if (Leba.a(this.this$0).b() == 1) {
              bool1 = true;
            }
            bhvv.a((Context)localObject, localTextView, 8, bool1);
          }
          localObject = new ArrayList();
          if (this.jdField_a_of_type_JavaUtilList != null) {
            ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
          }
          if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0) != null)) {
            Leba.b(this.this$0).a((ArrayList)localObject);
          }
          Leba.e(this.this$0);
          return;
          bool1 = false;
          break;
          if (Leba.d(this.this$0) == null) {
            continue;
          }
          Leba.d(this.this$0).setVisibility(8);
          continue;
        }
        if ((this.jdField_a_of_type_Boolean) && (this.b == 0) && (this.jdField_a_of_type_Int == 0))
        {
          if (Leba.e(this.this$0) == null) {
            continue;
          }
          Leba.e(this.this$0).setVisibility(0);
          bhvv.a(Leba.e(this.this$0), 8, this.jdField_a_of_type_Int, 0);
          localObject = this.this$0.a();
          localTextView = Leba.e(this.this$0);
          bool1 = bool3;
          if (Leba.a(this.this$0).b() == 1) {
            bool1 = true;
          }
          bhvv.a((Context)localObject, localTextView, 10, bool1);
          continue;
        }
        if (Leba.e(this.this$0) == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("Leba", 1, "updateQQCircleRedFlag" + localException);
        return;
      }
      Leba.e(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.38
 * JD-Core Version:    0.7.0.1
 */