package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$CollectionItemInfoCompat
{
  private final Object mInfo;
  
  private AccessibilityNodeInfoCompat$CollectionItemInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
  }
  
  public int getColumnIndex()
  {
    return AccessibilityNodeInfoCompat.access$000().getCollectionItemColumnIndex(this.mInfo);
  }
  
  public int getColumnSpan()
  {
    return AccessibilityNodeInfoCompat.access$000().getCollectionItemColumnSpan(this.mInfo);
  }
  
  public int getRowIndex()
  {
    return AccessibilityNodeInfoCompat.access$000().getCollectionItemRowIndex(this.mInfo);
  }
  
  public int getRowSpan()
  {
    return AccessibilityNodeInfoCompat.access$000().getCollectionItemRowSpan(this.mInfo);
  }
  
  public boolean isHeading()
  {
    return AccessibilityNodeInfoCompat.access$000().isCollectionItemHeading(this.mInfo);
  }
  
  public boolean isSelected()
  {
    return AccessibilityNodeInfoCompat.access$000().isCollectionItemSelected(this.mInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat
 * JD-Core Version:    0.7.0.1
 */