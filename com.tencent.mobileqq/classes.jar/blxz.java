import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blxz
  implements View.OnClickListener
{
  blxz(blxy paramblxy, int paramInt, blya paramblya) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != blxy.a(this.jdField_a_of_type_Blxy))
    {
      blya localblya = (blya)blxy.a(this.jdField_a_of_type_Blxy).findViewHolderForAdapterPosition(blxy.a(this.jdField_a_of_type_Blxy));
      if (localblya == null) {
        break label101;
      }
      localblya.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blya.a(true);
      this.jdField_a_of_type_Blxy.a(this.jdField_a_of_type_Int);
      if (blxy.a(this.jdField_a_of_type_Blxy) != null) {
        blxy.a(this.jdField_a_of_type_Blxy).setTextColor(Color.parseColor(blxy.a(this.jdField_a_of_type_Blxy)));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      this.jdField_a_of_type_Blxy.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxz
 * JD-Core Version:    0.7.0.1
 */