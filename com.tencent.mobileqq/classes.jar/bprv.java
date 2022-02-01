import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bprv
  extends BaseAdapter
  implements bkij, bpry
{
  private int jdField_a_of_type_Int;
  private List<bprx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bprv(@NonNull List<bprx> paramList)
  {
    if (paramList.isEmpty()) {
      yqp.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bprx)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private bprw a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      bprx localbprx = (bprx)localIterator.next();
      j = localbprx.a() + i;
      if (paramInt <= j - 1) {
        return new bprw(localbprx, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((bprx)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public bprx a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bprx localbprx = (bprx)localIterator.next();
      if (localbprx.a) {
        return localbprx;
      }
    }
    return null;
  }
  
  public void a(bprx parambprx)
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
    bprw localbprw = a(paramInt);
    return localbprw.jdField_a_of_type_Bprx.a(localbprw.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bprw localbprw = a(paramInt);
    bprx localbprx = localbprw.jdField_a_of_type_Bprx;
    int i = localbprw.jdField_a_of_type_Int;
    if (paramView == null) {
      paramView = localbprx.a(i, paramViewGroup);
    }
    for (;;)
    {
      localbprx.a(i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
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
    paramAdapterView = paramView.jdField_a_of_type_Bprx;
    if (!paramAdapterView.c) {}
    do
    {
      return;
      paramAdapterView.a(paramView.jdField_a_of_type_Int);
    } while ((paramAdapterView instanceof bpru));
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      bprx localbprx = (bprx)paramView.next();
      if (localbprx != paramAdapterView)
      {
        localbprx.b(false);
        localbprx.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprv
 * JD-Core Version:    0.7.0.1
 */