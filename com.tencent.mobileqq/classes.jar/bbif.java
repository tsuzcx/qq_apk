import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.mobileqq.widget.MeasureGridView;

public class bbif
  extends BaseAdapter
{
  public bbif(DraggableGridView paramDraggableGridView) {}
  
  public int getCount()
  {
    if (DraggableGridView.a(this.a) != null) {
      return DraggableGridView.a(this.a).a() * 2;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((DraggableGridView.a(this.a) != null) && (paramInt % 2 == 0)) {
      return DraggableGridView.a(this.a).a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt % 2 == 0) {
      return DraggableGridView.a(this.a).b(paramInt / 2) + 1;
    }
    return DraggableGridView.a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (getItemViewType(paramInt) == DraggableGridView.a())
    {
      if (paramView == null)
      {
        paramViewGroup = (MeasureGridView)LayoutInflater.from(this.a.getContext()).inflate(2131494729, paramViewGroup, false);
        paramViewGroup.setClickable(false);
        paramViewGroup.setNumColumns(DraggableGridView.a(this.a));
        paramViewGroup.setAdapter(new bbig(this.a, paramInt / 2));
        paramView = paramViewGroup;
      }
      for (;;)
      {
        paramViewGroup.setTag(Integer.valueOf(paramInt / 2));
        localObject = paramView;
        return localObject;
        paramViewGroup = (MeasureGridView)paramView;
        ((bbig)paramViewGroup.getAdapter()).a(paramInt / 2);
      }
    }
    if (paramView == null) {
      paramView = DraggableGridView.a(this.a).a(LayoutInflater.from(this.a.getContext()), paramInt / 2, paramViewGroup);
    }
    for (paramViewGroup = paramView;; paramViewGroup = paramView)
    {
      localObject = paramViewGroup;
      if (DraggableGridView.a(this.a) == null) {
        break;
      }
      DraggableGridView.a(this.a).a(paramView, paramInt / 2);
      return paramViewGroup;
    }
  }
  
  public int getViewTypeCount()
  {
    return DraggableGridView.a(this.a).b() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbif
 * JD-Core Version:    0.7.0.1
 */