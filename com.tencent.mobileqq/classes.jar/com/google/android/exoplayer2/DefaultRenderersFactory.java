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
    //   130: goto +19 -> 149
    //   133: astore_1
    //   134: new 135	java/lang/RuntimeException
    //   137: dup
    //   138: ldc 137
    //   140: aload_1
    //   141: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: athrow
    //   145: iload 8
    //   147: istore 6
    //   149: ldc 142
    //   151: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: iconst_3
    //   155: anewarray 100	java/lang/Class
    //   158: dup
    //   159: iconst_0
    //   160: ldc 106
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: ldc 108
    //   167: aastore
    //   168: dup
    //   169: iconst_2
    //   170: ldc 110
    //   172: aastore
    //   173: invokevirtual 114	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   176: iconst_3
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload 4
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 5
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: aload_3
    //   193: aastore
    //   194: invokevirtual 120	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   197: checkcast 122	com/google/android/exoplayer2/Renderer
    //   200: astore_1
    //   201: iload 6
    //   203: iconst_1
    //   204: iadd
    //   205: istore 8
    //   207: aload 7
    //   209: iload 6
    //   211: aload_1
    //   212: invokevirtual 125	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   215: ldc 23
    //   217: ldc 144
    //   219: invokestatic 133	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: iload 8
    //   225: istore 6
    //   227: goto +15 -> 242
    //   230: astore_1
    //   231: new 135	java/lang/RuntimeException
    //   234: dup
    //   235: ldc 146
    //   237: aload_1
    //   238: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: athrow
    //   242: aload 7
    //   244: iload 6
    //   246: ldc 148
    //   248: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   251: iconst_3
    //   252: anewarray 100	java/lang/Class
    //   255: dup
    //   256: iconst_0
    //   257: ldc 106
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: ldc 108
    //   264: aastore
    //   265: dup
    //   266: iconst_2
    //   267: ldc 110
    //   269: aastore
    //   270: invokevirtual 114	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   273: iconst_3
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload 4
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 5
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: aload_3
    //   290: aastore
    //   291: invokevirtual 120	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   294: checkcast 122	com/google/android/exoplayer2/Renderer
    //   297: invokevirtual 125	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   300: ldc 23
    //   302: ldc 150
    //   304: invokestatic 133	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: return
    //   309: astore_1
    //   310: new 135	java/lang/RuntimeException
    //   313: dup
    //   314: ldc 152
    //   316: aload_1
    //   317: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   320: athrow
    //   321: astore_1
    //   322: goto -177 -> 145
    //   325: astore_1
    //   326: goto -177 -> 149
    //   329: astore_1
    //   330: goto -88 -> 242
    //   333: astore_1
    //   334: iload 8
    //   336: istore 6
    //   338: goto -96 -> 242
    //   341: astore_1
    //   342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	DefaultRenderersFactory
    //   0	343	1	paramContext	Context
    //   0	343	2	paramDrmSessionManager	DrmSessionManager<FrameworkMediaCrypto>
    //   0	343	3	paramArrayOfAudioProcessor	AudioProcessor[]
    //   0	343	4	paramHandler	Handler
    //   0	343	5	paramAudioRendererEventListener	AudioRendererEventListener
    //   0	343	6	paramInt	int
    //   0	343	7	paramArrayList	ArrayList<Renderer>
    //   42	293	8	i	int
    //   38	16	9	j	int
    // Exception table:
    //   from	to	target	type
    //   56	108	133	java/lang/Exception
    //   114	130	133	java/lang/Exception
    //   149	201	230	java/lang/Exception
    //   207	223	230	java/lang/Exception
    //   242	308	309	java/lang/Exception
    //   56	108	321	java/lang/ClassNotFoundException
    //   114	130	325	java/lang/ClassNotFoundException
    //   149	201	329	java/lang/ClassNotFoundException
    //   207	223	333	java/lang/ClassNotFoundException
    //   242	308	341	java/lang/ClassNotFoundException
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
    int j = paramArrayList.size();
    int i = j;
    if (paramInt == 2) {
      i = j - 1;
    }
    try
    {
      paramArrayList.add(i, (Renderer)Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[] { Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE }).newInstance(new Object[] { Boolean.valueOf(true), Long.valueOf(paramLong), paramHandler, paramVideoRendererEventListener, Integer.valueOf(50) }));
      Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
      return;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException("Error instantiating VP9 extension", paramContext);
    }
    catch (ClassNotFoundException paramContext) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.DefaultRenderersFactory
 * JD-Core Version:    0.7.0.1
 */