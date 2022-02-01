package com.taobao.android.dexposed;

import com.tencent.qa.apphook.GalileoBackupMethod;
import com.tencent.qa.apphook.GalileoHookManager;
import com.tencent.qa.apphook.util.GalileoHookHelper;
import com.tencent.yahfa.apphook.YahfaHookManager;
import com.tencent.yahfa.apphook.YahfaLog;
import de.robv.android.xposed.callbacks.IXUnhook;
import java.lang.reflect.Member;

public class XC_MethodHook$Unhook
  implements IXUnhook<XC_MethodHook>
{
  private Member backupMethod;
  private GalileoBackupMethod galileoBackupMethod;
  private final Member hookMethod;
  private int hookType;
  
  public XC_MethodHook$Unhook(XC_MethodHook paramXC_MethodHook, Member paramMember)
  {
    this.hookMethod = paramMember;
  }
  
  public XC_MethodHook getCallback()
  {
    return this.this$0;
  }
  
  public Member getHookedMethod()
  {
    return this.hookMethod;
  }
  
  public void setBackupMethod(Member paramMember)
  {
    this.backupMethod = paramMember;
  }
  
  public void setGalileoBackupMethod(GalileoBackupMethod paramGalileoBackupMethod)
  {
    this.galileoBackupMethod = paramGalileoBackupMethod;
  }
  
  public void setHookType(int paramInt)
  {
    this.hookType = paramInt;
  }
  
  public void unhook()
  {
    if (this.hookType == 1) {
      DexposedBridge.unhookMethod(this.hookMethod, this.this$0);
    }
    do
    {
      do
      {
        return;
        if (this.hookType != 2) {
          break;
        }
      } while (this.galileoBackupMethod == null);
      this.galileoBackupMethod.setCallback(null);
      GalileoHookManager.unhookBackMethod(this.galileoBackupMethod);
      return;
    } while (this.hookType != 3);
    if ((this.hookMethod != null) && (this.backupMethod != null)) {
      YahfaLog.d("unhook method name is " + this.hookMethod.getName() + ",hookMethod is " + this.hookMethod + ",backupMethod is " + this.backupMethod);
    }
    YahfaHookManager.unhookMethod(GalileoHookHelper.getSignName(this.hookMethod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.XC_MethodHook.Unhook
 * JD-Core Version:    0.7.0.1
 */