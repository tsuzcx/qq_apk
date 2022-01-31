package com.tencent.biz.qqstory.storyHome.tag;

import android.content.Context;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import occ;
import ocd;
import oce;
import ocf;

public class TagAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private final Context jdField_a_of_type_AndroidContentContext;
  private TagAdapter.OnItemClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter$OnItemClickListener;
  private String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "来自微视";
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public TagAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(boolean paramBoolean)
  {
    int n = 0;
    this.jdField_b_of_type_JavaUtilList.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    int i1 = UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F) * 2;
    int i2 = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 23.0F);
    float f1;
    int k;
    label103:
    int j;
    int i;
    float f2;
    int m;
    if (this.jdField_b_of_type_Boolean)
    {
      f1 = localTextPaint.measureText(this.jdField_b_of_type_JavaLangString) + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      if (!paramBoolean) {
        break label319;
      }
      k = 2;
      j = 1;
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label469;
      }
      f2 = localTextPaint.measureText(b((TagItem.TagInfoBase)this.jdField_a_of_type_JavaUtilList.get(i))) + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      if (f1 + f2 <= i1) {
        break label426;
      }
      m = j + 1;
      if (m <= k) {
        break label411;
      }
      if (!paramBoolean) {
        break label326;
      }
      if (i2 + f1 <= i1) {
        break label462;
      }
      i -= 1;
      j = m;
    }
    for (;;)
    {
      label206:
      if (j <= k)
      {
        i = this.jdField_a_of_type_JavaUtilList.size();
        this.jdField_a_of_type_Int = 1;
        j = n;
      }
      for (;;)
      {
        if (j >= i) {
          break label461;
        }
        this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.get(j));
        j += 1;
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Boolean = true;
          f1 = localTextPaint.measureText(this.jdField_a_of_type_JavaLangString) + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        f1 = 0.0F;
        break;
        label319:
        k = 6;
        break label103;
        label326:
        i2 = this.jdField_a_of_type_JavaUtilList.size();
        j = i;
        if (localTextPaint.measureText("等" + (i2 - i) + "个标签") + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 18.0F) + f1 > i1) {
          j = i - 1;
        }
        i = j;
        j = m;
        break label206;
        label411:
        f1 = f2;
        j = m;
        for (;;)
        {
          i += 1;
          break;
          label426:
          f1 += f2;
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_Int = 2;
          j = n;
        }
        else
        {
          this.jdField_a_of_type_Int = 3;
          j = n;
        }
      }
      label461:
      return;
      label462:
      j = m;
      continue;
      label469:
      i = 0;
    }
  }
  
  private static String b(TagItem.TagInfoBase paramTagInfoBase)
  {
    String str = paramTagInfoBase.jdField_a_of_type_JavaLangString;
    paramTagInfoBase = str;
    if (StringUtil.a(str) > 20) {
      paramTagInfoBase = StringUtil.a(str, 0, 20) + "...";
    }
    return "#" + paramTagInfoBase;
  }
  
  private static void b(TextView paramTextView)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if ("2040".equals(str))
    {
      paramTextView.setBackgroundResource(2130843752);
      return;
    }
    if ("1103".equals(str))
    {
      paramTextView.setBackgroundResource(2130843753);
      return;
    }
    paramTextView.setBackgroundResource(2130843754);
  }
  
  public void a(TagAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(List paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null)
    {
      SLog.e("Q.qqstory.tag.TagAdapter", "TagList is null.");
      return;
    }
    SLog.a("Q.qqstory.tag.TagAdapter", "qimWording:%s, isTagFold:%s, tagList:%s,", paramString, Boolean.valueOf(paramBoolean1), paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    a(paramBoolean1);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        return this.jdField_b_of_type_JavaUtilList.size() + 1;
      }
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      return this.jdField_b_of_type_JavaUtilList.size() + 2;
    }
    return this.jdField_b_of_type_JavaUtilList.size() + 1;
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
    if (this.jdField_a_of_type_Int == 1) {
      if (((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) && (paramInt == 0)) {
        if (!this.jdField_b_of_type_Boolean) {}
      }
    }
    label95:
    label116:
    do
    {
      do
      {
        return 4;
        return 3;
        return 0;
        if (this.jdField_a_of_type_Int != 2) {
          break label116;
        }
        if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          break label95;
        }
        if (paramInt != 0) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      return 3;
      if ((paramInt > 0) && (paramInt <= this.jdField_b_of_type_JavaUtilList.size())) {
        return 0;
      }
      return 1;
      if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
        return 0;
      }
      return 1;
      if (this.jdField_a_of_type_Int != 3) {
        break label193;
      }
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label172;
      }
      if (paramInt != 0) {
        break;
      }
    } while (this.jdField_b_of_type_Boolean);
    return 3;
    if ((paramInt > 0) && (paramInt <= this.jdField_b_of_type_JavaUtilList.size())) {
      return 0;
    }
    return 2;
    label172:
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return 0;
    }
    return 2;
    label193:
    SLog.e("Q.qqstory.tag.TagAdapter", "mode error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 1)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970853, null);
      ((ImageView)paramView.findViewById(2131364808)).setOnClickListener(new occ(this));
      paramView.setTag(2131362459, Integer.valueOf(i));
      return paramView;
    }
    if (i == 2)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970851, null);
      paramViewGroup = (TextView)paramView.findViewById(2131371639);
      paramInt = this.jdField_a_of_type_JavaUtilList.size();
      int j = this.jdField_b_of_type_JavaUtilList.size();
      paramViewGroup.setText("等" + (paramInt - j) + "个标签");
      paramView.setTag(2131362459, Integer.valueOf(i));
      return paramView;
    }
    if (i == 3)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970849, null);
      paramViewGroup = (TextView)paramView.findViewById(2131367250);
      paramViewGroup.setText(this.jdField_a_of_type_JavaLangString);
      paramViewGroup.setOnClickListener(new ocd(this));
      b(paramViewGroup);
      paramView.setTag(2131362459, Integer.valueOf(i));
      return paramView;
    }
    if (i == 4)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970849, null);
      paramViewGroup = (TextView)paramView.findViewById(2131367250);
      paramViewGroup.setText(this.jdField_b_of_type_JavaLangString);
      paramViewGroup.setOnClickListener(new oce(this));
      b(paramViewGroup);
      paramView.setTag(2131362459, Integer.valueOf(i));
      return paramView;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970849, null);
      paramViewGroup = new ocf(paramView);
      paramView.setTag(paramViewGroup);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label386;
      }
    }
    label386:
    for (TagItem.TagInfoBase localTagInfoBase = (TagItem.TagInfoBase)this.jdField_b_of_type_JavaUtilList.get(paramInt - 1);; localTagInfoBase = (TagItem.TagInfoBase)this.jdField_b_of_type_JavaUtilList.get(paramInt))
    {
      paramViewGroup.a(localTagInfoBase, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter$OnItemClickListener);
      paramView.setTag(2131362459, Integer.valueOf(i));
      return paramView;
      paramViewGroup = (ocf)paramView.getTag();
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    int i = 2;
    int j = 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        i = j;
        if (!this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        i = 2;
      }
      return i;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      i = 3;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagAdapter
 * JD-Core Version:    0.7.0.1
 */