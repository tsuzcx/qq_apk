package com.tencent.av.ui;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.utils.AVUtil;

public class DefaultViewEvent
  implements NormalMenuView.ViewEvent
{
  private String a = null;
  private boolean b = false;
  
  public DefaultViewEvent(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((!this.b) && (!TextUtils.isEmpty(this.a)))
    {
      this.b = true;
      AVUtil.a(this.a, 0);
    }
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).a(paramLong, paramBoolean);
    }
  }
  
  public void b(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.b = false;
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).b(paramLong, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DefaultViewEvent
 * JD-Core Version:    0.7.0.1
 */