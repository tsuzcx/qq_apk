package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SendPanelAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context a;
  private List<SendPanelItemInfo> b;
  private INonMainProcAvatarLoader c;
  private INonMainProcAvatarLoader d;
  private INonMainProcAvatarLoader e;
  private INonMainProcAvatarLoader f;
  private IHeaderUpdateListener g;
  private Bitmap h;
  private int i;
  private ConcurrentHashMap<Integer, URLDrawable> j = new ConcurrentHashMap();
  private SendPanelPart k;
  
  public SendPanelAdapter(Context paramContext, IHeaderUpdateListener paramIHeaderUpdateListener)
  {
    this.a = paramContext;
    this.g = paramIHeaderUpdateListener;
    this.h = ImageUtil.k();
    this.i = AIOUtils.b(40.0F, this.a.getResources());
    d();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getIconDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("SendPanelAdapter", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private void a(SendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder != null) && (paramSendPanelViewHolder.d != null))
    {
      paramSendPanelViewHolder.c.setStatus(paramSendPanelViewHolder.d.e);
      if (paramSendPanelViewHolder.d.e == 1) {
        paramSendPanelViewHolder.c.setProgress(paramSendPanelViewHolder.d.f);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.j.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramRecentDynamicAvatarView.setImageDrawable(paramString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "url  is null ");
      }
    }
  }
  
  private SendPanelItemInfo b(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.b;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SendPanelItemInfo localSendPanelItemInfo = (SendPanelItemInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localSendPanelItemInfo.a)) && (paramString.equals(localSendPanelItemInfo.a)) && (paramInt1 == localSendPanelItemInfo.d))
          {
            localSendPanelItemInfo.e = paramInt2;
            if (localSendPanelItemInfo.e == 1) {
              localSendPanelItemInfo.j = true;
            }
            return localSendPanelItemInfo;
          }
        }
      }
    }
    return null;
  }
  
  private void d()
  {
    this.c = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.a, 1);
    this.c.a();
    this.c.a(new SendPanelAdapter.1(this));
    this.d = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.a, 4);
    this.d.a();
    this.d.a(new SendPanelAdapter.2(this));
    this.e = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.a, 113);
    this.e.a();
    this.e.a(new SendPanelAdapter.3(this));
    this.f = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.a, 101);
    this.f.a();
    this.f.a(new SendPanelAdapter.4(this));
  }
  
  public void a(int paramInt, SendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder != null) && (paramSendPanelViewHolder.d != null))
    {
      SendPanelItemInfo localSendPanelItemInfo = paramSendPanelViewHolder.d;
      if ((localSendPanelItemInfo.h != null) && (!localSendPanelItemInfo.h.isRecycled()))
      {
        paramSendPanelViewHolder.a.setImageBitmap(localSendPanelItemInfo.h);
      }
      else
      {
        Object localObject;
        if (!TextUtils.isEmpty(localSendPanelItemInfo.g))
        {
          localObject = (URLDrawable)this.j.get(Integer.valueOf(paramInt));
          if (localObject != null)
          {
            paramSendPanelViewHolder.a.setImageDrawable((Drawable)localObject);
          }
          else
          {
            localObject = localSendPanelItemInfo.g;
            int m = this.i;
            a((String)localObject, m, m, paramSendPanelViewHolder.a, paramInt);
          }
        }
        else
        {
          localObject = this.h;
          if ((localSendPanelItemInfo.d != 0) && (localSendPanelItemInfo.d != 1000) && (localSendPanelItemInfo.d != 1004))
          {
            if (localSendPanelItemInfo.d == 1)
            {
              if (localSendPanelItemInfo.k) {
                localObject = this.e.a(localSendPanelItemInfo.a, true);
              } else {
                localObject = this.d.a(localSendPanelItemInfo.a, true);
              }
            }
            else if (localSendPanelItemInfo.d == 3000) {
              localObject = this.f.a(localSendPanelItemInfo.a, true);
            }
          }
          else {
            localObject = this.c.a(localSendPanelItemInfo.a, true);
          }
          if (localObject != null) {
            paramSendPanelViewHolder.a.setImageBitmap((Bitmap)localObject);
          }
        }
      }
      paramSendPanelViewHolder.b.setText(localSendPanelItemInfo.c);
      paramSendPanelViewHolder.c.setTag(paramSendPanelViewHolder);
      paramSendPanelViewHolder.c.setOnClickListener(this);
      a(paramSendPanelViewHolder);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
    }
  }
  
  public void a(int paramInt, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramInt >= 0)
    {
      List localList = this.b;
      if ((localList != null) && (paramInt <= localList.size()) && (paramSendPanelItemInfo != null))
      {
        this.b.set(paramInt, paramSendPanelItemInfo);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onUpdate return");
    }
  }
  
  public void a(SendPanelPart paramSendPanelPart)
  {
    this.k = paramSendPanelPart;
  }
  
  public void a(List<SendPanelItemInfo> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData list is empty");
      }
      return;
    }
    if ((this.b != null) && (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData do not need refresh");
      }
      return;
    }
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onEditUpdate");
    }
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (SendPanelItemInfo)this.b.get(0);
      if ((TextUtils.isEmpty(((SendPanelItemInfo)localObject).l)) && (TextUtils.isEmpty(((SendPanelItemInfo)localObject).n))) {
        return;
      }
      if (paramBoolean)
      {
        localObject = this.k;
        if (localObject != null) {
          CaptureReportUtil.c(((SendPanelPart)localObject).t);
        }
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SendPanelItemInfo)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > 0)) {
      return TextUtils.isEmpty(((SendPanelItemInfo)this.b.get(0)).l) ^ true;
    }
    return false;
  }
  
  public void b()
  {
    INonMainProcAvatarLoader localINonMainProcAvatarLoader = this.c;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.c();
    }
    localINonMainProcAvatarLoader = this.d;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.c();
    }
    localINonMainProcAvatarLoader = this.f;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.c();
    }
    a(false);
  }
  
  public void c()
  {
    ConcurrentHashMap localConcurrentHashMap = this.j;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      try
      {
        long l = Long.parseLong(((SendPanelItemInfo)this.b.get(paramInt)).a);
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getItemId exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("SendPanelAdapter", 2, localStringBuilder.toString());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SendPanelItemInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131629284, null);
      localSendPanelViewHolder = new SendPanelAdapter.SendPanelViewHolder(this);
      localSendPanelViewHolder.a = ((RecentDynamicAvatarView)paramView.findViewById(2131435219));
      localSendPanelViewHolder.b = ((TextView)paramView.findViewById(2131439121));
      localSendPanelViewHolder.c = ((QuickSendProgressView)paramView.findViewById(2131439644));
      localSendPanelViewHolder.d = paramViewGroup;
      a(paramInt, localSendPanelViewHolder);
      paramView.setTag(localSendPanelViewHolder);
      return paramView;
    }
    SendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder = (SendPanelAdapter.SendPanelViewHolder)paramView.getTag();
    localSendPanelViewHolder.d = paramViewGroup;
    a(paramInt, localSendPanelViewHolder);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof SendPanelAdapter.SendPanelViewHolder))
    {
      paramView = (SendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      if (paramView.d == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
        }
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onClick operateStatus = ");
        ((StringBuilder)localObject1).append(paramView.d.e);
        QLog.d("SendPanelAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      int m = paramView.d.e;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2) {
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(this.a))
          {
            paramView = this.a;
            QQToast.makeText(paramView, paramView.getString(2131916792), 0).show();
            return;
          }
          localObject1 = b(paramView.d.a, paramView.d.d, 1);
          if (localObject1 != null)
          {
            paramView.d = ((SendPanelItemInfo)localObject1);
            a(paramView);
            PeakIpcController.b((SendPanelItemInfo)localObject1);
          }
          paramView = this.k;
          if (paramView != null) {
            CaptureReportUtil.a(paramView.t, (SendPanelItemInfo)localObject1);
          }
        }
        else
        {
          localObject1 = b(paramView.d.a, paramView.d.d, 0);
          if (localObject1 != null)
          {
            paramView.d = ((SendPanelItemInfo)localObject1);
            a(paramView);
            PeakIpcController.a((SendPanelItemInfo)localObject1);
          }
          paramView = this.k;
          if (paramView != null) {
            CaptureReportUtil.b(paramView.t, (SendPanelItemInfo)localObject1);
          }
        }
      }
      else
      {
        if (!NetworkUtil.isNetworkAvailable(this.a))
        {
          paramView = this.a;
          QQToast.makeText(paramView, paramView.getString(2131916792), 0).show();
          return;
        }
        if (!TextUtils.isEmpty(paramView.d.n))
        {
          localObject1 = b(paramView.d.a, paramView.d.d, 1);
          if (localObject1 != null)
          {
            paramView.d = ((SendPanelItemInfo)localObject1);
            a(paramView);
            if (((SendPanelItemInfo)localObject1).i) {
              PeakIpcController.a(((SendPanelItemInfo)localObject1).l, ((SendPanelItemInfo)localObject1).m, (SendPanelItemInfo)localObject1, SendPanelManager.a().b, SendPanelManager.a().c());
            } else {
              PeakIpcController.a(((SendPanelItemInfo)localObject1).l, (SendPanelItemInfo)localObject1, SendPanelManager.a().b, SendPanelManager.a().c());
            }
          }
          Object localObject2 = this.k;
          if (localObject2 != null) {
            CaptureReportUtil.c(((SendPanelPart)localObject2).t, (SendPanelItemInfo)localObject1);
          }
          localObject2 = (IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class);
          paramView = paramView.d.n;
          if (localObject1 == null) {
            m = -1;
          } else {
            m = ((SendPanelItemInfo)localObject1).d;
          }
          ((IAEBaseDataReporter)localObject2).reportPostBtn(paramView, m);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("【OnClick】messageType:");
          if (localObject1 == null) {
            paramView = "-1";
          } else {
            paramView = Integer.valueOf(((SendPanelItemInfo)localObject1).d);
          }
          ((StringBuilder)localObject2).append(paramView);
          AEQLog.b("SendPanelAdapter", ((StringBuilder)localObject2).toString());
          return;
        }
        ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
        this.k.t.a(20, paramView.d);
        this.k.t.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelAdapter
 * JD-Core Version:    0.7.0.1
 */