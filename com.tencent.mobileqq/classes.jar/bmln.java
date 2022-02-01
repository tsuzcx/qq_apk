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

public class bmln
  extends RecyclerView.Adapter<bmlp>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bmlq jdField_a_of_type_Bmlq;
  private List<bmlo> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Set<bmlp> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public bmln(@NonNull Context paramContext, @Nullable bmlq parambmlq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmlq = parambmlq;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296347);
    this.jdField_a_of_type_Boolean = bmby.a();
  }
  
  @NonNull
  public bmlp a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bmlp(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558550, paramViewGroup, false), this.jdField_a_of_type_Bmlq, this.jdField_a_of_type_Int);
  }
  
  public List<bmlo> a()
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
        ((bmlp)localIterator.next()).a();
      }
    }
  }
  
  public void a(bmlp parambmlp)
  {
    super.onViewAttachedToWindow(parambmlp);
    this.jdField_a_of_type_JavaUtilSet.add(parambmlp);
  }
  
  public void a(@NonNull bmlp parambmlp, int paramInt)
  {
    parambmlp.a((bmlo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_JavaUtilList.size());
    EventCollector.getInstance().onRecyclerBindViewHolder(parambmlp, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bmlo> paramList)
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
  
  public void b(bmlp parambmlp)
  {
    super.onViewDetachedFromWindow(parambmlp);
    this.jdField_a_of_type_JavaUtilSet.remove(parambmlp);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmln
 * JD-Core Version:    0.7.0.1
 */