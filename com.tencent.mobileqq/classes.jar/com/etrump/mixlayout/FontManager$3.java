package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.Vas.ColorFont.FastColorFontHelper;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VasUtils;
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
    Object localObject1;
    Object localObject2;
    switch (this.a)
    {
    case 2: 
    case 3: 
    default: 
      localObject1 = null;
      localObject2 = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (!VasSoUtils.a((String)localObject2, VasSoUtils.a() + File.separator, (String)localObject1)) {
          break label397;
        }
        if (VasSoUtils.a(VasSoUtils.a(), (String)localObject1) != 0) {
          break label384;
        }
        VasFontIPCModule.a().a(this.a, 0);
        switch (this.a)
        {
        }
      }
      break;
    }
    for (;;)
    {
      VasUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      FontManager.a(this.this$0);
      return;
      localObject2 = FontManager.jdField_a_of_type_JavaLangString + File.separator + "libColorFont.zip";
      localObject1 = "libFounderColorFont_818.so";
      break;
      localObject2 = FontManager.jdField_a_of_type_JavaLangString + File.separator + "libvipfont8417.so.zip";
      localObject1 = "libvipfont8417.so";
      break;
      FastColorFontHelper.a().b.set(true);
      HiBoomFont.a().a();
      continue;
      if ((!TextUtils.isEmpty(this.this$0.e)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("callbackId", this.this$0.e);
        ((Bundle)localObject1).putInt("srcType", 9);
        this.this$0.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(0L, 0, (Bundle)localObject1);
        this.this$0.e = null;
      }
      ETEngine.isSOLoaded.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 0).edit().putBoolean("vip_font_so_downloaded", true).commit();
      HiBoomFont.a().a();
      ((IFontSoLoaderAdapter)QRoute.api(IFontSoLoaderAdapter.class)).setVipFontSoLoad(true);
      this.this$0.a(false);
    }
    label384:
    VasFontIPCModule.a().a(this.a, -102);
    return;
    label397:
    VasFontIPCModule.a().a(this.a, -102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.3
 * JD-Core Version:    0.7.0.1
 */