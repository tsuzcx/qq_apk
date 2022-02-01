package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;

public class RelativeLayout$Params
  extends Layout.Params
{
  public static final int ABOVE_OF = 0;
  public static final int ALIGN_PARENT_BOTTOM = 7;
  public static final int ALIGN_PARENT_CENTER = 10;
  public static final int ALIGN_PARENT_CENTER_HORIZONTAL = 9;
  public static final int ALIGN_PARENT_CENTER_VERTICAL = 8;
  public static final int ALIGN_PARENT_LEFT = 4;
  public static final int ALIGN_PARENT_RIGHT = 5;
  public static final int ALIGN_PARENT_TOP = 6;
  public static final int BELOW_OF = 1;
  public static final int LEFT_OF = 2;
  public static final int RIGHT_OF = 3;
  public static final int[] RULES_HORIZONTAL = { 2, 3 };
  public static final int[] RULES_VERTICAL = { 0, 1 };
  public static final int RULE_COUNT = 11;
  public boolean alignWithParent;
  public int mBottom;
  public int mLeft;
  public int mRight;
  public int mTop;
  private String[] rule = new String[11];
  
  public String[] getRule()
  {
    return this.rule;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = super.setAttribute(paramInt, paramString);
    if (bool) {
      return bool;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      setRule(3, paramString);
      continue;
      setRule(2, paramString);
      continue;
      setRule(1, paramString);
      continue;
      setRule(0, paramString);
      continue;
      setRule(4, paramString);
      continue;
      setRule(5, paramString);
      continue;
      setRule(6, paramString);
      continue;
      setRule(7, paramString);
      continue;
      setRule(8, paramString);
      continue;
      setRule(9, paramString);
      continue;
      setRule(10, paramString);
    }
  }
  
  public void setRule(int paramInt, String paramString)
  {
    this.rule[paramInt] = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout.Params
 * JD-Core Version:    0.7.0.1
 */