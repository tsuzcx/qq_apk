package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PublicAccountListActivity$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public int a;
  public LinkedHashMap<String, List<PublicAccountListActivity.InnerPAInfo>> a;
  public int[] a;
  public String[] a;
  public int b = 0;
  
  public PublicAccountListActivity$ListAdapter(PublicAccountListActivity paramPublicAccountListActivity)
  {
    super(paramPublicAccountListActivity, paramPublicAccountListActivity.app, paramPublicAccountListActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Int = 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.b == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.b.iterator();
    char c;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c = 'A';
      j = 0;
      String str = "#";
      if (!bool) {
        break;
      }
      PublicAccountListActivity.InnerPAInfo localInnerPAInfo = (PublicAccountListActivity.InnerPAInfo)localIterator.next();
      if (!PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity, localInnerPAInfo))
      {
        if ((localInnerPAInfo.jdField_a_of_type_JavaLangString != null) && (localInnerPAInfo.jdField_a_of_type_JavaLangString.length() != 0)) {
          localObject1 = localInnerPAInfo.jdField_a_of_type_JavaLangString.substring(0, 1);
        } else {
          localObject1 = "#";
        }
        i = ((String)localObject1).charAt(0);
        if ((65 > i) || (i > 90))
        {
          localObject2 = str;
          if (97 <= i)
          {
            localObject2 = str;
            if (i > 122) {}
          }
        }
        else
        {
          localObject2 = ((String)localObject1).toUpperCase();
        }
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2) == null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject2, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localInnerPAInfo);
      }
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    while (c <= 'Z')
    {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
        Collections.sort((List)localObject2, PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity));
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), localObject2);
      }
      c = (char)(c + '\001');
    }
    if (((LinkedHashMap)localObject1).get("#") != null)
    {
      localObject2 = (List)((LinkedHashMap)localObject1).get("#");
      Collections.sort((List)localObject2, PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", localObject2);
    }
    ((LinkedHashMap)localObject1).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    Object localObject2 = this.jdField_a_of_type_ArrayOfInt;
    if (localObject2.length == 0) {
      return;
    }
    localObject2[0] = 0;
    int i = 1;
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      if (i >= localObject2.length) {
        break;
      }
      localObject2[i] += localObject2[(i - 1)] + ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    return 2131559309;
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
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (paramInt >= arrayOfString.length) {
      return;
    }
    ((TextView)paramView).setText(arrayOfString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
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
    return (PublicAccountListActivity.InnerPAInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559616, paramViewGroup, false);
      paramView = new PublicAccountListActivity.PAViewHolder();
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364234));
      paramView.d = ((TextView)localView.findViewById(2131378461));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373219));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373202));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373229));
      paramView.e = ((TextView)localView.findViewById(2131378463));
      paramView.f = ((TextView)localView.findViewById(2131379732));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131373216);
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364206));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (PublicAccountListActivity.PAViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (PublicAccountListActivity.InnerPAInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$InnerPAInfo = ((PublicAccountListActivity.InnerPAInfo)localObject);
      paramView.jdField_a_of_type_JavaLangString = String.valueOf(((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.f.setVisibility(8);
      paramView.d.setVisibility(0);
      paramView.d.setText(((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      if (((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade > 0L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          PublicAccountListActivity localPublicAccountListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity;
          localPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localPublicAccountListActivity.getResources().getDrawable(2130841838);
          this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
        }
        ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
        paramView.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      else
      {
        paramView.d.setCompoundDrawables(null, null, null, null);
      }
      paramView.e.setText(((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(super.a(paramView.jdField_a_of_type_JavaLangString));
      boolean bool;
      if (((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        bool = CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.app, ((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);
      } else {
        bool = false;
      }
      if (bool)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((PublicAccountListActivity.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, "");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, "");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      if (!bool)
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-1, "");
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-2, "");
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d)
      {
        localObject = new StringBuilder(24);
        ((StringBuilder)localObject).append(paramView.d.getText());
        ((StringBuilder)localObject).append(" 简介 ");
        ((StringBuilder)localObject).append(paramView.e.getText());
        localView.setContentDescription((CharSequence)localObject);
        localView.setFocusable(true);
        localView.setFocusableInTouchMode(true);
      }
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$InnerPAInfo = null;
      paramView.jdField_a_of_type_JavaLangString = "";
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.f.setVisibility(0);
      localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      paramView.f.setText((CharSequence)localObject);
      if (AppSetting.d) {
        paramView.f.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getString(2131691806), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */