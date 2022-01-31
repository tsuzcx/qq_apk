package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class PathDesc
{
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private PathData jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData = new PathData();
  private PathDrawer jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
  
  public PathDesc(DoodleParam paramDoodleParam, int paramInt1, List paramList, int paramInt2)
  {
    if (paramDoodleParam == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(paramDoodleParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.b(paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramList);
  }
  
  public PathDesc(PathDesc paramPathDesc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramPathDesc.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.b();
  }
  
  public PathData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData;
  }
  
  public PathDrawer a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.b());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
      Rect localRect = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer = new PathDrawer(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(paramFloat1, paramFloat2, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(), 0L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramFloat1, paramFloat2, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a();
    PathData.PointData localPointData = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.b();
    long l;
    if (localPointData != null)
    {
      l = paramLong - localPointData.a();
      if (l <= 0L) {
        f = localPointData.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(l, localPointData.a(), localPointData.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(0, 0, i, j);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDesc
 * JD-Core Version:    0.7.0.1
 */