package com.tencent.mobileqq.activity.qwallet.emoj;

import ahbr;
import android.content.Context;
import android.text.TextUtils;
import axna;
import axnb;
import axni;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import ltq;

class QWalletFaceTracker$1
  implements ahbr
{
  QWalletFaceTracker$1(QWalletFaceTracker paramQWalletFaceTracker, String paramString1, String paramString2, Context paramContext, IBaseRecognizer paramIBaseRecognizer) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QWalletFaceTracker.TAG, 2, "getResPath onResult: " + this.val$url + " resCode " + paramInt + " filePath: " + paramPathResult.folderPath);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(this.val$configPath)))
    {
      if (this.this$0.expressionItemList == null) {
        this.this$0.expressionItemList = FaceDetector.getInstance().parseExpressionConfigFromJson(this.val$context, this.val$configPath, "expression");
      }
      Object localObject2;
      if ((this.this$0.normalFaceExpression == null) && (this.this$0.expressionItemList != null) && (this.this$0.expressionItemList.size() > 0))
      {
        localObject1 = this.this$0.expressionItemList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QWalletFaceTracker.ExpressionInfo)((Iterator)localObject1).next();
          if (((QWalletFaceTracker.ExpressionInfo)localObject2).expressionItem.expressionID.equals("99")) {
            this.this$0.normalFaceExpression = ((QWalletFaceTracker.ExpressionInfo)localObject2).expressionItem;
          }
        }
      }
      Object localObject1 = new axna[this.this$0.soFileNames.length];
      paramInt = 0;
      while (paramInt < this.this$0.soFileNames.length)
      {
        localObject2 = this.this$0.soFileNames[paramInt];
        localObject1[paramInt] = new axnb().a(new File(paramPathResult.folderPath, (String)localObject2).getAbsolutePath()).a();
        paramInt += 1;
      }
      axni.a().a(this.this$0.soNames, new QWalletFaceTracker.1.1(this, paramPathResult), (axna[])localObject1);
    }
    do
    {
      return;
      this.this$0.hasSDkInit = false;
      if (QLog.isColorLevel()) {
        QLog.e(QWalletFaceTracker.TAG, 2, "download fail url: " + this.val$url + " resCode " + paramInt);
      }
    } while (this.val$baseRecognizer == null);
    this.val$baseRecognizer.OnInitResultCallback(this.this$0.hasSDkInit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.1
 * JD-Core Version:    0.7.0.1
 */