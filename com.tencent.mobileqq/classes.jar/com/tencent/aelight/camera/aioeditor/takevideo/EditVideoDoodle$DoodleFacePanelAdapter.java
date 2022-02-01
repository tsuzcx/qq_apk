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
  private final List<FacePackage> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<FacePackage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public FacePackage a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (FacePackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public FacePackage a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((PasterDataManager)QIMManager.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)localIterator.next();
      if ((localFacePackage != null) && (TextUtils.equals(paramString, localFacePackage.jdField_a_of_type_JavaLangString))) {
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
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramFacePackage);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, paramFacePackage);
      a(i);
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        localObject = (FacePackage)paramCollection.next();
        if (localObject != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localObject);
          if (((FacePackage)localObject).jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
      }
      a();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.DoodleFacePanelAdapter
 * JD-Core Version:    0.7.0.1
 */