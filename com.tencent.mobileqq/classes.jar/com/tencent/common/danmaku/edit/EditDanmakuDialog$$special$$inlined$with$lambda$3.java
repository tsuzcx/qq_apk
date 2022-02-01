package com.tencent.common.danmaku.edit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.danmaku.edit.views.RichEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/common/danmaku/edit/EditDanmakuDialog$1$3"}, k=3, mv={1, 1, 16})
final class EditDanmakuDialog$$special$$inlined$with$lambda$3
  implements View.OnClickListener
{
  EditDanmakuDialog$$special$$inlined$with$lambda$3(EditDanmakuDialog paramEditDanmakuDialog) {}
  
  public final void onClick(View paramView)
  {
    EditDanmakuDialog.a(this.a).setText((CharSequence)"");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.EditDanmakuDialog..special..inlined.with.lambda.3
 * JD-Core Version:    0.7.0.1
 */