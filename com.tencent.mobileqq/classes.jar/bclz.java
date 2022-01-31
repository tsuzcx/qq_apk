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

public class bclz
  extends RecyclerView.Adapter<bcma>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bckw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bclz(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bcma a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bcma(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561340, paramViewGroup, false));
  }
  
  public void a(bcma parambcma, int paramInt)
  {
    bckw localbckw;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbckw = (bckw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbckw != null)
      {
        String str = String.valueOf(localbckw.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bdda.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambcma.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambcma.jdField_a_of_type_AndroidWidgetTextView.setText(localbckw.a());
        parambcma.jdField_a_of_type_JavaLangString = String.valueOf(localbckw.a());
        parambcma.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambcma.jdField_b_of_type_AndroidWidgetImageView.setTag(localbckw);
        parambcma.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambcma.jdField_a_of_type_AndroidWidgetTextView.setTag(localbckw);
        parambcma.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbckw.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bckx)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label336;
          }
        }
      }
    }
    label336:
    for (boolean bool = ((bckx)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbckw.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool) {
        parambcma.c.setVisibility(0);
      }
      while (localbckw.b())
      {
        parambcma.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845701));
        parambcma.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambcma.c.setVisibility(8);
      }
      parambcma.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845686));
      parambcma.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(ArrayList<bckw> paramArrayList)
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
    if ((paramView != null) && ((paramView instanceof bckw)))
    {
      paramView = (bckw)paramView;
      bcgx.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(paramView.a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bckx localbckx = (bckx)localQQAppInterface.getManager(203);
        if ((localbckx != null) && (localbckx.a(localQQAppInterface, String.valueOf(paramView.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbckx.a(localQQAppInterface, String.valueOf(paramView.a()));
        }
      }
      azmj.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(paramView.a()), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclz
 * JD-Core Version:    0.7.0.1
 */