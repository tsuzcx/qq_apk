package com.etrump.mixlayout;

import bblj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import g;
import ho;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontManager$1
  implements Runnable
{
  public FontManager$1(ho paramho) {}
  
  public void run()
  {
    switch (bblj.a(bblj.a(), "libFounderColorFont_818.so"))
    {
    default: 
      return;
    case 1: 
      ((VasQuickUpdateManager)this.this$0.a.getManager(184)).downloadItem(1004L, VasQuickUpdateManager.SCID_COLORFONT_SO, "FontManager_initFZEngine");
      return;
    }
    g.a().b.set(true);
    bblj.a(this.this$0.a);
    ho.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.1
 * JD-Core Version:    0.7.0.1
 */