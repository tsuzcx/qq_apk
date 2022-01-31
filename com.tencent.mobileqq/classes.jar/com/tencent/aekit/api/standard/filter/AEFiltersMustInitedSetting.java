package com.tencent.aekit.api.standard.filter;

import android.util.Log;
import java.util.HashMap;
import java.util.Vector;

public class AEFiltersMustInitedSetting
{
  private Vector<Integer> FILTERS_MUST_INITED_FIRST_FRAME;
  private final String TAG = "AEFiltersMustSetting";
  private long mAllFiltersInitedValue = 0L;
  private long mShiftValue = 1L;
  private long mSumApplied = 0L;
  private HashMap<Integer, Long> mTypeValueMap;
  
  public AEFiltersMustInitedSetting(int... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      this.FILTERS_MUST_INITED_FIRST_FRAME = new Vector();
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        int k = paramVarArgs[i];
        if (this.FILTERS_MUST_INITED_FIRST_FRAME.contains(Integer.valueOf(k))) {}
        for (;;)
        {
          i += 1;
          break;
          this.FILTERS_MUST_INITED_FIRST_FRAME.add(Integer.valueOf(k));
          addNewType(k);
        }
      }
    }
  }
  
  private void addNewType(int paramInt)
  {
    if (this.mTypeValueMap == null) {
      this.mTypeValueMap = new HashMap();
    }
    if (!this.mTypeValueMap.containsKey(Integer.valueOf(paramInt)))
    {
      this.mTypeValueMap.put(Integer.valueOf(paramInt), Long.valueOf(this.mShiftValue));
      this.mShiftValue <<= 1;
    }
  }
  
  public void appliedType(int paramInt)
  {
    this.mSumApplied |= getTypeValue(paramInt);
    Log.i("AEFiltersMustSetting", paramInt + "|appliedType:" + this.mSumApplied);
  }
  
  public long getTypeValue(int paramInt)
  {
    if ((this.mTypeValueMap != null) && (this.mTypeValueMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((Long)this.mTypeValueMap.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
  
  public boolean isContainType(int paramInt)
  {
    return (this.FILTERS_MUST_INITED_FIRST_FRAME != null) && (this.FILTERS_MUST_INITED_FIRST_FRAME.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean isMustFiltersInited()
  {
    return this.mSumApplied == this.mAllFiltersInitedValue;
  }
  
  public int mustInitCount()
  {
    if (this.FILTERS_MUST_INITED_FIRST_FRAME != null) {
      return this.FILTERS_MUST_INITED_FIRST_FRAME.size();
    }
    return 0;
  }
  
  public void reset()
  {
    this.mSumApplied = 0L;
  }
  
  public void updateAllFilterInitedValue(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (mustInitCount() == 0)) {
      return;
    }
    this.mAllFiltersInitedValue = 0L;
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = this.mAllFiltersInitedValue;
      this.mAllFiltersInitedValue = (getTypeValue(k) | l);
      i += 1;
    }
    Log.i("AEFiltersMustSetting", "updateAllFilterInitedValue：" + this.mAllFiltersInitedValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFiltersMustInitedSetting
 * JD-Core Version:    0.7.0.1
 */