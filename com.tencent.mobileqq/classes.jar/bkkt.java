import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bkkt
  extends BaseAdapter
  implements bfpt, bkkw
{
  private int jdField_a_of_type_Int;
  private List<bkkv> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bkkt(@NonNull List<bkkv> paramList)
  {
    if (paramList.isEmpty()) {
      ved.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bkkv)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private bkku a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      bkkv localbkkv = (bkkv)localIterator.next();
      j = localbkkv.a() + i;
      if (paramInt <= j - 1) {
        return new bkku(localbkkv, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((bkkv)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public bkkv a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bkkv localbkkv = (bkkv)localIterator.next();
      if (localbkkv.a) {
        return localbkkv;
      }
    }
    return null;
  }
  
  public void a(bkkv parambkkv)
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
    bkku localbkku = a(paramInt);
    return localbkku.jdField_a_of_type_Bkkv.a(localbkku.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    bkkv localbkkv = ((bkku)localObject).jdField_a_of_type_Bkkv;
    paramInt = ((bkku)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localbkkv.a(paramInt, paramViewGroup);
    }
    localbkkv.a(paramInt, (View)localObject);
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
    paramAdapterView = paramView.jdField_a_of_type_Bkkv;
    if (!paramAdapterView.c) {}
    do
    {
      return;
      paramAdapterView.a(paramView.jdField_a_of_type_Int);
    } while ((paramAdapterView instanceof bkks));
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      bkkv localbkkv = (bkkv)paramView.next();
      if (localbkkv != paramAdapterView)
      {
        localbkkv.b(false);
        localbkkv.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkt
 * JD-Core Version:    0.7.0.1
 */