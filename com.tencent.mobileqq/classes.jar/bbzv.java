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

public class bbzv
  implements View.OnClickListener
{
  bbzv(bbzt parambbzt, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bird localbird = new bird(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559849, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363339);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131363004);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362991);
    TextView localTextView1 = (TextView)localView.findViewById(2131364250);
    TextView localTextView2 = (TextView)localView.findViewById(2131365494);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130842372);
      localImageView3.setImageResource(2130842372);
      localTextView1.setBackgroundResource(2130846017);
    }
    for (;;)
    {
      localbird.setContentView(localView);
      localbird.setHeight(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbird.setWidth(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new bbzw(this, localbird));
      localTextView2.setOnClickListener(new bbzx(this, localbird));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbird.showAsDropDown(paramView, 0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localImageView1.setImageResource(2130839330);
      localImageView2.setImageResource(2130842373);
      localImageView3.setImageResource(2130842373);
      localTextView1.setBackgroundResource(2130842363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzv
 * JD-Core Version:    0.7.0.1
 */