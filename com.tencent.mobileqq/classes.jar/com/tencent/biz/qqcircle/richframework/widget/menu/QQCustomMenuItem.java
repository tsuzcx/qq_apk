package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.MenuItemStyle;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.QQDefaultMenuItemStyle;

public class QQCustomMenuItem
{
  protected int a;
  protected String b;
  protected Drawable c;
  private MenuItemStyle d;
  
  public QQCustomMenuItem(int paramInt, String paramString, Drawable paramDrawable)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramDrawable;
    this.d = new QQDefaultMenuItemStyle();
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(MenuItemStyle paramMenuItemStyle)
  {
    this.d = paramMenuItemStyle;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public MenuItemStyle c()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQCustomMenuItem{title='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuItem
 * JD-Core Version:    0.7.0.1
 */