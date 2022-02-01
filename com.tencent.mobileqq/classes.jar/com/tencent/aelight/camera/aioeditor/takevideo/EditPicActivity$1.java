package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.biz.qqstory.support.logging.SLog;

class EditPicActivity$1
  extends DoodleInfoLoadObserver
{
  EditPicActivity$1(EditPicActivity paramEditPicActivity) {}
  
  public void a()
  {
    SLog.c("EditPicActivity", "DoodleInfoLoadObserver, onLoadSucc");
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.a.mEditVideoPartManager.a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity.1
 * JD-Core Version:    0.7.0.1
 */