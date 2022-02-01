package com.tencent.biz.qqcircle.fragments.chat.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bhtq;
import com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import qqcircle.QQCirclePrivateMsgShow.PMGiftDisplayInfo;
import qqcircle.QQCirclePrivateMsgShow.PMGiftInfo;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;
import uzg;
import vjo;

public class QCircleChatItemView
  extends QCircleBaseWidgetView<QCircleRecentChatListData>
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  private TextView b;
  
  public QCircleChatItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(QCircleRecentChatListData paramQCircleRecentChatListData, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramQCircleRecentChatListData = paramQCircleRecentChatListData.a();
        if ((paramQCircleRecentChatListData != null) && (paramQCircleRecentChatListData.giftInfos.get() != null) && (paramQCircleRecentChatListData.giftInfos.size() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          int i = paramQCircleRecentChatListData.giftInfos.size();
          paramInt = 0;
          if (paramInt < i)
          {
            Object localObject2 = (QQCirclePrivateMsgShow.PMGiftInfo)paramQCircleRecentChatListData.giftInfos.get(paramInt);
            if ((localObject2 == null) || (((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).giftCnt.get() <= 0)) {
              break label259;
            }
            localObject1 = new QCircleChatGiftRecordView(getContext());
            ((QCircleChatGiftRecordView)localObject1).setGiftCount(((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).giftCnt.get());
            ((QCircleChatGiftRecordView)localObject1).setIconUrl(((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).display.icon.get());
            localObject2 = new LinearLayout.LayoutParams(-2, -1);
            ((LinearLayout.LayoutParams)localObject2).gravity = 17;
            if (paramInt == 0)
            {
              ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
              break label259;
            }
            ((LinearLayout.LayoutParams)localObject2).leftMargin = bhtq.b(4.0F);
            continue;
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      catch (Exception paramQCircleRecentChatListData)
      {
        QLog.d("QCircleRecentTempChatItemView", 1, "initGiftLayout error" + paramQCircleRecentChatListData.getMessage());
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
      if (paramQCircleRecentChatListData.certification.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((QCircleAvatarView)localObject1).setIsAuth(bool);
        return;
      }
      label259:
      paramInt += 1;
    }
  }
  
  public int a()
  {
    return 2131560691;
  }
  
  public DragTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  }
  
  public String a()
  {
    return "QCircleRecentTempChatItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369131));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380040));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379962));
      this.b = ((TextView)paramView.findViewById(2131380131));
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379777));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370177));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = uzg.a(getContext());
    }
  }
  
  protected void a(QCircleRecentChatListData paramQCircleRecentChatListData)
  {
    a(paramQCircleRecentChatListData, -1);
  }
  
  public void a(QCircleRecentChatListData paramQCircleRecentChatListData, int paramInt)
  {
    if (paramQCircleRecentChatListData != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQCircleRecentChatListData.mTitleName);
      this.b.setText(paramQCircleRecentChatListData.mShowTime);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQCircleRecentChatListData.getRecentUserUin());
      String str = "";
      if (paramQCircleRecentChatListData.mMsgExtroInfo != null) {
        str = paramQCircleRecentChatListData.mMsgExtroInfo.toString();
      }
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(str, 1);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramQCircleRecentChatListData.mLastMsg);
      if (paramQCircleRecentChatListData.mUnreadNum <= 0) {
        break label128;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText(vjo.a(paramQCircleRecentChatListData.mUnreadNum));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      b(paramQCircleRecentChatListData, paramInt);
      return;
      label128:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
    }
  }
  
  public void setDragFrameLayout(DragFrameLayout paramDragFrameLayout)
  {
    QLog.d("QCircleRecentTempChatItemView", 1, "setDragFrameLayout");
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.item.QCircleChatItemView
 * JD-Core Version:    0.7.0.1
 */