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
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private NewGuideNodeWidget.MyActivityLifeCycle jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetNewGuideNodeWidget$MyActivityLifeCycle;
  private PressEffectTextView jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
  private String c;
  
  public NewGuideNodeWidget(View paramView)
  {
    super(paramView);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((PressEffectTextView)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((localObject instanceof LinearLayout.LayoutParams)) {
      localObject = (LinearLayout.LayoutParams)localObject;
    } else {
      localObject = new LinearLayout.LayoutParams(-2, -2);
    }
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    float f;
    if (paramBoolean) {
      f = 10.0F;
    } else {
      f = 30.0F;
    }
    ((LinearLayout.LayoutParams)localObject).bottomMargin = UIUtils.a(localContext, f);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public String a()
  {
    return "NewGuideNodeWidget";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView = new PressEffectTextView(this.jdField_a_of_type_AndroidViewView.getContext(), null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setId(1001);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setPadding(UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 38.0F));
    localLayoutParams.bottomMargin = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 4.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    paramView = (RelativeLayout)paramView;
    paramView.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(1000);
    this.jdField_a_of_type_AndroidWidgetButton.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839293);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localLayoutParams = new RelativeLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 40.0F));
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(2, 1001);
    localLayoutParams.bottomMargin = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 10.0F);
    paramView.addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    a(true);
  }
  
  protected void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.jdField_a_of_type_JavaUtilList != null) && (!paramStoryPlayerVideoData.a.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramStoryPlayerVideoData = paramStoryPlayerVideoData.a.jdField_a_of_type_JavaUtilList.iterator();
      while (paramStoryPlayerVideoData.hasNext())
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramStoryPlayerVideoData.next();
        if (TextUtils.equals(paramStoryVideoItem.mVid, localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString))
        {
          Object localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
          int i = localMsgTabNodeVideoInfo.jdField_a_of_type_Int;
          Object localObject1 = null;
          if (i != 0) {
            paramStoryPlayerVideoData = localMsgTabNodeVideoInfo.c;
          } else {
            paramStoryPlayerVideoData = null;
          }
          ((Button)localObject2).setText(paramStoryPlayerVideoData);
          this.jdField_a_of_type_AndroidWidgetButton.setTag(localMsgTabNodeVideoInfo.d);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
          paramStoryPlayerVideoData = localObject1;
          if (localMsgTabNodeVideoInfo.b != 0) {
            paramStoryPlayerVideoData = localMsgTabNodeVideoInfo.e;
          }
          ((PressEffectTextView)localObject2).setText(paramStoryPlayerVideoData);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTag(localMsgTabNodeVideoInfo.f);
          i = localMsgTabNodeVideoInfo.b;
          boolean bool = true;
          if ((i != 0) && (!TextUtils.isEmpty(localMsgTabNodeVideoInfo.e))) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i != 0) && (!TextUtils.equals(this.c, paramStoryVideoItem.mVid)))
          {
            StoryReportor.a("play_video", "exp_all_tips", 0, 0, new String[0]);
            this.c = paramStoryVideoItem.mVid;
          }
          if ((localMsgTabNodeVideoInfo.b == 0) || (TextUtils.isEmpty(localMsgTabNodeVideoInfo.e))) {
            bool = false;
          }
          a(bool);
          j();
          return;
        }
      }
      this.c = paramStoryVideoItem.mVid;
      k();
      return;
    }
    this.c = paramStoryVideoItem.mVid;
    k();
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetNewGuideNodeWidget$MyActivityLifeCycle = new NewGuideNodeWidget.MyActivityLifeCycle(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetNewGuideNodeWidget$MyActivityLifeCycle);
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.jdField_a_of_type_Int == 13);
  }
  
  protected int b()
  {
    return -1;
  }
  
  protected void f() {}
  
  protected void g()
  {
    NewGuideNodeWidget.MyActivityLifeCycle localMyActivityLifeCycle = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetNewGuideNodeWidget$MyActivityLifeCycle;
    if (localMyActivityLifeCycle != null) {
      b(localMyActivityLifeCycle);
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, new Object[] { "onClick ", Integer.valueOf(paramView.getId()), ", url=", paramView.getTag() });
      }
      Object localObject = paramView.getTag();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        int i = paramView.getId();
        if (i != 1000)
        {
          if (i == 1001) {
            StoryReportor.a("play_video", "clk_all_tips", 0, 0, new String[] { localObject, "", "", this.c });
          }
        }
        else {
          StoryReportor.a("play_video", "clk_try", 0, 0, new String[] { localObject, "", "", this.c });
        }
        if (((String)localObject).startsWith("mqqapi:"))
        {
          localObject = JumpParser.a(QQStoryContext.a(), b(), (String)localObject);
          if (localObject != null) {
            ((JumpAction)localObject).a();
          }
        }
        else
        {
          Intent localIntent = new Intent(b(), QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject);
          b().startActivity(localIntent);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.NewGuideNodeWidget
 * JD-Core Version:    0.7.0.1
 */