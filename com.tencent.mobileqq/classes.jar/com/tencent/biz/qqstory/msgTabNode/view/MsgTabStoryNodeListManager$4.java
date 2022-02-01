package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class MsgTabStoryNodeListManager$4
  extends QQStoryObserver
{
  MsgTabStoryNodeListManager$4(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void a()
  {
    SLog.b(MsgTabStoryNodeListManager.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      SLog.e(MsgTabStoryNodeListManager.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    if (localMsgTabStoryManager.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localMsgTabStoryManager.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager$MsgTabShowCounter.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", 5);
    return;
    if (localMsgTabStoryManager.c())
    {
      this.a.g();
      localMsgTabStoryManager.a();
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.4
 * JD-Core Version:    0.7.0.1
 */