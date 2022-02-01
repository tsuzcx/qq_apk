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
  View.OnClickListener a = new PublicAccountFragment.ListAdapter.1(this);
  public LinkedHashMap<String, List<PublicAccountFragment.InnerPAInfo>> b = new LinkedHashMap();
  public int[] c = new int[0];
  public String[] d = new String[0];
  public int e = 0;
  public int f = 0;
  private boolean h = false;
  
  public PublicAccountFragment$ListAdapter(PublicAccountFragment paramPublicAccountFragment)
  {
    this(paramPublicAccountFragment, PublicAccountFragment.g(paramPublicAccountFragment), PublicAccountFragment.h(paramPublicAccountFragment), paramPublicAccountFragment.b, true);
  }
  
  public PublicAccountFragment$ListAdapter(PublicAccountFragment paramPublicAccountFragment, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramBoolean);
    this.n = ImageUtil.b(true);
  }
  
  public int a()
  {
    return 2131625258;
  }
  
  protected Bitmap a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    return a(paramString, 115, (byte)0, paramInt);
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if (paramInt < this.d.length)
    {
      if (paramInt < 0) {
        return;
      }
      if ((paramView instanceof TextView))
      {
        paramView = (TextView)paramView;
        i = paramView.getPaddingLeft();
        if ((!ThemeUtil.isNowThemeDefaultCache) && (!ThemeUtil.isNowThemeIsNight(PublicAccountFragment.m(this.g), false, null))) {
          paramView.setBackgroundColor(553648127);
        } else {
          paramView.setBackgroundResource(2130852377);
        }
        paramView.setPadding(i, 0, 0, 0);
        paramView.setText(this.d[paramInt]);
        paramView.setTextColor(PublicAccountFragment.n(this.g).getResources().getColorStateList(2131168122));
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.c, paramInt) >= 0;
  }
  
  public int b(String paramString)
  {
    if (this.d != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.d;
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
        return this.c[i];
      }
    }
    return -1;
  }
  
  public void b()
  {
    this.b.clear();
    this.c = new int[0];
    this.d = new String[0];
    this.h = false;
  }
  
  public boolean b(View paramView, int paramInt)
  {
    if (!ThemeUtil.isNowThemeDefaultCache) {
      return !ThemeUtil.isNowThemeIsNight(PublicAccountFragment.l(this.g), false, null);
    }
    return false;
  }
  
  protected void c()
  {
    this.b.clear();
    if (this.g.h != null)
    {
      if (this.g.h.isEmpty()) {
        return;
      }
      Iterator localIterator = this.g.h.iterator();
      char c1;
      int j;
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        c1 = 'A';
        j = 0;
        String str = "#";
        if (!bool) {
          break;
        }
        PublicAccountFragment.InnerPAInfo localInnerPAInfo = (PublicAccountFragment.InnerPAInfo)localIterator.next();
        if ((localInnerPAInfo.b != null) && (localInnerPAInfo.b.length() != 0)) {
          localObject1 = localInnerPAInfo.b.substring(0, 1);
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
        if (this.b.get(localObject2) == null) {
          this.b.put(localObject2, new ArrayList());
        }
        ((List)this.b.get(localObject2)).add(localInnerPAInfo);
      }
      Object localObject1 = this.b;
      this.b = new LinkedHashMap();
      while (c1 <= 'Z')
      {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c1));
          Collections.sort((List)localObject2, PublicAccountFragment.o(this.g));
          this.b.put(String.valueOf(c1), localObject2);
        }
        c1 = (char)(c1 + '\001');
      }
      if (((LinkedHashMap)localObject1).get("#") != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get("#");
        Collections.sort((List)localObject2, PublicAccountFragment.o(this.g));
        this.b.put("#", localObject2);
      }
      ((LinkedHashMap)localObject1).clear();
      this.c = new int[this.b.keySet().size()];
      this.d = new String[this.c.length];
      localObject1 = this.b.keySet().iterator();
      Object localObject2 = this.c;
      if (localObject2.length == 0) {
        return;
      }
      localObject2[0] = 0;
      int i = 1;
      for (;;)
      {
        localObject2 = this.c;
        if (i >= localObject2.length) {
          break;
        }
        localObject2[i] += localObject2[(i - 1)] + ((List)this.b.get(((Iterator)localObject1).next())).size() + 1;
        i += 1;
      }
      localObject1 = this.b.keySet().iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        this.d[i] = ((String)((Iterator)localObject1).next());
        i += 1;
      }
      this.h = true;
    }
  }
  
  public int getCount()
  {
    int k = this.c.length;
    int j = 0;
    int i = j;
    if (k != 0)
    {
      if (!this.h) {
        return 0;
      }
      Object localObject1 = this.b;
      Object localObject2 = this.d;
      localObject1 = (List)((LinkedHashMap)localObject1).get(localObject2[(localObject2.length - 1)]);
      i = j;
      if (localObject1 != null)
      {
        localObject2 = this.c;
        i = localObject2[(localObject2.length - 1)] + ((List)localObject1).size() + 1;
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PublicAccountFragment.InnerPAInfo)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      localView = PublicAccountFragment.i(this.g).getLayoutInflater().inflate(2131625645, paramViewGroup, false);
      paramView = new PublicAccountFragment.PAViewHolder();
      paramView.z = 115;
      paramView.A = ((ImageView)localView.findViewById(2131435219));
      paramView.b = ((ImageView)localView.findViewById(2131430246));
      paramView.f = ((TextView)localView.findViewById(2131447063));
      paramView.c = ((TextView)localView.findViewById(2131440828));
      paramView.e = ((TextView)localView.findViewById(2131440811));
      paramView.d = ((TextView)localView.findViewById(2131440838));
      paramView.g = ((TextView)localView.findViewById(2131447065));
      paramView.h = ((TextView)localView.findViewById(2131448537));
      paramView.i = localView.findViewById(2131440825);
      paramView.j = ((ImageView)localView.findViewById(2131430209));
      localView.setTag(paramView);
      if ((paramView.A instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.A).setSupportMaskView(false);
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
      localObject1 = (PublicAccountFragment.InnerPAInfo)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
      paramView.a = ((PublicAccountFragment.InnerPAInfo)localObject1);
      paramView.y = String.valueOf(((PublicAccountFragment.InnerPAInfo)localObject1).a.uin);
      paramView.i.setVisibility(0);
      paramView.h.setVisibility(8);
      paramView.f.setVisibility(0);
      paramView.f.setText(((PublicAccountFragment.InnerPAInfo)localObject1).a.name);
      if (((PublicAccountFragment.InnerPAInfo)localObject1).a.certifiedGrade > 0L)
      {
        if (this.g.i == null)
        {
          localObject2 = this.g;
          ((PublicAccountFragment)localObject2).i = ((PublicAccountFragment)localObject2).getResources().getDrawable(2130842755);
          this.g.i.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
          ThemeUtil.setThemeFilter(this.g.i, ThemeUtil.curThemeId);
        }
        paramView.f.setCompoundDrawables(null, null, this.g.i, null);
      }
      else
      {
        paramView.f.setCompoundDrawables(null, null, null, null);
      }
      paramView.g.setText(((PublicAccountFragment.InnerPAInfo)localObject1).a.summary);
      Object localObject2 = a(paramView.y);
      paramView.A.setImageBitmap((Bitmap)localObject2);
      boolean bool;
      if (((PublicAccountFragment.InnerPAInfo)localObject1).a.extendType == 2) {
        bool = CrmUtils.a(PublicAccountFragment.j(this.g), ((PublicAccountFragment.InnerPAInfo)localObject1).a.getUin(), 1024);
      } else {
        bool = false;
      }
      if (bool)
      {
        paramView.b.setTag(-1, ((PublicAccountFragment.InnerPAInfo)localObject1).a.getUin());
        paramView.b.setTag(-2, ((PublicAccountFragment.InnerPAInfo)localObject1).a.name);
        paramView.b.setOnClickListener(this.a);
        paramView.b.setVisibility(0);
      }
      else
      {
        paramView.b.setTag(-1, "");
        paramView.b.setTag(-2, "");
        paramView.b.setOnClickListener(null);
        paramView.b.setVisibility(4);
      }
      if (!bool)
      {
        paramView.j.setTag(-1, "");
        paramView.j.setTag(-2, "");
        paramView.j.setOnClickListener(null);
        paramView.j.setVisibility(4);
      }
      paramView.e.setVisibility(8);
      paramView.c.setVisibility(8);
      paramView.d.setVisibility(8);
      if (AppSetting.e)
      {
        localObject1 = new StringBuilder(24);
        ((StringBuilder)localObject1).append(paramView.f.getText());
        ((StringBuilder)localObject1).append(" 简介 ");
        ((StringBuilder)localObject1).append(paramView.g.getText());
        localView.setContentDescription((CharSequence)localObject1);
        localView.setFocusable(true);
        localView.setFocusableInTouchMode(true);
      }
    }
    else
    {
      paramView.a = null;
      paramView.y = "";
      paramView.i.setVisibility(8);
      paramView.h.setVisibility(0);
      localObject1 = String.valueOf(this.d[i]);
      paramView.h.setText((CharSequence)localObject1);
      i = paramView.h.getPaddingLeft();
      paramView.h.setPadding(i, 0, 0, 0);
      if (AppSetting.e) {
        paramView.h.setContentDescription(String.format(PublicAccountFragment.k(this.g).getString(2131888769), new Object[] { ((String)localObject1).toLowerCase() }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.ListAdapter
 * JD-Core Version:    0.7.0.1
 */