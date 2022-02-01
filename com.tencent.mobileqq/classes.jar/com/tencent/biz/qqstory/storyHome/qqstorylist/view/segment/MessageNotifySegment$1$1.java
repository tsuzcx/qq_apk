package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import aoot;
import bhmg;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.qphone.base.util.QLog;
import wtt;
import xiz;
import yst;

class MessageNotifySegment$1$1
  implements Runnable
{
  MessageNotifySegment$1$1(MessageNotifySegment.1 param1, String paramString, wtt paramwtt) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = this.jdField_a_of_type_Wtt.b(this.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((QQUserUIItem)localObject).isAvailable()))
      {
        if ((((QQUserUIItem)localObject).isVipButNoFriend()) || ((yst.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0) == 1000000L) && (!TextUtils.isEmpty(yst.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0)))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from UserUIItem");
          }
          localObject = ((QQUserUIItem)localObject).headUrl;
          if (!TextUtils.isEmpty(yst.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0))) {
            localObject = yst.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0);
          }
          xiz.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, true, (int)bhmg.a(yst.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0), 33.0F));
        }
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set friend avatar.");
          }
          QQStoryContext.a();
          localObject = aoot.a(QQStoryContext.a(), 1, Long.toString(yst.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0)), 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        } while (localObject == null);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1.1
 * JD-Core Version:    0.7.0.1
 */