import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class awqm
  implements View.OnClickListener
{
  awqm(awqj paramawqj, awng paramawng) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Awng.l == 1)
    {
      axqy.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      axqy.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    Object localObject;
    for (;;)
    {
      localObject = (ajxl)awqj.a(this.jdField_a_of_type_Awqj).getManager(51);
      if ((((ajxl)localObject).b(this.jdField_a_of_type_Awng.b)) || (((ajxl)localObject).d(this.jdField_a_of_type_Awng.b))) {
        break;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Awng.b, null, 3020, 3, this.jdField_a_of_type_Awng.c, null, null, paramView.getContext().getString(2131689628), null);
      paramView.getContext().startActivity((Intent)localObject);
      return;
      axqy.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      axqy.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    if (((ajxl)localObject).b(this.jdField_a_of_type_Awng.b))
    {
      this.jdField_a_of_type_Awng.k = 2;
      awqj.a(this.jdField_a_of_type_Awqj).notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Awng.k = 1;
    awqj.a(this.jdField_a_of_type_Awqj).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqm
 * JD-Core Version:    0.7.0.1
 */