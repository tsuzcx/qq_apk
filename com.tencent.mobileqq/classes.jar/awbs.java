import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class awbs
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<awbt> b;
  
  public awbs(awbo paramawbo, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramawbo.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379901));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376645));
      paramawbo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramawbo.hasNext())
      {
        paramView = (RecommendPerson)paramawbo.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562935, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131376646);
        ImageView localImageView = (ImageView)paramView.findViewById(2131369411);
        TextView localTextView1 = (TextView)paramView.findViewById(2131379902);
        TextView localTextView2 = (TextView)paramView.findViewById(2131379903);
        Button localButton = (Button)paramView.findViewById(2131364001);
        awbt localawbt = new awbt(this);
        localawbt.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localawbt.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localawbt.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localawbt.b = localTextView2;
        localawbt.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localawbt);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
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
      if (awbo.a(this.jdField_a_of_type_Awbo) != null)
      {
        awbo.a(this.jdField_a_of_type_Awbo).a((RecyclerView.ViewHolder)paramView.getTag(2131376644), (RecommendPerson)paramView.getTag(2131364000));
        continue;
        if (awbo.a(this.jdField_a_of_type_Awbo) != null) {
          awbo.a(this.jdField_a_of_type_Awbo).b((RecyclerView.ViewHolder)paramView.getTag(2131376644), (RecommendPerson)paramView.getTag(2131364000));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbs
 * JD-Core Version:    0.7.0.1
 */