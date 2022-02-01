package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class GuideInfoDialog
  extends ReportDialog
{
  private ImageView a;
  private TextView b;
  private Button c;
  private Button d;
  private ImageView e;
  private VideoView f;
  private RelativeLayout g;
  private String h;
  private int i = -1;
  private Drawable j;
  private String k;
  private String l;
  private String m;
  private View.OnClickListener n;
  private View.OnClickListener o;
  private View.OnClickListener p;
  private boolean q;
  private boolean r;
  private String s;
  
  public GuideInfoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.s))
    {
      this.f.setVisibility(0);
      this.f.setVideoPath(this.s);
      this.f.setZOrderOnTop(true);
      this.f.start();
      return;
    }
    this.f.setVisibility(8);
  }
  
  private void b()
  {
    if ((this.q) && (!TextUtils.isEmpty(this.h)))
    {
      this.a.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "story_rename_guide";
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = UIUtils.a(getContext(), 3.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.a(getContext(), 155.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.a(getContext(), 307.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
      if (this.r)
      {
        localObject = URLDrawable.getDrawable(new File(this.h), (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).restartDownload();
        }
        this.a.setImageDrawable((Drawable)localObject);
        return;
      }
      localObject = URLDrawable.getDrawable(this.h, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.a.setImageDrawable((Drawable)localObject);
      return;
    }
    if (!TextUtils.isEmpty(this.h))
    {
      this.a.setVisibility(0);
      UIUtils.a(this.a, this.h, UIUtils.a(getContext(), 307.0F), UIUtils.a(getContext(), 155.0F), new RoundedTransformation(UIUtils.a(getContext(), 4.0F), 0, 0.504886F, null, null));
      return;
    }
    if (this.i != -1)
    {
      this.a.setVisibility(0);
      this.a.setImageResource(this.i);
      return;
    }
    if (this.j != null)
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(8);
  }
  
  public GuideInfoDialog a(View.OnClickListener paramOnClickListener)
  {
    this.n = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog a(String paramString)
  {
    this.s = paramString;
    return this;
  }
  
  public GuideInfoDialog a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public GuideInfoDialog b(View.OnClickListener paramOnClickListener)
  {
    this.o = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public GuideInfoDialog b(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  public GuideInfoDialog c(View.OnClickListener paramOnClickListener)
  {
    this.p = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog c(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public GuideInfoDialog d(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public void dismiss()
  {
    VideoView localVideoView = this.f;
    if ((localVideoView != null) && (localVideoView.isPlaying())) {
      this.f.stopPlayback();
    }
    super.dismiss();
  }
  
  public GuideInfoDialog e(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131628054);
    this.g = ((RelativeLayout)findViewById(2131442700));
    this.f = ((VideoView)findViewById(2131449765));
    this.a = ((ImageView)findViewById(2131442701));
    this.b = ((TextView)findViewById(2131442699));
    this.e = ((ImageView)findViewById(2131442698));
    this.d = ((Button)findViewById(2131442703));
    this.c = ((Button)findViewById(2131442704));
    a();
    b();
    if (TextUtils.isEmpty(this.k))
    {
      this.b.setVisibility(8);
    }
    else
    {
      this.b.setVisibility(0);
      if (this.b.getPaint().measureText(this.k) > UIUtils.a(getContext(), 280.0F)) {
        this.b.setGravity(3);
      } else {
        this.b.setGravity(17);
      }
      this.b.setText(this.k);
    }
    if (TextUtils.isEmpty(this.m))
    {
      this.c.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(0);
      this.c.setText(this.m);
      paramBundle = this.n;
      if (paramBundle != null) {
        this.c.setOnClickListener(paramBundle);
      } else {
        this.c.setOnClickListener(new GuideInfoDialog.1(this));
      }
    }
    if (TextUtils.isEmpty(this.l))
    {
      this.d.setVisibility(8);
    }
    else
    {
      this.d.setVisibility(0);
      this.d.setTag(this.l);
      paramBundle = this.o;
      if (paramBundle != null) {
        this.d.setOnClickListener(paramBundle);
      } else {
        this.d.setOnClickListener(new GuideInfoDialog.2(this));
      }
    }
    paramBundle = this.p;
    if (paramBundle != null)
    {
      this.e.setOnClickListener(paramBundle);
      return;
    }
    this.e.setOnClickListener(new GuideInfoDialog.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog
 * JD-Core Version:    0.7.0.1
 */