package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMedalWallEntryInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView;
import com.tencent.mobileqq.tofumsg.TofuConst;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TofuBaseProfileItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener, View.OnLayoutChangeListener
{
  int a;
  int c = 0;
  int d = 0;
  int e;
  int f = 0;
  int g = 0;
  
  public TofuBaseProfileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.d = AIOUtils.a(16.0F, paramContext.getResources());
    this.jdField_e_of_type_Int = AIOUtils.a(108.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296421) * 2);
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 9);
    }
  }
  
  private View a(View paramView, TofuBaseProfileItemBuilder.Holder paramHolder)
  {
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558936, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365294);
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131371065));
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379432));
      paramHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      paramHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131370383));
      paramHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131370384));
      paramHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131370385));
      paramHolder.c = paramView.findViewById(2131365922);
      localObject1 = paramHolder.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setColorFilter(-7894119, PorterDuff.Mode.SRC_IN);
        }
        i += 1;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView = ((DrawCircleCornerImageView)paramView.findViewById(2131363573));
      paramHolder.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setRadius(this.d);
      paramHolder.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setImageDrawable(new ColorDrawable(-657670));
      paramHolder.jdField_b_of_type_AndroidViewView.setOnTouchListener(UITools.a);
      paramHolder.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.d);
      localObject1 = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject1 = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      ((View)localObject1).setContentDescription(null);
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramHolder.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localObject1;
  }
  
  private void a(TofuBaseProfileItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    paramInt1 -= AIOUtils.a(30.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = AIOUtils.a(54.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramInt1 > 0)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setCircle(paramInt1, paramInt2, this.jdField_e_of_type_Int, -920839);
      paramHolder.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.invalidate();
    }
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int j = 8;
    paramMessageRecord = (MessageForTofuBaseProfile)paramMessageRecord;
    paramViewHolder = (TofuBaseProfileItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramLinearLayout = PLNewsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    paramLinearLayout = paramView.getResources().getString(2131690037, new Object[] { paramLinearLayout });
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
    int i = 0;
    if (i < 3)
    {
      if (paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] != null)
      {
        if (i >= paramMessageRecord.linesCnt) {
          break label152;
        }
        paramLinearLayout = paramMessageRecord.lines[i];
        paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(paramLinearLayout);
        paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        label152:
        paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText("");
        paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      }
    }
    paramLinearLayout = paramViewHolder.c;
    if (paramMessageRecord.linesCnt > 3) {}
    for (i = 0;; i = 8)
    {
      paramLinearLayout.setVisibility(i);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      i = j;
      if (bool) {
        i = 0;
      }
      paramMessageRecord.setVisibility(i);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramViewHolder);
      if (jdField_e_of_type_Boolean)
      {
        paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramViewHolder.jdField_b_of_type_AndroidWidgetTextView).append(paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].getText()).append(paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1].getText()).append(paramViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].getText());
        paramView.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      TofuConst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5D", 0);
      return paramView;
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuBaseProfileItemBuilder.Holder(this);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    TofuBaseProfileItemBuilder.Holder localHolder = (TofuBaseProfileItemBuilder.Holder)paramView.getTag();
    if (localHolder == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new ProfileMedalWallEntryInfo();
      ((ProfileMedalWallEntryInfo)localObject).showMetalWall = true;
      localObject = ProfileCardUtils.getProfileDetailUrl(localHolder.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), "android-8.5.5", null, (ProfileMedalWallEntryInfo)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (QQBrowserActivity.checkNotFrequentlyThenEnter(500L)))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
        localIntent.putExtra("reqType", 1);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TofuBaseProfileItemBuilder", 2, "jump profile detail:" + localHolder.jdField_a_of_type_JavaLangString);
      }
      TofuConst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5E", 0);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getMeasuredWidth();
    paramInt2 = paramView.getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != this.f) && (paramInt2 != this.g))
    {
      paramView = (TofuBaseProfileItemBuilder.Holder)paramView.getTag();
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    a(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuBaseProfileItemBuilder
 * JD-Core Version:    0.7.0.1
 */