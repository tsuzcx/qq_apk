package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialAdapter$onDownloadFinish$1
  implements Runnable
{
  AEFlashShowMaterialAdapter$onDownloadFinish$1(AEFlashShowMaterialAdapter paramAEFlashShowMaterialAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public final void run()
  {
    Object localObject1 = AEFlashShowMaterialAdapter.a(this.this$0).get(this.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mTemplateList[finalPos]");
    localObject1 = (AEMaterialMetaData)localObject1;
    Object localObject2 = AEFlashShowMaterialAdapter.b(this.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((AEFlashShowMaterialManager)localObject2).a();
    if ((!TextUtils.isEmpty((CharSequence)this.this$0.a())) && (Intrinsics.areEqual(this.this$0.a(), this.b.m)) && (Intrinsics.areEqual(localObject2, this.b.m)) && (localObject1 != null) && (Intrinsics.areEqual(((AEMaterialMetaData)localObject1).m, this.b.m)) && (this.c))
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
      if (AEFlashShowMaterialAdapter.c(this.this$0) != null)
      {
        AEFlashShowMaterialAdapter.b(this.this$0).a(this.b, AEFlashShowMaterialAdapter.d(this.this$0) ^ true);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject1).append(this.b.m);
        QLog.d("AEMaterialAdapter", 4, ((StringBuilder)localObject1).toString());
        AEFlashShowMaterialAdapter.c(this.this$0).a(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialAdapter.onDownloadFinish.1
 * JD-Core Version:    0.7.0.1
 */