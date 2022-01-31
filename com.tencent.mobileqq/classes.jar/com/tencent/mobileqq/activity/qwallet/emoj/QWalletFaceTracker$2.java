package com.tencent.mobileqq.activity.qwallet.emoj;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ljd;
import lje;
import ljf;

class QWalletFaceTracker$2
  implements Runnable
{
  QWalletFaceTracker$2(QWalletFaceTracker paramQWalletFaceTracker, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, QWalletFaceTracker.OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener) {}
  
  public void run()
  {
    for (;;)
    {
      float f2;
      try
      {
        Object localObject = this.this$0.DoDetectionProcessYUV(this.val$data, this.val$imagewidth, this.val$imageheight);
        if ((localObject != null) && (localObject.length > 0))
        {
          FaceDetector.getInstance().updatePointsAndAngles((QWalletFaceTracker.FaceStatus[])localObject);
          localObject = FaceDetector.getInstance().getAllPoints(0);
          float[] arrayOfFloat = FaceDetector.getInstance().getFaceAngles(0);
          if ((localObject != null) && (((List)localObject).size() > 0) && (arrayOfFloat != null) && (arrayOfFloat.length > 0) && (this.this$0.expressionItemList != null))
          {
            QWalletFaceTracker.ExpressionInfo localExpressionInfo = (QWalletFaceTracker.ExpressionInfo)this.this$0.expressionItemList.get(this.val$index);
            if (localExpressionInfo != null)
            {
              lje locallje = localExpressionInfo.expressionItem;
              ljf localljf = ljd.a(locallje, (List)localObject, ljd.b(arrayOfFloat));
              f2 = localljf.a;
              if (QLog.isColorLevel()) {
                QLog.d(QWalletFaceTracker.TAG, 2, "detectFaceExpression score: " + f2 + " threshold: " + this.val$threshold);
              }
              f1 = f2;
              if (f2 > this.val$threshold)
              {
                f1 = f2;
                if (this.this$0.normalFaceExpression != null)
                {
                  if ((locallje.expressionWeight[0] <= 0.0D) || (locallje.expressionWeight[1] <= 0.0D) || (ljd.a(localljf))) {
                    break label453;
                  }
                  if (!QLog.isColorLevel()) {
                    break label458;
                  }
                  QLog.d(QWalletFaceTracker.TAG, 2, "detectFaceExpression, invalid EyeOpenClose,reset score");
                  break label458;
                  boolean bool = QWalletFaceTracker.access$000(this.this$0, localljf.a, localExpressionInfo.coolValue, locallje.expressionWeight, locallje.a, this.this$0.normalFaceExpression, (List)localObject, ljd.b(arrayOfFloat));
                  if (QLog.isColorLevel()) {
                    QLog.d(QWalletFaceTracker.TAG, 2, "isNormalExpression: " + f1);
                  }
                  if (!bool) {
                    break label450;
                  }
                  if (!QLog.isColorLevel()) {
                    break label463;
                  }
                  QLog.d(QWalletFaceTracker.TAG, 2, "detectFaceExpression, is normalFaceExpression,reset score");
                  break label463;
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d(QWalletFaceTracker.TAG, 2, "similarityResult: " + f1);
              }
              if (this.val$listener != null) {
                this.val$listener.getFaceRecognizeResult(f1);
              }
            }
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(QWalletFaceTracker.TAG, 2, "error: " + localThrowable.getLocalizedMessage());
        return;
      }
      label450:
      continue;
      label453:
      float f1 = f2;
      continue;
      label458:
      f1 = 0.0F;
      continue;
      label463:
      f1 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.2
 * JD-Core Version:    0.7.0.1
 */