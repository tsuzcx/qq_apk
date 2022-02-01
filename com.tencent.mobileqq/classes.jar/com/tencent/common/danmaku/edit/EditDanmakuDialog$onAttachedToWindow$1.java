package com.tencent.common.danmaku.edit;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.danmaku.edit.views.RichEditText;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.util.DanmakuUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EditDanmakuDialog$onAttachedToWindow$1
  implements Runnable
{
  EditDanmakuDialog$onAttachedToWindow$1(EditDanmakuDialog paramEditDanmakuDialog) {}
  
  public final void run()
  {
    EditDanmakuDialog.a(this.this$0).requestFocus();
    Object localObject = EditDanmakuDialog.a(this.this$0);
    WindowConfig localWindowConfig = DanmakuContext.a();
    Intrinsics.checkExpressionValueIsNotNull(localWindowConfig, "DanmakuContext.getWindowConfig()");
    ((RichEditText)localObject).setMinWidth(localWindowConfig.j() - DanmakuUtils.a(150.0F));
    localObject = this.this$0.getContext().getSystemService("input_method");
    if (localObject != null)
    {
      localObject = (InputMethodManager)localObject;
      EditDanmakuDialog.a(this.this$0).requestFocus();
      ((InputMethodManager)localObject).showSoftInput((View)EditDanmakuDialog.a(this.this$0), 0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.EditDanmakuDialog.onAttachedToWindow.1
 * JD-Core Version:    0.7.0.1
 */