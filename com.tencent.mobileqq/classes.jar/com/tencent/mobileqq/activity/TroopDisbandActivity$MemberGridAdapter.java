package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopDisbandActivity$MemberGridAdapter
  extends BaseAdapter
{
  protected List<String> a = new ArrayList();
  protected int b;
  
  public TroopDisbandActivity$MemberGridAdapter(TroopDisbandActivity paramTroopDisbandActivity)
  {
    this.a.add("0");
  }
  
  public void a()
  {
    if ((this.a.size() == 1) && (this.a.contains(this.c.v))) {
      return;
    }
    this.a.clear();
    this.a.add(this.c.v);
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(List<String> paramList)
  {
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      this.a.clear();
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }
  
  public void b(List<oidb_0x899.memberlist> paramList)
  {
    int j = 0;
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      this.a.clear();
      while (j < i)
      {
        Object localObject = (oidb_0x899.memberlist)paramList.get(j);
        if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()))
        {
          localObject = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
          if (!this.a.contains(localObject)) {
            this.a.add(localObject);
          }
        }
        j += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    int j = this.a.size();
    int i = j;
    if (j > 6) {
      i = 6;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    int i;
    if (paramView == null)
    {
      localImageView = new ImageView(this.c);
      i = this.b;
      localImageView.setLayoutParams(new AbsListView.LayoutParams(i, i));
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localImageView.setAdjustViewBounds(true);
      paramView = localImageView;
    }
    else
    {
      localImageView = (ImageView)paramView;
      localObject = localImageView.getLayoutParams();
      if (localObject != null)
      {
        i = this.b;
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = i;
      }
    }
    Object localObject = (String)getItem(paramInt);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("0"))) {
      localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.c.app, (String)localObject, (byte)3));
    } else {
      localImageView.setImageDrawable(ImageUtil.j());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.MemberGridAdapter
 * JD-Core Version:    0.7.0.1
 */