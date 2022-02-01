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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcac
  implements View.OnClickListener
{
  bcac(bcaa parambcaa, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bjak localbjak = new bjak(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559803, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363243);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362973);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362960);
    TextView localTextView1 = (TextView)localView.findViewById(2131364153);
    TextView localTextView2 = (TextView)localView.findViewById(2131365368);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130842300);
      localImageView3.setImageResource(2130842300);
      localTextView1.setBackgroundResource(2130846029);
    }
    for (;;)
    {
      localbjak.setContentView(localView);
      localbjak.setHeight(zps.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbjak.setWidth(zps.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new bcad(this, localbjak));
      localTextView2.setOnClickListener(new bcae(this, localbjak));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbjak.showAsDropDown(paramView, 0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localImageView1.setImageResource(2130839274);
      localImageView2.setImageResource(2130842301);
      localImageView3.setImageResource(2130842301);
      localTextView1.setBackgroundResource(2130842291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcac
 * JD-Core Version:    0.7.0.1
 */