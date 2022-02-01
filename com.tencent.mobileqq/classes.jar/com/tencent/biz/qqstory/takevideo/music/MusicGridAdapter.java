package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class MusicGridAdapter
  extends BaseAdapter
{
  protected static int a;
  protected static int b;
  protected static int c;
  protected Context a;
  protected GridView a;
  protected QQStoryMusicInfo a;
  protected ArrayList<QQStoryMusicInfo> a;
  protected boolean a;
  protected ArrayList<QQStoryMusicInfo> b;
  
  public MusicGridAdapter(Context paramContext, GridView paramGridView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = null;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    jdField_a_of_type_Int = AIOUtils.b(80.0F, paramContext);
    jdField_b_of_type_Int = AIOUtils.b(10.0F, paramContext);
    c = AIOUtils.b(5.0F, paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList.add(QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    if (!paramBoolean1) {
      this.jdField_b_of_type_JavaUtilArrayList.add(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    }
    if (paramBoolean2) {
      this.jdField_b_of_type_JavaUtilArrayList.add(QQStoryMusicInfo.c);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public int a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.indexOf(paramQQStoryMusicInfo);
    }
    return -1;
  }
  
  public QQStoryMusicInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  }
  
  public void a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if ((localArrayList != null) && (localArrayList.contains(QQStoryMusicInfo.c)))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(QQStoryMusicInfo.c);
      this.jdField_b_of_type_JavaUtilArrayList.remove(QQStoryMusicInfo.c);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = paramQQStoryMusicInfo;
  }
  
  public void a(ArrayList<QQStoryMusicInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(0, this.jdField_b_of_type_JavaUtilArrayList);
    int i = getCount();
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
    paramArrayList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    paramArrayList.width = (jdField_a_of_type_Int * i + (i - 1) * jdField_b_of_type_Int + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight());
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(paramArrayList);
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)getItem(paramInt);
    View localView = null;
    int i;
    Object localObject2;
    Resources localResources;
    if (localQQStoryMusicInfo == null)
    {
      localObject1 = paramView;
    }
    else
    {
      if (paramView == null)
      {
        paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramView.setGravity(17);
        paramView.setSingleLine();
        paramView.setTextSize(12.0F);
        i = jdField_a_of_type_Int;
        paramView.setLayoutParams(new AbsListView.LayoutParams(i, i));
        i = c;
        paramView.setPadding(i, jdField_b_of_type_Int, i, 0);
        paramView.setEllipsize(TextUtils.TruncateAt.END);
        localView = paramView;
        localObject2 = paramView;
      }
      else
      {
        localObject2 = (TextView)paramView;
        localView = paramView;
      }
      ((TextView)localObject2).setText(localQQStoryMusicInfo.jdField_b_of_type_JavaLangString);
      if (localQQStoryMusicInfo.jdField_b_of_type_Int == 0)
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130846888, 0, 0);
        if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
          localObject2.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166522), PorterDuff.Mode.MULTIPLY);
        }
        ((TextView)localObject2).setTag(null);
      }
      else if (localQQStoryMusicInfo.jdField_b_of_type_Int == 1)
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130846892, 0, 0);
        if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
          localObject2.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166522), PorterDuff.Mode.MULTIPLY);
        }
        ((TextView)localObject2).setTag(null);
      }
      else if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130846885, 0, 0);
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        if ((paramView != null) && (paramView.jdField_b_of_type_Int == 2)) {
          localObject2.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166522), PorterDuff.Mode.MULTIPLY);
        }
        ((TextView)localObject2).setTag(null);
      }
      else if (localQQStoryMusicInfo.jdField_b_of_type_Int == 4)
      {
        i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 36.0F);
        if (localQQStoryMusicInfo.jdField_a_of_type_Int > 0)
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localQQStoryMusicInfo.jdField_a_of_type_Int);
          paramView.setBounds(0, 0, i, i);
          ((TextView)localObject2).setCompoundDrawables(null, paramView, null, null);
        }
        else
        {
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        }
      }
    }
    try
    {
      paramView = localQQStoryMusicInfo.g;
      if (TextUtils.isEmpty(paramView)) {
        break label609;
      }
      localFile = new File(paramView);
      if ((!localFile.exists()) || (!localFile.isFile())) {
        break label597;
      }
      long l = localFile.length();
      if (l <= 0L) {
        break label597;
      }
      try
      {
        paramView = FileUtils.getByte(localFile);
        if (paramView == null) {
          break label860;
        }
        localObject1 = Drawable.createFromStream(new ByteArrayInputStream(paramView), "voiceChangeIcon");
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        break label860;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        File localFile;
        continue;
        localObject1 = null;
        continue;
        boolean bool = false;
      }
    }
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mFailedDrawable = localResources.getDrawable(2130847706);
      paramView.mLoadingDrawable = localResources.getDrawable(2130847706);
      paramView = URLDrawable.getDrawable(localFile, paramView);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("drawable not null: ");
      ((StringBuilder)localObject1).append(paramView);
      if (((StringBuilder)localObject1).toString() == null) {
        break label866;
      }
      bool = true;
      QLog.e("blessVoiceIcon", 1, new Object[] { Boolean.valueOf(bool) });
      break label630;
      label597:
      paramView = localResources.getDrawable(2130847706);
      break label630;
      label609:
      paramView = localResources.getDrawable(2130847706);
      break label630;
      paramView = localResources.getDrawable(2130847706);
    }
    label630:
    paramView.setBounds(0, 0, i, i);
    ((TextView)localObject2).setCompoundDrawables(null, paramView, null, null);
    if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo))
    {
      localObject2.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166523), PorterDuff.Mode.SRC_ATOP);
      break label734;
      if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130846887, 0, 0);
      } else {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130846886, 0, 0);
      }
      ((TextView)localObject2).setTag(localQQStoryMusicInfo);
    }
    label734:
    if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo))
    {
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166522));
    }
    else
    {
      if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        if ((paramView != null) && (paramView.jdField_b_of_type_Int == 2))
        {
          ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166522));
          break label828;
        }
      }
      ((TextView)localObject2).setTextColor(-1);
      localObject2.getCompoundDrawables()[1].clearColorFilter();
    }
    label828:
    paramView = localView;
    localObject1 = localView;
    localView = paramView;
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter
 * JD-Core Version:    0.7.0.1
 */