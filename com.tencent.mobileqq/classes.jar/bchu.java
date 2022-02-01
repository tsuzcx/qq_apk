import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bchu
  implements View.OnClickListener
{
  bchu(bchs parambchs, bcep parambcep) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bcep.o == 1)
    {
      bdll.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
      localObject = (anyw)bchs.a(this.jdField_a_of_type_Bchs).getManager(51);
      if ((((anyw)localObject).b(this.jdField_a_of_type_Bcep.b)) || (((anyw)localObject).d(this.jdField_a_of_type_Bcep.b))) {
        break label210;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Bcep.b, null, 3020, 3, this.jdField_a_of_type_Bcep.c, null, null, paramView.getContext().getString(2131689551), null);
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
      break;
      label210:
      if (((anyw)localObject).b(this.jdField_a_of_type_Bcep.b))
      {
        this.jdField_a_of_type_Bcep.n = 2;
        bchs.a(this.jdField_a_of_type_Bchs).notifyDataSetChanged();
      }
      else
      {
        this.jdField_a_of_type_Bcep.n = 1;
        bchs.a(this.jdField_a_of_type_Bchs).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchu
 * JD-Core Version:    0.7.0.1
 */