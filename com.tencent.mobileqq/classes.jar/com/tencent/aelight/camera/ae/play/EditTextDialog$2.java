package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.ttpic.baseutils.string.StringUtils;

class EditTextDialog$2
  implements View.OnClickListener
{
  EditTextDialog$2(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    if (EditTextDialog.access$300(this.this$0).getText().length() > EditTextDialog.access$000(this.this$0))
    {
      QQToast.makeText(this.this$0.getContext(), this.this$0.getContext().getString(2064187593, new Object[] { Integer.valueOf(EditTextDialog.access$000(this.this$0)) }), 1).show();
      return;
    }
    if (EditTextDialog.access$400(this.this$0) != null) {
      localObject = null;
    }
    try
    {
      paramView = EditTextDialog.access$300(this.this$0).getText().toString();
      localObject = paramView;
    }
    catch (IndexOutOfBoundsException paramView)
    {
      label98:
      break label98;
    }
    paramView = (View)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = StringUtils.removeUTF8Emoji((String)localObject);
    }
    Object localObject = paramView;
    if (!TextUtils.isEmpty(paramView)) {
      localObject = paramView.replaceAll("\\r|\\n", "");
    }
    paramView = (View)localObject;
    if (localObject != null) {
      paramView = ((String)localObject).trim();
    }
    EditTextDialog.access$400(this.this$0).onConfirmClick(paramView);
    this.this$0.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.EditTextDialog.2
 * JD-Core Version:    0.7.0.1
 */