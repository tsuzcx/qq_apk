package com.tencent.biz.qqstory.storyHome.tag;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TagAdapter
  extends BaseAdapter
{
  private int a = 1;
  private final Context b;
  private final List<TagItem.TagInfoBase> c;
  private List<TagItem.TagInfoBase> d;
  private TagAdapter.OnItemClickListener e;
  private String f;
  private boolean g = false;
  private boolean h = false;
  private String i = "来自微视APP";
  
  public TagAdapter(Context paramContext)
  {
    this.b = paramContext;
    this.c = new ArrayList();
    this.d = new ArrayList();
  }
  
  private void a(boolean paramBoolean)
  {
    this.d.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(UIUtils.a(this.b, 12.0F));
    int i1 = UIUtils.b(this.b);
    int i4 = UIUtils.a(this.b, 10.0F);
    int i3 = UIUtils.a(this.b, 23.0F);
    boolean bool = this.h;
    int i2 = 0;
    if (bool) {
      f1 = localTextPaint.measureText(this.i);
    }
    for (int j = UIUtils.a(this.b, 18.0F);; j = UIUtils.a(this.b, 18.0F))
    {
      f1 += j;
      break label154;
      if (TextUtils.isEmpty(this.f)) {
        break;
      }
      this.g = true;
      f1 = localTextPaint.measureText(this.f);
    }
    this.g = false;
    float f1 = 0.0F;
    label154:
    int m;
    if (paramBoolean) {
      m = 2;
    } else {
      m = 6;
    }
    int k = 0;
    j = 1;
    while (k < this.c.size())
    {
      float f2 = localTextPaint.measureText(b((TagItem.TagInfoBase)this.c.get(k))) + UIUtils.a(this.b, 18.0F);
      float f3 = f1 + f2;
      float f4 = i1 - i4 * 2;
      if (f3 > f4)
      {
        int n = j + 1;
        if (n > m)
        {
          if (paramBoolean)
          {
            j = k;
            i1 = n;
            if (f1 + i3 <= f4) {
              break label429;
            }
            j = k - 1;
            i1 = n;
            break label429;
          }
          j = this.c.size();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131912029));
          localStringBuilder.append(j - k);
          localStringBuilder.append(HardCodeUtil.a(2131912032));
          j = k;
          i1 = n;
          if (f1 + (localTextPaint.measureText(localStringBuilder.toString()) + UIUtils.a(this.b, 18.0F)) <= f4) {
            break label429;
          }
          j = k - 1;
          i1 = n;
          break label429;
        }
        f1 = f2;
        j = n;
      }
      else
      {
        f1 = f3;
      }
      k += 1;
    }
    k = 0;
    i1 = j;
    j = k;
    label429:
    if (i1 <= m)
    {
      j = this.c.size();
      this.a = 1;
      k = i2;
    }
    else if (paramBoolean)
    {
      this.a = 2;
      k = i2;
    }
    else
    {
      this.a = 3;
      k = i2;
    }
    while (k < j)
    {
      this.d.add(this.c.get(k));
      k += 1;
    }
  }
  
  private static String b(TagItem.TagInfoBase paramTagInfoBase)
  {
    Object localObject = paramTagInfoBase.b;
    paramTagInfoBase = (TagItem.TagInfoBase)localObject;
    if (StringUtil.getWordCount((String)localObject) > 20)
    {
      paramTagInfoBase = new StringBuilder();
      paramTagInfoBase.append(StringUtil.substring((String)localObject, 0, 20));
      paramTagInfoBase.append("...");
      paramTagInfoBase = paramTagInfoBase.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append(paramTagInfoBase);
    return ((StringBuilder)localObject).toString();
  }
  
  private static void b(TextView paramTextView)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if ("2040".equals(str))
    {
      paramTextView.setBackgroundResource(2130848623);
      return;
    }
    if ("1103".equals(str))
    {
      paramTextView.setBackgroundResource(2130848624);
      return;
    }
    paramTextView.setBackgroundResource(2130848625);
  }
  
  public void a(TagAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.e = paramOnItemClickListener;
  }
  
  public void a(List<TagItem.TagInfoBase> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    if (paramList == null)
    {
      SLog.e("Q.qqstory.tag.TagAdapter", "TagList is null.");
      return;
    }
    SLog.a("Q.qqstory.tag.TagAdapter", "qimWording:%s, isTagFold:%s, tagList:%s,", paramString1, Boolean.valueOf(paramBoolean1), paramList);
    this.c.clear();
    this.d.clear();
    this.c.addAll(paramList);
    this.f = paramString1;
    this.h = paramBoolean2;
    this.i = paramString2;
    a(paramBoolean1);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.a == 1)
    {
      if ((!this.h) && (!this.g)) {
        return this.d.size();
      }
      return this.d.size() + 1;
    }
    if ((!this.h) && (!this.g)) {
      return this.d.size() + 1;
    }
    return this.d.size() + 2;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = this.a;
    if (j == 1)
    {
      if (((this.h) || (this.g)) && (paramInt == 0))
      {
        if (this.h) {
          return 4;
        }
        return 3;
      }
      return 0;
    }
    if (j == 2)
    {
      if ((!this.h) && (!this.g))
      {
        if ((paramInt >= 0) && (paramInt < this.d.size())) {
          return 0;
        }
        return 1;
      }
      if (paramInt == 0)
      {
        if (this.h) {
          return 4;
        }
        return 3;
      }
      if ((paramInt > 0) && (paramInt <= this.d.size())) {
        return 0;
      }
      return 1;
    }
    if (j == 3)
    {
      if ((!this.h) && (!this.g))
      {
        if ((paramInt >= 0) && (paramInt < this.d.size())) {
          return 0;
        }
        return 2;
      }
      if (paramInt == 0)
      {
        if (this.h) {
          return 4;
        }
        return 3;
      }
      if ((paramInt > 0) && (paramInt <= this.d.size())) {
        return 0;
      }
      return 2;
    }
    SLog.e("Q.qqstory.tag.TagAdapter", "mode error:%s", new Object[] { Integer.valueOf(j) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    Object localObject1;
    if (j == 1)
    {
      localObject1 = LayoutInflater.from(this.b).inflate(2131628167, null);
      ((ImageView)((View)localObject1).findViewById(2131438862)).setOnClickListener(new TagAdapter.1(this));
      ((View)localObject1).setTag(2131442787, Integer.valueOf(j));
    }
    for (;;)
    {
      break;
      Object localObject2;
      Object localObject3;
      if (j == 2)
      {
        localObject1 = LayoutInflater.from(this.b).inflate(2131628165, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131435052);
        int k = this.c.size();
        int m = this.d.size();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912030));
        ((StringBuilder)localObject3).append(k - m);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912031));
        ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
        ((View)localObject1).setTag(2131442787, Integer.valueOf(j));
      }
      else
      {
        if (j == 3)
        {
          localObject1 = LayoutInflater.from(this.b).inflate(2131628163, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131446778);
          ((TextView)localObject2).setText(this.f);
          ((TextView)localObject2).setOnClickListener(new TagAdapter.2(this));
          b((TextView)localObject2);
          ((View)localObject1).setTag(2131442787, Integer.valueOf(j));
        }
        for (;;)
        {
          break;
          if (j == 4)
          {
            localObject1 = LayoutInflater.from(this.b).inflate(2131628163, null);
            localObject2 = (TextView)((View)localObject1).findViewById(2131446778);
            float f1 = ((TextView)localObject2).getPaint().measureText(this.i);
            localObject3 = Shader.TileMode.CLAMP;
            localObject3 = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { -15289095, -8753934, -1161312 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject3);
            ((TextView)localObject2).getPaint().setShader((Shader)localObject3);
            ((TextView)localObject2).setText(this.i);
            ((TextView)localObject2).setOnClickListener(new TagAdapter.3(this));
            b((TextView)localObject2);
            ((View)localObject1).setTag(2131442787, Integer.valueOf(j));
          }
          else
          {
            if (paramView == null)
            {
              paramView = LayoutInflater.from(this.b).inflate(2131628163, null);
              localObject1 = new TagAdapter.TagViewHolder(paramView);
              paramView.setTag(localObject1);
            }
            else
            {
              localObject1 = (TagAdapter.TagViewHolder)paramView.getTag();
            }
            if ((!this.h) && (!this.g)) {
              localObject2 = this.d.get(paramInt);
            } else {
              localObject2 = this.d.get(paramInt - 1);
            }
            ((TagAdapter.TagViewHolder)localObject1).a((TagItem.TagInfoBase)localObject2, this.e);
            paramView.setTag(2131442787, Integer.valueOf(j));
            localObject1 = paramView;
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    int k = this.a;
    int j = 2;
    if (k == 1)
    {
      if (!this.h)
      {
        if (this.g) {
          return 2;
        }
        j = 1;
      }
      return j;
    }
    if ((this.h) || (this.g)) {
      j = 3;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagAdapter
 * JD-Core Version:    0.7.0.1
 */