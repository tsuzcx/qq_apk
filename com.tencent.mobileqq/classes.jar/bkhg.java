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

public class bkhg
  extends RecyclerView.Adapter<bkhh>
{
  public apze a;
  public DynamicTextConfigManager a;
  public List<DynamicTextConfigManager.DynamicTextConfigBean> a;
  
  public bkhg(EditTextEffectView paramEditTextEffectView, apze paramapze)
  {
    this.jdField_a_of_type_Apze = paramapze;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bjav.a(7));
  }
  
  public bkhh a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkhh(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131561230, paramViewGroup, false), this.jdField_a_of_type_Apze);
  }
  
  public void a(bkhh parambkhh, int paramInt)
  {
    Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambkhh.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)parambkhh.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.leftMargin = EditTextEffectView.b;
    localMarginLayoutParams.bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    localMarginLayoutParams.topMargin = EditTextEffectView.c;
    parambkhh.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.d)
    {
      parambkhh.c.setVisibility(0);
      parambkhh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        break label193;
      }
      parambkhh.d.setVisibility(8);
    }
    for (;;)
    {
      parambkhh.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambkhh.jdField_a_of_type_Int = paramInt;
      localObject = bjhi.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
      if (localObject == null) {
        break label204;
      }
      parambkhh.jdField_a_of_type_AndroidViewView.setContentDescription(ajya.a(2131703709) + (String)localObject + ajya.a(2131703710));
      return;
      parambkhh.c.setVisibility(8);
      break;
      label193:
      parambkhh.d.setVisibility(0);
    }
    label204:
    parambkhh.jdField_a_of_type_AndroidViewView.setContentDescription(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhg
 * JD-Core Version:    0.7.0.1
 */