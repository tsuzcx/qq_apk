package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FrameAdapter
{
  private ConcurrentHashMap<Integer, FramesProcessor.Frame> a = new ConcurrentHashMap();
  private FrameAdapter.DataSetChangeListener b;
  
  public FrameAdapter(FrameAdapter.DataSetChangeListener paramDataSetChangeListener)
  {
    this.b = paramDataSetChangeListener;
  }
  
  public FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.a.get(Integer.valueOf(paramInt));
  }
  
  public void a(FramesProcessor.Frame paramFrame)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFrame, index=");
      localStringBuilder.append(paramFrame.b);
      QLog.d("FrameAdapter", 2, localStringBuilder.toString());
    }
    this.a.putIfAbsent(Integer.valueOf(paramFrame.b), paramFrame);
    paramFrame = this.b;
    if (paramFrame != null) {
      paramFrame.a();
    }
  }
  
  public boolean a()
  {
    return this.a.size() == 0;
  }
  
  public void b()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      FramesProcessor.Frame localFrame = (FramesProcessor.Frame)localIterator.next();
      localFrame.a.recycle();
      localFrame.a = null;
    }
  }
  
  public boolean b(int paramInt)
  {
    return this.a.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */