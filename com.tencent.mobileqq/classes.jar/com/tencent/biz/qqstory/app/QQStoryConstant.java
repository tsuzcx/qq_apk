package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;

@TargetApi(14)
public class QQStoryConstant
{
  public static final String a = HardCodeUtil.a(2131897681);
  public static final String b = HardCodeUtil.a(2131897680);
  public static final String c;
  public static boolean d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final String l;
  public static final String m;
  public static final String n;
  public static final String o;
  public static final String p;
  public static final String q;
  public static final String r;
  public static final String s;
  public static final String t;
  public static final String u;
  public static final String v;
  public static final String w;
  public static final Boolean x = Boolean.valueOf(true);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/tencent/qq/music/");
    c = localStringBuilder.toString();
    d = AppSetting.b().contains("r");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.a);
    localStringBuilder.append("/qqstory/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append("debug/");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append("upload/");
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(".music/");
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(".tmp/");
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("download/preload/");
    j = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("download/mine/");
    k = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(".tmp/");
    l = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("watermark/");
    m = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("merge/");
    n = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("audio/");
    o = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("video/");
    p = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("slideshow/");
    q = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("textfilter/");
    r = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("pk/result/");
    s = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("source/");
    t = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("doodle/");
    u = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("composite/");
    v = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("download/");
    w = localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "UNKNOWN";
        }
        return "THUMBNAIL";
      }
      return "MASK_PIC";
    }
    return "VIDEO";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryConstant
 * JD-Core Version:    0.7.0.1
 */