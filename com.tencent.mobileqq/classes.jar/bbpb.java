import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbpb
  implements View.OnClickListener
{
  bbpb(bboz parambboz, bblw parambblw) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bblw.m == 1)
    {
      bcst.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bcst.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
      localObject = (anmw)bboz.a(this.jdField_a_of_type_Bboz).getManager(51);
      if ((((anmw)localObject).b(this.jdField_a_of_type_Bblw.b)) || (((anmw)localObject).d(this.jdField_a_of_type_Bblw.b))) {
        break label210;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Bblw.b, null, 3020, 3, this.jdField_a_of_type_Bblw.c, null, null, paramView.getContext().getString(2131689550), null);
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bcst.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
      break;
      label210:
      if (((anmw)localObject).b(this.jdField_a_of_type_Bblw.b))
      {
        this.jdField_a_of_type_Bblw.l = 2;
        bboz.a(this.jdField_a_of_type_Bboz).notifyDataSetChanged();
      }
      else
      {
        this.jdField_a_of_type_Bblw.l = 1;
        bboz.a(this.jdField_a_of_type_Bboz).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpb
 * JD-Core Version:    0.7.0.1
 */