import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class aylp
  implements View.OnClickListener
{
  aylp(aylm paramaylm, ayij paramayij) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ayij.l == 1)
    {
      azmj.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      azmj.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    Object localObject;
    for (;;)
    {
      localObject = (aloz)aylm.a(this.jdField_a_of_type_Aylm).getManager(51);
      if ((((aloz)localObject).b(this.jdField_a_of_type_Ayij.b)) || (((aloz)localObject).d(this.jdField_a_of_type_Ayij.b))) {
        break;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Ayij.b, null, 3020, 3, this.jdField_a_of_type_Ayij.c, null, null, paramView.getContext().getString(2131689628), null);
      paramView.getContext().startActivity((Intent)localObject);
      return;
      azmj.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      azmj.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    if (((aloz)localObject).b(this.jdField_a_of_type_Ayij.b))
    {
      this.jdField_a_of_type_Ayij.k = 2;
      aylm.a(this.jdField_a_of_type_Aylm).notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Ayij.k = 1;
    aylm.a(this.jdField_a_of_type_Aylm).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylp
 * JD-Core Version:    0.7.0.1
 */