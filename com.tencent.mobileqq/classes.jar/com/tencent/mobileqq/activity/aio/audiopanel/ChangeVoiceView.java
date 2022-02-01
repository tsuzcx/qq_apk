package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ChangeVoiceView
  extends RelativeLayout
{
  public static String a = HardCodeUtil.a(2131899744);
  ImageView b;
  ImageView c;
  public int d;
  public int e;
  public int f = 0;
  public VoiceChangeData g;
  private ImageView h;
  private CircleProgressView i;
  private VolumeIndicateSquareView j;
  private TextView k;
  private TextView l;
  private int m = 0;
  private boolean n = false;
  private long o = 0L;
  
  public ChangeVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.n = true;
    CircleProgressView localCircleProgressView = this.i;
    if (localCircleProgressView != null)
    {
      localCircleProgressView.setRingWidth(10);
      this.i.setRingColor(getResources().getColor(2131167981));
    }
  }
  
  public void a(int paramInt)
  {
    if (this.g == null) {
      return;
    }
    this.i.setProgress(0);
    if (paramInt == 2)
    {
      setContentDescription(a);
    }
    else if (paramInt == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getContext().getString(2131888076));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.g.c);
      setContentDescription(((StringBuilder)localObject).toString());
    }
    else
    {
      setContentDescription(this.g.c);
    }
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    if (paramInt == 0)
    {
      this.i.setVisibility(8);
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.l.setBackgroundResource(2130838393);
      if (this.g.d == 1) {
        this.l.setTextColor(2137417318);
      } else {
        this.l.setTextColor(getContext().getResources().getColor(2131165451));
      }
    }
    else if (paramInt == 1)
    {
      this.i.setVisibility(8);
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      if (this.n)
      {
        this.l.setBackgroundResource(2130849689);
        this.l.setTextColor(-16777216);
      }
      else
      {
        this.l.setBackgroundResource(2130838394);
        this.l.setTextColor(-1);
      }
    }
    else if (paramInt == 2)
    {
      this.i.setVisibility(0);
      this.k.setVisibility(0);
      this.j.a();
      this.j.setVisibility(0);
      if (this.n)
      {
        this.l.setBackgroundResource(2130849689);
        this.l.setTextColor(-16777216);
      }
      else
      {
        this.l.setBackgroundResource(2130838394);
        this.l.setTextColor(-1);
      }
    }
    Object localObject = this.l;
    paramInt = this.m;
    ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.i.setProgress(paramInt1);
    if (this.o == 0L) {
      this.o = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.o < 75L) {
      return;
    }
    this.o = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt2 /= 1000;
    paramInt1 = paramInt2 / 60;
    paramInt2 %= 60;
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    if (paramInt2 < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(paramInt2);
    if (!localStringBuilder.equals(this.k.getText())) {
      this.k.setText(localStringBuilder);
    }
    this.j.a(paramInt3);
  }
  
  public void a(VoiceChangeData paramVoiceChangeData)
  {
    int i1 = 0;
    boolean bool;
    if (paramVoiceChangeData != null) {
      bool = true;
    } else {
      bool = false;
    }
    super.setEnabled(bool);
    this.c = ((ImageView)super.findViewById(2131433313));
    this.b = ((ImageView)super.findViewById(2131433314));
    this.h = ((ImageView)super.findViewById(2131430487));
    this.l = ((TextView)super.findViewById(2131430489));
    this.i = ((CircleProgressView)super.findViewById(2131430488));
    this.i.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCircleProcessViewPresenter(this.i));
    this.k = ((TextView)super.findViewById(2131430492));
    this.j = ((VolumeIndicateSquareView)super.findViewById(2131430493));
    Object localObject2 = null;
    if (paramVoiceChangeData == null)
    {
      this.h.setBackgroundDrawable(null);
      this.h.setVisibility(4);
      this.l.setText(null);
      super.setContentDescription(null);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.i.setVisibility(8);
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.l.setBackgroundResource(2130838393);
      return;
    }
    this.m = DisplayUtil.a(getContext(), 4.0F);
    this.d = paramVoiceChangeData.a;
    this.i.setStrokeWidth(4);
    this.g = paramVoiceChangeData;
    this.h.setVisibility(0);
    Object localObject3;
    if (paramVoiceChangeData.g.c > 0) {
      this.h.setBackgroundResource(paramVoiceChangeData.g.c);
    } else {
      localObject3 = super.getResources();
    }
    try
    {
      localObject1 = paramVoiceChangeData.g.a;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject3).getDrawable(2130849366);
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130849366);
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getVoiceChangeRootDir());
        ((StringBuilder)localObject4).append(((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
        localObject4 = new File(((StringBuilder)localObject4).toString());
        if ((((File)localObject4).exists()) && (((File)localObject4).isFile())) {
          localObject1 = URLDrawable.getDrawable((File)localObject4, localURLDrawableOptions);
        } else {
          localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init drawable url = null, name=");
        ((StringBuilder)localObject1).append(paramVoiceChangeData.b);
        ((StringBuilder)localObject1).append(",type=");
        ((StringBuilder)localObject1).append(paramVoiceChangeData.a);
        QLog.d("ChangeVoiceView", 2, ((StringBuilder)localObject1).toString());
        localObject1 = ((Resources)localObject3).getDrawable(2130849366);
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label523:
      break label523;
    }
    localObject1 = ((Resources)localObject3).getDrawable(2130849366);
    if ((localObject1 instanceof URLDrawable))
    {
      localObject3 = (URLDrawable)localObject1;
      if (((URLDrawable)localObject3).getStatus() == 2) {
        ((URLDrawable)localObject3).restartDownload();
      }
    }
    if (paramVoiceChangeData.d == 1) {
      ((Drawable)localObject1).setAlpha(127);
    } else {
      ((Drawable)localObject1).setAlpha(255);
    }
    paramVoiceChangeData.g.d = ((Drawable)localObject1);
    this.h.setBackgroundDrawable((Drawable)localObject1);
    if (paramVoiceChangeData.e != 0)
    {
      this.b.setVisibility(0);
      if (paramVoiceChangeData.e == 1) {
        this.b.setImageResource(2130849256);
      } else {
        this.b.setImageResource(2130849255);
      }
    }
    else
    {
      this.b.setVisibility(8);
    }
    if (paramVoiceChangeData.f != 1)
    {
      this.c.setVisibility(0);
      if (paramVoiceChangeData.f == 4) {
        localObject1 = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getTagIconURL(0);
      } else if (paramVoiceChangeData.f == 5) {
        localObject1 = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getTagIconURL(1);
      } else {
        localObject1 = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getTagIconURL(2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getVoiceChangeRootDir());
        ((StringBuilder)localObject2).append(((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
        localObject2 = new File(((StringBuilder)localObject2).toString());
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          localObject2 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        } else {
          localObject2 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        }
      }
      this.c.setImageDrawable((Drawable)localObject2);
    }
    else
    {
      this.c.setVisibility(8);
    }
    localObject2 = paramVoiceChangeData.b;
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 4)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 3));
        ((StringBuilder)localObject1).append("...");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    this.l.setText((CharSequence)localObject1);
    super.setContentDescription(paramVoiceChangeData.c);
    if (paramVoiceChangeData.a == this.e) {
      i1 = 1;
    }
    this.f = (i1 + 1);
    a(i1);
  }
  
  public int getState()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView
 * JD-Core Version:    0.7.0.1
 */