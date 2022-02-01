package com.tencent.common.danmaku.edit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.danmaku.edit.listener.EditDanmakuListener;
import com.tencent.common.danmaku.edit.views.RichEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/common/danmaku/edit/EditDanmakuDialog$1$4"}, k=3, mv={1, 1, 16})
final class EditDanmakuDialog$$special$$inlined$with$lambda$4
  implements View.OnClickListener
{
  EditDanmakuDialog$$special$$inlined$with$lambda$4(EditDanmakuDialog paramEditDanmakuDialog) {}
  
  public final void onClick(View paramView)
  {
    EditDanmakuListener localEditDanmakuListener = this.a.b();
    if (localEditDanmakuListener != null) {
      localEditDanmakuListener.b(EditDanmakuDialog.a(this.a).getText().toString());
    }
    EditDanmakuDialog.a(this.a).setText((CharSequence)"");
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.EditDanmakuDialog..special..inlined.with.lambda.4
 * JD-Core Version:    0.7.0.1
 */