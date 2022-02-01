package com.tencent.luggage.wxa.n;

import android.util.Log;
import com.tencent.luggage.wxa.ao.j;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.ap.b;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;
import com.tencent.luggage.wxa.l.l.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

final class d$b
{
  public float A = -1.0F;
  public float B = -1.0F;
  public float C = -1.0F;
  public float D = -1.0F;
  public float E = -1.0F;
  public float F = -1.0F;
  public int G = 1;
  public int H = -1;
  public int I = 8000;
  public long J = 0L;
  public long K = 0L;
  public boolean L;
  public boolean M = true;
  public l N;
  public int O;
  private String P = "eng";
  public String a;
  public int b;
  public int c;
  public int d;
  public boolean e;
  public byte[] f;
  public l.a g;
  public byte[] h;
  public com.tencent.luggage.wxa.k.a i;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public int n = 0;
  public byte[] o = null;
  public int p = -1;
  public boolean q = false;
  public int r = -1;
  public int s = -1;
  public int t = -1;
  public int u = 1000;
  public int v = 200;
  public float w = -1.0F;
  public float x = -1.0F;
  public float y = -1.0F;
  public float z = -1.0F;
  
  private static List<byte[]> a(m paramm)
  {
    try
    {
      paramm.d(16);
      if (paramm.m() != 826496599L) {
        return null;
      }
      i1 = paramm.d() + 20;
      paramm = paramm.a;
    }
    catch (ArrayIndexOutOfBoundsException paramm)
    {
      for (;;)
      {
        int i1;
        continue;
        i1 += 1;
      }
    }
    if (i1 < paramm.length - 4)
    {
      if ((paramm[i1] == 0) && (paramm[(i1 + 1)] == 0) && (paramm[(i1 + 2)] == 1) && (paramm[(i1 + 3)] == 15)) {
        return Collections.singletonList(Arrays.copyOfRange(paramm, i1, paramm.length));
      }
    }
    else
    {
      throw new p("Failed to find FourCC VC1 initialization data");
      paramm = new p("Error parsing FourCC VC1 codec private");
      for (;;)
      {
        throw paramm;
      }
    }
  }
  
