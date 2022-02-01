package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class HotChatDemoChatPie
  extends HotChatPie
{
  protected String br;
  protected int bs;
  protected int bt;
  protected int bu;
  protected LinearLayout bv;
  protected ImageView bw;
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramString2);
      str = paramString1;
      if (paramString2 != null) {
        str = paramString2.name;
      }
    }
    if (!TextUtils.isEmpty(str))
    {
      try
      {
        paramString1 = URLEncoder.encode(str, "UTF-8");
        str = paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
      }
      paramString1 = String.format("https://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s", new Object[] { str });
    }
    else
    {
      paramString1 = null;
    }
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("makeUrl: ");
      paramString2.append(paramString1);
      QLog.i("HotChatDemoChatPie", 4, paramString2.toString());
    }
    return paramString1;
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    Object localObject;
    if (this.bv == null)
    {
      this.bw = new ImageView(this.f);
      this.bw.setScaleType(ImageView.ScaleType.CENTER_CROP);
      int i = this.bs;
      localObject = new LinearLayout.LayoutParams(i, i);
      i = this.bt;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject).topMargin = i;
      this.bw.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.bw.setImageDrawable(paramDrawable);
      paramDrawable = new SimpleTextView(this.f);
      paramDrawable.setText(this.f.getText(2131896954));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = this.bt;
      ((LinearLayout.LayoutParams)localObject).gravity = 1;
      paramDrawable.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramDrawable.setTextColor(Color.rgb(119, 119, 119));
      paramDrawable.setTextSize(1, 14.0F);
      paramDrawable.setGravity(1);
      this.bv = new LinearLayout(this.f);
      this.bv.setOrientation(1);
      this.bv.addView(this.bw);
      this.bv.addView(paramDrawable);
      paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
      paramDrawable.addRule(11);
      paramDrawable.addRule(15);
      paramDrawable.rightMargin = this.bu;
      this.bv.setLayoutParams(paramDrawable);
      this.bv.setBackgroundResource(2130847086);
      if (this.o != null) {
        this.o.addView(this.bv);
      }
    }
    else
    {
      localObject = this.bw;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(paramDrawable);
      }
    }
  }
  
  protected void D()
  {
    if (this.u != null) {
      this.u.setVisibility(8);
    }
  }
  
  protected void ap()
  {
    super.ap();
    if (this.bv == null)
    {
      if (TextUtils.isEmpty(this.br)) {
        this.br = a(this.ah.e, this.ah.c);
      }
      ThreadManager.getFileThreadHandler().post(new HotChatDemoChatPie.LoadQRCodeImg(this.br, this.m, this.bs));
    }
  }
  
  protected void e(Intent paramIntent)
  {
    if ((this.ah.c == null) || (this.ah.c.length() == 0))
    {
      paramIntent = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.ah.b);
      if (paramIntent != null) {
        this.ah.c = paramIntent.troopcode;
      }
    }
    this.br = a(this.ah.e, this.ah.c);
  }
  
  protected void f(Intent paramIntent)
  {
    if (this.s != null)
    {
      this.s.setText(2131896953);
      this.s.setContentDescription(this.f.getString(2131896953));
      this.s.setBackgroundDrawable(null);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    this.f.finish();
  }
  
  protected void h()
  {
    this.c = "HotChatDemoChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 34)
    {
      Drawable localDrawable = null;
      if ((paramMessage.obj instanceof Drawable)) {
        localDrawable = (Drawable)paramMessage.obj;
      }
      if (paramMessage.arg1 == 2) {
        b(localDrawable);
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void l()
  {
    super.l();
    if (this.X != null) {
      this.X.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */