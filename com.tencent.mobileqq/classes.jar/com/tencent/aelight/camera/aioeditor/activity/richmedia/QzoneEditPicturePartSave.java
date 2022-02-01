package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;

public class QzoneEditPicturePartSave
  extends EditPicSave
{
  private View f;
  
  public QzoneEditPicturePartSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a()
  {
    super.a();
    this.f = d(2131443547);
    ((Button)d(2131433456)).setOnClickListener(new QzoneEditPicturePartSave.1(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = this.f;
    if ((paramInt != 0) && (paramInt != 4)) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    paramObject.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartSave
 * JD-Core Version:    0.7.0.1
 */