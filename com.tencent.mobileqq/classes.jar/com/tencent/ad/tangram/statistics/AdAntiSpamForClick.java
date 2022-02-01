package com.tencent.ad.tangram.statistics;

import android.graphics.Rect;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class AdAntiSpamForClick
{
  private long actionDownTime = -2147483648L;
  private long actionUpTime = -2147483648L;
  private int downTouchX = 0;
  private int downTouchY = 0;
  private boolean hasShowCloseButton = false;
  private int upTouchX = 0;
  private int upTouchY = 0;
  private long videoPlayedDuration = -2147483648L;
  
  public String onClick(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Rect localRect = new Rect();
    long l = System.currentTimeMillis();
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((this.actionUpTime == -2147483648L) || (this.actionDownTime == -2147483648L) || (this.actionUpTime - this.actionDownTime < 0L)) {
          continue;
        }
        localJSONObject.put("g", String.valueOf((int)(this.actionUpTime - this.actionDownTime)));
        if (this.actionUpTime == -2147483648L) {
          continue;
        }
        localJSONObject.put("sc", String.valueOf((int)(l - this.actionUpTime)));
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
        continue;
        localJSONObject.put("sc", "-999");
        continue;
        localJSONObject.put("ec", "-999");
        continue;
        localJSONObject.put("p", "-999");
        continue;
        localJSONObject.put("x", "0");
        continue;
        localJSONObject.put("px", "0");
        localJSONObject.put("py", "0");
        continue;
      }
      if (this.actionDownTime == -2147483648L) {
        continue;
      }
      localJSONObject.put("ec", String.valueOf((int)(l - this.actionDownTime)));
      localJSONObject.put("aa", String.valueOf(this.downTouchX));
      localJSONObject.put("ab", String.valueOf(this.downTouchY));
      localJSONObject.put("ba", String.valueOf(this.upTouchX));
      localJSONObject.put("bb", String.valueOf(this.upTouchY));
      localJSONObject.put("d", "-999");
      if (this.videoPlayedDuration == -2147483648L) {
        continue;
      }
      localJSONObject.put("p", String.valueOf(this.videoPlayedDuration));
      localJSONObject.put("f", "-999");
      if (!this.hasShowCloseButton) {
        continue;
      }
      localJSONObject.put("x", "1");
      localJSONObject.put("sz", "-999");
      localJSONObject.put("da", String.valueOf(paramView.getWidth()));
      localJSONObject.put("db", String.valueOf(paramView.getHeight()));
      if (!paramView.getGlobalVisibleRect(localRect)) {
        continue;
      }
      localJSONObject.put("px", String.valueOf(localRect.left));
      localJSONObject.put("py", String.valueOf(localRect.top));
      if (localJSONObject.length() == 0) {
        break;
      }
      return localJSONObject.toString();
      localJSONObject.put("g", "-999");
    }
  }
  
  public void onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView == null) || (paramMotionEvent == null)) {}
    do
    {
      return;
      if (paramMotionEvent.getAction() == 0)
      {
        this.actionDownTime = System.currentTimeMillis();
        this.downTouchX = ((int)paramMotionEvent.getX());
        this.downTouchY = ((int)paramMotionEvent.getY());
        return;
      }
    } while (paramMotionEvent.getAction() != 1);
    this.actionUpTime = System.currentTimeMillis();
    this.upTouchX = ((int)paramMotionEvent.getX());
    this.upTouchY = ((int)paramMotionEvent.getY());
  }
  
  public void setHasShowCloseButton(boolean paramBoolean)
  {
    this.hasShowCloseButton = paramBoolean;
  }
  
  public void setVideoPlayedDuration(long paramLong)
  {
    this.videoPlayedDuration = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdAntiSpamForClick
 * JD-Core Version:    0.7.0.1
 */