package com.tencent.biz.qqstory.utils;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;

public class LocationUtils
{
  public static BasicLocation a(com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    BasicLocation localBasicLocation2 = LbsManager.a();
    BasicLocation localBasicLocation1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localBasicLocation1 = null;
      paramEditVideoParams = paramEditVideoParams.a;
      if ((paramEditVideoParams instanceof EditLocalVideoSource))
      {
        paramEditVideoParams = ((EditLocalVideoSource)paramEditVideoParams).a;
        j = paramEditVideoParams.latitude;
        i = paramEditVideoParams.longitude;
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0))
      {
        localBasicLocation1 = new BasicLocation(j, i, 0);
        SLog.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localBasicLocation1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localBasicLocation2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localBasicLocation1;
    }
  }
  
  public static BasicLocation a(dov.com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    BasicLocation localBasicLocation2 = LbsManager.a();
    BasicLocation localBasicLocation1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localBasicLocation1 = null;
      paramEditVideoParams = paramEditVideoParams.a;
      if ((paramEditVideoParams instanceof EditLocalVideoSource))
      {
        paramEditVideoParams = ((EditLocalVideoSource)paramEditVideoParams).a;
        j = paramEditVideoParams.latitude;
        i = paramEditVideoParams.longitude;
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0))
      {
        localBasicLocation1 = new BasicLocation(j, i, 0);
        SLog.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localBasicLocation1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localBasicLocation2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localBasicLocation1;
    }
  }
  
  public static Long a()
  {
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    if (TextUtils.isEmpty(str))
    {
      SLog.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      SLog.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(l));
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      SLog.e("LocationUtils", "getCityCode() cityCode is not number!");
      CaughtExceptionReport.a(StoryDebugUtils.StoryExceptionCallback.a("LocationUtils getCityCode() error", localNumberFormatException), "LocationUtils getCityCode() error");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.LocationUtils
 * JD-Core Version:    0.7.0.1
 */