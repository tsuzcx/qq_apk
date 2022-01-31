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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import yhc;

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
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 0;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private List c = new ArrayList();
  
  public ContactBindedAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131559383);
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131559384);
    a(paramList);
  }
  
  public static ContactBindedAdapter.ContactBindedData a(List paramList, ArrayList paramArrayList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ContactBindedAdapter.ContactBindedData localContactBindedData = new ContactBindedAdapter.ContactBindedData();
    localContactBindedData.jdField_a_of_type_JavaUtilList = ((List)localObject);
    label52:
    label53:
    PhoneContact localPhoneContact;
    if (paramArrayList != null)
    {
      paramList = (List)paramArrayList.clone();
      Iterator localIterator = ((List)localObject).iterator();
      break label193;
      if (!localIterator.hasNext()) {
        break label307;
      }
      localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        break label285;
      }
      paramArrayList = "#";
      label89:
      i = paramArrayList.charAt(0);
      if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
        break label301;
      }
    }
    label285:
    label301:
    for (paramArrayList = paramArrayList.toUpperCase();; paramArrayList = "#")
    {
      if (localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList) == null) {
        localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramArrayList, new ArrayList());
      }
      ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList)).add(localPhoneContact);
      if ((paramList == null) || (!paramBoolean)) {
        break label53;
      }
      paramArrayList = paramList.iterator();
      label193:
      if (!paramArrayList.hasNext()) {
        break label53;
      }
      if (!TextUtils.equals(((PhoneContact)paramArrayList.next()).unifiedCode, localPhoneContact.unifiedCode)) {
        break label52;
      }
      if (localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
        localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
      }
      ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).add(localPhoneContact);
      break label53;
      paramList = null;
      break;
      paramArrayList = String.valueOf(localPhoneContact.pinyinFirst.charAt(0));
      break label89;
    }
    label307:
    if (paramList != null)
    {
      localContactBindedData.jdField_b_of_type_JavaUtilList = paramList;
      if (!paramBoolean)
      {
        if (localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
          localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
        }
        ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap;
    localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (paramArrayList.get(String.valueOf(c1)) != null) {
        localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c1), paramArrayList.get(String.valueOf(c1)));
      }
    }
    if (paramArrayList.get("#") != null) {
      localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", paramList);
    }
    paramArrayList.clear();
    localContactBindedData.jdField_a_of_type_ArrayOfInt = new int[localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    localContactBindedData.jdField_a_of_type_ArrayOfJavaLangString = new String[localContactBindedData.jdField_a_of_type_ArrayOfInt.length];
    paramList = new ArrayList(localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    Collections.sort(paramList, new yhc());
    paramArrayList = paramList.iterator();
    if (localContactBindedData.jdField_a_of_type_ArrayOfInt.length == 0) {
      return localContactBindedData;
    }
    localContactBindedData.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < localContactBindedData.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject = localContactBindedData.jdField_a_of_type_ArrayOfInt;
      int j = localObject[i];
      int k = localContactBindedData.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject[i] = (((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList.next())).size() + k + 1 + j);
      i += 1;
    }
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localContactBindedData.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)paramList.next());
      i += 1;
    }
    return localContactBindedData;
  }
  
  private boolean a(PhoneContact paramPhoneContact)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
        if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b(View paramView, int paramInt)
  {
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingLeft();
    paramView.setBackgroundResource(paramInt);
    paramView.setPadding(m, j, k, i);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2130969056;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length) && (paramInt >= 0)) {
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    }
  }
  
  public void a(ContactBindedAdapter.ContactBindedData paramContactBindedData)
  {
    this.jdField_b_of_type_JavaUtilList = paramContactBindedData.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramContactBindedData.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContactBindedData.jdField_a_of_type_ArrayOfJavaLangString;
    this.c = paramContactBindedData.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      if (paramBoolean) {
        if (i == -1)
        {
          this.jdField_a_of_type_JavaUtilList.add(paramPhoneContact);
          notifyDataSetChanged();
        }
      }
      while (i == -1)
      {
        return;
        i += 1;
        break;
      }
      this.jdField_a_of_type_JavaUtilList.remove(i);
      notifyDataSetChanged();
      return;
      i = -1;
    }
  }
  
  public void a(List paramList)
  {
    a(a(paramList, null, true));
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
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
    label204:
    PhoneContact localPhoneContact;
    label315:
    StringBuilder localStringBuilder;
    label383:
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new ContactBindedAdapter.ConactBindedHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970293, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362894));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366545));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131369982));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369984));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368973));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131368974));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368492));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131363937));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369972);
      paramView.setBackgroundDrawable(null);
      paramView.setTag(paramViewGroup);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0)) {
        break label687;
      }
      paramView.findViewById(2131363923).setPadding(0, 0, this.jdField_a_of_type_Int, 0);
      if (i >= 0) {
        break label970;
      }
      i = -(i + 1) - 1;
      localPhoneContact = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = localPhoneContact;
      if ((this.c.isEmpty()) || ("★".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i])) || (!localPhoneContact.isNewRecommend)) {
        break label707;
      }
      paramView.setBackgroundResource(2130838589);
      b(paramViewGroup.jdField_a_of_type_AndroidViewView, 2130838589);
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(localPhoneContact.name)) {
        break label728;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPhoneContact.name);
      if (AppSetting.b)
      {
        AccessibilityUtil.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, false);
        localStringBuilder.append(localPhoneContact.name);
      }
      if (TextUtils.isEmpty(localPhoneContact.nickName)) {
        break label740;
      }
      paramViewGroup.b.setVisibility(0);
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433312), new Object[] { localPhoneContact.nickName });
      paramViewGroup.b.setText((CharSequence)localObject);
      if (AppSetting.b)
      {
        AccessibilityUtil.a(paramViewGroup.b, false);
        localStringBuilder.append(",").append((String)localObject);
      }
      label469:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((TextUtils.isEmpty(localPhoneContact.uin)) || (localPhoneContact.uin.equals("0"))) {
        break label752;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText("已添加");
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if (AppSetting.b) {
        paramViewGroup.d.setContentDescription("已添加");
      }
      label577:
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox;
      if (!this.jdField_a_of_type_Boolean) {
        break label964;
      }
    }
    label687:
    label707:
    label964:
    for (paramInt = 0;; paramInt = 8)
    {
      ((CheckBox)localObject).setVisibility(paramInt);
      if (AppSetting.b) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_JavaLangString = localPhoneContact.unifiedCode;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localPhoneContact.unifiedCode, 11, (byte)0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
      return paramView;
      paramViewGroup = (ContactBindedAdapter.ConactBindedHolder)paramView.getTag();
      break;
      paramView.findViewById(2131363923).setPadding(0, 0, this.jdField_b_of_type_Int, 0);
      break label204;
      paramView.setBackgroundResource(2130838585);
      b(paramViewGroup.jdField_a_of_type_AndroidViewView, 2130838585);
      break label315;
      label728:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label383;
      label740:
      paramViewGroup.b.setVisibility(8);
      break label469;
      label752:
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localPhoneContact.unifiedCode, true))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText("等待验证");
        if (this.jdField_a_of_type_Boolean)
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (!AppSetting.b) {
          break label577;
        }
        paramViewGroup.d.setContentDescription("等待验证");
        break label577;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a(localPhoneContact));
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(true);
        paramViewGroup.d.setVisibility(8);
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText("添加");
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localPhoneContact);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if (AppSetting.b) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription("添加");
        }
      }
    }
    label970:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(null);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.e.setVisibility(0);
    paramViewGroup.e.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ContactBindedActivity)) {
      ((ContactBindedActivity)this.jdField_a_of_type_AndroidContentContext).d();
    }
    int j;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368973: 
      localObject = (PhoneContact)localObject;
      paramView = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false)) {
        j = 1;
      }
      break;
    }
    for (int i = 3084;; i = 3006)
    {
      label212:
      ContactBindedActivity localContactBindedActivity;
      if (!paramView.g()) {
        if (this.c.contains(localObject))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
          j = 1;
          i = 3075;
          ((PhoneContact)localObject).isNewRecommend = false;
          if ((this.jdField_a_of_type_AndroidContentContext instanceof ContactBindedActivity))
          {
            localContactBindedActivity = (ContactBindedActivity)this.jdField_a_of_type_AndroidContentContext;
            if (!TextUtils.isEmpty(((PhoneContact)localObject).pinyinFirst)) {
              break label600;
            }
          }
        }
      }
      label600:
      for (paramView = "#";; paramView = String.valueOf(((PhoneContact)localObject).pinyinFirst.charAt(0)).toUpperCase())
      {
        paramView = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramView);
        if ((paramView != null) && (!paramView.isEmpty()))
        {
          localContactBindedActivity.jdField_a_of_type_Int = paramView.indexOf(localObject);
          if (localContactBindedActivity.jdField_a_of_type_Int != -1) {
            localContactBindedActivity.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject);
          }
        }
        paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, "取消", null);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
        notifyDataSetChanged();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
        break;
        if (this.c.isEmpty())
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          break label212;
        }
        if (this.c.contains(localObject)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          break;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = (ContactBindedAdapter.ConactBindedHolder)localObject;
        boolean bool2 = a(paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact);
        localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (!bool2)
        {
          bool1 = true;
          a((PhoneContact)localObject, bool1);
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$SelectedListener == null) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$SelectedListener;
          paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
          if (bool2) {
            break label707;
          }
        }
        label707:
        for (boolean bool1 = true;; bool1 = false)
        {
          ((ContactBindedAdapter.SelectedListener)localObject).a(paramView, bool1);
          return;
          bool1 = false;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((ContactBindedAdapter.ConactBindedHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.isNewRecommend = false;
        localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))) {
          break label861;
        }
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 53);
        paramView.k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        paramView.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        if ((!((PhoneContactManagerImp)localObject).g()) || (!this.c.isEmpty())) {
          break label909;
        }
        paramView.jdField_h_of_type_Int = 104;
      }
      for (;;)
      {
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
        notifyDataSetChanged();
        return;
        label861:
        if (((PhoneContactManagerImp)localObject).g())
        {
          paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 34);
          break;
        }
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 29);
        break;
        label909:
        if (this.c.contains(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact)) {
          paramView.jdField_h_of_type_Int = 101;
        } else {
          paramView.jdField_h_of_type_Int = 102;
        }
      }
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactBindedAdapter
 * JD-Core Version:    0.7.0.1
 */