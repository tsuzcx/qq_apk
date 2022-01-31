import android.annotation.TargetApi;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.OnPicDragListener.1;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class avke
  implements View.OnDragListener
{
  private int a;
  
  public avke(avjc paramavjc, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
      continue;
      RelativeLayout localRelativeLayout = avjc.a(this.jdField_a_of_type_Avjc);
      int i = this.jdField_a_of_type_Avjc.a.indexOfChild(paramView);
      int j = this.jdField_a_of_type_Avjc.a.indexOfChild(localRelativeLayout);
      if ((i != -1) && (j != -1) && (((i > j) && (paramDragEvent.getX() > this.jdField_a_of_type_Int / 2)) || ((i < j) && (paramDragEvent.getX() < this.jdField_a_of_type_Int / 2))))
      {
        try
        {
          this.jdField_a_of_type_Avjc.a.removeView(localRelativeLayout);
          this.jdField_a_of_type_Avjc.a.addView(localRelativeLayout, i);
          avjc.e(this.jdField_a_of_type_Avjc);
        }
        catch (Exception paramView) {}
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.", 2, "drag between small pics exception" + paramView.getMessage());
          continue;
          this.jdField_a_of_type_Avjc.a.post(new NearbyProfileEditPanel.OnPicDragListener.1(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avke
 * JD-Core Version:    0.7.0.1
 */