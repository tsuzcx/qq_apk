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

public class azlu
  extends RecyclerView.Adapter<azlv>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<azkr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public azlu(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public azlv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new azlv(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495564, paramViewGroup, false));
  }
  
  public void a(azlv paramazlv, int paramInt)
  {
    azkr localazkr;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localazkr = (azkr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localazkr != null)
      {
        String str = String.valueOf(localazkr.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bacm.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).a(str, 1, false);
            localObject1 = localObject2;
          }
        }
        paramazlv.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        paramazlv.jdField_a_of_type_AndroidWidgetTextView.setText(localazkr.a());
        paramazlv.jdField_a_of_type_JavaLangString = String.valueOf(localazkr.a());
        paramazlv.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramazlv.jdField_b_of_type_AndroidWidgetImageView.setTag(localazkr);
        paramazlv.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramazlv.jdField_a_of_type_AndroidWidgetTextView.setTag(localazkr);
        paramazlv.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localazkr.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (azks)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label336;
          }
        }
      }
    }
    label336:
    for (boolean bool = ((azks)localObject2).a((QQAppInterface)localObject1, String.valueOf(localazkr.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool) {
        paramazlv.c.setVisibility(0);
      }
      while (localazkr.b())
      {
        paramazlv.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845238));
        paramazlv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramazlv.c.setVisibility(8);
      }
      paramazlv.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845227));
      paramazlv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(ArrayList<azkr> paramArrayList)
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
    if ((paramView != null) && ((paramView instanceof azkr)))
    {
      paramView = (azkr)paramView;
      azgu.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(paramView.a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        azks localazks = (azks)localQQAppInterface.getManager(203);
        if ((localazks != null) && (localazks.a(localQQAppInterface, String.valueOf(paramView.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localazks.a(localQQAppInterface, String.valueOf(paramView.a()));
        }
      }
      awqx.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(paramView.a()), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlu
 * JD-Core Version:    0.7.0.1
 */