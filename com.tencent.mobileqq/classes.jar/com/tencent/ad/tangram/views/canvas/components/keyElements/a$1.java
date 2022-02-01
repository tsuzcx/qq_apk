package com.tencent.ad.tangram.views.canvas.components.keyElements;

import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.ad.tangram.log.AdLog;

class a$1
  implements ViewTreeObserver.OnPreDrawListener
{
  a$1(a parama) {}
  
  public boolean onPreDraw()
  {
    int i = this.this$0.getLineCount();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPreDraw :line ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" mask:");
    ((StringBuilder)localObject).append(a.access$000(this.this$0));
    AdLog.d("AdAutoLayoutTextView", ((StringBuilder)localObject).toString());
    if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.getText());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("权限详情 | 隐私协议");
      localObject = ((StringBuilder)localObject).toString();
      a.access$100(this.this$0, (CharSequence)localObject);
      return false;
    }
    if (i == 2)
    {
      if (this.this$0.getText().toString().contains("权限详情 | 隐私协议")) {
        return true;
      }
      a.access$002(this.this$0, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.getText());
      ((StringBuilder)localObject).append("权限详情 | 隐私协议");
      localObject = ((StringBuilder)localObject).toString();
      a.access$100(this.this$0, (CharSequence)localObject);
      return false;
    }
    if (i == 3)
    {
      if (a.access$000(this.this$0))
      {
        localObject = this.this$0.getText().toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((String)localObject).substring(0, ((String)localObject).length() - 11 - 3));
        localStringBuilder.append(" | \n");
        localStringBuilder.append("权限详情 | 隐私协议");
        localObject = localStringBuilder.toString();
        a.access$100(this.this$0, (CharSequence)localObject);
        a.access$002(this.this$0, false);
        a.access$202(this.this$0, true);
        return false;
      }
      if (!a.access$200(this.this$0))
      {
        localObject = this.this$0.getText().toString();
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 11 - 3);
        a.access$100(this.this$0, (CharSequence)localObject);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.keyElements.a.1
 * JD-Core Version:    0.7.0.1
 */