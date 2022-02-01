package com.tencent.biz.qqcircle.immersive.utils;

import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class QFSCommonUtil
{
  public static String a()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = HardCodeUtil.a(2131895633);
    } else {
      str = "W";
    }
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean a(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if ((paramStFeed1 != null) && (paramStFeed2 != null)) {
      return paramStFeed1.id.get().equals(paramStFeed2.id.get());
    }
    return false;
  }
  
  public static boolean a(@NonNull FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (a().equals(paramStUser.id.get()));
  }
  
  public static boolean a(String paramString)
  {
    return a().equals(paramString);
  }
  
  public static FeedCloudMeta.StUser b()
  {
    return c();
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return paramString;
      }
      int i = paramString.indexOf("?");
      if (i == -1) {
        return paramString;
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static FeedCloudMeta.StUser c()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(HostDataTransUtils.getAccount());
    localStUser.nick.set(HostDataTransUtils.getAccountNickName(HostDataTransUtils.getAccount()));
    return localStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil
 * JD-Core Version:    0.7.0.1
 */