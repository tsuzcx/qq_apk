package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;

class EditPicActivity$1
  extends PtvTemplateManager.DoodleInfoLoadObserver
{
  EditPicActivity$1(EditPicActivity paramEditPicActivity) {}
  
  public void a()
  {
    SLog.c("EditPicActivity", "DoodleInfoLoadObserver, onLoadSucc");
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.a.a.a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.W_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicActivity.1
 * JD-Core Version:    0.7.0.1
 */