package com.tencent.av.ui.bar;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class MultiVideoBarHelper
{
  public static Bitmap a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FaceDrawable.getUserFaceDrawable(paramQQAppInterface, paramString, (byte)2).getLoadedBitmap();
    paramString = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramString = ImageUtil.f();
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Message paramMessage, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    View localView = paramView.findViewById(2131371605);
    TextView localTextView = (TextView)paramView.findViewById(2131371585);
    ImageView localImageView = (ImageView)paramView.findViewById(2131371584);
    Object localObject;
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      l = ((Long)paramMessage.obj).longValue();
      i = paramQQAppInterface.getAVNotifyCenter().b(l);
      localObject = (LinearLayout)paramView.findViewById(2131371581);
      if (i == 2)
      {
        paramMessage = paramQQAppInterface.getAVNotifyCenter().a(l);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new ImageView[3];
        localObject[0] = ((ImageView)paramView.findViewById(2131363137));
        localObject[1] = ((ImageView)paramView.findViewById(2131363139));
        localObject[2] = ((ImageView)paramView.findViewById(2131363141));
        if ((paramMessage != null) && (paramMessage.size() != 0))
        {
          if (paramMessage.size() == 1)
          {
            localObject[0].setVisibility(0);
            localObject[1].setVisibility(8);
            localObject[2].setVisibility(8);
            localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(0)).a), paramQQAppInterface));
          }
          else if (paramMessage.size() == 2)
          {
            localObject[0].setVisibility(0);
            localObject[1].setVisibility(0);
            localObject[2].setVisibility(8);
            localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(0)).a), paramQQAppInterface));
            localObject[1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(1)).a), paramQQAppInterface));
          }
          else
          {
            i = 0;
            while (i < localObject.length)
            {
              localObject[i].setVisibility(0);
              localObject[i].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(i)).a), paramQQAppInterface));
              i += 1;
            }
          }
        }
        else
        {
          j = localObject.length;
          i = 0;
          while (i < j)
          {
            localObject[i].setVisibility(8);
            i += 1;
          }
        }
      }
      else
      {
        ((LinearLayout)localObject).setVisibility(0);
      }
    }
    int i = paramQQAppInterface.getAVNotifyCenter().e();
    int j = paramQQAppInterface.getAVNotifyCenter().b();
    long l = paramQQAppInterface.getAVNotifyCenter().c();
    boolean bool;
    if (paramQQAppInterface.getAVNotifyCenter().g() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("updateMultiVideoBar, randomStatus[");
      paramView.append(j);
      paramView.append("], sessionType[");
      paramView.append(i);
      paramView.append("], guildGroupId[");
      paramView.append(l);
      paramView.append("], getSmallScreenState[");
      paramView.append(paramQQAppInterface.getAVNotifyCenter().g());
      paramView.append("]");
      QLog.w("MultiVideoBarHelper", 1, paramView.toString());
    }
    if (l > 0L)
    {
      j = paramQQAppInterface.getAVNotifyCenter().d();
      if (j < 2)
      {
        localTextView.setText(2131689913);
      }
      else
      {
        paramView = paramQQAppInterface.getAVNotifyCenter().b();
        if ((paramView != null) && (paramView.equals("1"))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          i = 2131695695;
        } else {
          i = 2131695694;
        }
        paramMessage = paramQQAppInterface.getApp().getString(i);
        paramView = paramQQAppInterface.getAVNotifyCenter().e();
        paramMessage = String.format(paramMessage, new Object[] { Integer.valueOf(j) });
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramView);
        localTextView.setText(((StringBuilder)localObject).toString());
      }
      SmallScreenUtils.a(localView, bool, paramBoolean);
    }
    else if (j == 6)
    {
      localTextView.setText(paramQQAppInterface.getApp().getString(2131695696));
      SmallScreenUtils.a(localView, bool, paramBoolean);
    }
    else if (j >= 5)
    {
      paramView = paramQQAppInterface.getApp().getString(2131695694);
      paramMessage = new StringBuilder();
      paramMessage.append(paramView);
      paramMessage.append(" ");
      paramView = paramMessage.toString();
      paramMessage = new StringBuilder();
      paramMessage.append(paramView);
      paramMessage.append(paramQQAppInterface.getAVNotifyCenter().e());
      localTextView.setText(paramMessage.toString());
      SmallScreenUtils.a(localView, bool, paramBoolean);
    }
    else if ((j >= 1) && (j < 5))
    {
      localTextView.setText(paramQQAppInterface.getApp().getString(2131695380));
      SmallScreenUtils.a(localView, bool, paramBoolean);
    }
    else if ((i != 3) && (i != 4))
    {
      if (i == 1)
      {
        if (paramQQAppInterface.getAVNotifyCenter().f())
        {
          localTextView.setText(2131695981);
        }
        else
        {
          paramView = paramQQAppInterface.getAVNotifyCenter().e();
          paramMessage = paramQQAppInterface.getApp().getString(2131695371);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramMessage);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramView);
          localTextView.setText(((StringBuilder)localObject).toString());
        }
        UITools.a(localView, paramQQAppInterface.getApp().getString(2131690209));
        SmallScreenUtils.a(localView, bool, paramBoolean);
      }
      else if ((i == 2) && (!paramQQAppInterface.getAVNotifyCenter().k()))
      {
        if (paramQQAppInterface.getAVNotifyCenter().f())
        {
          localTextView.setText(2131695981);
        }
        else
        {
          paramView = paramQQAppInterface.getAVNotifyCenter().e();
          paramMessage = paramQQAppInterface.getApp().getString(2131695954);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramMessage);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramView);
          localTextView.setText(((StringBuilder)localObject).toString());
        }
        UITools.a(localView, paramQQAppInterface.getApp().getString(2131690209));
        SmallScreenUtils.a(localView, bool, paramBoolean);
      }
      else
      {
        SmallScreenUtils.a(localView, false, paramBoolean);
      }
    }
    else
    {
      l = paramQQAppInterface.getAVNotifyCenter().b();
      i = paramQQAppInterface.getAVNotifyCenter().b(l);
      j = paramQQAppInterface.getAVNotifyCenter().f();
      if (paramQQAppInterface.getAVNotifyCenter().f())
      {
        localTextView.setText(2131689913);
        if ((i == 2) && (!paramQQAppInterface.getAVNotifyCenter().a(String.valueOf(l)))) {
          localImageView.setImageDrawable(null);
        }
      }
      for (;;)
      {
        break;
        l = paramQQAppInterface.getAVNotifyCenter().b();
        int k = paramQQAppInterface.getAVNotifyCenter().a();
        localObject = paramQQAppInterface.getAVNotifyCenter().e();
        if (j == 3000)
        {
          paramMessage = paramQQAppInterface.getApp().getString(2131689905);
          paramView = paramMessage;
          if (i == 2) {
            paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719735), paramQQAppInterface.getApp().getString(2131719736));
          }
        }
        for (;;)
        {
          break;
          if (j != 1) {
            break label1591;
          }
          paramMessage = paramQQAppInterface.getApp().getString(2131689898);
          paramView = paramMessage;
          if (i == 2)
          {
            paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719735), paramQQAppInterface.getApp().getString(2131719736));
            localImageView.setImageDrawable(null);
          }
        }
        l = paramQQAppInterface.getAVNotifyCenter().a(k, l);
        if ((localView != null) && (l == 0L))
        {
          SmallScreenUtils.a(localView, false, paramBoolean);
          return;
        }
        if (localView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiVideoBarHelper", 2, "updateMultiVideoBar-->multiVideoBar is null");
          }
          return;
        }
        paramView = String.format(paramView, new Object[] { Long.valueOf(l) });
        paramMessage = new StringBuilder();
        paramMessage.append(paramView);
        paramMessage.append(" ");
        paramMessage.append((String)localObject);
        localTextView.setText(paramMessage.toString());
      }
      if (j == 1)
      {
        paramMessage = paramQQAppInterface.getApp().getString(2131692839);
        paramView = paramMessage;
        if (i == 2) {
          paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719735), paramQQAppInterface.getApp().getString(2131719736));
        }
        UITools.a(localView, paramView);
      }
      else if (j == 3000)
      {
        paramMessage = paramQQAppInterface.getApp().getString(2131692838);
        paramView = paramMessage;
        if (i == 2) {
          paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131719735), paramQQAppInterface.getApp().getString(2131719736));
        }
        UITools.a(localView, paramView);
      }
      SmallScreenUtils.a(localView, bool, paramBoolean);
    }
    ReportController.a(paramQQAppInterface, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 1, 0, "", "", "", "");
    return;
    label1591:
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("updateMultiVideoBar-->wrong type of UinType.uintype=");
      paramQQAppInterface.append(j);
      QLog.e("MultiVideoBarHelper", 2, paramQQAppInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.bar.MultiVideoBarHelper
 * JD-Core Version:    0.7.0.1
 */