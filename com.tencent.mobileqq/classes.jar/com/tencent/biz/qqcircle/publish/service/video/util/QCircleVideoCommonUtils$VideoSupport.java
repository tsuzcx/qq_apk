package com.tencent.biz.qqcircle.publish.service.video.util;

import com.tencent.biz.qqcircle.utils.HardCodeUtil;

public class QCircleVideoCommonUtils$VideoSupport
{
  public static final VideoSupport a = new VideoSupport(true, HardCodeUtil.a(2131910053), false, false);
  public static final VideoSupport b = new VideoSupport(false, "CPU指令集不支持", false, true);
  public static final VideoSupport c = new VideoSupport(false, HardCodeUtil.a(2131910038), false, true);
  public static final VideoSupport d = new VideoSupport(false, HardCodeUtil.a(2131910016), false, true);
  public static final VideoSupport e = new VideoSupport(false, HardCodeUtil.a(2131910023), false, true);
  public static final VideoSupport f = new VideoSupport(false, HardCodeUtil.a(2131910027), true, true);
  public static final VideoSupport g = new VideoSupport(false, HardCodeUtil.a(2131910037), true, true);
  public static final VideoSupport h = new VideoSupport(false, HardCodeUtil.a(2131910002), false, true);
  public static final VideoSupport i = new VideoSupport(false, HardCodeUtil.a(2131910085), true, true);
  private boolean j;
  private String k;
  private boolean l;
  private boolean m;
  
  QCircleVideoCommonUtils$VideoSupport(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.j = paramBoolean1;
    this.k = paramString;
    this.l = paramBoolean2;
    this.m = paramBoolean3;
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public String b()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.util.QCircleVideoCommonUtils.VideoSupport
 * JD-Core Version:    0.7.0.1
 */