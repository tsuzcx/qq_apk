package com.tencent.av.business.manager.magicface;

import android.graphics.Point;
import com.tencent.av.utils.AudioHelper;
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
  String common_id;
  int exptype = 0;
  int fps = 8;
  int frame_count = 0;
  boolean hasMirrorRes = false;
  boolean hasbackground = false;
  int height = 0;
  int lastLocationIndex = -1;
  protected int location_x = 0;
  protected int location_y = 0;
  boolean persistent = false;
  public ArrayList<Point> pointArrayList = new ArrayList();
  int repeat_count = 1;
  String src_prefix;
  String tips;
  int width = 0;
  boolean withdeco = false;
  
  public Point getLocation(int paramInt)
  {
    int k = this.pointArrayList.size();
    if (k == 0) {
      return emptyPoint;
    }
    int i;
    if (AudioHelper.a(14) == 1)
    {
      i = paramInt;
    }
    else
    {
      double d1 = Math.random();
      double d2 = k;
      Double.isNaN(d2);
      i = (int)(d1 * d2);
    }
    int j = i;
    if (i == paramInt) {
      j = i + 1;
    }
    paramInt = j % k;
    this.lastLocationIndex = paramInt;
    return (Point)this.pointArrayList.get(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MagicfaceDataVideoJason{src_prefix='");
    localStringBuilder.append(this.src_prefix);
    localStringBuilder.append('\'');
    localStringBuilder.append(", withdeco=");
    localStringBuilder.append(this.withdeco);
    localStringBuilder.append(", persistent=");
    localStringBuilder.append(this.persistent);
    localStringBuilder.append(", hasMirrorRes=");
    localStringBuilder.append(this.hasMirrorRes);
    localStringBuilder.append(", location_x=");
    localStringBuilder.append(this.location_x);
    localStringBuilder.append(", location_y=");
    localStringBuilder.append(this.location_y);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", fps=");
    localStringBuilder.append(this.fps);
    localStringBuilder.append(", frame_count=");
    localStringBuilder.append(this.frame_count);
    localStringBuilder.append(", repeat_count=");
    localStringBuilder.append(this.repeat_count);
    localStringBuilder.append(", exptype=");
    localStringBuilder.append(this.exptype);
    localStringBuilder.append(", common_id='");
    localStringBuilder.append(this.common_id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasbackground='");
    localStringBuilder.append(this.hasbackground);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pointArrayList='");
    localStringBuilder.append(this.pointArrayList.size());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason
 * JD-Core Version:    0.7.0.1
 */