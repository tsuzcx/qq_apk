package android.content.res;

import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import java.util.LinkedList;

final class XResources$1
  extends ThreadLocal<LinkedList<XC_MethodHook.MethodHookParam>>
{
  protected LinkedList<XC_MethodHook.MethodHookParam> initialValue()
  {
    return new LinkedList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.1
 * JD-Core Version:    0.7.0.1
 */