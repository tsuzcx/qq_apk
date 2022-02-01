import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class bfye
  extends bfyf
{
  public bfye(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  public void a(int paramInt1, bffr parambffr, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    if (parambffr.a)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfye
 * JD-Core Version:    0.7.0.1
 */