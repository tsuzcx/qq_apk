package com.tencent.common.danmaku.edit;

import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.common.danmaku.edit.views.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/FixSharpConnectionWrapper;", "Lcom/tencent/common/danmaku/edit/FixDelConnectionWrapper;", "richEditText", "Lcom/tencent/common/danmaku/edit/views/RichEditText;", "connection", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "(Lcom/tencent/common/danmaku/edit/views/RichEditText;Landroid/view/inputmethod/InputConnection;Z)V", "lastComposingText", "", "getRichEditText", "()Lcom/tencent/common/danmaku/edit/views/RichEditText;", "commitText", "text", "", "newCursorPosition", "", "finishComposingText", "setComposingRegion", "start", "end", "setComposingText", "Companion", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class FixSharpConnectionWrapper
  extends FixDelConnectionWrapper
{
  public static final FixSharpConnectionWrapper.Companion b = new FixSharpConnectionWrapper.Companion(null);
  private String c;
  @NotNull
  private final RichEditText d;
  
  public FixSharpConnectionWrapper(@NotNull RichEditText paramRichEditText, @NotNull InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
    this.d = paramRichEditText;
    this.c = "";
  }
  
  public boolean commitText(@Nullable CharSequence paramCharSequence, int paramInt)
  {
    this.c = "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commitText=>text: ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", newCursorPos: ");
    localStringBuilder.append(paramInt);
    Log.d("FixSharpConnection", localStringBuilder.toString());
    if (((Intrinsics.areEqual(paramCharSequence, "#") ^ true)) && (paramCharSequence != null) && (StringsKt.startsWith$default(paramCharSequence, (CharSequence)"#", false, 2, null) == true)) {
      return super.commitText((CharSequence)paramCharSequence.subSequence(1, paramCharSequence.length()).toString(), paramInt);
    }
    return super.commitText(paramCharSequence, paramInt);
  }
  
  public boolean finishComposingText()
  {
    Log.d("FixSharpConnection", "finishComposingText");
    return super.finishComposingText();
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    int j = this.d.getSelectionEnd();
    int i = 1;
    if (j >= 1)
    {
      if (this.d.getText().toString().charAt(j - 1) != '#') {
        i = 0;
      }
      if (i != 0) {
        return super.setComposingRegion(paramInt2, paramInt2);
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setComposingRegion=>start: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", end: ");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("FixSharpConnection", ((StringBuilder)localObject).toString());
    localObject = this.d.getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "richEditText.text");
    this.c = ((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString();
    return super.setComposingRegion(paramInt1, paramInt2);
  }
  
  public boolean setComposingText(@Nullable CharSequence paramCharSequence, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setComposingText=>text: ");
    ((StringBuilder)localObject).append(paramCharSequence);
    ((StringBuilder)localObject).append(", newCursorPos: ");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("FixSharpConnection", ((StringBuilder)localObject).toString());
    if (Intrinsics.areEqual(paramCharSequence, "#"))
    {
      commitText((CharSequence)"#", paramInt);
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("setComposingText actually=>[] on ");
      paramCharSequence.append(paramInt);
      Log.i("FixSharpConnection", paramCharSequence.toString());
      return super.setComposingText((CharSequence)"", paramInt);
    }
    int j = 1;
    if ((paramCharSequence != null) && (StringsKt.startsWith$default(paramCharSequence, (CharSequence)"#", false, 2, null) == true))
    {
      paramCharSequence = paramCharSequence.subSequence(1, paramCharSequence.length()).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setComposingText actually=>[");
      ((StringBuilder)localObject).append(paramCharSequence);
      ((StringBuilder)localObject).append("] on ");
      ((StringBuilder)localObject).append(paramInt);
      Log.i("FixSharpConnection", ((StringBuilder)localObject).toString());
      return super.setComposingText((CharSequence)paramCharSequence, paramInt);
    }
    if (paramCharSequence != null)
    {
      localObject = paramCharSequence.toString();
      if (localObject != null)
      {
        i = ((String)localObject).length();
        break label238;
      }
    }
    int i = 0;
    label238:
    if (i < this.c.length()) {
      i = j;
    } else {
      i = 0;
    }
    localObject = this.d.getRichSpanOrNullIfBehind();
    if ((i != 0) && (localObject != null))
    {
      boolean bool = super.setComposingText((CharSequence)this.c, paramInt);
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("setComposingText actually=>[");
      paramCharSequence.append(this.c);
      paramCharSequence.append("] on ");
      paramCharSequence.append(paramInt);
      Log.i("FixSharpConnection", paramCharSequence.toString());
      sendKeyEvent(new KeyEvent(0, 67));
      return bool;
    }
    return super.setComposingText(paramCharSequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.FixSharpConnectionWrapper
 * JD-Core Version:    0.7.0.1
 */