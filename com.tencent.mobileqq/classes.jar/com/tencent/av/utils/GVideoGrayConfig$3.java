package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoHelper;

final class GVideoGrayConfig$3
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  GVideoGrayConfig$3(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, String paramString) {}
  
  private void a(Context paramContext)
  {
    if ((paramContext instanceof JumpActivity)) {
      ((Activity)paramContext).finish();
    }
  }
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      Object localObject;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              a(this.jdField_a_of_type_AndroidContentContext);
              return;
            }
            localObject = this.jdField_a_of_type_AndroidContentContext;
            if ((localObject instanceof Activity))
            {
              GVideoGrayConfig.a((Context)localObject, paramRecord.b, paramRecord.c, new GVideoGrayConfig.3.2(this));
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_AndroidContentContext;
            if ((localObject instanceof Activity))
            {
              GVideoGrayConfig.a((Context)localObject, paramRecord.b, paramRecord.c, new GVideoGrayConfig.3.1(this));
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
            }
          }
        }
        else {
          ((IGroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, "4", "openRoom");
        }
      }
      else
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramRecord.jdField_a_of_type_JavaLangString);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          ((Intent)localObject).addFlags(268435456);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    else
    {
      ((IGroupVideoHelper)QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentIntent, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig.3
 * JD-Core Version:    0.7.0.1
 */