package com.tencent.common.danmaku.data;

import android.os.Handler;
import android.view.View;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.ViewDanmakuRender.ViewHolder;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.TouchPoint;

public class ViewDanmaku
  extends R2LDanmaku
{
  private ViewDanmakuRender.ViewHolder x;
  private boolean y = false;
  
  public ViewDanmaku(DanmakuContext paramDanmakuContext)
  {
    super(paramDanmakuContext);
  }
  
  public ViewDanmakuRender.ViewHolder S()
  {
    return this.x;
  }
  
  public boolean T()
  {
    return this.y;
  }
  
  public ClickResult a(TouchPoint paramTouchPoint)
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((ViewDanmakuRender.ViewHolder)localObject).a(paramTouchPoint);
      if (localObject != null) {
        DanmakuDependImp.a().b().c().post(new ViewDanmaku.1(this, (View)localObject));
      }
    }
    return super.a(paramTouchPoint);
  }
  
  public void a(ViewDanmakuRender.ViewHolder paramViewHolder)
  {
    this.x = paramViewHolder;
  }
  
  public void f(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void j()
  {
    super.j();
    this.y = false;
  }
  
  public int q()
  {
    return -2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.data.ViewDanmaku
 * JD-Core Version:    0.7.0.1
 */