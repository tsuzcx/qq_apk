package android.content.res;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.callbacks.XC_LayoutInflated.LayoutInflatedParam;
import de.robv.android.xposed.callbacks.XCallback;
import java.util.LinkedList;

final class XResources$3
  extends XC_MethodHook
{
  public void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    ((LinkedList)XResources.access$100().get()).pop();
    if (paramMethodHookParam.hasThrowable()) {}
    XResources.XMLInstanceDetails localXMLInstanceDetails;
    do
    {
      return;
      localXMLInstanceDetails = (XResources.XMLInstanceDetails)paramMethodHookParam.getObjectExtra("xmlInstanceDetails");
    } while (localXMLInstanceDetails == null);
    XC_LayoutInflated.LayoutInflatedParam localLayoutInflatedParam = new XC_LayoutInflated.LayoutInflatedParam(localXMLInstanceDetails.callbacks);
    paramMethodHookParam = paramMethodHookParam.args;
    if (Build.VERSION.SDK_INT < 23) {}
    for (int i = 1;; i = 2)
    {
      paramMethodHookParam = (ViewGroup)paramMethodHookParam[i];
      localLayoutInflatedParam.view = paramMethodHookParam.getChildAt(paramMethodHookParam.getChildCount() - 1);
      localLayoutInflatedParam.resNames = localXMLInstanceDetails.resNames;
      localLayoutInflatedParam.variant = localXMLInstanceDetails.variant;
      localLayoutInflatedParam.res = localXMLInstanceDetails.res;
      XCallback.callAll(localLayoutInflatedParam);
      return;
    }
  }
  
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    ((LinkedList)XResources.access$100().get()).push(paramMethodHookParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.3
 * JD-Core Version:    0.7.0.1
 */