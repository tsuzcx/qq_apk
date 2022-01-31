import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class avqr
  implements View.OnClickListener
{
  avqr(avqo paramavqo, avnl paramavnl) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Avnl.l == 1)
    {
      awqx.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      awqx.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    Object localObject;
    for (;;)
    {
      localObject = (ajjj)avqo.a(this.jdField_a_of_type_Avqo).getManager(51);
      if ((((ajjj)localObject).b(this.jdField_a_of_type_Avnl.b)) || (((ajjj)localObject).d(this.jdField_a_of_type_Avnl.b))) {
        break;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Avnl.b, null, 3020, 3, this.jdField_a_of_type_Avnl.c, null, null, paramView.getContext().getString(2131624088), null);
      paramView.getContext().startActivity((Intent)localObject);
      return;
      awqx.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      awqx.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    if (((ajjj)localObject).b(this.jdField_a_of_type_Avnl.b))
    {
      this.jdField_a_of_type_Avnl.k = 2;
      avqo.a(this.jdField_a_of_type_Avqo).notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Avnl.k = 1;
    avqo.a(this.jdField_a_of_type_Avqo).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqr
 * JD-Core Version:    0.7.0.1
 */