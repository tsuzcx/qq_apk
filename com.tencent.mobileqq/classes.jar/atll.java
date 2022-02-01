import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atll
  implements View.OnClickListener
{
  atll(atky paramatky, String paramString, atlm paramatlm) {}
  
  public void onClick(View paramView)
  {
    bcef.b(this.jdField_a_of_type_Atky.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    Parcelable localParcelable = this.jdField_a_of_type_Atky.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((localParcelable instanceof MessageForPic)) {
      atky.a(this.jdField_a_of_type_Atky, (MessageForPic)localParcelable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atlm);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localParcelable instanceof AIOImageData)) {
        atky.a(this.jdField_a_of_type_Atky, (AIOImageData)localParcelable, this.jdField_a_of_type_JavaLangString);
      } else {
        atky.a(this.jdField_a_of_type_Atky, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atll
 * JD-Core Version:    0.7.0.1
 */