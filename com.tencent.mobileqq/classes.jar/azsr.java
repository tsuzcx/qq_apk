import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.lifeachivement.LayerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableTextView;
import java.util.ArrayList;
import java.util.List;

public class azsr
  extends RecyclerView.Adapter<azsv>
{
  Context jdField_a_of_type_AndroidContentContext;
  azsw jdField_a_of_type_Azsw;
  List<azsx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public azsr(Context paramContext, List<azsx> paramList, azsw paramazsw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Azsw = paramazsw;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementAdapter", 2, "LifeAchivementAdapter itemClickListener = " + this.jdField_a_of_type_Azsw + ",listener = " + paramazsw);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(azsy.a(paramInt));
    if (paramBoolean) {}
    for (paramInt = 2130845783;; paramInt = 2130845782)
    {
      Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, paramTextView.getResources()));
      return;
    }
  }
  
  private void a(azsv paramazsv, azsx paramazsx)
  {
    if (!TextUtils.isEmpty(paramazsx.b))
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramazsx.b, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
      {
        localURLDrawable.setAutoDownload(true);
        localURLDrawable.startDownload(true);
      }
      paramazsv.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setImageDrawable(localURLDrawable);
    }
    if (paramazsx.jdField_a_of_type_Int == 2)
    {
      paramazsv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramazsv.jdField_a_of_type_AndroidWidgetTextView.setText("+" + paramazsx.d);
      paramazsv.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
    }
    for (;;)
    {
      paramazsv.b.setText(paramazsx.jdField_a_of_type_JavaLangString);
      return;
      if (paramazsx.jdField_a_of_type_Int == 1)
      {
        paramazsv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazsv.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
      }
      else
      {
        paramazsv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazsv.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(0);
        a(paramazsv.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView, paramazsx.jdField_a_of_type_Boolean, paramazsx.c);
      }
    }
  }
  
  public azsv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new azsv(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561383, paramViewGroup, false));
  }
  
  public azsx a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (azsx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(azsv paramazsv, int paramInt)
  {
    a(paramazsv, (azsx)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramazsv.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setOnClickListener(new azss(this, paramInt));
    paramazsv.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setOnClickListener(new azst(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramazsv, paramInt, getItemId(paramInt));
  }
  
  public void a(List<azsx> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramInt <= 10) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 10));
      paramList = new azsx();
      paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698603);
      paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
      paramList.d = (paramInt - 10);
      paramList.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramList = new azsx();
        paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698597);
        paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
        paramList.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_JavaUtilList.add(0, paramList);
      }
      notifyDataSetChanged();
      return;
      label150:
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsr
 * JD-Core Version:    0.7.0.1
 */