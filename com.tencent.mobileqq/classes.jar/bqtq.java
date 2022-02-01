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

public class bqtq
  extends BaseAdapter
  implements bljm, bqtt
{
  private int jdField_a_of_type_Int;
  private List<bqts> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bqtq(@NonNull List<bqts> paramList)
  {
    if (paramList.isEmpty()) {
      yuk.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bqts)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private bqtr a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      bqts localbqts = (bqts)localIterator.next();
      j = localbqts.a() + i;
      if (paramInt <= j - 1) {
        return new bqtr(localbqts, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((bqts)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public bqts a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bqts localbqts = (bqts)localIterator.next();
      if (localbqts.a) {
        return localbqts;
      }
    }
    return null;
  }
  
  public void a(bqts parambqts)
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
    bqtr localbqtr = a(paramInt);
    return localbqtr.jdField_a_of_type_Bqts.a(localbqtr.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bqtr localbqtr = a(paramInt);
    bqts localbqts = localbqtr.jdField_a_of_type_Bqts;
    int i = localbqtr.jdField_a_of_type_Int;
    if (paramView == null) {
      paramView = localbqts.a(i, paramViewGroup);
    }
    for (;;)
    {
      localbqts.a(i, paramView);
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
    paramAdapterView = paramView.jdField_a_of_type_Bqts;
    if (!paramAdapterView.c) {}
    do
    {
      return;
      paramAdapterView.a(paramView.jdField_a_of_type_Int);
    } while ((paramAdapterView instanceof bqtp));
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      bqts localbqts = (bqts)paramView.next();
      if (localbqts != paramAdapterView)
      {
        localbqts.b(false);
        localbqts.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqtq
 * JD-Core Version:    0.7.0.1
 */