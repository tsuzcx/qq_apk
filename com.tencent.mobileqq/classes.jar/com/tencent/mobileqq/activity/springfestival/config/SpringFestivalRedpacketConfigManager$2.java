package com.tencent.mobileqq.activity.springfestival.config;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class SpringFestivalRedpacketConfigManager$2
  implements AsyncBack
{
  SpringFestivalRedpacketConfigManager$2(SpringFestivalRedpacketConfigManager paramSpringFestivalRedpacketConfigManager, String paramString, int paramInt) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CODE_SUCCESS[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramString == null))
    {
      Utils.a(SpringFestivalRedpacketConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfigManager), SpringFestivalRedpacketConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfigManager).getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int + 1);
      Utils.a(SpringFestivalRedpacketConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfigManager), SpringFestivalRedpacketConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfigManager).getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, NetConnInfoCenter.getServerTimeMillis());
    }
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("progress[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager.2
 * JD-Core Version:    0.7.0.1
 */