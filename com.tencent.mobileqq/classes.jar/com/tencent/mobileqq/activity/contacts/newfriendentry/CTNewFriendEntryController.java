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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131379378));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131371949));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramRelativeLayout.findViewById(2131371842));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramRelativeLayout.findViewById(2131371843));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131371836));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131372096));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramRelativeLayout.findViewById(2131371877));
    this.jdField_c_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramRelativeLayout.findViewById(2131376445));
    a(paramRelativeLayout);
    b();
    if (QLog.isColorLevel())
    {
      paramRelativeLayout = new StringBuilder();
      paramRelativeLayout.append("CTNewFriendEntryController maxDisplayHeadCount = ");
      paramRelativeLayout.append(this.jdField_a_of_type_Int);
      QLog.d("CTNewFriendEntryController", 2, paramRelativeLayout.toString());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class, "");
    StringBuilder localStringBuilder = new StringBuilder(32);
    if (paramInt == 0)
    {
      localObject = ((INewFriendService)localObject).getLastUnreadNewFriendMessage();
      int j = 1;
      int i;
      if ((localObject != null) && (((NewFriendMessage)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if (paramBoolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
        }
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694443));
        localStringBuilder.append(" 有更新");
        i = j;
      }
      else if (((INewFriendVerificationService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendVerificationService.class)).isShowRedPoint())
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("CTNewFriendEntryController", 2, "contacts updateUnreadCount");
          i = j;
        }
      }
      else
      {
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719473));
        i = 0;
      }
      CustomWidgetUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, i, paramInt, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else if (paramInt > 0)
    {
      if (paramBoolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
      }
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694443));
      localStringBuilder.append(" ");
      if (paramInt > 99)
      {
        localStringBuilder.append("多于99条未读");
      }
      else
      {
        localStringBuilder.append(paramInt);
        localStringBuilder.append("条未读");
      }
      CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 3, paramInt, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localStringBuilder.toString());
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramRelativeLayout.findViewById(2131371833));
    int i = ViewUtils.a();
    int j = ViewUtils.b(68.0F);
    int k = ViewUtils.b(48.0F);
    int m = ViewUtils.b(8.0F);
    j = i - j + m;
    i = j / k;
    int n = j % k;
    if (n > m)
    {
      j = i + 1;
      float f = (n - m) * 1.0F / (k - m);
      paramRelativeLayout = new CTNewFriendEntryController.1(this, f);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory(paramRelativeLayout);
      i = j;
      paramRelativeLayout = localPaintDrawable;
      if (QLog.isColorLevel())
      {
        paramRelativeLayout = new StringBuilder();
        paramRelativeLayout.append("initHeadsRecyclerView count = ");
        paramRelativeLayout.append(j);
        paramRelativeLayout.append(", ratio = ");
        paramRelativeLayout.append(f);
        QLog.d("CTNewFriendEntryController", 2, paramRelativeLayout.toString());
        i = j;
        paramRelativeLayout = localPaintDrawable;
      }
    }
    else
    {
      paramRelativeLayout = null;
    }
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
  }
  
  private void a(List<Object> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 0) {
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
      if ((localObject1 instanceof FriendSystemMessage))
      {
        Object localObject2 = (FriendSystemMessage)localObject1;
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(((FriendSystemMessage)localObject2).b());
        localObject1 = ((FriendSystemMessage)localObject2).a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showOneNewFriendUI nickname = ");
          localStringBuilder.append(((FriendSystemMessage)localObject2).b());
          localStringBuilder.append("reqContent = ");
          localStringBuilder.append((String)localObject1);
          QLog.d("CTNewFriendEntryController", 2, localStringBuilder.toString());
        }
        this.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15, 0);
        }
      }
      else if ((localObject1 instanceof PhoneContact))
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramList.subList(0, 1));
    }
  }
  
  private void a(boolean paramBoolean, List<Object> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showMultiNewFriendUI doAnimate = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(",count = ");
        localStringBuilder.append(paramList.size());
        QLog.d("CTNewFriendEntryController", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ViewUtils.b(93.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      if (paramBoolean)
      {
        if (paramList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramList.get(0));
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryNewFriendEntryMultiHeadsAdapter.a(paramList);
      }
    }
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
    int j = this.jdField_b_of_type_Int;
    int i = 1;
    if (j != 1) {
      if (j > 1) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F18", "0X8007F18", 1, 0, String.valueOf(i), "", "", "");
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
    if (paramList != null)
    {
      if (paramList.size() < 0) {
        return;
      }
      int i = paramList.size();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRedDotCount count = ");
        localStringBuilder.append(i);
        localStringBuilder.append(",doAnimate = ");
        localStringBuilder.append(paramBoolean1);
        QLog.d("CTNewFriendEntryController", 2, localStringBuilder.toString());
      }
      if (i == 0)
      {
        b();
      }
      else
      {
        boolean bool = true;
        if (i == 1)
        {
          a(paramList);
        }
        else
        {
          if ((paramBoolean1) && (i - this.jdField_b_of_type_Int == 1)) {
            paramBoolean1 = bool;
          } else {
            paramBoolean1 = false;
          }
          a(paramBoolean1, paramList);
        }
      }
      this.jdField_b_of_type_Int = i;
      a(i, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController
 * JD-Core Version:    0.7.0.1
 */