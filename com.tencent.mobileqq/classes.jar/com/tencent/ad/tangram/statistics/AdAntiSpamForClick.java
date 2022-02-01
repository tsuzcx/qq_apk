package com.tencent.ad.tangram.statistics;

import android.graphics.Rect;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ad.tangram.util.AdUIUtils;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public final class AdAntiSpamForClick
{
  private long actionDownTime = -2147483648L;
  private long actionUpTime = -2147483648L;
  private int downTouchX = 0;
  private int downTouchY = 0;
  private boolean hasBeenPaused = false;
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
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((this.actionUpTime != -2147483648L) && (this.actionDownTime != -2147483648L) && (this.actionUpTime - this.actionDownTime >= 0L)) {
          localJSONObject.put("g", String.valueOf((int)(this.actionUpTime - this.actionDownTime)));
        }
        int i = AdUIUtils.px2dp(paramView.getContext(), this.downTouchX);
        if (i != -2147483648) {
          localJSONObject.put("aa", String.valueOf(i));
        }
        i = AdUIUtils.px2dp(paramView.getContext(), this.downTouchY);
        if (i != -2147483648) {
          localJSONObject.put("ab", String.valueOf(i));
        }
        i = AdUIUtils.px2dp(paramView.getContext(), this.upTouchX);
        if (i != -2147483648) {
          localJSONObject.put("ba", String.valueOf(i));
        }
        i = AdUIUtils.px2dp(paramView.getContext(), this.upTouchY);
        if (i != -2147483648) {
          localJSONObject.put("bb", String.valueOf(i));
        }
        if (this.videoPlayedDuration != -2147483648L) {
          localJSONObject.put("p", String.valueOf(this.videoPlayedDuration));
        }
        if (!this.hasBeenPaused) {
          continue;
        }
        str = "1";
        localJSONObject.put("f", str);
        if (!this.hasShowCloseButton) {
          continue;
        }
        str = "1";
        localJSONObject.put("x", str);
        i = AdUIUtils.px2dp(paramView.getContext(), paramView.getWidth());
        if (i != -2147483648) {
          localJSONObject.put("da", String.valueOf(i));
        }
        i = AdUIUtils.px2dp(paramView.getContext(), paramView.getHeight());
        if (i != -2147483648) {
          localJSONObject.put("db", String.valueOf(i));
        }
        if (paramView.getGlobalVisibleRect(localRect))
        {
          i = AdUIUtils.px2dp(paramView.getContext(), localRect.left);
          if (i != -2147483648) {
            localJSONObject.put("px", String.valueOf(i));
          }
          i = AdUIUtils.px2dp(paramView.getContext(), localRect.top);
          if (i != -2147483648) {
            localJSONObject.put("py", String.valueOf(i));
          }
        }
      }
      catch (JSONException paramView)
      {
        String str;
        paramView.printStackTrace();
        continue;
      }
      if (localJSONObject.length() == 0) {
        break;
      }
      return localJSONObject.toString();
      str = "0";
      continue;
      str = "0";
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
  
  public void setHasBeenPaused()
  {
    this.hasBeenPaused = true;
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