package com.tencent.mobileqq.activity.emogroupstore;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import java.util.Iterator;
import java.util.List;

public class OverlapDrawable
  extends Drawable
{
  private int a;
  private int b;
  private List<Drawable> c;
  private QQAppInterface d;
  
  public OverlapDrawable(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
  }
  
  public void a(List<Drawable> paramList, int paramInt)
  {
    this.c = paramList;
    this.a = paramInt;
    this.b = (paramInt * 2);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      localDrawable = ((VasExtensionManager)this.d.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d.a(localDrawable, this.a);
      if (localDrawable != null)
      {
        int i = this.b;
        localDrawable.setBounds(0, 0, i, i);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(this.a, 0.0F);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.OverlapDrawable
 * JD-Core Version:    0.7.0.1
 */