import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.tencent.mobileqq.emosm.view.DragSortItemView;
import com.tencent.mobileqq.emosm.view.DragSortItemViewCheckable;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.widget.AbsListView.LayoutParams;

public class antn
  extends BaseAdapter
{
  private ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  
  public antn(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(new anto(this, paramDragSortListView));
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
      paramViewGroup = (DragSortItemView)paramView;
      View localView1 = paramViewGroup.getChildAt(0);
      View localView2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView1, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      paramView = paramViewGroup;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          paramViewGroup.removeViewAt(0);
        }
        paramViewGroup.addView(localView2);
        paramView = paramViewGroup;
      }
      DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount() + paramInt, paramView, true);
      return paramView;
    }
    paramViewGroup = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, null, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    if ((paramViewGroup instanceof Checkable)) {}
    for (paramView = new DragSortItemViewCheckable(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext());; paramView = new DragSortItemView(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext()))
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.addView(paramViewGroup);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     antn
 * JD-Core Version:    0.7.0.1
 */