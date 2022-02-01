package com.tencent.biz.qqstory.network.request;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class PublishStoryVideoRequest
  extends NetworkRequest
{
  public static final String Y = String.valueOf(1);
  public static final String Z = String.valueOf(2);
  public static final String aa = String.valueOf(3);
  public static final String ab = String.valueOf(4);
  public static final String ac = String.valueOf(5);
  public static final String e = StoryApi.a("StorySvc.video_show_publish");
  public static final String f = StoryApi.a("StoryGroupSvc.do_video_publish");
  public String A;
  public String B;
  public int C;
  public long D;
  public int E;
  public int F;
  public String G;
  public byte[] H;
  public byte[] I;
  public String J;
  public boolean K = false;
  public int L = 0;
  public byte[] M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public VideoLinkInfo R;
  public String S;
  public String T;
  public boolean U;
  public String V;
  public int W = 0;
  public int X;
  public boolean g;
  public String h = "";
  public String i;
  public String j;
  public long k;
  public String l;
  public String m;
  public String n;
  public String o;
  public long p;
  @Nullable
  public String q;
  public String r;
  public AddressItem s;
  public long t;
  public int u;
  public int v;
  public int w;
  public int x;
  public long y;
  public String z;
  
  public PublishStoryVideoRequest(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.c = 5;
  }
  
  public String a()
  {
    if (this.g) {
      return f;
    }
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspPublishVideo localRspPublishVideo = new qqstory_service.RspPublishVideo();
    try
    {
      localRspPublishVideo.mergeFrom(paramArrayOfByte);
      return new PublishStoryVideoRespond(localRspPublishVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label23:
      break label23;
    }
    return null;
  }
  
  protected byte[] c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishStoryVideoRequest{title='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoThumbnailUrl='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOriginalMaskPicUrl='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest
 * JD-Core Version:    0.7.0.1
 */