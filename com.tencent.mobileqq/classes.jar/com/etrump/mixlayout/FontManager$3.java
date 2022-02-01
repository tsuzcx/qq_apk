package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.Vas.ColorFont.FastColorFontHelper;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class FontManager$3
  implements Runnable
{
  FontManager$3(FontManager paramFontManager, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject1;
    Object localObject2;
    if (i != 1)
    {
      if (i != 4)
      {
        localObject1 = null;
        localObject2 = localObject1;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("libColorFont.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = "libFounderColorFont_818.so";
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("libvipfont8417.so.zip");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = "libvipfont8417.so";
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VasSoUtils.a());
      localStringBuilder.append(File.separator);
      if (VasSoUtils.a((String)localObject1, localStringBuilder.toString(), (String)localObject2))
      {
        if (VasSoUtils.a(VasSoUtils.a(), (String)localObject2) == 0)
        {
          VasFontIPCModule.a().a(this.a, 0);
          i = this.a;
          if (i != 1)
          {
            if (i == 4)
            {
              FastColorFontHelper.a().c.set(true);
              HiBoomFont.a().b();
            }
          }
          else
          {
            if ((!TextUtils.isEmpty(this.this$0.k)) && (FontManager.c(this.this$0) != null))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("callbackId", this.this$0.k);
              ((Bundle)localObject1).putInt("srcType", 9);
              FontManager.c(this.this$0).a(0L, 0, (Bundle)localObject1);
              this.this$0.k = null;
            }
            ETEngine.isSOLoaded.set(true);
            BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 0).edit().putBoolean("vip_font_so_downloaded", true).commit();
            HiBoomFont.a().b();
            ((IFontSoLoaderAdapter)QRoute.api(IFontSoLoaderAdapter.class)).setVipFontSoLoad(true);
            FontManager.a(this.this$0, false);
          }
          VasUtils.a(FontManager.a(this.this$0));
          FontManager.b(this.this$0);
          return;
        }
        VasFontIPCModule.a().a(this.a, -102);
        return;
      }
      VasFontIPCModule.a().a(this.a, -102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.3
 * JD-Core Version:    0.7.0.1
 */