import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.3;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ayeb
  implements View.OnClickListener
{
  ayeb(aydz paramaydz, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    benw localbenw = new benw(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559661, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363034);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362842);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362829);
    TextView localTextView1 = (TextView)localView.findViewById(2131363907);
    TextView localTextView2 = (TextView)localView.findViewById(2131365085);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130841966);
      localImageView3.setImageResource(2130841966);
      localTextView1.setBackgroundResource(2130845542);
    }
    for (;;)
    {
      localbenw.setContentView(localView);
      localbenw.setHeight(xod.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbenw.setWidth(xod.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new ayec(this, localbenw));
      localTextView2.setOnClickListener(new ayed(this, localbenw));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbenw.showAsDropDown(paramView, 0, 0);
      return;
      localImageView1.setImageResource(2130839092);
      localImageView2.setImageResource(2130841967);
      localImageView3.setImageResource(2130841967);
      localTextView1.setBackgroundResource(2130841958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayeb
 * JD-Core Version:    0.7.0.1
 */