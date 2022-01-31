import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class amdz
  implements View.OnClickListener
{
  public amdz(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amdz
 * JD-Core Version:    0.7.0.1
 */