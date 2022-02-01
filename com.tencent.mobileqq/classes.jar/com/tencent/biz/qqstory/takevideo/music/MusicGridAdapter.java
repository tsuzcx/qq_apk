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
  protected static int g;
  protected static int h;
  protected static int i;
  protected Context a = null;
  protected ArrayList<QQStoryMusicInfo> b = null;
  protected ArrayList<QQStoryMusicInfo> c = null;
  protected QQStoryMusicInfo d = null;
  protected GridView e = null;
  protected boolean f = false;
  
  public MusicGridAdapter(Context paramContext, GridView paramGridView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramContext;
    this.e = paramGridView;
    this.f = paramBoolean1;
    paramContext = this.a.getResources();
    g = AIOUtils.b(80.0F, paramContext);
    h = AIOUtils.b(10.0F, paramContext);
    i = AIOUtils.b(5.0F, paramContext);
    this.e.setColumnWidth(g);
    this.c = new ArrayList();
    this.c.add(QQStoryMusicInfo.a);
    if (!paramBoolean1) {
      this.c.add(QQStoryMusicInfo.b);
    }
    if (paramBoolean2) {
      this.c.add(QQStoryMusicInfo.c);
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = this.b;
    int j;
    if ((localArrayList != null) && (localArrayList.contains(QQStoryMusicInfo.c)))
    {
      this.b.remove(QQStoryMusicInfo.c);
      this.c.remove(QQStoryMusicInfo.c);
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (j != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    this.d = paramQQStoryMusicInfo;
  }
  
  public void a(ArrayList<QQStoryMusicInfo> paramArrayList)
  {
    this.b = new ArrayList();
    if (paramArrayList != null) {
      this.b.addAll(paramArrayList);
    }
    this.b.addAll(0, this.c);
    int j = getCount();
    this.e.setNumColumns(j);
    paramArrayList = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    paramArrayList.width = (g * j + (j - 1) * h + this.e.getPaddingLeft() + this.e.getPaddingRight());
    this.e.setLayoutParams(paramArrayList);
  }
  
  public int b()
  {
    return this.c.size();
  }
  
  public int b(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      return localArrayList.indexOf(paramQQStoryMusicInfo);
    }
    return -1;
  }
  
  public QQStoryMusicInfo c()
  {
    return this.d;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.b;
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
    int j;
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
        paramView = new TextView(this.a);
        paramView.setGravity(17);
        paramView.setSingleLine();
        paramView.setTextSize(12.0F);
        j = g;
        paramView.setLayoutParams(new AbsListView.LayoutParams(j, j));
        j = i;
        paramView.setPadding(j, h, j, 0);
        paramView.setEllipsize(TextUtils.TruncateAt.END);
        localView = paramView;
        localObject2 = paramView;
      }
      else
      {
        localObject2 = (TextView)paramView;
        localView = paramView;
      }
      ((TextView)localObject2).setText(localQQStoryMusicInfo.e);
      if (localQQStoryMusicInfo.k == 0)
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130848440, 0, 0);
        if (localQQStoryMusicInfo.equals(this.d)) {
          localObject2.getCompoundDrawables()[1].setColorFilter(this.a.getResources().getColor(2131167379), PorterDuff.Mode.MULTIPLY);
        }
        ((TextView)localObject2).setTag(null);
      }
      else if (localQQStoryMusicInfo.k == 1)
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130848444, 0, 0);
        if (localQQStoryMusicInfo.equals(this.d)) {
          localObject2.getCompoundDrawables()[1].setColorFilter(this.a.getResources().getColor(2131167379), PorterDuff.Mode.MULTIPLY);
        }
        ((TextView)localObject2).setTag(null);
      }
      else if (localQQStoryMusicInfo.k == 2)
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130848437, 0, 0);
        paramView = this.d;
        if ((paramView != null) && (paramView.k == 2)) {
          localObject2.getCompoundDrawables()[1].setColorFilter(this.a.getResources().getColor(2131167379), PorterDuff.Mode.MULTIPLY);
        }
        ((TextView)localObject2).setTag(null);
      }
      else if (localQQStoryMusicInfo.k == 4)
      {
        j = (int)DisplayUtils.a(this.a, 36.0F);
        if (localQQStoryMusicInfo.j > 0)
        {
          paramView = this.a.getResources().getDrawable(localQQStoryMusicInfo.j);
          paramView.setBounds(0, 0, j, j);
          ((TextView)localObject2).setCompoundDrawables(null, paramView, null, null);
        }
        else
        {
          localResources = this.a.getResources();
        }
      }
    }
    try
    {
      paramView = localQQStoryMusicInfo.m;
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
      paramView.mFailedDrawable = localResources.getDrawable(2130849366);
      paramView.mLoadingDrawable = localResources.getDrawable(2130849366);
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
      paramView = localResources.getDrawable(2130849366);
      break label630;
      label609:
      paramView = localResources.getDrawable(2130849366);
      break label630;
      paramView = localResources.getDrawable(2130849366);
    }
    label630:
    paramView.setBounds(0, 0, j, j);
    ((TextView)localObject2).setCompoundDrawables(null, paramView, null, null);
    if (localQQStoryMusicInfo.equals(this.d))
    {
      localObject2.getCompoundDrawables()[1].setColorFilter(this.a.getResources().getColor(2131167380), PorterDuff.Mode.SRC_ATOP);
      break label734;
      if (localQQStoryMusicInfo.equals(this.d)) {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130848439, 0, 0);
      } else {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 2130848438, 0, 0);
      }
      ((TextView)localObject2).setTag(localQQStoryMusicInfo);
    }
    label734:
    if (localQQStoryMusicInfo.equals(this.d))
    {
      ((TextView)localObject2).setTextColor(this.a.getResources().getColor(2131167379));
    }
    else
    {
      if (localQQStoryMusicInfo.k == 2)
      {
        paramView = this.d;
        if ((paramView != null) && (paramView.k == 2))
        {
          ((TextView)localObject2).setTextColor(this.a.getResources().getColor(2131167379));
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