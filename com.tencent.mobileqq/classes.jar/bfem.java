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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bfem
  extends RecyclerView.Adapter<bfen>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList<bfdl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bfem(AddedRobotView paramAddedRobotView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramAddedRobotView.getContext().getSystemService("layout_inflater"));
  }
  
  public bfen a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bfen(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561511, paramViewGroup, false));
  }
  
  public void a(bfen parambfen, int paramInt)
  {
    bfdl localbfdl;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localbfdl = (bfdl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localbfdl != null)
      {
        String str = String.valueOf(localbfdl.a());
        localObject2 = AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).getBitmapFromCache(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = bfvo.a();
          localObject1 = localObject2;
          if (!AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).isPausing())
          {
            AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView).requestDecodeFace(str, 1, false);
            localObject1 = localObject2;
          }
        }
        parambfen.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        parambfen.jdField_a_of_type_AndroidWidgetTextView.setText(localbfdl.a());
        parambfen.jdField_a_of_type_JavaLangString = String.valueOf(localbfdl.a());
        parambfen.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        parambfen.jdField_b_of_type_AndroidWidgetImageView.setTag(localbfdl);
        parambfen.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        parambfen.jdField_a_of_type_AndroidWidgetTextView.setTag(localbfdl);
        parambfen.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localbfdl.a());
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject2 = (bfdm)((QQAppInterface)localObject1).getManager(203);
          if (localObject2 == null) {
            break label351;
          }
        }
      }
    }
    label320:
    label351:
    for (boolean bool = ((bfdm)localObject2).a((QQAppInterface)localObject1, String.valueOf(localbfdl.a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView));; bool = false)
    {
      if (bool)
      {
        parambfen.c.setVisibility(0);
        if (!localbfdl.b()) {
          break label320;
        }
        parambfen.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846128));
        parambfen.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parambfen, paramInt, getItemId(paramInt));
        return;
        parambfen.c.setVisibility(8);
        break;
        parambfen.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846082));
        parambfen.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(ArrayList<bfdl> paramArrayList)
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
    if ((localObject != null) && ((localObject instanceof bfdl)))
    {
      localObject = (bfdl)localObject;
      bezm.a(this.jdField_a_of_type_AndroidContentContext, AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView), String.valueOf(((bfdl)localObject).a()));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        bfdm localbfdm = (bfdm)localQQAppInterface.getManager(203);
        if ((localbfdm != null) && (localbfdm.a(localQQAppInterface, String.valueOf(((bfdl)localObject).a()), AddedRobotView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView)))) {
          localbfdm.a(localQQAppInterface, String.valueOf(((bfdl)localObject).a()));
        }
      }
      bcef.b(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((bfdl)localObject).a()), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfem
 * JD-Core Version:    0.7.0.1
 */