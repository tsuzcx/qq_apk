package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public final class WXLaunchMiniProgram$Req
  extends BaseReq
{
  public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
  public static final int MINIPROGRAM_TYPE_TEST = 1;
  public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
  private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgram.Req";
  public String extData = "";
  public int miniprogramType = 0;
  public String path = "";
  public String userName;
  
  public boolean checkArgs()
  {
    if (b.b(this.userName)) {}
    for (String str = "userName is null";; str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW")
    {
      Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", str);
      return false;
      int i = this.miniprogramType;
      if ((i >= 0) && (i <= 2)) {
        return true;
      }
    }
  }
  
  public int getType()
  {
    return 19;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_username", this.userName);
    paramBundle.putString("_launch_wxminiprogram_path", this.path);
    paramBundle.putString("_launch_wxminiprogram_extData", this.extData);
    paramBundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req
 * JD-Core Version:    0.7.0.1
 */