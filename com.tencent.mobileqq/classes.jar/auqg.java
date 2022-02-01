import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auqg
  implements View.OnClickListener
{
  auqg(aupt paramaupt, String paramString, auqh paramauqh) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.jdField_a_of_type_Aupt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    Parcelable localParcelable = this.jdField_a_of_type_Aupt.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((localParcelable instanceof MessageForPic)) {
      aupt.a(this.jdField_a_of_type_Aupt, (MessageForPic)localParcelable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auqh);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localParcelable instanceof AIOImageData)) {
        aupt.a(this.jdField_a_of_type_Aupt, (AIOImageData)localParcelable, this.jdField_a_of_type_JavaLangString);
      } else {
        aupt.a(this.jdField_a_of_type_Aupt, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auqg
 * JD-Core Version:    0.7.0.1
 */