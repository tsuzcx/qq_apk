package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import java.util.ArrayList;

public class AnimStateTypeEvaluator
  implements TypeEvaluator<ArrayList<Integer>>
{
  private long jdField_a_of_type_Long = 0L;
  private ArrayList<AnimStateTypeEvaluator.AnimInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<Integer> b = new ArrayList();
  private ArrayList<Integer> c = new ArrayList();
  private ArrayList<Integer> d = new ArrayList();
  private ArrayList<TimeInterpolator> e = new ArrayList();
  
  public int a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, TimeInterpolator paramTimeInterpolator)
  {
    int i = this.c.size();
    paramString = new AnimStateTypeEvaluator.AnimInfo(paramLong1, paramLong2, i);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.c.add(Integer.valueOf(paramInt1));
    this.d.add(Integer.valueOf(paramInt2));
    this.e.add(paramTimeInterpolator);
    paramLong1 += paramLong2;
    if (paramLong1 > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = paramLong1;
    }
    return i;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
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
        long l1 = ((AnimStateTypeEvaluator.AnimInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long;
        long l2 = ((AnimStateTypeEvaluator.AnimInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b;
        long l3 = (int)((float)this.jdField_a_of_type_Long * paramFloat);
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
          float f = ((TimeInterpolator)this.e.get(i)).getInterpolation((float)(l3 - l1) / (float)l2);
          this.b.add(Integer.valueOf((int)(k + (m - k) * f)));
        }
        i += 1;
      }
      return this.b;
    }
    return null;
  }
  
  public ArrayList<Integer> a(long paramLong)
  {
    return a((float)paramLong / (float)this.jdField_a_of_type_Long, this.c, this.d);
  }
  
  public ArrayList<Integer> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.AnimStateTypeEvaluator
 * JD-Core Version:    0.7.0.1
 */