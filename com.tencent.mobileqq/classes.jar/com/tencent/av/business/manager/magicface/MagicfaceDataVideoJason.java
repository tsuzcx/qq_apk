package com.tencent.av.business.manager.magicface;

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
  String common_id;
  int exptype = 0;
  int fps = 8;
  int frame_count = 0;
  boolean hasMirrorRes = false;
  boolean hasbackground = false;
  int height = 0;
  int location_x = 0;
  int location_y = 0;
  boolean persistent = false;
  int repeat_count = 1;
  String src_prefix;
  String tips;
  int width = 0;
  boolean withdeco = false;
  
  public String toString()
  {
    return "MagicfaceDataVideoJason{src_prefix='" + this.src_prefix + '\'' + ", withdeco=" + this.withdeco + ", persistent=" + this.persistent + ", hasMirrorRes=" + this.hasMirrorRes + ", location_x=" + this.location_x + ", location_y=" + this.location_y + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", frame_count=" + this.frame_count + ", repeat_count=" + this.repeat_count + ", exptype=" + this.exptype + ", common_id='" + this.common_id + '\'' + ", hasbackground='" + this.hasbackground + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason
 * JD-Core Version:    0.7.0.1
 */