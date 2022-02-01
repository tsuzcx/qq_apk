package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class AssociatedAccountActivity$6$1
  implements Runnable
{
  AssociatedAccountActivity$6$1(AssociatedAccountActivity.6 param6, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!this.c.this$0.isFinishing())
    {
      this.c.this$0.leftView.setText("");
      AssociatedAccountActivity.access$100(this.c.this$0).setText(this.a);
      if (TextUtils.isEmpty(this.a)) {
        AssociatedAccountActivity.access$200(this.c.this$0).setVisibility(8);
      } else {
        AssociatedAccountActivity.access$300(this.c.this$0).setVisibility(0);
      }
      AssociatedAccountActivity.access$400(this.c.this$0).setVisibility(4);
      this.c.this$0.leftView.setContentDescription(this.b);
      this.c.this$0.leftView.bringToFront();
      if ("1103".equals(ThemeUtil.curThemeId))
      {
        ColorStateList localColorStateList = this.c.this$0.getResources().getColorStateList(2131167990);
        AssociatedAccountActivity.access$500(this.c.this$0).setTextColor(localColorStateList);
        AssociatedAccountActivity.access$600(this.c.this$0).setBackgroundResource(2130838369);
        AssociatedAccountActivity.access$700(this.c.this$0).setPadding(ViewUtils.dip2px(8.0F), 0, ViewUtils.dip2px(8.0F), 0);
        Object localObject = AssociatedAccountActivity.access$800(this.c.this$0).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dip2px(24.0F);
        if ((localObject instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(8.0F);
        }
        AssociatedAccountActivity.access$900(this.c.this$0).requestLayout();
        localObject = (GradientDrawable)AssociatedAccountActivity.access$1000(this.c.this$0).getBackground();
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            ((GradientDrawable)localObject).setColor(localColorStateList);
          } else {
            ((GradientDrawable)localObject).setColor(localColorStateList.getDefaultColor());
          }
          ((GradientDrawable)localObject).setAlpha(46);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.6.1
 * JD-Core Version:    0.7.0.1
 */