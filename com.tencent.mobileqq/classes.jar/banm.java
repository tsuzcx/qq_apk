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

public class banm
  extends RecyclerView.Adapter<bann>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bamj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public banm(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bann a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bann(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561152, paramViewGroup, false));
  }
  
  public void a(bann parambann, int paramInt)
  {
    bamj localbamj;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbamj = (bamj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbamj != null)
      {
        String str = String.valueOf(localbamj.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bbef.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambann.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambann.jdField_a_of_type_AndroidWidgetTextView.setText(localbamj.a());
        parambann.jdField_a_of_type_JavaLangString = String.valueOf(localbamj.a());
        parambann.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambann.jdField_b_of_type_AndroidWidgetImageView.setTag(localbamj);
        parambann.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambann.jdField_a_of_type_AndroidWidgetTextView.setTag(localbamj);
        parambann.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbamj.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bamk)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label336;
          }
        }
      }
    }
    label336:
    for (boolean bool = ((bamk)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbamj.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool) {
        parambann.c.setVisibility(0);
      }
      while (localbamj.b())
      {
        parambann.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845332));
        parambann.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambann.c.setVisibility(8);
      }
      parambann.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845317));
      parambann.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(ArrayList<bamj> paramArrayList)
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
    if ((paramView != null) && ((paramView instanceof bamj)))
    {
      paramView = (bamj)paramView;
      bail.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(paramView.a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bamk localbamk = (bamk)localQQAppInterface.getManager(203);
        if ((localbamk != null) && (localbamk.a(localQQAppInterface, String.valueOf(paramView.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbamk.a(localQQAppInterface, String.valueOf(paramView.a()));
        }
      }
      axqy.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(paramView.a()), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     banm
 * JD-Core Version:    0.7.0.1
 */