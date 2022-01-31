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

public class auoo
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<auop> b;
  
  public auoo(auok paramauok, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramauok.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379068));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376004));
      paramauok = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramauok.hasNext())
      {
        paramView = (RecommendPerson)paramauok.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562781, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131376005);
        ImageView localImageView = (ImageView)paramView.findViewById(2131368954);
        TextView localTextView1 = (TextView)paramView.findViewById(2131379069);
        TextView localTextView2 = (TextView)paramView.findViewById(2131379070);
        Button localButton = (Button)paramView.findViewById(2131363746);
        auop localauop = new auop(this);
        localauop.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localauop.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localauop.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localauop.b = localTextView2;
        localauop.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localauop);
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
      } while (auok.a(this.jdField_a_of_type_Auok) == null);
      auok.a(this.jdField_a_of_type_Auok).a((RecyclerView.ViewHolder)paramView.getTag(2131376003), (RecommendPerson)paramView.getTag(2131363745));
      return;
    } while (auok.a(this.jdField_a_of_type_Auok) == null);
    auok.a(this.jdField_a_of_type_Auok).b((RecyclerView.ViewHolder)paramView.getTag(2131376003), (RecommendPerson)paramView.getTag(2131363745));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auoo
 * JD-Core Version:    0.7.0.1
 */