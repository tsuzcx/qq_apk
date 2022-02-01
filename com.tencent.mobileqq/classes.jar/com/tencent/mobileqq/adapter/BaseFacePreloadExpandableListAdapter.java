package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public abstract class BaseFacePreloadExpandableListAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private final Context a;
  private final QQAppInterface b;
  private IFaceDecoder c = null;
  protected ExpandableListView n = null;
  
  public BaseFacePreloadExpandableListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.n = paramExpandableListView;
    this.c = ((IQQAvatarService)this.b.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.b);
    this.c.setDecodeTaskCompletionListener(this);
    ImageUtil.k();
  }
  
  protected void a(FacePreloadHolder.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap, true);
  }
  
  protected void a(FacePreloadHolder.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.A == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramViewHolder.y))
    {
      paramViewHolder.A.setBackgroundResource(2130845599);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramViewHolder.y))
    {
      paramViewHolder.A.setBackgroundResource(2130845594);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramViewHolder.y))
    {
      paramViewHolder.A.setBackgroundResource(2130845602);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramViewHolder.y))
    {
      paramViewHolder.A.setBackgroundResource(2130839779);
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.c.getBitmapFromCache(paramViewHolder.z, paramViewHolder.y);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.k();
      }
      paramBitmap = localBitmap;
      if (!this.c.isPausing())
      {
        this.c.requestDecodeFace(paramViewHolder.y, paramViewHolder.z, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.A.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.n.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.n.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof FacePreloadHolder.ViewHolder)))
      {
        localObject = (FacePreloadHolder.ViewHolder)localObject;
        if (paramString == null)
        {
          a((FacePreloadHolder.ViewHolder)localObject, null, false);
        }
        else if (paramString.equals(((FacePreloadHolder.ViewHolder)localObject).y))
        {
          ((FacePreloadHolder.ViewHolder)localObject).A.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
          return;
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    IFaceDecoder localIFaceDecoder = this.c;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void configHeaderView(View paramView, int paramInt) {}
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return null;
  }
  
  public int getGroupCount()
  {
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 0;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.c.isPausing()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.c.cancelPendingRequests();
      this.c.pause();
      return;
    }
    if (this.c.isPausing())
    {
      this.c.cancelPendingRequests();
      this.c.resume();
      a(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */