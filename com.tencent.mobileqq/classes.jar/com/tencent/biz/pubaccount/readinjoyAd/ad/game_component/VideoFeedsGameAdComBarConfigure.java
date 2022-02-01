package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsGameAdComBarConfigure
{
  private static final String a = "VideoFeedsGameAdComBarConfigure";
  private static int b;
  private QQAppInterface c;
  private String d;
  
  public VideoFeedsGameAdComBarConfigure(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.d = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount();
    b = 0;
  }
  
  private int d()
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
      localStringBuilder.append(this.d);
      localStringBuilder.append("VideoFeedsGameAdComBarConfigure_DALIY");
      localIReadInJoyHelper.updateReadInJoySpValue(localStringBuilder.toString(), localInteger);
    }
    if (bool)
    {
      localIReadInJoyHelper = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("VideoFeedsGameAdComBarConfigure_DALIY");
      i = ((Integer)localIReadInJoyHelper.getReadInJoySpValue(localStringBuilder.toString(), localInteger)).intValue();
    }
    return i;
  }
  
  public void a()
  {
    try
    {
      int i = d();
      b += 1;
      IReadInJoyHelper localIReadInJoyHelper = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("VideoFeedsGameAdComBarConfigure_DALIY");
      localIReadInJoyHelper.updateReadInJoySpValue(((StringBuilder)localObject).toString(), Integer.valueOf(i + 1));
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("解析引流条出现的条件出错: ");
        localStringBuilder.append(localException.getMessage());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  public int b()
  {
    return b;
  }
  
  public int c()
  {
    return d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure
 * JD-Core Version:    0.7.0.1
 */