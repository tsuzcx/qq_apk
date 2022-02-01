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

public class bbhi
  implements View.OnClickListener
{
  bbhi(bbhg parambbhg, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    bhzm localbhzm = new bhzm(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559797, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363219);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362955);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362942);
    TextView localTextView1 = (TextView)localView.findViewById(2131364112);
    TextView localTextView2 = (TextView)localView.findViewById(2131365324);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130842288);
      localImageView3.setImageResource(2130842288);
      localTextView1.setBackgroundResource(2130846014);
    }
    for (;;)
    {
      localbhzm.setContentView(localView);
      localbhzm.setHeight(zlx.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
      localbhzm.setWidth(zlx.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
      localTextView1.setOnClickListener(new bbhj(this, localbhzm));
      localTextView2.setOnClickListener(new bbhk(this, localbhzm));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localbhzm.showAsDropDown(paramView, 0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localImageView1.setImageResource(2130839266);
      localImageView2.setImageResource(2130842289);
      localImageView3.setImageResource(2130842289);
      localTextView1.setBackgroundResource(2130842279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhi
 * JD-Core Version:    0.7.0.1
 */