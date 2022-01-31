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

public class bipu
  extends RecyclerView.Adapter<bipv>
{
  public apgz a;
  public DynamicTextConfigManager a;
  public List<DynamicTextConfigManager.DynamicTextConfigBean> a;
  
  public bipu(EditTextEffectView paramEditTextEffectView, apgz paramapgz)
  {
    this.jdField_a_of_type_Apgz = paramapgz;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bhfm.a(7));
  }
  
  public bipv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bipv(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131495640, paramViewGroup, false), this.jdField_a_of_type_Apgz);
  }
  
  public void a(bipv parambipv, int paramInt)
  {
    Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambipv.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)parambipv.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.leftMargin = EditTextEffectView.b;
    localMarginLayoutParams.bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    localMarginLayoutParams.topMargin = EditTextEffectView.c;
    parambipv.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.d)
    {
      parambipv.c.setVisibility(0);
      parambipv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        break label193;
      }
      parambipv.d.setVisibility(8);
    }
    for (;;)
    {
      parambipv.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambipv.jdField_a_of_type_Int = paramInt;
      localObject = bhlz.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
      if (localObject == null) {
        break label204;
      }
      parambipv.jdField_a_of_type_AndroidViewView.setContentDescription(ajjy.a(2131637913) + (String)localObject + ajjy.a(2131637914));
      return;
      parambipv.c.setVisibility(8);
      break;
      label193:
      parambipv.d.setVisibility(0);
    }
    label204:
    parambipv.jdField_a_of_type_AndroidViewView.setContentDescription(null);
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
 * Qualified Name:     bipu
 * JD-Core Version:    0.7.0.1
 */