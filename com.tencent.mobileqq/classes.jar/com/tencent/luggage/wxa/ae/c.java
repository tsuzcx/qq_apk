package com.tencent.luggage.wxa.ae;

import android.util.Log;
import com.tencent.luggage.wxa.ad.h;
import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends d
{
  private final m a = new m();
  private final l b = new l();
  private final int c;
  private final c.a[] d;
  private c.a e;
  private List<com.tencent.luggage.wxa.ad.a> f;
  private List<com.tencent.luggage.wxa.ad.a> g;
  private c.b h;
  private int i;
  
  public c(int paramInt)
  {
    int j = paramInt;
    if (paramInt == -1) {
      j = 1;
    }
    this.c = j;
    this.d = new c.a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.d[paramInt] = new c.a();
      paramInt += 1;
    }
    this.e = this.d[0];
    p();
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 3) {
        if (paramInt == 8) {}
      }
      switch (paramInt)
      {
      default: 
        if ((paramInt >= 17) && (paramInt <= 23))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Currently unsupported COMMAND_EXT1 Command: ");
          localStringBuilder.append(paramInt);
          Log.w("Cea708Decoder", localStringBuilder.toString());
          this.b.b(8);
          return;
        }
        if ((paramInt >= 24) && (paramInt <= 31))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Currently unsupported COMMAND_P16 Command: ");
          localStringBuilder.append(paramInt);
          Log.w("Cea708Decoder", localStringBuilder.toString());
          this.b.b(16);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid C0 command: ");
        localStringBuilder.append(paramInt);
        Log.w("Cea708Decoder", localStringBuilder.toString());
        return;
      case 13: 
        this.e.a('\n');
        return;
      case 12: 
        p();
        return;
        this.e.f();
        return;
        this.f = o();
      }
    }
  }
  
  private void b(int paramInt)
  {
    int k = 1;
    int m = 1;
    int j = 1;
    Object localObject;
    switch (paramInt)
    {
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid C1 command: ");
      ((StringBuilder)localObject).append(paramInt);
      Log.w("Cea708Decoder", ((StringBuilder)localObject).toString());
      return;
    case 152: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
    case 159: 
      paramInt -= 152;
      i(paramInt);
      if (this.i != paramInt)
      {
        this.i = paramInt;
        this.e = this.d[paramInt];
        return;
      }
      break;
    case 151: 
      if (!this.e.d())
      {
        this.b.b(32);
        return;
      }
      n();
      return;
    case 146: 
      if (!this.e.d())
      {
        this.b.b(16);
        return;
      }
      m();
      return;
    case 145: 
      if (!this.e.d())
      {
        this.b.b(24);
        return;
      }
      l();
      return;
    case 144: 
      if (!this.e.d())
      {
        this.b.b(16);
        return;
      }
      k();
      return;
    case 143: 
      p();
      return;
    case 141: 
      this.b.b(8);
      return;
    case 140: 
    case 139: 
    case 138: 
    case 137: 
    case 136: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
      while (j <= 8)
      {
        if (this.b.e()) {
          this.d[(8 - j)].b();
        }
        j += 1;
        continue;
        paramInt = 1;
        while (paramInt <= 8)
        {
          if (this.b.e())
          {
            localObject = this.d[(8 - paramInt)];
            ((c.a)localObject).a(((c.a)localObject).e() ^ true);
          }
          paramInt += 1;
          continue;
          while (k <= 8)
          {
            if (this.b.e()) {
              this.d[(8 - k)].a(false);
            }
            k += 1;
            continue;
            paramInt = 1;
            while (paramInt <= 8)
            {
              if (this.b.e()) {
                this.d[(8 - paramInt)].a(true);
              }
              paramInt += 1;
              continue;
              while (m <= 8)
              {
                if (this.b.e()) {
                  this.d[(8 - m)].c();
                }
                m += 1;
                continue;
                paramInt -= 128;
                if (this.i != paramInt)
                {
                  this.i = paramInt;
                  this.e = this.d[paramInt];
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt <= 7) {
      return;
    }
    if (paramInt <= 15)
    {
      this.b.b(8);
      return;
    }
    if (paramInt <= 23)
    {
      this.b.b(16);
      return;
    }
    if (paramInt <= 31) {
      this.b.b(24);
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt <= 135)
    {
      this.b.b(32);
      return;
    }
    if (paramInt <= 143)
    {
      this.b.b(40);
      return;
    }
    if (paramInt <= 159)
    {
      this.b.b(2);
      paramInt = this.b.c(6);
      this.b.b(paramInt * 8);
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 127)
    {
      this.e.a('♫');
      return;
    }
    this.e.a((char)(paramInt & 0xFF));
  }
  
  private void f(int paramInt)
  {
    this.e.a((char)(paramInt & 0xFF));
  }
  
  private void g(int paramInt)
  {
    if (paramInt != 32)
    {
      if (paramInt != 33)
      {
        if (paramInt != 37)
        {
          if (paramInt != 42)
          {
            if (paramInt != 44)
            {
              if (paramInt != 63)
              {
                if (paramInt != 57)
                {
                  if (paramInt != 58)
                  {
                    if (paramInt != 60)
                    {
                      if (paramInt != 61)
                      {
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            StringBuilder localStringBuilder = new StringBuilder();
                            localStringBuilder.append("Invalid G2 character: ");
                            localStringBuilder.append(paramInt);
                            Log.w("Cea708Decoder", localStringBuilder.toString());
                            return;
                          case 127: 
                            this.e.a('┌');
                            return;
                          case 126: 
                            this.e.a('┘');
                            return;
                          case 125: 
                            this.e.a('─');
                            return;
                          case 124: 
                            this.e.a('└');
                            return;
                          case 123: 
                            this.e.a('┐');
                            return;
                          case 122: 
                            this.e.a('│');
                            return;
                          case 121: 
                            this.e.a('⅞');
                            return;
                          case 120: 
                            this.e.a('⅝');
                            return;
                          case 119: 
                            this.e.a('⅜');
                            return;
                          }
                          this.e.a('⅛');
                          return;
                        case 53: 
                          this.e.a('•');
                          return;
                        case 52: 
                          this.e.a('”');
                          return;
                        case 51: 
                          this.e.a('“');
                          return;
                        case 50: 
                          this.e.a('’');
                          return;
                        case 49: 
                          this.e.a('‘');
                          return;
                        }
                        this.e.a('█');
                        return;
                      }
                      this.e.a('℠');
                      return;
                    }
                    this.e.a('œ');
                    return;
                  }
                  this.e.a('š');
                  return;
                }
                this.e.a('™');
                return;
              }
              this.e.a('Ÿ');
              return;
            }
            this.e.a('Œ');
            return;
          }
          this.e.a('Š');
          return;
        }
        this.e.a('…');
        return;
      }
      this.e.a(' ');
      return;
    }
    this.e.a(' ');
  }
  
  private void h(int paramInt)
  {
    if (paramInt == 160)
    {
      this.e.a('㏄');
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid G3 character: ");
    localStringBuilder.append(paramInt);
    Log.w("Cea708Decoder", localStringBuilder.toString());
    this.e.a('_');
  }
  
  private void i()
  {
    if (this.h == null) {
      return;
    }
    j();
    this.h = null;
  }
  
  private void i(int paramInt)
  {
    c.a locala = this.d[paramInt];
    this.b.b(2);
    boolean bool1 = this.b.e();
    boolean bool2 = this.b.e();
    boolean bool3 = this.b.e();
    paramInt = this.b.c(3);
    boolean bool4 = this.b.e();
    int j = this.b.c(7);
    int k = this.b.c(8);
    int m = this.b.c(4);
    int n = this.b.c(4);
    this.b.b(2);
    int i1 = this.b.c(6);
    this.b.b(2);
    locala.a(bool1, bool2, bool3, paramInt, bool4, j, k, n, i1, m, this.b.c(3), this.b.c(3));
  }
  
  private void j()
  {
    StringBuilder localStringBuilder;
    if (this.h.d != this.h.b * 2 - 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DtvCcPacket ended prematurely; size is ");
      localStringBuilder.append(this.h.b * 2 - 1);
      localStringBuilder.append(", but current index is ");
      localStringBuilder.append(this.h.d);
      localStringBuilder.append(" (sequence number ");
      localStringBuilder.append(this.h.a);
      localStringBuilder.append("); ignoring packet");
      Log.w("Cea708Decoder", localStringBuilder.toString());
      return;
    }
    this.b.a(this.h.c, this.h.d);
    int k = this.b.c(3);
    int m = this.b.c(5);
    int j = k;
    if (k == 7)
    {
      this.b.b(2);
      j = k + this.b.c(6);
    }
    if (m == 0)
    {
      if (j != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("serviceNumber is non-zero (");
        localStringBuilder.append(j);
        localStringBuilder.append(") when blockSize is 0");
        Log.w("Cea708Decoder", localStringBuilder.toString());
      }
      return;
    }
    if (j != this.c) {
      return;
    }
    j = 0;
    while (this.b.a() > 0)
    {
      k = this.b.c(8);
      if (k != 16)
      {
        if (k <= 31)
        {
          a(k);
          continue;
        }
        if (k <= 127)
        {
          e(k);
        }
        else if (k <= 159)
        {
          b(k);
        }
        else if (k <= 255)
        {
          f(k);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid base command: ");
          localStringBuilder.append(k);
          Log.w("Cea708Decoder", localStringBuilder.toString());
        }
      }
      else
      {
        k = this.b.c(8);
        if (k <= 31)
        {
          c(k);
          continue;
        }
        if (k > 127) {
          break label409;
        }
        g(k);
      }
      for (;;)
      {
        j = 1;
        break;
        label409:
        if (k <= 159)
        {
          d(k);
          break;
        }
        if (k > 255) {
          break label439;
        }
        h(k);
      }
      label439:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid extended command: ");
      localStringBuilder.append(k);
      Log.w("Cea708Decoder", localStringBuilder.toString());
    }
    if (j != 0) {
      this.f = o();
    }
  }
  
  private void k()
  {
    int j = this.b.c(4);
    int k = this.b.c(2);
    int m = this.b.c(2);
    boolean bool1 = this.b.e();
    boolean bool2 = this.b.e();
    int n = this.b.c(3);
    int i1 = this.b.c(3);
    this.e.a(j, k, m, bool1, bool2, n, i1);
  }
  
  private void l()
  {
    int j = this.b.c(2);
    j = c.a.a(this.b.c(2), this.b.c(2), this.b.c(2), j);
    int k = this.b.c(2);
    k = c.a.a(this.b.c(2), this.b.c(2), this.b.c(2), k);
    this.b.b(2);
    int m = c.a.b(this.b.c(2), this.b.c(2), this.b.c(2));
    this.e.a(j, k, m);
  }
  
  private void m()
  {
    this.b.b(4);
    int j = this.b.c(4);
    this.b.b(2);
    int k = this.b.c(6);
    this.e.a(j, k);
  }
  
  private void n()
  {
    int j = this.b.c(2);
    int m = c.a.a(this.b.c(2), this.b.c(2), this.b.c(2), j);
    int k = this.b.c(2);
    int n = c.a.b(this.b.c(2), this.b.c(2), this.b.c(2));
    j = k;
    if (this.b.e()) {
      j = k | 0x4;
    }
    boolean bool = this.b.e();
    k = this.b.c(2);
    int i1 = this.b.c(2);
    int i2 = this.b.c(2);
    this.b.b(8);
    this.e.a(m, n, bool, j, k, i1, i2);
  }
  
  private List<com.tencent.luggage.wxa.ad.a> o()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < 8)
    {
      if ((!this.d[j].a()) && (this.d[j].e())) {
        localArrayList.add(this.d[j].h());
      }
      j += 1;
    }
    Collections.sort(localArrayList);
    return Collections.unmodifiableList(localArrayList);
  }
  
  private void p()
  {
    int j = 0;
    while (j < 8)
    {
      this.d[j].b();
      j += 1;
    }
  }
  
  protected void a(h paramh)
  {
    this.a.a(paramh.b.array(), paramh.b.limit());
    while (this.a.b() >= 3)
    {
      int m = this.a.g() & 0x7;
      int n = m & 0x3;
      boolean bool = false;
      if ((m & 0x4) == 4) {
        m = 1;
      } else {
        m = 0;
      }
      int j = (byte)this.a.g();
      int k = (byte)this.a.g();
      if (((n == 2) || (n == 3)) && (m != 0))
      {
        c.b localb;
        if (n == 3)
        {
          i();
          n = j & 0x3F;
          m = n;
          if (n == 0) {
            m = 64;
          }
          this.h = new c.b((j & 0xC0) >> 6, m);
          paramh = this.h.c;
          localb = this.h;
          m = localb.d;
          localb.d = (m + 1);
          paramh[m] = k;
        }
        else
        {
          if (n == 2) {
            bool = true;
          }
          com.tencent.luggage.wxa.ao.a.a(bool);
          paramh = this.h;
          if (paramh == null)
          {
            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
            continue;
          }
          paramh = paramh.c;
          localb = this.h;
          m = localb.d;
          localb.d = (m + 1);
          paramh[m] = j;
          paramh = this.h.c;
          localb = this.h;
          m = localb.d;
          localb.d = (m + 1);
          paramh[m] = k;
        }
        if (this.h.d == this.h.b * 2 - 1) {
          i();
        }
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.f = null;
    this.g = null;
    this.i = 0;
    this.e = this.d[this.i];
    p();
    this.h = null;
  }
  
  protected boolean e()
  {
    return this.f != this.g;
  }
  
  protected com.tencent.luggage.wxa.ad.d f()
  {
    List localList = this.f;
    this.g = localList;
    return new f(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.c
 * JD-Core Version:    0.7.0.1
 */