package com.tencent.biz.pubaccount.weishi_new.image;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;

final class WSPicLoader$2
  implements IPublicAccountImageDownListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = SystemClock.uptimeMillis();
  
  WSPicLoader$2(String paramString, KandianUrlImageView paramKandianUrlImageView, int paramInt) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    WSLog.b("WSPicLoader", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Long > 0L)
    {
      if (paramURL == null) {
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      WSPicLoader.a(paramURL, l1 - l2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.b);
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    paramThrowable = new StringBuilder();
    paramThrowable.append("url = ");
    paramThrowable.append(paramURL);
    paramThrowable.append(", onLoadFailed!!!");
    WSLog.d("WSPicLoader", paramThrowable.toString());
    WsBeaconReportPresenter.a().a(false, false, false, 0L, 0L, 0L, paramURL.toString(), this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_Int < 3)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      WSLog.d("WSPicLoader", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.2
 * JD-Core Version:    0.7.0.1
 */