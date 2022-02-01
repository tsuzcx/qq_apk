package com.tencent.biz.qqstory.view.asyncImageLoader;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public abstract class Task
{
  public ImageLoader a;
  public Object b;
  public int c;
  protected WeakReference<ImageView> d;
  public Drawable e;
  public Drawable f;
  protected Task.TaskStateListener g;
  protected volatile boolean h = false;
  
  public Task(ImageView paramImageView)
  {
    this.d = new WeakReference(paramImageView);
  }
  
  public abstract void a();
  
  public void a(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    paramDrawable = this.g;
    if (paramDrawable != null) {
      paramDrawable.a(this);
    }
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    this.e = paramDrawable;
    paramDrawable = this.g;
    if (paramDrawable != null) {
      paramDrawable.a(this, paramString);
    }
  }
  
  public void a(Task.TaskStateListener paramTaskStateListener)
  {
    this.g = paramTaskStateListener;
  }
  
  public void a(WeakHashMap<ImageView, Drawable> paramWeakHashMap, boolean paramBoolean)
  {
    if (this.h) {
      return;
    }
    ImageView localImageView = (ImageView)this.d.get();
    if (localImageView == null) {
      return;
    }
    if (this.e == null) {
      return;
    }
    if ((paramBoolean) && (this.c == 0))
    {
      SLog.a("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.b);
      paramWeakHashMap.put(localImageView, this.e);
      return;
    }
    localImageView.setImageDrawable(this.e);
    paramWeakHashMap = localImageView.getTag(2131436784);
    String str = this.b.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" view hash:");
    localStringBuilder.append(localImageView.hashCode());
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", paramWeakHashMap, " and change to: ", str, localStringBuilder.toString() });
    localImageView.setTag(2131436784, this.b.toString());
  }
  
  public abstract String b();
  
  public void c()
  {
    this.h = true;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131912034), this.b });
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public void e()
  {
    this.e = null;
    this.g = null;
    this.a = null;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131912035), this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.asyncImageLoader.Task
 * JD-Core Version:    0.7.0.1
 */