package com.tencent.mobileqq.activity.contacts.publicaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PublicAccountFragment$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PublicAccountFragment.ListAdapter.1(this);
  public LinkedHashMap<String, List<PublicAccountFragment.InnerPAInfo>> a;
  private boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b = 0;
  
  public PublicAccountFragment$ListAdapter(PublicAccountFragment paramPublicAccountFragment)
  {
    this(paramPublicAccountFragment, PublicAccountFragment.c(paramPublicAccountFragment), PublicAccountFragment.b(paramPublicAccountFragment), paramPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public PublicAccountFragment$ListAdapter(PublicAccountFragment paramPublicAccountFragment, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramBoolean);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(true);
  }
  
  public int a()
  {
    return 2131559435;
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
  
  public Bitmap a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public Bitmap a(String paramString, int paramInt)
  {
    return a(paramString, 115, (byte)0, paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (paramInt < 0)) {}
    while (!(paramView instanceof TextView)) {
      return;
    }
    paramView = (TextView)paramView;
    i = paramView.getPaddingLeft();
    if ((ThemeUtil.isNowThemeDefaultCache) || (ThemeUtil.isNowThemeIsNight(PublicAccountFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment), false, null))) {
      paramView.setBackgroundResource(2130850655);
    }
    for (;;)
    {
      paramView.setPadding(i, 0, 0, 0);
      paramView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      paramView.setTextColor(PublicAccountFragment.f(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment).getResources().getColorStateList(2131167117));
      return;
      paramView.setBackgroundColor(553648127);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return (!ThemeUtil.isNowThemeDefaultCache) && (!ThemeUtil.isNowThemeIsNight(PublicAccountFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment), false, null));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    Object localObject2;
    label92:
    do
    {
      return;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PublicAccountFragment.InnerPAInfo localInnerPAInfo = (PublicAccountFragment.InnerPAInfo)((Iterator)localObject2).next();
        if ((localInnerPAInfo.jdField_a_of_type_JavaLangString == null) || (localInnerPAInfo.jdField_a_of_type_JavaLangString.length() == 0))
        {
          localObject1 = "#";
          i = ((String)localObject1).charAt(0);
          if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
            break label197;
          }
        }
        for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
        {
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localInnerPAInfo);
          break;
          localObject1 = localInnerPAInfo.jdField_a_of_type_JavaLangString.substring(0, 1);
          break label92;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
          Collections.sort((List)localObject2, PublicAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment));
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), localObject2);
        }
      }
      if (((LinkedHashMap)localObject1).get("#") != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get("#");
        Collections.sort((List)localObject2, PublicAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment));
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", localObject2);
      }
      ((LinkedHashMap)localObject1).clear();
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    } while (this.jdField_a_of_type_ArrayOfInt.length == 0);
    label197:
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      int j = localObject2[i];
      int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
      i += 1;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ArrayOfInt.length == 0) || (!this.jdField_a_of_type_Boolean)) {
      return 0;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)]);
    if (localList != null)
    {
      int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
      return localList.size() + i + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PublicAccountFragment.InnerPAInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView;
    if (paramView == null)
    {
      localView = PublicAccountFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment).getLayoutInflater().inflate(2131559740, paramViewGroup, false);
      paramView = new PublicAccountFragment.PAViewHolder();
      paramView.jdField_c_of_type_Int = 115;
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364322));
      paramView.d = ((TextView)localView.findViewById(2131379092));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373646));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373629));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373656));
      paramView.e = ((TextView)localView.findViewById(2131379094));
      paramView.f = ((TextView)localView.findViewById(2131380419));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131373643);
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364294));
      localView.setTag(paramView);
      if (!(paramView.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        break label903;
      }
      ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    label903:
    for (;;)
    {
      Object localObject;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localObject = (PublicAccountFragment.InnerPAInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$InnerPAInfo = ((PublicAccountFragment.InnerPAInfo)localObject);
        paramView.jdField_a_of_type_JavaLangString = String.valueOf(((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.f.setVisibility(8);
        paramView.d.setVisibility(0);
        paramView.d.setText(((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        if (((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade > 0L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.getResources().getDrawable(2130841947);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
            ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
          }
          paramView.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
          label431:
          paramView.e.setText(((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
          Bitmap localBitmap = a(paramView.jdField_a_of_type_JavaLangString);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          boolean bool = false;
          if (((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
            bool = CrmUtils.a(PublicAccountFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment), ((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);
          }
          if (!bool) {
            break label746;
          }
          paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
          paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((PublicAccountFragment.InnerPAInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          label560:
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
            ((StringBuilder)localObject).append(paramView.d.getText()).append(" 简介 ").append(paramView.e.getText());
            localView.setContentDescription((CharSequence)localObject);
            localView.setFocusable(true);
            localView.setFocusableInTouchMode(true);
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (PublicAccountFragment.PAViewHolder)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        paramView.d.setCompoundDrawables(null, null, null, null);
        break label431;
        label746:
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, "");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, "");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break label560;
        paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$InnerPAInfo = null;
        paramView.jdField_a_of_type_JavaLangString = "";
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.f.setVisibility(0);
        localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        paramView.f.setText((CharSequence)localObject);
        i = paramView.f.getPaddingLeft();
        paramView.f.setPadding(i, 0, 0, 0);
        if (AppSetting.d) {
          paramView.f.setContentDescription(String.format(PublicAccountFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment).getString(2131691884), new Object[] { ((String)localObject).toLowerCase() }));
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.ListAdapter
 * JD-Core Version:    0.7.0.1
 */