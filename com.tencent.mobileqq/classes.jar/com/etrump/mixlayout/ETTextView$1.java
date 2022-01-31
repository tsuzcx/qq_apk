package com.etrump.mixlayout;

import android.view.View;
import axkm;
import bbgc;
import com.tencent.qphone.base.util.QLog;
import fh;

public class ETTextView$1
  implements Runnable
{
  ETTextView$1(ETTextView paramETTextView) {}
  
  public void run()
  {
    if (this.this$0.getTag(2131302152) != null) {}
    for (boolean bool = ((Boolean)this.this$0.getTag(2131302152)).booleanValue();; bool = false)
    {
      if ((this.this$0.g) && (this.this$0.jdField_a_of_type_Bbgc != null) && (!bool))
      {
        if (this.this$0.d())
        {
          Object localObject = this.this$0.jdField_a_of_type_Fh.a(this.this$0.d, this.this$0.e);
          if ((localObject instanceof axkm))
          {
            localObject = (axkm)localObject;
            this.this$0.b = ((axkm)localObject).e;
            this.this$0.c = ((axkm)localObject).f;
            if (QLog.isColorLevel()) {
              QLog.d("ETTextView", 2, "click span: " + this.this$0.b);
            }
          }
        }
        this.this$0.jdField_a_of_type_Bbgc.a(this.this$0);
      }
      this.this$0.setTag(2131302152, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.1
 * JD-Core Version:    0.7.0.1
 */