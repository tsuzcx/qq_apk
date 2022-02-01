import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class blig<M, VH extends blij<M>>
  extends blik<M, VH>
{
  private List<M> a;
  
  public blig(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public blig(Context paramContext, List<M> paramList)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public abstract int a(int paramInt);
  
  public M a(int paramInt)
  {
    if (((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size() + d())) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
  }
  
  public void a(M paramM)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramM);
    if (i < 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(i);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      notifyItemRemoved(i);
      return;
    }
    notifyItemRemoved(i + 1);
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
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public List<M> b()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public boolean b(List<M> paramList)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (bool) {
      notifyItemRangeInserted(this.jdField_a_of_type_JavaUtilList.size() - paramList.size(), paramList.size());
    }
    return bool;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + c();
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
    if ((this.b != null) && (paramInt == this.jdField_a_of_type_JavaUtilList.size() + d())) {
      return 1025;
    }
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blig
 * JD-Core Version:    0.7.0.1
 */