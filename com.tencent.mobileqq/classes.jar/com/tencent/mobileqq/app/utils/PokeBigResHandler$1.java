package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import beum;
import bevo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;

class PokeBigResHandler$1
  implements Runnable
{
  PokeBigResHandler$1(PokeBigResHandler paramPokeBigResHandler) {}
  
  public void run()
  {
    PokeBigResHandler.a(true);
    beum localbeum = new beum();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0.app.getApp());
    String str = this.this$0.app.getAccount();
    PokeBigResHandler.a(localSharedPreferences.getString(str + "_" + "aio_poke_res_url", ""));
    PokeBigResHandler.b(localSharedPreferences.getString(str + "_" + "aio_poke_res_md5", ""));
    if (TextUtils.isEmpty(PokeBigResHandler.a()))
    {
      PokeBigResHandler.a(false);
      return;
    }
    localbeum.jdField_a_of_type_Beuq = PokeBigResHandler.a(this.this$0);
    localbeum.jdField_a_of_type_JavaLangString = PokeBigResHandler.a();
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = (PokeBigResHandler.b() + "poke.zip");
    ((bevo)this.this$0.mApp.getNetEngine(0)).a(localbeum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.1
 * JD-Core Version:    0.7.0.1
 */