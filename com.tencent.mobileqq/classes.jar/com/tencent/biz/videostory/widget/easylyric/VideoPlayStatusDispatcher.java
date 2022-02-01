package com.tencent.biz.videostory.widget.easylyric;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoPlayStatusDispatcher
{
  private static final VideoPlayStatusDispatcher.Instance jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricVideoPlayStatusDispatcher$Instance = new VideoPlayStatusDispatcher.Instance(null);
  private CopyOnWriteArrayList<OnLyricListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static VideoPlayStatusDispatcher a()
  {
    return (VideoPlayStatusDispatcher)jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricVideoPlayStatusDispatcher$Instance.getInstance();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnLyricListener)((Iterator)localObject).next()).b();
      }
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localObject != null) && (!this.jdField_a_of_type_Boolean))
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnLyricListener)((Iterator)localObject).next()).a(paramLong);
      }
    }
  }
  
  public void a(OnLyricListener paramOnLyricListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramOnLyricListener);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnLyricListener)((Iterator)localObject).next()).a();
      }
    }
  }
  
  public void b(OnLyricListener paramOnLyricListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramOnLyricListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.VideoPlayStatusDispatcher
 * JD-Core Version:    0.7.0.1
 */