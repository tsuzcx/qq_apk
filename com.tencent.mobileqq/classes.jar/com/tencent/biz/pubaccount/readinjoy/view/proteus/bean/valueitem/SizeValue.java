package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class SizeValue
  extends BaseValue
{
  public static final int MATCH_PARENT = 1001;
  public static final int VALUE_ABSOLUTELY = 1004;
  public static final int VALUE_RELATIVE = 1003;
  public static final int WRAP_CONTENT = 1002;
  public double value;
  public int valueType;
  
  public SizeValue()
  {
    super(1);
  }
  
  public static int getLayoutSize(int paramInt, double paramDouble)
  {
    if (paramInt != 1001)
    {
      if (paramInt != 1002)
      {
        if (paramInt != 1004) {
          return Utils.rp2px(paramDouble);
        }
        return Utils.dp2px(paramDouble);
      }
      return -2;
    }
    return -1;
  }
  
  public int getLayoutSize()
  {
    return getLayoutSize(this.valueType, this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue
 * JD-Core Version:    0.7.0.1
 */