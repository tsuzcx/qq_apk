import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public class blju
  extends RecyclerView.Adapter<bljw>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bljx jdField_a_of_type_Bljx;
  private List<bljv> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public blju(@NonNull Context paramContext, @Nullable bljx parambljx)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bljx = parambljx;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296270);
  }
  
  @NonNull
  public bljw a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bljw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558533, paramViewGroup, false), this.jdField_a_of_type_Bljx, this.jdField_a_of_type_Int);
  }
  
  public List<bljv> a()
  {
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(@NonNull bljw parambljw, int paramInt)
  {
    parambljw.a((bljv)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  public void a(@NonNull List<bljv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blju
 * JD-Core Version:    0.7.0.1
 */