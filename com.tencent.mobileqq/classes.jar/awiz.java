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

public class awiz
  implements View.OnClickListener
{
  awiz(awix paramawix, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bcof localbcof = new bcof(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559608, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362999);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362810);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362798);
    TextView localTextView1 = (TextView)localView.findViewById(2131363852);
    TextView localTextView2 = (TextView)localView.findViewById(2131365001);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130841814);
      localImageView3.setImageResource(2130841814);
      localTextView1.setBackgroundResource(2130845176);
    }
    for (;;)
    {
      localbcof.setContentView(localView);
      localbcof.setHeight(vzo.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbcof.setWidth(vzo.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new awja(this, localbcof));
      localTextView2.setOnClickListener(new awjb(this, localbcof));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbcof.showAsDropDown(paramView, 0, 0);
      return;
      localImageView1.setImageResource(2130839011);
      localImageView2.setImageResource(2130841815);
      localImageView3.setImageResource(2130841815);
      localTextView1.setBackgroundResource(2130841805);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiz
 * JD-Core Version:    0.7.0.1
 */