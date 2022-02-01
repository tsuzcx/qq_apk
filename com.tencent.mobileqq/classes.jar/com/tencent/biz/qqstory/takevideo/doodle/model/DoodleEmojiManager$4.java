package com.tencent.biz.qqstory.takevideo.doodle.model;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class DoodleEmojiManager$4
  implements LocationListener
{
  DoodleEmojiManager$4(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      SLog.a("DoodleEmojiManager", "onLocationChanged, location : %s", paramLocation);
      if (this.a.b.size() >= 10)
      {
        this.a.b.remove(0);
        SLog.b("DoodleEmojiManager", "onLocationChanged, LocationList size > 5, remove the first location.");
      }
      this.a.b.add(new Location(paramLocation));
      return;
    }
    SLog.d("DoodleEmojiManager", "onLocationChanged, location is null.");
  }
  
  public void onProviderDisabled(String paramString)
  {
    SLog.a("DoodleEmojiManager", "onProviderDisabled, provider: %s .", paramString);
  }
  
  public void onProviderEnabled(String paramString)
  {
    SLog.a("DoodleEmojiManager", "onProviderEnabled, provider: %s .", paramString);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    SLog.a("DoodleEmojiManager", "onStatusChanged, provider: %s , status: %s .", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.4
 * JD-Core Version:    0.7.0.1
 */