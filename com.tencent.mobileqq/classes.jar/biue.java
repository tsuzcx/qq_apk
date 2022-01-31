import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.ttpic.baseutils.device.DeviceUtils;

class biue
  extends RecyclerView.ItemDecoration
{
  biue(biua parambiua) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView) % 2;
    int j = (int)(DeviceUtils.getScreenWidth(biua.a(this.a)) * 0.04F);
    paramRect.left = (j - i * j / 2);
    paramRect.right = ((i + 1) * j / 2);
    paramRect.bottom = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biue
 * JD-Core Version:    0.7.0.1
 */