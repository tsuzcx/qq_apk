package com.tencent.biz.troop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class TroopMemberApiService$IncomingHandler$2
  implements Runnable
{
  TroopMemberApiService$IncomingHandler$2(TroopMemberApiService.IncomingHandler paramIncomingHandler, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.b.a.getBaseContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("browser_font_size_index", this.a);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.2
 * JD-Core Version:    0.7.0.1
 */