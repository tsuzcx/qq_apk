package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.basic.util.g.a;
import com.tencent.liteav.videodecoder.e;
import com.tencent.liteav.videoencoder.c;

public class TRTCEncodeTypeDecision
{
  public static final int CODEC_ABILITY_VALUE_SUPPORT_264 = 3;
  public static final int CODEC_ABILITY_VALUE_SUPPORT_264_DECODE = 2;
  public static final int CODEC_ABILITY_VALUE_SUPPORT_264_ENCODE = 1;
  private static final int CODEC_ABILITY_VALUE_SUPPORT_265_DECODE_BITMASK = 3;
  private static final int CODEC_ABILITY_VALUE_SUPPORT_265_ENCODE_BITMASK = 2;
  private static final String TAG = "TRTCH265Decision";
  private static boolean sLifeCycleEnableH265Decoder = true;
  private static boolean sLifeCycleEnableH265Encode = true;
  private boolean mEnableH265EncodeByPrivateAPI = false;
  private boolean mEnableH265EncodeByServer = false;
  private TRTCCloudImpl mTrtcCloud;
  
  public TRTCEncodeTypeDecision(TRTCCloudImpl paramTRTCCloudImpl)
  {
    this.mTrtcCloud = paramTRTCCloudImpl;
  }
  
  public static int getEnterRoomCodecSupportValue()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int getH265DecoderValue()
  {
    int i;
    if ((sLifeCycleEnableH265Decoder) && (e.a(1920, 1080, 20))) {
      i = 1;
    } else {
      i = 0;
    }
    return i << 3;
  }
  
  public static boolean isAppLifeCycleEnableH265Decoder()
  {
    return sLifeCycleEnableH265Decoder;
  }
  
  public static boolean isAppLifeCycleEnableH265Encoder()
  {
    return sLifeCycleEnableH265Encode;
  }
  
  public static void setAppLifeCycleEnableH265Decoder(boolean paramBoolean)
  {
    sLifeCycleEnableH265Decoder = paramBoolean;
  }
  
  public static void setAppLifeCycleEnableH265Encoder(boolean paramBoolean)
  {
    sLifeCycleEnableH265Encode = paramBoolean;
  }
  
