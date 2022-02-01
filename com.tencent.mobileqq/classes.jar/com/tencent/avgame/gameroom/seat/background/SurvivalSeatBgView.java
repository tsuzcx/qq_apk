package com.tencent.avgame.gameroom.seat.background;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;
import nin;
import nkj;
import nko;
import nkp;

public class SurvivalSeatBgView
  extends GridView
{
  private nkj jdField_a_of_type_Nkj;
  private nko jdField_a_of_type_Nko;
  
  public SurvivalSeatBgView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SurvivalSeatBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SurvivalSeatBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setNumColumns(12);
    setVerticalScrollBarEnabled(false);
    setClickable(false);
    this.jdField_a_of_type_Nkj = new nkp();
    this.jdField_a_of_type_Nko = new nko(getContext(), this.jdField_a_of_type_Nkj);
  }
  
  public nkj a()
  {
    return this.jdField_a_of_type_Nkj;
  }
  
  public void a()
  {
    setAdapter(this.jdField_a_of_type_Nko);
    if (QLog.isDevelopLevel()) {
      QLog.d("SurvivalSeatBgView", 4, "init SurvivalSeatBgView " + nin.y);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgView
 * JD-Core Version:    0.7.0.1
 */