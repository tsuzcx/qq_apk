import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnnj
  implements View.OnClickListener
{
  bnnj(bnni parambnni, int paramInt, bnnk parambnnk) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bnni.a(this.jdField_a_of_type_Bnni))
    {
      bnnk localbnnk = (bnnk)bnni.a(this.jdField_a_of_type_Bnni).findViewHolderForAdapterPosition(bnni.a(this.jdField_a_of_type_Bnni));
      if (localbnnk == null) {
        break label101;
      }
      localbnnk.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnnk.a(true);
      this.jdField_a_of_type_Bnni.a(this.jdField_a_of_type_Int);
      if (bnni.a(this.jdField_a_of_type_Bnni) != null) {
        bnni.a(this.jdField_a_of_type_Bnni).setTextColor(Color.parseColor(bnni.a(this.jdField_a_of_type_Bnni)));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      this.jdField_a_of_type_Bnni.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnj
 * JD-Core Version:    0.7.0.1
 */