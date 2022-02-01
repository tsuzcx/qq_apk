package com.tencent.biz.pubaccount.weishi_new.player;

import android.view.View;

public class WSPlayerUtils$PlayerLayoutParams
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  int c;
  int d;
  
  public WSPlayerUtils$PlayerLayoutParams(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayerLayoutParams{videoWidth=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", topBarHeight=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", bottomBarHeight=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils.PlayerLayoutParams
 * JD-Core Version:    0.7.0.1
 */