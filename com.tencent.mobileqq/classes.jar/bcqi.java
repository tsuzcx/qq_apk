import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import java.util.ArrayList;

public class bcqi
  extends RecyclerView.Adapter<bcqj>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bcpf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bcqi(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bcqj a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bcqj(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561358, paramViewGroup, false));
  }
  
  public void a(bcqj parambcqj, int paramInt)
  {
    bcpf localbcpf;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbcpf = (bcpf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbcpf != null)
      {
        String str = String.valueOf(localbcpf.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bdhj.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambcqj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambcqj.jdField_a_of_type_AndroidWidgetTextView.setText(localbcpf.a());
        parambcqj.jdField_a_of_type_JavaLangString = String.valueOf(localbcpf.a());
        parambcqj.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambcqj.jdField_b_of_type_AndroidWidgetImageView.setTag(localbcpf);
        parambcqj.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambcqj.jdField_a_of_type_AndroidWidgetTextView.setTag(localbcpf);
        parambcqj.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbcpf.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bcpg)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label336;
          }
        }
      }
    }
    label336:
    for (boolean bool = ((bcpg)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbcpf.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool) {
        parambcqj.c.setVisibility(0);
      }
      while (localbcpf.b())
      {
        parambcqj.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845773));
        parambcqj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambcqj.c.setVisibility(8);
      }
      parambcqj.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845758));
      parambcqj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(ArrayList<bcpf> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof bcpf)))
    {
      paramView = (bcpf)paramView;
      bclg.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(paramView.a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bcpg localbcpg = (bcpg)localQQAppInterface.getManager(203);
        if ((localbcpg != null) && (localbcpg.a(localQQAppInterface, String.valueOf(paramView.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbcpg.a(localQQAppInterface, String.valueOf(paramView.a()));
        }
      }
      azqs.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(paramView.a()), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqi
 * JD-Core Version:    0.7.0.1
 */