package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class StoryVideoUploadProgressManager
{
  private static StoryVideoUploadProgressManager jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadProgressManager = new StoryVideoUploadProgressManager();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Map<String, StoryVideoUploadProgressManager.ProgressStatus> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, List<StoryVideoUploadProgressManager.UpdateProgressListenerWrapper>> b = new HashMap();
  
  public static StoryVideoUploadProgressManager a()
  {
    return jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadProgressManager;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new StoryVideoUploadProgressManager.1(this, paramString, paramInt));
      return;
    }
    SLog.a("StoryVideoUploadProgressManager", "notifyListeners, id:%s, progress:%s", paramString, Integer.valueOf(paramInt));
    Object localObject = (List)this.b.get(paramString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoUploadProgressManager.UpdateProgressListener localUpdateProgressListener = ((StoryVideoUploadProgressManager.UpdateProgressListenerWrapper)((Iterator)localObject).next()).a();
        if (localUpdateProgressListener != null) {
          localUpdateProgressListener.a(paramString, paramInt);
        }
      }
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)localIterator.next();
      if (localProgressStatus.jdField_a_of_type_Boolean)
      {
        j += 1;
        i += localProgressStatus.jdField_b_of_type_Int;
      }
    }
    if (j > 0) {
      return i / j;
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    paramString = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)localIterator.next();
      if ((localProgressStatus.jdField_b_of_type_JavaLangString != null) && (localProgressStatus.jdField_b_of_type_JavaLangString.equals(paramString))) {
        return localProgressStatus.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public void a()
  {
    try
    {
      SLog.b("StoryVideoUploadProgressManager", "startANewUploadSeq");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((StoryVideoUploadProgressManager.ProgressStatus)((Map.Entry)localIterator.next()).getValue()).b();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.b.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(StoryVideoUploadProgressManager.UpdateProgressListener paramUpdateProgressListener)
  {
    SLog.a("StoryVideoUploadProgressManager", "unregisterListener, listener:%s", paramUpdateProgressListener.getClass().getSimpleName());
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((StoryVideoUploadProgressManager.UpdateProgressListenerWrapper)((Iterator)localObject).next()).a() == paramUpdateProgressListener) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      SLog.a("StoryVideoUploadProgressManager", "preparedSuccess:%s", paramString);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localProgressStatus.jdField_a_of_type_Int = 1;
        localProgressStatus.jdField_b_of_type_Int = 0;
        a(paramString, localProgressStatus.jdField_b_of_type_Int);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, StoryVideoUploadProgressManager.UpdateProgressListener paramUpdateProgressListener)
  {
    SLog.a("StoryVideoUploadProgressManager", "registerListener, id:%s, listener:%s", paramString, paramUpdateProgressListener.getClass().getSimpleName());
    Object localObject3 = this.b.entrySet().iterator();
    Object localObject1 = null;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      Object localObject4 = (String)((Map.Entry)localObject2).getKey();
      localObject4 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      localObject2 = localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (StoryVideoUploadProgressManager.UpdateProgressListenerWrapper)((Iterator)localObject4).next();
        if (((StoryVideoUploadProgressManager.UpdateProgressListenerWrapper)localObject1).a() == paramUpdateProgressListener)
        {
          ((Iterator)localObject4).remove();
          localObject2 = localObject1;
        }
      }
    }
    localObject3 = (List)this.b.get(paramString);
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new ArrayList();
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new StoryVideoUploadProgressManager.UpdateProgressListenerWrapper(paramUpdateProgressListener);
    }
    ((List)localObject2).add(localObject3);
    this.b.put(paramString, localObject2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      SLog.a("StoryVideoUploadProgressManager", "sendProtoSuccess:%s", paramString1);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
      {
        StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
        localProgressStatus.jdField_a_of_type_Int = 4;
        localProgressStatus.jdField_b_of_type_Int = 100;
        localProgressStatus.jdField_b_of_type_JavaLangString = paramString2;
        a(paramString1, localProgressStatus.jdField_b_of_type_Int);
        localProgressStatus.b();
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      SLog.a("StoryVideoUploadProgressManager", "addUploadTask:%s", paramString);
      StoryVideoUploadProgressManager.ProgressStatus localProgressStatus;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      } else {
        localProgressStatus = new StoryVideoUploadProgressManager.ProgressStatus(this, null);
      }
      localProgressStatus.jdField_a_of_type_JavaLangString = paramString;
      localProgressStatus.jdField_b_of_type_JavaLangString = "";
      localProgressStatus.jdField_a_of_type_Boolean = paramBoolean;
      localProgressStatus.jdField_a_of_type_Int = 0;
      localProgressStatus.jdField_b_of_type_Int = 0;
      localProgressStatus.a();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localProgressStatus);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      SLog.a("StoryVideoUploadProgressManager", "mergeVideoSuccess:%s", paramString);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localProgressStatus.jdField_a_of_type_Int = 2;
        localProgressStatus.jdField_b_of_type_Int = 60;
        a(paramString, localProgressStatus.jdField_b_of_type_Int);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      SLog.a("StoryVideoUploadProgressManager", "uploadVideoSuccess:%s", paramString);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localProgressStatus.jdField_a_of_type_Int = 3;
        localProgressStatus.jdField_b_of_type_Int = 95;
        a(paramString, localProgressStatus.jdField_b_of_type_Int);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        StoryVideoUploadProgressManager.ProgressStatus localProgressStatus = (StoryVideoUploadProgressManager.ProgressStatus)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localProgressStatus.jdField_a_of_type_Int = 5;
        localProgressStatus.jdField_b_of_type_Int = 100;
        a(paramString, localProgressStatus.jdField_b_of_type_Int);
        localProgressStatus.b();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager
 * JD-Core Version:    0.7.0.1
 */