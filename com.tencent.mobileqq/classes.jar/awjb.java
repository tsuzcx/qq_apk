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

public class awjb
  implements View.OnClickListener
{
  awjb(awiz paramawiz, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bcou localbcou = new bcou(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559608, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362998);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362809);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362797);
    TextView localTextView1 = (TextView)localView.findViewById(2131363851);
    TextView localTextView2 = (TextView)localView.findViewById(2131365000);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130841814);
      localImageView3.setImageResource(2130841814);
      localTextView1.setBackgroundResource(2130845177);
    }
    for (;;)
    {
      localbcou.setContentView(localView);
      localbcou.setHeight(vzl.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbcou.setWidth(vzl.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new awjc(this, localbcou));
      localTextView2.setOnClickListener(new awjd(this, localbcou));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbcou.showAsDropDown(paramView, 0, 0);
      return;
      localImageView1.setImageResource(2130839011);
      localImageView2.setImageResource(2130841815);
      localImageView3.setImageResource(2130841815);
      localTextView1.setBackgroundResource(2130841805);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjb
 * JD-Core Version:    0.7.0.1
 */