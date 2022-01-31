import android.view.MotionEvent;
import com.tencent.widget.ARMapHongBaoListView;

public abstract interface bhto
{
  public abstract int getMode();
  
  public abstract int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView);
  
  public abstract void onFlingScrollHeader(int paramInt1, int paramInt2);
  
  public abstract void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent);
  
  public abstract int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhto
 * JD-Core Version:    0.7.0.1
 */