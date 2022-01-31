package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import kbj;

public class VideoInviteFloatBar
  implements View.OnClickListener, View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  Intent jdField_a_of_type_AndroidContentIntent = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new kbj(this);
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 2131624718;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 1;
  
  public VideoInviteFloatBar(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130969368, null);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  public TextView a()
  {
    return (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362754);
  }
  
  public void a()
  {
    Log.i("VideoInviteFloatBar", "hide");
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      for (;;)
      {
        return;
        this.jdField_b_of_type_Boolean = false;
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
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoInviteFloatBar", 2, "hide error : " + localException);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    QLog.d("VideoInviteFloatBar", 1, "show type = " + paramInt + ", isMultiCall = " + paramBoolean);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363990);
    Button localButton1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366296);
    Button localButton2 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366295);
    localButton1.setClickable(true);
    localButton2.setClickable(true);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    if (paramBoolean) {
      if (paramInt == 1) {
        localTextView.setText("邀请你QQ语音通话，接听将挂断当前通话。");
      }
    }
    for (;;)
    {
      b();
      if (this.jdField_b_of_type_Int <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_b_of_type_Int * 1000);
      return;
      if (paramInt == 0)
      {
        localTextView.setText("邀请你QQ视频通话，接听将挂断当前通话。");
      }
      else
      {
        localTextView.setText("邀请你加入QQ电话，接听将挂断当前通话。");
        continue;
        if (paramInt == 1) {
          localTextView.setText("邀请你QQ语音通话...");
        } else if (paramInt == 0) {
          localTextView.setText("邀请你QQ视频通话...");
        } else {
          localTextView.setText("邀请你加入QQ电话...");
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362739)).setImageBitmap(paramBitmap);
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362739)).setImageBitmap(paramBitmap);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362754)).setText(paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363990));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 100
    //   8: iconst_2
    //   9: ldc 211
    //   11: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: new 213	android/view/WindowManager$LayoutParams
    //   18: dup
    //   19: invokespecial 214	android/view/WindowManager$LayoutParams:<init>	()V
    //   22: putfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   25: aload_0
    //   26: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   29: bipush 254
    //   31: putfield 219	android/view/WindowManager$LayoutParams:height	I
    //   34: aload_0
    //   35: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   38: iconst_m1
    //   39: putfield 222	android/view/WindowManager$LayoutParams:width	I
    //   42: aload_0
    //   43: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   46: ldc 223
    //   48: putfield 226	android/view/WindowManager$LayoutParams:flags	I
    //   51: aload_0
    //   52: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   55: sipush 2010
    //   58: putfield 229	android/view/WindowManager$LayoutParams:type	I
    //   61: aload_0
    //   62: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   65: bipush 253
    //   67: putfield 232	android/view/WindowManager$LayoutParams:format	I
    //   70: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 19
    //   75: if_icmplt +19 -> 94
    //   78: aload_0
    //   79: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   82: astore_1
    //   83: aload_1
    //   84: aload_1
    //   85: getfield 226	android/view/WindowManager$LayoutParams:flags	I
    //   88: ldc 238
    //   90: ior
    //   91: putfield 226	android/view/WindowManager$LayoutParams:flags	I
    //   94: aload_0
    //   95: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   98: bipush 49
    //   100: putfield 241	android/view/WindowManager$LayoutParams:gravity	I
    //   103: aload_0
    //   104: getfield 34	com/tencent/av/ui/VideoInviteFloatBar:jdField_c_of_type_Int	I
    //   107: iconst_m1
    //   108: if_icmpeq +14 -> 122
    //   111: aload_0
    //   112: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   115: aload_0
    //   116: getfield 34	com/tencent/av/ui/VideoInviteFloatBar:jdField_c_of_type_Int	I
    //   119: putfield 244	android/view/WindowManager$LayoutParams:windowAnimations	I
    //   122: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +11 -> 136
    //   128: ldc 100
    //   130: iconst_2
    //   131: ldc 246
    //   133: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_0
    //   137: getfield 70	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   140: aload_0
    //   141: getfield 81	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   144: aload_0
    //   145: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   148: invokeinterface 250 3 0
    //   153: aload_0
    //   154: iconst_1
    //   155: putfield 110	com/tencent/av/ui/VideoInviteFloatBar:jdField_b_of_type_Boolean	Z
    //   158: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +11 -> 172
    //   164: ldc 100
    //   166: iconst_2
    //   167: ldc 252
    //   169: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: return
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   178: goto -56 -> 122
    //   181: astore_1
    //   182: aload_0
    //   183: getfield 70	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   186: aload_0
    //   187: getfield 81	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   190: aload_0
    //   191: getfield 216	com/tencent/av/ui/VideoInviteFloatBar:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   194: invokeinterface 258 3 0
    //   199: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -30 -> 172
    //   205: ldc 100
    //   207: iconst_2
    //   208: new 129	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 260
    //   218: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_1
    //   222: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: return
    //   232: astore_1
    //   233: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -64 -> 172
    //   239: ldc 100
    //   241: iconst_2
    //   242: new 129	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 260
    //   252: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: return
    //   266: astore_1
    //   267: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -98 -> 172
    //   273: ldc 100
    //   275: iconst_2
    //   276: new 129	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 260
    //   286: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: return
    //   300: astore_1
    //   301: ldc 100
    //   303: new 129	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 260
    //   313: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_1
    //   317: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 266	com/tencent/av/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	VideoInviteFloatBar
    //   82	3	1	localLayoutParams	WindowManager.LayoutParams
    //   173	2	1	localException1	Exception
    //   181	41	1	localIllegalStateException	java.lang.IllegalStateException
    //   232	24	1	localBadTokenException	android.view.WindowManager.BadTokenException
    //   266	24	1	localSecurityException	java.lang.SecurityException
    //   300	17	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   14	94	173	java/lang/Exception
    //   94	122	173	java/lang/Exception
    //   122	136	181	java/lang/IllegalStateException
    //   136	172	181	java/lang/IllegalStateException
    //   122	136	232	android/view/WindowManager$BadTokenException
    //   136	172	232	android/view/WindowManager$BadTokenException
    //   122	136	266	java/lang/SecurityException
    //   136	172	266	java/lang/SecurityException
    //   122	136	300	java/lang/Exception
    //   136	172	300	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366294));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void c()
  {
    Object localObject = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366296);
    Button localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366295);
    ((Button)localObject).setVisibility(4);
    localButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363990);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363990));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void d(String paramString)
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362754)).setText(paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366296: 
      QLog.d("VideoInviteFloatBar", 1, "avideo onClick accept,mIsMultiCall = " + this.jdField_a_of_type_Boolean);
      paramView = new Intent();
      if (this.jdField_a_of_type_Boolean) {
        paramView.setAction("tencent.video.invite.multiaccept");
      }
      for (;;)
      {
        ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366296)).setClickable(false);
        ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366295)).setClickable(false);
        paramView.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramView);
        return;
        if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 0)) {
          paramView.setAction("tencent.video.invite.accept");
        } else {
          paramView.setAction("tencent.video.invite.gaaccept");
        }
      }
    }
    QLog.d("VideoInviteFloatBar", 1, "avideo onClick reject,mIsMultiCall = " + this.jdField_a_of_type_Boolean);
    paramView = new Intent();
    if (this.jdField_a_of_type_Boolean) {
      paramView.setAction("tencent.video.invite.multirefuse");
    }
    for (;;)
    {
      paramView.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramView);
      a();
      return;
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 0)) {
        paramView.setAction("tencent.video.invite.refuse");
      } else {
        paramView.setAction("tencent.video.invite.gaignore");
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
    Log.i("currP", "currX" + this.jdField_c_of_type_Float + "====currY" + this.jdField_d_of_type_Float);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      if (paramMotionEvent.getY() - this.jdField_b_of_type_Float < 0.0F) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBar
 * JD-Core Version:    0.7.0.1
 */