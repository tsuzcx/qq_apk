package com.tencent.mobileqq.apollo.view;

import bgod;
import bgoe;
import com.tencent.qphone.base.util.QLog;

class ApolloLottieAnim$2
  extends bgod
{
  ApolloLottieAnim$2(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (3 == parambgoe.a()) {
      this.this$0.onDownloadFinish(true, this.val$url, this.val$filePath, this.val$folder);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "downloadZip onDone task.getStatus()->" + parambgoe.a());
      }
      return;
      this.this$0.mState = 2;
      this.this$0.onDownloadFinish(false, this.val$url, this.val$filePath, this.val$folder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim.2
 * JD-Core Version:    0.7.0.1
 */