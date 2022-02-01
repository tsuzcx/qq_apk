package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qroute.QRoute;

public class LBSResultPlugin
  extends BaseResultPlugin
{
  public static void a(JumpActivity paramJumpActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ((IQJumpApi)QRoute.api(IQJumpApi.class)).releaseMapActivityProxy();
    if (paramIntent != null) {
      paramIntent = paramIntent.getExtras();
    } else {
      paramIntent = null;
    }
    if (paramIntent != null)
    {
      String str = paramIntent.getString("latitude");
      paramIntent = paramIntent.getString("longitude");
      if (paramJumpActivity.doCallBack)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ret=0&lon=");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append("&lat=");
        localStringBuilder.append(str);
        JumpActivityHelper.a(paramJumpActivity, localStringBuilder.toString());
      }
      paramJumpActivity.finish();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, JumpActivity paramJumpActivity)
  {
    a(paramJumpActivity, paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.LBSResultPlugin
 * JD-Core Version:    0.7.0.1
 */