package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FrameAdapter
{
  private FrameAdapter.DataSetChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public FrameAdapter(FrameAdapter.DataSetChangeListener paramDataSetChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener = paramDataSetChangeListener;
  }
  
  public FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      FramesProcessor.Frame localFrame = (FramesProcessor.Frame)localIterator.next();
      localFrame.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localFrame.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(FramesProcessor.Frame paramFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramFrame.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramFrame.jdField_a_of_type_Int), paramFrame);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */