package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$fetchGuideBgImg$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnGuideManager$fetchGuideBgImg$1$1
  implements IBitmapCallback
{
  public void a(@Nullable ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(@Nullable ImageRequest paramImageRequest, @Nullable CloseableBitmap paramCloseableBitmap)
  {
    VideoColumnGuideManager localVideoColumnGuideManager = this.a.this$0;
    if (paramCloseableBitmap != null) {}
    for (paramImageRequest = paramCloseableBitmap.a();; paramImageRequest = null)
    {
      VideoColumnGuideManager.a(localVideoColumnGuideManager, paramImageRequest);
      VideoColumnGuideManager.a(this.a.this$0, true);
      paramImageRequest = VideoColumnGuideManager.a(this.a.this$0);
      if (paramImageRequest != null) {
        paramImageRequest.setImageBitmap(VideoColumnGuideManager.a(this.a.this$0));
      }
      VideoColumnGuideManager.b(this.a.this$0);
      return;
    }
  }
  
  public void a(@Nullable ImageRequest paramImageRequest, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fetch guide bg img fail: ");
    if (paramThrowable != null) {}
    for (paramImageRequest = paramThrowable.getMessage();; paramImageRequest = null)
    {
      QLog.e("VideoColumnGuideManager", 1, paramImageRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1.1
 * JD-Core Version:    0.7.0.1
 */