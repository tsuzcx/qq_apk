import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public abstract class azaw<VH extends RecyclerView.ViewHolder, D extends azaa>
  implements View.OnClickListener
{
  public azax a;
  public XMediaEditor a;
  
  public azaw(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = paramXMediaEditor;
  }
  
  public abstract VH a(ViewGroup paramViewGroup);
  
  public azaw a(azax paramazax)
  {
    this.jdField_a_of_type_Azax = paramazax;
    return this;
  }
  
  public azax a()
  {
    return this.jdField_a_of_type_Azax;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azaw
 * JD-Core Version:    0.7.0.1
 */