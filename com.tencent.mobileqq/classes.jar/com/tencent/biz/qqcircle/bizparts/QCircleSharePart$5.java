package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import bcxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import ndd;
import tru;
import tsv;

public class QCircleSharePart$5
  implements Runnable
{
  public QCircleSharePart$5(tsv paramtsv, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (tsv.a(this.this$0) == null) {
          return;
        }
        if (tsv.a(this.this$0).jdField_a_of_type_Int != 1) {
          continue;
        }
        localObject1 = bcxb.a(((BaseActivity)this.this$0.a()).app, 1, 1, tsv.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get());
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((bcxb)localObject1).a();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject1;
        int i;
        int j;
        double d;
        Object localObject4;
        continue;
      }
      catch (Exception localException)
      {
        continue;
        localObject3 = localException;
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
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(i * d), (int)(j * d), true);
        localObject3 = localObject4;
        if (tsv.a(this.this$0).jdField_a_of_type_Int != 1)
        {
          ((Bitmap)localObject1).recycle();
          localObject3 = localObject4;
        }
        this.jdField_a_of_type_JavaUtilMap.put("image", localObject3);
      }
      if (this.this$0.a() == null) {
        continue;
      }
      this.this$0.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      return;
      localObject1 = localObject3;
      if (tsv.a(this.this$0).jdField_a_of_type_Int == 0)
      {
        localObject4 = ndd.a(BaseApplicationImpl.getContext(), tsv.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.cover.picUrl.get(), "GET", null, null);
        localObject1 = localObject3;
        if (localObject4 != null) {
          localObject1 = BitmapFactory.decodeByteArray((byte[])localObject4, 0, localObject4.length);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePart.5
 * JD-Core Version:    0.7.0.1
 */