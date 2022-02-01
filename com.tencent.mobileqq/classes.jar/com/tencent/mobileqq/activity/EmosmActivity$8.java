package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;

class EmosmActivity$8
  extends EmoticonPackageDownloadListener
{
  EmosmActivity$8(EmosmActivity paramEmosmActivity) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage == null) || (paramInt1 != 2) || (paramInt2 != 0)) {}
    while (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.8
 * JD-Core Version:    0.7.0.1
 */