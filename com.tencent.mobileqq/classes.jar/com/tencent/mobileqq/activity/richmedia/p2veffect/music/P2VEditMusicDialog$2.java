package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class P2VEditMusicDialog$2
  extends Handler
{
  P2VEditMusicDialog$2(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    case 10: 
    default: 
      return;
    case 12: 
      paramMessage = (QQStoryMusicInfo)paramMessage.obj;
      this.a.b(paramMessage);
      return;
    case 11: 
      this.a.b();
      paramMessage = this.a.x;
      paramMessage.p = ((int)ShortVideoUtils.getDuration(paramMessage.m));
      if (paramMessage.n < 0) {
        paramMessage.n = 0;
      }
      if (paramMessage.n + this.a.t > paramMessage.p) {
        paramMessage.n = 0;
      }
      paramMessage.o = (paramMessage.n + this.a.t);
      this.a.A.a(paramMessage);
      this.a.A.a(3);
      this.a.k.setVisibility(8);
      this.a.l.setVisibility(0);
      this.a.f.setVisibility(0);
      this.a.e.setVisibility(8);
      this.a.d.setText(paramMessage.e);
      this.a.c();
      this.a.c.setDurations((this.a.f() + 500) / 1000, (Math.max(paramMessage.p, this.a.t) + 500) / 1000);
      this.a.c.a(paramMessage.n);
      this.a.b(paramMessage.n, paramMessage.o);
      return;
    case 9: 
      if (this.a.k.getVisibility() != 0)
      {
        this.a.k.setVisibility(0);
        this.a.l.setVisibility(8);
      }
      this.a.k.setProgress(paramMessage.arg1);
      return;
    case 8: 
      this.a.c.setPlayedPosition(this.a.u);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.makeText(this.a.getContext(), paramMessage, 0).show();
      return;
    case 6: 
      this.a.b();
      this.a.A.a(QQStoryMusicInfo.b);
      this.a.A.a(1);
      this.a.d.setText("");
      this.a.e.setText(HardCodeUtil.a(2131905683));
      this.a.e.setVisibility(0);
      this.a.f.setVisibility(8);
      P2VEditMusicDialog.a(this.a);
      return;
    case 3: 
      this.a.b();
      this.a.A.a(QQStoryMusicInfo.a);
      this.a.A.a(0);
      this.a.d.setText("");
      this.a.e.setText(HardCodeUtil.a(2131905684));
      this.a.e.setVisibility(0);
      this.a.f.setVisibility(8);
      return;
    case 2: 
      this.a.b();
      paramMessage = this.a.A.a();
      if (paramMessage == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(P2VEditMusicDialog.h(), 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
        }
        return;
      }
      if (paramMessage.m == null)
      {
        QLog.e(P2VEditMusicDialog.h(), 2, "MSG_PLAY_MUSIC music.download_path is NULL!!!!!");
        return;
      }
      paramMessage.p = ((int)ShortVideoUtils.getDuration(paramMessage.m));
      if (paramMessage.n < 0) {
        paramMessage.n = 0;
      }
      if (paramMessage.n + this.a.t > paramMessage.p) {
        paramMessage.n = 0;
      }
      paramMessage.o = (paramMessage.n + this.a.t);
      this.a.A.a(3);
      this.a.k.setVisibility(8);
      this.a.l.setVisibility(0);
      this.a.f.setVisibility(0);
      this.a.e.setVisibility(8);
      this.a.d.setText(paramMessage.e);
      this.a.c();
      MusicHorizontalSeekView.a((this.a.f() + 500) / 1000, this.a.getContext().getResources().getDisplayMetrics().widthPixels - ViewUtils.dip2px(8.0F));
      this.a.c.setDurations((this.a.f() + 500) / 1000, (Math.max(paramMessage.p, this.a.t) + 500) / 1000);
      this.a.c.a(paramMessage.n);
      this.a.b(paramMessage.n, paramMessage.o);
      return;
    }
    this.a.b();
    if (this.a.b != null)
    {
      this.a.b.a(this.a.q);
      this.a.b.notifyDataSetChanged();
    }
    paramMessage = this.a.A.a();
    if (this.a.b != null) {
      this.a.b.a(paramMessage);
    }
    if (paramMessage != null)
    {
      if (paramMessage.k == 0)
      {
        this.a.B.sendEmptyMessage(3);
        return;
      }
      if (paramMessage.k == 1)
      {
        this.a.B.sendEmptyMessage(6);
        return;
      }
      if (!TextUtils.isEmpty(paramMessage.m))
      {
        this.a.B.sendEmptyMessage(2);
        return;
      }
      if (this.a.z)
      {
        P2VEditMusicDialog localP2VEditMusicDialog = this.a;
        localP2VEditMusicDialog.z = false;
        localP2VEditMusicDialog.a(paramMessage);
      }
    }
    else
    {
      if (!this.a.A.h())
      {
        this.a.B.sendEmptyMessage(3);
        return;
      }
      this.a.B.sendEmptyMessage(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.2
 * JD-Core Version:    0.7.0.1
 */