package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Rect;
import java.util.ArrayList;

public class TextCellLayout$MeasuredLine
{
  private ArrayList<TextCell> a;
  private ArrayList<Rect> b;
  private int c;
  private int d;
  
  private void d()
  {
    if (this.a == null) {
      this.a = new ArrayList(1);
    }
    if (this.b == null) {
      this.b = new ArrayList(1);
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public TextCell a(int paramInt)
  {
    TextCell localTextCell = null;
    if (paramInt < 0) {
      return null;
    }
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      localTextCell = (TextCell)localArrayList.get(paramInt);
    }
    return localTextCell;
  }
  
  public void a(TextCell paramTextCell, Rect paramRect)
  {
    d();
    this.a.add(paramTextCell);
    this.b.add(paramRect);
    if (paramRect != null) {
      this.c += paramRect.width();
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public Rect b(int paramInt)
  {
    Rect localRect = null;
    if (paramInt < 0) {
      return null;
    }
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      localRect = (Rect)localArrayList.get(paramInt);
    }
    return localRect;
  }
  
  public int c()
  {
    ArrayList localArrayList = this.a;
    if ((localArrayList != null) && (this.b != null))
    {
      int i = localArrayList.size();
      int j = this.b.size();
      if (i < j) {
        return i;
      }
      return j;
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int j = ((ArrayList)localObject).size();
    if (paramInt >= j) {
      return;
    }
    int i = 0;
    while (i < j - paramInt)
    {
      localObject = this.a;
      int k = j - i - 1;
      ((ArrayList)localObject).remove(k);
      localObject = (Rect)this.b.remove(k);
      if (localObject != null) {
        this.c -= ((Rect)localObject).width();
      }
      i += 1;
    }
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.MeasuredLine
 * JD-Core Version:    0.7.0.1
 */