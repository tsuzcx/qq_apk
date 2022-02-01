import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class axhr
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<axhs> b;
  
  public axhr(axhq paramaxhq, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramaxhq.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380235));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376905));
      paramView = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        Object localObject = (RecommendPerson)paramView.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "ActiveViewHolder, person.uin =" + ((RecommendPerson)localObject).uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131563006, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject).findViewById(2131376906);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131369579);
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131380236);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131380237);
        Button localButton = (Button)((View)localObject).findViewById(2131364074);
        a(AIOUtils.dp2px(85.0F, axhq.a(paramaxhq).getResources()), this.jdField_a_of_type_JavaUtilList.size(), localRelativeLayout);
        axhs localaxhs = new axhs(this);
        localaxhs.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localaxhs.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localaxhs.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localaxhs.b = localTextView2;
        localaxhs.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localaxhs);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    if (paramInt2 > 1)
    {
      int i = ViewUtils.getScreenWidth();
      paramInt2 = (i - paramInt2 * paramInt1) / (paramInt2 * paramInt2);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
      localLayoutParams.leftMargin = paramInt2;
      localLayoutParams.rightMargin = paramInt2;
      paramRelativeLayout.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.Adapter", 2, "onCreateViewHolder, rlWidth =" + paramInt1 + " screenWidth =" + i + " margin = " + paramInt2);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (axhq.a(this.jdField_a_of_type_Axhq) != null)
      {
        axhq.a(this.jdField_a_of_type_Axhq).a((RecyclerView.ViewHolder)paramView.getTag(2131376906), (RecommendPerson)paramView.getTag(2131364074));
        continue;
        if (axhq.a(this.jdField_a_of_type_Axhq) != null) {
          axhq.a(this.jdField_a_of_type_Axhq).b((RecyclerView.ViewHolder)paramView.getTag(2131376906), (RecommendPerson)paramView.getTag(2131364074));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhr
 * JD-Core Version:    0.7.0.1
 */