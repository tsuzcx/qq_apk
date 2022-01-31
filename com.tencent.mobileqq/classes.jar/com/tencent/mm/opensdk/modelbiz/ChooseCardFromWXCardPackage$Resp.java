package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage$Resp
  extends BaseResp
{
  public String cardItemList;
  
  public ChooseCardFromWXCardPackage$Resp() {}
  
  public ChooseCardFromWXCardPackage$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    return (this.cardItemList != null) && (this.cardItemList.length() != 0);
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    paramBundle = paramBundle.getString("_wxapi_choose_card_from_wx_card_list");
    if ((paramBundle != null) && (paramBundle.length() > 0))
    {
      this.cardItemList = paramBundle;
      return;
    }
    Log.i("MicroMsg.ChooseCardFromWXCardPackage", "cardItemList is empty!");
  }
  
  public int getType()
  {
    return 16;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp
 * JD-Core Version:    0.7.0.1
 */