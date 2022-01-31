package com.tencent.av.widget.stageview;

import android.graphics.drawable.Drawable;

public class StageEffectView$StageMember
{
  public Drawable a;
  public MemberEffect a;
  public final String a;
  public String b;
  
  public StageEffectView$StageMember(String paramString1, String paramString2, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.b = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof StageMember)) && (((StageMember)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.StageMember
 * JD-Core Version:    0.7.0.1
 */