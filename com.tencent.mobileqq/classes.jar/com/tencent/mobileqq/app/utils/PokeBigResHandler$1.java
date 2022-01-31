package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import ayrx;
import aytb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;

class PokeBigResHandler$1
  implements Runnable
{
  PokeBigResHandler$1(PokeBigResHandler paramPokeBigResHandler) {}
  
  public void run()
  {
    PokeBigResHandler.a(true);
    ayrx localayrx = new ayrx();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0.app.getApp());
    String str = this.this$0.app.getAccount();
    PokeBigResHandler.a(localSharedPreferences.getString(str + "_" + "aio_poke_res_url", ""));
    PokeBigResHandler.b(localSharedPreferences.getString(str + "_" + "aio_poke_res_md5", ""));
    if (TextUtils.isEmpty(PokeBigResHandler.a()))
    {
      PokeBigResHandler.a(false);
      return;
    }
    localayrx.jdField_a_of_type_Aysc = PokeBigResHandler.a(this.this$0);
    localayrx.jdField_a_of_type_JavaLangString = PokeBigResHandler.a();
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = (PokeBigResHandler.b() + "poke.zip");
    ((aytb)this.this$0.mApp.getNetEngine(0)).a(localayrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.1
 * JD-Core Version:    0.7.0.1
 */