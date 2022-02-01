package com.tencent.ilivesdk.playview.codec;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.ilivesdk.utils.LogUtils;
import java.nio.ByteBuffer;

public class HardwareFileDecoder
  implements VideoFileDecoder
{
  static final String TAG = "Render|HardwareFileDecoder";
  private VideoFileDecodeListener mDecodeListener = null;
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
    if (this.mMediaCodec != null)
    {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("mMediaCodec stop + release begin!");
        localStringBuilder1.append(hashCode());
        LogUtils.i("Render|HardwareFileDecoder", localStringBuilder1.toString());
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Failed to stop MediaCodec ");
        localStringBuilder2.append(localIllegalStateException.getMessage());
        LogUtils.e("Render|HardwareFileDecoder", localStringBuilder2.toString());
      }
      this.mMediaCodec = null;
    }
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
    label584:
    for (;;)
    {
      try
      {
        this.mExtractor = new MediaExtractor();
        this.mExtractor.setDataSource(paramString);
        int i = 0;
        try
        {
          int m = this.mExtractor.getTrackCount();
          int j = k;
          if (i < m)
          {
            if (!this.mExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
              break label584;
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
              paramString = new StringBuilder();
              paramString.append("mMediaCodec configure begin!");
              paramString.append(hashCode());
              LogUtils.i("Render|HardwareFileDecoder", paramString.toString());
              this.mMediaCodec.configure(this.mFormat, (Surface)paramObject, null, 0);
              paramString = new StringBuilder();
              paramString.append("mMediaCodec start begin!");
              paramString.append(hashCode());
              LogUtils.i("Render|HardwareFileDecoder", paramString.toString());
              this.mMediaCodec.start();
              this.mInputBuffers = this.mMediaCodec.getInputBuffers();
              this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
              LogUtils.i("Render|HardwareFileDecoder", "get mMediaCodec mInputBuffers & mOutputBuffers ");
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
                paramString = new StringBuilder();
                paramString.append("mMediaCodec release begin!");
                paramString.append(hashCode());
                LogUtils.i("Render|HardwareFileDecoder", paramString.toString());
                this.mMediaCodec.release();
                this.mMediaCodec = null;
              }
              this.mInputBuffers = null;
              this.mOutputBuffers = null;
              releaseExtractor();
              return -5;
            }
          }
          LogUtils.e("Render|HardwareFileDecoder", "error: not a video type file, end !");
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-3);
          }
          releaseExtractor();
          return -3;
        }
        catch (Exception paramString)
        {
          paramObject = new StringBuilder();
          paramObject.append("error read video file and info ");
          paramObject.append(paramString.getMessage());
          LogUtils.e("Render|HardwareFileDecoder", paramObject.toString());
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
        paramObject = new StringBuilder();
        paramObject.append(" error mExtractor.setDataSource file path ");
        paramObject.append(paramString.getMessage());
        LogUtils.e("Render|HardwareFileDecoder", paramObject.toString());
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
    //   0: new 218	android/media/MediaCodec$BufferInfo
    //   3: dup
    //   4: invokespecial 219	android/media/MediaCodec$BufferInfo:<init>	()V
    //   7: astore 14
    //   9: aload_0
    //   10: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   13: astore 13
    //   15: aload 13
    //   17: ifnull +10 -> 27
    //   20: aload 13
    //   22: invokeinterface 222 1 0
    //   27: aload_0
    //   28: lconst_0
    //   29: putfield 48	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameSysTime	J
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 50	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   37: aload_0
    //   38: monitorenter
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 58	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mStart	Z
    //   44: aload_0
    //   45: monitorexit
    //   46: iconst_0
    //   47: istore_2
    //   48: iconst_0
    //   49: istore_1
    //   50: iconst_1
    //   51: istore 5
    //   53: iload_2
    //   54: ifne +739 -> 793
    //   57: aload_0
    //   58: getfield 58	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mStart	Z
    //   61: ifne +13 -> 74
    //   64: ldc 10
    //   66: ldc 224
    //   68: invokestatic 91	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto +722 -> 793
    //   74: iload_1
    //   75: ifne +195 -> 270
    //   78: aload_0
    //   79: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   82: ldc2_w 225
    //   85: invokevirtual 230	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   88: istore 7
    //   90: iload 7
    //   92: iflt +130 -> 222
    //   95: aload_0
    //   96: getfield 52	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   99: iload 7
    //   101: aaload
    //   102: astore 13
    //   104: aload_0
    //   105: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   108: aload 13
    //   110: iconst_0
    //   111: invokevirtual 234	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   114: istore_3
    //   115: iload_3
    //   116: ifge +17 -> 133
    //   119: ldc 10
    //   121: ldc 236
    //   123: invokestatic 239	com/tencent/ilivesdk/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iconst_1
    //   127: istore_3
    //   128: iconst_0
    //   129: istore_1
    //   130: goto +26 -> 156
    //   133: aload_0
    //   134: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   137: astore 13
    //   139: aload_0
    //   140: aload 13
    //   142: invokevirtual 243	android/media/MediaExtractor:getSampleTime	()J
    //   145: putfield 44	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mSamplePresentationTimeUs	J
    //   148: iload_1
    //   149: istore 4
    //   151: iload_3
    //   152: istore_1
    //   153: iload 4
    //   155: istore_3
    //   156: iload_3
    //   157: istore 4
    //   159: aload_0
    //   160: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   163: astore 13
    //   165: iload_3
    //   166: istore 4
    //   168: aload_0
    //   169: getfield 44	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mSamplePresentationTimeUs	J
    //   172: lstore 8
    //   174: iload_3
    //   175: ifeq +715 -> 890
    //   178: iconst_4
    //   179: istore 6
    //   181: goto +3 -> 184
    //   184: iload_3
    //   185: istore 4
    //   187: aload 13
    //   189: iload 7
    //   191: iconst_0
    //   192: iload_1
    //   193: lload 8
    //   195: iload 6
    //   197: invokevirtual 247	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   200: iload_3
    //   201: istore_1
    //   202: iload_3
    //   203: ifne +67 -> 270
    //   206: iload_3
    //   207: istore 4
    //   209: aload_0
    //   210: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   213: invokevirtual 251	android/media/MediaExtractor:advance	()Z
    //   216: pop
    //   217: iload_3
    //   218: istore_1
    //   219: goto +51 -> 270
    //   222: new 67	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   229: astore 13
    //   231: aload 13
    //   233: ldc 253
    //   235: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 13
    //   241: iload 7
    //   243: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 10
    //   249: aload 13
    //   251: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 107	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto +13 -> 270
    //   260: astore 13
    //   262: goto +461 -> 723
    //   265: astore 13
    //   267: goto +456 -> 723
    //   270: iload_2
    //   271: istore_3
    //   272: iload_1
    //   273: istore 4
    //   275: aload_0
    //   276: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   279: aload 14
    //   281: ldc2_w 225
    //   284: invokevirtual 257	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   287: istore 6
    //   289: iload 6
    //   291: iflt +249 -> 540
    //   294: iload_1
    //   295: istore 4
    //   297: aload_0
    //   298: getfield 48	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameSysTime	J
    //   301: lconst_0
    //   302: lcmp
    //   303: ifne +28 -> 331
    //   306: iload_1
    //   307: istore 4
    //   309: aload_0
    //   310: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   313: putfield 48	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameSysTime	J
    //   316: iload_1
    //   317: istore 4
    //   319: aload_0
    //   320: aload 14
    //   322: getfield 265	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   325: putfield 50	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   328: goto +67 -> 395
    //   331: iload_1
    //   332: istore 4
    //   334: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   337: aload_0
    //   338: getfield 48	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameSysTime	J
    //   341: lsub
    //   342: lstore 8
    //   344: iload_1
    //   345: istore 4
    //   347: aload 14
    //   349: getfield 265	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   352: aload_0
    //   353: getfield 50	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   356: lsub
    //   357: ldc2_w 225
    //   360: ldiv
    //   361: lstore 10
    //   363: lload 8
    //   365: lload 10
    //   367: lcmp
    //   368: ifge +27 -> 395
    //   371: iload_1
    //   372: istore 4
    //   374: lload 10
    //   376: lload 8
    //   378: lsub
    //   379: invokestatic 271	java/lang/Thread:sleep	(J)V
    //   382: goto +13 -> 395
    //   385: astore 13
    //   387: iload_1
    //   388: istore 4
    //   390: aload 13
    //   392: invokevirtual 272	java/lang/InterruptedException:printStackTrace	()V
    //   395: iload_1
    //   396: istore 4
    //   398: aload_0
    //   399: aload 14
    //   401: getfield 265	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   404: putfield 46	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mPresentationTimeUs	J
    //   407: iload_1
    //   408: istore 4
    //   410: aload_0
    //   411: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   414: iload 6
    //   416: iconst_1
    //   417: invokevirtual 276	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   420: iload_1
    //   421: istore 4
    //   423: aload_0
    //   424: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   427: ifnull +20 -> 447
    //   430: iload_1
    //   431: istore 4
    //   433: aload_0
    //   434: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   437: aload_0
    //   438: getfield 46	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mPresentationTimeUs	J
    //   441: aconst_null
    //   442: invokeinterface 280 4 0
    //   447: iload_1
    //   448: istore 4
    //   450: aload 14
    //   452: getfield 284	android/media/MediaCodec$BufferInfo:flags	I
    //   455: iconst_4
    //   456: iand
    //   457: ifeq +78 -> 535
    //   460: iload_1
    //   461: istore 4
    //   463: ldc 10
    //   465: ldc_w 286
    //   468: invokestatic 239	com/tencent/ilivesdk/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: iload_1
    //   472: istore 4
    //   474: aload_0
    //   475: getfield 60	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mLoop	Z
    //   478: istore 12
    //   480: iload 12
    //   482: ifeq +48 -> 530
    //   485: aload_0
    //   486: lconst_0
    //   487: putfield 48	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameSysTime	J
    //   490: aload_0
    //   491: lconst_0
    //   492: putfield 50	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   495: aload_0
    //   496: lconst_0
    //   497: putfield 46	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mPresentationTimeUs	J
    //   500: aload_0
    //   501: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   504: lconst_0
    //   505: iconst_2
    //   506: invokevirtual 290	android/media/MediaExtractor:seekTo	(JI)V
    //   509: aload_0
    //   510: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   513: invokevirtual 293	android/media/MediaCodec:flush	()V
    //   516: iload_3
    //   517: istore_2
    //   518: iconst_0
    //   519: istore_1
    //   520: goto +17 -> 537
    //   523: astore 13
    //   525: iconst_0
    //   526: istore_1
    //   527: goto +196 -> 723
    //   530: iconst_1
    //   531: istore_2
    //   532: goto +5 -> 537
    //   535: iload_3
    //   536: istore_2
    //   537: goto +178 -> 715
    //   540: iload 6
    //   542: bipush 253
    //   544: if_icmpne +31 -> 575
    //   547: iload_1
    //   548: istore 4
    //   550: aload_0
    //   551: aload_0
    //   552: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   555: invokevirtual 189	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   558: putfield 54	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   561: iload_1
    //   562: istore 4
    //   564: ldc 10
    //   566: ldc_w 295
    //   569: invokestatic 239	com/tencent/ilivesdk/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: goto +141 -> 713
    //   575: iload 6
    //   577: bipush 254
    //   579: if_icmpne +66 -> 645
    //   582: iload_1
    //   583: istore 4
    //   585: aload_0
    //   586: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   589: invokevirtual 299	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   592: astore 13
    //   594: iload_1
    //   595: istore 4
    //   597: new 67	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   604: astore 15
    //   606: iload_1
    //   607: istore 4
    //   609: aload 15
    //   611: ldc_w 301
    //   614: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: iload_1
    //   619: istore 4
    //   621: aload 15
    //   623: aload 13
    //   625: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: iload_1
    //   630: istore 4
    //   632: ldc 10
    //   634: aload 15
    //   636: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 239	com/tencent/ilivesdk/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: goto +71 -> 713
    //   645: iload 6
    //   647: iconst_m1
    //   648: if_icmpne +17 -> 665
    //   651: iload_1
    //   652: istore 4
    //   654: ldc 10
    //   656: ldc_w 306
    //   659: invokestatic 239	com/tencent/ilivesdk/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: goto +51 -> 713
    //   665: iload_1
    //   666: istore 4
    //   668: new 67	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   675: astore 13
    //   677: iload_1
    //   678: istore 4
    //   680: aload 13
    //   682: ldc_w 308
    //   685: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: iload_1
    //   690: istore 4
    //   692: aload 13
    //   694: iload 6
    //   696: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: iload_1
    //   701: istore 4
    //   703: ldc 10
    //   705: aload 13
    //   707: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 239	com/tencent/ilivesdk/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: iload_3
    //   714: istore_2
    //   715: goto -662 -> 53
    //   718: astore 13
    //   720: iload 4
    //   722: istore_1
    //   723: new 67	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   730: astore 15
    //   732: aload 15
    //   734: ldc_w 310
    //   737: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 15
    //   743: aload 13
    //   745: invokevirtual 311	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   748: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: ldc 10
    //   754: aload 15
    //   756: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 107	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload_0
    //   763: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   766: astore 13
    //   768: aload 13
    //   770: ifnull +12 -> 782
    //   773: aload 13
    //   775: bipush 155
    //   777: invokeinterface 200 2 0
    //   782: aload_0
    //   783: iconst_0
    //   784: putfield 58	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mStart	Z
    //   787: iconst_0
    //   788: istore 5
    //   790: goto -737 -> 53
    //   793: aload_0
    //   794: getfield 58	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mStart	Z
    //   797: ifeq +8 -> 805
    //   800: aload_0
    //   801: iconst_0
    //   802: putfield 58	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mStart	Z
    //   805: aload_0
    //   806: invokespecial 313	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:releaseCodec	()V
    //   809: aload_0
    //   810: invokespecial 204	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:releaseExtractor	()V
    //   813: aload_0
    //   814: aconst_null
    //   815: putfield 42	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   818: aload_0
    //   819: aconst_null
    //   820: putfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   823: aload_0
    //   824: aconst_null
    //   825: putfield 52	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   828: aload_0
    //   829: aconst_null
    //   830: putfield 54	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   833: aload_0
    //   834: lconst_0
    //   835: putfield 44	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mSamplePresentationTimeUs	J
    //   838: aload_0
    //   839: lconst_0
    //   840: putfield 46	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mPresentationTimeUs	J
    //   843: aload_0
    //   844: lconst_0
    //   845: putfield 50	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameTimeUS	J
    //   848: aload_0
    //   849: lconst_0
    //   850: putfield 48	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFirstFrameSysTime	J
    //   853: iload 5
    //   855: ifeq +21 -> 876
    //   858: aload_0
    //   859: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   862: astore 13
    //   864: aload 13
    //   866: ifnull +10 -> 876
    //   869: aload 13
    //   871: invokeinterface 316 1 0
    //   876: return
    //   877: astore 13
    //   879: aload_0
    //   880: monitorexit
    //   881: goto +6 -> 887
    //   884: aload 13
    //   886: athrow
    //   887: goto -3 -> 884
    //   890: iconst_0
    //   891: istore 6
    //   893: goto -709 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	896	0	this	HardwareFileDecoder
    //   49	674	1	i	int
    //   47	668	2	j	int
    //   114	600	3	k	int
    //   149	572	4	m	int
    //   51	803	5	n	int
    //   179	713	6	i1	int
    //   88	154	7	i2	int
    //   172	205	8	l1	long
    //   361	14	10	l2	long
    //   478	3	12	bool	boolean
    //   13	237	13	localObject1	Object
    //   260	1	13	localRuntimeException1	java.lang.RuntimeException
    //   265	1	13	localRuntimeException2	java.lang.RuntimeException
    //   385	6	13	localInterruptedException	java.lang.InterruptedException
    //   523	1	13	localRuntimeException3	java.lang.RuntimeException
    //   592	114	13	localObject2	Object
    //   718	26	13	localRuntimeException4	java.lang.RuntimeException
    //   766	104	13	localVideoFileDecodeListener	VideoFileDecodeListener
    //   877	8	13	localObject3	Object
    //   7	444	14	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   604	151	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   139	148	260	java/lang/RuntimeException
    //   222	257	260	java/lang/RuntimeException
    //   78	90	265	java/lang/RuntimeException
    //   95	115	265	java/lang/RuntimeException
    //   119	126	265	java/lang/RuntimeException
    //   133	139	265	java/lang/RuntimeException
    //   374	382	385	java/lang/InterruptedException
    //   485	516	523	java/lang/RuntimeException
    //   159	165	718	java/lang/RuntimeException
    //   168	174	718	java/lang/RuntimeException
    //   187	200	718	java/lang/RuntimeException
    //   209	217	718	java/lang/RuntimeException
    //   275	289	718	java/lang/RuntimeException
    //   297	306	718	java/lang/RuntimeException
    //   309	316	718	java/lang/RuntimeException
    //   319	328	718	java/lang/RuntimeException
    //   334	344	718	java/lang/RuntimeException
    //   347	363	718	java/lang/RuntimeException
    //   374	382	718	java/lang/RuntimeException
    //   390	395	718	java/lang/RuntimeException
    //   398	407	718	java/lang/RuntimeException
    //   410	420	718	java/lang/RuntimeException
    //   423	430	718	java/lang/RuntimeException
    //   433	447	718	java/lang/RuntimeException
    //   450	460	718	java/lang/RuntimeException
    //   463	471	718	java/lang/RuntimeException
    //   474	480	718	java/lang/RuntimeException
    //   550	561	718	java/lang/RuntimeException
    //   564	572	718	java/lang/RuntimeException
    //   585	594	718	java/lang/RuntimeException
    //   597	606	718	java/lang/RuntimeException
    //   609	618	718	java/lang/RuntimeException
    //   621	629	718	java/lang/RuntimeException
    //   632	642	718	java/lang/RuntimeException
    //   654	662	718	java/lang/RuntimeException
    //   668	677	718	java/lang/RuntimeException
    //   680	689	718	java/lang/RuntimeException
    //   692	700	718	java/lang/RuntimeException
    //   703	713	718	java/lang/RuntimeException
    //   39	46	877	finally
    //   879	881	877	finally
  }
  
  public long getCurPresentationTimeUs()
  {
    return this.mPresentationTimeUs;
  }
  
  public VideoFileDecodeListener getDecodeListener()
  {
    return this.mDecodeListener;
  }
  
  public void release()
  {
    releaseCodec();
    releaseExtractor();
  }
  
  public void setDecodeListener(VideoFileDecodeListener paramVideoFileDecodeListener)
  {
    this.mDecodeListener = paramVideoFileDecodeListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.HardwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */