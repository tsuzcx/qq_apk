import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bity
  implements View.OnClickListener
{
  bity(bitx parambitx, int paramInt, bitz parambitz) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bitx.a(this.jdField_a_of_type_Bitx))
    {
      paramView = (bitz)bitx.a(this.jdField_a_of_type_Bitx).findViewHolderForAdapterPosition(bitx.a(this.jdField_a_of_type_Bitx));
      if (paramView == null) {
        break label94;
      }
      paramView.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bitz.a(true);
      this.jdField_a_of_type_Bitx.a(this.jdField_a_of_type_Int);
      if (bitx.a(this.jdField_a_of_type_Bitx) != null) {
        bitx.a(this.jdField_a_of_type_Bitx).setTextColor(Color.parseColor(bitx.a(this.jdField_a_of_type_Bitx)));
      }
      return;
      label94:
      this.jdField_a_of_type_Bitx.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bity
 * JD-Core Version:    0.7.0.1
 */