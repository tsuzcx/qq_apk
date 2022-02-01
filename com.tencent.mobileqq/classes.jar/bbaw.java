import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbaw
  implements View.OnClickListener
{
  bbaw(bbau parambbau, baxr parambaxr) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Baxr.o == 1)
    {
      bcef.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bcef.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
      localObject = (amsw)bbau.a(this.jdField_a_of_type_Bbau).getManager(51);
      if ((((amsw)localObject).b(this.jdField_a_of_type_Baxr.b)) || (((amsw)localObject).d(this.jdField_a_of_type_Baxr.b))) {
        break label210;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Baxr.b, null, 3020, 3, this.jdField_a_of_type_Baxr.c, null, null, paramView.getContext().getString(2131689550), null);
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bcef.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
      break;
      label210:
      if (((amsw)localObject).b(this.jdField_a_of_type_Baxr.b))
      {
        this.jdField_a_of_type_Baxr.n = 2;
        bbau.a(this.jdField_a_of_type_Bbau).notifyDataSetChanged();
      }
      else
      {
        this.jdField_a_of_type_Baxr.n = 1;
        bbau.a(this.jdField_a_of_type_Bbau).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaw
 * JD-Core Version:    0.7.0.1
 */