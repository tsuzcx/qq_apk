import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.tencent.mobileqq.emosm.view.DragSortItemView;
import com.tencent.mobileqq.emosm.view.DragSortItemViewCheckable;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;

public class arbr
  extends BaseAdapter
{
  private ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  
  public arbr(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(new arbs(this, paramDragSortListView));
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      localObject = (DragSortItemView)paramView;
      localView1 = ((DragSortItemView)localObject).getChildAt(0);
      View localView2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView1, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          ((DragSortItemView)localObject).removeViewAt(0);
        }
        ((DragSortItemView)localObject).addView(localView2);
      }
      DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount() + paramInt, (View)localObject, true);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    View localView1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, null, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    if ((localView1 instanceof Checkable)) {}
    for (Object localObject = new DragSortItemViewCheckable(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext());; localObject = new DragSortItemView(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext()))
    {
      ((DragSortItemView)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((DragSortItemView)localObject).addView(localView1);
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbr
 * JD-Core Version:    0.7.0.1
 */