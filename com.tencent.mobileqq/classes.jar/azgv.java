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

public class azgv
  extends RecyclerView.Adapter<azgz>
{
  Context jdField_a_of_type_AndroidContentContext;
  azha jdField_a_of_type_Azha;
  List<azhb> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public azgv(Context paramContext, List<azhb> paramList, azha paramazha)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Azha = paramazha;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementAdapter", 2, "LifeAchivementAdapter itemClickListener = " + this.jdField_a_of_type_Azha + ",listener = " + paramazha);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(azhc.a(paramInt));
    if (paramBoolean) {}
    for (paramInt = 2130845780;; paramInt = 2130845779)
    {
      Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(afur.a(2.0F, paramTextView.getResources()));
      return;
    }
  }
  
  private void a(azgz paramazgz, azhb paramazhb)
  {
    if (!TextUtils.isEmpty(paramazhb.b))
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramazhb.b, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
      {
        localURLDrawable.setAutoDownload(true);
        localURLDrawable.startDownload(true);
      }
      paramazgz.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setImageDrawable(localURLDrawable);
    }
    if (paramazhb.jdField_a_of_type_Int == 2)
    {
      paramazgz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramazgz.jdField_a_of_type_AndroidWidgetTextView.setText("+" + paramazhb.d);
      paramazgz.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
    }
    for (;;)
    {
      paramazgz.b.setText(paramazhb.jdField_a_of_type_JavaLangString);
      return;
      if (paramazhb.jdField_a_of_type_Int == 1)
      {
        paramazgz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazgz.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(4);
      }
      else
      {
        paramazgz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramazgz.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setVisibility(0);
        a(paramazgz.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView, paramazhb.jdField_a_of_type_Boolean, paramazhb.c);
      }
    }
  }
  
  public azgz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new azgz(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561397, paramViewGroup, false));
  }
  
  public azhb a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (azhb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(azgz paramazgz, int paramInt)
  {
    a(paramazgz, (azhb)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramazgz.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLayerImageView.setOnClickListener(new azgw(this, paramInt));
    paramazgz.jdField_a_of_type_ComTencentWidgetAlphaClickableTextView.setOnClickListener(new azgx(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramazgz, paramInt, getItemId(paramInt));
  }
  
  public void a(List<azhb> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramInt <= 10) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 10));
      paramList = new azhb();
      paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698041);
      paramList.b = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
      paramList.d = (paramInt - 10);
      paramList.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramList = new azhb();
        paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698035);
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
 * Qualified Name:     azgv
 * JD-Core Version:    0.7.0.1
 */