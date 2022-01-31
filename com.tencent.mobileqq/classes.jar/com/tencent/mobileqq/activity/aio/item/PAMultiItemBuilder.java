package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;
import vhf;
import vhg;

public class PAMultiItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PAMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vhf(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    int k = (int)(1.0F * BaseChatItemLayout.d);
    ArrayList localArrayList = localPAMessage.items;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    Object localObject1;
    if (localPAMessage.grayTips != null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setText(localPAMessage.grayTips);
      paramViewHolder.setGravity(17);
      paramViewHolder.setSingleLine();
      paramViewHolder.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewHolder.setBackgroundResource(2130842213);
      paramViewHolder.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramViewHolder.setTextColor(-1);
      paramViewHolder.setTextSize(12.0F);
      localViewGroup.addView(paramViewHolder);
    }
    int i = 0;
    label362:
    ImageView localImageView;
    if (i < localArrayList.size())
    {
      localObject1 = new vhg(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((vhg)localObject1).jdField_b_of_type_Int = 5;
      ((vhg)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((vhg)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((vhg)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((vhg)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((vhg)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((vhg)localObject1).d = i;
      Object localObject2;
      int j;
      if (i == 0)
      {
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968757, null);
        localObject2 = (TextView)paramViewHolder.findViewById(2131363599);
        localImageView = (ImageView)paramViewHolder.findViewById(2131363600);
        String str = Util.c(localItem.title);
        ((TextView)localObject2).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label830;
          }
          j = 2130840696;
          label428:
          localObject3 = ((Resources)localObject3).getDrawable(j);
          j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject3).setBounds(j, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
          SpannableString localSpannableString = new SpannableString(str + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject3, 0), str.length(), str.length() + 1, 17);
          ((TextView)localObject2).setText(localSpannableString);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramMessageRecord;
          if (i != 0) {
            continue;
          }
          j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
          int m = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = AIOUtils.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = n;
          localImageView.setImageDrawable(URLDrawable.getDrawable(PubAccountHttpDownloader.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject2));
        }
        catch (Exception localException)
        {
          label830:
          localImageView.setImageResource(2130837617);
          continue;
        }
        localViewGroup.addView(paramViewHolder);
        paramViewHolder.setTag(localObject1);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramViewHolder = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          paramViewHolder.setLayoutParams(new ViewGroup.LayoutParams(-1, k));
          paramViewHolder.setBackgroundResource(2130839704);
          localViewGroup.addView(paramViewHolder);
          paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968755, null);
          break label362;
        }
        paramViewHolder = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setLayoutParams(new ViewGroup.LayoutParams(-1, k));
        paramViewHolder.setBackgroundResource(2130839704);
        localViewGroup.addView(paramViewHolder);
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968756, null);
        break label362;
        j = 2130840697;
        break label428;
        j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = j;
      }
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new vhg(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131375633, this.jdField_a_of_type_AndroidContentContext.getString(2131433652), 2130838314);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */