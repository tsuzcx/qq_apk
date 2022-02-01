package com.tencent.common.danmaku.edit;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.danmaku.edit.views.RichEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/common/danmaku/edit/EditDanmakuDialog$1$2"}, k=3, mv={1, 1, 16})
final class EditDanmakuDialog$$special$$inlined$with$lambda$2
  implements TextView.OnEditorActionListener
{
  EditDanmakuDialog$$special$$inlined$with$lambda$2(EditDanmakuDialog paramEditDanmakuDialog) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66))
    {
      Editable localEditable = EditDanmakuDialog.a(this.a).getText();
      Intrinsics.checkExpressionValueIsNotNull(localEditable, "contentView.text");
      if (StringsKt.trim((CharSequence)localEditable).length() > 0) {
        i = 1;
      }
      bool1 = bool2;
      if (i != 0)
      {
        EditDanmakuDialog.c(this.a).callOnClick();
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.EditDanmakuDialog..special..inlined.with.lambda.2
 * JD-Core Version:    0.7.0.1
 */