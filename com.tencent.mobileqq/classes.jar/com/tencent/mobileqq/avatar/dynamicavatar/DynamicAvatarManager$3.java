package com.tencent.mobileqq.avatar.dynamicavatar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DynamicAvatarManager$3
  implements Runnable
{
  DynamicAvatarManager$3(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, String paramString) {}
  
  public void run()
  {
    synchronized (this.this$0.c)
    {
      boolean bool1 = this.this$0.c.contains(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      if (bool1)
      {
        if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {
          synchronized (this.this$0.c)
          {
            this.this$0.c.remove(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
            synchronized (this.this$0.d)
            {
              if (!this.this$0.d.contains(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference)) {
                this.this$0.d.add(this.this$0.d.size(), this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
              }
            }
          }
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.g))
        {
          DynamicAvatarManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_c_of_type_JavaLangString);
          return;
        }
        Object localObject4 = null;
        try
        {
          ??? = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_JavaLangString);
        }
        catch (NullPointerException localNullPointerException)
        {
          ??? = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.dynamicAvatar", 2, localNullPointerException.getMessage(), localNullPointerException);
            ??? = localObject4;
          }
        }
        if (??? != null)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.e;
          boolean bool2 = true;
          if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.e == 0))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.e == 0 ? !DynamicAvatarManager.a(this.this$0).i : !DynamicAvatarManager.a(this.this$0).j) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if ((!bool1) || (!DynamicUtils.a(System.currentTimeMillis(), ((DynamicAvatar)???).playTimeStamp))) {
              bool2 = false;
            }
            if (bool2)
            {
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("oneDayOnce:");
                ((StringBuilder)???).append(bool1);
                ((StringBuilder)???).append(" playedSameDay:");
                ((StringBuilder)???).append(bool2);
                ((StringBuilder)???).append(" uin:");
                ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
                QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
              }
              synchronized (this.this$0.c)
              {
                this.this$0.c.remove(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
                return;
              }
            }
          }
        }
        Object localObject6 = DynamicAvatarManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_JavaLangString);
        bool1 = DynamicAvatarManager.a(this.this$0, (DynamicAvatar)???, (Setting)localObject6, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_Int);
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("execute loadDynamicAvatarInfo runnable. isNeed2GetDynamicAvatarInfo: ");
          ((StringBuilder)localObject6).append(bool1);
          QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject6).toString());
        }
        if ((!bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.g))
        {
          localObject6 = DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.d, (DynamicAvatar)???);
          ??? = DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_Int, 640, (DynamicAvatar)???);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("execute loadDynamicAvatarInfo runnable. url : ");
            localStringBuilder.append((String)localObject6);
            QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
          DynamicAvatarManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, (String)localObject6, (String)???);
          return;
        }
        for (;;)
        {
          try
          {
            ((DynamicAvatarInfoHandler)DynamicAvatarManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.DYNAMIC_AVATAR_HANDLER)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.d, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_c_of_type_Boolean);
            return;
          }
          catch (Exception localException)
          {
            continue;
          }
          synchronized (this.this$0.c)
          {
            this.this$0.c.remove(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
            return;
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.3
 * JD-Core Version:    0.7.0.1
 */