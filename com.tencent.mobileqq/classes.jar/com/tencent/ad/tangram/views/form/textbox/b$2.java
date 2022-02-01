package com.tencent.ad.tangram.views.form.textbox;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.xijing.AdTextData;

class b$2
  implements View.OnFocusChangeListener
{
  b$2(b paramb) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.this$0.getData() != null) && (this.this$0.getData().isValid()))
    {
      if (paramBoolean)
      {
        paramView = new AdFormError(2, -1, this.this$0.getData().title.text);
        paramView.index = b.access$000(this.this$0);
        b.access$100(this.this$0, paramView);
        return;
      }
      b.access$200(this.this$0);
      return;
    }
    AdLog.i("AdFormItemTextBoxView", "onFocusChange error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.textbox.b.2
 * JD-Core Version:    0.7.0.1
 */