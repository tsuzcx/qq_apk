package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class VideoFeedsGameAdComBarConfigure
{
  private static int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = VideoFeedsGameAdComBarConfigure.class.getSimpleName();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  public VideoFeedsGameAdComBarConfigure(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = ReadInJoyUtils.a();
    jdField_a_of_type_Int = 0;
  }
  
  private int c()
  {
    int i = 0;
    boolean bool = ReadInJoyHelper.G(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!bool) {
      ReadInJoyHelper.a(this.b + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(0));
    }
    if (bool) {
      i = ((Integer)ReadInJoyHelper.a(this.b + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(0))).intValue();
    }
    return i;
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    try
    {
      int i = c();
      jdField_a_of_type_Int += 1;
      ReadInJoyHelper.a(this.b + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(i + 1));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "解析引流条出现的条件出错: " + localException.getMessage());
    }
  }
  
  public int b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure
 * JD-Core Version:    0.7.0.1
 */