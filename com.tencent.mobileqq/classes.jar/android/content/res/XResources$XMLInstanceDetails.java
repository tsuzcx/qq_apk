package android.content.res;

import de.robv.android.xposed.XposedBridge.CopyOnWriteSortedSet;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

class XResources$XMLInstanceDetails
{
  public final XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks;
  public final XResources res = this.this$0;
  public final XResources.ResourceNames resNames;
  public final String variant;
  
  private XResources$XMLInstanceDetails(XResources.ResourceNames paramResourceNames, String paramString, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> paramCopyOnWriteSortedSet)
  {
    this.resNames = paramString;
    this.variant = paramCopyOnWriteSortedSet;
    Object localObject;
    this.callbacks = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.XMLInstanceDetails
 * JD-Core Version:    0.7.0.1
 */