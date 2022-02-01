package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import uxx;
import vjs;
import vkb;
import vks;
import vku;
import vsn;

public class QCircleContentPart$10
  implements Runnable
{
  public QCircleContentPart$10(vks paramvks, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    Object localObject2 = null;
    if (this.this$0.a() != null)
    {
      uxx.a(this.this$0.a(), 0);
      if (!vks.b(this.this$0)) {
        break label190;
      }
      if (vks.a(this.this$0) != null) {
        vks.a(this.this$0).setInnerViewVisiable(8);
      }
      if (vks.a(this.this$0) == null) {
        break label294;
      }
    }
    label294:
    for (Matrix localMatrix = vks.a(this.this$0).getMatrix();; localMatrix = null)
    {
      if (vks.a(this.this$0) != null)
      {
        Object localObject1 = localObject2;
        if (vks.a(this.this$0) != null)
        {
          localObject1 = localObject2;
          if (vks.a(this.this$0).a() != null)
          {
            Object localObject3 = vks.a(this.this$0).a();
            localObject1 = localObject2;
            if ((localObject3 instanceof vjs))
            {
              localObject3 = ((vjs)localObject3).a;
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((QCircleContentImage)localObject3).a();
              }
            }
          }
        }
        vks.a(this.this$0).a(localMatrix, (ImageView)localObject1, new vku(this));
      }
      return;
      label190:
      this.this$0.a().finish();
      int i;
      if (Math.abs(this.a) <= Math.abs(this.b)) {
        if (this.b > 0.0F) {
          i = 2130772340;
        }
      }
      for (;;)
      {
        int j = i;
        if (this.a == 0.0F)
        {
          j = i;
          if (this.b == 0.0F) {
            j = 0;
          }
        }
        this.this$0.a().overridePendingTransition(0, j);
        return;
        i = 2130772344;
        continue;
        if (this.a > 0.0F) {
          i = 2130772320;
        } else {
          i = 2130772321;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.10
 * JD-Core Version:    0.7.0.1
 */