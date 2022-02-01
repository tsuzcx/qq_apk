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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bgms
  extends RecyclerView.Adapter<bgmt>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bglr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bgms(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bgmt a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bgmt(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561574, paramViewGroup, false));
  }
  
  public void a(bgmt parambgmt, int paramInt)
  {
    bglr localbglr;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbglr = (bglr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbglr != null)
      {
        String str = String.valueOf(localbglr.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).getBitmapFromCache(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bheg.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).isPausing())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).requestDecodeFace(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambgmt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambgmt.jdField_a_of_type_AndroidWidgetTextView.setText(localbglr.a());
        parambgmt.jdField_a_of_type_JavaLangString = String.valueOf(localbglr.a());
        parambgmt.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambgmt.jdField_b_of_type_AndroidWidgetImageView.setTag(localbglr);
        parambgmt.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambgmt.jdField_a_of_type_AndroidWidgetTextView.setTag(localbglr);
        parambgmt.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbglr.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bgls)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
          if (localObject2 == null) {
            break label351;
          }
        }
      }
    }
    label320:
    label351:
    for (boolean bool = ((bgls)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbglr.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool)
      {
        parambgmt.c.setVisibility(0);
        if (!localbglr.b()) {
          break label320;
        }
        parambgmt.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846224));
        parambgmt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parambgmt, paramInt, getItemId(paramInt));
        return;
        parambgmt.c.setVisibility(8);
        break;
        parambgmt.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846173));
        parambgmt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(ArrayList<bglr> paramArrayList)
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
    if ((localObject != null) && ((localObject instanceof bglr)))
    {
      localObject = (bglr)localObject;
      bghs.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(((bglr)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bgls localbgls = (bgls)localQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        if ((localbgls != null) && (localbgls.a(localQQAppInterface, String.valueOf(((bglr)localObject).a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbgls.a(localQQAppInterface, String.valueOf(((bglr)localObject).a()));
        }
      }
      bdla.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((bglr)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgms
 * JD-Core Version:    0.7.0.1
 */