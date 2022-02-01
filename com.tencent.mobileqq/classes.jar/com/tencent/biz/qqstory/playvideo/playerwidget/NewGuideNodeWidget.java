package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewGuideNodeWidget
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private long s;
  private Button t;
  private PressEffectTextView u;
  private NewGuideNodeWidget.MyActivityLifeCycle v;
  private String w;
  
  public NewGuideNodeWidget(View paramView)
  {
    super(paramView);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.u;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((PressEffectTextView)localObject).setVisibility(i);
    localObject = this.b.getLayoutParams();
    if ((localObject instanceof LinearLayout.LayoutParams)) {
      localObject = (LinearLayout.LayoutParams)localObject;
    } else {
      localObject = new LinearLayout.LayoutParams(-2, -2);
    }
    Context localContext = this.b.getContext();
    float f;
    if (paramBoolean) {
      f = 10.0F;
    } else {
      f = 30.0F;
    }
    ((LinearLayout.LayoutParams)localObject).bottomMargin = UIUtils.a(localContext, f);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected void a(View paramView)
  {
    this.u = new PressEffectTextView(this.b.getContext(), null);
    this.u.setId(1001);
    this.u.setTextSize(1, 14.0F);
    this.u.setTextColor(-1);
    this.u.setPadding(UIUtils.a(this.b.getContext(), 82.5F), UIUtils.a(this.b.getContext(), 9.0F), UIUtils.a(this.b.getContext(), 82.5F), UIUtils.a(this.b.getContext(), 9.0F));
    this.u.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, UIUtils.a(this.b.getContext(), 38.0F));
    localLayoutParams.bottomMargin = UIUtils.a(this.b.getContext(), 4.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    paramView = (RelativeLayout)paramView;
    paramView.addView(this.u, localLayoutParams);
    this.t = new Button(this.b.getContext());
    this.t.setId(1000);
    this.t.setGravity(17);
    this.t.setTextSize(1, 17.0F);
    this.t.setTextColor(-1);
    this.t.setBackgroundResource(2130839473);
    this.t.setOnClickListener(this);
    localLayoutParams = new RelativeLayout.LayoutParams(UIUtils.a(this.b.getContext(), 220.0F), UIUtils.a(this.b.getContext(), 40.0F));
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(2, 1001);
    localLayoutParams.bottomMargin = UIUtils.a(this.b.getContext(), 10.0F);
    paramView.addView(this.t, localLayoutParams);
    a(true);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.v = new NewGuideNodeWidget.MyActivityLifeCycle(this);
    a(this.v);
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.b == 13);
  }
  
  protected void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.e != null) && (!paramStoryPlayerVideoData.a.e.isEmpty()))
    {
      paramStoryPlayerVideoData = paramStoryPlayerVideoData.a.e.iterator();
      while (paramStoryPlayerVideoData.hasNext())
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramStoryPlayerVideoData.next();
        if (TextUtils.equals(paramStoryVideoItem.mVid, localMsgTabNodeVideoInfo.c))
        {
          Object localObject2 = this.t;
          int i = localMsgTabNodeVideoInfo.g;
          Object localObject1 = null;
          if (i != 0) {
            paramStoryPlayerVideoData = localMsgTabNodeVideoInfo.h;
          } else {
            paramStoryPlayerVideoData = null;
          }
          ((Button)localObject2).setText(paramStoryPlayerVideoData);
          this.t.setTag(localMsgTabNodeVideoInfo.i);
          localObject2 = this.u;
          paramStoryPlayerVideoData = localObject1;
          if (localMsgTabNodeVideoInfo.j != 0) {
            paramStoryPlayerVideoData = localMsgTabNodeVideoInfo.k;
          }
          ((PressEffectTextView)localObject2).setText(paramStoryPlayerVideoData);
          this.u.setTag(localMsgTabNodeVideoInfo.l);
          i = localMsgTabNodeVideoInfo.j;
          boolean bool = true;
          if ((i != 0) && (!TextUtils.isEmpty(localMsgTabNodeVideoInfo.k))) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i != 0) && (!TextUtils.equals(this.w, paramStoryVideoItem.mVid)))
          {
            StoryReportor.a("play_video", "exp_all_tips", 0, 0, new String[0]);
            this.w = paramStoryVideoItem.mVid;
          }
          if ((localMsgTabNodeVideoInfo.j == 0) || (TextUtils.isEmpty(localMsgTabNodeVideoInfo.k))) {
            bool = false;
          }
          a(bool);
          z();
          return;
        }
      }
      this.w = paramStoryVideoItem.mVid;
      A();
      return;
    }
    this.w = paramStoryVideoItem.mVid;
    A();
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.s >= 500L)
    {
      this.s = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(t(), 2, new Object[] { "onClick ", Integer.valueOf(paramView.getId()), ", url=", paramView.getTag() });
      }
      Object localObject = paramView.getTag();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        int i = paramView.getId();
        if (i != 1000)
        {
          if (i == 1001) {
            StoryReportor.a("play_video", "clk_all_tips", 0, 0, new String[] { localObject, "", "", this.w });
          }
        }
        else {
          StoryReportor.a("play_video", "clk_try", 0, 0, new String[] { localObject, "", "", this.w });
        }
        if (((String)localObject).startsWith("mqqapi:"))
        {
          localObject = JumpParser.a(QQStoryContext.j(), y(), (String)localObject);
          if (localObject != null) {
            ((JumpAction)localObject).a();
          }
        }
        else
        {
          Intent localIntent = new Intent(y(), QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject);
          y().startActivity(localIntent);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void q() {}
  
  protected void r()
  {
    NewGuideNodeWidget.MyActivityLifeCycle localMyActivityLifeCycle = this.v;
    if (localMyActivityLifeCycle != null) {
      b(localMyActivityLifeCycle);
    }
  }
  
  protected int s()
  {
    return -1;
  }
  
  public String t()
  {
    return "NewGuideNodeWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.NewGuideNodeWidget
 * JD-Core Version:    0.7.0.1
 */