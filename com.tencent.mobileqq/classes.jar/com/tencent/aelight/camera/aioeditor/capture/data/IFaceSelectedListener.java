package com.tencent.aelight.camera.aioeditor.capture.data;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public abstract interface IFaceSelectedListener
{
  public abstract void a();
  
  public abstract void a(InformationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper);
  
  public abstract void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void b(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener
 * JD-Core Version:    0.7.0.1
 */