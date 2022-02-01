package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VideoInviteFloatBar
  implements View.OnClickListener, View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  Intent jdField_a_of_type_AndroidContentIntent = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoInviteFloatBar.1(this);
  String jdField_a_of_type_JavaLangString = null;
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 2131756203;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  public VideoInviteFloatBar(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559778, null);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  public TextView a()
  {
    return (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371697);
  }
  
  public void a()
  {
    Log.i("VideoInviteFloatBar", "hide");
    if (!this.e) {
      return;
    }
    this.e = false;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBar", 2, "hide removeView start");
      }
      if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("VideoInviteFloatBar", 2, "hide removeView end");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hide error : ");
        localStringBuilder.append(localException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366401)).setImageBitmap(paramBitmap);
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366401)).setImageBitmap(paramBitmap);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371697)).setText(paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370825));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show, mIsAudioMode[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject).append("], misMultiCall[");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    ((StringBuilder)localObject).append("], mIsMultiIncomingCall[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoInviteFloatBar", 1, ((StringBuilder)localObject).toString());
    if (this.e) {
      return;
    }
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370825);
    Button localButton1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361821);
    Button localButton2 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376380);
    localButton1.setClickable(true);
    localButton2.setClickable(true);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    if (paramBoolean3)
    {
      if (this.jdField_c_of_type_Boolean) {
        ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131695350));
      } else {
        ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131695351));
      }
    }
    else if (this.jdField_c_of_type_Boolean) {
      ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131695349));
    } else {
      ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131695352));
    }
    b();
    int i = this.jdField_a_of_type_Int;
    if (i > 0) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, i * 1000);
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBar", 2, "initTN");
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 2098088;
      if (Build.VERSION.SDK_INT >= 26) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;
      } else {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2010;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      if (Build.VERSION.SDK_INT >= 19)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 49;
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = this.jdField_b_of_type_Int;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBar", 2, "startHandler addView start");
      }
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      this.e = true;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoInviteFloatBar", 2, "startHandler addView end");
        return;
      }
    }
    catch (Exception localException2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startHandler error : ");
      localStringBuilder.append(localException2);
      AVLog.printErrorLog("VideoInviteFloatBar", localStringBuilder.toString());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHandler error : ");
        localStringBuilder.append(localSecurityException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHandler error : ");
        localStringBuilder.append(localBadTokenException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      StringBuilder localStringBuilder;
      this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHandler error : ");
        localStringBuilder.append(localIllegalStateException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378731));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void c()
  {
    Object localObject = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361821);
    Button localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376380);
    ((Button)localObject).setVisibility(4);
    localButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370825);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370825));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void d(String paramString)
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371697)).setText(paramString);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    long l;
    Object localObject;
    if (i != 2131361821)
    {
      if (i == 2131376380)
      {
        l = AudioHelper.b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick reject, mIsMultiIncomingCall[");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject).append("], misMultiCall[");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.w("VideoInviteFloatBar", 1, ((StringBuilder)localObject).toString());
        localObject = new Intent();
        SeqUtil.a((Intent)localObject, l);
        if (this.jdField_b_of_type_Boolean) {
          ((Intent)localObject).setAction("tencent.video.invite.multirefuse");
        } else if (this.jdField_d_of_type_Boolean) {
          ((Intent)localObject).setAction("tencent.video.invite.gaignore");
        } else {
          ((Intent)localObject).setAction("tencent.video.invite.refuse");
        }
        ((Intent)localObject).setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
        a();
      }
    }
    else
    {
      l = AudioHelper.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick accept, mIsMultiIncomingCall[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append("], misMultiCall[");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("VideoInviteFloatBar", 1, ((StringBuilder)localObject).toString());
      localObject = new Intent();
      SeqUtil.a((Intent)localObject, l);
      if (this.jdField_b_of_type_Boolean) {
        ((Intent)localObject).setAction("tencent.video.invite.multiaccept");
      } else if (this.jdField_d_of_type_Boolean) {
        ((Intent)localObject).setAction("tencent.video.invite.gaaccept");
      } else {
        ((Intent)localObject).setAction("tencent.video.invite.accept");
      }
      ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361821)).setClickable(false);
      ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376380)).setClickable(false);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
    paramView = new StringBuilder();
    paramView.append("currX");
    paramView.append(this.jdField_c_of_type_Float);
    paramView.append("====currY");
    paramView.append(this.jdField_d_of_type_Float);
    Log.i("currP", paramView.toString());
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if (paramMotionEvent.getY() - this.jdField_b_of_type_Float < 0.0F)
      {
        a();
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBar
 * JD-Core Version:    0.7.0.1
 */