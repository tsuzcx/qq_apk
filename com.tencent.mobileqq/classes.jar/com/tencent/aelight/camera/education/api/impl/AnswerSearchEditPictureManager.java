package com.tencent.aelight.camera.education.api.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton;
import com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicCropPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicMeiHua;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave;
import com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoButton;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

class AnswerSearchEditPictureManager
  extends EditPicPartManager
{
  private WeakReference<AnswerSearchEditPictureActivity> a;
  
  public void a(AnswerSearchEditPictureActivity paramAnswerSearchEditPictureActivity)
  {
    this.a = new WeakReference(paramAnswerSearchEditPictureActivity);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    if (15 == this.I.a)
    {
      localObject = new EditARCakeButton(this);
      this.L = ((EditARCakeButton)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      localObject = new AnswerSearchEditVideoButton(this, paramEditVideoParams.c);
      this.K = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
      localObject = new EditProviderPart(this);
      this.N = ((EditProviderPart)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoDoodle(this, paramEditVideoParams.c);
      this.O = ((EditVideoDoodle)localObject);
      localArrayList.add(localObject);
      localObject = new AnswerSearchPicButtonPart(this);
      this.S = ((EditPicCropPart)localObject);
      localArrayList.add(localObject);
    }
    Object localObject = new AnswerSearchEditRawImage(this, paramEditVideoParams.c);
    this.R = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.c, 512))
    {
      localObject = new EditPicSave(this);
      this.U = ((EditPicSave)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 4096))
    {
      localObject = new EditVideoLimitRegion(this);
      this.ab = ((EditVideoLimitRegion)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 2048))
    {
      localObject = new EditJumpToPtu(this);
      this.ac = ((EditJumpToPtu)localObject);
      localArrayList.add(localObject);
    }
    if (EditPicMeiHua.b(paramEditVideoParams.c)) {
      localArrayList.add(new EditPicMeiHua(this));
    }
    if (2 == this.I.a) {
      localArrayList.add(new DocEnhancePart(this));
    }
    this.J = localArrayList;
  }
  
  public void d()
  {
    if (this.a.get() != null) {
      ((AnswerSearchPicButtonPart)this.S).a((Context)this.a.get());
    }
  }
  
  public AnswerSearchEditPictureActivity e()
  {
    return (AnswerSearchEditPictureActivity)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.AnswerSearchEditPictureManager
 * JD-Core Version:    0.7.0.1
 */