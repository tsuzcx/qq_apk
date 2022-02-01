import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class bobf
  extends RecyclerView.Adapter<bobh>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bobi jdField_a_of_type_Bobi;
  private List<bobg> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Set<bobh> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public bobf(@NonNull Context paramContext, @Nullable bobi parambobi)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bobi = parambobi;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296347);
    this.jdField_a_of_type_Boolean = bnri.a();
  }
  
  @NonNull
  public bobh a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bobh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558561, paramViewGroup, false), this.jdField_a_of_type_Bobi, this.jdField_a_of_type_Int);
  }
  
  public List<bobg> a()
  {
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilSet)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext()) {
        ((bobh)localIterator.next()).a();
      }
    }
  }
  
  public void a(bobh parambobh)
  {
    super.onViewAttachedToWindow(parambobh);
    this.jdField_a_of_type_JavaUtilSet.add(parambobh);
  }
  
  public void a(@NonNull bobh parambobh, int paramInt)
  {
    parambobh.a((bobg)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_JavaUtilList.size());
    EventCollector.getInstance().onRecyclerBindViewHolder(parambobh, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bobg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void b(bobh parambobh)
  {
    super.onViewDetachedFromWindow(parambobh);
    this.jdField_a_of_type_JavaUtilSet.remove(parambobh);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobf
 * JD-Core Version:    0.7.0.1
 */