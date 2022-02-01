package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import aoof;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import nnr;
import vbd;
import vfi;
import vfp;

public class QCircleSharePart$6
  implements Runnable
{
  public QCircleSharePart$6(vfi paramvfi, Map paramMap, Runnable paramRunnable) {}
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(d * j), true);
        if (vfi.a(this.this$0).jdField_a_of_type_Int != 1) {
          paramBitmap.recycle();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put("image", localBitmap);
      if (this.this$0.a() != null) {
        this.this$0.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void run()
  {
    try
    {
      if (vfi.a(this.this$0) == null) {
        return;
      }
      if (vfi.a(this.this$0).jdField_a_of_type_Int == 1)
      {
        QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon");
        aoof localaoof = new aoof(this.this$0.a(), (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
        localBitmap = localaoof.a(1, vfi.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 1, (byte)1);
        if (localBitmap == null)
        {
          QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon(need decode task)");
          localaoof.a(new vfp(this, localaoof));
          localaoof.a(vfi.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 200, false, 1, true, (byte)1, 1);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Bitmap localBitmap;
      QLog.e("QCircleSharePart", 1, "shareToWeChat  Exception : " + localException.getMessage());
      return;
      QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon(have cache)");
      a(localBitmap);
      localException.d();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QCircleSharePart", 1, "shareToWeChat  OutOfMemoryError : " + localOutOfMemoryError.getMessage());
      return;
    }
    QLog.d("QCircleSharePart", 1, "shareToWeChat share url icon");
    byte[] arrayOfByte = nnr.a(BaseApplicationImpl.getContext(), vfi.a(this.this$0).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.cover.picUrl.get(), "GET", null, null);
    if (arrayOfByte != null) {
      a(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePart.6
 * JD-Core Version:    0.7.0.1
 */