import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import java.util.List;

public class bmmh
  extends RecyclerView.Adapter<bmmj>
{
  private int jdField_a_of_type_Int = -1;
  private bmml jdField_a_of_type_Bmml;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private String b = "";
  
  public bmmh(String paramString, List<Integer> paramList, bmml parambmml)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bmml = parambmml;
  }
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
    }
    return 0;
  }
  
  private void b(bmmj parambmmj, int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      parambmmj.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambmmj.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public bmmj a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bmmj(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558541, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      this.jdField_a_of_type_Bmml.a(this.jdField_a_of_type_JavaLangString, a(paramInt), paramInt, this.b);
    }
  }
  
  public void a(bmmj parambmmj, int paramInt)
  {
    parambmmj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(AEEditorColorSelectorView.a(parambmmj.jdField_a_of_type_AndroidWidgetImageView, false, a(paramInt)));
    parambmmj.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bmmi(this, paramInt, parambmmj));
    b(parambmmj, paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(parambmmj, paramInt, getItemId(paramInt));
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmh
 * JD-Core Version:    0.7.0.1
 */