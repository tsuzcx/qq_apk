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
    jdField_a_of_type_Int = AIOUtils.a(80.0F, paramContext);
    jdField_b_of_type_Int = AIOUtils.a(10.0F, paramContext);
    c = AIOUtils.a(5.0F, paramContext);
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramQQStoryMusicInfo);
    }
    return -1;
  }
  
  public QQStoryMusicInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  }
  
  public void a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(QQStoryMusicInfo.c))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(QQStoryMusicInfo.c);
        this.jdField_b_of_type_JavaUtilArrayList.remove(QQStoryMusicInfo.c);
        i = 1;
      }
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
    int j = jdField_a_of_type_Int;
    paramArrayList.width = ((i - 1) * jdField_b_of_type_Int + j * i + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight());
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(paramArrayList);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    Object localObject1;
    if (localQQStoryMusicInfo == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(12.0F);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(jdField_a_of_type_Int, jdField_a_of_type_Int));
      localTextView.setPadding(c, jdField_b_of_type_Int, c, 0);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localObject1 = localTextView;
      label116:
      localTextView.setText(localQQStoryMusicInfo.jdField_b_of_type_JavaLangString);
      if (localQQStoryMusicInfo.jdField_b_of_type_Int != 0) {
        break label234;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847010, 0, 0);
      if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
        localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166508), PorterDuff.Mode.MULTIPLY);
      }
      localTextView.setTag(null);
      label187:
      if (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
        break label786;
      }
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166508));
    }
    for (;;)
    {
      paramView = (View)localObject1;
      break;
      localTextView = (TextView)paramView;
      localObject1 = paramView;
      break label116;
      label234:
      if (localQQStoryMusicInfo.jdField_b_of_type_Int == 1)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847014, 0, 0);
        if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
          localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166508), PorterDuff.Mode.MULTIPLY);
        }
        localTextView.setTag(null);
        break label187;
      }
      if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847007, 0, 0);
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 2)) {
          localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166508), PorterDuff.Mode.MULTIPLY);
        }
        localTextView.setTag(null);
        break label187;
      }
      Resources localResources;
      if (localQQStoryMusicInfo.jdField_b_of_type_Int == 4)
      {
        paramView = null;
        int i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 36.0F);
        if (localQQStoryMusicInfo.jdField_a_of_type_Int > 0)
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localQQStoryMusicInfo.jdField_a_of_type_Int);
          paramView.setBounds(0, 0, i, i);
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
        for (;;)
        {
          if (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
            break label681;
          }
          localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509), PorterDuff.Mode.SRC_ATOP);
          break;
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
          for (;;)
          {
            try
            {
              localObject2 = localQQStoryMusicInfo.g;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                continue;
              }
              localFile = new File((String)localObject2);
              if ((!localFile.exists()) || (!localFile.isFile())) {
                continue;
              }
              long l = localFile.length();
              if (l <= 0L) {
                continue;
              }
            }
            catch (Exception paramView)
            {
              Object localObject2;
              File localFile;
              byte[] arrayOfByte;
              View localView;
              paramView = localResources.getDrawable(2130847839);
              continue;
              boolean bool = false;
              continue;
              paramView = localResources.getDrawable(2130847839);
              continue;
              paramView = localResources.getDrawable(2130847839);
              continue;
            }
            try
            {
              arrayOfByte = FileUtils.b(localFile);
              localObject2 = paramView;
              if (arrayOfByte != null) {
                localObject2 = Drawable.createFromStream(new ByteArrayInputStream(arrayOfByte), "voiceChangeIcon");
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localView = paramView;
            }
          }
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = URLDrawable.URLDrawableOptions.obtain();
            paramView.mFailedDrawable = localResources.getDrawable(2130847839);
            paramView.mLoadingDrawable = localResources.getDrawable(2130847839);
            paramView = URLDrawable.getDrawable(localFile, paramView);
            if ("drawable not null: " + paramView == null) {
              break label709;
            }
            bool = true;
            QLog.e("blessVoiceIcon", 1, new Object[] { Boolean.valueOf(bool) });
          }
          paramView.setBounds(0, 0, i, i);
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
        label681:
        break label187;
      }
      label709:
      if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847009, 0, 0);
      }
      for (;;)
      {
        localTextView.setTag(localQQStoryMusicInfo);
        break;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847008, 0, 0);
      }
      label786:
      if ((localQQStoryMusicInfo.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 2))
      {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166508));
      }
      else
      {
        localTextView.setTextColor(-1);
        localTextView.getCompoundDrawables()[1].clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter
 * JD-Core Version:    0.7.0.1
 */