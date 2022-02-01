import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auyh
  implements View.OnClickListener
{
  auyh(auxu paramauxu, String paramString, auyi paramauyi) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.jdField_a_of_type_Auxu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    Parcelable localParcelable = this.jdField_a_of_type_Auxu.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((localParcelable instanceof MessageForPic)) {
      auxu.a(this.jdField_a_of_type_Auxu, (MessageForPic)localParcelable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auyi);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localParcelable instanceof AIOImageData)) {
        auxu.a(this.jdField_a_of_type_Auxu, (AIOImageData)localParcelable, this.jdField_a_of_type_JavaLangString);
      } else {
        auxu.a(this.jdField_a_of_type_Auxu, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auyh
 * JD-Core Version:    0.7.0.1
 */