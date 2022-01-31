import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bmwd
  extends BaseAdapter
  implements bhqp, bmwg
{
  private int jdField_a_of_type_Int;
  private List<bmwf> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bmwd(@NonNull List<bmwf> paramList)
  {
    if (paramList.isEmpty()) {
      wsv.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bmwf)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private bmwe a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      bmwf localbmwf = (bmwf)localIterator.next();
      j = localbmwf.a() + i;
      if (paramInt <= j - 1) {
        return new bmwe(localbmwf, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((bmwf)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public bmwf a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmwf localbmwf = (bmwf)localIterator.next();
      if (localbmwf.a) {
        return localbmwf;
      }
    }
    return null;
  }
  
  public void a(bmwf parambmwf)
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    bmwe localbmwe = a(paramInt);
    return localbmwe.jdField_a_of_type_Bmwf.a(localbmwe.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    bmwf localbmwf = ((bmwe)localObject).jdField_a_of_type_Bmwf;
    paramInt = ((bmwe)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localbmwf.a(paramInt, paramViewGroup);
    }
    localbmwf.a(paramInt, (View)localObject);
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = a(paramInt);
    paramAdapterView = paramView.jdField_a_of_type_Bmwf;
    if (!paramAdapterView.c) {}
    do
    {
      return;
      paramAdapterView.a(paramView.jdField_a_of_type_Int);
    } while ((paramAdapterView instanceof bmwc));
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      bmwf localbmwf = (bmwf)paramView.next();
      if (localbmwf != paramAdapterView)
      {
        localbmwf.b(false);
        localbmwf.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwd
 * JD-Core Version:    0.7.0.1
 */