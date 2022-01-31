package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$CollectionInfoCompat
{
  public static final int SELECTION_MODE_MULTIPLE = 2;
  public static final int SELECTION_MODE_NONE = 0;
  public static final int SELECTION_MODE_SINGLE = 1;
  final Object mInfo;
  
  private AccessibilityNodeInfoCompat$CollectionInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return new CollectionInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3));
  }
  
  public int getColumnCount()
  {
    return AccessibilityNodeInfoCompat.access$000().getCollectionInfoColumnCount(this.mInfo);
  }
  
  public int getRowCount()
  {
    return AccessibilityNodeInfoCompat.access$000().getCollectionInfoRowCount(this.mInfo);
  }
  
  public boolean isHierarchical()
  {
    return AccessibilityNodeInfoCompat.access$000().isCollectionInfoHierarchical(this.mInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat
 * JD-Core Version:    0.7.0.1
 */