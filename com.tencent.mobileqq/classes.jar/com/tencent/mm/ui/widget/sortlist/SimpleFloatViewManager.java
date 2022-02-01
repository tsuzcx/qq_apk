package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.ui.f;

public class SimpleFloatViewManager
  implements DragSortListView.FloatViewManager
{
  private Bitmap a;
  private ImageView b;
  private int c = -16777216;
  private ListView d;
  
  public SimpleFloatViewManager(ListView paramListView)
  {
    this.d = paramListView;
  }
  
  public View onCreateFloatView(int paramInt)
  {
    Object localObject = this.d;
    localObject = ((ListView)localObject).getChildAt(paramInt + ((ListView)localObject).getHeaderViewsCount() - this.d.getFirstVisiblePosition());
    if (localObject == null) {
      return null;
    }
    ((View)localObject).setPressed(false);
    ((View)localObject).setDrawingCacheEnabled(true);
    this.a = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.b == null) {
      this.b = new ImageView(this.d.getContext());
    }
    this.b.setBackgroundColor(this.c);
    this.b.setPadding(0, 0, 0, 0);
    this.b.setImageBitmap(this.a);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    return this.b;
  }
  
  public void onDestroyFloatView(View paramView)
  {
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    f.c("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.a.toString() });
    this.a.recycle();
    this.a = null;
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2) {}
  
  public void setBackgroundColor(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.SimpleFloatViewManager
 * JD-Core Version:    0.7.0.1
 */