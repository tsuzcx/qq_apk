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
    switch (VasSoUtils.a(VasSoUtils.a(), "libFounderColorFont_818.so"))
    {
    default: 
      return;
    case 1: 
      ((IVasQuickUpdateService)this.this$0.a.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libColorFont_818", "FontManager_initFZEngine");
      return;
    }
    FastColorFontHelper.a().b.set(true);
    VasUtils.a(this.this$0.a);
    FontManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.1
 * JD-Core Version:    0.7.0.1
 */