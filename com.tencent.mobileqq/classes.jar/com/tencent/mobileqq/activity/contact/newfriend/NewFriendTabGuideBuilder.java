package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class NewFriendTabGuideBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendTabGuideBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendTabGuideBuilder.NewFriendTabInfoHolder)))
    {
      paramView = new NewFriendTabGuideBuilder.NewFriendTabInfoHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561410, null);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      a(localView, ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166) - ViewUtils.a(80.0F));
      paramView.a = ((Button)localView.findViewById(2131368139));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.a.setBackgroundResource(2130839446);
      }
      localObject = (ThemeImageView)localView.findViewById(2131368135);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_SQURE);
      localView.setTag(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
      localObject = paramView;
    }
    for (;;)
    {
      ((NewFriendTabGuideBuilder.NewFriendTabInfoHolder)localObject).a.setOnClickListener(this);
      return localView;
      localObject = (NewFriendTabGuideBuilder.NewFriendTabInfoHolder)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      CTEntryMng localCTEntryMng = (CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG);
      if (localCTEntryMng != null) {
        localCTEntryMng.b(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendTabGuideBuilder
 * JD-Core Version:    0.7.0.1
 */