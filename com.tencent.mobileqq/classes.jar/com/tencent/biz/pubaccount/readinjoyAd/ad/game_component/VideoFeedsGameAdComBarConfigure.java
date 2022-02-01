package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsGameAdComBarConfigure
{
  private static int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "VideoFeedsGameAdComBarConfigure";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  public VideoFeedsGameAdComBarConfigure(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount();
    jdField_a_of_type_Int = 0;
  }
  
  private int c()
  {
    boolean bool = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).checkIsVideoFeedsGameAdComBarLocalConfigToday();
    int i = 0;
    Integer localInteger = Integer.valueOf(0);
    IReadInJoyHelper localIReadInJoyHelper;
    StringBuilder localStringBuilder;
    if (!bool)
    {
      localIReadInJoyHelper = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("VideoFeedsGameAdComBarConfigure_DALIY");
      localIReadInJoyHelper.updateReadInJoySpValue(localStringBuilder.toString(), localInteger);
    }
    if (bool)
    {
      localIReadInJoyHelper = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("VideoFeedsGameAdComBarConfigure_DALIY");
      i = ((Integer)localIReadInJoyHelper.getReadInJoySpValue(localStringBuilder.toString(), localInteger)).intValue();
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
      IReadInJoyHelper localIReadInJoyHelper = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("VideoFeedsGameAdComBarConfigure_DALIY");
      localIReadInJoyHelper.updateReadInJoySpValue(((StringBuilder)localObject).toString(), Integer.valueOf(i + 1));
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("解析引流条出现的条件出错: ");
        localStringBuilder.append(localException.getMessage());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  public int b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure
 * JD-Core Version:    0.7.0.1
 */