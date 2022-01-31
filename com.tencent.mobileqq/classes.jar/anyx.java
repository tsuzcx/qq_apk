import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class anyx
  extends RecyclerView.Adapter<anzb>
{
  private anza jdField_a_of_type_Anza;
  private anzn jdField_a_of_type_Anzn;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public anzb a(ViewGroup paramViewGroup, int paramInt)
  {
    return new anzb(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558842, paramViewGroup, false));
  }
  
  public void a(anza paramanza)
  {
    this.jdField_a_of_type_Anza = paramanza;
  }
  
  public void a(anzb paramanzb, int paramInt)
  {
    anxn.a((ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramanzb, paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(anzn paramanzn)
  {
    this.jdField_a_of_type_Anzn = paramanzn;
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
 * Qualified Name:     anyx
 * JD-Core Version:    0.7.0.1
 */