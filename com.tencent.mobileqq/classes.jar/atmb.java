import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import java.util.Map;

public class atmb
  implements DialogInterface.OnClickListener
{
  public atmb(ListenTogetherManager paramListenTogetherManager, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a();
      paramDialogInterface.dismiss();
    }
    while (paramInt != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b();
    paramDialogInterface.dismiss();
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager, (ListenTogetherSession)ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager).get(atmr.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmb
 * JD-Core Version:    0.7.0.1
 */