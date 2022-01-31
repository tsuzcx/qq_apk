import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bkyr
  implements View.OnClickListener
{
  bkyr(bkyq parambkyq, int paramInt, bkys parambkys) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bkyq.a(this.jdField_a_of_type_Bkyq))
    {
      paramView = (bkys)bkyq.a(this.jdField_a_of_type_Bkyq).findViewHolderForAdapterPosition(bkyq.a(this.jdField_a_of_type_Bkyq));
      if (paramView == null) {
        break label94;
      }
      paramView.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkys.a(true);
      this.jdField_a_of_type_Bkyq.a(this.jdField_a_of_type_Int);
      if (bkyq.a(this.jdField_a_of_type_Bkyq) != null) {
        bkyq.a(this.jdField_a_of_type_Bkyq).setTextColor(Color.parseColor(bkyq.a(this.jdField_a_of_type_Bkyq)));
      }
      return;
      label94:
      this.jdField_a_of_type_Bkyq.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyr
 * JD-Core Version:    0.7.0.1
 */