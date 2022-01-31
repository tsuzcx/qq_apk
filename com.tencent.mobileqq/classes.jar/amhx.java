import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class amhx
  extends RecyclerView.Adapter<amib>
{
  private amia jdField_a_of_type_Amia;
  private amin jdField_a_of_type_Amin;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public amib a(ViewGroup paramViewGroup, int paramInt)
  {
    return new amib(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558806, paramViewGroup, false));
  }
  
  public void a(amia paramamia)
  {
    this.jdField_a_of_type_Amia = paramamia;
  }
  
  public void a(amib paramamib, int paramInt)
  {
    amgo.a((ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramamib, paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(amin paramamin)
  {
    this.jdField_a_of_type_Amin = paramamin;
  }
  
  void a(List<ColorNote> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhx
 * JD-Core Version:    0.7.0.1
 */