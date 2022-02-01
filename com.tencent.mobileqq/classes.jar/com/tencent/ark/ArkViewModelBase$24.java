package com.tencent.ark;

import android.text.TextUtils;

class ArkViewModelBase$24
  implements Runnable
{
  ArkViewModelBase$24(ArkViewModelBase paramArkViewModelBase, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.mContainer != null) && (!TextUtils.isEmpty(this.val$metaData)))
    {
      this.this$0.mContainer.SetMetadata(this.val$metaData, "json");
      ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "arkAsyncShare updateMetaData = " + this.val$metaData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.24
 * JD-Core Version:    0.7.0.1
 */