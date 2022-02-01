package com.etrump.mixlayout;

import com.Vas.ColorFont.FastColorFontHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import java.util.concurrent.atomic.AtomicBoolean;

class FontManager$1
  implements Runnable
{
  FontManager$1(FontManager paramFontManager) {}
  
  public void run()
  {
    int i = VasSoUtils.a(VasSoUtils.a(), "libFounderColorFont_818.so");
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      ((IVasQuickUpdateService)FontManager.a(this.this$0).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libColorFont_818", "FontManager_initFZEngine");
      return;
    }
    FastColorFontHelper.a().c.set(true);
    VasUtils.a(FontManager.a(this.this$0));
    FontManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.1
 * JD-Core Version:    0.7.0.1
 */