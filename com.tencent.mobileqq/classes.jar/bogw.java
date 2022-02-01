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

public class bogw
  extends RecyclerView.Adapter<bogy>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bogz jdField_a_of_type_Bogz;
  private List<bogx> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Set<bogy> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public bogw(@NonNull Context paramContext, @Nullable bogz parambogz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bogz = parambogz;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296290);
    this.jdField_a_of_type_Boolean = bnzc.a();
  }
  
  @NonNull
  public bogy a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bogy(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558549, paramViewGroup, false), this.jdField_a_of_type_Bogz, this.jdField_a_of_type_Int);
  }
  
  public List<bogx> a()
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
        ((bogy)localIterator.next()).a();
      }
    }
  }
  
  public void a(bogy parambogy)
  {
    super.onViewAttachedToWindow(parambogy);
    this.jdField_a_of_type_JavaUtilSet.add(parambogy);
  }
  
  public void a(@NonNull bogy parambogy, int paramInt)
  {
    parambogy.a((bogx)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_JavaUtilList.size());
    EventCollector.getInstance().onRecyclerBindViewHolder(parambogy, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<bogx> paramList)
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
  
  public void b(bogy parambogy)
  {
    super.onViewDetachedFromWindow(parambogy);
    this.jdField_a_of_type_JavaUtilSet.remove(parambogy);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogw
 * JD-Core Version:    0.7.0.1
 */