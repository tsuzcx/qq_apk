package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class EditVideoProgressBar
  extends EditVideoPart
{
  private QzEditVideoPartManager a;
  private LinearLayout b;
  private RotationSeekBar c;
  private ImageButton d;
  private TextView e;
  private TextView f;
  private double g = 1.0D;
  private long h = -1L;
  private HWEditLocalVideoPlayer i;
  private QimMusicPlayer j;
  private int k = -1;
  private int l = 0;
  
  public EditVideoProgressBar(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager)
  {
    super(paramQzEditVideoPartManager);
    this.a = paramQzEditVideoPartManager;
  }
  
  private static String a(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)d(2063991043);
    Object localObject = LayoutInflater.from(u());
    int m = 0;
    this.b = ((LinearLayout)((LayoutInflater)localObject).inflate(2131628678, localRelativeLayout, false));
    localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(40.0F, s()));
    LinearLayout localLinearLayout = this.b;
    if (!this.a.n) {
      m = 8;
    }
    localLinearLayout.setVisibility(m);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    if (LiuHaiUtils.j > 0) {
      m = LiuHaiUtils.j + AIOUtils.b(40.0F, s());
    } else {
      m = AIOUtils.b(100.0F, s());
    }
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = m;
    localRelativeLayout.addView(this.b, (ViewGroup.LayoutParams)localObject);
  }
  
  private void d()
  {
    if ((this.h < 0L) && (this.a.aj != null) && (this.a.aj.k() != null))
    {
      this.h = this.a.aj.k().mDuration;
      this.i = this.a.aj;
      this.j = ((QimMusicPlayer)QIMManager.a().d(8));
      if ((this.i.l() == 1) && (this.l != 1))
      {
        this.d.setImageResource(2130849584);
        this.l = 1;
        return;
      }
      if ((this.i.l() == 2) && (this.l != 2))
      {
        this.d.setImageResource(2130849583);
        this.l = 2;
      }
    }
  }
  
  private void i()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((HWEditLocalVideoPlayer)localObject).h();
    }
    localObject = this.j;
    if (localObject != null) {
      ((QimMusicPlayer)localObject).b();
    }
  }
  
  private void k()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((HWEditLocalVideoPlayer)localObject).i();
    }
    localObject = this.j;
    if (localObject != null) {
      ((QimMusicPlayer)localObject).a();
    }
  }
  
  public void a()
  {
    super.a();
    c();
    this.c = ((RotationSeekBar)d(2131432279));
    this.d = ((ImageButton)d(2131432280));
    this.e = ((TextView)d(2131432281));
    this.f = ((TextView)d(2131432278));
    this.d.setOnClickListener(new EditVideoProgressBar.1(this));
    this.c.setEnabled(true);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.b.setVisibility(8);
      return;
    }
    if (this.a.n)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  protected boolean a(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 9)
    {
      if (m == 13)
      {
        if (this.a.n)
        {
          d();
          if (this.h > 0L)
          {
            long l1 = ((Long[])(Long[])paramMessage.obj)[0].longValue();
            if (this.g > 0.0D)
            {
              m = (int)(100L * l1 / this.h);
              int n = this.k;
              if ((m < n) && (n < 95) && (m > 5))
              {
                paramMessage = new StringBuilder();
                paramMessage.append("progress = ");
                paramMessage.append(n);
                paramMessage.append("；lastProgress = ");
                paramMessage.append(this.k);
                paramMessage.append("; need to reset");
                QLog.d("EditVideo - progressBar", 2, paramMessage.toString());
                m = n;
              }
              else
              {
                this.k = m;
              }
              this.c.setProgress(m);
              paramMessage = this.e;
              double d1 = l1;
              double d2 = this.g;
              Double.isNaN(d1);
              paramMessage.setText(a((d1 * d2)));
              paramMessage = this.f;
              d1 = this.h;
              d2 = this.g;
              Double.isNaN(d1);
              paramMessage.setText(a((d1 * d2)));
            }
            else
            {
              long l2 = this.h;
              m = (int)((l2 - l1) * 100L / l2);
              this.c.setProgress(m);
              this.e.setText(a(this.h - l1));
              this.f.setText(a(this.h));
            }
          }
          if ((this.i.l() == 1) && (this.l != 1))
          {
            this.d.setImageResource(2130849584);
            this.l = 1;
            return true;
          }
          if ((this.i.l() == 2) && (this.l != 2))
          {
            this.d.setImageResource(2130849583);
            this.l = 2;
          }
        }
        return true;
      }
    }
    else if (paramMessage.arg1 == 12)
    {
      m = paramMessage.arg2;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m != 4)
              {
                if (m == 5) {
                  this.g = -1.0D;
                }
              }
              else {
                this.g = 4.0D;
              }
            }
            else {
              this.g = 2.0D;
            }
          }
          else {
            this.g = 1.0D;
          }
        }
        else {
          this.g = 0.5D;
        }
      }
      else {
        this.g = 0.25D;
      }
    }
    return super.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoProgressBar
 * JD-Core Version:    0.7.0.1
 */