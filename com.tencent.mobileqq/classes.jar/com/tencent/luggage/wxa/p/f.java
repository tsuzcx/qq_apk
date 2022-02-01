package com.tencent.luggage.wxa.p;

import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.v.a.a;
import com.tencent.luggage.wxa.x.e;
import com.tencent.luggage.wxa.x.h;
import com.tencent.luggage.wxa.x.j;

final class f
{
  private static final int A = x.f("sosn");
  private static final int B = x.f("tvsh");
  private static final int C = x.f("----");
  private static final String[] D = { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
  private static final int a = x.f("nam");
  private static final int b = x.f("trk");
  private static final int c = x.f("cmt");
  private static final int d = x.f("day");
  private static final int e = x.f("ART");
  private static final int f = x.f("too");
  private static final int g = x.f("alb");
  private static final int h = x.f("com");
  private static final int i = x.f("wrt");
  private static final int j = x.f("lyr");
  private static final int k = x.f("gen");
  private static final int l = x.f("covr");
  private static final int m = x.f("gnre");
  private static final int n = x.f("grp");
  private static final int o = x.f("disk");
  private static final int p = x.f("trkn");
  private static final int q = x.f("tmpo");
  private static final int r = x.f("cpil");
  private static final int s = x.f("aART");
  private static final int t = x.f("sonm");
  private static final int u = x.f("soal");
  private static final int v = x.f("soar");
  private static final int w = x.f("soaa");
  private static final int x = x.f("soco");
  private static final int y = x.f("rtng");
  private static final int z = x.f("pgap");
  
  public static a.a a(m paramm)
  {
    int i1 = paramm.d() + paramm.n();
    int i2 = paramm.n();
    int i3 = i2 >> 24 & 0xFF;
    if ((i3 != 169) && (i3 != 65533)) {}
    try
    {
      if (i2 == m)
      {
        localObject1 = b(paramm);
        return localObject1;
      }
      if (i2 == o)
      {
        localObject1 = b(i2, "TPOS", paramm);
        return localObject1;
      }
      if (i2 == p)
      {
        localObject1 = b(i2, "TRCK", paramm);
        return localObject1;
      }
      if (i2 == q)
      {
        localObject1 = a(i2, "TBPM", paramm, true, false);
        return localObject1;
      }
      if (i2 == r)
      {
        localObject1 = a(i2, "TCMP", paramm, true, true);
        return localObject1;
      }
      if (i2 == l)
      {
        localObject1 = c(paramm);
        return localObject1;
      }
      if (i2 == s)
      {
        localObject1 = a(i2, "TPE2", paramm);
        return localObject1;
      }
      if (i2 == t)
      {
        localObject1 = a(i2, "TSOT", paramm);
        return localObject1;
      }
      if (i2 == u)
      {
        localObject1 = a(i2, "TSO2", paramm);
        return localObject1;
      }
      if (i2 == v)
      {
        localObject1 = a(i2, "TSOA", paramm);
        return localObject1;
      }
      if (i2 == w)
      {
        localObject1 = a(i2, "TSOP", paramm);
        return localObject1;
      }
      if (i2 == x)
      {
        localObject1 = a(i2, "TSOC", paramm);
        return localObject1;
      }
      if (i2 == y)
      {
        localObject1 = a(i2, "ITUNESADVISORY", paramm, false, false);
        return localObject1;
      }
      if (i2 == z)
      {
        localObject1 = a(i2, "ITUNESGAPLESS", paramm, false, true);
        return localObject1;
      }
      if (i2 == A)
      {
        localObject1 = a(i2, "TVSHOWSORT", paramm);
        return localObject1;
      }
      if (i2 == B)
      {
        localObject1 = a(i2, "TVSHOW", paramm);
        return localObject1;
      }
      if (i2 == C)
      {
        localObject1 = a(paramm, i1);
        return localObject1;
        i3 = 0xFFFFFF & i2;
        if (i3 == c)
        {
          localObject1 = a(i2, paramm);
          return localObject1;
        }
        if ((i3 == a) || (i3 == b)) {
          break label765;
        }
        if ((i3 == h) || (i3 == i)) {
          break label747;
        }
        if (i3 == d)
        {
          localObject1 = a(i2, "TDRC", paramm);
          return localObject1;
        }
        if (i3 == e)
        {
          localObject1 = a(i2, "TPE1", paramm);
          return localObject1;
        }
        if (i3 == f)
        {
          localObject1 = a(i2, "TSSE", paramm);
          return localObject1;
        }
        if (i3 == g)
        {
          localObject1 = a(i2, "TALB", paramm);
          return localObject1;
        }
        if (i3 == j)
        {
          localObject1 = a(i2, "USLT", paramm);
          return localObject1;
        }
        if (i3 == k)
        {
          localObject1 = a(i2, "TCON", paramm);
          return localObject1;
        }
        if (i3 == n)
        {
          localObject1 = a(i2, "TIT1", paramm);
          return localObject1;
        }
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Skipped unknown metadata entry: ");
      ((StringBuilder)localObject1).append(a.c(i2));
      Log.d("MetadataUtil", ((StringBuilder)localObject1).toString());
      return null;
      label747:
      localObject1 = a(i2, "TCOM", paramm);
      return localObject1;
      label765:
      localObject1 = a(i2, "TIT2", paramm);
      return localObject1;
    }
    finally
    {
      paramm.c(i1);
    }
  }
  
  private static e a(int paramInt, m paramm)
  {
    int i1 = paramm.n();
    if (paramm.n() == a.aF)
    {
      paramm.d(8);
      paramm = paramm.f(i1 - 16);
      return new e("und", paramm, paramm);
    }
    paramm = new StringBuilder();
    paramm.append("Failed to parse comment attribute: ");
    paramm.append(a.c(paramInt));
    Log.w("MetadataUtil", paramm.toString());
    return null;
  }
  
  private static h a(int paramInt, String paramString, m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = d(paramm);
    int i1 = i2;
    if (paramBoolean2) {
      i1 = Math.min(1, i2);
    }
    if (i1 >= 0)
    {
      if (paramBoolean1) {
        return new j(paramString, null, Integer.toString(i1));
      }
      return new e("und", paramString, Integer.toString(i1));
    }
    paramString = new StringBuilder();
    paramString.append("Failed to parse uint8 attribute: ");
    paramString.append(a.c(paramInt));
    Log.w("MetadataUtil", paramString.toString());
    return null;
  }
  
  private static h a(m paramm, int paramInt)
  {
    String str2 = null;
    String str1 = str2;
    int i2 = -1;
    int i1 = -1;
    while (paramm.d() < paramInt)
    {
      int i4 = paramm.d();
      int i3 = paramm.n();
      int i5 = paramm.n();
      paramm.d(4);
      if (i5 == a.aD)
      {
        str2 = paramm.f(i3 - 12);
      }
      else if (i5 == a.aE)
      {
        str1 = paramm.f(i3 - 12);
      }
      else
      {
        if (i5 == a.aF)
        {
          i2 = i4;
          i1 = i3;
        }
        paramm.d(i3 - 12);
      }
    }
    if (("com.apple.iTunes".equals(str2)) && ("iTunSMPB".equals(str1)))
    {
      if (i2 == -1) {
        return null;
      }
      paramm.c(i2);
      paramm.d(16);
      return new e("und", str1, paramm.f(i1 - 16));
    }
    return null;
  }
  
  private static j a(int paramInt, String paramString, m paramm)
  {
    int i1 = paramm.n();
    if (paramm.n() == a.aF)
    {
      paramm.d(8);
      return new j(paramString, null, paramm.f(i1 - 16));
    }
    paramString = new StringBuilder();
    paramString.append("Failed to parse text attribute: ");
    paramString.append(a.c(paramInt));
    Log.w("MetadataUtil", paramString.toString());
    return null;
  }
  
  private static j b(int paramInt, String paramString, m paramm)
  {
    int i1 = paramm.n();
    if ((paramm.n() == a.aF) && (i1 >= 22))
    {
      paramm.d(10);
      i1 = paramm.h();
      if (i1 > 0)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i1);
        localObject = ((StringBuilder)localObject).toString();
        paramInt = paramm.h();
        paramm = (m)localObject;
        if (paramInt > 0)
        {
          paramm = new StringBuilder();
          paramm.append((String)localObject);
          paramm.append("/");
          paramm.append(paramInt);
          paramm = paramm.toString();
        }
        return new j(paramString, null, paramm);
      }
    }
    paramString = new StringBuilder();
    paramString.append("Failed to parse index/count attribute: ");
    paramString.append(a.c(paramInt));
    Log.w("MetadataUtil", paramString.toString());
    return null;
  }
  
