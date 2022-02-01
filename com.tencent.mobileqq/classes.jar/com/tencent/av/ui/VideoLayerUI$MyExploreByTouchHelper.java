package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import java.util.List;

class VideoLayerUI$MyExploreByTouchHelper
  extends ExploreByTouchHelper
{
  public VideoLayerUI$MyExploreByTouchHelper(VideoLayerUI paramVideoLayerUI, View paramView)
  {
    super(paramView);
  }
  
  private Rect a(int paramInt)
  {
    Rect localRect = new Rect(0, 0, 1, 1);
    if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].a() == 0)) {
      localRect.set(this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].b());
    }
    return localRect;
  }
  
  private String a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null) && (paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      int i = -1;
      int j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().k;
      if (j == 3000) {
        i = 1004;
      } else if (j == 1) {
        i = 1000;
      } else if (j == 0) {
        i = 0;
      }
      Resources localResources = this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      Object localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      Object localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].c();
      if (localObject1 != null)
      {
        if (((String)localObject1).equals(localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localResources.getString(2131694384));
          ((StringBuilder)localObject1).append(localResources.getString(2131695561));
          return ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().f)));
        ((StringBuilder)localObject2).append(localResources.getString(2131695561));
        return ((StringBuilder)localObject2).toString();
      }
    }
    return "";
  }
  
  protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null)
    {
      int i = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1;
      while (i >= 0)
      {
        if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].a() == 0) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].b().contains((int)paramFloat1, (int)paramFloat2))) {
          return i;
        }
        i -= 1;
      }
    }
    return 0;
  }
  
  protected void getVisibleVirtualViews(List<Integer> paramList)
  {
    if (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null)
    {
      int j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length;
      int i = 0;
      while (i < j)
      {
        paramList.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
  
  protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    paramAccessibilityEvent.setContentDescription(a(paramInt));
  }
  
  protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramAccessibilityNodeInfoCompat.addAction(16);
    paramAccessibilityNodeInfoCompat.setContentDescription(a(paramInt));
    Rect localRect = a(paramInt);
    if (localRect.isEmpty()) {
      localRect.set(0, 0, 1, 1);
    }
    paramAccessibilityNodeInfoCompat.setBoundsInParent(localRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MyExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */