package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.Hashtable;

public abstract class CharDividedFacePreloadBaseAdapter
  extends PinnedDividerListView.DividerAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private XListView a;
  private boolean b;
  private boolean c;
  private int d = 0;
  private Hashtable<String, Bitmap> e = new Hashtable();
  protected Bitmap n = null;
  protected IFaceDecoder o;
  
  public CharDividedFacePreloadBaseAdapter(Context paramContext, AppInterface paramAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.a = paramXListView;
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.setOnScrollListener(this);
    }
    this.c = paramBoolean;
    this.o = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.o.setDecodeTaskCompletionListener(this);
    if (this.n == null) {
      this.n = BaseImageUtil.k();
    }
  }
  
  protected Bitmap a(String paramString)
  {
    return a(paramString, 1, (byte)0);
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    return a(paramString, 1, (byte)0, paramInt);
  }
  
  public Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    return a(paramString, paramInt, paramByte, 0);
  }
  
  public Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Bitmap localBitmap = this.o.getBitmapFromCacheFrom(paramInt1, paramString, paramInt2);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.b)
    {
      this.o.cancelPendingRequests();
      this.b = false;
    }
    if (!this.o.isPausing()) {
      this.o.requestDecodeFace(paramString, paramInt1, true, paramByte);
    }
    return this.n;
  }
  
  protected boolean a(FacePreloadHolder.ViewHolder paramViewHolder)
  {
    return (paramViewHolder != null) && (paramViewHolder.y != null) && (paramViewHolder.y.length() > 0);
  }
  
  public void d()
  {
    IFaceDecoder localIFaceDecoder = this.o;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    this.a = null;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.b;
    paramInt2 = 0;
    if (bool)
    {
      if (paramInt1 == 0) {
        this.b = false;
      }
    }
    else
    {
      if (paramBitmap != null) {
        this.e.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        if (this.d == 0)
        {
          paramString = this.a;
          if (paramString != null)
          {
            int i = paramString.getChildCount();
            paramInt1 = paramInt2;
            while (paramInt1 < i)
            {
              paramString = this.a.getChildAt(paramInt1).getTag();
              if ((paramString != null) && ((paramString instanceof FacePreloadHolder.ViewHolder)))
              {
                paramString = (FacePreloadHolder.ViewHolder)paramString;
                if (a(paramString))
                {
                  paramBitmap = (Bitmap)this.e.get(paramString.y);
                  if (paramBitmap != null) {
                    paramString.A.setImageBitmap(paramBitmap);
                  }
                }
              }
              paramInt1 += 1;
            }
          }
        }
        this.e.clear();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    if (paramInt != 0)
    {
      this.b = false;
      this.o.cancelPendingRequests();
      this.o.pause();
      return;
    }
    if (this.o.isPausing()) {
      this.o.resume();
    }
    paramAbsListView = this.a;
    if (paramAbsListView != null)
    {
      int i = paramAbsListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = (FacePreloadHolder.ViewHolder)this.a.getChildAt(paramInt).getTag();
        if (a(paramAbsListView)) {
          paramAbsListView.A.setImageBitmap(a(paramAbsListView.y, paramAbsListView.z, (byte)0));
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter
 * JD-Core Version:    0.7.0.1
 */