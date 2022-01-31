import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class aodg
  extends RecyclerView.Adapter<aodk>
{
  private aodj jdField_a_of_type_Aodj;
  private aodw jdField_a_of_type_Aodw;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public aodk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aodk(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558841, paramViewGroup, false));
  }
  
  public void a(aodj paramaodj)
  {
    this.jdField_a_of_type_Aodj = paramaodj;
  }
  
  public void a(aodk paramaodk, int paramInt)
  {
    aobw.a((ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramaodk, paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(aodw paramaodw)
  {
    this.jdField_a_of_type_Aodw = paramaodw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodg
 * JD-Core Version:    0.7.0.1
 */