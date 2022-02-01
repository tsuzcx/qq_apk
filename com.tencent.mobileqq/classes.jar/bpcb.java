import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import java.util.List;

public class bpcb
  extends RecyclerView.Adapter<bpcc>
{
  public aumj a;
  public DynamicTextConfigManager a;
  public List<DynamicTextConfigManager.DynamicTextConfigBean> a;
  
  public bpcb(EditTextEffectView paramEditTextEffectView, aumj paramaumj)
  {
    this.jdField_a_of_type_Aumj = paramaumj;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bogd.a(7));
  }
  
  public bpcc a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bpcc(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131561662, paramViewGroup, false), this.jdField_a_of_type_Aumj);
  }
  
  public void a(bpcc parambpcc, int paramInt)
  {
    Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambpcc.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)parambpcc.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.leftMargin = EditTextEffectView.b;
    localMarginLayoutParams.bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    localMarginLayoutParams.topMargin = EditTextEffectView.c;
    parambpcc.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.d)
    {
      parambpcc.c.setVisibility(0);
      parambpcc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        break label206;
      }
      parambpcc.d.setVisibility(8);
      label117:
      parambpcc.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambpcc.jdField_a_of_type_Int = paramInt;
      localObject = bolc.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
      if (localObject == null) {
        break label217;
      }
      parambpcc.jdField_a_of_type_AndroidViewView.setContentDescription(anvx.a(2131703183) + (String)localObject + anvx.a(2131703184));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambpcc, paramInt, getItemId(paramInt));
      return;
      parambpcc.c.setVisibility(8);
      break;
      label206:
      parambpcc.d.setVisibility(0);
      break label117;
      label217:
      parambpcc.jdField_a_of_type_AndroidViewView.setContentDescription(null);
    }
  }
  
  public void a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcb
 * JD-Core Version:    0.7.0.1
 */