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

public class bqqd
  extends RecyclerView.Adapter<bqqe>
{
  public auvu a;
  public DynamicTextConfigManager a;
  public List<DynamicTextConfigManager.DynamicTextConfigBean> a;
  
  public bqqd(EditTextEffectView paramEditTextEffectView, auvu paramauvu)
  {
    this.jdField_a_of_type_Auvu = paramauvu;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bplq.a(7));
  }
  
  public bqqe a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bqqe(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131561715, paramViewGroup, false), this.jdField_a_of_type_Auvu);
  }
  
  public void a(bqqe parambqqe, int paramInt)
  {
    Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambqqe.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)parambqqe.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.leftMargin = EditTextEffectView.b;
    localMarginLayoutParams.bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    localMarginLayoutParams.topMargin = EditTextEffectView.c;
    parambqqe.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.d)
    {
      parambqqe.c.setVisibility(0);
      parambqqe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        break label206;
      }
      parambqqe.d.setVisibility(8);
      label117:
      parambqqe.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambqqe.jdField_a_of_type_Int = paramInt;
      localObject = bpse.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
      if (localObject == null) {
        break label217;
      }
      parambqqe.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131702597) + (String)localObject + anzj.a(2131702598));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambqqe, paramInt, getItemId(paramInt));
      return;
      parambqqe.c.setVisibility(8);
      break;
      label206:
      parambqqe.d.setVisibility(0);
      break label117;
      label217:
      parambqqe.jdField_a_of_type_AndroidViewView.setContentDescription(null);
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
 * Qualified Name:     bqqd
 * JD-Core Version:    0.7.0.1
 */