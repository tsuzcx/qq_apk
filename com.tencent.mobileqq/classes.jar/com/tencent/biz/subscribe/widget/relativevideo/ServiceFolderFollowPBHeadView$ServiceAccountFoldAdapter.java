package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter
  extends RecyclerView.Adapter
  implements DecodeTaskCompletionListener
{
  private boolean a = false;
  private boolean b = true;
  private List<ServiceAccountFolderFeed> c;
  private Context d;
  private RecentFaceDecoder e;
  private HashMap<String, Bitmap> f = new HashMap();
  private RecyclerView g;
  private DragFrameLayout h;
  
  public ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.d = paramContext;
    this.g = paramRecyclerView;
    this.c = new ArrayList();
    this.e = new RecentFaceDecoder(((BaseActivity)paramContext).app, this, false);
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.2(this));
  }
  
  public void a()
  {
    this.g.addOnScrollListener(new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.1(this));
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.h = paramDragFrameLayout;
  }
  
  public void a(List<ServiceAccountFolderFeed> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = this.e;
    if (localObject != null) {
      ((RecentFaceDecoder)localObject).b();
    }
    if (this.h != null) {
      this.h = null;
    }
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ServiceFolderFollowPBHeadView.ServiceAccountViewHolder localServiceAccountViewHolder = (ServiceFolderFollowPBHeadView.ServiceAccountViewHolder)paramViewHolder;
    localServiceAccountViewHolder.a(this.a);
    localServiceAccountViewHolder.a((ServiceAccountFolderFeed)this.c.get(paramInt), paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ServiceFolderFollowPBHeadView.ServiceAccountViewHolder(LayoutInflater.from(this.d).inflate(2131625660, paramViewGroup, false), this.e, this.f, this.h);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      this.f.put(paramString, paramBitmap);
      paramBitmap = (LinearLayoutManager)this.g.getLayoutManager();
      paramInt1 = 0;
      while (paramInt1 < getItemCount())
      {
        Object localObject = paramBitmap.findViewByPosition(paramInt1);
        if (localObject != null)
        {
          localObject = this.g.getChildViewHolder((View)localObject);
          if ((localObject instanceof ServiceFolderFollowPBHeadView.ServiceAccountViewHolder))
          {
            localObject = (ServiceFolderFollowPBHeadView.ServiceAccountViewHolder)localObject;
            if (paramString.equals(((ServiceFolderFollowPBHeadView.ServiceAccountViewHolder)localObject).a.b))
            {
              ((ServiceFolderFollowPBHeadView.ServiceAccountViewHolder)localObject).a(ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.a((ServiceFolderFollowPBHeadView.ServiceAccountViewHolder)localObject), paramString);
              return;
            }
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter
 * JD-Core Version:    0.7.0.1
 */