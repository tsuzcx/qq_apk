import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.3;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class batg
  implements View.OnClickListener
{
  batg(bate parambate, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bhgl localbhgl = new bhgl(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559805, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363274);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362987);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362974);
    TextView localTextView1 = (TextView)localView.findViewById(2131364175);
    TextView localTextView2 = (TextView)localView.findViewById(2131365401);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130842342);
      localImageView3.setImageResource(2130842342);
      localTextView1.setBackgroundResource(2130845929);
    }
    for (;;)
    {
      localbhgl.setContentView(localView);
      localbhgl.setHeight(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbhgl.setWidth(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new bath(this, localbhgl));
      localTextView2.setOnClickListener(new bati(this, localbhgl));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbhgl.showAsDropDown(paramView, 0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localImageView1.setImageResource(2130839309);
      localImageView2.setImageResource(2130842343);
      localImageView3.setImageResource(2130842343);
      localTextView1.setBackgroundResource(2130842333);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batg
 * JD-Core Version:    0.7.0.1
 */