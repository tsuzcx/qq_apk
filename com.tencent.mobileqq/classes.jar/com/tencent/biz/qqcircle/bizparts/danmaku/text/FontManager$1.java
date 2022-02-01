package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import cooperation.qzone.LocalMultiProcConfig;
import vga;

public final class FontManager$1
  implements Runnable
{
  public void run()
  {
    vga.a(Boolean.valueOf(LocalMultiProcConfig.getBool("qzone_font_enabled", true)));
    vga.b(Boolean.valueOf(LocalMultiProcConfig.getBool("qzone_super_font_enabled", true)));
    vga.c(Boolean.valueOf(LocalMultiProcConfig.getBool("qzone_barrage_effect_enabled", true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.FontManager.1
 * JD-Core Version:    0.7.0.1
 */