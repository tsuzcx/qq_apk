package com.tencent.mobileqq.activity;

import aegr;
import ajzt;
import android.content.Context;
import android.widget.TextView;
import blas;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class Leba$35
  implements Runnable
{
  Leba$35(Leba paramLeba, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4, List paramList) {}
  
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
      blas.a(Leba.d(this.this$0), 9, this.jdField_a_of_type_Int, 0);
      localObject = this.this$0.a();
      localTextView = Leba.c(this.this$0);
      if (Leba.a(this.this$0).b() == 1)
      {
        bool1 = true;
        blas.a((Context)localObject, localTextView, 9, bool1);
        label93:
        if (Leba.e(this.this$0) != null) {
          Leba.e(this.this$0).setVisibility(8);
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (Leba.f(this.this$0) != null)
          {
            Leba.f(this.this$0).setVisibility(0);
            blas.a(Leba.f(this.this$0), 8, 0, 0);
            localObject = this.this$0.a();
            localTextView = Leba.f(this.this$0);
            bool1 = bool2;
            if (Leba.a(this.this$0).b() == 1) {
              bool1 = true;
            }
            blas.a((Context)localObject, localTextView, 8, bool1);
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
            break label93;
          }
          Leba.d(this.this$0).setVisibility(8);
          break label93;
        }
        if (this.b)
        {
          if (Leba.f(this.this$0) == null) {
            continue;
          }
          Leba.f(this.this$0).setVisibility(0);
          blas.a(Leba.f(this.this$0), 8, this.jdField_a_of_type_Int, 0);
          localObject = this.this$0.a();
          localTextView = Leba.f(this.this$0);
          bool1 = bool3;
          if (Leba.a(this.this$0).b() == 1) {
            bool1 = true;
          }
          blas.a((Context)localObject, localTextView, 10, bool1);
          continue;
        }
        if (!this.c) {
          break label443;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QCircleEeveeRedPoint_Leba", 1, "updateQQCircleRedFlag" + localException);
        return;
      }
      Leba.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      continue;
      label443:
      if (this.d) {
        Leba.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      } else if (Leba.f(this.this$0) != null) {
        Leba.f(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35
 * JD-Core Version:    0.7.0.1
 */