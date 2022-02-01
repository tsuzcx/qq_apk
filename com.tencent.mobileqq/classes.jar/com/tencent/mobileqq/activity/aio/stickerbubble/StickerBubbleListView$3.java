package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.graphics.Rect;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class StickerBubbleListView$3
  implements StickerBubbleListView.Action
{
  StickerBubbleListView$3(StickerBubbleListView paramStickerBubbleListView) {}
  
  public void a(View paramView)
  {
    if (((paramView instanceof StickerBubbleImageView)) && (paramView.getVisibility() == 0))
    {
      Object localObject = (StickerBubbleImageView)paramView;
      ((StickerBubbleImageView)localObject).a();
      if ((StickerBubbleListView.b(this.a) == null) || (StickerBubbleListView.b(this.a).get() != paramView)) {
        StickerBubbleListView.a(this.a, new WeakReference(localObject));
      }
      paramView = (View)paramView.getParent();
      localObject = (View)paramView.getParent();
      if (StickerBubbleListView.c(this.a) == null) {
        StickerBubbleListView.a(this.a, new Rect());
      }
      StickerBubbleListView.c(this.a).set(((View)localObject).getLeft() + paramView.getLeft(), ((View)localObject).getTop() + paramView.getTop(), ((View)localObject).getLeft() + paramView.getRight(), ((View)localObject).getTop() + paramView.getBottom());
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("notifyItemViewTouchDown with rect: ");
        paramView.append(StickerBubbleListView.c(this.a));
        QLog.d("StickerBubbleListView", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView.3
 * JD-Core Version:    0.7.0.1
 */