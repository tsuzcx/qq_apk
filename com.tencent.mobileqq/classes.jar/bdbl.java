import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.GroupListOpenFrame;

class bdbl
  implements View.OnClickListener
{
  bdbl(bdbk parambdbk, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("group_index", this.jdField_a_of_type_Int);
    paramView.putString("group_name", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bdbk.a.a.a(1, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbl
 * JD-Core Version:    0.7.0.1
 */