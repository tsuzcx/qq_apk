package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.TofuConst;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class TofuIntimateAnniversaryItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  int[] jdField_a_of_type_ArrayOfInt;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int c = 0;
  int d = 0;
  
  public TofuIntimateAnniversaryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.d = AIOUtils.a(16.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296421) * 2);
    this.c = ((int)(0.4531835F * this.jdField_a_of_type_Int));
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 8);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContext.getResources().getStringArray(2130968581);
    this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(2130968580);
  }
  
  private View a(View paramView, TofuIntimateAnniversaryItemBuilder.Holder paramHolder)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558937, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365294);
      paramHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371065);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370383));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370384));
      paramHolder.d = ((TextView)paramView.findViewById(2131370385));
      paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368304));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368320));
      localObject = (ViewGroup.MarginLayoutParams)paramHolder.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.c;
      paramHolder.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramHolder.jdField_b_of_type_AndroidViewView.setOnTouchListener(UITools.a);
      localObject = paramView;
      if (e)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject = paramView;
      }
    }
    if (e)
    {
      ((View)localObject).setContentDescription(null);
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramHolder.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localObject;
  }
  
  @Nullable
  private BaseChatPie a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment == null) {
        return null;
      }
      return localChatFragment.a();
    }
    return null;
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    }
    for (;;)
    {
      if (paramDrawable != null) {
        paramDrawable.invalidateSelf();
      }
      return;
      if ((paramDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)paramDrawable).setColor(paramInt);
      }
    }
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int j = 0;
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    paramViewHolder = (TofuIntimateAnniversaryItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mRequestHeight = this.c;
    paramMessageRecord.mRequestWidth = this.jdField_a_of_type_Int;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramViewHolder.d.setTextColor(paramLinearLayout.txtColor);
    a(paramViewHolder.d.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0))
    {
      paramMessageRecord = this.jdField_a_of_type_ArrayOfJavaLangString[paramLinearLayout.inimateType];
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramView.getContext().getString(2131690039, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * paramLinearLayout.bindTime);
      paramViewHolder.d.setText(paramView.getContext().getString(2131690040, new Object[] { paramMessageRecord }));
      paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLinearLayout.frdUin));
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramViewHolder.jdField_c_of_type_AndroidViewView;
      if (!bool) {
        break label510;
      }
    }
    label510:
    for (int i = 0;; i = 8)
    {
      paramMessageRecord.setVisibility(i);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramViewHolder);
      if (e)
      {
        paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramViewHolder.d.getText());
        paramView.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      i = j;
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        i = j;
        if (this.jdField_a_of_type_ArrayOfInt.length > paramLinearLayout.inimateType)
        {
          i = j;
          if (paramLinearLayout.inimateType >= 0) {
            i = this.jdField_a_of_type_ArrayOfInt[paramLinearLayout.inimateType];
          }
        }
      }
      TofuConst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE61", i);
      return paramView;
      paramMessageRecord = "";
      break;
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuIntimateAnniversaryItemBuilder.Holder(this);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    TofuIntimateAnniversaryItemBuilder.Holder localHolder = (TofuIntimateAnniversaryItemBuilder.Holder)paramView.getTag();
    if (localHolder == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    BaseChatPie localBaseChatPie = a();
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof FriendChatPie)) && (localBaseChatPie.a != null)) {
      localBaseChatPie.a.b(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "jumpIntimatePage:" + localHolder.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType) && (localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType >= 0)) {}
    for (int i = this.jdField_a_of_type_ArrayOfInt[localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType];; i = 0)
    {
      TofuConst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE62", i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuIntimateAnniversaryItemBuilder
 * JD-Core Version:    0.7.0.1
 */