import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class aypy
  implements View.OnClickListener
{
  aypy(aypv paramaypv, ayms paramayms) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ayms.l == 1)
    {
      azqs.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      azqs.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    Object localObject;
    for (;;)
    {
      localObject = (alto)aypv.a(this.jdField_a_of_type_Aypv).getManager(51);
      if ((((alto)localObject).b(this.jdField_a_of_type_Ayms.b)) || (((alto)localObject).d(this.jdField_a_of_type_Ayms.b))) {
        break;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Ayms.b, null, 3020, 3, this.jdField_a_of_type_Ayms.c, null, null, paramView.getContext().getString(2131689628), null);
      paramView.getContext().startActivity((Intent)localObject);
      return;
      azqs.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      azqs.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    if (((alto)localObject).b(this.jdField_a_of_type_Ayms.b))
    {
      this.jdField_a_of_type_Ayms.k = 2;
      aypv.a(this.jdField_a_of_type_Aypv).notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Ayms.k = 1;
    aypv.a(this.jdField_a_of_type_Aypv).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypy
 * JD-Core Version:    0.7.0.1
 */