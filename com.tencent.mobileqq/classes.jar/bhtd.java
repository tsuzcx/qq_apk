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

public class bhtd
  extends RecyclerView.Adapter<bhtf>
{
  private static List<bhsi> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bhtd(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    a();
    this.jdField_a_of_type_JavaLangString = ((bhsi)jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_JavaLangString;
    this.b = ((bhsi)jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).b;
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilList = bhsh.jdField_a_of_type_JavaUtilList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public bhtf a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new bhtf(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492973, paramViewGroup, false));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = ((bhsi)jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    this.b = ((bhsi)jdField_a_of_type_JavaUtilList.get(paramInt)).b;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(@NonNull bhtf parambhtf, int paramInt)
  {
    parambhtf.a(((bhsi)jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
    if (paramInt == this.jdField_a_of_type_Int) {
      parambhtf.a(true);
    }
    for (;;)
    {
      parambhtf.itemView.setOnClickListener(new bhte(this, paramInt, parambhtf));
      return;
      parambhtf.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhtd
 * JD-Core Version:    0.7.0.1
 */