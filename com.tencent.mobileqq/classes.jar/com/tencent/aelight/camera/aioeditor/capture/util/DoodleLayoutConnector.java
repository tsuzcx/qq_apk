package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleLayoutConnector
{
  private static DoodleLayoutConnector a;
  private WeakReference<DoodleLayout> b;
  private WeakReference<DoodleLayout> c;
  
  public static DoodleLayoutConnector a()
  {
    if (a == null) {
      a = new DoodleLayoutConnector();
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unbind ");
      localStringBuilder.append(paramInt);
      QLog.d("DoodleLayoutConnector", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      this.b = null;
      return;
    }
    this.c = null;
  }
  
  public void a(int paramInt, DoodleLayout paramDoodleLayout)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bind ");
      localStringBuilder.append(paramInt);
      QLog.d("DoodleLayoutConnector", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      this.b = new WeakReference(paramDoodleLayout);
      return;
    }
    this.c = new WeakReference(paramDoodleLayout);
  }
  
  public DoodleLayout b(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.b;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (DoodleLayout)this.b.get();
        break label66;
      }
    }
    else
    {
      localObject = this.c;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (DoodleLayout)this.c.get();
        break label66;
      }
    }
    Object localObject = null;
    label66:
    if ((localObject == null) && (QLog.isColorLevel())) {
      QLog.e("DoodleLayoutConnector", 2, "getDoodleLayout null, not init yet");
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector
 * JD-Core Version:    0.7.0.1
 */