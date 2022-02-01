package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.util.SquareRoundImageUtils.SquareRoundColorDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class AIOStoryVideoBuilder
  extends AbstractChatItemBuilder
{
  public int a;
  public int b = 0;
  public int d = 0;
  public int e;
  public int f = 0;
  
  public AIOStoryVideoBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298205);
    int i = paramContext.getResources().getDimensionPixelSize(2131298206);
    this.f = i;
    this.jdField_e_of_type_Int = i;
    this.d = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296400) * 2);
    this.b = paramContext.getResources().getDimensionPixelSize(2131298204);
  }
  
  private View a(View paramView, AIOStoryVideoBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558795, null);
      paramHolder.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365169);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362493));
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362494));
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131362491));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362492));
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.jdField_a_of_type_Int);
      paramView = new SquareRoundImageUtils.SquareRoundColorDrawable(-1, this.jdField_e_of_type_Int, this.f);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    paramOnLongClickAndTouchListener = (AIOStoryVideoBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramOnLongClickAndTouchListener);
    paramMessageRecord = (String)paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131374110);
    int i;
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (Utils.a(paramLinearLayout.cover, paramMessageRecord))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramViewHolder = null;
    }
    try
    {
      paramMessageRecord = new URL(paramLinearLayout.cover);
    }
    catch (Exception paramMessageRecord)
    {
      label89:
      break label89;
    }
    paramMessageRecord = paramViewHolder;
    if (QLog.isColorLevel())
    {
      QLog.e("ChatItemBuilder", 2, " AIOStoryVideoBuilder:  url has problem");
      paramMessageRecord = paramViewHolder;
    }
    if (paramMessageRecord != null)
    {
      QQStoryCoverImageViewHelper.a(paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetImageView, paramLinearLayout.cover);
      paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.d, this.b);
      paramMessageRecord.setDecodeHandler(URLDrawableDecodeHandler.r);
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131374110, paramLinearLayout.cover);
    }
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(paramLinearLayout.text);
    }
    paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidViewView.setOnClickListener(new AIOStoryVideoBuilder.1(this, paramLinearLayout));
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new AIOStoryVideoBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOStoryVideoBuilder
 * JD-Core Version:    0.7.0.1
 */