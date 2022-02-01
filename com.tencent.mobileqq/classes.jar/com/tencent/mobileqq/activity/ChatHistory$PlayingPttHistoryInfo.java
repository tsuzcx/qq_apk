package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class ChatHistory$PlayingPttHistoryInfo
{
  public int a;
  public View b;
  public Object c;
  public boolean d;
  public String e;
  
  public ChatHistory$PlayingPttHistoryInfo(ChatHistory paramChatHistory)
  {
    a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "reset()");
    }
    this.a = -1;
    this.b = null;
    this.c = null;
    this.d = true;
    this.e = null;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playPtt() type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isFinish = ");
      localStringBuilder.append(this.d);
      QLog.i("ChatHistory", 2, localStringBuilder.toString());
    }
    if ((!this.d) && (Utils.a(paramObject, this.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "playPtt() 点击正在播放，即要停止啦！");
      }
      d();
      return;
    }
    if (!this.d) {
      d();
    }
    if (!this.f.e(paramString))
    {
      d();
      return;
    }
    this.d = false;
    this.a = paramInt;
    this.b = paramView;
    this.c = paramObject;
    this.e = paramString;
    b();
  }
  
  public void a(View paramView, String paramString)
  {
    this.b = paramView;
    this.e = paramString;
    if (this.a != 1) {
      b();
    }
  }
  
  public boolean a(int paramInt, Object paramObject)
  {
    return (!this.d) && (paramInt == this.a) && (Utils.a(this.c, paramObject));
  }
  
  protected void b()
  {
    int i = this.a;
    ImageView localImageView = null;
    Object localObject1;
    if (i == 0)
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        localObject1 = (Button)((View)localObject1).findViewById(2131440790);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        boolean bool;
        if ((this.b.getTag() != null) && ((this.b.getTag() instanceof ChatHistory.Holder))) {
          bool = ((ChatHistory.Holder)this.b.getTag()).b;
        } else {
          bool = false;
        }
        if (bool)
        {
          this.f.E.setBounds(0, 0, this.f.E.getMinimumWidth(), this.f.E.getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables(this.f.E, null, null, null);
          this.f.E.stop();
          this.f.E.start();
          return;
        }
        this.f.D.setBounds(0, 0, this.f.D.getMinimumWidth(), this.f.D.getMinimumHeight());
        ((Button)localObject1).setCompoundDrawables(this.f.D, null, null, null);
        this.f.D.stop();
        this.f.D.start();
      }
    }
    else if (i == 1)
    {
      localObject1 = this.b;
      if (localObject1 != null)
      {
        localImageView = (ImageView)((View)localObject1).findViewById(2131445986);
        localObject1 = (ImageView)this.b.findViewById(2131435515);
      }
      else
      {
        localObject1 = null;
      }
      if ((localImageView != null) && (localObject1 != null))
      {
        Object localObject2 = localImageView.getTag();
        if ((localObject2 instanceof IPicEmoticonInfo))
        {
          localObject2 = (IPicEmoticonInfo)localObject2;
          this.f.a(localImageView);
          this.f.b((ImageView)localObject1, (IPicEmoticonInfo)localObject2);
        }
      }
    }
  }
  
  protected void c()
  {
    int i = this.a;
    Object localObject2 = null;
    Object localObject1;
    if (i == 0)
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        localObject1 = (Button)((View)localObject1).findViewById(2131440790);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((Button)localObject1).getTag().equals(this.c)))
      {
        boolean bool;
        if ((this.b.getTag() != null) && ((this.b.getTag() instanceof ChatHistory.Holder))) {
          bool = ((ChatHistory.Holder)this.b.getTag()).b;
        } else {
          bool = false;
        }
        if (bool)
        {
          this.f.E.stop();
          localObject2 = this.f.getResources().getDrawable(2130852101);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
        }
        else
        {
          this.f.D.stop();
          localObject2 = this.f.getResources().getDrawable(2130852100);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
        }
        ((Button)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      }
    }
    else if (i == 1)
    {
      localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject2 = (ImageView)((View)localObject1).findViewById(2131445986);
        localObject1 = (ImageView)this.b.findViewById(2131435515);
      }
      else
      {
        localObject1 = null;
      }
      if ((localObject2 != null) && (localObject1 != null))
      {
        Object localObject3 = ((ImageView)localObject2).getTag();
        if ((localObject3 instanceof IPicEmoticonInfo))
        {
          localObject3 = (IPicEmoticonInfo)localObject3;
          ((IPicEmoticonInfo)localObject3).getLoadingDrawable("fromAIO", true);
          this.f.b((ImageView)localObject2);
          this.f.a((ImageView)localObject1, (IPicEmoticonInfo)localObject3);
        }
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "stopPlayPtt()");
    }
    this.f.q();
    this.d = true;
    c();
    a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", curTag = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isFinish = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo
 * JD-Core Version:    0.7.0.1
 */