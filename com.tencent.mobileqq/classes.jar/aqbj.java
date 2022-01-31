import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aqbj
  implements View.OnClickListener
{
  aqbj(aqbc paramaqbc, String paramString, aqbo paramaqbo) {}
  
  public void onClick(View paramView)
  {
    axqw.b(this.jdField_a_of_type_Aqbc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    paramView = this.jdField_a_of_type_Aqbc.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((paramView instanceof MessageForPic))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from MessageForPic");
      }
      paramView = (MessageForPic)paramView;
      File localFile = new File(paramView.path);
      if (((localFile == null) || (!localFile.exists()) || (localFile.length() != paramView.size)) || (paramView != null)) {
        aqbc.a(this.jdField_a_of_type_Aqbc, paramView, this.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramView instanceof AIOImageData)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from AIOImageData");
        }
        paramView = (AIOImageData)paramView;
        if ((paramView.a(4)) && (paramView.a(4) != null))
        {
          aqbc.a(this.jdField_a_of_type_Aqbc, paramView, this.jdField_a_of_type_JavaLangString);
          return;
        }
        if ((paramView.a(2)) && (paramView.a(2) != null))
        {
          aqbc.a(this.jdField_a_of_type_Aqbc, paramView, this.jdField_a_of_type_JavaLangString);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: image does not exist");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from other");
      }
      paramView = this.jdField_a_of_type_Aqbc.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      if (paramView != null)
      {
        aqbc.a(this.jdField_a_of_type_Aqbc, paramView, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_Aqbc.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: from QZone");
        }
        this.jdField_a_of_type_Aqbc.jdField_a_of_type_AndroidOsBundle.putBoolean("FORWARD_IS_QZONE_SHARE", true);
        aqbc.a(this.jdField_a_of_type_Aqbc, this.jdField_a_of_type_Aqbc.b, this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: Unknown source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbj
 * JD-Core Version:    0.7.0.1
 */