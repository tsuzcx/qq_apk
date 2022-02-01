package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.luggage.wxa.pu.b;

public class VerifyCodeEditText
  extends AppCompatEditText
  implements b
{
  public VerifyCodeEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public VerifyCodeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VerifyCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @RequiresApi(api=3)
  public InputConnection f()
  {
    return super.onCreateInputConnection(new EditorInfo());
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.VerifyCodeEditText
 * JD-Core Version:    0.7.0.1
 */