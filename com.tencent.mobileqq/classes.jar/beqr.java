import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class beqr<M, VH extends bequ<M>>
  extends beqv<M, VH>
{
  private List<M> a;
  
  public beqr(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public abstract int a(int paramInt);
  
  public M a(int paramInt)
  {
    if (((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size() + c())) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
  }
  
  public List<M> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public boolean a(List<M> paramList)
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      boolean bool = i | this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (bool) {
        notifyDataSetChanged();
      }
      return bool;
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) {
      return 1024;
    }
    if ((this.b != null) && (paramInt == this.jdField_a_of_type_JavaUtilList.size() + c())) {
      return 1025;
    }
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beqr
 * JD-Core Version:    0.7.0.1
 */