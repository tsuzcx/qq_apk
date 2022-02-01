package com.tencent.mm.plugin.appbrand.phonenumber;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.MMFormInputView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class u$2
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable) {}
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = u.d(this.a);
    if (paramCharSequence != null)
    {
      Object localObject = u.a(this.a);
      if (localObject != null)
      {
        localObject = ((MMFormVerifyCodeInputView)localObject).getText();
        if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
      }
      else
      {
        localObject = u.e(this.a);
        if (localObject == null) {
          break label93;
        }
        localObject = ((MMFormInputView)localObject).getText();
        if ((localObject == null) || (((Editable)localObject).length() != 0)) {
          break label93;
        }
      }
      boolean bool = false;
      break label96;
      label93:
      bool = true;
      label96:
      paramCharSequence.setEnabled(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u.2
 * JD-Core Version:    0.7.0.1
 */