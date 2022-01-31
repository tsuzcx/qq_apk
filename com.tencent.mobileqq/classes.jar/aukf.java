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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aukf
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<aukg> b;
  
  public aukf(aukb paramaukb, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramaukb.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379010));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375951));
      paramaukb = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramaukb.hasNext())
      {
        paramView = (RecommendPerson)paramaukb.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562763, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375952);
        ImageView localImageView = (ImageView)paramView.findViewById(2131368936);
        TextView localTextView1 = (TextView)paramView.findViewById(2131379011);
        TextView localTextView2 = (TextView)paramView.findViewById(2131379012);
        Button localButton = (Button)paramView.findViewById(2131363744);
        aukg localaukg = new aukg(this);
        localaukg.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localaukg.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localaukg.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localaukg.b = localTextView2;
        localaukg.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localaukg);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (aukb.a(this.jdField_a_of_type_Aukb) == null);
      aukb.a(this.jdField_a_of_type_Aukb).a((RecyclerView.ViewHolder)paramView.getTag(2131375950), (RecommendPerson)paramView.getTag(2131363743));
      return;
    } while (aukb.a(this.jdField_a_of_type_Aukb) == null);
    aukb.a(this.jdField_a_of_type_Aukb).b((RecyclerView.ViewHolder)paramView.getTag(2131375950), (RecommendPerson)paramView.getTag(2131363743));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aukf
 * JD-Core Version:    0.7.0.1
 */