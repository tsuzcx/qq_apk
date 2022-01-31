package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$RangeInfoCompat
{
  public static final int RANGE_TYPE_FLOAT = 1;
  public static final int RANGE_TYPE_INT = 0;
  public static final int RANGE_TYPE_PERCENT = 2;
  private final Object mInfo;
  
  private AccessibilityNodeInfoCompat$RangeInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public float getCurrent()
  {
    return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
  }
  
  public float getMax()
  {
    return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
  }
  
  public float getMin()
  {
    return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
  }
  
  public int getType()
  {
    return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat
 * JD-Core Version:    0.7.0.1
 */