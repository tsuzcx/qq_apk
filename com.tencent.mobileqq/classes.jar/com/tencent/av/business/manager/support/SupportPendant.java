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
  
  private boolean b()
  {
    if (c()) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Int < 17)
      {
        AVLog.c("SupportPendant", "isUserEffectFace error  OSversion:" + this.jdField_a_of_type_Int);
        return false;
      }
      if (this.jdField_b_of_type_Int < 4)
      {
        AVLog.c("SupportPendant", "isUserEffectFace error cpucount:" + this.jdField_b_of_type_Int);
        return false;
      }
      if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long < 1400000L))
      {
        AVLog.c("SupportPendant", "isUserEffectFace error cpuFrequency:" + this.jdField_a_of_type_Long);
        return false;
      }
    } while (this.jdField_b_of_type_Long >= 1073741824L);
    AVLog.c("SupportPendant", "isUserEffectFace error  memory:" + this.jdField_b_of_type_Long);
    return false;
  }
  
  private static boolean c()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  public int a(String paramString)
  {
    return 0;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ("ptu_so".equalsIgnoreCase(paramString)) {
      return a();
    }
    return b();
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportPendant
 * JD-Core Version:    0.7.0.1
 */