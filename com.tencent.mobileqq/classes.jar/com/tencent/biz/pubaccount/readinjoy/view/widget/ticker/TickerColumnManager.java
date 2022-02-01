package com.tencent.biz.pubaccount.readinjoy.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class TickerColumnManager
{
  private final TickerDrawMetrics jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerDrawMetrics;
  final ArrayList<TickerColumn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Character> jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean = false;
  private TickerCharacterList[] jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  
  TickerColumnManager(TickerDrawMetrics paramTickerDrawMetrics)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerDrawMetrics = paramTickerDrawMetrics;
  }
  
  float a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      i += 1;
    }
    return f;
  }
  
  void a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramFloat, this.jdField_b_of_type_Boolean);
      i += 1;
    }
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      TickerColumn localTickerColumn = (TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localTickerColumn.a(paramCanvas, paramPaint);
      paramCanvas.translate(localTickerColumn.a(), 0.0F);
      i += 1;
    }
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void a(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList == null) {
      throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a() > 0.0F) {
        i += 1;
      }
      for (;;)
      {
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    int[] arrayOfInt = LevenshteinUtils.a(a(), paramArrayOfChar, this.jdField_a_of_type_JavaUtilSet);
    int i1 = 0;
    int j = 1;
    int k = 1;
    i = 0;
    int m = 0;
    TickerColumn localTickerColumn;
    char[] arrayOfChar1;
    int n;
    boolean bool;
    if (i1 < arrayOfInt.length) {
      switch (arrayOfInt[i1])
      {
      default: 
        throw new IllegalArgumentException("Unknown action: " + arrayOfInt[i1]);
      case 1: 
        this.jdField_a_of_type_JavaUtilArrayList.add(m, new TickerColumn(this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerDrawMetrics));
      case 0: 
        localTickerColumn = (TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        char[] arrayOfChar2 = null;
        arrayOfChar1 = arrayOfChar2;
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          arrayOfChar1 = arrayOfChar2;
          if (this.jdField_b_of_type_JavaUtilArrayList.size() > i1)
          {
            arrayOfChar2 = ((String)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).toCharArray();
            arrayOfChar1 = arrayOfChar2;
            if (arrayOfChar2 != null)
            {
              n = arrayOfChar2.length - 1;
              if (arrayOfChar2.length > 0)
              {
                bool = true;
                label277:
                arrayOfChar1 = arrayOfChar2;
              }
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      localTickerColumn.a(k, paramArrayOfChar[i], this.jdField_b_of_type_Boolean, bool, arrayOfChar1, 0, n);
      int i2 = m + 1;
      i += 1;
      m = i2;
      n = i;
      if (this.jdField_a_of_type_Boolean) {
        if (localTickerColumn.a() == localTickerColumn.b())
        {
          m = i2;
          n = i;
          if (k <= 1) {}
        }
        else
        {
          n = k + j;
          j += 1;
          m = i2;
          k = i;
          i = n;
        }
      }
      for (;;)
      {
        i1 += 1;
        n = k;
        k = i;
        i = n;
        break;
        bool = false;
        break label277;
        ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(m)).a(k, '\000', this.jdField_b_of_type_Boolean);
        i2 = m + 1;
        m = i2;
        n = i;
        if (this.jdField_a_of_type_Boolean)
        {
          m = k + j;
          k = i;
          j += 1;
          i = m;
          m = i2;
        }
        else
        {
          i = k;
          k = n;
        }
      }
      n = 0;
      bool = false;
    }
  }
  
  void a(String... paramVarArgs)
  {
    int j = 0;
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList = new TickerCharacterList[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList[i] = new TickerCharacterList(paramVarArgs[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_JavaUtilSet.addAll(this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList[i].a());
      i += 1;
    }
  }
  
  char[] a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  TickerCharacterList[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewWidgetTickerTickerCharacterList;
  }
  
  float b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerColumnManager
 * JD-Core Version:    0.7.0.1
 */