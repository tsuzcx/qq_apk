package com.tencent.mobileqq.activity.emogroupstore;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.emosm.view.CardLayoutManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqperf.monitor.memory.ActivityLeakSolution;
import java.util.List;

public class SDKSetEmotionDialog
  extends ReportDialog
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ProgressBar g;
  private ImageView h;
  private RecyclerView i;
  private LinearLayout j;
  private LinearLayout k;
  private ValueAnimator l;
  
  public SDKSetEmotionDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    setContentView(2131624609);
    this.a = ((TextView)findViewById(2131431880));
    this.b = ((TextView)findViewById(2131431876));
    this.c = ((TextView)findViewById(2131431864));
    this.d = ((TextView)findViewById(2131431870));
    this.e = ((TextView)findViewById(2131431834));
    this.h = ((ImageView)findViewById(2131433674));
    this.i = ((RecyclerView)findViewById(2131445559));
    this.f = ((TextView)findViewById(2131440762));
    this.g = ((ProgressBar)findViewById(2131432487));
    this.j = ((LinearLayout)findViewById(2131431884));
    this.k = ((LinearLayout)findViewById(2131431911));
  }
  
  public SDKSetEmotionDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.c.setVisibility(0);
    this.c.setOnClickListener(new SDKSetEmotionDialog.1(this, paramOnClickListener));
    return this;
  }
  
  public SDKSetEmotionDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.a.setText(paramString);
      this.a.setContentDescription(paramString);
      this.a.setVisibility(0);
      return this;
    }
    this.a.setVisibility(8);
    return this;
  }
  
  public SDKSetEmotionDialog a(List<String> paramList, View.OnClickListener paramOnClickListener)
  {
    if (paramList != null)
    {
      if (paramOnClickListener == null) {
        return this;
      }
      this.i.setVisibility(0);
      this.i.setAdapter(new StackAdapter(paramList));
      this.i.setItemAnimator(new DefaultItemAnimator());
      paramList = new CardLayoutManager(paramOnClickListener);
      this.i.setLayoutManager(paramList);
    }
    return this;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      return;
    }
    if (paramInt == 1)
    {
      this.j.setVisibility(0);
      this.k.setVisibility(8);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ValueAnimator localValueAnimator = this.l;
    if ((localValueAnimator != null) && (paramInt > 0)) {
      localValueAnimator.cancel();
    }
    if (this.f != null)
    {
      if (this.g == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.f.setVisibility(0);
        this.f.setText(paramString);
      }
      if (paramInt >= 0)
      {
        if (paramInt > 100) {
          return;
        }
        this.g.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 24)
        {
          this.g.setProgress(paramInt, true);
          return;
        }
        this.g.setProgress(paramInt);
      }
    }
  }
  
  public SDKSetEmotionDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.e.setVisibility(0);
    this.e.setOnClickListener(new SDKSetEmotionDialog.2(this, paramOnClickListener));
    return this;
  }
  
  public SDKSetEmotionDialog b(String paramString)
  {
    if (this.f != null)
    {
      if (this.g == null) {
        return this;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.f.setVisibility(0);
        this.f.setText(paramString);
        return this;
      }
      this.f.setVisibility(4);
    }
    return this;
  }
  
  public void b(int paramInt)
  {
    ProgressBar localProgressBar = this.g;
    if (localProgressBar == null) {
      return;
    }
    this.l = SDKSetEmotionHelper.a(localProgressBar, paramInt);
    this.l.start();
  }
  
  public SDKSetEmotionDialog c(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    TextView localTextView = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.d.setVisibility(0);
    this.d.setOnClickListener(new SDKSetEmotionDialog.3(this, paramOnClickListener));
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      try
      {
        if (this.l != null) {
          this.l.cancel();
        }
        super.dismiss();
      }
      finally
      {
        ActivityLeakSolution.a(this);
      }
    }
    catch (Exception localException)
    {
      label28:
      break label28;
    }
    ActivityLeakSolution.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKSetEmotionDialog
 * JD-Core Version:    0.7.0.1
 */