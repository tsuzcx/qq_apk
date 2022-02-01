package androidx.core.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  public static final int HOST_VIEW_ID = -1;
  private final Object mProvider;
  
  public AccessibilityNodeProviderCompat()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.mProvider = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mProvider = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16(this);
      return;
    }
    this.mProvider = null;
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.mProvider = paramObject;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  @Nullable
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return null;
  }
  
  public Object getProvider()
  {
    return this.mProvider;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 * JD-Core Version:    0.7.0.1
 */