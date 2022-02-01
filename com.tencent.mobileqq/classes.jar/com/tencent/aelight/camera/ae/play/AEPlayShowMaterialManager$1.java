package com.tencent.aelight.camera.ae.play;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AEPlayShowMaterialManager$1
  implements Runnable
{
  AEPlayShowMaterialManager$1(AEPlayShowMaterialManager paramAEPlayShowMaterialManager) {}
  
  public void run()
  {
    synchronized (AEPlayShowMaterialManager.access$000(this.this$0))
    {
      List localList = AEPlayShowMaterialManager.access$100(this.this$0);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newPsCategoryList, hashCode=");
        localStringBuilder.append(localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPsCategoryList, hashCode=");
        localStringBuilder.append(AEPlayShowMaterialManager.access$200(this.this$0).hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, localStringBuilder.toString());
      }
      if ((AEPlayShowMaterialManager.access$200(this.this$0) == null) || (AEPlayShowMaterialManager.access$200(this.this$0).size() < 1) || (localList.hashCode() != AEPlayShowMaterialManager.access$200(this.this$0).hashCode()))
      {
        if (AEPlayShowMaterialManager.access$200(this.this$0) != null)
        {
          AEPlayShowMaterialManager.access$200(this.this$0).clear();
          AEPlayShowMaterialManager.access$200(this.this$0).addAll(localList);
        }
        AEPlayShowMaterialManager.access$300(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */