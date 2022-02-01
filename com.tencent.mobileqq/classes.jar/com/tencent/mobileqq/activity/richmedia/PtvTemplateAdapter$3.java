package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;

class PtvTemplateAdapter$3
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  PtvTemplateAdapter$3(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    this.a.a.post(new PtvTemplateAdapter.3.2(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    this.a.a.post(new PtvTemplateAdapter.3.1(this, paramPtvTemplateInfo, paramBoolean));
    if (!paramBoolean) {
      FlowCameraMqqAction.a("", "0X80075BB", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3
 * JD-Core Version:    0.7.0.1
 */