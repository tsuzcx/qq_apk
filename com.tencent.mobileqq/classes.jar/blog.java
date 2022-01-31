import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public class blog
  extends RecyclerView.Adapter<bloi>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bloj jdField_a_of_type_Bloj;
  private List<bloh> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public blog(@NonNull Context paramContext, @Nullable bloj parambloj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bloj = parambloj;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296270);
  }
  
  @NonNull
  public bloi a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bloi(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558533, paramViewGroup, false), this.jdField_a_of_type_Bloj, this.jdField_a_of_type_Int);
  }
  
  public List<bloh> a()
  {
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(@NonNull bloi parambloi, int paramInt)
  {
    parambloi.a((bloh)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  public void a(@NonNull List<bloh> paramList)
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
 * Qualified Name:     blog
 * JD-Core Version:    0.7.0.1
 */