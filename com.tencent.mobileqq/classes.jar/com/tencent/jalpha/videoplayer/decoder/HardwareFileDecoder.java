package com.tencent.jalpha.videoplayer.decoder;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecoder;
import java.nio.ByteBuffer;

public class HardwareFileDecoder
  implements IVideoFileDecoder
{
  private String TAG = "VideoPlayer|HardwareFileDecoder";
  private IVideoFileDecodeListener mDecodeListener = null;
  private MediaExtractor mExtractor = null;
  private long mFirstFrameSysTime = 0L;
  private long mFirstFrameTimeUS = 0L;
  private MediaFormat mFormat = null;
  private ByteBuffer[] mInputBuffers = null;
  private boolean mLoop = false;
  private MediaCodec mMediaCodec = null;
  private String mMime = null;
  private ByteBuffer[] mOutputBuffers = null;
  private long mPresentationTimeUs = 0L;
  private long mSamplePresentationTimeUs = 0L;
  private boolean mStart = false;
  
  public HardwareFileDecoder() {}
  
  public HardwareFileDecoder(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  private void releaseCodec()
  {
    if (this.mMediaCodec != null) {}
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mMediaCodec stop + release begin!");
      localStringBuilder.append(hashCode());
      Logger.i(str, localStringBuilder.toString());
      this.mMediaCodec.stop();
      this.mMediaCodec.release();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label61:
      break label61;
    }
    Logger.e(this.TAG, "Failed to stop MediaCodec");
    this.mMediaCodec = null;
  }
  
  private void releaseExtractor()
  {
    MediaExtractor localMediaExtractor = this.mExtractor;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.mExtractor = null;
    }
  }
  
  public int createDecoder(String paramString, Object paramObject)
  {
    int k = -1;
    label620:
    for (;;)
    {
      try
      {
        this.mExtractor = new MediaExtractor();
        this.mExtractor.setDataSource(paramString);
        int i = 0;
        StringBuilder localStringBuilder;
        try
        {
          int m = this.mExtractor.getTrackCount();
          int j = k;
          if (i < m)
          {
            if (!this.mExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
              break label620;
            }
            this.mExtractor.selectTrack(i);
            j = i;
          }
          this.mFormat = this.mExtractor.getTrackFormat(j);
          if (this.mFormat != null) {
            this.mMime = this.mFormat.getString("mime");
          }
          this.mExtractor.selectTrack(j);
          if ((this.mFormat != null) && (this.mMime.startsWith("video/")))
          {
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoFormat(this.mFormat);
            }
            i = this.mFormat.getInteger("width");
            j = this.mFormat.getInteger("height");
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoSize(i, j);
            }
            try
            {
              this.mMediaCodec = MediaCodec.createDecoderByType(this.mMime);
              paramString = this.TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("mMediaCodec configure begin!");
              localStringBuilder.append(hashCode());
              Logger.i(paramString, localStringBuilder.toString());
              this.mMediaCodec.configure(this.mFormat, (Surface)paramObject, null, 0);
              paramString = this.TAG;
              paramObject = new StringBuilder();
              paramObject.append("mMediaCodec start begin!");
              paramObject.append(hashCode());
              Logger.i(paramString, paramObject.toString());
              this.mMediaCodec.start();
              this.mInputBuffers = this.mMediaCodec.getInputBuffers();
              this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
              Logger.i(this.TAG, "get mMediaCodec mInputBuffers & mOutputBuffers ");
              paramString = this.mDecodeListener;
              if (paramString != null) {
                paramString.onVideoDecoderCreated(true);
              }
              return 1;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              paramString = this.mDecodeListener;
              if (paramString != null) {
                paramString.onVideoDecodeError(-5);
              }
              if (this.mMediaCodec != null)
              {
                paramString = this.TAG;
                paramObject = new StringBuilder();
                paramObject.append("mMediaCodec release begin!");
                paramObject.append(hashCode());
                Logger.i(paramString, paramObject.toString());
                this.mMediaCodec.release();
                this.mMediaCodec = null;
              }
              this.mInputBuffers = null;
              this.mOutputBuffers = null;
              releaseExtractor();
              return -5;
            }
          }
          Logger.e(this.TAG, "error: not a video type file, end !");
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-3);
          }
          releaseExtractor();
          return -3;
        }
        catch (Exception paramString)
        {
          paramObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("error read video file and info ");
          localStringBuilder.append(paramString.getMessage());
          Logger.e(paramObject, localStringBuilder.toString());
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-2);
          }
          releaseExtractor();
          return -2;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        paramObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" error mExtractor.setDataSource file path ");
        localStringBuilder.append(paramString.getMessage());
        Logger.e(paramObject, localStringBuilder.toString());
        paramString = this.mDecodeListener;
        if (paramString != null) {
          paramString.onVideoDecodeError(-1);
        }
        releaseExtractor();
        return -1;
      }
    }
  }
  
  /* Error */
  public void decode()
  {
    // Byte code:
    //   0: new 219	android/media/MediaCodec$BufferInfo
    //   3: dup
    //   4: invokespecial 220	android/media/MediaCodec$BufferInfo:<init>	()V
    //   7: astore 14
    //   9: aload_0
    //   10: getfield 62	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/jalpha/videoplayer/interfaces/IVideoFileDecodeListener;
    //   13: astore 13
    //   15: aload 13
    //   17: ifnull +10 -> 27
    //   20: aload 13
    //   22: invokeinterface 223 1 0
    //   27: aload_0
    //   28: lconst_0
    //   29: putfield 46	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameSysTime	J
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 48	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   37: aload_0
    //   38: monitorenter
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 54	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mStart	Z
    //   44: aload_0
    //   45: monitorexit
    //   46: iconst_0
    //   47: istore_2
    //   48: iconst_0
    //   49: istore_1
    //   50: iconst_1
    //   51: istore 5
    //   53: iload_2
    //   54: ifne +874 -> 928
    //   57: aload_0
    //   58: getfield 54	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mStart	Z
    //   61: ifne +15 -> 76
    //   64: aload_0
    //   65: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   68: ldc 225
    //   70: invokestatic 93	com/tencent/jalpha/common/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: goto +855 -> 928
    //   76: iload_1
    //   77: ifne +244 -> 321
    //   80: aload_0
    //   81: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   84: ldc2_w 226
    //   87: invokevirtual 231	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   90: istore 7
    //   92: aload_0
    //   93: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   96: astore 13
    //   98: new 69	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   105: astore 15
    //   107: aload 15
    //   109: ldc 233
    //   111: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 15
    //   117: iload 7
    //   119: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 13
    //   125: aload 15
    //   127: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 93	com/tencent/jalpha/common/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: iload 7
    //   135: iflt +132 -> 267
    //   138: aload_0
    //   139: getfield 50	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   142: iload 7
    //   144: aaload
    //   145: astore 13
    //   147: aload_0
    //   148: getfield 36	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   151: aload 13
    //   153: iconst_0
    //   154: invokevirtual 237	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   157: istore_3
    //   158: iload_3
    //   159: ifge +19 -> 178
    //   162: aload_0
    //   163: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   166: ldc 239
    //   168: invokestatic 242	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: iconst_1
    //   172: istore_3
    //   173: iconst_0
    //   174: istore_1
    //   175: goto +26 -> 201
    //   178: aload_0
    //   179: getfield 36	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   182: astore 13
    //   184: aload_0
    //   185: aload 13
    //   187: invokevirtual 246	android/media/MediaExtractor:getSampleTime	()J
    //   190: putfield 42	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mSamplePresentationTimeUs	J
    //   193: iload_1
    //   194: istore 4
    //   196: iload_3
    //   197: istore_1
    //   198: iload 4
    //   200: istore_3
    //   201: iload_3
    //   202: istore 4
    //   204: aload_0
    //   205: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   208: astore 13
    //   210: iload_3
    //   211: istore 4
    //   213: aload_0
    //   214: getfield 42	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mSamplePresentationTimeUs	J
    //   217: lstore 8
    //   219: iload_3
    //   220: ifeq +805 -> 1025
    //   223: iconst_4
    //   224: istore 6
    //   226: goto +3 -> 229
    //   229: iload_3
    //   230: istore 4
    //   232: aload 13
    //   234: iload 7
    //   236: iconst_0
    //   237: iload_1
    //   238: lload 8
    //   240: iload 6
    //   242: invokevirtual 250	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   245: iload_3
    //   246: istore_1
    //   247: iload_3
    //   248: ifne +73 -> 321
    //   251: iload_3
    //   252: istore 4
    //   254: aload_0
    //   255: getfield 36	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   258: invokevirtual 254	android/media/MediaExtractor:advance	()Z
    //   261: pop
    //   262: iload_3
    //   263: istore_1
    //   264: goto +57 -> 321
    //   267: aload_0
    //   268: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   271: astore 13
    //   273: new 69	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   280: astore 15
    //   282: aload 15
    //   284: ldc 233
    //   286: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 15
    //   292: iload 7
    //   294: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 13
    //   300: aload 15
    //   302: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 106	com/tencent/jalpha/common/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: goto +13 -> 321
    //   311: astore 13
    //   313: goto +542 -> 855
    //   316: astore 13
    //   318: goto +537 -> 855
    //   321: iload_2
    //   322: istore_3
    //   323: iload_1
    //   324: istore 4
    //   326: aload_0
    //   327: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   330: aload 14
    //   332: ldc2_w 226
    //   335: invokevirtual 258	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   338: istore 6
    //   340: iload_1
    //   341: istore 4
    //   343: aload_0
    //   344: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   347: astore 13
    //   349: iload_1
    //   350: istore 4
    //   352: new 69	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   359: astore 15
    //   361: iload_1
    //   362: istore 4
    //   364: aload 15
    //   366: ldc_w 260
    //   369: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: iload_1
    //   374: istore 4
    //   376: aload 15
    //   378: iload 6
    //   380: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: iload_1
    //   385: istore 4
    //   387: aload 13
    //   389: aload 15
    //   391: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 93	com/tencent/jalpha/common/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: iload 6
    //   399: iflt +251 -> 650
    //   402: iload_1
    //   403: istore 4
    //   405: aload_0
    //   406: getfield 46	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameSysTime	J
    //   409: lconst_0
    //   410: lcmp
    //   411: ifne +28 -> 439
    //   414: iload_1
    //   415: istore 4
    //   417: aload_0
    //   418: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   421: putfield 46	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameSysTime	J
    //   424: iload_1
    //   425: istore 4
    //   427: aload_0
    //   428: aload 14
    //   430: getfield 268	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   433: putfield 48	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   436: goto +67 -> 503
    //   439: iload_1
    //   440: istore 4
    //   442: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   445: aload_0
    //   446: getfield 46	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameSysTime	J
    //   449: lsub
    //   450: lstore 8
    //   452: iload_1
    //   453: istore 4
    //   455: aload 14
    //   457: getfield 268	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   460: aload_0
    //   461: getfield 48	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   464: lsub
    //   465: ldc2_w 269
    //   468: ldiv
    //   469: lstore 10
    //   471: lload 8
    //   473: lload 10
    //   475: lcmp
    //   476: ifge +27 -> 503
    //   479: iload_1
    //   480: istore 4
    //   482: lload 10
    //   484: lload 8
    //   486: lsub
    //   487: invokestatic 276	java/lang/Thread:sleep	(J)V
    //   490: goto +13 -> 503
    //   493: astore 13
    //   495: iload_1
    //   496: istore 4
    //   498: aload 13
    //   500: invokevirtual 277	java/lang/InterruptedException:printStackTrace	()V
    //   503: iload_1
    //   504: istore 4
    //   506: aload_0
    //   507: aload 14
    //   509: getfield 268	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   512: putfield 44	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mPresentationTimeUs	J
    //   515: iload_1
    //   516: istore 4
    //   518: aload_0
    //   519: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   522: iload 6
    //   524: iconst_1
    //   525: invokevirtual 281	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   528: iload_1
    //   529: istore 4
    //   531: aload_0
    //   532: getfield 62	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/jalpha/videoplayer/interfaces/IVideoFileDecodeListener;
    //   535: ifnull +20 -> 555
    //   538: iload_1
    //   539: istore 4
    //   541: aload_0
    //   542: getfield 62	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/jalpha/videoplayer/interfaces/IVideoFileDecodeListener;
    //   545: aload_0
    //   546: getfield 44	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mPresentationTimeUs	J
    //   549: aconst_null
    //   550: invokeinterface 285 4 0
    //   555: iload_1
    //   556: istore 4
    //   558: aload 14
    //   560: getfield 289	android/media/MediaCodec$BufferInfo:flags	I
    //   563: iconst_4
    //   564: iand
    //   565: ifeq +80 -> 645
    //   568: iload_1
    //   569: istore 4
    //   571: aload_0
    //   572: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   575: ldc_w 291
    //   578: invokestatic 242	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: iload_1
    //   582: istore 4
    //   584: aload_0
    //   585: getfield 56	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mLoop	Z
    //   588: istore 12
    //   590: iload 12
    //   592: ifeq +48 -> 640
    //   595: aload_0
    //   596: lconst_0
    //   597: putfield 46	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameSysTime	J
    //   600: aload_0
    //   601: lconst_0
    //   602: putfield 48	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   605: aload_0
    //   606: lconst_0
    //   607: putfield 44	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mPresentationTimeUs	J
    //   610: aload_0
    //   611: getfield 36	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   614: lconst_0
    //   615: iconst_2
    //   616: invokevirtual 295	android/media/MediaExtractor:seekTo	(JI)V
    //   619: aload_0
    //   620: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   623: invokevirtual 298	android/media/MediaCodec:flush	()V
    //   626: iload_3
    //   627: istore_2
    //   628: iconst_0
    //   629: istore_1
    //   630: goto +17 -> 647
    //   633: astore 13
    //   635: iconst_0
    //   636: istore_1
    //   637: goto +218 -> 855
    //   640: iconst_1
    //   641: istore_2
    //   642: goto +5 -> 647
    //   645: iload_3
    //   646: istore_2
    //   647: goto +200 -> 847
    //   650: iload 6
    //   652: bipush 253
    //   654: if_icmpne +33 -> 687
    //   657: iload_1
    //   658: istore 4
    //   660: aload_0
    //   661: aload_0
    //   662: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   665: invokevirtual 188	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   668: putfield 52	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   671: iload_1
    //   672: istore 4
    //   674: aload_0
    //   675: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   678: ldc_w 300
    //   681: invokestatic 242	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: goto +161 -> 845
    //   687: iload 6
    //   689: bipush 254
    //   691: if_icmpne +75 -> 766
    //   694: iload_1
    //   695: istore 4
    //   697: aload_0
    //   698: getfield 34	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   701: invokevirtual 304	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   704: astore 13
    //   706: iload_1
    //   707: istore 4
    //   709: aload_0
    //   710: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   713: astore 15
    //   715: iload_1
    //   716: istore 4
    //   718: new 69	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   725: astore 16
    //   727: iload_1
    //   728: istore 4
    //   730: aload 16
    //   732: ldc_w 306
    //   735: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: iload_1
    //   740: istore 4
    //   742: aload 16
    //   744: aload 13
    //   746: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: iload_1
    //   751: istore 4
    //   753: aload 15
    //   755: aload 16
    //   757: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 242	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: goto +82 -> 845
    //   766: iload 6
    //   768: iconst_m1
    //   769: if_icmpne +19 -> 788
    //   772: iload_1
    //   773: istore 4
    //   775: aload_0
    //   776: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   779: ldc_w 311
    //   782: invokestatic 242	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: goto +60 -> 845
    //   788: iload_1
    //   789: istore 4
    //   791: aload_0
    //   792: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   795: astore 13
    //   797: iload_1
    //   798: istore 4
    //   800: new 69	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   807: astore 15
    //   809: iload_1
    //   810: istore 4
    //   812: aload 15
    //   814: ldc_w 313
    //   817: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: iload_1
    //   822: istore 4
    //   824: aload 15
    //   826: iload 6
    //   828: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: iload_1
    //   833: istore 4
    //   835: aload 13
    //   837: aload 15
    //   839: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 242	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: iload_3
    //   846: istore_2
    //   847: goto -794 -> 53
    //   850: astore 13
    //   852: iload 4
    //   854: istore_1
    //   855: aload_0
    //   856: getfield 60	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   859: astore 15
    //   861: new 69	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   868: astore 16
    //   870: aload 16
    //   872: ldc_w 315
    //   875: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 16
    //   881: aload 13
    //   883: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload 15
    //   889: aload 16
    //   891: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 106	com/tencent/jalpha/common/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   897: aload_0
    //   898: getfield 62	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/jalpha/videoplayer/interfaces/IVideoFileDecodeListener;
    //   901: astore 13
    //   903: aload 13
    //   905: ifnull +12 -> 917
    //   908: aload 13
    //   910: bipush 155
    //   912: invokeinterface 199 2 0
    //   917: aload_0
    //   918: iconst_0
    //   919: putfield 54	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mStart	Z
    //   922: iconst_0
    //   923: istore 5
    //   925: goto -872 -> 53
    //   928: aload_0
    //   929: getfield 54	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mStart	Z
    //   932: ifeq +8 -> 940
    //   935: aload_0
    //   936: iconst_0
    //   937: putfield 54	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mStart	Z
    //   940: aload_0
    //   941: invokespecial 317	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:releaseCodec	()V
    //   944: aload_0
    //   945: invokespecial 203	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:releaseExtractor	()V
    //   948: aload_0
    //   949: aconst_null
    //   950: putfield 40	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   953: aload_0
    //   954: aconst_null
    //   955: putfield 38	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   958: aload_0
    //   959: aconst_null
    //   960: putfield 50	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   963: aload_0
    //   964: aconst_null
    //   965: putfield 52	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   968: aload_0
    //   969: lconst_0
    //   970: putfield 42	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mSamplePresentationTimeUs	J
    //   973: aload_0
    //   974: lconst_0
    //   975: putfield 44	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mPresentationTimeUs	J
    //   978: aload_0
    //   979: lconst_0
    //   980: putfield 48	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   983: aload_0
    //   984: lconst_0
    //   985: putfield 46	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mFirstFrameSysTime	J
    //   988: iload 5
    //   990: ifeq +21 -> 1011
    //   993: aload_0
    //   994: getfield 62	com/tencent/jalpha/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/jalpha/videoplayer/interfaces/IVideoFileDecodeListener;
    //   997: astore 13
    //   999: aload 13
    //   1001: ifnull +10 -> 1011
    //   1004: aload 13
    //   1006: invokeinterface 320 1 0
    //   1011: return
    //   1012: astore 13
    //   1014: aload_0
    //   1015: monitorexit
    //   1016: goto +6 -> 1022
    //   1019: aload 13
    //   1021: athrow
    //   1022: goto -3 -> 1019
    //   1025: iconst_0
    //   1026: istore 6
    //   1028: goto -799 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1031	0	this	HardwareFileDecoder
    //   49	806	1	i	int
    //   47	800	2	j	int
    //   157	689	3	k	int
    //   194	659	4	m	int
    //   51	938	5	n	int
    //   224	803	6	i1	int
    //   90	203	7	i2	int
    //   217	268	8	l1	long
    //   469	14	10	l2	long
    //   588	3	12	bool	boolean
    //   13	286	13	localObject1	Object
    //   311	1	13	localRuntimeException1	java.lang.RuntimeException
    //   316	1	13	localRuntimeException2	java.lang.RuntimeException
    //   347	41	13	str	String
    //   493	6	13	localInterruptedException	java.lang.InterruptedException
    //   633	1	13	localRuntimeException3	java.lang.RuntimeException
    //   704	132	13	localObject2	Object
    //   850	32	13	localRuntimeException4	java.lang.RuntimeException
    //   901	104	13	localIVideoFileDecodeListener	IVideoFileDecodeListener
    //   1012	8	13	localObject3	Object
    //   7	552	14	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   105	783	15	localObject4	Object
    //   725	165	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   184	193	311	java/lang/RuntimeException
    //   267	308	311	java/lang/RuntimeException
    //   80	133	316	java/lang/RuntimeException
    //   138	158	316	java/lang/RuntimeException
    //   162	171	316	java/lang/RuntimeException
    //   178	184	316	java/lang/RuntimeException
    //   482	490	493	java/lang/InterruptedException
    //   595	626	633	java/lang/RuntimeException
    //   204	210	850	java/lang/RuntimeException
    //   213	219	850	java/lang/RuntimeException
    //   232	245	850	java/lang/RuntimeException
    //   254	262	850	java/lang/RuntimeException
    //   326	340	850	java/lang/RuntimeException
    //   343	349	850	java/lang/RuntimeException
    //   352	361	850	java/lang/RuntimeException
    //   364	373	850	java/lang/RuntimeException
    //   376	384	850	java/lang/RuntimeException
    //   387	397	850	java/lang/RuntimeException
    //   405	414	850	java/lang/RuntimeException
    //   417	424	850	java/lang/RuntimeException
    //   427	436	850	java/lang/RuntimeException
    //   442	452	850	java/lang/RuntimeException
    //   455	471	850	java/lang/RuntimeException
    //   482	490	850	java/lang/RuntimeException
    //   498	503	850	java/lang/RuntimeException
    //   506	515	850	java/lang/RuntimeException
    //   518	528	850	java/lang/RuntimeException
    //   531	538	850	java/lang/RuntimeException
    //   541	555	850	java/lang/RuntimeException
    //   558	568	850	java/lang/RuntimeException
    //   571	581	850	java/lang/RuntimeException
    //   584	590	850	java/lang/RuntimeException
    //   660	671	850	java/lang/RuntimeException
    //   674	684	850	java/lang/RuntimeException
    //   697	706	850	java/lang/RuntimeException
    //   709	715	850	java/lang/RuntimeException
    //   718	727	850	java/lang/RuntimeException
    //   730	739	850	java/lang/RuntimeException
    //   742	750	850	java/lang/RuntimeException
    //   753	763	850	java/lang/RuntimeException
    //   775	785	850	java/lang/RuntimeException
    //   791	797	850	java/lang/RuntimeException
    //   800	809	850	java/lang/RuntimeException
    //   812	821	850	java/lang/RuntimeException
    //   824	832	850	java/lang/RuntimeException
    //   835	845	850	java/lang/RuntimeException
    //   39	46	1012	finally
    //   1014	1016	1012	finally
  }
  
  public long getCurPresentationTimeUs()
  {
    return this.mPresentationTimeUs;
  }
  
  public IVideoFileDecodeListener getDecodeListener()
  {
    return this.mDecodeListener;
  }
  
  public void release()
  {
    releaseCodec();
    releaseExtractor();
  }
  
  public void setDecodeListener(IVideoFileDecodeListener paramIVideoFileDecodeListener)
  {
    this.mDecodeListener = paramIVideoFileDecodeListener;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public void stop()
  {
    try
    {
      this.mStart = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.decoder.HardwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */