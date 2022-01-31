package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import bcxb;
import bdcq;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.qphone.base.util.QLog;
import usd;
import vhj;
import wre;

class MessageNotifySegment$1$1
  implements Runnable
{
  MessageNotifySegment$1$1(MessageNotifySegment.1 param1, String paramString, usd paramusd) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = this.jdField_a_of_type_Usd.b(this.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((QQUserUIItem)localObject).isAvailable()))
      {
        if ((((QQUserUIItem)localObject).isVipButNoFriend()) || ((wre.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0) == 1000000L) && (!TextUtils.isEmpty(wre.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0)))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from UserUIItem");
          }
          localObject = ((QQUserUIItem)localObject).headUrl;
          if (!TextUtils.isEmpty(wre.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0))) {
            localObject = wre.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0);
          }
          vhj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, true, (int)bdcq.a(wre.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0), 33.0F));
        }
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set friend avatar.");
          }
          QQStoryContext.a();
          localObject = bcxb.a(QQStoryContext.a(), 1, Long.toString(wre.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0)), 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        } while (localObject == null);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.this$0.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment$1.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1.1
 * JD-Core Version:    0.7.0.1
 */