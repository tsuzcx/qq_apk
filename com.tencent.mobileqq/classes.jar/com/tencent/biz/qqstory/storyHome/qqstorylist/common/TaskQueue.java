package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.widget.ImageView;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class TaskQueue
{
  private WeakHashMap<ImageView, Task> a = new WeakHashMap();
  private LinkedHashMap<Task, WeakReference<ImageView>> b = new LinkedHashMap(10, 0.75F, true);
  
  public Task a(ImageView paramImageView)
  {
    paramImageView = (Task)this.a.remove(paramImageView);
    if (paramImageView != null) {
      this.b.remove(paramImageView);
    }
    return paramImageView;
  }
  
  public void a()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public void a(ImageView paramImageView, Task paramTask)
  {
    Task localTask = (Task)this.a.put(paramImageView, paramTask);
    if (localTask != null) {
      this.b.remove(localTask);
    }
    this.b.put(paramTask, new WeakReference(paramImageView));
  }
  
  public void a(Task paramTask)
  {
    this.b.remove(paramTask);
  }
  
  public Task b(ImageView paramImageView)
  {
    return (Task)this.a.get(paramImageView);
  }
  
  public ListIterator<Map.Entry<Task, WeakReference<ImageView>>> b()
  {
    return new ArrayList(this.b.entrySet()).listIterator(this.b.size());
  }
  
  public int c()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.TaskQueue
 * JD-Core Version:    0.7.0.1
 */