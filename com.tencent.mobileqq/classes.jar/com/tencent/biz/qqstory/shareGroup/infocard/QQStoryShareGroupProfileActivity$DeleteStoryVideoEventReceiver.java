package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

class QQStoryShareGroupProfileActivity$DeleteStoryVideoEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, DeleteStoryVideoEvent>
{
  public QQStoryShareGroupProfileActivity$DeleteStoryVideoEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (!paramQQStoryShareGroupProfileActivity.jdField_b_of_type_JavaLangString.equals(paramDeleteStoryVideoEvent.c)) {
      return;
    }
    if ((paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.d)) && (((MemoryManager)SuperManager.a(19)).a(paramDeleteStoryVideoEvent.d).contains(paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString)))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get delete event. groupId=");
        ((StringBuilder)localObject).append(paramQQStoryShareGroupProfileActivity.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", feedId=");
        ((StringBuilder)localObject).append(paramDeleteStoryVideoEvent.d);
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (paramQQStoryShareGroupProfileActivity.a != null)
      {
        localObject = paramQQStoryShareGroupProfileActivity.a;
        int i = ((ShareGroupItem)localObject).videoCount - 1;
        ((ShareGroupItem)localObject).videoCount = i;
        if (i == 0)
        {
          ThreadManager.getUIHandler().postDelayed(new QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver.1(this, paramQQStoryShareGroupProfileActivity), 400L);
          return;
        }
      }
      if (paramQQStoryShareGroupProfileActivity.isResume())
      {
        if (paramDeleteStoryVideoEvent.jdField_b_of_type_Boolean)
        {
          localObject = ((ShareGroupManager)SuperManager.a(7)).a(paramQQStoryShareGroupProfileActivity.jdField_b_of_type_JavaLangString);
          if ((localObject != null) && (((ShareGroupItem)localObject).headerUnionIdList.contains(paramDeleteStoryVideoEvent.jdField_b_of_type_JavaLangString))) {
            QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, true);
          }
        }
        paramQQStoryShareGroupProfileActivity.b(false);
        return;
      }
      if (paramDeleteStoryVideoEvent.jdField_b_of_type_Boolean)
      {
        paramQQStoryShareGroupProfileActivity.jdField_b_of_type_Boolean = true;
        paramQQStoryShareGroupProfileActivity.c = true;
        return;
      }
      paramQQStoryShareGroupProfileActivity.jdField_b_of_type_Boolean = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */