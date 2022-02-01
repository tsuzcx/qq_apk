import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcho
  implements View.OnClickListener
{
  bcho(bchk parambchk, bceh parambceh) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bceh.o == 1)
    {
      bdla.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
      localObject = (anvk)bchk.a(this.jdField_a_of_type_Bchk).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((((anvk)localObject).b(this.jdField_a_of_type_Bceh.b)) || (((anvk)localObject).d(this.jdField_a_of_type_Bceh.b))) {
        break label227;
      }
      int i = 3;
      if (this.jdField_a_of_type_Bceh.a == 99) {
        i = 4;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Bceh.b, null, 3020, i, this.jdField_a_of_type_Bceh.c, null, null, paramView.getContext().getString(2131689550), null);
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
      break;
      label227:
      if (((anvk)localObject).b(this.jdField_a_of_type_Bceh.b))
      {
        this.jdField_a_of_type_Bceh.n = 2;
        bchk.a(this.jdField_a_of_type_Bchk).notifyDataSetChanged();
      }
      else
      {
        this.jdField_a_of_type_Bceh.n = 1;
        bchk.a(this.jdField_a_of_type_Bchk).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcho
 * JD-Core Version:    0.7.0.1
 */