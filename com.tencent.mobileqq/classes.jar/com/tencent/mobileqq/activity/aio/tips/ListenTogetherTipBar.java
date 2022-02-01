package com.tencent.mobileqq.activity.aio.tips;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherTipBar
  extends TogetherTipsBar
{
  MusicPanelView a;
  
  public ListenTogetherTipBar(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseChatPie, paramOnClickListener);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(Object... paramVarArgs)
  {
    return super.a(paramVarArgs);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    super.a(paramInt, paramVarArgs);
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.a = new MusicPanelView(this.b.aX());
    this.a.setOnClickListener(this.d);
    this.a.setLayoutParams(paramLayoutParams);
    this.a.setId(d());
    this.a.l = this.d;
    this.a.setVisibility(0);
    this.a.setOnTouchListener(UITools.a);
    this.e.addView(this.a);
  }
  
  public void a(TogetherSession paramTogetherSession, QQAppInterface paramQQAppInterface)
  {
    super.a(paramTogetherSession, paramQQAppInterface);
  }
  
  public int b()
  {
    return 26;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public int d()
  {
    return 2131437326;
  }
  
  public View e()
  {
    return this.a;
  }
  
  protected void f()
  {
    this.c = ((QQBlurView)this.e.findViewById(2131447679));
    h();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
      QLog.d("ListenTogetherTipBar", 2, ((StringBuilder)localObject).toString());
    }
    QLog.d("ListenTogetherTipBar", 1, new Object[] { "stack......\n", Log.getStackTraceString(new Throwable()) });
    if (AIOMusicSkin.a().du_())
    {
      this.c.setVisibility(8);
      return;
    }
    Object localObject = this.e.findViewById(2131439721);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.e.getResources().getColor(2131167964));
      ((View)localObject).setVisibility(0);
      this.c.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
        QLog.d("ListenTogetherTipBar", 2, ((StringBuilder)localObject).toString());
      }
      this.c.c();
      this.c = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.c.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
      QLog.d("ListenTogetherTipBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void g()
  {
    super.g();
    MusicPanelView localMusicPanelView = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ListenTogetherTipBar
 * JD-Core Version:    0.7.0.1
 */