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

public class bamy
  extends RecyclerView.Adapter<bamz>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<balv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bamy(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bamz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bamz(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561153, paramViewGroup, false));
  }
  
  public void a(bamz parambamz, int paramInt)
  {
    balv localbalv;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbalv = (balv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbalv != null)
      {
        String str = String.valueOf(localbalv.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bbdr.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambamz.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambamz.jdField_a_of_type_AndroidWidgetTextView.setText(localbalv.a());
        parambamz.jdField_a_of_type_JavaLangString = String.valueOf(localbalv.a());
        parambamz.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambamz.jdField_b_of_type_AndroidWidgetImageView.setTag(localbalv);
        parambamz.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambamz.jdField_a_of_type_AndroidWidgetTextView.setTag(localbalv);
        parambamz.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbalv.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (balw)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label336;
          }
        }
      }
    }
    label336:
    for (boolean bool = ((balw)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbalv.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool) {
        parambamz.c.setVisibility(0);
      }
      while (localbalv.b())
      {
        parambamz.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845326));
        parambamz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambamz.c.setVisibility(8);
      }
      parambamz.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845315));
      parambamz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(ArrayList<balv> paramArrayList)
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
    if ((paramView != null) && ((paramView instanceof balv)))
    {
      paramView = (balv)paramView;
      bahx.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(paramView.a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        balw localbalw = (balw)localQQAppInterface.getManager(203);
        if ((localbalw != null) && (localbalw.a(localQQAppInterface, String.valueOf(paramView.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbalw.a(localQQAppInterface, String.valueOf(paramView.a()));
        }
      }
      axqw.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(paramView.a()), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bamy
 * JD-Core Version:    0.7.0.1
 */