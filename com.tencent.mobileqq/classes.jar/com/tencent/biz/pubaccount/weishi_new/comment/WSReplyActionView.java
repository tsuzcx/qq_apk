package com.tencent.biz.pubaccount.weishi_new.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class WSReplyActionView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  
  public WSReplyActionView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public WSReplyActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSReplyActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131560042, this, true);
    this.a = ((TextView)((View)localObject).findViewById(2131371579));
    this.b = ((TextView)((View)localObject).findViewById(2131370048));
    int i = AIOUtils.dp2px(12.0F, getContext().getResources());
    localObject = getResources().getDrawable(2130850948);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    this.a.setCompoundDrawables(null, null, (Drawable)localObject, null);
    localObject = getResources().getDrawable(2130850949);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    this.b.setCompoundDrawables(null, null, (Drawable)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSReplyActionView
 * JD-Core Version:    0.7.0.1
 */