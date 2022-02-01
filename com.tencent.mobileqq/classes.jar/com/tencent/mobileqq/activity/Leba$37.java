package com.tencent.mobileqq.activity;

import aewm;
import akgm;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import blkk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class Leba$37
  implements Runnable
{
  Leba$37(Leba paramLeba, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, List paramList) {}
  
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
      blkk.a(Leba.d(this.this$0), 9, this.jdField_a_of_type_Int, 0);
      localObject = this.this$0.a();
      localTextView = Leba.c(this.this$0);
      if (Leba.a(this.this$0).b() == 1)
      {
        bool1 = true;
        blkk.a((Context)localObject, localTextView, 9, bool1);
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
            blkk.a(Leba.f(this.this$0), 8, 0, 0);
            localObject = this.this$0.a();
            localTextView = Leba.f(this.this$0);
            bool1 = bool2;
            if (Leba.a(this.this$0).b() == 1) {
              bool1 = true;
            }
            blkk.a((Context)localObject, localTextView, 8, bool1);
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
          blkk.a(Leba.f(this.this$0), 8, this.jdField_a_of_type_Int, 0);
          localObject = this.this$0.a();
          localTextView = Leba.f(this.this$0);
          bool1 = bool3;
          if (Leba.a(this.this$0).b() == 1) {
            bool1 = true;
          }
          blkk.a((Context)localObject, localTextView, 10, bool1);
          continue;
        }
        if (!this.c) {
          break label532;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QCircleEeveeRedPoint_Leba", 1, "updateQQCircleRedFlag" + localException);
        return;
      }
      if (Leba.e(this.this$0) != null)
      {
        Leba.e(this.this$0).setText(this.jdField_a_of_type_JavaLangString);
        Leba.e(this.this$0).setVisibility(0);
      }
      Leba.f(this.this$0).setVisibility(0);
      blkk.a(Leba.f(this.this$0), 8, 0, 0);
      ViewGroup.LayoutParams localLayoutParams = Leba.f(this.this$0).getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = this.this$0.a().getDimensionPixelSize(2131297058);
        continue;
        label532:
        if (Leba.f(this.this$0) != null) {
          Leba.f(this.this$0).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.37
 * JD-Core Version:    0.7.0.1
 */