import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhwi
  extends BaseAdapter
{
  public bhwi(DraggableGridView paramDraggableGridView) {}
  
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
    if (getItemViewType(paramInt) == DraggableGridView.a())
    {
      if (paramView == null)
      {
        localObject = (MeasureGridView)LayoutInflater.from(this.a.getContext()).inflate(2131560563, paramViewGroup, false);
        ((MeasureGridView)localObject).setClickable(false);
        ((MeasureGridView)localObject).setNumColumns(DraggableGridView.a(this.a));
        ((MeasureGridView)localObject).setAdapter(new bhwj(this.a, paramInt / 2));
        paramView = (View)localObject;
      }
      for (;;)
      {
        ((MeasureGridView)localObject).setTag(Integer.valueOf(paramInt / 2));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (MeasureGridView)paramView;
        ((bhwj)((MeasureGridView)localObject).getAdapter()).a(paramInt / 2);
      }
    }
    if (paramView == null) {
      paramView = DraggableGridView.a(this.a).a(LayoutInflater.from(this.a.getContext()), paramInt / 2, paramViewGroup);
    }
    for (Object localObject = paramView;; localObject = paramView)
    {
      if (DraggableGridView.a(this.a) != null) {
        DraggableGridView.a(this.a).a(paramView, paramInt / 2);
      }
      paramView = (View)localObject;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return DraggableGridView.a(this.a).b() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwi
 * JD-Core Version:    0.7.0.1
 */