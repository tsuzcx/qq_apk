package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQCustomMenuList
{
  List<QQCustomMenuItem> a = new ArrayList();
  String b;
  
  public int a()
  {
    return this.a.size();
  }
  
  public QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)this.a.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable)
  {
    paramString = new QQCustomMenuItem(paramInt, paramString, paramDrawable);
    this.a.add(paramString);
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    this.a.add(paramQQCustomMenuItem);
  }
  
  public QQCustomMenuList b()
  {
    QQCustomMenuList localQQCustomMenuList = new QQCustomMenuList();
    localQQCustomMenuList.b = this.b;
    localQQCustomMenuList.a.addAll(this.a);
    return localQQCustomMenuList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQCustomMenuItem localQQCustomMenuItem = (QQCustomMenuItem)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" ");
        localStringBuilder2.append(localQQCustomMenuItem.b);
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuList
 * JD-Core Version:    0.7.0.1
 */