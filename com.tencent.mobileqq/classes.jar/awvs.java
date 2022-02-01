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

public class awvs
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<awvt> b;
  
  public awvs(awvo paramawvo, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramawvo.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379983));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376753));
      paramawvo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramawvo.hasNext())
      {
        paramView = (RecommendPerson)paramawvo.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131563019, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131376754);
        ImageView localImageView = (ImageView)paramView.findViewById(2131369336);
        TextView localTextView1 = (TextView)paramView.findViewById(2131379984);
        TextView localTextView2 = (TextView)paramView.findViewById(2131379985);
        Button localButton = (Button)paramView.findViewById(2131363952);
        awvt localawvt = new awvt(this);
        localawvt.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localawvt.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localawvt.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localawvt.b = localTextView2;
        localawvt.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localawvt);
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
      if (awvo.a(this.jdField_a_of_type_Awvo) != null)
      {
        awvo.a(this.jdField_a_of_type_Awvo).a((RecyclerView.ViewHolder)paramView.getTag(2131376752), (RecommendPerson)paramView.getTag(2131363951));
        continue;
        if (awvo.a(this.jdField_a_of_type_Awvo) != null) {
          awvo.a(this.jdField_a_of_type_Awvo).b((RecyclerView.ViewHolder)paramView.getTag(2131376752), (RecommendPerson)paramView.getTag(2131363951));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvs
 * JD-Core Version:    0.7.0.1
 */