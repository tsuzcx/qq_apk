package com.dataline.util;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

public class ItemHolder
  implements Cloneable
{
  public ImageView a;
  public RelativeLayout b;
  public BubbleInfo c;
  private TextView d;
  private TextView e;
  private ProgressBar f;
  private DataLineMsgSet g;
  private Object h;
  private ItemHolder.FileItemHolder i = new ItemHolder.FileItemHolder(this);
  private ItemHolder.ImageItemHolder j = new ItemHolder.ImageItemHolder(this);
  private ItemHolder.TextItemHolder k = new ItemHolder.TextItemHolder(this);
  private ItemHolder.MutiImageItemHolder l = new ItemHolder.MutiImageItemHolder(this);
  private ItemHolder.GrayTipItemHolder m = new ItemHolder.GrayTipItemHolder(this);
  private ItemHolder.TipHolder n = new ItemHolder.TipHolder(this);
  private ItemHolder.NewFileItemHolder o = new ItemHolder.NewFileItemHolder(this);
  
  public DataLineMsgSet a()
  {
    return this.g;
  }
  
  public void a(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  public void a(ProgressBar paramProgressBar)
  {
    this.f = paramProgressBar;
  }
  
  public void a(TextView paramTextView)
  {
    this.d = paramTextView;
  }
  
  public void a(DataLineMsgSet paramDataLineMsgSet)
  {
    this.g = paramDataLineMsgSet;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public Object b()
  {
    return this.h;
  }
  
  public void b(TextView paramTextView)
  {
    this.e = paramTextView;
  }
  
  public ItemHolder.FileItemHolder c()
  {
    return this.i;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ItemHolder clone failed.");
        localStringBuilder.append(localCloneNotSupportedException.toString());
        QLog.w("Dataline.ItemHolder", 4, localStringBuilder.toString());
      }
    }
    return this;
  }
  
  public ItemHolder.ImageItemHolder d()
  {
    return this.j;
  }
  
  public ItemHolder.MutiImageItemHolder e()
  {
    return this.l;
  }
  
  public ItemHolder.TextItemHolder f()
  {
    return this.k;
  }
  
  public ItemHolder.GrayTipItemHolder g()
  {
    return this.m;
  }
  
  public ItemHolder.TipHolder h()
  {
    return this.n;
  }
  
  public ItemHolder.NewFileItemHolder i()
  {
    return this.o;
  }
  
  public TextView j()
  {
    return this.d;
  }
  
  public TextView k()
  {
    return this.e;
  }
  
  public ProgressBar l()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.ItemHolder
 * JD-Core Version:    0.7.0.1
 */