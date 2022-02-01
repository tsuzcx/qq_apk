package com.tencent.aelight.camera.aioeditor.takevideo;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EditVideoDoodle$DoodleFacePanelAdapter
  extends FacePanelBaseAdapter
{
  private final ConcurrentLinkedQueue<FacePackage> a = new ConcurrentLinkedQueue();
  private final List<FacePackage> b = new ArrayList();
  
  public int a()
  {
    return this.b.size();
  }
  
  public FacePackage a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (FacePackage)this.b.get(paramInt);
    }
    return null;
  }
  
  public FacePackage a(String paramString)
  {
    if (this.a.isEmpty()) {
      a(((PasterDataManager)QIMManager.a(4)).f());
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)localIterator.next();
      if ((localFacePackage != null) && (TextUtils.equals(paramString, localFacePackage.a))) {
        return localFacePackage;
      }
    }
    return null;
  }
  
  public void a(FacePackage paramFacePackage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoodleFacePanelAdapter updateFacePackage ");
    localStringBuilder.append(paramFacePackage);
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", localStringBuilder.toString());
    int i = this.b.indexOf(paramFacePackage);
    if (i >= 0)
    {
      this.b.set(i, paramFacePackage);
      b(i);
    }
  }
  
  public void a(Collection<FacePackage> paramCollection)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DoodleFacePanelAdapter updateFacePackages size = ");
    ((StringBuilder)localObject).append(paramCollection.size());
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", ((StringBuilder)localObject).toString());
    try
    {
      this.a.clear();
      this.b.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        localObject = (FacePackage)paramCollection.next();
        if (localObject != null)
        {
          this.a.add(localObject);
          if (((FacePackage)localObject).i == 0) {
            this.b.add(localObject);
          }
        }
      }
      b();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.DoodleFacePanelAdapter
 * JD-Core Version:    0.7.0.1
 */