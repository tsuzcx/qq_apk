package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mhp;
import mhr;

public abstract class QavListItemBase
  extends LinearLayout
  implements View.OnClickListener
{
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  final String jdField_a_of_type_JavaLangString;
  mhp jdField_a_of_type_Mhp;
  
  public QavListItemBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt) {}
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public void a(int paramInt, mhp parammhp)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Mhp = parammhp;
  }
  
  public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, mhr parammhr, mhp parammhp);
  
  public void a(mhr parammhr, int paramInt) {}
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mhp != null)
    {
      long l = AudioHelper.b();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onClick, seq[" + l + "], mPosition[" + this.jdField_a_of_type_Int + "]");
      this.jdField_a_of_type_Mhp.a(l, this.jdField_a_of_type_Int, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public abstract void setHighlight(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemBase
 * JD-Core Version:    0.7.0.1
 */