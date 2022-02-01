package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

@SuppressLint({"ViewConstructor"})
public class ContactListView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener, DecodeTaskCompletionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131702658);
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  ContactListView.ContactGroupAdapter jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactGroupAdapter;
  private ContactListView.ContactListObserver jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver;
  ContactListView.UiHandler jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$UiHandler;
  ContactBindedAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  public ForwardBaseOption a;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new ContactListView.1(this);
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = new ContactListView.5(this);
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  List<List<PhoneContact>> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  List<PhoneContact> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private List<String> jdField_c_of_type_JavaUtilList;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2131559542);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "ContactListView()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$UiHandler = new ContactListView.UiHandler(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131365114));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368760));
  }
  
  private View a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "generateMergeContactsView()");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800670F", "0X800670F", 0, 0, "", "", "", "");
    if (this.e == null) {
      this.e = LayoutInflater.from(getContext()).inflate(2131562898, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    }
    this.e.findViewById(2131378733).setOnClickListener(new ContactListView.3(this));
    this.e.findViewById(2131378739).setOnClickListener(new ContactListView.4(this));
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)this.e.findViewById(2131378742)).setText(paramString);
    }
    return this.e;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    paramView = (ContactListView.Holder)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i = paramView.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i == 2) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
    if (i == 2)
    {
      paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).e(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ((Friends)localObject1).getFriendNickWithAlias());
          if ((CrmUtils.a(((Friends)localObject1).cSpecialFlag)) || (QidianManager.b(((Friends)localObject1).cSpecialFlag))) {
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
      return;
    }
    if (i == 3)
    {
      paramView = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramView.nationCode);
      ((StringBuilder)localObject2).append(paramView.mobileNo);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("entrance", 3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((PhoneContact)localObject1).nationCode);
      localStringBuilder.append(((PhoneContact)localObject1).mobileCode);
      paramView.putExtra("uin", localStringBuilder.toString());
      paramView.putExtra("phonenum", (String)localObject2);
      paramView.putExtra("uintype", 1006);
      paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((PhoneContact)localObject1).nationCode);
      ((StringBuilder)localObject2).append(((PhoneContact)localObject1).mobileCode);
      localObject2 = new AllInOne(((StringBuilder)localObject2).toString(), 31);
      ((AllInOne)localObject2).contactArray = new ArrayList();
      ((AllInOne)localObject2).nickname = ((PhoneContact)localObject1).nickName;
      ((AllInOne)localObject2).contactName = ((PhoneContact)localObject1).name;
      ((AllInOne)localObject2).contactArray.add(new ProfileContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
      ((AllInOne)localObject2).chatAbility = ((PhoneContact)localObject1).ability;
      ((AllInOne)localObject2).lastActivity = 3;
      ((AllInOne)localObject2).profileEntryType = 59;
      paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
      a(paramView);
    }
  }
  
  private void a(ContactListView.Holder paramHolder, String paramString, int paramInt)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramHolder.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      int j = paramListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        ContactListView.Holder localHolder = (ContactListView.Holder)paramListView.getChildAt(i).getTag();
        if ((localHolder != null) && (paramString.equals(localHolder.jdField_a_of_type_JavaLangString)))
        {
          localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() tipsType ");
      localStringBuilder.append(paramQQPimTipsInfo.jdField_a_of_type_Int);
      QLog.i("ContactListView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() tipsString ");
      localStringBuilder.append(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      QLog.i("ContactListView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() repeatContactNum ");
      localStringBuilder.append(paramQQPimTipsInfo.jdField_b_of_type_Int);
      QLog.i("ContactListView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() mTextViewQQPimTips ");
      localStringBuilder.append(this.jdField_d_of_type_AndroidWidgetTextView.getClass().hashCode());
      QLog.i("ContactListView", 2, localStringBuilder.toString());
    }
    if (paramQQPimTipsInfo.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    }
    else if ((paramQQPimTipsInfo.jdField_a_of_type_Int == 1) || (paramQQPimTipsInfo.jdField_a_of_type_Int == 2) || (paramQQPimTipsInfo.jdField_a_of_type_Int == 4))
    {
      if (TextUtils.isEmpty(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      } else {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      }
      if (paramQQPimTipsInfo.jdField_a_of_type_Byte > 0) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    if (paramQQPimTipsInfo.jdField_a_of_type_Int == 3)
    {
      a(true, paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    a(false, null);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "initBlueTipsBar()");
    }
    View localView = null;
    if (paramBoolean) {
      localView = a(paramString);
    }
    if (localView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
      paramString = this.jdField_d_of_type_AndroidViewView;
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(paramString);
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_d_of_type_AndroidViewView);
      }
    }
  }
  
  private void b(View paramView)
  {
    Object localObject = (ContactListView.Holder)paramView.getTag();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((ContactListView.Holder)localObject).jdField_a_of_type_Int == 2) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    ReportController.b(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
    paramView = ((ContactListView.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i = ((ContactListView.Holder)localObject).jdField_a_of_type_Int;
    if ((i != 2) && (i == 3)) {
      i = 1006;
    } else {
      i = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramView.nationCode);
    ((StringBuilder)localObject).append(paramView.mobileCode);
    localObject = ((StringBuilder)localObject).toString();
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), i, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, "from_internal");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
  }
  
  private void c(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    Object localObject = ((ContactListView.Holder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    IAddFriendApi localIAddFriendApi = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((PhoneContact)localObject).nationCode);
    localStringBuilder.append(((PhoneContact)localObject).mobileCode);
    localObject = localIAddFriendApi.startAddFriend(localContext, 2, localStringBuilder.toString(), null, 3006, 3, ((PhoneContact)localObject).name, null, null, HardCodeUtil.a(2131702677), null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject);
    if (this.jdField_a_of_type_Int != 3) {
      return;
    }
    paramView = paramView.getTag(2131374201);
    if (paramView != null)
    {
      int i = ((Integer)paramView).intValue();
      if (i < 5)
      {
        paramView = null;
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                if (i != 4) {
                  break label237;
                }
              }
            }
          }
        }
        for (;;)
        {
          paramView = "0X80068BB";
          continue;
          paramView = "0X80068BA";
          continue;
          paramView = "0X80068B9";
          continue;
          paramView = "0X80068B8";
          continue;
          paramView = "0X80068B7";
        }
        label237:
        if (paramView != null) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    Object localObject1 = (ContactListView.Holder)paramView.getTag();
    if (localObject1 != null)
    {
      if (((ContactListView.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null) {
        return;
      }
      PhoneContact localPhoneContact = ((ContactListView.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      int i = ((ContactListView.Holder)localObject1).jdField_a_of_type_Int;
      Object localObject2;
      if (this.jdField_a_of_type_Int == 2)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption;
        if ((i == 2) && (!bool))
        {
          paramView = new Bundle();
          paramView.putString("uin", localPhoneContact.uin);
          paramView.putInt("uintype", 0);
          paramView.putString("uinname", localPhoneContact.name);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtras(paramView);
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), paramView);
        }
        else if (i == 3)
        {
          bool = true;
        }
        if (bool)
        {
          localObject2 = new Bundle();
          localObject1 = localPhoneContact.mobileCode;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramView = localPhoneContact.mobileNo;
          }
          else
          {
            i = ((String)localObject1).indexOf("|");
            paramView = (View)localObject1;
            if (i > -1) {
              paramView = ((String)localObject1).substring(0, i);
            }
          }
          ((Bundle)localObject2).putBoolean("bindContact", TextUtils.isEmpty(localPhoneContact.uin) ^ true);
          ((Bundle)localObject2).putString("uin", paramView);
          ((Bundle)localObject2).putInt("uintype", 1006);
          ((Bundle)localObject2).putString("uinname", localPhoneContact.name);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtras((Bundle)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.h.intValue(), (Bundle)localObject2);
        }
        return;
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (i == 2) {
          paramView = "0";
        } else {
          paramView = "1";
        }
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
        paramView = paramView.getTag(2131374201);
        if (paramView != null)
        {
          int j = ((Integer)paramView).intValue();
          if (j < 5)
          {
            paramView = null;
            if (j != 0) {
              if (j != 1) {
                if (j != 2) {
                  if (j != 3) {
                    if (j != 4) {
                      break label467;
                    }
                  }
                }
              }
            }
            for (;;)
            {
              paramView = "0X80068B6";
              continue;
              paramView = "0X80068B5";
              continue;
              paramView = "0X80068B4";
              continue;
              paramView = "0X80068B3";
              continue;
              paramView = "0X80068B2";
            }
            label467:
            if (paramView != null) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            }
          }
        }
      }
      paramView = getContext();
      localObject1 = new Intent(paramView, QCallDetailActivity.class);
      ((Intent)localObject1).putExtra("contactID", localPhoneContact.contactID);
      if (i != 2)
      {
        if (i != 3)
        {
          ((Intent)localObject1).putExtra("uin", localPhoneContact.mobileNo);
          ((Intent)localObject1).putExtra("uintype", 56938);
          ((Intent)localObject1).putExtra("uinname", localPhoneContact.name);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localPhoneContact.nationCode);
          ((StringBuilder)localObject2).append(localPhoneContact.mobileCode);
          ((Intent)localObject1).putExtra("uin", ((StringBuilder)localObject2).toString());
          ((Intent)localObject1).putExtra("uintype", 1006);
          ((Intent)localObject1).putExtra("uinname", localPhoneContact.name);
        }
      }
      else
      {
        ((Intent)localObject1).putExtra("uin", localPhoneContact.uin);
        ((Intent)localObject1).putExtra("uintype", 0);
        ((Intent)localObject1).putExtra("uinname", localPhoneContact.nickName);
      }
      paramView.startActivity((Intent)localObject1);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Int == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = 0;
    int j = 21001;
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 5))
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption)) {
          i = 32768;
        } else {
          i = 256;
        }
        j = 21006;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        j = 21005;
        i = 256;
      }
    }
    else
    {
      i = 768;
      j = 21004;
    }
    ContactSearchComponentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, 3, i, j);
  }
  
  View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131559543, null);
    ContactListView.Holder localHolder = new ContactListView.Holder(null);
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372961));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372962));
    localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372960));
    localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371708));
    localHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131379130));
    localHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localHolder.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131379129));
    localHolder.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localHolder.jdField_c_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362203));
    localHolder.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    localHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362193));
    localHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131376543);
    if (this.jdField_a_of_type_Int == 3)
    {
      localHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localHolder.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      localHolder.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      localHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    localView.setTag(localHolder);
    return localView;
  }
  
  protected void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStart()");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ContactListView.class, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$UiHandler);
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702674));
    } else if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 5))
    {
      if (this.jdField_a_of_type_Int == 3) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702660));
      }
    }
    else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702676));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver = new ContactListView.ContactListObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    j();
    int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
    if ((this.jdField_a_of_type_Int == 2) && ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      boolean bool;
      if (i != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localTextView.setEnabled(bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onActivityResult() ");
    }
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 2)
      {
        localObject = new Intent(getContext(), BindNumberActivity.class);
        ((Intent)localObject).putExtra("kNeedUnbind", true);
        a((Intent)localObject);
      }
      else if (paramInt2 == 0)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
        if ((i == 1) || (i == 5)) {
          a(new Intent(getContext(), PhoneLaunchActivity.class));
        }
      }
      else if (paramInt2 == 4002)
      {
        f();
      }
      else
      {
        a(new Intent(getContext(), PhoneLaunchActivity.class));
      }
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21005)
      {
        if (paramInt1 != 21006) {
          return;
        }
        SearchUtil.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
        return;
      }
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("contactSearchResultUin");
        paramInt1 = paramIntent.getIntExtra("contactSearchResultUinType", 0);
        String str1 = paramIntent.getStringExtra("contactSearchResultName");
        long l = paramIntent.getLongExtra("contactSearchResultPhoneContactOriginBinder", -1L);
        String str2 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
        String str3 = paramIntent.getStringExtra("contactSearchResultPhoneContactNationCode");
        paramInt2 = paramIntent.getIntExtra("contactSearchResultPhoneContactAbility", -1);
        paramIntent = null;
        if (paramInt1 == 1006)
        {
          if (l == 3L) {
            paramInt1 = 32;
          } else {
            paramInt1 = 31;
          }
          paramIntent = new AllInOne((String)localObject, paramInt1);
          paramIntent.contactArray = new ArrayList();
          paramIntent.contactName = str1;
          paramIntent.contactArray.add(new ProfileContactInfo(str1, str2, str3));
          paramIntent.chatAbility = paramInt2;
          paramIntent.lastActivity = 3;
        }
        else if (paramInt1 == 0)
        {
          paramIntent = new AllInOne((String)localObject, 1);
        }
        ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
      }
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onCreate()");
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
    boolean bool;
    if ((this.jdField_a_of_type_Int == 2) && ((i == 1) || (i == 2) || (i == 6) || (i == 7) || (i == 3)))
    {
      bool = false;
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562770, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidViewView.findViewById(2131363868).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131366333));
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 5))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter = new ContactBindedAdapter(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
    else
    {
      paramIntent = this.jdField_c_of_type_AndroidViewView;
      if (paramIntent != null) {
        paramIntent.setPadding(0, 0, 40, 0);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringArrayExtra("key_reserved_mobile");
      if ((paramIntent != null) && (paramIntent.length > 0)) {
        this.jdField_c_of_type_JavaUtilList = Arrays.asList(paramIntent);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, bool, false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, false, 19);
  }
  
  void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    ContactListView.Holder localHolder = (ContactListView.Holder)paramView.getTag();
    if (paramBoolean) {
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
    } else {
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    }
    localHolder.jdField_a_of_type_JavaLangString = null;
    localHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localHolder.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localHolder.jdField_a_of_type_Int = 1;
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842159);
      paramPhoneContact = ContactUtils.a(paramPhoneContact.name);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContact);
      if (ContactUtils.a(paramPhoneContact)) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131299109));
      } else {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131299110));
      }
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5))
    {
      localHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localHolder.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    localHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localHolder);
    localHolder.jdField_b_of_type_AndroidWidgetButton.setTag(localHolder);
    Object localObject = localHolder.jdField_a_of_type_AndroidWidgetButton;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131702657));
    localStringBuilder.append(paramPhoneContact.name);
    localStringBuilder.append(HardCodeUtil.a(2131702666));
    ((Button)localObject).setContentDescription(localStringBuilder.toString());
    localObject = localHolder.jdField_b_of_type_AndroidWidgetButton;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131702662));
    localStringBuilder.append(paramPhoneContact.name);
    localStringBuilder.append(HardCodeUtil.a(2131702664));
    ((Button)localObject).setContentDescription(localStringBuilder.toString());
    if (!paramPhoneContact.uin.equals("0"))
    {
      localHolder.jdField_a_of_type_Int = 2;
      a(localHolder, paramPhoneContact.uin, 1);
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      localHolder.jdField_a_of_type_Int = 3;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramPhoneContact.nationCode);
      ((StringBuilder)localObject).append(paramPhoneContact.mobileCode);
      a(localHolder, ((StringBuilder)localObject).toString(), 11);
      if (this.jdField_a_of_type_Int == 5)
      {
        if (paramPhoneContact.isHiden)
        {
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (AppSetting.d)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramPhoneContact.name);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131702679));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          if (AppSetting.d)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramPhoneContact.name);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131702665));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
      }
      else {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (localHolder.jdField_a_of_type_Int != 2) {
      localHolder.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onResume()");
    }
    super.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState() != 9)
    {
      if (NetworkUtil.isNetSupport(getContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.isAutoUploadContacts())
        {
          a(2131718766, 0L, false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, true, 20);
        h();
        return;
      }
      a(2131694475, 3000L);
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStop()");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ContactListView.class);
    i();
    g();
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet != null)
    {
      localActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactListObserver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    super.d();
  }
  
  protected void e()
  {
    QQPimGetTipsInfoIPC.a().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
    if (localObject != null) {
      ((ForwardBaseOption)localObject).z();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(7);
    }
    super.e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 7)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      paramMessage = new ArrayList();
      paramMessage.add(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getContactListForContactListView(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.loadContactFromPhoneWithoutCaches(), true));
      paramMessage.add(new ArrayList());
      this.jdField_a_of_type_JavaUtilList = paramMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$UiHandler.sendEmptyMessage(8);
    }
    return false;
  }
  
  void j()
  {
    int i;
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 5))
    {
      if (this.jdField_a_of_type_Int == 3)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.loadContactFriendList(this.jdField_c_of_type_JavaUtilList);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load contact friend result: ");
          localStringBuilder.append(i);
          QLog.d("ContactListView", 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("the load contact mode is retype=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", state=");
        localStringBuilder.append(i);
        QLog.d("ContactListView", 2, localStringBuilder.toString());
      }
      if ((i != 1) && (i != 2) && (i != 6) && (i != 7) && (i != 3))
      {
        k();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
    }
  }
  
  void k()
  {
    boolean bool;
    if ((this.jdField_a_of_type_Int == 2) && ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((this.jdField_a_of_type_Int != 5) && (!bool))
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getContactListForDisplay();
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getContactListForContactListView(bool));
      localArrayList.add(new ArrayList());
      this.jdField_a_of_type_JavaUtilList = localArrayList;
    }
    l();
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactGroupAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactGroupAdapter = new ContactListView.ContactGroupAdapter(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactGroupAdapter);
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$UiHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(0));
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
    Object localObject3;
    for (Object localObject2 = "*"; localIterator.hasNext(); localObject2 = localObject3)
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      localObject3 = localPhoneContact.pinyinFirst;
      localObject1 = localObject3;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) == null)
      {
        localPhoneContact.pinyinFirst = "#";
        localObject1 = "#";
      }
      localObject3 = localObject2;
      if (!((String)localObject2).equals(localObject1))
      {
        localArrayList.add(null);
        localObject3 = localObject1;
      }
      localArrayList.add(localPhoneContact);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      ((HashMap)localObject2).put(localObject1, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject1)).intValue() + 1));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    for (i = 0; ((Iterator)localObject1).hasNext(); i = j)
    {
      localObject2 = (String)((Iterator)localObject1).next();
      j = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (j != 0) {
        j = j + i + 1;
      } else {
        j = i;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i));
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(1);
      if (((List)localObject1).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_JavaLangString, Integer.valueOf(localArrayList.size()));
        localArrayList.add(null);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PhoneContact)((Iterator)localObject1).next();
          ((PhoneContact)localObject2).pinyinFirst = jdField_a_of_type_JavaLangString;
          localArrayList.add(localObject2);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_Int > 10) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$ContactGroupAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      d(paramView);
      break;
    case 2131379130: 
      a(paramView);
      break;
    case 2131379129: 
      b(paramView);
      break;
    case 2131369233: 
      if (this.jdField_a_of_type_Int == 2)
      {
        f();
      }
      else
      {
        Intent localIntent1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
        Intent localIntent2 = new Intent(getContext(), SettingActivity2.class);
        if (localIntent1.hasExtra("kSrouce")) {
          localIntent2.putExtra("kSrouce", localIntent1.getIntExtra("kSrouce", 6));
        }
        a(localIntent2, 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      }
      break;
    case 2131366333: 
      m();
      break;
    case 2131362203: 
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      a(this.jdField_a_of_type_ComTencentWidgetXListView, paramString, paramBitmap);
    }
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    }
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    localXListView.setSelection(localXListView.getHeaderViewsCount() + ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      paramAbsListView = (ContactListView.Holder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString)))
      {
        int i;
        if (paramAbsListView.jdField_a_of_type_Int == 3) {
          i = 11;
        } else {
          i = 1;
        }
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, paramAbsListView.jdField_a_of_type_JavaLangString);
        if (localBitmap == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramAbsListView.jdField_a_of_type_JavaLangString, i, false);
        } else {
          paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */