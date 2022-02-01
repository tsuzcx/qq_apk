package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.ApolloTagButtonData;
import com.tencent.mobileqq.apollo.utils.ApolloActionUsedManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloTagActionViewBinder
  extends ApolloSecondaryViewBinder
{
  private ConcurrentHashMap<String, List<ApolloInfo>> A;
  private List<ApolloInfo> B;
  private ApolloTagActionViewBinder.OnTagUpdateListener C;
  private Handler D;
  private IApolloExtensionObserver E = new ApolloTagActionViewBinder.5(this);
  String h = CmShowWnsUtils.ak();
  private HorizontalListView t;
  private ApolloTagActionViewBinder.ApolloActionTagsAdapter u;
  private View v;
  private TextView w;
  private List<ApolloTagButtonData> x;
  private List<Integer> y;
  private List<String> z;
  
  public ApolloTagActionViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    f();
  }
  
  private void c(List<ApolloInfo> paramList)
  {
    ApolloTagActionViewBinder.OnTagUpdateListener localOnTagUpdateListener = this.C;
    if (localOnTagUpdateListener != null)
    {
      localOnTagUpdateListener.a(paramList);
      return;
    }
    d(paramList);
  }
  
  private void d(List<ApolloInfo> paramList)
  {
    b(paramList);
    if (this.s != null) {
      this.s.notifyDataSetChanged();
    }
  }
  
  public View a()
  {
    View localView = super.a();
    if (this.j != null) {
      this.j.addObserver(this.E);
    }
    if (this.k == 0) {
      a(this.r);
    }
    return localView;
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
  }
  
  public void a(ApolloPanelListView paramApolloPanelListView)
  {
    if (paramApolloPanelListView != null)
    {
      View localView = g();
      if ((localView != null) && (localView.getParent() == null) && (paramApolloPanelListView.findHeaderViewPosition(localView) == -1)) {
        paramApolloPanelListView.addHeaderView(localView);
      }
    }
  }
  
  public void a(ApolloTagActionViewBinder.OnTagUpdateListener paramOnTagUpdateListener)
  {
    this.C = paramOnTagUpdateListener;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionWithTagsViewBinder", 4, "getTagAction.");
    }
    if (!paramBoolean)
    {
      paramString = this.w;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        if (this.r != null) {
          this.r.removeHeaderView(this.w);
        }
      }
      c(this.B);
      return;
    }
    try
    {
      if ((this.A != null) && (this.A.get(paramString) != null) && (((List)this.A.get(paramString)).size() > 0))
      {
        c((List)this.A.get(paramString));
        return;
      }
      if (this.h.equals(paramString))
      {
        paramString = ApolloActionUsedManager.a(this.j);
        if (paramString == null) {
          return;
        }
        Object localObject = paramString.a(this.n);
        if ((localObject != null) && (((List)localObject).size() >= 1))
        {
          paramString = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            int i = ((Integer)((Iterator)localObject).next()).intValue();
            Iterator localIterator = this.B.iterator();
            while (localIterator.hasNext())
            {
              ApolloInfo localApolloInfo = (ApolloInfo)localIterator.next();
              if ((localApolloInfo != null) && (i == localApolloInfo.mAction.actionId)) {
                paramString.add(localApolloInfo);
              }
            }
          }
          c(paramString);
          return;
        }
        ThreadManagerV2.executeOnSubThread(new ApolloTagActionViewBinder.3(this, paramString));
        return;
      }
      ThreadManagerV2.executeOnSubThread(new ApolloTagActionViewBinder.4(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloActionWithTagsViewBinder", 1, paramString, new Object[0]);
    }
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    super.a(paramList);
    if (paramList != null) {
      this.B.addAll(paramList);
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.y;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.A;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
    localObject = this.B;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.z;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    if (this.j != null) {
      this.j.removeObserver(this.E);
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.D.post(new ApolloTagActionViewBinder.6(this, paramString));
    }
  }
  
  public void b(List<ApolloInfo> paramList)
  {
    if (this.o == null) {
      return;
    }
    this.o.clear();
    if (paramList != null) {
      this.o.addAll(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    HorizontalListView localHorizontalListView = this.t;
    if (localHorizontalListView == null) {
      return;
    }
    if (paramBoolean)
    {
      localHorizontalListView.setVisibility(0);
      return;
    }
    localHorizontalListView.setVisibility(8);
  }
  
  public void f()
  {
    this.A = new ConcurrentHashMap();
    this.B = new ArrayList();
    this.x = new ArrayList();
    this.D = new Handler(Looper.getMainLooper());
  }
  
  @NonNull
  public View g()
  {
    View localView = this.v;
    if (localView != null) {
      return localView;
    }
    if (this.i == null) {
      return null;
    }
    this.v = View.inflate(this.i, 2131624180, null);
    localView = this.v;
    if (localView != null) {
      this.t = ((HorizontalListView)localView.findViewById(2131435141));
    }
    ThreadManagerV2.executeOnSubThread(new ApolloTagActionViewBinder.1(this));
    return this.v;
  }
  
  public void h()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ApolloTagActionViewBinder.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder
 * JD-Core Version:    0.7.0.1
 */