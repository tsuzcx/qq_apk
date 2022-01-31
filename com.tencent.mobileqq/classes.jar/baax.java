import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class baax
  implements bacd
{
  public baax(XMediaEditor paramXMediaEditor) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    paramInt1 = paramInt2 - paramInt1;
    if (XMediaEditor.a(this.a) != null) {
      XMediaEditor.a(this.a).a(XMediaEditor.a(this.a), XMediaEditor.a(this.a) + paramInt1);
    }
    XMediaEditor.a(this.a, paramInt1 + XMediaEditor.a(this.a));
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = ((bacf)paramViewHolder).jdField_a_of_type_Babg;
    this.a.a(paramViewHolder.c);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (XMediaEditor.a(this.a) != this.a.a.a())
    {
      paramViewHolder = this.a;
      if (XMediaEditor.a(this.a)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      XMediaEditor.a(paramViewHolder, paramBoolean);
      if (XMediaEditor.a(this.a) != null) {
        XMediaEditor.a(this.a).a(XMediaEditor.a(this.a));
      }
      return;
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = ((bacf)paramViewHolder).jdField_a_of_type_Babg.c;
    if (i == 0) {}
    while (this.a.a.a(i - 1).b() == -1) {
      return;
    }
    this.a.a(i - 1);
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bacu)paramViewHolder;
    if (XMediaEditor.a(this.a) != null) {
      XMediaEditor.a(this.a).a = false;
    }
    XMediaEditor.a(this.a, (babp)paramViewHolder.jdField_a_of_type_Babg);
    if (XMediaEditor.a(this.a) != null) {
      XMediaEditor.a(this.a).a(paramViewHolder.jdField_a_of_type_AndroidWidgetEditText, true);
    }
  }
  
  public void d(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bacu)paramViewHolder;
    if (XMediaEditor.a(this.a) != null) {
      XMediaEditor.a(this.a).a(paramViewHolder.jdField_a_of_type_AndroidWidgetEditText, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baax
 * JD-Core Version:    0.7.0.1
 */