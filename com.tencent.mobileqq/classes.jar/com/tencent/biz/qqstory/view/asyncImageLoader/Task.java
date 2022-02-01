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
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener.a(this);
    }
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener.a(this, paramString);
    }
  }
  
  public void a(Task.TaskStateListener paramTaskStateListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener = paramTaskStateListener;
  }
  
  public void a(WeakHashMap<ImageView, Drawable> paramWeakHashMap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localImageView == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null));
    if ((paramBoolean) && (this.jdField_a_of_type_Int == 0))
    {
      SLog.a("Q.qqstory.newImageLoader", "save to waiting queue t:%s", this.jdField_a_of_type_JavaLangObject);
      paramWeakHashMap.put(localImageView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131369989), " and change to: ", this.jdField_a_of_type_JavaLangObject.toString(), " view hash:" + localImageView.hashCode() });
    localImageView.setTag(2131369989, this.jdField_a_of_type_JavaLangObject.toString());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131714605), this.jdField_a_of_type_JavaLangObject });
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderTask$TaskStateListener = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderImageLoader = null;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131714606), this.jdField_a_of_type_JavaLangObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.asyncImageLoader.Task
 * JD-Core Version:    0.7.0.1
 */