package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
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
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playPtt() type = " + paramInt + ", isFinish = " + this.jdField_a_of_type_Boolean);
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
    Object localObject1 = null;
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label307;
      }
    }
    label300:
    label302:
    label307:
    for (localObject1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363762);; localObject1 = null)
    {
      if (localObject1 != null) {
        if ((this.jdField_a_of_type_AndroidViewView.getTag() == null) || (!(this.jdField_a_of_type_AndroidViewView.getTag() instanceof ChatHistory.Holder))) {
          break label302;
        }
      }
      for (boolean bool = ((ChatHistory.Holder)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean;; bool = false)
      {
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.getMinimumWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, null, null, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.stop();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.start();
        }
        for (;;)
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.getMinimumWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a, null, null, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.stop();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.start();
          return;
          if (this.jdField_a_of_type_Int == 1)
          {
            ImageView localImageView;
            if (this.jdField_a_of_type_AndroidViewView != null)
            {
              localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363760);
              localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363759);
            }
            for (;;)
            {
              if ((localImageView == null) || (localObject1 == null)) {
                break label300;
              }
              Object localObject2 = localImageView.getTag();
              if (!(localObject2 instanceof PicEmoticonInfo)) {
                break;
              }
              localObject2 = (PicEmoticonInfo)localObject2;
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(localImageView);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b((ImageView)localObject1, (PicEmoticonInfo)localObject2);
              return;
              localImageView = null;
            }
          }
        }
      }
    }
  }
  
  protected void c()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label282;
      }
    }
    label275:
    label277:
    label282:
    for (localObject1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363762);; localObject1 = null)
    {
      if ((localObject1 != null) && (((Button)localObject1).getTag().equals(this.jdField_a_of_type_JavaLangObject))) {
        if ((this.jdField_a_of_type_AndroidViewView.getTag() == null) || (!(this.jdField_a_of_type_AndroidViewView.getTag() instanceof ChatHistory.Holder))) {
          break label277;
        }
      }
      for (boolean bool = ((ChatHistory.Holder)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean;; bool = false)
      {
        Object localObject2;
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.stop();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130845637);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        for (;;)
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.stop();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130845636);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          break;
          if (this.jdField_a_of_type_Int == 1)
          {
            if (this.jdField_a_of_type_AndroidViewView != null)
            {
              localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363760);
              localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363759);
            }
            for (;;)
            {
              if ((localObject2 == null) || (localObject1 == null)) {
                break label275;
              }
              Object localObject3 = ((ImageView)localObject2).getTag();
              if (!(localObject3 instanceof PicEmoticonInfo)) {
                break;
              }
              localObject3 = (PicEmoticonInfo)localObject3;
              ((PicEmoticonInfo)localObject3).a("fromAIO", true);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b((ImageView)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a((ImageView)localObject1, (PicEmoticonInfo)localObject3);
              return;
              localObject2 = null;
            }
          }
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
    localStringBuilder.append("[type = ").append(this.jdField_a_of_type_Int).append(", curTag = ").append(this.jdField_a_of_type_JavaLangObject).append(", isFinish = ").append(this.jdField_a_of_type_Boolean).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo
 * JD-Core Version:    0.7.0.1
 */