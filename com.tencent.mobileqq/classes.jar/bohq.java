import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import java.util.List;

public class bohq
  extends RecyclerView.Adapter<bohs>
{
  private int jdField_a_of_type_Int = -1;
  private bohu jdField_a_of_type_Bohu;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private String b = "";
  
  public bohq(String paramString, List<Integer> paramList, bohu parambohu)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bohu = parambohu;
  }
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
    }
    return 0;
  }
  
  private void b(bohs parambohs, int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      parambohs.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambohs.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public bohs a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bohs(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558540, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      this.jdField_a_of_type_Bohu.a(this.jdField_a_of_type_JavaLangString, a(paramInt), paramInt, this.b);
    }
  }
  
  public void a(bohs parambohs, int paramInt)
  {
    parambohs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(AEEditorColorSelectorView.a(parambohs.jdField_a_of_type_AndroidWidgetImageView, false, a(paramInt)));
    parambohs.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bohr(this, paramInt, parambohs));
    b(parambohs, paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(parambohs, paramInt, getItemId(paramInt));
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
 * Qualified Name:     bohq
 * JD-Core Version:    0.7.0.1
 */