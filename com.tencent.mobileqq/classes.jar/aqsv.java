import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqsv
  implements View.OnClickListener
{
  aqst jdField_a_of_type_Aqst;
  aqsx jdField_a_of_type_Aqsx;
  
  aqsv(aqst paramaqst, aqsx paramaqsx)
  {
    this.jdField_a_of_type_Aqst = paramaqst;
    this.jdField_a_of_type_Aqsx = paramaqsx;
  }
  
  public void onClick(View paramView)
  {
    aqre.a(paramView.getContext(), (ColorNote)aqst.a(this.jdField_a_of_type_Aqst).get(this.jdField_a_of_type_Aqsx.getAdapterPosition()));
    if (aqst.a(this.jdField_a_of_type_Aqst) != null) {
      aqst.a(this.jdField_a_of_type_Aqst).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsv
 * JD-Core Version:    0.7.0.1
 */