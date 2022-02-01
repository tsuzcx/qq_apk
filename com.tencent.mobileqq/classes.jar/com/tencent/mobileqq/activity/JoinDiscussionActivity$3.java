package com.tencent.mobileqq.activity;

import android.text.format.DateFormat;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class JoinDiscussionActivity$3
  implements Runnable
{
  JoinDiscussionActivity$3(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  public void run()
  {
    Object localObject1 = StringUtil.substring(this.this$0.h, 0, 32);
    String str = StringUtil.substring(this.this$0.l, 0, 32);
    if (this.this$0.j != null)
    {
      localObject2 = this.this$0.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format("(%d人)", new Object[] { Integer.valueOf(this.this$0.j.size()) }));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    else
    {
      this.this$0.d.setText((CharSequence)localObject1);
    }
    localObject1 = this.this$0.e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131903833));
    ((StringBuilder)localObject2).append(DateFormat.format("yy-M-d", this.this$0.m));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.3
 * JD-Core Version:    0.7.0.1
 */