package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;

class EmosmActivity$8
  extends EmoticonPackageDownloadListener
{
  EmosmActivity$8(EmosmActivity paramEmosmActivity) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage != null) && (paramInt1 == 2))
    {
      if (paramInt2 != 0) {
        return;
      }
      if (this.a.mEPDatas == null) {
        return;
      }
      paramEmoticonPackage = this.a;
      paramEmoticonPackage.runOnUiThread(paramEmoticonPackage.mRefreshTask);
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.8
 * JD-Core Version:    0.7.0.1
 */