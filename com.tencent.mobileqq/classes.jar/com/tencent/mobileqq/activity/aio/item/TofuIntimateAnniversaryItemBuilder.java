package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.tofumsg.TofuConst;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  int b = 0;
  int d = 0;
  
  public TofuIntimateAnniversaryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.d = AIOUtils.b(16.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296400) * 2);
    this.b = ((int)(this.jdField_a_of_type_Int * 0.4531835F));
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 8);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContext.getResources().getStringArray(2130968580);
    this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(2130968579);
  }
  
  private View a(View paramView, TofuIntimateAnniversaryItemBuilder.Holder paramHolder)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558835, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365169);
      paramHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370699);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370044));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370045));
      paramHolder.d = ((TextView)paramView.findViewById(2131370046));
      paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368056));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368072));
      localObject = (ViewGroup.MarginLayoutParams)paramHolder.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.b;
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
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity;
    Object localObject = null;
    if (bool)
    {
      localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null) {
        return null;
      }
      localObject = ((ChatFragment)localObject).a();
    }
    return localObject;
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    } else if ((paramDrawable instanceof GradientDrawable)) {
      ((GradientDrawable)paramDrawable).setColor(paramInt);
    }
    if (paramDrawable != null) {
      paramDrawable.invalidateSelf();
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    paramViewHolder = (TofuIntimateAnniversaryItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mRequestHeight = this.b;
    paramMessageRecord.mRequestWidth = this.jdField_a_of_type_Int;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramViewHolder.d.setTextColor(paramLinearLayout.txtColor);
    a(paramViewHolder.d.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    paramMessageRecord = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((paramMessageRecord != null) && (paramMessageRecord.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0)) {
      paramMessageRecord = this.jdField_a_of_type_ArrayOfJavaLangString[paramLinearLayout.inimateType];
    } else {
      paramMessageRecord = "";
    }
    paramOnLongClickAndTouchListener = paramViewHolder.jdField_c_of_type_AndroidWidgetTextView;
    Context localContext = paramView.getContext();
    int j = 0;
    paramOnLongClickAndTouchListener.setText(localContext.getString(2131689954, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
    paramMessageRecord = Calendar.getInstance();
    paramMessageRecord.setTimeInMillis(paramLinearLayout.bindTime * 1000L);
    paramViewHolder.d.setText(paramView.getContext().getString(2131689955, new Object[] { paramMessageRecord }));
    paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLinearLayout.frdUin));
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
    paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramMessageRecord = paramViewHolder.jdField_c_of_type_AndroidViewView;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    paramMessageRecord.setVisibility(i);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramViewHolder);
    if (e)
    {
      paramMessageRecord = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      paramMessageRecord.append(paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramMessageRecord.append(paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText());
      paramMessageRecord.append(paramViewHolder.d.getText());
      paramView.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
    paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramMessageRecord = this.jdField_a_of_type_ArrayOfInt;
    int i = j;
    if (paramMessageRecord != null)
    {
      i = j;
      if (paramMessageRecord.length > paramLinearLayout.inimateType)
      {
        i = j;
        if (paramLinearLayout.inimateType >= 0) {
          i = this.jdField_a_of_type_ArrayOfInt[paramLinearLayout.inimateType];
        }
      }
    }
    TofuConst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE61", i);
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
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
    if (localHolder != null)
    {
      Object localObject = a();
      if ((localObject != null) && ((localObject instanceof FriendChatPie)) && (((ChatDrawerHelper)((BaseChatPie)localObject).a(124)).a != null)) {
        ((ChatDrawerHelper)((BaseChatPie)localObject).a(124)).a.b(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jumpIntimatePage:");
        ((StringBuilder)localObject).append(localHolder.jdField_a_of_type_JavaLangString);
        QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ArrayOfInt;
      int i;
      if ((localObject != null) && (localObject.length > localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType) && (localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType >= 0)) {
        i = this.jdField_a_of_type_ArrayOfInt[localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType];
      } else {
        i = 0;
      }
      TofuConst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE62", i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuIntimateAnniversaryItemBuilder
 * JD-Core Version:    0.7.0.1
 */