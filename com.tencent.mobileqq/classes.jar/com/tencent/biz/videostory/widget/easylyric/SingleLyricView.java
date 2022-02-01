package com.tencent.biz.videostory.widget.easylyric;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;

public class SingleLyricView
  extends RelativeLayout
  implements ILyricView
{
  private final String a = "SingleLyricView";
  private final LyricControllerWrapper b;
  private final OnLyricListener c;
  private TextView d;
  private ImageView e;
  private volatile Lyric f;
  private int g;
  private Sentence h;
  private AnimatorSet i;
  private long j = 0L;
  private String k;
  private long l = 0L;
  private boolean m = false;
  private String n;
  private int o;
  private Handler p;
  
  public SingleLyricView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLyricView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLyricView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131629636, this, true);
    a(paramAttributeSet, paramInt);
    this.e = ((ImageView)findViewById(2131446040));
    if (this.o == 1)
    {
      this.d = ((TextView)findViewById(2131446041));
      paramContext = this.d;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      paramContext = this.e;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
    }
    else
    {
      this.d = ((TextView)findViewById(2131446542));
      paramContext = this.d;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      paramContext = this.e;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
    }
    this.b = new LyricControllerWrapper();
    this.c = new SingleLyricView.1(this);
    this.p = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.SingleLyricView, paramInt, 0);
    try
    {
      this.o = paramAttributeSet.getInteger(0, 1);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((AnimatorSet)localObject).end();
    }
    this.i = new AnimatorSet();
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).setInterpolator(new AccelerateInterpolator());
    ((ValueAnimator)localObject).addUpdateListener(new SingleLyricView.2(this));
    ((ValueAnimator)localObject).addListener(new SingleLyricView.3(this, paramString));
    paramString = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
    paramString.setDuration(500L);
    paramString.addUpdateListener(new SingleLyricView.4(this));
    paramString.addListener(new SingleLyricView.5(this));
    paramString.setInterpolator(new DecelerateInterpolator());
    paramString.addListener(new SingleLyricView.6(this));
    this.i.playSequentially(new Animator[] { localObject, paramString });
    this.i.start();
  }
  
  public void a()
  {
    this.p.removeCallbacks(null);
    this.g = -1;
    this.f = null;
    Object localObject = this.d;
    if (localObject != null)
    {
      ((TextView)localObject).setText("");
      this.d.setAlpha(1.0F);
    }
    localObject = this.i;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    this.k = null;
    this.j = 0L;
  }
  
  public void a(long paramLong)
  {
    if (this.f == null) {
      return;
    }
    Object localObject = LyricParserHelper.a().a(this.f, this.j + paramLong);
    Sentence localSentence = this.h;
    int i2 = 1;
    int i1;
    if (localSentence != localObject) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!this.m) || (paramLong >= this.l)) {
      i2 = 0;
    }
    if ((localObject != null) && (i1 != 0) && (i2 == 0))
    {
      this.h = ((Sentence)localObject);
      a(((Sentence)localObject).a);
      this.n = ((Sentence)localObject).a;
      return;
    }
    if ((i2 != 0) && (!TextUtils.isEmpty(this.k)) && (!this.k.equals(this.n)))
    {
      localObject = this.d;
      if (localObject != null)
      {
        ((TextView)localObject).setText(this.k);
        this.n = this.k;
        this.h = null;
      }
    }
  }
  
  public View getView()
  {
    return this.d;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.a(this);
    VideoPlayStatusDispatcher.a().a(this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoPlayStatusDispatcher.a().b(this.c);
    this.b.a();
    AnimatorSet localAnimatorSet = this.i;
    if (localAnimatorSet != null) {
      localAnimatorSet.cancel();
    }
    this.p.removeCallbacks(null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    this.f = null;
    this.p.post(new SingleLyricView.7(this, paramString1, paramString2));
    this.j = 0L;
  }
  
  public void setPos(long paramLong)
  {
    if (paramLong < 0L) {
      paramLong = 0L;
    }
    this.j = paramLong;
  }
  
  public void setSongName(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.k = paramString;
      TextView localTextView = this.d;
      if (localTextView != null)
      {
        localTextView.setAlpha(1.0F);
        this.d.setText(paramString);
      }
      this.m = true;
      if (paramLong < 0L) {
        paramLong = 3000L;
      }
      this.l = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView
 * JD-Core Version:    0.7.0.1
 */