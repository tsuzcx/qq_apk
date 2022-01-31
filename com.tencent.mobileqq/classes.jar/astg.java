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

public class astg
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<asth> b;
  
  public astg(astc paramastc, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramastc.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378397));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375462));
      paramastc = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramastc.hasNext())
      {
        paramView = (RecommendPerson)paramastc.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562562, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375463);
        ImageView localImageView = (ImageView)paramView.findViewById(2131368720);
        TextView localTextView1 = (TextView)paramView.findViewById(2131378398);
        TextView localTextView2 = (TextView)paramView.findViewById(2131378399);
        Button localButton = (Button)paramView.findViewById(2131363689);
        asth localasth = new asth(this);
        localasth.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localasth.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localasth.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localasth.b = localTextView2;
        localasth.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localasth);
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
      } while (astc.a(this.jdField_a_of_type_Astc) == null);
      astc.a(this.jdField_a_of_type_Astc).a((RecyclerView.ViewHolder)paramView.getTag(2131375461), (RecommendPerson)paramView.getTag(2131363688));
      return;
    } while (astc.a(this.jdField_a_of_type_Astc) == null);
    astc.a(this.jdField_a_of_type_Astc).b((RecyclerView.ViewHolder)paramView.getTag(2131375461), (RecommendPerson)paramView.getTag(2131363688));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     astg
 * JD-Core Version:    0.7.0.1
 */