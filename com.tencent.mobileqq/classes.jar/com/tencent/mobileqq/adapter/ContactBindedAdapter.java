package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import com.tencent.mobileqq.phonecontact.util.ContactBindUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ContactBindedAdapter
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  public ContactBindedAdapter.SelectedListener a;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PhoneContact jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
  public IndexView a;
  private LinkedHashMap<String, List<PhoneContact>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List<PhoneContact> a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 0;
  private List<PhoneContact> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<PhoneContact> c = new ArrayList();
  
  public ContactBindedAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<PhoneContact> paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = null;
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$SelectedListener = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131298219);
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131298220);
    a(paramList);
  }
  
  private boolean a(PhoneContact paramPhoneContact)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
      if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559309;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[i].equals(paramString)) {
          break label42;
        }
        i += 1;
      }
      i = -1;
      label42:
      if (i >= 0) {
        return this.jdField_a_of_type_ArrayOfInt[i];
      }
    }
    return -1;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((paramInt < arrayOfString.length) && (paramInt >= 0)) {
      ((TextView)paramView).setText(arrayOfString[paramInt]);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
      if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
        break label57;
      }
      i += 1;
    }
    i = -1;
    label57:
    if (paramBoolean)
    {
      if (i == -1)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramPhoneContact);
        notifyDataSetChanged();
      }
    }
    else if (i != -1)
    {
      this.jdField_a_of_type_JavaUtilList.remove(i);
      notifyDataSetChanged();
    }
  }
  
  public void a(ContactBindedData paramContactBindedData)
  {
    this.jdField_b_of_type_JavaUtilList = paramContactBindedData.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramContactBindedData.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContactBindedData.jdField_a_of_type_ArrayOfJavaLangString;
    this.c = paramContactBindedData.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(List<PhoneContact> paramList)
  {
    a(ContactBindUtils.a(paramList, null, true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public int getCount()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new ContactBindedAdapter.ConactBindedHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561026, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371877));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.b = ((TextView)localView.findViewById(2131376487));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377726));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376477));
      paramView.d = ((TextView)localView.findViewById(2131376485));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364609));
      paramView.e = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131374200);
      localView.setBackgroundDrawable(null);
      localView.setTag(paramView);
      if ((paramView.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
    }
    else
    {
      localObject1 = (ContactBindedAdapter.ConactBindedHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
    if ((localObject1 != null) && (((IndexView)localObject1).getVisibility() == 0)) {
      localView.findViewById(2131376483).setPadding(0, 0, this.jdField_a_of_type_Int, 0);
    } else {
      localView.findViewById(2131376483).setPadding(0, 0, this.jdField_b_of_type_Int, 0);
    }
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject1 = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject1);
      if ((!this.c.isEmpty()) && (!"★".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i])) && (((PhoneContact)localObject1).isNewRecommend))
      {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBg(localView, true);
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(paramView.jdField_a_of_type_AndroidViewView, true);
      }
      else
      {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBg(localView, false);
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(paramView.jdField_a_of_type_AndroidViewView, false);
      }
      StringBuilder localStringBuilder = new StringBuilder(256);
      if (!TextUtils.isEmpty(((PhoneContact)localObject1).name))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        if (AppSetting.d)
        {
          AccessibilityUtil.a(paramView.jdField_a_of_type_AndroidWidgetTextView, false);
          localStringBuilder.append(((PhoneContact)localObject1).name);
        }
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramView.b.setVisibility(8);
      if (((PhoneContact)localObject1).samFriend > 0)
      {
        paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject2 = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691093), new Object[] { Integer.valueOf(((PhoneContact)localObject1).samFriend) });
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        paramView.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (AppSetting.d)
        {
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject2);
        }
      }
      else
      {
        paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((!TextUtils.isEmpty(((PhoneContact)localObject1).uin)) && (!((PhoneContact)localObject1).uin.equals("0")))
      {
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView.d.setVisibility(0);
        paramView.d.setText(HardCodeUtil.a(2131702636));
        if (this.jdField_a_of_type_Boolean)
        {
          paramView.jdField_a_of_type_AndroidViewView.setEnabled(false);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (AppSetting.d) {
          paramView.d.setContentDescription(HardCodeUtil.a(2131702631));
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((PhoneContact)localObject1).unifiedCode, true))
      {
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView.d.setVisibility(0);
        paramView.d.setText(HardCodeUtil.a(2131702634));
        if (this.jdField_a_of_type_Boolean)
        {
          paramView.jdField_a_of_type_AndroidViewView.setEnabled(false);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (AppSetting.d) {
          paramView.d.setContentDescription(HardCodeUtil.a(2131702640));
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((PhoneContact)localObject1));
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramView);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
          paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
          paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          if (AppSetting.d) {
            paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
          }
        }
        paramView.jdField_a_of_type_AndroidViewView.setEnabled(true);
        paramView.d.setVisibility(8);
      }
      Object localObject2 = paramView.jdField_a_of_type_AndroidWidgetCheckBox;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((CheckBox)localObject2).setVisibility(i);
      if (AppSetting.d) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      paramView.e.setVisibility(8);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
      paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((PhoneContact)localObject1).unifiedCode, 11, (byte)0));
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidViewView.setTag(paramView);
    }
    else
    {
      paramView.jdField_a_of_type_AndroidViewView.setTag(null);
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.e.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if ((localObject2 instanceof ContactBindedActivity)) {
        ((ContactBindedActivity)localObject2).d();
      }
      int j = paramView.getId();
      int i = 1;
      if (j != 2131374200)
      {
        if (j == 2131376477)
        {
          localObject2 = (PhoneContact)localObject1;
          localObject1 = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
          if (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false))
          {
            j = 3084;
          }
          else
          {
            j = 3006;
            i = 13;
          }
          if (!((IPhoneContactService)localObject1).isBindedIgnoreUpload())
          {
            if (this.c.contains(localObject2)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
            } else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
            j = 3006;
            i = 16;
          }
          else if (this.c.isEmpty())
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          }
          else
          {
            if (this.c.contains(localObject2)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
            } else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          }
          ((PhoneContact)localObject2).isNewRecommend = false;
          localObject1 = this.jdField_a_of_type_AndroidContentContext;
          if ((localObject1 instanceof ContactBindedActivity))
          {
            ContactBindedActivity localContactBindedActivity = (ContactBindedActivity)localObject1;
            if (TextUtils.isEmpty(((PhoneContact)localObject2).pinyinFirst)) {
              localObject1 = "#";
            } else {
              localObject1 = String.valueOf(((PhoneContact)localObject2).pinyinFirst.charAt(0)).toUpperCase();
            }
            localObject1 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              localContactBindedActivity.jdField_a_of_type_Int = ((List)localObject1).indexOf(localObject2);
              if (localContactBindedActivity.jdField_a_of_type_Int != -1) {
                localContactBindedActivity.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject2);
              }
            }
          }
          localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 2, ((PhoneContact)localObject2).unifiedCode, null, j, i, ((PhoneContact)localObject2).name, null, null, HardCodeUtil.a(2131702637), null);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
          notifyDataSetChanged();
        }
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = (ContactBindedAdapter.ConactBindedHolder)localObject1;
        boolean bool = a(((ContactBindedAdapter.ConactBindedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact);
        a(((ContactBindedAdapter.ConactBindedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact, bool ^ true);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$SelectedListener;
        if (localObject2 != null) {
          ((ContactBindedAdapter.SelectedListener)localObject2).a(((ContactBindedAdapter.ConactBindedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact, bool ^ true);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((ContactBindedAdapter.ConactBindedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localObject1 != null)
        {
          ((PhoneContact)localObject1).isNewRecommend = false;
          localObject2 = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) && (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)))
          {
            localObject1 = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin, 30);
            ((AllInOne)localObject1).contactName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
          }
          else if (((IPhoneContactService)localObject2).isBindedIgnoreUpload())
          {
            localObject1 = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 34);
          }
          else
          {
            localObject1 = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 29);
            ((AllInOne)localObject1).subSourceId = 16;
          }
          ((AllInOne)localObject1).nickname = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
          if ((((IPhoneContactService)localObject2).isBindedIgnoreUpload()) && (this.c.isEmpty())) {
            ((AllInOne)localObject1).profileEntryType = 104;
          } else if (this.c.contains(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact)) {
            ((AllInOne)localObject1).profileEntryType = 101;
          } else {
            ((AllInOne)localObject1).profileEntryType = 102;
          }
          ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject1);
        }
        notifyDataSetChanged();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactBindedAdapter
 * JD-Core Version:    0.7.0.1
 */