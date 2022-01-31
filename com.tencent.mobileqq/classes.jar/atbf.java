import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class atbf
  extends BaseAdapter
{
  final BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  final atbj jdField_a_of_type_Atbj;
  
  atbf(atbj paramatbj, BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_Atbj = paramatbj;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(paramInt, paramView, paramViewGroup);
    this.jdField_a_of_type_Atbj.a(paramViewGroup, paramView, paramInt);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbf
 * JD-Core Version:    0.7.0.1
 */