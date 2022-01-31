package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import bdbk;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import ndd;
import trz;
import ttl;

public class QCircleSharePart$4
  implements Runnable
{
  public QCircleSharePart$4(ttl paramttl, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (ttl.a(this.this$0) == null) {
          return;
        }
        if (ttl.a(this.this$0).jdField_a_of_type_Int != 1) {
          continue;
        }
        localObject1 = bdbk.a(((BaseActivity)this.this$0.a()).app, 1, 1, ttl.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get());
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((bdbk)localObject1).a();
      }
      catch (Exception localException)
      {
        int i;
        int j;
        double d;
        Bitmap localBitmap;
        QLog.e("QCircleSharePart", 1, "shareToWeChat  Exception : " + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("QCircleSharePart", 1, "shareToWeChat  OutOfMemoryError : " + localOutOfMemoryError.getMessage());
        continue;
        Object localObject3 = localOutOfMemoryError;
        continue;
        Object localObject2 = null;
        continue;
        return;
        continue;
      }
      if (localObject1 != null)
      {
        i = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
        if (i * j <= 8000) {
          continue;
        }
        d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(i * d), (int)(j * d), true);
        localObject3 = localBitmap;
        if (ttl.a(this.this$0).jdField_a_of_type_Int != 1)
        {
          ((Bitmap)localObject1).recycle();
          localObject3 = localBitmap;
        }
        this.jdField_a_of_type_JavaUtilMap.put("image", localObject3);
      }
      if (this.this$0.a() == null) {
        continue;
      }
      this.this$0.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      return;
      localObject3 = ndd.a(BaseApplicationImpl.getContext(), ttl.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.cover.picUrl.get(), "GET", null, null);
      if (localObject3 != null) {
        localObject1 = BitmapFactory.decodeByteArray((byte[])localObject3, 0, localObject3.length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePart.4
 * JD-Core Version:    0.7.0.1
 */