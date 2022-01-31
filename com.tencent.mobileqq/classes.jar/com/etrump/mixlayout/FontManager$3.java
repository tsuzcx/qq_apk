package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import aqcx;
import bajo;
import bats;
import com.tencent.qphone.base.util.BaseApplication;
import fv;
import g;
import gd;
import gf;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontManager$3
  implements Runnable
{
  public FontManager$3(fv paramfv, int paramInt) {}
  
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
        if (!bajo.a((String)localObject2, bajo.a() + File.separator, (String)localObject1)) {
          break label390;
        }
        if (bajo.a(bajo.a(), (String)localObject1) != 0) {
          break label377;
        }
        gf.a().a(this.a, 0);
        switch (this.a)
        {
        }
      }
      break;
    }
    for (;;)
    {
      bajo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      fv.a(this.this$0);
      return;
      localObject2 = fv.jdField_a_of_type_JavaLangString + File.separator + "libColorFont.zip";
      localObject1 = "libFounderColorFont_818.so";
      break;
      localObject2 = fv.jdField_a_of_type_JavaLangString + File.separator + "libVipFont.zip";
      localObject1 = "libvipfont808.so";
      break;
      g.a().b.set(true);
      aqcx.a().a();
      continue;
      if ((!TextUtils.isEmpty(this.this$0.e)) && (this.this$0.jdField_a_of_type_Bats != null))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("callbackId", this.this$0.e);
        ((Bundle)localObject1).putInt("srcType", 9);
        this.this$0.jdField_a_of_type_Bats.a(0L, 0, (Bundle)localObject1);
        this.this$0.e = null;
      }
      ETEngine.isSOLoaded.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 0).edit().putBoolean("vip_font_so_downloaded", true).commit();
      aqcx.a().a();
      gd.a.set(true);
      this.this$0.a(false);
    }
    label377:
    gf.a().a(this.a, -102);
    return;
    label390:
    gf.a().a(this.a, -102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.3
 * JD-Core Version:    0.7.0.1
 */