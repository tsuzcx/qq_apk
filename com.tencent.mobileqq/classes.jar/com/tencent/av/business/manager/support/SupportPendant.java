package com.tencent.av.business.manager.support;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class SupportPendant
  extends SupportBase
{
  public SupportPendant(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private boolean d()
  {
    if (e()) {
      return true;
    }
    StringBuilder localStringBuilder;
    if (this.b < 17)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserEffectFace error  OSversion:");
      localStringBuilder.append(this.b);
      AVLog.printColorLog("SupportPendant", localStringBuilder.toString());
      return false;
    }
    if (this.d < 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserEffectFace error cpucount:");
      localStringBuilder.append(this.d);
      AVLog.printColorLog("SupportPendant", localStringBuilder.toString());
      return false;
    }
    if ((this.c != 0L) && (this.c < 1400000L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserEffectFace error cpuFrequency:");
      localStringBuilder.append(this.c);
      AVLog.printColorLog("SupportPendant", localStringBuilder.toString());
      return false;
    }
    if (this.e < 1073741824L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserEffectFace error  memory:");
      localStringBuilder.append(this.e);
      AVLog.printColorLog("SupportPendant", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private static boolean e()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return d();
  }
  
  public int b(String paramString)
  {
    return 0;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportPendant
 * JD-Core Version:    0.7.0.1
 */