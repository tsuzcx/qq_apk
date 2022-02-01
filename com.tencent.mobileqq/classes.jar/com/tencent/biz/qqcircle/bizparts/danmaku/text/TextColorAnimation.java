package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TextColorAnimation
  extends Animation
{
  private WeakReference<TextCellLayout> a;
  private ArrayList<Integer> b;
  private int c;
  
  public TextColorAnimation(TextCellLayout paramTextCellLayout, ArrayList<Integer> paramArrayList)
  {
    a(paramTextCellLayout, paramArrayList);
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(TextCellLayout paramTextCellLayout, ArrayList<Integer> paramArrayList)
  {
    this.a = new WeakReference(paramTextCellLayout);
    this.b = paramArrayList;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (this.a == null) {
      return;
    }
    paramTransformation = this.b;
    if (paramTransformation != null)
    {
      if (paramTransformation.size() < 2) {
        return;
      }
      if ((TextCellLayout)this.a.get() == null) {
        return;
      }
      float f = 1.0F / (this.b.size() - 1);
      int j = (int)(paramFloat / f);
      f = (paramFloat - j * f) / f;
      int i = j;
      if (j == this.b.size() - 1) {
        i = this.b.size() - 2;
      }
      int k = ((Integer)this.b.get(i)).intValue();
      j = ((Integer)this.b.get(i + 1)).intValue();
      i = j;
      if (paramFloat < 1.0F) {
        i = Color.argb((int)(Color.alpha(k) + (Color.alpha(j) - Color.alpha(k)) * f), (int)(Color.red(k) + (Color.red(j) - Color.red(k)) * f), (int)(Color.green(k) + (Color.green(j) - Color.green(k)) * f), (int)(Color.blue(k) + f * (Color.blue(j) - Color.blue(k))));
      }
      this.c = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextColorAnimation
 * JD-Core Version:    0.7.0.1
 */