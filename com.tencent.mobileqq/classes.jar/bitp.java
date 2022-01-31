import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bitp
  extends BaseAdapter
  implements behi, bits
{
  private int jdField_a_of_type_Int;
  private List<bitr> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bitp(@NonNull List<bitr> paramList)
  {
    if (paramList.isEmpty()) {
      urk.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bitr)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private bitq a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      bitr localbitr = (bitr)localIterator.next();
      j = localbitr.a() + i;
      if (paramInt <= j - 1) {
        return new bitq(localbitr, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((bitr)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public bitr a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bitr localbitr = (bitr)localIterator.next();
      if (localbitr.a) {
        return localbitr;
      }
    }
    return null;
  }
  
  public void a(bitr parambitr)
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
    bitq localbitq = a(paramInt);
    return localbitq.jdField_a_of_type_Bitr.a(localbitq.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    bitr localbitr = ((bitq)localObject).jdField_a_of_type_Bitr;
    paramInt = ((bitq)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localbitr.a(paramInt, paramViewGroup);
    }
    localbitr.a(paramInt, (View)localObject);
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
    paramAdapterView = paramView.jdField_a_of_type_Bitr;
    if (!paramAdapterView.c) {}
    do
    {
      return;
      paramAdapterView.a(paramView.jdField_a_of_type_Int);
    } while ((paramAdapterView instanceof bito));
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      bitr localbitr = (bitr)paramView.next();
      if (localbitr != paramAdapterView)
      {
        localbitr.b(false);
        localbitr.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitp
 * JD-Core Version:    0.7.0.1
 */