package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

class AEWaterMarkAdapter$4
  implements Runnable
{
  AEWaterMarkAdapter$4(AEWaterMarkAdapter paramAEWaterMarkAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = (AEMaterialMetaData)this.this$0.a.get(this.a);
    String str = AEWaterMarkAdapter.b(this.this$0).b();
    if ((!TextUtils.isEmpty(AEWaterMarkAdapter.c(this.this$0))) && (AEWaterMarkAdapter.c(this.this$0).equals(this.b.m)) && (str.equals(this.b.m)) && (localObject != null) && (((AEMaterialMetaData)localObject).m.equals(this.b.m)) && (this.c))
    {
      if (AEMaterialManager.a)
      {
        AEQLog.b("AEWaterMarkAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEWaterMarkAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      AEWaterMarkAdapter.b(this.this$0).b(this.b, true);
      if (AEWaterMarkAdapter.d(this.this$0) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject).append(this.b.m);
        AEQLog.a("AEWaterMarkAdapter", ((StringBuilder)localObject).toString());
        AEWaterMarkAdapter.d(this.this$0).a(this.b);
        this.this$0.a(this.a);
      }
    }
    else
    {
      this.this$0.notifyItemChanged(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkAdapter.4
 * JD-Core Version:    0.7.0.1
 */