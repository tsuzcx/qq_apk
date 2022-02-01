package com.tencent.av.business.manager.support;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

public class SupportZimu
  extends SupportBase
{
  int g = -1;
  int h = -1;
  boolean i = false;
  
  public SupportZimu(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveSupportMessage type:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString);
    AVLog.printColorLog("SupportZimu", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString.split("\\|");
      paramString = null;
      if (localObject.length > 0) {
        paramString = localObject[0];
      }
      if (paramInt != 7)
      {
        if (paramInt != 12)
        {
          if (paramInt == 13) {
            if ("SUPPORT_TRUE".equalsIgnoreCase(paramString)) {
              this.i = true;
            } else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString)) {
              this.i = false;
            }
          }
        }
        else if ("SUPPORT_TRUE".equalsIgnoreCase(paramString)) {
          this.g = 1;
        } else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString)) {
          this.g = 0;
        }
      }
      else if ("SUPPORT_TRUE".equalsIgnoreCase(paramString)) {
        this.h = 1;
      } else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString)) {
        this.h = 0;
      }
      if (("SUPPORT_TRUE".equalsIgnoreCase(paramString)) || ("SUPPORT_FALSE".equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public int b(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    VideoController localVideoController = this.f.b();
    localVideoController.e(12, "SUPPORT_TRUE");
    localVideoController.e(13, "SUPPORT_TRUE");
    AVLog.printColorLog("SupportZimu", "sendSupportMsg");
  }
  
  public void c()
  {
    this.g = -1;
    this.h = -1;
    this.i = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportZimu
 * JD-Core Version:    0.7.0.1
 */