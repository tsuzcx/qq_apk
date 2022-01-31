import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public abstract class bceu<VH extends RecyclerView.ViewHolder, D extends bcdy>
  implements View.OnClickListener
{
  public bcev a;
  public XMediaEditor a;
  
  public bceu(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = paramXMediaEditor;
  }
  
  public abstract VH a(ViewGroup paramViewGroup);
  
  public bceu a(bcev parambcev)
  {
    this.jdField_a_of_type_Bcev = parambcev;
    return this;
  }
  
  public bcev a()
  {
    return this.jdField_a_of_type_Bcev;
  }
  
  public void a() {}
  
  public void a(VH paramVH) {}
  
  public abstract void a(VH paramVH, D paramD, int paramInt);
  
  public abstract void a(View paramView, VH paramVH);
  
  public void b(VH paramVH) {}
  
  public void b(View paramView, VH paramVH)
  {
    paramView.setTag(paramVH);
    paramView.setOnClickListener(this);
  }
  
  public void b(D paramD) {}
  
  public void c(VH paramVH) {}
  
  public void c(D paramD) {}
  
  public void d(D paramD) {}
  
  public void onClick(View paramView)
  {
    a(paramView, (RecyclerView.ViewHolder)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceu
 * JD-Core Version:    0.7.0.1
 */