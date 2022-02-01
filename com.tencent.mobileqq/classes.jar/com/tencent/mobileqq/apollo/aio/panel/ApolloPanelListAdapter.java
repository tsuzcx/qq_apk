package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import mqq.app.AppRuntime;

public class ApolloPanelListAdapter
  extends BaseAdapter
{
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private List<ApolloInfo> a;
  private Context b;
  private SessionInfo c;
  private AppRuntime d;
  private ApolloManagerServiceImpl e;
  private IApolloResManager f;
  private BaseChatPie g;
  private int h = -1;
  private int i = 4;
  private int j;
  
  public ApolloPanelListAdapter(AppRuntime paramAppRuntime, Context paramContext)
  {
    this.d = paramAppRuntime;
    this.b = paramContext;
    if (paramAppRuntime != null) {
      this.e = ((ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all"));
    }
    this.f = ApolloResManagerFacade.a.a(Scene.AIO);
  }
  
  private void a(ApolloLinearLayout paramApolloLinearLayout, int paramInt)
  {
    if (paramApolloLinearLayout == null) {
      return;
    }
    paramApolloLinearLayout.a();
    paramApolloLinearLayout.setSessionInfo(this.c);
    paramApolloLinearLayout.setCallback(this.g);
    LinearLayout localLinearLayout = (LinearLayout)paramApolloLinearLayout.getChildAt(0);
    paramApolloLinearLayout = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    if (paramApolloLinearLayout != null)
    {
      if (paramInt == 0)
      {
        if (this.j != 4) {
          paramApolloLinearLayout.topMargin = ViewUtils.dip2px(16.0F);
        } else {
          paramApolloLinearLayout.topMargin = 0;
        }
        paramApolloLinearLayout.bottomMargin = 0;
      }
      if (paramInt == getCount() - 1) {
        paramApolloLinearLayout.bottomMargin = ViewUtils.dip2px(16.0F);
      }
      if ((paramInt > 0) && (paramInt < getCount() - 1))
      {
        paramApolloLinearLayout.topMargin = ViewUtils.dip2px(10.0F);
        paramApolloLinearLayout.bottomMargin = 0;
      }
    }
    int i4 = this.i;
    int i1 = 0;
    while (i1 < this.i)
    {
      View localView = localLinearLayout.getChildAt(i1);
      ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localView.getTag();
      int i3 = paramInt * i4 + i1;
      if (i3 < this.a.size())
      {
        localView.setVisibility(0);
        paramApolloLinearLayout = ((ApolloInfo)this.a.get(i3)).mAction;
        localViewHolder.b.setVisibility(0);
        localViewHolder.j = ((ApolloInfo)this.a.get(i3));
        if (this.j == 4) {
          localViewHolder.a.setBackgroundResource(2130838614);
        }
        Object localObject3;
        if (localViewHolder.j.mType == 1)
        {
          if (this.d != null)
          {
            localObject1 = new RedTouch(this.b, localViewHolder.b).c(5).a();
            ((RedTouch)localObject1).a(((IRedTouchManager)this.d.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103200"));
            localViewHolder.b.setBackgroundResource(2130838616);
            localViewHolder.k = ((RedTouch)localObject1);
          }
        }
        else if (localViewHolder.j.mType == 2)
        {
          localViewHolder.b.setBackgroundResource(2130838583);
        }
        else
        {
          if (((ApolloInfo)this.a.get(i3)).mAction.isForPlayerAction == 1) {
            QLog.i("[cmshow]ApolloPanelListAdapter", 4, "setBackgroundDrawable getview");
          }
          localObject1 = localViewHolder.b;
          localObject2 = (ApolloInfo)this.a.get(i3);
          localObject3 = this.b;
          ((ImageView)localObject1).setBackgroundDrawable(((ApolloInfo)localObject2).getPanelDrawable((Context)localObject3, ((Context)localObject3).getResources().getDisplayMetrics().density));
        }
        localViewHolder.c.setText(paramApolloLinearLayout.actionName);
        if (this.j != 4) {
          localViewHolder.j.mBinderType = 0;
        }
        if ((this.j != 2) && (!TextUtils.isEmpty(paramApolloLinearLayout.iconUrl)))
        {
          localViewHolder.d.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(String.valueOf(paramApolloLinearLayout.iconUrl.hashCode()), null, paramApolloLinearLayout.iconUrl, true));
          localViewHolder.d.setVisibility(0);
        }
        if (!TextUtils.isEmpty(localViewHolder.j.mActionText))
        {
          if (XPanelContainer.d == 0) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          localViewHolder.l.setVisibility(0);
          localViewHolder.n.setVisibility(0);
          localViewHolder.m.setVisibility(0);
          localViewHolder.l.setText(localViewHolder.j.mActionText);
          float f1;
          if (i2 != 0) {
            f1 = 3.0F;
          } else {
            f1 = 5.0F;
          }
          int i5 = ViewUtils.dip2px(f1);
          localObject1 = (RelativeLayout.LayoutParams)localViewHolder.n.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = i5;
          int i6 = ApolloLinearLayout.a;
          int i7 = i5 * 2;
          ((RelativeLayout.LayoutParams)localObject1).width = (i6 - i7);
          localViewHolder.l.setMaxHeight(ApolloLinearLayout.a - i5 * 3);
          localObject1 = (RelativeLayout.LayoutParams)localViewHolder.l.getLayoutParams();
          if (i2 != 0) {
            f1 = 2.0F;
          } else {
            f1 = 5.0F;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.dip2px(f1);
          localViewHolder.m.setBackgroundResource(2130838453);
          if (localViewHolder.j.mTextType == 1)
          {
            if (i2 != 0)
            {
              localViewHolder.l.setTextSize(8.0F);
              if (m == 0) {
                m = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = m;
            }
            else
            {
              localViewHolder.l.setMaxHeight(ApolloLinearLayout.a - i7);
              localViewHolder.l.setTextSize(12.0F);
              if (k == 0) {
                k = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = k;
            }
            localViewHolder.l.setTextColor(-4473925);
            localViewHolder.n.setBackgroundDrawable(null);
          }
          else
          {
            if (i2 != 0)
            {
              localViewHolder.l.setTextSize(7.0F);
              if (n == 0) {
                n = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = n;
            }
            else
            {
              localViewHolder.l.setTextSize(10.0F);
              if (l == 0) {
                l = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = l;
            }
            localObject1 = localViewHolder.l;
            if (i2 != 0) {
              f1 = 7.0F;
            } else {
              f1 = 10.0F;
            }
            ((TextView)localObject1).setTextSize(f1);
            localViewHolder.l.setTextColor(-8947849);
            localViewHolder.n.setBackgroundResource(2130838454);
          }
          localObject1 = localViewHolder.n;
          if (i2 != 0) {
            f1 = 3.0F;
          } else {
            f1 = 9.0F;
          }
          ((RelativeLayout)localObject1).setPadding(0, 0, 0, ViewUtils.dip2px(f1));
          localViewHolder.l.setMaxLines(3);
        }
        else
        {
          localViewHolder.m.setBackgroundDrawable(null);
          localViewHolder.l.setVisibility(8);
          localViewHolder.n.setVisibility(8);
          localViewHolder.m.setVisibility(8);
        }
        ApolloLinearLayout.setApolloActionIcon(localViewHolder.j.iconType, localViewHolder.j.mAction, localViewHolder);
        if ((paramApolloLinearLayout.personNum == 1) && ((this.c.a == 1) || (this.c.a == 3000))) {
          localViewHolder.h.setVisibility(0);
        }
        Object localObject1 = (RelativeLayout)localView;
        int i2 = this.h;
        if ((i2 != -1) && (i2 == i3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanelListAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.h), ", name=", paramApolloLinearLayout.actionName, ",id=", Integer.valueOf(paramApolloLinearLayout.actionId) });
          }
          if (localViewHolder.o != null)
          {
            ((RelativeLayout)localObject1).removeView(localViewHolder.o);
            localViewHolder.o = null;
          }
          localObject3 = new RelativeLayout.LayoutParams(-1, -1);
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131429021);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131429021);
          ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131429021);
          ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131429021);
          localObject2 = new RelativeLayout(this.b);
          ((RelativeLayout)localObject2).setId(2131428429);
          ((RelativeLayout)localObject2).setBackgroundDrawable(null);
          ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localViewHolder.o = ((View)localObject2);
          localObject3 = new ImageView(this.b);
          ((ImageView)localObject3).setImageResource(2130838611);
          ((ImageView)localObject3).setVisibility(8);
          ((RelativeLayout)localObject2).addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
          ((ImageView)localObject3).postDelayed(new ApolloPanelListAdapter.1(this, (ImageView)localObject3, (RelativeLayout)localObject2, (RelativeLayout)localObject1, localViewHolder), 200L);
          this.h = -1;
        }
        else if (localViewHolder.o != null)
        {
          ((RelativeLayout)localObject1).removeView(localViewHolder.o);
          localViewHolder.o = null;
        }
        Object localObject2 = paramApolloLinearLayout;
        localObject1 = ((ApolloActionData)localObject2).actionName;
        paramApolloLinearLayout = (ApolloLinearLayout)localObject1;
        if (((ApolloActionData)localObject2).hasSound)
        {
          paramApolloLinearLayout = new StringBuilder();
          paramApolloLinearLayout.append((String)localObject1);
          paramApolloLinearLayout.append(",有音效");
          paramApolloLinearLayout = paramApolloLinearLayout.toString();
        }
        localView.setContentDescription(paramApolloLinearLayout);
        if ((((ApolloInfo)this.a.get(i3)).mAction != null) && (((ApolloInfo)this.a.get(i3)).mAction.isForPlayerAction == 1)) {
          a(localViewHolder, (ApolloInfo)this.a.get(i3));
        }
      }
      else
      {
        localView.setContentDescription(null);
        localView.setOnClickListener(null);
        localView.setVisibility(4);
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.c = paramSessionInfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.g = paramBaseChatPie;
  }
  
  public void a(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ApolloPanelListAdapter handleMemeGetFrame : ");
    ((StringBuilder)localObject).append(paramApolloInfo.toString());
    QLog.d("[cmshow]ApolloPanelListAdapter", 4, ((StringBuilder)localObject).toString());
    localObject = this.e;
    if (localObject != null)
    {
      ((ApolloManagerServiceImpl)localObject).handleMemeGetFrame("ApolloPanelListAdapter", paramApolloInfo.mAction, new ApolloPanelListAdapter.FrameCallback(paramViewHolder, paramApolloInfo, this.b), this.f);
      return;
    }
    paramViewHolder = new StringBuilder();
    paramViewHolder.append("ApolloPanelListAdapter handleMemeGetFrame error!mApolloManager is null! ");
    paramViewHolder.append(paramApolloInfo);
    QLog.e("[cmshow]ApolloPanelListAdapter", 1, paramViewHolder.toString());
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int getCount()
  {
    List localList = this.a;
    int i1;
    if (localList != null)
    {
      int i2 = localList.size() / this.i;
      i1 = i2;
      if (this.a.size() % this.i != 0) {
        return i2 + 1;
      }
    }
    else
    {
      i1 = 0;
    }
    return i1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = new ApolloLinearLayout(this.b, null, this.j, this.i, 1);
    }
    a((ApolloLinearLayout)paramViewGroup, paramInt);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter
 * JD-Core Version:    0.7.0.1
 */