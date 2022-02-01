package com.tencent.mobileqq.activity.contacts.newfriendentry;

import android.content.res.Resources;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class CTNewFriendEntryController
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NewFriendEntryMultiHeadsAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private SingleLineTextView jdField_c_of_type_ComTencentWidgetSingleLineTextView;
  
  public CTNewFriendEntryController(RelativeLayout paramRelativeLayout, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = paramRelativeLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131380049));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131372364));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramRelativeLayout.findViewById(2131372248));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramRelativeLayout.findViewById(2131372249));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131372242));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131372512));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramRelativeLayout.findViewById(2131372288));
    this.jdField_c_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramRelativeLayout.findViewById(2131376955));
    a(paramRelativeLayout);
    b();
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "CTNewFriendEntryController maxDisplayHeadCount = " + this.jdField_a_of_type_Int);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder(32);
    if (paramInt == 0)
    {
      localObject = ((NewFriendManager)localObject).a();
      if ((localObject != null) && (((NewFriendMessage)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if (paramBoolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
        }
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694478)).append(" 有更新");
        i = 1;
        CustomWidgetUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, i, paramInt, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    while (paramInt <= 0) {
      for (;;)
      {
        int i;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localStringBuilder.toString());
        return;
        if (NewFriendVerificationManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
        {
          int j = 1;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("NewFriendVerification.manager", 2, "contacts updateUnreadCount");
            i = j;
          }
        }
        else
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719749));
          i = 0;
        }
      }
    }
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
    }
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694478)).append(" ");
    if (paramInt > 99) {
      localStringBuilder.append("多于99条未读");
    }
    for (;;)
    {
      CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 3, paramInt, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      localStringBuilder.append(paramInt).append("条未读");
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramRelativeLayout.findViewById(2131372239));
    int j = ViewUtils.a();
    int n = ViewUtils.b(68.0F);
    int k = ViewUtils.b(48.0F);
    int m = ViewUtils.b(8.0F);
    int i = (j - n + m) / k;
    n = (j - n + m) % k;
    PaintDrawable localPaintDrawable;
    if (n > m)
    {
      j = i + 1;
      float f = (n - m) * 1.0F / (k - m);
      paramRelativeLayout = new CTNewFriendEntryController.1(this, f);
      localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory(paramRelativeLayout);
      paramRelativeLayout = localPaintDrawable;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("CTNewFriendEntryController", 2, "initHeadsRecyclerView count = " + j + ", ratio = " + f);
        i = j;
      }
    }
    for (paramRelativeLayout = localPaintDrawable;; paramRelativeLayout = null)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter = new NewFriendEntryMultiHeadsAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramRelativeLayout, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutFrozen(true);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new NewFriendEntryMultiHeadsAdapter.SpacesItemDecoration(ViewUtils.b(8.0F)));
      paramRelativeLayout = new DefaultItemAnimator();
      paramRelativeLayout.setAddDuration(1000L);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(paramRelativeLayout);
      paramRelativeLayout = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      paramRelativeLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramRelativeLayout);
      return;
    }
  }
  
  private void a(List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() < 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ViewUtils.b(93.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
    Object localObject1 = paramList.get(0);
    Object localObject2;
    if ((localObject1 instanceof FriendSystemMessage))
    {
      localObject2 = (FriendSystemMessage)localObject1;
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(((FriendSystemMessage)localObject2).b());
      localObject1 = ((FriendSystemMessage)localObject2).a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
      if (QLog.isColorLevel()) {
        QLog.d("CTNewFriendEntryController", 2, "showOneNewFriendUI nickname = " + ((FriendSystemMessage)localObject2).b() + "reqContent = " + (String)localObject1);
      }
      this.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramList.subList(0, 1));
      return;
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, 0);
      continue;
      if ((localObject1 instanceof PhoneContact))
      {
        localObject1 = (PhoneContact)localObject1;
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
      }
      else if ((localObject1 instanceof ContactMatchMessage))
      {
        localObject1 = (ContactMatchMessage)localObject1;
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(((ContactMatchMessage)localObject1).a.name);
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
      }
    }
  }
  
  private void a(boolean paramBoolean, List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() < 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CTNewFriendEntryController", 2, "showMultiNewFriendUI doAnimate = " + paramBoolean + ",count = " + paramList.size());
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ViewUtils.b(93.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      if (!paramBoolean) {
        break;
      }
    } while (paramList.size() <= 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramList.get(0));
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramList);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ViewUtils.b(56.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
  }
  
  public void a()
  {
    int i;
    if (this.jdField_b_of_type_Int == 1) {
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F18", "0X8007F18", 1, 0, String.valueOf(i), "", "", "");
      return;
      if (this.jdField_b_of_type_Int > 1) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "clearData");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getRecycledViewPool().clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(new ArrayList());
  }
  
  public void a(List<Object> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((paramList == null) || (paramList.size() < 0)) {
      return;
    }
    int i = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "updateRedDotCount count = " + i + ",doAnimate = " + paramBoolean1);
    }
    if (i == 0) {
      b();
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      a(i, paramBoolean2);
      return;
      if (i != 1) {
        break;
      }
      a(paramList);
    }
    if ((paramBoolean1) && (i - this.jdField_b_of_type_Int == 1)) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      a(paramBoolean1, paramList);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController
 * JD-Core Version:    0.7.0.1
 */