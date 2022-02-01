package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class FriendProfileImageAdapter
  extends BaseAdapter
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  FriendProfileImageModel jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  Drawable b;
  
  public FriendProfileImageAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297550));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130851160);
    this.b = paramContext.getResources().getDrawable(2130851161);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (ImageProgressCircle)paramView.findViewById(2131368560);
    if (paramView != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1, paramView);
      if (paramView.getVisibility() != 4) {
        paramView.setVisibility(4);
      }
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    if (paramView == null) {
      return;
    }
    a(paramView);
    paramView.setTag(paramProfileImageInfo.b);
    paramProfileImageInfo = (ImageView)paramView.findViewById(2131368461);
    if (paramProfileImageInfo != null) {
      paramProfileImageInfo.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void a(FriendProfileImageModel paramFriendProfileImageModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = paramFriendProfileImageModel;
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showProgress() progressCircle = ");
      ((StringBuilder)localObject).append(paramImageProgressCircle);
      QLog.i("Q.profilecard.PhotoWall", 2, ((StringBuilder)localObject).toString());
    }
    if (paramImageProgressCircle == null) {
      return;
    }
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1, paramImageProgressCircle))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramImageProgressCircle;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 550L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadThumbImage() path = ");
      ((StringBuilder)localObject1).append(paramProfileImageInfo.b);
      QLog.i("Q.profilecard.PhotoWall", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      Object localObject2 = paramProfileImageInfo.b;
      localObject1 = null;
      URL localURL = new URL("profile_img_thumb", null, (String)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramProfileImageInfo.b);
      ((ImageView)paramView.findViewById(2131368461)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramProfileImageInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.PhotoWall", 2, paramProfileImageInfo.toString());
      }
    }
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadBigImage() path = ");
      ((StringBuilder)localObject1).append(paramProfileImageInfo.c);
      QLog.i("Q.profilecard.PhotoWall", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramView == null) {
      return;
    }
    for (;;)
    {
      try
      {
        a(paramView);
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramProfileImageInfo.b));
        URL localURL = new URL("profile_img_big_fhd", null, paramProfileImageInfo.c);
        int j = ((URLDrawable)localObject1).getStatus();
        i = 1;
        if (j != 1) {
          break label226;
        }
        if (i != 0)
        {
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel == null) {
            break label231;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.b;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        paramView.setTag(paramProfileImageInfo.c);
        paramProfileImageInfo = (ImageView)paramView.findViewById(2131368461);
        if (paramProfileImageInfo != null)
        {
          paramProfileImageInfo.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramProfileImageInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramProfileImageInfo.toString());
        }
        paramView.setTag(null);
      }
      return;
      label226:
      int i = 0;
      continue;
      label231:
      localObject1 = null;
    }
  }
  
  public int getCount()
  {
    FriendProfileImageModel localFriendProfileImageModel = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel;
    if (localFriendProfileImageModel != null) {
      return localFriendProfileImageModel.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    FriendProfileImageModel localFriendProfileImageModel = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel;
    if (localFriendProfileImageModel != null) {
      return localFriendProfileImageModel.a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559248, null);
      localObject = (ImageProgressCircle)localView.findViewById(2131368560);
      ((ImageProgressCircle)localObject).setVisibility(4);
      ImageView localImageView = (ImageView)localView.findViewById(2131368461);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      paramView = (FriendProfileImageModel.ProfileImageInfo)getItem(paramInt);
      if (paramView != null) {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a.getTroopFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b, (byte)1, false, false);
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = ImageUtil.c();
          }
          localImageView.setImageDrawable(paramView);
        }
        else if (paramView.jdField_a_of_type_Int == 6)
        {
          c(paramView, localView);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(paramView.c);
            QLog.d("Q.profilecard.PhotoWall", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if ((paramView.jdField_a_of_type_Int != 3) && (paramView.jdField_a_of_type_Int != 4))
        {
          localImageView.setImageResource(2130851161);
        }
        else
        {
          b(paramView, localView);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("thumb: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(",");
            localStringBuilder.append(paramView.b);
            QLog.d("Q.profilecard.PhotoWall", 2, localStringBuilder.toString());
          }
          if (paramView.jdField_a_of_type_Boolean) {
            a((ImageProgressCircle)localObject);
          }
        }
      }
      localObject = localView;
      if (AppSetting.d)
      {
        localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691182));
        localObject = localView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof ImageProgressCircle)))
    {
      paramMessage = (ImageProgressCircle)paramMessage.obj;
      if (paramMessage.getVisibility() != 0) {
        paramMessage.setVisibility(0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.FriendProfileImageAdapter
 * JD-Core Version:    0.7.0.1
 */