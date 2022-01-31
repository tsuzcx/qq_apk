package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.widget.ImageView;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.WeakHashMap;

public class TaskQueue
{
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
  }
  
  public Task a(ImageView paramImageView)
  {
    paramImageView = (Task)this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (paramImageView != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramImageView);
    }
    return paramImageView;
  }
  
  public ListIterator a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet()).listIterator(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
  }
  
  public void a(ImageView paramImageView, Task paramTask)
  {
    Task localTask = (Task)this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, paramTask);
    if (localTask != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localTask);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramTask, new WeakReference(paramImageView));
  }
  
  public void a(Task paramTask)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramTask);
  }
  
  public Task b(ImageView paramImageView)
  {
    return (Task)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.TaskQueue
 * JD-Core Version:    0.7.0.1
 */