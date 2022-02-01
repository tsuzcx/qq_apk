import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class botu
  implements View.OnClickListener
{
  botu(bott parambott, int paramInt, botv parambotv) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bott.a(this.jdField_a_of_type_Bott))
    {
      botv localbotv = (botv)bott.a(this.jdField_a_of_type_Bott).findViewHolderForAdapterPosition(bott.a(this.jdField_a_of_type_Bott));
      if (localbotv == null) {
        break label101;
      }
      localbotv.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Botv.a(true);
      this.jdField_a_of_type_Bott.a(this.jdField_a_of_type_Int);
      if (bott.a(this.jdField_a_of_type_Bott) != null) {
        bott.a(this.jdField_a_of_type_Bott).setTextColor(Color.parseColor(bott.a(this.jdField_a_of_type_Bott)));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      this.jdField_a_of_type_Bott.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botu
 * JD-Core Version:    0.7.0.1
 */