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

public class ayik
  implements View.OnClickListener
{
  ayik(ayii paramayii, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    besf localbesf = new besf(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559660, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363034);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362842);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362829);
    TextView localTextView1 = (TextView)localView.findViewById(2131363909);
    TextView localTextView2 = (TextView)localView.findViewById(2131365087);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130841979);
      localImageView3.setImageResource(2130841979);
      localTextView1.setBackgroundResource(2130845614);
    }
    for (;;)
    {
      localbesf.setContentView(localView);
      localbesf.setHeight(xsm.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbesf.setWidth(xsm.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new ayil(this, localbesf));
      localTextView2.setOnClickListener(new ayim(this, localbesf));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbesf.showAsDropDown(paramView, 0, 0);
      return;
      localImageView1.setImageResource(2130839093);
      localImageView2.setImageResource(2130841980);
      localImageView3.setImageResource(2130841980);
      localTextView1.setBackgroundResource(2130841971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayik
 * JD-Core Version:    0.7.0.1
 */