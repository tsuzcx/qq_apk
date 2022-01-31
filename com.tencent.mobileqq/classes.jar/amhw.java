import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class amhw
  extends RecyclerView.Adapter<amia>
{
  private amhz jdField_a_of_type_Amhz;
  private amim jdField_a_of_type_Amim;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public amia a(ViewGroup paramViewGroup, int paramInt)
  {
    return new amia(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558806, paramViewGroup, false));
  }
  
  public void a(amhz paramamhz)
  {
    this.jdField_a_of_type_Amhz = paramamhz;
  }
  
  public void a(amia paramamia, int paramInt)
  {
    amgn.a((ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramamia, paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(amim paramamim)
  {
    this.jdField_a_of_type_Amim = paramamim;
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
 * Qualified Name:     amhw
 * JD-Core Version:    0.7.0.1
 */