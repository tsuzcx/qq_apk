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

public class bpir
  extends RecyclerView.Adapter<bpit>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bpiu jdField_a_of_type_Bpiu;
  private List<bpis> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Set<bpit> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public bpir(@NonNull Context paramContext, @Nullable bpiu parambpiu)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bpiu = parambpiu;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296294);
    this.jdField_a_of_type_Boolean = bpan.a();
  }
  
  @NonNull
  public bpit a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bpit(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558551, paramViewGroup, false), this.jdField_a_of_type_Bpiu, this.jdField_a_of_type_Int);
  }
  
  public List<bpis> a()
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
        ((bpit)localIterator.next()).a();
      }
    }
  }
  
  public void a(bpit parambpit)
  {
    super.onViewAttachedToWindow(parambpit);
    this.jdField_a_of_type_JavaUtilSet.add(parambpit);
  }
  
  public void a(@NonNull bpit parambpit, int paramInt)
  {
    parambpit.a((bpis)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_JavaUtilList.size());
    EventCollector.getInstance().onRecyclerBindViewHolder(parambpit, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bpis> paramList)
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
  
  public void b(bpit parambpit)
  {
    super.onViewDetachedFromWindow(parambpit);
    this.jdField_a_of_type_JavaUtilSet.remove(parambpit);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpir
 * JD-Core Version:    0.7.0.1
 */