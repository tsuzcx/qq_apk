package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

class VisitorsActivity$11
  implements IIconListener
{
  VisitorsActivity$11(VisitorsActivity paramVisitorsActivity) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i = 0;
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      paramBitmap = this.a.a;
      if (paramBitmap == null) {
        break label108;
      }
      paramInt2 = paramBitmap.getChildCount();
    }
    for (;;)
    {
      if (i < paramInt2)
      {
        Object localObject = paramBitmap.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof VisitorsActivity.CustomViewHolder)))
        {
          localObject = (VisitorsActivity.CustomViewHolder)localObject;
          if ((((VisitorsActivity.CustomViewHolder)localObject).b == paramInt1) && (((VisitorsActivity.CustomViewHolder)localObject).e != null)) {
            VisitorsActivity.a(this.a, ((VisitorsActivity.CustomViewHolder)localObject).e, paramInt1);
          }
        }
        i += 1;
      }
      else
      {
        return;
        label108:
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.11
 * JD-Core Version:    0.7.0.1
 */