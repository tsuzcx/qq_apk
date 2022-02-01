package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import java.util.List;

public class EditTextEffectView$EditTextAdapter
  extends RecyclerView.Adapter<EditTextEffectView.EditTextHolder>
{
  public DynamicTextConfigManager a;
  public OnHolderItemClickListener a;
  List<DynamicTextConfigManager.DynamicTextConfigBean> jdField_a_of_type_JavaUtilList;
  
  public EditTextEffectView$EditTextAdapter(EditTextEffectView paramEditTextEffectView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)QIMManager.a(7));
  }
  
  public EditTextEffectView.EditTextHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new EditTextEffectView.EditTextHolder(LayoutInflater.from(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131561653, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
  }
  
  public void a(EditTextEffectView.EditTextHolder paramEditTextHolder, int paramInt)
  {
    Object localObject1 = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramEditTextHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject1);
    Object localObject2 = (ViewGroup.MarginLayoutParams)paramEditTextHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = EditTextEffectView.b;
    ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = EditTextEffectView.c;
    paramEditTextHolder.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject1).text_id == this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.d) {
      paramEditTextHolder.c.setVisibility(0);
    } else {
      paramEditTextHolder.c.setVisibility(8);
    }
    paramEditTextHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject1).iconDrawableId);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject1)) {
      paramEditTextHolder.d.setVisibility(8);
    } else {
      paramEditTextHolder.d.setVisibility(0);
    }
    paramEditTextHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setVisibility(8);
    paramEditTextHolder.jdField_a_of_type_Int = paramInt;
    localObject1 = DynamicTextBuilder.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject1).text_id);
    if (localObject1 != null)
    {
      paramEditTextHolder = paramEditTextHolder.jdField_a_of_type_AndroidViewView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703859));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703860));
      paramEditTextHolder.setContentDescription(((StringBuilder)localObject2).toString());
      return;
    }
    paramEditTextHolder.jdField_a_of_type_AndroidViewView.setContentDescription(null);
  }
  
  public void a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView.EditTextAdapter
 * JD-Core Version:    0.7.0.1
 */