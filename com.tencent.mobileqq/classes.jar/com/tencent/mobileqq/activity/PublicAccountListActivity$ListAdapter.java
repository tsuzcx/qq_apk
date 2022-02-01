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
  public LinkedHashMap<String, List<PublicAccountListActivity.InnerPAInfo>> a = new LinkedHashMap();
  public int[] b = new int[0];
  public String[] c = new String[0];
  public int d = 0;
  public int e = 0;
  
  public PublicAccountListActivity$ListAdapter(PublicAccountListActivity paramPublicAccountListActivity)
  {
    super(paramPublicAccountListActivity, paramPublicAccountListActivity.app, paramPublicAccountListActivity.u, true);
  }
  
  private void c()
  {
    this.a.clear();
    if (this.f.A == null) {
      return;
    }
    Iterator localIterator = this.f.A.iterator();
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
      PublicAccountListActivity.InnerPAInfo localInnerPAInfo = (PublicAccountListActivity.InnerPAInfo)localIterator.next();
      if (!PublicAccountListActivity.a(this.f, localInnerPAInfo))
      {
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
        if (this.a.get(localObject2) == null) {
          this.a.put(localObject2, new ArrayList());
        }
        ((List)this.a.get(localObject2)).add(localInnerPAInfo);
      }
    }
    Object localObject1 = this.a;
    this.a = new LinkedHashMap();
    while (c1 <= 'Z')
    {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c1));
        Collections.sort((List)localObject2, PublicAccountListActivity.c(this.f));
        this.a.put(String.valueOf(c1), localObject2);
      }
      c1 = (char)(c1 + '\001');
    }
    if (((LinkedHashMap)localObject1).get("#") != null)
    {
      localObject2 = (List)((LinkedHashMap)localObject1).get("#");
      Collections.sort((List)localObject2, PublicAccountListActivity.c(this.f));
      this.a.put("#", localObject2);
    }
    ((LinkedHashMap)localObject1).clear();
    this.b = new int[this.a.keySet().size()];
    this.c = new String[this.b.length];
    localObject1 = this.a.keySet().iterator();
    Object localObject2 = this.b;
    if (localObject2.length == 0) {
      return;
    }
    localObject2[0] = 0;
    int i = 1;
    for (;;)
    {
      localObject2 = this.b;
      if (i >= localObject2.length) {
        break;
      }
      localObject2[i] += localObject2[(i - 1)] + ((List)this.a.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.a.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.c[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    return 2131625258;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.b, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    String[] arrayOfString = this.c;
    if (paramInt >= arrayOfString.length) {
      return;
    }
    ((TextView)paramView).setText(arrayOfString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.b, paramInt) >= 0;
  }
  
  public void b()
  {
    c();
    super.notifyDataSetChanged();
  }
  
  public int f_(String paramString)
  {
    if (this.c != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.c;
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
        return this.b[i];
      }
    }
    return -1;
  }
  
  public int getCount()
  {
    Object localObject = this.b;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.a;
    String[] arrayOfString = this.c;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.b, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PublicAccountListActivity.InnerPAInfo)((List)this.a.get(this.c[i])).get(paramInt - this.b[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.b, paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.f.z.inflate(2131625645, paramViewGroup, false);
      paramView = new PublicAccountListActivity.PAViewHolder();
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
      localObject = (PublicAccountListActivity.InnerPAInfo)((List)this.a.get(this.c[i])).get(paramInt - this.b[i] - 1);
      paramView.a = ((PublicAccountListActivity.InnerPAInfo)localObject);
      paramView.y = String.valueOf(((PublicAccountListActivity.InnerPAInfo)localObject).a.uin);
      paramView.i.setVisibility(0);
      paramView.h.setVisibility(8);
      paramView.f.setVisibility(0);
      paramView.f.setText(((PublicAccountListActivity.InnerPAInfo)localObject).a.name);
      if (((PublicAccountListActivity.InnerPAInfo)localObject).a.certifiedGrade > 0L)
      {
        if (this.f.a == null)
        {
          PublicAccountListActivity localPublicAccountListActivity = this.f;
          localPublicAccountListActivity.a = localPublicAccountListActivity.getResources().getDrawable(2130842755);
          this.f.a.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
        }
        ThemeUtil.setThemeFilter(this.f.a, ThemeUtil.curThemeId);
        paramView.f.setCompoundDrawables(null, null, this.f.a, null);
      }
      else
      {
        paramView.f.setCompoundDrawables(null, null, null, null);
      }
      paramView.g.setText(((PublicAccountListActivity.InnerPAInfo)localObject).a.summary);
      paramView.A.setImageBitmap(super.a(paramView.y));
      boolean bool;
      if (((PublicAccountListActivity.InnerPAInfo)localObject).a.extendType == 2) {
        bool = CrmUtils.a(this.f.app, ((PublicAccountListActivity.InnerPAInfo)localObject).a.getUin(), 1024);
      } else {
        bool = false;
      }
      if (bool)
      {
        paramView.b.setTag(-1, ((PublicAccountListActivity.InnerPAInfo)localObject).a.getUin());
        paramView.b.setTag(-2, ((PublicAccountListActivity.InnerPAInfo)localObject).a.name);
        paramView.b.setOnClickListener(this.f.F);
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
        localObject = new StringBuilder(24);
        ((StringBuilder)localObject).append(paramView.f.getText());
        ((StringBuilder)localObject).append(" 简介 ");
        ((StringBuilder)localObject).append(paramView.g.getText());
        localView.setContentDescription((CharSequence)localObject);
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
      localObject = String.valueOf(this.c[i]);
      paramView.h.setText((CharSequence)localObject);
      if (AppSetting.e) {
        paramView.h.setContentDescription(String.format(this.f.getString(2131888769), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */