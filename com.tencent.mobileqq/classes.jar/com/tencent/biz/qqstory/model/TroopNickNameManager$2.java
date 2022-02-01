package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.TroopManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class TroopNickNameManager$2
  implements Runnable
{
  TroopNickNameManager$2(TroopNickNameManager paramTroopNickNameManager, String paramString, QQUserUIItem paramQQUserUIItem, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.a.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) != null)
    {
      TroopNickNameManager.TroopNickNameUpdateEvent localTroopNickNameUpdateEvent = new TroopNickNameManager.TroopNickNameUpdateEvent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq);
      localTroopNickNameUpdateEvent.jdField_a_of_type_JavaUtilList = localArrayList;
      localTroopNickNameUpdateEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      StoryDispatcher.a().dispatch(localTroopNickNameUpdateEvent);
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.this$0.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem, this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.2
 * JD-Core Version:    0.7.0.1
 */