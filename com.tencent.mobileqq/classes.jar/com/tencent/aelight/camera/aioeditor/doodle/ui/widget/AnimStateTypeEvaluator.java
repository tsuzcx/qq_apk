package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import java.util.ArrayList;

public class AnimStateTypeEvaluator
  implements TypeEvaluator<ArrayList<Integer>>
{
  private ArrayList<AnimStateTypeEvaluator.AnimInfo> a = new ArrayList();
  private ArrayList<Integer> b = new ArrayList();
  private ArrayList<Integer> c = new ArrayList();
  private ArrayList<Integer> d = new ArrayList();
  private ArrayList<TimeInterpolator> e = new ArrayList();
  private long f = 0L;
  
  public int a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, TimeInterpolator paramTimeInterpolator)
  {
    int i = this.c.size();
    paramString = new AnimStateTypeEvaluator.AnimInfo(paramLong1, paramLong2, i);
    this.a.add(paramString);
    this.c.add(Integer.valueOf(paramInt1));
    this.d.add(Integer.valueOf(paramInt2));
    this.e.add(paramTimeInterpolator);
    paramLong1 += paramLong2;
    if (paramLong1 > this.f) {
      this.f = paramLong1;
    }
    return i;
  }
  
  public ArrayList<Integer> a()
  {
    return this.d;
  }
  
  public ArrayList<Integer> a(float paramFloat, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (!paramArrayList1.isEmpty())
    {
      if (paramArrayList2.isEmpty()) {
        return null;
      }
      if (paramArrayList1.size() != paramArrayList2.size()) {
        return null;
      }
      int j = paramArrayList1.size();
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.clear();
      int i = 0;
      while (i < j)
      {
        int k = ((Integer)paramArrayList1.get(i)).intValue();
        int m = ((Integer)paramArrayList2.get(i)).intValue();
        long l1 = ((AnimStateTypeEvaluator.AnimInfo)this.a.get(i)).a;
        long l2 = ((AnimStateTypeEvaluator.AnimInfo)this.a.get(i)).b;
        long l3 = (int)((float)this.f * paramFloat);
        if (l3 < l1)
        {
          this.b.add(Integer.valueOf(0));
        }
        else if (l3 > l1 + l2)
        {
          this.b.add(Integer.valueOf(m));
        }
        else
        {
          float f1 = ((TimeInterpolator)this.e.get(i)).getInterpolation((float)(l3 - l1) / (float)l2);
          this.b.add(Integer.valueOf((int)(k + (m - k) * f1)));
        }
        i += 1;
      }
      return this.b;
    }
    return null;
  }
  
  public ArrayList<Integer> a(long paramLong)
  {
    return a((float)paramLong / (float)this.f, this.c, this.d);
  }
  
  public ArrayList<Integer> b()
  {
    return this.c;
  }
  
  public long c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.AnimStateTypeEvaluator
 * JD-Core Version:    0.7.0.1
 */