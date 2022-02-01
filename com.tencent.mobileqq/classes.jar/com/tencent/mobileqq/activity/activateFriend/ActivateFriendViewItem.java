package com.tencent.mobileqq.activity.activateFriend;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivateFriendViewItem
  extends RelativeLayout
{
  int a;
  ImageView b;
  ImageView c;
  TextView d;
  TextView e;
  boolean f = true;
  
  public ActivateFriendViewItem(Context paramContext)
  {
    this(paramContext, true, true);
  }
  
  public ActivateFriendViewItem(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    a(paramContext, paramBoolean1, paramBoolean2);
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    LayoutInflater.from(paramContext).inflate(2131627248, this, true);
    this.b = ((ImageView)findViewById(2131435219));
    this.c = ((ImageView)findViewById(2131440198));
    this.d = ((TextView)findViewById(2131439121));
    this.e = ((TextView)findViewById(2131429539));
    if (!paramBoolean2)
    {
      this.d.setHorizontallyScrolling(false);
      this.e.setHorizontallyScrolling(false);
    }
    if (!paramBoolean1)
    {
      paramContext = findViewById(2131434929).getBackground();
      if ((paramContext != null) && ((paramContext instanceof GradientDrawable))) {
        ((GradientDrawable)paramContext).setColor(-1);
      }
      this.d.setTextColor(-16777216);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    ImageView localImageView = this.c;
    if ((localImageView != null) && (localImageView.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.f);
    }
  }
  
  public void setBirthday(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    this.e.setText(paramString);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.f) {
      this.c.setImageResource(2130846159);
    } else {
      this.c.setImageResource(2130846161);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.d.getText());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.e.getVisibility() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.e.getText());
      localObject = ((StringBuilder)localObject).toString();
    }
    setContentDescription((CharSequence)localObject);
  }
  
  public void setHead(Bitmap paramBitmap)
  {
    this.b.setImageBitmap(paramBitmap);
  }
  
  public void setIndex(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setNickName(String paramString)
  {
    this.d.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem
 * JD-Core Version:    0.7.0.1
 */