  private static j b(m paramm)
  {
    int i1 = d(paramm);
    if (i1 > 0)
    {
      paramm = D;
      if (i1 <= paramm.length)
      {
        paramm = paramm[(i1 - 1)];
        break label30;
      }
    }
    paramm = null;
    label30:
    if (paramm != null) {
      return new j("TCON", null, paramm);
    }
    Log.w("MetadataUtil", "Failed to parse standard genre code");
    return null;
  }
  
  private static com.tencent.luggage.wxa.x.a c(m paramm)
  {
    int i1 = paramm.n();
    if (paramm.n() == a.aF)
    {
      int i2 = a.b(paramm.n());
      String str;
      if (i2 == 13) {
        str = "image/jpeg";
      } else if (i2 == 14) {
        str = "image/png";
      } else {
        str = null;
      }
      if (str == null)
      {
        paramm = new StringBuilder();
        paramm.append("Unrecognized cover art flags: ");
        paramm.append(i2);
        Log.w("MetadataUtil", paramm.toString());
        return null;
      }
      paramm.d(4);
      byte[] arrayOfByte = new byte[i1 - 16];
      paramm.a(arrayOfByte, 0, arrayOfByte.length);
      return new com.tencent.luggage.wxa.x.a(str, null, 3, arrayOfByte);
    }
    Log.w("MetadataUtil", "Failed to parse cover art attribute");
    return null;
  }
  
  private static int d(m paramm)
  {
    paramm.d(4);
    if (paramm.n() == a.aF)
    {
      paramm.d(8);
      return paramm.g();
    }
    Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.f
 * JD-Core Version:    0.7.0.1
 */