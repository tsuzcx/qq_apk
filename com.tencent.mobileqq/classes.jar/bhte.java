import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bhte
  implements View.OnClickListener
{
  bhte(bhtd parambhtd, int paramInt, bhtf parambhtf) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bhtd.a(this.jdField_a_of_type_Bhtd))
    {
      paramView = (bhtf)bhtd.a(this.jdField_a_of_type_Bhtd).findViewHolderForAdapterPosition(bhtd.a(this.jdField_a_of_type_Bhtd));
      if (paramView == null) {
        break label94;
      }
      paramView.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhtf.a(true);
      this.jdField_a_of_type_Bhtd.a(this.jdField_a_of_type_Int);
      if (bhtd.a(this.jdField_a_of_type_Bhtd) != null) {
        bhtd.a(this.jdField_a_of_type_Bhtd).setTextColor(Color.parseColor(bhtd.a(this.jdField_a_of_type_Bhtd)));
      }
      return;
      label94:
      this.jdField_a_of_type_Bhtd.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhte
 * JD-Core Version:    0.7.0.1
 */