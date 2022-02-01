package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import qhl;

class PTSNodeImage$1
  implements qhl
{
  PTSNodeImage$1(PTSNodeImage paramPTSNodeImage) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((TextUtils.equals(paramString, String.valueOf(PTSNodeImage.access$000(this.this$0)))) && (paramReadInJoyUserInfo != null))
    {
      paramString = ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
      ThreadManager.getUIHandler().post(new PTSNodeImage.1.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage.1
 * JD-Core Version:    0.7.0.1
 */