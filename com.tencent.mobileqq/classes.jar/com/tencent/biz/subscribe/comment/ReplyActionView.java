package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ReplyActionView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  
  public ReplyActionView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ReplyActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131558734, this, true);
    this.a = ((TextView)((View)localObject).findViewById(2131371510));
    this.b = ((TextView)((View)localObject).findViewById(2131369989));
    int i = AIOUtils.b(12.0F, getContext().getResources());
    localObject = getResources().getDrawable(2130851303);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    this.a.setCompoundDrawables(null, null, (Drawable)localObject, null);
    localObject = getResources().getDrawable(2130851304);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    this.b.setCompoundDrawables(null, null, (Drawable)localObject, null);
  }
  
  public TextView a()
  {
    return this.a;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyActionView
 * JD-Core Version:    0.7.0.1
 */