  private static List<byte[]> a(byte[] paramArrayOfByte)
  {
    int i1;
    int i2;
    if (paramArrayOfByte[0] == 2)
    {
      i1 = 1;
      i2 = 0;
    }
    for (;;)
    {
      int i3 = i2 + 1;
      i2 = paramArrayOfByte[i2];
      if (paramArrayOfByte[i3] == 1) {}
      try
      {
        byte[] arrayOfByte1 = new byte[i4];
        System.arraycopy(paramArrayOfByte, i3, arrayOfByte1, 0, i4);
        i3 += i4;
        if (paramArrayOfByte[i3] == 3)
        {
          i1 = i3 + (i1 + i2);
          if (paramArrayOfByte[i1] == 5)
          {
            byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i1];
            System.arraycopy(paramArrayOfByte, i1, arrayOfByte2, 0, paramArrayOfByte.length - i1);
            paramArrayOfByte = new ArrayList(2);
            paramArrayOfByte.add(arrayOfByte1);
            paramArrayOfByte.add(arrayOfByte2);
            return paramArrayOfByte;
          }
          throw new p("Error parsing vorbis codec private");
        }
        throw new p("Error parsing vorbis codec private");
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        break label159;
      }
      throw new p("Error parsing vorbis codec private");
      throw new p("Error parsing vorbis codec private");
      label159:
      paramArrayOfByte = new p("Error parsing vorbis codec private");
      for (;;)
      {
        throw paramArrayOfByte;
      }
      while (paramArrayOfByte[i1] == -1)
      {
        i2 += 255;
        i1 += 1;
      }
      i3 = i1 + 1;
      int i4 = i2 + paramArrayOfByte[i1];
      i1 = 0;
      i2 = i3;
      while (paramArrayOfByte[i2] == -1)
      {
        i1 += 255;
        i2 += 1;
      }
    }
  }
  
  private byte[] a()
  {
    if ((this.w != -1.0F) && (this.x != -1.0F) && (this.y != -1.0F) && (this.z != -1.0F) && (this.A != -1.0F) && (this.B != -1.0F) && (this.C != -1.0F) && (this.D != -1.0F) && (this.E != -1.0F) && (this.F != -1.0F))
    {
      byte[] arrayOfByte = new byte[25];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.put((byte)0);
      localByteBuffer.putShort((short)(int)(this.w * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.x * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.y * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.z * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.A * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.B * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.C * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.D * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.E + 0.5F));
      localByteBuffer.putShort((short)(int)(this.F + 0.5F));
      localByteBuffer.putShort((short)this.u);
      localByteBuffer.putShort((short)this.v);
      return arrayOfByte;
    }
    return null;
  }
  
  private static boolean b(m paramm)
  {
    try
    {
      int i1 = paramm.i();
      if (i1 == 1) {
        return true;
      }
      if (i1 == 65534)
      {
        paramm.c(24);
        if (paramm.p() == d.b().getMostSignificantBits())
        {
          long l1 = paramm.p();
          long l2 = d.b().getLeastSignificantBits();
          if (l1 == l2) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramm)
    {
      label64:
      break label64;
    }
    throw new p("Error parsing MS/ACM codec private");
  }
  
  public void a(f paramf, int paramInt)
  {
    Object localObject1 = this.a;
    int i1 = ((String)localObject1).hashCode();
    int i3 = 0;
    int i4 = 3;
    switch (i1)
    {
    default: 
      break;
    case 1951062397: 
      if (((String)localObject1).equals("A_OPUS")) {
        i1 = 11;
      }
      break;
    case 1950789798: 
      if (((String)localObject1).equals("A_FLAC")) {
        i1 = 21;
      }
      break;
    case 1950749482: 
      if (((String)localObject1).equals("A_EAC3")) {
        i1 = 16;
      }
      break;
    case 1809237540: 
      if (((String)localObject1).equals("V_MPEG2")) {
        i1 = 2;
      }
      break;
    case 1422270023: 
      if (((String)localObject1).equals("S_TEXT/UTF8")) {
        i1 = 24;
      }
      break;
    case 855502857: 
      if (((String)localObject1).equals("V_MPEGH/ISO/HEVC")) {
        i1 = 7;
      }
      break;
    case 738597099: 
      if (((String)localObject1).equals("S_TEXT/ASS")) {
        i1 = 25;
      }
      break;
    case 725957860: 
      if (((String)localObject1).equals("A_PCM/INT/LIT")) {
        i1 = 23;
      }
      break;
    case 542569478: 
      if (((String)localObject1).equals("A_DTS/EXPRESS")) {
        i1 = 19;
      }
      break;
    case 444813526: 
      if (((String)localObject1).equals("V_THEORA")) {
        i1 = 9;
      }
      break;
    case 99146302: 
      if (((String)localObject1).equals("S_HDMV/PGS")) {
        i1 = 27;
      }
      break;
    case 82338134: 
      if (((String)localObject1).equals("V_VP9")) {
        i1 = 1;
      }
      break;
    case 82338133: 
      if (((String)localObject1).equals("V_VP8")) {
        i1 = 0;
      }
      break;
    case 62927045: 
      if (((String)localObject1).equals("A_DTS")) {
        i1 = 18;
      }
      break;
    case 62923603: 
      if (((String)localObject1).equals("A_AC3")) {
        i1 = 15;
      }
      break;
    case 62923557: 
      if (((String)localObject1).equals("A_AAC")) {
        i1 = 12;
      }
      break;
    case -356037306: 
      if (((String)localObject1).equals("A_DTS/LOSSLESS")) {
        i1 = 20;
      }
      break;
    case -425012669: 
      if (((String)localObject1).equals("S_VOBSUB")) {
        i1 = 26;
      }
      break;
    case -538363109: 
      if (((String)localObject1).equals("V_MPEG4/ISO/AVC")) {
        i1 = 6;
      }
      break;
    case -538363189: 
      if (((String)localObject1).equals("V_MPEG4/ISO/ASP")) {
        i1 = 4;
      }
      break;
    case -933872740: 
      if (((String)localObject1).equals("S_DVBSUB")) {
        i1 = 28;
      }
      break;
    case -1373388978: 
      if (((String)localObject1).equals("V_MS/VFW/FOURCC")) {
        i1 = 8;
      }
      break;
    case -1482641357: 
      if (((String)localObject1).equals("A_MPEG/L3")) {
        i1 = 14;
      }
      break;
    case -1482641358: 
      if (((String)localObject1).equals("A_MPEG/L2")) {
        i1 = 13;
      }
      break;
    case -1730367663: 
      if (((String)localObject1).equals("A_VORBIS")) {
        i1 = 10;
      }
      break;
    case -1784763192: 
      if (((String)localObject1).equals("A_TRUEHD")) {
        i1 = 17;
      }
      break;
    case -1985379776: 
      if (((String)localObject1).equals("A_MS/ACM")) {
        i1 = 22;
      }
      break;
    case -2095575984: 
      if (((String)localObject1).equals("V_MPEG4/ISO/SP")) {
        i1 = 3;
      }
      break;
    case -2095576542: 
      if (((String)localObject1).equals("V_MPEG4/ISO/AP")) {
        i1 = 5;
      }
      break;
    }
    i1 = -1;
    Object localObject4 = null;
    label1246:
    Object localObject3;
    switch (i1)
    {
    default: 
      throw new p("Unrecognized codec identifier.");
    case 28: 
      localObject1 = this.h;
      localObject1 = Collections.singletonList(new byte[] { localObject1[0], localObject1[1], localObject1[2], localObject1[3] });
      localObject2 = "application/dvbsubs";
      break;
    case 27: 
      localObject1 = "application/pgs";
      break;
    case 26: 
      localObject2 = Collections.singletonList(this.h);
      localObject1 = "application/vobsub";
      break;
    case 25: 
      localObject1 = "text/x-ssa";
      break;
    case 24: 
      localObject1 = "application/x-subrip";
      break;
    case 23: 
      i2 = x.b(this.H);
      i1 = i2;
      if (i2 == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unsupported PCM bit depth: ");
        ((StringBuilder)localObject1).append(this.H);
        ((StringBuilder)localObject1).append(". Setting mimeType to ");
        ((StringBuilder)localObject1).append("audio/x-unknown");
        Log.w("MatroskaExtractor", ((StringBuilder)localObject1).toString());
      }
      break;
    case 22: 
      do
      {
        i2 = i1;
        localObject1 = "audio/raw";
        localObject2 = null;
        i1 = -1;
        break label1686;
        if (!b(new m(this.h))) {
          break;
        }
        i2 = x.b(this.H);
        i1 = i2;
      } while (i2 != 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unsupported PCM bit depth: ");
      ((StringBuilder)localObject1).append(this.H);
      ((StringBuilder)localObject1).append(". Setting mimeType to ");
      ((StringBuilder)localObject1).append("audio/x-unknown");
      Log.w("MatroskaExtractor", ((StringBuilder)localObject1).toString());
      break label1246;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
      ((StringBuilder)localObject1).append("audio/x-unknown");
      Log.w("MatroskaExtractor", ((StringBuilder)localObject1).toString());
      localObject1 = "audio/x-unknown";
      break;
    case 21: 
      localObject1 = Collections.singletonList(this.h);
      localObject2 = "audio/flac";
      break;
    case 20: 
      localObject1 = "audio/vnd.dts.hd";
      break;
    case 18: 
    case 19: 
      localObject1 = "audio/vnd.dts";
      break;
    case 17: 
      localObject1 = "audio/true-hd";
      break;
    case 16: 
      localObject1 = "audio/eac3";
      break;
    case 15: 
      localObject1 = "audio/ac3";
      break;
    case 14: 
      localObject1 = "audio/mpeg";
      break;
    case 13: 
      localObject1 = "audio/mpeg-L2";
      localObject2 = null;
      i1 = 4096;
      break;
    case 12: 
      localObject1 = Collections.singletonList(this.h);
      localObject2 = "audio/mp4a-latm";
    case 11: 
    case 10: 
    case 9: 
    case 8: 
    case 7: 
    case 6: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        i1 = -1;
        i2 = -1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label1686;
        localObject2 = new ArrayList(3);
        ((List)localObject2).add(this.h);
        ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
        ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
        localObject1 = "audio/opus";
        i1 = 5760;
        break label1683;
        localObject2 = a(this.h);
        localObject1 = "audio/vorbis";
        i1 = 8192;
        break label1683;
        localObject1 = "video/x-unknown";
        break;
        localObject1 = a(new m(this.h));
        if (localObject1 != null)
        {
          localObject2 = "video/wvc1";
        }
        else
        {
          Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
          localObject2 = localObject1;
          localObject1 = "video/x-unknown";
          break label1680;
          localObject1 = com.tencent.luggage.wxa.ap.d.a(new m(this.h));
          localObject2 = ((com.tencent.luggage.wxa.ap.d)localObject1).a;
          this.O = ((com.tencent.luggage.wxa.ap.d)localObject1).b;
          localObject1 = "video/hevc";
          break label1680;
          localObject1 = com.tencent.luggage.wxa.ap.a.a(new m(this.h));
          localObject2 = ((com.tencent.luggage.wxa.ap.a)localObject1).a;
          this.O = ((com.tencent.luggage.wxa.ap.a)localObject1).b;
          localObject1 = "video/avc";
          break label1680;
          localObject1 = this.h;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = Collections.singletonList(localObject1);
          }
          localObject2 = "video/mp4v-es";
        }
      }
    case 2: 
      localObject1 = "video/mpeg2";
      break;
    case 1: 
      localObject1 = "video/x-vnd.on2.vp9";
      break;
    }
    localObject1 = "video/x-vnd.on2.vp8";
    Object localObject2 = null;
    label1680:
    i1 = -1;
    label1683:
    int i2 = -1;
    label1686:
    boolean bool = this.M;
    if (this.L) {
      i3 = 2;
    }
    i3 |= bool | false;
    if (j.a((String)localObject1))
    {
      localObject1 = k.a(Integer.toString(paramInt), (String)localObject1, null, -1, i1, this.G, this.I, i2, (List)localObject2, this.i, i3, this.P);
      paramInt = 1;
    }
    else if (j.b((String)localObject1))
    {
      if (this.n == 0)
      {
        i3 = this.l;
        i2 = i3;
        if (i3 == -1) {
          i2 = this.j;
        }
        this.l = i2;
        i3 = this.m;
        i2 = i3;
        if (i3 == -1) {
          i2 = this.k;
        }
        this.m = i2;
      }
      i2 = this.l;
      if (i2 != -1)
      {
        i3 = this.m;
        if (i3 != -1)
        {
          f1 = this.k * i2 / (this.j * i3);
          break label1880;
        }
      }
      float f1 = -1.0F;
      label1880:
      localObject3 = localObject4;
      if (this.q)
      {
        localObject3 = a();
        localObject3 = new b(this.r, this.t, this.s, (byte[])localObject3);
      }
      localObject1 = k.a(Integer.toString(paramInt), (String)localObject1, null, -1, i1, this.j, this.k, -1.0F, (List)localObject2, -1, f1, this.o, this.p, (b)localObject3, this.i);
      paramInt = 2;
    }
    else if ("application/x-subrip".equals(localObject1))
    {
      localObject1 = k.a(Integer.toString(paramInt), (String)localObject1, i3, this.P, this.i);
      paramInt = i4;
    }
    else if ("text/x-ssa".equals(localObject1))
    {
      localObject2 = new ArrayList(2);
      ((List)localObject2).add(d.a());
      ((List)localObject2).add(this.h);
      localObject1 = k.a(Integer.toString(paramInt), (String)localObject1, null, -1, i3, this.P, -1, this.i, 9223372036854775807L, (List)localObject2);
      paramInt = i4;
    }
    else
    {
      if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
        throw new p("Unexpected MIME type.");
      }
      localObject1 = k.a(Integer.toString(paramInt), (String)localObject1, null, -1, (List)localObject2, this.P, this.i);
      paramInt = i4;
    }
    this.N = paramf.a(this.b, paramInt);
    this.N.a((k)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.n.d.b
 * JD-Core Version:    0.7.0.1
 */