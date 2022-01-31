import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class atcq
  implements bcij<oidb_0x8e4.RspBody>
{
  public atcq(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) || (paramInt == 1004))
    {
      this.a.jdField_a_of_type_Atcf.d();
      bbjn.a(this.a, this.a.app.getCurrentAccountUin(), false, System.currentTimeMillis());
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
        bcpw.a(this.a, ajyc.a(2131705057), 0).a();
      }
      this.a.jdField_a_of_type_Atdm.notifyDataSetChanged();
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
 * Qualified Name:     atcq
 * JD-Core Version:    0.7.0.1
 */