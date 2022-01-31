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

public class asti
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<astj> b;
  
  public asti(aste paramaste, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramaste.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378402));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375464));
      paramaste = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramaste.hasNext())
      {
        paramView = (RecommendPerson)paramaste.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "CommonViewHolder, person.uin =" + paramView.uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562561, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375465);
        ImageView localImageView = (ImageView)paramView.findViewById(2131368720);
        TextView localTextView1 = (TextView)paramView.findViewById(2131378403);
        TextView localTextView2 = (TextView)paramView.findViewById(2131378404);
        Button localButton = (Button)paramView.findViewById(2131363688);
        astj localastj = new astj(this);
        localastj.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localastj.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localastj.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localastj.b = localTextView2;
        localastj.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localastj);
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
      } while (aste.a(this.jdField_a_of_type_Aste) == null);
      aste.a(this.jdField_a_of_type_Aste).a((RecyclerView.ViewHolder)paramView.getTag(2131375463), (RecommendPerson)paramView.getTag(2131363687));
      return;
    } while (aste.a(this.jdField_a_of_type_Aste) == null);
    aste.a(this.jdField_a_of_type_Aste).b((RecyclerView.ViewHolder)paramView.getTag(2131375463), (RecommendPerson)paramView.getTag(2131363687));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asti
 * JD-Core Version:    0.7.0.1
 */