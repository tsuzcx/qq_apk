import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class blcy
  implements View.OnClickListener
{
  blcy(blcx paramblcx, int paramInt, blcz paramblcz) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != blcx.a(this.jdField_a_of_type_Blcx))
    {
      paramView = (blcz)blcx.a(this.jdField_a_of_type_Blcx).findViewHolderForAdapterPosition(blcx.a(this.jdField_a_of_type_Blcx));
      if (paramView == null) {
        break label94;
      }
      paramView.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blcz.a(true);
      this.jdField_a_of_type_Blcx.a(this.jdField_a_of_type_Int);
      if (blcx.a(this.jdField_a_of_type_Blcx) != null) {
        blcx.a(this.jdField_a_of_type_Blcx).setTextColor(Color.parseColor(blcx.a(this.jdField_a_of_type_Blcx)));
      }
      return;
      label94:
      this.jdField_a_of_type_Blcx.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcy
 * JD-Core Version:    0.7.0.1
 */