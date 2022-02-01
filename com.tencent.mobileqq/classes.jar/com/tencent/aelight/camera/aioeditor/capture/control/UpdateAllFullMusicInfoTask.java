package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UpdateAllFullMusicInfoTask
  extends ParallGroup
{
  private QIMMusicConfigManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager = (QIMMusicConfigManager)QIMManager.a(2);
  private ArrayList<FlowMusic> jdField_a_of_type_JavaUtilArrayList;
  private List<FlowMusic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ArrayList<FlowMusic> b = new ArrayList();
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager.a.query(FlowMusic.class);
    int i;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList((Collection)localObject);
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    else
    {
      i = 0;
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FlowMusic localFlowMusic = (FlowMusic)((Iterator)localObject).next();
        if (localFlowMusic.albumUrl == null) {
          this.jdField_a_of_type_JavaUtilList.add(localFlowMusic);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load db, has load local, size=");
      ((StringBuilder)localObject).append(i);
      QLog.d("UpdateAllFullMusicInfoTask", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b()
  {
    if (!this.b.isEmpty())
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager.a.getTransaction();
      try
      {
        ((EntityTransaction)localObject1).begin();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager.a.update(localFlowMusic);
        }
        ((EntityTransaction)localObject1).commit();
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager.a(4, true, localObject1);
    }
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      if ((paramAsyncStep instanceof GetSingleFullMusicInfoTask))
      {
        FlowMusic localFlowMusic = ((GetSingleFullMusicInfoTask)paramAsyncStep).a;
        if ((localFlowMusic != null) && (((GetSingleFullMusicInfoTask)paramAsyncStep).b != null))
        {
          localFlowMusic.albumUrl = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.albumUrl;
          localFlowMusic.url = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.url;
          localFlowMusic.size = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.size;
          localFlowMusic.playable = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.playable;
          this.b.add(localFlowMusic);
        }
      }
      paramInt = this.jdField_a_of_type_Int - 1;
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt == 0)
      {
        b();
        setResult(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.mAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
  
  protected int doStep()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FlowMusic)localIterator.next();
        if (this.mResult == 8) {
          break;
        }
        localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).mResultListener = this;
        this.mAutomator.b((AsyncStep)localObject);
      }
      return 2;
    }
    b();
    return 7;
  }
  
  public void onCreate()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.UpdateAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */