package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class DefaultRenderersFactory
  implements RenderersFactory
{
  public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000L;
  public static final int EXTENSION_RENDERER_MODE_OFF = 0;
  public static final int EXTENSION_RENDERER_MODE_ON = 1;
  public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
  protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
  private static final String TAG = "DefaultRenderersFactory";
  private final long allowedVideoJoiningTimeMs;
  private final Context context;
  @Nullable
  private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
  private final int extensionRendererMode;
  
  public DefaultRenderersFactory(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DefaultRenderersFactory(Context paramContext, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager)
  {
    this(paramContext, paramDrmSessionManager, 0);
  }
  
  public DefaultRenderersFactory(Context paramContext, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, int paramInt)
  {
    this(paramContext, paramDrmSessionManager, paramInt, 5000L);
  }
  
  public DefaultRenderersFactory(Context paramContext, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, int paramInt, long paramLong)
  {
    this.context = paramContext;
    this.drmSessionManager = paramDrmSessionManager;
    this.extensionRendererMode = paramInt;
    this.allowedVideoJoiningTimeMs = paramLong;
  }
  
  protected AudioProcessor[] buildAudioProcessors()
  {
    return new AudioProcessor[0];
  }
  
  /* Error */
  protected void buildAudioRenderers(Context paramContext, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, AudioProcessor[] paramArrayOfAudioProcessor, Handler paramHandler, AudioRendererEventListener paramAudioRendererEventListener, int paramInt, ArrayList<Renderer> paramArrayList)
  {
    // Byte code:
    //   0: aload 7
    //   2: new 71	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer
    //   5: dup
    //   6: getstatic 77	com/google/android/exoplayer2/mediacodec/MediaCodecSelector:DEFAULT	Lcom/google/android/exoplayer2/mediacodec/MediaCodecSelector;
    //   9: aload_2
    //   10: iconst_1
    //   11: aload 4
    //   13: aload 5
    //   15: aload_1
    //   16: invokestatic 83	com/google/android/exoplayer2/audio/AudioCapabilities:getCapabilities	(Landroid/content/Context;)Lcom/google/android/exoplayer2/audio/AudioCapabilities;
    //   19: aload_3
    //   20: invokespecial 86	com/google/android/exoplayer2/audio/MediaCodecAudioRenderer:<init>	(Lcom/google/android/exoplayer2/mediacodec/MediaCodecSelector;Lcom/google/android/exoplayer2/drm/DrmSessionManager;ZLandroid/os/Handler;Lcom/google/android/exoplayer2/audio/AudioRendererEventListener;Lcom/google/android/exoplayer2/audio/AudioCapabilities;[Lcom/google/android/exoplayer2/audio/AudioProcessor;)V
    //   23: invokevirtual 92	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   26: pop
    //   27: iload 6
    //   29: ifne +4 -> 33
    //   32: return
    //   33: aload 7
    //   35: invokevirtual 96	java/util/ArrayList:size	()I
    //   38: istore 9
    //   40: iload 9
    //   42: istore 8
    //   44: iload 6
    //   46: iconst_2
    //   47: if_icmpne +9 -> 56
    //   50: iload 9
    //   52: iconst_1
    //   53: isub
    //   54: istore 8
    //   56: ldc 98
    //   58: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   61: iconst_3
    //   62: anewarray 100	java/lang/Class
    //   65: dup
    //   66: iconst_0
    //   67: ldc 106
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: ldc 108
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc 110
    //   79: aastore
    //   80: invokevirtual 114	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   83: iconst_3
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload 4
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload 5
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: aload_3
    //   100: aastore
    //   101: invokevirtual 120	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 122	com/google/android/exoplayer2/Renderer
    //   107: astore_1
    //   108: iload 8
    //   110: iconst_1
    //   111: iadd
    //   112: istore 6
    //   114: aload 7
    //   116: iload 8
    //   118: aload_1
    //   119: invokevirtual 125	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   122: ldc 23
    //   124: ldc 127
    //   126: invokestatic 133	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: ldc 135
    //   132: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   135: iconst_3
    //   136: anewarray 100	java/lang/Class
    //   139: dup
    //   140: iconst_0
    //   141: ldc 106
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: ldc 108
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: ldc 110
    //   153: aastore
    //   154: invokevirtual 114	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   157: iconst_3
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload 4
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: aload 5
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: aload_3
    //   174: aastore
    //   175: invokevirtual 120	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   178: checkcast 122	com/google/android/exoplayer2/Renderer
    //   181: astore_1
    //   182: iload 6
    //   184: iconst_1
    //   185: iadd
    //   186: istore 8
    //   188: aload 7
    //   190: iload 6
    //   192: aload_1
    //   193: invokevirtual 125	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   196: ldc 23
    //   198: ldc 137
    //   200: invokestatic 133	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: aload 7
    //   206: iload 8
    //   208: ldc 139
    //   210: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   213: iconst_3
    //   214: anewarray 100	java/lang/Class
    //   217: dup
    //   218: iconst_0
    //   219: ldc 106
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: ldc 108
    //   226: aastore
    //   227: dup
    //   228: iconst_2
    //   229: ldc 110
    //   231: aastore
    //   232: invokevirtual 114	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   235: iconst_3
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload 4
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: aload 5
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: aload_3
    //   252: aastore
    //   253: invokevirtual 120	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   256: checkcast 122	com/google/android/exoplayer2/Renderer
    //   259: invokevirtual 125	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   262: ldc 23
    //   264: ldc 141
    //   266: invokestatic 133	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   269: pop
    //   270: return
    //   271: astore_1
    //   272: return
    //   273: astore_1
    //   274: iload 8
    //   276: istore 6
    //   278: goto -148 -> 130
    //   281: astore_1
    //   282: new 143	java/lang/RuntimeException
    //   285: dup
    //   286: ldc 145
    //   288: aload_1
    //   289: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   292: athrow
    //   293: astore_1
    //   294: iload 6
    //   296: istore 8
    //   298: goto -94 -> 204
    //   301: astore_1
    //   302: new 143	java/lang/RuntimeException
    //   305: dup
    //   306: ldc 150
    //   308: aload_1
    //   309: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   312: athrow
    //   313: astore_1
    //   314: new 143	java/lang/RuntimeException
    //   317: dup
    //   318: ldc 152
    //   320: aload_1
    //   321: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: athrow
    //   325: astore_1
    //   326: iload 8
    //   328: istore 6
    //   330: goto -36 -> 294
    //   333: astore_1
    //   334: goto -56 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	DefaultRenderersFactory
    //   0	337	1	paramContext	Context
    //   0	337	2	paramDrmSessionManager	DrmSessionManager<FrameworkMediaCrypto>
    //   0	337	3	paramArrayOfAudioProcessor	AudioProcessor[]
    //   0	337	4	paramHandler	Handler
    //   0	337	5	paramAudioRendererEventListener	AudioRendererEventListener
    //   0	337	6	paramInt	int
    //   0	337	7	paramArrayList	ArrayList<Renderer>
    //   42	285	8	i	int
    //   38	16	9	j	int
    // Exception table:
    //   from	to	target	type
    //   204	270	271	java/lang/ClassNotFoundException
    //   56	108	273	java/lang/ClassNotFoundException
    //   56	108	281	java/lang/Exception
    //   114	130	281	java/lang/Exception
    //   130	182	293	java/lang/ClassNotFoundException
    //   130	182	301	java/lang/Exception
    //   188	204	301	java/lang/Exception
    //   204	270	313	java/lang/Exception
    //   188	204	325	java/lang/ClassNotFoundException
    //   114	130	333	java/lang/ClassNotFoundException
  }
  
  protected void buildMetadataRenderers(Context paramContext, MetadataOutput paramMetadataOutput, Looper paramLooper, int paramInt, ArrayList<Renderer> paramArrayList)
  {
    paramArrayList.add(new MetadataRenderer(paramMetadataOutput, paramLooper));
  }
  
  protected void buildMiscellaneousRenderers(Context paramContext, Handler paramHandler, int paramInt, ArrayList<Renderer> paramArrayList) {}
  
  protected void buildTextRenderers(Context paramContext, TextOutput paramTextOutput, Looper paramLooper, int paramInt, ArrayList<Renderer> paramArrayList)
  {
    paramArrayList.add(new TextRenderer(paramTextOutput, paramLooper));
  }
  
  protected void buildVideoRenderers(Context paramContext, @Nullable DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager, long paramLong, Handler paramHandler, VideoRendererEventListener paramVideoRendererEventListener, int paramInt, ArrayList<Renderer> paramArrayList)
  {
    paramArrayList.add(new MediaCodecVideoRenderer(paramContext, MediaCodecSelector.DEFAULT, paramLong, paramDrmSessionManager, false, paramHandler, paramVideoRendererEventListener, 50));
    if (paramInt == 0) {
      return;
    }
    int i = paramArrayList.size();
    if (paramInt == 2) {}
    for (paramInt = i - 1;; paramInt = i) {
      try
      {
        paramArrayList.add(paramInt, (Renderer)Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[] { Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE }).newInstance(new Object[] { Boolean.valueOf(true), Long.valueOf(paramLong), paramHandler, paramVideoRendererEventListener, Integer.valueOf(50) }));
        Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        return;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Error instantiating VP9 extension", paramContext);
      }
    }
  }
  
  public Renderer[] createRenderers(Handler paramHandler, VideoRendererEventListener paramVideoRendererEventListener, AudioRendererEventListener paramAudioRendererEventListener, TextOutput paramTextOutput, MetadataOutput paramMetadataOutput)
  {
    ArrayList localArrayList = new ArrayList();
    buildVideoRenderers(this.context, this.drmSessionManager, this.allowedVideoJoiningTimeMs, paramHandler, paramVideoRendererEventListener, this.extensionRendererMode, localArrayList);
    buildAudioRenderers(this.context, this.drmSessionManager, buildAudioProcessors(), paramHandler, paramAudioRendererEventListener, this.extensionRendererMode, localArrayList);
    buildTextRenderers(this.context, paramTextOutput, paramHandler.getLooper(), this.extensionRendererMode, localArrayList);
    buildMetadataRenderers(this.context, paramMetadataOutput, paramHandler.getLooper(), this.extensionRendererMode, localArrayList);
    buildMiscellaneousRenderers(this.context, paramHandler, this.extensionRendererMode, localArrayList);
    return (Renderer[])localArrayList.toArray(new Renderer[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.DefaultRenderersFactory
 * JD-Core Version:    0.7.0.1
 */