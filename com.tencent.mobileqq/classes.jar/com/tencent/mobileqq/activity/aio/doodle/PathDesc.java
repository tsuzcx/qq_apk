package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class PathDesc
{
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private PathData jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData = new PathData();
  private PathDrawer jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
  
  public PathDesc(DoodleParam paramDoodleParam, int paramInt1, List<PathData.PointData> paramList, int paramInt2)
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
    PathDrawer localPathDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localPathDrawer == null) {
      return 0;
    }
    return localPathDrawer.b();
  }
  
  public PathData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData;
  }
  
  public PathDrawer a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localObject != null)
    {
      ((PathDrawer)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.b());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a());
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer = new PathDrawer(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData, ((Rect)localObject).width(), ((Rect)localObject).height(), -1, -1, 10, 15, 1.0F);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
  }
  
  public void a()
  {
    PathDrawer localPathDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localPathDrawer != null) {
      localPathDrawer.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    PathDrawer localPathDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localPathDrawer != null) {
      localPathDrawer.a(paramFloat1, paramFloat2, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(), 0L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramFloat1, paramFloat2, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.b();
    if (localObject != null)
    {
      long l = paramLong - ((PathData.PointData)localObject).a();
      if (l <= 0L) {
        f = ((PathData.PointData)localObject).c();
      } else {
        f = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(l, ((PathData.PointData)localObject).a(), ((PathData.PointData)localObject).b(), paramFloat1, paramFloat2);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localObject != null) {
      ((PathDrawer)localObject).b(paramFloat1, paramFloat2, f, paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData.a(paramFloat1, paramFloat2, f, paramLong);
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
    PathDrawer localPathDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localPathDrawer != null) {
      localPathDrawer.a(paramBoolean);
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
    PathDrawer localPathDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDrawer;
    if (localPathDrawer != null) {
      return localPathDrawer.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    PathData localPathData = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData;
    if (localPathData == null) {
      return 0;
    }
    return localPathData.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDesc
 * JD-Core Version:    0.7.0.1
 */