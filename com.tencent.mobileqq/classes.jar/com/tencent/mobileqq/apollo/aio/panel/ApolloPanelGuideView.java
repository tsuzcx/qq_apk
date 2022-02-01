package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelGuideView
  extends RelativeLayout
  implements View.OnClickListener
{
  private ApolloLinearLayoutNoPreview a;
  private LinearLayout b;
  private List<ApolloInfo> c;
  private int d = 0;
  private TextView e;
  private Button f;
  private RelativeLayout g;
  private RoundRectLinearLayout h;
  private ApolloPanelGuideView.ClickCallback i;
  
  public ApolloPanelGuideView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ApolloPanelGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloPanelGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.d == 0)
    {
      this.e.setText("试试有趣的3D形象");
      this.f.setText("使用3D形象");
    }
    else
    {
      this.e.setText("和好友一起来玩厘米秀吧！");
      this.f.setText("开启厘米秀");
    }
    int j = 0;
    while (j < this.b.getChildCount())
    {
      ViewGroup localViewGroup = (ViewGroup)this.b.getChildAt(j);
      ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localViewGroup.getTag();
      if (j < this.c.size())
      {
        localViewGroup.setVisibility(0);
        localViewHolder.j = ((ApolloInfo)this.c.get(j));
        ApolloActionData localApolloActionData = localViewHolder.j.mAction;
        localViewHolder.j.mBinderType = 0;
        localViewHolder.c.setText(localApolloActionData.actionName);
        localViewHolder.b.setBackgroundDrawable(localViewHolder.j.getPanelDrawable(getContext(), getContext().getResources().getDisplayMetrics().density));
        localViewHolder.m.setBackgroundDrawable(null);
        localViewHolder.l.setVisibility(8);
        localViewHolder.n.setVisibility(8);
        localViewHolder.m.setVisibility(8);
        if (localViewHolder.o != null)
        {
          localViewGroup.removeView(localViewHolder.o);
          localViewHolder.o = null;
        }
      }
      else
      {
        localViewGroup.setVisibility(4);
        localViewHolder.j = null;
        localViewHolder.b.setBackgroundDrawable(null);
      }
      j += 1;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ApolloInfo)((Iterator)localObject).next()).mAction.actionId == paramApolloActionData.actionId) {
        post(new ApolloPanelGuideView.1(this));
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public int getGuideType()
  {
    return this.d;
  }
  
  public void onClick(View paramView)
  {
    if (this.i == null) {
      return;
    }
    int j = paramView.getId();
    if (j != 2131435536)
    {
      if (j != 2131446677) {
        return;
      }
      this.i.b(this);
      return;
    }
    this.i.a(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131435536).setOnClickListener(this);
    this.f = ((Button)findViewById(2131446677));
    this.f.setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131427566);
    this.e = ((TextView)findViewById(2131434513));
    this.a = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.a, -1, -2);
    this.b = ((LinearLayout)this.a.getChildAt(0));
    this.g = ((RelativeLayout)findViewById(2131447731));
    this.h = ((RoundRectLinearLayout)findViewById(2131429674));
    this.h.setRoundRect(ViewUtils.dip2px(6.0F), -10205955, false);
  }
  
  public void setActions(List<ApolloInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.c = paramList;
    a();
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.a.setCallback(paramBaseChatPie);
  }
  
  public void setClickCallback(ApolloPanelGuideView.ClickCallback paramClickCallback)
  {
    this.i = paramClickCallback;
  }
  
  public void setGuideType(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.a.setSessionInfo(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelGuideView
 * JD-Core Version:    0.7.0.1
 */