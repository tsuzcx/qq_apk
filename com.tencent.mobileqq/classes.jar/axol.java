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

public class axol
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<axom> b;
  
  public axol(axoh paramaxoh, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramaxoh.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380167));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376889));
      paramaxoh = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramaxoh.hasNext())
      {
        paramView = (RecommendPerson)paramaxoh.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131563054, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131376890);
        ImageView localImageView = (ImageView)paramView.findViewById(2131369426);
        TextView localTextView1 = (TextView)paramView.findViewById(2131380168);
        TextView localTextView2 = (TextView)paramView.findViewById(2131380169);
        Button localButton = (Button)paramView.findViewById(2131363976);
        axom localaxom = new axom(this);
        localaxom.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localaxom.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localaxom.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localaxom.b = localTextView2;
        localaxom.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localaxom);
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
      if (axoh.a(this.jdField_a_of_type_Axoh) != null)
      {
        axoh.a(this.jdField_a_of_type_Axoh).a((RecyclerView.ViewHolder)paramView.getTag(2131376888), (RecommendPerson)paramView.getTag(2131363975));
        continue;
        if (axoh.a(this.jdField_a_of_type_Axoh) != null) {
          axoh.a(this.jdField_a_of_type_Axoh).b((RecyclerView.ViewHolder)paramView.getTag(2131376888), (RecommendPerson)paramView.getTag(2131363975));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axol
 * JD-Core Version:    0.7.0.1
 */