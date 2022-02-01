package com.tencent.mobileqq.activity.shopping;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;

public class ItemCountView
  extends FrameLayout
{
  private URLImageView a;
  private DragTextView b;
  private TextView c;
  
  public ItemCountView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ItemCountView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2131625263, this);
    this.a = ((URLImageView)paramContext.findViewById(2131429397));
    this.b = ((DragTextView)paramContext.findViewById(2131444530));
    this.c = ((TextView)paramContext.findViewById(2131439121));
  }
  
  public void setBg(Drawable paramDrawable)
  {
    URLImageView localURLImageView = this.a;
    if (localURLImageView != null) {
      localURLImageView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setRedCount(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        if (paramInt > 99) {
          localObject = "99+";
        } else {
          localObject = String.valueOf(paramInt);
        }
        this.b.setVisibility(0);
        this.b.setText((CharSequence)localObject);
        return;
      }
      ((DragTextView)localObject).setVisibility(8);
    }
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ItemCountView
 * JD-Core Version:    0.7.0.1
 */