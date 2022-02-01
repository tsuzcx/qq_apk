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

public class bgvb
  extends RecyclerView.Adapter<bgvc>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bgtx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bgvb(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bgvc a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bgvc(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561632, paramViewGroup, false));
  }
  
  public void a(bgvc parambgvc, int paramInt)
  {
    bgtx localbgtx;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbgtx = (bgtx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbgtx != null)
      {
        String str = String.valueOf(localbgtx.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bhmq.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambgvc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambgvc.jdField_a_of_type_AndroidWidgetTextView.setText(localbgtx.a());
        parambgvc.jdField_a_of_type_JavaLangString = String.valueOf(localbgtx.a());
        parambgvc.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambgvc.jdField_b_of_type_AndroidWidgetImageView.setTag(localbgtx);
        parambgvc.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambgvc.jdField_a_of_type_AndroidWidgetTextView.setTag(localbgtx);
        parambgvc.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbgtx.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bgty)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label351;
          }
        }
      }
    }
    label320:
    label351:
    for (boolean bool = ((bgty)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbgtx.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool)
      {
        parambgvc.c.setVisibility(0);
        if (!localbgtx.b()) {
          break label320;
        }
        parambgvc.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846223));
        parambgvc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parambgvc, paramInt, getItemId(paramInt));
        return;
        parambgvc.c.setVisibility(8);
        break;
        parambgvc.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846189));
        parambgvc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(ArrayList<bgtx> paramArrayList)
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
    if ((localObject != null) && ((localObject instanceof bgtx)))
    {
      localObject = (bgtx)localObject;
      bgpy.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(((bgtx)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bgty localbgty = (bgty)localQQAppInterface.getManager(203);
        if ((localbgty != null) && (localbgty.a(localQQAppInterface, String.valueOf(((bgtx)localObject).a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbgty.a(localQQAppInterface, String.valueOf(((bgtx)localObject).a()));
        }
      }
      bdll.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((bgtx)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvb
 * JD-Core Version:    0.7.0.1
 */