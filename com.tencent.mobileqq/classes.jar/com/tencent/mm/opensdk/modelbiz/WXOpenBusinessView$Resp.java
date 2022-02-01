package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXOpenBusinessView$Resp
  extends BaseResp
{
  public String businessType;
  public String extMsg;
  
  public WXOpenBusinessView$Resp() {}
  
  public WXOpenBusinessView$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_openbusinessview_ext_msg");
    this.businessType = paramBundle.getString("_openbusinessview_business_type");
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_openbusinessview_ext_msg", this.extMsg);
    paramBundle.putString("_openbusinessview_business_type", this.businessType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp
 * JD-Core Version:    0.7.0.1
 */