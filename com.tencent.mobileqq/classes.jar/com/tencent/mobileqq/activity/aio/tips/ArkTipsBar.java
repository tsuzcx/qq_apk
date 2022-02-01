package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ArkTipsBar
  implements TipsBarTask
{
  private Context a;
  private TipsManager b;
  private View c;
  private TextView d;
  private long e = -1L;
  
  public ArkTipsBar(TipsManager paramTipsManager, Context paramContext)
  {
    this.a = paramContext;
    this.b = paramTipsManager;
  }
  
  public int a()
  {
    return 55;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.c == null)
    {
      this.c = LayoutInflater.from(this.a).inflate(2131624076, null);
      this.d = ((TextView)this.c.findViewById(2131428109));
      this.c.setOnClickListener(new ArkTipsBar.1(this));
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[0] instanceof CharSequence)) && ((paramVarArgs[1] instanceof Long)))
    {
      this.d.setText((CharSequence)paramVarArgs[0]);
      this.e = ((Long)paramVarArgs[1]).longValue();
    }
    return this.c;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131428107);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(paramDrawable);
      }
    }
  }
  
  public int b()
  {
    return 16;
  }
  
  public int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ArkTipsBar
 * JD-Core Version:    0.7.0.1
 */