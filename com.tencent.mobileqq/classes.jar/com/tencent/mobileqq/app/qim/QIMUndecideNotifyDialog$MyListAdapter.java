package com.tencent.mobileqq.app.qim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

class QIMUndecideNotifyDialog$MyListAdapter
  extends XBaseAdapter
{
  List<QIMNotifyAddFriend> a = new ArrayList();
  LayoutInflater b;
  QQAppInterface c;
  Context d;
  int e = 0;
  int f = 0;
  
  public QIMUndecideNotifyDialog$MyListAdapter(QIMUndecideNotifyDialog paramQIMUndecideNotifyDialog, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.d = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramQQAppInterface;
    this.e = paramContext.getResources().getDimensionPixelOffset(2131298839);
    this.f = paramContext.getResources().getDimensionPixelOffset(2131298838);
  }
  
  public void a(List<QIMNotifyAddFriend> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QIMUndecideNotifyDialog.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = this.b.inflate(2131627197, null);
      localViewHolder = new QIMUndecideNotifyDialog.ViewHolder(this.g);
      localViewHolder.a = ((ImageView)paramView.findViewById(2131436366));
      localViewHolder.d = ((CheckBox)paramView.findViewById(2131430416));
      localViewHolder.b = ((TextView)paramView.findViewById(2131448606));
      localViewHolder.c = ((TextView)paramView.findViewById(2131448763));
      localViewHolder.e = ((LinearLayout)paramView.findViewById(2131437433));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (QIMUndecideNotifyDialog.ViewHolder)paramView.getTag();
    }
    QIMNotifyAddFriend localQIMNotifyAddFriend = (QIMNotifyAddFriend)getItem(paramInt);
    localViewHolder.d.setTag(localQIMNotifyAddFriend);
    localViewHolder.d.setOnCheckedChangeListener(this.g);
    localViewHolder.d.setChecked(this.g.c.contains(localQIMNotifyAddFriend));
    localViewHolder.a.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.c, String.valueOf(localQIMNotifyAddFriend.uin), (byte)3));
    localViewHolder.b.setText(localQIMNotifyAddFriend.nickName);
    localViewHolder.c.setText(localQIMNotifyAddFriend.wording);
    Object localObject1 = this.g.d.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localViewHolder.c.setText((CharSequence)localObject1);
    } else {
      localViewHolder.c.setVisibility(8);
    }
    if (localQIMNotifyAddFriend.videoInfos.size() > 0)
    {
      localViewHolder.e.removeAllViews();
      localViewHolder.e.setVisibility(0);
      localObject1 = new ArrayList();
      int i = 0;
      while (i < localQIMNotifyAddFriend.videoInfos.size())
      {
        Object localObject2 = (QIMNotifyAddFriend.VideoInfo)localQIMNotifyAddFriend.videoInfos.get(i);
        URLImageView localURLImageView = new URLImageView(this.d);
        localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ArrayList)localObject1).add(((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid);
        localURLImageView.setOnClickListener(new QIMUndecideNotifyDialog.MyListAdapter.1(this, (ArrayList)localObject1, ((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid));
        UIUtils.a(localURLImageView, ((QIMNotifyAddFriend.VideoInfo)localObject2).coverUrl, this.e, this.f, 8, new ColorDrawable(-1), "Qim_First_Login_Recommend");
        localObject2 = new LinearLayout.LayoutParams(this.e, this.f);
        if (localViewHolder.e.getChildCount() != 0) {
          ((LinearLayout.LayoutParams)localObject2).setMargins(AIOUtils.b(5.0F, this.d.getResources()), 0, 0, 0);
        }
        localViewHolder.e.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
    }
    localViewHolder.e.setVisibility(8);
    localViewHolder.f = localQIMNotifyAddFriend.uin;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMUndecideNotifyDialog.MyListAdapter
 * JD-Core Version:    0.7.0.1
 */