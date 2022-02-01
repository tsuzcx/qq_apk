package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import java.util.ArrayList;

public class UiElementFixedCache$MeasuredTextResult
{
  public ArrayList<TextCellLayout.MeasuredLine> a;
  public ArrayList<Integer> b;
  public int c;
  
  public UiElementFixedCache$MeasuredTextResult(ArrayList<TextCellLayout.MeasuredLine> paramArrayList, ArrayList<Integer> paramArrayList1, int paramInt)
  {
    this.a = ((ArrayList)paramArrayList.clone());
    this.b = ((ArrayList)paramArrayList1.clone());
    this.c = paramInt;
  }
  
  public MeasuredTextResult a()
  {
    return new MeasuredTextResult(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.UiElementFixedCache.MeasuredTextResult
 * JD-Core Version:    0.7.0.1
 */