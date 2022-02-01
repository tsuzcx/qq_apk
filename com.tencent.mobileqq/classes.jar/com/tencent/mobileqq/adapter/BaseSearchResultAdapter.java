package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface.SearchResultCallBack;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSearchResultAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener, SearchTask.SearchTaskCallBack, AbsListView.OnScrollListener
{
  boolean a = false;
  protected SearchAdapterInterface.SearchResultCallBack b = null;
  private XListView c;
  private int d = 0;
  private IFaceDecoder e;
  private List<? extends ISearchable> f;
  private List<ISearchable> g;
  private SearchTask h = null;
  
  public BaseSearchResultAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends ISearchable> paramList)
  {
    this.c = paramXListView;
    this.c.setOnScrollListener(this);
    this.e = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.e.setDecodeTaskCompletionListener(this);
    this.f = paramList;
    this.g = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.e.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.e.isPausing()) {
      this.e.requestDecodeFace(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return ImageUtil.k();
    }
    if (paramInt == 101) {
      return ImageUtil.i();
    }
    if (paramInt == 4) {
      return ImageUtil.g();
    }
    if (paramInt == 11) {
      return ImageUtil.c();
    }
    if (paramInt == 110) {
      return ImageUtil.o();
    }
    if (paramInt == 111) {
      return ImageUtil.p();
    }
    return ImageUtil.k();
  }
  
  public void a()
  {
    List localList = this.g;
    if (localList != null)
    {
      localList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<? extends ISearchable> paramList)
  {
    this.g.clear();
    this.g.addAll(paramList);
    paramList.clear();
    paramList = this.b;
    if (paramList != null) {
      paramList.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<? extends ISearchable> paramList)
  {
    this.g.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(BaseSearchResultAdapter.ViewHolder paramViewHolder)
  {
    return (paramViewHolder != null) && (!TextUtils.isEmpty(paramViewHolder.a));
  }
  
  public void b()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((SearchTask)localObject).cancel(true);
    }
    localObject = this.e;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.c = null;
  }
  
  public int getCount()
  {
    List localList = this.g;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.g;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.g.get(paramInt);
    }
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.e.isPausing())
    {
      paramInt1 = this.d;
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        int i = this.c.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          Object localObject = this.c.getChildAt(paramInt1).getTag();
          if ((localObject != null) && ((localObject instanceof BaseSearchResultAdapter.ViewHolder)))
          {
            localObject = (BaseSearchResultAdapter.ViewHolder)localObject;
            if ((localObject != null) && (!TextUtils.isEmpty(((BaseSearchResultAdapter.ViewHolder)localObject).a)) && (((BaseSearchResultAdapter.ViewHolder)localObject).a.equals(paramString)) && (paramInt2 == ((BaseSearchResultAdapter.ViewHolder)localObject).b))
            {
              ((BaseSearchResultAdapter.ViewHolder)localObject).c.setImageBitmap(paramBitmap);
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.c == null) {
      return;
    }
    this.d = paramInt;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.e.cancelPendingRequests();
      this.e.pause();
      return;
    }
    if (this.e.isPausing()) {
      this.e.resume();
    }
    int i = this.c.getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      paramAbsListView = this.c.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && ((paramAbsListView instanceof BaseSearchResultAdapter.ViewHolder)))
      {
        paramAbsListView = (BaseSearchResultAdapter.ViewHolder)paramAbsListView;
        if (a(paramAbsListView)) {
          paramAbsListView.c.setImageBitmap(a(paramAbsListView.a, paramAbsListView.b));
        }
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */