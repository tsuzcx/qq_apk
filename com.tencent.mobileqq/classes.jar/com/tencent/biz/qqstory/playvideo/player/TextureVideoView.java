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
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.onTextureUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.MediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

@TargetApi(14)
public class TextureVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl
{
  protected int a;
  protected Uri a;
  protected Surface a;
  protected MediaController a;
  private IMediaPlayer.OnBufferingUpdateListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener = new TextureVideoView.6(this);
  protected IMediaPlayer.OnCompletionListener a;
  protected IMediaPlayer.OnErrorListener a;
  protected IMediaPlayer.OnInfoListener a;
  protected IMediaPlayer.OnPreparedListener a;
  protected IMediaPlayer.OnSeekCompleteListener a;
  IMediaPlayer.OnVideoSizeChangedListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener = new TextureVideoView.1(this);
  protected IMediaPlayer.onTextureUpdateListener a;
  protected IMediaPlayer a;
  protected String a;
  protected Map<String, String> a;
  protected int b;
  private IMediaPlayer.OnCompletionListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener = new TextureVideoView.3(this);
  private IMediaPlayer.OnErrorListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener = new TextureVideoView.5(this);
  private IMediaPlayer.OnInfoListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener = new TextureVideoView.4(this);
  IMediaPlayer.OnPreparedListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener = new TextureVideoView.2(this);
  protected boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  public boolean f;
  protected int g;
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
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = null;
    this.jdField_g_of_type_Boolean = false;
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
    //   1: getfield 121	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 53	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: iconst_0
    //   17: invokespecial 123	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:b	(Z)V
    //   20: iload_1
    //   21: ifeq +25 -> 46
    //   24: aload_0
    //   25: invokespecial 124	android/view/TextureView:getContext	()Landroid/content/Context;
    //   28: invokevirtual 129	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: ldc 131
    //   33: invokevirtual 135	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 137	android/media/AudioManager
    //   39: aconst_null
    //   40: iconst_3
    //   41: iconst_1
    //   42: invokevirtual 141	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: invokevirtual 144	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:a	()Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   51: putfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   54: aload_0
    //   55: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   58: aload_0
    //   59: getfield 146	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_e_of_type_Boolean	Z
    //   62: invokeinterface 150 2 0
    //   67: aload_0
    //   68: getfield 152	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_c_of_type_Int	I
    //   71: ifeq +300 -> 371
    //   74: aload_0
    //   75: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   78: aload_0
    //   79: getfield 152	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_c_of_type_Int	I
    //   82: invokeinterface 155 2 0
    //   87: aload_0
    //   88: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   91: aload_0
    //   92: getfield 69	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnPreparedListener;
    //   95: invokeinterface 158 2 0
    //   100: aload_0
    //   101: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   104: aload_0
    //   105: getfield 64	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnVideoSizeChangedListener;
    //   108: invokeinterface 161 2 0
    //   113: aload_0
    //   114: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   117: aload_0
    //   118: getfield 74	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnCompletionListener;
    //   121: invokeinterface 164 2 0
    //   126: aload_0
    //   127: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   130: aload_0
    //   131: getfield 84	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnErrorListener;
    //   134: invokeinterface 167 2 0
    //   139: aload_0
    //   140: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   143: aload_0
    //   144: getfield 79	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnInfoListener;
    //   147: invokeinterface 170 2 0
    //   152: aload_0
    //   153: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   156: aload_0
    //   157: getfield 89	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnBufferingUpdateListener;
    //   160: invokeinterface 173 2 0
    //   165: aload_0
    //   166: getfield 175	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnSeekCompleteListener;
    //   169: ifnull +16 -> 185
    //   172: aload_0
    //   173: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   176: aload_0
    //   177: getfield 175	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnSeekCompleteListener;
    //   180: invokeinterface 178 2 0
    //   185: aload_0
    //   186: iconst_0
    //   187: putfield 180	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_f_of_type_Int	I
    //   190: aload_0
    //   191: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   194: aload_0
    //   195: invokevirtual 99	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:getContext	()Landroid/content/Context;
    //   198: invokevirtual 129	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   201: aload_0
    //   202: getfield 121	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   205: aload_0
    //   206: getfield 182	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   209: invokeinterface 185 4 0
    //   214: aload_0
    //   215: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   218: aload_0
    //   219: getfield 53	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   222: invokeinterface 188 2 0
    //   227: aload_0
    //   228: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   231: iconst_3
    //   232: invokeinterface 190 2 0
    //   237: aload_0
    //   238: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   241: iconst_1
    //   242: invokeinterface 191 2 0
    //   247: aload_0
    //   248: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   251: invokeinterface 192 1 0
    //   256: aload_0
    //   257: iconst_1
    //   258: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   261: aload_0
    //   262: invokespecial 194	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:d	()V
    //   265: return
    //   266: astore_2
    //   267: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +34 -> 304
    //   273: aload_0
    //   274: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   277: iconst_2
    //   278: new 202	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   285: ldc 206
    //   287: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_0
    //   291: getfield 121	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   294: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: aload_2
    //   301: invokestatic 221	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   304: aload_0
    //   305: iconst_m1
    //   306: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   309: aload_0
    //   310: iconst_m1
    //   311: putfield 51	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Int	I
    //   314: aload_0
    //   315: getfield 84	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnErrorListener;
    //   318: aload_0
    //   319: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   322: iconst_1
    //   323: iconst_0
    //   324: invokeinterface 226 4 0
    //   329: pop
    //   330: return
    //   331: astore_2
    //   332: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -289 -> 46
    //   338: aload_0
    //   339: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   342: iconst_2
    //   343: new 202	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   350: ldc 228
    //   352: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokestatic 232	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   359: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 235	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: goto -322 -> 46
    //   371: aload_0
    //   372: aload_0
    //   373: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   376: invokeinterface 238 1 0
    //   381: putfield 152	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_c_of_type_Int	I
    //   384: goto -297 -> 87
    //   387: astore_2
    //   388: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +34 -> 425
    //   394: aload_0
    //   395: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   398: iconst_2
    //   399: new 202	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   406: ldc 206
    //   408: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: getfield 121	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   415: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload_2
    //   422: invokestatic 221	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: aload_0
    //   426: iconst_m1
    //   427: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   430: aload_0
    //   431: iconst_m1
    //   432: putfield 51	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Int	I
    //   435: aload_0
    //   436: getfield 84	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnErrorListener;
    //   439: aload_0
    //   440: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   443: iconst_1
    //   444: iconst_0
    //   445: invokeinterface 226 4 0
    //   450: pop
    //   451: return
    //   452: astore_2
    //   453: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +14 -> 470
    //   459: aload_0
    //   460: getfield 47	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   463: iconst_2
    //   464: ldc 240
    //   466: aload_2
    //   467: invokestatic 221	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_0
    //   471: iconst_m1
    //   472: putfield 49	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Int	I
    //   475: aload_0
    //   476: iconst_m1
    //   477: putfield 51	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Int	I
    //   480: aload_0
    //   481: getfield 84	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnErrorListener;
    //   484: aload_0
    //   485: getfield 55	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer;
    //   488: iconst_1
    //   489: iconst_0
    //   490: invokeinterface 226 4 0
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
    return (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) && (this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.e();
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.g();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.f();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = null;
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
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) && (this.jdField_a_of_type_AndroidWidgetMediaController != null))
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
  
  protected IMediaPlayer a()
  {
    return new MediaPlayerWrapper();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.e();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.f();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer = null;
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) {
      return this.jdField_f_of_type_Int;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.b();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (a()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a());
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
      if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a()) {
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
      } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a());
      start();
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return true;
      if ((paramInt != 86) && (paramInt != 127)) {
        break label184;
      }
    } while (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a());
    label147:
    pause();
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
    return true;
    label184:
    e();
    label188:
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) && (i != 0) && (paramInt1 != 0))
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$onTextureUpdateListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$onTextureUpdateListener.a(paramSurfaceTexture);
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
    if ((a()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.d();
      this.jdField_a_of_type_Int = 4;
    }
    this.jdField_b_of_type_Int = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(paramInt);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(paramBoolean);
    }
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(paramOnSeekCompleteListener);
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
  
  public void setmOnTextureUpdateListener(IMediaPlayer.onTextureUpdateListener paramonTextureUpdateListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$onTextureUpdateListener = paramonTextureUpdateListener;
  }
  
  public void start()
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.c();
      this.jdField_a_of_type_Int = 3;
    }
    this.jdField_b_of_type_Int = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView
 * JD-Core Version:    0.7.0.1
 */