  public int getExpectVideoCodecType(int paramInt)
  {
    int i = g.a.a.a();
    boolean bool1 = true;
    if (paramInt == 1)
    {
      boolean bool2 = c.a(1920, 1080, 20);
      if ((!this.mEnableH265EncodeByPrivateAPI) || (!isAppLifeCycleEnableH265Encoder()) || (!bool2)) {
        bool1 = false;
      }
      if (bool1) {
        localObject = g.a.b;
      } else {
        localObject = g.a.a;
      }
      i = ((g.a)localObject).a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableH265 = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" expectCodecType=");
      ((StringBuilder)localObject).append(i);
      TXCLog.i("TRTCH265Decision", ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public boolean isVideoEncoderCodecUsingH265()
  {
    boolean bool2 = c.a(1920, 1080, 20);
    boolean bool1;
    if ((this.mEnableH265EncodeByPrivateAPI) && (this.mEnableH265EncodeByServer) && (isAppLifeCycleEnableH265Encoder()) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("codecability getVideoEncoderCodec: ");
    localStringBuilder.append(this.mEnableH265EncodeByServer);
    localStringBuilder.append(" ,mEnableHighQualityEncode=");
    localStringBuilder.append(this.mEnableH265EncodeByPrivateAPI);
    localStringBuilder.append(", TRTCH265Decision.isAppLifeCycleEnableH265Encoder()= ");
    localStringBuilder.append(isAppLifeCycleEnableH265Encoder());
    localStringBuilder.append(" supportEncoder = ");
    localStringBuilder.append(bool2);
    TXCLog.i("TRTCH265Decision", localStringBuilder.toString());
    return bool1;
  }
  
  public boolean isVideoEncoderStartCodecUsingH265()
  {
    g.a locala = g.a.a(g.a().b("key_last_encode_type", g.a.a.a()));
    boolean bool3 = c.a(1920, 1080, 20);
    boolean bool1;
    if ((this.mEnableH265EncodeByPrivateAPI) && (isAppLifeCycleEnableH265Encoder()) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1) {
      if (locala == g.a.b) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoEncoderStartCodec enableH265 = ");
    localStringBuilder.append(bool2);
    localStringBuilder.append(" , lastEncodeType=");
    localStringBuilder.append(locala.a());
    localStringBuilder.append(" mEnableH265EncodeByPrivateAPI=");
    localStringBuilder.append(this.mEnableH265EncodeByPrivateAPI);
    localStringBuilder.append(" supportEncoder=");
    localStringBuilder.append(bool3);
    TXCLog.i("TRTCH265Decision", localStringBuilder.toString());
    return bool2;
  }
  
  public void setEnableH265EncodeByPrivateAPI(boolean paramBoolean)
  {
    setEnableH265EncodeByPrivateAPI(paramBoolean, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_NO_NEED_CARE);
  }
  
  public void setEnableH265EncodeByPrivateAPI(boolean paramBoolean, TRTCEncodeTypeDecision.ModifyCodecReason paramModifyCodecReason)
  {
    this.mEnableH265EncodeByPrivateAPI = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnableH265EncodeByPrivateAPI: enableH265EncodeByPrivateAPI= ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", reason =");
    localStringBuilder.append(paramModifyCodecReason);
    TXCLog.i("TRTCH265Decision", localStringBuilder.toString());
    if (paramModifyCodecReason == TRTCEncodeTypeDecision.ModifyCodecReason.REASON_ENCODE_ERROR)
    {
      setAppLifeCycleEnableH265Encoder(false);
      this.mTrtcCloud.notifyCurrentEncodeType(false);
      return;
    }
    if ((paramModifyCodecReason == TRTCEncodeTypeDecision.ModifyCodecReason.REASON_DECODE_ERROR) && (!a.a())) {
      setAppLifeCycleEnableH265Decoder(false);
    }
  }
  
  public void setEnableH265EncodeByServer(boolean paramBoolean)
  {
    setEnableH265EncodeByServer(paramBoolean, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_NO_NEED_CARE);
  }
  
  public void setEnableH265EncodeByServer(boolean paramBoolean, TRTCEncodeTypeDecision.ModifyCodecReason paramModifyCodecReason)
  {
    if (this.mEnableH265EncodeByServer != paramBoolean)
    {
      if (paramModifyCodecReason == TRTCEncodeTypeDecision.ModifyCodecReason.REASON_QOS)
      {
        if (paramBoolean) {
          return;
        }
        if (isVideoEncoderCodecUsingH265()) {
          this.mTrtcCloud.notifyCurrentEncodeType(false);
        }
      }
      this.mEnableH265EncodeByServer = paramBoolean;
      if (paramModifyCodecReason == TRTCEncodeTypeDecision.ModifyCodecReason.REASON_ENTERROOM_RESPOND)
      {
        paramBoolean = isVideoEncoderCodecUsingH265();
        if (paramBoolean) {
          localObject = g.a.b;
        } else {
          localObject = g.a.a;
        }
        g.a().a("key_last_encode_type", ((g.a)localObject).a());
        this.mTrtcCloud.notifyCurrentEncodeType(paramBoolean);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setEnableH265EncodeByServer: enableH265EncodeByServer= ");
      ((StringBuilder)localObject).append(this.mEnableH265EncodeByServer);
      ((StringBuilder)localObject).append(", reason =");
      ((StringBuilder)localObject).append(paramModifyCodecReason);
      TXCLog.i("TRTCH265Decision", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCEncodeTypeDecision
 * JD-Core Version:    0.7.0.1
 */