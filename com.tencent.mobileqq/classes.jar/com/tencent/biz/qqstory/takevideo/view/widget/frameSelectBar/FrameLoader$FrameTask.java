package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import com.tencent.maxvideo.trim.TrimNative;

public class FrameLoader$FrameTask
  extends Task
{
  private long jdField_a_of_type_Long;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private FrameLoader.GetFrameReport jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader$GetFrameReport;
  private Integer jdField_a_of_type_JavaLangInteger;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public FrameLoader$FrameTask(ImageView paramImageView, MediaMetadataRetriever paramMediaMetadataRetriever, Integer paramInteger, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean1, FrameLoader.GetFrameReport paramGetFrameReport, boolean paramBoolean2)
  {
    super(paramImageView);
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
    this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = paramMediaMetadataRetriever;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramInt3;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader$GetFrameReport = paramGetFrameReport;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_JavaLangInteger);
  }
  
  @TargetApi(10)
  public void a()
  {
    SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround:%s", new Object[] { a() });
    long l3 = System.currentTimeMillis();
    if ((UIUtils.a()) && (this.jdField_c_of_type_Boolean))
    {
      SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative:%s", new Object[] { a() });
      try
      {
        Bitmap localBitmap1;
        if (this.jdField_b_of_type_Boolean) {
          localBitmap1 = Bitmap.createBitmap(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
        } else {
          localBitmap1 = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
        }
        this.jdField_a_of_type_JavaLangInteger.intValue();
        int i = this.d;
        long l2 = (this.jdField_a_of_type_JavaLangInteger.intValue() + 1) * this.d;
        l1 = l2;
        if (l2 > this.jdField_a_of_type_Long) {
          l1 = this.jdField_a_of_type_Long;
        }
        if (TrimNative.getThumbnail(0L, l1, localBitmap1) == 0)
        {
          Bitmap localBitmap2 = localBitmap1.copy(Bitmap.Config.RGB_565, true);
          localObject2 = localBitmap2;
          if (this.jdField_b_of_type_Boolean) {
            localObject2 = UIUtils.a(localBitmap2, 90.0F);
          }
          a(new BitmapDrawable((Bitmap)localObject2));
          localBitmap1.recycle();
          l1 = System.currentTimeMillis() - l3;
          SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), a() });
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader$GetFrameReport.a(this.jdField_a_of_type_JavaLangInteger.intValue(), l1);
          return;
        }
        if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
          localBitmap1.recycle();
        } else {
          SLog.e("Q.qqstory.frameWidget.FrameLoader", "TrimNative return error!");
        }
      }
      catch (Exception localException)
      {
        SLog.e("Q.qqstory.frameWidget.FrameLoader", "create bitmap width=%s,height=%s,error:%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), localException });
      }
    }
    Object localObject1 = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
    if (localObject1 == null)
    {
      SLog.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever is null!");
      return;
    }
    localObject1 = ((MediaMetadataRetriever)localObject1).getFrameAtTime(this.jdField_a_of_type_JavaLangInteger.intValue() * this.d * 1000L);
    if (localObject1 == null)
    {
      SLog.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever return null!");
      return;
    }
    Object localObject2 = new Matrix();
    if (this.jdField_b_of_type_Boolean)
    {
      float f1 = this.jdField_b_of_type_Int / ((Bitmap)localObject1).getHeight();
      float f2 = this.jdField_c_of_type_Int / ((Bitmap)localObject1).getWidth();
      ((Matrix)localObject2).postRotate(90.0F);
      ((Matrix)localObject2).postScale(f1, f2);
    }
    else
    {
      ((Matrix)localObject2).postScale(this.jdField_b_of_type_Int / ((Bitmap)localObject1).getWidth(), this.jdField_c_of_type_Int / ((Bitmap)localObject1).getHeight());
    }
    localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, true);
    ((Bitmap)localObject1).recycle();
    a(new BitmapDrawable((Bitmap)localObject2));
    long l1 = System.currentTimeMillis() - l3;
    SLog.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: mRetriever 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), a() });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader$GetFrameReport.a(this.jdField_a_of_type_JavaLangInteger.intValue(), l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameLoader.FrameTask
 * JD-Core Version:    0.7.0.1
 */