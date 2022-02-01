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
  private int jdField_a_of_type_Int = 1;
  private final Context jdField_a_of_type_AndroidContentContext;
  private TagAdapter.OnItemClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter$OnItemClickListener;
  private String jdField_a_of_type_JavaLangString;
  private final List<TagItem.TagInfoBase> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = "来自微视APP";
  private List<TagItem.TagInfoBase> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  
  public TagAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    int n = UIUtils.a(this.jdField_a_of_type_AndroidContentContext);
    int i3 = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    int i2 = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 23.0F);
    boolean bool = this.jdField_b_of_type_Boolean;
    int i1 = 0;
    if (bool) {
      f1 = localTextPaint.measureText(this.jdField_b_of_type_JavaLangString);
    }
    for (int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);; i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F))
    {
      f1 += i;
      break label154;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      f1 = localTextPaint.measureText(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Boolean = false;
    float f1 = 0.0F;
    label154:
    int k;
    if (paramBoolean) {
      k = 2;
    } else {
      k = 6;
    }
    int j = 0;
    i = 1;
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f2 = localTextPaint.measureText(b((TagItem.TagInfoBase)this.jdField_a_of_type_JavaUtilList.get(j))) + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      float f3 = f1 + f2;
      float f4 = n - i3 * 2;
      if (f3 > f4)
      {
        int m = i + 1;
        if (m > k)
        {
          if (paramBoolean)
          {
            i = j;
            n = m;
            if (f1 + i2 <= f4) {
              break label429;
            }
            i = j - 1;
            n = m;
            break label429;
          }
          i = this.jdField_a_of_type_JavaUtilList.size();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131714520));
          localStringBuilder.append(i - j);
          localStringBuilder.append(HardCodeUtil.a(2131714523));
          i = j;
          n = m;
          if (f1 + (localTextPaint.measureText(localStringBuilder.toString()) + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F)) <= f4) {
            break label429;
          }
          i = j - 1;
          n = m;
          break label429;
        }
        f1 = f2;
        i = m;
      }
      else
      {
        f1 = f3;
      }
      j += 1;
    }
    j = 0;
    n = i;
    i = j;
    label429:
    if (n <= k)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_Int = 1;
      j = i1;
    }
    else if (paramBoolean)
    {
      this.jdField_a_of_type_Int = 2;
      j = i1;
    }
    else
    {
      this.jdField_a_of_type_Int = 3;
      j = i1;
    }
    while (j < i)
    {
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.get(j));
      j += 1;
    }
  }
  
  private static String b(TagItem.TagInfoBase paramTagInfoBase)
  {
    Object localObject = paramTagInfoBase.jdField_a_of_type_JavaLangString;
    paramTagInfoBase = (TagItem.TagInfoBase)localObject;
    if (StringUtil.a((String)localObject) > 20)
    {
      paramTagInfoBase = new StringBuilder();
      paramTagInfoBase.append(StringUtil.a((String)localObject, 0, 20));
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
      paramTextView.setBackgroundResource(2130847071);
      return;
    }
    if ("1103".equals(str))
    {
      paramTextView.setBackgroundResource(2130847072);
      return;
    }
    paramTextView.setBackgroundResource(2130847073);
  }
  
  public void a(TagAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(List<TagItem.TagInfoBase> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    if (paramList == null)
    {
      SLog.e("Q.qqstory.tag.TagAdapter", "TagList is null.");
      return;
    }
    SLog.a("Q.qqstory.tag.TagAdapter", "qimWording:%s, isTagFold:%s, tagList:%s,", paramString1, Boolean.valueOf(paramBoolean1), paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    a(paramBoolean1);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        return this.jdField_b_of_type_JavaUtilList.size();
      }
      return this.jdField_b_of_type_JavaUtilList.size() + 1;
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      return this.jdField_b_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_b_of_type_JavaUtilList.size() + 2;
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
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      if (((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) && (paramInt == 0))
      {
        if (this.jdField_b_of_type_Boolean) {
          return 4;
        }
        return 3;
      }
      return 0;
    }
    if (i == 2)
    {
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
          return 0;
        }
        return 1;
      }
      if (paramInt == 0)
      {
        if (this.jdField_b_of_type_Boolean) {
          return 4;
        }
        return 3;
      }
      if ((paramInt > 0) && (paramInt <= this.jdField_b_of_type_JavaUtilList.size())) {
        return 0;
      }
      return 1;
    }
    if (i == 3)
    {
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
          return 0;
        }
        return 2;
      }
      if (paramInt == 0)
      {
        if (this.jdField_b_of_type_Boolean) {
          return 4;
        }
        return 3;
      }
      if ((paramInt > 0) && (paramInt <= this.jdField_b_of_type_JavaUtilList.size())) {
        return 0;
      }
      return 2;
    }
    SLog.e("Q.qqstory.tag.TagAdapter", "mode error:%s", new Object[] { Integer.valueOf(i) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (i == 1)
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561788, null);
      ((ImageView)((View)localObject1).findViewById(2131371487)).setOnClickListener(new TagAdapter.1(this));
      ((View)localObject1).setTag(2131374617, Integer.valueOf(i));
    }
    for (;;)
    {
      break;
      Object localObject2;
      Object localObject3;
      if (i == 2)
      {
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561786, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131368188);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        int k = this.jdField_b_of_type_JavaUtilList.size();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131714521));
        ((StringBuilder)localObject3).append(j - k);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131714522));
        ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
        ((View)localObject1).setTag(2131374617, Integer.valueOf(i));
      }
      else
      {
        if (i == 3)
        {
          localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561784, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131378259);
          ((TextView)localObject2).setText(this.jdField_a_of_type_JavaLangString);
          ((TextView)localObject2).setOnClickListener(new TagAdapter.2(this));
          b((TextView)localObject2);
          ((View)localObject1).setTag(2131374617, Integer.valueOf(i));
        }
        for (;;)
        {
          break;
          if (i == 4)
          {
            localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561784, null);
            localObject2 = (TextView)((View)localObject1).findViewById(2131378259);
            float f = ((TextView)localObject2).getPaint().measureText(this.jdField_b_of_type_JavaLangString);
            localObject3 = Shader.TileMode.CLAMP;
            localObject3 = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -15289095, -8753934, -1161312 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject3);
            ((TextView)localObject2).getPaint().setShader((Shader)localObject3);
            ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangString);
            ((TextView)localObject2).setOnClickListener(new TagAdapter.3(this));
            b((TextView)localObject2);
            ((View)localObject1).setTag(2131374617, Integer.valueOf(i));
          }
          else
          {
            if (paramView == null)
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561784, null);
              localObject1 = new TagAdapter.TagViewHolder(paramView);
              paramView.setTag(localObject1);
            }
            else
            {
              localObject1 = (TagAdapter.TagViewHolder)paramView.getTag();
            }
            if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
              localObject2 = this.jdField_b_of_type_JavaUtilList.get(paramInt);
            } else {
              localObject2 = this.jdField_b_of_type_JavaUtilList.get(paramInt - 1);
            }
            ((TagAdapter.TagViewHolder)localObject1).a((TagItem.TagInfoBase)localObject2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter$OnItemClickListener);
            paramView.setTag(2131374617, Integer.valueOf(i));
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
    int j = this.jdField_a_of_type_Int;
    int i = 2;
    if (j == 1)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Boolean) {
          return 2;
        }
        i = 1;
      }
      return i;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      i = 3;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagAdapter
 * JD-Core Version:    0.7.0.1
 */