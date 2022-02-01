package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;

class PokeBigResHandler$1
  implements Runnable
{
  PokeBigResHandler$1(PokeBigResHandler paramPokeBigResHandler) {}
  
  public void run()
  {
    PokeBigResHandler.a(true);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(PokeBigResHandler.a(this.this$0).getApp());
    String str = PokeBigResHandler.a(this.this$0).getAccount();
    PokeBigResHandler.a(localSharedPreferences.getString(str + "_" + "aio_poke_res_url", ""));
    PokeBigResHandler.b(localSharedPreferences.getString(str + "_" + "aio_poke_res_md5", ""));
    if (TextUtils.isEmpty(PokeBigResHandler.a()))
    {
      PokeBigResHandler.a(false);
      return;
    }
    localHttpNetReq.mCallback = PokeBigResHandler.a(this.this$0);
    localHttpNetReq.mReqUrl = PokeBigResHandler.a();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = (PokeBigResHandler.b() + "poke.zip");
    ((HttpEngineServiceImpl)PokeBigResHandler.a(this.this$0).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.1
 * JD-Core Version:    0.7.0.1
 */