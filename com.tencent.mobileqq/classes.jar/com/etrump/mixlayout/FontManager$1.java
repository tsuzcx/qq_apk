package com.etrump.mixlayout;

import bdom;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import fx;
import g;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontManager$1
  implements Runnable
{
  public FontManager$1(fx paramfx) {}
  
  public void run()
  {
    switch (bdom.a(bdom.a(), "libFounderColorFont_818.so"))
    {
    default: 
      return;
    case 1: 
      ((VasQuickUpdateManager)this.this$0.a.getManager(184)).downloadItem(1004L, "libColorFont_818", "FontManager_initFZEngine");
      return;
    }
    g.a().b.set(true);
    bdom.a(this.this$0.a);
    fx.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.1
 * JD-Core Version:    0.7.0.1
 */