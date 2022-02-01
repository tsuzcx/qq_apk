package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SendMessageToWX$Resp
  extends BaseResp
{
  public SendMessageToWX$Resp() {}
  
  public SendMessageToWX$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp
 * JD-Core Version:    0.7.0.1
 */