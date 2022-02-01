package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import wvk;
import wvl;
import wvm;
import wvn;
import wvo;
import wvq;
import wwz;
import wxa;
import wxb;
import wxc;
import wxd;
import wxe;
import wxf;
import wxh;
import wxi;
import wxj;

@TargetApi(14)
public class TextureVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl
{
  public int a;
  protected Uri a;
  protected Surface a;
  public MediaController a;
  public String a;
  protected Map<String, String> a;
  public wwz a;
  private wxa jdField_a_of_type_Wxa = new wvq(this);
  public wxb a;
  public wxc a;
  public wxd a;
  public wxe a;
  protected wxf a;
  wxh jdField_a_of_type_Wxh = new wvk(this);
  protected wxi a;
  public int b;
  private wxb jdField_b_of_type_Wxb = new wvm(this);
  private wxc jdField_b_of_type_Wxc = new wvo(this);
  private wxd jdField_b_of_type_Wxd = new wvn(this);
  wxe jdField_b_of_type_Wxe = new wvl(this);
  public boolean b;
  protected int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  protected boolean e;
  public int f;
  public boolean f;
  public int g;
  protected boolean g;
  
  public TextureVideoView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.player.TextureVideoView";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    b();
  }
  
  private Activity a()
  {
    try
    {
      for (Context localContext = getContext(); (localContext instanceof ContextWrapper); localContext = ((ContextWrapper)localContext).getBaseContext()) {
        if ((localContext instanceof Activity)) {
          return (Activity)localContext;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 117	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: iconst_0
    //   17: invokespecial 119	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:b	(Z)V
    //   20: iload_1
    //   21: ifeq +25 -> 46
    //   24: aload_0
    //   25: invokespecial 120	android/view/TextureView:getContext	()Landroid/content/Context;
    //   28: invokevirtual 125	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: ldc 127
    //   33: invokevirtual 131	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 133	android/media/AudioManager
    //   39: aconst_null
    //   40: iconst_3
    //   41: iconst_1
    //   42: invokevirtual 137	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: invokevirtual 140	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:a	()Lwwz;
    //   51: putfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   54: aload_0
    //   55: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   58: aload_0
    //   59: getfield 144	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_e_of_type_Boolean	Z
    //   62: invokeinterface 148 2 0
    //   67: aload_0
    //   68: getfield 150	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_c_of_type_Int	I
    //   71: ifeq +300 -> 371
    //   74: aload_0
    //   75: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   78: aload_0
    //   79: getfield 150	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_c_of_type_Int	I
    //   82: invokeinterface 153 2 0
    //   87: aload_0
    //   88: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   91: aload_0
    //   92: getfield 63	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxe	Lwxe;
    //   95: invokeinterface 156 2 0
    //   100: aload_0
    //   101: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   104: aload_0
    //   105: getfield 58	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wxh	Lwxh;
    //   108: invokeinterface 159 2 0
    //   113: aload_0
    //   114: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   117: aload_0
    //   118: getfield 68	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxb	Lwxb;
    //   121: invokeinterface 162 2 0
    //   126: aload_0
    //   127: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   130: aload_0
    //   131: getfield 78	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxc	Lwxc;
    //   134: invokeinterface 165 2 0
    //   139: aload_0
    //   140: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   143: aload_0
    //   144: getfield 73	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxd	Lwxd;
    //   147: invokeinterface 168 2 0
    //   152: aload_0
    //   153: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   156: aload_0
    //   157: getfield 83	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wxa	Lwxa;
    //   160: invokeinterface 171 2 0
    //   165: aload_0
    //   166: getfield 173	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wxf	Lwxf;
    //   169: ifnull +16 -> 185
    //   172: aload_0
    //   173: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   176: aload_0
    //   177: getfield 173	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wxf	Lwxf;
    //   180: invokeinterface 176 2 0
    //   185: aload_0
    //   186: iconst_0
    //   187: putfield 178	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_f_of_type_Int	I
    //   190: aload_0
    //   191: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   194: aload_0
    //   195: invokevirtual 93	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:getContext	()Landroid/content/Context;
    //   198: invokevirtual 125	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   201: aload_0
    //   202: getfield 115	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   205: aload_0
    //   206: getfield 180	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   209: invokeinterface 183 4 0
    //   214: aload_0
    //   215: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   218: aload_0
    //   219: getfield 117	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   222: invokeinterface 186 2 0
    //   227: aload_0
    //   228: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   231: iconst_3
    //   232: invokeinterface 188 2 0
    //   237: aload_0
    //   238: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   241: iconst_1
    //   242: invokeinterface 189 2 0
    //   247: aload_0
    //   248: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   251: invokeinterface 190 1 0
    //   256: aload_0
    //   257: iconst_1
    //   258: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   261: aload_0
    //   262: invokespecial 192	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:d	()V
    //   265: return
    //   266: astore_2
    //   267: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +34 -> 304
    //   273: aload_0
    //   274: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   277: iconst_2
    //   278: new 200	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   285: ldc 204
    //   287: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_0
    //   291: getfield 115	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   294: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: aload_2
    //   301: invokestatic 219	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   304: aload_0
    //   305: iconst_m1
    //   306: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   309: aload_0
    //   310: iconst_m1
    //   311: putfield 51	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Int	I
    //   314: aload_0
    //   315: getfield 78	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxc	Lwxc;
    //   318: aload_0
    //   319: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   322: iconst_1
    //   323: iconst_0
    //   324: invokeinterface 224 4 0
    //   329: pop
    //   330: return
    //   331: astore_2
    //   332: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -289 -> 46
    //   338: aload_0
    //   339: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   342: iconst_2
    //   343: new 200	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   350: ldc 226
    //   352: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokestatic 230	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   359: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 233	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: goto -322 -> 46
    //   371: aload_0
    //   372: aload_0
    //   373: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   376: invokeinterface 236 1 0
    //   381: putfield 150	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_c_of_type_Int	I
    //   384: goto -297 -> 87
    //   387: astore_2
    //   388: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +34 -> 425
    //   394: aload_0
    //   395: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   398: iconst_2
    //   399: new 200	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   406: ldc 204
    //   408: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: getfield 115	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   415: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload_2
    //   422: invokestatic 219	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: aload_0
    //   426: iconst_m1
    //   427: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   430: aload_0
    //   431: iconst_m1
    //   432: putfield 51	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Int	I
    //   435: aload_0
    //   436: getfield 78	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxc	Lwxc;
    //   439: aload_0
    //   440: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   443: iconst_1
    //   444: iconst_0
    //   445: invokeinterface 224 4 0
    //   450: pop
    //   451: return
    //   452: astore_2
    //   453: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +14 -> 470
    //   459: aload_0
    //   460: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   463: iconst_2
    //   464: ldc 238
    //   466: aload_2
    //   467: invokestatic 219	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_0
    //   471: iconst_m1
    //   472: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   475: aload_0
    //   476: iconst_m1
    //   477: putfield 51	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Int	I
    //   480: aload_0
    //   481: getfield 78	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Wxc	Lwxc;
    //   484: aload_0
    //   485: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Wwz	Lwwz;
    //   488: iconst_1
    //   489: iconst_0
    //   490: invokeinterface 224 4 0
    //   495: pop
    //   496: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	TextureVideoView
    //   0	497	1	paramBoolean	boolean
    //   266	35	2	localIOException	java.io.IOException
    //   331	25	2	localException	Exception
    //   387	35	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   452	15	2	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   46	87	266	java/io/IOException
    //   87	185	266	java/io/IOException
    //   185	265	266	java/io/IOException
    //   371	384	266	java/io/IOException
    //   24	46	331	java/lang/Exception
    //   46	87	387	java/lang/IllegalArgumentException
    //   87	185	387	java/lang/IllegalArgumentException
    //   185	265	387	java/lang/IllegalArgumentException
    //   371	384	387	java/lang/IllegalArgumentException
    //   46	87	452	java/lang/IllegalStateException
    //   87	185	452	java/lang/IllegalStateException
    //   185	265	452	java/lang/IllegalStateException
    //   371	384	452	java/lang/IllegalStateException
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Wwz != null) && (this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
  }
  
  private void b()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    super.setSurfaceTextureListener(this);
    super.setFocusable(true);
    super.setFocusableInTouchMode(true);
    super.requestFocus();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wwz != null) {
      this.jdField_a_of_type_Wwz.e();
    }
    try
    {
      this.jdField_a_of_type_Wwz.g();
      this.jdField_a_of_type_Wwz.f();
      this.jdField_a_of_type_Wwz = null;
      this.jdField_a_of_type_Int = 0;
      if (paramBoolean) {
        this.jdField_b_of_type_Int = 0;
      }
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      for (;;)
      {
        IllegalStateException localIllegalStateException2 = new IllegalStateException("CatchedException, caused by: ", localIllegalStateException1);
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mMediaPlayer.release() throw a exception!!", localIllegalStateException2);
      }
    }
  }
  
  private void c()
  {
    if (!this.jdField_f_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Wwz != null) && (this.jdField_a_of_type_AndroidWidgetMediaController != null))
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.setAnchorView((View)localObject);
      this.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(a());
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
  }
  
  protected wwz a()
  {
    return new wxj();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Wwz != null)
    {
      this.jdField_a_of_type_Wwz.e();
      this.jdField_a_of_type_Wwz.f();
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz.a(null);
      this.jdField_a_of_type_Wwz = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  public boolean canPause()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean canSeekBackward()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean canSeekForward()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int getAudioSessionId()
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.jdField_c_of_type_Int = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.jdField_c_of_type_Int;
  }
  
  public int getBufferPercentage()
  {
    if (this.jdField_a_of_type_Wwz != null) {
      return this.jdField_f_of_type_Int;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (a()) {
      return this.jdField_a_of_type_Wwz.b();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (a()) {
      return this.jdField_a_of_type_Wwz.a();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (a()) && (this.jdField_a_of_type_Wwz.a());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextureVideoView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6))
    {
      i = 1;
      if ((!a()) || (i == 0) || (this.jdField_a_of_type_AndroidWidgetMediaController == null)) {
        break label188;
      }
      if ((paramInt != 79) && (paramInt != 85)) {
        break label116;
      }
      if (!this.jdField_a_of_type_Wwz.a()) {
        break label103;
      }
      pause();
      this.jdField_a_of_type_AndroidWidgetMediaController.show();
    }
    label103:
    label116:
    do
    {
      do
      {
        return true;
        i = 0;
        break;
        start();
        this.jdField_a_of_type_AndroidWidgetMediaController.hide();
        return true;
        if (paramInt != 126) {
          break label147;
        }
      } while (this.jdField_a_of_type_Wwz.a());
      start();
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return true;
      if ((paramInt != 86) && (paramInt != 127)) {
        break label184;
      }
    } while (!this.jdField_a_of_type_Wwz.a());
    label147:
    pause();
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
    return true;
    label184:
    e();
    label188:
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = TextureView.getDefaultSize(this.jdField_d_of_type_Int, paramInt1);
    int m = TextureView.getDefaultSize(this.jdField_e_of_type_Int, paramInt2);
    int j = m;
    int i = k;
    int n;
    if (this.jdField_d_of_type_Int > 0)
    {
      j = m;
      i = k;
      if (this.jdField_e_of_type_Int > 0)
      {
        m = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        n = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((m != 1073741824) || (n != 1073741824)) {
          break label207;
        }
        if (this.jdField_d_of_type_Int * paramInt2 >= this.jdField_e_of_type_Int * paramInt1) {
          break label149;
        }
        if (!this.jdField_g_of_type_Boolean) {
          break label131;
        }
        i = this.jdField_d_of_type_Int * paramInt2 / this.jdField_e_of_type_Int;
        j = paramInt2;
      }
    }
    for (;;)
    {
      super.setMeasuredDimension(i, j);
      return;
      label131:
      j = this.jdField_e_of_type_Int * paramInt1 / this.jdField_d_of_type_Int;
      i = paramInt1;
      continue;
      label149:
      if (this.jdField_d_of_type_Int * paramInt2 > this.jdField_e_of_type_Int * paramInt1)
      {
        if (this.jdField_g_of_type_Boolean)
        {
          j = this.jdField_e_of_type_Int * paramInt1 / this.jdField_d_of_type_Int;
          i = paramInt1;
        }
        else
        {
          i = this.jdField_d_of_type_Int * paramInt2 / this.jdField_e_of_type_Int;
          j = paramInt2;
          continue;
          label207:
          if (m == 1073741824)
          {
            j = this.jdField_e_of_type_Int * paramInt1 / this.jdField_d_of_type_Int;
            if ((n == -2147483648) && (j > paramInt2))
            {
              j = paramInt2;
              i = paramInt1;
            }
          }
          else
          {
            if (n == 1073741824)
            {
              k = this.jdField_d_of_type_Int * paramInt2 / this.jdField_e_of_type_Int;
              j = paramInt2;
              i = k;
              if (m != -2147483648) {
                continue;
              }
              j = paramInt2;
              i = k;
              if (k <= paramInt1) {
                continue;
              }
              j = paramInt2;
              i = paramInt1;
              continue;
            }
            k = this.jdField_d_of_type_Int;
            i = this.jdField_e_of_type_Int;
            if ((n == -2147483648) && (i > paramInt2)) {
              k = this.jdField_d_of_type_Int * paramInt2 / this.jdField_e_of_type_Int;
            }
            for (;;)
            {
              j = paramInt2;
              i = k;
              if (m != -2147483648) {
                break;
              }
              j = paramInt2;
              i = k;
              if (k <= paramInt1) {
                break;
              }
              j = this.jdField_e_of_type_Int * paramInt1 / this.jdField_d_of_type_Int;
              i = paramInt1;
              break;
              paramInt2 = i;
            }
          }
          i = paramInt1;
        }
      }
      else
      {
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewSurface = new Surface(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceTextureAvailable: openVideo");
    }
    c();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    b(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    if (this.jdField_b_of_type_Int == 3)
    {
      i = 1;
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label67;
      }
    }
    label67:
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if ((this.jdField_a_of_type_Wwz != null) && (i != 0) && (paramInt1 != 0))
      {
        if (this.jdField_g_of_type_Int != 0) {
          seekTo(this.jdField_g_of_type_Int);
        }
        start();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Wxi != null) {
      this.jdField_a_of_type_Wxi.a(paramSurfaceTexture);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      e();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      e();
    }
    return false;
  }
  
  public void pause()
  {
    if ((a()) && (this.jdField_a_of_type_Wwz.a()))
    {
      this.jdField_a_of_type_Wwz.d();
      this.jdField_a_of_type_Int = 4;
    }
    this.jdField_b_of_type_Int = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (a())
    {
      this.jdField_a_of_type_Wwz.a(paramInt);
      this.jdField_g_of_type_Int = 0;
      return;
    }
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setCenterInside(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Wwz != null) {
      this.jdField_a_of_type_Wwz.a(paramBoolean);
    }
  }
  
  public void setOnCompletionListener(wxb paramwxb)
  {
    this.jdField_a_of_type_Wxb = paramwxb;
  }
  
  public void setOnErrorListener(wxc paramwxc)
  {
    this.jdField_a_of_type_Wxc = paramwxc;
  }
  
  public void setOnInfoListener(wxd paramwxd)
  {
    this.jdField_a_of_type_Wxd = paramwxd;
  }
  
  public void setOnPreparedListener(wxe paramwxe)
  {
    this.jdField_a_of_type_Wxe = paramwxe;
  }
  
  public void setOnSeekCompleteListener(wxf paramwxf)
  {
    this.jdField_a_of_type_Wxf = paramwxf;
    if (this.jdField_a_of_type_Wwz != null) {
      this.jdField_a_of_type_Wwz.a(paramwxf);
    }
  }
  
  public void setVideoPath(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = Uri.parse(paramString))
    {
      setVideoURI(paramString);
      return;
    }
  }
  
  public void setVideoURI(Uri paramUri)
  {
    setVideoURI(paramUri, null);
  }
  
  public void setVideoURI(Uri paramUri, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_g_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setVideoURI: openVideo");
    }
    c();
    super.requestLayout();
    super.invalidate();
  }
  
  public void setmOnTextureUpdateListener(wxi paramwxi)
  {
    this.jdField_a_of_type_Wxi = paramwxi;
  }
  
  public void start()
  {
    if (a())
    {
      this.jdField_a_of_type_Wwz.c();
      this.jdField_a_of_type_Int = 3;
    }
    this.jdField_b_of_type_Int = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView
 * JD-Core Version:    0.7.0.1
 */