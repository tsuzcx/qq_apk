package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    Object localObject1 = new BasePicItemBuilder.DrawURL(paramMessageForPic);
    if (paramMessageForPic.path != null) {}
    try
    {
      localObject2 = EmotionBatchForwardOption.a(paramMessageForPic.path);
      paramBoolean = "MARK_EMOTION:".equals(localObject2);
      if (paramBoolean)
      {
        localObject2 = paramMessageForPic.path.substring(paramMessageForPic.path.indexOf(":") + 1).split("_&_");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject2[0]);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(localObject2[1]);
        ((BasePicItemBuilder.DrawURL)localObject1).a = new URL("emotion_pic", "fromPanel", ((StringBuilder)localObject3).toString());
      }
      else if ("PIC_EMOTION:".equals(localObject2))
      {
        ((BasePicItemBuilder.DrawURL)localObject1).a = new URL("protocol_vas_extension_image", "FAVORITE_PANEL_THUMB", paramMessageForPic.path.substring(paramMessageForPic.path.indexOf(":") + 1));
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject2;
      Object localObject3;
      label188:
      break label188;
    }
    ((BasePicItemBuilder.DrawURL)localObject1).a = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
    localObject2 = ((BasePicItemBuilder.DrawURL)localObject1).a;
    if ((paramHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localObject2)))
    {
      localObject3 = a(this.a, paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, (BasePicItemBuilder.DrawURL)localObject1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject3);
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = ((BasePicItemBuilder.DrawURL)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("show send pic uniseq=");
        ((StringBuilder)localObject1).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject1).append(" url=");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramHolder.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return false;
  }
  
  protected void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder) {}
  
  protected void d(MessageForPic paramMessageForPic) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FakeEmotionBuilder
 * JD-Core Version:    0.7.0.1
 */