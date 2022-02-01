import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class anid
  implements DialogInterface.OnClickListener
{
  public anid(ApolloGameActivity paramApolloGameActivity, anpf paramanpf, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Anpf != null) {
      this.jdField_a_of_type_Anpf.a(1);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, 1, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anid
 * JD-Core Version:    0.7.0.1
 */