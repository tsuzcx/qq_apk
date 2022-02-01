package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class QavListItemBase
  extends LinearLayout
  implements View.OnClickListener
{
  protected int a;
  protected Context b;
  QavListItemBase.IClickCallback c;
  final String d;
  
  public QavListItemBase(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    paramContext = new StringBuilder();
    paramContext.append(getClass().getSimpleName());
    paramContext.append("_");
    paramContext.append(AudioHelper.c());
    this.d = paramContext.toString();
  }
  
  public void a(int paramInt) {}
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public void a(int paramInt, QavListItemBase.IClickCallback paramIClickCallback)
  {
    this.a = paramInt;
    this.c = paramIClickCallback;
  }
  
  public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback);
  
  public void a(QavListItemBase.ItemInfo paramItemInfo, int paramInt) {}
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public int getPosition()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    if (this.c != null)
    {
      long l = AudioHelper.c();
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], mPosition[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.c.a(l, this.a, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public abstract void setHighlight(boolean paramBoolean);
  
  public void setHighlight(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemBase
 * JD-Core Version:    0.7.0.1
 */