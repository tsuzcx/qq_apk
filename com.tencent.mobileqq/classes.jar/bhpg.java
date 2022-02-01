import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.agent.AgentActivity;

class bhpg
  implements DialogInterface.OnClickListener
{
  bhpg(bhpf parambhpf, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AgentActivity.a(this.jdField_a_of_type_Bhpf.a.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpg
 * JD-Core Version:    0.7.0.1
 */