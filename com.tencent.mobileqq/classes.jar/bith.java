import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bith
  implements View.OnClickListener
{
  bith(bitg parambitg, int paramInt, biti parambiti) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bitg.a(this.jdField_a_of_type_Bitg))
    {
      paramView = (biti)bitg.a(this.jdField_a_of_type_Bitg).findViewHolderForAdapterPosition(bitg.a(this.jdField_a_of_type_Bitg));
      if (paramView == null) {
        break label94;
      }
      paramView.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Biti.a(true);
      this.jdField_a_of_type_Bitg.a(this.jdField_a_of_type_Int);
      if (bitg.a(this.jdField_a_of_type_Bitg) != null) {
        bitg.a(this.jdField_a_of_type_Bitg).setTextColor(Color.parseColor(bitg.a(this.jdField_a_of_type_Bitg)));
      }
      return;
      label94:
      this.jdField_a_of_type_Bitg.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bith
 * JD-Core Version:    0.7.0.1
 */