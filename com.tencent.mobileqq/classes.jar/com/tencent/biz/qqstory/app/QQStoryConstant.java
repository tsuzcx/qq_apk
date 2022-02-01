package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;

@TargetApi(14)
public class QQStoryConstant
{
  public static final Boolean a;
  public static final String a;
  public static boolean a;
  public static final String b;
  public static final String c;
  public static final String d;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131699648);
    b = HardCodeUtil.a(2131699647);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/tencent/qq/music/");
    c = localStringBuilder.toString();
    jdField_a_of_type_Boolean = AppSetting.a().contains("r");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/qqstory/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("debug/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("upload/");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(f);
    localStringBuilder.append(".music/");
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(".tmp/");
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(h);
    localStringBuilder.append("download/preload/");
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(h);
    localStringBuilder.append("download/mine/");
    j = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(h);
    localStringBuilder.append(".tmp/");
    k = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("watermark/");
    l = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("merge/");
    m = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("audio/");
    n = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("video/");
    o = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("slideshow/");
    p = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("textfilter/");
    q = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("pk/result/");
    r = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("source/");
    s = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("doodle/");
    t = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("composite/");
    u = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("download/");
    v = localStringBuilder.toString();
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryConstant
 * JD-Core Version:    0.7.0.1
 */