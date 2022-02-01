package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class ThumbSlideShowView
  extends ImageSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RoundedTransformation jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList;
  private BitmapDrawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  private Handler b;
  
  public ThumbSlideShowView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ThumbSlideShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo, int paramInt, BitmapFactory.Options paramOptions)
  {
    
    if (paramContext == null)
    {
      AssertUtils.fail("Need the context to get thumbnail!", new Object[0]);
      return null;
    }
    if ((paramInt != 1) && (paramInt != 3))
    {
      AssertUtils.fail("kind is illegal", new Object[0]);
      return null;
    }
    long l = paramLocalMediaInfo._id;
    Bitmap localBitmap = MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), l, paramInt, paramOptions);
    paramContext = localBitmap;
    if (localBitmap == null) {
      paramContext = BitmapFactory.decodeFile(paramLocalMediaInfo.path, paramOptions);
    }
    return paramContext;
  }
  
  private void b()
  {
    super.setFactory(this);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772065);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772067);
    localAnimation1.setDuration(800L);
    localAnimation2.setDuration(800L);
    super.setInAnimation(localAnimation1);
    super.setOutAnimation(localAnimation2);
    super.setAnimateFirstView(true);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation = new RoundedTransformation(UIUtils.b(getContext(), 8.0F), 0, 1.418182F, null, null);
  }
  
  public void a()
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeMessages(2);
    }
    localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    }
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      a();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable[paramArrayList.size()];
      this.b.sendEmptyMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 0;
    if (j != 1)
    {
      if (j != 2) {
        return true;
      }
      long l = System.currentTimeMillis();
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inMutable = true;
        paramMessage = a(getContext(), paramMessage, 1, (BitmapFactory.Options)localObject);
        if (paramMessage != null)
        {
          localObject = new Canvas(paramMessage);
          Paint localPaint = new Paint();
          localPaint.setColor(-16777216);
          localPaint.setAlpha(100);
          ((Canvas)localObject).drawRect(0.0F, 0.0F, paramMessage.getWidth(), paramMessage.getHeight(), localPaint);
          ((Canvas)localObject).save();
          ((Canvas)localObject).restore();
          if (this.jdField_a_of_type_Long > l) {
            return true;
          }
          if (paramMessage != null)
          {
            this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[i] = new BitmapDrawable(getContext().getResources(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation.a(paramMessage));
            paramMessage.recycle();
          }
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return true;
    }
    paramMessage = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
    i = this.jdField_a_of_type_Int;
    Object localObject = paramMessage[i];
    if (localObject != null)
    {
      super.setImageDrawable((Drawable)localObject);
      paramMessage = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
      if (paramMessage.length == 1) {
        return true;
      }
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= paramMessage.length) {
        this.jdField_a_of_type_Int = 0;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
      return true;
    }
    this.jdField_a_of_type_Int = (i + 1);
    if (this.jdField_a_of_type_Int >= paramMessage.length) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
    return true;
  }
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localImageView;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.ThumbSlideShowView
 * JD-Core Version:    0.7.0.1
 */