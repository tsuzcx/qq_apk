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
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class arwz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<RecommendPerson> a;
  public List<arxa> b;
  
  public arwz(arwy paramarwy, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramarwy.a.get(Integer.valueOf(paramInt)));
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312570));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309705));
      paramView = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        Object localObject = (RecommendPerson)paramView.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "ActiveViewHolder, person.uin =" + ((RecommendPerson)localObject).uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131496959, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject).findViewById(2131309706);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131303081);
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131312571);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131312572);
        Button localButton = (Button)((View)localObject).findViewById(2131298135);
        a(aciy.a(85.0F, arwy.a(paramarwy).getResources()), this.jdField_a_of_type_JavaUtilList.size(), localRelativeLayout);
        arxa localarxa = new arxa(this);
        localarxa.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localarxa.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localarxa.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localarxa.b = localTextView2;
        localarxa.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localarxa);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    if (paramInt2 > 1)
    {
      int i = bajq.a();
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
 * Qualified Name:     arwz
 * JD-Core Version:    0.7.0.1
 */