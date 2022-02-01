package androidx.core.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;

public class AccessibilityNodeInfoCompat$RangeInfoCompat
{
  public static final int RANGE_TYPE_FLOAT = 1;
  public static final int RANGE_TYPE_INT = 0;
  public static final int RANGE_TYPE_PERCENT = 2;
  final Object mInfo;
  
  AccessibilityNodeInfoCompat$RangeInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static RangeInfoCompat obtain(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(paramInt, paramFloat1, paramFloat2, paramFloat3));
    }
    return new RangeInfoCompat(null);
  }
  
  public float getCurrent()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getCurrent();
    }
    return 0.0F;
  }
  
  public float getMax()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMax();
    }
    return 0.0F;
  }
  
  public float getMin()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMin();
    }
    return 0.0F;
  }
  
  public int getType()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getType();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat
 * JD-Core Version:    0.7.0.1
 */