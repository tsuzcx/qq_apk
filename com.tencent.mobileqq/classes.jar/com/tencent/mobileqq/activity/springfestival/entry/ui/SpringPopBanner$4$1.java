package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class SpringPopBanner$4$1
  implements Runnable
{
  SpringPopBanner$4$1(SpringPopBanner.4 param4, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show PopBanner type=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" path=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath);
    QLog.d("shua2021_SpringPopBanner", 2, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(true);
    try
    {
      SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner).addView(SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner));
      SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath);
      localObject = SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath);
      SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner).setBackgroundDrawable(null);
      SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner).setBackgroundDrawable((Drawable)localObject);
      SpringPopBanner.a(SpringPopBanner.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner));
      SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner).setTag(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_JavaLangString);
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(212, localThrowable, new String[0]);
      QLog.d("shua2021_SpringPopBanner", 1, localThrowable.getMessage(), localThrowable);
    }
    SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_JavaLangString, true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("active_id", this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner$4.jdField_a_of_type_JavaLangString);
    SpringHbReporter.a("event_dachaping", 0, 0, localHashMap, "exp", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner.4.1
 * JD-Core Version:    0.7.0.1
 */