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

public class avjg
  implements View.OnClickListener
{
  avjg(avje paramavje, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bblh localbblh = new bblh(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494037, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131297459);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131297270);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131297258);
    TextView localTextView1 = (TextView)localView.findViewById(2131298297);
    TextView localTextView2 = (TextView)localView.findViewById(2131299433);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130841720);
      localImageView3.setImageResource(2130841720);
      localTextView1.setBackgroundResource(2130845092);
    }
    for (;;)
    {
      localbblh.setContentView(localView);
      localbblh.setHeight(vms.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbblh.setWidth(vms.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new avjh(this, localbblh));
      localTextView2.setOnClickListener(new avji(this, localbblh));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbblh.showAsDropDown(paramView, 0, 0);
      return;
      localImageView1.setImageResource(2130838983);
      localImageView2.setImageResource(2130841721);
      localImageView3.setImageResource(2130841721);
      localTextView1.setBackgroundResource(2130841711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjg
 * JD-Core Version:    0.7.0.1
 */