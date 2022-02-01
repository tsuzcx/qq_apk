import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnsg
  implements View.OnClickListener
{
  bnsg(bnsf parambnsf, int paramInt, bnsh parambnsh) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int != bnsf.a(this.jdField_a_of_type_Bnsf))
    {
      bnsh localbnsh = (bnsh)bnsf.a(this.jdField_a_of_type_Bnsf).findViewHolderForAdapterPosition(bnsf.a(this.jdField_a_of_type_Bnsf));
      if (localbnsh == null) {
        break label101;
      }
      localbnsh.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnsh.a(true);
      this.jdField_a_of_type_Bnsf.a(this.jdField_a_of_type_Int);
      if (bnsf.a(this.jdField_a_of_type_Bnsf) != null) {
        bnsf.a(this.jdField_a_of_type_Bnsf).setTextColor(Color.parseColor(bnsf.a(this.jdField_a_of_type_Bnsf)));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      this.jdField_a_of_type_Bnsf.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsg
 * JD-Core Version:    0.7.0.1
 */