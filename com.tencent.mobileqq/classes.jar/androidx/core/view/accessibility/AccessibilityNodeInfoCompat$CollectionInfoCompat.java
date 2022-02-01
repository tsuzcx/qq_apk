package androidx.core.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public class AccessibilityNodeInfoCompat$CollectionInfoCompat
{
  public static final int SELECTION_MODE_MULTIPLE = 2;
  public static final int SELECTION_MODE_NONE = 0;
  public static final int SELECTION_MODE_SINGLE = 1;
  final Object mInfo;
  
  AccessibilityNodeInfoCompat$CollectionInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
    }
    return new CollectionInfoCompat(null);
  }
  
  public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3));
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
    }
    return new CollectionInfoCompat(null);
  }
  
  public int getColumnCount()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getColumnCount();
    }
    return 0;
  }
  
  public int getRowCount()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getRowCount();
    }
    return 0;
  }
  
  public int getSelectionMode()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getSelectionMode();
    }
    return 0;
  }
  
  public boolean isHierarchical()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).isHierarchical();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat
 * JD-Core Version:    0.7.0.1
 */