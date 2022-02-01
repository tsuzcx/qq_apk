package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class AEARCakeMaterialAdapter$3
  implements Runnable
{
  AEARCakeMaterialAdapter$3(AEARCakeMaterialAdapter paramAEARCakeMaterialAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a != 200)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064187644), 1).show();
      return;
    }
    if (this.b == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("arcake : onDownloadFinish ");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("cake id ");
    ((StringBuilder)localObject1).append(this.b.V);
    AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject1).toString());
    int i = AEARCakeMaterialAdapter.a(this.this$0, this.b);
    if (i <= 0) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("arcake : onDownloadFinish position");
    ((StringBuilder)localObject1).append(i);
    AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject1).toString());
    localObject1 = ((AEGiftMaterial)this.this$0.b.get(i)).c();
    Object localObject2 = AEARCakeMaterialAdapter.a(this.this$0).c();
    if (localObject2 == null) {
      return;
    }
    localObject2 = ((AEGiftMaterial)localObject2).c();
    this.this$0.notifyItemChanged(i);
    localObject2 = ((AEARCakeMaterial)localObject2).m;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(this.b.m)) && (localObject1 != null) && (((AEMaterialMetaData)localObject1).m.equals(this.b.m)) && (this.c))
    {
      if (AEMaterialManager.a)
      {
        AEQLog.b("AEARCakeMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEARCakeMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (this.this$0.a != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject1).append(this.b.m);
        AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject1).toString());
        this.this$0.a.a(this.b);
      }
      localObject1 = AEARCakeMaterialAdapter.a(this.this$0).e();
      if (localObject1 != null) {
        ((AEARCakeMaterialManager.IARCakeDownloadListener)localObject1).a(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.3
 * JD-Core Version:    0.7.0.1
 */