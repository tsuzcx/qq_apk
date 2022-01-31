import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

class bljp
  implements View.OnClickListener
{
  bljp(bljo parambljo, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean;
    boolean bool = true;
    if (bljo.a(this.jdField_a_of_type_Bljo) != null) {
      bool = bljo.a(this.jdField_a_of_type_Bljo).a(this.jdField_a_of_type_Int, paramView);
    }
    if (bool)
    {
      bljo.a(this.jdField_a_of_type_Bljo, this.jdField_a_of_type_Int);
      int i = bljo.a(this.jdField_a_of_type_Bljo);
      bljo.a(this.jdField_a_of_type_Bljo, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bljo.notifyItemChanged(i);
      this.jdField_a_of_type_Bljo.notifyItemChanged(bljo.a(this.jdField_a_of_type_Bljo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljp
 * JD-Core Version:    0.7.0.1
 */