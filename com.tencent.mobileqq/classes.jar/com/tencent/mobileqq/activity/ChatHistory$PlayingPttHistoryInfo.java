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
  public View a;
  public Object a;
  public String a;
  public boolean a;
  
  public ChatHistory$PlayingPttHistoryInfo(ChatHistory paramChatHistory)
  {
    a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "reset()");
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playPtt() type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isFinish = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("ChatHistory", 2, localStringBuilder.toString());
    }
    if ((!this.jdField_a_of_type_Boolean) && (Utils.a(paramObject, this.jdField_a_of_type_JavaLangObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "playPtt() 点击正在播放，即要停止啦！");
      }
      d();
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.c(paramString))
    {
      d();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangString = paramString;
    b();
  }
  
  public void a(View paramView, String paramString)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Int != 1) {
      b();
    }
  }
  
  public boolean a(int paramInt, Object paramObject)
  {
    return (!this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_Int) && (Utils.a(this.jdField_a_of_type_JavaLangObject, paramObject));
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_Int;
    ImageView localImageView = null;
    Object localObject1;
    if (i == 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        localObject1 = (Button)((View)localObject1).findViewById(2131373181);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        boolean bool;
        if ((this.jdField_a_of_type_AndroidViewView.getTag() != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof ChatHistory.Holder))) {
          bool = ((ChatHistory.Holder)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean;
        } else {
          bool = false;
        }
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.getMinimumWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, null, null, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.stop();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.start();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.getMinimumWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.getMinimumHeight());
        ((Button)localObject1).setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a, null, null, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.stop();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.start();
      }
    }
    else if (i == 1)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        localImageView = (ImageView)((View)localObject1).findViewById(2131377578);
        localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368603);
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
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(localImageView);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b((ImageView)localObject1, (IPicEmoticonInfo)localObject2);
        }
      }
    }
  }
  
  protected void c()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject2 = null;
    Object localObject1;
    if (i == 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        localObject1 = (Button)((View)localObject1).findViewById(2131373181);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((Button)localObject1).getTag().equals(this.jdField_a_of_type_JavaLangObject)))
      {
        boolean bool;
        if ((this.jdField_a_of_type_AndroidViewView.getTag() != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof ChatHistory.Holder))) {
          bool = ((ChatHistory.Holder)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean;
        } else {
          bool = false;
        }
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.stop();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130850310);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.stop();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130850309);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
        }
        ((Button)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      }
    }
    else if (i == 1)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        localObject2 = (ImageView)((View)localObject1).findViewById(2131377578);
        localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368603);
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
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b((ImageView)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a((ImageView)localObject1, (IPicEmoticonInfo)localObject3);
        }
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "stopPlayPtt()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.o();
    this.jdField_a_of_type_Boolean = true;
    c();
    a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", curTag = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    localStringBuilder.append(", isFinish = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo
 * JD-Core Version:    0.7.0.1
 */