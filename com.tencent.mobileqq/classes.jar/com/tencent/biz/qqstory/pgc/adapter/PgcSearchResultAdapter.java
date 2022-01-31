package com.tencent.biz.qqstory.pgc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import nif;

public class PgcSearchResultAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  
  public PgcSearchResultAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
  }
  
  private SpannableString a(String paramString, List paramList)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      int i = paramString.toLowerCase().indexOf(paramList.toLowerCase());
      if (i != -1)
      {
        paramString = new SpannableString(paramString);
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i, paramList.length() + i, 34);
        return paramString;
      }
    }
    return new SpannableString(paramString);
  }
  
  private PgcSearchResultAdapter.ListItemData a(int paramInt1, int paramInt2, UserInfo paramUserInfo)
  {
    PgcSearchResultAdapter.ListItemData localListItemData = new PgcSearchResultAdapter.ListItemData();
    localListItemData.jdField_a_of_type_Int = paramInt1;
    localListItemData.b = paramInt2;
    localListItemData.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    return localListItemData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      UserInfo localUserInfo = (UserInfo)localIterator.next();
      if (localUserInfo.type == 0) {
        ((List)localObject).add(a(0, 0, localUserInfo));
      }
    }
    if (((List)localObject).size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 0, null));
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (UserInfo)paramList.next();
      if (((UserInfo)localObject).type == 1) {
        localArrayList.add(a(1, 1, (UserInfo)localObject));
      }
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1, null));
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    notifyDataSetChanged();
  }
  
  public void c(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserInfo localUserInfo = (UserInfo)paramList.next();
      if (localUserInfo.type == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 0, localUserInfo));
      } else if (localUserInfo.type == 1) {
        this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 1, localUserInfo));
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((PgcSearchResultAdapter.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      localObject = paramView;
      return localObject;
    case 2: 
      localObject = paramView;
      if (paramView == null) {
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970827, paramViewGroup, false);
      }
      paramView = ((View)localObject).findViewById(2131371988);
      if (paramInt > 0) {
        paramView.setVisibility(0);
      }
      for (;;)
      {
        paramView = (TextView)((View)localObject).findViewById(2131363378);
        if (((PgcSearchResultAdapter.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b != 0) {
          break;
        }
        paramView.setText("栏目");
        return localObject;
        if (paramInt == 0) {
          paramView.setVisibility(8);
        }
      }
      paramView.setText("认证帐号");
      return localObject;
    }
    UserInfo localUserInfo = ((PgcSearchResultAdapter.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970798, null);
      paramViewGroup = new nif(this, paramView);
      paramView.setTag(paramViewGroup);
      label186:
      localObject = a(localUserInfo.nick, this.jdField_a_of_type_JavaUtilList);
      if (localObject != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      paramViewGroup.b.setText(localUserInfo.desc);
      localObject = (BitmapDrawable)ImageUtil.a(localUserInfo.type);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if (!TextUtils.isEmpty(localUserInfo.headUrl))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestHeight = 100;
        localURLDrawableOptions.mRequestWidth = 100;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(ThumbnailUrlHelper.a(localUserInfo.headUrl), localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        if (localUserInfo.type != 1) {
          break label453;
        }
        ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(100, 100));
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      localObject = paramView;
      if (localUserInfo.type != 1) {
        break;
      }
      localObject = paramView;
      if (TextUtils.isEmpty(localUserInfo.authTypeIcon)) {
        break;
      }
      localObject = URLDrawable.getDrawable(localUserInfo.authTypeIcon, URLDrawable.URLDrawableOptions.obtain());
      if (((URLDrawable)localObject).getStatus() == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
      ((URLDrawable)localObject).setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return paramView;
      paramViewGroup = (nif)paramView.getTag();
      break label186;
      label453:
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(100, 100, 10));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.g);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.pgc.adapter.PgcSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */