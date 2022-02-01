package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AENewMaterialAdapter$onDownloadFinish$2
  implements Runnable
{
  AENewMaterialAdapter$onDownloadFinish$2(AENewMaterialAdapter paramAENewMaterialAdapter, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public final void run()
  {
    StringBuilder localStringBuilder;
    if ((Intrinsics.areEqual(AENewMaterialAdapter.b(this.this$0), this.a) ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last chosen material [");
      localObject = AENewMaterialAdapter.b(this.this$0);
      if (localObject != null) {
        localObject = ((AEMaterialMetaData)localObject).m;
      } else {
        localObject = null;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] is not the download material");
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", localStringBuilder.toString());
      this.this$0.notifyDataSetChanged();
      return;
    }
    Object localObject = AENewMaterialAdapter.c(this.this$0).a();
    if ((Intrinsics.areEqual(localObject, this.a.m) ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last select materail [");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] is not the download material");
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", localStringBuilder.toString());
      this.this$0.notifyDataSetChanged();
      return;
    }
    if (AENewMaterialAdapter.d(this.this$0).a())
    {
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
      this.this$0.notifyDataSetChanged();
      return;
    }
    if (!AENewMaterialAdapter.d(this.this$0).b())
    {
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
      this.this$0.notifyDataSetChanged();
      return;
    }
    AENewMaterialAdapter.c(this.this$0).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialAdapter.onDownloadFinish.2
 * JD-Core Version:    0.7.0.1
 */