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
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  
  protected Bitmap a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected Bitmap a(String paramString, int paramInt)
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
    if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      if (paramInt < 0) {
        return;
      }
      if ((paramView instanceof TextView))
      {
        paramView = (TextView)paramView;
        i = paramView.getPaddingLeft();
        if ((!ThemeUtil.isNowThemeDefaultCache) && (!ThemeUtil.isNowThemeIsNight(PublicAccountFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment), false, null))) {
          paramView.setBackgroundColor(553648127);
        } else {
          paramView.setBackgroundResource(2130850581);
        }
        paramView.setPadding(i, 0, 0, 0);
        paramView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        paramView.setTextColor(PublicAccountFragment.f(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment).getResources().getColorStateList(2131167142));
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    if (!ThemeUtil.isNowThemeDefaultCache) {
      return !ThemeUtil.isNowThemeIsNight(PublicAccountFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment), false, null);
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_JavaUtilList.iterator();
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
        PublicAccountFragment.InnerPAInfo localInnerPAInfo = (PublicAccountFragment.InnerPAInfo)localIterator.next();
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
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      while (c <= 'Z')
      {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
          Collections.sort((List)localObject2, PublicAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment));
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), localObject2);
        }
        c = (char)(c + '\001');
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
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int getCount()
  {
    int k = this.jdField_a_of_type_ArrayOfInt.length;
    int j = 0;
    int i = j;
    if (k != 0)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return 0;
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
      localObject1 = (List)((LinkedHashMap)localObject1).get(localObject2[(localObject2.length - 1)]);
      i = j;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfInt;
        i = localObject2[(localObject2.length - 1)] + ((List)localObject1).size() + 1;
      }
    }
    return i;
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
    Object localObject1;
    if (paramView == null)
    {
      localView = PublicAccountFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment).getLayoutInflater().inflate(2131559616, paramViewGroup, false);
      paramView = new PublicAccountFragment.PAViewHolder();
      paramView.jdField_c_of_type_Int = 115;
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
      if ((paramView.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
    }
    else
    {
      localObject1 = (PublicAccountFragment.PAViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject1 = (PublicAccountFragment.InnerPAInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$InnerPAInfo = ((PublicAccountFragment.InnerPAInfo)localObject1);
      paramView.jdField_a_of_type_JavaLangString = String.valueOf(((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.f.setVisibility(8);
      paramView.d.setVisibility(0);
      paramView.d.setText(((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      if (((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade > 0L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment;
          ((PublicAccountFragment)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((PublicAccountFragment)localObject2).getResources().getDrawable(2130841838);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
          ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
        }
        paramView.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
      else
      {
        paramView.d.setCompoundDrawables(null, null, null, null);
      }
      paramView.e.setText(((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
      Object localObject2 = a(paramView.jdField_a_of_type_JavaLangString);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      boolean bool;
      if (((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        bool = CrmUtils.a(PublicAccountFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment), ((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);
      } else {
        bool = false;
      }
      if (bool)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
        paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((PublicAccountFragment.InnerPAInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
        localObject1 = new StringBuilder(24);
        ((StringBuilder)localObject1).append(paramView.d.getText());
        ((StringBuilder)localObject1).append(" 简介 ");
        ((StringBuilder)localObject1).append(paramView.e.getText());
        localView.setContentDescription((CharSequence)localObject1);
        localView.setFocusable(true);
        localView.setFocusableInTouchMode(true);
      }
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$InnerPAInfo = null;
      paramView.jdField_a_of_type_JavaLangString = "";
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.f.setVisibility(0);
      localObject1 = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      paramView.f.setText((CharSequence)localObject1);
      i = paramView.f.getPaddingLeft();
      paramView.f.setPadding(i, 0, 0, 0);
      if (AppSetting.d) {
        paramView.f.setContentDescription(String.format(PublicAccountFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment).getString(2131691806), new Object[] { ((String)localObject1).toLowerCase() }));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.ListAdapter
 * JD-Core Version:    0.7.0.1
 */