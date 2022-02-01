package com.tencent.biz.qqstory.storyHome;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.WeakReference;
import java.util.List;

class QQStoryBaseActivity$OutOfMemoryHandler
  implements Subscriber
{
  private WeakReference<QQStoryBaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public QQStoryBaseActivity$OutOfMemoryHandler(QQStoryBaseActivity paramQQStoryBaseActivity1, QQStoryBaseActivity paramQQStoryBaseActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQStoryBaseActivity2);
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    paramList.add(QQStoryBaseActivity.OutOfMemHandleCommand.class);
  }
  
  public void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    paramDispatchable = (QQStoryBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramDispatchable != null) {
      paramDispatchable.onOutOfMemory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.OutOfMemoryHandler
 * JD-Core Version:    0.7.0.1
 */