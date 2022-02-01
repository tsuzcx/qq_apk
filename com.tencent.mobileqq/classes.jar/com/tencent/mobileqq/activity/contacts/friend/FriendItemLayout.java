package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;

public class FriendItemLayout
  extends FrameLayout
{
  private static int b;
  private static Map<CharSequence, Integer> c = new HashMap(5);
  private BuddyListFriends.BuddyChildTag a;
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    int j = ((FrameLayout.LayoutParams)this.a.d.getLayoutParams()).leftMargin;
    int i = j;
    Object localObject;
    if (this.a.d.getVisibility() != 8)
    {
      localObject = this.a.d.getText();
      if (c.containsKey(localObject))
      {
        i = ((Integer)c.get(localObject)).intValue();
      }
      else
      {
        i = (int)this.a.d.getTextPaint().measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
        c.put(localObject, Integer.valueOf(i));
      }
      this.a.d.setFixedWidth(i);
      i = j + (i + b);
    }
    j = i;
    if (this.a.o != null)
    {
      j = i;
      if (this.a.o.getVisibility() != 8)
      {
        localObject = this.a.o.getDescText();
        if (c.containsKey(localObject))
        {
          j = ((Integer)c.get(localObject)).intValue();
        }
        else
        {
          j = this.a.o.getMeasureLength();
          c.put(localObject, Integer.valueOf(j));
        }
        j = i + (j + b);
      }
    }
    i = j;
    if (this.a.e.getVisibility() != 8)
    {
      localObject = (FrameLayout.LayoutParams)this.a.e.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = j;
      i = j + (((FrameLayout.LayoutParams)localObject).width + b);
    }
    j = i;
    if (this.a.f.getVisibility() != 8)
    {
      localObject = (FrameLayout.LayoutParams)this.a.f.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = i;
      j = i + (((FrameLayout.LayoutParams)localObject).width + b);
    }
    i = j;
    if (this.a.g.getVisibility() != 8)
    {
      localObject = (FrameLayout.LayoutParams)this.a.g.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = j;
      i = j + (((FrameLayout.LayoutParams)localObject).width + b);
    }
    ((FrameLayout.LayoutParams)this.a.b.getLayoutParams()).leftMargin = i;
    i = getContext().getResources().getDimensionPixelSize(2131297142);
    i = this.a.k.a(this, this.a, i);
    ((FrameLayout.LayoutParams)this.a.i.getLayoutParams()).rightMargin = i;
  }
  
  public BuddyListFriends.BuddyChildTag a()
  {
    this.a = new BuddyListFriends.BuddyChildTag();
    this.a.r = ((ImageView)findViewById(2131435219));
    this.a.a = ((SingleLineTextView)findViewById(2131447063));
    this.a.d = ((SimpleTextView)findViewById(2131448627));
    this.a.e = ((ImageView)findViewById(2131436594));
    this.a.f = ((ImageView)findViewById(2131436520));
    this.a.g = ((URLImageView)findViewById(2131436522));
    this.a.b = ((SingleLineTextView)findViewById(2131447065));
    this.a.h = ((ImageView)findViewById(2131436608));
    this.a.k = ((MutualMarkIconsView)findViewById(2131439085));
    this.a.j = ((URLImageView)findViewById(2131436431));
    this.a.i = ((LinearLayout)findViewById(2131439297));
    this.a.o = ((OnlineStatusView)findViewById(2131432679));
    this.a.b.setExtendTextColor(RichStatus.sActionColor, 1);
    this.a.b.setExtendTextSize(12.0F, 1);
    this.a.b.setGravity(19);
    if (this.a.o != null) {
      this.a.o.setViewStyle(2);
    }
    if (b == 0) {
      b = getContext().getResources().getDimensionPixelSize(2131297150);
    }
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout
 * JD-Core Version:    0.7.0.1
 */