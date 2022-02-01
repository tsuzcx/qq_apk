package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendFillAcademicInfoBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendFillAcademicInfoBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendFillAcademicInfoBuilder", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder paramNewFriendFillAcademicInfoHolder)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839445);
      paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramNewFriendFillAcademicInfoHolder.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839446);
    paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramNewFriendFillAcademicInfoHolder.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)))
    {
      paramView = new NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561661, null);
      a((View)localObject, ViewUtils.a(78.0F));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369584));
      paramView.b = ((TextView)((View)localObject).findViewById(2131380359));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380651));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131363938));
      a(paramView);
      ((View)localObject).setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((View)localObject).setTag(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 1, 0, "", "", "", "");
      return localObject;
    }
    Object localObject = (NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)paramView.getTag();
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 1, 0, "", "", "", "");
    Intent localIntent = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 231);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendFillAcademicInfoBuilder
 * JD-Core Version:    0.7.0.1
 */