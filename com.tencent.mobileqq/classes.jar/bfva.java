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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bfva
  extends RecyclerView.Adapter<bfvb>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bftw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bfva(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bfvb a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bfvb(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561591, paramViewGroup, false));
  }
  
  public void a(bfvb parambfvb, int paramInt)
  {
    bftw localbftw;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbftw = (bftw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbftw != null)
      {
        String str = String.valueOf(localbftw.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bgmo.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambfvb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambfvb.jdField_a_of_type_AndroidWidgetTextView.setText(localbftw.a());
        parambfvb.jdField_a_of_type_JavaLangString = String.valueOf(localbftw.a());
        parambfvb.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambfvb.jdField_b_of_type_AndroidWidgetImageView.setTag(localbftw);
        parambfvb.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambfvb.jdField_a_of_type_AndroidWidgetTextView.setTag(localbftw);
        parambfvb.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbftw.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bftx)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label351;
          }
        }
      }
    }
    label320:
    label351:
    for (boolean bool = ((bftx)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbftw.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool)
      {
        parambfvb.c.setVisibility(0);
        if (!localbftw.b()) {
          break label320;
        }
        parambfvb.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846208));
        parambfvb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parambfvb, paramInt, getItemId(paramInt));
        return;
        parambfvb.c.setVisibility(8);
        break;
        parambfvb.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846174));
        parambfvb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(ArrayList<bftw> paramArrayList)
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
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof bftw)))
    {
      localObject = (bftw)localObject;
      bfpx.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(((bftw)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bftx localbftx = (bftx)localQQAppInterface.getManager(203);
        if ((localbftx != null) && (localbftx.a(localQQAppInterface, String.valueOf(((bftw)localObject).a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbftx.a(localQQAppInterface, String.valueOf(((bftw)localObject).a()));
        }
      }
      bcst.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((bftw)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfva
 * JD-Core Version:    0.7.0.1
 */