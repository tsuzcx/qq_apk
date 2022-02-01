package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import java.util.ArrayList;

class EmosmActivity$7
  implements EmoticonPackageChangedListener
{
  EmosmActivity$7(EmosmActivity paramEmosmActivity) {}
  
  public void onPackageAdded(EmoticonPackage paramEmoticonPackage)
  {
    int i = 0;
    while (i < this.a.mEPDatas.size())
    {
      if (((EmoticonPackage)this.a.mEPDatas.get(i)).epId.equals(paramEmoticonPackage.epId)) {
        return;
      }
      i += 1;
    }
    paramEmoticonPackage = this.a;
    paramEmoticonPackage.runOnUiThread(paramEmoticonPackage.mRefreshTask);
  }
  
  public void onPackageDeleted(EmoticonPackage paramEmoticonPackage) {}
  
  public void onPackageMoved(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.7
 * JD-Core Version:    0.7.0.1
 */