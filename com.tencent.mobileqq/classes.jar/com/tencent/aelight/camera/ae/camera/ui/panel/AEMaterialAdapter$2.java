package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AEMaterialAdapter$2
  implements Runnable
{
  AEMaterialAdapter$2(AEMaterialAdapter paramAEMaterialAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = (AEMaterialMetaData)this.this$0.a.get(this.a);
    String str = AEMaterialAdapter.a(this.this$0).b();
    if ((!TextUtils.isEmpty(this.this$0.c)) && (this.this$0.c.equals(this.b.m)) && (str.equals(this.b.m)) && (localObject != null) && (((AEMaterialMetaData)localObject).m.equals(this.b.m)) && (this.c))
    {
      if (AEMaterialManager.a)
      {
        AEQLog.b("AEMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (AEMaterialAdapter.b(this.this$0) != null)
      {
        AEMaterialAdapter.a(this.this$0).a(this.b, AEMaterialAdapter.c(this.this$0) ^ true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject).append(this.b.m);
        QLog.d("AEMaterialAdapter", 4, ((StringBuilder)localObject).toString());
        AEMaterialAdapter.b(this.this$0).a(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */