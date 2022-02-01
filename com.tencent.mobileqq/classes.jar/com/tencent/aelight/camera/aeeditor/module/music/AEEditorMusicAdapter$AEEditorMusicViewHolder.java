package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ApolloLottieAnim;
import com.tencent.mobileqq.utils.ViewUtils;

class AEEditorMusicAdapter$AEEditorMusicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View a;
  private FrameLayout b;
  private ImageView c;
  private FrameLayout d;
  private ImageView e;
  private ImageView f;
  private AEDownLoadingView g;
  private TextView h;
  private DiniFlyAnimationView i;
  private ApolloLottieAnim j;
  private AEEditorMusicAdapter.ClickCallback k;
  private AEEditorMusicAdapter.AEEditorMusicInfo l;
  private int m;
  private final int n;
  
  public AEEditorMusicAdapter$AEEditorMusicViewHolder(@NonNull View paramView, @Nullable AEEditorMusicAdapter.ClickCallback paramClickCallback, int paramInt)
  {
    super(paramView);
    this.a = paramView;
    this.b = ((FrameLayout)paramView.findViewById(2063991357));
    this.c = ((ImageView)paramView.findViewById(2063991198));
    this.d = ((FrameLayout)paramView.findViewById(2063991089));
    this.e = ((ImageView)paramView.findViewById(2063991199));
    this.f = ((ImageView)paramView.findViewById(2063991194));
    this.g = ((AEDownLoadingView)paramView.findViewById(2063991328));
    this.h = ((TextView)paramView.findViewById(2063991548));
    this.i = ((DiniFlyAnimationView)paramView.findViewById(2063991012));
    this.j = new ApolloLottieAnim(null, paramView.getContext());
    this.b.setOnClickListener(this);
    this.k = paramClickCallback;
    this.n = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.setBgCorner(paramInt3 / 2);
    this.g.setMinimumHeight(paramInt3);
    this.g.setMinimumWidth(paramInt3);
    this.g.setProgressSizeAndMode(paramInt1, paramInt2, false);
    this.g.setBgColor(0);
    this.g.setProgressColor(-1);
    this.g.a(false);
  }
  
  void a()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.i;
    if ((localDiniFlyAnimationView != null) && (localDiniFlyAnimationView.getVisibility() == 0) && (!this.i.isAnimating())) {
      this.i.playAnimation();
    }
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2)
  {
    this.l = paramAEEditorMusicInfo;
    this.m = paramInt1;
    if ((paramAEEditorMusicInfo.f == 2) && (!TextUtils.isEmpty(paramAEEditorMusicInfo.g())))
    {
      this.c.setVisibility(0);
      UIUtils.a(this.c, paramAEEditorMusicInfo.g(), UIUtils.a(this.c.getContext(), this.n), UIUtils.a(this.c.getContext(), this.n), this.c.getContext().getResources().getDrawable(2130853651), null);
    }
    else
    {
      this.c.setVisibility(4);
    }
    Object localObject;
    if (paramAEEditorMusicInfo.c)
    {
      if (paramAEEditorMusicInfo.d == 1)
      {
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        if (paramAEEditorMusicInfo.e > 0)
        {
          this.f.setVisibility(0);
          this.g.setVisibility(0);
          this.g.setProgress(paramAEEditorMusicInfo.e);
        }
        else
        {
          this.f.setVisibility(8);
          this.g.setVisibility(8);
        }
        this.i.setVisibility(8);
      }
      else
      {
        this.d.setVisibility(0);
        this.d.setBackgroundResource(2130853652);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.i.setVisibility(0);
        if (this.j.a(AEEditorConstants.DIR_MUSIC_PLAYING_LOTTIE)) {
          this.j.a(this.a.getContext(), this.i, AEEditorConstants.DIR_MUSIC_PLAYING_LOTTIE, true);
        } else {
          this.j.a(this.i, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", AEEditorConstants.LOCAL_PATH_MUSIC_PLAYING_LOTTIE, true);
        }
      }
      this.h.setTextColor(-16777216);
      localObject = this.h;
      ((TextView)localObject).setTypeface(((TextView)localObject).getTypeface(), 1);
    }
    else
    {
      if (paramAEEditorMusicInfo.f == 0)
      {
        this.d.setVisibility(0);
        this.d.setBackgroundResource(2130853651);
        this.e.setVisibility(8);
        this.i.setVisibility(8);
      }
      else if (paramAEEditorMusicInfo.f == 1)
      {
        this.d.setVisibility(0);
        this.d.setBackgroundResource(2130853655);
        this.e.setVisibility(0);
        this.e.setImageResource(2130853664);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.i.setVisibility(8);
      }
      else if (paramAEEditorMusicInfo.f == 3)
      {
        this.d.setVisibility(4);
        this.d.setBackgroundResource(2130853651);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.i.setVisibility(8);
        this.c.setVisibility(0);
        this.c.setImageResource(2130853665);
      }
      else
      {
        if (paramAEEditorMusicInfo.d == 1)
        {
          this.d.setVisibility(4);
          if (paramAEEditorMusicInfo.e > 0)
          {
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            this.g.setProgress(paramAEEditorMusicInfo.e);
          }
          else
          {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
          }
        }
        else
        {
          this.d.setVisibility(8);
          this.f.setVisibility(8);
          this.g.setVisibility(8);
        }
        this.e.setVisibility(8);
        this.i.setVisibility(8);
      }
      this.h.setTextColor(-16777216);
      this.h.setTypeface(null, 0);
    }
    if (paramAEEditorMusicInfo.f == 1)
    {
      paramAEEditorMusicInfo = this.h.getContext().getString(2064187531);
    }
    else if (paramAEEditorMusicInfo.f == 3)
    {
      paramAEEditorMusicInfo = this.h.getContext().getString(2064187535);
    }
    else if (TextUtils.isEmpty(AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo)))
    {
      paramAEEditorMusicInfo = "";
    }
    else if (AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo).length() > 5)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo).substring(0, 5));
      ((StringBuilder)localObject).append("...");
      paramAEEditorMusicInfo = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramAEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo);
    }
    this.h.setText(paramAEEditorMusicInfo);
    paramAEEditorMusicInfo = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    if (paramInt1 == 0)
    {
      paramAEEditorMusicInfo.leftMargin = ViewUtils.dip2px(12.0F);
      paramAEEditorMusicInfo.rightMargin = (-ViewUtils.dip2px(4.0F));
    }
    else if (paramInt1 == paramInt2 - 1)
    {
      paramAEEditorMusicInfo.leftMargin = (-ViewUtils.dip2px(4.0F));
      paramAEEditorMusicInfo.rightMargin = ViewUtils.dip2px(12.0F);
    }
    else
    {
      paramAEEditorMusicInfo.leftMargin = (-ViewUtils.dip2px(4.0F));
      paramAEEditorMusicInfo.rightMargin = (-ViewUtils.dip2px(4.0F));
    }
    this.a.setLayoutParams(paramAEEditorMusicInfo);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2063991357)
    {
      paramView = this.l;
      if ((paramView != null) && (paramView.f != 0) && (this.k != null))
      {
        if (this.l.f != 1)
        {
          this.k.a(this.l, getAdapterPosition(), true ^ this.l.c, this.l.f);
          return;
        }
        if (!AEFastClickThrottle.a("tag_music_search_btn")) {
          this.k.a(this.l, getAdapterPosition(), true ^ this.l.c, this.l.f);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicViewHolder
 * JD-Core Version:    0.7.0.1
 */