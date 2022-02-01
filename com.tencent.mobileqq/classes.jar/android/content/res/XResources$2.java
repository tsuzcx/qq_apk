package android.content.res;

import android.view.View;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.callbacks.XC_LayoutInflated.LayoutInflatedParam;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.callbacks.XCallback.Param;
import java.util.WeakHashMap;

final class XResources$2
  extends XC_MethodHook
{
  public void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.hasThrowable()) {}
    for (;;)
    {
      return;
      synchronized (XResources.access$000())
      {
        XResources.XMLInstanceDetails localXMLInstanceDetails = (XResources.XMLInstanceDetails)XResources.access$000().get(paramMethodHookParam.args[0]);
        if (localXMLInstanceDetails == null) {
          continue;
        }
        ??? = new XC_LayoutInflated.LayoutInflatedParam(localXMLInstanceDetails.callbacks);
        ((XC_LayoutInflated.LayoutInflatedParam)???).view = ((View)paramMethodHookParam.getResult());
        ((XC_LayoutInflated.LayoutInflatedParam)???).resNames = localXMLInstanceDetails.resNames;
        ((XC_LayoutInflated.LayoutInflatedParam)???).variant = localXMLInstanceDetails.variant;
        ((XC_LayoutInflated.LayoutInflatedParam)???).res = localXMLInstanceDetails.res;
        XCallback.callAll((XCallback.Param)???);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.2
 * JD-Core Version:    0.7.0.1
 */