import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import java.util.List;

public class bmsq
  extends RecyclerView.Adapter<bmsr>
{
  public arsg a;
  public DynamicTextConfigManager a;
  public List<DynamicTextConfigManager.DynamicTextConfigBean> a;
  
  public bmsq(EditTextEffectView paramEditTextEffectView, arsg paramarsg)
  {
    this.jdField_a_of_type_Arsg = paramarsg;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)blmf.a(7));
  }
  
  public bmsr a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bmsr(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131561420, paramViewGroup, false), this.jdField_a_of_type_Arsg);
  }
  
  public void a(bmsr parambmsr, int paramInt)
  {
    Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambmsr.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)parambmsr.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.leftMargin = EditTextEffectView.b;
    localMarginLayoutParams.bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    localMarginLayoutParams.topMargin = EditTextEffectView.c;
    parambmsr.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.d)
    {
      parambmsr.c.setVisibility(0);
      parambmsr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        break label193;
      }
      parambmsr.d.setVisibility(8);
    }
    for (;;)
    {
      parambmsr.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambmsr.jdField_a_of_type_Int = paramInt;
      localObject = blst.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
      if (localObject == null) {
        break label204;
      }
      parambmsr.jdField_a_of_type_AndroidViewView.setContentDescription(alpo.a(2131704081) + (String)localObject + alpo.a(2131704082));
      return;
      parambmsr.c.setVisibility(8);
      break;
      label193:
      parambmsr.d.setVisibility(0);
    }
    label204:
    parambmsr.jdField_a_of_type_AndroidViewView.setContentDescription(null);
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
 * Qualified Name:     bmsq
 * JD-Core Version:    0.7.0.1
 */