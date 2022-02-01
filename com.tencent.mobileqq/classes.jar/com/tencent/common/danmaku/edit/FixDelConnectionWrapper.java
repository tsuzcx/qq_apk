package com.tencent.common.danmaku.edit;

import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/FixDelConnectionWrapper;", "Landroid/view/inputmethod/InputConnectionWrapper;", "connection", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "(Landroid/view/inputmethod/InputConnection;Z)V", "deleteSurroundingText", "beforeLength", "", "afterLength", "Companion", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public class FixDelConnectionWrapper
  extends InputConnectionWrapper
{
  public static final FixDelConnectionWrapper.Companion a = new FixDelConnectionWrapper.Companion(null);
  
  public FixDelConnectionWrapper(@NotNull InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteSurroundingText=>beforeLength: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", afterLength: ");
    localStringBuilder.append(paramInt2);
    Log.d("FixDelConnection", localStringBuilder.toString());
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      sendKeyEvent(new KeyEvent(0, 67));
      return false;
    }
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.FixDelConnectionWrapper
 * JD-Core Version:    0.7.0.1
 */