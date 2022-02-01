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

public class aynw
  extends RecyclerView.Adapter<ayoa>
{
  Context jdField_a_of_type_AndroidContentContext;
  ayob jdField_a_of_type_Ayob;
  List<ayoc> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aynw(Context paramContext, List<ayoc> paramList, ayob paramayob)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Ayob = paramayob;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementAdapter", 2, "LifeAchivementAdapter itemClickListener = " + this.jdField_a_of_type_Ayob + ",listener = " + paramayob);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(ayod.a(paramInt));
    if (paramBoolean) {}
    for (paramInt = 2130845695;; paramInt = 2130845694)
    {
      Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, paramTextView.getResources()));
      return;
    }
  }
  
  private void a(ayoa paramayoa, ayoc paramayoc)
  {
    if (!TextUtils.isEmpty(paramayoc.b))
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramayoc.b, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
      {
        localURLDrawable.setAutoDownload(true);
        localURLDrawable.startDownload(true);
      }
      paramayoa.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setImageDrawable(localURLDrawable);
    }
    if (paramayoc.jdField_a_of_type_Int == 2)
    {
      paramayoa.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramayoa.jdField_a_of_type_AndroidWidgetTextView.setText("+" + paramayoc.d);
      paramayoa.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
    }
    for (;;)
    {
      paramayoa.b.setText(paramayoc.jdField_a_of_type_JavaLangString);
      return;
      if (paramayoc.jdField_a_of_type_Int == 1)
      {
        paramayoa.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramayoa.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
      }
      else
      {
        paramayoa.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramayoa.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(0);
        a(paramayoa.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView, paramayoc.jdField_a_of_type_Boolean, paramayoc.c);
      }
    }
  }
  
  public ayoa a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ayoa(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561322, paramViewGroup, false));
  }
  
  public ayoc a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (ayoc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(ayoa paramayoa, int paramInt)
  {
    a(paramayoa, (ayoc)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramayoa.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setOnClickListener(new aynx(this, paramInt));
    paramayoa.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setOnClickListener(new ayny(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramayoa, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ayoc> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramInt <= 10) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 10));
      paramList = new ayoc();
      paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698307);
      paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
      paramList.d = (paramInt - 10);
      paramList.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramList = new ayoc();
        paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698301);
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
 * Qualified Name:     aynw
 * JD-Core Version:    0.7.0.1
 */