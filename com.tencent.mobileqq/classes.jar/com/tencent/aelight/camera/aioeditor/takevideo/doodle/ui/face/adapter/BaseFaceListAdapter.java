package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseFaceListAdapter<PACKAGE extends FacePackage>
  extends BaseAdapter
{
  protected Context a;
  protected PACKAGE b;
  protected IFaceSelectedListener c;
  public int d;
  protected FaceListPage e;
  
  public BaseFaceListAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    this.a = paramContext;
    this.e = paramFaceListPage;
  }
  
  public void a(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.c = paramIFaceSelectedListener;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.b = paramPACKAGE;
  }
  
  protected boolean a()
  {
    return this.e.b;
  }
  
  public int getCount()
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceList", 2, "facePkg is null");
      }
      return 0;
    }
    int i = ((FacePackage)localObject).d();
    int j = this.b.a();
    if (j >= 1)
    {
      if ((QLog.isColorLevel()) && (i == 0)) {
        QLog.d("FaceList", 2, "totalFaceCount = 0");
      }
      if (i % j == 0) {
        return i / j;
      }
      return i / j + 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("per item count < 1 :");
    ((StringBuilder)localObject).append(j);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter
 * JD-Core Version:    0.7.0.1
 */