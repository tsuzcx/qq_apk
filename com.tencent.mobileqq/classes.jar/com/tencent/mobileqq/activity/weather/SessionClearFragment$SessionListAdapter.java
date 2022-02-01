package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.messageclean.CleanMessageItemInfo;
import com.tencent.mobileqq.app.message.messageclean.FileCleanUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionClearFragment$SessionListAdapter
  extends RecyclerView.Adapter<SessionClearFragment.SessionHolder>
{
  List<CleanMessageItemInfo> a;
  Map<String, Integer> b = new HashMap();
  
  public SessionClearFragment$SessionListAdapter(List<CleanMessageItemInfo> paramList)
  {
    Object localObject;
    this.a = localObject;
  }
  
  public int a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return ((Integer)this.b.get(paramString)).intValue();
    }
    return -1;
  }
  
  public SessionClearFragment.SessionHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onCreateViewHolder");
    }
    paramViewGroup = SessionClearFragment.c(this.c).getLayoutInflater().inflate(2131629278, paramViewGroup, false);
    return new SessionClearFragment.SessionHolder(this.c, paramViewGroup);
  }
  
  public CleanMessageItemInfo a(int paramInt)
  {
    return (CleanMessageItemInfo)this.a.get(paramInt);
  }
  
  public void a()
  {
    SessionClearFragment.b(this.c, 0);
    SessionClearFragment.c(this.c, 0);
    int i = 0;
    boolean bool = false;
    Object localObject;
    while (i < this.a.size())
    {
      if (((CleanMessageItemInfo)this.a.get(i)).g)
      {
        localObject = this.c;
        SessionClearFragment.b((SessionClearFragment)localObject, (int)(SessionClearFragment.h((SessionClearFragment)localObject) + ((CleanMessageItemInfo)this.a.get(i)).d));
        SessionClearFragment.o(this.c);
        bool = true;
      }
      i += 1;
    }
    if (SessionClearFragment.h(this.c) == 0)
    {
      SessionClearFragment.p(this.c).setVisibility(8);
    }
    else
    {
      SessionClearFragment.p(this.c).setVisibility(0);
      localObject = SessionClearFragment.p(this.c);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131911269));
      localStringBuilder.append(FileCleanUtils.a(SessionClearFragment.h(this.c)));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    if (SessionClearFragment.g(this.c) == this.a.size()) {
      SessionClearFragment.d(this.c, 1);
    } else {
      SessionClearFragment.d(this.c, 0);
    }
    SessionClearFragment.q(this.c).setEnabled(bool);
  }
  
  public void a(SessionClearFragment.SessionHolder paramSessionHolder, int paramInt)
  {
    CleanMessageItemInfo localCleanMessageItemInfo = a(paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindViewHolder info uin=");
      ((StringBuilder)localObject).append(localCleanMessageItemInfo.a);
      ((StringBuilder)localObject).append(" pos=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SessionClearFragment", 2, ((StringBuilder)localObject).toString());
    }
    paramSessionHolder.c.setText(localCleanMessageItemInfo.b);
    paramSessionHolder.d.setText(localCleanMessageItemInfo.e);
    if ((localCleanMessageItemInfo.i != null) && (!localCleanMessageItemInfo.i.isRecycled()))
    {
      paramSessionHolder.b.setImageBitmap(localCleanMessageItemInfo.i);
    }
    else if (localCleanMessageItemInfo.h != null)
    {
      SessionClearFragment.a(this.c, localCleanMessageItemInfo.h, 80, 80, paramSessionHolder.b, paramInt);
    }
    else
    {
      localObject = SessionClearFragment.k(this.c);
      this.b.put(localCleanMessageItemInfo.a, Integer.valueOf(paramInt));
      if ((localCleanMessageItemInfo.c != 0) && (localCleanMessageItemInfo.c != 1000) && (localCleanMessageItemInfo.c != 1004))
      {
        if (localCleanMessageItemInfo.c == 1) {
          localObject = SessionClearFragment.m(this.c).a(localCleanMessageItemInfo.a, true);
        } else if (localCleanMessageItemInfo.c == 3000) {
          localObject = SessionClearFragment.n(this.c).a(localCleanMessageItemInfo.a, true);
        }
      }
      else {
        localObject = SessionClearFragment.l(this.c).a(localCleanMessageItemInfo.a, true);
      }
      if (localObject != null) {
        paramSessionHolder.b.setImageBitmap((Bitmap)localObject);
      }
    }
    if (((CleanMessageItemInfo)this.a.get(paramInt)).g) {
      paramSessionHolder.a.setChecked(true);
    } else {
      paramSessionHolder.a.setChecked(false);
    }
    paramSessionHolder.itemView.setOnClickListener(new SessionClearFragment.SessionListAdapter.1(this, paramSessionHolder, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramSessionHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    int i = a(paramString1);
    if (i >= 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateImage  uin: ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" pos =");
        localStringBuilder.append(i);
        QLog.i("SessionClearFragment", 4, localStringBuilder.toString());
      }
      SessionClearFragment.d(this.c).a(i).h = paramString2;
      SessionClearFragment.d(this.c).a(i).i = paramBitmap;
      SessionClearFragment.d(this.c).notifyItemChanged(i);
    }
  }
  
  public void a(List<CleanMessageItemInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setList sessionList size=");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("SessionClearFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((CleanMessageItemInfo)this.a.get(i)).g = true;
      i += 1;
    }
    notifyDataSetChanged();
    a();
    ReportController.b(null, "dc00898", "", "", "0X800A0C6", "0X800A0C6", 0, 0, String.valueOf(SessionClearFragment.g(this.c)), String.valueOf(SessionClearFragment.h(this.c)), "", "");
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((CleanMessageItemInfo)this.a.get(i)).g = false;
      i += 1;
    }
    notifyDataSetChanged();
    a();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.SessionListAdapter
 * JD-Core Version:    0.7.0.1
 */