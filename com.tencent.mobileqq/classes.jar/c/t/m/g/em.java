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

public final class em
  implements Parcelable, TencentLocation
{
  public static final em a = new em(-1);
  private ei b;
  private int c;
  private int d;
  private String e;
  private String f;
  private eg g;
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
  
  private em(int paramInt)
  {
    this.c = paramInt;
    this.l = SystemClock.elapsedRealtime();
    this.m = System.currentTimeMillis();
  }
  
  /* Error */
  private em(String paramString)
    throws JSONException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 49	android/os/Bundle
    //   8: dup
    //   9: invokespecial 50	android/os/Bundle:<init>	()V
    //   12: putfield 52	c/t/m/g/em:h	Landroid/os/Bundle;
    //   15: aload_0
    //   16: ldc 54
    //   18: putfield 56	c/t/m/g/em:i	Ljava/lang/String;
    //   21: aload_0
    //   22: ldc 54
    //   24: putfield 58	c/t/m/g/em:j	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 66	android/os/SystemClock:elapsedRealtime	()J
    //   31: putfield 68	c/t/m/g/em:l	J
    //   34: aload_0
    //   35: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   38: putfield 75	c/t/m/g/em:m	J
    //   41: new 83	org/json/JSONObject
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 85	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_0
    //   51: new 87	c/t/m/g/ei
    //   54: dup
    //   55: aload_1
    //   56: ldc 89
    //   58: invokevirtual 93	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: invokespecial 96	c/t/m/g/ei:<init>	(Lorg/json/JSONObject;)V
    //   64: putfield 98	c/t/m/g/em:b	Lc/t/m/g/ei;
    //   67: aload_0
    //   68: aload_1
    //   69: ldc 100
    //   71: invokevirtual 104	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield 106	c/t/m/g/em:f	Ljava/lang/String;
    //   77: aload_0
    //   78: aload_1
    //   79: ldc 108
    //   81: iconst_0
    //   82: invokevirtual 112	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   85: putfield 114	c/t/m/g/em:d	I
    //   88: aload_0
    //   89: aload_1
    //   90: ldc 116
    //   92: ldc 118
    //   94: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: putfield 123	c/t/m/g/em:e	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 123	c/t/m/g/em:e	Ljava/lang/String;
    //   104: ifnull +49 -> 153
    //   107: aload_0
    //   108: getfield 123	c/t/m/g/em:e	Ljava/lang/String;
    //   111: ldc 118
    //   113: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +37 -> 153
    //   119: aload_0
    //   120: aload_1
    //   121: ldc 131
    //   123: invokevirtual 135	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   126: putfield 75	c/t/m/g/em:m	J
    //   129: ldc 137
    //   131: new 139	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 141
    //   137: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 75	c/t/m/g/em:m	J
    //   144: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 155	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 114	c/t/m/g/em:d	I
    //   157: ifle +19 -> 176
    //   160: aload_0
    //   161: ldc 157
    //   163: putfield 58	c/t/m/g/em:j	Ljava/lang/String;
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 159	c/t/m/g/em:o	I
    //   171: iconst_1
    //   172: iadd
    //   173: putfield 159	c/t/m/g/em:o	I
    //   176: aload_1
    //   177: ldc 161
    //   179: invokevirtual 104	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_2
    //   183: aload_2
    //   184: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +47 -> 234
    //   190: aload_0
    //   191: getfield 52	c/t/m/g/em:h	Landroid/os/Bundle;
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
    //   215: new 139	java/lang/StringBuilder
    //   218: dup
    //   219: ldc 189
    //   221: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload_2
    //   225: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 155	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_1
    //   235: ldc 194
    //   237: invokevirtual 197	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   240: astore_2
    //   241: aload_2
    //   242: ifnull +75 -> 317
    //   245: aload_0
    //   246: new 199	c/t/m/g/eg
    //   249: dup
    //   250: aload_2
    //   251: invokespecial 200	c/t/m/g/eg:<init>	(Lorg/json/JSONObject;)V
    //   254: putfield 202	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   257: aload_0
    //   258: getfield 202	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   261: ifnull +30 -> 291
    //   264: aload_0
    //   265: getfield 202	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   268: getfield 205	c/t/m/g/eg:c	Lc/t/m/g/ek;
    //   271: ifnull +20 -> 291
    //   274: aload_0
    //   275: getfield 52	c/t/m/g/em:h	Landroid/os/Bundle;
    //   278: aload_0
    //   279: getfield 202	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   282: getfield 205	c/t/m/g/eg:c	Lc/t/m/g/ek;
    //   285: getfield 209	c/t/m/g/ek:l	Landroid/os/Bundle;
    //   288: invokevirtual 213	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   291: return
    //   292: astore_1
    //   293: aload_1
    //   294: athrow
    //   295: astore_2
    //   296: ldc 137
    //   298: ldc 215
    //   300: invokestatic 155	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: goto -69 -> 234
    //   306: astore_1
    //   307: ldc 137
    //   309: ldc 217
    //   311: aload_1
    //   312: invokestatic 220	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload_1
    //   316: athrow
    //   317: aload_1
    //   318: ldc 222
    //   320: invokevirtual 197	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   323: astore_1
    //   324: aload_1
    //   325: ifnull -68 -> 257
    //   328: aload_1
    //   329: ldc 224
    //   331: invokevirtual 228	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   334: ifeq -77 -> 257
    //   337: aload_0
    //   338: new 199	c/t/m/g/eg
    //   341: dup
    //   342: aload_1
    //   343: ldc 224
    //   345: invokevirtual 197	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   348: invokespecial 200	c/t/m/g/eg:<init>	(Lorg/json/JSONObject;)V
    //   351: putfield 202	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   354: goto -97 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	em
    //   0	357	1	paramString	String
    //   182	69	2	localObject	Object
    //   295	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	67	292	org/json/JSONException
    //   176	234	295	java/lang/Exception
    //   245	257	306	org/json/JSONException
  }
  
  public static em a(em paramem, int paramInt)
  {
    paramem.n = paramInt;
    return paramem;
  }
  
  public static em a(em paramem, ea paramea, boolean paramBoolean)
  {
    int i3;
    int i1;
    if ((paramem != null) && (paramea != null) && (paramem.f != null))
    {
      String str = paramem.f;
      int i2 = 0;
      i3 = paramea.f;
      i1 = i2;
      if (str != null)
      {
        i1 = i2;
        if (str.split(",").length > 1) {
          i1 = Integer.parseInt(str.split(",")[1]);
        }
      }
      paramea = paramem.b;
      if (paramea == null) {}
    }
    try
    {
      paramea.d = ((float)e.r(paramea.d, i1, i3));
      label91:
      if (paramBoolean) {
        paramem.j = "fake";
      }
      if (!paramem.j.equals("fake"))
      {
        if (paramea.d > 150.0D) {
          break label134;
        }
        paramem.j = "wifi";
      }
      label134:
      do
      {
        do
        {
          return paramem;
          paramem.j = "cell";
          return paramem;
        } while (paramem == null);
        if (paramBoolean) {
          paramem.j = "fake";
        }
      } while (paramem.j.equals("fake"));
      if (paramem.getAccuracy() <= 150.0D)
      {
        paramem.j = "wifi";
        return paramem;
      }
      paramem.j = "cell";
      return paramem;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label91;
    }
  }
  
  public static void a(em paramem)
    throws JSONException
  {
    if (paramem == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final em a(int paramInt)
  {
    this.o += paramInt;
    return this;
  }
  
  public final void a()
  {
    this.e = null;
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    this.b.a = (Math.round(paramDouble1 * 1000000.0D) / 1000000.0D);
    this.b.b = (Math.round(paramDouble2 * 1000000.0D) / 1000000.0D);
  }
  
  public final void a(Location paramLocation)
  {
    if ((paramLocation != null) && (this.b != null))
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
    if (this.c == 5) {
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
    if (this.h != null) {
      return this.h.getDouble("direction");
    }
    return (0.0D / 0.0D);
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
    if (this.h != null) {
      return this.h.getString("motion");
    }
    return "unknown";
  }
  
  public final String getName()
  {
    if (this.c == 5) {
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
    if (this.h != null) {
      return this.h.getString("wifi_data");
    }
    return null;
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
    return this.e;
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
    return this.d;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.c).append(",");
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
    paramParcel.writeInt(this.c);
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
    public em b;
    public int c;
    public String d = "network";
    public String e = "network";
    private Location f;
    
    public final a a(Location paramLocation)
    {
      this.f = new Location(paramLocation);
      return this;
    }
    
    public final em a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          em localem1 = new em(this.a, (byte)0);
          em.a(em.c(em.b(em.b(localem1, this.c), this.d), this.e), this.f);
          TencentExtraKeys.setRawGps(localem1, this.f);
          return localem1;
        }
        catch (JSONException localJSONException)
        {
          f.a.a("TxLocation", "build: ", localJSONException);
          return em.a;
        }
        em localem2 = em.c(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.em
 * JD-Core Version:    0.7.0.1
 */