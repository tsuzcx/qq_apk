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
    switch (paramInt)
    {
    case 1003: 
    default: 
      return Utils.rp2px(paramDouble);
    case 1001: 
      return -1;
    case 1002: 
      return -2;
    }
    return Utils.dp2px(paramDouble);
  }
  
  public int getLayoutSize()
  {
    return getLayoutSize(this.valueType, this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue
 * JD-Core Version:    0.7.0.1
 */