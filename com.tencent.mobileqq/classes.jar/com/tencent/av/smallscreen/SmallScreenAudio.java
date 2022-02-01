package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GuildInfo;

public class SmallScreenAudio
  extends SmallScreenItemBase
{
  protected int a;
  protected View a;
  protected ImageView a;
  protected TextView a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public SmallScreenAudio(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = "SmallScreenAudio";
    paramContext = paramContext.getResources();
    this.i = 2131559887;
    this.j = paramContext.getDimensionPixelSize(2131297967);
    this.k = paramContext.getDimensionPixelSize(2131297961);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2131297968);
    this.b = paramContext.getDimensionPixelSize(2131297962);
    this.c = paramContext.getDimensionPixelSize(2131297963);
    this.d = paramContext.getDimensionPixelSize(2131297965);
    this.e = paramContext.getDimensionPixelSize(2131297964);
    this.f = paramContext.getDimensionPixelSize(2131297966);
    this.g = paramContext.getDimensionPixelSize(2131297959);
    this.h = paramContext.getDimensionPixelSize(2131297960);
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    super.a(paramContext, paramLayoutInflater, paramFloatListener);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setTitleHeight(paramContext.getDimensionPixelSize(2131299166) * 5 / 2);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131374080));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131374055));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130772188);
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((paramContext instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramContext).start();
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131373801);
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    Object localObject1;
    Object localObject2;
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      localObject1 = ((SmallScreenService)paramBaseSmallScreenService).a;
      localObject2 = SessionMgr.a().a();
      if ((localObject1 == null) || (!((VideoController)localObject1).l()) || (((SessionInfo)localObject2).a == null) || (((SessionInfo)localObject2).a.b == null) || (!((SessionInfo)localObject2).a.b.equals("1"))) {}
    }
    for (int i = 1;; i = 0)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (paramBaseSmallScreenService.f)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
        if (i != 0) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842440);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.c;
          ((RelativeLayout.LayoutParams)localObject1).topMargin = this.d;
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.g;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
          return;
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842437);
        }
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.b);
      if (i != 0) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842441);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.e;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = this.f;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.h;
        break;
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842439);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenAudio
 * JD-Core Version:    0.7.0.1
 */