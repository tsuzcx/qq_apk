package com.tencent.mobileqq.avatar.dynamicavatar;

import android.text.TextUtils;
import aobo;
import apub;
import apuj;
import apul;
import apux;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DynamicAvatarManager$3
  implements Runnable
{
  public DynamicAvatarManager$3(apul paramapul, aobo paramaobo, String paramString) {}
  
  public void run()
  {
    synchronized (this.this$0.c)
    {
      bool1 = this.this$0.c.contains(this.jdField_a_of_type_Aobo.jdField_b_of_type_MqqUtilWeakReference);
      if (bool1)
      {
        if (aobo.jdField_b_of_type_Boolean) {}
        synchronized (this.this$0.c)
        {
          this.this$0.c.remove(this.jdField_a_of_type_Aobo.jdField_b_of_type_MqqUtilWeakReference);
          synchronized (this.this$0.d)
          {
            if (!this.this$0.d.contains(this.jdField_a_of_type_Aobo.jdField_b_of_type_MqqUtilWeakReference)) {
              this.this$0.d.add(this.this$0.d.size(), this.jdField_a_of_type_Aobo.jdField_b_of_type_MqqUtilWeakReference);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Aobo.jdField_b_of_type_JavaLangString)) {
              if (!this.jdField_a_of_type_Aobo.g) {
                break label678;
              }
            }
          }
        }
      }
    }
    DynamicAvatar localDynamicAvatar;
    try
    {
      ??? = this.this$0.a(this.jdField_a_of_type_Aobo.jdField_c_of_type_Int, this.jdField_a_of_type_Aobo.jdField_a_of_type_JavaLangString);
      if ((??? != null) && ((this.jdField_a_of_type_Aobo.e == 1) || (this.jdField_a_of_type_Aobo.e == 0))) {
        if (this.jdField_a_of_type_Aobo.e == 0) {
          if (!apul.a(this.this$0).i)
          {
            bool1 = true;
            if ((!bool1) || (!apux.a(System.currentTimeMillis(), ((DynamicAvatar)???).playTimeStamp))) {
              break label402;
            }
            bool2 = true;
            if (!bool2) {
              break label414;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "oneDayOnce:" + bool1 + " playedSameDay:" + bool2 + " uin:" + this.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      synchronized (this.this$0.c)
      {
        for (;;)
        {
          this.this$0.c.remove(this.jdField_a_of_type_Aobo.jdField_b_of_type_MqqUtilWeakReference);
          return;
          localObject3 = finally;
          throw localObject3;
          localObject4 = finally;
          throw localObject4;
          localObject5 = finally;
          throw localObject5;
          localNullPointerException = localNullPointerException;
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, localNullPointerException.getMessage(), localNullPointerException);
          }
          localDynamicAvatar = null;
          continue;
          bool1 = false;
          continue;
          if (!apul.a(this.this$0).j) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        label402:
        boolean bool2 = false;
      }
    }
    label414:
    Setting localSetting = apul.a(this.this$0, this.jdField_a_of_type_Aobo.jdField_c_of_type_Int, this.jdField_a_of_type_Aobo.jdField_a_of_type_JavaLangString);
    boolean bool1 = apul.a(this.this$0, localDynamicAvatar, localSetting, this.jdField_a_of_type_Aobo.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "execute loadDynamicAvatarInfo runnable. isNeed2GetDynamicAvatarInfo: " + bool1);
    }
    if ((bool1) || (this.jdField_a_of_type_Aobo.g)) {
      try
      {
        ((apuj)apul.a(this.this$0).getBusinessHandler(97)).a(Long.valueOf(this.jdField_a_of_type_Aobo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Aobo.jdField_c_of_type_Int, this.jdField_a_of_type_Aobo.jdField_b_of_type_Int, this.jdField_a_of_type_Aobo.d, this.jdField_a_of_type_Aobo.jdField_c_of_type_Boolean);
        return;
      }
      catch (Exception localException)
      {
        synchronized (this.this$0.c)
        {
          this.this$0.c.remove(this.jdField_a_of_type_Aobo.jdField_b_of_type_MqqUtilWeakReference);
          return;
        }
      }
    }
    String str = apul.a(this.jdField_a_of_type_Aobo.jdField_b_of_type_Int, this.jdField_a_of_type_Aobo.d, (DynamicAvatar)???);
    ??? = apul.a(this.jdField_a_of_type_Aobo.jdField_b_of_type_Int, 640, (DynamicAvatar)???);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "execute loadDynamicAvatarInfo runnable. url : " + str);
    }
    apul.a(this.this$0, this.jdField_a_of_type_JavaLangString, str, (String)???);
    return;
    label678:
    apul.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aobo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aobo.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.3
 * JD-Core Version:    0.7.0.1
 */