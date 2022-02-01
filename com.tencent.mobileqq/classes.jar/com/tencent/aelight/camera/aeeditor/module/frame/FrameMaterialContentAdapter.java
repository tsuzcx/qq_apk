package com.tencent.aelight.camera.aeeditor.module.frame;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;

public class FrameMaterialContentAdapter
  extends MaterialContentAdapter
{
  public FrameMaterialContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext, 1);
    b(true);
  }
  
  protected MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new FrameMaterialContentAdapter.FrameContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056486, paramViewGroup, false));
  }
  
  public void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    if (!TextUtils.isEmpty(paramMetaMaterial.id)) {
      AEReportUtils.i(paramMetaMaterial.id);
    }
    if ((paramContentItemVH instanceof FrameMaterialContentAdapter.FrameContentItemVH))
    {
      paramContentItemVH = (FrameMaterialContentAdapter.FrameContentItemVH)paramContentItemVH;
      if ("frame".equals(FrameMetaMaterialKt.c(paramMetaMaterial)))
      {
        if (!TextUtils.isEmpty(FrameMetaMaterialKt.a(paramMetaMaterial)))
        {
          paramContentItemVH.b.setBackgroundColor(Color.parseColor(FrameMetaMaterialKt.a(paramMetaMaterial)));
          paramContentItemVH = paramContentItemVH.a.getLayoutParams();
          paramContentItemVH.height = ViewUtils.dip2px(42.0F);
          paramContentItemVH.width = ViewUtils.dip2px(42.0F);
        }
      }
      else
      {
        paramContentItemVH = paramContentItemVH.a.getLayoutParams();
        paramContentItemVH.height = -1;
        paramContentItemVH.width = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.frame.FrameMaterialContentAdapter
 * JD-Core Version:    0.7.0.1
 */