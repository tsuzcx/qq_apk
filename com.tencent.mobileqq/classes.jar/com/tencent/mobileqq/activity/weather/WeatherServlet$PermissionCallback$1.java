package com.tencent.mobileqq.activity.weather;

import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.NewIntent;

class WeatherServlet$PermissionCallback$1
  implements Runnable
{
  WeatherServlet$PermissionCallback$1(WeatherServlet.PermissionCallback paramPermissionCallback, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("adcode", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.WeatherServlet.PermissionCallback.1
 * JD-Core Version:    0.7.0.1
 */