import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import javax.annotation.Nonnull;

public class blcx
  extends RecyclerView.Adapter<blcz>
{
  private static List<blcd> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public blcx(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    a();
    this.jdField_a_of_type_JavaLangString = ((blcd)jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_JavaLangString;
    this.b = ((blcd)jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).b;
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilList = blcc.jdField_a_of_type_JavaUtilList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public blcz a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new blcz(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558548, paramViewGroup, false));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = ((blcd)jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    this.b = ((blcd)jdField_a_of_type_JavaUtilList.get(paramInt)).b;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(@NonNull blcz paramblcz, int paramInt)
  {
    paramblcz.a(((blcd)jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
    if (paramInt == this.jdField_a_of_type_Int) {
      paramblcz.a(true);
    }
    for (;;)
    {
      paramblcz.itemView.setOnClickListener(new blcy(this, paramInt, paramblcz));
      return;
      paramblcz.a(false);
    }
  }
  
  @Nonnull
  public String b()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    return jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcx
 * JD-Core Version:    0.7.0.1
 */