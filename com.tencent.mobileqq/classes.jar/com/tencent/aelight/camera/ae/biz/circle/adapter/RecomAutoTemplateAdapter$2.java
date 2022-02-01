package com.tencent.aelight.camera.ae.biz.circle.adapter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import java.util.List;

class RecomAutoTemplateAdapter$2
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  RecomAutoTemplateAdapter$2(RecomAutoTemplateAdapter paramRecomAutoTemplateAdapter, int paramInt, MetaMaterial paramMetaMaterial) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (RecomAutoTemplateAdapter.a(this.c) != null) {
        RecomAutoTemplateAdapter.a(this.c).b();
      }
      RecomAutoTemplateAdapter localRecomAutoTemplateAdapter = this.c;
      RecomAutoTemplateAdapter.a(localRecomAutoTemplateAdapter, ((RecomAutoTemplateAdapter.RecomAutoTemplateData)RecomAutoTemplateAdapter.b(localRecomAutoTemplateAdapter).get(this.a)).d, this.b, ((RecomAutoTemplateAdapter.RecomAutoTemplateData)RecomAutoTemplateAdapter.b(this.c).get(this.a)).f);
      return;
    }
    if (RecomAutoTemplateAdapter.a(this.c) != null) {
      RecomAutoTemplateAdapter.a(this.c).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter.2
 * JD-Core Version:    0.7.0.1
 */