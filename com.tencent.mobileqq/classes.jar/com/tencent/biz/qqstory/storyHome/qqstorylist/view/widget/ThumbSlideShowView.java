package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class ThumbSlideShowView
  extends ImageSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RoundedTransformation jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
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
  
  @TargetApi(10)
  private Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo._id;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, l, 1, null);
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, l, 3, null);
    }
    localObject = paramContext;
    if (paramContext == null)
    {
      localObject = paramContext;
      if (Build.VERSION.SDK_INT >= 10)
      {
        localObject = paramContext;
        if (TextUtils.isEmpty(paramLocalMediaInfo.path))
        {
          paramContext = new MediaMetadataRetriever();
          paramContext.setDataSource(paramLocalMediaInfo.path);
          localObject = paramContext.getFrameAtTime(0L);
        }
      }
    }
    paramContext = (Context)localObject;
    if (localObject != null) {
      paramContext = ((Bitmap)localObject).copy(Bitmap.Config.RGB_565, true);
    }
    return paramContext;
  }
  
  private void b()
  {
    super.setFactory(this);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2131034165);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2131034167);
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
    if (this.b != null) {
      this.b.removeMessages(2);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return true;
        paramMessage = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[this.jdField_a_of_type_Int];
        if (paramMessage == null) {
          break;
        }
        super.setImageDrawable(paramMessage);
      } while (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length == 1);
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length) {
        this.jdField_a_of_type_Int = 0;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
      return true;
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length) {
        this.jdField_a_of_type_Int = 0;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      return true;
    }
    long l = System.currentTimeMillis();
    int i = 0;
    label146:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramMessage = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramMessage = a(getContext(), paramMessage);
      if (paramMessage == null) {}
      for (;;)
      {
        i += 1;
        break label146;
        Bitmap localBitmap = Bitmap.createBitmap(paramMessage);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        localPaint.setAlpha(100);
        localCanvas.drawRect(0.0F, 0.0F, paramMessage.getWidth(), paramMessage.getHeight(), localPaint);
        localCanvas.save(31);
        localCanvas.restore();
        paramMessage.recycle();
        if (this.jdField_a_of_type_Long > l) {
          break;
        }
        if (localBitmap != null)
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[i] = new BitmapDrawable(getContext().getResources(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation.a(localBitmap));
          localBitmap.recycle();
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    return true;
  }
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return localImageView;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.ThumbSlideShowView
 * JD-Core Version:    0.7.0.1
 */