import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class atcs
  implements bcix<oidb_0x8e4.RspBody>
{
  public atcs(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) || (paramInt == 1004))
    {
      this.a.jdField_a_of_type_Atch.d();
      bbkb.a(this.a, this.a.app.getCurrentAccountUin(), false, System.currentTimeMillis());
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Long = this.a.app.getLongAccountUin();
      this.a.jdField_b_of_type_JavaLangString = null;
      GameRoomInviteActivity.jdField_a_of_type_JavaLangString = null;
      this.a.jdField_a_of_type_JavaUtilList = null;
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.a.jdField_b_of_type_JavaUtilList != null) {
        this.a.jdField_b_of_type_JavaUtilList.clear();
      }
      this.a.f = false;
      this.a.a();
      paramRspBody = this.a.a();
      if ((paramRspBody != null) && (paramRspBody.jdField_a_of_type_Boolean)) {
        bcql.a(this.a, ajya.a(2131705068), 0).a();
      }
      this.a.jdField_a_of_type_Atdo.notifyDataSetChanged();
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidViewView.setEnabled(true);
      return;
      this.a.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atcs
 * JD-Core Version:    0.7.0.1
 */