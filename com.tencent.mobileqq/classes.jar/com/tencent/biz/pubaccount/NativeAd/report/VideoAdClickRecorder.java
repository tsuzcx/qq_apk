package com.tencent.biz.pubaccount.NativeAd.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.List;
import java.util.Vector;

public class VideoAdClickRecorder
{
  static List<String> a = new Vector();
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.getTicket())) {
      return;
    }
    a.add(paramAdvertisementInfo.getTicket());
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.getTicket())) {
      return false;
    }
    return a.contains(paramAdvertisementInfo.getTicket());
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.getTicket())) {
      return;
    }
    a.remove(paramAdvertisementInfo.getTicket());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.VideoAdClickRecorder
 * JD-Core Version:    0.7.0.1
 */