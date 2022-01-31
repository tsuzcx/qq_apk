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

public class arxc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<arxd> b;
  
  public arxc(arwy paramarwy, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramarwy.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312573));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309707));
      paramarwy = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramarwy.hasNext())
      {
        paramView = (RecommendPerson)paramarwy.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131496962, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131309708);
        ImageView localImageView = (ImageView)paramView.findViewById(2131303082);
        TextView localTextView1 = (TextView)paramView.findViewById(2131312574);
        TextView localTextView2 = (TextView)paramView.findViewById(2131312575);
        Button localButton = (Button)paramView.findViewById(2131298136);
        arxd localarxd = new arxd(this);
        localarxd.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localarxd.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localarxd.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localarxd.b = localTextView2;
        localarxd.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localarxd);
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
      } while (arwy.a(this.jdField_a_of_type_Arwy) == null);
      arwy.a(this.jdField_a_of_type_Arwy).a((RecyclerView.ViewHolder)paramView.getTag(2131309706), (RecommendPerson)paramView.getTag(2131298135));
      return;
    } while (arwy.a(this.jdField_a_of_type_Arwy) == null);
    arwy.a(this.jdField_a_of_type_Arwy).b((RecyclerView.ViewHolder)paramView.getTag(2131309706), (RecommendPerson)paramView.getTag(2131298135));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arxc
 * JD-Core Version:    0.7.0.1
 */