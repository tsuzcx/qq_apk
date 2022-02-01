package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

class QIMInformationPasterManager$2
  implements Runnable
{
  QIMInformationPasterManager$2(QIMInformationPasterManager paramQIMInformationPasterManager, List paramList) {}
  
  public void run()
  {
    QIMInformationPasterManager.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!NetworkUtil.isNetworkAvailable(QIMInformationPasterManager.b(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    Object localObject = this.a.iterator();
    InformationFacePackage.Item localItem;
    while (((Iterator)localObject).hasNext())
    {
      localItem = (InformationFacePackage.Item)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(localItem.g)) && (!this.this$0.a(localItem)) && (localItem.f != 2)) {
        QIMInformationPasterManager.a(this.this$0).add(localItem);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("need download size:");
      ((StringBuilder)localObject).append(QIMInformationPasterManager.a(this.this$0).size());
      QLog.d("QIMInformationPasterManager", 2, ((StringBuilder)localObject).toString());
    }
    localObject = QIMInformationPasterManager.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localItem = (InformationFacePackage.Item)((Iterator)localObject).next();
      this.this$0.a.a(localItem, new QIMInformationPasterManager.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */