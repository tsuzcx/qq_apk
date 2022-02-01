import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class augj
  implements View.OnClickListener
{
  augj(aufz paramaufz, String paramString, augl paramaugl) {}
  
  public void onClick(View paramView)
  {
    bcst.b(this.jdField_a_of_type_Aufz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    Parcelable localParcelable = this.jdField_a_of_type_Aufz.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((localParcelable instanceof MessageForPic)) {
      aufz.a(this.jdField_a_of_type_Aufz, (MessageForPic)localParcelable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Augl);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localParcelable instanceof AIOImageData)) {
        aufz.a(this.jdField_a_of_type_Aufz, (AIOImageData)localParcelable, this.jdField_a_of_type_JavaLangString);
      } else {
        aufz.a(this.jdField_a_of_type_Aufz, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     augj
 * JD-Core Version:    0.7.0.1
 */