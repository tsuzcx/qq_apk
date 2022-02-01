package com.tencent.mobileqq.activity.aio.coreui.input;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunBtnUI
{
  private final PatchedButton a;
  private final AIOContext b;
  
  public FunBtnUI(AIOContext paramAIOContext, PatchedButton paramPatchedButton)
  {
    this.a = paramPatchedButton;
    this.b = paramAIOContext;
  }
  
  public void a()
  {
    this.a.setOnClickListener(new FunBtnUI.1(this));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }
  
  public void b()
  {
    this.a.setOnLongClickListener(new FunBtnUI.2(this));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.a.setContentDescription(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject2 = this.b.p().d().f().a();
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      Editable localEditable = this.b.p().d().f().a();
      Matcher localMatcher = Pattern.compile("[\\n ]+$").matcher(localEditable);
      localObject1 = localObject2;
      if (localMatcher.find()) {
        localObject1 = localEditable.subSequence(0, localMatcher.start());
      }
    }
    if (((CharSequence)localObject1).length() > 0)
    {
      c(true);
      if (QLog.isColorLevel()) {
        QLog.d("AIO:FunBtnUI", 2, "set FunBtn enable because has text");
      }
      return;
    }
    localObject2 = this.b.p().c().e().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (IFunBtnEnabledCheck)((Iterator)localObject2).next();
      if (((IFunBtnEnabledCheck)localObject1).a(this.b))
      {
        c(true);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("set FunBtn enable by:");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("AIO:FunBtnUI", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIO:FunBtnUI", 2, "set FunBtn unable click");
    }
    c(false);
  }
  
  public void c()
  {
    b(false);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.setVisibility(0);
    this.a.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI
 * JD-Core Version:    0.7.0.1
 */