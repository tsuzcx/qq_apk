import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import java.util.List;

public class bobz
  extends RecyclerView.Adapter<bocb>
{
  private int jdField_a_of_type_Int = -1;
  private bocd jdField_a_of_type_Bocd;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private String b = "";
  
  public bobz(String paramString, List<Integer> paramList, bocd parambocd)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bocd = parambocd;
  }
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
    }
    return 0;
  }
  
  private void b(bocb parambocb, int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      parambocb.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambocb.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public bocb a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bocb(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558552, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      this.jdField_a_of_type_Bocd.a(this.jdField_a_of_type_JavaLangString, a(paramInt), paramInt, this.b);
    }
  }
  
  public void a(bocb parambocb, int paramInt)
  {
    parambocb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(AEEditorColorSelectorView.a(parambocb.jdField_a_of_type_AndroidWidgetImageView, false, a(paramInt)));
    parambocb.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new boca(this, paramInt, parambocb));
    b(parambocb, paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(parambocb, paramInt, getItemId(paramInt));
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
 * Qualified Name:     bobz
 * JD-Core Version:    0.7.0.1
 */