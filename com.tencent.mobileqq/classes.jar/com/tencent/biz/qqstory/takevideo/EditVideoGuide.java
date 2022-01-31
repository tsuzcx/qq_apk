package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.StoryAddDescribeGuideDialog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import oex;
import oey;
import oez;
import ofa;
import ofb;

public class EditVideoGuide
  extends EditVideoPart
  implements View.OnClickListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AtomicBoolean a;
  private ofa jdField_a_of_type_Ofa;
  private ofb jdField_a_of_type_Ofb;
  public int b;
  
  public EditVideoGuide(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  private boolean a(int paramInt)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoGuide", "initTipGuide. guideType = %d", Integer.valueOf(paramInt));
    int j = -AIOUtils.a(1.0F, a().getResources());
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    switch (paramInt)
    {
    default: 
      SLog.e("Q.qqstory.publish.edit.EditVideoGuide", "initTipGuide error. unknown guideType = %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText("涂涂画画，圈点有趣");
      i = AIOUtils.a(12.0F, a().getResources());
      paramInt = 0;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.setMargins(i, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.setMargins(paramInt, 0, 0, j);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("有趣的贴纸都在这里");
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, k);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      paramInt = AIOUtils.a(114.0F, a().getResources());
      k = i / 2;
      i = AIOUtils.a(108.0F, a().getResources());
      paramInt -= k;
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("为视频添加一首背景音乐吧");
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, k);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      paramInt = AIOUtils.a(162.0F, a().getResources());
      k = i / 2;
      i = AIOUtils.a(156.0F, a().getResources());
      paramInt -= k;
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("尝试用地点贴纸标记你所在的位置");
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, k);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      paramInt = AIOUtils.a(114.0F, a().getResources());
      k = i / 2;
      i = AIOUtils.a(108.0F, a().getResources());
      paramInt -= k;
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("拖动视频片段以删除");
      paramInt = AIOUtils.a(15.0F, a());
      k = AIOUtils.a(12.0F, a());
      i = AIOUtils.a(12.0F, a());
      k = (ScreenUtil.jdField_a_of_type_Int - paramInt * 2 - k * 5) / 6;
      paramInt = AIOUtils.a(3.0F, a());
      i = paramInt + (k - i) / 2;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.setMargins(0, 0, 0, AIOUtils.a(161.0F, a()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean b()
  {
    return ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("has_show_fragment_guide", Boolean.valueOf(false))).booleanValue();
  }
  
  private void j()
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(500L);
    localAlphaAnimation1.setRepeatCount(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.05F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setRepeatCount(10);
    localTranslateAnimation.setRepeatMode(2);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(500L);
    localAlphaAnimation2.setRepeatCount(0);
    localAlphaAnimation2.setStartOffset(5000L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation2);
    localAnimationSet.setFillAfter(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localTranslateAnimation.setAnimationListener(new oez(this));
  }
  
  private void k()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 3: 
    case 6: 
      ((DoodleEmojiManager)SuperManager.a(8)).a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(6);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(2);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(7);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364419));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364421));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364420));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    boolean bool1 = EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.b, 32768);
    boolean bool2 = b();
    if ((!bool1) || (bool2))
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoGuide", "enableMultiVideoFragment = %s, hasShowFragmentGuide = %s.", Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      a(false);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    SLog.c("Q.qqstory.publish.edit.EditVideoGuide", "wait for fragment list message.");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
    }
    if (this.jdField_a_of_type_Ofb == null) {
      this.jdField_a_of_type_Ofb = new ofb(this, null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Ofb, 5000L);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = (StoryConfigManager)SuperManager.a(10);
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      h();
    case 0: 
    case 13: 
    case 10: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
    case 7: 
    case 5: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    StoryAddDescribeGuideDialog localStoryAddDescribeGuideDialog = new StoryAddDescribeGuideDialog(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a());
                    localStoryAddDescribeGuideDialog.a("点击屏幕可添加描述");
                    localStoryAddDescribeGuideDialog.show();
                    localStoryAddDescribeGuideDialog.setOnDismissListener(new oex(this));
                    paramObject.b("has_show_basal_guide", Boolean.valueOf(true));
                    StoryReportor.a("video_edit", "guide_txt", 0, 0, new String[0]);
                    return;
                    paramObject = new StoryNewGuideDialog(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a());
                    paramObject.a("左右滑动可添加滤镜效果");
                  } while (((Activity)a()).isFinishing());
                  paramObject.show();
                  paramObject.setOnDismissListener(new oey(this));
                  StoryReportor.a("video_edit", "guide_filter", 0, 0, new String[0]);
                  return;
                } while (!a(2));
                j();
                StoryReportor.a("video_edit", "guide_sticker", 0, 0, new String[0]);
                return;
              } while (!a(3));
              j();
              paramObject.b("has_show_music_guide", Boolean.valueOf(true));
              StoryReportor.a("video_edit", "guide_music", 0, 0, new String[0]);
              return;
            } while (!a(1));
            j();
            paramObject.b("has_show_draw_line_guide", Boolean.valueOf(true));
            StoryReportor.a("video_edit", "guide_graffiti", 0, 0, new String[0]);
            return;
          } while (!a(4));
          j();
          paramObject.b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
          StoryReportor.a("video_edit", "guide_place", 0, 0, new String[0]);
          return;
        } while (!a(5));
        j();
        paramObject.b("has_show_fragment_guide", Boolean.valueOf(true));
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 1) {
          paramObject.b("has_show_draw_line_guide", Boolean.valueOf(true));
        }
        h();
        return;
      } while (this.jdField_a_of_type_Int == 2);
      h();
      return;
    case 6: 
      i();
      h();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 1) {
      paramObject.b("has_show_music_guide", Boolean.valueOf(true));
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_Int = 8;
      this.b = 8;
      SLog.c("Q.qqstory.publish.edit.EditVideoGuide", "not story business, initial guideType = GUIDE_NULL.");
      return;
    }
    SLog.b("Q.qqstory.publish.edit.EditVideoGuide", "initGuideType. enableMultiFragment = %s.", Boolean.valueOf(paramBoolean));
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if ((paramBoolean) && (!((Boolean)localStoryConfigManager.b("has_show_fragment_guide", Boolean.valueOf(false))).booleanValue()))
    {
      this.jdField_a_of_type_Int = 7;
      this.b = 7;
      return;
    }
    if (!((Boolean)localStoryConfigManager.b("has_show_basal_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.jdField_a_of_type_Int = 1;
      this.b = 1;
      return;
    }
    paramBoolean = ((Boolean)localStoryConfigManager.b("has_show_music_guide", Boolean.valueOf(false))).booleanValue();
    AddressDataProvider localAddressDataProvider = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
    if ((!paramBoolean) && (!localAddressDataProvider.a((AddressDataProvider.AddressInfo)localAddressDataProvider.a())))
    {
      this.jdField_a_of_type_Int = 4;
      this.b = 4;
      return;
    }
    if (!((Boolean)localStoryConfigManager.b("has_show_draw_line_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.jdField_a_of_type_Int = 5;
      this.b = 5;
      return;
    }
    if (!((Boolean)localStoryConfigManager.b("has_show_add_poi_paster_guide", Boolean.valueOf(false))).booleanValue())
    {
      this.jdField_a_of_type_Int = 6;
      this.b = 6;
      return;
    }
    this.jdField_a_of_type_Int = 8;
    this.b = 8;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return super.a(paramMessage);
      SLog.b("Q.qqstory.publish.edit.EditVideoGuide", "handleEditVideoMessage. mWaitForFragmentMsg = %s.", Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false));
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_Ofb != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ofb);
      this.jdField_a_of_type_Ofb = null;
    }
    paramMessage = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (paramMessage != null) {}
    for (paramMessage = paramMessage.a();; paramMessage = null)
    {
      int i;
      if (paramMessage == null)
      {
        i = 0;
        int j = i;
        if (i > this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.c()) {
          j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.c();
        }
        if (j >= 2) {
          break label171;
        }
        a(false);
      }
      for (;;)
      {
        e();
        return true;
        i = paramMessage.size();
        break;
        label171:
        a(true);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_Ofa != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ofa);
        this.jdField_a_of_type_Ofa = null;
      }
      if (this.jdField_a_of_type_Ofb != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ofb);
        this.jdField_a_of_type_Ofb = null;
      }
    }
  }
  
  public void e()
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoGuide", "checkShowGuide. guideType = %d.", Integer.valueOf(this.jdField_a_of_type_Int));
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(24);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(13);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(15);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(16);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(17);
  }
  
  public void f()
  {
    super.f();
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      e();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Int != 8)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      this.jdField_a_of_type_Int = 8;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Int == 6) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
        }
        if (this.jdField_a_of_type_Ofa == null) {
          this.jdField_a_of_type_Ofa = new ofa(this);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Ofa, 200L);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoGuide
 * JD-Core Version:    0.7.0.1
 */