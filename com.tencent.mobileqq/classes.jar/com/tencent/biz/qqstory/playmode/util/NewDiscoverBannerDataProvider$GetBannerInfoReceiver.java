package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetDiscoverBannerVideoHandler.GetDiscoverBannerVideoEvent;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class NewDiscoverBannerDataProvider$GetBannerInfoReceiver
  extends QQUIEventReceiver
{
  public NewDiscoverBannerDataProvider$GetBannerInfoReceiver(@NonNull NewDiscoverBannerDataProvider paramNewDiscoverBannerDataProvider)
  {
    super(paramNewDiscoverBannerDataProvider);
  }
  
  public void a(@NonNull NewDiscoverBannerDataProvider paramNewDiscoverBannerDataProvider, @NonNull GetDiscoverBannerVideoHandler.GetDiscoverBannerVideoEvent paramGetDiscoverBannerVideoEvent)
  {
    paramNewDiscoverBannerDataProvider.jdField_b_of_type_Boolean = false;
    if ((paramGetDiscoverBannerVideoEvent.errorInfo.isFail()) || (paramGetDiscoverBannerVideoEvent.a == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "banner info back:" + paramGetDiscoverBannerVideoEvent.toString());
    }
    paramNewDiscoverBannerDataProvider.jdField_a_of_type_JavaUtilList.addAll(paramGetDiscoverBannerVideoEvent.a.jdField_b_of_type_JavaUtilList);
    paramNewDiscoverBannerDataProvider.jdField_b_of_type_JavaUtilList.addAll(paramGetDiscoverBannerVideoEvent.a.jdField_a_of_type_JavaUtilList);
    paramNewDiscoverBannerDataProvider.jdField_b_of_type_JavaLangString = paramGetDiscoverBannerVideoEvent.a.jdField_a_of_type_JavaLangString;
    paramNewDiscoverBannerDataProvider.jdField_a_of_type_Boolean = paramGetDiscoverBannerVideoEvent.a.jdField_a_of_type_Boolean;
    paramNewDiscoverBannerDataProvider.jdField_a_of_type_Int = paramGetDiscoverBannerVideoEvent.a.jdField_b_of_type_Int;
    paramNewDiscoverBannerDataProvider.a(paramGetDiscoverBannerVideoEvent.a.jdField_a_of_type_JavaUtilList);
    paramNewDiscoverBannerDataProvider.b(paramGetDiscoverBannerVideoEvent.a.jdField_b_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return GetDiscoverBannerVideoHandler.GetDiscoverBannerVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.NewDiscoverBannerDataProvider.GetBannerInfoReceiver
 * JD-Core Version:    0.7.0.1
 */