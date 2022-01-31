import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class awqk
  implements View.OnClickListener
{
  awqk(awqh paramawqh, awne paramawne) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Awne.l == 1)
    {
      axqw.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      axqw.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    Object localObject;
    for (;;)
    {
      localObject = (ajxn)awqh.a(this.jdField_a_of_type_Awqh).getManager(51);
      if ((((ajxn)localObject).b(this.jdField_a_of_type_Awne.b)) || (((ajxn)localObject).d(this.jdField_a_of_type_Awne.b))) {
        break;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Awne.b, null, 3020, 3, this.jdField_a_of_type_Awne.c, null, null, paramView.getContext().getString(2131689628), null);
      paramView.getContext().startActivity((Intent)localObject);
      return;
      axqw.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      axqw.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    if (((ajxn)localObject).b(this.jdField_a_of_type_Awne.b))
    {
      this.jdField_a_of_type_Awne.k = 2;
      awqh.a(this.jdField_a_of_type_Awqh).notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Awne.k = 1;
    awqh.a(this.jdField_a_of_type_Awqh).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqk
 * JD-Core Version:    0.7.0.1
 */