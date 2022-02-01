package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.graphics.Point;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.ui.Direction;
import com.tencent.biz.videostory.capture.widgets.RecyclerViewProxy;

public class DSVOrientation$VerticalHelper
  implements DSVOrientation.Helper
{
  public float a(Point paramPoint, int paramInt1, int paramInt2)
  {
    return paramInt2 - paramPoint.y;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public void a(int paramInt, RecyclerViewProxy paramRecyclerViewProxy)
  {
    paramRecyclerViewProxy.b(paramInt);
  }
  
  public void a(Point paramPoint1, int paramInt, Point paramPoint2)
  {
    int i = paramPoint1.y;
    paramPoint2.set(paramPoint1.x, i - paramInt);
  }
  
  public void a(Direction paramDirection, int paramInt, Point paramPoint)
  {
    int i = paramPoint.y;
    paramInt = paramDirection.a(paramInt);
    paramPoint.set(paramPoint.x, i + paramInt);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = paramPoint.y;
    int i = paramPoint.y;
    return (paramInt1 - paramInt2 < paramInt3 + paramInt4) && (i + paramInt2 > -paramInt4);
  }
  
  public boolean a(AEBottomListScrollLayoutManager paramAEBottomListScrollLayoutManager)
  {
    View localView1 = paramAEBottomListScrollLayoutManager.a();
    View localView2 = paramAEBottomListScrollLayoutManager.b();
    int i = -paramAEBottomListScrollLayoutManager.c();
    int j = paramAEBottomListScrollLayoutManager.getHeight();
    int k = paramAEBottomListScrollLayoutManager.c();
    int m = paramAEBottomListScrollLayoutManager.getDecoratedTop(localView1);
    boolean bool = false;
    if ((m > i) && (paramAEBottomListScrollLayoutManager.getPosition(localView1) > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramAEBottomListScrollLayoutManager.getDecoratedBottom(localView2) < j + k) && (paramAEBottomListScrollLayoutManager.getPosition(localView2) < paramAEBottomListScrollLayoutManager.getItemCount() - 1)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) || (j != 0)) {
      bool = true;
    }
    return bool;
  }
  
  public int b(int paramInt)
  {
    return paramInt;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.DSVOrientation.VerticalHelper
 * JD-Core Version:    0.7.0.1
 */