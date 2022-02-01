import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;

public class autu
  implements DialogInterface.OnClickListener
{
  public autu(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.c) {
      bjgx.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "51", "0", false, true);
    }
    ForwardSdkBaseOption.a(this.a.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autu
 * JD-Core Version:    0.7.0.1
 */