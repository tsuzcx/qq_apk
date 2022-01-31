package com.tencent.mobileqq.activity.qwallet.emoj;

import ahbt;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;

class HandRecognizer$1
  implements ahbt
{
  HandRecognizer$1(HandRecognizer paramHandRecognizer, String paramString) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d(HandRecognizer.TAG, 2, "dowload url: " + this.val$url + " resCode " + paramInt + " filePath: " + paramPathResult.folderPath);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      HandRecognizer.access$000(this.this$0).init(paramPathResult.folderPath, paramPathResult.folderPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.1
 * JD-Core Version:    0.7.0.1
 */