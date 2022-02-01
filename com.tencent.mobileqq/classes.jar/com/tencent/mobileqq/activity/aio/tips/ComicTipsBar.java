package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ComicTipsBar
  implements TipsBarTask
{
  QQAppInterface a;
  TipsManager b;
  Activity c;
  String d;
  String e = "";
  String f = "";
  int g = -1;
  boolean h = false;
  
  public ComicTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity)
  {
    this.a = paramQQAppInterface;
    this.b = paramTipsManager;
    this.c = paramActivity;
  }
  
  public int a()
  {
    return 35;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.c).inflate(2131624144, null);
    localView.setOnClickListener(new ComicTipsBar.1(this, localView));
    TextView localTextView = (TextView)localView.findViewById(2131428120);
    paramVarArgs = this.c.getResources().getDisplayMetrics();
    int j = (int)(localTextView.getPaint().measureText(this.f) / this.f.length());
    if (paramVarArgs.widthPixels > paramVarArgs.heightPixels) {
      i = paramVarArgs.heightPixels;
    } else {
      i = paramVarArgs.widthPixels;
    }
    int i = (int)((i - paramVarArgs.density * 65.0F) / j) - 8;
    if (this.f.length() > i)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(this.f.substring(0, i));
      paramVarArgs.append("...");
      this.f = paramVarArgs.toString();
    }
    i = this.g;
    if ((i >= 100) && (i <= 300)) {
      paramVarArgs = HardCodeUtil.a(2131900361);
    } else {
      paramVarArgs = HardCodeUtil.a(2131900362);
    }
    this.d = String.format(paramVarArgs, new Object[] { this.f });
    localTextView.setText(this.d);
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    paramVarArgs = this.c;
    if ((paramVarArgs != null) && (paramVarArgs.getIntent() != null))
    {
      paramVarArgs = this.c.getIntent().getExtras();
      if (paramVarArgs == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComicTipsBar", 2, "onAIOEvent() : data == null");
        }
        return;
      }
      this.h = paramVarArgs.getBoolean("fromMessage", false);
      this.e = paramVarArgs.getString("comicId");
      this.f = paramVarArgs.getString("comicName");
      this.g = paramVarArgs.getInt("type", -1);
      if (TextUtils.isEmpty(this.f))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComicTipsBar", 2, "onAIOEvent() : comicName is null");
        }
        return;
      }
      this.b.a(this, new Object[0]);
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent() : show ReaderTipBar, bookName : ");
        paramVarArgs.append(this.f);
        QLog.d("ComicTipsBar", 2, paramVarArgs.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicTipsBar", 2, "onAIOEvent() : intent is null");
    }
  }
  
  public int b()
  {
    return 13;
  }
  
  public int[] c()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ComicTipsBar
 * JD-Core Version:    0.7.0.1
 */