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
  List<DynamicTextConfigManager.DynamicTextConfigBean> a;
  public OnHolderItemClickListener b;
  public DynamicTextConfigManager c;
  
  public EditTextEffectView$EditTextAdapter(EditTextEffectView paramEditTextEffectView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.b = paramOnHolderItemClickListener;
    this.c = ((DynamicTextConfigManager)QIMManager.a(7));
  }
  
  public EditTextEffectView.EditTextHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new EditTextEffectView.EditTextHolder(LayoutInflater.from(this.d.getContext()).inflate(2131628032, paramViewGroup, false), this.b);
  }
  
  public void a(EditTextEffectView.EditTextHolder paramEditTextHolder, int paramInt)
  {
    Object localObject1 = (DynamicTextConfigManager.DynamicTextConfigBean)this.a.get(paramInt);
    paramEditTextHolder.b = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject1);
    Object localObject2 = (ViewGroup.MarginLayoutParams)paramEditTextHolder.c.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = EditTextEffectView.b;
    ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = EditTextEffectView.a;
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = EditTextEffectView.c;
    paramEditTextHolder.e.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject1).text_id == this.d.i) {
      paramEditTextHolder.f.setVisibility(0);
    } else {
      paramEditTextHolder.f.setVisibility(8);
    }
    paramEditTextHolder.d.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject1).iconDrawableId);
    if (this.c.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject1)) {
      paramEditTextHolder.h.setVisibility(8);
    } else {
      paramEditTextHolder.h.setVisibility(0);
    }
    paramEditTextHolder.i.setVisibility(8);
    paramEditTextHolder.j = paramInt;
    localObject1 = DynamicTextBuilder.b(((DynamicTextConfigManager.DynamicTextConfigBean)localObject1).text_id);
    if (localObject1 != null)
    {
      paramEditTextHolder = paramEditTextHolder.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901805));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901806));
      paramEditTextHolder.setContentDescription(((StringBuilder)localObject2).toString());
      return;
    }
    paramEditTextHolder.c.setContentDescription(null);
  }
  
  public void a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView.EditTextAdapter
 * JD-Core Version:    0.7.0.1
 */