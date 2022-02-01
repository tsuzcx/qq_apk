import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.lifeachivement.LayerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableTextView;
import java.util.ArrayList;
import java.util.List;

public class azzh
  extends RecyclerView.Adapter<azzl>
{
  Context jdField_a_of_type_AndroidContentContext;
  azzm jdField_a_of_type_Azzm;
  List<azzn> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public azzh(Context paramContext, List<azzn> paramList, azzm paramazzm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Azzm = paramazzm;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementAdapter", 2, "LifeAchivementAdapter itemClickListener = " + this.jdField_a_of_type_Azzm + ",listener = " + paramazzm);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(azzo.a(paramInt));
    if (paramBoolean) {}
    for (paramInt = 2130845795;; paramInt = 2130845794)
    {
      Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(agej.a(2.0F, paramTextView.getResources()));
      return;
    }
  }
  
  private void a(azzl paramazzl, azzn paramazzn)
  {
    if (!TextUtils.isEmpty(paramazzn.b))
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramazzn.b, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
      {
        localURLDrawable.setAutoDownload(true);
        localURLDrawable.startDownload(true);
      }
      paramazzl.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setImageDrawable(localURLDrawable);
    }
    if (paramazzn.jdField_a_of_type_Int == 2)
    {
      paramazzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramazzl.jdField_a_of_type_AndroidWidgetTextView.setText("+" + paramazzn.d);
      paramazzl.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
    }
    for (;;)
    {
      paramazzl.b.setText(paramazzn.jdField_a_of_type_JavaLangString);
      return;
      if (paramazzn.jdField_a_of_type_Int == 1)
      {
        paramazzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazzl.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
      }
      else
      {
        paramazzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazzl.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(0);
        a(paramazzl.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView, paramazzn.jdField_a_of_type_Boolean, paramazzn.c);
      }
    }
  }
  
  public azzl a(ViewGroup paramViewGroup, int paramInt)
  {
    return new azzl(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561438, paramViewGroup, false));
  }
  
  public azzn a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (azzn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(azzl paramazzl, int paramInt)
  {
    a(paramazzl, (azzn)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramazzl.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setOnClickListener(new azzi(this, paramInt));
    paramazzl.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setOnClickListener(new azzj(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramazzl, paramInt, getItemId(paramInt));
  }
  
  public void a(List<azzn> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramInt <= 10) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 10));
      paramList = new azzn();
      paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698142);
      paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
      paramList.d = (paramInt - 10);
      paramList.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramList = new azzn();
        paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698136);
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
 * Qualified Name:     azzh
 * JD-Core Version:    0.7.0.1
 */