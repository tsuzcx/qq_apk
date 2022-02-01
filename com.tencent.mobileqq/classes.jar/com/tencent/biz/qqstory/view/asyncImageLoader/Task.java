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
  public int a;
  public Drawable a;
  public ImageLoader a;
  protected Task.TaskStateListener a;
  public Object a;
  protected WeakReference<ImageView> a;
  protected volatile boolean a;
  public Drawable b;
  
  public Task(ImageView paramImageView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
  }
  
  public abstract String a();
  
  public abstract void a();
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    paramDrawable = this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener;
    if (paramDrawable != null) {
      paramDrawable.a(this);
    }
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    paramDrawable = this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener;
    if (paramDrawable != null) {
      paramDrawable.a(this, paramString);
    }
  }
  
  public void a(Task.TaskStateListener paramTaskStateListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener = paramTaskStateListener;
  }
  
  public void a(WeakHashMap<ImageView, Drawable> paramWeakHashMap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Int == 0))
    {
      SLog.a("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.jdField_a_of_type_JavaLangObject);
      paramWeakHashMap.put(localImageView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramWeakHashMap = localImageView.getTag(2131369674);
    String str = this.jdField_a_of_type_JavaLangObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" view hash:");
    localStringBuilder.append(localImageView.hashCode());
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", paramWeakHashMap, " and change to: ", str, localStringBuilder.toString() });
    localImageView.setTag(2131369674, this.jdField_a_of_type_JavaLangObject.toString());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131714525), this.jdField_a_of_type_JavaLangObject });
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderImageLoader = null;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131714526), this.jdField_a_of_type_JavaLangObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.asyncImageLoader.Task
 * JD-Core Version:    0.7.0.1
 */