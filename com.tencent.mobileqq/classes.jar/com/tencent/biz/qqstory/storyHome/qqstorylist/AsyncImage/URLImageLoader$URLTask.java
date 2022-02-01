package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class URLImageLoader$URLTask
  extends Task
  implements URLDrawable.URLDrawableListener
{
  private URLImageLoader.Config jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  public URLImageLoader$URLTask(ImageView paramImageView, URLImageLoader.Config paramConfig)
  {
    super(paramImageView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config = paramConfig;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "runOnBackGround url= ", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_JavaLangString });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      new URL(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "drawable have urlDrawable cache" });
        onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 3))
      {
        InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "drawable startDownload" });
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
        return;
      }
      InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "drawable restartDownload" });
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { localMalformedURLException.getMessage() });
      Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url is error:");
      localStringBuilder.append(localMalformedURLException);
      a(localDrawable, localStringBuilder.toString());
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "onLoadCanceled url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, "task have been cancel!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "onLoadFialed url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, paramThrowable.getMessage());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "onLoadSuccessed url= ", paramURLDrawable.getURL() });
    if (this.jdField_a_of_type_Boolean)
    {
      super.a(paramURLDrawable);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation != null)
    {
      Bitmap localBitmap = StoryListUtils.a(paramURLDrawable.getCurrDrawable(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.b, UIUtils.a, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageURLImageLoader$Config.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramURLDrawable != null) {
          paramURLDrawable.setTag(2131369673, localBitmap);
        }
        super.a(new BitmapDrawable(localBitmap));
        return;
      }
      super.a(paramURLDrawable, "drawable transform failed!");
      return;
    }
    super.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.URLTask
 * JD-Core Version:    0.7.0.1
 */