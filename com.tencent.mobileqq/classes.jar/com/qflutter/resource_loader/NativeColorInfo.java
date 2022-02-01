package com.qflutter.resource_loader;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Map;

public class NativeColorInfo
{
  static final int[] state_disabled = { -16842910 };
  static final int[] state_focused;
  static final int[] state_pressed = { 16842919, 16842910 };
  static final int[] state_selected;
  public Integer color;
  public ColorStateList colorStateList;
  public String name;
  public Integer resId;
  
  static
  {
    state_focused = new int[] { 16842908, 16842910 };
    state_selected = new int[] { 16842913, 16842910 };
  }
  
  public NativeColorInfo(String paramString)
  {
    this.name = paramString;
  }
  
  public Map<String, Integer> buildFlutterReply(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    ColorStateList localColorStateList2 = this.colorStateList;
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = localColorStateList2;
      if (this.resId != null) {
        localColorStateList1 = paramContext.getResources().getColorStateList(this.resId.intValue());
      }
    }
    if (localColorStateList1 != null)
    {
      int i = localColorStateList1.getDefaultColor();
      int j = localColorStateList1.getColorForState(state_pressed, i);
      int k = localColorStateList1.getColorForState(state_focused, i);
      int m = localColorStateList1.getColorForState(state_selected, i);
      int n = localColorStateList1.getColorForState(state_disabled, i);
      if (j != i) {
        localHashMap.put("p", Integer.valueOf(j));
      }
      if (k != i) {
        localHashMap.put("f", Integer.valueOf(k));
      }
      if (m != i) {
        localHashMap.put("s", Integer.valueOf(m));
      }
      if (n != i) {
        localHashMap.put("d", Integer.valueOf(n));
      }
      paramContext = Integer.valueOf(i);
    }
    else
    {
      paramContext = this.color;
      if (paramContext == null) {
        break label218;
      }
    }
    localHashMap.put("n", paramContext);
    return localHashMap;
    label218:
    return null;
  }
  
  public boolean isNull()
  {
    return (this.resId == null) && (this.colorStateList == null) && (this.color == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.resource_loader.NativeColorInfo
 * JD-Core Version:    0.7.0.1
 */