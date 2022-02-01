package com.tencent.av.business.manager.magicface;

import android.graphics.Point;
import com.tencent.mobileqq.utils.AudioHelper;
import java.util.ArrayList;

public class MagicfaceDataVideoJason
{
  public static final String Background = "background/background.png";
  public static final int DECORATION_DURATION = 3;
  public static final int DECORATION_DURATION_MAX = 50000;
  public static final int MATCH_PARENT = -1;
  private static final String TAG = "MagicfaceDataJason";
  public static final String VIDEO_SRC = "video";
  public static final String VIDEO_SRC_MIRROR = "mirror";
  public static final String VIDEO_SRC_NORMAL = "normal";
  static Point emptyPoint = new Point(0, 0);
  public String common_id;
  int exptype = 0;
  public int fps = 8;
  public int frame_count = 0;
  public boolean hasMirrorRes = false;
  public boolean hasbackground = false;
  public int height = 0;
  public int lastLocationIndex = -1;
  public int location_x;
  public int location_y;
  public boolean persistent = false;
  public ArrayList<Point> pointArrayList = new ArrayList();
  public int repeat_count = 1;
  public String src_prefix;
  public String tips;
  public int width = 0;
  boolean withdeco = false;
  
  public Point getLocation(int paramInt)
  {
    int k = this.pointArrayList.size();
    if (k == 0) {
      return emptyPoint;
    }
    if (AudioHelper.a(14) == 1) {}
    for (int i = paramInt;; i = (int)(Math.random() * k))
    {
      int j = i;
      if (i == paramInt) {
        j = i + 1;
      }
      paramInt = j % k;
      this.lastLocationIndex = paramInt;
      return (Point)this.pointArrayList.get(paramInt);
    }
  }
  
  public String toString()
  {
    return "MagicfaceDataVideoJason{src_prefix='" + this.src_prefix + '\'' + ", withdeco=" + this.withdeco + ", persistent=" + this.persistent + ", hasMirrorRes=" + this.hasMirrorRes + ", location_x=" + this.location_x + ", location_y=" + this.location_y + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", frame_count=" + this.frame_count + ", repeat_count=" + this.repeat_count + ", exptype=" + this.exptype + ", common_id='" + this.common_id + '\'' + ", hasbackground='" + this.hasbackground + '\'' + ", pointArrayList='" + this.pointArrayList.size() + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason
 * JD-Core Version:    0.7.0.1
 */