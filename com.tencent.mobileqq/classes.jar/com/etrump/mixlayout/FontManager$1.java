package com.etrump.mixlayout;

import bgae;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import gb;
import java.util.concurrent.atomic.AtomicBoolean;
import l;

public class FontManager$1
  implements Runnable
{
  public FontManager$1(gb paramgb) {}
  
  public void run()
  {
    switch (bgae.a(bgae.a(), "libFounderColorFont_818.so"))
    {
    default: 
      return;
    case 1: 
      ((VasQuickUpdateManager)this.this$0.a.getManager(184)).downloadItem(1004L, "libColorFont_818", "FontManager_initFZEngine");
      return;
    }
    l.a().b.set(true);
    bgae.a(this.this$0.a);
    gb.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.1
 * JD-Core Version:    0.7.0.1
 */