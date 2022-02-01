package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicListFragment
  extends BasePartFragment
{
  protected PublicListCommonPart a;
  protected ArrayList<BaseListBlock> b = new ArrayList();
  protected ArrayList<String> c;
  protected List<BasePartFragment> d;
  protected MultiTabViewPager e;
  protected PublicListFragment.MultiFragmentsAdapter f;
  
  private void e()
  {
    this.e = ((MultiTabViewPager)this.D.findViewById(2131450004));
    this.f = new PublicListFragment.MultiFragmentsAdapter(this, getChildFragmentManager(), null);
    List localList = this.d;
    if ((localList != null) && (localList.size() > 1)) {
      this.e.setOffscreenPageLimit(this.d.size() - 1);
    }
    this.e.setAdapter(this.f);
  }
  
  public BaseListBlock a(Intent paramIntent, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (BaseListBlock)Class.forName(paramString).getConstructor(new Class[] { Bundle.class }).newInstance(new Object[] { getActivity().getIntent().getExtras() });
        try
        {
          if (paramIntent.hasExtra("public_list_init_data")) {
            paramString.setDatas((ArrayList)paramIntent.getSerializableExtra("public_list_init_data"));
          }
          String str = paramString;
          if (!paramIntent.hasExtra("key_bundle_common_init_bean")) {
            return ???;
          }
          paramString.setInitBean(paramIntent.getSerializableExtra("key_bundle_common_init_bean"));
          return paramString;
        }
        catch (Exception localException1)
        {
          paramIntent = paramString;
        }
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException2)
    {
      paramIntent = null;
      paramString = new StringBuilder();
      paramString.append("initAdapterError");
      paramString.append(localException2.getMessage());
      QLog.e("PublicListFragment", 1, paramString.toString());
      Intent localIntent = paramIntent;
      return localIntent;
    }
  }
  
  public BasePartFragment a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (BasePartFragment)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAdapterError");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("PublicListFragment", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  protected void a()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("public_list_block_class_array"))) {
      try
      {
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.c = localIntent.getStringArrayListExtra("public_list_block_class_array");
        Object localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          BaseListBlock localBaseListBlock = a(localIntent, (String)localObject2);
          if (localBaseListBlock != null)
          {
            PublicListInnerFragment localPublicListInnerFragment = new PublicListInnerFragment();
            localPublicListInnerFragment.a(localBaseListBlock);
            this.b.add(localBaseListBlock);
            this.d.add(localPublicListInnerFragment);
          }
          localObject2 = a((String)localObject2);
          if (localObject2 != null) {
            this.d.add(localObject2);
          }
        }
        QLog.e("PublicListFragment", 1, "intent can't be null");
      }
      catch (Exception localException)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initIntentData error");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.e("PublicListFragment", 1, ((StringBuilder)localObject1).toString());
        getActivity().finish();
        return;
      }
    } else {
      getActivity().finish();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e();
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (ImmersiveUtils.d() == 1)
    {
      QCircleThemeUtil.a(getActivity(), QCircleSkinHelper.getInstance().getColor(2131167059));
      ImmersiveUtils.a(QCircleCommonUtil.isInNightMode() ^ true, getActivity().getWindow());
    }
  }
  
  public String b()
  {
    return "PublicListFragment";
  }
  
  protected int c()
  {
    return 2131626923;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.a = new PublicListCommonPart(this.b);
    localArrayList.add(this.a);
    return localArrayList;
  }
  
  protected int j()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      BaseListBlock localBaseListBlock = (BaseListBlock)localIterator.next();
      if (localBaseListBlock.getStatusBarColor() != 0) {
        return localBaseListBlock.getStatusBarColor();
      }
    }
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseListBlock)((Iterator)localObject).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    a();
  }
  
  public boolean onBackEvent()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((BaseListBlock)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.PublicListFragment
 * JD-Core Version:    0.7.0.1
 */