package com.tencent.mobileqq.activity.qwallet.emoj;

import agpe;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import lje;

class QWalletFaceTracker$1
  implements agpe
{
  QWalletFaceTracker$1(QWalletFaceTracker paramQWalletFaceTracker, String paramString1, String paramString2, Context paramContext, IBaseRecognizer paramIBaseRecognizer) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QWalletFaceTracker.TAG, 2, "download success url: " + this.val$url + " resCode " + paramInt + " filePath: " + paramPathResult.folderPath);
    }
    Iterator localIterator;
    File localFile;
    if ((paramInt == 0) && (!TextUtils.isEmpty(this.val$configPath)))
    {
      if (this.this$0.expressionItemList == null) {
        this.this$0.expressionItemList = FaceDetector.getInstance().parseExpressionConfigFromJson(this.val$context, this.val$configPath, "expression");
      }
      Object localObject;
      if ((this.this$0.normalFaceExpression == null) && (this.this$0.expressionItemList != null) && (this.this$0.expressionItemList.size() > 0))
      {
        localIterator = this.this$0.expressionItemList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (QWalletFaceTracker.ExpressionInfo)localIterator.next();
          if (((QWalletFaceTracker.ExpressionInfo)localObject).expressionItem.expressionID.equals("99")) {
            this.this$0.normalFaceExpression = ((QWalletFaceTracker.ExpressionInfo)localObject).expressionItem;
          }
        }
      }
      if (!this.this$0.hasSoInit)
      {
        localObject = this.this$0.soFileNames;
        int i = localObject.length;
        paramInt = 0;
        if (paramInt >= i) {
          break label710;
        }
        localIterator = localObject[paramInt];
        localFile = new File(paramPathResult.folderPath, localIterator);
        if (!localFile.exists()) {
          if (QLog.isColorLevel()) {
            QLog.w(QWalletFaceTracker.TAG, 2, "so file: " + localFile.getAbsolutePath() + " not exist!!");
          }
        }
      }
    }
    label710:
    for (boolean bool = false;; bool = true)
    {
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QWalletFaceTracker.TAG, 2, "isLibExist: " + bool);
        }
        this.this$0.hasSDkInit = false;
        if (this.val$baseRecognizer != null) {
          this.val$baseRecognizer.OnInitResultCallback(this.this$0.hasSDkInit);
        }
        do
        {
          for (;;)
          {
            return;
            try
            {
              System.load(localFile.getAbsolutePath());
              paramInt += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e(QWalletFaceTracker.TAG, 1, "load so " + localIterator + " occur an error: " + localThrowable + ", retry");
                try
                {
                  System.load(localFile.getAbsolutePath());
                }
                catch (Throwable paramPathResult)
                {
                  QLog.e(QWalletFaceTracker.TAG, 1, "load so " + localIterator + " occur an error: " + paramPathResult);
                  this.this$0.hasSDkInit = false;
                }
              }
            }
          }
        } while (this.val$baseRecognizer == null);
        this.val$baseRecognizer.OnInitResultCallback(false);
        return;
      }
      this.this$0.hasSoInit = true;
      for (;;)
      {
        try
        {
          YTCommonInterface.initAuth(this.val$context, "youtusdk_mqq.licence", 0);
          QWalletFaceTracker.nativeInit();
          QWalletFaceTracker.GlobalInit(paramPathResult.folderPath + "/");
          this.this$0.NativeConstructor();
          this.this$0.hasSDkInit = true;
          if (this.val$baseRecognizer == null) {
            break;
          }
          this.val$baseRecognizer.OnInitResultCallback(this.this$0.hasSDkInit);
          return;
        }
        catch (Throwable paramPathResult)
        {
          QLog.e(QWalletFaceTracker.TAG, 1, "initAuth occur an error: " + paramPathResult);
          this.this$0.hasSDkInit = false;
        }
        if (this.val$baseRecognizer == null) {
          break;
        }
        this.val$baseRecognizer.OnInitResultCallback(this.this$0.hasSDkInit);
        return;
        this.this$0.hasSDkInit = false;
        if (QLog.isColorLevel()) {
          QLog.e(QWalletFaceTracker.TAG, 2, "download fail url: " + this.val$url + " resCode " + paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.1
 * JD-Core Version:    0.7.0.1
 */