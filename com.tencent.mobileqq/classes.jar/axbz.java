import android.annotation.TargetApi;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.OnPicDragListener.1;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class axbz
  implements View.OnDragListener
{
  private int a;
  
  public axbz(axax paramaxax, int paramInt)
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
      RelativeLayout localRelativeLayout = axax.a(this.jdField_a_of_type_Axax);
      int i = this.jdField_a_of_type_Axax.a.indexOfChild(paramView);
      int j = this.jdField_a_of_type_Axax.a.indexOfChild(localRelativeLayout);
      if ((i != -1) && (j != -1) && (((i > j) && (paramDragEvent.getX() > this.jdField_a_of_type_Int / 2)) || ((i < j) && (paramDragEvent.getX() < this.jdField_a_of_type_Int / 2))))
      {
        try
        {
          this.jdField_a_of_type_Axax.a.removeView(localRelativeLayout);
          this.jdField_a_of_type_Axax.a.addView(localRelativeLayout, i);
          axax.e(this.jdField_a_of_type_Axax);
        }
        catch (Exception paramView) {}
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.", 2, "drag between small pics exception" + paramView.getMessage());
          continue;
          this.jdField_a_of_type_Axax.a.post(new NearbyProfileEditPanel.OnPicDragListener.1(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbz
 * JD-Core Version:    0.7.0.1
 */