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
    Object localObject = PreferenceManager.getDefaultSharedPreferences(PokeBigResHandler.a(this.this$0).getApp());
    String str = PokeBigResHandler.a(this.this$0).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_res_url");
    PokeBigResHandler.a(((SharedPreferences)localObject).getString(localStringBuilder.toString(), ""));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_res_md5");
    PokeBigResHandler.b(((SharedPreferences)localObject).getString(localStringBuilder.toString(), ""));
    if (TextUtils.isEmpty(PokeBigResHandler.a()))
    {
      PokeBigResHandler.a(false);
      return;
    }
    localHttpNetReq.mCallback = PokeBigResHandler.a(this.this$0);
    localHttpNetReq.mReqUrl = PokeBigResHandler.a();
    localHttpNetReq.mHttpMethod = 0;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PokeBigResHandler.b());
    ((StringBuilder)localObject).append("poke.zip");
    localHttpNetReq.mOutPath = ((StringBuilder)localObject).toString();
    ((HttpEngineServiceImpl)PokeBigResHandler.a(this.this$0).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler.1
 * JD-Core Version:    0.7.0.1
 */