package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.forward.EmotionBatchForwardOption;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class FakeEmotionBuilder
  extends BasePicItemBuilder
{
  public FakeEmotionBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder) {}
  
  protected void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    if (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    BasePicItemBuilder.DrawURL localDrawURL = new BasePicItemBuilder.DrawURL(paramMessageForPic);
    if (paramMessageForPic.path != null) {}
    try
    {
      Object localObject = EmotionBatchForwardOption.a(paramMessageForPic.path);
      if ("MARK_EMOTION:".equals(localObject))
      {
        localObject = paramMessageForPic.path.substring(paramMessageForPic.path.indexOf(":") + 1).split("_&_");
        localDrawURL.a = new URL("emotion_pic", "fromPanel", localObject[0] + "_" + localObject[1]);
      }
      for (;;)
      {
        localObject = localDrawURL.a;
        if ((paramHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localObject)))
        {
          URLDrawable localURLDrawable = a(this.a, paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, localDrawURL);
          paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
          paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = localDrawURL;
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + paramMessageForPic.uniseq + " url=" + localObject);
          }
        }
        paramHolder.jdField_a_of_type_AndroidViewView = paramView;
        return;
        if ("PIC_EMOTION:".equals(localObject)) {
          localDrawURL.a = new URL("protocol_vas_extension_image", "FAVORITE_PANEL_THUMB", paramMessageForPic.path.substring(paramMessageForPic.path.indexOf(":") + 1));
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localDrawURL.a = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return false;
  }
  
  protected void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder) {}
  
  protected void d(MessageForPic paramMessageForPic) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FakeEmotionBuilder
 * JD-Core Version:    0.7.0.1
 */