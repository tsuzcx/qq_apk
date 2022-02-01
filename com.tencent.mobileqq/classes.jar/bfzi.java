import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class bfzi
  extends bfyf
{
  public bfzi(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 1;
  }
  
  public int a(int paramInt)
  {
    return 2130850745;
  }
  
  @Nullable
  public bfyg a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    int j = 0;
    int i;
    if (paramLong3 >= paramLong2) {
      i = 0;
    }
    while (i != 0)
    {
      return new bfyg(true, String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697564), new Object[] { Integer.valueOf(paramInt2) }), bffr.a(paramInt1, paramLong1, paramInt2), "");
      if (paramInt2 < 30)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        i = j;
        if (paramList != null)
        {
          long l = paramList.shmsgseq;
          for (paramLong3 = 0L;; paramLong3 += 1L)
          {
            i = j;
            if (paramLong3 >= paramInt2) {
              break;
            }
            paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, l);
            if ((paramList != null) && (paramList.msgtype != -2058) && (paramList.shmsgseq < paramLong2))
            {
              i = 1;
              break;
            }
            l -= 1L;
          }
        }
      }
      else
      {
        i = 1;
      }
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setVisibility(8);
    paramTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166256));
    paramTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166256));
    paramImageView.setBackgroundResource(2130850796);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 15) && (paramInt2 <= 200);
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzi
 * JD-Core Version:    0.7.0.1
 */