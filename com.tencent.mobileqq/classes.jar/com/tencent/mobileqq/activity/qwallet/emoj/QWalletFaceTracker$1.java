package com.tencent.mobileqq.activity.qwallet.emoj;

import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.List;
import lsy;
import lsz;
import lta;

class QWalletFaceTracker$1
  implements Runnable
{
  QWalletFaceTracker$1(QWalletFaceTracker paramQWalletFaceTracker, int paramInt1, int paramInt2, QWalletFaceTracker.OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener) {}
  
  public void run()
  {
    try
    {
      if (QWalletFaceTracker.access$000(this.this$0) == null)
      {
        if (!QLog.isColorLevel()) {
          break label633;
        }
        QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】init QQFilterRenderManage error");
        return;
      }
      localObject = QWalletFaceTracker.access$000(this.this$0).getFaceAttr();
      if (QLog.isColorLevel()) {
        QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】faceAttr score: " + localObject);
      }
      if (localObject != null) {
        break label131;
      }
      if (!QLog.isColorLevel()) {
        break label633;
      }
      QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】 QQFilterRenderManage.getFaceAttr() error  PTFaceAttr is null");
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!QLog.isColorLevel()) {
        break label633;
      }
    }
    QLog.e(QWalletFaceTracker.TAG, 2, "error: " + localThrowable.getLocalizedMessage());
    return;
    label131:
    List localList = ((PTFaceAttr)localObject).getAllFacePoints();
    Object localObject = ((PTFaceAttr)localObject).getAllFaceAngles();
    float f2;
    float f1;
    if ((localList != null) && (localList.size() > 0) && (localObject != null) && (((List)localObject).size() > 0))
    {
      localList = (List)localList.get(0);
      localObject = (float[])((List)localObject).get(0);
      if ((localList != null) && (localList.size() > 0) && (localObject != null) && (localObject.length > 0)) {
        if (this.this$0.expressionItemList != null)
        {
          QWalletFaceTracker.ExpressionInfo localExpressionInfo = (QWalletFaceTracker.ExpressionInfo)this.this$0.expressionItemList.get(this.val$index);
          if (localExpressionInfo != null)
          {
            lsz locallsz = localExpressionInfo.expressionItem;
            lta locallta = lsy.a(locallsz, new ArrayList(localList), lsy.b((float[])localObject));
            f2 = locallta.a;
            if (QLog.isColorLevel()) {
              QLog.d(QWalletFaceTracker.TAG, 2, "detectFaceExpression score: " + f2 + " threshold: " + this.val$threshold);
            }
            f1 = f2;
            if (f2 > this.val$threshold)
            {
              f1 = f2;
              if (this.this$0.normalFaceExpression != null)
              {
                if ((locallsz.expressionWeight[0] <= 0.0D) || (locallsz.expressionWeight[1] <= 0.0D) || (lsy.a(locallta))) {
                  break label628;
                }
                if (!QLog.isColorLevel()) {
                  break label634;
                }
                QLog.d(QWalletFaceTracker.TAG, 2, "detectFaceExpression, invalid EyeOpenClose,reset score");
                break label634;
                boolean bool = QWalletFaceTracker.access$100(this.this$0, locallta.a, localExpressionInfo.coolValue, locallsz.expressionWeight, locallsz.a, this.this$0.normalFaceExpression, localList, lsy.b((float[])localObject));
                if (QLog.isColorLevel()) {
                  QLog.d(QWalletFaceTracker.TAG, 2, "isNormalExpression: " + f1);
                }
                if (!bool) {
                  break label625;
                }
                if (!QLog.isColorLevel()) {
                  break label639;
                }
                QLog.d(QWalletFaceTracker.TAG, 2, "detectFaceExpression, is normalFaceExpression,reset score");
                break label639;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QWalletFaceTracker.TAG, 2, "similarityResult: " + f1);
      }
      if (this.val$listener != null)
      {
        this.val$listener.getFaceRecognizeResult(f1);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】 expressionInfo is null ");
          return;
          if (QLog.isColorLevel())
          {
            QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】 userPoints.get(0) or userAngels.get(0) is null ");
            return;
            if (QLog.isColorLevel())
            {
              QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】 expressionItemList is null ");
              return;
              if (QLog.isColorLevel())
              {
                QLog.d(QWalletFaceTracker.TAG, 2, "【onPreviewFrameHandler】 faceAttr.getAllFacePoints() or faceAttr.getAllFaceAngles() is error ");
                return;
                label625:
                continue;
                label628:
                f1 = f2;
                break;
              }
            }
          }
        }
      }
      label633:
      return;
      label634:
      f1 = 0.0F;
      break;
      label639:
      f1 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.1
 * JD-Core Version:    0.7.0.1
 */