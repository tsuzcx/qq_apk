package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class eq
  implements Parcelable, TencentLocation
{
  public static final eq a = new eq(-1);
  public em b;
  public String c;
  private int d;
  private int e;
  private String f;
  private ek g;
  private final Bundle h = new Bundle();
  private String i = "network";
  private String j = "network";
  private Location k;
  private final long l;
  private long m;
  private int n;
  private int o;
  
  static
  {
    new Parcelable.Creator() {};
  }
  
  private eq(int paramInt)
  {
    this.d = paramInt;
    this.l = SystemClock.elapsedRealtime();
    this.m = System.currentTimeMillis();
  }
  
  /* Error */
  private eq(String paramString)
    throws JSONException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 49	android/os/Bundle
    //   8: dup
    //   9: invokespecial 50	android/os/Bundle:<init>	()V
    //   12: putfield 52	c/t/m/g/eq:h	Landroid/os/Bundle;
    //   15: aload_0
    //   16: ldc 54
    //   18: putfield 56	c/t/m/g/eq:i	Ljava/lang/String;
    //   21: aload_0
    //   22: ldc 54
    //   24: putfield 58	c/t/m/g/eq:j	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 66	android/os/SystemClock:elapsedRealtime	()J
    //   31: putfield 68	c/t/m/g/eq:l	J
    //   34: aload_0
    //   35: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   38: putfield 75	c/t/m/g/eq:m	J
    //   41: new 83	org/json/JSONObject
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 85	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_0
    //   51: new 87	c/t/m/g/em
    //   54: dup
    //   55: aload_1
    //   56: ldc 89
    //   58: invokevirtual 93	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: invokespecial 96	c/t/m/g/em:<init>	(Lorg/json/JSONObject;)V
    //   64: putfield 98	c/t/m/g/eq:b	Lc/t/m/g/em;
    //   67: aload_0
    //   68: aload_1
    //   69: ldc 100
    //   71: invokevirtual 104	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield 106	c/t/m/g/eq:f	Ljava/lang/String;
    //   77: aload_0
    //   78: aload_1
    //   79: ldc 108
    //   81: iconst_0
    //   82: invokevirtual 112	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   85: putfield 114	c/t/m/g/eq:e	I
    //   88: aload_0
    //   89: aload_1
    //   90: ldc 116
    //   92: ldc 118
    //   94: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: putfield 123	c/t/m/g/eq:c	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 123	c/t/m/g/eq:c	Ljava/lang/String;
    //   104: ifnull +49 -> 153
    //   107: aload_0
    //   108: getfield 123	c/t/m/g/eq:c	Ljava/lang/String;
    //   111: ldc 118
    //   113: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +37 -> 153
    //   119: aload_0
    //   120: aload_1
    //   121: ldc 131
    //   123: invokevirtual 135	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   126: putfield 75	c/t/m/g/eq:m	J
    //   129: ldc 137
    //   131: new 139	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 141
    //   137: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 75	c/t/m/g/eq:m	J
    //   144: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 155	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 114	c/t/m/g/eq:e	I
    //   157: ifle +19 -> 176
    //   160: aload_0
    //   161: ldc 157
    //   163: putfield 58	c/t/m/g/eq:j	Ljava/lang/String;
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 159	c/t/m/g/eq:o	I
    //   171: iconst_1
    //   172: iadd
    //   173: putfield 159	c/t/m/g/eq:o	I
    //   176: aload_1
    //   177: ldc 161
    //   179: invokevirtual 104	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_2
    //   183: aload_2
    //   184: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +40 -> 227
    //   190: aload_0
    //   191: getfield 52	c/t/m/g/eq:h	Landroid/os/Bundle;
    //   194: ldc 161
    //   196: aload_2
    //   197: ldc 169
    //   199: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   202: iconst_0
    //   203: aaload
    //   204: invokestatic 179	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   207: invokevirtual 183	java/lang/Integer:intValue	()I
    //   210: invokevirtual 187	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   213: ldc 137
    //   215: ldc 189
    //   217: aload_2
    //   218: invokestatic 192	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 155	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_1
    //   228: ldc 197
    //   230: invokevirtual 200	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   233: astore_2
    //   234: aload_2
    //   235: ifnull +75 -> 310
    //   238: aload_0
    //   239: new 202	c/t/m/g/ek
    //   242: dup
    //   243: aload_2
    //   244: invokespecial 203	c/t/m/g/ek:<init>	(Lorg/json/JSONObject;)V
    //   247: putfield 205	c/t/m/g/eq:g	Lc/t/m/g/ek;
    //   250: aload_0
    //   251: getfield 205	c/t/m/g/eq:g	Lc/t/m/g/ek;
    //   254: ifnull +30 -> 284
    //   257: aload_0
    //   258: getfield 205	c/t/m/g/eq:g	Lc/t/m/g/ek;
    //   261: getfield 208	c/t/m/g/ek:c	Lc/t/m/g/eo;
    //   264: ifnull +20 -> 284
    //   267: aload_0
    //   268: getfield 52	c/t/m/g/eq:h	Landroid/os/Bundle;
    //   271: aload_0
    //   272: getfield 205	c/t/m/g/eq:g	Lc/t/m/g/ek;
    //   275: getfield 208	c/t/m/g/ek:c	Lc/t/m/g/eo;
    //   278: getfield 212	c/t/m/g/eo:l	Landroid/os/Bundle;
    //   281: invokevirtual 216	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   284: return
    //   285: astore_1
    //   286: aload_1
    //   287: athrow
    //   288: astore_2
    //   289: ldc 137
    //   291: ldc 218
    //   293: invokestatic 155	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -69 -> 227
    //   299: astore_1
    //   300: ldc 137
    //   302: ldc 220
    //   304: aload_1
    //   305: invokestatic 223	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload_1
    //   309: athrow
    //   310: aload_1
    //   311: ldc 225
    //   313: invokevirtual 200	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   316: astore_1
    //   317: aload_1
    //   318: ifnull -68 -> 250
    //   321: aload_1
    //   322: ldc 227
    //   324: invokevirtual 231	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   327: ifeq -77 -> 250
    //   330: aload_0
    //   331: new 202	c/t/m/g/ek
    //   334: dup
    //   335: aload_1
    //   336: ldc 227
    //   338: invokevirtual 200	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   341: invokespecial 203	c/t/m/g/ek:<init>	(Lorg/json/JSONObject;)V
    //   344: putfield 205	c/t/m/g/eq:g	Lc/t/m/g/ek;
    //   347: goto -97 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	eq
    //   0	350	1	paramString	String
    //   182	62	2	localObject	Object
    //   288	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	67	285	org/json/JSONException
    //   176	227	288	java/lang/Exception
    //   238	250	299	org/json/JSONException
  }
  
  public static eq a(eq parameq, int paramInt)
  {
    parameq.n = paramInt;
    return parameq;
  }
  
  public static eq a(eq parameq, ee paramee, boolean paramBoolean)
  {
    int i3;
    int i1;
    if ((parameq != null) && (paramee != null) && (parameq.f != null))
    {
      String str = parameq.f;
      int i2 = 0;
      i3 = paramee.f;
      i1 = i2;
      if (str != null)
      {
        i1 = i2;
        if (str.split(",").length > 1) {
          i1 = Integer.parseInt(str.split(",")[1]);
        }
      }
      paramee = parameq.b;
      if (paramee == null) {}
    }
    try
    {
      paramee.d = ((float)e.r(paramee.d, i1, i3));
      label91:
      if (paramBoolean) {
        parameq.j = "fake";
      }
      if (!parameq.j.equals("fake"))
      {
        if (paramee.d > 150.0D) {
          break label134;
        }
        parameq.j = "wifi";
      }
      label134:
      do
      {
        do
        {
          return parameq;
          parameq.j = "cell";
          return parameq;
        } while (parameq == null);
        if (paramBoolean) {
          parameq.j = "fake";
        }
      } while (parameq.j.equals("fake"));
      if (parameq.getAccuracy() <= 150.0D)
      {
        parameq.j = "wifi";
        return parameq;
      }
      parameq.j = "cell";
      return parameq;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label91;
    }
  }
  
  public static void a(eq parameq)
    throws JSONException
  {
    if (parameq == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final eq a(int paramInt)
  {
    this.o += paramInt;
    return this;
  }
  
  public final void a(Location paramLocation)
  {
    if (this.b != null)
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      this.b.a = d2;
      this.b.b = d1;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (this.d == 5) {
      return this.h.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (this.g != null) {
      return Integer.valueOf(this.g.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (this.k == null) {
      return 0.0F;
    }
    return this.k.getBearing();
  }
  
  public final String getCity()
  {
    if (this.g != null) {
      return this.g.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (this.g != null) {
      return this.g.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return this.n;
  }
  
  public final double getDirection()
  {
    return this.h.getDouble("direction");
  }
  
  public final String getDistrict()
  {
    if (this.g != null) {
      return this.g.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return this.l;
  }
  
  public final Bundle getExtra()
  {
    return this.h;
  }
  
  public final int getFakeReason()
  {
    return this.o;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {
      return this.b.b;
    }
    return 0.0D;
  }
  
  public final String getMotion()
  {
    return this.h.getString("motion");
  }
  
  public final String getName()
  {
    if (this.d == 5) {
      return this.h.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (this.g != null) {
      return this.g.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.g != null) {
      return new ArrayList(this.g.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.i;
  }
  
  public final String getProvince()
  {
    if (this.g != null) {
      return this.g.c.e;
    }
    return "";
  }
  
  public final String getRawData()
  {
    return this.h.getString("wifi_data");
  }
  
  public final int getRssi()
  {
    if (this.k == null) {}
    Bundle localBundle;
    do
    {
      return 0;
      localBundle = this.k.getExtras();
    } while (localBundle == null);
    return localBundle.getInt("rssi", 0);
  }
  
  public final String getSourceProvider()
  {
    return this.j;
  }
  
  public final float getSpeed()
  {
    if (this.k == null) {
      return 0.0F;
    }
    return this.k.getSpeed();
  }
  
  public final String getStreet()
  {
    if (this.g != null) {
      return this.g.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (this.g != null) {
      return this.g.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.m;
  }
  
  public final String getTown()
  {
    if (this.g != null) {
      return this.g.c.h;
    }
    return "";
  }
  
  public final String getVerifyKey()
  {
    return this.c;
  }
  
  public final String getVillage()
  {
    if (this.g != null) {
      return this.g.c.i;
    }
    return "";
  }
  
  public final int isMockGps()
  {
    return this.e;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.d).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (this.g != null) {}
    for (String str = this.g.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(this.m);
      paramParcel.writeBundle(this.h);
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public eq b;
    public int c;
    public String d = "network";
    public String e = "network";
    private Location f;
    
    public final a a(Location paramLocation)
    {
      this.f = new Location(paramLocation);
      return this;
    }
    
    public final eq a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          eq localeq1 = new eq(this.a, (byte)0);
          eq.a(eq.c(eq.b(eq.b(localeq1, this.c), this.d), this.e), this.f);
          TencentExtraKeys.setRawGps(localeq1, this.f);
          return localeq1;
        }
        catch (JSONException localJSONException)
        {
          ev.a("TxLocation", "build: ", localJSONException);
          return eq.a;
        }
        eq localeq2 = eq.c(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.eq
 * JD-Core Version:    0.7.0.1
 */