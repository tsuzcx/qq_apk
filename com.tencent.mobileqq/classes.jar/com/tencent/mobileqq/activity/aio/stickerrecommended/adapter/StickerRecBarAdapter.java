package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDataUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerMvpDirector;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class StickerRecBarAdapter
  extends BaseAdapter
  implements IStickerMvpDirector
{
  public static final int a;
  public static final int b;
  public static final int c = d;
  private static int d;
  private List<IStickerRecEmoticon> e;
  private QBaseActivity f;
  private AppInterface g;
  private BaseSessionInfo h;
  private BaseAIOContext i;
  private ViewGroup j;
  private EditText k;
  private String l;
  private String m;
  private int n = 0;
  private String o;
  private StickerRecManagerImpl p;
  private EmotionKeywordHorizonListView q;
  private StickerDrawableDownloader r;
  private StickerRecViewModel s;
  
  static
  {
    int i1 = d;
    d = i1 + 1;
    a = i1;
    i1 = d;
    d = i1 + 1;
    b = i1;
  }
  
  public StickerRecBarAdapter(QBaseActivity paramQBaseActivity, AppInterface paramAppInterface, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup, EditText paramEditText, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
  {
    this.f = paramQBaseActivity;
    this.g = paramAppInterface;
    this.e = new ArrayList();
    this.i = paramBaseAIOContext;
    this.j = paramViewGroup;
    this.h = paramBaseAIOContext.O();
    this.k = paramEditText;
    this.p = StickerRecManagerImpl.get(paramAppInterface);
    this.q = paramEmotionKeywordHorizonListView;
    this.r = new StickerDrawableDownloader();
  }
  
  public IStickerView a(int paramInt, IStickerPresenter paramIStickerPresenter)
  {
    if (paramInt == a) {
      return new CommonStickerRecView(paramIStickerPresenter, this.f, this.i, this.j, this.k);
    }
    if (paramInt == b) {
      return new ApolloStickerRecView(paramIStickerPresenter, this.f, this.i, this.j, this.k, this.g);
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 111	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter:b	()V
    //   4: invokestatic 116	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/mvp/CommonStickerRecPresenter:f	()Ljava/util/List;
    //   7: astore_1
    //   8: invokestatic 122	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   11: new 124	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter$2
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 127	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter$2:<init>	(Lcom/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter;Ljava/util/List;)V
    //   20: invokevirtual 133	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   23: pop
    //   24: goto +17 -> 41
    //   27: astore_1
    //   28: goto +18 -> 46
    //   31: astore_1
    //   32: ldc 135
    //   34: iconst_1
    //   35: ldc 137
    //   37: aload_1
    //   38: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_0
    //   42: invokevirtual 144	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter:c	()V
    //   45: return
    //   46: aload_0
    //   47: invokevirtual 144	com/tencent/mobileqq/activity/aio/stickerrecommended/adapter/StickerRecBarAdapter:c	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	StickerRecBarAdapter
    //   7	10	1	localList	List
    //   27	1	1	localObject	Object
    //   31	20	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	24	27	finally
    //   32	41	27	finally
    //   0	24	31	java/lang/Throwable
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(StickerRecViewModel paramStickerRecViewModel)
  {
    this.s = paramStickerRecViewModel;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(List<IStickerRecEmoticon> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.s.b(false);
      QLog.e("StickerRecBarAdapter", 1, "setData");
      c();
      this.e.addAll(paramList);
      this.q.resetCurrentX(0);
      this.r.a(new StickerRecBarAdapter.1(this));
      this.r.a(this.e);
      notifyDataSetChanged();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData:");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.next();
          if ((localIStickerRecEmoticon != null) && (StickerRecManagerImpl.isStickerRecFromRemote(localIStickerRecEmoticon)))
          {
            localStringBuilder.append("thumb=");
            localStringBuilder.append(((StickerRecData)localIStickerRecEmoticon).f());
            localStringBuilder.append(",");
          }
        }
        QLog.d("StickerRecBarAdapter", 2, localStringBuilder.toString());
      }
      return;
    }
    QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = this.s.e();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject;
    if (this.n != 1)
    {
      localObject = this.p.preProcessUsrText(this.k.getText().toString());
      String str = ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).getSpecKeyWord(this.i);
      if (!TextUtils.isEmpty(str)) {
        localObject = str;
      }
      if ((paramBoolean) && (this.l.equalsIgnoreCase((String)localObject))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean)
    {
      localObject = this.i.g();
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69, this.o));
      }
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showEmotionKeywordLayout isshow = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("StickerRecBarAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public IStickerRecEmoticon b(int paramInt)
  {
    if (paramInt >= this.e.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get view position exception , position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",size = ");
      localStringBuilder.append(this.e.size());
      QLog.e("StickerRecBarAdapter", 2, localStringBuilder.toString());
      return null;
    }
    return (IStickerRecEmoticon)this.e.get(paramInt);
  }
  
  public void b()
  {
    if (this.e.size() > 0) {
      StickerRecManagerImpl.get(this.g).collectReportData(this.e, this.l, this.m, this.n);
    }
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public IStickerPresenter c(int paramInt)
  {
    if (paramInt == a) {
      return new CommonStickerRecPresenter(this.g, this.f, this.i, this.k);
    }
    if (paramInt == b) {
      return new ApolloStickerRecPresenter(this.g, this.f, this.i, this.k);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error presenter type:");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void c()
  {
    this.e.clear();
    CommonStickerRecPresenter.e();
    ApolloStickerRecPresenter.b();
  }
  
  public void c(String paramString)
  {
    this.m = paramString;
  }
  
  public int getCount()
  {
    List localList = this.e;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (StickerRecDataUtils.a(b(paramInt))) {
      return b;
    }
    return a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt >= this.e.size())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get view position exception , position = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",size = ");
      ((StringBuilder)localObject1).append(this.e.size());
      QLog.e("StickerRecBarAdapter", 2, ((StringBuilder)localObject1).toString());
      localObject1 = null;
      localObject2 = paramView;
    }
    else
    {
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)this.e.get(paramInt);
      StringBuilder localStringBuilder;
      if (paramView == null)
      {
        paramView = new StringBuilder();
        paramView.append("convertView is null, position:");
        paramView.append(paramInt);
        paramView.append(", model:");
        paramView.append(localIStickerRecEmoticon);
        QLog.d("StickerRecBarAdapter", 1, paramView.toString());
        localObject2 = c(getItemViewType(paramInt));
        localObject1 = a(getItemViewType(paramInt), (IStickerPresenter)localObject2);
        paramView = ((IStickerView)localObject1).c();
        paramView.setTag(localObject1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertView is null, view:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", presenter:");
        localStringBuilder.append(localObject2);
        QLog.d("StickerRecBarAdapter", 1, localStringBuilder.toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("convertView exist, position:");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", model:");
        ((StringBuilder)localObject1).append(localIStickerRecEmoticon);
        QLog.d("StickerRecBarAdapter", 1, ((StringBuilder)localObject1).toString());
        localObject1 = (IStickerView)paramView.getTag();
        localObject2 = ((IStickerView)localObject1).d();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertView exist, view:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", presenter:");
        localStringBuilder.append(localObject2);
        QLog.d("StickerRecBarAdapter", 1, localStringBuilder.toString());
      }
      ((IStickerPresenter)localObject2).a(this.l, this.n);
      ((IStickerPresenter)localObject2).a((IStickerView)localObject1, localIStickerRecEmoticon);
      localObject2 = paramView;
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter
 * JD-Core Version:    0.7.0.1
 */